package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001aH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u001aj\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2 \u0010\u0013\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014¨\u0006\u0017"}, hxF = {"calculatePopupMenuLocation", "Landroid/graphics/Point;", "anchor", "Landroid/view/View;", "loadImageView", "", "imageView", "Landroid/widget/ImageView;", "url", "", "radius", "", "isRound", "", "defaultRes", "", "width", "height", "loadImageViewCallback", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "Landroid/graphics/Bitmap;", "plugin-card_release"})
public final class m {
    public static /* synthetic */ void a(ImageView imageView, String str, boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        AppMethodBeat.i(201727);
        boolean z2 = (i5 & 8) != 0 ? false : z;
        int i7 = (i5 & 16) != 0 ? -1 : i2;
        int i8 = (i5 & 32) != 0 ? 0 : i3;
        if ((i5 & 64) == 0) {
            i6 = i4;
        }
        a(imageView, str, z2, i7, i8, i6);
        AppMethodBeat.o(201727);
    }

    public static final void a(ImageView imageView, String str, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(201726);
        p.h(imageView, "imageView");
        p.h(str, "url");
        e.a aVar = new e.a();
        String ajp = com.tencent.mm.plugin.card.model.m.ajp(str);
        p.g(ajp, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
        aVar.Hh(ajp);
        aVar.hZJ = true;
        aVar.hZV = z;
        aVar.hZM = i3;
        aVar.hZN = i4;
        aVar.hZI = true;
        if (i2 >= 0) {
            aVar.hZO = i2;
        }
        e aJT = aVar.aJT();
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().a(str, imageView, aJT);
        AppMethodBeat.o(201726);
    }

    public static /* synthetic */ void b(ImageView imageView, String str, int i2, int i3, kotlin.g.a.m mVar) {
        AppMethodBeat.i(201729);
        a(imageView, str, i2, i3, mVar);
        AppMethodBeat.o(201729);
    }

    private static void a(ImageView imageView, String str, int i2, int i3, kotlin.g.a.m<? super g<?>, ? super Bitmap, x> mVar) {
        AppMethodBeat.i(201728);
        p.h(imageView, "imageView");
        p.h(str, "url");
        e.a aVar = new e.a();
        String ajp = com.tencent.mm.plugin.card.model.m.ajp(str);
        p.g(ajp, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
        aVar.Hh(ajp);
        aVar.hZJ = true;
        aVar.hZV = false;
        aVar.hZM = i2;
        aVar.hZN = i3;
        aVar.hZI = true;
        e aJT = aVar.aJT();
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e.aJs().a(str, imageView, aJT, mVar);
        AppMethodBeat.o(201728);
    }

    public static final Point dB(View view) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(201730);
        p.h(view, "anchor");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = (view.getWidth() / 2) + iArr[0];
        int i4 = iArr[1];
        int height = iArr[1] + view.getHeight();
        if (i4 >= 0) {
            i3 = i4;
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        p.g(resources, "MMApplicationContext.getContext().resources");
        if (height > resources.getDisplayMetrics().heightPixels) {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            Resources resources2 = context2.getResources();
            p.g(resources2, "MMApplicationContext.getContext().resources");
            i2 = resources2.getDisplayMetrics().heightPixels;
        } else {
            i2 = height;
        }
        Point point = new Point(width, (i3 + i2) / 2);
        AppMethodBeat.o(201730);
        return point;
    }
}
