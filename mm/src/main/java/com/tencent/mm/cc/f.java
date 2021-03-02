package com.tencent.mm.cc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.svg.b.b;

public final class f {
    com.tencent.mm.svg.a.a oZU = new com.tencent.mm.svg.a.a();

    public f() {
        AppMethodBeat.i(141244);
        AppMethodBeat.o(141244);
    }

    static {
        AppMethodBeat.i(141247);
        com.tencent.mm.compatible.f.a.a(new a());
        b.AP(MMApplicationContext.getContext().getSharedPreferences("wechat_svg_debug", g.aps()).getBoolean("open_tag", false));
        AppMethodBeat.o(141247);
    }

    public static class a implements a.AbstractC0303a {
        com.tencent.mm.svg.a.a oZU = new com.tencent.mm.svg.a.a();

        public a() {
            AppMethodBeat.i(141242);
            AppMethodBeat.o(141242);
        }

        @Override // com.tencent.mm.compatible.f.a.AbstractC0303a
        public final Bitmap decodeResource(Resources resources, int i2, BitmapFactory.Options options) {
            AppMethodBeat.i(141243);
            if (this.oZU.j(resources, i2)) {
                float f2 = 0.0f;
                if (options != null) {
                    f2 = ((float) options.inDensity) / 160.0f;
                }
                Bitmap b2 = com.tencent.mm.svg.a.a.b(resources, i2, f2);
                AppMethodBeat.o(141243);
                return b2;
            }
            AppMethodBeat.o(141243);
            return null;
        }
    }

    public final Drawable h(Resources resources, int i2) {
        AppMethodBeat.i(141245);
        Drawable drawable = null;
        if (this.oZU.j(resources, i2)) {
            drawable = com.tencent.mm.svg.a.a.h(resources, i2);
        }
        AppMethodBeat.o(141245);
        return drawable;
    }

    public static void Av(boolean z) {
        AppMethodBeat.i(141246);
        MMApplicationContext.getContext().getSharedPreferences("wechat_svg_debug", g.aps()).edit().putBoolean("open_tag", z).commit();
        b.AP(z);
        AppMethodBeat.o(141246);
    }
}
