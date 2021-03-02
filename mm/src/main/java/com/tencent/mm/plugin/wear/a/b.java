package com.tencent.mm.plugin.wear.a;

import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

public final class b {
    public static final boolean aWr(String str) {
        AppMethodBeat.i(131330);
        try {
            boolean equals = str.split(FilePathGenerator.ANDROID_DIR_SEP)[2].equals(PutDataRequest.WEAR_URI_SCHEME);
            AppMethodBeat.o(131330);
            return equals;
        } catch (Exception e2) {
            AppMethodBeat.o(131330);
            return false;
        }
    }

    public static final int aWs(String str) {
        AppMethodBeat.i(131331);
        try {
            int intValue = Integer.valueOf(str.split(FilePathGenerator.ANDROID_DIR_SEP)[4]).intValue();
            AppMethodBeat.o(131331);
            return intValue;
        } catch (Exception e2) {
            AppMethodBeat.o(131331);
            return 0;
        }
    }
}
