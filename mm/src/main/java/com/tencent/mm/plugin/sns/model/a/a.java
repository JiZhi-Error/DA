package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;

public final class a {
    public n DDH = null;
    public SparseArray<n> DDI;
    public String DEt = "";
    public String DEu = "";
    public SparseArray<cnb> DEw;
    public String DIl = "";
    public String DIp = "";
    public cnb DIq;
    public boolean DPm = false;
    public boolean DPn = false;
    public int DPo = 0;
    public bp DPp;
    public float DPq = 0.0f;
    public String dRS;
    public String md5 = "";
    public String mediaId = "";
    public int mediaType = 0;
    public int size;
    public String url = "";

    public a(String str) {
        this.mediaId = str;
    }

    public a(String str, SparseArray<cnb> sparseArray, SparseArray<n> sparseArray2, int i2) {
        this.dRS = str;
        this.DEw = sparseArray;
        this.DDI = sparseArray2;
        this.size = i2;
    }

    public final boolean init() {
        AppMethodBeat.i(96063);
        this.DIl = ar.ki(aj.getAccSnsPath(), this.mediaId);
        AppMethodBeat.o(96063);
        return true;
    }

    public final a ko(String str, String str2) {
        this.DEt = str;
        this.DEu = str2;
        return this;
    }

    public final String fbV() {
        AppMethodBeat.i(96064);
        if (this.DPo == 4) {
            String p = r.p(this.DIq);
            AppMethodBeat.o(96064);
            return p;
        } else if (this.DPo == 6) {
            String q = r.q(this.DIq);
            AppMethodBeat.o(96064);
            return q;
        } else if (this.DPm) {
            String n = r.n(this.DIq);
            AppMethodBeat.o(96064);
            return n;
        } else {
            String m = r.m(this.DIq);
            AppMethodBeat.o(96064);
            return m;
        }
    }

    public final String getPath() {
        AppMethodBeat.i(96065);
        if (!Util.isNullOrNil(this.DEt)) {
            String str = this.DEt;
            AppMethodBeat.o(96065);
            return str;
        }
        if (Util.isNullOrNil(this.DIl)) {
            init();
        }
        String str2 = this.DIl;
        AppMethodBeat.o(96065);
        return str2;
    }
}
