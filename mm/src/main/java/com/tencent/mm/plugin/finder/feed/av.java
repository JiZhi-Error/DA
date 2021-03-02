package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract;", "", "()V", "FinderTopicInfoWrapper", "TopicFeedPresenter", "TopicFeedViewCallback", "plugin-finder_release"})
public final class av {
    public static final av tTl = new av();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\"\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020]H\u0016J\u0018\u0010_\u001a\u0002042\u0006\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cJ\u001e\u0010d\u001a\b\u0012\u0004\u0012\u00020f0e2\u000e\u0010g\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010hH\u0002J\n\u0010i\u001a\u0004\u0018\u00010IH\u0016J\b\u0010?\u001a\u0004\u0018\u00010jJ\u000e\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020>J\b\u0010n\u001a\u000204H\u0016J\b\u0010o\u001a\u000204H\u0016J\u0010\u0010p\u001a\u0002042\u0006\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u000204H\u0016J\b\u0010t\u001a\u000204H\u0016J\u0018\u0010u\u001a\u0002042\u0010\b\u0002\u0010v\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103J&\u0010w\u001a\u0002042\f\u0010x\u001a\b\u0012\u0004\u0012\u00020z0y2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u0005H\u0002J\u0014\u0010~\u001a\u0002042\f\u0010x\u001a\b\u0012\u0004\u0012\u00020z0yR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u001a\u0010$\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001c\u0010'\u001a\u00020\u00108FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010 R\u001a\u0010=\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u0011\u0010X\u001a\u00020Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[¨\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "TAB_TYPE", "getTAB_TYPE", "()I", "setTAB_TYPE", "(I)V", "TAG", "", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "disableFlag", "getDisableFlag", "setDisableFlag", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1;", "flag", "getFlag", "setFlag", "iconUrl", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "onRequestFinished", "Lkotlin/Function0;", "", "getOnRequestFinished", "()Lkotlin/jvm/functions/Function0;", "setOnRequestFinished", "(Lkotlin/jvm/functions/Function0;)V", "removeEvent", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "getRemoveEvent", "setRemoveEvent", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getSelectedTag", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "topic", "getTopic", "setTopic", "topicRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getTopicRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setTopicRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "totalCount", "", "getTotalCount", "()J", "setTotalCount", "(J)V", "totalDy", "type", "getType", "setType", "wrapper", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "getWrapper", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "buildCampaignConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "buildItemCoverts", "dealFirstRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "distinctResponseList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "incrementList", "", "getIViewActionCallback", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "ifDummyTag", "", "tag", "initViewCallback", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "scrollToTop", "endCallBack", "setNoMoreForActivity", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicResponse;", "size", "showNoMoreView", "plugin-finder_release"})
    public static final class a extends c.a {
        final String TAG = "Finder.FinderTopicFeedUIContract.TopicFeedPresenter";
        final c UIe;
        public bdr bgmInfo;
        int cSx;
        public String dST = "";
        private String iconUrl;
        azk musicInfo;
        private IListener<ig> tOh;
        bds tRJ;
        public int tTm;
        public long tTn;
        int tTo;
        private IListener<com.tencent.mm.g.a.f> tTp;
        final FinderTopicFeedCache tTq;
        private final b tTr;
        private j tTs;
        int totalDy;
        public int type;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", LocaleUtil.ITALIAN, "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.av$a$a  reason: collision with other inner class name */
        static final class C1129a extends q implements kotlin.g.a.b<Integer, com.tencent.mm.view.recyclerview.e<?>> {
            final /* synthetic */ a tTt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1129a(a aVar) {
                super(1);
                this.tTt = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ com.tencent.mm.view.recyclerview.e<?> invoke(Integer num) {
                AppMethodBeat.i(244446);
                int intValue = num.intValue();
                switch (intValue) {
                    case -6:
                        ah ahVar = new ah(new com.tencent.mm.plugin.finder.presenter.base.b(this) {
                            /* class com.tencent.mm.plugin.finder.feed.av.a.C1129a.AnonymousClass1 */
                            final /* synthetic */ C1129a tTw;

                            /* JADX WARN: Incorrect args count in method signature: ()V */
                            {
                                this.tTw = r1;
                            }

                            @Override // com.tencent.mm.plugin.finder.presenter.base.b
                            public final View getRootView() {
                                AppMethodBeat.i(244445);
                                View findViewById = this.tTw.tTt.gte.findViewById(R.id.itu);
                                p.g(findViewById, "context.findViewById(R.id.topic_root_layout)");
                                AppMethodBeat.o(244445);
                                return findViewById;
                            }
                        });
                        AppMethodBeat.o(244446);
                        return ahVar;
                    default:
                        y yVar = y.vXH;
                        y.dQ(this.tTt.TAG, intValue);
                        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                        AppMethodBeat.o(244446);
                        return fVar;
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(final MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(244468);
            bds bds = new bds();
            FinderTagView.a aVar = FinderTagView.wpv;
            bds.twp = FinderTagView.dHl();
            this.tRJ = bds;
            this.iconUrl = "";
            this.UIe = new c((byte) 0);
            this.tTq = new FinderTopicFeedCache();
            this.tTr = new b(this);
            this.tTs = new j(this) {
                /* class com.tencent.mm.plugin.finder.feed.av.a.AnonymousClass1 */
                final /* synthetic */ a tTt;

                {
                    this.tTt = r1;
                }

                @Override // com.tencent.mm.view.i
                public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                    AppMethodBeat.i(244437);
                    p.h(cVar, "reason");
                    com.tencent.mm.ac.d.h(new c(this, cVar));
                    AppMethodBeat.o(244437);
                }

                @Override // com.tencent.mm.view.i
                public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    AppMethodBeat.i(244438);
                    p.h(cVar, "reason");
                    c.b bVar = this.tTt.tMd;
                    if (!(bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null)) {
                        refreshLoadMoreLayout.onPreFinishLoadMore(cVar);
                    }
                    com.tencent.mm.ac.d.h(new C1128a(this, cVar));
                    AppMethodBeat.o(244438);
                }

                @Override // com.tencent.mm.view.i
                public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    AppMethodBeat.i(244439);
                    p.h(cVar, "reason");
                    c.b bVar = this.tTt.tMd;
                    if (!(bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null)) {
                        refreshLoadMoreLayout.onPreFinishLoadMoreSmooth(cVar);
                    }
                    com.tencent.mm.ac.d.h(new b(this, cVar));
                    AppMethodBeat.o(244439);
                }

                @Override // com.tencent.mm.view.j
                public final void onChanged() {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    AppMethodBeat.i(244440);
                    c.b bVar = this.tTt.tMd;
                    if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                        AppMethodBeat.o(244440);
                        return;
                    }
                    refreshLoadMoreLayout.onChanged();
                    AppMethodBeat.o(244440);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeChanged(int i2, int i3) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    int i4;
                    WxRecyclerAdapter<?> adapter;
                    AppMethodBeat.i(244441);
                    c.b bVar = this.tTt.tMd;
                    if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                        AppMethodBeat.o(244441);
                        return;
                    }
                    c.b bVar2 = this.tTt.tMd;
                    if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                        i4 = 0;
                    } else {
                        i4 = adapter.RqM.size();
                    }
                    refreshLoadMoreLayout.onItemRangeChanged(i4 + i2, i3);
                    AppMethodBeat.o(244441);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeChanged(int i2, int i3, Object obj) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    int i4;
                    WxRecyclerAdapter<?> adapter;
                    AppMethodBeat.i(244442);
                    c.b bVar = this.tTt.tMd;
                    if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                        AppMethodBeat.o(244442);
                        return;
                    }
                    c.b bVar2 = this.tTt.tMd;
                    if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                        i4 = 0;
                    } else {
                        i4 = adapter.RqM.size();
                    }
                    refreshLoadMoreLayout.onItemRangeChanged(i4 + i2, i3, obj);
                    AppMethodBeat.o(244442);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeInserted(int i2, int i3) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    int i4;
                    WxRecyclerAdapter<?> adapter;
                    AppMethodBeat.i(244443);
                    c.b bVar = this.tTt.tMd;
                    if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                        AppMethodBeat.o(244443);
                        return;
                    }
                    c.b bVar2 = this.tTt.tMd;
                    if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                        i4 = 0;
                    } else {
                        i4 = adapter.RqM.size();
                    }
                    refreshLoadMoreLayout.onItemRangeInserted(i4 + i2, i3);
                    AppMethodBeat.o(244443);
                }

                @Override // com.tencent.mm.view.j
                public final void onItemRangeRemoved(int i2, int i3) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout;
                    int i4;
                    WxRecyclerAdapter<?> adapter;
                    AppMethodBeat.i(244444);
                    c.b bVar = this.tTt.tMd;
                    if (!(bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null)) {
                        c.b bVar2 = this.tTt.tMd;
                        if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                            i4 = 0;
                        } else {
                            i4 = adapter.RqM.size();
                        }
                        refreshLoadMoreLayout.onItemRangeRemoved(i4 + i2, i3);
                    }
                    c.b bVar3 = this.tTt.tMd;
                    if (bVar3 != null) {
                        bVar3.dcv();
                        AppMethodBeat.o(244444);
                        return;
                    }
                    AppMethodBeat.o(244444);
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                /* renamed from: com.tencent.mm.plugin.finder.feed.av$a$1$c */
                static final class c extends q implements kotlin.g.a.a<x> {
                    final /* synthetic */ RefreshLoadMoreLayout.c $reason;
                    final /* synthetic */ AnonymousClass1 tTv;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    c(AnonymousClass1 r2, RefreshLoadMoreLayout.c cVar) {
                        super(0);
                        this.tTv = r2;
                        this.$reason = cVar;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        RefreshLoadMoreLayout refreshLoadMoreLayout;
                        Integer num;
                        TextView textView;
                        FinderContact finderContact;
                        azk azk;
                        TextView textView2;
                        TextView textView3;
                        TextView textView4;
                        TextView textView5;
                        AppMethodBeat.i(244436);
                        E e2 = this.$reason.tXF;
                        if (e2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
                            AppMethodBeat.o(244436);
                            throw tVar;
                        }
                        E e3 = e2;
                        if (this.$reason.Rmh != -1) {
                            if (this.$reason.actionType == 3) {
                                String str = this.tTv.tTt.TAG;
                                StringBuilder sb = new StringBuilder("refresh incrementCount ");
                                List incrementList = e3.getIncrementList();
                                if (incrementList != null) {
                                    num = Integer.valueOf(incrementList.size());
                                } else {
                                    num = null;
                                }
                                Log.i(str, sb.append(num).append(", totalCount ").append(e3.tTn).toString());
                                this.tTv.tTt.tTn = e3.tTn;
                                this.tTv.tTt.musicInfo = e3.musicInfo;
                                this.tTv.tTt.bgmInfo = e3.getBgmInfo();
                                this.tTv.tTt.cSx = e3.cSx;
                                this.tTv.tTt.tTo = e3.tTo;
                                c.b bVar = this.tTv.tTt.tMd;
                                if (bVar != null) {
                                    b bVar2 = (b) bVar;
                                    dmk dmk = e3.tXS;
                                    if (dmk != null && !dmk.MPW.isEmpty()) {
                                        bVar2.tRK.a(dmk);
                                        bVar2.getAdapter().T((long) bVar2.tRK.hashCode(), true);
                                        bVar2.getAdapter().a((com.tencent.mm.view.recyclerview.g) bVar2.tRK, (g.b) true);
                                    }
                                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                                    FinderReporterUIC fH = FinderReporterUIC.a.fH(mMActivity);
                                    if (fH != null) {
                                        i iVar = new i();
                                        try {
                                            iVar.h("topic", this.tTv.tTt.dST);
                                            iVar.U("type", this.tTv.tTt.type);
                                            iVar.v("count", this.tTv.tTt.tTn);
                                        } catch (Exception e4) {
                                        }
                                        String iVar2 = iVar.toString();
                                        p.g(iVar2, "obj.toString()");
                                        p.h(iVar2, "<set-?>");
                                        fH.wza = iVar2;
                                        com.tencent.mm.plugin.finder.report.e c2 = FinderReporterUIC.c(fH);
                                        if (c2 != null) {
                                            c2.d(fH.dIx());
                                        }
                                    }
                                    c.b bVar3 = this.tTv.tTt.tMd;
                                    if (bVar3 != null) {
                                        b bVar4 = (b) bVar3;
                                        String str2 = e3.oqZ;
                                        long j2 = this.tTv.tTt.tTn;
                                        bds bds = e3.dMU;
                                        int errCode = e3.getErrCode();
                                        String errMsg = e3.getErrMsg();
                                        if (bVar4.type == 4) {
                                            c.a dcr = bVar4.dcr();
                                            if (dcr == null) {
                                                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                                                AppMethodBeat.o(244436);
                                                throw tVar2;
                                            }
                                            a aVar2 = (a) dcr;
                                            if ((aVar2.cSx & 2) == 1 || aVar2.tTo > 0) {
                                                String str3 = bVar4.TAG;
                                                StringBuilder append = new StringBuilder(" musicInfo = ").append(bVar4.musicInfo).append(" ,bgmInfo?.contact = ");
                                                bdr bdr = aVar2.bgmInfo;
                                                if (bdr != null) {
                                                    finderContact = bdr.contact;
                                                } else {
                                                    finderContact = null;
                                                }
                                                Log.i(str3, append.append(finderContact).append(", totalCount = ").append(aVar2.tTn).toString());
                                                String str4 = bVar4.TAG;
                                                StringBuilder sb2 = new StringBuilder("Type_Follow , falg = ");
                                                c.a dcr2 = bVar4.dcr();
                                                if (dcr2 == null) {
                                                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                                                    AppMethodBeat.o(244436);
                                                    throw tVar3;
                                                }
                                                Log.i(str4, sb2.append(((a) dcr2).cSx).toString());
                                                View findViewById = bVar4.gte.findViewById(R.id.ip9);
                                                p.g(findViewById, "context.findViewById<View>(R.id.tips_layout)");
                                                findViewById.setVisibility(0);
                                                View findViewById2 = bVar4.gte.findViewById(R.id.h7t);
                                                p.g(findViewById2, "context.findViewById<View>(R.id.rl_layout)");
                                                findViewById2.setVisibility(0);
                                                c.a dcr3 = bVar4.dcr();
                                                if (dcr3 == null) {
                                                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                                                    AppMethodBeat.o(244436);
                                                    throw tVar4;
                                                }
                                                bdr bdr2 = ((a) dcr3).bgmInfo;
                                                if (bdr2 != null) {
                                                    azk = bdr2.musicInfo;
                                                } else {
                                                    azk = null;
                                                }
                                                if (azk == null) {
                                                    View findViewById3 = bVar4.gte.findViewById(R.id.bml);
                                                    p.g(findViewById3, "context.findViewById<TextView>(R.id.delete_tip_tv)");
                                                    ((TextView) findViewById3).setText(bVar4.gte.getResources().getString(R.string.ci6));
                                                } else {
                                                    View findViewById4 = bVar4.gte.findViewById(R.id.bml);
                                                    p.g(findViewById4, "context.findViewById<TextView>(R.id.delete_tip_tv)");
                                                    ((TextView) findViewById4).setText(bVar4.gte.getResources().getString(R.string.d2l));
                                                }
                                            } else {
                                                c.a dcr4 = bVar4.dcr();
                                                if (dcr4 == null) {
                                                    t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                                                    AppMethodBeat.o(244436);
                                                    throw tVar5;
                                                }
                                                bdr bdr3 = ((a) dcr4).bgmInfo;
                                                if ((bdr3 != null ? bdr3.musicInfo : null) == null) {
                                                    View view = bVar4.tOT;
                                                    if (!(view == null || (textView5 = (TextView) view.findViewById(R.id.itl)) == null)) {
                                                        textView5.setText(bVar4.gte.getResources().getString(R.string.cof, k.Gb(j2)));
                                                    }
                                                } else {
                                                    View view2 = bVar4.tOT;
                                                    if (!(view2 == null || (textView2 = (TextView) view2.findViewById(R.id.itl)) == null)) {
                                                        textView2.setText(bVar4.gte.getResources().getString(R.string.cor, k.Gb(j2)));
                                                    }
                                                }
                                                if (j2 == 0) {
                                                    View view3 = bVar4.tOT;
                                                    if (!(view3 == null || (textView4 = (TextView) view3.findViewById(R.id.itl)) == null)) {
                                                        textView4.setVisibility(4);
                                                    }
                                                    View view4 = bVar4.tOT;
                                                    if (!(view4 == null || (textView3 = (TextView) view4.findViewById(R.id.cf3)) == null)) {
                                                        textView3.setVisibility(0);
                                                    }
                                                }
                                            }
                                        } else {
                                            View view5 = bVar4.tOT;
                                            if (!(view5 == null || (textView = (TextView) view5.findViewById(R.id.itl)) == null)) {
                                                textView.setText(bVar4.gte.getResources().getString(R.string.dah, k.Gb(j2)));
                                            }
                                        }
                                        if (bVar4.type == 7) {
                                            bVar4.dMU = bds;
                                            if (bVar4.dcr() instanceof a) {
                                                c.a dcr5 = bVar4.dcr();
                                                if (dcr5 == null) {
                                                    t tVar6 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                                                    AppMethodBeat.o(244436);
                                                    throw tVar6;
                                                }
                                                ((a) dcr5).UIe.dMU = bds;
                                            }
                                            ih ihVar = new ih();
                                            ihVar.dMT.dMU = bds;
                                            ihVar.dMT.responseCode = errCode;
                                            ihVar.dMT.errMsg = errMsg;
                                            EventCenter.instance.publish(ihVar);
                                        }
                                        if (!bVar4.ddv()) {
                                            View view6 = bVar4.tOT;
                                            if (view6 != null) {
                                                switch (bVar4.type) {
                                                    case 2:
                                                        if (str2 != null) {
                                                            if (str2.length() > 0) {
                                                                View findViewById5 = view6.findViewById(R.id.ito);
                                                                p.g(findViewById5, "findViewById<TextView>(R…topic_location_sec_title)");
                                                                ((TextView) findViewById5).setText(str2);
                                                                View findViewById6 = view6.findViewById(R.id.itn);
                                                                p.g(findViewById6, "findViewById<View>(R.id.topic_location_jump)");
                                                                findViewById6.setVisibility(0);
                                                                byte[] byteArrayExtra = bVar4.gte.getIntent().getByteArrayExtra("key_topic_poi_location");
                                                                if (byteArrayExtra != null) {
                                                                    axt axt = new axt();
                                                                    axt.parseFrom(byteArrayExtra);
                                                                    if (!Util.isNullOrNil(axt.kHV) || Util.isNullOrNil(axt.fuK)) {
                                                                        View findViewById7 = view6.findViewById(R.id.itn);
                                                                        p.g(findViewById7, "findViewById<View>(R.id.topic_location_jump)");
                                                                        findViewById7.setVisibility(0);
                                                                        view6.findViewById(R.id.itn).setOnClickListener(new b.View$OnClickListenerC1131b(axt, byteArrayExtra, view6, bVar4, str2));
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            View findViewById8 = view6.findViewById(R.id.itn);
                                                            p.g(findViewById8, "findViewById<View>(R.id.topic_location_jump)");
                                                            findViewById8.setVisibility(8);
                                                            break;
                                                        }
                                                        break;
                                                    case 4:
                                                        view6.post(new b.c(view6, bVar4, str2));
                                                        break;
                                                }
                                            }
                                        } else {
                                            y yVar = bVar4.tTC;
                                            if (yVar != null) {
                                                yVar.a(bds);
                                            }
                                        }
                                    } else {
                                        t tVar7 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                                        AppMethodBeat.o(244436);
                                        throw tVar7;
                                    }
                                } else {
                                    t tVar8 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                                    AppMethodBeat.o(244436);
                                    throw tVar8;
                                }
                            } else {
                                c.b bVar5 = this.tTv.tTt.tMd;
                                if (bVar5 == null) {
                                    t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                                    AppMethodBeat.o(244436);
                                    throw tVar9;
                                }
                                ((b) bVar5).nb(false);
                            }
                        }
                        c.b bVar6 = this.tTv.tTt.tMd;
                        if (!(bVar6 == null || (refreshLoadMoreLayout = bVar6.tLS) == null)) {
                            refreshLoadMoreLayout.onPreFinishRefresh(this.$reason);
                        }
                        this.tTv.tTt.e(this.$reason);
                        x xVar = x.SXb;
                        AppMethodBeat.o(244436);
                        return xVar;
                    }
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                /* renamed from: com.tencent.mm.plugin.finder.feed.av$a$1$a  reason: collision with other inner class name */
                static final class C1128a extends q implements kotlin.g.a.a<x> {
                    final /* synthetic */ RefreshLoadMoreLayout.c $reason;
                    final /* synthetic */ AnonymousClass1 tTv;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C1128a(AnonymousClass1 r2, RefreshLoadMoreLayout.c cVar) {
                        super(0);
                        this.tTv = r2;
                        this.$reason = cVar;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(244434);
                        this.tTv.tTt.e(this.$reason);
                        x xVar = x.SXb;
                        AppMethodBeat.o(244434);
                        return xVar;
                    }
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                /* renamed from: com.tencent.mm.plugin.finder.feed.av$a$1$b */
                static final class b extends q implements kotlin.g.a.a<x> {
                    final /* synthetic */ RefreshLoadMoreLayout.c $reason;
                    final /* synthetic */ AnonymousClass1 tTv;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    b(AnonymousClass1 r2, RefreshLoadMoreLayout.c cVar) {
                        super(0);
                        this.tTv = r2;
                        this.$reason = cVar;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(244435);
                        this.tTv.tTt.e(this.$reason);
                        x xVar = x.SXb;
                        AppMethodBeat.o(244435);
                        return xVar;
                    }
                }
            };
            AppMethodBeat.o(244468);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a, com.tencent.mm.plugin.finder.feed.c.a
        public final /* synthetic */ void onAttach(c.b bVar) {
            AppMethodBeat.i(165955);
            a(bVar);
            AppMethodBeat.o(165955);
        }

        public final void atn(String str) {
            AppMethodBeat.i(244459);
            p.h(str, "<set-?>");
            this.dST = str;
            AppMethodBeat.o(244459);
        }

        public final void c(bds bds) {
            AppMethodBeat.i(244460);
            p.h(bds, "<set-?>");
            this.tRJ = bds;
            AppMethodBeat.o(244460);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class b extends IListener<hk> {
            final /* synthetic */ a tTt;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(a aVar) {
                this.tTt = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(hk hkVar) {
                AppMethodBeat.i(244447);
                hk hkVar2 = hkVar;
                p.h(hkVar2, "event");
                Log.i(this.tTt.TAG, "feedProgressListener localId:" + hkVar2.dLT.localId + ", progress:" + hkVar2.dLT.progress);
                this.tTt.tFM.updateProgressByLocalId(hkVar2.dLT.localId);
                AppMethodBeat.o(244447);
                return true;
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void a(c.b bVar) {
            AppMethodBeat.i(244461);
            p.h(bVar, "callback");
            super.onAttach(bVar);
            EventCenter.instance.add(this.tTr);
            c.b bVar2 = this.tMd;
            if (bVar2 != null) {
                byte[] byteArrayExtra = bVar2.dcl().getIntent().getByteArrayExtra("key_topic_poi_location");
                if (byteArrayExtra != null) {
                    axt axt = new axt();
                    axt.parseFrom(byteArrayExtra);
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                    if (baseFinderFeedLoader == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                        AppMethodBeat.o(244461);
                        throw tVar;
                    }
                    ((FinderTopicFeedLoader) baseFinderFeedLoader).tXM = axt;
                }
                long longExtra = bVar2.dcl().getIntent().getLongExtra("key_ref_object_id", 0);
                if (this.type != 7) {
                    BaseFinderFeedLoader baseFinderFeedLoader2 = this.tFM;
                    if (baseFinderFeedLoader2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                        AppMethodBeat.o(244461);
                        throw tVar2;
                    }
                    ((FinderTopicFeedLoader) baseFinderFeedLoader2).tXN = Long.valueOf(longExtra);
                }
                if (this.type == 4) {
                    bVar2.tLS.getRecyclerView().a(new d(bVar2, this));
                }
                if (this.type == 7) {
                    this.tTp = new e(this);
                    IListener<com.tencent.mm.g.a.f> iListener = this.tTp;
                    if (iListener != null) {
                        iListener.alive();
                    }
                }
            }
            BaseFinderFeedLoader baseFinderFeedLoader3 = this.tFM;
            if (baseFinderFeedLoader3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                AppMethodBeat.o(244461);
                throw tVar3;
            }
            ((FinderTopicFeedLoader) baseFinderFeedLoader3).tXO = new f(this);
            AppMethodBeat.o(244461);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
        public static final class d extends RecyclerView.l {
            final /* synthetic */ c.b tTA;
            final /* synthetic */ a tTt;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(244454);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(244454);
            }

            d(c.b bVar, a aVar) {
                this.tTA = bVar;
                this.tTt = aVar;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                int i4;
                AppMethodBeat.i(244453);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                this.tTt.totalDy += i3;
                a aVar = this.tTt;
                if (this.tTt.totalDy < 0) {
                    i4 = 0;
                } else {
                    i4 = this.tTt.totalDy;
                }
                aVar.totalDy = i4;
                float dimensionPixelOffset = ((float) this.tTt.totalDy) / ((float) this.tTt.gte.getResources().getDimensionPixelOffset(R.dimen.bz));
                if (dimensionPixelOffset == 0.0f) {
                    c.b bVar2 = this.tTA;
                    if (bVar2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                        AppMethodBeat.o(244453);
                        throw tVar;
                    }
                    ((b) bVar2).dds().setVisibility(4);
                } else {
                    c.b bVar3 = this.tTA;
                    if (bVar3 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                        AppMethodBeat.o(244453);
                        throw tVar2;
                    }
                    if (((b) bVar3).dds().getVisibility() == 4) {
                        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.H(true, 6);
                    }
                    c.b bVar4 = this.tTA;
                    if (bVar4 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                        AppMethodBeat.o(244453);
                        throw tVar3;
                    }
                    ((b) bVar4).dds().setVisibility(0);
                }
                c.b bVar5 = this.tTA;
                if (bVar5 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                    AppMethodBeat.o(244453);
                    throw tVar4;
                }
                ((b) bVar5).dds().setAlpha(dimensionPixelOffset);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(244453);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$onAttach$1$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class e extends IListener<com.tencent.mm.g.a.f> {
            final /* synthetic */ a tTt;

            e(a aVar) {
                this.tTt = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(com.tencent.mm.g.a.f fVar) {
                AppMethodBeat.i(244456);
                final com.tencent.mm.g.a.f fVar2 = fVar;
                if (fVar2 != null) {
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.av.a.e.AnonymousClass1 */
                        final /* synthetic */ e tTB;

                        {
                            this.tTB = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244455);
                            if (fVar2.dBS.id != 0) {
                                BaseFinderFeedLoader baseFinderFeedLoader = this.tTB.tTt.tFM;
                                if (baseFinderFeedLoader != null) {
                                    baseFinderFeedLoader.remove(fVar2.dBS.id, true);
                                }
                            } else {
                                BaseFinderFeedLoader baseFinderFeedLoader2 = this.tTB.tTt.tFM;
                                if (baseFinderFeedLoader2 != null) {
                                    baseFinderFeedLoader2.removeByLocalId(fVar2.dBS.localId, true);
                                }
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(244455);
                            return xVar;
                        }
                    });
                }
                AppMethodBeat.o(244456);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class g implements Runnable {
            final /* synthetic */ kotlin.g.a.a tRS;

            g(kotlin.g.a.a aVar) {
                this.tRS = aVar;
            }

            public final void run() {
                AppMethodBeat.i(244458);
                kotlin.g.a.a aVar = this.tRS;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(244458);
                    return;
                }
                AppMethodBeat.o(244458);
            }
        }

        public static boolean d(bds bds) {
            AppMethodBeat.i(244463);
            p.h(bds, "tag");
            long j2 = bds.twp;
            FinderTagView.a aVar = FinderTagView.wpv;
            if (j2 == FinderTagView.dHl()) {
                AppMethodBeat.o(244463);
                return true;
            }
            AppMethodBeat.o(244463);
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x014f, code lost:
            if (r1 == null) goto L_0x0151;
         */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a, com.tencent.mm.plugin.finder.feed.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onDetach() {
            /*
            // Method dump skipped, instructions count: 401
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.av.a.onDetach():void");
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final com.tencent.mm.view.recyclerview.f dce() {
            AppMethodBeat.i(244464);
            if (this.type == 7) {
                h hVar = new h(this);
                AppMethodBeat.o(244464);
                return hVar;
            }
            c.b bVar = this.tMd;
            if (bVar == null) {
                p.hyc();
            }
            com.tencent.mm.view.recyclerview.f G = bVar.dcs().G(new C1129a(this));
            AppMethodBeat.o(244464);
            return G;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$buildCampaignConvert$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        public static final class h implements com.tencent.mm.view.recyclerview.f {
            final /* synthetic */ a tTt;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            h(a aVar) {
                this.tTt = aVar;
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                AppMethodBeat.i(260235);
                switch (i2) {
                    case -5:
                        ab abVar = new ab();
                        AppMethodBeat.o(260235);
                        return abVar;
                    case -3:
                        ag agVar = new ag();
                        AppMethodBeat.o(260235);
                        return agVar;
                    case 2:
                    case 3001:
                        v vVar = new v();
                        vVar.UIe = this.tTt.UIe;
                        v vVar2 = vVar;
                        AppMethodBeat.o(260235);
                        return vVar2;
                    case 4:
                    case 9:
                    case 3002:
                        al alVar = new al();
                        alVar.UIe = this.tTt.UIe;
                        al alVar2 = alVar;
                        AppMethodBeat.o(260235);
                        return alVar2;
                    default:
                        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                        AppMethodBeat.o(260235);
                        return fVar;
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class c extends IListener<ig> {
            final /* synthetic */ a tTt;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(a aVar) {
                this.tTt = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ig igVar) {
                AppMethodBeat.i(244452);
                ig igVar2 = igVar;
                if (igVar2 != null) {
                    com.tencent.mm.ac.d.h(new C1130a(this, igVar2));
                }
                AppMethodBeat.o(244452);
                return true;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter$initViewCallback$1$callback$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.av$a$c$a  reason: collision with other inner class name */
            static final class C1130a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ ig tRO;
                final /* synthetic */ c tTx;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1130a(c cVar, ig igVar) {
                    super(0);
                    this.tTx = cVar;
                    this.tRO = igVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(244451);
                    Log.d("Finder.TimelineMachinePresenter", "tag click:" + this.tRO.dMR.dMS + ",index:" + this.tRO.dMR.index);
                    bds bds = this.tRO.dMR.dMS;
                    p.g(bds, "event.data.tag");
                    if (!a.d(bds)) {
                        if (a.d(this.tTx.tTt.tRJ)) {
                            FinderTopicFeedCache finderTopicFeedCache = this.tTx.tTt.tTq;
                            Object clone = this.tTx.tTt.tFM.getDataListJustForAdapter().clone();
                            if (clone == null) {
                                t tVar = new t("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
                                AppMethodBeat.o(244451);
                                throw tVar;
                            }
                            ArrayList<BaseFinderFeed> arrayList = (ArrayList) clone;
                            new StringBuilder("lastDataList size=").append(arrayList != null ? Integer.valueOf(arrayList.size()) : null).append(' ');
                            com.tencent.e.f.h.hkS();
                            finderTopicFeedCache.wuX = arrayList;
                        }
                        a aVar = this.tTx.tTt;
                        bds bds2 = this.tRO.dMR.dMS;
                        p.g(bds2, "event.data.tag");
                        aVar.c(bds2);
                        this.tTx.tTt.F(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.av.a.c.C1130a.AnonymousClass1 */
                            final /* synthetic */ C1130a tTy;

                            {
                                this.tTy = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(244449);
                                com.tencent.mm.ac.d.a(100, new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.finder.feed.av.a.c.C1130a.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 tTz;

                                    {
                                        this.tTz = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        int i2;
                                        WxRecyclerAdapter<?> adapter;
                                        WxRecyclerAdapter<?> adapter2;
                                        AppMethodBeat.i(244448);
                                        int size = this.tTz.tTy.tTx.tTt.tFM.getDataListJustForAdapter().size();
                                        c.b bVar = this.tTz.tTy.tTx.tTt.tMd;
                                        if (bVar == null || (adapter2 = bVar.getAdapter()) == null) {
                                            i2 = 0;
                                        } else {
                                            i2 = adapter2.RqM.size();
                                        }
                                        this.tTz.tTy.tTx.tTt.tFM.getDataListJustForAdapter().clear();
                                        c.b bVar2 = this.tTz.tTy.tTx.tTt.tMd;
                                        if (!(bVar2 == null || (adapter = bVar2.getAdapter()) == null)) {
                                            adapter.at(i2, size);
                                        }
                                        c.b bVar3 = this.tTz.tTy.tTx.tTt.tMd;
                                        if (bVar3 == null) {
                                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                                            AppMethodBeat.o(244448);
                                            throw tVar;
                                        }
                                        ((b) bVar3).nb(true);
                                        this.tTz.tTy.tTx.tTt.requestRefresh();
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(244448);
                                        return xVar;
                                    }
                                });
                                x xVar = x.SXb;
                                AppMethodBeat.o(244449);
                                return xVar;
                            }
                        });
                    } else {
                        a aVar2 = this.tTx.tTt;
                        bds bds3 = this.tRO.dMR.dMS;
                        p.g(bds3, "event.data.tag");
                        aVar2.c(bds3);
                        this.tTx.tTt.F(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.av.a.c.C1130a.AnonymousClass2 */
                            final /* synthetic */ C1130a tTy;

                            {
                                this.tTy = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                int i2;
                                WxRecyclerAdapter<?> adapter;
                                WxRecyclerAdapter<?> adapter2;
                                WxRecyclerAdapter<?> adapter3;
                                AppMethodBeat.i(244450);
                                int size = this.tTy.tTx.tTt.tFM.getSize();
                                c.b bVar = this.tTy.tTx.tTt.tMd;
                                if (bVar == null || (adapter3 = bVar.getAdapter()) == null) {
                                    i2 = 0;
                                } else {
                                    i2 = adapter3.RqM.size();
                                }
                                this.tTy.tTx.tTt.tFM.getDataListJustForAdapter().clear();
                                c.b bVar2 = this.tTy.tTx.tTt.tMd;
                                if (!(bVar2 == null || (adapter2 = bVar2.getAdapter()) == null)) {
                                    adapter2.at(i2, size);
                                }
                                c.b bVar3 = this.tTy.tTx.tTt.tMd;
                                if (bVar3 == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                                    AppMethodBeat.o(244450);
                                    throw tVar;
                                }
                                ((b) bVar3).nb(false);
                                ArrayList<BaseFinderFeed> arrayList = this.tTy.tTx.tTt.tTq.wuX;
                                if (arrayList != null) {
                                    this.tTy.tTx.tTt.tFM.getDataListJustForAdapter().addAll(arrayList);
                                }
                                c.b bVar4 = this.tTy.tTx.tTt.tMd;
                                if (!(bVar4 == null || (adapter = bVar4.getAdapter()) == null)) {
                                    adapter.at(i2, this.tTy.tTx.tTt.tFM.getSize());
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(244450);
                                return xVar;
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(244451);
                    return xVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
            AppMethodBeat.i(165957);
            if (d(this.tRJ)) {
                BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                if (baseFinderFeedLoader == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                    AppMethodBeat.o(165957);
                    throw tVar;
                }
                FinderTopicFeedLoader.a((FinderTopicFeedLoader) baseFinderFeedLoader, this.tTm);
                AppMethodBeat.o(165957);
                return;
            }
            dmk dmk = new dmk();
            dmk.MPW = new LinkedList<>();
            dmk.MPW.add(this.tRJ);
            BaseFinderFeedLoader baseFinderFeedLoader2 = this.tFM;
            if (baseFinderFeedLoader2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                AppMethodBeat.o(165957);
                throw tVar2;
            }
            ((FinderTopicFeedLoader) baseFinderFeedLoader2).a(this.tTm, dmk, 4);
            AppMethodBeat.o(165957);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(244466);
            if (d(this.tRJ)) {
                BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                if (baseFinderFeedLoader == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                    AppMethodBeat.o(244466);
                    throw tVar;
                }
                FinderTopicFeedLoader.b((FinderTopicFeedLoader) baseFinderFeedLoader, this.tTm);
                AppMethodBeat.o(244466);
                return;
            }
            dmk dmk = new dmk();
            dmk.MPW = new LinkedList<>();
            dmk.MPW.add(this.tRJ);
            BaseFinderFeedLoader baseFinderFeedLoader2 = this.tFM;
            if (baseFinderFeedLoader2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                AppMethodBeat.o(244466);
                throw tVar2;
            }
            ((FinderTopicFeedLoader) baseFinderFeedLoader2).a(this.tTm, dmk);
            AppMethodBeat.o(244466);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final j dco() {
            return this.tTs;
        }

        public final String getIconUrl() {
            cjl cjl;
            AppMethodBeat.i(165953);
            List listOfType = this.tFM.getListOfType(BaseFinderFeed.class);
            if (listOfType.isEmpty() || (cjl = (cjl) kotlin.a.j.L(((BaseFinderFeed) listOfType.get(0)).feedObject.getMediaList(), 0)) == null) {
                AppMethodBeat.o(165953);
                return "";
            }
            String str = cjl.thumbUrl + cjl.thumb_url_token;
            AppMethodBeat.o(165953);
            return str;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class f extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a tTt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(a aVar) {
                super(0);
                this.tTt = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244457);
                c.b bVar = this.tTt.tMd;
                if (bVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedViewCallback");
                    AppMethodBeat.o(244457);
                    throw tVar;
                }
                ((b) bVar).ddu();
                x xVar = x.SXb;
                AppMethodBeat.o(244457);
                return xVar;
            }
        }

        public final void F(kotlin.g.a.a<x> aVar) {
            RecyclerView recyclerView;
            RecyclerView recyclerView2;
            AppMethodBeat.i(244462);
            c.b bVar = this.tMd;
            if (!(bVar == null || (recyclerView2 = bVar.tLS.getRecyclerView()) == null)) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView2.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter", "scrollToTop", "(Lkotlin/jvm/functions/Function0;)V", "Undefined", "scrollToPosition", "(I)V");
            }
            c.b bVar2 = this.tMd;
            if (bVar2 == null || (recyclerView = bVar2.tLS.getRecyclerView()) == null) {
                AppMethodBeat.o(244462);
                return;
            }
            recyclerView.post(new g(aVar));
            AppMethodBeat.o(244462);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            AppMethodBeat.i(244465);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
            }
            this.tOh = new c(this);
            EventCenter.instance.add(this.tOh);
            AppMethodBeat.o(244465);
        }

        public final void e(RefreshLoadMoreLayout.c<Object> cVar) {
            RefreshLoadMoreLayout refreshLoadMoreLayout;
            RefreshLoadMoreLayout refreshLoadMoreLayout2;
            View loadMoreFooter;
            TextView textView;
            RefreshLoadMoreLayout refreshLoadMoreLayout3;
            View loadMoreFooter2;
            TextView textView2;
            RefreshLoadMoreLayout refreshLoadMoreLayout4;
            RefreshLoadMoreLayout refreshLoadMoreLayout5;
            View loadMoreFooter3;
            String str;
            View view;
            TextView textView3;
            TextView textView4;
            View findViewById;
            View findViewById2;
            View findViewById3;
            aqk aqk;
            boolean z = true;
            AppMethodBeat.i(244467);
            p.h(cVar, "reason");
            E e2 = cVar.tXF;
            if (e2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.TopicResponse");
                AppMethodBeat.o(244467);
                throw tVar;
            }
            E e3 = e2;
            if (e3.getHasMore()) {
                c.b bVar = this.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(244467);
                    return;
                }
                refreshLoadMoreLayout.setEnableLoadMore(true);
                AppMethodBeat.o(244467);
            } else if (this.type == 7) {
                int size = this.tFM.getSize();
                c.b bVar2 = this.tMd;
                if (bVar2 == null || (refreshLoadMoreLayout5 = bVar2.tLS) == null || (loadMoreFooter3 = refreshLoadMoreLayout5.getLoadMoreFooter()) == null) {
                    AppMethodBeat.o(244467);
                    return;
                }
                bds bds = e3.dMU;
                if (bds == null || (aqk = bds.LNz) == null) {
                    str = null;
                } else {
                    str = aqk.coverImgUrl;
                }
                if (Util.isNullOrNil(str)) {
                    z = false;
                }
                c.b bVar3 = this.tMd;
                if (!(bVar3 instanceof b)) {
                    bVar3 = null;
                }
                b bVar4 = (b) bVar3;
                if (bVar4 != null) {
                    view = bVar4.UIv;
                } else {
                    view = null;
                }
                if (size > 0) {
                    loadMoreFooter3.setVisibility(0);
                    View findViewById4 = loadMoreFooter3.findViewById(R.id.ep1);
                    p.g(findViewById4, "findViewById<View>(R.id.load_more_footer_tip_tv)");
                    findViewById4.setVisibility(8);
                    View findViewById5 = loadMoreFooter3.findViewById(R.id.ep0);
                    p.g(findViewById5, "findViewById<View>(R.id.…d_more_footer_end_layout)");
                    findViewById5.setVisibility(0);
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    if (z) {
                        int color = loadMoreFooter3.getResources().getColor(R.color.BW_100_Alpha_0_3);
                        View findViewById6 = loadMoreFooter3.findViewById(R.id.aq8);
                        p.g(findViewById6, "findViewById<View>(R.id.center_icon)");
                        findViewById6.setBackground(loadMoreFooter3.getResources().getDrawable(R.drawable.cul));
                        loadMoreFooter3.findViewById(R.id.ea_).setBackgroundColor(color);
                        loadMoreFooter3.findViewById(R.id.h76).setBackgroundColor(color);
                        AppMethodBeat.o(244467);
                        return;
                    }
                    int color2 = loadMoreFooter3.getResources().getColor(R.color.FG_2);
                    View findViewById7 = loadMoreFooter3.findViewById(R.id.aq8);
                    p.g(findViewById7, "findViewById<View>(R.id.center_icon)");
                    findViewById7.setBackground(loadMoreFooter3.getResources().getDrawable(R.drawable.cum));
                    loadMoreFooter3.findViewById(R.id.ea_).setBackgroundColor(color2);
                    loadMoreFooter3.findViewById(R.id.h76).setBackgroundColor(color2);
                    AppMethodBeat.o(244467);
                    return;
                }
                loadMoreFooter3.setVisibility(8);
                if (view != null) {
                    view.setVisibility(0);
                }
                if (!(view == null || (findViewById3 = view.findViewById(R.id.c35)) == null)) {
                    findViewById3.setVisibility(0);
                }
                if (!(view == null || (findViewById2 = view.findViewById(R.id.h5w)) == null)) {
                    findViewById2.setVisibility(8);
                }
                if (!(view == null || (findViewById = view.findViewById(R.id.gl7)) == null)) {
                    findViewById.setVisibility(8);
                }
                if (z) {
                    if (view == null || (textView4 = (TextView) view.findViewById(R.id.c35)) == null) {
                        AppMethodBeat.o(244467);
                        return;
                    }
                    textView4.setTextColor(loadMoreFooter3.getResources().getColor(R.color.BW_100_Alpha_0_3));
                    AppMethodBeat.o(244467);
                } else if (view == null || (textView3 = (TextView) view.findViewById(R.id.c35)) == null) {
                    AppMethodBeat.o(244467);
                } else {
                    textView3.setTextColor(loadMoreFooter3.getResources().getColor(R.color.FG_2));
                    AppMethodBeat.o(244467);
                }
            } else {
                c.b bVar5 = this.tMd;
                if (!(bVar5 == null || (refreshLoadMoreLayout4 = bVar5.tLS) == null)) {
                    if (this.tFM.getSize() <= 10) {
                        z = false;
                    }
                    refreshLoadMoreLayout4.setEnableLoadMore(z);
                }
                c.b bVar6 = this.tMd;
                if (!(bVar6 == null || (refreshLoadMoreLayout3 = bVar6.tLS) == null || (loadMoreFooter2 = refreshLoadMoreLayout3.getLoadMoreFooter()) == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView2.setText(R.string.d0m);
                }
                c.b bVar7 = this.tMd;
                if (bVar7 == null || (refreshLoadMoreLayout2 = bVar7.tLS) == null || (loadMoreFooter = refreshLoadMoreLayout2.getLoadMoreFooter()) == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null) {
                    AppMethodBeat.o(244467);
                    return;
                }
                textView.setTextColor(this.gte.getResources().getColor(R.color.FG_2));
                AppMethodBeat.o(244467);
            }
        }
    }

    static {
        AppMethodBeat.i(165979);
        AppMethodBeat.o(165979);
    }

    private av() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010Q\u001a\u00020RJ\u0010\u0010S\u001a\u00020R2\b\u0010T\u001a\u0004\u0018\u00010UJ\u000e\u0010V\u001a\u00020R2\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020RJ\b\u0010Z\u001a\u00020\u0003H\u0016J\u0018\u0010[\u001a\u0004\u0018\u00010\u000b2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]H\u0016J\n\u0010_\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010`\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020d2\u0006\u0010\u0002\u001a\u00020eH\u0016J\u0018\u0010f\u001a\u0004\u0018\u00010\u000b2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]H\u0016J \u0010g\u001a\u00020R2\u0016\u0010h\u001a\u0012\u0012\u0004\u0012\u00020j0ij\b\u0012\u0004\u0012\u00020j`kH\u0016J\u0006\u0010l\u001a\u00020\bJ\u0006\u0010m\u001a\u00020RJ$\u0010n\u001a\u00020R2\n\u0010o\u001a\u0006\u0012\u0002\b\u00030p2\u0006\u0010q\u001a\u00020\u00142\u0006\u0010r\u001a\u00020\u0005H\u0016J\b\u0010s\u001a\u00020RH\u0016J\u0016\u0010t\u001a\u00020R2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]H\u0016J\u0010\u0010u\u001a\u00020\b2\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020R2\b\u0010y\u001a\u0004\u0018\u00010\u000bJ4\u0010z\u001a\u00020R2\b\u0010y\u001a\u0004\u0018\u00010\u000b2\u0006\u0010{\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010|\u001a\u00020\u00052\b\u0010}\u001a\u0004\u0018\u00010\u000bJ\b\u0010~\u001a\u00020\bH\u0016J\b\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\bR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u0010\u0010<\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001b\"\u0004\bM\u0010\u001dR\u001a\u0010N\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010)\"\u0004\bP\u0010+¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPR_LOADING_HEADER", "activityHeaderManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "getActivityHeaderManager", "()Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "setActivityHeaderManager", "(Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;)V", "campaignEmptyView", "Landroid/view/View;", "getCampaignEmptyView", "()Landroid/view/View;", "setCampaignEmptyView", "(Landroid/view/View;)V", "followId", "getFollowId", "()Ljava/lang/String;", "setFollowId", "(Ljava/lang/String;)V", "followTopicFloatHeader", "getFollowTopicFloatHeader", "setFollowTopicFloatHeader", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "innerTabType", "getInnerTabType", "()I", "setInnerTabType", "(I)V", "isEnableActivityHeader", "loadingHeader", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "topic", "getTopic", "setTopic", "topicHeader", "topicHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "topicId", "", "getTopicId", "()J", "setTopicId", "(J)V", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "topicNonceId", "getTopicNonceId", "setTopicNonceId", "type", "getType", "setType", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "bindFeedFlowEventSubscriber", "fragment", "Landroid/support/v4/app/Fragment;", "dimissLoadingHeader", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isHeaderWithFollow", "onDetach", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "onTopicOnRefreshEnd", "otherFullSpan", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "refreshHeader", "subTitle", "refreshHeaderContent", "count", "errCode", "errMsg", "refreshWhenEnter", "showHeaderOnDataEmpty", "showProgressHeader", "ifShow", "plugin-finder_release"})
    public static final class b extends c.b {
        final String TAG;
        private final boolean UIu;
        public View UIv;
        bds dMU;
        public String dST;
        azk musicInfo;
        View tOT;
        com.tencent.mm.plugin.finder.model.j tRK;
        y tTC;
        public View tTD;
        private View tTE;
        private final int tTF;
        public String tTG;
        public int tTH;
        com.tencent.mm.plugin.finder.activity.view.a tTI;
        public boolean tTJ;
        public long twp;
        public String twq;
        public int type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private b(MMActivity mMActivity, int i2) {
            super(mMActivity, 2, i2, false);
            p.h(mMActivity, "context");
            AppMethodBeat.i(244486);
            this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
            this.tTF = -2;
            this.dST = "";
            this.tTG = "";
            this.twq = "";
            this.tTH = 1;
            this.tRK = new com.tencent.mm.plugin.finder.model.j(new dmk());
            this.tTJ = true;
            AppMethodBeat.o(244486);
        }

        public /* synthetic */ b(MMActivity mMActivity, int i2, byte b2) {
            this(mMActivity, i2);
        }

        public final View dds() {
            AppMethodBeat.i(244472);
            View view = this.tTD;
            if (view == null) {
                p.btv("followTopicFloatHeader");
            }
            AppMethodBeat.o(244472);
            return view;
        }

        public final void atn(String str) {
            AppMethodBeat.i(244473);
            p.h(str, "<set-?>");
            this.dST = str;
            AppMethodBeat.o(244473);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void ab(ArrayList<bo> arrayList) {
            AppMethodBeat.i(244474);
            p.h(arrayList, "data");
            if (this.UIu) {
                switch (this.type) {
                    case 7:
                        this.tTI = new com.tencent.mm.plugin.finder.activity.view.a(this.gte);
                        break;
                }
            }
            if (ddv()) {
                this.tTC = new y(this.gte, this.tLS);
            }
            super.ab(arrayList);
            AppMethodBeat.o(244474);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final boolean dcu() {
            if (this.type == 7) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final boolean dct() {
            return this.tTJ;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
            if (kotlin.g.b.p.j(r0, java.lang.Integer.valueOf(com.tencent.mm.plugin.finder.convert.be.cZK())) != false) goto L_0x002e;
         */
        @Override // com.tencent.mm.plugin.finder.feed.c.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean l(com.tencent.mm.view.recyclerview.h r4) {
            /*
                r3 = this;
                r2 = 244475(0x3bafb, float:3.42582E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.lang.String r0 = "holder"
                kotlin.g.b.p.h(r4, r0)
                int r0 = r4.lU()
                int r1 = r3.tTF
                if (r0 == r1) goto L_0x002e
                java.lang.Object r0 = r4.getTag()
                if (r0 == 0) goto L_0x0033
                java.lang.Object r0 = r4.getTag()
                com.tencent.mm.plugin.finder.convert.be$a r1 = com.tencent.mm.plugin.finder.convert.be.tER
                int r1 = com.tencent.mm.plugin.finder.convert.be.cZK()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
            L_0x002e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0032:
                return r0
            L_0x0033:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.av.b.l(com.tencent.mm.view.recyclerview.h):boolean");
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            FinderItem finderItem;
            aqk aqk;
            String str;
            dmk dmk;
            BaseFinderFeedLoader baseFinderFeedLoader;
            BaseFinderFeedLoader baseFinderFeedLoader2;
            BaseFinderFeedLoader baseFinderFeedLoader3;
            bbn dIx;
            LinkedList<bds> linkedList;
            bds bds;
            String string;
            bbn dIx2;
            BaseFinderFeedLoader baseFinderFeedLoader4;
            List listOfType;
            BaseFinderFeedLoader baseFinderFeedLoader5;
            AppMethodBeat.i(244476);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(aVar);
            bVar.bm(view);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, bVar.axR());
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0) {
                c.a dcq = dcq();
                if (size < ((dcq == null || (baseFinderFeedLoader5 = dcq.tFM) == null) ? null : Integer.valueOf(baseFinderFeedLoader5.getSize())).intValue()) {
                    c.a dcq2 = dcq();
                    BaseFinderFeed baseFinderFeed = (dcq2 == null || (baseFinderFeedLoader4 = dcq2.tFM) == null || (listOfType = baseFinderFeedLoader4.getListOfType(BaseFinderFeed.class)) == null) ? null : (BaseFinderFeed) listOfType.get(size);
                    if (baseFinderFeed != null) {
                        finderItem = baseFinderFeed.feedObject;
                    } else {
                        finderItem = null;
                    }
                    Log.i(this.TAG, "onClick " + size + " id:" + (finderItem != null ? Long.valueOf(finderItem.getId()) : null).longValue() + ", pos:" + size);
                    if (finderItem == null || finderItem.getMediaType() != 9) {
                        Intent intent = new Intent();
                        intent.putExtra("key_topic_type", this.type);
                        if (this.type == 4) {
                            c.a dcr = dcr();
                            if (dcr == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                                AppMethodBeat.o(244476);
                                throw tVar;
                            }
                            bdr bdr = ((a) dcr).bgmInfo;
                            if (bdr != null) {
                                if (bdr.musicInfo != null) {
                                    azk azk = bdr.musicInfo;
                                    string = String.valueOf(azk != null ? azk.name : null);
                                } else {
                                    MMActivity mMActivity = this.gte;
                                    Object[] objArr = new Object[1];
                                    FinderContact finderContact = bdr.contact;
                                    objArr[0] = finderContact != null ? finderContact.nickname : null;
                                    string = mMActivity.getString(R.string.coo, objArr);
                                    p.g(string, "context.getString(R.stri…tle,it.contact?.nickname)");
                                }
                                intent.putExtra("key_topic_title", string);
                                intent.putExtra("KEY_FOLLOW_ID", bdr.groupId);
                            }
                        } else if (this.type == 7) {
                            bds bds2 = this.dMU;
                            if (!(bds2 == null || (aqk = bds2.LNz) == null)) {
                                intent.putExtra("key_activity_name", aqk.eventName);
                                FinderContact finderContact2 = aqk.contact;
                                if (finderContact2 == null || (str = finderContact2.username) == null) {
                                    str = "";
                                }
                                intent.putExtra("key_creator_finder_name", str);
                                intent.putExtra("key_activity_id", aqk.twd);
                                intent.putExtra("key_activity_inner_tab_type", this.tTH);
                                intent.putExtra("key_activity_max_top_count", aqk.tUe);
                            }
                        } else {
                            intent.putExtra("key_topic_title", this.dST);
                        }
                        intent.putExtra("KEY_CLICK_FEED_ID", (finderItem != null ? Long.valueOf(finderItem.getId()) : null).longValue());
                        intent.putExtra("KEY_CLICK_FEED_POSITION", size);
                        c.a dcq3 = dcq();
                        if (dcq3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderTopicFeedUIContract.TopicFeedPresenter");
                            AppMethodBeat.o(244476);
                            throw tVar2;
                        }
                        a aVar2 = (a) dcq3;
                        if (a.d(aVar2.tRJ)) {
                            dmk = null;
                        } else {
                            dmk dmk2 = new dmk();
                            dmk2.MPW = new LinkedList<>();
                            dmk2.MPW.add(aVar2.tRJ);
                            dmk = dmk2;
                        }
                        BaseFinderFeedLoader baseFinderFeedLoader6 = dcq().tFM;
                        if (baseFinderFeedLoader6 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                            AppMethodBeat.o(244476);
                            throw tVar3;
                        }
                        dcq().tFM.saveCache(intent, size, new FinderTopicTimelineUIContract.c(dmk, ((FinderTopicFeedLoader) baseFinderFeedLoader6).atr((dmk == null || (linkedList = dmk.MPW) == null || (bds = linkedList.get(0)) == null) ? null : bds.dST)));
                        intent.putExtra("key_ref_object_id", this.gte.getIntent().getLongExtra("key_ref_object_id", 0));
                        c.a dcq4 = dcq();
                        if (dcq4 != null) {
                            baseFinderFeedLoader = dcq4.tFM;
                        } else {
                            baseFinderFeedLoader = null;
                        }
                        if (baseFinderFeedLoader == null) {
                            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                            AppMethodBeat.o(244476);
                            throw tVar4;
                        }
                        axt axt = ((FinderTopicFeedLoader) baseFinderFeedLoader).tXM;
                        intent.putExtra("KEY_FINDER_LOCATION", axt != null ? axt.toByteArray() : null);
                        c.a dcq5 = dcq();
                        if (dcq5 != null) {
                            baseFinderFeedLoader2 = dcq5.tFM;
                        } else {
                            baseFinderFeedLoader2 = null;
                        }
                        if (baseFinderFeedLoader2 == null) {
                            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                            AppMethodBeat.o(244476);
                            throw tVar5;
                        }
                        bcc bcc = ((FinderTopicFeedLoader) baseFinderFeedLoader2).tvs;
                        if (bcc != null) {
                            intent.putExtra("KEY_SECTION_INFO", bcc != null ? bcc.toByteArray() : null);
                        }
                        c.a dcq6 = dcq();
                        if (dcq6 != null) {
                            baseFinderFeedLoader3 = dcq6.tFM;
                        } else {
                            baseFinderFeedLoader3 = null;
                        }
                        if (baseFinderFeedLoader3 == null) {
                            t tVar6 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
                            AppMethodBeat.o(244476);
                            throw tVar6;
                        }
                        ((FinderTopicFeedLoader) baseFinderFeedLoader3).tXJ = null;
                        Log.i(this.TAG, "enterTopicTimelineUI, fixPos:".concat(String.valueOf(size)));
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        Context context = view.getContext();
                        p.g(context, "view.context");
                        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context2 = view.getContext();
                        p.g(context2, "view.context");
                        com.tencent.mm.plugin.finder.utils.a.P(context2, intent);
                        if (finderItem != null) {
                            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                            com.tencent.mm.plugin.finder.report.k.J(finderItem.getId(), 2);
                            FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                            Context context3 = view.getContext();
                            p.g(context3, "view.context");
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                            if (!(fH == null || (dIx = fH.dIx()) == null)) {
                                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                                com.tencent.mm.plugin.finder.report.k.a(dIx, finderItem.getId(), this.tLS.getRecyclerView(), this.tTH);
                            }
                        }
                    } else {
                        if (Util.isEqual(finderItem.getUserName(), z.aUg())) {
                            com.tencent.mm.plugin.finder.utils.a aVar6 = com.tencent.mm.plugin.finder.utils.a.vUU;
                            MMActivity mMActivity2 = this.gte;
                            long id = finderItem.getId();
                            String objectNonceId = finderItem.getObjectNonceId();
                            awe liveInfo = finderItem.getLiveInfo();
                            if (liveInfo == null) {
                                liveInfo = new awe();
                            }
                            com.tencent.mm.plugin.finder.utils.a.a(mMActivity2, id, objectNonceId, liveInfo, false, null, null, null, null, null, finderItem.getFinderObject().sessionBuffer, null, null, 14320);
                        } else {
                            com.tencent.mm.plugin.finder.report.live.k.vkd.a(baseFinderFeed, (long) i2, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, "26");
                            FinderReporterUIC.a aVar7 = FinderReporterUIC.wzC;
                            Context context4 = view.getContext();
                            p.g(context4, "view.context");
                            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context4);
                            int i3 = (fH2 == null || (dIx2 = fH2.dIx()) == null) ? 0 : dIx2.tCE;
                            com.tencent.mm.plugin.finder.utils.a aVar8 = com.tencent.mm.plugin.finder.utils.a.vUU;
                            m mVar = m.vVH;
                            com.tencent.mm.plugin.finder.utils.a.a(this.gte, m.a(dcq().tFM.getDataList(), baseFinderFeed, this.type, i3), (String) null, (String) null, (Intent) null, 28);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
                        AppMethodBeat.o(244476);
                        return;
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
            AppMethodBeat.o(244476);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(244477);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = dcs().eS(context);
            AppMethodBeat.o(244477);
            return eS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(244478);
            RecyclerView.h itemDecoration = dcs().getItemDecoration();
            AppMethodBeat.o(244478);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getHeaderView() {
            View view;
            b bVar;
            TextView textView;
            AppMethodBeat.i(244480);
            switch (this.type) {
                case 1:
                case 5:
                    if (this.tTC == null) {
                        this.tOT = View.inflate(this.gte, R.layout.ako, null);
                        View view2 = this.tOT;
                        if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.iu2)) == null)) {
                            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.dST));
                            break;
                        }
                    } else {
                        y yVar = this.tTC;
                        if (yVar == null) {
                            p.hyc();
                        }
                        Log.i("Finder.FinderNewsTopicHelper", "getTopicHeaderView : " + ((Object) null));
                        View inflate = aa.jQ(yVar.gte).inflate(R.layout.akr, (ViewGroup) null, false);
                        String stringExtra = yVar.gte.getIntent().getStringExtra("key_topic_title");
                        if (stringExtra == null) {
                            stringExtra = "";
                        }
                        TextView textView2 = (TextView) inflate.findViewById(R.id.its);
                        if (textView2 != null) {
                            if (!n.J(stringExtra, "#", false)) {
                                textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(textView2.getContext(), "#".concat(String.valueOf(stringExtra))));
                            } else {
                                textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(textView2.getContext(), stringExtra));
                            }
                            ao.a(textView2.getPaint(), 0.8f);
                        }
                        TextView textView3 = (TextView) inflate.findViewById(R.id.cew);
                        if (textView3 != null) {
                            textView3.setVisibility(8);
                        }
                        yVar.a((bds) null);
                        p.g(inflate, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                        view = inflate;
                        bVar = this;
                        bVar.tOT = view;
                        break;
                    }
                case 2:
                    View inflate2 = View.inflate(this.gte, R.layout.ako, null);
                    View findViewById = inflate2.findViewById(R.id.iu2);
                    p.g(findViewById, "findViewById<TextView>(R.id.topic_tv)");
                    ((TextView) findViewById).setText(com.tencent.mm.pluginsdk.ui.span.l.c(inflate2.getContext(), this.dST));
                    ((ImageView) inflate2.findViewById(R.id.itm)).setImageResource(R.raw.icons_outlined_location);
                    view = inflate2;
                    bVar = this;
                    bVar.tOT = view;
                    break;
                case 4:
                    this.tOT = new FinderFollowTopicHeaderView(this.gte);
                    View inflate3 = aa.jQ(this.gte).inflate(R.layout.abp, (ViewGroup) null);
                    p.g(inflate3, "MMLayoutInflater.getInfl…er_on_scroll_layout,null)");
                    this.tTD = inflate3;
                    View view3 = this.tTD;
                    if (view3 == null) {
                        p.btv("followTopicFloatHeader");
                    }
                    view3.setAlpha(0.0f);
                    View view4 = this.tTD;
                    if (view4 == null) {
                        p.btv("followTopicFloatHeader");
                    }
                    view4.setVisibility(4);
                    y yVar2 = y.vXH;
                    if (y.dCL() == 1) {
                        View view5 = this.tTD;
                        if (view5 == null) {
                            p.btv("followTopicFloatHeader");
                        }
                        View findViewById2 = view5.findViewById(R.id.d7z);
                        p.g(findViewById2, "followTopicFloatHeader.f…w>(R.id.follow_btn_float)");
                        findViewById2.setVisibility(8);
                    } else {
                        View view6 = this.tTD;
                        if (view6 == null) {
                            p.btv("followTopicFloatHeader");
                        }
                        view6.findViewById(R.id.d7z).setOnClickListener(new a(this));
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.gte.getResources().getDimensionPixelSize(R.dimen.cn));
                    layoutParams.gravity = 48;
                    layoutParams.setMargins(0, au.ay(this.gte), 0, 0);
                    Window window = this.gte.getWindow();
                    p.g(window, "context.window");
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        FrameLayout frameLayout = (FrameLayout) decorView;
                        View view7 = this.tTD;
                        if (view7 == null) {
                            p.btv("followTopicFloatHeader");
                        }
                        frameLayout.addView(view7, layoutParams);
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                        AppMethodBeat.o(244480);
                        throw tVar;
                    }
                case 7:
                    com.tencent.mm.plugin.finder.activity.view.a aVar = this.tTI;
                    if (aVar != null) {
                        view = aa.jQ(aVar.gte).inflate(R.layout.a9a, (ViewGroup) null, false);
                        aVar.dR(view);
                        p.g(view, "headerView");
                        bVar = this;
                    } else {
                        view = null;
                        bVar = this;
                    }
                    bVar.tOT = view;
                    break;
            }
            View view8 = this.tOT;
            AppMethodBeat.o(244480);
            return view8;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ b tTK;

            a(b bVar) {
                this.tTK = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(244469);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$getHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                View view2 = this.tTK.tOT;
                if (view2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView");
                    AppMethodBeat.o(244469);
                    throw tVar;
                }
                ((FinderFollowTopicHeaderView) view2).dla();
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.H(false, 6);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$getHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(244469);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244481);
            p.h(cVar, "reason");
            AppMethodBeat.o(244481);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244482);
            p.h(cVar, "reason");
            AppMethodBeat.o(244482);
            return null;
        }

        public final synchronized void nb(boolean z) {
            AppMethodBeat.i(244483);
            Log.d(this.TAG, "showProgressHeader = ".concat(String.valueOf(z)));
            if (z) {
                ddt();
                AppMethodBeat.o(244483);
            } else {
                ddu();
                AppMethodBeat.o(244483);
            }
        }

        private synchronized void ddt() {
            ViewParent viewParent;
            AppMethodBeat.i(244484);
            if (this.tTE == null) {
                this.tTE = aa.jQ(this.gte).inflate(R.layout.ag8, (ViewGroup) null);
            }
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("ken loading header:");
            View view = this.tTE;
            Log.d(str, sb.append(view != null ? view.getParent() : null).toString());
            View view2 = this.tTE;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                AppMethodBeat.o(244484);
            } else {
                if (this.tTE != null) {
                    WxRecyclerAdapter<?> adapter = getAdapter();
                    View view3 = this.tTE;
                    if (view3 == null) {
                        p.hyc();
                    }
                    adapter.f(view3, this.tTF, true);
                }
                AppMethodBeat.o(244484);
            }
        }

        public final void ddu() {
            AppMethodBeat.i(244485);
            if (this.tTE != null) {
                WxRecyclerAdapter<?> adapter = getAdapter();
                View view = this.tTE;
                if (view == null) {
                    p.hyc();
                }
                adapter.T((long) view.hashCode(), true);
            }
            AppMethodBeat.o(244485);
        }

        public final boolean ddv() {
            return this.type == 5;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\b"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$1$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$2"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.av$b$b  reason: collision with other inner class name */
        static final class View$OnClickListenerC1131b implements View.OnClickListener {
            final /* synthetic */ b tTK;
            final /* synthetic */ axt tTL;
            final /* synthetic */ byte[] tTM;
            final /* synthetic */ View tTN;
            final /* synthetic */ String tTO;

            View$OnClickListenerC1131b(axt axt, byte[] bArr, View view, b bVar, String str) {
                this.tTL = axt;
                this.tTM = bArr;
                this.tTN = view;
                this.tTK = bVar;
                this.tTO = str;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(244470);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                y yVar = y.vXH;
                Context context = this.tTN.getContext();
                p.g(context, "context");
                y.a(context, this.tTL);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(244470);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshHeader$1$2"})
        static final class c implements Runnable {
            final /* synthetic */ View tCl;
            final /* synthetic */ b tTK;
            final /* synthetic */ String tTO;

            c(View view, b bVar, String str) {
                this.tCl = view;
                this.tTK = bVar;
                this.tTO = str;
            }

            /* JADX WARNING: Removed duplicated region for block: B:165:0x0494  */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0258  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 1450
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.av.b.c.run():void");
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void j(RefreshLoadMoreLayout.c<Object> cVar) {
            View loadMoreFooter;
            AppMethodBeat.i(260236);
            p.h(cVar, "reason");
            if (this.type == 7) {
                E e2 = cVar.tXF;
                if (!(e2 instanceof FinderTopicFeedLoader.e)) {
                    e2 = null;
                }
                E e3 = e2;
                if (!((e3 != null ? e3.getHasMore() : true) || cVar.Rmk == 0 || (loadMoreFooter = this.tLS.getLoadMoreFooter()) == null)) {
                    loadMoreFooter.setVisibility(0);
                    View findViewById = loadMoreFooter.findViewById(R.id.ep1);
                    p.g(findViewById, "findViewById<View>(R.id.load_more_footer_tip_tv)");
                    findViewById.setVisibility(8);
                    View findViewById2 = loadMoreFooter.findViewById(R.id.ep0);
                    p.g(findViewById2, "findViewById<View>(R.id.…d_more_footer_end_layout)");
                    findViewById2.setVisibility(0);
                    AppMethodBeat.o(260236);
                    return;
                }
            }
            AppMethodBeat.o(260236);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(244479);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(244479);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setTopicInfo", "plugin-finder_release"})
    public static final class c {
        public bds dMU;

        private c() {
            this.dMU = null;
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }
}
