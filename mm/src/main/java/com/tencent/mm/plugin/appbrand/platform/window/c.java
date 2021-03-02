package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.platform.window.d;

public interface c extends n, g, Comparable<c> {

    public static class b {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    @Deprecated
    boolean OD();

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    d a(d.b bVar);

    void a(int i2, AppBrandRuntime appBrandRuntime);

    void a(WxaWindowLayoutParams wxaWindowLayoutParams, AppBrandRuntime appBrandRuntime);

    boolean bsc();

    boolean bsj();

    Context getContext();

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    e getOrientationHandler();

    Rect getSafeAreaInsets();

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    DisplayMetrics getVDisplayMetrics();

    boolean isInMultiWindowMode();

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    @Deprecated
    void setSoftOrientation(String str);

    void setWindowDescription(a aVar);

    /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.c$c  reason: collision with other inner class name */
    public static class C0789c {
        public int height;
        public int visibility = 0;

        public final String toString() {
            AppMethodBeat.i(176697);
            String str = "WindowStatusBar{height=" + this.height + ", visibility=" + this.visibility + '}';
            AppMethodBeat.o(176697);
            return str;
        }
    }

    public static class a {
        public final int colorPrimary;
        public final String label;
        public final Bitmap nEk;
        public final int noe;

        public a(String str, Bitmap bitmap, int i2) {
            this.label = str;
            this.nEk = bitmap;
            this.noe = -1;
            this.colorPrimary = i2;
        }

        public a(String str) {
            this(str, null, 0);
        }
    }
}
