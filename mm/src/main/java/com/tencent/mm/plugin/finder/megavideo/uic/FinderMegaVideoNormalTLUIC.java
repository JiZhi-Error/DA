package com.tencent.mm.plugin.finder.megavideo.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.megavideo.loader.NormalMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.g;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "tipsLayout", "Landroid/view/View;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "showRetryTips", "ifShow", "", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoNormalTLUIC extends BaseMegaVideoTLUIC {
    public static final a uNg = new a((byte) 0);
    private h.b uLW;
    private h.a uMy;
    private View uNf;

    static {
        AppMethodBeat.i(248646);
        AppMethodBeat.o(248646);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$4"})
    static final class c extends q implements m<Integer, String, x> {
        final /* synthetic */ FinderMegaVideoNormalTLUIC uNi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC) {
            super(2);
            this.uNi = finderMegaVideoNormalTLUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, String str) {
            RecyclerView recyclerView;
            boolean z = true;
            AppMethodBeat.i(248637);
            int intValue = num.intValue();
            String str2 = str;
            h.b a2 = FinderMegaVideoNormalTLUIC.a(this.uNi);
            if (!(a2 == null || (recyclerView = a2.getRecyclerView()) == null)) {
                recyclerView.setVisibility(8);
            }
            TextView textView = (TextView) FinderMegaVideoNormalTLUIC.b(this.uNi).findViewById(R.id.bml);
            switch (intValue) {
                case -4036:
                    FinderMegaVideoNormalTLUIC.b(this.uNi).setVisibility(0);
                    if (str2 != null) {
                        if (!(str2.length() == 0)) {
                            p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.d94);
                    break;
                case -4033:
                    FinderMegaVideoNormalTLUIC.b(this.uNi).setVisibility(0);
                    if (str2 != null) {
                        if (str2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.cny);
                    break;
                case -4011:
                    FinderMegaVideoNormalTLUIC.b(this.uNi).setVisibility(0);
                    if (str2 != null) {
                        if (str2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.cmw);
                    break;
                default:
                    FinderMegaVideoNormalTLUIC.a(this.uNi, true);
                    break;
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J(a.uNl);
            x xVar = x.SXb;
            AppMethodBeat.o(248637);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$5"})
    static final class d extends q implements kotlin.g.a.b<bm, x> {
        final /* synthetic */ FinderMegaVideoNormalTLUIC uNi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC) {
            super(1);
            this.uNi = finderMegaVideoNormalTLUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(bm bmVar) {
            RecyclerView recyclerView;
            AppMethodBeat.i(248638);
            p.h(bmVar, LocaleUtil.ITALIAN);
            h.b a2 = FinderMegaVideoNormalTLUIC.a(this.uNi);
            if (!(a2 == null || (recyclerView = a2.getRecyclerView()) == null)) {
                recyclerView.setVisibility(0);
            }
            FinderMegaVideoNormalTLUIC.a(this.uNi, false);
            this.uNi.dkq().dkp();
            x xVar = x.SXb;
            AppMethodBeat.o(248638);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMegaVideoNormalTLUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(248645);
        AppMethodBeat.o(248645);
    }

    public static final /* synthetic */ h.b a(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC) {
        AppMethodBeat.i(248647);
        h.b bVar = finderMegaVideoNormalTLUIC.uLW;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(248647);
        return bVar;
    }

    public static final /* synthetic */ View b(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC) {
        AppMethodBeat.i(248648);
        View view = finderMegaVideoNormalTLUIC.uNf;
        if (view == null) {
            p.btv("tipsLayout");
        }
        AppMethodBeat.o(248648);
        return view;
    }

    public static final /* synthetic */ h.a c(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC) {
        AppMethodBeat.i(248650);
        h.a aVar = finderMegaVideoNormalTLUIC.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(248650);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
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
        AppMethodBeat.i(248642);
        super.onCreate(bundle);
        this.uMy = new f(getActivity(), this);
        AppCompatActivity activity = getActivity();
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.uLW = new g(activity, aVar, getRootView());
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(248642);
            throw tVar;
        }
        NormalMegaVideoLoader normalMegaVideoLoader = new NormalMegaVideoLoader(dIx, (MMFragmentActivity) activity2);
        normalMegaVideoLoader.uLp = getIntent().getLongExtra("KEY_CACHE_OBJECT_ID", 0);
        String stringExtra = getIntent().getStringExtra("KEY_CACHE_OBJECT_NONCE_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        p.h(stringExtra, "<set-?>");
        normalMegaVideoLoader.uLq = stringExtra;
        normalMegaVideoLoader.uKX = this.uMQ;
        Intent intent = this.uMO;
        if (intent != null) {
            normalMegaVideoLoader.initFromCache(intent);
        } else {
            normalMegaVideoLoader.initFromCache(getIntent());
        }
        normalMegaVideoLoader.setInitDone(new b(normalMegaVideoLoader, this));
        normalMegaVideoLoader.tNM = new c(this);
        normalMegaVideoLoader.tNN = new d(this);
        View findViewById = getRootView().findViewById(R.id.cep);
        p.g(findViewById, "rootView.findViewById<Vi….feed_detail_tips_layout)");
        this.uNf = findViewById;
        h.a aVar3 = this.uMy;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        NormalMegaVideoLoader normalMegaVideoLoader2 = normalMegaVideoLoader;
        h.b bVar = this.uLW;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        aVar3.a(normalMegaVideoLoader2, bVar);
        AppMethodBeat.o(248642);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ NormalMegaVideoLoader uNh;
        final /* synthetic */ FinderMegaVideoNormalTLUIC uNi;

        b(NormalMegaVideoLoader normalMegaVideoLoader, FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC) {
            this.uNh = normalMegaVideoLoader;
            this.uNi = finderMegaVideoNormalTLUIC;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(248636);
            final RecyclerView recyclerView = FinderMegaVideoNormalTLUIC.a(this.uNi).getRecyclerView();
            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                    AppMethodBeat.o(248636);
                    throw tVar;
                }
                final FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
                recyclerView.post(new Runnable() {
                    /* class com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoNormalTLUIC.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(248635);
                        finderLinearLayoutManager.ah(this.uNh.getInitPos(), 0);
                        final long longExtra = this.uNi.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0);
                        if (longExtra > 0) {
                            com.tencent.mm.ac.d.a(0, new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoNormalTLUIC.b.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 uNk;

                                {
                                    this.uNk = r3;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    FinderVideoLayout finderVideoLayout;
                                    AppMethodBeat.i(248634);
                                    RecyclerView.v ch = recyclerView.ch(finderLinearLayoutManager.ks());
                                    if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
                                        ch = null;
                                    }
                                    com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
                                    if (!(hVar == null || (finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd)) == null)) {
                                        finderVideoLayout.setStartPlayTime(longExtra);
                                    }
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(248634);
                                    return xVar;
                                }
                            });
                        }
                        AppMethodBeat.o(248635);
                    }
                });
                AppMethodBeat.o(248636);
                return;
            }
            AppMethodBeat.o(248636);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$1$1"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ FinderMegaVideoNormalTLUIC uNi;
        final /* synthetic */ boolean uNm;
        final /* synthetic */ z.f uNn;

        e(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC, boolean z, z.f fVar) {
            this.uNi = finderMegaVideoNormalTLUIC;
            this.uNm = z;
            this.uNn = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248641);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uNn.SYG.setVisibility(8);
            FinderMegaVideoNormalTLUIC.c(this.uNi).dcp();
            FinderMegaVideoNormalTLUIC.c(this.uNi).requestRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248641);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC, com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(248643);
        super.onDestroy();
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onDetach();
        AppMethodBeat.o(248643);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC
    public final h.a dkq() {
        AppMethodBeat.i(248644);
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(248644);
        return aVar;
    }

    public static final /* synthetic */ void a(FinderMegaVideoNormalTLUIC finderMegaVideoNormalTLUIC, boolean z) {
        AppMethodBeat.i(248649);
        z.f fVar = new z.f();
        fVar.SYG = (T) finderMegaVideoNormalTLUIC.getRootView().findViewById(R.id.h5w);
        if (fVar.SYG != null) {
            if (z) {
                fVar.SYG.setVisibility(0);
                fVar.SYG.setOnClickListener(new e(finderMegaVideoNormalTLUIC, z, fVar));
                AppMethodBeat.o(248649);
                return;
            }
            fVar.SYG.setVisibility(8);
        }
        AppMethodBeat.o(248649);
    }
}
