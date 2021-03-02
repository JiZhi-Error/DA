package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.snackbar.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class b extends AppBrandProxyUIProcessTask {
    public static final /* synthetic */ MMActivity a(b bVar) {
        AppMethodBeat.i(228247);
        MMActivity bDF = bVar.bDF();
        AppMethodBeat.o(228247);
        return bDF;
    }

    public static final /* synthetic */ void a(b bVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(228246);
        bVar.b(processResult);
        AppMethodBeat.o(228246);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(228245);
        if (!(processRequest instanceof AddImageToFavoritesRequest)) {
            Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "handleRequest#AddImageToFavoritesTask, request is not AddImageToFavoritesRequest");
            AppMethodBeat.o(228245);
            return;
        }
        cz czVar = new cz();
        ((ad) g.af(ad.class)).a(czVar, 6, ((AddImageToFavoritesRequest) processRequest).imagePath);
        EventCenter.instance.publish(czVar);
        boolean z = czVar.dGa.ret == 0;
        Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", "handleRequest#AddImageToFavoritesTask, success: ".concat(String.valueOf(z)));
        AddToFavoritesResult addToFavoritesResult = new AddToFavoritesResult(z);
        e.a(czVar.dGa.ret, bDF(), new a(this, addToFavoritesResult), new DialogInterface$OnClickListenerC0648b(this, addToFavoritesResult), new c(this));
        AppMethodBeat.o(228245);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesTask$handleRequest$1", "Lcom/tencent/mm/ui/widget/snackbar/SnackBar$OnVisibilityChangeListener;", "onHide", "", "onShow", "startHide", "plugin-appbrand-integration_release"})
    public static final class a implements a.c {
        final /* synthetic */ AddToFavoritesResult lxh;
        final /* synthetic */ b lxi;

        a(b bVar, AddToFavoritesResult addToFavoritesResult) {
            this.lxi = bVar;
            this.lxh = addToFavoritesResult;
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void onShow() {
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void onHide() {
            AppMethodBeat.i(228242);
            b.a(this.lxi, this.lxh);
            AppMethodBeat.o(228242);
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.c
        public final void bDY() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b$b  reason: collision with other inner class name */
    static final class DialogInterface$OnClickListenerC0648b implements DialogInterface.OnClickListener {
        final /* synthetic */ AddToFavoritesResult lxh;
        final /* synthetic */ b lxi;

        DialogInterface$OnClickListenerC0648b(b bVar, AddToFavoritesResult addToFavoritesResult) {
            this.lxi = bVar;
            this.lxh = addToFavoritesResult;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228243);
            dialogInterface.dismiss();
            b.a(this.lxi, this.lxh);
            AppMethodBeat.o(228243);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onMessageClick"})
    static final class c implements a.b {
        final /* synthetic */ b lxi;

        c(b bVar) {
            this.lxi = bVar;
        }

        @Override // com.tencent.mm.ui.widget.snackbar.a.b
        public final void bDZ() {
            AppMethodBeat.i(228244);
            hb hbVar = new hb();
            hbVar.dLm.type = 35;
            hbVar.dLm.context = b.a(this.lxi);
            EventCenter.instance.publish(hbVar);
            AppMethodBeat.o(228244);
        }
    }
}
