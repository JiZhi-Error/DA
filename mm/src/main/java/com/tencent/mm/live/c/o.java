package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.d.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nJ\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010+\u001a\u00020\u001eH\u0016J\u001a\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020\u001eH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "checkDuration", "", "createTime", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "onlineCnt", "likeCnt", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o extends a {
    private final String TAG = "MicroMsg.LiveCommonInfoPlugin";
    public boolean dMz;
    final b hOp;
    final TextView hPE;
    final TextView hPF;
    final TextView hPG;
    private final View hPH;
    private final View hPI;
    private final View hPJ;
    final ImageView hPK;
    private final ImageView hPL;
    final Drawable hPM;
    final Drawable hPN;
    final Drawable hPO;
    public int hPP;
    public String hPQ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207988);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.egq);
        p.g(findViewById, "root.findViewById(R.id.l…e_common_info_members_tv)");
        this.hPE = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.egk);
        p.g(findViewById2, "root.findViewById(R.id.l…_common_info_duration_tv)");
        this.hPF = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.egn);
        p.g(findViewById3, "root.findViewById(R.id.live_common_info_like_tv)");
        this.hPG = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.ego);
        p.g(findViewById4, "root.findViewById(R.id.l…ommon_info_members_group)");
        this.hPH = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.egi);
        p.g(findViewById5, "root.findViewById(R.id.l…mmon_info_duration_group)");
        this.hPI = findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.egl);
        p.g(findViewById6, "root.findViewById(R.id.l…e_common_info_like_group)");
        this.hPJ = findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.egj);
        p.g(findViewById7, "root.findViewById(R.id.l…ommon_info_duration_icon)");
        this.hPK = (ImageView) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.egh);
        p.g(findViewById8, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
        this.hPL = (ImageView) findViewById8;
        this.hPM = rh(R.raw.live_net_good_icon);
        this.hPN = rh(R.raw.live_net_normal_icon);
        this.hPO = rh(R.raw.live_net_bad_icon);
        e.h hVar = e.h.hya;
        this.hPP = e.h.aCS();
        this.hPQ = "00:00:00";
        this.hPH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.o.AnonymousClass1 */
            final /* synthetic */ o hPR;

            {
                this.hPR = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207980);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hPR.hOp.getLiveRole() == 0) {
                    f.aIN();
                } else {
                    com.tencent.mm.live.d.a.aIc();
                }
                b.C0376b.a(this.hPR.hOp, b.c.hLO);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207980);
            }
        });
        AppMethodBeat.o(207988);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ o hPR;
        final /* synthetic */ int hPS;
        final /* synthetic */ int hPT;

        a(o oVar, int i2, int i3) {
            this.hPR = oVar;
            this.hPS = i2;
            this.hPT = i3;
        }

        public final void run() {
            String format;
            AppMethodBeat.i(207982);
            int i2 = this.hPR.hPP;
            e.h hVar = e.h.hya;
            if (i2 == e.h.aCS()) {
                this.hPR.hPK.setImageDrawable(this.hPR.hPM);
            } else {
                e.h hVar2 = e.h.hya;
                if (i2 == e.h.aCT()) {
                    this.hPR.hPK.setImageDrawable(this.hPR.hPN);
                } else {
                    e.h hVar3 = e.h.hya;
                    if (i2 == e.h.aCU()) {
                        this.hPR.hPK.setImageDrawable(this.hPR.hPO);
                    }
                }
            }
            TextView textView = this.hPR.hPE;
            ae aeVar = ae.SYK;
            String string = this.hPR.hwr.getContext().getString(R.string.eh9);
            p.g(string, "root.context.getString(R.string.live_members_tip)");
            String format2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.hPS)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            textView.setText(String.valueOf(format2));
            this.hPR.hPF.setText(String.valueOf(this.hPR.hPQ));
            TextView textView2 = this.hPR.hPG;
            u.a aVar = u.hIn;
            int i3 = this.hPT;
            if (i3 <= 0) {
                format = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else if (i3 < 10000) {
                format = String.valueOf(i3);
            } else if (i3 % 10000 >= 1000) {
                ae aeVar2 = ae.SYK;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                String string2 = context.getResources().getString(R.string.egk);
                p.g(string2, "MMApplicationContext.get…g.live_like_count_format)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Float.valueOf(((float) i3) / 10000.0f)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
            } else {
                ae aeVar3 = ae.SYK;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                String string3 = context2.getResources().getString(R.string.egl);
                p.g(string3, "MMApplicationContext.get…ve_like_count_int_format)");
                format = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(i3 / 10000)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
            }
            textView2.setText(format);
            AppMethodBeat.o(207982);
        }
    }

    public final void aHy() {
        AppMethodBeat.i(207985);
        b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
        this.dMz = b.a.aDp();
        if (this.dMz) {
            this.hPH.setVisibility(0);
            this.hPI.setVisibility(0);
            this.hPJ.setVisibility(0);
            AppMethodBeat.o(207985);
            return;
        }
        this.hPH.setVisibility(0);
        this.hPI.setVisibility(8);
        this.hPJ.setVisibility(8);
        AppMethodBeat.o(207985);
    }

    @Override // com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(207986);
        super.rg(i2);
        AppMethodBeat.o(207986);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(207987);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (p.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                super.rg(0);
                AppMethodBeat.o(207987);
                return;
            case 2:
                super.rg(8);
                AppMethodBeat.o(207987);
                return;
            case 3:
                if (this.hOp.getLiveRole() == 0) {
                    if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                        super.rg(0);
                        break;
                    } else {
                        super.rg(4);
                        AppMethodBeat.o(207987);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(207987);
    }

    public final void db(int i2, int i3) {
        AppMethodBeat.i(207983);
        this.hwr.post(new a(this, i2, i3));
        AppMethodBeat.o(207983);
    }

    private final Drawable rh(int i2) {
        AppMethodBeat.i(207984);
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        Drawable drawable = context.getResources().getDrawable(i2);
        p.g(drawable, "root.context.resources.getDrawable(resId)");
        AppMethodBeat.o(207984);
        return drawable;
    }
}
