package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "AccountTransferProgressCreator")
public class zzr extends zzbs {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private static final a<String, FastJsonResponse.Field<?, ?>> zzbp;
    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", id = 2)
    private List<String> zzbq;
    @SafeParcelable.Field(getter = "getInProgressAccountTypes", id = 3)
    private List<String> zzbr;
    @SafeParcelable.Field(getter = "getSuccessAccountTypes", id = 4)
    private List<String> zzbs;
    @SafeParcelable.Field(getter = "getFailedAccountTypes", id = 5)
    private List<String> zzbt;
    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", id = 6)
    private List<String> zzbu;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10673);
        a<String, FastJsonResponse.Field<?, ?>> aVar = new a<>();
        zzbp = aVar;
        aVar.put("registered", FastJsonResponse.Field.forStrings("registered", 2));
        zzbp.put("in_progress", FastJsonResponse.Field.forStrings("in_progress", 3));
        zzbp.put("success", FastJsonResponse.Field.forStrings("success", 4));
        zzbp.put(StateEvent.ProcessResult.FAILED, FastJsonResponse.Field.forStrings(StateEvent.ProcessResult.FAILED, 5));
        zzbp.put("escrowed", FastJsonResponse.Field.forStrings("escrowed", 6));
        AppMethodBeat.o(10673);
    }

    public zzr() {
        this.zzy = 1;
    }

    @SafeParcelable.Constructor
    zzr(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) List<String> list, @SafeParcelable.Param(id = 3) List<String> list2, @SafeParcelable.Param(id = 4) List<String> list3, @SafeParcelable.Param(id = 5) List<String> list4, @SafeParcelable.Param(id = 6) List<String> list5) {
        this.zzy = i2;
        this.zzbq = list;
        this.zzbr = list2;
        this.zzbs = list3;
        this.zzbt = list4;
        this.zzbu = list5;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        return zzbp;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        AppMethodBeat.i(10671);
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.o(10671);
                return valueOf;
            case 2:
                List<String> list = this.zzbq;
                AppMethodBeat.o(10671);
                return list;
            case 3:
                List<String> list2 = this.zzbr;
                AppMethodBeat.o(10671);
                return list2;
            case 4:
                List<String> list3 = this.zzbs;
                AppMethodBeat.o(10671);
                return list3;
            case 5:
                List<String> list4 = this.zzbt;
                AppMethodBeat.o(10671);
                return list4;
            case 6:
                List<String> list5 = this.zzbu;
                AppMethodBeat.o(10671);
                return list5;
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(field.getSafeParcelableFieldId()).toString());
                AppMethodBeat.o(10671);
                throw illegalStateException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(10672);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbq = arrayList;
                AppMethodBeat.o(10672);
                return;
            case 3:
                this.zzbr = arrayList;
                AppMethodBeat.o(10672);
                return;
            case 4:
                this.zzbs = arrayList;
                AppMethodBeat.o(10672);
                return;
            case 5:
                this.zzbt = arrayList;
                AppMethodBeat.o(10672);
                return;
            case 6:
                this.zzbu = arrayList;
                AppMethodBeat.o(10672);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(safeParcelableFieldId)));
                AppMethodBeat.o(10672);
                throw illegalArgumentException;
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10670);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzbq, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzbr, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzbs, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzbt, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzbu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10670);
    }
}
