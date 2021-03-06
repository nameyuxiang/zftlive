package com.zftlive.android.library.third.ormlite.stmt.query;

import java.sql.SQLException;
import java.util.List;

import com.zftlive.android.library.third.ormlite.db.DatabaseType;
import com.zftlive.android.library.third.ormlite.field.FieldType;
import com.zftlive.android.library.third.ormlite.stmt.ArgumentHolder;
import com.zftlive.android.library.third.ormlite.stmt.StatementBuilder;

/**
 * Internal class handling the SQL SET part used by UPDATE statements. Used by
 * {@link StatementBuilder#updateColumnExpression(String, String)}.
 * 
 * <p>
 * It's not a comparison per se but does have a columnName = value form so it works.
 * </p>
 * 
 * @author graywatson
 */
public class SetExpression extends BaseComparison {

	public SetExpression(String columnName, FieldType fieldType, String string) throws SQLException {
		super(columnName, fieldType, string, true);
	}

	@Override
	public void appendOperation(StringBuilder sb) {
		sb.append("= ");
	}

	@Override
	protected void appendArgOrValue(DatabaseType databaseType, FieldType fieldType, StringBuilder sb,
			List<ArgumentHolder> selectArgList, Object argOrValue) {
		// we know it is a string so just append it
		sb.append(argOrValue).append(' ');
	}
}
