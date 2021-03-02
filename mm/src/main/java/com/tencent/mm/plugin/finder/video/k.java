package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicPlayerManager;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J$\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010E\u001a\u00020\rJ\u0006\u0010F\u001a\u00020<J\u000e\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "musicManager", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "getMusicManager", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "setMusicManager", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;)V", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;)V", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "onInitialize", "context", "Landroid/support/v7/app/AppCompatActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class k extends com.tencent.mm.plugin.finder.life.a implements o {
    public static final a weW = new a((byte) 0);
    private final int dLS;
    private RecyclerView hak;
    public FinderVideoRecycler weH;
    public FinderImgFeedMusicPlayerManager weI;
    r weR;
    public FinderVideoAutoPlayManager weS;
    public com.tencent.mm.plugin.finder.event.c weT;
    public MediaPreloadCore weU;
    public long weV;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
    public interface b {
        RecyclerView dch();

        DataBuffer<bo> dci();
    }

    static {
        AppMethodBeat.i(168046);
        AppMethodBeat.o(168046);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<r, Boolean> {
        public static final c weY = new c();

        static {
            AppMethodBeat.i(168037);
            AppMethodBeat.o(168037);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            AppMethodBeat.i(168036);
            p.h(rVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(168036);
            return bool;
        }
    }

    public /* synthetic */ k() {
        this(-1);
        AppMethodBeat.i(168045);
        AppMethodBeat.o(168045);
    }

    public k(int i2) {
        AppMethodBeat.i(254272);
        this.dLS = i2;
        this.weR = new r();
        AppMethodBeat.o(254272);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final FinderVideoRecycler dFx() {
        AppMethodBeat.i(254268);
        FinderVideoRecycler finderVideoRecycler = this.weH;
        if (finderVideoRecycler == null) {
            p.btv("recycler");
        }
        AppMethodBeat.o(254268);
        return finderVideoRecycler;
    }

    public final FinderImgFeedMusicPlayerManager dFy() {
        AppMethodBeat.i(254269);
        FinderImgFeedMusicPlayerManager finderImgFeedMusicPlayerManager = this.weI;
        if (finderImgFeedMusicPlayerManager == null) {
            p.btv("musicManager");
        }
        AppMethodBeat.o(254269);
        return finderImgFeedMusicPlayerManager;
    }

    public static /* synthetic */ void a(k kVar, AppCompatActivity appCompatActivity, b bVar, int i2) {
        AppMethodBeat.i(254271);
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        kVar.a(appCompatActivity, bVar, false);
        AppMethodBeat.o(254271);
    }

    public final void a(AppCompatActivity appCompatActivity, b bVar, boolean z) {
        AppMethodBeat.i(254270);
        p.h(appCompatActivity, "context");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
        p.g(viewModel, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
        this.weH = (FinderVideoRecycler) viewModel;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel2 = com.tencent.mm.ui.component.a.b(appCompatActivity).get(FinderImgFeedMusicPlayerManager.class);
        p.g(viewModel2, "UICProvider.of(context).…layerManager::class.java)");
        this.weI = (FinderImgFeedMusicPlayerManager) viewModel2;
        FinderVideoRecycler finderVideoRecycler = this.weH;
        if (finderVideoRecycler == null) {
            p.btv("recycler");
        }
        finderVideoRecycler.a(appCompatActivity, z);
        if (bVar != null) {
            RecyclerView dch = bVar.dch();
            this.hak = dch;
            DataBuffer<bo> dci = bVar.dci();
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.event.base.c MA = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(appCompatActivity).get(FinderReporterUIC.class)).MA(this.dLS);
            if (MA != null) {
                this.weT = new com.tencent.mm.plugin.finder.event.c(MA);
            }
            com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel3 = com.tencent.mm.ui.component.a.b(appCompatActivity).get(MediaPreloadCore.class);
            MediaPreloadCore mediaPreloadCore = (MediaPreloadCore) viewModel3;
            int i2 = this.dLS == -1 ? Integer.MIN_VALUE : this.dLS;
            com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
            mediaPreloadCore.a(dci, i2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(appCompatActivity).get(FinderReporterUIC.class)).MA(this.dLS));
            this.weU = (MediaPreloadCore) viewModel3;
            this.weR = new r(this.weU);
            MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) appCompatActivity;
            FinderVideoRecycler finderVideoRecycler2 = this.weH;
            if (finderVideoRecycler2 == null) {
                p.btv("recycler");
            }
            FinderImgFeedMusicPlayerManager finderImgFeedMusicPlayerManager = this.weI;
            if (finderImgFeedMusicPlayerManager == null) {
                p.btv("musicManager");
            }
            this.weS = new FinderVideoAutoPlayManager(mMFragmentActivity, dch, finderVideoRecycler2, finderImgFeedMusicPlayerManager, this.dLS);
            FinderVideoAutoPlayManager finderVideoAutoPlayManager = this.weS;
            if (finderVideoAutoPlayManager == null) {
                p.hyc();
            }
            finderVideoAutoPlayManager.setup();
        }
        a((MMFragmentActivity) appCompatActivity, new FinderVideoCore$onInitialize$2(this, appCompatActivity));
        AppMethodBeat.o(254270);
    }

    public final void dFz() {
        AppMethodBeat.i(168043);
        FinderVideoRecycler finderVideoRecycler = this.weH;
        if (finderVideoRecycler == null) {
            p.btv("recycler");
        }
        finderVideoRecycler.J(c.weY);
        AppMethodBeat.o(168043);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(168044);
        FinderVideoRecycler finderVideoRecycler = this.weH;
        if (finderVideoRecycler == null) {
            p.btv("recycler");
        }
        finderVideoRecycler.fJ(null);
        AppMethodBeat.o(168044);
    }
}
