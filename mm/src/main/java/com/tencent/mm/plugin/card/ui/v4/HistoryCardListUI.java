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
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0014J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0010H\u0014J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0010H\u0002J\u0018\u0010&\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0012\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0017\u0010+\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u0010-J$\u0010.\u001a\u00020\u00102\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u000100j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`1H\u0002J\u0018\u00102\u001a\u00020\u00102\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u000104H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/HistoryCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "mCardType", "", "mEmptyView", "Landroid/view/ViewGroup;", "mHistoryCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mHistoryCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "bindData", "", "doItemClick", "getLayoutId", "gotoCardDetailUI", "position", "initDeleteDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "", "saveSnapshot", "showDeleteCardMenu", "Landroid/view/View;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "Companion", "plugin-card_release"})
public final class HistoryCardListUI extends CardNewBaseUI {
    public static final a qjy = new a((byte) 0);
    private q gxX;
    private ViewGroup qgI;
    private LoadMoreRecyclerView qju;
    private CardsViewModel qjv;
    private c qjw;
    private int qjx = 1;

    static {
        AppMethodBeat.i(201703);
        AppMethodBeat.o(201703);
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "iconMenuData", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
    static final class b<T> implements Observer<List<? extends ue>> {
        final /* synthetic */ HistoryCardListUI qjz;

        b(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(List<? extends ue> list) {
            AppMethodBeat.i(201684);
            HistoryCardListUI.a(this.qjz, list);
            AppMethodBeat.o(201684);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "jumpUrlItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
    static final class c<T> implements Observer<ue> {
        final /* synthetic */ HistoryCardListUI qjz;

        c(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ue ueVar) {
            AppMethodBeat.i(201685);
            HistoryCardListUI.a(this.qjz, ueVar);
            AppMethodBeat.o(201685);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "onChanged"})
    static final class d<T> implements Observer<ArrayList<a>> {
        final /* synthetic */ HistoryCardListUI qjz;

        d(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ArrayList<a> arrayList) {
            AppMethodBeat.i(201686);
            HistoryCardListUI.a(this.qjz, (ArrayList) arrayList);
            AppMethodBeat.o(201686);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "onChanged"})
    static final class e<T> implements Observer<e> {
        final /* synthetic */ HistoryCardListUI qjz;

        e(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(e eVar) {
            AppMethodBeat.i(201687);
            HistoryCardListUI.a(this.qjz, eVar);
            AppMethodBeat.o(201687);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "isShowDialog", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class f<T> implements Observer<Boolean> {
        final /* synthetic */ HistoryCardListUI qjz;

        f(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(201688);
            HistoryCardListUI.a(this.qjz, bool);
            AppMethodBeat.o(201688);
        }
    }

    public static final /* synthetic */ CardsViewModel a(HistoryCardListUI historyCardListUI) {
        AppMethodBeat.i(201709);
        CardsViewModel cardsViewModel = historyCardListUI.qjv;
        if (cardsViewModel == null) {
            p.btv("mViewModel");
        }
        AppMethodBeat.o(201709);
        return cardsViewModel;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        CardsViewModel cardsViewModel;
        AppMethodBeat.i(201700);
        super.onCreate(bundle);
        initView();
        LoadMoreRecyclerView loadMoreRecyclerView = this.qju;
        if (loadMoreRecyclerView == null) {
            p.btv("mHistoryCardListRv");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new g(this));
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.qju;
        if (loadMoreRecyclerView2 == null) {
            p.btv("mHistoryCardListRv");
        }
        loadMoreRecyclerView2.setOnItemClickListener(new h(this));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qju;
        if (loadMoreRecyclerView3 == null) {
            p.btv("mHistoryCardListRv");
        }
        loadMoreRecyclerView3.setOnItemLongClickListener(new i(this));
        switch (this.qjx) {
            case 2:
                ViewModel viewModel = ViewModelProviders.of(this).get(CouponHistoryCardListViewModel.class);
                p.g(viewModel, "ViewModelProviders.of(th…istViewModel::class.java)");
                cardsViewModel = (CardsViewModel) viewModel;
                break;
            case 3:
                ViewModel viewModel2 = ViewModelProviders.of(this).get(MemberHistoryCardListViewModel.class);
                p.g(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
                cardsViewModel = (CardsViewModel) viewModel2;
                break;
            default:
                ViewModel viewModel3 = ViewModelProviders.of(this).get(CouponHistoryCardListViewModel.class);
                p.g(viewModel3, "ViewModelProviders.of(th…istViewModel::class.java)");
                cardsViewModel = (CardsViewModel) viewModel3;
                break;
        }
        this.qjv = cardsViewModel;
        CardsViewModel cardsViewModel2 = this.qjv;
        if (cardsViewModel2 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel2.qiN.observe(this, new b(this));
        CardsViewModel cardsViewModel3 = this.qjv;
        if (cardsViewModel3 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel3.qiO.observe(this, new c(this));
        CardsViewModel cardsViewModel4 = this.qjv;
        if (cardsViewModel4 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel4.qiP.observe(this, new d(this));
        CardsViewModel cardsViewModel5 = this.qjv;
        if (cardsViewModel5 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel5.qiQ.observe(this, new e(this));
        CardsViewModel cardsViewModel6 = this.qjv;
        if (cardsViewModel6 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel6.qiR.observe(this, new f(this));
        CardsViewModel cardsViewModel7 = this.qjv;
        if (cardsViewModel7 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel7.cxu();
        CardsViewModel cardsViewModel8 = this.qjv;
        if (cardsViewModel8 == null) {
            p.btv("mViewModel");
        }
        cardsViewModel8.d(this);
        AppMethodBeat.o(201700);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(201701);
        View findViewById = findViewById(R.id.bjb);
        p.g(findViewById, "findViewById(R.id.ctlu_rv)");
        this.qju = (LoadMoreRecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.b1h);
        p.g(findViewById2, "findViewById(R.id.chpe_root_layout)");
        this.qgI = (ViewGroup) findViewById2;
        TextView textView = (TextView) findViewById(R.id.b1i);
        WeImageView weImageView = (WeImageView) findViewById(R.id.b1g);
        weImageView.setImageResource(R.raw.icon_history_card_empty);
        weImageView.setIconColor(getResources().getColor(R.color.FG_2));
        LoadMoreRecyclerView loadMoreRecyclerView = this.qju;
        if (loadMoreRecyclerView == null) {
            p.btv("mHistoryCardListRv");
        }
        getContext();
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        this.qjw = new c(true);
        c cVar = this.qjw;
        if (cVar == null) {
            p.btv("mHistoryCardListAdapter");
        }
        cVar.au(true);
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.qju;
        if (loadMoreRecyclerView2 == null) {
            p.btv("mHistoryCardListRv");
        }
        c cVar2 = this.qjw;
        if (cVar2 == null) {
            p.btv("mHistoryCardListAdapter");
        }
        loadMoreRecyclerView2.setAdapter(cVar2);
        w wVar = new w(getContext(), 1);
        wVar.setDrawable(getResources().getDrawable(R.drawable.lk));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.qju;
        if (loadMoreRecyclerView3 == null) {
            p.btv("mHistoryCardListRv");
        }
        loadMoreRecyclerView3.b(wVar);
        LoadMoreRecyclerView loadMoreRecyclerView4 = this.qju;
        if (loadMoreRecyclerView4 == null) {
            p.btv("mHistoryCardListRv");
        }
        loadMoreRecyclerView4.setLoadingView(R.layout.nc);
        LoadMoreRecyclerView loadMoreRecyclerView5 = this.qju;
        if (loadMoreRecyclerView5 == null) {
            p.btv("mHistoryCardListRv");
        }
        ViewGroup viewGroup = this.qgI;
        if (viewGroup == null) {
            p.btv("mEmptyView");
        }
        loadMoreRecyclerView5.setEmptyView(viewGroup);
        textView.setText(R.string.aq1);
        String stringExtra = getIntent().getStringExtra("title");
        this.qjx = getIntent().getIntExtra("card_type", 2);
        String str = stringExtra;
        if (!(str == null || str.length() == 0)) {
            setMMTitle(stringExtra);
        } else {
            setMMTitle(R.string.hoc);
        }
        setActionbarColor(getResources().getColor(R.color.f3043a));
        hideActionbarLine();
        setBackBtn(new l(this));
        AppMethodBeat.o(201701);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class l implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ HistoryCardListUI qjz;

        l(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201694);
            this.qjz.finish();
            AppMethodBeat.o(201694);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(201702);
        super.onDestroy();
        CardsViewModel cardsViewModel = this.qjv;
        if (cardsViewModel == null) {
            p.btv("mViewModel");
        }
        cardsViewModel.cxv();
        AppMethodBeat.o(201702);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.yn;
    }

    @Override // com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
    public final void ad(int i2, boolean z) {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class g implements LoadMoreRecyclerView.a {
        final /* synthetic */ HistoryCardListUI qjz;

        g(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
        public final void bYy() {
            AppMethodBeat.i(201689);
            HistoryCardListUI.a(this.qjz).c(this.qjz);
            AppMethodBeat.o(201689);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    static final class h implements MRecyclerView.a {
        final /* synthetic */ HistoryCardListUI qjz;

        h(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
        public final void S(View view, int i2) {
            AppMethodBeat.i(201690);
            HistoryCardListUI.a(this.qjz, i2);
            AppMethodBeat.o(201690);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    static final class i implements MRecyclerView.b {
        final /* synthetic */ HistoryCardListUI qjz;

        i(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b
        public final boolean T(View view, int i2) {
            AppMethodBeat.i(201691);
            HistoryCardListUI historyCardListUI = this.qjz;
            p.g(view, "view");
            boolean a2 = HistoryCardListUI.a(historyCardListUI, i2, view);
            AppMethodBeat.o(201691);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$updateIconMenu$1$1"})
    public static final class o implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ List qit;
        final /* synthetic */ HistoryCardListUI qjz;

        o(List list, HistoryCardListUI historyCardListUI) {
            this.qit = list;
            this.qjz = historyCardListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201699);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.qjz.getContext(), 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI.o.AnonymousClass1 */
                final /* synthetic */ o qjA;

                {
                    this.qjA = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(201697);
                    int i2 = 0;
                    for (Object obj : this.qjA.qit) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            kotlin.a.j.hxH();
                        }
                        mVar.add(0, i2, 1, ((ue) obj).LdB);
                        i2 = i3;
                    }
                    AppMethodBeat.o(201697);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI.o.AnonymousClass2 */
                final /* synthetic */ o qjA;

                {
                    this.qjA = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(201698);
                    HistoryCardListUI.a(this.qjA.qjz).EG(i2);
                    AppMethodBeat.o(201698);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(201699);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class j implements o.f {
        final /* synthetic */ HistoryCardListUI qjz;

        j(HistoryCardListUI historyCardListUI) {
            this.qjz = historyCardListUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(201692);
            mVar.a(1, this.qjz.getResources().getColor(R.color.a5e), this.qjz.getString(R.string.tf));
            AppMethodBeat.o(201692);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class k implements o.g {
        final /* synthetic */ int gUj;
        final /* synthetic */ a qiY;
        final /* synthetic */ HistoryCardListUI qjz;

        k(HistoryCardListUI historyCardListUI, a aVar, int i2) {
            this.qjz = historyCardListUI;
            this.qiY = aVar;
            this.gUj = i2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            int i3;
            String str;
            AppMethodBeat.i(201693);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    switch (this.qjz.qjx) {
                        case 2:
                            i3 = 2;
                            break;
                        case 3:
                            i3 = 1;
                            break;
                        default:
                            i3 = 2;
                            break;
                    }
                    ua uaVar = this.qiY.qiw;
                    if (uaVar == null || (str = uaVar.KDM) == null) {
                        str = "";
                    }
                    Log.i("MicroMsg.HistoryCardListUI", "delete card, cardIndex: " + this.gUj + ", cardID: " + str + ", pageScene: " + i3);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(21329, Integer.valueOf(i3), 1, str, Integer.valueOf(this.gUj));
                    HistoryCardListUI.a(this.qjz).a(this.qiY);
                    break;
            }
            AppMethodBeat.o(201693);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$showDeleteCardMenu$1$1"})
    public static final class m implements View.OnCreateContextMenuListener {
        final /* synthetic */ int oeZ;
        final /* synthetic */ View qgm;
        final /* synthetic */ a qiX;
        final /* synthetic */ HistoryCardListUI qjz;

        m(HistoryCardListUI historyCardListUI, View view, a aVar, int i2) {
            this.qjz = historyCardListUI;
            this.qgm = view;
            this.qiX = aVar;
            this.oeZ = i2;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(201695);
            contextMenu.add(0, 1, 0, this.qjz.getString(R.string.tf));
            AppMethodBeat.o(201695);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$showDeleteCardMenu$1$2"})
    public static final class n implements o.g {
        final /* synthetic */ int oeZ;
        final /* synthetic */ View qgm;
        final /* synthetic */ a qiX;
        final /* synthetic */ HistoryCardListUI qjz;

        n(HistoryCardListUI historyCardListUI, View view, a aVar, int i2) {
            this.qjz = historyCardListUI;
            this.qgm = view;
            this.qiX = aVar;
            this.oeZ = i2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(201696);
            HistoryCardListUI.a(this.qjz, this.qiX, this.oeZ);
            AppMethodBeat.o(201696);
        }
    }

    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, List list) {
        AppMethodBeat.i(201704);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            historyCardListUI.removeAllOptionMenu();
            historyCardListUI.addIconOptionMenu(0, 0, R.raw.icons_outlined_more, new o(list, historyCardListUI));
        }
        AppMethodBeat.o(201704);
    }

    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, ue ueVar) {
        AppMethodBeat.i(201705);
        if (ueVar != null) {
            switch (ueVar.LdC) {
                case 1:
                    String str = ueVar.LdD;
                    if (str != null) {
                        com.tencent.mm.plugin.card.d.b.a(historyCardListUI, str);
                        AppMethodBeat.o(201705);
                        return;
                    }
                    AppMethodBeat.o(201705);
                    return;
                case 2:
                    un unVar = ueVar.LdE;
                    if (unVar != null) {
                        com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                        AppMethodBeat.o(201705);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(201705);
            return;
        }
        AppMethodBeat.o(201705);
    }

    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, ArrayList arrayList) {
        boolean z;
        AppMethodBeat.i(201706);
        ArrayList arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ViewGroup viewGroup = historyCardListUI.qgI;
            if (viewGroup == null) {
                p.btv("mEmptyView");
            }
            viewGroup.setVisibility(0);
            c cVar = historyCardListUI.qjw;
            if (cVar == null) {
                p.btv("mHistoryCardListAdapter");
            }
            cVar.notifyDataSetChanged();
            AppMethodBeat.o(201706);
            return;
        }
        ViewGroup viewGroup2 = historyCardListUI.qgI;
        if (viewGroup2 == null) {
            p.btv("mEmptyView");
        }
        viewGroup2.setVisibility(8);
        c cVar2 = historyCardListUI.qjw;
        if (cVar2 == null) {
            p.btv("mHistoryCardListAdapter");
        }
        cVar2.P(arrayList);
        AppMethodBeat.o(201706);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, e eVar) {
        boolean z;
        AppMethodBeat.i(201707);
        if (eVar != null) {
            switch (g.$EnumSwitchMapping$0[eVar.ordinal()]) {
                case 1:
                    String str = eVar.msg;
                    if (str == null || str.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        com.tencent.mm.plugin.card.d.l.ar(historyCardListUI.getContext(), "");
                        AppMethodBeat.o(201707);
                        return;
                    }
                    com.tencent.mm.plugin.card.d.l.aq(historyCardListUI.getContext(), eVar.msg);
                    AppMethodBeat.o(201707);
                    return;
                case 2:
                    LoadMoreRecyclerView loadMoreRecyclerView = historyCardListUI.qju;
                    if (loadMoreRecyclerView == null) {
                        p.btv("mHistoryCardListRv");
                    }
                    loadMoreRecyclerView.showLoading(false);
                    AppMethodBeat.o(201707);
                    return;
                case 3:
                    LoadMoreRecyclerView loadMoreRecyclerView2 = historyCardListUI.qju;
                    if (loadMoreRecyclerView2 == null) {
                        p.btv("mHistoryCardListRv");
                    }
                    loadMoreRecyclerView2.showLoading(true);
                    break;
            }
            AppMethodBeat.o(201707);
            return;
        }
        AppMethodBeat.o(201707);
    }

    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, Boolean bool) {
        q qVar;
        AppMethodBeat.i(201708);
        if (bool != null) {
            if (bool.booleanValue()) {
                qVar = q.a(historyCardListUI.getContext(), historyCardListUI.getString(R.string.a06), true, 3, null);
            } else {
                q qVar2 = historyCardListUI.gxX;
                if (qVar2 != null) {
                    qVar2.dismiss();
                }
                qVar = null;
            }
            historyCardListUI.gxX = qVar;
        }
        AppMethodBeat.o(201708);
    }

    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, int i2) {
        ua uaVar;
        int i3;
        AppMethodBeat.i(201710);
        c cVar = historyCardListUI.qjw;
        if (cVar == null) {
            p.btv("mHistoryCardListAdapter");
        }
        a EF = cVar.EF(i2);
        if (EF == null || (uaVar = EF.qiw) == null) {
            AppMethodBeat.o(201710);
            return;
        }
        switch (uaVar.Ldc) {
            case 1:
                com.tencent.mm.plugin.card.d.b.a((MMActivity) historyCardListUI.getContext(), uaVar.Ldd);
                break;
            case 2:
                un unVar = uaVar.Lde;
                if (unVar != null) {
                    com.tencent.mm.plugin.card.d.b.H(unVar.Hwr, unVar.Hws, unVar.IhZ);
                    break;
                }
                break;
            default:
                Intent intent = new Intent(historyCardListUI.getContext(), CardDetailUI.class);
                intent.putExtra("key_card_id", uaVar.KDM);
                intent.addFlags(131072);
                intent.putExtra("key_from_scene", 3);
                AppCompatActivity context = historyCardListUI.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
        }
        switch (historyCardListUI.qjx) {
            case 2:
                i3 = 2;
                break;
            case 3:
                i3 = 1;
                break;
            default:
                i3 = 2;
                break;
        }
        Log.i("MicroMsg.HistoryCardListUI", "go to card detail ui, cardIndex: " + i2 + ", cardID: " + uaVar.KDM + ", pageScene: " + i3 + ", cardType: " + uaVar.Ldc);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21329, Integer.valueOf(i3), 1, uaVar.KDM, Integer.valueOf(i2));
        AppMethodBeat.o(201710);
    }

    public static final /* synthetic */ boolean a(HistoryCardListUI historyCardListUI, int i2, View view) {
        AppMethodBeat.i(201711);
        c cVar = historyCardListUI.qjw;
        if (cVar == null) {
            p.btv("mHistoryCardListAdapter");
        }
        a EF = cVar.EF(i2);
        if (EF != null) {
            switch (EF.type) {
                case 3:
                case 4:
                case 5:
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(historyCardListUI.getContext(), view);
                    aVar.a(new m(historyCardListUI, view, EF, i2));
                    aVar.a(new n(historyCardListUI, view, EF, i2));
                    Point dB = com.tencent.mm.plugin.card.d.m.dB(view);
                    aVar.ez(dB.x, dB.y);
                    break;
            }
        }
        AppMethodBeat.o(201711);
        return false;
    }

    public static final /* synthetic */ void a(HistoryCardListUI historyCardListUI, a aVar, int i2) {
        AppMethodBeat.i(201712);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) historyCardListUI.getContext(), 1, true);
        TextView textView = new TextView(historyCardListUI.getContext());
        textView.setText(historyCardListUI.getString(R.string.apu));
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(historyCardListUI.getResources().getColor(R.color.u_));
        textView.setGravity(17);
        int dimensionPixelSize = historyCardListUI.getResources().getDimensionPixelSize(R.dimen.ct);
        int dimensionPixelSize2 = historyCardListUI.getResources().getDimensionPixelSize(R.dimen.cb);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        eVar.V(textView, false);
        eVar.a(new j(historyCardListUI));
        eVar.a(new k(historyCardListUI, aVar, i2));
        eVar.dGm();
        AppMethodBeat.o(201712);
    }
}
