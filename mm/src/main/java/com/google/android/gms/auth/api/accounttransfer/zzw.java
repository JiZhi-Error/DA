package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
public class zzw extends zzbs {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbk;
    @SafeParcelable.Indicator
    private final Set<Integer> zzbl;
    @SafeParcelable.Field(getter = "getAccountType", id = 2)
    private String zzbx;
    @SafeParcelable.Field(getter = "getStatus", id = 3)
    private int zzby;
    @SafeParcelable.Field(getter = "getTransferBytes", id = 4)
    private byte[] zzbz;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 5)
    private PendingIntent zzca;
    @SafeParcelable.Field(getter = "getDeviceMetaData", id = 6)
    private DeviceMetaData zzcb;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10690);
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzbk = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        zzbk.put("status", FastJsonResponse.Field.forInteger("status", 3));
        zzbk.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
        AppMethodBeat.o(10690);
    }

    public zzw() {
        AppMethodBeat.i(10683);
        this.zzbl = new b(3);
        this.zzy = 1;
        AppMethodBeat.o(10683);
    }

    @SafeParcelable.Constructor
    zzw(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(id = 6) DeviceMetaData deviceMetaData) {
        this.zzbl = set;
        this.zzy = i2;
        this.zzbx = str;
        this.zzby = i3;
        this.zzbz = bArr;
        this.zzca = pendingIntent;
        this.zzcb = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return zzbk;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        AppMethodBeat.i(10686);
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                Integer valueOf = Integer.valueOf(this.zzy);
                AppMethodBeat.o(10686);
                return valueOf;
            case 2:
                String str = this.zzbx;
                AppMethodBeat.o(10686);
                return str;
            case 3:
                Integer valueOf2 = Integer.valueOf(this.zzby);
                AppMethodBeat.o(10686);
                return valueOf2;
            case 4:
                byte[] bArr = this.zzbz;
                AppMethodBeat.o(10686);
                return bArr;
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(field.getSafeParcelableFieldId()).toString());
                AppMethodBeat.o(10686);
                throw illegalStateException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        AppMethodBeat.i(10685);
        boolean contains = this.zzbl.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        AppMethodBeat.o(10685);
        return contains;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        AppMethodBeat.i(10689);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 4:
                this.zzbz = bArr;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.o(10689);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(59).append("Field with id=").append(safeParcelableFieldId).append(" is not known to be an byte array.").toString());
                AppMethodBeat.o(10689);
                throw illegalArgumentException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i2) {
        AppMethodBeat.i(10688);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 3:
                this.zzby = i2;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.o(10688);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(52).append("Field with id=").append(safeParcelableFieldId).append(" is not known to be an int.").toString());
                AppMethodBeat.o(10688);
                throw illegalArgumentException;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        AppMethodBeat.i(10687);
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.zzbx = str2;
                this.zzbl.add(Integer.valueOf(safeParcelableFieldId));
                AppMethodBeat.o(10687);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
                AppMethodBeat.o(10687);
                throw illegalArgumentException;
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10684);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzbl;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.zzbx, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzby);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzbz, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzca, i2, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzcb, i2, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10684);
    }
}
