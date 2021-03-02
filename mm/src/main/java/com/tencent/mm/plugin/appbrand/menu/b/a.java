package com.tencent.mm.plugin.appbrand.menu.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.aa;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import junit.framework.Assert;
import org.json.JSONObject;

public final class a implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(final Context context, ag agVar, String str) {
        final String str2;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        AppMethodBeat.i(47678);
        final ag agVar2 = agVar;
        l lVar = new l(context);
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    str2 = next.processName;
                    break;
                }
            }
        }
        str2 = null;
        lVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.appbrand.menu.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(47675);
                mVar.kV(1, R.string.i3);
                mVar.kV(2, R.string.i0);
                mVar.kV(7, R.string.i2);
                mVar.kV(9, R.string.hx);
                mVar.d(3, "appID: " + agVar2.getAppId());
                mVar.d(8, "username: " + agVar2.getRuntime().bsC().username);
                mVar.d(5, Util.isNullOrNil(str2) ? "UNKNOWN PROCESS NAME" : str2);
                mVar.d(6, context.getString(R.string.hy) + String.format("(cur:%b)", Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.b.bVE())));
                mVar.d(10, "JAVA ASSERT");
                mVar.d(11, "JNI ASSERT");
                AppMethodBeat.o(47675);
            }
        };
        lVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.appbrand.menu.b.a.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                String str;
                AppMethodBeat.i(47677);
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.plugin.appbrand.jsapi.ab.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.ab.a();
                        c bsE = agVar2.bsE();
                        new JSONObject();
                        aVar.a(bsE, 10000);
                        AppMethodBeat.o(47677);
                        return;
                    case 2:
                    case 7:
                    case 9:
                        switch (menuItem.getItemId()) {
                            case 2:
                                str = "wxfile://usr";
                                break;
                            case 7:
                                str = "wxfile://opendata";
                                break;
                            case 9:
                                str = "wxfile://clientdata";
                                break;
                            default:
                                str = "wxfile://";
                                break;
                        }
                        String z = aa.z(agVar2.getFileSystem().ag(str, true).her());
                        Toast.makeText(context, context.getString(R.string.i1, z), 0).show();
                        ClipboardHelper.setText(MMApplicationContext.getContext(), "text", z);
                        AppMethodBeat.o(47677);
                        return;
                    case 3:
                        ClipboardHelper.setText(MMApplicationContext.getContext(), "text", agVar2.getAppId());
                        Toast.makeText(context, context.getString(R.string.hw, agVar2.getAppId()), 1).show();
                        AppMethodBeat.o(47677);
                        return;
                    case 6:
                        if (com.tencent.mm.plugin.appbrand.task.b.bVE()) {
                            com.tencent.mm.plugin.appbrand.task.b.bVG();
                        } else {
                            com.tencent.mm.plugin.appbrand.task.b.bVF();
                        }
                        menuItem.setTitle(context.getString(R.string.hy) + String.format("(cur:%b)", Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.b.bVE())));
                        Toast.makeText(context, "Restart Wechat!!", 1).show();
                        AppMethodBeat.o(47677);
                        return;
                    case 8:
                        String str2 = agVar2.getRuntime().bsC().username;
                        ClipboardHelper.setText(MMApplicationContext.getContext(), "text", str2);
                        Toast.makeText(context, context.getString(R.string.i4, str2), 1).show();
                        AppMethodBeat.o(47677);
                        return;
                    case 10:
                        Assert.fail("test errlog " + new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS, Locale.ENGLISH).format(new Date()));
                        AppMethodBeat.o(47677);
                        return;
                    case 11:
                        MMProtocalJni.setClientPackVersion(-1);
                        break;
                }
                AppMethodBeat.o(47677);
            }
        };
        lVar.gXI();
        AppMethodBeat.o(47678);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(47679);
        String string = context.getString(R.string.hv);
        AppMethodBeat.o(47679);
        return string;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47680);
        if (WeChatEnvironment.hasDebugger() || p.Un(str).kDe) {
            AppMethodBeat.o(47680);
            return true;
        }
        AppMethodBeat.o(47680);
        return false;
    }
}
