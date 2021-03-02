package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzbj extends zze implements zzbi {
    public zzbj() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zze
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 1:
                zzd((ProxyResponse) zzf.zzd(parcel, ProxyResponse.CREATOR));
                break;
            case 2:
                zzf(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
