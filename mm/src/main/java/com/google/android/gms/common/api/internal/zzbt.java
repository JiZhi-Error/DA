package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

public class zzbt extends zzk {
    private TaskCompletionSource<Void> zzln = new TaskCompletionSource<>();

    private zzbt(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.i(11340);
        this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
        AppMethodBeat.o(11340);
    }

    public static zzbt zzd(Activity activity) {
        AppMethodBeat.i(11339);
        LifecycleFragment fragment = getFragment(activity);
        zzbt zzbt = (zzbt) fragment.getCallbackOrNull("GmsAvailabilityHelper", zzbt.class);
        if (zzbt != null) {
            if (zzbt.zzln.getTask().isComplete()) {
                zzbt.zzln = new TaskCompletionSource<>();
            }
            AppMethodBeat.o(11339);
            return zzbt;
        }
        zzbt zzbt2 = new zzbt(fragment);
        AppMethodBeat.o(11339);
        return zzbt2;
    }

    public final Task<Void> getTask() {
        AppMethodBeat.i(11344);
        Task<Void> task = this.zzln.getTask();
        AppMethodBeat.o(11344);
        return task;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onDestroy() {
        AppMethodBeat.i(11343);
        super.onDestroy();
        this.zzln.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
        AppMethodBeat.o(11343);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzk
    public final void zza(ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(11341);
        this.zzln.setException(ApiExceptionUtil.fromConnectionResult(connectionResult));
        AppMethodBeat.o(11341);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzk
    public final void zzr() {
        AppMethodBeat.i(11342);
        int isGooglePlayServicesAvailable = this.zzdg.isGooglePlayServicesAvailable(this.mLifecycleFragment.getLifecycleActivity());
        if (isGooglePlayServicesAvailable == 0) {
            this.zzln.setResult(null);
            AppMethodBeat.o(11342);
            return;
        }
        if (!this.zzln.getTask().isComplete()) {
            zzb(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        }
        AppMethodBeat.o(11342);
    }
}
