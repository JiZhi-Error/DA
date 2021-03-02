package com.tencent.mm.media.j.b;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "attributeYUVPosition", "attributeYUVTextureCoord", "frame", "", "uBuffer", "Ljava/nio/ByteBuffer;", "uTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "uniformUTexture", "uniformVTexture", "uniformYTexture", "uniformYUVRotateMatrix", "vBuffer", "vTextureObj", "yBuffer", "yTextureObj", "yuvProgramId", "afterRender", "", "getFrame", "release", "renderImpl", "setFrame", "updateScaleType", "Companion", "plugin-mediaeditor_release"})
public final class d extends a {
    private static final String TAG = TAG;
    public static final a ikM = new a((byte) 0);
    private com.tencent.mm.media.g.d ikA;
    private int ikB;
    private int ikC;
    private int ikD;
    private int ikE;
    private int ikF;
    private int ikG;
    private int ikH;
    private ByteBuffer ikI;
    private ByteBuffer ikJ;
    private ByteBuffer ikK;
    private byte[] ikL;
    private com.tencent.mm.media.g.d iky;
    private com.tencent.mm.media.g.d ikz;

    private d(int i2, int i3, int i4, int i5, int i6) {
        super(i2, i3, i4, i5, 1, i6);
        AppMethodBeat.i(218767);
        this.ikL = new byte[0];
        c.a aVar = c.ilt;
        this.ikB = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D y_texture;\n        uniform sampler2D u_texture;\n        uniform sampler2D v_texture;\n\n        void main () {\n           float r, g, b, y, u, v;\n\n        //We had put the Y values of each pixel to the R,G,B components by GL_LUMINANCE,\n        //that's why we're pulling it from the R component, we could also use G or B\n           y = texture2D(y_texture, v_texCoord).r;\n\n        //We had put the U and V values of each pixel to the A and R,G,B components of the\n        //texture respectively using GL_LUMINANCE_ALPHA. Since U,V bytes are interspread\n        //in the texture, this is probably the fastest way to use them in the shader\n        //GL_LUMINANCE_ALPHA is a luminance/alpha pair, so r correspond to v, and\n        //a correspond to u\n        //NV21 is a VUVU pair\n           v = texture2D(v_texture, v_texCoord).r;\n           u = texture2D(u_texture, v_texCoord).r;\n           u = u - 0.5;\n           v = v - 0.5;\n\n        //The numbers are just YUV to RGB conversion constants\n        //https://en.wikipedia.org/wiki/YUV#Y.E2.80.B2UV420sp_.28NV21.29_to_RGB_conversion_.28Android.29\n           r = y + 1.370705 * v;\n           g = y - 0.337633 * u - 0.698001 * v;\n           b = y + 1.732446 * u;\n\n        //We finally set the RGB color of our pixel\n           gl_FragColor = vec4(r, g, b, 1.0);\n        }\n        ");
        if (this.ikB == 0) {
            Log.e(TAG, "checkInit, load program failed!");
        }
        this.ikD = GLES20.glGetAttribLocation(this.ikB, "a_position");
        this.ikC = GLES20.glGetAttribLocation(this.ikB, "a_texCoord");
        this.ikE = GLES20.glGetUniformLocation(this.ikB, "y_texture");
        this.ikF = GLES20.glGetUniformLocation(this.ikB, "u_texture");
        this.ikG = GLES20.glGetUniformLocation(this.ikB, "v_texture");
        this.ikH = GLES20.glGetUniformLocation(this.ikB, "uMatrix");
        this.iky = com.tencent.mm.media.g.c.a(true, 5);
        this.ikz = com.tencent.mm.media.g.c.a(true, 5);
        this.ikA = com.tencent.mm.media.g.c.a(true, 5);
        AppMethodBeat.o(218767);
    }

    public /* synthetic */ d(int i2, int i3, int i4, int i5, int i6, byte b2) {
        this(i2, i3, i4, i5, i6);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void ag(byte[] bArr) {
        AppMethodBeat.i(218763);
        p.h(bArr, "frame");
        this.ikL = bArr;
        AppMethodBeat.o(218763);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        AppMethodBeat.i(218764);
        GLES30.glClear(16640);
        GLES30.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (this.ikB != 0 && this.hEp > 0 && this.hEq > 0) {
            if (!(this.ikL.length == 0)) {
                if (this.ikI == null || this.ikJ == null || this.ikK == null || (byteBuffer = this.ikI) == null || byteBuffer.capacity() != this.hDn * this.hDo || (byteBuffer2 = this.ikJ) == null || byteBuffer2.capacity() != (this.hDn * this.hDo) / 4 || (byteBuffer3 = this.ikK) == null || byteBuffer3.capacity() != (this.hDn * this.hDn) / 4) {
                    this.ikI = ByteBuffer.allocateDirect(this.hDn * this.hDo);
                    this.ikJ = ByteBuffer.allocateDirect((this.hDn * this.hDo) / 4);
                    this.ikK = ByteBuffer.allocateDirect((this.hDn * this.hDo) / 4);
                    ByteBuffer byteBuffer4 = this.ikI;
                    if (byteBuffer4 != null) {
                        byteBuffer4.order(ByteOrder.nativeOrder());
                    }
                    ByteBuffer byteBuffer5 = this.ikJ;
                    if (byteBuffer5 != null) {
                        byteBuffer5.order(ByteOrder.nativeOrder());
                    }
                    ByteBuffer byteBuffer6 = this.ikK;
                    if (byteBuffer6 != null) {
                        byteBuffer6.order(ByteOrder.nativeOrder());
                    }
                }
                ByteBuffer byteBuffer7 = this.ikI;
                if (byteBuffer7 != null) {
                    byteBuffer7.put(this.ikL, 0, this.hDn * this.hDo);
                }
                ByteBuffer byteBuffer8 = this.ikI;
                if (byteBuffer8 != null) {
                    byteBuffer8.position(0);
                }
                ByteBuffer byteBuffer9 = this.ikJ;
                if (byteBuffer9 != null) {
                    byteBuffer9.put(this.ikL, this.hDn * this.hDo, (this.hDn * this.hDo) / 4);
                }
                ByteBuffer byteBuffer10 = this.ikJ;
                if (byteBuffer10 != null) {
                    byteBuffer10.position(0);
                }
                ByteBuffer byteBuffer11 = this.ikK;
                if (byteBuffer11 != null) {
                    byteBuffer11.put(this.ikL, (this.hDn * this.hDo) + ((this.hDn * this.hDo) / 4), (this.hDn * this.hDo) / 4);
                }
                ByteBuffer byteBuffer12 = this.ikK;
                if (byteBuffer12 != null) {
                    byteBuffer12.position(0);
                }
                GLES20.glUseProgram(this.ikB);
                GLES20.glActiveTexture(33984);
                com.tencent.mm.media.g.d.a(this.iky, this.hDn, this.hDo, 6409, this.ikI, 0, 0, 48);
                GLES20.glUniform1i(this.ikE, 0);
                GLES20.glActiveTexture(33985);
                com.tencent.mm.media.g.d.a(this.ikz, this.hDn / 2, this.hDo / 2, 6409, this.ikJ, 0, 0, 48);
                GLES20.glUniform1i(this.ikF, 1);
                GLES20.glActiveTexture(33986);
                com.tencent.mm.media.g.d.a(this.ikA, this.hDn / 2, this.hDo / 2, 6409, this.ikK, 0, 0, 48);
                GLES20.glUniform1i(this.ikG, 2);
                GLES20.glUniformMatrix4fv(this.ikH, 1, false, this.ijG, 0);
                this.hDU.position(0);
                GLES20.glVertexAttribPointer(this.ikD, 2, 5126, false, 0, (Buffer) this.hDU);
                GLES20.glEnableVertexAttribArray(this.ikD);
                this.hDT.position(0);
                GLES20.glVertexAttribPointer(this.ikC, 2, 5126, false, 0, (Buffer) this.hDT);
                GLES20.glEnableVertexAttribArray(this.ikC);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.ikD);
                GLES20.glDisableVertexAttribArray(this.ikC);
                GLES20.glBindTexture(3553, 0);
                GLES20.glFinish();
            }
        }
        AppMethodBeat.o(218764);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMU() {
        AppMethodBeat.i(218765);
        super.aMU();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        AppMethodBeat.o(218765);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(218768);
        AppMethodBeat.o(218768);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void release() {
        AppMethodBeat.i(218766);
        super.release();
        this.iky.close();
        this.ikz.close();
        AppMethodBeat.o(218766);
    }

    public final void rm(int i2) {
        this.scaleType = i2;
    }
}
