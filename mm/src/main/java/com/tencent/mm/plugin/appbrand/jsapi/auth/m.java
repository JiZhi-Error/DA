package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.h;
import com.tencent.luggage.sdk.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.auth.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"})
public final class m extends i implements f {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";
    @Deprecated
    public static final g lHr = new g((byte) 0);

    static {
        AppMethodBeat.i(169619);
        AppMethodBeat.o(169619);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<ceu> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ m lHs;
        final /* synthetic */ String lHt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar, com.tencent.mm.plugin.appbrand.d dVar, String str) {
            super(0);
            this.lHs = mVar;
            this.lGr = dVar;
            this.lHt = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ceu invoke() {
            AppMethodBeat.i(169605);
            ceu bER = bER();
            AppMethodBeat.o(169605);
            return bER;
        }

        public final ceu bER() {
            AppMethodBeat.i(169606);
            ceu ceu = new ceu();
            ceu.jfi = this.lGr.getAppId();
            ceu.oTm = m.Zq(this.lHt);
            AppBrandRuntime runtime = this.lGr.getRuntime();
            p.g(runtime, "service.runtime");
            ceu.MjZ = runtime.brf();
            ceu.Mka = m.b(new fdg(), this.lGr);
            AppMethodBeat.o(169606);
            return ceu;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ m lHs;
        final /* synthetic */ b lHu;
        final /* synthetic */ int lyo;

        c(m mVar, com.tencent.mm.plugin.appbrand.d dVar, int i2, b bVar) {
            this.lHs = mVar;
            this.lGr = dVar;
            this.lyo = i2;
            this.lHu = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            cdz cdz;
            AppMethodBeat.i(169613);
            final cev cev = (cev) obj;
            Integer valueOf = (cev == null || (cdz = cev.Mkb) == null) ? null : Integer.valueOf(cdz.dIZ);
            if (valueOf != null && valueOf.intValue() == -12000) {
                final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                h.RTc.aV(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.m.c.AnonymousClass1 */
                    final /* synthetic */ c lHv;

                    {
                        this.lHv = r1;
                    }

                    public final void run() {
                        boolean z;
                        a aVar;
                        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid;
                        AppMethodBeat.i(169612);
                        if (!this.lHv.lGr.isRunning()) {
                            hdH.ej(f.b.lFy);
                            AppMethodBeat.o(169612);
                            return;
                        }
                        C0641c cVar = new C0641c(this);
                        Context c2 = m.c(this.lHv.lGr);
                        C0641c cVar2 = cVar;
                        AppBrandRuntime runtime = this.lHv.lGr.getRuntime();
                        if (runtime == null || (windowAndroid = runtime.getWindowAndroid()) == null) {
                            z = false;
                        } else {
                            z = windowAndroid.OD();
                        }
                        com.tencent.mm.plugin.appbrand.widget.dialog.h hVar = new com.tencent.mm.plugin.appbrand.widget.dialog.h(c2, cVar2, z);
                        hVar.setAppBrandName(cev.xMq);
                        hVar.setRequestDesc(cev.Mkq.Desc);
                        hVar.setApplyWording(cev.Mkg);
                        hVar.setNegativeButtonText(cev.Mke);
                        hVar.setPositiveButtonText(cev.Mkf);
                        hVar.setIconUrl(cev.KFs);
                        hVar.setFunctionButtonText("");
                        com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid2 = this.lHv.lGr.getWindowAndroid();
                        if (windowAndroid2 != null && windowAndroid2.bsj()) {
                            hVar.setPosition(1);
                        }
                        if (p.j("scope.userInfo", cev.Mkq.KWK)) {
                            com.tencent.luggage.sdk.f.a aVar2 = (com.tencent.luggage.sdk.f.a) this.lHv.lGr.M(com.tencent.luggage.sdk.f.a.class);
                            if (aVar2 == null) {
                                aVar = new a(this);
                            } else {
                                aVar = aVar2;
                            }
                            p.g(aVar, "service.customize(IWecha…                        }");
                            m.b(m.c(this.lHv.lGr), null, aVar.Pa(), "scope.userInfo", hVar);
                            aVar.a(new b(aVar, hVar, this));
                        } else {
                            String str = cev.Mkq.KWK;
                            p.g(str, "response.Scope.Scope");
                            hVar.setScope(str);
                        }
                        com.tencent.mm.plugin.appbrand.widget.dialog.m dialogContainer = this.lHv.lGr.getDialogContainer();
                        if (dialogContainer == null) {
                            p.hyc();
                        }
                        dialogContainer.b(hVar);
                        AppMethodBeat.o(169612);
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$3$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.m$c$1$c  reason: collision with other inner class name */
                    public static final class C0641c implements h.b {
                        final /* synthetic */ AnonymousClass1 lHx;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        C0641c(AnonymousClass1 r1) {
                            this.lHx = r1;
                        }

                        @Override // com.tencent.mm.plugin.appbrand.permission.a.b.c
                        public final void a(int i2, ArrayList<String> arrayList, int i3) {
                            AppMethodBeat.i(169611);
                            p.h(arrayList, "resultData");
                            g unused = m.lHr;
                            Log.i("Luggage.WXA.JsApiOperateWXDataLU", "dialog onMsg, resultCode[" + i2 + "], callbackId[" + this.lHx.lHv.lyo + ']');
                            switch (i2) {
                                case 1:
                                    ceu bER = this.lHx.lHv.lHu.bER();
                                    bER.MjY = 1;
                                    bER.Mkp = (String) j.kt(arrayList);
                                    com.tencent.mm.vending.g.b bVar = hdH;
                                    p.g(bVar, "m");
                                    com.tencent.mm.plugin.appbrand.d dVar = this.lHx.lHv.lGr;
                                    g unused2 = m.lHr;
                                    com.tencent.mm.vending.g.c b2 = m.b(dVar, "/cgi-bin/mmbiz-bin/js-operatewxdata", bER, cev.class);
                                    p.h(bVar, "$this$bridge");
                                    p.h(b2, "pipeable");
                                    f.c.a(bVar, b2);
                                    AppMethodBeat.o(169611);
                                    return;
                                case 2:
                                    hdH.ej(new f.a("fail:auth denied"));
                                    ceu bER2 = this.lHx.lHv.lHu.bER();
                                    bER2.MjY = 2;
                                    com.tencent.mm.plugin.appbrand.d dVar2 = this.lHx.lHv.lGr;
                                    g unused3 = m.lHr;
                                    m.b(dVar2, "/cgi-bin/mmbiz-bin/js-operatewxdata", bER2, cev.class);
                                    AppMethodBeat.o(169611);
                                    return;
                                default:
                                    hdH.ej(new f.a("fail:auth canceled"));
                                    AppMethodBeat.o(169611);
                                    return;
                            }
                        }
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$3$1$1$provider$1", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "luggage-wechat-full-sdk_release"})
                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.m$c$1$a */
                    public static final class a implements com.tencent.luggage.sdk.f.a {
                        final /* synthetic */ AnonymousClass1 lHx;

                        a(AnonymousClass1 r1) {
                            this.lHx = r1;
                        }

                        @Override // com.tencent.luggage.sdk.f.a
                        public final void a(final a.b bVar) {
                            LinkedList<eor> linkedList;
                            eor peekFirst;
                            AppMethodBeat.i(169608);
                            p.h(bVar, "callback");
                            eoq eoq = cev.Mkt;
                            String str = (eoq == null || (linkedList = eoq.Mzx) == null || (peekFirst = linkedList.peekFirst()) == null) ? null : peekFirst.lHM;
                            String str2 = str;
                            if (!(str2 == null || str2.length() == 0)) {
                                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.m.c.AnonymousClass1.a.AnonymousClass1 */

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void aYg() {
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void oD() {
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void I(Bitmap bitmap) {
                                        AppMethodBeat.i(169607);
                                        a.b bVar = bVar;
                                        if (bVar != null) {
                                            bVar.o(bitmap);
                                            AppMethodBeat.o(169607);
                                            return;
                                        }
                                        AppMethodBeat.o(169607);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                                    public final String Lb() {
                                        return "JsApiOperateWXData";
                                    }
                                }, str, (b.h) null);
                                AppMethodBeat.o(169608);
                                return;
                            }
                            bVar.o(null);
                            AppMethodBeat.o(169608);
                        }

                        @Override // com.tencent.luggage.sdk.f.a
                        public final String Pa() {
                            LinkedList<eor> linkedList;
                            eor peekFirst;
                            AppMethodBeat.i(169609);
                            eoq eoq = cev.Mkt;
                            if (eoq == null || (linkedList = eoq.Mzx) == null || (peekFirst = linkedList.peekFirst()) == null) {
                                AppMethodBeat.o(169609);
                                return null;
                            }
                            String str = peekFirst.nickname;
                            AppMethodBeat.o(169609);
                            return str;
                        }
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "onGetImagePath", "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$3$1$1$1"})
                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.m$c$1$b */
                    static final class b implements a.b {
                        final /* synthetic */ com.tencent.luggage.sdk.f.a lGv;
                        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.h lGw;
                        final /* synthetic */ AnonymousClass1 lHx;

                        b(com.tencent.luggage.sdk.f.a aVar, com.tencent.mm.plugin.appbrand.widget.dialog.h hVar, AnonymousClass1 r3) {
                            this.lGv = aVar;
                            this.lGw = hVar;
                            this.lHx = r3;
                        }

                        @Override // com.tencent.luggage.sdk.f.a.b
                        public final void o(Bitmap bitmap) {
                            AppMethodBeat.i(169610);
                            m.b(m.c(this.lHx.lHv.lGr), bitmap, this.lGv.Pa(), "scope.userInfo", this.lGw);
                            AppMethodBeat.o(169610);
                        }
                    }
                });
                AppMethodBeat.o(169613);
                return null;
            }
            AppMethodBeat.o(169613);
            return cev;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ m lHs;
        final /* synthetic */ int lyo;

        d(m mVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lHs = mVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            cdz cdz;
            AppMethodBeat.i(169615);
            cev cev = (cev) obj;
            Integer valueOf = (cev == null || (cdz = cev.Mkb) == null) ? null : Integer.valueOf(cdz.dIZ);
            if (valueOf != null && valueOf.intValue() == 0) {
                com.tencent.mm.bw.b bVar = cev.oTm;
                if (bVar != null) {
                    String yO = bVar.yO();
                    com.tencent.mm.plugin.appbrand.d dVar = this.lGr;
                    int i2 = this.lyo;
                    m mVar = this.lHs;
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", yO);
                    dVar.i(i2, mVar.n("ok", hashMap));
                } else {
                    new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.m.d.AnonymousClass1 */
                        final /* synthetic */ d lHy;

                        {
                            this.lHy = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(169614);
                            g unused = m.lHr;
                            Log.e("Luggage.WXA.JsApiOperateWXDataLU", "response ok but data is NULL, appId[" + this.lHy.lGr.getAppId() + "], callbackId[" + this.lHy.lyo + ']');
                            this.lHy.lGr.i(this.lHy.lyo, this.lHy.lHs.Zf("fail invalid response"));
                            x xVar = x.SXb;
                            AppMethodBeat.o(169614);
                            return xVar;
                        }
                    }.invoke();
                }
            } else if (valueOf == null) {
                this.lGr.i(this.lyo, this.lHs.Zf("fail invalid response"));
            } else {
                this.lGr.i(this.lyo, this.lHs.Zf("fail response errcode=" + valueOf + " errmsg=" + cev.Mkb.dJa));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(169615);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "URL", "luggage-wechat-full-sdk_release"})
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }
    }

    public static com.tencent.mm.bw.b Zq(String str) {
        AppMethodBeat.i(169620);
        p.h(str, "$this$toByteString");
        p.h(str, "$this$toByteString");
        byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.bw.b bVar = new com.tencent.mm.bw.b(bytes);
        AppMethodBeat.o(169620);
        return bVar;
    }

    public static fdg b(fdg fdg, k kVar) {
        AppMethodBeat.i(169624);
        p.h(fdg, "$this$fill");
        p.h(kVar, "service");
        fdg a2 = f.c.a(fdg, kVar);
        AppMethodBeat.o(169624);
        return a2;
    }

    public static <R extends dpc> com.tencent.mm.vending.g.c<R> b(k kVar, String str, com.tencent.mm.bw.a aVar, Class<R> cls) {
        AppMethodBeat.i(169622);
        p.h(kVar, "$this$runCgi");
        p.h(str, "url");
        p.h(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(cls, "clazz");
        com.tencent.mm.vending.g.c<R> a2 = f.c.a(kVar, str, aVar, cls);
        AppMethodBeat.o(169622);
        return a2;
    }

    public static void b(Context context, Bitmap bitmap, String str, String str2, com.tencent.mm.plugin.appbrand.permission.a.b bVar) {
        AppMethodBeat.i(230076);
        p.h(context, "context");
        p.h(bVar, "dialog");
        f.c.a(context, bitmap, str, str2, bVar);
        AppMethodBeat.o(230076);
    }

    public static Context c(k kVar) {
        AppMethodBeat.i(169621);
        p.h(kVar, "$this$notNullContext");
        Context a2 = f.c.a(kVar);
        AppMethodBeat.o(169621);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2, e eVar) {
        AppMethodBeat.i(230075);
        if (dVar == null) {
            AppMethodBeat.o(230075);
        } else if (jSONObject == null) {
            AppMethodBeat.o(230075);
        } else {
            String optString = jSONObject.optString("data", null);
            if (optString == null) {
                new a(this, dVar, i2).invoke();
                AppMethodBeat.o(230075);
                return;
            }
            b bVar = new b(this, dVar, optString);
            b(dVar, "/cgi-bin/mmbiz-bin/js-operatewxdata", bVar.bER(), cev.class).d(new c(this, dVar, i2, bVar)).f(new d(this, dVar, i2)).a(new e(eVar)).a(com.tencent.mm.vending.h.d.UI, new f(this, eVar, dVar, i2));
            AppMethodBeat.o(230075);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onTerminate"})
    static final class e<T> implements d.b<Object> {
        final /* synthetic */ e lGE;

        e(e eVar) {
            this.lGE = eVar;
        }

        @Override // com.tencent.mm.vending.g.d.b
        public final void bz(Object obj) {
            AppMethodBeat.i(169616);
            e eVar = this.lGE;
            if (eVar != null) {
                eVar.bEE();
                AppMethodBeat.o(169616);
                return;
            }
            AppMethodBeat.o(169616);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class f<T> implements d.a<Object> {
        final /* synthetic */ e lGE;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ m lHs;
        final /* synthetic */ int lyo;

        f(m mVar, e eVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.lHs = mVar;
            this.lGE = eVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(169617);
            e eVar = this.lGE;
            if (eVar != null) {
                eVar.bEE();
            }
            g unused = m.lHr;
            Log.i("Luggage.WXA.JsApiOperateWXDataLU", "onInterrupt, appId[" + this.lGr.getAppId() + "], callbackId[" + this.lyo + "], e[" + (obj != null ? obj.toString() : null) + ']');
            if (obj instanceof f.b) {
                AppMethodBeat.o(169617);
            } else if (obj instanceof f.a) {
                this.lGr.i(this.lyo, this.lHs.Zf("fail " + ((f.a) obj).getMessage()));
                AppMethodBeat.o(169617);
            } else if (obj instanceof Throwable) {
                this.lGr.i(this.lyo, this.lHs.Zf("fail " + ((Throwable) obj).getMessage()));
                AppMethodBeat.o(169617);
            } else if (obj == null) {
                this.lGr.i(this.lyo, this.lHs.Zf("fail:internal error"));
                AppMethodBeat.o(169617);
            } else {
                this.lGr.i(this.lyo, this.lHs.Zf("fail ".concat(String.valueOf(obj))));
                AppMethodBeat.o(169617);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lGr;
        final /* synthetic */ m lHs;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m mVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            super(0);
            this.lHs = mVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(169604);
            this.lGr.i(this.lyo, this.lHs.Zf("fail:invalid data"));
            x xVar = x.SXb;
            AppMethodBeat.o(169604);
            return xVar;
        }
    }
}
