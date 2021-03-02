package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import java.util.List;

public abstract class zzez extends zzo implements zzey {
    public zzez() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzo
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 1:
                zza((zzeu) zzp.zza(parcel, zzeu.CREATOR), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zza((zzjx) zzp.zza(parcel, zzjx.CREATOR), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                zza((zzeu) zzp.zza(parcel, zzeu.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zzb((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                List<zzjx> zza = zza((zzdz) zzp.zza(parcel, zzdz.CREATOR), zzp.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 9:
                byte[] zza2 = zza((zzeu) zzp.zza(parcel, zzeu.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                break;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String zzc = zzc((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            case 12:
                zza((zzed) zzp.zza(parcel, zzed.CREATOR), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzb((zzed) zzp.zza(parcel, zzed.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                List<zzjx> zza3 = zza(parcel.readString(), parcel.readString(), zzp.zza(parcel), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                break;
            case 15:
                List<zzjx> zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzp.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                break;
            case 16:
                List<zzed> zza5 = zza(parcel.readString(), parcel.readString(), (zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                break;
            case 17:
                List<zzed> zze = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zze);
                break;
            case 18:
                zzd((zzdz) zzp.zza(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                break;
        }
        return true;
    }
}
