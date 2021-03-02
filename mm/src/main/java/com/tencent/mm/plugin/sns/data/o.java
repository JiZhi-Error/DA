package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;

public final class o {
    public String DEt;
    public String DEu;
    public bp DEv;
    public SparseArray<cnb> DEw;
    public String dRS;
    public cnb ebR;
    public String key;
    public int requestType;
    public int size;

    public o() {
        AppMethodBeat.i(95089);
        this.DEw = new SparseArray<>();
        AppMethodBeat.o(95089);
    }

    public o(String str, SparseArray<cnb> sparseArray, String str2, bp bpVar, int i2) {
        this.dRS = str;
        this.DEw = sparseArray;
        this.requestType = 9;
        this.key = str2;
        this.DEv = bpVar;
        this.size = i2;
    }

    public o(cnb cnb, int i2, String str, bp bpVar, String str2, String str3) {
        this.ebR = cnb;
        this.requestType = i2;
        this.DEv = bpVar;
        this.key = str;
        this.DEt = str2;
        this.DEu = str3;
    }
}
