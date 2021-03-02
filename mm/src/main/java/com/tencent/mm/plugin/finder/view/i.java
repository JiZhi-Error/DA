package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.widget.PopupWindow;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper;", "", "()V", "TAG", "", "mWindow", "Landroid/widget/PopupWindow;", "getMWindow", "()Landroid/widget/PopupWindow;", "setMWindow", "(Landroid/widget/PopupWindow;)V", "menu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getMenu", "()Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "setMenu", "(Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;)V", "dimiss", "", "isShowing", "show", "", "view", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateContextMMMenuListener;", "selectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onDimissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "plugin-finder_release"})
public final class i {
    private static a wnj;
    public static final i wnk = new i();

    static {
        AppMethodBeat.i(254846);
        AppMethodBeat.o(254846);
    }

    private i() {
    }

    public static void a(View view, o.e eVar, o.g gVar, PopupWindow.OnDismissListener onDismissListener) {
        AppMethodBeat.i(254843);
        p.h(view, "view");
        p.h(eVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        p.h(gVar, "selectedListener");
        p.h(onDismissListener, "onDimissListener");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = iArr[0] + ((int) (((float) view.getWidth()) / 2.0f));
        int i2 = iArr[1];
        if (width > 0 && i2 > 0) {
            a aVar = new a(view.getContext());
            wnj = aVar;
            aVar.hcb();
            a aVar2 = wnj;
            if (aVar2 == null) {
                p.hyc();
            }
            aVar2.setOnDismissListener(onDismissListener);
            a aVar3 = wnj;
            if (aVar3 == null) {
                p.hyc();
            }
            aVar3.a(view, eVar, gVar, width, i2);
        }
        AppMethodBeat.o(254843);
    }

    public static boolean dGO() {
        boolean z = true;
        AppMethodBeat.i(254844);
        a aVar = wnj;
        if (aVar == null) {
            z = false;
        } else if (aVar.isShowing()) {
            a aVar2 = wnj;
            if (aVar2 != null) {
                aVar2.gNq();
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(254844);
        return z;
    }

    public static boolean isShowing() {
        AppMethodBeat.i(254845);
        a aVar = wnj;
        if (aVar == null || !aVar.hca()) {
            AppMethodBeat.o(254845);
            return false;
        }
        AppMethodBeat.o(254845);
        return true;
    }
}
