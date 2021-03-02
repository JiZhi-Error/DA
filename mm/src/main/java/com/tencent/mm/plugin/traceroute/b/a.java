package com.tencent.mm.plugin.traceroute.b;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    public static String Grg;
    public static c Grh;
    private final int Gri = 64;
    private boolean Grj = false;
    f Grk = new f(this, (byte) 0);
    public Map<String, Set<Integer>> Grl = new HashMap();
    public e Grm;
    public d Grn;
    public c Gro;
    public b Grp;
    private final String TAG = "MicroMsg.MMTraceRoute";
    String userName;

    public interface b {
        void fAd();
    }

    public interface c {
        void fAe();
    }

    public interface d {
        void onFinished();
    }

    public interface e {
        void fAf();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean fAa() {
        return this.Grj;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void wy(boolean z) {
        this.Grj = z;
    }

    public a(String str) {
        AppMethodBeat.i(29663);
        this.userName = str;
        Grg = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".log";
        AppMethodBeat.o(29663);
    }

    public final void stop() {
        AppMethodBeat.i(29664);
        wy(true);
        if (Grh != null) {
            try {
                Grh.shutdownNow();
                AppMethodBeat.o(29664);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(29664);
    }

    public final void c(String[] strArr, boolean z) {
        String str;
        String str2;
        AppMethodBeat.i(29665);
        if (strArr == null || strArr.length == 0) {
            Log.e("MicroMsg.MMTraceRoute", "no ip contains");
            AppMethodBeat.o(29665);
            return;
        }
        if (z) {
            str = "" + "long: ";
        } else {
            str = "" + "short: ";
        }
        int length = strArr.length;
        int i2 = 0;
        String str3 = str;
        while (i2 < length) {
            String str4 = strArr[i2];
            String[] split = str4.split(":");
            if (split == null || split.length != 3) {
                Log.e("MicroMsg.MMTraceRoute", "err ip ".concat(String.valueOf(str4)));
                str2 = str3;
            } else if (!this.Grl.containsKey(split[0])) {
                HashSet hashSet = new HashSet();
                hashSet.add(Integer.valueOf(Util.getInt(split[1], 0)));
                this.Grl.put(split[0], hashSet);
                str2 = str3 + split[0] + " ";
            } else {
                this.Grl.get(split[0]).add(Integer.valueOf(Util.getInt(split[1], 0)));
                str2 = str3;
            }
            i2++;
            str3 = str2;
        }
        String str5 = str3 + "\n";
        String str6 = Grg;
        byte[] bytes = str5.getBytes();
        s.e(str6, bytes, bytes.length);
        AppMethodBeat.o(29665);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(String str, String str2, Integer num) {
        AppMethodBeat.i(29666);
        if (str == null || str2 == null || num.intValue() < 0) {
            AppMethodBeat.o(29666);
        } else if (!this.Grk.containsKey(str)) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(num, new StringBuilder(str2));
            this.Grk.put(str, concurrentHashMap);
            AppMethodBeat.o(29666);
        } else if (((ConcurrentHashMap) this.Grk.get(str)).containsKey(num)) {
            ((StringBuilder) ((ConcurrentHashMap) this.Grk.get(str)).get(num)).append(str2);
            AppMethodBeat.o(29666);
        } else {
            new ConcurrentHashMap().put(num, new StringBuilder(str2));
            ((ConcurrentHashMap) this.Grk.get(str)).put(num, new StringBuilder(str2));
            AppMethodBeat.o(29666);
        }
    }

    public final synchronized void fAb() {
        Map map;
        String str;
        AppMethodBeat.i(29667);
        if (this.Grk != null) {
            f fVar = this.Grk;
            o oVar = new o(Grg);
            if (!oVar.exists()) {
                try {
                    oVar.createNewFile();
                    String str2 = Grg;
                    byte[] bytes = (a.this.userName + "\n").getBytes();
                    s.e(str2, bytes, bytes.length);
                } catch (IOException e2) {
                    Log.e("MicroMsg.MMTraceRoute", "create log file err " + e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    a.this.fAc();
                    AppMethodBeat.o(29667);
                }
            }
            for (Map.Entry entry : a.this.Grk.entrySet()) {
                String str3 = (String) entry.getKey();
                if (!Util.isNullOrNil(str3) && a.this.Grk.containsKey(str3) && (map = (Map) a.this.Grk.get(str3)) != null) {
                    String str4 = "";
                    if (map.size() != 1 || map.get(1) == null) {
                        int i2 = 0;
                        boolean z = false;
                        while (i2 < map.size() && !z) {
                            if (map.get(Integer.valueOf(i2)) != null) {
                                String sb = ((StringBuilder) map.get(Integer.valueOf(i2))).toString();
                                if (!Util.isNullOrNil(sb)) {
                                    str = str4 + sb;
                                    if (sb.contains("FIN")) {
                                        z = true;
                                    }
                                    i2++;
                                    str4 = str;
                                }
                            }
                            str = str4;
                            i2++;
                            str4 = str;
                        }
                    } else {
                        str4 = str4 + ((StringBuilder) map.get(1)).toString();
                    }
                    if (str4.length() > 0) {
                        Log.i("MicroMsg.MMTraceRoute", str3 + str4);
                        String str5 = Grg;
                        byte[] bytes2 = str4.getBytes();
                        s.e(str5, bytes2, bytes2.length);
                    }
                }
            }
            byte[] aW = s.aW(Grg, 0, -1);
            if (Util.isNullOrNil(aW)) {
                Log.e("MicroMsg.MMTraceRoute", "read log failed");
                a.this.fAc();
                AppMethodBeat.o(29667);
            } else {
                int length = aW.length;
                String lowerCase = com.tencent.mm.b.g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(com.tencent.mm.protocal.d.KyO), Integer.valueOf(length)).getBytes()).toLowerCase();
                byte[] compress = com.tencent.mm.b.s.compress(aW);
                PByteArray pByteArray = new PByteArray();
                com.tencent.mm.b.c.a(pByteArray, compress, lowerCase.getBytes());
                ThreadPool.post(new Runnable(length, lowerCase, pByteArray) {
                    /* class com.tencent.mm.plugin.traceroute.b.a.f.AnonymousClass1 */
                    final /* synthetic */ int Grt;
                    final /* synthetic */ String Gru;
                    final /* synthetic */ PByteArray Grv;

                    {
                        this.Grt = r2;
                        this.Gru = r3;
                        this.Grv = r4;
                    }

                    public final void run() {
                        AppMethodBeat.i(29657);
                        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
                        StringBuilder sb = new StringBuilder(HttpWrapperBase.PROTOCAL_HTTPS);
                        String str = com.tencent.mm.network.c.icB;
                        String sb2 = sb.append(sharedPreferences.getString(str, str)).toString();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(sb2 + "/cgi-bin/mmsupport-bin/stackreport?version=");
                        stringBuffer.append(Integer.toHexString(com.tencent.mm.protocal.d.KyO));
                        stringBuffer.append("&devicetype=");
                        stringBuffer.append(com.tencent.mm.protocal.d.ics);
                        stringBuffer.append("&filelength=");
                        stringBuffer.append(this.Grt);
                        stringBuffer.append("&sum=");
                        stringBuffer.append(this.Gru);
                        stringBuffer.append("&reporttype=");
                        stringBuffer.append(4);
                        if (a.this.userName != null && !a.this.userName.equals("")) {
                            stringBuffer.append("&username=");
                            stringBuffer.append(a.this.userName);
                        }
                        Log.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
                        f.a(f.this, stringBuffer.toString(), this.Grv.value);
                        AppMethodBeat.o(29657);
                    }
                }, "MMTraceRoute_uploadLog");
            }
        }
        AppMethodBeat.o(29667);
    }

    /* access modifiers changed from: package-private */
    public final void fAc() {
        AppMethodBeat.i(29668);
        if (this.Grp != null) {
            this.Grp.fAd();
        }
        AppMethodBeat.o(29668);
    }

    public class j implements Runnable {
        private j() {
        }

        public /* synthetic */ j(a aVar, byte b2) {
            this();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 136
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 375
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.traceroute.b.a.j.run():void");
        }
    }

    class i implements Runnable {
        private String ip;

        public i(String str) {
            this.ip = str;
        }

        public final void run() {
            String format;
            AppMethodBeat.i(29661);
            List<Object> S = b.S(new String[]{"ping", "-c 1", "-t 64", this.ip});
            if (S.size() != 2) {
                a.this.b(this.ip, "failed to ping: \n" + this.ip, 0);
                AppMethodBeat.o(29661);
                return;
            }
            String str = (String) S.get(0);
            if (Util.isNullOrNil(str)) {
                a.this.b(this.ip, "failed to ping: \n" + this.ip, 0);
                Log.e("MicroMsg.MMTraceRoute", "runcommand err");
                AppMethodBeat.o(29661);
                return;
            }
            int aTL = b.aTL(str);
            if (aTL <= 0) {
                Log.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
                a.this.b(this.ip, "failed to touch server: " + this.ip + "\n", 0);
                AppMethodBeat.o(29661);
                return;
            }
            String obj = S.get(1).toString();
            String aTK = b.aTK(str);
            if (!Util.isNullOrNil(aTK)) {
                format = String.format("server: %s, TTL: %d, Time = %sms", this.ip, Integer.valueOf(aTL), aTK);
            } else if (!Util.isNullOrNil(obj)) {
                format = String.format("server: %s, TTL: %d, Time = %sms", this.ip, Integer.valueOf(aTL), obj);
            } else {
                format = String.format("server: %s, TTL: %d, Time = %sms", this.ip, Integer.valueOf(aTL), "unknown");
            }
            a.this.b(this.ip, format + "\n", 0);
            int i2 = (64 - aTL) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            for (int i3 = 1; i3 < i2 && !a.this.fAa(); i3++) {
                h hVar = new h(this.ip, i3);
                if (a.Grh != null) {
                    a.Grh.execute(hVar);
                }
            }
            AppMethodBeat.o(29661);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$a  reason: collision with other inner class name */
    class RunnableC1839a implements Runnable {
        private Set<Integer> Grq;
        private String ip;

        public RunnableC1839a(String str, Set<Integer> set) {
            this.ip = str;
            this.Grq = set;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x010f A[SYNTHETIC, Splitter:B:19:0x010f] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0187 A[SYNTHETIC, Splitter:B:27:0x0187] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x01ff A[SYNTHETIC, Splitter:B:35:0x01ff] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0231 A[SYNTHETIC, Splitter:B:42:0x0231] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0026 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0026 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0026 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 642
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.traceroute.b.a.RunnableC1839a.run():void");
        }
    }

    class h implements Runnable {
        private int GrA;
        private String ip;

        public h(String str, int i2) {
            this.ip = str;
            this.GrA = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x018f  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0072  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 404
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.traceroute.b.a.h.run():void");
        }
    }

    class g implements Runnable {
        private String Grx;
        private boolean Gry;
        private Integer Grz;
        private String serverIP;

        public g(String str, String str2, boolean z, Integer num) {
            this.Grx = str;
            this.serverIP = str2;
            this.Gry = z;
            this.Grz = num;
        }

        public final void run() {
            String format;
            AppMethodBeat.i(29659);
            a aVar = a.this;
            String str = this.Grx;
            String str2 = this.serverIP;
            Integer num = this.Grz;
            for (int i2 = 1; i2 <= 3; i2++) {
                List<Object> S = b.S(new String[]{"ping", "-c 1", "-t 64", str});
                if (S.size() == 2) {
                    String str3 = (String) S.get(0);
                    if (Util.isNullOrNil(str3)) {
                        Log.e("MicroMsg.MMTraceRoute", "runcommand err ".concat(String.valueOf(str)));
                        aVar.b(str2, "run command err ", num);
                    } else {
                        String obj = S.get(1).toString();
                        if (b.aTL(str3) > 0) {
                            String aTK = b.aTK(str3);
                            if (!Util.isNullOrNil(aTK)) {
                                format = String.format(" %sms ", aTK);
                            } else if (!Util.isNullOrNil(obj)) {
                                format = String.format(" %sms ", obj);
                            } else {
                                format = String.format("unable to get time", new Object[0]);
                            }
                        } else {
                            format = String.format(" router no response ", new Object[0]);
                        }
                        if (i2 == 3) {
                            format = format + "\n";
                        }
                        aVar.b(str2, format, num);
                    }
                } else if (i2 == 3) {
                    aVar.b(str2, " router no response\n", num);
                } else {
                    aVar.b(str2, " router no response", num);
                }
            }
            AppMethodBeat.o(29659);
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {
        private final String Grs;

        private f() {
            AppMethodBeat.i(232122);
            this.Grs = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m);
            AppMethodBeat.o(232122);
        }

        /* synthetic */ f(a aVar, byte b2) {
            this();
        }

        static /* synthetic */ void a(f fVar, String str, byte[] bArr) {
            AppMethodBeat.i(29658);
            int i2 = 3;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(str);
                    try {
                        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
                        byteArrayEntity.setContentType("binary/octet-stream");
                        httpPost.setEntity(byteArrayEntity);
                        Log.i("MicroMsg.MMTraceRoute", "http pose returnContent : ".concat(String.valueOf(Util.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()))));
                        a aVar = a.this;
                        if (aVar.Gro != null) {
                            aVar.Gro.fAe();
                        }
                        AppMethodBeat.o(29658);
                        return;
                    } catch (IllegalStateException e2) {
                        Log.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e2.getMessage());
                        Log.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        i2 = i3;
                    } catch (IOException e3) {
                        Log.e("MicroMsg.MMTraceRoute", "http post IOException: " + e3.getMessage());
                        Log.printErrStackTrace("MicroMsg.MMTraceRoute", e3, "", new Object[0]);
                        i2 = i3;
                    }
                } else {
                    a.this.fAc();
                    AppMethodBeat.o(29658);
                    return;
                }
            }
        }
    }
}
