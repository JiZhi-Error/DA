package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Landroid/widget/ImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", ch.COL_USERNAME, "plugin-logic_release"})
public final class ay extends a {
    private Context context;
    private final TextView gxs;
    final b hOp;
    private int hOw;
    private final ImageView hSF;
    String hwd;
    private final TextView titleTv;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ay(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208183);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.emh);
        p.g(findViewById, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
        this.hSF = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.emj);
        p.g(findViewById2, "root.findViewById(R.id.live_title_info_name_tv)");
        this.gxs = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.eml);
        p.g(findViewById3, "root.findViewById(R.id.live_title_info_title_tv)");
        this.titleTv = (TextView) findViewById3;
        this.hOw = au.aD(viewGroup.getContext());
        this.hSF.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.ay.AnonymousClass1 */
            final /* synthetic */ ay hSG;

            {
                this.hSG = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208178);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                bundle.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.hSG.hwd);
                this.hSG.hOp.statusChange(b.c.hMk, bundle);
                if (this.hSG.hOp.getLiveRole() == 0) {
                    x xVar = x.hJf;
                    String aGm = x.aGm();
                    x xVar2 = x.hJf;
                    long j2 = x.aGr().hyH;
                    x xVar3 = x.hJf;
                    String aGt = x.aGt();
                    x xVar4 = x.hJf;
                    e.a(aGm, j2, aGt, 8, 1, x.aGr().LIa);
                    f.aIO();
                }
                a.a(this, "com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208178);
            }
        });
        if (viewGroup.getLayoutParams() != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && isLandscape()) {
            switch (getCurrentOrientation()) {
                case 1:
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(at.fromDPToPix(viewGroup.getContext(), 16));
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208183);
                        throw tVar;
                    }
                case 3:
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208183);
                        throw tVar2;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(au.aD(viewGroup.getContext()));
                    AppMethodBeat.o(208183);
                    return;
            }
        }
        AppMethodBeat.o(208183);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(208180);
        super.resume();
        int aD = au.aD(this.hwr.getContext());
        if (aD == 0) {
            aD = at.fromDPToPix(this.hwr.getContext(), 16);
        }
        this.hOw = aD;
        AppMethodBeat.o(208180);
    }

    public final void a(CharSequence charSequence, String str) {
        AppMethodBeat.i(208181);
        p.h(charSequence, "title");
        p.h(str, ch.COL_USERNAME);
        this.hwd = str;
        a.b.c(this.hSF, str);
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, charSequence, this.titleTv.getTextSize()));
        TextView textView = this.gxs;
        Context context2 = this.hwr.getContext();
        x xVar = x.hJf;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context2, x.GV(str), this.titleTv.getTextSize()));
        if (Util.isNullOrNil(charSequence)) {
            this.titleTv.setVisibility(8);
            this.gxs.requestLayout();
            AppMethodBeat.o(208181);
            return;
        }
        this.titleTv.setVisibility(0);
        AppMethodBeat.o(208181);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208182);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (az.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(4);
                AppMethodBeat.o(208182);
                return;
            case 4:
                rg(0);
                AppMethodBeat.o(208182);
                return;
            case 5:
                if (this.hOp.getLiveRole() == 0) {
                    if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                        rg(0);
                        AppMethodBeat.o(208182);
                        return;
                    }
                    rg(4);
                    AppMethodBeat.o(208182);
                    return;
                }
                break;
            case 6:
                if (this.hwr.getLayoutParams() != null && (this.hwr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    switch (getCurrentOrientation()) {
                        case 1:
                            ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                            if (layoutParams != null) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(at.fromDPToPix(this.hwr.getContext(), 16));
                                this.hwr.requestLayout();
                                break;
                            } else {
                                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                AppMethodBeat.o(208182);
                                throw tVar;
                            }
                        case 3:
                            ViewGroup.LayoutParams layoutParams2 = this.hwr.getLayoutParams();
                            if (layoutParams2 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                AppMethodBeat.o(208182);
                                throw tVar2;
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(this.hOw);
                            this.hwr.requestLayout();
                            AppMethodBeat.o(208182);
                            return;
                    }
                }
                break;
        }
        AppMethodBeat.o(208182);
    }
}
