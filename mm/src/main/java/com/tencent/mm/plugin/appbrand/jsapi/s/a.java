package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;

public abstract class a extends s {
    public final void d(t tVar) {
        ac currentPageView = tVar.getCurrentPageView();
        b(currentPageView, currentPageView.getComponentId()).bEo();
        b(currentPageView.NY(), currentPageView.getComponentId()).bEo();
    }
}
