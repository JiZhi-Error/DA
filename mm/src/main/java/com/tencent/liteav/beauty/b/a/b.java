package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b extends t {
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private final String x = "BeautyBlend";

    public b() {
        super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        AppMethodBeat.i(14976);
        NativeLoad.getInstance();
        this.f300a = NativeLoad.nativeLoadGLProgram(12);
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z = this.f306g;
        AppMethodBeat.o(14976);
        return z;
    }

    @Override // com.tencent.liteav.beauty.b.t, com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(14977);
        super.b();
        q();
        AppMethodBeat.o(14977);
        return true;
    }

    public void a(float f2) {
        AppMethodBeat.i(14978);
        TXCLog.i("BeautyBlend", "setBrightLevel ".concat(String.valueOf(f2)));
        a(this.s, f2);
        AppMethodBeat.o(14978);
    }

    public void b(float f2) {
        AppMethodBeat.i(14979);
        a(this.t, f2 / 2.0f);
        AppMethodBeat.o(14979);
    }

    private void q() {
        AppMethodBeat.i(14980);
        this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
        this.r = GLES20.glGetUniformLocation(p(), "contrast");
        this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
        AppMethodBeat.o(14980);
    }
}
