package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class b {
    private static long INf = 2592000;
    private static b INg;
    private c INh;
    private Map<String, Long> INi = new HashMap();
    private long INj = 0;

    public b() {
        AppMethodBeat.i(77829);
        AppMethodBeat.o(77829);
    }

    public static b gam() {
        AppMethodBeat.i(77830);
        if (INg == null) {
            INg = new b();
        }
        b bVar = INg;
        AppMethodBeat.o(77830);
        return bVar;
    }

    public final c gan() {
        AppMethodBeat.i(77831);
        if (this.INh == null) {
            g.aAi();
            this.INh = new c(g.aAh().hqK);
        }
        c cVar = this.INh;
        AppMethodBeat.o(77831);
        return cVar;
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.i(77832);
        boolean a2 = a(str, str2, str3, str4, str5, z, lM(str2, str3), "");
        AppMethodBeat.o(77832);
        return a2;
    }

    public static boolean lL(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(77833);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(77833);
        } else {
            Log.d("MicroMsg.WebViewDataCenter", "PageCache cache_size:%d, cache_content:%s", Integer.valueOf(str2.getBytes().length), str2);
            String str3 = c.gao() + str;
            o oVar = new o(c.gao());
            if (!oVar.exists() || !oVar.isDirectory()) {
                oVar.mkdirs();
            }
            OutputStream outputStream = null;
            try {
                byte[] bytes = str2.getBytes();
                outputStream = s.dw(str3, false);
                outputStream.write(bytes);
                z = true;
            } catch (IOException e2) {
                Log.e("MicroMsg.WebViewDataCenter", "savePageCache: " + e2.getMessage());
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(77833);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A[SYNTHETIC, Splitter:B:14:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String aXS(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.b.b.aXS(java.lang.String):java.lang.String");
    }

    public final boolean a(final String str, final String str2, final String str3, final String str4, final String str5, boolean z, long j2, final String str6) {
        AppMethodBeat.i(77835);
        long lO = gan().lO(str, str2);
        long j3 = j2 - lO;
        final long aXU = aXU(str) + j3;
        final long bx = bx(str, aXU);
        Log.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", Long.valueOf(lO), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(aXU), Long.valueOf(bx));
        if (bx <= 0 || z) {
            a.aj(new Runnable() {
                /* class com.tencent.mm.plugin.webview.b.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(77828);
                    if (bx > 0) {
                        b.this.INi.put(str, Long.valueOf(aXU - b.this.gan().bz(str, bx)));
                    } else {
                        b.this.INi.put(str, Long.valueOf(aXU));
                    }
                    if (Util.isNullOrNil(str3)) {
                        b.this.gan().a(str, str2, "", Util.nullAs(str4, "1"), b.aXV(str5), str6);
                    } else {
                        b.this.gan().a(str, str2, str3, Util.nullAs(str4, "1"), b.aXV(str5), "");
                    }
                    b.this.gan().by(str, b.this.INi.get(str) == null ? 0 : ((Long) b.this.INi.get(str)).longValue());
                    b.b(b.this);
                    AppMethodBeat.o(77828);
                }
            });
            AppMethodBeat.o(77835);
            return true;
        }
        AppMethodBeat.o(77835);
        return false;
    }

    public static long lM(String str, String str2) {
        AppMethodBeat.i(77836);
        long length = (long) (str.getBytes().length + str2.getBytes().length);
        AppMethodBeat.o(77836);
        return length;
    }

    public final a lN(String str, String str2) {
        AppMethodBeat.i(77837);
        a lN = gan().lN(str, str2);
        AppMethodBeat.o(77837);
        return lN;
    }

    public final void b(String str, JSONArray jSONArray) {
        AppMethodBeat.i(77838);
        gan().b(str, jSONArray);
        AppMethodBeat.o(77838);
    }

    public final void aXT(String str) {
        AppMethodBeat.i(77839);
        gan().aXT(str);
        AppMethodBeat.o(77839);
    }

    private long aXU(String str) {
        AppMethodBeat.i(77840);
        if (this.INi.containsKey(str)) {
            long longValue = this.INi.get(str).longValue();
            AppMethodBeat.o(77840);
            return longValue;
        }
        long aXU = gan().aXU(str);
        AppMethodBeat.o(77840);
        return aXU;
    }

    private static long bx(String str, long j2) {
        AppMethodBeat.i(77841);
        if (str.equals("wx62d9035fd4fd2059")) {
            long j3 = j2 - DownloadHelper.SAVE_LENGTH;
            AppMethodBeat.o(77841);
            return j3;
        }
        long j4 = j2 - 10485760;
        AppMethodBeat.o(77841);
        return j4;
    }

    static /* synthetic */ long aXV(String str) {
        AppMethodBeat.i(77842);
        long j2 = Util.getLong(str, 604800);
        if (j2 > INf) {
            long j3 = INf;
            AppMethodBeat.o(77842);
            return j3;
        }
        AppMethodBeat.o(77842);
        return j2;
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(77843);
        c gan = bVar.gan();
        Cursor rawQuery = gan.rawQuery(String.format("select * from %s where %s<%s", "WebViewData", "expireTime", Long.valueOf(System.currentTimeMillis() / 1000)), new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    if (!Util.isNullOrNil(aVar.field_localFile)) {
                        Log.i("MicroMsg.WebViewDataStorage", "clearExpireTimeData(), delete data file:%s, ret:%b", aVar.field_localFile, Boolean.valueOf(new o(c.gao() + aVar.field_localFile).delete()));
                    }
                    Log.i("MicroMsg.WebViewDataStorage", "clearExpireTimeData(), delete data appIdKey:%s, ret:%b", aVar.field_appIdKey, Boolean.valueOf(gan.delete(aVar, new String[0])));
                    String str = aVar.field_appId;
                    long aXU = gan.aXU(str) - aVar.field_size;
                    Log.i("MicroMsg.WebViewDataStorage", "clearExpireTimeData(), currSize:%d", Long.valueOf(aXU));
                    if (aXU < 0) {
                        aXU = 0;
                    }
                    gan.by(str, aXU);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.o(77843);
    }
}
