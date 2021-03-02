package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@VisibleForTesting
@SafeParcelable.Class(creator = "AssetCreator")
@SafeParcelable.Reserved({1})
public class Asset extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getData", id = 2)
    private byte[] data;
    @SafeParcelable.Field(id = 5)
    private Uri uri;
    @SafeParcelable.Field(getter = "getDigest", id = 3)
    private String zze;
    @SafeParcelable.Field(id = 4)
    private ParcelFileDescriptor zzf;

    static {
        AppMethodBeat.i(100776);
        AppMethodBeat.o(100776);
    }

    @SafeParcelable.Constructor
    Asset(@SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 5) Uri uri2) {
        this.data = bArr;
        this.zze = str;
        this.zzf = parcelFileDescriptor;
        this.uri = uri2;
    }

    @VisibleForTesting
    public static Asset createFromBytes(byte[] bArr) {
        AppMethodBeat.i(100770);
        Asserts.checkNotNull(bArr);
        Asset asset = new Asset(bArr, null, null, null);
        AppMethodBeat.o(100770);
        return asset;
    }

    @VisibleForTesting
    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(100771);
        Asserts.checkNotNull(parcelFileDescriptor);
        Asset asset = new Asset(null, null, parcelFileDescriptor, null);
        AppMethodBeat.o(100771);
        return asset;
    }

    public static Asset createFromRef(String str) {
        AppMethodBeat.i(100769);
        Asserts.checkNotNull(str);
        Asset asset = new Asset(null, str, null, null);
        AppMethodBeat.o(100769);
        return asset;
    }

    @VisibleForTesting
    public static Asset createFromUri(Uri uri2) {
        AppMethodBeat.i(100772);
        Asserts.checkNotNull(uri2);
        Asset asset = new Asset(null, null, null, uri2);
        AppMethodBeat.o(100772);
        return asset;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(100774);
        if (this == obj) {
            AppMethodBeat.o(100774);
            return true;
        } else if (!(obj instanceof Asset)) {
            AppMethodBeat.o(100774);
            return false;
        } else {
            Asset asset = (Asset) obj;
            if (!Arrays.equals(this.data, asset.data) || !Objects.equal(this.zze, asset.zze) || !Objects.equal(this.zzf, asset.zzf) || !Objects.equal(this.uri, asset.uri)) {
                AppMethodBeat.o(100774);
                return false;
            }
            AppMethodBeat.o(100774);
            return true;
        }
    }

    public final byte[] getData() {
        return this.data;
    }

    public String getDigest() {
        return this.zze;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzf;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        AppMethodBeat.i(100773);
        int deepHashCode = Arrays.deepHashCode(new Object[]{this.data, this.zze, this.zzf, this.uri});
        AppMethodBeat.o(100773);
        return deepHashCode;
    }

    public String toString() {
        AppMethodBeat.i(100775);
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zze == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.zze);
        }
        if (this.data != null) {
            sb.append(", size=");
            sb.append(this.data.length);
        }
        if (this.zzf != null) {
            sb.append(", fd=");
            sb.append(this.zzf);
        }
        if (this.uri != null) {
            sb.append(", uri=");
            sb.append(this.uri);
        }
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(100775);
        return sb2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(100768);
        Asserts.checkNotNull(parcel);
        int i3 = i2 | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.data, false);
        SafeParcelWriter.writeString(parcel, 3, getDigest(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzf, i3, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.uri, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(100768);
    }
}
