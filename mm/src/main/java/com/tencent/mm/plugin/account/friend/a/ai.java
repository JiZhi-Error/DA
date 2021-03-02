package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.y.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class ai extends q implements m {
    private i callback;
    private int gQp;
    private HashMap<String, n> kcB = new HashMap<>();
    private ArrayList<n> kfv;
    private int kfw;
    private int kfx;
    private int mEntryScene;
    private String mToken;
    private final d rr;

    public ai(ArrayList<n> arrayList, int i2, HashMap<String, n> hashMap, String str) {
        AppMethodBeat.i(131126);
        d.a aVar = new d.a();
        aVar.iLN = new cii();
        aVar.iLO = new cij();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.funcId = f.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.kfv = arrayList;
        this.mEntryScene = i2;
        this.kfw = 0;
        this.kfx = 1;
        this.kcB = hashMap;
        this.mToken = str;
        AppMethodBeat.o(131126);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131127);
        Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.callback = iVar;
        cii cii = (cii) this.rr.iLK.iLR;
        if (this.kfv != null) {
            LinkedList<bzw> linkedList = new LinkedList<>();
            this.gQp = this.kfv.size();
            int i2 = this.kfw;
            while (i2 < this.gQp && i2 < this.kfw + 500) {
                bzw bzw = new bzw();
                bzw.KPA = this.kfv.get(i2).field_googlegmail;
                linkedList.add(bzw);
                i2++;
            }
            cii.oTA = linkedList;
            cii.oTz = linkedList.size();
            if (this.kfw + 500 > this.gQp) {
                this.kfx = 0;
            } else {
                this.kfx = 1;
            }
            cii.KZh = this.kfx;
            cii.Mnu = this.mEntryScene;
            Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", Integer.valueOf(this.gQp), Integer.valueOf(this.kfw), Integer.valueOf(this.kfx));
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131127);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131128);
        Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            a(boq());
            if (this.kfx == 1) {
                this.kfw += 500;
                if (doScene(dispatcher(), this.callback) < 0) {
                    Log.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.callback.onSceneEnd(3, -1, "", this);
                }
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(131128);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131128);
    }

    public final cij boq() {
        return (cij) this.rr.iLL.iLR;
    }

    private synchronized void a(cij cij) {
        int i2;
        AppMethodBeat.i(131129);
        Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(cij.oTz));
        if (cij.oTA != null && cij.oTA.size() > 0) {
            int size = cij.oTA.size();
            ArrayList<n> arrayList = new ArrayList<>();
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < size; i3++) {
                bzv bzv = cij.oTA.get(i3);
                if (!TextUtils.isEmpty(bzv.UserName)) {
                    as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(bzv.UserName);
                    i2 = (Kn == null || !c.oR(Kn.field_type)) ? 0 : 2;
                } else {
                    i2 = 1;
                }
                if (this.kcB != null && this.kcB.containsKey(bzv.KPA)) {
                    n nVar = this.kcB.get(bzv.KPA);
                    nVar.field_username = bzv.UserName;
                    nVar.field_nickname = bzv.oUJ;
                    nVar.field_usernamepy = com.tencent.mm.platformtools.f.Si(bzv.oUJ);
                    nVar.field_nicknameqp = com.tencent.mm.platformtools.f.Sh(bzv.oUJ);
                    nVar.field_ret = bzv.Ret;
                    nVar.field_small_url = bzv.Mfu;
                    nVar.field_big_url = bzv.Mft;
                    nVar.field_status = i2;
                    nVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        nVar.field_contecttype = "weixin".concat(String.valueOf(i3));
                    } else {
                        nVar.field_contecttype = "google";
                    }
                    nVar.field_googlenamepy = com.tencent.mm.platformtools.f.Si(nVar.field_googlename);
                    arrayList.add(nVar);
                    String str = nVar.field_googleid;
                    String str2 = nVar.field_googlephotourl;
                    String str3 = this.mToken;
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        String str4 = str + "@google";
                        com.tencent.mm.aj.i Mx = p.aYB().Mx(str4);
                        if (Mx == null) {
                            Mx = new com.tencent.mm.aj.i();
                        }
                        Mx.username = str4;
                        Mx.fuz = 3;
                        Mx.iKX = com.tencent.mm.aj.c.ba(str2, str3);
                        Mx.iKW = com.tencent.mm.aj.c.ba(str2, str3);
                        Mx.fv(true);
                        Mx.cSx = 31;
                        p.aYB().b(Mx);
                    }
                    g.a aVar = new g.a();
                    aVar.field_userName = bzv.UserName;
                    aVar.field_scene = 58;
                    aVar.field_ticket = bzv.LRO;
                    linkedList.add(aVar);
                }
            }
            ((o) ((a) com.tencent.mm.kernel.g.ah(a.class)).getGoogleFriendStorage()).z(arrayList);
            com.tencent.mm.plugin.c.a.bqE().aTp().iB(linkedList);
        }
        AppMethodBeat.o(131129);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return f.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }
}
