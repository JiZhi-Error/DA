package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.support.v7.h.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.b.a.ko;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.an;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.v;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public final class AppBrandLauncherRecentsList extends AppBrandLauncherUI.Fragment {
    private boolean iCn;
    private int lvW;
    private final MMHandler oaC;
    private final int obS;
    private final boolean obT;
    private final boolean obU;
    private final boolean obV;
    private final k obW;
    private final Bundle obX;
    private final AtomicLong obY;
    private final AtomicLong obZ;
    private final MStorage.IOnStorageChange ocA;
    private final MStorage.IOnStorageChange ocB;
    private final c ocC;
    private boolean ocD;
    private Dialog ocE;
    private final AtomicBoolean oca;
    private final AtomicLong ocb;
    private final AtomicBoolean occ;
    private LoadMoreRecyclerView ocd;
    private LinearLayoutManager oce;
    private r ocf;
    private final l ocg;
    private final a och;
    private final p oci;
    private d ocj;
    private View ock;
    private View ocl;
    private a ocm;
    private g ocn;
    private final n oco;
    private int ocp;
    private int ocq;
    private boolean ocr;
    private boolean ocs;
    private String oct;
    private int ocu;
    private final Object ocv;
    private final android.support.v7.h.d ocw;
    private final b ocx;
    private final MStorage.IOnStorageChange ocy;
    private final MStorage.IOnStorageChange ocz;

    public AppBrandLauncherRecentsList() {
        this(true);
    }

    @SuppressLint({"ValidFragment"})
    public AppBrandLauncherRecentsList(boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(49119);
        this.obX = new Bundle();
        this.obY = new AtomicLong(-1);
        this.obZ = new AtomicLong(-1);
        this.oca = new AtomicBoolean(false);
        this.ocb = new AtomicLong(MAlarmHandler.NEXT_FIRE_INTERVAL);
        this.occ = new AtomicBoolean(false);
        this.ocg = new l();
        this.oaC = new MMHandler("AppBrandLauncherUI#RecentsListUI");
        this.och = new a();
        this.oci = new p();
        this.oco = new n();
        this.ocp = 3;
        this.ocq = 0;
        this.ocr = false;
        this.ocs = false;
        this.iCn = false;
        this.ocu = -1;
        this.ocv = new Object();
        this.ocw = new android.support.v7.h.d() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass17 */

            @Override // android.support.v7.h.d
            public final void f(int i2, int i3) {
                AppMethodBeat.i(49070);
                AppBrandLauncherRecentsList.this.ocf.as(i2, i3);
                AppMethodBeat.o(49070);
            }

            @Override // android.support.v7.h.d
            public final void k(int i2, int i3) {
                AppMethodBeat.i(49071);
                AppBrandLauncherRecentsList.this.ocx.bYA();
                AppBrandLauncherRecentsList.this.ocf.at(i2, i3);
                AppMethodBeat.o(49071);
            }

            @Override // android.support.v7.h.d
            public final void l(int i2, int i3) {
                AppMethodBeat.i(49072);
                AppBrandLauncherRecentsList.this.ocx.bYA();
                AppBrandLauncherRecentsList.this.ocf.ar(i2, i3);
                AppMethodBeat.o(49072);
            }

            @Override // android.support.v7.h.d
            public final void c(int i2, int i3, Object obj) {
                AppMethodBeat.i(49073);
                AppBrandLauncherRecentsList.this.ocf.e(i2, i3, obj);
                AppMethodBeat.o(49073);
            }
        };
        this.ocx = new b(this, (byte) 0);
        this.ocy = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass18 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(49074);
                if (MStorageEventData.EventType.SINGLE.equals(str)) {
                    if ((5 == mStorageEventData.eventId && AppBrandLauncherRecentsList.this.obU) || 2 == mStorageEventData.eventId || 3 == mStorageEventData.eventId) {
                        Log.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, event %d", Integer.valueOf(mStorageEventData.eventId));
                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, false, -1L, true);
                        AppMethodBeat.o(49074);
                        return;
                    }
                } else if (MStorageEventData.EventType.BATCH.equals(str) && 3 == mStorageEventData.eventId) {
                    Object obj = mStorageEventData.obj;
                    if (!(obj instanceof Long) || ((Long) obj).longValue() != AppBrandLauncherRecentsList.this.obY.get()) {
                        Log.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, batch update");
                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, false, (long) MAlarmHandler.NEXT_FIRE_INTERVAL, true);
                    } else {
                        AppMethodBeat.o(49074);
                        return;
                    }
                }
                AppMethodBeat.o(49074);
            }
        };
        this.ocz = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass19 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(49076);
                if (MStorageEventData.EventType.SINGLE.equals(str) && (3 == mStorageEventData.eventId || 2 == mStorageEventData.eventId)) {
                    AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass19.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(49075);
                            if (AppBrandLauncherRecentsList.this.ocd.asn) {
                                AppBrandLauncherRecentsList.this.oco.odO = false;
                            }
                            AppMethodBeat.o(49075);
                        }
                    });
                    Log.d("MicroMsg.AppBrandLauncherRecentsList", "onHistoryRecordModified");
                    AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, true, (long) MAlarmHandler.NEXT_FIRE_INTERVAL, false);
                }
                AppMethodBeat.o(49076);
            }
        };
        this.ocA = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass20 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(49077);
                Log.d("MicroMsg.AppBrandLauncherRecentsList", "onContactUpdate %s", str);
                AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, false, -1L, false);
                AppMethodBeat.o(49077);
            }
        };
        this.ocB = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass21 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                ArrayList<AppBrandRecentTaskInfo> g2;
                final ArrayList<AppBrandRecentTaskInfo> a2;
                AppMethodBeat.i(49080);
                try {
                    if (mStorageEventData.obj != null && (mStorageEventData.obj instanceof Long)) {
                        long j2 = AppBrandLauncherRecentsList.this.obY.get();
                        long j3 = AppBrandLauncherRecentsList.this.obZ.get();
                        Log.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", (Long) mStorageEventData.obj, Long.valueOf(j2), Long.valueOf(j3));
                        if (mStorageEventData.obj.equals(Long.valueOf(j2))) {
                            g2 = n.buJ().kVB.byr();
                        } else {
                            g2 = n.buJ().kVB.g(AppBrandLauncherRecentsList.this.ocb.get(), 30);
                        }
                        if (!Util.isNullOrNil(g2)) {
                            AppBrandLauncherRecentsList.this.ocb.set(g2.get(g2.size() - 1).crj);
                        }
                        final ArrayList<AppBrandRecentTaskInfo> L = AppBrandLauncherRecentsList.this.obW.L(g2);
                        if (mStorageEventData.obj.equals(Long.valueOf(j2))) {
                            if (AppBrandLauncherRecentsList.this.obU) {
                                a2 = new ArrayList<>(0);
                            } else {
                                a2 = AppBrandLauncherRecentsList.this.obT ? n.buK().a(ag.a.ASC) : null;
                            }
                            AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass21.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(49078);
                                    AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, a2, L, true);
                                    AppMethodBeat.o(49078);
                                }
                            });
                            AppMethodBeat.o(49080);
                            return;
                        } else if (mStorageEventData.obj.equals(Long.valueOf(j3))) {
                            a.a(AppBrandLauncherRecentsList.this.och);
                            AppBrandLauncherRecentsList.this.och.sendMessage(AppBrandLauncherRecentsList.this.och.obtainMessage(1, new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass21.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(49079);
                                    if (AppBrandLauncherRecentsList.this.ocd == null || !AppBrandLauncherRecentsList.this.ocd.isAttachedToWindow()) {
                                        AppMethodBeat.o(49079);
                                    } else if (AppBrandLauncherRecentsList.this.ocd.ld()) {
                                        AppBrandLauncherRecentsList.this.och.sendMessage(AppBrandLauncherRecentsList.this.och.obtainMessage(2, this));
                                        AppMethodBeat.o(49079);
                                    } else {
                                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, L);
                                        AppMethodBeat.o(49079);
                                    }
                                }
                            }));
                        }
                    }
                    AppMethodBeat.o(49080);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", e2);
                    AppMethodBeat.o(49080);
                }
            }
        };
        this.ocC = new c(this, (byte) 0);
        this.ocD = false;
        this.lvW = 0;
        this.ocE = null;
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("showHeader", z);
        setArguments(bundle);
        this.obT = v.bym();
        this.obU = v.byn();
        if (!WeChatEnvironment.hasDebugger() || !com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN, false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.obV = z2;
        this.obS = v.byo();
        this.obW = new k((!this.obT || this.obU) ? false : z3);
        AppMethodBeat.o(49119);
    }

    private boolean bYv() {
        AppMethodBeat.i(49120);
        if (this.occ.get()) {
            AppMethodBeat.o(49120);
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            AppMethodBeat.o(49120);
            return true;
        }
        AppMethodBeat.o(49120);
        return false;
    }

    private void bYw() {
        AppMethodBeat.i(227726);
        try {
            synchronized (this.ocv) {
                try {
                    this.ocv.wait(500);
                } finally {
                    AppMethodBeat.o(227726);
                }
            }
        } catch (InterruptedException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e2, "", new Object[0]);
            AppMethodBeat.o(227726);
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements RecyclerView.f.a {
        private b() {
        }

        /* synthetic */ b(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.f.a
        public final void lD() {
            AppMethodBeat.i(49087);
            AppBrandLauncherRecentsList.this.oco.odN = false;
            AppMethodBeat.o(49087);
        }

        /* access modifiers changed from: package-private */
        public final void bYA() {
            AppMethodBeat.i(49088);
            AppBrandLauncherRecentsList.this.oco.odN = true;
            AppMethodBeat.o(49088);
        }
    }

    final class c extends RecyclerView.c implements RecyclerView.f.a {
        private c() {
        }

        /* synthetic */ c(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(49090);
            iS(false);
            AppMethodBeat.o(49090);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(49091);
            iS(true);
            AppMethodBeat.o(49091);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            AppMethodBeat.i(164002);
            iS(false);
            AppMethodBeat.o(164002);
        }

        @Override // android.support.v7.widget.RecyclerView.f.a
        public final void lD() {
            AppMethodBeat.i(49093);
            iS(false);
            AppMethodBeat.o(49093);
        }

        private void iS(final boolean z) {
            AppMethodBeat.i(49094);
            AppBrandLauncherRecentsList.this.postOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.c.AnonymousClass1 */

                public final void run() {
                    boolean z = true;
                    int i2 = 0;
                    AppMethodBeat.i(49089);
                    if (!AppBrandLauncherRecentsList.this.ocf.isEmpty() && AppBrandLauncherRecentsList.this.ocf != null) {
                        try {
                            AppBrandLauncherRecentsList.this.ocf.ci(AppBrandLauncherRecentsList.this.ocf.getItemCount() - 1);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrandLauncherRecentsList", "adjustListBottomDivider notifyItemChanged e=%s", e2);
                        }
                    }
                    if (AppBrandLauncherRecentsList.this.ocn != null) {
                        g gVar = AppBrandLauncherRecentsList.this.ocn;
                        if (z || AppBrandLauncherRecentsList.this.ocf.isEmpty()) {
                            z = false;
                        }
                        View view = gVar.odr;
                        if (!z) {
                            i2 = 4;
                        }
                        view.setVisibility(i2);
                    }
                    AppMethodBeat.o(49089);
                }
            });
            AppMethodBeat.o(49094);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(49121);
        this.ocD = true;
        super.onResume();
        if (this.ocd != null) {
            this.ocd.setLayoutFrozen(false);
        }
        int i2 = this.lvW + 1;
        this.lvW = i2;
        if (i2 > 1) {
            if (this.ocm != null) {
                this.ocm.onResume();
            }
            postOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass22 */

                public final void run() {
                    AppMethodBeat.i(49081);
                    AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
                    AppMethodBeat.o(49081);
                }
            });
        }
        this.iCn = ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        this.ocu = ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
        Log.v("MicroMsg.AppBrandLauncherRecentsList", "updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu));
        AppMethodBeat.o(49121);
    }

    @Override // android.support.v4.app.Fragment
    public final void onPause() {
        AppMethodBeat.i(49122);
        this.ocD = false;
        super.onPause();
        if (this.ocm != null) {
            this.ocm.onPause();
        }
        try {
            if (this.ocd != null) {
                this.ocd.setLayoutFrozen(true);
            }
        } catch (IllegalStateException e2) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass2 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(49049);
                    Looper.myQueue().removeIdleHandler(this);
                    if (!AppBrandLauncherRecentsList.this.ocD && AppBrandLauncherRecentsList.this.ocd != null) {
                        try {
                            AppBrandLauncherRecentsList.this.ocd.setLayoutFrozen(true);
                        } catch (IllegalStateException e2) {
                        }
                    }
                    AppMethodBeat.o(49049);
                    return false;
                }
            });
        }
        p pVar = this.oci;
        FragmentActivity activity = getActivity();
        if (pVar.oep && pVar.oes != null) {
            pVar.a("startActivity", activity);
        }
        AppMethodBeat.o(49122);
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroyView() {
        AppMethodBeat.i(49123);
        super.onDestroyView();
        p pVar = this.oci;
        FragmentActivity activity = getActivity();
        if (pVar.oes != null) {
            pVar.a("onDestroy", activity);
        }
        if (this.ocm != null) {
            this.ocm.onDetached();
        }
        if (this.ocn != null) {
            this.ocn.onDetached();
        }
        if (this.ocf != null) {
            this.ocf.b(this.ocC);
        }
        if (this.ocj != null) {
            this.ocj.ocY.clear();
            this.ocj = null;
        }
        if (com.tencent.mm.kernel.g.aAf().hpY && !com.tencent.mm.kernel.a.azj()) {
            y.bAj().remove(this.ocA);
            n.buJ().remove(this.ocz);
            ((u) n.W(u.class)).remove(this.ocy);
            j.bxQ().remove(this.ocB);
        }
        this.oaC.removeCallbacksAndMessages(null);
        this.oaC.quit();
        this.obY.set(-1);
        this.obZ.set(-1);
        this.oca.set(false);
        this.ocb.set(MAlarmHandler.NEXT_FIRE_INTERVAL);
        this.oco.c(this.ocC);
        this.oco.c(this.ocx);
        AppMethodBeat.o(49123);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void bXb() {
        AppMethodBeat.i(49124);
        if (this.ocd != null) {
            LoadMoreRecyclerView loadMoreRecyclerView = this.ocd;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(loadMoreRecyclerView, a2.axQ(), "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            loadMoreRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(loadMoreRecyclerView, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(49124);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void setScene(int i2) {
        AppMethodBeat.i(49125);
        super.setScene(i2);
        this.obX.putInt("launcher_ui_enter_scene", i2);
        AppMethodBeat.o(49125);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void onDestroy() {
        AppMethodBeat.i(49126);
        super.onDestroy();
        bnk();
        this.occ.set(true);
        a.b(this.och);
        AppMethodBeat.o(49126);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(49127);
        super.onActivityCreated(bundle);
        if (!(getActivity() == null || getActivity().getIntent() == null)) {
            this.ocp = getActivity().getIntent().getIntExtra("extra_get_usage_reason", this.ocp);
            this.ocq = getActivity().getIntent().getIntExtra("extra_get_usage_prescene", this.ocq);
        }
        p pVar = this.oci;
        FragmentActivity activity = getActivity();
        if (activity.getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false)) {
            pVar.oes = new ko();
            pVar.oes.eWB = (long) activity.getIntent().getIntExtra("extra_desktop_open_session", 0);
            pVar.oet = new LinkedHashSet<>();
            pVar.oeu = new IListener<wu>() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.p.AnonymousClass1 */

                {
                    AppMethodBeat.i(160620);
                    this.__eventId = wu.class.getName().hashCode();
                    AppMethodBeat.o(160620);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* bridge */ /* synthetic */ boolean callback(wu wuVar) {
                    if (p.this.oes == null || p.this.oes.eWs > 0) {
                        return false;
                    }
                    p.this.oes.eWs = 3;
                    return false;
                }
            };
            pVar.oeu.alive();
        }
        pVar.oer = Util.nowMilliSecond();
        AppMethodBeat.o(49127);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void initView() {
        AppMethodBeat.i(49128);
        getActivity();
        this.oce = new LinearLayoutManager() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass3 */

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
                AppMethodBeat.i(49051);
                o oVar = new o(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.oce);
                oVar.atO = i2;
                startSmoothScroll(oVar);
                AppMethodBeat.o(49051);
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
                AppMethodBeat.i(49052);
                try {
                    super.onLayoutChildren(nVar, sVar);
                    AppMethodBeat.o(49052);
                } catch (IllegalArgumentException | IndexOutOfBoundsException e2) {
                    Log.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren exception(%s) retry notifyDataSetChanged", e2);
                    try {
                        AppBrandLauncherRecentsList.this.ocf.atj.notifyChanged();
                        AppMethodBeat.o(49052);
                    } catch (IllegalStateException e3) {
                        Log.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged e=%s", e3);
                        if (Util.nullAsNil(e3.getMessage()).contains("computing a layout or scrolling")) {
                            AppBrandLauncherRecentsList.this.och.sendMessage(AppBrandLauncherRecentsList.this.och.obtainMessage(2, new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(49050);
                                    try {
                                        AppBrandLauncherRecentsList.this.ocf.atj.notifyChanged();
                                        AppMethodBeat.o(49050);
                                    } catch (IllegalStateException e2) {
                                        Log.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged after scroll e=%s", e2);
                                        AppMethodBeat.o(49050);
                                    }
                                }
                            }));
                        }
                        AppMethodBeat.o(49052);
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
                int i3 = 0;
                AppMethodBeat.i(49053);
                try {
                    i3 = super.scrollVerticallyBy(i2, nVar, sVar);
                    AppMethodBeat.o(49053);
                } catch (IndexOutOfBoundsException e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e2, "scrollVerticallyBy(%d, %s)", Integer.valueOf(i2), sVar);
                    AppMethodBeat.o(49053);
                }
                return i3;
            }
        };
        this.oce.setItemPrefetchEnabled(false);
        this.ocd = new RecentsRecyclerView(getContext()) {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
            public final LinearLayoutManager bYx() {
                AppMethodBeat.i(49054);
                LinearLayoutManager linearLayoutManager = AppBrandLauncherRecentsList.this.oce;
                AppMethodBeat.o(49054);
                return linearLayoutManager;
            }
        };
        this.ocd.setVerticalScrollBarEnabled(true);
        ((FrameLayout) this.mContentView).addView(this.ocd, new ViewGroup.LayoutParams(-1, -1));
        this.ocd.a(new g(this, (byte) 0));
        this.ocd.setItemAnimator(this.oco);
        this.oco.b(this.ocC);
        this.oco.b(this.ocx);
        r rVar = new r(this.ocg);
        d dVar = new d(this, (byte) 0);
        this.ocj = dVar;
        rVar.oey.put(AppBrandRecentTaskInfo.class.hashCode(), dVar);
        this.ocf = rVar;
        this.ocf.au(true);
        this.ocf.a(this.ocC);
        this.ocd.setAdapter(this.ocf);
        this.ocd.a(new f(this, (byte) 0));
        if (getArguments() == null || getArguments().getBoolean("showHeader", true)) {
            this.ocm = new h(getActivity(), this.ocd, false);
            this.ocd.addHeaderView(this.ocm.bYp());
            this.ocm.bYp().setVisibility(8);
            this.ocm.bSx();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f2, (ViewGroup) this.ocd, false);
            this.ocd.addHeaderView(inflate);
            this.ock = inflate;
            this.ock.setVisibility(8);
        } else {
            getActivity();
            this.ocm = new a() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final void bSx() {
                }

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final void onDetached() {
                }

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final void onResume() {
                }

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final void onPause() {
                }

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final View bYp() {
                    return null;
                }

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final void zu(int i2) {
                }

                @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
                public final void zv(int i2) {
                }
            };
        }
        this.ocn = new g(getContext(), this.ocd);
        this.ocn.iT(true);
        this.ocd.setLoadingView(this.ocn.aus);
        this.ocd.showLoading(false);
        this.ocd.setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a
            public final void bYy() {
                AppMethodBeat.i(49057);
                if (!AppBrandLauncherRecentsList.this.ocn.bYD()) {
                    if (AppBrandLauncherRecentsList.this.oco.odO) {
                        AppBrandLauncherRecentsList.this.oco.b(new RecyclerView.f.a() {
                            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass7.AnonymousClass1 */

                            @Override // android.support.v7.widget.RecyclerView.f.a
                            public final void lD() {
                                AppMethodBeat.i(227722);
                                AppBrandLauncherRecentsList.this.oco.c(this);
                                if (!AppBrandLauncherRecentsList.this.ocn.bYD()) {
                                    AppMethodBeat.o(227722);
                                    return;
                                }
                                AppBrandLauncherRecentsList.t(AppBrandLauncherRecentsList.this);
                                AppMethodBeat.o(227722);
                            }
                        });
                    }
                    AppMethodBeat.o(49057);
                    return;
                }
                AppBrandLauncherRecentsList.t(AppBrandLauncherRecentsList.this);
                AppMethodBeat.o(49057);
            }
        });
        bnk();
        FragmentActivity activity = getActivity();
        View inflate2 = View.inflate(activity, R.layout.gr, null);
        j.a aVar = new j.a(activity);
        aVar.setContentView(inflate2);
        aVar.setCancelable(true);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setOnCancelListener(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00f8: INVOKE  
              (r2v6 'aVar' com.tencent.mm.plugin.appbrand.ui.j$a)
              (wrap: com.tencent.mm.plugin.appbrand.ui.j$1 : 0x00f5: CONSTRUCTOR  (r1v23 com.tencent.mm.plugin.appbrand.ui.j$1) = (r0v30 'activity' android.support.v4.app.FragmentActivity), (r2v6 'aVar' com.tencent.mm.plugin.appbrand.ui.j$a) call: com.tencent.mm.plugin.appbrand.ui.j.1.<init>(android.content.Context, com.tencent.mm.ui.base.i):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.ui.base.i.setOnCancelListener(android.content.DialogInterface$OnCancelListener):void in method: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.initView():void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00f5: CONSTRUCTOR  (r1v23 com.tencent.mm.plugin.appbrand.ui.j$1) = (r0v30 'activity' android.support.v4.app.FragmentActivity), (r2v6 'aVar' com.tencent.mm.plugin.appbrand.ui.j$a) call: com.tencent.mm.plugin.appbrand.ui.j.1.<init>(android.content.Context, com.tencent.mm.ui.base.i):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.initView():void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.ui.j, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 362
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.initView():void");
    }

    private void bnk() {
        AppMethodBeat.i(49129);
        if (this.ocE != null) {
            this.ocE.dismiss();
        }
        this.ocE = null;
        AppMethodBeat.o(49129);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void a(Intent intent, int i2) {
        AppMethodBeat.i(49130);
        super.a(intent, i2);
        this.oci.U(intent);
        AppMethodBeat.o(49130);
    }

    @Override // android.support.v4.app.Fragment
    public final void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(49131);
        super.startActivityForResult(intent, i2, bundle);
        this.oci.U(intent);
        AppMethodBeat.o(49131);
    }

    final class g extends RecyclerView.h {
        private g() {
        }

        /* synthetic */ g(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(49118);
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
            rect.top = 0;
            if (recyclerView instanceof MRecyclerView) {
                RecyclerView.v bi = recyclerView.bi(view);
                if (bi instanceof e) {
                    ((e) bi).jWr.setVisibility(((MRecyclerView) recyclerView).U(bi) == AppBrandLauncherRecentsList.this.ocf.getItemCount() + -1 ? 8 : 0);
                }
            }
            AppMethodBeat.o(49118);
        }
    }

    /* access modifiers changed from: package-private */
    public final class e extends RecyclerView.v implements View.OnClickListener, View.OnCreateContextMenuListener, o.g {
        View jWr;
        ImageView kc;
        TextView ocZ;
        TextView oda;
        TextView odb;
        TextView odc;
        View odd;
        ImageView ode;
        WeImageView odf;
        com.tencent.mm.ui.widget.b.a odg;
        final int odh = 1;
        final int odi = 2;
        final int odj = 3;
        final int odk = 4;

        e(View view) {
            super(view);
            AppMethodBeat.i(49109);
            this.jWr = view.findViewById(R.id.brt);
            this.ocZ = (TextView) view.findViewById(R.id.gh0);
            this.oda = (TextView) view.findViewById(R.id.hfo);
            this.odb = (TextView) view.findViewById(R.id.iha);
            this.odc = (TextView) view.findViewById(R.id.bgb);
            this.kc = (ImageView) view.findViewById(R.id.dt5);
            this.odd = view.findViewById(R.id.i4c);
            this.ode = (ImageView) view.findViewById(R.id.iut);
            this.odf = (WeImageView) view.findViewById(R.id.hfh);
            view.setOnClickListener(this);
            this.odg = new com.tencent.mm.ui.widget.b.a(this.aus.getContext()) {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.b.a
                public final boolean ez(int i2, int i3) {
                    AppMethodBeat.i(49104);
                    if (e.this.aus.getParent() != null) {
                        e.this.aus.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    boolean ez = super.ez(i2, i3);
                    AppMethodBeat.o(49104);
                    return ez;
                }

                @Override // com.tencent.mm.ui.widget.b.a
                public final void onDismiss() {
                    AppMethodBeat.i(49105);
                    if (e.this.aus.getParent() != null) {
                        e.this.aus.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    super.onDismiss();
                    AppMethodBeat.o(49105);
                }
            };
            this.odg.c(this.aus, this, this);
            AppMethodBeat.o(49109);
        }

        private int bYB() {
            AppMethodBeat.i(49110);
            int U = AppBrandLauncherRecentsList.this.ocd.U(this);
            AppMethodBeat.o(49110);
            return U;
        }

        /* access modifiers changed from: package-private */
        public final AppBrandRecentTaskInfo bYC() {
            AppMethodBeat.i(49111);
            try {
                AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) AppBrandLauncherRecentsList.this.ocf.zy(bYB());
                AppMethodBeat.o(49111);
                return appBrandRecentTaskInfo;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e2, "getAppInfo", new Object[0]);
                AppMethodBeat.o(49111);
                return null;
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(49112);
            AppBrandRecentTaskInfo bYC = bYC();
            if (bYC == null) {
                AppMethodBeat.o(49112);
                return;
            }
            if (AppBrandLauncherRecentsList.this.obT) {
                if (bYC.kVp) {
                    contextMenu.add(0, 1, 0, this.aus.getContext().getString(R.string.sh));
                } else if (com.tencent.mm.plugin.appbrand.launching.f.b.t(AppBrandLauncherRecentsList.this.iCn, AppBrandLauncherRecentsList.this.ocu)) {
                    contextMenu.add(0, 1, 0, this.aus.getContext().getString(R.string.sd));
                }
            }
            contextMenu.add(0, 2, 0, this.aus.getContext().getString(R.string.n_));
            if (com.tencent.mm.plugin.appbrand.report.a.a.bUC()) {
                contextMenu.add(0, 3, 0, this.aus.getContext().getString(R.string.e_m));
            }
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                contextMenu.add(0, 4, 0, MMApplicationContext.getContext().getString(R.string.sj));
            }
            AppMethodBeat.o(49112);
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            final int i3;
            final String str;
            boolean z;
            AppMethodBeat.i(49113);
            final AppBrandRecentTaskInfo bYC = bYC();
            if (bYC == null || menuItem == null) {
                AppMethodBeat.o(49113);
            } else if (AppBrandLauncherRecentsList.this.getActivity() == null) {
                AppMethodBeat.o(49113);
            } else {
                switch (AppBrandLauncherRecentsList.this.getActivity().getIntent().getIntExtra("extra_get_usage_reason", 3)) {
                    case 9:
                        i3 = 7;
                        break;
                    default:
                        i3 = 1;
                        break;
                }
                if (i3 == 7) {
                    str = l.bUw();
                } else {
                    if (TextUtils.isEmpty(AppBrandLauncherRecentsList.this.oct)) {
                        AppBrandLauncherRecentsList.this.oct = l.bUv();
                    }
                    str = AppBrandLauncherRecentsList.this.oct;
                }
                if (1 != menuItem.getItemId()) {
                    if (2 == menuItem.getItemId()) {
                        if (bYC.kVp && !AppBrandLauncherRecentsList.this.obU) {
                            AppBrandLauncherRecentsList.this.oaC.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(49108);
                                    ((u) n.W(u.class)).j(bYC.dCl, bYC.eix, true);
                                    l.a(bYC, 7, i3, str);
                                    AppMethodBeat.o(49108);
                                }
                            });
                        }
                        AppBrandLauncherRecentsList.this.ocg.zx(bYB());
                        AppBrandLauncherRecentsList.this.oco.odO = true;
                        AppBrandLauncherRecentsList.this.ocx.bYA();
                        AppBrandLauncherRecentsList.this.ocf.ck(bYB());
                        AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
                        an.t(bYC.dCl, bYC.appId, bYC.eix);
                    }
                    if (3 == menuItem.getItemId()) {
                        if (bYC.cyo == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        String str2 = z ? "game" : WeChatBrands.Business.GROUP_MP;
                        Pattern s = com.tencent.mm.plugin.appbrand.keylogger.f.s(bYC.appId, bYC.username);
                        Context context = MMApplicationContext.getContext();
                        Intent intent = new Intent();
                        intent.setClass(context, KeyStepAnalyserActivity.class);
                        intent.addFlags(268435456);
                        intent.putExtra("process", KSProcessWeAppLaunch.class);
                        intent.putExtra("category", str2);
                        intent.putExtra("session_id_prefix", s);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyser", "analyse", "(Ljava/lang/Class;Ljava/lang/String;Ljava/util/regex/Pattern;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepAnalyser", "analyse", "(Ljava/lang/Class;Ljava/lang/String;Ljava/util/regex/Pattern;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(49113);
                        return;
                    }
                    if (4 == menuItem.getItemId()) {
                        Context context2 = AppBrandLauncherRecentsList.this.getContext();
                        String str3 = bYC.dCl;
                        WxaExposedParams.a aVar = new WxaExposedParams.a();
                        aVar.appId = bYC.appId;
                        aVar.from = 3;
                        AppBrandProfileUI.a(context2, str3, 3, "", aVar.bAv(), null, null);
                    }
                    AppMethodBeat.o(49113);
                } else if (AppBrandLauncherRecentsList.this.obU || AppBrandLauncherRecentsList.this.ocg.bYJ().size() < AppBrandLauncherRecentsList.this.obS || bYC.kVp) {
                    AppBrandLauncherRecentsList.this.oaC.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.AnonymousClass2 */

                        public final void run() {
                            int i2;
                            AppMethodBeat.i(49107);
                            if (!bYC.kVp) {
                                int bk = ((u) n.W(u.class)).bk(bYC.dCl, bYC.eix);
                                if (bk == -2) {
                                    AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.AnonymousClass2.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(49106);
                                            if (AppBrandLauncherRecentsList.this.getActivity() == null) {
                                                AppMethodBeat.o(49106);
                                                return;
                                            }
                                            h.a((Context) AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(R.string.k4, Integer.valueOf(AppBrandLauncherRecentsList.this.obS)), "", AppBrandLauncherRecentsList.this.getResources().getString(R.string.x_), false, (DialogInterface.OnClickListener) null);
                                            AppMethodBeat.o(49106);
                                        }
                                    });
                                    AppMethodBeat.o(49107);
                                    return;
                                } else if (bk == -1) {
                                    Log.e("MicroMsg.AppBrandLauncherRecentsList", "addStarApp, username %s, type %d, fatal", bYC.dCl, Integer.valueOf(bYC.eix));
                                    AppMethodBeat.o(49107);
                                    return;
                                } else {
                                    AppBrandLauncherRecentsList.this.postOnUiThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.AnonymousClass2.AnonymousClass2 */

                                        public final void run() {
                                            AppMethodBeat.i(175087);
                                            if (AppBrandLauncherRecentsList.this.getContext() == null) {
                                                AppMethodBeat.o(175087);
                                                return;
                                            }
                                            com.tencent.mm.ui.base.u.cG(AppBrandLauncherRecentsList.this.getContext(), AppBrandLauncherRecentsList.this.getContext().getResources().getString(R.string.sf));
                                            AppMethodBeat.o(175087);
                                        }
                                    });
                                    i2 = 6;
                                }
                            } else {
                                ((u) n.W(u.class)).j(bYC.dCl, bYC.eix, true);
                                if (!AppBrandLauncherRecentsList.this.obU && AppBrandLauncherRecentsList.this.obT) {
                                    n.buJ().a(bYC.dCl, bYC.eix, false, 0, 2, (String) null, false);
                                }
                                AppBrandLauncherRecentsList.this.postOnUiThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.AnonymousClass2.AnonymousClass3 */

                                    public final void run() {
                                        AppMethodBeat.i(175088);
                                        if (AppBrandLauncherRecentsList.this.getContext() == null) {
                                            AppMethodBeat.o(175088);
                                            return;
                                        }
                                        com.tencent.mm.ui.base.u.cG(AppBrandLauncherRecentsList.this.getContext(), AppBrandLauncherRecentsList.this.getContext().getResources().getString(R.string.sg));
                                        AppMethodBeat.o(175088);
                                    }
                                });
                                i2 = 7;
                            }
                            l.a(bYC, i2, i3, str);
                            AppMethodBeat.o(49107);
                        }
                    });
                    AppBrandLauncherRecentsList.this.oco.odO = true;
                    AppMethodBeat.o(49113);
                } else {
                    if (AppBrandLauncherRecentsList.this.getActivity() != null) {
                        h.a((Context) AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(R.string.k4, Integer.valueOf(AppBrandLauncherRecentsList.this.obS)), "", AppBrandLauncherRecentsList.this.getResources().getString(R.string.x_), false, (DialogInterface.OnClickListener) null);
                    }
                    AppMethodBeat.o(49113);
                }
            }
        }

        public final void onClick(View view) {
            t.d dVar;
            long j2;
            AppMethodBeat.i(49114);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            AppBrandRecentTaskInfo bYC = bYC();
            if (bYC == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(49114);
            } else if (AppBrandLauncherRecentsList.this.getActivity() == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(49114);
            } else {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1001;
                switch (AppBrandLauncherRecentsList.this.mScene) {
                    case 10:
                        appBrandStatObject.ecU = 11;
                        break;
                    case 11:
                        appBrandStatObject.ecU = 12;
                        break;
                    case 13:
                        appBrandStatObject.ecU = 13;
                        break;
                }
                p pVar = AppBrandLauncherRecentsList.this.oci;
                int bYB = bYB();
                if (pVar.oes != null) {
                    pVar.oes.eWs = 2;
                    pVar.oes.eWt = (long) bYB;
                    ko koVar = pVar.oes;
                    koVar.eWu = koVar.x("ClickAppid", bYC.appId, true);
                    ko koVar2 = pVar.oes;
                    koVar2.eWv = koVar2.x("ClickAppidName", bYC.nickname, true);
                    ko koVar3 = pVar.oes;
                    if (bYC.kVp) {
                        j2 = 1;
                    } else {
                        j2 = 0;
                    }
                    koVar3.eWw = j2;
                }
                com.tencent.mm.plugin.appbrand.report.f fVar = com.tencent.mm.plugin.appbrand.report.f.nGV;
                AppBrandLauncherDesktopReporter b2 = com.tencent.mm.plugin.appbrand.report.f.b(AppBrandLauncherRecentsList.this.getActivity());
                String str = bYC.appId;
                int bYB2 = bYB();
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = 6;
                objArr[1] = "";
                objArr[2] = "";
                objArr[3] = Integer.valueOf(bYB2);
                if (str == null) {
                    str = "";
                }
                objArr[4] = str;
                objArr[5] = "";
                objArr[6] = Long.valueOf(b2.mSessionId);
                hVar.a(19468, objArr);
                AppBrandLaunchProxyUI.a(AppBrandLauncherRecentsList.this.getActivity(), bYC.dCl, bYC.appId, null, bYC.eix, -1, appBrandStatObject, null, null);
                if (!(AppBrandLauncherRecentsList.this.getActivity() == null || !(AppBrandLauncherRecentsList.this.getActivity() instanceof AppBrandLauncherUI) || (dVar = ((AppBrandLauncherUI) AppBrandLauncherRecentsList.this.getActivity()).nTP) == null)) {
                    dVar.kVm[7] = "1";
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(49114);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class d extends s<AppBrandRecentTaskInfo, e> {
        final Map<String, String> ocY;

        private d() {
            AppMethodBeat.i(49095);
            this.ocY = new HashMap();
            AppMethodBeat.o(49095);
        }

        /* synthetic */ d(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.ui.recents.s
        public final /* synthetic */ boolean a(e eVar, Object obj) {
            AppMethodBeat.i(49100);
            e eVar2 = eVar;
            if (obj == null || !(obj instanceof Bundle) || ((Bundle) obj).size() <= 0) {
                AppMethodBeat.o(49100);
                return false;
            }
            if (((Bundle) obj).containsKey("nick_name")) {
                a(eVar2, ((Bundle) obj).getString("nick_name"));
            }
            if (!(((Bundle) obj).get("running_flag") == null && ((Bundle) obj).get("third_party_app_using_desc") == null)) {
                ((Bundle) obj).getLong("running_flag", 0);
                b(eVar2, ((Bundle) obj).getString("third_party_app_using_desc"));
            }
            if (((Bundle) obj).get("icon") != null) {
                c(eVar2, ((Bundle) obj).getString("icon"));
            }
            if (!AppBrandLauncherRecentsList.this.oco.odO) {
                ((Bundle) obj).containsKey("star");
            }
            a(eVar2);
            AppMethodBeat.o(49100);
            return true;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.ui.recents.s
        public final /* synthetic */ void b(e eVar, AppBrandRecentTaskInfo appBrandRecentTaskInfo) {
            AppMethodBeat.i(49102);
            e eVar2 = eVar;
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = appBrandRecentTaskInfo;
            eVar2.oda.setVisibility(8);
            eVar2.jWr.setVisibility(0);
            a(eVar2, Util.isNullOrNil(appBrandRecentTaskInfo2.appName) ? appBrandRecentTaskInfo2.dCl.replaceFirst("@app", "") : appBrandRecentTaskInfo2.appName);
            b(eVar2, appBrandRecentTaskInfo2.kWc ? appBrandRecentTaskInfo2.kWd : "");
            c(eVar2, appBrandRecentTaskInfo2.kVo);
            String vO = com.tencent.mm.plugin.appbrand.appcache.e.vO(appBrandRecentTaskInfo2.eix);
            if (Util.isNullOrNil(vO)) {
                eVar2.odb.setVisibility(8);
            } else {
                eVar2.odb.setText(vO);
                eVar2.odb.setVisibility(0);
            }
            a(eVar2);
            if (!appBrandRecentTaskInfo2.kVq || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_appbrand_rencent_use_list, 0) != 1) {
                eVar2.ode.setVisibility(8);
                AppMethodBeat.o(49102);
                return;
            }
            eVar2.ode.setVisibility(0);
            AppMethodBeat.o(49102);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.ui.recents.s
        public final /* synthetic */ long cL(AppBrandRecentTaskInfo appBrandRecentTaskInfo) {
            AppMethodBeat.i(49101);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = appBrandRecentTaskInfo;
            long hashCode = (long) (appBrandRecentTaskInfo2.dCl + appBrandRecentTaskInfo2.eix).hashCode();
            AppMethodBeat.o(49101);
            return hashCode;
        }

        private void a(e eVar) {
            AppMethodBeat.i(49096);
            LoadMoreRecyclerView unused = AppBrandLauncherRecentsList.this.ocd;
            if (LoadMoreRecyclerView.bw(eVar.aus) == AppBrandLauncherRecentsList.this.ocf.getItemCount() - 1) {
                eVar.jWr.setVisibility(8);
            } else {
                eVar.jWr.setVisibility(0);
            }
            if (AppBrandLauncherRecentsList.this.obV) {
                TextView textView = eVar.odc;
                LoadMoreRecyclerView unused2 = AppBrandLauncherRecentsList.this.ocd;
                textView.setText(String.valueOf(LoadMoreRecyclerView.bw(eVar.aus)));
                eVar.odc.setVisibility(0);
                AppMethodBeat.o(49096);
                return;
            }
            eVar.odc.setVisibility(8);
            AppMethodBeat.o(49096);
        }

        private static void a(e eVar, String str) {
            AppMethodBeat.i(49098);
            eVar.ocZ.setText(str);
            AppMethodBeat.o(49098);
        }

        private void b(e eVar, String str) {
            AppMethodBeat.i(227725);
            eVar.oda.setVisibility(8);
            eVar.odf.setVisibility(8);
            eVar.kc.setColorFilter((ColorFilter) null);
            if (!TextUtils.isEmpty(str)) {
                eVar.oda.setVisibility(0);
                eVar.odf.setVisibility(0);
                eVar.odf.setImageResource(R.raw.app_brand_third_party_running_flag);
                eVar.odf.setIconColor(AppBrandLauncherRecentsList.this.getResources().getColor(R.color.l4));
                eVar.oda.setText(str);
            }
            AppMethodBeat.o(227725);
        }

        /* access modifiers changed from: package-private */
        public final void c(e eVar, String str) {
            AppMethodBeat.i(49099);
            boolean unused = AppBrandLauncherRecentsList.this.ocr;
            this.ocY.put(str, com.tencent.mm.modelappbrand.a.b.aXY().a(eVar.kc, str, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB));
            AppMethodBeat.o(49099);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // com.tencent.mm.plugin.appbrand.ui.recents.s
        public final /* synthetic */ e a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            AppMethodBeat.i(49103);
            e eVar = new e(layoutInflater.inflate(R.layout.e8, viewGroup, false));
            AppMethodBeat.o(49103);
            return eVar;
        }
    }

    final class f extends RecyclerView.l implements Runnable {
        private f() {
        }

        /* synthetic */ f(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(49115);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsListScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            AppBrandLauncherRecentsList.A(AppBrandLauncherRecentsList.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsListScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(49115);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(49116);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsListScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            AppBrandLauncherRecentsList.this.ocr = i2 == 2;
            if (i2 == 0) {
                AppBrandLauncherRecentsList.this.postOnUiThread(this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsList$RecentsListScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(49116);
        }

        public final void run() {
            AppBrandRecentTaskInfo bYC;
            AppMethodBeat.i(49117);
            if (!(AppBrandLauncherRecentsList.this.ocd == null || AppBrandLauncherRecentsList.this.oce == null || AppBrandLauncherRecentsList.this.ocf == null || AppBrandLauncherRecentsList.this.ocj == null)) {
                int ks = AppBrandLauncherRecentsList.this.oce.ks();
                int ku = AppBrandLauncherRecentsList.this.oce.ku();
                for (int i2 = ks; i2 <= ku; i2++) {
                    RecyclerView.v ch = AppBrandLauncherRecentsList.this.ocd.ch(i2);
                    if ((ch instanceof e) && (bYC = ((e) ch).bYC()) != null) {
                        AppBrandLauncherRecentsList.this.ocj.c((e) ch, bYC.kVo);
                    }
                }
            }
            AppMethodBeat.o(49117);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public final class a extends Handler {
        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(227723);
            aVar.bYz();
            AppMethodBeat.o(227723);
        }

        public a() {
            super(Looper.getMainLooper());
            AppMethodBeat.i(49082);
            AppMethodBeat.o(49082);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(49083);
            if (message.what == 1) {
                ((Runnable) message.obj).run();
                removeMessages(2);
                synchronized (AppBrandLauncherRecentsList.this.ocv) {
                    try {
                        AppBrandLauncherRecentsList.this.ocv.notifyAll();
                    } finally {
                        AppMethodBeat.o(49083);
                    }
                }
            } else if (message.what == 2) {
                ((Runnable) message.obj).run();
                AppMethodBeat.o(49083);
            } else {
                super.handleMessage(message);
                AppMethodBeat.o(49083);
            }
        }

        private void bYz() {
            AppMethodBeat.i(49084);
            removeMessages(1);
            removeMessages(2);
            removeCallbacksAndMessages(null);
            AppMethodBeat.o(49084);
        }

        static /* synthetic */ void b(a aVar) {
            AppMethodBeat.i(227724);
            aVar.bYz();
            AppMethodBeat.o(227724);
        }
    }

    static /* synthetic */ boolean c(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.i(49132);
        if (!appBrandLauncherRecentsList.ocf.isEmpty() || ((appBrandLauncherRecentsList.ocm.bYp() != null && appBrandLauncherRecentsList.ocm.bYp().getVisibility() == 0) || appBrandLauncherRecentsList.getActivity() == null)) {
            if (!(appBrandLauncherRecentsList.ocf == null || appBrandLauncherRecentsList.ock == null)) {
                if (appBrandLauncherRecentsList.ocf.isEmpty()) {
                    appBrandLauncherRecentsList.ock.setVisibility(8);
                } else {
                    appBrandLauncherRecentsList.ock.setVisibility(0);
                }
            }
            if (appBrandLauncherRecentsList.ocf.isEmpty()) {
                if (appBrandLauncherRecentsList.ocl == null) {
                    appBrandLauncherRecentsList.ocl = AppBrandLauncherBlankPage.ag(appBrandLauncherRecentsList.getActivity(), appBrandLauncherRecentsList.getString(R.string.n8));
                    ((FrameLayout) appBrandLauncherRecentsList.mContentView).addView(appBrandLauncherRecentsList.ocl, 0);
                    ((ViewGroup.MarginLayoutParams) appBrandLauncherRecentsList.ocl.getLayoutParams()).topMargin = appBrandLauncherRecentsList.ocm.bYp().getMeasuredHeight();
                    appBrandLauncherRecentsList.ocl.requestLayout();
                }
                if (appBrandLauncherRecentsList.ocm instanceof h) {
                    h hVar = (h) appBrandLauncherRecentsList.ocm;
                    if (hVar.nmW.getChildCount() > 0) {
                        View childAt = hVar.nmW.getChildAt(hVar.nmW.getChildCount() - 1);
                        if (childAt.getId() == R.id.p8) {
                            childAt.setVisibility(4);
                        }
                    }
                }
                appBrandLauncherRecentsList.ocn.aus.setVisibility(8);
                appBrandLauncherRecentsList.ocl.setVisibility(0);
            } else {
                if (appBrandLauncherRecentsList.ocl != null) {
                    appBrandLauncherRecentsList.ocl.setVisibility(8);
                }
                if (appBrandLauncherRecentsList.ocm instanceof h) {
                    h hVar2 = (h) appBrandLauncherRecentsList.ocm;
                    if (hVar2.nmW.getChildCount() > 0) {
                        View childAt2 = hVar2.nmW.getChildAt(hVar2.nmW.getChildCount() - 1);
                        if (childAt2.getId() == R.id.p8) {
                            childAt2.setVisibility(0);
                        }
                    }
                }
                appBrandLauncherRecentsList.ocn.aus.setVisibility(0);
            }
            AppMethodBeat.o(49132);
            return true;
        }
        ((com.tencent.mm.plugin.appbrand.ui.launcher.a) appBrandLauncherRecentsList.getActivity()).iI(false);
        AppMethodBeat.o(49132);
        return false;
    }

    static /* synthetic */ void a(AppBrandLauncherRecentsList appBrandLauncherRecentsList, boolean z, long j2, boolean z2) {
        long max;
        long j3;
        ArrayList<AppBrandRecentTaskInfo> a2;
        AppMethodBeat.i(227727);
        if (!appBrandLauncherRecentsList.bYv()) {
            l bYL = appBrandLauncherRecentsList.ocg.bYL();
            if (!Util.isNullOrNil(bYL) || z) {
                ArrayList<AppBrandRecentTaskInfo> bYK = bYL.bYK();
                if (Util.isNullOrNil(bYK)) {
                    max = Long.MAX_VALUE;
                    j3 = 0;
                } else {
                    long j4 = bYK.get(bYK.size() - 1).crj;
                    max = Math.max(bYK.get(0).crj, j2);
                    j3 = j4;
                }
                ArrayList<AppBrandRecentTaskInfo> L = appBrandLauncherRecentsList.obW.L(x.d(x.this.kVs.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s>=? and %s<=? and %s=?", ch.COL_UPDATETIME, ch.COL_UPDATETIME, "scene"), new String[]{String.valueOf(j3), String.valueOf(max), "2"}, null, null, String.format(Locale.US, " %s desc ", ch.COL_UPDATETIME), 2)));
                if (appBrandLauncherRecentsList.obU) {
                    a2 = new ArrayList<>(0);
                } else {
                    a2 = appBrandLauncherRecentsList.obT ? ((u) n.W(u.class)).a(ag.a.ASC) : null;
                }
                final l d2 = l.d(a2, L);
                Log.d("MicroMsg.AppBrandLauncherRecentsList", "diff old.size %d, new.size %d", Integer.valueOf(bYL.size()), Integer.valueOf(d2.size()));
                if (!appBrandLauncherRecentsList.bYv()) {
                    if (Util.isNullOrNil(d2)) {
                        appBrandLauncherRecentsList.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(49048);
                                int size = AppBrandLauncherRecentsList.this.ocg.size();
                                if (size > 0) {
                                    AppBrandLauncherRecentsList.this.ocg.clear();
                                    AppBrandLauncherRecentsList.this.ocf.at(0, size);
                                }
                                AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
                                synchronized (AppBrandLauncherRecentsList.this.ocv) {
                                    try {
                                        AppBrandLauncherRecentsList.this.ocv.notifyAll();
                                    } finally {
                                        AppMethodBeat.o(49048);
                                    }
                                }
                            }
                        });
                        appBrandLauncherRecentsList.bYw();
                        AppMethodBeat.o(227727);
                        return;
                    } else if (Util.isNullOrNil(bYL)) {
                        appBrandLauncherRecentsList.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass12 */

                            public final void run() {
                                AppMethodBeat.i(49064);
                                if (!Util.isNullOrNil(AppBrandLauncherRecentsList.this.ocg)) {
                                    int size = AppBrandLauncherRecentsList.this.ocg.size();
                                    AppBrandLauncherRecentsList.this.ocg.clear();
                                    AppBrandLauncherRecentsList.this.ocf.at(0, size);
                                }
                                AppBrandLauncherRecentsList.this.ocg.addAll(d2);
                                AppBrandLauncherRecentsList.this.ocf.as(0, d2.size());
                                synchronized (AppBrandLauncherRecentsList.this.ocv) {
                                    try {
                                        AppBrandLauncherRecentsList.this.ocv.notifyAll();
                                    } finally {
                                        AppMethodBeat.o(49064);
                                    }
                                }
                            }
                        });
                        appBrandLauncherRecentsList.bYw();
                        AppMethodBeat.o(227727);
                        return;
                    } else {
                        final c.b a3 = android.support.v7.h.c.a(new m(bYL, d2), z2);
                        a.a(appBrandLauncherRecentsList.och);
                        appBrandLauncherRecentsList.och.sendMessage(appBrandLauncherRecentsList.och.obtainMessage(1, new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass16 */

                            public final void run() {
                                AppMethodBeat.i(49069);
                                if (AppBrandLauncherRecentsList.this.ocd == null || !AppBrandLauncherRecentsList.this.ocd.isAttachedToWindow()) {
                                    AppMethodBeat.o(49069);
                                } else if (AppBrandLauncherRecentsList.this.ocd.ld()) {
                                    AppBrandLauncherRecentsList.this.och.sendMessage(AppBrandLauncherRecentsList.this.och.obtainMessage(2, this));
                                    AppMethodBeat.o(49069);
                                } else {
                                    AppBrandLauncherRecentsList.this.ocg.clear();
                                    AppBrandLauncherRecentsList.this.ocg.addAll(d2);
                                    MMHandlerThread.setCurrentPriority(-8);
                                    a3.a(AppBrandLauncherRecentsList.this.ocw);
                                    AppMethodBeat.o(49069);
                                }
                            }
                        }));
                        appBrandLauncherRecentsList.bYw();
                    }
                }
            }
        }
        AppMethodBeat.o(227727);
    }

    static /* synthetic */ void a(AppBrandLauncherRecentsList appBrandLauncherRecentsList, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(227728);
        Log.d("MicroMsg.AppBrandLauncherRecentsList", "onFirstPageFetched fromSvr %b", Boolean.valueOf(z));
        appBrandLauncherRecentsList.bnk();
        appBrandLauncherRecentsList.ocd.showLoading(true);
        if (z) {
            appBrandLauncherRecentsList.ocs = true;
            appBrandLauncherRecentsList.oca.set(false);
            appBrandLauncherRecentsList.ocn.iT(com.tencent.mm.plugin.appbrand.appusage.j.bxS());
            final l bYL = appBrandLauncherRecentsList.ocg.bYL();
            final l e2 = appBrandLauncherRecentsList.ocg.bYL().e(arrayList, arrayList2);
            appBrandLauncherRecentsList.oaC.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(49066);
                    final c.b a2 = android.support.v7.h.c.a(new m(bYL, e2), false);
                    a.a(AppBrandLauncherRecentsList.this.och);
                    AppBrandLauncherRecentsList.this.och.sendMessage(AppBrandLauncherRecentsList.this.och.obtainMessage(1, new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass13.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(49065);
                            AppBrandLauncherRecentsList.this.ocg.a(e2);
                            MMHandlerThread.setCurrentPriority(-8);
                            a2.a(AppBrandLauncherRecentsList.this.ocf);
                            AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
                            AppMethodBeat.o(49065);
                        }
                    }));
                    AppMethodBeat.o(49066);
                }
            });
        } else {
            appBrandLauncherRecentsList.ocg.e(arrayList, arrayList2);
            appBrandLauncherRecentsList.ocf.aq(0, appBrandLauncherRecentsList.ocg.size());
            if (appBrandLauncherRecentsList.ocg.size() > 0) {
                com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, z.APPBRAND_LAUNCHER);
                com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WAGAME, z.APPBRAND_LAUNCHER);
            }
            if (appBrandLauncherRecentsList.ock != null) {
                appBrandLauncherRecentsList.ock.setVisibility(0);
            }
            if (!(appBrandLauncherRecentsList.getActivity() == null || !(appBrandLauncherRecentsList.getActivity() instanceof AppBrandLauncherUI) || appBrandLauncherRecentsList.getActivity().getIntent() == null || appBrandLauncherRecentsList.ock == null || !appBrandLauncherRecentsList.getActivity().getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false))) {
                final AnonymousClass5 r2 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(49055);
                        if (AppBrandLauncherRecentsList.this.ocd.computeVerticalScrollOffset() == 0) {
                            AppBrandLauncherRecentsList.this.ocd.scrollBy(0, AppBrandLauncherRecentsList.this.ock.getTop());
                        }
                        AppMethodBeat.o(49055);
                    }
                };
                if (android.support.v4.view.u.az(appBrandLauncherRecentsList.ock)) {
                    r2.run();
                } else {
                    appBrandLauncherRecentsList.ock.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass6 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(49056);
                            AppBrandLauncherRecentsList.this.ock.getViewTreeObserver().removeOnPreDrawListener(this);
                            r2.run();
                            AppMethodBeat.o(49056);
                            return false;
                        }
                    });
                }
            }
        }
        if ((z || appBrandLauncherRecentsList.ocg.isEmpty()) && !z) {
            z2 = false;
        }
        if (z2) {
            final AnonymousClass14 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(49067);
                    AppBrandLauncherRecentsList.A(AppBrandLauncherRecentsList.this);
                    AppMethodBeat.o(49067);
                }
            };
            appBrandLauncherRecentsList.ocd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass15 */

                public final boolean onPreDraw() {
                    AppMethodBeat.i(49068);
                    AppBrandLauncherRecentsList.this.ocd.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppBrandLauncherRecentsList.this.ocd.post(r0);
                    AppMethodBeat.o(49068);
                    return false;
                }
            });
        }
        AppMethodBeat.o(227728);
    }

    static /* synthetic */ void a(AppBrandLauncherRecentsList appBrandLauncherRecentsList, ArrayList arrayList) {
        AppMethodBeat.i(227729);
        int size = appBrandLauncherRecentsList.ocg.size();
        if (!Util.isNullOrNil(arrayList)) {
            appBrandLauncherRecentsList.ocg.bYK().addAll(arrayList);
            appBrandLauncherRecentsList.ocf.as(size, arrayList.size());
            if (size > 0) {
                appBrandLauncherRecentsList.ocf.ci(size - 1);
            }
        } else if (!com.tencent.mm.plugin.appbrand.appusage.j.bxS()) {
            appBrandLauncherRecentsList.ocn.iT(false);
            if (appBrandLauncherRecentsList.ocn.aus != null) {
                appBrandLauncherRecentsList.ocn.aus.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(49060);
                        if (AppBrandLauncherRecentsList.this.ocn.aus == null || AppBrandLauncherRecentsList.this.ocn.aus.getHeight() <= 0 || AppBrandLauncherRecentsList.this.ocd == null) {
                            AppMethodBeat.o(49060);
                            return;
                        }
                        try {
                            AppBrandLauncherRecentsList.this.ocd.scrollBy(0, AppBrandLauncherRecentsList.this.ocn.aus.getHeight());
                            AppMethodBeat.o(49060);
                        } catch (IndexOutOfBoundsException e2) {
                            Log.e("MicroMsg.AppBrandLauncherRecentsList", "makeFooterFullyVisible scrollBy e=%s", e2);
                            AppMethodBeat.o(49060);
                        }
                    }
                });
            }
        } else if (!(appBrandLauncherRecentsList.ocn == null || appBrandLauncherRecentsList.ocn.aus == null || !appBrandLauncherRecentsList.ocn.aus.isShown())) {
            appBrandLauncherRecentsList.postOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(49061);
                    AppBrandLauncherRecentsList.t(AppBrandLauncherRecentsList.this);
                    AppMethodBeat.o(49061);
                }
            });
        }
        appBrandLauncherRecentsList.oca.set(false);
        AppMethodBeat.o(227729);
    }

    static /* synthetic */ void t(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.i(227730);
        if (appBrandLauncherRecentsList.ocs && !appBrandLauncherRecentsList.oca.get()) {
            appBrandLauncherRecentsList.obZ.set(Util.nowMilliSecond());
            if (com.tencent.mm.plugin.appbrand.appusage.j.bxS()) {
                com.tencent.mm.plugin.appbrand.appusage.j.bxQ().a(appBrandLauncherRecentsList.obZ.get(), false, appBrandLauncherRecentsList.obX, appBrandLauncherRecentsList.ocp, appBrandLauncherRecentsList.ocq);
                appBrandLauncherRecentsList.oca.set(true);
                AppMethodBeat.o(227730);
                return;
            }
            ArrayList<AppBrandRecentTaskInfo> bYK = appBrandLauncherRecentsList.ocg.bYK();
            final long j2 = Util.isNullOrNil(bYK) ? MAlarmHandler.NEXT_FIRE_INTERVAL : bYK.get(bYK.size() - 1).crj;
            appBrandLauncherRecentsList.oaC.postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(49059);
                    final ArrayList<AppBrandRecentTaskInfo> L = AppBrandLauncherRecentsList.this.obW.L(n.buJ().kVB.g(j2, 30));
                    a.a(AppBrandLauncherRecentsList.this.och);
                    AppBrandLauncherRecentsList.this.och.sendMessage(AppBrandLauncherRecentsList.this.och.obtainMessage(1, new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(49058);
                            if (AppBrandLauncherRecentsList.this.ocd == null || !android.support.v4.view.u.aD(AppBrandLauncherRecentsList.this.ocd)) {
                                AppMethodBeat.o(49058);
                            } else if (AppBrandLauncherRecentsList.this.ocd.ld()) {
                                AppBrandLauncherRecentsList.this.och.obtainMessage(2, this).sendToTarget();
                                AppMethodBeat.o(49058);
                            } else {
                                AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, L);
                                AppMethodBeat.o(49058);
                            }
                        }
                    }));
                    AppMethodBeat.o(49059);
                }
            });
        }
        AppMethodBeat.o(227730);
    }

    static /* synthetic */ void v(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.i(227731);
        y.bAj().add(appBrandLauncherRecentsList.oaC.getSerial(), appBrandLauncherRecentsList.ocA);
        n.buJ().add(appBrandLauncherRecentsList.oaC.getSerial(), appBrandLauncherRecentsList.ocz);
        if (appBrandLauncherRecentsList.obT) {
            ((u) n.W(u.class)).add(appBrandLauncherRecentsList.oaC.getSerial(), appBrandLauncherRecentsList.ocy);
        }
        com.tencent.mm.plugin.appbrand.appusage.j.bxQ().add(appBrandLauncherRecentsList.oaC.getSerial(), appBrandLauncherRecentsList.ocB);
        AppMethodBeat.o(227731);
    }

    static /* synthetic */ void A(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        List subList;
        AppMethodBeat.i(227732);
        int U = appBrandLauncherRecentsList.ocd.U(appBrandLauncherRecentsList.ocd.k(appBrandLauncherRecentsList.oce.ks(), false));
        int U2 = appBrandLauncherRecentsList.ocd.U(appBrandLauncherRecentsList.ocd.k(appBrandLauncherRecentsList.oce.ku(), false));
        p pVar = appBrandLauncherRecentsList.oci;
        l bYL = appBrandLauncherRecentsList.ocg.bYL();
        if (pVar.oes != null && pVar.oet.size() < 20 && !bYL.isEmpty()) {
            int max = Math.max(U, 0);
            int min = Math.min(bYL.size() - 1, U2) + 1;
            if (max > min) {
                subList = Collections.emptyList();
            } else {
                subList = bYL.subList(max, min);
            }
            pVar.oet.addAll(subList);
        }
        if (appBrandLauncherRecentsList.getActivity() != null && appBrandLauncherRecentsList.ocg.size() > 0) {
            com.tencent.mm.plugin.appbrand.report.f fVar = com.tencent.mm.plugin.appbrand.report.f.nGV;
            com.tencent.mm.plugin.appbrand.report.f.b(appBrandLauncherRecentsList.getActivity()).nGX.addAll(kotlin.a.j.o(new kotlin.k.f(Math.max(U, 0), Math.min(appBrandLauncherRecentsList.ocg.size() - 1, U2))));
        }
        AppMethodBeat.o(227732);
    }
}
