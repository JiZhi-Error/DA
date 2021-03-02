package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.e;
import java.util.HashSet;
import java.util.Set;

public final class b extends f {
    private static final Set<String> IUM;
    private static e lqt = new com.tencent.mm.plugin.ball.c.f() {
        /* class com.tencent.mm.plugin.webview.ui.tools.floatball.b.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(80497);
            b.a(ballInfo);
            AppMethodBeat.o(80497);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
            AppMethodBeat.i(80498);
            Log.i("MicroMsg.WebViewFloatBallHelper", "onFloatBallInfoExposed, ballInfo:%s", ballInfo);
            b.S(ballInfo);
            AppMethodBeat.o(80498);
        }
    };
    private WebViewUI Jkg;
    private boolean JmJ;
    private boolean JmK = false;
    private boolean JmL = false;

    static {
        AppMethodBeat.i(80523);
        HashSet hashSet = new HashSet();
        IUM = hashSet;
        hashSet.add("title");
        IUM.add("webpageTitle");
        IUM.add("hide_option_menu");
        IUM.add("translate_webview");
        IUM.add("srcUsername");
        IUM.add("srcDisplayname");
        IUM.add("mode");
        IUM.add("KTemplateId");
        IUM.add("KPublisherId");
        IUM.add(e.p.Ozw);
        IUM.add(e.p.Ozx);
        IUM.add("pay_channel");
        IUM.add("key_download_restrict");
        IUM.add("key_wallet_region");
        IUM.add("key_function_id");
        IUM.add(e.p.OzA);
        IUM.add("geta8key_scene");
        IUM.add("biz_video_msg_id");
        IUM.add("biz_video_msg_index");
        IUM.add("biz_video_msg_svr_id");
        IUM.add("biz_mp_msg_info");
        IUM.add(e.p.OzI);
        IUM.add("key_menu_hide_expose");
        IUM.add("webviewCurrentProcess");
        AppMethodBeat.o(80523);
    }

    public b(com.tencent.mm.plugin.ball.a.f fVar, WebViewUI webViewUI) {
        super(fVar);
        AppMethodBeat.i(80499);
        this.Jkg = webViewUI;
        Log.i("MicroMsg.WebViewFloatBallHelper", "createFloatBallHelper, WebViewUI:%s", Integer.valueOf(webViewUI.hashCode()));
        AppMethodBeat.o(80499);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        AppMethodBeat.i(185939);
        boolean gbH = this.Jkg.gbH();
        AppMethodBeat.o(185939);
        return gbH;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        AppMethodBeat.i(80501);
        if (!this.Jkg.gbH() || !this.oXA.aGg()) {
            AppMethodBeat.o(80501);
            return false;
        }
        AppMethodBeat.o(80501);
        return true;
    }

    public static boolean isMpUrl(String str) {
        AppMethodBeat.i(80503);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80503);
            return false;
        } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP)) {
            AppMethodBeat.o(80503);
            return true;
        } else {
            AppMethodBeat.o(80503);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(80504);
        this.JmJ = true;
        Log.i("MicroMsg.WebViewFloatBallHelper", "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        ciw().hDa = 3;
        if (this.Jkg.cpI()) {
            ciw().oWx = this.Jkg.getIntent().getIntExtra(e.p.Ozw, 10000);
        } else {
            ciw().oWx = this.Jkg.bLC();
        }
        if (isMpUrl(this.Jkg.coX())) {
            ciw().iNV = this.Jkg.getIntent().getStringExtra("srcUsername");
        }
        Log.d("MicroMsg.WebViewFloatBallHelper", "initReportInfo generateScene %d", Integer.valueOf(ciw().oWx));
        cit();
        if (!(this.oXA.getIntent() == null || this.oWE.jkf == null)) {
            a.b(this.oXA.getIntent(), this.oWE.jkf, IUM);
            cit();
        }
        AppMethodBeat.o(80504);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(int i2) {
        AppMethodBeat.i(80505);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onClose, WebViewUI:%s", Integer.valueOf(this.Jkg.hashCode()));
        boolean wu = super.wu(i2);
        AppMethodBeat.o(80505);
        return wu;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(80506);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onDestroy, WebViewUI:%s", Integer.valueOf(this.Jkg.hashCode()));
        super.onDestroy();
        AppMethodBeat.o(80506);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(80507);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onEnterPage, WebViewUI:%s, isEntered: %b", Integer.valueOf(this.Jkg.hashCode()), Boolean.valueOf(this.JmK));
        if (!this.JmK) {
            this.JmK = true;
            super.bCA();
        }
        AppMethodBeat.o(80507);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGf() {
        AppMethodBeat.i(211205);
        if (!this.JmK) {
            super.aGf();
        }
        AppMethodBeat.o(211205);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(80508);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onExitPage, WebViewUI:%s", Integer.valueOf(this.Jkg.hashCode()));
        if ((this.Jkg instanceof com.tencent.mm.plugin.webview.h.a.a) && ciq()) {
            int cql = ((com.tencent.mm.plugin.webview.h.a.a) this.Jkg).cql();
            if (!(this.oWE == null || this.oWE.jkf == null)) {
                this.oWE.jkf.putInt("BizVideoPlayTime", cql);
                cit();
            }
        }
        super.aGj();
        this.JmK = false;
        AppMethodBeat.o(80508);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(80509);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedBallInfoRemovedEvent, WebViewUI:%s", Integer.valueOf(this.Jkg.hashCode()));
        super.bCB();
        AppMethodBeat.o(80509);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(80510);
        Log.i("MicroMsg.WebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, WebViewUI:%s", Integer.valueOf(this.Jkg.hashCode()));
        this.oXA.hb(false);
        AppMethodBeat.o(80510);
    }

    public static void bCM() {
        AppMethodBeat.i(80511);
        if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(2, lqt);
        }
        AppMethodBeat.o(80511);
    }

    public static void bCN() {
        AppMethodBeat.i(80512);
        if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).b(2, lqt);
        }
        AppMethodBeat.o(80512);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void agT(String str) {
        AppMethodBeat.i(80513);
        if (this.oWE == null || Util.isNullOrNil(this.oWE.name) || this.oWE.name.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || this.oWE.name.startsWith(HttpWrapperBase.PROTOCAL_HTTPS) || Util.isNullOrNil(str) || (!str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS))) {
            super.agT(str);
            AppMethodBeat.o(80513);
            return;
        }
        AppMethodBeat.o(80513);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final BallInfo cim() {
        AppMethodBeat.i(80514);
        BallInfo cim = super.cim();
        AppMethodBeat.o(80514);
        return cim;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void cir() {
        AppMethodBeat.i(80515);
        if (this.JmJ && this.oWG != null) {
            this.oWG.l(this.oWE);
        }
        AppMethodBeat.o(80515);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void cis() {
        AppMethodBeat.i(80516);
        if (this.JmJ && this.oWG != null) {
            this.oWG.j(this.oWE);
        }
        AppMethodBeat.o(80516);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void cit() {
        AppMethodBeat.i(80517);
        if (this.JmJ && this.oWG != null) {
            this.oWG.k(this.oWE);
        }
        AppMethodBeat.o(80517);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        AppMethodBeat.i(211206);
        if (this.JmL || !this.Jkg.gbH()) {
            AppMethodBeat.o(211206);
            return false;
        }
        AppMethodBeat.o(211206);
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean ciy() {
        return true;
    }

    public final void aYt(String str) {
        AppMethodBeat.i(80518);
        ciw().dPJ = str;
        cit();
        AppMethodBeat.o(80518);
    }

    static /* synthetic */ void a(BallInfo ballInfo) {
        String str;
        AppMethodBeat.i(80521);
        if (!(ballInfo == null || ballInfo.jkf == null)) {
            String str2 = ballInfo.key;
            String string = ballInfo.jkf.getString("rawUrl");
            Log.i("MicroMsg.WebViewFloatBallHelper", "handleBallInfoClicked, url:%s", string);
            int i2 = ballInfo.jkf.getInt("minimize_secene", 0);
            int i3 = ballInfo.jkf.getInt(e.p.OzA, -1);
            Intent intent = new Intent();
            a.a(intent, ballInfo.jkf, IUM);
            intent.putExtra("rawUrl", string);
            intent.putExtra("minimize_secene", i2);
            intent.putExtra("float_ball_key", str2);
            intent.putExtra("key_enable_teen_mode_check", true);
            intent.putExtra("webpageTitle", ballInfo.name);
            if (i2 == 1) {
                Log.i("MicroMsg.WebViewFloatBallHelper", "openWebPage, go to jd url");
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("minimize_secene", 1);
                intent.putExtra("KPublisherId", "jd_store");
                h.setPayChannel(9);
                str = ".ui.tools.WebViewUI";
            } else if (i2 == 2) {
                Log.i("MicroMsg.WebViewFloatBallHelper", "openWebPage, go to game url");
                str = ".ui.tools.game.GameWebViewUI";
            } else {
                if (i3 >= 0) {
                    int i4 = ballInfo.jkf.getInt(e.p.Ozw);
                    int i5 = ballInfo.jkf.getInt(e.p.Ozx);
                    if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(i4) && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(MMApplicationContext.getContext(), string, i3, i4, i5, intent)) {
                        Log.i("MicroMsg.WebViewFloatBallHelper", "openWebPage, use fast Load");
                        AppMethodBeat.o(80521);
                        return;
                    }
                }
                str = ".ui.tools.WebViewUI";
            }
            c.b(MMApplicationContext.getContext(), "webview", str, intent);
        }
        AppMethodBeat.o(80521);
    }

    static /* synthetic */ void S(BallInfo ballInfo) {
        AppMethodBeat.i(80522);
        if (!(ballInfo == null || ballInfo.jkf == null)) {
            int i2 = ballInfo.jkf.getInt(e.p.OzA, -1);
            String string = ballInfo.jkf.getString("rawUrl");
            if (i2 >= 0 && !Util.isNullOrNil(string)) {
                String string2 = ballInfo.jkf.getString("srcDisplayname");
                int i3 = ballInfo.jkf.getInt(e.p.Ozw);
                Log.d("MicroMsg.WebViewFloatBallHelper", "addToPreload, name:%s", string2);
                ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(string, i2, i3, new Object[0]);
            }
        }
        AppMethodBeat.o(80522);
    }
}
