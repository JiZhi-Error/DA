package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.da;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.shortlink.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class e extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {
    private final b neD = new b((byte) 0);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(227164);
        switch (f(agVar)) {
            case SHOW_CLICKABLE:
                mVar.b(this.nfG, context.getString(R.string.jr), R.raw.app_brand_menu_copy_shortlink);
                AppMethodBeat.o(227164);
                return;
            case SHOW_UNCLICKABLE:
                mVar.a(this.nfG, (CharSequence) context.getString(R.string.jr), R.raw.app_brand_menu_copy_shortlink, true);
                break;
        }
        AppMethodBeat.o(227164);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(227163);
        ag agVar2 = agVar;
        this.neD.appId = str;
        this.neD.neC = agVar2.lBI;
        this.neD.mri = agVar2;
        da daVar = da.lCI;
        da.a(ad.MP_SHORT_LINK, this.neD);
        new u(true).a(agVar2.getComponentId(), agVar2.bsE());
        AppMethodBeat.o(227163);
    }

    public e() {
        super(u.CopyShortLink.ordinal());
        AppMethodBeat.i(227161);
        AppMethodBeat.o(227161);
    }

    public static a f(ag agVar) {
        int i2;
        AppMethodBeat.i(227162);
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        if (bsB != null) {
            i2 = com.tencent.mm.plugin.appbrand.config.a.CopyShortLink.a(bsB);
        } else {
            i2 = 0;
        }
        d dVar = d.nNQ;
        if (!d.bVB().invoke().booleanValue() || i2 == 1) {
            a aVar = a.HIDDEN;
            AppMethodBeat.o(227162);
            return aVar;
        } else if ((!o.g(agVar) || i2 != 0) && bsB != null && bsB.leE.kNW == 0) {
            a aVar2 = a.SHOW_UNCLICKABLE;
            AppMethodBeat.o(227162);
            return aVar2;
        } else {
            a aVar3 = a.SHOW_CLICKABLE;
            AppMethodBeat.o(227162);
            return aVar3;
        }
    }

    public enum a {
        HIDDEN,
        SHOW_CLICKABLE,
        SHOW_UNCLICKABLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(227158);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(227158);
            return aVar;
        }

        static {
            AppMethodBeat.i(227159);
            AppMethodBeat.o(227159);
        }
    }

    static class b implements ah {
        public String appId;
        public ag mri;
        public String neC;

        private b() {
            this.appId = "";
            this.neC = "";
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ah
        public final void Zi(String str) {
            int i2 = 1;
            AppMethodBeat.i(227160);
            Log.i("MicroMsg.MenuDelegate_CopyShortLink", "onReturnUrl %s", str);
            String str2 = this.appId;
            String str3 = this.neC;
            long nowSecond = Util.nowSecond();
            if (str.isEmpty()) {
                i2 = 2;
            }
            i.a(str2, str3, 47, "", nowSecond, i2, 0);
            da daVar = da.lCI;
            da.b(ad.MP_SHORT_LINK, this);
            if (!str.isEmpty()) {
                com.tencent.mm.plugin.appbrand.shortlink.e eVar = com.tencent.mm.plugin.appbrand.shortlink.e.nNT;
                com.tencent.mm.plugin.appbrand.shortlink.e.b(this.mri, str);
            }
            AppMethodBeat.o(227160);
        }
    }
}
