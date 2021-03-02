package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private d AYW = null;
    public m AYX;
    public List<n> AYY;
    public String AYZ;
    public String AZa;
    public String AZb;
    public akg AZc;
    public dr AZd;
    public dki AZe;
    public String AZf;
    public String AZg;
    public int AZh;
    public Map<String, e> AZi;
    public Map<String, String> AZj = new HashMap();
    public LinkedList<akg> AZk;
    public LinkedList<bd> AZl;
    public e AZm;
    private e AZn;
    public Map<String, LinkedList<ahl>> AZo = null;
    public int mCount = 1;

    public c() {
        AppMethodBeat.i(66858);
        AppMethodBeat.o(66858);
    }

    public final void clear() {
        AppMethodBeat.i(66859);
        this.AYX = null;
        if (this.AYY != null) {
            this.AYY.clear();
            this.AYY = null;
        }
        this.AYZ = null;
        this.AZa = null;
        this.mCount = 1;
        this.AZb = null;
        this.AZc = null;
        this.AZe = null;
        this.AZf = null;
        this.AZh = 0;
        this.AZm = null;
        if (this.AZi != null) {
            this.AZi.clear();
            this.AZi = null;
        }
        if (this.AZj != null) {
            this.AZj.clear();
        }
        if (this.AZk != null) {
            this.AZk.clear();
            this.AZk = null;
        }
        if (this.AZo != null) {
            this.AZo.clear();
            this.AZo = null;
        }
        AppMethodBeat.o(66859);
    }

    public final void a(m mVar, List<n> list) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(66860);
        clear();
        this.AYX = mVar;
        this.AYY = list;
        if (Util.isNullOrNil(this.AYX.eby)) {
            this.AYX.eby = this.AZa;
        }
        bh(this.AYX.AZD);
        if (!(this.AYX.AZB == null || this.AYX.AZB.AZU == null)) {
            this.AZh = this.AYX.AZB.AZU.size();
        }
        if (!(this.AYX.AZB == null || this.AYX.AZB.AZO == null || this.AYX.AZB.AZO.size() <= 0)) {
            this.AZf = this.AYX.AZB.AZO.get(0);
        }
        if (!Util.isNullOrNil(this.AYX.eDx())) {
            u.a(new com.tencent.mm.plugin.product.ui.c(this.AYX.eDx()));
            Log.d("MicroMsg.MallProductManager", "product img path : " + eDl());
        }
        if (this.AYX.AZE == null || this.AYX.AZE.AZY == null) {
            i2 = 0;
        } else {
            i2 = this.AYX.AZE.AZY.cSx;
        }
        if (this.AYX.AZC != null) {
            i3 = this.AYX.AZC.cSx;
        }
        this.AZn = new e(i2, i3);
        AppMethodBeat.o(66860);
    }

    public final e eDe() {
        AppMethodBeat.i(66861);
        if (this.AZn == null) {
            this.AZn = new e(0, 0);
        }
        e eVar = this.AZn;
        AppMethodBeat.o(66861);
        return eVar;
    }

    public final String eDf() {
        AppMethodBeat.i(66862);
        if (this.AZm == null || Util.isNullOrNil(this.AZm.url)) {
            String str = this.AZf;
            AppMethodBeat.o(66862);
            return str;
        }
        String str2 = this.AZm.url;
        AppMethodBeat.o(66862);
        return str2;
    }

    public final String eDg() {
        AppMethodBeat.i(66863);
        StringBuilder sb = new StringBuilder();
        Iterator<m> it = this.AYX.AZB.AZU.iterator();
        while (it.hasNext()) {
            m next = it.next();
            String str = this.AZj.get(next.Bae);
            if (str != null) {
                Iterator<h> it2 = next.Bag.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    h next2 = it2.next();
                    if (str.equals(next2.id)) {
                        sb.append(next2.name).append(" ");
                        break;
                    }
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(66863);
        return sb2;
    }

    public final void aO(Intent intent) {
        AppMethodBeat.i(66864);
        dr drVar = new dr();
        drVar.UserName = Util.nullAs(intent.getStringExtra("userName"), "");
        drVar.KHE = Util.nullAs(intent.getStringExtra("telNumber"), "");
        drVar.KHF = Util.nullAs(intent.getStringExtra("addressPostalCode"), "");
        drVar.kdZ = Util.nullAs(intent.getStringExtra("proviceFirstStageName"), "");
        drVar.kea = Util.nullAs(intent.getStringExtra("addressCitySecondStageName"), "");
        drVar.keh = Util.nullAs(intent.getStringExtra("addressCountiesThirdStageName"), "");
        drVar.xKd = Util.nullAs(intent.getStringExtra("addressDetailInfo"), "");
        if (!Util.isNullOrNil(drVar.UserName) && !Util.isNullOrNil(drVar.KHE)) {
            this.AZd = drVar;
        }
        AppMethodBeat.o(66864);
    }

    public final LinkedList<a> aB(Activity activity) {
        int aKh;
        AppMethodBeat.i(66865);
        LinkedList<a> linkedList = new LinkedList<>();
        if (this.AZl != null) {
            Iterator<bd> it = this.AZl.iterator();
            while (it.hasNext()) {
                bd next = it.next();
                a aVar = new a();
                aVar.Name = next.Name;
                aVar.AZI = next.AZI;
                aVar.iAc = next.iAc;
                aVar.oUv = next.oUv;
                aVar.IconUrl = next.IconUrl;
                if (aVar.oUv == 1 && (aKh = aKh(aVar.iAc)) > 0) {
                    aVar.AZI = activity.getString(R.string.ex9, new Object[]{b.c((double) aKh, this.AYX.AZB.AOl)});
                }
                linkedList.add(aVar);
            }
        }
        AppMethodBeat.o(66865);
        return linkedList;
    }

    public final void Ut(int i2) {
        AppMethodBeat.i(66866);
        if (this.AZk == null) {
            AppMethodBeat.o(66866);
            return;
        }
        if (i2 < this.AZk.size() && i2 >= 0) {
            this.AZc = this.AZk.get(i2);
        }
        AppMethodBeat.o(66866);
    }

    public final int eDh() {
        int i2;
        AppMethodBeat.i(66867);
        int i3 = 0;
        if (!eDe().eDA() && this.AZc != null) {
            i3 = this.AZc.KZx + 0;
        }
        if (this.AZm != null) {
            i2 = i3 + (this.AZm.AZq * this.mCount);
        } else {
            i2 = i3 + (this.AYX.AZB.AZM * this.mCount);
        }
        int eDi = i2 - eDi();
        AppMethodBeat.o(66867);
        return eDi;
    }

    public final int eDi() {
        int i2;
        AppMethodBeat.i(66868);
        int i3 = 0;
        if (this.AZo != null && this.AZo.size() > 0) {
            Iterator<LinkedList<ahl>> it = this.AZo.values().iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                LinkedList<ahl> next = it.next();
                if (next != null && next.size() > 0) {
                    Iterator<ahl> it2 = next.iterator();
                    while (it2.hasNext()) {
                        i2 += it2.next().KZx;
                    }
                }
                i3 = i2;
            }
            i3 = i2;
        }
        AppMethodBeat.o(66868);
        return i3;
    }

    private int aKh(String str) {
        LinkedList<ahl> linkedList;
        AppMethodBeat.i(66869);
        int i2 = 0;
        if (this.AZo != null && this.AZo.size() > 0 && (linkedList = this.AZo.get(str)) != null && linkedList.size() > 0) {
            Iterator<ahl> it = linkedList.iterator();
            while (it.hasNext()) {
                i2 = it.next().KZx + i2;
            }
        }
        AppMethodBeat.o(66869);
        return i2;
    }

    public final dki eDj() {
        String str;
        AppMethodBeat.i(66870);
        if (this.AZe != null) {
            dki dki = this.AZe;
            AppMethodBeat.o(66870);
            return dki;
        }
        if (this.AYW == null) {
            this.AYW = com.tencent.mm.plugin.product.a.a.eDb().eDd();
        }
        d dVar = this.AYW;
        if (dVar.AZp == null || dVar.AZp.size() <= 0) {
            str = null;
        } else {
            str = dVar.AZp.get(0);
        }
        if (!Util.isNullOrNil(str)) {
            this.AZe = new dki();
            this.AZe.xKd = str;
            this.AZe.MOm = 1;
            dki dki2 = this.AZe;
            AppMethodBeat.o(66870);
            return dki2;
        }
        dr drVar = this.AZd;
        if (drVar == null || Util.isNullOrNil(drVar.UserName)) {
            AppMethodBeat.o(66870);
            return null;
        }
        this.AZe = new dki();
        this.AZe.xKd = drVar.UserName;
        this.AZe.MOm = 1;
        dki dki3 = this.AZe;
        AppMethodBeat.o(66870);
        return dki3;
    }

    public final String getAppId() {
        if (this.AYX.AZC != null) {
            return this.AYX.AZC.dNI;
        }
        return null;
    }

    public final String eDk() {
        if (this.AYX.AZC != null) {
            return this.AYX.AZC.username;
        }
        return null;
    }

    public final String eDl() {
        AppMethodBeat.i(66871);
        if (!Util.isNullOrNil(this.AYX.eDx())) {
            String aKj = com.tencent.mm.plugin.product.ui.c.aKj(this.AYX.eDx());
            AppMethodBeat.o(66871);
            return aKj;
        }
        AppMethodBeat.o(66871);
        return null;
    }

    public final String eDm() {
        AppMethodBeat.i(66872);
        if (this.AYX.AZB != null && this.AYX.AZB.AZW != null) {
            String str = this.AYX.AZB.AZW.url;
            AppMethodBeat.o(66872);
            return str;
        } else if (!Util.isNullOrNil(this.AYX.eby)) {
            String str2 = this.AYX.eby;
            AppMethodBeat.o(66872);
            return str2;
        } else {
            String str3 = this.AZa;
            AppMethodBeat.o(66872);
            return str3;
        }
    }

    public final int eDn() {
        int i2 = this.AYX.AZz;
        if (this.AZm == null || i2 <= this.AZm.AZz) {
            return i2;
        }
        return this.AZm.AZz;
    }

    public final boolean eDo() {
        AppMethodBeat.i(66873);
        if (this.mCount <= 0 || this.AYX == null || this.mCount > eDn() || this.AYX.AZB == null || this.AYX.AZB.AZU == null) {
            AppMethodBeat.o(66873);
            return false;
        }
        AppMethodBeat.o(66873);
        return true;
    }

    public final boolean eDp() {
        AppMethodBeat.i(66874);
        if (!eDo()) {
            AppMethodBeat.o(66874);
            return false;
        }
        if (this.AZj != null && this.AZj.size() == this.AZh) {
            if (this.AZh > 0) {
                if (this.AZm != null && this.mCount > 0 && this.mCount <= eDn()) {
                    AppMethodBeat.o(66874);
                    return true;
                }
            } else if (this.AZh == 0) {
                AppMethodBeat.o(66874);
                return true;
            }
        }
        AppMethodBeat.o(66874);
        return false;
    }

    public final boolean eDq() {
        AppMethodBeat.i(66875);
        if (!eDp()) {
            AppMethodBeat.o(66875);
            return false;
        } else if (this.AZd == null) {
            AppMethodBeat.o(66875);
            return false;
        } else if (eDe().eDA() || this.AZc != null) {
            AppMethodBeat.o(66875);
            return true;
        } else {
            AppMethodBeat.o(66875);
            return false;
        }
    }

    public final LinkedList<dqn> eDr() {
        AppMethodBeat.i(66876);
        LinkedList<dqn> linkedList = new LinkedList<>();
        dqn dqn = new dqn();
        dqn.oTz = this.mCount;
        dqn.LZy = this.AYX.AZx;
        dqn.MJR = this.AYX.eby;
        dqn.MJS = this.AZb;
        linkedList.add(dqn);
        AppMethodBeat.o(66876);
        return linkedList;
    }

    public final dyy eDs() {
        AppMethodBeat.i(66877);
        dyy dyy = new dyy();
        dyy.Lca = this.AYZ;
        dyy.APg = 1;
        dyy.MYz = new LinkedList<>();
        dev dev = new dev();
        dev.oTz = this.mCount;
        dev.LZy = this.AYX.AZx;
        dev.Name = this.AYX.AZB.name;
        if (this.AZm != null) {
            dev.MJQ = this.AZm.AZq;
        } else {
            dev.MJQ = this.AYX.AZB.AZM;
        }
        dev.MJR = this.AYX.eby;
        dev.MJS = this.AZb;
        dev.oUv = this.AYX.AZy;
        dev.MJO = this.AZh;
        dev.MJP = new LinkedList<>();
        for (String str : this.AZj.keySet()) {
            cfw cfw = new cfw();
            cfw.xMX = str;
            cfw.Cyk = this.AZj.get(str);
            dev.MJP.add(cfw);
        }
        dev.MJW = new LinkedList<>();
        dev.MJV = 0;
        if (this.AZo != null && this.AZo.size() > 0) {
            for (LinkedList<ahl> linkedList : this.AZo.values()) {
                dev.MJW.addAll(linkedList);
                dev.MJV = linkedList.size() + dev.MJV;
            }
        }
        dyy.MYz.add(dev);
        dyy.MYB = new LinkedList<>();
        dyy.MYC = 1;
        this.AZe = eDj();
        if (this.AZe != null) {
            dyy.MYB.add(this.AZe);
        } else {
            this.AZe = new dki();
            this.AZe.MOm = 0;
            dyy.MYB.add(this.AZe);
        }
        dyy.LWZ = this.AZd;
        dyy.MYA = this.AZc;
        AppMethodBeat.o(66877);
        return dyy;
    }

    public final void eDt() {
        boolean z;
        AppMethodBeat.i(66878);
        if (this.AZj == null) {
            AppMethodBeat.o(66878);
            return;
        }
        Iterator<m> it = this.AYX.AZB.AZU.iterator();
        while (it.hasNext()) {
            m next = it.next();
            Iterator<h> it2 = next.Bag.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                String str = next.Bae;
                String str2 = next2.id;
                if (this.AZj == null || this.AZi == null) {
                    z = false;
                } else if (this.AZj.containsKey(str)) {
                    this.AZj.put(str, str2);
                    String aF = aF(this.AZj);
                    this.AZj.put(str, this.AZj.get(str));
                    e eVar = this.AZi.get(aF);
                    z = eVar != null ? eVar.AZz > 0 : false;
                } else {
                    this.AZj.put(str, str2);
                    String aF2 = aF(this.AZj);
                    this.AZj.remove(str);
                    e eVar2 = this.AZi.get(aF2);
                    z = eVar2 != null ? eVar2.AZz > 0 : false;
                }
                next2.iJ = z;
                Log.d("MicroMsg.MallProductManager", "(" + next.Bae + " , " + next2.id + ") hasStock--> " + next2.iJ);
            }
        }
        AppMethodBeat.o(66878);
    }

    public static String aF(Map<String, String> map) {
        AppMethodBeat.i(66879);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(66879);
            return null;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() {
            /* class com.tencent.mm.plugin.product.b.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                AppMethodBeat.i(66857);
                int compareTo = entry.getKey().compareTo(entry2.getKey());
                AppMethodBeat.o(66857);
                return compareTo;
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append((String) entry.getKey()).append(":").append((String) entry.getValue()).append(";");
        }
        sb.deleteCharAt(sb.lastIndexOf(";"));
        String sb2 = sb.toString();
        AppMethodBeat.o(66879);
        return sb2;
    }

    private void bh(LinkedList<l> linkedList) {
        AppMethodBeat.i(66880);
        this.AZi = new HashMap();
        if (linkedList == null || linkedList.size() <= 0) {
            AppMethodBeat.o(66880);
            return;
        }
        int size = linkedList.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = linkedList.get(i2);
            a(lVar.Bab.split(";"), lVar);
        }
        eDt();
        AppMethodBeat.o(66880);
    }

    private void a(String[] strArr, l lVar) {
        AppMethodBeat.i(66881);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(66881);
            return;
        }
        int length = strArr.length;
        int i2 = -1 >>> (32 - length);
        for (int i3 = 1; i3 <= i2; i3++) {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < length; i4++) {
                if (((i3 << (31 - i4)) >> 31) == -1) {
                    sb.append(strArr[i4]).append(";");
                }
            }
            sb.deleteCharAt(sb.lastIndexOf(";"));
            e eVar = this.AZi.get(sb.toString());
            if (eVar != null) {
                if (eVar.AZq < lVar.Bac) {
                    eVar.AZq = lVar.Bac;
                }
                if (eVar.AZr > lVar.Bac) {
                    eVar.AZr = lVar.Bac;
                }
                eVar.AZz += lVar.AZz;
            } else {
                e eVar2 = new e();
                eVar2.AZq = lVar.Bac;
                eVar2.AZr = lVar.Bac;
                eVar2.AZz = lVar.AZz;
                eVar2.Bad = lVar.Bad;
                eVar2.url = lVar.url;
                this.AZi.put(sb.toString(), eVar2);
            }
        }
        AppMethodBeat.o(66881);
    }

    public final String eDu() {
        AppMethodBeat.i(66882);
        k.b bVar = new k.b();
        bVar.title = this.AYX.AZB.name;
        bVar.description = eDv();
        bVar.type = 13;
        bVar.url = eDm();
        bVar.thumburl = this.AYX.eDx();
        bVar.ixm = this.AYX.AZy;
        bVar.ixn = a(this.AYX);
        String a2 = k.b.a(bVar, null, null);
        AppMethodBeat.o(66882);
        return a2;
    }

    public final String eDv() {
        AppMethodBeat.i(66883);
        String c2 = b.c((double) this.AYX.AZB.AZN, this.AYX.AZB.AOl);
        AppMethodBeat.o(66883);
        return c2;
    }

    public final String a(m mVar) {
        AppMethodBeat.i(66884);
        StringBuilder sb = new StringBuilder();
        sb.append("<mallProductInfo>");
        sb.append("<type>").append(mVar.AZy).append("</type>");
        sb.append("<id>").append(mVar.AZx).append("</id>");
        sb.append("<version>").append(mVar.AZB.version).append("</version>");
        sb.append("<name>").append(Util.escapeStringForXml(mVar.AZB.name)).append("</name>");
        sb.append("<highPrice>").append(mVar.AZB.AZM).append("</highPrice>");
        sb.append("<lowPrice>").append(mVar.AZB.AZN).append("</lowPrice>");
        sb.append("<originPrice>").append(mVar.AZB.AZL).append("</originPrice>");
        sb.append("<sourceUrl>").append(Util.escapeStringForXml(this.AYX.eby)).append("</sourceUrl>");
        if (mVar.AZB.AZO != null) {
            sb.append("<imgCount>").append(mVar.AZB.AZO.size()).append("</imgCount>");
            sb.append("<imgList>");
            Iterator<String> it = mVar.AZB.AZO.iterator();
            while (it.hasNext()) {
                sb.append("<imgUrl>").append(Util.escapeStringForXml(it.next())).append("</imgUrl>");
            }
            sb.append("</imgList>");
        }
        sb.append("<shareInfo>");
        sb.append("<shareUrl>").append(Util.escapeStringForXml(eDm())).append("</shareUrl>");
        sb.append("<shareThumbUrl>").append(Util.escapeStringForXml(mVar.eDx())).append("</shareThumbUrl>");
        sb.append("</shareInfo>");
        if (this.AYX.AZC != null) {
            sb.append("<sellerInfo>");
            sb.append("<appID>").append(mVar.AZC.dNI).append("</appID>");
            sb.append("<appName>").append(mVar.AZC.name).append("</appName>");
            sb.append("<usrName>").append(mVar.AZC.username).append("</usrName>");
            sb.append("</sellerInfo>");
        }
        sb.append("</mallProductInfo>");
        String sb2 = sb.toString();
        AppMethodBeat.o(66884);
        return sb2;
    }
}
