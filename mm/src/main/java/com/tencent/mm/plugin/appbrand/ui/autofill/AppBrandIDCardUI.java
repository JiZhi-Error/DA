package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.ees;
import com.tencent.mm.protocal.protobuf.eet;
import com.tencent.mm.protocal.protobuf.epy;
import com.tencent.mm.protocal.protobuf.epz;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI extends MMActivity {
    public static final int nZt = R.id.oi;
    private String appId;
    private int iDM;
    private e jCK;
    private dyd nZA;
    private hv nZB;
    private LinkedList<Integer> nZC;
    private String nZD;
    private String nZE;
    private String nZF;
    private int nZG;
    private com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a nZH;
    private q nZI;
    private PhoneItem nZJ;
    private a nZf = new a() {
        /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void bXR() {
            AppMethodBeat.i(48929);
            d.a aVar = new d.a();
            aVar.iLN = new dyc();
            aVar.iLO = new dyd();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
            aVar.funcId = 1774;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            dyc dyc = (dyc) aXF.iLK.iLR;
            dyc.dNI = AppBrandIDCardUI.this.appId;
            dyc.MNJ = AppBrandIDCardUI.this.nZC;
            dyc.MNK = AppBrandIDCardUI.this.iDM;
            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(48922);
                    if (AppBrandIDCardUI.this.nZI != null && AppBrandIDCardUI.this.nZI.isShowing()) {
                        AppBrandIDCardUI.this.nZI.dismiss();
                    }
                    if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                        dyd dyd = (dyd) dVar.iLL.iLR;
                        if (dyd.MVQ == null) {
                            Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                            Intent intent = new Intent();
                            intent.putExtra("intent_err_code", 40000);
                            intent.putExtra("intent_err_msg", "network err");
                            AppBrandIDCardUI.this.setResult(1, intent);
                            AppBrandIDCardUI.this.finish();
                            AppMethodBeat.o(48922);
                            return;
                        }
                        Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", Integer.valueOf(dyd.MVQ.dOK));
                        Log.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", Integer.valueOf(dyd.MXG));
                        switch (dyd.MXG) {
                            case 0:
                                if (dyd.MVQ.dOK != 0) {
                                    Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("intent_err_code", dyd.MVQ.dOK);
                                    intent2.putExtra("intent_err_msg", dyd.MVQ.dOL);
                                    AppBrandIDCardUI.this.setResult(1, intent2);
                                    AppBrandIDCardUI.this.finish();
                                    AppMethodBeat.o(48922);
                                    return;
                                }
                                AppBrandIDCardUI.this.nZA = dyd;
                                if (AppBrandIDCardUI.this.nZG == 0) {
                                    AppBrandIDCardUI.f(AppBrandIDCardUI.this);
                                    AppMethodBeat.o(48922);
                                    return;
                                } else if (AppBrandIDCardUI.this.nZG == 1) {
                                    AppBrandIDCardUI.g(AppBrandIDCardUI.this);
                                    AppMethodBeat.o(48922);
                                    return;
                                } else if (AppBrandIDCardUI.this.nZG == 2) {
                                    AppBrandIDCardUI.h(AppBrandIDCardUI.this);
                                    AppMethodBeat.o(48922);
                                    return;
                                }
                                break;
                            case 1:
                                Log.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", Integer.valueOf(dyd.MVQ.dOK), dyd.MVQ.dOL);
                                AnonymousClass1 r8 = AnonymousClass1.this;
                                h.a((Context) AppBrandIDCardUI.this, false, dyd.MXH.desc, dyd.MXH.title, AppBrandIDCardUI.this.getString(R.string.m5), "", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(dyd.MVQ.dOK, dyd.MVQ.dOL) {
                                    /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass2 */
                                    final /* synthetic */ int val$errCode;
                                    final /* synthetic */ String val$errMsg;

                                    {
                                        this.val$errCode = r2;
                                        this.val$errMsg = r3;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(48923);
                                        Intent intent = new Intent();
                                        intent.putExtra("intent_err_code", Util.nullAsInt(Integer.valueOf(this.val$errCode), 0));
                                        intent.putExtra("intent_err_msg", Util.nullAsNil(this.val$errMsg));
                                        AppBrandIDCardUI.this.setResult(1, intent);
                                        AppBrandIDCardUI.this.finish();
                                        AppMethodBeat.o(48923);
                                    }
                                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass3 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                });
                                AppMethodBeat.o(48922);
                                return;
                            default:
                                Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
                                break;
                        }
                        AppMethodBeat.o(48922);
                        return;
                    }
                    Log.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                    Intent intent3 = new Intent();
                    intent3.putExtra("intent_err_code", 40000);
                    intent3.putExtra("intent_err_msg", "network err");
                    AppBrandIDCardUI.this.setResult(1, intent3);
                    AppBrandIDCardUI.this.finish();
                    AppMethodBeat.o(48922);
                }
            });
            AppMethodBeat.o(48929);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void onSwipeBack() {
            AppMethodBeat.i(48930);
            AppBrandIDCardUI.this.onSwipeBack();
            AppMethodBeat.o(48930);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void back() {
            AppMethodBeat.i(48931);
            AppBrandIDCardUI.i(AppBrandIDCardUI.this);
            AppMethodBeat.o(48931);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void aft(String str) {
            AppMethodBeat.i(48932);
            Log.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
            AppBrandIDCardUI.a(AppBrandIDCardUI.this, str);
            AppMethodBeat.o(48932);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void afu(String str) {
            AppMethodBeat.i(48933);
            Log.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
            AppBrandIDCardUI.a(AppBrandIDCardUI.this, str);
            AppMethodBeat.o(48933);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void afv(String str) {
            AppMethodBeat.i(48934);
            Log.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
            AppBrandIDCardUI.a(AppBrandIDCardUI.this, str);
            AppMethodBeat.o(48934);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void bXS() {
            AppMethodBeat.i(48935);
            Log.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 2, AppBrandIDCardUI.this.nZA.dHx);
            if (AppBrandIDCardUI.this.nZA.MXN == null) {
                Log.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
                AppMethodBeat.o(48935);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", AppBrandIDCardUI.this.nZA.MXN.dNI);
                jSONObject.put("timeStamp", AppBrandIDCardUI.this.nZA.MXN.dmc);
                jSONObject.put("nonceStr", AppBrandIDCardUI.this.nZA.MXN.Mju);
                jSONObject.put("package", AppBrandIDCardUI.this.nZA.MXN.NnP);
                jSONObject.put("signType", AppBrandIDCardUI.this.nZA.MXN.qcK);
                jSONObject.put("paySign", AppBrandIDCardUI.this.nZA.MXN.MiN);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 3, AppBrandIDCardUI.this.nZA.dHx);
                AppBrandJsApiPayService.INSTANCE.verifyPassword(AppBrandIDCardUI.this, null, jSONObject, new a.d() {
                    /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.d
                    public final void p(boolean z, final String str) {
                        AppMethodBeat.i(48925);
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 4, AppBrandIDCardUI.this.nZA.dHx);
                            d.a aVar = new d.a();
                            aVar.iLN = new ees();
                            aVar.iLO = new eet();
                            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                            aVar.funcId = 1721;
                            aVar.iLP = 0;
                            aVar.respCmdId = 0;
                            d aXF = aVar.aXF();
                            ees ees = (ees) aXF.iLK.iLR;
                            ees.dNI = AppBrandIDCardUI.this.appId;
                            ees.MNJ = AppBrandIDCardUI.this.nZC;
                            ees.MVO = str;
                            ees.dHx = AppBrandIDCardUI.this.nZA.dHx;
                            if ((AppBrandIDCardUI.this.nZG == 1 || AppBrandIDCardUI.this.nZG == 2) && AppBrandIDCardUI.this.nZJ != null && !AppBrandIDCardUI.this.nZJ.nzy) {
                                ees.MVP = Util.nullAsNil(AppBrandIDCardUI.this.nZJ.dSf);
                            }
                            if (AppBrandIDCardUI.this.nZI != null && !AppBrandIDCardUI.this.nZI.isShowing()) {
                                AppBrandIDCardUI.this.nZI.show();
                            }
                            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass4.AnonymousClass1 */

                                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                                public final void a(int i2, int i3, String str, d dVar) {
                                    AppMethodBeat.i(48924);
                                    if (AppBrandIDCardUI.this.nZI != null && AppBrandIDCardUI.this.nZI.isShowing()) {
                                        AppBrandIDCardUI.this.nZI.dismiss();
                                    }
                                    if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                        eet eet = (eet) dVar.iLL.iLR;
                                        if (eet.MVQ == null) {
                                            Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                                            Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(R.string.m4), 0).show();
                                            AppMethodBeat.o(48924);
                                            return;
                                        }
                                        Log.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", Integer.valueOf(eet.KLv));
                                        switch (eet.KLv) {
                                            case 0:
                                                Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", eet.LpC);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 9, AppBrandIDCardUI.this.nZA.dHx);
                                                if ((AppBrandIDCardUI.this.nZG == 1 || AppBrandIDCardUI.this.nZG == 2) && AppBrandIDCardUI.this.nZJ != null) {
                                                    r rVar = r.nzC;
                                                    r.b(AppBrandIDCardUI.this.nZJ);
                                                }
                                                Intent intent = new Intent();
                                                intent.putExtra("intent_err_code", eet.MVQ.dOK);
                                                intent.putExtra("intent_auth_token", eet.LpC);
                                                AppBrandIDCardUI.this.setResult(-1, intent);
                                                AppBrandIDCardUI.this.finish();
                                                AppMethodBeat.o(48924);
                                                return;
                                            case 1:
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 5, AppBrandIDCardUI.this.nZA.dHx);
                                                AppBrandIDCardUI.this.nZD = str;
                                                AppBrandIDCardUI.this.nZB = eet.NeP;
                                                AppBrandIDCardUI.l(AppBrandIDCardUI.this);
                                                break;
                                        }
                                        AppMethodBeat.o(48924);
                                        return;
                                    }
                                    Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                                    AppMethodBeat.o(48924);
                                }
                            });
                        } else if (AppBrandIDCardUI.this.nZG == 1 || AppBrandIDCardUI.this.nZG == 2) {
                            AppBrandIDCardUI.this.setResult(0);
                            AppBrandIDCardUI.this.finish();
                        }
                        Log.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", Boolean.valueOf(z));
                        AppMethodBeat.o(48925);
                    }
                });
                AppMethodBeat.o(48935);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e2, "", new Object[0]);
                AppMethodBeat.o(48935);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void bXT() {
            AppMethodBeat.i(48936);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 6, AppBrandIDCardUI.this.nZA.dHx);
            AppMethodBeat.o(48936);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void a(hu huVar) {
            AppMethodBeat.i(48937);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 7, AppBrandIDCardUI.this.nZA.dHx);
            Log.i("MicroMsg.AppBrandIDCardUI", "sendSms");
            d.a aVar = new d.a();
            aVar.iLN = new due();
            aVar.iLO = new duf();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
            aVar.funcId = 1762;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            due due = (due) aXF.iLK.iLR;
            due.dNI = AppBrandIDCardUI.this.appId;
            due.MNJ = AppBrandIDCardUI.this.nZC;
            due.MVO = AppBrandIDCardUI.this.nZD;
            due.KLH = huVar.KLH;
            due.dDj = huVar.dDj;
            due.dHx = AppBrandIDCardUI.this.nZA.dHx;
            if ((AppBrandIDCardUI.this.nZG == 1 || AppBrandIDCardUI.this.nZG == 2) && AppBrandIDCardUI.this.nZJ != null && !AppBrandIDCardUI.this.nZJ.nzy) {
                due.MVP = Util.nullAsNil(AppBrandIDCardUI.this.nZJ.dSf);
            }
            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass5 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(48926);
                    if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                        duf duf = (duf) dVar.iLL.iLR;
                        if (duf.MVQ != null) {
                            Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", Integer.valueOf(duf.MVQ.dOK));
                            if (duf.MVQ.dOK == 0) {
                                AppBrandIDCardUI.this.nZE = duf.MVR;
                                Log.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", duf.MVR);
                                AppMethodBeat.o(48926);
                                return;
                            }
                            AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.m_));
                            AppMethodBeat.o(48926);
                            return;
                        }
                        Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
                        AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.m_));
                        AppMethodBeat.o(48926);
                        return;
                    }
                    Log.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                    Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(R.string.m4), 0).show();
                    AppMethodBeat.o(48926);
                }
            });
            AppMethodBeat.o(48937);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final void a(String str, hu huVar) {
            AppMethodBeat.i(48938);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
                AppMethodBeat.o(48938);
                return;
            }
            Log.i("MicroMsg.AppBrandIDCardUI", "verifySms");
            d.a aVar = new d.a();
            aVar.iLN = new epy();
            aVar.iLO = new epz();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
            aVar.funcId = 1721;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            d aXF = aVar.aXF();
            epy epy = (epy) aXF.iLK.iLR;
            epy.dNI = AppBrandIDCardUI.this.appId;
            epy.MNJ = AppBrandIDCardUI.this.nZC;
            epy.MVO = AppBrandIDCardUI.this.nZD;
            epy.KLH = huVar.KLH;
            epy.dHx = AppBrandIDCardUI.this.nZA.dHx;
            epy.IaW = str;
            epy.MVR = AppBrandIDCardUI.this.nZE;
            epy.dDj = huVar.dDj;
            if ((AppBrandIDCardUI.this.nZG == 1 || AppBrandIDCardUI.this.nZG == 2) && AppBrandIDCardUI.this.nZJ != null && !AppBrandIDCardUI.this.nZJ.nzy) {
                epy.MVP = Util.nullAsNil(AppBrandIDCardUI.this.nZJ.dSf);
            }
            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass6 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(48927);
                    if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                        epz epz = (epz) dVar.iLL.iLR;
                        if (epz.MVQ != null) {
                            Log.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", Integer.valueOf(epz.MVQ.dOK), Util.nullAsNil(epz.MVQ.dOL));
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 8, AppBrandIDCardUI.this.nZA.dHx);
                            if (epz.MVQ.dOK == 0) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14943, AppBrandIDCardUI.this.appId, 9, AppBrandIDCardUI.this.nZA.dHx);
                                Log.i("MicroMsg.AppBrandIDCardUI", "verify success");
                                Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", epz.LpC);
                                if ((AppBrandIDCardUI.this.nZG == 1 || AppBrandIDCardUI.this.nZG == 2) && AppBrandIDCardUI.this.nZJ != null) {
                                    r rVar = r.nzC;
                                    r.b(AppBrandIDCardUI.this.nZJ);
                                }
                                Intent intent = new Intent();
                                intent.putExtra("intent_err_code", epz.MVQ.dOK);
                                intent.putExtra("intent_auth_token", epz.LpC);
                                AppBrandIDCardUI.this.setResult(-1, intent);
                                AppBrandIDCardUI.this.finish();
                                AppMethodBeat.o(48927);
                            } else if (epz.MVQ.dOK == 40013) {
                                AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.m9));
                                AppMethodBeat.o(48927);
                            } else {
                                AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.m8));
                                AppMethodBeat.o(48927);
                            }
                        } else {
                            Log.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
                            AppMethodBeat.o(48927);
                        }
                    } else {
                        Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                        Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(R.string.m4), 0).show();
                        AppMethodBeat.o(48927);
                    }
                }
            });
            AppMethodBeat.o(48938);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final dyd bXU() {
            AppMethodBeat.i(48939);
            dyd dyd = AppBrandIDCardUI.this.nZA;
            AppMethodBeat.o(48939);
            return dyd;
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a
        public final hv bXV() {
            AppMethodBeat.i(48940);
            hv hvVar = AppBrandIDCardUI.this.nZB;
            AppMethodBeat.o(48940);
            return hvVar;
        }

        static /* synthetic */ void a(AnonymousClass1 r9, String str) {
            AppMethodBeat.i(227706);
            h.a((Context) AppBrandIDCardUI.this, false, str, "", AppBrandIDCardUI.this.getString(R.string.jn), "", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(48928);
                    Log.i("MicroMsg.AppBrandIDCardUI", "[showVerifySmsAlert] btn click");
                    AppMethodBeat.o(48928);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass1.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(227706);
        }
    };
    public MMFragment nZu;
    private String nZv;
    private String nZw;
    private int nZx;
    private String nZy;
    private String nZz;

    public interface a {
        void a(hu huVar);

        void a(String str, hu huVar);

        void aft(String str);

        void afu(String str);

        void afv(String str);

        void bXR();

        void bXS();

        void bXT();

        dyd bXU();

        hv bXV();

        void back();

        void onSwipeBack();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandIDCardUI() {
        AppMethodBeat.i(48952);
        AppMethodBeat.o(48952);
    }

    static /* synthetic */ void a(AppBrandIDCardUI appBrandIDCardUI, int i2) {
        AppMethodBeat.i(227720);
        appBrandIDCardUI.zs(i2);
        AppMethodBeat.o(227720);
    }

    static /* synthetic */ void f(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(48962);
        appBrandIDCardUI.bXQ();
        AppMethodBeat.o(48962);
    }

    static /* synthetic */ void i(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(227716);
        appBrandIDCardUI.back();
        AppMethodBeat.o(227716);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(48953);
        super.onCreateBeforeSetContentView();
        if (this.nZG == 1 || this.nZG == 2) {
            setTheme(R.style.q6);
        }
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        AppMethodBeat.o(48953);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48954);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.nZG = extras.getInt("id_ui_theme", 0);
        }
        super.onCreate(bundle);
        if (extras == null) {
            Log.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
            finish();
            AppMethodBeat.o(48954);
            return;
        }
        this.appId = extras.getString("intent_appid", "");
        this.nZv = extras.getString("wecoin_protocol_url", "");
        this.nZw = extras.getString("wecoin_apply_info", "");
        this.nZx = extras.getInt("wecoin_kv_scene_id", 1);
        this.nZy = extras.getString("wecoin_kv_session_id", "");
        this.nZz = extras.getString("wecoin_kv_cgi_session_id", "");
        if (Util.isNullOrNil(this.appId)) {
            Log.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
            finish();
            AppMethodBeat.o(48954);
            return;
        }
        this.nZC = T(extras);
        if (Util.isNullOrNil(this.nZC) || this.nZC.size() <= 0) {
            Log.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
            Intent intent = new Intent();
            intent.putExtra("intent_err_code", 40003);
            intent.putExtra("intent_err_msg", "category_id is null");
            setResult(1, intent);
            finish();
            AppMethodBeat.o(48954);
            return;
        }
        this.iDM = extras.getInt("intent_auth_type", 1);
        getContentView().setBackgroundColor(getResources().getColor(R.color.a2r));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(nZt);
        ((ViewGroup) getContentView()).addView(frameLayout, layoutParams);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48944);
                AppBrandIDCardUI.i(AppBrandIDCardUI.this);
                AppMethodBeat.o(48944);
                return true;
            }
        });
        getString(R.string.zb);
        this.nZI = h.a((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass12 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(48945);
                AppBrandIDCardUI.this.setResult(0);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48945);
            }
        });
        this.nZI.show();
        if (this.nZG == 1 || this.nZG == 2) {
            ao.e(getWindow());
            getContentView().setBackgroundColor(0);
            getContentView().findViewById(nZt).setBackgroundColor(0);
            this.jCK = new e(getContext());
            View childAt = ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
            if (((ViewGroup) getWindow().getDecorView()).getChildAt(0) instanceof ViewGroup) {
                Log.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
                childAt.setFitsSystemWindows(false);
                try {
                    ((ViewGroup) childAt).addView(this.jCK);
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", e2);
                    ((ViewGroup) getContentView()).addView(this.jCK);
                }
            } else {
                Log.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
                ((ViewGroup) getContentView()).addView(this.jCK);
            }
        }
        this.nZf.bXR();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(48955);
        back();
        AppMethodBeat.o(48955);
    }

    private void back() {
        AppMethodBeat.i(48956);
        if (!(this.nZu instanceof AppBrandIDCardVerifyPwdFrag) || this.nZG != 0) {
            if (!(this.nZG == 1 || this.nZG == 2) || this.jCK == null || !this.jCK.onBackPressed()) {
                finish();
            }
            AppMethodBeat.o(48956);
            return;
        }
        bXQ();
        AppMethodBeat.o(48956);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(48957);
        back();
        AppMethodBeat.o(48957);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(48958);
        if (this.nZI != null && this.nZI.isShowing()) {
            this.nZI.dismiss();
        }
        if (!(this.jCK == null || this.nZH == null)) {
            this.jCK.c(this.nZH);
        }
        super.finish();
        if (this.nZG == 1 || this.nZG == 2) {
            overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(48958);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(48959);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.AppBrandIDCardUI", "onActivityResult, requestcode: %d", Integer.valueOf(i2));
        switch (i2) {
            case 10000:
            case 10001:
                if (this.nZH == null) {
                    Log.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
                    break;
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a aVar = this.nZH;
                    r rVar = r.nzC;
                    aVar.setPhoneItems((ArrayList) r.bTy());
                    AppMethodBeat.o(48959);
                    return;
                }
        }
        AppMethodBeat.o(48959);
    }

    private static LinkedList<Integer> T(Bundle bundle) {
        AppMethodBeat.i(48960);
        LinkedList<Integer> linkedList = new LinkedList<>();
        try {
            String string = bundle.getString("intent_category_id");
            Log.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", string);
            JSONArray jSONArray = new JSONArray(string);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                linkedList.add(Integer.valueOf(jSONArray.optInt(i2)));
            }
            AppMethodBeat.o(48960);
            return linkedList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e2, "", new Object[0]);
            AppMethodBeat.o(48960);
            return null;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean noActionBar() {
        return true;
    }

    private void bXQ() {
        AppMethodBeat.i(48961);
        Log.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
        this.nZu = new AppBrandIDCardShowFrag();
        ((AppBrandIDCardShowFrag) this.nZu).nZf = this.nZf;
        getSupportFragmentManager().beginTransaction().b(nZt, this.nZu).commitAllowingStateLoss();
        AppMethodBeat.o(48961);
    }

    private void zs(int i2) {
        AppMethodBeat.i(227715);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21655, Integer.valueOf(this.nZx), this.nZy, Integer.valueOf(i2), this.nZz);
        AppMethodBeat.o(227715);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void g(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(48963);
        if (!(appBrandIDCardUI.nZH == null || appBrandIDCardUI.jCK == null)) {
            appBrandIDCardUI.jCK.c(appBrandIDCardUI.nZH);
        }
        if (appBrandIDCardUI.nZA == null) {
            Log.e("MicroMsg.AppBrandIDCardUI", "lost idcard show info");
            appBrandIDCardUI.setResult(0);
            appBrandIDCardUI.finish();
            AppMethodBeat.o(48963);
        } else if (appBrandIDCardUI.nZA.MXQ == null) {
            Log.e("MicroMsg.AppBrandIDCardUI", "lost idcard info");
            appBrandIDCardUI.setResult(0);
            appBrandIDCardUI.finish();
            AppMethodBeat.o(48963);
        } else {
            appBrandIDCardUI.nZH = new com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a(appBrandIDCardUI.getContext());
            com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a aVar = appBrandIDCardUI.nZH;
            AnonymousClass13 r1 = new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass13 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48946);
                    if (AppBrandIDCardUI.this.nZA.MXQ.KLF == null) {
                        Log.e("MicroMsg.AppBrandIDCardUI", "scope_wording is null");
                        AppMethodBeat.o(48946);
                    } else {
                        AppBrandIDCardUI.a(AppBrandIDCardUI.this, Util.nullAsNil(AppBrandIDCardUI.this.nZA.MXQ.KLF.title), Util.nullAsNil(AppBrandIDCardUI.this.nZA.MXQ.KLF.dQx), AppBrandIDCardUI.this.nZH.jBN.getMeasuredHeight());
                        AppMethodBeat.o(48946);
                    }
                    return null;
                }
            };
            p.h(r1, "<set-?>");
            aVar.lJt = r1;
            appBrandIDCardUI.nZH.y(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass14 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48947);
                    if (AppBrandIDCardUI.this.nZA.MXQ.KLG == null) {
                        Log.e("MicroMsg.AppBrandIDCardUI", "authorize_wording is null");
                        AppMethodBeat.o(48947);
                    } else {
                        AppBrandIDCardUI.a(AppBrandIDCardUI.this, Util.nullAsNil(AppBrandIDCardUI.this.nZA.MXQ.KLG.title), Util.nullAsNil(AppBrandIDCardUI.this.nZA.MXQ.KLG.qPT), AppBrandIDCardUI.this.nZH.jBN.getMeasuredHeight());
                        AppMethodBeat.o(48947);
                    }
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnAccept(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass15 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48948);
                    AppBrandIDCardUI.this.nZJ = AppBrandIDCardUI.this.nZH.bEU();
                    if (!(AppBrandIDCardUI.this.jCK == null || AppBrandIDCardUI.this.nZH == null)) {
                        AppBrandIDCardUI.this.jCK.c(AppBrandIDCardUI.this.nZH);
                    }
                    AppBrandIDCardUI.this.nZf.bXS();
                    AppMethodBeat.o(48948);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.x(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass16 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48949);
                    AppBrandIDCardUI.this.setResult(0);
                    AppBrandIDCardUI.this.finish();
                    AppMethodBeat.o(48949);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnCancel(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass17 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48950);
                    AppBrandIDCardUI.this.setResult(0);
                    AppBrandIDCardUI.this.finish();
                    AppMethodBeat.o(48950);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnAddPhoneNumber(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass18 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48951);
                    Intent intent = new Intent(AppBrandIDCardUI.this.getContext(), PhoneNumberAddUI.class);
                    intent.putExtra("APPID", AppBrandIDCardUI.this.appId);
                    AppBrandIDCardUI.this.startActivityForResult(intent, 10000);
                    AppMethodBeat.o(48951);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnManagePhoneNumber(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(48942);
                    Intent intent = new Intent(AppBrandIDCardUI.this.getContext(), PhoneNumberManagerUI.class);
                    intent.putExtra("APPID", AppBrandIDCardUI.this.appId);
                    intent.putExtra("PAGEPATH", Util.nullAsNil(AppBrandIDCardUI.this.nZF));
                    AppBrandIDCardUI.this.startActivityForResult(intent, 10001);
                    AppMethodBeat.o(48942);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setIconUrl(appBrandIDCardUI.nZA.Mzt);
            appBrandIDCardUI.nZH.setAppBrandName(appBrandIDCardUI.nZA.ixZ);
            appBrandIDCardUI.nZH.Zs(appBrandIDCardUI.nZA.MXQ.KLC);
            appBrandIDCardUI.nZH.Zt(appBrandIDCardUI.nZA.MXQ.KLD);
            appBrandIDCardUI.nZH.Zu(appBrandIDCardUI.nZA.MXQ.KLE);
            appBrandIDCardUI.nZH.g(Boolean.valueOf(appBrandIDCardUI.nZA.MXO));
            appBrandIDCardUI.nZH.Zv(appBrandIDCardUI.nZA.MXK);
            appBrandIDCardUI.nZH.Zw(appBrandIDCardUI.nZA.MXP);
            if (appBrandIDCardUI.nZA.MXQ.KLG != null) {
                appBrandIDCardUI.nZH.Zx(appBrandIDCardUI.nZA.MXQ.KLG.dQx);
            }
            if (appBrandIDCardUI.nZA.MXQ.KLA != null) {
                appBrandIDCardUI.nZH.Zy(appBrandIDCardUI.nZA.MXQ.KLA.KLy + " " + appBrandIDCardUI.nZA.MXQ.KLA.KLz);
            } else {
                Log.i("MicroMsg.AppBrandIDCardUI", "no id card info");
            }
            ArrayList arrayList = new ArrayList();
            if (appBrandIDCardUI.nZA.MXQ.KLB != null) {
                if (appBrandIDCardUI.nZA.MXQ.KLB.LSi != null) {
                    dbj dbj = appBrandIDCardUI.nZA.MXQ.KLB.LSi;
                    arrayList.add(new PhoneItem(Util.nullAsNil(dbj.dSf), Util.nullAsNil(dbj.Lli), Util.nullAsNil(dbj.nzu), Util.nullAsNil(dbj.bxK), Util.nullAsNil(dbj.nzv), dbj.MGs, dbj.MGt, true, false));
                }
                if (appBrandIDCardUI.nZA.MXQ.KLB.LSj != null) {
                    Iterator<dbj> it = appBrandIDCardUI.nZA.MXQ.KLB.LSj.iterator();
                    while (it.hasNext()) {
                        dbj next = it.next();
                        arrayList.add(new PhoneItem(Util.nullAsNil(next.dSf), Util.nullAsNil(next.Lli), Util.nullAsNil(next.nzu), Util.nullAsNil(next.bxK), Util.nullAsNil(next.nzv), next.MGs, next.MGt, false, false));
                    }
                }
            }
            r rVar = r.nzC;
            r rVar2 = r.nzC;
            List<PhoneItem> j2 = r.j(arrayList, r.bTy());
            appBrandIDCardUI.nZH.setPhoneItems(j2 == null ? new ArrayList<>() : (ArrayList) j2);
            r rVar3 = r.nzC;
            r.bQ(j2);
            if (appBrandIDCardUI.jCK != null) {
                appBrandIDCardUI.jCK.b(appBrandIDCardUI.nZH);
            }
            AppMethodBeat.o(48963);
        }
    }

    static /* synthetic */ void h(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(48964);
        if (!(appBrandIDCardUI.nZH == null || appBrandIDCardUI.jCK == null)) {
            appBrandIDCardUI.jCK.c(appBrandIDCardUI.nZH);
        }
        if (appBrandIDCardUI.nZA == null) {
            Log.e("MicroMsg.AppBrandIDCardUI", "wecoin lost idcard show info");
            appBrandIDCardUI.setResult(0);
            appBrandIDCardUI.finish();
            AppMethodBeat.o(48964);
        } else if (appBrandIDCardUI.nZA.MXQ == null) {
            Log.e("MicroMsg.AppBrandIDCardUI", "wecoin lost idcard info");
            appBrandIDCardUI.setResult(0);
            appBrandIDCardUI.finish();
            AppMethodBeat.o(48964);
        } else {
            appBrandIDCardUI.nZH = new com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a(appBrandIDCardUI.getContext());
            com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a aVar = appBrandIDCardUI.nZH;
            aVar.lIM.setVisibility(8);
            aVar.lIO.setVisibility(8);
            appBrandIDCardUI.nZH.getContentView().setBackgroundResource(R.drawable.b1g);
            appBrandIDCardUI.nZH.y(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(227707);
                    AppBrandIDCardUI.a(AppBrandIDCardUI.this, 16);
                    if (TextUtils.isEmpty(AppBrandIDCardUI.this.nZv)) {
                        Log.e("MicroMsg.AppBrandIDCardUI", "wecoin protocol url is null");
                        AppMethodBeat.o(227707);
                    } else {
                        AppBrandIDCardUI.a(AppBrandIDCardUI.this, AppBrandIDCardUI.this.nZv);
                        AppMethodBeat.o(227707);
                    }
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnAccept(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass4 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(227708);
                    AppBrandIDCardUI.a(AppBrandIDCardUI.this, 17);
                    AppBrandIDCardUI.this.nZJ = AppBrandIDCardUI.this.nZH.bEU();
                    if (!(AppBrandIDCardUI.this.jCK == null || AppBrandIDCardUI.this.nZH == null)) {
                        AppBrandIDCardUI.this.jCK.c(AppBrandIDCardUI.this.nZH);
                    }
                    AppBrandIDCardUI.this.nZf.bXS();
                    AppMethodBeat.o(227708);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.x(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(227709);
                    AppBrandIDCardUI.a(AppBrandIDCardUI.this, 18);
                    AppBrandIDCardUI.this.setResult(0);
                    AppBrandIDCardUI.this.finish();
                    AppMethodBeat.o(227709);
                    return null;
                }
            });
            com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a aVar2 = appBrandIDCardUI.nZH;
            AnonymousClass6 r1 = new b<Boolean, x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(227710);
                    if (bool.booleanValue()) {
                        AppBrandIDCardUI.a(AppBrandIDCardUI.this, 14);
                        AppMethodBeat.o(227710);
                    } else {
                        AppBrandIDCardUI.a(AppBrandIDCardUI.this, 15);
                        AppMethodBeat.o(227710);
                    }
                    return null;
                }
            };
            p.h(r1, "<set-?>");
            aVar2.lJr = r1;
            appBrandIDCardUI.nZH.setOnCancel(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass7 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(227711);
                    AppBrandIDCardUI.this.setResult(0);
                    AppBrandIDCardUI.this.finish();
                    AppMethodBeat.o(227711);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnAddPhoneNumber(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass8 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(227712);
                    Intent intent = new Intent(AppBrandIDCardUI.this.getContext(), PhoneNumberAddUI.class);
                    intent.putExtra("APPID", AppBrandIDCardUI.this.appId);
                    AppBrandIDCardUI.this.startActivityForResult(intent, 10000);
                    AppMethodBeat.o(227712);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setOnManagePhoneNumber(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass9 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(227713);
                    Intent intent = new Intent(AppBrandIDCardUI.this.getContext(), PhoneNumberManagerUI.class);
                    intent.putExtra("APPID", AppBrandIDCardUI.this.appId);
                    intent.putExtra("PAGEPATH", Util.nullAsNil(AppBrandIDCardUI.this.nZF));
                    AppBrandIDCardUI.this.startActivityForResult(intent, 10001);
                    AppMethodBeat.o(227713);
                    return null;
                }
            });
            appBrandIDCardUI.nZH.setIconUrl(appBrandIDCardUI.nZA.Mzt);
            appBrandIDCardUI.nZH.setAppBrandName(appBrandIDCardUI.nZw);
            appBrandIDCardUI.nZH.Zs(appBrandIDCardUI.nZA.MXQ.KLC);
            appBrandIDCardUI.nZH.Zt(appBrandIDCardUI.nZA.MXQ.KLD);
            appBrandIDCardUI.nZH.Zu(appBrandIDCardUI.nZA.MXQ.KLE);
            boolean z = appBrandIDCardUI.nZA.MXO;
            appBrandIDCardUI.zs(z ? 12 : 13);
            appBrandIDCardUI.nZH.g(Boolean.valueOf(z));
            appBrandIDCardUI.nZH.Zv(appBrandIDCardUI.nZA.MXK);
            appBrandIDCardUI.nZH.Zw(appBrandIDCardUI.nZA.MXP);
            if (appBrandIDCardUI.nZA.MXQ.KLG != null) {
                appBrandIDCardUI.nZH.Zx(appBrandIDCardUI.nZA.MXQ.KLG.dQx);
            }
            if (appBrandIDCardUI.nZA.MXQ.KLA != null) {
                appBrandIDCardUI.nZH.Zy(appBrandIDCardUI.nZA.MXQ.KLA.KLy + " " + appBrandIDCardUI.nZA.MXQ.KLA.KLz);
            } else {
                Log.i("MicroMsg.AppBrandIDCardUI", "wecoin no id card info");
            }
            ArrayList arrayList = new ArrayList();
            if (appBrandIDCardUI.nZA.MXQ.KLB != null) {
                if (appBrandIDCardUI.nZA.MXQ.KLB.LSi != null) {
                    dbj dbj = appBrandIDCardUI.nZA.MXQ.KLB.LSi;
                    arrayList.add(new PhoneItem(Util.nullAsNil(dbj.dSf), Util.nullAsNil(dbj.Lli), Util.nullAsNil(dbj.nzu), Util.nullAsNil(dbj.bxK), Util.nullAsNil(dbj.nzv), dbj.MGs, dbj.MGt, true, false));
                }
                if (appBrandIDCardUI.nZA.MXQ.KLB.LSj != null) {
                    Iterator<dbj> it = appBrandIDCardUI.nZA.MXQ.KLB.LSj.iterator();
                    while (it.hasNext()) {
                        dbj next = it.next();
                        arrayList.add(new PhoneItem(Util.nullAsNil(next.dSf), Util.nullAsNil(next.Lli), Util.nullAsNil(next.nzu), Util.nullAsNil(next.bxK), Util.nullAsNil(next.nzv), next.MGs, next.MGt, false, false));
                    }
                }
            }
            r rVar = r.nzC;
            r rVar2 = r.nzC;
            List<PhoneItem> j2 = r.j(arrayList, r.bTy());
            appBrandIDCardUI.nZH.setPhoneItems(j2 == null ? new ArrayList<>() : (ArrayList) j2);
            r rVar3 = r.nzC;
            r.bQ(j2);
            if (appBrandIDCardUI.jCK != null) {
                appBrandIDCardUI.jCK.b(appBrandIDCardUI.nZH);
            }
            AppMethodBeat.o(48964);
        }
    }

    static /* synthetic */ void a(AppBrandIDCardUI appBrandIDCardUI, String str) {
        AppMethodBeat.i(227717);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandIDCardUI", "url is null");
            AppMethodBeat.o(227717);
            return;
        }
        Log.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("forceHideShare", true);
        c.b(appBrandIDCardUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(227717);
    }

    static /* synthetic */ void l(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(227718);
        Log.i("MicroMsg.AppBrandIDCardUI", "switchToVerifyFragment");
        appBrandIDCardUI.nZu = new AppBrandIDCardVerifyPwdFrag();
        ((AppBrandIDCardVerifyPwdFrag) appBrandIDCardUI.nZu).nZf = appBrandIDCardUI.nZf;
        appBrandIDCardUI.getSupportFragmentManager().beginTransaction().b(nZt, appBrandIDCardUI.nZu).commitAllowingStateLoss();
        AppMethodBeat.o(227718);
    }

    static /* synthetic */ void a(AppBrandIDCardUI appBrandIDCardUI, String str, String str2, int i2) {
        AppMethodBeat.i(227719);
        if (appBrandIDCardUI.jCK != null) {
            appBrandIDCardUI.jCK.b(new com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b(appBrandIDCardUI.jCK, str, str2, appBrandIDCardUI.getContext(), i2, Math.round(((float) appBrandIDCardUI.jCK.getMeasuredHeight()) * 0.7f), new b<String, x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.AnonymousClass10 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(String str) {
                    AppMethodBeat.i(227714);
                    AppBrandIDCardUI.a(AppBrandIDCardUI.this, str);
                    AppMethodBeat.o(227714);
                    return null;
                }
            }));
        }
        AppMethodBeat.o(227719);
    }
}
