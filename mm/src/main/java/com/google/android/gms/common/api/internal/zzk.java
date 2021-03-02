package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzk extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean mStarted;
    protected final GoogleApiAvailability zzdg;
    protected final AtomicReference<zzl> zzer;
    private final Handler zzes;

    protected zzk(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    @VisibleForTesting
    private zzk(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zzer = new AtomicReference<>(null);
        this.zzes = new Handler(Looper.getMainLooper());
        this.zzdg = googleApiAvailability;
    }

    private static int zza(zzl zzl) {
        if (zzl == null) {
            return -1;
        }
        return zzl.zzu();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        int i4 = 13;
        zzl zzl = this.zzer.get();
        switch (i2) {
            case 1:
                if (i3 != -1) {
                    if (i3 == 0) {
                        if (intent != null) {
                            i4 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        zzl zzl2 = new zzl(new ConnectionResult(i4, null), zza(zzl));
                        this.zzer.set(zzl2);
                        zzl = zzl2;
                        z = false;
                        break;
                    }
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
            case 2:
                int isGooglePlayServicesAvailable = this.zzdg.isGooglePlayServicesAvailable(getActivity());
                z = isGooglePlayServicesAvailable == 0;
                if (zzl == null) {
                    return;
                }
                if (zzl.getConnectionResult().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
            default:
                z = false;
                break;
        }
        if (z) {
            zzt();
        } else if (zzl != null) {
            zza(zzl.getConnectionResult(), zzl.zzu());
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), zza(this.zzer.get()));
        zzt();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzer.set(bundle.getBoolean("resolving_error", false) ? new zzl(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zzl zzl = this.zzer.get();
        if (zzl != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzl.zzu());
            bundle.putInt("failed_status", zzl.getConnectionResult().getErrorCode());
            bundle.putParcelable("failed_resolution", zzl.getConnectionResult().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ConnectionResult connectionResult, int i2);

    public final void zzb(ConnectionResult connectionResult, int i2) {
        zzl zzl = new zzl(connectionResult, i2);
        if (this.zzer.compareAndSet(null, zzl)) {
            this.zzes.post(new zzm(this, zzl));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzr();

    /* access modifiers changed from: protected */
    public final void zzt() {
        this.zzer.set(null);
        zzr();
    }
}
