package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015J\"\u0010\u001d\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;", "", "()V", "videoProfileData", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "onMediaPlayerCreated", "", "costTime", "", "onMediaPlayerVideoBufferEnd", "onMediaPlayerVideoBufferStart", "onMediaPlayerVideoEnd", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "onMediaPlayerVideoError", "what", "", "extra", "msg", "", "onMediaPlayerVideoPrepareEnd", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "onMediaPlayerVideoPrepareStart", "onMediaPlayerVideoStop", "onVideoPathChanged", "cachedSize", "videoPath", "reportVideoProfile", "callFrom", "Companion", "VideoProfileData", "plugin-webview_release"})
public final class m {
    public static final a Jyn = new a((byte) 0);
    final b Jym = new b();

    static {
        AppMethodBeat.i(210793);
        AppMethodBeat.o(210793);
    }

    public m() {
        AppMethodBeat.i(210792);
        AppMethodBeat.o(210792);
    }

    public final void bbl(String str) {
        AppMethodBeat.i(210789);
        if (str == null) {
            AppMethodBeat.o(210789);
            return;
        }
        h.INSTANCE.idkeyStat(1379, 14, 1, false);
        if (0 > 0) {
            h.INSTANCE.idkeyStat(1379, 15, 1, false);
            h.INSTANCE.idkeyStat(1379, 16, 0, false);
            Log.d("MicroMsg.WebViewVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", 0L, 0L);
        }
        this.Jym.setVideoPath(str);
        this.Jym.mNp = 0;
        AppMethodBeat.o(210789);
    }

    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, c cVar) {
        AppMethodBeat.i(210790);
        p.h(cVar, "mediaPlayer");
        if (!Util.isNullOrNil(this.Jym.videoPath) && this.Jym.mNq > 0) {
            this.Jym.mNx = Util.nowMilliSecond();
            a(aVar, cVar, "onMediaPlayerVideoStop");
        }
        AppMethodBeat.o(210790);
    }

    /* access modifiers changed from: package-private */
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, c cVar, String str) {
        com.tencent.luggage.xweb_ext.extendplugin.a aVar2;
        String str2;
        com.tencent.luggage.xweb_ext.extendplugin.a aVar3;
        String str3;
        int i2;
        int i3;
        int i4;
        int i5;
        String gid;
        AppMethodBeat.i(210791);
        if (this.Jym.mNr < this.Jym.mNq) {
            Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
            this.Jym.reset();
            AppMethodBeat.o(210791);
            return;
        }
        if (!(aVar instanceof f)) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        f fVar = (f) aVar2;
        if (fVar == null || (gid = fVar.gid()) == null) {
            str2 = "";
        } else {
            str2 = gid;
        }
        if (!(aVar instanceof f)) {
            aVar3 = null;
        } else {
            aVar3 = aVar;
        }
        f fVar2 = (f) aVar3;
        if (fVar2 == null || (str3 = fVar2.getCurrentUrl()) == null) {
            str3 = "";
        }
        String bfG = z.bfG(str3);
        String bfG2 = z.bfG(this.Jym.videoPath);
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.l.f(cVar)) {
            i2 = 0;
        } else if (cVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
            AppMethodBeat.o(210791);
            throw tVar;
        } else {
            i2 = ((f) cVar).bKD();
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.l.f(cVar)) {
            i3 = 0;
        } else if (cVar == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
            AppMethodBeat.o(210791);
            throw tVar2;
        } else {
            i3 = ((f) cVar).bKE();
        }
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.l.f(cVar)) {
            i4 = 0;
        } else if (cVar == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.player.exo.ExoMediaPlayer");
            AppMethodBeat.o(210791);
            throw tVar3;
        } else {
            i4 = ((f) cVar).bKF();
        }
        j bJE = j.bJE();
        p.g(bJE, "VideoCore.getInstance()");
        if (bJE.bJG()) {
            j bJE2 = j.bJE();
            p.g(bJE2, "VideoCore.getInstance()");
            if (bJE2.bJF()) {
                i5 = 1;
                j bJE3 = j.bJE();
                p.g(bJE3, "VideoCore.getInstance()");
                Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", str, str2, Boolean.valueOf(bJE3.bJG()), Long.valueOf(this.Jym.mNo), this.Jym.videoPath, Long.valueOf(this.Jym.mNp), Long.valueOf(this.Jym.duration), Long.valueOf(this.Jym.mNs), Integer.valueOf(this.Jym.mNt), Long.valueOf(this.Jym.mNu), Integer.valueOf(this.Jym.mNz), Integer.valueOf(this.Jym.mNA), this.Jym.errorMsg, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                h.INSTANCE.a(19953, str2, bfG, bfG2, Long.valueOf(this.Jym.mNq), Long.valueOf(this.Jym.mNr), Long.valueOf(this.Jym.mNs), Long.valueOf(this.Jym.mNo), Long.valueOf(this.Jym.duration), Long.valueOf(this.Jym.mNp), Integer.valueOf(this.Jym.mNz), Integer.valueOf(this.Jym.mNA), this.Jym.errorMsg, Integer.valueOf(i5), Integer.valueOf(this.Jym.mNt), Long.valueOf(this.Jym.mNu), Long.valueOf(this.Jym.mNx), Long.valueOf(this.Jym.mNy), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                this.Jym.reset();
                AppMethodBeat.o(210791);
            }
        }
        i5 = 0;
        j bJE32 = j.bJE();
        p.g(bJE32, "VideoCore.getInstance()");
        Log.i("MicroMsg.WebViewVideoProfileReport", "reportVideoProfile:%s, webComptName:%s, proxy:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", str, str2, Boolean.valueOf(bJE32.bJG()), Long.valueOf(this.Jym.mNo), this.Jym.videoPath, Long.valueOf(this.Jym.mNp), Long.valueOf(this.Jym.duration), Long.valueOf(this.Jym.mNs), Integer.valueOf(this.Jym.mNt), Long.valueOf(this.Jym.mNu), Integer.valueOf(this.Jym.mNz), Integer.valueOf(this.Jym.mNA), this.Jym.errorMsg, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        h.INSTANCE.a(19953, str2, bfG, bfG2, Long.valueOf(this.Jym.mNq), Long.valueOf(this.Jym.mNr), Long.valueOf(this.Jym.mNs), Long.valueOf(this.Jym.mNo), Long.valueOf(this.Jym.duration), Long.valueOf(this.Jym.mNp), Integer.valueOf(this.Jym.mNz), Integer.valueOf(this.Jym.mNA), this.Jym.errorMsg, Integer.valueOf(i5), Integer.valueOf(this.Jym.mNt), Long.valueOf(this.Jym.mNu), Long.valueOf(this.Jym.mNx), Long.valueOf(this.Jym.mNy), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.Jym.reset();
        AppMethodBeat.o(210791);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR$\u0010:\u001a\u00020\"2\u0006\u00109\u001a\u00020\"@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$VideoProfileData;", "", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport;)V", "bufferEndTime", "", "getBufferEndTime", "()J", "setBufferEndTime", "(J)V", "bufferStartTime", "getBufferStartTime", "setBufferStartTime", "buffetAllTime", "getBuffetAllTime", "setBuffetAllTime", "buffetCount", "", "getBuffetCount", "()I", "setBuffetCount", "(I)V", "cachedSize", "getCachedSize", "setCachedSize", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "setDuration", "endTimeStamp", "getEndTimeStamp", "setEndTimeStamp", "errorExtra", "getErrorExtra", "setErrorExtra", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "errorWhat", "getErrorWhat", "setErrorWhat", "playerCreateTime", "getPlayerCreateTime", "setPlayerCreateTime", "prepareEndTime", "getPrepareEndTime", "setPrepareEndTime", "prepareStartTime", "getPrepareStartTime", "setPrepareStartTime", "prepareTime", "getPrepareTime", "setPrepareTime", "stopTimeStamp", "getStopTimeStamp", "setStopTimeStamp", "value", "videoPath", "getVideoPath", "setVideoPath", "reset", "", "resetBufferTime", "plugin-webview_release"})
    public final class b {
        long duration;
        String errorMsg = "";
        int mNA;
        long mNo;
        long mNp;
        long mNq;
        long mNr;
        long mNs;
        int mNt;
        long mNu;
        long mNv;
        long mNw;
        long mNx;
        long mNy;
        int mNz;
        String videoPath = "";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public final void setVideoPath(String str) {
            AppMethodBeat.i(210787);
            p.h(str, "value");
            if (Util.isNullOrNil(str)) {
                str = "";
            } else if (str.length() > 512) {
                str = str.substring(0, 512);
                p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.videoPath = str;
            AppMethodBeat.o(210787);
        }

        public final void reset() {
            AppMethodBeat.i(210788);
            setVideoPath("");
            this.mNo = 0;
            this.duration = 0;
            this.mNp = 0;
            this.mNq = 0;
            this.mNr = 0;
            this.mNs = 0;
            this.mNt = 0;
            this.mNv = 0;
            this.mNw = 0;
            this.mNu = 0;
            this.mNx = 0;
            this.mNy = 0;
            this.mNz = 0;
            this.mNA = 0;
            this.errorMsg = "";
            AppMethodBeat.o(210788);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoProfileReport$Companion;", "", "()V", "IDKEY", "", "KVKEY", "", "ONE_KB", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
