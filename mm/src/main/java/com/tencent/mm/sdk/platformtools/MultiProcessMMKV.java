package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.a;
import com.tencent.mmkv.b;
import com.tencent.mmkv.c;
import com.tencent.mmkv.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.Map;
import java.util.Set;

public class MultiProcessMMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final String DEFAULT_MULTI_NAME = "MULTIPROCESSMMKV_MULTI_DEFAULT";
    private static final String DEFAULT_SINGLE_NAME = "MULTIPROCESSMMKV_SINGLE_DEFAULT";
    private static final int IDKEY_MMKV = 941;
    private static final int KVID_MMKV = 18378;
    public static final int MULTI_PROCESS_MODE = 2;
    private static final String PERSERVED_NAME = "MULTIPROCESSMMKV_PERSERVED_NAME";
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final String TAG = "MicroMsg.MultiProcessMMKV";
    private static ArrayMap<String, MultiProcessMMKV> mmkvCache = new ArrayMap<>();
    private MMKV mmkv;
    private String name;

    static {
        AppMethodBeat.i(156304);
        MMKV.class.getClassLoader();
        j.Ed("mmkv");
        MMKV.initialize(MMApplicationContext.getContext());
        MMKV.registerHandler(new a() {
            /* class com.tencent.mm.sdk.platformtools.MultiProcessMMKV.AnonymousClass1 */

            @Override // com.tencent.mmkv.a
            public final c onMMKVCRCCheckFail(String str) {
                AppMethodBeat.i(156250);
                Log.i(MultiProcessMMKV.TAG, "onMMKVCRCCheckFail:%s", str);
                e.INSTANCE.idkeyStat(941, 3, 1, true);
                c cVar = c.OnErrorDiscard;
                AppMethodBeat.o(156250);
                return cVar;
            }

            @Override // com.tencent.mmkv.a
            public final c onMMKVFileLengthError(String str) {
                AppMethodBeat.i(156251);
                Log.i(MultiProcessMMKV.TAG, "onMMKVFileLengthError:%s", str);
                e.INSTANCE.idkeyStat(941, 4, 1, true);
                c cVar = c.OnErrorDiscard;
                AppMethodBeat.o(156251);
                return cVar;
            }

            @Override // com.tencent.mmkv.a
            public final boolean wantLogRedirecting() {
                return true;
            }

            @Override // com.tencent.mmkv.a
            public final void mmkvLog(b bVar, String str, int i2, String str2, String str3) {
                AppMethodBeat.i(215398);
                Log.i("MMKV", "[%s][%d][%s] %s", str, Integer.valueOf(i2), str2, str3);
                AppMethodBeat.o(215398);
            }
        });
        AppMethodBeat.o(156304);
    }

    public static void init() {
    }

    public static int transport2MMKV(SharedPreferences sharedPreferences, MultiProcessMMKV multiProcessMMKV) {
        boolean decodeBool;
        AppMethodBeat.i(156253);
        if (sharedPreferences == null || multiProcessMMKV == null) {
            AppMethodBeat.o(156253);
            return 0;
        }
        String name2 = multiProcessMMKV.getName();
        if (Util.isNullOrNil(name2)) {
            AppMethodBeat.o(156253);
            return 0;
        }
        MultiProcessMMKV perservedMMKV = getPerservedMMKV();
        Log.i(TAG, "transport2MMKV, name : %s", name2);
        try {
            decodeBool = perservedMMKV.decodeBool(name2, false);
        } catch (Throwable th) {
            ensureSoLoaded();
            decodeBool = perservedMMKV.decodeBool(name2, false);
        }
        if (decodeBool) {
            Log.i(TAG, "transport2MMKV has Done");
            AppMethodBeat.o(156253);
            return 0;
        }
        perservedMMKV.encode(name2, true);
        int transport2MMKVByForce = transport2MMKVByForce(sharedPreferences, multiProcessMMKV);
        AppMethodBeat.o(156253);
        return transport2MMKVByForce;
    }

    public static int transport2MMKVByForce(SharedPreferences sharedPreferences, MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(215399);
        e.INSTANCE.idkeyStat(941, 2, 1, true);
        int importFromSharedPreferences = multiProcessMMKV.importFromSharedPreferences(sharedPreferences);
        AppMethodBeat.o(215399);
        return importFromSharedPreferences;
    }

    private MultiProcessMMKV(String str, MMKV mmkv2) {
        this.mmkv = mmkv2;
        this.name = str;
    }

    private MultiProcessMMKV(String str) {
        this.name = str;
    }

    private MMKV getCoreMMKV() {
        return this.mmkv;
    }

    private String getName() {
        return this.name;
    }

    public static MultiProcessMMKV getMMKV(String str) {
        AppMethodBeat.i(156254);
        MultiProcessMMKV mmkv2 = getMMKV(str, 2, null);
        AppMethodBeat.o(156254);
        return mmkv2;
    }

    public static MultiProcessMMKV getCryptMMKV(String str, String str2) {
        AppMethodBeat.i(215400);
        MultiProcessMMKV cryptMMKVReal = getCryptMMKVReal(str, 2, str2);
        AppMethodBeat.o(215400);
        return cryptMMKVReal;
    }

    public static MultiProcessMMKV getSingleCryptMMKV(String str, String str2) {
        AppMethodBeat.i(215401);
        MultiProcessMMKV cryptMMKVReal = getCryptMMKVReal(str, 1, str2);
        AppMethodBeat.o(215401);
        return cryptMMKVReal;
    }

    public static MultiProcessMMKV getCryptMMKVReal(String str, int i2, String str2) {
        AppMethodBeat.i(215402);
        MultiProcessMMKV multiProcessMMKV = new MultiProcessMMKV(str, MMKV.mmkvWithID(str, i2, str2));
        AppMethodBeat.o(215402);
        return multiProcessMMKV;
    }

    public static MultiProcessMMKV getDefault() {
        AppMethodBeat.i(215403);
        MultiProcessMMKV mmkv2 = getMMKV(DEFAULT_MULTI_NAME, 2, MMKV.defaultMMKV());
        AppMethodBeat.o(215403);
        return mmkv2;
    }

    public static MultiProcessMMKV getDefault(int i2, String str) {
        AppMethodBeat.i(215404);
        MMKV defaultMMKV = MMKV.defaultMMKV(i2, str);
        if (i2 == 2) {
            MultiProcessMMKV mmkv2 = getMMKV(DEFAULT_MULTI_NAME, i2, defaultMMKV);
            AppMethodBeat.o(215404);
            return mmkv2;
        }
        MultiProcessMMKV mmkv3 = getMMKV(DEFAULT_SINGLE_NAME, i2, defaultMMKV);
        AppMethodBeat.o(215404);
        return mmkv3;
    }

    public static MultiProcessMMKV getSingleDefault() {
        AppMethodBeat.i(156255);
        MultiProcessMMKV mmkv2 = getMMKV(DEFAULT_SINGLE_NAME, 1, MMKV.defaultMMKV());
        AppMethodBeat.o(156255);
        return mmkv2;
    }

    public static MultiProcessMMKV getMultiDefault() {
        AppMethodBeat.i(156256);
        MultiProcessMMKV mmkv2 = getMMKV(DEFAULT_MULTI_NAME, 2, MMKV.defaultMMKV(2, null));
        AppMethodBeat.o(156256);
        return mmkv2;
    }

    public static MultiProcessMMKV getMMKVWithAshmemFD(Context context, String str, int i2, int i3, String str2) {
        AppMethodBeat.i(215405);
        MultiProcessMMKV mmkv2 = getMMKV(str, i3, MMKV.mmkvWithAshmemID(context, str, i2, i3, str2));
        AppMethodBeat.o(215405);
        return mmkv2;
    }

    public static MultiProcessMMKV getMMKVWithAshmemFD(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(215406);
        MultiProcessMMKV mmkv2 = getMMKV(str, -1, MMKV.mmkvWithAshmemFD(str, i2, i3, str2));
        AppMethodBeat.o(215406);
        return mmkv2;
    }

    public static MultiProcessMMKV getSingleMMKV(String str) {
        AppMethodBeat.i(156257);
        MultiProcessMMKV mmkv2 = getMMKV(str, 1, null);
        AppMethodBeat.o(156257);
        return mmkv2;
    }

    public static MultiProcessMMKV getMMKV(String str, int i2) {
        AppMethodBeat.i(156258);
        MultiProcessMMKV mmkv2 = getMMKV(str, i2, null);
        AppMethodBeat.o(156258);
        return mmkv2;
    }

    private static MultiProcessMMKV getMMKV(String str, int i2, MMKV mmkv2) {
        AppMethodBeat.i(156259);
        if (Util.isNullOrNil(str) || Util.isEqual(str, PERSERVED_NAME)) {
            Log.i(TAG, "getMMKV name is illegal");
            AppMethodBeat.o(156259);
            return null;
        }
        MultiProcessMMKV mMKVReal = getMMKVReal(str, i2, mmkv2);
        AppMethodBeat.o(156259);
        return mMKVReal;
    }

    private static MultiProcessMMKV getMMKVReal(String str, int i2, MMKV mmkv2) {
        MultiProcessMMKV multiProcessMMKV;
        AppMethodBeat.i(156260);
        synchronized (MultiProcessMMKV.class) {
            try {
                multiProcessMMKV = mmkvCache.get(str);
                if (multiProcessMMKV == null) {
                    if (mmkv2 == null) {
                        multiProcessMMKV = new MultiProcessMMKV(str, MMKV.mmkvWithID(str, i2));
                    } else {
                        multiProcessMMKV = new MultiProcessMMKV(str, mmkv2);
                    }
                    long j2 = multiProcessMMKV.totalSize();
                    if (j2 > 1048576) {
                        Log.e(TAG, "MMKV file is too big, name : %s, size : %d, please contact with leafjia", str, Long.valueOf(j2));
                        reportTotalSize(j2, str);
                        if (j2 > 5242880) {
                            e.INSTANCE.idkeyStat(941, 100, 1, true);
                            Log.i(TAG, "start to trim, before size : %d", Long.valueOf(j2));
                            multiProcessMMKV.trim();
                            Log.i(TAG, "trim is over, after size : %d", Long.valueOf(multiProcessMMKV.totalSize()));
                        }
                    }
                    mmkvCache.put(str, multiProcessMMKV);
                } else {
                    AppMethodBeat.o(156260);
                }
            } finally {
                AppMethodBeat.o(156260);
            }
        }
        return multiProcessMMKV;
    }

    private static MultiProcessMMKV getPerservedMMKV() {
        AppMethodBeat.i(215407);
        MultiProcessMMKV mMKVReal = getMMKVReal(PERSERVED_NAME, 2, null);
        AppMethodBeat.o(215407);
        return mMKVReal;
    }

    public static MultiProcessMMKV getMMKVWithTransportByName(String str) {
        AppMethodBeat.i(156261);
        MultiProcessMMKV mmkv2 = getMMKV(str);
        transport2MMKV(MMApplicationContext.getContext().getSharedPreferences(str, 4), mmkv2);
        AppMethodBeat.o(156261);
        return mmkv2;
    }

    private static void reportTotalSize(long j2, String str) {
        AppMethodBeat.i(215408);
        if (j2 <= 5242880) {
            e.INSTANCE.idkeyStat(941, 10, 1, true);
        } else if (j2 <= 10485760) {
            e.INSTANCE.idkeyStat(941, 11, 1, true);
        } else if (j2 <= DownloadHelper.SAVE_LENGTH) {
            e.INSTANCE.idkeyStat(941, 12, 1, true);
        } else {
            e.INSTANCE.idkeyStat(941, 13, 1, true);
        }
        e.INSTANCE.a(KVID_MMKV, str, Long.valueOf(j2));
        AppMethodBeat.o(215408);
    }

    public int getValueActualSize(String str) {
        AppMethodBeat.i(215409);
        int valueActualSize = this.mmkv.getValueActualSize(str);
        AppMethodBeat.o(215409);
        return valueActualSize;
    }

    public boolean encode(String str, String str2) {
        AppMethodBeat.i(156262);
        if (!isLegal(str, str2)) {
            AppMethodBeat.o(156262);
            return false;
        }
        boolean encode = this.mmkv.encode(str, str2);
        AppMethodBeat.o(156262);
        return encode;
    }

    public boolean encode(String str, int i2) {
        AppMethodBeat.i(156263);
        if (!isLegal(str, Integer.valueOf(i2))) {
            AppMethodBeat.o(156263);
            return false;
        }
        boolean encode = this.mmkv.encode(str, i2);
        AppMethodBeat.o(156263);
        return encode;
    }

    public boolean encode(String str, long j2) {
        AppMethodBeat.i(156264);
        if (!isLegal(str, Long.valueOf(j2))) {
            AppMethodBeat.o(156264);
            return false;
        }
        boolean encode = this.mmkv.encode(str, j2);
        AppMethodBeat.o(156264);
        return encode;
    }

    public boolean encode(String str, float f2) {
        AppMethodBeat.i(215410);
        if (!isLegal(str, Float.valueOf(f2))) {
            AppMethodBeat.o(215410);
            return false;
        }
        boolean encode = this.mmkv.encode(str, f2);
        AppMethodBeat.o(215410);
        return encode;
    }

    public boolean encode(String str, double d2) {
        AppMethodBeat.i(215411);
        if (!isLegal(str, Double.valueOf(d2))) {
            AppMethodBeat.o(215411);
            return false;
        }
        boolean encode = this.mmkv.encode(str, d2);
        AppMethodBeat.o(215411);
        return encode;
    }

    public boolean encode(String str, boolean z) {
        boolean encode;
        AppMethodBeat.i(156265);
        if (!isLegal(str, Boolean.valueOf(z))) {
            AppMethodBeat.o(156265);
            return false;
        }
        try {
            encode = this.mmkv.encode(str, z);
        } catch (Throwable th) {
            ensureSoLoaded();
            encode = this.mmkv.encode(str, z);
        }
        AppMethodBeat.o(156265);
        return encode;
    }

    public boolean encode(String str, Set<String> set) {
        AppMethodBeat.i(156266);
        if (!isLegal(str, set)) {
            AppMethodBeat.o(156266);
            return false;
        }
        boolean encode = this.mmkv.encode(str, set);
        AppMethodBeat.o(156266);
        return encode;
    }

    public boolean encode(String str, byte[] bArr) {
        AppMethodBeat.i(156267);
        if (!isLegal(str, bArr)) {
            AppMethodBeat.o(156267);
            return false;
        }
        boolean encode = this.mmkv.encode(str, bArr);
        AppMethodBeat.o(156267);
        return encode;
    }

    public boolean encode(String str, Parcelable parcelable) {
        AppMethodBeat.i(156268);
        if (!isLegal(str, parcelable)) {
            AppMethodBeat.o(156268);
            return false;
        }
        boolean encode = this.mmkv.encode(str, parcelable);
        AppMethodBeat.o(156268);
        return encode;
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        int importFromSharedPreferences;
        AppMethodBeat.i(156269);
        try {
            importFromSharedPreferences = this.mmkv.importFromSharedPreferences(sharedPreferences);
        } catch (Throwable th) {
            ensureSoLoaded();
            importFromSharedPreferences = this.mmkv.importFromSharedPreferences(sharedPreferences);
        }
        AppMethodBeat.o(156269);
        return importFromSharedPreferences;
    }

    public static NativeBuffer createNativeBuffer(int i2) {
        AppMethodBeat.i(215412);
        d createNativeBuffer = MMKV.createNativeBuffer(i2);
        NativeBuffer nativeBuffer = new NativeBuffer(createNativeBuffer.pointer, createNativeBuffer.size);
        AppMethodBeat.o(215412);
        return nativeBuffer;
    }

    public static void destroyNativeBuffer(NativeBuffer nativeBuffer) {
        AppMethodBeat.i(215413);
        MMKV.destroyNativeBuffer(new d(nativeBuffer.pointer, nativeBuffer.size));
        AppMethodBeat.o(215413);
    }

    public int writeValueToNativeBuffer(String str, NativeBuffer nativeBuffer) {
        AppMethodBeat.i(215414);
        int writeValueToNativeBuffer = this.mmkv.writeValueToNativeBuffer(str, new d(nativeBuffer.pointer, nativeBuffer.size));
        AppMethodBeat.o(215414);
        return writeValueToNativeBuffer;
    }

    public String decodeString(String str) {
        String decodeString;
        AppMethodBeat.i(156270);
        try {
            decodeString = this.mmkv.decodeString(str);
        } catch (Throwable th) {
            ensureSoLoaded();
            decodeString = this.mmkv.decodeString(str);
        }
        AppMethodBeat.o(156270);
        return decodeString;
    }

    public String decodeString(String str, String str2) {
        AppMethodBeat.i(156271);
        String decodeString = this.mmkv.decodeString(str, str2);
        AppMethodBeat.o(156271);
        return decodeString;
    }

    public int decodeInt(String str) {
        AppMethodBeat.i(156272);
        int decodeInt = this.mmkv.decodeInt(str);
        AppMethodBeat.o(156272);
        return decodeInt;
    }

    public int decodeInt(String str, int i2) {
        AppMethodBeat.i(156273);
        int decodeInt = this.mmkv.decodeInt(str, i2);
        AppMethodBeat.o(156273);
        return decodeInt;
    }

    public long decodeLong(String str) {
        AppMethodBeat.i(156274);
        long decodeLong = this.mmkv.decodeLong(str);
        AppMethodBeat.o(156274);
        return decodeLong;
    }

    public long decodeLong(String str, long j2) {
        AppMethodBeat.i(156275);
        long decodeLong = this.mmkv.decodeLong(str, j2);
        AppMethodBeat.o(156275);
        return decodeLong;
    }

    public float decodeFloat(String str) {
        AppMethodBeat.i(215415);
        float decodeFloat = this.mmkv.decodeFloat(str);
        AppMethodBeat.o(215415);
        return decodeFloat;
    }

    public float decodeFloat(String str, float f2) {
        AppMethodBeat.i(215416);
        float decodeFloat = this.mmkv.decodeFloat(str, f2);
        AppMethodBeat.o(215416);
        return decodeFloat;
    }

    public double decodeDouble(String str) {
        AppMethodBeat.i(215417);
        double decodeDouble = this.mmkv.decodeDouble(str);
        AppMethodBeat.o(215417);
        return decodeDouble;
    }

    public double decodeDouble(String str, double d2) {
        AppMethodBeat.i(215418);
        double decodeDouble = this.mmkv.decodeDouble(str, d2);
        AppMethodBeat.o(215418);
        return decodeDouble;
    }

    public boolean decodeBool(String str) {
        AppMethodBeat.i(215419);
        boolean decodeBool = this.mmkv.decodeBool(str);
        AppMethodBeat.o(215419);
        return decodeBool;
    }

    public boolean decodeBool(String str, boolean z) {
        AppMethodBeat.i(156277);
        boolean decodeBool = this.mmkv.decodeBool(str, z);
        AppMethodBeat.o(156277);
        return decodeBool;
    }

    public Set<String> decodeStringSet(String str) {
        AppMethodBeat.i(215420);
        Set<String> decodeStringSet = this.mmkv.decodeStringSet(str);
        AppMethodBeat.o(215420);
        return decodeStringSet;
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        AppMethodBeat.i(156278);
        Set<String> decodeStringSet = this.mmkv.decodeStringSet(str, set);
        AppMethodBeat.o(156278);
        return decodeStringSet;
    }

    public byte[] decodeBytes(String str) {
        AppMethodBeat.i(156279);
        byte[] decodeBytes = this.mmkv.decodeBytes(str);
        AppMethodBeat.o(156279);
        return decodeBytes;
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        AppMethodBeat.i(156280);
        T t = (T) this.mmkv.decodeParcelable(str, cls);
        AppMethodBeat.o(156280);
        return t;
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t) {
        AppMethodBeat.i(215421);
        T t2 = (T) this.mmkv.decodeParcelable(str, cls, t);
        AppMethodBeat.o(215421);
        return t2;
    }

    public boolean containsKey(String str) {
        AppMethodBeat.i(156281);
        boolean containsKey = this.mmkv.containsKey(str);
        AppMethodBeat.o(156281);
        return containsKey;
    }

    public void removeValueForKey(String str) {
        AppMethodBeat.i(156282);
        this.mmkv.removeValueForKey(str);
        AppMethodBeat.o(156282);
    }

    public void removeValuesForKeys(String[] strArr) {
        AppMethodBeat.i(215422);
        this.mmkv.removeValuesForKeys(strArr);
        AppMethodBeat.o(215422);
    }

    public long totalSize() {
        AppMethodBeat.i(186112);
        long j2 = this.mmkv.totalSize();
        AppMethodBeat.o(186112);
        return j2;
    }

    public long count() {
        AppMethodBeat.i(215423);
        long count = this.mmkv.count();
        AppMethodBeat.o(215423);
        return count;
    }

    public void close() {
        AppMethodBeat.i(215424);
        this.mmkv.close();
        AppMethodBeat.o(215424);
    }

    public void clearMemoryCache() {
        AppMethodBeat.i(215425);
        this.mmkv.clearMemoryCache();
        AppMethodBeat.o(215425);
    }

    public void clearAll() {
        AppMethodBeat.i(156284);
        try {
            this.mmkv.clearAll();
            AppMethodBeat.o(156284);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.clearAll();
            AppMethodBeat.o(156284);
        }
    }

    public void trim() {
        AppMethodBeat.i(215426);
        this.mmkv.trim();
        AppMethodBeat.o(215426);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        AppMethodBeat.i(156285);
        Map<String, ?> all = this.mmkv.getAll();
        AppMethodBeat.o(156285);
        return all;
    }

    public String[] allKeys() {
        String[] allKeys;
        AppMethodBeat.i(156286);
        try {
            allKeys = this.mmkv.allKeys();
        } catch (Throwable th) {
            ensureSoLoaded();
            allKeys = this.mmkv.allKeys();
        }
        AppMethodBeat.o(156286);
        return allKeys;
    }

    public String getString(String str, String str2) {
        String string;
        AppMethodBeat.i(156287);
        try {
            string = this.mmkv.getString(str, str2);
        } catch (Throwable th) {
            ensureSoLoaded();
            string = this.mmkv.getString(str, str2);
        }
        AppMethodBeat.o(156287);
        return string;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet;
        AppMethodBeat.i(156288);
        try {
            stringSet = this.mmkv.getStringSet(str, set);
        } catch (Throwable th) {
            ensureSoLoaded();
            stringSet = this.mmkv.getStringSet(str, set);
        }
        AppMethodBeat.o(156288);
        return stringSet;
    }

    public int getInt(String str, int i2) {
        int i3;
        AppMethodBeat.i(156289);
        try {
            i3 = this.mmkv.getInt(str, i2);
        } catch (Throwable th) {
            ensureSoLoaded();
            i3 = this.mmkv.getInt(str, i2);
        }
        AppMethodBeat.o(156289);
        return i3;
    }

    public long getLong(String str, long j2) {
        long j3;
        AppMethodBeat.i(156290);
        try {
            j3 = this.mmkv.getLong(str, j2);
        } catch (Throwable th) {
            ensureSoLoaded();
            j3 = this.mmkv.getLong(str, j2);
        }
        AppMethodBeat.o(156290);
        return j3;
    }

    public float getFloat(String str, float f2) {
        float f3;
        AppMethodBeat.i(156291);
        try {
            f3 = this.mmkv.getFloat(str, f2);
        } catch (Throwable th) {
            ensureSoLoaded();
            f3 = this.mmkv.getFloat(str, f2);
        }
        AppMethodBeat.o(156291);
        return f3;
    }

    public boolean getBoolean(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(156292);
        try {
            z2 = this.mmkv.getBoolean(str, z);
        } catch (Throwable th) {
            ensureSoLoaded();
            z2 = this.mmkv.getBoolean(str, z);
        }
        AppMethodBeat.o(156292);
        return z2;
    }

    public boolean contains(String str) {
        boolean contains;
        AppMethodBeat.i(156293);
        try {
            contains = this.mmkv.contains(str);
        } catch (Throwable th) {
            ensureSoLoaded();
            contains = this.mmkv.contains(str);
        }
        AppMethodBeat.o(156293);
        return contains;
    }

    public SharedPreferences.Editor edit() {
        return this;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        AppMethodBeat.i(156294);
        if (!isLegal(str, str2)) {
            SharedPreferences.Editor edit = edit();
            AppMethodBeat.o(156294);
            return edit;
        }
        try {
            this.mmkv.putString(str, str2);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.putString(str, str2);
        }
        AppMethodBeat.o(156294);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.i(156295);
        if (!isLegal(str, set)) {
            SharedPreferences.Editor edit = edit();
            AppMethodBeat.o(156295);
            return edit;
        }
        try {
            this.mmkv.putStringSet(str, set);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.putStringSet(str, set);
        }
        AppMethodBeat.o(156295);
        return this;
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        AppMethodBeat.i(156296);
        if (!isLegal(str, Integer.valueOf(i2))) {
            SharedPreferences.Editor edit = edit();
            AppMethodBeat.o(156296);
            return edit;
        }
        try {
            this.mmkv.putInt(str, i2);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.putInt(str, i2);
        }
        AppMethodBeat.o(156296);
        return this;
    }

    public SharedPreferences.Editor putLong(String str, long j2) {
        AppMethodBeat.i(156297);
        if (!isLegal(str, Long.valueOf(j2))) {
            SharedPreferences.Editor edit = edit();
            AppMethodBeat.o(156297);
            return edit;
        }
        try {
            this.mmkv.putLong(str, j2);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.putLong(str, j2);
        }
        AppMethodBeat.o(156297);
        return this;
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        AppMethodBeat.i(156298);
        if (!isLegal(str, Float.valueOf(f2))) {
            SharedPreferences.Editor edit = edit();
            AppMethodBeat.o(156298);
            return edit;
        }
        try {
            this.mmkv.putFloat(str, f2);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.putFloat(str, f2);
        }
        AppMethodBeat.o(156298);
        return this;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        AppMethodBeat.i(156299);
        if (!isLegal(str, Boolean.valueOf(z))) {
            SharedPreferences.Editor edit = edit();
            AppMethodBeat.o(156299);
            return edit;
        }
        try {
            this.mmkv.putBoolean(str, z);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.putBoolean(str, z);
        }
        AppMethodBeat.o(156299);
        return this;
    }

    public SharedPreferences.Editor remove(String str) {
        AppMethodBeat.i(156300);
        try {
            this.mmkv.remove(str);
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.remove(str);
        }
        AppMethodBeat.o(156300);
        return this;
    }

    public SharedPreferences.Editor clear() {
        AppMethodBeat.i(156301);
        try {
            this.mmkv.clear();
        } catch (Throwable th) {
            ensureSoLoaded();
            this.mmkv.clear();
        }
        AppMethodBeat.o(156301);
        return this;
    }

    public boolean commit() {
        return true;
    }

    public void apply() {
    }

    public String mmapID() {
        AppMethodBeat.i(215427);
        String mmapID = this.mmkv.mmapID();
        AppMethodBeat.o(215427);
        return mmapID;
    }

    public int ashmemFD() {
        AppMethodBeat.i(215428);
        int ashmemFD = this.mmkv.ashmemFD();
        AppMethodBeat.o(215428);
        return ashmemFD;
    }

    public int ashmemMetaFD() {
        AppMethodBeat.i(215429);
        int ashmemMetaFD = this.mmkv.ashmemMetaFD();
        AppMethodBeat.o(215429);
        return ashmemMetaFD;
    }

    private boolean isLegal(String str, Object obj) {
        AppMethodBeat.i(156302);
        if (Util.isNullOrNil(str) || obj == null || Util.isNullOrNil(getName())) {
            AppMethodBeat.o(156302);
            return false;
        }
        AppMethodBeat.o(156302);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(182044);
        close();
        super.finalize();
        AppMethodBeat.o(182044);
    }

    private static void ensureSoLoaded() {
        AppMethodBeat.i(156303);
        MMKV.class.getClassLoader();
        j.Ed("mmkv");
        AppMethodBeat.o(156303);
    }

    public static final class NativeBuffer {
        public long pointer;
        public int size;

        public NativeBuffer(long j2, int i2) {
            this.pointer = j2;
            this.size = i2;
        }
    }
}
