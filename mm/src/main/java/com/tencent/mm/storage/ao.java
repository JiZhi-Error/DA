package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class ao extends MStorageEx {
    private static final Object NRT = new Object();
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private a<Integer> NRU = new a<>("userinfo", "id");
    private a<String> NRV = new a<>("userinfo2", "sid");
    private HashMap<Integer, b> NRW = new HashMap<>();
    private HashMap<String, b> NRX = new HashMap<>();
    private volatile boolean NRY;
    private final Runnable NRZ = new Runnable() {
        /* class com.tencent.mm.storage.ao.AnonymousClass1 */

        public final void run() {
            boolean z;
            int i2;
            HashMap hashMap;
            HashMap hashMap2;
            boolean z2 = true;
            int i3 = 0;
            AppMethodBeat.i(133256);
            SQLiteDatabase gFH = ao.this.iFy != null ? ao.this.iFy.gFH() : null;
            if (gFH == null || !gFH.isOpen()) {
                Log.w("MicroMsg.ConfigStorage", "Skip flushing because database has been closed.");
                AppMethodBeat.o(133256);
                return;
            }
            try {
                gFH.acquireReference();
                gFH.beginTransaction();
                try {
                    Object[] objArr = new Object[3];
                    Object[] objArr2 = new Object[1];
                    synchronized (ao.this) {
                        try {
                            hashMap = ao.this.NRW;
                            hashMap2 = ao.this.NRX;
                            ao.this.NRW = new HashMap();
                            ao.this.NRX = new HashMap();
                            ao.this.NRY = false;
                        } catch (Throwable th) {
                            AppMethodBeat.o(133256);
                            throw th;
                        }
                    }
                    for (Map.Entry entry : hashMap.entrySet()) {
                        b bVar = (b) entry.getValue();
                        if (bVar == null) {
                            objArr2[0] = entry.getKey();
                            gFH.execSQL("DELETE FROM userinfo WHERE id=?;", objArr2);
                        } else {
                            objArr[0] = entry.getKey();
                            objArr[1] = Integer.valueOf(bVar.type);
                            objArr[2] = bVar.iFF;
                            gFH.execSQL("INSERT OR REPLACE INTO userinfo VALUES (?,?,?);", objArr);
                        }
                        i3++;
                    }
                    for (Map.Entry entry2 : hashMap2.entrySet()) {
                        b bVar2 = (b) entry2.getValue();
                        if (bVar2 == null) {
                            objArr2[0] = entry2.getKey();
                            gFH.execSQL("DELETE FROM userinfo2 WHERE sid=?;", objArr2);
                        } else {
                            objArr[0] = entry2.getKey();
                            objArr[1] = Integer.valueOf(bVar2.type);
                            objArr[2] = bVar2.iFF;
                            gFH.execSQL("INSERT OR REPLACE INTO userinfo2 VALUES (?,?,?);", objArr);
                        }
                        i3++;
                    }
                    gFH.setTransactionSuccessful();
                    if (gFH.inTransaction()) {
                        gFH.endTransaction();
                    }
                    gFH.releaseReference();
                    Log.i("MicroMsg.ConfigStorage", "Flushed " + i3 + " entries.");
                    AppMethodBeat.o(133256);
                } catch (RuntimeException e2) {
                    e = e2;
                    z = true;
                    i2 = 0;
                    try {
                        Log.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to flush ConfigStorage", new Object[0]);
                        if (z && gFH.inTransaction()) {
                            gFH.endTransaction();
                        }
                        gFH.releaseReference();
                        Log.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                        AppMethodBeat.o(133256);
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z;
                        gFH.endTransaction();
                        gFH.releaseReference();
                        Log.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                        AppMethodBeat.o(133256);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i2 = 0;
                    if (z2 && gFH.inTransaction()) {
                        gFH.endTransaction();
                    }
                    gFH.releaseReference();
                    Log.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                    AppMethodBeat.o(133256);
                    throw th;
                }
            } catch (RuntimeException e3) {
                e = e3;
                z = false;
                i2 = 0;
                Log.printErrStackTrace("MicroMsg.ConfigStorage", e, "Failed to flush ConfigStorage", new Object[0]);
                gFH.endTransaction();
                gFH.releaseReference();
                Log.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                AppMethodBeat.o(133256);
            } catch (Throwable th4) {
                th = th4;
                z2 = false;
                i2 = 0;
                gFH.endTransaction();
                gFH.releaseReference();
                Log.i("MicroMsg.ConfigStorage", "Flushed " + i2 + " entries.");
                AppMethodBeat.o(133256);
                throw th;
            }
        }
    };
    private h iFy;
    public MMHandler mHandler;

    static {
        AppMethodBeat.i(133280);
        AppMethodBeat.o(133280);
    }

    /* access modifiers changed from: package-private */
    public final class a<K> extends LruCache<K, Object> {
        private final String NSb;

        a(String str, String str2) {
            super(64);
            AppMethodBeat.i(133257);
            this.NSb = "SELECT * FROM " + str + " WHERE " + str2 + "=?;";
            AppMethodBeat.o(133257);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2  */
        @Override // com.tencent.mm.sdk.platformtools.LruCache
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object create(K r9) {
            /*
            // Method dump skipped, instructions count: 212
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ao.a.create(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        final String iFF;
        final int type;

        b(int i2, String str) {
            this.type = i2;
            this.iFF = str;
        }

        static b ec(Object obj) {
            int i2;
            AppMethodBeat.i(133259);
            if (obj instanceof Integer) {
                i2 = 1;
            } else if (obj instanceof Long) {
                i2 = 2;
            } else if (obj instanceof String) {
                i2 = 3;
            } else if (obj instanceof Boolean) {
                i2 = 4;
            } else if (obj instanceof Float) {
                i2 = 5;
            } else if (obj instanceof Double) {
                i2 = 6;
            } else {
                Log.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
                AppMethodBeat.o(133259);
                return null;
            }
            b bVar = new b(i2, obj.toString());
            AppMethodBeat.o(133259);
            return bVar;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(133260);
            if (obj == null) {
                AppMethodBeat.o(133260);
                return false;
            } else if (!(obj instanceof b)) {
                AppMethodBeat.o(133260);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.type != bVar.type) {
                    AppMethodBeat.o(133260);
                    return false;
                } else if (this.iFF != null) {
                    boolean equals = this.iFF.equals(bVar.iFF);
                    AppMethodBeat.o(133260);
                    return equals;
                } else if (bVar.iFF == null) {
                    AppMethodBeat.o(133260);
                    return true;
                } else {
                    AppMethodBeat.o(133260);
                    return false;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final Object bmp() {
            AppMethodBeat.i(133261);
            if (this.iFF == ao.NRT) {
                AppMethodBeat.o(133261);
                return null;
            }
            try {
                switch (this.type) {
                    case 1:
                        Integer valueOf = Integer.valueOf(this.iFF);
                        AppMethodBeat.o(133261);
                        return valueOf;
                    case 2:
                        Long valueOf2 = Long.valueOf(this.iFF);
                        AppMethodBeat.o(133261);
                        return valueOf2;
                    case 3:
                        String str = this.iFF;
                        AppMethodBeat.o(133261);
                        return str;
                    case 4:
                        Boolean valueOf3 = Boolean.valueOf(this.iFF);
                        AppMethodBeat.o(133261);
                        return valueOf3;
                    case 5:
                        Float valueOf4 = Float.valueOf(this.iFF);
                        AppMethodBeat.o(133261);
                        return valueOf4;
                    case 6:
                        Double valueOf5 = Double.valueOf(this.iFF);
                        AppMethodBeat.o(133261);
                        return valueOf5;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ConfigStorage", "exception:%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(133261);
            return null;
        }
    }

    public ao(h hVar) {
        AppMethodBeat.i(133262);
        this.iFy = hVar;
        this.mHandler = new MMHandler("ConfigStorage");
        AppMethodBeat.o(133262);
    }

    public final Object get(int i2) {
        AppMethodBeat.i(259570);
        Object obj = get(i2, (Object) null);
        AppMethodBeat.o(259570);
        return obj;
    }

    public final Object get(int i2, Object obj) {
        AppMethodBeat.i(133264);
        Assert.assertNotNull("db is null", this.iFy);
        Object obj2 = this.NRU.get(Integer.valueOf(i2));
        if (obj2 == null || obj2 == NRT) {
            AppMethodBeat.o(133264);
            return obj;
        }
        AppMethodBeat.o(133264);
        return obj2;
    }

    public final Object i(ar.a aVar) {
        AppMethodBeat.i(259571);
        Object obj = get(aVar, (Object) null);
        AppMethodBeat.o(259571);
        return obj;
    }

    public final Object get(ar.a aVar, Object obj) {
        AppMethodBeat.i(133266);
        if (aVar == null) {
            AppMethodBeat.o(133266);
            return obj;
        }
        String name = aVar.name();
        if (Util.isNullOrNil(name)) {
            AppMethodBeat.o(133266);
            return obj;
        }
        String[] split = name.split("_");
        String str = split[split.length - 1];
        if (str.equals("SYNC")) {
            str = split[split.length - 2];
        }
        Object obj2 = get(name.substring(0, name.lastIndexOf(str) + str.length()), obj);
        if (!a(str, obj2, false)) {
            AppMethodBeat.o(133266);
            return obj;
        }
        AppMethodBeat.o(133266);
        return obj2;
    }

    public final boolean getBoolean(ar.a aVar, boolean z) {
        AppMethodBeat.i(133267);
        Object obj = get(aVar, Boolean.valueOf(z));
        if (obj == null || !(obj instanceof Boolean)) {
            AppMethodBeat.o(133267);
            return z;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        AppMethodBeat.o(133267);
        return booleanValue;
    }

    public final String a(ar.a aVar, String str) {
        AppMethodBeat.i(197177);
        Object obj = get(aVar, str);
        if (obj == null || !(obj instanceof String)) {
            AppMethodBeat.o(197177);
            return str;
        }
        String str2 = (String) obj;
        AppMethodBeat.o(197177);
        return str2;
    }

    public final long a(ar.a aVar, long j2) {
        AppMethodBeat.i(133268);
        Object obj = get(aVar, Long.valueOf(j2));
        if (obj == null || !(obj instanceof Long)) {
            AppMethodBeat.o(133268);
            return j2;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(133268);
        return longValue;
    }

    public final int getInt(ar.a aVar, int i2) {
        AppMethodBeat.i(133269);
        Object obj = get(aVar, Integer.valueOf(i2));
        if (obj == null || !(obj instanceof Integer)) {
            AppMethodBeat.o(133269);
            return i2;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.o(133269);
        return intValue;
    }

    private Object get(String str, Object obj) {
        AppMethodBeat.i(133270);
        Assert.assertNotNull("db is null", this.iFy);
        Object obj2 = this.NRV.get(str);
        if (obj2 == null || obj2 == NRT) {
            AppMethodBeat.o(133270);
            return obj;
        }
        AppMethodBeat.o(133270);
        return obj2;
    }

    public final void set(int i2, Object obj) {
        b ec;
        AppMethodBeat.i(133271);
        Assert.assertNotNull("db is null", this.iFy);
        if (obj == null) {
            obj = NRT;
        }
        if (!obj.equals(this.NRU.put(Integer.valueOf(i2), obj))) {
            if (obj == NRT) {
                ec = null;
            } else {
                ec = b.ec(obj);
                if (ec == null) {
                    AppMethodBeat.o(133271);
                    return;
                }
            }
            synchronized (this) {
                try {
                    this.NRW.put(Integer.valueOf(i2), ec);
                    if (!this.NRY) {
                        this.NRY = true;
                        this.mHandler.postDelayed(this.NRZ, 30000);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(133271);
                    throw th;
                }
            }
            doNotify(obj == NRT ? 5 : 4, this, Integer.valueOf(i2));
        }
        Log.i("MicroMsg.ConfigStorage", "SET: " + i2 + " => " + (obj == NRT ? "(DELETED)" : obj.toString()));
        AppMethodBeat.o(133271);
    }

    public final void set(ar.a aVar, Object obj) {
        boolean z;
        b ec;
        AppMethodBeat.i(133272);
        if (aVar == null) {
            AppMethodBeat.o(133272);
            return;
        }
        String name = aVar.name();
        if (Util.isNullOrNil(name)) {
            AppMethodBeat.o(133272);
            return;
        }
        String[] split = name.split("_");
        String str = split[split.length - 1];
        if (str.equals("SYNC")) {
            str = split[split.length - 2];
            z = true;
        } else {
            z = false;
        }
        if (!a(str, obj, true)) {
            AppMethodBeat.o(133272);
            return;
        }
        String substring = name.substring(0, str.length() + name.lastIndexOf(str));
        if (obj == null) {
            obj = NRT;
        }
        if (!obj.equals(this.NRV.put(substring, obj))) {
            if (obj == NRT) {
                ec = null;
            } else {
                ec = b.ec(obj);
                if (ec == null) {
                    AppMethodBeat.o(133272);
                    return;
                }
            }
            synchronized (this) {
                try {
                    this.NRX.put(substring, ec);
                    if (z) {
                        gBI();
                    } else if (!this.NRY) {
                        this.NRY = true;
                        this.mHandler.postDelayed(this.NRZ, 30000);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(133272);
                    throw th;
                }
            }
            doNotify(obj == NRT ? 5 : 4, this, substring);
        }
        Log.i("MicroMsg.ConfigStorage", "SET: " + substring + " => " + (obj == NRT ? "(DELETED)" : obj.toString()));
        AppMethodBeat.o(133272);
    }

    private static boolean a(String str, Object obj, boolean z) {
        AppMethodBeat.i(133273);
        if (obj == null && z) {
            AppMethodBeat.o(133273);
            return true;
        } else if (str.equals("INT") && (obj instanceof Integer)) {
            AppMethodBeat.o(133273);
            return true;
        } else if (str.equals("LONG") && (obj instanceof Long)) {
            AppMethodBeat.o(133273);
            return true;
        } else if (str.equals("STRING") && (obj instanceof String)) {
            AppMethodBeat.o(133273);
            return true;
        } else if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            AppMethodBeat.o(133273);
            return true;
        } else if (str.equals("FLOAT") && (obj instanceof Float)) {
            AppMethodBeat.o(133273);
            return true;
        } else if (!str.equals("DOUBLE") || !(obj instanceof Double)) {
            if (obj != null && CrashReportFactory.hasDebuger()) {
                Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
            }
            if (z) {
                Log.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
            }
            AppMethodBeat.o(133273);
            return false;
        } else {
            AppMethodBeat.o(133273);
            return true;
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        AppMethodBeat.i(133274);
        if (this.iFy == null || this.iFy.isClose()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.iFy == null ? BuildConfig.COMMAND : Boolean.valueOf(this.iFy.isClose());
            Log.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", objArr);
            AppMethodBeat.o(133274);
            return false;
        }
        AppMethodBeat.o(133274);
        return true;
    }

    public final void gBI() {
        AppMethodBeat.i(133275);
        synchronized (this) {
            try {
                this.mHandler.removeCallbacks(this.NRZ);
                this.mHandler.post(this.NRZ);
                this.NRY = true;
            } catch (Throwable th) {
                AppMethodBeat.o(133275);
                throw th;
            }
        }
        Log.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
        AppMethodBeat.o(133275);
    }

    public final void setInt(int i2, int i3) {
        AppMethodBeat.i(133276);
        set(i2, Integer.valueOf(i3));
        AppMethodBeat.o(133276);
    }

    public final void setLong(int i2, long j2) {
        AppMethodBeat.i(133278);
        set(i2, Long.valueOf(j2));
        AppMethodBeat.o(133278);
    }

    public final int getInt(int i2, int i3) {
        AppMethodBeat.i(133277);
        Integer num = (Integer) get(i2, (Object) null);
        if (num == null) {
            AppMethodBeat.o(133277);
            return i3;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(133277);
        return intValue;
    }

    public final long akg(int i2) {
        AppMethodBeat.i(133279);
        Long l = (Long) get(i2, (Object) null);
        if (l == null) {
            AppMethodBeat.o(133279);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(133279);
        return longValue;
    }
}
