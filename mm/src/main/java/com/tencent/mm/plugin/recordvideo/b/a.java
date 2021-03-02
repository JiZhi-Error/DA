package com.tencent.mm.plugin.recordvideo.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "videoPath", "", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;Ljava/lang/String;)V", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getRecordVideoTransPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setRecordVideoTransPara", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getRecordScene", "", "getResolutionLimit", "getVideoTransPara", "initCameraConfig", "", "useCpuCrop", "", "Companion", "plugin-recordvideo_release"})
public final class a implements com.tencent.mm.media.widget.camerarecordview.d.a {
    public static final C1637a BML = new C1637a((byte) 0);
    public VideoTransPara BMK;
    public String videoPath;
    private CameraPreviewGLSurfaceView wcV;

    static {
        AppMethodBeat.i(75350);
        AppMethodBeat.o(75350);
    }

    public a(VideoTransPara videoTransPara, CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView, String str) {
        p.h(videoTransPara, "recordVideoTransPara");
        p.h(cameraPreviewGLSurfaceView, "previewPlugin");
        p.h(str, "videoPath");
        AppMethodBeat.i(75349);
        this.BMK = videoTransPara;
        this.wcV = cameraPreviewGLSurfaceView;
        this.videoPath = str;
        AppMethodBeat.o(75349);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean Zx() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQx() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQy() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.j.a getPreviewRenderer() {
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.j.a getRecordRenderer() {
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.c.b getRecorder() {
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getRecordScene() {
        return 9;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(75345);
        if (g.isInit()) {
            g gVar = g.BNx;
            VideoTransPara eJy = g.eJy();
            if (!(eJy == null || (eJy.width == this.BMK.width && eJy.height == this.BMK.height))) {
                this.BMK.width = eJy.width;
                this.BMK.height = eJy.height;
            }
        }
        VideoTransPara videoTransPara = this.BMK;
        AppMethodBeat.o(75345);
        return videoTransPara;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQw() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public final int getResolutionLimit() {
        AppMethodBeat.i(75346);
        if (g.isInit()) {
            g gVar = g.BNx;
            int eJA = g.eJA();
            AppMethodBeat.o(75346);
            return eJA;
        }
        int i2 = this.BMK.width;
        AppMethodBeat.o(75346);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
    public static final class b implements com.tencent.mm.media.widget.camerarecordview.b.a {
        final /* synthetic */ a BMM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.BMM = aVar;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final int aQm() {
            AppMethodBeat.i(75343);
            if (g.isInit()) {
                g gVar = g.BNx;
                int eJz = g.eJz();
                AppMethodBeat.o(75343);
                return eJz;
            }
            AppMethodBeat.o(75343);
            return 2;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String getFilePath() {
            return this.BMM.videoPath;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String aQn() {
            AppMethodBeat.i(75344);
            String str = ((String) n.b(this.BMM.videoPath, new String[]{"."}).get(0)) + "_thumb.jpg";
            AppMethodBeat.o(75344);
            return str;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig() {
        AppMethodBeat.i(75347);
        b bVar = new b(this);
        AppMethodBeat.o(75347);
        return bVar;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final e getCameraPreviewView() {
        return this.wcV;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final Context getContext() {
        AppMethodBeat.i(75348);
        Context context = this.wcV.getContext();
        p.g(context, "previewPlugin.context");
        AppMethodBeat.o(75348);
        return context;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.b.a$a  reason: collision with other inner class name */
    public static final class C1637a {
        private C1637a() {
        }

        public /* synthetic */ C1637a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final VideoTransPara getDaemonVideoTransPara() {
        AppMethodBeat.i(75351);
        VideoTransPara videoTransPara = getVideoTransPara();
        AppMethodBeat.o(75351);
        return videoTransPara;
    }
}
