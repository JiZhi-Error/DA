package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList extends AppBrandLauncherUI.Fragment {
    private static final String TAG = TAG;
    public static final a oeA = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final f oez = g.ah(new b(this));

    private final AppBrandRecommendUILogic bYM() {
        AppMethodBeat.i(51310);
        AppBrandRecommendUILogic appBrandRecommendUILogic = (AppBrandRecommendUILogic) this.oez.getValue();
        AppMethodBeat.o(51310);
        return appBrandRecommendUILogic;
    }

    public AppBrandLauncherRecommendList() {
        AppMethodBeat.i(51316);
        AppMethodBeat.o(51316);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(51311);
        super.onCreate(bundle);
        Log.i(TAG, "onCreate");
        getLifecycle().addObserver(bYM());
        AppMethodBeat.o(51311);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void initView() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(51312);
        AppBrandRecommendUILogic bYM = bYM();
        bYM.bZc().setLayoutManager(bYM.ofw);
        View contentView = bYM.getContentView();
        if (contentView == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(51312);
            throw tVar;
        }
        ((FrameLayout) contentView).addView(bYM.bZc(), new ViewGroup.LayoutParams(-1, -1));
        bYM.ofu.au(true);
        a aVar = bYM.ofu;
        AppBrandRecommendUILogic.m mVar = new AppBrandRecommendUILogic.m(bYM);
        p.h(mVar, "<set-?>");
        aVar.oeE = mVar;
        a aVar2 = bYM.ofu;
        AppBrandRecommendUILogic.n nVar = new AppBrandRecommendUILogic.n(bYM);
        p.h(nVar, "<set-?>");
        aVar2.oeG = nVar;
        a aVar3 = bYM.ofu;
        AppBrandRecommendUILogic.o oVar = new AppBrandRecommendUILogic.o(bYM);
        p.h(oVar, "<set-?>");
        aVar3.oeF = oVar;
        bYM.bZc().setAdapter(bYM.ofu);
        if (bYM.bYO()) {
            bYM.bZc().addHeaderView(bYM.ofx.bYp());
            View bYp = bYM.ofx.bYp();
            if (bYp != null) {
                bYp.setVisibility(8);
            }
            bYM.ofx.bSx();
            bYM.ofx.zu(0);
            bYM.ofx.zv(0);
        }
        View inflate = LayoutInflater.from(bYM.context).inflate(R.layout.fb, (ViewGroup) bYM.bZc(), false);
        bYM.bZc().addHeaderView(inflate);
        View findViewById = inflate.findViewById(R.id.dp4);
        if (findViewById == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(51312);
            throw tVar2;
        }
        ((TextView) findViewById).setText(bYM.bYN());
        inflate.setOnLongClickListener(AppBrandRecommendUILogic.g.ofT);
        bYM.bZc().setLoadingView(bYM.bZe().bYp());
        i.a(bYM, false);
        i.b(bYM, false);
        bYM.bZe();
        bYM.bZe().bYE();
        bYM.ofv.jlo = bYM.bZd().kWZ;
        AppBrandRecommendUILogic.b bVar = bYM.ofv;
        if (bYM.bZd().kWY > 0) {
            z = true;
        } else {
            z = false;
        }
        bVar.ofK = z;
        bYM.bZd().kXf = new AppBrandRecommendUILogic.f(bYM);
        if (bYM.bZd().byK().isEmpty() || !bYM.bZd().kXa) {
            z2 = false;
        }
        bYM.iV(z2);
        if (!z2) {
            g.zz(2);
        }
        bYM.bZc().setOnLoadingStateChangedListener(new AppBrandRecommendUILogic.h(bYM));
        bYM.bZc().a(bYM.ofG);
        bYM.ofy.bYX();
        bYM.ofu.notifyDataSetChanged();
        AppMethodBeat.o(51312);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(51309);
        AppMethodBeat.o(51309);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void bXb() {
        AppMethodBeat.i(51313);
        super.bXb();
        Log.i(TAG, "onTitleDoubleTap");
        LoadMoreRecyclerView bZc = bYM().bZc();
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(bZc, a2.axQ(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        bZc.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(bZc, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        AppMethodBeat.o(51313);
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroyView() {
        AppMethodBeat.i(51314);
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
        Lifecycle lifecycle = getLifecycle();
        p.g(lifecycle, "lifecycle");
        lifecycle.getCurrentState();
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(51314);
    }

    @Override // android.support.v4.app.Fragment
    public final void onPause() {
        AppMethodBeat.i(51315);
        super.onPause();
        Log.i(TAG, "onPause");
        AppMethodBeat.o(51315);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
    public static final class b extends q implements kotlin.g.a.a<AppBrandLauncherRecommendList$uiLogic$2$1> {
        final /* synthetic */ AppBrandLauncherRecommendList oeB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppBrandLauncherRecommendList appBrandLauncherRecommendList) {
            super(0);
            this.oeB = appBrandLauncherRecommendList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AppBrandLauncherRecommendList$uiLogic$2$1 invoke() {
            AppMethodBeat.i(51308);
            FragmentActivity activity = this.oeB.getActivity();
            if (activity == null) {
                p.hyc();
            }
            p.g(activity, "activity!!");
            AppBrandLauncherRecommendList$uiLogic$2$1 appBrandLauncherRecommendList$uiLogic$2$1 = new AppBrandLauncherRecommendList$uiLogic$2$1(this, activity);
            AppMethodBeat.o(51308);
            return appBrandLauncherRecommendList$uiLogic$2$1;
        }
    }
}
