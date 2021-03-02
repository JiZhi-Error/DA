package com.tencent.mm.wallet_core.c;

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
import java.util.HashMap;
import junit.framework.Assert;

public final class aa extends MStorageEx {
    private static final Object NRT = new Object();
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS walletcache ( sid TEXT PRIMARY KEY, type INT, value TEXT )"};
    private HashMap<Integer, b> NRW = new HashMap<>();
    private HashMap<String, b> NRX = new HashMap<>();
    private volatile boolean NRY;
    private final Runnable NRZ = new Runnable() {
        /* class com.tencent.mm.wallet_core.c.aa.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 404
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.c.aa.AnonymousClass1.run():void");
        }
    };
    private a<String> Ruh = new a<>("walletcache", "sid");
    private h iFy;
    private MMHandler mHandler;

    static {
        AppMethodBeat.i(130945);
        AppMethodBeat.o(130945);
    }

    /* access modifiers changed from: package-private */
    public final class a<K> extends LruCache<K, Object> {
        private final String NSb;

        a(String str, String str2) {
            super(64);
            AppMethodBeat.i(130933);
            this.NSb = "SELECT * FROM " + str + " WHERE " + str2 + "=?;";
            AppMethodBeat.o(130933);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2  */
        @Override // com.tencent.mm.sdk.platformtools.LruCache
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object create(K r9) {
            /*
            // Method dump skipped, instructions count: 212
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.c.aa.a.create(java.lang.Object):java.lang.Object");
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

        static b ev(Object obj) {
            int i2;
            AppMethodBeat.i(130935);
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
                Log.e("MicroMsg.WalletCacheStorage", "unresolve failed, unknown type=" + obj.getClass().toString());
                AppMethodBeat.o(130935);
                return null;
            }
            b bVar = new b(i2, obj.toString());
            AppMethodBeat.o(130935);
            return bVar;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(130936);
            if (obj == null) {
                AppMethodBeat.o(130936);
                return false;
            } else if (!(obj instanceof b)) {
                AppMethodBeat.o(130936);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.type != bVar.type) {
                    AppMethodBeat.o(130936);
                    return false;
                } else if (this.iFF != null) {
                    boolean equals = this.iFF.equals(bVar.iFF);
                    AppMethodBeat.o(130936);
                    return equals;
                } else if (bVar.iFF == null) {
                    AppMethodBeat.o(130936);
                    return true;
                } else {
                    AppMethodBeat.o(130936);
                    return false;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final Object bmp() {
            AppMethodBeat.i(130937);
            if (this.iFF == aa.NRT) {
                AppMethodBeat.o(130937);
                return null;
            }
            try {
                switch (this.type) {
                    case 1:
                        Integer valueOf = Integer.valueOf(this.iFF);
                        AppMethodBeat.o(130937);
                        return valueOf;
                    case 2:
                        Long valueOf2 = Long.valueOf(this.iFF);
                        AppMethodBeat.o(130937);
                        return valueOf2;
                    case 3:
                        String str = this.iFF;
                        AppMethodBeat.o(130937);
                        return str;
                    case 4:
                        Boolean valueOf3 = Boolean.valueOf(this.iFF);
                        AppMethodBeat.o(130937);
                        return valueOf3;
                    case 5:
                        Float valueOf4 = Float.valueOf(this.iFF);
                        AppMethodBeat.o(130937);
                        return valueOf4;
                    case 6:
                        Double valueOf5 = Double.valueOf(this.iFF);
                        AppMethodBeat.o(130937);
                        return valueOf5;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WalletCacheStorage", "exception:%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(130937);
            return null;
        }
    }

    public aa(h hVar) {
        AppMethodBeat.i(130938);
        this.iFy = hVar;
        this.mHandler = new MMHandler("WalletCacheStorage");
        AppMethodBeat.o(130938);
    }

    public final Object get(ar.a aVar, Object obj) {
        AppMethodBeat.i(130939);
        if (aVar == null) {
            AppMethodBeat.o(130939);
            return obj;
        }
        String name = aVar.name();
        if (Util.isNullOrNil(name)) {
            AppMethodBeat.o(130939);
            return obj;
        }
        String[] split = name.split("_");
        String str = split[split.length - 1];
        if (str.equals("SYNC")) {
            str = split[split.length - 2];
        }
        Object obj2 = get(name.substring(0, name.lastIndexOf(str) + str.length()), obj);
        if (!a(str, obj2, false)) {
            AppMethodBeat.o(130939);
            return obj;
        }
        AppMethodBeat.o(130939);
        return obj2;
    }

    private Object get(String str, Object obj) {
        AppMethodBeat.i(130940);
        Assert.assertNotNull("db is null", this.iFy);
        Object obj2 = this.Ruh.get(str);
        if (obj2 == null || obj2 == NRT) {
            AppMethodBeat.o(130940);
            return obj;
        }
        AppMethodBeat.o(130940);
        return obj2;
    }

    public final void set(ar.a aVar, Object obj) {
        boolean z;
        b ev;
        AppMethodBeat.i(130941);
        if (aVar == null) {
            AppMethodBeat.o(130941);
            return;
        }
        String name = aVar.name();
        if (Util.isNullOrNil(name)) {
            AppMethodBeat.o(130941);
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
            AppMethodBeat.o(130941);
            return;
        }
        String substring = name.substring(0, str.length() + name.lastIndexOf(str));
        if (obj == null) {
            obj = NRT;
        }
        if (!obj.equals(this.Ruh.put(substring, obj))) {
            if (obj == NRT) {
                ev = null;
            } else {
                ev = b.ev(obj);
                if (ev == null) {
                    AppMethodBeat.o(130941);
                    return;
                }
            }
            synchronized (this) {
                try {
                    this.NRX.put(substring, ev);
                    if (z) {
                        gBI();
                    } else if (!this.NRY) {
                        this.NRY = true;
                        this.mHandler.postDelayed(this.NRZ, 30000);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(130941);
                    throw th;
                }
            }
            doNotify(obj == NRT ? 5 : 4, this, substring);
        }
        Log.i("MicroMsg.WalletCacheStorage", "SET: " + substring + " => " + (obj == NRT ? "(DELETED)" : obj.toString()));
        AppMethodBeat.o(130941);
    }

    private static boolean a(String str, Object obj, boolean z) {
        AppMethodBeat.i(130942);
        if (obj == null && z) {
            AppMethodBeat.o(130942);
            return true;
        } else if (str.equals("INT") && (obj instanceof Integer)) {
            AppMethodBeat.o(130942);
            return true;
        } else if (str.equals("LONG") && (obj instanceof Long)) {
            AppMethodBeat.o(130942);
            return true;
        } else if (str.equals("STRING") && (obj instanceof String)) {
            AppMethodBeat.o(130942);
            return true;
        } else if (str.equals("BOOLEAN") && (obj instanceof Boolean)) {
            AppMethodBeat.o(130942);
            return true;
        } else if (str.equals("FLOAT") && (obj instanceof Float)) {
            AppMethodBeat.o(130942);
            return true;
        } else if (!str.equals("DOUBLE") || !(obj instanceof Double)) {
            if (obj != null && CrashReportFactory.hasDebuger()) {
                Assert.assertTrue("checkType failed, input type and value[" + str + ", " + obj + "] are not match", false);
            }
            if (z) {
                Log.e("MicroMsg.WalletCacheStorage", "checkType failed, input type and value[%s, %s] are not match", str, obj);
            }
            AppMethodBeat.o(130942);
            return false;
        } else {
            AppMethodBeat.o(130942);
            return true;
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        AppMethodBeat.i(130943);
        if (this.iFy == null || this.iFy.isClose()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.iFy == null ? BuildConfig.COMMAND : Boolean.valueOf(this.iFy.isClose());
            Log.w("MicroMsg.WalletCacheStorage", "shouldProcessEvent db is close :%s", objArr);
            AppMethodBeat.o(130943);
            return false;
        }
        AppMethodBeat.o(130943);
        return true;
    }

    public final void gBI() {
        AppMethodBeat.i(130944);
        synchronized (this) {
            try {
                this.mHandler.removeCallbacks(this.NRZ);
                this.mHandler.post(this.NRZ);
                this.NRY = true;
            } catch (Throwable th) {
                AppMethodBeat.o(130944);
                throw th;
            }
        }
        Log.i("MicroMsg.WalletCacheStorage", "Posted appendAllToDisk");
        AppMethodBeat.o(130944);
    }
}
