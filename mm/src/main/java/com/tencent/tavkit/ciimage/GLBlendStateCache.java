package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public class GLBlendStateCache {
    private static final String TAG = "GLBlendStateCache";
    private final int[] pNames = {TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED, TraeAudioManager.TraeAudioManagerLooper.MESSAGE_ISDEVICECHANGABLED, 34877, 32969, 32968, 32971, 32970};
    private final int[] params = new int[7];

    GLBlendStateCache() {
        AppMethodBeat.i(197322);
        AppMethodBeat.o(197322);
    }

    /* access modifiers changed from: package-private */
    public synchronized void cache() {
        AppMethodBeat.i(197323);
        for (int i2 = 0; i2 < this.pNames.length; i2++) {
            GLES20.glGetIntegerv(this.pNames[i2], this.params, i2);
        }
        AppMethodBeat.o(197323);
    }

    /* access modifiers changed from: package-private */
    public synchronized void restore() {
        AppMethodBeat.i(197324);
        Logger.v(TAG, "restore: params = " + Arrays.toString(this.params));
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(this.params[0]);
        GLES20.glBlendEquationSeparate(this.params[1], this.params[2]);
        GLES20.glBlendFuncSeparate(this.params[3], this.params[4], this.params[5], this.params[6]);
        AppMethodBeat.o(197324);
    }
}
