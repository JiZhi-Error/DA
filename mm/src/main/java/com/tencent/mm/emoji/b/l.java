package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l {
    private static int gXt = 98304;
    private static int gXu = 4;
    private boolean brW = false;
    private final EmojiInfo gWm;
    public b gXA;
    private List<c> gXB = new ArrayList();
    private int gXC;
    private int gXD = 2;
    private int gXE;
    private long gXF;
    private boolean gXG;
    private boolean gXv;
    private boolean gXw;
    private String gXx;
    private List<String> gXy;
    private String gXz;

    public interface b {
        void b(int i2, int i3, String str, boolean z);
    }

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(104460);
        lVar.auU();
        AppMethodBeat.o(104460);
    }

    static /* synthetic */ void a(l lVar, int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(104459);
        lVar.a(i2, i3, str, z);
        AppMethodBeat.o(104459);
    }

    public l(EmojiInfo emojiInfo, boolean z, String str, List<String> list, String str2) {
        AppMethodBeat.i(104456);
        Log.i("MicroMsg.EmojiUploadHelper", "EmojiUploadHelper: isCapture %s", Boolean.valueOf(z));
        this.gWm = emojiInfo;
        this.gXv = z;
        this.gXw = true;
        this.gXx = str;
        this.gXy = list;
        this.gXz = str2;
        this.gXF = System.currentTimeMillis();
        int i2 = emojiInfo.field_size;
        int ceil = (int) Math.ceil((((double) i2) * 1.0d) / ((double) gXt));
        this.gXC = ceil * 2;
        this.gXE = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            int i4 = i3 * gXt;
            int i5 = gXt;
            if (i4 + i5 > i2) {
                i5 = i2 - i4;
            }
            c cVar = new c(this, (byte) 0);
            cVar.index = i3;
            cVar.start = i4;
            cVar.djh = i5;
            this.gXB.add(cVar);
        }
        Log.i("MicroMsg.EmojiUploadHelper", "start upload emoji, md5 %s, totalLen %d, parts %d, file %s", emojiInfo.getMd5(), Integer.valueOf(i2), Integer.valueOf(ceil), emojiInfo.hYx());
        for (int i6 = 0; i6 < gXu; i6++) {
            auU();
        }
        AppMethodBeat.o(104456);
    }

    private synchronized void auU() {
        boolean z;
        final c cVar = null;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            AppMethodBeat.i(104457);
            if (this.brW) {
                AppMethodBeat.o(104457);
            } else {
                Iterator<c> it = this.gXB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = z2;
                        break;
                    }
                    c next = it.next();
                    if (next.completed) {
                        z = z2;
                    } else if (!next.running) {
                        cVar = next;
                        break;
                    } else {
                        z = false;
                    }
                    z2 = z;
                }
                if (cVar == null) {
                    if (z3) {
                        Log.w("MicroMsg.EmojiUploadHelper", "all parts finished but not completed");
                        a(4, 4, null, false);
                    }
                    AppMethodBeat.o(104457);
                } else if (this.gXE >= this.gXC) {
                    Log.w("MicroMsg.EmojiUploadHelper", "req count is %d, max is %d; toRun part is %d", Integer.valueOf(this.gXE), Integer.valueOf(this.gXC), Integer.valueOf(cVar.index));
                    a(3, -2, null, false);
                    AppMethodBeat.o(104457);
                } else {
                    this.gXE++;
                    cVar.retryCount++;
                    cVar.running = true;
                    Log.i("MicroMsg.EmojiUploadHelper", "start part %d, retry count %d", Integer.valueOf(cVar.index), Integer.valueOf(cVar.retryCount));
                    new a(this.gWm, cVar, this.gXv, this.gXw, this.gXx, this.gXy, this.gXz).aYI().g(new com.tencent.mm.vending.c.a<Void, c.a<ajc>>() {
                        /* class com.tencent.mm.emoji.b.l.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(c.a<ajc> aVar) {
                            AppMethodBeat.i(104453);
                            c.a<ajc> aVar2 = aVar;
                            int i2 = aVar2.errType;
                            int i3 = aVar2.errCode;
                            cVar.running = false;
                            if (i2 == 0 && i3 == 0) {
                                ajc ajc = (ajc) aVar2.iLC;
                                if (ajc.LsE.size() <= 0) {
                                    Log.w("MicroMsg.EmojiUploadHelper", "part %d resp size error, size is %d", Integer.valueOf(cVar.index), Integer.valueOf(ajc.LsE.size()));
                                    l.a(l.this, i2, i3, null, false);
                                } else {
                                    enf enf = ajc.LsE.get(0);
                                    if (enf == null) {
                                        Log.e("MicroMsg.EmojiUploadHelper", "part %d resp info is null", Integer.valueOf(cVar.index));
                                        l.a(l.this, 4, -2, null, false);
                                    } else if (enf.Nlh) {
                                        Log.e("MicroMsg.EmojiUploadHelper", "part %d resp info IsTooLarge", Integer.valueOf(cVar.index));
                                        l.a(l.this, 3, -2, null, true);
                                    } else if (enf.Ret != 0) {
                                        Log.w("MicroMsg.EmojiUploadHelper", "part %d resp info error, md5 is %s, ret is %d", Integer.valueOf(cVar.index), enf.MD5, Integer.valueOf(enf.Ret));
                                        if (enf.Ret == -1) {
                                            l.a(l.this);
                                        } else {
                                            l.a(l.this, 4, enf.Ret, null, false);
                                        }
                                        Void r0 = QZL;
                                        AppMethodBeat.o(104453);
                                        return r0;
                                    } else {
                                        cVar.completed = true;
                                        Log.i("MicroMsg.EmojiUploadHelper", "finish part %d. completed %b", Integer.valueOf(cVar.index), Boolean.valueOf(enf.Nlg));
                                        if (enf.Nlg) {
                                            l.this.gWm.field_activityid = enf.LVq;
                                            l.a(l.this, enf.MD5);
                                            l.this.brW = true;
                                            long currentTimeMillis = System.currentTimeMillis() - l.this.gXF;
                                            Log.i("MicroMsg.EmojiUploadHelper", "complete cost %d, size %d, rate %d", Long.valueOf(currentTimeMillis), Integer.valueOf(l.this.gWm.field_size), Long.valueOf(((long) l.this.gWm.field_size) / currentTimeMillis));
                                            Log.i("MicroMsg.EmojiUploadHelper", "gif md5 is %s", enf.MD5);
                                            l.a(l.this, i2, i3, enf.MD5, false);
                                        } else {
                                            l.a(l.this);
                                        }
                                    }
                                }
                                Void r02 = QZL;
                                AppMethodBeat.o(104453);
                                return r02;
                            }
                            Log.e("MicroMsg.EmojiUploadHelper", "part %d code or type error, code is %d, type is %d", Integer.valueOf(cVar.index), Integer.valueOf(i3), Integer.valueOf(i2));
                            if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                                l.a(l.this, 3, 5, null, false);
                            } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                l.a(l.this, 3, 6, null, false);
                            } else {
                                l.a(l.this, 3, 7, null, false);
                            }
                            Void r03 = QZL;
                            AppMethodBeat.o(104453);
                            return r03;
                        }
                    });
                    AppMethodBeat.o(104457);
                }
            }
        }
    }

    private void a(int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(104458);
        if (this.gXA != null && !this.gXG) {
            this.gXG = true;
            if (i3 == -434) {
                if (this.gXv) {
                    k kVar = k.gXr;
                    k.ea(true);
                    g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                } else {
                    k kVar2 = k.gXr;
                    k.dZ(true);
                    g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            this.gXA.b(i2, i3, str, z);
            if (i3 == 0) {
                k kVar3 = k.gXr;
                k.auS();
            }
        }
        AppMethodBeat.o(104458);
    }

    public class a extends com.tencent.mm.ak.c<ajc> {
        public a(EmojiInfo emojiInfo, c cVar, boolean z, boolean z2, String str, List<String> list, String str2) {
            AppMethodBeat.i(104454);
            ajb ajb = new ajb();
            ene ene = new ene();
            ene.MD5 = emojiInfo.getMd5();
            ene.BsG = cVar.start;
            ene.BsF = emojiInfo.field_size;
            ene.Nld = z;
            ene.Lsm = str;
            ene.Nlf = str2;
            ene.Lso = emojiInfo.field_lensId;
            ene.Lsn = emojiInfo.field_attachTextColor;
            if (list != null) {
                ene.Nle.addAll(list);
            }
            ajb.xIY = z ? 1 : 0;
            ajb.LsE.add(ene);
            ajb.LsG = z2;
            ene.Nlc = new com.tencent.mm.bw.b(a(emojiInfo, cVar.start, cVar.djh));
            d.a aVar = new d.a();
            aVar.iLN = ajb;
            aVar.iLO = new ajc();
            aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
            aVar.funcId = 703;
            c(aVar.aXF());
            AppMethodBeat.o(104454);
        }

        private byte[] a(EmojiInfo emojiInfo, int i2, int i3) {
            byte[] nl;
            AppMethodBeat.i(104455);
            if ((emojiInfo.field_reserved4 & EmojiInfo.Vll) == EmojiInfo.Vll) {
                byte[] a2 = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a(emojiInfo);
                if (!Util.isNullOrNil(a2)) {
                    nl = new byte[i3];
                    Log.d("CgiEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(a2.length), Integer.valueOf(i3));
                    System.arraycopy(a2, i2, nl, 0, i3);
                } else {
                    Log.w("CgiEmojiUpload", "buffer is null.");
                    nl = new byte[0];
                }
            } else {
                synchronized (l.this.gWm) {
                    try {
                        emojiInfo.field_start = i2;
                        nl = emojiInfo.nl(i2, i3);
                        emojiInfo.field_start = 0;
                    } catch (Throwable th) {
                        AppMethodBeat.o(104455);
                        throw th;
                    }
                }
            }
            if (nl == null) {
                nl = new byte[0];
            }
            AppMethodBeat.o(104455);
            return nl;
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        public boolean completed;
        public int djh;
        public int index;
        public int retryCount;
        public boolean running;
        public int start;

        private c() {
        }

        /* synthetic */ c(l lVar, byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(l lVar, String str) {
        AppMethodBeat.i(104461);
        Log.d("MicroMsg.EmojiUploadHelper", "save emoji gif md5, wxam %b, md5 %s, %s", Boolean.valueOf(lVar.gWm.hYo()), str, lVar.gWm.field_wxamMd5);
        if (!lVar.gWm.hYo() || Util.isNullOrNil(str)) {
            lVar.gWm.a(EmojiInfo.a.STATUS_SUCCESS);
            ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(lVar.gWm);
            AppMethodBeat.o(104461);
            return;
        }
        String str2 = lVar.gWm.field_md5;
        String hYx = lVar.gWm.hYx();
        String hYy = lVar.gWm.hYy();
        s.nw(hYx, EmojiInfo.hYz() + str);
        lVar.gWm.field_md5 = str;
        lVar.gWm.field_externMd5 = lVar.gWm.field_wxamMd5;
        lVar.gWm.a(EmojiInfo.a.STATUS_SUCCESS);
        s.nw(hYy, lVar.gWm.hYy());
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.dj(str2, false);
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.J(lVar.gWm);
        AppMethodBeat.o(104461);
    }
}
