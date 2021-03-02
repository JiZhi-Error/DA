package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.b;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private static Boolean pAC = null;
    private static Boolean pAD = null;
    private static HashSet<Long> pAw = new HashSet<>();
    private static HashSet<String> pAx = new HashSet<>();
    private boolean pAA = false;
    public boolean pAB = false;
    private int pAt;
    private int pAu;
    public int pAv = 0;
    public List<z> pAy = new LinkedList();
    private List<z> pAz;
    public BizTimeLineUI pro;

    static /* synthetic */ z d(d dVar) {
        AppMethodBeat.i(6179);
        z cnA = dVar.cnA();
        AppMethodBeat.o(6179);
        return cnA;
    }

    static /* synthetic */ int e(d dVar) {
        int i2 = dVar.pAv;
        dVar.pAv = i2 - 1;
        return i2;
    }

    static {
        AppMethodBeat.i(6181);
        AppMethodBeat.o(6181);
    }

    public d(BizTimeLineUI bizTimeLineUI, int i2, int i3, List<z> list) {
        AppMethodBeat.i(6160);
        this.pro = bizTimeLineUI;
        this.pAt = i2;
        this.pAu = i3;
        this.pAz = list;
        if (this.pAz.size() <= 10) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.AnonymousClass1 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(6154);
                    d.this.onLoadMore();
                    AppMethodBeat.o(6154);
                    return false;
                }
            });
        }
        AppMethodBeat.o(6160);
    }

    public final void a(long j2, int i2, v vVar, String str, ImageView imageView, int i3, int i4, boolean z, m.a aVar, boolean z2, int i5) {
        AppMethodBeat.i(6161);
        imageView.setContentDescription(this.pro.getString(R.string.az3));
        String u = b.u(str, 1);
        g gVar = g.Kev;
        if (g.aig(1)) {
            a aVar2 = a.JUl;
            a.n(j2, i2, vVar.url);
        }
        int i6 = z2 ? R.drawable.c06 : 0;
        int i7 = z2 ? R.drawable.hu : R.drawable.hy;
        float fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix((Context) this.pro, 8);
        com.tencent.mm.pluginsdk.model.b bVar = com.tencent.mm.pluginsdk.model.b.JUJ;
        c.a aVar3 = new c.a();
        aVar3.jbt = i7;
        aVar3.jbf = true;
        c.a dr = aVar3.dr(i3, i4);
        dr.jbv = String.valueOf(i6);
        dr.jaU = new n(1);
        dr.jbC = new e(1);
        dr.jbD = new l();
        dr.fullPath = s.bdu(u);
        com.tencent.mm.pluginsdk.model.b.a(j2, i2, vVar, u, imageView, i5, z, dr.bdv(), new m(1, i3, i4, false, z2, fromDPToPix, aVar));
        AppMethodBeat.o(6161);
    }

    public final void a(long j2, int i2, v vVar, String str, ImageView imageView, int i3, int i4, boolean z, m.a aVar, int i5, float f2) {
        AppMethodBeat.i(195022);
        imageView.setContentDescription(this.pro.getString(R.string.az3));
        String u = b.u(str, 1);
        g gVar = g.Kev;
        if (g.aig(1)) {
            a aVar2 = a.JUl;
            a.n(j2, i2, vVar.url);
        }
        com.tencent.mm.pluginsdk.model.b bVar = com.tencent.mm.pluginsdk.model.b.JUJ;
        c.a aVar3 = new c.a();
        aVar3.jbt = R.color.j6;
        aVar3.jbf = true;
        c.a dr = aVar3.dr(i3, i4);
        dr.jbv = "2131231315";
        dr.jaU = new n(1);
        dr.jbC = new e(1);
        dr.jbD = new l();
        dr.fullPath = s.bdu(u);
        com.tencent.mm.pluginsdk.model.b.a(j2, i2, vVar, u, imageView, i5, z, dr.bdv(), new m(1, i3, i4, true, true, f2, aVar));
        AppMethodBeat.o(195022);
    }

    public final void a(String str, ImageView imageView, int i2, int i3, int i4) {
        AppMethodBeat.i(195023);
        imageView.setContentDescription(this.pro.getString(R.string.az3));
        com.tencent.mm.pluginsdk.model.b bVar = com.tencent.mm.pluginsdk.model.b.JUJ;
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbq = R.color.j6;
        c.a dr = aVar.dr(i2, i3);
        dr.jbi = 4;
        com.tencent.mm.pluginsdk.model.b.a(-1, -1, null, str, imageView, i4, false, dr.bdv(), new m());
        AppMethodBeat.o(195023);
    }

    public final int getContentWidth() {
        AppMethodBeat.i(6163);
        int jn = com.tencent.mm.cb.a.jn(this.pro) - com.tencent.mm.plugin.brandservice.ui.timeline.b.prD;
        AppMethodBeat.o(6163);
        return jn;
    }

    public final void cnz() {
        AppMethodBeat.i(6164);
        if (!cnC()) {
            AppMethodBeat.o(6164);
        } else if (this.pAA || this.pAB) {
            Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", Boolean.valueOf(this.pAA), Boolean.valueOf(this.pAB));
            AppMethodBeat.o(6164);
        } else {
            this.pAA = true;
            Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
            com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(6155);
                    d.this.pAA = false;
                    if (d.this.pro == null || d.this.pro.isFinishing()) {
                        AppMethodBeat.o(6155);
                    } else if (d.cnD() && !NetStatusUtil.isWifi(d.this.pro)) {
                        AppMethodBeat.o(6155);
                    } else if (!d.c(d.this)) {
                        Log.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
                        AppMethodBeat.o(6155);
                    } else {
                        z d2 = d.d(d.this);
                        if (d2 == null) {
                            Log.v("MicroMsg.BizTimeLineImgLoader", "not loading");
                            AppMethodBeat.o(6155);
                            return;
                        }
                        d.a(d.this, d2);
                        AppMethodBeat.o(6155);
                    }
                }
            }, 500);
            AppMethodBeat.o(6164);
        }
    }

    private boolean a(v vVar, String str, final long j2, final int i2, boolean z) {
        AppMethodBeat.i(6165);
        if (a(str, j2, i2)) {
            AppMethodBeat.o(6165);
            return false;
        }
        Log.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.pro);
        this.pAv++;
        if (i2 != 0 || !z) {
            a(j2, i2, vVar, str, imageView, this.pAu, this.pAu, true, (m.a) new m.a() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                public final void onFinish() {
                    AppMethodBeat.i(6157);
                    d.e(d.this);
                    d.this.m(j2, i2);
                    AppMethodBeat.o(6157);
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                public final void onStart() {
                }
            }, -1, 2.0f);
        } else {
            a(j2, i2, vVar, str, imageView, getContentWidth(), this.pAt, true, (m.a) new m.a() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.AnonymousClass3 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                public final void onFinish() {
                    AppMethodBeat.i(6156);
                    d.e(d.this);
                    d.this.m(j2, i2);
                    AppMethodBeat.o(6156);
                }

                @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
                public final void onStart() {
                }
            }, false, -1);
        }
        AppMethodBeat.o(6165);
        return true;
    }

    private static void BG(long j2) {
        AppMethodBeat.i(6166);
        pAw.add(Long.valueOf(j2));
        AppMethodBeat.o(6166);
    }

    public final void m(long j2, int i2) {
        AppMethodBeat.i(6168);
        Log.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", Integer.valueOf(this.pAv));
        pAx.add(j2 + "_" + i2);
        if (this.pAv <= 0) {
            cnz();
        }
        AppMethodBeat.o(6168);
    }

    private static boolean a(String str, long j2, int i2) {
        AppMethodBeat.i(6169);
        if (pAx.contains(j2 + "_" + i2)) {
            AppMethodBeat.o(6169);
            return true;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(6169);
            return false;
        } else if (!com.tencent.mm.vfs.s.YS(s.bdu(b.u(str, 1)))) {
            AppMethodBeat.o(6169);
            return false;
        } else {
            pAx.add(j2 + "_" + i2);
            AppMethodBeat.o(6169);
            return true;
        }
    }

    public static String OO(String str) {
        AppMethodBeat.i(259585);
        String u = b.u(str, 1);
        AppMethodBeat.o(259585);
        return u;
    }

    public final void onLoadMore() {
        AppMethodBeat.i(6171);
        if (!cnC()) {
            AppMethodBeat.o(6171);
            return;
        }
        com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(6159);
                if (d.this.pro == null || d.this.pro.isFinishing()) {
                    AppMethodBeat.o(6159);
                    return;
                }
                z cnB = d.this.cnB();
                if (cnB == null) {
                    AppMethodBeat.o(6159);
                    return;
                }
                final List<z> aU = ag.ban().aU(5, cnB.field_orderFlag);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(6158);
                        d.this.pAy.clear();
                        d.this.pAy.addAll(aU);
                        AppMethodBeat.o(6158);
                    }
                });
                AppMethodBeat.o(6159);
            }
        }, 0);
        AppMethodBeat.o(6171);
    }

    public final z cnB() {
        AppMethodBeat.i(6172);
        try {
            if (this.pAz.size() > 0) {
                z zVar = this.pAz.get(this.pAz.size() - 1);
                AppMethodBeat.o(6172);
                return zVar;
            }
        } catch (Throwable th) {
            Log.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", th.getMessage());
        }
        AppMethodBeat.o(6172);
        return null;
    }

    private z De(int i2) {
        AppMethodBeat.i(6173);
        try {
            if (i2 < this.pAz.size()) {
                z zVar = this.pAz.get(i2);
                AppMethodBeat.o(6173);
                return zVar;
            }
            if (i2 < this.pAz.size() + this.pAy.size()) {
                z zVar2 = this.pAy.get(i2 - this.pAz.size());
                AppMethodBeat.o(6173);
                return zVar2;
            }
            AppMethodBeat.o(6173);
            return null;
        } catch (Throwable th) {
            Log.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", th.getMessage());
        }
    }

    public static boolean a(z zVar, v vVar) {
        AppMethodBeat.i(6174);
        if (zVar == null || vVar == null) {
            AppMethodBeat.o(6174);
            return false;
        }
        boolean a2 = com.tencent.mm.plugin.brandservice.ui.b.a.a(zVar, vVar);
        AppMethodBeat.o(6174);
        return a2;
    }

    private static boolean cnC() {
        AppMethodBeat.i(6175);
        if (pAC == null) {
            cnE();
        }
        boolean booleanValue = pAC.booleanValue();
        AppMethodBeat.o(6175);
        return booleanValue;
    }

    public static boolean cnD() {
        AppMethodBeat.i(6176);
        if (pAD == null) {
            cnE();
        }
        boolean booleanValue = pAD.booleanValue();
        AppMethodBeat.o(6176);
        return booleanValue;
    }

    private static void cnE() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(6177);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_preload_img, 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        pAC = Boolean.valueOf(z);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_preload_img_in_wifi, 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        pAD = Boolean.valueOf(z2);
        Log.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", pAC, pAD);
        AppMethodBeat.o(6177);
    }

    private z cnA() {
        AppMethodBeat.i(6167);
        int i2 = 0;
        while (i2 < this.pAz.size() + this.pAy.size()) {
            try {
                z De = De(i2);
                if (De == null || !De.gAt() || De.field_isRead == 1 || pAw.contains(Long.valueOf(De.field_msgId))) {
                    i2++;
                    BG(De.field_msgId);
                } else {
                    Log.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", Integer.valueOf(i2), Long.valueOf(De.field_msgId));
                    AppMethodBeat.o(6167);
                    return De;
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(6167);
        return null;
    }

    static /* synthetic */ boolean c(d dVar) {
        AppMethodBeat.i(6178);
        int firstVisiblePosition = dVar.pro.psJ.getFirstVisiblePosition();
        int lastVisiblePosition = dVar.pro.psJ.getLastVisiblePosition();
        int i2 = firstVisiblePosition > 0 ? firstVisiblePosition - 1 : 0;
        int i3 = lastVisiblePosition > 0 ? lastVisiblePosition - 1 : 0;
        for (int i4 = i2; i4 <= i3; i4++) {
            z De = dVar.De(i4);
            if (De != null && De.gAt() && !pAw.contains(Long.valueOf(De.field_msgId))) {
                LinkedList linkedList = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(De.field_msgId, De.field_content).iAd;
                if (!Util.isNullOrNil(linkedList)) {
                    int size = linkedList.size();
                    int i5 = (De.field_isExpand || size <= 2) ? size : 2;
                    for (int i6 = 0; i6 < i5; i6++) {
                        v vVar = (v) linkedList.get(i6);
                        if (!Util.isNullOrNil(vVar.iAo)) {
                            if (i6 == 0) {
                                if (!a(vVar.iAo, De.field_msgId, i6) && !a(com.tencent.mm.ag.m.a(vVar), De.field_msgId, i6)) {
                                    AppMethodBeat.o(6178);
                                    return false;
                                }
                            } else if (!a(vVar.iAo, De.field_msgId, i6)) {
                                AppMethodBeat.o(6178);
                                return false;
                            }
                        }
                    }
                    if (De.field_isExpand || linkedList.size() <= 2) {
                        BG(De.field_msgId);
                    }
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.o(6178);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d r11, com.tencent.mm.storage.z r12) {
        /*
        // Method dump skipped, instructions count: 370
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d, com.tencent.mm.storage.z):void");
    }
}
