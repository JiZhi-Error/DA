package com.tencent.mm.plugin.finder.conv;

import android.view.View;
import android.widget.ImageView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "finderConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getFinderConversation", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "setFinderConversation", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "fixedConversationList", "", "getFixedConversationList", "()Ljava/util/List;", "setFixedConversationList", "(Ljava/util/List;)V", "isOneFixed", "", "getConversation", FirebaseAnalytics.b.INDEX, "", "getDelta", "getFixedConversation", "getItem", "position", "getItemCount", "notifyConvItemChanged", "", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "plugin-finder_release"})
public final class g extends d {
    private final String TAG = "ConversationFirstFixAdapter";
    private final boolean tyH = true;
    public c tyI;
    private List<c> tyJ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // com.tencent.mm.plugin.finder.conv.d, android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(242733);
        a(aVar, i2);
        AppMethodBeat.o(242733);
    }

    @Override // com.tencent.mm.plugin.finder.conv.d, android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(242730);
        int itemCount = super.getItemCount() + cZx();
        AppMethodBeat.o(242730);
        return itemCount;
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final c Io(int i2) {
        c cVar;
        AppMethodBeat.i(242731);
        if (i2 < 0 || i2 >= cZx()) {
            cVar = super.Io(i2 - cZx());
        } else if (this.tyH) {
            cVar = this.tyI;
            if (cVar == null) {
                c cVar2 = new c();
                AppMethodBeat.o(242731);
                return cVar2;
            }
        } else {
            c Iq = Iq(i2);
            AppMethodBeat.o(242731);
            return Iq;
        }
        AppMethodBeat.o(242731);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final void a(a aVar, int i2) {
        AppMethodBeat.i(242732);
        p.h(aVar, "holder");
        super.a(aVar, i2);
        if (i2 == 0) {
            View view = aVar.aus;
            p.g(view, "holder.itemView");
            ((ImageView) view.findViewById(R.id.wo)).setImageResource(R.drawable.a2c);
        }
        AppMethodBeat.o(242732);
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final void Il(int i2) {
        AppMethodBeat.i(242734);
        super.Il(cZx() + i2);
        AppMethodBeat.o(242734);
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final void Im(int i2) {
        AppMethodBeat.i(242735);
        if (i2 >= 0) {
            super.Im(cZx() + i2);
            AppMethodBeat.o(242735);
            return;
        }
        super.Im(1);
        AppMethodBeat.o(242735);
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final void fY(int i2, int i3) {
        AppMethodBeat.i(242736);
        super.fY(cZx() + i2, i3);
        AppMethodBeat.o(242736);
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final void In(int i2) {
        AppMethodBeat.i(242737);
        super.In(cZx() + i2);
        AppMethodBeat.o(242737);
    }

    @Override // com.tencent.mm.plugin.finder.conv.d
    public final void fZ(int i2, int i3) {
        AppMethodBeat.i(242738);
        super.fZ(cZx() + i2, i3);
        AppMethodBeat.o(242738);
    }

    public final c Ip(int i2) {
        AppMethodBeat.i(242739);
        if (i2 < 0 || i2 >= cZx()) {
            c cVar = this.ppH.get(i2 - cZx());
            AppMethodBeat.o(242739);
            return cVar;
        } else if (this.tyH) {
            c cVar2 = this.tyI;
            AppMethodBeat.o(242739);
            return cVar2;
        } else {
            c Iq = Iq(i2);
            AppMethodBeat.o(242739);
            return Iq;
        }
    }

    private final int cZx() {
        AppMethodBeat.i(242740);
        List<c> list = this.tyJ;
        if (list != null) {
            int size = list.size();
            AppMethodBeat.o(242740);
            return size;
        }
        AppMethodBeat.o(242740);
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tencent.mm.plugin.finder.conv.c Iq(int r4) {
        /*
            r3 = this;
            r2 = 242741(0x3b435, float:3.40153E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            java.util.List<com.tencent.mm.plugin.finder.conv.c> r0 = r3.tyJ
            if (r0 == 0) goto L_0x001f
            if (r4 < 0) goto L_0x0028
            int r1 = r0.size()
            if (r4 >= r1) goto L_0x0028
            r1 = 1
        L_0x0013:
            if (r1 == 0) goto L_0x002a
        L_0x0015:
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = r0.get(r4)
            com.tencent.mm.plugin.finder.conv.c r0 = (com.tencent.mm.plugin.finder.conv.c) r0
            if (r0 != 0) goto L_0x0024
        L_0x001f:
            com.tencent.mm.plugin.finder.conv.c r0 = new com.tencent.mm.plugin.finder.conv.c
            r0.<init>()
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return r0
        L_0x0028:
            r1 = 0
            goto L_0x0013
        L_0x002a:
            r0 = 0
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.conv.g.Iq(int):com.tencent.mm.plugin.finder.conv.c");
    }
}
