package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.ui.ar;
import com.tencent.smtt.sdk.WebView;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0012\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0012\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001a"}, hxF = {"DEFAULT_STROKE_COLOR", "", "DEFAULT_TEXT_COLOR", "STROKE_COLORS", "", "getSTROKE_COLORS", "()[I", "TEXT_COLORS", "getTEXT_COLORS", "findStrokeColor", "textColor", "findTextColor", "isRedPackageScene", "", "scene", "waitUploading", "waitingMixing", "getIconNorColor", "Landroid/view/View;", "getIconSelColor", "getTextColor", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojicapture_release"})
public final class c {
    private static final int[] rsh = {-1, WebView.NIGHT_MODE_COLOR, -314573, -12493, -4920114, -4724993, -144437};
    private static final int[] rsi = {WebView.NIGHT_MODE_COLOR, -1, -15616, -2724096, -16339626, -15954996, -298125};

    public static final int[] cJF() {
        return rsh;
    }

    public static final int[] cJG() {
        return rsi;
    }

    public static final int Go(int i2) {
        boolean z;
        Integer valueOf;
        int i3 = 1;
        AppMethodBeat.i(JsApiCancelDownloadTask.CTRL_INDEX);
        int[] iArr = rsh;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            valueOf = null;
        } else {
            int i4 = iArr[0];
            int X = e.X(iArr);
            if (X != 0) {
                int red = Color.red(i2) - Color.red(i4);
                int green = Color.green(i2) - Color.green(i4);
                int blue = Color.blue(i2) - Color.blue(i4);
                double sqrt = Math.sqrt((double) ((red * red) + (green * green) + (blue * blue)));
                if (X > 0) {
                    while (true) {
                        int i5 = iArr[i3];
                        int red2 = Color.red(i2) - Color.red(i5);
                        int green2 = Color.green(i2) - Color.green(i5);
                        int blue2 = Color.blue(i2) - Color.blue(i5);
                        double sqrt2 = Math.sqrt((double) ((red2 * red2) + (green2 * green2) + (blue2 * blue2)));
                        if (Double.compare(sqrt, sqrt2) > 0) {
                            sqrt = sqrt2;
                            i4 = i5;
                        }
                        if (i3 == X) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            valueOf = Integer.valueOf(i4);
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            AppMethodBeat.o(JsApiCancelDownloadTask.CTRL_INDEX);
            return intValue;
        }
        AppMethodBeat.o(JsApiCancelDownloadTask.CTRL_INDEX);
        return -1;
    }

    public static final int Gp(int i2) {
        AppMethodBeat.i(JsApiOpenAdCanvas.CTRL_INDEX);
        int n = e.n(rsh, i2);
        if (n < 0) {
            AppMethodBeat.o(JsApiOpenAdCanvas.CTRL_INDEX);
            return WebView.NIGHT_MODE_COLOR;
        }
        int i3 = rsi[n];
        AppMethodBeat.o(JsApiOpenAdCanvas.CTRL_INDEX);
        return i3;
    }

    public static final int dH(View view) {
        AppMethodBeat.i(b.CTRL_INDEX);
        p.h(view, "$this$getIconSelColor");
        Context context = view.getContext();
        p.g(context, "context");
        int color = context.getResources().getColor(com.tencent.mm.emoji.e.b.cG(view.getContext()));
        AppMethodBeat.o(b.CTRL_INDEX);
        return color;
    }

    public static final int dI(View view) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
        p.h(view, "$this$getIconNorColor");
        Context context = view.getContext();
        p.g(context, "context");
        int color = context.getResources().getColor(R.color.FG_0);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
        return color;
    }

    public static final void a(ImageView imageView, int i2, int i3) {
        AppMethodBeat.i(479);
        p.h(imageView, "$this$setSvgDrawable");
        imageView.setImageDrawable(ar.m(imageView.getContext(), i2, i3));
        AppMethodBeat.o(479);
    }

    public static final boolean Gr(int i2) {
        AppMethodBeat.i(480);
        if (!Gq(i2) || !(i2 == 4 || i2 == 5)) {
            AppMethodBeat.o(480);
            return false;
        }
        AppMethodBeat.o(480);
        return true;
    }

    public static final boolean Gq(int i2) {
        switch (i2) {
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }
}
