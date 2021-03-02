package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.pip.a;
import com.tencent.mm.plugin.appbrand.pip.f;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c> {
    /* access modifiers changed from: protected */
    public abstract PipInfoProvider Pw();

    /* access modifiers changed from: protected */
    public abstract int getId();

    /* access modifiers changed from: protected */
    public abstract String getKey();

    /* access modifiers changed from: protected */
    public abstract String getLogTag();

    public final void a(a aVar, String str) {
        Log.i(getLogTag(), "handlePipInfo");
        ac e2 = e(aVar);
        if (e2 == null) {
            Log.w(getLogTag(), "handlePipInfo, null == pageView");
            return;
        }
        t tVar = e2.nqU;
        if (tVar == null) {
            Log.w(getLogTag(), "handlePipInfo, null == page");
            return;
        }
        f b2 = b(e2);
        if (b2 == null) {
            Log.w(getLogTag(), "handlePipInfo, null == pipManager");
            return;
        }
        if (b2.nDe.get(Integer.valueOf(e2.hashCode())) == null) {
            com.tencent.mm.plugin.appbrand.pip.a aVar2 = new com.tencent.mm.plugin.appbrand.pip.a(e2);
            if (b2.nDm == null) {
                b2.nDm = new i.a() {
                    /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void a(i iVar) {
                        AppMethodBeat.i(219525);
                        String key = iVar.getKey();
                        Log.i(f.this.cDW, "onLoading, key: ".concat(String.valueOf(key)));
                        if (!(f.this.nDi == null || !f.this.nDi.equals(key) || f.this.kAR == null)) {
                            f.this.kAR.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(219519);
                                    AppBrandPipContainerView appBrandPipContainerView = f.this.kAR;
                                    if (appBrandPipContainerView.okT) {
                                        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoading");
                                        appBrandPipContainerView.okN.setVisibility(0);
                                    }
                                    AppMethodBeat.o(219519);
                                }
                            });
                        }
                        AppMethodBeat.o(219525);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void b(i iVar) {
                        AppMethodBeat.i(219526);
                        String key = iVar.getKey();
                        Log.i(f.this.cDW, "onLoadEnd, key: ".concat(String.valueOf(key)));
                        if (!(f.this.nDi == null || !f.this.nDi.equals(key) || f.this.kAR == null)) {
                            f.this.kAR.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(219520);
                                    f.this.kAR.bZY();
                                    AppMethodBeat.o(219520);
                                }
                            });
                            iVar.start();
                        }
                        AppMethodBeat.o(219526);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void a(i iVar, boolean z) {
                        a.C0785a aVar;
                        AppMethodBeat.i(219527);
                        String key = iVar.getKey();
                        Log.i(f.this.cDW, "onPlay, key: ".concat(String.valueOf(key)));
                        if (f.this.nDz) {
                            Log.i(f.this.cDW, "onPlay, runtime paused");
                            AppMethodBeat.o(219527);
                            return;
                        }
                        Integer bIt = iVar.bIt();
                        if (bIt != null) {
                            f fVar = f.this;
                            a yW = fVar.yW(bIt.intValue());
                            if (yW != null) {
                                if (!fVar.nDd) {
                                    fVar.kAs.setPipPageLifeCycleListener(new w.i() {
                                        /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass2 */

                                        @Override // com.tencent.mm.plugin.appbrand.page.w.i
                                        public final void r(t tVar) {
                                            AppMethodBeat.i(219513);
                                            Log.i(f.this.cDW, "onPageDestroy, page: " + f.s(tVar));
                                            if (!tVar.noQ) {
                                                ac currentPageView = tVar.getCurrentPageView();
                                                Log.i(f.this.cDW, "onPageDestroy, remove " + currentPageView + " from mPageView2PageScopedPipInfoMap");
                                                f.this.nDe.remove(Integer.valueOf(currentPageView.hashCode()));
                                            } else {
                                                Log.i(f.this.cDW, "onPageDestroy, " + f.s(tVar) + " is PipVideoRelated");
                                            }
                                            if (f.this.nDj == null) {
                                                AppMethodBeat.o(219513);
                                                return;
                                            }
                                            if (tVar == f.this.nDj) {
                                                f.this.nDk = false;
                                                f.this.kAs.setPipVideoRelatedPage(f.this.nDj);
                                            }
                                            AppMethodBeat.o(219513);
                                        }
                                    });
                                    fVar.kAs.setOnPageSwitchListener(new w.e() {
                                        /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass3 */
                                        private boolean FW = false;

                                        @Override // com.tencent.mm.plugin.appbrand.page.w.e
                                        public final void aQ(float f2) {
                                            AppMethodBeat.i(219516);
                                            if (!(!f.this.nDr || f.this.nDi == null || f.this.nDg == null)) {
                                                if (f.this.nDs) {
                                                    f.this.nDg.aR(100.0f - f2);
                                                    AppMethodBeat.o(219516);
                                                    return;
                                                }
                                                f.this.nDg.aR(f2);
                                            }
                                            AppMethodBeat.o(219516);
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.page.w.e
                                        public final void c(bx bxVar, t tVar, t tVar2) {
                                            boolean z;
                                            boolean z2;
                                            a aVar;
                                            AppMethodBeat.i(219517);
                                            Log.i(f.this.cDW, "onPageSwitchEnd, pageOpenType: %s, oldPage: %s, page: %s", bxVar, f.s(tVar), f.s(tVar2));
                                            if (!(tVar == null || (aVar = f.this.nDe.get(Integer.valueOf(tVar.getCurrentPageView().hashCode()))) == null || bx.NAVIGATE_BACK != bxVar || tVar == f.this.nDj)) {
                                                Log.i(aVar.cDW, "markCurPageDestroy");
                                                synchronized (aVar.nBO) {
                                                    try {
                                                        aVar.nBO.clear();
                                                    } catch (Throwable th) {
                                                        AppMethodBeat.o(219517);
                                                        throw th;
                                                    }
                                                }
                                                aVar.nBP.clear();
                                            }
                                            if (f.this.nDr && f.this.nDs) {
                                                Log.i(f.this.cDW, "onPageSwitchEnd, tryTransferFrom, isBack: " + this.FW);
                                                if (f.this.ix(true)) {
                                                    if (!(f.this.nDy == null || f.this.nDl == null)) {
                                                        e eVar = e.nDb;
                                                        if (f.this.nDn) {
                                                            eVar = e.nCV;
                                                        } else if (!this.FW) {
                                                            eVar = e.nCZ;
                                                        }
                                                        f.this.nDy.a(f.this.nDl.nBX, eVar);
                                                    }
                                                    f.this.aeA("onPageSwitchEnd 0");
                                                    if (!this.FW) {
                                                        Log.i(f.this.cDW, "onPageSwitchEnd, clearPipVideoRelated");
                                                    }
                                                    f fVar = f.this;
                                                    if (!this.FW) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (!this.FW) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    fVar.y(z, z2);
                                                }
                                                f.this.nDn = false;
                                                f.this.nDs = false;
                                                f.this.nDr = false;
                                            }
                                            if (!(!f.this.nDr || f.this.nDi == null || f.this.nDg == null)) {
                                                f.this.nDg.bTE();
                                                f.this.nDr = false;
                                                if (f.this.kAR != null) {
                                                    f.this.kAR.ja(true);
                                                }
                                                f.a(f.this, "onPageSwitchEnd");
                                            }
                                            if (!(!f.b(f.this) || f.this.nDi == null || f.this.kAR == null)) {
                                                Log.i(f.this.cDW, "onPageSwitchEnd, transferFrom for other video is playing");
                                                f.this.kAR.post(new Runnable() {
                                                    /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass3.AnonymousClass1 */

                                                    public final void run() {
                                                        AppMethodBeat.i(219514);
                                                        if (f.this.ix(false)) {
                                                            if (!(f.this.nDy == null || f.this.nDl == null)) {
                                                                f.this.nDy.a(f.this.nDl.nBX, e.nCY);
                                                            }
                                                            f.this.aeA("onPageSwitchEnd 1");
                                                            Log.i(f.this.cDW, "onPageSwitchEnd, clearPipVideoRelated");
                                                            f.this.y(true, true);
                                                        }
                                                        AppMethodBeat.o(219514);
                                                    }
                                                });
                                            }
                                            AppMethodBeat.o(219517);
                                        }

                                        /* JADX WARNING: Removed duplicated region for block: B:88:0x0282  */
                                        @Override // com.tencent.mm.plugin.appbrand.page.w.e
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final com.tencent.mm.plugin.appbrand.page.w.h b(com.tencent.mm.plugin.appbrand.page.bx r21, com.tencent.mm.plugin.appbrand.page.t r22, com.tencent.mm.plugin.appbrand.page.t r23) {
                                            /*
                                            // Method dump skipped, instructions count: 1013
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass3.b(com.tencent.mm.plugin.appbrand.page.bx, com.tencent.mm.plugin.appbrand.page.t, com.tencent.mm.plugin.appbrand.page.t):com.tencent.mm.plugin.appbrand.page.w$h");
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.page.w.e
                                        public final void d(bx bxVar, t tVar, t tVar2) {
                                            boolean z;
                                            boolean z2 = true;
                                            AppMethodBeat.i(219518);
                                            String s = f.s(tVar);
                                            String s2 = f.s(tVar2);
                                            Log.i(f.this.cDW, "onPageSwitchCancel, type: %s, oldPage: %s, newPage: %s", bxVar, s, s2);
                                            if (f.this.nDr && f.this.nDj != null && f.this.kAR != null) {
                                                f.this.nDq = null;
                                                Log.i(f.this.cDW, "onPageSwitchCancel, mPipVideoTargetPageViewId about null");
                                                if (tVar != f.this.nDj || !f.this.ix(true)) {
                                                    z = false;
                                                } else {
                                                    if (!(f.this.nDy == null || f.this.nDl == null)) {
                                                        f.this.nDy.a(f.this.nDl.nBX, e.nDb);
                                                    }
                                                    f.this.aeA("onPageSwitchCancel");
                                                    f.this.y(false, false);
                                                    z = true;
                                                }
                                                if (f.this.nDs && f.this.nDg != null) {
                                                    f.this.nDg.bTE();
                                                }
                                                f.this.nDr = false;
                                                f.this.nDs = false;
                                                AppBrandPipContainerView appBrandPipContainerView = f.this.kAR;
                                                if (z) {
                                                    z2 = false;
                                                }
                                                appBrandPipContainerView.ja(z2);
                                                AppMethodBeat.o(219518);
                                            } else if (f.this.nDr) {
                                                Log.i(f.this.cDW, "onPageSwitchCancel, isTransfering but mPipVideoRelatedPage or mPipContainerView is null");
                                                AppMethodBeat.o(219518);
                                            } else if (tVar == null) {
                                                Log.w(f.this.cDW, "onPageSwitchCancel, oldPage is null");
                                                AppMethodBeat.o(219518);
                                            } else {
                                                f.this.nDq = Integer.valueOf(tVar.getCurrentPageView().hashCode());
                                                Log.i(f.this.cDW, "onPageSwitchCancel, mPipVideoTargetPageViewId: %d(%s)", f.this.nDq, s2);
                                                AppMethodBeat.o(219518);
                                            }
                                        }
                                    });
                                    h.a(fVar.kEc.mAppId, new h.c() {
                                        /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass14 */

                                        @Override // com.tencent.mm.plugin.appbrand.h.c
                                        public final void a(h.d dVar) {
                                            AppMethodBeat.i(219552);
                                            Log.i(f.this.cDW, "onPause, type: ".concat(String.valueOf(dVar)));
                                            f.this.nDz = true;
                                            if (f.this.nDo) {
                                                Log.i(f.this.cDW, "pipVideo has stopped, skip");
                                                AppMethodBeat.o(219552);
                                            } else if (f.this.nDl == null) {
                                                AppMethodBeat.o(219552);
                                            } else {
                                                if (f.this.nDi != null) {
                                                    f.this.aeA("onPause");
                                                }
                                                i iVar = f.this.nDl.nBW;
                                                if (iVar != null) {
                                                    if (iVar.bIu()) {
                                                        Log.i(f.this.cDW, "background play enabled, skip");
                                                        AppMethodBeat.o(219552);
                                                        return;
                                                    }
                                                    Log.i(f.this.cDW, "onPause, pause");
                                                    iVar.pause();
                                                    f.this.nDp = true;
                                                }
                                                AppMethodBeat.o(219552);
                                            }
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.h.c
                                        public final void onResume() {
                                            AppMethodBeat.i(219553);
                                            Log.i(f.this.cDW, "onResume");
                                            f.this.nDz = false;
                                            if (f.this.nDo) {
                                                Log.i(f.this.cDW, "pipVideo has stopped, skip");
                                                AppMethodBeat.o(219553);
                                            } else if (f.this.nDl == null) {
                                                AppMethodBeat.o(219553);
                                            } else {
                                                if (f.this.nDi != null) {
                                                    f.a(f.this, "onResume");
                                                }
                                                i iVar = f.this.nDl.nBW;
                                                if (iVar != null) {
                                                    if (iVar.bIu()) {
                                                        Log.i(f.this.cDW, "background play enabled, skip");
                                                        AppMethodBeat.o(219553);
                                                        return;
                                                    }
                                                    Log.i(f.this.cDW, "onResume, start");
                                                    iVar.start();
                                                    f.this.nDp = false;
                                                }
                                                AppMethodBeat.o(219553);
                                            }
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.h.c
                                        public final void onDestroy() {
                                            i iVar;
                                            AppMethodBeat.i(219554);
                                            Log.i(f.this.cDW, "onDestroy");
                                            if (!(f.this.nDl == null || (iVar = f.this.nDl.nBW) == null)) {
                                                iVar.release();
                                            }
                                            f.this.kAs.setPipPageLifeCycleListener(null);
                                            h.b(f.this.kEc.mAppId, this);
                                            AppMethodBeat.o(219554);
                                        }
                                    });
                                    fVar.kAs.setDelegateWrapperFactory(new w.b() {
                                        /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass5 */

                                        @Override // com.tencent.mm.plugin.appbrand.page.w.b
                                        public final w.a a(final w.a aVar) {
                                            AppMethodBeat.i(219541);
                                            if (aVar == null) {
                                                aVar = new w.a() {
                                                    /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass5.AnonymousClass1 */

                                                    @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                    public final t a(String str, bx bxVar, w wVar, Callable<t> callable) {
                                                        AppMethodBeat.i(219536);
                                                        if (AnonymousClass5.a(AnonymousClass5.this, str, bxVar)) {
                                                            t tVar = f.this.nDj;
                                                            AppMethodBeat.o(219536);
                                                            return tVar;
                                                        }
                                                        AppMethodBeat.o(219536);
                                                        return null;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                    public final ac a(w wVar) {
                                                        return null;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                    public final boolean a(String str, bx bxVar, w wVar, w.d dVar) {
                                                        return false;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                    public final boolean MX() {
                                                        return false;
                                                    }
                                                };
                                            }
                                            AnonymousClass2 r0 = new w.a() {
                                                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass5.AnonymousClass2 */

                                                @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                public final t a(String str, bx bxVar, w wVar, Callable<t> callable) {
                                                    AppMethodBeat.i(219537);
                                                    if (AnonymousClass5.a(AnonymousClass5.this, str, bxVar)) {
                                                        t tVar = f.this.nDj;
                                                        AppMethodBeat.o(219537);
                                                        return tVar;
                                                    }
                                                    t a2 = aVar.a(str, bxVar, wVar, callable);
                                                    AppMethodBeat.o(219537);
                                                    return a2;
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                public final ac a(w wVar) {
                                                    AppMethodBeat.i(219538);
                                                    ac a2 = aVar.a(wVar);
                                                    AppMethodBeat.o(219538);
                                                    return a2;
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                public final boolean a(String str, bx bxVar, w wVar, w.d dVar) {
                                                    AppMethodBeat.i(219539);
                                                    boolean a2 = aVar.a(str, bxVar, wVar, dVar);
                                                    AppMethodBeat.o(219539);
                                                    return a2;
                                                }

                                                @Override // com.tencent.mm.plugin.appbrand.page.w.a
                                                public final boolean MX() {
                                                    AppMethodBeat.i(219540);
                                                    boolean MX = aVar.MX();
                                                    AppMethodBeat.o(219540);
                                                    return MX;
                                                }
                                            };
                                            AppMethodBeat.o(219541);
                                            return r0;
                                        }

                                        static /* synthetic */ boolean a(AnonymousClass5 r4, String str, bx bxVar) {
                                            AppMethodBeat.i(219542);
                                            if (bx.NAVIGATE_TO != bxVar || f.this.nDk || f.this.nDj == null || !f.this.nDj.getCurrentUrl().equals(str)) {
                                                AppMethodBeat.o(219542);
                                                return false;
                                            }
                                            Log.i(f.this.cDW, "onCreatePage, reuse " + f.s(f.this.nDj));
                                            AppMethodBeat.o(219542);
                                            return true;
                                        }
                                    });
                                    fVar.nDd = true;
                                }
                                Log.i(yW.cDW, "addPipRelatedKey, key: ".concat(String.valueOf(key)));
                                synchronized (yW.nBO) {
                                    try {
                                        yW.nBO.remove(key);
                                        yW.nBO.addFirst(key);
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(219527);
                                        throw th;
                                    }
                                }
                            }
                            f fVar2 = f.this;
                            a aVar2 = fVar2.nDe.get(Integer.valueOf(bIt.intValue()));
                            if (aVar2 == null) {
                                Log.w(fVar2.cDW, "getPipVideoSession, null == pageScopedPipInfo");
                                aVar = null;
                            } else {
                                aVar = aVar2.nBP.get(key);
                            }
                        } else {
                            Log.w(f.this.cDW, "onPlay, pageViewId is null");
                            aVar = null;
                        }
                        if (!(f.this.nDy == null || aVar == null || aVar.nBR == null || b.a.NONE == aVar.nBR)) {
                            f.this.nDy.a(aVar.nBX, aVar.nBR);
                        }
                        if (f.b(f.this) && f.this.nDi != null && f.this.nDi.equals(key) && f.this.kAR != null) {
                            Log.i(f.this.cDW, "processTransferFromOnPlay for other video is playing");
                            iy(z);
                            AppMethodBeat.o(219527);
                        } else if (f.this.nDi == null || !f.this.nDi.equals(key)) {
                            if (bIt != null) {
                                f.this.s(bIt.intValue(), key, "onPlay");
                            }
                            if (!((f.this.nDr && f.this.nDs) || f.this.nDi == null || f.this.kAR == null)) {
                                iy(z);
                            }
                            AppMethodBeat.o(219527);
                        } else {
                            Log.i(f.this.cDW, "onPlay, mark pip video play");
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(219521);
                                    if (!(f.this.nDh == null || f.this.nBY == null)) {
                                        f.this.nDh.d(f.this.nBY, null);
                                    }
                                    AppMethodBeat.o(219521);
                                }
                            });
                            f.this.nDo = false;
                            f.a(f.this, "onPlay");
                            AppMethodBeat.o(219527);
                        }
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void c(i iVar) {
                        AppMethodBeat.i(219528);
                        String key = iVar.getKey();
                        Log.i(f.this.cDW, "onPause, key: ".concat(String.valueOf(key)));
                        if (f.this.nDz) {
                            Log.i(f.this.cDW, "onPause, runtime paused");
                            AppMethodBeat.o(219528);
                        } else if (f.this.nDi == null || !f.this.nDi.equals(key)) {
                            Integer bIt = iVar.bIt();
                            if (bIt == null) {
                                Log.w(f.this.cDW, "onPause, pageViewId is null");
                                AppMethodBeat.o(219528);
                                return;
                            }
                            f.this.r(bIt.intValue(), key, "onPause");
                            AppMethodBeat.o(219528);
                        } else if (f.this.nDp) {
                            Log.i(f.this.cDW, "onPause, key: " + key + ", mPipVideoPausedByMyself: true");
                            AppMethodBeat.o(219528);
                        } else {
                            Log.i(f.this.cDW, "onPause, start key: ".concat(String.valueOf(key)));
                            iVar.start();
                            AppMethodBeat.o(219528);
                        }
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void d(i iVar) {
                        AppMethodBeat.i(219529);
                        Log.i(f.this.cDW, "onError, key: ".concat(String.valueOf(iVar.getKey())));
                        AppMethodBeat.o(219529);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void e(i iVar) {
                        AppMethodBeat.i(219530);
                        String key = iVar.getKey();
                        Log.i(f.this.cDW, "onStop, key: ".concat(String.valueOf(key)));
                        if (!(f.this.nDi == null || !f.this.nDi.equals(key) || f.this.kAR == null)) {
                            aeB("onStop");
                        }
                        Integer bIt = iVar.bIt();
                        if (bIt != null) {
                            f.a(f.this, bIt.intValue(), key);
                            if (f.this.nDi == null || !f.this.nDi.equals(key)) {
                                f.this.r(bIt.intValue(), key, "onStop");
                                AppMethodBeat.o(219530);
                                return;
                            }
                        } else {
                            Log.w(f.this.cDW, "onStop, pageViewId is null");
                        }
                        AppMethodBeat.o(219530);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void a(i iVar, final float f2) {
                        AppMethodBeat.i(219531);
                        String key = iVar.getKey();
                        if (!(f.this.nDi == null || !f.this.nDi.equals(key) || f.this.nDl == null || f.this.kAR == null)) {
                            final boolean z = f.this.nDl.nBS;
                            f.this.kAR.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(219522);
                                    if (z) {
                                        f.this.kAR.aV(f2);
                                        AppMethodBeat.o(219522);
                                        return;
                                    }
                                    f.this.kAR.bZZ();
                                    AppMethodBeat.o(219522);
                                }
                            });
                        }
                        AppMethodBeat.o(219531);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void f(i iVar) {
                        AppMethodBeat.i(219532);
                        Log.d(f.this.cDW, "onPlayEndSoon, key: ".concat(String.valueOf(iVar.getKey())));
                        AppMethodBeat.o(219532);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i.a
                    public final void g(i iVar) {
                        AppMethodBeat.i(219533);
                        String key = iVar.getKey();
                        Log.i(f.this.cDW, "onPlayEnd, key: ".concat(String.valueOf(key)));
                        if (!(f.this.nDi == null || !f.this.nDi.equals(key) || f.this.kAR == null)) {
                            aeB("onPlayEnd");
                        }
                        Integer bIt = iVar.bIt();
                        if (bIt != null) {
                            f.a(f.this, bIt.intValue(), key);
                            if (f.this.nDi == null || !f.this.nDi.equals(key)) {
                                f.this.r(bIt.intValue(), key, "onPlayEnd");
                            }
                        } else {
                            Log.w(f.this.cDW, "onPlayEnd, pageViewId is null");
                        }
                        if (f.this.nDh != null) {
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4.AnonymousClass5 */

                                public final void run() {
                                    AppMethodBeat.i(219523);
                                    Log.i(f.this.cDW, "onPlayEnd, onPlayEndWorkaround");
                                    if (!(f.this.nDh == null || f.this.nBY == null)) {
                                        f.this.nDh.cg(f.this.nBY);
                                    }
                                    AppMethodBeat.o(219523);
                                }
                            });
                        }
                        AppMethodBeat.o(219533);
                    }

                    private void iy(final boolean z) {
                        AppMethodBeat.i(219534);
                        f.this.kAR.post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.pip.f.AnonymousClass4.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(219524);
                                if (f.this.ix(false)) {
                                    if (!(f.this.nDy == null || f.this.nDl == null)) {
                                        f.this.nDy.a(f.this.nDl.nBX, z ? e.nCX : e.nCY);
                                    }
                                    f.this.aeA("processTransferFromOnPlay");
                                    Log.i(f.this.cDW, "processTransferFromOnPlay, clearPipVideoRelated");
                                    f.this.y(true, true);
                                }
                                AppMethodBeat.o(219524);
                            }
                        });
                        AppMethodBeat.o(219534);
                    }

                    private void aeB(String str) {
                        AppMethodBeat.i(219535);
                        f.this.aeA(str);
                        f.this.nDo = true;
                        AppMethodBeat.o(219535);
                    }
                };
            }
            aVar2.mKh = b2.nDm;
            Log.i(b2.cDW, "createPageScopedPipInfoIfNeed for " + f.s(e2.nqU));
            b2.nDe.put(Integer.valueOf(e2.hashCode()), aVar2);
        }
        JSONObject Ps = aVar.Ps();
        if (Ps == null) {
            Log.w(getLogTag(), "handlePipInfo, null == dataJsonObj");
            return;
        }
        PipInfoProvider Pw = Pw();
        com.tencent.mm.plugin.appbrand.jsapi.s.b dQ = Pw.dQ(Ps.toString());
        if (dQ == null) {
            Log.w(getLogTag(), "handlePipInfo, null == pipExtra");
            return;
        }
        com.tencent.mm.plugin.appbrand.pip.c cVar = new com.tencent.mm.plugin.appbrand.pip.c(b2.kEc.mAppId, tVar.getCurrentUrl(), str);
        String key = getKey();
        int id = getId();
        g PI = Pw.PI();
        h.a PJ = Pw.PJ();
        com.tencent.mm.plugin.appbrand.jsapi.s.c PK = Pw.PK();
        com.tencent.mm.plugin.appbrand.pip.a z = b2.z(e2);
        if (z != null) {
            Log.d(z.cDW, "processPipInfo, key: ".concat(String.valueOf(key)));
            a.C0785a aVar3 = z.nBP.get(key);
            if (aVar3 == null) {
                Log.i(z.cDW, "processPipInfo, create PipVideoSession for key: ".concat(String.valueOf(key)));
                z.nBP.put(key, new a.C0785a(id, dQ, PI, PJ, PK, cVar, z.mKh));
                return;
            }
            Log.i(z.cDW, "processPipInfo, pipVideoSession for key: " + key + " exists");
            aVar3.a(dQ);
            aVar3.nBX = cVar;
        }
    }

    public final void b(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        f b2;
        Log.i(getLogTag(), "removePipId");
        ac e2 = e(aVar);
        if (e2 != null && (b2 = b(e2)) != null) {
            String key = getKey();
            com.tencent.mm.plugin.appbrand.pip.a z = b2.z(e2);
            if (z != null) {
                z.aez(key);
            }
        }
    }

    public final boolean c(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        f b2;
        Log.i(getLogTag(), "exitPip");
        ac e2 = e(aVar);
        if (e2 == null || (b2 = b(e2)) == null) {
            return false;
        }
        return b2.yV(getId());
    }

    public final boolean d(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        ac e2;
        f b2;
        Log.i(getLogTag(), "amIPipPlayer");
        if (aVar == null || (e2 = e(aVar)) == null || (b2 = b(e2)) == null) {
            return false;
        }
        return Objects.equals(b2.nDi, getKey());
    }

    public static ac e(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        com.tencent.mm.plugin.appbrand.jsapi.f NN = aVar.NN();
        if (NN instanceof ac) {
            return (ac) NN;
        }
        Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", NN);
        if (NN instanceof s) {
            return ((s) NN).getCurrentPageView();
        }
        Log.w("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", NN);
        return null;
    }

    private f b(ac acVar) {
        AppBrandRuntime runtime = acVar.getRuntime();
        if (runtime == null) {
            Log.w(getLogTag(), "handlePipInfo, null == runtime");
            return null;
        }
        f fVar = runtime.kAQ;
        if (fVar != null) {
            return fVar;
        }
        Log.w(getLogTag(), "handlePipInfo, null == pipManager");
        return null;
    }
}
