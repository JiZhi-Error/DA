package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "isLockScreenSolved", id = 2)
    private boolean zzcc;
    @SafeParcelable.Field(getter = "getMinAgeOfLockScreen", id = 3)
    private long zzcd;
    @SafeParcelable.Field(getter = "isChallengeAllowed", id = 4)
    private final boolean zzce;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10650);
        AppMethodBeat.o(10650);
    }

    @SafeParcelable.Constructor
    DeviceMetaData(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) boolean z2) {
        this.zzy = i2;
        this.zzcc = z;
        this.zzcd = j2;
        this.zzce = z2;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzcd;
    }

    public boolean isChallengeAllowed() {
        return this.zzce;
    }

    public boolean isLockScreenSolved() {
        return this.zzcc;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10649);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10649);
    }
}
