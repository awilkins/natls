package org.amshove.natls.progress;

import org.eclipse.lsp4j.ProgressParams;
import org.eclipse.lsp4j.WorkDoneProgressBegin;
import org.eclipse.lsp4j.WorkDoneProgressCreateParams;
import org.eclipse.lsp4j.WorkDoneProgressEnd;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.LanguageClient;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

public class ProgressTasks
{
	private static final ConcurrentMap<String, IProgressMonitor> runningTasks = new ConcurrentHashMap<>();

	public static CompletableFuture<Void> startNew(String title, LanguageClient client, Consumer<IProgressMonitor> task)
	{
		var taskId = UUID.randomUUID().toString();
		var params = new WorkDoneProgressCreateParams();
		params.setToken(taskId);
		var progressMonitor = new WorkDoneProgressMonitor(taskId, client);
		runningTasks.put(taskId, progressMonitor);
		return client.createProgress(params).thenRunAsync(() -> {
			try
			{
				var begin = new WorkDoneProgressBegin();
				begin.setTitle(title);
				begin.setCancellable(true);
				begin.setMessage(title);
				client.notifyProgress(new ProgressParams(Either.forLeft(taskId), Either.forLeft(begin)));
				task.accept(progressMonitor);
			}
			catch (Exception e)
			{
				System.err.printf("Error in task %s: %s%n", taskId, e.getMessage());
			}
			finally
			{
				runningTasks.remove(taskId);
				var end = new WorkDoneProgressEnd();
				end.setMessage("Done");
				client.notifyProgress(new ProgressParams(Either.forLeft(taskId), Either.forLeft(end)));
			}
		});
	}
}
