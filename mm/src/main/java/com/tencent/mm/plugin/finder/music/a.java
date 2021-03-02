package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.a.k;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u001cH\u0016J\u001c\u0010\u001f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010 2\b\u0010\u001b\u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010\"\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010#2\b\u0010\u001b\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010%\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020\u0010J\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "getContext", "()Landroid/content/Context;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "initPlayer", "", "isPlaying", "", "onLoadingChanged", "isLoading", "onPlaybackParametersChanged", "p0", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "pause", AssetExtension.SCENE_PLAY, "release", "stop", "Companion", "plugin-finder_release"})
public final class a implements q.a {
    public static final C1235a uPB = new C1235a((byte) 0);
    private final Context context;
    private v hWJ;
    private azk musicInfo;

    static {
        AppMethodBeat.i(248927);
        AppMethodBeat.o(248927);
    }

    public a(Context context2, azk azk) {
        p.h(context2, "context");
        p.h(azk, "musicInfo");
        AppMethodBeat.i(248926);
        this.context = context2;
        this.musicInfo = azk;
        dlb();
        AppMethodBeat.o(248926);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.music.a$a  reason: collision with other inner class name */
    public static final class C1235a {
        private C1235a() {
        }

        public /* synthetic */ C1235a(byte b2) {
            this();
        }
    }

    private final void dlb() {
        AppMethodBeat.i(248918);
        if (this.hWJ == null) {
            Log.i("FinderImgFeedMusicPlayer", "init musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
            this.hWJ = g.a(this.context, new c());
            n nVar = new n(this.context, x.h(this.context, "Finder.Player"), new com.google.android.exoplayer2.h.l());
            al alVar = al.waC;
            com.google.android.exoplayer2.h.a.l lVar = new com.google.android.exoplayer2.h.a.l(new File(com.tencent.mm.b.q.k(al.c(this.musicInfo), true)), new k(5242880));
            i iVar = new i(new h(Uri.parse(this.musicInfo.LJi), new e(lVar, nVar), new com.google.android.exoplayer2.c.c(), null, null));
            v vVar = this.hWJ;
            if (vVar != null) {
                vVar.a(this);
            }
            v vVar2 = this.hWJ;
            if (vVar2 != null) {
                vVar2.a(iVar);
                AppMethodBeat.o(248918);
                return;
            }
        }
        AppMethodBeat.o(248918);
    }

    public final void play() {
        AppMethodBeat.i(248919);
        dlb();
        Log.i("FinderImgFeedMusicPlayer", "play musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
        v vVar = this.hWJ;
        if (vVar != null) {
            vVar.aO(true);
            AppMethodBeat.o(248919);
            return;
        }
        AppMethodBeat.o(248919);
    }

    public final void pause() {
        AppMethodBeat.i(248920);
        if (isPlaying()) {
            Log.i("FinderImgFeedMusicPlayer", "pause musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name + ",musicInfo:" + this.musicInfo);
            v vVar = this.hWJ;
            if (vVar != null) {
                vVar.aO(false);
                AppMethodBeat.o(248920);
                return;
            }
            AppMethodBeat.o(248920);
            return;
        }
        Log.i("FinderImgFeedMusicPlayer", "pause musicInfo:" + this.musicInfo + " failed, cause it is not playing");
        AppMethodBeat.o(248920);
    }

    public final void release() {
        v vVar;
        AppMethodBeat.i(248921);
        Log.i("FinderImgFeedMusicPlayer", "relsese musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
        Log.i("FinderImgFeedMusicPlayer", "stop musicId:" + this.musicInfo.wWb + ",musicName:" + this.musicInfo.name);
        if (isPlaying() && (vVar = this.hWJ) != null) {
            vVar.stop();
        }
        v vVar2 = this.hWJ;
        if (vVar2 != null) {
            vVar2.release();
        }
        this.hWJ = null;
        AppMethodBeat.o(248921);
    }

    public final boolean isPlaying() {
        boolean z;
        v vVar;
        v vVar2;
        v vVar3;
        AppMethodBeat.i(248922);
        StringBuilder sb = new StringBuilder("[isPlaying] state:");
        v vVar4 = this.hWJ;
        Log.i("FinderImgFeedMusicPlayer", sb.append(vVar4 != null ? Integer.valueOf(vVar4.ti()) : null).toString());
        v vVar5 = this.hWJ;
        if (vVar5 != null) {
            z = vVar5.tj();
        } else {
            z = false;
        }
        if (!z || (((vVar = this.hWJ) == null || vVar.ti() != 3) && (((vVar2 = this.hWJ) == null || vVar2.ti() != 2) && ((vVar3 = this.hWJ) == null || vVar3.ti() != 1)))) {
            AppMethodBeat.o(248922);
            return false;
        }
        AppMethodBeat.o(248922);
        return true;
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void b(com.google.android.exoplayer2.p pVar) {
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void tz() {
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void a(com.google.android.exoplayer2.e eVar) {
        Integer num;
        Throwable th = null;
        AppMethodBeat.i(248923);
        StringBuilder sb = new StringBuilder("[onPlayerError] type:");
        if (eVar != null) {
            num = Integer.valueOf(eVar.type);
        } else {
            num = null;
        }
        StringBuilder append = sb.append(num).append(" , message:").append(eVar != null ? eVar.getMessage() : null).append(" ,cause:");
        if (eVar != null) {
            th = eVar.getCause();
        }
        Log.i("FinderImgFeedMusicPlayer", append.append(th).toString());
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1530, 4, 1);
        AppMethodBeat.o(248923);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void c(boolean z, int i2) {
        AppMethodBeat.i(248924);
        Log.i("FinderImgFeedMusicPlayer", "[onPlayerStateChanged] playWhenReady:" + z + " ,state:" + i2);
        AppMethodBeat.o(248924);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void aR(boolean z) {
        AppMethodBeat.i(248925);
        Log.i("FinderImgFeedMusicPlayer", "[onLoadingChanged] isLoading:".concat(String.valueOf(z)));
        AppMethodBeat.o(248925);
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void tA() {
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void aA(int i2) {
    }

    @Override // com.google.android.exoplayer2.q.a
    public final void ty() {
    }
}
