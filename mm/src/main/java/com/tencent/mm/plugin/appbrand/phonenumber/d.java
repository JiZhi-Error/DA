package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.d;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002Jt\u0010\u000e\u001a\u00020\u000f2l\u0010\u0010\u001ah\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getApiName", "()Ljava/lang/String;", "getAppId", "getWithCredentials", "()Z", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "info", "luggage-wechat-full-sdk_release"})
public final class d {
    private final String appId;
    private final String nbb;
    private final boolean nyJ;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ r nyK;

        a(r rVar) {
            this.nyK = rVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(148024);
            cev cev = (cev) obj;
            Log.i("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber success");
            int i2 = cev.Mkb.dIZ;
            String str = cev.Mkb.dJa;
            h hVar = h.nzb;
            if (i2 != h.bTk()) {
                Log.e("Luggage.FULL.CgiPhoneNumber", "jsErrcode:" + i2 + ", jsErrmsg:" + str);
                r rVar = this.nyK;
                if (rVar != null) {
                    Boolean bool = Boolean.FALSE;
                    if (str == null) {
                        str = "";
                    }
                    rVar.invoke(bool, str, null, null);
                }
            } else {
                JSONObject jSONObject = new JSONObject(cev.oTm.yO());
                ArrayList arrayList = new ArrayList();
                PhoneItem.a aVar = PhoneItem.nzA;
                String optString = jSONObject.optString("wx_phone");
                p.g(optString, "phoneItemsJsonObj.optString(\"wx_phone\")");
                PhoneItem aet = PhoneItem.a.aet(optString);
                if (aet != null) {
                    aet.nzy = true;
                    arrayList.add(aet);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("custom_phone_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        PhoneItem.a aVar2 = PhoneItem.nzA;
                        String string = optJSONArray.getString(i3);
                        p.g(string, "customPhoneItemsObjArray.getString(i)");
                        PhoneItem aet2 = PhoneItem.a.aet(string);
                        if (aet2 != null) {
                            arrayList.add(aet2);
                        }
                    }
                }
                r rVar2 = this.nyK;
                if (rVar2 != null) {
                    rVar2.invoke(Boolean.TRUE, "", arrayList, new d.b(cev.Mkq, cev.Mkh));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(148024);
            return xVar;
        }
    }

    public d(String str, String str2, boolean z) {
        p.h(str, "appId");
        p.h(str2, "apiName");
        AppMethodBeat.i(148028);
        this.appId = str;
        this.nbb = str2;
        this.nyJ = z;
        AppMethodBeat.o(148028);
    }

    private static String aA(String str, boolean z) {
        AppMethodBeat.i(148026);
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(str);
            jSONStringer.key("with_credentials");
            jSONStringer.value(z);
            jSONStringer.endObject();
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", e2, "", new Object[0]);
        }
        String jSONStringer2 = jSONStringer.toString();
        p.g(jSONStringer2, "jsonStringer.toString()");
        AppMethodBeat.o(148026);
        return jSONStringer2;
    }

    public final void b(r<? super Boolean, ? super String, ? super List<PhoneItem>, ? super d.b, x> rVar) {
        AppMethodBeat.i(148027);
        String aA = aA(this.nbb, this.nyJ);
        ceu ceu = new ceu();
        ceu.jfi = this.appId;
        Charset charset = kotlin.n.d.UTF_8;
        if (aA == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(148027);
            throw tVar;
        }
        byte[] bytes = aA.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        ceu.oTm = new com.tencent.mm.bw.b(bytes);
        ((c) e.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", ceu, cev.class).c(new a(rVar)).a(new b(rVar));
        AppMethodBeat.o(148027);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    public static final class b<T> implements d.a<Object> {
        final /* synthetic */ r nyK;

        b(r rVar) {
            this.nyK = rVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(148025);
            Log.e("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
            if (obj instanceof Exception) {
                Log.e("Luggage.FULL.CgiPhoneNumber", "CgiGetAllPhone " + ((Exception) obj).getMessage());
            }
            r rVar = this.nyK;
            if (rVar != null) {
                rVar.invoke(Boolean.FALSE, "cgi fail", null, null);
                AppMethodBeat.o(148025);
                return;
            }
            AppMethodBeat.o(148025);
        }
    }
}
