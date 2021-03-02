package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;

public abstract class zzyw implements Serializable, Iterable<Byte> {
    public static final zzyw zzbqx = new zzzc(zzzr.zzbsq);
    private static final zzza zzbqy = (zzyv.zzsv() ? new zzzd(null) : new zzyy(null));
    private int zzboc = 0;

    zzyw() {
    }

    static int zzb(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i2).append(" < 0").toString());
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i2).append(", ").append(i3).toString());
        } else {
            throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i3).append(" >= ").append(i4).toString());
        }
    }

    public static zzyw zzfi(String str) {
        return new zzzc(str.getBytes(zzzr.UTF_8));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzboc;
        if (i2 == 0) {
            int size = size();
            i2 = zza(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzboc = i2;
        }
        return i2;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzyx(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i2, int i3, int i4);

    public abstract byte zzae(int i2);

    public abstract zzyw zzb(int i2, int i3);

    /* access modifiers changed from: protected */
    public final int zzsx() {
        return this.zzboc;
    }
}
