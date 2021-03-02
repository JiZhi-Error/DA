package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class v extends u {
    public v(ag agVar, List<t> list) {
        super(agVar, list);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.u
    public final void a(e eVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int a2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(47798);
        super.a(eVar);
        final ag agVar = (ag) this.cwK;
        if (agVar.getRuntime().NA()) {
            if (agVar.isFullScreen() || agVar.btO()) {
                z = true;
            } else {
                z = false;
            }
            eVar.mLN = z;
            if (agVar.isFullScreen() || agVar.btO()) {
                z2 = true;
            } else {
                z2 = false;
            }
            eVar.mLO = z2;
        } else {
            eVar.mLN = agVar.isFullScreen();
            eVar.mLO = agVar.isFullScreen();
        }
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.plugin.appbrand.page.v.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(47796);
                i.a(agVar.getAppId(), agVar.lBI, 38, "", Util.nowSecond(), 1, 0);
                AppMethodBeat.o(47796);
            }
        };
        eVar.QNO = new e.a() {
            /* class com.tencent.mm.plugin.appbrand.page.v.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.e.a
            public final void onClick() {
                AppMethodBeat.i(47797);
                i.a(agVar.getAppId(), agVar.lBI, 37, "", Util.nowSecond(), 1, 0);
                AppMethodBeat.o(47797);
            }
        };
        ag agVar2 = (ag) this.cwK;
        a ah = a.C0775a.ah(agVar2.getRuntime());
        int i6 = o.g(agVar2) ? 1 : 0;
        if (agVar2.getRuntime().bsC().NA()) {
            i2 = 2;
        } else {
            i2 = b.g(agVar2) ? 1 : 0;
        }
        switch (com.tencent.mm.plugin.appbrand.menu.e.f(agVar2)) {
            case SHOW_CLICKABLE:
                i3 = 1;
                break;
            case HIDDEN:
                i3 = 2;
                break;
            case SHOW_UNCLICKABLE:
                i3 = 0;
                break;
            default:
                i3 = 1;
                break;
        }
        if (ah.bSu() == a.b.LBS.ordinal()) {
            i4 = 1;
        } else if (ah.bSu() == a.b.VOICE.ordinal()) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        if (p.g(agVar2)) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (!q.ef(agVar2.getContext())) {
            a2 = 1;
        } else {
            AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
            if (bsB == null) {
                a2 = 1;
            } else {
                a2 = com.tencent.mm.plugin.appbrand.config.a.ShareToWeWork.a(bsB);
            }
        }
        i.a(agVar2.getAppId(), agVar2.lBI, 28, String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(a2), Integer.valueOf(i3)), Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47798);
    }
}
