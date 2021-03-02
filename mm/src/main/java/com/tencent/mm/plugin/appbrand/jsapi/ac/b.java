package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b {
    public static void a(View view, JSONObject jSONObject) {
        AppMethodBeat.i(140677);
        if (view != null && jSONObject != null && jSONObject.has("accessibility") && jSONObject.optBoolean("accessibility", false)) {
            final String optString = jSONObject.optString("ariaLabel", "");
            final String optString2 = jSONObject.optString("ariaRole", "");
            view.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ac.b.AnonymousClass1 */

                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    AppMethodBeat.i(140676);
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    if (!Util.isNullOrNil(optString)) {
                        accessibilityNodeInfo.setContentDescription(optString);
                    }
                    if (Util.isNullOrNil(optString2) || !optString2.equalsIgnoreCase("button")) {
                        accessibilityNodeInfo.setClickable(false);
                        accessibilityNodeInfo.setClassName(TextView.class.getName());
                        AppMethodBeat.o(140676);
                        return;
                    }
                    accessibilityNodeInfo.setClickable(true);
                    accessibilityNodeInfo.setClassName(Button.class.getName());
                    AppMethodBeat.o(140676);
                }
            });
        }
        AppMethodBeat.o(140677);
    }
}
