package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/ui/tools/VoiceStateHolder;", "", "()V", "TAG", "", "enableBackgroundVoice", "", "isNeedStop", "value", "needStop", "getNeedStop", "()Z", "setNeedStop", "(Z)V", "noneStopList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "jumpTo", "", "toWhere", "openAppbrand", "openFloatBallPage", "type", "", "app_release"})
public final class x {
    private static final HashSet<String> Qxi;
    private static boolean Qxj;
    private static boolean Qxk = (((b) g.af(b.class)).a(b.a.clicfg_enable_background_voice, 1) == 1);
    public static final x Qxl = new x();

    static {
        AppMethodBeat.i(231384);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("com.tencent.mm.ui.chatting.gallery.ImageGalleryUI");
        hashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        hashSet.add("com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI");
        hashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewTooLMpUI");
        hashSet.add("com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI");
        hashSet.add("com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI");
        hashSet.add("com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        Qxi = hashSet;
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(0, new e() {
            /* class com.tencent.mm.ui.tools.x.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.ball.c.e
            public final void b(BallInfo ballInfo) {
                AppMethodBeat.i(231381);
                Log.i("MicroMsg.VoiceStateHolder", "onFloatBallInfoClicked, ballInfo:".concat(String.valueOf(ballInfo)));
                if (ballInfo != null) {
                    x xVar = x.Qxl;
                    int i2 = ballInfo.type;
                    Log.i("MicroMsg.VoiceStateHolder", "open ball page type: ".concat(String.valueOf(i2)));
                    switch (i2) {
                        case 6:
                        case 8:
                        case 9:
                        case 17:
                        case 18:
                        case 19:
                            Log.i("MicroMsg.VoiceStateHolder", "need stop set to true for voice/video ball");
                            x.CM(true);
                            AppMethodBeat.o(231381);
                            return;
                        case 7:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        default:
                            Log.i("MicroMsg.VoiceStateHolder", "need stop set to false for other float ball");
                            x.CM(false);
                            AppMethodBeat.o(231381);
                            return;
                    }
                } else {
                    AppMethodBeat.o(231381);
                }
            }

            @Override // com.tencent.mm.plugin.ball.c.e
            public final void c(BallInfo ballInfo) {
            }

            @Override // com.tencent.mm.plugin.ball.c.e
            public final void d(BallInfo ballInfo) {
            }

            @Override // com.tencent.mm.plugin.ball.c.e
            public final void g(BallInfo ballInfo) {
            }
        });
        AppMethodBeat.o(231384);
    }

    private x() {
    }

    public static void CM(boolean z) {
        if (Qxk) {
            Qxj = z;
        }
    }

    public static boolean gXX() {
        if (Qxk) {
            return Qxj;
        }
        return true;
    }

    public static void bnV(String str) {
        AppMethodBeat.i(231382);
        p.h(str, "toWhere");
        Log.i("MicroMsg.VoiceStateHolder", "jump to ".concat(String.valueOf(str)));
        if (Qxi.contains(str)) {
            Log.i("MicroMsg.VoiceStateHolder", "need stop set to false");
            CM(false);
        }
        AppMethodBeat.o(231382);
    }

    public static void gXY() {
        AppMethodBeat.i(231383);
        Log.i("MicroMsg.VoiceStateHolder", "open appBrand");
        CM(false);
        AppMethodBeat.o(231383);
    }
}
