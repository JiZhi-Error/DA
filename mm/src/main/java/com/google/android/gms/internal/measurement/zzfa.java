package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class zzfa extends zzn implements zzey {
    zzfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        AppMethodBeat.i(1287);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzjx.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(1287);
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        AppMethodBeat.i(1295);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzed.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(1295);
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(1294);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzjx.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(1294);
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        AppMethodBeat.i(1293);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzp.zza(obtainAndWriteInterfaceToken, z);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzjx.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(1293);
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(long j2, String str, String str2, String str3) {
        AppMethodBeat.i(1289);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j2);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1289);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzdz zzdz) {
        AppMethodBeat.i(1284);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1284);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzed zzed, zzdz zzdz) {
        AppMethodBeat.i(1291);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzed);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1291);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.i(1282);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzeu);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1282);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzeu zzeu, String str, String str2) {
        AppMethodBeat.i(1285);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzeu);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1285);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zza(zzjx zzjx, zzdz zzdz) {
        AppMethodBeat.i(1283);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzjx);
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1283);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final byte[] zza(zzeu zzeu, String str) {
        AppMethodBeat.i(1288);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzeu);
        obtainAndWriteInterfaceToken.writeString(str);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        byte[] createByteArray = transactAndReadException.createByteArray();
        transactAndReadException.recycle();
        AppMethodBeat.o(1288);
        return createByteArray;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zzb(zzdz zzdz) {
        AppMethodBeat.i(1286);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1286);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zzb(zzed zzed) {
        AppMethodBeat.i(1292);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzed);
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1292);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final String zzc(zzdz zzdz) {
        AppMethodBeat.i(1290);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        AppMethodBeat.o(1290);
        return readString;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final void zzd(zzdz zzdz) {
        AppMethodBeat.i(1297);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzp.zza(obtainAndWriteInterfaceToken, zzdz);
        transactAndReadExceptionReturnVoid(18, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(1297);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final List<zzed> zze(String str, String str2, String str3) {
        AppMethodBeat.i(1296);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzed.CREATOR);
        transactAndReadException.recycle();
        AppMethodBeat.o(1296);
        return createTypedArrayList;
    }
}
