package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

/* access modifiers changed from: package-private */
public class AccessTokenAppIdPair implements Serializable {
    private static final long serialVersionUID = 1;
    private final String accessTokenString;
    private final String applicationId;

    public AccessTokenAppIdPair(AccessToken accessToken) {
        this(accessToken.getToken(), FacebookSdk.getApplicationId());
        AppMethodBeat.i(17288);
        AppMethodBeat.o(17288);
    }

    public AccessTokenAppIdPair(String str, String str2) {
        AppMethodBeat.i(17289);
        this.accessTokenString = Utility.isNullOrEmpty(str) ? null : str;
        this.applicationId = str2;
        AppMethodBeat.o(17289);
    }

    public String getAccessTokenString() {
        return this.accessTokenString;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(17290);
        int hashCode = this.accessTokenString == null ? 0 : this.accessTokenString.hashCode();
        if (this.applicationId != null) {
            i2 = this.applicationId.hashCode();
        }
        int i3 = hashCode ^ i2;
        AppMethodBeat.o(17290);
        return i3;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(17291);
        if (!(obj instanceof AccessTokenAppIdPair)) {
            AppMethodBeat.o(17291);
            return false;
        }
        AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
        if (!Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) || !Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
            AppMethodBeat.o(17291);
            return false;
        }
        AppMethodBeat.o(17291);
        return true;
    }

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final String accessTokenString;
        private final String appId;

        private SerializationProxyV1(String str, String str2) {
            this.accessTokenString = str;
            this.appId = str2;
        }

        private Object readResolve() {
            AppMethodBeat.i(17287);
            AccessTokenAppIdPair accessTokenAppIdPair = new AccessTokenAppIdPair(this.accessTokenString, this.appId);
            AppMethodBeat.o(17287);
            return accessTokenAppIdPair;
        }
    }

    private Object writeReplace() {
        AppMethodBeat.i(17292);
        SerializationProxyV1 serializationProxyV1 = new SerializationProxyV1(this.accessTokenString, this.applicationId);
        AppMethodBeat.o(17292);
        return serializationProxyV1;
    }
}
