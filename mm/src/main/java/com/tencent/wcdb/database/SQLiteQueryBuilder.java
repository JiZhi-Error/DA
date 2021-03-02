package com.tencent.wcdb.database;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

public class SQLiteQueryBuilder {
    private static final String TAG = "WCDB.SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mDistinct = false;
    private SQLiteDatabase.CursorFactory mFactory = null;
    private Map<String, String> mProjectionMap = null;
    private boolean mStrict;
    private String mTables = "";
    private StringBuilder mWhereClause = null;

    static {
        AppMethodBeat.i(3286);
        AppMethodBeat.o(3286);
    }

    public void setDistinct(boolean z) {
        this.mDistinct = z;
    }

    public String getTables() {
        return this.mTables;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public void appendWhere(CharSequence charSequence) {
        AppMethodBeat.i(3271);
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
        AppMethodBeat.o(3271);
    }

    public void appendWhereEscapeString(String str) {
        AppMethodBeat.i(3272);
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
        AppMethodBeat.o(3272);
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setStrict(boolean z) {
        this.mStrict = z;
    }

    public static String buildQueryString(boolean z, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(3273);
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
            AppMethodBeat.o(3273);
            throw illegalArgumentException;
        } else if (TextUtils.isEmpty(str6) || sLimitPattern.matcher(str6).matches()) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (z) {
                sb.append("DISTINCT ");
            }
            if (strArr == null || strArr.length == 0) {
                sb.append("* ");
            } else {
                appendColumns(sb, strArr);
            }
            sb.append("FROM ");
            sb.append(str);
            appendClause(sb, " WHERE ", str2);
            appendClause(sb, " GROUP BY ", str3);
            appendClause(sb, " HAVING ", str4);
            appendClause(sb, " ORDER BY ", str5);
            appendClause(sb, " LIMIT ", str6);
            String sb2 = sb.toString();
            AppMethodBeat.o(3273);
            return sb2;
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("invalid LIMIT clauses:".concat(String.valueOf(str6)));
            AppMethodBeat.o(3273);
            throw illegalArgumentException2;
        }
    }

    private static void appendClause(StringBuilder sb, String str, String str2) {
        AppMethodBeat.i(3274);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str);
            sb.append(str2);
        }
        AppMethodBeat.o(3274);
    }

    public static void appendColumns(StringBuilder sb, String[] strArr) {
        AppMethodBeat.i(3275);
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (str != null) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append(' ');
        AppMethodBeat.o(3275);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        AppMethodBeat.i(3276);
        Cursor query = query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null, null);
        AppMethodBeat.o(3276);
        return query;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(3277);
        Cursor query = query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, str5, null);
        AppMethodBeat.o(3277);
        return query;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3278);
        if (this.mTables == null) {
            AppMethodBeat.o(3278);
            return null;
        }
        if (this.mStrict && str != null && str.length() > 0) {
            validateQuerySql(sQLiteDatabase, buildQuery(strArr, "(" + str + ")", str2, str3, str4, str5), cancellationSignal);
        }
        String buildQuery = buildQuery(strArr, str, str2, str3, str4, str5);
        Log.d(TAG, "Performing query: ".concat(String.valueOf(buildQuery)));
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables), cancellationSignal);
        AppMethodBeat.o(3278);
        return rawQueryWithFactory;
    }

    private void validateQuerySql(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3279);
        sQLiteDatabase.getThreadSession().prepare(str, sQLiteDatabase.getThreadDefaultConnectionFlags(true), cancellationSignal, null);
        AppMethodBeat.o(3279);
    }

    public String buildQuery(String[] strArr, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(3280);
        String[] computeProjection = computeProjection(strArr);
        StringBuilder sb = new StringBuilder();
        boolean z = this.mWhereClause != null && this.mWhereClause.length() > 0;
        if (z) {
            sb.append(this.mWhereClause.toString());
            sb.append(')');
        }
        if (str != null && str.length() > 0) {
            if (z) {
                sb.append(" AND ");
            }
            sb.append('(');
            sb.append(str);
            sb.append(')');
        }
        String buildQueryString = buildQueryString(this.mDistinct, this.mTables, computeProjection, sb.toString(), str2, str3, str4, str5);
        AppMethodBeat.o(3280);
        return buildQueryString;
    }

    @Deprecated
    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(3281);
        String buildQuery = buildQuery(strArr, str, str2, str3, str4, str5);
        AppMethodBeat.o(3281);
        return buildQuery;
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(3282);
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str6 = strArr[i3];
            if (str6.equals(str)) {
                strArr2[i3] = "'" + str2 + "' AS " + str;
            } else if (i3 <= i2 || set.contains(str6)) {
                strArr2[i3] = str6;
            } else {
                strArr2[i3] = "NULL AS ".concat(String.valueOf(str6));
            }
        }
        String buildQuery = buildQuery(strArr2, str3, str4, str5, null, null);
        AppMethodBeat.o(3282);
        return buildQuery;
    }

    @Deprecated
    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i2, String str2, String str3, String[] strArr2, String str4, String str5) {
        AppMethodBeat.i(3283);
        String buildUnionSubQuery = buildUnionSubQuery(str, strArr, set, i2, str2, str3, str4, str5);
        AppMethodBeat.o(3283);
        return buildUnionSubQuery;
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        AppMethodBeat.i(3284);
        StringBuilder sb = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                sb.append(str3);
            }
            sb.append(strArr[i2]);
        }
        appendClause(sb, " ORDER BY ", str);
        appendClause(sb, " LIMIT ", str2);
        String sb2 = sb.toString();
        AppMethodBeat.o(3284);
        return sb2;
    }

    private String[] computeProjection(String[] strArr) {
        AppMethodBeat.i(3285);
        if (strArr == null || strArr.length <= 0) {
            if (this.mProjectionMap != null) {
                Set<Map.Entry<String, String>> entrySet = this.mProjectionMap.entrySet();
                String[] strArr2 = new String[entrySet.size()];
                int i2 = 0;
                for (Map.Entry<String, String> entry : entrySet) {
                    if (!entry.getKey().equals(XWalkEnvironment.SP_KEY_FILE_READER_POSTFIX_COUNT)) {
                        strArr2[i2] = entry.getValue();
                        i2++;
                    }
                }
                AppMethodBeat.o(3285);
                return strArr2;
            }
            AppMethodBeat.o(3285);
            return null;
        } else if (this.mProjectionMap != null) {
            String[] strArr3 = new String[strArr.length];
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = strArr[i3];
                String str2 = this.mProjectionMap.get(str);
                if (str2 != null) {
                    strArr3[i3] = str2;
                } else if (this.mStrict || (!str.contains(" AS ") && !str.contains(" as "))) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid column " + strArr[i3]);
                    AppMethodBeat.o(3285);
                    throw illegalArgumentException;
                } else {
                    strArr3[i3] = str;
                }
            }
            AppMethodBeat.o(3285);
            return strArr3;
        } else {
            AppMethodBeat.o(3285);
            return strArr;
        }
    }
}
