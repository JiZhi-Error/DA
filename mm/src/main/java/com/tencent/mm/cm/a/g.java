package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class g extends h {
    public int RfP;
    public int RfQ;
    public int RfR;
    public int RfS;
    public boolean RfT;
    private int[] RfU;
    private ByteBuffer RfV;
    private Bitmap mBitmap;

    public g(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", str);
    }

    private g(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(190254);
        this.RfS = -1;
        this.RfT = true;
        a(j.NORMAL);
        AppMethodBeat.o(190254);
    }

    @Override // com.tencent.mm.cm.a.a, com.tencent.mm.cm.a.h
    public void MC() {
        AppMethodBeat.i(190255);
        super.MC();
        this.RfR = GLES20.glGetAttribLocation(this.Rfd, "position");
        this.RfP = GLES20.glGetAttribLocation(hfa(), "inputTextureCoordinate3");
        this.RfQ = GLES20.glGetUniformLocation(hfa(), "inputImageTexture3");
        GLES20.glEnableVertexAttribArray(this.RfP);
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            setBitmap(this.mBitmap);
        }
        AppMethodBeat.o(190255);
    }

    @Override // com.tencent.mm.cm.a.h
    public final void setBitmap(final Bitmap bitmap) {
        AppMethodBeat.i(190256);
        if (bitmap == null || !bitmap.isRecycled()) {
            this.mBitmap = bitmap;
            if (this.mBitmap == null) {
                AppMethodBeat.o(190256);
                return;
            }
            aR(new Runnable() {
                /* class com.tencent.mm.cm.a.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(190253);
                    if (g.this.RfS == -1) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.o(190253);
                            return;
                        }
                        GLES20.glActiveTexture(33987);
                        g.this.RfS = i.aO(bitmap);
                    }
                    AppMethodBeat.o(190253);
                }
            });
            AppMethodBeat.o(190256);
            return;
        }
        AppMethodBeat.o(190256);
    }

    @Override // com.tencent.mm.cm.a.a, com.tencent.mm.cm.a.h
    public final void onDestroy() {
        AppMethodBeat.i(190257);
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.RfS}, 0);
        this.RfS = -1;
        if (this.RfU != null) {
            GLES20.glDeleteFramebuffers(this.RfU.length, this.RfU, 0);
            this.RfU = null;
        }
        AppMethodBeat.o(190257);
    }

    @Override // com.tencent.mm.cm.a.a, com.tencent.mm.cm.a.h
    public final void a(int i2, int i3, int i4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(190258);
        GLES20.glUseProgram(this.Rfd);
        heZ();
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
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, i3);
        GLES20.glUniform1i(this.RfY, 2);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.RfP, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.RfP);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, i4);
        GLES20.glUniform1i(this.RfQ, 3);
        GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.Rfe);
        GLES20.glDisableVertexAttribArray(this.Rfg);
        GLES20.glDisableVertexAttribArray(this.RfZ);
        GLES20.glDisableVertexAttribArray(this.RfX);
        GLES20.glDisableVertexAttribArray(this.RfR);
        GLES20.glDisableVertexAttribArray(this.RfP);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(190258);
    }

    @Override // com.tencent.mm.cm.a.h
    public final void a(j jVar) {
        AppMethodBeat.i(190259);
        float[] a2 = l.a(jVar, false);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a2);
        asFloatBuffer.flip();
        this.RfV = order;
        AppMethodBeat.o(190259);
    }
}
