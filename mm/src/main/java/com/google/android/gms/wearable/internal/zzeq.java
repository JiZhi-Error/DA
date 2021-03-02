package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeq extends zza implements zzep {
    zzeq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek) {
        AppMethodBeat.i(101242);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101242);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, int i2) {
        AppMethodBeat.i(101250);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeInt(i2);
        transactAndReadExceptionReturnVoid(43, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101250);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, Uri uri) {
        AppMethodBeat.i(101241);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, uri);
        transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101241);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, Uri uri, int i2) {
        AppMethodBeat.i(101243);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, uri);
        obtainAndWriteInterfaceToken.writeInt(i2);
        transactAndReadExceptionReturnVoid(40, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101243);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, Asset asset) {
        AppMethodBeat.i(101246);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, asset);
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101246);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, PutDataRequest putDataRequest) {
        AppMethodBeat.i(101240);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, putDataRequest);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101240);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, zzd zzd) {
        AppMethodBeat.i(101253);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, zzd);
        transactAndReadExceptionReturnVoid(16, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101253);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, zzei zzei, String str) {
        AppMethodBeat.i(101258);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, zzei);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(34, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101258);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, zzfw zzfw) {
        AppMethodBeat.i(101254);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, zzfw);
        transactAndReadExceptionReturnVoid(17, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101254);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, String str) {
        AppMethodBeat.i(101251);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(46, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101251);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, String str, int i2) {
        AppMethodBeat.i(101249);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i2);
        transactAndReadExceptionReturnVoid(42, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101249);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, String str, ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(101260);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, parcelFileDescriptor);
        transactAndReadExceptionReturnVoid(38, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101260);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, String str, ParcelFileDescriptor parcelFileDescriptor, long j2, long j3) {
        AppMethodBeat.i(101261);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, parcelFileDescriptor);
        obtainAndWriteInterfaceToken.writeLong(j2);
        obtainAndWriteInterfaceToken.writeLong(j3);
        transactAndReadExceptionReturnVoid(39, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101261);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, String str, String str2) {
        AppMethodBeat.i(101255);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        transactAndReadExceptionReturnVoid(31, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101255);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzek, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(101245);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeByteArray(bArr);
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101245);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzb(zzek zzek) {
        AppMethodBeat.i(101247);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        transactAndReadExceptionReturnVoid(14, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101247);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzb(zzek zzek, Uri uri, int i2) {
        AppMethodBeat.i(101244);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, uri);
        obtainAndWriteInterfaceToken.writeInt(i2);
        transactAndReadExceptionReturnVoid(41, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101244);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzb(zzek zzek, zzei zzei, String str) {
        AppMethodBeat.i(101259);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        zzc.zza(obtainAndWriteInterfaceToken, zzei);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(35, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101259);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzb(zzek zzek, String str) {
        AppMethodBeat.i(101252);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(47, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101252);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzb(zzek zzek, String str, int i2) {
        AppMethodBeat.i(101257);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i2);
        transactAndReadExceptionReturnVoid(33, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101257);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzc(zzek zzek) {
        AppMethodBeat.i(101248);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        transactAndReadExceptionReturnVoid(15, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101248);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzc(zzek zzek, String str) {
        AppMethodBeat.i(101256);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, zzek);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(32, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(101256);
    }
}
