package org.amshove.natlint.natparse.parsing.ddm;

import org.amshove.natlint.natparse.NaturalParseException;
import org.amshove.natlint.natparse.natural.DataFormat;
import org.amshove.natlint.natparse.natural.DescriptorType;
import org.amshove.natlint.natparse.natural.NullValueSupression;

class FieldParser
{
	private static final int TYPE_INDEX = 0;
	private static final int TYPE_LENGTH = 1;

	private static final int LEVEL_INDEX = 2;
	private static final int LEVEL_LENGTH = 1;

	private static final int SHORTNAME_INDEX = 4;
	private static final int SHORTNAME_LENGTH = 2;

	private static final int NAME_INDEX = 7;
	private static final int NAME_LENGTH = 32;

	private static final int FORMAT_INDEX = 41;
	private static final int FORMAT_LENGTH = 1;

	private static final int LENGTH_INDEX = 43;
	private static final int LENGTH_LENGTH = 4;

	private static final int SUPRESSION_INDEX = 49;
	private static final int SUPRESSION_LENGTH = 1;

	private static final int DESCRIPTOR_INDEX = 51;
	private static final int DESCRIPTOR_LENGTH = 1;

	private static final int REMARK_INDEX = 53;

	public DdmField parse(String fieldLine)
	{
		return new DdmField(
			parseFieldType(fieldLine),
			parseLevel(fieldLine),
			parseShortname(fieldLine),
			parseName(fieldLine),
			parseFormat(fieldLine),
			parseLength(fieldLine),
			parseSupression(fieldLine),
			parseDescriptorType(fieldLine),
			parseRemark(fieldLine));
	}

	private static FieldType parseFieldType(String line)
	{
		String type = getField(line, TYPE_INDEX, TYPE_LENGTH);
		if (type.equals(" "))
		{
			return FieldType.NONE;
		}
		if (type.equals("M"))
		{
			return FieldType.MULTIPLE;
		}
		if (type.equals("G"))
		{
			return FieldType.GROUP;
		}
		if (type.equals("P"))
		{
			return FieldType.PERIODIC;
		}

		throw new NaturalParseException(String.format("Can't determine DDM FieldType from \"%s\"", type));
	}

	private static int parseLevel(String line)
	{
		String level = getField(line, LEVEL_INDEX, LEVEL_LENGTH);
		return Integer.parseInt(level);
	}

	private static String parseShortname(String line)
	{
		return getField(line, SHORTNAME_INDEX, SHORTNAME_LENGTH).trim();
	}

	private static String parseName(String line)
	{
		return getField(line, NAME_INDEX, NAME_LENGTH).trim();
	}

	private static DataFormat parseFormat(String line)
	{
		String format = getField(line, FORMAT_INDEX, FORMAT_LENGTH);
		return DataFormat.fromSource(format);
	}

	private static double parseLength(String line)
	{
		String ddmLength = getField(line, LENGTH_INDEX, LENGTH_LENGTH);
		if (ddmLength.contains(","))
		{
			// Using NumberFormat would not throw on invalid Characters
			ddmLength = ddmLength.replace(",", ".");
		}

		try
		{
			return Double.parseDouble(ddmLength);
		}
		catch (NumberFormatException e)
		{
			throw new NaturalParseException(String.format("Can't parse format length \"%s\"", ddmLength));
		}
	}

	private static NullValueSupression parseSupression(String line)
	{
		String supression = getField(line, SUPRESSION_INDEX, SUPRESSION_LENGTH);
		return NullValueSupression.fromSource(supression);
	}

	private static String getField(String line, int index, int length)
	{
		return line.substring(index, index + length);
	}

	private static DescriptorType parseDescriptorType(String line)
	{
		return DescriptorType.fromSource(getField(line, DESCRIPTOR_INDEX, DESCRIPTOR_LENGTH));
	}

	private static String parseRemark(String line)
	{
		return line.substring(REMARK_INDEX).trim();
	}
}
