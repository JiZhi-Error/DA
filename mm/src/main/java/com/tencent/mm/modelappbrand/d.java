package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d {
    public static final a iIp = new a((byte) 0);

    static {
        AppMethodBeat.i(201282);
        AppMethodBeat.o(201282);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static com.tencent.mm.ak.d a(dwq dwq) {
            AppMethodBeat.i(201281);
            p.h(dwq, "req");
            d.a aVar = new d.a();
            aVar.d(new dwr());
            aVar.MB("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
            aVar.sG(3872);
            aVar.sI(0);
            aVar.sJ(0);
            aVar.c(dwq);
            com.tencent.mm.ak.d aXF = aVar.aXF();
            p.g(aXF, "builder.buildInstance()");
            AppMethodBeat.o(201281);
            return aXF;
        }
    }
}
