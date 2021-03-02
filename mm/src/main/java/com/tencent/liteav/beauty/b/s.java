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

public class s extends h {
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    private ByteBuffer x;
    private ByteBuffer y;

    public s(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", str);
        AppMethodBeat.i(15072);
        a(k.NORMAL, false, true);
        AppMethodBeat.o(15072);
    }

    public s(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(15073);
        this.t = -1;
        this.w = -1;
        a(k.NORMAL, false, true);
        AppMethodBeat.o(15073);
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15074);
        boolean b2 = super.b();
        GLES20.glUseProgram(p());
        this.r = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
        this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate3");
        this.s = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
        this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture3");
        GLES20.glEnableVertexAttribArray(this.r);
        GLES20.glEnableVertexAttribArray(this.u);
        AppMethodBeat.o(15074);
        return b2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public int a(int i2, int i3, int i4) {
        AppMethodBeat.i(15075);
        int a2 = a(i2, i3, i4, this.m, this.n);
        AppMethodBeat.o(15075);
        return a2;
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(15076);
        this.t = i3;
        this.w = i4;
        int a2 = super.a(i2, i5, i6);
        AppMethodBeat.o(15076);
        return a2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15077);
        super.a(i2, i3);
        AppMethodBeat.o(15077);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void i() {
        AppMethodBeat.i(15078);
        GLES20.glEnableVertexAttribArray(this.r);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.t);
        GLES20.glUniform1i(this.s, 3);
        this.x.position(0);
        GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 0, (Buffer) this.x);
        GLES20.glEnableVertexAttribArray(this.u);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.w);
        GLES20.glUniform1i(this.v, 4);
        this.y.position(0);
        GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, (Buffer) this.y);
        AppMethodBeat.o(15078);
    }

    public void a(k kVar, boolean z, boolean z2) {
        AppMethodBeat.i(221436);
        float[] a2 = l.a(kVar, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a2);
        asFloatBuffer.flip();
        this.x = order;
        ByteBuffer order2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = order2.asFloatBuffer();
        asFloatBuffer2.put(a2);
        asFloatBuffer2.flip();
        this.y = order2;
        AppMethodBeat.o(221436);
    }
}
