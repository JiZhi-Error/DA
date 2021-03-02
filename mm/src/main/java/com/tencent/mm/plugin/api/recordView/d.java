package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* access modifiers changed from: package-private */
public final class d {
    static float[] ilm = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static final float[] iln = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static final Object lock = new Object();
    int dYT;
    FloatBuffer hDT;
    FloatBuffer hDU;
    int hEy;
    int hEz;
    volatile boolean ife;
    int ikE;
    ByteBuffer ikI;
    int ikO;
    ByteBuffer ikP;
    boolean kxV;
    int kxW;
    int kxX;
    int kxY;
    int kxZ;
    int kya;
    float[] kyb;
    float[] kyd;
    volatile boolean kyn;
    int programId;
    private int surfaceHeight;
    private int surfaceWidth;

    static {
        AppMethodBeat.i(89218);
        AppMethodBeat.o(89218);
    }

    public d() {
        AppMethodBeat.i(89216);
        this.surfaceWidth = 0;
        this.surfaceHeight = 0;
        this.kxV = false;
        this.kxW = 0;
        this.kxX = 0;
        this.dYT = 0;
        this.kxY = -1;
        this.kxZ = -1;
        this.programId = -1;
        this.kyb = new float[16];
        this.kyd = ilm;
        this.ife = false;
        this.kyn = false;
        this.ife = false;
        AppMethodBeat.o(89216);
    }

    public final void dL(int i2, int i3) {
        AppMethodBeat.i(89217);
        Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i2), Integer.valueOf(i3), this);
        if (!(i2 == this.surfaceWidth && i3 == this.surfaceHeight)) {
            Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i2, i3);
            this.surfaceWidth = i2;
            this.surfaceHeight = i3;
        }
        AppMethodBeat.o(89217);
    }
}
