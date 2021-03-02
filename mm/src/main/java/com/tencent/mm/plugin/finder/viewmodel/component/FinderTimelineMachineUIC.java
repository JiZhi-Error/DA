package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.ar;
import com.tencent.mm.plugin.finder.feed.as;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "getLayoutId", "", "onActionbarClick", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineMachineUIC extends UIComponent {
    public static final a wAI = new a((byte) 0);
    private ar wAH;

    static {
        AppMethodBeat.i(256003);
        AppMethodBeat.o(256003);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineMachineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderTimelineMachineUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(256002);
        AppMethodBeat.o(256002);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.akm;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255997);
        super.onCreate(bundle);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255997);
            throw tVar;
        }
        ((MMActivity) activity).setMMTitle(R.string.chs);
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255997);
            throw tVar2;
        }
        ((MMActivity) activity2).setBackBtn(new b(this));
        AppCompatActivity activity3 = getActivity();
        if (activity3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255997);
            throw tVar3;
        }
        this.wAH = new ar((MMActivity) activity3);
        AppCompatActivity activity4 = getActivity();
        if (activity4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255997);
            throw tVar4;
        }
        MMActivity mMActivity = (MMActivity) activity4;
        ar arVar = this.wAH;
        if (arVar == null) {
            p.btv("presenter");
        }
        as asVar = new as(mMActivity, arVar, getRootView(), getFragment());
        ar arVar2 = this.wAH;
        if (arVar2 == null) {
            p.btv("presenter");
        }
        arVar2.a(asVar);
        AppMethodBeat.o(255997);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderTimelineMachineUIC wAJ;

        b(FinderTimelineMachineUIC finderTimelineMachineUIC) {
            this.wAJ = finderTimelineMachineUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255996);
            boolean onBackPressed = this.wAJ.onBackPressed();
            AppMethodBeat.o(255996);
            return onBackPressed;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255998);
        getActivity().finish();
        AppMethodBeat.o(255998);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(255999);
        super.onUserVisibleFocused();
        ar arVar = this.wAH;
        if (arVar == null) {
            p.btv("presenter");
        }
        d.i(new ar.h(arVar));
        AppMethodBeat.o(255999);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onFinished() {
        AppMethodBeat.i(256000);
        super.onFinished();
        ar arVar = this.wAH;
        if (arVar == null) {
            p.btv("presenter");
        }
        FinderHomeTabStateVM.a(arVar.tlCache, 4, 0, arVar.totalDy, arVar.tRo.getDataListJustForAdapter());
        if (arVar.tRI != null) {
            FinderTagCacheVM finderTagCacheVM = arVar.tRF;
            apa apa = arVar.tRI;
            if (apa == null) {
                p.hyc();
            }
            p.h(apa, "lastDataList");
            new StringBuilder("tabType=4 lastExitPosition=-1  lastDataList size=").append(apa.LBa.size()).append(' ');
            h.hkS();
            FinderTagCacheVM.a aVar = new FinderTagCacheVM.a();
            aVar.wuU = -1;
            p.h(apa, "<set-?>");
            aVar.wuT = apa;
            finderTagCacheVM.wtV.put(4, aVar);
        }
        AppMethodBeat.o(256000);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(256001);
        super.onDestroy();
        ar arVar = this.wAH;
        if (arVar == null) {
            p.btv("presenter");
        }
        arVar.onDetach();
        AppMethodBeat.o(256001);
    }
}
