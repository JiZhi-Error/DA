package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import android.view.Surface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.mm.plugin.flutter.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.nio.charset.Charset;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 ^2\u00020\u0001:\u0002^_B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010'H\u0016J\u0012\u00107\u001a\u0002052\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u001cH\u0016J\b\u0010;\u001a\u00020\u001cH\u0016J\b\u0010<\u001a\u000201H\u0016J\b\u0010=\u001a\u000201H\u0016J\b\u0010>\u001a\u00020\u001cH\u0016J\b\u0010?\u001a\u00020@H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010B\u001a\u00020\u001cH\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0016J\b\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u000205H\u0016J\u0010\u0010H\u001a\u0002052\u0006\u0010I\u001a\u00020\u001cH\u0016J\u0018\u0010H\u001a\u0002052\u0006\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\"H\u0016J\b\u0010L\u001a\u000205H\u0016J\u0010\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020\"H\u0016J\u0010\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020\"H\u0016J\u0012\u0010Q\u001a\u0002052\b\u0010R\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020@H\u0016J\u0012\u0010U\u001a\u0002052\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010X\u001a\u0002052\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u000205H\u0016J\b\u0010]\u001a\u000205H\u0016R\u0014\u0010\u0007\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\rR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", r.NAME, "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"})
public final class d implements g {
    private static Boolean wLj = Boolean.FALSE;
    public static final a wLk = new a((byte) 0);
    final String TAG = "MicroMsg.FlutterVideoPlayer";
    boolean ZA;
    private Context context;
    String mediaId;
    private long rangeOffset;
    private String url;
    private ITPPlayer wLc;
    private h wLd;
    private String wLe;
    int wLf;
    private int wLg;
    private long wLh;
    private b wLi;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$Companion;", "", "()V", "isInited", "", "Ljava/lang/Boolean;", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241173);
        AppMethodBeat.o(241173);
    }

    public d(Context context2, String str) {
        p.h(context2, "_context");
        p.h(str, "_path");
        AppMethodBeat.i(241172);
        this.context = context2;
        this.wLe = str;
        Boolean bool = wLj;
        if (bool == null) {
            p.hyc();
        }
        if (!bool.booleanValue()) {
            wLj = Boolean.TRUE;
            TPPlayerMgr.initSdk(this.context, "60303", 1);
            TPPlayerMgr.setProxyEnable(true);
            TPPlayerMgr.setProxyServiceType(100);
        }
        this.wLc = TPPlayerFactory.createTPPlayer(this.context);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.setOnPreparedListener(new c(this));
        }
        ITPPlayer iTPPlayer2 = this.wLc;
        if (iTPPlayer2 != null) {
            iTPPlayer2.setOnErrorListener(new C1363d(this));
        }
        ITPPlayer iTPPlayer3 = this.wLc;
        if (iTPPlayer3 != null) {
            iTPPlayer3.setOnCompletionListener(new e(this));
        }
        ITPPlayer iTPPlayer4 = this.wLc;
        if (iTPPlayer4 != null) {
            iTPPlayer4.setOnSeekCompleteListener(new f(this));
        }
        ITPPlayer iTPPlayer5 = this.wLc;
        if (iTPPlayer5 != null) {
            iTPPlayer5.setOnPlayerStateChangeListener(new g(this));
        }
        ITPPlayer iTPPlayer6 = this.wLc;
        if (iTPPlayer6 != null) {
            iTPPlayer6.setOnInfoListener(new h(this));
            AppMethodBeat.o(241172);
            return;
        }
        AppMethodBeat.o(241172);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
    static final class c implements ITPPlayerListener.IOnPreparedListener {
        final /* synthetic */ d wLm;

        c(d dVar) {
            this.wLm = dVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
        public final void onPrepared(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(241151);
            Log.i(this.wLm.TAG, "FVPlayer video_status " + iTPPlayer + " prepared");
            this.wLm.ZA = true;
            h hVar = this.wLm.wLd;
            if (hVar != null) {
                hVar.c(false, 3);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1414, 0);
            AppMethodBeat.o(241151);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "arg1", "", "arg2", "onError"})
    /* renamed from: com.tencent.mm.plugin.flutter.f.d$d  reason: collision with other inner class name */
    static final class C1363d implements ITPPlayerListener.IOnErrorListener {
        final /* synthetic */ d wLm;

        C1363d(d dVar) {
            this.wLm = dVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
        public final void onError(ITPPlayer iTPPlayer, int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(241152);
            Log.e(this.wLm.TAG, "tplayer log " + iTPPlayer + " error " + i2 + ' ' + i3);
            h hVar = this.wLm.wLd;
            if (hVar != null) {
                hVar.c(i3, i2, "视频加载失败，请检查网络连接后重试", "重试");
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1414, 1);
            AppMethodBeat.o(241152);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
    static final class e implements ITPPlayerListener.IOnCompletionListener {
        final /* synthetic */ d wLm;

        e(d dVar) {
            this.wLm = dVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
        public final void onCompletion(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(241153);
            Log.i(this.wLm.TAG, iTPPlayer + " on complete");
            h hVar = this.wLm.wLd;
            if (hVar != null) {
                hVar.c(false, 4);
                AppMethodBeat.o(241153);
                return;
            }
            AppMethodBeat.o(241153);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
    static final class f implements ITPPlayerListener.IOnSeekCompleteListener {
        final /* synthetic */ d wLm;

        f(d dVar) {
            this.wLm = dVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener
        public final void onSeekComplete(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(241154);
            Log.i(this.wLm.TAG, iTPPlayer + " on seek");
            AppMethodBeat.o(241154);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "preState", "", "curState", "onStateChange"})
    static final class g implements ITPPlayerListener.IOnStateChangeListener {
        final /* synthetic */ d wLm;

        g(d dVar) {
            this.wLm = dVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
        public final void onStateChange(int i2, int i3) {
            AppMethodBeat.i(241155);
            Log.i(this.wLm.TAG, this.wLm.wLc + " prestate: " + i2 + ", curState: " + i3);
            this.wLm.wLf = i3;
            switch (i3) {
                case 3:
                    h hVar = this.wLm.wLd;
                    if (hVar != null) {
                        hVar.c(false, 5);
                        AppMethodBeat.o(241155);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(241155);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000bH\n¢\u0006\u0002\b\f"}, hxF = {"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
    static final class h implements ITPPlayerListener.IOnInfoListener {
        final /* synthetic */ d wLm;

        h(d dVar) {
            this.wLm = dVar;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
        public final void onInfo(ITPPlayer iTPPlayer, int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(241156);
            Log.i(this.wLm.TAG, "tplayer log " + iTPPlayer + ", msg:" + i2);
            switch (i2) {
                case 200:
                    Log.i(this.wLm.TAG, "video_status need buffer: " + iTPPlayer + " mediaId:" + this.wLm.mediaId);
                    h hVar = this.wLm.wLd;
                    if (hVar != null) {
                        hVar.c(false, 7);
                        AppMethodBeat.o(241156);
                        return;
                    }
                    AppMethodBeat.o(241156);
                    return;
                case 201:
                    Log.i(this.wLm.TAG, "video_status buffer ok: ".concat(String.valueOf(iTPPlayer)));
                    h hVar2 = this.wLm.wLd;
                    if (hVar2 != null) {
                        hVar2.c(false, 8);
                        AppMethodBeat.o(241156);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(241156);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\"\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "fileId", "", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "plugin-flutter_release"})
    public final class b extends h.a.a.a.a.a.a.a.a.a.a.a {
        private final String mediaId;
        private final String path;
        private long wLl;
        final /* synthetic */ d wLm;

        public b(d dVar, String str, String str2) {
            p.h(str, "mediaId");
            p.h(str2, "path");
            this.wLm = dVar;
            AppMethodBeat.i(241150);
            this.mediaId = str;
            this.path = str2;
            AppMethodBeat.o(241150);
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int onStartReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(241145);
            Log.d(this.wLm.TAG, "[onStartReadData] player: " + this.wLm.wLc + " mediaId=" + this.mediaId + " fileId: " + i2);
            int hashCode = this.mediaId.hashCode();
            AppMethodBeat.o(241145);
            return hashCode;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int k(int i2, long j2, long j3) {
            boolean z;
            boolean isVideoDataAvailable;
            AppMethodBeat.i(241146);
            Log.d(this.wLm.TAG, "[onReadData] player: " + this.wLm.wLc + " mediaId=" + this.mediaId + " fileId: " + i2 + " state:" + this.wLm.wLf);
            if (j3 <= 0) {
                Log.d(this.wLm.TAG, "FVPlayer onReadDate 0");
                AppMethodBeat.o(241146);
                return 0;
            }
            b.a axy = e.wLs.dMk().wLp.axy(this.mediaId);
            if (!(axy == null || this.wLl == axy.cacheSize)) {
                this.wLl = axy.cacheSize;
                com.tencent.f.h.RTc.aV(new a(this));
            }
            if (axy == null || !axy.brr) {
                if (this.wLm.wLf != 6) {
                    boolean taskExist = CdnLogic.taskExist(this.mediaId);
                    if (!taskExist || !(isVideoDataAvailable = CdnLogic.isVideoDataAvailable(this.mediaId, j2, j3))) {
                        z = taskExist;
                    } else {
                        Log.d(this.wLm.TAG, "FVPlayer onReadData isVideoDataAvailable " + isVideoDataAvailable + " offset:" + j2 + " length:" + j3 + " mediaId" + this.mediaId);
                        int i3 = (int) j3;
                        AppMethodBeat.o(241146);
                        return i3;
                    }
                } else {
                    z = false;
                }
                if (this.wLm.wLf != 3 && this.wLm.wLf != 5) {
                    Log.v(this.wLm.TAG, "not in need data state, ignore, state:" + this.wLm.wLf + ", media:" + this.mediaId);
                    AppMethodBeat.o(241146);
                    return 0;
                } else if (this.wLm.wLf == 3) {
                    Long valueOf = axy != null ? Long.valueOf(axy.wKT) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    if (valueOf.longValue() >= j2 + j3) {
                        Log.v(this.wLm.TAG, "onreaddata preload enough: " + this.mediaId);
                        int i4 = (int) j3;
                        AppMethodBeat.o(241146);
                        return i4;
                    }
                    if (z) {
                        if ((axy != null ? Boolean.valueOf(axy.wKV) : null).booleanValue()) {
                            if (this.wLm.rangeOffset == j2 && this.wLm.wLh == j3) {
                                Log.d(this.wLm.TAG, "range(" + j2 + ", " + j3 + ") is already requesting");
                                AppMethodBeat.o(241146);
                                return 0;
                            }
                            int z2 = e.wLs.dMk().wLq.z(this.mediaId, j2, j3);
                            if (z2 != 0) {
                                Log.e(this.wLm.TAG, "[key] request video data error " + this.mediaId + ", ret:" + z2 + " state:" + this.wLm.wLf + " exists:" + z + ", offset:" + j2 + ", length:" + j3 + ", cache:" + (axy != null ? Long.valueOf(axy.cacheSize) : null).longValue());
                                e.wLs.dMk().wLp.a(this.wLm.url, this.mediaId, Long.valueOf(j2 + j3));
                                this.wLm.wLh = 0;
                            } else {
                                this.wLm.rangeOffset = j2;
                                this.wLm.wLh = j3;
                            }
                            Log.d(this.wLm.TAG, "onreaddata need more: " + this.mediaId);
                            AppMethodBeat.o(241146);
                            return 0;
                        }
                    }
                    if (!(axy != null ? Boolean.valueOf(axy.wKU) : null).booleanValue()) {
                        e.wLs.dMk().wLp.a(this.wLm.url, this.mediaId, Long.valueOf(j2 + j3));
                    }
                    Log.d(this.wLm.TAG, "onreaddata need more: " + this.mediaId);
                    AppMethodBeat.o(241146);
                    return 0;
                } else if (this.wLm.wLf != 5) {
                    AppMethodBeat.o(241146);
                    return 0;
                } else if (this.wLm.rangeOffset == j2 && this.wLm.wLh == j3) {
                    Log.d(this.wLm.TAG, "range(" + j2 + ", " + j3 + ") is already requesting");
                    AppMethodBeat.o(241146);
                    return 0;
                } else {
                    int z3 = e.wLs.dMk().wLq.z(this.mediaId, j2, j3);
                    if (z3 != 0) {
                        Log.d(this.wLm.TAG, "onreaddata request more data ret:" + z3 + " state:" + this.wLm.wLf + ' ' + this.mediaId + ", ret:" + z3 + ", exists:" + z + ", offset:" + j2 + ", length:" + j3 + ", cache:" + (axy != null ? Long.valueOf(axy.cacheSize) : null));
                        e.wLs.dMk().wLp.a(this.wLm.url, this.mediaId, Long.valueOf(j2 + j3));
                        this.wLm.wLh = 0;
                    } else {
                        this.wLm.rangeOffset = j2;
                        this.wLm.wLh = j3;
                    }
                    AppMethodBeat.o(241146);
                    return 0;
                }
            } else {
                Log.d(this.wLm.TAG, "onreaddata completed");
                int i5 = (int) j3;
                AppMethodBeat.o(241146);
                return i5;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b wLn;

            a(b bVar) {
                this.wLn = bVar;
            }

            public final void run() {
                AppMethodBeat.i(241144);
                h hVar = this.wLn.wLm.wLd;
                if (hVar != null) {
                    hVar.c(false, 2);
                    AppMethodBeat.o(241144);
                    return;
                }
                AppMethodBeat.o(241144);
            }
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int onStopReadData(int i2, String str, int i3) {
            AppMethodBeat.i(241147);
            Log.d(this.wLm.TAG, "[onStopReadData] player: " + this.wLm.wLc + " mediaId=" + this.mediaId + " taskId: " + i2);
            AppMethodBeat.o(241147);
            return 0;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final long getDataTotalSize(int i2, String str) {
            AppMethodBeat.i(241148);
            b.a axy = e.wLs.dMk().wLp.axy(this.mediaId);
            Long valueOf = axy != null ? Long.valueOf(axy.oJj) : null;
            if (valueOf == null) {
                p.hyc();
            }
            long longValue = valueOf.longValue();
            AppMethodBeat.o(241148);
            return longValue;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final String Mf(int i2) {
            String str;
            AppMethodBeat.i(241149);
            b.a axy = e.wLs.dMk().wLp.axy(this.mediaId);
            if (axy != null) {
                str = axy.path;
            } else {
                str = null;
            }
            if (str == null) {
                p.hyc();
            }
            Log.d(this.wLm.TAG, "[getDataFilePath] player: " + this.wLm.wLc + " mediaId=" + this.mediaId + " fileId: " + i2 + ", path: " + str);
            AppMethodBeat.o(241149);
            return str;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final String getContentType(int i2, String str) {
            return "video/mp4";
        }
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final void a(h hVar) {
        this.wLd = hVar;
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void seek(int i2) {
        AppMethodBeat.i(241157);
        Log.i(this.TAG, "video_status seek " + this.wLc + ", state: " + this.wLf);
        if (this.wLf < 4) {
            Log.e(this.TAG, "video_status wrong seek");
            AppMethodBeat.o(241157);
            return;
        }
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.resumeDownload();
        }
        ITPPlayer iTPPlayer2 = this.wLc;
        if (iTPPlayer2 != null) {
            iTPPlayer2.seekTo(i2);
            AppMethodBeat.o(241157);
            return;
        }
        AppMethodBeat.o(241157);
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final long getCurrentPosition() {
        AppMethodBeat.i(241158);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            long currentPositionMs = iTPPlayer.getCurrentPositionMs();
            AppMethodBeat.o(241158);
            return currentPositionMs;
        }
        AppMethodBeat.o(241158);
        return 0;
    }

    @Override // com.tencent.mm.plugin.n.c
    public final boolean prepare() {
        AppMethodBeat.i(241159);
        String str = this.mediaId;
        if (str == null) {
            p.hyc();
        }
        String str2 = this.wLe;
        if (str2 == null) {
            p.hyc();
        }
        this.wLi = new b(this, str, str2);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.enableTPAssetResourceLoader(this.wLi);
        }
        Log.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
        if (this.wLf < 3) {
            b.a axy = e.wLs.dMk().wLp.axy(this.mediaId);
            TPVideoInfo.Builder builder = new TPVideoInfo.Builder();
            builder.fileId(this.mediaId);
            builder.downloadParam(new TPDownloadParamData(11));
            ITPPlayer iTPPlayer2 = this.wLc;
            if (iTPPlayer2 != null) {
                iTPPlayer2.setVideoInfo(builder.build());
            }
            if (axy == null || !axy.brr) {
                ITPPlayer iTPPlayer3 = this.wLc;
                if (iTPPlayer3 != null) {
                    iTPPlayer3.setDataSource(this.url);
                }
            } else {
                ITPPlayer iTPPlayer4 = this.wLc;
                if (iTPPlayer4 != null) {
                    iTPPlayer4.setDataSource(axy.path);
                }
            }
            ITPPlayer iTPPlayer5 = this.wLc;
            if (iTPPlayer5 != null) {
                iTPPlayer5.prepareAsync();
            }
        } else {
            Log.d(this.TAG, "video_status prepare playerState " + this.wLf + ' ');
        }
        AppMethodBeat.o(241159);
        return true;
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void start() {
        AppMethodBeat.i(241160);
        Log.d(this.TAG, "video_status play " + this.wLc + ", mediaId:" + this.mediaId + ", download: " + this.wLg + " state:" + this.wLf + " : " + this.url);
        if (this.wLf == 5) {
            Log.d(this.TAG, "video_status already playing " + this.wLc);
            AppMethodBeat.o(241160);
            return;
        }
        boolean z = this.wLf >= 4;
        if (!aa.SXc || z) {
            ITPPlayer iTPPlayer = this.wLc;
            if (iTPPlayer != null) {
                iTPPlayer.resumeDownload();
            }
            ITPPlayer iTPPlayer2 = this.wLc;
            if (iTPPlayer2 != null) {
                iTPPlayer2.start();
                AppMethodBeat.o(241160);
                return;
            }
            AppMethodBeat.o(241160);
            return;
        }
        AssertionError assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(241160);
        throw assertionError;
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final void u(double d2) {
        AppMethodBeat.i(241161);
        Log.d(this.TAG, r.NAME);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.setAudioGainRatio((float) d2);
            AppMethodBeat.o(241161);
            return;
        }
        AppMethodBeat.o(241161);
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final int getHeight() {
        AppMethodBeat.i(241162);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            int videoHeight = iTPPlayer.getVideoHeight();
            AppMethodBeat.o(241162);
            return videoHeight;
        }
        AppMethodBeat.o(241162);
        return 0;
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void pause() {
        AppMethodBeat.i(241163);
        Log.d(this.TAG, "video_status pause " + this.wLc + ", mediaId:" + this.mediaId + ", url:" + this.url);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.pause();
        }
        ITPPlayer iTPPlayer2 = this.wLc;
        if (iTPPlayer2 != null) {
            iTPPlayer2.pauseDownload();
            AppMethodBeat.o(241163);
            return;
        }
        AppMethodBeat.o(241163);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final long getDurationMs() {
        AppMethodBeat.i(241164);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("getDurationMs: ");
        ITPPlayer iTPPlayer = this.wLc;
        Log.d(str, sb.append(iTPPlayer != null ? Long.valueOf(iTPPlayer.getDurationMs()) : null).toString());
        ITPPlayer iTPPlayer2 = this.wLc;
        if (iTPPlayer2 != null) {
            long durationMs = iTPPlayer2.getDurationMs();
            AppMethodBeat.o(241164);
            return durationMs;
        }
        AppMethodBeat.o(241164);
        return 0;
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final int getWidth() {
        int i2;
        AppMethodBeat.i(241165);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("getWidth ").append(this.wLc).append("  ");
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            i2 = iTPPlayer.getVideoWidth();
        } else {
            i2 = 0;
        }
        Log.d(str, append.append(i2).toString());
        ITPPlayer iTPPlayer2 = this.wLc;
        if (iTPPlayer2 != null) {
            int videoWidth = iTPPlayer2.getVideoWidth();
            AppMethodBeat.o(241165);
            return videoWidth;
        }
        AppMethodBeat.o(241165);
        return 0;
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final void setLooping(boolean z) {
        AppMethodBeat.i(241166);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.setLoopback(z);
            AppMethodBeat.o(241166);
            return;
        }
        AppMethodBeat.o(241166);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void setSurface(Surface surface) {
        int i2;
        AppMethodBeat.i(241167);
        String str = this.TAG;
        Object[] objArr = new Object[1];
        if (surface != null) {
            i2 = surface.hashCode();
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        Log.d(str, "setSurface %s", objArr);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.setSurface(surface);
            AppMethodBeat.o(241167);
            return;
        }
        AppMethodBeat.o(241167);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void stop() {
        AppMethodBeat.i(241168);
        Log.d(this.TAG, "video_status stop: " + this.wLc + " , url: " + this.url);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.stop();
            AppMethodBeat.o(241168);
            return;
        }
        AppMethodBeat.o(241168);
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final int getBufferedPercentage() {
        Long l = null;
        AppMethodBeat.i(241169);
        b.a axy = e.wLs.dMk().wLp.axy(this.mediaId);
        Long valueOf = axy != null ? Long.valueOf(axy.cacheSize) : null;
        if (axy != null) {
            l = Long.valueOf(axy.oJj);
        }
        if (valueOf == null) {
            p.hyc();
        }
        if (valueOf.longValue() > 0) {
            if (l == null) {
                p.hyc();
            }
            if (l.longValue() > 0) {
                int longValue = (int) ((valueOf.longValue() * 100) / l.longValue());
                AppMethodBeat.o(241169);
                return longValue;
            }
        }
        AppMethodBeat.o(241169);
        return 0;
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void setPath(String str) {
        byte[] bArr;
        AppMethodBeat.i(241170);
        Log.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + str + ' ');
        this.url = str;
        String str2 = this.url;
        if (str2 != null) {
            Charset charset = kotlin.n.d.UTF_8;
            if (str2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(241170);
                throw tVar;
            }
            bArr = str2.getBytes(charset);
            p.g(bArr, "(this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        this.mediaId = com.tencent.mm.b.g.getMessageDigest(bArr);
        AppMethodBeat.o(241170);
    }

    @Override // com.tencent.mm.plugin.n.c
    public final void release() {
        AppMethodBeat.i(241171);
        Log.d(this.TAG, "video_status release " + this.wLc + " , url: " + this.url);
        ITPPlayer iTPPlayer = this.wLc;
        if (iTPPlayer != null) {
            iTPPlayer.setSurface(null);
        }
        ITPPlayer iTPPlayer2 = this.wLc;
        if (iTPPlayer2 != null) {
            iTPPlayer2.release();
            AppMethodBeat.o(241171);
            return;
        }
        AppMethodBeat.o(241171);
    }

    @Override // com.tencent.mm.plugin.flutter.f.g
    public final String getVideoPath() {
        return this.url;
    }
}
