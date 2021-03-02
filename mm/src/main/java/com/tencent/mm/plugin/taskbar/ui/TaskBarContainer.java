package com.tencent.mm.plugin.taskbar.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.h;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.multitask.ui.bg.a;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.d;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;

public class TaskBarContainer extends HeaderContainer implements View.OnTouchListener {
    private MMFragmentActivity Dpx;
    private b FTE;
    private TaskBarView FTF;
    private DynamicBgContainer FTG;
    private GradientColorBackgroundView FTH;
    private Rect FTJ = new Rect();
    private boolean FTK = false;
    private LinearLayout FTL;
    private View FTM;
    private View FTN;
    private TextView FTO;
    private WeImageView FTP;
    private WeImageView FTQ;
    private WeImageView FTR;
    private WeImageView FTS;
    private View FTT;
    private View FTU;
    private TaskBarBottomView FTV;
    private View FTX;
    private boolean FTY = true;
    private int FTZ = 0;
    private GyroView FTo;
    private int FUa = 0;
    private boolean FUb = LocaleUtil.isChineseAppLang();
    private a FUc = null;
    private Runnable FUd = null;
    private IListener FUe = new IListener<yp>() {
        /* class com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.AnonymousClass1 */

        {
            AppMethodBeat.i(238158);
            this.__eventId = yp.class.getName().hashCode();
            AppMethodBeat.o(238158);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yp ypVar) {
            AppMethodBeat.i(238159);
            yp ypVar2 = ypVar;
            Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateMainActionBarView updateField: %d", Integer.valueOf(ypVar2.eeQ.eeR));
            TaskBarContainer.a(TaskBarContainer.this, ypVar2);
            AppMethodBeat.o(238159);
            return false;
        }
    };
    private FrameLayout Vbq;
    private int aYN = 0;
    private int aYO = 0;
    private int aqL = 0;
    private View nZg;
    private boolean whs = true;

    static /* synthetic */ void b(TaskBarContainer taskBarContainer) {
        AppMethodBeat.i(238201);
        taskBarContainer.fuM();
        AppMethodBeat.o(238201);
    }

    public TaskBarContainer(Context context) {
        super(context);
        AppMethodBeat.i(238163);
        init(context);
        AppMethodBeat.o(238163);
    }

    public TaskBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(238164);
        init(context);
        AppMethodBeat.o(238164);
    }

    public TaskBarContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(238165);
        init(context);
        AppMethodBeat.o(238165);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.i(238166);
        this.Dpx = mMFragmentActivity;
        AppMethodBeat.o(238166);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setAnimController(b bVar) {
        AppMethodBeat.i(238167);
        this.FTE = bVar;
        if (!(this.FTF == null || this.FTE == null)) {
            this.FTE.a(this.FTF);
        }
        AppMethodBeat.o(238167);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setFixedHeight(boolean z) {
        this.FTY = z;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setExtraBottomHeight(int i2) {
        this.FUa = i2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        AppMethodBeat.i(238168);
        fuK();
        Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.FTZ), Integer.valueOf(this.FUa));
        if (this.FTY) {
            int measuredHeight = ((((ViewGroup) getParent()).getMeasuredHeight() - this.FTZ) - this.FUa) - this.aqL;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            this.aYO = measuredHeight;
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i2, makeMeasureSpec);
        if (getMeasuredWidth() != this.aYN) {
            Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYN));
            this.aYN = getMeasuredWidth();
            Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", Integer.valueOf(getMeasuredWidth()));
            this.FTL.setPivotX(((float) getMeasuredWidth()) / 2.0f);
            this.FTL.setPivotY((float) au.eu(getContext()));
            fuL();
        }
        AppMethodBeat.o(238168);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public int getViewHeight() {
        return this.aYO;
    }

    private void fuK() {
        AppMethodBeat.i(238169);
        int i2 = getResources().getConfiguration().orientation;
        this.FTZ = 0;
        AppMethodBeat.o(238169);
    }

    private void init(Context context) {
        AppMethodBeat.i(238170);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
        this.aqL = com.tencent.mm.cb.a.fromDPToPix(context, 16);
        fuK();
        setBackgroundColor(getResources().getColor(R.color.ac_));
        com.tencent.mm.plugin.taskbar.ui.a.a aVar = com.tencent.mm.plugin.taskbar.ui.a.a.FUZ;
        com.tencent.mm.plugin.taskbar.ui.a.a.fva();
        hp(context);
        AppMethodBeat.o(238170);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(238171);
        super.onAttachedToWindow();
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
        if (this.FUe != null) {
            this.FUe.alive();
        }
        jy jyVar = new jy();
        EventCenter.instance.publish(jyVar);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", Integer.valueOf(jyVar.dOR.dOS));
        String string = getContext().getResources().getString(R.string.wx);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            if (this.FUb) {
                string = string + h.jr(getContext());
            } else {
                string = string + " " + h.jr(getContext());
            }
        }
        if (jyVar.dOR.dOS > 0) {
            if (!this.FUb) {
                string = string + " ";
            }
            string = string + "(" + jyVar.dOR.dOS + ")";
        }
        setActionBarTitle(string);
        AppMethodBeat.o(238171);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(238172);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
        if (this.FUe != null) {
            this.FUe.dead();
        }
        AppMethodBeat.o(238172);
    }

    private void hp(Context context) {
        AppMethodBeat.i(238173);
        View inflate = LayoutInflater.from(context).inflate(R.layout.c1m, (ViewGroup) null);
        this.FTL = (LinearLayout) inflate.findViewById(R.id.nq);
        ((FrameLayout.LayoutParams) this.FTL.getLayoutParams()).topMargin = ao.getStatusBarHeight(context);
        this.FTo = (GyroView) inflate.findViewById(R.id.dmt);
        this.Vbq = (FrameLayout) inflate.findViewById(R.id.ju3);
        this.FTM = LayoutInflater.from(context).inflate(R.layout.c1o, (ViewGroup) null);
        this.FTN = this.FTM.findViewById(R.id.be3);
        ((FrameLayout) inflate.findViewById(R.id.nn)).addView(this.FTM, -1, -1);
        this.FTO = (TextView) this.FTM.findViewById(R.id.nk);
        this.FTP = (WeImageView) this.FTM.findViewById(R.id.he6);
        this.FTQ = (WeImageView) this.FTM.findViewById(R.id.gdh);
        this.FTS = (WeImageView) this.FTM.findViewById(R.id.dpw);
        this.FTT = this.FTM.findViewById(R.id.he7);
        this.FTU = this.FTM.findViewById(R.id.gdi);
        this.FTV = (TaskBarBottomView) this.FTM.findViewById(R.id.nl);
        this.FTR = (WeImageView) this.FTM.findViewById(R.id.ei);
        this.FTP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(238160);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TaskBarContainer.this.FTE != null && TaskBarContainer.this.FTE.esy()) {
                    TaskBarContainer.this.FTE.abu(16);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(238160);
            }
        });
        this.FTQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(238161);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TaskBarContainer.this.FTE != null && TaskBarContainer.this.FTE.esy()) {
                    TaskBarContainer.this.FTE.abu(14);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(238161);
            }
        });
        fuL();
        this.FTF = (TaskBarView) inflate.findViewById(R.id.nt);
        this.FTF.setHeaderContainer(this);
        this.FTF.setId(R.id.nt);
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(238173);
    }

    private void fuL() {
        AppMethodBeat.i(238174);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", Integer.valueOf(getMeasuredWidth()));
        if (!this.whs) {
            AppMethodBeat.o(238174);
            return;
        }
        if (this.FTL != null) {
            this.FTL.setScaleX(0.6f);
            this.FTL.setScaleY(0.6f);
        }
        AppMethodBeat.o(238174);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setActionBar(View view) {
        AppMethodBeat.i(238175);
        super.setActionBar(view);
        this.nZg = view;
        fuM();
        AppMethodBeat.o(238175);
    }

    private void fuM() {
        boolean z;
        AppMethodBeat.i(238176);
        if (!(this.FTO == null || this.nZg == null)) {
            int[] iArr = new int[2];
            this.nZg.getLocationOnScreen(iArr);
            Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            if (Build.VERSION.SDK_INT >= 24) {
                z = this.Dpx.isInMultiWindowMode();
            } else {
                z = false;
            }
            if (z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.FTO.getLayoutParams();
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.r);
                Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", Integer.valueOf(layoutParams.leftMargin));
                if (this.FTO.getParent() != null) {
                    this.FTO.getParent().requestLayout();
                }
                this.FTM.setVisibility(0);
            }
        }
        AppMethodBeat.o(238176);
    }

    private void setActionBarTitle(String str) {
        AppMethodBeat.i(238177);
        if (!g.aAc()) {
            AppMethodBeat.o(238177);
            return;
        }
        if (this.FTO != null) {
            this.FTO.setText(l.e(getContext(), (CharSequence) str, com.tencent.mm.cb.a.aG(getContext(), R.dimen.l)));
            float aH = ((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.f3058c)) * com.tencent.mm.cb.a.ji(getContext());
            if (this.FTO.getTextSize() != aH) {
                this.FTO.setTextSize(0, aH);
            }
            ao.a(this.FTO.getPaint(), 0.8f);
            ((c) g.ah(c.class)).setTextWithStatus(this.FTO, com.tencent.mm.plugin.auth.a.a.ceA(), a.b.PLANET, a.c.OUTLINED);
        }
        AppMethodBeat.o(238177);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void jh(int i2, int i3) {
        AppMethodBeat.i(238178);
        if (!this.whs) {
            if (i2 <= 10) {
                this.whs = true;
            }
            AppMethodBeat.o(238178);
            return;
        }
        if (this.FTL != null) {
            if (i2 <= 10) {
                AppMethodBeat.o(238178);
                return;
            }
            this.FTL.setTranslationY((float) (getMeasuredHeight() - getBottom()));
            float max = Math.max(Math.min((((((float) i2) * 1.0f) / ((float) i3)) * 0.39999998f) + 0.6f, 1.0f), 0.6f);
            this.FTL.setScaleX(max);
            this.FTL.setScaleY(max);
            Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", Float.valueOf(max), Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 >= i3) {
                this.whs = false;
            }
        }
        AppMethodBeat.o(238178);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final boolean isFullScreen() {
        return true;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public Rect getBackUpFooterRect() {
        return this.FTJ;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(238179);
        if (this.FTE != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            this.FTE.onTouch(view, motionEvent);
        }
        AppMethodBeat.o(238179);
        return false;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public com.tencent.mm.plugin.appbrand.widget.c.a.a getHeaderView() {
        return null;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public View getEmptyView() {
        return null;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public GyroView getGyroView() {
        return this.FTo;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public View getMaskView() {
        return this.FTX;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void f(Configuration configuration) {
        AppMethodBeat.i(238180);
        super.f(configuration);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", Integer.valueOf(configuration.orientation));
        if (this.FUd != null) {
            removeCallbacks(this.FUd);
        }
        this.FTM.setVisibility(4);
        AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(238162);
                TaskBarContainer.b(TaskBarContainer.this);
                if (ao.isDarkMode()) {
                    TaskBarContainer.this.abx(TaskBarContainer.this.getResources().getColor(R.color.ko));
                    AppMethodBeat.o(238162);
                    return;
                }
                TaskBarContainer.this.abx(TaskBarContainer.this.getResources().getColor(R.color.a2r));
                AppMethodBeat.o(238162);
            }
        };
        this.FUd = r0;
        postDelayed(r0, 400);
        if (this.FTF != null) {
            TaskBarView taskBarView = this.FTF;
            Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", Integer.valueOf(taskBarView.hIX), Integer.valueOf(configuration.orientation));
            if (taskBarView.onh != null) {
                taskBarView.onp = taskBarView.onh.getViewHeight();
                Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged fixedViewHeight: %d", Integer.valueOf(taskBarView.onp));
            }
            if (taskBarView.hIX != configuration.orientation) {
                taskBarView.hIX = configuration.orientation;
                if (taskBarView.onh == null || !taskBarView.onh.fuw()) {
                    taskBarView.reloadData();
                } else {
                    Log.i("MicroMsg.TaskBarView", "alvinluo onCustomConfigurationChanged closeHeader");
                    taskBarView.onh.ad(0, 0);
                    AppMethodBeat.o(238180);
                    return;
                }
            }
        }
        AppMethodBeat.o(238180);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void fuA() {
        AppMethodBeat.i(238181);
        if (this.Dpx == null) {
            AppMethodBeat.o(238181);
            return;
        }
        Pair<Integer, Integer> aO = com.tencent.mm.plugin.taskbar.ui.c.b.aO(this.Dpx);
        ((FrameLayout.LayoutParams) this.FTN.getLayoutParams()).setMargins(((Integer) aO.first).intValue(), 0, ((Integer) aO.second).intValue(), 0);
        this.FTM.requestLayout();
        this.FTM.setVisibility(0);
        AppMethodBeat.o(238181);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final boolean fuw() {
        AppMethodBeat.i(238182);
        if (this.FTE != null) {
            boolean fuw = this.FTE.fuw();
            AppMethodBeat.o(238182);
            return fuw;
        }
        AppMethodBeat.o(238182);
        return false;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void ac(long j2, int i2) {
        AppMethodBeat.i(238183);
        super.ac(j2, i2);
        if (this.FTE != null) {
            this.FTE.i(j2, i2, false);
        }
        AppMethodBeat.o(238183);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void ad(long j2, int i2) {
        AppMethodBeat.i(238184);
        super.ad(j2, i2);
        if (this.FTE != null) {
            this.FTE.i(j2, i2, true);
        }
        AppMethodBeat.o(238184);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void o(View view, View view2) {
        AppMethodBeat.i(238185);
        a((DynamicBgContainer) view, (GradientColorBackgroundView) view2);
        AppMethodBeat.o(238185);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setDynamicBackgroundView(View view) {
        AppMethodBeat.i(238186);
        a((DynamicBgContainer) view, this.FTH);
        AppMethodBeat.o(238186);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setBlurAlpha(float f2) {
        AppMethodBeat.i(238188);
        if (this.FTK) {
            AppMethodBeat.o(238188);
            return;
        }
        this.Vbq.setAlpha(f2);
        AppMethodBeat.o(238188);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public void setBlurAnimateStatue(boolean z) {
        this.FTK = z;
    }

    private void a(DynamicBgContainer dynamicBgContainer, GradientColorBackgroundView gradientColorBackgroundView) {
        AppMethodBeat.i(238189);
        this.FTG = dynamicBgContainer;
        this.FTH = gradientColorBackgroundView;
        if (this.FTE != null) {
            this.FTE.o(dynamicBgContainer, this.FTH);
        }
        AppMethodBeat.o(238189);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void onResume() {
        AppMethodBeat.i(238190);
        super.onResume();
        fuA();
        if (this.FTF != null) {
            TaskBarView taskBarView = this.FTF;
            Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume");
            taskBarView.isPaused = false;
            taskBarView.Vbx = false;
            if (taskBarView.asn) {
                Log.v("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume setLayoutFrozen false");
                taskBarView.setLayoutFrozen(false);
            }
            Log.i("MicroMsg.TaskBarView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", Boolean.valueOf(taskBarView.onK), Boolean.valueOf(taskBarView.onO), Boolean.valueOf(taskBarView.FUn));
            if (taskBarView.onK && taskBarView.onO) {
                if (e.atB() && taskBarView.onh != null && taskBarView.onh.fuw()) {
                    Log.i("MicroMsg.TaskBarView", "alvinluo switchToDynamicBackgroundView");
                    ((View) taskBarView.onh.getParent()).setBackgroundColor(taskBarView.mContext.getResources().getColor(R.color.ac_));
                    View backgroundGradientView = taskBarView.onh.getBackgroundGradientView();
                    if (backgroundGradientView != null) {
                        backgroundGradientView.setVisibility(0);
                    }
                    View backgroundGLSurfaceView = taskBarView.onh.getBackgroundGLSurfaceView();
                    if (backgroundGLSurfaceView instanceof DynamicBackgroundGLSurfaceView) {
                        backgroundGLSurfaceView.setVisibility(0);
                        if (taskBarView.onT) {
                            ((DynamicBackgroundGLSurfaceView) backgroundGLSurfaceView).onResume();
                            taskBarView.onT = false;
                        }
                        Log.i("MicroMsg.TaskBarView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
                        taskBarView.postDelayed(new Runnable(backgroundGLSurfaceView) {
                            /* class com.tencent.mm.plugin.taskbar.ui.TaskBarView.AnonymousClass12 */
                            final /* synthetic */ View Vbz;

                            {
                                this.Vbz = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(238243);
                                Log.i("MicroMsg.TaskBarView", "do show");
                                ((DynamicBackgroundGLSurfaceView) this.Vbz).setShowGradientView(false);
                                AppMethodBeat.o(238243);
                            }
                        }, 100);
                    }
                }
                taskBarView.onN = true;
                taskBarView.onO = true;
            }
            if (taskBarView.FUn && taskBarView.onh != null) {
                taskBarView.onh.ad(0, taskBarView.onP);
                taskBarView.onP = 0;
                taskBarView.FUn = false;
            }
            taskBarView.FUi.cau();
            taskBarView.fuQ();
            d dVar = taskBarView.FUi;
            d.b bVar = dVar.FUL;
            if (bVar == null) {
                AppMethodBeat.o(238190);
                return;
            } else if (bVar.esy()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis >= dVar.mZq) {
                    dVar.mZq = currentTimeMillis;
                }
                Log.i("MicroMsg.TaskBarViewPresenter", "onResume lastStartTime:%d,duration:%d,currentTime:%d", Long.valueOf(dVar.mZq), Long.valueOf(dVar.FUG), Long.valueOf(currentTimeMillis));
            }
        }
        AppMethodBeat.o(238190);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void onPause() {
        AppMethodBeat.i(238191);
        super.onPause();
        if (this.FTF != null) {
            TaskBarView taskBarView = this.FTF;
            taskBarView.isPaused = true;
            Log.i("MicroMsg.TaskBarView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b", Boolean.valueOf(taskBarView.onK), Boolean.valueOf(taskBarView.onN));
            if (taskBarView.onK && taskBarView.onN) {
                taskBarView.onO = true;
                taskBarView.fuS();
            }
            if (taskBarView.FUo) {
                taskBarView.FUo = false;
                if (taskBarView.onh != null) {
                    taskBarView.onh.ac(1000, taskBarView.onP);
                    taskBarView.onP = 0;
                }
            }
            d dVar = taskBarView.FUi;
            d.b bVar = dVar.FUL;
            if (bVar == null) {
                AppMethodBeat.o(238191);
                return;
            } else if (bVar.esy()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis >= dVar.mZq) {
                    dVar.FUG += currentTimeMillis - dVar.mZq;
                }
                Log.i("MicroMsg.TaskBarViewPresenter", "onPause lastStartTime:%d,duration:%d,currentTime:%d", Long.valueOf(dVar.mZq), Long.valueOf(dVar.FUG), Long.valueOf(currentTimeMillis));
            }
        }
        AppMethodBeat.o(238191);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void onDestroy() {
        AppMethodBeat.i(238192);
        super.onDestroy();
        Log.i("MicroMsg.AppBrandDesktopContainer", "onDestroy");
        if (this.FTF != null) {
            TaskBarView taskBarView = this.FTF;
            Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onDestroy %d", Integer.valueOf(taskBarView.hashCode()));
            d dVar = taskBarView.FUi;
            Log.i("MicroMsg.TaskBarViewPresenter", "onDestroy");
            dVar.FUK.dead();
            dVar.VbH.dead();
            dVar.FUL = null;
            ah fuW = dVar.fuW();
            if (fuW != null) {
                fuW.remove(dVar.FUI);
            }
            ag hWZ = dVar.hWZ();
            if (hWZ != null) {
                hWZ.remove(dVar.VbG);
            }
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).b(dVar.kIM);
            com.tencent.mm.plugin.taskbar.h taskBarStorage = ((PluginTaskBar) g.ah(PluginTaskBar.class)).getTaskBarStorage();
            if (taskBarStorage != null) {
                taskBarStorage.remove(dVar.FUJ);
            }
            try {
                if (taskBarView.ont != null) {
                    taskBarView.removeCallbacks(taskBarView.ont);
                    taskBarView.ont = null;
                }
                if (taskBarView.onu != null) {
                    taskBarView.removeCallbacks(taskBarView.onu);
                    taskBarView.onu = null;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TaskBarView", e2, "alvinluo onDestroy exception", new Object[0]);
            }
        }
        if (this.FUe != null) {
            this.FUe.dead();
        }
        if (this.FUd != null) {
            removeCallbacks(this.FUd);
            this.FUd = null;
        }
        if (this.FTG != null) {
            this.FTG.release();
        }
        AppMethodBeat.o(238192);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public LinearLayout getRootLayout() {
        return this.FTL;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public View getBackgroundGLSurfaceContainer() {
        return this.FTG;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public View getBackgroundGLSurfaceView() {
        AppMethodBeat.i(238193);
        DynamicBackgroundGLSurfaceView dynamicBgSurfaceView = this.FTG.getDynamicBgSurfaceView();
        AppMethodBeat.o(238193);
        return dynamicBgSurfaceView;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public View getBackgroundGradientView() {
        return this.FTH;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void hWQ() {
        String str;
        awe awe;
        d.b bVar;
        AppMethodBeat.i(263664);
        TaskBarView taskBarView = this.FTF;
        Log.i("MicroMsg.TaskBarView", "onStartPull");
        taskBarView.Vbv = true;
        d dVar = taskBarView.FUi;
        Log.i("MicroMsg.TaskBarViewPresenter", "onStartToPull");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.f.h.RTc.aY(new d.k(dVar));
        if (dVar.hXb() && (bVar = dVar.FUL) != null) {
            bVar.hWS();
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        MultiTaskInfo hXc = dVar.hXc();
        if (hXc != null) {
            aws aws = new aws();
            try {
                aws.parseFrom(hXc.field_data);
                if (aws.tuO != null) {
                    FinderObject finderObject = aws.tuO;
                    if (finderObject == null) {
                        p.hyc();
                    }
                    hashMap.put(Long.valueOf(finderObject.id), hXc);
                    FinderObject finderObject2 = aws.tuO;
                    if (((finderObject2 == null || (awe = finderObject2.liveInfo) == null) ? 2 : awe.liveStatus) != 2) {
                        FinderObject finderObject3 = aws.tuO;
                        if (finderObject3 == null) {
                            p.hyc();
                        }
                        hashMap2.put(Long.valueOf(finderObject3.id), aws);
                    }
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.TaskBarViewPresenter", "FinderLiveMultiTaskData parse failed");
            }
        }
        if (!hashMap2.isEmpty()) {
            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
            if (currentTimeMillis2 - dVar.FUD <= ((long) dVar.FUE)) {
                Log.i("MicroMsg.TaskBarViewPresenter", "not check because of interval: " + dVar.FUE + " last:" + dVar.FUD);
            } else {
                dVar.FUD = currentTimeMillis2;
                Log.i("MicroMsg.TaskBarViewPresenter", "start check live status");
                aj ajVar = (aj) g.ah(aj.class);
                Collection values = hashMap2.values();
                p.g(values, "objId2LiveDataNotEnded.values");
                Collection<aws> collection = values;
                ArrayList arrayList = new ArrayList(j.a(collection, 10));
                for (aws aws2 : collection) {
                    FinderObject finderObject4 = aws2.tuO;
                    long valueOf = finderObject4 != null ? Long.valueOf(finderObject4.id) : 0L;
                    FinderObject finderObject5 = aws2.tuO;
                    if (finderObject5 == null || (str = finderObject5.objectNonceId) == null) {
                        str = "";
                    }
                    arrayList.add(new Pair(valueOf, str));
                }
                ajVar.batchGetLiveStatus(j.v((Collection) arrayList), new d.f(dVar, hashMap2, hashMap));
            }
        }
        Log.i("MicroMsg.TaskBarViewPresenter", "onStartToPull done " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(263664);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public int getExtraBottomHeight() {
        return this.FUa;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void abx(int i2) {
        AppMethodBeat.i(238195);
        super.abx(i2);
        if (this.FTV != null) {
            this.FTV.setDrawColor(i2);
        }
        AppMethodBeat.o(238195);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void ji(int i2, int i3) {
        AppMethodBeat.i(238196);
        super.ji(i2, i3);
        if (this.FTO != null) {
            this.FTO.setTextColor(i2);
        }
        if (this.FTP != null) {
            this.FTP.setImageResource(R.raw.actionbar_icon_dark_search);
            this.FTP.setIconColor(i3);
        }
        if (this.FTQ != null) {
            this.FTQ.setImageResource(R.raw.icons_outlined_add2);
            this.FTQ.setIconColor(i3);
        }
        if (this.FTS != null) {
            this.FTS.setVisibility(this.FTF.FUi.iCn ? 0 : 8);
        }
        if (this.FTR != null) {
            this.FTR.setIconColor(i3);
            if (this.nZg != null) {
                View findViewById = this.nZg.findViewById(R.id.ei);
                if (findViewById == null || findViewById.getVisibility() != 0) {
                    this.FTR.setVisibility(4);
                    AppMethodBeat.o(238196);
                    return;
                }
                this.FTR.setVisibility(0);
            }
        }
        AppMethodBeat.o(238196);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public int getAnimationScrollOffset() {
        AppMethodBeat.i(238197);
        int animationScrollOffset = this.FTE.getAnimationScrollOffset();
        AppMethodBeat.o(238197);
        return animationScrollOffset;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.HeaderContainer
    public final void wn(boolean z) {
        AppMethodBeat.i(238198);
        super.wn(z);
        if (this.FTF != null) {
            TaskBarView taskBarView = this.FTF;
            Log.i("MicroMsg.TaskBarView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", Boolean.valueOf(z), Boolean.valueOf(taskBarView.dSv));
            if (taskBarView.dSv != z) {
                taskBarView.dSv = z;
            }
        }
        AppMethodBeat.o(238198);
    }

    static /* synthetic */ void a(TaskBarContainer taskBarContainer, yp ypVar) {
        int i2 = 0;
        AppMethodBeat.i(238200);
        if (ypVar.eeQ.eeR == 1) {
            taskBarContainer.setActionBarTitle(ypVar.eeQ.title);
            AppMethodBeat.o(238200);
            return;
        }
        if (ypVar.eeQ.eeR == 2) {
            if (taskBarContainer.FTT != null) {
                taskBarContainer.FTT.setVisibility(ypVar.eeQ.eeT ? 0 : 8);
            }
            if (taskBarContainer.FTU != null) {
                View view = taskBarContainer.FTU;
                if (!ypVar.eeQ.eeS) {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
        }
        AppMethodBeat.o(238200);
    }
}
