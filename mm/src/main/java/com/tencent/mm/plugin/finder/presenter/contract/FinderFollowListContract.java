package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract;", "", "()V", "FollowListPresent", "FollowListViewCallback", "plugin-finder_release"})
public final class FinderFollowListContract {
    public static final FinderFollowListContract uWB = new FinderFollowListContract();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J,\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020+0*J&\u0010,\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "clearLastBuff", "", "doGetFollowScene", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "printDebugFinderContactList", "firstPage", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refresh", "plugin-finder_release"})
    public static final class FollowListPresent implements i, a<FollowListViewCallback> {
        private final String TAG = ("Finder.FinderFollowListContract.FollowListPresent." + hashCode());
        boolean hasMore;
        public final ArrayList<af> kgc = new ArrayList<>();
        private boolean tQl;
        private long tQo;
        b tsO;
        private FollowListViewCallback uWC;
        private final g uWD;

        public FollowListPresent() {
            AppMethodBeat.i(249725);
            FinderFollowListUIC.a aVar = FinderFollowListUIC.wwp;
            this.uWD = new g(FinderFollowListUIC.uWR);
            this.hasMore = true;
            this.tQo = SystemClock.uptimeMillis();
            AppMethodBeat.o(249725);
        }

        public static final /* synthetic */ FollowListViewCallback e(FollowListPresent followListPresent) {
            AppMethodBeat.i(249727);
            FollowListViewCallback followListViewCallback = followListPresent.uWC;
            if (followListViewCallback == null) {
                p.btv("viewCallback");
            }
            AppMethodBeat.o(249727);
            return followListViewCallback;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(FollowListViewCallback followListViewCallback) {
            AppMethodBeat.i(249720);
            a(followListViewCallback);
            AppMethodBeat.o(249720);
        }

        public final void a(FollowListViewCallback followListViewCallback) {
            AppMethodBeat.i(249719);
            p.h(followListViewCallback, "callback");
            this.uWC = followListViewCallback;
            com.tencent.mm.kernel.g.azz().a(713, this);
            com.tencent.mm.kernel.g.azz().a(3867, this);
            AppMethodBeat.o(249719);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            AppMethodBeat.i(249721);
            com.tencent.mm.kernel.g.azz().b(713, this);
            com.tencent.mm.kernel.g.azz().b(3867, this);
            FollowListViewCallback followListViewCallback = this.uWC;
            if (followListViewCallback == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView = followListViewCallback.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            recyclerView.b(followListViewCallback.uWK);
            AppMethodBeat.o(249721);
        }

        /* JADX WARNING: Removed duplicated region for block: B:57:0x015e  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
            /*
            // Method dump skipped, instructions count: 466
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }

        public final void nO(boolean z) {
            AppMethodBeat.i(249723);
            this.tQo = SystemClock.uptimeMillis();
            this.tQl = z;
            com.tencent.mm.kernel.g.azz().b(new bj(this.tsO));
            AppMethodBeat.o(249723);
        }

        private void c(boolean z, List<? extends FinderContact> list) {
            AppMethodBeat.i(249724);
            p.h(list, "dataList");
            y yVar = y.vXH;
            if (!y.dCM()) {
                AppMethodBeat.o(249724);
                return;
            }
            StringBuilder sb = new StringBuilder("firstPage:" + z + ';');
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("[" + i2 + "]:").append(com.tencent.mm.ac.g.bN(list.get(i2))).append(";");
            }
            Log.i(this.TAG, "printFinderContactList :".concat(String.valueOf(sb)));
            AppMethodBeat.o(249724);
        }

        public static final /* synthetic */ void a(FollowListPresent followListPresent, boolean z, List list, boolean z2) {
            int i2;
            AppMethodBeat.i(249726);
            Log.i(followListPresent.TAG, "firstPage " + z + ", get follow contact " + list.size());
            int size = followListPresent.kgc.size();
            int size2 = list.size();
            if (z) {
                followListPresent.kgc.clear();
                i2 = -1;
                size = -1;
            } else {
                i2 = size2;
            }
            ArrayList<af> arrayList = followListPresent.kgc;
            List<FinderContact> list2 = list;
            ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
            for (FinderContact finderContact : list2) {
                FinderFollowListUIC.a aVar = FinderFollowListUIC.wwp;
                arrayList2.add(new af(FinderFollowListUIC.a.f(finderContact)));
            }
            arrayList.addAll(arrayList2);
            FollowListViewCallback followListViewCallback = followListPresent.uWC;
            if (followListViewCallback == null) {
                p.btv("viewCallback");
            }
            followListViewCallback.f(z2, size, i2);
            followListPresent.c(z, list);
            AppMethodBeat.o(249726);
        }
    }

    static {
        AppMethodBeat.i(249750);
        AppMethodBeat.o(249750);
    }

    private FinderFollowListContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001a\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0005H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010(\u001a\u00020%J0\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J0\u0010/\u001a\u00020\n2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J\u0010\u00100\u001a\u00020%2\u0006\u0010,\u001a\u00020\rH\u0016J\"\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u00020\rJ\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J\u0018\u00107\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0007H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isFromTeenModeSettingPage", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;Z)V", "MENU_ID_UNFOLLOW", "", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "mHellScrollListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "addScrollListener", "", "getActivity", "getPresenter", "initView", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "removeScrollListener", "showPopupMenu", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "anchor", "plugin-finder_release"})
    public static final class FollowListViewCallback implements c<FollowListPresent>, HeadFooterLayout.b {
        private final String TAG = ("Finder.FinderFollowListContract.FollowListViewCallback." + hashCode());
        public final MMActivity activity;
        public final View contentView;
        public TextView hRM;
        public RecyclerView hak;
        public com.tencent.mm.ui.widget.b.a pqr;
        public WxRecyclerAdapter<af> tFp;
        public RefreshLoadMoreLayout tLS;
        public MMProcessBar tSY;
        private final int tzW = 1001;
        public final FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1 uWK = new FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1();
        public final FollowListPresent uWL;
        private final boolean uWM;

        public FollowListViewCallback(MMActivity mMActivity, View view, FollowListPresent followListPresent, boolean z) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(view, "contentView");
            p.h(followListPresent, "presenter");
            AppMethodBeat.i(249747);
            this.activity = mMActivity;
            this.contentView = view;
            this.uWL = followListPresent;
            this.uWM = z;
            AppMethodBeat.o(249747);
        }

        public static final /* synthetic */ RefreshLoadMoreLayout g(FollowListViewCallback followListViewCallback) {
            AppMethodBeat.i(249749);
            RefreshLoadMoreLayout refreshLoadMoreLayout = followListViewCallback.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(249749);
            return refreshLoadMoreLayout;
        }

        public static /* synthetic */ void b(FollowListViewCallback followListViewCallback) {
            AppMethodBeat.i(249742);
            followListViewCallback.f(false, -1, -1);
            AppMethodBeat.o(249742);
        }

        public final void f(boolean z, int i2, int i3) {
            AppMethodBeat.i(249741);
            if (i2 < 0 || i3 <= 0) {
                WxRecyclerAdapter<af> wxRecyclerAdapter = this.tFp;
                if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.notifyDataSetChanged();
                }
            } else {
                WxRecyclerAdapter<af> wxRecyclerAdapter2 = this.tFp;
                if (wxRecyclerAdapter2 != null) {
                    wxRecyclerAdapter2.as(i2, i3);
                }
            }
            if (z) {
                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                cVar.Rmj = this.uWL.hasMore;
                cVar.Rmk = i3;
                if (cVar.Rmk > 0) {
                    cVar.jLE = false;
                }
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                if (refreshLoadMoreLayout == null) {
                    p.btv("rlLayout");
                }
                refreshLoadMoreLayout.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(249741);
                return;
            }
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout2.apS(0);
            if (!this.uWL.hasMore) {
                RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
                if (refreshLoadMoreLayout3 == null) {
                    p.btv("rlLayout");
                }
                RefreshLoadMoreLayout.e(refreshLoadMoreLayout3);
            }
            AppMethodBeat.o(249741);
        }

        public final void dlR() {
            AppMethodBeat.i(249743);
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FOLLOW_COUNT_INT_SYNC, 0);
            this.activity.setMMTitle(c.a.a(this).getString(R.string.d2t, Integer.valueOf(i2)));
            if (i2 == 0) {
                TextView textView = this.hRM;
                if (textView == null) {
                    p.btv("emptyTip");
                }
                textView.setVisibility(0);
                TextView textView2 = this.hRM;
                if (textView2 == null) {
                    p.btv("emptyTip");
                }
                textView2.setText(this.activity.getString(R.string.cod));
                AppMethodBeat.o(249743);
                return;
            }
            TextView textView3 = this.hRM;
            if (textView3 == null) {
                p.btv("emptyTip");
            }
            textView3.setVisibility(8);
            AppMethodBeat.o(249743);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final void ddr() {
            AppMethodBeat.i(249744);
            Log.i(this.TAG, "[onOverStop]");
            MMProcessBar mMProcessBar = this.tSY;
            if (mMProcessBar == null) {
                p.btv("rlProcessBar");
            }
            mMProcessBar.gYP();
            AppMethodBeat.o(249744);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean u(int i2, int i3, boolean z) {
            AppMethodBeat.i(249745);
            Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(i2)));
            MMProcessBar mMProcessBar = this.tSY;
            if (mMProcessBar == null) {
                p.btv("rlProcessBar");
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            mMProcessBar.rotate(((float) i2) / ((float) ((int) context.getResources().getDimension(R.dimen.ca))));
            AppMethodBeat.o(249745);
            return false;
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean IJ(int i2) {
            AppMethodBeat.i(249746);
            Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(i2)));
            AppMethodBeat.o(249746);
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }

        public static final /* synthetic */ void a(FollowListViewCallback followListViewCallback, com.tencent.mm.plugin.finder.api.g gVar, View view) {
            AppMethodBeat.i(249748);
            com.tencent.mm.ui.widget.b.a aVar = followListViewCallback.pqr;
            if (aVar == null) {
                p.btv("popupMenu");
            }
            aVar.gNq();
            com.tencent.mm.ui.widget.b.a aVar2 = followListViewCallback.pqr;
            if (aVar2 == null) {
                p.btv("popupMenu");
            }
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            int i2 = TouchableLayout.kuv;
            TouchableLayout.a aVar4 = TouchableLayout.Rni;
            aVar2.a(view, new FinderFollowListContract$FollowListViewCallback$showPopupMenu$1(followListViewCallback), new FinderFollowListContract$FollowListViewCallback$showPopupMenu$2(followListViewCallback, gVar), i2, TouchableLayout.kuw);
            AppMethodBeat.o(249748);
        }
    }
}
