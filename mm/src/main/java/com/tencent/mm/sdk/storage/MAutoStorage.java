package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public abstract class MAutoStorage<T extends IAutoDBItem> extends MStorage implements IAutoStorage<T> {
    private static final String TAG = "MicroMsg.SDK.MAutoStorage";
    private final ISQLiteDatabase db;
    private final IAutoDBItem.MAutoDBInfo dbInfo;
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private final String table;

    public MAutoStorage(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str, String[] strArr) {
        this.db = iSQLiteDatabase;
        this.dbInfo = mAutoDBInfo;
        this.dbInfo.primaryKey = Util.isNullOrNil(this.dbInfo.primaryKey) ? "rowid" : this.dbInfo.primaryKey;
        this.table = str;
        updateColumnSQLs(strArr);
    }

    public String getTableName() {
        return this.table;
    }

    public String getPrimaryKey() {
        return this.dbInfo.primaryKey;
    }

    public static String getCreateSQLs(IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        sb.append(mAutoDBInfo.sql);
        sb.append(");");
        return sb.toString();
    }

    public static List<String> getUpdateSQLs(IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str, ISQLiteDatabase iSQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (iSQLiteDatabase == null || str == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(iSQLiteDatabase == null);
            objArr[1] = str;
            Log.e(TAG, "dk getUpdateSQLs db==null :%b  table:%s", objArr);
            return arrayList;
        }
        Cursor rawQuery = iSQLiteDatabase.rawQuery("PRAGMA table_info( " + str + " )", new String[0], 2);
        if (rawQuery == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int columnIndex = rawQuery.getColumnIndex("name");
        int columnIndex2 = rawQuery.getColumnIndex("type");
        while (rawQuery.moveToNext()) {
            hashMap.put(rawQuery.getString(columnIndex), rawQuery.getString(columnIndex2));
        }
        rawQuery.close();
        for (Map.Entry<String, String> entry : mAutoDBInfo.colsMap.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (value != null && value.length() > 0) {
                String str2 = (String) hashMap.get(key);
                if (str2 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + key + " " + value + ";");
                    hashMap.remove(key);
                } else if (!value.toLowerCase().startsWith(str2.toLowerCase())) {
                    Log.e(TAG, "conflicting alter table on column: " + key + ", " + str2 + "<o-n>" + value);
                    hashMap.remove(key);
                }
            }
        }
        return arrayList;
    }

    private void updateColumnSQLs(String[] strArr) {
        List<String> updateSQLs = getUpdateSQLs(this.dbInfo, getTableName(), this.db);
        for (int i2 = 0; i2 < updateSQLs.size(); i2++) {
            if (!this.db.execSQL(this.table, updateSQLs.get(i2))) {
                Log.i(TAG, "updateColumnSQLs table failed %s, sql %s", this.table, updateSQLs.get(i2));
            }
        }
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                this.db.execSQL(this.table, str);
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean execSQL(String str, String str2) {
        if (str == null || str.length() == 0) {
            LOGE("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.db.execSQL(str, str2);
        } else {
            LOGE("null or nill sql");
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean insert(T t) {
        return insertNotify(t, true);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean insertNotify(T t, boolean z) {
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            LOGE("insert failed, value.size <= 0");
            return false;
        }
        t.systemRowid = this.db.insert(getTableName(), this.dbInfo.primaryKey, convertTo);
        if (t.systemRowid <= 0) {
            LOGE("insert failed");
            return false;
        }
        convertTo.put("rowid", Long.valueOf(t.systemRowid));
        if (z) {
            doNotify(convertTo.getAsString(this.dbInfo.primaryKey));
        }
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean delete(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            LOGE("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            LOGD("delete with primary key");
            if (this.db.delete(getTableName(), this.dbInfo.primaryKey + " = ?", new String[]{Util.nullAsNil(convertTo.getAsString(this.dbInfo.primaryKey))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder checkKeysWithValues = checkKeysWithValues(convertTo, strArr);
            if (checkKeysWithValues == null) {
                LOGE("delete failed, check keys failed");
                return false;
            } else if (this.db.delete(getTableName(), checkKeysWithValues.toString(), valuesFromKeys(strArr, convertTo)) <= 0 || !z) {
                LOGE("delete failed");
                return false;
            } else {
                doNotify(this.dbInfo.primaryKey);
                return true;
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean delete(T t, String... strArr) {
        return delete(t, true, strArr);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean deleteNotify(long j2, boolean z) {
        boolean z2 = true;
        if (this.db.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j2)}) <= 0) {
            z2 = false;
        }
        if (z2 && z) {
            doNotify();
        }
        return z2;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean delete(long j2) {
        return deleteNotify(j2, true);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean get(long j2, T t) {
        Cursor query = this.db.query(getTableName(), this.dbInfo.columns, "rowid = ?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            t.convertFrom(query);
            query.close();
            return true;
        }
        query.close();
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean get(T t, String... strArr) {
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            LOGE("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            LOGD("get with primary key");
            Cursor query = this.db.query(getTableName(), this.dbInfo.columns, this.dbInfo.primaryKey + " = ?", new String[]{Util.nullAsNil(convertTo.getAsString(this.dbInfo.primaryKey))}, null, null, null, 2);
            if (query.moveToFirst()) {
                t.convertFrom(query);
                query.close();
                return true;
            }
            query.close();
            return false;
        } else {
            StringBuilder checkKeysWithValues = checkKeysWithValues(convertTo, strArr);
            if (checkKeysWithValues == null) {
                LOGE("get failed, check keys failed");
                return false;
            }
            Cursor query2 = this.db.query(getTableName(), this.dbInfo.columns, checkKeysWithValues.toString(), valuesFromKeys(strArr, convertTo), null, null, null, 2);
            if (query2.moveToFirst()) {
                t.convertFrom(query2);
                query2.close();
                return true;
            }
            query2.close();
            LOGD("get failed, not found");
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean update(long j2, T t, boolean z) {
        boolean z2;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            LOGE("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.db.query(getTableName(), this.dbInfo.columns, "rowid = ?", new String[]{String.valueOf(j2)}, null, null, null);
        if (IAutoDBItem.checkIOEqual(convertTo, query)) {
            query.close();
            LOGD("no need replace , fields no change");
            return true;
        }
        query.close();
        if (this.db.update(getTableName(), convertTo, "rowid = ?", new String[]{String.valueOf(j2)}) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !z) {
            return z2;
        }
        doNotify();
        return z2;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean update(long j2, T t) {
        return update(j2, t, true);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean updateNotify(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            LOGE("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            LOGD("update with primary key");
            if (checkOld(convertTo)) {
                LOGD("no need replace , fields no change");
                return true;
            }
            if (this.db.update(getTableName(), convertTo, this.dbInfo.primaryKey + " = ?", new String[]{Util.nullAsNil(convertTo.getAsString(this.dbInfo.primaryKey))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder checkKeysWithValues = checkKeysWithValues(convertTo, strArr);
            if (checkKeysWithValues == null) {
                LOGE("update failed, check keys failed");
                return false;
            } else if (this.db.update(getTableName(), convertTo, checkKeysWithValues.toString(), valuesFromKeys(strArr, convertTo)) > 0) {
                if (z) {
                    doNotify(convertTo.getAsString(this.dbInfo.primaryKey));
                }
                return true;
            } else {
                LOGE("update failed");
                return false;
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean update(T t, String... strArr) {
        return updateNotify(t, true, strArr);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public boolean replace(T t) {
        return replace(t, true);
    }

    public boolean replace(T t, boolean z) {
        int i2;
        boolean z2 = false;
        Assert.assertTrue("replace primaryKey == null", !Util.isNullOrNil(this.dbInfo.primaryKey));
        ContentValues convertTo = t.convertTo();
        if (convertTo != null) {
            int size = convertTo.size();
            int length = t.getDBInfo().fields.length;
            if (convertTo.containsKey("rowid")) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (size == i2 + length) {
                if (checkOld(convertTo)) {
                    LOGD("no need replace , fields no change");
                    return true;
                }
                t.systemRowid = this.db.replace(getTableName(), this.dbInfo.primaryKey, convertTo);
                if (t.systemRowid > 0) {
                    z2 = true;
                }
                if (!z2 || !z) {
                    if (!z2) {
                        LOGE("replace failed");
                    }
                    return z2;
                }
                doNotify(this.dbInfo.primaryKey);
                return true;
            }
        }
        LOGE("replace failed, cv.size() != item.fields().length");
        return false;
    }

    private boolean checkOld(ContentValues contentValues) {
        Cursor query = this.db.query(getTableName(), this.dbInfo.columns, this.dbInfo.primaryKey + " = ?", new String[]{Util.nullAsNil(contentValues.getAsString(this.dbInfo.primaryKey))}, null, null, null);
        boolean checkIOEqual = IAutoDBItem.checkIOEqual(contentValues, query);
        query.close();
        return checkIOEqual;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public Cursor getAll() {
        return this.db.query(getTableName(), this.dbInfo.columns, null, null, null, null, null);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        return i2;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoStorage
    public Cursor rawQuery(String str, String... strArr) {
        return this.db.rawQuery(str, strArr);
    }

    private static StringBuilder checkKeysWithValues(ContentValues contentValues, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        sb.append(" 1=1");
        return sb;
    }

    private static String[] valuesFromKeys(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            strArr2[i2] = Util.nullAsNil(contentValues.getAsString(strArr[i2]));
        }
        return strArr2;
    }

    private void LOGD(String str) {
        Log.d(TAG, getTableName() + ":" + str);
    }

    private void LOGE(String str) {
        Log.e(TAG, getTableName() + ":" + str);
    }
}
