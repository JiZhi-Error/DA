package com.tencent.mm.plugin.sns.ad.d.a;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    Map<String, a> DsA = new ConcurrentHashMap();
    Map<String, b> Dsz = new ConcurrentHashMap();

    public static class a {
        long DsB;
        String gWK;
    }

    public c() {
        AppMethodBeat.i(201883);
        AppMethodBeat.o(201883);
    }

    public static class b {
        SnsInfo DsC;
        String[] cze;
        String dRS;
        String gWK;
        int source;
        int type = 0;

        public b(SnsInfo snsInfo, int i2) {
            AppMethodBeat.i(201880);
            this.DsC = snsInfo;
            this.source = i2;
            this.type = 0;
            this.dRS = snsInfo != null ? snsInfo.getSnsId() : "";
            this.gWK = fq(this.dRS, this.type);
            AppMethodBeat.o(201880);
        }

        public b(String str, String[] strArr) {
            AppMethodBeat.i(201881);
            this.dRS = str;
            this.cze = strArr;
            this.type = 1;
            this.gWK = fq(str, this.type);
            AppMethodBeat.o(201881);
        }

        private static String fq(String str, int i2) {
            AppMethodBeat.i(201882);
            if (str != null) {
                String str2 = str + "_" + i2;
                AppMethodBeat.o(201882);
                return str2;
            }
            String concat = " _".concat(String.valueOf(i2));
            AppMethodBeat.o(201882);
            return concat;
        }
    }

    private boolean a(b bVar) {
        AppMethodBeat.i(201884);
        if (bVar == null || TextUtils.isEmpty(bVar.gWK)) {
            Log.i("SnsAd.H5Prefetch", "the task info is empty!");
            AppMethodBeat.o(201884);
            return false;
        } else if (this.Dsz.containsKey(bVar.gWK)) {
            Log.i("SnsAd.H5Prefetch", "the task key is in pending task, the task key is : " + bVar.gWK);
            AppMethodBeat.o(201884);
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = this.DsA.get(bVar.gWK);
            if (aVar == null || currentTimeMillis >= aVar.DsB + 600000) {
                int i2 = bVar.type;
                if (i2 == 0) {
                    if (bVar == null) {
                        AppMethodBeat.o(201884);
                        return false;
                    }
                    SnsInfo snsInfo = bVar.DsC;
                    if (snsInfo == null || !snsInfo.isAd()) {
                        Log.i("SnsAd.H5Prefetch", "the sns info is not ad!");
                        AppMethodBeat.o(201884);
                        return false;
                    }
                    AppMethodBeat.o(201884);
                    return true;
                } else if (i2 != 1) {
                    AppMethodBeat.o(201884);
                    return false;
                } else if (bVar == null) {
                    AppMethodBeat.o(201884);
                    return false;
                } else if (com.tencent.mm.plugin.sns.ad.i.c.w(bVar.cze)) {
                    Log.i("SnsAd.H5Prefetch", "the urls is empty!");
                    AppMethodBeat.o(201884);
                    return false;
                } else {
                    AppMethodBeat.o(201884);
                    return true;
                }
            } else {
                Log.i("SnsAd.H5Prefetch", "the task key has been prefetch, the task key is : " + bVar.gWK);
                AppMethodBeat.o(201884);
                return false;
            }
        }
    }

    public final b b(b bVar) {
        AppMethodBeat.i(201885);
        if (TextUtils.isEmpty(bVar.gWK)) {
            AppMethodBeat.o(201885);
            return null;
        } else if (a(bVar)) {
            Log.i("SnsAd.H5Prefetch", "the task info is to prefetch, the task key  is : " + bVar.gWK);
            this.Dsz.put(bVar.gWK, bVar);
            AppMethodBeat.o(201885);
            return bVar;
        } else {
            AppMethodBeat.o(201885);
            return null;
        }
    }

    public final void c(b bVar) {
        AppMethodBeat.i(201886);
        if (bVar == null || TextUtils.isEmpty(bVar.gWK) || h.RTc == null) {
            Log.d("SnsAd.H5Prefetch", "the task info is null");
            AppMethodBeat.o(201886);
            return;
        }
        h.RTc.aX(new b(this, bVar.gWK));
        AppMethodBeat.o(201886);
    }
}
