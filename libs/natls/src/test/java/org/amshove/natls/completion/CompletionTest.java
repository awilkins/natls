package org.amshove.natls.completion;

import org.amshove.natls.testlifecycle.EmptyProjectTest;
import org.amshove.natls.testlifecycle.SourceWithCursor;
import org.eclipse.lsp4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public abstract class CompletionTest extends EmptyProjectTest
{
	protected CompletionAssertion assertCompletions(String libName, String fileName, String triggerChar, String sourceWithCursor)
	{
		try
		{
			var cursor = SourceWithCursor.fromSourceWithCursor(sourceWithCursor);
			var identifier = createOrSaveFile(libName, fileName, cursor);
			var params = new CompletionParams(identifier, cursor.toSinglePosition());
			var context = new CompletionContext(CompletionTriggerKind.Invoked);
			if (triggerChar != null)
			{
				context.setTriggerKind(CompletionTriggerKind.TriggerCharacter);
				context.setTriggerCharacter(triggerChar);
			}
			params.setContext(context);
			var completions = getContext().documentService().completion(params).get(1, TimeUnit.MINUTES).getLeft();

			var resolvedCompletes = new ArrayList<CompletionItem>();
			for (var unresolved : completions)
			{
				var resolved = getContext().languageService().resolveComplete(unresolved);
				resolvedCompletes.add(resolved);
			}
			return new CompletionAssertion(resolvedCompletes);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	protected CompletionAssertion assertCompletions(String libName, String fileName, String sourceWithCursor)
	{
		return assertCompletions(libName, fileName, null, sourceWithCursor);
	}

	record CompletionAssertion(List<CompletionItem> items)
	{
		CompletionAssertion assertContainsVariable(String label)
		{
			return assertContains(label, CompletionItemKind.Variable);
		}

		CompletionAssertion assertContainsVariableCompleting(String label, String completion)
		{
			return assertContainsCompleting(label, CompletionItemKind.Variable, completion);
		}

		CompletionAssertion assertContains(String label, CompletionItemKind kind)
		{
			assertThat(items)
				.as(
					"Expected completions to contain '%s (%s)' but did not. Completions of same kind:%n%s"
						.formatted(
							label,
							kind,
							items.stream().filter(i -> i.getKind().equals(kind)).map(Object::toString).collect(Collectors.joining("\n"))
						)
				)
				.anyMatch(ci -> ci.getLabel().equals(label) && ci.getKind().equals(kind));
			return this;
		}

		CompletionAssertion assertContainsCompleting(String label, CompletionItemKind kind, String completion)
		{
			assertThat(items)
				.as(
					"Expected completions to contain '%s (%s)' completing '%s' but did not. Completions of same kind:%n%s"
						.formatted(
							label,
							kind,
							completion,
							items.stream().filter(i -> i.getKind().equals(kind)).map(Object::toString).collect(Collectors.joining("\n"))
						)
				)
				.anyMatch(ci -> ci.getLabel().equals(label) && ci.getKind().equals(kind) && ci.getInsertText().equals(completion));
			return this;
		}

		CompletionAssertion assertDoesNotContainVariable(String label)
		{
			assertThat(items)
				.as(
					"Expected completions to not contain variable with label %s"
				)
				.noneMatch(ci -> ci.getKind().equals(CompletionItemKind.Variable) && ci.getLabel().equalsIgnoreCase(label));
			return this;
		}
	}
}
