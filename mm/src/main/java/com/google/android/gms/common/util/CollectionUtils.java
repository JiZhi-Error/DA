package com.google.android.gms.common.util;

import android.support.v4.e.a;
import android.support.v4.e.b;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <K, V> Map<K, V> inOrderMapOf() {
        AppMethodBeat.i(5129);
        Map<K, V> mapOf = mapOf();
        AppMethodBeat.o(5129);
        return mapOf;
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v) {
        AppMethodBeat.i(5130);
        Map<K, V> mapOf = mapOf(k, v);
        AppMethodBeat.o(5130);
        return mapOf;
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2) {
        AppMethodBeat.i(5131);
        Map zzg = zzg(2, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzg);
        AppMethodBeat.o(5131);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3) {
        AppMethodBeat.i(5132);
        Map zzg = zzg(3, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzg);
        AppMethodBeat.o(5132);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        AppMethodBeat.i(5133);
        Map zzg = zzg(4, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        zzg.put(k4, v4);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzg);
        AppMethodBeat.o(5133);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        AppMethodBeat.i(5134);
        Map zzg = zzg(5, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        zzg.put(k4, v4);
        zzg.put(k5, v5);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzg);
        AppMethodBeat.o(5134);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        AppMethodBeat.i(5135);
        Map zzg = zzg(6, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        zzg.put(k4, v4);
        zzg.put(k5, v5);
        zzg.put(k6, v6);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzg);
        AppMethodBeat.o(5135);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> inOrderMapOfKeyValueArrays(K[] kArr, V[] vArr) {
        AppMethodBeat.i(5136);
        zza(kArr, vArr);
        int length = kArr.length;
        switch (length) {
            case 0:
                Map<K, V> inOrderMapOf = inOrderMapOf();
                AppMethodBeat.o(5136);
                return inOrderMapOf;
            case 1:
                Map<K, V> inOrderMapOf2 = inOrderMapOf(kArr[0], vArr[0]);
                AppMethodBeat.o(5136);
                return inOrderMapOf2;
            default:
                Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzb(length, false, kArr, vArr));
                AppMethodBeat.o(5136);
                return unmodifiableMap;
        }
    }

    public static <T> Set<T> inOrderSetOf() {
        AppMethodBeat.i(5093);
        Set<T> of = setOf();
        AppMethodBeat.o(5093);
        return of;
    }

    public static <T> Set<T> inOrderSetOf(T t) {
        AppMethodBeat.i(5094);
        Set<T> of = setOf(t);
        AppMethodBeat.o(5094);
        return of;
    }

    public static <T> Set<T> inOrderSetOf(T t, T t2) {
        AppMethodBeat.i(5095);
        Set zze = zze(2, false);
        zze.add(t);
        zze.add(t2);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(zze);
        AppMethodBeat.o(5095);
        return unmodifiableSet;
    }

    public static <T> Set<T> inOrderSetOf(T t, T t2, T t3) {
        AppMethodBeat.i(5096);
        Set zze = zze(3, false);
        zze.add(t);
        zze.add(t2);
        zze.add(t3);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(zze);
        AppMethodBeat.o(5096);
        return unmodifiableSet;
    }

    public static <T> Set<T> inOrderSetOf(T t, T t2, T t3, T t4) {
        AppMethodBeat.i(5097);
        Set zze = zze(4, false);
        zze.add(t);
        zze.add(t2);
        zze.add(t3);
        zze.add(t4);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(zze);
        AppMethodBeat.o(5097);
        return unmodifiableSet;
    }

    public static <T> Set<T> inOrderSetOf(T... tArr) {
        AppMethodBeat.i(5098);
        switch (tArr.length) {
            case 0:
                Set<T> inOrderSetOf = inOrderSetOf();
                AppMethodBeat.o(5098);
                return inOrderSetOf;
            case 1:
                Set<T> inOrderSetOf2 = inOrderSetOf(tArr[0]);
                AppMethodBeat.o(5098);
                return inOrderSetOf2;
            case 2:
                Set<T> inOrderSetOf3 = inOrderSetOf(tArr[0], tArr[1]);
                AppMethodBeat.o(5098);
                return inOrderSetOf3;
            case 3:
                Set<T> inOrderSetOf4 = inOrderSetOf(tArr[0], tArr[1], tArr[2]);
                AppMethodBeat.o(5098);
                return inOrderSetOf4;
            case 4:
                Set<T> inOrderSetOf5 = inOrderSetOf(tArr[0], tArr[1], tArr[2], tArr[3]);
                AppMethodBeat.o(5098);
                return inOrderSetOf5;
            default:
                Set<T> unmodifiableSet = Collections.unmodifiableSet(zzb(tArr.length, false, tArr));
                AppMethodBeat.o(5098);
                return unmodifiableSet;
        }
    }

    public static boolean isEmpty(Collection<?> collection) {
        AppMethodBeat.i(5069);
        if (collection == null) {
            AppMethodBeat.o(5069);
            return true;
        }
        boolean isEmpty = collection.isEmpty();
        AppMethodBeat.o(5069);
        return isEmpty;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        AppMethodBeat.i(5070);
        if (map == null) {
            AppMethodBeat.o(5070);
            return true;
        }
        boolean isEmpty = map.isEmpty();
        AppMethodBeat.o(5070);
        return isEmpty;
    }

    @Deprecated
    public static <T> List<T> listOf() {
        AppMethodBeat.i(5072);
        List<T> emptyList = Collections.emptyList();
        AppMethodBeat.o(5072);
        return emptyList;
    }

    @Deprecated
    public static <T> List<T> listOf(T t) {
        AppMethodBeat.i(5073);
        List<T> singletonList = Collections.singletonList(t);
        AppMethodBeat.o(5073);
        return singletonList;
    }

    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        AppMethodBeat.i(5074);
        switch (tArr.length) {
            case 0:
                List<T> listOf = listOf();
                AppMethodBeat.o(5074);
                return listOf;
            case 1:
                List<T> listOf2 = listOf(tArr[0]);
                AppMethodBeat.o(5074);
                return listOf2;
            default:
                List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(tArr));
                AppMethodBeat.o(5074);
                return unmodifiableList;
        }
    }

    public static <K, V> Map<K, V> mapOf() {
        AppMethodBeat.i(5119);
        Map<K, V> emptyMap = Collections.emptyMap();
        AppMethodBeat.o(5119);
        return emptyMap;
    }

    public static <K, V> Map<K, V> mapOf(K k, V v) {
        AppMethodBeat.i(5120);
        Map<K, V> singletonMap = Collections.singletonMap(k, v);
        AppMethodBeat.o(5120);
        return singletonMap;
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2) {
        AppMethodBeat.i(NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE);
        Map zzf = zzf(2, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzf);
        AppMethodBeat.o(NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3) {
        AppMethodBeat.i(5122);
        Map zzf = zzf(3, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzf);
        AppMethodBeat.o(5122);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        AppMethodBeat.i(5123);
        Map zzf = zzf(4, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        zzf.put(k4, v4);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzf);
        AppMethodBeat.o(5123);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        AppMethodBeat.i(5124);
        Map zzf = zzf(5, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        zzf.put(k4, v4);
        zzf.put(k5, v5);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzf);
        AppMethodBeat.o(5124);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        AppMethodBeat.i(5125);
        Map zzf = zzf(6, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        zzf.put(k4, v4);
        zzf.put(k5, v5);
        zzf.put(k6, v6);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zzf);
        AppMethodBeat.o(5125);
        return unmodifiableMap;
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        AppMethodBeat.i(5126);
        zza(kArr, vArr);
        switch (kArr.length) {
            case 0:
                Map<K, V> mapOf = mapOf();
                AppMethodBeat.o(5126);
                return mapOf;
            case 1:
                Map<K, V> mapOf2 = mapOf(kArr[0], vArr[0]);
                AppMethodBeat.o(5126);
                return mapOf2;
            default:
                Map<K, V> unmodifiableMap = Collections.unmodifiableMap(zza(kArr.length, false, kArr, vArr));
                AppMethodBeat.o(5126);
                return unmodifiableMap;
        }
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf() {
        AppMethodBeat.i(5152);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AppMethodBeat.o(5152);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf(K k, V v) {
        AppMethodBeat.i(5153);
        Map<K, V> mutableInOrderMapOfWithSize = mutableInOrderMapOfWithSize(1, k, v);
        AppMethodBeat.o(5153);
        return mutableInOrderMapOfWithSize;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf(K k, V v, K k2, V v2) {
        AppMethodBeat.i(5154);
        Map<K, V> mutableInOrderMapOfWithSize = mutableInOrderMapOfWithSize(2, k, v, k2, v2);
        AppMethodBeat.o(5154);
        return mutableInOrderMapOfWithSize;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf(K k, V v, K k2, V v2, K k3, V v3) {
        AppMethodBeat.i(5155);
        Map<K, V> mutableInOrderMapOfWithSize = mutableInOrderMapOfWithSize(3, k, v, k2, v2, k3, v3);
        AppMethodBeat.o(5155);
        return mutableInOrderMapOfWithSize;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArrays(K[] kArr, V[] vArr) {
        AppMethodBeat.i(5156);
        zza(kArr, vArr);
        int length = kArr.length;
        if (length == 0) {
            Map<K, V> mutableInOrderMapOf = mutableInOrderMapOf();
            AppMethodBeat.o(5156);
            return mutableInOrderMapOf;
        }
        Map<K, V> zzb = zzb(length, true, kArr, vArr);
        AppMethodBeat.o(5156);
        return zzb;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArraysWithSize(int i2, K[] kArr, V[] vArr) {
        AppMethodBeat.i(5151);
        zza(kArr, vArr);
        int max = Math.max(i2, kArr.length);
        if (max == 0) {
            Map<K, V> mutableInOrderMapOf = mutableInOrderMapOf();
            AppMethodBeat.o(5151);
            return mutableInOrderMapOf;
        } else if (kArr.length == 0) {
            Map<K, V> mutableInOrderMapOfWithSize = mutableInOrderMapOfWithSize(max);
            AppMethodBeat.o(5151);
            return mutableInOrderMapOfWithSize;
        } else {
            Map<K, V> zzb = zzb(i2, true, kArr, vArr);
            AppMethodBeat.o(5151);
            return zzb;
        }
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i2) {
        AppMethodBeat.i(5147);
        if (i2 == 0) {
            Map<K, V> mutableInOrderMapOf = mutableInOrderMapOf();
            AppMethodBeat.o(5147);
            return mutableInOrderMapOf;
        }
        Map<K, V> zzg = zzg(i2, true);
        AppMethodBeat.o(5147);
        return zzg;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i2, K k, V v) {
        AppMethodBeat.i(5148);
        Map<K, V> zzg = zzg(Math.max(i2, 1), true);
        zzg.put(k, v);
        AppMethodBeat.o(5148);
        return zzg;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i2, K k, V v, K k2, V v2) {
        AppMethodBeat.i(5149);
        Map<K, V> zzg = zzg(Math.max(i2, 2), true);
        zzg.put(k, v);
        zzg.put(k2, v2);
        AppMethodBeat.o(5149);
        return zzg;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i2, K k, V v, K k2, V v2, K k3, V v3) {
        AppMethodBeat.i(5150);
        Map<K, V> zzg = zzg(Math.max(i2, 3), true);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        AppMethodBeat.o(5150);
        return zzg;
    }

    public static <T> Set<T> mutableInOrderSetOf() {
        AppMethodBeat.i(5111);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        AppMethodBeat.o(5111);
        return linkedHashSet;
    }

    public static <T> Set<T> mutableInOrderSetOf(T t) {
        AppMethodBeat.i(5112);
        Set<T> mutableInOrderSetOfWithSize = mutableInOrderSetOfWithSize(1, t);
        AppMethodBeat.o(5112);
        return mutableInOrderSetOfWithSize;
    }

    public static <T> Set<T> mutableInOrderSetOf(T t, T t2) {
        AppMethodBeat.i(5113);
        Set<T> mutableInOrderSetOfWithSize = mutableInOrderSetOfWithSize(2, t, t2);
        AppMethodBeat.o(5113);
        return mutableInOrderSetOfWithSize;
    }

    public static <T> Set<T> mutableInOrderSetOf(T... tArr) {
        AppMethodBeat.i(5114);
        if (tArr.length == 0) {
            Set<T> mutableInOrderSetOf = mutableInOrderSetOf();
            AppMethodBeat.o(5114);
            return mutableInOrderSetOf;
        }
        Set<T> zzb = zzb(tArr.length, true, tArr);
        AppMethodBeat.o(5114);
        return zzb;
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i2) {
        AppMethodBeat.i(5107);
        if (i2 == 0) {
            Set<T> mutableInOrderSetOf = mutableInOrderSetOf();
            AppMethodBeat.o(5107);
            return mutableInOrderSetOf;
        }
        Set<T> zze = zze(i2, true);
        AppMethodBeat.o(5107);
        return zze;
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i2, T t) {
        AppMethodBeat.i(5108);
        Set<T> zze = zze(Math.max(i2, 1), true);
        zze.add(t);
        AppMethodBeat.o(5108);
        return zze;
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i2, T t, T t2) {
        AppMethodBeat.i(5109);
        Set<T> zze = zze(Math.max(i2, 2), true);
        zze.add(t);
        zze.add(t2);
        AppMethodBeat.o(5109);
        return zze;
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i2, T... tArr) {
        AppMethodBeat.i(5110);
        int max = Math.max(i2, tArr.length);
        if (max == 0) {
            Set<T> mutableSetOf = mutableSetOf();
            AppMethodBeat.o(5110);
            return mutableSetOf;
        } else if (tArr.length == 0) {
            Set<T> mutableInOrderSetOfWithSize = mutableInOrderSetOfWithSize(i2);
            AppMethodBeat.o(5110);
            return mutableInOrderSetOfWithSize;
        } else {
            Set<T> zzb = zzb(max, true, tArr);
            AppMethodBeat.o(5110);
            return zzb;
        }
    }

    public static <T> List<T> mutableListOf() {
        AppMethodBeat.i(5079);
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(5079);
        return arrayList;
    }

    public static <T> List<T> mutableListOf(T t) {
        AppMethodBeat.i(5080);
        List<T> mutableListOfWithSize = mutableListOfWithSize(1, t);
        AppMethodBeat.o(5080);
        return mutableListOfWithSize;
    }

    public static <T> List<T> mutableListOf(T t, T t2) {
        AppMethodBeat.i(5081);
        List<T> mutableListOfWithSize = mutableListOfWithSize(2, t, t2);
        AppMethodBeat.o(5081);
        return mutableListOfWithSize;
    }

    public static <T> List<T> mutableListOf(T... tArr) {
        AppMethodBeat.i(5082);
        if (tArr.length == 0) {
            List<T> mutableListOf = mutableListOf();
            AppMethodBeat.o(5082);
            return mutableListOf;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(tArr));
        AppMethodBeat.o(5082);
        return arrayList;
    }

    public static <T> List<T> mutableListOfWithSize(int i2) {
        AppMethodBeat.i(5075);
        if (i2 == 0) {
            List<T> mutableListOf = mutableListOf();
            AppMethodBeat.o(5075);
            return mutableListOf;
        }
        List<T> zzc = zzc(i2, true);
        AppMethodBeat.o(5075);
        return zzc;
    }

    public static <T> List<T> mutableListOfWithSize(int i2, T t) {
        AppMethodBeat.i(5076);
        List<T> zzc = zzc(Math.max(i2, 1), true);
        zzc.add(t);
        AppMethodBeat.o(5076);
        return zzc;
    }

    public static <T> List<T> mutableListOfWithSize(int i2, T t, T t2) {
        AppMethodBeat.i(5077);
        List<T> zzc = zzc(Math.max(i2, 2), true);
        zzc.add(t);
        zzc.add(t2);
        AppMethodBeat.o(5077);
        return zzc;
    }

    public static <T> List<T> mutableListOfWithSize(int i2, T... tArr) {
        AppMethodBeat.i(5078);
        int max = Math.max(i2, tArr.length);
        if (max == 0) {
            List<T> mutableListOf = mutableListOf();
            AppMethodBeat.o(5078);
            return mutableListOf;
        } else if (tArr.length == 0) {
            List<T> mutableListOfWithSize = mutableListOfWithSize(i2);
            AppMethodBeat.o(5078);
            return mutableListOfWithSize;
        } else if (tArr.length == max) {
            ArrayList arrayList = new ArrayList(Arrays.asList(tArr));
            AppMethodBeat.o(5078);
            return arrayList;
        } else {
            List<T> zzc = zzc(max, true);
            zzc.addAll(Arrays.asList(tArr));
            AppMethodBeat.o(5078);
            return zzc;
        }
    }

    public static <K, V> Map<K, V> mutableMapOf() {
        AppMethodBeat.i(5142);
        a aVar = new a();
        AppMethodBeat.o(5142);
        return aVar;
    }

    public static <K, V> Map<K, V> mutableMapOf(K k, V v) {
        AppMethodBeat.i(5143);
        Map<K, V> mutableMapOfWithSize = mutableMapOfWithSize(1, k, v);
        AppMethodBeat.o(5143);
        return mutableMapOfWithSize;
    }

    public static <K, V> Map<K, V> mutableMapOf(K k, V v, K k2, V v2) {
        AppMethodBeat.i(5144);
        Map<K, V> mutableMapOfWithSize = mutableMapOfWithSize(2, k, v, k2, v2);
        AppMethodBeat.o(5144);
        return mutableMapOfWithSize;
    }

    public static <K, V> Map<K, V> mutableMapOf(K k, V v, K k2, V v2, K k3, V v3) {
        AppMethodBeat.i(5145);
        Map<K, V> mutableMapOfWithSize = mutableMapOfWithSize(3, k, v, k2, v2, k3, v3);
        AppMethodBeat.o(5145);
        return mutableMapOfWithSize;
    }

    public static <K, V> Map<K, V> mutableMapOfKeyValueArrays(K[] kArr, V[] vArr) {
        AppMethodBeat.i(5146);
        zza(kArr, vArr);
        int length = kArr.length;
        if (length == 0) {
            Map<K, V> mutableMapOf = mutableMapOf();
            AppMethodBeat.o(5146);
            return mutableMapOf;
        }
        Map<K, V> zza = zza(length, true, kArr, vArr);
        AppMethodBeat.o(5146);
        return zza;
    }

    public static <K, V> Map<K, V> mutableMapOfKeyValueArraysWithSize(int i2, K[] kArr, V[] vArr) {
        AppMethodBeat.i(5141);
        zza(kArr, vArr);
        int max = Math.max(i2, kArr.length);
        if (max == 0) {
            Map<K, V> mutableMapOf = mutableMapOf();
            AppMethodBeat.o(5141);
            return mutableMapOf;
        } else if (kArr.length == 0) {
            Map<K, V> mutableMapOfWithSize = mutableMapOfWithSize(i2);
            AppMethodBeat.o(5141);
            return mutableMapOfWithSize;
        } else {
            Map<K, V> zza = zza(max, true, kArr, vArr);
            AppMethodBeat.o(5141);
            return zza;
        }
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i2) {
        AppMethodBeat.i(5137);
        if (i2 == 0) {
            Map<K, V> mutableMapOf = mutableMapOf();
            AppMethodBeat.o(5137);
            return mutableMapOf;
        }
        Map<K, V> zzf = zzf(i2, true);
        AppMethodBeat.o(5137);
        return zzf;
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i2, K k, V v) {
        AppMethodBeat.i(5138);
        Map<K, V> zzf = zzf(Math.max(i2, 1), true);
        zzf.put(k, v);
        AppMethodBeat.o(5138);
        return zzf;
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i2, K k, V v, K k2, V v2) {
        AppMethodBeat.i(5139);
        Map<K, V> zzf = zzf(Math.max(i2, 2), true);
        zzf.put(k, v);
        zzf.put(k2, v2);
        AppMethodBeat.o(5139);
        return zzf;
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i2, K k, V v, K k2, V v2, K k3, V v3) {
        AppMethodBeat.i(5140);
        Map<K, V> zzf = zzf(Math.max(i2, 3), true);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        AppMethodBeat.o(5140);
        return zzf;
    }

    public static <T> Set<T> mutableSetOf() {
        AppMethodBeat.i(TXLiteAVCode.WARNING_ROOM_NET_BUSY);
        b bVar = new b();
        AppMethodBeat.o(TXLiteAVCode.WARNING_ROOM_NET_BUSY);
        return bVar;
    }

    public static <T> Set<T> mutableSetOf(T t) {
        AppMethodBeat.i(5104);
        Set<T> mutableSetOfWithSize = mutableSetOfWithSize(1, t);
        AppMethodBeat.o(5104);
        return mutableSetOfWithSize;
    }

    public static <T> Set<T> mutableSetOf(T t, T t2) {
        AppMethodBeat.i(5105);
        Set<T> mutableSetOfWithSize = mutableSetOfWithSize(2, t, t2);
        AppMethodBeat.o(5105);
        return mutableSetOfWithSize;
    }

    public static <T> Set<T> mutableSetOf(T... tArr) {
        AppMethodBeat.i(5106);
        if (tArr.length == 0) {
            Set<T> mutableSetOf = mutableSetOf();
            AppMethodBeat.o(5106);
            return mutableSetOf;
        }
        Set<T> zza = zza(tArr.length, true, (Object[]) tArr);
        AppMethodBeat.o(5106);
        return zza;
    }

    public static <T> Set<T> mutableSetOfWithSize(int i2) {
        AppMethodBeat.i(5099);
        if (i2 == 0) {
            Set<T> mutableSetOf = mutableSetOf();
            AppMethodBeat.o(5099);
            return mutableSetOf;
        }
        Set<T> zzd = zzd(i2, true);
        AppMethodBeat.o(5099);
        return zzd;
    }

    public static <T> Set<T> mutableSetOfWithSize(int i2, T t) {
        AppMethodBeat.i(5100);
        Set<T> zzd = zzd(Math.max(i2, 1), true);
        zzd.add(t);
        AppMethodBeat.o(5100);
        return zzd;
    }

    public static <T> Set<T> mutableSetOfWithSize(int i2, T t, T t2) {
        AppMethodBeat.i(TXLiteAVCode.WARNING_ROOM_DISCONNECT);
        Set<T> zzd = zzd(Math.max(i2, 2), true);
        zzd.add(t);
        zzd.add(t2);
        AppMethodBeat.o(TXLiteAVCode.WARNING_ROOM_DISCONNECT);
        return zzd;
    }

    public static <T> Set<T> mutableSetOfWithSize(int i2, T... tArr) {
        AppMethodBeat.i(TXLiteAVCode.WARNING_ROOM_RECONNECT);
        int max = Math.max(i2, tArr.length);
        if (max == 0) {
            Set<T> mutableSetOf = mutableSetOf();
            AppMethodBeat.o(TXLiteAVCode.WARNING_ROOM_RECONNECT);
            return mutableSetOf;
        } else if (tArr.length == 0) {
            Set<T> mutableSetOfWithSize = mutableSetOfWithSize(i2);
            AppMethodBeat.o(TXLiteAVCode.WARNING_ROOM_RECONNECT);
            return mutableSetOfWithSize;
        } else {
            Set<T> zza = zza(max, true, (Object[]) tArr);
            AppMethodBeat.o(TXLiteAVCode.WARNING_ROOM_RECONNECT);
            return zza;
        }
    }

    @Deprecated
    public static <T> Set<T> setOf() {
        AppMethodBeat.i(5085);
        Set<T> emptySet = Collections.emptySet();
        AppMethodBeat.o(5085);
        return emptySet;
    }

    @Deprecated
    public static <T> Set<T> setOf(T t) {
        AppMethodBeat.i(5086);
        Set<T> singleton = Collections.singleton(t);
        AppMethodBeat.o(5086);
        return singleton;
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2) {
        AppMethodBeat.i(5087);
        Set zzd = zzd(2, false);
        zzd.add(t);
        zzd.add(t2);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(zzd);
        AppMethodBeat.o(5087);
        return unmodifiableSet;
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3) {
        AppMethodBeat.i(5088);
        Set zzd = zzd(3, false);
        zzd.add(t);
        zzd.add(t2);
        zzd.add(t3);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(zzd);
        AppMethodBeat.o(5088);
        return unmodifiableSet;
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3, T t4) {
        AppMethodBeat.i(5089);
        Set zzd = zzd(4, false);
        zzd.add(t);
        zzd.add(t2);
        zzd.add(t3);
        zzd.add(t4);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(zzd);
        AppMethodBeat.o(5089);
        return unmodifiableSet;
    }

    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        AppMethodBeat.i(5090);
        switch (tArr.length) {
            case 0:
                Set<T> of = setOf();
                AppMethodBeat.o(5090);
                return of;
            case 1:
                Set<T> of2 = setOf(tArr[0]);
                AppMethodBeat.o(5090);
                return of2;
            case 2:
                Set<T> of3 = setOf(tArr[0], tArr[1]);
                AppMethodBeat.o(5090);
                return of3;
            case 3:
                Set<T> of4 = setOf(tArr[0], tArr[1], tArr[2]);
                AppMethodBeat.o(5090);
                return of4;
            case 4:
                Set<T> of5 = setOf(tArr[0], tArr[1], tArr[2], tArr[3]);
                AppMethodBeat.o(5090);
                return of5;
            default:
                Set<T> unmodifiableSet = Collections.unmodifiableSet(zza(tArr.length, false, (Object[]) tArr));
                AppMethodBeat.o(5090);
                return unmodifiableSet;
        }
    }

    private static <K, V> Map<K, V> zza(int i2, boolean z, K[] kArr, V[] vArr) {
        AppMethodBeat.i(5118);
        Map<K, V> zzf = zzf(i2, z);
        zza(zzf, kArr, vArr);
        AppMethodBeat.o(5118);
        return zzf;
    }

    private static <T> Set<T> zza(int i2, boolean z, T[] tArr) {
        AppMethodBeat.i(5084);
        Set<T> zzd = zzd(i2, z);
        Collections.addAll(zzd, tArr);
        AppMethodBeat.o(5084);
        return zzd;
    }

    private static <K, V> void zza(Map<K, V> map, K[] kArr, V[] vArr) {
        AppMethodBeat.i(5116);
        for (int i2 = 0; i2 < kArr.length; i2++) {
            map.put(kArr[i2], vArr[i2]);
        }
        AppMethodBeat.o(5116);
    }

    private static <K, V> void zza(K[] kArr, V[] vArr) {
        AppMethodBeat.i(5115);
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(66).append("Key and values array lengths not equal: ").append(length).append(" != ").append(vArr.length).toString());
            AppMethodBeat.o(5115);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(5115);
    }

    private static <K, V> Map<K, V> zzb(int i2, boolean z, K[] kArr, V[] vArr) {
        AppMethodBeat.i(5128);
        Map<K, V> zzg = zzg(i2, z);
        zza(zzg, kArr, vArr);
        AppMethodBeat.o(5128);
        return zzg;
    }

    private static <T> Set<T> zzb(int i2, boolean z, T[] tArr) {
        AppMethodBeat.i(5092);
        Set<T> zze = zze(i2, z);
        Collections.addAll(zze, tArr);
        AppMethodBeat.o(5092);
        return zze;
    }

    private static <T> List<T> zzc(int i2, boolean z) {
        AppMethodBeat.i(5071);
        ArrayList arrayList = new ArrayList(i2);
        AppMethodBeat.o(5071);
        return arrayList;
    }

    private static <T> Set<T> zzd(int i2, boolean z) {
        AppMethodBeat.i(5083);
        float f2 = z ? 0.75f : 1.0f;
        if (i2 <= (z ? 128 : 256)) {
            b bVar = new b(i2);
            AppMethodBeat.o(5083);
            return bVar;
        }
        HashSet hashSet = new HashSet(i2, f2);
        AppMethodBeat.o(5083);
        return hashSet;
    }

    private static <T> Set<T> zze(int i2, boolean z) {
        AppMethodBeat.i(5091);
        LinkedHashSet linkedHashSet = new LinkedHashSet(i2, z ? 0.75f : 1.0f);
        AppMethodBeat.o(5091);
        return linkedHashSet;
    }

    private static <K, V> Map<K, V> zzf(int i2, boolean z) {
        AppMethodBeat.i(5117);
        float f2 = z ? 0.75f : 1.0f;
        if (i2 <= (z ? 128 : 256)) {
            a aVar = new a(i2);
            AppMethodBeat.o(5117);
            return aVar;
        }
        HashMap hashMap = new HashMap(i2, f2);
        AppMethodBeat.o(5117);
        return hashMap;
    }

    private static <K, V> Map<K, V> zzg(int i2, boolean z) {
        AppMethodBeat.i(5127);
        LinkedHashMap linkedHashMap = new LinkedHashMap(i2, z ? 0.75f : 1.0f);
        AppMethodBeat.o(5127);
        return linkedHashMap;
    }
}
