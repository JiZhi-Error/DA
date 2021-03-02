package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static boolean jiQ = false;
    long jiR = 0;
    private String jiS;
    long jiT = 0;
    long mNativePtr = 0;

    public a(long j2) {
        AppMethodBeat.i(155977);
        this.jiS = String.valueOf(j2);
        init();
        AppMethodBeat.o(155977);
    }

    public a(String str) {
        AppMethodBeat.i(155978);
        this.jiS = str;
        init();
        AppMethodBeat.o(155978);
    }

    /* access modifiers changed from: package-private */
    public final void init() {
        AppMethodBeat.i(155979);
        Log.i("MicroMsg.EncEngine", "init  key  enckey " + this.jiS + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.jiS);
        try {
            Log.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
            AppMethodBeat.o(155979);
        } catch (Exception e2) {
            Log.e("MicroMsg.EncEngine", "exception " + e2.getMessage());
            AppMethodBeat.o(155979);
        }
    }

    public final int B(byte[] bArr, int i2) {
        AppMethodBeat.i(155980);
        if (this.mNativePtr == 0) {
            Log.i("MicroMsg.EncEngine", "transFor " + Util.getStack().toString());
        }
        if (jiQ) {
            Log.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (jiQ && this.jiR < 64) {
            Log.d("MicroMsg.EncEngine", "dump before _offset " + this.jiR + "  length:" + i2 + " " + Util.dumpHex(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.jiR, (long) i2);
        if (jiQ && this.jiR < 64) {
            Log.d("MicroMsg.EncEngine", "dump after _offset " + this.jiR + "  length:" + i2 + " " + Util.dumpHex(bArr) + " hashcode " + hashCode());
        }
        this.jiR += (long) i2;
        AppMethodBeat.o(155980);
        return i2;
    }

    public final void free() {
        AppMethodBeat.i(155981);
        Log.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.o(155981);
    }
}
