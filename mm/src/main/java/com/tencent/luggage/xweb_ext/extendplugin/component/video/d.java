package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.s.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class d extends c<j, TextureImageViewLikeImpl> {
    protected static h.a<j, TextureImageViewLikeImpl> cFK = new h.a<j, TextureImageViewLikeImpl>() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.d.AnonymousClass1 */

        /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.s.h' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.s.g] */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h.a
        public final /* synthetic */ h<TextureImageViewLikeImpl> a(j jVar) {
            AppMethodBeat.i(177176);
            final j jVar2 = jVar;
            AnonymousClass1 r0 = new com.tencent.luggage.xweb_ext.extendplugin.component.d<TextureImageViewLikeImpl>() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.d.AnonymousClass1.AnonymousClass1 */

                static /* synthetic */ void a(AnonymousClass1 r2) {
                    AppMethodBeat.i(215738);
                    r2.l(null);
                    AppMethodBeat.o(215738);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Runnable] */
                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d
                public final /* synthetic */ d.a c(TextureImageViewLikeImpl textureImageViewLikeImpl, Runnable runnable) {
                    AppMethodBeat.i(215736);
                    a aVar = new a(textureImageViewLikeImpl, runnable);
                    AppMethodBeat.o(215736);
                    return aVar;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Runnable] */
                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final /* synthetic */ void e(TextureImageViewLikeImpl textureImageViewLikeImpl, Runnable runnable) {
                    AppMethodBeat.i(215735);
                    TextureImageViewLikeImpl textureImageViewLikeImpl2 = textureImageViewLikeImpl;
                    Log.i(this.cDW, "transferFrom, textureView: ".concat(String.valueOf(textureImageViewLikeImpl2)));
                    super.e(textureImageViewLikeImpl2, runnable);
                    l(runnable);
                    AppMethodBeat.o(215735);
                }

                private void l(Runnable runnable) {
                    AppMethodBeat.i(215734);
                    Surface surface = jVar2.cJT.mSurface;
                    if (surface == null || !surface.isValid()) {
                        Log.w(this.cDW, "transferFrom, originSurface is invalid");
                        if (runnable != null) {
                            Log.i(this.cDW, "transferFrom, run afterTransferFromTask when originSurface is invalid");
                            runnable.run();
                        }
                        AppMethodBeat.o(215734);
                        return;
                    }
                    try {
                        jVar2.e(surface);
                        if (runnable != null) {
                            SurfaceTexture surfaceTexture = jVar2.cJT.mSurfaceTexture;
                            if (surfaceTexture != null) {
                                a(runnable, surfaceTexture);
                                AppMethodBeat.o(215734);
                                return;
                            }
                            Log.i(this.cDW, "transferFrom, run afterTransferFromTask when originSurfaceTexture is null");
                            runnable.run();
                        }
                        AppMethodBeat.o(215734);
                    } catch (Exception e2) {
                        AppMethodBeat.o(215734);
                    }
                }

                /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.video.d$1$1$a */
                class a extends com.tencent.luggage.xweb_ext.extendplugin.component.d<TextureImageViewLikeImpl>.a {
                    private Surface cFP = null;

                    protected a(TextureImageViewLikeImpl textureImageViewLikeImpl, Runnable runnable) {
                        super(textureImageViewLikeImpl, runnable);
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d.a
                    public final boolean b(Surface surface, int i2, int i3) {
                        AppMethodBeat.i(215732);
                        if (this.cFP == null || this.cFP != surface) {
                            try {
                                boolean e2 = jVar2.e(surface);
                                if (e2) {
                                    this.cFP = surface;
                                }
                                AppMethodBeat.o(215732);
                                return e2;
                            } catch (Exception e3) {
                                AppMethodBeat.o(215732);
                                return false;
                            }
                        } else {
                            AppMethodBeat.o(215732);
                            return true;
                        }
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d.a
                    public final void PC() {
                        AppMethodBeat.i(215733);
                        AnonymousClass1.a(AnonymousClass1.this);
                        AppMethodBeat.o(215733);
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final /* synthetic */ View aS(Context context) {
                    AppMethodBeat.i(215737);
                    Log.d(this.cDW, "createVideoContainerView");
                    TextureImageViewLikeImpl textureImageViewLikeImpl = new TextureImageViewLikeImpl(context);
                    jVar2.cJT.cJz = new b(jVar2, textureImageViewLikeImpl);
                    AppMethodBeat.o(215737);
                    return textureImageViewLikeImpl;
                }
            };
            AppMethodBeat.o(177176);
            return r0;
        }
    };
    static com.tencent.mm.plugin.appbrand.jsapi.s.c cFL = new com.tencent.mm.plugin.appbrand.jsapi.s.c() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.d.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.c
        public final a hW(int i2) {
            AppMethodBeat.i(177177);
            com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a();
            aVar.p("videoPlayerId", Integer.valueOf(i2));
            AppMethodBeat.o(177177);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.c
        public final a hX(int i2) {
            AppMethodBeat.i(177178);
            b bVar = new b();
            bVar.p("videoPlayerId", Integer.valueOf(i2));
            AppMethodBeat.o(177178);
            return bVar;
        }
    };
    final g cFM;

    static {
        AppMethodBeat.i(177180);
        AppMethodBeat.o(177180);
    }

    public d(c cVar) {
        super(cVar);
        AppMethodBeat.i(177179);
        this.cFM = new j(cVar);
        AppMethodBeat.o(177179);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final g PI() {
        return this.cFM;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final h.a PJ() {
        return cFK;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.p
    public final com.tencent.mm.plugin.appbrand.jsapi.s.c PK() {
        return cFL;
    }
}
