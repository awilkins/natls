package org.amshove.natparse.parsing;

import org.amshove.natparse.lexing.LexerError;
import org.amshove.natparse.natural.*;
import org.amshove.natparse.natural.project.NaturalProject;
import org.amshove.testhelpers.ProjectName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class IncludeCopyCodeParsingShould extends ParserIntegrationTest
{
	@Test
	void notReportDiagnosticsForUnresolvedReferences(@ProjectName("copycodetests") NaturalProject project)
	{
		assertParsesWithoutAnyDiagnostics(project.findModule("LIBONE", "NODIAG"));
	}

	@Test
	void exportDeclaredSubroutinesUpToTheIncludingModule(@ProjectName("copycodetests") NaturalProject project)
	{
		var module = assertParsesWithoutAnyDiagnostics(project.findModule("LIBONE", "USEDECL"));
		assertThat(module.referencableNodes()).anyMatch(n -> n instanceof ISubroutineNode subroutine && subroutine.declaration().symbolName().equals("INSIDE-CCODE"));
	}

	@Test
	void relocateDiagnosticsFromCopyCodesToTheirIncludeStatement(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "SUBPROG"), ISubprogram.class);
		assertThat(subprogram.diagnostics()).hasSize(2);
		for (var diagnostic : subprogram.diagnostics())
		{
			assertThat(diagnostic.line()).as("Line mismatch for: " + diagnostic.message()).isEqualTo(6);
			assertThat(diagnostic.offsetInLine()).isEqualTo(8);
		}
	}

	@Test
	void relocateDiagnosticsFromDeeplyNestedCopyCodesToTheirIncludeStatement(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "DANEST"), ISubprogram.class);
		assertThat(subprogram.diagnostics()).hasSize(2);
		for (var diagnostic : subprogram.diagnostics())
		{
			assertThat(diagnostic.line()).as("Line mismatch for: " + diagnostic.message()).isEqualTo(8);
			assertThat(diagnostic.offsetInLine()).isEqualTo(8);
		}
	}

	@Test
	void notReportDiagnosticsForCopycodeParameterThatAreQualified(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "USEQVAR"), ISubprogram.class);
		assertThat(subprogram.diagnostics()).hasSize(0);
	}

	@Test
	void relocateDiagnosticLocationsForCopyCodeNodesThatAreNestedMultipleTimes(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "SUBPROG2"), ISubprogram.class);
		assertThat(subprogram.diagnostics()).hasSize(2);
		for (var diagnostic : subprogram.diagnostics())
		{
			assertThat(diagnostic.line()).as("Line mismatch for: " + diagnostic.message()).isEqualTo(6);
			assertThat(diagnostic.offsetInLine()).isEqualTo(8);
		}
	}

	@Test
	void correctlyIncludeStringLiterals(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "INCLSTR"), ISubprogram.class);
		var write = (WriteNode) subprogram.body().statements().first();
		assertThat(((ILiteralNode) write.descendants().last()).token().source()).isEqualTo("\"\"\"Text\"\"\"");
	}

	@Test
	void correctlyIncludeStringConcatLiterals(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "INCLMSTR"), ISubprogram.class);
		var write = (IWriteNode) subprogram.body().statements().first();
		assertThat(((VariableReferenceNode) write.descendants().get(write.descendants().size() - 2)).token().source()).isEqualTo("#VAR1");
		assertThat(((VariableReferenceNode) write.descendants().last()).token().source()).isEqualTo("#VAR2");
	}

	@Test
	void correctlyIncludeStringLiteralsOnNestedLevels(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "WRITNEST"), ISubprogram.class);
		var write = (IWriteNode) subprogram.body().statements().first();
		assertThat(write.descendants()).as("WRITE statement should only have 2 nodes. The WRITE keyword and the string operand").hasSize(2);
		assertThat(((ILiteralNode) write.descendants().last()).token().source()).isEqualTo("\"Text\"");
	}

	@Test
	void raiseADiagnosticForCyclomaticCopycodes(@ProjectName("copycodetests") NaturalProject project)
	{
		var subprogram = assertFileParsesAs(project.findModule("LIBONE", "INCLREC"), ISubprogram.class);
		assertThat(subprogram.diagnostics()).hasSize(1);
		assertThat(subprogram.diagnostics().first().id()).isEqualTo(LexerError.CYCLOMATIC_INCLUDE.id());
		assertThat(subprogram.diagnostics().first().message()).isEqualTo("Cyclomatic include found. RECCC is recursively included multiple times");
	}

	@Test
	void correctlyParseStatementsWhenTheHeadBodyAndTailAreInDifferentCopycodes(@ProjectName("copycodetests") NaturalProject project)
	{
		var program = assertFileParsesAs(project.findModule("LIBTWO", "PROG"), IProgram.class);
		assertThat(program.body().statements()).hasSize(1);
		assertThat(program.body().statements().first()).isInstanceOf(IIfStatementNode.class);
	}
}
