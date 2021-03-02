package com.tencent.youtu.ytagreflectlivecheck.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;

public class JNIUtils {
    private static final String TAG = "LightLiveCheck";

    public static Timeval getTimeval(long j2) {
        AppMethodBeat.i(193632);
        Timeval timeval = new Timeval(j2 / 1000, (int) ((1000 * j2) % TimeUtil.SECOND_TO_US));
        AppMethodBeat.o(193632);
        return timeval;
    }
}
