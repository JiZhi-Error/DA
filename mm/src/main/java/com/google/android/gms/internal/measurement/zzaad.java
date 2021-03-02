package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaad implements zzaaw {
    private static final zzaak zzbte = new zzaae();
    private final zzaak zzbtd;

    static {
        AppMethodBeat.i(40124);
        AppMethodBeat.o(40124);
    }

    public zzaad() {
        this(new zzaaf(zzzp.zztl(), zzts()));
        AppMethodBeat.i(40119);
        AppMethodBeat.o(40119);
    }

    private zzaad(zzaak zzaak) {
        AppMethodBeat.i(40120);
        this.zzbtd = (zzaak) zzzr.zza(zzaak, "messageInfoFactory");
        AppMethodBeat.o(40120);
    }

    private static boolean zza(zzaaj zzaaj) {
        AppMethodBeat.i(40122);
        if (zzaaj.zztw() == zzzq.zzb.zzbsk) {
            AppMethodBeat.o(40122);
            return true;
        }
        AppMethodBeat.o(40122);
        return false;
    }

    private static zzaak zzts() {
        AppMethodBeat.i(40123);
        try {
            zzaak zzaak = (zzaak) Class.forName("com.google.a.j").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.o(40123);
            return zzaak;
        } catch (Exception e2) {
            zzaak zzaak2 = zzbte;
            AppMethodBeat.o(40123);
            return zzaak2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaaw
    public final <T> zzaav<T> zzg(Class<T> cls) {
        AppMethodBeat.i(40121);
        zzaax.zzh(cls);
        zzaaj zze = this.zzbtd.zze(cls);
        if (zze.zztx()) {
            if (zzzq.class.isAssignableFrom(cls)) {
                zzaap zza = zzaap.zza(zzaax.zzug(), zzzl.zztg(), zze.zzty());
                AppMethodBeat.o(40121);
                return zza;
            }
            zzaap zza2 = zzaap.zza(zzaax.zzue(), zzzl.zzth(), zze.zzty());
            AppMethodBeat.o(40121);
            return zza2;
        } else if (zzzq.class.isAssignableFrom(cls)) {
            if (zza(zze)) {
                zzaao zza3 = zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), zzzl.zztg(), zzaai.zztu());
                AppMethodBeat.o(40121);
                return zza3;
            }
            zzaao zza4 = zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), null, zzaai.zztu());
            AppMethodBeat.o(40121);
            return zza4;
        } else if (zza(zze)) {
            zzaao zza5 = zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzue(), zzzl.zzth(), zzaai.zztt());
            AppMethodBeat.o(40121);
            return zza5;
        } else {
            zzaao zza6 = zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzuf(), null, zzaai.zztt());
            AppMethodBeat.o(40121);
            return zza6;
        }
    }
}
