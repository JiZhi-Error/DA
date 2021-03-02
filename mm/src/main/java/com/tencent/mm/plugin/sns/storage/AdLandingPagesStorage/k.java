package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;

public final class k {
    public String DQS;
    public int DZU;
    public int ElM;
    public int ElN;
    public int ElO;
    public int ElP;
    public int ElQ;
    public int ElR;
    private String ElS;
    public String ElT;
    public JSONArray ElU = new JSONArray();
    public String dRS;
    public long enterTime;
    public String extra = "";
    public int favCount;
    public int gYH;
    public int gmJ;
    public String lAN;
    public int rna;
    public int tar;
    public int tas;
    public String uxInfo;

    public k() {
        AppMethodBeat.i(97392);
        AppMethodBeat.o(97392);
    }

    public final String feA() {
        String str;
        AppMethodBeat.i(97393);
        this.ElS = this.ElU.toString();
        Log.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", this.ElS);
        if (!Util.isNullOrNil(this.ElS)) {
            try {
                this.ElS = URLEncoder.encode(this.ElS, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e2.toString());
            }
        }
        long j2 = 0;
        try {
            j2 = r.aOw(this.dRS);
        } catch (Exception e3) {
            Log.e("AdLandingPagesReportInfo", "", e3);
        }
        StringBuilder append = new StringBuilder().append(r.Jb(j2)).append(",").append(this.uxInfo).append(",").append(this.gYH).append(",").append(this.gmJ).append(",").append(this.rna).append(",").append(this.ElM).append(",").append(this.ElN).append(",").append(this.ElO).append(",").append(this.ElP).append(",").append(this.ElQ).append(",").append(this.ElR).append(",").append(this.tas).append(",").append(this.tar).append(",").append(this.favCount).append(",").append(this.ElS).append(",").append(this.enterTime).append(",").append(this.ElT).append(",");
        if (this.DQS == null) {
            str = "";
        } else {
            str = this.DQS;
        }
        String sb = append.append(str).append(",").append(this.extra).append(",").append(this.DZU).append(",").append(this.lAN).toString();
        AppMethodBeat.o(97393);
        return sb;
    }
}
