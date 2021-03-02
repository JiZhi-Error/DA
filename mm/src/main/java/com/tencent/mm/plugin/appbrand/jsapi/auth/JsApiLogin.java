package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.c;
import com.tencent.mm.aa.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.c;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLogin extends i {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";
    private final l lGF = new l();

    public JsApiLogin() {
        AppMethodBeat.i(174774);
        AppMethodBeat.o(174774);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final /* bridge */ /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46064);
        a(dVar, jSONObject, i2);
        AppMethodBeat.o(46064);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226702);
        try {
            if (!jSONObject.has("requestInQueue")) {
                jSONObject.put("requestInQueue", false);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", e2.getMessage());
        }
        super.a(dVar, jSONObject, i2);
        AppMethodBeat.o(226702);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(d dVar, JSONObject jSONObject, int i2, e eVar) {
        AppMethodBeat.i(226703);
        LoginTask loginTask = new LoginTask();
        loginTask.appId = dVar.getAppId();
        loginTask.lFR = "login";
        l OT = dVar.getRuntime().OT();
        if (OT != null) {
            loginTask.iOo = OT.leE.kNW;
        }
        AppBrandStatObject TS = a.TS(dVar.getAppId());
        if (TS != null) {
            loginTask.lBE = TS.scene;
        }
        String jSONObject2 = jSONObject.toString();
        loginTask.lFN = this;
        loginTask.lGG = dVar;
        loginTask.data = jSONObject2;
        loginTask.lqe = i2;
        loginTask.lFP = eVar;
        loginTask.lGd = new Bundle();
        if (dVar instanceof s) {
            loginTask.lGg = 1;
        } else if (dVar instanceof ac) {
            loginTask.lGg = 2;
        }
        loginTask.bDJ();
        AppBrandMainProcessService.a(loginTask);
        AppMethodBeat.o(226703);
    }

    static class LoginTask extends MainProcessTask {
        public static final Parcelable.Creator<LoginTask> CREATOR = new Parcelable.Creator<LoginTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LoginTask[] newArray(int i2) {
                return new LoginTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LoginTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46049);
                LoginTask loginTask = new LoginTask(parcel);
                AppMethodBeat.o(46049);
                return loginTask;
            }
        };
        public String appId;
        public String code;
        public String data;
        public int errCode;
        public String errMsg;
        public int iOo;
        public int lBE;
        public String lDx;
        i lFN;
        e lFP;
        public ArrayList<String> lFQ;
        public String lFR;
        public String lFS;
        public int lFT;
        public String lFU;
        k lGG;
        public int lGc;
        public Bundle lGd;
        int lGg;
        public int loginType;
        public int lqe;
        public String mAppName;

        interface a {
            void a(LinkedList<drb> linkedList, String str, String str2, String str3);

            void ai(int i2, String str);

            void onSuccess(String str);
        }

        static /* synthetic */ boolean a(LoginTask loginTask) {
            AppMethodBeat.i(46057);
            boolean bDU = loginTask.bDU();
            AppMethodBeat.o(46057);
            return bDU;
        }

        static /* synthetic */ boolean b(LoginTask loginTask) {
            AppMethodBeat.i(46058);
            boolean bDU = loginTask.bDU();
            AppMethodBeat.o(46058);
            return bDU;
        }

        static /* synthetic */ boolean c(LoginTask loginTask) {
            AppMethodBeat.i(46059);
            boolean bDU = loginTask.bDU();
            AppMethodBeat.o(46059);
            return bDU;
        }

        static /* synthetic */ boolean d(LoginTask loginTask) {
            AppMethodBeat.i(46060);
            boolean bDU = loginTask.bDU();
            AppMethodBeat.o(46060);
            return bDU;
        }

        public LoginTask() {
        }

        public LoginTask(Parcel parcel) {
            AppMethodBeat.i(46052);
            f(parcel);
            AppMethodBeat.o(46052);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46053);
            final AnonymousClass1 r9 = new a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.a
                public final void onSuccess(String str) {
                    AppMethodBeat.i(46044);
                    Log.i("MicroMsg.JsApiLogin", "onSuccess !");
                    LoginTask.this.code = str;
                    LoginTask.this.lFS = "ok";
                    LoginTask.a(LoginTask.this);
                    AppMethodBeat.o(46044);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.a
                public final void ai(int i2, String str) {
                    AppMethodBeat.i(46045);
                    Log.i("MicroMsg.JsApiLogin", "onFailure !");
                    LoginTask.this.lFS = "fail";
                    LoginTask.this.errCode = i2;
                    LoginTask.this.errMsg = str;
                    LoginTask.b(LoginTask.this);
                    AppMethodBeat.o(46045);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.a
                public final void a(LinkedList<drb> linkedList, String str, String str2, String str3) {
                    AppMethodBeat.i(46046);
                    Log.i("MicroMsg.JsApiLogin", "onConfirm !");
                    LoginTask.this.lGc = linkedList.size();
                    for (int i2 = 0; i2 < LoginTask.this.lGc; i2++) {
                        try {
                            LoginTask.this.lGd.putByteArray(String.valueOf(i2), linkedList.get(i2).toByteArray());
                        } catch (IOException e2) {
                            Log.e("MicroMsg.JsApiLogin", "IOException %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.JsApiLogin", e2, "", new Object[0]);
                            LoginTask.this.lFS = "fail";
                            LoginTask.c(LoginTask.this);
                            AppMethodBeat.o(46046);
                            return;
                        }
                    }
                    LoginTask.this.lDx = str3;
                    LoginTask.this.mAppName = str;
                    LoginTask.this.lFU = str2;
                    LoginTask.this.lFS = "needConfirm";
                    LoginTask.d(LoginTask.this);
                    AppMethodBeat.o(46046);
                }
            };
            if (this.lFR.equals("login")) {
                Log.i("MicroMsg.JsApiLogin", "start login");
                LinkedList linkedList = new LinkedList();
                this.loginType = 1;
                this.lDx = "";
                c cVar = new c(this.appId, linkedList, this.loginType, "", this.lDx, this.iOo, this.lBE, new c.a<c>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.AnonymousClass4 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.aa.a.c.a
                    public final /* synthetic */ void a(int i2, int i3, String str, c cVar) {
                        AppMethodBeat.i(46050);
                        c cVar2 = cVar;
                        Log.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            cet ayM = cVar2.ayM();
                            if (ayM == null || ayM.Mkb == null) {
                                r9.ai(-1, String.format("cgi fail response null", new Object[0]));
                                AppMethodBeat.o(46050);
                                return;
                            }
                            int i4 = ayM.Mkb.dIZ;
                            String str2 = ayM.Mkb.dJa;
                            String str3 = ayM.Mkl;
                            Log.i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", Integer.valueOf(i4));
                            if (i4 == -12000) {
                                LinkedList<drb> linkedList = ayM.LRN;
                                String str4 = ayM.xMq;
                                String str5 = ayM.KFs;
                                Log.i("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", str4, str5);
                                r9.a(linkedList, str4, str5, str3);
                                AppMethodBeat.o(46050);
                            } else if (i4 == 0) {
                                String str6 = ayM.Mkm;
                                r9.onSuccess(str6);
                                Log.i("MicroMsg.JsApiLogin", "resp data code [%s]", str6);
                                AppMethodBeat.o(46050);
                            } else if (i4 == -12001) {
                                r9.ai(i4, str2);
                                Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", str2);
                                AppMethodBeat.o(46050);
                            } else if (i4 == -12002) {
                                r9.ai(i4, str2);
                                Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", str2);
                                AppMethodBeat.o(46050);
                            } else if (i4 == -12003) {
                                r9.ai(i4, str2);
                                Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", str2);
                                AppMethodBeat.o(46050);
                            } else {
                                r9.ai(i4, str2);
                                Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                                AppMethodBeat.o(46050);
                            }
                        } else {
                            r9.ai(-1, String.format("cgi fail(%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3)));
                            AppMethodBeat.o(46050);
                        }
                    }
                });
                if (cVar.ayL().Mka == null) {
                    cVar.ayL().Mka = new fdg();
                }
                cVar.ayL().Mka.NyS = this.lGg;
                g.azz().a(cVar, 0);
                AppMethodBeat.o(46053);
                return;
            }
            if (this.lFR.equals("loginConfirm")) {
                Log.i("MicroMsg.JsApiLogin", "start loginConfirm");
                String str = this.appId;
                ArrayList<String> arrayList = this.lFQ;
                int i2 = this.loginType;
                String str2 = this.lDx;
                int i3 = this.iOo;
                final int i4 = this.lFT;
                com.tencent.mm.aa.a.d dVar = new com.tencent.mm.aa.a.d(str, i.A(arrayList), i2, str2, i3, i4, this.lBE, new d.a<com.tencent.mm.aa.a.d>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.AnonymousClass5 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.aa.a.d.a
                    public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.aa.a.d dVar) {
                        AppMethodBeat.i(46051);
                        com.tencent.mm.aa.a.d dVar2 = dVar;
                        Log.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 != 0 || i3 != 0) {
                            r9.ai(-1, "confirm cgi fail");
                            AppMethodBeat.o(46051);
                        } else if (i4 == 2) {
                            Log.i("MicroMsg.JsApiLogin", "press reject button");
                            r9.ai(i3, "auth deny");
                            AppMethodBeat.o(46051);
                        } else {
                            cer ayO = dVar2.ayO();
                            int i4 = ayO.Mkb.dIZ;
                            String str2 = ayO.Mkb.dJa;
                            Log.i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", Integer.valueOf(i4));
                            if (i4 == 0) {
                                String str3 = ayO.Mkm;
                                r9.onSuccess(str3);
                                Log.i("MicroMsg.JsApiLogin", "resp data code [%s]", str3);
                                AppMethodBeat.o(46051);
                                return;
                            }
                            r9.ai(i4, str2);
                            Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", str2);
                            AppMethodBeat.o(46051);
                        }
                    }
                });
                if (dVar.ayN().Mka == null) {
                    dVar.ayN().Mka = new fdg();
                }
                dVar.ayN().Mka.NyS = this.lGg;
                g.azz().a(dVar, 0);
            }
            AppMethodBeat.o(46053);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(46054);
            bDK();
            if (!this.lGG.isRunning()) {
                this.lFP.bEE();
                AppMethodBeat.o(46054);
            } else if (this.lFS.equals("ok")) {
                HashMap hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.code);
                this.lGG.i(this.lqe, this.lFN.n("ok", hashMap));
                this.lFP.bEE();
                AppMethodBeat.o(46054);
            } else if (this.lFS.equals("fail")) {
                this.lFN.b(this.lGG, this.lqe, Util.isNullOrNil(this.errMsg) ? String.format("fail:login error %s", Integer.valueOf(this.errCode)) : String.format("fail:%s", this.errMsg));
                this.lFP.bEE();
                AppMethodBeat.o(46054);
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
                            Log.e("MicroMsg.JsApiLogin", "parse scope info error %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.JsApiLogin", e2, "", new Object[0]);
                            this.lFN.b(this.lGG, this.lqe, "fail:internal error scope error");
                            this.lFP.bEE();
                            AppMethodBeat.o(46054);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(46048);
                                LoginTask.this.lGG.getDialogContainer().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(i.b(LoginTask.this.lGG), i.y(linkedList), LoginTask.this.mAppName, LoginTask.this.lFU, new c.a() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.AnonymousClass2.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.c.a
                                    public final void a(int i2, ArrayList<String> arrayList) {
                                        AppMethodBeat.i(46047);
                                        Log.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", Integer.valueOf(i2));
                                        switch (i2) {
                                            case 1:
                                            case 2:
                                                LoginTask.this.lFR = "loginConfirm";
                                                LoginTask.this.lFQ = arrayList;
                                                LoginTask.this.lFT = i2;
                                                AppBrandMainProcessService.a(LoginTask.this);
                                                if (i2 == 2) {
                                                    LoginTask.this.lFN.b(LoginTask.this.lGG, LoginTask.this.lqe, "fail auth deny");
                                                    LoginTask.this.lFP.bEE();
                                                    AppMethodBeat.o(46047);
                                                    return;
                                                }
                                                break;
                                            default:
                                                Log.d("MicroMsg.JsApiLogin", "press back button!");
                                                LoginTask.this.lFN.b(LoginTask.this.lGG, LoginTask.this.lqe, "fail auth cancel");
                                                LoginTask.this.lFP.bEE();
                                                break;
                                        }
                                        AppMethodBeat.o(46047);
                                    }
                                }));
                                AppMethodBeat.o(46048);
                            }
                        });
                        AppMethodBeat.o(46054);
                        return;
                    }
                    this.lFN.b(this.lGG, this.lqe, "fail:internal error scope empty");
                    this.lFP.bEE();
                }
                AppMethodBeat.o(46054);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(46055);
            this.data = parcel.readString();
            this.lqe = parcel.readInt();
            this.lFR = parcel.readString();
            this.appId = parcel.readString();
            this.code = parcel.readString();
            this.lFS = parcel.readString();
            this.lDx = parcel.readString();
            this.loginType = parcel.readInt();
            this.mAppName = parcel.readString();
            this.lFU = parcel.readString();
            this.lGc = parcel.readInt();
            this.lGd = parcel.readBundle(JsApiLogin.class.getClassLoader());
            this.lFQ = parcel.createStringArrayList();
            this.iOo = parcel.readInt();
            this.lFT = parcel.readInt();
            this.lBE = parcel.readInt();
            this.lGg = parcel.readInt();
            this.errCode = parcel.readInt();
            this.errMsg = parcel.readString();
            AppMethodBeat.o(46055);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46056);
            parcel.writeString(this.data);
            parcel.writeInt(this.lqe);
            parcel.writeString(this.lFR);
            parcel.writeString(this.appId);
            parcel.writeString(this.code);
            parcel.writeString(this.lFS);
            parcel.writeString(this.lDx);
            parcel.writeInt(this.loginType);
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
            AppMethodBeat.o(46056);
        }

        static {
            AppMethodBeat.i(46061);
            AppMethodBeat.o(46061);
        }
    }
}
