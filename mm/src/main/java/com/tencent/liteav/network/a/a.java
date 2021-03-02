package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class a extends IOException {
    public a(String str, String str2) {
        super(str + ": " + str2);
        AppMethodBeat.i(15453);
        AppMethodBeat.o(15453);
    }
}
