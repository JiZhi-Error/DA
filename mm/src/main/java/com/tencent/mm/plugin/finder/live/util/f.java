package com.tencent.mm.plugin.finder.live.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/BezierUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class f {
    public static final a uwb = new a((byte) 0);

    static {
        AppMethodBeat.i(247234);
        AppMethodBeat.o(247234);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/BezierUtil$Companion;", "", "()V", "calculateBezierPointForCubic", "Landroid/graphics/PointF;", "t", "", "p0", "p1", "p2", "p3", "calculateBezierPointForQuadratic", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static PointF c(float f2, PointF pointF, PointF pointF2, PointF pointF3) {
            AppMethodBeat.i(260754);
            p.h(pointF, "p0");
            p.h(pointF2, "p1");
            p.h(pointF3, "p2");
            PointF pointF4 = new PointF();
            float f3 = 1.0f - f2;
            pointF4.x = (f3 * f3 * pointF.x) + (2.0f * f2 * f3 * pointF2.x) + (f2 * f2 * pointF3.x);
            pointF4.y = (f3 * 2.0f * f2 * pointF2.y) + (f3 * f3 * pointF.y) + (f2 * f2 * pointF3.y);
            AppMethodBeat.o(260754);
            return pointF4;
        }
    }
}
