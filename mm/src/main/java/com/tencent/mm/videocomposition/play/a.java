package com.tencent.mm.videocomposition.play;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.n;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.Callback;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVSource;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010!\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bH\u0002J \u0010$\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010'\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\bJ$\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010-H\u0002J\u0006\u00100\u001a\u00020 J\u0006\u00101\u001a\u00020 J\u0006\u00102\u001a\u00020 J\u000e\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\bJ\u0016\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006J\u0010\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010<\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u0015J\u001e\u0010=\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bJ\u001e\u0010>\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bJ\u0006\u00108\u001a\u00020 J\u0006\u0010?\u001a\u00020 J,\u0010@\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\b2\b\b\u0002\u00103\u001a\u00020\u0006J\b\u0010B\u001a\u00020 H\u0002J\u0016\u0010C\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bJ\u0006\u0010D\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "flushSurfaceTick", "", "hasPlaySurface", "", "isLoop", "isStarted", "isUpdatingComposition", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceWidth", "createPlayer", "", "createPlayerLayerBySurface", "width", "height", "createPlayerLayerBySurfaceTexture", "currentPositionTimeMs", "getLaggingTime", "initPlayerCallback", "isPlaying", "muteOrigin", "mute", "normalUpdateComposition", "newPosition", "Lcom/tencent/tav/coremedia/CMTime;", "playAfterUpdate", "originPosition", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setProfileCallback", "setSurface", "setSurfaceTexture", "stop", "updateComposition", "seekToOriginPosition", "updateCompositionByRecreatePlayer", "updateDisplaySize", "videoDurationMs", "Companion", "video_composition_release"})
public final class a {
    public static final C2159a RhL = new C2159a((byte) 0);
    private n Gez;
    public C2159a.c RhE;
    private TAVSource RhG = this.Gez.buildSource();
    private C2159a.AbstractC2160a RhH;
    public boolean RhI;
    private boolean RhJ;
    private long RhK;
    private boolean isStarted;
    private boolean jqj;
    Player player;
    PlayerItem playerItem = new PlayerItem(this.RhG.getAsset());
    private PlayerLayer playerLayer;
    private int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    private int surfaceWidth;

    static {
        AppMethodBeat.i(216842);
        AppMethodBeat.o(216842);
    }

    public a(n nVar) {
        Player player2;
        p.h(nVar, "composition");
        AppMethodBeat.i(216841);
        this.Gez = nVar;
        this.playerItem.setVideoComposition(this.RhG.getVideoComposition());
        this.playerItem.setAudioMix(this.RhG.getAudioMix());
        this.player = new Player(this.playerItem);
        Player player3 = this.player;
        if (player3 != null) {
            player3.setPlayRange(this.Gez.hfo());
        }
        if (this.Gez.QEl && (player2 = this.player) != null) {
            player2.setRate(-1.0f);
        }
        this.isStarted = false;
        this.RhJ = false;
        hfs();
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "create player, composition:" + this.Gez, new Object[0]);
        AppMethodBeat.o(216841);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion;", "", "()V", "TAG", "", "PlayerCallback", "PlayerFrameCallback", "PlayerProfileCallback", "video_composition_release"})
    /* renamed from: com.tencent.mm.videocomposition.play.a$a  reason: collision with other inner class name */
    public static final class C2159a {

        @l(hxD = {1, 1, 15}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_composition_release"})
        /* renamed from: com.tencent.mm.videocomposition.play.a$a$a  reason: collision with other inner class name */
        public interface AbstractC2160a {
            void Go(long j2);

            void dER();

            void dES();

            void dET();

            void dEU();

            void dEV();
        }

        @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "onFrame", "", "video_composition_release"})
        /* renamed from: com.tencent.mm.videocomposition.play.a$a$b */
        public interface b extends AbstractC2160a {
            void dEW();
        }

        @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "", "onSeek", "", "cost", "", "onUpdateComposition", "video_composition_release"})
        /* renamed from: com.tencent.mm.videocomposition.play.a$a$c */
        public interface c {
            void Lc(long j2);

            void Ld(long j2);
        }

        private C2159a() {
        }

        public /* synthetic */ C2159a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/videocomposition/play/VideoCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "video_composition_release"})
    public static final class b implements IPlayer.PlayerListener {
        final /* synthetic */ a RhM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.RhM = aVar;
        }

        @Override // com.tencent.tav.player.IPlayer.PlayerListener
        public final void onStatusChanged(IPlayer.PlayerStatus playerStatus) {
            C2159a.AbstractC2160a aVar;
            AppMethodBeat.i(216819);
            com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "onStatusChanged:".concat(String.valueOf(playerStatus)), new Object[0]);
            if (playerStatus == IPlayer.PlayerStatus.PLAYING) {
                C2159a.AbstractC2160a aVar2 = this.RhM.RhH;
                if (aVar2 != null) {
                    aVar2.dER();
                    AppMethodBeat.o(216819);
                    return;
                }
                AppMethodBeat.o(216819);
            } else if (playerStatus == IPlayer.PlayerStatus.STOPPED) {
                C2159a.AbstractC2160a aVar3 = this.RhM.RhH;
                if (aVar3 != null) {
                    aVar3.dES();
                    AppMethodBeat.o(216819);
                    return;
                }
                AppMethodBeat.o(216819);
            } else if (playerStatus == IPlayer.PlayerStatus.FINISHED) {
                C2159a.AbstractC2160a aVar4 = this.RhM.RhH;
                if (aVar4 != null) {
                    aVar4.dET();
                    AppMethodBeat.o(216819);
                    return;
                }
                AppMethodBeat.o(216819);
            } else if (playerStatus != IPlayer.PlayerStatus.ERROR || (aVar = this.RhM.RhH) == null) {
                AppMethodBeat.o(216819);
            } else {
                aVar.dEV();
                AppMethodBeat.o(216819);
            }
        }

        @Override // com.tencent.tav.player.IPlayer.PlayerListener
        public final void onPositionChanged(CMTime cMTime) {
            C2159a.AbstractC2160a aVar;
            AppMethodBeat.i(216820);
            C2159a.AbstractC2160a aVar2 = this.RhM.RhH;
            if (aVar2 != null) {
                aVar2.Go((cMTime != null ? cMTime.getTimeUs() : 0) / 1000);
            }
            if (cMTime == null) {
                AppMethodBeat.o(216820);
            } else if (cMTime.getTimeUs() != this.RhM.Gez.hfo().getStartUs() || (aVar = this.RhM.RhH) == null) {
                AppMethodBeat.o(216820);
            } else {
                aVar.dER();
                AppMethodBeat.o(216820);
            }
        }
    }

    private final void hfs() {
        AppMethodBeat.i(216823);
        Player player2 = this.player;
        if (player2 != null) {
            player2.setPlayerListener(new b(this));
            AppMethodBeat.o(216823);
            return;
        }
        AppMethodBeat.o(216823);
    }

    public static /* synthetic */ void a(a aVar, n nVar, boolean z, long j2, int i2) {
        AppMethodBeat.i(216825);
        aVar.a(nVar, (i2 & 2) != 0 ? false : z, false, (i2 & 8) != 0 ? -1 : j2);
        AppMethodBeat.o(216825);
    }

    public final void a(n nVar, boolean z, boolean z2, long j2) {
        CMTime cMTime;
        AppMethodBeat.i(216824);
        p.h(nVar, "composition");
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "updateComposition, surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", playAfterUpdate:" + z + ", seekToOriginPosition:" + z2 + ", seekTo:" + j2 + ", isStarted:" + this.isStarted, new Object[0]);
        this.RhG = nVar.buildSource();
        this.playerItem = new PlayerItem(this.RhG.getAsset());
        this.playerItem.setVideoComposition(this.RhG.getVideoComposition());
        this.playerItem.setAudioMix(this.RhG.getAudioMix());
        this.Gez = nVar;
        Player player2 = this.player;
        CMTime position = player2 != null ? player2.position() : null;
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "updateComposition, originPosition:".concat(String.valueOf(position)), new Object[0]);
        if (j2 != -1) {
            cMTime = new CMTime(j2, 1000);
        } else if (z2) {
            cMTime = position;
        } else {
            cMTime = CMTime.CMTimeZero;
        }
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "updateComposition, originPosition:" + position + ", newPosition:" + cMTime, new Object[0]);
        a(cMTime, z, position);
        AppMethodBeat.o(216824);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
    public static final class c implements OnCompositionUpdateListener {
        final /* synthetic */ a RhM;
        final /* synthetic */ long RhN;
        final /* synthetic */ CMTime RhO;
        final /* synthetic */ CMTime RhP;
        final /* synthetic */ boolean RhQ;
        final /* synthetic */ long iiX;

        c(a aVar, long j2, CMTime cMTime, long j3, CMTime cMTime2, boolean z) {
            this.RhM = aVar;
            this.RhN = j2;
            this.RhO = cMTime;
            this.iiX = j3;
            this.RhP = cMTime2;
            this.RhQ = z;
        }

        @Override // com.tencent.tav.player.OnCompositionUpdateListener
        public final void onUpdated(Player player, boolean z) {
            AppMethodBeat.i(216821);
            long currentTimeMillis = System.currentTimeMillis() - this.RhN;
            C2159a.c cVar = this.RhM.RhE;
            if (cVar != null) {
                cVar.Lc(currentTimeMillis);
            }
            StringBuilder append = new StringBuilder("on composition update, success:").append(z).append(", position:");
            CMTime position = player.position();
            p.g(position, "player.position()");
            com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", append.append(position.getTimeUs() / 1000).append(", originPosition:").append(this.RhO).append(", isStarted:").append(this.RhM.isStarted).append(", cost:").append(SystemClock.elapsedRealtime() - this.iiX).toString(), new Object[0]);
            if (player != null) {
                player.seekToTime(this.RhP);
            }
            if ((this.RhQ || this.RhM.isStarted) && player != null) {
                player.play();
            }
            this.RhM.RhJ = false;
            AppMethodBeat.o(216821);
        }
    }

    public final void at(long j2, long j3) {
        AppMethodBeat.i(216827);
        Player player2 = this.player;
        if (player2 != null) {
            player2.setPlayRange(new CMTimeRange(new CMTime(j2, 1000), new CMTime(j3 - j2, 1000)));
            AppMethodBeat.o(216827);
            return;
        }
        AppMethodBeat.o(216827);
    }

    public final void DB(boolean z) {
        AppMethodBeat.i(216828);
        Player player2 = this.player;
        if (player2 != null) {
            player2.setVolume(z ? 0.0f : 1.0f);
            AppMethodBeat.o(216828);
            return;
        }
        AppMethodBeat.o(216828);
    }

    public final void setPlayerCallback(C2159a.AbstractC2160a aVar) {
        AppMethodBeat.i(216829);
        this.RhH = aVar;
        hfs();
        AppMethodBeat.o(216829);
    }

    public final void c(SurfaceTexture surfaceTexture2, int i2, int i3) {
        AppMethodBeat.i(216830);
        p.h(surfaceTexture2, "surfaceTexture");
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        this.surfaceTexture = surfaceTexture2;
        d(surfaceTexture2, i2, i3);
        this.RhI = true;
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "setSurfaceTexture: " + surfaceTexture2 + ", width:" + i2 + ", height:" + i3, new Object[0]);
        AppMethodBeat.o(216830);
    }

    private final void d(SurfaceTexture surfaceTexture2, int i2, int i3) {
        AppMethodBeat.i(216831);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "createPlayerLayerBySurfaceTexture: " + surfaceTexture2 + ", size:[" + i2 + ", " + i3 + ']', new Object[0]);
        this.playerLayer = new PlayerLayer(surfaceTexture2, i2, i3);
        PlayerLayer playerLayer2 = this.playerLayer;
        if (playerLayer2 != null) {
            playerLayer2.setPlayer(this.player);
            AppMethodBeat.o(216831);
            return;
        }
        AppMethodBeat.o(216831);
    }

    public final void lX(int i2, int i3) {
        AppMethodBeat.i(216832);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "updateDisplaySize:[" + i2 + ", " + i3 + ']', new Object[0]);
        Player player2 = this.player;
        if (player2 != null) {
            player2.updateViewport(i2, i3);
            AppMethodBeat.o(216832);
            return;
        }
        AppMethodBeat.o(216832);
    }

    public final void start() {
        Player player2;
        AppMethodBeat.i(216833);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "start, isUpdatingComposition:" + this.RhJ, new Object[0]);
        if (!this.RhJ && (player2 = this.player) != null) {
            player2.play();
        }
        this.isStarted = true;
        AppMethodBeat.o(216833);
    }

    public final void pause() {
        AppMethodBeat.i(216834);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "pause", new Object[0]);
        Player player2 = this.player;
        if (player2 != null) {
            player2.pause();
        }
        this.isStarted = false;
        AppMethodBeat.o(216834);
    }

    public final void stop() {
        AppMethodBeat.i(216835);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "stop", new Object[0]);
        Player player2 = this.player;
        if (player2 != null) {
            player2.stop();
        }
        this.isStarted = false;
        AppMethodBeat.o(216835);
    }

    public final void release() {
        AppMethodBeat.i(216836);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "release", new Object[0]);
        Player player2 = this.player;
        if (player2 != null) {
            player2.release();
        }
        this.playerLayer = null;
        this.player = null;
        this.isStarted = false;
        AppMethodBeat.o(216836);
    }

    public final void seekTo(long j2) {
        AppMethodBeat.i(216837);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "seekTo:" + j2 + ", isUpdatingComposition:" + this.RhJ, new Object[0]);
        if (!this.RhJ) {
            long currentTimeMillis = System.currentTimeMillis();
            Player player2 = this.player;
            if (player2 != null) {
                player2.seekToTime(new CMTime(j2, 1000), new d(this, currentTimeMillis, j2));
                AppMethodBeat.o(216837);
                return;
            }
        }
        AppMethodBeat.o(216837);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "call"})
    static final class d implements Callback {
        final /* synthetic */ a RhM;
        final /* synthetic */ long RhN;
        final /* synthetic */ long wfK;

        d(a aVar, long j2, long j3) {
            this.RhM = aVar;
            this.RhN = j2;
            this.wfK = j3;
        }

        @Override // com.tencent.tav.player.Callback
        public final void call() {
            AppMethodBeat.i(216822);
            long currentTimeMillis = System.currentTimeMillis() - this.RhN;
            com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "seekTo:" + this.wfK + " completed", new Object[0]);
            C2159a.c cVar = this.RhM.RhE;
            if (cVar != null) {
                cVar.Ld(currentTimeMillis);
                AppMethodBeat.o(216822);
                return;
            }
            AppMethodBeat.o(216822);
        }
    }

    public final void setLoop(boolean z) {
        AppMethodBeat.i(216838);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "setLoop:".concat(String.valueOf(z)), new Object[0]);
        this.jqj = z;
        Player player2 = this.player;
        if (player2 != null) {
            player2.setLoop(z);
            AppMethodBeat.o(216838);
            return;
        }
        AppMethodBeat.o(216838);
    }

    public final void hft() {
        AppMethodBeat.i(216839);
        com.tencent.mm.videocomposition.c.b.i("VideoCompositionPlayer", "refreshSurface isStarted:" + this.isStarted, new Object[0]);
        if (!this.isStarted) {
            this.RhK = SystemClock.elapsedRealtime();
            Player player2 = this.player;
            if (player2 != null) {
                player2.refreshSurface(null);
                AppMethodBeat.o(216839);
                return;
            }
        }
        AppMethodBeat.o(216839);
    }

    public final long hfu() {
        CMTime currentTime;
        AppMethodBeat.i(216840);
        Player player2 = this.player;
        long timeUs = ((player2 == null || (currentTime = player2.currentTime()) == null) ? 0 : currentTime.getTimeUs()) / 1000;
        AppMethodBeat.o(216840);
        return timeUs;
    }

    private final void a(CMTime cMTime, boolean z, CMTime cMTime2) {
        AppMethodBeat.i(216826);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.RhJ = true;
        Player player2 = this.player;
        if (player2 != null) {
            player2.pause();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Player player3 = this.player;
        if (player3 != null) {
            player3.update(this.playerItem, cMTime, new c(this, currentTimeMillis, cMTime2, elapsedRealtime, cMTime, z));
        }
        Player player4 = this.player;
        if (player4 != null) {
            player4.setPlayRange(this.Gez.hfo());
            AppMethodBeat.o(216826);
            return;
        }
        AppMethodBeat.o(216826);
    }
}
