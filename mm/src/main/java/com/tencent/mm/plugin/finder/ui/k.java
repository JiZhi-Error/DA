package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.convert.bw;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0013\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\"\u001a\u00020\u0007J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u0016\u0010)\u001a\u00020\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZI)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "feedProgressListener", "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1;", "onBindMoreConvert", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnBindMoreConvert", "()Lkotlin/jvm/functions/Function1;", "setOnBindMoreConvert", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "consumeBackPressed", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "smoothScrollToNextPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class k extends j.a {
    String TAG = "Finder.FinderShareFeedDetailUI";
    private com.tencent.mm.plugin.finder.view.b tPE;
    kotlin.g.a.b<? super View, x> vQl;
    private final b vQm = new b(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(int i2, MMActivity mMActivity, boolean z, int i3) {
        super(i2, mMActivity, z, i3, (byte) 0);
        p.h(mMActivity, "context");
        AppMethodBeat.i(252839);
        AppMethodBeat.o(252839);
    }

    public static final /* synthetic */ f a(k kVar) {
        AppMethodBeat.i(252840);
        f dce = super.dce();
        AppMethodBeat.o(252840);
        return dce;
    }

    @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a
    public final String getTAG() {
        return this.TAG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<hk> {
        final /* synthetic */ k vQn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(k kVar) {
            this.vQn = kVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hk hkVar) {
            AppMethodBeat.i(252830);
            hk hkVar2 = hkVar;
            p.h(hkVar2, "event");
            Log.i(this.vQn.TAG, "feedProgressListener localId:" + hkVar2.dLT.localId + ", progress:" + hkVar2.dLT.progress);
            BaseFinderFeedLoader baseFinderFeedLoader = this.vQn.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.updateProgressByLocalId(hkVar2.dLT.localId);
            }
            AppMethodBeat.o(252830);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ k vQn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(k kVar) {
            this.vQn = kVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            bbn bbn;
            AppMethodBeat.i(252829);
            if (this.vQn.dca()) {
                e<?> EC = k.a(this.vQn).EC(i2);
                AppMethodBeat.o(252829);
                return EC;
            }
            switch (i2) {
                case 2:
                case 3001:
                    b bVar = new b(this, this.vQn, this.vQn.tAj, this.vQn.dLS);
                    AppMethodBeat.o(252829);
                    return bVar;
                case 4:
                case 3002:
                    C1300a aVar = new C1300a(this, this.vQn.tCD, this.vQn, this.vQn.tAj, this.vQn.dLS);
                    AppMethodBeat.o(252829);
                    return aVar;
                case 2001:
                    c cVar = new c(this);
                    AppMethodBeat.o(252829);
                    return cVar;
                case 2016:
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vQn.gte);
                    if (fH != null) {
                        bbn = fH.dIx();
                    } else {
                        bbn = null;
                    }
                    bw bwVar = new bw(bbn, this.vQn.dLS);
                    AppMethodBeat.o(252829);
                    return bwVar;
                default:
                    e<?> EC2 = k.a(this.vQn).EC(i2);
                    AppMethodBeat.o(252829);
                    return EC2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.ui.k$a$a  reason: collision with other inner class name */
        public static final class C1300a extends ak {
            final /* synthetic */ a vQo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1300a(a aVar, com.tencent.mm.plugin.finder.video.k kVar, i iVar, boolean z, int i2) {
                super(kVar, iVar, z, i2);
                this.vQo = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.plugin.finder.convert.ak
            public final /* bridge */ /* synthetic */ void a(h hVar, ad adVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(252823);
                a(hVar, adVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(252823);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.ak
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(252822);
                a(hVar, (ad) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(252822);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ak
            public final void a(h hVar, ad adVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(252821);
                p.h(hVar, "holder");
                p.h(adVar, "item");
                super.a(hVar, adVar, i2, i3, z, list);
                if (adVar.feedObject.isPostFinish()) {
                    k.d(hVar, this.tAj);
                }
                View Mn = hVar.Mn(R.id.d7i);
                if (Mn != null) {
                    Mn.setVisibility(8);
                    AppMethodBeat.o(252821);
                    return;
                }
                AppMethodBeat.o(252821);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class b extends u {
            final /* synthetic */ a vQo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, i iVar, boolean z, int i2) {
                super(iVar, z, i2);
                this.vQo = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.plugin.finder.convert.u
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(252826);
                a(hVar, uVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(252826);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.u
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(252825);
                a(hVar, (com.tencent.mm.plugin.finder.model.u) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(252825);
            }

            @Override // com.tencent.mm.plugin.finder.convert.u
            public final void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(252824);
                p.h(hVar, "holder");
                p.h(uVar, "item");
                super.a(hVar, uVar, i2, i3, z, list);
                if (uVar.feedObject.isPostFinish()) {
                    k.d(hVar, this.tAj);
                }
                View Mn = hVar.Mn(R.id.d7i);
                if (Mn != null) {
                    Mn.setVisibility(8);
                    AppMethodBeat.o(252824);
                    return;
                }
                AppMethodBeat.o(252824);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class c extends be {
            final /* synthetic */ a vQo;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(a aVar) {
                this.vQo = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.be, com.tencent.mm.view.recyclerview.e
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.b bVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(252828);
                a(hVar, bVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(252828);
            }

            @Override // com.tencent.mm.plugin.finder.convert.be
            public final void a(h hVar, com.tencent.mm.plugin.finder.model.b bVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(252827);
                p.h(hVar, "holder");
                p.h(bVar, "item");
                super.a(hVar, bVar, i2, i3, z, list);
                kotlin.g.a.b<? super View, x> bVar2 = this.vQo.vQn.vQl;
                if (bVar2 != null) {
                    View view = hVar.aus;
                    p.g(view, "holder.itemView");
                    bVar2.invoke(view);
                    AppMethodBeat.o(252827);
                    return;
                }
                AppMethodBeat.o(252827);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a
    public final f dce() {
        AppMethodBeat.i(252833);
        a aVar = new a(this);
        AppMethodBeat.o(252833);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.v.a
    public final void a(BaseFinderFeedLoader baseFinderFeedLoader, v.b bVar) {
        AppMethodBeat.i(252834);
        p.h(baseFinderFeedLoader, "model");
        p.h(bVar, "callback");
        super.a(baseFinderFeedLoader, bVar);
        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tFM;
        if (baseFinderFeedLoader2 != null) {
            this.tPE = new com.tencent.mm.plugin.finder.view.b(baseFinderFeedLoader2);
            com.tencent.mm.plugin.finder.view.b bVar2 = this.tPE;
            if (bVar2 != null) {
                bVar2.alive();
            }
        }
        bVar.tLS.getRecyclerView().post(new c(this));
        this.vQm.alive();
        AppMethodBeat.o(252834);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ k vQn;

        c(k kVar) {
            this.vQn = kVar;
        }

        public final void run() {
            AppMethodBeat.i(252831);
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.Kl(this.vQn.dLS);
            AppMethodBeat.o(252831);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.j.a, com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(252835);
        super.onDetach();
        com.tencent.mm.plugin.finder.view.b bVar = this.tPE;
        if (bVar != null) {
            bVar.dead();
        }
        this.vQm.dead();
        AppMethodBeat.o(252835);
    }

    @Override // com.tencent.mm.plugin.finder.feed.b.a
    public final void dcd() {
        AppMethodBeat.i(252836);
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        int i2 = this.dLS;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.report.h.a(hVar, i2, false, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), 8);
        AppMethodBeat.o(252836);
    }

    @Override // com.tencent.mm.plugin.finder.feed.b.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        bo boVar;
        DataBuffer dataListJustForAdapter;
        b.AbstractC1134b bVar;
        RecyclerView recyclerView;
        int i2 = 0;
        AppMethodBeat.i(252837);
        p.h(cVar, "reason");
        com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, this.dLS, false, null, 12);
        if (cVar.Rml && cVar.Rmj && (bVar = this.tLN) != null && (recyclerView = bVar.tLS.getRecyclerView()) != null) {
            y yVar = y.vXH;
            int i3 = this.dLS;
            b.AbstractC1134b bVar2 = this.tLN;
            if (bVar2 != null) {
                i2 = bVar2.tCE;
            }
            if (y.gr(i3, i2)) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
                    AppMethodBeat.o(252837);
                    throw tVar;
                }
                int ks = ((FinderLinearLayoutManager) layoutManager).ks() + 1;
                Log.i(this.TAG, "[smoothScrollToNextPosition] nextPosition=".concat(String.valueOf(ks)));
                recyclerView.post(new d(recyclerView, ks));
            }
        }
        if (cVar.Rmj) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderFullFeedGuideUIC finderFullFeedGuideUIC = (FinderFullFeedGuideUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFullFeedGuideUIC.class);
            b.AbstractC1134b bVar3 = this.tLN;
            finderFullFeedGuideUIC.setRecyclerView(bVar3 != null ? bVar3.tLS.getRecyclerView() : null);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) {
                boVar = null;
            } else {
                boVar = (bo) kotlin.a.j.L(dataListJustForAdapter, 1);
            }
            finderFullFeedGuideUIC.e(boVar);
            finderFullFeedGuideUIC.dIc();
        }
        AppMethodBeat.o(252837);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ int tQg;

        d(RecyclerView recyclerView, int i2) {
            this.tDJ = recyclerView;
            this.tQg = i2;
        }

        public final void run() {
            AppMethodBeat.i(252832);
            RecyclerView recyclerView = this.tDJ;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.tQg, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/ui/ShareRelPresenter$smoothScrollToNextPosition$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(252832);
        }
    }

    public final boolean dAp() {
        FinderLikeDrawer dcj;
        FinderLikeDrawer dcn;
        TouchMediaPreviewLayout touchMediaPreviewLayout;
        com.tencent.mm.plugin.finder.view.e dcm;
        AppMethodBeat.i(252838);
        b.AbstractC1134b bVar = this.tLN;
        if (bVar == null || (dcm = bVar.dcm()) == null || !dcm.dGs()) {
            b.AbstractC1134b bVar2 = this.tLN;
            if (bVar2 == null || (touchMediaPreviewLayout = bVar2.tLW) == null || !touchMediaPreviewLayout.QFs) {
                b.AbstractC1134b bVar3 = this.tLN;
                if (bVar3 == null || (dcn = bVar3.dcn()) == null || !dcn.dGs()) {
                    b.AbstractC1134b bVar4 = this.tLN;
                    if (bVar4 == null || (dcj = bVar4.dcj()) == null || !dcj.dGs()) {
                        AppMethodBeat.o(252838);
                        return false;
                    }
                    dcj.dGr();
                    AppMethodBeat.o(252838);
                    return true;
                }
                dcn.dGr();
                AppMethodBeat.o(252838);
                return true;
            }
            touchMediaPreviewLayout.gZk();
            AppMethodBeat.o(252838);
            return true;
        }
        dcm.dGr();
        AppMethodBeat.o(252838);
        return true;
    }

    public static final /* synthetic */ void d(h hVar, boolean z) {
        FinderFeedExposeLayout finderFeedExposeLayout;
        AppMethodBeat.i(252841);
        if (z && (finderFeedExposeLayout = (FinderFeedExposeLayout) hVar.Mn(R.id.b92)) != null) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!com.tencent.mm.plugin.finder.storage.c.drv()) {
                Log.i("Finder.FeedConvert", "hit EXPOSE_COMMENT_SHOW close");
                finderFeedExposeLayout.getCommentsLayout().setVisibility(8);
            }
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!com.tencent.mm.plugin.finder.storage.c.drw()) {
                Log.i("Finder.FeedConvert", "hit EXPOSE_COMMENTBTN_SHOW close");
                finderFeedExposeLayout.getSeeAllCommentsTv().setVisibility(8);
            }
        }
        AppMethodBeat.o(252841);
    }
}
