package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfc extends zzhh {
    private final zzfd zzaig = new zzfd(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaih;

    zzfc(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1325);
        AppMethodBeat.o(1325);
    }

    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() {
        AppMethodBeat.i(1332);
        if (this.zzaih) {
            AppMethodBeat.o(1332);
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzaig.getWritableDatabase();
        if (writableDatabase == null) {
            this.zzaih = true;
            AppMethodBeat.o(1332);
            return null;
        }
        AppMethodBeat.o(1332);
        return writableDatabase;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00eb, code lost:
        r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r14, byte[] r15) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zza(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1343);
        Context context = super.getContext();
        AppMethodBeat.o(1343);
        return context;
    }

    public final void resetAnalyticsData() {
        AppMethodBeat.i(1326);
        zzab();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzge().zzit().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
            AppMethodBeat.o(1326);
        } catch (SQLiteException e2) {
            zzge().zzim().zzg("Error resetting local analytics data. error", e2);
            AppMethodBeat.o(1326);
        }
    }

    public final boolean zza(zzeu zzeu) {
        AppMethodBeat.i(1328);
        Parcel obtain = Parcel.obtain();
        zzeu.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzge().zzip().log("Event is too long for local database. Sending event directly to service");
            AppMethodBeat.o(1328);
            return false;
        }
        boolean zza = zza(0, marshall);
        AppMethodBeat.o(1328);
        return zza;
    }

    public final boolean zza(zzjx zzjx) {
        AppMethodBeat.i(1329);
        Parcel obtain = Parcel.obtain();
        zzjx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzge().zzip().log("User property too long for local database. Sending directly to service");
            AppMethodBeat.o(1329);
            return false;
        }
        boolean zza = zza(1, marshall);
        AppMethodBeat.o(1329);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1335);
        super.zzab();
        AppMethodBeat.o(1335);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1342);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1342);
        return zzbt;
    }

    public final boolean zzc(zzed zzed) {
        AppMethodBeat.i(1330);
        zzgb();
        byte[] zza = zzka.zza(zzed);
        if (zza.length > 131072) {
            zzge().zzip().log("Conditional user property too long for local database. Sending directly to service");
            AppMethodBeat.o(1330);
            return false;
        }
        boolean zza2 = zza(2, zza);
        AppMethodBeat.o(1330);
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1333);
        super.zzfr();
        AppMethodBeat.o(1333);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1334);
        super.zzfs();
        AppMethodBeat.o(1334);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1336);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1336);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1337);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1337);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1338);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1338);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1339);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1339);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1340);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1340);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1341);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1341);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1344);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1344);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1345);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1345);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1346);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1346);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1347);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1347);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1348);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1348);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1349);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1349);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1350);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1350);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1351);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1351);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x00ce A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzp(int r14) {
        /*
        // Method dump skipped, instructions count: 598
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zzp(int):java.util.List");
    }
}
