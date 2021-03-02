package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.h;
import com.tencent.luggage.sdk.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.auth.f;
import com.tencent.mm.plugin.appbrand.permission.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class k extends i implements f {
    public static final int CTRL_INDEX = 54;
    public static final String NAME = "authorize";
    @Deprecated
    public static final f lGp = new f((byte) 0);

    static {
        AppMethodBeat.i(169581);
        AppMethodBeat.o(169581);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k lGq;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        b(k kVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lGq = kVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            cdz cdz;
            cdz cdz2;
            AppMethodBeat.i(169576);
            final cep cep = (cep) obj;
            Integer valueOf = (cep == null || (cdz2 = cep.Mkb) == null) ? null : Integer.valueOf(cdz2.dIZ);
            if (valueOf != null && valueOf.intValue() == -12000) {
                final com.tencent.mm.vending.g.b hdH = g.hdH();
                LinkedList<drb> linkedList = cep.LRN;
                if (linkedList == null || linkedList.isEmpty()) {
                    this.lGr.i(this.lyo, this.lGq.Zf("fail:internal error scope empty"));
                } else {
                    h.RTc.aV(new Runnable(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.k.b.AnonymousClass1 */
                        final /* synthetic */ b lGs;

                        {
                            this.lGs = r1;
                        }

                        public final void run() {
                            boolean z;
                            com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid;
                            AppMethodBeat.i(169575);
                            if (!this.lGs.lGr.isRunning()) {
                                hdH.ej(f.b.lFy);
                                AppMethodBeat.o(169575);
                                return;
                            }
                            C0637b bVar = new C0637b(this);
                            LinkedList<drb> linkedList = cep.LRN;
                            p.g(linkedList, "response.ScopeList");
                            drb first = linkedList.getFirst();
                            String str = first.KWK;
                            AppBrandRuntime runtime = this.lGs.lGr.getRuntime();
                            p.g(runtime, "service.runtime");
                            boolean a2 = q.a(str, runtime.OT());
                            if (!a2 || !TextUtils.isEmpty(q.a(first.KWK, this.lGs.lGr.getRuntime()))) {
                                Context c2 = k.c(this.lGs.lGr);
                                C0637b bVar2 = bVar;
                                AppBrandRuntime runtime2 = this.lGs.lGr.getRuntime();
                                if (runtime2 == null || (windowAndroid = runtime2.getWindowAndroid()) == null) {
                                    z = false;
                                } else {
                                    z = windowAndroid.OD();
                                }
                                com.tencent.mm.plugin.appbrand.widget.dialog.h hVar = new com.tencent.mm.plugin.appbrand.widget.dialog.h(c2, bVar2, z);
                                hVar.setAppBrandName(cep.xMq);
                                hVar.setRequestDesc(first.Desc);
                                hVar.setApplyWording(cep.Mkg);
                                hVar.setNegativeButtonText(cep.Mke);
                                hVar.setPositiveButtonText(cep.Mkf);
                                hVar.setIconUrl(cep.KFs);
                                com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid2 = this.lGs.lGr.getWindowAndroid();
                                if (windowAndroid2 != null && windowAndroid2.bsj()) {
                                    hVar.setPosition(1);
                                }
                                if (p.j("scope.userInfo", first.KWK)) {
                                    com.tencent.luggage.sdk.f.a b2 = a.C0186a.b(this.lGs.lGr);
                                    p.g(b2, "IWechatUserInfoProvider.….notNullProvider(service)");
                                    k.b(k.c(this.lGs.lGr), null, b2.Pa(), "scope.userInfo", hVar);
                                    b2.a(new a(b2, hVar, this, first, a2));
                                } else {
                                    String str2 = first.KWK;
                                    p.g(str2, "scopeInfo.Scope");
                                    hVar.setScope(str2);
                                }
                                if (a2) {
                                    hVar.setSimpleDetailDesc(q.a(first.KWK, this.lGs.lGr.getRuntime()));
                                }
                                m dialogContainer = this.lGs.lGr.getDialogContainer();
                                if (dialogContainer == null) {
                                    p.hyc();
                                }
                                dialogContainer.b(hVar);
                                AppMethodBeat.o(169575);
                                return;
                            }
                            hdH.ej(new f.a("fail:require permission desc"));
                            AppMethodBeat.o(169575);
                        }

                        @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU$AuthInvoke$3$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
                        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.k$b$1$b  reason: collision with other inner class name */
                        public static final class C0637b implements h.b {
                            final /* synthetic */ AnonymousClass1 lGx;

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"createConfirmRequest", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeConfirmRequest;", "invoke"})
                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.k$b$1$b$a */
                            static final class a extends kotlin.g.b.q implements kotlin.g.a.a<cem> {
                                final /* synthetic */ C0637b lGA;
                                final /* synthetic */ ArrayList lGB;
                                final /* synthetic */ int lGC;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                a(C0637b bVar, ArrayList arrayList, int i2) {
                                    super(0);
                                    this.lGA = bVar;
                                    this.lGB = arrayList;
                                    this.lGC = i2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ cem invoke() {
                                    AppMethodBeat.i(169570);
                                    cem bEL = bEL();
                                    AppMethodBeat.o(169570);
                                    return bEL;
                                }

                                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.LinkedList<java.lang.String> */
                                /* JADX WARN: Multi-variable type inference failed */
                                public final cem bEL() {
                                    AppMethodBeat.i(169571);
                                    cem cem = new cem();
                                    cem.jfi = this.lGA.lGx.lGs.lGr.getAppId();
                                    cem.MjX.add(j.kt(this.lGB));
                                    cem.MjY = this.lGC;
                                    AppBrandRuntime runtime = this.lGA.lGx.lGs.lGr.getRuntime();
                                    p.g(runtime, "service.runtime");
                                    cem.MjZ = runtime.brf();
                                    cem.Mka = k.b(new fdg(), this.lGA.lGx.lGs.lGr);
                                    AppMethodBeat.o(169571);
                                    return cem;
                                }
                            }

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeConfirmResponse;", "call"})
                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.k$b$1$b$b  reason: collision with other inner class name */
                            static final class C0638b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
                                public static final C0638b lGD = new C0638b();

                                static {
                                    AppMethodBeat.i(169573);
                                    AppMethodBeat.o(169573);
                                }

                                C0638b() {
                                }

                                @Override // com.tencent.mm.vending.c.a
                                public final /* synthetic */ Object call(Object obj) {
                                    cdz cdz;
                                    AppMethodBeat.i(169572);
                                    cen cen = (cen) obj;
                                    if (cen != null) {
                                        cdz = cen.Mkb;
                                    } else {
                                        cdz = null;
                                    }
                                    f unused = k.lGp;
                                    o oVar = new o(cdz, "/cgi-bin/mmbiz-bin/js-authorize-confirm");
                                    AppMethodBeat.o(169572);
                                    return oVar;
                                }
                            }

                            /* JADX WARN: Incorrect args count in method signature: ()V */
                            C0637b(AnonymousClass1 r1) {
                                this.lGx = r1;
                            }

                            @Override // com.tencent.mm.plugin.appbrand.permission.a.b.c
                            public final void a(int i2, ArrayList<String> arrayList, int i3) {
                                AppMethodBeat.i(169574);
                                p.h(arrayList, "resultData");
                                f unused = k.lGp;
                                Log.i("Luggage.WXA.JsApiAuthorizeLU", "dialog onMsg, resultCode[" + i2 + "], callbackId[" + this.lGx.lGs.lyo + ']');
                                a aVar = new a(this, arrayList, i2);
                                switch (i2) {
                                    case 1:
                                        com.tencent.mm.vending.g.b bVar = hdH;
                                        p.g(bVar, "m");
                                        com.tencent.mm.plugin.appbrand.d dVar = this.lGx.lGs.lGr;
                                        f unused2 = k.lGp;
                                        com.tencent.mm.vending.g.c<_Ret> d2 = k.b(dVar, "/cgi-bin/mmbiz-bin/js-authorize-confirm", aVar.bEL(), cen.class).d(C0638b.lGD);
                                        p.g(d2, "service.runCgi(CONFIRM_U…                        }");
                                        p.h(bVar, "$this$bridge");
                                        p.h(d2, "pipeable");
                                        f.c.a(bVar, d2);
                                        AppMethodBeat.o(169574);
                                        return;
                                    case 2:
                                        hdH.ej(new f.a("fail:auth denied"));
                                        com.tencent.mm.plugin.appbrand.d dVar2 = this.lGx.lGs.lGr;
                                        f unused3 = k.lGp;
                                        k.b(dVar2, "/cgi-bin/mmbiz-bin/js-authorize-confirm", aVar.bEL(), cen.class);
                                        AppMethodBeat.o(169574);
                                        return;
                                    default:
                                        hdH.ej(new f.a("fail:auth canceled"));
                                        AppMethodBeat.o(169574);
                                        return;
                                }
                            }
                        }

                        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "onGetImagePath", "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU$AuthInvoke$3$1$1$1"})
                        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.k$b$1$a */
                        static final class a implements a.b {
                            final /* synthetic */ com.tencent.luggage.sdk.f.a lGv;
                            final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.h lGw;
                            final /* synthetic */ AnonymousClass1 lGx;
                            final /* synthetic */ drb lGy;
                            final /* synthetic */ boolean lGz;

                            a(com.tencent.luggage.sdk.f.a aVar, com.tencent.mm.plugin.appbrand.widget.dialog.h hVar, AnonymousClass1 r3, drb drb, boolean z) {
                                this.lGv = aVar;
                                this.lGw = hVar;
                                this.lGx = r3;
                                this.lGy = drb;
                                this.lGz = z;
                            }

                            @Override // com.tencent.luggage.sdk.f.a.b
                            public final void o(Bitmap bitmap) {
                                AppMethodBeat.i(169569);
                                k.b(k.c(this.lGx.lGs.lGr), bitmap, this.lGv.Pa(), "scope.userInfo", this.lGw);
                                AppMethodBeat.o(169569);
                            }
                        }
                    });
                }
                AppMethodBeat.o(169576);
                return null;
            }
            if (cep != null) {
                cdz = cep.Mkb;
            } else {
                cdz = null;
            }
            f unused = k.lGp;
            o oVar = new o(cdz, "/cgi-bin/mmbiz-bin/js-authorize");
            AppMethodBeat.o(169576);
            return oVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k lGq;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        c(k kVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lGq = kVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(169577);
            o oVar = (o) obj;
            A a2 = oVar.first;
            B b2 = oVar.second;
            Integer valueOf = a2 != null ? Integer.valueOf(a2.dIZ) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                this.lGr.i(this.lyo, this.lGq.Zf("ok"));
            } else if (valueOf == null) {
                this.lGr.i(this.lyo, this.lGq.Zf("fail invalid " + k.Zo(b2) + " response"));
            } else {
                this.lGr.i(this.lyo, this.lGq.Zf("fail " + k.Zo(b2) + " response errcode=" + valueOf + " errmsg=" + a2.dJa));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(169577);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU$Companion;", "", "()V", "CONFIRM_URL", "", "CTRL_INDEX", "", "NAME", "QUERY_URL", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(byte b2) {
            this();
        }
    }

    public static fdg b(fdg fdg, com.tencent.mm.plugin.appbrand.jsapi.k kVar) {
        AppMethodBeat.i(169585);
        p.h(fdg, "$this$fill");
        p.h(kVar, "service");
        fdg a2 = f.c.a(fdg, kVar);
        AppMethodBeat.o(169585);
        return a2;
    }

    public static <R extends dpc> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.plugin.appbrand.jsapi.k kVar, String str, com.tencent.mm.bw.a aVar, Class<R> cls) {
        AppMethodBeat.i(169583);
        p.h(kVar, "$this$runCgi");
        p.h(str, "url");
        p.h(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(cls, "clazz");
        com.tencent.mm.vending.g.c<R> a2 = f.c.a(kVar, str, aVar, cls);
        AppMethodBeat.o(169583);
        return a2;
    }

    public static void b(Context context, Bitmap bitmap, String str, String str2, com.tencent.mm.plugin.appbrand.permission.a.b bVar) {
        AppMethodBeat.i(230072);
        p.h(context, "context");
        p.h(bVar, "dialog");
        f.c.a(context, bitmap, str, str2, bVar);
        AppMethodBeat.o(230072);
    }

    public static Context c(com.tencent.mm.plugin.appbrand.jsapi.k kVar) {
        AppMethodBeat.i(169582);
        p.h(kVar, "$this$notNullContext");
        Context a2 = f.c.a(kVar);
        AppMethodBeat.o(169582);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2, e eVar) {
        boolean z;
        AppMethodBeat.i(230071);
        if (dVar == null) {
            AppMethodBeat.o(230071);
        } else if (jSONObject == null) {
            AppMethodBeat.o(230071);
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("scope");
            if (optJSONArray == null) {
                new a(this, dVar, i2).invoke();
                AppMethodBeat.o(230071);
                return;
            }
            LinkedList linkedList = new LinkedList();
            int length = optJSONArray.length();
            if (length >= 0) {
                int i3 = 0;
                while (true) {
                    String optString = optJSONArray.optString(i3, null);
                    String str = optString;
                    if (str == null || str.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        linkedList.add(optString);
                    }
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            ceo ceo = new ceo();
            ceo.jfi = dVar.getAppId();
            ceo.MjX.addAll(linkedList);
            AppBrandRuntime runtime = dVar.getRuntime();
            p.g(runtime, "service.runtime");
            ceo.MjZ = runtime.brf();
            ceo.Mka = b(new fdg(), dVar);
            b(dVar, "/cgi-bin/mmbiz-bin/js-authorize", ceo, cep.class).d(new b(this, dVar, i2)).f(new c(this, dVar, i2)).a(new d(eVar)).a(new e(this, eVar, dVar, i2));
            AppMethodBeat.o(230071);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onTerminate"})
    static final class d<T> implements d.b<Object> {
        final /* synthetic */ e lGE;

        d(e eVar) {
            this.lGE = eVar;
        }

        @Override // com.tencent.mm.vending.g.d.b
        public final void bz(Object obj) {
            AppMethodBeat.i(169578);
            e eVar = this.lGE;
            if (eVar != null) {
                eVar.bEE();
                AppMethodBeat.o(169578);
                return;
            }
            AppMethodBeat.o(169578);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class e<T> implements d.a<Object> {
        final /* synthetic */ e lGE;
        final /* synthetic */ k lGq;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        e(k kVar, e eVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lGq = kVar;
            this.lGE = eVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(169579);
            e eVar = this.lGE;
            if (eVar != null) {
                eVar.bEE();
            }
            f unused = k.lGp;
            Log.i("Luggage.WXA.JsApiAuthorizeLU", "onInterrupt, appId[" + this.lGr.getAppId() + "], callbackId[" + this.lyo + "], e[" + (obj != null ? obj.toString() : null) + ']');
            if (obj instanceof f.b) {
                AppMethodBeat.o(169579);
            } else if (obj instanceof f.a) {
                this.lGr.i(this.lyo, this.lGq.Zf("fail " + ((f.a) obj).getMessage()));
                AppMethodBeat.o(169579);
            } else if (obj instanceof Throwable) {
                this.lGr.i(this.lyo, this.lGq.Zf("fail " + ((Throwable) obj).getMessage()));
                AppMethodBeat.o(169579);
            } else if (obj == null) {
                this.lGr.i(this.lyo, this.lGq.Zf("fail:internal error"));
                AppMethodBeat.o(169579);
            } else {
                this.lGr.i(this.lyo, this.lGq.Zf("fail ".concat(String.valueOf(obj))));
                AppMethodBeat.o(169579);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ k lGq;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            super(0);
            this.lGq = kVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(169568);
            this.lGr.i(this.lyo, this.lGq.Zf("fail:invalid data"));
            x xVar = x.SXb;
            AppMethodBeat.o(169568);
            return xVar;
        }
    }

    public static final /* synthetic */ String Zo(String str) {
        AppMethodBeat.i(169586);
        switch (str.hashCode()) {
            case -1813933127:
                if (str.equals("/cgi-bin/mmbiz-bin/js-authorize-confirm")) {
                    AppMethodBeat.o(169586);
                    return "js-authorize-confirm";
                }
                break;
            case 1410133958:
                if (str.equals("/cgi-bin/mmbiz-bin/js-authorize")) {
                    AppMethodBeat.o(169586);
                    return "js-authorize";
                }
                break;
        }
        AppMethodBeat.o(169586);
        return str;
    }
}
