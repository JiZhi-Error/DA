package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class v extends o {
    private g PTI = new g();
    private List<Integer> PWN;
    protected l PWO = new l() {
        /* class com.tencent.mm.ui.contact.v.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(102892);
            switch (kVar.resultCode) {
                case 0:
                    if (v.this.wXa == null || kVar.wWd == null) {
                        AppMethodBeat.o(102892);
                        return;
                    }
                    v.a(v.this, kVar.wXb);
                    String str = kVar.wWd.wWB;
                    if (v.this.PXp.get(str) == null) {
                        v.this.PXp.put(str, new LinkedList());
                        if (v.this.PXq.get(str) == null) {
                            v.this.PXq.put(str, Boolean.FALSE);
                        }
                        v.this.PXr.put(str, kVar.wWd);
                    }
                    if (kVar.wXb.size() > 0) {
                        switch (kVar.wXb.get(0).type) {
                            case 131072:
                                ((List) v.this.PXp.get(kVar.wWd.wWB)).addAll(kVar.wXb);
                                break;
                            default:
                                Log.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
                                break;
                        }
                    }
                    v.a(v.this, kVar.wTn.query, v.e(v.this));
                    AppMethodBeat.o(102892);
                    return;
                case -3:
                case -2:
                case -1:
                    Log.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", kVar.wTn.query, Integer.valueOf(kVar.resultCode));
                    if (kVar.wTn.query.equals(v.this.PXu.get(v.this.PXv))) {
                        v.e(v.this);
                        break;
                    } else {
                        AppMethodBeat.o(102892);
                        return;
                    }
            }
            AppMethodBeat.o(102892);
        }
    };
    private Map<String, Integer> PXA = new HashMap();
    private int PXB = 0;
    private int PXC = 1;
    private List<String> PXo = new LinkedList();
    private Map<String, List<m>> PXp = null;
    private Map<String, Boolean> PXq = new HashMap();
    private Map<String, h> PXr = null;
    private List<String> PXs;
    private List<String> PXt;
    private List<String> PXu;
    protected int PXv = 0;
    private Map<String, LinkedList<String>> PXw = new HashMap();
    private int[] PXx;
    private Cursor PXy;
    private Map<Integer, String> PXz = new HashMap();
    private int count = 0;
    private List<String> gzY;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private int sHN = 1;
    private a wXa;

    static /* synthetic */ void a(v vVar, String str, boolean z) {
        AppMethodBeat.i(102916);
        vVar.p(str, z, true);
        AppMethodBeat.o(102916);
    }

    static /* synthetic */ boolean e(v vVar) {
        AppMethodBeat.i(102915);
        boolean gVa = vVar.gVa();
        AppMethodBeat.o(102915);
        return gVa;
    }

    public v(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, List<String> list3, boolean z, int i2) {
        super(mMBaseSelectContactUI, z, i2);
        AppMethodBeat.i(102893);
        this.PXt = list;
        this.PXs = list2;
        this.gzY = list3;
        this.PWN = new ArrayList();
        amZ();
        AppMethodBeat.o(102893);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void b(String str, int[] iArr) {
        AppMethodBeat.i(102894);
        this.PXp = new HashMap();
        this.PXr = new HashMap();
        this.PXo.clear();
        if (this.PXy != null) {
            this.PXy.close();
            this.PXy = null;
            this.PXz.clear();
            this.PXA.clear();
        }
        this.count = 0;
        this.PXu = bnx(str);
        this.PXv = 0;
        this.PXx = iArr;
        this.PWN.clear();
        for (int i2 : iArr) {
            this.PWN.add(Integer.valueOf(i2));
        }
        Log.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", str, this.PXu);
        gVa();
        AppMethodBeat.o(102894);
    }

    private List<String> bnx(String str) {
        AppMethodBeat.i(102895);
        LinkedList<String> linkedList = new LinkedList();
        String[] split = str.split(" ");
        for (String str2 : split) {
            if (!Util.isNullOrNil(str2.trim())) {
                linkedList.add(str2);
            }
        }
        linkedList.addAll(this.PXw.keySet());
        if (this.PXu != null) {
            if (linkedList.size() != this.PXu.size()) {
                AppMethodBeat.o(102895);
                return linkedList;
            }
            for (String str3 : linkedList) {
                if (!this.PXu.contains(str3)) {
                    AppMethodBeat.o(102895);
                    return linkedList;
                }
            }
        }
        if (this.PXu == null) {
            AppMethodBeat.o(102895);
            return linkedList;
        }
        List<String> list = this.PXu;
        AppMethodBeat.o(102895);
        return list;
    }

    private void clearTask() {
        AppMethodBeat.i(102896);
        if (this.wXa != null) {
            ((n) g.ah(n.class)).cancelSearchTask(this.wXa);
            this.wXa = null;
        }
        AppMethodBeat.o(102896);
    }

    private void gUZ() {
        AppMethodBeat.i(102897);
        this.PXp = new HashMap();
        this.PXr = new HashMap();
        this.PXo.clear();
        if (this.PXy != null) {
            this.PXy.close();
            this.PXy = null;
            this.PXz.clear();
            this.PXA.clear();
        }
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(102897);
    }

    private void amZ() {
        AppMethodBeat.i(102898);
        this.PXv = 0;
        gUZ();
        clearTask();
        clearCache();
        AppMethodBeat.o(102898);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void clearData() {
        AppMethodBeat.i(102899);
        this.PXw.clear();
        this.PXq.clear();
        amZ();
        AppMethodBeat.o(102899);
    }

    private boolean gVa() {
        AppMethodBeat.i(102900);
        if (this.PWN.size() > 0 && this.PXu.size() > 0) {
            HashSet<String> hashSet = new HashSet<>();
            int intValue = this.PWN.remove(0).intValue();
            j jVar = new j();
            jVar.query = this.PXu.get(this.PXv);
            jVar.wWU = new int[]{intValue};
            jVar.wWX = hashSet;
            jVar.wWZ = this.PWO;
            jVar.handler = this.handler;
            if (intValue == 131075) {
                jVar.kXb = 32;
                jVar.wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;
            } else {
                jVar.kXb = 16;
                jVar.wWY = b.wXy;
            }
            this.wXa = ((n) g.ah(n.class)).search(2, jVar);
            AppMethodBeat.o(102900);
            return false;
        } else if (this.PXv < this.PXu.size() - 1) {
            this.PXv++;
            this.PWN.clear();
            for (int i2 : this.PXx) {
                this.PWN.add(Integer.valueOf(i2));
            }
            gVa();
            AppMethodBeat.o(102900);
            return false;
        } else {
            AppMethodBeat.o(102900);
            return true;
        }
    }

    private void p(String str, boolean z, boolean z2) {
        int i2;
        int i3;
        AppMethodBeat.i(102901);
        if (!z || !gVe() || this.PXt.size() >= 3) {
            i2 = 0;
        } else {
            this.PTI.jE(this.gzY);
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.PXt);
            linkedList.addAll(this.PXs);
            this.PXo = this.PTI.c(linkedList, this.PXp);
            i2 = this.PXo.size() > 0 ? this.PXo.size() + this.sHN + 0 : 0;
            Log.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", Integer.valueOf(this.PXo.size()));
        }
        if (this.PXu != null) {
            i3 = i2;
            for (String str2 : this.PXu) {
                if (this.PXp.get(str2) != null) {
                    if (this.PXp.get(str2).size() > 0) {
                        int size = this.PXp.get(str2).size();
                        if (!gVe() || size <= 3) {
                            i3 = this.sHN + size + i3;
                        } else if (this.PXq.get(str2).booleanValue()) {
                            i3 = this.sHN + size + this.PXC + i3;
                        } else {
                            i3 = this.sHN + 3 + this.PXC + i3;
                        }
                    } else {
                        if (z && gVe()) {
                            this.PXp.get(str).add(new m());
                            i3 += this.PXp.get(str2).size() + this.sHN;
                        }
                        i3 = i3;
                    }
                }
            }
        } else {
            i3 = i2;
        }
        this.PXB = i3;
        if (z && gVe()) {
            gVf();
        }
        if (this.PXy != null) {
            i3 += this.PXy.getCount() + this.PXz.size();
        }
        this.count = i3;
        if (z2 && this.PWf != null) {
            this.PWf.B(str, getCount(), z);
        }
        Log.i("MicroMsg.MultiSearchContactAdapter", "updateHeaderPosition, query:%s, isFinish:%b, searchEnd:%b, count:%d", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(getCount()));
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(102901);
    }

    /* access modifiers changed from: package-private */
    public final boolean gVe() {
        AppMethodBeat.i(102902);
        if (this.PXu == null || this.PXu.size() <= 1) {
            AppMethodBeat.o(102902);
            return false;
        }
        AppMethodBeat.o(102902);
        return true;
    }

    @Override // com.tencent.mm.ui.contact.o
    public final boolean gUN() {
        AppMethodBeat.i(102903);
        boolean gVe = gVe();
        AppMethodBeat.o(102903);
        return gVe;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final int gUt() {
        AppMethodBeat.i(102904);
        int size = this.PXo.size();
        AppMethodBeat.o(102904);
        return size;
    }

    @Override // com.tencent.mm.ui.contact.o
    public final int bnw(String str) {
        AppMethodBeat.i(102905);
        for (LinkedList<String> linkedList : this.PXw.values()) {
            if (linkedList.contains(str)) {
                AppMethodBeat.o(102905);
                return 3;
            }
        }
        if (this.PTI.bnt(str)) {
            AppMethodBeat.o(102905);
            return 4;
        }
        AppMethodBeat.o(102905);
        return 0;
    }

    @Override // com.tencent.mm.ui.contact.o
    public final int bnr(String str) {
        AppMethodBeat.i(102906);
        if (this.PXA.get(str) != null) {
            int intValue = this.PXA.get(str).intValue() + this.PXB;
            AppMethodBeat.o(102906);
            return intValue;
        }
        AppMethodBeat.o(102906);
        return 0;
    }

    @Override // com.tencent.mm.ui.contact.o
    public final String gUO() {
        AppMethodBeat.i(102907);
        for (String str : this.PXw.keySet()) {
            String[] strArr = (String[]) this.PXw.get(str).toArray(new String[0]);
            for (String str2 : strArr) {
                if (!this.PXs.contains(str2)) {
                    this.PXw.get(str).remove(str2);
                }
            }
        }
        Iterator<String> it = this.PXw.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (this.PXw.get(next).size() == 0) {
                this.PXw.remove(next);
                break;
            }
        }
        String str3 = "";
        for (String str4 : this.PXu) {
            str3 = !this.PXw.containsKey(str4) ? str3 + str4 + " " : str3;
        }
        if (Util.isNullOrNil(str3) && gVe()) {
            str3 = " ";
        }
        Log.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", str3);
        AppMethodBeat.o(102907);
        return str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gVf() {
        /*
        // Method dump skipped, instructions count: 318
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.v.gVf():void");
    }

    public final int getCount() {
        return this.count;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.tencent.mm.ui.contact.a.e, com.tencent.mm.ui.contact.a.a] */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.tencent.mm.ui.contact.a.j] */
    /* JADX WARN: Type inference failed for: r0v36, types: [com.tencent.mm.ui.contact.a.a] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // com.tencent.mm.ui.contact.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ui.contact.a.a va(int r13) {
        /*
        // Method dump skipped, instructions count: 696
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.v.va(int):com.tencent.mm.ui.contact.a.a");
    }

    private static com.tencent.mm.ui.contact.a.a hj(String str, int i2) {
        AppMethodBeat.i(102910);
        com.tencent.mm.ui.contact.a.h hVar = new com.tencent.mm.ui.contact.a.h(i2);
        hVar.header = str;
        AppMethodBeat.o(102910);
        return hVar;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(102911);
        super.finish();
        Log.i("MicroMsg.MultiSearchContactAdapter", "finish!");
        clearData();
        AppMethodBeat.o(102911);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(102912);
        int i2 = aVar.position + 1;
        if (i2 >= this.count) {
            AppMethodBeat.o(102912);
            return true;
        } else if (i2 >= this.PXB && this.PXz.get(Integer.valueOf(i2 - this.PXB)) != null) {
            AppMethodBeat.o(102912);
            return true;
        } else if (this.PXo.size() > 0 && i2 == this.PXo.size() + this.sHN) {
            AppMethodBeat.o(102912);
            return true;
        } else if (i2 < this.PXB) {
            com.tencent.mm.ui.contact.a.a va = va(i2);
            if (va != null || !(va instanceof com.tencent.mm.ui.contact.a.h)) {
                AppMethodBeat.o(102912);
                return false;
            }
            AppMethodBeat.o(102912);
            return true;
        } else {
            AppMethodBeat.o(102912);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.contact.p
    public final boolean anI(int i2) {
        boolean z = false;
        AppMethodBeat.i(102913);
        com.tencent.mm.ui.contact.a.a anH = getItem(i2 - this.PWg.getContentLV().getHeaderViewsCount());
        if (anH instanceof com.tencent.mm.ui.contact.a.j) {
            this.PXq.put(anH.query, Boolean.valueOf(!this.PXq.get(anH.query).booleanValue()));
            p(null, true, false);
            this.PWg.getContentLV().setSelection(this.PWg.getContentLV().getSelectedItemPosition());
            z = true;
        } else if (!Util.isNullOrNil(anH.query) && (anH instanceof e)) {
            if (!this.PXs.contains(anH.contact.field_username)) {
                if (this.PXw.get(anH.query) == null) {
                    this.PXw.put(anH.query, new LinkedList<>());
                }
                this.PXw.get(anH.query).add(anH.contact.field_username);
            } else if (this.PXw.get(anH.query) != null) {
                this.PXw.get(anH.query).remove(anH.contact.field_username);
            }
            this.PTI.reset();
        }
        AppMethodBeat.o(102913);
        return z;
    }

    static /* synthetic */ void a(v vVar, List list) {
        boolean z;
        AppMethodBeat.i(102914);
        if (vVar.gzY != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                m mVar = (m) list.get(size);
                if (!vVar.gzY.contains(mVar.wVX)) {
                    int i2 = mVar.type;
                    if (i2 == 131072 || i2 == 131075 || i2 == 131076 || i2 == 131081) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                    }
                }
                list.remove(size);
            }
        }
        AppMethodBeat.o(102914);
    }
}
