package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.fts.ui.d.n;
import com.tencent.mm.plugin.fts.ui.widget.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends d implements e.b {
    private boolean wrW;
    private MMHandler xad = new MMHandler(Looper.getMainLooper());
    List<e> xbB;
    private n xbC;
    public b xbD;
    i xbE;
    private long xbF;
    private long xbG;
    private long xbH;
    private long xbI;
    private MMHandler xbJ = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.fts.ui.k.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(111945);
            switch (message.what) {
                case 1:
                    if (!k.this.xbw && k.this.getCount() > 0) {
                        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOn();
                        o.DCM.start();
                        k.this.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.o(111945);
        }
    };
    private int xbK = -1;
    private boolean xbL;
    boolean xbM;
    public boolean xbo;
    private boolean xbw;
    public boolean xby;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(com.tencent.mm.plugin.fts.ui.e r7, int r8, com.tencent.mm.plugin.fts.ui.widget.i r9) {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.k.<init>(com.tencent.mm.plugin.fts.ui.e, int, com.tencent.mm.plugin.fts.ui.widget.i):void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final com.tencent.mm.plugin.fts.a.d.a.a No(int i2) {
        long j2;
        com.tencent.mm.plugin.fts.a.d.a.a aVar;
        int i3;
        AppMethodBeat.i(111948);
        long j3 = 0;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        Iterator<e> it = this.xbB.iterator();
        while (true) {
            if (!it.hasNext()) {
                j2 = j3;
                break;
            }
            e next = it.next();
            com.tencent.mm.plugin.fts.a.d.a.a No = next.No(i2);
            j3 = next.dOJ();
            if (No != null) {
                aVar2 = No;
                j2 = j3;
                break;
            }
            aVar2 = No;
        }
        if (aVar2 == null) {
            com.tencent.mm.plugin.fts.a.d.a.a No2 = this.xbC.No(i2);
            j2 = this.xbC.wXS;
            aVar = No2;
        } else {
            aVar = aVar2;
        }
        if (aVar != null) {
            LinkedList linkedList = new LinkedList();
            for (e eVar : this.xbB) {
                linkedList.addAll(eVar.dOH());
            }
            int size = linkedList.size() - 1;
            while (true) {
                if (size < 0) {
                    i3 = i2;
                    break;
                } else if (i2 > ((Integer) linkedList.get(size)).intValue()) {
                    i3 = i2 - size;
                    break;
                } else {
                    size--;
                }
            }
            aVar.wXL = i3;
            aVar.pageType = 1;
            aVar.wXS = j2;
        }
        if (aVar == null) {
            Log.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", Integer.valueOf(getCount()), Integer.valueOf(i2));
        }
        AppMethodBeat.o(111948);
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        AppMethodBeat.i(111949);
        super.a(context, aVar);
        b bVar = this.xbD;
        switch (aVar.qcr) {
            case -1:
            case 0:
            case 11:
                AppMethodBeat.o(111949);
                return;
            default:
                for (c cVar : bVar.xeG) {
                    if (cVar.position == aVar.position) {
                        cVar.wVY = System.currentTimeMillis() - bVar.xaI;
                        AppMethodBeat.o(111949);
                        return;
                    }
                }
                AppMethodBeat.o(111949);
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        boolean z = true;
        AppMethodBeat.i(111950);
        if (!Util.isNullOrNil(this.xbD.query) && !this.wrW && this.xbD.xej != 0) {
            l.a(this.xbD);
            l.b(this.xbD);
            this.wrW = true;
        }
        this.wrW = false;
        this.xbo = false;
        this.xby = false;
        this.xbK = -1;
        this.xbM = false;
        this.xbL = false;
        this.xbD.reset();
        com.tencent.mm.plugin.fts.a.e.wVn = d.Ni(3);
        this.xbD.xej = com.tencent.mm.plugin.fts.a.e.wVn;
        this.xbD.query = this.query;
        this.xbD.xaI = System.currentTimeMillis();
        this.xbF = 0;
        this.xbG = 0;
        this.xbH = 0;
        this.xbI = 0;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("filehelper");
        boolean aUM = z.aUM();
        if (aUM) {
            z = aUM;
        } else if (Util.getInt(h.aqJ().getValue("BindQQSwitch"), 1) != 1) {
            z = false;
        }
        if (!z) {
            Log.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        hashSet.add("62");
        if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            Log.i("MicroMsg.FTS.FTSMainAdapter", "checkLookVisibility EuropeanUnionCountry");
            hashSet.add("65");
        }
        if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clc()) {
            hashSet.add("63");
        } else {
            hashSet.add("67");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.e) g.af(com.tencent.mm.plugin.appbrand.service.e.class)).bVr()) {
            hashSet.add("69");
        }
        if (!((com.tencent.mm.plugin.appbrand.service.h) g.af(com.tencent.mm.plugin.appbrand.service.h.class)).bVr()) {
            hashSet.add("71");
        }
        b(hashSet);
        this.xbC.a(this.query, this.xad, null, com.tencent.mm.plugin.fts.a.e.wVn);
        AppMethodBeat.o(111950);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void finish() {
        AppMethodBeat.i(111951);
        if (!this.xbo) {
            this.xbo = true;
            if (!this.xby) {
                l.a(this.query, false, dOI(), 0, this.xbD);
            }
        }
        if (!this.wrW) {
            this.wrW = true;
            l.a(this.xbD);
            l.b(this.xbD);
        }
        this.xbD.reset();
        super.finish();
        AppMethodBeat.o(111951);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void clearCache() {
        AppMethodBeat.i(111952);
        super.clearCache();
        for (e eVar : this.xbB) {
            eVar.dOG();
            eVar.clearData();
        }
        this.xbC.dOG();
        this.xbC.clearData();
        AppMethodBeat.o(111952);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void stopSearch() {
        AppMethodBeat.i(111953);
        this.xbJ.removeMessages(1);
        super.stopSearch();
        AppMethodBeat.o(111953);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    @Override // com.tencent.mm.plugin.fts.ui.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.View r10, com.tencent.mm.plugin.fts.a.d.a.a r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.k.a(android.view.View, com.tencent.mm.plugin.fts.a.d.a.a, boolean):boolean");
    }

    public final boolean dPt() {
        return this.xbM && this.xbL;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(111955);
        if (eVar instanceof a) {
            a aVar = (a) eVar;
            if (str.equals(this.query)) {
                b(aVar.wWX);
            }
            if (aVar.dPa() > 0 && this.xbF == 0) {
                this.xbF = System.currentTimeMillis() - this.xaI;
                l.ao(9, this.xbF);
                Log.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", Long.valueOf(this.xbF));
            }
            switch (aVar.getType()) {
                case 16:
                    if (this.xbG == 0) {
                        this.xbG = System.currentTimeMillis() - this.xaI;
                        Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", Long.valueOf(this.xbG));
                        l.ao(0, this.xbG);
                        break;
                    }
                    break;
                case 32:
                    if (this.xbH == 0) {
                        this.xbH = System.currentTimeMillis() - this.xaI;
                        Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", Long.valueOf(this.xbH));
                        l.ao(3, this.xbH);
                        break;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    if (this.xbI == 0) {
                        this.xbI = System.currentTimeMillis() - this.xaI;
                        Log.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", Long.valueOf(this.xbI));
                        l.ao(6, this.xbI);
                        break;
                    }
                    break;
            }
            b bVar = this.xbD;
            for (e.a aVar2 : aVar.wZO) {
                int size = (aVar2.tuG ? 1 : 0) + aVar2.mWl.size();
                switch (aVar2.businessType) {
                    case -13:
                        bVar.xer = size;
                        break;
                    case -11:
                        bVar.xeq = size;
                        break;
                    case -8:
                        bVar.xek = size;
                        break;
                    case -7:
                        bVar.xen = size;
                        break;
                    case -6:
                        bVar.xep = size;
                        break;
                    case -4:
                        bVar.xel = size;
                        break;
                    case -3:
                        bVar.xem = size;
                        break;
                    case -2:
                        bVar.xeo = size;
                        break;
                    case -1:
                        bVar.favCount = size;
                        break;
                }
            }
        } else {
            b bVar2 = this.xbD;
            if (eVar.dOI() > 0) {
                if (eVar.dOF() == 2) {
                    bVar2.xet = eVar.dOI();
                } else {
                    bVar2.xes = eVar.dOI();
                }
            }
        }
        this.xbD.xeE = dOI();
        new a(eVar, str).run();
        AppMethodBeat.o(111955);
    }

    class a implements Runnable {
        private String query;
        private e xbO;

        a(e eVar, String str) {
            this.query = str;
            this.xbO = eVar;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(111946);
            if (!k.this.xbM && ((e) k.this.xbB.get(k.this.xbB.size() - 1)).getType() == this.xbO.getType()) {
                k.this.xbM = true;
            }
            if (!k.this.xbL && this.xbO.getType() == 256) {
                k.this.xbL = true;
            }
            k.this.xbD.xeD = k.this.dPt();
            int i3 = 0;
            for (e eVar : k.this.xbB) {
                i3 = eVar.Nn(i3);
            }
            int Nn = k.this.xbC.Nn(i3);
            k.this.setCount(Nn);
            k.this.notifyDataSetChanged();
            k kVar = k.this;
            kVar.ax(Nn, kVar.dPt());
            if (k.this.dPt()) {
                k.this.xbD.xeh = System.currentTimeMillis();
            }
            b bVar = k.this.xbD;
            bVar.xeG.addAll(this.xbO.GE(bVar.xaI));
            b bVar2 = k.this.xbD;
            bVar2.xeA = Nn;
            for (c cVar : bVar2.xeG) {
                if ("SearchContactBar".equals(cVar.dUb)) {
                    cVar.position = bVar2.xeA + 1;
                }
            }
            for (c cVar2 : bVar2.xeG) {
                if ("SOSBar".equals(cVar2.dUb)) {
                    if (bVar2.xew > 0 || bVar2.xex > 0) {
                        cVar2.position = bVar2.xeA + 2;
                    } else {
                        cVar2.position = bVar2.xeA + 1;
                    }
                }
            }
            if (bVar2.xew > 0 || bVar2.xex > 0) {
                i2 = bVar2.xeA + 3;
            } else {
                i2 = bVar2.xeA + 2;
            }
            for (c cVar3 : bVar2.xeG) {
                if (cVar3.dUb.startsWith("SOSRelevant")) {
                    cVar3.position = i2;
                }
            }
            AppMethodBeat.o(111946);
        }
    }

    private void b(HashSet<String> hashSet) {
        AppMethodBeat.i(111956);
        this.xbK++;
        if (this.xbK < this.xbB.size()) {
            this.xbB.get(this.xbK).a(this.query, this.xad, hashSet, com.tencent.mm.plugin.fts.a.e.wVn);
        }
        AppMethodBeat.o(111956);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(111957);
        super.onScroll(absListView, i2, i3, i4);
        FTSMainUI fTSMainUI = (FTSMainUI) this.xaG;
        int headerViewsCount = ((ListView) absListView).getHeaderViewsCount();
        if (fTSMainUI.xch == 1 && absListView.getLastVisiblePosition() >= headerViewsCount + fTSMainUI.xbX.getCount() && fTSMainUI.xbX.dPt() && fTSMainUI.xbZ.getVisibility() == 0) {
            fTSMainUI.xch = 2;
            b bVar = fTSMainUI.xbX.xbD;
            for (c cVar : bVar.xeG) {
                if ("SearchContactBar".equals(cVar.dUb)) {
                    cVar.wVY = System.currentTimeMillis() - bVar.xaI;
                }
            }
        }
        i iVar = fTSMainUI.xbV;
        int headerViewsCount2 = ((ListView) absListView).getHeaderViewsCount();
        if (absListView.getLastVisiblePosition() >= iVar.xfV.xbX.getCount() + headerViewsCount2 && iVar.xfV.xbX.dPt() && iVar.xat == 1 && iVar.xaY.getVisibility() == 0) {
            Log.i("MicroMsg.FTS.PardusSearchLogic", "onScroll webEntry hasResult:%s hasSug:%s", Boolean.valueOf(iVar.dDz), Boolean.valueOf(iVar.xgF));
            if (!iVar.dDz) {
                iVar.xat = 2;
                b bVar2 = iVar.xfV.xbX.xbD;
                Iterator<c> it = bVar2.xeG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if ("SOSBar".equals(next.dUb)) {
                        next.wVY = System.currentTimeMillis() - bVar2.xaI;
                        break;
                    }
                }
            }
        }
        if (absListView.getLastVisiblePosition() >= headerViewsCount2 + iVar.xfV.xbX.getCount() && iVar.xfV.xbX.dPt() && iVar.xba.getVisibility() == 0 && !iVar.xgF) {
            int jo = com.tencent.mm.cb.a.jo(iVar.xfV);
            for (int i5 = 0; i5 < iVar.xba.getChildCount(); i5++) {
                View childAt = iVar.xba.getChildAt(i5);
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                int measuredHeight = iArr[1] + childAt.getMeasuredHeight();
                alv alv = (alv) childAt.getTag();
                if (measuredHeight <= jo) {
                    b bVar3 = iVar.xfV.xbX.xbD;
                    String str = "SOSRelevant-" + alv.Lux.MEq;
                    Iterator<c> it2 = bVar3.xeG.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        c next2 = it2.next();
                        if (str.equals(next2.dUb) && next2.wVY == 0) {
                            next2.wVY = System.currentTimeMillis() - bVar3.xaI;
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        iVar.e(0, "", "", "", alv.Lux.MEq);
                    }
                }
            }
        }
        AppMethodBeat.o(111957);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(111958);
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 2) {
            this.xbw = true;
            ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOl();
            o.DCM.pause();
            AppMethodBeat.o(111958);
            return;
        }
        this.xbw = false;
        if (!((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().dOm()) {
            this.xbJ.removeMessages(1);
            this.xbJ.sendEmptyMessageDelayed(1, 200);
        }
        AppMethodBeat.o(111958);
    }

    public final void dPu() {
        this.xby = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final int dOI() {
        AppMethodBeat.i(111959);
        int i2 = 0;
        for (e eVar : this.xbB) {
            i2 = eVar.dOI() + i2;
        }
        int dOI = this.xbC.dOI() + i2;
        AppMethodBeat.o(111959);
        return dOI;
    }

    public final void Nr(int i2) {
        this.xbD.xeB = i2;
    }
}
