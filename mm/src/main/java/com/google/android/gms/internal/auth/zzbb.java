package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzbb extends zze implements zzba {
    public zzbb() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zze
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 1:
                zzd((Status) zzf.zzd(parcel, Status.CREATOR), (Credential) zzf.zzd(parcel, Credential.CREATOR));
                break;
            case 2:
                zze((Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            case 3:
                zzd((Status) zzf.zzd(parcel, Status.CREATOR), parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
