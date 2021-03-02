package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f {
    private static String JaE = null;
    private static b JaF = null;
    private static String hes = null;

    public static Bundle b(Bundle bundle, String str, String str2) {
        AppMethodBeat.i(79144);
        JaE = null;
        hes = null;
        JaF = null;
        try {
            dyt dyt = new dyt();
            dyt.MYh = bundle.getString("PickedWord");
            dyt.MYi = bundle.getString("PrefixText");
            dyt.MYj = bundle.getString("SuffixText");
            dyt.Scene = bundle.getInt("Scene");
            dyt.MYk = bundle.getInt("MainIndex", -1);
            dyt.Url = str;
            dyt.Title = str2;
            dyt.MYl = bundle.getString("SubPickedWord");
            dyt.MYm = bundle.getString("SubPrefixText");
            dyt.MYn = bundle.getString("SubSuffixText");
            dyt.MYo = bundle.getInt("SubIndex", -1);
            dyt.MYp = bundle.getInt("TagNewLineBefore", -1);
            dyt.MYq = bundle.getInt("TagNewLineAfter", -1);
            dyt.MYr = bundle.getInt("TagNewLineBeforeSub", -1);
            dyt.MYs = bundle.getInt("TagNewLineAfterSub", -1);
            Log.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", dyt.MYi, dyt.MYh, dyt.MYj);
            d.a aVar = new d.a();
            aVar.iLN = dyt;
            aVar.iLO = new dyu();
            aVar.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
            aVar.funcId = 2974;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bundle bundle2 = new Bundle();
            IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.webview.modeltools.f.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(79143);
                    Log.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        dyu dyu = (dyu) dVar.iLL.iLR;
                        bundle2.putString("PickedWord", dyu.MYh);
                        bundle2.putInt("PrefixOffset", dyu.MYt);
                        bundle2.putInt("SuffixOffset", dyu.MYu);
                        bundle2.putString("PrefixText", dyu.MYi);
                        bundle2.putString("SuffixText", dyu.MYj);
                        bundle2.putInt("IsMainOrSub", dyu.MYv);
                        String unused = f.JaE = dyu.MYh;
                        b unused2 = f.JaF = dyu.MYw;
                        String unused3 = f.hes = dyu.Mbb;
                        Log.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", dyu.MYi, dyu.MYh, dyu.MYj, Integer.valueOf(dyu.MYt), Integer.valueOf(dyu.MYu), Integer.valueOf(dyu.MYv));
                        countDownLatch.countDown();
                        AppMethodBeat.o(79143);
                        return;
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.o(79143);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.w("MicroMsg.SmartPickWordHelper", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", e2, "", new Object[0]);
            }
            Log.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
            AppMethodBeat.o(79144);
            return bundle2;
        } catch (Exception e3) {
            Log.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
            AppMethodBeat.o(79144);
            return null;
        }
    }

    public static void aP(Bundle bundle) {
        AppMethodBeat.i(79145);
        if (bundle == null) {
            AppMethodBeat.o(79145);
            return;
        }
        if (hes != null) {
            bundle.putString("searchId", hes);
        }
        if (JaF != null) {
            bundle.putString("extQueryInfo", JaF.yO());
        }
        AppMethodBeat.o(79145);
    }

    public static boolean aQ(Bundle bundle) {
        AppMethodBeat.i(79146);
        String string = bundle.getString(SearchIntents.EXTRA_QUERY);
        String string2 = bundle.getString("searchId");
        String string3 = bundle.getString("extQueryInfo");
        if (Util.isNullOrNil(string)) {
            AppMethodBeat.o(79146);
        } else {
            String valueOf = String.valueOf(e.wVm);
            HashMap hashMap = new HashMap();
            String str = null;
            if (string2 != null) {
                str = "18:" + string2 + ":" + string + ":";
                hashMap.put("parentSearchID", str);
            }
            if (str != null) {
                ad.aVe().G(str, true).l("extQueryInfo", string3);
            }
            hashMap.put("clickType", "18");
            ((h) g.af(h.class)).a(MMApplicationContext.getContext(), 17, string, valueOf, hashMap);
            AppMethodBeat.o(79146);
        }
        return false;
    }

    public static void mc(String str, String str2) {
        int i2 = 1;
        AppMethodBeat.i(79147);
        boolean z = !Util.isNullOrNil(JaE) && !Util.isEqual(str, JaE);
        String str3 = "";
        String str4 = "";
        String str5 = "";
        try {
            str3 = URLEncoder.encode(Util.nullAsNil(str2), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            str4 = URLEncoder.encode(Util.nullAsNil(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            str5 = URLEncoder.encode(Util.nullAsNil(JaE), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", e2, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[6];
        objArr[0] = 2;
        objArr[1] = str3;
        objArr[2] = str5;
        objArr[3] = str4;
        if (!z) {
            i2 = 0;
        }
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = hes;
        hVar.a(13742, objArr);
        AppMethodBeat.o(79147);
    }

    public static void q(String str, Bundle bundle) {
        boolean z;
        int i2;
        int i3 = 1;
        AppMethodBeat.i(79148);
        if (bundle != null) {
            z = bundle.getBoolean("IsCursorMove", false);
        } else {
            z = false;
        }
        String str2 = "";
        try {
            str2 = URLEncoder.encode(Util.nullAsNil(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", e2, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[6];
        if (z) {
            i2 = 3;
        } else {
            i2 = 1;
        }
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = str2;
        objArr[2] = "";
        objArr[3] = "";
        if (!z) {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = hes;
        hVar.a(13742, objArr);
        AppMethodBeat.o(79148);
    }

    public static void aZr(String str) {
        AppMethodBeat.i(79149);
        String str2 = "";
        try {
            str2 = URLEncoder.encode(Util.nullAsNil(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", e2, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13742, 4, str2, "", "", 0, hes);
        AppMethodBeat.o(79149);
    }
}
