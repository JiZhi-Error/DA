package com.google.android.gms.internal.measurement;

public abstract class zzze {
    private static volatile boolean zzbrg = false;
    int zzbrd;
    private int zzbre;
    private boolean zzbrf;

    private zzze() {
        this.zzbrd = 100;
        this.zzbre = Integer.MAX_VALUE;
        this.zzbrf = false;
    }

    static zzze zza(byte[] bArr, int i2, int i3, boolean z) {
        zzzg zzzg = new zzzg(bArr, i2, i3);
        try {
            zzzg.zzaf(i3);
            return zzzg;
        } catch (zzzt e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int zzsz();
}
