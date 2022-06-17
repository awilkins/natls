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
	GREATER_SIGN,
	GREATER_EQUALS_SIGN,
	LESSER_SIGN,
	LESSER_EQUALS_SIGN,
	NUMBER_LITERAL,
	LESSER_GREATER,
	STRING_LITERAL,
	IDENTIFIER,
	LABEL_IDENTIFIER,
	COMMENT,
	EDITOR_MASK,
	PERCENT,
	QUESTIONMARK,

	// System variables and functions
	TIMX,
	DATX,
	DATN,
	LIBRARY_ID,
	LINEX,
	CURRENT_UNIT,
	OCC,
	ERROR_NR,
	ERROR_LINE,
	LINE,
	TRIM,
	MAXVAL,
	MINVAL,
	CURS_LINE,
	PF_KEY,

	// Natural reserved keywords
	ABS,
	ABSOLUTE,
	ACCEPT,
	ACTION,
	ACTIVATION,
	AD,
	ADD,
	AFTER,
	AL,
	ALARM,
	ALL,
	ALPHA,
	ALPHABETICALLY,
	AND,
	ANY,
	APPL,
	APPLICATION,
	ARRAY,
	AS,
	ASC,
	ASCENDING,
	ASSIGN,
	ASSIGNING,
	ASYNC,
	AT,
	ATN,
	ATT,
	ATTRIBUTES,
	AUTH,
	AUTHORIZATION,
	AUTO,
	AVER,
	AVG,
	BACKOUT,
	BACKWARD,
	BASE,
	BEFORE,
	BETWEEN,
	BLOCK,
	BOT,
	BOTTOM,
	BREAK,
	BROWSE,
	BUT,
	BX,
	BY,
	CABINET,
	CALL,
	CALLDBPROC,
	CALLING,
	CALLNAT,
	CAP,
	CAPTIONED,
	CASE,
	CC,
	CD,
	CDID,
	CF,
	CHAR,
	CHARLENGTH,
	CHARPOSITION,
	CHILD,
	CIPH,
	CIPHER,
	CLASS,
	CLOSE,
	CLR,
	COALESCE,
	CODEPAGE,
	COMMAND,
	COMMIT,
	COMPOSE,
	COMPRESS,
	COMPUTE,
	CONCAT,
	CONDITION,
	CONST,
	CONSTANT,
	CONTEXT,
	CONTROL,
	CONVERSATION,
	COPIES,
	COPY,
	COS,
	COUNT,
	COUPLED,
	CS,
	CURRENT,
	CURSOR,
	CV,
	DATA,
	DATAAREA,
	DATE,
	DAY,
	DAYS,
	DC,
	DECIDE,
	DECIMAL,
	DEFINE,
	DEFINITION,
	DELETE,
	DELIMITED,
	DELIMITER,
	DELIMITERS,
	DESC,
	DESCENDING,
	DIALOG,
	DIALOG_ID,
	DIGITS,
	DIRECTION,
	DISABLED,
	DISP,
	DISPLAY,
	DISTINCT,
	DIVIDE,
	DL,
	DLOGOFF,
	DLOGON,
	DNATIVE,
	DNRET,
	DO,
	DOCUMENT,
	DOEND,
	DOWNLOAD,
	DU,
	DY,
	DYNAMIC,
	EDITED,
	EJ,
	EJECT,
	ELSE,
	EM,
	ENCODED,
	END,
	END_ALL,
	END_BEFORE,
	END_BREAK,
	END_BROWSE,
	END_CLASS,
	END_DECIDE,
	END_DEFINE,
	END_ENDDATA,
	END_ENDFILE,
	END_ENDPAGE,
	END_ERROR,
	END_FILE,
	END_FIND,
	END_FOR,
	END_FUNCTION,
	END_HISTOGRAM,
	ENDHOC,
	END_IF,
	END_INTERFACE,
	END_LOOP,
	END_METHOD,
	END_NOREC,
	END_PARAMETERS,
	END_PARSE,
	END_PROCESS,
	END_PROPERTY,
	END_PROTOTYPE,
	END_READ,
	END_REPEAT,
	END_RESULT,
	END_SELECT,
	END_SORT,
	END_START,
	END_SUBROUTINE,
	END_TOPPAGE,
	END_WORK,
	ENDING,
	ENTER,
	ENTIRE,
	ENTR,
	EQ,
	EQUAL,
	ERASE,
	ERROR,
	ERRORS,
	ES,
	ESCAPE,
	EVEN,
	EVENT,
	EVERY,
	EXAMINE,
	EXCEPT,
	EXISTS,
	EXIT,
	EXP,
	EXPAND,
	EXPORT,
	EXTERNAL,
	EXTRACTING,
	FALSE,
	FC,
	FETCH,
	FIELD,
	FIELDS,
	FILE,
	FILL,
	FILLER,
	FINAL,
	FIND,
	FIRST,
	FL,
	FLOAT,
	FOR,
	FORM,
	FORMAT,
	FORMATTED,
	FORMATTING,
	FORMS,
	FORWARD,
	FOUND,
	FRAC,
	FRAMED,
	FROM,
	FS,
	FULL,
	FUNCTION,
	FUNCTIONS,
	GC,
	GE,
	GEN,
	GENERATED,
	GET,
	GFID,
	GIVE,
	GIVING,
	GLOBAL,
	GLOBALS,
	GREATER,
	GT,
	GUI,
	HANDLE,
	HAVING,
	HC,
	HD,
	HE,
	HEADER,
	HEX,
	HISTOGRAM,
	HOLD,
	HORIZ,
	HORIZONTALLY,
	HOUR,
	HOURS,
	HW,
	IA,
	IC,
	ID,
	IDENTICAL,
	IF,
	IGNORE,
	IM,
	IMMEDIATE,
	IMPORT,
	IN,
	INC,
	INCCONT,
	INCDIC,
	INCDIR,
	INCLUDE,
	INCLUDED,
	INCLUDING,
	INCMAC,
	INDEPENDENT,
	INDEX,
	INDEXED,
	INDICATOR,
	INIT,
	INITIAL,
	INNER,
	INPUT,
	INSENSITIVE,
	INSERT,
	INT,
	INTEGER,
	INTERCEPTED,
	INTERFACE,
	INTERFACE4,
	INTERMEDIATE,
	INTERSECT,
	INTO,
	INVERTED,
	INVESTIGATE,
	IP,
	IS,
	ISN,
	JOIN,
	JUST,
	JUSTIFIED,
	KD,
	KEEP,
	KEY,
	KEYS,
	LANGUAGE,
	LAST,
	LC,
	LE,
	LEAVE,
	LEAVING,
	LEFT,
	LENGTH,
	LESS,
	LEVEL,
	LIB,
	LIBPW,
	LIBRARY,
	LIBRARY_PASSWORD,
	LIKE,
	LIMIT,
	LINDICATOR,
	LINES,
	LISTED,
	LOCAL,
	LOCKS,
	LOG,
	LOG_LS,
	LOG_PS,
	LOGICAL,
	LOOP,
	LOWER,
	LS,
	LT,
	MACROAREA,
	MAP,
	MARK,
	MASK,
	MAX,
	MC,
	MCG,
	MESSAGES,
	METHOD,
	MGID,
	MICROSECOND,
	MIN,
	MINUTE,
	MODAL,
	MODIFIED,
	MODULE,
	MONTH,
	MORE,
	MOVE,
	MOVING,
	MP,
	MS,
	MT,
	MULTI_FETCH,
	MULTIPLY,
	NAME,
	NAMED,
	NAMESPACE,
	NATIVE,
	NAVER,
	NC,
	NCOUNT,
	NE,
	NEWPAGE,
	NL,
	NMIN,
	NO,
	NODE,
	NOHDR,
	NONE,
	NORMALIZE,
	NORMALIZED,
	NOT,
	NOTIT,
	NOTITLE,
	NULL,
	NULL_HANDLE,
	NUMBER,
	NUMERIC,
	OBJECT,
	OBTAIN,
	OCCURRENCES,
	OF,
	OFF,
	OFFSET,
	OLD,
	ON,
	ONCE,
	ONLY,
	OPEN,
	OPTIMIZE,
	OPTIONAL,
	OPTIONS,
	OR,
	ORDER,
	OUTER,
	OUTPUT,
	PACKAGESET,
	PAGE,
	PARAMETER,
	PARAMETERS,
	PARENT,
	PARSE,
	PASS,
	PASSW,
	PASSWORD,
	PATH,
	PATTERN,
	PA1,
	PA2,
	PA3,
	PC,
	PD,
	PEN,
	PERFORM,
	PF,
	PGDN,
	PGUP,
	PGM,
	PHYSICAL,
	PM,
	POLICY,
	POS,
	POSITION,
	PREFIX,
	PRINT,
	PRINTER,
	PROCESS,
	PROCESSING,
	PROFILE,
	PROGRAM,
	PROPERTY,
	PROTOTYPE,
	PRTY,
	PS,
	PT,
	PW,
	QUARTER,
	QUERYNO,
	RD,
	READ,
	READONLY,
	REC,
	RECORD,
	RECORDS,
	RECURSIVELY,
	REDEFINE,
	REDUCE,
	REFERENCED,
	REFERENCING,
	REINPUT,
	REJECT,
	REL,
	RELATION,
	RELATIONSHIP,
	RELEASE,
	REMAINDER,
	REPEAT,
	REPLACE,
	REPORT,
	REPORTER,
	REPOSITION,
	REQUEST,
	REQUIRED,
	RESET,
	RESETTING,
	RESIZE,
	RESPONSE,
	RESTORE,
	RESULT,
	RET,
	RETAIN,
	RETAINED,
	RETRY,
	RETURN,
	RETURNS,
	REVERSED,
	RG,
	RIGHT,
	ROLLBACK,
	ROUNDED,
	ROUTINE,
	ROW,
	ROWS,
	RR,
	RS,
	RULEVAR,
	RUN,
	SA,
	SAME,
	SCAN,
	SCREEN,
	SCROLL,
	SECOND,
	SELECT,
	SELECTION,
	SEND,
	SENSITIVE,
	SEPARATE,
	SEQUENCE,
	SERVER,
	SET,
	SETS,
	SETTIME,
	SF,
	SG,
	SGN,
	SHORT,
	SHOW,
	SIN,
	SINGLE,
	SIZE,
	SKIP,
	SL,
	SM,
	SOME,
	SORT,
	SORTED,
	SORTKEY,
	SOUND,
	SPACE,
	SPECIFIED,
	SQL,
	SQLID,
	SQRT,
	STACK,
	START,
	STARTING,
	STATEMENT,
	STATIC,
	STATUS,
	STEP,
	STOP,
	STORE,
	SUBPROGRAM,
	SUBPROGRAMS,
	SUBROUTINE,
	SUBSTR,
	SUBSTRING,
	SUBTRACT,
	SUM,
	SUPPRESS,
	SUPPRESSED,
	SUSPEND,
	SYMBOL,
	SYNC,
	SYSTEM,
	TAN,
	TC,
	TERMINATE,
	TEXT,
	TEXTAREA,
	TEXTVARIABLE,
	THAN,
	THEM,
	THEN,
	THRU,
	TIME,
	TIMESTAMP,
	TIMEZONE,
	TITLE,
	TO,
	TOP,
	TOTAL,
	TP,
	TR,
	TRAILER,
	TRANSACTION,
	TRANSFER,
	TRANSLATE,
	TREQ,
	TRUE,
	TS,
	TYPE,
	TYPES,
	UC,
	UNDERLINED,
	UNION,
	UNIQUE,
	UNKNOWN,
	UNTIL,
	UPDATE,
	UPLOAD,
	UPPER,
	UR,
	USED,
	USER,
	USING,
	VAL,
	VALUE,
	VALUES,
	VARGRAPHIC,
	VARIABLE,
	VARIABLES,
	VERT,
	VERTICALLY,
	VIA,
	VIEW,
	WH,
	WHEN,
	WHERE,
	WHILE,
	WINDOW,
	WITH,
	WORK,
	WRITE,
	WITH_CTE,
	XML,
	YEAR,
	ZD,
	ZP;


	@Deprecated(since="Directly test against IDENTIFIER", forRemoval=true)
	public boolean isIdentifier()
	{
		return this == IDENTIFIER;
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
		return isBoolean() || this == NUMBER_LITERAL || this == STRING_LITERAL;
	}
}
