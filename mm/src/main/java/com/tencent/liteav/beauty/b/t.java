package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class t extends h {
    private ByteBuffer r;
    public int u;
    public int v;
    public int w;

    public t(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public t(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(15101);
        this.u = -1;
        this.w = -1;
        a(k.NORMAL, false, true);
        AppMethodBeat.o(15101);
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15102);
        boolean b2 = super.b();
        if (b2) {
            this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
            this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
            GLES20.glEnableVertexAttribArray(this.u);
        }
        AppMethodBeat.o(15102);
        return b2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(15103);
        super.e();
        AppMethodBeat.o(15103);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void i() {
        AppMethodBeat.i(15104);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.w);
        GLES20.glUniform1i(this.v, 3);
        if (this.u != -1) {
            GLES20.glEnableVertexAttribArray(this.u);
            this.r.position(0);
            GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, (Buffer) this.r);
        }
        AppMethodBeat.o(15104);
    }

    public void a(k kVar, boolean z, boolean z2) {
        AppMethodBeat.i(221438);
        float[] a2 = l.a(kVar, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a2);
        asFloatBuffer.flip();
        this.r = order;
        AppMethodBeat.o(221438);
    }

    public int c(int i2, int i3) {
        AppMethodBeat.i(15106);
        this.w = i3;
        int a2 = a(i2, this.m, this.n);
        AppMethodBeat.o(15106);
        return a2;
    }

    public int a(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(15107);
        this.w = i3;
        int a2 = a(i2, i4, i5);
        AppMethodBeat.o(15107);
        return a2;
    }
}
