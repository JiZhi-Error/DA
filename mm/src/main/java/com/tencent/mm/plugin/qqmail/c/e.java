package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;

public class e implements b<IPCVoid, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCVoid iPCVoid, d<Bundle> dVar) {
        String str;
        String str2;
        boolean z = true;
        AppMethodBeat.i(198582);
        String mailAppEnterUlAndroid = h.aqK().getMailAppEnterUlAndroid();
        String aqC = h.aqK().aqC();
        if (ChannelUtil.channelId == 1) {
            z = false;
        } else if (h.aqK().aqB() != 1) {
            z = false;
        }
        Bundle bundle = new Bundle();
        if (!Util.isNullOrNil(mailAppEnterUlAndroid)) {
            str = mailAppEnterUlAndroid.replace("http:", "https:");
        } else {
            str = mailAppEnterUlAndroid;
        }
        if (!Util.isNullOrNil(aqC)) {
            str2 = aqC.replace("http:", "https:");
        } else {
            str2 = aqC;
        }
        bundle.putString("mail_app_enter_url", str);
        bundle.putString("mail_app_download_url", str2);
        bundle.putBoolean("mail_app_show_recommend", z);
        dVar.bn(bundle);
        AppMethodBeat.o(198582);
    }
}
