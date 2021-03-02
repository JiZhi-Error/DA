package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.os.Build;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends t {
    private String A = "SmoothVertical";
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int x = -1;
    private float y = 2.0f;
    private float z = 0.5f;

    e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        AppMethodBeat.i(14992);
        if (!Build.BRAND.equals("samsung") || !Build.MODEL.equals("GT-I9500") || !Build.VERSION.RELEASE.equals("4.3")) {
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(5);
        } else {
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(15);
        }
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z2 = this.f306g;
        AppMethodBeat.o(14992);
        return z2;
    }

    @Override // com.tencent.liteav.beauty.b.t, com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(14993);
        super.b();
        q();
        AppMethodBeat.o(14993);
        return true;
    }

    public void a(float f2) {
        AppMethodBeat.i(14994);
        this.z = f2;
        TXCLog.i(this.A, "setBeautyLevel ".concat(String.valueOf(f2)));
        a(this.t, f2);
        AppMethodBeat.o(14994);
    }

    public void q() {
        AppMethodBeat.i(14995);
        this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
        this.t = GLES20.glGetUniformLocation(p(), "smoothDegree");
        AppMethodBeat.o(14995);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(14996);
        super.a(i2, i3);
        if (i2 > i3) {
            if (i3 < 540) {
                this.y = 2.0f;
            } else {
                this.y = 4.0f;
            }
        } else if (i2 < 540) {
            this.y = 2.0f;
        } else {
            this.y = 4.0f;
        }
        TXCLog.i(this.A, "m_textureRation " + this.y);
        a(this.r, this.y / ((float) i2));
        a(this.s, this.y / ((float) i3));
        AppMethodBeat.o(14996);
    }
}
