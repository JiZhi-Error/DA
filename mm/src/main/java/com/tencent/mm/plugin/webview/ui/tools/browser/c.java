package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J*\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseReporter;", "", "()V", "TAG", "", "reportBrowserChooseDialogAction", "", "sessionId", "", NativeProtocol.WEB_DIALOG_ACTION, "", "browserCount", "reportBrowserChooseDialogClickBrowser", "clickPosition", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "reportBrowserSettingDialogAction", "reportBrowserSettingDialogResult", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "ChooseDialogAction", "SettingDialogAction", "plugin-webview_release"})
public final class c {
    public static final c JlC = new c();

    static {
        AppMethodBeat.i(210420);
        AppMethodBeat.o(210420);
    }

    private c() {
    }

    public static final void q(long j2, int i2, int i3) {
        AppMethodBeat.i(210416);
        Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserChooseDialogAction action: " + i2 + ", browserCount: " + i3);
        h.INSTANCE.a(21454, Integer.valueOf(i2), 0, 0, "", Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.o(210416);
    }

    public static final void a(long j2, int i2, int i3, ResolveInfo resolveInfo) {
        String str;
        AppMethodBeat.i(210417);
        if (resolveInfo == null) {
            AppMethodBeat.o(210417);
            return;
        }
        StringBuilder append = new StringBuilder("alvinluo reportBrowserChooseDialogClickBrowser clickPosition: ").append(i2).append(", browserCount: ").append(i3).append(", packageName: ");
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        Log.v("MicroMsg.BrowserChooseReporter", append.append(activityInfo != null ? activityInfo.packageName : null).toString());
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[6];
        objArr[0] = 2;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = 0;
        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
        if (activityInfo2 == null || (str = activityInfo2.packageName) == null) {
            str = "";
        }
        objArr[3] = str;
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Long.valueOf(j2);
        hVar.a(21454, objArr);
        AppMethodBeat.o(210417);
    }

    public static final void r(long j2, int i2, int i3) {
        AppMethodBeat.i(210418);
        Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogAction action: " + i2 + ", browserCount: " + i3);
        h.INSTANCE.a(21458, Integer.valueOf(i2), 0, "", Integer.valueOf(i3), 0, Long.valueOf(j2));
        AppMethodBeat.o(210418);
    }

    public static final void a(long j2, f fVar, int i2, int i3) {
        int i4;
        String str;
        ActivityInfo activityInfo;
        AppMethodBeat.i(210419);
        if (fVar == null) {
            AppMethodBeat.o(210419);
            return;
        }
        if (fVar.dUm == 1) {
            i4 = 1;
        } else {
            i4 = fVar.dUm == 2 ? 2 : 0;
        }
        ResolveInfo resolveInfo = fVar.resolveInfo;
        if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || (str = activityInfo.packageName) == null) {
            str = "";
        }
        Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogResult settingResult: " + i4 + ", selectedPosition: " + i3 + ", packageName: " + str);
        h.INSTANCE.a(21458, 2, Integer.valueOf(i4), str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.o(210419);
    }
}
