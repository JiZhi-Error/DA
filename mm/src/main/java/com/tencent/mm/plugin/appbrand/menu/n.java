package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class n extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47648);
        ag agVar2 = agVar;
        String str2 = agVar2.getRuntime().bsC().username;
        if (!Util.isNullOrNil(str2)) {
            Intent putExtra = new Intent(context, AppBrandAuthorizeUI.class).putExtra("key_username", str2);
            putExtra.putExtra("key_app_authorize_profile", true);
            c.b(context, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra);
            i.a(agVar2.getAppId(), agVar2.lBI, 30, "", Util.nowSecond(), 1, 0);
        }
        AppMethodBeat.o(47648);
    }

    public n() {
        super(u.Setting.ordinal());
        AppMethodBeat.i(47647);
        AppMethodBeat.o(47647);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(47649);
        mVar.b(this.nfG, context.getString(R.string.ix), R.raw.appbrand_menu_setting);
        AppMethodBeat.o(47649);
    }
}
