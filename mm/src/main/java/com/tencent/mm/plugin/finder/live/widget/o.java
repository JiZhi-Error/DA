package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "giftClickArea", "Landroid/view/View;", "giftIcon", "Landroid/widget/ImageView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "Companion", "plugin-finder_release"})
public final class o {
    private static boolean uHC;
    public static final a uHD = new a((byte) 0);
    final b hOp;
    private final ViewGroup hwr;
    private final d uFw;
    private final ImageView uHA;
    private final View uHB;

    static {
        AppMethodBeat.i(248161);
        AppMethodBeat.o(248161);
    }

    public o(ViewGroup viewGroup, b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(248160);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        View findViewById = this.hwr.findViewById(R.id.cqc);
        p.g(findViewById, "root.findViewById(R.id.finder_live_gift_icon)");
        this.uHA = (ImageView) findViewById;
        View findViewById2 = this.hwr.findViewById(R.id.cqb);
        p.g(findViewById2, "root.findViewById(R.id.f…der_live_gift_click_area)");
        this.uHB = findViewById2;
        this.uHA.setImageDrawable(ar.m(this.hwr.getContext(), R.raw.icons_filled_gift, -1));
        this.uHB.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.o.AnonymousClass1 */
            final /* synthetic */ o uHE;

            {
                this.uHE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248155);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.uHE.hOp, b.c.hMG);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248155);
            }
        });
        this.uHB.setOnLongClickListener(AnonymousClass2.uHF);
        AppMethodBeat.o(248160);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$Companion;", "", "()V", "DEBUG_FLAG", "", "getDEBUG_FLAG", "()Z", "setDEBUG_FLAG", "(Z)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void dju() {
        AppMethodBeat.i(248158);
        if (!this.uFw.getLiveData().dja() || !this.uFw.getLiveData().isLiveStarted()) {
            this.hwr.setVisibility(8);
        } else {
            this.hwr.setVisibility(0);
        }
        m mVar = m.vli;
        m.a(s.aw.GIFT_ICON_EXPOSURE, "", this.hwr.getVisibility());
        AppMethodBeat.o(248158);
    }

    public final boolean isVisible() {
        AppMethodBeat.i(248159);
        if (this.hwr.getVisibility() == 0) {
            AppMethodBeat.o(248159);
            return true;
        }
        AppMethodBeat.o(248159);
        return false;
    }
}
