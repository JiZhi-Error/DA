package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.r;

public final class a {
    public static final boolean orx = (Build.VERSION.SDK_INT < 20);
    public final Activity activity;
    public boolean ory = false;
    public int orz = 0;

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(136303);
        aVar.caN();
        AppMethodBeat.o(136303);
    }

    public a(Activity activity2) {
        this.activity = activity2;
    }

    public final void caN() {
        AppMethodBeat.i(136298);
        if (!this.ory || this.activity.isFinishing()) {
            AppMethodBeat.o(136298);
            return;
        }
        if (orx) {
            if (n.I(this.activity) == null) {
                Log.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
                AppMethodBeat.o(136298);
                return;
            }
            caO();
        }
        AppMethodBeat.o(136298);
    }

    public final void caO() {
        AppMethodBeat.i(183096);
        n I = n.I(this.activity);
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int jJ = r.jJ(this.activity);
        int i2 = point.y;
        if (caP()) {
            jJ = 0;
        }
        int i3 = i2 - jJ;
        Log.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", Integer.valueOf(i3));
        I.setForceHeight(i3);
        AppMethodBeat.o(183096);
    }

    private boolean caP() {
        AppMethodBeat.i(136300);
        if (this.activity.getWindow() == null || (this.activity.getWindow().getAttributes().flags & 1024) <= 0) {
            AppMethodBeat.o(136300);
            return false;
        }
        AppMethodBeat.o(136300);
        return true;
    }

    public static boolean eB(Context context) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(136301);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            z = resources.getBoolean(identifier);
        } else {
            z = false;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                z2 = false;
            } else {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                    z2 = true;
                }
                z2 = z;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(136301);
        return z2;
    }

    public static boolean caQ() {
        AppMethodBeat.i(136302);
        try {
            boolean booleanValue = ((Boolean) org.a.a.gG(org.a.a.bF(org.a.a.forName("android.view.WindowManagerGlobal")).bvt("getWindowManagerService").object).bvt("hasNavigationBar").object).booleanValue();
            AppMethodBeat.o(136302);
            return booleanValue;
        } catch (Throwable th) {
            Log.e("MicroMsg.AppBrandFixInputIssuesActivityHelper", "checkDeviceHasNavigationBar2 e=%s", th);
            AppMethodBeat.o(136302);
            return false;
        }
    }
}
