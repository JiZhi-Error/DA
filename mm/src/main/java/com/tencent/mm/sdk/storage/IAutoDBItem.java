package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class IAutoDBItem implements MDBItem {
    public static final String COL_ROWID = "rowid";
    public static final String FIELD_PREFIX = "field_";
    public static final String SYSTEM_ROWID_FIELD = "rowid";
    private static final String TAG = "MicroMsg.SDK.IAutoDBItem";
    public long systemRowid = -1;

    @Override // com.tencent.mm.sdk.storage.MDBItem
    public abstract void convertFrom(Cursor cursor);

    @Override // com.tencent.mm.sdk.storage.MDBItem
    public abstract ContentValues convertTo();

    /* access modifiers changed from: protected */
    public abstract MAutoDBInfo getDBInfo();

    public static class MAutoDBInfo {
        public Map<String, String> colsMap = new HashMap();
        public String[] columns;
        public Field[] fields;
        public String primaryKey;
        public String sql;

        public MAutoDBInfo() {
            AppMethodBeat.i(158082);
            AppMethodBeat.o(158082);
        }
    }

    public static MAutoDBInfo initAutoDBInfo(Class<?> cls) {
        String str;
        MAutoDBInfo mAutoDBInfo = new MAutoDBInfo();
        LinkedList linkedList = new LinkedList();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            String name = field.getName();
            if (name != null && Modifier.isPublic(modifiers) && !Modifier.isFinal(modifiers)) {
                if (name.startsWith(FIELD_PREFIX)) {
                    str = name.substring(6);
                } else {
                    str = name;
                }
                if (field.isAnnotationPresent(MAutoDBFieldAnnotation.class)) {
                    if (((MAutoDBFieldAnnotation) field.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey() == 1) {
                        mAutoDBInfo.primaryKey = str;
                    }
                } else if (!name.startsWith(FIELD_PREFIX)) {
                }
                if (!Util.isNullOrNil(str)) {
                    if (str.equals("rowid")) {
                        Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
                    }
                    linkedList.add(field);
                }
            }
        }
        mAutoDBInfo.fields = (Field[]) linkedList.toArray(new Field[0]);
        mAutoDBInfo.columns = getFullColumns(mAutoDBInfo.fields);
        mAutoDBInfo.colsMap = getColsMap(mAutoDBInfo.fields);
        mAutoDBInfo.sql = getSql(mAutoDBInfo.fields);
        return mAutoDBInfo;
    }

    private static String[] getFullColumns(Field[] fieldArr) {
        String[] strArr = new String[(fieldArr.length + 1)];
        for (int i2 = 0; i2 < fieldArr.length; i2++) {
            strArr[i2] = getColName(fieldArr[i2]);
            Assert.assertTrue("getFullColumns failed:" + fieldArr[i2].getName(), !Util.isNullOrNil(strArr[i2]));
        }
        strArr[fieldArr.length] = "rowid";
        return strArr;
    }

    private static Map<String, String> getColsMap(Field[] fieldArr) {
        HashMap hashMap = new HashMap();
        for (Field field : fieldArr) {
            String type = CursorFieldHelper.type(field.getType());
            if (type == null) {
                Log.e(TAG, "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String colName = getColName(field);
                if (!Util.isNullOrNil(colName)) {
                    hashMap.put(colName, type);
                }
            }
        }
        return hashMap;
    }

    private static String getSql(Field[] fieldArr) {
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < fieldArr.length) {
            Field field = fieldArr[i3];
            String type = CursorFieldHelper.type(field.getType());
            if (type == null) {
                Log.e(TAG, "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String colName = getColName(field);
                if (!Util.isNullOrNil(colName)) {
                    String str = "";
                    if (field.isAnnotationPresent(MAutoDBFieldAnnotation.class)) {
                        str = " default '" + ((MAutoDBFieldAnnotation) field.getAnnotation(MAutoDBFieldAnnotation.class)).defValue() + "' ";
                        i2 = ((MAutoDBFieldAnnotation) field.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey();
                    } else {
                        i2 = 0;
                    }
                    sb.append(colName + " " + type + str + (i2 == 1 ? " PRIMARY KEY " : ""));
                    sb.append(i3 == fieldArr.length + -1 ? "" : ", ");
                }
            }
            i3++;
        }
        return sb.toString();
    }

    public static String getColName(Field field) {
        String name;
        if (field == null || (name = field.getName()) == null || name.length() <= 0) {
            return null;
        }
        if (name.startsWith(FIELD_PREFIX)) {
            return name.substring(6);
        }
        return name;
    }

    public static Field[] getValidFields(Class<?> cls) {
        return initAutoDBInfo(cls).fields;
    }

    private static boolean checkBlobEqual(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null && bArr2 != null) {
            return false;
        }
        if ((bArr != null && bArr2 == null) || bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIOEqual(ContentValues contentValues, Cursor cursor) {
        if (contentValues == null) {
            return cursor == null;
        }
        if (cursor == null || cursor.getCount() != 1) {
            return false;
        }
        cursor.moveToFirst();
        int columnCount = cursor.getColumnCount();
        int size = contentValues.size();
        if (contentValues.containsKey("rowid")) {
            size--;
        }
        if (cursor.getColumnIndex("rowid") != -1) {
            columnCount--;
        }
        if (size != columnCount) {
            return false;
        }
        try {
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                String key = entry.getKey();
                if (!key.equals("rowid")) {
                    int columnIndex = cursor.getColumnIndex(key);
                    if (columnIndex == -1) {
                        return false;
                    }
                    if (contentValues.get(key) instanceof byte[]) {
                        if (!checkBlobEqual((byte[]) contentValues.get(key), cursor.getBlob(columnIndex))) {
                            return false;
                        }
                    } else if (cursor.getString(columnIndex) == null && contentValues.get(key) != null) {
                        return false;
                    } else {
                        if (contentValues.get(key) == null) {
                            return false;
                        }
                        if (!contentValues.get(key).toString().equals(cursor.getString(columnIndex))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            return false;
        }
    }

    public static Cursor getCursorForProjection(ContentValues contentValues, String[] strArr) {
        Object[] objArr = new Object[strArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            objArr[i2] = contentValues.get(strArr[i2]);
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }
}
