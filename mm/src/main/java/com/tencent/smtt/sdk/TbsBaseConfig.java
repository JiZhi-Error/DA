package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f1773a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1774b;

    public abstract String getConfigFileName();

    public void init(Context context) {
        this.f1773a = new HashMap();
        this.f1774b = context.getApplicationContext();
        if (this.f1774b == null) {
            this.f1774b = context;
        }
        refreshSyncMap(context);
    }

    private static File a(Context context, String str) {
        q.a();
        File t = q.t(context);
        if (t == null) {
            return null;
        }
        File file = new File(t, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            return null;
        }
    }

    public void clear() {
        this.f1773a.clear();
        commit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[SYNTHETIC, Splitter:B:16:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[SYNTHETIC, Splitter:B:25:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void refreshSyncMap(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsBaseConfig.refreshSyncMap(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A[SYNTHETIC, Splitter:B:19:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c A[SYNTHETIC, Splitter:B:22:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6 A[SYNTHETIC, Splitter:B:36:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab A[SYNTHETIC, Splitter:B:39:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void writeTbsDownloadInfo() {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsBaseConfig.writeTbsDownloadInfo():void");
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }
}
