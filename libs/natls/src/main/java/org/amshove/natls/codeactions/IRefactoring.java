package org.amshove.natls.codeactions;

import org.eclipse.lsp4j.CodeAction;

import java.util.List;

public interface IRefactoring
{
	boolean isApplicable(RefactoringContext context);
	List<CodeAction> createCodeAction(RefactoringContext context);
}
