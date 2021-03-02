package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzq implements Cloneable {
    private Object value;
    private zzo<?, ?> zzhi;
    private List<zzv> zzhj = new ArrayList();

    zzq() {
        AppMethodBeat.i(100742);
        AppMethodBeat.o(100742);
    }

    private final byte[] toByteArray() {
        AppMethodBeat.i(100748);
        byte[] bArr = new byte[zzg()];
        zza(zzl.zzb(bArr));
        AppMethodBeat.o(100748);
        return bArr;
    }

    private final zzq zzt() {
        int i2 = 0;
        AppMethodBeat.i(100749);
        zzq zzq = new zzq();
        try {
            zzq.zzhi = this.zzhi;
            if (this.zzhj == null) {
                zzq.zzhj = null;
            } else {
                zzq.zzhj.addAll(this.zzhj);
            }
            if (this.value != null) {
                if (this.value instanceof zzt) {
                    zzq.value = (zzt) ((zzt) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzq.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzq.value = bArr2;
                    while (i2 < bArr.length) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                        i2++;
                    }
                } else if (this.value instanceof boolean[]) {
                    zzq.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzq.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzq.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzq.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzq.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzt[]) {
                    zzt[] zztArr = (zzt[]) this.value;
                    zzt[] zztArr2 = new zzt[zztArr.length];
                    zzq.value = zztArr2;
                    while (i2 < zztArr.length) {
                        zztArr2[i2] = (zzt) zztArr[i2].clone();
                        i2++;
                    }
                }
            }
            AppMethodBeat.o(100749);
            return zzq;
        } catch (CloneNotSupportedException e2) {
            AssertionError assertionError = new AssertionError(e2);
            AppMethodBeat.o(100749);
            throw assertionError;
        }
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(100750);
        zzq zzt = zzt();
        AppMethodBeat.o(100750);
        return zzt;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100746);
        if (obj == this) {
            AppMethodBeat.o(100746);
            return true;
        } else if (!(obj instanceof zzq)) {
            AppMethodBeat.o(100746);
            return false;
        } else {
            zzq zzq = (zzq) obj;
            if (this.value == null || zzq.value == null) {
                if (this.zzhj == null || zzq.zzhj == null) {
                    try {
                        boolean equals = Arrays.equals(toByteArray(), zzq.toByteArray());
                        AppMethodBeat.o(100746);
                        return equals;
                    } catch (IOException e2) {
                        IllegalStateException illegalStateException = new IllegalStateException(e2);
                        AppMethodBeat.o(100746);
                        throw illegalStateException;
                    }
                } else {
                    boolean equals2 = this.zzhj.equals(zzq.zzhj);
                    AppMethodBeat.o(100746);
                    return equals2;
                }
            } else if (this.zzhi != zzq.zzhi) {
                AppMethodBeat.o(100746);
                return false;
            } else if (!this.zzhi.zzhd.isArray()) {
                boolean equals3 = this.value.equals(zzq.value);
                AppMethodBeat.o(100746);
                return equals3;
            } else if (this.value instanceof byte[]) {
                boolean equals4 = Arrays.equals((byte[]) this.value, (byte[]) zzq.value);
                AppMethodBeat.o(100746);
                return equals4;
            } else if (this.value instanceof int[]) {
                boolean equals5 = Arrays.equals((int[]) this.value, (int[]) zzq.value);
                AppMethodBeat.o(100746);
                return equals5;
            } else if (this.value instanceof long[]) {
                boolean equals6 = Arrays.equals((long[]) this.value, (long[]) zzq.value);
                AppMethodBeat.o(100746);
                return equals6;
            } else if (this.value instanceof float[]) {
                boolean equals7 = Arrays.equals((float[]) this.value, (float[]) zzq.value);
                AppMethodBeat.o(100746);
                return equals7;
            } else if (this.value instanceof double[]) {
                boolean equals8 = Arrays.equals((double[]) this.value, (double[]) zzq.value);
                AppMethodBeat.o(100746);
                return equals8;
            } else if (this.value instanceof boolean[]) {
                boolean equals9 = Arrays.equals((boolean[]) this.value, (boolean[]) zzq.value);
                AppMethodBeat.o(100746);
                return equals9;
            } else {
                boolean deepEquals = Arrays.deepEquals((Object[]) this.value, (Object[]) zzq.value);
                AppMethodBeat.o(100746);
                return deepEquals;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(100747);
        try {
            int hashCode = Arrays.hashCode(toByteArray()) + JsApiGetABTestConfig.CTRL_INDEX;
            AppMethodBeat.o(100747);
            return hashCode;
        } catch (IOException e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.o(100747);
            throw illegalStateException;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzl zzl) {
        AppMethodBeat.i(100745);
        if (this.value != null) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.o(100745);
            throw noSuchMethodError;
        }
        for (zzv zzv : this.zzhj) {
            zzl.zzl(zzv.tag);
            zzl.zzc(zzv.zzhm);
        }
        AppMethodBeat.o(100745);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv) {
        AppMethodBeat.i(100743);
        if (this.zzhj != null) {
            this.zzhj.add(zzv);
            AppMethodBeat.o(100743);
        } else if (this.value instanceof zzt) {
            byte[] bArr = zzv.zzhm;
            zzk zza = zzk.zza(bArr, 0, bArr.length);
            int zzk = zza.zzk();
            if (zzk != bArr.length - zzl.zzi(zzk)) {
                zzs zzu = zzs.zzu();
                AppMethodBeat.o(100743);
                throw zzu;
            }
            zzt zza2 = ((zzt) this.value).zza(zza);
            this.zzhi = this.zzhi;
            this.value = zza2;
            this.zzhj = null;
            AppMethodBeat.o(100743);
        } else if (this.value instanceof zzt[]) {
            Collections.singletonList(zzv);
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.o(100743);
            throw noSuchMethodError;
        } else {
            Collections.singletonList(zzv);
            NoSuchMethodError noSuchMethodError2 = new NoSuchMethodError();
            AppMethodBeat.o(100743);
            throw noSuchMethodError2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzg() {
        AppMethodBeat.i(100744);
        int i2 = 0;
        if (this.value != null) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            AppMethodBeat.o(100744);
            throw noSuchMethodError;
        }
        for (zzv zzv : this.zzhj) {
            i2 = zzv.zzhm.length + zzl.zzm(zzv.tag) + 0 + i2;
        }
        AppMethodBeat.o(100744);
        return i2;
    }
}
