package com.tencent.mm.plugin.festival.finder;

import android.arch.lifecycle.Lifecycle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePresenter;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "viewcall", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveViewCallback;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$ViewCallback;", "onDetach", "requestDisableSwipeBack", "disabled", "", "Companion", "plugin-festival_release"})
public final class aq implements w.a {
    public static final a Uuo = new a((byte) 0);
    private FestivalFinderLiveViewCallback Uun;
    private final MMActivity activity;

    static {
        AppMethodBeat.i(262525);
        AppMethodBeat.o(262525);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePresenter$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public aq(MMActivity mMActivity) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(262524);
        this.activity = mMActivity;
        AppMethodBeat.o(262524);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(w.b bVar) {
        AppMethodBeat.i(262523);
        a(bVar);
        AppMethodBeat.o(262523);
    }

    @Override // com.tencent.mm.plugin.festival.finder.w.a
    public final void Fh(boolean z) {
        AppMethodBeat.i(262521);
        if (z) {
            SwipeBackLayout swipeBackLayout = this.activity.getSwipeBackLayout();
            if (swipeBackLayout != null) {
                swipeBackLayout.setEnableGesture(false);
                AppMethodBeat.o(262521);
                return;
            }
            AppMethodBeat.o(262521);
            return;
        }
        SwipeBackLayout swipeBackLayout2 = this.activity.getSwipeBackLayout();
        if (swipeBackLayout2 != null) {
            swipeBackLayout2.setEnableGesture(true);
            AppMethodBeat.o(262521);
            return;
        }
        AppMethodBeat.o(262521);
    }

    public final void a(w.b bVar) {
        w.b bVar2;
        d dVar;
        AppMethodBeat.i(262522);
        p.h(bVar, "callback");
        if (!(bVar instanceof FestivalFinderLiveViewCallback)) {
            bVar2 = null;
        } else {
            bVar2 = bVar;
        }
        this.Uun = (FestivalFinderLiveViewCallback) bVar2;
        FestivalFinderLiveViewCallback festivalFinderLiveViewCallback = this.Uun;
        if (festivalFinderLiveViewCallback != null) {
            at atVar = at.Uuv;
            d dfY = at.dfY();
            if (dfY == null) {
                dVar = new d();
            } else {
                dVar = dfY;
            }
            p.h(dVar, "data");
            Lifecycle lifecycle = festivalFinderLiveViewCallback.ufJ;
            if (lifecycle != null) {
                lifecycle.addObserver(festivalFinderLiveViewCallback);
            }
            c cVar = dVar.uCu.get(0);
            p.g(cVar, "data.liveDataList[0]");
            festivalFinderLiveViewCallback.UuD = cVar;
            FestivalFinderLiveViewCallback.a(festivalFinderLiveViewCallback);
            AppMethodBeat.o(262522);
            return;
        }
        AppMethodBeat.o(262522);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        this.Uun = null;
    }
}
