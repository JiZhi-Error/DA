package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJF\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\rJ0\u0010\u001b\u001a\u00020\u000f2(\u0010\u001c\u001a$\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u001dj\u0002`\u001fJ\u001e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "release", "", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "encodeRotate", "encodeMirror", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "plugin-voip_release"})
public final class c {
    public com.tencent.mm.plugin.voip.video.render.a Hms;
    public final boolean Hmt = g.fKi();
    public int hEA;
    public e hEx;
    public int hEy;
    public int hEz;
    public int programId;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram$setRGBDataCallback$1$1"})
    public static final class a extends q implements b<ByteBuffer, x> {
        final /* synthetic */ r Hmv;
        final /* synthetic */ c Hmw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, r rVar) {
            super(1);
            this.Hmw = cVar;
            this.Hmv = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer) {
            AppMethodBeat.i(236170);
            ByteBuffer byteBuffer2 = byteBuffer;
            p.h(byteBuffer2, LocaleUtil.ITALIAN);
            r rVar = this.Hmv;
            e eVar = this.Hmw.hEx;
            if (eVar == null) {
                p.hyc();
            }
            Integer valueOf = Integer.valueOf(eVar.ijO);
            e eVar2 = this.Hmw.hEx;
            if (eVar2 == null) {
                p.hyc();
            }
            rVar.invoke(byteBuffer2, valueOf, Integer.valueOf(eVar2.ijP), 0);
            x xVar = x.SXb;
            AppMethodBeat.o(236170);
            return xVar;
        }
    }

    public c() {
        AppMethodBeat.i(236171);
        g gVar = g.HgZ;
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        if (g.fKg()) {
            if (this.Hmt) {
                this.Hms = new com.tencent.mm.plugin.voip.video.render.a();
                AppMethodBeat.o(236171);
                return;
            }
            this.hEx = new e(0, 0, 0, 0, 2, 0, 32);
        }
        AppMethodBeat.o(236171);
    }
}
