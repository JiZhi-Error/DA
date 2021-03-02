package com.tencent.mm.videocomposition.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

final class c {
    private final int[] pNames = {TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED, TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED, 34877, 32969, 32968, 32971, 32970};
    private final int[] params = new int[7];

    c() {
        AppMethodBeat.i(216711);
        AppMethodBeat.o(216711);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void cache() {
        AppMethodBeat.i(216712);
        for (int i2 = 0; i2 < this.pNames.length; i2++) {
            GLES20.glGetIntegerv(this.pNames[i2], this.params, i2);
        }
        AppMethodBeat.o(216712);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void restore() {
        AppMethodBeat.i(216713);
        Logger.v("GLBlendStateCache", "restore: params = " + Arrays.toString(this.params));
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(this.params[0]);
        GLES20.glBlendEquationSeparate(this.params[1], this.params[2]);
        GLES20.glBlendFuncSeparate(this.params[3], this.params[4], this.params[5], this.params[6]);
        AppMethodBeat.o(216713);
    }
}
