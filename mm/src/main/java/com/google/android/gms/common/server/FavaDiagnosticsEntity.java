package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new FavaDiagnosticsEntityCreator();
    public static final String EXTRA_NAMESPACE = "namespace";
    public static final String EXTRA_TYPE_NUM = "typeNum";
    @SafeParcelable.Field(id = 2)
    public final String namespace;
    @SafeParcelable.Field(id = 3)
    public final int typeNum;
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;

    static {
        AppMethodBeat.i(11929);
        AppMethodBeat.o(11929);
    }

    @SafeParcelable.Constructor
    public FavaDiagnosticsEntity(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.zzal = i2;
        this.namespace = str;
        this.typeNum = i3;
    }

    public FavaDiagnosticsEntity(String str, int i2) {
        this.zzal = 1;
        this.namespace = str;
        this.typeNum = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11928);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeString(parcel, 2, this.namespace, false);
        SafeParcelWriter.writeInt(parcel, 3, this.typeNum);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11928);
    }
}
