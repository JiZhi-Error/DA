package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/GetStablePosTask;", "Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Landroid/graphics/Point;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class n extends q implements b<IPCString, Point> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(IPCString iPCString, d<Point> dVar) {
        AppMethodBeat.i(229269);
        IPCString iPCString2 = iPCString;
        if (iPCString2 == null || dVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "GetStablePosTask#invoke, data: " + iPCString2 + ", callback: " + dVar);
            AppMethodBeat.o(229269);
            return;
        }
        o bTJ = bTJ();
        String str = iPCString2.value;
        p.g(str, "data.value");
        Point aeC = bTJ.aeC(str);
        Log.d("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "GetStablePosTask#invoke, point: ".concat(String.valueOf(aeC)));
        dVar.bn(aeC);
        AppMethodBeat.o(229269);
    }
}
