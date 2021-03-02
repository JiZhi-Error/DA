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

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a extends AppBrandProxyUIProcessTask {
    public static final /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(228236);
        aVar.b(processResult);
        AppMethodBeat.o(228236);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(228235);
        if (!(processRequest instanceof AddFileToFavoritesRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "handleRequest#AddFileToFavoritesTask, request is not AddFileToFavoritesRequest");
            AppMethodBeat.o(228235);
            return;
        }
        cz czVar = new cz();
        ((ad) g.af(ad.class)).a(czVar, 6, ((AddFileToFavoritesRequest) processRequest).filePath, db.D(((AddFileToFavoritesRequest) processRequest).filePath, ((AddFileToFavoritesRequest) processRequest).gCr, ((AddFileToFavoritesRequest) processRequest).fileName), "");
        EventCenter.instance.publish(czVar);
        boolean z = czVar.dGa.ret == 0;
        Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "handleRequest#AddFileToFavoritesTask, success: ".concat(String.valueOf(z)));
        AddToFavoritesResult addToFavoritesResult = new AddToFavoritesResult(z);
        e.a(czVar.dGa.ret, bDF(), new C0596a(this, addToFavoritesResult), new b(this, addToFavoritesResult), null);
        AppMethodBeat.o(228235);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesTask$handleRequest$1", "Lcom/tencent/mm/ui/widget/snackbar/SnackBar$OnVisibilityChangeListener;", "onHide", "", "onShow", "startHide", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a$a  reason: collision with other inner class name */
    public static final class C0596a implements a.c {
        final /* synthetic */ a lxg;
        final /* synthetic */ AddToFavoritesResult lxh;

        C0596a(a aVar, AddToFavoritesResult addToFavoritesResult) {
            this.lxg = aVar;
            this.lxh = addToFavoritesResult;
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void onShow() {
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void onHide() {
            AppMethodBeat.i(228233);
            a.a(this.lxg, this.lxh);
            AppMethodBeat.o(228233);
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void bDY() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ a lxg;
        final /* synthetic */ AddToFavoritesResult lxh;

        b(a aVar, AddToFavoritesResult addToFavoritesResult) {
            this.lxg = aVar;
            this.lxh = addToFavoritesResult;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228234);
            dialogInterface.dismiss();
            a.a(this.lxg, this.lxh);
            AppMethodBeat.o(228234);
        }
    }
}
