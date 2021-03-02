package com.tencent.mm.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ConfigFileStorageProxyMMKV {
    private final long NRP = 600;
    private final long NRQ = 2;
    boolean NRR;
    private String NRS;
    MultiProcessMMKV cQe;
    private String fileName;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ConfigFileStorageProxyMMKV(java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 293
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ConfigFileStorageProxyMMKV.<init>(java.lang.String):void");
    }

    private String getFileName() {
        AppMethodBeat.i(133241);
        if (TextUtils.isEmpty(this.NRS)) {
            AppMethodBeat.o(133241);
            return "";
        }
        if (TextUtils.isEmpty(this.fileName)) {
            this.fileName = new o(this.NRS).getName();
        }
        String str = this.fileName;
        AppMethodBeat.o(133241);
        return str;
    }

    public final synchronized boolean bX(Map<Integer, Object> map) {
        boolean bZ;
        AppMethodBeat.i(133242);
        if (map == null) {
            bZ = false;
            AppMethodBeat.o(133242);
        } else {
            bZ = bZ(map);
            AppMethodBeat.o(133242);
        }
        return bZ;
    }

    public final synchronized void bY(Map<Integer, Object> map) {
        AppMethodBeat.i(133243);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        map.put(Integer.valueOf((int) TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND), Long.valueOf(currentTimeMillis));
        set(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND, Long.valueOf(currentTimeMillis));
        if (!(this.cQe == null || ((long) map.size()) == this.cQe.count())) {
            akf(24);
            dj(24, null);
        }
        AppMethodBeat.o(133243);
    }

    private synchronized boolean bZ(Map<Integer, Object> map) {
        long j2;
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(133244);
            if (!(this.cQe == null || ((long) map.size()) == this.cQe.count())) {
                Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 size mmkv:%d, cfg:%d", Long.valueOf(this.cQe.count()), Integer.valueOf(map.size()));
                if (map.containsKey(Integer.valueOf((int) TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND)) && !this.cQe.containsKey(Integer.toString(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND))) {
                    Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 mmkv not contain md time key");
                    akf(21);
                    dj(21, null);
                    if (this.cQe.count() != 0) {
                        akf(22);
                        dj(22, null);
                    }
                }
                if (this.cQe.count() != 0) {
                    akf(25);
                    dj(25, null);
                }
            }
            long j3 = getLong(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND, 0);
            Object obj = map.get(Integer.valueOf((int) TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND));
            if (obj instanceof Long) {
                j2 = ((Long) obj).longValue();
            } else {
                j2 = 0;
            }
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(j3 == j2);
            objArr[1] = Long.valueOf(j3);
            objArr[2] = Long.valueOf(this.cQe.count());
            objArr[3] = Long.valueOf(j2);
            objArr[4] = Integer.valueOf(map.size());
            Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 time compare result is [%b], mmkvTime is [%s], size:%d, storageTime is [%s], size:[%d]", objArr);
            if (j3 != j2) {
                long lastModified = 2 + (new o(this.NRS).lastModified() / 1000);
                if (j2 >= j3) {
                    cb(map);
                    if (j3 != 0 || j2 <= 0) {
                        akf(11);
                    } else {
                        akf(7);
                    }
                    a(11, lastModified, j2, j3);
                    z = false;
                } else if (lastModified < j3) {
                    akf(12);
                    a(12, lastModified, j2, j3);
                    cc(map);
                    z = true;
                } else if (lastModified - j3 >= 600) {
                    if (ca(map)) {
                        akf(13);
                        a(13, lastModified, j2, j3);
                    } else {
                        akf(14);
                        a(14, lastModified, j2, j3);
                    }
                    cb(map);
                    z = false;
                } else {
                    akf(15);
                    a(15, lastModified, j2, j3);
                    cc(map);
                    z = true;
                }
                z2 = z;
            } else if (j3 == 0) {
                Object[] objArr2 = new Object[2];
                objArr2[0] = Long.valueOf(this.cQe != null ? this.cQe.count() : 0);
                objArr2[1] = Integer.valueOf(map.size());
                Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmkv has no data, mmkv:%d, cfg:%d", objArr2);
                cb(map);
            } else {
                long lastModified2 = 2 + (new o(this.NRS).lastModified() / 1000);
                if (lastModified2 >= j3) {
                    if (lastModified2 - j3 >= 600) {
                        cb(map);
                        akf(2);
                        a(2, lastModified2, j2, j3);
                    } else if (ca(map)) {
                        akf(3);
                        a(3, lastModified2, j2, j3);
                        cb(map);
                    }
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    map.put(Integer.valueOf((int) TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND), Long.valueOf(currentTimeMillis));
                    set(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND, Long.valueOf(currentTimeMillis));
                } else {
                    akf(1);
                    a(1, lastModified2, j2, j3);
                }
            }
            String formatVersion = ChannelUtil.formatVersion(MMApplicationContext.getContext(), d.KyO, true);
            map.put(100003, formatVersion);
            set(100003, formatVersion);
            if (!this.cQe.containsKey(Integer.toString(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND))) {
                long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                map.put(Integer.valueOf((int) TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND), Long.valueOf(currentTimeMillis2));
                set(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND, Long.valueOf(currentTimeMillis2));
                akf(30);
                dj(30, null);
            }
            AppMethodBeat.o(133244);
        }
        return z2;
    }

    private static boolean ca(Map<Integer, Object> map) {
        AppMethodBeat.i(133245);
        String formatVersion = ChannelUtil.formatVersion(MMApplicationContext.getContext(), d.KyO, true);
        Object obj = map.get(100003);
        String str = obj instanceof String ? (String) obj : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (TextUtils.equals(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.o(133245);
            return false;
        } else if (!TextUtils.equals(formatVersion, str)) {
            AppMethodBeat.o(133245);
            return true;
        } else {
            AppMethodBeat.o(133245);
            return false;
        }
    }

    private void cb(Map<Integer, Object> map) {
        AppMethodBeat.i(133246);
        if (map == null || this.cQe == null) {
            AppMethodBeat.o(133246);
            return;
        }
        this.cQe.clear();
        Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "storageCoverMMKV storage size:[%d]", Integer.valueOf(map.size()));
        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            set(entry.getKey().intValue(), entry.getValue());
        }
        AppMethodBeat.o(133246);
    }

    public final void cc(Map<Integer, Object> map) {
        AppMethodBeat.i(133247);
        if (this.cQe == null || map == null) {
            AppMethodBeat.o(133247);
            return;
        }
        Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmKVCoverStorage storage size:[%d]", Integer.valueOf(map.size()));
        map.clear();
        String[] allKeys = this.cQe.allKeys();
        if (allKeys == null || allKeys.length == 0) {
            AppMethodBeat.o(133247);
            return;
        }
        for (String str : allKeys) {
            try {
                int safeParseInt = Util.safeParseInt(str);
                MMKVTypeObject mMKVTypeObject = (MMKVTypeObject) this.cQe.decodeParcelable(str, MMKVTypeObject.class);
                if (mMKVTypeObject != null) {
                    map.put(Integer.valueOf(safeParseInt), mMKVTypeObject.object);
                } else {
                    Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
                    akf(32);
                    dj(32, null);
                }
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", e2, "NumberFormatException", new Object[0]);
            }
        }
        AppMethodBeat.o(133247);
    }

    public final void akf(int i2) {
        AppMethodBeat.i(133248);
        try {
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 reportData, case is [%s], filename:[%s]", Integer.valueOf(i2), getFileName());
            Log.printInfoStack("MicroMsg.ConfigFileStorageProxyMMKV", "reportIDKeyData stack", new Object[0]);
            e.INSTANCE.idkeyStat(1041, (long) i2, 1, false);
            AppMethodBeat.o(133248);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", th, "reportIDKeyData error", new Object[0]);
            AppMethodBeat.o(133248);
        }
    }

    public final void dj(int i2, String str) {
        AppMethodBeat.i(133249);
        a(null, false, 0, 0, 0, str, null, null, i2, true);
        AppMethodBeat.o(133249);
    }

    private void a(int i2, long j2, long j3, long j4) {
        AppMethodBeat.i(133250);
        a(null, false, j2, j3, j4, null, null, null, i2, false);
        AppMethodBeat.o(133250);
    }

    public final void i(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(133251);
        a(null, false, 0, 0, 0, str, str2, str3, i2, false);
        AppMethodBeat.o(133251);
    }

    private void a(String str, boolean z, long j2, long j3, long j4, String str2, String str3, String str4, int i2, boolean z2) {
        AppMethodBeat.i(133252);
        o oVar = null;
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.NRS)) {
            str = this.NRS;
            oVar = new o(str);
            z = oVar.exists();
        }
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.COMMAND;
        }
        if (j2 == 0 && oVar != null) {
            j2 = oVar.lastModified() / 1000;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = BuildConfig.COMMAND;
        }
        if (str4 == null) {
            str4 = BuildConfig.COMMAND;
        }
        try {
            Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "reportKVData [%s]", String.format("%s,%s,%d,%d,%d,%s,%s,%s,%d,%s,%s", str, String.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str2, str3, str4, Integer.valueOf(i2), Boolean.valueOf(z2), MMApplicationContext.getProcessName()));
            AppMethodBeat.o(133252);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", e2, "reportKVData error", new Object[0]);
            AppMethodBeat.o(133252);
        }
    }

    public final void set(int i2, Object obj) {
        AppMethodBeat.i(133253);
        if (this.cQe == null) {
            AppMethodBeat.o(133253);
            return;
        }
        String valueOf = String.valueOf(i2);
        MMKVTypeObject mMKVTypeObject = new MMKVTypeObject(obj != null ? obj.getClass().getSimpleName() : BuildConfig.COMMAND, obj);
        boolean encode = this.cQe.encode(valueOf, mMKVTypeObject);
        Object obj2 = get(i2, null);
        if (!encode) {
            akf(18);
            dj(18, valueOf);
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "write data fail");
        }
        if (obj2 == null) {
            Object[] objArr = new Object[4];
            objArr[0] = mMKVTypeObject.type;
            objArr[1] = mMKVTypeObject.object;
            objArr[2] = valueOf;
            objArr[3] = obj != null ? obj : BuildConfig.COMMAND;
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "innerObject set get data null, type:[%s], obj:[%s], key:[%s], value:[%s]", objArr);
            Log.printInfoStack("MicroMsg.ConfigFileStorageProxyMMKV", "innerObject stack", new Object[0]);
            if (obj != null) {
                akf(23);
                dj(23, null);
            }
            if (((MMKVTypeObject) this.cQe.decodeParcelable(valueOf, MMKVTypeObject.class)) == null) {
                Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value again, value is null");
                akf(33);
                dj(33, valueOf);
            }
        }
        if (obj != null && !obj.equals(obj2)) {
            akf(20);
            dj(20, valueOf);
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "set get data not equal, type:%s", mMKVTypeObject.type);
        }
        AppMethodBeat.o(133253);
    }

    public final Object get(int i2, Object obj) {
        AppMethodBeat.i(133254);
        if (this.cQe == null) {
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv is null ,return default val");
            akf(31);
            dj(31, null);
            AppMethodBeat.o(133254);
            return obj;
        }
        MMKVTypeObject mMKVTypeObject = (MMKVTypeObject) this.cQe.decodeParcelable(String.valueOf(i2), MMKVTypeObject.class);
        if (mMKVTypeObject != null) {
            Object obj2 = mMKVTypeObject.object;
            AppMethodBeat.o(133254);
            return obj2;
        }
        Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
        akf(32);
        dj(32, null);
        AppMethodBeat.o(133254);
        return obj;
    }

    public final long getLong(int i2, long j2) {
        AppMethodBeat.i(133255);
        Object obj = get(i2, Long.valueOf(j2));
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            AppMethodBeat.o(133255);
            return longValue;
        }
        AppMethodBeat.o(133255);
        return j2;
    }

    public static class MMKVTypeObject implements Parcelable {
        public static final Parcelable.Creator<MMKVTypeObject> CREATOR = new Parcelable.Creator<MMKVTypeObject>() {
            /* class com.tencent.mm.storage.ConfigFileStorageProxyMMKV.MMKVTypeObject.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MMKVTypeObject[] newArray(int i2) {
                return new MMKVTypeObject[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MMKVTypeObject createFromParcel(Parcel parcel) {
                AppMethodBeat.i(133234);
                MMKVTypeObject mMKVTypeObject = new MMKVTypeObject(parcel);
                AppMethodBeat.o(133234);
                return mMKVTypeObject;
            }
        };
        Object object;
        String type;

        public MMKVTypeObject(String str, Object obj) {
            AppMethodBeat.i(133235);
            this.type = str;
            if (obj instanceof LinkedHashMap) {
                this.object = new a(obj);
                AppMethodBeat.o(133235);
                return;
            }
            this.object = obj;
            AppMethodBeat.o(133235);
        }

        protected MMKVTypeObject(Parcel parcel) {
            AppMethodBeat.i(133236);
            try {
                this.type = parcel.readString();
                try {
                    if (!TextUtils.equals(this.type, HashMap.class.getSimpleName()) && !TextUtils.equals(this.type, HashSet.class.getSimpleName())) {
                        TextUtils.equals(this.type, LinkedHashMap.class.getSimpleName());
                    }
                    Object readValue = parcel.readValue(null);
                    if (readValue instanceof a) {
                        this.object = ((a) readValue).obj;
                        AppMethodBeat.o(133236);
                        return;
                    }
                    this.object = readValue;
                    AppMethodBeat.o(133236);
                } catch (Exception e2) {
                    e.INSTANCE.idkeyStat(1041, 44, 1, true);
                    Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", e2, "MMKVTypeObject readValue error", new Object[0]);
                    AppMethodBeat.o(133236);
                }
            } catch (RuntimeException e3) {
                Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", e3, "", new Object[0]);
                AppMethodBeat.o(133236);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(133237);
            try {
                parcel.writeString(this.type);
                parcel.writeValue(this.object);
                AppMethodBeat.o(133237);
            } catch (RuntimeException e2) {
                Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", e2, "", new Object[0]);
                AppMethodBeat.o(133237);
            }
        }

        static {
            AppMethodBeat.i(133239);
            AppMethodBeat.o(133239);
        }

        public String toString() {
            AppMethodBeat.i(133238);
            String str = "type = " + this.type + " object = " + (this.object != null ? this.object.toString() : "");
            AppMethodBeat.o(133238);
            return str;
        }
    }

    public static class a implements Serializable {
        public Object obj;

        public a(Object obj2) {
            this.obj = obj2;
        }
    }
}
