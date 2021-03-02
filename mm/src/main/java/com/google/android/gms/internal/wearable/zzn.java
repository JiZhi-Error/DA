package com.google.android.gms.internal.wearable;

import com.google.android.gms.internal.wearable.zzn;

public abstract class zzn<M extends zzn<M>> extends zzt {
    protected zzp zzhc;

    @Override // com.google.android.gms.internal.wearable.zzt
    public /* synthetic */ Object clone() {
        zzn zzn = (zzn) super.clone();
        zzr.zza(this, zzn);
        return zzn;
    }

    @Override // com.google.android.gms.internal.wearable.zzt
    public void zza(zzl zzl) {
        if (this.zzhc != null) {
            for (int i2 = 0; i2 < this.zzhc.size(); i2++) {
                this.zzhc.zzp(i2).zza(zzl);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzk zzk, int i2) {
        int position = zzk.getPosition();
        if (!zzk.zzd(i2)) {
            return false;
        }
        int i3 = i2 >>> 3;
        zzv zzv = new zzv(i2, zzk.zzb(position, zzk.getPosition() - position));
        zzq zzq = null;
        if (this.zzhc == null) {
            this.zzhc = new zzp();
        } else {
            zzq = this.zzhc.zzo(i3);
        }
        if (zzq == null) {
            zzq = new zzq();
            this.zzhc.zza(i3, zzq);
        }
        zzq.zza(zzv);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzt
    public int zzg() {
        int i2 = 0;
        if (this.zzhc == null) {
            return 0;
        }
        for (int i3 = 0; i3 < this.zzhc.size(); i3++) {
            i2 = this.zzhc.zzp(i3).zzg() + i2;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.wearable.zzt
    public final /* synthetic */ zzt zzs() {
        return (zzn) clone();
    }
}
