package org.amshove.natparse.parsing;

import org.amshove.natparse.lexing.SyntaxToken;
import org.amshove.natparse.natural.IEjectNode;

import java.util.Optional;

class EjectNode extends StatementNode implements IEjectNode, ICanSetReportSpecification
{
	private SyntaxToken reportSpecification;

	@Override
	public Optional<SyntaxToken> reportSpecification()
	{
		return Optional.ofNullable(reportSpecification);
	}

	@Override
	public void setReportSpecification(SyntaxToken reportSpecification)
	{
		this.reportSpecification = reportSpecification;
	}
}
