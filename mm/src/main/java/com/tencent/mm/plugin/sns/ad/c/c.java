package com.tencent.mm.plugin.sns.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static boolean a(Context context, String str, String str2, SnsInfo snsInfo) {
        af afVar;
        AppMethodBeat.i(201872);
        try {
            Log.d("SnsAd.FinderTopicRequest", " encryptedTopicId is " + str + ", topicName is " + str2);
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                Log.w("SnsAd.FinderTopicRequest", "the encryptedTopicId or topicName is empty or context is null");
                AppMethodBeat.o(201872);
                return false;
            }
            aj ajVar = (aj) g.ah(aj.class);
            if (ajVar != null) {
                afVar = ajVar.getFinderUtilApi();
            } else {
                afVar = null;
            }
            if (afVar != null) {
                if (snsInfo != null) {
                    h.aB(snsInfo.getUxinfo(), r.v(snsInfo), 0);
                }
                afVar.B(context, str, str2);
                AppMethodBeat.o(201872);
                return true;
            }
            Log.w("SnsAd.FinderTopicRequest", "the IFinderUtilApi object is null!!");
            AppMethodBeat.o(201872);
            return false;
        } catch (Throwable th) {
            Log.e("SnsAd.FinderTopicRequest", "the enterTopicProfileUI has something wrong!!!");
        }
    }
}
