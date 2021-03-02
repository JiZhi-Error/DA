package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new ClientIdentityCreator();
    @SafeParcelable.Field(defaultValueUnchecked = BuildConfig.COMMAND, id = 2)
    public final String packageName;
    @SafeParcelable.Field(defaultValueUnchecked = AppEventsConstants.EVENT_PARAM_VALUE_NO, id = 1)
    public final int uid;

    static {
        AppMethodBeat.i(11804);
        AppMethodBeat.o(11804);
    }

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        this.uid = i2;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(11801);
        if (obj == this) {
            AppMethodBeat.o(11801);
            return true;
        } else if (obj == null || !(obj instanceof ClientIdentity)) {
            AppMethodBeat.o(11801);
            return false;
        } else {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.uid != this.uid || !Objects.equal(clientIdentity.packageName, this.packageName)) {
                AppMethodBeat.o(11801);
                return false;
            }
            AppMethodBeat.o(11801);
            return true;
        }
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        AppMethodBeat.i(11802);
        int i2 = this.uid;
        String str = this.packageName;
        String sb = new StringBuilder(String.valueOf(str).length() + 12).append(i2).append(":").append(str).toString();
        AppMethodBeat.o(11802);
        return sb;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11803);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.uid);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11803);
    }
}
