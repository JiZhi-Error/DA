package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u001a\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x extends a {
    final b hOp;
    public final View hQA;
    final View hQB;
    final View hQC;
    int hQD;
    public final ImageView hQt;
    public final RelativeLayout hQu;
    public final ImageView hQv;
    public final RelativeLayout hQw;
    public final TextView hQx;
    private final TextView hQy;
    private final TextView hQz;
    private final kotlin.g.a.a<kotlin.x> liveMessageCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208034);
        this.hOp = bVar;
        this.hQt = (ImageView) viewGroup.findViewById(R.id.ekz);
        this.hQu = (RelativeLayout) viewGroup.findViewById(R.id.el0);
        this.hQv = (ImageView) viewGroup.findViewById(R.id.el3);
        this.hQw = (RelativeLayout) viewGroup.findViewById(R.id.el4);
        this.hQx = (TextView) viewGroup.findViewById(R.id.el1);
        this.hQy = (TextView) viewGroup.findViewById(R.id.el5);
        this.hQz = (TextView) viewGroup.findViewById(R.id.el9);
        this.hQA = viewGroup.findViewById(R.id.el2);
        this.hQB = viewGroup.findViewById(R.id.el6);
        this.hQC = viewGroup.findViewById(R.id.el_);
        this.liveMessageCallback = new a(this, viewGroup);
        m mVar = m.hGg;
        m.d(name(), this.liveMessageCallback);
        if (viewGroup.findViewById(R.id.bf8) != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (!isLandscape()) {
                layoutParams.bottomMargin = au.aD(viewGroup.getContext());
            }
            View findViewById = viewGroup.findViewById(R.id.bf8);
            p.g(findViewById, "root.findViewById<Linear…>(R.id.content_root_view)");
            ((LinearLayout) findViewById).setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(208034);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ x hQE;

        public b(x xVar) {
            this.hQE = xVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208030);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hQE.hOp.statusChange(b.c.hLF, new Bundle());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208030);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ x hQE;

        public c(x xVar) {
            this.hQE = xVar;
        }

        public final void onClick(View view) {
            com.tencent.mm.live.core.core.b.d dVar;
            boolean z;
            boolean z2;
            com.tencent.mm.live.core.core.b.d dVar2;
            AppMethodBeat.i(208031);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hQE.hOp.statusChange(b.c.hLE, new Bundle());
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            f aGv = com.tencent.mm.live.b.x.aGv();
            if (!(aGv == null || (dVar = aGv.hzt) == null)) {
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                f aGv2 = com.tencent.mm.live.b.x.aGv();
                if (aGv2 == null || (dVar2 = aGv2.hzt) == null) {
                    z = true;
                } else {
                    z = dVar2.hzh;
                }
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                dVar.hzh = z2;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208031);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208033);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (y.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(8);
                AppMethodBeat.o(208033);
                return;
            case 4:
                rg(0);
                this.hwr.post(new d(this));
                break;
        }
        AppMethodBeat.o(208033);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ x hQE;

        d(x xVar) {
            this.hQE = xVar;
        }

        public final void run() {
            AppMethodBeat.i(208032);
            x xVar = this.hQE;
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(xVar.hQB);
            arrayList.add(xVar.hQC);
            View view = xVar.hQB;
            p.g(view, "switchBtnLayout");
            int width = view.getWidth();
            View view2 = xVar.hQC;
            p.g(view2, "micBtnLayout");
            int mZ = j.mZ(width, view2.getWidth());
            for (View view3 : arrayList) {
                view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), ((mZ - view3.getWidth()) / 2) + view3.getPaddingRight(), view3.getPaddingBottom());
            }
            xVar.hwr.requestLayout();
            AppMethodBeat.o(208032);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ ViewGroup hOA;
        final /* synthetic */ x hQE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x xVar, ViewGroup viewGroup) {
            super(0);
            this.hQE = xVar;
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(208029);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.live.c.x.a.AnonymousClass1 */
                final /* synthetic */ a hQF;

                {
                    this.hQF = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(208028);
                    if (this.hQF.hOA.getVisibility() == 0) {
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        int na = j.na(com.tencent.mm.live.b.x.aGr().LXG - this.hQF.hQE.hQD, 5);
                        if (na > 0) {
                            x xVar2 = this.hQF.hQE;
                            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                            xVar2.hQD = com.tencent.mm.live.b.x.aGr().LXG;
                            Bundle bundle = new Bundle();
                            int[] iArr = {0, 0};
                            this.hQF.hQE.hQw.getLocationOnScreen(iArr);
                            int i2 = iArr[0];
                            RelativeLayout relativeLayout = this.hQF.hQE.hQw;
                            p.g(relativeLayout, "switchCameraBtnClickArea");
                            int width = i2 + (relativeLayout.getWidth() / 2);
                            o.b bVar = o.b.hGo;
                            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFl() / 2));
                            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", iArr[1] - at.fromDPToPix(this.hQF.hOA.getContext(), 16));
                            Iterator it = j.mY(0, na).iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.ac.d.a(500 * ((long) ((ab) it).nextInt()), new C0377a(this, bundle));
                            }
                        }
                    }
                    kotlin.x xVar4 = kotlin.x.SXb;
                    AppMethodBeat.o(208028);
                    return xVar4;
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$liveMessageCallback$1$1$1$1"})
                /* renamed from: com.tencent.mm.live.c.x$a$1$a  reason: collision with other inner class name */
                static final class C0377a extends q implements kotlin.g.a.a<kotlin.x> {
                    final /* synthetic */ AnonymousClass1 hQG;
                    final /* synthetic */ Bundle hQH;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0377a(AnonymousClass1 r2, Bundle bundle) {
                        super(0);
                        this.hQG = r2;
                        this.hQH = bundle;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(208027);
                        this.hQG.hQF.hQE.hOp.statusChange(b.c.hMa, this.hQH);
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(208027);
                        return xVar;
                    }
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(208029);
            return xVar;
        }
    }
}
