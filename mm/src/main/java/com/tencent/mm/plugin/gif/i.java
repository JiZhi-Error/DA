package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i {
    public static Bitmap bF(byte[] bArr) {
        AppMethodBeat.i(104682);
        if (Util.isNullOrNil(bArr)) {
            AppMethodBeat.o(104682);
            return null;
        }
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        long nativeInitWxAMDecoder = MMWXGFJNI.nativeInitWxAMDecoder();
        if (nativeInitWxAMDecoder == 0) {
            Log.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
        }
        int nativeDecodeBufferHeader = MMWXGFJNI.nativeDecodeBufferHeader(nativeInitWxAMDecoder, bArr, bArr.length);
        if (nativeDecodeBufferHeader != 0) {
            Log.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", Integer.valueOf(nativeDecodeBufferHeader));
        }
        int nativeGetOption = MMWXGFJNI.nativeGetOption(nativeInitWxAMDecoder, bArr, bArr.length, iArr);
        if (nativeGetOption != 0) {
            Log.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", Integer.valueOf(nativeGetOption));
        }
        int i2 = iArr[1];
        int i3 = iArr[2];
        if (i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(104682);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        MMWXGFJNI.nativeDecodeBufferFrame(nativeInitWxAMDecoder, null, 0, createBitmap, iArr2);
        MMWXGFJNI.nativeUninit(nativeInitWxAMDecoder);
        AppMethodBeat.o(104682);
        return createBitmap;
    }
}
