package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class o {
    static Map<String, Bundle> Jgg = new HashMap();
    private final long EKO = 175;
    boolean Jkf = false;
    WebViewUI Jkg;
    View Jkh = null;
    private View Jki = null;
    private TextView Jkj = null;
    private long Jkk = SystemClock.elapsedRealtime();
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    String nKc;
    MMWebView webView;

    static /* synthetic */ String bax(String str) {
        AppMethodBeat.i(175836);
        String ahz = ahz(str);
        AppMethodBeat.o(175836);
        return ahz;
    }

    static {
        AppMethodBeat.i(175837);
        AppMethodBeat.o(175837);
    }

    public o(WebViewUI webViewUI) {
        AppMethodBeat.i(175830);
        this.Jkg = webViewUI;
        AppMethodBeat.o(175830);
    }

    /* access modifiers changed from: package-private */
    public final boolean ggd() {
        AppMethodBeat.i(80401);
        if (this.Jkg.bXi()) {
            AppMethodBeat.o(80401);
            return true;
        }
        Intent intent = this.Jkg.getIntent();
        if (intent != null) {
            if (intent.getBooleanExtra("disable_light_actionbar_style", false)) {
                Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
                AppMethodBeat.o(80401);
                return true;
            }
            String stringExtra = intent.getStringExtra("status_bar_style");
            if (!Util.isNullOrNil(stringExtra) && stringExtra.equals("black")) {
                Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
                AppMethodBeat.o(80401);
                return true;
            } else if (intent.getIntExtra("customize_status_bar_color", 0) != 0) {
                Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
                AppMethodBeat.o(80401);
                return true;
            } else if (intent.getBooleanExtra("open_custom_style_url", false)) {
                Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
                AppMethodBeat.o(80401);
                return true;
            } else if (intent.getBooleanExtra("show_full_screen", false)) {
                Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
                AppMethodBeat.o(80401);
                return true;
            }
        }
        AppMethodBeat.o(80401);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void gge() {
        AppMethodBeat.i(80402);
        ggg();
        ggf();
        ggh();
        AppMethodBeat.o(80402);
    }

    @SuppressLint({"ResourceType"})
    private void ggf() {
        AppMethodBeat.i(80403);
        View findViewById = this.Jkg.findViewById(R.id.jkx);
        if (findViewById != null) {
            findViewById.setBackgroundColor(ggj());
        }
        int color = this.Jkg.getResources().getColor(R.color.afm);
        View findViewById2 = this.Jkg.findViewById(R.id.js2);
        if (findViewById2 != null && (findViewById2 instanceof TextView)) {
            ((TextView) findViewById2).setTextColor(color);
        }
        View findViewById3 = this.Jkg.findViewById(R.id.dy_);
        if (findViewById3 != null && (findViewById3 instanceof TextView)) {
            ((TextView) findViewById3).setTextColor(color);
        }
        View findViewById4 = this.Jkg.findViewById(R.id.js1);
        if (findViewById4 != null && (findViewById4 instanceof ImageView)) {
            ((ImageView) findViewById4).setImageResource(R.raw.webview_logo_qqbrowser_light);
        }
        AppMethodBeat.o(80403);
    }

    private void ggg() {
        AppMethodBeat.i(80404);
        if (this.Jkg.VgT.VgK.ITX) {
            AppMethodBeat.o(80404);
            return;
        }
        this.Jkg.setActionbarColor(ggj());
        AppMethodBeat.o(80404);
    }

    public final void ggh() {
        AppMethodBeat.i(80405);
        if (!ggi()) {
            this.Jkg.showActionbarLine();
            AppMethodBeat.o(80405);
        } else if (this.webView == null || this.webView.getWebScrollY() <= 0) {
            this.Jkg.hideActionbarLine();
            AppMethodBeat.o(80405);
        } else {
            this.Jkg.showActionbarLine();
            AppMethodBeat.o(80405);
        }
    }

    private boolean ggi() {
        AppMethodBeat.i(80406);
        if (this.Jkg == null) {
            AppMethodBeat.o(80406);
            return false;
        }
        String str = this.nKc;
        if (Util.isNullOrNil(str)) {
            str = this.Jkg.coX();
        }
        boolean bbr = k.bbr(str);
        AppMethodBeat.o(80406);
        return bbr;
    }

    public final int ggj() {
        AppMethodBeat.i(80407);
        if (ggi()) {
            int color = this.Jkg.getResources().getColor(R.color.afl);
            AppMethodBeat.o(80407);
            return color;
        }
        int color2 = this.Jkg.getResources().getColor(R.color.aff);
        AppMethodBeat.o(80407);
        return color2;
    }

    public final void bd(final Bundle bundle) {
        AppMethodBeat.i(175831);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(175825);
                if (o.this.Jkg == null || o.this.Jkg.isFinishing()) {
                    AppMethodBeat.o(175825);
                    return;
                }
                boolean z = bundle.getBoolean("key_current_info_show");
                Bundle bundle = (Bundle) o.Jgg.get(o.bax(o.this.nKc));
                if (bundle != null) {
                    bundle.putBoolean("key_current_info_show", z);
                }
                if (z) {
                    o.this.ggl();
                    AppMethodBeat.o(175825);
                    return;
                }
                o.this.ggm();
                AppMethodBeat.o(175825);
            }
        });
        AppMethodBeat.o(175831);
    }

    public final void ggk() {
        AppMethodBeat.i(211199);
        Bundle bundle = Jgg.get(ahz(this.nKc));
        if (bundle == null || this.Jkg == null) {
            ggm();
            AppMethodBeat.o(211199);
        } else if (bundle.getBoolean("key_current_info_show")) {
            ggl();
            AppMethodBeat.o(211199);
        } else {
            ggm();
            AppMethodBeat.o(211199);
        }
    }

    public final void ggl() {
        AppMethodBeat.i(175832);
        Bundle bundle = Jgg.get(ahz(this.nKc));
        if (bundle == null || this.Jkg == null) {
            Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", this.nKc);
            AppMethodBeat.o(175832);
        } else if (this.Jkg.JhT) {
            Log.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
            AppMethodBeat.o(175832);
        } else {
            this.Jkg.getController().setMMTitleVisibility(8);
            if (this.Jkh == null) {
                this.Jkh = this.Jkg.getLayoutInflater().inflate(R.layout.cc0, (ViewGroup) null);
                this.Jki = this.Jkh.findViewById(R.id.jl3);
                this.Jkj = (TextView) this.Jkh.findViewById(R.id.fzg);
                this.Jkj.setTextSize(1, 17.0f);
                View customView = this.Jkg.getController().mActionBar.getCustomView();
                if (customView instanceof LinearLayout) {
                    ((LinearLayout) customView).addView(this.Jkh);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Jkh.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.weight = 1.0f;
                    this.Jkh.setLayoutParams(layoutParams);
                } else if (customView instanceof RelativeLayout) {
                    ((RelativeLayout) customView).addView(this.Jkh);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Jkh.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    this.Jkh.setLayoutParams(layoutParams2);
                }
            }
            String string = bundle.getString("key_brand_name");
            final String string2 = bundle.getString("key_brand_user_name");
            Log.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s", string2, string);
            if (Util.isNullOrNil(string) || Util.isNullOrNil(string2)) {
                Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", string2, string);
                AppMethodBeat.o(175832);
                return;
            }
            this.Jkg.setMMTitle("");
            if (this.Jkh.getVisibility() == 8) {
                this.Jkh.setVisibility(4);
            }
            this.Jkj.setText(l.b(this.Jkg, string, this.Jkj.getTextSize()));
            ao.a(this.Jkj.getPaint(), 0.8f);
            this.Jkh.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.o.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(175826);
                    float x = o.this.Jkh.getX();
                    int width = (int) (((float) (o.this.Jkh.getWidth() / 2)) + x);
                    int jn = com.tencent.mm.cb.a.jn(o.this.Jkg) / 2;
                    if (width != jn) {
                        float f2 = ((float) (jn - width)) + x;
                        o.this.Jkh.setX(f2);
                        Log.d("MicroMsg.WebViewUIStyleHelper", "showTopBar x = %f, new x=%f", Float.valueOf(x), Float.valueOf(f2));
                    }
                    if (o.this.Jkh.getVisibility() != 0) {
                        o.this.Jkh.setVisibility(0);
                    }
                    AppMethodBeat.o(175826);
                }
            });
            this.Jki.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.o.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(175828);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (o.this.Jkg == null || o.this.Jkg.Jjm == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(175828);
                    } else if (SystemClock.elapsedRealtime() - o.this.Jkk < 175) {
                        o.this.handler.removeCallbacksAndMessages(null);
                        o.this.Jkg.gfF();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(175828);
                    } else {
                        o.this.Jkk = SystemClock.elapsedRealtime();
                        o.this.handler.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.o.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(175827);
                                o.this.Jkg.Jjm.gx("Contact_Scene", 154);
                                o.this.Jkg.bas(string2);
                                if (o.this.Jkg.IBw != null) {
                                    com.tencent.mm.plugin.webview.d.h hVar = o.this.Jkg.IBw;
                                    if (hVar.GBl) {
                                        hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("topbar:click", null, hVar.IRj, hVar.zpY) + ")", null);
                                    }
                                }
                                o.this.handler.removeCallbacksAndMessages(null);
                                AppMethodBeat.o(175827);
                            }
                        }, 175);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(175828);
                    }
                }
            });
            com.tencent.mm.ui.tools.o.hq(this.Jki);
            AppMethodBeat.o(175832);
        }
    }

    public final void ggm() {
        AppMethodBeat.i(175833);
        this.Jkg.getController().setMMTitleVisibility(0);
        if (this.Jkh != null) {
            this.Jkh.setVisibility(8);
        }
        AppMethodBeat.o(175833);
    }

    static String ahz(String str) {
        AppMethodBeat.i(175834);
        if (str == null || g.af(com.tencent.mm.plugin.brandservice.a.b.class) == null || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(str)) {
            AppMethodBeat.o(175834);
            return str;
        }
        String ahz = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(str);
        AppMethodBeat.o(175834);
        return ahz;
    }

    public static class a {
        public boolean JbC;
        public String Jkn;
        public String Jko;
        public String brandUsername;
        public String iAo;
        public String title;

        public final boolean isDataValid() {
            AppMethodBeat.i(175829);
            if (Util.isNullOrNil(this.Jko) || Util.isNullOrNil(this.Jkn) || Util.isNullOrNil(this.brandUsername) || !this.JbC) {
                AppMethodBeat.o(175829);
                return false;
            }
            AppMethodBeat.o(175829);
            return true;
        }
    }

    public static a baw(String str) {
        String str2;
        AppMethodBeat.i(175835);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(175835);
            return null;
        }
        Bundle bundle = Jgg.get(ahz(str));
        if (bundle == null) {
            AppMethodBeat.o(175835);
            return null;
        }
        String string = bundle.getString("key_brand_name");
        String string2 = bundle.getString("key_brand_user_name");
        String string3 = bundle.getString("key_bag_icon");
        String string4 = bundle.getString("key_title");
        String string5 = bundle.getString("key_cover");
        boolean z = bundle.getBoolean("key_show_menu_onfo", false);
        a aVar = new a();
        aVar.Jko = string3;
        aVar.Jkn = string;
        aVar.brandUsername = string2;
        aVar.JbC = z;
        aVar.title = string4;
        if (Util.isNullOrNil(string5)) {
            str2 = string3;
        } else {
            str2 = string5;
        }
        aVar.iAo = str2;
        AppMethodBeat.o(175835);
        return aVar;
    }
}
