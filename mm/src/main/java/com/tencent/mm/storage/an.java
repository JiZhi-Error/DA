package com.tencent.mm.storage;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class an {
    public volatile boolean NRI = false;
    public volatile boolean NRJ = false;
    private volatile boolean NRK = false;
    private volatile boolean NRL = false;
    private boolean NRM = true;
    protected ConfigFileStorageProxyMMKV NRN;
    private Runnable dQN = new Runnable() {
        /* class com.tencent.mm.storage.an.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(133219);
            an.this.gBH();
            AppMethodBeat.o(133219);
        }
    };
    private String filePath = "";
    private boolean gHN = false;
    private volatile Map<Integer, Object> values;

    public an(String str) {
        AppMethodBeat.i(133220);
        if (!new File(str).exists()) {
            Log.e("MicroMsg.ConfigFileStorage", "ConfigFileStorage not exit path[%s]", str);
        }
        Log.d("MicroMsg.ConfigFileStorage", "ConfigFileStorage path is [%s],needCheckData:[%b]", str, Boolean.TRUE);
        this.filePath = str;
        this.NRM = true;
        if (!TextUtils.isEmpty(this.filePath)) {
            this.NRN = new ConfigFileStorageProxyMMKV(this.filePath);
        }
        gBG();
        this.gHN = false;
        AppMethodBeat.o(133220);
    }

    /* access modifiers changed from: protected */
    public final boolean gBE() {
        return this.NRN != null && this.NRN.NRR;
    }

    public final synchronized void set(int i2, Object obj) {
        AppMethodBeat.i(133221);
        this.NRL = true;
        if (gBE()) {
            this.NRN.set(i2, obj);
        }
        if (this.values != null) {
            this.values.put(Integer.valueOf(i2), obj);
        }
        if (!this.gHN) {
            aom();
        }
        AppMethodBeat.o(133221);
    }

    public final synchronized Object get(int i2) {
        Object obj;
        AppMethodBeat.i(133222);
        Object obj2 = this.values.get(Integer.valueOf(i2));
        if (gBE()) {
            obj = this.NRN.get(i2, null);
            if (!Objects.equals(obj2, obj)) {
                this.NRN.akf(16);
                this.NRN.i(16, String.valueOf(i2), String.valueOf(obj2), String.valueOf(obj));
                this.values.put(Integer.valueOf(i2), obj);
            }
            AppMethodBeat.o(133222);
        } else {
            AppMethodBeat.o(133222);
            obj = obj2;
        }
        return obj;
    }

    public final synchronized Object get(int i2, Object obj) {
        AppMethodBeat.i(133223);
        Object obj2 = this.values.get(Integer.valueOf(i2));
        if (gBE()) {
            Object obj3 = this.NRN.get(i2, obj);
            if (!Objects.equals(obj2, obj3)) {
                this.NRN.akf(17);
                this.NRN.i(17, String.valueOf(i2), String.valueOf(obj2), String.valueOf(obj3));
                this.values.put(Integer.valueOf(i2), obj3);
            }
            if (obj3 == null) {
                AppMethodBeat.o(133223);
            } else {
                AppMethodBeat.o(133223);
                obj = obj3;
            }
        } else if (obj2 == null) {
            AppMethodBeat.o(133223);
        } else {
            AppMethodBeat.o(133223);
            obj = obj2;
        }
        return obj;
    }

    public final synchronized void setInt(int i2, int i3) {
        AppMethodBeat.i(133224);
        set(i2, Integer.valueOf(i3));
        AppMethodBeat.o(133224);
    }

    public final synchronized int ake(int i2) {
        int i3;
        AppMethodBeat.i(133225);
        if (gBE()) {
            Object obj = this.NRN.get(i2, 0);
            if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
                AppMethodBeat.o(133225);
            } else {
                AppMethodBeat.o(133225);
                i3 = 0;
            }
        } else {
            Object obj2 = get(i2, 0);
            if (obj2 instanceof Integer) {
                i3 = ((Integer) obj2).intValue();
                AppMethodBeat.o(133225);
            } else {
                AppMethodBeat.o(133225);
                i3 = 0;
            }
        }
        return i3;
    }

    public final synchronized void setLong(int i2, long j2) {
        AppMethodBeat.i(133226);
        set(i2, Long.valueOf(j2));
        AppMethodBeat.o(133226);
    }

    public synchronized long getLong(int i2, long j2) {
        AppMethodBeat.i(133227);
        if (gBE()) {
            j2 = this.NRN.getLong(i2, j2);
            AppMethodBeat.o(133227);
        } else {
            Object obj = get(i2, Long.valueOf(j2));
            if (obj instanceof Long) {
                j2 = ((Long) obj).longValue();
                AppMethodBeat.o(133227);
            } else {
                AppMethodBeat.o(133227);
            }
        }
        return j2;
    }

    public final synchronized void lockWrite() {
        this.gHN = true;
    }

    public final synchronized void gBF() {
        AppMethodBeat.i(133228);
        this.gHN = false;
        aom();
        AppMethodBeat.o(133228);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007f A[Catch:{ all -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0097 A[SYNTHETIC, Splitter:B:20:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c A[Catch:{ Exception -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0128 A[SYNTHETIC, Splitter:B:51:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012d A[Catch:{ Exception -> 0x0137 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void gBG() {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.an.gBG():void");
    }

    private synchronized void aom() {
        AppMethodBeat.i(133230);
        if (!gBE()) {
            gBH();
            AppMethodBeat.o(133230);
        } else {
            if (gBE() && this.NRM) {
                this.NRN.bY(this.values);
            }
            h.RTc.bqo(Integer.toString(hashCode()));
            h.RTc.a(this.dQN, 100, Integer.toString(hashCode()));
            AppMethodBeat.o(133230);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A[Catch:{ all -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f A[SYNTHETIC, Splitter:B:39:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a4 A[Catch:{ Exception -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd A[SYNTHETIC, Splitter:B:52:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e2 A[Catch:{ Exception -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0131 A[SYNTHETIC, Splitter:B:65:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0136 A[Catch:{ Exception -> 0x0141 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014f A[SYNTHETIC, Splitter:B:75:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0154 A[Catch:{ Exception -> 0x015e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void gBH() {
        /*
        // Method dump skipped, instructions count: 376
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.an.gBH():void");
    }

    public final synchronized void reset() {
        AppMethodBeat.i(133232);
        Log.i("MicroMsg.ConfigFileStorage", "ConfigFileStorage reset ");
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
        this.values = new HashMap();
        if (gBE()) {
            ConfigFileStorageProxyMMKV configFileStorageProxyMMKV = this.NRN;
            if (configFileStorageProxyMMKV.cQe != null) {
                configFileStorageProxyMMKV.cQe.clearAll();
            }
            this.NRN.akf(36);
            this.NRN.dj(36, null);
        }
        AppMethodBeat.o(133232);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(133233);
        super.finalize();
        if (this.NRK && this.NRL && this.NRN != null) {
            this.NRN.akf(27);
            this.NRN.dj(27, null);
        }
        AppMethodBeat.o(133233);
    }
}
