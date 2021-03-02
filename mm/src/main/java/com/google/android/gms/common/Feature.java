package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new FeatureCreator();
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int zzaq;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getVersion", id = 3)
    private final long zzar;

    static {
        AppMethodBeat.i(4378);
        AppMethodBeat.o(4378);
    }

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) long j2) {
        this.name = str;
        this.zzaq = i2;
        this.zzar = j2;
    }

    public Feature(String str, long j2) {
        this.name = str;
        this.zzar = j2;
        this.zzaq = -1;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(4375);
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() == null || !getName().equals(feature.getName())) && !(getName() == null && feature.getName() == null)) || getVersion() != feature.getVersion()) {
                AppMethodBeat.o(4375);
                return false;
            }
            AppMethodBeat.o(4375);
            return true;
        }
        AppMethodBeat.o(4375);
        return false;
    }

    public String getName() {
        return this.name;
    }

    public long getVersion() {
        return this.zzar == -1 ? (long) this.zzaq : this.zzar;
    }

    public int hashCode() {
        AppMethodBeat.i(4376);
        int hashCode = Objects.hashCode(getName(), Long.valueOf(getVersion()));
        AppMethodBeat.o(4376);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(4377);
        String toStringHelper = Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
        AppMethodBeat.o(4377);
        return toStringHelper;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4374);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzaq);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4374);
    }
}
