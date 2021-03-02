package com.tencent.mm.plugin.webview.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class g {
    private final HashMap<Integer, a> IRb = new HashMap<>();
    private final HashMap<Integer, Integer> IRc = new HashMap<>();
    private final String TAG = "MicroMsg.JsApiFrequentHelper";

    public g() {
        AppMethodBeat.i(225106);
        try {
            String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_webview_jsapi_call_limit, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
            JSONArray optJSONArray = new JSONObject(a2).optJSONArray("list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = optJSONArray.get(i2);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type org.json.JSONObject");
                        AppMethodBeat.o(225106);
                        throw tVar;
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    this.IRc.put(Integer.valueOf(jSONObject.optInt("pos")), Integer.valueOf(jSONObject.optInt("limit")));
                }
            }
            Log.i(this.TAG, "size=" + this.IRc.size() + ", config=" + a2);
            AppMethodBeat.o(225106);
        } catch (Throwable th) {
            Log.w(this.TAG, "parse fail: ex=" + th.getMessage());
            AppMethodBeat.o(225106);
        }
    }

    public final boolean afT(int i2) {
        a aVar;
        AppMethodBeat.i(225104);
        if (this.IRc.containsKey(Integer.valueOf(i2))) {
            Integer num = this.IRc.get(Integer.valueOf(i2));
            if (num == null) {
                p.hyc();
            }
            p.g(num, "controlByteMap[controlByte]!!");
            int intValue = num.intValue();
            if (intValue <= 0) {
                AppMethodBeat.o(225104);
                return false;
            }
            a aVar2 = this.IRb.get(Integer.valueOf(i2));
            long currentTimeMillis = System.currentTimeMillis() / Util.MILLSECONDS_OF_MINUTE;
            if (aVar2 == null) {
                aVar = new a(currentTimeMillis);
            } else if (aVar2.time == currentTimeMillis) {
                aVar2.count++;
                aVar = aVar2;
            } else {
                aVar2.time = currentTimeMillis;
                aVar2.count = 1;
                aVar = aVar2;
            }
            this.IRb.put(Integer.valueOf(i2), aVar);
            if (aVar.count >= intValue) {
                AppMethodBeat.o(225104);
                return true;
            }
            Log.i(this.TAG, "isTooFrequent controlByte:" + i2 + ", count:" + aVar.count);
        }
        AppMethodBeat.o(225104);
        return false;
    }

    public final void S(int i2, String str, String str2) {
        AppMethodBeat.i(225105);
        p.h(str, "funcName");
        p.h(str2, "url");
        if (this.IRc.containsKey(Integer.valueOf(i2))) {
            Integer num = this.IRc.get(Integer.valueOf(i2));
            if (num == null) {
                p.hyc();
            }
            p.g(num, "controlByteMap[controlByte]!!");
            int intValue = num.intValue();
            if (intValue <= 0) {
                AppMethodBeat.o(225105);
                return;
            }
            a aVar = this.IRb.get(Integer.valueOf(i2));
            if (aVar != null) {
                if (aVar.count == intValue) {
                    h.INSTANCE.a(18188, str, z.bfG(str2));
                }
                AppMethodBeat.o(225105);
                return;
            }
        }
        AppMethodBeat.o(225105);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "webview-sdk_release"})
    public static final class a {
        int count = 1;
        long time;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.time == aVar.time && this.count == aVar.count)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.time;
            return (((int) (j2 ^ (j2 >>> 32))) * 31) + this.count;
        }

        public final String toString() {
            AppMethodBeat.i(225103);
            String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
            AppMethodBeat.o(225103);
            return str;
        }

        public a(long j2) {
            this.time = j2;
        }
    }
}
