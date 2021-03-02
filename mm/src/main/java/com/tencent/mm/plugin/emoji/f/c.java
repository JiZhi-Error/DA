package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements m {
    private i callback;
    public int kfa;
    private int rcs;
    private List<String> rct;
    private final d rr;

    public c(int i2, int i3, List<String> list) {
        AppMethodBeat.i(104566);
        d.a aVar = new d.a();
        aVar.iLN = new ik();
        aVar.iLO = new il();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        aVar.funcId = 698;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcs = i2;
        this.kfa = i3;
        this.rct = list;
        AppMethodBeat.o(104566);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(104567);
        Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i4 == -434) {
            Log.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.TRUE);
            h.INSTANCE.idkeyStat(164, 7, 1, false);
        }
        if (i3 == 0 && i4 == 0) {
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
            if (this.kfa == 1 || this.kfa == 4) {
                h.INSTANCE.idkeyStat(164, 5, 1, false);
            } else {
                h.INSTANCE.idkeyStat(164, 8, 1, false);
            }
        } else if (this.kfa == 1 || this.kfa == 4) {
            h.INSTANCE.idkeyStat(164, 6, 1, false);
        } else {
            h.INSTANCE.idkeyStat(164, 9, 1, false);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(104567);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 698;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(104568);
        this.callback = iVar;
        ik ikVar = (ik) this.rr.iLK.iLR;
        ikVar.KMz = this.kfa;
        ikVar.KMy = new LinkedList<>(this.rct);
        ikVar.xIY = this.rcs;
        if (ikVar.KMy == null || ikVar.KMy.size() <= 0) {
            Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", Integer.valueOf(ikVar.KMy.size()));
            for (int i2 = 0; i2 < ikVar.KMy.size(); i2++) {
                Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", ikVar.KMy.get(i2));
            }
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(104568);
        return dispatch;
    }
}
