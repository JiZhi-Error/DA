package com.tencent.mm.plugin.gamelife.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;
import com.tencent.mm.plugin.gamelife.ui.f;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004<=>?B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\b\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001fH\u0016J\u000e\u0010,\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u0018\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001fH\u0016J\u0018\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001fH\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0002H\u0016J\u0006\u00104\u001a\u00020$J\u0014\u00105\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000707J\u000e\u00108\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u0018\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001fH\u0002J\u0014\u0010;\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000707R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "getDataList", "()Ljava/util/LinkedList;", "interactionMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "normalViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "value", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClickListener", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "serviceMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "viewProvider", "", "", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "dataPosToListPos", "dataPos", "deleteConversation", "", "conversation", "getDataListNum", "getItem", "pos", "getItemCount", "getItemViewType", "position", "insertOrUpdateConversation", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "refreshGameCenterMsg", "refreshList", "data", "", "replaceConversation", "reportConversationItemExpose", "item", "submitList", "Companion", "ConversationViewHolder", "OnItemClickListener", "OnItemLongClickListener", "plugin-gamelife_release"})
public final class b extends RecyclerView.a<C1424b> implements f.a {
    public static final a ycH = new a((byte) 0);
    final LinkedList<com.tencent.mm.plugin.gamelife.e.a> ppH = new LinkedList<>();
    final d ycB = new d(this);
    private final a ycC = new a(this);
    private final g ycD = new g(this);
    private final Map<Integer, f> ycE = ae.e(s.U(0, this.ycB), s.U(1, this.ycC), s.U(2, this.ycD));
    c ycF;
    d ycG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
    public interface c {
        void a(View view, com.tencent.mm.plugin.gamelife.e.a aVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "totalDataNum", "plugin-gamelife_release"})
    public interface d {
        void a(View view, int i2, com.tencent.mm.plugin.gamelife.e.a aVar, int i3);
    }

    static {
        AppMethodBeat.i(241453);
        AppMethodBeat.o(241453);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$Companion;", "", "()V", "EXTRA_VIEW_COUNT", "", "TAG", "", "VIEW_TYPE_INTERACTION_NOTIFY", "VIEW_TYPE_NORMAL", "VIEW_TYPE_SERVICE_NOTIFY", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(241452);
        AppMethodBeat.o(241452);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C1424b a(ViewGroup viewGroup, int i2) {
        C1424b bVar;
        AppMethodBeat.i(241442);
        p.h(viewGroup, "parent");
        f fVar = this.ycE.get(Integer.valueOf(i2));
        if (fVar != null) {
            bVar = fVar.y(viewGroup);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            p.hyc();
        }
        C1424b bVar2 = bVar;
        AppMethodBeat.o(241442);
        return bVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C1424b bVar, int i2) {
        x xVar;
        AppMethodBeat.i(241443);
        C1424b bVar2 = bVar;
        p.h(bVar2, "holder");
        f fVar = this.ycE.get(Integer.valueOf(getItemViewType(i2)));
        if (fVar != null) {
            fVar.a(bVar2, i2);
            xVar = x.SXb;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(241443);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void k(C1424b bVar) {
        AppMethodBeat.i(241449);
        C1424b bVar2 = bVar;
        p.h(bVar2, "holder");
        super.k(bVar2);
        com.tencent.mm.plugin.gamelife.e.a aVar = (com.tencent.mm.plugin.gamelife.e.a) bVar2.hgv();
        if (aVar != null) {
            int lR = bVar2.lR();
            if (!aVar.dXj()) {
                com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(aVar.field_selfUserName);
                if (aAR != null) {
                    c.a aVar2 = com.tencent.mm.game.report.c.hhl;
                    int i2 = (lR - 2) + 1;
                    int size = this.ppH.size();
                    String str = aVar.field_sessionId;
                    p.g(str, "item.field_sessionId");
                    long dWY = (long) aAR.dWY();
                    String str2 = aVar.field_selfUserName;
                    p.g(str2, "item.field_selfUserName");
                    com.tencent.mm.plugin.gamelife.d.a aVar3 = aVar.ybV;
                    if (aVar3 == null) {
                        p.hyc();
                    }
                    String str3 = aVar.field_talker;
                    p.g(str3, "item.field_talker");
                    long dXi = aVar.dXi();
                    com.tencent.mm.plugin.gamelife.i.a aVar4 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                    c.a.a(i2, 1, size, str, dWY, str2, (long) aVar3.field_accountType, str3, dXi, com.tencent.mm.plugin.gamelife.i.a.dXm());
                    AppMethodBeat.o(241449);
                    return;
                }
                AppMethodBeat.o(241449);
                return;
            }
            c.a aVar5 = com.tencent.mm.game.report.c.hhl;
            int size2 = this.ppH.size();
            String str4 = aVar.field_sessionId;
            p.g(str4, "item.field_sessionId");
            long dXi2 = aVar.dXi();
            com.tencent.mm.plugin.gamelife.i.a aVar6 = com.tencent.mm.plugin.gamelife.i.a.ycs;
            c.a.a((lR - 2) + 1, 1, size2, str4, 0, "", 0, "", dXi2, com.tencent.mm.plugin.gamelife.i.a.dXm());
            AppMethodBeat.o(241449);
            return;
        }
        AppMethodBeat.o(241449);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(241444);
        int size = this.ppH.size() + 2;
        AppMethodBeat.o(241444);
        return size;
    }

    public final void b(com.tencent.mm.plugin.gamelife.e.a aVar) {
        AppMethodBeat.i(241445);
        p.h(aVar, "conversation");
        com.tencent.mm.ac.d.h(new h(this, aVar));
        AppMethodBeat.o(241445);
    }

    public final void fe(List<com.tencent.mm.plugin.gamelife.e.a> list) {
        AppMethodBeat.i(241446);
        p.h(list, "data");
        com.tencent.mm.ac.d.h(new g(this, list));
        AppMethodBeat.o(241446);
    }

    public final void dR(List<com.tencent.mm.plugin.gamelife.e.a> list) {
        AppMethodBeat.i(241447);
        p.h(list, "data");
        com.tencent.mm.ac.d.h(new i(this, list));
        AppMethodBeat.o(241447);
    }

    public final void dXn() {
        AppMethodBeat.i(241448);
        this.ycC.refreshView();
        g gVar = this.ycD;
        C1424b bVar = gVar.ycy;
        if (bVar != null) {
            gVar.a(bVar, 0);
            AppMethodBeat.o(241448);
            return;
        }
        AppMethodBeat.o(241448);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.f.a
    public final com.tencent.mm.plugin.gamelife.e.a OD(int i2) {
        AppMethodBeat.i(241450);
        com.tencent.mm.plugin.gamelife.e.a aVar = this.ppH.get(i2 - 2);
        p.g(aVar, "dataList[pos - EXTRA_VIEW_COUNT]");
        com.tencent.mm.plugin.gamelife.e.a aVar2 = aVar;
        AppMethodBeat.o(241450);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.f.a
    public final int dXo() {
        AppMethodBeat.i(261727);
        int size = this.ppH.size();
        AppMethodBeat.o(261727);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-gamelife_release"})
    /* renamed from: com.tencent.mm.plugin.gamelife.ui.b$b  reason: collision with other inner class name */
    public static class C1424b extends com.tencent.mm.view.recyclerview.h {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1424b(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(241436);
            AppMethodBeat.o(241436);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ycI;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar, com.tencent.mm.plugin.gamelife.e.a aVar) {
            super(0);
            this.ycI = bVar;
            this.ycJ = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241438);
            int indexOf = this.ycI.ppH.indexOf(this.ycJ);
            if (indexOf >= 0) {
                this.ycI.ppH.remove(indexOf);
                this.ycI.ck(b.OE(indexOf));
            }
            this.ycI.ppH.add(0, this.ycJ);
            this.ycI.cj(b.OE(0));
            x xVar = x.SXb;
            AppMethodBeat.o(241438);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ycI;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar, com.tencent.mm.plugin.gamelife.e.a aVar) {
            super(0);
            this.ycI = bVar;
            this.ycJ = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241440);
            int indexOf = this.ycI.ppH.indexOf(this.ycJ);
            if (indexOf >= 0) {
                this.ycI.ppH.set(indexOf, this.ycJ);
                this.ycI.ci(b.OE(indexOf));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241440);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ycI;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, com.tencent.mm.plugin.gamelife.e.a aVar) {
            super(0);
            this.ycI = bVar;
            this.ycJ = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241437);
            int indexOf = this.ycI.ppH.indexOf(this.ycJ);
            if (indexOf >= 0) {
                this.ycI.ppH.remove(indexOf);
                this.ycI.ck(b.OE(indexOf));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241437);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ycI;
        final /* synthetic */ List ycK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar, List list) {
            super(0);
            this.ycI = bVar;
            this.ycK = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241439);
            int size = this.ycI.ppH.size();
            this.ycI.ppH.clear();
            this.ycI.at(b.OE(0), size);
            this.ycI.dR(this.ycK);
            x xVar = x.SXb;
            AppMethodBeat.o(241439);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b ycI;
        final /* synthetic */ List ycK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(b bVar, List list) {
            super(0);
            this.ycI = bVar;
            this.ycK = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241441);
            int itemCount = this.ycI.getItemCount();
            this.ycI.ppH.addAll(this.ycK);
            this.ycI.as(b.OE(itemCount), this.ycK.size());
            x xVar = x.SXb;
            AppMethodBeat.o(241441);
            return xVar;
        }
    }

    public static final /* synthetic */ int OE(int i2) {
        return i2 + 2;
    }
}
