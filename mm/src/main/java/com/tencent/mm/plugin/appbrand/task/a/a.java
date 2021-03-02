package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.task.a.a$a  reason: collision with other inner class name */
    public static class C0797a implements b<IPCString, IPCBoolean> {
        private C0797a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, final d<IPCBoolean> dVar) {
            AppMethodBeat.i(227532);
            final IPCString iPCString2 = iPCString;
            if (iPCString2 == null || Util.isNullOrNil(iPCString2.value)) {
                Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask callback error invalid appid ");
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(227532);
                return;
            }
            Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask invoke appId:%s", iPCString2.value);
            c buG = n.buG();
            if (buG == null) {
                Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask invoke storage null!");
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(227532);
                return;
            }
            int Xi = buG.Xi(iPCString2.value);
            Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask invoke permissionDemo:%d", Integer.valueOf(Xi));
            if (Xi == 0) {
                d.a aVar = new d.a();
                yh yhVar = new yh();
                yhVar.dNI = iPCString2.value;
                yhVar.Ljm = null;
                yhVar.Ljn = null;
                aVar.iLN = yhVar;
                aVar.iLO = new yi();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
                aVar.funcId = 1124;
                Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask request");
                aa.a(aVar.aXF(), new aa.a() {
                    /* class com.tencent.mm.plugin.appbrand.task.a.a.C0797a.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                        AppMethodBeat.i(227531);
                        if (qVar.getType() != 1124) {
                            Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask callback error mismatch ");
                            AppMethodBeat.o(227531);
                        } else {
                            if (i2 == 0 && i3 == 0) {
                                yi yiVar = (yi) dVar.iLL.iLR;
                                if (yiVar == null || yiVar.Ljo == null) {
                                    Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask callback error nil resp");
                                    n.buG().aD(iPCString2.value, false);
                                    dVar.bn(new IPCBoolean(false));
                                } else if (yiVar.Ljo.rBL != 0) {
                                    Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask callback error,ErrCode %d", Integer.valueOf(yiVar.Ljo.rBL));
                                    n.buG().aD(iPCString2.value, false);
                                    dVar.bn(new IPCBoolean(false));
                                } else {
                                    Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask callback success");
                                    n.buG().aD(iPCString2.value, true);
                                    dVar.bn(new IPCBoolean(true));
                                }
                            } else {
                                Log.e("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "CheckDemoTask callback error, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                dVar.bn(new IPCBoolean(false));
                            }
                            AppMethodBeat.o(227531);
                        }
                        return 0;
                    }
                }, true);
                AppMethodBeat.o(227532);
            } else if (Xi == 2) {
                dVar.bn(new IPCBoolean(true));
                AppMethodBeat.o(227532);
            } else {
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(227532);
            }
        }
    }
}
