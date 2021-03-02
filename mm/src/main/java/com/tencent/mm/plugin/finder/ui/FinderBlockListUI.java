package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract$BlockListPresenter$initData$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract$BlockListViewCallback$initView$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract$BlockListViewCallback$initView$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract$BlockListViewCallback$initView$3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract$BlockListViewCallback$initView$4;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract$BlockListViewCallback$initView$5;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0014J\b\u0010\u0019\u001a\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "type", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "getLayoutId", "initView", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "Companion", "plugin-finder_release"})
public final class FinderBlockListUI extends MMFinderUI {
    private static final int vHA = 20;
    private static final int vHB = 1;
    public static final a vHC = new a((byte) 0);
    private static final int vHz = 1;
    private final String TAG = "Finder.FinderBlockListUI";
    private HashMap _$_findViewCache;
    private int type;
    private FinderBlockListContract.BlockListViewCallback uWo;
    private ak uWp;
    private FinderBlockListContract.BlockListPresenter uWr;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252163);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252163);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252162);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252162);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI$Companion;", "", "()V", "MAX_MULTI_SELECTED_USER", "", "getMAX_MULTI_SELECTED_USER", "()I", "MENU_ID_ADD_USER", "getMENU_ID_ADD_USER", "REQUEST_CODE_MULTI_ADDR", "getREQUEST_CODE_MULTI_ADDR", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252161);
        AppMethodBeat.o(252161);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252156);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(252156);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        ae aeVar;
        AppMethodBeat.i(252157);
        this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
        switch (this.type) {
            case 1:
                aeVar = new ad();
                break;
            case 2:
                aeVar = new ae();
                break;
            case 3:
                aeVar = new com.tencent.mm.plugin.finder.storage.b();
                break;
            default:
                aeVar = null;
                break;
        }
        this.uWp = aeVar;
        if (this.uWp == null) {
            finish();
        }
        ak akVar = this.uWp;
        if (akVar == null) {
            p.hyc();
        }
        setMMTitle(akVar.dql());
        setBackBtn(new b(this));
        ak akVar2 = this.uWp;
        if (akVar2 == null) {
            p.hyc();
        }
        this.uWr = new FinderBlockListContract.BlockListPresenter(akVar2);
        FinderBlockListUI finderBlockListUI = this;
        View contentView = getContentView();
        p.g(contentView, "contentView");
        FinderBlockListContract.BlockListPresenter blockListPresenter = this.uWr;
        if (blockListPresenter == null) {
            p.hyc();
        }
        FinderBlockListContract.BlockListViewCallback blockListViewCallback = new FinderBlockListContract.BlockListViewCallback(finderBlockListUI, contentView, blockListPresenter);
        FinderBlockListContract.BlockListPresenter blockListPresenter2 = this.uWr;
        if (blockListPresenter2 == null) {
            p.hyc();
        }
        blockListPresenter2.a(blockListViewCallback);
        View findViewById = blockListViewCallback.contentView.findViewById(R.id.h7t);
        p.g(findViewById, "contentView.findViewById(R.id.rl_layout)");
        blockListViewCallback.tLS = (RefreshLoadMoreLayout) findViewById;
        RefreshLoadMoreLayout refreshLoadMoreLayout = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        refreshLoadMoreLayout.setLimitTopRequest(((int) context.getResources().getDimension(R.dimen.a5g)) - ((int) context2.getResources().getDimension(R.dimen.bx)));
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("rlLayout");
        }
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        Context context4 = MMApplicationContext.getContext();
        p.g(context4, "MMApplicationContext.getContext()");
        refreshLoadMoreLayout2.setRefreshTargetY(((int) context3.getResources().getDimension(R.dimen.cp)) - ((int) context4.getResources().getDimension(R.dimen.a5g)));
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout3.setDamping(1.85f);
        RefreshLoadMoreLayout refreshLoadMoreLayout4 = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout4 == null) {
            p.btv("rlLayout");
        }
        blockListViewCallback.hak = refreshLoadMoreLayout4.getRecyclerView();
        RecyclerView recyclerView = blockListViewCallback.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        RefreshLoadMoreLayout refreshLoadMoreLayout5 = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout5 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout5.setEnableLoadMore(blockListViewCallback.uWr.uWp.dqq());
        blockListViewCallback.tFp = new WxRecyclerAdapter<>(new FinderBlockListContract$BlockListViewCallback$initView$1(), blockListViewCallback.uWr.kgc, true);
        if (blockListViewCallback.uWs == null) {
            blockListViewCallback.uWs = new i();
        }
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> wxRecyclerAdapter = blockListViewCallback.tFp;
        if (wxRecyclerAdapter == null) {
            p.hyc();
        }
        i iVar = blockListViewCallback.uWs;
        if (iVar == null) {
            p.hyc();
        }
        wxRecyclerAdapter.a((g) iVar, (g.b) true);
        RecyclerView recyclerView2 = blockListViewCallback.hak;
        if (recyclerView2 == null) {
            p.btv("recyclerView");
        }
        recyclerView2.post(new FinderBlockListContract$BlockListViewCallback$initView$2(blockListViewCallback));
        CharSequence hUL = blockListViewCallback.uWr.uWp.hUL();
        if (!(hUL == null || hUL.length() == 0)) {
            WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> wxRecyclerAdapter2 = blockListViewCallback.tFp;
            if (wxRecyclerAdapter2 == null) {
                p.hyc();
            }
            wxRecyclerAdapter2.a((g) new m(blockListViewCallback.uWr.uWp), (g.b) true);
        }
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> wxRecyclerAdapter3 = blockListViewCallback.tFp;
        if (wxRecyclerAdapter3 != null) {
            wxRecyclerAdapter3.RqP = new FinderBlockListContract$BlockListViewCallback$initView$3(blockListViewCallback);
        }
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.p> wxRecyclerAdapter4 = blockListViewCallback.tFp;
        if (wxRecyclerAdapter4 != null) {
            wxRecyclerAdapter4.RqO = new FinderBlockListContract$BlockListViewCallback$initView$4(blockListViewCallback);
        }
        RecyclerView recyclerView3 = blockListViewCallback.hak;
        if (recyclerView3 == null) {
            p.btv("recyclerView");
        }
        recyclerView3.setAdapter(blockListViewCallback.tFp);
        RefreshLoadMoreLayout refreshLoadMoreLayout6 = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout6 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout6.setOverCallback(blockListViewCallback);
        RefreshLoadMoreLayout refreshLoadMoreLayout7 = blockListViewCallback.tLS;
        if (refreshLoadMoreLayout7 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout7.setActionCallback(new FinderBlockListContract$BlockListViewCallback$initView$5(blockListViewCallback));
        this.uWo = blockListViewCallback;
        ak akVar3 = this.uWp;
        if (akVar3 == null) {
            p.hyc();
        }
        if (akVar3.dqn()) {
            addIconOptionMenu(0, R.raw.icons_outlined_add_friends, new c(this));
        }
        AppMethodBeat.o(252157);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderBlockListUI vHD;

        b(FinderBlockListUI finderBlockListUI) {
            this.vHD = finderBlockListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252154);
            this.vHD.finish();
            AppMethodBeat.o(252154);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderBlockListUI vHD;

        c(FinderBlockListUI finderBlockListUI) {
            this.vHD = finderBlockListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252155);
            Log.i(this.vHD.TAG, "doCallSelectContactUIForMultiRetransmit");
            Intent intent = new Intent();
            intent.setClassName(this.vHD, "com.tencent.mm.ui.contact.SelectContactUI");
            intent.putExtra("list_type", 1);
            intent.putExtra("titile", this.vHD.getString(R.string.d1m));
            intent.putExtra("list_attr", u.PWT);
            FinderBlockListContract.BlockListPresenter blockListPresenter = this.vHD.uWr;
            if (blockListPresenter == null) {
                p.hyc();
            }
            ArrayList<com.tencent.mm.plugin.finder.model.p> arrayList = blockListPresenter.kgc;
            ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().contact.username);
            }
            intent.putExtra("always_select_contact", Util.listToString(arrayList2, ","));
            intent.putExtra("block_contact", z.aTY());
            a aVar = FinderBlockListUI.vHC;
            intent.putExtra("max_limit_num", FinderBlockListUI.vHA);
            intent.putExtra("Forbid_SelectChatRoom", true);
            AppCompatActivity context = this.vHD.getContext();
            a aVar2 = FinderBlockListUI.vHC;
            context.startActivityForResult(intent, FinderBlockListUI.vHB);
            AppMethodBeat.o(252155);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(252158);
        super.onActivityResult(i2, i3, intent);
        if (i2 == vHB) {
            List<String> stringToList = Util.stringToList(intent != null ? intent.getStringExtra("Select_Contact") : null, ",");
            p.g(stringToList, "nameList");
            List<String> list = stringToList;
            ArrayList arrayList = new ArrayList(j.a(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                FinderContact finderContact = new FinderContact();
                finderContact.username = it.next();
                arrayList.add(finderContact);
            }
            ArrayList arrayList2 = arrayList;
            FinderBlockListContract.BlockListPresenter blockListPresenter = this.uWr;
            if (blockListPresenter != null) {
                blockListPresenter.eo(arrayList2);
                AppMethodBeat.o(252158);
                return;
            }
        }
        AppMethodBeat.o(252158);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a9h;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252159);
        super.onDestroy();
        FinderBlockListContract.BlockListPresenter blockListPresenter = this.uWr;
        if (blockListPresenter != null) {
            blockListPresenter.onDetach();
            AppMethodBeat.o(252159);
            return;
        }
        AppMethodBeat.o(252159);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(252160);
        super.onResume();
        FinderBlockListContract.BlockListPresenter blockListPresenter = this.uWr;
        if (blockListPresenter != null) {
            ArrayList arrayList = new ArrayList();
            LinkedList<FinderContact> dqp = blockListPresenter.uWp.dqp();
            if (dqp != null) {
                Iterator<T> it = dqp.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.tencent.mm.plugin.finder.model.p(it.next()));
                }
            }
            if (!arrayList.isEmpty()) {
                FinderBlockListContract.BlockListViewCallback blockListViewCallback = blockListPresenter.uWo;
                if (blockListViewCallback != null) {
                    blockListViewCallback.e(arrayList, true);
                }
            } else {
                FinderBlockListContract.BlockListViewCallback blockListViewCallback2 = blockListPresenter.uWo;
                if (blockListViewCallback2 != null) {
                    blockListViewCallback2.bIo();
                }
            }
            d.a(300, new FinderBlockListContract$BlockListPresenter$initData$1(blockListPresenter));
            AppMethodBeat.o(252160);
            return;
        }
        AppMethodBeat.o(252160);
    }
}
