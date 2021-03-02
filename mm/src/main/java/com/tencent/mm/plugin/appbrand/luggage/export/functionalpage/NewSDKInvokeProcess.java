package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.appbrand.ah.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.a.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "newSdkInvokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", i.NAME, "", "transitiveData", "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "NewSdkInvokeBackData", "plugin-appbrand-integration_release"})
final class NewSDKInvokeProcess implements o {
    @Deprecated
    public static final a naN = new a((byte) 0);
    private WechatNativeExtraDataInvokeFunctionalPage naL;
    private final int naM = (hashCode() & 65535);
    final l nas;

    static {
        AppMethodBeat.i(228875);
        AppMethodBeat.o(228875);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    public static final class c<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<NewSdkInvokeBackData, IPCVoid> {
        public static final c naR = new c();

        static {
            AppMethodBeat.i(228862);
            AppMethodBeat.o(228862);
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(NewSdkInvokeBackData newSdkInvokeBackData, final com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(228861);
            final NewSdkInvokeBackData newSdkInvokeBackData2 = newSdkInvokeBackData;
            final AnonymousClass1 r1 = new kotlin.g.a.b<String, x>() {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.c.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* bridge */ /* synthetic */ x invoke(String str) {
                    AppMethodBeat.i(228856);
                    invoke(str);
                    x xVar = x.SXb;
                    AppMethodBeat.o(228856);
                    return xVar;
                }

                public static /* synthetic */ void a(AnonymousClass1 r2) {
                    AppMethodBeat.i(228858);
                    r2.invoke((String) null);
                    AppMethodBeat.o(228858);
                }

                private void invoke(String str) {
                    AppMethodBeat.i(228857);
                    a.C0537a aVar = a.C0537a.oFy;
                    String str2 = newSdkInvokeBackData2.naO.invokeTicket;
                    if (str2 == null) {
                        p.hyc();
                    }
                    a.C0537a.agm(str2);
                    Bundle bundle = new Bundle();
                    WXLaunchWxaRedirectingPage.Resp resp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
                    String str3 = newSdkInvokeBackData2.naO.invokeTicket;
                    if (str3 == null) {
                        p.hyc();
                    }
                    resp.invokeTicket = str3;
                    resp.callbackActivity = newSdkInvokeBackData2.naO.callbackActivity;
                    resp.errStr = str;
                    resp.toBundle(bundle);
                    q.bo(bundle);
                    q.bp(bundle);
                    Context context = MMApplicationContext.getContext();
                    MMessageActV2.Args args = new MMessageActV2.Args();
                    args.targetPkgName = newSdkInvokeBackData2.naO.packageName;
                    args.bundle = bundle;
                    MMessageActV2.send(context, args);
                    com.tencent.mm.ipcinvoker.d dVar = dVar;
                    if (dVar != null) {
                        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                        AppMethodBeat.o(228857);
                        return;
                    }
                    AppMethodBeat.o(228857);
                }
            };
            a.C0746a aVar = a.nap;
            String str = newSdkInvokeBackData2.naO.invokeTicket;
            if (str == null) {
                p.hyc();
            }
            a.C0746a.el(str, newSdkInvokeBackData2.naP).aYI().a(new d.b<c.a<fek>>() {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.c.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(c.a<fek> aVar) {
                    AppMethodBeat.i(228859);
                    AnonymousClass1.a(r1);
                    AppMethodBeat.o(228859);
                }
            }).a(new d.a<Object>() {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.c.AnonymousClass3 */

                @Override // com.tencent.mm.vending.g.d.a
                public final void cn(Object obj) {
                    AppMethodBeat.i(228860);
                    AnonymousClass1.a(r1);
                    AppMethodBeat.o(228860);
                }
            });
            AppMethodBeat.o(228861);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class e<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<NewSdkInvokeBackData, IPCVoid> {
        public static final e naU = new e();

        static {
            AppMethodBeat.i(228865);
            AppMethodBeat.o(228865);
        }

        e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(NewSdkInvokeBackData newSdkInvokeBackData, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(228864);
            NewSdkInvokeBackData newSdkInvokeBackData2 = newSdkInvokeBackData;
            a.C0746a aVar = a.nap;
            String str = newSdkInvokeBackData2.naO.invokeTicket;
            if (str == null) {
                p.hyc();
            }
            a.C0746a.el(str, newSdkInvokeBackData2.naP).aYI();
            if (dVar != null) {
                com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                AppMethodBeat.o(228864);
                return;
            }
            AppMethodBeat.o(228864);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public NewSDKInvokeProcess(l lVar) {
        p.h(lVar, "runtime");
        AppMethodBeat.i(228874);
        this.nas = lVar;
        AppMethodBeat.o(228874);
    }

    public static final /* synthetic */ void a(NewSDKInvokeProcess newSDKInvokeProcess, String str) {
        AppMethodBeat.i(228876);
        newSDKInvokeProcess.acw(str);
        AppMethodBeat.o(228876);
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void acv(String str) {
        p pVar;
        AppMethodBeat.i(228870);
        p.h(str, "invokeData");
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "performInvoke with instance(" + hashCode() + ") callbackId(" + this.naM + ") appId(" + this.nas.getAppId() + ") data(" + str + ')');
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage = new WechatNativeExtraDataInvokeFunctionalPage();
        wechatNativeExtraDataInvokeFunctionalPage.am(new JSONObject(str));
        this.naL = wechatNativeExtraDataInvokeFunctionalPage;
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage2 = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage2 == null) {
            p.btv("newSdkInvokeArgs");
        }
        String str2 = wechatNativeExtraDataInvokeFunctionalPage2.nbb;
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage3 = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage3 == null) {
            p.btv("newSdkInvokeArgs");
        }
        String str3 = wechatNativeExtraDataInvokeFunctionalPage3.nbc;
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage4 = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage4 == null) {
            p.btv("newSdkInvokeArgs");
        }
        String str4 = wechatNativeExtraDataInvokeFunctionalPage4.les;
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage5 = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage5 == null) {
            p.btv("newSdkInvokeArgs");
        }
        String str5 = wechatNativeExtraDataInvokeFunctionalPage5.nbg;
        if (str5 != null) {
            k bOH = this.nas.bOH();
            if (bOH == null) {
                p.hyc();
            }
            p.g(bOH, "runtime.currentPageView!!");
            bOH.YO(str5);
        }
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage6 = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage6 == null) {
            p.btv("newSdkInvokeArgs");
        }
        String str6 = wechatNativeExtraDataInvokeFunctionalPage6.nbh;
        if (str6 != null) {
            k bOH2 = this.nas.bOH();
            if (bOH2 == null) {
                p.hyc();
            }
            p.g(bOH2, "runtime.currentPageView!!");
            bOH2.acu(str6);
        }
        String str7 = str2;
        if (!(str7 == null || str7.length() == 0)) {
            String str8 = str3;
            if (!(str8 == null || str8.length() == 0)) {
                WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage7 = this.naL;
                if (wechatNativeExtraDataInvokeFunctionalPage7 == null) {
                    p.btv("newSdkInvokeArgs");
                }
                if (!wechatNativeExtraDataInvokeFunctionalPage7.cuy) {
                    WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage8 = this.naL;
                    if (wechatNativeExtraDataInvokeFunctionalPage8 == null) {
                        p.btv("newSdkInvokeArgs");
                    }
                    String str9 = wechatNativeExtraDataInvokeFunctionalPage8.nbd;
                    if (str9 != null) {
                        switch (str9.hashCode()) {
                            case 1224424441:
                                if (str9.equals("webview")) {
                                    com.tencent.mm.plugin.appbrand.page.x bsD = this.nas.bsD();
                                    p.g(bsD, "runtime.pageContainer");
                                    ac pageView = bsD.getPageView();
                                    if (pageView != null) {
                                        pVar = (k) pageView;
                                        break;
                                    } else {
                                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
                                        AppMethodBeat.o(228870);
                                        throw tVar;
                                    }
                                }
                                break;
                            case 1452004724:
                                if (str9.equals("appservice")) {
                                    com.tencent.mm.plugin.appbrand.service.c bsE = this.nas.bsE();
                                    if (bsE != null) {
                                        pVar = (e) bsE;
                                        break;
                                    } else {
                                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
                                        AppMethodBeat.o(228870);
                                        throw tVar2;
                                    }
                                }
                                break;
                        }
                    }
                    acw(d.en("fail invalid jsapiType", str2));
                    RuntimeException runtimeException = new RuntimeException();
                    AppMethodBeat.o(228870);
                    throw runtimeException;
                } else if (this.nas.bsE().Ze(str2) != null) {
                    com.tencent.mm.plugin.appbrand.service.c bsE2 = this.nas.bsE();
                    if (bsE2 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
                        AppMethodBeat.o(228870);
                        throw tVar3;
                    }
                    pVar = (e) bsE2;
                } else {
                    k bOH3 = this.nas.bOH();
                    if (bOH3 == null) {
                        p.hyc();
                    }
                    if (bOH3.Ze(str2) != null) {
                        p bOH4 = this.nas.bOH();
                        if (bOH4 == null) {
                            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
                            AppMethodBeat.o(228870);
                            throw tVar4;
                        }
                        pVar = bOH4;
                    } else {
                        com.tencent.mm.plugin.appbrand.service.c bsE3 = this.nas.bsE();
                        if (bsE3 == null) {
                            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
                            AppMethodBeat.o(228870);
                            throw tVar5;
                        }
                        pVar = (e) bsE3;
                    }
                }
                g gVar = new g(this, pVar, str2, str3);
                WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage9 = this.naL;
                if (wechatNativeExtraDataInvokeFunctionalPage9 == null) {
                    p.btv("newSdkInvokeArgs");
                }
                if (3 != wechatNativeExtraDataInvokeFunctionalPage9.nbe) {
                    gVar.invoke();
                    AppMethodBeat.o(228870);
                    return;
                } else if (pVar == null) {
                    t tVar6 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandComponentWxaShared");
                    AppMethodBeat.o(228870);
                    throw tVar6;
                } else {
                    com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((com.tencent.mm.plugin.appbrand.d) pVar, str2, null, this.naM), new f(this, gVar, str4, str2));
                    AppMethodBeat.o(228870);
                    return;
                }
            }
        }
        acw("fail invalid args");
        AppMethodBeat.o(228870);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$performInvoke$4", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/AppBrandJsApiUserAuth$OnUserAuthResultListener;", "onCancel", "", "onConfirm", "onDeny", "reason", "", "plugin-appbrand-integration_release"})
    public static final class f implements a.c {
        final /* synthetic */ NewSDKInvokeProcess naQ;
        final /* synthetic */ kotlin.g.a.a naV;
        final /* synthetic */ String naW;
        final /* synthetic */ String naX;

        f(NewSDKInvokeProcess newSDKInvokeProcess, kotlin.g.a.a aVar, String str, String str2) {
            this.naQ = newSDKInvokeProcess;
            this.naV = aVar;
            this.naW = str;
            this.naX = str2;
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
        public final void bOI() {
            AppMethodBeat.i(228866);
            this.naV.invoke();
            AppMethodBeat.o(228866);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
        public final void acx(String str) {
            AppMethodBeat.i(228867);
            NewSDKInvokeProcess newSDKInvokeProcess = this.naQ;
            StringBuilder sb = new StringBuilder("fail ");
            if (str == null) {
                str = "";
            }
            NewSDKInvokeProcess.a(newSDKInvokeProcess, d.en(sb.append(str).toString(), this.naX));
            AppMethodBeat.o(228867);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
        public final void onCancel() {
            AppMethodBeat.i(228868);
            NewSDKInvokeProcess.a(this.naQ, d.en("fail:auth canceled", this.naX));
            AppMethodBeat.o(228868);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void a(p pVar, int i2, String str) {
        AppMethodBeat.i(228871);
        p.h(pVar, "component");
        p.h(str, "data");
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onCallback, instance(" + hashCode() + ", callbackId(" + i2 + "), data(" + str + ')');
        if (this.naM == i2) {
            if (this.naL == null) {
                p.btv("newSdkInvokeArgs");
            }
            acw(str);
        }
        AppMethodBeat.o(228871);
    }

    private final void acw(String str) {
        AppMethodBeat.i(228872);
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "navigateBack, instance(" + hashCode() + ", invokeResult(" + str + ')');
        h.RTc.aV(new b(this));
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage == null) {
            p.btv("newSdkInvokeArgs");
        }
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(wechatNativeExtraDataInvokeFunctionalPage, str), c.naR, new d(this));
        AppMethodBeat.o(228872);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ NewSDKInvokeProcess naQ;

        b(NewSDKInvokeProcess newSDKInvokeProcess) {
            this.naQ = newSDKInvokeProcess;
        }

        public final void run() {
            AppMethodBeat.i(228855);
            Activity context = this.naQ.nas.getContext();
            if (context != null) {
                MMApplicationContext.getContext().getString(R.string.zb);
                com.tencent.mm.ui.base.h.a((Context) context, MMApplicationContext.getContext().getString(R.string.j5o), false, (DialogInterface.OnCancelListener) null);
                AppMethodBeat.o(228855);
                return;
            }
            AppMethodBeat.o(228855);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void b(p pVar, int i2, String str) {
        AppMethodBeat.i(228873);
        p.h(pVar, "component");
        p.h(str, "callbackStr");
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.NewSDKInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + i2 + "), callbackStr(" + str + ')');
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage = this.naL;
        if (wechatNativeExtraDataInvokeFunctionalPage == null) {
            p.btv("newSdkInvokeArgs");
        }
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new NewSdkInvokeBackData(wechatNativeExtraDataInvokeFunctionalPage, str), e.naU, null);
        AppMethodBeat.o(228873);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/NewSDKInvokeProcess$NewSdkInvokeBackData;", "Landroid/os/Parcelable;", "invokeReq", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "backData", "", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;Ljava/lang/String;)V", "getBackData", "()Ljava/lang/String;", "getInvokeReq", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "component1", "component2", "copy", "describeContents", "", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class NewSdkInvokeBackData implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        final WechatNativeExtraDataInvokeFunctionalPage naO;
        final String naP;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228848);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                NewSdkInvokeBackData newSdkInvokeBackData = new NewSdkInvokeBackData((WechatNativeExtraDataInvokeFunctionalPage) WechatNativeExtraDataInvokeFunctionalPage.CREATOR.createFromParcel(parcel), parcel.readString());
                AppMethodBeat.o(228848);
                return newSdkInvokeBackData;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new NewSdkInvokeBackData[i2];
            }
        }

        static {
            AppMethodBeat.i(228854);
            AppMethodBeat.o(228854);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.naP, r4.naP) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 228852(0x37df4, float:3.2069E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.NewSdkInvokeBackData
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess$NewSdkInvokeBackData r4 = (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.NewSdkInvokeBackData) r4
                com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage r0 = r3.naO
                com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage r1 = r4.naO
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.naP
                java.lang.String r1 = r4.naP
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.NewSdkInvokeBackData.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(228851);
            WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage = this.naO;
            int hashCode = (wechatNativeExtraDataInvokeFunctionalPage != null ? wechatNativeExtraDataInvokeFunctionalPage.hashCode() : 0) * 31;
            String str = this.naP;
            if (str != null) {
                i2 = str.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(228851);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(228850);
            String str = "NewSdkInvokeBackData(invokeReq=" + this.naO + ", backData=" + this.naP + ")";
            AppMethodBeat.o(228850);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228853);
            p.h(parcel, "parcel");
            this.naO.writeToParcel(parcel, 0);
            parcel.writeString(this.naP);
            AppMethodBeat.o(228853);
        }

        public NewSdkInvokeBackData(WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, String str) {
            p.h(wechatNativeExtraDataInvokeFunctionalPage, "invokeReq");
            AppMethodBeat.i(228849);
            this.naO = wechatNativeExtraDataInvokeFunctionalPage;
            this.naP = str;
            AppMethodBeat.o(228849);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ NewSDKInvokeProcess naQ;
        final /* synthetic */ String naX;
        final /* synthetic */ p naY;
        final /* synthetic */ String naZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(NewSDKInvokeProcess newSDKInvokeProcess, p pVar, String str, String str2) {
            super(0);
            this.naQ = newSDKInvokeProcess;
            this.naY = pVar;
            this.naX = str;
            this.naZ = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(228869);
            p pVar = this.naY;
            if (pVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
                AppMethodBeat.o(228869);
                throw tVar;
            }
            String y = ((com.tencent.mm.plugin.appbrand.jsapi.g) pVar).y(this.naX, this.naZ, this.naQ.naM);
            AppMethodBeat.o(228869);
            return y;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class d<T> implements com.tencent.mm.ipcinvoker.d<IPCVoid> {
        final /* synthetic */ NewSDKInvokeProcess naQ;

        d(NewSDKInvokeProcess newSDKInvokeProcess) {
            this.naQ = newSDKInvokeProcess;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(IPCVoid iPCVoid) {
            AppMethodBeat.i(228863);
            this.naQ.nas.bOG();
            AppMethodBeat.o(228863);
        }
    }
}
