package com.tencent.mm.plugin.festival.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Calendar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalBlurSnapshotAlternativeDrawable;", "", "()V", "calender", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "plugin-festival_release"})
public final class b {
    public static final b UBn = new b();
    private static final Calendar Usb = Calendar.getInstance();

    static {
        AppMethodBeat.i(263187);
        AppMethodBeat.o(263187);
    }

    private b() {
    }

    public static Drawable mj(Context context) {
        int i2;
        AppMethodBeat.i(263186);
        p.h(context, "context");
        Calendar calendar = Usb;
        p.g(calendar, "calender");
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i3 = Usb.get(11);
        if (6 <= i3 && 18 > i3) {
            i2 = R.drawable.ctl;
        } else {
            i2 = R.drawable.ctm;
        }
        Drawable l = android.support.v4.content.b.l(context, i2);
        AppMethodBeat.o(263186);
        return l;
    }
}
