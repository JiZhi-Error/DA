package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.mm.aa.b.a;
import com.tencent.mm.aa.b.b;
import org.json.JSONObject;

public abstract class b extends a {
    /* access modifiers changed from: protected */
    public abstract JSONObject a(com.tencent.mm.aa.c.a aVar);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.aa.c.a, java.lang.Object, java.lang.Object, com.tencent.mm.aa.b.b$a] */
    @Override // com.tencent.mm.aa.b.b
    public final /* bridge */ /* synthetic */ String a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, Bundle bundle, b.a<JSONObject> aVar2) {
        return super.a(aVar, jSONObject, bundle, aVar2);
    }

    public b(String str, int i2) {
        super(str, i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.aa.c.a, java.lang.Object, com.tencent.mm.aa.b.b$a] */
    @Override // com.tencent.mm.aa.b.b
    public final /* synthetic */ String a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        return a(aVar).toString();
    }
}
