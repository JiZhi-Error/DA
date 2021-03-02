package com.tencent.mm.ui.component;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, hxF = {"com/tencent/mm/ui/component/UIComponentActivity$onCreate$2", "Landroid/arch/lifecycle/LifecycleObserver;", "onCreate", "", "libmmui_release"})
public final class UIComponentActivity$onCreate$2 implements LifecycleObserver {
    final /* synthetic */ UIComponentActivity PRT;
    final /* synthetic */ Bundle PRU;

    UIComponentActivity$onCreate$2(UIComponentActivity uIComponentActivity, Bundle bundle) {
        this.PRT = uIComponentActivity;
        this.PRU = bundle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        AppMethodBeat.i(204838);
        for (UIComponent uIComponent : this.PRT.uiComponents) {
            Window window = this.PRT.getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            uIComponent.setRootView(decorView);
        }
        for (UIComponent uIComponent2 : this.PRT.uiComponents) {
            uIComponent2.onCreate(this.PRU);
        }
        for (UIComponent uIComponent3 : this.PRT.uiComponents) {
            uIComponent3.onCreateAfter(this.PRU);
        }
        AppMethodBeat.o(204838);
    }
}
