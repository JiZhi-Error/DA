package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzcc extends Fragment implements LifecycleFragment {
    private static WeakHashMap<FragmentActivity, WeakReference<zzcc>> zzla = new WeakHashMap<>();
    private Map<String, LifecycleCallback> zzlb = new a();
    private int zzlc = 0;
    private Bundle zzld;

    static {
        AppMethodBeat.i(4535);
        AppMethodBeat.o(4535);
    }

    public zzcc() {
        AppMethodBeat.i(4522);
        AppMethodBeat.o(4522);
    }

    public static zzcc zza(FragmentActivity fragmentActivity) {
        zzcc zzcc;
        AppMethodBeat.i(4523);
        WeakReference<zzcc> weakReference = zzla.get(fragmentActivity);
        if (weakReference == null || (zzcc = weakReference.get()) == null) {
            try {
                zzcc = (zzcc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzcc == null || zzcc.isRemoving()) {
                    zzcc = new zzcc();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().a(zzcc, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                zzla.put(fragmentActivity, new WeakReference<>(zzcc));
                AppMethodBeat.o(4523);
            } catch (ClassCastException e2) {
                IllegalStateException illegalStateException = new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
                AppMethodBeat.o(4523);
                throw illegalStateException;
            }
        } else {
            AppMethodBeat.o(4523);
        }
        return zzcc;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        AppMethodBeat.i(4525);
        if (!this.zzlb.containsKey(str)) {
            this.zzlb.put(str, lifecycleCallback);
            if (this.zzlc > 0) {
                new Handler(Looper.getMainLooper()).post(new zzcd(this, lifecycleCallback, str));
            }
            AppMethodBeat.o(4525);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        AppMethodBeat.o(4525);
        throw illegalArgumentException;
    }

    @Override // android.support.v4.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(4533);
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.dump(str, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.o(4533);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        AppMethodBeat.i(4524);
        T cast = cls.cast(this.zzlb.get(str));
        AppMethodBeat.o(4524);
        return cast;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final /* synthetic */ Activity getLifecycleActivity() {
        AppMethodBeat.i(4534);
        FragmentActivity activity = getActivity();
        AppMethodBeat.o(4534);
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

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(4529);
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(4529);
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(4526);
        super.onCreate(bundle);
        this.zzlc = 1;
        this.zzld = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.zzlb.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
        AppMethodBeat.o(4526);
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        AppMethodBeat.i(4532);
        super.onDestroy();
        this.zzlc = 5;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onDestroy();
        }
        AppMethodBeat.o(4532);
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(4528);
        super.onResume();
        this.zzlc = 3;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onResume();
        }
        AppMethodBeat.o(4528);
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(4530);
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            AppMethodBeat.o(4530);
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.zzlb.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
        AppMethodBeat.o(4530);
    }

    @Override // android.support.v4.app.Fragment
    public final void onStart() {
        AppMethodBeat.i(4527);
        super.onStart();
        this.zzlc = 2;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onStart();
        }
        AppMethodBeat.o(4527);
    }

    @Override // android.support.v4.app.Fragment
    public final void onStop() {
        AppMethodBeat.i(4531);
        super.onStop();
        this.zzlc = 4;
        for (LifecycleCallback lifecycleCallback : this.zzlb.values()) {
            lifecycleCallback.onStop();
        }
        AppMethodBeat.o(4531);
    }
}
