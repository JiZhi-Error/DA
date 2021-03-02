package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

public final class ah {
    public static final ah OKD = new ah();

    static {
        AppMethodBeat.i(175972);
        AppMethodBeat.o(175972);
    }

    private ah() {
    }

    public static final class a {
        public final int height;
        public final int width;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.width == aVar.width && this.height == aVar.height)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.width * 31) + this.height;
        }

        public final String toString() {
            AppMethodBeat.i(175970);
            String str = "Size(width=" + this.width + ", height=" + this.height + ")";
            AppMethodBeat.o(175970);
            return str;
        }

        public a(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }
    }

    public static /* synthetic */ a gJB() {
        AppMethodBeat.i(196219);
        a jS = jS(null);
        AppMethodBeat.o(196219);
        return jS;
    }

    public static final a jS(Context context) {
        Display defaultDisplay;
        AppMethodBeat.i(175971);
        if (context == null && (context = MMApplicationContext.getContext()) == null) {
            p.hyc();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (!(windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getRealSize(point);
        }
        if (point.x == 0 || point.y == 0) {
            Resources resources = context.getResources();
            p.g(resources, "context.resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = context.getResources();
            p.g(resources2, "context.resources");
            a aVar = new a(i2, resources2.getDisplayMetrics().heightPixels);
            AppMethodBeat.o(175971);
            return aVar;
        }
        a aVar2 = new a(point.x, point.y);
        AppMethodBeat.o(175971);
        return aVar2;
    }
}
