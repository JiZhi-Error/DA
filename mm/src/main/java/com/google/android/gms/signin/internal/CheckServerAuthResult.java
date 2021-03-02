package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "CheckServerAuthResultCreator")
public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new CheckServerAuthResultCreator();
    @SafeParcelable.Field(id = 2)
    private final boolean zzadp;
    @SafeParcelable.Field(id = 3)
    private final List<Scope> zzadq;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;

    static {
        AppMethodBeat.i(12152);
        AppMethodBeat.o(12152);
    }

    @SafeParcelable.Constructor
    CheckServerAuthResult(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) List<Scope> list) {
        this.zzal = i2;
        this.zzadp = z;
        this.zzadq = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CheckServerAuthResult(boolean z, Set<Scope> set) {
        this(1, z, set == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(set)));
        AppMethodBeat.i(12149);
        AppMethodBeat.o(12149);
    }

    public Set<Scope> getAdditionalScopes() {
        AppMethodBeat.i(12150);
        HashSet hashSet = new HashSet(this.zzadq);
        AppMethodBeat.o(12150);
        return hashSet;
    }

    public boolean isNewAuthCodeRequired() {
        return this.zzadp;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(12151);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzadp);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzadq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(12151);
    }
}
