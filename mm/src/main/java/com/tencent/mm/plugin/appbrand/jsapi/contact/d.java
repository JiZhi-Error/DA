package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<f> {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";
    @Deprecated
    public static final a lRZ = new a((byte) 0);

    static {
        AppMethodBeat.i(138160);
        AppMethodBeat.o(138160);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-default-impl_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138159);
        if (fVar == null) {
            AppMethodBeat.o(138159);
        } else if (jSONObject == null) {
            AppMethodBeat.o(138159);
        } else {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(fVar.getContext());
            if (castActivityOrNull == null) {
                new b(fVar, i2).invoke();
                AppMethodBeat.o(138159);
                return;
            }
            com.tencent.luggage.h.f aK = com.tencent.luggage.h.f.aK(castActivityOrNull);
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/phone_v2");
            aK.a(intent, new c(this, fVar, i2));
            AppMethodBeat.o(138159);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    static final class c implements f.b {
        final /* synthetic */ d lSa;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.f lyn;
        final /* synthetic */ int lyo;

        c(d dVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2) {
            this.lSa = dVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x011c  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01a8  */
        @Override // com.tencent.luggage.h.f.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r13, android.content.Intent r14) {
            /*
            // Method dump skipped, instructions count: 476
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.contact.d.c.a(int, android.content.Intent):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.f lyn;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2) {
            super(0);
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(138154);
            this.lyn.i(this.lyo, "fail:internal error invalid android context");
            x xVar = x.SXb;
            AppMethodBeat.o(138154);
            return xVar;
        }
    }
}
