package com.tencent.mm.plugin.lite.ui;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.a;
import com.tencent.mm.plugin.lite.c;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(2)
@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0014J0\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0002J(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00162\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "START_UI_UN_NEED_DO_ININT", "", "getSTART_UI_UN_NEED_DO_ININT", "()I", "setSTART_UI_UN_NEED_DO_ININT", "(I)V", "START_UI_WITH_DO_INIT", "getSTART_UI_WITH_DO_INIT", "setSTART_UI_WITH_DO_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getLayoutId", "isSameMapContent", "", "m1", "", "m2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "query2Map", SearchIntents.EXTRA_QUERY, "removeDebugInfo", "m", "Companion", "luggage-lite-app_release"})
public final class WxaLiteAppProxyUI extends MMActivity {
    private static boolean yFo = true;
    public static final a yFp = new a((byte) 0);
    private String TAG = "MicroMsg.WxaLiteAppProxyUI";
    private int yFm = 4;
    private int yFn = 5;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI$Companion;", "", "()V", "needetDisplayParams", "", "getNeedetDisplayParams", "()Z", "setNeedetDisplayParams", "(Z)V", "luggage-lite-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(198978);
        AppMethodBeat.o(198978);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    private static Map<String, String> aCW(String str) {
        AppMethodBeat.i(198974);
        HashMap hashMap = new HashMap();
        if (str == null || str.equals("")) {
            HashMap hashMap2 = hashMap;
            AppMethodBeat.o(198974);
            return hashMap2;
        }
        for (String str2 : n.b(str, new String[]{"&"})) {
            List b2 = n.b(str2, new String[]{"="});
            hashMap.put(b2.get(0), b2.get(1));
        }
        HashMap hashMap3 = hashMap;
        AppMethodBeat.o(198974);
        return hashMap3;
    }

    private static Map<String, String> ar(Map<String, String> map) {
        AppMethodBeat.i(198975);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!map.equals("debug") && !map.equals("debugSvr")) {
                hashMap.put(key, value);
            }
        }
        HashMap hashMap2 = hashMap;
        AppMethodBeat.o(198975);
        return hashMap2;
    }

    private static boolean c(Map<String, String> map, Map<String, String> map2) {
        AppMethodBeat.i(198976);
        if (map.size() != map2.size()) {
            AppMethodBeat.o(198976);
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                AppMethodBeat.o(198976);
                return false;
            }
        }
        AppMethodBeat.o(198976);
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        LiteAppCenter.PageInfo pageInfo;
        boolean z;
        AppMethodBeat.i(198977);
        super.onCreate(bundle);
        setActionbarColor(0);
        setNavigationbarColor(0);
        if (com.tencent.mm.plugin.lite.a.yDP.Pv(0)) {
            h.INSTANCE.dN(1404, this.yFn);
        } else {
            h.INSTANCE.dN(1404, this.yFm);
        }
        if (yFo) {
            yFo = false;
            Point az = ao.az(this);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = getWindowManager();
            p.g(windowManager, "getWindowManager()");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = az.x;
            int i3 = az.y;
            float f2 = displayMetrics.density;
            int ay = au.ay(this);
            int aD = au.aD(this);
            float f3 = 48.0f * f2;
            LiteAppCenter.setDisplayParams(((float) i2) / f2, ((float) i3) / f2, ((float) az.x) / f2, ((float) az.y) / f2, displayMetrics.densityDpi, f2, f3 / f2, ((float) ay) / f2, ((float) aD) / f2);
            Log.i(this.TAG, "updateLvCppDisplayParams SetDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f statusBarHeight:%d navigationBarHeight:%d actionBarHeight:%f", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(az.x), Integer.valueOf(az.y), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(f2), Integer.valueOf(ay), Integer.valueOf(aD), Float.valueOf(f3));
            DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
            p.g(displayMetrics2, "getResources().getDisplayMetrics()");
            Rect bl = ao.bl(this);
            LiteAppCenter.setSafeAreaInsets(((float) bl.left) / f2, ((float) bl.top) / f2, ((float) (displayMetrics2.widthPixels - bl.right)) / f2, ((float) (displayMetrics2.heightPixels - bl.bottom)) / f2);
        }
        Parcelable parcelableExtra = getIntent().getParcelableExtra("WxaLiteAppLaunchInfo");
        if (parcelableExtra == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo");
            AppMethodBeat.o(198977);
            throw tVar;
        }
        WxaLiteAppLaunchInfo wxaLiteAppLaunchInfo = (WxaLiteAppLaunchInfo) parcelableExtra;
        Map<String, String> aCW = aCW(wxaLiteAppLaunchInfo.yEx);
        if (!BuildInfo.DEBUG && !WeChatEnvironment.isCoolassistEnv() && n.I(aCW.get("debug"), "1", false)) {
            aCW = ar(aCW);
        }
        a.C1457a aVar = com.tencent.mm.plugin.lite.a.yDP;
        if (!c(aCW, com.tencent.mm.plugin.lite.a.yDO) || n.I(aCW.get("debug"), "1", false)) {
            a.C1457a aVar2 = com.tencent.mm.plugin.lite.a.yDP;
            p.h(aCW, "<set-?>");
            com.tencent.mm.plugin.lite.a.yDO = aCW;
            c.setPath(c.getLastPath(), aCW);
        }
        String str = wxaLiteAppLaunchInfo.path;
        if (str != null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                pageInfo = LiteAppCenter.showView(wxaLiteAppLaunchInfo.appId, str, wxaLiteAppLaunchInfo.query, s.k(wxaLiteAppLaunchInfo.pkgPath, false), wxaLiteAppLaunchInfo.crh);
                Log.i(this.TAG, "show index view result %b", Boolean.valueOf(pageInfo.success));
                HashMap hashMap = new HashMap();
                hashMap.put("activityId", Long.valueOf(pageInfo.appUuid));
                hashMap.put("appId", wxaLiteAppLaunchInfo.appId);
                hashMap.put("appPtr", Long.valueOf(pageInfo.appPtr));
                hashMap.put("pageViewId", Long.valueOf(pageInfo.pageId));
                String str2 = pageInfo.basePath;
                p.g(str2, "page.basePath");
                hashMap.put("basePath", str2);
                hashMap.put("pageRenderPtr", Long.valueOf(pageInfo.renderId));
                hashMap.put("flags", Integer.valueOf(pageInfo.flags));
                hashMap.put("startTime", Long.valueOf(wxaLiteAppLaunchInfo.startTime));
                Intent intent = new Intent(this, WxaLiteAppLiteUI.class);
                intent.addFlags(268435456);
                intent.putExtra("main", "liteApp");
                intent.putExtra("name", String.valueOf(pageInfo.pageId));
                intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, new com.tencent.wxa.d.a(hashMap));
                intent.putExtra("background_mode", "transparent");
                intent.putExtra("bundle", getIntent().getBundleExtra("bundle"));
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                Log.i(this.TAG, "cpan appId%s appPtr:%s pageViewId:%s, pageRenderPtr%s", wxaLiteAppLaunchInfo.appId, Long.valueOf(pageInfo.appPtr), Long.valueOf(pageInfo.pageId), Long.valueOf(pageInfo.renderId));
                finish();
                AppMethodBeat.o(198977);
            }
        }
        pageInfo = LiteAppCenter.showIndexView(wxaLiteAppLaunchInfo.appId, s.k(wxaLiteAppLaunchInfo.pkgPath, true), wxaLiteAppLaunchInfo.crh, wxaLiteAppLaunchInfo.query);
        Log.i(this.TAG, "show index view result %b", Boolean.valueOf(pageInfo.success));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("activityId", Long.valueOf(pageInfo.appUuid));
        hashMap2.put("appId", wxaLiteAppLaunchInfo.appId);
        hashMap2.put("appPtr", Long.valueOf(pageInfo.appPtr));
        hashMap2.put("pageViewId", Long.valueOf(pageInfo.pageId));
        String str22 = pageInfo.basePath;
        p.g(str22, "page.basePath");
        hashMap2.put("basePath", str22);
        hashMap2.put("pageRenderPtr", Long.valueOf(pageInfo.renderId));
        hashMap2.put("flags", Integer.valueOf(pageInfo.flags));
        hashMap2.put("startTime", Long.valueOf(wxaLiteAppLaunchInfo.startTime));
        Intent intent2 = new Intent(this, WxaLiteAppLiteUI.class);
        intent2.addFlags(268435456);
        intent2.putExtra("main", "liteApp");
        intent2.putExtra("name", String.valueOf(pageInfo.pageId));
        intent2.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, new com.tencent.wxa.d.a(hashMap2));
        intent2.putExtra("background_mode", "transparent");
        intent2.putExtra("bundle", getIntent().getBundleExtra("bundle"));
        com.tencent.mm.hellhoundlib.b.a bl22 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl22.axQ(), "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl22.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/lite/ui/WxaLiteAppProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.i(this.TAG, "cpan appId%s appPtr:%s pageViewId:%s, pageRenderPtr%s", wxaLiteAppLaunchInfo.appId, Long.valueOf(pageInfo.appPtr), Long.valueOf(pageInfo.pageId), Long.valueOf(pageInfo.renderId));
        finish();
        AppMethodBeat.o(198977);
    }
}
