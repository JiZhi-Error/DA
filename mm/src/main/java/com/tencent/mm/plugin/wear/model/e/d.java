package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.ce.b;
import com.tencent.mm.g.a.aao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.eyj;
import com.tencent.mm.protocal.protobuf.eyk;
import com.tencent.mm.protocal.protobuf.eyl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.aa;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30075);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11001);
        arrayList.add(11004);
        AppMethodBeat.o(30075);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        List<EmojiInfo> amo;
        InputStream inputStream;
        Throwable th;
        IOException e2;
        byte[] bArr2;
        AppMethodBeat.i(30076);
        if (i2 == 11001) {
            eyj eyj = new eyj();
            try {
                eyj.parseFrom(bArr);
            } catch (IOException e3) {
            }
            if (b.gxI().NKB > eyj.LRV) {
                try {
                    inputStream = MMApplicationContext.getContext().getAssets().open("color_emoji");
                    try {
                        bArr2 = e.readFromStream(inputStream);
                        aa.closeQuietly(inputStream);
                    } catch (IOException e4) {
                        e2 = e4;
                        try {
                            Log.printErrStackTrace("MicroMsg.Wear.EmojiServer", e2, "", new Object[0]);
                            aa.closeQuietly(inputStream);
                            bArr2 = null;
                            AppMethodBeat.o(30076);
                            return bArr2;
                        } catch (Throwable th2) {
                            th = th2;
                            aa.closeQuietly(inputStream);
                            AppMethodBeat.o(30076);
                            throw th;
                        }
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    inputStream = null;
                    Log.printErrStackTrace("MicroMsg.Wear.EmojiServer", e2, "", new Object[0]);
                    aa.closeQuietly(inputStream);
                    bArr2 = null;
                    AppMethodBeat.o(30076);
                    return bArr2;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    aa.closeQuietly(inputStream);
                    AppMethodBeat.o(30076);
                    throw th;
                }
                AppMethodBeat.o(30076);
                return bArr2;
            }
        } else if (i2 == 11004) {
            a.aff(9);
            eyk eyk = new eyk();
            try {
                eyk.parseFrom(bArr);
            } catch (IOException e6) {
            }
            eyl eyl = new eyl();
            if (!(((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null || (amo = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amo(eyk.KZu)) == null)) {
                for (EmojiInfo emojiInfo : amo) {
                    if (!Util.isNullOrNil(emojiInfo.getMd5())) {
                        eyl.KMy.add(emojiInfo.getMd5());
                    }
                }
            }
            if (eyl.KMy.size() == 0) {
                aao aao = new aao();
                aao.ehA.ehB = new String[]{eyk.KZu};
                aao.ehA.dDe = 1;
                EventCenter.instance.publish(aao);
            }
            try {
                byte[] byteArray = eyl.toByteArray();
                AppMethodBeat.o(30076);
                return byteArray;
            } catch (IOException e7) {
            }
        }
        AppMethodBeat.o(30076);
        return null;
    }
}
