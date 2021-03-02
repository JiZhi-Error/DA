package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiChoosePOI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "REQUEST_CODE_CHOOSE_POI", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<s> {
    public static final int CTRL_INDEX = 938;
    public static final String NAME = "choosePoi";
    public static final a lWY = new a((byte) 0);
    private final int lWX = com.tencent.luggage.sdk.g.a.aK(com.tencent.luggage.sdk.g.a.cCG);

    static {
        AppMethodBeat.i(228422);
        AppMethodBeat.o(228422);
    }

    public d() {
        AppMethodBeat.i(228421);
        AppMethodBeat.o(228421);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228420);
        s sVar2 = sVar;
        if (sVar2 != null) {
            Activity btb = sVar2.btb();
            p.g(btb, "env.getPageContext()");
            if (btb == null) {
                sVar2.i(i2, Zf("fail:internal error invalid android context"));
                Log.e("MicroMsg.JsApiChoosePOI", "mmActivity is null, invoke fail!");
                AppMethodBeat.o(228420);
                return;
            }
            f.aK(btb).b(new b(this, sVar2, i2));
            c.b(btb, "nearlife", ".ui.CheckInLifeUI", new Intent(), this.lWX);
        }
        AppMethodBeat.o(228420);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiChoosePOI$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class b implements f.c {
        final /* synthetic */ d lWZ;
        final /* synthetic */ s lXa;
        final /* synthetic */ int lyo;

        b(d dVar, s sVar, int i2) {
            this.lWZ = dVar;
            this.lXa = sVar;
            this.lyo = i2;
        }

        @Override // com.tencent.luggage.h.f.c
        public final boolean c(int i2, int i3, Intent intent) {
            AppMethodBeat.i(228419);
            if (i2 != this.lWZ.lWX) {
                AppMethodBeat.o(228419);
                return false;
            }
            switch (i3) {
                case -1:
                    if (intent != null) {
                        HashMap hashMap = new HashMap();
                        int intExtra = intent.getIntExtra("get_poi_data_type", 0);
                        hashMap.put("type", Integer.valueOf(intExtra));
                        switch (intExtra) {
                            case 1:
                                String stringExtra = intent.getStringExtra("get_city");
                                p.g(stringExtra, "data.getStringExtra(Cons…tsUI.NearLifeUI.GET_CITY)");
                                hashMap.put("city", stringExtra);
                                break;
                            case 2:
                                String stringExtra2 = intent.getStringExtra("get_poi_name");
                                p.g(stringExtra2, "data.getStringExtra(Cons….NearLifeUI.GET_POI_NAME)");
                                hashMap.put("name", stringExtra2);
                                String stringExtra3 = intent.getStringExtra("get_poi_address");
                                p.g(stringExtra3, "data.getStringExtra(Cons…arLifeUI.GET_POI_ADDRESS)");
                                hashMap.put("address", stringExtra3);
                                hashMap.put("latitude", Float.valueOf(intent.getFloatExtra("get_lat", -1.0f)));
                                hashMap.put("longitude", Float.valueOf(intent.getFloatExtra("get_lng", -1.0f)));
                                break;
                        }
                        this.lXa.i(this.lyo, this.lWZ.n("ok", hashMap));
                        break;
                    } else {
                        this.lXa.i(this.lyo, this.lWZ.Zf("fail:internal error"));
                        AppMethodBeat.o(228419);
                        return true;
                    }
                case 0:
                    this.lXa.i(this.lyo, this.lWZ.Zf("fail cancel"));
                    Log.i("MicroMsg.JsApiChoosePOI", "choose canceled");
                    break;
                default:
                    this.lXa.i(this.lyo, this.lWZ.Zf("fail"));
                    Log.e("MicroMsg.JsApiChoosePOI", "choose failed");
                    break;
            }
            AppMethodBeat.o(228419);
            return true;
        }
    }
}
