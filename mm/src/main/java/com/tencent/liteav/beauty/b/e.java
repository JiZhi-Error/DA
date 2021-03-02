package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends s {
    private int A;
    private float[] B;
    private int x;
    private int y;
    private int z;

    @Override // com.tencent.liteav.basic.c.h
    public void c() {
        AppMethodBeat.i(15039);
        super.c();
        this.x = GLES20.glGetUniformLocation(p(), "screenMode");
        this.y = GLES20.glGetUniformLocation(p(), "screenReplaceColor");
        this.z = GLES20.glGetUniformLocation(p(), "screenMirrorX");
        this.A = GLES20.glGetUniformLocation(p(), "screenMirrorY");
        b(this.B);
        AppMethodBeat.o(15039);
    }

    public void b(float[] fArr) {
        AppMethodBeat.i(15040);
        float[] fArr2 = new float[3];
        fArr2[0] = (float) ((0.2989d * ((double) fArr[0])) + (0.5866d * ((double) fArr[1])) + (0.1145d * ((double) fArr[2])));
        fArr2[1] = (float) (0.7132d * ((double) (fArr[0] - fArr2[0])));
        fArr2[2] = (float) (0.5647d * ((double) (fArr[2] - fArr2[0])));
        b(this.y, fArr2);
        AppMethodBeat.o(15040);
    }
}
