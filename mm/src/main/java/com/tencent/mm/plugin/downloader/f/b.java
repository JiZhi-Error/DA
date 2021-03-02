package com.tencent.mm.plugin.downloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

public final class b {
    public String appId;
    public String channelId;
    public long costTime;
    public long dCa;
    public int dNv;
    public String downloadUrl;
    public int eik = 1;
    public int errCode;
    public String extInfo;
    public long oJj;
    public long qJD;
    public int qJE;
    public int qJF;
    public int qJG;
    public int qJH;
    public int qJI;
    public int qJJ;
    public long qJe;
    public int scene;

    public b() {
    }

    public b(String str, int i2, long j2, String str2) {
        this.appId = str;
        this.scene = i2;
        this.dCa = j2;
        this.channelId = str2;
        this.extInfo = null;
        this.qJF = 0;
    }

    public b(String str, long j2, String str2, long j3, int i2) {
        this.appId = str;
        this.dCa = j2;
        this.channelId = str2;
        this.costTime = j3;
        this.qJF = i2;
    }

    public b(String str, int i2, String str2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(89085);
        this.appId = str;
        this.scene = i2;
        this.qJG = i2;
        this.extInfo = str2;
        this.qJF = this.qJF;
        this.qJH = i3;
        this.qJI = i5;
        this.qJJ = i4;
        this.eik = i6;
        AppMethodBeat.o(89085);
    }

    public final void k(a aVar) {
        AppMethodBeat.i(89086);
        this.appId = aVar.field_appId;
        this.scene = aVar.field_scene;
        this.qJD = aVar.field_startSize;
        this.qJe = aVar.field_downloadedSize - aVar.field_startSize;
        this.qJe = this.qJe < 0 ? 0 : this.qJe;
        this.oJj = aVar.field_totalSize;
        this.downloadUrl = aVar.field_downloadUrl;
        this.errCode = aVar.field_errCode;
        this.dNv = aVar.field_downloaderType;
        this.channelId = aVar.field_channelId;
        long currentTimeMillis = aVar.field_finishTime > 0 ? aVar.field_finishTime : System.currentTimeMillis();
        if (aVar.field_startTime == 0) {
            this.costTime = 0;
        } else {
            this.costTime = (currentTimeMillis - aVar.field_startTime) / 1000;
        }
        if (this.costTime < 0) {
            this.costTime = 0;
        }
        this.qJE = aVar.field_startState;
        this.dCa = aVar.field_downloadId;
        this.extInfo = aVar.field_extInfo;
        this.qJF = aVar.field_reserveInWifi ? 1 : 0;
        this.qJG = aVar.field_startScene;
        this.qJH = aVar.field_uiarea;
        this.qJI = aVar.field_noticeId;
        this.qJJ = aVar.field_ssid;
        this.eik = aVar.field_downloadType;
        AppMethodBeat.o(89086);
    }
}
