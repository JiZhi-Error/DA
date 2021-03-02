package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ca {
    public static Bitmap cD(View view) {
        AppMethodBeat.i(140770);
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            AppMethodBeat.o(140770);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        a(view, view, new Canvas(createBitmap));
        AppMethodBeat.o(140770);
        return createBitmap;
    }

    static void a(View view, View view2, Canvas canvas) {
        boolean z = true;
        float f2 = 0.0f;
        AppMethodBeat.i(221345);
        if (view2.getVisibility() == 0) {
            if (view2 instanceof bz) {
                z = ((bz) view2).c(canvas);
            } else if (view2 instanceof ViewGroup) {
                z = false;
            } else {
                view2.draw(canvas);
            }
        }
        if (z) {
            AppMethodBeat.o(221345);
            return;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            float left = view == view2 ? 0.0f : ((float) viewGroup.getLeft()) + viewGroup.getX();
            if (view != view2) {
                f2 = ((float) viewGroup.getTop()) + viewGroup.getY();
            }
            canvas.save();
            canvas.translate(left, f2);
            viewGroup.draw(canvas);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                canvas.save();
                canvas.translate(((float) childAt.getLeft()) + childAt.getX(), ((float) childAt.getTop()) + childAt.getY());
                a(view, childAt, canvas);
                canvas.restore();
            }
            canvas.restore();
        }
        AppMethodBeat.o(221345);
    }
}
