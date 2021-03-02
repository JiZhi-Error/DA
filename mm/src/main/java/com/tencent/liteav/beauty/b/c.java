package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends b {
    private static final String r = c.class.getSimpleName();
    private float A = 0.0f;
    private f s;
    private a t;
    private r u = null;
    private int v = -1;
    private int w = -1;
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    static /* synthetic */ float a(float f2) {
        AppMethodBeat.i(15037);
        float b2 = b(f2);
        AppMethodBeat.o(15037);
        return b2;
    }

    static {
        AppMethodBeat.i(15038);
        AppMethodBeat.o(15038);
    }

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        int i3;
        AppMethodBeat.i(15028);
        if (this.x > 0.0f || this.y > 0.0f || this.z > 0.0f) {
            if (this.x != 0.0f) {
                i3 = this.s.b(i2);
            } else {
                i3 = i2;
            }
            i2 = this.t.a(i3, i2, i2);
        }
        if (this.A > 0.0f) {
            i2 = this.u.b(i2);
        }
        AppMethodBeat.o(15028);
        return i2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15029);
        if (this.v == i2 && this.w == i3) {
            AppMethodBeat.o(15029);
            return;
        }
        new StringBuilder("onOutputSizeChanged mFrameWidth = ").append(i2).append("  mFrameHeight = ").append(i3);
        this.v = i2;
        this.w = i3;
        c(this.v, this.w);
        AppMethodBeat.o(15029);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public boolean c(int i2, int i3) {
        AppMethodBeat.i(15030);
        this.v = i2;
        this.w = i3;
        new StringBuilder("init mFrameWidth = ").append(i2).append("  mFrameHeight = ").append(i3);
        if (this.s == null) {
            this.s = new f();
            this.s.a(true);
            if (!this.s.a()) {
                AppMethodBeat.o(15030);
                return false;
            }
        }
        this.s.a(this.v, this.w);
        if (this.t == null) {
            this.t = new a();
            this.t.a(true);
            if (!this.t.a()) {
                AppMethodBeat.o(15030);
                return false;
            }
        }
        this.t.a(this.v, this.w);
        if (this.u == null) {
            this.u = new r();
            this.u.a(true);
            if (!this.u.a()) {
                AppMethodBeat.o(15030);
                return false;
            }
        }
        this.u.a(this.v, this.w);
        AppMethodBeat.o(15030);
        return true;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(15031);
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        if (this.s != null) {
            this.s.d();
            this.s = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
        AppMethodBeat.o(15031);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void c(int i2) {
        AppMethodBeat.i(15032);
        this.x = (float) i2;
        if (this.t != null) {
            this.t.a((float) i2);
        }
        AppMethodBeat.o(15032);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void d(int i2) {
        AppMethodBeat.i(15033);
        this.y = (float) i2;
        if (this.t != null) {
            this.t.b((float) i2);
        }
        AppMethodBeat.o(15033);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void e(int i2) {
        AppMethodBeat.i(15034);
        this.z = (float) i2;
        if (this.t != null) {
            this.t.c((float) i2);
        }
        AppMethodBeat.o(15034);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void f(int i2) {
        AppMethodBeat.i(15035);
        float f2 = ((float) i2) / 15.0f;
        if (((double) Math.abs(this.A - f2)) < 0.001d) {
            AppMethodBeat.o(15035);
            return;
        }
        this.A = f2;
        if (this.u != null) {
            this.u.a(this.A);
        }
        AppMethodBeat.o(15035);
    }

    public static class a extends s {
        private int x = -1;
        private int y = -1;
        private int z = -1;

        public a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }

        @Override // com.tencent.liteav.basic.c.h
        public boolean a() {
            AppMethodBeat.i(15066);
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(1);
            if (this.f300a == 0 || !b()) {
                this.f306g = false;
            } else {
                this.f306g = true;
            }
            c();
            boolean z2 = this.f306g;
            AppMethodBeat.o(15066);
            return z2;
        }

        @Override // com.tencent.liteav.basic.c.h, com.tencent.liteav.beauty.b.s
        public void a(int i2, int i3) {
            AppMethodBeat.i(15067);
            if (this.f305f == i3 && this.f304e == i2) {
                AppMethodBeat.o(15067);
                return;
            }
            super.a(i2, i3);
            this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
            this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
            this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
            AppMethodBeat.o(15067);
        }

        @Override // com.tencent.liteav.basic.c.h, com.tencent.liteav.beauty.b.s
        public boolean b() {
            AppMethodBeat.i(15068);
            boolean b2 = super.b();
            AppMethodBeat.o(15068);
            return b2;
        }

        public void a(float f2) {
            AppMethodBeat.i(15069);
            a(this.x, c.a(f2));
            AppMethodBeat.o(15069);
        }

        public void b(float f2) {
            AppMethodBeat.i(15070);
            a(this.y, f2 / 3.0f);
            AppMethodBeat.o(15070);
        }

        public void c(float f2) {
            AppMethodBeat.i(15071);
            a(this.z, (f2 / 10.0f) / 2.0f);
            AppMethodBeat.o(15071);
        }
    }

    private static float b(float f2) {
        AppMethodBeat.i(15036);
        if (f2 > 1.0f) {
            if (((double) f2) < 2.5d) {
                f2 = a((f2 - 1.0f) / 1.5f, 1.0f, 4.1f);
            } else if (f2 < 4.0f) {
                f2 = a((f2 - 2.5f) / 1.5f, 4.1f, 5.6f);
            } else if (((double) f2) < 5.5d) {
                f2 = a((f2 - 4.0f) / 1.5f, 5.6f, 6.8f);
            } else if (((double) f2) <= 7.0d) {
                f2 = a((f2 - 5.5f) / 1.5f, 6.8f, 7.0f);
            }
            float f3 = f2 / 10.0f;
            AppMethodBeat.o(15036);
            return f3;
        }
        AppMethodBeat.o(15036);
        return 0.1f;
    }

    private static float a(float f2, float f3, float f4) {
        return ((f4 - f3) * f2) + f3;
    }
}
