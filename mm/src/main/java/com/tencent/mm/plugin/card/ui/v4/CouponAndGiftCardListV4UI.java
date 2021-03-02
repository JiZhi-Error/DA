package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.w;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0012\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0014J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0012H\u0014J\b\u0010'\u001a\u00020\u0012H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0017\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00102J$\u00103\u001a\u00020\u00122\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u000105j\n\u0012\u0004\u0012\u00020,\u0018\u0001`6H\u0002J\u0018\u00107\u001a\u00020\u00122\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u000109H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "mCardsCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "needForceRefresh", "", "bindData", "", "doItemClick", "getLayoutId", "", "gotoCardDetailUI", "position", "gotoCouponHistoryCardListUI", "title", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "Landroid/view/View;", "showDeleteConfirmDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "plugin-card_release"})
public final class CouponAndGiftCardListV4UI extends CardNewBaseUI {
    private final String TAG = "MicroMsg.CouponAndGiftCardListV4UI";
    private q gxX;
    private ViewGroup qgI;
    private LoadMoreRecyclerView qiS;
    private CouponAndGiftCardListViewModel qiT;
    private c qiU;
    private boolean qiV;

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "iconMenuData", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
    static final class a<T> implements Observer<List<? extends ue>> {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(List<? extends ue> list) {
            AppMethodBeat.i(201624);
            CouponAndGiftCardListV4UI.a(this.qiW, list);
            AppMethodBeat.o(201624);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "jumpUrlItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
    static final class b<T> implements Observer<ue> {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        b(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ue ueVar) {
            AppMethodBeat.i(201625);
            CouponAndGiftCardListV4UI.a(this.qiW, ueVar);
            AppMethodBeat.o(201625);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "onChanged"})
    static final class c<T> implements Observer<ArrayList<a>> {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        c(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ArrayList<a> arrayList) {
            AppMethodBeat.i(201626);
            CouponAndGiftCardListV4UI.a(this.qiW, (ArrayList) arrayList);
            AppMethodBeat.o(201626);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "onChanged"})
    static final class d<T> implements Observer<e> {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        d(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(e eVar) {
            AppMethodBeat.i(201627);
            CouponAndGiftCardListV4UI.a(this.qiW, eVar);
            AppMethodBeat.o(201627);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "isShowDialog", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class e<T> implements Observer<Boolean> {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        e(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(201628);
            CouponAndGiftCardListV4UI.a(this.qiW, bool);
            AppMethodBeat.o(201628);
        }
    }

    public static final /* synthetic */ CouponAndGiftCardListViewModel a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
        AppMethodBeat.i(201644);
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel = couponAndGiftCardListV4UI.qiT;
        if (couponAndGiftCardListViewModel == null) {
            p.btv("mViewModel");
        }
        AppMethodBeat.o(201644);
        return couponAndGiftCardListViewModel;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(201640);
        super.onCreate(bundle);
        initView();
        LoadMoreRecyclerView loadMoreRecyclerView = this.qiS;
        if (loadMoreRecyclerView == null) {
            p.btv("mCouponCardListRv");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new f(this));
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.qiS;
        if (loadMoreRecyclerView2 == null) {
            p.btv("mCouponCardListRv");
        }
        loadMoreRecyclerView2.setOnItemClickListener(new g(this));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qiS;
        if (loadMoreRecyclerView3 == null) {
            p.btv("mCouponCardListRv");
        }
        loadMoreRecyclerView3.setOnItemLongClickListener(new h(this));
        ViewModel viewModel = ViewModelProviders.of(this).get(CouponAndGiftCardListViewModel.class);
        p.g(viewModel, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.qiT = (CouponAndGiftCardListViewModel) viewModel;
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel = this.qiT;
        if (couponAndGiftCardListViewModel == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel.qiN.observe(this, new a(this));
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel2 = this.qiT;
        if (couponAndGiftCardListViewModel2 == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel2.qiO.observe(this, new b(this));
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel3 = this.qiT;
        if (couponAndGiftCardListViewModel3 == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel3.qiP.observe(this, new c(this));
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel4 = this.qiT;
        if (couponAndGiftCardListViewModel4 == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel4.qiQ.observe(this, new d(this));
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel5 = this.qiT;
        if (couponAndGiftCardListViewModel5 == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel5.qiR.observe(this, new e(this));
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel6 = this.qiT;
        if (couponAndGiftCardListViewModel6 == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel6.cxu();
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel7 = this.qiT;
        if (couponAndGiftCardListViewModel7 == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel7.d(this);
        AppMethodBeat.o(201640);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(201641);
        View findViewById = findViewById(R.id.bjb);
        p.g(findViewById, "findViewById(R.id.ctlu_rv)");
        this.qiS = (LoadMoreRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.b1h);
        p.g(findViewById2, "findViewById(R.id.chpe_root_layout)");
        this.qgI = (ViewGroup) findViewById2;
        LoadMoreRecyclerView loadMoreRecyclerView = this.qiS;
        if (loadMoreRecyclerView == null) {
            p.btv("mCouponCardListRv");
        }
        getContext();
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        this.qiU = new c();
        c cVar = this.qiU;
        if (cVar == null) {
            p.btv("mCardsCardListAdapter");
        }
        cVar.au(true);
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.qiS;
        if (loadMoreRecyclerView2 == null) {
            p.btv("mCouponCardListRv");
        }
        c cVar2 = this.qiU;
        if (cVar2 == null) {
            p.btv("mCardsCardListAdapter");
        }
        loadMoreRecyclerView2.setAdapter(cVar2);
        w wVar = new w(getContext(), 1);
        wVar.setDrawable(getResources().getDrawable(R.drawable.lk));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qiS;
        if (loadMoreRecyclerView3 == null) {
            p.btv("mCouponCardListRv");
        }
        loadMoreRecyclerView3.b(wVar);
        LoadMoreRecyclerView loadMoreRecyclerView4 = this.qiS;
        if (loadMoreRecyclerView4 == null) {
            p.btv("mCouponCardListRv");
        }
        loadMoreRecyclerView4.setLoadingView(R.layout.nc);
        LoadMoreRecyclerView loadMoreRecyclerView5 = this.qiS;
        if (loadMoreRecyclerView5 == null) {
            p.btv("mCouponCardListRv");
        }
        ViewGroup viewGroup = this.qgI;
        if (viewGroup == null) {
            p.btv("mEmptyView");
        }
        loadMoreRecyclerView5.setEmptyView(viewGroup);
        String stringExtra = getIntent().getStringExtra("title");
        String str = stringExtra;
        if (!(str == null || str.length() == 0)) {
            setMMTitle(stringExtra);
        } else {
            setMMTitle(R.string.ao_);
        }
        setActionbarColor(getResources().getColor(R.color.f3043a));
        hideActionbarLine();
        setBackBtn(new i(this));
        AppMethodBeat.o(201641);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class i implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        i(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201632);
            this.qiW.finish();
            AppMethodBeat.o(201632);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(201642);
        if (this.qiV) {
            CouponAndGiftCardListViewModel couponAndGiftCardListViewModel = this.qiT;
            if (couponAndGiftCardListViewModel == null) {
                p.btv("mViewModel");
            }
            couponAndGiftCardListViewModel.d(this);
            this.qiV = false;
        }
        super.onResume();
        AppMethodBeat.o(201642);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(201643);
        super.onDestroy();
        CouponAndGiftCardListViewModel couponAndGiftCardListViewModel = this.qiT;
        if (couponAndGiftCardListViewModel == null) {
            p.btv("mViewModel");
        }
        couponAndGiftCardListViewModel.cxv();
        AppMethodBeat.o(201643);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.yn;
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class f implements LoadMoreRecyclerView.a {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        f(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
        public final void bYy() {
            AppMethodBeat.i(201629);
            CouponAndGiftCardListV4UI.a(this.qiW).c(this.qiW);
            AppMethodBeat.o(201629);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    static final class g implements MRecyclerView.a {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        g(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
        public final void S(View view, int i2) {
            AppMethodBeat.i(201630);
            CouponAndGiftCardListV4UI.a(this.qiW, i2);
            AppMethodBeat.o(201630);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    static final class h implements MRecyclerView.b {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        h(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b
        public final boolean T(View view, int i2) {
            AppMethodBeat.i(201631);
            CouponAndGiftCardListV4UI couponAndGiftCardListV4UI = this.qiW;
            p.g(view, "view");
            boolean a2 = CouponAndGiftCardListV4UI.a(couponAndGiftCardListV4UI, i2, view);
            AppMethodBeat.o(201631);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$updateIconMenu$1$1"})
    public static final class n implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;
        final /* synthetic */ List qit;

        n(List list, CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qit = list;
            this.qiW = couponAndGiftCardListV4UI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201639);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qiW.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI.n.AnonymousClass1 */
                final /* synthetic */ n qiZ;

                {
                    this.qiZ = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(201637);
                    int i2 = 0;
                    for (Object obj : this.qiZ.qit) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            kotlin.a.j.hxH();
                        }
                        mVar.add(0, i2, 1, ((ue) obj).LdB);
                        i2 = i3;
                    }
                    AppMethodBeat.o(201637);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI.n.AnonymousClass2 */
                final /* synthetic */ n qiZ;

                {
                    this.qiZ = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201638);
                    CouponAndGiftCardListV4UI.a(this.qiZ.qiW).EG(i2);
                    AppMethodBeat.o(201638);
                }
            });
            eVar.dGm();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 3, 1);
            AppMethodBeat.o(201639);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$showDeleteCardAlert$1$1"})
    public static final class j implements View.OnCreateContextMenuListener {
        final /* synthetic */ View qgm;
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;
        final /* synthetic */ a qiX;

        j(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, View view, a aVar) {
            this.qiW = couponAndGiftCardListV4UI;
            this.qgm = view;
            this.qiX = aVar;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(201633);
            contextMenu.add(0, 1, 0, this.qiW.getString(R.string.tf));
            AppMethodBeat.o(201633);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$showDeleteCardAlert$1$2"})
    public static final class k implements o.g {
        final /* synthetic */ View qgm;
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;
        final /* synthetic */ a qiX;

        k(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, View view, a aVar) {
            this.qiW = couponAndGiftCardListV4UI;
            this.qgm = view;
            this.qiX = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201634);
            CouponAndGiftCardListV4UI.a(this.qiW, this.qiX);
            AppMethodBeat.o(201634);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class l implements o.f {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;

        l(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI) {
            this.qiW = couponAndGiftCardListV4UI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(201635);
            mVar.a(1, this.qiW.getResources().getColor(R.color.a5e), this.qiW.getString(R.string.tf));
            AppMethodBeat.o(201635);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class m implements o.g {
        final /* synthetic */ CouponAndGiftCardListV4UI qiW;
        final /* synthetic */ a qiY;

        m(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, a aVar) {
            this.qiW = couponAndGiftCardListV4UI;
            this.qiY = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201636);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    CouponAndGiftCardListV4UI.a(this.qiW).a(this.qiY);
                    break;
            }
            AppMethodBeat.o(201636);
        }
    }

    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, int i2) {
        int i3;
        AppMethodBeat.i(201645);
        c cVar = couponAndGiftCardListV4UI.qiU;
        if (cVar == null) {
            p.btv("mCardsCardListAdapter");
        }
        a EF = cVar.EF(i2);
        if (EF != null) {
            switch (EF.type) {
                case 1:
                    i3 = i2 - 2;
                    break;
                case 2:
                    i3 = i2 - 1;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            ua uaVar = EF.qiw;
            if (uaVar != null) {
                Log.i(couponAndGiftCardListV4UI.TAG, "go to card detail ui, cardIndex: " + i3 + ", cardID: " + uaVar.KDM + ", cardType: " + uaVar.Ldc);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19748, 3, Long.valueOf(System.currentTimeMillis() / 1000), uaVar.KDM, Integer.valueOf(i3), 0);
                switch (uaVar.Ldc) {
                    case 1:
                        com.tencent.mm.plugin.card.d.b.a((MMActivity) couponAndGiftCardListV4UI.getContext(), uaVar.Ldd);
                        break;
                    case 2:
                        un unVar = uaVar.Lde;
                        if (unVar != null) {
                            com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                            break;
                        }
                        break;
                    default:
                        Intent intent = new Intent(couponAndGiftCardListV4UI.getContext(), CardDetailUI.class);
                        intent.putExtra("key_card_id", uaVar.KDM);
                        intent.addFlags(131072);
                        intent.putExtra("key_from_scene", 3);
                        AppCompatActivity context = couponAndGiftCardListV4UI.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                }
                couponAndGiftCardListV4UI.qiV = true;
                AppMethodBeat.o(201645);
                return;
            }
            AppMethodBeat.o(201645);
            return;
        }
        AppMethodBeat.o(201645);
    }

    public static final /* synthetic */ boolean a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, int i2, View view) {
        AppMethodBeat.i(201646);
        c cVar = couponAndGiftCardListV4UI.qiU;
        if (cVar == null) {
            p.btv("mCardsCardListAdapter");
        }
        a EF = cVar.EF(i2);
        if (EF != null) {
            switch (EF.type) {
                case 1:
                case 2:
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(couponAndGiftCardListV4UI.getContext(), view);
                    aVar.a(new j(couponAndGiftCardListV4UI, view, EF));
                    aVar.a(new k(couponAndGiftCardListV4UI, view, EF));
                    Point dB = com.tencent.mm.plugin.card.d.m.dB(view);
                    aVar.ez(dB.x, dB.y);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 3, 3);
                    break;
            }
        }
        AppMethodBeat.o(201646);
        return false;
    }

    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, List list) {
        AppMethodBeat.i(201647);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            couponAndGiftCardListV4UI.removeAllOptionMenu();
            couponAndGiftCardListV4UI.addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new n(list, couponAndGiftCardListV4UI));
        }
        AppMethodBeat.o(201647);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, ue ueVar) {
        AppMethodBeat.i(201648);
        if (ueVar != null) {
            switch (ueVar.LdC) {
                case 1:
                    String str = ueVar.LdD;
                    if (str != null) {
                        com.tencent.mm.plugin.card.d.b.a(couponAndGiftCardListV4UI, str);
                        AppMethodBeat.o(201648);
                        return;
                    }
                    AppMethodBeat.o(201648);
                    return;
                case 2:
                    un unVar = ueVar.LdE;
                    if (unVar != null) {
                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                        AppMethodBeat.o(201648);
                        return;
                    }
                    AppMethodBeat.o(201648);
                    return;
                case 3:
                    String str2 = ueVar.LdF;
                    if (str2 != null) {
                        switch (str2.hashCode()) {
                            case 2016213713:
                                if (str2.equals("weixin://mktcard/couponv2history")) {
                                    String str3 = ueVar.LdB;
                                    Log.i(couponAndGiftCardListV4UI.TAG, "go to coupon history card list: title ".concat(String.valueOf(str3)));
                                    Intent intent = new Intent(couponAndGiftCardListV4UI.getContext(), HistoryCardListUI.class);
                                    intent.putExtra("title", str3);
                                    intent.putExtra("card_type", 2);
                                    AppCompatActivity context = couponAndGiftCardListV4UI.getContext();
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCouponHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    context.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCouponHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19747, 3, 2);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(201648);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(201648);
            return;
        }
        AppMethodBeat.o(201648);
    }

    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, ArrayList arrayList) {
        boolean z;
        AppMethodBeat.i(201649);
        ArrayList arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ViewGroup viewGroup = couponAndGiftCardListV4UI.qgI;
            if (viewGroup == null) {
                p.btv("mEmptyView");
            }
            viewGroup.setVisibility(0);
            c cVar = couponAndGiftCardListV4UI.qiU;
            if (cVar == null) {
                p.btv("mCardsCardListAdapter");
            }
            cVar.notifyDataSetChanged();
            AppMethodBeat.o(201649);
            return;
        }
        ViewGroup viewGroup2 = couponAndGiftCardListV4UI.qgI;
        if (viewGroup2 == null) {
            p.btv("mEmptyView");
        }
        viewGroup2.setVisibility(8);
        c cVar2 = couponAndGiftCardListV4UI.qiU;
        if (cVar2 == null) {
            p.btv("mCardsCardListAdapter");
        }
        cVar2.P(arrayList);
        AppMethodBeat.o(201649);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, e eVar) {
        boolean z;
        AppMethodBeat.i(201650);
        if (eVar != null) {
            switch (d.$EnumSwitchMapping$0[eVar.ordinal()]) {
                case 1:
                    String str = eVar.msg;
                    if (str == null || str.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        com.tencent.mm.plugin.card.d.l.ar(couponAndGiftCardListV4UI.getContext(), "");
                        AppMethodBeat.o(201650);
                        return;
                    }
                    com.tencent.mm.plugin.card.d.l.aq(couponAndGiftCardListV4UI.getContext(), eVar.msg);
                    AppMethodBeat.o(201650);
                    return;
                case 2:
                    LoadMoreRecyclerView loadMoreRecyclerView = couponAndGiftCardListV4UI.qiS;
                    if (loadMoreRecyclerView == null) {
                        p.btv("mCouponCardListRv");
                    }
                    loadMoreRecyclerView.showLoading(false);
                    AppMethodBeat.o(201650);
                    return;
                case 3:
                    LoadMoreRecyclerView loadMoreRecyclerView2 = couponAndGiftCardListV4UI.qiS;
                    if (loadMoreRecyclerView2 == null) {
                        p.btv("mCouponCardListRv");
                    }
                    loadMoreRecyclerView2.showLoading(true);
                    break;
            }
            AppMethodBeat.o(201650);
            return;
        }
        AppMethodBeat.o(201650);
    }

    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, Boolean bool) {
        q qVar;
        AppMethodBeat.i(201651);
        if (bool != null) {
            if (bool.booleanValue()) {
                qVar = q.a(couponAndGiftCardListV4UI.getContext(), couponAndGiftCardListV4UI.getString(R.string.a06), true, 3, null);
            } else {
                q qVar2 = couponAndGiftCardListV4UI.gxX;
                if (qVar2 != null) {
                    qVar2.dismiss();
                }
                qVar = null;
            }
            couponAndGiftCardListV4UI.gxX = qVar;
        }
        AppMethodBeat.o(201651);
    }

    public static final /* synthetic */ void a(CouponAndGiftCardListV4UI couponAndGiftCardListV4UI, a aVar) {
        AppMethodBeat.i(201652);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) couponAndGiftCardListV4UI.getContext(), 1, true);
        TextView textView = new TextView(couponAndGiftCardListV4UI.getContext());
        textView.setText(couponAndGiftCardListV4UI.getString(R.string.apu));
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(couponAndGiftCardListV4UI.getResources().getColor(R.color.u_));
        textView.setGravity(17);
        int dimensionPixelSize = couponAndGiftCardListV4UI.getResources().getDimensionPixelSize(R.dimen.ct);
        int dimensionPixelSize2 = couponAndGiftCardListV4UI.getResources().getDimensionPixelSize(R.dimen.cb);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        eVar.V(textView, false);
        eVar.a(new l(couponAndGiftCardListV4UI));
        eVar.a(new m(couponAndGiftCardListV4UI, aVar));
        eVar.dGm();
        AppMethodBeat.o(201652);
    }
}
