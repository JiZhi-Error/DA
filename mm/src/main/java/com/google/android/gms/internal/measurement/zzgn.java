package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class zzgn extends zzez {
    private final zzjr zzajp;
    private Boolean zzanc;
    private String zzand;

    public zzgn(zzjr zzjr) {
        this(zzjr, null);
    }

    private zzgn(zzjr zzjr, String str) {
        AppMethodBeat.i(1613);
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
        this.zzand = null;
        AppMethodBeat.o(1613);
    }

    private final void zzb(zzdz zzdz, boolean z) {
        AppMethodBeat.i(1621);
        Preconditions.checkNotNull(zzdz);
        zzc(zzdz.packageName, false);
        this.zzajp.zzgb().zzcg(zzdz.zzadm);
        AppMethodBeat.o(1621);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        if (r5.zzanc.booleanValue() == false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(java.lang.String r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgn.zzc(java.lang.String, boolean):void");
    }

    @VisibleForTesting
    private final void zze(Runnable runnable) {
        AppMethodBeat.i(1632);
        Preconditions.checkNotNull(runnable);
        if (!zzew.zzaia.get().booleanValue() || !this.zzajp.zzgd().zzjk()) {
            this.zzajp.zzgd().zzc(runnable);
            AppMethodBeat.o(1632);
            return;
        }
        runnable.run();
        AppMethodBeat.o(1632);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        AppMethodBeat.i(1619);
        zzb(zzdz, false);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzhd(this, zzdz)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            AppMethodBeat.o(1619);
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(zzdz.packageName), e2);
            AppMethodBeat.o(1619);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        AppMethodBeat.i(1629);
        zzb(zzdz, false);
        try {
            List<zzed> list = (List) this.zzajp.zzgd().zzb(new zzgv(this, zzdz, str, str2)).get();
            AppMethodBeat.o(1629);
            return list;
        } catch (InterruptedException | ExecutionException e2) {
            this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", e2);
            List<zzed> emptyList = Collections.emptyList();
            AppMethodBeat.o(1629);
            return emptyList;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(1628);
        zzc(str, true);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzgu(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            AppMethodBeat.o(1628);
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(str), e2);
            List<zzjx> emptyList = Collections.emptyList();
            AppMethodBeat.o(1628);
            return emptyList;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        AppMethodBeat.i(1627);
        zzb(zzdz, false);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzgt(this, zzdz, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            AppMethodBeat.o(1627);
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(zzdz.packageName), e2);
            List<zzjx> emptyList = Collections.emptyList();
            AppMethodBeat.o(1627);
            return emptyList;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(long j2, String str, String str2, String str3) {
        AppMethodBeat.i(1623);
        zze(new zzhf(this, str2, str3, str, j2));
        AppMethodBeat.o(1623);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzdz zzdz) {
        AppMethodBeat.i(1620);
        zzb(zzdz, false);
        zze(new zzhe(this, zzdz));
        AppMethodBeat.o(1620);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzed zzed, zzdz zzdz) {
        AppMethodBeat.i(1625);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotNull(zzed.zzaep);
        zzb(zzdz, false);
        zzed zzed2 = new zzed(zzed);
        zzed2.packageName = zzdz.packageName;
        if (zzed.zzaep.getValue() == null) {
            zze(new zzgp(this, zzed2, zzdz));
            AppMethodBeat.o(1625);
            return;
        }
        zze(new zzgq(this, zzed2, zzdz));
        AppMethodBeat.o(1625);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.i(1615);
        Preconditions.checkNotNull(zzeu);
        zzb(zzdz, false);
        zze(new zzgy(this, zzeu, zzdz));
        AppMethodBeat.o(1615);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzeu zzeu, String str, String str2) {
        AppMethodBeat.i(1616);
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzc(str, true);
        zze(new zzgz(this, zzeu, str));
        AppMethodBeat.o(1616);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzjx zzjx, zzdz zzdz) {
        AppMethodBeat.i(1618);
        Preconditions.checkNotNull(zzjx);
        zzb(zzdz, false);
        if (zzjx.getValue() == null) {
            zze(new zzhb(this, zzjx, zzdz));
            AppMethodBeat.o(1618);
            return;
        }
        zze(new zzhc(this, zzjx, zzdz));
        AppMethodBeat.o(1618);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final byte[] zza(zzeu zzeu, String str) {
        AppMethodBeat.i(1617);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeu);
        zzc(str, true);
        this.zzajp.zzge().zzis().zzg("Log and bundle. event", this.zzajp.zzga().zzbj(zzeu.name));
        long nanoTime = this.zzajp.zzbt().nanoTime() / TimeUtil.SECOND_TO_US;
        try {
            byte[] bArr = (byte[]) this.zzajp.zzgd().zzc(new zzha(this, zzeu, str)).get();
            if (bArr == null) {
                this.zzajp.zzge().zzim().zzg("Log and bundle returned null. appId", zzfg.zzbm(str));
                bArr = new byte[0];
            }
            this.zzajp.zzge().zzis().zzd("Log and bundle processed. event, size, time_ms", this.zzajp.zzga().zzbj(zzeu.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzajp.zzbt().nanoTime() / TimeUtil.SECOND_TO_US) - nanoTime));
            AppMethodBeat.o(1617);
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.zzajp.zzge().zzim().zzd("Failed to log and bundle. appId, event, error", zzfg.zzbm(str), this.zzajp.zzga().zzbj(zzeu.name), e2);
            AppMethodBeat.o(1617);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zzb(zzdz zzdz) {
        AppMethodBeat.i(1614);
        zzb(zzdz, false);
        zze(new zzgo(this, zzdz));
        AppMethodBeat.o(1614);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zzb(zzed zzed) {
        AppMethodBeat.i(1626);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotNull(zzed.zzaep);
        zzc(zzed.packageName, true);
        zzed zzed2 = new zzed(zzed);
        if (zzed.zzaep.getValue() == null) {
            zze(new zzgr(this, zzed2));
            AppMethodBeat.o(1626);
            return;
        }
        zze(new zzgs(this, zzed2));
        AppMethodBeat.o(1626);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final String zzc(zzdz zzdz) {
        AppMethodBeat.i(1624);
        zzb(zzdz, false);
        String zzh = this.zzajp.zzh(zzdz);
        AppMethodBeat.o(1624);
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zzd(zzdz zzdz) {
        AppMethodBeat.i(1631);
        zzc(zzdz.packageName, false);
        zze(new zzgx(this, zzdz));
        AppMethodBeat.o(1631);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzed> zze(String str, String str2, String str3) {
        AppMethodBeat.i(1630);
        zzc(str, true);
        try {
            List<zzed> list = (List) this.zzajp.zzgd().zzb(new zzgw(this, str, str2, str3)).get();
            AppMethodBeat.o(1630);
            return list;
        } catch (InterruptedException | ExecutionException e2) {
            this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", e2);
            List<zzed> emptyList = Collections.emptyList();
            AppMethodBeat.o(1630);
            return emptyList;
        }
    }
}
