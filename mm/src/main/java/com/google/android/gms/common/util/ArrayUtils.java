package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@VisibleForTesting
public final class ArrayUtils {

    static class zza {
        HashMap<Object, zza> zzzb;

        zza(int i2) {
            AppMethodBeat.i(5017);
            this.zzzb = new HashMap<>(i2);
            AppMethodBeat.o(5017);
        }

        private final zza zzd(Object obj) {
            AppMethodBeat.i(5020);
            zza zza = this.zzzb.get(obj);
            if (zza == null) {
                zza = new zza();
                this.zzzb.put(obj, zza);
            }
            AppMethodBeat.o(5020);
            return zza;
        }

        /* access modifiers changed from: package-private */
        public final void zzb(Object obj) {
            AppMethodBeat.i(5018);
            zzd(obj).count++;
            AppMethodBeat.o(5018);
        }

        /* access modifiers changed from: package-private */
        public final void zzc(Object obj) {
            AppMethodBeat.i(5019);
            zza zzd = zzd(obj);
            zzd.count--;
            AppMethodBeat.o(5019);
        }
    }

    private ArrayUtils() {
    }

    public static int[] appendToArray(int[] iArr, int i2) {
        AppMethodBeat.i(5043);
        int[] copyOf = (iArr == null || iArr.length == 0) ? new int[1] : Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i2;
        AppMethodBeat.o(5043);
        return copyOf;
    }

    public static <T> T[] appendToArray(T[] tArr, T t) {
        AppMethodBeat.i(5042);
        if (tArr == null && t == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot generate array of generic type w/o class info");
            AppMethodBeat.o(5042);
            throw illegalArgumentException;
        }
        T[] tArr2 = tArr == null ? (T[]) ((Object[]) Array.newInstance(t.getClass(), 1)) : (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr2.length - 1] = t;
        AppMethodBeat.o(5042);
        return tArr2;
    }

    public static <T> T[] concat(T[]... tArr) {
        AppMethodBeat.i(5040);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
            AppMethodBeat.o(5040);
            return tArr2;
        }
        int i2 = 0;
        for (T[] tArr3 : tArr) {
            i2 += tArr3.length;
        }
        T[] tArr4 = (T[]) Arrays.copyOf(tArr[0], i2);
        int length = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr5 = tArr[i3];
            System.arraycopy(tArr5, 0, tArr4, length, tArr5.length);
            length += tArr5.length;
        }
        AppMethodBeat.o(5040);
        return tArr4;
    }

    public static byte[] concatByteArrays(byte[]... bArr) {
        AppMethodBeat.i(5041);
        if (bArr.length == 0) {
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(5041);
            return bArr2;
        }
        int i2 = 0;
        for (byte[] bArr3 : bArr) {
            i2 += bArr3.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i2);
        int length = bArr[0].length;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            byte[] bArr4 = bArr[i3];
            System.arraycopy(bArr4, 0, copyOf, length, bArr4.length);
            length += bArr4.length;
        }
        AppMethodBeat.o(5041);
        return copyOf;
    }

    public static boolean contains(byte[] bArr, byte b2) {
        if (bArr == null) {
            return false;
        }
        for (byte b3 : bArr) {
            if (b3 == b2) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] cArr, char c2) {
        if (cArr == null) {
            return false;
        }
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(double[] dArr, double d2) {
        if (dArr == null) {
            return false;
        }
        for (double d3 : dArr) {
            if (d3 == d2) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(float[] fArr, float f2, float f3) {
        if (fArr == null) {
            return false;
        }
        float f4 = f2 - f3;
        float f5 = f2 + f3;
        for (float f6 : fArr) {
            if (f4 <= f6 && f6 <= f5) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        AppMethodBeat.i(5022);
        if (indexOf(tArr, t) >= 0) {
            AppMethodBeat.o(5022);
            return true;
        }
        AppMethodBeat.o(5022);
        return false;
    }

    public static boolean contains(short[] sArr, short s) {
        if (sArr == null) {
            return false;
        }
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        if (zArr == null) {
            return false;
        }
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(String[] strArr, String str) {
        AppMethodBeat.i(5023);
        if (strArr == null) {
            AppMethodBeat.o(5023);
            return false;
        }
        for (String str2 : strArr) {
            if (str2 == str) {
                AppMethodBeat.o(5023);
                return true;
            } else if (str2 != null && str2.equalsIgnoreCase(str)) {
                AppMethodBeat.o(5023);
                return true;
            }
        }
        AppMethodBeat.o(5023);
        return false;
    }

    public static boolean equalsAnyOrder(Object[] objArr, Object[] objArr2) {
        AppMethodBeat.i(5024);
        if (objArr == objArr2) {
            AppMethodBeat.o(5024);
            return true;
        }
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        if (length == 0 && length2 == 0) {
            AppMethodBeat.o(5024);
            return true;
        } else if (length != length2) {
            AppMethodBeat.o(5024);
            return false;
        } else {
            zza zza2 = new zza(length);
            for (Object obj : objArr) {
                zza2.zzb(obj);
            }
            for (Object obj2 : objArr2) {
                zza2.zzc(obj2);
            }
            for (zza zza3 : zza2.zzzb.values()) {
                if (zza3.count != 0) {
                    AppMethodBeat.o(5024);
                    return false;
                }
            }
            AppMethodBeat.o(5024);
            return true;
        }
    }

    public static <T> int indexOf(T[] tArr, T t) {
        AppMethodBeat.i(5021);
        int length = tArr != null ? tArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Objects.equal(tArr[i2], t)) {
                AppMethodBeat.o(5021);
                return i2;
            }
        }
        AppMethodBeat.o(5021);
        return -1;
    }

    public static <T> ArrayList<T> newArrayList() {
        AppMethodBeat.i(5049);
        ArrayList<T> arrayList = new ArrayList<>();
        AppMethodBeat.o(5049);
        return arrayList;
    }

    public static <T> int rearrange(T[] tArr, Predicate<T> predicate) {
        AppMethodBeat.i(5048);
        if (tArr == null || tArr.length == 0) {
            AppMethodBeat.o(5048);
            return 0;
        }
        int length = tArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (predicate.apply(tArr[i3])) {
                if (i2 != i3) {
                    T t = tArr[i2];
                    tArr[i2] = tArr[i3];
                    tArr[i3] = t;
                }
                i2++;
            }
        }
        AppMethodBeat.o(5048);
        return i2;
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(5045);
        if (iArr == null) {
            AppMethodBeat.o(5045);
            return null;
        } else if (iArr2 == null || iArr2.length == 0) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            AppMethodBeat.o(5045);
            return copyOf;
        } else {
            int[] iArr3 = new int[iArr.length];
            if (iArr2.length == 1) {
                int length = iArr.length;
                int i5 = 0;
                i2 = 0;
                while (i5 < length) {
                    int i6 = iArr[i5];
                    if (iArr2[0] != i6) {
                        i4 = i2 + 1;
                        iArr3[i2] = i6;
                    } else {
                        i4 = i2;
                    }
                    i5++;
                    i2 = i4;
                }
            } else {
                int length2 = iArr.length;
                int i7 = 0;
                i2 = 0;
                while (i7 < length2) {
                    int i8 = iArr[i7];
                    if (!contains(iArr2, i8)) {
                        i3 = i2 + 1;
                        iArr3[i2] = i8;
                    } else {
                        i3 = i2;
                    }
                    i7++;
                    i2 = i3;
                }
            }
            int[] resize = resize(iArr3, i2);
            AppMethodBeat.o(5045);
            return resize;
        }
    }

    public static <T> T[] removeAll(T[] tArr, T... tArr2) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(5044);
        if (tArr == null) {
            AppMethodBeat.o(5044);
            return null;
        } else if (tArr2 == null || tArr2.length == 0) {
            T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length);
            AppMethodBeat.o(5044);
            return tArr3;
        } else {
            Object[] objArr = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
            if (tArr2.length == 1) {
                int length = tArr.length;
                int i5 = 0;
                i2 = 0;
                while (i5 < length) {
                    T t = tArr[i5];
                    if (!Objects.equal(tArr2[0], t)) {
                        i4 = i2 + 1;
                        objArr[i2] = t;
                    } else {
                        i4 = i2;
                    }
                    i5++;
                    i2 = i4;
                }
            } else {
                int length2 = tArr.length;
                int i6 = 0;
                i2 = 0;
                while (i6 < length2) {
                    T t2 = tArr[i6];
                    if (!contains(tArr2, t2)) {
                        i3 = i2 + 1;
                        objArr[i2] = t2;
                    } else {
                        i3 = i2;
                    }
                    i6++;
                    i2 = i3;
                }
            }
            T[] tArr4 = (T[]) resize(objArr, i2);
            AppMethodBeat.o(5044);
            return tArr4;
        }
    }

    public static int[] resize(int[] iArr, int i2) {
        AppMethodBeat.i(5047);
        if (iArr == null) {
            AppMethodBeat.o(5047);
            return null;
        }
        if (i2 != iArr.length) {
            iArr = Arrays.copyOf(iArr, i2);
        }
        AppMethodBeat.o(5047);
        return iArr;
    }

    public static <T> T[] resize(T[] tArr, int i2) {
        AppMethodBeat.i(5046);
        if (tArr == null) {
            AppMethodBeat.o(5046);
            return null;
        }
        if (i2 != tArr.length) {
            tArr = (T[]) Arrays.copyOf(tArr, i2);
        }
        AppMethodBeat.o(5046);
        return tArr;
    }

    public static <T> ArrayList<T> toArrayList(Collection<T> collection) {
        AppMethodBeat.i(5051);
        if (collection == null) {
            AppMethodBeat.o(5051);
            return null;
        }
        ArrayList<T> arrayList = new ArrayList<>(collection);
        AppMethodBeat.o(5051);
        return arrayList;
    }

    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        AppMethodBeat.i(5050);
        int length = tArr.length;
        ArrayList<T> arrayList = new ArrayList<>(length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        AppMethodBeat.o(5050);
        return arrayList;
    }

    public static long[] toLongArray(Collection<Long> collection) {
        AppMethodBeat.i(5054);
        if (collection == null || collection.size() == 0) {
            long[] jArr = new long[0];
            AppMethodBeat.o(5054);
            return jArr;
        }
        long[] jArr2 = new long[collection.size()];
        int i2 = 0;
        for (Long l : collection) {
            jArr2[i2] = l.longValue();
            i2++;
        }
        AppMethodBeat.o(5054);
        return jArr2;
    }

    public static long[] toLongArray(Long[] lArr) {
        AppMethodBeat.i(5055);
        if (lArr == null) {
            long[] jArr = new long[0];
            AppMethodBeat.o(5055);
            return jArr;
        }
        long[] jArr2 = new long[lArr.length];
        for (int i2 = 0; i2 < lArr.length; i2++) {
            jArr2[i2] = lArr[i2].longValue();
        }
        AppMethodBeat.o(5055);
        return jArr2;
    }

    public static int[] toPrimitiveArray(Collection<Integer> collection) {
        AppMethodBeat.i(5052);
        if (collection == null || collection.size() == 0) {
            int[] iArr = new int[0];
            AppMethodBeat.o(5052);
            return iArr;
        }
        int[] iArr2 = new int[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            iArr2[i2] = num.intValue();
            i2++;
        }
        AppMethodBeat.o(5052);
        return iArr2;
    }

    public static int[] toPrimitiveArray(Integer[] numArr) {
        AppMethodBeat.i(5053);
        if (numArr == null) {
            int[] iArr = new int[0];
            AppMethodBeat.o(5053);
            return iArr;
        }
        int[] iArr2 = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            iArr2[i2] = numArr[i2].intValue();
        }
        AppMethodBeat.o(5053);
        return iArr2;
    }

    public static String[] toStringArray(Collection<String> collection) {
        AppMethodBeat.i(5056);
        if (collection == null || collection.size() == 0) {
            String[] strArr = new String[0];
            AppMethodBeat.o(5056);
            return strArr;
        }
        String[] strArr2 = (String[]) collection.toArray(new String[collection.size()]);
        AppMethodBeat.o(5056);
        return strArr2;
    }

    public static Boolean[] toWrapperArray(boolean[] zArr) {
        AppMethodBeat.i(5031);
        if (zArr == null) {
            AppMethodBeat.o(5031);
            return null;
        }
        int length = zArr.length;
        Boolean[] boolArr = new Boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        AppMethodBeat.o(5031);
        return boolArr;
    }

    public static Byte[] toWrapperArray(byte[] bArr) {
        AppMethodBeat.i(5030);
        if (bArr == null) {
            AppMethodBeat.o(5030);
            return null;
        }
        int length = bArr.length;
        Byte[] bArr2 = new Byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        AppMethodBeat.o(5030);
        return bArr2;
    }

    public static Character[] toWrapperArray(char[] cArr) {
        AppMethodBeat.i(5026);
        if (cArr == null) {
            AppMethodBeat.o(5026);
            return null;
        }
        int length = cArr.length;
        Character[] chArr = new Character[length];
        for (int i2 = 0; i2 < length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        AppMethodBeat.o(5026);
        return chArr;
    }

    public static Double[] toWrapperArray(double[] dArr) {
        AppMethodBeat.i(5028);
        if (dArr == null) {
            AppMethodBeat.o(5028);
            return null;
        }
        int length = dArr.length;
        Double[] dArr2 = new Double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        AppMethodBeat.o(5028);
        return dArr2;
    }

    public static Float[] toWrapperArray(float[] fArr) {
        AppMethodBeat.i(5029);
        if (fArr == null) {
            AppMethodBeat.o(5029);
            return null;
        }
        int length = fArr.length;
        Float[] fArr2 = new Float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        AppMethodBeat.o(5029);
        return fArr2;
    }

    public static Integer[] toWrapperArray(int[] iArr) {
        AppMethodBeat.i(5025);
        if (iArr == null) {
            AppMethodBeat.o(5025);
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        AppMethodBeat.o(5025);
        return numArr;
    }

    public static Long[] toWrapperArray(long[] jArr) {
        AppMethodBeat.i(5027);
        if (jArr == null) {
            AppMethodBeat.o(5027);
            return null;
        }
        int length = jArr.length;
        Long[] lArr = new Long[length];
        for (int i2 = 0; i2 < length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        AppMethodBeat.o(5027);
        return lArr;
    }

    public static Short[] toWrapperArray(short[] sArr) {
        AppMethodBeat.i(5032);
        if (sArr == null) {
            AppMethodBeat.o(5032);
            return null;
        }
        int length = sArr.length;
        Short[] shArr = new Short[length];
        for (int i2 = 0; i2 < length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        AppMethodBeat.o(5032);
        return shArr;
    }

    public static void writeArray(StringBuilder sb, double[] dArr) {
        AppMethodBeat.i(5037);
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i2]));
        }
        AppMethodBeat.o(5037);
    }

    public static void writeArray(StringBuilder sb, float[] fArr) {
        AppMethodBeat.i(5036);
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i2]));
        }
        AppMethodBeat.o(5036);
    }

    public static void writeArray(StringBuilder sb, int[] iArr) {
        AppMethodBeat.i(5034);
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i2]));
        }
        AppMethodBeat.o(5034);
    }

    public static void writeArray(StringBuilder sb, long[] jArr) {
        AppMethodBeat.i(5035);
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i2]));
        }
        AppMethodBeat.o(5035);
    }

    public static <T> void writeArray(StringBuilder sb, T[] tArr) {
        AppMethodBeat.i(5033);
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i2].toString());
        }
        AppMethodBeat.o(5033);
    }

    public static void writeArray(StringBuilder sb, boolean[] zArr) {
        AppMethodBeat.i(5038);
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i2]));
        }
        AppMethodBeat.o(5038);
    }

    public static void writeStringArray(StringBuilder sb, String[] strArr) {
        AppMethodBeat.i(5039);
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append("\"").append(strArr[i2]).append("\"");
        }
        AppMethodBeat.o(5039);
    }
}
