package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class c extends AppBrandProxyUIProcessTask {
    public static final /* synthetic */ void a(c cVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(228260);
        cVar.b(processResult);
        AppMethodBeat.o(228260);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        boolean z;
        AppMethodBeat.i(228259);
        if (!(processRequest instanceof AddVideoToFavoritesRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "handleRequest#AddVideoToFavoritesTask, request is not AddVideoToFavoritesRequest");
            AppMethodBeat.o(228259);
            return;
        }
        cz czVar = new cz();
        int Zj = dc.Zj(((AddVideoToFavoritesRequest) processRequest).videoPath);
        if (Zj <= 0) {
            Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "handleRequest#AddVideoToFavoritesTask, durationS: ".concat(String.valueOf(Zj)));
            b(new AddToFavoritesResult(false));
            AppMethodBeat.o(228259);
            return;
        }
        String dm = dc.dm(((AddVideoToFavoritesRequest) processRequest).videoPath, ((AddVideoToFavoritesRequest) processRequest).thumbPath);
        String str = dm;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "handleRequest#AddVideoToFavoritesTask, thumbPath is empty");
            b(new AddToFavoritesResult(false));
            AppMethodBeat.o(228259);
            return;
        }
        ((ad) g.af(ad.class)).a(czVar, ((AddVideoToFavoritesRequest) processRequest).videoPath, dm, Zj, "", "");
        EventCenter.instance.publish(czVar);
        boolean z2 = czVar.dGa.ret == 0;
        Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "handleRequest#AddVideoToFavoritesTask, success: ".concat(String.valueOf(z2)));
        AddToFavoritesResult addToFavoritesResult = new AddToFavoritesResult(z2);
        e.a(czVar.dGa.ret, bDF(), new a(this, addToFavoritesResult), new b(this, addToFavoritesResult), null);
        AppMethodBeat.o(228259);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesTask$handleRequest$1", "Lcom/tencent/mm/ui/widget/snackbar/SnackBar$OnVisibilityChangeListener;", "onHide", "", "onShow", "startHide", "plugin-appbrand-integration_release"})
    public static final class a implements a.c {
        final /* synthetic */ AddToFavoritesResult lxh;
        final /* synthetic */ c lxj;

        a(c cVar, AddToFavoritesResult addToFavoritesResult) {
            this.lxj = cVar;
            this.lxh = addToFavoritesResult;
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void onShow() {
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void onHide() {
            AppMethodBeat.i(228257);
            c.a(this.lxj, this.lxh);
            AppMethodBeat.o(228257);
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void bDY() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ AddToFavoritesResult lxh;
        final /* synthetic */ c lxj;

        b(c cVar, AddToFavoritesResult addToFavoritesResult) {
            this.lxj = cVar;
            this.lxh = addToFavoritesResult;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228258);
            dialogInterface.dismiss();
            c.a(this.lxj, this.lxh);
            AppMethodBeat.o(228258);
        }
    }
}
