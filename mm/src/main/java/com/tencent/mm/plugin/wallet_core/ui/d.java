package com.tencent.mm.plugin.wallet_core.ui;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class d {
    public h IcO = null;
    private Map<String, t> IcP = null;
    private Map<String, j> IcQ = null;

    public final boolean fSw() {
        AppMethodBeat.i(70649);
        if (this.IcP == null || this.IcP.size() <= 0) {
            AppMethodBeat.o(70649);
            return false;
        }
        AppMethodBeat.o(70649);
        return true;
    }

    public d(h hVar) {
        AppMethodBeat.i(70650);
        Assert.assertNotNull(hVar);
        this.IcO = hVar;
        amZ();
        AppMethodBeat.o(70650);
    }

    private void amZ() {
        AppMethodBeat.i(70651);
        this.IcP = new HashMap();
        LinkedList<t> linkedList = this.IcO.HEu;
        if (linkedList != null) {
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                t tVar = linkedList.get(i2);
                this.IcP.put(tVar.HEn, tVar);
            }
        } else {
            Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.IcQ = new HashMap();
        if (this.IcO.HEv == null || this.IcO.HEv.HEH == null) {
            Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            AppMethodBeat.o(70651);
            return;
        }
        LinkedList<j> linkedList2 = this.IcO.HEv.HEH;
        for (int i3 = 0; i3 < linkedList2.size(); i3++) {
            j jVar = linkedList2.get(i3);
            this.IcQ.put(jVar.HEJ, jVar);
        }
        AppMethodBeat.o(70651);
    }

    public final Map<String, a> aVG(String str) {
        AppMethodBeat.i(70652);
        Map<String, a> cF = cF(str, false);
        AppMethodBeat.o(70652);
        return cF;
    }

    public final j cE(String str, boolean z) {
        int i2;
        AppMethodBeat.i(70653);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || !this.IcQ.containsKey(str)) {
            for (String str2 : this.IcQ.keySet()) {
                j jVar = this.IcQ.get(str2);
                if (!(jVar.HEL == null || jVar.HEL.size() == 0)) {
                    int size = jVar.HEL.size();
                    int i3 = 0;
                    Iterator<f> it = jVar.HEL.iterator();
                    while (true) {
                        i2 = i3;
                        if (!it.hasNext()) {
                            break;
                        }
                        f next = it.next();
                        if (!this.IcP.containsKey(next.HEn)) {
                            break;
                        }
                        t tVar = this.IcP.get(next.HEn);
                        if (tVar.HFr.equals("") && tVar.HFt.size() == 0 && (!z || tVar.HFq == 0)) {
                            i2++;
                        }
                        i3 = i2;
                    }
                    if (i2 > 0 && i2 == size) {
                        AppMethodBeat.o(70653);
                        return jVar;
                    }
                }
            }
            AppMethodBeat.o(70653);
            return null;
        }
        j jVar2 = this.IcQ.get(str);
        AppMethodBeat.o(70653);
        return jVar2;
    }

    public final Map<String, a> aVH(String str) {
        t tVar;
        boolean z;
        AppMethodBeat.i(70654);
        HashMap hashMap = new HashMap();
        if (this.IcO.HEv == null || this.IcO.HEv.HEH == null) {
            Log.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        } else {
            LinkedList<j> linkedList = this.IcO.HEv.HEH;
            double d2 = this.IcQ.containsKey(str) ? this.IcQ.get(str).HEK : 0.0d;
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                j jVar = linkedList.get(i2);
                String str2 = null;
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !jVar.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str2 = jVar.HEJ;
                } else if (jVar.HEJ.startsWith(str) && !str.equals(jVar.HEJ)) {
                    str2 = jVar.HEJ.replace(str + "-", "");
                }
                String[] aVK = aVK(str2);
                if (!(aVK == null || aVK.length <= 0 || (tVar = this.IcP.get(aVK[0])) == null)) {
                    if (tVar.HFq != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && tVar.HFt.size() > 0) {
                        Iterator<b> it = tVar.HFt.iterator();
                        while (it.hasNext()) {
                            String a2 = z.a(it.next());
                            a aVar = (a) hashMap.get(a2);
                            if (aVar == null || jVar.HEK > aVar.IcR.HEK) {
                                a aVar2 = new a();
                                aVar2.IcR = jVar;
                                aVar2.AOj = tVar.AOj;
                                aVar2.IcS = jVar.HEK - d2;
                                aVar2.dQl = tVar.HFr;
                                hashMap.put(a2, aVar2);
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(70654);
        return hashMap;
    }

    public final Map<String, a> cF(String str, boolean z) {
        t tVar;
        boolean z2;
        a aVar;
        AppMethodBeat.i(70655);
        HashMap hashMap = new HashMap();
        if (this.IcO.HEv == null || this.IcO.HEv.HEH == null) {
            Log.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        } else {
            LinkedList<j> linkedList = this.IcO.HEv.HEH;
            double d2 = this.IcQ.containsKey(str) ? this.IcQ.get(str).HEK : 0.0d;
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                j jVar = linkedList.get(i2);
                String str2 = null;
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !jVar.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    str2 = jVar.HEJ;
                } else if (jVar.HEJ.startsWith(str) && !str.equals(jVar.HEJ)) {
                    str2 = jVar.HEJ.replace(str + "-", "");
                }
                String[] aVK = aVK(str2);
                if (!(aVK == null || aVK.length <= 0 || (tVar = this.IcP.get(aVK[0])) == null)) {
                    if (tVar.HFq != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && !Util.isNullOrNil(tVar.HFr) && tVar.HFt.size() <= 0 && ((z || !tVar.HFr.equalsIgnoreCase("CFT")) && ((aVar = (a) hashMap.get(tVar.HFr)) == null || jVar.HEK > aVar.IcR.HEK))) {
                        a aVar2 = new a();
                        aVar2.IcR = jVar;
                        aVar2.AOj = tVar.AOj;
                        aVar2.IcS = jVar.HEK - d2;
                        aVar2.dQl = tVar.HFr;
                        hashMap.put(tVar.HFr, aVar2);
                    }
                }
            }
        }
        AppMethodBeat.o(70655);
        return hashMap;
    }

    public final List<t> aVI(String str) {
        AppMethodBeat.i(70656);
        LinkedList linkedList = new LinkedList();
        if (this.IcO.HEu != null) {
            Map<String, a> aVG = aVG(str);
            for (int i2 = 0; i2 < this.IcO.HEu.size(); i2++) {
                t tVar = this.IcO.HEu.get(i2);
                if (tVar != null) {
                    if ((tVar.HFq != 0) && aVG.containsKey(tVar.HFr)) {
                        linkedList.add(tVar);
                    }
                }
            }
        } else {
            Log.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        AppMethodBeat.o(70656);
        return linkedList;
    }

    public final int fSx() {
        AppMethodBeat.i(70657);
        int size = this.IcQ.size();
        AppMethodBeat.o(70657);
        return size;
    }

    public final j fSy() {
        AppMethodBeat.i(70658);
        if (!this.IcQ.isEmpty()) {
            Iterator<Map.Entry<String, j>> it = this.IcQ.entrySet().iterator();
            if (it.hasNext()) {
                j value = it.next().getValue();
                AppMethodBeat.o(70658);
                return value;
            }
        }
        AppMethodBeat.o(70658);
        return null;
    }

    public final j aVJ(String str) {
        AppMethodBeat.i(70659);
        j jVar = this.IcQ.get(str);
        AppMethodBeat.o(70659);
        return jVar;
    }

    public static String[] aVK(String str) {
        AppMethodBeat.i(70660);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70660);
            return null;
        }
        String[] split = str.split("-");
        AppMethodBeat.o(70660);
        return split;
    }

    public final String aVL(String str) {
        AppMethodBeat.i(70661);
        String cG = cG(str, false);
        AppMethodBeat.o(70661);
        return cG;
    }

    public final String cG(String str, boolean z) {
        AppMethodBeat.i(70662);
        String[] aVK = aVK(str);
        if (aVK != null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < aVK.length; i2++) {
                t tVar = this.IcP.get(aVK[i2]);
                if (tVar != null) {
                    if (!(tVar.HFq != 0) || (Util.isNullOrNil(tVar.HFr) && !z)) {
                        sb.append(aVK[i2]);
                        sb.append("-");
                    }
                }
            }
            if (sb.length() == 0) {
                AppMethodBeat.o(70662);
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            String sb2 = sb.delete(sb.length() - 1, sb.length()).toString();
            AppMethodBeat.o(70662);
            return sb2;
        }
        AppMethodBeat.o(70662);
        return AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    public final FavorPayInfo aVM(String str) {
        boolean z;
        AppMethodBeat.i(70663);
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.IcQ.get(str) == null) {
            favorPayInfo.HXI = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (this.IcO != null) {
                favorPayInfo.HXL = this.IcO.HEt;
            }
            favorPayInfo.HXJ = 0;
            AppMethodBeat.o(70663);
            return favorPayInfo;
        }
        favorPayInfo.HXI = str;
        if (this.IcO != null) {
            favorPayInfo.HXL = this.IcO.HEt;
        }
        favorPayInfo.HXJ = 0;
        String[] aVK = aVK(str);
        if (aVK == null) {
            AppMethodBeat.o(70663);
            return favorPayInfo;
        }
        int length = aVK.length - 1;
        while (true) {
            if (length < 0) {
                break;
            }
            t tVar = this.IcP.get(aVK[length]);
            if (tVar != null) {
                if (tVar.HFq != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    break;
                }
                favorPayInfo.HXJ = 1;
                if (tVar.HFt != null && tVar.HFt.size() > 0) {
                    favorPayInfo.HXN = new LinkedList();
                    Iterator<b> it = tVar.HFt.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.HXN.add(z.a(it.next()));
                    }
                }
                if (!Util.isNullOrNil(tVar.HFr)) {
                    favorPayInfo.HXK = tVar.HFr;
                    break;
                }
            }
            length--;
        }
        AppMethodBeat.o(70663);
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(70664);
        if (bankcard == null) {
            Log.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            AppMethodBeat.o(70664);
            return true;
        }
        if (favorPayInfo != null && !Util.isNullOrNil(favorPayInfo.HXI)) {
            if (favorPayInfo.HXJ != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && !Util.isNullOrNil(favorPayInfo.HXK) && favorPayInfo.HXN != null && favorPayInfo.HXN.contains(bankcard.field_bindSerial)) {
                AppMethodBeat.o(70664);
                return false;
            }
        }
        if (favorPayInfo.HXJ != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || ((Util.isNullOrNil(favorPayInfo.HXK) || bankcard.field_bankcardType == null || bankcard.field_bankcardType.equals(favorPayInfo.HXK)) && (!Util.isNullOrNil(favorPayInfo.HXK) || !bankcard.field_bankcardType.equals("CFT")))) {
            AppMethodBeat.o(70664);
            return false;
        }
        AppMethodBeat.o(70664);
        return true;
    }

    public static List<Bankcard> cI(int i2, String str) {
        boolean z;
        AppMethodBeat.i(70665);
        ArrayList<Bankcard> yj = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
        if (!(i2 != 0)) {
            AppMethodBeat.o(70665);
            return yj;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < yj.size(); i3++) {
            if (Util.isNullOrNil(str)) {
                if (!yj.get(i3).field_bankcardType.equals("CFT")) {
                    z = true;
                }
                z = false;
            } else {
                if (yj.get(i3).field_bankcardType.equals(str)) {
                    z = true;
                }
                z = false;
            }
            if (z) {
                arrayList.add(yj.get(i3));
            }
        }
        AppMethodBeat.o(70665);
        return arrayList;
    }

    private static String ic(List<String> list) {
        AppMethodBeat.i(70666);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2));
            if (i2 < list.size() - 1) {
                sb.append("-");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(70666);
        return sb2;
    }

    public final String aVN(String str) {
        AppMethodBeat.i(70667);
        ArrayList<Bankcard> yj = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < yj.size(); i2++) {
            hashMap.put(yj.get(i2).field_bankcardType, 0);
        }
        String[] aVK = aVK(str);
        if (aVK != null) {
            for (String str2 : aVK) {
                t tVar = this.IcP.get(str2);
                if (tVar != null) {
                    if (tVar.HFq != 0) {
                        if (hashMap.containsKey(tVar.HFr) || Util.isNullOrNil(tVar.HFr)) {
                            arrayList.add(str2);
                        }
                    }
                }
                arrayList.add(str2);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(70667);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String ic = ic(arrayList);
        AppMethodBeat.o(70667);
        return ic;
    }

    public final List<t> fSz() {
        AppMethodBeat.i(70668);
        ArrayList<Bankcard> yj = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < yj.size(); i2++) {
            hashMap.put(yj.get(i2).field_bankcardType, 0);
        }
        LinkedList linkedList = new LinkedList();
        LinkedList<t> linkedList2 = this.IcO.HEu;
        if (linkedList2 != null) {
            for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                t tVar = linkedList2.get(i3);
                if (tVar != null) {
                    if (tVar.HFq != 0) {
                        if (hashMap.containsKey(tVar.HFr) || Util.isNullOrNil(tVar.HFr)) {
                            linkedList.add(tVar);
                        }
                    }
                }
                linkedList.add(tVar);
            }
        }
        AppMethodBeat.o(70668);
        return linkedList;
    }

    public static final class a {
        public String AOj;
        public j IcR;
        public double IcS;
        public String dQl;

        public final String toString() {
            AppMethodBeat.i(70648);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.IcR != null) {
                stringBuffer.append("|faovrComposeId: " + this.IcR.HEJ);
            }
            stringBuffer.append("|bankName: " + this.AOj);
            stringBuffer.append("|bankFavorAmount: " + this.IcS);
            stringBuffer.append("|bankType: " + this.dQl);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(70648);
            return stringBuffer2;
        }
    }
}
