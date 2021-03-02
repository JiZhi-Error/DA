package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.a.b;
import com.tencent.luggage.sdk.b.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public abstract class a<PAGE extends c> extends a.AbstractC0178a<PAGE> implements ae {
    public a(PAGE page) {
        super(page);
    }

    public d NP() {
        c cVar = (c) NN();
        if (cVar == null) {
            return null;
        }
        return cVar.NP();
    }

    public final String getAppId() {
        f NN = NN();
        if (NN != null) {
            return NN.getAppId();
        }
        Log.printErrStackTrace("Luggage.AbstractPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
        return null;
    }

    public final Context getContext() {
        Context context = ((c) NN()).getContext();
        if (context == null) {
            return MMApplicationContext.getContext();
        }
        return context;
    }

    public final <T extends b> T T(Class<T> cls) {
        return (T) ((c) NN()).M(cls);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void a(Map<String, Object> map, bx bxVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void dispatchStart() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
        for (Object obj : NO()) {
            if (obj instanceof com.tencent.mm.plugin.appbrand.page.a.b) {
                ((com.tencent.mm.plugin.appbrand.page.a.b) obj).a(bVar);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void Nd() {
        for (Object obj : NO()) {
            if (obj instanceof com.tencent.mm.plugin.appbrand.page.a.b) {
                ((com.tencent.mm.plugin.appbrand.page.a.b) obj).onForeground();
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void Ne() {
        for (Object obj : NO()) {
            if (obj instanceof com.tencent.mm.plugin.appbrand.page.a.b) {
                ((com.tencent.mm.plugin.appbrand.page.a.b) obj).onBackground();
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void dispatchDestroy() {
        for (Object obj : NO()) {
            if (obj instanceof com.tencent.mm.plugin.appbrand.page.a.b) {
                ((com.tencent.mm.plugin.appbrand.page.a.b) obj).onDestroy();
            }
        }
        synchronized (this.czn) {
            this.czn.clear();
        }
        synchronized (this) {
            this.czm = null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public final void dispatchConfigurationChanged(Configuration configuration) {
        for (Object obj : NO()) {
            if (obj instanceof com.tencent.mm.plugin.appbrand.page.a.b) {
                ((com.tencent.mm.plugin.appbrand.page.a.b) obj).onConfigurationChanged(configuration);
            }
        }
    }
}
