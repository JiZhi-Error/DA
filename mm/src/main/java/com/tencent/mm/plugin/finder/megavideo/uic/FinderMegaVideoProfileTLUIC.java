package com.tencent.mm.plugin.finder.megavideo.uic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.e;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoProfileTLUIC extends BaseMegaVideoTLUIC {
    public static final a uNo = new a((byte) 0);
    private h.b uLW;
    private h.a uMy;

    static {
        AppMethodBeat.i(248658);
        AppMethodBeat.o(248658);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMegaVideoProfileTLUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(248657);
        AppMethodBeat.o(248657);
    }

    public static final /* synthetic */ h.b a(FinderMegaVideoProfileTLUIC finderMegaVideoProfileTLUIC) {
        AppMethodBeat.i(248659);
        h.b bVar = finderMegaVideoProfileTLUIC.uLW;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(248659);
        return bVar;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aga;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(248654);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("finder_username");
        if (stringExtra == null) {
            str = "";
        } else {
            str = stringExtra;
        }
        f fVar = new f(getActivity(), this);
        fVar.uLZ = z.In(str);
        this.uMy = fVar;
        AppCompatActivity activity = getActivity();
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.uLW = new e(activity, aVar, getRootView());
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderMegaVideoProfileLoader finderMegaVideoProfileLoader = new FinderMegaVideoProfileLoader(str, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
        finderMegaVideoProfileLoader.initFromCache(getIntent());
        finderMegaVideoProfileLoader.setInitDone(new b(finderMegaVideoProfileLoader, this));
        h.a aVar3 = this.uMy;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        FinderMegaVideoProfileLoader finderMegaVideoProfileLoader2 = finderMegaVideoProfileLoader;
        h.b bVar = this.uLW;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        aVar3.a(finderMegaVideoProfileLoader2, bVar);
        AppMethodBeat.o(248654);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderMegaVideoProfileLoader uNp;
        final /* synthetic */ FinderMegaVideoProfileTLUIC uNq;

        b(FinderMegaVideoProfileLoader finderMegaVideoProfileLoader, FinderMegaVideoProfileTLUIC finderMegaVideoProfileTLUIC) {
            this.uNp = finderMegaVideoProfileLoader;
            this.uNq = finderMegaVideoProfileTLUIC;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(248653);
            final RecyclerView recyclerView = FinderMegaVideoProfileTLUIC.a(this.uNq).getRecyclerView();
            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                    AppMethodBeat.o(248653);
                    throw tVar;
                }
                final FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
                recyclerView.post(new Runnable() {
                    /* class com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoProfileTLUIC.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(248652);
                        finderLinearLayoutManager.ah(this.uNp.getInitPos() - this.uNp.uKR, 0);
                        final long longExtra = this.uNq.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0);
                        if (longExtra > 0) {
                            d.a(0, new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoProfileTLUIC.b.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 uNs;

                                {
                                    this.uNs = r3;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    FinderVideoLayout finderVideoLayout;
                                    AppMethodBeat.i(248651);
                                    RecyclerView.v ch = recyclerView.ch(finderLinearLayoutManager.ks());
                                    if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
                                        ch = null;
                                    }
                                    com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
                                    if (!(hVar == null || (finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd)) == null)) {
                                        finderVideoLayout.setStartPlayTime(longExtra);
                                    }
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(248651);
                                    return xVar;
                                }
                            });
                        }
                        AppMethodBeat.o(248652);
                    }
                });
                AppMethodBeat.o(248653);
                return;
            }
            AppMethodBeat.o(248653);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC, com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(248655);
        super.onDestroy();
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onDetach();
        AppMethodBeat.o(248655);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC
    public final h.a dkq() {
        AppMethodBeat.i(248656);
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(248656);
        return aVar;
    }
}
