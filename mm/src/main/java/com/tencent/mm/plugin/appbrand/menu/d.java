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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class d extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {

    /* renamed from: new  reason: not valid java name */
    private static final b f4new = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        boolean z;
        a aVar;
        AppMethodBeat.i(47625);
        int[] iArr = AnonymousClass1.nex;
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = bsB.czc;
        Log.i("MicroMsg.MenuDelegate_CopyPath", "current time = %d , expire time = %d, time interval in seconds = %d", Long.valueOf(currentTimeMillis), Long.valueOf(j2), Long.valueOf((j2 - currentTimeMillis) / 1000));
        if (System.currentTimeMillis() > j2) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            aVar = a.SHOW_CLICKABLE;
        } else {
            aVar = a.HIDDEN;
        }
        switch (iArr[aVar.ordinal()]) {
            case 1:
                mVar.b(this.nfG, context.getString(R.string.jo), R.raw.app_brand_menu_copy_path);
                AppMethodBeat.o(47625);
                return;
            case 2:
                mVar.a(this.nfG, (CharSequence) context.getString(R.string.jo), R.raw.app_brand_menu_copy_path, true);
                break;
        }
        AppMethodBeat.o(47625);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47624);
        ag agVar2 = agVar;
        f4new.appId = str;
        f4new.neC = agVar2.lBI;
        da daVar = da.lCI;
        da.a(ad.PAGE_PATH, f4new);
        new u((byte) 0).a(agVar2.getComponentId(), agVar2.bsE());
        AppMethodBeat.o(47624);
    }

    static {
        AppMethodBeat.i(227155);
        AppMethodBeat.o(227155);
    }

    public d() {
        super(u.CopyPath.ordinal());
        AppMethodBeat.i(47623);
        AppMethodBeat.o(47623);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.menu.d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nex = new int[a.values().length];

        static {
            AppMethodBeat.i(227150);
            try {
                nex[a.SHOW_CLICKABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nex[a.SHOW_UNCLICKABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nex[a.HIDDEN.ordinal()] = 3;
                AppMethodBeat.o(227150);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(227150);
            }
        }
    }

    public enum a {
        HIDDEN,
        SHOW_CLICKABLE,
        SHOW_UNCLICKABLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(227152);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(227152);
            return aVar;
        }

        static {
            AppMethodBeat.i(227153);
            AppMethodBeat.o(227153);
        }
    }

    public static class b implements ah {
        public String appId = "";
        public String neC = "";

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ah
        public final void Zi(String str) {
            int i2 = 1;
            AppMethodBeat.i(227154);
            Log.i("MicroMsg.MenuDelegate_CopyPath", "onReturnUrl %s", str);
            String str2 = this.appId;
            String str3 = this.neC;
            long nowSecond = Util.nowSecond();
            if (str.isEmpty()) {
                i2 = 2;
            }
            i.a(str2, str3, 26, "", nowSecond, i2, 0);
            da daVar = da.lCI;
            da.b(ad.PAGE_PATH, this);
            AppMethodBeat.o(227154);
        }
    }
}
