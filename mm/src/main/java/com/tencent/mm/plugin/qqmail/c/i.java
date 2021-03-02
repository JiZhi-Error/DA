package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public class i implements b<Bundle, IPCVoid> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<IPCVoid> dVar) {
        AppMethodBeat.i(198588);
        Bundle bundle2 = bundle;
        int i2 = bundle2.getInt("kv_report_key");
        int i3 = bundle2.getInt("kv_report_value");
        h.INSTANCE.a(i2, Integer.valueOf(i3));
        Log.i("MicroMsg.ReportKVTask", "report key %d, value %d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(198588);
    }
}
