package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AccountTransferMsgCreator")
public final class zzo extends zzbs {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbk;
    @SafeParcelable.Indicator
    private final Set<Integer> zzbl;
    @SafeParcelable.Field(getter = "getAuthenticatorDatas", id = 2)
    private ArrayList<zzu> zzbm;
    @SafeParcelable.Field(getter = "getRequestType", id = 3)
    private int zzbn;
    @SafeParcelable.Field(getter = "getProgress", id = 4)
    private zzr zzbo;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10668);
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzbk = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.forConcreteTypeArray("authenticatorData", 2, zzu.class));
        zzbk.put("progress", FastJsonResponse.Field.forConcreteType("progress", 4, zzr.class));
        AppMethodBeat.o(10668);
    }

    public zzo() {
        AppMethodBeat.i(10662);
        this.zzbl = new HashSet(1);
        this.zzy = 1;
        AppMethodBeat.o(10662);
    }

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<zzu> arrayList, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) zzr zzr) {
        this.zzbl = set;
        this.zzy = i2;
        this.zzbm = arrayList;
        this.zzbn = i3;
        this.zzbo = zzr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.server.response.FastJsonResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        AppMethodBeat.i(10666);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbm = arrayList;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.o(10666);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(safeParcelableFieldId), arrayList.getClass().getCanonicalName()));
                AppMethodBeat.o(10666);
                throw illegalArgumentException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        AppMethodBeat.i(10667);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 4:
                this.zzbo = (zzr) t;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.o(10667);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()));
                AppMethodBeat.o(10667);
                throw illegalArgumentException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return zzbk;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        AppMethodBeat.i(10665);
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.o(10665);
                return valueOf;
            case 2:
                ArrayList<zzu> arrayList = this.zzbm;
                AppMethodBeat.o(10665);
                return arrayList;
            case 3:
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(field.getSafeParcelableFieldId()).toString());
                AppMethodBeat.o(10665);
                throw illegalStateException;
            case 4:
                zzr zzr = this.zzbo;
                AppMethodBeat.o(10665);
                return zzr;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        AppMethodBeat.i(10664);
        boolean contains = this.zzbl.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        AppMethodBeat.o(10664);
        return contains;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10663);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzbl;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeTypedList(parcel, 2, this.zzbm, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzbo, i2, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10663);
    }
}
