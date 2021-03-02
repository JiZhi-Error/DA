package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@Deprecated
public class KindaAnimateProxyCreator {
    private static HashMap<Integer, WeakReference<Object>> cache = new HashMap<>();

    static {
        AppMethodBeat.i(18301);
        AppMethodBeat.o(18301);
    }

    public static Object checkCreateAnimateViewProxy(Object obj) {
        return obj;
    }
}
