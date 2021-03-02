package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.ah;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class k {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000b\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u000fH\u0002J\u001c\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0,H\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001eH\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0003H\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\u000e\u00106\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
    public static class a extends b.a {
        private final boolean dJM;
        public ArrayList<bo> feedList;
        private final int scene;
        public final boolean tAj;
        private final c tNW;
        Dialog tipDialog;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private a(int i2, MMActivity mMActivity, boolean z, boolean z2) {
            super(mMActivity);
            p.h(mMActivity, "context");
            AppMethodBeat.i(243814);
            this.scene = i2;
            this.tAj = z;
            this.dJM = z2;
            this.feedList = new ArrayList<>();
            this.tNW = new c(this);
            AppMethodBeat.o(243814);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(int i2, MMActivity mMActivity, boolean z, boolean z2, int i3) {
            this(i2, mMActivity, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2);
            AppMethodBeat.i(243815);
            AppMethodBeat.o(243815);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public /* synthetic */ void onAttach(b.AbstractC1134b bVar) {
            AppMethodBeat.i(165715);
            a(bVar);
            AppMethodBeat.o(165715);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class d implements Runnable {
            final /* synthetic */ a tNX;

            public d(a aVar) {
                this.tNX = aVar;
            }

            public final void run() {
                com.tencent.mm.plugin.finder.event.base.c a2;
                AppMethodBeat.i(165707);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tNX.gte);
                if (fH == null || (a2 = FinderReporterUIC.a(fH)) == null) {
                    AppMethodBeat.o(165707);
                    return;
                }
                new ah(a2).doW().KC(0);
                AppMethodBeat.o(165707);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.feed.i
        public final boolean dbZ() {
            return this.dJM;
        }

        public final bo dcJ() {
            AppMethodBeat.i(243809);
            if (Util.isNullOrNil(this.feedList)) {
                AppMethodBeat.o(243809);
                return null;
            }
            bo boVar = this.feedList.get(0);
            AppMethodBeat.o(243809);
            return boVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.ab.a
        public final int l(BaseFinderFeed baseFinderFeed) {
            AppMethodBeat.i(165710);
            p.h(baseFinderFeed, "feed");
            long lT = baseFinderFeed.lT();
            bo dcJ = dcJ();
            if (dcJ == null || lT != dcJ.lT()) {
                AppMethodBeat.o(165710);
                return -1;
            }
            AppMethodBeat.o(165710);
            return 0;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final DataBuffer<bo> dcc() {
            AppMethodBeat.i(243810);
            bo dcJ = dcJ();
            if (dcJ != null) {
                DataBuffer<bo> dataBuffer = new DataBuffer<>(dcJ, null, 2, null);
                AppMethodBeat.o(243810);
                return dataBuffer;
            }
            DataBuffer<bo> dataBuffer2 = new DataBuffer<>(null, 1, null);
            AppMethodBeat.o(243810);
            return dataBuffer2;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final bo IE(int i2) {
            AppMethodBeat.i(243811);
            bo dcJ = dcJ();
            AppMethodBeat.o(243811);
            return dcJ;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.k$a$a  reason: collision with other inner class name */
        public static final class C1150a implements f {
            final /* synthetic */ a tNX;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1150a(a aVar) {
                this.tNX = aVar;
            }

            @Override // com.tencent.mm.view.recyclerview.f
            public final e<?> EC(int i2) {
                AppMethodBeat.i(165706);
                switch (i2) {
                    case 2:
                    case 3001:
                        y yVar = y.vXH;
                        if (y.isOtherEnableFullScreenEnjoy()) {
                            q qVar = new q(this.tNX, this.tNX.tAj, 0, 4);
                            AppMethodBeat.o(165706);
                            return qVar;
                        }
                        u uVar = new u(this.tNX, this.tNX.tAj, 0, 4);
                        AppMethodBeat.o(165706);
                        return uVar;
                    case 4:
                    case 3002:
                        y yVar2 = y.vXH;
                        if (y.isOtherEnableFullScreenEnjoy()) {
                            t tVar = new t(this.tNX.tCD, this.tNX, this.tNX.tAj, 0, 8);
                            AppMethodBeat.o(165706);
                            return tVar;
                        }
                        ak akVar = new ak(this.tNX.tCD, this.tNX, this.tNX.tAj, 0, 8);
                        AppMethodBeat.o(165706);
                        return akVar;
                    default:
                        y yVar3 = y.vXH;
                        y.dQ(this.tNX.getTAG(), i2);
                        com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                        AppMethodBeat.o(165706);
                        return fVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public f dce() {
            AppMethodBeat.i(165713);
            C1150a aVar = new C1150a(this);
            AppMethodBeat.o(165713);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.ab.a
        public final ArrayList<bo> dcH() {
            return this.feedList;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(b.AbstractC1134b bVar) {
            AppMethodBeat.i(165714);
            p.h(bVar, "callback");
            super.onAttach(bVar);
            this.tNW.alive();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(bVar.tLS.getRecyclerView());
            AppMethodBeat.o(165714);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            AppMethodBeat.i(165716);
            super.onDetach();
            this.tNW.dead();
            AppMethodBeat.o(165716);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
        public static final class c extends IListener<hn> {
            final /* synthetic */ a tNX;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(a aVar) {
                this.tNX = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(hn hnVar) {
                AppMethodBeat.i(243808);
                hn hnVar2 = hnVar;
                p.h(hnVar2, "event");
                com.tencent.mm.ac.d.a(0, new C1152a(this, hnVar2));
                AppMethodBeat.o(243808);
                return true;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.k$a$c$a  reason: collision with other inner class name */
            static final class C1152a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                final /* synthetic */ hn $event;
                final /* synthetic */ c tOb;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1152a(c cVar, hn hnVar) {
                    super(0);
                    this.tOb = cVar;
                    this.$event = hnVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    WxRecyclerAdapter<?> adapter;
                    WxRecyclerAdapter<?> adapter2;
                    WxRecyclerAdapter<?> adapter3;
                    AppMethodBeat.i(243807);
                    Log.i(this.tOb.tNX.getTAG(), "feedChangeListener " + this.$event.dLW.id);
                    if (this.tOb.tNX.feedList.size() > 0 && this.tOb.tNX.feedList.get(0).lT() == this.$event.dLW.id && this.$event.dLW.id != 0) {
                        switch (this.$event.dLW.type) {
                            case 0:
                                b.AbstractC1134b bVar = this.tOb.tNX.tLN;
                                if (!(bVar == null || (adapter3 = bVar.getAdapter()) == null)) {
                                    adapter3.e(0, 1, 1);
                                    break;
                                }
                            case 4:
                                b.AbstractC1134b bVar2 = this.tOb.tNX.tLN;
                                if (!(bVar2 == null || (adapter2 = bVar2.getAdapter()) == null)) {
                                    adapter2.e(0, 1, new o(3, 1));
                                    break;
                                }
                            case 5:
                                b.AbstractC1134b bVar3 = this.tOb.tNX.tLN;
                                if (!(bVar3 == null || (adapter = bVar3.getAdapter()) == null)) {
                                    adapter.e(0, 1, new o(4, 1));
                                    break;
                                }
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(243807);
                    return xVar;
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, m mVar) {
            AppMethodBeat.i(243812);
            p.h(baseFinderFeed, "feed");
            p.h(mVar, "menu");
            super.a(baseFinderFeed, mVar);
            if (this.dJM) {
                mVar.aS(this.tLI, R.string.tf, R.raw.icons_outlined_delete);
                if (baseFinderFeed.feedObject.isCommentClose()) {
                    mVar.b(this.tLH, this.gte.getString(R.string.cnl), R.raw.icons_outlined_comment);
                    AppMethodBeat.o(243812);
                    return;
                }
                mVar.b(this.tLG, this.gte.getString(R.string.cmn), R.raw.finder_feed_discomment);
            }
            AppMethodBeat.o(243812);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, MenuItem menuItem, int i2) {
            boolean z;
            AppMethodBeat.i(243813);
            p.h(baseFinderFeed, "feed");
            p.h(menuItem, "menuItem");
            super.a(baseFinderFeed, menuItem, i2);
            if (menuItem.getItemId() == this.tLI) {
                if (!baseFinderFeed.feedObject.getLongVideoMediaList().isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                h.a(this.gte, z ? R.string.cjq : R.string.d6h, 0, new b(this, baseFinderFeed), (DialogInterface.OnClickListener) null);
            }
            AppMethodBeat.o(243813);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        static final class b implements DialogInterface.OnClickListener {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ a tNX;

            b(a aVar, BaseFinderFeed baseFinderFeed) {
                this.tNX = aVar;
                this.tEM = baseFinderFeed;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(243806);
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                final av avVar = new av(aUg, this.tEM.feedObject.getFeedObject());
                Dialog dialog = this.tNX.tipDialog;
                if (dialog != null) {
                    dialog.show();
                } else {
                    a aVar = this.tNX;
                    aVar.gte.getString(R.string.zb);
                    aVar.tipDialog = h.a((Context) aVar.gte, aVar.gte.getString(R.string.a06), false, (DialogInterface.OnCancelListener) DialogInterface$OnCancelListenerC1151a.tNY);
                }
                g.azz().a(avVar.getType(), new i(this) {
                    /* class com.tencent.mm.plugin.finder.feed.k.a.b.AnonymousClass1 */
                    final /* synthetic */ b tNZ;

                    {
                        this.tNZ = r1;
                    }

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(243805);
                        if ((qVar instanceof av) && ((av) qVar).hFK == avVar.hFK) {
                            g.azz().b(avVar.getType(), this);
                        }
                        Dialog dialog = this.tNZ.tNX.tipDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        if (i2 == 0 && i3 == 0) {
                            this.tNZ.tNX.gte.finish();
                            AppMethodBeat.o(243805);
                            return;
                        }
                        com.tencent.mm.ui.base.u.makeText(this.tNZ.tNX.gte, (int) R.string.d6k, 0).show();
                        AppMethodBeat.o(243805);
                    }
                });
                g.azz().b(avVar);
                AppMethodBeat.o(243806);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.k$a$b$a  reason: collision with other inner class name */
            static final class DialogInterface$OnCancelListenerC1151a implements DialogInterface.OnCancelListener {
                public static final DialogInterface$OnCancelListenerC1151a tNY = new DialogInterface$OnCancelListenerC1151a();

                static {
                    AppMethodBeat.i(243804);
                    AppMethodBeat.o(243804);
                }

                DialogInterface$OnCancelListenerC1151a() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void dcb() {
            AppMethodBeat.i(165708);
            b.AbstractC1134b bVar = this.tLN;
            if (bVar != null) {
                bVar.ab(this.feedList);
                AppMethodBeat.o(165708);
                return;
            }
            AppMethodBeat.o(165708);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;IIZ)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "onLoadInitDataError", "", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
    public static class b extends b.AbstractC1134b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, a aVar, int i2, int i3, boolean z) {
            super(mMActivity, aVar, i2, i3, z);
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
            AppMethodBeat.i(165720);
            AppMethodBeat.o(165720);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(165719);
            com.tencent.mm.plugin.finder.view.decoration.b bVar = new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(c.a.a(this).getColor(R.color.f3043a)), 0);
            AppMethodBeat.o(165719);
            return bVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void dbY() {
            AppMethodBeat.i(165718);
            this.tLS.setEnableLoadMore(false);
            RecyclerView.a adapter = this.tLS.getRecyclerView().getAdapter();
            if (adapter != null) {
                adapter.getItemCount();
                AppMethodBeat.o(165718);
                return;
            }
            AppMethodBeat.o(165718);
        }
    }
}
