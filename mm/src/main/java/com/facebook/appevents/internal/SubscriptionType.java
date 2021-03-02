package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum SubscriptionType {
    NEW,
    HEARTBEAT,
    EXPIRE,
    CANCEL,
    RESTORE,
    DUPLICATED,
    UNKNOWN;

    public static SubscriptionType valueOf(String str) {
        AppMethodBeat.i(17666);
        SubscriptionType subscriptionType = (SubscriptionType) Enum.valueOf(SubscriptionType.class, str);
        AppMethodBeat.o(17666);
        return subscriptionType;
    }

    static {
        AppMethodBeat.i(17667);
        AppMethodBeat.o(17667);
    }
}
