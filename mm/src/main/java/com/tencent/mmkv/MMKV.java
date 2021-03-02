package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static a gCallbackHandler;
    private static boolean gWantLogReDirecting = false;
    private static b[] index2LogLevel = {b.LevelDebug, b.LevelInfo, b.LevelWarning, b.LevelError, b.LevelNone};
    private static EnumMap<b, Integer> logLevel2Index;
    private static final HashMap<String, Parcelable.Creator<?>> mCreators = new HashMap<>();
    private static EnumMap<c, Integer> recoverIndex;
    private static String rootDir = null;
    private long nativeHandle;

    public interface a {
    }

    private native boolean containsKey(long j2, String str);

    private native long count(long j2);

    private static native long createNB(int i2);

    private native boolean decodeBool(long j2, String str, boolean z);

    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f2);

    private native int decodeInt(long j2, String str, int i2);

    private native long decodeLong(long j2, String str, long j3);

    private native String decodeString(long j2, String str, String str2);

    private native String[] decodeStringSet(long j2, String str);

    private static native void destroyNB(long j2, int i2);

    private native boolean encodeBool(long j2, String str, boolean z);

    private native boolean encodeBytes(long j2, String str, byte[] bArr);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeFloat(long j2, String str, float f2);

    private native boolean encodeInt(long j2, String str, int i2);

    private native boolean encodeLong(long j2, String str, long j3);

    private native boolean encodeSet(long j2, String str, String[] strArr);

    private native boolean encodeString(long j2, String str, String str2);

    private static native long getDefaultMMKV(int i2, String str);

    private static native long getMMKVWithAshmemFD(String str, int i2, int i3, String str2);

    private static native long getMMKVWithID(String str, int i2, String str2, String str3);

    private static native long getMMKVWithIDAndSize(String str, int i2, int i3, String str2);

    public static native boolean isFileValid(String str);

    private static native void jniInitialize(String str);

    public static native void onExit();

    public static native int pageSize();

    private native void removeValueForKey(long j2, String str);

    private static native void setLogLevel(int i2);

    private static native void setLogReDirecting(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j2);

    private native int valueSize(long j2, String str, boolean z);

    private native int writeValueToNB(long j2, String str, long j3, int i2);

    public native String[] allKeys();

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkReSetCryptKey(String str);

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public native String cryptKey();

    public native void lock();

    public native String mmapID();

    public native boolean reKey(String str);

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    static {
        AppMethodBeat.i(13527);
        EnumMap<c, Integer> enumMap = new EnumMap<>(c.class);
        recoverIndex = enumMap;
        enumMap.put(c.OnErrorDiscard, (Integer) 0);
        recoverIndex.put(c.OnErrorRecover, (Integer) 1);
        EnumMap<b, Integer> enumMap2 = new EnumMap<>(b.class);
        logLevel2Index = enumMap2;
        enumMap2.put(b.LevelDebug, (Integer) 0);
        logLevel2Index.put(b.LevelInfo, (Integer) 1);
        logLevel2Index.put(b.LevelWarning, (Integer) 2);
        logLevel2Index.put(b.LevelError, (Integer) 3);
        logLevel2Index.put(b.LevelNone, (Integer) 4);
        AppMethodBeat.o(13527);
    }

    public static String initialize(Context context) {
        AppMethodBeat.i(13450);
        String initialize = initialize(context.getFilesDir().getAbsolutePath() + "/mmkv", null);
        AppMethodBeat.o(13450);
        return initialize;
    }

    public static String initialize(String str) {
        AppMethodBeat.i(13451);
        String initialize = initialize(str, null);
        AppMethodBeat.o(13451);
        return initialize;
    }

    public static String initialize(String str, a aVar) {
        AppMethodBeat.i(13452);
        if (aVar != null) {
            "StaticCpp".equals("SharedCpp");
        } else {
            if ("StaticCpp".equals("SharedCpp")) {
                System.loadLibrary("c++_shared");
            }
            System.loadLibrary("mmkv");
        }
        rootDir = str;
        jniInitialize(str);
        AppMethodBeat.o(13452);
        return str;
    }

    public static String getRootDir() {
        return rootDir;
    }

    public static void setLogLevel(b bVar) {
        int i2 = 1;
        AppMethodBeat.i(13453);
        switch (bVar) {
            case LevelDebug:
                i2 = 0;
                break;
            case LevelWarning:
                i2 = 2;
                break;
            case LevelError:
                i2 = 3;
                break;
            case LevelNone:
                i2 = 4;
                break;
        }
        setLogLevel(i2);
        AppMethodBeat.o(13453);
    }

    public static MMKV mmkvWithID(String str) {
        AppMethodBeat.i(13454);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13454);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getMMKVWithID(str, 1, null, null));
        AppMethodBeat.o(13454);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, int i2) {
        AppMethodBeat.i(13455);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13455);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getMMKVWithID(str, i2, null, null));
        AppMethodBeat.o(13455);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, int i2, String str2) {
        AppMethodBeat.i(13456);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13456);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getMMKVWithID(str, i2, str2, null));
        AppMethodBeat.o(13456);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, String str2) {
        AppMethodBeat.i(13457);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13457);
            throw illegalStateException;
        }
        long mMKVWithID = getMMKVWithID(str, 1, null, str2);
        if (mMKVWithID == 0) {
            AppMethodBeat.o(13457);
            return null;
        }
        MMKV mmkv = new MMKV(mMKVWithID);
        AppMethodBeat.o(13457);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(13458);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13458);
            throw illegalStateException;
        }
        long mMKVWithID = getMMKVWithID(str, i2, str2, str3);
        if (mMKVWithID == 0) {
            AppMethodBeat.o(13458);
            return null;
        }
        MMKV mmkv = new MMKV(mMKVWithID);
        AppMethodBeat.o(13458);
        return mmkv;
    }

    public static MMKV mmkvWithAshmemID(Context context, String str, int i2, int i3, String str2) {
        MMKV mmkv;
        AppMethodBeat.i(13459);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13459);
            throw illegalStateException;
        }
        String aT = MMKVContentProvider.aT(context, Process.myPid());
        if (aT == null || aT.length() == 0) {
            simpleLog(b.LevelError, "process name detect fail, try again later");
            AppMethodBeat.o(13459);
            return null;
        } else if (aT.contains(":")) {
            Uri kU = MMKVContentProvider.kU(context);
            if (kU == null) {
                simpleLog(b.LevelError, "MMKVContentProvider has invalid authority");
                AppMethodBeat.o(13459);
                return null;
            }
            simpleLog(b.LevelInfo, "getting parcelable mmkv in process, Uri = ".concat(String.valueOf(kU)));
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i2);
            bundle.putInt("KEY_MODE", i3);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle call = context.getContentResolver().call(kU, "mmkvFromAshmemID", str, bundle);
            if (call != null) {
                call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                if (parcelableMMKV != null) {
                    if (parcelableMMKV.RzH < 0 || parcelableMMKV.RzI < 0) {
                        mmkv = null;
                    } else {
                        mmkv = mmkvWithAshmemFD(parcelableMMKV.RzG, parcelableMMKV.RzH, parcelableMMKV.RzI, parcelableMMKV.RzJ);
                    }
                    if (mmkv != null) {
                        simpleLog(b.LevelInfo, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    }
                    AppMethodBeat.o(13459);
                    return mmkv;
                }
            }
            AppMethodBeat.o(13459);
            return null;
        } else {
            simpleLog(b.LevelInfo, "getting mmkv in main process");
            MMKV mmkv2 = new MMKV(getMMKVWithIDAndSize(str, i2, i3 | 8, str2));
            AppMethodBeat.o(13459);
            return mmkv2;
        }
    }

    public static MMKV defaultMMKV() {
        AppMethodBeat.i(13460);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13460);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getDefaultMMKV(1, null));
        AppMethodBeat.o(13460);
        return mmkv;
    }

    public static MMKV defaultMMKV(int i2, String str) {
        AppMethodBeat.i(13461);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.o(13461);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getDefaultMMKV(i2, str));
        AppMethodBeat.o(13461);
        return mmkv;
    }

    public boolean encode(String str, boolean z) {
        AppMethodBeat.i(13462);
        boolean encodeBool = encodeBool(this.nativeHandle, str, z);
        AppMethodBeat.o(13462);
        return encodeBool;
    }

    public boolean decodeBool(String str) {
        AppMethodBeat.i(13463);
        boolean decodeBool = decodeBool(this.nativeHandle, str, false);
        AppMethodBeat.o(13463);
        return decodeBool;
    }

    public boolean decodeBool(String str, boolean z) {
        AppMethodBeat.i(13464);
        boolean decodeBool = decodeBool(this.nativeHandle, str, z);
        AppMethodBeat.o(13464);
        return decodeBool;
    }

    public boolean encode(String str, int i2) {
        AppMethodBeat.i(13465);
        boolean encodeInt = encodeInt(this.nativeHandle, str, i2);
        AppMethodBeat.o(13465);
        return encodeInt;
    }

    public int decodeInt(String str) {
        AppMethodBeat.i(13466);
        int decodeInt = decodeInt(this.nativeHandle, str, 0);
        AppMethodBeat.o(13466);
        return decodeInt;
    }

    public int decodeInt(String str, int i2) {
        AppMethodBeat.i(13467);
        int decodeInt = decodeInt(this.nativeHandle, str, i2);
        AppMethodBeat.o(13467);
        return decodeInt;
    }

    public boolean encode(String str, long j2) {
        AppMethodBeat.i(13468);
        boolean encodeLong = encodeLong(this.nativeHandle, str, j2);
        AppMethodBeat.o(13468);
        return encodeLong;
    }

    public long decodeLong(String str) {
        AppMethodBeat.i(13469);
        long decodeLong = decodeLong(this.nativeHandle, str, 0);
        AppMethodBeat.o(13469);
        return decodeLong;
    }

    public long decodeLong(String str, long j2) {
        AppMethodBeat.i(13470);
        long decodeLong = decodeLong(this.nativeHandle, str, j2);
        AppMethodBeat.o(13470);
        return decodeLong;
    }

    public boolean encode(String str, float f2) {
        AppMethodBeat.i(13471);
        boolean encodeFloat = encodeFloat(this.nativeHandle, str, f2);
        AppMethodBeat.o(13471);
        return encodeFloat;
    }

    public float decodeFloat(String str) {
        AppMethodBeat.i(13472);
        float decodeFloat = decodeFloat(this.nativeHandle, str, 0.0f);
        AppMethodBeat.o(13472);
        return decodeFloat;
    }

    public float decodeFloat(String str, float f2) {
        AppMethodBeat.i(13473);
        float decodeFloat = decodeFloat(this.nativeHandle, str, f2);
        AppMethodBeat.o(13473);
        return decodeFloat;
    }

    public boolean encode(String str, double d2) {
        AppMethodBeat.i(13474);
        boolean encodeDouble = encodeDouble(this.nativeHandle, str, d2);
        AppMethodBeat.o(13474);
        return encodeDouble;
    }

    public double decodeDouble(String str) {
        AppMethodBeat.i(13475);
        double decodeDouble = decodeDouble(this.nativeHandle, str, 0.0d);
        AppMethodBeat.o(13475);
        return decodeDouble;
    }

    public double decodeDouble(String str, double d2) {
        AppMethodBeat.i(13476);
        double decodeDouble = decodeDouble(this.nativeHandle, str, d2);
        AppMethodBeat.o(13476);
        return decodeDouble;
    }

    public boolean encode(String str, String str2) {
        AppMethodBeat.i(13477);
        boolean encodeString = encodeString(this.nativeHandle, str, str2);
        AppMethodBeat.o(13477);
        return encodeString;
    }

    public String decodeString(String str) {
        AppMethodBeat.i(13478);
        String decodeString = decodeString(this.nativeHandle, str, null);
        AppMethodBeat.o(13478);
        return decodeString;
    }

    public String decodeString(String str, String str2) {
        AppMethodBeat.i(13479);
        String decodeString = decodeString(this.nativeHandle, str, str2);
        AppMethodBeat.o(13479);
        return decodeString;
    }

    public boolean encode(String str, Set<String> set) {
        AppMethodBeat.i(13480);
        boolean encodeSet = encodeSet(this.nativeHandle, str, (String[]) set.toArray(new String[set.size()]));
        AppMethodBeat.o(13480);
        return encodeSet;
    }

    public Set<String> decodeStringSet(String str) {
        AppMethodBeat.i(13481);
        Set<String> decodeStringSet = decodeStringSet(str, (Set<String>) null);
        AppMethodBeat.o(13481);
        return decodeStringSet;
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        AppMethodBeat.i(13482);
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            AppMethodBeat.o(13482);
            return set;
        }
        HashSet hashSet = new HashSet(Arrays.asList(decodeStringSet));
        AppMethodBeat.o(13482);
        return hashSet;
    }

    public boolean encode(String str, byte[] bArr) {
        AppMethodBeat.i(13483);
        boolean encodeBytes = encodeBytes(this.nativeHandle, str, bArr);
        AppMethodBeat.o(13483);
        return encodeBytes;
    }

    public byte[] decodeBytes(String str) {
        AppMethodBeat.i(13484);
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        AppMethodBeat.o(13484);
        return decodeBytes;
    }

    public boolean encode(String str, Parcelable parcelable) {
        AppMethodBeat.i(13485);
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, parcelable.describeContents());
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        boolean encodeBytes = encodeBytes(this.nativeHandle, str, marshall);
        AppMethodBeat.o(13485);
        return encodeBytes;
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        AppMethodBeat.i(13486);
        T t = (T) decodeParcelable(str, cls, null);
        AppMethodBeat.o(13486);
        return t;
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t) {
        Parcelable.Creator<?> creator;
        AppMethodBeat.i(13487);
        if (cls == null) {
            AppMethodBeat.o(13487);
            return t;
        }
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        if (decodeBytes == null) {
            AppMethodBeat.o(13487);
            return t;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
        obtain.setDataPosition(0);
        try {
            String cls2 = cls.toString();
            synchronized (mCreators) {
                try {
                    creator = mCreators.get(cls2);
                    if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                        mCreators.put(cls2, creator);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(13487);
                    throw th;
                }
            }
            if (creator != null) {
                return (T) ((Parcelable) creator.createFromParcel(obtain));
            }
            Exception exc = new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(cls2)));
            AppMethodBeat.o(13487);
            throw exc;
        } catch (Exception e2) {
            simpleLog(b.LevelError, e2.toString());
            return t;
        } finally {
            obtain.recycle();
            AppMethodBeat.o(13487);
        }
    }

    public int getValueSize(String str) {
        AppMethodBeat.i(13488);
        int valueSize = valueSize(this.nativeHandle, str, false);
        AppMethodBeat.o(13488);
        return valueSize;
    }

    public int getValueActualSize(String str) {
        AppMethodBeat.i(13489);
        int valueSize = valueSize(this.nativeHandle, str, true);
        AppMethodBeat.o(13489);
        return valueSize;
    }

    public boolean containsKey(String str) {
        AppMethodBeat.i(13490);
        boolean containsKey = containsKey(this.nativeHandle, str);
        AppMethodBeat.o(13490);
        return containsKey;
    }

    public long count() {
        AppMethodBeat.i(13491);
        long count = count(this.nativeHandle);
        AppMethodBeat.o(13491);
        return count;
    }

    public long totalSize() {
        AppMethodBeat.i(13492);
        long j2 = totalSize(this.nativeHandle);
        AppMethodBeat.o(13492);
        return j2;
    }

    public void removeValueForKey(String str) {
        AppMethodBeat.i(13493);
        removeValueForKey(this.nativeHandle, str);
        AppMethodBeat.o(13493);
    }

    public void sync() {
        AppMethodBeat.i(13494);
        sync(true);
        AppMethodBeat.o(13494);
    }

    public void async() {
        AppMethodBeat.i(13495);
        sync(false);
        AppMethodBeat.o(13495);
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(13496);
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            AppMethodBeat.o(13496);
            return 0;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!(key == null || value == null)) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, key, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, key, (String) value);
                } else if (value instanceof Set) {
                    encode(key, (Set) value);
                } else {
                    simpleLog(b.LevelError, "unknown type: " + value.getClass());
                }
            }
        }
        int size = all.size();
        AppMethodBeat.o(13496);
        return size;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        AppMethodBeat.i(13497);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
        AppMethodBeat.o(13497);
        throw unsupportedOperationException;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(13498);
        String decodeString = decodeString(this.nativeHandle, str, str2);
        AppMethodBeat.o(13498);
        return decodeString;
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        AppMethodBeat.i(13499);
        encodeString(this.nativeHandle, str, str2);
        AppMethodBeat.o(13499);
        return this;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        AppMethodBeat.i(13500);
        Set<String> decodeStringSet = decodeStringSet(str, set);
        AppMethodBeat.o(13500);
        return decodeStringSet;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.i(13501);
        encode(str, set);
        AppMethodBeat.o(13501);
        return this;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(13502);
        int decodeInt = decodeInt(this.nativeHandle, str, i2);
        AppMethodBeat.o(13502);
        return decodeInt;
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        AppMethodBeat.i(13503);
        encodeInt(this.nativeHandle, str, i2);
        AppMethodBeat.o(13503);
        return this;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(13504);
        long decodeLong = decodeLong(this.nativeHandle, str, j2);
        AppMethodBeat.o(13504);
        return decodeLong;
    }

    public SharedPreferences.Editor putLong(String str, long j2) {
        AppMethodBeat.i(13505);
        encodeLong(this.nativeHandle, str, j2);
        AppMethodBeat.o(13505);
        return this;
    }

    public float getFloat(String str, float f2) {
        AppMethodBeat.i(13506);
        float decodeFloat = decodeFloat(this.nativeHandle, str, f2);
        AppMethodBeat.o(13506);
        return decodeFloat;
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        AppMethodBeat.i(13507);
        encodeFloat(this.nativeHandle, str, f2);
        AppMethodBeat.o(13507);
        return this;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(13508);
        boolean decodeBool = decodeBool(this.nativeHandle, str, z);
        AppMethodBeat.o(13508);
        return decodeBool;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        AppMethodBeat.i(13509);
        encodeBool(this.nativeHandle, str, z);
        AppMethodBeat.o(13509);
        return this;
    }

    public SharedPreferences.Editor remove(String str) {
        AppMethodBeat.i(13510);
        removeValueForKey(str);
        AppMethodBeat.o(13510);
        return this;
    }

    public SharedPreferences.Editor clear() {
        AppMethodBeat.i(13511);
        clearAll();
        AppMethodBeat.o(13511);
        return this;
    }

    public boolean commit() {
        AppMethodBeat.i(13512);
        sync(true);
        AppMethodBeat.o(13512);
        return true;
    }

    public void apply() {
        AppMethodBeat.i(13513);
        sync(false);
        AppMethodBeat.o(13513);
    }

    public boolean contains(String str) {
        AppMethodBeat.i(13514);
        boolean containsKey = containsKey(str);
        AppMethodBeat.o(13514);
        return containsKey;
    }

    public SharedPreferences.Editor edit() {
        return this;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(13515);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(13515);
        throw unsupportedOperationException;
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(13516);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(13516);
        throw unsupportedOperationException;
    }

    public static MMKV mmkvWithAshmemFD(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(13517);
        MMKV mmkv = new MMKV(getMMKVWithAshmemFD(str, i2, i3, str2));
        AppMethodBeat.o(13517);
        return mmkv;
    }

    public static d createNativeBuffer(int i2) {
        AppMethodBeat.i(13518);
        long createNB = createNB(i2);
        if (createNB <= 0) {
            AppMethodBeat.o(13518);
            return null;
        }
        d dVar = new d(createNB, i2);
        AppMethodBeat.o(13518);
        return dVar;
    }

    public static void destroyNativeBuffer(d dVar) {
        AppMethodBeat.i(13519);
        destroyNB(dVar.pointer, dVar.size);
        AppMethodBeat.o(13519);
    }

    public int writeValueToNativeBuffer(String str, d dVar) {
        AppMethodBeat.i(13520);
        int writeValueToNB = writeValueToNB(this.nativeHandle, str, dVar.pointer, dVar.size);
        AppMethodBeat.o(13520);
        return writeValueToNB;
    }

    public static void registerHandler(a aVar) {
        AppMethodBeat.i(13521);
        gCallbackHandler = aVar;
        if (aVar.wantLogRedirecting()) {
            setLogReDirecting(true);
            gWantLogReDirecting = true;
            AppMethodBeat.o(13521);
            return;
        }
        setLogReDirecting(false);
        gWantLogReDirecting = false;
        AppMethodBeat.o(13521);
    }

    public static void unregisterHandler() {
        AppMethodBeat.i(13522);
        gCallbackHandler = null;
        setLogReDirecting(false);
        gWantLogReDirecting = false;
        AppMethodBeat.o(13522);
    }

    private static int onMMKVCRCCheckFail(String str) {
        AppMethodBeat.i(13523);
        c cVar = c.OnErrorDiscard;
        if (gCallbackHandler != null) {
            cVar = gCallbackHandler.onMMKVCRCCheckFail(str);
        }
        simpleLog(b.LevelInfo, "Recover strategic for " + str + " is " + cVar);
        int intValue = recoverIndex.get(cVar).intValue();
        AppMethodBeat.o(13523);
        return intValue;
    }

    private static int onMMKVFileLengthError(String str) {
        AppMethodBeat.i(13524);
        c cVar = c.OnErrorDiscard;
        if (gCallbackHandler != null) {
            cVar = gCallbackHandler.onMMKVFileLengthError(str);
        }
        simpleLog(b.LevelInfo, "Recover strategic for " + str + " is " + cVar);
        int intValue = recoverIndex.get(cVar).intValue();
        AppMethodBeat.o(13524);
        return intValue;
    }

    private static void mmkvLogImp(int i2, String str, int i3, String str2, String str3) {
        AppMethodBeat.i(13525);
        if (gCallbackHandler == null || !gWantLogReDirecting) {
            int[] iArr = AnonymousClass1.Rzv;
            index2LogLevel[i2].ordinal();
            AppMethodBeat.o(13525);
            return;
        }
        gCallbackHandler.mmkvLog(index2LogLevel[i2], str, i3, str2, str3);
        AppMethodBeat.o(13525);
    }

    private static void simpleLog(b bVar, String str) {
        AppMethodBeat.i(13526);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        mmkvLogImp(logLevel2Index.get(bVar).intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
        AppMethodBeat.o(13526);
    }

    private MMKV(long j2) {
        this.nativeHandle = j2;
    }
}
