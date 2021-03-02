package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaby;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzabz<M extends zzaby<M>, T> {
    public final int tag;
    private final int type;
    protected final Class<T> zzbwx;
    protected final boolean zzbwy;
    private final zzzq<?, ?> zzbwz;

    private zzabz(int i2, Class<T> cls, int i3, boolean z) {
        this(11, cls, null, 810, false);
    }

    private zzabz(int i2, Class<T> cls, zzzq<?, ?> zzzq, int i3, boolean z) {
        this.type = i2;
        this.zzbwx = cls;
        this.tag = i3;
        this.zzbwy = false;
        this.zzbwz = null;
    }

    public static <M extends zzaby<M>, T extends zzace> zzabz<M, T> zza(int i2, Class<T> cls, long j2) {
        AppMethodBeat.i(40271);
        zzabz<M, T> zzabz = new zzabz<>(11, cls, 810, false);
        AppMethodBeat.o(40271);
        return zzabz;
    }

    private final Object zzf(zzabv zzabv) {
        AppMethodBeat.i(40274);
        Class<?> componentType = this.zzbwy ? this.zzbwx.getComponentType() : this.zzbwx;
        try {
            switch (this.type) {
                case 10:
                    T newInstance = componentType.newInstance();
                    zzabv.zza(newInstance, this.tag >>> 3);
                    AppMethodBeat.o(40274);
                    return newInstance;
                case 11:
                    T newInstance2 = componentType.newInstance();
                    zzabv.zza(newInstance2);
                    AppMethodBeat.o(40274);
                    return newInstance2;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                    AppMethodBeat.o(40274);
                    throw illegalArgumentException;
            }
        } catch (InstantiationException e2) {
            String valueOf = String.valueOf(componentType);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
            AppMethodBeat.o(40274);
            throw illegalArgumentException2;
        } catch (IllegalAccessException e3) {
            String valueOf2 = String.valueOf(componentType);
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e3);
            AppMethodBeat.o(40274);
            throw illegalArgumentException3;
        } catch (IOException e4) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Error reading extension field", e4);
            AppMethodBeat.o(40274);
            throw illegalArgumentException4;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzabz)) {
            return false;
        }
        zzabz zzabz = (zzabz) obj;
        return this.type == zzabz.type && this.zzbwx == zzabz.zzbwx && this.tag == zzabz.tag && this.zzbwy == zzabz.zzbwy;
    }

    public final int hashCode() {
        AppMethodBeat.i(40272);
        int hashCode = (this.zzbwy ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zzbwx.hashCode()) * 31) + this.tag) * 31);
        AppMethodBeat.o(40272);
        return hashCode;
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, zzabw zzabw) {
        AppMethodBeat.i(40275);
        try {
            zzabw.zzar(this.tag);
            switch (this.type) {
                case 10:
                    ((zzace) obj).zza(zzabw);
                    zzabw.zzg(this.tag >>> 3, 4);
                    AppMethodBeat.o(40275);
                    return;
                case 11:
                    zzabw.zzb((zzace) obj);
                    AppMethodBeat.o(40275);
                    return;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                    AppMethodBeat.o(40275);
                    throw illegalArgumentException;
            }
        } catch (IOException e2) {
            IllegalStateException illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.o(40275);
            throw illegalStateException;
        }
    }

    /* access modifiers changed from: package-private */
    public final T zzi(List<zzacg> list) {
        AppMethodBeat.i(40273);
        if (list == null) {
            AppMethodBeat.o(40273);
            return null;
        } else if (this.zzbwy) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzacg zzacg = list.get(i2);
                if (zzacg.zzbrc.length != 0) {
                    arrayList.add(zzf(zzabv.zzi(zzacg.zzbrc)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                AppMethodBeat.o(40273);
                return null;
            }
            T cast = this.zzbwx.cast(Array.newInstance(this.zzbwx.getComponentType(), size));
            for (int i3 = 0; i3 < size; i3++) {
                Array.set(cast, i3, arrayList.get(i3));
            }
            AppMethodBeat.o(40273);
            return cast;
        } else if (list.isEmpty()) {
            AppMethodBeat.o(40273);
            return null;
        } else {
            T cast2 = this.zzbwx.cast(zzf(zzabv.zzi(list.get(list.size() - 1).zzbrc)));
            AppMethodBeat.o(40273);
            return cast2;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzv(Object obj) {
        AppMethodBeat.i(40276);
        int i2 = this.tag >>> 3;
        switch (this.type) {
            case 10:
                int zzaq = (zzabw.zzaq(i2) << 1) + ((zzace) obj).zzvm();
                AppMethodBeat.o(40276);
                return zzaq;
            case 11:
                int zzb = zzabw.zzb(i2, (zzace) obj);
                AppMethodBeat.o(40276);
                return zzb;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
                AppMethodBeat.o(40276);
                throw illegalArgumentException;
        }
    }
}
