package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.protocal.protobuf.fao;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J,\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J4\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0004H\u0002J\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/webview/fts/ChatSearchLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "THREAD_TAG", "mJSCallback", "Lcom/tencent/mm/plugin/webview/fts/PreGetController$JSCallback;", "getCgiAction", "content", "getChatSearchData", "", NativeProtocol.WEB_DIALOG_PARAMS, "", "", "getSessionId", "url", "onDataBack", "", "tag", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportAction", NativeProtocol.WEB_DIALOG_ACTION, "sessionId", "cgiRet", "cgiAction", "start", "stop", "plugin-webview_release"})
public final class a implements i {
    public static final h.a INN = b.INQ;
    public static final a INO = new a();
    public static final String TAG = TAG;
    private static final String kWD = kWD;

    static {
        AppMethodBeat.i(210305);
        AppMethodBeat.o(210305);
    }

    private a() {
    }

    public static final /* synthetic */ String aXX(String str) {
        AppMethodBeat.i(210306);
        String aXW = aXW(str);
        AppMethodBeat.o(210306);
        return aXW;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.webview.fts.a$a  reason: collision with other inner class name */
    public static final class RunnableC1952a implements Runnable {
        final /* synthetic */ v INP;

        public RunnableC1952a(v vVar) {
            this.INP = vVar;
        }

        public final void run() {
            AppMethodBeat.i(210296);
            g.azz().b(new aa(this.INP));
            a aVar = a.INO;
            String str = this.INP.IDZ;
            p.g(str, "model.imageSearchSessionId");
            int i2 = this.INP.scene;
            a aVar2 = a.INO;
            a.L(str, i2, a.aXX(this.INP.content));
            AppMethodBeat.o(210296);
        }
    }

    public static String avA(String str) {
        AppMethodBeat.i(210299);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(210299);
            return "";
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("sessionId");
            if (queryParameter == null) {
                queryParameter = "";
            }
            AppMethodBeat.o(210299);
            return queryParameter;
        } catch (Exception e2) {
            AppMethodBeat.o(210299);
            return "";
        }
    }

    private static String aXW(String str) {
        AppMethodBeat.i(210300);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(210300);
            return "";
        }
        try {
            String optString = new JSONObject(str).optString(NativeProtocol.WEB_DIALOG_ACTION);
            if (optString == null) {
                optString = "";
            }
            AppMethodBeat.o(210300);
            return optString;
        } catch (Exception e2) {
            AppMethodBeat.o(210300);
            return "";
        }
    }

    static /* synthetic */ void L(String str, int i2, String str2) {
        AppMethodBeat.i(210302);
        b(6, str, i2, 0, str2);
        AppMethodBeat.o(210302);
    }

    private static void b(int i2, String str, int i3, int i4, String str2) {
        AppMethodBeat.i(210301);
        ab abVar = new ab();
        abVar.jK(i2);
        abVar.jM(i3);
        abVar.ig("");
        abVar.ih("");
        abVar.jN(0);
        abVar.ie(str);
        abVar.bW(System.currentTimeMillis());
        abVar.jO(i4);
        abVar.ij(str2);
        abVar.bfK();
        ar.a(abVar);
        AppMethodBeat.o(210301);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(210303);
        if (qVar instanceof aa) {
            if (!TextUtils.isEmpty(((aa) qVar).fXN().content)) {
                String str3 = ((aa) qVar).fXN().content;
                p.g(str3, "scene.model.content");
                str2 = str3;
            } else {
                String str4 = ((aa) qVar).fXN().dPI;
                p.g(str4, "scene.model.requestId");
                str2 = str4;
            }
            fao fXS = ((aa) qVar).fXS();
            v fXN = ((aa) qVar).fXN();
            if (!(fXS == null || fXN == null)) {
                String str5 = fXN.IDZ;
                if (!(str5 == null || str5.length() == 0)) {
                    String str6 = fXN.IDZ;
                    p.g(str6, "model.imageSearchSessionId");
                    b(7, str6, fXN.scene, i3, aXW(fXN.content));
                }
                if (i2 == 0 && i3 == 0) {
                    String str7 = TAG;
                    StringBuilder append = new StringBuilder("net scene success requestId:").append(((aa) qVar).fXN().dPI).append(" reqKey:").append(((aa) qVar).fXN().dDL).append(" jsonStr:");
                    String str8 = fXS.KRB;
                    Log.i(str7, append.append(str8 != null ? Integer.valueOf(str8.length()) : null).toString());
                    String str9 = fXS.KRB;
                    p.g(str9, "response.json_str");
                    lR(str9, str2);
                } else {
                    Log.i(TAG, "net scene fail requestId:" + ((aa) qVar).fXN().dPI + " reqKey:" + ((aa) qVar).fXN().dDL);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ret", -1);
                    } catch (Exception e2) {
                    }
                    String jSONObject2 = jSONObject.toString();
                    p.g(jSONObject2, "resultObject.toString()");
                    lR(jSONObject2, str2);
                    AppMethodBeat.o(210303);
                    return;
                }
            }
        }
        AppMethodBeat.o(210303);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/webview/fts/PreGetController$ReqStatus;", "kotlin.jvm.PlatformType", "handleCallback"})
    static final class b implements h.a {
        public static final b INQ = new b();

        static {
            AppMethodBeat.i(210298);
            AppMethodBeat.o(210298);
        }

        b() {
        }

        @Override // com.tencent.mm.plugin.webview.fts.h.a
        public final void a(h.b bVar) {
            AppMethodBeat.i(210297);
            if ((bVar.IOM instanceof v) && (bVar.ION instanceof String)) {
                Object obj = bVar.IOM;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.websearch.api.NetSceneRequestModel");
                    AppMethodBeat.o(210297);
                    throw tVar;
                }
                v vVar = (v) obj;
                f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(vVar.dVL);
                Object obj2 = bVar.ION;
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210297);
                    throw tVar2;
                }
                ahd.mg((String) obj2, vVar.dPI);
            }
            AppMethodBeat.o(210297);
        }
    }

    private static void lR(String str, String str2) {
        AppMethodBeat.i(210304);
        j gdt = com.tencent.mm.plugin.webview.modeltools.g.gdt();
        p.g(gdt, "SubCoreTools.getFTSWebSearchLogic()");
        gdt.gaB().a(0, str2, str, INN);
        AppMethodBeat.o(210304);
    }
}
