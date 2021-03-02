package com.tencent.mm.cc;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;

public final class g {
    public SparseArray<a> NDv;
    public byte[] mData;

    private g(SparseArray<a> sparseArray, byte[] bArr) {
        this.NDv = sparseArray;
        this.mData = bArr;
    }

    public static g b(SparseArray<a> sparseArray, InputStream inputStream, int i2) {
        AppMethodBeat.i(141248);
        try {
            byte[] bArr = new byte[i2];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                Log.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            g gVar = new g(sparseArray, bArr);
            AppMethodBeat.o(141248);
            return gVar;
        } catch (IOException e2) {
            Log.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(141248);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public final int[] NDw;
        public final int resId;

        public a(int i2, int[] iArr) {
            this.resId = i2;
            this.NDw = iArr;
        }
    }
}
