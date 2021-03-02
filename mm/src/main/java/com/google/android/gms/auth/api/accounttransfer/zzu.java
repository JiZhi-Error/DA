package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorAnnotatedDataCreator")
public class zzu extends zzbs {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbk;
    @SafeParcelable.Field(getter = "getPackageName", id = 4)
    private String mPackageName;
    @SafeParcelable.Indicator
    private final Set<Integer> zzbl;
    @SafeParcelable.Field(getter = "getInfo", id = 2)
    private zzw zzbv;
    @SafeParcelable.Field(getter = "getSignature", id = 3)
    private String zzbw;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10681);
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzbk = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzw.class));
        zzbk.put("signature", FastJsonResponse.Field.forString("signature", 3));
        zzbk.put("package", FastJsonResponse.Field.forString("package", 4));
        AppMethodBeat.o(10681);
    }

    public zzu() {
        AppMethodBeat.i(10675);
        this.zzbl = new HashSet(3);
        this.zzy = 1;
        AppMethodBeat.o(10675);
    }

    @SafeParcelable.Constructor
    zzu(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) zzw zzw, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.zzbl = set;
        this.zzy = i2;
        this.zzbv = zzw;
        this.zzbw = str;
        this.mPackageName = str2;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        AppMethodBeat.i(10680);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbv = (zzw) t;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.o(10680);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()));
                AppMethodBeat.o(10680);
                throw illegalArgumentException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return zzbk;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        AppMethodBeat.i(10678);
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.o(10678);
                return valueOf;
            case 2:
                zzw zzw = this.zzbv;
                AppMethodBeat.o(10678);
                return zzw;
            case 3:
                String str = this.zzbw;
                AppMethodBeat.o(10678);
                return str;
            case 4:
                String str2 = this.mPackageName;
                AppMethodBeat.o(10678);
                return str2;
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(field.getSafeParcelableFieldId()).toString());
                AppMethodBeat.o(10678);
                throw illegalStateException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        AppMethodBeat.i(10677);
        boolean contains = this.zzbl.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        AppMethodBeat.o(10677);
        return contains;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        AppMethodBeat.i(10679);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 3:
                this.zzbw = str2;
                break;
            case 4:
                this.mPackageName = str2;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
                AppMethodBeat.o(10679);
                throw illegalArgumentException;
        }
        this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
        AppMethodBeat.o(10679);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10676);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzbl;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.zzbv, i2, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeString(parcel, 3, this.zzbw, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.mPackageName, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10676);
    }
}
