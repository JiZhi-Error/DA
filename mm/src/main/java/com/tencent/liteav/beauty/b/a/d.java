package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d extends h {
    private int r = -1;
    private int s = -1;
    private float t = 4.0f;
    private String u = "SmoothHorizontal";

    d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        AppMethodBeat.i(14997);
        NativeLoad.getInstance();
        this.f300a = NativeLoad.nativeLoadGLProgram(13);
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z = this.f306g;
        AppMethodBeat.o(14997);
        return z;
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(14998);
        super.b();
        q();
        AppMethodBeat.o(14998);
        return true;
    }

    public void q() {
        AppMethodBeat.i(14999);
        this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
        AppMethodBeat.o(14999);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15000);
        super.a(i2, i3);
        if (i2 > i3) {
            if (i3 < 540) {
                this.t = 2.0f;
            } else {
                this.t = 4.0f;
            }
        } else if (i2 < 540) {
            this.t = 2.0f;
        } else {
            this.t = 4.0f;
        }
        TXCLog.i(this.u, "m_textureRation " + this.t);
        a(this.r, this.t / ((float) i2));
        a(this.s, this.t / ((float) i3));
        AppMethodBeat.o(15000);
    }
}
