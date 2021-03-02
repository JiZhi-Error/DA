package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b extends h {
    private int r = -1;
    private int s = -1;
    private float[] t = new float[4];
    private String u = "Beauty3Filter";

    public b() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.i(15012);
        AppMethodBeat.o(15012);
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        AppMethodBeat.i(15013);
        NativeLoad.getInstance();
        this.f300a = NativeLoad.nativeLoadGLProgram(14);
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z = this.f306g;
        AppMethodBeat.o(15013);
        return z;
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15014);
        boolean b2 = super.b();
        this.r = GLES20.glGetUniformLocation(p(), "singleStepOffset");
        this.s = GLES20.glGetUniformLocation(p(), "beautyParams");
        a(5.0f);
        AppMethodBeat.o(15014);
        return b2;
    }

    public void c(int i2, int i3) {
        AppMethodBeat.i(15015);
        a(this.r, new float[]{2.0f / ((float) i2), 2.0f / ((float) i3)});
        AppMethodBeat.o(15015);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15016);
        super.a(i2, i3);
        c(i2, i3);
        AppMethodBeat.o(15016);
    }

    public void a(float f2) {
        AppMethodBeat.i(15017);
        this.t[0] = f2;
        b(this.t);
        AppMethodBeat.o(15017);
    }

    public void b(float f2) {
        AppMethodBeat.i(15018);
        this.t[1] = f2;
        b(this.t);
        AppMethodBeat.o(15018);
    }

    public void c(float f2) {
        AppMethodBeat.i(15019);
        this.t[2] = f2;
        b(this.t);
        AppMethodBeat.o(15019);
    }

    private void b(float[] fArr) {
        AppMethodBeat.i(15020);
        c(this.s, fArr);
        AppMethodBeat.o(15020);
    }
}
