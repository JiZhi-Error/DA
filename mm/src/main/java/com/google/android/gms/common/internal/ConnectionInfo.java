package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
public class ConnectionInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionInfo> CREATOR = new ConnectionInfoCreator();
    @SafeParcelable.Field(id = 1)
    private Bundle zzsf;
    @SafeParcelable.Field(id = 2)
    private Feature[] zzsg;

    static {
        AppMethodBeat.i(4608);
        AppMethodBeat.o(4608);
    }

    public ConnectionInfo() {
    }

    @SafeParcelable.Constructor
    ConnectionInfo(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) Feature[] featureArr) {
        this.zzsf = bundle;
        this.zzsg = featureArr;
    }

    public Feature[] getAvailableFeatures() {
        return this.zzsg;
    }

    public Bundle getResolutionBundle() {
        return this.zzsf;
    }

    public ConnectionInfo setAvailableFeatures(Feature[] featureArr) {
        this.zzsg = featureArr;
        return this;
    }

    public ConnectionInfo setResolutionBundle(Bundle bundle) {
        this.zzsf = bundle;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4607);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzsf, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzsg, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4607);
    }
}
