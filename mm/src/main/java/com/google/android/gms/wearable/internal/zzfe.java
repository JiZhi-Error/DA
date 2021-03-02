package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

@SafeParcelable.Class(creator = "MessageEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzfe extends AbstractSafeParcelable implements MessageEvent {
    public static final Parcelable.Creator<zzfe> CREATOR = new zzff();
    @SafeParcelable.Field(getter = "getData", id = 4)
    private final byte[] data;
    @SafeParcelable.Field(getter = "getPath", id = 3)
    private final String zzcl;
    @SafeParcelable.Field(getter = "getRequestId", id = 2)
    private final int zzeh;
    @SafeParcelable.Field(getter = "getSourceNodeId", id = 5)
    private final String zzek;

    static {
        AppMethodBeat.i(101295);
        AppMethodBeat.o(101295);
    }

    @SafeParcelable.Constructor
    public zzfe(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String str2) {
        this.zzeh = i2;
        this.zzcl = str;
        this.data = bArr;
        this.zzek = str2;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final byte[] getData() {
        return this.data;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final String getPath() {
        return this.zzcl;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final int getRequestId() {
        return this.zzeh;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final String getSourceNodeId() {
        return this.zzek;
    }

    public final String toString() {
        AppMethodBeat.i(101294);
        int i2 = this.zzeh;
        String str = this.zzcl;
        String valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        String sb = new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(valueOf).length()).append("MessageEventParcelable[").append(i2).append(",").append(str).append(", size=").append(valueOf).append("]").toString();
        AppMethodBeat.o(101294);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101293);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getRequestId());
        SafeParcelWriter.writeString(parcel, 3, getPath(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getData(), false);
        SafeParcelWriter.writeString(parcel, 5, getSourceNodeId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101293);
    }
}
