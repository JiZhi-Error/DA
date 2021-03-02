package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class t extends q implements m {
    private i callback;
    private int kfa;
    private List<String> rdn = new ArrayList();
    private final d rr;

    public t(List<String> list, int i2) {
        AppMethodBeat.i(108726);
        d.a aVar = new d.a();
        aVar.iLN = new enw();
        aVar.iLO = new enx();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        aVar.funcId = 717;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rdn = list;
        this.kfa = i2;
        AppMethodBeat.o(108726);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108727);
        Log.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, Long.valueOf(System.currentTimeMillis()));
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.TRUE);
            h.INSTANCE.idkeyStat(165, 0, 1, false);
        } else {
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, Long.valueOf((System.currentTimeMillis() - Util.MILLSECONDS_OF_DAY) + Util.MILLSECONDS_OF_HOUR));
            h.INSTANCE.idkeyStat(165, 1, 1, false);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108727);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 717;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(108728);
        this.callback = iVar;
        enw enw = (enw) this.rr.iLK.iLR;
        enw.OpCode = this.kfa;
        if (this.rdn != null) {
            for (String str : this.rdn) {
                if (!Util.isNullOrNil(str) && str.equals(String.valueOf(EmojiGroupInfo.VkN))) {
                    str = "com.tencent.xin.emoticon.tusiji";
                }
                enw.NlK.add(str);
                Log.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", str);
            }
            Log.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", Integer.valueOf(this.kfa), Integer.valueOf(this.rdn.size()));
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108728);
        return dispatch;
    }
}
