package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.g;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0012\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "attachRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isStatistic", "", "detachRecyclerView", "getData", FirebaseAnalytics.b.INDEX, "", "getId", "isSystemMsgExpose", "plugin-finder_release"})
public final class al extends ak<String, c> {
    private g viX;

    public al() {
        AppMethodBeat.i(250890);
        a<ID> aVar = new a<>();
        aVar.vcN = new a();
        this.viV = aVar;
        AppMethodBeat.o(250890);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/report/SystemMsgScrollListener$1$condition$1", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "", "filter", "", "id", "plugin-finder_release"})
    public static final class a implements ab<String> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.report.ab
        public final /* synthetic */ boolean dm(String str) {
            AppMethodBeat.i(250884);
            String str2 = str;
            p.h(str2, "id");
            boolean isEqual = Util.isEqual(str2, "finder_system_message");
            AppMethodBeat.o(250884);
            return isEqual;
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.ak
    public final void b(RecyclerView recyclerView, boolean z) {
        AppMethodBeat.i(250885);
        p.h(recyclerView, "recyclerView");
        super.b(recyclerView, z);
        if (recyclerView.getAdapter() instanceof g) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
                AppMethodBeat.o(250885);
                throw tVar;
            }
            this.viX = (g) adapter;
        }
        AppMethodBeat.o(250885);
    }

    @Override // com.tencent.mm.plugin.finder.report.ak
    public final void doY() {
        AppMethodBeat.i(250887);
        super.doY();
        this.viX = null;
        AppMethodBeat.o(250887);
    }

    private c KH(int i2) {
        AppMethodBeat.i(250889);
        g gVar = this.viX;
        if (gVar != null) {
            c Ip = gVar.Ip(i2);
            AppMethodBeat.o(250889);
            return Ip;
        }
        AppMethodBeat.o(250889);
        return null;
    }

    public final boolean doZ() {
        AppMethodBeat.i(250886);
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                this.tIy = j.mZ(0, ((LinearLayoutManager) layoutManager).ks());
                this.tIA = j.mZ(0, ((LinearLayoutManager) layoutManager).ku());
                int i2 = this.tIy;
                int i3 = this.tIA;
                if (i2 <= i3) {
                    while (true) {
                        c KH = KH(i2);
                        if (KH == null || !p.j(KH.field_sessionId, "finder_system_message")) {
                            if (i2 == i3) {
                                break;
                            }
                            i2++;
                        } else {
                            AppMethodBeat.o(250886);
                            return true;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(250886);
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.finder.report.ak
    public final /* synthetic */ String KG(int i2) {
        String str;
        AppMethodBeat.i(250888);
        c KH = KH(i2);
        if (KH == null || (str = KH.field_sessionId) == null) {
            str = "";
        }
        AppMethodBeat.o(250888);
        return str;
    }
}
