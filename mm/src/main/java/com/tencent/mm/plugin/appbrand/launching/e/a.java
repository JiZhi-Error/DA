package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.support.v4.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.av;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.storage.ar;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.xwalk.core.XWalkEnvironment;

public abstract class a extends MutableContextWrapper {
    private volatile boolean mYT = false;
    volatile boolean mYU = false;
    protected boolean mYV = true;
    private final Queue<Runnable> mYW = new ConcurrentLinkedQueue();
    private MMHandler mYX;
    private LaunchParcel mYY;

    public a() {
        super(MMApplicationContext.getContext());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 120
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    public final void setBaseContext(android.content.Context r5) {
        /*
            r4 = this;
            super.setBaseContext(r5)
            boolean r0 = r4.bOd()
            if (r0 == 0) goto L_0x0012
            boolean r0 = r4.mYT
            if (r0 == 0) goto L_0x001e
            java.util.Queue<java.lang.Runnable> r0 = r4.mYW
            r0.clear()
        L_0x0012:
            return
        L_0x0013:
            java.util.Queue<java.lang.Runnable> r0 = r4.mYW     // Catch:{ ClassCastException -> 0x003b }
            java.lang.Object r0 = r0.poll()     // Catch:{ ClassCastException -> 0x003b }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ ClassCastException -> 0x003b }
            r0.run()     // Catch:{ ClassCastException -> 0x003b }
        L_0x001e:
            java.util.Queue<java.lang.Runnable> r0 = r4.mYW
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0012
            boolean r0 = r4.bOd()
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess"
            java.lang.String r1 = "fileAllPendingUiTasks but !currentInUiEnv, return"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
            java.util.Queue<java.lang.Runnable> r0 = r4.mYW
            r0.clear()
            goto L_0x0012
        L_0x003b:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "cannot be cast to com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = "MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess"
            java.lang.String r2 = "mUiEnvQueue.poll().run()"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r1, r0, r2, r3)
            java.util.Queue<java.lang.Runnable> r0 = r4.mYW
            r0.clear()
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.e.a.setBaseContext(android.content.Context):void");
    }

    public final void bOc() {
        this.mYT = true;
        this.mYW.clear();
        super.setBaseContext(MMApplicationContext.getContext());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean bOd() {
        Context baseContext = getBaseContext();
        if (!(baseContext instanceof AppBrandLaunchProxyUI)) {
            return false;
        }
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) baseContext;
        if (appBrandLaunchProxyUI.isDestroyed() || appBrandLaunchProxyUI.isFinishing()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void ab(Runnable runnable) {
        if (bOd()) {
            ((Activity) getBaseContext()).runOnUiThread(runnable);
        } else if (this.mYT) {
            Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", android.util.Log.getStackTraceString(new Throwable()));
            this.mYW.clear();
        } else {
            this.mYW.offer(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public final void bOe() {
        ab(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(47421);
                Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "finishUiEnv InUiEnv");
                if (a.this.getBaseContext() instanceof AppBrandLaunchProxyUI) {
                    ((AppBrandLaunchProxyUI) a.this.getBaseContext()).finish();
                }
                a.this.setBaseContext(MMApplicationContext.getContext());
                a.this.mYT = true;
                AppMethodBeat.o(47421);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void finish() {
        c(null, null);
    }

    /* access modifiers changed from: protected */
    public Context bOf() {
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Context bOg() {
        Context baseContext = getBaseContext();
        Context bOf = bOf();
        if ((baseContext instanceof Activity) || bOf == null) {
            bOf = baseContext;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(bOf);
        if (castActivityOrNull == null || castActivityOrNull.isFinishing()) {
            return MMApplicationContext.getContext();
        }
        return bOf;
    }

    /* access modifiers changed from: protected */
    public void c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfigWC != null) {
            i.b(bOg(), appBrandInitConfigWC, appBrandStatObject);
        } else {
            this.mYV = true;
            if (this.mYY != null) {
                u uVar = u.mTD;
                g yi = u.yi(this.mYY.mYS);
                if (!(yi == null || yi.kHN == null)) {
                    yi.kHN.bud();
                }
            }
        }
        if (this.mYV) {
            bOe();
        }
        this.mYU = true;
        if (this.mYX != null && this.mYX.getLooper() != Looper.getMainLooper()) {
            this.mYX.postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(47429);
                    a.this.mYX.quit();
                    AppMethodBeat.o(47429);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isFinishing() {
        return bOd() && ((AppBrandLaunchProxyUI) getBaseContext()).isFinishing();
    }

    /* access modifiers changed from: protected */
    public final boolean bOh() {
        return bOd() && ((AppBrandLaunchProxyUI) getBaseContext()).isDestroyed();
    }

    /* access modifiers changed from: protected */
    public boolean d(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        if (DebuggerShell.bAx()) {
            Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
            return true;
        }
        boolean e2 = (h.bWb().afi(appBrandInitConfigWC.appId) || appBrandInitConfigWC.NA()) | appBrandInitConfigWC.ldK | com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(appBrandInitConfigWC, appBrandStatObject);
        if (!appBrandInitConfigWC.ldK && appBrandInitConfigWC.ldN && f.a(appBrandInitConfigWC)) {
            e2 = false;
        }
        if (appBrandInitConfigWC.NA()) {
            com.tencent.mm.plugin.expansions.a.cMr();
        }
        return !(e2 & true);
    }

    /* access modifiers changed from: protected */
    public final void a(final LaunchParcel launchParcel, final String str) {
        MMHandler mMHandler = new MMHandler("AppBrandLaunchProxyUI-PrepareThread");
        this.mYX = mMHandler;
        mMHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(47428);
                new com.tencent.mm.plugin.appbrand.launching.f(launchParcel, str, new e.a<AppBrandInitConfigWC>() {
                    /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.config.AppBrandInitConfigLU, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject, int] */
                    @Override // com.tencent.mm.plugin.appbrand.launching.e.a
                    public final /* synthetic */ void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i2) {
                        AppMethodBeat.i(227138);
                        final AppBrandInitConfigWC appBrandInitConfigWC2 = appBrandInitConfigWC;
                        if (!a.this.isFinishing()) {
                            if (appBrandInitConfigWC2 == null) {
                                k.b(launchParcel.appId, launchParcel.kHw, launchParcel.mYK);
                                a.this.finish();
                                AppMethodBeat.o(227138);
                                return;
                            }
                            launchParcel.f(appBrandInitConfigWC2);
                            WeAppOpenUICallbackIPCProxy.c.a(appBrandInitConfigWC2, launchParcel);
                            appBrandInitConfigWC2.ldR = launchParcel.ldR;
                            appBrandInitConfigWC2.ldQ = launchParcel.ldQ;
                            appBrandInitConfigWC2.kHI = launchParcel.kHI;
                            appBrandInitConfigWC2.kHK = launchParcel.kHK;
                            final AnonymousClass1 r1 = new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(47425);
                                    a.this.c(appBrandInitConfigWC2, launchParcel.mYK);
                                    AppMethodBeat.o(47425);
                                }
                            };
                            if (WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailableSlient(a.this.bOg(), new c<WeChatBrands.Business.AvailabilityAlertSupplier>() {
                                /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass1.AnonymousClass2 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.support.v4.e.c
                                public final /* synthetic */ void accept(WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier) {
                                    AppMethodBeat.i(227135);
                                    WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier2 = availabilityAlertSupplier;
                                    com.tencent.mm.plugin.appbrand.ipc.a.a(a.this.getBaseContext(), availabilityAlertSupplier2.getBody(), availabilityAlertSupplier2.getTilte(), availabilityAlertSupplier2.getPositiveBtnText(), availabilityAlertSupplier2.getNegativeBtnText(), availabilityAlertSupplier2.getOnPositiveClickListener(), availabilityAlertSupplier2.getOnNegativeClickListener(), availabilityAlertSupplier2.getOnPositiveClickListener());
                                    a.this.finish();
                                    AppMethodBeat.o(227135);
                                }
                            })) {
                                if (com.tencent.mm.model.gdpr.c.aXj()) {
                                    com.tencent.mm.model.gdpr.c.a(a.this.getBaseContext(), com.tencent.mm.model.gdpr.a.MINI_PROGRAM, appBrandInitConfigWC2.appId, new b() {
                                        /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass1.AnonymousClass3 */

                                        @Override // com.tencent.mm.model.gdpr.b
                                        public final void sx(int i2) {
                                            AppMethodBeat.i(227136);
                                            if (i2 == 0) {
                                                r1.run();
                                                AppMethodBeat.o(227136);
                                                return;
                                            }
                                            com.tencent.mm.plugin.appbrand.ipc.a.a(a.this.getBaseContext(), a.this.getBaseContext().getString(R.string.a1g), a.this.getBaseContext().getString(R.string.a1h), a.this.getBaseContext().getString(R.string.x_), null, null, null, null);
                                            a.this.finish();
                                            AppMethodBeat.o(227136);
                                        }
                                    });
                                    AppMethodBeat.o(227138);
                                    return;
                                }
                                if (!com.tencent.mm.plugin.appbrand.launching.f.b.a(appBrandInitConfigWC2, Integer.valueOf(launchParcel.mYK != null ? launchParcel.mYK.scene : -1), launchParcel.username, launchParcel.iOo)) {
                                    a.this.ab(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass1.AnonymousClass4 */

                                        public final void run() {
                                            AppMethodBeat.i(227137);
                                            ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(a.this.getBaseContext());
                                            com.tencent.mm.plugin.appbrand.launching.f.a.aco(launchParcel.username);
                                            a.this.finish();
                                            AppMethodBeat.o(227137);
                                        }
                                    });
                                    AppMethodBeat.o(227138);
                                    return;
                                } else if (!a.this.d(appBrandInitConfigWC2, launchParcel.mYK)) {
                                    r1.run();
                                    AppMethodBeat.o(227138);
                                    return;
                                } else {
                                    a.a(a.this, r1);
                                }
                            }
                        }
                        AppMethodBeat.o(227138);
                    }
                }, new f.a() {
                    /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.launching.f.a
                    public final void bto() {
                        AppMethodBeat.i(175006);
                        Log.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", launchParcel.username, launchParcel.appId, Boolean.valueOf(a.this.bOd()));
                        a.this.ab(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                boolean z = true;
                                AppMethodBeat.i(175005);
                                if (a.this.getBaseContext() instanceof AppBrandLaunchProxyUI) {
                                    AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) a.this.getBaseContext();
                                    Object[] objArr = new Object[1];
                                    if (!appBrandLaunchProxyUI.isFinishing() && !appBrandLaunchProxyUI.isDestroyed()) {
                                        z = false;
                                    }
                                    objArr[0] = Boolean.valueOf(z);
                                    Log.d("MicroMsg.AppBrandLaunchProxyUI", "revealProgressLayoutImmediately destroyed[%b]", objArr);
                                    appBrandLaunchProxyUI.mQp.removeCallbacks(appBrandLaunchProxyUI.mQq);
                                    appBrandLaunchProxyUI.mQp.post(appBrandLaunchProxyUI.mQq);
                                }
                                AppMethodBeat.o(175005);
                            }
                        });
                        AppMethodBeat.o(175006);
                    }
                }).run();
                AppMethodBeat.o(47428);
            }
        });
    }

    static /* synthetic */ void a(a aVar, final Runnable runnable) {
        aVar.ab(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(47424);
                AnonymousClass1 r1 = new av() {
                    /* class com.tencent.mm.plugin.appbrand.launching.e.a.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.launching.av
                    public final void bNL() {
                        AppMethodBeat.i(47422);
                        a.this.finish();
                        AppMethodBeat.o(47422);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.launching.av
                    public final void onReady() {
                        AppMethodBeat.i(47423);
                        runnable.run();
                        AppMethodBeat.o(47423);
                    }
                };
                AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) a.this.getBaseContext();
                com.tencent.mm.plugin.expansions.a.cMr();
                int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext());
                if (installedNewstVersion > 400) {
                    Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
                    r1.onReady();
                    AppMethodBeat.o(47424);
                    return;
                }
                if (Math.abs(Util.nowSecond() - com.tencent.mm.kernel.g.aAh().azQ().a(ar.a.APPBRAND_TBS_CHECK_INSTALL_LAST_TIME_IN_SECOND_LONG, 0)) < 1800) {
                    Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
                    r1.bNM();
                    AppMethodBeat.o(47424);
                    return;
                }
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.APPBRAND_TBS_CHECK_INSTALL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(Util.nowSecond()));
                Log.d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", Long.valueOf(Util.nowMilliSecond() - Util.nowMilliSecond()), Integer.valueOf(installedNewstVersion));
                if (appBrandLaunchProxyUI == null || !appBrandLaunchProxyUI.bNd()) {
                    r1.bNM();
                    AppMethodBeat.o(47424);
                    return;
                }
                appBrandLaunchProxyUI.a(r1, new Intent().setClass(appBrandLaunchProxyUI.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), r1.requestCode);
                AppMethodBeat.o(47424);
            }
        });
    }
}
