package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a extends b {
    private final String TAG = "Finder.FinderCameraContainerProcess";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(RecordConfigProvider recordConfigProvider, CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView) {
        super(recordConfigProvider, cameraPreviewGLSurfaceView);
        p.h(recordConfigProvider, "configProvider");
        p.h(cameraPreviewGLSurfaceView, "previewPlugin");
        AppMethodBeat.i(167999);
        c cVar = c.vCb;
        if (c.drX()) {
            VideoTransPara videoTransPara = super.getVideoTransPara();
            c cVar2 = c.vCb;
            videoTransPara.videoBitrate = c.drY();
        }
        AppMethodBeat.o(167999);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a, com.tencent.mm.plugin.recordvideo.b.b
    public final boolean aQy() {
        boolean z = false;
        AppMethodBeat.i(178467);
        if (aQw()) {
            Log.i(this.TAG, "useDaemonRecorder useCpuCrop false");
            com.tencent.mm.plugin.recordvideo.e.b bVar = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tG(false);
            AppMethodBeat.o(178467);
        } else {
            c cVar = c.vCb;
            if (c.drX() && this.BMN.aQl()) {
                z = true;
            }
            String str = this.TAG;
            StringBuilder append = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(z).append(", FinderConfig.USE_DAEMON_RECORD:");
            c cVar2 = c.vCb;
            Log.i(str, append.append(c.drX()).toString());
            com.tencent.mm.plugin.recordvideo.e.b bVar2 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tG(z);
            AppMethodBeat.o(178467);
        }
        return z;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a, com.tencent.mm.plugin.recordvideo.b.b
    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(261497);
        VideoTransPara videoTransPara = super.getVideoTransPara();
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_record_max_size, 1920);
        if (videoTransPara.width > a2 || videoTransPara.height > a2) {
            Log.i(this.TAG, "getVideoTransPara, size to large, originWidth:" + videoTransPara.width + ", originHeight:" + videoTransPara.height + ", maxSize:" + a2);
            float f2 = ((float) videoTransPara.height) / ((float) videoTransPara.width);
            if (videoTransPara.width > videoTransPara.height) {
                videoTransPara.height = (int) (f2 * ((float) a2));
                videoTransPara.width = a2;
            } else {
                videoTransPara.width = (int) (((float) a2) / f2);
                videoTransPara.height = a2;
            }
            videoTransPara.width = d.QH(videoTransPara.width);
            videoTransPara.height = d.QH(videoTransPara.height);
            Log.i(this.TAG, "getVideoTransPara, do size crop, width:" + videoTransPara.width + ", height:" + videoTransPara.height + ", maxSize:" + a2);
        }
        AppMethodBeat.o(261497);
        return videoTransPara;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.video.a$a  reason: collision with other inner class name */
    public static final class C1320a implements com.tencent.mm.media.widget.camerarecordview.b.a {
        final /* synthetic */ a wbh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1320a(a aVar) {
            this.wbh = aVar;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final int aQm() {
            AppMethodBeat.i(253860);
            if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
                AppMethodBeat.o(253860);
                return 1;
            } else if (com.tencent.mm.plugin.recordvideo.b.g.isInit()) {
                com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
                int eJz = com.tencent.mm.plugin.recordvideo.b.g.eJz();
                AppMethodBeat.o(253860);
                return eJz;
            } else {
                int i2 = this.wbh.wdm.BOi;
                AppMethodBeat.o(253860);
                return i2;
            }
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String getFilePath() {
            AppMethodBeat.i(253861);
            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            if (!s.YS(com.tencent.mm.plugin.recordvideo.e.c.eMJ())) {
                s.boN(com.tencent.mm.plugin.recordvideo.e.c.eMJ());
            }
            StringBuilder sb = new StringBuilder();
            p.g(o.bhi(), "SubCoreVideo.getCore()");
            String sb2 = sb.append(o.bhr()).append(FilePathGenerator.ANDROID_DIR_SEP).append(System.currentTimeMillis()).toString();
            AppMethodBeat.o(253861);
            return sb2;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String aQn() {
            return "";
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a, com.tencent.mm.plugin.recordvideo.b.b
    public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig() {
        AppMethodBeat.i(253862);
        C1320a aVar = new C1320a(this);
        AppMethodBeat.o(253862);
        return aVar;
    }
}
