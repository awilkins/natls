package org.amshove.natparse.lexing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LexerForSystemVariablesShould extends AbstractLexerTest
{
	@Test
	void lexTimX()
	{
		assertTokens("*TIMX", token(SyntaxKind.TIMX, "*TIMX"));
	}

	@Test
	void lexDatX()
	{
		assertTokens("*DATX", token(SyntaxKind.DATX, "*DATX"));
	}

	@Test
	void lexDatN()
	{
		assertTokens("*DATN", token(SyntaxKind.DATN, "*DATN"));
	}

	@Test
	void lexLanguage()
	{
		assertTokens("*LANGUAGE", token(SyntaxKind.LANGUAGE, "*LANGUAGE"));
	}

	@Test
	void lexProgram()
	{
		assertTokens("*PROGRAM", token(SyntaxKind.PROGRAM, "*PROGRAM"));
	}

	@Test
	void lexUser()
	{
		assertTokens("*USER", token(SyntaxKind.USER, "*USER"));
	}

	@Test
	void lexLibraryId()
	{
		assertTokens("*LIBRARY-ID", token(SyntaxKind.LIBRARY_ID, "*LIBRARY-ID"));
	}

	@Test
	void lexLineX()
	{
		assertTokens("*LINEX", token(SyntaxKind.LINEX, "*LINEX"));
	}

	@Test
	void lexCurrentUnit()
	{
		assertTokens("*CURRENT-UNIT", token(SyntaxKind.CURRENT_UNIT, "*CURRENT-UNIT"));
	}

	@Test
	void lexOcc()
	{
		assertTokens("*OCC", token(SyntaxKind.OCC, "*OCC"));
	}

	@Test
	void lexErrorNr()
	{
		assertTokens("*ERROR-NR", token(SyntaxKind.ERROR_NR, "*ERROR-NR"));
	}

	@Test
	void lexErrorLine()
	{
		assertTokens("*ERROR-LINE", token(SyntaxKind.ERROR_LINE, "*ERROR-LINE"));
	}

	@Test
	void lexLine()
	{
		assertTokens("*LINE", token(SyntaxKind.LINE, "*LINE"));
	}

	@Test
	void lexTrim()
	{
		assertTokens("*TRIM", token(SyntaxKind.TRIM, "*TRIM"));
	}

	@Test
	void lexMinval()
	{
		assertTokens("*MINVAL", token(SyntaxKind.MINVAL, "*MINVAL"));
	}

	@Test
	void lexMaxval()
	{
		assertTokens("*MAXVAL", token(SyntaxKind.MAXVAL, "*MAXVAL"));
	}

	@Test
	void lexCursLine()
	{
		assertTokens("*CURS-LINE", token(SyntaxKind.CURS_LINE, "*CURS-LINE"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "PF1", "PF2", "PF3", "PF9", "PF12", "PF15" })
	void lexPfKey(String pfKey)
	{
		assertTokens(pfKey, token(SyntaxKind.PF, pfKey));
	}

	@Test
	void lexPfKey()
	{
		assertTokens("*PF-KEY", token(SyntaxKind.PF_KEY, "*PF-KEY"));
	}
}
