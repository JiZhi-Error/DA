package com.tencent.mm.plugin.recordvideo.b;

import android.content.Context;
import android.opengl.EGLContext;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ar;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020*H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010+H\u0016J\n\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020.H\u0016J\b\u00102\u001a\u00020!H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0012H\u0016J\b\u00106\u001a\u00020\u0012H\u0016J\b\u00107\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "daemonChecker", "Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "getDaemonChecker", "()Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "setDaemonChecker", "(Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;)V", "mute", "", "getMute", "()Z", "setMute", "(Z)V", "needEffect", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "previewRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "getPreviewRenderer", "()Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "recorderRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "initCameraConfig", "", "isMute", "useCpuCrop", "useDaemonRecorder", "Companion", "plugin-recordvideo_release"})
public class b implements com.tencent.mm.media.widget.camerarecordview.d.a {
    public static final a BMR = new a((byte) 0);
    private VideoTransPara BMK;
    protected com.tencent.mm.media.widget.camerarecordview.a.a BMN;
    private final boolean BMO;
    private final com.tencent.mm.plugin.recordvideo.c.b BMP;
    private final com.tencent.mm.plugin.recordvideo.c.a BMQ;
    public boolean isb;
    private CameraPreviewGLSurfaceView wcV;
    public RecordConfigProvider wdm;

    static {
        AppMethodBeat.i(75363);
        AppMethodBeat.o(75363);
    }

    public b(RecordConfigProvider recordConfigProvider, CameraPreviewGLSurfaceView cameraPreviewGLSurfaceView) {
        p.h(recordConfigProvider, "configProvider");
        p.h(cameraPreviewGLSurfaceView, "previewPlugin");
        AppMethodBeat.i(75362);
        this.wdm = recordConfigProvider;
        this.wcV = cameraPreviewGLSurfaceView;
        Context context = this.wcV.getContext();
        p.g(context, "previewPlugin.context");
        this.BMN = new com.tencent.mm.media.widget.camerarecordview.a.a(context);
        c cVar = c.Cic;
        RecordConfigProvider recordConfigProvider2 = this.wdm;
        p.h(recordConfigProvider2, "configProvider");
        if (TextUtils.isEmpty(recordConfigProvider2.BOC)) {
            recordConfigProvider2.BOC = c.eMK();
        }
        if (TextUtils.isEmpty(recordConfigProvider2.BOB)) {
            recordConfigProvider2.BOB = c.eML();
        }
        if (TextUtils.isEmpty(recordConfigProvider2.BOz)) {
            recordConfigProvider2.BOz = c.eMI();
        }
        c.e(recordConfigProvider2);
        Object clone = this.wdm.BOm.clone();
        if (clone == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelcontrol.VideoTransPara");
            AppMethodBeat.o(75362);
            throw tVar;
        }
        this.BMK = (VideoTransPara) clone;
        if (g.isInit()) {
            g gVar = g.BNx;
            VideoTransPara eJy = g.eJy();
            if (eJy != null) {
                Object clone2 = eJy.clone();
                if (clone2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.modelcontrol.VideoTransPara");
                    AppMethodBeat.o(75362);
                    throw tVar2;
                }
                this.BMK = (VideoTransPara) clone2;
            }
        }
        if (this.wdm.BOj == 1) {
            if (!g.isInit()) {
                com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
                int displayHeight = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
                com.tencent.mm.plugin.recordvideo.model.a aVar2 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
                this.BMK.width = (com.tencent.mm.plugin.recordvideo.model.a.eJO() * this.BMK.height) / displayHeight;
                Log.i("MicroMsg.CameraContainerProcess", "SightRecordConfig init failed, fix videoPara");
            }
            com.tencent.mm.media.b.b bVar = com.tencent.mm.media.b.b.idz;
            if (!com.tencent.mm.media.b.b.aLP()) {
                if (this.wdm.scene == 2) {
                    float a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_record_multiple_kbps, 2.0f);
                    this.BMK.videoBitrate = (int) (((float) this.BMK.videoBitrate) * a2);
                    Log.i("MicroMsg.CameraContainerProcess", "final kbps: " + a2 + "  " + this.BMK.videoBitrate);
                } else if (this.wdm.scene == 1) {
                    float a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_record_multiple_kbps, 2.0f);
                    this.BMK.videoBitrate = (int) (((float) this.BMK.videoBitrate) * a3);
                    Log.i("MicroMsg.CameraContainerProcess", "final kbps: " + a3 + "  " + this.BMK.videoBitrate);
                } else {
                    this.BMK.videoBitrate = 8000000;
                    Log.i("MicroMsg.CameraContainerProcess", "final kbps: $2  " + this.BMK.videoBitrate);
                }
            }
        }
        this.BMO = this.wdm.BOJ.BOM || this.wdm.BOJ.BON;
        if (this.BMO) {
            this.BMP = new com.tencent.mm.plugin.recordvideo.c.b();
            this.BMQ = new com.tencent.mm.plugin.recordvideo.c.a();
            this.BMP.BXt = new m<Integer, Integer, x>(this) {
                /* class com.tencent.mm.plugin.recordvideo.b.b.AnonymousClass1 */
                final /* synthetic */ b BMS;

                {
                    this.BMS = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Integer num2) {
                    AppMethodBeat.i(182842);
                    this.BMS.BMQ.hX(num.intValue(), num2.intValue());
                    x xVar = x.SXb;
                    AppMethodBeat.o(182842);
                    return xVar;
                }
            };
        } else {
            this.BMP = null;
            this.BMQ = null;
        }
        Log.i("MicroMsg.CameraContainerProcess", "init CameraContainerProcess, scene: " + this.wdm.scene + "   " + this.BMK);
        AppMethodBeat.o(75362);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQx() {
        return false;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(75355);
        if (g.isInit()) {
            g gVar = g.BNx;
            VideoTransPara eJy = g.eJy();
            if (!(eJy == null || (eJy.width == this.BMK.width && eJy.height == this.BMK.height))) {
                this.BMK.width = eJy.width;
                this.BMK.height = eJy.height;
            }
        }
        VideoTransPara videoTransPara = this.BMK;
        AppMethodBeat.o(75355);
        return videoTransPara;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean aQw() {
        Boolean bool;
        AppMethodBeat.i(75356);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_LOCAL_SIGHT_PREVIEW_CROP_INT_SYNC, (Object) -1);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(75356);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        Log.i("MicroMsg.CameraContainerProcess", "cuttype : ".concat(String.valueOf(intValue)));
        if (intValue == 1) {
            com.tencent.mm.plugin.recordvideo.e.b bVar = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tF(false);
            AppMethodBeat.o(75356);
            return false;
        } else if (intValue == 2) {
            com.tencent.mm.plugin.recordvideo.e.b bVar2 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tF(true);
            AppMethodBeat.o(75356);
            return true;
        } else if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
            com.tencent.mm.plugin.recordvideo.e.b bVar3 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tF(true);
            AppMethodBeat.o(75356);
            return true;
        } else {
            if (g.isInit()) {
                g gVar = g.BNx;
                bool = Boolean.valueOf(g.eJB());
            } else {
                bool = this.wdm.BOh;
            }
            com.tencent.mm.plugin.recordvideo.e.b bVar4 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            p.g(bool, "cpuCrop");
            com.tencent.mm.plugin.recordvideo.e.b.tF(bool.booleanValue());
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(75356);
            return booleanValue;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public int getResolutionLimit() {
        AppMethodBeat.i(75357);
        if (g.isInit()) {
            g gVar = g.BNx;
            int eJA = g.eJA();
            AppMethodBeat.o(75357);
            return eJA;
        }
        int i2 = this.wdm.ilT;
        AppMethodBeat.o(75357);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/recordvideo/config/CameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.b.b$b  reason: collision with other inner class name */
    public static final class C1639b implements com.tencent.mm.media.widget.camerarecordview.b.a {
        final /* synthetic */ b BMS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1639b(b bVar) {
            this.BMS = bVar;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final int aQm() {
            AppMethodBeat.i(75352);
            if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false)) {
                AppMethodBeat.o(75352);
                return 1;
            } else if (g.isInit()) {
                g gVar = g.BNx;
                int eJz = g.eJz();
                AppMethodBeat.o(75352);
                return eJz;
            } else {
                int i2 = this.BMS.wdm.BOi;
                AppMethodBeat.o(75352);
                return i2;
            }
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String getFilePath() {
            AppMethodBeat.i(75353);
            String str = this.BMS.wdm.BOz;
            p.g(str, "configProvider.inputVideoPath");
            AppMethodBeat.o(75353);
            return str;
        }

        @Override // com.tencent.mm.media.widget.camerarecordview.b.a
        public final String aQn() {
            AppMethodBeat.i(75354);
            String str = this.BMS.wdm.thumbPath;
            p.g(str, "configProvider.thumbPath");
            AppMethodBeat.o(75354);
            return str;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig() {
        AppMethodBeat.i(75358);
        C1639b bVar = new C1639b(this);
        AppMethodBeat.o(75358);
        return bVar;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public final boolean Zx() {
        return this.isb;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public boolean aQy() {
        boolean z = true;
        AppMethodBeat.i(75361);
        if (aQw()) {
            Log.i("MicroMsg.CameraContainerProcess", "useDaemonRecorder false");
            com.tencent.mm.plugin.recordvideo.e.b bVar = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tG(false);
            AppMethodBeat.o(75361);
            return false;
        } else if (this.wdm.scene == 2 || this.wdm.scene == 1) {
            com.tencent.mm.media.widget.camerarecordview.a.a aVar = this.BMN;
            Log.i("MicroMsg.DaemonChecker", "info: enable:[" + aVar.enable + "] ramConfig:[" + aVar.ipX + "] blackModelList:[" + aVar.ipY + ']');
            if (!aVar.enable || !aVar.aQl()) {
                z = false;
            }
            Log.i("MicroMsg.CameraContainerProcess", "useDaemonRecorder ".concat(String.valueOf(z)));
            com.tencent.mm.plugin.recordvideo.e.b bVar2 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tG(z);
            AppMethodBeat.o(75361);
            return z;
        } else {
            com.tencent.mm.plugin.recordvideo.e.b bVar3 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            com.tencent.mm.plugin.recordvideo.e.b.tG(false);
            Log.i("MicroMsg.CameraContainerProcess", "scene " + this.wdm.scene + " not use DaemonRecorder");
            AppMethodBeat.o(75361);
            return false;
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public com.tencent.mm.media.j.a getPreviewRenderer() {
        if (this.BMO) {
            return this.BMP;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public com.tencent.mm.media.j.a getRecordRenderer() {
        if (this.BMO) {
            return this.BMQ;
        }
        return null;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public com.tencent.mm.media.widget.c.b getRecorder() {
        d dVar = null;
        AppMethodBeat.i(182843);
        if (this.BMO) {
            VideoTransPara videoTransPara = getVideoTransPara();
            com.tencent.mm.plugin.recordvideo.c.a aVar = this.BMQ;
            EGLContext eGLContext = getCameraPreviewView().getEGLContext();
            if (eGLContext == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.recordvideo.c.b bVar = this.BMP;
            if (bVar != null) {
                dVar = bVar.rwP;
            }
            if (dVar == null) {
                p.hyc();
            }
            com.tencent.mm.media.widget.c.c cVar = new com.tencent.mm.media.widget.c.c(videoTransPara, aVar, eGLContext, dVar.igv);
            AppMethodBeat.o(182843);
            return cVar;
        }
        AppMethodBeat.o(182843);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public com.tencent.mm.media.widget.camerarecordview.preview.e getCameraPreviewView() {
        return this.wcV;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public Context getContext() {
        AppMethodBeat.i(75359);
        Context context = this.wcV.getContext();
        p.g(context, "previewPlugin.context");
        AppMethodBeat.o(75359);
        return context;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.a
    public VideoTransPara getDaemonVideoTransPara() {
        AppMethodBeat.i(75360);
        VideoTransPara videoTransPara = this.wdm.BOm;
        p.g(videoTransPara, "configProvider.videoParam");
        AppMethodBeat.o(75360);
        return videoTransPara;
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.d.b
    public int getRecordScene() {
        return this.wdm.scene;
    }
}
