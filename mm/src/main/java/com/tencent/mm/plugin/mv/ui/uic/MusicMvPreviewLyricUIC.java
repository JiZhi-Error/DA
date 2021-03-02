package com.tencent.mm.plugin.mv.ui.uic;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.ui.LyricView;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lyricView", "Lcom/tencent/mm/plugin/music/ui/LyricView;", "getLyricView", "()Lcom/tencent/mm/plugin/music/ui/LyricView;", "setLyricView", "(Lcom/tencent/mm/plugin/music/ui/LyricView;)V", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "initBgLyric", "", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvPreviewLyricUIC extends UIComponent {
    private final d.a AhI = new a(this);
    public LyricView Anv;
    public axy Aqo;
    private final String TAG = "MicroMsg.Mv.MusicMvPreviewLyricUIC";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvPreviewLyricUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257330);
        AppMethodBeat.o(257330);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(257328);
        k euj = k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().b(this.AhI);
        AppMethodBeat.o(257328);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(257329);
        k euj = k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        euj.etW().c(this.AhI);
        AppMethodBeat.o(257329);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
    static final class a implements d.a {
        final /* synthetic */ MusicMvPreviewLyricUIC AvB;

        a(MusicMvPreviewLyricUIC musicMvPreviewLyricUIC) {
            this.AvB = musicMvPreviewLyricUIC;
        }

        @Override // com.tencent.mm.plugin.music.f.a.d.a
        public final void fn(final int i2, final int i3) {
            AppMethodBeat.i(257327);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewLyricUIC.a.AnonymousClass1 */
                final /* synthetic */ a AvC;

                {
                    this.AvC = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    LyricView lyricView;
                    AppMethodBeat.i(257326);
                    if (i2 >= 0 && i3 >= 0 && (lyricView = this.AvC.AvB.Anv) != null) {
                        lyricView.setCurrentTime((long) i2);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(257326);
                    return xVar;
                }
            });
            AppMethodBeat.o(257327);
        }
    }
}
