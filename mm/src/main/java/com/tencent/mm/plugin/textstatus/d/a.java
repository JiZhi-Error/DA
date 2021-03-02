package com.tencent.mm.plugin.textstatus.d;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "showSameTopics", "", "getShowSameTopics", "()Z", "setShowSameTopics", "(Z)V", "vTopLine", "Landroid/view/View;", "getVTopLine", "()Landroid/view/View;", "setVTopLine", "(Landroid/view/View;)V", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "contentView", "onCoordinationViewClosing", "offset", "", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "update", ch.COL_USERNAME, "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Companion", "plugin-textstatus_release"})
public final class a extends b implements c {
    public static final C1816a Vds = new C1816a((byte) 0);
    private View FYc;
    private boolean Vdr;

    static {
        AppMethodBeat.i(258387);
        AppMethodBeat.o(258387);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(n nVar) {
        super(nVar);
        p.h(nVar, "showParam");
        AppMethodBeat.i(216133);
        AppMethodBeat.o(216133);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.d.a$a  reason: collision with other inner class name */
    public static final class C1816a {
        private C1816a() {
        }

        public /* synthetic */ C1816a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.d.d, com.tencent.mm.plugin.textstatus.d.b
    public final void ba(View view) {
        AppMethodBeat.i(216130);
        p.h(view, "contentView");
        super.ba(view);
        this.FYc = view.findViewById(R.id.j2b);
        AppMethodBeat.o(216130);
    }

    @Override // com.tencent.mm.plugin.textstatus.d.d, com.tencent.mm.plugin.textstatus.d.b
    public final boolean b(String str, com.tencent.mm.plugin.textstatus.f.f.a aVar) {
        AppMethodBeat.i(258384);
        p.h(str, ch.COL_USERNAME);
        boolean b2 = super.b(str, aVar);
        com.tencent.mm.plugin.textstatus.f.f.a aVar2 = this.FYx;
        z.d dVar = new z.d();
        dVar.SYE = 0;
        if (aVar2 != null) {
            String str2 = aVar2.field_TopicId;
            if (!(str2 == null || kotlin.n.n.aL(str2))) {
                f fVar = f.FXJ;
                dVar.SYE = f.fvM().m(aVar2.field_TopicId, j.ac(str)).size();
            }
            if (!this.FYA.abM(4) || dVar.SYE <= 0) {
                TextView textView = this.FYg;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = this.FYg;
                if (textView2 != null) {
                    com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
                    textView2.setText(com.tencent.mm.plugin.textstatus.j.b.a(aVar2.fvU()));
                }
                this.Vdr = false;
            } else {
                Log.i("MicroMsg.TxtStatus.BaseProfileLoadLogic", "sametsize " + dVar.SYE);
                TextView textView3 = this.FYg;
                if (textView3 != null) {
                    Resources resources = getContext().getResources();
                    com.tencent.mm.plugin.textstatus.j.b bVar2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
                    textView3.setText(resources.getString(R.string.hnf, Integer.valueOf(dVar.SYE), com.tencent.mm.plugin.textstatus.j.b.a(aVar2.fvU())));
                }
                this.Vdr = true;
                TextView textView4 = this.FYg;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = this.FYg;
                if (textView5 != null) {
                    textView5.setOnClickListener(new b(this, aVar2, str, dVar));
                }
                SecDataUIC.a aVar3 = SecDataUIC.CWq;
                y yVar = (y) SecDataUIC.a.a(getContext(), 9, y.class);
                if (yVar != null) {
                    yVar.VdS = dVar.SYE;
                }
            }
        }
        AppMethodBeat.o(258384);
        return b2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$update$1$1"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ a Vdt;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.f.a Vdu;
        final /* synthetic */ z.d Vdv;
        final /* synthetic */ String uhS;

        b(a aVar, com.tencent.mm.plugin.textstatus.f.f.a aVar2, String str, z.d dVar) {
            this.Vdt = aVar;
            this.Vdu = aVar2;
            this.uhS = str;
            this.Vdv = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258383);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$update$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusSameTopicsActivity.a aVar = TextStatusSameTopicsActivity.GfI;
            TextStatusSameTopicsActivity.a.bE(this.Vdt.getContext(), this.Vdu.field_TopicId);
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(this.Vdt.getContext(), 9, y.class);
            if (yVar != null) {
                com.tencent.mm.plugin.textstatus.k.a aVar3 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(21, yVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic$update$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258383);
        }
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostClose() {
        TextView textView;
        AppMethodBeat.i(258386);
        if (this.Vdr || (textView = this.FYg) == null) {
            AppMethodBeat.o(258386);
            return;
        }
        textView.setVisibility(8);
        AppMethodBeat.o(258386);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEk() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        AppMethodBeat.i(216131);
        View view = this.FYc;
        if (!(view == null || (animate = view.animate()) == null || (alpha = animate.alpha(0.0f)) == null)) {
            alpha.setDuration(200);
        }
        SecDataUIC.a aVar = SecDataUIC.CWq;
        y yVar = (y) SecDataUIC.a.a(getContext(), 9, y.class);
        if (yVar != null) {
            com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.a(42, yVar);
            AppMethodBeat.o(216131);
            return;
        }
        AppMethodBeat.o(216131);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEl() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        AppMethodBeat.i(216132);
        View view = this.FYc;
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(0.15f)) == null) {
            AppMethodBeat.o(216132);
            return;
        }
        alpha.setDuration(200);
        AppMethodBeat.o(216132);
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEm() {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void eEn() {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UC(int i2) {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UD(int i2) {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void UE(int i2) {
    }

    @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
    public final void onPostOpen(boolean z) {
        AppMethodBeat.i(258385);
        TextView textView = this.FYg;
        if (textView != null) {
            textView.setVisibility(0);
            AppMethodBeat.o(258385);
            return;
        }
        AppMethodBeat.o(258385);
    }
}
