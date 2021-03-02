package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.PowerManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005\u001a&\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e¨\u0006\u0011"}, hxF = {"askScreenStatus", "", "context", "Landroid/content/Context;", "onScreenStatusGot", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isScreenOn", "runIfDrawStatusBarLayoutPresent", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "function", "Lcom/tencent/mm/vending/functional/Functional;", "Ljava/lang/Void;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "plugin-appbrand-integration_release"})
public final class z {
    public static final void a(MMActivity mMActivity, com.tencent.mm.vending.c.a<Void, b> aVar) {
        View view;
        AppMethodBeat.i(51154);
        SwipeBackLayout swipeBackLayout = mMActivity.getSwipeBackLayout();
        if (swipeBackLayout != null) {
            view = swipeBackLayout.getTargetContentView();
        } else {
            view = null;
        }
        if (!(view instanceof b)) {
            view = null;
        }
        b bVar = (b) view;
        if (bVar != null) {
            aVar.call(bVar);
            AppMethodBeat.o(51154);
            return;
        }
        AppMethodBeat.o(51154);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ kotlin.g.a.b nXW;

        a(Context context, kotlin.g.a.b bVar) {
            this.$context = context;
            this.nXW = bVar;
        }

        public final void run() {
            AppMethodBeat.i(51153);
            Object systemService = this.$context.getSystemService("power");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.os.PowerManager");
                AppMethodBeat.o(51153);
                throw tVar;
            }
            this.nXW.invoke(Boolean.valueOf(((PowerManager) systemService).isInteractive()));
            AppMethodBeat.o(51153);
        }
    }
}
