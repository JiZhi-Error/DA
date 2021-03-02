package com.tencent.mm.plugin.game.luggage.g;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader_app.api.e;
import com.tencent.mm.plugin.game.luggage.e.a;
import com.tencent.mm.plugin.game.luggage.e.a.b;
import com.tencent.mm.plugin.game.luggage.e.a.c;
import com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public final class g extends m {
    private i xxA;
    private b xyc;
    private com.tencent.mm.plugin.game.luggage.e.b xyd;
    private c xye;
    private DownloadProgressImageView xyf;
    private RedDotView xyg;
    private e xyh;

    static /* synthetic */ b b(g gVar) {
        AppMethodBeat.i(83133);
        b h5GameMenuHelp = gVar.getH5GameMenuHelp();
        AppMethodBeat.o(83133);
        return h5GameMenuHelp;
    }

    public g(i iVar) {
        super(iVar);
        boolean z;
        AppMethodBeat.i(180138);
        this.xxA = iVar;
        if (this.xxA.mParams.getBoolean("from_find_more_friend", false)) {
            View inflate = aa.jQ(getContext()).inflate(R.layout.aof, (ViewGroup) this.IUk, false);
            this.xyf = (DownloadProgressImageView) inflate.findViewById(R.id.buf);
            this.xyg = (RedDotView) inflate.findViewById(R.id.buh);
            this.IUk.addView(inflate, 0);
            dTJ();
            this.xyh = new e() {
                /* class com.tencent.mm.plugin.game.luggage.g.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.downloader_app.api.e
                public final void onChange(final boolean z) {
                    AppMethodBeat.i(180137);
                    g.this.post(new Runnable() {
                        /* class com.tencent.mm.plugin.game.luggage.g.g.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(180136);
                            if (z) {
                                g.this.xyg.setVisibility(0);
                                AppMethodBeat.o(180136);
                                return;
                            }
                            g.this.xyg.setVisibility(8);
                            AppMethodBeat.o(180136);
                        }
                    });
                    AppMethodBeat.o(180137);
                }
            };
            ((com.tencent.mm.plugin.downloader_app.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.xyh);
        }
        if (iVar.mParams.getInt("share_report_from_scene", -1) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            setBackBtn(R.raw.actionbar_icon_light_back);
        }
        AppMethodBeat.o(180138);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void onDestroy() {
        AppMethodBeat.i(180139);
        super.onDestroy();
        ((com.tencent.mm.plugin.downloader_app.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.xyh);
        AppMethodBeat.o(180139);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void onForeground() {
        AppMethodBeat.i(180140);
        super.onForeground();
        dTJ();
        AppMethodBeat.o(180140);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final n getMenuHelp() {
        AppMethodBeat.i(83128);
        if (this.IUo == null) {
            this.IUo = new a();
        }
        n nVar = this.IUo;
        AppMethodBeat.o(83128);
        return nVar;
    }

    private b getH5GameMenuHelp() {
        AppMethodBeat.i(83129);
        if (this.xyc == null) {
            this.xyc = new b(this.xxA.mParams.getString("game_hv_menu_appid"));
        }
        b bVar = this.xyc;
        AppMethodBeat.o(83129);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void dTG() {
        AppMethodBeat.i(83130);
        this.xxA.hb(!(this.xxA instanceof a));
        AppMethodBeat.o(83130);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void dTH() {
        long j2;
        AppMethodBeat.i(83131);
        boolean z = false;
        if (getContext() instanceof MMActivity) {
            z = ((MMActivity) getContext()).hideVKBHavingResult();
        }
        AnonymousClass1 r2 = new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(83127);
                if (Util.isNullOrNil(g.this.xxA.mParams.getString("game_hv_menu_appid"))) {
                    g.this.xyd = new com.tencent.mm.plugin.game.luggage.e.b(g.this.xxA, g.this.getMenuHelp());
                    AppMethodBeat.o(83127);
                    return;
                }
                g.this.xye = new c(g.this.xxA, g.b(g.this));
                AppMethodBeat.o(83127);
            }
        };
        if (z) {
            j2 = 100;
        } else {
            j2 = 0;
        }
        MMHandlerThread.postToMainThreadDelayed(r2, j2);
        AppMethodBeat.o(83131);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void dTI() {
        AppMethodBeat.i(83132);
        if (this.xyd != null) {
            this.xyd.gca();
        }
        if (this.xye != null) {
            c cVar = this.xye;
            if (cVar.xxC != null) {
                cVar.xxC.bMo();
            }
        }
        AppMethodBeat.o(83132);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void pK(boolean z) {
        AppMethodBeat.i(186952);
        super.pK(z);
        if (this.xyf != null) {
            this.xyf.setDarkMode(z);
        }
        AppMethodBeat.o(186952);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.m
    public final void setAlpha(float f2) {
        AppMethodBeat.i(186953);
        super.setAlpha(f2);
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            AppMethodBeat.o(186953);
            return;
        }
        int i2 = (int) (255.0f * f2);
        if (this.xyf != null) {
            this.xyf.setImageAlpha(i2);
        }
        AppMethodBeat.o(186953);
    }

    private void dTJ() {
        AppMethodBeat.i(180141);
        if (this.xyg == null) {
            AppMethodBeat.o(180141);
        } else if (((com.tencent.mm.plugin.downloader_app.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).cBT()) {
            this.xyg.setVisibility(0);
            AppMethodBeat.o(180141);
        } else {
            this.xyg.setVisibility(8);
            AppMethodBeat.o(180141);
        }
    }
}
