package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
@SafeParcelable.Class(creator = "PutDataRequestCreator")
@SafeParcelable.Reserved({1})
public class PutDataRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final long zzt = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzu = new SecureRandom();
    @SafeParcelable.Field(getter = "getData", id = 5)
    private byte[] data;
    @SafeParcelable.Field(getter = "getUri", id = 2)
    private final Uri uri;
    @SafeParcelable.Field(getter = "getAssetsInternal", id = 4)
    private final Bundle zzv;
    @SafeParcelable.Field(getter = "getSyncDeadline", id = 6)
    private long zzw;

    static {
        AppMethodBeat.i(100871);
        AppMethodBeat.o(100871);
    }

    private PutDataRequest(Uri uri2) {
        this(uri2, new Bundle(), null, zzt);
        AppMethodBeat.i(100857);
        AppMethodBeat.o(100857);
    }

    @SafeParcelable.Constructor
    PutDataRequest(@SafeParcelable.Param(id = 2) Uri uri2, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) long j2) {
        AppMethodBeat.i(100856);
        this.uri = uri2;
        this.zzv = bundle;
        this.zzv.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.data = bArr;
        this.zzw = j2;
        AppMethodBeat.o(100856);
    }

    public static PutDataRequest create(String str) {
        AppMethodBeat.i(100862);
        Asserts.checkNotNull(str, "path must not be null");
        PutDataRequest zza = zza(zza(str));
        AppMethodBeat.o(100862);
        return zza;
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        AppMethodBeat.i(100859);
        Asserts.checkNotNull(dataItem, "source must not be null");
        PutDataRequest zza = zza(dataItem.getUri());
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getValue().getId() == null) {
                String valueOf = String.valueOf(entry.getKey());
                IllegalStateException illegalStateException = new IllegalStateException(valueOf.length() != 0 ? "Cannot create an asset for a put request without a digest: ".concat(valueOf) : new String("Cannot create an asset for a put request without a digest: "));
                AppMethodBeat.o(100859);
                throw illegalStateException;
            }
            zza.putAsset(entry.getKey(), Asset.createFromRef(entry.getValue().getId()));
        }
        zza.setData(dataItem.getData());
        AppMethodBeat.o(100859);
        return zza;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        AppMethodBeat.i(100861);
        Asserts.checkNotNull(str, "pathPrefix must not be null");
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            sb.append(FilePathGenerator.ANDROID_DIR_SEP);
        }
        sb.append("PN").append(zzu.nextLong());
        PutDataRequest putDataRequest = new PutDataRequest(zza(sb.toString()));
        AppMethodBeat.o(100861);
        return putDataRequest;
    }

    private static Uri zza(String str) {
        AppMethodBeat.i(100863);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("An empty path was supplied.");
            AppMethodBeat.o(100863);
            throw illegalArgumentException;
        } else if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("A path must start with a single / .");
            AppMethodBeat.o(100863);
            throw illegalArgumentException2;
        } else if (str.startsWith("//")) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("A path must start with a single / .");
            AppMethodBeat.o(100863);
            throw illegalArgumentException3;
        } else {
            Uri build = new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
            AppMethodBeat.o(100863);
            return build;
        }
    }

    public static PutDataRequest zza(Uri uri2) {
        AppMethodBeat.i(100860);
        Asserts.checkNotNull(uri2, "uri must not be null");
        PutDataRequest putDataRequest = new PutDataRequest(uri2);
        AppMethodBeat.o(100860);
        return putDataRequest;
    }

    @VisibleForTesting
    public Asset getAsset(String str) {
        AppMethodBeat.i(100865);
        Asserts.checkNotNull(str, "key must not be null");
        Asset asset = (Asset) this.zzv.getParcelable(str);
        AppMethodBeat.o(100865);
        return asset;
    }

    public Map<String, Asset> getAssets() {
        AppMethodBeat.i(100864);
        HashMap hashMap = new HashMap();
        for (String str : this.zzv.keySet()) {
            hashMap.put(str, (Asset) this.zzv.getParcelable(str));
        }
        Map<String, Asset> unmodifiableMap = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(100864);
        return unmodifiableMap;
    }

    @VisibleForTesting
    public byte[] getData() {
        return this.data;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean hasAsset(String str) {
        AppMethodBeat.i(100866);
        Asserts.checkNotNull(str, "key must not be null");
        boolean containsKey = this.zzv.containsKey(str);
        AppMethodBeat.o(100866);
        return containsKey;
    }

    public boolean isUrgent() {
        return this.zzw == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        AppMethodBeat.i(100867);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(asset);
        this.zzv.putParcelable(str, asset);
        AppMethodBeat.o(100867);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        AppMethodBeat.i(100868);
        Asserts.checkNotNull(str, "key must not be null");
        this.zzv.remove(str);
        AppMethodBeat.o(100868);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzw = 0;
        return this;
    }

    public String toString() {
        AppMethodBeat.i(100869);
        String putDataRequest = toString(Log.isLoggable(DataMap.TAG, 3));
        AppMethodBeat.o(100869);
        return putDataRequest;
    }

    public String toString(boolean z) {
        AppMethodBeat.i(100870);
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        String valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        sb.append(new StringBuilder(String.valueOf(valueOf).length() + 7).append("dataSz=").append(valueOf).toString());
        sb.append(new StringBuilder(23).append(", numAssets=").append(this.zzv.size()).toString());
        String valueOf2 = String.valueOf(this.uri);
        sb.append(new StringBuilder(String.valueOf(valueOf2).length() + 6).append(", uri=").append(valueOf2).toString());
        sb.append(new StringBuilder(35).append(", syncDeadline=").append(this.zzw).toString());
        if (!z) {
            sb.append("]");
            String sb2 = sb.toString();
            AppMethodBeat.o(100870);
            return sb2;
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzv.keySet()) {
            String valueOf3 = String.valueOf(this.zzv.getParcelable(str));
            sb.append(new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(valueOf3).length()).append("\n    ").append(str).append(": ").append(valueOf3).toString());
        }
        sb.append("\n  ]");
        String sb3 = sb.toString();
        AppMethodBeat.o(100870);
        return sb3;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(100858);
        Asserts.checkNotNull(parcel, "dest must not be null");
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i2, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzv, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(100858);
    }
}
