package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.nio.ByteBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\"J`\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020 J\u0016\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u000204J0\u00105\u001a\u00020\"2(\u00106\u001a$\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"07j\u0002`9J\u001e\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004J\u0018\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0016J\u0018\u0010A\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "glOutFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "glSTFilterInputFrameBufferObject", "getGlSTFilterInputFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlSTFilterInputFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glSTFilterInputTextureObject", "getGlSTFilterInputTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlSTFilterInputTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mSTFilter", "Lcom/tencent/mm/video/videoprocessing/GPUImageSpatiotemporalDenosing;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "stFilterOutputTexture", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "texture", "outputTexture", "useSTfilterScreenOut", "encodeRotate", "encodeMirror", "skipFilter", "setMotionLevel", "motionLevel", "noiseLevel", "", "setSTFilterDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateSurfaceSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class e {
    public static final a HmE = new a((byte) 0);
    public com.tencent.mm.media.g.a HmA;
    public f HmB;
    public d HmC;
    public com.tencent.mm.media.g.a HmD;
    public com.tencent.mm.plugin.voip.video.render.a Hms;
    public final boolean Hmt = g.fKi();
    public int hEA;
    public d hEv;
    public com.tencent.mm.media.j.b.e hEx;
    public int hEy;
    public int hEz;
    public int programId;

    static {
        AppMethodBeat.i(236177);
        AppMethodBeat.o(236177);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram$setSTFilterDataCallback$1$1"})
    public static final class b extends q implements kotlin.g.a.b<ByteBuffer, x> {
        final /* synthetic */ e HmF;
        final /* synthetic */ r Hmv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, r rVar) {
            super(1);
            this.HmF = eVar;
            this.Hmv = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer) {
            AppMethodBeat.i(236174);
            ByteBuffer byteBuffer2 = byteBuffer;
            p.h(byteBuffer2, LocaleUtil.ITALIAN);
            r rVar = this.Hmv;
            com.tencent.mm.media.j.b.e eVar = this.HmF.hEx;
            if (eVar == null) {
                p.hyc();
            }
            Integer valueOf = Integer.valueOf(eVar.ijO);
            com.tencent.mm.media.j.b.e eVar2 = this.HmF.hEx;
            if (eVar2 == null) {
                p.hyc();
            }
            rVar.invoke(byteBuffer2, valueOf, Integer.valueOf(eVar2.ijP), 0);
            x xVar = x.SXb;
            AppMethodBeat.o(236174);
            return xVar;
        }
    }

    public e() {
        AppMethodBeat.i(236176);
        g gVar = g.HgZ;
        c.a aVar = c.ilt;
        this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
        this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        if (this.Hmt) {
            this.Hms = new com.tencent.mm.plugin.voip.video.render.a();
        } else {
            this.hEx = new com.tencent.mm.media.j.b.e(0, 0, 0, 0, 2, 0, 32);
        }
        this.HmB = new f();
        f fVar = this.HmB;
        if (fVar != null) {
            fVar.MC();
        }
        if (this.HmC == null) {
            this.HmC = com.tencent.mm.media.g.c.a(true, 3);
            com.tencent.mm.media.g.c cVar = com.tencent.mm.media.g.c.igu;
            this.HmD = com.tencent.mm.media.g.c.zI(3);
        }
        w(5, 0.024f);
        AppMethodBeat.o(236176);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void w(int i2, float f2) {
        AppMethodBeat.i(236175);
        f fVar = this.HmB;
        if (fVar != null) {
            fVar.apH(i2);
            fVar.cH(f2);
            AppMethodBeat.o(236175);
            return;
        }
        AppMethodBeat.o(236175);
    }
}
