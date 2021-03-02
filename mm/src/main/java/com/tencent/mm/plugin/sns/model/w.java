package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w extends q implements m {
    public LinkedList<eaw> DIZ = null;
    public int DJa;
    public i callback;
    private int dJY;
    private String md5;
    private d rr;

    public w(int i2) {
        String str;
        AppMethodBeat.i(95648);
        this.dJY = i2;
        d.a aVar = new d.a();
        aVar.iLN = new eax();
        aVar.iLO = new eay();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.funcId = l.CTRL_INDEX;
        aVar.iLP = 116;
        aVar.respCmdId = 1000000116;
        this.rr = aVar.aXF();
        String str2 = aj.faS().aQr("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.md5 = str;
        eax eax = (eax) this.rr.iLK.iLR;
        eax.OpCode = i2;
        eax.Nas = str;
        AppMethodBeat.o(95648);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95649);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95649);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return l.CTRL_INDEX;
    }

    public static s a(s sVar, eaw eaw) {
        AppMethodBeat.i(95650);
        sVar.field_tagId = eaw.Nar;
        sVar.field_tagName = Util.nullAs(eaw.xMo, "");
        sVar.field_count = eaw.oTz;
        sVar.gX(eaw.oTA);
        Log.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + eaw.toString());
        AppMethodBeat.o(95650);
        return sVar;
    }

    private static boolean a(List<Long> list, Long l) {
        AppMethodBeat.i(95651);
        for (Long l2 : list) {
            if (l2.longValue() == l.longValue()) {
                AppMethodBeat.o(95651);
                return true;
            }
        }
        AppMethodBeat.o(95651);
        return false;
    }

    public final List<String> Jp(long j2) {
        AppMethodBeat.i(95652);
        LinkedList linkedList = new LinkedList();
        if (this.DIZ == null) {
            AppMethodBeat.o(95652);
            return linkedList;
        }
        Iterator<eaw> it = this.DIZ.iterator();
        while (it.hasNext()) {
            eaw next = it.next();
            if (next.Nar == j2) {
                Iterator<dqi> it2 = next.oTA.iterator();
                while (it2.hasNext()) {
                    linkedList.add(it2.next().MTo);
                }
                AppMethodBeat.o(95652);
                return linkedList;
            }
        }
        AppMethodBeat.o(95652);
        return linkedList;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(95653);
        Log.d("MicroMsg.NetSceneSnsTagList", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            eay eay = (eay) ((d) sVar).iLL.iLR;
            Log.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", Integer.valueOf(this.DJa));
            this.DJa = eay.DJa;
            this.DIZ = eay.oTA;
            String str2 = eay.Nas;
            if (this.md5.equals(str2)) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(95653);
                return;
            }
            List<Long> ffg = aj.faU().ffg();
            if (this.dJY != 3) {
                Iterator<Long> it = ffg.iterator();
                while (it.hasNext()) {
                    Long next = it.next();
                    Iterator<eaw> it2 = eay.oTA.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (next.longValue() == it2.next().Nar) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        it.remove();
                        aj.faU().JM(next.longValue());
                    }
                }
            }
            Iterator<eaw> it3 = eay.oTA.iterator();
            while (it3.hasNext()) {
                eaw next2 = it3.next();
                if (!a(ffg, Long.valueOf(next2.Nar))) {
                    s sVar2 = new s();
                    a(sVar2, next2);
                    aj.faU().a(sVar2);
                } else {
                    s JL = aj.faU().JL(next2.Nar);
                    if ((JL.field_tagName != null && !JL.field_tagName.equals(next2.xMo)) || JL.field_count != next2.oTz || b(JL, next2)) {
                        a(JL, next2);
                        aj.faU().a(JL);
                    }
                }
            }
            com.tencent.mm.plugin.sns.storage.l aQr = aj.faS().aQr("@__weixintsnstag");
            aQr.field_md5 = str2;
            aj.faS().a(aQr);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95653);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95653);
    }

    private static boolean b(s sVar, eaw eaw) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(95654);
        String[] split = sVar.field_memberList.split(",");
        Iterator<dqi> it = eaw.oTA.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            dqi next = it.next();
            int i2 = 0;
            while (true) {
                if (i2 >= split.length) {
                    z = false;
                    continue;
                    break;
                } else if (split[i2].equals(next)) {
                    z = true;
                    continue;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                z2 = true;
                break;
            }
        }
        AppMethodBeat.o(95654);
        return z2;
    }
}
