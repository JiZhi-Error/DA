package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.emoji.sync.d;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.o;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;

public final class h extends q implements m {
    private i heq;
    public String iYT;
    boolean ifz;
    private int mScene;
    public String rcD;
    public String rcE;
    public String rcF;
    String rcG;
    public String rcH;
    private int rcI;
    private boolean rcJ;
    private g.a rcK;
    EmojiGroupInfo rcL;
    private final d rr;

    private h(String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.i(240153);
        this.iYT = "";
        this.rcK = new g.a() {
            /* class com.tencent.mm.plugin.emoji.f.h.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(108679);
                if (Util.isNullOrNil(h.this.iYT) || !str.equals(h.this.iYT)) {
                    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
                    AppMethodBeat.o(108679);
                } else if (i2 == -21006) {
                    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", h.this.iYT);
                    h.h(h.this.rcD, 6, 0, h.this.iYT);
                    AppMethodBeat.o(108679);
                } else if (i2 != 0) {
                    Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", h.this.rcD);
                    h.h(h.this.rcD, -1, 0, h.this.iYT);
                    AppMethodBeat.o(108679);
                } else if (cVar == null) {
                    if (dVar != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10625, 2, dVar.field_fileId, h.this.rcD, dVar.field_transInfo);
                        if (dVar.field_retCode != 0) {
                            Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", h.this.rcD, Integer.valueOf(dVar.field_retCode));
                            h.h(h.this.rcD, -1, 0, h.this.iYT);
                        } else {
                            Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                            d.a aVar = com.tencent.mm.emoji.sync.d.hcI;
                            String str2 = h.this.rcD;
                            p.h(str2, "productId");
                            Log.i(com.tencent.mm.emoji.sync.d.TAG, "checkPack: ".concat(String.valueOf(str2)));
                            com.tencent.mm.ac.d.i(new d.a.C0338a(str2, d.a.b.hcM));
                            try {
                                com.tencent.mm.plugin.emoji.e.c cFD = com.tencent.mm.plugin.emoji.e.c.cFD();
                                String str3 = h.this.rcD;
                                if (cFD.qZu != null && cFD.qZu.contains(str3)) {
                                    cFD.qZu.remove(str3);
                                }
                                EmojiLogic.a(h.this.rcD, h.this.rcE, h.this.rcG, h.this.rcH, h.this.rcL);
                                k.getEmojiStorageMgr().OpN.doNotify();
                                h.h(h.this.rcD, 7, 100, h.this.iYT);
                                o oVar = new o(b.aKM() + h.this.rcD);
                                if (oVar.isFile() && oVar.exists()) {
                                    oVar.delete();
                                }
                                h.aP(h.this.rcD, true);
                                AppMethodBeat.o(108679);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + Util.getStack());
                                h.h(h.this.rcD, -1, 0, h.this.iYT);
                                h.aP(h.this.rcD, false);
                                AppMethodBeat.o(108679);
                                return 0;
                            } catch (OutOfMemoryError e3) {
                                Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + Util.getStack());
                                h.h(h.this.rcD, -1, 0, h.this.iYT);
                                h.aP(h.this.rcD, false);
                                AppMethodBeat.o(108679);
                                return 0;
                            }
                        }
                    }
                    AppMethodBeat.o(108679);
                } else if (cVar.field_finishedLength == cVar.field_toltalLength) {
                    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
                    AppMethodBeat.o(108679);
                } else {
                    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", h.this.iYT, Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength));
                    if (!h.this.ifz) {
                        h.h(h.this.rcD, 6, (int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f), h.this.iYT);
                    }
                    AppMethodBeat.o(108679);
                }
                return 0;
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return null;
            }
        };
        this.rcD = str;
        this.rcE = str3;
        this.rcF = str2;
        this.rcG = str4;
        this.rcH = str5;
        this.rcL = null;
        this.rcI = i2;
        this.mScene = i3;
        this.rcJ = false;
        d.a aVar = new d.a();
        aVar.iLN = new ExchangeEmotionPackRequest();
        aVar.iLO = new ExchangeEmotionPackResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.funcId = v2helper.EMethodSetNgStrength;
        aVar.iLP = 213;
        aVar.respCmdId = 1000000213;
        this.rr = aVar.aXF();
        AppMethodBeat.o(240153);
    }

    public h(String str, String str2, String str3) {
        this(str, str2, str3, null, null);
    }

    public h(String str, String str2) {
        this(str, null, str2, null, null, 0, 0);
    }

    public h(String str) {
        this(str, null, "", null, null, 1, 0);
    }

    public h(String str, byte b2) {
        this(str, null, "", null, null, 1, 1);
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, 0, 0);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetNgStrength;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108681);
        Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.emoji.e.d dVar = com.tencent.mm.emoji.e.d.hdY;
            com.tencent.mm.emoji.e.d.Fa(this.rcD);
            if (this.mScene == 0) {
                o oVar = new o(b.aKM());
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                if (!this.rcJ) {
                    long currentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    com.tencent.mm.kernel.g.aAf();
                    this.iYT = com.tencent.mm.an.c.a("downzip", currentTimeMillis, sb.append(a.getUin()).toString(), "emoji");
                }
                EmotionCDNUrl emotionCDNUrl = ((ExchangeEmotionPackResponse) this.rr.iLL.iLR).DownloadInfo;
                g gVar = new g();
                gVar.taskName = "task_NetSceneExchangeEmotionPack";
                gVar.field_mediaId = this.iYT;
                gVar.field_fullpath = b.aKM() + this.rcD;
                gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
                gVar.field_totalLen = emotionCDNUrl.FileSize;
                gVar.field_aesKey = emotionCDNUrl.AesKey;
                gVar.field_fileId = emotionCDNUrl.Url;
                gVar.field_priority = com.tencent.mm.i.a.gpM;
                gVar.gqy = this.rcK;
                gVar.field_needStorage = true;
                this.ifz = false;
                if (!f.baQ().b(gVar, -1)) {
                    Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                Log.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.heq.onSceneEnd(i3, i4, str, this);
            com.tencent.mm.kernel.g.aAg().hqi.a(new l(this.rcD), 0);
            AppMethodBeat.o(108681);
            return;
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        h(this.rcD, -1, 0, this.iYT);
        AppMethodBeat.o(108681);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(108682);
        Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.heq = iVar;
        if (this.mScene == 0) {
            h(this.rcD, 6, 0, this.iYT);
        }
        ExchangeEmotionPackRequest exchangeEmotionPackRequest = (ExchangeEmotionPackRequest) this.rr.iLK.iLR;
        exchangeEmotionPackRequest.ProductID = this.rcD;
        exchangeEmotionPackRequest.SeriesID = this.rcF;
        exchangeEmotionPackRequest.IsAutomatic = this.rcI;
        exchangeEmotionPackRequest.Scene = this.mScene;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108682);
        return dispatch;
    }

    static void h(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(108683);
        k.cGk().h(str, i2, i3, str2);
        AppMethodBeat.o(108683);
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(108684);
        super.cancel();
        this.ifz = true;
        AppMethodBeat.o(108684);
    }

    static /* synthetic */ void aP(String str, boolean z) {
        AppMethodBeat.i(240154);
        if (!Util.isNullOrNil(str)) {
            Log.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", str, Boolean.valueOf(z));
            dm dmVar = new dm();
            dmVar.dGw.md5 = str;
            dmVar.dGw.dDe = 2;
            dmVar.dGw.success = z;
            EventCenter.instance.publish(dmVar);
        }
        AppMethodBeat.o(240154);
    }
}
