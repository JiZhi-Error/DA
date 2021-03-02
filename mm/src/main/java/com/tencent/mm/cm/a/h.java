package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h extends a {
    public boolean RfT;
    private int[] RfU;
    public int RfX;
    public int RfY;
    public int RfZ;
    public int Rga;
    private ByteBuffer Rgb;
    private boolean Rgc;
    private boolean Rgd;
    private boolean Rge;
    private boolean Rgf;
    private Bitmap mBitmap;

    public h(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public h(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(190261);
        this.Rga = -1;
        this.RfT = false;
        this.Rgc = false;
        this.Rgd = false;
        this.Rge = false;
        this.Rgf = false;
        a(j.NORMAL);
        AppMethodBeat.o(190261);
    }

    @Override // com.tencent.mm.cm.a.a
    public void MC() {
        AppMethodBeat.i(190262);
        super.MC();
        this.RfX = GLES20.glGetAttribLocation(hfa(), "inputTextureCoordinate2");
        this.RfY = GLES20.glGetUniformLocation(hfa(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.RfX);
        if (this.RfT) {
            GLES20.glGenFramebuffers(1, this.RfU, 0);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, 1080, 1853, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            this.Rga = iArr[0];
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            setBitmap(this.mBitmap);
        }
        AppMethodBeat.o(190262);
    }

    public void setBitmap(final Bitmap bitmap) {
        AppMethodBeat.i(190263);
        if (bitmap == null || !bitmap.isRecycled()) {
            this.mBitmap = bitmap;
            if (this.mBitmap == null) {
                AppMethodBeat.o(190263);
                return;
            }
            aR(new Runnable() {
                /* class com.tencent.mm.cm.a.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(190260);
                    if (h.this.Rga == -1) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.o(190260);
                            return;
                        }
                        GLES20.glActiveTexture(33986);
                        h.this.Rga = i.aO(bitmap);
                    }
                    AppMethodBeat.o(190260);
                }
            });
            AppMethodBeat.o(190263);
            return;
        }
        AppMethodBeat.o(190263);
    }

    @Override // com.tencent.mm.cm.a.a
    public void onDestroy() {
        AppMethodBeat.i(190264);
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.Rga}, 0);
        this.Rga = -1;
        if (this.RfU != null) {
            GLES20.glDeleteFramebuffers(this.RfU.length, this.RfU, 0);
            this.RfU = null;
        }
        AppMethodBeat.o(190264);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.cm.a.a
    public final void b(FloatBuffer floatBuffer) {
        AppMethodBeat.i(190265);
        GLES20.glEnableVertexAttribArray(this.RfX);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.Rga);
        GLES20.glUniform1i(this.RfY, 2);
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.RfX, 2, 5126, false, 0, (Buffer) floatBuffer);
        AppMethodBeat.o(190265);
    }

    @Override // com.tencent.mm.cm.a.a
    public void a(int i2, int i3, int i4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(190266);
        GLES20.glUseProgram(this.Rfd);
        heZ();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.Rfe, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.Rfe);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.Rfg, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.Rfg);
        if (i2 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(this.Rff, 0);
        }
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.RfX, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.RfX);
        if (i3 != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, i3);
            GLES20.glUniform1i(this.RfY, 3);
        }
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.Rfe);
        GLES20.glDisableVertexAttribArray(this.Rfg);
        GLES20.glDisableVertexAttribArray(this.RfZ);
        GLES20.glDisableVertexAttribArray(this.RfX);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(190266);
    }

    public void a(j jVar) {
        AppMethodBeat.i(190267);
        float[] a2 = l.a(jVar, false);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a2);
        asFloatBuffer.flip();
        this.Rgb = order;
        AppMethodBeat.o(190267);
    }
}
