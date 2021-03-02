package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.o;
import java.io.IOException;

public final class p extends q implements m {
    public static int rde = 0;
    public static int rdf = 1;
    public static int rdg = 1;
    public static int rdh = 2;
    public static int rdi = 256;
    private i callback;
    private String rcq;
    private int rdj;
    private final d rr;

    public p(String str, int i2) {
        AppMethodBeat.i(108712);
        d.a aVar = new d.a();
        aVar.iLN = new GetEmotionRewardRequest();
        aVar.iLO = new GetEmotionRewardResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        aVar.funcId = 822;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcq = str;
        this.rdj = i2;
        AppMethodBeat.o(108712);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108713);
        Log.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            if (this.rdj == rde) {
                o oVar = k.getEmojiStorageMgr().OpS;
                String str2 = this.rcq;
                GetEmotionRewardResponse cGz = cGz();
                if (Util.isNullOrNil(str2) || cGz == null) {
                    Log.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        n nVar = new n();
                        nVar.field_productID = str2;
                        nVar.field_content = cGz.toByteArray();
                        if (oVar.db.replace("EmotionRewardInfo", "productID", nVar.convertTo()) > 0) {
                            Log.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", str2);
                        } else {
                            Log.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", str2);
                        }
                    } catch (IOException e2) {
                        Log.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", Util.stackTraceToString(e2));
                    }
                }
            }
            if (cGz() == null || cGz().Reward == null) {
                Log.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                k.getEmojiStorageMgr().OpU.gU(this.rcq, rdi);
                k.cGj().dg(this.rcq, rdi);
            } else {
                k.getEmojiStorageMgr().OpU.gU(this.rcq, cGz().Reward.KHa);
                k.cGj().dg(this.rcq, cGz().Reward.KHa);
            }
        } else if (i4 == 1) {
            k.getEmojiStorageMgr().OpU.gU(this.rcq, rdi);
            k.cGj().dg(this.rcq, rdi);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108713);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 822;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108714);
        this.callback = iVar;
        GetEmotionRewardRequest getEmotionRewardRequest = (GetEmotionRewardRequest) this.rr.iLK.iLR;
        getEmotionRewardRequest.ProductID = this.rcq;
        getEmotionRewardRequest.OpCode = this.rdj;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108714);
        return dispatch;
    }

    public final GetEmotionRewardResponse cGz() {
        return (GetEmotionRewardResponse) this.rr.iLL.iLR;
    }
}
