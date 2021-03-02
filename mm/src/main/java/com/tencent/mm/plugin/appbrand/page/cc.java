package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(14)
public final class cc {
    public static void a(Canvas canvas, View view, float f2, float f3) {
        AppMethodBeat.i(140771);
        if (view.getVisibility() != 0) {
            AppMethodBeat.o(140771);
        } else if (view instanceof TextureView) {
            Bitmap bitmap = ((TextureView) view).getBitmap(view.getWidth(), view.getHeight());
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(bitmap, f2, f3, (Paint) null);
            }
            AppMethodBeat.o(140771);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                a(canvas, childAt, childAt.getX() + f2, childAt.getY() + f3);
            }
            AppMethodBeat.o(140771);
        } else {
            canvas.save();
            canvas.translate(f2, f3);
            view.draw(canvas);
            canvas.restore();
            AppMethodBeat.o(140771);
        }
    }

    public static boolean k(ViewGroup viewGroup) {
        AppMethodBeat.i(140772);
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            AppMethodBeat.o(140772);
            return false;
        }
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof TextureView) {
                z = true;
            }
            if (childAt instanceof ViewGroup) {
                z = k((ViewGroup) childAt);
            }
            if (z) {
                break;
            }
        }
        AppMethodBeat.o(140772);
        return z;
    }
}
