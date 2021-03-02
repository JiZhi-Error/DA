package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class c extends d {
    private static final int CTRL_INDEX = 851;
    private static final String NAME = "checkIsOpenAccessibility";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        Boolean bool;
        AppMethodBeat.i(193704);
        AccessibilityManager accessibilityManager = (AccessibilityManager) fVar.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            Log.w("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
            bool = null;
        } else {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
            if (!(enabledAccessibilityServiceList != null && !enabledAccessibilityServiceList.isEmpty())) {
                Log.i("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, isTalkBackAccessibilityEnabled: false");
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
        }
        if (bool == null) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(193704);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WeChatBrands.Business.GROUP_OPEN, bool);
        fVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(193704);
    }
}
