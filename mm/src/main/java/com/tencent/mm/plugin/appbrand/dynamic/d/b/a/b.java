package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b implements e<String> {
    private String lox;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final /* bridge */ /* synthetic */ void cB(String str) {
        this.lox = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void a(com.tencent.mm.plugin.appbrand.dynamic.d.b.b bVar) {
        AppMethodBeat.i(121372);
        bVar.run();
        AppMethodBeat.o(121372);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final boolean YA(String str) {
        AppMethodBeat.i(121373);
        if (this.lox == null) {
            AppMethodBeat.o(121373);
            return true;
        } else if (TextUtils.isEmpty(str) || str.hashCode() == this.lox.hashCode()) {
            AppMethodBeat.o(121373);
            return false;
        } else {
            AppMethodBeat.o(121373);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void reset() {
        this.lox = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final int bCe() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void W(Runnable runnable) {
        AppMethodBeat.i(121374);
        runnable.run();
        AppMethodBeat.o(121374);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void bCd() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final /* synthetic */ String d(JSONObject jSONObject, String str) {
        AppMethodBeat.i(121375);
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(121375);
        return jSONObject2;
    }
}
