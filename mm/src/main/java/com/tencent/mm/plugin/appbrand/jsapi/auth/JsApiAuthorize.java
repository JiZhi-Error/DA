package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.aa.a.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.f;
import com.tencent.mm.plugin.appbrand.jsapi.auth.g;
import com.tencent.mm.plugin.appbrand.jsapi.auth.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.permission.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends i {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";
    private final k lFM = new k();

    public JsApiAuthorize() {
        AppMethodBeat.i(174773);
        AppMethodBeat.o(174773);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(d dVar, JSONObject jSONObject, int i2, e eVar) {
        AppMethodBeat.i(226701);
        Log.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        AuthorizeTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = dVar.getAppId();
        authorizeTask.lFR = "authorize";
        l OT = dVar.getRuntime().OT();
        if (OT != null) {
            authorizeTask.iOo = OT.leE.kNW;
        }
        AppBrandStatObject TS = a.TS(dVar.getAppId());
        if (TS != null) {
            authorizeTask.lBE = TS.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.lFN = this;
        authorizeTask.lFO = dVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.lqe = i2;
        authorizeTask.lFP = eVar;
        authorizeTask.lGd = new Bundle();
        if (dVar instanceof s) {
            authorizeTask.lGg = 1;
        } else if (dVar instanceof ac) {
            authorizeTask.lGg = 2;
        }
        authorizeTask.bDJ();
        AppBrandMainProcessService.a(authorizeTask);
        AppMethodBeat.o(226701);
    }

    static class AuthorizeTask extends MainProcessTask {
        public static final Parcelable.Creator<AuthorizeTask> CREATOR = new Parcelable.Creator<AuthorizeTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AuthorizeTask[] newArray(int i2) {
                return new AuthorizeTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AuthorizeTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(226694);
                AuthorizeTask authorizeTask = new AuthorizeTask(parcel);
                AppMethodBeat.o(226694);
                return authorizeTask;
            }
        };
        public String appId;
        public String data;
        public int errCode;
        public String errMsg;
        public int iOo;
        private int lBE;
        transient i lFN;
        transient d lFO;
        transient e lFP;
        public ArrayList<String> lFQ;
        public String lFR;
        public String lFS;
        public int lFT;
        public String lFU;
        public String lFV;
        public String lFW;
        public String lFX;
        public boolean lFY;
        public String lFZ;
        public String lGa;
        public String lGb;
        public int lGc;
        public Bundle lGd;
        public String lGe;
        public MMAuthScopeRiskInfo lGf;
        int lGg;
        public String lGh;
        public String lGi;
        public int lqe;
        public String mAppName;

        public interface a {
            void a(MMAuthScopeRiskInfo mMAuthScopeRiskInfo);

            void a(cep cep);

            void ai(int i2, String str);

            void onSuccess();
        }

        static /* synthetic */ void a(AuthorizeTask authorizeTask, String str) {
            AppMethodBeat.i(226700);
            authorizeTask.Zb(str);
            AppMethodBeat.o(226700);
        }

        static /* synthetic */ boolean a(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(46034);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(46034);
            return bDU;
        }

        static /* synthetic */ boolean b(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(46035);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(46035);
            return bDU;
        }

        static /* synthetic */ boolean c(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(46036);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(46036);
            return bDU;
        }

        static /* synthetic */ boolean d(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(46037);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(46037);
            return bDU;
        }

        static /* synthetic */ boolean e(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(46038);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(46038);
            return bDU;
        }

        static /* synthetic */ boolean f(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(226696);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(226696);
            return bDU;
        }

        static /* synthetic */ boolean g(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(226697);
            boolean bDU = authorizeTask.bDU();
            AppMethodBeat.o(226697);
            return bDU;
        }

        public AuthorizeTask() {
        }

        public AuthorizeTask(Parcel parcel) {
            AppMethodBeat.i(46028);
            f(parcel);
            AppMethodBeat.o(46028);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46029);
            final AnonymousClass1 r8 = new a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a
                public final void onSuccess() {
                    AppMethodBeat.i(46019);
                    Log.d("MicroMsg.JsApiAuthorize", "onSuccess !");
                    AuthorizeTask.this.lFS = "ok";
                    AuthorizeTask.a(AuthorizeTask.this);
                    AppMethodBeat.o(46019);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a
                public final void a(MMAuthScopeRiskInfo mMAuthScopeRiskInfo) {
                    AppMethodBeat.i(226689);
                    Log.d("MicroMsg.JsApiAuthorize", "onScopeRiskIntercepted !");
                    AuthorizeTask.this.lFS = "risk_intercepted";
                    AuthorizeTask.this.lGf = mMAuthScopeRiskInfo;
                    AuthorizeTask.b(AuthorizeTask.this);
                    AppMethodBeat.o(226689);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a
                public final void ai(int i2, String str) {
                    AppMethodBeat.i(46020);
                    Log.e("MicroMsg.JsApiAuthorize", "onFailure !");
                    AuthorizeTask.this.lFS = "fail";
                    AuthorizeTask.this.errCode = i2;
                    AuthorizeTask.this.errMsg = str;
                    AuthorizeTask.c(AuthorizeTask.this);
                    AppMethodBeat.o(46020);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a
                public final void a(cep cep) {
                    String str;
                    AppMethodBeat.i(46021);
                    Log.d("MicroMsg.JsApiAuthorize", "onConfirm !");
                    LinkedList<drb> linkedList = cep.LRN;
                    AuthorizeTask.this.lGc = linkedList.size();
                    for (int i2 = 0; i2 < AuthorizeTask.this.lGc; i2++) {
                        try {
                            AuthorizeTask.this.lGd.putByteArray(String.valueOf(i2), linkedList.get(i2).toByteArray());
                        } catch (IOException e2) {
                            Log.e("MicroMsg.JsApiAuthorize", "IOException %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.JsApiAuthorize", e2, "", new Object[0]);
                            AuthorizeTask.this.lFS = "fail";
                            AuthorizeTask.d(AuthorizeTask.this);
                            AppMethodBeat.o(46021);
                            return;
                        }
                    }
                    AuthorizeTask.this.mAppName = cep.xMq;
                    AuthorizeTask.this.lFU = cep.KFs;
                    AuthorizeTask.this.lFV = cep.Mkg;
                    AuthorizeTask.this.lFX = cep.Mkf;
                    AuthorizeTask.this.lFW = cep.Mke;
                    if (cep.Mkh != null) {
                        AuthorizeTask.this.lFY = cep.Mkh.KHU;
                        AuthorizeTask.this.lFZ = cep.Mkh.KHV;
                    }
                    AuthorizeTask.this.lFS = "needConfirm";
                    if (linkedList.size() > 0) {
                        drb drb = linkedList.get(0);
                        AuthorizeTask.this.lGe = drb.MTJ == null ? "" : drb.MTJ;
                        if ("scope.userInfo".equals(drb.KWK)) {
                            AuthorizeTask.this.lGb = z.aUa();
                            StringBuilder sb = new StringBuilder("userNickName=");
                            if (AuthorizeTask.this.lGb == null) {
                                str = "";
                            } else {
                                str = AuthorizeTask.this.lGb;
                            }
                            Log.i("MicroMsg.JsApiAuthorize", sb.append(str).toString());
                            String aTY = z.aTY();
                            g.a aVar = g.lFD;
                            g.a.a(aTY, new g.b() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.g.b
                                public final void UI(String str) {
                                    AppMethodBeat.i(46018);
                                    AuthorizeTask.this.lGa = str;
                                    Log.i("MicroMsg.JsApiAuthorize", " userHeadIconPath=" + (AuthorizeTask.this.lGa == null ? "" : AuthorizeTask.this.lGa));
                                    AuthorizeTask.e(AuthorizeTask.this);
                                    AppMethodBeat.o(46018);
                                }
                            });
                            AppMethodBeat.o(46021);
                            return;
                        }
                        AuthorizeTask.f(AuthorizeTask.this);
                        AppMethodBeat.o(46021);
                        return;
                    }
                    AuthorizeTask.g(AuthorizeTask.this);
                    AppMethodBeat.o(46021);
                }
            };
            if (this.lFR.equals("authorize")) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        linkedList.add(jSONArray.optString(i2));
                    }
                    if (linkedList.size() > 0) {
                        this.lGh = (String) linkedList.get(0);
                    }
                    com.tencent.mm.aa.a.a aVar = new com.tencent.mm.aa.a.a(this.appId, linkedList, this.iOo, this.lBE, new a.AbstractC0240a<com.tencent.mm.aa.a.a>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass5 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                        @Override // com.tencent.mm.aa.a.a.AbstractC0240a
                        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.aa.a.a aVar) {
                            AppMethodBeat.i(46027);
                            com.tencent.mm.aa.a.a aVar2 = aVar;
                            Log.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            if (i2 == 0 && i3 == 0) {
                                cep ayI = aVar2.ayI();
                                int i4 = ayI.Mkb.dIZ;
                                String str2 = ayI.Mkb.dJa;
                                Log.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", Integer.valueOf(i4));
                                if (i4 == -12000) {
                                    r8.a(ayI);
                                    AppMethodBeat.o(46027);
                                } else if (i4 == 0) {
                                    r8.onSuccess();
                                    AppMethodBeat.o(46027);
                                } else {
                                    Log.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                                    r8.ai(i4, str2);
                                    AppMethodBeat.o(46027);
                                }
                            } else {
                                r8.ai(-1, String.format(Locale.ENGLISH, "cgi fail(%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3)));
                                AppMethodBeat.o(46027);
                            }
                        }
                    });
                    if (aVar.ayH().Mka == null) {
                        aVar.ayH().Mka = new fdg();
                    }
                    aVar.ayH().Mka.NyS = this.lGg;
                    com.tencent.mm.kernel.g.azz().a(aVar, 0);
                    AppMethodBeat.o(46029);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiAuthorize", "Exception %s", e2.getMessage());
                    this.lFS = "fail";
                    bDU();
                    AppMethodBeat.o(46029);
                }
            } else {
                if (this.lFR.equals("authorizeConfirm")) {
                    String str = this.appId;
                    ArrayList<String> arrayList = this.lFQ;
                    int i3 = this.iOo;
                    final int i4 = this.lFT;
                    b bVar = new b(str, i.A(arrayList), i3, i4, this.lBE, new b.a<b>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass6 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                        @Override // com.tencent.mm.aa.a.b.a
                        public final /* synthetic */ void a(int i2, int i3, String str, b bVar) {
                            boolean z;
                            AppMethodBeat.i(226695);
                            b bVar2 = bVar;
                            Log.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            if (i2 != 0 || i3 != 0) {
                                r8.ai(-1, "confirm cgi fail");
                                AppMethodBeat.o(226695);
                            } else if (i4 == 2) {
                                Log.d("MicroMsg.JsApiAuthorize", "press reject button");
                                AppMethodBeat.o(226695);
                            } else {
                                cen ayK = bVar2.ayK();
                                int i4 = ayK.Mkb.dIZ;
                                String str2 = ayK.Mkb.dJa;
                                Log.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", Integer.valueOf(i4));
                                if (i4 == 0) {
                                    if (ayK.Mkc == null || ayK.Mkc.size() <= 0 || ayK.Mkc.get(0).KKW == null) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    MMAuthScopeRiskInfo mMAuthScopeRiskInfo = z ? new MMAuthScopeRiskInfo(ayK.Mkc.get(0).KKW) : null;
                                    if (mMAuthScopeRiskInfo != null) {
                                        r8.a(mMAuthScopeRiskInfo);
                                        AppMethodBeat.o(226695);
                                        return;
                                    }
                                    r8.onSuccess();
                                    AppMethodBeat.o(226695);
                                    return;
                                }
                                Log.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", str2);
                                r8.ai(i4, str2);
                                AppMethodBeat.o(226695);
                            }
                        }
                    });
                    if (bVar.ayJ().Mka == null) {
                        bVar.ayJ().Mka = new fdg();
                    }
                    bVar.ayJ().Mka.NyS = this.lGg;
                    com.tencent.mm.kernel.g.azz().a(bVar, 0);
                }
                AppMethodBeat.o(46029);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(46030);
            bDK();
            if (!this.lFO.isRunning()) {
                this.lFP.bEE();
                AppMethodBeat.o(46030);
            } else if (this.lFS.equals("ok")) {
                if (this.lGh == null || Util.isNullOrNil(this.lGi) || this.lGh.equals(this.lGi)) {
                    this.lFN.b(this.lFO, this.lqe, "ok");
                } else {
                    Log.i("MicroMsg.JsApiAuthorize", "targetScope:%s, selectScope:%s", this.lGh, this.lGi);
                    this.lFN.b(this.lFO, this.lqe, "fail auth deny");
                }
                this.lFP.bEE();
                AppMethodBeat.o(46030);
            } else if (this.lFS.equals("fail")) {
                this.lFN.b(this.lFO, this.lqe, Util.isNullOrNil(this.errMsg) ? String.format("fail:login error %s", Integer.valueOf(this.errCode)) : String.format("fail:%s", this.errMsg));
                this.lFP.bEE();
                AppMethodBeat.o(46030);
            } else if (this.lFS.equals("risk_intercepted")) {
                if (this.lGf != null) {
                    h.a(this.lFO.getContext(), this.lGf.dQx, this.lGf.lHB, this.lGf.lHA, h.b.a(this.lFO.getContext(), this.lGf), new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass2 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(226690);
                            AuthorizeTask.this.lFN.b(AuthorizeTask.this.lFO, AuthorizeTask.this.lqe, "fail:risk intercepted");
                            AppMethodBeat.o(226690);
                        }
                    });
                }
                this.lFP.bEE();
                AppMethodBeat.o(46030);
            } else {
                if (this.lFS.equals("needConfirm")) {
                    final LinkedList linkedList = new LinkedList();
                    for (int i2 = 0; i2 < this.lGc; i2++) {
                        byte[] byteArray = this.lGd.getByteArray(String.valueOf(i2));
                        drb drb = new drb();
                        try {
                            drb.parseFrom(byteArray);
                            linkedList.add(drb);
                        } catch (IOException e2) {
                            Log.e("MicroMsg.JsApiAuthorize", "IOException %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.JsApiAuthorize", e2, "", new Object[0]);
                            this.lFN.b(this.lFO, this.lqe, "fail:internal error scope error");
                            this.lFP.bEE();
                            AppMethodBeat.o(46030);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        this.lFO.P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(226693);
                                drb drb = (drb) linkedList.get(0);
                                AppBrandRuntime runtime = AuthorizeTask.this.lFO.getRuntime();
                                boolean a2 = q.a(drb.KWK, runtime.OT());
                                final com.tencent.mm.plugin.appbrand.permission.a.b a3 = b.a.a(AuthorizeTask.this.lFO, new h.b() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass3.AnonymousClass1 */

                                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                                    @Override // com.tencent.mm.plugin.appbrand.permission.a.b.c
                                    public final void a(int i2, ArrayList<String> arrayList, int i3) {
                                        AppMethodBeat.i(226691);
                                        AuthorizeTask.this.lGi = com.tencent.luggage.h.b.G(arrayList).size() > 0 ? arrayList.get(0) : "";
                                        switch (i2) {
                                            case 1:
                                                ArrayList arrayList2 = new ArrayList();
                                                arrayList2.add(AuthorizeTask.this.lGi);
                                                AuthorizeTask.a(AuthorizeTask.this, 1, arrayList2);
                                                Log.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                                                AppMethodBeat.o(226691);
                                                return;
                                            case 2:
                                                ArrayList arrayList3 = new ArrayList();
                                                arrayList3.add(AuthorizeTask.this.lGi);
                                                AuthorizeTask.a(AuthorizeTask.this, 2, arrayList3);
                                                Log.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                                                AppMethodBeat.o(226691);
                                                return;
                                            case 3:
                                                AuthorizeTask.h(AuthorizeTask.this);
                                                Log.i("MicroMsg.JsApiAuthorize", "user cancel");
                                                break;
                                        }
                                        AppMethodBeat.o(226691);
                                    }
                                });
                                a3.setAppBrandName(runtime.OT().brandName);
                                a3.setApplyWording(AuthorizeTask.this.lFV);
                                a3.setRequestDesc(drb.Desc);
                                a3.setNegativeButtonText(AuthorizeTask.this.lFW);
                                a3.setPositiveButtonText(AuthorizeTask.this.lFX);
                                a3.setIconUrl(AuthorizeTask.this.lFU);
                                if (!AuthorizeTask.this.lFY || TextUtils.isEmpty(AuthorizeTask.this.lFZ)) {
                                    a3.ia(false);
                                } else {
                                    a3.ia(true);
                                    a3.setExplainOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.AnonymousClass3.AnonymousClass2 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(226692);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            a3.a(AuthorizeTask.this.lFO, AuthorizeTask.this.lFZ, (ag) AuthorizeTask.this.lFO.M(ag.class)).h(AuthorizeTask.this.lFO);
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(226692);
                                        }
                                    });
                                }
                                if ("scope.userInfo".equals(drb.KWK)) {
                                    g.a aVar = g.lFD;
                                    Context context = AuthorizeTask.this.lFO.getContext();
                                    Bitmap Mq = e.Mq(AuthorizeTask.this.lGa);
                                    String str = AuthorizeTask.this.lGb;
                                    String str2 = drb.KWK;
                                    p.h(context, "context");
                                    p.h(a3, "dialog");
                                    f.c.a(context, Mq, str, str2, a3);
                                } else if (linkedList.size() > 1) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(new i.a(((drb) linkedList.get(0)).MTK, ((drb) linkedList.get(0)).KWK, true));
                                    for (int i2 = 1; i2 < linkedList.size(); i2++) {
                                        arrayList.add(new i.a(((drb) linkedList.get(i2)).MTK, ((drb) linkedList.get(i2)).KWK, false));
                                    }
                                    a3.setFunctionButtonVisibility(8);
                                    a3.setSelectListItem(arrayList);
                                    a3.setScope("");
                                } else {
                                    a3.setScope(drb.KWK);
                                }
                                if (a2) {
                                    if (TextUtils.isEmpty(q.a(drb.KWK, runtime))) {
                                        AuthorizeTask.a(AuthorizeTask.this, "fail:require permission desc");
                                        Log.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                                        AppMethodBeat.o(226693);
                                        return;
                                    }
                                    a3.setSimpleDetailDesc(q.a(drb.KWK, runtime));
                                } else if (!TextUtils.isEmpty(AuthorizeTask.this.lGe)) {
                                    a3.setSimpleDetailDesc(AuthorizeTask.this.lGe);
                                }
                                Log.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", drb.KWK, drb.Desc, drb.Mjt, drb.nBo);
                                a3.h(AuthorizeTask.this.lFO);
                                AppMethodBeat.o(226693);
                            }
                        });
                        AppMethodBeat.o(46030);
                        return;
                    }
                    this.lFN.b(this.lFO, this.lqe, "fail:internal error scope empty");
                    this.lFP.bEE();
                }
                AppMethodBeat.o(46030);
            }
        }

        private void Zb(String str) {
            AppMethodBeat.i(46031);
            if (TextUtils.isEmpty(str)) {
                this.lFN.b(this.lFO, this.lqe, "fail auth cancel");
            } else {
                this.lFN.b(this.lFO, this.lqe, str);
            }
            this.lFP.bEE();
            AppMethodBeat.o(46031);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(46032);
            this.data = parcel.readString();
            this.lqe = parcel.readInt();
            this.appId = parcel.readString();
            this.lFS = parcel.readString();
            this.lFR = parcel.readString();
            this.mAppName = parcel.readString();
            this.lFU = parcel.readString();
            this.lGc = parcel.readInt();
            this.lGd = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.lFQ = parcel.createStringArrayList();
            this.iOo = parcel.readInt();
            this.lFT = parcel.readInt();
            this.lBE = parcel.readInt();
            this.lGg = parcel.readInt();
            this.errCode = parcel.readInt();
            this.errMsg = parcel.readString();
            this.lFX = parcel.readString();
            this.lFW = parcel.readString();
            this.lFV = parcel.readString();
            this.lGa = parcel.readString();
            this.lGb = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lFY = z;
            this.lFZ = parcel.readString();
            this.lGe = parcel.readString();
            this.lGf = (MMAuthScopeRiskInfo) parcel.readParcelable(MMAuthScopeRiskInfo.class.getClassLoader());
            this.lGh = parcel.readString();
            this.lGi = parcel.readString();
            AppMethodBeat.o(46032);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46033);
            parcel.writeString(this.data);
            parcel.writeInt(this.lqe);
            parcel.writeString(this.appId);
            parcel.writeString(this.lFS);
            parcel.writeString(this.lFR);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.lFU);
            parcel.writeInt(this.lGc);
            parcel.writeBundle(this.lGd);
            parcel.writeStringList(this.lFQ);
            parcel.writeInt(this.iOo);
            parcel.writeInt(this.lFT);
            parcel.writeInt(this.lBE);
            parcel.writeInt(this.lGg);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.errMsg);
            parcel.writeString(this.lFX);
            parcel.writeString(this.lFW);
            parcel.writeString(this.lFV);
            parcel.writeString(this.lGa);
            parcel.writeString(this.lGb);
            parcel.writeInt(this.lFY ? 1 : 0);
            parcel.writeString(this.lFZ);
            parcel.writeString(this.lGe);
            parcel.writeParcelable(this.lGf, i2);
            parcel.writeString(this.lGh);
            parcel.writeString(this.lGi);
            AppMethodBeat.o(46033);
        }

        static {
            AppMethodBeat.i(46042);
            AppMethodBeat.o(46042);
        }

        static /* synthetic */ void a(AuthorizeTask authorizeTask, int i2, ArrayList arrayList) {
            AppMethodBeat.i(226698);
            authorizeTask.lFR = "authorizeConfirm";
            authorizeTask.lFQ = arrayList;
            authorizeTask.lFT = i2;
            AppBrandMainProcessService.a(authorizeTask);
            if (i2 == 2) {
                authorizeTask.lFN.b(authorizeTask.lFO, authorizeTask.lqe, "fail auth deny");
                authorizeTask.lFP.bEE();
            }
            AppMethodBeat.o(226698);
        }

        static /* synthetic */ void h(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(226699);
            authorizeTask.Zb("");
            AppMethodBeat.o(226699);
        }
    }
}
