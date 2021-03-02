package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.s;

public final class l {
    public int mode = 1;
    public int progress = 0;
    public int status = 0;
    public c xEP;
    public boolean xEQ = false;

    public l(c cVar) {
        this.xEP = cVar;
    }

    public final void gi(Context context) {
        AppMethodBeat.i(41433);
        if (this.xEP == null) {
            AppMethodBeat.o(41433);
            return;
        }
        int i2 = this.xEP.fmN;
        int i3 = this.xEP.fmN;
        Log.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", this.xEP.field_appId, Integer.valueOf(i2));
        if (i2 == 2) {
            i3 = 3;
        }
        if (i3 == 3 && !h.s(context, "wx3909f6add1206543")) {
            i3 = 1;
        }
        if (i3 != 1) {
            FileDownloadTaskInfo alg = f.cBv().alg(this.xEP.field_appId);
            if (alg.status == 1 || alg.status == 2 || alg.status == 3) {
                i3 = 1;
            }
        }
        this.mode = i3;
        Log.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", this.xEP.field_appId, Integer.valueOf(i3));
        AppMethodBeat.o(41433);
    }

    public final void cCq() {
        AppMethodBeat.i(41434);
        if (this.xEP == null) {
            AppMethodBeat.o(41434);
            return;
        }
        switch (this.mode) {
            case 1:
                FileDownloadTaskInfo alg = f.cBv().alg(this.xEP.field_appId);
                if (alg.oJj != 0) {
                    this.progress = (int) ((((double) alg.qJe) / ((double) alg.oJj)) * 100.0d);
                } else {
                    this.progress = 0;
                }
                this.progress = this.progress == 0 ? 1 : this.progress;
                Log.d("MicroMsg.GameDownloadInfo", "status = " + alg.status);
                switch (alg.status) {
                    case 0:
                        this.status = 0;
                        break;
                    case 1:
                        this.status = 1;
                        break;
                    case 2:
                        this.status = 2;
                        break;
                    case 3:
                        if (!s.YS(alg.path)) {
                            this.status = 0;
                            break;
                        } else {
                            this.status = 3;
                            break;
                        }
                    case 4:
                        if (this.progress != 0 && !NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                            this.status = 2;
                            break;
                        } else {
                            this.status = 0;
                            break;
                        }
                        break;
                    default:
                        this.status = 0;
                        break;
                }
            default:
                this.status = 0;
                break;
        }
        Log.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", this.xEP.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status));
        AppMethodBeat.o(41434);
    }

    public final void dVj() {
        this.mode = 1;
        this.xEQ = true;
    }
}
