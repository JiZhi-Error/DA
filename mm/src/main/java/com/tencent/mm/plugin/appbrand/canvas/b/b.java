package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg;
import org.json.JSONArray;

public final class b implements a {
    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final String getMethod() {
        return "arc";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, JSONArray jSONArray) {
        AppMethodBeat.i(145347);
        if (jSONArray.length() < 5) {
            AppMethodBeat.o(145347);
            return false;
        }
        boolean a2 = a(path, g.f(jSONArray, 0), g.f(jSONArray, 1), g.f(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4), jSONArray.optBoolean(5));
        AppMethodBeat.o(145347);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final boolean a(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(145348);
        if (basePathActionArg == null || !(basePathActionArg instanceof PathArcActionArg)) {
            AppMethodBeat.o(145348);
            return false;
        }
        PathArcActionArg pathArcActionArg = (PathArcActionArg) basePathActionArg;
        boolean a2 = a(path, pathArcActionArg.x, pathArcActionArg.y, pathArcActionArg.radius, pathArcActionArg.mj, pathArcActionArg.kZU, pathArcActionArg.kZV);
        AppMethodBeat.o(145348);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.b.a
    public final BasePathActionArg bzv() {
        AppMethodBeat.i(145349);
        PathArcActionArg pathArcActionArg = new PathArcActionArg();
        AppMethodBeat.o(145349);
        return pathArcActionArg;
    }

    private static boolean a(Path path, float f2, float f3, float f4, float f5, float f6, boolean z) {
        float f7;
        AppMethodBeat.i(145350);
        float f8 = f2 - f4;
        float f9 = f3 - f4;
        float f10 = f2 + f4;
        float f11 = f3 + f4;
        float degrees = (float) Math.toDegrees((double) f5);
        float degrees2 = (float) Math.toDegrees((double) f6);
        float f12 = (float) (360.0d / (6.283185307179586d * ((double) f4)));
        if (z) {
            if (degrees - degrees2 >= 360.0f) {
                f7 = -360.0f;
            } else {
                float f13 = degrees % 360.0f;
                float f14 = degrees2 % 360.0f;
                if (f13 < 0.0f) {
                    f13 += 360.0f;
                }
                if (f14 < 0.0f) {
                    f14 += 360.0f;
                }
                if (f14 >= f13) {
                    f7 = (f14 - f13) - 360.0f;
                } else {
                    f7 = f14 - f13;
                }
            }
        } else if (degrees2 - degrees >= 360.0f) {
            f7 = 360.0f;
        } else {
            float f15 = degrees % 360.0f;
            float f16 = degrees2 % 360.0f;
            if (f15 < 0.0f) {
                f15 += 360.0f;
            }
            if (f16 < 0.0f) {
                f16 += 360.0f;
            }
            if (f16 >= f15) {
                f7 = f16 - f15;
            } else {
                f7 = (f16 + 360.0f) - f15;
            }
        }
        float f17 = f7 % 360.0f;
        if (f17 > f12 || f17 < (-f12)) {
            path.arcTo(new RectF(f8, f9, f10, f11), degrees, f7, false);
        } else {
            path.arcTo(new RectF(f8, f9, f10, f11), degrees, f7, false);
            path.addArc(new RectF(f8, f9, f10, f11), degrees, f7);
        }
        AppMethodBeat.o(145350);
        return true;
    }
}
