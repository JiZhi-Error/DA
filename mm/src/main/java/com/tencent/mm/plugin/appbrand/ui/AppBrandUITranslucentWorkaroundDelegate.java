package com.tencent.mm.plugin.appbrand.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;

/* access modifiers changed from: package-private */
public class AppBrandUITranslucentWorkaroundDelegate implements LifecycleObserver, b.a {
    final AppBrandUI nXT;
    boolean nXU = false;
    boolean nXV = false;

    AppBrandUITranslucentWorkaroundDelegate(AppBrandUI appBrandUI) {
        this.nXT = appBrandUI;
    }

    /* access modifiers changed from: package-private */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityResumed() {
        AppMethodBeat.i(227705);
        if (this.nXV) {
            b.bp(this.nXT);
            this.nXV = false;
        }
        AppMethodBeat.o(227705);
    }

    @Override // com.tencent.mm.ui.base.b.a
    public final void bXA() {
        this.nXU = true;
    }

    @Override // com.tencent.mm.ui.base.b.a
    public final void bXB() {
        this.nXU = false;
    }
}
