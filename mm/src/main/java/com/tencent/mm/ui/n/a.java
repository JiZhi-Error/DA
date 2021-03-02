package com.tencent.mm.ui.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapTracer;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.IWebView;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static Bitmap a(View view, int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(205362);
        if (view == null) {
            AppMethodBeat.o(205362);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        Matrix matrix = new Matrix();
        matrix.setScale(((float) i2) / ((float) view.getWidth()), ((float) i3) / ((float) view.getHeight()));
        Canvas canvas = new Canvas(createBitmap);
        canvas.setMatrix(matrix);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        a(canvas, view, true);
        BitmapUtil.setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(205362);
        return trace;
    }

    public static Bitmap a(View view, Bitmap.Config config) {
        AppMethodBeat.i(205363);
        if (view == null) {
            AppMethodBeat.o(205363);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        a(canvas, view, false);
        BitmapUtil.setBitmapDensity(createBitmap);
        Bitmap trace = BitmapTracer.trace(createBitmap);
        AppMethodBeat.o(205363);
        return trace;
    }

    private static void a(Canvas canvas, View view, boolean z) {
        AppMethodBeat.i(205364);
        view.draw(canvas);
        List<C2122a> c2 = c(view, (int) view.getX(), (int) view.getY(), z);
        if (c2.size() > 0) {
            for (C2122a aVar : c2) {
                if (aVar != null && aVar.Qof != null) {
                    TextureView textureView = aVar.Qof;
                    Bitmap bitmap = textureView.getBitmap(textureView.getWidth(), textureView.getHeight());
                    if (bitmap == null || bitmap.isRecycled()) {
                        Log.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
                    } else {
                        canvas.drawBitmap(bitmap, (float) aVar.left, (float) aVar.top, (Paint) null);
                    }
                } else if (aVar != null && (aVar.Qog instanceof IWebView) && z) {
                    Bitmap captureBitmap = aVar.Qog.captureBitmap();
                    if (captureBitmap == null || captureBitmap.isRecycled()) {
                        Log.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
                    } else {
                        canvas.drawBitmap(captureBitmap, (float) aVar.left, (float) aVar.top, (Paint) null);
                    }
                }
            }
        }
        AppMethodBeat.o(205364);
    }

    private static List<C2122a> c(View view, int i2, int i3, boolean z) {
        AppMethodBeat.i(205365);
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            C2122a aVar = new C2122a();
            aVar.Qof = (TextureView) view;
            aVar.left = i2;
            aVar.top = i3;
            arrayList.add(aVar);
        } else if (z && (view instanceof WebView)) {
            C2122a aVar2 = new C2122a();
            aVar2.Qog = (WebView) view;
            aVar2.left = i2;
            aVar2.top = i3;
            arrayList.add(aVar2);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                arrayList.addAll(c(viewGroup.getChildAt(i4), (int) (viewGroup.getX() + ((float) i2)), (int) (viewGroup.getY() + ((float) i3)), z));
            }
        }
        AppMethodBeat.o(205365);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.n.a$a  reason: collision with other inner class name */
    public static class C2122a {
        TextureView Qof;
        IWebView Qog;
        int left = 0;
        int top = 0;

        C2122a() {
        }
    }

    public static Bitmap hn(View view) {
        AppMethodBeat.i(259386);
        Bitmap a2 = a(view, Bitmap.Config.ARGB_8888);
        AppMethodBeat.o(259386);
        return a2;
    }
}
