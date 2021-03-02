package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public final class am {
    public static crh IEW;

    public static crh fYi() {
        AppMethodBeat.i(117730);
        if (IEW == null) {
            String bKh = bKh();
            IEW = new crh();
            try {
                String string = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(bKh, "");
                if (!Util.isNullOrNil(string)) {
                    IEW.parseFrom(Base64.decode(string.getBytes(), 0));
                }
            } catch (Exception e2) {
            }
        }
        if (b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            IEW.oTA.clear();
        }
        crh crh = IEW;
        AppMethodBeat.o(117730);
        return crh;
    }

    public static String bKh() {
        AppMethodBeat.i(117731);
        String str = "key_pb_most_search_biz_list" + z.aTY();
        AppMethodBeat.o(117731);
        return str;
    }

    public static void aXh(String str) {
        AppMethodBeat.i(117732);
        if (b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            AppMethodBeat.o(117732);
        } else if (!ab.IT(str)) {
            AppMethodBeat.o(117732);
        } else {
            if (IEW == null) {
                fYi();
            }
            long currentTimeMillis = System.currentTimeMillis();
            crg crg = null;
            int i2 = 0;
            while (i2 < IEW.oTA.size()) {
                crg crg2 = IEW.oTA.get(i2);
                long j2 = (currentTimeMillis - crg2.Mwx) / Util.MILLSECONDS_OF_DAY;
                crg2.Mww *= Math.pow(0.98d, (double) j2);
                crg2.Mwx = (j2 * Util.MILLSECONDS_OF_DAY) + crg2.Mwx;
                Log.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", Double.valueOf(crg2.Mww), Long.valueOf(crg2.Mwx), crg2.Username);
                if (!crg2.Username.equals(str)) {
                    crg2 = crg;
                }
                i2++;
                crg = crg2;
            }
            if (crg == null) {
                crg crg3 = new crg();
                crg3.Mww = 1.0d;
                crg3.Mwx = currentTimeMillis;
                crg3.Username = str;
                IEW.oTA.add(crg3);
                Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", str);
            } else {
                crg.Mww += 1.0d;
                Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", str, Double.valueOf(crg.Mww));
            }
            Collections.sort(IEW.oTA, new Comparator<crg>() {
                /* class com.tencent.mm.plugin.websearch.api.am.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(crg crg, crg crg2) {
                    crg crg3 = crg;
                    crg crg4 = crg2;
                    if (crg3.Mww > crg4.Mww) {
                        return 1;
                    }
                    if (crg3.Mww < crg4.Mww) {
                        return -1;
                    }
                    return 0;
                }
            });
            for (int size = IEW.oTA.size() - 1; size < IEW.oTA.size() && IEW.oTA.size() > 8; size++) {
                if (IEW.oTA.get(size).Mww < 0.5d) {
                    IEW.oTA.remove(size);
                }
            }
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                String bKh = bKh();
                String encodeToString = Base64.encodeToString(IEW.toByteArray(), 0);
                sharedPreferences.edit().putString(bKh, encodeToString).commit();
                Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", encodeToString);
                AppMethodBeat.o(117732);
            } catch (IOException e2) {
                AppMethodBeat.o(117732);
            }
        }
    }
}
