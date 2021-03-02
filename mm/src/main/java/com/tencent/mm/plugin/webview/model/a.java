package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.regex.Pattern;

public final class a {
    private static final String IXo = ("(http(s)?://" + WeChatHosts.domainString(R.string.e20) + "/(.*)|http(s)?://" + WeChatHosts.domainString(R.string.e1h) + "/(.*)|http(s)?://([^?#&/]*.)?weishi.com/(.*)|http(s)?://([^?#&/]*.)?weishi.qq.com/(.*)|http(s)?://([^?#&/]*.)?view.inews.qq.com/(.*))");
    private static Pattern IXp = null;

    static {
        AppMethodBeat.i(210970);
        AppMethodBeat.o(210970);
    }

    public static void e(MMWebView mMWebView) {
        AppMethodBeat.i(78832);
        if (mMWebView == null) {
            Log.e("MicroMsg.AutoPlayLogic", "webView null");
            AppMethodBeat.o(78832);
            return;
        }
        String url = mMWebView.getUrl();
        Log.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", url);
        if (Util.isNullOrNil(url)) {
            AppMethodBeat.o(78832);
            return;
        }
        a(mMWebView, url);
        AppMethodBeat.o(78832);
    }

    public static void a(final MMWebView mMWebView, final String str) {
        AppMethodBeat.i(210969);
        if (mMWebView == null) {
            Log.e("MicroMsg.AutoPlayLogic", "webView null");
            AppMethodBeat.o(210969);
            return;
        }
        Log.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(210969);
        } else if (str.startsWith(c.getScheme())) {
            AppMethodBeat.o(210969);
        } else {
            p.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.model.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(78831);
                    final boolean gi = a.gi(str);
                    p.y(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.model.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(78830);
                            if (gi) {
                                a.a(mMWebView, true);
                                Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
                                AppMethodBeat.o(78830);
                                return;
                            }
                            a.a(mMWebView, false);
                            Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
                            AppMethodBeat.o(78830);
                        }
                    });
                    AppMethodBeat.o(78831);
                }
            });
            AppMethodBeat.o(210969);
        }
    }

    static /* synthetic */ boolean gi(String str) {
        AppMethodBeat.i(78833);
        if (IXp == null) {
            String a2 = ((b) g.af(b.class)).a(b.a.clicfg_webview_auto_play_list, IXo);
            Log.i("MicroMsg.AutoPlayLogic", "autoPlayHostsStr config:%s", a2);
            IXp = Pattern.compile(a2);
        }
        if (IXp == null) {
            Log.i("MicroMsg.AutoPlayLogic", "autoPlayHostsPattern is null");
        } else if (IXp.matcher(str).find()) {
            AppMethodBeat.o(78833);
            return true;
        }
        AppMethodBeat.o(78833);
        return false;
    }

    static /* synthetic */ void a(MMWebView mMWebView, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(78834);
        mMWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        mMWebView.getSettings().setVideoPlaybackRequiresUserGesture(!z);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_webview_audio_autoplay, 0);
        Log.i("MicroMsg.AutoPlayLogic", "enableAutoPlay audioAutoPlayControl:%d, enable:%b", Integer.valueOf(a2), Boolean.valueOf(z));
        if (a2 == 1) {
            z settings = mMWebView.getSettings();
            if (z) {
                z2 = false;
            }
            settings.setAudioPlaybackRequiresUserGesture(z2);
        }
        AppMethodBeat.o(78834);
    }
}
