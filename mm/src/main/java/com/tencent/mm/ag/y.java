package com.tencent.mm.ag;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;

public final class y extends jo {
    public float iAJ = 0.0f;
    private String iAK = null;
    public int iAL;
    public int iAM;
    public int iAN;
    public int iAO;
    public int iAP = 0;
    public long iAQ = -1;
    public String iAR;
    public boolean iAS = false;
    public int idx = 0;

    public final String HJ(String str) {
        AppMethodBeat.i(116425);
        this.iAK = MD5Util.getMD5String(str + "_" + this.videoUrl);
        String str2 = this.iAK;
        AppMethodBeat.o(116425);
        return str2;
    }

    public final void aSB() {
        AppMethodBeat.i(116426);
        if (this.iAQ != -1) {
            AppMethodBeat.o(116426);
            return;
        }
        try {
            Uri parse = Uri.parse(this.KOe);
            this.iAQ = Util.getLong(parse.getQueryParameter("mid"), 0);
            this.idx = Util.getInt(parse.getQueryParameter("idx"), 0);
            AppMethodBeat.o(116426);
        } catch (Exception e2) {
            this.iAQ = 0;
            AppMethodBeat.o(116426);
        }
    }

    public final y a(jo joVar) {
        if (joVar == null) {
            return null;
        }
        this.KOe = joVar.KOe;
        this.videoUrl = joVar.videoUrl;
        this.KOf = joVar.KOf;
        this.title = joVar.title;
        this.iAo = joVar.iAo;
        this.videoDuration = joVar.videoDuration;
        this.width = joVar.width;
        this.height = joVar.height;
        this.url = joVar.url;
        this.dHc = joVar.dHc;
        this.iAg = joVar.iAg;
        this.iAh = joVar.iAh;
        this.ehR = joVar.ehR;
        this.ehQ = joVar.ehQ;
        return this;
    }
}
