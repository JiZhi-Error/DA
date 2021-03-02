package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.util.CompatProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor;
import com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.SubscribeMsgExecutor;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "SubscribeMsgTask", "luggage-wechat-full-sdk_release"})
public final class JsApiRequestSubscribeMessage extends d<com.tencent.luggage.sdk.b.a.c.d> {
    public static final int CTRL_INDEX = 640;
    public static final String NAME = "requestSubscribeMessage";
    public static final a mfH = new a((byte) 0);

    static {
        AppMethodBeat.i(50620);
        AppMethodBeat.o(50620);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.luggage.sdk.b.a.c.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50619);
        com.tencent.luggage.sdk.b.a.c.d dVar2 = dVar;
        Log.i("JsApiRequestSubscribeMessage", "JsApiRequestSubscribeMessage invoked");
        if (jSONObject == null) {
            if (dVar2 == null) {
                p.hyc();
            }
            dVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(50619);
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("tmplIds");
        ArrayList arrayList = new ArrayList();
        if (jSONArray.length() == 0) {
            if (dVar2 == null) {
                p.hyc();
            }
            a.a(dVar2, this, i2, "fail:TmplIds can't be empty", 10001);
            AppMethodBeat.o(50619);
            return;
        }
        try {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = jSONArray.get(i3);
                if (!(obj instanceof String)) {
                    if (dVar2 == null) {
                        p.hyc();
                    }
                    a.a(dVar2, this, i2, "fail:Invalid template id", ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL);
                    AppMethodBeat.o(50619);
                    return;
                }
                arrayList.add(obj);
            }
            if (dVar2 == null) {
                p.hyc();
            }
            com.tencent.luggage.sdk.d.d NP = dVar2.NP();
            p.g(NP, "env!!.runtime");
            String str = NP.ON().username;
            p.g(str, "env!!.runtime.initConfig.username");
            com.tencent.luggage.sdk.d.d NP2 = dVar2.NP();
            p.g(NP2, "env!!.runtime");
            String str2 = NP2.ON().appId;
            p.g(str2, "env!!.runtime.initConfig.appId");
            com.tencent.luggage.sdk.d.d NP3 = dVar2.NP();
            p.g(NP3, "env!!.runtime");
            new SubscribeMsgTask(str, str2, NP3.ON().cyo, arrayList, this, dVar2, i2).bjm();
            AppMethodBeat.o(50619);
        } catch (JSONException e2) {
            if (dVar2 == null) {
                p.hyc();
            }
            dVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(50619);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DBM\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014J2\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000202\u0018\u0001012\b\b\u0002\u00103\u001a\u00020\u0007H\u0002J\u0016\u00104\u001a\u0002052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u0007H\u0016J*\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010>\u001a\u00020.2\b\u0010?\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010@\u001a\u00020.H\u0016J\b\u0010A\u001a\u00020.H\u0016J\u0018\u0010B\u001a\u00020.2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u0007H\u0016R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", ch.COL_USERNAME, "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"})
    static final class SubscribeMsgTask extends CompatProcessTask implements b.c {
        public static final Parcelable.Creator<SubscribeMsgTask> CREATOR = new b();
        public static final a mfP = new a((byte) 0);
        SubscribeMsgRequestResult mfI;
        private com.tencent.luggage.sdk.b.a.c.d mfJ;
        private Integer mfK;
        private JsApiRequestSubscribeMessage mfL;
        private GetSubscribeMsgListExecutor mfM;
        SubscribeMsgExecutor mfN;
        private boolean mfO;
        private int type;
        private String username;

        private SubscribeMsgTask(String str, int i2) {
            p.h(str, ch.COL_USERNAME);
            AppMethodBeat.i(50614);
            this.username = str;
            this.type = i2;
            this.mfO = true;
            AppMethodBeat.o(50614);
        }

        public static final /* synthetic */ void a(SubscribeMsgTask subscribeMsgTask, String str, Map map) {
            AppMethodBeat.i(50618);
            subscribeMsgTask.a(str, map, 0);
            AppMethodBeat.o(50618);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public SubscribeMsgTask(String str, String str2, int i2, List<String> list, JsApiRequestSubscribeMessage jsApiRequestSubscribeMessage, com.tencent.luggage.sdk.b.a.c.d dVar, int i3) {
            this(str, 0);
            p.h(str, ch.COL_USERNAME);
            p.h(str2, "appid");
            p.h(list, "tmplIds");
            p.h(jsApiRequestSubscribeMessage, "jsapi");
            p.h(dVar, "service");
            AppMethodBeat.i(50615);
            this.mfL = jsApiRequestSubscribeMessage;
            this.mfJ = dVar;
            this.mfK = Integer.valueOf(i3);
            a aVar = a.mfw;
            a.dB(str, str2);
            GetSubscribeMsgListExecutor getSubscribeMsgListExecutor = new GetSubscribeMsgListExecutor(str, list, bHB(), str2, i2);
            a aVar2 = a.mfw;
            p.h(aVar2, "<set-?>");
            getSubscribeMsgListExecutor.mfx = aVar2;
            this.mfM = getSubscribeMsgListExecutor;
            SubscribeMsgExecutor subscribeMsgExecutor = new SubscribeMsgExecutor(str, bHA());
            a aVar3 = a.mfw;
            p.h(aVar3, "<set-?>");
            subscribeMsgExecutor.mfx = aVar3;
            this.mfN = subscribeMsgExecutor;
            AppMethodBeat.o(50615);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"})
        public static final class d implements SubscribeMsgExecutor.c {
            final /* synthetic */ SubscribeMsgTask mfQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(SubscribeMsgTask subscribeMsgTask) {
                this.mfQ = subscribeMsgTask;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.SubscribeMsgExecutor.c
            public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                AppMethodBeat.i(50604);
                p.h(str, "errMsg");
                this.mfQ.a(i2, i3, str, subscribeMsgRequestResult);
                AppMethodBeat.o(50604);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.SubscribeMsgExecutor.c
            public final void c(SubscribeMsgRequestResult subscribeMsgRequestResult) {
                AppMethodBeat.i(50603);
                p.h(subscribeMsgRequestResult, "result");
                if (subscribeMsgRequestResult.jyw) {
                    SubscribeMsgTask.a(this.mfQ, "cancel", 0, 6);
                    AppMethodBeat.o(50603);
                    return;
                }
                HashMap hashMap = new HashMap();
                for (T t : subscribeMsgRequestResult.jyk) {
                    hashMap.put(t.ixM, t.jyE);
                }
                SubscribeMsgTask.a(this.mfQ, "ok", hashMap);
                AppMethodBeat.o(50603);
            }
        }

        private final SubscribeMsgExecutor.c bHA() {
            AppMethodBeat.i(50605);
            d dVar = new d(this);
            AppMethodBeat.o(50605);
            return dVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", ch.COL_USERNAME, "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
        public static final class c implements GetSubscribeMsgListExecutor.c {
            final /* synthetic */ SubscribeMsgTask mfQ;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(SubscribeMsgTask subscribeMsgTask) {
                this.mfQ = subscribeMsgTask;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor.c
            public final void b(k kVar) {
                com.tencent.luggage.sdk.d.d NP;
                m brn;
                com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid;
                k kVar2;
                AppMethodBeat.i(50600);
                p.h(kVar, "dialog");
                com.tencent.luggage.sdk.b.a.c.d dVar = this.mfQ.mfJ;
                if (!(dVar == null || (windowAndroid = dVar.getWindowAndroid()) == null || !windowAndroid.bsj())) {
                    if (!(kVar instanceof com.tencent.mm.msgsubscription.ui.b)) {
                        kVar2 = null;
                    } else {
                        kVar2 = kVar;
                    }
                    com.tencent.mm.msgsubscription.ui.b bVar = (com.tencent.mm.msgsubscription.ui.b) kVar2;
                    if (bVar != null) {
                        bVar.setPosition(1);
                    }
                }
                com.tencent.luggage.sdk.b.a.c.d dVar2 = this.mfQ.mfJ;
                if (dVar2 == null || (NP = dVar2.NP()) == null || (brn = NP.brn()) == null) {
                    AppMethodBeat.o(50600);
                    return;
                }
                brn.b(kVar);
                AppMethodBeat.o(50600);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor.c
            public final void a(String str, List<SubscribeMsgTmpItem> list, SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData) {
                byte[] bArr;
                AppMethodBeat.i(50601);
                p.h(str, ch.COL_USERNAME);
                p.h(list, "items");
                SubscribeMsgExecutor subscribeMsgExecutor = this.mfQ.mfN;
                if (subscribeMsgExecutor != null) {
                    List v = j.v((Collection) list);
                    p.h(v, "value");
                    subscribeMsgExecutor.mfT.clear();
                    subscribeMsgExecutor.mfT.addAll(v);
                }
                SubscribeMsgExecutor subscribeMsgExecutor2 = this.mfQ.mfN;
                if (subscribeMsgExecutor2 != null) {
                    SubscribeMsgRequestResult subscribeMsgRequestResult = this.mfQ.mfI;
                    if (subscribeMsgRequestResult != null) {
                        bArr = subscribeMsgRequestResult.buffer;
                    } else {
                        bArr = null;
                    }
                    subscribeMsgExecutor2.mfS = bArr;
                }
                SubscribeMsgExecutor subscribeMsgExecutor3 = this.mfQ.mfN;
                if (subscribeMsgExecutor3 != null) {
                    subscribeMsgExecutor3.jzq = subscribeMsgRequestDialogUiData;
                }
                this.mfQ.type = 1;
                this.mfQ.bjm();
                AppMethodBeat.o(50601);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor.c
            public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                AppMethodBeat.i(50602);
                p.h(str, "errMsg");
                this.mfQ.a(i2, i3, str, subscribeMsgRequestResult);
                AppMethodBeat.o(50602);
            }
        }

        private final GetSubscribeMsgListExecutor.c bHB() {
            AppMethodBeat.i(50606);
            c cVar = new c(this);
            AppMethodBeat.o(50606);
            return cVar;
        }

        static /* synthetic */ void a(SubscribeMsgTask subscribeMsgTask, String str, int i2, int i3) {
            AppMethodBeat.i(50608);
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            subscribeMsgTask.a(str, (Map<String, ? extends Object>) null, i2);
            AppMethodBeat.o(50608);
        }

        private final void a(String str, Map<String, ? extends Object> map, int i2) {
            AppMethodBeat.i(50607);
            a aVar = JsApiRequestSubscribeMessage.mfH;
            com.tencent.luggage.sdk.b.a.c.d dVar = this.mfJ;
            if (dVar == null) {
                p.hyc();
            }
            JsApiRequestSubscribeMessage jsApiRequestSubscribeMessage = this.mfL;
            if (jsApiRequestSubscribeMessage == null) {
                p.hyc();
            }
            Integer num = this.mfK;
            if (num == null) {
                p.hyc();
            }
            a.a(dVar, jsApiRequestSubscribeMessage, num.intValue(), str, map, i2);
            AppMethodBeat.o(50607);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SubscribeMsgTask(android.os.Parcel r4) {
            /*
            // Method dump skipped, instructions count: 107
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage.SubscribeMsgTask.<init>(android.os.Parcel):void");
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(50609);
            p.h(str, "errMsg");
            Log.i("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " result" + subscribeMsgRequestResult);
            this.mfO = i2 == 0 && i3 == 0;
            this.mfI = subscribeMsgRequestResult;
            h.RTc.b(new CompatProcessTask.a(this), "CompatProcessTask_" + bjl());
            AppMethodBeat.o(50609);
        }

        @Override // com.tencent.mm.msgsubscription.util.CompatProcessTask
        public final void bjj() {
            AppMethodBeat.i(50610);
            if (this.type == 0) {
                GetSubscribeMsgListExecutor getSubscribeMsgListExecutor = this.mfM;
                if (getSubscribeMsgListExecutor != null) {
                    b.a.C0462a aVar = b.a.jzu;
                    String str = getSubscribeMsgListExecutor.username;
                    List<String> list = getSubscribeMsgListExecutor.mfA;
                    p.h(str, ch.COL_USERNAME);
                    p.h(list, "templateIds");
                    com.tencent.mm.msgsubscription.a.b bVar = new com.tencent.mm.msgsubscription.a.b(str, 2);
                    bVar.jzo = getSubscribeMsgListExecutor;
                    for (String str2 : list) {
                        List list2 = bVar.jzm;
                        efc efc = new efc();
                        efc.Mqy = str2;
                        list2.add(efc);
                    }
                    bVar.a(getSubscribeMsgListExecutor.mfx);
                    AppMethodBeat.o(50610);
                    return;
                }
                AppMethodBeat.o(50610);
                return;
            }
            SubscribeMsgExecutor subscribeMsgExecutor = this.mfN;
            if (subscribeMsgExecutor != null) {
                boolean z = subscribeMsgExecutor.jzq != null;
                if (!aa.SXc || z) {
                    b.a.C0462a aVar2 = b.a.jzu;
                    String str3 = subscribeMsgExecutor.username;
                    List<SubscribeMsgTmpItem> list3 = subscribeMsgExecutor.mfT;
                    SubscribeMsgExecutor subscribeMsgExecutor2 = subscribeMsgExecutor;
                    byte[] bArr = subscribeMsgExecutor.mfS;
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData = subscribeMsgExecutor.jzq;
                    p.h(str3, ch.COL_USERNAME);
                    p.h(list3, "templates");
                    p.h(bArr, "byteArray");
                    b.a.C0462a.a(str3, "", list3, "", subscribeMsgExecutor2, true, bArr, subscribeMsgRequestDialogUiData).a(subscribeMsgExecutor.mfx);
                    AppMethodBeat.o(50610);
                    return;
                }
                AssertionError assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.o(50610);
                throw assertionError;
            }
            AppMethodBeat.o(50610);
        }

        @Override // com.tencent.mm.msgsubscription.util.CompatProcessTask
        public final void bjk() {
            int i2 = 50611;
            AppMethodBeat.i(i2);
            try {
                if (this.mfO && this.mfI != null) {
                    if (this.type == 0) {
                        SubscribeMsgRequestResult subscribeMsgRequestResult = this.mfI;
                        if (subscribeMsgRequestResult == null) {
                            p.hyc();
                        }
                        if (subscribeMsgRequestResult.jyu != 0) {
                            StringBuilder sb = new StringBuilder("fail:");
                            SubscribeMsgRequestResult subscribeMsgRequestResult2 = this.mfI;
                            if (subscribeMsgRequestResult2 == null) {
                                p.hyc();
                            }
                            String sb2 = sb.append(subscribeMsgRequestResult2.jyv).toString();
                            SubscribeMsgRequestResult subscribeMsgRequestResult3 = this.mfI;
                            if (subscribeMsgRequestResult3 == null) {
                                p.hyc();
                            }
                            a(this, sb2, subscribeMsgRequestResult3.jyu, 2);
                            AppMethodBeat.o(i2);
                            return;
                        }
                    }
                    if (this.type == 0) {
                        GetSubscribeMsgListExecutor getSubscribeMsgListExecutor = this.mfM;
                        if (getSubscribeMsgListExecutor != null) {
                            com.tencent.luggage.sdk.b.a.c.d dVar = this.mfJ;
                            if (dVar == null) {
                                p.hyc();
                            }
                            Context context = dVar.getContext();
                            p.g(context, "service!!.context");
                            SubscribeMsgRequestResult subscribeMsgRequestResult4 = this.mfI;
                            if (subscribeMsgRequestResult4 == null) {
                                p.hyc();
                            }
                            getSubscribeMsgListExecutor.a(context, subscribeMsgRequestResult4);
                            AppMethodBeat.o(50611);
                            return;
                        }
                        AppMethodBeat.o(50611);
                        return;
                    }
                    SubscribeMsgExecutor subscribeMsgExecutor = this.mfN;
                    if (subscribeMsgExecutor != null) {
                        com.tencent.luggage.sdk.b.a.c.d dVar2 = this.mfJ;
                        if (dVar2 == null) {
                            p.hyc();
                        }
                        Context context2 = dVar2.getContext();
                        p.g(context2, "service!!.context");
                        SubscribeMsgRequestResult subscribeMsgRequestResult5 = this.mfI;
                        if (subscribeMsgRequestResult5 == null) {
                            p.hyc();
                        }
                        p.h(context2, "context");
                        p.h(subscribeMsgRequestResult5, "result");
                        SubscribeMsgExecutor.c cVar = subscribeMsgExecutor.mfR;
                        if (cVar != null) {
                            cVar.c(subscribeMsgRequestResult5);
                            AppMethodBeat.o(50611);
                            return;
                        }
                        AppMethodBeat.o(50611);
                        return;
                    }
                    AppMethodBeat.o(i2);
                } else if (this.type == 0) {
                    a(this, "fail:Request list fail", 10002, 2);
                    i2 = 50611;
                } else {
                    a(this, "fail:Request subscribe fail", (int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, 2);
                    AppMethodBeat.o(i2);
                }
            } finally {
                AppMethodBeat.o(i2);
            }
        }

        @Override // com.tencent.mm.msgsubscription.util.CompatProcessTask
        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(50612);
            p.h(parcel, "parcel");
            parcel.writeString(this.username);
            parcel.writeInt(this.type);
            parcel.writeParcelable(this.mfI, i2);
            parcel.writeParcelable(this.mfM, i2);
            parcel.writeParcelable(this.mfN, i2);
            parcel.writeInt(this.mfO ? 1 : 0);
            AppMethodBeat.o(50612);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$Companion;", "", "()V", "ACTION_SUBSCRIBE", "", "ACTION_USER_ACTION", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "luggage-wechat-full-sdk_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "luggage-wechat-full-sdk_release"})
        public static final class b implements Parcelable.Creator<SubscribeMsgTask> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SubscribeMsgTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(50599);
                p.h(parcel, "parcel");
                SubscribeMsgTask subscribeMsgTask = new SubscribeMsgTask(parcel);
                AppMethodBeat.o(50599);
                return subscribeMsgTask;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SubscribeMsgTask[] newArray(int i2) {
                return new SubscribeMsgTask[i2];
            }
        }

        static {
            AppMethodBeat.i(50617);
            AppMethodBeat.o(50617);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$Companion;", "", "()V", "CTRL_INDEX", "", "ErrorCode_InvalidTemplateID", "ErrorCode_ListRequestFail", "ErrorCode_OK", "ErrorCode_SubscribeInvalidTemplateId", "ErrorCode_SubscribeRequestFail", "ErrorMsg_InvalidTemplateID", "", "ErrorMsg_ListRequestFail", "ErrorMsg_SubscribeInvalidTemplateId", "ErrorMsg_SubscribeRequestFail", "NAME", "TAG", "callbackJsApi", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "callbackId", "status", "retMap", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ void a(com.tencent.luggage.sdk.b.a.c.d dVar, JsApiRequestSubscribeMessage jsApiRequestSubscribeMessage, int i2, String str, int i3) {
            AppMethodBeat.i(160629);
            a(dVar, jsApiRequestSubscribeMessage, i2, str, null, i3);
            AppMethodBeat.o(160629);
        }

        public static void a(com.tencent.luggage.sdk.b.a.c.d dVar, JsApiRequestSubscribeMessage jsApiRequestSubscribeMessage, int i2, String str, Map<String, ? extends Object> map, int i3) {
            AppMethodBeat.i(50598);
            p.h(dVar, "service");
            p.h(jsApiRequestSubscribeMessage, "jsapi");
            p.h(str, "status");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!(i3 == -1 || i3 == 0)) {
                linkedHashMap.put("errCode", Integer.valueOf(i3));
            }
            if (map != null) {
                linkedHashMap.putAll(map);
            }
            String n = jsApiRequestSubscribeMessage.n(str, linkedHashMap);
            Log.i("JsApiRequestSubscribeMessage", "[callbackJsApi] return json:".concat(String.valueOf(n)));
            dVar.i(i2, n);
            AppMethodBeat.o(50598);
        }
    }
}
