package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zzd();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    @SafeParcelable.Field(id = 4)
    public final byte[] body;
    @SafeParcelable.Field(id = 2)
    public final int httpMethod;
    @SafeParcelable.Field(id = 3)
    public final long timeoutMillis;
    @SafeParcelable.Field(id = 1)
    public final String url;
    @SafeParcelable.VersionField(id = 1000)
    private final int versionCode;
    @SafeParcelable.Field(id = 5)
    private Bundle zzdw;

    @KeepForSdkWithMembers
    public static class Builder {
        private String zzdx;
        private int zzdy = ProxyRequest.HTTP_METHOD_GET;
        private long zzdz = 3000;
        private byte[] zzea = null;
        private Bundle zzeb = new Bundle();

        public Builder(String str) {
            AppMethodBeat.i(10694);
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zzdx = str;
                AppMethodBeat.o(10694);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 51).append("The supplied url [ ").append(str).append("] is not match Patterns.WEB_URL!").toString());
            AppMethodBeat.o(10694);
            throw illegalArgumentException;
        }

        public ProxyRequest build() {
            AppMethodBeat.i(10698);
            if (this.zzea == null) {
                this.zzea = new byte[0];
            }
            ProxyRequest proxyRequest = new ProxyRequest(2, this.zzdx, this.zzdy, this.zzdz, this.zzea, this.zzeb);
            AppMethodBeat.o(10698);
            return proxyRequest;
        }

        public Builder putHeader(String str, String str2) {
            AppMethodBeat.i(10697);
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzeb;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            AppMethodBeat.o(10697);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzea = bArr;
            return this;
        }

        public Builder setHttpMethod(int i2) {
            AppMethodBeat.i(10695);
            Preconditions.checkArgument(i2 >= 0 && i2 <= ProxyRequest.LAST_CODE, "Unrecognized http method code.");
            this.zzdy = i2;
            AppMethodBeat.o(10695);
            return this;
        }

        public Builder setTimeoutMillis(long j2) {
            AppMethodBeat.i(10696);
            Preconditions.checkArgument(j2 >= 0, "The specified timeout must be non-negative.");
            this.zzdz = j2;
            AppMethodBeat.o(10696);
            return this;
        }
    }

    static {
        AppMethodBeat.i(10702);
        AppMethodBeat.o(10702);
    }

    @SafeParcelable.Constructor
    ProxyRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.versionCode = i2;
        this.url = str;
        this.httpMethod = i3;
        this.timeoutMillis = j2;
        this.body = bArr;
        this.zzdw = bundle;
    }

    public Map<String, String> getHeaderMap() {
        AppMethodBeat.i(10699);
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzdw.size());
        for (String str : this.zzdw.keySet()) {
            linkedHashMap.put(str, this.zzdw.getString(str));
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AppMethodBeat.o(10699);
        return unmodifiableMap;
    }

    public String toString() {
        AppMethodBeat.i(10700);
        String str = this.url;
        String sb = new StringBuilder(String.valueOf(str).length() + 42).append("ProxyRequest[ url: ").append(str).append(", method: ").append(this.httpMethod).append(" ]").toString();
        AppMethodBeat.o(10700);
        return sb;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10701);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzdw, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10701);
    }
}
