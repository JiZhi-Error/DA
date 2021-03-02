package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ConnectionConfigurationCreator")
@SafeParcelable.Reserved({1})
public class ConnectionConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String name;
    @SafeParcelable.Field(getter = "getType", id = 4)
    private final int type;
    @SafeParcelable.Field(getter = "getAddress", id = 3)
    private final String zzi;
    @SafeParcelable.Field(getter = "getRole", id = 5)
    private final int zzj;
    @SafeParcelable.Field(getter = "isEnabled", id = 6)
    private final boolean zzk;
    @SafeParcelable.Field(getter = "isConnected", id = 7)
    private volatile boolean zzl;
    @SafeParcelable.Field(getter = "getPeerNodeId", id = 8)
    private volatile String zzm;
    @SafeParcelable.Field(getter = "getBtlePriority", id = 9)
    private boolean zzn;
    @SafeParcelable.Field(getter = "getNodeId", id = 10)
    private String zzo;

    static {
        AppMethodBeat.i(100781);
        AppMethodBeat.o(100781);
    }

    @SafeParcelable.Constructor
    ConnectionConfiguration(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) String str3, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 10) String str4) {
        this.name = str;
        this.zzi = str2;
        this.type = i2;
        this.zzj = i3;
        this.zzk = z;
        this.zzl = z2;
        this.zzm = str3;
        this.zzn = z3;
        this.zzo = str4;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(100779);
        if (!(obj instanceof ConnectionConfiguration)) {
            AppMethodBeat.o(100779);
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        if (!Objects.equal(this.name, connectionConfiguration.name) || !Objects.equal(this.zzi, connectionConfiguration.zzi) || !Objects.equal(Integer.valueOf(this.type), Integer.valueOf(connectionConfiguration.type)) || !Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(connectionConfiguration.zzj)) || !Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(connectionConfiguration.zzk)) || !Objects.equal(Boolean.valueOf(this.zzn), Boolean.valueOf(connectionConfiguration.zzn))) {
            AppMethodBeat.o(100779);
            return false;
        }
        AppMethodBeat.o(100779);
        return true;
    }

    public int hashCode() {
        AppMethodBeat.i(100780);
        int hashCode = Objects.hashCode(this.name, this.zzi, Integer.valueOf(this.type), Integer.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzn));
        AppMethodBeat.o(100780);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(100778);
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ ");
        String valueOf = String.valueOf(this.name);
        sb.append(valueOf.length() != 0 ? "mName=".concat(valueOf) : new String("mName="));
        String valueOf2 = String.valueOf(this.zzi);
        sb.append(valueOf2.length() != 0 ? ", mAddress=".concat(valueOf2) : new String(", mAddress="));
        sb.append(new StringBuilder(19).append(", mType=").append(this.type).toString());
        sb.append(new StringBuilder(19).append(", mRole=").append(this.zzj).toString());
        sb.append(new StringBuilder(16).append(", mEnabled=").append(this.zzk).toString());
        sb.append(new StringBuilder(20).append(", mIsConnected=").append(this.zzl).toString());
        String valueOf3 = String.valueOf(this.zzm);
        sb.append(valueOf3.length() != 0 ? ", mPeerNodeId=".concat(valueOf3) : new String(", mPeerNodeId="));
        sb.append(new StringBuilder(21).append(", mBtlePriority=").append(this.zzn).toString());
        String valueOf4 = String.valueOf(this.zzo);
        sb.append(valueOf4.length() != 0 ? ", mNodeId=".concat(valueOf4) : new String(", mNodeId="));
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(100778);
        return sb2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(100777);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzi, false);
        SafeParcelWriter.writeInt(parcel, 4, this.type);
        SafeParcelWriter.writeInt(parcel, 5, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzl);
        SafeParcelWriter.writeString(parcel, 8, this.zzm, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzn);
        SafeParcelWriter.writeString(parcel, 10, this.zzo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(100777);
    }
}
