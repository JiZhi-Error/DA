package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"TAG", "", "isValid", "", "Landroid/content/Context;", "notifyChangeFixed", "", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "plugin-appbrand-integration_release"})
public final class d {
    public static final boolean eg(Context context) {
        AppMethodBeat.i(229098);
        p.h(context, "$this$isValid");
        if (!(context instanceof Activity) || (!((Activity) context).isFinishing() && !((Activity) context).isDestroyed())) {
            AppMethodBeat.o(229098);
            return true;
        }
        AppMethodBeat.o(229098);
        return false;
    }

    public static final void a(e eVar, Context context) {
        AppMethodBeat.i(261668);
        p.h(eVar, "$this$notifyChangeFixed");
        p.h(context, "context");
        if (eg(context)) {
            try {
                eVar.fPw();
                AppMethodBeat.o(261668);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.OpenMaterial.Commons", e2, "notifyChangeFixed, fail", new Object[0]);
                AppMethodBeat.o(261668);
            }
        } else {
            Log.e("MicroMsg.AppBrand.OpenMaterial.Commons", "notifyChangeFixed, context is invalid, why?");
            AppMethodBeat.o(261668);
        }
    }
}
