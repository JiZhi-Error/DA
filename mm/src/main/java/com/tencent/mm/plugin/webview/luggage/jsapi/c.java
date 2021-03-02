package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.jsapi.auth.k;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

public class c extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return k.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78521);
        Log.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
        JSONArray optJSONArray = aVar.ctb.csi.optJSONArray("scope");
        if (optJSONArray == null) {
            Log.e("MicroMsg.JsApiAuthorize", "scope is null!");
            aVar.c("fail", null);
            AppMethodBeat.o(78521);
            return;
        }
        final String appId = aVar.cta.ITw.getAppId();
        if (Util.isNullOrNil(appId)) {
            Log.e("MicroMsg.JsApiAuthorize", "appId is null!");
            aVar.c("fail", null);
            AppMethodBeat.o(78521);
            return;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            linkedList.add(optJSONArray.optString(i2));
        }
        d.a aVar2 = new d.a();
        ceo ceo = new ceo();
        aVar2.iLN = ceo;
        aVar2.iLO = new cep();
        aVar2.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar2.funcId = 1157;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        ceo.jfi = appId;
        ceo.MjX = linkedList;
        ceo.MjZ = 0;
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.c.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(78519);
                Log.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    cep cep = (cep) dVar.iLL.iLR;
                    if (cep == null || cep.Mkb == null) {
                        aVar.c("fail", null);
                        AppMethodBeat.o(78519);
                        return;
                    }
                    int i4 = cep.Mkb.dIZ;
                    String str2 = cep.Mkb.dJa;
                    Log.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i4));
                    if (i4 == -12000) {
                        final LinkedList<drb> linkedList = cep.LRN;
                        final String str3 = cep.xMq;
                        final String str4 = cep.KFs;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.luggage.jsapi.c.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(78518);
                                r rVar = new r(aVar.cta.mContext);
                                AnonymousClass1 r0 = new r.a() {
                                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.c.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.r.a
                                    public final void i(int i2, Bundle bundle) {
                                        AppMethodBeat.i(78517);
                                        Log.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i2));
                                        switch (i2) {
                                            case 1:
                                            case 2:
                                                c cVar = c.this;
                                                String str = appId;
                                                b.a aVar = aVar;
                                                LinkedList<String> linkedList = new LinkedList<>();
                                                Iterator it = ((ArrayList) bundle.getSerializable("key_scope")).iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                d.a aVar2 = new d.a();
                                                cem cem = new cem();
                                                aVar2.iLN = cem;
                                                aVar2.iLO = new cen();
                                                aVar2.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                                                aVar2.funcId = 1158;
                                                aVar2.iLP = 0;
                                                aVar2.respCmdId = 0;
                                                cem.jfi = str;
                                                cem.MjX = linkedList;
                                                cem.MjZ = 0;
                                                cem.MjY = i2;
                                                IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a(aVar, i2) {
                                                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.c.AnonymousClass2 */
                                                    final /* synthetic */ int lno;
                                                    final /* synthetic */ b.a xwD;

                                                    {
                                                        this.xwD = r2;
                                                        this.lno = r3;
                                                    }

                                                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                                                    public final void a(int i2, int i3, String str, d dVar) {
                                                        AppMethodBeat.i(78520);
                                                        Log.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                                        if (i2 != 0 || i3 != 0) {
                                                            this.xwD.c("fail", null);
                                                            AppMethodBeat.o(78520);
                                                        } else if (this.lno == 2) {
                                                            Log.d("MicroMsg.JsApiAuthorize", "press reject button");
                                                            this.xwD.c("fail", null);
                                                            AppMethodBeat.o(78520);
                                                        } else {
                                                            cen cen = (cen) dVar.iLL.iLR;
                                                            if (cen == null || cen.Mkb == null) {
                                                                this.xwD.c("fail", null);
                                                                AppMethodBeat.o(78520);
                                                                return;
                                                            }
                                                            int i4 = cen.Mkb.dIZ;
                                                            String str2 = cen.Mkb.dJa;
                                                            Log.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", Integer.valueOf(i4));
                                                            if (i4 == 0) {
                                                                this.xwD.c("", null);
                                                                AppMethodBeat.o(78520);
                                                                return;
                                                            }
                                                            Log.e("MicroMsg.JsApiAuthorize", "ERROR = %s", str2);
                                                            this.xwD.c("fail", null);
                                                            AppMethodBeat.o(78520);
                                                        }
                                                    }
                                                });
                                                if (i2 == 2) {
                                                    aVar.c("auth_deny", null);
                                                    AppMethodBeat.o(78517);
                                                    return;
                                                }
                                                break;
                                            default:
                                                Log.d("MicroMsg.JsApiAuthorize", "press back button!");
                                                aVar.c("auth_cancel", null);
                                                break;
                                        }
                                        AppMethodBeat.o(78517);
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    Log.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
                                    aVar.c("fail", null);
                                    AppMethodBeat.o(78518);
                                    return;
                                }
                                if (!rVar.a(linkedList, str3, str4, r0)) {
                                    aVar.c("fail", null);
                                }
                                AppMethodBeat.o(78518);
                            }
                        });
                        AppMethodBeat.o(78519);
                    } else if (i4 == 0) {
                        aVar.c("", null);
                        AppMethodBeat.o(78519);
                    } else {
                        Log.e("MicroMsg.JsApiAuthorize", "ERROR = %s", str2);
                        aVar.c("fail", null);
                        AppMethodBeat.o(78519);
                    }
                } else {
                    aVar.c("fail", null);
                    AppMethodBeat.o(78519);
                }
            }
        });
        AppMethodBeat.o(78521);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
