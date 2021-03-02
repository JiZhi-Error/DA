package com.tencent.liteav;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private String f810a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f811b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f812c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f813d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f814e = "";

    /* renamed from: f  reason: collision with root package name */
    private long f815f = 0;

    public interface a {
        void a(long j2);
    }

    static /* synthetic */ String d(j jVar, String str) {
        AppMethodBeat.i(221434);
        String a2 = jVar.a(str);
        AppMethodBeat.o(221434);
        return a2;
    }

    public long a() {
        AppMethodBeat.i(221430);
        long currentTimeMillis = System.currentTimeMillis() - this.f815f;
        AppMethodBeat.o(221430);
        return currentTimeMillis;
    }

    public String a(long j2) {
        String format;
        AppMethodBeat.i(221431);
        String format2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.f815f + (1000 * j2)));
        if (this.f812c < 0) {
            format = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=%d", this.f810a, this.f814e, this.f811b, Long.valueOf(((System.currentTimeMillis() - this.f815f) - j2) / 1000));
        } else {
            format = String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", this.f810a, Integer.valueOf(this.f812c), this.f811b, format2, this.f813d);
        }
        AppMethodBeat.o(221431);
        return format;
    }

    public int a(final String str, final String str2, final int i2, final a aVar) {
        AppMethodBeat.i(221432);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(221432);
            return -1;
        }
        this.f813d = TXCCommonUtil.getAppID();
        if (TextUtils.isEmpty(this.f813d)) {
            AppMethodBeat.o(221432);
            return -2;
        }
        AsyncTask.execute(new Runnable() {
            /* class com.tencent.liteav.j.AnonymousClass1 */

            public void run() {
                String format;
                AppMethodBeat.i(221786);
                j.this.f815f = System.currentTimeMillis();
                j.this.f811b = "";
                j.this.f812c = i2;
                j.this.f810a = str2;
                j.this.f811b = TXCCommonUtil.getStreamIDByStreamUrl(str);
                j.this.f814e = TXCCommonUtil.getAppNameByStreamUrl(str);
                if (j.this.f814e == null) {
                    j.this.f814e = WeChatBrands.Business.GROUP_LIVE;
                }
                if (j.this.f812c < 0) {
                    format = String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=0", j.this.f810a, j.this.f814e, j.this.f811b);
                } else {
                    format = String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", j.this.f810a, Integer.valueOf(j.this.f812c), j.this.f811b, j.this.f813d);
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(format).openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Charsert", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    httpURLConnection.setRequestProperty("Content-Type", "text/plain;");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String str = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + readLine;
                    }
                    TXCLog.i("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = ".concat(String.valueOf(str)));
                    String d2 = j.d(j.this, str);
                    if (d2 != null) {
                        j.this.f815f = Long.parseLong(d2) * 1000;
                    }
                } catch (Exception e2) {
                    j.this.f815f = System.currentTimeMillis();
                    TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime error " + e2.toString());
                }
                long currentTimeMillis = System.currentTimeMillis();
                TXCLog.i("TXCTimeShiftUtil", "live start time:" + j.this.f815f + ",currentTime:" + currentTimeMillis + ",diff:" + (currentTimeMillis - j.this.f815f));
                final long j2 = currentTimeMillis - j.this.f815f;
                if (aVar != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.liteav.j.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(221600);
                            aVar.a(j2);
                            AppMethodBeat.o(221600);
                        }
                    });
                }
                AppMethodBeat.o(221786);
            }
        });
        AppMethodBeat.o(221432);
        return 0;
    }

    private String a(String str) {
        int indexOf;
        String substring;
        int indexOf2;
        AppMethodBeat.i(221433);
        if (!str.contains("#EXT-TX-TS-START-TIME") || (indexOf = str.indexOf("#EXT-TX-TS-START-TIME:") + 22) <= 0 || (indexOf2 = (substring = str.substring(indexOf)).indexOf("#")) <= 0) {
            AppMethodBeat.o(221433);
            return null;
        }
        String replaceAll = substring.substring(0, indexOf2).replaceAll(APLogFileUtil.SEPARATOR_LINE, "");
        AppMethodBeat.o(221433);
        return replaceAll;
    }
}
