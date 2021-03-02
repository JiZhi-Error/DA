package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.u;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002JP\u0010\u0007\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J^\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u001c\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u000e\b\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002JH\u0010\u001c\u001a\u00020\u001d2\u001c\u0010\u001e\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u0002H\u0002¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", LocaleUtil.ITALIAN, "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"})
@TargetApi(8)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<ac> {
    private static final int CTRL_INDEX = 209;
    private static final String NAME = NAME;
    public static final a lIh = new a((byte) 0);

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.b<PhoneItem, x> {
        final /* synthetic */ com.tencent.mm.vending.g.b kQj;
        final /* synthetic */ ac lIn;
        final /* synthetic */ y lIr;
        final /* synthetic */ b lIy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(y yVar, ac acVar, b bVar, com.tencent.mm.vending.g.b bVar2) {
            super(1);
            this.lIr = yVar;
            this.lIn = acVar;
            this.lIy = bVar;
            this.kQj = bVar2;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "isSuccess", "", "result", "", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$showPhoneNumberDialog$5$1$1"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, Map<String, ? extends String>, x> {
            final /* synthetic */ PhoneItem lIA;
            final /* synthetic */ r lIz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(r rVar, PhoneItem phoneItem) {
                super(2);
                this.lIz = rVar;
                this.lIA = phoneItem;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Boolean bool, Map<String, ? extends String> map) {
                Long l = null;
                AppMethodBeat.i(230077);
                boolean booleanValue = bool.booleanValue();
                Map<String, ? extends String> map2 = map;
                kotlin.g.b.p.h(map2, "result");
                if (booleanValue) {
                    if (this.lIA.nzy) {
                        y yVar = this.lIz.lIr;
                        if (yVar != null) {
                            y yVar2 = this.lIz.lIr;
                            if (yVar2 != null) {
                                l = Long.valueOf(yVar2.nAK);
                            }
                            if (l == null) {
                                kotlin.g.b.p.hyc();
                            }
                            yVar.nAK = l.longValue() + 1;
                        }
                    } else {
                        y yVar3 = this.lIz.lIr;
                        if (yVar3 != null) {
                            y yVar4 = this.lIz.lIr;
                            if (yVar4 != null) {
                                l = Long.valueOf(yVar4.nAL);
                            }
                            if (l == null) {
                                kotlin.g.b.p.hyc();
                            }
                            yVar3.nAL = l.longValue() + 1;
                        }
                    }
                    com.tencent.mm.vending.g.b bVar = this.lIz.kQj;
                    Object[] objArr = new Object[1];
                    p.a aVar = new p.a("ok", new Object[0]);
                    HashMap hashMap = new HashMap();
                    String str = (String) map2.get("encryptedData");
                    if (str == null) {
                        str = "";
                    }
                    hashMap.put("encryptedData", str);
                    String str2 = (String) map2.get("iv");
                    if (str2 == null) {
                        str2 = "";
                    }
                    hashMap.put("iv", str2);
                    aVar.I(hashMap);
                    objArr[0] = aVar;
                    bVar.G(objArr);
                    com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
                    com.tencent.mm.plugin.appbrand.phonenumber.r.b(this.lIA);
                } else {
                    this.lIz.kQj.ej(map2.get("errMsg"));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(230077);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(PhoneItem phoneItem) {
            String str;
            drb drb;
            Long l = null;
            AppMethodBeat.i(147927);
            PhoneItem phoneItem2 = phoneItem;
            kotlin.g.b.p.h(phoneItem2, "phoneItem");
            Log.d("MicroMsg.JsApiGetPhoneNumberNew", "select phoneItem ".concat(String.valueOf(phoneItem2)));
            y yVar = this.lIr;
            if (yVar != null) {
                y yVar2 = this.lIr;
                Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nAH) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                yVar.nAH = valueOf.longValue() + 1;
            }
            if (phoneItem2.nzw) {
                u uVar = u.nAe;
                com.tencent.mm.plugin.appbrand.phonenumber.n bTz = u.bTz();
                Context context = this.lIn.getContext();
                kotlin.g.b.p.g(context, "env.context");
                String appId = this.lIn.getAppId();
                kotlin.g.b.p.g(appId, "env.appId");
                b bVar = this.lIy;
                if (bVar == null || (drb = bVar.lIi) == null || (str = drb.nBo) == null) {
                    str = "";
                }
                bTz.a(context, appId, str, this.lIr, phoneItem2, new a(this, phoneItem2));
            } else {
                if (phoneItem2.nzy) {
                    y yVar3 = this.lIr;
                    if (yVar3 != null) {
                        y yVar4 = this.lIr;
                        if (yVar4 != null) {
                            l = Long.valueOf(yVar4.nAK);
                        }
                        if (l == null) {
                            kotlin.g.b.p.hyc();
                        }
                        yVar3.nAK = l.longValue() + 1;
                    }
                } else {
                    y yVar5 = this.lIr;
                    if (yVar5 != null) {
                        y yVar6 = this.lIr;
                        if (yVar6 != null) {
                            l = Long.valueOf(yVar6.nAL);
                        }
                        if (l == null) {
                            kotlin.g.b.p.hyc();
                        }
                        yVar5.nAL = l.longValue() + 1;
                    }
                }
                com.tencent.mm.vending.g.b bVar2 = this.kQj;
                p.a aVar = new p.a("ok", new Object[0]);
                HashMap hashMap = new HashMap();
                hashMap.put("encryptedData", phoneItem2.nzu);
                hashMap.put("iv", phoneItem2.bxK);
                hashMap.put("cloud_id", phoneItem2.nzv);
                aVar.I(hashMap);
                bVar2.G(aVar);
                com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
                com.tencent.mm.plugin.appbrand.phonenumber.r.b(phoneItem2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(147927);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "isSuccess", "", "errMsg", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.r<Boolean, String, List<? extends PhoneItem>, b, x> {
        final /* synthetic */ com.tencent.mm.vending.g.b kQj;
        final /* synthetic */ List lIk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(com.tencent.mm.vending.g.b bVar, List list) {
            super(4);
            this.kQj = bVar;
            this.lIk = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Boolean bool, String str, List<? extends PhoneItem> list, b bVar) {
            boolean z = false;
            AppMethodBeat.i(147905);
            boolean booleanValue = bool.booleanValue();
            String str2 = str;
            List<? extends PhoneItem> list2 = list;
            b bVar2 = bVar;
            kotlin.g.b.p.h(str2, "errMsg");
            Log.i("MicroMsg.JsApiGetPhoneNumberNew", "getPhoneNumber isSuccess:" + booleanValue + ", errMsg:" + str2 + ", phoneItems:" + (list2 != null ? list2.size() : 0));
            if (!booleanValue) {
                com.tencent.mm.vending.g.b bVar3 = this.kQj;
                if (str2.length() == 0) {
                    z = true;
                }
                if (z) {
                    str2 = "network request fail";
                }
                bVar3.ej(str2);
            } else {
                com.tencent.mm.vending.g.b bVar4 = this.kQj;
                com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
                bVar4.G(com.tencent.mm.vending.j.a.Q(com.tencent.mm.plugin.appbrand.phonenumber.r.j(list2, this.lIk), bVar2));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(147905);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0006*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"})
    static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ d lIl;
        final /* synthetic */ ac lIn;
        final /* synthetic */ String lIo;
        final /* synthetic */ boolean lIp;

        f(d dVar, ac acVar, String str, boolean z) {
            this.lIl = dVar;
            this.lIn = acVar;
            this.lIo = str;
            this.lIp = z;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(147908);
            ac acVar = this.lIn;
            String str = this.lIo;
            kotlin.g.b.p.g(str, "apiName");
            boolean z = this.lIp;
            z zVar = z.nBg;
            String appId = this.lIn.getAppId();
            kotlin.g.b.p.g(appId, "env.appId");
            com.tencent.mm.vending.j.c a2 = d.a(acVar, str, z, (List) obj, zVar.aex(appId));
            AppMethodBeat.o(147908);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", LocaleUtil.ITALIAN, "call"})
    static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ d lIl;
        final /* synthetic */ ac lIn;
        final /* synthetic */ String lIo;
        final /* synthetic */ boolean lIp;

        g(d dVar, ac acVar, String str, boolean z) {
            this.lIl = dVar;
            this.lIn = acVar;
            this.lIo = str;
            this.lIp = z;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(147909);
            ac acVar = this.lIn;
            z zVar = z.nBg;
            String appId = this.lIn.getAppId();
            kotlin.g.b.p.g(appId, "env.appId");
            y aex = zVar.aex(appId);
            String str = this.lIo;
            kotlin.g.b.p.g(str, "apiName");
            com.tencent.mm.vending.j.c a2 = d.a((com.tencent.mm.vending.j.c) obj, acVar, aex, str, this.lIp);
            AppMethodBeat.o(147909);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", LocaleUtil.ITALIAN, "call"})
    static final class h<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        public static final h lIq = new h();

        static {
            AppMethodBeat.i(147911);
            AppMethodBeat.o(147911);
        }

        h() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            List list;
            AppMethodBeat.i(147910);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
            if (cVar != null) {
                list = (List) cVar.hdM();
            } else {
                list = null;
            }
            com.tencent.mm.plugin.appbrand.phonenumber.r.bQ(list);
            AppMethodBeat.o(147910);
            return cVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"})
    static final class i<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ d lIl;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.g lIm;
        final /* synthetic */ ac lIn;

        i(d dVar, ac acVar, com.tencent.mm.plugin.appbrand.widget.dialog.g gVar) {
            this.lIl = dVar;
            this.lIn = acVar;
            this.lIm = gVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(147912);
            com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a e2 = a.C0643a.e(this.lIn);
            ac acVar = this.lIn;
            com.tencent.mm.plugin.appbrand.widget.dialog.g gVar = this.lIm;
            z zVar = z.nBg;
            String appId = this.lIn.getAppId();
            kotlin.g.b.p.g(appId, "env.appId");
            p.a a2 = d.a((com.tencent.mm.vending.j.c) obj, acVar, gVar, e2, zVar.aex(appId));
            AppMethodBeat.o(147912);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"})
    static final class j<T> implements d.b<p.a> {
        final /* synthetic */ d lIl;
        final /* synthetic */ ac lIn;
        final /* synthetic */ int lyo;

        j(d dVar, ac acVar, int i2) {
            this.lIl = dVar;
            this.lIn = acVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.g.d.b
        public final /* synthetic */ void bz(p.a aVar) {
            AppMethodBeat.i(147913);
            p.a aVar2 = aVar;
            z zVar = z.nBg;
            String appId = this.lIn.getAppId();
            kotlin.g.b.p.g(appId, "env.appId");
            y aex = zVar.aex(appId);
            if (aex != null) {
                aex.report();
            }
            z zVar2 = z.nBg;
            ac acVar = this.lIn;
            String appId2 = acVar != null ? acVar.getAppId() : null;
            kotlin.g.b.p.g(appId2, "env?.appId");
            zVar2.aey(appId2);
            Log.i("MicroMsg.JsApiGetPhoneNumberNew", "callResult: " + aVar2.errMsg + ' ' + aVar2.values);
            if (aVar2 == null) {
                Log.e("MicroMsg.JsApiGetPhoneNumberNew", "callResult is null, fail");
                ac acVar2 = this.lIn;
                if (acVar2 != null) {
                    acVar2.i(this.lyo, this.lIl.Zf("fail"));
                    AppMethodBeat.o(147913);
                    return;
                }
                AppMethodBeat.o(147913);
                return;
            }
            this.lIn.i(this.lyo, this.lIl.n(aVar2.errMsg, aVar2.values));
            AppMethodBeat.o(147913);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ com.tencent.mm.vending.g.b kQj;
        final /* synthetic */ ac lIn;
        final /* synthetic */ String lIo;
        final /* synthetic */ boolean lIp;
        final /* synthetic */ y lIr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(y yVar, ac acVar, String str, boolean z, com.tencent.mm.vending.g.b bVar) {
            super(1);
            this.lIr = yVar;
            this.lIn = acVar;
            this.lIo = str;
            this.lIp = z;
            this.kQj = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(147917);
            if (num.intValue() == -1) {
                y yVar = this.lIr;
                if (yVar != null) {
                    yVar.nAF = 1;
                }
                y yVar2 = this.lIr;
                if (yVar2 != null) {
                    y yVar3 = this.lIr;
                    Long valueOf = yVar3 != null ? Long.valueOf(yVar3.nAG) : null;
                    if (valueOf == null) {
                        kotlin.g.b.p.hyc();
                    }
                    yVar2.nAG = valueOf.longValue() + 1;
                }
                String appId = this.lIn.getAppId();
                kotlin.g.b.p.g(appId, "env.appId");
                new com.tencent.mm.plugin.appbrand.phonenumber.d(appId, this.lIo, this.lIp).b(new kotlin.g.a.r<Boolean, String, List<? extends PhoneItem>, b, x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.d.m.AnonymousClass1 */
                    final /* synthetic */ m lIs;

                    {
                        this.lIs = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.r
                    public final /* synthetic */ x invoke(Boolean bool, String str, List<? extends PhoneItem> list, b bVar) {
                        boolean z;
                        AppMethodBeat.i(147916);
                        boolean booleanValue = bool.booleanValue();
                        String str2 = str;
                        List<? extends PhoneItem> list2 = list;
                        b bVar2 = bVar;
                        kotlin.g.b.p.h(str2, "errMsg");
                        if (!booleanValue) {
                            com.tencent.mm.vending.g.b bVar3 = this.lIs.kQj;
                            if (str2.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                str2 = "network request fail";
                            }
                            bVar3.ej(str2);
                        } else {
                            com.tencent.mm.vending.g.b bVar4 = this.lIs.kQj;
                            com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
                            bVar4.G(com.tencent.mm.vending.j.a.Q(com.tencent.mm.plugin.appbrand.phonenumber.r.j(list2, null), bVar2));
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(147916);
                        return xVar;
                    }
                });
            } else {
                Log.e("MicroMsg.JsApiGetPhoneNumberNew", "bind wechat phone number fail");
                y yVar4 = this.lIr;
                if (yVar4 != null) {
                    yVar4.nAF = 0;
                }
                this.kQj.ej("user cancel");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(147917);
            return xVar;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147930);
        ac acVar2 = acVar;
        kotlin.g.b.p.h(acVar2, "env");
        kotlin.g.b.p.h(jSONObject, "data");
        if (acVar2.getContext() == null || !(acVar2.getContext() instanceof Activity)) {
            Log.e("MicroMsg.JsApiGetPhoneNumberNew", "env is null, return");
            acVar2.i(i2, Zf("fail"));
            AppMethodBeat.o(147930);
            return;
        }
        Log.i("MicroMsg.JsApiGetPhoneNumberNew", "getPhoneNumber data:%s", jSONObject.toString());
        acVar2.getContext();
        z zVar = z.nBg;
        String appId = acVar2.getAppId();
        kotlin.g.b.p.g(appId, "env.appId");
        zVar.init(appId);
        String optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        com.tencent.mm.plugin.appbrand.widget.dialog.g gVar = new com.tencent.mm.plugin.appbrand.widget.dialog.g(acVar2.getContext());
        com.tencent.mm.vending.g.g.hdG().c(new C0645d(this, gVar, acVar2)).d(new e(this)).d(new f(this, acVar2, optString, optBoolean)).d(new g(this, acVar2, optString, optBoolean)).d(h.lIq).f(new i(this, acVar2, gVar)).a(com.tencent.mm.vending.h.d.LOGIC, new j(this, acVar2, i2)).a(new k(this, acVar2, i2)).a(com.tencent.mm.vending.h.d.UI, new l(acVar2, gVar));
        AppMethodBeat.o(147930);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", ShareConstants.RES_PATH, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class k<T> implements d.a<Object> {
        final /* synthetic */ d lIl;
        final /* synthetic */ ac lIn;
        final /* synthetic */ int lyo;

        k(d dVar, ac acVar, int i2) {
            this.lIl = dVar;
            this.lIn = acVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(147914);
            z zVar = z.nBg;
            String appId = this.lIn.getAppId();
            kotlin.g.b.p.g(appId, "env.appId");
            y aex = zVar.aex(appId);
            if (aex != null) {
                aex.report();
            }
            z zVar2 = z.nBg;
            ac acVar = this.lIn;
            String appId2 = acVar != null ? acVar.getAppId() : null;
            kotlin.g.b.p.g(appId2, "env?.appId");
            zVar2.aey(appId2);
            if (obj instanceof String) {
                Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:".concat(String.valueOf(obj)));
                ac acVar2 = this.lIn;
                if (acVar2 != null) {
                    acVar2.i(this.lyo, this.lIl.Zf("fail:".concat(String.valueOf(obj))));
                    AppMethodBeat.o(147914);
                    return;
                }
                AppMethodBeat.o(147914);
            } else if (obj instanceof Exception) {
                Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + obj + ".message}");
                ac acVar3 = this.lIn;
                if (acVar3 != null) {
                    acVar3.i(this.lyo, this.lIl.Zf("fail:{" + obj + ".message}"));
                    AppMethodBeat.o(147914);
                    return;
                }
                AppMethodBeat.o(147914);
            } else {
                Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
                ac acVar4 = this.lIn;
                if (acVar4 != null) {
                    acVar4.i(this.lyo, this.lIl.Zf("fail"));
                    AppMethodBeat.o(147914);
                    return;
                }
                AppMethodBeat.o(147914);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class l<T> implements d.a<Object> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.g lIm;
        final /* synthetic */ ac lIn;

        l(ac acVar, com.tencent.mm.plugin.appbrand.widget.dialog.g gVar) {
            this.lIn = acVar;
            this.lIm = gVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            com.tencent.mm.plugin.appbrand.widget.dialog.m dialogContainer;
            AppMethodBeat.i(147915);
            ac acVar = this.lIn;
            if (acVar == null || (dialogContainer = acVar.getDialogContainer()) == null) {
                AppMethodBeat.o(147915);
                return;
            }
            dialogContainer.c(this.lIm);
            AppMethodBeat.o(147915);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "luggage-wechat-full-sdk_release"})
    public static final class b {
        final drb lIi;
        final dy lIj;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.lIj, r4.lIj) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 147904(0x241c0, float:2.07258E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.appbrand.jsapi.autofill.d$b r4 = (com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b) r4
                com.tencent.mm.protocal.protobuf.drb r0 = r3.lIi
                com.tencent.mm.protocal.protobuf.drb r1 = r4.lIi
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.protocal.protobuf.dy r0 = r3.lIj
                com.tencent.mm.protocal.protobuf.dy r1 = r4.lIj
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(147903);
            drb drb = this.lIi;
            int hashCode = (drb != null ? drb.hashCode() : 0) * 31;
            dy dyVar = this.lIj;
            if (dyVar != null) {
                i2 = dyVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(147903);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(147902);
            String str = "Info(scopeInfo=" + this.lIi + ", alertPrivacyInfo=" + this.lIj + ")";
            AppMethodBeat.o(147902);
            return str;
        }

        public b(drb drb, dy dyVar) {
            this.lIi = drb;
            this.lIj = dyVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class t implements DialogInterface.OnCancelListener {
        final /* synthetic */ com.tencent.mm.vending.g.b kQj;

        t(com.tencent.mm.vending.g.b bVar) {
            this.kQj = bVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(147929);
            this.kQj.ej("user cancel");
            AppMethodBeat.o(147929);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(147931);
        AppMethodBeat.o(147931);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.autofill.d$d  reason: collision with other inner class name */
    static final class C0645d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ d lIl;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.g lIm;
        final /* synthetic */ ac lIn;

        C0645d(d dVar, com.tencent.mm.plugin.appbrand.widget.dialog.g gVar, ac acVar) {
            this.lIl = dVar;
            this.lIm = gVar;
            this.lIn = acVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(147906);
            Object a2 = d.a(this.lIm, this.lIn);
            AppMethodBeat.o(147906);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "call"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ d lIl;

        e(d dVar) {
            this.lIl = dVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(147907);
            List bET = d.bET();
            AppMethodBeat.o(147907);
            return bET;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.vending.g.b kQj;
        final /* synthetic */ y lIr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(y yVar, com.tencent.mm.vending.g.b bVar) {
            super(0);
            this.lIr = yVar;
            this.kQj = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147918);
            y yVar = this.lIr;
            if (yVar != null) {
                y yVar2 = this.lIr;
                Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nAI) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                yVar.nAI = valueOf.longValue() + 1;
            }
            this.kQj.ej("user deny");
            x xVar = x.SXb;
            AppMethodBeat.o(147918);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.vending.g.b kQj;
        final /* synthetic */ y lIr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(y yVar, com.tencent.mm.vending.g.b bVar) {
            super(0);
            this.lIr = yVar;
            this.kQj = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147919);
            y yVar = this.lIr;
            if (yVar != null) {
                y yVar2 = this.lIr;
                Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nAJ) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                yVar.nAJ = valueOf.longValue() + 1;
            }
            this.kQj.ej("user cancel");
            x xVar = x.SXb;
            AppMethodBeat.o(147919);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ac lIn;
        final /* synthetic */ y lIr;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a lIt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(y yVar, ac acVar, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a aVar) {
            super(0);
            this.lIr = yVar;
            this.lIn = acVar;
            this.lIt = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            Context context;
            String str2 = null;
            AppMethodBeat.i(147922);
            y yVar = this.lIr;
            if (yVar != null) {
                y yVar2 = this.lIr;
                Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nAN) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                yVar.nAN = valueOf.longValue() + 1;
            }
            z zVar = z.nBg;
            ac acVar = this.lIn;
            if (acVar != null) {
                str = acVar.getAppId();
            } else {
                str = null;
            }
            kotlin.g.b.p.g(str, "env?.appId");
            zVar.aev(str);
            u uVar = u.nAe;
            com.tencent.mm.plugin.appbrand.phonenumber.n bTz = u.bTz();
            ac acVar2 = this.lIn;
            if (acVar2 != null) {
                context = acVar2.getContext();
            } else {
                context = null;
            }
            kotlin.g.b.p.g(context, "env?.context");
            ac acVar3 = this.lIn;
            if (acVar3 != null) {
                str2 = acVar3.getAppId();
            }
            kotlin.g.b.p.g(str2, "env?.appId");
            bTz.a(context, str2, new kotlin.g.a.m<Integer, Intent, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.d.p.AnonymousClass1 */
                final /* synthetic */ p lIu;

                {
                    this.lIu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Intent intent) {
                    AppMethodBeat.i(147921);
                    com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(new Runnable(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.d.p.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 lIv;

                        {
                            this.lIv = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(147920);
                            com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a aVar = this.lIv.lIu.lIt;
                            com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
                            aVar.setPhoneItems((ArrayList) com.tencent.mm.plugin.appbrand.phonenumber.r.bTy());
                            z zVar = z.nBg;
                            ac acVar = this.lIv.lIu.lIn;
                            String appId = acVar != null ? acVar.getAppId() : null;
                            kotlin.g.b.p.g(appId, "env?.appId");
                            zVar.aew(appId);
                            AppMethodBeat.o(147920);
                        }
                    });
                    x xVar = x.SXb;
                    AppMethodBeat.o(147921);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(147922);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ac lIn;
        final /* synthetic */ y lIr;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a lIt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(y yVar, ac acVar, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a aVar) {
            super(0);
            this.lIr = yVar;
            this.lIn = acVar;
            this.lIt = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            Context context;
            String str2 = null;
            AppMethodBeat.i(147925);
            y yVar = this.lIr;
            if (yVar != null) {
                y yVar2 = this.lIr;
                Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nAO) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                yVar.nAO = valueOf.longValue() + 1;
            }
            z zVar = z.nBg;
            ac acVar = this.lIn;
            if (acVar != null) {
                str = acVar.getAppId();
            } else {
                str = null;
            }
            kotlin.g.b.p.g(str, "env?.appId");
            zVar.aev(str);
            u uVar = u.nAe;
            com.tencent.mm.plugin.appbrand.phonenumber.n bTz = u.bTz();
            ac acVar2 = this.lIn;
            if (acVar2 != null) {
                context = acVar2.getContext();
            } else {
                context = null;
            }
            kotlin.g.b.p.g(context, "env?.context");
            ac acVar3 = this.lIn;
            if (acVar3 != null) {
                str2 = acVar3.getAppId();
            }
            kotlin.g.b.p.g(str2, "env?.appId");
            String bRm = this.lIn.bRm();
            bTz.a(context, str2, bRm == null ? "" : bRm, new kotlin.g.a.m<Integer, Intent, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.d.q.AnonymousClass1 */
                final /* synthetic */ q lIw;

                {
                    this.lIw = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Integer num, Intent intent) {
                    AppMethodBeat.i(147924);
                    com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(new Runnable(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.d.q.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 lIx;

                        {
                            this.lIx = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(147923);
                            com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a aVar = this.lIx.lIw.lIt;
                            com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
                            aVar.setPhoneItems((ArrayList) com.tencent.mm.plugin.appbrand.phonenumber.r.bTy());
                            z zVar = z.nBg;
                            String appId = this.lIx.lIw.lIn.getAppId();
                            kotlin.g.b.p.g(appId, "env.appId");
                            zVar.aew(appId);
                            AppMethodBeat.o(147923);
                        }
                    });
                    x xVar = x.SXb;
                    AppMethodBeat.o(147924);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(147925);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ac lIn;
        final /* synthetic */ y lIr;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a lIt;
        final /* synthetic */ b lIy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(y yVar, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a aVar, ac acVar, b bVar) {
            super(0);
            this.lIr = yVar;
            this.lIt = aVar;
            this.lIn = acVar;
            this.lIy = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147928);
            y yVar = this.lIr;
            if (yVar != null) {
                y yVar2 = this.lIr;
                Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nAM) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                yVar.nAM = valueOf.longValue() + 1;
            }
            this.lIt.a(this.lIn, this.lIy.lIj.KHV, (ag) this.lIn.M(ag.class)).h(this.lIn);
            x xVar = x.SXb;
            AppMethodBeat.o(147928);
            return xVar;
        }
    }

    public static final /* synthetic */ Object a(com.tencent.mm.plugin.appbrand.widget.dialog.g gVar, ac acVar) {
        AppMethodBeat.i(147932);
        com.tencent.mm.vending.g.b hdx = com.tencent.mm.vending.g.g.hdx();
        gVar.setMessage(acVar.getContext().getString(R.string.a2v));
        gVar.setOnCancelListener(new t(hdx));
        com.tencent.mm.plugin.appbrand.widget.dialog.m dialogContainer = acVar.getDialogContainer();
        if (dialogContainer != null) {
            dialogContainer.b(gVar);
        }
        Object obj = new Object();
        AppMethodBeat.o(147932);
        return obj;
    }

    public static final /* synthetic */ List bET() {
        AppMethodBeat.i(147933);
        com.tencent.mm.plugin.appbrand.phonenumber.r rVar = com.tencent.mm.plugin.appbrand.phonenumber.r.nzC;
        List<PhoneItem> bTy = com.tencent.mm.plugin.appbrand.phonenumber.r.bTy();
        AppMethodBeat.o(147933);
        return bTy;
    }

    public static final /* synthetic */ com.tencent.mm.vending.j.c a(ac acVar, String str, boolean z, List list, y yVar) {
        AppMethodBeat.i(169625);
        com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
        if (yVar != null) {
            yVar.nAG++;
        }
        String appId = acVar.getAppId();
        kotlin.g.b.p.g(appId, "env.appId");
        new com.tencent.mm.plugin.appbrand.phonenumber.d(appId, str, z).b(new c(hdH, list));
        AppMethodBeat.o(169625);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r0 != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ com.tencent.mm.vending.j.c a(com.tencent.mm.vending.j.c r9, com.tencent.mm.plugin.appbrand.page.ac r10, com.tencent.mm.plugin.appbrand.phonenumber.y r11, java.lang.String r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.autofill.d.a(com.tencent.mm.vending.j.c, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.plugin.appbrand.phonenumber.y, java.lang.String, boolean):com.tencent.mm.vending.j.c");
    }

    public static final /* synthetic */ p.a a(com.tencent.mm.vending.j.c cVar, ac acVar, com.tencent.mm.plugin.appbrand.widget.dialog.g gVar, com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a aVar, y yVar) {
        b bVar;
        Collection collection;
        dy dyVar;
        com.tencent.mm.plugin.appbrand.widget.dialog.m dialogContainer;
        AppMethodBeat.i(230078);
        Collection collection2 = cVar != null ? (List) cVar.hdM() : null;
        if (cVar != null) {
            bVar = (b) cVar.hdN();
        } else {
            bVar = null;
        }
        com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
        if (!(acVar == null || (dialogContainer = acVar.getDialogContainer()) == null)) {
            dialogContainer.c(gVar);
        }
        String str = ((com.tencent.mm.plugin.appbrand.config.l) acVar.av(com.tencent.mm.plugin.appbrand.config.l.class)).brandName;
        if (str == null) {
            str = "";
        }
        aVar.setAppBrandName(str);
        String str2 = ((com.tencent.mm.plugin.appbrand.config.l) acVar.av(com.tencent.mm.plugin.appbrand.config.l.class)).jyi;
        if (str2 == null) {
            str2 = "";
        }
        aVar.setIconUrl(str2);
        aVar.setOnDeny(new n(yVar, hdH));
        aVar.setOnCancel(new o(yVar, hdH));
        aVar.setOnAddPhoneNumber(new p(yVar, acVar, aVar));
        aVar.setOnManagePhoneNumber(new q(yVar, acVar, aVar));
        aVar.setOnPhoneItemSelect(new r(yVar, acVar, bVar, hdH));
        if (bVar == null || (dyVar = bVar.lIj) == null || !dyVar.KHU) {
            aVar.hm(false);
        } else {
            aVar.hm(true);
            aVar.setOnExplain(new s(yVar, aVar, acVar, bVar));
        }
        if (!(collection2 instanceof ArrayList)) {
            collection = null;
        } else {
            collection = collection2;
        }
        ArrayList<PhoneItem> arrayList = (ArrayList) collection;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        aVar.setPhoneItems(arrayList);
        aVar.h(acVar);
        p.a aVar2 = new p.a("ok", new Object[0]);
        AppMethodBeat.o(230078);
        return aVar2;
    }
}
