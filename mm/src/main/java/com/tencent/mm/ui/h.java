package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e;
import com.tencent.mm.al.x;
import com.tencent.mm.br.c;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;

public final class h {
    private static final String dol = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2o) + "/wework_admin/commdownload?from=conv%s");

    static {
        AppMethodBeat.i(232475);
        AppMethodBeat.o(232475);
    }

    public static int cy(Context context, String str) {
        boolean z;
        AppMethodBeat.i(33024);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(33024);
            return 0;
        }
        d MO = ag.bar().MO(str);
        if (MO == null || (MO.field_userFlag & 2) == 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(33024);
            return 0;
        } else if (MO.field_wwExposeTimes < MO.field_wwMaxExposeTimes || q.s(context, "com.tencent.wework")) {
            AppMethodBeat.o(33024);
            return 2;
        } else {
            AppMethodBeat.o(33024);
            return 1;
        }
    }

    public static void cz(Context context, String str) {
        AppMethodBeat.i(33025);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(33025);
            return;
        }
        if (!q.s(context, "com.tencent.wework")) {
            ag.bar().MR(str);
        }
        AppMethodBeat.o(33025);
    }

    public static void r(Context context, String str, int i2) {
        AppMethodBeat.i(33026);
        if (q.s(context, "com.tencent.wework")) {
            aP(str, 4, i2);
            AppMethodBeat.o(33026);
            return;
        }
        aP(str, 5, i2);
        AppMethodBeat.o(33026);
    }

    public static void s(final Context context, final String str, final int i2) {
        final Intent launchIntentForPackage;
        AppMethodBeat.i(33027);
        aP(str, 1, i2);
        aQ(str, 2, i2);
        d MP = ag.bar().MP(str);
        String str2 = null;
        if (4 == i2 || 3 == i2) {
            ag.bar();
            str2 = e.aZA();
            if (str2 != null && str2.length() > 0 && str2.toLowerCase().startsWith("http")) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(33027);
                return;
            }
        }
        if (q.s(context, "com.tencent.wework")) {
            aP(str, 2, i2);
            PackageInfo packageInfo = b.getPackageInfo(context, "com.tencent.wework");
            if (Util.isNullOrNil(packageInfo.versionName) || packageInfo.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                if ((i2 == 4 || 3 == i2) && str2 != null && str2.length() > 0) {
                    intent2.setData(Uri.parse(str2));
                    launchIntentForPackage = intent2;
                } else {
                    intent2.setData(Uri.parse((i2 == 2 || i2 == 4 || i2 == 6) ? "wxwork://createconversation" : "wxwork://conversationlist"));
                    launchIntentForPackage = intent2;
                }
            }
            a.post(new Runnable() {
                /* class com.tencent.mm.ui.h.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(33023);
                    try {
                        com.tencent.mm.pluginsdk.model.app.h.b(context, launchIntentForPackage, context.getString(R.string.bxu));
                        AppMethodBeat.o(33023);
                    } catch (Throwable th) {
                        AppMethodBeat.o(33023);
                    }
                }
            });
            AppMethodBeat.o(33027);
        } else if (MP.field_use_preset_banner_tips) {
            com.tencent.mm.ui.base.h.a(context, (int) R.string.bxx, 0, (int) R.string.bxw, (int) R.string.sz, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.h.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(33021);
                    h.t(context, str, i2);
                    AppMethodBeat.o(33021);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(33027);
        } else if (MP.field_show_confirm) {
            f.a aVar = new f.a(context);
            aVar.boB(context.getString(R.string.sz));
            aVar.apa(R.string.bxw);
            ag.bar();
            ag.bar();
            String sM = e.sM(1);
            if (sM == null) {
                aVar.bow(context.getString(R.string.bxx));
            } else {
                aVar.bow(sM);
            }
            aVar.a(new f.c() {
                /* class com.tencent.mm.ui.h.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                }
            }, new f.c() {
                /* class com.tencent.mm.ui.h.AnonymousClass3 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(33022);
                    h.t(context, str, i2);
                    AppMethodBeat.o(33022);
                }
            }).show();
            AppMethodBeat.o(33027);
        } else {
            t(context, str, i2);
            AppMethodBeat.o(33027);
        }
    }

    public static void t(Context context, String str, int i2) {
        AppMethodBeat.i(33028);
        aP(str, 3, i2);
        aQ(str, 3, i2);
        ag.bah();
        String MX = com.tencent.mm.al.f.MX(str);
        String str2 = dol;
        Object[] objArr = new Object[1];
        objArr[0] = Util.isNullOrNil(MX) ? "off" : "on";
        String format = String.format(str2, objArr);
        FileDownloadTaskInfo alh = com.tencent.mm.plugin.downloader.model.f.cBv().alh(format);
        if (alh != null && alh.status == 3 && s.YS(alh.path)) {
            s.deleteFile(alh.path);
        }
        u.makeText(context, context.getString(R.string.bxy), 2000).show();
        g.a aVar = new g.a();
        aVar.alj(format);
        aVar.all(context.getString(R.string.bxu));
        aVar.Fl(1);
        aVar.kS(true);
        com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.qIY);
        AppMethodBeat.o(33028);
    }

    private static int aP(String str, int i2, int i3) {
        AppMethodBeat.i(33029);
        com.tencent.mm.api.c MT = ag.bah().MT(str);
        if (MT.UG()) {
            str = MT.UN();
        }
        d MO = ag.bar().MO(str);
        int i4 = MO != null ? MO.field_qyUin : 0;
        int i5 = MO != null ? MO.field_userUin : 0;
        long j2 = MO != null ? MO.field_wwCorpId : 0;
        long j3 = MO != null ? MO.field_wwUserVid : 0;
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13656, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3));
        Log.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(33029);
        return i3;
    }

    public static void aQ(String str, int i2, int i3) {
        int i4;
        AppMethodBeat.i(33031);
        com.tencent.mm.api.c MT = ag.bah().MT(str);
        if (i3 == 3) {
            i4 = 2;
        } else {
            i4 = i3;
        }
        if (i4 == 4) {
            i4 = 3;
        }
        if (MT.UG()) {
            str = MT.UN();
        }
        d MO = ag.bar().MO(str);
        com.tencent.mm.kernel.g.aAg().hqi.a(new x(MO, i2, i4, new Object()), 0);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15162, Long.valueOf(MO.field_wwCorpId), Long.valueOf(MO.field_wwUserVid), Integer.valueOf(MO.field_chatOpen ? 1 : 0), Integer.valueOf(MO.field_wwUnreadCnt), Integer.valueOf(MO.field_show_confirm ? 1 : 0), Integer.valueOf(MO.field_userType), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.o(33031);
    }
}
