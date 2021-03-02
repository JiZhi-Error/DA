package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.regex.Pattern;

public final class k {
    public static final Pattern PATTERN = Pattern.compile("<a>(.+?)</a>");
    public static int wEa = 0;
    public static int wEb = TPMediaCodecProfileLevel.HEVCHighTierLevel62;

    public interface a {
        public static final int wEc = Math.max(4, Runtime.getRuntime().availableProcessors());
    }

    static {
        AppMethodBeat.i(209314);
        AppMethodBeat.o(209314);
    }

    public static boolean MM(int i2) {
        return i2 == 76 || i2 == 77 || i2 == 80;
    }
}
