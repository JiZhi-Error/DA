package com.tencent.mm.plugin.eggspring.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001SB\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J\"\u0010(\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0016J \u0010+\u001a\u00020,2\u0006\u0010&\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0016J\u001a\u0010-\u001a\u00020,2\b\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020\u0015H\u0016J6\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\rH\u0016J\"\u00104\u001a\u00020,2\u0006\u0010&\u001a\u00020\n2\u0006\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u000107H\u0016J,\u00108\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0016J\u001c\u0010;\u001a\u00020,2\b\u0010<\u001a\u0004\u0018\u00010\n2\b\u0010=\u001a\u0004\u0018\u00010\nH\u0016J*\u0010>\u001a\u00020,2\u0006\u0010&\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\b\u0010?\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010@\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J \u0010A\u001a\u00020,2\u0006\u0010&\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001aH\u0016J\u001c\u0010C\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010D\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010E\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010F\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010G\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010H\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010I\u001a\u00020,J\u0006\u0010J\u001a\u00020,J\"\u0010K\u001a\u00020,2\b\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0016J\u0006\u0010L\u001a\u00020,J\u0012\u0010M\u001a\u00020,2\b\u0010N\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010O\u001a\u00020,J \u0010P\u001a\u00020,2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010Q\u001a\u00020,2\u0006\u0010&\u001a\u00020\nH\u0016J\u0006\u0010R\u001a\u00020\u001aR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "videoView", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "url", "", "(Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "value", "", "mute", "setMute", "(Z)V", "playDuration", "", "playStartTime", "uiHandler", "Landroid/os/Handler;", "videoDuration", "getVideoDuration", "()J", "setVideoDuration", "(J)V", "videoMediaId", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "path", "isVideoDataAvailable", "offset", "length", "onDataAvailable", "", "onDownloadFinish", "isPlayNow", "onError", "sessionId", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onM3U8Ready", "p0", "p1", "onMoovReady", "svrflag", "onPrepared", "onProgress", "total", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "pause", "release", "requestVideoData", "resume", "setIEngineCallback", "callback", "start", "startHttpStream", "stop", "totalDuration", "Companion", "plugin-eggspring_release"})
public final class d implements h.a, com.tencent.mm.modelvideo.b, i.a, i.b {
    public static final a qWq = new a((byte) 0);
    private final Handler cPw = new Handler(Looper.getMainLooper());
    int count;
    private boolean isb = true;
    long pLQ;
    long playDuration;
    final SpringEggVideoView qVU;
    final c qVv;
    private b.a qWn;
    String qWo;
    long qWp;

    static {
        AppMethodBeat.i(194671);
        AppMethodBeat.o(194671);
    }

    public d(SpringEggVideoView springEggVideoView, c cVar, String str) {
        p.h(springEggVideoView, "videoView");
        p.h(cVar, "viewBinding");
        p.h(str, "url");
        AppMethodBeat.i(194670);
        this.qVU = springEggVideoView;
        this.qVv = cVar;
        this.qVU.setLoop(true);
        this.qVU.setIMMVideoViewCallback(this);
        this.qVU.setIMMDownloadFinish(this);
        this.qVU.setIOnlineVideoProxy(this);
        this.qVU.c(false, str, 0);
        this.qVU.setFilepath(PluginEggSpring.qUF + "MMVideo_" + str.hashCode() + ".mp4.temp");
        this.qVv.qVV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.eggspring.ui.d.AnonymousClass1 */
            final /* synthetic */ d qWr;

            {
                this.qWr = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(194646);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/VideoController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.a(this.qWr, !this.qWr.isb);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/VideoController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194646);
            }
        });
        AppMethodBeat.o(194670);
    }

    public static final /* synthetic */ void a(d dVar, boolean z) {
        AppMethodBeat.i(194672);
        dVar.setMute(z);
        AppMethodBeat.o(194672);
    }

    /* access modifiers changed from: package-private */
    public final void setMute(boolean z) {
        AppMethodBeat.i(194651);
        this.isb = z;
        this.qVU.setMute(z);
        this.qVv.qVV.setImageResource(z ? R.raw.icon_volume_off : R.raw.icon_volume_on);
        AppMethodBeat.o(194651);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(194652);
        Log.i("MicroMsg.VideoController", "onError!!! mediaId[%s] errorMsg[%s].", str2, str3);
        this.qVv.qVQ.setVisibility(0);
        this.qVU.setVisibility(8);
        this.qVv.qVV.setVisibility(8);
        this.playDuration += Util.milliSecondsToNow(this.qWp);
        this.qWp = 0;
        AppMethodBeat.o(194652);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        AppMethodBeat.i(194653);
        Log.i("MicroMsg.VideoController", "onPrepared!!! mediaId[%s].", str2);
        this.qWp = Util.nowMilliSecond();
        this.pLQ = ((long) this.qVU.getVideoDurationSec()) * 1000;
        AppMethodBeat.o(194653);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(194654);
        Log.i("MicroMsg.VideoController", "onVideoEnded!!! mediaId[%s].", str2);
        AppMethodBeat.o(194654);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(194655);
        Log.i("MicroMsg.VideoController", "onGetVideoSize!!! mediaId[%s].", str2);
        AppMethodBeat.o(194655);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
        AppMethodBeat.i(194656);
        Log.i("MicroMsg.VideoController", "onVideoPause!!! mediaId[%s].", str2);
        AppMethodBeat.o(194656);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(194657);
        Log.i("MicroMsg.VideoController", "onVideoPlay!!! mediaId[%s], duration[%s].", str2, Integer.valueOf(this.qVU.getVideoDurationSec()));
        this.count++;
        AppMethodBeat.o(194657);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        AppMethodBeat.i(194658);
        Log.i("MicroMsg.VideoController", "onVideoWaiting!!! mediaId[%s].", str2);
        AppMethodBeat.o(194658);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        AppMethodBeat.i(194659);
        Log.i("MicroMsg.VideoController", "onVideoWaitingEnd!!! mediaId[%s].", str2);
        AppMethodBeat.o(194659);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
        AppMethodBeat.i(194660);
        Log.i("MicroMsg.VideoController", "onVideoFirstFrameDraw!!! mediaId[%s].", str2);
        AppMethodBeat.o(194660);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.a
    public final void aO(String str, boolean z) {
        AppMethodBeat.i(194661);
        if (str != null) {
            String j2 = n.j(str, ".temp", "", false);
            if (!s.YS(j2) && n.nm(str, ".temp")) {
                s.nw(str, j2);
            }
            AppMethodBeat.o(194661);
            return;
        }
        AppMethodBeat.o(194661);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void p(String str, String str2, String str3) {
        AppMethodBeat.i(194662);
        p.h(str, "mediaId");
        p.h(str2, "path");
        p.h(str3, "url");
        this.qWo = str;
        if (s.YS(PluginEggSpring.qUF + "MMVideo_" + str3.hashCode() + ".mp4")) {
            a(str, 0, null);
            AppMethodBeat.o(194662);
            return;
        }
        com.tencent.mm.an.e bhk = o.bhk();
        h hVar = new h();
        hVar.field_mediaId = str;
        hVar.url = str3;
        hVar.gqU = 1;
        hVar.gqP = 5;
        hVar.concurrentCount = 3;
        hVar.field_fullpath = str2;
        hVar.gre = this;
        bhk.a(hVar, false);
        AppMethodBeat.o(194662);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void he(String str) {
        AppMethodBeat.i(194663);
        p.h(str, "mediaId");
        Log.w("MicroMsg.VideoController", "stop ".concat(String.valueOf(str)));
        String str2 = this.qWo;
        if (str2 != null) {
            if (p.j(str2, str)) {
                o.bhk().m(str, null);
            }
            AppMethodBeat.o(194663);
            return;
        }
        AppMethodBeat.o(194663);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void requestVideoData(String str, int i2, int i3) {
        AppMethodBeat.i(194664);
        String str2 = this.qWo;
        if (str2 != null) {
            if (p.j(str2, str)) {
                Log.w("MicroMsg.VideoController", "requestVideoData offset=" + i2 + ", length=" + i3);
                o.bhk();
                com.tencent.mm.an.e.r(str, i2, i3);
            }
            AppMethodBeat.o(194664);
            return;
        }
        AppMethodBeat.o(194664);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final boolean isVideoDataAvailable(String str, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(194665);
        Log.i("MicroMsg.VideoController", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", str, Integer.valueOf(i2), Integer.valueOf(i3));
        String str2 = this.qWo;
        if (str2 != null && p.j(str2, str)) {
            z = o.bhk().isVideoDataAvailable(str, i2, i3);
        }
        AppMethodBeat.o(194665);
        return z;
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void a(b.a aVar) {
        this.qWn = aVar;
    }

    @Override // com.tencent.mm.i.h.a
    public final void Ds(String str) {
    }

    @Override // com.tencent.mm.i.h.a
    public final void a(String str, long j2, long j3, String str2) {
        AppMethodBeat.i(194666);
        p.h(str, "mediaId");
        Log.i("MicroMsg.VideoController", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", str, Long.valueOf(j2), Long.valueOf(j3));
        if (!(this.qWn == null || this.qWo == null || !p.j(this.qWo, str))) {
            this.cPw.post(new RunnableC0955d(this, str, j2, j3, str2));
        }
        AppMethodBeat.o(194666);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.eggspring.ui.d$d  reason: collision with other inner class name */
    static final class RunnableC0955d implements Runnable {
        final /* synthetic */ d qWr;
        final /* synthetic */ String qWs;
        final /* synthetic */ long qWt;
        final /* synthetic */ long qWu;
        final /* synthetic */ String qWw;

        RunnableC0955d(d dVar, String str, long j2, long j3, String str2) {
            this.qWr = dVar;
            this.qWs = str;
            this.qWt = j2;
            this.qWu = j3;
            this.qWw = str2;
        }

        public final void run() {
            AppMethodBeat.i(194649);
            b.a aVar = this.qWr.qWn;
            if (aVar == null) {
                p.hyc();
            }
            aVar.AI(this.qWt);
            AppMethodBeat.o(194649);
        }
    }

    @Override // com.tencent.mm.i.h.a
    public final void onDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(194667);
        p.h(str, "mediaId");
        Log.i("MicroMsg.VideoController", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", str, Long.valueOf(j2), Long.valueOf(j3));
        if (!(this.qWn == null || this.qWo == null || !p.j(this.qWo, str))) {
            this.cPw.post(new b(this, str, j2, j3));
        }
        AppMethodBeat.o(194667);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ d qWr;
        final /* synthetic */ String qWs;
        final /* synthetic */ long qWt;
        final /* synthetic */ long qWu;

        b(d dVar, String str, long j2, long j3) {
            this.qWr = dVar;
            this.qWs = str;
            this.qWt = j2;
            this.qWu = j3;
        }

        public final void run() {
            AppMethodBeat.i(194647);
            b.a aVar = this.qWr.qWn;
            if (aVar == null) {
                p.hyc();
            }
            aVar.onDataAvailable(this.qWs, this.qWt, this.qWu);
            AppMethodBeat.o(194647);
        }
    }

    @Override // com.tencent.mm.i.h.a
    public final void i(String str, long j2, long j3) {
        AppMethodBeat.i(194668);
        p.h(str, "mediaId");
        Log.i("MicroMsg.VideoController", "onProgress!!! mediaId[%s] offset[%s] length[%s].", str, Long.valueOf(j2), Long.valueOf(j3));
        if (!(this.qWn == null || this.qWo == null || !p.j(this.qWo, str))) {
            this.cPw.post(new e(this, str, j2, j3));
        }
        AppMethodBeat.o(194668);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ d qWr;
        final /* synthetic */ String qWs;
        final /* synthetic */ long qWt;
        final /* synthetic */ long qWx;

        e(d dVar, String str, long j2, long j3) {
            this.qWr = dVar;
            this.qWs = str;
            this.qWt = j2;
            this.qWx = j3;
        }

        public final void run() {
            AppMethodBeat.i(194650);
            b.a aVar = this.qWr.qWn;
            if (aVar == null) {
                p.hyc();
            }
            aVar.i(this.qWs, this.qWt, this.qWx);
            AppMethodBeat.o(194650);
        }
    }

    @Override // com.tencent.mm.i.h.a
    public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(194669);
        p.h(str, "mediaId");
        Log.i("MicroMsg.VideoController", "onFinish!!! mediaId[%s].", str);
        if (!(this.qWn == null || this.qWo == null || !p.j(this.qWo, str))) {
            this.cPw.post(new c(this, str, i2));
        }
        AppMethodBeat.o(194669);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ d qWr;
        final /* synthetic */ String qWs;
        final /* synthetic */ int qWv;

        c(d dVar, String str, int i2) {
            this.qWr = dVar;
            this.qWs = str;
            this.qWv = i2;
        }

        public final void run() {
            AppMethodBeat.i(194648);
            b.a aVar = this.qWr.qWn;
            if (aVar == null) {
                p.hyc();
            }
            aVar.ax(this.qWs, this.qWv);
            AppMethodBeat.o(194648);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/VideoController$Companion;", "", "()V", "TAG", "", "getCachePath", "url", "getTempPath", "plugin-eggspring_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
