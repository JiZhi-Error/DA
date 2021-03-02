package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.brandservice.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class g extends c {
    List<dkz> ppW = null;
    private SparseArray<a> ppX = new SparseArray<>();
    private int ppY;

    @Override // com.tencent.mm.ui.base.sortview.b
    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(5777);
        com.tencent.mm.ui.base.sortview.a Dc = Dc(i2);
        AppMethodBeat.o(5777);
        return Dc;
    }

    public g(Context context) {
        super(context);
        AppMethodBeat.i(5770);
        setReporter(new c.b() {
            /* class com.tencent.mm.plugin.brandservice.ui.g.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.brandservice.ui.c.b
            public final void a(c cVar, com.tencent.mm.ui.base.sortview.a aVar, int i2, String str, int i3, int i4) {
                AppMethodBeat.i(5769);
                ru CX = g.this.CX(i4);
                String str2 = Util.nullAsNil(g.this.poa) + "," + i2 + "," + Util.nullAsNil(str) + "," + i3 + "," + cVar.poi + "," + (CX == null ? "" : CX.KZj + ",0");
                h.INSTANCE.kvStat(10866, str2);
                Log.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(str2)));
                AppMethodBeat.o(5769);
            }
        });
        AppMethodBeat.o(5770);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.c
    public final void m(String str, List<ru> list) {
        AppMethodBeat.i(5771);
        super.m(str, list);
        this.ppY = super.getCount();
        AppMethodBeat.o(5771);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.c
    public final void a(ru ruVar, boolean z) {
        AppMethodBeat.i(5772);
        super.a(ruVar, z);
        if (this.ppY == 0) {
            this.ppY = super.getCount();
        }
        AppMethodBeat.o(5772);
    }

    @Override // com.tencent.mm.ui.base.sortview.b, com.tencent.mm.plugin.brandservice.ui.c
    public final int getCount() {
        int i2;
        AppMethodBeat.i(5773);
        int count = super.getCount();
        if (count == 0 && this.ppW != null) {
            Iterator<dkz> it = this.ppW.iterator();
            while (true) {
                i2 = count;
                if (!it.hasNext()) {
                    break;
                }
                dkz next = it.next();
                if (!(next == null || next.MOV == null)) {
                    i2 += next.MOV.size();
                }
                count = i2;
            }
            count = i2;
        }
        AppMethodBeat.o(5773);
        return count;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.c
    public final void clV() {
        AppMethodBeat.i(5774);
        super.clV();
        AppMethodBeat.o(5774);
    }

    @Override // com.tencent.mm.ui.base.sortview.b
    public final com.tencent.mm.ui.base.sortview.a Dc(int i2) {
        String str;
        dsn dsn;
        AppMethodBeat.i(5775);
        int count = super.getCount();
        if (count != 0) {
            com.tencent.mm.ui.base.sortview.a Dc = super.getItem(i2);
            AppMethodBeat.o(5775);
            return Dc;
        }
        a aVar = this.ppX.get(i2);
        if (aVar == null && this.ppW.size() > 0) {
            Iterator<dkz> it = this.ppW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    dsn = null;
                    break;
                }
                dkz next = it.next();
                if (count == i2) {
                    str = next.MOT == null ? null : next.MOT.toString();
                    dsn = next.MOV.get(0);
                } else if (i2 < next.MOV.size() + count) {
                    dsn = next.MOV.get(i2 - count);
                    str = null;
                    break;
                } else {
                    count = next.MOV.size() + count;
                }
            }
            b bVar = new b(dsn, str);
            bVar.Dd(i2);
            bVar.setPosition(i2);
            this.ppX.put(i2, bVar);
            aVar = bVar;
        }
        AppMethodBeat.o(5775);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.b, com.tencent.mm.plugin.brandservice.ui.c
    public final Object[] CZ(int i2) {
        AppMethodBeat.i(5776);
        c.a CW = CW(i2);
        ru CX = CX(i2);
        if (CW != null) {
            Object[] objArr = new Object[4];
            objArr[0] = this;
            objArr[1] = CW.pol;
            objArr[2] = Integer.valueOf(i2 < this.ppY ? 39 : 56);
            objArr[3] = CX != null ? CX.KZj : "";
            AppMethodBeat.o(5776);
            return objArr;
        }
        Object[] CZ = super.CZ(i2);
        AppMethodBeat.o(5776);
        return CZ;
    }
}
