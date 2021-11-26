package org.amshove.natparse.parsing;

import org.amshove.natparse.IPosition;
import org.amshove.natparse.ReadOnlyList;
import org.amshove.natparse.natural.ISyntaxNode;
import org.amshove.natparse.natural.ISyntaxTree;

import java.util.ArrayList;
import java.util.List;

class BaseSyntaxNode implements ISyntaxNode
{
	private List<BaseSyntaxNode> nodes = new ArrayList<>();
	private ISyntaxTree parent;
	private IPosition position;

	List<BaseSyntaxNode> getNodes()
	{
		return nodes;
	}

	public void setParent(ISyntaxTree parent)
	{
		this.parent = parent;
	}

	public ISyntaxTree parent()
	{
		return parent;
	}

	private ISyntaxNode getStart()
	{
		return nodes.get(0);
	}

	void addNode(BaseSyntaxNode node)
	{
		if(node == null)
		{
			return;
		}

		node.setParent(this);
		nodes.add(node);
		nodeAdded(node);
	}

	void setPosition(IPosition position)
	{
		this.position = position;
	}

	protected void nodeAdded(BaseSyntaxNode node)
	{

	}

	@Override
	public ReadOnlyList<? extends ISyntaxNode> nodes()
	{
		return ReadOnlyList.from(nodes); // TODO: Perf
	}

	@Override
	public IPosition position()
	{
		return getStart().position();
	}
}
