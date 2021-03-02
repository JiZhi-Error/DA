package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ChannelImplCreator")
@SafeParcelable.Reserved({1})
public final class zzay extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Parcelable.Creator<zzay> CREATOR = new zzbi();
    @SafeParcelable.Field(getter = "getToken", id = 2)
    private final String zzce;
    @SafeParcelable.Field(getter = "getPath", id = 4)
    private final String zzcl;
    @SafeParcelable.Field(getter = "getNodeId", id = 3)
    private final String zzo;

    static {
        AppMethodBeat.i(101040);
        AppMethodBeat.o(101040);
    }

    @SafeParcelable.Constructor
    public zzay(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3) {
        AppMethodBeat.i(101026);
        this.zzce = (String) Preconditions.checkNotNull(str);
        this.zzo = (String) Preconditions.checkNotNull(str2);
        this.zzcl = (String) Preconditions.checkNotNull(str3);
        AppMethodBeat.o(101026);
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(101038);
        PendingResult<Status> zza = zzb.zza(googleApiClient, new zzbf(this.zzce, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")}), channelListener);
        AppMethodBeat.o(101038);
        return zza;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(101031);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzaz(this, googleApiClient));
        AppMethodBeat.o(101031);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient, int i2) {
        AppMethodBeat.i(101032);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzba(this, googleApiClient, i2));
        AppMethodBeat.o(101032);
        return enqueue;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101029);
        if (obj == this) {
            AppMethodBeat.o(101029);
            return true;
        } else if (!(obj instanceof zzay)) {
            AppMethodBeat.o(101029);
            return false;
        } else {
            zzay zzay = (zzay) obj;
            if (!this.zzce.equals(zzay.zzce) || !Objects.equal(zzay.zzo, this.zzo) || !Objects.equal(zzay.zzcl, this.zzcl)) {
                AppMethodBeat.o(101029);
                return false;
            }
            AppMethodBeat.o(101029);
            return true;
        }
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(101033);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbb(this, googleApiClient));
        AppMethodBeat.o(101033);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.ChannelClient.Channel, com.google.android.gms.wearable.Channel
    public final String getNodeId() {
        return this.zzo;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(101034);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbc(this, googleApiClient));
        AppMethodBeat.o(101034);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.ChannelClient.Channel, com.google.android.gms.wearable.Channel
    public final String getPath() {
        return this.zzcl;
    }

    public final int hashCode() {
        AppMethodBeat.i(101030);
        int hashCode = this.zzce.hashCode();
        AppMethodBeat.o(101030);
        return hashCode;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, Uri uri, boolean z) {
        AppMethodBeat.i(101035);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(uri, "uri is null");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbd(this, googleApiClient, uri, z));
        AppMethodBeat.o(101035);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(101039);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzan(googleApiClient, channelListener, this.zzce));
        AppMethodBeat.o(101039);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.i(101036);
        PendingResult<Status> sendFile = sendFile(googleApiClient, uri, 0, -1);
        AppMethodBeat.o(101036);
        return sendFile;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri, long j2, long j3) {
        AppMethodBeat.i(101037);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(this.zzce, "token is null");
        Preconditions.checkNotNull(uri, "uri is null");
        Preconditions.checkArgument(j2 >= 0, "startOffset is negative: %s", Long.valueOf(j2));
        Preconditions.checkArgument(j3 >= 0 || j3 == -1, "invalid length: %s", Long.valueOf(j3));
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbe(this, googleApiClient, uri, j2, j3));
        AppMethodBeat.o(101037);
        return enqueue;
    }

    public final String toString() {
        AppMethodBeat.i(101028);
        int i2 = 0;
        for (char c2 : this.zzce.toCharArray()) {
            i2 += c2;
        }
        String trim = this.zzce.trim();
        int length = trim.length();
        if (length > 25) {
            String substring = trim.substring(0, 10);
            String substring2 = trim.substring(length - 10, length);
            trim = new StringBuilder(String.valueOf(substring).length() + 16 + String.valueOf(substring2).length()).append(substring).append("...").append(substring2).append("::").append(i2).toString();
        }
        String str = this.zzo;
        String str2 = this.zzcl;
        String sb = new StringBuilder(String.valueOf(trim).length() + 31 + String.valueOf(str).length() + String.valueOf(str2).length()).append("Channel{token=").append(trim).append(", nodeId=").append(str).append(", path=").append(str2).append("}").toString();
        AppMethodBeat.o(101028);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101027);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 3, getNodeId(), false);
        SafeParcelWriter.writeString(parcel, 4, getPath(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101027);
    }

    public final String zzc() {
        return this.zzce;
    }
}
