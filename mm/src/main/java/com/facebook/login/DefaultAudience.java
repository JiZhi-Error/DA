package com.facebook.login;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DefaultAudience {
    NONE(null),
    ONLY_ME(NativeProtocol.AUDIENCE_ME),
    FRIENDS(NativeProtocol.AUDIENCE_FRIENDS),
    EVERYONE(NativeProtocol.AUDIENCE_EVERYONE);
    
    private final String nativeProtocolAudience;

    public static DefaultAudience valueOf(String str) {
        AppMethodBeat.i(18048);
        DefaultAudience defaultAudience = (DefaultAudience) Enum.valueOf(DefaultAudience.class, str);
        AppMethodBeat.o(18048);
        return defaultAudience;
    }

    static {
        AppMethodBeat.i(18049);
        AppMethodBeat.o(18049);
    }

    private DefaultAudience(String str) {
        this.nativeProtocolAudience = str;
    }

    public final String getNativeProtocolAudience() {
        return this.nativeProtocolAudience;
    }
}
