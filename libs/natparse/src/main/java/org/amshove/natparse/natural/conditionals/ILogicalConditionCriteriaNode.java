package org.amshove.natparse.natural.conditionals;

import org.amshove.natparse.natural.ISyntaxNode;

public sealed interface ILogicalConditionCriteriaNode extends ISyntaxNode permits IChainedCriteriaNode, IExtendedRelationalCriteriaNode, IGroupedConditionCriteria, IRangedExtendedRelationalCriteriaNode, IRelationalCriteriaNode, IUnaryLogicalCriteriaNode
{
}
