package org.amshove.natparse.lexing;

public enum SyntaxKind
{
	LBRACKET,
	RBRACKET,
	LPAREN,
	RPAREN,
	EQUALS,
	COLON,
	COLON_EQUALS,
	DOT,
	CARET,
	COMMA,
	PLUS,
	MINUS,
	ASTERISK,
	SLASH,
	BACKSLASH,
	SEMICOLON,
	GREATER,
	GREATER_EQUALS,
	LESSER_EQUALS,
	GT,
	LT,
	LE,
	GE,
	EQ,
	NE,
	LESSER,
	NUMBER,
	LESSER_GREATER,
	STRING,
	IDENTIFIER_OR_KEYWORD,
	IDENTIFIER,
	LABEL_IDENTIFIER,
	COMMENT,
	EDITOR_MASK,

	// System variables
	TIMX,
	DATX,
	DATN,

	ABS,
	ACCEPT,
	ADD,
	ALL,
	ANY,
	ASSIGN,
	AT,
	ATN,
	AVER,
	BACKOUT,
	BEFORE,
	BREAK,
	BROWSE,
	BY,
	CALL,
	CALLDBPROC,
	CALLNAT,
	CLOSE,
	COMMIT,
	COMPOSE,
	COMPRESS,
	COMPUTE,
	CONST,
	CONSTANT,
	COPY,
	COS,
	COUNT,
	CREATE,
	DATA,
	DECIDE,
	DEFINE,
	DELETE,
	DISPLAY,
	DIVIDE,
	DYNAMIC,
	DLOGOFF,
	DLOGON,
	DNATIVE,
	DO,
	DOEND,
	DOWNLOAD,
	EJECT,
	ELSE,
	END,
	END_ALL,
	END_BEFORE,
	END_BREAK,
	END_BROWSE,
	END_DECIDE,
	END_ENDDATA,
	END_ENDFILE,
	END_ENDPAGE,
	END_ERROR,
	END_FILE,
	END_FIND,
	END_FOR,
	END_HISTOGRAM,
	ENDHOC,
	END_IF,
	END_LOOP,
	END_NOREC,
	END_PARSE,
	END_PROCESS,
	END_READ,
	END_REPEAT,
	END_RESULT,
	END_SELECT,
	END_SORT,
	END_START,
	END_DATA,
	END_DEFINE,
	END_SUBROUTINE,
	END_TOPPAGE,
	END_WORK,
	ENTIRE,
	ESCAPE,
	EXAMINE,
	EXP,
	EXPAND,
	EXPORT,
	FALSE,
	FETCH,
	FILLER,
	FIND,
	FOR,
	FORMAT,
	FRAC,
	FULL,
	FUNCTION,
	GET,
	GLOBAL,
	HISTOGRAM,
	IF,
	IGNORE,
	IMPORT,
	INCCONT,
	INCDIC,
	INCDIR,
	INCLUDE,
	INCMAC,
	INDEPENDENT,
	INIT,
	INPUT,
	INSERT,
	INT,
	INVESTIGATE,
	LANGUAGE,
	LENGTH,
	LIBRARY_ID,
	LIMIT,
	LOCAL,
	LOG,
	LOOP,
	MAP,
	MAX,
	MIN,
	MOVE,
	MULTIPLY,
	NAVER,
	NCOUNT,
	NEWPAGE,
	NMIN,
	NONE,
	NULL_HANDLE,
	OBTAIN,
	OF,
	OLD,
	ON,
	OPEN,
	OPTIONAL,
	OPTIONS,
	PARAMETER,
	PARSE,
	PASSW,
	PERCENT,
	PERFORM,
	POS,
	PRINT,
	PRINTER,
	PROCESS,
	PROTOTYPE,
	PROGRAM,
	QUESTIONMARK,
	READ,
	REDEFINE,
	REDUCE,
	REINPUT,
	REJECT,
	RELEASE,
	REPEAT,
	REQUEST,
	RESET,
	RESIZE,
	RESTORE,
	RESULT,
	RET,
	RETRY,
	RETURN,
	ROLLBACK,
	RULEVAR,
	RUN,
	SELECT,
	SEND,
	SEPARATE,
	SET,
	SETTIME,
	SGN,
	SHOW,
	SIN,
	SKIP,
	SORT,
	SORTKEY,
	SQRT,
	STACK,
	START,
	STOP,
	STORE,
	SUBROUTINE,
	SUBSTR,
	SUBSTRING,
	SUBTRACT,
	SUM,
	SUSPEND,
	TAN,
	TERMINATE,
	TOP,
	TOTAL,
	TRANSFER,
	TRUE,
	UNTIL,
	UPDATE,
	USER,
	USING,
	UPLOAD,
	VAL,
	VALUE,
	VALUES,
	VIEW,
	WASTE,
	WHEN,
	WHILE,
	WITH_CTE,
	WINDOW,
	WORK,
	WRITE;

	public boolean isIdentifier()
	{
		return this == IDENTIFIER || this == IDENTIFIER_OR_KEYWORD; // TODO: Keyword temporary
	}

	public boolean isSystemVariable()
	{
		return this == DATN || this == DATX || this == TIMX || this == LANGUAGE || this == PROGRAM || this == USER || this == LIBRARY_ID;
	}

	public boolean isBoolean()
	{
		return this == TRUE || this == FALSE;
	}

	public boolean isLiteralOrConst()
	{
		return isBoolean() || this == NUMBER || this == STRING;
	}
}
