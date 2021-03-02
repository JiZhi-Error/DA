package com.tencent.mm.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/ui/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "libmmui_release"})
public final class u extends ContextThemeWrapper {
    private LayoutInflater kgB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(Context context, int i2) {
        super(context, i2);
        p.h(context, "base");
        AppMethodBeat.i(204790);
        AppMethodBeat.o(204790);
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        AppMethodBeat.i(204789);
        p.h(str, "name");
        if (p.j("layout_inflater", str)) {
            if (this.kgB == null) {
                Object systemService = super.getSystemService(str);
                if (!(systemService instanceof LayoutInflater)) {
                    systemService = null;
                }
                this.kgB = aa.b((LayoutInflater) systemService);
            }
            LayoutInflater layoutInflater = this.kgB;
            AppMethodBeat.o(204789);
            return layoutInflater;
        }
        Object systemService2 = super.getSystemService(str);
        AppMethodBeat.o(204789);
        return systemService2;
    }
}
