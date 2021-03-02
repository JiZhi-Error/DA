package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ChannelEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzax();
    @SafeParcelable.Field(id = 3)
    private final int type;
    @SafeParcelable.Field(id = 5)
    private final int zzcj;
    @SafeParcelable.Field(id = 2)
    private final zzay zzck;
    @SafeParcelable.Field(id = 4)
    private final int zzg;

    static {
        AppMethodBeat.i(101024);
        AppMethodBeat.o(101024);
    }

    @SafeParcelable.Constructor
    public zzaw(@SafeParcelable.Param(id = 2) zzay zzay, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4) {
        this.zzck = zzay;
        this.type = i2;
        this.zzg = i3;
        this.zzcj = i4;
    }

    public final String toString() {
        String str;
        String str2;
        AppMethodBeat.i(101023);
        String valueOf = String.valueOf(this.zzck);
        int i2 = this.type;
        switch (i2) {
            case 1:
                str = "CHANNEL_OPENED";
                break;
            case 2:
                str = "CHANNEL_CLOSED";
                break;
            case 3:
                str = "INPUT_CLOSED";
                break;
            case 4:
                str = "OUTPUT_CLOSED";
                break;
            default:
                str = Integer.toString(i2);
                break;
        }
        int i3 = this.zzg;
        switch (i3) {
            case 0:
                str2 = "CLOSE_REASON_NORMAL";
                break;
            case 1:
                str2 = "CLOSE_REASON_DISCONNECTED";
                break;
            case 2:
                str2 = "CLOSE_REASON_REMOTE_CLOSE";
                break;
            case 3:
                str2 = "CLOSE_REASON_LOCAL_CLOSE";
                break;
            default:
                str2 = Integer.toString(i3);
                break;
        }
        String sb = new StringBuilder(String.valueOf(valueOf).length() + 81 + String.valueOf(str).length() + String.valueOf(str2).length()).append("ChannelEventParcelable[, channel=").append(valueOf).append(", type=").append(str).append(", closeReason=").append(str2).append(", appErrorCode=").append(this.zzcj).append("]").toString();
        AppMethodBeat.o(101023);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101022);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzck, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, this.type);
        SafeParcelWriter.writeInt(parcel, 4, this.zzg);
        SafeParcelWriter.writeInt(parcel, 5, this.zzcj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101022);
    }

    public final void zza(ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(101021);
        switch (this.type) {
            case 1:
                channelListener.onChannelOpened(this.zzck);
                AppMethodBeat.o(101021);
                return;
            case 2:
                channelListener.onChannelClosed(this.zzck, this.zzg, this.zzcj);
                AppMethodBeat.o(101021);
                return;
            case 3:
                channelListener.onInputClosed(this.zzck, this.zzg, this.zzcj);
                AppMethodBeat.o(101021);
                return;
            case 4:
                channelListener.onOutputClosed(this.zzck, this.zzg, this.zzcj);
                AppMethodBeat.o(101021);
                return;
            default:
                new StringBuilder(25).append("Unknown type: ").append(this.type);
                AppMethodBeat.o(101021);
                return;
        }
    }
}
