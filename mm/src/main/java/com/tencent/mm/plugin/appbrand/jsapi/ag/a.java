package com.tencent.mm.plugin.appbrand.jsapi.ag;

import android.util.ArrayMap;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.i;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends i {
    private final AppBrandRuntime kEc;
    private final String mAppId;
    public final c mIF;
    private volatile boolean mIG;
    public volatile AbstractC0602a mIH = null;
    private volatile boolean mII = true;
    private volatile com.tencent.luggage.xweb_ext.extendplugin.component.i mIJ = null;
    private final Object mIK = new Object();
    private final Map<com.tencent.luggage.xweb_ext.extendplugin.component.i, Boolean> mIL = new ArrayMap();
    private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> mIM = new ArrayList();
    private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> mIN = new ArrayList();
    private final LinkedList<com.tencent.luggage.xweb_ext.extendplugin.component.i> mIO = new LinkedList<>();
    public AtomicBoolean mIP = new AtomicBoolean(false);
    public AtomicBoolean mIQ = new AtomicBoolean(false);

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.a$a  reason: collision with other inner class name */
    public interface AbstractC0602a {
        void byV();

        void byW();
    }

    public a(AppBrandRuntime appBrandRuntime) {
        boolean z = true;
        AppMethodBeat.i(215768);
        this.kEc = appBrandRuntime;
        this.mAppId = appBrandRuntime.mAppId;
        this.mIF = new c(this);
        this.mIG = appBrandRuntime.mResumed ? false : z;
        h.a(this.mAppId, new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onCreate() {
                AppMethodBeat.i(215763);
                super.onCreate();
                Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
                a.this.mIG = false;
                AppMethodBeat.o(215763);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onResume() {
                AppMethodBeat.i(215764);
                super.onResume();
                Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
                a.b(a.this);
                AppMethodBeat.o(215764);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void a(h.d dVar) {
                AppMethodBeat.i(215765);
                super.a(dVar);
                Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(dVar)));
                a.this.c(dVar);
                AppMethodBeat.o(215765);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(215766);
                super.onDestroy();
                Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
                a.this.bLX();
                AppMethodBeat.o(215766);
            }
        });
        AppMethodBeat.o(215768);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.i
    public final boolean bzc() {
        boolean z;
        AppMethodBeat.i(215769);
        synchronized (this.mIK) {
            try {
                z = !this.mIO.isEmpty();
            } finally {
                AppMethodBeat.o(215769);
            }
        }
        return z;
    }

    public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(215770);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + iVar.getName() + ", pauseType: " + h.Uc(this.mAppId));
        synchronized (this.mIK) {
            try {
                z = !this.mIO.isEmpty() && iVar == this.mIO.getFirst();
            } catch (Throwable th) {
                AppMethodBeat.o(215770);
                throw th;
            }
        }
        if (!z || !this.mIQ.getAndSet(false)) {
            z2 = z;
        } else {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
        }
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(z2)));
        AppMethodBeat.o(215770);
        return z2;
    }

    public final com.tencent.luggage.xweb_ext.extendplugin.component.i bLP() {
        AppMethodBeat.i(215771);
        com.tencent.luggage.xweb_ext.extendplugin.component.i iVar = this.mIJ;
        if (iVar != null && this.mIQ.get()) {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
            iVar = null;
        }
        AppMethodBeat.o(215771);
        return iVar;
    }

    public final String bLQ() {
        AppMethodBeat.i(215772);
        com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = bLP();
        if (bLP == null) {
            AppMethodBeat.o(215772);
            return null;
        }
        String k = k(bLP);
        AppMethodBeat.o(215772);
        return k;
    }

    public final String bLR() {
        AppMethodBeat.i(215773);
        com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = bLP();
        if (bLP == null) {
            AppMethodBeat.o(215773);
            return null;
        }
        String l = l(bLP);
        AppMethodBeat.o(215773);
        return l;
    }

    public final boolean bLS() {
        AppMethodBeat.i(215774);
        Log.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.mII);
        boolean z = this.mII;
        AppMethodBeat.o(215774);
        return z;
    }

    public final boolean b(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        boolean z = false;
        AppMethodBeat.i(215775);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", iVar.getName(), Boolean.TRUE);
        if (this.mIG) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
            AppMethodBeat.o(215775);
            return false;
        }
        synchronized (this.mIK) {
            try {
                this.mIL.put(iVar, Boolean.TRUE);
                if (this.mIN.contains(iVar)) {
                    this.mIN.remove(iVar);
                    this.mIO.remove(iVar);
                    this.mIO.addFirst(iVar);
                    z = true;
                } else {
                    this.mIM.remove(iVar);
                    this.mIM.add(iVar);
                }
            } finally {
                AppMethodBeat.o(215775);
            }
        }
        if (z) {
            g(iVar);
        }
        return true;
    }

    public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(215776);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + iVar.getName());
        synchronized (this.mIK) {
            try {
                this.mIL.remove(iVar);
                com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = bLP();
                if (this.mIO.contains(iVar) || bLP == iVar) {
                    this.mIO.remove(iVar);
                    if (bLP == iVar) {
                        z2 = false;
                        z = true;
                    } else {
                        z2 = true;
                        z = false;
                    }
                } else {
                    this.mIM.remove(iVar);
                    z2 = false;
                    z = false;
                }
            } finally {
                AppMethodBeat.o(215776);
            }
        }
        if (z) {
            bLV();
            bLX();
            this.mIF.bLZ();
            this.mIJ = null;
        }
        if (z2) {
            h(iVar);
        }
    }

    public final void d(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215777);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + iVar.getName());
        boolean z = false;
        synchronized (this.mIK) {
            try {
                if (this.mIM.contains(iVar)) {
                    this.mIM.remove(iVar);
                    z = true;
                    this.mIO.remove(iVar);
                    this.mIO.addFirst(iVar);
                } else {
                    this.mIN.remove(iVar);
                    this.mIN.add(iVar);
                }
            } finally {
                AppMethodBeat.o(215777);
            }
        }
        if (z && m(iVar)) {
            g(iVar);
        }
        if (this.mIG && bLP() != null) {
            bLW();
        }
    }

    public final void e(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215778);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + iVar.getName());
        synchronized (this.mIK) {
            try {
                if (this.mIO.contains(iVar)) {
                    this.mIO.remove(iVar);
                    this.mIM.add(iVar);
                } else {
                    this.mIN.remove(iVar);
                }
            } finally {
                AppMethodBeat.o(215778);
            }
        }
        if (bLP() == iVar) {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
            bLX();
            if (!this.mII) {
                this.mIF.bLZ();
                this.mIJ = null;
            }
        }
    }

    public final void f(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215779);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + iVar.getName());
        synchronized (this.mIK) {
            try {
                this.mIM.remove(iVar);
                this.mIN.remove(iVar);
                this.mIO.remove(iVar);
            } finally {
                AppMethodBeat.o(215779);
            }
        }
        if (bLP() == iVar) {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
            bLX();
            if (!this.mII) {
                this.mIF.bLZ();
                this.mIJ = null;
            }
        }
    }

    public final void bLT() {
        AppMethodBeat.i(215780);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
        com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = bLP();
        if (bLP == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
            AppMethodBeat.o(215780);
            return;
        }
        if (i(bLP)) {
            this.mII = false;
            this.mIF.requestFocus();
            AbstractC0602a aVar = this.mIH;
            if (aVar != null) {
                aVar.byV();
            }
        }
        AppMethodBeat.o(215780);
    }

    public final void bLU() {
        AppMethodBeat.i(215781);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
        com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = bLP();
        if (bLP == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
            AppMethodBeat.o(215781);
            return;
        }
        if (j(bLP)) {
            this.mII = true;
            AbstractC0602a aVar = this.mIH;
            if (aVar != null) {
                aVar.byW();
            }
        }
        AppMethodBeat.o(215781);
    }

    public final void bLV() {
        AppMethodBeat.i(215782);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
        com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = bLP();
        if (bLP == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
            AppMethodBeat.o(215782);
            return;
        }
        if (j(bLP)) {
            this.mII = false;
            this.mIF.bLZ();
        }
        AppMethodBeat.o(215782);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        r5.mIJ = r0;
        r1 = bLY();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1) != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        bLV();
        com.tencent.f.h.RTc.aV(new com.tencent.mm.plugin.appbrand.jsapi.ag.a.AnonymousClass2(r5));
        com.tencent.matrix.trace.core.AppMethodBeat.o(215783);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        r5.mIF.requestFocus();
        r5.mII = false;
        g(r0);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
        bLW();
        com.tencent.matrix.trace.core.AppMethodBeat.o(215783);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.tencent.mm.plugin.appbrand.h.d r6) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.a.c(com.tencent.mm.plugin.appbrand.h$d):void");
    }

    private void g(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215784);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + iVar.getName());
        m mVar = (m) iVar.X(m.class);
        if (mVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
            AppMethodBeat.o(215784);
            return;
        }
        mVar.playAudio();
        d(iVar);
        AppMethodBeat.o(215784);
    }

    private void h(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215785);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + iVar.getName());
        m mVar = (m) iVar.X(m.class);
        if (mVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
            AppMethodBeat.o(215785);
            return;
        }
        mVar.PF();
        d(iVar);
        AppMethodBeat.o(215785);
    }

    private static boolean i(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215786);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + iVar.getName());
        n nVar = (n) iVar.X(n.class);
        if (nVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
            AppMethodBeat.o(215786);
            return false;
        }
        nVar.start();
        AppMethodBeat.o(215786);
        return true;
    }

    private static boolean j(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215787);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + iVar.getName());
        n nVar = (n) iVar.X(n.class);
        if (nVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
            AppMethodBeat.o(215787);
            return false;
        }
        nVar.pause();
        AppMethodBeat.o(215787);
        return true;
    }

    private static String k(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215788);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + iVar.getName());
        l lVar = (l) iVar.X(l.class);
        if (lVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
            AppMethodBeat.o(215788);
            return null;
        }
        String title = lVar.getTitle();
        AppMethodBeat.o(215788);
        return title;
    }

    private static String l(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        AppMethodBeat.i(215789);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + iVar.getName());
        l lVar = (l) iVar.X(l.class);
        if (lVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
            AppMethodBeat.o(215789);
            return null;
        }
        String PE = lVar.PE();
        AppMethodBeat.o(215789);
        return PE;
    }

    private void bLW() {
        AppMethodBeat.i(215790);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a();
        aVar.mJH.appId = this.mAppId;
        aVar.mJH.beL = 8;
        aVar.mJH.dDe = 1;
        EventCenter.instance.publish(aVar);
        AppMethodBeat.o(215790);
    }

    public final void bLX() {
        AppMethodBeat.i(215791);
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.a();
        aVar.mJH.appId = this.mAppId;
        aVar.mJH.beL = 8;
        aVar.mJH.dDe = 2;
        EventCenter.instance.publish(aVar);
        AppMethodBeat.o(215791);
    }

    private boolean m(com.tencent.luggage.xweb_ext.extendplugin.component.i iVar) {
        Boolean bool;
        AppMethodBeat.i(215792);
        synchronized (this.mIK) {
            try {
                bool = this.mIL.get(iVar);
            } catch (Throwable th) {
                AppMethodBeat.o(215792);
                throw th;
            }
        }
        if (bool == null || !bool.booleanValue()) {
            AppMethodBeat.o(215792);
            return false;
        }
        AppMethodBeat.o(215792);
        return true;
    }

    private String bLY() {
        AppMethodBeat.i(215793);
        c cVar = (c) this.kEc.aw(c.class);
        if (cVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
            AppMethodBeat.o(215793);
            return null;
        }
        String bMg = cVar.bMg();
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", bMg);
        AppMethodBeat.o(215793);
        return bMg;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(215794);
        aVar.mIG = false;
        if (aVar.mIP.getAndSet(false)) {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeForeground, ignore");
            AppMethodBeat.o(215794);
            return;
        }
        com.tencent.luggage.xweb_ext.extendplugin.component.i bLP = aVar.bLP();
        if (bLP == null) {
            AppMethodBeat.o(215794);
            return;
        }
        if (!aVar.m(bLP)) {
            aVar.h(bLP);
        }
        aVar.mII = false;
        aVar.mIF.bLZ();
        aVar.mIJ = null;
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeForeground, disableAppBrandBackgroundRun");
        aVar.bLX();
        AppMethodBeat.o(215794);
    }
}
