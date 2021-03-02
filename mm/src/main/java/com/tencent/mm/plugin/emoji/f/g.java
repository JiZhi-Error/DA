package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class g extends q implements m {
    private i callback;
    private EmojiInfo dEz;
    private long gXF = System.currentTimeMillis();
    private boolean gvP = true;
    private int rcC = 256;
    private final d rr;

    public g(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108674);
        Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.gXF);
        this.dEz = emojiInfo;
        d.a aVar = new d.a();
        aVar.iLN = new ajb();
        aVar.iLO = new ajc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.funcId = 703;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ajb ajb = (ajb) this.rr.iLK.iLR;
        ene ene = new ene();
        if (this.dEz != null) {
            h.INSTANCE.n(164, 13, 1);
            Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", this.dEz.getMd5());
            ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.a(MMApplicationContext.getContext(), this.dEz);
            ene.MD5 = this.dEz.getMd5();
            ene.BsF = this.dEz.field_size;
            ajb.LsE.add(ene);
            this.rcC = (this.dEz.field_size / 8192) * 2;
        }
        AppMethodBeat.o(108674);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 703;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2;
        byte[] nl;
        int i3;
        byte[] nl2;
        int i4;
        int i5 = -1;
        AppMethodBeat.i(108675);
        this.callback = iVar;
        ene ene = ((ajb) this.rr.iLK.iLR).LsE.get(0);
        if (this.gvP) {
            Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + ene.MD5);
            ene.BsG = 0;
            int i6 = this.dEz.field_size + 0;
            if (i6 > 8192) {
                i3 = 8192;
            } else {
                i3 = i6;
            }
            if ((this.dEz.field_reserved4 & EmojiInfo.Vll) == EmojiInfo.Vll) {
                byte[] a2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dEz);
                if (!Util.isNullOrNil(a2)) {
                    nl2 = new byte[i3];
                    Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(a2.length), Integer.valueOf(i3));
                    System.arraycopy(a2, 0, nl2, 0, i3);
                } else {
                    Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    nl2 = new byte[0];
                }
            } else {
                nl2 = this.dEz.nl(0, i3);
            }
            if (nl2 == null || nl2.length <= 0) {
                Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                AppMethodBeat.o(108675);
                return -1;
            }
            ene.BsG = 0;
            ene.Nlc = new b(nl2);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(nl2.length);
            objArr[1] = Integer.valueOf(ene.Nlc.zy.length);
            if (this.dEz == null) {
                i4 = -1;
            } else {
                i4 = this.dEz.field_start;
            }
            objArr[2] = Integer.valueOf(i4);
            if (this.dEz != null) {
                i5 = this.dEz.field_size;
            }
            objArr[3] = Integer.valueOf(i5);
            Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", objArr);
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(108675);
            return dispatch;
        } else if (this.dEz == null || this.dEz.field_start == 0) {
            Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            AppMethodBeat.o(108675);
            return -1;
        } else {
            int i7 = this.dEz.field_size - this.dEz.field_start;
            if (i7 > 8192) {
                i2 = 8192;
            } else {
                i2 = i7;
            }
            if ((this.dEz.field_reserved4 & EmojiInfo.Vll) == EmojiInfo.Vll) {
                byte[] a3 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dEz);
                if (!Util.isNullOrNil(a3)) {
                    nl = new byte[i2];
                    Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", Integer.valueOf(a3.length), Integer.valueOf(i2));
                    System.arraycopy(a3, this.dEz.field_start, nl, 0, i2);
                } else {
                    Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    nl = new byte[0];
                }
            } else {
                nl = this.dEz.nl(this.dEz.field_start, i2);
            }
            if (nl == null || nl.length <= 0) {
                Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                AppMethodBeat.o(108675);
                return -1;
            }
            int length = nl.length;
            ene.BsG = this.dEz.field_start;
            ene.Nlc = new b(nl);
            Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", Integer.valueOf(nl.length), Integer.valueOf(ene.Nlc.zy.length));
            Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.dEz.field_start + ", total:" + this.dEz.field_size + ", len:" + length);
            int dispatch2 = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(108675);
            return dispatch2;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        int i6;
        AppMethodBeat.i(108676);
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i3 + " errcode:" + i4);
        if (i3 == 0 && i4 == 0) {
            ajb ajb = (ajb) ((d) sVar).iLK.iLR;
            ajc ajc = (ajc) ((d) sVar).iLL.iLR;
            if (ajb.LsE.size() != ajc.LsE.size()) {
                Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + ajb.LsE.size() + ", resp size:" + ajc.LsE.size());
                cGr();
                this.callback.onSceneEnd(i3, i4, str, this);
                e(this.dEz, false);
                AppMethodBeat.o(108676);
                return;
            }
            enf enf = null;
            if (ajc.LsE != null && ajc.LsE.size() > 0) {
                enf = ajc.LsE.get(0);
            }
            if (enf == null || enf.MD5 == null || !enf.MD5.equals(this.dEz.getMd5()) || enf.BsG < this.dEz.field_start) {
                Object[] objArr = new Object[5];
                objArr[0] = enf.MD5;
                objArr[1] = Integer.valueOf(enf.BsF);
                objArr[2] = Integer.valueOf(enf == null ? -1 : enf.BsG);
                if (this.dEz == null) {
                    i5 = -1;
                } else {
                    i5 = this.dEz.field_start;
                }
                objArr[3] = Integer.valueOf(i5);
                if (this.dEz == null) {
                    i6 = -1;
                } else {
                    i6 = this.dEz.field_size;
                }
                objArr[4] = Integer.valueOf(i6);
                Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", objArr);
                cGr();
                this.callback.onSceneEnd(4, -2, "", this);
                e(this.dEz, false);
                AppMethodBeat.o(108676);
            } else if (enf != null && this.dEz != null && enf.Ret != 0 && enf.BsG == enf.BsF && enf.BsG > 0) {
                Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", this.dEz.getMd5(), Integer.valueOf(enf.Ret), Integer.valueOf(enf.BsG), Integer.valueOf(enf.BsF));
                cGr();
                this.callback.onSceneEnd(i3, i4, "", this);
                AppMethodBeat.o(108676);
            } else if (ajc.BaseResponse.Ret == 0 && (enf == null || enf.Ret == 0)) {
                if (this.gvP) {
                    this.gvP = false;
                }
                if (enf.BsG >= enf.BsF) {
                    this.dEz.field_start = 0;
                    this.dEz.field_state = EmojiInfo.Vle;
                    this.dEz.field_needupload = EmojiInfo.Vlj;
                    ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.dEz);
                    this.callback.onSceneEnd(i3, i4, "", this);
                    e(this.dEz, true);
                    Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    AppMethodBeat.o(108676);
                    return;
                }
                Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", Integer.valueOf(enf.BsG));
                this.dEz.field_start = enf.BsG;
                ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.dEz);
                if (doScene(dispatcher(), this.callback) < 0) {
                    this.callback.onSceneEnd(3, -1, "", this);
                    e(this.dEz, false);
                }
                AppMethodBeat.o(108676);
            } else {
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(ajc.BaseResponse.Ret);
                objArr2[1] = Integer.valueOf(enf == null ? -1 : enf.Ret);
                Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", objArr2);
                cGr();
                this.callback.onSceneEnd(i3, i4, "", this);
                AppMethodBeat.o(108676);
            }
        } else {
            cGr();
            this.callback.onSceneEnd(i3, i4, str, this);
            e(this.dEz, false);
            AppMethodBeat.o(108676);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return this.rcC;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    private void cGr() {
        AppMethodBeat.i(108677);
        this.dEz.field_start = 0;
        ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.dEz);
        AppMethodBeat.o(108677);
    }

    private void e(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(108678);
        if (emojiInfo != null && !Util.isNullOrNil(emojiInfo.getMd5())) {
            Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", emojiInfo.getMd5(), Boolean.valueOf(z));
            dm dmVar = new dm();
            dmVar.dGw.md5 = emojiInfo.getMd5();
            dmVar.dGw.dDe = 0;
            dmVar.dGw.success = z;
            EventCenter.instance.publish(dmVar);
            long currentTimeMillis = System.currentTimeMillis() - this.gXF;
            Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + currentTimeMillis + " size " + emojiInfo.field_size + " rate " + (((long) emojiInfo.field_size) / currentTimeMillis));
        }
        AppMethodBeat.o(108678);
    }
}
