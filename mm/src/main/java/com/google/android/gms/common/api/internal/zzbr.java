package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzbr extends Fragment implements LifecycleFragment {
    private static WeakHashMap<Activity, WeakReference<zzbr>> zzla = new WeakHashMap<>();
    private Map<String, LifecycleCallback> zzlb = new a();
    private int zzlc = 0;
    private Bundle zzld;

    static {
        AppMethodBeat.i(4520);
        AppMethodBeat.o(4520);
    }

    public zzbr() {
        AppMethodBeat.i(4507);
        AppMethodBeat.o(4507);
    }

    public static zzbr zzc(Activity activity) {
        zzbr zzbr;
        AppMethodBeat.i(4508);
        WeakReference<zzbr> weakReference = zzla.get(activity);
        if (weakReference == null || (zzbr = weakReference.get()) == null) {
            try {
                zzbr = (zzbr) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzbr == null || zzbr.isRemoving()) {
                    zzbr = new zzbr();
                    activity.getFragmentManager().beginTransaction().add(zzbr, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                zzla.put(activity, new WeakReference<>(zzbr));
                AppMethodBeat.o(4508);
            } catch (ClassCastException e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
                AppMethodBeat.o(4508);
                throw illegalStateException;
            }
        } else {
            AppMethodBeat.o(4508);
        }
        return zzbr;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        AppMethodBeat.i(4510);
        if (!this.zzlb.containsKey(str)) {
            this.zzlb.put(str, lifecycleCallback);
            if (this.zzlc > 0) {
                new Handler(Looper.getMainLooper()).post(new zzbs(this, lifecycleCallback, str));
            }
            AppMethodBeat.o(4510);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        AppMethodBeat.o(4510);
        throw illegalArgumentException;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(4519);
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.o(4519);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        AppMethodBeat.i(4509);
        T cast = cls.cast(this.zzlb.get(str));
        AppMethodBeat.o(4509);
        return cast;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity getLifecycleActivity() {
        AppMethodBeat.i(4511);
        Activity activity = getActivity();
        AppMethodBeat.o(4511);
        return activity;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.zzlc > 0;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.zzlc >= 2;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(4515);
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(4515);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(4512);
        super.onCreate(bundle);
        this.zzlc = 1;
        this.zzld = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzlb.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
        AppMethodBeat.o(4512);
    }

    public final void onDestroy() {
        AppMethodBeat.i(4518);
        super.onDestroy();
        this.zzlc = 5;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onDestroy();
        }
        AppMethodBeat.o(4518);
    }

    public final void onResume() {
        AppMethodBeat.i(4514);
        super.onResume();
        this.zzlc = 3;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onResume();
        }
        AppMethodBeat.o(4514);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(4516);
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            AppMethodBeat.o(4516);
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.zzlb.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
        AppMethodBeat.o(4516);
    }

    public final void onStart() {
        AppMethodBeat.i(4513);
        super.onStart();
        this.zzlc = 2;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onStart();
        }
        AppMethodBeat.o(4513);
    }

    public final void onStop() {
        AppMethodBeat.i(4517);
        super.onStop();
        this.zzlc = 4;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onStop();
        }
        AppMethodBeat.o(4517);
    }
}
