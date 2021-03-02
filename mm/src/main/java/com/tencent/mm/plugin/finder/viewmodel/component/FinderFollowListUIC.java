package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListPresent$loadStart$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListPresent$loadStart$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListViewCallback$initView$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListViewCallback$initView$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListViewCallback$initView$3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListViewCallback$initView$4;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListViewCallback$initView$5;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract$FollowListViewCallback$initView$6;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.t;

public final class FinderFollowListUIC extends UIComponent {
    private static final String uWR = uWR;
    public static final a wwp = new a((byte) 0);
    private final FinderFollowListContract.FollowListPresent uWL = new FinderFollowListContract.FollowListPresent();
    private boolean uWM;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFollowListUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255532);
        AppMethodBeat.o(255532);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.abj;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255528);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.uWM = (intent != null ? Boolean.valueOf(intent.getBooleanExtra("from_teen_mode_setting_page", false)) : null).booleanValue();
        Log.i("Finder.FinderFollowListUIC", "initDataFromIntent, isFromTeenModeSettingPage:" + this.uWM);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255528);
            throw tVar;
        }
        FinderFollowListContract.FollowListViewCallback followListViewCallback = new FinderFollowListContract.FollowListViewCallback((MMActivity) activity, getRootView(), this.uWL, this.uWM);
        this.uWL.a(followListViewCallback);
        View findViewById = followListViewCallback.contentView.findViewById(R.id.h7t);
        p.g(findViewById, "contentView.findViewById(R.id.rl_layout)");
        followListViewCallback.tLS = (RefreshLoadMoreLayout) findViewById;
        RefreshLoadMoreLayout refreshLoadMoreLayout = followListViewCallback.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        refreshLoadMoreLayout.setLimitTopRequest(((int) context.getResources().getDimension(R.dimen.a5g)) - ((int) context2.getResources().getDimension(R.dimen.bx)));
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = followListViewCallback.tLS;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("rlLayout");
        }
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        Context context4 = MMApplicationContext.getContext();
        p.g(context4, "MMApplicationContext.getContext()");
        refreshLoadMoreLayout2.setRefreshTargetY(((int) context3.getResources().getDimension(R.dimen.cp)) - ((int) context4.getResources().getDimension(R.dimen.a5g)));
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = followListViewCallback.tLS;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout3.setDamping(1.85f);
        View findViewById2 = followListViewCallback.contentView.findViewById(R.id.h7v);
        p.g(findViewById2, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
        followListViewCallback.tSY = (MMProcessBar) findViewById2;
        RefreshLoadMoreLayout refreshLoadMoreLayout4 = followListViewCallback.tLS;
        if (refreshLoadMoreLayout4 == null) {
            p.btv("rlLayout");
        }
        followListViewCallback.hak = refreshLoadMoreLayout4.getRecyclerView();
        RecyclerView recyclerView = followListViewCallback.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        followListViewCallback.tFp = new WxRecyclerAdapter<>(new FinderFollowListContract$FollowListViewCallback$initView$1(followListViewCallback), followListViewCallback.uWL.kgc, true);
        RecyclerView recyclerView2 = followListViewCallback.hak;
        if (recyclerView2 == null) {
            p.btv("recyclerView");
        }
        recyclerView2.setAdapter(followListViewCallback.tFp);
        WxRecyclerAdapter<af> wxRecyclerAdapter = followListViewCallback.tFp;
        if (wxRecyclerAdapter == null) {
            p.hyc();
        }
        wxRecyclerAdapter.RqP = new FinderFollowListContract$FollowListViewCallback$initView$2(followListViewCallback);
        WxRecyclerAdapter<af> wxRecyclerAdapter2 = followListViewCallback.tFp;
        if (wxRecyclerAdapter2 == null) {
            p.hyc();
        }
        wxRecyclerAdapter2.RqO = new FinderFollowListContract$FollowListViewCallback$initView$3(followListViewCallback);
        RefreshLoadMoreLayout refreshLoadMoreLayout5 = followListViewCallback.tLS;
        if (refreshLoadMoreLayout5 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout5.setOverCallback(followListViewCallback);
        RefreshLoadMoreLayout refreshLoadMoreLayout6 = followListViewCallback.tLS;
        if (refreshLoadMoreLayout6 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout6.setActionCallback(new FinderFollowListContract$FollowListViewCallback$initView$4(followListViewCallback));
        View findViewById3 = followListViewCallback.contentView.findViewById(R.id.c35);
        p.g(findViewById3, "contentView.findViewById<TextView>(R.id.empty_tip)");
        followListViewCallback.hRM = (TextView) findViewById3;
        followListViewCallback.dlR();
        followListViewCallback.pqr = new com.tencent.mm.ui.widget.b.a(followListViewCallback.activity);
        followListViewCallback.activity.setBackBtn(new FinderFollowListContract$FollowListViewCallback$initView$5(followListViewCallback));
        FinderFollowListContract.FollowListPresent followListPresent = followListViewCallback.uWL;
        d.b(d.a(d.aBx(), new FinderFollowListContract$FollowListPresent$loadStart$1(followListPresent)), new FinderFollowListContract$FollowListPresent$loadStart$2(followListPresent));
        followListPresent.nO(false);
        c cVar = c.vCb;
        if (c.drt()) {
            com.tencent.mm.kernel.c.a af = g.af(ad.class);
            p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((ad) af).dxX()) {
                followListViewCallback.activity.addIconOptionMenu(0, R.raw.icons_outlined_search, new FinderFollowListContract$FollowListViewCallback$initView$6(followListViewCallback));
            }
        }
        RecyclerView recyclerView3 = followListViewCallback.hak;
        if (recyclerView3 == null) {
            p.btv("recyclerView");
        }
        recyclerView3.a(followListViewCallback.uWK);
        AppMethodBeat.o(255528);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255529);
        super.onDestroy();
        this.uWL.onDetach();
        AppMethodBeat.o(255529);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static com.tencent.mm.plugin.finder.api.g f(FinderContact finderContact) {
            AppMethodBeat.i(255527);
            p.h(finderContact, "fcontact");
            com.tencent.mm.plugin.finder.api.g gVar = new com.tencent.mm.plugin.finder.api.g();
            String str = finderContact.username;
            if (str == null) {
                str = "";
            }
            gVar.setUsername(str);
            String str2 = finderContact.headUrl;
            if (str2 == null) {
                str2 = "";
            }
            gVar.asL(str2);
            String str3 = finderContact.nickname;
            if (str3 == null) {
                str3 = "";
            }
            gVar.setNickname(str3);
            gVar.field_version = finderContact.seq;
            String str4 = finderContact.signature;
            if (str4 == null) {
                str4 = "";
            }
            gVar.field_signature = str4;
            gVar.field_follow_Flag = finderContact.followFlag;
            String str5 = finderContact.nickname;
            if (str5 == null) {
                str5 = "";
            }
            gVar.field_pyInitial = f.Si(str5);
            gVar.field_followTime = finderContact.followTime;
            String str6 = finderContact.coverImgUrl;
            if (str6 == null) {
                str6 = "";
            }
            gVar.field_coverImg = str6;
            gVar.field_spamStatus = finderContact.spamStatus;
            gVar.field_authInfo = finderContact.authInfo;
            gVar.field_extInfo = finderContact.extInfo;
            gVar.field_extFlag = finderContact.extFlag;
            gVar.field_liveCoverImg = finderContact.liveCoverImgUrl;
            gVar.field_liveStatus = finderContact.liveStatus;
            gVar.field_v5username = finderContact.wx_username_v5;
            AppMethodBeat.o(255527);
            return gVar;
        }
    }

    static {
        AppMethodBeat.i(255533);
        AppMethodBeat.o(255533);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255530);
        super.onResume();
        k kVar = k.vkd;
        k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, "12", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(255530);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255531);
        super.onPause();
        k kVar = k.vkd;
        k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, "12", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(255531);
    }
}
