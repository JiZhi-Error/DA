package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract;", "", "()V", "TAG", "", "startNetSceneTime", "", "BlockListPresenter", "BlockListViewCallback", "plugin-finder_release"})
public final class FinderBlockListContract {
    private static final String TAG = TAG;
    private static long uWm = SystemClock.uptimeMillis();
    public static final FinderBlockListContract uWn = new FinderBlockListContract();

    static {
        AppMethodBeat.i(249712);
        AppMethodBeat.o(249712);
    }

    private FinderBlockListContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0015\u001a\u00020\u0011J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J,\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "viewCallback", "addContactList", "", "contacts", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "doScene", "getData", "initByCache", "initData", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class BlockListPresenter implements i, a<BlockListViewCallback> {
        public final ArrayList<p> kgc = new ArrayList<>();
        private b tVM;
        public BlockListViewCallback uWo;
        public ak uWp;

        public BlockListPresenter(ak akVar) {
            kotlin.g.b.p.h(akVar, "config");
            AppMethodBeat.i(249688);
            this.uWp = akVar;
            AppMethodBeat.o(249688);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(BlockListViewCallback blockListViewCallback) {
            AppMethodBeat.i(249683);
            a(blockListViewCallback);
            AppMethodBeat.o(249683);
        }

        public final void a(BlockListViewCallback blockListViewCallback) {
            AppMethodBeat.i(249682);
            kotlin.g.b.p.h(blockListViewCallback, "callback");
            this.uWo = blockListViewCallback;
            q c2 = this.uWp.c(null);
            if (c2 != null) {
                g.azz().a(c2.getType(), this);
                AppMethodBeat.o(249682);
                return;
            }
            AppMethodBeat.o(249682);
        }

        public final void dlQ() {
            AppMethodBeat.i(249684);
            if (this.uWp.c(null) != null) {
                g.azz().b(this.uWp.c(this.tVM));
            }
            AppMethodBeat.o(249684);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            AppMethodBeat.i(249685);
            this.uWo = null;
            q c2 = this.uWp.c(null);
            if (c2 != null) {
                g.azz().b(c2.getType(), this);
            }
            com.tencent.mm.plugin.finder.storage.data.g dqo = this.uWp.dqo();
            if (dqo != null) {
                dqo.blr();
            }
            ArrayList<p> arrayList = this.kgc;
            ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().contact);
            }
            LinkedList linkedList = new LinkedList(arrayList2);
            com.tencent.mm.plugin.finder.storage.data.g dqo2 = this.uWp.dqo();
            if (dqo2 != null) {
                dqo2.r(linkedList);
                AppMethodBeat.o(249685);
                return;
            }
            AppMethodBeat.o(249685);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(249686);
            FinderBlockListContract finderBlockListContract = FinderBlockListContract.uWn;
            Log.i(FinderBlockListContract.TAG, "errType " + i2 + ", errCode " + i3 + " errMsg " + str + " requestScene " + this.uWp.c(null));
            if (i2 == 0 && i3 == 0) {
                ArrayList arrayList = new ArrayList();
                LinkedList<FinderContact> j2 = this.uWp.j(qVar);
                if (j2 != null) {
                    Iterator<T> it = j2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new p(it.next()));
                    }
                }
                BlockListViewCallback blockListViewCallback = this.uWo;
                if (blockListViewCallback != null) {
                    blockListViewCallback.e(arrayList, this.tVM == null);
                }
                this.tVM = this.uWp.i(qVar);
            }
            AppMethodBeat.o(249686);
        }

        public final void eo(List<? extends FinderContact> list) {
            AppMethodBeat.i(249687);
            kotlin.g.b.p.h(list, "contacts");
            List<? extends FinderContact> list2 = list;
            ArrayList arrayList = new ArrayList(j.a(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new p(it.next()));
            }
            ArrayList arrayList2 = arrayList;
            BlockListViewCallback blockListViewCallback = this.uWo;
            if (blockListViewCallback != null) {
                kotlin.g.b.p.h(arrayList2, "newList");
                blockListViewCallback.uWr.kgc.addAll(0, arrayList2);
                RecyclerView recyclerView = blockListViewCallback.hak;
                if (recyclerView == null) {
                    kotlin.g.b.p.btv("recyclerView");
                }
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    WxRecyclerAdapter<p> wxRecyclerAdapter = blockListViewCallback.tFp;
                    adapter.as(wxRecyclerAdapter != null ? wxRecyclerAdapter.RqM.size() : 0, arrayList2.size());
                }
                blockListViewCallback.bIo();
            }
            ak akVar = this.uWp;
            List<? extends FinderContact> list3 = list;
            ArrayList arrayList3 = new ArrayList(j.a(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                String str = it2.next().username;
                if (str == null) {
                    str = "";
                }
                arrayList3.add(str);
            }
            akVar.es(arrayList3);
            AppMethodBeat.o(249687);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\tJ\u001c\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0005H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\"H\u0002J\u0006\u0010)\u001a\u00020\u001eJ0\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\"H\u0016J0\u00100\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\"H\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u000bH\u0016J\u0014\u00102\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100 J\u0006\u00103\u001a\u00020\u001eR\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;)V", "DEL_MENU_ID", "", "getDEL_MENU_ID", "()I", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchBarData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "finishLoadMore", "", "newList", "", "isRefresh", "", "getActivity", "getPresenter", "hideSearchBar", "delay", "", "isSmooth", "initView", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "onUserAddList", "showEmptyView", "plugin-finder_release"})
    public static final class BlockListViewCallback implements c<BlockListPresenter>, HeadFooterLayout.b {
        public final View contentView;
        public final MMActivity gte;
        public RecyclerView hak;
        public WxRecyclerAdapter<p> tFp;
        public RefreshLoadMoreLayout tLS;
        public final BlockListPresenter uWr;
        public com.tencent.mm.plugin.finder.model.i uWs;
        final int uWt;

        public BlockListViewCallback(MMActivity mMActivity, View view, BlockListPresenter blockListPresenter) {
            kotlin.g.b.p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            kotlin.g.b.p.h(view, "rootView");
            kotlin.g.b.p.h(blockListPresenter, "presenter");
            AppMethodBeat.i(249708);
            this.uWr = blockListPresenter;
            this.gte = mMActivity;
            this.contentView = view;
            AppMethodBeat.o(249708);
        }

        public static final /* synthetic */ RecyclerView e(BlockListViewCallback blockListViewCallback) {
            AppMethodBeat.i(249710);
            RecyclerView recyclerView = blockListViewCallback.hak;
            if (recyclerView == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            AppMethodBeat.o(249710);
            return recyclerView;
        }

        public static final /* synthetic */ RefreshLoadMoreLayout f(BlockListViewCallback blockListViewCallback) {
            AppMethodBeat.i(249711);
            RefreshLoadMoreLayout refreshLoadMoreLayout = blockListViewCallback.tLS;
            if (refreshLoadMoreLayout == null) {
                kotlin.g.b.p.btv("rlLayout");
            }
            AppMethodBeat.o(249711);
            return refreshLoadMoreLayout;
        }

        public final void bIo() {
            AppMethodBeat.i(249703);
            if (this.uWr.kgc.size() == 0) {
                View findViewById = this.contentView.findViewById(R.id.h7t);
                kotlin.g.b.p.g(findViewById, "contentView.findViewById<View>(R.id.rl_layout)");
                findViewById.setVisibility(8);
                View findViewById2 = this.contentView.findViewById(R.id.gyq);
                kotlin.g.b.p.g(findViewById2, "contentView.findViewById<View>(R.id.refresh_tip)");
                findViewById2.setVisibility(0);
                View findViewById3 = this.contentView.findViewById(R.id.gyq);
                kotlin.g.b.p.g(findViewById3, "contentView.findViewById…xtView>(R.id.refresh_tip)");
                ((TextView) findViewById3).setText(this.uWr.uWp.hUM());
                y yVar = y.vXH;
                View findViewById4 = this.contentView.findViewById(R.id.gyq);
                kotlin.g.b.p.g(findViewById4, "contentView.findViewById…xtView>(R.id.refresh_tip)");
                y.a((TextView) findViewById4, new SpannableString(this.uWr.uWp.hUM()));
                AppMethodBeat.o(249703);
                return;
            }
            View findViewById5 = this.contentView.findViewById(R.id.h7t);
            kotlin.g.b.p.g(findViewById5, "contentView.findViewById<View>(R.id.rl_layout)");
            findViewById5.setVisibility(0);
            View findViewById6 = this.contentView.findViewById(R.id.gyq);
            kotlin.g.b.p.g(findViewById6, "contentView.findViewById<View>(R.id.refresh_tip)");
            findViewById6.setVisibility(8);
            AppMethodBeat.o(249703);
        }

        public final void e(List<p> list, boolean z) {
            long longValue;
            AppMethodBeat.i(249704);
            kotlin.g.b.p.h(list, "newList");
            z.d dVar = new z.d();
            dVar.SYE = this.uWr.kgc.size();
            long uptimeMillis = SystemClock.uptimeMillis();
            FinderBlockListContract finderBlockListContract = FinderBlockListContract.uWn;
            long j2 = uptimeMillis - FinderBlockListContract.uWm;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (j2 >= com.tencent.mm.plugin.finder.storage.c.dty().value().longValue()) {
                longValue = 0;
            } else {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                longValue = com.tencent.mm.plugin.finder.storage.c.dty().value().longValue() - j2;
            }
            d.a(longValue, new FinderBlockListContract$BlockListViewCallback$finishLoadMore$1(this, z, list, dVar));
            AppMethodBeat.o(249704);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final void ddr() {
            AppMethodBeat.i(249705);
            FinderBlockListContract finderBlockListContract = FinderBlockListContract.uWn;
            Log.i(FinderBlockListContract.TAG, "[onOverStop]");
            AppMethodBeat.o(249705);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean u(int i2, int i3, boolean z) {
            AppMethodBeat.i(249706);
            FinderBlockListContract finderBlockListContract = FinderBlockListContract.uWn;
            Log.i(FinderBlockListContract.TAG, "[onOverStart] dy=".concat(String.valueOf(i2)));
            AppMethodBeat.o(249706);
            return false;
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean IJ(int i2) {
            AppMethodBeat.i(249707);
            FinderBlockListContract finderBlockListContract = FinderBlockListContract.uWn;
            Log.i(FinderBlockListContract.TAG, "[onOverEnd] dy=".concat(String.valueOf(i2)));
            AppMethodBeat.o(249707);
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        public static final /* synthetic */ void b(BlockListViewCallback blockListViewCallback) {
            AppMethodBeat.i(249709);
            WxRecyclerAdapter<p> wxRecyclerAdapter = blockListViewCallback.tFp;
            if (wxRecyclerAdapter != null) {
                com.tencent.mm.plugin.finder.model.i iVar = blockListViewCallback.uWs;
                if (iVar == null) {
                    kotlin.g.b.p.hyc();
                }
                if (!wxRecyclerAdapter.a(iVar)) {
                    AppMethodBeat.o(249709);
                    return;
                }
            }
            RecyclerView recyclerView = blockListViewCallback.hak;
            if (recyclerView == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.ah(1, 0);
            }
            RecyclerView recyclerView2 = blockListViewCallback.hak;
            if (recyclerView2 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            recyclerView2.postDelayed(new FinderBlockListContract$BlockListViewCallback$hideSearchBar$1(blockListViewCallback, linearLayoutManager), 200);
            AppMethodBeat.o(249709);
        }
    }
}
