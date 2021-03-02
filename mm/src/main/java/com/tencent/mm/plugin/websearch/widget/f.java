package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.j;

public final class f {
    public static void a(int i2, WidgetData widgetData, WidgetData widgetData2) {
        AppMethodBeat.i(116645);
        String str = "";
        switch (i2) {
            case 1:
            case 3:
                str = widgetData.IFG.iIA;
                break;
            case 2:
                str = widgetData2.IFG.iIA;
                break;
        }
        nd ndVar = new nd();
        ndVar.ekB = ndVar.x("appId", str, true);
        ndVar.fgg = (long) i2;
        ndVar.fgh = System.currentTimeMillis() / 1000;
        ndVar.fgi = (long) widgetData.IFG.serviceType;
        ndVar.fgj = ndVar.x("statBuffer", widgetData.IFG.IFM, true);
        ndVar.fgk = ndVar.x("switchId", String.format("%s-%s-%s", widgetData.IFG.hes, Integer.valueOf(widgetData.IFG.serviceType), Long.valueOf(System.currentTimeMillis() / 1000)), true);
        ((j) g.af(j.class)).cL(14688, ndVar.abV());
        AppMethodBeat.o(116645);
    }
}
