package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003JB\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_SUBSCRIBE_MSG", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "errMsg", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestSubscribeMessage", "plugin-webview_release"})
public final class s extends a implements MMActivity.a {
    private static final int CDJ = 395;
    private static n JsF = null;
    private static f JxI = null;
    public static final s JxJ = new s();
    private static final String edq = "requestSubscribeMessage";

    static {
        AppMethodBeat.i(210665);
        AppMethodBeat.o(210665);
    }

    private s() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210662);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage");
        JxI = fVar;
        JsF = nVar;
        String str = (String) nVar.params.get("appId");
        String str2 = (String) nVar.params.get(IssueStorage.COLUMN_EXT_INFO);
        String str3 = (String) nVar.params.get("templateIdList");
        ArrayList<String> arrayList = new ArrayList<>();
        if (str3 != null) {
            JSONArray jSONArray = new JSONArray(str3);
            int i2 = 0;
            int length = jSONArray.length();
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Object obj = jSONArray.get(i2);
                if (!(obj instanceof String)) {
                    a(fVar, nVar, ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, ":fail templateId invalid", null);
                    break;
                }
                arrayList.add(obj);
                i2++;
            }
        }
        if (arrayList.isEmpty()) {
            a(fVar, nVar, 10001, ":fail templateIdList empty", null);
            AppMethodBeat.o(210662);
        } else {
            if (fVar.context instanceof MMActivity) {
                Context context = fVar.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(210662);
                    throw tVar;
                }
                ((MMActivity) context).mmSetOnActivityResultCallback(this);
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_extra_info", str2);
            bundle.putBoolean("key_need_result", true);
            bundle.putStringArrayList("key_template_id_list", arrayList);
            ISubscribeMsgService iSubscribeMsgService = (ISubscribeMsgService) g.af(ISubscribeMsgService.class);
            Context context2 = fVar.context;
            if (str == null) {
                str = "";
            }
            iSubscribeMsgService.a(context2, 2, 1000, str, bundle);
            AppMethodBeat.o(210662);
        }
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        AppMethodBeat.i(210663);
        Log.d("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage onActivityResult requestCode: " + i2 + ", resultCode: " + i3 + ", data: " + (intent == null));
        if (intent != null && i2 == 1000) {
            ArrayList<SubscribeMsgTmpItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_result_data");
            int intExtra = intent.getIntExtra("key_result_err_code", -1);
            String stringExtra = intent.getStringExtra("key_result_err_msg");
            if (stringExtra == null) {
                stringExtra = "unknown error";
            }
            String stringExtra2 = intent.getStringExtra("key_result_ext_data");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(intExtra);
            objArr[1] = stringExtra;
            objArr[2] = parcelableArrayListExtra != null ? Integer.valueOf(parcelableArrayListExtra.size()) : null;
            objArr[3] = stringExtra2;
            Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage onActivityResult errCode: %s, errMsg: %s, template size: %s, extData: %s", objArr);
            JSONObject jSONObject = new JSONObject();
            if (parcelableArrayListExtra != null) {
                for (SubscribeMsgTmpItem subscribeMsgTmpItem : parcelableArrayListExtra) {
                    String str = subscribeMsgTmpItem.ixM;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("status", subscribeMsgTmpItem.jyE);
                    jSONObject.put(str, jSONObject2.toString());
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("templatesDetail", jSONObject.toString());
            hashMap.put("ext_info", stringExtra2);
            a(JxI, JsF, intExtra, stringExtra, hashMap);
        }
        AppMethodBeat.o(210663);
    }

    private static void a(f fVar, n nVar, int i2, String str, Map<String, ? extends Object> map) {
        boolean z = true;
        AppMethodBeat.i(210664);
        p.h(str, "errMsg");
        if (fVar == null) {
            AppMethodBeat.o(210664);
        } else if (nVar == null) {
            AppMethodBeat.o(210664);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("err_code", Integer.valueOf(i2));
            if (map != null) {
                linkedHashMap.putAll(map);
            }
            if (i2 == 0) {
                if (str.length() <= 0) {
                    z = false;
                }
                if (!z) {
                    str = "ok";
                }
            } else {
                if (!(str.length() > 0)) {
                    str = "unknown error";
                }
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":" + str, linkedHashMap);
            AppMethodBeat.o(210664);
        }
    }
}
