package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.FinderConversationUI;
import com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "onHelloClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "", "(Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;Lkotlin/jvm/functions/Function1;)V", "onItemClick", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Companion", "plugin-finder_release"})
public final class e implements d.a {
    public static final a tyB = new a((byte) 0);
    private final kotlin.g.a.b<b, x> tyA;
    private final ReadyChattingCompatUI tyz;

    static {
        AppMethodBeat.i(242727);
        AppMethodBeat.o(242727);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super com.tencent.mm.plugin.finder.conv.b, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(ReadyChattingCompatUI readyChattingCompatUI, kotlin.g.a.b<? super b, x> bVar) {
        p.h(readyChattingCompatUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242726);
        this.tyz = readyChattingCompatUI;
        this.tyA = bVar;
        AppMethodBeat.o(242726);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener$Companion;", "", "()V", "FINDER_SYSTEM_MESSAGE", "", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.conv.d.a
    public final void a(View view, c cVar) {
        String aUg;
        AppMethodBeat.i(242725);
        p.h(view, "view");
        p.h(cVar, "conv");
        view.setSelected(true);
        if (p.j(cVar.field_sessionId, "findersayhisessionholder")) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = view.getContext();
            p.g(context, "view.context");
            com.tencent.mm.plugin.finder.utils.a.fC(context);
            kotlin.g.a.b<b, x> bVar = this.tyA;
            if (bVar != null) {
                bVar.invoke(new b(view, cVar));
            }
            com.tencent.mm.plugin.finder.storage.e conversationStorage = ((PluginFinder) g.ah(PluginFinder.class)).getConversationStorage();
            String str = cVar.field_sessionId;
            p.g(str, "conv.field_sessionId");
            conversationStorage.avs(str);
            com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
            String str2 = cVar.field_sessionId;
            p.g(str2, "conv.field_sessionId");
            com.tencent.mm.plugin.finder.report.d.auB(str2);
            com.tencent.mm.plugin.finder.report.d dVar2 = com.tencent.mm.plugin.finder.report.d.vdp;
            d.a aVar2 = com.tencent.mm.plugin.finder.report.d.dnF().viN;
            com.tencent.mm.plugin.finder.report.d dVar3 = com.tencent.mm.plugin.finder.report.d.vdp;
            com.tencent.mm.plugin.finder.report.d.dnG().R(aVar2.vdq, 1);
            com.tencent.mm.plugin.finder.report.d dVar4 = com.tencent.mm.plugin.finder.report.d.vdp;
            d.c dnI = com.tencent.mm.plugin.finder.report.d.dnI();
            long j2 = aVar2.vdq;
            dnI.vdw = String.valueOf(cl.aWA());
            dnI.vdx = j2;
            AppMethodBeat.o(242725);
            return;
        }
        if (p.j(cVar.field_sessionId, "finder_system_message")) {
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
            k kVar = k.vfA;
            k.ai(i2, 2);
            kotlin.g.a.b<b, x> bVar2 = this.tyA;
            if (bVar2 != null) {
                bVar2.invoke(new b(view, cVar));
            }
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fy(this.tyz);
            if (i2 > 0) {
                k kVar2 = k.vfA;
                FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tyz);
                k.a("11", 4, 2, 5, 0, i2, (String) null, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3520);
                AppMethodBeat.o(242725);
                return;
            }
        } else {
            com.tencent.mm.j.a aVar5 = this.tyz.vQb;
            if (aVar5 != null) {
                String str3 = cVar.field_sessionId;
                if (as.bjt(cVar.field_talker)) {
                    aUg = z.aTY();
                } else {
                    aUg = z.aUg();
                }
                aVar5.a(str3, aUg, new b(this, cVar, view));
            }
            com.tencent.mm.plugin.finder.report.d dVar5 = com.tencent.mm.plugin.finder.report.d.vdp;
            String str4 = cVar.field_sessionId;
            p.g(str4, "conv.field_sessionId");
            com.tencent.mm.plugin.finder.report.d.auB(str4);
            com.tencent.mm.plugin.finder.report.d dVar6 = com.tencent.mm.plugin.finder.report.d.vdp;
            com.tencent.mm.plugin.finder.report.d.dnJ().vdE = (long) cVar.field_unReadCount;
        }
        AppMethodBeat.o(242725);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/conv/FinderConversationClickListener$onItemClick$1", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-finder_release"})
    public static final class b implements a.b {
        final /* synthetic */ View hCI;
        final /* synthetic */ e tyC;
        final /* synthetic */ c tyD;

        b(e eVar, c cVar, View view) {
            this.tyC = eVar;
            this.tyD = cVar;
            this.hCI = view;
        }

        @Override // com.tencent.mm.j.a.b
        public final void anx() {
            AppMethodBeat.i(242723);
            Log.i("Finder.ConversationOnClickListener", "onChattingUIEnter");
            m mVar = (m) g.af(m.class);
            as asVar = this.tyD.contact;
            mVar.a(asVar != null ? asVar.getUsername() : null, Boolean.TRUE);
            AppMethodBeat.o(242723);
        }

        @Override // com.tencent.mm.j.a.b
        public final boolean any() {
            FinderConversationUI finderConversationUI;
            al alVar;
            AppMethodBeat.i(242724);
            Log.i("Finder.ConversationOnClickListener", "onChattingUIExit");
            com.tencent.mm.ac.d.a(0, new b(this.hCI, this.tyD));
            if ((this.tyC.tyz instanceof FinderConversationUI) && (alVar = (finderConversationUI = (FinderConversationUI) this.tyC.tyz).vHY) != null && alVar.doZ()) {
                finderConversationUI.dzc();
            }
            AppMethodBeat.o(242724);
            return false;
        }
    }
}
