package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initAndRefreshAll$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initAndRefreshAll$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initView$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initView$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initView$3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initView$4;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$refresh$1;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

public final class FinderNotifyUIC extends UIComponent implements i, FinderNotifyContract.NotifyViewCallback.UICallbackListener {
    private static final String[] wyP = {"NotificationCenterLike", "NotificationCenterComment", "NotificationCenterFollow"};
    public static final a wyQ = new a((byte) 0);
    public int index = -1;
    private FinderNotifyContract.NotifyPresenter uZa;
    private int wyL;
    private int wyM;
    private boolean wyN;
    private FinderNotifyContract.NotifyViewCallback wyO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderNotifyUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255853);
        AppMethodBeat.o(255853);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String My(int i2) {
            switch (i2) {
                case 0:
                    return "NotificationCenterLike";
                case 1:
                    return "NotificationCenterComment";
                case 2:
                    return "NotificationCenterFollow";
                default:
                    return "";
            }
        }
    }

    static {
        AppMethodBeat.i(255854);
        AppMethodBeat.o(255854);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        List<Boolean> list;
        String str;
        f d2;
        AppMethodBeat.i(255845);
        super.onCreateAfter(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        this.wyL = ((FinderTabStateCacheVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class)).dHU();
        this.uZa = dIq();
        Fragment fragment = getFragment();
        FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255845);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        View rootView = getRootView();
        FinderNotifyContract.NotifyPresenter dIq = dIq();
        if (dIq == null) {
            p.hyc();
        }
        FinderNotifyContract.NotifyViewCallback notifyViewCallback = new FinderNotifyContract.NotifyViewCallback(mMActivity, rootView, dIq, this, this.index);
        FinderNotifyContract.NotifyPresenter notifyPresenter = this.uZa;
        if (notifyPresenter != null) {
            notifyPresenter.a(notifyViewCallback);
        }
        notifyViewCallback.tLS = (RefreshLoadMoreLayout) notifyViewCallback.contentView.findViewById(R.id.h7t);
        if (!notifyViewCallback.uYZ) {
            RefreshLoadMoreLayout refreshLoadMoreLayout = notifyViewCallback.tLS;
            if (refreshLoadMoreLayout != null) {
                refreshLoadMoreLayout.setEnableRefresh(false);
            }
        } else {
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = notifyViewCallback.tLS;
            if (refreshLoadMoreLayout2 != null) {
                refreshLoadMoreLayout2.setEnableRefresh(false);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                refreshLoadMoreLayout2.setLimitTopRequest(((int) context.getResources().getDimension(R.dimen.a5g)) - ((int) context2.getResources().getDimension(R.dimen.bx)));
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                Context context4 = MMApplicationContext.getContext();
                p.g(context4, "MMApplicationContext.getContext()");
                refreshLoadMoreLayout2.setRefreshTargetY(((int) context3.getResources().getDimension(R.dimen.cp)) - ((int) context4.getResources().getDimension(R.dimen.a5g)));
                refreshLoadMoreLayout2.setDamping(1.85f);
                notifyViewCallback.tSY = (MMProcessBar) notifyViewCallback.contentView.findViewById(R.id.h7v);
                refreshLoadMoreLayout2.setActionCallback(new FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1(refreshLoadMoreLayout2, notifyViewCallback));
                refreshLoadMoreLayout2.setOverCallback(notifyViewCallback);
            }
        }
        View findViewById = notifyViewCallback.contentView.findViewById(R.id.g2l);
        p.g(findViewById, "contentView.findViewById….id.notify_recycler_view)");
        notifyViewCallback.hak = (RecyclerView) findViewById;
        RecyclerView recyclerView = notifyViewCallback.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        notifyViewCallback.uYA = (TextView) notifyViewCallback.contentView.findViewById(R.id.g2m);
        TextView textView = notifyViewCallback.uYA;
        if (textView != null) {
            textView.setOnClickListener(new FinderNotifyContract$NotifyViewCallback$initView$1(notifyViewCallback));
        }
        notifyViewCallback.tFp = new WxRecyclerAdapter<>(new FinderNotifyContract$NotifyViewCallback$initView$2(notifyViewCallback), notifyViewCallback.uZa.JV(notifyViewCallback.uZc), true);
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter = notifyViewCallback.tFp;
        if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.RrA = new FinderNotifyContract$NotifyViewCallback$initView$3(notifyViewCallback);
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(notifyViewCallback.gte);
        if (!(fH == null || (d2 = FinderReporterUIC.d(fH)) == null)) {
            RecyclerView recyclerView2 = notifyViewCallback.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            d2.m(recyclerView2);
        }
        RecyclerView recyclerView3 = notifyViewCallback.hak;
        if (recyclerView3 == null) {
            p.btv("recyclerView");
        }
        recyclerView3.setAdapter(notifyViewCallback.tFp);
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter2 = notifyViewCallback.tFp;
        if (wxRecyclerAdapter2 != null) {
            wxRecyclerAdapter2.RqP = new FinderNotifyContract$NotifyViewCallback$initView$4(notifyViewCallback);
        }
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW = ((PluginFinder) ah).getRedDotManager().asW(wyP[this.index]);
        this.wyM = asW != null ? asW.count : 0;
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        Fragment fragment2 = getFragment();
        if (fragment2 == null) {
            p.hyc();
        }
        FragmentActivity activity2 = fragment2.getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255845);
            throw tVar2;
        }
        com.tencent.mm.plugin.finder.view.tabcomp.a MI = ((FinderMsgNotifyTabUIC) com.tencent.mm.ui.component.a.b((MMActivity) activity2).get(FinderMsgNotifyTabUIC.class)).MI(this.index);
        if ((MI instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a) && this.wyM > 0) {
            if (this.wyM > 9999) {
                str = "+" + (this.wyM / 10000) + (char) 19975;
            } else {
                str = "+" + this.wyM;
            }
            Log.i("SimpleUIComponent", "setRedDot " + this.index + ':' + str);
            MI.by(str, true);
        }
        if (this.wyL == this.index) {
            FinderNotifyContract.NotifyPresenter notifyPresenter2 = this.uZa;
            if (!(notifyPresenter2 == null || (list = notifyPresenter2.uYL) == null)) {
                list.set(this.index, Boolean.TRUE);
            }
            Log.i(notifyViewCallback.TAG, "initRefresh:" + notifyViewCallback.uZc);
            d.a(d.aBx(), new FinderNotifyContract$NotifyViewCallback$initAndRefreshAll$1(notifyViewCallback));
            d.a(200, new FinderNotifyContract$NotifyViewCallback$initAndRefreshAll$2(notifyViewCallback));
            cnl();
            this.wyN = true;
        } else {
            cnl();
            if (!this.wyN) {
                Log.i("SimpleUIComponent", "refresh index: " + this.index);
                Log.i(notifyViewCallback.TAG, "refresh: " + notifyViewCallback.uZc);
                d.a(250, new FinderNotifyContract$NotifyViewCallback$refresh$1(notifyViewCallback));
                this.wyN = true;
            }
        }
        if (this.wyM > 0) {
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah2).getRedDotManager().asV(wyP[this.index]);
        }
        this.wyO = notifyViewCallback;
        AppMethodBeat.o(255845);
    }

    private final void cnl() {
        bbn bbn;
        bbn bbn2;
        AppMethodBeat.i(255846);
        String My = a.My(this.index);
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        k asX = ((PluginFinder) ah).getRedDotManager().asX(My);
        com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        bdo asW = ((PluginFinder) ah2).getRedDotManager().asW(My);
        y yVar = y.vXH;
        Fragment fragment = getFragment();
        if (!(asX == null || asW == null || fragment == null)) {
            j jVar = j.vft;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FragmentActivity activity = fragment.getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255846);
                throw tVar;
            }
            FinderReporterUIC fH = FinderReporterUIC.a.fH((MMActivity) activity);
            if (fH != null) {
                bbn = fH.dIx();
            } else {
                bbn = null;
            }
            j.a("5", asX, asW, 1, bbn, 0, 0, 96);
            if (this.wyL == this.index) {
                j jVar2 = j.vft;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                FragmentActivity activity2 = fragment.getActivity();
                if (activity2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(255846);
                    throw tVar2;
                }
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH((MMActivity) activity2);
                if (fH2 != null) {
                    bbn2 = fH2.dIx();
                } else {
                    bbn2 = null;
                }
                j.a("5", asX, asW, 3, bbn2, 1, 0, 64);
            }
        }
        AppMethodBeat.o(255846);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        List<Boolean> list;
        AppMethodBeat.i(255847);
        Log.i("SimpleUIComponent", "onUserVisibleFocused:" + this.wyN + "  " + this.index);
        FinderNotifyContract.NotifyPresenter notifyPresenter = this.uZa;
        if (notifyPresenter == null || (list = notifyPresenter.uYL) == null) {
            AppMethodBeat.o(255847);
            return;
        }
        list.set(this.index, Boolean.TRUE);
        AppMethodBeat.o(255847);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(255848);
        Log.i("SimpleUIComponent", "onUserVisibleUnFocused:" + this.wyN + "  " + this.index);
        AppMethodBeat.o(255848);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter;
        AppMethodBeat.i(255849);
        super.onResume();
        FinderNotifyContract.NotifyViewCallback notifyViewCallback = this.wyO;
        if (notifyViewCallback == null || (wxRecyclerAdapter = notifyViewCallback.tFp) == null) {
            AppMethodBeat.o(255849);
            return;
        }
        wxRecyclerAdapter.onResume();
        AppMethodBeat.o(255849);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter;
        AppMethodBeat.i(255850);
        super.onPause();
        FinderNotifyContract.NotifyViewCallback notifyViewCallback = this.wyO;
        if (notifyViewCallback == null || (wxRecyclerAdapter = notifyViewCallback.tFp) == null) {
            AppMethodBeat.o(255850);
            return;
        }
        wxRecyclerAdapter.onPause();
        AppMethodBeat.o(255850);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ahj;
    }

    private final FinderNotifyContract.NotifyPresenter dIq() {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        AppMethodBeat.i(255851);
        Fragment fragment = getFragment();
        if (fragment != null) {
            fragmentActivity = fragment.getActivity();
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity instanceof FinderFinderMsgUI) {
            Fragment fragment2 = getFragment();
            if (fragment2 != null) {
                fragmentActivity2 = fragment2.getActivity();
            } else {
                fragmentActivity2 = null;
            }
            if (fragmentActivity2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI");
                AppMethodBeat.o(255851);
                throw tVar;
            }
            FinderNotifyContract.NotifyPresenter notifyPresenter = ((FinderFinderMsgUI) fragmentActivity2).uZa;
            AppMethodBeat.o(255851);
            return notifyPresenter;
        }
        AppMethodBeat.o(255851);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.UICallbackListener
    public final void a(ao aoVar) {
        AppMethodBeat.i(255852);
        p.h(aoVar, "mention");
        AppMethodBeat.o(255852);
    }
}
