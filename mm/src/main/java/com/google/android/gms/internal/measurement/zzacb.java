package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzacb implements Cloneable {
    private Object value;
    private zzabz<?, ?> zzbxe;
    private List<zzacg> zzbxf = new ArrayList();

    zzacb() {
        AppMethodBeat.i(40284);
        AppMethodBeat.o(40284);
    }

    private final byte[] toByteArray() {
        AppMethodBeat.i(40291);
        byte[] bArr = new byte[zza()];
        zza(zzabw.zzj(bArr));
        AppMethodBeat.o(40291);
        return bArr;
    }

    private final zzacb zzvg() {
        int i2 = 0;
        AppMethodBeat.i(40292);
        zzacb zzacb = new zzacb();
        try {
            zzacb.zzbxe = this.zzbxe;
            if (this.zzbxf == null) {
                zzacb.zzbxf = null;
            } else {
                zzacb.zzbxf.addAll(this.zzbxf);
            }
            if (this.value != null) {
                if (this.value instanceof zzace) {
                    zzacb.value = (zzace) ((zzace) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzacb.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzacb.value = bArr2;
                    while (i2 < bArr.length) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                        i2++;
                    }
                } else if (this.value instanceof boolean[]) {
                    zzacb.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzacb.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzacb.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzacb.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzacb.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzace[]) {
                    zzace[] zzaceArr = (zzace[]) this.value;
                    zzace[] zzaceArr2 = new zzace[zzaceArr.length];
                    zzacb.value = zzaceArr2;
                    while (i2 < zzaceArr.length) {
                        zzaceArr2[i2] = (zzace) zzaceArr[i2].clone();
                        i2++;
                    }
                }
            }
            AppMethodBeat.o(40292);
            return zzacb;
        } catch (CloneNotSupportedException e2) {
            AssertionError assertionError = new AssertionError(e2);
            AppMethodBeat.o(40292);
            throw assertionError;
        }
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(40293);
        zzacb zzvg = zzvg();
        AppMethodBeat.o(40293);
        return zzvg;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40289);
        if (obj == this) {
            AppMethodBeat.o(40289);
            return true;
        } else if (!(obj instanceof zzacb)) {
            AppMethodBeat.o(40289);
            return false;
        } else {
            zzacb zzacb = (zzacb) obj;
            if (this.value == null || zzacb.value == null) {
                if (this.zzbxf == null || zzacb.zzbxf == null) {
                    try {
                        boolean equals = Arrays.equals(toByteArray(), zzacb.toByteArray());
                        AppMethodBeat.o(40289);
                        return equals;
                    } catch (IOException e2) {
                        IllegalStateException illegalStateException = new IllegalStateException(e2);
                        AppMethodBeat.o(40289);
                        throw illegalStateException;
                    }
                } else {
                    boolean equals2 = this.zzbxf.equals(zzacb.zzbxf);
                    AppMethodBeat.o(40289);
                    return equals2;
                }
            } else if (this.zzbxe != zzacb.zzbxe) {
                AppMethodBeat.o(40289);
                return false;
            } else if (!this.zzbxe.zzbwx.isArray()) {
                boolean equals3 = this.value.equals(zzacb.value);
                AppMethodBeat.o(40289);
                return equals3;
            } else if (this.value instanceof byte[]) {
                boolean equals4 = Arrays.equals((byte[]) this.value, (byte[]) zzacb.value);
                AppMethodBeat.o(40289);
                return equals4;
            } else if (this.value instanceof int[]) {
                boolean equals5 = Arrays.equals((int[]) this.value, (int[]) zzacb.value);
                AppMethodBeat.o(40289);
                return equals5;
            } else if (this.value instanceof long[]) {
                boolean equals6 = Arrays.equals((long[]) this.value, (long[]) zzacb.value);
                AppMethodBeat.o(40289);
                return equals6;
            } else if (this.value instanceof float[]) {
                boolean equals7 = Arrays.equals((float[]) this.value, (float[]) zzacb.value);
                AppMethodBeat.o(40289);
                return equals7;
            } else if (this.value instanceof double[]) {
                boolean equals8 = Arrays.equals((double[]) this.value, (double[]) zzacb.value);
                AppMethodBeat.o(40289);
                return equals8;
            } else if (this.value instanceof boolean[]) {
                boolean equals9 = Arrays.equals((boolean[]) this.value, (boolean[]) zzacb.value);
                AppMethodBeat.o(40289);
                return equals9;
            } else {
                boolean deepEquals = Arrays.deepEquals((Object[]) this.value, (Object[]) zzacb.value);
                AppMethodBeat.o(40289);
                return deepEquals;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(40290);
        try {
            int hashCode = Arrays.hashCode(toByteArray()) + JsApiGetABTestConfig.CTRL_INDEX;
            AppMethodBeat.o(40290);
            return hashCode;
        } catch (IOException e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.o(40290);
            throw illegalStateException;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(40287);
        if (this.value != null) {
            zzabz<?, ?> zzabz = this.zzbxe;
            Object obj = this.value;
            if (zzabz.zzbwy) {
                int length = Array.getLength(obj);
                i2 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (Array.get(obj, i4) != null) {
                        i2 += zzabz.zzv(Array.get(obj, i4));
                    }
                }
            } else {
                i2 = zzabz.zzv(obj);
            }
        } else {
            for (zzacg zzacg : this.zzbxf) {
                i3 = zzacg.zzbrc.length + zzabw.zzas(zzacg.tag) + 0 + i3;
            }
            i2 = i3;
        }
        AppMethodBeat.o(40287);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(40288);
        if (this.value != null) {
            zzabz<?, ?> zzabz = this.zzbxe;
            Object obj = this.value;
            if (zzabz.zzbwy) {
                int length = Array.getLength(obj);
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj2 = Array.get(obj, i2);
                    if (obj2 != null) {
                        zzabz.zza(obj2, zzabw);
                    }
                }
                AppMethodBeat.o(40288);
                return;
            }
            zzabz.zza(obj, zzabw);
            AppMethodBeat.o(40288);
            return;
        }
        for (zzacg zzacg : this.zzbxf) {
            zzabw.zzar(zzacg.tag);
            zzabw.zzk(zzacg.zzbrc);
        }
        AppMethodBeat.o(40288);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzacg zzacg) {
        Object zzi;
        AppMethodBeat.i(40285);
        if (this.zzbxf != null) {
            this.zzbxf.add(zzacg);
            AppMethodBeat.o(40285);
            return;
        }
        if (this.value instanceof zzace) {
            byte[] bArr = zzacg.zzbrc;
            zzabv zza = zzabv.zza(bArr, 0, bArr.length);
            int zzuy = zza.zzuy();
            if (zzuy != bArr.length - zzabw.zzao(zzuy)) {
                zzacd zzvh = zzacd.zzvh();
                AppMethodBeat.o(40285);
                throw zzvh;
            }
            zzi = ((zzace) this.value).zzb(zza);
        } else if (this.value instanceof zzace[]) {
            zzace[] zzaceArr = (zzace[]) this.zzbxe.zzi(Collections.singletonList(zzacg));
            zzace[] zzaceArr2 = (zzace[]) this.value;
            zzi = (zzace[]) Arrays.copyOf(zzaceArr2, zzaceArr2.length + zzaceArr.length);
            System.arraycopy(zzaceArr, 0, zzi, zzaceArr2.length, zzaceArr.length);
        } else {
            zzi = this.zzbxe.zzi(Collections.singletonList(zzacg));
        }
        this.zzbxe = this.zzbxe;
        this.value = zzi;
        this.zzbxf = null;
        AppMethodBeat.o(40285);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.measurement.zzabz<?, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public final <T> T zzb(zzabz<?, T> zzabz) {
        AppMethodBeat.i(40286);
        if (this.value == null) {
            this.zzbxe = zzabz;
            this.value = zzabz.zzi(this.zzbxf);
            this.zzbxf = null;
        } else if (!this.zzbxe.equals(zzabz)) {
            IllegalStateException illegalStateException = new IllegalStateException("Tried to getExtension with a different Extension.");
            AppMethodBeat.o(40286);
            throw illegalStateException;
        }
        T t = (T) this.value;
        AppMethodBeat.o(40286);
        return t;
    }
}
