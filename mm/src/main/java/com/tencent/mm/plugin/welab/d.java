package com.tencent.mm.plugin.welab;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {

    public static class a {
        public String JFU;
        public boolean JFV;
        public int action;
        public String dNI;
        public long timeStamp;
    }

    public static void a(a aVar) {
        int i2;
        AppMethodBeat.i(146213);
        m mVar = new m();
        mVar.n("expid", aVar.JFU + ",");
        mVar.n("appid", aVar.dNI + ",");
        mVar.n(NativeProtocol.WEB_DIALOG_ACTION, aVar.action + ",");
        mVar.n(AppMeasurement.Param.TIMESTAMP, aVar.timeStamp + ",");
        StringBuilder sb = new StringBuilder();
        if (aVar.JFV) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        mVar.n("hasRedPoint", sb.append(i2).append(",").toString());
        Log.i("WelabReporter", "report " + mVar.abW());
        h.INSTANCE.a(14206, mVar);
        AppMethodBeat.o(146213);
    }

    public static void y(String str, int i2, boolean z) {
        AppMethodBeat.i(146214);
        a aVar = new a();
        aVar.dNI = str;
        aVar.action = i2;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.JFU = a.gjg().bbz(str).field_expId;
        aVar.JFV = z;
        a(aVar);
        AppMethodBeat.o(146214);
    }

    public static void f(String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(146215);
        a aVar = new a();
        aVar.dNI = str;
        aVar.action = i2;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.JFU = str2;
        aVar.JFV = z;
        a(aVar);
        AppMethodBeat.o(146215);
    }
}
