package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface e {

    public interface b {
        void a(e eVar, String str);
    }

    List<c> GE(long j2);

    int Nn(int i2);

    com.tencent.mm.plugin.fts.a.d.a.a No(int i2);

    void a(String str, MMHandler mMHandler, HashSet<String> hashSet, long j2);

    boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z);

    void clearData();

    int dOF();

    void dOG();

    LinkedList<Integer> dOH();

    int dOI();

    long dOJ();

    int getType();

    public static class a {
        public int businessType = 0;
        public List<m> mWl = null;
        public boolean tuG = false;
        public h wWd = null;
        public int wXD = Integer.MAX_VALUE;
        public boolean wXE = true;
        public int wXF = Integer.MAX_VALUE;
        public boolean wXG = true;
        public m wXH;
        public int wXI = 0;

        public final String toString() {
            int i2 = 0;
            AppMethodBeat.i(131734);
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.wXD);
            objArr[1] = Boolean.valueOf(this.wXE);
            objArr[2] = Integer.valueOf(this.wXF);
            objArr[3] = Boolean.valueOf(this.tuG);
            objArr[4] = Integer.valueOf(this.businessType);
            if (this.mWl != null) {
                i2 = this.mWl.size();
            }
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Integer.valueOf(this.wXI);
            String format = String.format("{%d, %b, %d, %b, %d, %d, %d}", objArr);
            AppMethodBeat.o(131734);
            return format;
        }
    }
}
