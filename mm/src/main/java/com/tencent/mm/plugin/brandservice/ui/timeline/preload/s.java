package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, hxF = {"resettableLazy", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function0;", "resettableManager", "plugin-brandservice_release"})
public final class s {
    public static final <PROPTYPE> q<PROPTYPE> a(r rVar, a<? extends PROPTYPE> aVar) {
        AppMethodBeat.i(6732);
        p.h(rVar, "manager");
        p.h(aVar, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        q<PROPTYPE> qVar = new q<>(rVar, aVar);
        AppMethodBeat.o(6732);
        return qVar;
    }
}
