package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class a extends b implements l {
    protected String query;
    HashSet<String> wWX = new HashSet<>();
    private long wXS;
    private com.tencent.mm.plugin.fts.a.a.a wXa;
    public List<e.a> wZO = Collections.synchronizedList(new LinkedList());

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.plugin.fts.a.a.a a(MMHandler mMHandler, HashSet<String> hashSet);

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.plugin.fts.a.d.a.a a(int i2, e.a aVar);

    /* access modifiers changed from: protected */
    public abstract void a(k kVar, HashSet<String> hashSet);

    public a(Context context, e.b bVar, int i2) {
        super(context, bVar, i2);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final void a(String str, MMHandler mMHandler, HashSet<String> hashSet, long j2) {
        dOG();
        clearData();
        this.query = str;
        this.wXa = a(mMHandler, hashSet);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final void dOG() {
        if (this.wXa != null) {
            ((n) g.ah(n.class)).cancelSearchTask(this.wXa);
            this.wXa = null;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e, com.tencent.mm.plugin.fts.a.d.b
    public final List<c> GE(long j2) {
        ArrayList arrayList = new ArrayList();
        if (this.wXS > 0) {
            for (int i2 = 0; i2 < this.wZO.size(); i2++) {
                e.a aVar = this.wZO.get(i2);
                int size = aVar.wXI + aVar.mWl.size();
                for (int i3 = 0; i3 < size; i3++) {
                    c b2 = b(i3, aVar);
                    if (b2 != null) {
                        b2.wVZ = this.wXS - j2;
                        b2.position = aVar.wXD + i3 + 1;
                        arrayList.add(b2);
                    }
                }
                if (aVar.tuG) {
                    c cVar = new c();
                    cVar.dUb = String.valueOf(aVar.hashCode());
                    int i4 = aVar.businessType;
                    if (i4 == -3) {
                        cVar.dUm = 4;
                    } else if (i4 == -4) {
                        cVar.dUm = 3;
                    } else if (i4 == -1) {
                        cVar.dUm = 12;
                    } else if (i4 == -2) {
                        cVar.dUm = 11;
                    } else if (i4 == -6) {
                        cVar.dUm = 10;
                    } else if (i4 == -13) {
                        cVar.dUm = 19;
                    } else if (i4 == -7) {
                        cVar.dUm = 5;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        cVar.wVZ = this.wXS - j2;
                        cVar.position = aVar.wXF;
                        arrayList.add(cVar);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public int Nn(int i2) {
        int i3;
        int size = this.wZO.size();
        int i4 = 0;
        int i5 = i2;
        while (i4 < size) {
            e.a aVar = this.wZO.get(i4);
            aVar.wXD = i5;
            if (aVar.wXE) {
                i5++;
            }
            int size2 = i5 + aVar.mWl.size() + aVar.wXI;
            aVar.wXF = size2;
            if (aVar.tuG) {
                i3 = size2 + 1;
            } else {
                i3 = size2;
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final com.tencent.mm.plugin.fts.a.d.a.a No(int i2) {
        com.tencent.mm.plugin.fts.a.d.a.a aVar;
        int size = this.wZO.size();
        for (int i3 = 0; i3 < size; i3++) {
            e.a aVar2 = this.wZO.get(i3);
            if (aVar2.wXD == i2 && aVar2.wXE) {
                aVar = c(i2, aVar2);
            } else if (aVar2.wXF == i2 && aVar2.tuG) {
                aVar = d(i2, aVar2);
            } else if (i2 <= aVar2.wXF) {
                aVar = a(i2, aVar2);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                if (aVar.position == aVar2.wXF) {
                    aVar.wXK = false;
                }
                aVar.mve = this.mve;
                aVar.wWd = aVar2.wWd;
                aVar.rjr = aVar2.businessType;
                return aVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.plugin.fts.ui.a.k c(int i2, e.a aVar) {
        return new com.tencent.mm.plugin.fts.ui.a.k(i2);
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.plugin.fts.ui.a.n d(int i2, e.a aVar) {
        com.tencent.mm.plugin.fts.ui.a.n nVar = new com.tencent.mm.plugin.fts.ui.a.n(i2);
        nVar.wXM = aVar.wXF - aVar.wXD;
        nVar.wXT = true;
        return nVar;
    }

    /* access modifiers changed from: protected */
    public c b(int i2, e.a aVar) {
        return null;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final void clearData() {
        this.query = null;
        this.wWX.clear();
        this.wZO.clear();
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        switch (kVar.resultCode) {
            case -3:
            case -2:
            case -1:
                Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", Integer.valueOf(getType()), Integer.valueOf(kVar.resultCode), kVar.wTn.query);
                if (!kVar.wTn.query.equals(this.query)) {
                    Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
                    return;
                }
                break;
            case 0:
                Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", Integer.valueOf(getType()), Integer.valueOf(kVar.wXb.size()));
                if (this.query != null && this.query.equals(kVar.wTn.query)) {
                    this.wXS = System.currentTimeMillis();
                    this.wWX = kVar.wTn.wWX;
                    a(kVar, this.wWX);
                    break;
                } else {
                    Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", kVar.wTn.query, this.query);
                    return;
                }
            default:
                return;
        }
        this.wXC.a(this, kVar.wTn.query);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final LinkedList<Integer> dOH() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int size = this.wZO.size();
        for (int i2 = 0; i2 < size; i2++) {
            e.a aVar = this.wZO.get(i2);
            if (aVar.wXD != Integer.MAX_VALUE) {
                linkedList.add(Integer.valueOf(aVar.wXD));
            }
        }
        return linkedList;
    }

    public com.tencent.mm.plugin.fts.a.d.a.a a(int i2, int i3, m mVar, e.a aVar) {
        return null;
    }

    public final int dPa() {
        int size = this.wZO.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            for (m mVar : this.wZO.get(i3).mWl) {
                String nullAs = Util.nullAs(mVar.wVX, "");
                char c2 = 65535;
                switch (nullAs.hashCode()) {
                    case -19329355:
                        if (nullAs.equals("create_chatroom​")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 255180560:
                        if (nullAs.equals("no_result​")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 541269703:
                        if (nullAs.equals("create_talker_message​")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                        break;
                    default:
                        i2++;
                        break;
                }
            }
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final int dOI() {
        return dPa();
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public final long dOJ() {
        return this.wXS;
    }
}
