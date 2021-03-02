package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zza extends ActivityLifecycleObserver {
    private final WeakReference<C0117zza> zzds;

    /* renamed from: com.google.android.gms.common.api.internal.zza$zza  reason: collision with other inner class name */
    static class C0117zza extends LifecycleCallback {
        private List<Runnable> zzdt = new ArrayList();

        private C0117zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            AppMethodBeat.i(11160);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
            AppMethodBeat.o(11160);
        }

        private static C0117zza zza(Activity activity) {
            C0117zza zza;
            AppMethodBeat.i(11159);
            synchronized (activity) {
                try {
                    LifecycleFragment fragment = getFragment(activity);
                    zza = (C0117zza) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0117zza.class);
                    if (zza == null) {
                        zza = new C0117zza(fragment);
                    }
                } finally {
                    AppMethodBeat.o(11159);
                }
            }
            return zza;
        }

        static /* synthetic */ void zza(C0117zza zza, Runnable runnable) {
            AppMethodBeat.i(11164);
            zza.zza(runnable);
            AppMethodBeat.o(11164);
        }

        private final synchronized void zza(Runnable runnable) {
            AppMethodBeat.i(11161);
            this.zzdt.add(runnable);
            AppMethodBeat.o(11161);
        }

        static /* synthetic */ C0117zza zzb(Activity activity) {
            AppMethodBeat.i(11163);
            C0117zza zza = zza(activity);
            AppMethodBeat.o(11163);
            return zza;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            List<Runnable> list;
            AppMethodBeat.i(11162);
            synchronized (this) {
                try {
                    list = this.zzdt;
                    this.zzdt = new ArrayList();
                } finally {
                    AppMethodBeat.o(11162);
                }
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }

    public zza(Activity activity) {
        this(C0117zza.zzb(activity));
        AppMethodBeat.i(11165);
        AppMethodBeat.o(11165);
    }

    private zza(C0117zza zza) {
        AppMethodBeat.i(11166);
        this.zzds = new WeakReference<>(zza);
        AppMethodBeat.o(11166);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        AppMethodBeat.i(11167);
        C0117zza zza = this.zzds.get();
        if (zza == null) {
            IllegalStateException illegalStateException = new IllegalStateException("The target activity has already been GC'd");
            AppMethodBeat.o(11167);
            throw illegalStateException;
        }
        C0117zza.zza(zza, runnable);
        AppMethodBeat.o(11167);
        return this;
    }
}
