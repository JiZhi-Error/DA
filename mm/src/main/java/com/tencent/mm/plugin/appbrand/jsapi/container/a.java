package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public final class a extends b {
    public static final int CTRL_INDEX = 509;
    public static final String NAME = "insertPositioningContainer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.i(137505);
        AppBrandNativeContainerView appBrandNativeContainerView = new AppBrandNativeContainerView(hVar.getContext());
        appBrandNativeContainerView.setBackgroundColor(0);
        boolean optBoolean = jSONObject.optBoolean("visible", true);
        boolean optBoolean2 = jSONObject.optBoolean("canFullScreenByChild", false);
        int a2 = g.a(jSONObject, "contentOffsetLeft", 0);
        int a3 = g.a(jSONObject, "contentOffsetTop", 0);
        appBrandNativeContainerView.setX((float) (-a2));
        appBrandNativeContainerView.setY((float) (-a3));
        WrapperNativeContainerView wrapperNativeContainerView = new WrapperNativeContainerView(hVar.getContext(), appBrandNativeContainerView);
        if (!optBoolean) {
            i2 = 4;
        }
        wrapperNativeContainerView.setVisibility(i2);
        wrapperNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.setFullscreenWithChild(optBoolean2);
        AppMethodBeat.o(137505);
        return wrapperNativeContainerView;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137506);
        int i2 = jSONObject.getInt("containerId");
        AppMethodBeat.o(137506);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137507);
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.container.a.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(137504);
                if (motionEvent.getAction() != 0) {
                    e.a((ViewGroup) view, motionEvent);
                }
                AppMethodBeat.o(137504);
                return false;
            }
        });
        AppMethodBeat.o(137507);
    }
}
