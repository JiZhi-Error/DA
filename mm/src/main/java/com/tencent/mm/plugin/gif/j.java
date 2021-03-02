package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Arrays;

public final class j implements a {
    private int height;
    private String rpE;
    private int width;
    private long yeH = 0;
    private long yeI;
    private int yeT = -1;

    public j(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(104683);
        this.rpE = str;
        this.width = i2;
        this.height = i3;
        this.yeI = j2;
        this.yeT = 20;
        Log.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), 20, str);
        AppMethodBeat.o(104683);
    }

    @Override // com.tencent.mm.plugin.gif.a
    public final boolean init() {
        AppMethodBeat.i(104684);
        this.yeH = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.yeI, this.yeT);
        if (this.yeH == 0) {
            h.INSTANCE.dN(852, 12);
            Log.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", Long.valueOf(this.yeH));
            AppMethodBeat.o(104684);
            return false;
        }
        Log.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", Long.valueOf(this.yeH));
        AppMethodBeat.o(104684);
        return true;
    }

    @Override // com.tencent.mm.plugin.gif.a
    public final boolean d(byte[] bArr, long j2) {
        AppMethodBeat.i(104685);
        if (this.yeH == 0 || Util.isNullOrNil(bArr) || bArr.length != this.width * this.height * 4) {
            Log.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
            AppMethodBeat.o(104685);
            return false;
        }
        long j3 = this.yeI;
        if (j2 >= 0) {
            j3 = j2;
        }
        int nativeAddWxAMEncodeRgbaFrame = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.yeH, this.width, this.height, bArr, j3);
        if (nativeAddWxAMEncodeRgbaFrame < 0) {
            Log.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", Integer.valueOf(nativeAddWxAMEncodeRgbaFrame));
            AppMethodBeat.o(104685);
            return false;
        }
        AppMethodBeat.o(104685);
        return true;
    }

    @Override // com.tencent.mm.plugin.gif.a
    public final boolean dXw() {
        AppMethodBeat.i(104686);
        if (this.yeH != 0) {
            byte[] nativeFinishWxAMEncode = MMWXGFJNI.nativeFinishWxAMEncode(this.yeH);
            if (nativeFinishWxAMEncode == null || nativeFinishWxAMEncode.length <= 0) {
                Log.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", Arrays.toString(nativeFinishWxAMEncode));
                AppMethodBeat.o(104686);
                return false;
            }
            Log.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", Integer.valueOf(nativeFinishWxAMEncode.length));
            if (!Util.isNullOrNil(this.rpE)) {
                s.f(this.rpE, nativeFinishWxAMEncode, nativeFinishWxAMEncode.length);
                AppMethodBeat.o(104686);
                return true;
            }
        }
        AppMethodBeat.o(104686);
        return false;
    }
}
