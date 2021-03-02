package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator = "TokenDataCreator")
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzn();
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 3)
    private final Long zzaa;
    @SafeParcelable.Field(getter = "isCached", id = 4)
    private final boolean zzab;
    @SafeParcelable.Field(getter = "isSnowballed", id = 5)
    private final boolean zzac;
    @SafeParcelable.Field(getter = "getGrantedScopes", id = 6)
    private final List<String> zzad;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;
    @SafeParcelable.Field(getter = "getToken", id = 2)
    private final String zzz;

    static {
        AppMethodBeat.i(10619);
        AppMethodBeat.o(10619);
    }

    @SafeParcelable.Constructor
    TokenData(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Long l, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list) {
        AppMethodBeat.i(10615);
        this.zzy = i2;
        this.zzz = Preconditions.checkNotEmpty(str);
        this.zzaa = l;
        this.zzab = z;
        this.zzac = z2;
        this.zzad = list;
        AppMethodBeat.o(10615);
    }

    public static TokenData zzd(Bundle bundle, String str) {
        AppMethodBeat.i(10614);
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            AppMethodBeat.o(10614);
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        TokenData tokenData = (TokenData) bundle2.getParcelable("TokenData");
        AppMethodBeat.o(10614);
        return tokenData;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(10616);
        if (!(obj instanceof TokenData)) {
            AppMethodBeat.o(10616);
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        if (!TextUtils.equals(this.zzz, tokenData.zzz) || !Objects.equal(this.zzaa, tokenData.zzaa) || this.zzab != tokenData.zzab || this.zzac != tokenData.zzac || !Objects.equal(this.zzad, tokenData.zzad)) {
            AppMethodBeat.o(10616);
            return false;
        }
        AppMethodBeat.o(10616);
        return true;
    }

    public int hashCode() {
        AppMethodBeat.i(10617);
        int hashCode = Objects.hashCode(this.zzz, this.zzaa, Boolean.valueOf(this.zzab), Boolean.valueOf(this.zzac), this.zzad);
        AppMethodBeat.o(10617);
        return hashCode;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10618);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.zzz, false);
        SafeParcelWriter.writeLongObject(parcel, 3, this.zzaa, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzab);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzac);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzad, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10618);
    }

    public final String zze() {
        return this.zzz;
    }
}
