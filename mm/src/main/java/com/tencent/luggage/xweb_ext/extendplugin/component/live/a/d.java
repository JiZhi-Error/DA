package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.sdk.platformtools.Log;

final class d extends c<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View> {
    private h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View> cFR = new h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View>() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.d.AnonymousClass1 */

        /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.s.h' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.s.g] */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h.a
        public final /* synthetic */ h<View> a(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c cVar) {
            AppMethodBeat.i(215624);
            final com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c cVar2 = cVar;
            AnonymousClass1 r0 = new t(d.this.cFS) {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.d.AnonymousClass1.AnonymousClass1 */
                private h<TextureImageViewLikeImpl> cFV = null;

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final View aS(Context context) {
                    AppMethodBeat.i(215617);
                    if (!cVar2.cFS.cFe.get()) {
                        TextureImageViewLikeImpl aS = PZ().aS(context);
                        AppMethodBeat.o(215617);
                        return aS;
                    }
                    View aS2 = super.aS(context);
                    AppMethodBeat.o(215617);
                    return aS2;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void cf(View view) {
                    AppMethodBeat.i(215618);
                    if (cVar2.cFS.cFe.get()) {
                        super.cf(view);
                        AppMethodBeat.o(215618);
                    } else if (view instanceof TextureImageViewLikeImpl) {
                        PZ().cf((TextureImageViewLikeImpl) view);
                        AppMethodBeat.o(215618);
                    } else {
                        Log.w(this.cDW, "recycleVideoContainerView, view is not instanceof TextureImageViewLikeImpl");
                        AppMethodBeat.o(215618);
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final com.tencent.mm.plugin.appbrand.jsapi.s.d Pz() {
                    AppMethodBeat.i(215619);
                    if (!cVar2.cFS.cFe.get()) {
                        com.tencent.mm.plugin.appbrand.jsapi.s.d Pz = PZ().Pz();
                        AppMethodBeat.o(215619);
                        return Pz;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.s.d Pz2 = super.Pz();
                    AppMethodBeat.o(215619);
                    return Pz2;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void d(View view, Runnable runnable) {
                    AppMethodBeat.i(215620);
                    if (cVar2.cFS.cFe.get()) {
                        super.d(view, runnable);
                        AppMethodBeat.o(215620);
                    } else if (!(view instanceof TextureImageViewLikeImpl)) {
                        Log.w(this.cDW, "transferTo, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            Log.i(this.cDW, "transferTo, run afterTransferToTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                        }
                        AppMethodBeat.o(215620);
                    } else {
                        PZ().d((TextureImageViewLikeImpl) view, runnable);
                        AppMethodBeat.o(215620);
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void e(View view, Runnable runnable) {
                    AppMethodBeat.i(215621);
                    if (cVar2.cFS.cFe.get()) {
                        super.e(view, runnable);
                        AppMethodBeat.o(215621);
                    } else if (!(view instanceof TextureImageViewLikeImpl)) {
                        Log.w(this.cDW, "transferFrom, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            Log.i(this.cDW, "transferFrom, run afterTransferFromTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                        }
                        AppMethodBeat.o(215621);
                    } else {
                        PZ().e((TextureImageViewLikeImpl) view, runnable);
                        AppMethodBeat.o(215621);
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void cg(View view) {
                    AppMethodBeat.i(215622);
                    if (cVar2.cFS.cFe.get()) {
                        super.cg(view);
                        AppMethodBeat.o(215622);
                    } else if (!(view instanceof TextureImageViewLikeImpl)) {
                        Log.w(this.cDW, "onPlayEndWorkaround, view is not instanceof TextureImageViewLikeImpl");
                        AppMethodBeat.o(215622);
                    } else {
                        PZ().cg((TextureImageViewLikeImpl) view);
                        AppMethodBeat.o(215622);
                    }
                }

                private h<TextureImageViewLikeImpl> PZ() {
                    AppMethodBeat.i(215623);
                    if (this.cFV == null) {
                        this.cFV = c.cFK.a(cVar2);
                    }
                    h<TextureImageViewLikeImpl> hVar = this.cFV;
                    AppMethodBeat.o(215623);
                    return hVar;
                }
            };
            AppMethodBeat.o(215624);
            return r0;
        }
    };
    final a cFS;
    private final c cFT;

    protected d(a aVar) {
        super(aVar);
        AppMethodBeat.i(215625);
        this.cFS = aVar;
        this.cFT = new c(aVar);
        AppMethodBeat.o(215625);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final g PI() {
        return this.cFT.cFM;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, View> PJ() {
        return this.cFR;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final com.tencent.mm.plugin.appbrand.jsapi.s.c PK() {
        return c.cFL;
    }
}
