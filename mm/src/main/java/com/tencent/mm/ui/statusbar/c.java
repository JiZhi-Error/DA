package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.Meizu;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

public class c {
    private static final WeakHashMap<Activity, c> OLL = new WeakHashMap<>();
    @SuppressLint({"StaticFieldLeak"})
    private static final c QoB = new c() {
        /* class com.tencent.mm.ui.statusbar.c.AnonymousClass2 */

        @Override // com.tencent.mm.ui.statusbar.c
        public final void a(a aVar) {
        }

        @Override // com.tencent.mm.ui.statusbar.c
        public final void b(a aVar) {
        }
    };
    public static final boolean Qow;
    private WeakReference<View> QoA;
    private final Set<WeakReference<a>> Qox;
    private boolean Qoy;
    int Qoz;
    private final WeakReference<Activity> mActivityRef;

    public interface a {
        void yf(int i2);
    }

    /* synthetic */ c() {
        this(null);
    }

    static {
        boolean z;
        AppMethodBeat.i(133824);
        if (Build.VERSION.SDK_INT < 21 || Meizu.hasSmartBar()) {
            z = false;
        } else {
            z = true;
        }
        Qow = z;
        AppMethodBeat.o(133824);
    }

    private c(Activity activity) {
        AppMethodBeat.i(133819);
        this.Qox = new HashSet();
        this.Qoy = false;
        this.Qoz = 0;
        this.mActivityRef = new WeakReference<>(activity);
        AppMethodBeat.o(133819);
    }

    public final void requestApplyInsets() {
        AppMethodBeat.i(196231);
        if (!(this.QoA == null || this.QoA.get() == null)) {
            this.QoA.get().requestApplyInsets();
        }
        AppMethodBeat.o(196231);
    }

    public void b(a aVar) {
        AppMethodBeat.i(133821);
        if (aVar != null) {
            Iterator it = new LinkedList(this.Qox).iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (aVar == weakReference.get() || weakReference.get() == null) {
                    this.Qox.remove(weakReference);
                }
            }
        }
        AppMethodBeat.o(133821);
    }

    public static c bt(Activity activity) {
        AppMethodBeat.i(133822);
        if (!Qow || activity == null) {
            c cVar = QoB;
            AppMethodBeat.o(133822);
            return cVar;
        }
        c cVar2 = OLL.get(activity);
        if (cVar2 == null) {
            cVar2 = new c(activity);
            OLL.put(activity, cVar2);
        }
        AppMethodBeat.o(133822);
        return cVar2;
    }

    public void a(a aVar) {
        View view;
        AppMethodBeat.i(133820);
        if (!this.Qoy) {
            this.Qoy = true;
            Activity activity = this.mActivityRef.get();
            if (!(activity == null || activity.getWindow() == null)) {
                try {
                    final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= viewGroup.getChildCount()) {
                            view = null;
                            break;
                        }
                        view = viewGroup.getChildAt(i2);
                        if (!"android:status:background".equals(view.getTransitionName()) && !"android:navigation:background".equals(view.getTransitionName())) {
                            break;
                        }
                        i2++;
                    }
                    if (view == null) {
                        view = viewGroup;
                    }
                    view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                        /* class com.tencent.mm.ui.statusbar.c.AnonymousClass1 */

                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            AppMethodBeat.i(133818);
                            c.b(c.this, c.this.Qoz = windowInsets.getSystemWindowInsetTop());
                            WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
                            if (view != viewGroup) {
                                view.onApplyWindowInsets(consumeSystemWindowInsets);
                            }
                            AppMethodBeat.o(133818);
                            return consumeSystemWindowInsets;
                        }
                    });
                    view.requestApplyInsets();
                    this.QoA = new WeakReference<>(view);
                } catch (Exception e2) {
                    this.Qoy = false;
                    Log.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", e2);
                }
            }
        }
        if (aVar != null) {
            this.Qox.add(new WeakReference<>(aVar));
            if (this.Qoz > 0) {
                aVar.yf(this.Qoz);
            }
        }
        AppMethodBeat.o(133820);
    }

    static /* synthetic */ void b(c cVar, int i2) {
        AppMethodBeat.i(133823);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(cVar.Qox);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.yf(i2);
            } else {
                cVar.Qox.remove(weakReference);
            }
        }
        AppMethodBeat.o(133823);
    }
}
