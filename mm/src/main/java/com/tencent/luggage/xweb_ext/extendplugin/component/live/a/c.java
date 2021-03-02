package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class c extends com.tencent.luggage.xweb_ext.extendplugin.component.c<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, TextureImageViewLikeImpl> {
    protected static h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, TextureImageViewLikeImpl> cFK = new h.a<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c, TextureImageViewLikeImpl>() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c.AnonymousClass1 */

        /* Return type fixed from 'com.tencent.mm.plugin.appbrand.jsapi.s.h' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.s.g] */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h.a
        public final /* synthetic */ h<TextureImageViewLikeImpl> a(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c cVar) {
            AppMethodBeat.i(177143);
            final com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c cVar2 = cVar;
            b bVar = cVar2.cFS.cEz;
            if (bVar != null) {
                bVar.f(null);
            }
            AnonymousClass1 r0 = new d<TextureImageViewLikeImpl>() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c.AnonymousClass1.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Runnable] */
                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d
                public final /* synthetic */ d.a c(TextureImageViewLikeImpl textureImageViewLikeImpl, Runnable runnable) {
                    AppMethodBeat.i(215615);
                    a aVar = new a(textureImageViewLikeImpl, runnable);
                    AppMethodBeat.o(215615);
                    return aVar;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Runnable] */
                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d, com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final /* synthetic */ void e(TextureImageViewLikeImpl textureImageViewLikeImpl, Runnable runnable) {
                    AppMethodBeat.i(215614);
                    TextureImageViewLikeImpl textureImageViewLikeImpl2 = textureImageViewLikeImpl;
                    Log.i(this.cDW, "transferFrom, textureView: ".concat(String.valueOf(textureImageViewLikeImpl2)));
                    super.e(textureImageViewLikeImpl2, runnable);
                    Surface surface = cVar2.cFS.mSurface;
                    if (surface == null || !surface.isValid()) {
                        Log.w(this.cDW, "transferFrom, originSurface is invalid");
                        if (runnable != null) {
                            Log.i(this.cDW, "transferFrom, run afterTransferFromTask when originSurface is invalid");
                            runnable.run();
                        }
                        AppMethodBeat.o(215614);
                        return;
                    }
                    try {
                        if (cVar2.e(surface)) {
                            cVar2.bU(cVar2.cFS.cEF, cVar2.cFS.cEG);
                        }
                        if (runnable != null) {
                            SurfaceTexture surfaceTexture = cVar2.cFS.mSurfaceTexture;
                            if (surfaceTexture != null) {
                                a(runnable, surfaceTexture);
                                AppMethodBeat.o(215614);
                                return;
                            }
                            Log.i(this.cDW, "transferFrom, run afterTransferFromTask when originSurfaceTexture is null");
                            runnable.run();
                        }
                        AppMethodBeat.o(215614);
                    } catch (Exception e2) {
                        AppMethodBeat.o(215614);
                    }
                }

                /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c$1$1$a */
                class a extends d<TextureImageViewLikeImpl>.a {
                    private Surface cFP = null;

                    protected a(TextureImageViewLikeImpl textureImageViewLikeImpl, Runnable runnable) {
                        super(textureImageViewLikeImpl, runnable);
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d.a
                    public final boolean b(Surface surface, int i2, int i3) {
                        AppMethodBeat.i(215613);
                        try {
                            if (this.cFP != null && this.cFP == surface) {
                                surface = null;
                            }
                            boolean z = true;
                            if (surface != null && (z = cVar2.e(surface))) {
                                this.cFP = surface;
                            }
                            if (z) {
                                cVar2.bU(i2, i3);
                            }
                            AppMethodBeat.o(215613);
                            return z;
                        } catch (Exception e2) {
                            AppMethodBeat.o(215613);
                            return false;
                        }
                    }

                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.d.a
                    public final void PC() {
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.s.h
                public final /* synthetic */ View aS(Context context) {
                    AppMethodBeat.i(215616);
                    Log.d(this.cDW, "createVideoContainerView");
                    TextureImageViewLikeImpl textureImageViewLikeImpl = new TextureImageViewLikeImpl(context);
                    AppMethodBeat.o(215616);
                    return textureImageViewLikeImpl;
                }
            };
            AppMethodBeat.o(177143);
            return r0;
        }
    };
    static com.tencent.mm.plugin.appbrand.jsapi.s.c cFL = new com.tencent.mm.plugin.appbrand.jsapi.s.c() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.c
        public final a hW(int i2) {
            AppMethodBeat.i(177144);
            b bVar = new b();
            bVar.p("livePlayerId", Integer.valueOf(i2));
            AppMethodBeat.o(177144);
            return bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.c
        public final a hX(int i2) {
            AppMethodBeat.i(177145);
            com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c cVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c();
            cVar.p("livePlayerId", Integer.valueOf(i2));
            AppMethodBeat.o(177145);
            return cVar;
        }
    };
    final g cFM;

    static {
        AppMethodBeat.i(177147);
        AppMethodBeat.o(177147);
    }

    protected c(a aVar) {
        super(aVar);
        AppMethodBeat.i(177146);
        this.cFM = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c(aVar);
        AppMethodBeat.o(177146);
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
