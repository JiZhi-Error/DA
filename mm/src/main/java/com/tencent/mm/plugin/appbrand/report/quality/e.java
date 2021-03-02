package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(51041);
        int[] iArr = new int[com.tencent.mm.plugin.appbrand.report.e.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[com.tencent.mm.plugin.appbrand.report.e.X5.ordinal()] = 1;
        $EnumSwitchMapping$0[com.tencent.mm.plugin.appbrand.report.e.MMV8.ordinal()] = 2;
        $EnumSwitchMapping$0[com.tencent.mm.plugin.appbrand.report.e.WebViewBased.ordinal()] = 3;
        $EnumSwitchMapping$0[com.tencent.mm.plugin.appbrand.report.e.NativeScript.ordinal()] = 4;
        $EnumSwitchMapping$0[com.tencent.mm.plugin.appbrand.report.e.J2V8.ordinal()] = 5;
        $EnumSwitchMapping$0[com.tencent.mm.plugin.appbrand.report.e.NodeJS.ordinal()] = 6;
        int[] iArr2 = new int[WebView.c.values().length];
        haE = iArr2;
        iArr2[WebView.c.WV_KIND_NONE.ordinal()] = 1;
        haE[WebView.c.WV_KIND_SYS.ordinal()] = 2;
        haE[WebView.c.WV_KIND_X5.ordinal()] = 3;
        haE[WebView.c.WV_KIND_CW.ordinal()] = 4;
        AppMethodBeat.o(51041);
    }
}
