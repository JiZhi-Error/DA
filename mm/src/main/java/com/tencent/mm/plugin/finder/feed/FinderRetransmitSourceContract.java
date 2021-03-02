package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bz;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract;", "", "()V", "Loader", "Presenter", "RetransmitSourceResponse", "ViewCallback", "plugin-finder_release"})
public final class FinderRetransmitSourceContract {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "loadMoreData", "", "requestRefresh", "plugin-finder_release"})
    public static final class a extends v.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity) {
            super(mMActivity);
            p.h(mMActivity, "context");
            AppMethodBeat.i(165848);
            AppMethodBeat.o(165848);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
            AppMethodBeat.i(165846);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestRefresh();
                AppMethodBeat.o(165846);
                return;
            }
            AppMethodBeat.o(165846);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(165847);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestLoadMore();
                AppMethodBeat.o(165847);
                return;
            }
            AppMethodBeat.o(165847);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
    public static final class c extends v.b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MMActivity mMActivity, a aVar) {
            super(mMActivity, aVar, 2, 4);
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
            AppMethodBeat.i(165858);
            AppMethodBeat.o(165858);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            AppMethodBeat.i(165857);
            p.h(arrayList, "data");
            super.aa(arrayList);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            View inflate = aa.jQ(this.gte).inflate(R.layout.b21, (ViewGroup) null);
            p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
            refreshLoadMoreLayout.setLoadMoreFooter(inflate);
            AppMethodBeat.o(165857);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "RetransmitSourceData", "plugin-finder_release"})
    public static final class Loader extends BaseFinderFeedLoader {
        final long refObjectId;
        final String refObjectNonceId;
        final String tvp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loader(String str, long j2, String str2, e eVar, bbn bbn) {
            super(bbn);
            p.h(str, "targetUsername");
            p.h(str2, "refObjectNonceId");
            p.h(eVar, "scene");
            AppMethodBeat.i(244116);
            this.tvp = str;
            this.refObjectId = j2;
            this.refObjectNonceId = str2;
            AppMethodBeat.o(244116);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
        public final g<bo> createDataFetch() {
            AppMethodBeat.i(244115);
            a aVar = new a();
            AppMethodBeat.o(244115);
            return aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader$RetransmitSourceData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
        public final class a extends com.tencent.mm.plugin.finder.feed.model.internal.a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final List<Integer> getCmdIds() {
                AppMethodBeat.i(244111);
                List<Integer> listOf = j.listOf((Object) 3581);
                AppMethodBeat.o(244111);
                return listOf;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final q genRefreshNetScene() {
                AppMethodBeat.i(244112);
                bz bzVar = new bz(Loader.this.tvp, Loader.this.refObjectId, Loader.this.refObjectNonceId, Loader.this.getLastBuffer(), 0);
                AppMethodBeat.o(244112);
                return bzVar;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final q genLoadMoreNetScene() {
                AppMethodBeat.i(244113);
                bz bzVar = new bz(Loader.this.tvp, Loader.this.refObjectId, Loader.this.refObjectNonceId, Loader.this.getLastBuffer(), 2);
                AppMethodBeat.o(244113);
                return bzVar;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, q qVar) {
                boolean z;
                AppMethodBeat.i(244114);
                p.h(qVar, "scene");
                bz bzVar = (bz) qVar;
                if (i2 == 0 && i3 == 0 && bzVar.cYZ().continueFlag == 0) {
                    z = false;
                } else {
                    z = true;
                }
                LinkedList linkedList = bzVar.tvo;
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                List<? extends FinderItem> list = linkedList;
                ArrayList arrayList = new ArrayList(j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList.add(c.a.s(it.next()));
                }
                ArrayList arrayList2 = arrayList;
                if (!Util.isNullOrNil(arrayList2)) {
                    Context context = MMApplicationContext.getContext();
                    if (((BaseFinderFeed) j.ks(arrayList2)).feedObject.getId() != bzVar.refObjectId) {
                        String string = context.getString(R.string.clc);
                        p.g(string, "context.getString(R.string.finder_deleted_tip2)");
                        p.h(string, "<set-?>");
                        ((BaseFinderFeed) j.ks(arrayList2)).headerWording = string;
                    } else if (arrayList2.size() > 1) {
                        String string2 = context.getString(R.string.cld);
                        p.g(string2, "context.getString(R.string.finder_deleted_tip3)");
                        p.h(string2, "<set-?>");
                        ((BaseFinderFeed) j.ks(arrayList2)).footerWording = string2;
                    }
                }
                b bVar = new b(i2, i3, str);
                bVar.setIncrementList(arrayList2);
                bVar.setPullType(bzVar.pullType);
                bVar.setLastBuffer(bzVar.cYZ().lastBuffer);
                bVar.setHasMore(z);
                b bVar2 = bVar;
                AppMethodBeat.o(244114);
                return bVar2;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$RetransmitSourceResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
    public static final class b extends IResponse<bo> {
        public b(int i2, int i3, String str) {
            super(i2, i3, str);
        }
    }
}
