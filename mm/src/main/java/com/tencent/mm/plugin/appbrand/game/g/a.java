package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.game.f.a.d;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.x;

final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.game.g.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0587a {
        protected WeakReference<MagicBrushView> luG;

        /* access modifiers changed from: package-private */
        public abstract void a(b.AbstractC0588b bVar);

        /* access modifiers changed from: package-private */
        public abstract void a(c.b bVar, d<String> dVar);

        /* access modifiers changed from: package-private */
        public abstract void a(d<String> dVar);

        /* access modifiers changed from: package-private */
        public abstract void b(d<String> dVar);

        public abstract VideoTransPara bDA();

        /* access modifiers changed from: package-private */
        public abstract void bDz();

        /* access modifiers changed from: package-private */
        public abstract void c(d<String> dVar);

        /* access modifiers changed from: package-private */
        public abstract void d(d<String> dVar);

        /* synthetic */ AbstractC0587a(MagicBrushView magicBrushView, byte b2) {
            this(magicBrushView);
        }

        private AbstractC0587a(MagicBrushView magicBrushView) {
            this.luG = new WeakReference<>(magicBrushView);
        }

        public final MagicBrushView bDB() {
            return this.luG.get();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends AbstractC0587a {
        com.tencent.mm.media.widget.c.c luH = null;
        b.AbstractC0588b luI = null;
        private VideoTransPara luJ = null;

        b(MagicBrushView magicBrushView) {
            super(magicBrushView, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        @SuppressLint({"DefaultLocale"})
        public final void a(c.b bVar, d<String> dVar) {
            AppMethodBeat.i(45315);
            MagicBrushView magicBrushView = (MagicBrushView) this.luG.get();
            if (magicBrushView == null) {
                dVar.a(1, 111, "magic brush view not found", "");
                AppMethodBeat.o(45315);
                return;
            }
            d dVar2 = (d) magicBrushView.getRendererView();
            if (dVar2 == null) {
                dVar.a(1, 111, "texture view not found", "");
                AppMethodBeat.o(45315);
                return;
            }
            if (!dVar2.isAvailable()) {
                dVar.a(1, 111, "view not prepared", "");
            }
            this.luJ = new VideoTransPara();
            this.luJ.videoBitrate = bVar.bitrate;
            this.luJ.width = bVar.width;
            this.luJ.height = bVar.height;
            this.luJ.fps = bVar.fps;
            this.luJ.iiH = bVar.gop;
            this.luJ.iSV = 1;
            this.luJ.iSU = 2;
            this.luJ.duration = bVar.duration;
            this.luJ.audioBitrate = 64000;
            this.luJ.audioSampleRate = 44100;
            this.luJ.iTf = 200;
            Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", this.luJ);
            this.luH = new com.tencent.mm.media.widget.c.c(this.luJ, dVar2.getAbsSurfaceRenderer(), dVar2.getEGLContext(), dVar2.getPreviewTextureId(), new c.a() {
                /* class com.tencent.mm.plugin.appbrand.game.g.a.b.AnonymousClass1 */

                @Override // com.tencent.mm.media.widget.c.c.a
                public final void zV(long j2) {
                    AppMethodBeat.i(45312);
                    synchronized (this) {
                        try {
                            if (b.this.luI != null) {
                                b.this.luI.Bc(j2 / 1000);
                            }
                        } finally {
                            AppMethodBeat.o(45312);
                        }
                    }
                }
            });
            if (bVar.lvz == null) {
                AppMethodBeat.o(45315);
            } else if (bVar.lvy == null) {
                AppMethodBeat.o(45315);
            } else {
                Log.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
                this.luH.setMute(true);
                this.luH.s(dVar2.getSurfaceWidth(), dVar2.getSurfaceHeight(), this.luJ.width, this.luJ.height);
                this.luH.setFilePath(bVar.lvz.getAbsolutePath());
                this.luH.rC(0);
                int b2 = this.luH.b(0, false, 0);
                if (b2 != 0) {
                    dVar.a(1, 110, String.format("media recoder start failed: %d", Integer.valueOf(b2)), "");
                    AppMethodBeat.o(45315);
                    return;
                }
                this.luH.ish = true;
                dVar2.setOnTextureDrawFinishDelegate(new kotlin.g.a.b<com.tencent.mm.media.g.d, x>() {
                    /* class com.tencent.mm.plugin.appbrand.game.g.a.b.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(com.tencent.mm.media.g.d dVar) {
                        AppMethodBeat.i(45313);
                        b.this.luH.aQG();
                        AppMethodBeat.o(45313);
                        return null;
                    }
                });
                Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
                dVar.a(0, 0, "ok", "");
                AppMethodBeat.o(45315);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final void a(final d<String> dVar) {
            AppMethodBeat.i(45316);
            if (this.luH == null) {
                dVar.a(1, -1, "no recorder", "");
                AppMethodBeat.o(45316);
                return;
            }
            this.luH.E(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.game.g.a.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(45314);
                    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
                    b.this.luH.clear();
                    dVar.a(0, 0, "ok", "");
                    AppMethodBeat.o(45314);
                }
            });
            AppMethodBeat.o(45316);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final void b(d<String> dVar) {
            AppMethodBeat.i(45317);
            if (this.luH == null) {
                dVar.a(1, -1, "no recorder", "");
                AppMethodBeat.o(45317);
                return;
            }
            this.luH.pause();
            dVar.a(0, 0, "ok", "");
            AppMethodBeat.o(45317);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final void c(d<String> dVar) {
            AppMethodBeat.i(45318);
            if (this.luH == null) {
                dVar.a(1, -1, "no recorder", "");
                AppMethodBeat.o(45318);
                return;
            }
            MagicBrushView magicBrushView = (MagicBrushView) this.luG.get();
            if (magicBrushView == null) {
                dVar.a(1, 111, "magic brush view not found", "");
                AppMethodBeat.o(45318);
                return;
            }
            d dVar2 = (d) magicBrushView.getRendererView();
            if (dVar2 == null) {
                dVar.a(1, 111, "texture view not found", "");
                AppMethodBeat.o(45318);
                return;
            }
            if (!dVar2.isAvailable()) {
                dVar.a(1, 111, "view not prepared", "");
            }
            this.luH.M(0, dVar2.getSurfaceWidth(), dVar2.getSurfaceHeight());
            dVar.a(0, 0, "ok", "");
            AppMethodBeat.o(45318);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final void a(b.AbstractC0588b bVar) {
            synchronized (this) {
                this.luI = bVar;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final void bDz() {
            synchronized (this) {
                this.luI = null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final void d(d<String> dVar) {
            AppMethodBeat.i(45319);
            if (this.luH != null) {
                this.luH.cancel();
                this.luH.clear();
            }
            dVar.a(0, 0, "ok", "");
            AppMethodBeat.o(45319);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.game.g.a.AbstractC0587a
        public final VideoTransPara bDA() {
            return this.luJ;
        }
    }
}
