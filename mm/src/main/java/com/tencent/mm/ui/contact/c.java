package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements MStorageEx.IOnStorageChange {
    private int CuC;
    private int PTA;
    private int PTB;
    private int PTC;
    private HashMap<String, Integer> PTD;
    private SparseArray<String> PTE;
    private int PTF;
    private List<String> PTG;
    private List<String> PTH;
    g PTI;
    private List<String> PTJ;
    private List<ah> PTK;
    private a PTu;
    private int PTv;
    private int PTw;
    private int PTx;
    private int PTy;
    private int PTz;
    public boolean VlU;
    private Cursor jWh;

    public static class a {
        public String PSf = "@all.contact.without.chatroom";
        public boolean PTL = false;
        public boolean PTM = false;
        public boolean PTN = false;
        public boolean PTO = false;
        public boolean PTP = false;
        public boolean PTQ = false;
        public boolean PTR = false;
        public boolean PTS = false;
        public String PTT;
        public String PTU;
        public boolean PTV = false;
        public String PTW = "";
        public String PTX = "";
        public String customHeader = "";
        public String dFl = "";
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, List<String> list3, boolean z, boolean z2, a aVar, boolean z3, boolean z4) {
        super(mMBaseSelectContactUI, list3, z, z2, z3);
        AppMethodBeat.i(261605);
        this.PTv = Integer.MAX_VALUE;
        this.CuC = Integer.MAX_VALUE;
        this.PTw = Integer.MAX_VALUE;
        this.PTx = Integer.MAX_VALUE;
        this.PTy = Integer.MAX_VALUE;
        this.PTz = Integer.MAX_VALUE;
        this.PTA = Integer.MAX_VALUE;
        this.PTB = Integer.MAX_VALUE;
        this.PTC = Integer.MAX_VALUE;
        this.PTD = null;
        this.PTE = null;
        this.PTF = 0;
        this.VlU = false;
        this.PTI = new g();
        this.PTJ = null;
        this.PTK = null;
        this.VlU = z4;
        Log.i("MicroMsg.AlphabetContactAdapter", "create!");
        if (aVar != null) {
            this.PTu = aVar;
        } else {
            this.PTu = new a();
        }
        this.PTH = list;
        this.PTG = list2;
        g.aAi();
        ((l) g.af(l.class)).aSN().add(this);
        and();
        AppMethodBeat.o(261605);
    }

    private c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar) {
        this(mMBaseSelectContactUI, null, null, list, true, z, aVar, false, false);
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar, byte b2) {
        this(mMBaseSelectContactUI, list, z, aVar);
    }

    public final boolean bnq(String str) {
        AppMethodBeat.i(102810);
        boolean bnt = this.PTI.bnt(str);
        AppMethodBeat.o(102810);
        return bnt;
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        int i2;
        Cursor iS;
        int i3;
        Cursor iQ;
        List<String> list = null;
        AppMethodBeat.i(102811);
        Log.i("MicroMsg.AlphabetContactAdapter", "resetData");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        this.PTv = Integer.MAX_VALUE;
        this.CuC = Integer.MAX_VALUE;
        this.PTw = Integer.MAX_VALUE;
        this.PTx = Integer.MAX_VALUE;
        this.PTy = Integer.MAX_VALUE;
        this.PTz = Integer.MAX_VALUE;
        this.PTA = Integer.MAX_VALUE;
        this.PTC = Integer.MAX_VALUE;
        if (this.PTD != null) {
            this.PTD.clear();
        } else {
            this.PTD = new HashMap<>();
        }
        if (this.PTE != null) {
            this.PTE.clear();
        } else {
            this.PTE = new SparseArray<>();
        }
        ArrayList arrayList = new ArrayList();
        if (this.PTu.PTQ) {
            List<String> stringToList = Util.stringToList(this.PTu.PTU, ",");
            if (!stringToList.isEmpty()) {
                g.aAi();
                Cursor x = ((l) g.af(l.class)).aSN().x(stringToList, false);
                arrayList.add(x);
                int count = x.getCount();
                Log.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", Integer.valueOf(count));
                if (count > 0) {
                    this.PTC = 0;
                    dm(this.PTC, "☆");
                    i3 = count + 1 + 0;
                } else {
                    this.PTC = Integer.MAX_VALUE;
                    i3 = 0;
                }
            } else {
                this.PTC = Integer.MAX_VALUE;
                i3 = 0;
            }
            if (this.PTu.PSf == "@all.contact.without.chatroom.without.openim.without.openimfavour") {
                g.aAi();
                iQ = ((l) g.af(l.class)).aSN().iR(Util.stringsToList(this.PTu.PTT.split(",")));
            } else {
                g.aAi();
                iQ = ((l) g.af(l.class)).aSN().iQ(Util.stringsToList(this.PTu.PTT.split(",")));
            }
            arrayList.add(iQ);
            int count2 = iQ.getCount();
            if (count2 > 0) {
                this.PTy = i3;
                i3 += count2 + 1;
                dm(this.PTy, "☆");
            } else {
                this.PTy = Integer.MAX_VALUE;
            }
            ArrayList<String> stringsToList = Util.stringsToList(this.PTu.PTT.split(","));
            g.aAi();
            Cursor x2 = ((l) g.af(l.class)).aSN().x(stringsToList, true);
            arrayList.add(x2);
            String[] aq = ab.aq(stringsToList);
            int[] ap = ab.ap(stringsToList);
            if (!(aq == null || ap == null)) {
                for (int i4 = 0; i4 < aq.length; i4++) {
                    if (i4 < ap.length) {
                        dm(ap[i4] + i3, aq[i4]);
                        i3++;
                    }
                }
                x2.getCount();
            }
        } else {
            if (this.PTu.PTR) {
                this.PTB = 0;
                dm(this.PTB, "nonLimit");
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.PTu.PTV && this.PTu.PTW != null && !Util.isNullOrNil(this.PTu.PTW)) {
                ArrayList<String> stringsToList2 = Util.stringsToList(this.PTu.PTW.split(";"));
                g.aAi();
                Cursor iL = ((l) g.af(l.class)).aSN().iL(stringsToList2);
                arrayList.add(iL);
                int count3 = iL.getCount();
                if (count3 > 0) {
                    this.PTv = i2;
                    i2 += count3 + 1;
                    dm(this.PTv, "↑");
                } else {
                    this.PTv = Integer.MAX_VALUE;
                }
            } else if (this.PTu.PTL) {
                Cursor jG = h.jG(this.gzY);
                arrayList.add(jG);
                int count4 = jG.getCount();
                if (count4 > 0) {
                    this.CuC = i2;
                    i2 += count4 + 1;
                    dm(this.CuC, "↑");
                } else {
                    this.CuC = Integer.MAX_VALUE;
                }
            }
            if (this.PTu.PTP) {
                this.PTI.jE(this.gzY);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.PTH);
                linkedList.addAll(this.PTG);
                this.PTI.jC(linkedList);
                if (this.PTH.size() < 3) {
                    Cursor gUy = this.PTI.gUy();
                    int count5 = gUy.getCount();
                    this.PTF = count5;
                    if (count5 > 0) {
                        arrayList.add(gUy);
                        this.PTx = i2;
                        i2 += count5 + 1;
                        dm(this.PTx, "↑");
                        Log.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", Integer.valueOf(count5));
                    } else {
                        gUy.close();
                    }
                }
                if (this.PTG.size() > 0 && this.PTH.size() < 41) {
                    Cursor gUx = this.PTI.gUx();
                    int count6 = gUx.getCount();
                    if (count6 > 0) {
                        arrayList.add(gUx);
                        this.PTw = i2;
                        i2 += count6 + 1;
                        dm(this.PTw, "↑");
                        Log.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", Integer.valueOf(count6));
                    } else {
                        gUx.close();
                    }
                }
            }
            if (this.PTu.PTM) {
                Log.i("MicroMsg.AlphabetContactAdapter", "option.filterType = " + this.PTu.PSf);
                if (this.PTu.PSf == "@all.contact.without.chatroom.without.openim.without.openimfavour") {
                    Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursorWithoutOpenIM");
                    g.aAi();
                    iS = ((l) g.af(l.class)).aSN().iT(this.gzY);
                } else {
                    Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursor");
                    g.aAi();
                    iS = ((l) g.af(l.class)).aSN().iS(this.gzY);
                }
                arrayList.add(iS);
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MicroMsg.AlphabetContactAdapter", "before favContactCursor.getCount");
                int count7 = iS.getCount();
                Log.i("MicroMsg.AlphabetContactAdapter", "favContactCursor.getCount duration = " + (System.currentTimeMillis() - currentTimeMillis));
                if (count7 > 0) {
                    this.PTy = i2;
                    i2 += count7 + 1;
                    dm(this.PTy, "☆");
                } else {
                    this.PTy = Integer.MAX_VALUE;
                }
            }
            if (this.PTu.PTS) {
                if (!Util.isNullOrNil(this.PTu.PTX)) {
                    list = Util.stringToList(this.PTu.PTX, ",");
                }
                g.aAi();
                Cursor x3 = ((l) g.af(l.class)).aSN().x(list, true);
                arrayList.add(x3);
                String[] aq2 = ab.aq(list);
                int[] ap2 = ab.ap(list);
                if (!(aq2 == null || ap2 == null)) {
                    int i5 = i2;
                    for (int i6 = 0; i6 < aq2.length; i6++) {
                        if (i6 < ap2.length) {
                            dm(ap2[i6] + i5, aq2[i6]);
                            i5++;
                        }
                    }
                    i2 += x3.getCount() + aq2.length;
                }
            } else {
                g.aAi();
                Cursor c2 = ((l) g.af(l.class)).aSN().c(this.PTu.PSf, "", this.gzY);
                arrayList.add(c2);
                String[] a2 = ab.a((String[]) null, this.PTu.PSf, "", "", this.gzY);
                int[] a3 = ab.a((String[]) null, this.PTu.PSf, "", this.gzY, "");
                if (!(a2 == null || a3 == null)) {
                    int i7 = i2;
                    for (int i8 = 0; i8 < a2.length; i8++) {
                        if (i8 < a3.length) {
                            dm(a3[i8] + i7, a2[i8]);
                            i7++;
                        }
                    }
                    i2 += c2.getCount() + a2.length;
                }
            }
            if (this.PTu.PTN) {
                g.aAi();
                Cursor d2 = ((l) g.af(l.class)).aSN().d("@all.chatroom.contact", "", this.gzY);
                arrayList.add(d2);
                int count8 = d2.getCount();
                if (count8 > 0) {
                    this.PTz = i2;
                    i2 += count8 + 1;
                    dm(this.PTz, this.PWg.getActivity().getString(R.string.e6));
                } else {
                    this.PTz = Integer.MAX_VALUE;
                }
            }
            if (this.PTu.PTO) {
                g.aAi();
                Cursor d3 = ((l) g.af(l.class)).aSN().d("@verify.contact", "", this.gzY);
                arrayList.add(d3);
                if (d3.getCount() > 0) {
                    this.PTA = i2;
                    dm(this.PTA, this.PWg.getActivity().getString(R.string.ghy));
                } else {
                    this.PTA = Integer.MAX_VALUE;
                }
            }
        }
        this.jWh = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        Log.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", Integer.valueOf(this.jWh.getCount()), this.PTD.toString());
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(102811);
    }

    private void dm(int i2, String str) {
        AppMethodBeat.i(102812);
        this.PTD.put(str, Integer.valueOf(i2));
        this.PTE.put(i2, str);
        AppMethodBeat.o(102812);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final int gUt() {
        return this.PTF;
    }

    @Override // com.tencent.mm.ui.contact.q
    public final int bnr(String str) {
        AppMethodBeat.i(102813);
        if (str.equals("↑")) {
            AppMethodBeat.o(102813);
            return 0;
        } else if (this.PTD == null) {
            AppMethodBeat.o(102813);
            return -1;
        } else if (this.PTD.containsKey(str)) {
            int intValue = this.PTD.get(str).intValue() + this.PWg.getContentLV().getHeaderViewsCount();
            AppMethodBeat.o(102813);
            return intValue;
        } else {
            AppMethodBeat.o(102813);
            return -1;
        }
    }

    public final int getCount() {
        AppMethodBeat.i(102814);
        int size = (this.PTE == null ? 0 : this.PTE.size()) + this.jWh.getCount();
        AppMethodBeat.o(102814);
        return size;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(102815);
        if (i2 == this.PTC) {
            com.tencent.mm.ui.contact.a.a dn = dn(i2, this.PWg.getActivity().getString(R.string.gi2));
            AppMethodBeat.o(102815);
            return dn;
        } else if (i2 == this.PTv) {
            com.tencent.mm.ui.contact.a.a dn2 = dn(i2, this.PTu.customHeader);
            AppMethodBeat.o(102815);
            return dn2;
        } else if (i2 == this.CuC) {
            com.tencent.mm.ui.contact.a.a dn3 = dn(i2, this.PWg.getActivity().getString(R.string.ghs));
            AppMethodBeat.o(102815);
            return dn3;
        } else if (i2 == this.PTw) {
            com.tencent.mm.ui.contact.a.a dn4 = dn(i2, this.PWg.getActivity().getString(R.string.ghz));
            AppMethodBeat.o(102815);
            return dn4;
        } else if (i2 == this.PTx) {
            com.tencent.mm.ui.contact.a.a dn5 = dn(i2, this.PWg.getActivity().getString(R.string.gi0));
            AppMethodBeat.o(102815);
            return dn5;
        } else if (i2 == this.PTy) {
            com.tencent.mm.ui.contact.a.a dn6 = dn(i2, this.PWg.getActivity().getString(R.string.ghm));
            AppMethodBeat.o(102815);
            return dn6;
        } else if (i2 == this.PTz) {
            com.tencent.mm.ui.contact.a.a dn7 = dn(i2, this.PWg.getActivity().getString(R.string.e6));
            AppMethodBeat.o(102815);
            return dn7;
        } else if (i2 == this.PTA) {
            com.tencent.mm.ui.contact.a.a dn8 = dn(i2, this.PWg.getActivity().getString(R.string.ghy));
            AppMethodBeat.o(102815);
            return dn8;
        } else if (i2 == this.PTB) {
            k kVar = new k(i2);
            AppMethodBeat.o(102815);
            return kVar;
        } else if (this.PTE.indexOfKey(i2) >= 0) {
            com.tencent.mm.ui.contact.a.a dn9 = dn(i2, this.PTE.get(i2));
            AppMethodBeat.o(102815);
            return dn9;
        } else {
            int i3 = i2;
            int i4 = 0;
            while (i4 <= this.PTE.size()) {
                if (this.PTE.indexOfKey(i3) >= 0) {
                    i4++;
                }
                i3--;
                if (i3 < 0) {
                    break;
                }
            }
            int i5 = i2 - i4;
            if (this.jWh.moveToPosition(i5)) {
                Log.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
                as asVar = new as();
                asVar.convertFrom(this.jWh);
                e eVar = new e(i2);
                eVar.contact = asVar;
                if (!Util.isNullOrNil(this.PTu.dFl)) {
                    eVar.dFl = this.PTu.dFl;
                }
                if (ab.Eq(asVar.field_username)) {
                    eVar.PWh = false;
                    eVar.PWi = false;
                    eVar.Qaa = false;
                    eVar.Qap = true;
                } else {
                    eVar.PWh = eWh();
                    eVar.PWi = this.PWi;
                    eVar.Qap = false;
                }
                eVar.VlU = this.VlU;
                AppMethodBeat.o(102815);
                return eVar;
            }
            Log.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
            AppMethodBeat.o(102815);
            return null;
        }
    }

    private com.tencent.mm.ui.contact.a.a dn(int i2, String str) {
        AppMethodBeat.i(102816);
        h hVar = new h(i2);
        hVar.header = str;
        hVar.VlU = this.VlU;
        AppMethodBeat.o(102816);
        return hVar;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(102817);
        super.finish();
        Log.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        g.aAi();
        ((l) g.af(l.class)).aSN().remove(this);
        AppMethodBeat.o(102817);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(102818);
        Log.i("MicroMsg.AlphabetContactAdapter", "onNotifyChange evnet = ".concat(String.valueOf(i2)));
        if (mStorageEx != null) {
            Log.i("MicroMsg.AlphabetContactAdapter", "onNotifyChange stg = " + mStorageEx.toString());
        }
        if (obj != null) {
            Log.i("MicroMsg.AlphabetContactAdapter", "onNotifyChange obj = " + obj.toString());
        }
        if (obj != null) {
            g.aAi();
            as bjF = ((l) g.af(l.class)).aSN().bjF(obj.toString());
            if (bjF != null && com.tencent.mm.contact.c.oR(bjF.field_type)) {
                and();
            }
        }
        AppMethodBeat.o(102818);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(102819);
        int i2 = aVar.position + 1;
        int[] iArr = {this.PTC, this.PTv, this.CuC, this.PTw, this.PTx, this.PTy, this.PTz, this.PTA};
        for (int i3 = 0; i3 < 8; i3++) {
            if (i2 == iArr[i3]) {
                AppMethodBeat.o(102819);
                return true;
            }
        }
        if (this.PTE.indexOfKey(i2) >= 0) {
            AppMethodBeat.o(102819);
            return true;
        }
        AppMethodBeat.o(102819);
        return false;
    }
}
