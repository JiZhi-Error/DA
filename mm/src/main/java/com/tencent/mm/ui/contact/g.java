package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private List<String> PTJ = null;
    private List<ah> PTK = null;
    List<ah> PUu = new LinkedList();
    private List<ah> PUv = new LinkedList();
    Map<String, Integer> PUw;

    public g() {
        AppMethodBeat.i(102824);
        AppMethodBeat.o(102824);
    }

    public final void reset() {
        AppMethodBeat.i(102825);
        this.PTJ = null;
        this.PTK = null;
        this.PUu.clear();
        AppMethodBeat.o(102825);
    }

    public final boolean bnt(String str) {
        AppMethodBeat.i(102826);
        if (this.PTJ == null || !this.PTJ.contains(str)) {
            AppMethodBeat.o(102826);
            return false;
        }
        AppMethodBeat.o(102826);
        return true;
    }

    public final void jC(List<String> list) {
        int i2 = 6;
        AppMethodBeat.i(102827);
        if (this.PTJ == null) {
            if (list.contains(z.aTY())) {
                list.remove(z.aTY());
            }
            w.jN(list);
            w.jL(list);
            List<ah> jD = jD(list);
            this.PTK = jD;
            if (jD.size() > 0) {
                this.PTJ = a(jD, list, 10);
                this.PUu = C(this.PTK, list);
            }
            if (this.PTJ != null && this.PTJ.size() < 10 && list.size() > 1) {
                List<ah> jD2 = jD(list.subList(list.size() - 1, list.size()));
                if (jD2.size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(this.PTJ);
                    linkedList.addAll(list);
                    this.PTJ = a(jD2, linkedList, 10 - this.PTJ.size());
                }
            }
            if (this.PTJ != null) {
                List<String> list2 = this.PTJ;
                if (this.PTJ.size() <= 6) {
                    i2 = this.PTJ.size();
                }
                w.jM(list2.subList(0, i2));
            }
            AppMethodBeat.o(102827);
            return;
        }
        if (this.PTK != null) {
            if (list.contains(z.aTY())) {
                list.remove(z.aTY());
            }
            this.PUu = C(this.PTK, list);
        }
        AppMethodBeat.o(102827);
    }

    public final Cursor gUx() {
        AppMethodBeat.i(102828);
        com.tencent.mm.kernel.g.aAi();
        Cursor gCo = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().gCo();
        if (this.PTJ != null && this.PTJ.size() > 0) {
            com.tencent.mm.kernel.g.aAi();
            gCo = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().iP(this.PTJ);
        }
        AppMethodBeat.o(102828);
        return gCo;
    }

    public final Cursor gUy() {
        AppMethodBeat.i(102829);
        com.tencent.mm.kernel.g.aAi();
        Cursor gCo = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().gCo();
        if (this.PUu.size() > 0) {
            com.tencent.mm.kernel.g.aAi();
            gCo = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().iM(jF(this.PUu));
        }
        AppMethodBeat.o(102829);
        return gCo;
    }

    public final List<String> c(List<String> list, Map<String, List<m>> map) {
        boolean z;
        AppMethodBeat.i(102830);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        if (list.contains(z.aTY())) {
            list.remove(z.aTY());
        }
        for (String str : list) {
            hashMap.put(str, Boolean.TRUE);
        }
        for (List<m> list2 : map.values()) {
            for (m mVar : list2) {
                hashMap.put(mVar.wVX, Boolean.TRUE);
            }
        }
        hashMap.put(z.aTY(), Boolean.TRUE);
        LinkedList linkedList = new LinkedList();
        gUz();
        for (ah ahVar : this.PUv) {
            if (ahVar.bax().size() == map.size() + list.size() + 1) {
                Iterator<String> it = ahVar.bax().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!hashMap.containsKey(it.next())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    linkedList.add(ahVar);
                }
            }
        }
        Log.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        List<String> jF = jF(linkedList);
        AppMethodBeat.o(102830);
        return jF;
    }

    private List<String> a(List<ah> list, List<String> list2, int i2) {
        int intValue;
        AppMethodBeat.i(102831);
        HashMap hashMap = new HashMap();
        String aTY = z.aTY();
        for (ah ahVar : list) {
            if (this.PUw.get(ahVar.field_chatroomname) != null) {
                boolean JO = ahVar.JO(aTY);
                for (String str : ahVar.bax()) {
                    if (hashMap.get(str) == null) {
                        intValue = 1;
                    } else {
                        intValue = (JO ? 2 : 1) + ((Integer) hashMap.get(str)).intValue();
                    }
                    hashMap.put(str, Integer.valueOf(intValue));
                }
            }
        }
        for (String str2 : list2) {
            hashMap.remove(str2);
        }
        hashMap.remove(aTY);
        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
            /* class com.tencent.mm.ui.contact.g.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                int i2 = Integer.MAX_VALUE;
                AppMethodBeat.i(102821);
                Map.Entry<String, Integer> entry3 = entry;
                Map.Entry<String, Integer> entry4 = entry2;
                if (entry3.getValue() != entry4.getValue()) {
                    int intValue = entry4.getValue().intValue() - entry3.getValue().intValue();
                    AppMethodBeat.o(102821);
                    return intValue;
                }
                int intValue2 = g.this.PUw.get(entry3.getKey()) != null ? g.this.PUw.get(entry3.getKey()).intValue() : Integer.MAX_VALUE;
                if (g.this.PUw.get(entry4.getKey()) != null) {
                    i2 = g.this.PUw.get(entry4.getKey()).intValue();
                }
                int i3 = intValue2 - i2;
                AppMethodBeat.o(102821);
                return i3;
            }
        });
        LinkedList linkedList = new LinkedList();
        for (Map.Entry entry : arrayList) {
            linkedList.add(entry.getKey());
        }
        if (linkedList.size() <= i2) {
            i2 = linkedList.size();
        }
        List<String> subList = linkedList.subList(0, i2);
        AppMethodBeat.o(102831);
        return subList;
    }

    private static List<ah> jD(List<String> list) {
        AppMethodBeat.i(102832);
        LinkedList linkedList = new LinkedList();
        if (list.size() == 0) {
            AppMethodBeat.o(102832);
            return linkedList;
        }
        long nowMilliSecond = Util.nowMilliSecond();
        String str = "select chatroomname,memberlist from chatroom where memberCount < 50 ";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            str = str + " and memberlist like \"%" + Util.escapeSqlValue(it.next()) + "%\" ";
        }
        com.tencent.wcdb.Cursor rawQuery = com.tencent.mm.kernel.g.aAh().hqK.gFH().rawQuery(str, null);
        while (rawQuery.moveToNext()) {
            ah ahVar = new ah();
            ahVar.convertFrom(rawQuery);
            linkedList.add(ahVar);
        }
        rawQuery.close();
        Log.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", Integer.valueOf(linkedList.size()), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
        AppMethodBeat.o(102832);
        return linkedList;
    }

    private void gUz() {
        AppMethodBeat.i(102833);
        if (this.PUv.size() == 0) {
            com.tencent.wcdb.Cursor rawQuery = com.tencent.mm.kernel.g.aAh().hqK.gFH().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
            while (rawQuery.moveToNext()) {
                ah ahVar = new ah();
                ahVar.convertFrom(rawQuery);
                this.PUv.add(ahVar);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(102833);
    }

    public final void jE(List<String> list) {
        AppMethodBeat.i(102834);
        if (this.PUw != null) {
            AppMethodBeat.o(102834);
            return;
        }
        this.PUw = new HashMap();
        Cursor f2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().f(list, 0, 200);
        int i2 = 1;
        int columnIndex = f2.getColumnIndex(ch.COL_USERNAME);
        while (f2.moveToNext()) {
            this.PUw.put(f2.getString(columnIndex), Integer.valueOf(i2));
            i2++;
        }
        f2.close();
        AppMethodBeat.o(102834);
    }

    private List<String> jF(List<ah> list) {
        AppMethodBeat.i(102835);
        if (list == null || list.size() == 0) {
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(102835);
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        for (ah ahVar : list) {
            linkedList4.add(ahVar.field_chatroomname);
        }
        com.tencent.mm.kernel.g.aAi();
        Cursor x = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().x(linkedList4, false);
        LinkedList<as> linkedList5 = new LinkedList();
        while (x.moveToNext()) {
            as asVar = new as();
            asVar.convertFrom(x);
            linkedList5.add(asVar);
        }
        x.close();
        for (as asVar2 : linkedList5) {
            if (Util.isNullOrNil(asVar2.field_nickname)) {
                linkedList3.add(asVar2.field_username);
            } else {
                linkedList2.add(asVar2.field_username);
            }
        }
        Collections.sort(linkedList2, new Comparator<String>() {
            /* class com.tencent.mm.ui.contact.g.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(String str, String str2) {
                int i2 = Integer.MAX_VALUE;
                AppMethodBeat.i(102822);
                String str3 = str;
                String str4 = str2;
                int intValue = g.this.PUw.get(str3) != null ? g.this.PUw.get(str3).intValue() : Integer.MAX_VALUE;
                if (g.this.PUw.get(str4) != null) {
                    i2 = g.this.PUw.get(str4).intValue();
                }
                int i3 = intValue - i2;
                AppMethodBeat.o(102822);
                return i3;
            }
        });
        Collections.sort(linkedList3, new Comparator<String>() {
            /* class com.tencent.mm.ui.contact.g.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(String str, String str2) {
                int i2 = Integer.MAX_VALUE;
                AppMethodBeat.i(102823);
                String str3 = str;
                String str4 = str2;
                int intValue = g.this.PUw.get(str3) != null ? g.this.PUw.get(str3).intValue() : Integer.MAX_VALUE;
                if (g.this.PUw.get(str4) != null) {
                    i2 = g.this.PUw.get(str4).intValue();
                }
                int i3 = intValue - i2;
                AppMethodBeat.o(102823);
                return i3;
            }
        });
        if (linkedList2.size() == 0 && linkedList3.size() > 0) {
            List<String> subList = linkedList3.subList(0, 1);
            AppMethodBeat.o(102835);
            return subList;
        } else if (linkedList3.size() != 0 || linkedList2.size() <= 0) {
            LinkedList linkedList6 = new LinkedList();
            if (linkedList2.size() > 0 && linkedList3.size() > 0) {
                int i2 = 0;
                while (i2 < linkedList2.size() && i2 < 2) {
                    linkedList6.add(linkedList2.get(i2));
                    i2++;
                }
                linkedList6.add(linkedList3.get(0));
            }
            AppMethodBeat.o(102835);
            return linkedList6;
        } else {
            List<String> subList2 = linkedList2.subList(0, linkedList2.size() > 3 ? 3 : linkedList2.size());
            AppMethodBeat.o(102835);
            return subList2;
        }
    }

    private static List<ah> C(List<ah> list, List<String> list2) {
        boolean z;
        AppMethodBeat.i(102836);
        LinkedList linkedList = new LinkedList();
        for (ah ahVar : list) {
            List<String> bax = ahVar.bax();
            if (bax.size() == list2.size() + 1) {
                Iterator<String> it = bax.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String next = it.next();
                    if (!(list2.contains(next) || z.Im(next))) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    linkedList.add(ahVar);
                }
            }
        }
        AppMethodBeat.o(102836);
        return linkedList;
    }
}
