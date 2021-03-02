package com.tencent.mm.plugin.lite.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends com.tencent.liteapp.jsapi.a implements com.tencent.mm.ipcinvoker.b<Bundle, IPCCallbackData> {
    private com.tencent.liteapp.jsapi.b yEm = null;
    public a yEn = null;
    private Map<String, Integer> yEo = new HashMap<String, Integer>() {
        /* class com.tencent.mm.plugin.lite.jsapi.b.AnonymousClass1 */

        {
            AppMethodBeat.i(198829);
            put("none", 0);
            put("slide_right_in", Integer.valueOf((int) R.anim.eq));
            put("alpha_in", Integer.valueOf((int) R.anim.n));
            put("pop_in", Integer.valueOf((int) R.anim.dd));
            put("slide_left_in", Integer.valueOf((int) R.anim.em));
            put("fast_faded_in", Integer.valueOf((int) R.anim.br));
            put("push_down_in", Integer.valueOf((int) R.anim.dn));
            put("push_up_in", Integer.valueOf((int) R.anim.dq));
            put("slide_bottom_in", Integer.valueOf((int) R.anim.el));
            put("slide_pop_in", Integer.valueOf((int) R.anim.eo));
            put("slide_right_in", Integer.valueOf((int) R.anim.eq));
            put("toast_fade_in", Integer.valueOf((int) R.anim.f9));
            put("fast_alot_faded_in", Integer.valueOf((int) R.anim.bn));
            put("pop_left_bottom_in", Integer.valueOf((int) R.anim.de));
            put("pop_left_top_in", Integer.valueOf((int) R.anim.dg));
            put("pop_right_bottom_in", Integer.valueOf((int) R.anim.dj));
            put("pop_right_top_in", Integer.valueOf((int) R.anim.dl));
            put("sight_slide_bottom_in", Integer.valueOf((int) R.anim.ei));
            AppMethodBeat.o(198829);
        }
    };
    private Map<String, Integer> yEp = new HashMap<String, Integer>() {
        /* class com.tencent.mm.plugin.lite.jsapi.b.AnonymousClass2 */

        {
            AppMethodBeat.i(198830);
            put("none", 0);
            put("slide_right_out", Integer.valueOf((int) R.anim.er));
            put("alpha_out", Integer.valueOf((int) R.anim.o));
            put("faded_out", Integer.valueOf((int) R.anim.bi));
            put("pop_out", Integer.valueOf((int) R.anim.di));
            put("slide_left_out", Integer.valueOf((int) R.anim.en));
            put("fast_faded_out", Integer.valueOf((int) R.anim.bs));
            put("push_down_out", Integer.valueOf((int) R.anim.f6do));
            put("push_up_out", Integer.valueOf((int) R.anim.dr));
            put("push_empty_out", Integer.valueOf((int) R.anim.dp));
            put("slide_pop_out", Integer.valueOf((int) R.anim.ep));
            put("slide_right_out", Integer.valueOf((int) R.anim.er));
            put("slide_top_out", Integer.valueOf((int) R.anim.et));
            put("toast_fade_out", Integer.valueOf((int) R.anim.f_));
            put("fast_alot_faded_out", Integer.valueOf((int) R.anim.bo));
            put("pop_left_bottom_out", Integer.valueOf((int) R.anim.df));
            put("pop_left_top_out", Integer.valueOf((int) R.anim.dh));
            put("pop_right_bottom_out", Integer.valueOf((int) R.anim.dk));
            put("pop_right_top_out", Integer.valueOf((int) R.anim.dm));
            put("sight_slide_bottom_out", Integer.valueOf((int) R.anim.ej));
            AppMethodBeat.o(198830);
        }
    };

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<IPCCallbackData> dVar) {
        Bundle bundle2 = bundle;
        this.yEn = new a();
        this.yEn.yEr = dVar;
        try {
            a(bundle2.getString("appId"), new JSONObject(bundle2.getString("data")));
        } catch (JSONException e2) {
            Log.printErrStackTrace("LiteAppJsApi", e2, "", new Object[0]);
        }
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(com.tencent.liteapp.jsapi.b bVar) {
        this.yEm = bVar;
    }

    public static class a {
        public com.tencent.liteapp.jsapi.b yEm;
        public d<IPCCallbackData> yEr = null;

        public final void aCS(String str) {
            AppMethodBeat.i(198832);
            if (this.yEm != null) {
                this.yEm.h(str, false);
                AppMethodBeat.o(198832);
                return;
            }
            IPCCallbackData iPCCallbackData = new IPCCallbackData();
            iPCCallbackData.cqT = false;
            iPCCallbackData.yEe = false;
            iPCCallbackData.cqU = str;
            this.yEr.bn(iPCCallbackData);
            AppMethodBeat.o(198832);
        }

        public final void ecz() {
            AppMethodBeat.i(198833);
            aW(new JSONObject());
            AppMethodBeat.o(198833);
        }

        public final void aq(Map<String, Object> map) {
            AppMethodBeat.i(198834);
            aW(new JSONObject(map));
            AppMethodBeat.o(198834);
        }

        public final void aW(JSONObject jSONObject) {
            AppMethodBeat.i(198835);
            if (this.yEm != null) {
                this.yEm.a(jSONObject, false);
                AppMethodBeat.o(198835);
                return;
            }
            IPCCallbackData iPCCallbackData = new IPCCallbackData();
            iPCCallbackData.cqT = true;
            iPCCallbackData.yEe = false;
            if (jSONObject != null) {
                iPCCallbackData.cqV = jSONObject.toString();
            }
            this.yEr.bn(iPCCallbackData);
            AppMethodBeat.o(198835);
        }
    }

    public int dTw() {
        return 0;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void b(String str, JSONObject jSONObject) {
        if (dTw() == 0) {
            this.yEn = new a();
            this.yEn.yEm = this.yEm;
            a(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("data", jSONObject.toString());
        bundle.putString("appId", str);
        h.a(MMApplicationContext.getPackageName(), bundle, getClass(), new d<IPCCallbackData>() {
            /* class com.tencent.mm.plugin.lite.jsapi.b.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCCallbackData iPCCallbackData) {
                AppMethodBeat.i(198831);
                IPCCallbackData iPCCallbackData2 = iPCCallbackData;
                if (iPCCallbackData2.cqT) {
                    b.this.yEm.a(iPCCallbackData2.ecy(), iPCCallbackData2.yEe);
                    AppMethodBeat.o(198831);
                    return;
                }
                b.this.yEm.h(iPCCallbackData2.cqU, iPCCallbackData2.yEe);
                AppMethodBeat.o(198831);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final int aU(JSONObject jSONObject) {
        if (!jSONObject.has("nextAnimIn")) {
            return R.anim.eq;
        }
        String string = jSONObject.getString("nextAnimIn");
        if (this.yEo.containsKey(string)) {
            return this.yEo.get(string).intValue();
        }
        return R.anim.eq;
    }

    /* access modifiers changed from: protected */
    public final int aV(JSONObject jSONObject) {
        if (!jSONObject.has("currentAnimOut")) {
            return R.anim.en;
        }
        String string = jSONObject.getString("currentAnimOut");
        if (this.yEo.containsKey(string)) {
            return this.yEp.get(string).intValue();
        }
        return R.anim.en;
    }
}
