package com.tencent.mm.audio.mix.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements f {
    private String appId;
    private String filePath;

    public a(String str, String str2) {
        this.appId = str;
        this.filePath = str2;
    }

    @Override // com.tencent.mm.audio.mix.b.a.f
    public final void YC() {
        AppMethodBeat.i(136749);
        b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", this.appId);
        if (TextUtils.isEmpty(this.filePath)) {
            b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
            ArrayList<String> YN = f.YL().YN();
            if (YN.size() > 0) {
                String str = "";
                Iterator<String> it = YN.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    d gE = f.YL().gE(next);
                    if (gE == null || !gE.aBQ || !gE.dtV) {
                        int gF = f.YL().gF(next);
                        if (gF < i2) {
                            next = str;
                            gF = i2;
                        }
                        str = next;
                        i2 = gF;
                    }
                }
                d gE2 = f.YL().gE(str);
                if (gE2 != null && gE2.aBQ && !gE2.dtV) {
                    gE2.gA(this.appId);
                }
                b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", str, Integer.valueOf(i2));
            }
            AppMethodBeat.o(136749);
            return;
        }
        b.i("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", this.filePath, Integer.valueOf(f.YL().gF(this.filePath)));
        d gE3 = f.YL().gE(this.filePath);
        if (gE3 != null && gE3.aBQ && !gE3.dtV) {
            gE3.gA(this.appId);
        }
        AppMethodBeat.o(136749);
    }

    @Override // com.tencent.mm.audio.mix.b.a.f
    public final void end() {
    }
}
