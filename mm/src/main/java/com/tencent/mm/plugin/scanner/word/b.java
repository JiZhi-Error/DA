package com.tencent.mm.plugin.scanner.word;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.worddetect.WordDetectNative;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private WordDetectNative.WordDetectDetailResult CVE;
    public List<Float> CVF = new ArrayList();

    public b(WordDetectNative.WordDetectDetailResult wordDetectDetailResult) {
        AppMethodBeat.i(194820);
        this.CVE = wordDetectDetailResult;
        if (!(wordDetectDetailResult == null || wordDetectDetailResult.rate_lang == null)) {
            for (int i2 = 0; i2 < wordDetectDetailResult.rate_lang.length; i2++) {
                Log.i("MicroMsg.WordDetectDetailResultWrapper", "%d ratio %f", Integer.valueOf(i2), Float.valueOf(wordDetectDetailResult.rate_lang[i2]));
                this.CVF.add(Float.valueOf(wordDetectDetailResult.rate_lang[i2]));
            }
        }
        AppMethodBeat.o(194820);
    }
}
