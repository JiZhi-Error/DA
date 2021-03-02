package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.media.widget.a.d;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J@\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class c {
    private static com.tencent.mm.media.j.a ihs;
    public static final c ipU = new c();

    static {
        AppMethodBeat.i(94272);
        AppMethodBeat.o(94272);
    }

    private c() {
    }

    public static void aQk() {
        ihs = null;
    }

    public static com.tencent.mm.media.j.a getRenderer() {
        return ihs;
    }

    public static com.tencent.mm.media.widget.c.b a(int i2, VideoTransPara videoTransPara, d dVar, EGLContext eGLContext, e eVar, boolean z, com.tencent.mm.media.j.a aVar) {
        int i3;
        AppMethodBeat.i(94270);
        p.h(videoTransPara, "videoTransPara");
        p.h(dVar, "camera");
        p.h(eGLContext, "eglContext");
        p.h(eVar, "view");
        if (i2 == 2) {
            if (aVar == null) {
                ihs = new b(z);
            } else {
                ihs = aVar;
            }
            com.tencent.mm.media.j.a aVar2 = ihs;
            if (!(aVar2 == null || dVar.aPr() == null)) {
                aVar2.cZ(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
                aVar2.qx(com.tencent.mm.media.widget.a.b.aPk());
                aVar2.eD(com.tencent.mm.media.widget.a.b.aPn());
            }
            com.tencent.mm.media.j.a aVar3 = ihs;
            com.tencent.mm.media.g.d previewTexture = eVar.getPreviewTexture();
            if (previewTexture != null) {
                i3 = previewTexture.igv;
            } else {
                i3 = -1;
            }
            com.tencent.mm.media.widget.c.c cVar = new com.tencent.mm.media.widget.c.c(videoTransPara, aVar3, eGLContext, i3);
            AppMethodBeat.o(94270);
            return cVar;
        }
        if (aVar == null) {
            ihs = new C0434c();
        } else {
            ihs = aVar;
        }
        com.tencent.mm.media.j.a aVar4 = ihs;
        if (!(aVar4 == null || dVar.aPr() == null)) {
            Point aPo = com.tencent.mm.media.widget.a.b.aPo();
            aVar4.cZ(aPo.x, aPo.y);
            aVar4.qx(com.tencent.mm.media.widget.a.b.aPk());
            aVar4.eD(com.tencent.mm.media.widget.a.b.aPn());
        }
        com.tencent.mm.media.widget.c.d dVar2 = new com.tencent.mm.media.widget.c.d(videoTransPara, ihs);
        dVar.a(dVar2.getFrameDataCallback());
        com.tencent.mm.media.widget.c.d dVar3 = dVar2;
        AppMethodBeat.o(94270);
        return dVar3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, hxF = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class b extends com.tencent.mm.media.j.d {
        final /* synthetic */ boolean ipV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z) {
            super(1);
            this.ipV = z;
        }

        @Override // com.tencent.mm.media.j.a
        public final com.tencent.mm.media.j.b.a aEC() {
            AppMethodBeat.i(94268);
            if (this.ipV) {
                f fVar = new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
                AppMethodBeat.o(94268);
                return fVar;
            }
            com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
            AppMethodBeat.o(94268);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, hxF = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.c$c  reason: collision with other inner class name */
    public static final class C0434c extends com.tencent.mm.media.j.a {
        C0434c() {
            super(3, 0, 0, 0, 62);
        }

        @Override // com.tencent.mm.media.j.a
        public final com.tencent.mm.media.j.b.a aEC() {
            AppMethodBeat.i(94269);
            f fVar = new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
            AppMethodBeat.o(94269);
            return fVar;
        }
    }

    public static com.tencent.mm.media.widget.c.b a(int i2, VideoTransPara videoTransPara, d dVar, com.tencent.mm.media.j.a aVar) {
        AppMethodBeat.i(94271);
        p.h(videoTransPara, "videoPara");
        p.h(dVar, "camera");
        if (i2 == 2) {
            if (aVar == null) {
                ihs = new a();
            } else {
                ihs = aVar;
            }
            com.tencent.mm.media.j.a aVar2 = ihs;
            if (!(aVar2 == null || dVar.aPr() == null)) {
                Point aPo = com.tencent.mm.media.widget.a.b.aPo();
                aVar2.cZ(aPo.x, aPo.y);
                aVar2.qx(com.tencent.mm.media.widget.a.b.aPk());
                aVar2.eD(com.tencent.mm.media.widget.a.b.aPn());
            }
            com.tencent.mm.media.widget.c.c cVar = new com.tencent.mm.media.widget.c.c(videoTransPara, ihs);
            dVar.a(cVar.getFrameDataCallback());
            com.tencent.mm.media.widget.c.c cVar2 = cVar;
            AppMethodBeat.o(94271);
            return cVar2;
        }
        com.tencent.mm.media.widget.c.e eVar = new com.tencent.mm.media.widget.c.e(videoTransPara);
        if (dVar.aPr() != null) {
            eVar.setMirror(com.tencent.mm.media.widget.a.b.aPn());
        }
        dVar.a(eVar.getFrameDataCallback());
        com.tencent.mm.media.widget.c.e eVar2 = eVar;
        AppMethodBeat.o(94271);
        return eVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, hxF = {"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
    public static final class a extends com.tencent.mm.media.j.a {
        a() {
            super(1, 0, 0, 0, 62);
        }

        @Override // com.tencent.mm.media.j.a
        public final com.tencent.mm.media.j.b.a aEC() {
            AppMethodBeat.i(94267);
            f fVar = new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
            AppMethodBeat.o(94267);
            return fVar;
        }
    }
}
