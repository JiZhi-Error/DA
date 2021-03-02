package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;

public final class d {
    public SparseArray<a> NDr;
    public byte[] mData;

    private d(SparseArray<a> sparseArray, byte[] bArr) {
        this.NDr = sparseArray;
        this.mData = bArr;
    }

    public static d a(SparseArray<a> sparseArray, InputStream inputStream, int i2) {
        AppMethodBeat.i(141240);
        try {
            byte[] bArr = new byte[i2];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                Log.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            d dVar = new d(sparseArray, bArr);
            AppMethodBeat.o(141240);
            return dVar;
        } catch (IOException e2) {
            Log.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(141240);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public final int NDs;
        public final int[] NDt;
        public final int[] NDu;

        public a(int i2, int[] iArr, int[] iArr2) {
            this.NDs = i2;
            this.NDt = iArr;
            this.NDu = iArr2;
        }
    }

    public final String getQuantityString(int i2, int i3, Object... objArr) {
        Exception e2;
        String str;
        int i4;
        AppMethodBeat.i(141241);
        try {
            int indexOfKey = this.NDr.indexOfKey(i2);
            if (indexOfKey < 0) {
                AppMethodBeat.o(141241);
                return null;
            }
            a valueAt = this.NDr.valueAt(indexOfKey);
            int length = valueAt.NDt.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                if (valueAt.NDt[i5] == i3) {
                    i4 = i5;
                } else {
                    i4 = i6;
                }
                i5++;
                i6 = i4;
            }
            if (indexOfKey <= this.NDr.size() - 1) {
                if (i6 >= length - 1) {
                    str = new String(this.mData, valueAt.NDu[i6], this.NDr.valueAt(indexOfKey + 1).NDu[0] - valueAt.NDu[i6]);
                } else {
                    str = new String(this.mData, valueAt.NDu[i6], valueAt.NDu[i6 + 1] - valueAt.NDu[i6]);
                }
            } else if (i6 >= length - 1) {
                str = new String(this.mData, valueAt.NDu[i6], this.mData.length - valueAt.NDu[i6]);
            } else {
                str = new String(this.mData, valueAt.NDu[i6], valueAt.NDu[i6 + 1] - valueAt.NDu[i6]);
            }
            try {
                if (Util.isNullOrNil(str) || objArr != null) {
                    str = String.format(str, objArr);
                }
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", Util.stackTraceToString(e2));
                AppMethodBeat.o(141241);
                return str;
            }
            AppMethodBeat.o(141241);
            return str;
        } catch (Exception e4) {
            e2 = e4;
            str = null;
            Log.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(141241);
            return str;
        }
    }
}
