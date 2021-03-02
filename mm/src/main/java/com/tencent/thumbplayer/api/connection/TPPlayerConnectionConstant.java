package com.tencent.thumbplayer.api.connection;

import com.tencent.thumbplayer.a.b.b.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPPlayerConnectionConstant {
    @a.AbstractC2202a(-1)
    public static final int ACTION_NONE = -1;
    @a.AbstractC2202a(1)
    public static final int ACTION_OBTAIN_SYNC_CLOCK = 1;
    @a.AbstractC2202a(0)
    public static final int ACTION_PROVIDE_SYNC_CLOCK = 0;
    @a.b(0)
    public static final int CFG_LONG_SYNC_CLOCK_OFFSET_MS = 0;

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Config {
    }
}
