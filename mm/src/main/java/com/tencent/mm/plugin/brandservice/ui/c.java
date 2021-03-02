package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class c extends com.tencent.mm.ui.base.sortview.b {
    private int cSs;
    protected int mScene;
    protected String poa;
    protected int pob;
    private List<a> poe = new ArrayList();
    private boolean pof;
    protected boolean pog;
    protected boolean poh;
    int poi;
    protected long[] poj;
    protected b pok;

    public interface b {
        void a(c cVar, com.tencent.mm.ui.base.sortview.a aVar, int i2, String str, int i3, int i4);
    }

    /* access modifiers changed from: protected */
    public static class a {
        public int continueFlag;
        public int count;
        public long dDw;
        public List<sb> gzD;
        public List<String> pol;
        public boolean pom;
        public boolean pon;
        public List<ru> poo;

        protected a() {
        }
    }

    public c(Context context) {
        super(context);
        AppMethodBeat.i(5624);
        F(true, true);
        this.pof = true;
        b(1);
        AppMethodBeat.o(5624);
    }

    public void m(String str, List<ru> list) {
        AppMethodBeat.i(5625);
        this.poe.clear();
        this.OZO.clear();
        MMHandlerThread.postToMainThread(this.OZP);
        this.cSs = 0;
        this.poa = str;
        if (list != null) {
            this.poi = (int) (System.currentTimeMillis() / 1000);
            for (int i2 = 0; i2 < list.size(); i2++) {
                ru ruVar = list.get(i2);
                if (!(ruVar == null || ruVar.xKD == null || ruVar.xKD.size() <= 0)) {
                    a a2 = a(ruVar);
                    this.cSs += a(a2);
                    this.poe.add(a2);
                    Log.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", Long.valueOf(a2.dDw), Integer.valueOf(a2.count), Integer.valueOf(this.cSs));
                }
            }
            clU();
        }
        MMHandlerThread.postToMainThread(this.OZP);
        AppMethodBeat.o(5625);
    }

    private a a(ru ruVar) {
        AppMethodBeat.i(5626);
        a aVar = new a();
        aVar.poo = new LinkedList();
        aVar.poo.add(ruVar);
        aVar.dDw = ruVar.KZg;
        aVar.count = ruVar.xKD.size();
        aVar.continueFlag = ruVar.KZh;
        aVar.gzD = new LinkedList();
        aVar.gzD.addAll(ruVar.xKD);
        aVar.pol = ruVar.KZi;
        aVar.pom = this.poh;
        aVar.pon = b(aVar);
        AppMethodBeat.o(5626);
        return aVar;
    }

    public void a(ru ruVar, boolean z) {
        AppMethodBeat.i(5627);
        if ((!this.pof || ruVar != null) && ruVar.xKD != null) {
            if (isEmpty()) {
                this.poi = (int) (System.currentTimeMillis() / 1000);
            }
            a BE = BE(ruVar.KZg);
            if (BE != null) {
                if (BE.gzD == null) {
                    BE.gzD = new LinkedList();
                }
                BE.gzD.addAll(ruVar.xKD);
                if (BE.poo == null) {
                    BE.poo = new LinkedList();
                }
                BE.poo.add(ruVar);
                BE.count += ruVar.xKD.size();
                this.cSs += ruVar.xKD.size();
            } else if (z) {
                this.poe.add(a(ruVar));
                clU();
            } else {
                Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", Long.valueOf(ruVar.KZg));
                AppMethodBeat.o(5627);
                return;
            }
            MMHandlerThread.postToMainThread(this.OZP);
            AppMethodBeat.o(5627);
            return;
        }
        Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
        AppMethodBeat.o(5627);
    }

    /* access modifiers changed from: package-private */
    public final a BE(long j2) {
        AppMethodBeat.i(5628);
        int BF = BF(j2);
        if (BF >= 0) {
            a aVar = this.poe.get(BF);
            AppMethodBeat.o(5628);
            return aVar;
        }
        AppMethodBeat.o(5628);
        return null;
    }

    private int BF(long j2) {
        AppMethodBeat.i(5629);
        for (int i2 = 0; i2 < this.poe.size(); i2++) {
            if (this.poe.get(i2).dDw == j2) {
                AppMethodBeat.o(5629);
                return i2;
            }
        }
        AppMethodBeat.o(5629);
        return -1;
    }

    /* access modifiers changed from: protected */
    public final a CW(int i2) {
        AppMethodBeat.i(5630);
        if (i2 >= 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.poe.size(); i4++) {
                a aVar = this.poe.get(i4);
                i3 += a(aVar);
                if (i2 < i3) {
                    AppMethodBeat.o(5630);
                    return aVar;
                }
            }
        }
        AppMethodBeat.o(5630);
        return null;
    }

    /* access modifiers changed from: protected */
    public final ru CX(int i2) {
        AppMethodBeat.i(5631);
        if (i2 >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= this.poe.size()) {
                    break;
                }
                a aVar = this.poe.get(i3);
                int a2 = a(aVar);
                i4 += a2;
                if (i2 < i4) {
                    int i5 = (aVar.pom ? 1 : 0) + (i4 - a2);
                    for (int i6 = 0; i6 < aVar.poo.size(); i6++) {
                        ru ruVar = aVar.poo.get(i6);
                        i5 += ruVar.xKD.size();
                        if (i2 < i5) {
                            AppMethodBeat.o(5631);
                            return ruVar;
                        }
                    }
                } else {
                    i3++;
                }
            }
        }
        AppMethodBeat.o(5631);
        return null;
    }

    private static int a(a aVar) {
        int i2 = 1;
        if (aVar == null) {
            return 0;
        }
        int i3 = (aVar.pom ? 1 : 0) + aVar.count;
        if (!aVar.pon) {
            i2 = 0;
        }
        return i3 + i2;
    }

    private synchronized void clU() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(5632);
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < this.poe.size(); i2++) {
                a aVar = this.poe.get(i2);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.dDw), aVar);
                }
            }
            this.poe.clear();
            this.cSs = 0;
            for (int i3 = 0; i3 < this.poj.length; i3++) {
                a aVar2 = (a) hashMap.get(Long.valueOf(this.poj[i3]));
                if (aVar2 != null) {
                    this.poe.add(aVar2);
                    this.cSs = a(aVar2) + this.cSs;
                }
            }
            if (this.poe.size() > 0) {
                a aVar3 = this.poe.get(this.poe.size() - 1);
                if (aVar3.pon == this.pof) {
                    this.cSs = (aVar3.pon ? -1 : 1) + this.cSs;
                    if (this.pof) {
                        z = false;
                    }
                    aVar3.pon = z;
                }
            }
            hashMap.clear();
            AppMethodBeat.o(5632);
        }
    }

    private boolean b(a aVar) {
        return this.pog && aVar.continueFlag != 0;
    }

    public final void F(boolean z, boolean z2) {
        this.poh = z;
        this.pog = z2;
    }

    public final void setScene(int i2) {
        this.mScene = i2;
    }

    public final void setAddContactScene(int i2) {
        this.pob = i2;
    }

    public final void b(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.poj = jArr;
        }
    }

    @Override // com.tencent.mm.ui.base.sortview.b
    public int getCount() {
        return this.cSs;
    }

    public void clV() {
        AppMethodBeat.i(5633);
        m(null, null);
        this.poi = 0;
        AppMethodBeat.o(5633);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    @Override // com.tencent.mm.ui.base.sortview.b
    public final com.tencent.mm.ui.base.sortview.a CY(int i2) {
        com.tencent.mm.ui.base.sortview.a hVar;
        int i3 = 0;
        AppMethodBeat.i(5634);
        int i4 = 0;
        for (int i5 = 0; i5 < this.poe.size(); i5++) {
            a aVar = this.poe.get(i5);
            int a2 = a(aVar);
            i4 += a2;
            if (aVar.pom && i2 == i4 - a2) {
                ru ruVar = aVar.poo.size() == 0 ? null : aVar.poo.get(0);
                if (ruVar != null) {
                    d dVar = new d(ruVar.Title);
                    AppMethodBeat.o(5634);
                    return dVar;
                }
            } else if (aVar.pon && i2 == i4 - 1) {
                f fVar = new f(aVar.dDw, aVar.count, this.poa);
                AppMethodBeat.o(5634);
                return fVar;
            } else if (i2 < i4) {
                int i6 = (i2 - i4) + aVar.count;
                if (aVar.pon) {
                    i3 = 1;
                }
                int i7 = i3 + i6;
                sb sbVar = aVar.gzD.get(i7);
                long j2 = aVar.dDw;
                b bVar = this.pok;
                if (sbVar == null) {
                    Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                    AppMethodBeat.o(5634);
                    return null;
                }
                if (j2 == 1) {
                    Log.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                    hVar = new a(sbVar);
                } else if (j2 == 4) {
                    hVar = new h(sbVar);
                } else if (j2 == TPAudioFrame.TP_CH_STEREO_RIGHT) {
                    hVar = new h(sbVar);
                } else {
                    hVar = new h(sbVar);
                }
                if (hVar instanceof com.tencent.mm.plugin.brandservice.ui.base.a) {
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar2 = (com.tencent.mm.plugin.brandservice.ui.base.a) hVar;
                    aVar2.Dd(i7);
                    aVar2.setPosition(i2);
                    aVar2.setReporter(bVar);
                }
                AppMethodBeat.o(5634);
                return hVar;
            }
        }
        h hVar2 = new h(null);
        AppMethodBeat.o(5634);
        return hVar2;
    }

    @Override // com.tencent.mm.ui.base.sortview.b
    public Object[] CZ(int i2) {
        AppMethodBeat.i(5635);
        a CW = CW(i2);
        ru CX = CX(i2);
        String str = CX != null ? CX.KZj : "";
        if (CW != null) {
            Object[] objArr = {this, CW.pol, Integer.valueOf(this.pob), str};
            AppMethodBeat.o(5635);
            return objArr;
        }
        AppMethodBeat.o(5635);
        return null;
    }

    public final void setReporter(b bVar) {
        this.pok = bVar;
    }
}
