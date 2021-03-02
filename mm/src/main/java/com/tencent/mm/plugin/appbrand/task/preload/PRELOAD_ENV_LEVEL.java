package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public enum PRELOAD_ENV_LEVEL {
    LOW_LEVEL,
    MIDDLE_LEVEL,
    HIGH_LEVEL;

    public static PRELOAD_ENV_LEVEL valueOf(String str) {
        AppMethodBeat.i(48507);
        PRELOAD_ENV_LEVEL preload_env_level = (PRELOAD_ENV_LEVEL) Enum.valueOf(PRELOAD_ENV_LEVEL.class, str);
        AppMethodBeat.o(48507);
        return preload_env_level;
    }

    static {
        AppMethodBeat.i(48508);
        AppMethodBeat.o(48508);
    }
}
