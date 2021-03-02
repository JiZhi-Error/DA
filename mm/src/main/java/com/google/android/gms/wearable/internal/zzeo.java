package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzeo extends zza implements zzem {
    zzeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void onConnectedNodes(List<zzfo> list) {
        AppMethodBeat.i(101235);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeTypedList(list);
        transactOneway(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101235);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(DataHolder dataHolder) {
        AppMethodBeat.i(101231);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, dataHolder);
        transactOneway(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101231);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzah zzah) {
        AppMethodBeat.i(101238);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzah);
        transactOneway(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101238);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzaw zzaw) {
        AppMethodBeat.i(101237);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzaw);
        transactOneway(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101237);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzfe zzfe) {
        AppMethodBeat.i(101232);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfe);
        transactOneway(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101232);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzfo zzfo) {
        AppMethodBeat.i(101233);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfo);
        transactOneway(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101233);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzi zzi) {
        AppMethodBeat.i(101239);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzi);
        transactOneway(9, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101239);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzl zzl) {
        AppMethodBeat.i(101236);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzl);
        transactOneway(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101236);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zzb(zzfo zzfo) {
        AppMethodBeat.i(101234);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzfo);
        transactOneway(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101234);
    }
}
