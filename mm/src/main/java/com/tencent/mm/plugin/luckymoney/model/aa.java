package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;

public final class aa implements g.a {
    String rCh = null;
    boolean yWA = true;
    a yWy;
    String yWz;

    public interface a {
        void bN(String str, boolean z);
    }

    @Override // com.tencent.mm.i.g.a
    public final int a(String str, int i2, c cVar, d dVar, boolean z) {
        AppMethodBeat.i(65240);
        Log.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
        if (dVar != null && this.rCh.equals(str) && !Util.isNullOrNil(dVar.field_fileId)) {
            Log.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + dVar.field_retCode);
            if (i2 == 0 && dVar.field_retCode == 0) {
                if (this.yWA) {
                    Log.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    Log.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                Log.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", str, dVar.toString());
                if (this.yWy != null) {
                    this.yWy.bN(this.yWz, true);
                }
            } else {
                Log.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.yWy != null) {
                    this.yWy.bN(this.yWz, false);
                }
            }
        } else if (dVar != null && this.rCh.equals(str) && dVar.field_retCode != 0) {
            Log.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + dVar.field_retCode);
            if (this.yWy != null) {
                this.yWy.bN(this.yWz, false);
            }
        } else if (cVar != null) {
            Log.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        AppMethodBeat.o(65240);
        return 0;
    }

    @Override // com.tencent.mm.i.g.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    @Override // com.tencent.mm.i.g.a
    public final byte[] f(String str, byte[] bArr) {
        return null;
    }
}
