package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import org.json.JSONArray;

public final class f implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144871);
        DrawImageActionArg drawImageActionArg = new DrawImageActionArg();
        AppMethodBeat.o(144871);
        return drawImageActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "drawImage";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144872);
        int length = jSONArray.length();
        if (length < 3) {
            AppMethodBeat.o(144872);
            return false;
        }
        boolean a2 = a(dVar, canvas, length, jSONArray.optString(0), g.f(jSONArray, 1), g.f(jSONArray, 2), g.f(jSONArray, 3), g.f(jSONArray, 4), jSONArray.optInt(5), jSONArray.optInt(6), jSONArray.optInt(7), jSONArray.optInt(8));
        AppMethodBeat.o(144872);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144873);
        DrawImageActionArg drawImageActionArg = (DrawImageActionArg) drawActionArg;
        if (drawImageActionArg == null) {
            AppMethodBeat.o(144873);
            return false;
        }
        boolean a2 = a(dVar, canvas, drawImageActionArg.kZx, drawImageActionArg.url, drawImageActionArg.x, drawImageActionArg.y, drawImageActionArg.width, drawImageActionArg.height, drawImageActionArg.kZy, drawImageActionArg.kZz, drawImageActionArg.aWX, drawImageActionArg.aWY);
        AppMethodBeat.o(144873);
        return a2;
    }

    private boolean a(d dVar, Canvas canvas, int i2, String str, float f2, float f3, float f4, float f5, int i3, int i4, int i5, int i6) {
        float f6;
        float f7;
        Bitmap a2;
        int i7;
        int i8;
        AppMethodBeat.i(144874);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(144874);
            return false;
        }
        if (i2 < 5) {
            f6 = f3;
            f7 = f2;
        } else if (f4 == 0.0f || f5 == 0.0f) {
            AppMethodBeat.o(144874);
            return true;
        } else {
            if (f4 < 0.0f) {
                f7 = f2 + f4;
                f4 = -f4;
            } else {
                f7 = f2;
            }
            if (f5 < 0.0f) {
                float f8 = f3 + f5;
                f5 = -f5;
                f6 = f8;
            } else {
                f6 = f3;
            }
        }
        float f9 = f7 + f4;
        float f10 = f6 + f5;
        if (i2 < 9) {
            a2 = dVar.kZr.a(dVar, str, new e.a() {
                /* class com.tencent.mm.plugin.appbrand.canvas.action.f.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.canvas.e.a
                public final void a(d dVar) {
                    AppMethodBeat.i(144870);
                    dVar.invalidate();
                    AppMethodBeat.o(144870);
                }
            });
            if (a2 == null || a2.isRecycled()) {
                AppMethodBeat.o(144874);
                return false;
            }
            if (f4 == 0.0f) {
                f9 = ((float) g.zD(a2.getWidth())) + f7;
            }
            if (f5 == 0.0f) {
                f10 = ((float) g.zD(a2.getHeight())) + f6;
            }
        } else if (i5 == 0 || i6 == 0) {
            AppMethodBeat.o(144874);
            return true;
        } else {
            if (i5 < 0) {
                i7 = i3 + i5;
                i5 = -i5;
            } else {
                i7 = i3;
            }
            if (i6 < 0) {
                i8 = i4 + i6;
                i6 = -i6;
            } else {
                i8 = i4;
            }
            if (i7 + i5 <= 0 || i8 + i6 <= 0) {
                AppMethodBeat.o(144874);
                return true;
            }
            int i9 = i7 > 0 ? i7 : 0;
            int i10 = i8 > 0 ? i8 : 0;
            a2 = dVar.kZr.a(dVar, str, new Rect(i9, i10, i7 + i5, i8 + i6), new e.a() {
                /* class com.tencent.mm.plugin.appbrand.canvas.action.f.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.canvas.e.a
                public final void a(d dVar) {
                    AppMethodBeat.i(144869);
                    dVar.invalidate();
                    AppMethodBeat.o(144869);
                }
            });
            if (a2 == null || a2.isRecycled()) {
                AppMethodBeat.o(144874);
                return false;
            }
            int zD = g.zD(i7);
            int zD2 = g.zD(i8);
            int zD3 = g.zD(i5);
            int zD4 = g.zD(i6);
            float f11 = f4 / ((float) zD3);
            float f12 = f5 / ((float) zD4);
            f7 += ((float) (g.zD(i9) - zD)) * f11;
            f6 += ((float) (g.zD(i10) - zD2)) * f12;
            f9 = f7 + (((float) g.zD(a2.getWidth())) * f11);
            f10 = (((float) g.zD(a2.getHeight())) * f12) + f6;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), new RectF(f7, f6, f9, f10), dVar.kZm);
        AppMethodBeat.o(144874);
        return true;
    }
}
