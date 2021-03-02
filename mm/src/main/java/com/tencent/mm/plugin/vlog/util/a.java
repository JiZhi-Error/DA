package com.tencent.mm.plugin.vlog.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gallery.picker.b.c;
import com.tencent.mm.plugin.vlog.ui.plugin.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rJ&\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\rJ\u001e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/vlog/util/FinderEditUtil;", "", "()V", "FULLSCREEN_RATIO", "", "getFULLSCREEN_RATIO", "()F", "MIN_RATIO", "NORMAL_RATIO", "getNORMAL_RATIO", "RATIO_TOLERANCE", "SUPPORT_RATIO", "TAG", "", "cropThumb", "Landroid/graphics/Bitmap;", "thumb", "cropRect", "Landroid/graphics/Rect;", "getGOPSize", "", "path", "getRatio", "width", "height", "keepPhotoExifInfo", "", "source", "dst", "makePhotoSizeConformity", "maxSize", "", "quality", "bitmap", "savePhotoThumbNail", "compressQuality", "plugin-vlog_release"})
public final class a {
    private static final float GQB = ((b) g.af(b.class)).a(b.a.clicfg_finder_full_screen_inside_radio, 1.7777778f);
    public static final a GQC = new a();

    static {
        AppMethodBeat.i(192226);
        AppMethodBeat.o(192226);
    }

    private a() {
    }

    public static float fEA() {
        AppMethodBeat.i(192222);
        f fVar = f.GHk;
        if (f.fDl()) {
            AppMethodBeat.o(192222);
            return 1.3333334f;
        }
        AppMethodBeat.o(192222);
        return 1.1666666f;
    }

    public static float fEB() {
        return GQB;
    }

    public static void a(int i2, Bitmap bitmap, String str) {
        AppMethodBeat.i(192223);
        p.h(bitmap, "bitmap");
        p.h(str, "path");
        BitmapUtil.saveBitmapToImage(bitmap, i2, Bitmap.CompressFormat.JPEG, str, false);
        int i3 = 0;
        while (0 > 0 && s.boW(str) > 0 && i2 > 0 && i3 <= 5) {
            i2 -= 5;
            BitmapUtil.saveBitmapToImage(bitmap, i2, Bitmap.CompressFormat.JPEG, str, false);
            i3++;
        }
        Log.i("MicroMsg.FinderEditUtil", "makePhotoSizeConformity  maxSize:0  compressQuality:" + i2 + " size:" + s.YS(str));
        AppMethodBeat.o(192223);
    }

    public static void lm(String str, String str2) {
        AppMethodBeat.i(192224);
        p.h(str, "source");
        p.h(str2, "dst");
        c cVar = c.UXg;
        c.lm(str, str2);
        AppMethodBeat.o(192224);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ce, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cf, code lost:
        r4.release();
        com.tencent.matrix.trace.core.AppMethodBeat.o(192225);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A[ExcHandler: all (r0v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:5:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int aUr(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.util.a.aUr(java.lang.String):int");
    }
}
