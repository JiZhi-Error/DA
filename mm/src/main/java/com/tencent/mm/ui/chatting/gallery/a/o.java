package com.tencent.mm.ui.chatting.gallery.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.gallery.a.n;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J4\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ*\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014H\u0007J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeViewHelper;", "", "()V", "TAG", "", "vibrator", "Landroid/os/Vibrator;", "animateScanCodeSuccessView", "", "successView", "Landroid/view/View;", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getTopBitmap", "Landroid/graphics/Bitmap;", "bitmap", "viewWidth", "", "viewHeight", "handleCode", "context", "Landroid/content/Context;", "currentView", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "codeHandler", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "needShowScanCodeSuccessView", "", "point", "Landroid/graphics/PointF;", "successViewSize", "vibrate", "app_release"})
public final class o {
    public static final o PDi = new o();
    private static Vibrator paT;

    static {
        AppMethodBeat.i(231313);
        AppMethodBeat.o(231313);
    }

    private o() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/ui/chatting/gallery/scan/ScanCodeViewHelper$handleCode$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ d PDj;
        final /* synthetic */ n PDk;

        a(d dVar, n nVar) {
            this.PDj = dVar;
            this.PDk = nVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(231309);
            super.onAnimationEnd(animator);
            d dVar = this.PDj;
            if (dVar != null) {
                dVar.a(this.PDk);
                AppMethodBeat.o(231309);
                return;
            }
            AppMethodBeat.o(231309);
        }
    }

    public static final void a(View view, float f2, float f3, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(231311);
        if (view == null) {
            AppMethodBeat.o(231311);
            return;
        }
        view.setVisibility(0);
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        view.setAlpha(0.0f);
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.animate().setInterpolator(new LinearInterpolator()).setListener(animatorListenerAdapter).setUpdateListener(null).setDuration(300).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
        AppMethodBeat.o(231311);
    }

    public static final Bitmap j(Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(231312);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(231312);
            return null;
        }
        Log.v("MicroMsg.ScanCodeViewHelper", "getTopBitmap viewWidth: %d, viewHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        Bitmap bitmapFromRect = BitmapUtil.getBitmapFromRect(bitmap, new Rect(0, 0, bitmap.getWidth(), Math.min((int) (((float) i3) / ((1.0f * ((float) i2)) / ((float) bitmap.getWidth()))), bitmap.getHeight())), false);
        AppMethodBeat.o(231312);
        return bitmapFromRect;
    }

    public static void a(Context context, View view, n nVar, k kVar, d dVar) {
        int i2;
        boolean z;
        AppMethodBeat.i(231310);
        p.h(context, "context");
        p.h(nVar, "codeResult");
        if (!nVar.PDd || nVar.PDc == null) {
            dVar.a(nVar);
        } else {
            n.a aVar = nVar.PDc;
            if (aVar == null) {
                p.hyc();
            }
            p.h(context, "context");
            if (paT == null) {
                Object systemService = context.getSystemService("vibrator");
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.os.Vibrator");
                    AppMethodBeat.o(231310);
                    throw tVar;
                }
                paT = (Vibrator) systemService;
            }
            Vibrator vibrator = paT;
            if (vibrator != null) {
                vibrator.vibrate(10);
            }
            int aH = at.aH(context, R.dimen.aia);
            int i3 = 0;
            if (view instanceof g) {
                i3 = ((g) view).getImageWidth();
                i2 = ((g) view).getImageHeight();
            } else {
                i2 = 0;
            }
            if (i3 > 0 && i2 > 0) {
                if (view == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(231310);
                    throw tVar2;
                }
                PointF a2 = ((g) view).a(aVar.PDf, aVar.PDg, aVar.PDh);
                a2.x -= ((float) aH) / 2.0f;
                a2.y -= ((float) aH) / 2.0f;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                if (a2 == null) {
                    z = false;
                } else {
                    if (a2.x >= ((float) (-aH)) / 2.0f && a2.x <= ((float) measuredWidth) + (((float) aH) / 2.0f) && a2.y >= ((float) (-aH)) / 2.0f) {
                        if (a2.y <= (((float) aH) / 2.0f) + ((float) measuredHeight)) {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    Log.i("MicroMsg.ScanCodeViewHelper", "alvinluo handleCode codePoint: %s, dstPoint: %s, imageWidth: %d, imageHeight: %d", aVar.PDf, a2, Integer.valueOf(i3), Integer.valueOf(i2));
                    p.g(a2, "dstPoint");
                    kVar.a(a2, new a(dVar, nVar));
                    AppMethodBeat.o(231310);
                    return;
                }
                dVar.a(nVar);
                AppMethodBeat.o(231310);
                return;
            }
        }
        AppMethodBeat.o(231310);
    }
}
