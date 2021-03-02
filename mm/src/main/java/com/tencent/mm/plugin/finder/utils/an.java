package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils;", "", "()V", "TAG", "", "initSwitchTime", "", "context", "Landroid/content/Context;", "viewPager", "Landroid/support/v4/view/ViewPager;", "time", "", "ViewPagerScroller", "plugin-finder_release"})
public final class an {
    public static final an waE = new an();

    static {
        AppMethodBeat.i(253824);
        AppMethodBeat.o(253824);
    }

    private an() {
    }

    public static void a(Context context, ViewPager viewPager, int i2) {
        AppMethodBeat.i(253823);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            p.g(declaredField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, new a(context, i2));
            AppMethodBeat.o(253823);
        } catch (Exception e2) {
            Log.printErrStackTrace("ViewPageUtils", e2, "", new Object[0]);
            AppMethodBeat.o(253823);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils$ViewPagerScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "time", "", "(Landroid/content/Context;I)V", "getTime", "()I", "setTime", "(I)V", "startScroll", "", "startX", "startY", "dx", "dy", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "plugin-finder_release"})
    public static final class a extends Scroller {
        private int hXs;

        public a(Context context, int i2) {
            super(context);
            this.hXs = i2;
        }

        public final void startScroll(int i2, int i3, int i4, int i5, int i6) {
            AppMethodBeat.i(253822);
            super.startScroll(i2, i3, i4, i5, this.hXs);
            AppMethodBeat.o(253822);
        }
    }
}
