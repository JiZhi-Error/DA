package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.g.b.a.o;
import com.tencent.mm.g.b.a.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.d;
import com.tencent.mm.plugin.taskbar.ui.section.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

public class TaskBarView extends RecyclerView implements b.a, d.b, b.a {
    private float CBd = 0.0f;
    final d FUi = new d(this);
    private final ArrayList<Integer> FUj = new ArrayList<>();
    private long FUk = 0;
    private com.tencent.mm.plugin.taskbar.ui.section.weapp.b FUl;
    private boolean FUm = false;
    boolean FUn = false;
    boolean FUo = false;
    private boolean FUp = false;
    private float FUq = 0.0f;
    private boolean FUr = false;
    private boolean FUs = false;
    private c Vbs = new c();
    private c Vbt;
    private com.tencent.mm.plugin.taskbar.ui.section.other.a Vbu;
    boolean Vbv = false;
    private boolean Vbw = true;
    boolean Vbx = false;
    private RecyclerView.a adj;
    private int atO = 0;
    boolean dSv = false;
    private boolean dXX = false;
    private RecyclerView.l guX = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass2 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(263665);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarView$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                if (TaskBarView.this.ooc) {
                    TaskBarView.this.ooc = false;
                } else if (TaskBarView.this.mLastState == 1 || TaskBarView.this.mLastState == 2) {
                    TaskBarView.hWW();
                }
            }
            TaskBarView.this.mLastState = i2;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(263665);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int ks;
            AppMethodBeat.i(263666);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarView$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            if (TaskBarView.this.onj) {
                TaskBarView.this.onj = false;
                if (TaskBarView.this.oDV != null && (ks = TaskBarView.this.atO - TaskBarView.this.oDV.ks()) >= 0 && ks < TaskBarView.this.getChildCount()) {
                    TaskBarView.this.scrollBy(0, TaskBarView.this.getChildAt(ks).getTop());
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(263666);
        }
    };
    int hIX = 0;
    boolean isPaused = false;
    Context mContext;
    private Interpolator mInterpolator = new DecelerateInterpolator();
    private int mLastState = -1;
    private int mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    private LinearLayoutManager oDV = null;
    private String onG = "";
    boolean onK = false;
    boolean onN = false;
    boolean onO = false;
    int onP = 0;
    boolean onT = false;
    private int onV = 0;
    private float onW = 0.0f;
    private float onX = 0.0f;
    private boolean onY = false;
    private boolean onZ = false;
    HeaderContainer onh;
    private boolean onj = false;
    private RelativeLayout onl;
    int onp = 0;
    Runnable ont = null;
    Runnable onu = null;
    private boolean ooc = false;
    private Animator.AnimatorListener wY = new Animator.AnimatorListener() {
        /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass6 */

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    };

    static /* synthetic */ int a(TaskBarView taskBarView, int i2) {
        AppMethodBeat.i(238297);
        int abF = taskBarView.abF(i2);
        AppMethodBeat.o(238297);
        return abF;
    }

    static /* synthetic */ void c(TaskBarView taskBarView) {
        AppMethodBeat.i(263686);
        taskBarView.hWU();
        AppMethodBeat.o(263686);
    }

    static /* synthetic */ void hWW() {
    }

    static /* synthetic */ void j(TaskBarView taskBarView) {
        taskBarView.onN = false;
        taskBarView.onO = false;
    }

    public TaskBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(238261);
        init(context);
        AppMethodBeat.o(238261);
    }

    public TaskBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(238262);
        init(context);
        AppMethodBeat.o(238262);
    }

    public void setHeaderContainer(HeaderContainer headerContainer) {
        AppMethodBeat.i(238263);
        this.onh = headerContainer;
        AppMethodBeat.o(238263);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(238264);
        super.onVisibilityChanged(view, i2);
        Log.d("MicroMsg.TaskBarView", "[onVisibilityChanged] visibility:".concat(String.valueOf(i2)));
        if (i2 == 8 || i2 == 4) {
            if (this.FUn && this.onh != null) {
                this.onh.ad(100, this.onP);
                this.onP = 0;
                this.FUn = false;
            }
            if (this.dXX) {
                Log.i("MicroMsg.TaskBarView", "alvinluo onVisibilityChanged needRefresh");
                this.dXX = false;
                if (this.onu != null) {
                    removeCallbacks(this.onu);
                }
                AnonymousClass1 r0 = new Runnable() {
                    /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(238232);
                        TaskBarView.this.setLayoutFrozen(false);
                        AppMethodBeat.o(238232);
                    }
                };
                this.onu = r0;
                postDelayed(r0, 1000);
            }
        }
        AppMethodBeat.o(238264);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(238265);
        if (this.FUr) {
            AppMethodBeat.o(238265);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(238265);
        return onInterceptTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(238266);
        if (this.FUp) {
            AppMethodBeat.o(238266);
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.CBd = motionEvent.getRawX();
                this.onW = motionEvent.getRawY();
                this.FUq = 0.0f;
                this.onX = 0.0f;
                this.onY = false;
                this.onZ = false;
                this.FUr = false;
                this.FUs = false;
                break;
            case 1:
            case 3:
                if (this.onY) {
                    if (Math.abs(this.onX) < ((float) this.onV) || this.onh == null) {
                        animate().translationY(0.0f).setDuration(300).setInterpolator(this.mInterpolator).setListener(this.wY).start();
                    } else {
                        Log.i("MicroMsg.TaskBarView", "alvinluo checkAndClose closeHeader because of pull up bottom");
                        this.onh.ac(0, 15);
                    }
                }
                this.FUq = 0.0f;
                this.onX = 0.0f;
                this.onY = false;
                this.onZ = false;
                this.FUr = false;
                this.FUs = false;
                break;
            case 2:
                if (!this.FUr) {
                    if (!this.FUs) {
                        float abs = Math.abs(motionEvent.getRawX() - this.CBd);
                        float abs2 = Math.abs(motionEvent.getRawY() - this.onW);
                        if (abs > ((float) this.mTouchSlop)) {
                            if (abs2 <= ((float) this.mTouchSlop) || abs2 <= abs) {
                                this.FUr = true;
                                break;
                            } else {
                                this.FUs = true;
                            }
                        } else if (abs2 > ((float) this.mTouchSlop)) {
                            this.FUs = true;
                        }
                    }
                    Log.v("MicroMsg.TaskBarView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", Boolean.valueOf(this.onY), Float.valueOf(this.onX), Integer.valueOf(this.mTouchSlop));
                    if (this.oDV == null || this.FUj == null) {
                        z = false;
                    } else {
                        z = this.oDV.kv() == this.FUj.size() + -1;
                    }
                    if (z && !this.onY) {
                        if (this.onZ) {
                            this.onX = (motionEvent.getRawY() - this.onW) * 0.55f;
                            if (this.onX < 0.0f) {
                                this.onY = true;
                                break;
                            }
                        } else {
                            this.onW = motionEvent.getRawY();
                            this.onX = 0.0f;
                            this.onZ = true;
                            break;
                        }
                    } else if (this.onY) {
                        this.onX = (motionEvent.getRawY() - this.onW) * 0.55f;
                        if (this.onX > 0.0f) {
                            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                            AppMethodBeat.o(238266);
                            return dispatchTouchEvent;
                        }
                        if (this.onX < ((float) (-this.mTouchSlop))) {
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            motionEvent.setAction(2);
                        }
                        int abs3 = (int) Math.abs(this.onX);
                        Log.v("MicroMsg.TaskBarView", "alvinluo moveView: %d", Integer.valueOf(abs3));
                        setTranslationY((float) (-abs3));
                        AppMethodBeat.o(238266);
                        return true;
                    }
                } else {
                    boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(238266);
                    return dispatchTouchEvent2;
                }
                break;
        }
        boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(238266);
        return dispatchTouchEvent3;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        AppMethodBeat.i(238267);
        super.onAttachedToWindow();
        View rootView = getRootView();
        if (rootView == null) {
            AppMethodBeat.o(238267);
            return;
        }
        this.onl = (RelativeLayout) rootView.findViewById(R.id.f6r);
        AppMethodBeat.o(238267);
    }

    private void init(Context context) {
        AppMethodBeat.i(238268);
        this.mContext = context;
        setItemAnimator(this.Vbs);
        a(new b(this, (byte) 0));
        this.FUi.cau();
        com.tencent.mm.plugin.appbrand.widget.recent.d.init(this.mContext);
        setVerticalFadingEdgeEnabled(false);
        setNestedScrollingEnabled(true);
        setBackgroundColor(getContext().getResources().getColor(R.color.ac_));
        this.oDV = new LinearLayoutManager();
        setLayoutManager(this.oDV);
        setOverScrollMode(2);
        a(this.guX);
        this.adj = new a();
        setAdapter(this.adj);
        this.FUi.FH(false);
        reloadData();
        Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView init %d", Integer.valueOf(hashCode()));
        this.onV = com.tencent.mm.cb.a.fromDPToPix(context, 100);
        AppMethodBeat.o(238268);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void fuO() {
        AppMethodBeat.i(238270);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass7 */

            public final void run() {
                int i2;
                T t;
                boolean z;
                AppMethodBeat.i(263667);
                if (TaskBarView.this.FUj.contains(4) && TaskBarView.this.Vbu != null) {
                    com.tencent.mm.plugin.taskbar.ui.section.other.a aVar = TaskBarView.this.Vbu;
                    Iterator<MultiTaskInfo> it = aVar.getViewModel().FVI.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        if (it.next().field_type == 21) {
                            i2 = i3;
                            break;
                        }
                        i3++;
                    }
                    if (i2 != -1) {
                        Iterator<T> it2 = aVar.getViewModel().FVH.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t = null;
                                break;
                            }
                            T next = it2.next();
                            if (((MultiTaskInfo) next).field_type == 21) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                t = next;
                                break;
                            }
                        }
                        T t2 = t;
                        if (t2 != null) {
                            aVar.getViewModel().FVI.set(i2, t2);
                        }
                        aVar.VbU.ci(i2);
                    }
                }
                AppMethodBeat.o(263667);
            }
        });
        AppMethodBeat.o(238270);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void fuP() {
        AppMethodBeat.i(238271);
        Log.i("MicroMsg.TaskBarView", "onDataUpdated");
        this.FUm = true;
        fuQ();
        AppMethodBeat.o(238271);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void fuQ() {
        boolean z = true;
        AppMethodBeat.i(238272);
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(this.Vbx);
        objArr[1] = Boolean.valueOf(!this.FUm);
        objArr[2] = Boolean.valueOf(!this.Vbw);
        objArr[3] = Boolean.valueOf(this.isPaused);
        if (this.FUi.fuX()) {
            z = false;
        }
        objArr[4] = Boolean.valueOf(z);
        objArr[5] = Boolean.valueOf(this.Vbv);
        Log.i("MicroMsg.TaskBarView", "reloadDataIfNeed %b %b %b %b %b %b", objArr);
        if (this.Vbx || (this.FUm && this.Vbw && !this.isPaused && this.FUi.fuX() && !this.Vbv)) {
            reloadData();
            AppMethodBeat.o(238272);
            return;
        }
        AppMethodBeat.o(238272);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void hWR() {
        AppMethodBeat.i(263678);
        Log.i("MicroMsg.TaskBarView", "forceReloadData");
        reloadData();
        AppMethodBeat.o(263678);
    }

    /* access modifiers changed from: package-private */
    public final void reloadData() {
        AppMethodBeat.i(238277);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(263668);
                Log.i("MicroMsg.TaskBarView", "doReloadData");
                TaskBarView.c(TaskBarView.this);
                if (TaskBarView.this.asn) {
                    TaskBarView.this.dXX = true;
                }
                if (TaskBarView.this.getRecyclerView().ld()) {
                    Log.i("MicroMsg.TaskBarView", "isComputingLayout not update");
                    TaskBarView.this.FUm = true;
                    AppMethodBeat.o(263668);
                    return;
                }
                TaskBarView.this.FUi.FUH.clear();
                TaskBarView.this.adj.atj.notifyChanged();
                TaskBarView.this.FUm = false;
                AppMethodBeat.o(263668);
            }
        });
        AppMethodBeat.o(238277);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void hWS() {
        AppMethodBeat.i(263679);
        int indexOf = this.FUj.indexOf(4);
        if (indexOf != -1) {
            Log.i("MicroMsg.TaskBarView", "do reloadOtherData");
            if (this.FUi.abG(4).FVH.isEmpty()) {
                hWU();
                this.adj.ck(indexOf);
                AppMethodBeat.o(263679);
                return;
            }
            this.adj.ci(indexOf);
        }
        AppMethodBeat.o(263679);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void fuR() {
        AppMethodBeat.i(238273);
        Log.i("MicroMsg.TaskBarView", "onTeenModeStatusChanged");
        this.FUi.FH(true);
        AppMethodBeat.o(238273);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final void axf(final int i2) {
        AppMethodBeat.i(263680);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass9 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(238240);
                Log.i("MicroMsg.TaskBarView", "onSectionDeleted %d", Integer.valueOf(i2));
                if (i2 != 4 || TaskBarView.this.FUi.abG(4).FVI.isEmpty()) {
                    int a2 = TaskBarView.a(TaskBarView.this, i2);
                    if (a2 == -1) {
                        Log.i("MicroMsg.TaskBarView", "section not found!");
                        AppMethodBeat.o(238240);
                        return;
                    }
                    TaskBarView.this.FUj.remove(a2);
                    TaskBarView.this.getAdapter().ck(a2);
                    if (i2 == 1 && TaskBarView.this.Vbt != null) {
                        TaskBarView.this.Vbt.setSearchHidden(false);
                    }
                    int size = TaskBarView.this.FUj.size();
                    if (size == 1 && ((Integer) TaskBarView.this.FUj.get(0)).intValue() == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    TaskBarView.c(TaskBarView.this);
                    if (TaskBarView.this.FUj.size() > size || z) {
                        if (z) {
                            TaskBarView.this.getAdapter().ci(0);
                            AppMethodBeat.o(238240);
                            return;
                        }
                        if (TaskBarView.this.FUj.size() > 1) {
                            Log.i("MicroMsg.TaskBarView", "other tips show[remove section], mark");
                            g.aAh().azQ().set(ar.a.USERINFO_TASKBAR_HAS_SHOWED_EMPTY_OTHER_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        TaskBarView.this.getAdapter().cj(TaskBarView.this.FUj.size() - 1);
                    }
                    AppMethodBeat.o(238240);
                    return;
                }
                Log.i("MicroMsg.TaskBarView", "showDataList not empty!");
                AppMethodBeat.o(238240);
            }
        });
        AppMethodBeat.o(263680);
    }

    private static boolean hWT() {
        boolean z;
        AppMethodBeat.i(263681);
        boolean z2 = g.aAh().azQ().getBoolean(ar.a.USERINFO_TASKBAR_SHOULD_NOT_SHOW_EMPTY_OTHER_TIPS_BOOLEAN_SYNC, false);
        Object[] objArr = new Object[1];
        if (!z2) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.TaskBarView", "enableOthersWording %b", objArr);
        if (!z2) {
            AppMethodBeat.o(263681);
            return true;
        }
        AppMethodBeat.o(263681);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void hWU() {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.taskbar.ui.TaskBarView.hWU():void");
    }

    private String hWV() {
        AppMethodBeat.i(263683);
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.FUj.iterator();
        while (it.hasNext()) {
            sb.append(it.next().intValue()).append(",");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(263683);
        return sb2;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(238278);
        super.onMeasure(i2, i3);
        if (!(this.onh == null || this.onp == this.onh.getViewHeight())) {
            this.onp = this.onh.getViewHeight();
            Log.i("MicroMsg.TaskBarView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", Integer.valueOf(this.onp), Integer.valueOf(this.onh.getMeasuredHeight()));
        }
        AppMethodBeat.o(238278);
    }

    public RecyclerView getRecyclerView() {
        return this;
    }

    private void setupMultiTaskScroll(boolean z) {
        AppMethodBeat.i(238279);
        Log.i("MicroMsg.TaskBarView", "setupMultiTaskScroll %b", Boolean.valueOf(z));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((MultiTaskUIC) com.tencent.mm.ui.component.a.ko(getContext()).get(MultiTaskUIC.class)).hx(z);
        AppMethodBeat.o(238279);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void caB() {
        int size;
        List<MultiTaskInfo> list;
        int i2;
        AppMethodBeat.i(238280);
        Log.i("MicroMsg.TaskBarView", "[onOpenHeader]");
        if (!this.onK) {
            if (this.FUj.size() > 1 && this.FUj.contains(3)) {
                Log.i("MicroMsg.TaskBarView", "other tips show[speard], mark");
                g.aAh().azQ().set(ar.a.USERINFO_TASKBAR_HAS_SHOWED_EMPTY_OTHER_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
            }
            if (hWT() && this.FUj.contains(4) && g.aAh().azQ().getBoolean(ar.a.USERINFO_TASKBAR_HAS_SHOWED_EMPTY_OTHER_TIPS_BOOLEAN_SYNC, false)) {
                Log.i("MicroMsg.TaskBarView", "other tips hide[speard], mark disabled");
                g.aAh().azQ().set(ar.a.USERINFO_TASKBAR_SHOULD_NOT_SHOW_EMPTY_OTHER_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
            }
            this.FUp = false;
            setupMultiTaskScroll(false);
            String str = this.onG;
            Object obj = g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_FROM_DESKTOP_INPUT_HINT_CONTENT_STRING_SYNC, (Object) null);
            if (obj instanceof String) {
                this.onG = Util.nullAs((String) obj, this.onG);
            }
            Log.d("MicroMsg.TaskBarView", "alvinluo updateSearchWording last: %s, new: %s", str, this.onG);
            l.aeK(l.bUv());
            this.onK = true;
            this.Vbw = false;
            this.onN = true;
            this.onO = true;
            ai.LX(0);
            d dVar = this.FUi;
            com.tencent.mm.plugin.taskbar.a.a aVar = dVar.FUF;
            aVar.oCb = System.currentTimeMillis() / 1000;
            aVar.FSr = String.valueOf((int) aVar.oCb);
            dVar.mZq = System.currentTimeMillis();
            dVar.VbF = 0;
            Log.i("MicroMsg.TaskBarViewPresenter", "onDidAppear lastStartTime:%d", Long.valueOf(dVar.mZq));
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            com.tencent.mm.plugin.taskbar.ui.section.g gVar = dVar.FUC.get(4);
            if (!(gVar == null || (list = gVar.FVH) == null)) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    switch (((MultiTaskInfo) it.next()).field_type) {
                        case 2:
                            i8++;
                            continue;
                        case 3:
                            i3++;
                            continue;
                        case 4:
                            i4++;
                            continue;
                        case 6:
                            i5++;
                            continue;
                        case 21:
                            i6++;
                            continue;
                        case 22:
                            i2 = i7 + 1;
                            break;
                        default:
                            i2 = i7;
                            break;
                    }
                    i7 = i2;
                }
            }
            int i9 = e.atB() ? 1 : 0;
            com.tencent.mm.plugin.taskbar.a.a aVar2 = dVar.FUF;
            int size2 = dVar.FUB.size() >= 8 ? 8 : dVar.FUB.size();
            if (dVar.VbD.size() >= 8) {
                size = 8;
            } else {
                size = dVar.VbD.size();
            }
            o oVar = new o();
            oVar.ekH = oVar.x("session_id", aVar2.FSr, true);
            oVar.ekI = 1;
            oVar.ekJ = (long) i9;
            oVar.ekK = (long) size2;
            oVar.ekL = (long) i8;
            oVar.ekM = (long) i4;
            oVar.ekN = (long) i3;
            oVar.ekP = (long) i7;
            oVar.ekQ = (long) i6;
            oVar.opY = (long) size;
            oVar.opZ = (long) i5;
            oVar.bfK();
            Iterator<d.C1800d> it2 = dVar.FUH.iterator();
            while (it2.hasNext()) {
                d.C1800d next = it2.next();
                MultiTaskInfo multiTaskInfo = next.Agu;
                if (multiTaskInfo != null) {
                    ((PluginTaskBar) g.ah(PluginTaskBar.class)).notifyExposeTaskBarItem$plugin_taskbar_release(multiTaskInfo);
                }
                dVar.FUF.J(next.FUN, next.pageType, next.pFK);
            }
            dVar.FUH.clear();
            j.bxQ().a(Util.nowMilliSecond(), true, null, 6, 0);
            h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, z.MAIN_PULLDOWN);
            h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WAGAME, z.MAIN_PULLDOWN);
        }
        setLayoutFrozen(false);
        AppMethodBeat.o(238280);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void eG(int i2, int i3) {
        int i4;
        long j2;
        AppMethodBeat.i(238281);
        Log.i("MicroMsg.TaskBarView", "[onCloseHeader] reason: %d duration:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.onK) {
            this.Vbx = false;
            this.onK = false;
            this.Vbv = false;
            this.FUp = false;
            d dVar = this.FUi;
            Log.i("MicroMsg.TaskBarViewPresenter", "onDidClose reason:%d", Integer.valueOf(i2));
            if (i2 == 13 || i2 == 0) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            dVar.FUG += currentTimeMillis - dVar.mZq;
            Log.i("MicroMsg.TaskBarViewPresenter", "reportTaskBarClose viewDuration:%d,lastStartTime:%d,currentTime:%d,closeType:%d,reportTime:%d", Long.valueOf(dVar.FUG), Long.valueOf(dVar.mZq), Long.valueOf(currentTimeMillis), Integer.valueOf(dVar.VbF), Integer.valueOf((int) (dVar.FUG / 1000)));
            com.tencent.mm.plugin.taskbar.a.a aVar = dVar.FUF;
            int i5 = (int) (dVar.FUG / 1000);
            int i6 = dVar.VbF;
            q qVar = new q();
            qVar.ekH = qVar.x("session_id", aVar.FSr, true);
            qVar.ekI = (long) i4;
            qVar.ekU = (long) i5;
            qVar.ekR = (long) i6;
            qVar.bfK();
            dVar.FUG = 0;
            dVar.mZq = 0;
            this.onN = false;
            this.onO = false;
            this.FUi.FH(true);
            AnonymousClass11 r2 = new Runnable() {
                /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(238242);
                    TaskBarView taskBarView = TaskBarView.this;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(taskBarView, a2.axQ(), "com/tencent/mm/plugin/taskbar/ui/TaskBarView$7", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    taskBarView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(taskBarView, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$7", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                    TaskBarView.this.setTranslationY(0.0f);
                    AppMethodBeat.o(238242);
                }
            };
            if (i2 == 15) {
                j2 = (long) i3;
            } else {
                j2 = 0;
            }
            postDelayed(r2, j2);
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(238241);
                    TaskBarView.h(TaskBarView.this);
                    AppMethodBeat.o(238241);
                }
            }, (long) i3);
        }
        AppMethodBeat.o(238281);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void zT(int i2) {
        AppMethodBeat.i(238282);
        eG(i2, 0);
        AppMethodBeat.o(238282);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void caC() {
        AppMethodBeat.i(238283);
        caB();
        AppMethodBeat.o(238283);
    }

    /* access modifiers changed from: package-private */
    public final void fuS() {
        AppMethodBeat.i(238284);
        if (this.onh != null && e.atB()) {
            Log.i("MicroMsg.TaskBarView", "alvinluo switchToGradientBackgroundView");
            ViewParent parent = this.onh.getParent();
            if (parent instanceof View) {
                ((View) parent).setBackgroundColor(this.mContext.getResources().getColor(R.color.ac_));
            }
            View backgroundGradientView = this.onh.getBackgroundGradientView();
            if (backgroundGradientView != null) {
                backgroundGradientView.setVisibility(0);
                backgroundGradientView.setAlpha(1.0f);
            }
            if (this.onh.getBackgroundGLSurfaceView() instanceof DynamicBackgroundGLSurfaceView) {
                this.onT = true;
            }
        }
        AppMethodBeat.o(238284);
    }

    public int getTaskBarContainerBottom() {
        AppMethodBeat.i(238288);
        int bottom = getBottom();
        AppMethodBeat.o(238288);
        return bottom;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b.a
    public final void wo(boolean z) {
        this.FUp = z;
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<com.tencent.mm.plugin.taskbar.ui.section.a> {
        private TaskBarSectionWeAppRecyclerView.b VbA = new TaskBarSectionWeAppRecyclerView.b() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void a(final RecyclerView.v vVar, final b.a aVar, final boolean z) {
                AppMethodBeat.i(263669);
                if (aVar == null) {
                    AppMethodBeat.o(263669);
                    return;
                }
                d dVar = TaskBarView.this.FUi;
                LocalUsageInfo localUsageInfo = aVar.ooj;
                AnonymousClass1 r4 = new d.c() {
                    /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.a.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.taskbar.ui.d.c
                    public final void dQ(boolean z) {
                        int i2 = 1;
                        AppMethodBeat.i(238245);
                        Log.i("MicroMsg.TaskBarView", "checkLaunchAppBrand checkOk: %b", Boolean.valueOf(z));
                        if (!z) {
                            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(TaskBarView.this.mContext);
                            com.tencent.mm.plugin.appbrand.launching.f.a.aco(aVar.ooj.username);
                            AppMethodBeat.o(238245);
                            return;
                        }
                        TaskBarView.j(TaskBarView.this);
                        if (z) {
                            TaskBarView.a(TaskBarView.this, 1104, aVar.ooj, vVar.lR());
                        } else {
                            TaskBarView.a(TaskBarView.this, 1089, aVar.ooj, vVar.lR());
                        }
                        TaskBarView taskBarView = TaskBarView.this;
                        LocalUsageInfo localUsageInfo = aVar.ooj;
                        int lR = vVar.lR();
                        boolean z2 = z;
                        d dVar = taskBarView.FUi;
                        p.h(localUsageInfo, "appItem");
                        Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked appId:%s,pos:%d", localUsageInfo.appId, Integer.valueOf(lR));
                        String eP = com.tencent.mm.plugin.multitask.g.eP(localUsageInfo.appId, localUsageInfo.iOo);
                        if (z2) {
                            i2 = 3;
                        }
                        dVar.VbF = i2;
                        dVar.FUF.I(i2, lR, eP);
                        AppMethodBeat.o(238245);
                    }
                };
                if (!dVar.iCn || dVar.ocu == 1) {
                    r4.dQ(true);
                    AppMethodBeat.o(263669);
                } else if (localUsageInfo == null || Util.isNullOrNil(localUsageInfo.username)) {
                    r4.dQ(true);
                    AppMethodBeat.o(263669);
                } else {
                    WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localUsageInfo.username);
                    if (Xk != null) {
                        WxaAttributes.a bAn = Xk.bAn();
                        p.g(bAn, "attrs.appInfo");
                        r4.dQ(dVar.a(localUsageInfo, bAn));
                        AppMethodBeat.o(263669);
                        return;
                    }
                    ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(localUsageInfo.username, new d.e(dVar, r4, localUsageInfo));
                    AppMethodBeat.o(263669);
                }
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void hWX() {
                AppMethodBeat.i(263670);
                FG(false);
                AppMethodBeat.o(263670);
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void fuV() {
                AppMethodBeat.i(238249);
                FG(true);
                AppMethodBeat.o(238249);
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void a(b.a aVar, int i2) {
                AppMethodBeat.i(263671);
                TaskBarView.this.FUi.T(i2, false);
                TaskBarView.this.FUi.bq(false, false);
                TaskBarView.this.FUl.setDataList(TaskBarView.this.FUi.FUB);
                TaskBarView.this.adj.b(0, Boolean.TRUE);
                TaskBarView.this.a(aVar.ooj, i2, false);
                AppMethodBeat.o(263671);
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void b(b.a aVar, int i2) {
                AppMethodBeat.i(263672);
                TaskBarView.this.FUi.T(i2, true);
                TaskBarView.this.FUi.bq(false, true);
                TaskBarView.this.Vbt.setDataList(TaskBarView.this.FUi.VbD);
                TaskBarView.this.adj.b(TaskBarView.this.FUj.indexOf(2), Boolean.TRUE);
                TaskBarView.this.a(aVar.ooj, i2, true);
                AppMethodBeat.o(263672);
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void a(b.a aVar, boolean z) {
                int i2;
                AppMethodBeat.i(263673);
                TaskBarView taskBarView = TaskBarView.this;
                LocalUsageInfo localUsageInfo = aVar.ooj;
                d dVar = taskBarView.FUi;
                p.h(localUsageInfo, "appItem");
                String eP = com.tencent.mm.plugin.multitask.g.eP(localUsageInfo.appId, localUsageInfo.iOo);
                Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear appId:%s,multiTaskId:%s", localUsageInfo.appId, eP);
                if (z) {
                    i2 = 3;
                } else {
                    i2 = 1;
                }
                d.b bVar = dVar.FUL;
                if (bVar == null || !bVar.esy()) {
                    d.C1800d dVar2 = new d.C1800d();
                    dVar2.FUN = 1;
                    dVar2.pageType = i2;
                    dVar2.pFK = eP;
                    dVar.FUH.add(dVar2);
                    AppMethodBeat.o(263673);
                    return;
                }
                dVar.FUF.J(2, i2, eP);
                AppMethodBeat.o(263673);
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void a(boolean z, int i2, LocalUsageInfo localUsageInfo) {
                int i3 = 2;
                AppMethodBeat.i(263674);
                Log.i("MicroMsg.TaskBarView", "notifyMyWeAppChanged %b %d", Boolean.valueOf(z), Integer.valueOf(i2));
                TaskBarView.this.FUi.bq(false, true);
                int indexOf = TaskBarView.this.FUj.indexOf(2);
                if (indexOf != -1) {
                    if (TaskBarView.this.Vbt != null) {
                        TaskBarView.this.adj.b(indexOf, Boolean.TRUE);
                        if (z) {
                            TaskBarView.this.Vbt.bF(TaskBarView.this.FUi.VbD);
                        } else {
                            TaskBarView.this.Vbt.bG(TaskBarView.this.FUi.VbD);
                        }
                    }
                } else if (z) {
                    TaskBarView.c(TaskBarView.this);
                    TaskBarView.this.adj.cj(TaskBarView.this.FUj.indexOf(2));
                }
                d dVar = TaskBarView.this.FUi;
                p.h(localUsageInfo, "appItem");
                Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemManualAddDeleteMyWeApp appId:%s,pos:%d", localUsageInfo.appId, Integer.valueOf(i2));
                String eP = com.tencent.mm.plugin.multitask.g.eP(localUsageInfo.appId, localUsageInfo.iOo);
                if (z) {
                    i3 = 1;
                }
                int i4 = 7;
                if (z) {
                    i4 = 6;
                }
                dVar.FUF.a(i3, i4, 1, eP, 0);
                AppMethodBeat.o(263674);
            }

            @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b
            public final void hWY() {
                AppMethodBeat.i(263675);
                TaskBarView.j(TaskBarView.this);
                TaskBarView.this.FUn = false;
                com.tencent.mm.plugin.websearch.api.h hVar = (com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class);
                if (hVar != null) {
                    TaskBarView.this.Vbx = true;
                    hVar.b(TaskBarView.this.mContext, 42, TaskBarView.this.onG, "");
                }
                TaskBarView.this.axg(12);
                AppMethodBeat.o(263675);
            }

            private void FG(boolean z) {
                AppMethodBeat.i(263676);
                TaskBarView.j(TaskBarView.this);
                TaskBarView.this.FUn = true;
                TaskBarView.this.onP = 9;
                if (z) {
                    ((t) g.af(t.class)).L(TaskBarView.this.getContext(), 0);
                } else {
                    ((t) g.af(t.class)).O(TaskBarView.this.getContext(), 3);
                }
                TaskBarView.this.axg(z ? 2 : 11);
                AppMethodBeat.o(263676);
            }
        };

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* bridge */ /* synthetic */ void a(com.tencent.mm.plugin.taskbar.ui.section.a aVar, int i2) {
            AppMethodBeat.i(238258);
            a(aVar, i2);
            AppMethodBeat.o(238258);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(com.tencent.mm.plugin.taskbar.ui.section.a aVar, int i2, List list) {
            AppMethodBeat.i(238257);
            com.tencent.mm.plugin.taskbar.ui.section.a aVar2 = aVar;
            if (list.size() == 0) {
                a(aVar2, i2);
            }
            AppMethodBeat.o(238257);
        }

        a() {
            AppMethodBeat.i(238252);
            au(true);
            AppMethodBeat.o(238252);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final long getItemId(int i2) {
            AppMethodBeat.i(238253);
            long intValue = (long) ((Integer) TaskBarView.this.FUj.get(i2)).intValue();
            AppMethodBeat.o(238253);
            return intValue;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(238254);
            int c2 = TaskBarView.c(TaskBarView.this, i2);
            AppMethodBeat.o(238254);
            return c2;
        }

        private void a(com.tencent.mm.plugin.taskbar.ui.section.a aVar, int i2) {
            boolean z = true;
            AppMethodBeat.i(263677);
            Log.i("MicroMsg.TaskBarView", "onBind %d %d", Integer.valueOf(aVar.auw), Integer.valueOf(i2));
            switch (aVar.auw) {
                case 1:
                    TaskBarView.this.FUl = (com.tencent.mm.plugin.taskbar.ui.section.weapp.b) aVar.aus;
                    TaskBarView.this.FUl.setDataList(TaskBarView.this.FUi.FUB);
                    break;
                case 2:
                    TaskBarView.this.Vbt = (c) aVar.aus;
                    TaskBarView.this.Vbt.setDataList(TaskBarView.this.FUi.VbD);
                    TaskBarView.this.Vbt.setSearchHidden(i2 != 0);
                    break;
                case 3:
                    com.tencent.mm.plugin.taskbar.ui.section.c cVar = (com.tencent.mm.plugin.taskbar.ui.section.c) aVar.aus;
                    if (TaskBarView.this.FUj.size() != 1) {
                        z = false;
                    }
                    cVar.qco.setText(com.tencent.mm.cb.a.aI(cVar.getContext(), z ? R.string.ry : R.string.s1));
                    break;
            }
            com.tencent.mm.plugin.taskbar.ui.section.g viewModel = aVar.fvh().getViewModel();
            Log.i("MicroMsg.TaskBarSectionViewModel", "update show data oldCount:" + viewModel.FVI.size() + " new:" + viewModel.FVH.size());
            viewModel.FVI.clear();
            viewModel.FVI.addAll(viewModel.FVH);
            aVar.fvh().notifyDataSetChanged();
            AppMethodBeat.o(263677);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(238256);
            int size = TaskBarView.this.FUj.size();
            AppMethodBeat.o(238256);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ com.tencent.mm.plugin.taskbar.ui.section.a a(ViewGroup viewGroup, int i2) {
            com.tencent.mm.plugin.taskbar.ui.section.a aVar;
            AppMethodBeat.i(238259);
            switch (i2) {
                case 1:
                    TaskBarView.this.FUl = new com.tencent.mm.plugin.taskbar.ui.section.weapp.b(TaskBarView.this.getContext(), TaskBarView.this, i2, (byte) 0);
                    TaskBarView.this.FUl.setWeAppCallback(this.VbA);
                    aVar = new com.tencent.mm.plugin.taskbar.ui.section.a(TaskBarView.this.FUl);
                    break;
                case 2:
                    TaskBarView.this.Vbt = new c(TaskBarView.this.getContext(), (b.a) TaskBarView.this, i2, (char) 0);
                    TaskBarView.this.Vbt.setWeAppCallback(this.VbA);
                    aVar = new com.tencent.mm.plugin.taskbar.ui.section.a(TaskBarView.this.Vbt);
                    break;
                case 3:
                    aVar = new com.tencent.mm.plugin.taskbar.ui.section.a(new com.tencent.mm.plugin.taskbar.ui.section.c(TaskBarView.this.getContext(), (b.a) TaskBarView.this, i2, (char) 0));
                    break;
                case 4:
                    TaskBarView.this.Vbu = new com.tencent.mm.plugin.taskbar.ui.section.other.a(TaskBarView.this.getContext(), (b.a) TaskBarView.this, i2, (char) 0);
                    aVar = new com.tencent.mm.plugin.taskbar.ui.section.a(TaskBarView.this.Vbu);
                    break;
                default:
                    AppMethodBeat.o(238259);
                    return null;
            }
            com.tencent.mm.plugin.taskbar.ui.section.g abG = TaskBarView.this.FUi.abG(i2);
            if (abG != null) {
                aVar.fvh().setViewModel(abG);
            }
            AppMethodBeat.o(238259);
            return aVar;
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b.a
    public final void jd(boolean z) {
        this.FUo = z;
        this.FUn = true;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b.a
    public final void abE(int i2) {
        AppMethodBeat.i(238289);
        if (i2 != 4 || abF(i2) == -1 || !this.FUi.abG(4).FVI.isEmpty()) {
            getAdapter().b(abF(i2), Boolean.TRUE);
            AppMethodBeat.o(238289);
            return;
        }
        Log.i("MicroMsg.TaskBarView", "other last item removed");
        this.FUi.a(this.FUi.abG(4));
        axf(4);
        AppMethodBeat.o(238289);
    }

    private int abF(int i2) {
        AppMethodBeat.i(238290);
        int indexOf = this.FUj.indexOf(Integer.valueOf(i2));
        AppMethodBeat.o(238290);
        return indexOf;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.d.b
    public final boolean esy() {
        return this.onK;
    }

    /* access modifiers changed from: package-private */
    public class b extends RecyclerView.h {
        private b() {
        }

        /* synthetic */ b(TaskBarView taskBarView, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            int i2;
            boolean z;
            AppMethodBeat.i(238260);
            super.a(rect, view, recyclerView, sVar);
            RecyclerView.v bi = recyclerView.bi(view);
            if (bi == null) {
                Log.w("MicroMsg.TaskBarView", "null holder");
                AppMethodBeat.o(238260);
                return;
            }
            int lR = bi.lR();
            if (!sVar.aui || lR != -1) {
                i2 = lR;
            } else {
                i2 = bi.auu;
            }
            int i3 = bi.auw;
            if (i2 == 0) {
                if (i3 == 1 || i3 == 2) {
                    rect.top = 0;
                } else {
                    rect.top = com.tencent.mm.cb.a.aH(view.getContext(), R.dimen.ct);
                }
            } else if (i3 == 2) {
                rect.top = com.tencent.mm.cb.a.aH(view.getContext(), R.dimen.ce);
            } else {
                rect.top = com.tencent.mm.cb.a.aH(view.getContext(), R.dimen.cl);
            }
            if (i3 == 3) {
                TaskBarView taskBarView = TaskBarView.this;
                if (TaskBarView.this.FUj.size() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                rect.top = TaskBarView.c(taskBarView, z);
            }
            if (i3 == ((Integer) TaskBarView.this.FUj.get(TaskBarView.this.FUj.size() - 1)).intValue()) {
                rect.bottom = com.tencent.mm.cb.a.aH(view.getContext(), R.dimen.cl);
            }
            Log.i("MicroMsg.TaskBarView", "getItemOffsets index:%d sectionType:%d rect:%s", Integer.valueOf(i2), Integer.valueOf(i3), rect);
            AppMethodBeat.o(238260);
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b.a
    public final void a(MultiTaskInfo multiTaskInfo, int i2) {
        AppMethodBeat.i(238292);
        d dVar = this.FUi;
        p.h(multiTaskInfo, "multiTaskInfo");
        Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d,pos:%d", Integer.valueOf(multiTaskInfo.field_type), Integer.valueOf(i2));
        int Mm = com.tencent.mm.plugin.taskbar.a.a.Mm(multiTaskInfo.field_type);
        dVar.VbF = Mm;
        dVar.FUF.I(Mm, i2, multiTaskInfo.field_id);
        AppMethodBeat.o(238292);
    }

    public final void axg(int i2) {
        AppMethodBeat.i(263684);
        d dVar = this.FUi;
        dVar.VbF = i2;
        Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d", Integer.valueOf(i2));
        dVar.FUF.I(i2, 0, "");
        AppMethodBeat.o(263684);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.b.a
    public final void n(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238293);
        d dVar = this.FUi;
        p.h(multiTaskInfo, "multiTaskInfo");
        Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear type:%d,multiTaskId:%s", Integer.valueOf(multiTaskInfo.field_type), multiTaskInfo.field_id);
        int Mm = com.tencent.mm.plugin.taskbar.a.a.Mm(multiTaskInfo.field_type);
        d.b bVar = dVar.FUL;
        if (bVar == null || !bVar.esy()) {
            d.C1800d dVar2 = new d.C1800d();
            dVar2.FUN = 1;
            dVar2.pageType = Mm;
            dVar2.pFK = multiTaskInfo.field_id;
            dVar2.Agu = multiTaskInfo;
            dVar.FUH.add(dVar2);
            AppMethodBeat.o(238293);
            return;
        }
        dVar.FUF.J(2, Mm, multiTaskInfo.field_id);
        AppMethodBeat.o(238293);
    }

    public final void a(LocalUsageInfo localUsageInfo, int i2, boolean z) {
        int i3 = 1;
        AppMethodBeat.i(263685);
        d dVar = this.FUi;
        p.h(localUsageInfo, "appItem");
        Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemManualDeleted appId:%s,pos:%d", localUsageInfo.appId, Integer.valueOf(i2));
        String eP = com.tencent.mm.plugin.multitask.g.eP(localUsageInfo.appId, localUsageInfo.iOo);
        if (z) {
            i3 = 3;
        }
        dVar.FUF.a(2, 3, i3, eP, 0);
        AppMethodBeat.o(263685);
    }

    static /* synthetic */ void h(TaskBarView taskBarView) {
        AppMethodBeat.i(263687);
        Log.i("MicroMsg.TaskBarView", "onDidCloseHeader %b", Boolean.valueOf(taskBarView.Vbv));
        if (!taskBarView.Vbv) {
            taskBarView.setupMultiTaskScroll(true);
            taskBarView.Vbw = true;
            taskBarView.fuQ();
        }
        AppMethodBeat.o(263687);
    }

    static /* synthetic */ void a(TaskBarView taskBarView, int i2, final LocalUsageInfo localUsageInfo, int i3) {
        AppMethodBeat.i(263688);
        Log.v("MicroMsg.TaskBarView", "alvinluo launchAppBrand position: %d", Integer.valueOf(i3));
        final AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i2;
        appBrandStatObject.dCw = "1:".concat(String.valueOf(i3));
        if (localUsageInfo != null) {
            taskBarView.FUn = true;
            taskBarView.fuS();
            taskBarView.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(238244);
                    TaskBarView.this.onP = 13;
                    ((r) g.af(r.class)).a(TaskBarView.this.getContext(), localUsageInfo.username, localUsageInfo.appId, localUsageInfo.iOo, -1, (String) null, appBrandStatObject);
                    AppMethodBeat.o(238244);
                }
            }, 100);
        }
        AppMethodBeat.o(263688);
    }

    static /* synthetic */ int c(TaskBarView taskBarView, int i2) {
        AppMethodBeat.i(263689);
        if (i2 < 0 || i2 >= taskBarView.FUj.size()) {
            AppMethodBeat.o(263689);
            return -1;
        }
        int intValue = taskBarView.FUj.get(i2).intValue();
        AppMethodBeat.o(263689);
        return intValue;
    }

    static /* synthetic */ int c(TaskBarView taskBarView, boolean z) {
        AppMethodBeat.i(263690);
        if (z) {
            int height = taskBarView.getHeight() / 3;
            AppMethodBeat.o(263690);
            return height;
        }
        int height2 = taskBarView.getHeight();
        if (taskBarView.FUj.contains(1) && taskBarView.FUl != null) {
            height2 -= taskBarView.FUl.getHeight();
        }
        if (taskBarView.FUj.contains(2) && taskBarView.Vbt != null) {
            height2 -= taskBarView.Vbt.getHeight();
        }
        int max = Math.max(height2 / 3, com.tencent.mm.cb.a.aH(taskBarView.getContext(), R.dimen.cb));
        AppMethodBeat.o(263690);
        return max;
    }
}
