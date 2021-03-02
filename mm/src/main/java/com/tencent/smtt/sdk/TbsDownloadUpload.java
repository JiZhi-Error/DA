package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TbsDownloadUpload {

    /* renamed from: b  reason: collision with root package name */
    private static TbsDownloadUpload f1787b;

    /* renamed from: a  reason: collision with root package name */
    Map<String, Object> f1788a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Context f1789c;

    /* renamed from: d  reason: collision with root package name */
    private int f1790d;

    /* renamed from: e  reason: collision with root package name */
    private int f1791e;

    /* renamed from: f  reason: collision with root package name */
    private int f1792f;

    /* renamed from: g  reason: collision with root package name */
    private int f1793g;

    /* renamed from: h  reason: collision with root package name */
    private int f1794h;

    /* renamed from: i  reason: collision with root package name */
    private int f1795i;
    public SharedPreferences mPreferences;

    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        AppMethodBeat.i(54657);
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        this.f1789c = context.getApplicationContext();
        if (this.f1789c == null) {
            this.f1789c = context;
        }
        AppMethodBeat.o(54657);
    }

    public static synchronized TbsDownloadUpload getInstance(Context context) {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            AppMethodBeat.i(54658);
            if (f1787b == null) {
                f1787b = new TbsDownloadUpload(context);
            }
            tbsDownloadUpload = f1787b;
            AppMethodBeat.o(54658);
        }
        return tbsDownloadUpload;
    }

    public static synchronized TbsDownloadUpload getInstance() {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            tbsDownloadUpload = f1787b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized void clear() {
        synchronized (TbsDownloadUpload.class) {
            f1787b = null;
        }
    }

    public void clearUploadCode() {
        AppMethodBeat.i(54659);
        this.f1788a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.f1788a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.f1788a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.f1788a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.f1788a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.f1788a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
        AppMethodBeat.o(54659);
    }

    public synchronized int getNeedDownloadCode() {
        int i2;
        if (this.f1793g == 1) {
            i2 = 148;
        } else {
            i2 = this.f1790d;
        }
        return i2;
    }

    public synchronized int getLocalCoreVersion() {
        return this.f1795i;
    }

    public synchronized int getStartDownloadCode() {
        int i2;
        if (this.f1794h == 1) {
            i2 = 168;
        } else {
            i2 = this.f1791e;
        }
        return i2;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f1792f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[SYNTHETIC, Splitter:B:42:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0115 A[SYNTHETIC, Splitter:B:50:0x0115] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void readTbsDownloadInfo(android.content.Context r5) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadUpload.readTbsDownloadInfo(android.content.Context):void");
    }

    private static File a(Context context, String str) {
        AppMethodBeat.i(54661);
        q.a();
        File t = q.t(context);
        if (t == null) {
            AppMethodBeat.o(54661);
            return null;
        }
        File file = new File(t, str);
        if (file.exists()) {
            AppMethodBeat.o(54661);
            return file;
        }
        try {
            file.createNewFile();
            AppMethodBeat.o(54661);
            return file;
        } catch (IOException e2) {
            AppMethodBeat.o(54661);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f A[SYNTHETIC, Splitter:B:20:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[SYNTHETIC, Splitter:B:23:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ca A[SYNTHETIC, Splitter:B:44:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf A[SYNTHETIC, Splitter:B:47:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void writeTbsDownloadInfo() {
        /*
        // Method dump skipped, instructions count: 239
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadUpload.writeTbsDownloadInfo():void");
    }

    public synchronized void commit() {
        AppMethodBeat.i(54663);
        writeTbsDownloadInfo();
        AppMethodBeat.o(54663);
    }
}
