package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static String fe(String str) {
        AppMethodBeat.i(116343);
        if (Util.isNullOrNil(str)) {
            str = "tempConv";
        }
        StringBuilder sb = new StringBuilder(d.aSZ());
        sb.append(g.getMessageDigest(str.getBytes())).append(FilePathGenerator.ANDROID_DIR_SEP);
        sb.append("conv/");
        String sb2 = sb.toString();
        AppMethodBeat.o(116343);
        return sb2;
    }
}
