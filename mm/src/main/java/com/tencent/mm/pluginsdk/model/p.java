package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eqa;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqe;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class p extends q implements m {
    public List<String> JVj;
    public String JVk;
    private List<String> JVl;
    private i callback;
    public int dKy;
    public String kfu;
    private final d rr;

    public p(String str, String str2, int i2, String str3, int i3) {
        AppMethodBeat.i(151638);
        this.JVj = null;
        this.dKy = 0;
        this.JVl = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.JVj = new LinkedList();
        this.JVj.add(str);
        this.dKy = 3;
        d.a aVar = new d.a();
        aVar.iLN = new eqd();
        aVar.iLO = new eqe();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.funcId = 137;
        aVar.iLP = 44;
        aVar.respCmdId = 1000000044;
        this.rr = aVar.aXF();
        eqd eqd = (eqd) this.rr.iLK.iLR;
        eqd.KMz = 3;
        eqd.MbK = "";
        LinkedList<eqa> linkedList = new LinkedList<>();
        eqa eqa = new eqa();
        eqa.Cyk = str;
        eqa.Nnv = str2;
        eqa.LRO = a.bqE().aTp().biD(str);
        eqa.MSG = str3;
        if (i3 > 0) {
            eqa.Nnw = i3;
        }
        linkedList.add(eqa);
        eqd.NnG = linkedList;
        eqd.NnF = linkedList.size();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(Integer.valueOf(i2));
        eqd.NnI = linkedList2;
        eqd.NnH = linkedList2.size();
        if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_ver_usr")) {
            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_ver_usr");
        }
        ewf ewf = new ewf();
        ewf.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_ver_usr"));
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(ewf.NtO != null ? ewf.NtO.getILen() : -1);
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", objArr);
        ewf.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_ver_usr"));
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(ewf.NtP != null ? ewf.NtP.getILen() : -1);
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", objArr2);
        ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
        Object[] objArr3 = new Object[1];
        objArr3[0] = Integer.valueOf(ewf.NtQ != null ? ewf.NtQ.getILen() : -1);
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", objArr3);
        String aIT = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_ver_usr");
        if (aIT != null) {
            ewf.NtV = new SKBuiltinBuffer_t().setBuffer(aIT.getBytes());
        }
        try {
            eqd.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
        } catch (Throwable th) {
        }
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify user:%d scene:%d ticket:%s anti:%s, friendFlag:%d", Integer.valueOf(eqd.NnG.size()), Integer.valueOf(eqd.NnI.size()), str2, eqa.LRO, Integer.valueOf(i3));
        AppMethodBeat.o(151638);
    }

    public p(int i2, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        String str5;
        AppMethodBeat.i(151639);
        this.JVj = null;
        this.dKy = 0;
        this.JVl = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i2 != 3);
        this.dKy = i2;
        this.JVj = list;
        list3 = (list3 == null || list3.size() == 0) ? new LinkedList<>() : list3;
        d.a aVar = new d.a();
        aVar.iLN = new eqd();
        aVar.iLO = new eqe();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.funcId = 137;
        aVar.iLP = 44;
        aVar.respCmdId = 1000000044;
        this.rr = aVar.aXF();
        if (list3 != null && list3.size() > 0) {
            if (list3.size() != list.size()) {
                Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", Integer.valueOf(list3.size()), Integer.valueOf(list.size()));
            } else {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    a.bqE().aTp().O(list.get(i3), 2147483633, list3.get(i3));
                }
            }
        }
        if (i2 == 2) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                list3.add(Util.nullAs(a.bqE().aTp().biD(list.get(i4)), ""));
            }
        }
        eqd eqd = (eqd) this.rr.iLK.iLR;
        eqd.KMz = i2;
        eqd.MbK = str;
        this.JVk = str;
        LinkedList<eqa> linkedList = new LinkedList<>();
        for (int i5 = 0; i5 < list.size(); i5++) {
            eqa eqa = new eqa();
            eqa.Cyk = list.get(i5);
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2;
            }
            eqa.Nnv = str5;
            g aTp = a.bqE().aTp();
            String str6 = eqa.Cyk;
            list2.get(i5).intValue();
            eqa.LRO = Util.nullAs(aTp.biD(str6), "");
            if (TextUtils.isEmpty(eqa.LRO) && list3 != null && list3.size() > i5) {
                eqa.LRO = list3.get(i5);
            }
            eqa.MSG = str3;
            if (map != null && map.containsKey(eqa.Cyk)) {
                eqa.Nnw = map.get(eqa.Cyk).intValue();
            }
            eqa.NnA = str4;
            Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s, friendflag:%d", Integer.valueOf(this.dKy), Integer.valueOf(i5), eqa.Cyk, eqa.LRO, str3, str4, Integer.valueOf(eqa.Nnw));
            linkedList.add(eqa);
        }
        eqd.NnG = linkedList;
        eqd.NnF = linkedList.size();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.addAll(list2);
        eqd.NnI = linkedList2;
        eqd.NnH = linkedList2.size();
        if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_ver_usr")) {
            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_ver_usr");
        }
        ewf ewf = new ewf();
        ewf.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_ver_usr"));
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(ewf.NtO != null ? ewf.NtO.getILen() : -1);
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcstf set on verifyuser , len: %s", objArr);
        ewf.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_ver_usr"));
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(ewf.NtP != null ? ewf.NtP.getILen() : -1);
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] wcste set on verifyuser , len: %s", objArr2);
        ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
        Object[] objArr3 = new Object[1];
        objArr3[0] = Integer.valueOf(ewf.NtQ != null ? ewf.NtQ.getILen() : -1);
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "[debug] ccData set on verifyuser , len: %s", objArr3);
        String aIT = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_ver_usr");
        if (aIT != null) {
            ewf.NtV = new SKBuiltinBuffer_t().setBuffer(aIT.getBytes());
        }
        try {
            eqd.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
        } catch (Throwable th) {
        }
        Log.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", Integer.valueOf(this.dKy), Integer.valueOf(eqd.NnG.size()), Integer.valueOf(eqd.NnI.size()), Util.listToString(list3, ","), str3, Util.getStack());
        AppMethodBeat.o(151639);
    }

    public p(List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public p(String str, String str2, int i2) {
        this(str, str2, i2, null, 0);
    }

    public p(List<String> list, List<Integer> list2, String str, String str2) {
        this(1, list, list2, null, str, str2, null, null, "");
    }

    public final void mw(String str, String str2) {
        AppMethodBeat.i(151640);
        Iterator<eqa> it = ((eqd) this.rr.iLK.iLR).NnG.iterator();
        while (it.hasNext()) {
            eqa next = it.next();
            next.Nnx = str;
            next.Nny = str2;
        }
        AppMethodBeat.o(151640);
    }

    public final void Pz(String str) {
        AppMethodBeat.i(151641);
        Iterator<eqa> it = ((eqd) this.rr.iLK.iLR).NnG.iterator();
        while (it.hasNext()) {
            it.next().LRe = str;
        }
        AppMethodBeat.o(151641);
    }

    public final void setSubScene(int i2) {
        AppMethodBeat.i(151642);
        Iterator<eqa> it = ((eqd) this.rr.iLK.iLR).NnG.iterator();
        while (it.hasNext()) {
            it.next().KJS = i2;
        }
        AppMethodBeat.o(151642);
    }

    public final void a(eqb eqb) {
        AppMethodBeat.i(151643);
        if (eqb == null) {
            AppMethodBeat.o(151643);
            return;
        }
        Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", Integer.valueOf(eqb.KJS), Integer.valueOf(eqb.NnE), eqb.Lru);
        Iterator<eqa> it = ((eqd) this.rr.iLK.iLR).NnG.iterator();
        while (it.hasNext()) {
            try {
                it.next().NnD = new SKBuiltinBuffer_t().setBuffer(eqb.toByteArray());
            } catch (IOException e2) {
                Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(151643);
    }

    public final void zJ(boolean z) {
        eqd eqd = (eqd) this.rr.iLK.iLR;
        if (z) {
            eqd.NnL = 1;
        } else {
            eqd.NnL = 0;
        }
    }

    public final String gmD() {
        if (this.rr == null || this.rr.iLL == null) {
            return "";
        }
        return ((eqe) this.rr.iLL.iLR).UserName;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151644);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151644);
        return dispatch;
    }

    public final int gmE() {
        return this.dKy;
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 30;
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151645);
        updateDispatchId(i2);
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151645);
    }
}
