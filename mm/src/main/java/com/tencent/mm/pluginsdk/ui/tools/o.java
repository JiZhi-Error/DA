package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class o {
    private static final String Kwq = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e27) + "/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0");

    public interface a {
        void eGv();

        void onSuccess(int i2);
    }

    static {
        AppMethodBeat.i(198777);
        AppMethodBeat.o(198777);
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(123216);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(123211);
                try {
                    o.b(aVar);
                    AppMethodBeat.o(123211);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e2, "", new Object[0]);
                    Log.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                    AppMethodBeat.o(123211);
                }
            }
        }, "QQMailUnreadHelper");
        AppMethodBeat.o(123216);
    }

    public static void b(final a aVar) {
        final int i2;
        AppMethodBeat.i(123217);
        Log.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
        String str = (String) g.aAh().azQ().get(-1535680990, "");
        long longValue = new p(Util.nullAsNil((Integer) g.aAh().azQ().get(9, (Object) null))).longValue();
        if (Util.isNullOrNil(str) || longValue == 0) {
            g.aAh().azQ().set(ar.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, (Object) -1);
            Log.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.tools.o.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(123212);
                    aVar.eGv();
                    AppMethodBeat.o(123212);
                }
            });
            AppMethodBeat.o(123217);
            return;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Kwq).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", str, Long.valueOf(longValue)));
        if (httpURLConnection.getResponseCode() >= 300) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e2) {
                Log.e("MicroMsg.QQMailUnreadHelper", e2.getMessage());
            }
            httpURLConnection.disconnect();
            Log.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.tools.o.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(123213);
                    aVar.eGv();
                    AppMethodBeat.o(123213);
                }
            });
            AppMethodBeat.o(123217);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(Util.convertStreamToString(httpURLConnection.getInputStream()), "Response", null);
        if (parseXml == null || Util.getInt(parseXml.get(".Response.error.code"), -1) != 0) {
            i2 = -1;
        } else {
            i2 = Util.getInt(parseXml.get(".Response.result.UnreadCount"), -1);
        }
        if (i2 < 0) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.tools.o.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(123214);
                    aVar.eGv();
                    AppMethodBeat.o(123214);
                }
            });
            AppMethodBeat.o(123217);
            return;
        }
        g.aAh().azQ().set(ar.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i2));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.o.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(123215);
                aVar.onSuccess(i2);
                AppMethodBeat.o(123215);
            }
        });
        AppMethodBeat.o(123217);
    }
}
