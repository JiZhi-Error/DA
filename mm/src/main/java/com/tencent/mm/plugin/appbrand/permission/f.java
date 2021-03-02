package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\f\u0010\u0007\u001a\u00020\b*\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "show", "findPromptViewContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "luggage-wechat-full-sdk_release"})
public interface f {
    void h(d dVar);

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static m j(d dVar) {
            AppMethodBeat.i(230123);
            p.h(dVar, "$this$findPromptViewContainer");
            AppBrandRuntime runtime = dVar.getRuntime();
            if (runtime == null) {
                p.hyc();
            }
            m brn = runtime.brn();
            if (brn == null) {
                p.hyc();
            }
            AppMethodBeat.o(230123);
            return brn;
        }
    }
}
