package com.google.android.gms.wearable;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import com.google.android.gms.internal.wearable.zzt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@VisibleForTesting
public class DataMap {
    public static final String TAG = "DataMap";
    private final HashMap<String, Object> zzq = new HashMap<>();

    public DataMap() {
        AppMethodBeat.i(100786);
        AppMethodBeat.o(100786);
    }

    public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> arrayList) {
        AppMethodBeat.i(100789);
        ArrayList<DataMap> arrayList2 = new ArrayList<>();
        ArrayList<Bundle> arrayList3 = arrayList;
        int size = arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            Bundle bundle = arrayList3.get(i2);
            i2++;
            arrayList2.add(fromBundle(bundle));
        }
        AppMethodBeat.o(100789);
        return arrayList2;
    }

    public static DataMap fromBundle(Bundle bundle) {
        AppMethodBeat.i(100787);
        bundle.setClassLoader(Asset.class.getClassLoader());
        DataMap dataMap = new DataMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                dataMap.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                dataMap.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                dataMap.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                dataMap.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                dataMap.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                dataMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataMap.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof byte[]) {
                dataMap.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof String[]) {
                dataMap.putStringArray(str, (String[]) obj);
            } else if (obj instanceof long[]) {
                dataMap.putLongArray(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                dataMap.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Asset) {
                dataMap.putAsset(str, (Asset) obj);
            } else if (obj instanceof Bundle) {
                dataMap.putDataMap(str, fromBundle((Bundle) obj));
            } else if (obj instanceof ArrayList) {
                switch (zza((ArrayList) obj)) {
                    case 0:
                        dataMap.putStringArrayList(str, (ArrayList) obj);
                        continue;
                    case 1:
                        dataMap.putStringArrayList(str, (ArrayList) obj);
                        continue;
                    case 2:
                        dataMap.putIntegerArrayList(str, (ArrayList) obj);
                        continue;
                    case 3:
                        dataMap.putStringArrayList(str, (ArrayList) obj);
                        continue;
                    case 5:
                        dataMap.putDataMapArrayList(str, arrayListFromBundleArrayList((ArrayList) obj));
                        continue;
                }
            }
        }
        AppMethodBeat.o(100787);
        return dataMap;
    }

    public static DataMap fromByteArray(byte[] bArr) {
        AppMethodBeat.i(100788);
        try {
            DataMap zza = zze.zza(new zzf(zzg.zza(bArr), new ArrayList()));
            AppMethodBeat.o(100788);
            return zza;
        } catch (zzs e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to convert data", e2);
            AppMethodBeat.o(100788);
            throw illegalArgumentException;
        }
    }

    private static int zza(ArrayList<?> arrayList) {
        int i2 = 0;
        AppMethodBeat.i(100844);
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(100844);
            return 0;
        }
        ArrayList<?> arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            if (obj != null) {
                if (obj instanceof Integer) {
                    AppMethodBeat.o(100844);
                    return 2;
                } else if (obj instanceof String) {
                    AppMethodBeat.o(100844);
                    return 3;
                } else if (obj instanceof DataMap) {
                    AppMethodBeat.o(100844);
                    return 4;
                } else if (obj instanceof Bundle) {
                    AppMethodBeat.o(100844);
                    return 5;
                }
            }
        }
        AppMethodBeat.o(100844);
        return 1;
    }

    private static void zza(String str, Object obj, String str2, ClassCastException classCastException) {
        AppMethodBeat.i(100842);
        zza(str, obj, str2, "<null>", classCastException);
        AppMethodBeat.o(100842);
    }

    private static void zza(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        AppMethodBeat.i(100843);
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(str);
        sb.append(" expected ");
        sb.append(str2);
        sb.append(" but value was a ");
        sb.append(obj.getClass().getName());
        sb.append(".  The default value ");
        sb.append(obj2);
        sb.append(" was returned.");
        AppMethodBeat.o(100843);
    }

    public void clear() {
        AppMethodBeat.i(100794);
        this.zzq.clear();
        AppMethodBeat.o(100794);
    }

    public boolean containsKey(String str) {
        AppMethodBeat.i(100795);
        boolean containsKey = this.zzq.containsKey(str);
        AppMethodBeat.o(100795);
        return containsKey;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.DataMap.equals(java.lang.Object):boolean");
    }

    public <T> T get(String str) {
        AppMethodBeat.i(100796);
        T t = (T) this.zzq.get(str);
        AppMethodBeat.o(100796);
        return t;
    }

    public Asset getAsset(String str) {
        AppMethodBeat.i(100830);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100830);
            return null;
        }
        try {
            Asset asset = (Asset) obj;
            AppMethodBeat.o(100830);
            return asset;
        } catch (ClassCastException e2) {
            zza(str, obj, Asset.TAG, e2);
            AppMethodBeat.o(100830);
            return null;
        }
    }

    public boolean getBoolean(String str) {
        AppMethodBeat.i(100816);
        boolean z = getBoolean(str, false);
        AppMethodBeat.o(100816);
        return z;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(100817);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100817);
        } else {
            try {
                z = ((Boolean) obj).booleanValue();
                AppMethodBeat.o(100817);
            } catch (ClassCastException e2) {
                zza(str, obj, "Boolean", Boolean.valueOf(z), e2);
                AppMethodBeat.o(100817);
            }
        }
        return z;
    }

    public byte getByte(String str) {
        AppMethodBeat.i(100818);
        byte b2 = getByte(str, (byte) 0);
        AppMethodBeat.o(100818);
        return b2;
    }

    public byte getByte(String str, byte b2) {
        AppMethodBeat.i(100819);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100819);
        } else {
            try {
                b2 = ((Byte) obj).byteValue();
                AppMethodBeat.o(100819);
            } catch (ClassCastException e2) {
                zza(str, obj, "Byte", Byte.valueOf(b2), e2);
                AppMethodBeat.o(100819);
            }
        }
        return b2;
    }

    public byte[] getByteArray(String str) {
        AppMethodBeat.i(100835);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100835);
            return null;
        }
        try {
            byte[] bArr = (byte[]) obj;
            AppMethodBeat.o(100835);
            return bArr;
        } catch (ClassCastException e2) {
            zza(str, obj, "byte[]", e2);
            AppMethodBeat.o(100835);
            return null;
        }
    }

    public DataMap getDataMap(String str) {
        AppMethodBeat.i(100831);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100831);
            return null;
        }
        try {
            DataMap dataMap = (DataMap) obj;
            AppMethodBeat.o(100831);
            return dataMap;
        } catch (ClassCastException e2) {
            zza(str, obj, TAG, e2);
            AppMethodBeat.o(100831);
            return null;
        }
    }

    public ArrayList<DataMap> getDataMapArrayList(String str) {
        AppMethodBeat.i(100834);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100834);
            return null;
        }
        try {
            ArrayList<DataMap> arrayList = (ArrayList) obj;
            AppMethodBeat.o(100834);
            return arrayList;
        } catch (ClassCastException e2) {
            zza(str, obj, "ArrayList<DataMap>", e2);
            AppMethodBeat.o(100834);
            return null;
        }
    }

    public double getDouble(String str) {
        AppMethodBeat.i(100826);
        double d2 = getDouble(str, 0.0d);
        AppMethodBeat.o(100826);
        return d2;
    }

    public double getDouble(String str, double d2) {
        AppMethodBeat.i(100827);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100827);
        } else {
            try {
                d2 = ((Double) obj).doubleValue();
                AppMethodBeat.o(100827);
            } catch (ClassCastException e2) {
                zza(str, obj, "Double", Double.valueOf(d2), e2);
                AppMethodBeat.o(100827);
            }
        }
        return d2;
    }

    public float getFloat(String str) {
        AppMethodBeat.i(100824);
        float f2 = getFloat(str, 0.0f);
        AppMethodBeat.o(100824);
        return f2;
    }

    public float getFloat(String str, float f2) {
        AppMethodBeat.i(100825);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100825);
        } else {
            try {
                f2 = ((Float) obj).floatValue();
                AppMethodBeat.o(100825);
            } catch (ClassCastException e2) {
                zza(str, obj, "Float", Float.valueOf(f2), e2);
                AppMethodBeat.o(100825);
            }
        }
        return f2;
    }

    public float[] getFloatArray(String str) {
        AppMethodBeat.i(100837);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100837);
            return null;
        }
        try {
            float[] fArr = (float[]) obj;
            AppMethodBeat.o(100837);
            return fArr;
        } catch (ClassCastException e2) {
            zza(str, obj, "float[]", e2);
            AppMethodBeat.o(100837);
            return null;
        }
    }

    public int getInt(String str) {
        AppMethodBeat.i(100820);
        int i2 = getInt(str, 0);
        AppMethodBeat.o(100820);
        return i2;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(100821);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100821);
        } else {
            try {
                i2 = ((Integer) obj).intValue();
                AppMethodBeat.o(100821);
            } catch (ClassCastException e2) {
                zza(str, obj, DownloadSetting.TYPE_INTEGER, e2);
                AppMethodBeat.o(100821);
            }
        }
        return i2;
    }

    public ArrayList<Integer> getIntegerArrayList(String str) {
        AppMethodBeat.i(100832);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100832);
            return null;
        }
        try {
            ArrayList<Integer> arrayList = (ArrayList) obj;
            AppMethodBeat.o(100832);
            return arrayList;
        } catch (ClassCastException e2) {
            zza(str, obj, "ArrayList<Integer>", e2);
            AppMethodBeat.o(100832);
            return null;
        }
    }

    public long getLong(String str) {
        AppMethodBeat.i(100822);
        long j2 = getLong(str, 0);
        AppMethodBeat.o(100822);
        return j2;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(100823);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100823);
        } else {
            try {
                j2 = ((Long) obj).longValue();
                AppMethodBeat.o(100823);
            } catch (ClassCastException e2) {
                zza(str, obj, "long", e2);
                AppMethodBeat.o(100823);
            }
        }
        return j2;
    }

    public long[] getLongArray(String str) {
        AppMethodBeat.i(100836);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100836);
            return null;
        }
        try {
            long[] jArr = (long[]) obj;
            AppMethodBeat.o(100836);
            return jArr;
        } catch (ClassCastException e2) {
            zza(str, obj, "long[]", e2);
            AppMethodBeat.o(100836);
            return null;
        }
    }

    public String getString(String str) {
        AppMethodBeat.i(100829);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100829);
            return null;
        }
        try {
            String str2 = (String) obj;
            AppMethodBeat.o(100829);
            return str2;
        } catch (ClassCastException e2) {
            zza(str, obj, "String", e2);
            AppMethodBeat.o(100829);
            return null;
        }
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(100828);
        String string = getString(str);
        if (string == null) {
            AppMethodBeat.o(100828);
            return str2;
        }
        AppMethodBeat.o(100828);
        return string;
    }

    public String[] getStringArray(String str) {
        AppMethodBeat.i(100838);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100838);
            return null;
        }
        try {
            String[] strArr = (String[]) obj;
            AppMethodBeat.o(100838);
            return strArr;
        } catch (ClassCastException e2) {
            zza(str, obj, "String[]", e2);
            AppMethodBeat.o(100838);
            return null;
        }
    }

    public ArrayList<String> getStringArrayList(String str) {
        AppMethodBeat.i(100833);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.o(100833);
            return null;
        }
        try {
            ArrayList<String> arrayList = (ArrayList) obj;
            AppMethodBeat.o(100833);
            return arrayList;
        } catch (ClassCastException e2) {
            zza(str, obj, "ArrayList<String>", e2);
            AppMethodBeat.o(100833);
            return null;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(100840);
        int hashCode = this.zzq.hashCode() * 29;
        AppMethodBeat.o(100840);
        return hashCode;
    }

    public boolean isEmpty() {
        AppMethodBeat.i(100793);
        boolean isEmpty = this.zzq.isEmpty();
        AppMethodBeat.o(100793);
        return isEmpty;
    }

    public Set<String> keySet() {
        AppMethodBeat.i(100799);
        Set<String> keySet = this.zzq.keySet();
        AppMethodBeat.o(100799);
        return keySet;
    }

    public void putAll(DataMap dataMap) {
        AppMethodBeat.i(100798);
        for (String str : dataMap.keySet()) {
            this.zzq.put(str, dataMap.get(str));
        }
        AppMethodBeat.o(100798);
    }

    public void putAsset(String str, Asset asset) {
        AppMethodBeat.i(100807);
        this.zzq.put(str, asset);
        AppMethodBeat.o(100807);
    }

    public void putBoolean(String str, boolean z) {
        AppMethodBeat.i(100800);
        this.zzq.put(str, Boolean.valueOf(z));
        AppMethodBeat.o(100800);
    }

    public void putByte(String str, byte b2) {
        AppMethodBeat.i(100801);
        this.zzq.put(str, Byte.valueOf(b2));
        AppMethodBeat.o(100801);
    }

    public void putByteArray(String str, byte[] bArr) {
        AppMethodBeat.i(100812);
        this.zzq.put(str, bArr);
        AppMethodBeat.o(100812);
    }

    public void putDataMap(String str, DataMap dataMap) {
        AppMethodBeat.i(100808);
        this.zzq.put(str, dataMap);
        AppMethodBeat.o(100808);
    }

    public void putDataMapArrayList(String str, ArrayList<DataMap> arrayList) {
        AppMethodBeat.i(100809);
        this.zzq.put(str, arrayList);
        AppMethodBeat.o(100809);
    }

    public void putDouble(String str, double d2) {
        AppMethodBeat.i(100805);
        this.zzq.put(str, Double.valueOf(d2));
        AppMethodBeat.o(100805);
    }

    public void putFloat(String str, float f2) {
        AppMethodBeat.i(100804);
        this.zzq.put(str, Float.valueOf(f2));
        AppMethodBeat.o(100804);
    }

    public void putFloatArray(String str, float[] fArr) {
        AppMethodBeat.i(100814);
        this.zzq.put(str, fArr);
        AppMethodBeat.o(100814);
    }

    public void putInt(String str, int i2) {
        AppMethodBeat.i(100802);
        this.zzq.put(str, Integer.valueOf(i2));
        AppMethodBeat.o(100802);
    }

    public void putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        AppMethodBeat.i(100810);
        this.zzq.put(str, arrayList);
        AppMethodBeat.o(100810);
    }

    public void putLong(String str, long j2) {
        AppMethodBeat.i(100803);
        this.zzq.put(str, Long.valueOf(j2));
        AppMethodBeat.o(100803);
    }

    public void putLongArray(String str, long[] jArr) {
        AppMethodBeat.i(100813);
        this.zzq.put(str, jArr);
        AppMethodBeat.o(100813);
    }

    public void putString(String str, String str2) {
        AppMethodBeat.i(100806);
        this.zzq.put(str, str2);
        AppMethodBeat.o(100806);
    }

    public void putStringArray(String str, String[] strArr) {
        AppMethodBeat.i(100815);
        this.zzq.put(str, strArr);
        AppMethodBeat.o(100815);
    }

    public void putStringArrayList(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(100811);
        this.zzq.put(str, arrayList);
        AppMethodBeat.o(100811);
    }

    public Object remove(String str) {
        AppMethodBeat.i(100797);
        Object remove = this.zzq.remove(str);
        AppMethodBeat.o(100797);
        return remove;
    }

    public int size() {
        AppMethodBeat.i(100792);
        int size = this.zzq.size();
        AppMethodBeat.o(100792);
        return size;
    }

    public Bundle toBundle() {
        AppMethodBeat.i(100790);
        Bundle bundle = new Bundle();
        for (String str : this.zzq.keySet()) {
            Object obj = this.zzq.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof String[]) {
                bundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Asset) {
                bundle.putParcelable(str, (Asset) obj);
            } else if (obj instanceof DataMap) {
                bundle.putParcelable(str, ((DataMap) obj).toBundle());
            } else if (obj instanceof ArrayList) {
                switch (zza((ArrayList) obj)) {
                    case 0:
                        bundle.putStringArrayList(str, (ArrayList) obj);
                        continue;
                    case 1:
                        bundle.putStringArrayList(str, (ArrayList) obj);
                        continue;
                    case 2:
                        bundle.putIntegerArrayList(str, (ArrayList) obj);
                        continue;
                    case 3:
                        bundle.putStringArrayList(str, (ArrayList) obj);
                        continue;
                    case 4:
                        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj2 = arrayList2.get(i2);
                            i2++;
                            arrayList.add(((DataMap) obj2).toBundle());
                        }
                        bundle.putParcelableArrayList(str, arrayList);
                        continue;
                }
            }
        }
        AppMethodBeat.o(100790);
        return bundle;
    }

    public byte[] toByteArray() {
        AppMethodBeat.i(100791);
        byte[] zzb = zzt.zzb(zze.zza(this).zzfw);
        AppMethodBeat.o(100791);
        return zzb;
    }

    public String toString() {
        AppMethodBeat.i(100841);
        String hashMap = this.zzq.toString();
        AppMethodBeat.o(100841);
        return hashMap;
    }
}
