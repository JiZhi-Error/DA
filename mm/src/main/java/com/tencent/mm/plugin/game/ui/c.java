package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class c implements View.OnClickListener {
    protected long lAs = -1;
    protected Context mContext;
    protected int mStatus = -1;
    protected com.tencent.mm.plugin.game.model.c xEP = null;
    protected int xGR;
    protected String xOh;
    protected FileDownloadTaskInfo xOi;
    protected a xOj;
    protected String xOk;
    protected String xOl;
    protected String xOm;
    private String xOn = "xiaomi";

    public c(Context context) {
        this.mContext = context;
    }

    public final void setSourceScene(int i2) {
        this.xGR = i2;
    }

    /* access modifiers changed from: protected */
    public final void dWe() {
        e.at(this.mContext, this.xEP.field_appId);
    }

    /* access modifiers changed from: protected */
    public final void pR(final boolean z) {
        if (!NetStatusUtil.isNetworkConnected(this.mContext)) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.dom), 0).show();
            k.dVi();
            k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFt, false, (String) null);
            return;
        }
        g.aAi();
        if (!g.aAh().isSDCardAvailable()) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.doq), 0).show();
            k.dVi();
            k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFu, false, (String) null);
        } else if (h.CF(this.xEP.nJC) || h.CE(this.xEP.nJC)) {
            if (d.KyI.toLowerCase().contains(this.xOn)) {
                try {
                    if (Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !e.fZ(this.mContext)) {
                        com.tencent.mm.ui.base.h.a(this.mContext, (int) R.string.dsq, (int) R.string.dsr, (int) R.string.dp9, (int) R.string.sz, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.game.ui.c.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(41860);
                                Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
                                Context context = c.this.mContext;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                dialogInterface.cancel();
                                AppMethodBeat.o(41860);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.game.ui.c.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(41861);
                                dialogInterface.cancel();
                                AppMethodBeat.o(41861);
                            }
                        });
                        e.ga(this.mContext);
                    }
                } catch (Settings.SettingNotFoundException e2) {
                    Log.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", e2.getMessage());
                }
            }
            if (Util.isNullOrNil(this.xEP.fmE) || Util.isNullOrNil(this.xEP.fmJ)) {
                Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                if (Util.isNullOrNil(this.xEP.fmK)) {
                    Log.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                } else {
                    Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", Boolean.valueOf(r.ck(this.mContext, this.xEP.fmK)));
                }
                if (Util.isNullOrNil(this.xEP.fmE)) {
                    k.dVi();
                    k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, (String) null);
                }
                if (Util.isNullOrNil(this.xEP.fmJ)) {
                    k.dVi();
                    k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFr, false, (String) null);
                    return;
                }
                return;
            }
            f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 4, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
            if (NetStatusUtil.isWifi(this.mContext)) {
                pS(z);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, this.xEP.field_appId, 4, "", this.xEP.fmE, 2);
            com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.string.iyr), this.mContext.getString(R.string.iys), this.mContext.getString(R.string.iym), this.mContext.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.ui.c.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(41858);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, c.this.xEP.field_appId, 5, "", c.this.xEP.fmE, 2);
                    c.this.pS(z);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(41858);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.ui.c.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(41859);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, c.this.xEP.field_appId, 6, "", c.this.xEP.fmE, 2);
                    dialogInterface.dismiss();
                    Log.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
                    AppMethodBeat.o(41859);
                }
            }, (int) R.color.afp);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.don), 0).show();
            k.dVi();
            k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFu, false, (String) null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pS(boolean z) {
        long a2;
        if (z) {
            k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, "app_update");
        } else {
            k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, this.xOm);
        }
        g.a aVar = new g.a();
        aVar.alj(this.xEP.fmE);
        aVar.alk(this.xEP.xEn);
        aVar.setFileSize(this.xEP.nJC);
        aVar.all(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.xEP, (String) null));
        aVar.setAppId(this.xEP.field_appId);
        aVar.setFileMD5(this.xEP.fmJ);
        aVar.kS(true);
        aVar.Fl(1);
        aVar.gm(this.xEP.field_packageName);
        aVar.setScene(this.xEP.dYu);
        if (this.xEP.dNv == 1) {
            a2 = com.tencent.mm.plugin.downloader.model.f.cBv().b(aVar.qIY);
        } else {
            a2 = com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.qIY);
        }
        Log.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(a2), this.xEP.field_appId, Integer.valueOf(this.xEP.dNv));
        e.aK(this.mContext, this.xEP.field_appId);
        com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.xEP.field_appId, this.xEP.dYu, a2, ""));
        com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
    }

    /* access modifiers changed from: protected */
    public final void dWf() {
        this.xOj = com.tencent.mm.plugin.downloader.model.d.alb(this.xEP.field_appId);
        this.xOi = com.tencent.mm.plugin.downloader.model.f.cBv().alg(this.xEP.field_appId);
        this.lAs = this.xOi.id;
        this.mStatus = this.xOi.status;
        this.xOh = this.xOi.path;
    }
}
