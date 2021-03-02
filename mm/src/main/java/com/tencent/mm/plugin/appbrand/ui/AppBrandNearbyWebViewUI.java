package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.Properties;

public final class AppBrandNearbyWebViewUI extends WebViewUI {
    private static Boolean isMIUIV8 = null;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(21118);
        if (getIntent() != null) {
            getIntent().putExtra("forceHideShare", true);
            getIntent().putExtra("disable_bounce_scroll", true);
            getIntent().putExtra("show_long_click_popup_menu", false);
            getIntent().putExtra("key_load_js_without_delay", true);
            getIntent().putExtra("geta8key_scene", 41);
        }
        super.onCreate(bundle);
        setResult(-1);
        AppMethodBeat.o(21118);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public final void setMMTitle(String str) {
        AppMethodBeat.i(21119);
        super.setMMTitle(str);
        setMMTitleColor(getContext().getResources().getColor(R.color.FG_0));
        AppMethodBeat.o(21119);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(21120);
        super.initView();
        AppMethodBeat.o(21120);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void bXg() {
        AppMethodBeat.i(21121);
        super.bXg();
        setActionbarColor(-855310);
        AppMethodBeat.o(21121);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final int bXh() {
        AppMethodBeat.i(21122);
        if (Build.VERSION.SDK_INT >= 23 && (!g.isMIUI() || !isMIUIV8())) {
            ao.d(getWindow(), true);
            AppMethodBeat.o(21122);
            return -855310;
        } else if (Build.VERSION.SDK_INT >= 21) {
            int i2 = ac.kEM;
            AppMethodBeat.o(21122);
            return i2;
        } else {
            int bXh = super.bXh();
            AppMethodBeat.o(21122);
            return bXh;
        }
    }

    public static boolean isMIUIV8() {
        AppMethodBeat.i(21123);
        if (isMIUIV8 == null) {
            InputStream inputStream = null;
            try {
                inputStream = s.ao(new o(Environment.getRootDirectory(), "build.prop"));
                Properties properties = new Properties();
                properties.load(inputStream);
                isMIUIV8 = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                isMIUIV8 = Boolean.FALSE;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(21123);
                throw th;
            }
        }
        boolean booleanValue = isMIUIV8.booleanValue();
        AppMethodBeat.o(21123);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean bXi() {
        return true;
    }
}
