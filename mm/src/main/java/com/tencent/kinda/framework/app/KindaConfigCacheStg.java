package com.tencent.kinda.framework.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.nio.charset.Charset;

public class KindaConfigCacheStg extends MAutoStorage<KindaConfigCacheItem> {
    public static final String SAVE_CHARSET = "ISO-8859-1";
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(KindaConfigCacheItem.info, "KindaConfigCache")};
    public static final String TABLE_NAME = "KindaConfigCache";
    public static final String TAG = "MicroMsg.KindaConfigCacheStg";
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(18410);
        AppMethodBeat.o(18410);
    }

    public KindaConfigCacheStg(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, KindaConfigCacheItem.info, "KindaConfigCache", null);
        this.db = iSQLiteDatabase;
    }

    public Object get(String str, Object obj) {
        AppMethodBeat.i(18393);
        KindaConfigCacheItem impl = getImpl(str);
        if (impl == null) {
            AppMethodBeat.o(18393);
            return obj;
        }
        Object resolveObj = resolveObj(impl.field_type, impl.field_value);
        if (resolveObj != null) {
            AppMethodBeat.o(18393);
            return resolveObj;
        }
        AppMethodBeat.o(18393);
        return obj;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static Object resolveObj(int i2, String str) {
        AppMethodBeat.i(18394);
        switch (i2) {
            case 1:
                try {
                    Integer valueOf = Integer.valueOf(Util.getInt(str, 0));
                    AppMethodBeat.o(18394);
                    return valueOf;
                } catch (Exception e2) {
                    Log.e(TAG, "exception:%s", "");
                    break;
                }
            case 2:
                Long valueOf2 = Long.valueOf(Util.getLong(str, 0));
                AppMethodBeat.o(18394);
                return valueOf2;
            case 3:
                AppMethodBeat.o(18394);
                return str;
            case 4:
                Boolean valueOf3 = Boolean.valueOf(str);
                AppMethodBeat.o(18394);
                return valueOf3;
            case 5:
                Float valueOf4 = Float.valueOf(Util.getFloat(str, 0.0f));
                AppMethodBeat.o(18394);
                return valueOf4;
            case 6:
                Double valueOf5 = Double.valueOf(Util.getDouble(str, 0.0d));
                AppMethodBeat.o(18394);
                return valueOf5;
            case 7:
                byte[] bytes = str.getBytes();
                AppMethodBeat.o(18394);
                return bytes;
        }
        AppMethodBeat.o(18394);
        return null;
    }

    private KindaConfigCacheItem getImpl(String str) {
        AppMethodBeat.i(18395);
        Cursor rawQuery = this.db.rawQuery("select * from KindaConfigCache where key=?", new String[]{str});
        if (rawQuery == null) {
            AppMethodBeat.o(18395);
            return null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(18395);
            return null;
        } else {
            rawQuery.moveToFirst();
            KindaConfigCacheItem kindaConfigCacheItem = new KindaConfigCacheItem();
            kindaConfigCacheItem.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(18395);
            return kindaConfigCacheItem;
        }
    }

    public int getInt(String str) {
        AppMethodBeat.i(18396);
        int intValue = ((Integer) get(str, (Object) 0)).intValue();
        AppMethodBeat.o(18396);
        return intValue;
    }

    public long getLong(String str) {
        AppMethodBeat.i(18397);
        long longValue = ((Long) get(str, (Object) 0L)).longValue();
        AppMethodBeat.o(18397);
        return longValue;
    }

    public String getString(String str) {
        AppMethodBeat.i(18398);
        String str2 = (String) get(str, "");
        AppMethodBeat.o(18398);
        return str2;
    }

    public byte[] getBinary(String str) {
        AppMethodBeat.i(18399);
        byte[] bArr = (byte[]) get(str, new byte[0]);
        AppMethodBeat.o(18399);
        return bArr;
    }

    public void putInt(String str, int i2) {
        AppMethodBeat.i(18400);
        put(str, Integer.valueOf(i2), 1);
        AppMethodBeat.o(18400);
    }

    public void putLong(String str, long j2) {
        AppMethodBeat.i(18401);
        put(str, Long.valueOf(j2), 2);
        AppMethodBeat.o(18401);
    }

    public void putString(String str, String str2) {
        AppMethodBeat.i(18402);
        put(str, str2, 3);
        AppMethodBeat.o(18402);
    }

    public void putBinary(String str, byte[] bArr) {
        AppMethodBeat.i(18403);
        put(str, bArr, 7);
        AppMethodBeat.o(18403);
    }

    public void putInt(String str, int i2, long j2) {
        AppMethodBeat.i(18404);
        put(str, Integer.valueOf(i2), 1, j2);
        AppMethodBeat.o(18404);
    }

    public void putLong(String str, long j2, long j3) {
        AppMethodBeat.i(18405);
        put(str, Long.valueOf(j2), 2, j3);
        AppMethodBeat.o(18405);
    }

    public void putString(String str, String str2, long j2) {
        AppMethodBeat.i(18406);
        put(str, str2, 3, j2);
        AppMethodBeat.o(18406);
    }

    public void putBinary(String str, byte[] bArr, long j2) {
        AppMethodBeat.i(18407);
        put(str, bArr, 7, j2);
        AppMethodBeat.o(18407);
    }

    public void put(String str, Object obj, int i2) {
        AppMethodBeat.i(18408);
        put(str, obj, i2, 0);
        AppMethodBeat.o(18408);
    }

    public void put(String str, Object obj, int i2, long j2) {
        AppMethodBeat.i(18409);
        KindaConfigCacheItem kindaConfigCacheItem = new KindaConfigCacheItem();
        kindaConfigCacheItem.field_type = i2;
        kindaConfigCacheItem.field_key = str;
        kindaConfigCacheItem.field_expire_at = j2;
        if (i2 == 1 && (obj instanceof Integer)) {
            kindaConfigCacheItem.field_value = obj.toString();
        } else if (i2 == 4 && (obj instanceof Integer)) {
            kindaConfigCacheItem.field_value = obj.toString();
        } else if (i2 == 6 && (obj instanceof Double)) {
            kindaConfigCacheItem.field_value = obj.toString();
        } else if (i2 == 5 && (obj instanceof Float)) {
            kindaConfigCacheItem.field_value = obj.toString();
        } else if (i2 == 2 && (obj instanceof Long)) {
            kindaConfigCacheItem.field_value = obj.toString();
        } else if (i2 == 3 && (obj instanceof String)) {
            kindaConfigCacheItem.field_value = obj.toString();
        } else if (i2 != 7 || !(obj instanceof byte[])) {
            AppMethodBeat.o(18409);
            return;
        } else {
            kindaConfigCacheItem.field_value = new String((byte[]) obj, Charset.forName(SAVE_CHARSET));
        }
        replace(kindaConfigCacheItem);
        AppMethodBeat.o(18409);
    }
}
