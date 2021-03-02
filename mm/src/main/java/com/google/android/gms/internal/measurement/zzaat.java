package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzaat {
    private static final zzaat zzbtq = new zzaat();
    private final zzaaw zzbtr;
    private final ConcurrentMap<Class<?>, zzaav<?>> zzbts = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(40147);
        AppMethodBeat.o(40147);
    }

    private zzaat() {
        AppMethodBeat.i(40145);
        zzaaw zzaaw = null;
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        for (int i2 = 0; i2 <= 0; i2++) {
            zzaaw = zzfl(strArr[0]);
            if (zzaaw != null) {
                break;
            }
        }
        this.zzbtr = zzaaw == null ? new zzaad() : zzaaw;
        AppMethodBeat.o(40145);
    }

    private static zzaaw zzfl(String str) {
        AppMethodBeat.i(40146);
        try {
            zzaaw zzaaw = (zzaaw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(40146);
            return zzaaw;
        } catch (Throwable th) {
            AppMethodBeat.o(40146);
            return null;
        }
    }

    public static zzaat zzud() {
        return zzbtq;
    }

    public final <T> zzaav<T> zzt(T t) {
        AppMethodBeat.i(40144);
        Class<?> cls = t.getClass();
        zzzr.zza(cls, "messageType");
        zzaav<T> zzaav = (zzaav<T>) this.zzbts.get(cls);
        if (zzaav == null) {
            zzaav<?> zzg = this.zzbtr.zzg(cls);
            zzzr.zza(cls, "messageType");
            zzzr.zza(zzg, "schema");
            zzaav = (zzaav<T>) this.zzbts.putIfAbsent(cls, zzg);
            if (zzaav == null) {
                zzaav = (zzaav<T>) zzg;
            }
        }
        AppMethodBeat.o(40144);
        return zzaav;
    }
}
