package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Arrays;

public final class g implements a {
    private int height;
    private String rpE;
    private int width;
    private long yeH = 0;
    private long yeI;

    public g(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(104655);
        this.rpE = str;
        this.width = i2;
        this.height = i3;
        this.yeI = j2;
        Log.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str);
        AppMethodBeat.o(104655);
    }

    @Override // com.tencent.mm.plugin.gif.a
    public final boolean init() {
        AppMethodBeat.i(104656);
        this.yeH = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.yeI);
        if (this.yeH == 0) {
            h.INSTANCE.dN(852, 11);
            Log.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", Long.valueOf(this.yeH));
            AppMethodBeat.o(104656);
            return false;
        }
        Log.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", Long.valueOf(this.yeH));
        AppMethodBeat.o(104656);
        return true;
    }

    @Override // com.tencent.mm.plugin.gif.a
    public final boolean d(byte[] bArr, long j2) {
        AppMethodBeat.i(104657);
        if (this.yeH == 0 || Util.isNullOrNil(bArr) || bArr.length != this.width * this.height * 4) {
            Log.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
            AppMethodBeat.o(104657);
            return false;
        }
        long j3 = this.yeI;
        if (j2 >= 0) {
            j3 = j2;
        }
        int nativeAddGifEncodeRgbaFrame = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.yeH, this.width, this.height, bArr, j3);
        if (nativeAddGifEncodeRgbaFrame < 0) {
            Log.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", Integer.valueOf(nativeAddGifEncodeRgbaFrame));
            AppMethodBeat.o(104657);
            return false;
        }
        AppMethodBeat.o(104657);
        return true;
    }

    @Override // com.tencent.mm.plugin.gif.a
    public final boolean dXw() {
        AppMethodBeat.i(104658);
        if (this.yeH != 0) {
            byte[] nativeFinishGifEncode = MMWXGFJNI.nativeFinishGifEncode(this.yeH);
            if (nativeFinishGifEncode == null || nativeFinishGifEncode.length <= 0) {
                Log.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", Arrays.toString(nativeFinishGifEncode));
                AppMethodBeat.o(104658);
                return false;
            }
            Log.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", Integer.valueOf(nativeFinishGifEncode.length));
            if (!Util.isNullOrNil(this.rpE)) {
                s.f(this.rpE, nativeFinishGifEncode, nativeFinishGifEncode.length);
                AppMethodBeat.o(104658);
                return true;
            }
        }
        AppMethodBeat.o(104658);
        return false;
    }
}
