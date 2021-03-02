package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.c.b;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f {
    public static final f xlA = new f();
    private static final e xls;
    private static final e xlt;
    private static final com.tencent.mm.loader.g.a.f xlu = new com.tencent.mm.loader.g.a.f(new a(Integer.MAX_VALUE), new g(5), new g(5), new g(5), 5, "galleryLoader");
    private static final d<c> xlv = com.tencent.mm.loader.g.a.e.a(xlu);
    private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> xlw;
    private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> xlx;
    private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> xly = com.tencent.mm.loader.e.a(xlw);
    private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> xlz = com.tencent.mm.loader.e.a(xlx);

    static {
        AppMethodBeat.i(164911);
        e.a aVar = new e.a();
        aVar.hZJ = false;
        aVar.hZI = true;
        e.a a2 = aVar.a(e.c.FILE);
        a2.hZN = 480;
        a2.hZM = 480;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        if (resources == null) {
            p.hyc();
        }
        xls = a2.w(new ColorDrawable(resources.getColor(R.color.BW_93))).aJT();
        e.a aVar2 = new e.a();
        aVar2.hZJ = false;
        e.a a3 = aVar2.a(e.c.FILE);
        a3.hZI = true;
        a3.hZN = 2160;
        a3.hZM = 2160;
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        Resources resources2 = context2.getResources();
        if (resources2 == null) {
            p.hyc();
        }
        xlt = a3.w(new ColorDrawable(resources2.getColor(R.color.BW_93))).aJT();
        com.tencent.mm.loader.g.a.e eVar = com.tencent.mm.loader.g.a.e.ibM;
        b b2 = new com.tencent.mm.loader.c.a().a(new com.tencent.mm.loader.b.b.a()).a(new a()).a(new g()).b(new d()).a(new b()).b(xls);
        b2.hYm = xlv;
        xlw = b2.aJE();
        b b3 = new com.tencent.mm.loader.c.a().a(new com.tencent.mm.loader.b.b.a()).a(new a()).b(new c()).a(new g()).a(new b()).b(xlt);
        b3.hYm = xlv;
        xlx = b3.aJE();
        com.tencent.mm.loader.e eVar2 = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar3 = com.tencent.mm.loader.e.hXU;
        AppMethodBeat.o(164911);
    }

    private f() {
    }

    public static com.tencent.mm.loader.d<GalleryItem.MediaItem> dRD() {
        return xly;
    }

    public static com.tencent.mm.loader.d<GalleryItem.MediaItem> dRE() {
        return xlz;
    }
}
