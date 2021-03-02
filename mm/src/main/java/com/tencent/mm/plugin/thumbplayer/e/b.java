package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import android.view.Surface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u00012\u00020\u0001:\u0006\u0001\u0001\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010c\u001a\u00020-H\u0002J\b\u0010d\u001a\u00020-H\u0002J\f\u0010e\u001a\u00060KR\u00020\u0000H\u0016J\u0006\u0010f\u001a\u00020gJ\u0006\u0010h\u001a\u00020\u0016J\b\u0010i\u001a\u00020-H\u0002J\u0012\u0010j\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u000109H\u0002J\u0006\u0010k\u001a\u00020\u0010J\u0006\u0010l\u001a\u00020\u0010J\u0006\u0010m\u001a\u00020\u0010J\u0006\u0010n\u001a\u00020\u0010J\u0006\u0010o\u001a\u00020\u0010J\u0006\u0010p\u001a\u00020\u0010J\u0006\u0010q\u001a\u00020-J\u0006\u0010r\u001a\u00020\u0006J\u0010\u0010s\u001a\u00020\u00102\b\b\u0002\u0010t\u001a\u00020\nJ\u0010\u0010u\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\nH\u0002J\b\u0010v\u001a\u00020-H\u0002J\u0006\u0010w\u001a\u00020-J\u0018\u0010x\u001a\u00020-2\u0006\u0010y\u001a\u00020\n2\b\b\u0002\u0010z\u001a\u00020\u0010J\u001a\u0010{\u001a\u00020-2\n\u0010|\u001a\u00060^R\u00020\u00002\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020-2\u0006\u0010\u001a\u00020\u0010J\u000f\u0010\u0001\u001a\u00020-2\u0006\u0010}\u001a\u00020&J\u0010\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u0010J\u0019\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016J\u001d\u0010\u0001\u001a\u00020-2\t\u0010\u0001\u001a\u0004\u0018\u00010R2\t\b\u0002\u0010\u0001\u001a\u00020\u0016J\u001e\u0010\u0001\u001a\u00020-2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\b\u0002\u0010\u0001\u001a\u00020\u0010J\t\u0010\u0001\u001a\u00020-H\u0002J\t\u0010\u0001\u001a\u00020-H\u0002J\u0007\u0010\u0001\u001a\u00020-J\u0007\u0010\u0001\u001a\u00020-J\u0007\u0010\u0001\u001a\u00020-J\u0007\u0010\u0001\u001a\u00020-J\u0007\u0010\u0001\u001a\u00020-J\u0012\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020-\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00108\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020-\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u000e\u0010<\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR \u0010J\u001a\b\u0018\u00010KR\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010W\u001a\u00020XX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R \u0010]\u001a\b\u0018\u00010^R\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "currentPlayState", "", "getCurrentPlayState", "()I", "setCurrentPlayState", "(I)V", "enableProgressLog", "", "getEnableProgressLog", "()Z", "setEnableProgressLog", "(Z)V", "firstPlaySeekTimeMs", "", "getFirstPlaySeekTimeMs", "()J", "setFirstPlaySeekTimeMs", "(J)V", "fromExternResourceLoader", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRealStartDownloader", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isStartCdn", "setStartCdn", "isViewFocused", "setViewFocused", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMedia", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "setMedia", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "onPlayStarted", "Lkotlin/Function1;", "", "getOnPlayStarted", "()Lkotlin/jvm/functions/Function1;", "setOnPlayStarted", "(Lkotlin/jvm/functions/Function1;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerRecycleListener;)V", "onPrepared", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getOnPrepared", "setOnPrepared", "playEnd", "playStart", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;)V", "playerActionListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "getPlayerActionListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;", "setPlayerActionListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerActionListener;)V", "playerListener", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "getPlayerListener", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "setPlayerListener", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;)V", "progressInterval", "progressListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "progressTimer", "Ljava/util/Timer;", "progressTimerTask", "Ljava/util/TimerTask;", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;)V", "resourceLoader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "getResourceLoader", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "setResourceLoader", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;)V", "checkPlayRange", "checkProgressTimer", "createTPPlayerListener", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCurrentPositionMs", "invokePlayStartedCallback", "invokePreparedCallback", "isIdle", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "pause", "playInfo", "playWithSource", "source", "prepareVideo", "realPlay", "recycle", "seekTo", "timeMs", "accurate", "setCdnResourceLoader", "loader", "mediaInfo", "setLoop", "looper", "setMediaInfo", "setMute", "mute", "setPlayRange", "startMs", "endMs", "setProgressListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "interval", "setSurface", "surface", "Landroid/view/Surface;", "start", "startCdnDownload", "startProgressTimer", "startToPlay", "stop", "stopAsync", "stopCdnDownload", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "MMTPResourceLoader", "TPPlayerListener", "plugin-thumbplayer_release"})
public final class b {
    public static final a GhL = new a((byte) 0);
    public C1836b GhA;
    com.tencent.mm.plugin.thumbplayer.view.f GhB;
    private volatile com.tencent.mm.plugin.thumbplayer.view.e GhD;
    private long GhE = 200;
    private Timer GhF;
    private TimerTask GhG;
    private long GhH = -1;
    public boolean GhI;
    public boolean GhJ;
    public long GhK;
    public com.tencent.mm.plugin.thumbplayer.d.a Ghy;
    private c Ghz = new c();
    public final String TAG = ("MicroMsg.TP.MMCdnTPPlayer@" + hashCode());
    public kotlin.g.a.b<? super b, x> VfN;
    private kotlin.g.a.b<? super ITPPlayer, x> VfO;
    public com.tencent.mm.plugin.thumbplayer.view.g VfP;
    public com.tencent.mm.plugin.thumbplayer.d.b VfQ = new com.tencent.mm.plugin.thumbplayer.d.b();
    private final Context context;
    volatile int currentPlayState;
    private long wbl = -1;
    public boolean wcA;
    public a wdC;
    private AtomicBoolean wdQ = new AtomicBoolean(true);
    public boolean wdU;

    static {
        AppMethodBeat.i(238731);
        AppMethodBeat.o(238731);
    }

    public b(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(238730);
        this.context = context2;
        d.a aVar = d.GhZ;
        this.wdC = d.a.ht(this.context);
        a aVar2 = this.wdC;
        if (aVar2 != null) {
            aVar2.setOnErrorListener(this.Ghz);
        }
        a aVar3 = this.wdC;
        if (aVar3 != null) {
            aVar3.setOnPreparedListener(this.Ghz);
        }
        a aVar4 = this.wdC;
        if (aVar4 != null) {
            aVar4.setOnVideoSizeChangedListener(this.Ghz);
        }
        a aVar5 = this.wdC;
        if (aVar5 != null) {
            aVar5.setOnPlayerStateChangeListener(this.Ghz);
        }
        a aVar6 = this.wdC;
        if (aVar6 != null) {
            aVar6.setOnInfoListener(this.Ghz);
        }
        a aVar7 = this.wdC;
        if (aVar7 != null) {
            aVar7.setOnCompletionListener(this.Ghz);
        }
        this.GhK = -1;
        AppMethodBeat.o(238730);
    }

    public static final /* synthetic */ boolean a(b bVar, int i2) {
        AppMethodBeat.i(238734);
        boolean Md = bVar.Md(i2);
        AppMethodBeat.o(238734);
        return Md;
    }

    public static final /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(238732);
        bVar.fwT();
        AppMethodBeat.o(238732);
    }

    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(238733);
        bVar.fxa();
        AppMethodBeat.o(238733);
    }

    public static final /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(238735);
        bVar.fwX();
        AppMethodBeat.o(238735);
    }

    public static final /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(238736);
        bVar.fwZ();
        AppMethodBeat.o(238736);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$Companion;", "", "()V", "DEFAULT_PROGRESS_INTERVAL", "", "plugin-thumbplayer_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.d.a aVar) {
        String str;
        int i2;
        Boolean bool = null;
        AppMethodBeat.i(238704);
        p.h(aVar, "mediaInfo");
        this.Ghy = aVar;
        C1836b bVar = this.GhA;
        if (bVar != null) {
            str = bVar.mediaId;
        } else {
            str = null;
        }
        if (!p.j(str, aVar.mediaId)) {
            this.GhA = new C1836b(this, aVar.mediaId);
        }
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("setMediaInfo, resourceLoader:");
        C1836b bVar2 = this.GhA;
        if (bVar2 != null) {
            i2 = bVar2.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append = sb.append(i2).append(", isLocal:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.Ghy;
        if (aVar2 != null) {
            bool = Boolean.valueOf(aVar2.dLQ);
        }
        Log.i(str2, append.append(bool).toString());
        AppMethodBeat.o(238704);
    }

    public final void at(long j2, long j3) {
        AppMethodBeat.i(238705);
        Log.i(this.TAG, "setPlayRange: " + j2 + " - " + j3);
        this.wbl = j2;
        this.GhH = j3;
        fwY();
        fwZ();
        AppMethodBeat.o(238705);
    }

    public static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(238707);
        bVar.a((com.tencent.mm.plugin.thumbplayer.view.e) null, 200);
        AppMethodBeat.o(238707);
    }

    public final void a(com.tencent.mm.plugin.thumbplayer.view.e eVar, long j2) {
        AppMethodBeat.i(238706);
        this.GhD = eVar;
        if (j2 < 0) {
            Log.w(this.TAG, "setProgressListener: invalid interval ".concat(String.valueOf(j2)));
        } else {
            this.GhE = j2;
        }
        fwY();
        AppMethodBeat.o(238706);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J4\u0010\u0013\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\"\u0010\u001b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0016¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$TPPlayerListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onStateChange", "preState", "curState", "onVideoSizeChanged", "width", "height", "plugin-thumbplayer_release"})
    public class c implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
        public final void onPrepared(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(238694);
            b.this.Mc(0);
            if (b.this.Ghy != null && b.this.GhK > 0) {
                b.this.YX((int) b.this.GhK);
                Log.i(b.this.TAG, "seek to play " + b.this.GhK + ' ' + b.this.dFm());
            }
            b.a(b.this, iTPPlayer);
            AppMethodBeat.o(238694);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
        public final void onVideoSizeChanged(ITPPlayer iTPPlayer, long j2, long j3) {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
        public final void onInfo(ITPPlayer iTPPlayer, int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(260008);
            switch (i2) {
                case 106:
                    com.tencent.mm.plugin.thumbplayer.d.b bVar = b.this.VfQ;
                    bVar.Vfx = Util.ticksToNow(bVar.gXF);
                    break;
                case 150:
                    AppMethodBeat.o(260008);
                    return;
                case 200:
                    b.this.VfQ.VfA = Util.currentTicks();
                    AppMethodBeat.o(260008);
                    return;
                case 201:
                    com.tencent.mm.plugin.thumbplayer.d.b bVar2 = b.this.VfQ;
                    if (bVar2.VfA > 0) {
                        bVar2.Vfy++;
                        bVar2.Vfz += Util.ticksToNow(bVar2.VfA);
                    }
                    bVar2.VfA = 0;
                    AppMethodBeat.o(260008);
                    return;
            }
            AppMethodBeat.o(260008);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
        public final void onStateChange(int i2, int i3) {
            com.tencent.mm.plugin.thumbplayer.d.a aVar;
            com.tencent.mm.plugin.thumbplayer.view.g gVar;
            com.tencent.mm.plugin.thumbplayer.view.g gVar2;
            AppMethodBeat.i(238695);
            Log.i(b.this.TAG, "onStateChange() preState:" + i2 + " curState:" + i3 + ' ' + b.this.dFm());
            b.this.currentPlayState = i3;
            if (i3 == 9 || i3 == 1) {
                Log.i(b.this.TAG, "onStateChange() player stop or idle " + b.this.dFm());
                b.this.GhB = null;
            }
            if (i3 == 5) {
                b.c(b.this);
                com.tencent.mm.plugin.thumbplayer.d.a aVar2 = b.this.Ghy;
                if (!(aVar2 == null || (gVar2 = b.this.VfP) == null)) {
                    gVar2.b(aVar2);
                }
            }
            if (!(i3 != 6 || (aVar = b.this.Ghy) == null || (gVar = b.this.VfP) == null)) {
                gVar.a(aVar);
            }
            if (b.this.isPlaying()) {
                b.d(b.this);
                AppMethodBeat.o(238695);
                return;
            }
            b.this.dFs();
            AppMethodBeat.o(238695);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
        public final void onCompletion(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(238696);
            Log.i(b.this.TAG, "onCompletion");
            AppMethodBeat.o(238696);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
        public final void onError(ITPPlayer iTPPlayer, int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(238697);
            Log.i(b.this.TAG, "onError errorType:" + i2 + " errorCode:" + i3 + ' ' + b.this.dFm());
            b.this.VfQ.errType = i2;
            b.this.VfQ.errCode = i3;
            AppMethodBeat.o(238697);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
    public static final class g extends TimerTask {
        final /* synthetic */ b GhQ;

        public g(b bVar) {
            this.GhQ = bVar;
        }

        public final void run() {
            AppMethodBeat.i(238701);
            a aVar = this.GhQ.wdC;
            long currentPositionMs = aVar != null ? aVar.getCurrentPositionMs() : 0;
            if (this.GhQ.GhI) {
                Log.d(this.GhQ.TAG, "onProgress currentMs:".concat(String.valueOf(currentPositionMs)));
            }
            com.tencent.mm.plugin.thumbplayer.view.e eVar = this.GhQ.GhD;
            if (eVar != null) {
                eVar.Hv(currentPositionMs);
            }
            b.g(this.GhQ);
            AppMethodBeat.o(238701);
        }
    }

    private final void fwT() {
        AppMethodBeat.i(238708);
        kotlin.g.a.b<? super b, x> bVar = this.VfN;
        if (bVar != null) {
            bVar.invoke(this);
        }
        this.VfN = null;
        AppMethodBeat.o(238708);
    }

    public final void fwU() {
        AppMethodBeat.i(238709);
        if (fwV()) {
            Log.i(this.TAG, "already start " + dFm());
            Mc(3);
            fwT();
            AppMethodBeat.o(238709);
            return;
        }
        C1836b bVar = this.GhA;
        com.tencent.mm.plugin.thumbplayer.d.a aVar = this.Ghy;
        if (!(bVar == null || aVar == null)) {
            String k = s.k(aVar.path, false);
            Log.i(this.TAG, "startToPlay(), cache file:" + k + ", isLocal:" + aVar.dLQ + ", isExists:" + s.YS(k) + ' ' + dFm());
            if (aVar.dLQ || bVar.GhM) {
                a aVar2 = this.wdC;
                if (aVar2 != null) {
                    aVar2.setMediaId(aVar.mediaId);
                }
                a aVar3 = this.wdC;
                if (aVar3 != null) {
                    aVar3.setDataSource(k);
                }
            } else {
                TPVideoInfo.Builder builder = new TPVideoInfo.Builder();
                builder.fileId(aVar.mediaId);
                builder.downloadParam(new TPDownloadParamData(11));
                a aVar4 = this.wdC;
                if (aVar4 != null) {
                    aVar4.setMediaId(aVar.mediaId);
                }
                a aVar5 = this.wdC;
                if (aVar5 != null) {
                    aVar5.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000));
                }
                a aVar6 = this.wdC;
                if (aVar6 != null) {
                    aVar6.setVideoInfo(builder.build());
                }
                a aVar7 = this.wdC;
                if (aVar7 != null) {
                    aVar7.setDataSource(aVar.url);
                }
                dFo();
            }
            Md(1);
            this.VfQ.gXF = Util.currentTicks();
        }
        AppMethodBeat.o(238709);
    }

    public final void YX(int i2) {
        AppMethodBeat.i(238710);
        Log.i(this.TAG, "seekTo:" + i2 + ", accurate:true, isPause:" + YY());
        a aVar = this.wdC;
        if (aVar != null) {
            aVar.seekTo(i2, 3);
        }
        if (YY()) {
            Mc(2);
        }
        AppMethodBeat.o(238710);
    }

    public final void pause() {
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        AppMethodBeat.i(238711);
        if (isPlaying()) {
            a aVar2 = this.wdC;
            if (aVar2 != null) {
                aVar2.pause();
            }
            a aVar3 = this.wdC;
            if (aVar3 != null) {
                aVar3.pauseDownload();
            }
        }
        if (this.GhJ || (aVar = this.Ghy) == null || aVar.dLQ) {
            this.wdU = false;
            AppMethodBeat.o(238711);
            return;
        }
        dFp();
        AppMethodBeat.o(238711);
    }

    private boolean fwV() {
        switch (this.currentPlayState) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public final void fwW() {
        AppMethodBeat.i(238712);
        a aVar = this.wdC;
        if (aVar != null) {
            aVar.setOutputMute(true);
            AppMethodBeat.o(238712);
            return;
        }
        AppMethodBeat.o(238712);
    }

    public final void setLoop(boolean z) {
        AppMethodBeat.i(238713);
        a aVar = this.wdC;
        if (aVar != null) {
            aVar.setLoopback(z);
            AppMethodBeat.o(238713);
            return;
        }
        AppMethodBeat.o(238713);
    }

    public final boolean YY() {
        return this.currentPlayState == 6;
    }

    private boolean dFr() {
        return this.currentPlayState == 3;
    }

    public final boolean asa() {
        switch (this.currentPlayState) {
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public final boolean isPlaying() {
        return this.currentPlayState == 5;
    }

    public final boolean Mc(int i2) {
        AppMethodBeat.i(238714);
        Log.i(this.TAG, "playWithSource source=" + i2 + ' ' + dFm() + ' ');
        if (!this.wcA) {
            Log.i(this.TAG, "playWithSource() return for isViewFocused:" + this.wcA);
            AppMethodBeat.o(238714);
            return false;
        } else if (!fwV()) {
            Log.i(this.TAG, "playWithSource() return for currentState:" + this.currentPlayState);
            AppMethodBeat.o(238714);
            return false;
        } else {
            boolean isPlaying = isPlaying();
            if (isPlaying) {
                Log.i(this.TAG, "playWithSource() return for isPlaying:".concat(String.valueOf(isPlaying)));
            } else if (asa()) {
                dFn();
            }
            dFo();
            a aVar = this.wdC;
            if (aVar != null) {
                aVar.resumeDownload();
            }
            AppMethodBeat.o(238714);
            return true;
        }
    }

    private final boolean Md(int i2) {
        Boolean bool;
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        String str = null;
        AppMethodBeat.i(238715);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("prepareVideo() source:").append(i2).append(" isMoovReady:");
        C1836b bVar = this.GhA;
        StringBuilder append2 = append.append(bVar != null ? Boolean.valueOf(bVar.uTW) : null).append(' ').append("isAllCompleted:");
        C1836b bVar2 = this.GhA;
        if (bVar2 != null) {
            bool = Boolean.valueOf(bVar2.GhM);
        } else {
            bool = null;
        }
        StringBuilder append3 = append2.append(bool).append(' ').append("downloadUrl:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.Ghy;
        if (aVar2 != null) {
            str = aVar2.url;
        }
        Log.i(str2, append3.append(str).append(' ').append(dFm()).toString());
        if (asa() || dFr()) {
            Log.i(this.TAG, "prepareVideo return for state:" + this.currentPlayState);
            AppMethodBeat.o(238715);
            return false;
        }
        C1836b bVar3 = this.GhA;
        if (bVar3 == null || (!bVar3.uTW && !bVar3.GhM && (((aVar = this.Ghy) == null || !aVar.dLQ) && !this.GhJ))) {
            AppMethodBeat.o(238715);
            return false;
        }
        Log.i(this.TAG, "real prepare player");
        a aVar3 = this.wdC;
        if (aVar3 != null) {
            aVar3.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, false));
        }
        a aVar4 = this.wdC;
        if (aVar4 != null) {
            aVar4.enableTPAssetResourceLoader(bVar3);
        }
        a aVar5 = this.wdC;
        if (aVar5 != null) {
            aVar5.prepareAsync();
        }
        AppMethodBeat.o(238715);
        return true;
    }

    private final void dFn() {
        AppMethodBeat.i(238716);
        Log.i(this.TAG, "realPlay()");
        a aVar = this.wdC;
        if (aVar != null) {
            aVar.start();
            AppMethodBeat.o(238716);
            return;
        }
        AppMethodBeat.o(238716);
    }

    private final void dFo() {
        String str;
        AppMethodBeat.i(238717);
        if (this.wdU) {
            Log.i(this.TAG, "startCdnDownload() already start cdn " + dFm());
            AppMethodBeat.o(238717);
            return;
        }
        C1836b bVar = this.GhA;
        com.tencent.mm.plugin.thumbplayer.d.a aVar = this.Ghy;
        if (!(bVar == null || aVar == null)) {
            if (bVar.GhM || aVar.dLQ || this.GhJ) {
                Log.i(this.TAG, "local file or complete or fromExternResourceLoader");
            } else {
                Log.i(this.TAG, "startCdnDownload");
                com.tencent.mm.plugin.thumbplayer.b.a cdnTaskController = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
                String str2 = aVar.mediaId;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                cdnTaskController.a(str, new e(this), new f(this));
                this.wdU = true;
                AppMethodBeat.o(238717);
                return;
            }
        }
        AppMethodBeat.o(238717);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-thumbplayer_release"})
    public static final class e implements com.tencent.mm.plugin.thumbplayer.b.b {
        final /* synthetic */ b GhQ;

        e(b bVar) {
            this.GhQ = bVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.b
        public final com.tencent.mm.i.h awH(String str) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Integer num;
            AppMethodBeat.i(238699);
            p.h(str, "id");
            b bVar = this.GhQ;
            com.tencent.mm.plugin.thumbplayer.a aVar = com.tencent.mm.plugin.thumbplayer.a.Ggt;
            com.tencent.mm.plugin.thumbplayer.d.a aVar2 = bVar.Ghy;
            if (aVar2 == null || (str2 = aVar2.mediaId) == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar3 = bVar.Ghy;
            if (aVar3 == null || (str3 = aVar3.url) == null) {
                str3 = "";
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar4 = bVar.Ghy;
            if (aVar4 == null || (str4 = aVar4.path) == null) {
                str4 = "";
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar5 = bVar.Ghy;
            int intValue = (aVar5 == null || (num = aVar5.Ghr) == null) ? 2 : num.intValue();
            com.tencent.mm.plugin.thumbplayer.d.a aVar6 = bVar.Ghy;
            if (aVar6 == null || (str5 = aVar6.viB) == null) {
                str5 = "";
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar7 = bVar.Ghy;
            if (aVar7 == null || (str6 = aVar7.decodeKey) == null) {
                str6 = "";
            }
            com.tencent.mm.i.h a2 = com.tencent.mm.plugin.thumbplayer.a.a(str2, str3, str4, intValue, "xV2", str5, str6, bVar.GhA, bVar.TAG);
            AppMethodBeat.o(238699);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-thumbplayer_release"})
    public static final class f implements com.tencent.mm.plugin.thumbplayer.b.e {
        final /* synthetic */ b GhQ;

        f(b bVar) {
            this.GhQ = bVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.e
        public final void JS(int i2) {
            AppMethodBeat.i(238700);
            Log.i(this.GhQ.TAG, "startCdnDownload()#onStart " + this.GhQ.dFm() + ' ' + i2);
            if (i2 == 0) {
                b.e(this.GhQ);
                AppMethodBeat.o(238700);
                return;
            }
            if (i2 == 1) {
                C1836b bVar = this.GhQ.GhA;
                if (bVar != null) {
                    bVar.GhM = true;
                }
                C1836b bVar2 = this.GhQ.GhA;
                if (bVar2 != null) {
                    bVar2.uTW = true;
                }
                b.a(this.GhQ, 4);
            }
            AppMethodBeat.o(238700);
        }
    }

    public final void dFp() {
        String str;
        String str2;
        AppMethodBeat.i(238718);
        if (!this.wdU) {
            Log.i(this.TAG, "stopCdnDownload() not start cdn " + dFm());
            AppMethodBeat.o(238718);
            return;
        }
        Log.i(this.TAG, "stopCdnDownload");
        com.tencent.mm.plugin.thumbplayer.b.a cdnTaskController = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
        com.tencent.mm.plugin.thumbplayer.d.a aVar = this.Ghy;
        if (aVar == null || (str2 = aVar.mediaId) == null) {
            str = "";
        } else {
            str = str2;
        }
        cdnTaskController.a(str, new i(this));
        this.wdU = false;
        C1836b bVar = this.GhA;
        if (bVar != null) {
            bVar.GhN = false;
            AppMethodBeat.o(238718);
            return;
        }
        AppMethodBeat.o(238718);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$stopCdnDownload$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-thumbplayer_release"})
    public static final class i implements com.tencent.mm.plugin.thumbplayer.b.g {
        final /* synthetic */ b GhQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(b bVar) {
            this.GhQ = bVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.g
        public final void a(int i2, com.tencent.mm.i.h hVar, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(238703);
            Log.i(this.GhQ.TAG, "stopCdnDownload()#onStop(), real cancel download task " + this.GhQ.dFm() + ' ' + i2);
            AppMethodBeat.o(238703);
        }
    }

    public final void fwX() {
        AppMethodBeat.i(238719);
        Log.i(this.TAG, "updateIsReaStartDownloader() isReaStartDownloader:true");
        this.wdQ.set(true);
        AppMethodBeat.o(238719);
    }

    public final void stop() {
        com.tencent.mm.plugin.thumbplayer.d.a aVar;
        AppMethodBeat.i(238720);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("stop() ").append(dFm()).append(", fromExternResourceLoader:").append(this.GhJ).append(", isLocal:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.Ghy;
        Log.i(str, append.append(aVar2 != null ? Boolean.valueOf(aVar2.dLQ) : null).toString());
        if (!fwV()) {
            Log.i(this.TAG, "stop() return for isStartPlay. " + dFm());
            AppMethodBeat.o(238720);
            return;
        }
        dFs();
        this.GhD = null;
        this.VfP = null;
        this.GhK = -1;
        a aVar3 = this.wdC;
        if (aVar3 != null) {
            aVar3.stop();
        }
        a aVar4 = this.wdC;
        if (aVar4 != null) {
            aVar4.reset();
        }
        if (this.GhJ || (aVar = this.Ghy) == null || aVar.dLQ) {
            this.wdU = false;
        } else {
            dFp();
        }
        Log.i(this.TAG, "stop() end " + dFm());
        AppMethodBeat.o(238720);
    }

    public final void stopAsync() {
        AppMethodBeat.i(238721);
        Log.i(this.TAG, "stopAsync() " + dFm());
        this.VfQ.stop();
        com.tencent.mm.ac.d.c("TP.Player", new h(this));
        AppMethodBeat.o(238721);
    }

    public final void recycle() {
        AppMethodBeat.i(238722);
        Log.i(this.TAG, "recycle " + dFm());
        b(null, false);
        com.tencent.mm.ac.d.c("TP.Player", new d(this));
        dFs();
        Timer timer = this.GhF;
        if (timer != null) {
            timer.cancel();
        }
        this.GhF = null;
        this.VfP = null;
        AppMethodBeat.o(238722);
    }

    public static /* synthetic */ void a(b bVar, Surface surface) {
        AppMethodBeat.i(238724);
        bVar.b(surface, false);
        AppMethodBeat.o(238724);
    }

    public final void b(Surface surface, boolean z) {
        AppMethodBeat.i(238723);
        Log.i(this.TAG, "setSurface() surface:" + (surface != null ? Integer.valueOf(surface.hashCode()) : null) + ' ' + dFm());
        a aVar = this.wdC;
        if (aVar != null) {
            aVar.setSurface(surface);
        }
        if (z) {
            Mc(1);
        }
        AppMethodBeat.o(238723);
    }

    private final void fwY() {
        AppMethodBeat.i(238725);
        long j2 = this.GhH;
        long j3 = this.wbl;
        boolean z = (0 <= j3 && j2 > j3) || this.GhD != null;
        if (z && this.GhF == null) {
            this.GhF = new Timer(this.TAG + "-progress");
            if (isPlaying()) {
                fxa();
                AppMethodBeat.o(238725);
                return;
            }
        } else if (!z) {
            dFs();
            Timer timer = this.GhF;
            if (timer != null) {
                timer.cancel();
            }
            this.GhF = null;
        }
        AppMethodBeat.o(238725);
    }

    private final void fwZ() {
        long j2;
        a aVar;
        AppMethodBeat.i(238726);
        a aVar2 = this.wdC;
        if (aVar2 != null) {
            j2 = aVar2.getCurrentPositionMs();
        } else {
            j2 = 0;
        }
        long j3 = this.GhH;
        long j4 = this.wbl;
        if (0 > j4) {
            AppMethodBeat.o(238726);
            return;
        }
        if (j3 > j4) {
            long j5 = this.wbl;
            long j6 = this.GhH;
            if ((j5 > j2 || j6 <= j2) && (aVar = this.wdC) != null) {
                aVar.seekTo((int) this.wbl, 3);
                AppMethodBeat.o(238726);
                return;
            }
        }
        AppMethodBeat.o(238726);
    }

    private final void fxa() {
        AppMethodBeat.i(238727);
        Log.i(this.TAG, "startProgressTimer " + dFm());
        this.GhG = new g(this);
        Timer timer = this.GhF;
        if (timer != null) {
            timer.schedule(this.GhG, this.GhE, this.GhE);
            AppMethodBeat.o(238727);
            return;
        }
        AppMethodBeat.o(238727);
    }

    public final long getCurrentPositionMs() {
        AppMethodBeat.i(260009);
        a aVar = this.wdC;
        if (aVar != null) {
            long currentPositionMs = aVar.getCurrentPositionMs();
            AppMethodBeat.o(260009);
            return currentPositionMs;
        }
        AppMethodBeat.o(260009);
        return 0;
    }

    public final void dFs() {
        AppMethodBeat.i(238728);
        Log.i(this.TAG, "stopProgressTimer " + dFm());
        TimerTask timerTask = this.GhG;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.GhG = null;
        AppMethodBeat.o(238728);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010'\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016J$\u0010*\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001c\u0010.\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J,\u00100\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u00102\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J*\u00104\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016J*\u00105\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0016J\u0006\u00108\u001a\u00020\u0018J\"\u00109\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0004H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "mediaId", "", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;Ljava/lang/String;)V", "MAX_REQUETS_LENGTH", "", "getMAX_REQUETS_LENGTH", "()J", "isAllComplete", "", "()Z", "setAllComplete", "(Z)V", "isMoovReady", "setMoovReady", "isRequestingData", "setRequestingData", "getMediaId", "()Ljava/lang/String;", "onAllComplete", "Lkotlin/Function2;", "", "", "getOnAllComplete", "()Lkotlin/jvm/functions/Function2;", "setOnAllComplete", "(Lkotlin/jvm/functions/Function2;)V", "requestNumber", "getRequestNumber", "()I", "setRequestNumber", "(I)V", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "offset", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopCdnDownload", "onStopReadData", "requestId", "resourceInfo", "plugin-thumbplayer_release"})
    /* renamed from: com.tencent.mm.plugin.thumbplayer.e.b$b  reason: collision with other inner class name */
    public final class C1836b extends h.a.a.a.a.a.a.a.a.a.a.a implements h.a {
        public boolean GhM;
        boolean GhN;
        public m<? super String, ? super Integer, x> GhO;
        private final long GhP = 1048576;
        final /* synthetic */ b GhQ;
        public final String mediaId;
        public boolean uTW;
        private int wed;

        public C1836b(b bVar, String str) {
            p.h(str, "mediaId");
            this.GhQ = bVar;
            AppMethodBeat.i(238693);
            this.mediaId = str;
            AppMethodBeat.o(238693);
        }

        private final String fxb() {
            AppMethodBeat.i(238682);
            String str = this.GhQ.dFm() + " isMoovReady:" + this.uTW + " isAllComplete:" + this.GhM + " isRequestingData:" + this.GhN;
            AppMethodBeat.o(238682);
            return str;
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, long j2, long j3, String str2) {
            AppMethodBeat.i(238683);
            this.uTW = true;
            b.a(this.GhQ, 2);
            AppMethodBeat.o(238683);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            AppMethodBeat.i(238684);
            Log.i(this.GhQ.TAG, "onDataAvailable mediaId:" + str + " offset:" + j2 + ' ' + fxb());
            this.GhN = false;
            AppMethodBeat.o(238684);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            AppMethodBeat.i(238685);
            Log.i(this.GhQ.TAG, "onProgress mediaId:" + str + " offset:" + j2 + " total:" + j3 + ' ' + fxb());
            AppMethodBeat.o(238685);
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(238686);
            this.GhM = true;
            m<? super String, ? super Integer, x> mVar = this.GhO;
            if (mVar != null) {
                mVar.invoke(str, Integer.valueOf(i2));
                AppMethodBeat.o(238686);
                return;
            }
            AppMethodBeat.o(238686);
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final long getDataTotalSize(int i2, String str) {
            String str2;
            AppMethodBeat.i(238687);
            com.tencent.mm.plugin.thumbplayer.d.a aVar = this.GhQ.Ghy;
            if (aVar != null) {
                str2 = aVar.path;
            } else {
                str2 = null;
            }
            long boW = s.boW(str2);
            Log.i(this.GhQ.TAG, "getDataTotalSize() fileId:" + i2 + ", fileKey:" + str + " fileLength:" + boW + ' ' + fxb());
            AppMethodBeat.o(238687);
            return boW;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int k(int i2, long j2, long j3) {
            long min;
            AppMethodBeat.i(238688);
            if (this.GhM) {
                min = j3;
            } else {
                long[] jArr = new long[2];
                min = (CdnLogic.queryContinuousSize(this.mediaId, j2, jArr) != 0 || jArr[0] <= 0) ? 0 : Math.min(jArr[0], j3);
            }
            if (min == 0 && !this.GhN && this.uTW && this.GhQ.wdU) {
                long aN = j.aN(j3, this.GhP);
                int a2 = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int) j2, (int) aN, new a(this, aN));
                if (a2 > 0) {
                    this.GhN = true;
                }
                Log.i(this.GhQ.TAG, "requestVideoData requestDataRet:" + a2 + " requestLength:" + aN);
            }
            if (min > 0) {
                Log.i(this.GhQ.TAG, "onReadData() offset:" + j2 + " length:" + j3 + " returnLength:" + min + ' ' + fxb());
            } else {
                Log.d(this.GhQ.TAG, "onReadData() offset:" + j2 + " length:" + j3 + ' ' + fxb());
            }
            int i3 = (int) min;
            AppMethodBeat.o(238688);
            return i3;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-thumbplayer_release"})
        /* renamed from: com.tencent.mm.plugin.thumbplayer.e.b$b$a */
        public static final class a implements com.tencent.mm.plugin.thumbplayer.b.c {
            final /* synthetic */ C1836b GhR;
            final /* synthetic */ long GhS;

            a(C1836b bVar, long j2) {
                this.GhR = bVar;
                this.GhS = j2;
            }

            @Override // com.tencent.mm.plugin.thumbplayer.b.c
            public final void Mg(int i2) {
                AppMethodBeat.i(238681);
                if (i2 != 0) {
                    Log.w(this.GhR.GhQ.TAG, "requestedResource() requestVideoData fail, ret:" + i2 + ' ' + this);
                    this.GhR.GhN = false;
                    AppMethodBeat.o(238681);
                    return;
                }
                Log.i(this.GhR.GhQ.TAG, "requestVideoData requestDataRet:" + i2 + " requestLength:" + this.GhS);
                AppMethodBeat.o(238681);
            }
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final String Mf(int i2) {
            String str;
            AppMethodBeat.i(238689);
            com.tencent.mm.plugin.thumbplayer.d.a aVar = this.GhQ.Ghy;
            if (aVar == null || (str = aVar.path) == null) {
                str = "";
            }
            String k = s.k(str, false);
            AppMethodBeat.o(238689);
            return k;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final String getContentType(int i2, String str) {
            AppMethodBeat.i(238690);
            Log.i(this.GhQ.TAG, "getContentType() fileId:" + i2 + ", fileKey:" + str + " contentType:" + "video/mp4" + ' ' + fxb());
            AppMethodBeat.o(238690);
            return "video/mp4";
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int onStartReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(238691);
            Log.i(this.GhQ.TAG, "onStartReadData() fileId:" + i2 + ", fileKey:" + str + " requestStart:" + j2 + " requestEnd:" + j3 + ' ' + fxb());
            int i3 = this.wed;
            this.wed = i3 + 1;
            AppMethodBeat.o(238691);
            return i3;
        }

        @Override // com.tencent.thumbplayer.e.a.a
        public final int onStopReadData(int i2, String str, int i3) {
            AppMethodBeat.i(238692);
            Log.i(this.GhQ.TAG, "onStopReadData() fileId:" + i2 + ", fileKey:" + str + " requestId:" + i3 + ' ' + fxb());
            int i4 = this.wed;
            AppMethodBeat.o(238692);
            return i4;
        }
    }

    public final String dFm() {
        String str;
        Long l = null;
        AppMethodBeat.i(238729);
        StringBuilder sb = new StringBuilder("mediaId:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar = this.Ghy;
        if (aVar != null) {
            str = aVar.mediaId;
        } else {
            str = null;
        }
        StringBuilder append = sb.append(str).append(" isViewFocused:").append(this.wcA).append(" width:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.Ghy;
        StringBuilder append2 = append.append(aVar2 != null ? Integer.valueOf(aVar2.width) : null).append(" height:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar3 = this.Ghy;
        StringBuilder append3 = append2.append(aVar3 != null ? Integer.valueOf(aVar3.height) : null).append(" duration:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar4 = this.Ghy;
        StringBuilder append4 = append3.append(aVar4 != null ? Long.valueOf(aVar4.pLQ) : null).append(", timeOffset:");
        com.tencent.mm.plugin.thumbplayer.d.a aVar5 = this.Ghy;
        if (aVar5 != null) {
            l = Long.valueOf(aVar5.Ghw);
        }
        String sb2 = append4.append(l).toString();
        AppMethodBeat.o(238729);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b GhQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar) {
            super(0);
            this.GhQ = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238702);
            this.GhQ.stop();
            x xVar = x.SXb;
            AppMethodBeat.o(238702);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b GhQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.GhQ = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238698);
            a aVar = this.GhQ.wdC;
            if (aVar != null) {
                aVar.release();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238698);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(b bVar, ITPPlayer iTPPlayer) {
        AppMethodBeat.i(260010);
        kotlin.g.a.b<? super ITPPlayer, x> bVar2 = bVar.VfO;
        if (bVar2 != null) {
            bVar2.invoke(iTPPlayer);
            AppMethodBeat.o(260010);
            return;
        }
        AppMethodBeat.o(260010);
    }
}
