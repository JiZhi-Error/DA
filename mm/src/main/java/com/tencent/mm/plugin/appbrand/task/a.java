package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.service.o;

public final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.task.a$a  reason: collision with other inner class name */
    public static class C0796a implements b<IPCString, GetOnLineInfoInfoResult> {
        private C0796a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<GetOnLineInfoInfoResult> dVar) {
            AppMethodBeat.i(227435);
            o oVar = (o) g.af(o.class);
            if (oVar == null) {
                AppMethodBeat.o(227435);
                return;
            }
            GetOnLineInfoInfoResult getOnLineInfoInfoResult = new GetOnLineInfoInfoResult();
            getOnLineInfoInfoResult.jjN = oVar.beL();
            getOnLineInfoInfoResult.jjS = oVar.beM();
            getOnLineInfoInfoResult.kDf = oVar.beN();
            dVar.bn(getOnLineInfoInfoResult);
            AppMethodBeat.o(227435);
        }
    }
}
