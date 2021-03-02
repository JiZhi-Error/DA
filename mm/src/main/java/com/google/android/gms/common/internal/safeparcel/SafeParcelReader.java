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
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(java.lang.String r6, android.os.Parcel r7) {
            /*
                r5 = this;
                r4 = 4751(0x128f, float:6.658E-42)
                int r0 = r7.dataPosition()
                int r1 = r7.dataSize()
                java.lang.String r2 = java.lang.String.valueOf(r6)
                int r2 = r2.length()
                int r2 = r2 + 41
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.StringBuilder r2 = r3.append(r6)
                java.lang.String r3 = " Parcel: pos="
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r0 = r2.append(r0)
                java.lang.String r2 = " size="
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                r5.<init>(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    public static BigDecimal createBigDecimal(Parcel parcel, int i2) {
        AppMethodBeat.i(4772);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4772);
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(readSize + dataPosition);
        BigDecimal bigDecimal = new BigDecimal(new BigInteger(createByteArray), readInt);
        AppMethodBeat.o(4772);
        return bigDecimal;
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4786);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4786);
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4786);
        return bigDecimalArr;
    }

    public static BigInteger createBigInteger(Parcel parcel, int i2) {
        AppMethodBeat.i(4767);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4767);
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        BigInteger bigInteger = new BigInteger(createByteArray);
        AppMethodBeat.o(4767);
        return bigInteger;
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4783);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4783);
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4783);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4779);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4779);
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4779);
        return createBooleanArray;
    }

    public static ArrayList<Boolean> createBooleanList(Parcel parcel, int i2) {
        AppMethodBeat.i(4789);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4789);
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4789);
        return arrayList;
    }

    public static Bundle createBundle(Parcel parcel, int i2) {
        AppMethodBeat.i(4776);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4776);
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4776);
        return readBundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4777);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4777);
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4777);
        return createByteArray;
    }

    public static byte[][] createByteArrayArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4778);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4778);
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i3 = 0; i3 < readInt; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4778);
        return bArr;
    }

    public static SparseArray<byte[]> createByteArraySparseArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4800);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4800);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4800);
        return sparseArray;
    }

    public static char[] createCharArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4780);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4780);
            return null;
        }
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4780);
        return createCharArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4785);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4785);
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4785);
        return createDoubleArray;
    }

    public static ArrayList<Double> createDoubleList(Parcel parcel, int i2) {
        AppMethodBeat.i(4803);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4803);
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4803);
        return arrayList;
    }

    public static SparseArray<Double> createDoubleSparseArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4794);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4794);
            return null;
        }
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4794);
        return sparseArray;
    }

    public static float[] createFloatArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4784);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4784);
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4784);
        return createFloatArray;
    }

    public static ArrayList<Float> createFloatList(Parcel parcel, int i2) {
        AppMethodBeat.i(4802);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4802);
            return null;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4802);
        return arrayList;
    }

    public static SparseArray<Float> createFloatSparseArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4793);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4793);
            return null;
        }
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4793);
        return sparseArray;
    }

    public static IBinder[] createIBinderArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4788);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4788);
            return null;
        }
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4788);
        return createBinderArray;
    }

    public static ArrayList<IBinder> createIBinderList(Parcel parcel, int i2) {
        AppMethodBeat.i(4805);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4805);
            return null;
        }
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4805);
        return createBinderArrayList;
    }

    public static SparseArray<IBinder> createIBinderSparseArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4799);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4799);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4799);
        return sparseArray;
    }

    public static int[] createIntArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4781);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4781);
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4781);
        return createIntArray;
    }

    public static ArrayList<Integer> createIntegerList(Parcel parcel, int i2) {
        AppMethodBeat.i(4790);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4790);
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4790);
        return arrayList;
    }

    public static long[] createLongArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4782);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4782);
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4782);
        return createLongArray;
    }

    public static ArrayList<Long> createLongList(Parcel parcel, int i2) {
        AppMethodBeat.i(4801);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4801);
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4801);
        return arrayList;
    }

    public static Parcel createParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4808);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4808);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4808);
        return obtain;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4809);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4809);
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4809);
        return parcelArr;
    }

    public static ArrayList<Parcel> createParcelList(Parcel parcel, int i2) {
        AppMethodBeat.i(4810);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4810);
            return null;
        }
        int readInt = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                arrayList.add(null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4810);
        return arrayList;
    }

    public static SparseArray<Parcel> createParcelSparseArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4797);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4797);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray.append(readInt2, null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4797);
        return sparseArray;
    }

    public static <T extends Parcelable> T createParcelable(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4775);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4775);
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4775);
        return createFromParcel;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4791);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4791);
            return null;
        }
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4791);
        return readSparseBooleanArray;
    }

    public static SparseIntArray createSparseIntArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4792);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4792);
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4792);
        return sparseIntArray;
    }

    public static SparseLongArray createSparseLongArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4795);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4795);
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4795);
        return sparseLongArray;
    }

    public static String createString(Parcel parcel, int i2) {
        AppMethodBeat.i(4773);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4773);
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4773);
        return readString;
    }

    public static String[] createStringArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4787);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4787);
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4787);
        return createStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i2) {
        AppMethodBeat.i(4804);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4804);
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4804);
        return createStringArrayList;
    }

    public static SparseArray<String> createStringSparseArray(Parcel parcel, int i2) {
        AppMethodBeat.i(4796);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4796);
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4796);
        return sparseArray;
    }

    public static <T> T[] createTypedArray(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4806);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4806);
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4806);
        return tArr;
    }

    public static <T> ArrayList<T> createTypedList(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4807);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4807);
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4807);
        return createTypedArrayList;
    }

    public static <T> SparseArray<T> createTypedSparseArray(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4798);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4798);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<T> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(4798);
        return sparseArray;
    }

    public static void ensureAtEnd(Parcel parcel, int i2) {
        AppMethodBeat.i(4812);
        if (parcel.dataPosition() != i2) {
            ParseException parseException = new ParseException(new StringBuilder(37).append("Overread allowed size end=").append(i2).toString(), parcel);
            AppMethodBeat.o(4812);
            throw parseException;
        }
        AppMethodBeat.o(4812);
    }

    public static int getFieldId(int i2) {
        return 65535 & i2;
    }

    public static boolean readBoolean(Parcel parcel, int i2) {
        AppMethodBeat.i(4758);
        zza(parcel, i2, 4);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(4758);
            return true;
        }
        AppMethodBeat.o(4758);
        return false;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i2) {
        AppMethodBeat.i(4759);
        int readSize = readSize(parcel, i2);
        if (readSize == 0) {
            AppMethodBeat.o(4759);
            return null;
        }
        zza(parcel, i2, readSize, 4);
        Boolean valueOf = Boolean.valueOf(parcel.readInt() != 0);
        AppMethodBeat.o(4759);
        return valueOf;
    }

    public static byte readByte(Parcel parcel, int i2) {
        AppMethodBeat.i(4760);
        zza(parcel, i2, 4);
        byte readInt = (byte) parcel.readInt();
        AppMethodBeat.o(4760);
        return readInt;
    }

    public static char readChar(Parcel parcel, int i2) {
        AppMethodBeat.i(4761);
        zza(parcel, i2, 4);
        char readInt = (char) parcel.readInt();
        AppMethodBeat.o(4761);
        return readInt;
    }

    public static double readDouble(Parcel parcel, int i2) {
        AppMethodBeat.i(4770);
        zza(parcel, i2, 8);
        double readDouble = parcel.readDouble();
        AppMethodBeat.o(4770);
        return readDouble;
    }

    public static Double readDoubleObject(Parcel parcel, int i2) {
        AppMethodBeat.i(4771);
        int readSize = readSize(parcel, i2);
        if (readSize == 0) {
            AppMethodBeat.o(4771);
            return null;
        }
        zza(parcel, i2, readSize, 8);
        Double valueOf = Double.valueOf(parcel.readDouble());
        AppMethodBeat.o(4771);
        return valueOf;
    }

    public static float readFloat(Parcel parcel, int i2) {
        AppMethodBeat.i(4768);
        zza(parcel, i2, 4);
        float readFloat = parcel.readFloat();
        AppMethodBeat.o(4768);
        return readFloat;
    }

    public static Float readFloatObject(Parcel parcel, int i2) {
        AppMethodBeat.i(4769);
        int readSize = readSize(parcel, i2);
        if (readSize == 0) {
            AppMethodBeat.o(4769);
            return null;
        }
        zza(parcel, i2, readSize, 4);
        Float valueOf = Float.valueOf(parcel.readFloat());
        AppMethodBeat.o(4769);
        return valueOf;
    }

    public static int readHeader(Parcel parcel) {
        AppMethodBeat.i(4752);
        int readInt = parcel.readInt();
        AppMethodBeat.o(4752);
        return readInt;
    }

    public static IBinder readIBinder(Parcel parcel, int i2) {
        AppMethodBeat.i(4774);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4774);
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4774);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int i2) {
        AppMethodBeat.i(4763);
        zza(parcel, i2, 4);
        int readInt = parcel.readInt();
        AppMethodBeat.o(4763);
        return readInt;
    }

    public static Integer readIntegerObject(Parcel parcel, int i2) {
        AppMethodBeat.i(4764);
        int readSize = readSize(parcel, i2);
        if (readSize == 0) {
            AppMethodBeat.o(4764);
            return null;
        }
        zza(parcel, i2, readSize, 4);
        Integer valueOf = Integer.valueOf(parcel.readInt());
        AppMethodBeat.o(4764);
        return valueOf;
    }

    public static void readList(Parcel parcel, int i2, List list, ClassLoader classLoader) {
        AppMethodBeat.i(4811);
        int readSize = readSize(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(4811);
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(4811);
    }

    public static long readLong(Parcel parcel, int i2) {
        AppMethodBeat.i(4765);
        zza(parcel, i2, 8);
        long readLong = parcel.readLong();
        AppMethodBeat.o(4765);
        return readLong;
    }

    public static Long readLongObject(Parcel parcel, int i2) {
        AppMethodBeat.i(4766);
        int readSize = readSize(parcel, i2);
        if (readSize == 0) {
            AppMethodBeat.o(4766);
            return null;
        }
        zza(parcel, i2, readSize, 8);
        Long valueOf = Long.valueOf(parcel.readLong());
        AppMethodBeat.o(4766);
        return valueOf;
    }

    public static short readShort(Parcel parcel, int i2) {
        AppMethodBeat.i(4762);
        zza(parcel, i2, 4);
        short readInt = (short) parcel.readInt();
        AppMethodBeat.o(4762);
        return readInt;
    }

    public static int readSize(Parcel parcel, int i2) {
        AppMethodBeat.i(4753);
        if ((i2 & -65536) != -65536) {
            int i3 = (i2 >> 16) & 65535;
            AppMethodBeat.o(4753);
            return i3;
        }
        int readInt = parcel.readInt();
        AppMethodBeat.o(4753);
        return readInt;
    }

    public static void skipUnknownField(Parcel parcel, int i2) {
        AppMethodBeat.i(4754);
        parcel.setDataPosition(readSize(parcel, i2) + parcel.dataPosition());
        AppMethodBeat.o(4754);
    }

    public static int validateObjectHeader(Parcel parcel) {
        AppMethodBeat.i(4757);
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readHeader));
            ParseException parseException = new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
            AppMethodBeat.o(4757);
            throw parseException;
        }
        int i2 = dataPosition + readSize;
        if (i2 < dataPosition || i2 > parcel.dataSize()) {
            ParseException parseException2 = new ParseException(new StringBuilder(54).append("Size read is invalid start=").append(dataPosition).append(" end=").append(i2).toString(), parcel);
            AppMethodBeat.o(4757);
            throw parseException2;
        }
        AppMethodBeat.o(4757);
        return i2;
    }

    private static void zza(Parcel parcel, int i2, int i3) {
        AppMethodBeat.i(4755);
        int readSize = readSize(parcel, i2);
        if (readSize != i3) {
            String hexString = Integer.toHexString(readSize);
            ParseException parseException = new ParseException(new StringBuilder(String.valueOf(hexString).length() + 46).append("Expected size ").append(i3).append(" got ").append(readSize).append(" (0x").append(hexString).append(")").toString(), parcel);
            AppMethodBeat.o(4755);
            throw parseException;
        }
        AppMethodBeat.o(4755);
    }

    private static void zza(Parcel parcel, int i2, int i3, int i4) {
        AppMethodBeat.i(4756);
        if (i3 != i4) {
            String hexString = Integer.toHexString(i3);
            ParseException parseException = new ParseException(new StringBuilder(String.valueOf(hexString).length() + 46).append("Expected size ").append(i4).append(" got ").append(i3).append(" (0x").append(hexString).append(")").toString(), parcel);
            AppMethodBeat.o(4756);
            throw parseException;
        }
        AppMethodBeat.o(4756);
    }
}
