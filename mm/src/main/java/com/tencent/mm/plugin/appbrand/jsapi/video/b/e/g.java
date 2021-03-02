package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g implements i<String> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i
    public final /* synthetic */ boolean aj(String str) {
        List<String> arrayList;
        AppMethodBeat.i(234850);
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            String lowerCase = str2.toLowerCase();
            if (lowerCase.startsWith("video")) {
                AppMethodBeat.o(234850);
                return true;
            } else if (lowerCase.startsWith(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                AppMethodBeat.o(234850);
                return true;
            } else {
                a bJK = a.bJK();
                if (bJK.mxk != null) {
                    arrayList = bJK.mxk;
                } else {
                    arrayList = new ArrayList(Arrays.asList(c.mzG, c.mzH, c.mzI, c.mzK, c.mzL, c.mzJ, c.mzM, c.mzN, c.mzO, c.mzP));
                }
                for (String str3 : arrayList) {
                    if (!TextUtils.isEmpty(str3) && lowerCase.startsWith(str3.toLowerCase())) {
                        AppMethodBeat.o(234850);
                        return true;
                    }
                }
            }
        } else {
            h.log(5, "PassOnVideoType", "contentType is null");
        }
        AppMethodBeat.o(234850);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i
    public final boolean aM(byte[] bArr) {
        AppMethodBeat.i(234849);
        if (!h.aN(bArr)) {
            AppMethodBeat.o(234849);
            return true;
        }
        AppMethodBeat.o(234849);
        return false;
    }
}
