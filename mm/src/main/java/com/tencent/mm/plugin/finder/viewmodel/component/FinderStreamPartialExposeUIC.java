package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J,\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC extends UIComponent implements i {
    private static final HashMap<Integer, Long> wAs = new HashMap<>();
    public static final a wAt = new a((byte) 0);
    private final f vPc = g.ah(new d(this));
    private final f vau = g.ah(new c(this));
    private int wAr = -1;

    private final RecyclerView getRecyclerView() {
        AppMethodBeat.i(255961);
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        AppMethodBeat.o(255961);
        return recyclerView;
    }

    private final int getTabType() {
        AppMethodBeat.i(255962);
        int intValue = ((Number) this.vPc.getValue()).intValue();
        AppMethodBeat.o(255962);
        return intValue;
    }

    public static final /* synthetic */ RecyclerView a(FinderStreamPartialExposeUIC finderStreamPartialExposeUIC) {
        AppMethodBeat.i(255969);
        RecyclerView recyclerView = finderStreamPartialExposeUIC.getRecyclerView();
        AppMethodBeat.o(255969);
        return recyclerView;
    }

    public static final /* synthetic */ int c(FinderStreamPartialExposeUIC finderStreamPartialExposeUIC) {
        AppMethodBeat.i(255970);
        int tabType = finderStreamPartialExposeUIC.getTabType();
        AppMethodBeat.o(255970);
        return tabType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderStreamPartialExposeUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255967);
        AppMethodBeat.o(255967);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static long MH(int i2) {
            AppMethodBeat.i(255956);
            Long l = (Long) FinderStreamPartialExposeUIC.wAs.remove(Integer.valueOf(i2));
            if (l != null) {
                long longValue = l.longValue();
                AppMethodBeat.o(255956);
                return longValue;
            }
            AppMethodBeat.o(255956);
            return 0;
        }
    }

    static {
        AppMethodBeat.i(255968);
        AppMethodBeat.o(255968);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255963);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3901, this);
        AppMethodBeat.o(255963);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255964);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3901, this);
        AppMethodBeat.o(255964);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(255965);
        super.onCreateAfter(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context = getRecyclerView().getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255965);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.event.base.c MF = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class)).MF(getTabType());
        if (MF != null) {
            MF.a(new b(this));
        }
        wAs.put(Integer.valueOf(getTabType()), 0L);
        AppMethodBeat.o(255965);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
    public static final class b extends com.tencent.mm.plugin.finder.event.base.d {
        final /* synthetic */ FinderStreamPartialExposeUIC wAu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderStreamPartialExposeUIC finderStreamPartialExposeUIC) {
            this.wAu = finderStreamPartialExposeUIC;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            int ku;
            AppMethodBeat.i(255957);
            p.h(bVar, "ev");
            if (bVar instanceof h) {
                RecyclerView.LayoutManager layoutManager = FinderStreamPartialExposeUIC.a(this.wAu).getLayoutManager();
                if ((layoutManager instanceof LinearLayoutManager) && (ku = ((LinearLayoutManager) layoutManager).ku()) > this.wAu.wAr) {
                    RecyclerView.v ch = FinderStreamPartialExposeUIC.a(this.wAu).ch(ku);
                    if (ch instanceof com.tencent.mm.view.recyclerview.h) {
                        Object hgv = ((com.tencent.mm.view.recyclerview.h) ch).hgv();
                        if (hgv instanceof BaseFinderFeed) {
                            long id = ((BaseFinderFeed) hgv).feedObject.getId();
                            if (((h) bVar).tIC != id) {
                                FinderStreamPartialExposeUIC.wAs.put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.wAu)), Long.valueOf(id));
                                Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.wAu) + " lastId=" + id + ' ' + ((h) bVar).tIC + " position=" + ku);
                                this.wAu.wAr = ku;
                            }
                        }
                    }
                }
                Long l = (Long) FinderStreamPartialExposeUIC.wAs.get(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.wAu)));
                long j2 = ((h) bVar).tIC;
                if (l == null) {
                    AppMethodBeat.o(255957);
                    return;
                } else if (l.longValue() == j2) {
                    FinderStreamPartialExposeUIC.wAs.put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.wAu)), 0L);
                    Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.wAu) + " reset");
                }
            }
            AppMethodBeat.o(255957);
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(255958);
            p.h(cVar, "dispatcher");
            p.h(bVar, "event");
            boolean z = bVar instanceof h;
            AppMethodBeat.o(255958);
            return z;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        s reqResp;
        AppMethodBeat.i(255966);
        if (i2 != 0 || i3 != 0 || qVar == null || (reqResp = qVar.getReqResp()) == null) {
            AppMethodBeat.o(255966);
            return;
        }
        reqResp.getReqObj();
        AppMethodBeat.o(255966);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderStreamPartialExposeUIC wAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderStreamPartialExposeUIC finderStreamPartialExposeUIC) {
            super(0);
            this.wAu = finderStreamPartialExposeUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(255959);
            View findViewById = this.wAu.getRootView().findViewById(R.id.h7t);
            if (findViewById == null) {
                p.hyc();
            }
            RecyclerView recyclerView = ((RefreshLoadMoreLayout) findViewById).getRecyclerView();
            AppMethodBeat.o(255959);
            return recyclerView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderStreamPartialExposeUIC wAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderStreamPartialExposeUIC finderStreamPartialExposeUIC) {
            super(0);
            this.wAu = finderStreamPartialExposeUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(255960);
            Fragment fragment = this.wAu.getFragment();
            if (fragment == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                AppMethodBeat.o(255960);
                throw tVar;
            }
            Integer valueOf = Integer.valueOf(((FinderHomeTabFragment) fragment).dLS);
            AppMethodBeat.o(255960);
            return valueOf;
        }
    }
}
