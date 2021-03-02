package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzis implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzis(zzii zzii, AtomicReference atomicReference, String str, String str2, String str3, zzdz zzdz) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1854);
        synchronized (this.zzapf) {
            try {
                zzey zzey = this.zzape.zzaoy;
                if (zzey == null) {
                    this.zzape.zzge().zzim().zzd("Failed to get conditional properties", zzfg.zzbm(this.zzanj), this.zzanh, this.zzani);
                    this.zzapf.set(Collections.emptyList());
                    try {
                        this.zzapf.notify();
                    } finally {
                        AppMethodBeat.o(1854);
                    }
                } else {
                    if (TextUtils.isEmpty(this.zzanj)) {
                        this.zzapf.set(zzey.zza(this.zzanh, this.zzani, this.zzane));
                    } else {
                        this.zzapf.set(zzey.zze(this.zzanj, this.zzanh, this.zzani));
                    }
                    zzii.zze(this.zzape);
                    this.zzapf.notify();
                    AppMethodBeat.o(1854);
                }
            } catch (RemoteException e2) {
                this.zzape.zzge().zzim().zzd("Failed to get conditional properties", zzfg.zzbm(this.zzanj), this.zzanh, e2);
                this.zzapf.set(Collections.emptyList());
                this.zzapf.notify();
            } catch (Throwable th) {
                this.zzapf.notify();
                AppMethodBeat.o(1854);
                throw th;
            }
        }
    }
}
