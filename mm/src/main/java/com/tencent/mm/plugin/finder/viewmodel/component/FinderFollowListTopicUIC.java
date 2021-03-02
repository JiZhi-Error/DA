package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract$FollowTopicPresenter$loadStart$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract$FollowTopicPresenter$loadStart$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract$FollowTopicViewCallback$initView$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract$FollowTopicViewCallback$initView$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract$FollowTopicViewCallback$initView$3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract$FollowTopicViewCallback$initView$4;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderFollowListTopicUIC extends UIComponent {
    public static final a wwo = new a((byte) 0);
    private final FinderFollowTopicListContract.FollowTopicPresenter uWW = new FinderFollowTopicListContract.FollowTopicPresenter();

    static {
        AppMethodBeat.i(255526);
        AppMethodBeat.o(255526);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowListTopicUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255525);
        AppMethodBeat.o(255525);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTopicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.abl;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255523);
        super.onCreate(bundle);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255523);
            throw tVar;
        }
        FinderFollowTopicListContract.FollowTopicViewCallback followTopicViewCallback = new FinderFollowTopicListContract.FollowTopicViewCallback((MMActivity) activity, getRootView(), this.uWW);
        this.uWW.a(followTopicViewCallback);
        View findViewById = followTopicViewCallback.contentView.findViewById(R.id.h7t);
        p.g(findViewById, "contentView.findViewById(R.id.rl_layout)");
        followTopicViewCallback.tLS = (RefreshLoadMoreLayout) findViewById;
        RefreshLoadMoreLayout refreshLoadMoreLayout = followTopicViewCallback.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        followTopicViewCallback.hak = refreshLoadMoreLayout.getRecyclerView();
        RecyclerView recyclerView = followTopicViewCallback.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        followTopicViewCallback.tFp = new WxRecyclerAdapter<>(new FinderFollowTopicListContract$FollowTopicViewCallback$initView$1(), followTopicViewCallback.uWW.kgc, true);
        RecyclerView recyclerView2 = followTopicViewCallback.hak;
        if (recyclerView2 == null) {
            p.btv("recyclerView");
        }
        WxRecyclerAdapter<bk> wxRecyclerAdapter = followTopicViewCallback.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        recyclerView2.setAdapter(wxRecyclerAdapter);
        WxRecyclerAdapter<bk> wxRecyclerAdapter2 = followTopicViewCallback.tFp;
        if (wxRecyclerAdapter2 == null) {
            p.btv("adapter");
        }
        wxRecyclerAdapter2.RqP = new FinderFollowTopicListContract$FollowTopicViewCallback$initView$2(followTopicViewCallback);
        WxRecyclerAdapter<bk> wxRecyclerAdapter3 = followTopicViewCallback.tFp;
        if (wxRecyclerAdapter3 == null) {
            p.btv("adapter");
        }
        wxRecyclerAdapter3.RqO = new FinderFollowTopicListContract$FollowTopicViewCallback$initView$3(followTopicViewCallback);
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = followTopicViewCallback.tLS;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout2.setOverCallback(followTopicViewCallback);
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = followTopicViewCallback.tLS;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout3.setActionCallback(new FinderFollowTopicListContract$FollowTopicViewCallback$initView$4(followTopicViewCallback));
        View findViewById2 = followTopicViewCallback.contentView.findViewById(R.id.c35);
        p.g(findViewById2, "contentView.findViewById<TextView>(R.id.empty_tip)");
        followTopicViewCallback.hRM = (TextView) findViewById2;
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        followTopicViewCallback.JT(aAh.azQ().getInt(ar.a.USERINFO_FINDER_TOPIC_FOLLOW_COUNT_INT_SYNC, 0));
        followTopicViewCallback.pqr = new com.tencent.mm.ui.widget.b.a(followTopicViewCallback.activity);
        FinderFollowTopicListContract.FollowTopicPresenter followTopicPresenter = followTopicViewCallback.uWW;
        d.b(d.a(d.aBx(), new FinderFollowTopicListContract$FollowTopicPresenter$loadStart$1(followTopicPresenter)), new FinderFollowTopicListContract$FollowTopicPresenter$loadStart$2(followTopicPresenter));
        followTopicPresenter.nO(false);
        AppMethodBeat.o(255523);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255524);
        super.onDestroy();
        this.uWW.onDetach();
        AppMethodBeat.o(255524);
    }
}
