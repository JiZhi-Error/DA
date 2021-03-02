package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.k.ad;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a {
    public static void a(long j2, final boolean z, final com.tencent.mm.pluginsdk.permission.a aVar) {
        AppMethodBeat.i(89133);
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null || Cw.field_status != 3 || !s.YS(Cw.field_filePath)) {
            if (aVar != null) {
                aVar.hk(false);
            }
            AppMethodBeat.o(89133);
        } else if (!e.g(Cw)) {
            Log.i("MicroMsg.DownloadAppUtil", "install, md5 check fail");
            s.deleteFile(Cw.field_filePath);
            d.Cx(j2);
            h.INSTANCE.dN(ad.CTRL_INDEX, 35);
            AppMethodBeat.o(89133);
        } else {
            if (Util.isNullOrNil(Cw.field_packageName)) {
                String ali = f.ali(Cw.field_filePath);
                if (!Util.isNullOrNil(ali)) {
                    Cw.field_packageName = ali;
                    Log.i("MicroMsg.DownloadAppUtil", "get package name from file : %s, %s", Cw.field_filePath, ali);
                    d.e(Cw);
                }
            }
            a(Cw.field_filePath, new com.tencent.mm.pluginsdk.permission.a() {
                /* class com.tencent.mm.plugin.downloader.i.a.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.permission.a
                public final void hk(boolean z) {
                    AppMethodBeat.i(89130);
                    if (z) {
                        b bVar = new b();
                        bVar.k(Cw);
                        String str = Cw.field_packageName;
                        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("install_begin_time", 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
                        }
                        com.tencent.mm.plugin.downloader.f.a.a(Cw.field_appId, Cw.field_scene, 4, Cw.field_md5, Cw.field_downloadUrl, null, Cw.field_extInfo);
                        bVar.costTime = (System.currentTimeMillis() - Cw.field_startTime) / 1000;
                        com.tencent.mm.plugin.downloader.f.a.a(4, bVar);
                        if (z) {
                            com.tencent.mm.plugin.downloader.f.a.a(15, bVar);
                        } else {
                            com.tencent.mm.plugin.downloader.f.a.a(16, bVar);
                        }
                    }
                    if (aVar != null) {
                        aVar.hk(z);
                    }
                    AppMethodBeat.o(89130);
                }
            });
            AppMethodBeat.o(89133);
        }
    }

    public static void a(String str, com.tencent.mm.pluginsdk.permission.a aVar) {
        AppMethodBeat.i(89134);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
            if (aVar != null) {
                aVar.hk(false);
            }
            AppMethodBeat.o(89134);
            return;
        }
        Log.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(str)));
        if (!s.YS(str)) {
            Log.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
            if (aVar != null) {
                aVar.hk(false);
            }
            AppMethodBeat.o(89134);
            return;
        }
        r.b(MMApplicationContext.getContext(), str, aVar, true);
        AppMethodBeat.o(89134);
    }

    public static void as(final Context context, String str) {
        AppMethodBeat.i(192276);
        final AnonymousClass2 r1 = new al() {
            /* class com.tencent.mm.plugin.downloader.i.a.AnonymousClass2 */
            final /* synthetic */ al qJV = null;

            @Override // com.tencent.mm.pluginsdk.model.app.al
            public final void v(boolean z, boolean z2) {
                AppMethodBeat.i(192275);
                if (this.qJV != null) {
                    this.qJV.v(z, z2);
                }
                AppMethodBeat.o(192275);
            }
        };
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.DownloadAppUtil", "null or nil appid");
            r1.v(false, false);
        }
        final g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
        if (o == null || Util.isNullOrNil(o.field_appId)) {
            Log.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
            r1.v(false, false);
            AppMethodBeat.o(192276);
            return;
        }
        final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
        wXMediaMessage.sdkVer = Build.SDK_INT;
        wXMediaMessage.messageAction = null;
        wXMediaMessage.messageExt = "WX_GameCenter";
        Log.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", o.field_appId, o.field_appName, o.field_openId);
        if (Util.isNullOrNil(o.field_openId)) {
            Log.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", o.field_appName);
            com.tencent.mm.plugin.r.a.eAU().add(o.field_appId);
        }
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.i.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(89132);
                com.tencent.mm.pluginsdk.model.app.h.a(context, o.field_packageName, wXMediaMessage, o.field_appId, o.field_openId, 0, r1, null);
                AppMethodBeat.o(89132);
            }
        });
        AppMethodBeat.o(192276);
    }
}
