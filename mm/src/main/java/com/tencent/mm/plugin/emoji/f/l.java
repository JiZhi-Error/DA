package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends q implements m {
    private i heq;
    private c.a rcV;
    private boolean rcW = false;
    private ql rcX = null;
    public String rcq = "";
    public final d rr;

    public l(String str) {
        AppMethodBeat.i(108695);
        d.a aVar = new d.a();
        aVar.iLN = new bmr();
        aVar.iLO = new bms();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.funcId = 521;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcq = str;
        this.rcX = new ql();
        AppMethodBeat.o(108695);
    }

    public l(String str, c.a aVar) {
        AppMethodBeat.i(108696);
        d.a aVar2 = new d.a();
        aVar2.iLN = new bmr();
        aVar2.iLO = new bms();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.funcId = 521;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        this.rcq = str;
        this.rcV = aVar;
        this.rcW = true;
        this.rcX = new ql();
        AppMethodBeat.o(108696);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 521;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108697);
        Log.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", this.rcq);
        this.heq = iVar;
        ((bmr) this.rr.iLK.iLR).ProductID = this.rcq;
        if (TextUtils.isEmpty(this.rcq)) {
            Log.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
            AppMethodBeat.o(108697);
            return -1;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108697);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        long j2;
        AppMethodBeat.i(108698);
        if (i3 != 0 || i4 != 0) {
            Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", Integer.valueOf(i3), Integer.valueOf(i4), this.rcq);
            if (this.rcW) {
                Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.rcW) {
            LinkedList<ajf> linkedList = ((bms) this.rr.iLL.iLR).oTA;
            e eVar = k.getEmojiStorageMgr().OpP;
            String str2 = this.rcq;
            int i5 = ((bms) this.rr.iLL.iLR).LVs;
            int cGu = cGu();
            if (eVar.OsE != null) {
                eVar.OsE.edit().putLong("274544".concat(String.valueOf(str2)), System.currentTimeMillis()).commit();
            }
            if (linkedList != null && linkedList.size() > 0) {
                h hVar = null;
                if (eVar.db instanceof h) {
                    h hVar2 = (h) eVar.db;
                    j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    j2 = -1;
                }
                eVar.db.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                com.tencent.mm.storage.emotion.d dVar = new com.tencent.mm.storage.emotion.d();
                dVar.field_groupId = str2;
                dVar.field_click_flag = i5;
                dVar.field_download_flag = cGu;
                Iterator<ajf> it = linkedList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ajf next = it.next();
                        dVar.field_md5 = next.Md5;
                        Iterator<cgx> it2 = next.oTA.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                cgx next2 = it2.next();
                                dVar.field_desc = next2.Desc;
                                dVar.field_lang = next2.xLl;
                                dVar.field_md5_lang = dVar.field_md5 + dVar.field_lang;
                                if (eVar.db.replace("EmojiInfoDesc", "md5_lang", dVar.convertTo()) < 0) {
                                    if (hVar != null) {
                                        hVar.endTransaction(j2);
                                    }
                                }
                            }
                        }
                    } else {
                        eVar.db.replace("EmojiInfoDesc", "md5_lang", dVar.convertTo());
                        if (hVar != null) {
                            hVar.endTransaction(j2);
                        }
                    }
                }
            }
            if (linkedList != null && linkedList.size() > 0) {
                Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", this.rcq);
                this.rcX.dWU.productId = this.rcq;
                EventCenter.instance.publish(this.rcX);
            }
        } else if ((cGu() & 1) == 1) {
            c.a(this.rcV);
        } else {
            Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108698);
    }

    private int cGu() {
        return ((bms) this.rr.iLL.iLR).LVu;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 50;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }
}
