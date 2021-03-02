package com.tencent.map.lib.models;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DownloadPriority {
    NONE(-1),
    HIGH(0),
    MIDDLE(1),
    LOW(2);
    
    private final int mValue;

    public static DownloadPriority valueOf(String str) {
        AppMethodBeat.i(180735);
        DownloadPriority downloadPriority = (DownloadPriority) Enum.valueOf(DownloadPriority.class, str);
        AppMethodBeat.o(180735);
        return downloadPriority;
    }

    static {
        AppMethodBeat.i(180738);
        AppMethodBeat.o(180738);
    }

    private DownloadPriority(int i2) {
        this.mValue = i2;
    }

    public static DownloadPriority get(int i2) {
        AppMethodBeat.i(180736);
        DownloadPriority[] values = values();
        for (DownloadPriority downloadPriority : values) {
            if (downloadPriority.mValue == i2) {
                AppMethodBeat.o(180736);
                return downloadPriority;
            }
        }
        DownloadPriority downloadPriority2 = NONE;
        AppMethodBeat.o(180736);
        return downloadPriority2;
    }

    public static int getThreadPriority(int i2) {
        AppMethodBeat.i(180737);
        switch (get(i2)) {
            case HIGH:
                AppMethodBeat.o(180737);
                return 10;
            case LOW:
                AppMethodBeat.o(180737);
                return 1;
            case MIDDLE:
                AppMethodBeat.o(180737);
                return 5;
            default:
                AppMethodBeat.o(180737);
                return 5;
        }
    }

    public final int getValue() {
        return this.mValue;
    }
}
