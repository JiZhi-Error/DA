package com.tencent.mm.plugin.downloader_app.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.a.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends FloatBallHelper {
    private static LinkedList<com.tencent.mm.plugin.downloader_app.api.e> qKR = new LinkedList<>();
    public com.tencent.mm.plugin.ball.c.e lqt;
    LinkedList<String> qKP;
    LinkedList<String> qKQ;
    boolean qKS;
    public a.b qKT;
    boolean qKU;

    /* synthetic */ e(byte b2) {
        this();
    }

    static /* synthetic */ String b(e eVar) {
        AppMethodBeat.i(175269);
        String cBZ = eVar.cBZ();
        AppMethodBeat.o(175269);
        return cBZ;
    }

    static class a {
        static e qKX = new e((byte) 0);

        static {
            AppMethodBeat.i(175264);
            AppMethodBeat.o(175264);
        }
    }

    public static e cBX() {
        return a.qKX;
    }

    static {
        AppMethodBeat.i(183808);
        AppMethodBeat.o(183808);
    }

    private e() {
        AppMethodBeat.i(175265);
        this.qKP = new LinkedList<>();
        this.qKQ = new LinkedList<>();
        this.qKS = false;
        this.qKT = new a.b() {
            /* class com.tencent.mm.plugin.downloader_app.a.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader.b.a.b
            public final void O(int i2, long j2) {
                com.tencent.mm.plugin.downloader.g.a alb;
                AppMethodBeat.i(175257);
                com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
                if (Cw == null || !Cw.field_fromDownloadApp) {
                    AppMethodBeat.o(175257);
                    return;
                }
                e eVar = e.this;
                String str = Cw.field_appId;
                if (i2 == 1 || i2 == 7) {
                    Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskStart");
                    e.lb(false);
                    eVar.qKS = false;
                    if (!eVar.qKP.contains(str)) {
                        eVar.qKP.add(str);
                    }
                    if (!eVar.qKQ.contains(str) && (alb = d.alb(str)) != null && (alb.field_autoDownload || alb.field_reserveInWifi)) {
                        eVar.qKQ.add(str);
                    }
                    Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskStart, isInDownloadMainUI:%s", Boolean.valueOf(eVar.qKU));
                    if (!eVar.ciq()) {
                        Log.i("MicroMsg.GameDownloadFloatBallHelper", "addCurrentBall");
                        if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()) || !eVar.qKQ.contains(str)) {
                            eVar.BH(com.tencent.mm.plugin.ball.f.d.eV(eVar.oWE.state, 16));
                            eVar.cis();
                        }
                    }
                    eVar.jU(eVar.qKU);
                    eVar.cBY();
                    eVar.updateTitle();
                    f.a(MMApplicationContext.getContext(), 34, 3402, 0, 1, 0, eVar.cBZ());
                    AppMethodBeat.o(175257);
                } else if (i2 == 6) {
                    if (!eVar.qKS) {
                        if (!eVar.qKP.contains(str)) {
                            eVar.qKP.add(str);
                        }
                        eVar.jU(eVar.qKU);
                        Log.i("MicroMsg.GameDownloadFloatBallHelper", "onProgressChanged, isInDownloadMainUI:%s", Boolean.valueOf(eVar.qKU));
                        if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()) && !eVar.ciq()) {
                            eVar.BH(com.tencent.mm.plugin.ball.f.d.eV(eVar.oWE.state, 16));
                            eVar.cis();
                            eVar.updateTitle();
                        }
                        eVar.cBY();
                    }
                    AppMethodBeat.o(175257);
                } else if (i2 == 5) {
                    eVar.aN(str, true);
                    AppMethodBeat.o(175257);
                } else {
                    eVar.aN(str, false);
                    AppMethodBeat.o(175257);
                }
            }
        };
        this.qKU = false;
        this.lqt = new com.tencent.mm.plugin.ball.c.f() {
            /* class com.tencent.mm.plugin.downloader_app.a.e.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
            public final void b(BallInfo ballInfo) {
                AppMethodBeat.i(175261);
                Intent intent = new Intent();
                intent.putExtra("from_scene", 2);
                ((c) g.af(c.class)).a(MMApplicationContext.getContext(), intent, (a.c) null);
                f.a(MMApplicationContext.getContext(), 34, 3403, 1, 6, 0, e.b(e.this));
                AppMethodBeat.o(175261);
            }

            @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
            public final void c(BallInfo ballInfo) {
                AppMethodBeat.i(175262);
                if (e.this.qKP.isEmpty()) {
                    AppMethodBeat.o(175262);
                    return;
                }
                f.a(MMApplicationContext.getContext(), 34, 3403, 2, 21, 0, e.b(e.this));
                ((c) g.af(c.class)).cBS();
                e.this.qKP.clear();
                e.lb(true);
                AppMethodBeat.o(175262);
            }

            @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
            public final void d(BallInfo ballInfo) {
                AppMethodBeat.i(175263);
                f.a(MMApplicationContext.getContext(), 34, 3403, 0, 1, 0, e.b(e.this));
                AppMethodBeat.o(175263);
            }
        };
        G(16, "GameDownloadFloatBall");
        ciw().hDa = 11;
        jT(true);
        cit();
        com.tencent.mm.plugin.ball.a.d dVar = d.a.oWb;
        dVar.oWa.put(16, new com.tencent.mm.plugin.ball.a.c() {
            /* class com.tencent.mm.plugin.downloader_app.a.e.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.ball.a.b, com.tencent.mm.plugin.ball.a.c
            public final boolean a(Context context, BallInfo ballInfo) {
                AppMethodBeat.i(175259);
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("game_download_float_ball");
                StringBuilder sb = new StringBuilder("game_download_first_");
                g.aAf();
                boolean z = singleMMKV.getBoolean(sb.append(com.tencent.mm.kernel.a.ayV()).toString(), true);
                String str = e.this.qKP.size() > 0 ? (String) e.this.qKP.get(0) : "";
                if (z) {
                    com.tencent.mm.game.report.api.a.hhr.c(str, 7, 0, null, "");
                    MultiProcessMMKV singleMMKV2 = MultiProcessMMKV.getSingleMMKV("game_download_float_ball");
                    StringBuilder sb2 = new StringBuilder("game_download_first_");
                    g.aAf();
                    singleMMKV2.putBoolean(sb2.append(com.tencent.mm.kernel.a.ayV()).toString(), false).commit();
                }
                AppMethodBeat.o(175259);
                return false;
            }

            @Override // com.tencent.mm.plugin.ball.a.b, com.tencent.mm.plugin.ball.a.c
            public final boolean a(final TextView textView, final BallInfo ballInfo) {
                AppMethodBeat.i(175260);
                textView.post(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader_app.a.e.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(175258);
                        Log.i("MicroMsg.GameDownloadFloatBallHelper", "onBallNameTextViewSet");
                        Layout layout = textView.getLayout();
                        if (layout == null) {
                            Log.e("MicroMsg.GameDownloadFloatBallHelper", "onBallNameTextViewSet layout null");
                            AppMethodBeat.o(175258);
                            return;
                        }
                        int lineCount = layout.getLineCount();
                        if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0 && e.this.qKP.size() > 1) {
                            Log.i("MicroMsg.GameDownloadFloatBallHelper", "ellipsis");
                            TextPaint paint = textView.getPaint();
                            int lineEnd = layout.getLineEnd(0);
                            String format = String.format("...等%d个游戏", Integer.valueOf(e.this.qKP.size()));
                            String substring = ballInfo.name.substring(lineEnd);
                            int measureText = (int) paint.measureText(".");
                            int measureText2 = (int) paint.measureText(substring);
                            int measureText3 = (int) paint.measureText(format);
                            while (measureText2 + measureText3 + (measureText * 3) > layout.getEllipsizedWidth() && substring.length() > 0) {
                                substring = substring.substring(0, substring.length() - 1);
                                measureText2 = (int) paint.measureText(substring);
                            }
                            e.this.agT(ballInfo.name.substring(0, lineEnd) + substring + format);
                        }
                        AppMethodBeat.o(175258);
                    }
                });
                AppMethodBeat.o(175260);
                return false;
            }
        });
        AppMethodBeat.o(175265);
    }

    /* access modifiers changed from: package-private */
    public final void aN(String str, boolean z) {
        AppMethodBeat.i(183803);
        this.qKP.remove(str);
        this.qKQ.remove(str);
        if (this.qKP.isEmpty()) {
            this.qKS = true;
            cir();
            if (z) {
                lb(true);
            }
            AppMethodBeat.o(183803);
            return;
        }
        jU(this.qKU);
        Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskFinished, isInDownloadMainUI:%s", Boolean.valueOf(this.qKU));
        cBY();
        updateTitle();
        AppMethodBeat.o(183803);
    }

    /* access modifiers changed from: package-private */
    public final void cBY() {
        AppMethodBeat.i(175266);
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.qKP.iterator();
        long j2 = 0;
        long j3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            com.tencent.mm.plugin.downloader.g.a alb = com.tencent.mm.plugin.downloader.model.d.alb(next);
            if (alb == null || alb.field_status != 1) {
                linkedList.add(next);
            } else {
                j3 += alb.field_downloadedSize;
                j2 = alb.field_totalSize + j2;
            }
        }
        if (j2 > 0) {
            Bz((100 * j3) / j2);
        }
        if (linkedList.size() > 0) {
            this.qKP.remove(linkedList);
        }
        AppMethodBeat.o(175266);
    }

    /* access modifiers changed from: package-private */
    public final void updateTitle() {
        AppMethodBeat.i(175267);
        int size = this.qKP.size();
        if (size > 0) {
            StringBuilder sb = new StringBuilder();
            if (this.qKQ.size() > 0) {
                sb.append(MMApplicationContext.getResources().getString(R.string.akg));
            }
            for (int i2 = size - 1; i2 > 0; i2--) {
                com.tencent.mm.pluginsdk.model.app.g o = h.o(this.qKP.get(i2), true, false);
                if (o != null) {
                    sb.append(o.field_appName).append("、");
                }
            }
            com.tencent.mm.pluginsdk.model.app.g o2 = h.o(this.qKP.get(0), true, false);
            if (o2 != null) {
                sb.append(o2.field_appName);
            }
            String sb2 = sb.toString();
            Log.i("MicroMsg.GameDownloadFloatBallHelper", "updateTitle, name = %s, length : %d", sb2, Integer.valueOf(sb2.length()));
            agT(sb2);
        }
        AppMethodBeat.o(175267);
    }

    /* access modifiers changed from: package-private */
    public final String cBZ() {
        AppMethodBeat.i(175268);
        if (this.qKP.isEmpty()) {
            AppMethodBeat.o(175268);
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("gamenum", String.valueOf(this.qKP.size()));
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.qKP.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("_");
        }
        sb.deleteCharAt(sb.length() - 1);
        hashMap.put("appidg", sb.toString());
        String u = com.tencent.mm.game.report.e.a.u(hashMap);
        AppMethodBeat.o(175268);
        return u;
    }

    public static void lb(boolean z) {
        AppMethodBeat.i(183804);
        MultiProcessMMKV.getMMKV("download_app").putBoolean("show_red_dot", z).apply();
        MultiProcessMMKV.getMMKV("download_app").putLong("red_dot_create_time", System.currentTimeMillis()).apply();
        Iterator<com.tencent.mm.plugin.downloader_app.api.e> it = qKR.iterator();
        while (it.hasNext()) {
            it.next().onChange(z);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("show", z);
        ToolsProcessIPCService.a(bundle, b.class, null);
        AppMethodBeat.o(183804);
    }

    public static boolean cCa() {
        AppMethodBeat.i(183805);
        boolean z = MultiProcessMMKV.getMMKV("download_app").getBoolean("show_red_dot", false);
        if (z) {
            if (System.currentTimeMillis() - MultiProcessMMKV.getMMKV("download_app").getLong("red_dot_create_time", 0) > 86400) {
                MultiProcessMMKV.getMMKV("download_app").putBoolean("show_red_dot", false).apply();
                MultiProcessMMKV.getMMKV("download_app").putLong("red_dot_create_time", 0).apply();
                AppMethodBeat.o(183805);
                return false;
            }
        }
        AppMethodBeat.o(183805);
        return z;
    }

    public static void a(com.tencent.mm.plugin.downloader_app.api.e eVar) {
        AppMethodBeat.i(183806);
        qKR.add(eVar);
        AppMethodBeat.o(183806);
    }

    public static void b(com.tencent.mm.plugin.downloader_app.api.e eVar) {
        AppMethodBeat.i(183807);
        qKR.remove(eVar);
        AppMethodBeat.o(183807);
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(183802);
            boolean z = bundle.getBoolean("show");
            Iterator it = e.qKR.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.downloader_app.api.e) it.next()).onChange(z);
            }
            AppMethodBeat.o(183802);
        }
    }
}
