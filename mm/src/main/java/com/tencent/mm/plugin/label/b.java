package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.label.a.b {
    String username;
    ArrayList<String> yBM;
    ArrayList<String> yBN;
    private i yBO = new i() {
        /* class com.tencent.mm.plugin.label.b.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            int i4;
            int i5;
            AppMethodBeat.i(26111);
            Log.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
            switch (qVar.getType()) {
                case com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX:
                    if (i2 == 0 && i3 == 0) {
                        b.j(b.this.username, b.this.yBM);
                        AppMethodBeat.o(26111);
                        return;
                    }
                    b.this.ecc();
                    Log.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                    AppMethodBeat.o(26111);
                    return;
                case 638:
                    if (i2 == 0 && i3 == 0) {
                        if (b.this.yBN == null || b.this.yBN.isEmpty()) {
                            i4 = 0;
                        } else {
                            i4 = b.this.yBN.size();
                        }
                        if (b.this.yBM == null || b.this.yBM.isEmpty()) {
                            i5 = 0;
                        } else {
                            i5 = b.this.yBM.size() - i4;
                        }
                        if (i4 > 0 || i5 > 0) {
                            Log.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(i4), Integer.valueOf(i5));
                            h.INSTANCE.a(11220, z.aTY(), Integer.valueOf(i4), Integer.valueOf(i5), 0, 0);
                        }
                    }
                    b.this.ecc();
                    break;
            }
            AppMethodBeat.o(26111);
        }
    };

    public b() {
        AppMethodBeat.i(26112);
        AppMethodBeat.o(26112);
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final void aHn() {
        AppMethodBeat.i(26113);
        e.ecf().aHn();
        AppMethodBeat.o(26113);
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final String aCG(String str) {
        AppMethodBeat.i(26114);
        String aCG = e.ecf().aCG(str);
        AppMethodBeat.o(26114);
        return aCG;
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final String aCH(String str) {
        AppMethodBeat.i(26115);
        String aCH = e.ecf().aCH(str);
        AppMethodBeat.o(26115);
        return aCH;
    }

    @Override // com.tencent.mm.ax.a
    public final void a(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(26116);
        e.ecf().add(iOnStorageChange);
        AppMethodBeat.o(26116);
    }

    @Override // com.tencent.mm.ax.a
    public final void b(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(26117);
        e.ecf().remove(iOnStorageChange);
        AppMethodBeat.o(26117);
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final List<String> ecb() {
        AppMethodBeat.i(26118);
        ax ecf = e.ecf();
        long nowMilliSecond = Util.nowMilliSecond();
        ArrayList<au> gBV = ecf.gBV();
        if (gBV == null) {
            AppMethodBeat.o(26118);
            return null;
        }
        ecf.gBW();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < gBV.size(); i2++) {
            ArrayList<String> arrayList2 = ecf.OoA.get(Integer.valueOf(gBV.get(i2).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(gBV.get(i2).field_labelName);
            }
        }
        Log.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(gBV.size()), Integer.valueOf(arrayList.size()), Util.getStack());
        AppMethodBeat.o(26118);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final List<String> aCI(String str) {
        AppMethodBeat.i(26119);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            AppMethodBeat.o(26119);
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            AppMethodBeat.o(26119);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        AppMethodBeat.o(26119);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final String fh(List<String> list) {
        AppMethodBeat.i(26120);
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            AppMethodBeat.o(26120);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(list.get(i2));
            if (i2 < size - 1) {
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(26120);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final synchronized void is(String str, String str2) {
        AppMethodBeat.i(26121);
        Log.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", String.valueOf(str), String.valueOf(str2));
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
            AppMethodBeat.o(26121);
        } else {
            ArrayList<String> arrayList = (ArrayList) aCI(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                Log.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
                AppMethodBeat.o(26121);
            } else {
                this.username = str;
                this.yBM = arrayList;
                int size = arrayList.size();
                this.yBN = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    au bjB = e.ecf().bjB(arrayList.get(i2));
                    if (bjB != null && bjB.field_isTemporary) {
                        this.yBN.add(arrayList.get(i2));
                    }
                }
                bg.azz().a(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, this.yBO);
                bg.azz().a(638, this.yBO);
                if (this.yBN == null || this.yBN.isEmpty()) {
                    j(str, arrayList);
                    ecc();
                    AppMethodBeat.o(26121);
                } else {
                    Log.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", this.yBN.toString());
                    bg.azz().a(new a(this.yBN), 0);
                    AppMethodBeat.o(26121);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void ecc() {
        AppMethodBeat.i(26122);
        this.username = null;
        this.yBM = null;
        this.yBN = null;
        bg.azz().b(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX, this.yBO);
        bg.azz().b(638, this.yBO);
        AppMethodBeat.o(26122);
    }

    static void j(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(26123);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        Log.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", objArr);
        if (Util.isNullOrNil(str) || arrayList == null || arrayList.size() <= 0) {
            Log.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            AppMethodBeat.o(26123);
            return;
        }
        String str2 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str2 = c.fj(e.ecf().bi(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        eov eov = new eov();
        eov.Lqm = str2;
        eov.UserName = str;
        linkedList.add(eov);
        bg.azz().a(new d(linkedList), 0);
        AppMethodBeat.o(26123);
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final void fi(List<String> list) {
        AppMethodBeat.i(26124);
        bg.azz().a(new a(list), 0);
        AppMethodBeat.o(26124);
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final void p(List<String> list, List<String> list2) {
        AppMethodBeat.i(26125);
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator<String> it = list2.iterator();
            for (String str : list) {
                ArrayList<String> stringsToList = Util.stringsToList(it.next().split(","));
                if (stringsToList != null && stringsToList.size() > 0) {
                    for (String str2 : stringsToList) {
                        if (hashMap.containsKey(str2)) {
                            String str3 = (String) hashMap.get(str2);
                            String it2 = c.it(str3, str);
                            if (!it2.equalsIgnoreCase(str3)) {
                                hashMap.put(str2, it2);
                            }
                        } else {
                            bg.aVF();
                            as Kn = c.aSN().Kn(str2);
                            if (Kn != null) {
                                String str4 = Kn.field_contactLabelIds;
                                String it3 = c.it(str4, str);
                                if (!it3.equalsIgnoreCase(str4)) {
                                    hashMap.put(str2, it3);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            eov eov = new eov();
            eov.UserName = (String) entry.getKey();
            eov.Lqm = (String) entry.getValue();
            linkedList.add(eov);
        }
        if (linkedList.size() > 0) {
            bg.azz().a(new d(linkedList), 0);
        }
        AppMethodBeat.o(26125);
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final /* synthetic */ List aCJ(String str) {
        AppMethodBeat.i(26126);
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            AppMethodBeat.o(26126);
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        ArrayList<String> X = e.ecf().X(str.split(","));
        AppMethodBeat.o(26126);
        return X;
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final /* synthetic */ List aCK(String str) {
        AppMethodBeat.i(26127);
        ArrayList<String> bjA = e.ecf().bjA(str);
        AppMethodBeat.o(26127);
        return bjA;
    }

    @Override // com.tencent.mm.plugin.label.a.b
    public final /* synthetic */ List ecd() {
        AppMethodBeat.i(26128);
        ArrayList<String> gBU = e.ecf().gBU();
        AppMethodBeat.o(26128);
        return gBU;
    }
}
