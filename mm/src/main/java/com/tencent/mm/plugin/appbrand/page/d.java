package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0001J\u0019\u0010\t\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\n0\nH\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0001J\u0019\u0010\r\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u000e0\u000eH\u0001J\u0019\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00100\u0010H\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00120\u0012H\u0001J\u0019\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00140\u0014H\u0001J\u0019\u0010\u0015\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0011\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0018H\u0001J\t\u0010\u0019\u001a\u00020\u0018H\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u0001J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&J\b\u0010!\u001a\u00020\u0005H\u0004J\u0014\u0010\"\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050$J\u0012\u0010\"\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020)H\u0016J\t\u0010*\u001a\u00020\u0005H\u0001J\u0012\u0010+\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0019\u0010,\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0001J\u0019\u0010-\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\n0\nH\u0001J\u0019\u0010.\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0001J\u0019\u0010/\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u000e0\u000eH\u0001J\u0019\u00100\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00100\u0010H\u0001J\u0019\u00101\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00120\u0012H\u0001J\u0019\u00102\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00140\u0014H\u0001J\u0019\u00103\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0019\u00104\u001a\u00020\u00052\u000e\b\u0004\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050$H\bJ\u0010\u00104\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&J\b\u00105\u001a\u00020\u0005H\u0004¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore;", "()V", "addOnBackPressedListener", "", "p0", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackPressedListener;", "kotlin.jvm.PlatformType", "addOnBackgroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "addOnDestroyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "addOnForegroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "addOnInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnInteractiveListener;", "addOnNonInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnNonInteractiveListener;", "addOnReadyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "addOnWillDisappearListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnWillDisappearListener;", "callInteractiveStateChanged", "", "callOnBackPressed", "callOnViewWillDisappear", "callPageOnBackground", "callPageOnDestroy", "callPageOnForeground", "callPageOnReady", "getContentView", "Landroid/view/View;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "post", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "removeAllLifecycleListeners", "removeCallbacks", "removeOnBackPressedListener", "removeOnBackgroundListener", "removeOnDestroyListener", "removeOnForegroundListener", "removeOnInteractiveListener", "removeOnNonInteractiveListener", "removeOnReadyListener", "removeOnWillDisappearListener", "runOnUiThread", "show", "luggage-wxa-app_release"})
public abstract class d extends com.tencent.mm.plugin.appbrand.d implements i {
    public final /* synthetic */ j nnC = new j();

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.b bVar) {
        this.nnC.a(bVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.c cVar) {
        this.nnC.a(cVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.d dVar) {
        this.nnC.a(dVar);
    }

    public final void a(i.e eVar) {
        this.nnC.a(eVar);
    }

    public final void a(i.f fVar) {
        this.nnC.a(fVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.b bVar) {
        this.nnC.b(bVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.c cVar) {
        this.nnC.b(cVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.d dVar) {
        this.nnC.b(dVar);
    }

    public final void b(i.e eVar) {
        this.nnC.b(eVar);
    }

    public final void b(i.f fVar) {
        this.nnC.b(fVar);
    }

    public abstract View getContentView();

    public final void hh(boolean z) {
        this.nnC.hh(z);
    }

    public final void runOnUiThread(Runnable runnable) {
        if (MMHandlerThread.isMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void post(Runnable runnable) {
        View contentView;
        if (runnable != null && (contentView = getContentView()) != null) {
            contentView.post(runnable);
        }
    }

    public void c(Runnable runnable, long j2) {
        View contentView;
        if (runnable != null && (contentView = getContentView()) != null) {
            contentView.postDelayed(runnable, j2);
        }
    }

    public void removeCallbacks(Runnable runnable) {
        View contentView;
        if (runnable != null && (contentView = getContentView()) != null) {
            contentView.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public final void hide() {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setVisibility(4);
        }
    }
}
