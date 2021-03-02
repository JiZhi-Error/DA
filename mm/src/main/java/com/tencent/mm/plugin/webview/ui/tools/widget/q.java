package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, hxF = {"toActivity", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/content/Context;", "plugin-webview_release"})
public final class q {
    static final MMActivity ib(Context context) {
        Context context2;
        AppMethodBeat.i(82757);
        if (!(context instanceof MMActivity)) {
            context2 = context;
            while (!(context2 instanceof MMActivity) && (context2 instanceof ContextWrapper)) {
                context2 = ((ContextWrapper) context2).getBaseContext();
                p.g(context2, "baseContext.baseContext");
            }
        } else {
            context2 = context;
        }
        if (!(context2 instanceof MMActivity)) {
            context2 = null;
        }
        MMActivity mMActivity = (MMActivity) context2;
        AppMethodBeat.o(82757);
        return mMActivity;
    }
}
