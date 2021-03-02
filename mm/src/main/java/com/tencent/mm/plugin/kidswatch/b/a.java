package com.tencent.mm.plugin.kidswatch.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.kidswatch.a;
import com.tencent.mm.plugin.kidswatch.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/util/KidsWatchUtil;", "", "()V", "TAG", "", "gotoLauncherUI", "", "context", "Landroid/content/Context;", "loginUrl", "isFinish", "", "gotoMiniProgram", "appId", "path", "scene", "", "sceneNote", "marginAdapter", "cardParentLL", "Landroid/widget/LinearLayout;", "buttonParentLL", "setWindowStyle", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "isShowStatusBar", "isShowNavigationBar", "showAlertWhenError", "errCode", "errMsg", "plugin-kidswatch_release"})
public final class a {
    public static final a yBL = new a();

    static {
        AppMethodBeat.i(256388);
        AppMethodBeat.o(256388);
    }

    private a() {
    }

    public static void h(Context context, String str, boolean z) {
        AppMethodBeat.i(256383);
        p.h(context, "context");
        p.h(str, "loginUrl");
        Log.i("KidsWatchUtil", "gotoLauncherUI, context:" + context + ", url:" + str + ", isFinish:" + z);
        if (!z) {
            g.azz().b(new e(str));
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 0);
        c.f(context, ".ui.LauncherUI", intent);
        AppMethodBeat.o(256383);
    }

    public static void c(Context context, int i2, String str) {
        AppMethodBeat.i(256384);
        p.h(context, "context");
        Log.i("KidsWatchUtil", "context:" + context + ", errCode:errCode, errMsg:" + str);
        if (!Util.isNullOrNil(str)) {
            if (str == null) {
                p.hyc();
            }
            if (!n.J(str, "<", false)) {
                h.X(context, str, "");
                AppMethodBeat.o(256384);
                return;
            }
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(context, null, null);
                AppMethodBeat.o(256384);
                return;
            }
            h.n(context, R.string.b3c, 0);
            AppMethodBeat.o(256384);
        } else if (i2 == a.b.ExtDeviceLoginRet_Error.value) {
            h.X(context, context.getString(R.string.eah), "");
            AppMethodBeat.o(256384);
        } else if (i2 == a.b.ExtDeviceLoginRet_Expired.value) {
            h.X(context, context.getString(R.string.eai), "");
            AppMethodBeat.o(256384);
        } else {
            h.X(context, context.getString(R.string.eaj, Integer.valueOf(i2)), "");
            AppMethodBeat.o(256384);
        }
    }

    public static void aq(Activity activity) {
        AppMethodBeat.i(256385);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.i("KidsWatchUtil", "setWindowStyle, activity:" + activity + ", isShowStatusBar:true, isShowNavigationBar: false");
        Window window = activity.getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        p.g(decorView, "activity.window.decorView");
        decorView.setSystemUiVisibility(5890);
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = activity.getWindow();
            p.g(window2, "activity.window");
            window2.setStatusBarColor(0);
            Window window3 = activity.getWindow();
            p.g(window3, "activity.window");
            window3.setNavigationBarColor(0);
        }
        activity.getWindow().setFormat(-3);
        AppMethodBeat.o(256385);
    }

    public static void f(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(256386);
        p.h(context, "context");
        p.h(str, "appId");
        p.h(str2, "path");
        p.h(str3, "sceneNote");
        Log.i("KidsWatchUtil", "gotoMiniProgram, appId:" + str + ", path:" + str2 + ", scene:1180, sceneNote:" + str3);
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.appId = str;
        gVar.kHw = str2;
        gVar.scene = 1180;
        gVar.dCw = str3;
        gVar.iOo = 0;
        ((r) g.af(r.class)).a(context, gVar);
        AppMethodBeat.o(256386);
    }

    public static void a(Context context, LinearLayout linearLayout, LinearLayout linearLayout2) {
        int i2;
        AppMethodBeat.i(256387);
        p.h(context, "context");
        Log.i("KidsWatchUtil", "marginAdapter, context:".concat(String.valueOf(context)));
        int E = at.E(context, com.tencent.h.c.c.getScreenWidth(context));
        int fromDPToPix = at.fromDPToPix(context, 8);
        int fromDPToPix2 = at.fromDPToPix(context, 40);
        if (E >= 375) {
            fromDPToPix = at.fromDPToPix(context, 24);
            i2 = at.fromDPToPix(context, 96);
        } else {
            i2 = fromDPToPix2;
        }
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(256387);
                throw tVar;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = fromDPToPix;
            }
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = fromDPToPix;
            }
            linearLayout.setLayoutParams(layoutParams2);
        }
        if (linearLayout2 != null) {
            ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(256387);
                throw tVar2;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            if (layoutParams4 != null) {
                layoutParams4.bottomMargin = i2;
            }
            linearLayout2.setLayoutParams(layoutParams4);
            AppMethodBeat.o(256387);
            return;
        }
        AppMethodBeat.o(256387);
    }
}
