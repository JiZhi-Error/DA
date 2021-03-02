package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";

    /* renamed from: a  reason: collision with root package name */
    Context f1884a = null;

    /* renamed from: b  reason: collision with root package name */
    TbsVideoCacheListener f1885b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1886c = false;

    /* renamed from: d  reason: collision with root package name */
    private s f1887d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f1888e;

    /* renamed from: f  reason: collision with root package name */
    private String f1889f;

    /* renamed from: g  reason: collision with root package name */
    private Object f1890g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        AppMethodBeat.i(54613);
        this.f1884a = context;
        this.f1885b = tbsVideoCacheListener;
        if (bundle != null) {
            this.f1888e = bundle.getString("taskId");
            this.f1889f = bundle.getString("url");
        }
        a(bundle);
        AppMethodBeat.o(54613);
    }

    public String getTaskID() {
        return this.f1888e;
    }

    public String getTaskUrl() {
        return this.f1889f;
    }

    private void a(Bundle bundle) {
        DexLoader dexLoader;
        AppMethodBeat.i(54614);
        if (this.f1887d == null) {
            g.a(true).a(this.f1884a, false, false, null);
            TbsWizard a2 = g.a(true).a();
            if (a2 != null) {
                dexLoader = a2.dexLoader();
            } else {
                this.f1885b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoader = null;
            }
            if (dexLoader != null) {
                this.f1887d = new s(dexLoader);
            } else {
                this.f1885b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        if (this.f1887d != null) {
            this.f1890g = this.f1887d.a(this.f1884a, this, bundle);
            if (this.f1890g == null) {
                this.f1885b.onVideoDownloadError(this, -1, "init task error!", null);
                AppMethodBeat.o(54614);
                return;
            }
        } else if (this.f1885b != null) {
            this.f1885b.onVideoDownloadError(this, -1, "init error!", null);
        }
        AppMethodBeat.o(54614);
    }

    public void pauseTask() {
        AppMethodBeat.i(54615);
        new StringBuilder("pauseTask mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54615);
            return;
        }
        this.f1887d.a();
        AppMethodBeat.o(54615);
    }

    public void stopTask() {
        AppMethodBeat.i(54616);
        new StringBuilder("stopTask mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54616);
            return;
        }
        this.f1887d.c();
        AppMethodBeat.o(54616);
    }

    public void resumeTask() {
        AppMethodBeat.i(54617);
        new StringBuilder("resumeTask mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54617);
            return;
        }
        this.f1887d.b();
        AppMethodBeat.o(54617);
    }

    public void removeTask(boolean z) {
        AppMethodBeat.i(54618);
        new StringBuilder("removeTask mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54618);
            return;
        }
        this.f1887d.a(z);
        AppMethodBeat.o(54618);
    }

    public long getContentLength() {
        AppMethodBeat.i(54619);
        new StringBuilder("getContentLength mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54619);
            return 0;
        }
        long d2 = this.f1887d.d();
        AppMethodBeat.o(54619);
        return d2;
    }

    public int getDownloadedSize() {
        AppMethodBeat.i(54620);
        new StringBuilder("getDownloadedSize mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54620);
            return 0;
        }
        int e2 = this.f1887d.e();
        AppMethodBeat.o(54620);
        return e2;
    }

    public int getProgress() {
        AppMethodBeat.i(54621);
        new StringBuilder("getProgress mWizard = ").append(this.f1887d == null ? BuildConfig.COMMAND : "not null").append("  mDownloadWorker = ").append(this.f1890g == null ? BuildConfig.COMMAND : "not null");
        if (this.f1887d == null || this.f1890g == null) {
            if (this.f1885b != null) {
                this.f1885b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
            }
            AppMethodBeat.o(54621);
            return 0;
        }
        int f2 = this.f1887d.f();
        AppMethodBeat.o(54621);
        return f2;
    }
}
