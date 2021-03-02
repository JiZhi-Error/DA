package com.tencent.mm.plugin.ab;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ezy;
import com.tencent.mm.protocal.protobuf.ezz;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\nH\u0007J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0007J\f\u0010\u001a\u001a\u00020\u001b*\u00020\nH\u0002¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;)V", "cgi", "", "cmdId", "", "cgiUrl", "", "reqProtoBuf", "callback", "cgiCallBack", "errMsg", "commonCgi", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "getBasePkgVersion", "getBizPkgVersion", "getLocalData", "key", "invoke", "func", "message", "setLocalData", "data", "asCallbacker", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "webview-sdk_release"})
public final class j extends a<k> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(k kVar) {
        super("wxJsEngineClient", kVar);
        p.h(kVar, "context");
        AppMethodBeat.i(224834);
        AppMethodBeat.o(224834);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032F\u0010\u0006\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\b0\b\u0018\u00010\t0\u0007H\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
    static final class a implements com.tencent.mm.plugin.webview.d.b {
        final /* synthetic */ j IBj;
        final /* synthetic */ String IBk;

        a(j jVar, String str) {
            this.IBj = jVar;
            this.IBk = str;
        }

        @Override // com.tencent.mm.plugin.webview.d.b
        public final void h(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(224824);
            HashMap hashMap = new HashMap();
            p.g(str2, "ret");
            hashMap.put("err_msg", str2);
            if (map != null) {
                hashMap.putAll(map);
            }
            String a2 = n.a.a(str, (Map<String, Object>) hashMap, false, "");
            Log.i(this.IBj.TAG, "invoke callback: " + str2 + ", " + this.IBk + ", " + a2);
            String str3 = this.IBk;
            String iVar = new i(a2).FJ("__params").toString();
            p.g(iVar, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
            c.a.a((k) this.IBj.IBa, str3, iVar, null, 4);
            AppMethodBeat.o(224824);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class b implements aa.a {
        final /* synthetic */ j IBj;
        final /* synthetic */ int IBl;
        final /* synthetic */ String pwf;

        b(j jVar, int i2, String str) {
            this.IBj = jVar;
            this.IBl = i2;
            this.pwf = str;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            AppMethodBeat.i(224825);
            p.h(dVar, "rr");
            Log.i(this.IBj.TAG, "do cgi callback cmdId=" + this.IBl);
            com.tencent.mm.bw.a aYK = dVar.aYK();
            p.g(aYK, "rr.responseProtoBuf");
            if (Util.isNullOrNil(aYK.getData())) {
                j.a(this.IBj, "fail response data is empty", this.pwf);
                AppMethodBeat.o(224825);
            } else {
                com.tencent.mm.bw.a aYK2 = dVar.aYK();
                p.g(aYK2, "rr.responseProtoBuf");
                byte[] encode = Base64.encode(aYK2.getData(), 2);
                p.g(encode, "Base64.encode(rr.respons…Buf.data, Base64.NO_WRAP)");
                Charset charset = StandardCharsets.UTF_8;
                p.g(charset, "StandardCharsets.UTF_8");
                c.a.a((k) this.IBj.IBa, this.pwf, "'" + new String(encode, charset) + '\'', null, 4);
                AppMethodBeat.o(224825);
            }
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class c implements aa.a {
        final /* synthetic */ j IBj;
        final /* synthetic */ String pwf;

        c(j jVar, String str) {
            this.IBj = jVar;
            this.pwf = str;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            String str2;
            AppMethodBeat.i(224826);
            Log.i(this.IBj.TAG, "videoPreloadCgi callback " + i2 + '/' + i2 + ' ' + str);
            if (i2 == 0 && i3 == 0) {
                String str3 = this.IBj.TAG;
                StringBuilder sb = new StringBuilder("resp_str = ");
                p.g(dVar, "comReqResp");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (!(aYK instanceof ezz)) {
                    aYK = null;
                }
                ezz ezz = (ezz) aYK;
                Log.d(str3, sb.append(ezz != null ? ezz.NvX : null).toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errMsg", "ok");
                jSONObject.put("errCode", i3);
                com.tencent.mm.bw.a aYK2 = dVar.aYK();
                if (!(aYK2 instanceof ezz)) {
                    aYK2 = null;
                }
                ezz ezz2 = (ezz) aYK2;
                if (ezz2 == null || (str2 = ezz2.NvX) == null) {
                    str2 = "{}";
                }
                try {
                    jSONObject.put("data", new JSONObject(str2));
                } catch (Exception e2) {
                    jSONObject.put("data", str2);
                }
                String jSONObject2 = jSONObject.toString();
                p.g(jSONObject2, "org.json.JSONObject().ap…             }.toString()");
                c.a.a((k) this.IBj.IBa, this.pwf, jSONObject2, null, 4);
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errMsg", "fail");
                jSONObject3.put("errCode", i3);
                String jSONObject4 = jSONObject3.toString();
                p.g(jSONObject4, "org.json.JSONObject().ap…             }.toString()");
                c.a.a((k) this.IBj.IBa, this.pwf, jSONObject4, null, 4);
            }
            AppMethodBeat.o(224826);
            return 0;
        }
    }

    @JavascriptInterface
    public final int getBasePkgVersion() {
        AppMethodBeat.i(224827);
        int basePkgVersion = ((k) this.IBa).getBasePkgVersion();
        AppMethodBeat.o(224827);
        return basePkgVersion;
    }

    @JavascriptInterface
    public final int getBizPkgVersion() {
        AppMethodBeat.i(224828);
        int bizPkgVersion = ((k) this.IBa).getBizPkgVersion();
        AppMethodBeat.o(224828);
        return bizPkgVersion;
    }

    @JavascriptInterface
    public final void invoke(String str, String str2, String str3) {
        AppMethodBeat.i(224829);
        p.h(str, "func");
        p.h(str2, "message");
        p.h(str3, "callback");
        Log.d(this.TAG, "invoke: " + str3 + ' ' + str2);
        ((k) this.IBa).cna().a(n.a.lY(str, str2), new a(this, str3));
        ((k) this.IBa).fe(str, str2);
        AppMethodBeat.o(224829);
    }

    @JavascriptInterface
    public final void cgi(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(224830);
        p.h(str, "cgiUrl");
        p.h(str2, "reqProtoBuf");
        p.h(str3, "callback");
        if (!((k) this.IBa).aD(i2, str)) {
            AppMethodBeat.o(224830);
            return;
        }
        Log.i(this.TAG, "do cgi cmdId=" + i2 + ", cgiUrl=" + str);
        try {
            d.a aVar = new d.a();
            Charset forName = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            p.g(forName, "Charset.forName(\"UTF-8\")");
            byte[] bytes = str2.getBytes(forName);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            aVar.c(new jp(Base64.decode(bytes, 2)));
            aVar.d(new jq());
            aVar.MB(str);
            aVar.sG(i2);
            aa.a(aVar.aXF(), new b(this, i2, str3));
            AppMethodBeat.o(224830);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "do cgi", new Object[0]);
            AppMethodBeat.o(224830);
        }
    }

    @JavascriptInterface
    public final void commonCgi(String str, String str2) {
        AppMethodBeat.i(224831);
        p.h(str, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(str2, "callback");
        Log.i(this.TAG, "[TRACE_VIDEO_PRELOAD] jsapi cgi");
        d.a aVar = new d.a();
        aVar.c(new ezy());
        aVar.d(new ezz());
        aVar.MB("/cgi-bin/mmbiz-bin/appmsg/web_comm_prefetch");
        aVar.sG(4924);
        d aXF = aVar.aXF();
        p.g(aXF, "rr");
        com.tencent.mm.bw.a aYJ = aXF.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.WebCommPrefetchReq");
            AppMethodBeat.o(224831);
            throw tVar;
        }
        ((ezy) aYJ).NvW = str;
        aa.a(aXF, new c(this, str2));
        AppMethodBeat.o(224831);
    }

    @JavascriptInterface
    public final void setLocalData(String str, String str2) {
        AppMethodBeat.i(224832);
        p.h(str, "key");
        p.h(str2, "data");
        ((k) this.IBa).setLocalData(str, str2);
        AppMethodBeat.o(224832);
    }

    @JavascriptInterface
    public final String getLocalData(String str) {
        AppMethodBeat.i(224833);
        p.h(str, "key");
        String localData = ((k) this.IBa).getLocalData(str);
        AppMethodBeat.o(224833);
        return localData;
    }

    public static final /* synthetic */ void a(j jVar, String str, String str2) {
        AppMethodBeat.i(224835);
        oe oeVar = new oe();
        oeVar.BaseResponse = new BaseResponse();
        BaseResponse baseResponse = oeVar.BaseResponse;
        dqi dqi = new dqi();
        dqi.bhy(str);
        baseResponse.ErrMsg = dqi;
        oeVar.BaseResponse.Ret = -1;
        byte[] encode = Base64.encode(oeVar.toByteArray(), 2);
        p.g(encode, "Base64.encode(resp.toByteArray(), Base64.NO_WRAP)");
        Charset charset = StandardCharsets.UTF_8;
        p.g(charset, "StandardCharsets.UTF_8");
        c.a.a((k) jVar.IBa, str2, "'" + new String(encode, charset) + '\'', null, 4);
        AppMethodBeat.o(224835);
    }
}
