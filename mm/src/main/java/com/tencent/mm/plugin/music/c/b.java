package com.tencent.mm.plugin.music.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class b implements Runnable {
    private String AiY = null;
    public f AiZ;
    public a Aja;
    public float Ajb;
    private long Ajc = 307200;
    public int Ajd = -1;
    public AbstractC1532b Aje;
    public int dvm = 0;
    public boolean isStop = true;
    public String mimeType = "";
    public boolean tcf;

    /* renamed from: com.tencent.mm.plugin.music.c.b$b  reason: collision with other inner class name */
    public interface AbstractC1532b {
        void SK(int i2);
    }

    public b(f fVar, a aVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(137216);
        this.AiZ = fVar;
        this.Aja = aVar;
        boolean z3 = aVar.AiT == 0 && aVar.AiU == 0 && aVar.endFlag == 0;
        if (aVar.AiV == 0 && aVar.AiX == 0 && aVar.AiW == 0) {
            z = true;
        } else {
            z = false;
        }
        if ((!z3 || !z) ? false : z2) {
            Log.e("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
        } else {
            Log.i("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
        }
        this.tcf = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        AppMethodBeat.o(137216);
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x0747  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0772 A[SYNTHETIC, Splitter:B:198:0x0772] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0777 A[SYNTHETIC, Splitter:B:201:0x0777] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x077c A[SYNTHETIC, Splitter:B:204:0x077c] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x08f7  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0922 A[SYNTHETIC, Splitter:B:270:0x0922] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0927 A[SYNTHETIC, Splitter:B:273:0x0927] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x092c A[SYNTHETIC, Splitter:B:276:0x092c] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0aad  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0ad8  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0b85  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0c1d  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x0c48 A[SYNTHETIC, Splitter:B:378:0x0c48] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0c4d A[SYNTHETIC, Splitter:B:381:0x0c4d] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0c52 A[SYNTHETIC, Splitter:B:384:0x0c52] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0c86  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0cb0  */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0d48  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0d73 A[SYNTHETIC, Splitter:B:422:0x0d73] */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0d78 A[SYNTHETIC, Splitter:B:425:0x0d78] */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0d7d A[SYNTHETIC, Splitter:B:428:0x0d7d] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0db1  */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x0ddb  */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x0e73  */
    /* JADX WARNING: Removed duplicated region for block: B:466:0x0e9e A[SYNTHETIC, Splitter:B:466:0x0e9e] */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0ea3 A[SYNTHETIC, Splitter:B:469:0x0ea3] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0ea8 A[SYNTHETIC, Splitter:B:472:0x0ea8] */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x0edc  */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x0f06  */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x0f7b  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0fa6 A[SYNTHETIC, Splitter:B:510:0x0fa6] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0fab A[SYNTHETIC, Splitter:B:513:0x0fab] */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0fb0 A[SYNTHETIC, Splitter:B:516:0x0fb0] */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x0fe3  */
    /* JADX WARNING: Removed duplicated region for block: B:530:0x100d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 4258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.c.b.run():void");
    }

    private HttpURLConnection I(String str, Map<String, String> map) {
        int i2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        AppMethodBeat.i(137219);
        if (!TextUtils.isEmpty(this.AiY)) {
            Log.i("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
            str = this.AiY;
            httpURLConnection = null;
            i2 = 0;
        } else {
            httpURLConnection = null;
            i2 = 0;
        }
        while (true) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e2) {
                    Log.e("MicroMsg.Music.MusicDownloadTask", e2.getMessage());
                }
                httpURLConnection.disconnect();
            }
            Log.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", str);
            com.tencent.mm.plugin.music.e.a aVar = k.euj().AjC;
            URL url = new URL(str);
            if (aVar != null) {
                url = aVar.aHK(str);
            }
            httpURLConnection2 = (HttpURLConnection) url.openConnection();
            httpURLConnection2.setRequestMethod("GET");
            httpURLConnection2.setConnectTimeout(25000);
            httpURLConnection2.setInstanceFollowRedirects(false);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
            }
            int responseCode = httpURLConnection2.getResponseCode();
            Log.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", Integer.valueOf(responseCode), Integer.valueOf(i2));
            if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                SI(responseCode);
                String requestMethod = httpURLConnection2.getRequestMethod();
                if (!(responseCode != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD"))) {
                    AppMethodBeat.o(137219);
                    break;
                }
                String headerField = httpURLConnection2.getHeaderField("Location");
                if (headerField == null) {
                    Log.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", Integer.valueOf(responseCode));
                    AppMethodBeat.o(137219);
                    break;
                }
                URL url2 = new URL(httpURLConnection2.getURL(), headerField);
                Log.i("MicroMsg.Music.MusicDownloadTask", "location:%s", headerField);
                Log.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", url2.toString());
                if (!(url2.getProtocol().equals("https") || url2.getProtocol().equals("http"))) {
                    Log.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", Integer.valueOf(responseCode));
                    AppMethodBeat.o(137219);
                    break;
                }
                int i3 = i2 + 1;
                if (i3 > 5) {
                    Log.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: ".concat(String.valueOf(i3)));
                    AppMethodBeat.o(137219);
                    break;
                }
                str = url2.toString();
                this.AiY = str;
                httpURLConnection = httpURLConnection2;
                i2 = i3;
            } else {
                if (!(responseCode == 200 || responseCode == 206)) {
                    this.AiY = null;
                }
                AppMethodBeat.o(137219);
            }
        }
        return httpURLConnection2;
    }

    private static void SI(int i2) {
        AppMethodBeat.i(137220);
        d dVar = (d) com.tencent.mm.plugin.music.f.c.b.aS(d.class);
        if (dVar != null) {
            dVar.SN(i2);
        }
        AppMethodBeat.o(137220);
    }

    private void SJ(int i2) {
        AppMethodBeat.i(137221);
        this.AiY = null;
        MMHandlerThread.postToMainThread(new a(i2));
        AppMethodBeat.o(137221);
    }

    private void Ho(long j2) {
        AppMethodBeat.i(137222);
        if (this.tcf) {
            this.Aja.AiV = j2;
            this.Aja.AiW = 1;
            this.Aja.AiX = j2;
            e.a(this.AiZ.jeV, this.Aja);
        } else {
            this.Aja.AiT = j2;
            this.Aja.endFlag = 1;
            this.Aja.AiU = j2;
            e.a(this.AiZ.jeV, this.Aja);
        }
        MMHandlerThread.postToMainThread(new a(2));
        AppMethodBeat.o(137222);
    }

    private void ac(long j2, long j3) {
        AppMethodBeat.i(137223);
        if (this.tcf) {
            this.Aja.AiV = j2;
            this.Aja.AiW = 0;
            this.Aja.AiX = j3;
            e.a(this.AiZ.jeV, this.Aja);
        } else {
            this.Aja.AiT = j2;
            this.Aja.endFlag = 0;
            this.Aja.AiU = j3;
            e.a(this.AiZ.jeV, this.Aja);
        }
        MMHandlerThread.postToMainThread(new a(3));
        AppMethodBeat.o(137223);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        int action;

        public final void run() {
            AppMethodBeat.i(137215);
            if (b.this.Aje != null) {
                b.this.Aje.SK(this.action);
            }
            AppMethodBeat.o(137215);
        }

        a(int i2) {
            this.action = i2;
        }
    }

    private static long[] aHJ(String str) {
        AppMethodBeat.i(137224);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(137224);
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            String[] split2 = split[1].split(FilePathGenerator.ANDROID_DIR_SEP);
            long[] jArr = {longValue, Long.valueOf(split2[0]).longValue(), Long.valueOf(split2[1]).longValue()};
            AppMethodBeat.o(137224);
            return jArr;
        } catch (Exception e2) {
            AppMethodBeat.o(137224);
            return null;
        }
    }

    public final void start() {
        AppMethodBeat.i(137217);
        if (!this.isStop) {
            AppMethodBeat.o(137217);
            return;
        }
        this.isStop = false;
        ThreadPool.post(this, "music_download_thread");
        AppMethodBeat.o(137217);
    }
}
