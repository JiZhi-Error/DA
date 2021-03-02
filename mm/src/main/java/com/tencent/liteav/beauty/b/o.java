package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o extends h {
    private static float[] C = {0.1826f, 0.6142f, 0.062f, -0.1006f, -0.3386f, 0.4392f, 0.4392f, -0.3989f, -0.0403f};
    private static float[] D = {0.256816f, 0.504154f, 0.0979137f, -0.148246f, -0.29102f, 0.439266f, 0.439271f, -0.367833f, -0.071438f};
    private static float[] E = {0.0625f, 0.5f, 0.5f};
    private String A = "RGBA2I420Filter";
    private int B = 1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    public o(int i2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.B = i2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        AppMethodBeat.i(15059);
        if (1 == this.B) {
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(8);
            TXCLog.i(this.A, "RGB-->I420 init!");
        } else if (3 == this.B) {
            TXCLog.i(this.A, "RGB-->NV21 init!");
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(11);
        } else if (2 == this.B) {
            TXCLog.i(this.A, "RGBA Format init!");
            boolean a2 = super.a();
            AppMethodBeat.o(15059);
            return a2;
        } else {
            TXCLog.i(this.A, "don't support format " + this.B + " use default I420");
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(8);
        }
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z2 = this.f306g;
        AppMethodBeat.o(15059);
        return z2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15060);
        super.b();
        this.r = GLES20.glGetUniformLocation(this.f300a, "width");
        this.s = GLES20.glGetUniformLocation(this.f300a, "height");
        AppMethodBeat.o(15060);
        return true;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15061);
        if (i2 <= 0 || i3 <= 0) {
            TXCLog.e(this.A, "width or height is error!");
            AppMethodBeat.o(15061);
        } else if (this.f305f == i3 && this.f304e == i2) {
            AppMethodBeat.o(15061);
        } else {
            super.a(i2, i3);
            TXCLog.i(this.A, "RGBA2I420Filter width " + i2 + " height " + i3);
            a(this.r, (float) i2);
            a(this.s, (float) i3);
            AppMethodBeat.o(15061);
        }
    }

    @Override // com.tencent.liteav.basic.c.h
    public void c() {
        AppMethodBeat.i(15062);
        super.c();
        AppMethodBeat.o(15062);
    }
}
