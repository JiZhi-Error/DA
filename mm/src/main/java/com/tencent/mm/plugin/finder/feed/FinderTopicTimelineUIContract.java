package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.component.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract;", "", "()V", "Companion", "Loader", "Presenter", "TopicCustomData", "ViewCallback", "plugin-finder_release"})
public final class FinderTopicTimelineUIContract {
    public static final a tTP = new a((byte) 0);

    static {
        AppMethodBeat.i(166004);
        AppMethodBeat.o(166004);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$TopicCustomData;", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "tag", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "tagLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;Lcom/tencent/mm/protobuf/ByteString;)V", "getTag", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
    public static final class c extends com.tencent.mm.plugin.finder.feed.model.a {
        public final dmk tUb;
        final com.tencent.mm.bw.b tUc;

        public c(dmk dmk, com.tencent.mm.bw.b bVar) {
            this.tUb = dmk;
            this.tUc = bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0001<B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u0018\u00100\u001a\u00020#2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020#H\u0016J\u0016\u00106\u001a\u00020#2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\b\u0010:\u001a\u00020#H\u0016J\b\u0010;\u001a\u00020#H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "type", "(Lcom/tencent/mm/ui/MMActivity;II)V", "activityCreatorFinderName", "", "getActivityCreatorFinderName", "()Ljava/lang/String;", "setActivityCreatorFinderName", "(Ljava/lang/String;)V", "activityFeedHandler", "Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "removeEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "()Lcom/tencent/mm/sdk/event/IListener;", "setRemoveEvent", "(Lcom/tencent/mm/sdk/event/IListener;)V", "getScene", "()I", "getType", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "isCreator", "", "isFinderSelfScene", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "requestRefresh", "Companion", "plugin-finder_release"})
    public static final class b extends v.a {
        public static final a tTY = new a((byte) 0);
        private final int scene;
        private final com.tencent.mm.plugin.finder.feed.model.d tLy;
        private final f tLz;
        private final com.tencent.mm.plugin.finder.feed.component.a tTW = new com.tencent.mm.plugin.finder.feed.component.a();
        private String tTX;
        private IListener<com.tencent.mm.g.a.f> tTp;
        private final int type;

        static {
            AppMethodBeat.i(244505);
            AppMethodBeat.o(244505);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract$b$b  reason: collision with other inner class name */
        static final class C1115b extends q implements kotlin.g.a.b<Integer, bo> {
            final /* synthetic */ b tTZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1115b(b bVar) {
                super(1);
                this.tTZ = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ bo invoke(Integer num) {
                bo boVar;
                BaseFinderFeed baseFinderFeed;
                DataBuffer dataListJustForAdapter;
                AppMethodBeat.i(178280);
                int intValue = num.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tTZ.tFM;
                    if (intValue < ((baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter.size())) {
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tTZ.tFM;
                        if (baseFinderFeedLoader2 != null) {
                            boVar = (bo) baseFinderFeedLoader2.get(intValue);
                        } else {
                            boVar = null;
                        }
                        if (boVar instanceof BaseFinderFeed) {
                            baseFinderFeed = (BaseFinderFeed) boVar;
                        } else {
                            baseFinderFeed = null;
                        }
                        BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
                        AppMethodBeat.o(178280);
                        return baseFinderFeed2;
                    }
                }
                AppMethodBeat.o(178280);
                return null;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
        static final class c extends q implements m<Integer, Integer, LinkedList<bo>> {
            final /* synthetic */ b tTZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super(2);
                this.tTZ = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
                BaseFinderFeedLoader baseFinderFeedLoader;
                DataBuffer dataListJustForAdapter;
                List a2;
                DataBuffer dataListJustForAdapter2;
                AppMethodBeat.i(244498);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader2 = this.tTZ.tFM;
                    if (!(intValue2 >= ((baseFinderFeedLoader2 == null || (dataListJustForAdapter2 = baseFinderFeedLoader2.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter2.size()) || (baseFinderFeedLoader = this.tTZ.tFM) == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null || (a2 = j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                        LinkedList linkedList = new LinkedList(a2);
                        AppMethodBeat.o(244498);
                        return linkedList;
                    }
                }
                AppMethodBeat.o(244498);
                return null;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$Companion;", "", "()V", "CANCEL_TOP_PLACE_ACTIVITY", "", "REMOVE_FROM_ACTIVITY", "TOP_PLACE_ACTIVITY", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, int i2, int i3) {
            super(mMActivity);
            p.h(mMActivity, "context");
            AppMethodBeat.i(244504);
            this.scene = i2;
            this.type = i3;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            this.tLz = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(244504);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.feed.i
        public final boolean dbZ() {
            AppMethodBeat.i(260237);
            if (this.type == 7) {
                boolean hSJ = hSJ();
                AppMethodBeat.o(260237);
                return hSJ;
            }
            boolean dbZ = super.dbZ();
            AppMethodBeat.o(260237);
            return dbZ;
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a
        public final void a(BaseFinderFeedLoader baseFinderFeedLoader, v.b bVar) {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(178281);
            p.h(baseFinderFeedLoader, "model");
            p.h(bVar, "callback");
            super.a(baseFinderFeedLoader, bVar);
            this.tLy.a(this.scene, this.tCE, new C1115b(this));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.a(this.tLy);
            }
            g.azz().a(5909, this.tTW);
            this.tTW.tFM = this.tFM;
            this.tLz.e(new c(this));
            if (this.type == 7) {
                this.tTW.tUe = this.gte.getIntent().getIntExtra("key_activity_max_top_count", 3);
                this.tTX = this.gte.getIntent().getStringExtra("key_creator_finder_name");
                this.tTp = new d(this);
                IListener<com.tencent.mm.g.a.f> iListener = this.tTp;
                if (iListener != null) {
                    iListener.alive();
                }
            }
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null) {
                AppMethodBeat.o(178281);
                return;
            }
            a2.a(this.tLz);
            AppMethodBeat.o(178281);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class d extends IListener<com.tencent.mm.g.a.f> {
            final /* synthetic */ b tTZ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(b bVar) {
                this.tTZ = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(com.tencent.mm.g.a.f fVar) {
                AppMethodBeat.i(244500);
                com.tencent.mm.g.a.f fVar2 = fVar;
                if (fVar2 != null) {
                    com.tencent.mm.ac.d.h(new a(this, fVar2));
                }
                AppMethodBeat.o(244500);
                return false;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter$onAttach$3$callback$1$1"})
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ com.tencent.mm.g.a.f tQD;
                final /* synthetic */ d tUa;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(d dVar, com.tencent.mm.g.a.f fVar) {
                    super(0);
                    this.tUa = dVar;
                    this.tQD = fVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(244499);
                    if (this.tQD.dBS.id != 0) {
                        BaseFinderFeedLoader baseFinderFeedLoader = this.tUa.tTZ.tFM;
                        if (baseFinderFeedLoader != null) {
                            baseFinderFeedLoader.remove(this.tQD.dBS.id, true);
                        }
                    } else {
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tUa.tTZ.tFM;
                        if (baseFinderFeedLoader2 != null) {
                            baseFinderFeedLoader2.removeByLocalId(this.tQD.dBS.localId, true);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(244499);
                    return xVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(178282);
            this.tLy.onDetach();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.b(this.tLy);
            }
            g.azz().b(5909, this.tTW);
            this.tLz.onDetach();
            IListener<com.tencent.mm.g.a.f> iListener = this.tTp;
            if (iListener != null) {
                iListener.dead();
            }
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
                a2.b(this.tLz);
            }
            super.onDetach();
            AppMethodBeat.o(178282);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void dcd() {
            AppMethodBeat.i(244501);
            super.dcd();
            a aVar = FinderTopicTimelineUIContract.tTP;
            com.tencent.mm.vending.j.c<s.p, String> IK = a.IK(this.type);
            k kVar = k.vkd;
            b.AbstractC1134b bVar = this.tLN;
            RecyclerView recyclerView = bVar != null ? bVar.tLS.getRecyclerView() : null;
            s.p hdM = IK.hdM();
            p.g(hdM, "tuple2.`$1`()");
            String hdN = IK.hdN();
            p.g(hdN, "tuple2.`$2`()");
            k.b(recyclerView, hdM, hdN, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_REFRESH);
            AppMethodBeat.o(244501);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(260238);
            p.h(cVar, "reason");
            super.a(cVar);
            if (this.tLN instanceof d) {
                b.AbstractC1134b bVar = this.tLN;
                if (bVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.ViewCallback");
                    AppMethodBeat.o(260238);
                    throw tVar;
                }
                d dVar = (d) bVar;
                p.h(cVar, "reason");
                if (dVar.dck() && cVar.Rmj) {
                    RecyclerView recyclerView = dVar.tLS.getRecyclerView();
                    if (dVar.dck()) {
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                            AppMethodBeat.o(260238);
                            throw tVar2;
                        }
                        int ks = ((FinderLinearLayoutManager) layoutManager).ks() + 1;
                        if (ks < dVar.getAdapter().data.size()) {
                            recyclerView.post(new d.a(recyclerView, ks));
                        }
                    }
                }
            }
            AppMethodBeat.o(260238);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(244502);
            p.h(baseFinderFeed, "feed");
            p.h(mVar, "menu");
            if (this.type == 7) {
                if (hSJ()) {
                    if (baseFinderFeed.feedObject.isPostFinish()) {
                        mVar.b(5001, this.gte.getString(R.string.chb), R.raw.icons_outlined_remove_from_list);
                    }
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                    if (baseFinderFeedLoader == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.Loader");
                        AppMethodBeat.o(244502);
                        throw tVar;
                    } else if (((Loader) baseFinderFeedLoader).tTH == 1) {
                        com.tencent.mm.plugin.finder.feed.component.a.a(this.gte, baseFinderFeed, mVar);
                    }
                }
                y yVar = y.vXH;
                if (!y.h(baseFinderFeed)) {
                    mVar.b(this.pMa, this.gte.getString(R.string.f3g), R.raw.icons_outlined_report_problem);
                    AppMethodBeat.o(244502);
                    return;
                }
            } else {
                super.a(baseFinderFeed, mVar);
            }
            AppMethodBeat.o(244502);
        }

        private final boolean hSJ() {
            AppMethodBeat.i(260239);
            if (Util.isNullOrNil(this.tTX) || !p.j(this.tTX, z.aUg())) {
                AppMethodBeat.o(260239);
                return false;
            }
            AppMethodBeat.o(260239);
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, MenuItem menuItem, int i2) {
            azs azs;
            AppMethodBeat.i(244503);
            p.h(baseFinderFeed, "feed");
            p.h(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == 5001) {
                com.tencent.mm.plugin.finder.feed.component.a aVar = this.tTW;
                MMActivity mMActivity = this.gte;
                p.h(mMActivity, "context");
                p.h(baseFinderFeed, "feed");
                if (aVar.tqs == null) {
                    e eVar = new e((Context) mMActivity, 1, true);
                    eVar.j(mMActivity.getResources().getString(R.string.j_3), 17, mMActivity.getResources().getDimensionPixelSize(R.dimen.kc));
                    eVar.a(new a.f(aVar, mMActivity, baseFinderFeed));
                    eVar.a(new a.g(aVar, mMActivity, baseFinderFeed));
                    eVar.b(new a.h(aVar, mMActivity, baseFinderFeed));
                    aVar.tqs = eVar;
                }
                e eVar2 = aVar.tqs;
                if (eVar2 != null) {
                    if (!eVar2.isShowing()) {
                        eVar2.dGm();
                    }
                    AppMethodBeat.o(244503);
                    return;
                }
                AppMethodBeat.o(244503);
            } else if (itemId == 5002) {
                this.tTW.a((Context) this.gte, true, baseFinderFeed);
                AppMethodBeat.o(244503);
            } else if (itemId == 5003) {
                this.tTW.a((Context) this.gte, false, baseFinderFeed);
                AppMethodBeat.o(244503);
            } else if (itemId != this.pMa) {
                super.a(baseFinderFeed, menuItem, i2);
                AppMethodBeat.o(244503);
            } else if (this.type == 7) {
                FinderObjectDesc finderObjectDesc = baseFinderFeed.feedObject.getFeedObject().objectDesc;
                long j2 = (finderObjectDesc == null || (azs = finderObjectDesc.event) == null) ? 0 : azs.twd;
                com.tencent.mm.plugin.finder.feed.logic.a aVar2 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                com.tencent.mm.plugin.finder.feed.logic.a.i(this.gte, j2);
                AppMethodBeat.o(244503);
            } else {
                super.a(baseFinderFeed, menuItem, i2);
                AppMethodBeat.o(244503);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
            AppMethodBeat.i(165999);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestRefresh();
                AppMethodBeat.o(165999);
                return;
            }
            AppMethodBeat.o(165999);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(166000);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestLoadMore();
                AppMethodBeat.o(166000);
                return;
            }
            AppMethodBeat.o(166000);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u001e\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Presenter;II)V", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "type", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onLoadMoreError", "onRefreshError", "onViewCallPreFinishRefresh", "smoothScrollToNextPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
    public static final class d extends v.b {
        private y tTC;
        private int type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MMActivity mMActivity, b bVar, int i2, int i3) {
            super(mMActivity, bVar, i2, i3);
            p.h(mMActivity, "context");
            p.h(bVar, "presenter");
            AppMethodBeat.i(166003);
            AppMethodBeat.o(166003);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            View loadMoreFooter;
            AppMethodBeat.i(166002);
            p.h(arrayList, "data");
            super.aa(arrayList);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            View inflate = aa.jQ(this.gte).inflate(R.layout.b21, (ViewGroup) null);
            p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
            refreshLoadMoreLayout.setLoadMoreFooter(inflate);
            if (dck() && (loadMoreFooter = this.tLS.getLoadMoreFooter()) != null) {
                Context context = loadMoreFooter.getContext();
                p.g(context, "context");
                int color = context.getResources().getColor(R.color.am);
                TextView textView = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView != null) {
                    textView.setTextColor(color);
                }
                View findViewById = loadMoreFooter.findViewById(R.id.aq8);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(color);
                }
                View findViewById2 = loadMoreFooter.findViewById(R.id.ea_);
                if (findViewById2 != null) {
                    findViewById2.setBackgroundColor(color);
                }
                View findViewById3 = loadMoreFooter.findViewById(R.id.h76);
                if (findViewById3 != null) {
                    findViewById3.setBackgroundColor(color);
                }
            }
            this.type = this.gte.getIntent().getIntExtra("key_topic_type", 0);
            if (this.type == 5) {
                this.tTC = new y(this.gte, this.tLS);
                View findViewById4 = this.gte.findViewById(R.id.c3e);
                p.g(findViewById4, "context.findViewById<FrameLayout>(R.id.empty_view)");
                ((FrameLayout) findViewById4).setVisibility(0);
                View findViewById5 = this.gte.findViewById(R.id.gl7);
                p.g(findViewById5, "context.findViewById<ProgressBar>(R.id.progress)");
                ((ProgressBar) findViewById5).setVisibility(0);
            }
            AppMethodBeat.o(166002);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.b
        public final void d(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244506);
            p.h(cVar, "reason");
            super.d(cVar);
            if (this.type == 5 && (cVar.tXF instanceof bds) && cVar.Rmh != -1) {
                if (cVar.tXF == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderTopicInfo");
                    AppMethodBeat.o(244506);
                    throw tVar;
                }
                View findViewById = this.gte.findViewById(R.id.c3e);
                p.g(findViewById, "context.findViewById<FrameLayout>(R.id.empty_view)");
                ((FrameLayout) findViewById).setVisibility(8);
                View findViewById2 = this.gte.findViewById(R.id.gl7);
                p.g(findViewById2, "context.findViewById<ProgressBar>(R.id.progress)");
                ((ProgressBar) findViewById2).setVisibility(8);
            }
            AppMethodBeat.o(244506);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ RecyclerView tDJ;
            final /* synthetic */ int tQg;

            a(RecyclerView recyclerView, int i2) {
                this.tDJ = recyclerView;
                this.tQg = i2;
            }

            public final void run() {
                AppMethodBeat.i(260240);
                RecyclerView recyclerView = this.tDJ;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.tQg, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$ViewCallback$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(260240);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002KLBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020E0GH\u0016J\u0016\u0010H\u001a\u00020 2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020E0JH\u0016R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u00100¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "type", "", "topic", "", "topicId", "", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "encryptedTopicId", "getEncryptedTopicId", "setEncryptedTopicId", "eventTopicId", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "groupId", "getGroupId", "setGroupId", "hotTopicBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getHotTopicBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setHotTopicBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", com.tencent.mm.plugin.appbrand.jsapi.i.m.NAME, "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "refObjectId", "getRefObjectId", "setRefObjectId", "relatedTopic", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getRelatedTopic", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setRelatedTopic", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "getTopicId", "getType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderTopicTimelineResponse", "TopicTimelineDataFetcher", "plugin-finder_release"})
    public static final class Loader extends BaseFinderFeedLoader {
        private String TAG = "Finder.FinderTopicTimelineLoader";
        final String dST;
        public String groupId;
        final axt location;
        public long refObjectId;
        public int tTH;
        String tTQ = "";
        public com.tencent.mm.bw.b tTR;
        public kotlin.g.a.a<x> tTS;
        public dmk tTT;
        final bcc tvs;
        public long twd;
        final long twp;
        public final int type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loader(int i2, String str, long j2, axt axt, com.tencent.mm.plugin.finder.feed.model.internal.e eVar, bcc bcc, bbn bbn) {
            super(bbn);
            p.h(str, "topic");
            p.h(axt, FirebaseAnalytics.b.LOCATION);
            p.h(eVar, "scene");
            AppMethodBeat.i(244497);
            this.type = i2;
            this.dST = str;
            this.twp = j2;
            this.location = axt;
            this.tvs = bcc;
            AppMethodBeat.o(244497);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
        public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch() {
            AppMethodBeat.i(244495);
            b bVar = new b();
            AppMethodBeat.o(244495);
            return bVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
        public static final class c extends BaseFeedLoader<bo>.a {
            final /* synthetic */ Loader tTU;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Loader loader) {
                super();
                this.tTU = loader;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
            public final void mergeRefresh(IResponse<bo> iResponse, kotlin.g.a.b<? super IResponse<bo>, x> bVar) {
                AppMethodBeat.i(244494);
                p.h(iResponse, "response");
                RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
                RefreshLoadMoreLayout.c cVar = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm);
                if ((iResponse instanceof a) && this.tTU.type == 5) {
                    cVar.tXF = (E) ((a) iResponse).dMU;
                }
                com.tencent.mm.ac.d.h(new a(this, new n(iResponse.getHasMore() ? 2 : 6, iResponse.getIncrementList(), false, 12), cVar, bVar, iResponse));
                AppMethodBeat.o(244494);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ kotlin.g.a.b $next;
                final /* synthetic */ n $op;
                final /* synthetic */ RefreshLoadMoreLayout.c $reason;
                final /* synthetic */ IResponse $response;
                final /* synthetic */ c tTV;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(c cVar, n nVar, RefreshLoadMoreLayout.c cVar2, kotlin.g.a.b bVar, IResponse iResponse) {
                    super(0);
                    this.tTV = cVar;
                    this.$op = nVar;
                    this.$reason = cVar2;
                    this.$next = bVar;
                    this.$response = iResponse;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(244493);
                    this.tTV.convertOpToReason(this.$op, this.$reason);
                    this.tTV.tTU.dispatcher().onPreFinishRefresh(this.$reason);
                    kotlin.g.a.b bVar = this.$next;
                    if (bVar != null) {
                        bVar.invoke(this.$response);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(244493);
                    return xVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
        public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger() {
            AppMethodBeat.i(244496);
            c cVar = new c(this);
            AppMethodBeat.o(244496);
            return cVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.DataStore
        public final String getTAG() {
            return this.TAG;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.DataStore
        public final void setTAG(String str) {
            AppMethodBeat.i(165993);
            p.h(str, "<set-?>");
            this.TAG = str;
            AppMethodBeat.o(165993);
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
        public final void onFetchDone(IResponse<bo> iResponse) {
            kotlin.g.a.a<x> aVar;
            AppMethodBeat.i(165995);
            p.h(iResponse, "response");
            super.onFetchDone(iResponse);
            if (isInitOperation(iResponse)) {
                AppMethodBeat.o(165995);
            } else if (iResponse.getHasMore() || (aVar = this.tTS) == null) {
                AppMethodBeat.o(165995);
            } else {
                aVar.invoke();
                AppMethodBeat.o(165995);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "errType", "", "errCode", "errMsg", "", "(JLcom/tencent/mm/protocal/protobuf/FinderTopicInfo;IILjava/lang/String;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTotalCount", "()J", "plugin-finder_release"})
        public static final class a extends IResponse<bo> {
            final bds dMU;
            private final long tTn;

            public a(long j2, bds bds, int i2, int i3, String str) {
                super(i2, i3, str);
                this.tTn = j2;
                this.dMU = bds;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J2\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$TopicTimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Loader$FinderTopicTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
        public final class b extends com.tencent.mm.plugin.finder.feed.model.internal.a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b() {
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final List<Integer> getCmdIds() {
                AppMethodBeat.i(244488);
                List<Integer> listOf = j.listOf((Object) 817);
                AppMethodBeat.o(244488);
                return listOf;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final com.tencent.mm.ak.q genRefreshNetScene() {
                AppMethodBeat.i(244489);
                if (Loader.this.type == 5) {
                    bs bsVar = new bs(Loader.this.dST, Loader.this.twp, Loader.this.tTR, Long.valueOf(Loader.this.refObjectId), Loader.this.type, Loader.this.getContextObj());
                    AppMethodBeat.o(244489);
                    return bsVar;
                }
                AppMethodBeat.o(244489);
                return null;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final com.tencent.mm.ak.q genLoadMoreNetScene() {
                bs bsVar;
                AppMethodBeat.i(244490);
                switch (Loader.this.type) {
                    case 1:
                        bsVar = new bs(Loader.this.dST, Long.valueOf(Loader.this.refObjectId), Loader.this.getLastBuffer(), Loader.this.tvs, Loader.this.getContextObj(), (byte) 0);
                        bsVar.pullType = 2;
                        break;
                    case 2:
                        String str = Loader.this.location.LIb;
                        if (str == null) {
                            str = "";
                        }
                        bsVar = new bs(str, Loader.this.location.dTj, Loader.this.location.latitude, Long.valueOf(Loader.this.refObjectId), Loader.this.getLastBuffer(), Loader.this.tTT, Loader.this.tvs, Loader.this.getContextObj());
                        bsVar.pullType = 2;
                        break;
                    case 3:
                    case 6:
                    default:
                        bsVar = null;
                        break;
                    case 4:
                        String str2 = Loader.this.groupId;
                        if (str2 == null) {
                            str2 = com.tencent.mm.ac.d.zs(Loader.this.refObjectId);
                        }
                        bsVar = new bs(str2, Long.valueOf(Loader.this.refObjectId), Loader.this.getLastBuffer(), Loader.this.tvs, Loader.this.getContextObj());
                        bsVar.pullType = 2;
                        break;
                    case 5:
                        bsVar = new bs(Loader.this.dST, Loader.this.twp, Loader.this.tTR, Long.valueOf(Loader.this.refObjectId), Loader.this.getLastBuffer(), Loader.this.tvs, Loader.this.getContextObj());
                        bsVar.pullType = 2;
                        break;
                    case 7:
                        bs bsVar2 = new bs(Loader.this.twd, Long.valueOf(Loader.this.refObjectId), Loader.this.tTQ, Loader.this.tTH, Loader.this.getLastBuffer(), Loader.this.getContextObj());
                        bsVar2.pullType = 2;
                        bsVar = bsVar2;
                        break;
                }
                bs bsVar3 = bsVar;
                AppMethodBeat.o(244490);
                return bsVar3;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final IResponse<bo> dealOnSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                boolean z;
                Integer num;
                AppMethodBeat.i(244491);
                p.h(qVar, "scene");
                bs bsVar = (bs) qVar;
                if (i2 == 0 && i3 == 0 && bsVar.cYA() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                a aVar = new a(bsVar.cYI(), bsVar.cYJ(), i2, i3, str);
                LinkedList<FinderObject> cYH = ((bs) qVar).cYH();
                ArrayList arrayList = new ArrayList(j.a(cYH, 10));
                Iterator<T> it = cYH.iterator();
                while (it.hasNext()) {
                    FinderItem.a aVar2 = FinderItem.Companion;
                    FinderItem a2 = FinderItem.a.a((FinderObject) it.next(), 64);
                    FinderTopicFeedUI.a aVar3 = FinderTopicFeedUI.udw;
                    FinderTopicFeedUI.ddO().put(Long.valueOf(a2.getId()), a2);
                    c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList.add(c.a.s(a2));
                }
                aVar.setIncrementList(arrayList);
                String tag = getTAG();
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = aVar.getIncrementList();
                if (incrementList != null) {
                    num = Integer.valueOf(incrementList.size());
                } else {
                    num = null;
                }
                Log.i(tag, sb.append(num).toString());
                aVar.setPullType(bsVar.pullType);
                aVar.setLastBuffer(bsVar.cYz());
                aVar.setHasMore(z);
                a aVar5 = aVar;
                AppMethodBeat.o(244491);
                return aVar5;
            }

            @Override // com.tencent.mm.plugin.finder.feed.model.internal.a
            public final /* synthetic */ IResponse callInit() {
                a aVar;
                Integer num;
                AppMethodBeat.i(244492);
                h cache = Loader.this.getCache();
                if (cache != null) {
                    ArrayList<bo> arrayList = cache.kgc;
                    Log.i(getTAG(), "fetchInit size:" + (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue());
                    if (arrayList != null) {
                        num = Integer.valueOf(arrayList.size());
                    } else {
                        num = null;
                    }
                    a aVar2 = new a((long) num.intValue(), null, 0, 0, "");
                    aVar2.setIncrementList(arrayList);
                    if (cache.tXU instanceof c) {
                        aVar2.setLastBuffer(((c) cache.tXU).tUc);
                    }
                    aVar = aVar2;
                } else {
                    aVar = new a(0, null, 0, 0, "");
                }
                a aVar3 = aVar;
                AppMethodBeat.o(244492);
                return aVar3;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicTimelineUIContract$Companion;", "", "()V", "getActionScene", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "", "type", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static com.tencent.mm.vending.j.c<s.p, String> IK(int i2) {
            AppMethodBeat.i(244487);
            s.p pVar = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
            String str = "27";
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEu = true;
            if (2 == i2) {
                pVar = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD;
                str = "27";
                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEu = true;
            } else if (1 == i2) {
                pVar = s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR;
                str = "9";
                c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEu = false;
            }
            com.tencent.mm.vending.j.c<s.p, String> Q = com.tencent.mm.vending.j.a.Q(pVar, str);
            p.g(Q, "Tuple.make(action, scene)");
            AppMethodBeat.o(244487);
            return Q;
        }
    }
}
