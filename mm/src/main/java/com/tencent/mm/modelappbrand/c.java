package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.bzh;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c {
    public static final a iIo = new a((byte) 0);

    static {
        AppMethodBeat.i(201280);
        AppMethodBeat.o(201280);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d aXF() {
            AppMethodBeat.i(201279);
            d.a aVar = new d.a();
            aVar.c(new bzg());
            aVar.d(new bzh());
            aVar.MB("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
            aVar.sG(357);
            aVar.sI(0);
            aVar.sJ(0);
            d aXF = aVar.aXF();
            p.g(aXF, "builder.buildInstance()");
            AppMethodBeat.o(201279);
            return aXF;
        }
    }
}
