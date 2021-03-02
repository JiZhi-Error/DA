package com.google.android.gms.common.api.internal;

/* access modifiers changed from: package-private */
public abstract class zzat implements Runnable {
    private final /* synthetic */ zzaj zzhv;

    private zzat(zzaj zzaj) {
        this.zzhv = zzaj;
    }

    /* synthetic */ zzat(zzaj zzaj, zzak zzak) {
        this(zzaj);
    }

    public void run() {
        this.zzhv.zzga.lock();
        try {
            if (!Thread.interrupted()) {
                zzaq();
                this.zzhv.zzga.unlock();
            }
        } catch (RuntimeException e2) {
            this.zzhv.zzhf.zzb(e2);
        } finally {
            this.zzhv.zzga.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzaq();
}
