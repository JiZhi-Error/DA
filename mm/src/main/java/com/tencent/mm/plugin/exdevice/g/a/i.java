package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.ui.SportProfileUIC;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.ecx;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.protocal.protobuf.ffo;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<bxb, bxc> {
    public String appName;
    private Context context;
    public String coverUrl;
    public String msN;
    public String rCo;
    public String rCp;
    public String rCq;
    public List<ecx> rCr;
    public List<ffo> rCs;
    public ffn rCt;
    public ArrayList<String> rCu;
    public List<bes> rCv;
    public List<sg> rCw;
    public boolean rCx;
    public int rCy;
    public boolean rCz;
    private final WeakReference<b<i>> rxQ;
    public String source;
    public String username;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* bridge */ /* synthetic */ void i(bxb bxb) {
        bxb bxb2 = bxb;
        bxb2.rJH = this.appName;
        bxb2.username = this.username;
    }

    public i(Context context2, String str, String str2, b<i> bVar) {
        AppMethodBeat.i(231695);
        Log.i("MicroMsg.NetSceneGetProfileDetail", "NetSceneGetProfileDetail, username: %s, appName: %s", str, str2);
        this.context = context2;
        this.username = str;
        this.appName = str2;
        this.rxQ = new WeakReference<>(bVar);
        AppMethodBeat.o(231695);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        b<i> bVar;
        AppMethodBeat.i(23523);
        Log.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            bxc bxc = (bxc) cgq();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((SportProfileUIC) com.tencent.mm.ui.component.a.ko(this.context).get(SportProfileUIC.class)).rMR = bxc;
            this.coverUrl = bxc.McL;
            this.rCp = bxc.rCp;
            this.rCs = bxc.McN;
            this.rCt = bxc.LpZ;
            this.rCq = bxc.McP;
            this.source = bxc.source;
            this.msN = bxc.McQ;
            this.rCr = bxc.KHS;
            this.rCx = bxc.rCx;
            this.rCv = bxc.KHh;
            this.rCw = bxc.McR;
            this.rCu = new ArrayList<>();
            this.rCy = bxc.rJh;
            this.rCz = bxc.McS;
            this.rCo = bxc.rCo;
            if (bxc.McO != null) {
                this.rCu.addAll(bxc.McO);
            }
            this.rCr = new LinkedList();
            if (bxc.KHS != null) {
                this.rCr.addAll(bxc.KHS);
            }
            if (this.username != null && !this.username.equalsIgnoreCase(z.aTY())) {
                if (!this.rCx) {
                    ad.cKN().anE(this.username);
                } else {
                    com.tencent.mm.plugin.exdevice.g.b.b.a cKN = ad.cKN();
                    String str2 = this.username;
                    if (cKN.a(new com.tencent.mm.plugin.exdevice.g.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        cKN.insert(cVar);
                    }
                }
            }
            if (bxc.KHh != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<bes> it = bxc.KHh.iterator();
                while (it.hasNext()) {
                    bes next = it.next();
                    bg.aVF();
                    if (com.tencent.mm.model.c.aSN().bjG(next.username)) {
                        c cVar2 = new c();
                        cVar2.field_username = next.username;
                        cVar2.field_step = next.lCq;
                        arrayList.add(cVar2);
                    } else {
                        bg.azz().a(new h(next.username, null), 0);
                    }
                }
                Log.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", Integer.valueOf(arrayList.size()), arrayList.toString());
                if (z.aTY().equalsIgnoreCase(this.username)) {
                    ad.cKN().dn(arrayList);
                }
            }
            this.rCw = new ArrayList();
            if (bxc.McR != null) {
                this.rCw.addAll(bxc.McR);
            }
            this.rCx = bxc.rCx;
            com.tencent.mm.plugin.exdevice.g.b.a.a aVar2 = new com.tencent.mm.plugin.exdevice.g.b.a.a();
            aVar2.field_championMotto = this.rCp;
            aVar2.field_championUrl = this.coverUrl;
            aVar2.field_username = this.username;
            ad.cKP().a(aVar2);
        }
        if (!(this.rxQ == null || (bVar = this.rxQ.get()) == null)) {
            bVar.a(i3, i4, str, this);
        }
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        AppMethodBeat.o(23523);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1043;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ bxc cKd() {
        AppMethodBeat.i(23524);
        bxc bxc = new bxc();
        AppMethodBeat.o(23524);
        return bxc;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ bxb cKc() {
        AppMethodBeat.i(23525);
        bxb bxb = new bxb();
        AppMethodBeat.o(23525);
        return bxb;
    }
}
