package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a2\u0010\b\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\n"}, hxF = {"doOnNextLayout", "", "Landroid/view/View;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnPreDraw", "removeFromViewTree", "plugin-appbrand-integration_release"})
public final class a {
    public static final /* synthetic */ void cw(View view) {
        AppMethodBeat.i(228931);
        p.h(view, "$this$removeFromViewTree");
        view.setVisibility(8);
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(view);
            AppMethodBeat.o(228931);
            return;
        }
        AppMethodBeat.o(228931);
    }
}
