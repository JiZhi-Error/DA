package com.tencent.mm.model.gdpr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.fda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;

public final class c {
    public static boolean aXj() {
        AppMethodBeat.i(40087);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(40087);
            return false;
        }
        AppMethodBeat.o(40087);
        return true;
    }

    public static void a(final Context context, final a aVar, final String str, final b bVar) {
        AppMethodBeat.i(40088);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        if (!aXj()) {
            bVar.sx(0);
            AppMethodBeat.o(40088);
        } else if (Util.isNullOrNil(str)) {
            bVar.sx(1);
            AppMethodBeat.o(40088);
        } else {
            g.hio().h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                /* class com.tencent.mm.model.gdpr.c.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Boolean call(Void r6) {
                    AppMethodBeat.i(40085);
                    if (aVar.iGQ == 0) {
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.o(40085);
                        return bool;
                    }
                    final b hdH = com.tencent.mm.vending.g.g.hdH();
                    bns bns = new bns();
                    bns.dNI = str;
                    bns.scene = aVar.iGQ;
                    d.a aVar = new d.a();
                    aVar.funcId = 2575;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getgdrpauth";
                    aVar.iLN = bns;
                    aVar.iLO = new bnt();
                    IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                        /* class com.tencent.mm.model.gdpr.c.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                        public final void a(int i2, int i3, String str, d dVar) {
                            boolean z;
                            AppMethodBeat.i(40084);
                            dpc dpc = (dpc) dVar.iLL.iLR;
                            if (i2 == 0 && i3 == 0 && dpc != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                bnt bnt = (bnt) dVar.iLL.iLR;
                                if (bnt.LWi == null) {
                                    bnt.LWi = new fda();
                                    bnt.LWi.dIZ = -1;
                                }
                                Log.i("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d)", aVar.iGP, str, Integer.valueOf(bnt.LWi.dIZ), Integer.valueOf(bnt.state));
                                if (bnt.LWi.dIZ != 0) {
                                    bVar.sx(0);
                                    hdH.ej(Boolean.FALSE);
                                    AppMethodBeat.o(40084);
                                } else if (bnt.state <= 0) {
                                    hdH.G(Boolean.TRUE);
                                    AppMethodBeat.o(40084);
                                } else {
                                    bVar.sx(0);
                                    hdH.ej(Boolean.FALSE);
                                    AppMethodBeat.o(40084);
                                }
                            } else {
                                Log.e("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d %s)", aVar.iGP, str, Integer.valueOf(i3), Integer.valueOf(i2), str);
                                bVar.sx(0);
                                hdH.ej(Boolean.FALSE);
                                AppMethodBeat.o(40084);
                            }
                        }
                    });
                    AppMethodBeat.o(40085);
                    return null;
                }
            }).g(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                /* class com.tencent.mm.model.gdpr.c.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Boolean bool) {
                    AppMethodBeat.i(40083);
                    if (bool.booleanValue()) {
                        Intent putExtra = new Intent(context, MPGdprPolicyUI.class).putExtra("MPGdprPolicyUI_KEY_BUSINESS", aVar.iGP).putExtra("MPGdprPolicyUI_KEY_APPID", str).putExtra("MPGdprPolicyUI_KEY_RECEIVER", new MPGdprPolicyUtil$1$1(this, new Handler(Looper.getMainLooper())));
                        if (!(context instanceof Activity)) {
                            putExtra.addFlags(268435456);
                        }
                        Context context = context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/model/gdpr/MPGdprPolicyUtil$1", "call", "(Ljava/lang/Boolean;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/model/gdpr/MPGdprPolicyUtil$1", "call", "(Ljava/lang/Boolean;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(40083);
                    return null;
                }
            });
            AppMethodBeat.o(40088);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements k<IPCVoid, IPCBoolean> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            boolean z;
            AppMethodBeat.i(40086);
            if (!com.tencent.mm.kernel.g.aAc() || !com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null))) {
                z = false;
            } else {
                z = true;
            }
            IPCBoolean iPCBoolean = new IPCBoolean(z);
            AppMethodBeat.o(40086);
            return iPCBoolean;
        }
    }
}
