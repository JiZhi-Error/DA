package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class h extends c {
    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(41973);
        hVar.dWm();
        AppMethodBeat.o(41973);
    }

    public h(Context context) {
        super(context);
    }

    public final void hO(String str, String str2) {
        this.xOl = str;
        this.xOm = str2;
    }

    public final void onClick(View view) {
        int i2;
        int i3;
        AppMethodBeat.i(41969);
        if (view.getTag() instanceof c) {
            this.xEP = (c) view.getTag();
            Log.i("MicroMsg.GameClickListener", "Clicked appid = " + this.xEP.field_appId);
            dWf();
            if (com.tencent.mm.pluginsdk.model.app.h.s(this.mContext, this.xEP.field_appId)) {
                if (this.xEP instanceof c) {
                    int aAH = com.tencent.mm.plugin.game.e.c.aAH(this.xEP.field_packageName);
                    i2 = this.xEP.versionCode;
                    i3 = aAH;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                if (i2 > i3) {
                    Log.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", this.xEP.field_appId, Integer.valueOf(i3), Integer.valueOf(i2));
                    k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, "app_update");
                    if (this.xOi.status == 1) {
                        Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(Cp(this.xOi.id))));
                        AppMethodBeat.o(41969);
                    } else if (this.xOi.status == 2) {
                        dWl();
                        AppMethodBeat.o(41969);
                    } else if (this.xOi.status != 3) {
                        pR(true);
                        AppMethodBeat.o(41969);
                    } else if (!s.YS(this.xOi.path) || com.tencent.mm.plugin.game.e.c.aAJ(this.xOi.path) <= i3) {
                        pR(true);
                        AppMethodBeat.o(41969);
                    } else {
                        r.b(this.mContext, this.xOi.path, null, false);
                        f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 8, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
                        AppMethodBeat.o(41969);
                    }
                } else {
                    Log.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", this.xEP.field_appId, this.xEP.field_packageName, this.xEP.field_openId);
                    f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 3, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
                    dWe();
                    AppMethodBeat.o(41969);
                }
            } else if (this.xEP.dUP()) {
                com.tencent.mm.plugin.game.e.c.D(this.mContext, this.xEP.xEo.xMp, "game_center_hv_game");
                f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 29, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
                AppMethodBeat.o(41969);
            } else {
                k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, this.xOm);
                switch (this.mStatus) {
                    case 1:
                        Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(Cp(this.xOi.id))));
                        AppMethodBeat.o(41969);
                        return;
                    case 2:
                        dWl();
                        AppMethodBeat.o(41969);
                        return;
                    case 3:
                        if (Util.isNullOrNil(this.xOh) || !s.YS(this.xOh) || !com.tencent.mm.plugin.game.e.c.hR(this.xOh, this.xOj.field_md5)) {
                            pR(false);
                            AppMethodBeat.o(41969);
                            return;
                        }
                        com.tencent.mm.plugin.game.e.c.GK(this.xOj.field_downloadId);
                        f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 8, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
                        AppMethodBeat.o(41969);
                        return;
                    default:
                        pR(false);
                        AppMethodBeat.o(41969);
                        return;
                }
            }
        } else {
            Log.e("MicroMsg.GameClickListener", "No AppInfo");
            AppMethodBeat.o(41969);
        }
    }

    private void dWl() {
        AppMethodBeat.i(41970);
        if (!NetStatusUtil.isNetworkConnected(this.mContext)) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.dom), 0).show();
            AppMethodBeat.o(41970);
        } else if (NetStatusUtil.isWifi(this.mContext)) {
            dWm();
            AppMethodBeat.o(41970);
        } else {
            com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.string.iyr), this.mContext.getString(R.string.iys), this.mContext.getString(R.string.iym), this.mContext.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.ui.h.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(41967);
                    h.a(h.this);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(41967);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.ui.h.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(41968);
                    dialogInterface.dismiss();
                    Log.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
                    AppMethodBeat.o(41968);
                }
            }, (int) R.color.afp);
            AppMethodBeat.o(41970);
        }
    }

    private void dWm() {
        AppMethodBeat.i(41971);
        a.a(10, new b(this.xEP.field_appId, this.xEP.dYu, this.xOj.field_downloadId, ""));
        d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
        if (com.tencent.mm.plugin.downloader.model.f.cBv().Cq(this.xOj.field_downloadId)) {
            e.aK(this.mContext, this.xEP.field_appId);
            f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 4, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
            AppMethodBeat.o(41971);
            return;
        }
        Log.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
        com.tencent.mm.plugin.downloader.model.f.cBv().Cn(this.xOj.field_downloadId);
        pR(false);
        AppMethodBeat.o(41971);
    }

    private static boolean Cp(long j2) {
        AppMethodBeat.i(41972);
        com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
        if (Cw != null && Cw.field_downloadInWifi) {
            Cw.field_downloadInWifi = false;
            com.tencent.mm.plugin.downloader.model.d.e(Cw);
        }
        boolean Cp = com.tencent.mm.plugin.downloader.model.f.cBv().Cp(j2);
        AppMethodBeat.o(41972);
        return Cp;
    }
}
