package com.tencent.mm.plugin.appbrand.report;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fdh;
import com.tencent.mm.protocal.protobuf.fdi;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b {
    public MMHandler luO = new MMHandler(Looper.getMainLooper());
    public fdi nGb = null;
    public fdh nGc = null;
    public fdm nGd = null;
    public fdn nGe = null;
    public fdk nGf = null;
    public ffc nGg = null;

    public interface a {
        void dW(int i2, int i3);
    }

    public b() {
        AppMethodBeat.i(48014);
        AppMethodBeat.o(48014);
    }
}
