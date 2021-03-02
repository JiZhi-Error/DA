package com.tencent.mm.plugin.appbrand.d;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintHelper;", "", "()V", "TAG", "", "tryTakeScreenshot", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class a {
    public static final a lbv = new a();

    static {
        AppMethodBeat.i(228152);
        AppMethodBeat.o(228152);
    }

    private a() {
    }

    public static final String b(ag agVar) {
        AppMethodBeat.i(228151);
        p.h(agVar, "pageView");
        Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, pageView:".concat(String.valueOf(agVar)));
        String cacheDir = ((c) g.af(c.class)).getCacheDir();
        if (cacheDir == null) {
            Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, null image cache dir");
            AppMethodBeat.o(228151);
            return null;
        }
        o oVar = new o(cacheDir + '/' + agVar.getAppId() + '_' + System.currentTimeMillis() + ".jpeg");
        agVar.NV();
        String absolutePath = oVar.getAbsolutePath();
        p.g(absolutePath, "tempFile.absolutePath");
        h.RTc.aX(new RunnableC0567a(agVar, absolutePath));
        String aYY = ay.aYY(absolutePath);
        Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, localId:" + aYY + ", imagePath:" + absolutePath);
        AppMethodBeat.o(228151);
        return aYY;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.d.a$a  reason: collision with other inner class name */
    static final class RunnableC0567a implements Runnable {
        final /* synthetic */ ag lbw;
        final /* synthetic */ String lbx;

        RunnableC0567a(ag agVar, String str) {
            this.lbw = agVar;
            this.lbx = str;
        }

        public final void run() {
            AppMethodBeat.i(228150);
            Bitmap bRB = this.lbw.bRB();
            Bitmap bitmap = null;
            if (bRB != null) {
                try {
                    if (!bRB.isRecycled()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        bitmap = BitmapUtil.extractThumbNail(bRB, 640, 640, false, true);
                        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, this.lbx, true);
                        Log.i("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, save bitmap to file:" + this.lbx + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        ((c) g.af(c.class)).WT(this.lbx);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrandComplaintHelper", e2, "tryTakeScreenshot, save bitmap to file fail", new Object[0]);
                    if (bRB != null && !bRB.isRecycled()) {
                        Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(bRB)));
                        bRB.recycle();
                    }
                    if (0 != 0 && !bitmap.isRecycled()) {
                        Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf((Object) null)));
                        bitmap.recycle();
                    }
                    AppMethodBeat.o(228150);
                    return;
                } catch (Throwable th) {
                    if (bRB != null && !bRB.isRecycled()) {
                        Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(bRB)));
                        bRB.recycle();
                    }
                    if (0 != 0 && !bitmap.isRecycled()) {
                        Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf((Object) null)));
                        bitmap.recycle();
                    }
                    AppMethodBeat.o(228150);
                    throw th;
                }
            }
            if (bRB != null && !bRB.isRecycled()) {
                Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle bitmap:".concat(String.valueOf(bRB)));
                bRB.recycle();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                Log.d("MicroMsg.AppBrandComplaintHelper", "tryTakeScreenshot, recycle thumbnail:".concat(String.valueOf(bitmap)));
                bitmap.recycle();
            }
            AppMethodBeat.o(228150);
        }
    }
}
