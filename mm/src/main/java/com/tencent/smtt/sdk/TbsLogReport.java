package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.n;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

public class TbsLogReport {

    /* renamed from: a  reason: collision with root package name */
    private static TbsLogReport f1812a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f1813b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f1814c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1815d = false;

    static /* synthetic */ void a(TbsLogReport tbsLogReport) {
        AppMethodBeat.i(54983);
        tbsLogReport.b();
        AppMethodBeat.o(54983);
    }

    static /* synthetic */ void a(TbsLogReport tbsLogReport, int i2, TbsLogInfo tbsLogInfo) {
        AppMethodBeat.i(54982);
        tbsLogReport.a(i2, tbsLogInfo);
        AppMethodBeat.o(54982);
    }

    static /* synthetic */ void b(TbsLogReport tbsLogReport) {
        AppMethodBeat.i(54984);
        tbsLogReport.c();
        AppMethodBeat.o(54984);
    }

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);
        

        /* renamed from: a  reason: collision with root package name */
        int f1820a;

        public static EventType valueOf(String str) {
            AppMethodBeat.i(54368);
            EventType eventType = (EventType) Enum.valueOf(EventType.class, str);
            AppMethodBeat.o(54368);
            return eventType;
        }

        static {
            AppMethodBeat.i(54369);
            AppMethodBeat.o(54369);
        }

        private EventType(int i2) {
            this.f1820a = i2;
        }
    }

    private TbsLogReport(Context context) {
        AppMethodBeat.i(54960);
        this.f1814c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.f1813b = new Handler(handlerThread.getLooper()) {
            /* class com.tencent.smtt.sdk.TbsLogReport.AnonymousClass1 */

            public void handleMessage(Message message) {
                AppMethodBeat.i(55019);
                if (message.what == 600) {
                    if (message.obj instanceof TbsLogInfo) {
                        try {
                            int i2 = message.arg1;
                            TbsLogReport.a(TbsLogReport.this, i2, (TbsLogInfo) message.obj);
                            AppMethodBeat.o(55019);
                            return;
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(55019);
                    return;
                }
                if (message.what == 601) {
                    TbsLogReport.a(TbsLogReport.this);
                }
                AppMethodBeat.o(55019);
            }
        };
        AppMethodBeat.o(54960);
    }

    public static TbsLogReport getInstance(Context context) {
        AppMethodBeat.i(54961);
        if (f1812a == null) {
            synchronized (TbsLogReport.class) {
                try {
                    if (f1812a == null) {
                        f1812a = new TbsLogReport(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(54961);
                    throw th;
                }
            }
        }
        TbsLogReport tbsLogReport = f1812a;
        AppMethodBeat.o(54961);
        return tbsLogReport;
    }

    public static class TbsLogInfo implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        int f1821a;

        /* renamed from: b  reason: collision with root package name */
        private long f1822b;

        /* renamed from: c  reason: collision with root package name */
        private String f1823c;

        /* renamed from: d  reason: collision with root package name */
        private String f1824d;

        /* renamed from: e  reason: collision with root package name */
        private int f1825e;

        /* renamed from: f  reason: collision with root package name */
        private int f1826f;

        /* renamed from: g  reason: collision with root package name */
        private int f1827g;

        /* renamed from: h  reason: collision with root package name */
        private int f1828h;

        /* renamed from: i  reason: collision with root package name */
        private String f1829i;

        /* renamed from: j  reason: collision with root package name */
        private int f1830j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
            AppMethodBeat.i(55046);
            resetArgs();
            AppMethodBeat.o(55046);
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public Object clone() {
            Object obj;
            AppMethodBeat.i(55047);
            try {
                Object clone = super.clone();
                AppMethodBeat.o(55047);
                obj = clone;
            } catch (CloneNotSupportedException e2) {
                AppMethodBeat.o(55047);
                obj = this;
            }
            return obj;
        }

        public void resetArgs() {
            this.f1822b = 0;
            this.f1823c = null;
            this.f1824d = null;
            this.f1825e = 0;
            this.f1826f = 0;
            this.f1827g = 0;
            this.f1828h = 2;
            this.f1829i = "unknown";
            this.f1830j = 0;
            this.k = 2;
            this.l = 0;
            this.m = 0;
            this.n = 1;
            this.f1821a = 0;
            this.o = null;
            this.p = null;
            this.q = 0;
        }

        public void setEventTime(long j2) {
            this.f1822b = j2;
        }

        public void setDownloadUrl(String str) {
            AppMethodBeat.i(55048);
            if (this.f1823c == null) {
                this.f1823c = str;
                AppMethodBeat.o(55048);
                return;
            }
            this.f1823c += ";" + str;
            AppMethodBeat.o(55048);
        }

        public void setResolveIp(String str) {
            this.f1824d = str;
        }

        public void setHttpCode(int i2) {
            this.f1825e = i2;
        }

        public void setPatchUpdateFlag(int i2) {
            this.f1826f = i2;
        }

        public void setDownloadCancel(int i2) {
            this.f1827g = i2;
        }

        public void setUnpkgFlag(int i2) {
            this.f1828h = i2;
        }

        public void setApn(String str) {
            this.f1829i = str;
        }

        public void setNetworkType(int i2) {
            this.f1830j = i2;
        }

        public void setDownFinalFlag(int i2) {
            this.k = i2;
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void setPkgSize(long j2) {
            this.l = j2;
        }

        public void setDownConsumeTime(long j2) {
            this.m += j2;
        }

        public void setNetworkChange(int i2) {
            this.n = i2;
        }

        public void setErrorCode(int i2) {
            AppMethodBeat.i(55049);
            if (!(i2 == 100 || i2 == 110 || i2 == 120 || i2 == 111 || i2 >= 400)) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:".concat(String.valueOf(i2)), true);
            }
            if (i2 == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f1821a = i2;
            AppMethodBeat.o(55049);
        }

        public void setCheckErrorDetail(String str) {
            AppMethodBeat.i(55050);
            setErrorCode(108);
            this.o = str;
            AppMethodBeat.o(55050);
        }

        public void setFailDetail(String str) {
            AppMethodBeat.i(55051);
            if (str == null) {
                AppMethodBeat.o(55051);
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.p = str;
            AppMethodBeat.o(55051);
        }

        public void setFailDetail(Throwable th) {
            AppMethodBeat.i(55052);
            if (th == null) {
                this.p = "";
                AppMethodBeat.o(55052);
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.p = stackTraceString;
            AppMethodBeat.o(55052);
        }

        public void setDownloadSize(long j2) {
            this.q += j2;
        }
    }

    public TbsLogInfo tbsLogInfo() {
        AppMethodBeat.i(54962);
        TbsLogInfo tbsLogInfo = new TbsLogInfo();
        AppMethodBeat.o(54962);
        return tbsLogInfo;
    }

    public void setInstallErrorCode(int i2, String str) {
        AppMethodBeat.i(54963);
        setInstallErrorCode(i2, str, EventType.TYPE_INSTALL);
        AppMethodBeat.o(54963);
    }

    public void setInstallErrorCode(int i2, String str, EventType eventType) {
        AppMethodBeat.i(54964);
        if (!(i2 == 200 || i2 == 220 || i2 == 221)) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:".concat(String.valueOf(i2)), true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i2, tbsLogInfo, eventType);
        AppMethodBeat.o(54964);
    }

    private void a(int i2, TbsLogInfo tbsLogInfo, EventType eventType) {
        AppMethodBeat.i(54965);
        tbsLogInfo.setErrorCode(i2);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.l.onInstallFinish(i2);
        eventReport(eventType, tbsLogInfo);
        AppMethodBeat.o(54965);
    }

    public void setInstallErrorCode(int i2, Throwable th) {
        AppMethodBeat.i(54966);
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i2, tbsLogInfo, EventType.TYPE_INSTALL);
        AppMethodBeat.o(54966);
    }

    public void setLoadErrorCode(int i2, String str) {
        AppMethodBeat.i(54967);
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i2);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
        new StringBuilder("setLoadErrorCode(").append(i2).append(",").append(str).append(")");
        AppMethodBeat.o(54967);
    }

    public void setLoadErrorCode(int i2, Throwable th) {
        AppMethodBeat.i(54968);
        String str = "NULL";
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
        }
        setLoadErrorCode(i2, str);
        AppMethodBeat.o(54968);
    }

    public void dailyReport() {
        AppMethodBeat.i(54969);
        this.f1813b.sendEmptyMessage(601);
        AppMethodBeat.o(54969);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        AppMethodBeat.i(54970);
        try {
            Message obtainMessage = this.f1813b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.f1820a;
            obtainMessage.obj = (TbsLogInfo) tbsLogInfo.clone();
            this.f1813b.sendMessage(obtainMessage);
            AppMethodBeat.o(54970);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
            AppMethodBeat.o(54970);
        }
    }

    private void a(int i2, TbsLogInfo tbsLogInfo) {
        String str;
        AppMethodBeat.i(54971);
        StringBuilder sb = new StringBuilder();
        sb.append(a(i2));
        sb.append(a(b.f(this.f1814c)));
        sb.append(a(l.a(this.f1814c)));
        sb.append(a(q.a().j(this.f1814c)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
        } catch (Exception e2) {
            str = str2;
        }
        sb.append(a(str));
        String packageName = this.f1814c.getPackageName();
        sb.append(a(packageName));
        if ("com.tencent.mm".equals(packageName)) {
            sb.append(a(b.a(this.f1814c, TbsDownloader.TBS_METADATA)));
        } else {
            sb.append(a(b.d(this.f1814c)));
        }
        sb.append(a(a(tbsLogInfo.f1822b)));
        sb.append(a(tbsLogInfo.f1823c));
        sb.append(a(tbsLogInfo.f1824d));
        sb.append(a(tbsLogInfo.f1825e));
        sb.append(a(tbsLogInfo.f1826f));
        sb.append(a(tbsLogInfo.f1827g));
        sb.append(a(tbsLogInfo.f1828h));
        sb.append(a(tbsLogInfo.f1829i));
        sb.append(a(tbsLogInfo.f1830j));
        sb.append(a(tbsLogInfo.k));
        sb.append(b(tbsLogInfo.q));
        sb.append(b(tbsLogInfo.l));
        sb.append(b(tbsLogInfo.m));
        sb.append(a(tbsLogInfo.n));
        sb.append(a(tbsLogInfo.f1821a));
        sb.append(a(tbsLogInfo.o));
        sb.append(a(tbsLogInfo.p));
        sb.append(a(TbsDownloadConfig.getInstance(this.f1814c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(a(b.i(this.f1814c)));
        sb.append(a("4.4.0.0006_43809"));
        sb.append(false);
        SharedPreferences d2 = d();
        JSONArray a2 = a();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i3 = 4; i3 > 0; i3--) {
                try {
                    jSONArray.put(a2.get(jSONArray.length() - i3));
                } catch (Exception e3) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
        } else {
            jSONArray = a2;
        }
        jSONArray.put(sb.toString());
        SharedPreferences.Editor edit = d2.edit();
        edit.putString("tbs_download_upload", jSONArray.toString());
        edit.commit();
        if (this.f1815d || i2 != EventType.TYPE_LOAD.f1820a) {
            b();
        }
        AppMethodBeat.o(54971);
    }

    private JSONArray a() {
        JSONArray jSONArray;
        AppMethodBeat.i(54972);
        String string = d().getString("tbs_download_upload", null);
        if (string == null) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(string);
                if (jSONArray.length() > 5) {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = jSONArray.length() - 1;
                    if (length > jSONArray.length() - 5) {
                        jSONArray2.put(jSONArray.get(length));
                        AppMethodBeat.o(54972);
                        return jSONArray2;
                    }
                }
            } catch (Exception e2) {
                jSONArray = new JSONArray();
            }
        }
        AppMethodBeat.o(54972);
        return jSONArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0115 A[SYNTHETIC, Splitter:B:31:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011a A[SYNTHETIC, Splitter:B:34:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0167 A[SYNTHETIC, Splitter:B:48:0x0167] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016c A[SYNTHETIC, Splitter:B:51:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportTbsLog() {
        /*
        // Method dump skipped, instructions count: 416
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.reportTbsLog():void");
    }

    private void b() {
        AppMethodBeat.i(54974);
        if (QbSdk.mSettings == null || !QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray a2 = a();
            if (a2 == null || a2.length() == 0) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
                AppMethodBeat.o(54974);
                return;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:".concat(String.valueOf(a2)));
            try {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + g.a(n.a(this.f1814c).c(), a2.toString().getBytes(ProtocolPackage.ServerEncoding), new g.a() {
                    /* class com.tencent.smtt.sdk.TbsLogReport.AnonymousClass3 */

                    @Override // com.tencent.smtt.utils.g.a
                    public void a(int i2) {
                        AppMethodBeat.i(55090);
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:".concat(String.valueOf(i2)));
                        if (i2 < 300) {
                            TbsLogReport.b(TbsLogReport.this);
                        }
                        AppMethodBeat.o(55090);
                    }
                }, true) + " testcase: -1");
                AppMethodBeat.o(54974);
            } catch (Throwable th) {
                AppMethodBeat.o(54974);
            }
        } else {
            TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.o(54974);
        }
    }

    private void c() {
        AppMethodBeat.i(54975);
        SharedPreferences.Editor edit = d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
        AppMethodBeat.o(54975);
    }

    private String a(long j2) {
        AppMethodBeat.i(54976);
        String str = null;
        try {
            str = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS, Locale.getDefault()).format(new Date(j2));
        } catch (Exception e2) {
        }
        AppMethodBeat.o(54976);
        return str;
    }

    private SharedPreferences d() {
        AppMethodBeat.i(54977);
        SharedPreferences sharedPreferences = this.f1814c.getSharedPreferences("tbs_download_stat", 4);
        AppMethodBeat.o(54977);
        return sharedPreferences;
    }

    private String a(String str) {
        AppMethodBeat.i(54978);
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        String sb2 = sb.append(str).append("|").toString();
        AppMethodBeat.o(54978);
        return sb2;
    }

    private String a(int i2) {
        AppMethodBeat.i(54979);
        String str = i2 + "|";
        AppMethodBeat.o(54979);
        return str;
    }

    private String b(long j2) {
        AppMethodBeat.i(54980);
        String str = j2 + "|";
        AppMethodBeat.o(54980);
        return str;
    }

    public void clear() {
        AppMethodBeat.i(54981);
        try {
            SharedPreferences.Editor edit = d().edit();
            edit.clear();
            edit.commit();
            AppMethodBeat.o(54981);
        } catch (Exception e2) {
            AppMethodBeat.o(54981);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1831a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1832b;

        public a(String str, String str2) {
            this.f1831a = str;
            this.f1832b = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[SYNTHETIC, Splitter:B:19:0x0051] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[SYNTHETIC, Splitter:B:22:0x0056] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A[SYNTHETIC, Splitter:B:39:0x0082] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0087 A[SYNTHETIC, Splitter:B:42:0x0087] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[SYNTHETIC, Splitter:B:49:0x0096] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x009b A[SYNTHETIC, Splitter:B:52:0x009b] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00b1 A[SYNTHETIC, Splitter:B:62:0x00b1] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6 A[SYNTHETIC, Splitter:B:65:0x00b6] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00bd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
            // Method dump skipped, instructions count: 241
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a.a():void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[SYNTHETIC, Splitter:B:16:0x0041] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC, Splitter:B:24:0x0052] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0059  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void a(java.io.File r7) {
            /*
            // Method dump skipped, instructions count: 101
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a.a(java.io.File):void");
        }
    }

    public void setShouldUploadEventReport(boolean z) {
        this.f1815d = z;
    }

    public boolean getShouldUploadEventReport() {
        return this.f1815d;
    }
}
