package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g {
    public FaceProNative sQQ = null;

    public final FaceProNative.FaceResult cTb() {
        AppMethodBeat.i(103739);
        if (this.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: release out not init");
            AppMethodBeat.o(103739);
            return null;
        }
        try {
            long currentTicks = Util.currentTicks();
            FaceProNative.FaceResult engineReleaseOut = this.sQQ.engineReleaseOut();
            Log.i("MicroMsg.FaceDetectNativeManager", "hy: uninitialize result : %d, using: %d ms", Integer.valueOf(engineReleaseOut.result), Long.valueOf(Util.currentTicks() - currentTicks));
            this.sQQ = null;
            AppMethodBeat.o(103739);
            return engineReleaseOut;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.FaceDetectNativeManager", th, "hy: face lib release crash!!!", new Object[0]);
            this.sQQ.engineRelease();
            this.sQQ = null;
            AppMethodBeat.o(103739);
            return null;
        }
    }

    public final int cTc() {
        AppMethodBeat.i(103740);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.sQQ == null);
        Log.v("MicroMsg.FaceDetectNativeManager", "alvinluo cutDown sFaceProNative == null: %b", objArr);
        if (this.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: reelase not init");
            AppMethodBeat.o(103740);
            return -101;
        }
        int engineRelease = this.sQQ.engineRelease();
        Log.i("MicroMsg.FaceDetectNativeManager", "hy: cut down result: %d", Integer.valueOf(engineRelease));
        this.sQQ = null;
        AppMethodBeat.o(103740);
        return engineRelease;
    }
}
