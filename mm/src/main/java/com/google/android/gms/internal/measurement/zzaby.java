package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaby;

public abstract class zzaby<M extends zzaby<M>> extends zzace {
    protected zzaca zzbww;

    @Override // com.google.android.gms.internal.measurement.zzace
    public /* synthetic */ Object clone() {
        zzaby zzaby = (zzaby) super.clone();
        zzacc.zza(this, zzaby);
        return zzaby;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzace
    public int zza() {
        int i2 = 0;
        if (this.zzbww == null) {
            return 0;
        }
        for (int i3 = 0; i3 < this.zzbww.size(); i3++) {
            i2 = this.zzbww.zzau(i3).zza() + i2;
        }
        return i2;
    }

    public final <T> T zza(zzabz<M, T> zzabz) {
        zzacb zzat;
        if (this.zzbww == null || (zzat = this.zzbww.zzat(zzabz.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzat.zzb(zzabz);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public void zza(zzabw zzabw) {
        if (this.zzbww != null) {
            for (int i2 = 0; i2 < this.zzbww.size(); i2++) {
                this.zzbww.zzau(i2).zza(zzabw);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzabv zzabv, int i2) {
        int position = zzabv.getPosition();
        if (!zzabv.zzak(i2)) {
            return false;
        }
        int i3 = i2 >>> 3;
        zzacg zzacg = new zzacg(i2, zzabv.zzc(position, zzabv.getPosition() - position));
        zzacb zzacb = null;
        if (this.zzbww == null) {
            this.zzbww = new zzaca();
        } else {
            zzacb = this.zzbww.zzat(i3);
        }
        if (zzacb == null) {
            zzacb = new zzacb();
            this.zzbww.zza(i3, zzacb);
        }
        zzacb.zza(zzacg);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzvf() {
        return (zzaby) clone();
    }
}
