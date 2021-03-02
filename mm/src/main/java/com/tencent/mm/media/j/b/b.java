package com.tencent.mm.media.j.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0014J\u0018\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020!2\b\b\u0002\u00100\u001a\u000201J\u000e\u00102\u001a\u00020,2\u0006\u0010/\u001a\u00020!J\u000e\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\u0014J&\u00105\u001a\u00020,2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u0002072\u0006\u0010:\u001a\u000207J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020\u0003H\u0016J\u000e\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n )*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "blendAttributeBlurBgTextureCoord", "blendAttributePosition", "blendAttributeTextureCoord", "blendBitmapTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendBlurTextureCoordBuff", "Ljava/nio/FloatBuffer;", "blendCenterLocationBuffer", "", "blendProgramId", "blendTextureCoordBuff", "blendUniformBlurBgTexture", "blendUniformCenterLocation", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasBlurBgTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformUseNormalVideoTexture", "blurBgBitmap", "Landroid/graphics/Bitmap;", "blurBgBitmapTextureObj", "currentBlendBitmap", "emojiBlendAttributeTextureCoord", "inputTexture", "inputTextureHeight", "inputTextureWidth", "sizeBuffer", "kotlin.jvm.PlatformType", "textureType", "release", "", "renderImpl", "setBlendBitmap", "bitmap", "flip", "", "setBlurBgBitmap", "setBlurBgTextureCoordBuff", "blurBgCoord", "setCenterLocation", "top", "", "bottom", "left", "right", "setInputTexture", "texture", "setTextureType", "type", "plugin-mediaeditor_release"})
public class b extends a {
    private final String TAG;
    public int hDl;
    private int ijY;
    private int ijZ;
    private Bitmap ika;
    private d ikb;
    public Bitmap ikc;
    private d ikd;
    public final float[] ike;
    private int ikf;
    private int ikg;
    private int ikh;
    private int iki;
    private int ikj;
    private int ikk;
    private int ikl;
    private int ikm;
    private int ikn;
    private int iko;
    private int ikp;
    private int ikq;
    private int ikr;
    private int iks;
    private final FloatBuffer ikt;
    private FloatBuffer iku;
    public FloatBuffer ikv;
    public int textureType;

    public b(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        AppMethodBeat.i(218761);
        this.TAG = "MircoMsg.GLTextureRenderProcBlend";
        this.ike = new float[4];
        this.ikt = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(c.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.iku = asFloatBuffer;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(c.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer2, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.ikv = asFloatBuffer2;
        this.textureType = 36197;
        this.ijY = i2;
        this.ijZ = i3;
        this.ikb = com.tencent.mm.media.g.c.a(true, 4);
        this.ikd = com.tencent.mm.media.g.c.a(true, 4);
        c.a aVar = c.ilt;
        this.ikf = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        attribute vec2 a_texBlurBgCoord;\n        attribute vec2 a_texEmojiCoord;\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n            v_texBlurBgCoord = a_texBlurBgCoord;\n            v_texEmojiCoord = a_texEmojiCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        varying vec2 v_texBlurBgCoord;\n        varying vec2 v_texEmojiCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform sampler2D blurBgTexture;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int hasBlurBgTexture;\n        uniform vec4 centerLocation; //按top bottom left right来传\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec4 videoColor;\n            vec4 blendElementsColor;\n\n            if (hasBlurBgTexture == 1) {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texBlurBgCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texBlurBgCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (gl_FragCoord.y > centerLocation[0] || gl_FragCoord.y < centerLocation[1] ||\n                    gl_FragCoord.x > centerLocation[3] || gl_FragCoord.x < centerLocation[2]) {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(texture2D(blurBgTexture, v_texCoord), texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = texture2D(blurBgTexture, v_texCoord);\n                    }\n                } else {\n                    if (hasEmojiTexture == 1) {\n                        gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                    } else {\n                        gl_FragColor = videoColor;\n                    }\n                }\n            } else {\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texEmojiCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
        this.ikg = GLES20.glGetAttribLocation(this.ikf, "a_position");
        this.ikh = GLES20.glGetAttribLocation(this.ikf, "a_texCoord");
        this.iki = GLES20.glGetAttribLocation(this.ikf, "a_texEmojiCoord");
        this.iks = GLES20.glGetAttribLocation(this.ikf, "a_texBlurBgCoord");
        this.ikj = GLES20.glGetUniformLocation(this.ikf, "videoExternalTexture");
        this.ikk = GLES20.glGetUniformLocation(this.ikf, "videoNormalTexture");
        this.ikl = GLES20.glGetUniformLocation(this.ikf, "emojiTexture");
        this.ikm = GLES20.glGetUniformLocation(this.ikf, "hasEmojiTexture");
        this.iko = GLES20.glGetUniformLocation(this.ikf, "uMatrix");
        this.ikn = GLES20.glGetUniformLocation(this.ikf, "useNormalVideoTexture");
        this.ikq = GLES20.glGetUniformLocation(this.ikf, "blurBgTexture");
        this.ikp = GLES20.glGetUniformLocation(this.ikf, "hasBlurBgTexture");
        this.ikr = GLES20.glGetUniformLocation(this.ikf, "centerLocation");
        this.iku.position(0);
        this.iku.put(c.ilo);
        this.iku.position(0);
        AppMethodBeat.o(218761);
    }

    public /* synthetic */ b(int i2, int i3) {
        this(0, 0, i2, i3, 1, 4);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.hDl = i2;
    }

    public static /* synthetic */ void a(b bVar, Bitmap bitmap) {
        AppMethodBeat.i(218760);
        p.h(bitmap, "bitmap");
        bVar.ika = bitmap;
        bVar.iku.position(0);
        bVar.iku.put(c.iln);
        bVar.iku.position(0);
        AppMethodBeat.o(218760);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        AppMethodBeat.i(93854);
        long currentTicks = Util.currentTicks();
        GLES20.glUseProgram(this.ikf);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.textureType, this.hDl);
        GLES20.glTexParameterf(this.textureType, 10241, 9729.0f);
        GLES20.glTexParameterf(this.textureType, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(this.textureType, 10242, 10497.0f);
        GLES20.glTexParameterf(this.textureType, 10243, 10497.0f);
        if (this.textureType == 3553) {
            GLES20.glUniform1i(this.ikn, 1);
            GLES20.glUniform1i(this.ikk, 0);
            GLES20.glUniform1i(this.ikj, 3);
        } else {
            GLES20.glUniform1i(this.ikn, 0);
            GLES20.glUniform1i(this.ikk, 3);
            GLES20.glUniform1i(this.ikj, 0);
        }
        if (this.ika != null) {
            GLES20.glActiveTexture(33985);
            Bitmap bitmap = this.ika;
            if (bitmap != null) {
                d.a(this.ikb, bitmap);
            }
            GLES20.glUniform1i(this.ikl, 1);
            GLES20.glUniform1i(this.ikm, 1);
        } else {
            GLES20.glUniform1i(this.ikl, 1);
            GLES20.glUniform1i(this.ikm, 0);
        }
        if (this.ikc != null) {
            GLES20.glActiveTexture(33986);
            Bitmap bitmap2 = this.ikc;
            if (bitmap2 != null) {
                d.a(this.ikd, bitmap2);
            }
            GLES20.glUniform1i(this.ikq, 2);
            GLES20.glUniform1i(this.ikp, 1);
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.ike.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.ike).position(0);
            GLES20.glUniform4fv(this.ikr, 1, asFloatBuffer);
            this.ikv.position(0);
            GLES20.glVertexAttribPointer(this.iks, 2, 5126, false, 0, (Buffer) this.ikv);
            GLES20.glEnableVertexAttribArray(this.iks);
        } else {
            GLES20.glUniform1i(this.ikp, 0);
            GLES20.glUniform1i(this.ikq, 2);
        }
        this.hDU.position(0);
        GLES20.glVertexAttribPointer(this.ikg, 2, 5126, false, 0, (Buffer) this.hDU);
        GLES20.glEnableVertexAttribArray(this.ikg);
        this.hDT.position(0);
        this.iku.position(0);
        GLES20.glVertexAttribPointer(this.iki, 2, 5126, false, 0, (Buffer) this.iku);
        GLES20.glEnableVertexAttribArray(this.iki);
        GLES20.glVertexAttribPointer(this.ikh, 2, 5126, false, 0, (Buffer) this.hDT);
        GLES20.glEnableVertexAttribArray(this.ikh);
        GLES20.glUniformMatrix4fv(this.iko, 1, false, this.ijG, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.ikg);
        GLES20.glDisableVertexAttribArray(this.ikh);
        GLES20.glDisableVertexAttribArray(this.iki);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindTexture(36197, 0);
        GLES20.glFinish();
        GLES20.glUseProgram(0);
        this.ika = null;
        this.ikc = null;
        Log.i(this.TAG, "draw frame used " + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
        AppMethodBeat.o(93854);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void release() {
        AppMethodBeat.i(93855);
        super.release();
        this.ikb.close();
        this.ikd.close();
        AppMethodBeat.o(93855);
    }
}
