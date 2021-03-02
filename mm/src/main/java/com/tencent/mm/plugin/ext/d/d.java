package com.tencent.mm.plugin.ext.d;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class d {
    private static SparseArray<byte[]> sOa = new SparseArray<>(1);

    /* access modifiers changed from: package-private */
    public interface c {
        b bb(String str, boolean z);
    }

    static {
        AppMethodBeat.i(24494);
        AppMethodBeat.o(24494);
    }

    public static class b {
        int dYT;
        public String md5;
        int previewHeight;
        int previewWidth;
        Rect sOb;
        byte[] yuvData;

        public b(byte[] bArr, int i2, int i3, int i4, Rect rect, String str) {
            this.yuvData = bArr;
            this.previewWidth = i2;
            this.previewHeight = i3;
            this.dYT = i4;
            this.sOb = rect;
            this.md5 = str;
        }

        public final String toString() {
            AppMethodBeat.i(24491);
            String str = "RetrieveResult{yuvDataLength=" + (this.yuvData != null ? Integer.valueOf(this.yuvData.length) : BuildConfig.COMMAND) + ", previewWidth=" + this.previewWidth + ", previewHeight=" + this.previewHeight + ", rotate=" + this.dYT + ", scanRect=" + this.sOb + ", md5=" + this.md5 + '}';
            AppMethodBeat.o(24491);
            return str;
        }
    }

    public static class a implements c {
        @Override // com.tencent.mm.plugin.ext.d.d.c
        public final b bb(String str, boolean z) {
            AppMethodBeat.i(24490);
            if (!s.YS(str)) {
                Log.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
                AppMethodBeat.o(24490);
                return null;
            }
            b c2 = d.c(s.aW(str, 0, -1), z);
            AppMethodBeat.o(24490);
            return c2;
        }
    }

    static c cSD() {
        AppMethodBeat.i(24492);
        a aVar = new a();
        AppMethodBeat.o(24492);
        return aVar;
    }

    private static int bA(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16) | ((bArr[0] & 255) << 24);
    }

    static /* synthetic */ b c(byte[] bArr, boolean z) {
        byte[] bArr2;
        String str = null;
        AppMethodBeat.i(24493);
        if (bArr == null || bArr.length <= 14) {
            Log.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: invalid yuv handle file!!");
            AppMethodBeat.o(24493);
            return null;
        }
        if (z) {
            str = g.getMessageDigest(bArr);
        }
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, 0, bArr3, 0, 4);
        byte[] bArr4 = new byte[4];
        System.arraycopy(bArr, 4, bArr4, 0, 4);
        byte[] bArr5 = new byte[4];
        System.arraycopy(bArr, 8, bArr5, 0, 4);
        byte[] bArr6 = new byte[4];
        System.arraycopy(bArr, 12, bArr6, 0, 4);
        byte[] bArr7 = new byte[4];
        System.arraycopy(bArr, 16, bArr7, 0, 4);
        byte[] bArr8 = new byte[4];
        System.arraycopy(bArr, 20, bArr8, 0, 4);
        byte[] bArr9 = new byte[4];
        System.arraycopy(bArr, 24, bArr9, 0, 4);
        int length = bArr.length - 28;
        byte[] bArr10 = sOa.get(length);
        if (bArr10 == null) {
            bArr2 = new byte[length];
            sOa.put(length, bArr2);
        } else {
            bArr2 = bArr10;
        }
        System.arraycopy(bArr, 28, bArr2, 0, length);
        int bA = bA(bArr3);
        int bA2 = bA(bArr4);
        int bA3 = bA(bArr5);
        int bA4 = bA(bArr6);
        b bVar = new b(bArr2, bA, bA2, bA(bArr9), new Rect(bA3, bA4, bA(bArr7) + bA3, bA(bArr8) + bA4), str);
        Log.i("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: retrieved result: %s", bVar);
        AppMethodBeat.o(24493);
        return bVar;
    }
}
