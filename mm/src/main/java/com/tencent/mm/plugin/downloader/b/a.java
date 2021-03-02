package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a implements m {
    private static a qFD = null;
    private static BroadcastReceiver qFE = null;
    private static Set<b> qFF = new CopyOnWriteArraySet();
    private static Set<c> qFG = new CopyOnWriteArraySet();
    private static IListener qFH = new IListener<jg>() {
        /* class com.tencent.mm.plugin.downloader.b.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160994);
            this.__eventId = jg.class.getName().hashCode();
            AppMethodBeat.o(160994);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jg jgVar) {
            com.tencent.mm.plugin.downloader.g.a ale;
            AppMethodBeat.i(88832);
            jg jgVar2 = jgVar;
            String str = jgVar2.dNY.url;
            if (!Util.isNullOrNil(str) && (ale = com.tencent.mm.plugin.downloader.model.d.ale(str)) != null) {
                jgVar2.dNZ.dNI = ale.field_appId;
            }
            AppMethodBeat.o(88832);
            return false;
        }
    };

    public interface b {
        void O(int i2, long j2);
    }

    public interface c {
        void ag(Bundle bundle);
    }

    static /* synthetic */ void Ck(long j2) {
        AppMethodBeat.i(177456);
        N(9, j2);
        AppMethodBeat.o(177456);
    }

    static {
        AppMethodBeat.i(88848);
        AppMethodBeat.o(88848);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(88834);
        if (bVar != null) {
            qFF.add(bVar);
        }
        AppMethodBeat.o(88834);
    }

    public static void b(b bVar) {
        AppMethodBeat.i(88835);
        if (bVar != null) {
            qFF.remove(bVar);
        }
        AppMethodBeat.o(88835);
    }

    public static void a(c cVar) {
        AppMethodBeat.i(177453);
        if (cVar != null) {
            qFG.add(cVar);
        }
        AppMethodBeat.o(177453);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(177454);
        if (cVar != null) {
            qFG.remove(cVar);
        }
        AppMethodBeat.o(177454);
    }

    public static void cBn() {
        AppMethodBeat.i(88836);
        if (qFD == null) {
            qFD = new a();
        }
        if (qFE == null) {
            qFE = new C0943a((byte) 0);
        }
        f.cBv();
        com.tencent.mm.plugin.downloader.model.c.a(qFD);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        MMApplicationContext.getContext().registerReceiver(qFE, intentFilter);
        EventCenter.instance.addListener(qFH);
        AppMethodBeat.o(88836);
    }

    public static void cBo() {
        AppMethodBeat.i(88837);
        f.cBv();
        com.tencent.mm.plugin.downloader.model.c.b(qFD);
        MMApplicationContext.getContext().unregisterReceiver(qFE);
        qFD = null;
        qFE = null;
        qFF.clear();
        EventCenter.instance.removeListener(qFH);
        AppMethodBeat.o(88837);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void k(long j2, String str) {
        AppMethodBeat.i(88838);
        N(1, j2);
        AppMethodBeat.o(88838);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, String str, boolean z) {
        AppMethodBeat.i(88839);
        N(3, j2);
        AppMethodBeat.o(88839);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, int i2, boolean z) {
        AppMethodBeat.i(88840);
        N(5, j2);
        AppMethodBeat.o(88840);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bd(long j2) {
        AppMethodBeat.i(88841);
        N(4, j2);
        AppMethodBeat.o(88841);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Be(long j2) {
        AppMethodBeat.i(88842);
        N(2, j2);
        AppMethodBeat.o(88842);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void a(long j2, String str, long j3, long j4) {
        AppMethodBeat.i(192249);
        N(6, j2);
        AppMethodBeat.o(192249);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void l(long j2, String str) {
        AppMethodBeat.i(88844);
        N(7, j2);
        AppMethodBeat.o(88844);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bf(long j2) {
        AppMethodBeat.i(88845);
        N(8, j2);
        AppMethodBeat.o(88845);
    }

    private static void N(int i2, long j2) {
        AppMethodBeat.i(88846);
        Log.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", Integer.valueOf(i2), Long.valueOf(j2));
        com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
        if (Cw == null) {
            AppMethodBeat.o(88846);
            return;
        }
        for (b bVar : qFF) {
            bVar.O(i2, Cw.field_downloadId);
        }
        a(Cw, i2);
        AppMethodBeat.o(88846);
    }

    private static void a(com.tencent.mm.plugin.downloader.g.a aVar, int i2) {
        AppMethodBeat.i(177455);
        Bundle bundle = new Bundle();
        bundle.putString("appId", aVar.field_appId);
        bundle.putInt("state", aVar.field_status);
        if (aVar.field_totalSize > 0) {
            bundle.putInt("progress", (int) ((aVar.field_downloadedSize * 100) / aVar.field_totalSize));
        }
        bundle.putBoolean("downloadInWidget", aVar.field_fromDownloadApp);
        bundle.putInt("event", i2);
        ToolsProcessIPCService.a(bundle, d.class, null);
        AppMethodBeat.o(177455);
    }

    /* access modifiers changed from: package-private */
    public static class d implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(177452);
            Bundle bundle2 = bundle;
            for (c cVar : a.qFG) {
                cVar.ag(bundle2);
            }
            AppMethodBeat.o(177452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.b.a$a  reason: collision with other inner class name */
    static class C0943a extends BroadcastReceiver {
        private C0943a() {
        }

        /* synthetic */ C0943a(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            LinkedList linkedList;
            com.tencent.mm.plugin.downloader.g.a aVar;
            AppMethodBeat.i(88833);
            if (context == null || intent == null) {
                AppMethodBeat.o(88833);
                return;
            }
            String action = intent.getAction();
            Log.i("MicroMsg.DownloadEventBus", action);
            if (Util.isNullOrNil(action)) {
                Log.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
                AppMethodBeat.o(88833);
            } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                String str = "";
                try {
                    str = intent.getDataString();
                } catch (Exception e2) {
                    Log.e("MicroMsg.DownloadEventBus", "%s", Util.stackTraceToString(e2));
                }
                Log.i("MicroMsg.DownloadEventBus", "get added package name : %s", str);
                if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
                    AppMethodBeat.o(88833);
                    return;
                }
                if (str.startsWith("package:")) {
                    str = str.substring(8);
                }
                if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                    Log.e("MicroMsg.DownloadEventBus", "no user login");
                    AppMethodBeat.o(88833);
                    return;
                }
                com.tencent.mm.plugin.downloader.g.b aSU = com.tencent.mm.plugin.downloader.model.d.aSU();
                if (aSU == null) {
                    linkedList = null;
                } else if (Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                    linkedList = null;
                } else {
                    Cursor rawQuery = aSU.rawQuery("select * from FileDownloadInfo where packageName='" + str + "' order by downloadId desc", new String[0]);
                    linkedList = new LinkedList();
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            do {
                                com.tencent.mm.plugin.downloader.g.a aVar2 = new com.tencent.mm.plugin.downloader.g.a();
                                aVar2.convertFrom(rawQuery);
                                linkedList.add(aVar2);
                            } while (rawQuery.moveToNext());
                        }
                        rawQuery.close();
                    }
                }
                if (Util.isNullOrNil(linkedList)) {
                    AppMethodBeat.o(88833);
                    return;
                }
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = null;
                        break;
                    }
                    aVar = (com.tencent.mm.plugin.downloader.g.a) it.next();
                    if (aVar.field_fileType == 1) {
                        break;
                    }
                }
                if (aVar != null) {
                    a.Ck(aVar.field_downloadId);
                }
                AppMethodBeat.o(88833);
            } else {
                AppMethodBeat.o(88833);
            }
        }
    }
}
