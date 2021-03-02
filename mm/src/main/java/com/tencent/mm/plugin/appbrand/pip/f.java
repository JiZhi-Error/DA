package com.tencent.mm.plugin.appbrand.pip;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioManager;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.pip.a;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    public final String cDW = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    public AppBrandPipContainerView kAR = null;
    final w kAs;
    public final AppBrandRuntime kEc;
    private final AudioManager mAudioManager;
    public final Context mContext;
    View nBY = null;
    volatile boolean nDd = false;
    public final Map<Integer, a> nDe = new ConcurrentHashMap();
    private Map<Integer, Set<String>> nDf = new ConcurrentHashMap();
    public b nDg = null;
    h nDh = null;
    public String nDi = null;
    t nDj = null;
    boolean nDk = true;
    a.C0785a nDl = null;
    public i.a nDm = null;
    volatile boolean nDn = false;
    boolean nDo = false;
    boolean nDp = false;
    volatile Integer nDq = null;
    boolean nDr = false;
    boolean nDs = false;
    z nDt = null;
    z nDu = null;
    private AudioManager.OnAudioFocusChangeListener nDv = null;
    public j nDw = null;
    private i nDx = null;
    public d nDy = null;
    volatile boolean nDz;

    public f(Context context, AppBrandRuntime appBrandRuntime) {
        boolean z;
        AppMethodBeat.i(219555);
        this.mContext = context;
        this.kEc = appBrandRuntime;
        this.mAudioManager = (AudioManager) context.getApplicationContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.kAs = appBrandRuntime.brh();
        if (!appBrandRuntime.mResumed) {
            z = true;
        } else {
            z = false;
        }
        this.nDz = z;
        AppMethodBeat.o(219555);
    }

    public final boolean yV(int i2) {
        AppMethodBeat.i(219556);
        Log.i(this.cDW, "exitPip, viewId: ".concat(String.valueOf(i2)));
        if (this.nDn) {
            Log.w(this.cDW, "exitPip when mPipClickProcessing, return");
            AppMethodBeat.o(219556);
            return false;
        } else if (this.nDi == null || !this.nDi.contains(String.valueOf(i2))) {
            AppMethodBeat.o(219556);
            return false;
        } else {
            if (!(this.nDl == null || this.nDy == null)) {
                this.nDy.a(this.nDl.nBX, e.EXIT_PIP_CALLED);
            }
            if (this.kAR != null) {
                this.kAR.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(219545);
                        f.a(f.this);
                        AppMethodBeat.o(219545);
                    }
                });
            }
            AppMethodBeat.o(219556);
            return true;
        }
    }

    public final void bTG() {
        AppMethodBeat.i(219557);
        if (!(this.kAR == null || this.nDw == null)) {
            if (this.nDx == null) {
                this.nDx = this.nDw.a(this.kEc.mAppId, this.kAR);
            }
            this.nDx.a(new h() {
                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.appbrand.pip.h
                public final void f(final Point point) {
                    AppMethodBeat.i(219547);
                    if (point == null) {
                        Log.i(f.this.cDW, "onPipStablePosGot, point is null");
                        AppMethodBeat.o(219547);
                        return;
                    }
                    com.tencent.f.h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(219546);
                            if (f.this.kAR != null) {
                                f.this.kAR.setStablePos(point);
                            }
                            AppMethodBeat.o(219546);
                        }
                    });
                    AppMethodBeat.o(219547);
                }
            });
        }
        AppMethodBeat.o(219557);
    }

    /* access modifiers changed from: package-private */
    public final a yW(int i2) {
        AppMethodBeat.i(219558);
        a aVar = this.nDe.get(Integer.valueOf(i2));
        if (aVar == null) {
            Log.w(this.cDW, "getPageScopedPipInfo, null == pageScopedPipInfo");
            AppMethodBeat.o(219558);
            return null;
        }
        AppMethodBeat.o(219558);
        return aVar;
    }

    public final a z(ac acVar) {
        AppMethodBeat.i(219559);
        a yW = yW(acVar.hashCode());
        AppMethodBeat.o(219559);
        return yW;
    }

    /* access modifiers changed from: package-private */
    public final boolean ix(boolean z) {
        AppMethodBeat.i(219560);
        if (this.kAR == null || this.nDh == null || this.nBY == null) {
            AppMethodBeat.o(219560);
            return false;
        }
        if (this.nDu != null) {
            z zVar = this.nDu;
            zVar.ohs.set(0);
            zVar.run();
            this.nDu = null;
        }
        AnonymousClass10 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(219548);
                Log.i(f.this.cDW, "transferFrom, dismissTask run");
                f.this.nDt = null;
                if (f.this.kAR == null || f.this.nBY == null || f.this.nDh == null) {
                    AppMethodBeat.o(219548);
                    return;
                }
                AppBrandPipContainerView appBrandPipContainerView = f.this.kAR;
                appBrandPipContainerView.okL.removeView(f.this.nBY);
                f.this.nDh.cf(f.this.nBY);
                f.this.kAR.setVisibility(4);
                f.this.nBY = null;
                f.this.nDg = null;
                AppMethodBeat.o(219548);
            }
        };
        Log.i(this.cDW, "transferFrom");
        if (z) {
            h hVar = this.nDh;
            View view = this.nBY;
            z zVar2 = new z(r1, (byte) 0);
            this.nDt = zVar2;
            hVar.e(view, zVar2);
        } else {
            this.nDh.e(this.nBY, null);
            r1.run();
        }
        AppMethodBeat.o(219560);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void y(boolean z, boolean z2) {
        AppMethodBeat.i(219561);
        Log.i(this.cDW, "clearPipVideoRelated, mayPause: " + z + ", mayDestroyPage: " + z2);
        if (!(this.nDi == null || this.nDl == null || this.nDj == null || this.nDl.nBU == null)) {
            this.nDl.nBU.hX(this.nDl.id).d(this.nDj);
        }
        String str = this.nDi;
        this.nDi = null;
        if (this.nDj != null) {
            int hashCode = this.nDj.getCurrentPageView().hashCode();
            s(hashCode, str, "clearPipVideoRelated");
            if (z2) {
                t currentPage = this.kAs.getCurrentPage();
                if (currentPage == null) {
                    Log.w(this.cDW, "clearPipVideoRelated, curPage is null");
                } else {
                    currentPage.a(bx.DISMISS_PIP, (w.h) null);
                    currentPage.b(bx.DISMISS_PIP);
                }
            }
            this.nDj.noQ = false;
            if (!(!z || this.nDl == null || this.nDl.nBW == null)) {
                this.nDl.nBW.pause();
            }
            if (z2 && !this.nDk) {
                Log.i(this.cDW, "clearPipVideoRelated, performDestroy and performCleanup");
                this.nDj.performDestroy();
                this.nDj.NR();
                if (this.nDl != null) {
                    a.C0785a aVar = this.nDl;
                    if (aVar.nBW != null) {
                        aVar.nBW.a(null);
                    }
                }
                r(hashCode, str, "clearPipVideoRelated");
            }
        }
        this.nDj = null;
        this.kAs.setPipVideoRelatedPage(null);
        this.nDk = true;
        this.nDl = null;
        AppMethodBeat.o(219561);
    }

    /* access modifiers changed from: package-private */
    public final void r(int i2, String str, String str2) {
        AppMethodBeat.i(219562);
        Set<String> set = this.nDf.get(Integer.valueOf(i2));
        if (set != null) {
            Log.i(this.cDW, str2 + ", mPageView2VideosMap remove " + str + " for " + i2);
            set.remove(str);
        }
        AppMethodBeat.o(219562);
    }

    /* access modifiers changed from: package-private */
    public final void s(int i2, String str, String str2) {
        AppMethodBeat.i(219563);
        Set<String> set = this.nDf.get(Integer.valueOf(i2));
        if (set == null) {
            set = new HashSet<>();
            this.nDf.put(Integer.valueOf(i2), set);
        }
        Log.i(this.cDW, str2 + ", mPageView2VideosMap add " + str + " for " + i2);
        set.add(str);
        AppMethodBeat.o(219563);
    }

    /* access modifiers changed from: package-private */
    public final void aeA(String str) {
        AppMethodBeat.i(219564);
        Log.d(this.cDW, str + ", abandonAudioFocus");
        this.mAudioManager.abandonAudioFocus(bTH());
        AppMethodBeat.o(219564);
    }

    private AudioManager.OnAudioFocusChangeListener bTH() {
        AppMethodBeat.i(219565);
        if (this.nDv == null) {
            this.nDv = new AudioManager.OnAudioFocusChangeListener() {
                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass6 */

                public final void onAudioFocusChange(int i2) {
                    AppMethodBeat.i(219543);
                    Log.d(f.this.cDW, "onAudioFocusChange, focusChange: ".concat(String.valueOf(i2)));
                    if (f.this.nDz) {
                        Log.i(f.this.cDW, "onAudioFocusChange, runtime paused");
                        AppMethodBeat.o(219543);
                    } else if (f.this.nDl == null) {
                        Log.d(f.this.cDW, "onAudioFocusChange, mPipVideoSession is null");
                        AppMethodBeat.o(219543);
                    } else if (f.this.nDi == null || (f.this.nDr && f.this.nDs)) {
                        Log.d(f.this.cDW, "onAudioFocusChange, mPipVideoRelatedKey is null or is transfering from");
                        AppMethodBeat.o(219543);
                    } else {
                        switch (i2) {
                            case -1:
                                f.this.aeA("onAudioFocusChange");
                            case -3:
                            case -2:
                                f.this.nDl.nBW.pause();
                                f.this.nDp = true;
                                break;
                            case 1:
                            case 2:
                            case 3:
                                f.this.nDl.nBW.start();
                                AppMethodBeat.o(219543);
                                return;
                        }
                        AppMethodBeat.o(219543);
                    }
                }
            };
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.nDv;
        AppMethodBeat.o(219565);
        return onAudioFocusChangeListener;
    }

    public static String s(t tVar) {
        AppMethodBeat.i(219566);
        if (tVar == null) {
            AppMethodBeat.o(219566);
            return BuildConfig.COMMAND;
        }
        String str = tVar.getClass().getSimpleName() + "@" + tVar.hashCode() + "(" + tVar.getCurrentUrl() + ")";
        AppMethodBeat.o(219566);
        return str;
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(219567);
        if (fVar.ix(false)) {
            fVar.aeA("exitPip");
            Log.i(fVar.cDW, "exitPip, clearPipVideoRelated");
            fVar.y(true, true);
        }
        if (fVar.kAR != null) {
            fVar.kAR.setVisibility(4);
        }
        AppMethodBeat.o(219567);
    }

    static /* synthetic */ void a(f fVar, String str) {
        AppMethodBeat.i(219568);
        Log.d(fVar.cDW, str + ", requestAudioFocus");
        fVar.mAudioManager.requestAudioFocus(fVar.bTH(), 3, 2);
        AppMethodBeat.o(219568);
    }

    static /* synthetic */ boolean b(f fVar) {
        Set<String> set;
        AppMethodBeat.i(219569);
        Integer num = fVar.nDq;
        if (num == null) {
            Log.w(fVar.cDW, "isVideoInPipVideoTargetPageViewPlaying, pipVideoTargetPageViewId is null");
        } else if (!fVar.nDf.isEmpty() && (set = fVar.nDf.get(num)) != null && !set.isEmpty()) {
            AppMethodBeat.o(219569);
            return true;
        }
        AppMethodBeat.o(219569);
        return false;
    }

    static /* synthetic */ void a(f fVar, int i2, String str) {
        AppMethodBeat.i(219570);
        a yW = fVar.yW(i2);
        if (yW == null) {
            AppMethodBeat.o(219570);
            return;
        }
        yW.aez(str);
        AppMethodBeat.o(219570);
    }
}
