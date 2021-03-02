package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyResponseCreator")
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zze();
    public static final int STATUS_CODE_NO_CONNECTION = -1;
    @SafeParcelable.Field(id = 5)
    public final byte[] body;
    @SafeParcelable.Field(id = 1)
    public final int googlePlayServicesStatusCode;
    @SafeParcelable.Field(id = 2)
    public final PendingIntent recoveryAction;
    @SafeParcelable.Field(id = 3)
    public final int statusCode;
    @SafeParcelable.VersionField(id = 1000)
    private final int versionCode;
    @SafeParcelable.Field(id = 4)
    private final Bundle zzdw;

    static {
        AppMethodBeat.i(10708);
        AppMethodBeat.o(10708);
    }

    @SafeParcelable.Constructor
    ProxyResponse(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) int i3, @SafeParcelable.Param(id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) byte[] bArr) {
        this.versionCode = i2;
        this.googlePlayServicesStatusCode = i3;
        this.statusCode = i4;
        this.zzdw = bundle;
        this.body = bArr;
        this.recoveryAction = pendingIntent;
    }

    public ProxyResponse(int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this(1, i2, pendingIntent, i3, bundle, bArr);
    }

    private ProxyResponse(int i2, Bundle bundle, byte[] bArr) {
        this(1, 0, null, i2, bundle, bArr);
    }

    public ProxyResponse(int i2, Map<String, String> map, byte[] bArr) {
        this(i2, zzd(map), bArr);
        AppMethodBeat.i(10705);
        AppMethodBeat.o(10705);
    }

    public static ProxyResponse createErrorProxyResponse(int i2, PendingIntent pendingIntent, int i3, Map<String, String> map, byte[] bArr) {
        AppMethodBeat.i(10703);
        ProxyResponse proxyResponse = new ProxyResponse(1, i2, pendingIntent, i3, zzd(map), bArr);
        AppMethodBeat.o(10703);
        return proxyResponse;
    }

    private static Bundle zzd(Map<String, String> map) {
        AppMethodBeat.i(10704);
        Bundle bundle = new Bundle();
        if (map == null) {
            AppMethodBeat.o(10704);
            return bundle;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(10704);
        return bundle;
    }

    public Map<String, String> getHeaders() {
        AppMethodBeat.i(10706);
        if (this.zzdw == null) {
            Map<String, String> emptyMap = Collections.emptyMap();
            AppMethodBeat.o(10706);
            return emptyMap;
        }
        HashMap hashMap = new HashMap();
        for (String str : this.zzdw.keySet()) {
            hashMap.put(str, this.zzdw.getString(str));
        }
        AppMethodBeat.o(10706);
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10707);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.googlePlayServicesStatusCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.recoveryAction, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzdw, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.body, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10707);
    }
}
