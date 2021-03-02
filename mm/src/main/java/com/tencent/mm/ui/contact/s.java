package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
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
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class s extends o {
    private int PTA = Integer.MAX_VALUE;
    protected int PTz = Integer.MAX_VALUE;
    private List<String> PWD;
    private int PWE = Integer.MAX_VALUE;
    private int PWF = Integer.MAX_VALUE;
    private int PWG = Integer.MAX_VALUE;
    private boolean PWH = true;
    private int PWI = Integer.MAX_VALUE;
    private boolean PWJ = true;
    private int PWK = Integer.MAX_VALUE;
    private List<m> PWL = null;
    private List<m> PWM = null;
    private List<Integer> PWN;
    protected l PWO = new l() {
        /* class com.tencent.mm.ui.contact.s.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(102870);
            switch (kVar.resultCode) {
                case -3:
                case -2:
                case -1:
                    if (kVar.wTn.query.equals(s.this.query)) {
                        s.c(s.this);
                        break;
                    } else {
                        AppMethodBeat.o(102870);
                        return;
                    }
                case 0:
                    if (s.this.wXa != null && s.this.wXa.equals(s.this.wXa)) {
                        s.this.wWd = kVar.wWd;
                        s.this.jJ(kVar.wXb);
                        if (kVar.wXb.size() > 0) {
                            switch (kVar.wXb.get(0).type) {
                                case 131072:
                                    s.this.gxh = kVar.wXb;
                                    break;
                                case 131075:
                                    s.this.wZw = kVar.wXb;
                                    break;
                                case 131076:
                                    s.this.PWM = kVar.wXb;
                                    break;
                                case 131081:
                                    if (s.this.gxh == null) {
                                        s.this.gxh = kVar.wXb;
                                        break;
                                    } else {
                                        s.this.gxh.addAll(kVar.wXb);
                                        break;
                                    }
                                default:
                                    Log.i("MicroMsg.MMSearchContactAdapter", "not support search");
                                    break;
                            }
                        }
                        s.a(s.this, kVar.wTn.query, s.c(s.this));
                        AppMethodBeat.o(102870);
                        return;
                    }
            }
            AppMethodBeat.o(102870);
        }
    };
    private boolean VlU = false;
    private int count = 0;
    private List<m> gxh = null;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    protected String query;
    private h wWd;
    private a wXa;
    protected List<m> wZw = null;

    static /* synthetic */ void a(s sVar, String str, boolean z) {
        AppMethodBeat.i(102889);
        sVar.p(str, z, true);
        AppMethodBeat.o(102889);
    }

    static /* synthetic */ boolean c(s sVar) {
        AppMethodBeat.i(102888);
        boolean gVa = sVar.gVa();
        AppMethodBeat.o(102888);
        return gVa;
    }

    public s(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i2) {
        super(mMBaseSelectContactUI, z, i2);
        AppMethodBeat.i(102871);
        lc(list);
        AppMethodBeat.o(102871);
    }

    public s(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i2, boolean z2) {
        super(mMBaseSelectContactUI, z, i2);
        AppMethodBeat.i(261606);
        this.VlU = z2;
        lc(list);
        AppMethodBeat.o(261606);
    }

    private void lc(List<String> list) {
        AppMethodBeat.i(261607);
        this.PWD = list;
        this.PWN = new ArrayList();
        Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
        amZ();
        AppMethodBeat.o(261607);
    }

    public void ds(String str, boolean z) {
        AppMethodBeat.i(102872);
        if (this.PWf != null) {
            this.PWf.B(str, getCount(), z);
        }
        AppMethodBeat.o(102872);
    }

    @Override // com.tencent.mm.ui.contact.o
    public void b(String str, int[] iArr) {
        AppMethodBeat.i(102873);
        clearTask();
        this.query = str;
        this.PWN.clear();
        for (int i2 : iArr) {
            this.PWN.add(Integer.valueOf(i2));
        }
        Log.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", this.query);
        gVa();
        AppMethodBeat.o(102873);
    }

    private void clearTask() {
        AppMethodBeat.i(102874);
        if (this.wXa != null) {
            ((n) g.ah(n.class)).cancelSearchTask(this.wXa);
            this.wXa = null;
        }
        AppMethodBeat.o(102874);
    }

    private void gUZ() {
        AppMethodBeat.i(102875);
        this.PWF = Integer.MAX_VALUE;
        this.PWG = Integer.MAX_VALUE;
        this.PWH = true;
        this.PWI = Integer.MAX_VALUE;
        this.PTz = Integer.MAX_VALUE;
        this.PWJ = true;
        this.PWK = Integer.MAX_VALUE;
        this.PTA = Integer.MAX_VALUE;
        this.PWL = null;
        this.gxh = null;
        this.wZw = null;
        this.PWM = null;
        this.wWd = null;
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(102875);
    }

    private void amZ() {
        AppMethodBeat.i(102876);
        Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.query = null;
        gUZ();
        clearTask();
        clearCache();
        AppMethodBeat.o(102876);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void clearData() {
        AppMethodBeat.i(102877);
        amZ();
        AppMethodBeat.o(102877);
    }

    private boolean gVa() {
        AppMethodBeat.i(102878);
        if (this.PWN.size() > 0) {
            HashSet<String> hashSet = new HashSet<>();
            if (this.PWL != null) {
                for (m mVar : this.PWL) {
                    hashSet.add(mVar.wVX);
                }
            }
            int intValue = this.PWN.remove(0).intValue();
            j jVar = new j();
            jVar.query = this.query;
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
            AppMethodBeat.o(102878);
            return false;
        }
        AppMethodBeat.o(102878);
        return true;
    }

    private void p(String str, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(102879);
        int jK = jK(this.PWL);
        int jK2 = jK(this.gxh);
        int jK3 = jK(this.wZw);
        int jK4 = jK(this.PWM);
        if (jK > 0) {
            this.PWF = 0;
            i2 = jK + 1 + 0;
        } else {
            this.PWF = Integer.MAX_VALUE;
            i2 = 0;
        }
        if (jK2 > 0) {
            this.PWG = i2;
            if (jK2 <= 3 || (jK3 <= 0 && jK4 <= 0)) {
                this.PWI = Integer.MAX_VALUE;
                i2 += jK2 + 1;
            } else if (this.PWH) {
                int i3 = i2 + 4;
                this.PWI = i3;
                i2 = i3 + 1;
            } else {
                int i4 = i2 + jK2 + 1;
                this.PWI = i4;
                i2 = i4 + 1;
            }
        } else {
            this.PWG = Integer.MAX_VALUE;
        }
        if (this.wWd == null || this.wWd.wWD.length <= 1 || eWh()) {
            this.PWE = Integer.MAX_VALUE;
        } else {
            this.PWE = i2;
            i2++;
        }
        if (jK3 > 0) {
            this.PTz = i2;
            if (jK3 <= 3 || jK4 <= 0) {
                this.PWK = Integer.MAX_VALUE;
                i2 += jK3 + 1;
            } else if (this.PWJ) {
                int i5 = i2 + 4;
                this.PWK = i5;
                i2 = i5 + 1;
            } else {
                int i6 = i2 + jK3 + 1;
                this.PWK = i6;
                i2 = i6 + 1;
            }
        } else {
            this.PTz = Integer.MAX_VALUE;
        }
        if (jK4 > 0) {
            this.PTA = i2;
            i2 += jK4 + 1;
        } else {
            this.PTA = Integer.MAX_VALUE;
        }
        Log.i("MicroMsg.MMSearchContactAdapter", "setCount %d", Integer.valueOf(i2));
        this.count = i2;
        if (z2) {
            ds(str, z);
        }
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(102879);
    }

    /* access modifiers changed from: protected */
    public void jJ(List<m> list) {
        boolean z;
        AppMethodBeat.i(102880);
        if (this.PWD == null) {
            AppMethodBeat.o(102880);
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!this.PWD.contains(mVar.wVX)) {
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
        AppMethodBeat.o(102880);
    }

    public int getCount() {
        return this.count;
    }

    private static int jK(List<? extends Object> list) {
        AppMethodBeat.i(102881);
        if (list == null) {
            AppMethodBeat.o(102881);
            return 0;
        }
        int size = list.size();
        AppMethodBeat.o(102881);
        return size;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: com.tencent.mm.ui.contact.a.c */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(102882);
        com.tencent.mm.ui.contact.a.g gVar = null;
        if (i2 == this.PWE) {
            com.tencent.mm.ui.contact.a.g gVar2 = new com.tencent.mm.ui.contact.a.g(i2);
            gVar2.hkH = true;
            gVar = gVar2;
        } else if (i2 == this.PWF) {
            gVar = lk(R.string.djx, i2);
        } else if (i2 == this.PWG) {
            gVar = lk(R.string.djh, i2);
        } else if (i2 == this.PTz) {
            gVar = lk(R.string.djg, i2);
        } else if (i2 == this.PTA) {
            gVar = lk(R.string.dje, i2);
        } else if (i2 == this.PWI) {
            gVar = L(R.string.djh, i2, this.PWH);
        } else if (i2 == this.PWK) {
            gVar = L(R.string.djg, i2, this.PWJ);
        } else if (i2 > this.PTA) {
            int i3 = (i2 - this.PTA) - 1;
            e eVar = new e(i2);
            eVar.lqW = this.PWM.get(i3);
            eVar.PWh = eWh();
            eVar.hkH = true;
            eVar.wXL = i3 + 1;
            eVar.gE(eVar.lqW.type, eVar.lqW.wVW);
            gVar = eVar;
        } else if (i2 > this.PTz) {
            gVar = aab(i2);
        } else if (i2 > this.PWG) {
            int i4 = (i2 - this.PWG) - 1;
            e eVar2 = new e(i2);
            eVar2.lqW = this.gxh.get(i4);
            eVar2.PWh = eWh();
            eVar2.hkH = true;
            eVar2.wXL = i4 + 1;
            eVar2.gE(eVar2.lqW.type, eVar2.lqW.wVW);
            eVar2.VlU = this.VlU;
            gVar = eVar2;
        } else if (i2 > this.PWF) {
            int i5 = (i2 - this.PWF) - 1;
            m mVar = this.PWL.get(i5);
            if (mVar.type == 131072 || mVar.type == 131076 || mVar.type == 131081) {
                e eVar3 = new e(i2);
                eVar3.lqW = mVar;
                eVar3.PWh = eWh();
                eVar3.Qad = true;
                eVar3.hkH = true;
                eVar3.wXL = i5 + 1;
                eVar3.gE(eVar3.lqW.type, eVar3.lqW.wVW);
                gVar = eVar3;
            } else if (mVar.type == 131075) {
                c cVar = new c(i2);
                cVar.lqW = mVar;
                cVar.PWh = eWh();
                cVar.Qad = true;
                cVar.hkH = true;
                cVar.wXL = i5 + 1;
                cVar.gE(cVar.lqW.type, cVar.lqW.wVW);
                gVar = cVar;
            } else {
                Log.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", Integer.valueOf(mVar.type));
                gVar = null;
            }
        } else {
            Log.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", Integer.valueOf(i2));
        }
        if (gVar != null) {
            gVar.query = this.query;
            gVar.wWd = this.wWd;
            gVar.scene = this.scene;
        }
        AppMethodBeat.o(102882);
        return gVar;
    }

    private static com.tencent.mm.ui.contact.a.a L(int i2, int i3, boolean z) {
        AppMethodBeat.i(102883);
        com.tencent.mm.ui.contact.a.j jVar = new com.tencent.mm.ui.contact.a.j(i3);
        jVar.resId = i2;
        jVar.wke = z;
        AppMethodBeat.o(102883);
        return jVar;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.ui.contact.a.a lk(int i2, int i3) {
        AppMethodBeat.i(102884);
        com.tencent.mm.ui.contact.a.h hVar = new com.tencent.mm.ui.contact.a.h(i3);
        hVar.header = this.PWg.getActivity().getResources().getString(i2);
        AppMethodBeat.o(102884);
        return hVar;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.ui.contact.a.a aab(int i2) {
        AppMethodBeat.i(102885);
        int i3 = (i2 - this.PTz) - 1;
        c cVar = new c(i2);
        cVar.lqW = this.wZw.get(i3);
        cVar.PWh = eWh();
        cVar.hkH = true;
        cVar.wXL = i3 + 1;
        cVar.gE(cVar.lqW.type, cVar.lqW.wVW);
        AppMethodBeat.o(102885);
        return cVar;
    }

    @Override // com.tencent.mm.ui.contact.p
    public void finish() {
        AppMethodBeat.i(102886);
        super.finish();
        Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
        amZ();
        AppMethodBeat.o(102886);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i2 = aVar.position + 1;
        int[] iArr = {this.PWF, this.PWG, this.PTz, this.PTA};
        for (int i3 = 0; i3 < 4; i3++) {
            if (i2 == iArr[i3]) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final boolean anI(int i2) {
        boolean z = true;
        AppMethodBeat.i(102887);
        int headerViewsCount = i2 - this.PWg.getContentLV().getHeaderViewsCount();
        if (headerViewsCount == this.PWI) {
            if (this.PWH) {
                int selectedItemPosition = this.PWg.getContentLV().getSelectedItemPosition();
                this.PWH = false;
                p(this.query, true, false);
                this.PWg.getContentLV().setSelection(selectedItemPosition);
            } else {
                this.PWH = true;
                p(this.query, true, false);
                this.PWg.getContentLV().setSelection(this.PWI);
            }
        } else if (headerViewsCount != this.PWK) {
            com.tencent.mm.ui.contact.a.a anH = getItem(headerViewsCount);
            if (!(anH == null || !anH.hkH || this.PWE == Integer.MAX_VALUE)) {
                if (anH.position == this.PWE) {
                    ac.anJ(1);
                    z = false;
                } else {
                    ac.anJ(0);
                }
            }
            z = false;
        } else if (this.PWJ) {
            int selectedItemPosition2 = this.PWg.getContentLV().getSelectedItemPosition();
            this.PWJ = false;
            p(this.query, true, false);
            this.PWg.getContentLV().setSelection(selectedItemPosition2);
        } else {
            this.PWJ = true;
            p(this.query, true, false);
            this.PWg.getContentLV().setSelection(this.PWK);
        }
        AppMethodBeat.o(102887);
        return z;
    }
}
