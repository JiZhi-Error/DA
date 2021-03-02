package com.tencent.mm.plugin.finder.megavideo.uic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoShareLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.g;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "tipsLayout", "Landroid/view/View;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "showProgress", "ifShow", "", "showRetryTips", "Companion", "plugin-finder_release"})
public final class FinderMegaVideoShareTLUIC extends BaseMegaVideoTLUIC {
    public static final a uNy = new a((byte) 0);
    private h.b uLW;
    private h.a uMy;
    private View uNf;

    static {
        AppMethodBeat.i(248680);
        AppMethodBeat.o(248680);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$onCreate$feedLoader$1$1"})
    static final class b extends q implements m<Integer, String, x> {
        final /* synthetic */ FinderMegaVideoShareTLUIC uNz;
        final /* synthetic */ String uhS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC, String str) {
            super(2);
            this.uNz = finderMegaVideoShareTLUIC;
            this.uhS = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, String str) {
            RecyclerView recyclerView;
            boolean z = true;
            AppMethodBeat.i(248669);
            int intValue = num.intValue();
            String str2 = str;
            FinderMegaVideoShareTLUIC.a(this.uNz, false);
            h.b a2 = FinderMegaVideoShareTLUIC.a(this.uNz);
            if (!(a2 == null || (recyclerView = a2.getRecyclerView()) == null)) {
                recyclerView.setVisibility(8);
            }
            TextView textView = (TextView) FinderMegaVideoShareTLUIC.b(this.uNz).findViewById(R.id.bml);
            switch (intValue) {
                case -8003:
                    FinderMegaVideoShareTLUIC.b(this.uNz).setVisibility(0);
                    if (str2 != null) {
                        if (!(str2.length() == 0)) {
                            p.g(textView, "tipsTv");
                            textView.setText(str2);
                            break;
                        }
                    }
                    textView.setText(R.string.d94);
                    break;
                case -8002:
                    FinderMegaVideoShareTLUIC.b(this.uNz).setVisibility(0);
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
                case -8001:
                    FinderMegaVideoShareTLUIC.b(this.uNz).setVisibility(0);
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
                    FinderMegaVideoShareTLUIC.b(this.uNz, true);
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248669);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMegaVideoShareTLUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(248679);
        AppMethodBeat.o(248679);
    }

    public static final /* synthetic */ h.b a(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC) {
        AppMethodBeat.i(248682);
        h.b bVar = finderMegaVideoShareTLUIC.uLW;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(248682);
        return bVar;
    }

    public static final /* synthetic */ void a(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC, boolean z) {
        AppMethodBeat.i(248681);
        finderMegaVideoShareTLUIC.nK(z);
        AppMethodBeat.o(248681);
    }

    public static final /* synthetic */ View b(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC) {
        AppMethodBeat.i(248683);
        View view = finderMegaVideoShareTLUIC.uNf;
        if (view == null) {
            p.btv("tipsLayout");
        }
        AppMethodBeat.o(248683);
        return view;
    }

    public static final /* synthetic */ h.a c(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC) {
        AppMethodBeat.i(248685);
        h.a aVar = finderMegaVideoShareTLUIC.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(248685);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.agr;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(248675);
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("feed_object_id", 0);
        String stringExtra = getIntent().getStringExtra("feed_object_nonceId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra("finder_user_name");
        if (stringExtra2 == null) {
            str = "";
        } else {
            str = stringExtra2;
        }
        this.uMy = new f(getActivity(), this);
        AppCompatActivity activity = getActivity();
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        this.uLW = new g(activity, aVar, getRootView());
        String stringExtra3 = getIntent().getStringExtra("key_from_user_name");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        String stringExtra4 = getIntent().getStringExtra("key_to_user_name");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderMegaVideoShareLoader finderMegaVideoShareLoader = new FinderMegaVideoShareLoader(longExtra, stringExtra, stringExtra3, stringExtra4, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx());
        p.h(str, "<set-?>");
        finderMegaVideoShareLoader.uKW = str;
        finderMegaVideoShareLoader.tNM = new b(this, str);
        finderMegaVideoShareLoader.uLa = new c(this, str);
        finderMegaVideoShareLoader.initFromCache(getIntent());
        finderMegaVideoShareLoader.setInitDone(new d(finderMegaVideoShareLoader, this, str));
        h.a aVar3 = this.uMy;
        if (aVar3 == null) {
            p.btv("presenter");
        }
        FinderMegaVideoShareLoader finderMegaVideoShareLoader2 = finderMegaVideoShareLoader;
        h.b bVar = this.uLW;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        aVar3.a(finderMegaVideoShareLoader2, bVar);
        View findViewById = getRootView().findViewById(R.id.hpd);
        p.g(findViewById, "rootView.findViewById(R.…_feed_detail_tips_layout)");
        this.uNf = findViewById;
        if (longExtra != 0) {
            nK(true);
        }
        AppMethodBeat.o(248675);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$onCreate$feedLoader$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class d implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderMegaVideoShareLoader uNA;
        final /* synthetic */ FinderMegaVideoShareTLUIC uNz;
        final /* synthetic */ String uhS;

        d(FinderMegaVideoShareLoader finderMegaVideoShareLoader, FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC, String str) {
            this.uNA = finderMegaVideoShareLoader;
            this.uNz = finderMegaVideoShareTLUIC;
            this.uhS = str;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(248673);
            final RecyclerView recyclerView = FinderMegaVideoShareTLUIC.a(this.uNz).getRecyclerView();
            if (recyclerView != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                    AppMethodBeat.o(248673);
                    throw tVar;
                }
                final FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
                recyclerView.post(new Runnable() {
                    /* class com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoShareTLUIC.d.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(248672);
                        finderLinearLayoutManager.ah(this.uNA.getInitPos(), 0);
                        final long longExtra = this.uNz.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0);
                        if (longExtra > 0) {
                            com.tencent.mm.ac.d.a(0, new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoShareTLUIC.d.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 uNC;

                                {
                                    this.uNC = r3;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    FinderVideoLayout finderVideoLayout;
                                    AppMethodBeat.i(248671);
                                    RecyclerView.v ch = recyclerView.ch(finderLinearLayoutManager.ks());
                                    if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
                                        ch = null;
                                    }
                                    com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
                                    if (!(hVar == null || (finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd)) == null)) {
                                        finderVideoLayout.setStartPlayTime(longExtra);
                                    }
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(248671);
                                    return xVar;
                                }
                            });
                        }
                        AppMethodBeat.o(248672);
                    }
                });
                AppMethodBeat.o(248673);
                return;
            }
            AppMethodBeat.o(248673);
        }
    }

    private final void nK(boolean z) {
        AppMethodBeat.i(248676);
        if (getRootView().findViewById(R.id.hpe) != null) {
            if (z) {
                View findViewById = getRootView().findViewById(R.id.hpe);
                p.g(findViewById, "rootView.findViewById<Vi…R.id.share_feed_progress)");
                findViewById.setVisibility(0);
                AppMethodBeat.o(248676);
                return;
            }
            View findViewById2 = getRootView().findViewById(R.id.hpe);
            p.g(findViewById2, "rootView.findViewById<Vi…R.id.share_feed_progress)");
            findViewById2.setVisibility(8);
        }
        AppMethodBeat.o(248676);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$showRetryTips$1$1"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ boolean uNm;
        final /* synthetic */ z.f uNn;
        final /* synthetic */ FinderMegaVideoShareTLUIC uNz;

        e(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC, boolean z, z.f fVar) {
            this.uNz = finderMegaVideoShareTLUIC;
            this.uNm = z;
            this.uNn = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248674);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderMegaVideoShareTLUIC.a(this.uNz, true);
            this.uNn.SYG.setVisibility(8);
            FinderMegaVideoShareTLUIC.c(this.uNz).dcp();
            FinderMegaVideoShareTLUIC.c(this.uNz).requestRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$showRetryTips$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248674);
        }
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC, com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(248677);
        super.onDestroy();
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        aVar.onDetach();
        AppMethodBeat.o(248677);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.uic.BaseMegaVideoTLUIC
    public final h.a dkq() {
        AppMethodBeat.i(248678);
        h.a aVar = this.uMy;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(248678);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoShareTLUIC$onCreate$feedLoader$1$2"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderMegaVideoShareTLUIC uNz;
        final /* synthetic */ String uhS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC, String str) {
            super(0);
            this.uNz = finderMegaVideoShareTLUIC;
            this.uhS = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248670);
            FinderMegaVideoShareTLUIC.a(this.uNz, false);
            FinderMegaVideoShareTLUIC.b(this.uNz, false);
            FinderMegaVideoShareTLUIC.a(this.uNz).getRecyclerView().setVisibility(0);
            x xVar = x.SXb;
            AppMethodBeat.o(248670);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(FinderMegaVideoShareTLUIC finderMegaVideoShareTLUIC, boolean z) {
        AppMethodBeat.i(248684);
        z.f fVar = new z.f();
        fVar.SYG = (T) finderMegaVideoShareTLUIC.getRootView().findViewById(R.id.h5w);
        if (fVar.SYG != null) {
            if (z) {
                fVar.SYG.setVisibility(0);
                fVar.SYG.setOnClickListener(new e(finderMegaVideoShareTLUIC, z, fVar));
                AppMethodBeat.o(248684);
                return;
            }
            fVar.SYG.setVisibility(8);
        }
        AppMethodBeat.o(248684);
    }
}
