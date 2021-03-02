package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;

public class CMTimeUtils {
    public static long CMTimeConvertToUs(CMTime cMTime) {
        AppMethodBeat.i(217872);
        long timeSeconds = (long) (cMTime.getTimeSeconds() * 1000.0f * 1000.0f);
        AppMethodBeat.o(217872);
        return timeSeconds;
    }
}
