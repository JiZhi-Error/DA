package com.tencent.mm.plugin.box;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.box.a.c;
import com.tencent.mm.plugin.box.c.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.UUID;

public final class b implements c {
    @Override // com.tencent.mm.plugin.box.a.c
    public final void b(Context context, String str, long j2) {
        AppMethodBeat.i(76317);
        String fYv = ai.afr(2).fYv();
        Log.i("MicroMsg.Box.BoxUILogic", "startBoxHomeUI type=%d query=%s messageSvrID=%d", 3, str, Long.valueOf(j2));
        qt qtVar = new qt();
        qtVar.KXB = UUID.randomUUID().toString();
        qtVar.KXA = str;
        qtVar.oUv = 3;
        HashMap hashMap = new HashMap();
        hashMap.put(SearchIntents.EXTRA_QUERY, str);
        hashMap.put("type", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("messageSvrID", String.valueOf(j2));
        hashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("version", String.valueOf(ai.aft(2)));
        hashMap.put(DownloadInfo.NETTYPE, ai.ait());
        hashMap.put("isClientLoading", "1");
        hashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(fYv);
        stringBuffer.append("?");
        stringBuffer.append(ai.toUrlParams(hashMap));
        qtVar.Url = stringBuffer.toString();
        a aVar = new a(context, qtVar);
        aVar.show();
        aVar.getWindow().setLayout(-1, -1);
        AppMethodBeat.o(76317);
    }
}
