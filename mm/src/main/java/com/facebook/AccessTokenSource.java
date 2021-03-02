package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);
    
    private final boolean canExtendToken;

    public static AccessTokenSource valueOf(String str) {
        AppMethodBeat.i(17006);
        AccessTokenSource accessTokenSource = (AccessTokenSource) Enum.valueOf(AccessTokenSource.class, str);
        AppMethodBeat.o(17006);
        return accessTokenSource;
    }

    static {
        AppMethodBeat.i(17007);
        AppMethodBeat.o(17007);
    }

    private AccessTokenSource(boolean z) {
        this.canExtendToken = z;
    }

    /* access modifiers changed from: package-private */
    public final boolean canExtendToken() {
        return this.canExtendToken;
    }
}
