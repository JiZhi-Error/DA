package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        AppMethodBeat.i(4816);
        int zza = zza(parcel, 20293);
        AppMethodBeat.o(4816);
        return zza;
    }

    public static void finishObjectHeader(Parcel parcel, int i2) {
        AppMethodBeat.i(4817);
        zzb(parcel, i2);
        AppMethodBeat.o(4817);
    }

    public static void writeBigDecimal(Parcel parcel, int i2, BigDecimal bigDecimal, boolean z) {
        AppMethodBeat.i(4832);
        if (bigDecimal == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4832);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        zzb(parcel, zza);
        AppMethodBeat.o(4832);
    }

    public static void writeBigDecimalArray(Parcel parcel, int i2, BigDecimal[] bigDecimalArr, boolean z) {
        AppMethodBeat.i(4846);
        if (bigDecimalArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4846);
            return;
        }
        int zza = zza(parcel, i2);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i3 = 0; i3 < length; i3++) {
            parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i3].scale());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4846);
    }

    public static void writeBigInteger(Parcel parcel, int i2, BigInteger bigInteger, boolean z) {
        AppMethodBeat.i(4827);
        if (bigInteger == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4827);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeByteArray(bigInteger.toByteArray());
        zzb(parcel, zza);
        AppMethodBeat.o(4827);
    }

    public static void writeBigIntegerArray(Parcel parcel, int i2, BigInteger[] bigIntegerArr, boolean z) {
        AppMethodBeat.i(4843);
        if (bigIntegerArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4843);
            return;
        }
        int zza = zza(parcel, i2);
        int length = bigIntegerArr.length;
        parcel.writeInt(length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4843);
    }

    public static void writeBoolean(Parcel parcel, int i2, boolean z) {
        AppMethodBeat.i(4818);
        zzb(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.o(4818);
    }

    public static void writeBooleanArray(Parcel parcel, int i2, boolean[] zArr, boolean z) {
        AppMethodBeat.i(4839);
        if (zArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4839);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeBooleanArray(zArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4839);
    }

    public static void writeBooleanList(Parcel parcel, int i2, List<Boolean> list, boolean z) {
        AppMethodBeat.i(4849);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4849);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).booleanValue() ? 1 : 0);
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4849);
    }

    public static void writeBooleanObject(Parcel parcel, int i2, Boolean bool, boolean z) {
        int i3 = 0;
        AppMethodBeat.i(4819);
        if (bool == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4819);
            return;
        }
        zzb(parcel, i2, 4);
        if (bool.booleanValue()) {
            i3 = 1;
        }
        parcel.writeInt(i3);
        AppMethodBeat.o(4819);
    }

    public static void writeBundle(Parcel parcel, int i2, Bundle bundle, boolean z) {
        AppMethodBeat.i(4836);
        if (bundle == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4836);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeBundle(bundle);
        zzb(parcel, zza);
        AppMethodBeat.o(4836);
    }

    public static void writeByte(Parcel parcel, int i2, byte b2) {
        AppMethodBeat.i(4820);
        zzb(parcel, i2, 4);
        parcel.writeInt(b2);
        AppMethodBeat.o(4820);
    }

    public static void writeByteArray(Parcel parcel, int i2, byte[] bArr, boolean z) {
        AppMethodBeat.i(4837);
        if (bArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4837);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeByteArray(bArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4837);
    }

    public static void writeByteArrayArray(Parcel parcel, int i2, byte[][] bArr, boolean z) {
        AppMethodBeat.i(4838);
        if (bArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4838);
            return;
        }
        int zza = zza(parcel, i2);
        int length = bArr.length;
        parcel.writeInt(length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4838);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i2, SparseArray<byte[]> sparseArray, boolean z) {
        AppMethodBeat.i(4872);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4872);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeByteArray(sparseArray.valueAt(i3));
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4872);
    }

    public static void writeChar(Parcel parcel, int i2, char c2) {
        AppMethodBeat.i(4821);
        zzb(parcel, i2, 4);
        parcel.writeInt(c2);
        AppMethodBeat.o(4821);
    }

    public static void writeCharArray(Parcel parcel, int i2, char[] cArr, boolean z) {
        AppMethodBeat.i(4840);
        if (cArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4840);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeCharArray(cArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4840);
    }

    public static void writeDouble(Parcel parcel, int i2, double d2) {
        AppMethodBeat.i(4830);
        zzb(parcel, i2, 8);
        parcel.writeDouble(d2);
        AppMethodBeat.o(4830);
    }

    public static void writeDoubleArray(Parcel parcel, int i2, double[] dArr, boolean z) {
        AppMethodBeat.i(4845);
        if (dArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4845);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeDoubleArray(dArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4845);
    }

    public static void writeDoubleList(Parcel parcel, int i2, List<Double> list, boolean z) {
        AppMethodBeat.i(4853);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4853);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeDouble(list.get(i3).doubleValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4853);
    }

    public static void writeDoubleObject(Parcel parcel, int i2, Double d2, boolean z) {
        AppMethodBeat.i(4831);
        if (d2 == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4831);
            return;
        }
        zzb(parcel, i2, 8);
        parcel.writeDouble(d2.doubleValue());
        AppMethodBeat.o(4831);
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i2, SparseArray<Double> sparseArray, boolean z) {
        AppMethodBeat.i(4864);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4864);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4864);
    }

    public static void writeFloat(Parcel parcel, int i2, float f2) {
        AppMethodBeat.i(4828);
        zzb(parcel, i2, 4);
        parcel.writeFloat(f2);
        AppMethodBeat.o(4828);
    }

    public static void writeFloatArray(Parcel parcel, int i2, float[] fArr, boolean z) {
        AppMethodBeat.i(4844);
        if (fArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4844);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeFloatArray(fArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4844);
    }

    public static void writeFloatList(Parcel parcel, int i2, List<Float> list, boolean z) {
        AppMethodBeat.i(4852);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4852);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeFloat(list.get(i3).floatValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4852);
    }

    public static void writeFloatObject(Parcel parcel, int i2, Float f2, boolean z) {
        AppMethodBeat.i(4829);
        if (f2 == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4829);
            return;
        }
        zzb(parcel, i2, 4);
        parcel.writeFloat(f2.floatValue());
        AppMethodBeat.o(4829);
    }

    public static void writeFloatSparseArray(Parcel parcel, int i2, SparseArray<Float> sparseArray, boolean z) {
        AppMethodBeat.i(4865);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4865);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4865);
    }

    public static void writeIBinder(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        AppMethodBeat.i(4834);
        if (iBinder == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4834);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeStrongBinder(iBinder);
        zzb(parcel, zza);
        AppMethodBeat.o(4834);
    }

    public static void writeIBinderArray(Parcel parcel, int i2, IBinder[] iBinderArr, boolean z) {
        AppMethodBeat.i(4848);
        if (iBinderArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4848);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeBinderArray(iBinderArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4848);
    }

    public static void writeIBinderList(Parcel parcel, int i2, List<IBinder> list, boolean z) {
        AppMethodBeat.i(4855);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4855);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeBinderList(list);
        zzb(parcel, zza);
        AppMethodBeat.o(4855);
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i2, SparseArray<IBinder> sparseArray, boolean z) {
        AppMethodBeat.i(4871);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4871);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeStrongBinder(sparseArray.valueAt(i3));
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4871);
    }

    public static void writeInt(Parcel parcel, int i2, int i3) {
        AppMethodBeat.i(4823);
        zzb(parcel, i2, 4);
        parcel.writeInt(i3);
        AppMethodBeat.o(4823);
    }

    public static void writeIntArray(Parcel parcel, int i2, int[] iArr, boolean z) {
        AppMethodBeat.i(4841);
        if (iArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4841);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeIntArray(iArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4841);
    }

    public static void writeIntegerList(Parcel parcel, int i2, List<Integer> list, boolean z) {
        AppMethodBeat.i(4850);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4850);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).intValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4850);
    }

    public static void writeIntegerObject(Parcel parcel, int i2, Integer num, boolean z) {
        AppMethodBeat.i(4824);
        if (num == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4824);
            return;
        }
        zzb(parcel, i2, 4);
        parcel.writeInt(num.intValue());
        AppMethodBeat.o(4824);
    }

    public static void writeList(Parcel parcel, int i2, List list, boolean z) {
        AppMethodBeat.i(4862);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4862);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeList(list);
        zzb(parcel, zza);
        AppMethodBeat.o(4862);
    }

    public static void writeLong(Parcel parcel, int i2, long j2) {
        AppMethodBeat.i(4825);
        zzb(parcel, i2, 8);
        parcel.writeLong(j2);
        AppMethodBeat.o(4825);
    }

    public static void writeLongArray(Parcel parcel, int i2, long[] jArr, boolean z) {
        AppMethodBeat.i(4842);
        if (jArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4842);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeLongArray(jArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4842);
    }

    public static void writeLongList(Parcel parcel, int i2, List<Long> list, boolean z) {
        AppMethodBeat.i(4851);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4851);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeLong(list.get(i3).longValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4851);
    }

    public static void writeLongObject(Parcel parcel, int i2, Long l, boolean z) {
        AppMethodBeat.i(4826);
        if (l == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4826);
            return;
        }
        zzb(parcel, i2, 8);
        parcel.writeLong(l.longValue());
        AppMethodBeat.o(4826);
    }

    public static void writeParcel(Parcel parcel, int i2, Parcel parcel2, boolean z) {
        AppMethodBeat.i(4859);
        if (parcel2 == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4859);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        zzb(parcel, zza);
        AppMethodBeat.o(4859);
    }

    public static void writeParcelArray(Parcel parcel, int i2, Parcel[] parcelArr, boolean z) {
        AppMethodBeat.i(4860);
        if (parcelArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4860);
            return;
        }
        int zza = zza(parcel, i2);
        int length = parcelArr.length;
        parcel.writeInt(length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4860);
    }

    public static void writeParcelList(Parcel parcel, int i2, List<Parcel> list, boolean z) {
        AppMethodBeat.i(4861);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4861);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcel parcel2 = list.get(i3);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4861);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i2, SparseArray<Parcel> sparseArray, boolean z) {
        AppMethodBeat.i(4869);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4869);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            Parcel valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4869);
    }

    public static void writeParcelable(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        AppMethodBeat.i(4835);
        if (parcelable == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4835);
            return;
        }
        int zza = zza(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        zzb(parcel, zza);
        AppMethodBeat.o(4835);
    }

    public static void writeShort(Parcel parcel, int i2, short s) {
        AppMethodBeat.i(4822);
        zzb(parcel, i2, 4);
        parcel.writeInt(s);
        AppMethodBeat.o(4822);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i2, SparseBooleanArray sparseBooleanArray, boolean z) {
        AppMethodBeat.i(4863);
        if (sparseBooleanArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4863);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeSparseBooleanArray(sparseBooleanArray);
        zzb(parcel, zza);
        AppMethodBeat.o(4863);
    }

    public static void writeSparseIntArray(Parcel parcel, int i2, SparseIntArray sparseIntArray, boolean z) {
        AppMethodBeat.i(4866);
        if (sparseIntArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4866);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseIntArray.keyAt(i3));
            parcel.writeInt(sparseIntArray.valueAt(i3));
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4866);
    }

    public static void writeSparseLongArray(Parcel parcel, int i2, SparseLongArray sparseLongArray, boolean z) {
        AppMethodBeat.i(4867);
        if (sparseLongArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4867);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseLongArray.keyAt(i3));
            parcel.writeLong(sparseLongArray.valueAt(i3));
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4867);
    }

    public static void writeString(Parcel parcel, int i2, String str, boolean z) {
        AppMethodBeat.i(4833);
        if (str == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4833);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeString(str);
        zzb(parcel, zza);
        AppMethodBeat.o(4833);
    }

    public static void writeStringArray(Parcel parcel, int i2, String[] strArr, boolean z) {
        AppMethodBeat.i(4847);
        if (strArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4847);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeStringArray(strArr);
        zzb(parcel, zza);
        AppMethodBeat.o(4847);
    }

    public static void writeStringList(Parcel parcel, int i2, List<String> list, boolean z) {
        AppMethodBeat.i(4854);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4854);
            return;
        }
        int zza = zza(parcel, i2);
        parcel.writeStringList(list);
        zzb(parcel, zza);
        AppMethodBeat.o(4854);
    }

    public static void writeStringSparseArray(Parcel parcel, int i2, SparseArray<String> sparseArray, boolean z) {
        AppMethodBeat.i(4868);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4868);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeString(sparseArray.valueAt(i3));
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4868);
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        AppMethodBeat.i(4856);
        if (tArr == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4856);
            return;
        }
        int zza = zza(parcel, i2);
        int length = tArr.length;
        parcel.writeInt(length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, t, i3);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4856);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i2, List<T> list, boolean z) {
        AppMethodBeat.i(4857);
        if (list == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4857);
            return;
        }
        int zza = zza(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, t, 0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4857);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i2, SparseArray<T> sparseArray, boolean z) {
        AppMethodBeat.i(4870);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i2, 0);
            }
            AppMethodBeat.o(4870);
            return;
        }
        int zza = zza(parcel, i2);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            T valueAt = sparseArray.valueAt(i3);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, valueAt, 0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.o(4870);
    }

    private static int zza(Parcel parcel, int i2) {
        AppMethodBeat.i(4814);
        parcel.writeInt(-65536 | i2);
        parcel.writeInt(0);
        int dataPosition = parcel.dataPosition();
        AppMethodBeat.o(4814);
        return dataPosition;
    }

    private static <T extends Parcelable> void zza(Parcel parcel, T t, int i2) {
        AppMethodBeat.i(4858);
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
        AppMethodBeat.o(4858);
    }

    private static void zzb(Parcel parcel, int i2) {
        AppMethodBeat.i(4815);
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
        AppMethodBeat.o(4815);
    }

    private static void zzb(Parcel parcel, int i2, int i3) {
        AppMethodBeat.i(4813);
        if (i3 >= 65535) {
            parcel.writeInt(-65536 | i2);
            parcel.writeInt(i3);
            AppMethodBeat.o(4813);
            return;
        }
        parcel.writeInt((i3 << 16) | i2);
        AppMethodBeat.o(4813);
    }
}
