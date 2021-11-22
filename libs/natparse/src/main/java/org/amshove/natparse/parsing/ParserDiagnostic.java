package org.amshove.natparse.parsing;

import org.amshove.natparse.IDiagnostic;
import org.amshove.natparse.IPosition;
import org.amshove.natparse.lexing.SyntaxKind;
import org.amshove.natparse.lexing.SyntaxToken;

import java.util.List;
import java.util.stream.Collectors;

public class ParserDiagnostic implements IDiagnostic
{
	private final String message;
	private final int offset;
	private final int offsetInLine;
	private final int line;
	private final int length;
	private final String id;

	private ParserDiagnostic(String message, int offset, int offsetInLine, int line, int length, ParserError error)
	{
		this.message = message;
		this.offset = offset;
		this.offsetInLine = offsetInLine;
		this.line = line;
		this.length = length;
		this.id = error.id();
	}

	public static ParserDiagnostic create(String message, int offset, int offsetInLine, int line, int length, ParserError error)
	{
		return new ParserDiagnostic(message, offset, offsetInLine, line, length, error);
	}

	public static ParserDiagnostic create(String message, IPosition position, ParserError error)
	{
		return new ParserDiagnostic(message, position.offset(), position.offsetInLine(), position.line(), position.length(), error);
	}

	public static ParserDiagnostic unexpectedToken(SyntaxKind expectedToken, SyntaxToken invalidToken)
	{
		return new ParserDiagnostic(
			"Unexpected token <%s>, expected <%s>".formatted(invalidToken.kind(), expectedToken),
			invalidToken.offset(),
			invalidToken.offsetInLine(),
			invalidToken.line(),
			invalidToken.length(),
			ParserError.UNEXPECTED_TOKEN
		);
	}

	public static ParserDiagnostic unexpectedToken(List<SyntaxKind> expectedTokenKinds, SyntaxToken invalidToken)
	{
		return new ParserDiagnostic(
			"Unexpected token <%s>, expected one of <%s>".formatted(invalidToken.kind(), expectedTokenKinds.stream().map(t -> t.toString()).collect(Collectors.joining(", "))),
			invalidToken.offset(),
			invalidToken.offsetInLine(),
			invalidToken.line(),
			invalidToken.length(),
			ParserError.UNEXPECTED_TOKEN
		);
	}

	@Override
	public String id()
	{
		return id;
	}

	@Override
	public int offset()
	{
		return offset;
	}

	@Override
	public int offsetInLine()
	{
		return offsetInLine;
	}

	@Override
	public int line()
	{
		return line;
	}

	@Override
	public int length()
	{
		return 0;
	}

	@Override
	public String message()
	{
		return message;
	}

	@Override
	public String toString()
	{
		return "ParserDiagnostic{" + id + ":" + message + '}';
	}
}
