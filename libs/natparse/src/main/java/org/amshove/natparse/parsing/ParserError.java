package org.amshove.natparse.parsing;

public enum ParserError
{
	NO_DEFINE_DATA_FOUND("NPP001"),
	MISSING_END_DEFINE("NPP002"),
	UNEXPECTED_TOKEN("NPP003"),
	INVALID_DATA_TYPE_FOR_DYNAMIC_LENGTH("NPP004"),
	VARIABLE_LENGTH_MISSING("NPP005"),
	INITIAL_VALUE_TYPE_MISMATCH("NPP006"),
	EMPTY_INITIAL_VALUE("NPP007"),
	DYNAMIC_AND_FIXED_LENGTH("NPP008"),
	INVALID_ARRAY_BOUND("NPP009"),
	INCOMPLETE_ARRAY_DEFINITION("NPP010"),
	INDEPENDENT_VARIABLES_NAMING("NPP011"),
	INDEPENDENT_CANNOT_BE_GROUP("NPP012"),
	GROUP_CANNOT_BE_EMPTY("NPP013"),
	NO_TARGET_VARIABLE_FOR_REDEFINE_FOUND("NPP014"),
	REDEFINE_LENGTH_EXCEEDS_TARGET_LENGTH("NPP015")
	;

    private final String id;

	ParserError(String id)
	{
		this.id = id;
	}

	public String id()
	{
		return id;
	}
}
