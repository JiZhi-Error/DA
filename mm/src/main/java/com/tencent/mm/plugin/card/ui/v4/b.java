package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.d.b;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003\u001a\"\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, hxF = {"getOverlayColorDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "loadAndOverlayImageFromUrl", "", "view", "Landroid/widget/ImageView;", "url", "", "width", "height", "pickPrimaryColor", "bitmap", "Landroid/graphics/Bitmap;", "defColor", "getPrimaryColorCallback", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "plugin-card_release"})
public final class b {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "palette", "Landroid/support/v7/graphics/Palette;", "onGenerated"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v4.b$b  reason: collision with other inner class name */
    static final class C0916b implements b.c {
        final /* synthetic */ int qiA;
        final /* synthetic */ f qiz;

        C0916b(f fVar, int i2) {
            this.qiz = fVar;
            this.qiA = i2;
        }

        @Override // android.support.v7.d.b.c
        public final void a(android.support.v7.d.b bVar) {
            AppMethodBeat.i(201604);
            if (bVar != null) {
                b.d hh = bVar.hh();
                if (hh != null) {
                    this.qiz.BN(hh.hm());
                    AppMethodBeat.o(201604);
                    return;
                }
                Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated but swatch is null");
                this.qiz.BN(this.qiA);
                AppMethodBeat.o(201604);
                return;
            }
            Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated fail");
            this.qiz.BN(this.qiA);
            AppMethodBeat.o(201604);
        }
    }

    public static final void a(ImageView imageView, String str, int i2, int i3) {
        AppMethodBeat.i(201605);
        if (str == null || imageView == null) {
            AppMethodBeat.o(201605);
            return;
        }
        m.b(imageView, str, i2, i3, new a(str, imageView));
        AppMethodBeat.o(201605);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class a extends q implements kotlin.g.a.m<g<?>, Bitmap, x> {
        final /* synthetic */ ImageView gWz;
        final /* synthetic */ String mkH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, ImageView imageView) {
            super(2);
            this.mkH = str;
            this.gWz = imageView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/card/ui/v4/CardViewUtilsKt$loadAndOverlayImageFromUrl$1$1$1", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "onGetColor", "", "color", "", "plugin-card_release"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v4.b$a$a  reason: collision with other inner class name */
        public static final class C0915a implements f {
            final /* synthetic */ Context $context;
            final /* synthetic */ Bitmap qix;
            final /* synthetic */ a qiy;

            C0915a(Bitmap bitmap, Context context, a aVar) {
                this.qix = bitmap;
                this.$context = context;
                this.qiy = aVar;
            }

            @Override // com.tencent.mm.plugin.card.ui.v4.f
            public final void BN(int i2) {
                AppMethodBeat.i(201602);
                long bR = com.tencent.mm.loader.l.a.bR(this.qix);
                Log.d("MicroMsg.CardViewUtils", "bitmap size:%d B newsize:%s, url:%s", Long.valueOf(bR), Util.getSizeKB(bR), this.qiy.mkH);
                Context context = this.$context;
                p.g(context, "context");
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), this.qix);
                ColorDrawable colorDrawable = new ColorDrawable(com.tencent.mm.cb.a.n(this.$context, R.color.aa));
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-16777216 | (16777215 & i2), 436207616 | (16777215 & i2)});
                gradientDrawable.setGradientType(0);
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, gradientDrawable, colorDrawable});
                ImageView imageView = this.qiy.gWz;
                if (imageView != null) {
                    imageView.setImageDrawable(layerDrawable);
                    AppMethodBeat.o(201602);
                    return;
                }
                AppMethodBeat.o(201602);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(g<?> gVar, Bitmap bitmap) {
            AppMethodBeat.i(201603);
            Bitmap bitmap2 = bitmap;
            p.h(gVar, "imageView");
            if (bitmap2 != null) {
                Context context = MMApplicationContext.getContext();
                int n = com.tencent.mm.cb.a.n(context, R.color.a1);
                C0915a aVar = new C0915a(bitmap2, context, this);
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, bitmap is null");
                    aVar.BN(n);
                } else {
                    p.g(android.support.v7.d.b.d(bitmap2).a(new C0916b(aVar, n)), "Palette.from(bitmap).gen…)\n            }\n        }");
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201603);
            return xVar;
        }
    }

    public static final Drawable EE(int i2) {
        AppMethodBeat.i(201606);
        Context context = MMApplicationContext.getContext();
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        ColorDrawable colorDrawable2 = new ColorDrawable(com.tencent.mm.cb.a.n(context, R.color.aa));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-16777216 | (i2 & 16777215), 436207616 | (i2 & 16777215)});
        gradientDrawable.setGradientType(0);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{colorDrawable, gradientDrawable, colorDrawable2});
        AppMethodBeat.o(201606);
        return layerDrawable;
    }
}
