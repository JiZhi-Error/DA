package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;

/* access modifiers changed from: package-private */
public class z extends c<bzl> {
    z(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(44639);
        d.a aVar = new d.a();
        bzk bzk = new bzk();
        bzk.bDZ = i2;
        bzk.Mfd = i3;
        bzk.condition = i4;
        bzk.Mfb = i5;
        bzk.Mfc = i6;
        aVar.iLN = bzk;
        aVar.iLO = new bzl();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        aVar.funcId = 1148;
        c(aVar.aXF());
        AppMethodBeat.o(44639);
    }
}
