package com.tencent.mm.plugin.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.blur.f;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/comm/MusicMvUIUtil;", "", "()V", "TAG", "", "addGradientDrawableToBitmap", "Landroid/graphics/Bitmap;", "isDarkMode", "", "bm", "calcAndUpdateBlurBm", "", "context", "Landroid/content/Context;", "container", "Landroid/view/View;", "bitmap", "md5Key", "targetWidth", "", "targetHeight", "updateBlurBmBackground", "plugin-comm_release"})
public final class b {
    public static final b qCp = new b();

    static {
        AppMethodBeat.i(223471);
        AppMethodBeat.o(223471);
    }

    private b() {
    }

    public static final /* synthetic */ void b(Context context, View view, Bitmap bitmap, String str, int i2, int i3) {
        AppMethodBeat.i(263514);
        a(context, view, bitmap, str, i2, i3);
        AppMethodBeat.o(263514);
    }

    @SuppressLint({"WrongConstant"})
    public static Bitmap a(boolean z, Bitmap bitmap) {
        AppMethodBeat.i(223469);
        p.h(bitmap, "bm");
        Log.e("MicroMsg.Mv.MusicMvUIUtil", "addGradientDrawableToBitmap, start ");
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = {-1711802377, -134744073};
        if (z) {
            iArr = new int[]{-1289542877, -232578269};
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        gradientDrawable.draw(new Canvas(bitmap));
        ae aeVar = ae.SYK;
        String format = String.format(" addGradientDrawableToBitmap end, cost:%d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        Log.e("MicroMsg.Mv.MusicMvUIUtil", format);
        AppMethodBeat.o(223469);
        return bitmap;
    }

    private static void a(Context context, View view, Bitmap bitmap, String str, int i2, int i3) {
        Bitmap bitmap2;
        AppMethodBeat.i(263513);
        try {
            long currentTicks = Util.currentTicks();
            if (bitmap == null) {
                try {
                    p.hyc();
                } catch (Throwable th) {
                    AppMethodBeat.o(263513);
                    throw th;
                }
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int i4 = (int) (((float) height) * 1.0f * ((((float) i3) * 1.0f) / ((float) i2)));
            Matrix matrix = new Matrix();
            float f2 = ((((float) i3) * 1.0f) / ((float) i4)) * 0.25f * 0.25f;
            matrix.postScale(f2, f2);
            bitmap2 = new f(MMApplicationContext.getContext()).b(Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - i4) / 2, width, i4, matrix, false), 30.0f);
            if (bitmap2 != null) {
                q.bcV().h(str, bitmap2);
                view.setBackground(new BitmapDrawable(context.getResources(), bitmap2));
            }
            Log.i("MicroMsg.Mv.MusicMvUIUtil", "updateBlurBmBackground, after blur, cost:" + Util.ticksToNow(currentTicks));
            AppMethodBeat.o(263513);
        } catch (Exception e2) {
            Log.e("MicroMsg.Mv.MusicMvUIUtil", "updateBlurBmBackground, fail, reason:" + e2.getMessage());
            AppMethodBeat.o(263513);
        }
    }

    public static void a(Context context, View view, Bitmap bitmap, String str) {
        AppMethodBeat.i(223470);
        p.h(context, "context");
        p.h(view, "container");
        p.h(bitmap, "bitmap");
        p.h(str, "md5Key");
        Bitmap OQ = q.bcV().OQ(str);
        if (OQ != null && !OQ.isRecycled()) {
            d.h(new a(context, OQ, view));
            AppMethodBeat.o(223470);
        } else if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            view.post(new RunnableC0933b(view, context, bitmap, str));
            AppMethodBeat.o(223470);
        } else {
            a(context, view, bitmap, str, view.getWidth(), view.getHeight());
            AppMethodBeat.o(223470);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.comm.b$b  reason: collision with other inner class name */
    public static final class RunnableC0933b implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ View qCr;
        final /* synthetic */ String qCt;

        RunnableC0933b(View view, Context context, Bitmap bitmap, String str) {
            this.qCr = view;
            this.$context = context;
            this.cKG = bitmap;
            this.qCt = str;
        }

        public final void run() {
            AppMethodBeat.i(263512);
            int width = this.qCr.getWidth();
            int height = this.qCr.getHeight();
            if (this.qCr.getWidth() == 0 || this.qCr.getHeight() == 0) {
                width = com.tencent.mm.cb.a.fromDPToPix(this.$context, 268);
                height = com.tencent.mm.cb.a.fromDPToPix(this.$context, 80);
            }
            b bVar = b.qCp;
            b.b(this.$context, this.qCr, this.cKG, this.qCt, width, height);
            AppMethodBeat.o(263512);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Bitmap qCq;
        final /* synthetic */ View qCr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Bitmap bitmap, View view) {
            super(0);
            this.$context = context;
            this.qCq = bitmap;
            this.qCr = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(223467);
            this.qCr.setBackground(new BitmapDrawable(this.$context.getResources(), this.qCq));
            x xVar = x.SXb;
            AppMethodBeat.o(223467);
            return xVar;
        }
    }
}
