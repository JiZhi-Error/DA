package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0006\t\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contactChangeListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1;", "observer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1;", "timelineUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "getTimelineUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "timelineUIC$delegate", "Lkotlin/Lazy;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "doFetchRelatedFeed", "", "feedId", "", "maxUnreadCount", "", "source", "", "isPrefetch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderHotRelatedUIC extends UIComponent {
    private static boolean wxL = ((Boolean) com.tencent.mm.plugin.finder.storage.c.dtt().value()).booleanValue();
    public static final a wxM = new a((byte) 0);
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private final c wxI = new c(this);
    private final b wxJ = new b(this);
    final f wxK;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHotRelatedUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255702);
        this.wxK = g.ah(new d(fragment));
        AppMethodBeat.o(255702);
    }

    public static final /* synthetic */ void b(FinderHotRelatedUIC finderHotRelatedUIC, long j2, int i2, String str) {
        AppMethodBeat.i(255704);
        finderHotRelatedUIC.a(j2, i2, str, true);
        AppMethodBeat.o(255704);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$Companion;", "", "()V", "TAG", "", "isEnableAutoGetRelated", "", "()Z", "setEnableAutoGetRelated", "(Z)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(255703);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        AppMethodBeat.o(255703);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterId", "", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
    public static final class c extends com.tencent.mm.plugin.finder.event.base.d {
        final /* synthetic */ FinderHotRelatedUIC wxN;
        private long wxO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderHotRelatedUIC finderHotRelatedUIC) {
            this.wxN = finderHotRelatedUIC;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            boolean z;
            AppMethodBeat.i(255692);
            p.h(bVar, "event");
            if (bVar instanceof h) {
                a aVar = FinderHotRelatedUIC.wxM;
                if (!FinderHotRelatedUIC.wxL) {
                    AppMethodBeat.o(255692);
                    return;
                } else if (this.wxO != ((h) bVar).tIC) {
                    this.wxN.hAk.removeCallbacksAndMessages(null);
                    FeedData feedData = ((h) bVar).tIF;
                    if (feedData != null && feedData.getMediaType() == 2) {
                        com.tencent.mm.plugin.finder.storage.data.h hVar = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                        FinderItem.b FI = com.tencent.mm.plugin.finder.storage.data.h.FI(((h) bVar).tIC);
                        if (FI != null) {
                            if (FI.vDQ > 0 && FI.vDQ < FI.vDO) {
                                this.wxN.hAk.postDelayed(new a(FI, this, bVar), ((long) FI.vDQ) * 1000);
                            }
                            if (FI.vDO > 0) {
                                this.wxN.hAk.postDelayed(new b(FI, this, bVar), ((long) FI.vDO) * 1000);
                            }
                        }
                    }
                    this.wxO = ((h) bVar).tIC;
                    AppMethodBeat.o(255692);
                    return;
                }
            } else if (bVar instanceof c.a) {
                a aVar2 = FinderHotRelatedUIC.wxM;
                if (!FinderHotRelatedUIC.wxL) {
                    AppMethodBeat.o(255692);
                    return;
                }
                switch (((c.a) bVar).type) {
                    case 3:
                        com.tencent.mm.plugin.finder.storage.data.h hVar2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                        FinderItem.b FI2 = com.tencent.mm.plugin.finder.storage.data.h.FI(((c.a) bVar).feedId);
                        if (FI2 != null) {
                            int i2 = (int) ((100.0f * ((float) ((c.a) bVar).offset)) / ((float) ((c.a) bVar).jcu));
                            if (FI2.vDQ <= 0 || ((c.a) bVar).offset < FI2.vDQ || FI2.vDQ >= FI2.vDO) {
                                int i3 = FI2.vDR;
                                if (1 <= i3 && i2 >= i3 && FI2.vDR < FI2.vDP) {
                                    FinderHotRelatedUIC.b(this.wxN, ((c.a) bVar).feedId, FI2.tXx, "VideoShowPercentage#" + FI2.vDR);
                                }
                            } else {
                                FinderHotRelatedUIC.b(this.wxN, ((c.a) bVar).feedId, FI2.tXx, "VideoShowTime#" + FI2.vDQ);
                            }
                            if (!n.e(FI2.vDS, "||")) {
                                if (FI2.vDS.length() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    if (n.e(FI2.vDS, "&&") && i2 >= FI2.vDP && ((c.a) bVar).offset >= FI2.vDO && FI2.vDP > 0 && FI2.vDO > 0) {
                                        FinderHotRelatedUIC.a(this.wxN, ((c.a) bVar).feedId, FI2.tXx, "VideoShowPercentage#" + FI2.vDP);
                                    }
                                    AppMethodBeat.o(255692);
                                    return;
                                }
                            }
                            int i4 = FI2.vDP;
                            if (1 <= i4 && i2 >= i4) {
                                FinderHotRelatedUIC.a(this.wxN, ((c.a) bVar).feedId, FI2.tXx, "VideoShowPercentage#" + FI2.vDP);
                                AppMethodBeat.o(255692);
                                return;
                            }
                            if (((c.a) bVar).offset >= FI2.vDO && FI2.vDO > 0) {
                                FinderHotRelatedUIC.a(this.wxN, ((c.a) bVar).feedId, FI2.tXx, "VideoShowTime#" + FI2.vDO);
                            }
                            AppMethodBeat.o(255692);
                            return;
                        }
                        AppMethodBeat.o(255692);
                        return;
                    default:
                        AppMethodBeat.o(255692);
                        return;
                }
            } else if (bVar instanceof a.C1104a) {
                int i5 = ((a.C1104a) bVar).type;
                a.C1104a.C1105a aVar3 = a.C1104a.tHJ;
                if (i5 == a.C1104a.tHq) {
                    com.tencent.mm.plugin.finder.storage.data.h hVar3 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                    FinderItem.b FI3 = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.C1104a) bVar).feedId);
                    if (FI3 != null) {
                        FinderHotRelatedUIC.a(this.wxN, ((a.C1104a) bVar).feedId, FI3.tXx, "SHARE_TO_SNS");
                        AppMethodBeat.o(255692);
                        return;
                    }
                    AppMethodBeat.o(255692);
                    return;
                }
                a.C1104a.C1105a aVar4 = a.C1104a.tHJ;
                if (i5 == a.C1104a.tHv) {
                    com.tencent.mm.plugin.finder.storage.data.h hVar4 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                    FinderItem.b FI4 = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.C1104a) bVar).feedId);
                    if (FI4 != null) {
                        FinderHotRelatedUIC.a(this.wxN, ((a.C1104a) bVar).feedId, FI4.tXx, "LIKE");
                        AppMethodBeat.o(255692);
                        return;
                    }
                    AppMethodBeat.o(255692);
                    return;
                }
                a.C1104a.C1105a aVar5 = a.C1104a.tHJ;
                if (i5 == a.C1104a.tHy) {
                    com.tencent.mm.plugin.finder.storage.data.h hVar5 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                    FinderItem.b FI5 = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.C1104a) bVar).feedId);
                    if (FI5 != null) {
                        FinderHotRelatedUIC.a(this.wxN, ((a.C1104a) bVar).feedId, FI5.tXx, "FAV");
                        AppMethodBeat.o(255692);
                        return;
                    }
                    AppMethodBeat.o(255692);
                    return;
                }
                a.C1104a.C1105a aVar6 = a.C1104a.tHJ;
                if (i5 == a.C1104a.tHp) {
                    com.tencent.mm.plugin.finder.storage.data.h hVar6 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                    FinderItem.b FI6 = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.C1104a) bVar).feedId);
                    if (FI6 != null) {
                        FinderHotRelatedUIC.a(this.wxN, ((a.C1104a) bVar).feedId, FI6.tXx, "SHARE_TO_CHAT");
                        AppMethodBeat.o(255692);
                        return;
                    }
                }
            }
            AppMethodBeat.o(255692);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ com.tencent.mm.plugin.finder.event.base.b tIc;
            final /* synthetic */ FinderItem.b wxP;
            final /* synthetic */ c wxQ;

            a(FinderItem.b bVar, c cVar, com.tencent.mm.plugin.finder.event.base.b bVar2) {
                this.wxP = bVar;
                this.wxQ = cVar;
                this.tIc = bVar2;
            }

            public final void run() {
                AppMethodBeat.i(255690);
                FinderHotRelatedUIC.b(this.wxQ.wxN, ((h) this.tIc).tIC, this.wxP.tXx, "PhotoShowTime#" + this.wxP.vDO);
                AppMethodBeat.o(255690);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$2"})
        static final class b implements Runnable {
            final /* synthetic */ com.tencent.mm.plugin.finder.event.base.b tIc;
            final /* synthetic */ FinderItem.b wxP;
            final /* synthetic */ c wxQ;

            b(FinderItem.b bVar, c cVar, com.tencent.mm.plugin.finder.event.base.b bVar2) {
                this.wxP = bVar;
                this.wxQ = cVar;
                this.tIc = bVar2;
            }

            public final void run() {
                AppMethodBeat.i(255691);
                FinderHotRelatedUIC.a(this.wxQ.wxN, ((h) this.tIc).tIC, this.wxP.tXx, "PhotoShowTime#" + this.wxP.vDO);
                AppMethodBeat.o(255691);
            }
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<hf> {
        final /* synthetic */ FinderHotRelatedUIC wxN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderHotRelatedUIC finderHotRelatedUIC) {
            this.wxN = finderHotRelatedUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hf hfVar) {
            int i2;
            BaseFinderFeed baseFinderFeed = null;
            AppMethodBeat.i(255689);
            hf hfVar2 = hfVar;
            p.h(hfVar2, "event");
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            if (c.a.asJ(hfVar2.dLI.username)) {
                FinderTimelineUIC finderTimelineUIC = (FinderTimelineUIC) this.wxN.wxK.getValue();
                String str = hfVar2.dLI.username;
                p.g(str, "event.data.username");
                p.h(str, ch.COL_USERNAME);
                ai.b bVar = finderTimelineUIC.tRV;
                if (bVar == null) {
                    p.btv("viewCallback");
                }
                RecyclerView.LayoutManager layoutManager = bVar.getRecyclerView().getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int ks = linearLayoutManager != null ? linearLayoutManager.ks() : 0;
                if (linearLayoutManager != null) {
                    i2 = linearLayoutManager.ku();
                } else {
                    i2 = 0;
                }
                if (ks <= i2) {
                    int i3 = ks;
                    while (true) {
                        ai.b bVar2 = finderTimelineUIC.tRV;
                        if (bVar2 == null) {
                            p.btv("viewCallback");
                        }
                        RecyclerView.v ch = bVar2.getRecyclerView().ch(i3);
                        if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
                            ch = null;
                        }
                        com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
                        if (hVar instanceof com.tencent.mm.view.recyclerview.h) {
                            Object hgv = hVar.hgv();
                            if ((hgv instanceof BaseFinderFeed) && p.j(((BaseFinderFeed) hgv).feedObject.getUserName(), str)) {
                                baseFinderFeed = (BaseFinderFeed) hgv;
                                break;
                            }
                        }
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                if (baseFinderFeed != null) {
                    com.tencent.mm.plugin.finder.storage.data.h hVar2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
                    FinderItem.b FI = com.tencent.mm.plugin.finder.storage.data.h.FI(baseFinderFeed.feedObject.getExpectId());
                    if (FI != null) {
                        FinderHotRelatedUIC.a(this.wxN, baseFinderFeed.feedObject.getId(), FI.tXx, "Follow#" + hfVar2.dLI.username);
                    }
                }
            }
            AppMethodBeat.o(255689);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255694);
        super.onCreate(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MF = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).MF(4);
        if (MF == null) {
            Log.e("Finder.HotRelatedUIC", "[onCreate] eventDispatcher is null");
        }
        if (MF != null) {
            MF.a(this.wxI);
            AppMethodBeat.o(255694);
            return;
        }
        AppMethodBeat.o(255694);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255695);
        super.onPause();
        this.hAk.removeCallbacksAndMessages(null);
        AppMethodBeat.o(255695);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255696);
        super.onResume();
        AppMethodBeat.o(255696);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(255697);
        super.onUserVisibleFocused();
        this.wxJ.alive();
        AppMethodBeat.o(255697);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
        AppMethodBeat.i(255698);
        super.onUserVisibleUnFocused();
        this.wxJ.dead();
        this.hAk.removeCallbacksAndMessages(null);
        AppMethodBeat.o(255698);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255699);
        super.onDestroy();
        this.wxJ.dead();
        this.hAk.removeCallbacksAndMessages(null);
        AppMethodBeat.o(255699);
    }

    static /* synthetic */ void a(FinderHotRelatedUIC finderHotRelatedUIC, long j2, int i2, String str) {
        AppMethodBeat.i(255701);
        finderHotRelatedUIC.a(j2, i2, str, false);
        AppMethodBeat.o(255701);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r15 = new com.tencent.mm.protocal.protobuf.atn();
        r2 = com.tencent.mm.ui.component.a.PRN;
        r2 = r14.getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r2 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        com.tencent.matrix.trace.core.AppMethodBeat.o(255700);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r2 = ((com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC) com.tencent.mm.ui.component.a.b((com.tencent.mm.ui.MMActivity) r2).get(com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.class)).MB(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        if (r2 == null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        r3 = com.tencent.mm.plugin.finder.report.o.vfN;
        r16 = com.tencent.mm.plugin.finder.report.o.vfM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r16 == null) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r3 = new com.tencent.mm.plugin.finder.report.p(r16.feedId, r16.startTime, r16.tHo, r16.tIw, r16.vgz, r16.vdR, null, 64);
        r3.uOV = r16.uOV;
        r3.vfP = r16.vfP;
        r3.endTime = r16.endTime;
        r3.vfQ = r16.vfQ;
        r3.vfR = r16.vfR;
        r3.vfS = r16.vfS;
        r3.vfT = r16.vfT;
        r3.vfU = r16.vfU;
        r3.vfV = r16.vfV;
        r3.vfW = r16.vfW;
        r3.vfX = r16.vfX;
        r3.vfY = r16.vfY;
        r3.msj = r16.msj;
        r3.vfZ = r16.vfZ;
        r3.vga = r16.vga;
        r3.vgb = r16.vgb;
        r3.vgc = r16.vgc;
        r3.vgd = r16.vgd;
        r3.vge = r16.vge;
        r3.vgf = r16.vgf;
        r3.vgg = r16.vgg;
        r3.vgh = r16.vgh;
        r3.vgj = r16.vgj;
        r3.vgk = r16.vgk;
        r3.vgl = r16.vgl;
        r3.vgm = r16.vgm;
        r3.vgn = r16.vgn;
        r3.vgo = r16.vgo;
        r3.vgp = r16.vgp;
        r3.dUy = r16.dUy;
        r3.vgq = r16.vgq;
        r3.vgr = r16.vgr;
        r3.vgs = r16.vgs;
        r3.vgt = r16.vgt;
        r3.vgu = r16.vgu;
        r3.vgv = r16.vgv;
        r3.vgw = r16.vgw;
        r3.netType = r16.netType;
        r3.videoDuration = r16.videoDuration;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x016d, code lost:
        if (r3 == null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x016f, code lost:
        r3.a(r2.vdR);
        r4 = com.tencent.mm.plugin.finder.report.p.vgC;
        r15.tVf = com.tencent.mm.plugin.finder.report.p.a.a(r3, r2.ttO);
        r2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        r2 = com.tencent.mm.plugin.finder.storage.data.h.FI(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0184, code lost:
        if (r2 == null) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0186, code lost:
        r2 = r2.lEd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0188, code lost:
        r15.LEo = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x018a, code lost:
        r2 = r15.tVf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x018c, code lost:
        if (r2 == null) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x018e, code lost:
        r3 = com.tencent.mm.plugin.finder.report.p.vgC;
        kotlin.g.b.p.g(r2, com.tencent.mm.sdk.platformtools.LocaleUtil.ITALIAN);
        com.tencent.mm.plugin.finder.report.p.a.a(r2, "Finder.HotRelatedUIC");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x019c, code lost:
        r2 = new java.lang.StringBuilder("[doFetchRelatedFeed] ").append(com.tencent.mm.ac.d.zs(r18)).append(" maxUnreadCount=").append(r20).append(" isPrefetch=").append(r22).append(" source=").append(r21).append(' ').append("config=");
        r4 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        r4 = r2.append(com.tencent.mm.plugin.finder.storage.data.h.FI(r18)).append(", stats=");
        r2 = r15.tVf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x01f6, code lost:
        if (r2 == null) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x01f8, code lost:
        r2 = java.lang.Long.valueOf(r2.hFK);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01fe, code lost:
        r4 = r4.append(r2).append(", pos_trigger_config=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x020b, code lost:
        if (r15.LEo == null) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x020d, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x020e, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("Finder.HotRelatedUIC", r4.append(r2).toString());
        r2 = com.tencent.mm.ui.component.a.PRN;
        ((com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC) com.tencent.mm.ui.component.a.of(r14).get(com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC.class)).a(r18, r20, r22, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0231, code lost:
        if (r22 != false) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0233, code lost:
        r2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        com.tencent.mm.plugin.finder.storage.data.h.FL(r18);
        com.tencent.matrix.trace.core.AppMethodBeat.o(255700);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x023f, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0242, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0245, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0247, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0249, code lost:
        r2 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        com.tencent.mm.plugin.finder.storage.data.h.FN(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        if (com.tencent.mm.plugin.finder.storage.data.h.FJ(r18) == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (com.tencent.mm.plugin.finder.storage.data.h.FJ(r18) != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(long r18, int r20, java.lang.String r21, boolean r22) {
        /*
        // Method dump skipped, instructions count: 604
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC.a(long, int, java.lang.String, boolean):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<FinderTimelineUIC> {
        final /* synthetic */ Fragment uRC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Fragment fragment) {
            super(0);
            this.uRC = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderTimelineUIC invoke() {
            AppMethodBeat.i(255693);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderTimelineUIC finderTimelineUIC = (FinderTimelineUIC) com.tencent.mm.ui.component.a.of(this.uRC).get(FinderTimelineUIC.class);
            AppMethodBeat.o(255693);
            return finderTimelineUIC;
        }
    }
}
