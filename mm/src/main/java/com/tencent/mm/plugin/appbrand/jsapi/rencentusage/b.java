package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(228496);
        int[] iArr = new int[JsApiOperateRecentUsageList.Companion.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[JsApiOperateRecentUsageList.Companion.a.REMOVE_FROM_RECENT_USAGE_LIST.ordinal()] = 1;
        $EnumSwitchMapping$0[JsApiOperateRecentUsageList.Companion.a.ADD_TO_MY_COLLECTION.ordinal()] = 2;
        $EnumSwitchMapping$0[JsApiOperateRecentUsageList.Companion.a.REMOVE_FROM_MY_COLLECTION.ordinal()] = 3;
        AppMethodBeat.o(228496);
    }
}
