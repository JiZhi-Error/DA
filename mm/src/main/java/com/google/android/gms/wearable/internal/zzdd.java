package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
@SafeParcelable.Class(creator = "DataItemParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzdd extends AbstractSafeParcelable implements DataItem {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    @SafeParcelable.Field(getter = "getData", id = 5)
    private byte[] data;
    @SafeParcelable.Field(getter = "getUri", id = 2)
    private final Uri uri;
    @SafeParcelable.Field(getter = "getAssetsInternal", id = 4, type = "android.os.Bundle")
    private final Map<String, DataItemAsset> zzdo;

    static {
        AppMethodBeat.i(101180);
        AppMethodBeat.o(101180);
    }

    @SafeParcelable.Constructor
    zzdd(@SafeParcelable.Param(id = 2) Uri uri2, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) byte[] bArr) {
        AppMethodBeat.i(101177);
        this.uri = uri2;
        HashMap hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.zzdo = hashMap;
        this.data = bArr;
        AppMethodBeat.o(101177);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItem freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        return this.zzdo;
    }

    @Override // com.google.android.gms.wearable.DataItem
    @VisibleForTesting
    public final byte[] getData() {
        return this.data;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final /* synthetic */ DataItem setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public final String toString() {
        AppMethodBeat.i(101179);
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        String valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        sb.append(new StringBuilder(String.valueOf(valueOf).length() + 8).append(",dataSz=").append(valueOf).toString());
        sb.append(new StringBuilder(23).append(", numAssets=").append(this.zzdo.size()).toString());
        String valueOf2 = String.valueOf(this.uri);
        sb.append(new StringBuilder(String.valueOf(valueOf2).length() + 6).append(", uri=").append(valueOf2).toString());
        if (!isLoggable) {
            sb.append("]");
            String sb2 = sb.toString();
            AppMethodBeat.o(101179);
            return sb2;
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzdo.keySet()) {
            String valueOf3 = String.valueOf(this.zzdo.get(str));
            sb.append(new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(valueOf3).length()).append("\n    ").append(str).append(": ").append(valueOf3).toString());
        }
        sb.append("\n  ]");
        String sb3 = sb.toString();
        AppMethodBeat.o(101179);
        return sb3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101178);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i2, false);
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry<String, DataItemAsset> entry : this.zzdo.entrySet()) {
            bundle.putParcelable(entry.getKey(), new DataItemAssetParcelable(entry.getValue()));
        }
        SafeParcelWriter.writeBundle(parcel, 4, bundle, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101178);
    }
}
