package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new e();
    @SafeParcelable.Field(id = 2)
    Bundle bMT;
    private Map<String, String> bMU;

    static {
        AppMethodBeat.i(116787);
        AppMethodBeat.o(116787);
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.bMT = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(116786);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.bMT, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(116786);
    }

    public final Map<String, String> yA() {
        AppMethodBeat.i(201779);
        if (this.bMU == null) {
            this.bMU = new a();
            for (String str : this.bMT.keySet()) {
                Object obj = this.bMT.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        this.bMU.put(str, str2);
                    }
                }
            }
        }
        Map<String, String> map = this.bMU;
        AppMethodBeat.o(201779);
        return map;
    }
}
