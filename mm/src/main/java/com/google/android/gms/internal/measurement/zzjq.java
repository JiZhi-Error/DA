package com.google.android.gms.internal.measurement;

/* access modifiers changed from: package-private */
public abstract class zzjq extends zzjp {
    private boolean zzvo;

    zzjq(zzjr zzjr) {
        super(zzjr);
        this.zzajp.zzb(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean isInitialized() {
        return this.zzvo;
    }

    /* access modifiers changed from: protected */
    public final void zzch() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzhf();

    public final void zzm() {
        if (this.zzvo) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzhf();
        this.zzajp.zzkz();
        this.zzvo = true;
    }
}
