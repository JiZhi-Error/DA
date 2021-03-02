package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Looper;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.ui.ap;
import java.util.List;

/* access modifiers changed from: package-private */
public final class l implements k {
    private final Activity mActivity;
    private final Object nFo = this;
    private Configuration nFp;
    private boolean nFq = false;
    private final SparseArray<WindowInsets> nFr = new SparseArray<>(4);

    l(Activity activity) {
        AppMethodBeat.i(176749);
        this.mActivity = activity;
        this.nFp = new Configuration(activity.getResources().getConfiguration());
        Log.i("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", "<init> hasCutOut[%b] activity[%s]", Boolean.valueOf(cz()), activity.getLocalClassName());
        AppMethodBeat.o(176749);
    }

    /* access modifiers changed from: package-private */
    public final WindowInsets za(int i2) {
        WindowInsets windowInsets;
        AppMethodBeat.i(176750);
        synchronized (this.nFo) {
            try {
                windowInsets = this.nFr.get(i2);
            } finally {
                AppMethodBeat.o(176750);
            }
        }
        return windowInsets;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.k
    public final boolean cz() {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        AppMethodBeat.i(176751);
        final View decorView = this.mActivity.getWindow().getDecorView();
        final int rotation = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
        synchronized (this.nFo) {
            try {
                WindowInsets windowInsets = this.nFr.get(rotation);
                if (windowInsets == null) {
                    if (MMHandlerThread.isMainThread() && decorView.isAttachedToWindow()) {
                        windowInsets = decorView.getRootWindowInsets();
                        this.nFr.put(rotation, decorView.getRootWindowInsets());
                    } else if (MMHandlerThread.isMainThread() || !decorView.isAttachedToWindow()) {
                        final ap bn = ap.bn(this.mActivity);
                        bn.a(new View.OnApplyWindowInsetsListener() {
                            /* class com.tencent.mm.plugin.appbrand.platform.window.a.l.AnonymousClass2 */

                            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                DisplayCutout displayCutout;
                                List<Rect> boundingRects;
                                AppMethodBeat.i(176748);
                                synchronized (l.this.nFo) {
                                    try {
                                        l.this.nFr.put(rotation, decorView.getRootWindowInsets());
                                        if (!(decorView.getRootWindowInsets() == null || (displayCutout = decorView.getRootWindowInsets().getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() <= 0)) {
                                            l.this.nFq = true;
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(176748);
                                        throw th;
                                    }
                                }
                                bn.b(this);
                                AppMethodBeat.o(176748);
                                return windowInsets;
                            }
                        });
                        return this.nFq;
                    } else {
                        windowInsets = (WindowInsets) new SyncTask<WindowInsets>() {
                            /* class com.tencent.mm.plugin.appbrand.platform.window.a.l.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // com.tencent.mm.sdk.platformtools.SyncTask
                            public final /* synthetic */ WindowInsets run() {
                                AppMethodBeat.i(176747);
                                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                                AppMethodBeat.o(176747);
                                return rootWindowInsets;
                            }
                        }.exec(new MMHandler(Looper.getMainLooper()));
                        this.nFr.put(rotation, windowInsets);
                    }
                }
                if (!(windowInsets == null || (displayCutout = windowInsets.getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() <= 0)) {
                    this.nFq = true;
                }
                boolean z = this.nFq;
                AppMethodBeat.o(176751);
                return z;
            } finally {
                AppMethodBeat.o(176751);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.k
    public final int bTW() {
        AppMethodBeat.i(176752);
        int aP = j.cDv.aP(this.mActivity);
        AppMethodBeat.o(176752);
        return aP;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.k
    public final void c(Configuration configuration) {
        AppMethodBeat.i(219582);
        if (n.a(this.nFp, configuration)) {
            synchronized (this.nFo) {
                try {
                    this.nFr.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(219582);
                    throw th;
                }
            }
        }
        this.nFp = new Configuration(configuration);
        AppMethodBeat.o(219582);
    }
}
