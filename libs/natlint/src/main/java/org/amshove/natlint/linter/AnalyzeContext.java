package org.amshove.natlint.linter;

import org.amshove.natlint.api.IAnalyzeContext;
import org.amshove.natlint.api.IDiagnosticReporter;
import org.amshove.natlint.api.LinterDiagnostic;
import org.amshove.natlint.editorconfig.EditorConfig;
import org.amshove.natparse.DiagnosticSeverity;
import org.amshove.natparse.natural.INaturalModule;

class AnalyzeContext implements IAnalyzeContext
{
	private final INaturalModule module;
	private final IDiagnosticReporter diagnosticReporter;
	private EditorConfig editorConfig;

	AnalyzeContext(INaturalModule module, IDiagnosticReporter diagnosticReporter)
	{
		this.module = module;
		this.diagnosticReporter = diagnosticReporter;
	}

	void setEditorConfig(EditorConfig editorConfig)
	{
		this.editorConfig = editorConfig;
	}

	@Override
	public INaturalModule getModule()
	{
		return module;
	}

	@Override
	public void report(LinterDiagnostic diagnostic)
	{
		if (editorConfig == null)
		{
			diagnosticReporter.report(diagnostic);
			return;
		}

		var newSeverityName = editorConfig
			.getProperty(module.file().getPath(), "natls.%s.severity".formatted(diagnostic.id()), diagnostic.severity().toString());

		if (newSeverityName.equals("none"))
		{
			return;
		}

		var newSeverity = DiagnosticSeverity.fromString(newSeverityName);
		diagnosticReporter.report(diagnostic.withSeverity(newSeverity));
	}
}
