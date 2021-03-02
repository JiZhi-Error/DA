package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.hellhound.a.a.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.g;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private int mActionBarHeight = -1;
    private int mScreenHeight = 0;
    private int mScreenRealHeight = 0;
    private int mScrollState = 0;
    private int mStatusBarHeight = -1;
    private int mVisibleItemCount = 0;
    private long sBA = -1;
    private String sBB = "";
    private WindowManager sBC = null;
    private final int sBg;
    private final int sBh;
    public final Map<String, c> sBi;
    public final Map<String, Boolean> sBj = new HashMap();
    private ebf sBk;
    private long sBl = 0;
    private h sBm;
    private g sBn;
    private final b sBo;
    private final String sBp;
    private String sBq;
    public int sBr;
    private boolean sBs = false;
    private boolean sBt = false;
    private WeakReference<ViewGroup> sBu = null;
    private int sBv = -1;
    private int sBw = 0;
    private WeakReference<LinearLayoutManager> sBx = null;
    private int sBy = -1;
    private long sBz = 0;

    public a(int i2, String str, String str2) {
        b bVar = null;
        AppMethodBeat.i(169282);
        switch (i2) {
            case 0:
                bVar = new c();
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                bVar = new com.tencent.mm.plugin.expt.hellhound.a.a.a.a();
                break;
        }
        this.sBo = bVar;
        this.sBg = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
        this.sBi = new HashMap();
        this.sBh = i2;
        this.sBp = str;
        this.sBq = str2;
        this.sBr = -1;
        AppMethodBeat.o(169282);
    }

    public final void mc(boolean z) {
        ViewGroup viewGroup;
        AppMethodBeat.i(186061);
        if (!(this.sBu == null || (viewGroup = this.sBu.get()) == null)) {
            b(viewGroup, z ? 0 : this.sBv, viewGroup.getChildCount());
        }
        AppMethodBeat.o(186061);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(int i2, Activity activity) {
        AppMethodBeat.i(169283);
        switch (i2) {
            case 0:
                ac(activity);
                AppMethodBeat.o(169283);
                return;
            case 1:
                stopMonitor();
                AppMethodBeat.o(169283);
                return;
            case 2:
                cOz();
                AppMethodBeat.o(169283);
                return;
            case 3:
                cOu();
                AppMethodBeat.o(169283);
                return;
            case 4:
                ad(activity);
                AppMethodBeat.o(169283);
                return;
            case 5:
                cOx();
                break;
        }
        AppMethodBeat.o(169283);
    }

    private void ac(Activity activity) {
        AppMethodBeat.i(169284);
        this.mScrollState = 0;
        initStatusBarHeight(activity);
        initScreenHeight(activity);
        cOs();
        AppMethodBeat.o(169284);
    }

    private void ad(Activity activity) {
        AppMethodBeat.i(220450);
        this.mScrollState = 0;
        initStatusBarHeight(activity);
        initScreenHeight(activity);
        cOt();
        AppMethodBeat.o(220450);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void cOs() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        AppMethodBeat.i(169285);
        int cNT = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT();
        Log.i("HABBYGE-MALI.FeedMonitor", "startMonitor activityMethod: %d", Integer.valueOf(cNT));
        switch (cNT) {
            case 0:
                gq(com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), d.cPV());
                this.sBs = true;
                AppMethodBeat.o(169285);
                return;
            case 1:
                this.sBs = true;
                if (!(this.sBu == null || (viewGroup2 = this.sBu.get()) == null)) {
                    a(viewGroup2, this.sBv, this.mVisibleItemCount);
                }
                AppMethodBeat.o(169285);
                return;
            case 7:
                if (System.currentTimeMillis() - this.sBl <= 30000) {
                    this.sBs = true;
                    if (!(this.sBu == null || (viewGroup = this.sBu.get()) == null)) {
                        a(viewGroup, this.sBv, this.mVisibleItemCount);
                        break;
                    }
                } else {
                    Log.i("HABBYGE-MALI.FeedMonitor", "_handleActivityMethod.BACK_2_FRONT: New Session");
                    cOv();
                    AppMethodBeat.o(169285);
                    return;
                }
        }
        AppMethodBeat.o(169285);
    }

    private void cOt() {
        ViewGroup viewGroup;
        AppMethodBeat.i(220451);
        gq(com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), d.cPV());
        this.sBs = true;
        this.sBt = true;
        if (!(this.sBu == null || (viewGroup = this.sBu.get()) == null)) {
            a(viewGroup, Math.max(this.sBv, 0), Math.max(this.mVisibleItemCount, 1));
        }
        AppMethodBeat.o(220451);
    }

    /* access modifiers changed from: package-private */
    public final void gq(String str, String str2) {
        AppMethodBeat.i(169286);
        this.sBk = new ebf();
        this.sBk.NaS = 0;
        this.sBk.iGB = this.sBp;
        this.sBk.NaW = this.sBq;
        ebf ebf = this.sBk;
        if (str == null) {
            str = "";
        }
        ebf.dRM = str;
        this.sBk.dPM = str2;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEy = this.sBk.dRM;
        Log.i("HABBYGE-MALI.FeedMonitor", "initTimelineParams: %s, %s", this.sBk.dRM, this.sBk.dPM);
        this.sBk.NaT = 0;
        this.sBk.NaU = 0;
        this.sBi.clear();
        this.sBm = new h();
        this.sBn = new g();
        AppMethodBeat.o(169286);
    }

    private void cOu() {
        AppMethodBeat.i(169287);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.expt.hellhound.a.a.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(169279);
                a.a(a.this);
                AppMethodBeat.o(169279);
            }
        });
        AppMethodBeat.o(169287);
    }

    private void cOv() {
        AppMethodBeat.i(169288);
        final String cPR = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR();
        final String cPV = d.cPV();
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.expt.hellhound.a.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(169280);
                a.a(a.this);
                a.this.gq(cPR, cPV);
                AppMethodBeat.o(169280);
            }
        });
        AppMethodBeat.o(169288);
    }

    private void cOw() {
        ViewGroup viewGroup;
        AppMethodBeat.i(169289);
        if (this.sBm == null) {
            AppMethodBeat.o(169289);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.sBm.sBV > 0) {
            this.sBm.sBW = currentTimeMillis;
            if (this.sBk != null) {
                long j2 = this.sBm.sBW - this.sBm.sBV;
                ebf ebf = this.sBk;
                ebf.NaT = j2 + ebf.NaT;
            }
            this.sBm.cOB();
            if (!(this.sBu == null || (viewGroup = this.sBu.get()) == null)) {
                a(viewGroup, this.sBv, this.mVisibleItemCount, currentTimeMillis, false);
            }
        }
        if (this.sBm.sBX > 0) {
            this.sBm.sBY = currentTimeMillis;
            if (this.sBk != null) {
                long j3 = this.sBm.sBY - this.sBm.sBX;
                ebf ebf2 = this.sBk;
                ebf2.NaU = j3 + ebf2.NaU;
            } else {
                Log.e("HABBYGE-MALI.FeedMonitor", "_stopComputeTimelineSliceTime mSnsTimeline is NULL 2");
            }
            this.sBm.cOC();
        }
        if (this.sBm.sBZ > 0) {
            this.sBm.sCa = currentTimeMillis;
            if (this.sBk != null) {
                long j4 = this.sBm.sCa - this.sBm.sBZ;
                ebf ebf3 = this.sBk;
                ebf3.NaS = j4 + ebf3.NaS;
            }
            h hVar = this.sBm;
            hVar.sBZ = 0;
            hVar.sCa = 0;
        }
        AppMethodBeat.o(169289);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void stopMonitor() {
        AppMethodBeat.i(169290);
        int cNT = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT();
        Log.i("HABBYGE-MALI.FeedMonitor", "stopMonitor, activityMethod: %s", Integer.valueOf(cNT));
        switch (cNT) {
            case 0:
                cOw();
                AppMethodBeat.o(169290);
                return;
            case 1:
                cOu();
                AppMethodBeat.o(169290);
                return;
            case 8:
                cOw();
                this.sBl = System.currentTimeMillis();
                break;
        }
        AppMethodBeat.o(169290);
    }

    private void cOx() {
        AppMethodBeat.i(220452);
        this.sBt = false;
        cOu();
        AppMethodBeat.o(220452);
    }

    public final void g(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(186062);
        this.mScrollState = i2;
        if (this.sBu == null || this.sBu.get() == null) {
            this.sBu = new WeakReference<>(viewGroup);
        }
        if (viewGroup instanceof RecyclerView) {
            this.sBo.setRecyclerView((RecyclerView) viewGroup);
        }
        if (i2 == 0) {
            this.sBw = 0;
        }
        if (this.sBh == 0 && i2 != 2) {
            this.sBr = -1;
        }
        if (this.sBt) {
            this.sBt = false;
            a(viewGroup, Math.max(this.sBv, 0), Math.max(this.mVisibleItemCount, 1), System.currentTimeMillis(), true);
        }
        AppMethodBeat.o(186062);
    }

    public final void a(Activity activity, ViewGroup viewGroup, int i2, int i3, int i4) {
        ActionBar supportActionBar;
        AppMethodBeat.i(169291);
        if (viewGroup instanceof RecyclerView) {
            this.sBo.setRecyclerView((RecyclerView) viewGroup);
        }
        if (this.sBu == null || this.sBu.get() == null) {
            this.sBu = new WeakReference<>(viewGroup);
        }
        this.sBv = i2;
        this.mVisibleItemCount = i3;
        if (this.mScrollState == 1) {
            try {
                if (Math.abs(i4) > this.sBg) {
                    if (i4 > 0) {
                        this.sBw = -1;
                    } else if (i4 < 0) {
                        this.sBw = 1;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.FeedMonitor", e2, "scrollingState, crash: %s", e2.getMessage());
            }
        } else if (this.mScrollState == 0 && this.mActionBarHeight <= 0 && activity != null) {
            try {
                if ((activity instanceof AppCompatActivity) && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                    this.mActionBarHeight = supportActionBar.getCustomView().getHeight();
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("HABBYGE-MALI.FeedMonitor", e3, "initBarHeight", new Object[0]);
            }
        }
        a(viewGroup, i2, i3);
        AppMethodBeat.o(169291);
    }

    private void a(ViewGroup viewGroup, int i2, int i3) {
        boolean i4;
        AppMethodBeat.i(186063);
        if (this.mScrollState == 0) {
            this.sBz = 0;
            i4 = true;
        } else {
            i4 = i(viewGroup, i3);
        }
        if (i4) {
            b(viewGroup, i2, i3);
        }
        AppMethodBeat.o(186063);
    }

    private void b(ViewGroup viewGroup, int i2, int i3) {
        AppMethodBeat.i(186064);
        if (this.sBm == null) {
            AppMethodBeat.o(186064);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.sBm.sBZ <= 0) {
            this.sBm.sBZ = currentTimeMillis;
        }
        if (cOy() || this.mScrollState == 0) {
            a(viewGroup, i2, i3, currentTimeMillis);
            AppMethodBeat.o(186064);
        } else if (this.sBh != 0 || this.sBr == -1) {
            b(viewGroup, i2, i3, currentTimeMillis);
            AppMethodBeat.o(186064);
        } else {
            a(viewGroup, i2, i3, currentTimeMillis);
            AppMethodBeat.o(186064);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r10.sBh != 0) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.ViewGroup r11, int r12, int r13, long r14) {
        /*
            r10 = this;
            r8 = 0
            r7 = 186065(0x2d6d1, float:2.60733E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.mm.plugin.expt.hellhound.a.a.h r0 = r10.sBm
            long r0 = r0.sBV
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0020
            com.tencent.mm.plugin.expt.hellhound.a.a.h r0 = r10.sBm
            r0.sBV = r14
            com.tencent.mm.plugin.expt.hellhound.a.a.g r0 = r10.sBn
            if (r0 == 0) goto L_0x0029
            com.tencent.mm.plugin.expt.hellhound.a.a.g r0 = r10.sBn
            r0.startTime = r14
            int r0 = r10.sBh
            if (r0 == 0) goto L_0x0029
        L_0x0020:
            r6 = 1
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r0.a(r1, r2, r3, r4, r6)
        L_0x0029:
            com.tencent.mm.plugin.expt.hellhound.a.a.h r0 = r10.sBm
            long r0 = r0.sBX
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x004e
            com.tencent.mm.plugin.expt.hellhound.a.a.h r0 = r10.sBm
            r0.sBY = r14
            com.tencent.mm.protocal.protobuf.ebf r0 = r10.sBk
            if (r0 == 0) goto L_0x0049
            com.tencent.mm.plugin.expt.hellhound.a.a.h r0 = r10.sBm
            long r0 = r0.sBY
            com.tencent.mm.plugin.expt.hellhound.a.a.h r2 = r10.sBm
            long r2 = r2.sBX
            long r0 = r0 - r2
            com.tencent.mm.protocal.protobuf.ebf r2 = r10.sBk
            long r4 = r2.NaU
            long r0 = r0 + r4
            r2.NaU = r0
        L_0x0049:
            com.tencent.mm.plugin.expt.hellhound.a.a.h r0 = r10.sBm
            r0.cOC()
        L_0x004e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.a.a.a(android.view.ViewGroup, int, int, long):void");
    }

    private void b(ViewGroup viewGroup, int i2, int i3, long j2) {
        AppMethodBeat.i(186066);
        if (this.sBm.sBV > 0) {
            this.sBm.sBW = j2;
            if (this.sBk != null) {
                long j3 = this.sBm.sBW - this.sBm.sBV;
                ebf ebf = this.sBk;
                ebf.NaT = j3 + ebf.NaT;
            }
            this.sBm.cOB();
            a(viewGroup, i2, i3, j2, false);
        }
        if (this.sBm.sBX <= 0) {
            this.sBm.sBX = j2;
        }
        AppMethodBeat.o(186066);
    }

    private void a(ViewGroup viewGroup, int i2, int i3, long j2, boolean z) {
        AppMethodBeat.i(169296);
        if (viewGroup == null || this.sBn == null) {
            AppMethodBeat.o(169296);
            return;
        }
        this.sBt = false;
        if (this.sBn.startTime > 0) {
            this.sBn.endTime = j2;
            long j3 = this.sBn.endTime - this.sBn.startTime;
            if (j3 <= 0) {
                if (this.sBs) {
                    this.sBs = false;
                } else {
                    AppMethodBeat.o(169296);
                    return;
                }
            }
            com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c2 = c(viewGroup, i2, i3);
            Map map = (Map) c2.get(0);
            int intValue = ((Integer) c2.get(1)).intValue();
            if (intValue <= 0) {
                AppMethodBeat.o(169296);
                return;
            }
            this.sBj.clear();
            double d2 = ((double) j3) / ((double) intValue);
            for (Map.Entry entry : map.entrySet()) {
                c cVar = (c) entry.getKey();
                if (((Boolean) entry.getValue()).booleanValue()) {
                    this.sBj.put(cVar.sBK.feedId, Boolean.valueOf(cVar.sBK.isAd));
                    if (this.sBi.containsKey(cVar.sBK.feedId)) {
                        c cVar2 = this.sBi.get(cVar.sBK.feedId);
                        if (cVar2 != null) {
                            cVar2.sBK.MZt += d2;
                            cVar2.sBK.MZu += (double) j3;
                            a(cVar2, cVar);
                            this.sBi.put(cVar.sBK.feedId, cVar2);
                            cVar2.sBK.likeCount = cVar.sBK.likeCount;
                            cVar2.sBK.commentCount = cVar.sBK.commentCount;
                            cVar2.sBK.userName = cVar.sBK.userName;
                            cVar2.sBK.nickName = cVar.sBK.nickName;
                            cVar2.sBK.isAd = cVar.sBK.isAd;
                        }
                    } else {
                        cVar.sBK.MZt = d2;
                        cVar.sBK.MZu = (double) j3;
                        this.sBi.put(cVar.sBK.feedId, cVar);
                    }
                }
            }
            if (z) {
                this.sBn.startTime = j2;
                AppMethodBeat.o(169296);
                return;
            }
            this.sBn.startTime = 0;
        }
        AppMethodBeat.o(169296);
    }

    private static void a(c cVar, c cVar2) {
        cVar.sBK.y = cVar2.sBK.y;
        cVar.sBK.height = cVar2.sBK.height;
        cVar.sBK.vp = cVar2.sBK.vp;
        cVar.sBK.EOS = cVar2.sBK.EOS;
        cVar.sBK.mEY = cVar2.sBK.mEY;
        cVar.sBK.virtualKeyHeight = cVar2.sBK.virtualKeyHeight;
    }

    private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> c(ViewGroup viewGroup, int i2, int i3) {
        AppMethodBeat.i(169297);
        if (this.sBh == 0) {
            com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> h2 = h(viewGroup, i3);
            AppMethodBeat.o(169297);
            return h2;
        }
        com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> d2 = d(viewGroup, i2, i3);
        AppMethodBeat.o(169297);
        return d2;
    }

    private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> h(ViewGroup viewGroup, int i2) {
        int i3;
        com.tencent.mm.vending.j.c<c, Boolean> ab;
        AppMethodBeat.i(185575);
        HashMap hashMap = new HashMap();
        int i4 = i2 - 1;
        int i5 = 0;
        while (i4 >= 0) {
            View childAt = viewGroup.getChildAt(i4);
            if (!(childAt == null || (ab = ab(childAt, i4)) == null)) {
                boolean booleanValue = ((Boolean) ab.get(1)).booleanValue();
                hashMap.put(ab.get(0), Boolean.valueOf(booleanValue));
                if (booleanValue) {
                    i3 = i5 + 1;
                    i4--;
                    i5 = i3;
                }
            }
            i3 = i5;
            i4--;
            i5 = i3;
        }
        com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> Q = com.tencent.mm.vending.j.a.Q(hashMap, Integer.valueOf(i5));
        AppMethodBeat.o(185575);
        return Q;
    }

    private com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> d(ViewGroup viewGroup, int i2, int i3) {
        RecyclerView recyclerView;
        int i4;
        LinearLayoutManager linearLayoutManager;
        View findViewByPosition;
        int i5;
        com.tencent.mm.vending.j.c<c, Boolean> ab;
        AppMethodBeat.i(185576);
        HashMap hashMap = new HashMap();
        if (viewGroup instanceof RecyclerView) {
            recyclerView = (RecyclerView) viewGroup;
        } else {
            recyclerView = null;
        }
        int i6 = i3 - 1;
        int i7 = 0;
        while (i6 >= 0) {
            if (recyclerView == null) {
                i5 = i6;
                findViewByPosition = viewGroup.getChildAt(i6);
            } else {
                if (this.sBx == null || (linearLayoutManager = this.sBx.get()) == null) {
                    linearLayoutManager = (LinearLayoutManager) ((RecyclerView) viewGroup).getLayoutManager();
                    if (linearLayoutManager != null) {
                        this.sBx = new WeakReference<>(linearLayoutManager);
                    }
                    i4 = i7;
                    i6--;
                    i7 = i4;
                }
                int i8 = i2 + i6;
                findViewByPosition = linearLayoutManager.findViewByPosition(i8);
                if (findViewByPosition == null && (findViewByPosition = viewGroup.getChildAt(i6)) == null) {
                    findViewByPosition = viewGroup.getChildAt(i8);
                    i5 = i8;
                } else {
                    i5 = i8;
                }
            }
            if (!(findViewByPosition == null || (ab = ab(findViewByPosition, i5)) == null)) {
                boolean booleanValue = ((Boolean) ab.get(1)).booleanValue();
                hashMap.put(ab.get(0), Boolean.valueOf(booleanValue));
                if (booleanValue) {
                    i4 = i7 + 1;
                    i6--;
                    i7 = i4;
                }
            }
            i4 = i7;
            i6--;
            i7 = i4;
        }
        com.tencent.mm.vending.j.c<Map<c, Boolean>, Integer> Q = com.tencent.mm.vending.j.a.Q(hashMap, Integer.valueOf(i7));
        AppMethodBeat.o(185576);
        return Q;
    }

    private com.tencent.mm.vending.j.c<c, Boolean> ab(View view, int i2) {
        AppMethodBeat.i(220453);
        String ac = this.sBo.ac(view, i2);
        if (TextUtils.isEmpty(ac)) {
            AppMethodBeat.o(220453);
            return null;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.sBo.a(view, pInt, pInt2, i2);
        com.tencent.mm.vending.j.c<Integer, Integer> dN = dN(view);
        int intValue = ((Integer) dN.get(0)).intValue();
        int intValue2 = ((Integer) dN.get(1)).intValue();
        c cVar = new c();
        cVar.sBK = new dzv();
        cVar.sBK.feedId = ac;
        cVar.sBK.likeCount = pInt.value;
        cVar.sBK.commentCount = pInt2.value;
        String ad = this.sBo.ad(view, i2);
        dzv dzv = cVar.sBK;
        if (ad == null) {
            ad = "";
        }
        dzv.userName = ad;
        String ae = this.sBo.ae(view, i2);
        dzv dzv2 = cVar.sBK;
        if (ae == null) {
            ae = "";
        }
        dzv2.nickName = ae;
        cVar.sBK.isAd = this.sBo.dP(view);
        cVar.sBK.y = intValue;
        cVar.sBK.height = intValue2;
        cVar.sBK.mEY = this.mScreenRealHeight;
        cVar.sBK.virtualKeyHeight = this.mScreenRealHeight - this.mScreenHeight;
        cVar.sBK.CHZ = this.mStatusBarHeight;
        cVar.sBK.udM = this.mActionBarHeight <= 0 ? 144 : this.mActionBarHeight;
        cVar.sBK.vp = this.mScrollState;
        cVar.sBK.EOS = this.sBw;
        cVar.position = i2;
        com.tencent.mm.vending.j.c<c, Boolean> Q = com.tencent.mm.vending.j.a.Q(cVar, Boolean.valueOf(cVar.GX(this.sBh)));
        AppMethodBeat.o(220453);
        return Q;
    }

    private boolean i(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(169299);
        View j2 = j(viewGroup, i2);
        if (j2 == null) {
            AppMethodBeat.o(169299);
            return true;
        }
        String ac = this.sBo.ac(j2, i2 - 1);
        if (ac == null) {
            AppMethodBeat.o(169299);
            return true;
        } else if (!ac.equals(this.sBB)) {
            this.sBy = getY(j2);
            this.sBA = System.currentTimeMillis();
            this.sBB = ac;
            AppMethodBeat.o(169299);
            return true;
        } else {
            int y = getY(j2);
            int abs = Math.abs(y - this.sBy);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.sBA;
            if (j3 <= 0 || abs <= this.sBg) {
                AppMethodBeat.o(169299);
                return false;
            }
            this.sBz = (((long) abs) * 1000) / j3;
            this.sBy = y;
            this.sBA = currentTimeMillis;
            AppMethodBeat.o(169299);
            return true;
        }
    }

    private boolean cOy() {
        return this.sBz <= 1000;
    }

    private com.tencent.mm.vending.j.c<Integer, Integer> dN(View view) {
        int max;
        AppMethodBeat.i(169300);
        if (this.sBh == 0) {
            max = view.getHeight();
        } else {
            max = Math.max(view.getMeasuredHeight(), view.getHeight());
        }
        com.tencent.mm.vending.j.c<Integer, Integer> Q = com.tencent.mm.vending.j.a.Q(Integer.valueOf(Math.min(getY(view), (int) view.getY())), Integer.valueOf(max));
        AppMethodBeat.o(169300);
        return Q;
    }

    private static int getY(View view) {
        AppMethodBeat.i(169301);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        AppMethodBeat.o(169301);
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r0 == null) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.View j(android.view.ViewGroup r3, int r4) {
        /*
            r2 = 169302(0x29556, float:2.37243E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r0 = 0
            boolean r1 = r3 instanceof android.widget.AbsListView
            if (r1 == 0) goto L_0x0022
            int r0 = r4 + -1
            android.view.View r0 = r3.getChildAt(r0)
            if (r0 != 0) goto L_0x001e
            r0 = r3
            android.widget.AbsListView r0 = (android.widget.AbsListView) r0
            int r0 = r0.getLastVisiblePosition()
            android.view.View r0 = r3.getChildAt(r0)
        L_0x001e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return r0
        L_0x0022:
            boolean r1 = r3 instanceof android.support.v7.widget.RecyclerView
            if (r1 == 0) goto L_0x001e
            r0 = r3
            android.support.v7.widget.RecyclerView r0 = (android.support.v7.widget.RecyclerView) r0
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            android.support.v7.widget.LinearLayoutManager r0 = (android.support.v7.widget.LinearLayoutManager) r0
            if (r0 == 0) goto L_0x0045
            int r1 = r0.ku()
            android.view.View r1 = r0.findViewByPosition(r1)
            if (r1 != 0) goto L_0x004c
            int r0 = r0.ku()
            android.view.View r0 = r3.getChildAt(r0)
            if (r0 != 0) goto L_0x001e
        L_0x0045:
            int r0 = r4 + -1
            android.view.View r0 = r3.getChildAt(r0)
            goto L_0x001e
        L_0x004c:
            r0 = r1
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.a.a.j(android.view.ViewGroup, int):android.view.View");
    }

    private void initStatusBarHeight(Activity activity) {
        AppMethodBeat.i(169303);
        if (this.mStatusBarHeight > 0) {
            AppMethodBeat.o(169303);
        } else if (activity == null) {
            AppMethodBeat.o(169303);
        } else {
            Resources resources = activity.getResources();
            this.mStatusBarHeight = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            if (this.mStatusBarHeight <= 0) {
                this.mStatusBarHeight = resources.getDimensionPixelSize(R.dimen.a3n);
            }
            AppMethodBeat.o(169303);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private void initScreenHeight(Activity activity) {
        Display defaultDisplay;
        AppMethodBeat.i(169304);
        try {
            if (this.sBC == null) {
                this.sBC = (WindowManager) MMApplicationContext.getContext().getSystemService("window");
            }
            defaultDisplay = this.sBC.getDefaultDisplay();
        } catch (Exception e2) {
            if (activity != null) {
                defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            } else {
                AppMethodBeat.o(169304);
                return;
            }
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        }
        Point point2 = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point2);
        }
        this.mScreenHeight = point.y;
        this.mScreenRealHeight = point2.y;
        AppMethodBeat.o(169304);
    }

    private void cOz() {
        AppMethodBeat.i(169305);
        if (this.sBi != null) {
            this.sBi.clear();
        }
        this.sBC = null;
        if (this.sBu != null) {
            this.sBu.clear();
            this.sBu = null;
        }
        AppMethodBeat.o(169305);
    }

    static /* synthetic */ void a(a aVar) {
        c value;
        AppMethodBeat.i(169306);
        if (aVar.sBk != null) {
            aVar.cOw();
            if (!aVar.sBi.isEmpty()) {
                Log.i("HABBYGE-MALI.FeedMonitor", "_moveMonitoringFeed2ReadyReport");
                for (Map.Entry<String, c> entry : aVar.sBi.entrySet()) {
                    if (!(entry == null || (value = entry.getValue()) == null || aVar.sBk == null)) {
                        aVar.sBk.NaV.add(value.sBK);
                    }
                }
                aVar.sBi.clear();
            }
            final ebf ebf = aVar.sBk;
            aVar.sBk = null;
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.expt.hellhound.a.a.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(169281);
                    ebf ebf = ebf;
                    if (ebf != null) {
                        Log.i("HABBYGE-MALI.HellTimelineReport", "reportTimelineV2");
                        com.tencent.mm.vending.j.c<String, Integer> a2 = e.a(ebf);
                        if (a2 != null) {
                            Log.i("HABBYGE-MALI.HellTimelineReport", "reportTimelineV2 YES");
                            if ("18260".equals(ebf.iGB)) {
                                com.tencent.mm.plugin.expt.hellhound.a.a.b.a.a(ebf, a2);
                            } else if ("16242".equals(ebf.iGB)) {
                                g.a(ebf, a2);
                            }
                            if (ebf != null) {
                                if (Math.abs(ebf.NaS - (ebf.NaT + ebf.NaU)) <= 50) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(932, 87, 1, false);
                                    Log.i("HABBYGE-MALI.TimelineMonitorCheck", "Timeline time-sharing monitor data accuracy report, true");
                                } else {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(932, 88, 1, false);
                                    Log.i("HABBYGE-MALI.TimelineMonitorCheck", "Timeline time-sharing monitor data accuracy report, false");
                                }
                            }
                            double d2 = 0.0d;
                            Iterator<dzv> it = ebf.NaV.iterator();
                            while (it.hasNext()) {
                                d2 = it.next().MZt + d2;
                            }
                            double abs = Math.abs(((double) ebf.NaT) - d2);
                            if (abs <= 50.0d) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(932, 89, 1, false);
                                Log.i("HABBYGE-MALI.TimelineMonitorCheck", "Timeline time-sharing monitor data accuracy report, true: %s - %s = %s", Long.valueOf(ebf.NaT), Double.valueOf(d2), Double.valueOf(abs));
                                AppMethodBeat.o(169281);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(932, 90, 1, false);
                            Log.i("HABBYGE-MALI.TimelineMonitorCheck", "Timeline time-sharing monitor data accuracy report, false: %s", Double.valueOf(abs));
                        }
                    }
                    AppMethodBeat.o(169281);
                }
            }, "_reportTimeline");
        }
        AppMethodBeat.o(169306);
    }
}
