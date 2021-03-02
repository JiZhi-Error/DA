package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public volatile b DGp;
    public C1728a DXh;
    public volatile boolean DXi;
    private IntentFilter DXj;
    ConcurrentHashMap<String, c> DXk;
    public ConcurrentHashMap<String, d> DXl;
    public m DXm;
    MMHandler DXn;

    public interface b {
        void failed(long j2);

        void paused(long j2);

        void progress(long j2, int i2);

        void resumed(long j2);

        void stopped(long j2);

        void succeed(long j2);
    }

    public interface c {
        void aOJ(String str);

        void aOK(String str);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static class d implements Serializable {
        public String aid;
        public String kZe;
        public String uxInfo;

        public d(String str, String str2, String str3) {
            this.aid = str;
            this.kZe = str2;
            this.uxInfo = str3;
        }
    }

    public static final class e {
        public static final a DXp = new a((byte) 0);

        static {
            AppMethodBeat.i(96294);
            AppMethodBeat.o(96294);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a$a  reason: collision with other inner class name */
    public class C1728a extends BroadcastReceiver {
        private C1728a() {
        }

        /* synthetic */ C1728a(a aVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(96293);
            if (intent != null) {
                String action = intent.getAction();
                Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, action=".concat(String.valueOf(action)));
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(schemeSpecificPart)));
                    if (Util.isNullOrNil(schemeSpecificPart) || !a.this.DXk.containsKey(schemeSpecificPart)) {
                        Log.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(schemeSpecificPart)));
                        AppMethodBeat.o(96293);
                        return;
                    }
                    a.this.DXk.remove(schemeSpecificPart).aOJ(schemeSpecificPart);
                    AppMethodBeat.o(96293);
                    return;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    String schemeSpecificPart2 = intent.getData().getSchemeSpecificPart();
                    Log.i("MicroMsg.AdDownloadApkMgr", "onReceive, pkg=".concat(String.valueOf(schemeSpecificPart2)));
                    if (Util.isNullOrNil(schemeSpecificPart2) || !a.this.DXk.containsKey(schemeSpecificPart2)) {
                        Log.e("MicroMsg.AdDownloadApkMgr", "onReceive, installCallback==null, pkg=".concat(String.valueOf(schemeSpecificPart2)));
                    } else {
                        a.this.DXk.remove(schemeSpecificPart2).aOK(schemeSpecificPart2);
                        AppMethodBeat.o(96293);
                        return;
                    }
                }
            }
            AppMethodBeat.o(96293);
        }
    }

    private a() {
        AppMethodBeat.i(96295);
        this.DXk = new ConcurrentHashMap<>();
        this.DXl = new ConcurrentHashMap<>();
        this.DXm = new m() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void k(long j2, String str) {
                AppMethodBeat.i(96283);
                a.this.aH(1, j2);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskStarted, id=".concat(String.valueOf(j2)));
                AppMethodBeat.o(96283);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void b(long j2, String str, boolean z) {
                AppMethodBeat.i(96284);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFinished, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(j2)));
                if (a.this.DGp != null) {
                    a.this.DGp.succeed(j2);
                    a.this.DXn.removeMessages(10008);
                    a.this.DXn.sendEmptyMessageDelayed(10008, 300000);
                }
                a.this.aH(3, j2);
                AppMethodBeat.o(96284);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void b(long j2, int i2, boolean z) {
                AppMethodBeat.i(96285);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskFailed, id=" + j2 + ", errCode=" + i2);
                if (a.this.DGp != null) {
                    a.this.DGp.failed(j2);
                }
                a.this.aH(8, j2);
                AppMethodBeat.o(96285);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void Bd(long j2) {
                AppMethodBeat.i(96286);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskRemoved, id=".concat(String.valueOf(j2)));
                if (a.this.DGp != null) {
                    a.this.DGp.stopped(j2);
                }
                a.this.aH(2, j2);
                AppMethodBeat.o(96286);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void Be(long j2) {
                AppMethodBeat.i(96287);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskPaused, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(j2)));
                if (a.this.DGp != null) {
                    a.this.DGp.paused(j2);
                }
                a.this.aH(6, j2);
                a.this.DXn.removeMessages(10008);
                a.this.DXn.sendEmptyMessageDelayed(10008, 300000);
                AppMethodBeat.o(96287);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void a(long j2, String str, long j3, long j4) {
                AppMethodBeat.i(202828);
                Log.d("MicroMsg.AdDownloadApkMgr", "progress changed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(j2)));
                if (a.this.DGp != null) {
                    FileDownloadTaskInfo Co = f.cBv().Co(j2);
                    if (Co.qJe >= 0 && Co.oJj > 0) {
                        a.this.DGp.progress(j2, (int) ((Co.qJe * 100) / Co.oJj));
                        a.this.DXn.removeMessages(10008);
                        a.this.DXn.sendEmptyMessageDelayed(10008, 300000);
                    }
                }
                AppMethodBeat.o(202828);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void l(long j2, String str) {
                AppMethodBeat.i(96289);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskResumed, reset MSG_CHECK_INSTALL, id=".concat(String.valueOf(j2)));
                if (a.this.DGp != null) {
                    a.this.DGp.resumed(j2);
                }
                a.this.aH(7, j2);
                a.this.DXn.removeMessages(10008);
                a.this.DXn.sendEmptyMessageDelayed(10008, 300000);
                AppMethodBeat.o(96289);
            }

            @Override // com.tencent.mm.plugin.downloader.model.m
            public final void Bf(long j2) {
                AppMethodBeat.i(96290);
                Log.i("MicroMsg.AdDownloadApkMgr", "onTaskMd5Checking, remove MSG_CHECK_INSTALL, id=".concat(String.valueOf(j2)));
                a.this.DXn.removeMessages(10008);
                a.this.DXn.sendEmptyMessageDelayed(10008, 300000);
                AppMethodBeat.o(96290);
            }
        };
        this.DXh = new C1728a(this, (byte) 0);
        this.DXj = new IntentFilter();
        this.DXj.addAction("android.intent.action.PACKAGE_ADDED");
        this.DXj.addAction("android.intent.action.PACKAGE_REMOVED");
        this.DXj.addDataScheme("package");
        this.DXn = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(96291);
                if (message.what == 10008) {
                    Log.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
                    try {
                        MMApplicationContext.getContext().unregisterReceiver(a.this.DXh);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AdDownloadApkMgr", "unregister package receiver, exp=" + e2.toString());
                    }
                    a.this.DXi = false;
                }
                AppMethodBeat.o(96291);
            }
        };
        AppMethodBeat.o(96295);
    }

    public static boolean isApkExist(String str) {
        AppMethodBeat.i(96296);
        FileDownloadTaskInfo alg = f.cBv().alg(str);
        if (alg == null || alg.status != 3 || TextUtils.isEmpty(alg.path) || !s.YS(alg.path)) {
            AppMethodBeat.o(96296);
            return false;
        }
        AppMethodBeat.o(96296);
        return true;
    }

    public static boolean bz(Context context, String str) {
        AppMethodBeat.i(96297);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(96297);
            return false;
        }
        boolean s = q.s(context, str);
        AppMethodBeat.o(96297);
        return s;
    }

    public static long queryIdByAppid(String str) {
        AppMethodBeat.i(96298);
        FileDownloadTaskInfo alg = f.cBv().alg(str);
        if (alg != null) {
            long j2 = alg.id;
            AppMethodBeat.o(96298);
            return j2;
        }
        AppMethodBeat.o(96298);
        return MAlarmHandler.NEXT_FIRE_INTERVAL;
    }

    public final void a(String str, c cVar) {
        AppMethodBeat.i(96299);
        this.DXk.put(str, cVar);
        Log.w("MicroMsg.AdDownloadApkMgr", "register package receiver");
        try {
            MMApplicationContext.getContext().registerReceiver(this.DXh, this.DXj);
        } catch (Exception e2) {
            Log.e("MicroMsg.AdDownloadApkMgr", "register package receiver, exp=" + e2.toString());
        }
        this.DXi = true;
        this.DXn.removeMessages(10008);
        this.DXn.sendEmptyMessageDelayed(10008, 300000);
        AppMethodBeat.o(96299);
    }

    public final void aH(int i2, long j2) {
        AppMethodBeat.i(96300);
        com.tencent.mm.plugin.downloader.g.a CH = ((com.tencent.mm.plugin.downloader.a.d) g.af(com.tencent.mm.plugin.downloader.a.d.class)).aSU().CH(j2);
        if (CH == null) {
            AppMethodBeat.o(96300);
            return;
        }
        reportDownloadInfo(i2, CH.field_rawAppId);
        AppMethodBeat.o(96300);
    }

    private static String s(Object... objArr) {
        AppMethodBeat.i(96301);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append(String.valueOf(objArr[i2]));
            if (i2 != 5) {
                sb.append(',');
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(96301);
        return sb2;
    }

    private void g(int i2, String str, String str2, String str3) {
        String str4;
        String str5;
        AppMethodBeat.i(96302);
        System.currentTimeMillis();
        d dVar = this.DXl.get(str);
        if (dVar == null) {
            Log.e("MicroMsg.AdDownloadApkMgr", "reportInfo is null, appid=".concat(String.valueOf(str)));
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        if (dVar == null) {
            str4 = "";
        } else {
            str4 = dVar.aid + "." + dVar.kZe + "." + str2 + ".0.20.0";
        }
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = Long.valueOf(System.currentTimeMillis() / 1000);
        if (dVar == null) {
            str5 = "";
        } else {
            str5 = dVar.uxInfo;
        }
        objArr[5] = str5;
        String s = s(objArr);
        Log.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", 14542, s);
        Log.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : ".concat(String.valueOf(str4)));
        h.INSTANCE.a(14542, s, true, false);
        AppMethodBeat.o(96302);
    }

    public final void reportDownloadInfo(int i2, String str) {
        AppMethodBeat.i(96303);
        com.tencent.mm.plugin.downloader.g.a alb = ((com.tencent.mm.plugin.downloader.a.d) g.af(com.tencent.mm.plugin.downloader.a.d.class)).aSU().alb(str);
        if (alb == null) {
            Log.e("MicroMsg.AdDownloadApkMgr", "reportDownloadInfo, downloadinfo not found, appId=" + str + ", op=" + i2);
            if (i2 != 9) {
                j.b(j.DDY, str, i2, 0, "");
            }
            AppMethodBeat.o(96303);
            return;
        }
        g(i2, str, alb.field_packageName, alb.field_downloadUrl);
        AppMethodBeat.o(96303);
    }
}
