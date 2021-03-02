package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class aj extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "login";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78584);
        Log.i("MicroMsg.JsApiLogin", "invoke");
        LinkedList<String> linkedList = new LinkedList<>();
        final String appId = aVar.cta.ITw.getAppId();
        if (Util.isNullOrNil(appId)) {
            Log.e("MicroMsg.JsApiLogin", "appId is null!");
            aVar.c("fail", null);
            AppMethodBeat.o(78584);
            return;
        }
        d.a aVar2 = new d.a();
        ces ces = new ces();
        aVar2.iLN = ces;
        aVar2.iLO = new cet();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar2.funcId = TXLiteAVCode.EVT_LOCAL_RECORD_RESULT;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        ces.jfi = appId;
        ces.MjX = linkedList;
        ces.Mkk = 0;
        ces.Url = "";
        ces.Mkl = "";
        ces.MjZ = 0;
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.aj.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(78582);
                Log.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    cet cet = (cet) dVar.iLL.iLR;
                    if (cet == null || cet.Mkb == null) {
                        aVar.c("fail", null);
                        AppMethodBeat.o(78582);
                        return;
                    }
                    int i4 = cet.Mkb.dIZ;
                    String str2 = cet.Mkb.dJa;
                    final String str3 = cet.Mkl;
                    Log.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i4));
                    if (i4 == -12000) {
                        final LinkedList<drb> linkedList = cet.LRN;
                        final String str4 = cet.xMq;
                        final String str5 = cet.KFs;
                        Log.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", str4, str5);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.luggage.jsapi.aj.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(78581);
                                r rVar = new r(aVar.cta.mContext);
                                AnonymousClass1 r0 = new r.a() {
                                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.aj.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.r.a
                                    public final void i(int i2, Bundle bundle) {
                                        AppMethodBeat.i(78580);
                                        Log.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", Integer.valueOf(i2));
                                        switch (i2) {
                                            case 1:
                                            case 2:
                                                aj.a(aj.this, appId, bundle, str3, i2, aVar);
                                                if (i2 == 2) {
                                                    Log.e("MicroMsg.JsApiLogin", "fail auth deny!");
                                                    aVar.c("auth_deny", null);
                                                    AppMethodBeat.o(78580);
                                                    return;
                                                }
                                                break;
                                            default:
                                                Log.i("MicroMsg.JsApiLogin", "press back button!");
                                                aVar.c("auth_cancel", null);
                                                break;
                                        }
                                        AppMethodBeat.o(78580);
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    Log.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
                                    aVar.c("fail", null);
                                    AppMethodBeat.o(78581);
                                    return;
                                }
                                if (!rVar.a(linkedList, str4, str5, r0)) {
                                    aVar.c("fail", null);
                                }
                                AppMethodBeat.o(78581);
                            }
                        });
                        AppMethodBeat.o(78582);
                    } else if (i4 == 0) {
                        String str6 = cet.Mkm;
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str6);
                        Log.d("MicroMsg.JsApiLogin", "resp data code [%s]", str6);
                        aVar.c("", null);
                        AppMethodBeat.o(78582);
                    } else {
                        Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                        aVar.c("fail", null);
                        AppMethodBeat.o(78582);
                    }
                } else {
                    aVar.c("fail", null);
                    AppMethodBeat.o(78582);
                }
            }
        });
        AppMethodBeat.o(78584);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static /* synthetic */ void a(aj ajVar, String str, Bundle bundle, String str2, final int i2, final b.a aVar) {
        AppMethodBeat.i(78585);
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator it = ((ArrayList) bundle.getSerializable("key_scope")).iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        d.a aVar2 = new d.a();
        ceq ceq = new ceq();
        aVar2.iLN = ceq;
        aVar2.iLO = new cer();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar2.funcId = FaceManager.FACE_WITH_EYES_CLOSED;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        ceq.jfi = str;
        ceq.MjX = linkedList;
        ceq.Mkk = 0;
        ceq.Mkl = str2;
        ceq.MjZ = 0;
        ceq.MjY = i2;
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.aj.AnonymousClass2 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(78583);
                Log.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 != 0 || i3 != 0) {
                    aVar.c("fail", null);
                    AppMethodBeat.o(78583);
                } else if (i2 == 2) {
                    Log.d("MicroMsg.JsApiLogin", "press reject button");
                    aVar.c("fail", null);
                    AppMethodBeat.o(78583);
                } else {
                    cer cer = (cer) dVar.iLL.iLR;
                    if (cer == null || cer.Mkb == null) {
                        aVar.c("fail", null);
                        AppMethodBeat.o(78583);
                        return;
                    }
                    int i4 = cer.Mkb.dIZ;
                    String str2 = cer.Mkb.dJa;
                    Log.i("MicroMsg.JsApiLogin", "jsErrcode = %d", Integer.valueOf(i4));
                    if (i4 == 0) {
                        String str3 = cer.Mkm;
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str3);
                        aVar.c("", null);
                        Log.d("MicroMsg.JsApiLogin", "resp data code [%s]", str3);
                        AppMethodBeat.o(78583);
                        return;
                    }
                    aVar.c("fail", null);
                    Log.e("MicroMsg.JsApiLogin", "errMsg = %s", str2);
                    AppMethodBeat.o(78583);
                }
            }
        });
        AppMethodBeat.o(78585);
    }
}
