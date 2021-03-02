package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.x;
import org.json.JSONObject;

public enum AppBrandJsApiPayService implements a {
    INSTANCE;

    public static AppBrandJsApiPayService valueOf(String str) {
        AppMethodBeat.i(46703);
        AppBrandJsApiPayService appBrandJsApiPayService = (AppBrandJsApiPayService) Enum.valueOf(AppBrandJsApiPayService.class, str);
        AppMethodBeat.o(46703);
        return appBrandJsApiPayService;
    }

    static {
        AppMethodBeat.i(46710);
        j.UJ("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
        AppMethodBeat.o(46710);
    }

    /* access modifiers changed from: package-private */
    public enum PayResultCallbackReason {
        SuccessAheadCallback,
        ActivityResult;

        public static PayResultCallbackReason valueOf(String str) {
            AppMethodBeat.i(226958);
            PayResultCallbackReason payResultCallbackReason = (PayResultCallbackReason) Enum.valueOf(PayResultCallbackReason.class, str);
            AppMethodBeat.o(226958);
            return payResultCallbackReason;
        }

        static {
            AppMethodBeat.i(226959);
            AppMethodBeat.o(226959);
        }
    }

    public final boolean startPay(Activity activity, final k kVar, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final a.b bVar, PString pString) {
        final c cVar;
        AppMethodBeat.i(174858);
        final WalletJsapiData walletJsapiData = new WalletJsapiData(jSONObject);
        if (appBrandStatObject != null) {
            walletJsapiData.payChannel = WalletJsapiData.kH(appBrandStatObject.scene, appBrandStatObject.ecS);
            walletJsapiData.KxG = WalletJsapiData.kG(appBrandStatObject.scene, appBrandStatObject.ecS);
        }
        walletJsapiData.dVv = 46;
        String optString = jSONObject.optString("adUxInfo");
        walletJsapiData.KxO = optString;
        com.tencent.mm.plugin.s.a.x("AppBrandRuntime", n.NAME, optString, "data");
        pString.value = walletJsapiData.packageExt;
        if (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.u(kVar)) {
            cVar = (c) e.M(c.class);
        } else {
            cVar = null;
        }
        final int hashCode = 65535 & hashCode();
        final AnonymousClass1WxPayResultDispatcher r6 = new Object() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1WxPayResultDispatcher */
            AnonymousClass1WxPayActivityResultAdapter mlT;

            /* access modifiers changed from: package-private */
            public final void a(int i2, Intent intent, PayResultCallbackReason payResultCallbackReason) {
                AppMethodBeat.i(226955);
                AnonymousClass1WxPayActivityResultAdapter r0 = new Object(i2, intent, payResultCallbackReason) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1WxPayActivityResultAdapter */
                    private final Intent dQs;
                    private final PayResultCallbackReason mlQ;
                    private final int resultCode;

                    {
                        this.resultCode = r2;
                        this.dQs = r3;
                        this.mlQ = r4;
                    }

                    public final boolean a(AnonymousClass1WxPayActivityResultAdapter r4) {
                        if (r4.mlQ != PayResultCallbackReason.SuccessAheadCallback && this.mlQ == PayResultCallbackReason.SuccessAheadCallback) {
                            return false;
                        }
                        return true;
                    }

                    public final AnonymousClass1WxPayCallbackResult bIk() {
                        int i2;
                        AppMethodBeat.i(226954);
                        if (this.dQs != null) {
                            i2 = this.dQs.getIntExtra("key_is_clear_failure", -1);
                        } else {
                            i2 = -1;
                        }
                        HashMap hashMap = new HashMap();
                        if (i2 == 0) {
                            hashMap.put("payStatus", "pending");
                        } else if (i2 == 1) {
                            hashMap.put("pay_status", "fail");
                        }
                        if (this.resultCode == -1) {
                            AnonymousClass1WxPayCallbackResult r0 = new Object(1, 0, null, hashMap) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1WxPayCallbackResult */
                                final int mlR;
                                final String mlS;
                                final int result;
                                final Map<String, Object> values;

                                {
                                    this.result = r2;
                                    this.mlR = r3;
                                    this.mlS = r4;
                                    this.values = r5;
                                }
                            };
                            AppMethodBeat.o(226954);
                            return r0;
                        } else if (this.resultCode == 5) {
                            int intExtra = this.dQs.getIntExtra("key_jsapi_pay_err_code", 0);
                            String nullAsNil = Util.nullAsNil(this.dQs.getStringExtra("key_jsapi_pay_err_msg"));
                            Log.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), nullAsNil);
                            AnonymousClass1WxPayCallbackResult r02 = new Object(2, intExtra, nullAsNil, hashMap) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1WxPayCallbackResult */
                                final int mlR;
                                final String mlS;
                                final int result;
                                final Map<String, Object> values;

                                {
                                    this.result = r2;
                                    this.mlR = r3;
                                    this.mlS = r4;
                                    this.values = r5;
                                }
                            };
                            AppMethodBeat.o(226954);
                            return r02;
                        } else {
                            AnonymousClass1WxPayCallbackResult r03 = new Object(3, 0, null, hashMap) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1WxPayCallbackResult */
                                final int mlR;
                                final String mlS;
                                final int result;
                                final Map<String, Object> values;

                                {
                                    this.result = r2;
                                    this.mlR = r3;
                                    this.mlS = r4;
                                    this.values = r5;
                                }
                            };
                            AppMethodBeat.o(226954);
                            return r03;
                        }
                    }
                };
                if (this.mlT == null || this.mlT.a(r0)) {
                    this.mlT = r0;
                    if (this.mlT.mlQ == PayResultCallbackReason.SuccessAheadCallback && (bVar instanceof a.c)) {
                        AnonymousClass1WxPayCallbackResult bIk = this.mlT.bIk();
                        ((a.c) bVar).b(bIk.result, bIk.mlS, bIk.values);
                    }
                }
                AppMethodBeat.o(226955);
            }
        };
        walletJsapiData.KxQ = new ResultReceiver(r6) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1PaySuccessAheadCallbackResultReceiver */
            private final AnonymousClass1WxPayResultDispatcher mlP;

            {
                AppMethodBeat.i(226953);
                this.mlP = r5;
                AppMethodBeat.o(226953);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                AppMethodBeat.i(180264);
                bundle.setClassLoader(WalletJsapiData.class.getClassLoader());
                this.mlP.a(i2, new Intent().putExtras(bundle), PayResultCallbackReason.SuccessAheadCallback);
                AppMethodBeat.o(180264);
            }
        };
        if (cVar != null) {
            cVar.bHL();
        }
        boolean a2 = AppBrandJsApiPayUtils.a(activity, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(226952);
                f.a(mMActivity, walletJsapiData, hashCode, new MMActivity.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.MMActivity.a
                    public final void d(int i2, int i3, Intent intent) {
                        int i4 = 0;
                        AppMethodBeat.i(226951);
                        if (hashCode != i2) {
                            Object[] objArr = new Object[2];
                            objArr[0] = kVar.getAppId();
                            if (bVar != null) {
                                i4 = bVar.hashCode();
                            }
                            objArr[1] = Integer.valueOf(i4);
                            Log.w("MicroMsg.AppBrandJsApiPayService", "startPay mismatch requestCode, appId:%s, listener.hash[%d]", objArr);
                            AppMethodBeat.o(226951);
                            return;
                        }
                        r6.a(i3, intent, PayResultCallbackReason.ActivityResult);
                        AppMethodBeat.o(226951);
                    }
                });
                x xVar = x.SXb;
                AppMethodBeat.o(226952);
                return xVar;
            }
        }, new f.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass2 */

            @Override // com.tencent.luggage.h.f.b
            public final void a(int i2, Intent intent) {
                AppMethodBeat.i(226956);
                r6.a(i2, intent, PayResultCallbackReason.ActivityResult);
                AnonymousClass1WxPayResultDispatcher r1 = r6;
                if (cVar != null) {
                    cVar.bHK();
                }
                AnonymousClass1WxPayCallbackResult bIk = ((AnonymousClass1WxPayActivityResultAdapter) Objects.requireNonNull(r1.mlT)).bIk();
                if (bVar != null) {
                    bVar.a(bIk.result, bIk.mlS, bIk.values);
                }
                AppMethodBeat.o(226956);
            }
        });
        AppMethodBeat.o(174858);
        return a2;
    }

    public final boolean startPayToBank(Activity activity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final a.b bVar) {
        AppMethodBeat.i(174859);
        final WalletJsapiData walletJsapiData = new WalletJsapiData(jSONObject);
        if (appBrandStatObject != null) {
            walletJsapiData.payChannel = WalletJsapiData.kH(appBrandStatObject.scene, appBrandStatObject.ecS);
            walletJsapiData.KxG = WalletJsapiData.kG(appBrandStatObject.scene, appBrandStatObject.ecS);
        }
        walletJsapiData.dVv = 46;
        final AnonymousClass3 r1 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass3 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(46698);
                if (i2 != (AppBrandJsApiPayService.this.hashCode() & 65535)) {
                    AppMethodBeat.o(46698);
                } else if (i3 == -1) {
                    HashMap hashMap = new HashMap();
                    String nullAs = Util.nullAs(intent.getStringExtra("token"), "");
                    String nullAs2 = Util.nullAs(intent.getStringExtra("bind_serial"), "");
                    hashMap.put("token", nullAs);
                    hashMap.put("bindSerial", nullAs2);
                    if (bVar != null) {
                        bVar.a(1, null, hashMap);
                    }
                    AppMethodBeat.o(46698);
                } else {
                    if (bVar != null) {
                        bVar.a(2, null, null);
                    }
                    AppMethodBeat.o(46698);
                }
            }
        };
        boolean a2 = AppBrandJsApiPayUtils.a(activity, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(174853);
                MMActivity mMActivity2 = mMActivity;
                Intent intent = new Intent();
                intent.putExtra("appId", walletJsapiData.appId);
                intent.putExtra("timeStamp", walletJsapiData.timeStamp);
                intent.putExtra("nonceStr", walletJsapiData.nonceStr);
                intent.putExtra("packageExt", walletJsapiData.packageExt);
                intent.putExtra("signtype", walletJsapiData.signType);
                intent.putExtra("paySignature", walletJsapiData.dVt);
                intent.putExtra("url", walletJsapiData.url);
                intent.putExtra("pay_scene", walletJsapiData.dVw);
                mMActivity2.mmSetOnActivityResultCallback(r1);
                com.tencent.mm.br.c.a((Context) mMActivity2, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, AppBrandJsApiPayService.this.hashCode() & 65535, false);
                x xVar = x.SXb;
                AppMethodBeat.o(174853);
                return xVar;
            }
        });
        AppMethodBeat.o(174859);
        return a2;
    }

    public final void startBindBankcard(Activity activity, AppBrandStatObject appBrandStatObject, final JSONObject jSONObject, final a.b bVar) {
        AppMethodBeat.i(174860);
        final AnonymousClass5 r0 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass5 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(46700);
                if (i2 != (AppBrandJsApiPayService.this.hashCode() & 65535)) {
                    AppMethodBeat.o(46700);
                    return;
                }
                if (i3 == -1) {
                    if (bVar != null) {
                        bVar.a(1, null, null);
                        AppMethodBeat.o(46700);
                        return;
                    }
                } else if (bVar != null) {
                    bVar.a(2, null, null);
                }
                AppMethodBeat.o(46700);
            }
        };
        AppBrandJsApiPayUtils.a(activity, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(174854);
                WalletJsapiData walletJsapiData = new WalletJsapiData(jSONObject);
                walletJsapiData.dVw = 4;
                com.tencent.mm.pluginsdk.wallet.f.b(mMActivity, walletJsapiData, AppBrandJsApiPayService.this.hashCode() & 65535, r0);
                x xVar = x.SXb;
                AppMethodBeat.o(174854);
                return xVar;
            }
        });
        AppMethodBeat.o(174860);
    }

    public final void sendBizRedPacket(Activity activity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final a.b bVar) {
        AppMethodBeat.i(174861);
        WalletJsapiData walletJsapiData = new WalletJsapiData(jSONObject);
        walletJsapiData.payChannel = 16;
        final AnonymousClass7 r1 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass7 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174855);
                if (i2 != (AppBrandJsApiPayService.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174855);
                } else if (i3 == -1) {
                    if (bVar != null) {
                        bVar.a(1, null, null);
                    }
                    AppMethodBeat.o(174855);
                } else if (i3 == 2) {
                    if (bVar != null) {
                        bVar.a(2, intent != null ? intent.getStringExtra("key_result_errmsg") : "", null);
                    }
                    AppMethodBeat.o(174855);
                } else {
                    if (bVar != null) {
                        bVar.a(3, null, null);
                    }
                    AppMethodBeat.o(174855);
                }
            }
        };
        final Intent intent = new Intent();
        intent.putExtra("key_way", 3);
        intent.putExtra("appId", walletJsapiData.appId);
        intent.putExtra("timeStamp", walletJsapiData.timeStamp);
        intent.putExtra("nonceStr", walletJsapiData.nonceStr);
        intent.putExtra("packageExt", walletJsapiData.packageExt);
        intent.putExtra("signtype", walletJsapiData.signType);
        intent.putExtra("paySignature", walletJsapiData.dVt);
        intent.putExtra("key_static_from_scene", 100004);
        intent.putExtra("url", walletJsapiData.url);
        AppBrandJsApiPayUtils.a(activity, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(174856);
                MMActivity mMActivity2 = mMActivity;
                mMActivity2.mmSetOnActivityResultCallback(r1);
                com.tencent.mm.br.c.a((Context) mMActivity2, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, AppBrandJsApiPayService.this.hashCode() & 65535, false);
                x xVar = x.SXb;
                AppMethodBeat.o(174856);
                return xVar;
            }
        });
        AppMethodBeat.o(174861);
    }

    public final void verifyPassword(Activity activity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final a.d dVar) {
        AppMethodBeat.i(174862);
        final AnonymousClass9 r0 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass9 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174857);
                if (i2 != (AppBrandJsApiPayService.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174857);
                } else if (i3 == -1) {
                    String str = "";
                    if (intent != null) {
                        str = Util.nullAs(intent.getStringExtra("token"), "");
                    }
                    if (!TextUtils.isEmpty(str)) {
                        Log.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        if (dVar != null) {
                            dVar.p(true, str);
                            AppMethodBeat.o(174857);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
                        if (dVar != null) {
                            dVar.p(false, null);
                        }
                    }
                    AppMethodBeat.o(174857);
                } else {
                    if (dVar != null) {
                        dVar.p(false, null);
                    }
                    AppMethodBeat.o(174857);
                }
            }
        };
        WalletJsapiData walletJsapiData = new WalletJsapiData(jSONObject);
        final Intent intent = new Intent();
        intent.putExtra("appId", walletJsapiData.appId);
        intent.putExtra("timeStamp", walletJsapiData.timeStamp);
        intent.putExtra("nonceStr", walletJsapiData.nonceStr);
        intent.putExtra("packageExt", walletJsapiData.packageExt);
        intent.putExtra("signtype", walletJsapiData.signType);
        intent.putExtra("paySignature", walletJsapiData.dVt);
        intent.putExtra("url", walletJsapiData.url);
        intent.putExtra("scene", 1);
        AppBrandJsApiPayUtils.a(activity, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass10 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(174849);
                MMActivity mMActivity2 = mMActivity;
                mMActivity2.mmSetOnActivityResultCallback(r0);
                com.tencent.mm.br.c.a((Context) mMActivity2, "wallet_core", ".ui.WalletCheckPwdUI", intent, AppBrandJsApiPayService.this.hashCode() & 65535, false);
                x xVar = x.SXb;
                AppMethodBeat.o(174849);
                return xVar;
            }
        });
        AppMethodBeat.o(174862);
    }

    public final void startPayComponent(Activity activity, final AppBrandStatObject appBrandStatObject, final String str, final Map<String, String> map, final a.AbstractC0695a aVar) {
        AppMethodBeat.i(174863);
        AppBrandJsApiPayUtils.a(activity, new b<MMActivity, x>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass11 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public /* synthetic */ x invoke(MMActivity mMActivity) {
                AppMethodBeat.i(174850);
                AppBrandJsApiPayService.a(AppBrandJsApiPayService.this, mMActivity, str, map, aVar);
                x xVar = x.SXb;
                AppMethodBeat.o(174850);
                return xVar;
            }
        });
        AppMethodBeat.o(174863);
    }

    static /* synthetic */ void a(AppBrandJsApiPayService appBrandJsApiPayService, MMActivity mMActivity, String str, Map map, final a.AbstractC0695a aVar) {
        AppMethodBeat.i(226960);
        com.tencent.mm.pluginsdk.wallet.f.a(mMActivity, str, map, appBrandJsApiPayService.hashCode() & 65535, new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService.AnonymousClass12 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                Bundle extras;
                Set<String> keySet;
                AppMethodBeat.i(174851);
                if (i2 != (AppBrandJsApiPayService.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174851);
                    return;
                }
                if (aVar != null) {
                    HashMap hashMap = new HashMap();
                    if (!(intent == null || (extras = intent.getExtras()) == null || (keySet = extras.keySet()) == null)) {
                        for (String str : keySet) {
                            hashMap.put(str, extras.get(str));
                        }
                    }
                    if (i3 == -1) {
                        aVar.p("ok", hashMap);
                        AppMethodBeat.o(174851);
                        return;
                    } else if (i3 == 5) {
                        aVar.p("fail", hashMap);
                        AppMethodBeat.o(174851);
                        return;
                    } else if (i3 == 0) {
                        aVar.p("cancel", hashMap);
                    }
                }
                AppMethodBeat.o(174851);
            }
        });
        AppMethodBeat.o(226960);
    }
}
