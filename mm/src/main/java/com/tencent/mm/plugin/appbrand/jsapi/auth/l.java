package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.auth.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.r;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J%\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0002¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "component", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class l extends i implements f {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";
    @Deprecated
    public static final e lGK = new e((byte) 0);

    static {
        AppMethodBeat.i(169600);
        AppMethodBeat.o(169600);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSLoginResponse;", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ l lGL;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        a(l lVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lGL = lVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            cdz cdz;
            String str;
            cdz cdz2;
            AppMethodBeat.i(169593);
            final cet cet = (cet) obj;
            Integer valueOf = (cet == null || (cdz2 = cet.Mkb) == null) ? null : Integer.valueOf(cdz2.dIZ);
            if (valueOf != null && valueOf.intValue() == -12000) {
                final com.tencent.mm.vending.g.b hdH = g.hdH();
                LinkedList<drb> linkedList = cet.LRN;
                if (linkedList == null || linkedList.isEmpty()) {
                    this.lGr.i(this.lyo, this.lGL.Zf("fail:internal error scope empty"));
                } else {
                    h.RTc.aV(new Runnable(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.l.a.AnonymousClass1 */
                        final /* synthetic */ a lGM;

                        {
                            this.lGM = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(169592);
                            if (!this.lGM.lGr.isRunning()) {
                                hdH.ej(f.b.lFy);
                                AppMethodBeat.o(169592);
                                return;
                            }
                            C0639a aVar = new C0639a(this);
                            m dialogContainer = this.lGM.lGr.getDialogContainer();
                            if (dialogContainer == null) {
                                p.hyc();
                            }
                            com.tencent.mm.plugin.appbrand.d dVar = this.lGM.lGr;
                            p.h(dVar, "$this$notNullContext");
                            dialogContainer.b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(f.c.a(dVar), i.y(cet.LRN), cet.xMq, cet.KFs, aVar));
                            AppMethodBeat.o(169592);
                        }

                        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU$AuthInvoke$2$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$Listener;", "onRecvMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "luggage-wechat-full-sdk_release"})
                        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.l$a$1$a  reason: collision with other inner class name */
                        public static final class C0639a implements c.a {
                            final /* synthetic */ AnonymousClass1 lGO;

                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"createConfirmRequest", "Lcom/tencent/mm/protocal/protobuf/JSLoginConfirmRequest;", "invoke"})
                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.l$a$1$a$a  reason: collision with other inner class name */
                            static final class C0640a extends q implements kotlin.g.a.a<ceq> {
                                final /* synthetic */ ArrayList lGB;
                                final /* synthetic */ int lGC;
                                final /* synthetic */ C0639a lGP;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                C0640a(C0639a aVar, ArrayList arrayList, int i2) {
                                    super(0);
                                    this.lGP = aVar;
                                    this.lGB = arrayList;
                                    this.lGC = i2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ ceq invoke() {
                                    AppMethodBeat.i(169587);
                                    ceq bEN = bEN();
                                    AppMethodBeat.o(169587);
                                    return bEN;
                                }

                                public final ceq bEN() {
                                    AppMethodBeat.i(169588);
                                    ceq ceq = new ceq();
                                    ceq.jfi = this.lGP.lGO.lGM.lGr.getAppId();
                                    LinkedList<String> linkedList = ceq.MjX;
                                    v vVar = this.lGB;
                                    if (vVar == null) {
                                        vVar = v.SXr;
                                    }
                                    linkedList.addAll(vVar);
                                    ceq.MjY = this.lGC;
                                    AppBrandRuntime runtime = this.lGP.lGO.lGM.lGr.getRuntime();
                                    p.g(runtime, "service.runtime");
                                    ceq.MjZ = runtime.brf();
                                    ceq.Mka = l.b(new fdg(), this.lGP.lGO.lGM.lGr);
                                    AppMethodBeat.o(169588);
                                    return ceq;
                                }
                            }

                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/JSLoginConfirmResponse;", "call"})
                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.l$a$1$a$b */
                            static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
                                public static final b lGQ = new b();

                                static {
                                    AppMethodBeat.i(169590);
                                    AppMethodBeat.o(169590);
                                }

                                b() {
                                }

                                @Override // com.tencent.mm.vending.c.a
                                public final /* synthetic */ Object call(Object obj) {
                                    cdz cdz;
                                    String str = null;
                                    AppMethodBeat.i(169589);
                                    cer cer = (cer) obj;
                                    if (cer != null) {
                                        cdz = cer.Mkb;
                                    } else {
                                        cdz = null;
                                    }
                                    if (cer != null) {
                                        str = cer.Mkm;
                                    }
                                    e unused = l.lGK;
                                    r rVar = new r(cdz, str, "/cgi-bin/mmbiz-bin/js-login-confirm");
                                    AppMethodBeat.o(169589);
                                    return rVar;
                                }
                            }

                            /* JADX WARN: Incorrect args count in method signature: ()V */
                            C0639a(AnonymousClass1 r1) {
                                this.lGO = r1;
                            }

                            @Override // com.tencent.mm.plugin.appbrand.widget.dialog.c.a
                            public final void a(int i2, ArrayList<String> arrayList) {
                                AppMethodBeat.i(169591);
                                e unused = l.lGK;
                                Log.i("Luggage.WXA.JsApiLoginLU", "dialog onRecvMsg, resultCode[" + i2 + "], callbackId[" + this.lGO.lGM.lyo + ']');
                                C0640a aVar = new C0640a(this, arrayList, i2);
                                switch (i2) {
                                    case 1:
                                        com.tencent.mm.vending.g.b bVar = hdH;
                                        p.g(bVar, "m");
                                        com.tencent.mm.plugin.appbrand.d dVar = this.lGO.lGM.lGr;
                                        e unused2 = l.lGK;
                                        com.tencent.mm.vending.g.c<_Ret> d2 = l.b(dVar, "/cgi-bin/mmbiz-bin/js-login-confirm", aVar.bEN(), cer.class).d(b.lGQ);
                                        p.g(d2, "service.runCgi(CONFIRM_U…                        }");
                                        p.h(bVar, "$this$bridge");
                                        p.h(d2, "pipeable");
                                        f.c.a(bVar, d2);
                                        AppMethodBeat.o(169591);
                                        return;
                                    case 2:
                                        hdH.ej(new f.a("fail:auth denied"));
                                        com.tencent.mm.plugin.appbrand.d dVar2 = this.lGO.lGM.lGr;
                                        e unused3 = l.lGK;
                                        l.b(dVar2, "/cgi-bin/mmbiz-bin/js-login-confirm", aVar.bEN(), cer.class);
                                        AppMethodBeat.o(169591);
                                        return;
                                    default:
                                        hdH.ej(new f.a("fail:auth canceled"));
                                        AppMethodBeat.o(169591);
                                        return;
                                }
                            }
                        }
                    });
                }
                AppMethodBeat.o(169593);
                return null;
            }
            if (cet != null) {
                cdz = cet.Mkb;
            } else {
                cdz = null;
            }
            if (cet != null) {
                str = cet.Mkm;
            } else {
                str = null;
            }
            e unused = l.lGK;
            r rVar = new r(cdz, str, "/cgi-bin/mmbiz-bin/js-login");
            AppMethodBeat.o(169593);
            return rVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012:\u0010\u0002\u001a6\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0005 \u0006*\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ l lGL;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        b(l lVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lGL = lVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(169594);
            r rVar = (r) obj;
            A a2 = rVar.first;
            B b2 = rVar.second;
            C c2 = rVar.SWY;
            Integer valueOf = a2 != null ? Integer.valueOf(a2.dIZ) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                com.tencent.mm.plugin.appbrand.d dVar = this.lGr;
                int i2 = this.lyo;
                l lVar = this.lGL;
                HashMap hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, b2);
                dVar.i(i2, lVar.n("ok", hashMap));
            } else if (valueOf == null) {
                this.lGr.i(this.lyo, this.lGL.Zf("fail invalid " + l.Zp(c2) + " response"));
            } else {
                this.lGr.i(this.lyo, this.lGL.Zf("fail " + l.Zp(c2) + " response errcode=" + valueOf + " errmsg=" + a2.dJa));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(169594);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU$Companion;", "", "()V", "CONFIRM_URL", "", "CTRL_INDEX", "", "NAME", "QUERY_URL", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(byte b2) {
            this();
        }
    }

    public static fdg b(fdg fdg, k kVar) {
        AppMethodBeat.i(169602);
        p.h(fdg, "$this$fill");
        p.h(kVar, "service");
        fdg a2 = f.c.a(fdg, kVar);
        AppMethodBeat.o(169602);
        return a2;
    }

    public static <R extends dpc> com.tencent.mm.vending.g.c<R> b(k kVar, String str, com.tencent.mm.bw.a aVar, Class<R> cls) {
        AppMethodBeat.i(169601);
        p.h(kVar, "$this$runCgi");
        p.h(str, "url");
        p.h(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(cls, "clazz");
        com.tencent.mm.vending.g.c<R> a2 = f.c.a(kVar, str, aVar, cls);
        AppMethodBeat.o(169601);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(169598);
        a(dVar, jSONObject, i2);
        AppMethodBeat.o(169598);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(230073);
        if (jSONObject == null) {
            AppMethodBeat.o(230073);
            return;
        }
        try {
            if (!jSONObject.has("requestInQueue")) {
                jSONObject.put("requestInQueue", false);
            }
        } catch (JSONException e2) {
            Log.e("Luggage.WXA.JsApiLoginLU", "invoke put KEY_IN_QUEUE e=" + e2.getMessage());
        }
        super.a(dVar, jSONObject, i2);
        AppMethodBeat.o(230073);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2, e eVar) {
        AppMethodBeat.i(230074);
        if (dVar == null) {
            AppMethodBeat.o(230074);
        } else if (jSONObject == null) {
            AppMethodBeat.o(230074);
        } else {
            ces ces = new ces();
            ces.jfi = dVar.getAppId();
            AppBrandRuntime runtime = dVar.getRuntime();
            p.g(runtime, "service.runtime");
            ces.MjZ = runtime.brf();
            ces.Mka = b(new fdg(), dVar);
            b(dVar, "/cgi-bin/mmbiz-bin/js-login", ces, cet.class).d(new a(this, dVar, i2)).f(new b(this, dVar, i2)).a(new c(eVar)).a(new d(this, eVar, dVar, i2));
            AppMethodBeat.o(230074);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onTerminate"})
    static final class c<T> implements d.b<Object> {
        final /* synthetic */ e lGE;

        c(e eVar) {
            this.lGE = eVar;
        }

        @Override // com.tencent.mm.vending.g.d.b
        public final void bz(Object obj) {
            AppMethodBeat.i(169595);
            e eVar = this.lGE;
            if (eVar != null) {
                eVar.bEE();
                AppMethodBeat.o(169595);
                return;
            }
            AppMethodBeat.o(169595);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class d<T> implements d.a<Object> {
        final /* synthetic */ e lGE;
        final /* synthetic */ l lGL;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        d(l lVar, e eVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lGL = lVar;
            this.lGE = eVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(169596);
            e eVar = this.lGE;
            if (eVar != null) {
                eVar.bEE();
            }
            e unused = l.lGK;
            Log.i("Luggage.WXA.JsApiLoginLU", "onInterrupt, appId[" + this.lGr.getAppId() + "], callbackId[" + this.lyo + "], e[" + (obj != null ? obj.toString() : null) + ']');
            if (obj instanceof f.b) {
                AppMethodBeat.o(169596);
            } else if (obj instanceof f.a) {
                this.lGr.i(this.lyo, this.lGL.Zf("fail " + ((f.a) obj).getMessage()));
                AppMethodBeat.o(169596);
            } else if (obj instanceof Throwable) {
                this.lGr.i(this.lyo, this.lGL.Zf("fail " + ((Throwable) obj).getMessage()));
                AppMethodBeat.o(169596);
            } else if (obj == null) {
                this.lGr.i(this.lyo, this.lGL.Zf("fail:internal error"));
                AppMethodBeat.o(169596);
            } else {
                this.lGr.i(this.lyo, this.lGL.Zf("fail ".concat(String.valueOf(obj))));
                AppMethodBeat.o(169596);
            }
        }
    }

    public static final /* synthetic */ String Zp(String str) {
        AppMethodBeat.i(169603);
        switch (str.hashCode()) {
            case -453030458:
                if (str.equals("/cgi-bin/mmbiz-bin/js-login")) {
                    AppMethodBeat.o(169603);
                    return "js-login";
                }
                break;
            case 865464761:
                if (str.equals("/cgi-bin/mmbiz-bin/js-login-confirm")) {
                    AppMethodBeat.o(169603);
                    return "js-login-confirm";
                }
                break;
        }
        AppMethodBeat.o(169603);
        return str;
    }
}
