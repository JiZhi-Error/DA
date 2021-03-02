package com.tencent.wcdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;

public final class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int EX_HAS_REPLY_HEADER = -128;
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;
    private static final String TAG = "WCDB.DatabaseUtils";
    private static Collator mColl = null;

    public static boolean objectEquals(Object obj, Object obj2) {
        AppMethodBeat.i(2795);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.o(2795);
            return true;
        }
        AppMethodBeat.o(2795);
        return false;
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exc) {
        int i2;
        boolean z;
        AppMethodBeat.i(2796);
        if (exc instanceof FileNotFoundException) {
            i2 = 1;
            z = false;
        } else if (exc instanceof IllegalArgumentException) {
            i2 = 2;
            z = true;
        } else if (exc instanceof UnsupportedOperationException) {
            i2 = 3;
            z = true;
        } else if (exc instanceof SQLiteAbortException) {
            i2 = 4;
            z = true;
        } else if (exc instanceof SQLiteConstraintException) {
            i2 = 5;
            z = true;
        } else if (exc instanceof SQLiteDatabaseCorruptException) {
            i2 = 6;
            z = true;
        } else if (exc instanceof SQLiteFullException) {
            i2 = 7;
            z = true;
        } else if (exc instanceof SQLiteDiskIOException) {
            i2 = 8;
            z = true;
        } else if (exc instanceof SQLiteException) {
            i2 = 9;
            z = true;
        } else if (exc instanceof OperationApplicationException) {
            i2 = 10;
            z = true;
        } else if (exc instanceof OperationCanceledException) {
            i2 = 11;
            z = false;
        } else {
            parcel.writeException(exc);
            Log.e(TAG, "Writing exception to parcel", exc);
            AppMethodBeat.o(2796);
            return;
        }
        parcel.writeInt(i2);
        parcel.writeString(exc.getMessage());
        if (z) {
            Log.e(TAG, "Writing exception to parcel", exc);
        }
        AppMethodBeat.o(2796);
    }

    private static final int readExceptionCode(Parcel parcel) {
        AppMethodBeat.i(2797);
        int readInt = parcel.readInt();
        if (readInt == EX_HAS_REPLY_HEADER) {
            if (parcel.readInt() == 0) {
                Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
            }
            AppMethodBeat.o(2797);
            return 0;
        }
        AppMethodBeat.o(2797);
        return readInt;
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        AppMethodBeat.i(2798);
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode == 0) {
            AppMethodBeat.o(2798);
            return;
        }
        readExceptionFromParcel(parcel, parcel.readString(), readExceptionCode);
        AppMethodBeat.o(2798);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) {
        AppMethodBeat.i(2799);
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode == 0) {
            AppMethodBeat.o(2799);
            return;
        }
        String readString = parcel.readString();
        if (readExceptionCode == 1) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(readString);
            AppMethodBeat.o(2799);
            throw fileNotFoundException;
        }
        readExceptionFromParcel(parcel, readString, readExceptionCode);
        AppMethodBeat.o(2799);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) {
        AppMethodBeat.i(2800);
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode == 0) {
            AppMethodBeat.o(2800);
            return;
        }
        String readString = parcel.readString();
        if (readExceptionCode == 10) {
            OperationApplicationException operationApplicationException = new OperationApplicationException(readString);
            AppMethodBeat.o(2800);
            throw operationApplicationException;
        }
        readExceptionFromParcel(parcel, readString, readExceptionCode);
        AppMethodBeat.o(2800);
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i2) {
        AppMethodBeat.i(2801);
        switch (i2) {
            case 2:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                AppMethodBeat.o(2801);
                throw illegalArgumentException;
            case 3:
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(str);
                AppMethodBeat.o(2801);
                throw unsupportedOperationException;
            case 4:
                SQLiteAbortException sQLiteAbortException = new SQLiteAbortException(str);
                AppMethodBeat.o(2801);
                throw sQLiteAbortException;
            case 5:
                SQLiteConstraintException sQLiteConstraintException = new SQLiteConstraintException(str);
                AppMethodBeat.o(2801);
                throw sQLiteConstraintException;
            case 6:
                SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException(str);
                AppMethodBeat.o(2801);
                throw sQLiteDatabaseCorruptException;
            case 7:
                SQLiteFullException sQLiteFullException = new SQLiteFullException(str);
                AppMethodBeat.o(2801);
                throw sQLiteFullException;
            case 8:
                SQLiteDiskIOException sQLiteDiskIOException = new SQLiteDiskIOException(str);
                AppMethodBeat.o(2801);
                throw sQLiteDiskIOException;
            case 9:
                SQLiteException sQLiteException = new SQLiteException(str);
                AppMethodBeat.o(2801);
                throw sQLiteException;
            case 10:
            default:
                parcel.readException(i2, str);
                AppMethodBeat.o(2801);
                return;
            case 11:
                OperationCanceledException operationCanceledException = new OperationCanceledException(str);
                AppMethodBeat.o(2801);
                throw operationCanceledException;
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i2, Object obj) {
        AppMethodBeat.i(2802);
        if (obj == null) {
            sQLiteProgram.bindNull(i2);
            AppMethodBeat.o(2802);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i2, ((Number) obj).doubleValue());
            AppMethodBeat.o(2802);
        } else if (obj instanceof Number) {
            sQLiteProgram.bindLong(i2, ((Number) obj).longValue());
            AppMethodBeat.o(2802);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i2, 1);
                AppMethodBeat.o(2802);
                return;
            }
            sQLiteProgram.bindLong(i2, 0);
            AppMethodBeat.o(2802);
        } else if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i2, (byte[]) obj);
            AppMethodBeat.o(2802);
        } else {
            sQLiteProgram.bindString(i2, obj.toString());
            AppMethodBeat.o(2802);
        }
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return 1;
        }
        return 3;
    }

    public static void cursorFillWindow(Cursor cursor, int i2, CursorWindow cursorWindow) {
        boolean putNull;
        AppMethodBeat.i(2803);
        if (i2 < 0 || i2 >= cursor.getCount()) {
            AppMethodBeat.o(2803);
            return;
        }
        int position = cursor.getPosition();
        int columnCount = cursor.getColumnCount();
        cursorWindow.clear();
        cursorWindow.setStartPosition(i2);
        cursorWindow.setNumColumns(columnCount);
        if (cursor.moveToPosition(i2)) {
            while (cursorWindow.allocRow()) {
                int i3 = 0;
                while (true) {
                    if (i3 < columnCount) {
                        switch (cursor.getType(i3)) {
                            case 0:
                                putNull = cursorWindow.putNull(i2, i3);
                                break;
                            case 1:
                                putNull = cursorWindow.putLong(cursor.getLong(i3), i2, i3);
                                break;
                            case 2:
                                putNull = cursorWindow.putDouble(cursor.getDouble(i3), i2, i3);
                                break;
                            case 3:
                            default:
                                String string = cursor.getString(i3);
                                if (string == null) {
                                    putNull = cursorWindow.putNull(i2, i3);
                                    break;
                                } else {
                                    putNull = cursorWindow.putString(string, i2, i3);
                                    break;
                                }
                            case 4:
                                byte[] blob = cursor.getBlob(i3);
                                if (blob == null) {
                                    putNull = cursorWindow.putNull(i2, i3);
                                    break;
                                } else {
                                    putNull = cursorWindow.putBlob(blob, i2, i3);
                                    break;
                                }
                        }
                        if (!putNull) {
                            cursorWindow.freeLastRow();
                        } else {
                            i3++;
                        }
                    }
                }
                i2++;
                if (!cursor.moveToNext()) {
                }
            }
        }
        cursor.moveToPosition(position);
        AppMethodBeat.o(2803);
    }

    public static void appendEscapedSQLString(StringBuilder sb, String str) {
        AppMethodBeat.i(2804);
        sb.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\'') {
                    sb.append('\'');
                }
                sb.append(charAt);
            }
        } else {
            sb.append(str);
        }
        sb.append('\'');
        AppMethodBeat.o(2804);
    }

    public static String sqlEscapeString(String str) {
        AppMethodBeat.i(2805);
        StringBuilder sb = new StringBuilder();
        appendEscapedSQLString(sb, str);
        String sb2 = sb.toString();
        AppMethodBeat.o(2805);
        return sb2;
    }

    public static final void appendValueToSql(StringBuilder sb, Object obj) {
        AppMethodBeat.i(2806);
        if (obj == null) {
            sb.append("NULL");
            AppMethodBeat.o(2806);
        } else if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(sb, obj.toString());
            AppMethodBeat.o(2806);
        } else if (((Boolean) obj).booleanValue()) {
            sb.append('1');
            AppMethodBeat.o(2806);
        } else {
            sb.append('0');
            AppMethodBeat.o(2806);
        }
    }

    public static String concatenateWhere(String str, String str2) {
        AppMethodBeat.i(2807);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(2807);
            return str2;
        } else if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(2807);
            return str;
        } else {
            String str3 = "(" + str + ") AND (" + str2 + ")";
            AppMethodBeat.o(2807);
            return str3;
        }
    }

    public static String getCollationKey(String str) {
        AppMethodBeat.i(2808);
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            String str2 = new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
            AppMethodBeat.o(2808);
            return str2;
        } catch (Exception e2) {
            AppMethodBeat.o(2808);
            return "";
        }
    }

    private static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr[i2] = DIGITS[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = DIGITS[bArr[i3] & 15];
        }
        return cArr;
    }

    public static String getHexCollationKey(String str) {
        AppMethodBeat.i(2809);
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        String str2 = new String(encodeHex(collationKeyInBytes), 0, getKeyLen(collationKeyInBytes) * 2);
        AppMethodBeat.o(2809);
        return str2;
    }

    private static int getKeyLen(byte[] bArr) {
        if (bArr[bArr.length - 1] != 0) {
            return bArr.length;
        }
        return bArr.length - 1;
    }

    private static byte[] getCollationKeyInBytes(String str) {
        AppMethodBeat.i(2810);
        if (mColl == null) {
            Collator instance = Collator.getInstance();
            mColl = instance;
            instance.setStrength(0);
        }
        byte[] byteArray = mColl.getCollationKey(str).toByteArray();
        AppMethodBeat.o(2810);
        return byteArray;
    }

    public static void dumpCursor(Cursor cursor) {
        AppMethodBeat.i(2811);
        dumpCursor(cursor, System.out);
        AppMethodBeat.o(2811);
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        AppMethodBeat.i(2812);
        printStream.println(">>>>> Dumping cursor ".concat(String.valueOf(cursor)));
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
        AppMethodBeat.o(2812);
    }

    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        AppMethodBeat.i(2813);
        sb.append(">>>>> Dumping cursor " + cursor + "\n");
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(position);
        }
        sb.append("<<<<<\n");
        AppMethodBeat.o(2813);
    }

    public static String dumpCursorToString(Cursor cursor) {
        AppMethodBeat.i(2814);
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        String sb2 = sb.toString();
        AppMethodBeat.o(2814);
        return sb2;
    }

    public static void dumpCurrentRow(Cursor cursor) {
        AppMethodBeat.i(2815);
        dumpCurrentRow(cursor, System.out);
        AppMethodBeat.o(2815);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String str;
        AppMethodBeat.i(2816);
        String[] columnNames = cursor.getColumnNames();
        printStream.println(cursor.getPosition() + " {");
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                str = cursor.getString(i2);
            } catch (SQLiteException e2) {
                str = "<unprintable>";
            }
            printStream.println("   " + columnNames[i2] + '=' + str);
        }
        printStream.println("}");
        AppMethodBeat.o(2816);
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String str;
        AppMethodBeat.i(2817);
        String[] columnNames = cursor.getColumnNames();
        sb.append(cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                str = cursor.getString(i2);
            } catch (SQLiteException e2) {
                str = "<unprintable>";
            }
            sb.append("   " + columnNames[i2] + '=' + str + "\n");
        }
        sb.append("}\n");
        AppMethodBeat.o(2817);
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        AppMethodBeat.i(2818);
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        String sb2 = sb.toString();
        AppMethodBeat.o(2818);
        return sb2;
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.i(2819);
        cursorStringToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.o(2819);
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i2) {
        AppMethodBeat.i(2820);
        insertHelper.bind(i2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
        AppMethodBeat.o(2820);
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.i(2821);
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
        AppMethodBeat.o(2821);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.i(2822);
        cursorIntToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.o(2822);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.i(2823);
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
            AppMethodBeat.o(2823);
            return;
        }
        contentValues.put(str2, (Integer) null);
        AppMethodBeat.o(2823);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.i(2824);
        cursorLongToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.o(2824);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.i(2825);
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
            AppMethodBeat.o(2825);
            return;
        }
        contentValues.put(str2, (Long) null);
        AppMethodBeat.o(2825);
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.i(2826);
        cursorDoubleToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.o(2826);
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.i(2827);
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
            AppMethodBeat.o(2827);
            return;
        }
        contentValues.put(str2, (Double) null);
        AppMethodBeat.o(2827);
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AppMethodBeat.i(2828);
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (abstractWindowedCursor == null || !abstractWindowedCursor.isBlob(i2)) {
                contentValues.put(columnNames[i2], cursor.getString(i2));
            } else {
                contentValues.put(columnNames[i2], cursor.getBlob(i2));
            }
        }
        AppMethodBeat.o(2828);
    }

    public static int cursorPickFillWindowStartPosition(int i2, int i3) {
        AppMethodBeat.i(2829);
        int max = Math.max(i2 - (i3 / 3), 0);
        AppMethodBeat.o(2829);
        return max;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.i(2830);
        long queryNumEntries = queryNumEntries(sQLiteDatabase, str, null, null);
        AppMethodBeat.o(2830);
        return queryNumEntries;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        AppMethodBeat.i(2831);
        long queryNumEntries = queryNumEntries(sQLiteDatabase, str, str2, null);
        AppMethodBeat.o(2831);
        return queryNumEntries;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        AppMethodBeat.i(2832);
        long longForQuery = longForQuery(sQLiteDatabase, "select count(*) from " + str + (!TextUtils.isEmpty(str2) ? " where ".concat(String.valueOf(str2)) : ""), strArr);
        AppMethodBeat.o(2832);
        return longForQuery;
    }

    public static boolean queryIsEmpty(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.i(2833);
        if (longForQuery(sQLiteDatabase, "select exists(select 1 from " + str + ")", null) == 0) {
            AppMethodBeat.o(2833);
            return true;
        }
        AppMethodBeat.o(2833);
        return false;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        AppMethodBeat.i(2834);
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return longForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
            AppMethodBeat.o(2834);
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        AppMethodBeat.i(2835);
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
        AppMethodBeat.o(2835);
        return simpleQueryForLong;
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        AppMethodBeat.i(2836);
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return stringForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
            AppMethodBeat.o(2836);
        }
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        AppMethodBeat.i(2837);
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        String simpleQueryForString = sQLiteStatement.simpleQueryForString();
        AppMethodBeat.o(2837);
        return simpleQueryForString;
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.i(2838);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, cursor.getString(columnIndex));
        }
        AppMethodBeat.o(2838);
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.i(2839);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Long.valueOf(cursor.getLong(columnIndex)));
        }
        AppMethodBeat.o(2839);
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.i(2840);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Short.valueOf(cursor.getShort(columnIndex)));
        }
        AppMethodBeat.o(2840);
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.i(2841);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndex)));
        }
        AppMethodBeat.o(2841);
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.i(2842);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndex)));
        }
        AppMethodBeat.o(2842);
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.i(2843);
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndex)));
        }
        AppMethodBeat.o(2843);
    }

    @Deprecated
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mPreparedStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private final String mTableName;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        private void buildSQL() {
            Cursor cursor = null;
            AppMethodBeat.i(2777);
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(this.mTableName);
            sb.append(" (");
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("VALUES (");
            try {
                Cursor rawQuery = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
                this.mColumns = new HashMap<>(rawQuery.getCount());
                int i2 = 1;
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(1);
                    String string2 = rawQuery.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i2));
                    sb.append("'");
                    sb.append(string);
                    sb.append("'");
                    if (string2 == null) {
                        sb2.append("?");
                    } else {
                        sb2.append("COALESCE(?, ");
                        sb2.append(string2);
                        sb2.append(")");
                    }
                    sb.append(i2 == rawQuery.getCount() ? ") " : ", ");
                    sb2.append(i2 == rawQuery.getCount() ? ");" : ", ");
                    i2++;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                sb.append((CharSequence) sb2);
                this.mInsertSQL = sb.toString();
                AppMethodBeat.o(2777);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                AppMethodBeat.o(2777);
                throw th;
            }
        }

        private SQLiteStatement getStatement(boolean z) {
            AppMethodBeat.i(2778);
            if (z) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
                }
                SQLiteStatement sQLiteStatement = this.mReplaceStatement;
                AppMethodBeat.o(2778);
                return sQLiteStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            SQLiteStatement sQLiteStatement2 = this.mInsertStatement;
            AppMethodBeat.o(2778);
            return sQLiteStatement2;
        }

        private long insertInternal(ContentValues contentValues, boolean z) {
            AppMethodBeat.i(2779);
            this.mDb.beginTransactionNonExclusive();
            try {
                SQLiteStatement statement = getStatement(z);
                statement.clearBindings();
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    DatabaseUtils.bindObjectToProgram(statement, getColumnIndex(entry.getKey()), entry.getValue());
                }
                long executeInsert = statement.executeInsert();
                this.mDb.setTransactionSuccessful();
                this.mDb.endTransaction();
                AppMethodBeat.o(2779);
                return executeInsert;
            } catch (SQLException e2) {
                Log.e(DatabaseUtils.TAG, "Error inserting " + contentValues + " into table  " + this.mTableName, e2);
                this.mDb.endTransaction();
                AppMethodBeat.o(2779);
                return -1;
            } catch (Throwable th) {
                this.mDb.endTransaction();
                AppMethodBeat.o(2779);
                throw th;
            }
        }

        public int getColumnIndex(String str) {
            AppMethodBeat.i(2780);
            getStatement(false);
            Integer num = this.mColumns.get(str);
            if (num == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("column '" + str + "' is invalid");
                AppMethodBeat.o(2780);
                throw illegalArgumentException;
            }
            int intValue = num.intValue();
            AppMethodBeat.o(2780);
            return intValue;
        }

        public void bind(int i2, double d2) {
            AppMethodBeat.i(2781);
            this.mPreparedStatement.bindDouble(i2, d2);
            AppMethodBeat.o(2781);
        }

        public void bind(int i2, float f2) {
            AppMethodBeat.i(2782);
            this.mPreparedStatement.bindDouble(i2, (double) f2);
            AppMethodBeat.o(2782);
        }

        public void bind(int i2, long j2) {
            AppMethodBeat.i(2783);
            this.mPreparedStatement.bindLong(i2, j2);
            AppMethodBeat.o(2783);
        }

        public void bind(int i2, int i3) {
            AppMethodBeat.i(2784);
            this.mPreparedStatement.bindLong(i2, (long) i3);
            AppMethodBeat.o(2784);
        }

        public void bind(int i2, boolean z) {
            AppMethodBeat.i(2785);
            this.mPreparedStatement.bindLong(i2, z ? 1 : 0);
            AppMethodBeat.o(2785);
        }

        public void bindNull(int i2) {
            AppMethodBeat.i(2786);
            this.mPreparedStatement.bindNull(i2);
            AppMethodBeat.o(2786);
        }

        public void bind(int i2, byte[] bArr) {
            AppMethodBeat.i(2787);
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i2);
                AppMethodBeat.o(2787);
                return;
            }
            this.mPreparedStatement.bindBlob(i2, bArr);
            AppMethodBeat.o(2787);
        }

        public void bind(int i2, String str) {
            AppMethodBeat.i(2788);
            if (str == null) {
                this.mPreparedStatement.bindNull(i2);
                AppMethodBeat.o(2788);
                return;
            }
            this.mPreparedStatement.bindString(i2, str);
            AppMethodBeat.o(2788);
        }

        public long insert(ContentValues contentValues) {
            AppMethodBeat.i(2789);
            long insertInternal = insertInternal(contentValues, false);
            AppMethodBeat.o(2789);
            return insertInternal;
        }

        public long execute() {
            AppMethodBeat.i(2790);
            if (this.mPreparedStatement == null) {
                IllegalStateException illegalStateException = new IllegalStateException("you must prepare this inserter before calling execute");
                AppMethodBeat.o(2790);
                throw illegalStateException;
            }
            try {
                long executeInsert = this.mPreparedStatement.executeInsert();
                this.mPreparedStatement = null;
                AppMethodBeat.o(2790);
                return executeInsert;
            } catch (SQLException e2) {
                Log.e(DatabaseUtils.TAG, "Error executing InsertHelper with table " + this.mTableName, e2);
                this.mPreparedStatement = null;
                AppMethodBeat.o(2790);
                return -1;
            } catch (Throwable th) {
                this.mPreparedStatement = null;
                AppMethodBeat.o(2790);
                throw th;
            }
        }

        public void prepareForInsert() {
            AppMethodBeat.i(2791);
            this.mPreparedStatement = getStatement(false);
            this.mPreparedStatement.clearBindings();
            AppMethodBeat.o(2791);
        }

        public void prepareForReplace() {
            AppMethodBeat.i(2792);
            this.mPreparedStatement = getStatement(true);
            this.mPreparedStatement.clearBindings();
            AppMethodBeat.o(2792);
        }

        public long replace(ContentValues contentValues) {
            AppMethodBeat.i(2793);
            long insertInternal = insertInternal(contentValues, true);
            AppMethodBeat.o(2793);
            return insertInternal;
        }

        public void close() {
            AppMethodBeat.i(2794);
            if (this.mInsertStatement != null) {
                this.mInsertStatement.close();
                this.mInsertStatement = null;
            }
            if (this.mReplaceStatement != null) {
                this.mReplaceStatement.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
            AppMethodBeat.o(2794);
        }
    }

    public static void createDbFromSqlStatements(Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2, String str2) {
        AppMethodBeat.i(2844);
        SQLiteDatabase openOrCreateDatabase = com.tencent.wcdb.support.Context.openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, 0, null);
        String[] split = TextUtils.split(str2, ";\n");
        for (String str3 : split) {
            if (!TextUtils.isEmpty(str3)) {
                openOrCreateDatabase.execSQL(str3);
            }
        }
        openOrCreateDatabase.setVersion(i2);
        openOrCreateDatabase.close();
        AppMethodBeat.o(2844);
    }

    public static void createDbFromSqlStatements(Context context, String str, int i2, String str2) {
        AppMethodBeat.i(2845);
        createDbFromSqlStatements(context, str, null, null, i2, str2);
        AppMethodBeat.o(2845);
    }

    private static int extractSqlCode(String str) {
        AppMethodBeat.i(2846);
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            int charAt = str.charAt(i3);
            if (charAt >= 97 && charAt <= 122) {
                charAt = (charAt - 97) + 65;
            } else if (charAt >= 128) {
                AppMethodBeat.o(2846);
                return 0;
            }
            i2 |= (charAt & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) << (i3 * 8);
        }
        AppMethodBeat.o(2846);
        return i2;
    }

    public static int getSqlStatementType(String str) {
        AppMethodBeat.i(2847);
        String trim = str.trim();
        if (trim.length() < 3) {
            AppMethodBeat.o(2847);
            return 99;
        }
        switch (extractSqlCode(trim)) {
            case 4279873:
            case 5522756:
                AppMethodBeat.o(2847);
                return 9;
            case 4280912:
                AppMethodBeat.o(2847);
                return 7;
            case 4476485:
            case 5066563:
                AppMethodBeat.o(2847);
                return 5;
            case 4477013:
            case 4998468:
            case 5260626:
            case 5459529:
                AppMethodBeat.o(2847);
                return 2;
            case 4543043:
            case 5198404:
            case 5524545:
                AppMethodBeat.o(2847);
                return 8;
            case 4670786:
                AppMethodBeat.o(2847);
                return 4;
            case 4998483:
                AppMethodBeat.o(2847);
                return 1;
            case 5001042:
                AppMethodBeat.o(2847);
                return 6;
            case 5526593:
                AppMethodBeat.o(2847);
                return 3;
            default:
                AppMethodBeat.o(2847);
                return 99;
        }
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(2848);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(2848);
            return strArr2;
        }
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        AppMethodBeat.o(2848);
        return strArr3;
    }

    public static int findRowIdColumnIndex(String[] strArr) {
        AppMethodBeat.i(2849);
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (strArr[i2].equals("_id")) {
                AppMethodBeat.o(2849);
                return i2;
            }
        }
        AppMethodBeat.o(2849);
        return -1;
    }
}
