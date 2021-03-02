package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.collection.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

final class j extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        String string;
        AppMethodBeat.i(47638);
        ag agVar2 = agVar;
        String str2 = agVar2.getRuntime().bsC().username;
        int i2 = agVar2.getRuntime().kAq.eix;
        try {
            boolean bf = ((com.tencent.mm.plugin.appbrand.appusage.ag) g.af(com.tencent.mm.plugin.appbrand.appusage.ag.class)).bf(str2, i2);
            int i3 = this.nfG;
            if (bf) {
                string = context.getString(R.string.si);
            } else {
                string = context.getString(R.string.se);
            }
            mVar.a(i3, string, bf ? R.raw.appbrand_menu_modify_collection_remove : R.raw.appbrand_menu_modify_collection_add, 0);
            p.Un(str).kCW = bf;
            AppMethodBeat.o(47638);
        } catch (Exception e2) {
            mVar.removeItem(this.nfG);
            Log.e("MicroMsg.MenuDelegate_ModifyCollection", "attachTo, query (%s %d) e = %s", str2, Integer.valueOf(i2), e2);
            AppMethodBeat.o(47638);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        int i2;
        int i3;
        AppMethodBeat.i(47637);
        ag agVar2 = agVar;
        boolean z = p.Um(str).kCW;
        boolean a2 = d.a(z, context, agVar2.getRuntime().bsC().username, agVar2.getRuntime().kAq.eix);
        int i4 = z ? 25 : 24;
        if (a2) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        i.a(str, agVar2.lBI, i4, "", Util.nowSecond(), i2, 0);
        if (a2) {
            boolean z2 = !z;
            AppBrandStatObject appBrandStatObject = agVar2.getRuntime().ON().cyA;
            if (z2) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            appBrandStatObject.nHt = i3;
        }
        AppMethodBeat.o(47637);
    }

    j() {
        super(u.ModifyCollection.ordinal());
        AppMethodBeat.i(47636);
        AppMethodBeat.o(47636);
    }
}
