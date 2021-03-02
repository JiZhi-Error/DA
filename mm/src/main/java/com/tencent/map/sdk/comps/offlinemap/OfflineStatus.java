package com.tencent.map.sdk.comps.offlinemap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OfflineStatus {
    ERROR,
    READY,
    START,
    DOWNLOADING,
    CANCEL,
    COMPLETED,
    OPEN,
    CLOSE;

    public static OfflineStatus valueOf(String str) {
        AppMethodBeat.i(193506);
        OfflineStatus offlineStatus = (OfflineStatus) Enum.valueOf(OfflineStatus.class, str);
        AppMethodBeat.o(193506);
        return offlineStatus;
    }

    static {
        AppMethodBeat.i(193507);
        AppMethodBeat.o(193507);
    }
}
