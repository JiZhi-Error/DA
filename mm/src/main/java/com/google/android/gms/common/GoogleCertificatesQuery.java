package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public class GoogleCertificatesQuery extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleCertificatesQuery> CREATOR = new GoogleCertificatesQueryCreator();
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String zzbh;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    private final GoogleCertificates.CertData zzbi;
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzbj;

    static {
        AppMethodBeat.i(4411);
        AppMethodBeat.o(4411);
    }

    @SafeParcelable.Constructor
    GoogleCertificatesQuery(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z) {
        AppMethodBeat.i(4407);
        this.zzbh = str;
        this.zzbi = zza(iBinder);
        this.zzbj = z;
        AppMethodBeat.o(4407);
    }

    GoogleCertificatesQuery(String str, @Nullable GoogleCertificates.CertData certData, boolean z) {
        this.zzbh = str;
        this.zzbi = certData;
        this.zzbj = z;
    }

    @Nullable
    private static GoogleCertificates.CertData zza(@Nullable IBinder iBinder) {
        AppMethodBeat.i(4410);
        if (iBinder == null) {
            AppMethodBeat.o(4410);
            return null;
        }
        try {
            IObjectWrapper bytesWrapped = ICertData.Stub.asInterface(iBinder).getBytesWrapped();
            byte[] bArr = bytesWrapped == null ? null : (byte[]) ObjectWrapper.unwrap(bytesWrapped);
            zzb zzb = bArr != null ? new zzb(bArr) : null;
            AppMethodBeat.o(4410);
            return zzb;
        } catch (RemoteException e2) {
            AppMethodBeat.o(4410);
            return null;
        }
    }

    public boolean getAllowTestKeys() {
        return this.zzbj;
    }

    @Nullable
    public IBinder getCallingCertificateBinder() {
        AppMethodBeat.i(4408);
        if (this.zzbi == null) {
            AppMethodBeat.o(4408);
            return null;
        }
        IBinder asBinder = this.zzbi.asBinder();
        AppMethodBeat.o(4408);
        return asBinder;
    }

    public String getCallingPackage() {
        return this.zzbh;
    }

    @Nullable
    public GoogleCertificates.CertData getCertificate() {
        return this.zzbi;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4409);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCallingPackage(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, getCallingCertificateBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, getAllowTestKeys());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4409);
    }
}
