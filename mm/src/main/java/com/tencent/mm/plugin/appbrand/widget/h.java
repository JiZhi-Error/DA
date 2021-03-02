package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/IconProviderWC;", "Lcom/tencent/mm/plugin/appbrand/widget/IconProvider;", "()V", "getDefaultAppIcon", "Landroid/graphics/drawable/Drawable;", "plugin-appbrand-integration_release"})
public final class h implements g {
    public static final h ols = new h();

    static {
        AppMethodBeat.i(51406);
        AppMethodBeat.o(51406);
    }

    private h() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.g
    public final Drawable cab() {
        AppMethodBeat.i(51405);
        Drawable aXX = a.aXX();
        AppMethodBeat.o(51405);
        return aXX;
    }
}
