package com.tencent.mm.plugin.emojicapture.e;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Matrix;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002,-B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", JsApiStartRecordVoice.NAME, "stopCallBack", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "isBackCamera", JsApiStopRecordVoice.NAME, "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a implements a.AbstractC0967a {
    public static final C0970a rqK = new C0970a((byte) 0);
    private Context context;
    private final com.tencent.mm.remoteservice.d gVN = new com.tencent.mm.remoteservice.d(this.context);
    private long qPl;
    private boolean rqA;
    private boolean rqB;
    private String rqC;
    private final com.tencent.mm.plugin.emojicapture.model.a.b rqD = new com.tencent.mm.plugin.emojicapture.model.a.b();
    private VoiceInputProxy rqE = new VoiceInputProxy(new f(this), this.gVN);
    private final MTimerHandler rqF = new MTimerHandler(new e(this), true);
    private a.b rqG;
    private final VideoTransPara rqH;
    private EmojiCaptureUI.b rqI;
    private final EmojiCaptureReporter rqJ;
    private b rqz = b.RECORD_STATE_IDLE;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "", "(Ljava/lang/String;I)V", "RECORD_STATE_IDLE", "RECORD_STATE_PREVIEW", "RECORD_STATE_PREVIEW_PAUSED", "RECORD_STATE_STARTED", "RECORD_STATE_STOP", "plugin-emojicapture_release"})
    public enum b {
        RECORD_STATE_IDLE,
        RECORD_STATE_PREVIEW,
        RECORD_STATE_PREVIEW_PAUSED,
        RECORD_STATE_STARTED,
        RECORD_STATE_STOP;

        static {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL);
        AppMethodBeat.o(TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL);
    }

    public a(Context context2, a.b bVar, VideoTransPara videoTransPara, EmojiCaptureUI.b bVar2, EmojiCaptureReporter emojiCaptureReporter) {
        p.h(context2, "context");
        p.h(bVar, "view");
        p.h(videoTransPara, "videoPara");
        p.h(bVar2, "uiNavigation");
        p.h(emojiCaptureReporter, "reporter");
        AppMethodBeat.i(TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE);
        this.context = context2;
        this.rqG = bVar;
        this.rqH = videoTransPara;
        this.rqI = bVar2;
        this.rqJ = emojiCaptureReporter;
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
        this.gVN.connect(AnonymousClass1.rqL);
        VideoTransPara videoTransPara2 = this.rqH;
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        videoTransPara2.width = com.tencent.mm.plugin.emojicapture.model.d.rov;
        VideoTransPara videoTransPara3 = this.rqH;
        d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        videoTransPara3.height = com.tencent.mm.plugin.emojicapture.model.d.rov;
        this.rqH.videoBitrate = GmsVersion.VERSION_LONGHORN;
        k.zuy.videoBitrate = this.rqH.videoBitrate;
        k.zuy.irT = this.rqH;
        this.rqD.scene = this.rqJ.scene;
        this.rqD.hdz = this.rqJ.hdz;
        AppMethodBeat.o(TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$a  reason: collision with other inner class name */
    public static final class C0970a {
        private C0970a() {
        }

        public /* synthetic */ C0970a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
    public static final class f implements VoiceInputProxy.b {
        final /* synthetic */ a rqS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(a aVar) {
            this.rqS = aVar;
        }

        @Override // com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b
        public final void onRes(String str) {
            AppMethodBeat.i(323);
            Log.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(str)));
            this.rqS.rqC = str;
            AppMethodBeat.o(323);
        }

        @Override // com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b
        public final void biz() {
            AppMethodBeat.i(aq.CTRL_INDEX);
            Log.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
            if (!this.rqS.rqB) {
                this.rqS.rqI.ano(this.rqS.rqC);
            }
            this.rqS.rqB = true;
            AppMethodBeat.o(aq.CTRL_INDEX);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class e implements MTimerHandler.CallBack {
        final /* synthetic */ a rqS;

        e(a aVar) {
            this.rqS = aVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            int i2;
            boolean z = false;
            AppMethodBeat.i(TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
            if (this.rqS.rqE != null) {
                VoiceInputProxy voiceInputProxy = this.rqS.rqE;
                i2 = voiceInputProxy != null ? voiceInputProxy.getMaxAmplitudeRate() : 0;
            } else {
                i2 = 0;
            }
            a.b bVar = this.rqS.rqG;
            if (i2 > 10) {
                z = true;
            }
            bVar.lD(z);
            AppMethodBeat.o(TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final void sA() {
        AppMethodBeat.i(TbsListener.ErrorCode.THROWABLE_INITX5CORE);
        Log.i("MicroMsg.CapturePresenter", "pauseCapture " + this.rqB);
        if (this.rqC != null || this.rqB) {
            this.rqI.ano(this.rqC);
            AppMethodBeat.o(TbsListener.ErrorCode.THROWABLE_INITX5CORE);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new c(this), 1500);
        AppMethodBeat.o(TbsListener.ErrorCode.THROWABLE_INITX5CORE);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ a rqS;

        c(a aVar) {
            this.rqS = aVar;
        }

        public final void run() {
            AppMethodBeat.i(320);
            Log.i("MicroMsg.CapturePresenter", "voice finish called force");
            if (!this.rqS.rqB) {
                this.rqS.rqI.ano(this.rqS.rqC);
            }
            this.rqS.rqB = true;
            AppMethodBeat.o(320);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final void bFT() {
        AppMethodBeat.i(TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL);
        Log.i("MicroMsg.CapturePresenter", "start record " + this.rqz);
        this.rqD.setVideoPath("");
        this.rqD.HA("");
        this.rqC = this.rqG.getDecoration().getText();
        this.rqG.getDecoration();
        String str = this.rqC;
        this.rqA = str == null || str.length() == 0;
        Log.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.rqA);
        if (this.rqA && (!p.j("NON_NETWORK", NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())))) {
            VoiceInputProxy voiceInputProxy = this.rqE;
            if (voiceInputProxy != null) {
                voiceInputProxy.start();
            }
            this.rqF.startTimer(50);
        }
        this.rqB = false;
        this.rqz = b.RECORD_STATE_STARTED;
        this.qPl = Util.currentTicks();
        this.rqJ.rnG = System.currentTimeMillis();
        this.rqJ.bFT();
        AppMethodBeat.o(TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final boolean ZZ() {
        AppMethodBeat.i(TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
        Log.i("MicroMsg.CapturePresenter", "stop record " + this.rqz);
        if (this.rqz == b.RECORD_STATE_STOP) {
            AppMethodBeat.o(TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
            return true;
        }
        this.rqz = b.RECORD_STATE_STOP;
        if (Util.ticksToNow(this.qPl) < 600) {
            VoiceInputProxy voiceInputProxy = this.rqE;
            if (voiceInputProxy != null) {
                voiceInputProxy.stop(true);
            }
            this.rqz = b.RECORD_STATE_PREVIEW;
            AppMethodBeat.o(TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
            return false;
        }
        EmojiCaptureUI.b bVar = this.rqI;
        Context context2 = this.context;
        String string = this.context.getString(R.string.ekc);
        p.g(string, "context.getString(R.string.loading_tips)");
        bVar.a(context2, string, true, new d(this));
        CaptureDecoration decoration = this.rqG.getDecoration();
        decoration.rtj.pause();
        decoration.rtk.pause();
        if (this.rqA) {
            VoiceInputProxy voiceInputProxy2 = this.rqE;
            if (voiceInputProxy2 != null) {
                voiceInputProxy2.stop(true);
            }
            this.rqF.stopTimer();
        }
        this.rqJ.rnH = System.currentTimeMillis();
        this.rqJ.gLd = this.rqJ.rnH - this.rqJ.rnG;
        EmojiCaptureReporter.a(4, this.rqJ.hdz, 0, this.rqJ.gLd, 0, 0, 0, 0, this.rqJ.scene);
        AppMethodBeat.o(TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ a rqS;

        d(a aVar) {
            this.rqS = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
            this.rqS.rqI.cJC();
            AppMethodBeat.o(TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar, boolean z) {
        com.tencent.mm.sticker.e eVar;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
        p.h(bVar, "info");
        Log.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
        this.rqD.setVideoPath(bVar.iqd);
        this.rqD.HA(bVar.iqe);
        this.rqD.roM = this.rqC;
        this.rqD.roN = this.rqG.getDecoration().getTextColor();
        com.tencent.mm.plugin.emojicapture.model.a.b bVar2 = this.rqD;
        com.tencent.mm.sticker.f fVar = this.rqD.roL;
        if (fVar != null) {
            eVar = fVar.NNt;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        bVar2.roO = z2;
        com.tencent.mm.plugin.emojicapture.model.a.b bVar3 = this.rqD;
        if (!this.rqD.roO || !z) {
            z3 = true;
        }
        bVar3.rnN = z3;
        this.rqD.roP = this.rqG.getDecoration().getAttachEmoji();
        com.tencent.mm.plugin.emojicapture.model.a.b bVar4 = this.rqD;
        Matrix attachEmojiMatrix = this.rqG.getDecoration().getAttachEmojiMatrix();
        p.h(attachEmojiMatrix, "<set-?>");
        bVar4.roQ = attachEmojiMatrix;
        this.rqI.b(this.rqD);
        AppMethodBeat.o(TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final void exit() {
        AppMethodBeat.i(TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
        EmojiCaptureUI.b.a.a(this.rqI, false);
        AppMethodBeat.o(TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final void destroy() {
        AppMethodBeat.i(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
        this.gVN.release();
        VoiceInputProxy voiceInputProxy = this.rqE;
        if (voiceInputProxy != null) {
            voiceInputProxy.setUiCallback(null);
            AppMethodBeat.o(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
            return;
        }
        AppMethodBeat.o(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.a.AbstractC0967a
    public final void a(com.tencent.mm.sticker.f fVar) {
        AppMethodBeat.i(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
        Log.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(fVar)));
        this.rqD.roL = fVar;
        this.rqG.a(fVar);
        AppMethodBeat.o(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE);
    }
}
