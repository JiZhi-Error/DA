package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zze;
import com.google.android.gms.internal.auth.zzf;

public abstract class zzu extends zze implements zzt {
    public zzu() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zze
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 101:
                zzd((GoogleSignInAccount) zzf.zzd(parcel, GoogleSignInAccount.CREATOR), (Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            case 102:
                zzg((Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            case 103:
                zzh((Status) zzf.zzd(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
