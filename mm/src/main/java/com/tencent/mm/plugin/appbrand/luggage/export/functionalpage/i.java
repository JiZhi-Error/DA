package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalPageAuthorizePresenterViewsFactory;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "()V", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "plugin-appbrand-integration_release"})
public final class i implements a.b, b.AbstractC0781b {
    public static final i nax = new i();

    static {
        AppMethodBeat.i(228837);
        AppMethodBeat.o(228837);
    }

    private i() {
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b.AbstractC0781b
    public final b a(d dVar, b.c cVar) {
        AppMethodBeat.i(228835);
        p.h(dVar, "component");
        p.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b bVar = new com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b(dVar, cVar);
        AppMethodBeat.o(228835);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b
    public final a e(d dVar) {
        AppMethodBeat.i(228836);
        p.h(dVar, "component");
        c cVar = new c(dVar);
        AppMethodBeat.o(228836);
        return cVar;
    }
}
