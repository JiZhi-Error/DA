package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiUpdateShareMenuToDo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class t extends d<s> {
    public static final int CTRL_INDEX = 798;
    public static final String NAME = "updateShareMenuToDo";
    public static final a msc = new a((byte) 0);

    static {
        AppMethodBeat.i(183060);
        AppMethodBeat.o(183060);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        String str;
        AppMethodBeat.i(183059);
        s sVar2 = sVar;
        ac currentPageView = sVar2 != null ? sVar2.getCurrentPageView() : null;
        if (currentPageView != null) {
            com.tencent.mm.plugin.appbrand.menu.t yK = currentPageView.yK(u.ShareAppMsg.ordinal());
            if (yK == null) {
                sVar2.i(i2, Zf("fail:menu item do not exist"));
                AppMethodBeat.o(183059);
                return;
            }
            boolean optBoolean = jSONObject != null ? jSONObject.optBoolean("isToDoMessage", false) : false;
            if (jSONObject == null || (str = jSONObject.optString("toDoActivityId", "")) == null) {
                str = "";
            }
            Log.i("MicroMsg.JsApiUpdateShareMenuToDo", "isToDoMessage=" + optBoolean + "  toDoActivityId=" + str);
            yK.getKeyValueSet().l("is_todo_message", Boolean.valueOf(optBoolean));
            yK.getKeyValueSet().l("share_todo_activity_id", str);
            sVar2.i(i2, Zf("ok"));
            AppMethodBeat.o(183059);
        } else if (sVar2 != null) {
            sVar2.i(i2, Zf("fail"));
            AppMethodBeat.o(183059);
        } else {
            AppMethodBeat.o(183059);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiUpdateShareMenuToDo$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
