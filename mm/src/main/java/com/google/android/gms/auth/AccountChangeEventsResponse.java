package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator = "AccountChangeEventsResponseCreator")
public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzf();
    @SafeParcelable.VersionField(id = 1)
    private final int zzh;
    @SafeParcelable.Field(id = 2)
    private final List<AccountChangeEvent> zzo;

    static {
        AppMethodBeat.i(10593);
        AppMethodBeat.o(10593);
    }

    @SafeParcelable.Constructor
    AccountChangeEventsResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) List<AccountChangeEvent> list) {
        AppMethodBeat.i(10590);
        this.zzh = i2;
        this.zzo = (List) Preconditions.checkNotNull(list);
        AppMethodBeat.o(10590);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> list) {
        AppMethodBeat.i(10591);
        this.zzh = 1;
        this.zzo = (List) Preconditions.checkNotNull(list);
        AppMethodBeat.o(10591);
    }

    public List<AccountChangeEvent> getEvents() {
        return this.zzo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10592);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzh);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10592);
    }
}
