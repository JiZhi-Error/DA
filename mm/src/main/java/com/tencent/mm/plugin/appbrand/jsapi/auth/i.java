package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.c;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i extends d<com.tencent.mm.plugin.appbrand.d> {
    protected boolean iLM = false;

    /* access modifiers changed from: protected */
    public abstract void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2, e eVar);

    public void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        this.iLM = jSONObject.optBoolean("keepAlive", false);
        boolean optBoolean = jSONObject.optBoolean("requestInQueue", true);
        if (j.NAME.equalsIgnoreCase(getName())) {
            a(dVar, jSONObject, i2, (e) null);
            return;
        }
        try {
            jSONObject.put("wxdataQueueTimestamp", Util.nowMilliSecond());
        } catch (JSONException e2) {
        }
        if (!optBoolean) {
            b.U(dVar.getRuntime()).a(this, dVar, jSONObject, i2);
        } else {
            d.V(dVar.getRuntime()).a(this, dVar, jSONObject, i2);
        }
    }

    protected static Activity b(k kVar) {
        Context context;
        if (kVar instanceof s) {
            context = ((s) kVar).ay(Activity.class);
        } else {
            context = kVar.getContext();
        }
        if (context == null) {
            return null;
        }
        return AndroidContextUtil.castActivityOrNull(context);
    }

    protected static LinkedList<c.C0819c> y(LinkedList<drb> linkedList) {
        LinkedList<c.C0819c> linkedList2 = new LinkedList<>();
        Iterator<drb> it = linkedList.iterator();
        while (it.hasNext()) {
            drb next = it.next();
            c.C0819c cVar = new c.C0819c();
            cVar.scope = next.KWK;
            cVar.desc = next.Desc;
            cVar.state = next.MTI;
            linkedList2.add(cVar);
        }
        return linkedList2;
    }

    protected static <T> LinkedList<T> A(ArrayList<T> arrayList) {
        if (arrayList == null) {
            return null;
        }
        LinkedList<T> linkedList = new LinkedList<>();
        linkedList.addAll(arrayList);
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void b(k kVar, int i2, String str) {
        kVar.i(i2, h(str, null));
    }
}
