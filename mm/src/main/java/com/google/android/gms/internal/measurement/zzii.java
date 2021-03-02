package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzii extends zzhh {
    private final zziw zzaox;
    private zzey zzaoy;
    private volatile Boolean zzaoz;
    private final zzem zzapa;
    private final zzjm zzapb;
    private final List<Runnable> zzapc = new ArrayList();
    private final zzem zzapd;

    protected zzii(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1799);
        this.zzapb = new zzjm(zzgl.zzbt());
        this.zzaox = new zziw(this);
        this.zzapa = new zzij(this, zzgl);
        this.zzapd = new zzio(this, zzgl);
        AppMethodBeat.o(1799);
    }

    private final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(1817);
        zzab();
        if (this.zzaoy != null) {
            this.zzaoy = null;
            zzge().zzit().zzg("Disconnected from device MeasurementService", componentName);
            zzab();
            zzdf();
        }
        AppMethodBeat.o(1817);
    }

    static /* synthetic */ void zza(zzii zzii, ComponentName componentName) {
        AppMethodBeat.i(1841);
        zzii.onServiceDisconnected(componentName);
        AppMethodBeat.o(1841);
    }

    static /* synthetic */ void zzb(zzii zzii) {
        AppMethodBeat.i(1842);
        zzii.zzkg();
        AppMethodBeat.o(1842);
    }

    static /* synthetic */ void zzc(zzii zzii) {
        AppMethodBeat.i(1843);
        zzii.zzcv();
        AppMethodBeat.o(1843);
    }

    private final void zzcu() {
        AppMethodBeat.i(1813);
        zzab();
        this.zzapb.start();
        this.zzapa.zzh(zzew.zzaho.get().longValue());
        AppMethodBeat.o(1813);
    }

    private final void zzcv() {
        AppMethodBeat.i(1818);
        zzab();
        if (!isConnected()) {
            AppMethodBeat.o(1818);
            return;
        }
        zzge().zzit().log("Inactivity, disconnecting from the service");
        disconnect();
        AppMethodBeat.o(1818);
    }

    static /* synthetic */ void zze(zzii zzii) {
        AppMethodBeat.i(1844);
        zzii.zzcu();
        AppMethodBeat.o(1844);
    }

    private final void zzf(Runnable runnable) {
        AppMethodBeat.i(1819);
        zzab();
        if (isConnected()) {
            runnable.run();
            AppMethodBeat.o(1819);
        } else if (((long) this.zzapc.size()) >= 1000) {
            zzge().zzim().log("Discarding data. Max runnable queue size reached");
            AppMethodBeat.o(1819);
        } else {
            this.zzapc.add(runnable);
            this.zzapd.zzh(Util.MILLSECONDS_OF_MINUTE);
            zzdf();
            AppMethodBeat.o(1819);
        }
    }

    private final zzdz zzk(boolean z) {
        AppMethodBeat.i(1821);
        zzdz zzbi = zzfv().zzbi(z ? zzge().zziv() : null);
        AppMethodBeat.o(1821);
        return zzbi;
    }

    private final void zzkg() {
        AppMethodBeat.i(1820);
        zzab();
        zzge().zzit().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapc.size()));
        for (Runnable runnable : this.zzapc) {
            try {
                runnable.run();
            } catch (Exception e2) {
                zzge().zzim().zzg("Task exception while flushing queue", e2);
            }
        }
        this.zzapc.clear();
        this.zzapd.cancel();
        AppMethodBeat.o(1820);
    }

    public final void disconnect() {
        AppMethodBeat.i(1816);
        zzab();
        zzch();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzaox);
        } catch (IllegalArgumentException | IllegalStateException e2) {
        }
        this.zzaoy = null;
        AppMethodBeat.o(1816);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1832);
        Context context = super.getContext();
        AppMethodBeat.o(1832);
        return context;
    }

    public final boolean isConnected() {
        AppMethodBeat.i(1800);
        zzab();
        zzch();
        if (this.zzaoy != null) {
            AppMethodBeat.o(1800);
            return true;
        }
        AppMethodBeat.o(1800);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void resetAnalyticsData() {
        AppMethodBeat.i(1809);
        zzab();
        zzch();
        zzdz zzk = zzk(false);
        zzfz().resetAnalyticsData();
        zzf(new zzik(this, zzk));
        AppMethodBeat.o(1809);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(zzey zzey) {
        AppMethodBeat.i(1815);
        zzab();
        Preconditions.checkNotNull(zzey);
        this.zzaoy = zzey;
        zzcu();
        zzkg();
        AppMethodBeat.o(1815);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzey zzey, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdz) {
        AppMethodBeat.i(1802);
        zzab();
        zzch();
        int i2 = 100;
        for (int i3 = 0; i3 < 1001 && i2 == 100; i3++) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zzp = zzfz().zzp(100);
            if (zzp != null) {
                arrayList.addAll(zzp);
                i2 = zzp.size();
            } else {
                i2 = 0;
            }
            if (abstractSafeParcelable != null && i2 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        zzey.zza((zzeu) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e2) {
                        zzge().zzim().zzg("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        zzey.zza((zzjx) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e3) {
                        zzge().zzim().zzg("Failed to send attribute to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        zzey.zza((zzed) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e4) {
                        zzge().zzim().zzg("Failed to send conditional property to the service", e4);
                    }
                } else {
                    zzge().zzim().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
        AppMethodBeat.o(1802);
    }

    public final void zza(AtomicReference<String> atomicReference) {
        AppMethodBeat.i(1810);
        zzab();
        zzch();
        zzf(new zzil(this, atomicReference, zzk(false)));
        AppMethodBeat.o(1810);
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        AppMethodBeat.i(1805);
        zzab();
        zzch();
        zzf(new zzis(this, atomicReference, str, str2, str3, zzk(false)));
        AppMethodBeat.o(1805);
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(1806);
        zzab();
        zzch();
        zzf(new zzit(this, atomicReference, str, str2, str3, z, zzk(false)));
        AppMethodBeat.o(1806);
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzjx>> atomicReference, boolean z) {
        AppMethodBeat.i(1808);
        zzab();
        zzch();
        zzf(new zziv(this, atomicReference, zzk(false), z));
        AppMethodBeat.o(1808);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1824);
        super.zzab();
        AppMethodBeat.o(1824);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzeu zzeu, String str) {
        AppMethodBeat.i(1803);
        Preconditions.checkNotNull(zzeu);
        zzab();
        zzch();
        zzf(new zziq(this, true, zzfz().zza(zzeu), zzeu, zzk(true), str));
        AppMethodBeat.o(1803);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzie zzie) {
        AppMethodBeat.i(1812);
        zzab();
        zzch();
        zzf(new zzin(this, zzie));
        AppMethodBeat.o(1812);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzjx zzjx) {
        AppMethodBeat.i(1807);
        zzab();
        zzch();
        zzf(new zziu(this, zzfz().zza(zzjx), zzjx, zzk(true)));
        AppMethodBeat.o(1807);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1831);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1831);
        return zzbt;
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzed zzed) {
        AppMethodBeat.i(1804);
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        zzf(new zzir(this, true, zzfz().zzc(zzed), new zzed(zzed), zzk(true), zzed));
        AppMethodBeat.o(1804);
    }

    /* access modifiers changed from: package-private */
    public final void zzdf() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(1814);
        zzab();
        zzch();
        if (isConnected()) {
            AppMethodBeat.o(1814);
            return;
        }
        if (this.zzaoz == null) {
            zzab();
            zzch();
            Boolean zzjb = zzgf().zzjb();
            if (zzjb == null || !zzjb.booleanValue()) {
                if (zzfv().zzik() != 1) {
                    zzge().zzit().log("Checking service availability");
                    int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzgb().getContext(), 12451);
                    switch (isGooglePlayServicesAvailable) {
                        case 0:
                            zzge().zzit().log("Service available");
                            z = true;
                            z2 = true;
                            break;
                        case 1:
                            zzge().zzit().log("Service missing");
                            z = false;
                            z2 = true;
                            break;
                        case 2:
                            zzge().zzis().log("Service container out of date");
                            if (zzgb().zzld() >= 12600) {
                                Boolean zzjb2 = zzgf().zzjb();
                                z = zzjb2 == null || zzjb2.booleanValue();
                                z2 = false;
                                break;
                            } else {
                                z = false;
                                z2 = true;
                                break;
                            }
                            break;
                        case 3:
                            zzge().zzip().log("Service disabled");
                            z = false;
                            z2 = false;
                            break;
                        case 9:
                            zzge().zzip().log("Service invalid");
                            z = false;
                            z2 = false;
                            break;
                        case 18:
                            zzge().zzip().log("Service updating");
                            z = true;
                            z2 = true;
                            break;
                        default:
                            zzge().zzip().zzg("Unexpected service status", Integer.valueOf(isGooglePlayServicesAvailable));
                            z = false;
                            z2 = false;
                            break;
                    }
                } else {
                    z = true;
                    z2 = true;
                }
                if (z2) {
                    zzgf().zzf(z);
                }
            } else {
                z = true;
            }
            this.zzaoz = Boolean.valueOf(z);
        }
        if (this.zzaoz.booleanValue()) {
            this.zzaox.zzkh();
            AppMethodBeat.o(1814);
            return;
        }
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            z3 = false;
        }
        if (z3) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.zzaox.zzc(intent);
            AppMethodBeat.o(1814);
            return;
        }
        zzge().zzim().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        AppMethodBeat.o(1814);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1822);
        super.zzfr();
        AppMethodBeat.o(1822);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1823);
        super.zzfs();
        AppMethodBeat.o(1823);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1825);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1825);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1826);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1826);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1827);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1827);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1828);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1828);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1829);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1829);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1830);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1830);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1833);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1833);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1834);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1834);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1835);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1835);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1836);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1836);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1837);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1837);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1838);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1838);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1839);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1839);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1840);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1840);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void zzkb() {
        AppMethodBeat.i(1811);
        zzab();
        zzch();
        zzf(new zzim(this, zzk(true)));
        AppMethodBeat.o(1811);
    }

    /* access modifiers changed from: protected */
    public final void zzke() {
        AppMethodBeat.i(1801);
        zzab();
        zzch();
        zzf(new zzip(this, zzk(true)));
        AppMethodBeat.o(1801);
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzkf() {
        return this.zzaoz;
    }
}
