package com.tencent.mm.emoji.d;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.g;
import com.tencent.mm.protocal.protobuf.enh;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class f extends d {
    int gVY = 0;
    private String hdI;
    long startTime = 0;

    public f(EmojiInfo emojiInfo, boolean z, d.a aVar) {
        super(emojiInfo, z, aVar);
        AppMethodBeat.i(104493);
        Log.i("MicroMsg.EmojiUploadCDN", "prepare: %s", this.gWm.field_md5);
        new com.tencent.mm.emoji.b.f(this.gWm, this.gXv).aYI().g(new a<Void, c.a<enh>>() {
            /* class com.tencent.mm.emoji.d.f.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<enh> aVar) {
                String str;
                AppMethodBeat.i(104491);
                c.a<enh> aVar2 = aVar;
                int i2 = aVar2.errType;
                int i3 = aVar2.errCode;
                Log.i("MicroMsg.EmojiUploadCDN", "prepare callback: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 0 && i3 == 0) {
                    if (aVar2.iLC == null || ((enh) aVar2.iLC).Nlj == null) {
                        str = "";
                    } else {
                        str = ((enh) aVar2.iLC).Nlj.yO();
                    }
                    f.a(f.this, str);
                } else {
                    f.this.aws();
                }
                Void r0 = QZL;
                AppMethodBeat.o(104491);
                return r0;
            }
        });
        AppMethodBeat.o(104493);
    }

    static /* synthetic */ void a(f fVar, String str) {
        String str2;
        AppMethodBeat.i(104494);
        Log.i("MicroMsg.EmojiUploadCDN", "upload: %s, %s", fVar.gWm.field_md5, str);
        fVar.startTime = Util.nowMilliSecond();
        fVar.gVY = fVar.hdB ? CdnLogic.kMediaTypeEmojiWXAM : CdnLogic.kMediaTypeEmojiNormal;
        g gVar = new g();
        gVar.taskName = "task_EmojiUploadCDN";
        gVar.field_mediaId = "emoji_upload_" + fVar.gWm.field_md5 + System.currentTimeMillis();
        gVar.field_appType = 110;
        gVar.field_fileType = fVar.gVY;
        gVar.emojiExtinfo = str;
        String hYx = fVar.gWm.hYx();
        if (ImgUtil.isImgFile(hYx) || ImgUtil.isWXGF(hYx)) {
            str2 = hYx;
        } else {
            byte[] a2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a(fVar.gWm);
            fVar.hdI = hYx + "_temp";
            s.f(fVar.hdI, a2, a2.length);
            str2 = fVar.hdI;
        }
        gVar.field_fullpath = str2;
        gVar.field_bzScene = 1;
        gVar.gqy = new g.a() {
            /* class com.tencent.mm.emoji.d.f.AnonymousClass2 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(104492);
                Log.i("MicroMsg.EmojiUploadCDN", "cdn callback: %s, %s", str, Integer.valueOf(i2));
                if (i2 != 0) {
                    f.a(f.this);
                    f.this.pt(11);
                    AppMethodBeat.o(104492);
                    return 0;
                }
                if (cVar != null) {
                    Log.i("MicroMsg.EmojiUploadCDN", "cdn callback progress: %s, %s, %s", Integer.valueOf(cVar.field_status), Long.valueOf(cVar.field_finishedLength), Long.valueOf(cVar.field_toltalLength));
                }
                if (dVar != null) {
                    Log.i("MicroMsg.EmojiUploadCDN", "cdn callback result: %s, %s", Integer.valueOf(dVar.field_retCode), dVar.emojiMD5);
                    f.a(f.this);
                    String str2 = dVar.emojiMD5;
                    if (dVar.field_retCode == 0 && !Util.isNullOrNil(str2)) {
                        f.this.EW(str2);
                        long currentTimeMillis = System.currentTimeMillis() - f.this.gXF;
                        Log.i("MicroMsg.EmojiUploadCDN", "complete cost %d, size %d, rate %d", Long.valueOf(currentTimeMillis), Integer.valueOf(f.this.gWm.field_size), Long.valueOf(((long) f.this.gWm.field_size) / currentTimeMillis));
                        f.this.C(0, str2);
                    } else if (dVar.field_retCode <= -20000 || dVar.field_retCode >= 0) {
                        f.this.pt(11);
                    } else if (dVar.field_retCode == -447) {
                        f.this.pt(2);
                    } else if (dVar.field_retCode == -448) {
                        f.this.pt(8);
                    } else {
                        f.this.aws();
                    }
                    new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 1, Long.valueOf(f.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(f.this.gVY), Long.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.gqk)).bfK();
                }
                AppMethodBeat.o(104492);
                return 0;
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        com.tencent.mm.an.f.baQ().f(gVar);
        AppMethodBeat.o(104494);
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(199754);
        if (s.YS(fVar.hdI)) {
            s.deleteFile(fVar.hdI);
        }
        AppMethodBeat.o(199754);
    }
}
