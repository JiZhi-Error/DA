package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.dn;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class aa {
    public String mAppId = "";
    public List<a> xHa = new LinkedList();

    public static class a implements Serializable {
        public String dWq;
        public String tag;
        public long wXd;
        public int xHb;
        public int xHc;
        public boolean xHd;
        public String xHe;
    }

    public aa(String str) {
        AppMethodBeat.i(41531);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41531);
            return;
        }
        this.mAppId = str;
        this.xHa.addAll(dVL());
        AppMethodBeat.o(41531);
    }

    public aa(String str, List<dn> list) {
        AppMethodBeat.i(41532);
        if (Util.isNullOrNil(str) || list == null || list.isEmpty()) {
            AppMethodBeat.o(41532);
            return;
        }
        this.mAppId = str;
        this.xHa.clear();
        for (dn dnVar : list) {
            a aVar = new a();
            aVar.xHb = dnVar.xNc;
            aVar.dWq = dnVar.UserName;
            aVar.tag = dnVar.Label;
            aVar.wXd = dnVar.xNd;
            aVar.xHd = dnVar.xNe;
            aVar.xHc = dnVar.xNf;
            aVar.xHe = dnVar.xNg;
            this.xHa.add(aVar);
        }
        dVM();
        AppMethodBeat.o(41532);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[SYNTHETIC, Splitter:B:21:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A[SYNTHETIC, Splitter:B:29:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.tencent.mm.plugin.game.model.aa.a> dVL() {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.aa.dVL():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e A[SYNTHETIC, Splitter:B:18:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[SYNTHETIC, Splitter:B:28:0x0071] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dVM() {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.aa.dVM():void");
    }
}
