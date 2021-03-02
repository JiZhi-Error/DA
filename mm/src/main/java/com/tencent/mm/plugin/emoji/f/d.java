package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.LinkedList;

public final class d extends q implements m {
    private i callback;
    private ArrayList<String> rcu;
    private final com.tencent.mm.ak.d rr;

    public d(ArrayList<String> arrayList) {
        AppMethodBeat.i(108671);
        d.a aVar = new d.a();
        aVar.iLN = new jy();
        aVar.iLO = new jz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        aVar.funcId = 696;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcu = arrayList;
        AppMethodBeat.o(108671);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108672);
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i4 == -434) {
            Log.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.TRUE);
            h.INSTANCE.idkeyStat(164, 4, 1, false);
        }
        if (i3 == 0 && i4 == 0) {
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
            f fVar = k.getEmojiStorageMgr().OpN;
            ArrayList<String> arrayList = this.rcu;
            if (arrayList == null || arrayList.size() <= 0) {
                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", Integer.valueOf(arrayList.size()));
                StringBuilder sb = new StringBuilder();
                sb.append("UPDATE");
                sb.append(" EmojiInfo ");
                sb.append(" SET ");
                sb.append("source");
                sb.append("=");
                sb.append(EmojiInfo.Vli);
                sb.append(" where ");
                sb.append("md5");
                sb.append(" IN (");
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    sb.append("'" + arrayList.get(i5) + "'");
                    if (i5 < arrayList.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append(")");
                Log.d("MicroMsg.emoji.EmojiInfoStorage", sb.toString());
                fVar.db.execSQL("EmojiInfo", sb.toString());
            }
            h.INSTANCE.idkeyStat(164, 2, 1, false);
        } else {
            h.INSTANCE.idkeyStat(164, 3, 1, false);
        }
        jz jzVar = (jz) this.rr.iLL.iLR;
        if (jzVar.KMA != null && jzVar.KMA.size() > 0) {
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            k.getEmojiStorageMgr().OpN.bJ(jzVar.KMA);
            g.aAh().azQ().set(348165, Boolean.TRUE);
            a.lr(true);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108672);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 696;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(108673);
        this.callback = iVar;
        ((jy) this.rr.iLK.iLR).KMy = new LinkedList<>(this.rcu);
        if (this.rcu == null || this.rcu.size() <= 0) {
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
            g.aAh().azQ().set(348162, Boolean.FALSE);
            AppMethodBeat.o(108673);
            return -1;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108673);
        return dispatch;
    }
}
