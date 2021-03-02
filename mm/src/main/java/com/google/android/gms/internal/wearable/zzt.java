package com.google.android.gms.internal.wearable;

import java.io.IOException;

public abstract class zzt {
    protected volatile int zzhl = -1;

    public static final <T extends zzt> T zza(T t, byte[] bArr, int i2, int i3) {
        try {
            zzk zza = zzk.zza(bArr, 0, i3);
            t.zza(zza);
            zza.zzc(0);
            return t;
        } catch (zzs e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
        }
    }

    public static final byte[] zzb(zzt zzt) {
        byte[] bArr = new byte[zzt.zzx()];
        try {
            zzl zzb = zzl.zzb(bArr, 0, bArr.length);
            zzt.zza(zzb);
            zzb.zzr();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzu.zzc(this);
    }

    public abstract zzt zza(zzk zzk);

    public void zza(zzl zzl) {
    }

    /* access modifiers changed from: protected */
    public int zzg() {
        return 0;
    }

    /* renamed from: zzs */
    public zzt clone() {
        return (zzt) super.clone();
    }

    public final int zzx() {
        int zzg = zzg();
        this.zzhl = zzg;
        return zzg;
    }
}
