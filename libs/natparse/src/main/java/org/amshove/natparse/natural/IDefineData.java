package org.amshove.natparse.natural;

import org.amshove.natparse.ReadOnlyList;

public interface IDefineData extends ISyntaxNode
{
	ReadOnlyList<IUsingNode> localUsings();
	ReadOnlyList<IUsingNode> parameterUsings();
	ReadOnlyList<IUsingNode> globalUsings();
}
