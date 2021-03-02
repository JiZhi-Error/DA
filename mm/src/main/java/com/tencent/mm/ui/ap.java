package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.arch.a.c.a;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

@TargetApi(21)
public final class ap {
    private static final boolean OLK = (Build.VERSION.SDK_INT < 23);
    private static final WeakHashMap<Activity, ap> OLL = new WeakHashMap<>();
    private WindowInsets OLM;
    private final Set<View.OnApplyWindowInsetsListener> qFF = new HashSet();

    public static void i(Application application) {
        AppMethodBeat.i(153543);
        final AnonymousClass1 r0 = new a<Activity, Void>() {
            /* class com.tencent.mm.ui.ap.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* synthetic */ Void apply(Activity activity) {
                AppMethodBeat.i(153537);
                Activity activity2 = activity;
                if (ap.OLK && Build.VERSION.SDK_INT >= 21) {
                    ap.bn(activity2);
                }
                AppMethodBeat.o(153537);
                return null;
            }
        };
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            /* class com.tencent.mm.ui.ap.AnonymousClass2 */

            public final void onActivityCreated(Activity activity, Bundle bundle) {
                AppMethodBeat.i(153538);
                r0.apply(activity);
                AppMethodBeat.o(153538);
            }

            public final void onActivityStarted(Activity activity) {
                AppMethodBeat.i(153539);
                r0.apply(activity);
                AppMethodBeat.o(153539);
            }

            public final void onActivityResumed(Activity activity) {
            }

            public final void onActivityPaused(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityDestroyed(Activity activity) {
                ap apVar;
                AppMethodBeat.i(153540);
                synchronized (ap.OLL) {
                    try {
                        apVar = (ap) ap.OLL.remove(activity);
                    } finally {
                        AppMethodBeat.o(153540);
                    }
                }
                if (apVar != null) {
                    synchronized (apVar.qFF) {
                        try {
                            apVar.qFF.clear();
                        } finally {
                            AppMethodBeat.o(153540);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(153540);
            }
        });
        AppMethodBeat.o(153543);
    }

    @TargetApi(21)
    public static ap bn(Activity activity) {
        AppMethodBeat.i(153544);
        ap f2 = f(activity, true);
        AppMethodBeat.o(153544);
        return f2;
    }

    public static WindowInsets bo(Activity activity) {
        AppMethodBeat.i(153545);
        if (OLK) {
            ap f2 = f(activity, false);
            if (f2 == null) {
                AppMethodBeat.o(153545);
                return null;
            }
            WindowInsets gJZ = f2.gJZ();
            AppMethodBeat.o(153545);
            return gJZ;
        } else if (Build.VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            AppMethodBeat.o(153545);
            return rootWindowInsets;
        } else {
            AppMethodBeat.o(153545);
            return null;
        }
    }

    static {
        AppMethodBeat.i(153549);
        AppMethodBeat.o(153549);
    }

    private static ap f(Activity activity, boolean z) {
        ap apVar;
        AppMethodBeat.i(153546);
        synchronized (OLL) {
            try {
                apVar = OLL.get(activity);
                if (apVar == null && z) {
                    apVar = new ap(activity);
                    OLL.put(activity, apVar);
                }
            } finally {
                AppMethodBeat.o(153546);
            }
        }
        return apVar;
    }

    private ap(final Activity activity) {
        AppMethodBeat.i(153547);
        activity.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.ui.ap.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(153542);
                activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    /* class com.tencent.mm.ui.ap.AnonymousClass3.AnonymousClass1 */

                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        LinkedList<View.OnApplyWindowInsetsListener> linkedList;
                        AppMethodBeat.i(153541);
                        synchronized (ap.this) {
                            try {
                                ap.this.OLM = new WindowInsets(windowInsets);
                            } finally {
                                AppMethodBeat.o(153541);
                            }
                        }
                        synchronized (ap.this.qFF) {
                            try {
                                linkedList = new LinkedList(ap.this.qFF);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        for (View.OnApplyWindowInsetsListener onApplyWindowInsetsListener : linkedList) {
                            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
                        }
                        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                        AppMethodBeat.o(153541);
                        return onApplyWindowInsets;
                    }
                });
                AppMethodBeat.o(153542);
            }
        });
        AppMethodBeat.o(153547);
    }

    private WindowInsets gJZ() {
        WindowInsets windowInsets;
        synchronized (this) {
            windowInsets = this.OLM;
        }
        return windowInsets;
    }

    public final void a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        AppMethodBeat.i(153548);
        synchronized (this.qFF) {
            try {
                this.qFF.add(onApplyWindowInsetsListener);
            } finally {
                AppMethodBeat.o(153548);
            }
        }
    }

    public final void b(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        AppMethodBeat.i(175981);
        synchronized (this.qFF) {
            try {
                this.qFF.remove(onApplyWindowInsetsListener);
            } finally {
                AppMethodBeat.o(175981);
            }
        }
    }
}
