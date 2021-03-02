package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class Utils {
    public static boolean isRectValid(CGRect cGRect) {
        AppMethodBeat.i(197691);
        if (cGRect == null || !isSizeValid(cGRect.size)) {
            AppMethodBeat.o(197691);
            return false;
        }
        AppMethodBeat.o(197691);
        return true;
    }

    public static boolean isSizeValid(CGSize cGSize) {
        return (cGSize == null || cGSize.width == 0.0f || cGSize.height == 0.0f) ? false : true;
    }
}
