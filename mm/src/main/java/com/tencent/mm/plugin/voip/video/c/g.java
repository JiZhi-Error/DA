package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.voip.video.a.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u0013J`\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0011J0\u0010#\u001a\u00020\u00132(\u0010$\u001a$\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130%j\u0002`'J\u001e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "texture", "outputTexture", "useSTFilter", "encodeRotate", "encodeMirror", "setFaceBeautyDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "Companion", "plugin-voip_release"})
public final class g {
    public static final a HmI = new a((byte) 0);
    public volatile d HmH;
    public com.tencent.mm.plugin.voip.video.render.a Hms;
    public final boolean Hmt = com.tencent.mm.plugin.voip.b.g.fKi();
    private int hEA;
    public com.tencent.mm.media.g.d hEv;
    public e hEx;
    private int hEy;
    private int hEz;
    public int programId;

    static {
        AppMethodBeat.i(236183);
        AppMethodBeat.o(236183);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$setFaceBeautyDataCallback$1$1"})
    public static final class b extends q implements kotlin.g.a.b<ByteBuffer, x> {
        final /* synthetic */ g HmJ;
        final /* synthetic */ r Hmv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, r rVar) {
            super(1);
            this.HmJ = gVar;
            this.Hmv = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer) {
            AppMethodBeat.i(236179);
            ByteBuffer byteBuffer2 = byteBuffer;
            p.h(byteBuffer2, LocaleUtil.ITALIAN);
            r rVar = this.Hmv;
            e eVar = this.HmJ.hEx;
            if (eVar == null) {
                p.hyc();
            }
            Integer valueOf = Integer.valueOf(eVar.ijO);
            e eVar2 = this.HmJ.hEx;
            if (eVar2 == null) {
                p.hyc();
            }
            rVar.invoke(byteBuffer2, valueOf, Integer.valueOf(eVar2.ijP), 0);
            x xVar = x.SXb;
            AppMethodBeat.o(236179);
            return xVar;
        }
    }

    public g() {
        AppMethodBeat.i(236182);
        com.tencent.mm.plugin.voip.b.g gVar = com.tencent.mm.plugin.voip.b.g.HgZ;
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
            AppMethodBeat.o(236182);
            return;
        }
        this.hEx = new e(0, 0, 0, 0, 2, 0, 32);
        AppMethodBeat.o(236182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void jL(int i2, int i3) {
        AppMethodBeat.i(236180);
        if (i2 != 0 && this.hEv == null) {
            this.hEv = com.tencent.mm.media.g.c.a(true, 14);
            this.HmH = new d();
            d dVar = this.HmH;
            if (dVar != null) {
                com.tencent.mm.media.g.d dVar2 = this.hEv;
                if (dVar2 == null) {
                    p.hyc();
                }
                p.h(dVar2, "outputTexture");
                try {
                    String str = d.TAG;
                    Thread currentThread = Thread.currentThread();
                    p.g(currentThread, "Thread.currentThread()");
                    Log.i(str, "initial %s, %d, beauytParams:%s", dVar, Long.valueOf(currentThread.getId()), Integer.valueOf(i2));
                    if (dVar.hiH != null) {
                        Log.w(d.TAG, "initial xLabEffect: again");
                        com.tencent.mm.plugin.xlabeffect.b bVar = dVar.hiH;
                        if (bVar == null) {
                            p.hyc();
                        }
                        bVar.destroy();
                    }
                    dVar.hiH = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 1);
                    com.tencent.mm.plugin.xlabeffect.b bVar2 = dVar.hiH;
                    if (bVar2 == null) {
                        p.hyc();
                    }
                    bVar2.zG(false);
                    int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_lut_color_weight, 0);
                    int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_skin_smooth_weight, -1);
                    int a4 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_skin_bright_weight, -1);
                    int a5 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_eye_bigger_weight, -1);
                    int a6 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_eye_bright_weight, -1);
                    int a7 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_voip_face_thin_weight, -1);
                    Log.i(d.TAG, "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4), Integer.valueOf(a5), Integer.valueOf(a6), Integer.valueOf(a7));
                    com.tencent.mm.plugin.xlabeffect.b bVar3 = dVar.hiH;
                    if (bVar3 != null) {
                        bVar3.l(a3, a5, a7, a4, a6);
                    }
                    boolean z = (i2 & 1) != 0;
                    boolean z2 = (i2 & 2) != 0;
                    boolean z3 = (i2 & 4) != 0;
                    Log.i(d.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
                    if (z) {
                        com.tencent.mm.plugin.xlabeffect.b bVar4 = dVar.hiH;
                        if (bVar4 == null) {
                            p.hyc();
                        }
                        bVar4.glh();
                    }
                    if (z2) {
                        com.tencent.mm.plugin.xlabeffect.b bVar5 = dVar.hiH;
                        if (bVar5 == null) {
                            p.hyc();
                        }
                        bVar5.glj();
                    }
                    if (z3) {
                        com.tencent.mm.plugin.xlabeffect.b bVar6 = dVar.hiH;
                        if (bVar6 == null) {
                            p.hyc();
                        }
                        bVar6.gll();
                        com.tencent.mm.plugin.xlabeffect.b bVar7 = dVar.hiH;
                        if (bVar7 == null) {
                            p.hyc();
                        }
                        bVar7.aa(true, a2);
                    }
                    dVar.hDl = i3;
                    dVar.hDm = dVar2;
                    Log.d(d.TAG, "initial end %s", dVar);
                    AppMethodBeat.o(236180);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace(d.TAG, e2, "initial error", new Object[0]);
                    AppMethodBeat.o(236180);
                    return;
                }
            }
        }
        AppMethodBeat.o(236180);
    }

    public final com.tencent.mm.media.g.d a(int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i4, com.tencent.mm.media.g.d dVar, int i5, int i6, int i7, boolean z) {
        AppMethodBeat.i(236181);
        p.h(floatBuffer, "cubeBuffer");
        p.h(floatBuffer2, "textureCoordBuff");
        p.h(dVar, "outputTexture");
        if (i4 != -1) {
            if (i6 == 0) {
                GLES20.glUseProgram(this.programId);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, i4);
                GLES20.glUniform1i(this.hEA, 0);
                floatBuffer.position(0);
                GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer) floatBuffer);
                GLES20.glEnableVertexAttribArray(this.hEy);
                floatBuffer2.position(0);
                GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer) floatBuffer2);
                GLES20.glEnableVertexAttribArray(this.hEz);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.hEy);
                GLES20.glDisableVertexAttribArray(this.hEz);
                GLES20.glBindTexture(36197, 0);
                GLES20.glBindFramebuffer(36160, 0);
                jL(i5, dVar.igv);
            } else {
                jL(i5, i4);
            }
            d dVar2 = this.HmH;
            if (dVar2 != null) {
                if (!(i3 == dVar2.hDo && i2 == dVar2.hDn)) {
                    Log.i(d.TAG, "updateTextureSize:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                }
                dVar2.hDn = i2;
                dVar2.hDo = i3;
                if (dVar2.hiH != null) {
                    com.tencent.mm.plugin.xlabeffect.b bVar = dVar2.hiH;
                    if (bVar == null) {
                        p.hyc();
                    }
                    bVar.setSize(i2, i3);
                }
                if (i6 == 0) {
                    dVar2.hDl = dVar.igv;
                } else {
                    dVar2.hDl = i4;
                }
                long currentTicks = Util.currentTicks();
                try {
                    com.tencent.mm.plugin.xlabeffect.b bVar2 = dVar2.hiH;
                    if (bVar2 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.xlabeffect.b.a(bVar2, dVar2.hDl);
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glBindTexture(3553, 0);
                    com.tencent.mm.media.g.d dVar3 = dVar2.hDm;
                    if (dVar3 == null) {
                        p.hyc();
                    }
                    dVar3.a(dVar2.hDn, dVar2.hDo, NativeBitmapStruct.GLFormat.GL_RGBA, null, 9729, 10497);
                    GLES20.glViewport(0, 0, dVar2.hDn, dVar2.hDo);
                    com.tencent.mm.plugin.xlabeffect.b bVar3 = dVar2.hiH;
                    if (bVar3 == null) {
                        p.hyc();
                    }
                    int i8 = dVar2.hDl;
                    com.tencent.mm.media.g.d dVar4 = dVar2.hDm;
                    if (dVar4 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.xlabeffect.b.a(bVar3, i8, dVar4.igv, false, 8);
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glBindTexture(3553, 0);
                } catch (Exception e2) {
                    Log.printErrStackTrace(d.TAG, e2, "filterProcess error", new Object[0]);
                }
                Log.d(d.TAG, "filterProcess: cost %s", Long.valueOf(Util.ticksToNow(currentTicks)));
            }
            if (this.Hmt) {
                com.tencent.mm.plugin.voip.video.render.a aVar = this.Hms;
                if (aVar != null) {
                    com.tencent.mm.media.g.d dVar5 = this.hEv;
                    Integer valueOf = dVar5 != null ? Integer.valueOf(dVar5.igv) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    aVar.Gxi = valueOf.intValue();
                    aVar.jj(i2, i3);
                    aVar.requestRender();
                }
            } else {
                e eVar = this.hEx;
                if (eVar != null) {
                    eVar.qx(i7);
                    eVar.iju = z;
                    com.tencent.mm.media.g.d dVar6 = this.hEv;
                    Integer valueOf2 = dVar6 != null ? Integer.valueOf(dVar6.igv) : null;
                    if (valueOf2 == null) {
                        p.hyc();
                    }
                    eVar.hDl = valueOf2.intValue();
                    eVar.cZ(i2, i3);
                    eVar.cY(i3, i2);
                    eVar.dc(i3, i2);
                    eVar.ijM = true;
                    eVar.aED();
                }
            }
            com.tencent.mm.media.g.d dVar7 = this.hEv;
            AppMethodBeat.o(236181);
            return dVar7;
        }
        AppMethodBeat.o(236181);
        return dVar;
    }
}
