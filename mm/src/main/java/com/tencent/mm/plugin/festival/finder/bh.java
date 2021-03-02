package com.tencent.mm.plugin.festival.finder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.festival.b.e;
import com.tencent.mm.plugin.festival.model.g;
import com.tencent.mm.plugin.festival.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderShareInfoPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/model/FestivalWishConfigProvider$OnConfigUpdatedListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "infoQueue", "Ljava/util/LinkedList;", "", "onLineCntWording", "watchedCntWording", "canClearScreen", "", "genInfoQueue", "", "mount", "onConfigUpdated", "config", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishConfig;", "pollInfo", "unMount", "Companion", "plugin-festival_release"})
public final class bh extends p implements z.a {
    @Deprecated
    public static final a Uwf = new a((byte) 0);
    private final LinkedList<String> Uwc = new LinkedList<>();
    private String Uwd;
    private String Uwe;
    private final com.tencent.mm.live.c.b hOp;

    static {
        AppMethodBeat.i(262775);
        AppMethodBeat.o(262775);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderShareInfoPlugin$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bh(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262774);
        this.hOp = bVar;
        AppMethodBeat.o(262774);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.festival.model.z.a
    public final void a(e eVar) {
        AppMethodBeat.i(262771);
        p.h(eVar, "config");
        d.h(new b(this, eVar));
        AppMethodBeat.o(262771);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(262772);
        super.mount();
        z zVar = z.Uzb;
        z.a(this);
        AppMethodBeat.o(262772);
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262773);
        super.unMount();
        z zVar = z.Uzb;
        z.b(this);
        AppMethodBeat.o(262773);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bh Uwg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bh bhVar) {
            super(0);
            this.Uwg = bhVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262770);
            this.Uwg.Uwd = z.Uzb.hRC().UAN;
            this.Uwg.Uwe = z.Uzb.hRC().UAO;
            if (this.Uwg.Uwc.isEmpty()) {
                bh.b(this.Uwg);
            }
            TextView textView = (TextView) this.Uwg.hwr.findViewById(R.id.k2d);
            p.g(textView, "root.shareInfoTv");
            textView.setText((String) this.Uwg.Uwc.poll());
            x xVar = x.SXb;
            AppMethodBeat.o(262770);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(bh bhVar) {
        AppMethodBeat.i(262776);
        ArrayList arrayList = new ArrayList();
        String str = bhVar.Uwe;
        if (!(str == null || str.length() == 0)) {
            String str2 = bhVar.Uwe;
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(str2);
        } else if (bhVar.getLiveData().uDV > 0) {
            arrayList.add(bhVar.hwr.getContext().getString(R.string.j8j, String.valueOf(bhVar.getLiveData().uDV)));
        }
        String str3 = bhVar.Uwd;
        if (!(str3 == null || str3.length() == 0)) {
            String str4 = bhVar.Uwd;
            if (str4 == null) {
                str4 = "";
            }
            arrayList.add(str4);
        }
        g gVar = g.UxZ;
        com.tencent.mm.plugin.festival.b.g gWC = g.gWC();
        LinkedList<String> linkedList = gWC != null ? gWC.UAY : null;
        if (linkedList != null) {
            if (!linkedList.isEmpty()) {
                for (T t : linkedList) {
                    p.g(t, LocaleUtil.ITALIAN);
                    if (t.length() > 0) {
                        arrayList.add(t);
                    }
                }
            }
        }
        bhVar.Uwc.clear();
        bhVar.Uwc.addAll(arrayList);
        AppMethodBeat.o(262776);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bh Uwg;
        final /* synthetic */ e Uwh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bh bhVar, e eVar) {
            super(0);
            this.Uwg = bhVar;
            this.Uwh = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262769);
            this.Uwg.Uwd = this.Uwh.UAN;
            this.Uwg.Uwe = this.Uwh.UAO;
            x xVar = x.SXb;
            AppMethodBeat.o(262769);
            return xVar;
        }
    }
}
