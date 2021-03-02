package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.emoji.d.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.eni;
import com.tencent.mm.protocal.protobuf.enj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsListener;
import junit.framework.Assert;

public final class s extends q implements m {
    i callback;
    private EmojiInfo dEz;
    boolean gvP;
    private long iXv;
    boolean rdl;
    private final d rr;

    public s(String str, String str2, EmojiInfo emojiInfo, long j2) {
        this(str, str2, emojiInfo, j2, (byte) 0);
    }

    private s(String str, String str2, EmojiInfo emojiInfo, long j2, byte b2) {
        int i2;
        AppMethodBeat.i(108723);
        this.gvP = true;
        this.rdl = false;
        this.iXv = 0;
        Assert.assertTrue((str2 == null || str2.length() <= 0 || emojiInfo == null) ? false : true);
        this.iXv = j2;
        this.dEz = emojiInfo;
        d.a aVar = new d.a();
        aVar.iLN = new eni();
        aVar.iLO = new enj();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
        aVar.iLP = 68;
        aVar.respCmdId = 1000000068;
        this.rr = aVar.aXF();
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.a(MMApplicationContext.getContext(), emojiInfo);
        eni eni = (eni) this.rr.iLK.iLR;
        aiz aiz = new aiz();
        Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", emojiInfo.getMd5(), Integer.valueOf(emojiInfo.field_size));
        aiz.MD5 = emojiInfo.getMd5();
        aiz.LsB = str;
        aiz.xNG = str2;
        aiz.BsF = emojiInfo.field_size;
        aiz.Lsz = emojiInfo.getContent();
        aiz.oUv = emojiInfo.field_type;
        aiz.KHq = br.ajw();
        aiz.LsC = 0;
        if (((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(str2)) {
            aiz.LbN = ((l) g.af(l.class)).aSN().bjT(str2);
        }
        if (ab.Eq(str2)) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        if (emojiInfo.field_catalog == EmojiInfo.VkV) {
            aiz.LsA = "56,2,".concat(String.valueOf(i2));
        } else if (emojiInfo.field_catalog == EmojiInfo.VkU) {
            aiz.LsA = "56,1,".concat(String.valueOf(i2));
        }
        eni.LsE.add(aiz);
        eni.Nlk = eni.LsE.size();
        AppMethodBeat.o(108723);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        byte[] nl;
        AppMethodBeat.i(108724);
        this.callback = iVar;
        aiz aiz = ((eni) this.rr.iLK.iLR).LsE.get(0);
        if (this.gvP) {
            Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + aiz.MD5);
            aiz.Lsy = new SKBuiltinBuffer_t();
            aiz.BsG = 0;
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(108724);
            return dispatch;
        }
        int i2 = this.dEz.field_size - this.dEz.field_start;
        if (i2 > 8192) {
            i2 = 8192;
        }
        if ((this.dEz.field_reserved4 & EmojiInfo.Vll) == EmojiInfo.Vll) {
            byte[] a2 = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dEz);
            if (!Util.isNullOrNil(a2)) {
                nl = new byte[i2];
                Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", Integer.valueOf(a2.length), Integer.valueOf(i2));
                System.arraycopy(a2, this.dEz.field_start, nl, 0, i2);
            } else {
                Log.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                nl = new byte[0];
            }
        } else {
            nl = this.dEz.nl(this.dEz.field_start, i2);
        }
        if (b.bt(nl) == EmojiInfo.VkM && this.gvP) {
            Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.dEz.hYj();
            AppMethodBeat.o(108724);
            return -1;
        } else if (nl == null || nl.length <= 0) {
            Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            AppMethodBeat.o(108724);
            return -1;
        } else {
            int length = nl.length;
            aiz.BsG = this.dEz.field_start;
            aiz.Lsy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cD(nl));
            if (com.tencent.mm.al.g.DQ(aiz.xNG)) {
                aiz.KHq = a.C0409a.anC().o(((l) g.af(l.class)).eiy().Hb(this.iXv));
                Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", aiz.KHq);
            }
            Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.dEz.field_start + ", total:" + this.dEz.field_size + ", len:" + length);
            int dispatch2 = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(108724);
            return dispatch2;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        EmojiInfo emojiInfo;
        AppMethodBeat.i(108725);
        Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + i3 + " errcode:" + i4);
        eni eni = (eni) ((d) sVar).iLK.iLR;
        enj enj = (enj) ((d) sVar).iLL.iLR;
        if (enj != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(enj.LbO);
        }
        if (i3 != 0 || i4 != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(108725);
        } else if (eni.LsE.size() != enj.LsE.size()) {
            Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + enj.LsE.size() + ", resp size:" + eni.LsE.size());
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(108725);
        } else {
            aja aja = enj.LsE.get(0);
            if (aja.MD5 == null || !aja.MD5.equals(this.dEz.getMd5()) || aja.BsG < this.dEz.field_start) {
                Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + aja.BsG + ", size=" + this.dEz.field_size);
                this.callback.onSceneEnd(4, -2, "", this);
                this.dEz.field_start = 0;
                ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.M(this.dEz);
                AppMethodBeat.o(108725);
            } else if (enj.BaseResponse.Ret != 0) {
                Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", Integer.valueOf(enj.BaseResponse.Ret));
                this.callback.onSceneEnd(4, -2, "", this);
                AppMethodBeat.o(108725);
            } else if (aja.Ret != 0) {
                Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", Integer.valueOf(aja.Ret));
                this.callback.onSceneEnd(4, -2, "", this);
                AppMethodBeat.o(108725);
            } else if (aja.BsG >= aja.BsF) {
                Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + aja.LsD);
                ca Hb = ((l) g.af(l.class)).eiy().Hb(this.iXv);
                Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(aja.Brn), Integer.valueOf(ac.jOD));
                if (10007 == ac.jOC && ac.jOD != 0) {
                    aja.LsD = ac.jOD;
                    ac.jOD = 0;
                }
                Hb.yF(aja.Brn);
                ((l) g.af(l.class)).eiy().a(this.iXv, Hb);
                EmojiInfo blk = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.blk(this.dEz.field_md5);
                if (blk == null) {
                    emojiInfo = this.dEz;
                } else {
                    emojiInfo = blk;
                }
                emojiInfo.field_start = 0;
                emojiInfo.field_lastUseTime = System.currentTimeMillis();
                emojiInfo.field_state = EmojiInfo.Vle;
                ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.M(emojiInfo);
                if (Hb.dOQ()) {
                    com.tencent.mm.modelstat.b.jmd.b(Hb, com.tencent.mm.ag.l.t(Hb));
                } else {
                    com.tencent.mm.modelstat.b.jmd.s(Hb);
                }
                this.callback.onSceneEnd(i3, i4, "", this);
                AppMethodBeat.o(108725);
            } else if (!n.avl()) {
                if (this.gvP) {
                    this.gvP = false;
                }
                this.dEz.field_start = aja.BsG;
                this.dEz.field_lastUseTime = System.currentTimeMillis();
                ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.M(this.dEz);
                if (doScene(dispatcher(), this.callback) < 0) {
                    this.callback.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.o(108725);
            } else if (this.rdl) {
                this.callback.onSceneEnd(4, -2, "", this);
                AppMethodBeat.o(108725);
            } else {
                new f(this.dEz, false, new d.a() {
                    /* class com.tencent.mm.plugin.emoji.f.s.AnonymousClass1 */

                    @Override // com.tencent.mm.emoji.d.d.a
                    public final void A(int i2, String str) {
                        AppMethodBeat.i(108722);
                        if (i2 == 0) {
                            s.this.rdl = true;
                            s.this.gvP = true;
                            if (s.this.doScene(s.this.dispatcher(), s.this.callback) < 0) {
                                s.this.callback.onSceneEnd(3, -1, "", s.this);
                                AppMethodBeat.o(108722);
                                return;
                            }
                        } else {
                            s.this.callback.onSceneEnd(4, -2, "", s.this);
                        }
                        AppMethodBeat.o(108722);
                    }
                });
                AppMethodBeat.o(108725);
            }
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 256;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }
}
