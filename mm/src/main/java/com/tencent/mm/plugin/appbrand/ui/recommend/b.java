package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003¨\u0006\u0005"}, hxF = {"getDefaultAppCardBg", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getDefaultCardContentImgBg", "plugin-appbrand-integration_release"})
public final class b {
    public static final Drawable a(a aVar) {
        AppMethodBeat.i(51348);
        p.h(aVar, "$this$getDefaultAppCardBg");
        Drawable drawable = aVar.activity.getResources().getDrawable(R.drawable.dh);
        AppMethodBeat.o(51348);
        return drawable;
    }
}
