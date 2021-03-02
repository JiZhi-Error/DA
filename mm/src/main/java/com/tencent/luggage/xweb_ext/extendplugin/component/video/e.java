package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class e extends c<j, View> {
    private h.a<j, View> cFR = new h.a<j, View>() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.e.AnonymousClass1 */

        /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.s.h' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.s.g] */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h.a
        public final /* synthetic */ h<View> a(j jVar) {
            AppMethodBeat.i(215746);
            final j jVar2 = jVar;
            AnonymousClass1 r0 = new t(e.this.cJT) {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.e.AnonymousClass1.AnonymousClass1 */
                private h<TextureImageViewLikeImpl> cFV = null;

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final View aS(Context context) {
                    AppMethodBeat.i(215739);
                    if (!jVar2.cJT.cFe.get()) {
                        TextureImageViewLikeImpl aS = PZ().aS(context);
                        AppMethodBeat.o(215739);
                        return aS;
                    }
                    View aS2 = super.aS(context);
                    AppMethodBeat.o(215739);
                    return aS2;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void cf(View view) {
                    AppMethodBeat.i(215740);
                    if (jVar2.cJT.cFe.get()) {
                        super.cf(view);
                        AppMethodBeat.o(215740);
                    } else if (view instanceof TextureImageViewLikeImpl) {
                        PZ().cf((TextureImageViewLikeImpl) view);
                        AppMethodBeat.o(215740);
                    } else {
                        Log.w(this.cDW, "recycleVideoContainerView, view is not instanceof TextureImageViewLikeImpl");
                        AppMethodBeat.o(215740);
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final d Pz() {
                    AppMethodBeat.i(215741);
                    if (!jVar2.cJT.cFe.get()) {
                        d Pz = PZ().Pz();
                        AppMethodBeat.o(215741);
                        return Pz;
                    }
                    d Pz2 = super.Pz();
                    AppMethodBeat.o(215741);
                    return Pz2;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void d(View view, Runnable runnable) {
                    AppMethodBeat.i(215742);
                    if (jVar2.cJT.cFe.get()) {
                        super.d(view, runnable);
                        AppMethodBeat.o(215742);
                    } else if (!(view instanceof TextureImageViewLikeImpl)) {
                        Log.w(this.cDW, "transferTo, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            Log.i(this.cDW, "transferTo, run afterTransferToTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                        }
                        AppMethodBeat.o(215742);
                    } else {
                        PZ().d((TextureImageViewLikeImpl) view, runnable);
                        AppMethodBeat.o(215742);
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void e(View view, Runnable runnable) {
                    AppMethodBeat.i(215743);
                    if (jVar2.cJT.cFe.get()) {
                        super.e(view, runnable);
                        AppMethodBeat.o(215743);
                    } else if (!(view instanceof TextureImageViewLikeImpl)) {
                        Log.w(this.cDW, "transferFrom, view is not instanceof TextureImageViewLikeImpl");
                        if (runnable != null) {
                            Log.i(this.cDW, "transferFrom, run afterTransferFromTask when view is not instanceof TextureImageViewLikeImpl");
                            runnable.run();
                        }
                        AppMethodBeat.o(215743);
                    } else {
                        PZ().e((TextureImageViewLikeImpl) view, runnable);
                        AppMethodBeat.o(215743);
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.t, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final void cg(View view) {
                    AppMethodBeat.i(215744);
                    if (jVar2.cJT.cFe.get()) {
                        super.cg(view);
                        AppMethodBeat.o(215744);
                    } else if (!(view instanceof TextureImageViewLikeImpl)) {
                        Log.w(this.cDW, "onPlayEndWorkaround, view is not instanceof TextureImageViewLikeImpl");
                        AppMethodBeat.o(215744);
                    } else {
                        PZ().cg((TextureImageViewLikeImpl) view);
                        AppMethodBeat.o(215744);
                    }
                }

                private h<TextureImageViewLikeImpl> PZ() {
                    AppMethodBeat.i(215745);
                    if (this.cFV == null) {
                        this.cFV = d.cFK.a(jVar2);
                    }
                    h<TextureImageViewLikeImpl> hVar = this.cFV;
                    AppMethodBeat.o(215745);
                    return hVar;
                }
            };
            AppMethodBeat.o(215746);
            return r0;
        }
    };
    final c cJT;
    private final d cJU;

    public e(c cVar) {
        super(cVar);
        AppMethodBeat.i(215747);
        this.cJT = cVar;
        this.cJU = new d(cVar);
        AppMethodBeat.o(215747);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final g PI() {
        return this.cJU.cFM;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final h.a<j, View> PJ() {
        return this.cFR;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final com.tencent.mm.plugin.appbrand.jsapi.s.c PK() {
        return d.cFL;
    }
}
