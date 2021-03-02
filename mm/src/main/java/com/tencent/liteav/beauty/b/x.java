package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class x extends h {
    private static final float[] A = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    protected static final short[] v = {1, 2, 0, 2, 0, 3};
    private static final float[] z = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private String B;
    protected a[] r;
    protected List<d.f> s;
    protected boolean t;
    protected int u;
    protected ShortBuffer w;
    private a x;
    private int y;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public FloatBuffer f547a = null;

        /* renamed from: b  reason: collision with root package name */
        public FloatBuffer f548b = null;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f549c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f550d = null;

        public a() {
        }
    }

    public x(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(14969);
        this.r = null;
        this.x = null;
        this.s = null;
        this.t = false;
        this.u = 1;
        this.y = 1;
        this.w = null;
        this.B = "GPUWatermark";
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(v.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.w = allocateDirect.asShortBuffer();
        this.w.put(v);
        this.w.position(0);
        this.o = true;
        AppMethodBeat.o(14969);
    }

    public x() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.basic.c.h
    public void d() {
        AppMethodBeat.i(14970);
        super.d();
        this.t = false;
        q();
        AppMethodBeat.o(14970);
    }

    public void c(boolean z2) {
        this.t = z2;
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4, int i2) {
        AppMethodBeat.i(14971);
        if (bitmap == null) {
            if (!(this.r == null || this.r[i2] == null)) {
                new StringBuilder("release ").append(i2).append(" water mark!");
                if (this.r[i2].f550d != null) {
                    GLES20.glDeleteTextures(1, this.r[i2].f550d, 0);
                }
                this.r[i2].f550d = null;
                this.r[i2].f549c = null;
                this.r[i2] = null;
            }
            AppMethodBeat.o(14971);
        } else if (this.r[i2] == null || i2 >= this.r.length) {
            AppMethodBeat.o(14971);
        } else {
            a(bitmap.getWidth(), bitmap.getHeight(), f2, f3, f4, i2);
            if (this.r[i2].f550d == null) {
                this.r[i2].f550d = new int[1];
                GLES20.glGenTextures(1, this.r[i2].f550d, 0);
                GLES20.glBindTexture(3553, this.r[i2].f550d[0]);
                GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            if (this.r[i2].f549c == null || !this.r[i2].f549c.equals(bitmap)) {
                GLES20.glBindTexture(3553, this.r[i2].f550d[0]);
                if (!bitmap.isRecycled()) {
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                } else {
                    TXCLog.e(this.B, "SetWaterMark when bitmap is recycled");
                }
            }
            this.r[i2].f549c = bitmap;
            AppMethodBeat.o(14971);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, float f2, float f3, float f4, int i4) {
        AppMethodBeat.i(14972);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(z.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.r[i4].f547a = allocateDirect.asFloatBuffer();
        float[] fArr = new float[z.length];
        float f5 = (((((float) i3) / ((float) i2)) * f4) * ((float) this.f304e)) / ((float) this.f305f);
        fArr[0] = (2.0f * f2) - 1.0f;
        fArr[1] = 1.0f - (2.0f * f3);
        fArr[2] = fArr[0];
        fArr[3] = fArr[1] - (f5 * 2.0f);
        fArr[4] = fArr[0] + (2.0f * f4);
        fArr[5] = fArr[3];
        fArr[6] = fArr[4];
        fArr[7] = fArr[1];
        for (int i5 = 1; i5 <= 7; i5 += 2) {
            fArr[i5] = fArr[i5] * -1.0f;
        }
        this.r[i4].f547a.put(fArr);
        this.r[i4].f547a.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(A.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.r[i4].f548b = allocateDirect2.asFloatBuffer();
        this.r[i4].f548b.put(A);
        this.r[i4].f548b.position(0);
        AppMethodBeat.o(14972);
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4) {
        AppMethodBeat.i(14973);
        if (this.r == null) {
            this.r = new a[1];
        }
        if (this.r[0] == null) {
            this.r[0] = new a();
        }
        a(bitmap, f2, f3, f4, 0);
        this.x = this.r[0];
        AppMethodBeat.o(14973);
    }

    private void q() {
        AppMethodBeat.i(14974);
        if (this.r != null) {
            for (int i2 = 0; i2 < this.r.length; i2++) {
                if (this.r[i2] != null) {
                    if (this.r[i2].f550d != null) {
                        GLES20.glDeleteTextures(1, this.r[i2].f550d, 0);
                    }
                    this.r[i2].f550d = null;
                    this.r[i2].f549c = null;
                    this.r[i2] = null;
                }
            }
        }
        this.r = null;
        AppMethodBeat.o(14974);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void j() {
        AppMethodBeat.i(14975);
        super.j();
        if (this.t) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(this.u, 771);
            GLES20.glActiveTexture(33984);
            for (int i2 = 0; i2 < this.r.length; i2++) {
                if (this.r[i2] != null) {
                    GLES20.glBindTexture(3553, this.r[i2].f550d[0]);
                    GLES20.glUniform1i(this.f302c, 0);
                    GLES20.glVertexAttribPointer(this.f301b, 2, 5126, false, 8, (Buffer) this.r[i2].f547a);
                    GLES20.glEnableVertexAttribArray(this.f301b);
                    GLES20.glVertexAttribPointer(this.f303d, 4, 5126, false, 16, (Buffer) this.r[i2].f548b);
                    GLES20.glEnableVertexAttribArray(this.f303d);
                    GLES20.glDrawElements(4, v.length, 5123, this.w);
                    GLES20.glDisableVertexAttribArray(this.f301b);
                    GLES20.glDisableVertexAttribArray(this.f303d);
                }
            }
            GLES20.glDisable(3042);
        }
        AppMethodBeat.o(14975);
    }
}
