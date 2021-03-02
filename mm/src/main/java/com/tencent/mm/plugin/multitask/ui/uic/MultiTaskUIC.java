package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.animation.c.a.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.base.b;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u001a*\u0001\u001e\u0018\u0000 ³\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004³\u0001´\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010L\u001a\u00020!J,\u0010M\u001a\u00020!2\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020!2\b\b\u0002\u0010R\u001a\u00020!H\u0016J\u0010\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020\bH\u0016J$\u0010U\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\n\u0010V\u001a\u0004\u0018\u00010#H\u0002J\u0006\u0010W\u001a\u00020XJ\u000e\u0010Y\u001a\u00020!2\u0006\u0010Z\u001a\u00020[J\b\u0010\\\u001a\u00020!H\u0016J\u000e\u0010]\u001a\u00020X2\u0006\u0010^\u001a\u00020!J\u0010\u0010_\u001a\u00020X2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010`\u001a\u00020XH\u0016J\"\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020b2\u0006\u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u00020\bH\u0016J\u0010\u0010f\u001a\u00020!2\u0006\u0010c\u001a\u00020bH\u0016J\b\u0010g\u001a\u00020XH\u0002J\u000e\u0010h\u001a\u00020X2\u0006\u0010i\u001a\u00020!J\u0006\u0010j\u001a\u00020!J\b\u0010k\u001a\u00020XH\u0002J\b\u0010l\u001a\u00020XH\u0002J\b\u0010m\u001a\u00020!H\u0016J\u0006\u0010n\u001a\u00020!J\u0006\u0010o\u001a\u00020XJ\u0010\u0010p\u001a\u00020X2\u0006\u0010q\u001a\u00020!H\u0016J\"\u0010r\u001a\u00020X2\u0006\u0010s\u001a\u00020\b2\u0006\u0010t\u001a\u00020\b2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\b\u0010w\u001a\u00020!H\u0016J\u0012\u0010x\u001a\u00020X2\b\u0010y\u001a\u0004\u0018\u00010vH\u0016J\u0010\u0010z\u001a\u00020X2\u0006\u0010{\u001a\u00020|H\u0016J\u0012\u0010}\u001a\u00020X2\b\u0010~\u001a\u0004\u0018\u000102H\u0016J\u0012\u0010\u001a\u00020X2\b\u0010~\u001a\u0004\u0018\u000102H\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\u001a\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010Z\u001a\u00020[H\u0016J\u001a\u0010\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\u0001\u001a\u00020X2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u001d\u0010\u0001\u001a\u00020X2\t\u0010\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u0001\u001a\u00020\bH\u0016J\u001b\u0010\u0001\u001a\u00020X2\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\bH\u0016J\u001e\u0010\u0001\u001a\u00020X2\t\u0010\u0001\u001a\u0004\u0018\u00010#2\b\u0010\u0001\u001a\u00030\u0001H\u0016J,\u0010\u0001\u001a\u00020X2\t\u0010\u0001\u001a\u0004\u0018\u00010#2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\u0013\u0010\u0001\u001a\u00020X2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J3\u0010\u0001\u001a\u00020X2\u0006\u0010s\u001a\u00020\b2\u0010\u0010\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020b0\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00020X2\b\u0010~\u001a\u0004\u0018\u000102H\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\u0014\u0010\u0001\u001a\u00020X2\t\u0010 \u0001\u001a\u0004\u0018\u000102H\u0016J\t\u0010¡\u0001\u001a\u00020XH\u0016J'\u0010¢\u0001\u001a\u00020X2\t\u0010£\u0001\u001a\u0004\u0018\u00010v2\u0006\u0010s\u001a\u00020\b2\t\u0010¤\u0001\u001a\u0004\u0018\u000102H\u0016J\t\u0010¥\u0001\u001a\u00020XH\u0016J\t\u0010¦\u0001\u001a\u00020XH\u0002J\u0007\u0010§\u0001\u001a\u00020XJ(\u0010¨\u0001\u001a\u00020X2\t\b\u0002\u0010©\u0001\u001a\u00020!2\t\b\u0002\u0010ª\u0001\u001a\u00020!2\t\b\u0002\u0010«\u0001\u001a\u00020!J\u0010\u0010¬\u0001\u001a\u00020X2\u0007\u0010©\u0001\u001a\u00020!J\u0007\u0010­\u0001\u001a\u00020XJ\t\u0010®\u0001\u001a\u00020XH\u0016J\u0012\u0010¯\u0001\u001a\u00020X2\u0007\u0010°\u0001\u001a\u00020!H\u0016J\u0010\u0010±\u0001\u001a\u00020X2\u0007\u0010²\u0001\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\n\"\u0004\bG\u0010\fR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000¨\u0006µ\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionEnterType", "", "getActionEnterType", "()I", "setActionEnterType", "(I)V", "actionExitType", "getActionExitType", "setActionExitType", "callback", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "getCallback", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "setCallback", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;)V", "currentTabIndex", "delayHideDynamicBgRunnable", "Ljava/lang/Runnable;", "dynamicBgContainer", "Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "gradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "homeTabChangedListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1;", "isDynamicBgShow", "", "launcherContainer", "Landroid/view/View;", "getLauncherContainer", "()Landroid/view/View;", "setLauncherContainer", "(Landroid/view/View;)V", "mOriention", "getMOriention", "setMOriention", "multiTaskIcon", "Landroid/widget/ImageView;", "getMultiTaskIcon", "()Landroid/widget/ImageView;", "setMultiTaskIcon", "(Landroid/widget/ImageView;)V", "onCreateInstanceState", "Landroid/os/Bundle;", "panelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "getPanelView", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "setPanelView", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;)V", "parentPanelLayoutWrapper", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "getParentPanelLayoutWrapper", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "setParentPanelLayoutWrapper", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "parentViewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getParentViewPager", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setParentViewPager", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "playSound", "getPlaySound", "setPlaySound", "realPanelView", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowLoading", "checkShowSnapshotIfNeed", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "size", "forceHide", "forceShow", "checkTeenMode", "multiTaskType", "createMultiTaskPanelView", "createPanelView", "delayHideDynamicBg", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "enableExpand", "enableScroll", "enable", "enterFullScreenMode", "exitFullScreenMode", "getMultiTaskItemPosition", "", "id", "curPos", "way", "hasCurrentMultiInfo", "hideDynamicBg", "hideSnapshotUIC", "remove", "inMultiTaskPanel", "initEnterReport", "initExitReport", "isDataEmpty", "isShowSnapshotUIC", "jumpSnapshotUIC", "markWechatForeground", "foreground", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "onKeyUp", "onMultiTaskPageSelected", "position", "onPanelItemSelected", "panel", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPause", "onPlaySound", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "requestOrientation", "saveHomeSnapBlt", "showHome", "smoothScroll", "fromClick", "fromSwipe", "showPanel", "showSnapshotUIC", "switchToDynamicBg", "switchToStaticBg", "delay", "updateLoadingMode", "loadingMode", "Companion", "MultiTaskCallback", "ui-multitask_release"})
public final class MultiTaskUIC extends UIComponent implements PluginMultiTask.b, b.AbstractC1522b {
    private static int AfR = 0;
    private static int AfS = 0;
    private static int AfT = 0;
    private static int AfU = 0;
    private static int AfV = 0;
    private static int AfW = 0;
    private static int AfX = 0;
    private static int AfY = 0;
    private static int AfZ = 0;
    private static int Aga = 0;
    private static int Agb = 0;
    private static int Agc = 0;
    private static int Agd = 0;
    private static int Age = 0;
    private static int Agf = 0;
    private static int Agg = 0;
    private static int Agh = 0;
    private static int Agi = 0;
    private static int Agj = 0;
    private static int Agk = 0;
    private static int Agl = 0;
    private static float Agm = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
    private static float Agn = 1.3333334f;
    public static final a Ago = new a((byte) 0);
    public static final String TAG = TAG;
    private static int kn;
    private static int mEX;
    private static int mEY;
    private static int qmd;
    private static float scale = 1.6666666f;
    private GradientColorBackgroundView AdB;
    private Bundle AeI;
    public CustomViewPager AfB;
    public com.tencent.mm.plugin.multitask.ui.base.b AfC;
    private View AfD;
    public com.tencent.mm.plugin.multitask.ui.panel.b AfE;
    private ImageView AfF;
    public int AfG = 4;
    private int AfH = 4;
    private b AfI;
    private int AfJ;
    private int AfK;
    private int AfL;
    public MultiTaskContainerView AfM;
    private DynamicBgContainer AfN;
    private final e AfO = new e(this);
    private Runnable AfP;
    private boolean AfQ;
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$MultiTaskCallback;", "", "getCurrentTabIndex", "", "isHeaderOpen", "", "multiTaskStateChanged", "", "state", "curIndex", "multiTaskTabChanged", "ui-multitask_release"})
    public interface b {
        void awZ(int i2);

        void axa(int i2);

        boolean esy();

        int getCurrentTabIndex();
    }

    public static final /* synthetic */ void b(MultiTaskUIC multiTaskUIC) {
        AppMethodBeat.i(236695);
        multiTaskUIC.erP();
        AppMethodBeat.o(236695);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236693);
        AppMethodBeat.o(236693);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$homeTabChangedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "ui-multitask_release"})
    public static final class e extends IListener<kt> {
        final /* synthetic */ MultiTaskUIC Agq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(MultiTaskUIC multiTaskUIC) {
            this.Agq = multiTaskUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kt ktVar) {
            kt.a aVar;
            AppMethodBeat.i(236647);
            kt ktVar2 = ktVar;
            if (!(ktVar2 == null || (aVar = ktVar2.dPO) == null)) {
                this.Agq.AfK = aVar.currentIndex;
                if (this.Agq.AfK == 0) {
                    this.Agq.hx(true);
                } else {
                    this.Agq.hx(false);
                }
            }
            AppMethodBeat.o(236647);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\bG\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010a\u001a\u00020bJ\u0016\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001a\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR\u001a\u0010C\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001a\u0010I\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001a\u0010L\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001a\u0010O\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001a\u0010R\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001c\"\u0004\bT\u0010\u001eR\u001a\u0010U\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001a\u0010X\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001a\u0010[\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001a\u0010^\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\b¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$Companion;", "", "()V", "HOME_EXPOSE_WIDTH", "", "getHOME_EXPOSE_WIDTH", "()I", "setHOME_EXPOSE_WIDTH", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_2A", "get_2A", "set_2A", "_2_5A", "get_2_5A", "set_2_5A", "canvasHeight", "getCanvasHeight", "setCanvasHeight", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "font_size", "", "getFont_size", "()F", "setFont_size", "(F)V", "image_scale", "getImage_scale", "setImage_scale", "itemButtomPadding", "getItemButtomPadding", "setItemButtomPadding", "itemHeaderHeight", "getItemHeaderHeight", "setItemHeaderHeight", "itemHeight", "getItemHeight", "setItemHeight", "itemHoritonalPadding", "getItemHoritonalPadding", "setItemHoritonalPadding", "itemImgHeight", "getItemImgHeight", "setItemImgHeight", "itemImgWidth", "getItemImgWidth", "setItemImgWidth", "itemTitleHeight", "getItemTitleHeight", "setItemTitleHeight", "itemWidth", "getItemWidth", "setItemWidth", "oneItemContentHeight", "getOneItemContentHeight", "setOneItemContentHeight", "oneItemContentWidth", "getOneItemContentWidth", "setOneItemContentWidth", "oneItemFromLeft", "getOneItemFromLeft", "setOneItemFromLeft", "oneItemFromTop", "getOneItemFromTop", "setOneItemFromTop", "oneItemImgHeight", "getOneItemImgHeight", "setOneItemImgHeight", "oneItemImgWidth", "getOneItemImgWidth", "setOneItemImgWidth", "portraitHeight", "getPortraitHeight", "setPortraitHeight", "portraitWidth", "getPortraitWidth", "setPortraitWidth", "scale", "getScale", "setScale", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "twoItemFromLeft", "getTwoItemFromLeft", "setTwoItemFromLeft", "twoItemFromTop", "getTwoItemFromTop", "setTwoItemFromTop", "initMultiTaskViewParams", "", "screenSizeW", "screenSizeH", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void esx() {
            AppMethodBeat.i(236643);
            hn(com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()), com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
            AppMethodBeat.o(236643);
        }

        public static void hn(int i2, int i3) {
            AppMethodBeat.i(236644);
            b.a aVar = com.tencent.mm.plugin.multitask.ui.base.b.Adg;
            MultiTaskUIC.Agi = com.tencent.mm.plugin.multitask.ui.base.b.Ade;
            MultiTaskUIC.mEX = i2;
            MultiTaskUIC.mEY = i3;
            MultiTaskUIC.AfR = Math.min(MultiTaskUIC.mEX, MultiTaskUIC.mEY);
            MultiTaskUIC.AfS = Math.max(MultiTaskUIC.mEX, MultiTaskUIC.mEY);
            MultiTaskUIC.AfT = (MultiTaskUIC.mEX * 2) - MultiTaskUIC.Agi;
            MultiTaskUIC.AfU = MultiTaskUIC.mEY;
            MultiTaskUIC.AfV = at.fromDPToPix(MMApplicationContext.getContext(), 12);
            MultiTaskUIC.AfW = at.fromDPToPix(MMApplicationContext.getContext(), 14);
            MultiTaskUIC.AfX = at.fromDPToPix(MMApplicationContext.getContext(), 20);
            MultiTaskUIC.Agk = at.fromDPToPix(MMApplicationContext.getContext(), 44);
            MultiTaskUIC.Agj = at.fromDPToPix(MMApplicationContext.getContext(), 32) - MultiTaskUIC.AfV;
            MultiTaskUIC.qmd = kotlin.h.a.cR(((float) ((MultiTaskUIC.AfR - MultiTaskUIC.Agi) - (MultiTaskUIC.AfW * 2))) / 2.0f);
            MultiTaskUIC.Aga = MultiTaskUIC.qmd - MultiTaskUIC.AfV;
            MultiTaskUIC.Agb = kotlin.h.a.cR(((float) MultiTaskUIC.Aga) * MultiTaskUIC.Agn);
            MultiTaskUIC.scale = ((((float) ((MultiTaskUIC.Agb + MultiTaskUIC.AfV) + MultiTaskUIC.Agj)) + (((float) MultiTaskUIC.Agk) * MultiTaskUIC.Agm)) + ((float) at.fromDPToPix(MMApplicationContext.getContext(), 16))) / ((float) MultiTaskUIC.qmd);
            MultiTaskUIC.kn = kotlin.h.a.cR(((float) MultiTaskUIC.qmd) * MultiTaskUIC.scale);
            MultiTaskUIC.AfY = kotlin.h.a.cR(((float) MultiTaskUIC.qmd) * 1.5f);
            MultiTaskUIC.AfZ = kotlin.h.a.cR(((float) MultiTaskUIC.AfY) * MultiTaskUIC.scale);
            MultiTaskUIC.Agc = MultiTaskUIC.AfY - MultiTaskUIC.AfV;
            MultiTaskUIC.Agd = kotlin.h.a.cR(((float) MultiTaskUIC.Agc) * MultiTaskUIC.Agn);
            MultiTaskUIC.Age = kotlin.h.a.K(((double) ((MultiTaskUIC.AfS - MultiTaskUIC.AfZ) - (MultiTaskUIC.AfV * 6))) / 2.0d);
            MultiTaskUIC.Agf = kotlin.h.a.K((((double) ((MultiTaskUIC.AfR - MultiTaskUIC.Agi) - MultiTaskUIC.AfY)) / 2.0d) - ((double) MultiTaskUIC.AfW));
            MultiTaskUIC.Agg = 0;
            MultiTaskUIC.Agh = kotlin.h.a.K(((double) ((MultiTaskUIC.AfS - MultiTaskUIC.kn) - (MultiTaskUIC.AfV * 8))) / 2.0d);
            Log.i(MultiTaskUIC.TAG, "initMultiTaskViewParams width:" + MultiTaskUIC.qmd + " height:" + MultiTaskUIC.kn + " oneItemContentWidth:" + MultiTaskUIC.AfY + " oneItemContentHeight:" + MultiTaskUIC.AfZ);
            AppMethodBeat.o(236644);
        }
    }

    static {
        AppMethodBeat.i(236694);
        AppMethodBeat.o(236694);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void hm(int i2, int i3) {
        AppMethodBeat.i(236649);
        a.hn(i2, i3);
        AppMethodBeat.o(236649);
    }

    public final View a(View view, DynamicBgContainer dynamicBgContainer, b bVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        View customView;
        View view2 = null;
        AppMethodBeat.i(236650);
        p.h(view, "launcherContainer");
        Log.i(TAG, "create panel launcher");
        this.AfD = view;
        this.AfN = dynamicBgContainer;
        this.AdB = dynamicBgContainer.getGradientBgView();
        DynamicBgContainer dynamicBgContainer2 = this.AfN;
        if (dynamicBgContainer2 != null) {
            dynamicBgContainer2.erv();
        }
        this.AfI = bVar;
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        this.AfF = (supportActionBar == null || (customView = supportActionBar.getCustomView()) == null) ? null : (ImageView) customView.findViewById(R.id.ei);
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).registerMultiTaskUIC(2, WebMultiTaskUIC.class);
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).registerMultiTaskUIC(0, MultiTaskMinusScreenUIC.class);
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).registerMultiTaskUIC(1, AppBrandMultiTaskUIC.class);
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).registerMultiTaskUIC(1048576, SnapShotMultiTaskUIC.class);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        SecDataUIC gU = SecDataUIC.a.gU(getActivity());
        if (gU != null) {
            gU.a(new com.tencent.mm.plugin.secdata.b(j.listOf((Object[]) new String[]{"WebViewUI", "WebviewMpUI", "FinderLongVideoTimelineUI", "NoteEditorUI", "MiniQBReaderUI", "AppAttachDownloadUI", "ChooseMsgFileShowUI", "TopStoryFSVideoUI", "TopStoryMultiTaskListVideoUI", "LuggageGameWebViewUI"}), crt.class));
        }
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).setListener(this);
        if (this.AfC == null) {
            com.tencent.mm.plugin.multitask.ui.base.b bVar2 = new com.tencent.mm.plugin.multitask.ui.base.b(getActivity());
            bVar2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Log.i(TAG, "create panel view");
            a.esx();
            if (this.AfE == null) {
                this.AfE = new com.tencent.mm.plugin.multitask.ui.panel.b(getActivity(), this.AeI);
            }
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.bdm, (ViewGroup) null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                AppMethodBeat.o(236650);
                throw tVar;
            }
            FrameLayout frameLayout = (FrameLayout) inflate;
            View findViewById = frameLayout.findViewById(R.id.fpn);
            if (findViewById == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView");
                AppMethodBeat.o(236650);
                throw tVar2;
            }
            this.AfM = (MultiTaskContainerView) findViewById;
            frameLayout.setDrawingCacheEnabled(false);
            com.tencent.mm.plugin.multitask.ui.panel.b bVar3 = this.AfE;
            if (bVar3 != null) {
                if (bVar3.AeF == null) {
                    View inflate2 = bVar3.tUQ.getLayoutInflater().inflate(R.layout.bdn, (ViewGroup) null);
                    bVar3.AeE = (MultiTaskPanelContainer) inflate2.findViewById(R.id.fnj);
                    MultiTaskPanelContainer multiTaskPanelContainer = bVar3.AeE;
                    if (multiTaskPanelContainer != null) {
                        bVar3.a(multiTaskPanelContainer);
                    }
                    bVar3.AeF = inflate2;
                }
                view2 = bVar3.AeF;
            }
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = frameLayout;
            if (frameLayout2 != null) {
                com.tencent.mm.plugin.multitask.f.c cVar = com.tencent.mm.plugin.multitask.f.c.AgL;
                float esE = com.tencent.mm.plugin.multitask.f.c.esE();
                Log.i(TAG, "slideFractor: ".concat(String.valueOf(esE)));
                int i2 = (int) (esE * ((float) (mEX - Agi)));
                frameLayout2.setPadding(0, 0, i2, 0);
                if (!(frameLayout2 == null || view == null)) {
                    bVar2.addView(view, 0, new ViewGroup.LayoutParams(-1, -1));
                    bVar2.addView(frameLayout2, 1, new ViewGroup.LayoutParams(-1, -1));
                }
                Interpolator loadInterpolator = AnimationUtils.loadInterpolator(bVar2.getContext(), R.anim.co);
                c.b bVar4 = com.tencent.mm.plugin.multitask.animation.c.a.c.Aaz;
                p.g(loadInterpolator, "interpolator");
                bVar2.AaG = c.b.a(bVar2, new b.d(), loadInterpolator);
                Context context = bVar2.getContext();
                float density = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? com.tencent.mm.cb.a.getDensity(bVar2.getContext()) : displayMetrics.density;
                float f2 = 100.0f * density;
                float f3 = density * 300.0f;
                com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = bVar2.AaG;
                if (cVar2 != null) {
                    cVar2.Aau = f2;
                }
                com.tencent.mm.plugin.multitask.animation.c.a.c cVar3 = bVar2.AaG;
                if (cVar3 != null) {
                    cVar3.Aat = f3;
                }
                Object systemService = bVar2.getContext().getSystemService("vibrator");
                if (systemService == null) {
                    t tVar3 = new t("null cannot be cast to non-null type android.os.Vibrator");
                    AppMethodBeat.o(236650);
                    throw tVar3;
                }
                bVar2.ooM = (Vibrator) systemService;
                bVar2.setSlideLeft(false);
                bVar2.setPanelWidth(mEX);
                bVar2.setPanelExpose(Agi);
                bVar2.setExtraSlideRange(i2);
                if (ao.isDarkMode()) {
                    bVar2.setCoveredFadeColor(5066061);
                } else {
                    bVar2.setCoveredFadeColor(3618127);
                }
                bVar2.setOverlayed(true);
                MultiTaskUIC multiTaskUIC = this;
                synchronized (bVar2.AcI) {
                    try {
                        bVar2.AcI.add(multiTaskUIC);
                    } catch (Throwable th) {
                        AppMethodBeat.o(236650);
                        throw th;
                    }
                }
                bVar2.setFadeOnClickListener(new c(bVar2, this, view));
            }
            bVar2.setCurrentItem(1, false);
            this.AfC = bVar2;
        }
        com.tencent.mm.plugin.multitask.ui.base.b bVar5 = this.AfC;
        AppMethodBeat.o(236650);
        return bVar5;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$1$1$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "ui-multitask_release", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$$special$$inlined$let$lambda$1"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.multitask.ui.base.b Agp;
        final /* synthetic */ MultiTaskUIC Agq;
        final /* synthetic */ View Agr;

        c(com.tencent.mm.plugin.multitask.ui.base.b bVar, MultiTaskUIC multiTaskUIC, View view) {
            this.Agp = bVar;
            this.Agq = multiTaskUIC;
            this.Agr = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(236645);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Agq.m(true, true, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$createMultiTaskPanelView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(236645);
        }
    }

    public final boolean erO() {
        AppMethodBeat.i(236651);
        com.tencent.mm.plugin.multitask.ui.base.b bVar = this.AfC;
        if (bVar == null || bVar.getCurItem() != 0) {
            AppMethodBeat.o(236651);
            return false;
        }
        AppMethodBeat.o(236651);
        return true;
    }

    private final void erP() {
        AppMethodBeat.i(236652);
        if (!erO()) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
            p.g(sharedPreferences, "activity.getSharedPrefer…faultPreferencePath(), 0)");
            Log.i(TAG, "set ScreenOrientation，now is ： %s", Boolean.valueOf(sharedPreferences.getBoolean("settings_landscape_mode", false)));
            if (sharedPreferences.getBoolean("settings_landscape_mode", false)) {
                getActivity().setRequestedOrientation(-1);
                AppMethodBeat.o(236652);
                return;
            }
            getActivity().setRequestedOrientation(1);
            AppMethodBeat.o(236652);
            return;
        }
        getActivity().setRequestedOrientation(1);
        AppMethodBeat.o(236652);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final boolean eru() {
        AppMethodBeat.i(236653);
        if (!isDataEmpty() || erO()) {
            AppMethodBeat.o(236653);
            return true;
        }
        Log.d(TAG, "needExpand, false!");
        AppMethodBeat.o(236653);
        return false;
    }

    private boolean erQ() {
        AppMethodBeat.i(236654);
        if (!erO()) {
            AppMethodBeat.o(236654);
            return true;
        }
        AppMethodBeat.o(236654);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void ert() {
        AppMethodBeat.i(236655);
        this.AfL++;
        Log.d(TAG, "playsound count: %d", Integer.valueOf(this.AfL));
        AppMethodBeat.o(236655);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void bB(float f2) {
        AppMethodBeat.i(236656);
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent aGP = bVar.aGP(com.tencent.mm.plugin.multitask.g.eqx());
            if (aGP != null) {
                if (aGP instanceof SnapShotMultiTaskUIC) {
                    SnapShotMultiTaskUIC snapShotMultiTaskUIC = (SnapShotMultiTaskUIC) aGP;
                    if (snapShotMultiTaskUIC.bJw()) {
                        int i2 = Agi;
                        com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
                        float esC = 1.0f - (((float) (i2 + com.tencent.mm.plugin.multitask.f.a.esC())) / ((float) snapShotMultiTaskUIC.getRootView().getWidth()));
                        float f3 = 0.0f;
                        if (f2 >= esC) {
                            f3 = (f2 - esC) / (1.0f - esC);
                        }
                        int i3 = Agi;
                        com.tencent.mm.plugin.multitask.f.a aVar2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
                        int i4 = Agi;
                        com.tencent.mm.plugin.multitask.f.a aVar3 = com.tencent.mm.plugin.multitask.f.a.AgJ;
                        snapShotMultiTaskUIC.getRootView().setTranslationX(((float) (-(i3 + com.tencent.mm.plugin.multitask.f.a.esC()))) + (((float) (i4 + com.tencent.mm.plugin.multitask.f.a.esC())) * f3));
                        Log.d("MicroMsg.SnapShotMultiTaskUIC", "onPanelSlide, factor: %f", Float.valueOf(f3));
                    }
                    AppMethodBeat.o(236656);
                    return;
                }
                AppMethodBeat.o(236656);
                return;
            }
        }
        AppMethodBeat.o(236656);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void bC(float f2) {
        MultiTaskContainerView multiTaskContainerView;
        float f3;
        float f4 = 0.0f;
        AppMethodBeat.i(236657);
        MultiTaskContainerView multiTaskContainerView2 = this.AfM;
        if (multiTaskContainerView2 != null) {
            float width = ((float) multiTaskContainerView2.getWidth()) * 0.18f;
            float width2 = ((float) (multiTaskContainerView2.getWidth() - Agi)) * f2;
            if (width2 < width) {
                float f5 = width2 / width;
                f3 = 1.0f - (f5 * f5);
            } else {
                f3 = 0.0f;
            }
            ImageView imageView = this.AfF;
            if (imageView != null) {
                if (f3 >= 0.0f) {
                    f4 = f3 > 1.0f ? 1.0f : f3;
                }
                imageView.setAlpha(f4);
            }
        }
        if (!erQ() || (multiTaskContainerView = this.AfM) == null) {
            AppMethodBeat.o(236657);
            return;
        }
        multiTaskContainerView.Vm = f2;
        multiTaskContainerView.invalidate();
        AppMethodBeat.o(236657);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void ers() {
        AppMethodBeat.i(236658);
        MultiTaskContainerView multiTaskContainerView = this.AfM;
        if (multiTaskContainerView != null) {
            multiTaskContainerView.RT(0);
            AppMethodBeat.o(236658);
            return;
        }
        AppMethodBeat.o(236658);
    }

    @Override // com.tencent.mm.plugin.multitask.PluginMultiTask.b
    public final boolean isDataEmpty() {
        AppMethodBeat.i(236659);
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (bK != null) {
                if (bK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                    AppMethodBeat.o(236659);
                    throw tVar;
                }
                boolean isDataEmpty = ((MultiTaskMinusScreenUIC) bK).isDataEmpty();
                AppMethodBeat.o(236659);
                return isDataEmpty;
            }
        }
        AppMethodBeat.o(236659);
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void err() {
        MultiTaskContainerView multiTaskContainerView;
        AppMethodBeat.i(236660);
        if (!erQ() && (multiTaskContainerView = this.AfM) != null) {
            multiTaskContainerView.RT(0);
        }
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (bK != null) {
                if (bK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                    AppMethodBeat.o(236660);
                    throw tVar;
                }
                ((MultiTaskMinusScreenUIC) bK).erM();
                AppMethodBeat.o(236660);
                return;
            }
        }
        AppMethodBeat.o(236660);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    public final void a(b.c cVar, b.c cVar2) {
        ImageView imageView;
        AppMethodBeat.i(236661);
        Log.d(TAG, "onPanelStateChanged, previousState:" + cVar + ", newState:" + cVar2);
        if (cVar2 != cVar && cVar2 == b.c.DRAGGING) {
            if (!erO() && !erU() && cVar == b.c.COLLAPSED) {
                erT();
            }
            b bVar = this.AfI;
            if (bVar != null) {
                bVar.axa(erO() ? 0 : 1);
            }
        }
        if (cVar2 != cVar && cVar2 == b.c.COLLAPSED) {
            DynamicBgContainer dynamicBgContainer = this.AfN;
            if (dynamicBgContainer != null) {
                dynamicBgContainer.erv();
            }
            erR();
        } else if (cVar2 != cVar) {
            b.c cVar3 = b.c.EXPANDED;
        }
        if (cVar2 == b.c.COLLAPSED && !isDataEmpty()) {
            ImageView imageView2 = this.AfF;
            if (imageView2 != null) {
                imageView2.setAlpha(1.0f);
                AppMethodBeat.o(236661);
                return;
            }
            AppMethodBeat.o(236661);
        } else if (cVar2 != b.c.EXPANDED || (imageView = this.AfF) == null) {
            AppMethodBeat.o(236661);
        } else {
            imageView.setAlpha(0.0f);
            AppMethodBeat.o(236661);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x02db  */
    @Override // com.tencent.mm.plugin.multitask.ui.base.b.AbstractC1522b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void RQ(int r11) {
        /*
        // Method dump skipped, instructions count: 1062
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.RQ(int):void");
    }

    private void erR() {
        AppMethodBeat.i(236663);
        if (!this.AfQ) {
            AppMethodBeat.o(236663);
            return;
        }
        Log.i(TAG, "virbg: switchToStaticBg");
        this.AfQ = false;
        if (this.AfN != null && !DynamicBgContainer.erw()) {
            GradientColorBackgroundView gradientColorBackgroundView = this.AdB;
            if (gradientColorBackgroundView != null) {
                gradientColorBackgroundView.setVisibility(0);
            }
            GradientColorBackgroundView gradientColorBackgroundView2 = this.AdB;
            if (gradientColorBackgroundView2 != null) {
                gradientColorBackgroundView2.setAlpha(1.0f);
            }
        }
        erS();
        AppMethodBeat.o(236663);
    }

    private final void erS() {
        AppMethodBeat.i(236664);
        DynamicBgContainer dynamicBgContainer = this.AfN;
        if (dynamicBgContainer != null) {
            dynamicBgContainer.ery();
            AppMethodBeat.o(236664);
            return;
        }
        AppMethodBeat.o(236664);
    }

    public final void erT() {
        AppMethodBeat.i(236665);
        if (this.AfQ || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitask_minimize_disable_dynamic_bg, 0) == 1) {
            AppMethodBeat.o(236665);
            return;
        }
        Log.i(TAG, "virbg: switchToDynamicBg");
        this.AfQ = true;
        if (this.AfP != null) {
            this.hAk.removeCallbacks(this.AfP);
            this.AfP = null;
        }
        DynamicBgContainer dynamicBgContainer = this.AfN;
        if (dynamicBgContainer != null) {
            dynamicBgContainer.erz();
            AppMethodBeat.o(236665);
            return;
        }
        AppMethodBeat.o(236665);
    }

    @Override // com.tencent.mm.plugin.multitask.PluginMultiTask.b
    public final String getMultiTaskItemPosition(String str, int i2, int i3) {
        RecyclerView.v vVar;
        View view;
        RecyclerView.v ch;
        View view2;
        View view3 = null;
        AppMethodBeat.i(236666);
        p.h(str, "id");
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (bK != null) {
                if (bK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                    AppMethodBeat.o(236666);
                    throw tVar;
                }
                MultiTaskMinusScreenUIC multiTaskMinusScreenUIC = (MultiTaskMinusScreenUIC) bK;
                p.h(str, "id");
                int aGQ = multiTaskMinusScreenUIC.aGQ(str);
                if (i2 == aGQ || aGQ < 0 || aGQ >= multiTaskMinusScreenUIC.Afn.size()) {
                    AppMethodBeat.o(236666);
                    return "";
                }
                if (i3 != 4) {
                    WxRecyclerView wxRecyclerView = multiTaskMinusScreenUIC.ufR;
                    if (wxRecyclerView != null) {
                        vVar = wxRecyclerView.ch(aGQ + 1);
                    } else {
                        vVar = null;
                    }
                    if (vVar != null) {
                        view3 = vVar.aus;
                    }
                    view = view3;
                } else if (multiTaskMinusScreenUIC.Afn.size() <= 2) {
                    WxRecyclerView wxRecyclerView2 = multiTaskMinusScreenUIC.ufR;
                    view = (wxRecyclerView2 == null || (ch = wxRecyclerView2.ch(1)) == null || (view2 = ch.aus) == null) ? null : view2.findViewById(R.id.fnq);
                } else {
                    view3 = multiTaskMinusScreenUIC.getRootView().findViewById(R.id.fnm);
                    view = view3;
                }
                com.tencent.mm.plugin.multitask.f.c cVar = com.tencent.mm.plugin.multitask.f.c.AgL;
                String ey = com.tencent.mm.plugin.multitask.f.c.ey(view);
                AppMethodBeat.o(236666);
                return ey;
            }
        }
        AppMethodBeat.o(236666);
        return "";
    }

    @Override // com.tencent.mm.plugin.multitask.PluginMultiTask.b
    public final boolean aGK(String str) {
        boolean z;
        AppMethodBeat.i(236667);
        p.h(str, "id");
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (bK != null) {
                if (bK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                    AppMethodBeat.o(236667);
                    throw tVar;
                }
                p.h(str, "id");
                Iterator<T> it = ((MultiTaskMinusScreenUIC) bK).Afn.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    T next = it.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    if (next.Aen.field_id.equals(str)) {
                        z = true;
                        break;
                    }
                    i2 = i3;
                }
                Log.i(TAG, "hasCurrentMultiInfo, id:%s, ret:%b", str, Boolean.valueOf(z));
                AppMethodBeat.o(236667);
                return z;
            }
        }
        z = false;
        Log.i(TAG, "hasCurrentMultiInfo, id:%s, ret:%b", str, Boolean.valueOf(z));
        AppMethodBeat.o(236667);
        return z;
    }

    public static /* synthetic */ void a(MultiTaskUIC multiTaskUIC) {
        AppMethodBeat.i(236669);
        multiTaskUIC.m(true, false, false);
        AppMethodBeat.o(236669);
    }

    public final void m(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(236668);
        Log.i(TAG, "showHome, smoothScrool:" + z + ", fromClick:" + z2 + ", fromSwipe:" + z2);
        if (z2) {
            this.AfH = 2;
        } else if (z3) {
            this.AfH = 1;
        } else {
            this.AfH = 3;
        }
        GradientColorBackgroundView gradientColorBackgroundView = this.AdB;
        if (gradientColorBackgroundView != null) {
            gradientColorBackgroundView.setVisibility(0);
        }
        GradientColorBackgroundView gradientColorBackgroundView2 = this.AdB;
        if (gradientColorBackgroundView2 != null) {
            gradientColorBackgroundView2.setAlpha(1.0f);
        }
        com.tencent.mm.plugin.multitask.ui.base.b bVar = this.AfC;
        if (bVar != null) {
            bVar.setCurrentItem(1, z);
        }
        if (!z) {
            erV();
        }
        AppMethodBeat.o(236668);
    }

    public final void RT(int i2) {
        AppMethodBeat.i(236670);
        Log.i(TAG, "updateLoadingMode, loadingMode:".concat(String.valueOf(i2)));
        MultiTaskContainerView multiTaskContainerView = this.AfM;
        if (multiTaskContainerView != null) {
            multiTaskContainerView.RT(i2);
            AppMethodBeat.o(236670);
            return;
        }
        AppMethodBeat.o(236670);
    }

    public final void hx(boolean z) {
        boolean z2;
        AppMethodBeat.i(236671);
        com.tencent.mm.plugin.multitask.ui.base.b bVar = this.AfC;
        if (bVar != null) {
            boolean canSlide = bVar.getCanSlide();
            Log.i(TAG, "enableScroll: " + z + ", canSlide:" + canSlide + ", orientation:" + this.AfJ + ", currentTabIndex:" + this.AfK);
            if ((this.AfJ == 2 || isDataEmpty() || this.AfK != 0) && !erO()) {
                Log.i(TAG, "enableScroll false, isDataEmpty: " + isDataEmpty());
                z2 = false;
            } else {
                z2 = z;
            }
            if (erU() && erO()) {
                Log.i(TAG, "enableScroll false, showSnapshot Already");
                z2 = false;
            }
            b bVar2 = this.AfI;
            if (bVar2 != null && bVar2.esy()) {
                Log.i(TAG, "enableScroll false, isHeaderOpen");
                z2 = false;
            }
            if (canSlide == z) {
                AppMethodBeat.o(236671);
                return;
            }
            bVar.setCanSlide(z2);
            AppMethodBeat.o(236671);
            return;
        }
        AppMethodBeat.o(236671);
    }

    public final void l(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(236672);
        p.h(multiTaskInfo, "taskInfo");
        erW();
        erR();
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_MULTITASK_LAST_SHOW_ID_AND_TIME_STRING_SYNC, multiTaskInfo.field_id + "|" + cl.aWA());
        Log.i(TAG, "enterFullScreenMode, id:" + multiTaskInfo.field_id);
        AppMethodBeat.o(236672);
    }

    public final boolean erU() {
        AppMethodBeat.i(236673);
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(1048576, com.tencent.mm.plugin.multitask.g.eqx());
            if (bK != null) {
                if (bK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
                    AppMethodBeat.o(236673);
                    throw tVar;
                }
                boolean bJw = ((SnapShotMultiTaskUIC) bK).bJw();
                AppMethodBeat.o(236673);
                return bJw;
            }
        }
        AppMethodBeat.o(236673);
        return false;
    }

    private void erV() {
        AppMethodBeat.i(236674);
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent aGP = bVar.aGP(com.tencent.mm.plugin.multitask.g.eqx());
            if (aGP != null) {
                com.tencent.mm.plugin.multitask.ui.panel.b bVar2 = this.AfE;
                if (bVar2 != null) {
                    com.tencent.mm.plugin.multitask.g gVar2 = com.tencent.mm.plugin.multitask.g.zZj;
                    MultiTaskUIComponent bK = bVar2.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
                    if (bK != null) {
                        if (bK == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                            AppMethodBeat.o(236674);
                            throw tVar;
                        }
                        MultiTaskMinusScreenUIC multiTaskMinusScreenUIC = (MultiTaskMinusScreenUIC) bK;
                        if (aGP == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
                            AppMethodBeat.o(236674);
                            throw tVar2;
                        } else if (MultiTaskMinusScreenUIC.a(multiTaskMinusScreenUIC, ((SnapShotMultiTaskUIC) aGP).Agu, false)) {
                            ((SnapShotMultiTaskUIC) aGP).erV();
                        } else {
                            sk(false);
                        }
                    }
                }
                if (aGP == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC");
                    AppMethodBeat.o(236674);
                    throw tVar3;
                }
                ((SnapShotMultiTaskUIC) aGP).esA();
                hx(true);
                AppMethodBeat.o(236674);
                return;
            }
        }
        sk(false);
        AppMethodBeat.o(236674);
    }

    public final void sk(boolean z) {
        AppMethodBeat.i(236675);
        Log.i(TAG, "hideSnapshotUIC, remove:".concat(String.valueOf(z)));
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(1048576, com.tencent.mm.plugin.multitask.g.eqx());
            if (bK != null) {
                if (bK instanceof SnapShotMultiTaskUIC) {
                    ((SnapShotMultiTaskUIC) bK).esB();
                    ((SnapShotMultiTaskUIC) bK).esA();
                    if (z) {
                        h.RTc.aV(new d(this, z));
                    }
                }
                AppMethodBeat.o(236675);
                return;
            }
        }
        AppMethodBeat.o(236675);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskUIC$hideSnapshotUIC$1$1"})
    public static final class d implements Runnable {
        final /* synthetic */ MultiTaskUIC Agq;
        final /* synthetic */ boolean Ags;

        d(MultiTaskUIC multiTaskUIC, boolean z) {
            this.Agq = multiTaskUIC;
            this.Ags = z;
        }

        public final void run() {
            AppMethodBeat.i(236646);
            com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.Agq.AfE;
            if (bVar != null) {
                com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
                bVar.aGO(com.tencent.mm.plugin.multitask.g.eqx());
            }
            this.Agq.hx(true);
            AppMethodBeat.o(236646);
        }
    }

    private void erW() {
        AppMethodBeat.i(236676);
        try {
            View view = this.AfD;
            if (view != null) {
                Bitmap a2 = com.tencent.mm.ui.n.a.a(this.AfD, view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                if (a2 != null) {
                    com.tencent.mm.plugin.multitask.h hVar = com.tencent.mm.plugin.multitask.h.zZn;
                    String eqA = com.tencent.mm.plugin.multitask.h.eqA();
                    if (s.YS(eqA)) {
                        s.deleteFile(eqA);
                    }
                    BitmapUtil.saveBitmapToImage(a2, 100, Bitmap.CompressFormat.JPEG, eqA, true);
                }
                AppMethodBeat.o(236676);
                return;
            }
            AppMethodBeat.o(236676);
        } catch (Throwable th) {
            Log.e(TAG, "snapshot bitmap failed", th);
            AppMethodBeat.o(236676);
        }
    }

    public static boolean RU(int i2) {
        AppMethodBeat.i(236677);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
        com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
        int fvp = ((com.tencent.mm.plugin.teenmode.a.b) af2).fvp();
        com.tencent.mm.kernel.c.a af3 = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af3, "MMKernel.service(ITeenModeService::class.java)");
        int fvo = ((com.tencent.mm.plugin.teenmode.a.b) af3).fvo();
        com.tencent.mm.kernel.c.a af4 = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af4, "MMKernel.service(ITeenModeService::class.java)");
        int dxW = ((com.tencent.mm.plugin.teenmode.a.b) af4).dxW();
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onTeenModeDataChanged isTeenMode: %b, miniProgramOption: %d, bizAcctOption: %d, finderOption: %d", Boolean.valueOf(Vt), Integer.valueOf(fvp), Integer.valueOf(fvo), Integer.valueOf(dxW));
        if (!Vt || !((fvp == 2 && i2 == 1) || ((fvo == 2 && i2 == 2) || (dxW == 2 && i2 == 22)))) {
            AppMethodBeat.o(236677);
            return false;
        }
        AppMethodBeat.o(236677);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
        AppMethodBeat.i(236678);
        Log.i(TAG, "onCreateBefore");
        this.AeI = bundle;
        AppMethodBeat.o(236678);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(236679);
        super.onCreate(bundle);
        this.AfO.alive();
        AppMethodBeat.o(236679);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(236680);
        Log.i(TAG, "onSaveInstanceState");
        AppMethodBeat.o(236680);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(236681);
        Log.i(TAG, "onRestoreInstanceState");
        AppMethodBeat.o(236681);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStart() {
        com.tencent.mm.plugin.multitask.ui.panel.b bVar;
        AppMethodBeat.i(236682);
        Log.i(TAG, "onStart, isMultiTaskPanel:%b", Boolean.valueOf(erO()));
        if (!erO() || (bVar = this.AfE) == null) {
            AppMethodBeat.o(236682);
            return;
        }
        bVar.onStart();
        AppMethodBeat.o(236682);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(236683);
        Log.i(TAG, "onResume, isMultiTaskPanel:%b", Boolean.valueOf(erO()));
        if (erO()) {
            com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
            if (bVar != null) {
                bVar.onResume();
            }
            if (this.AfE != null && !erU()) {
                erT();
            }
            com.tencent.mm.plugin.multitask.ui.panel.b bVar2 = this.AfE;
            if (bVar2 != null) {
                com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
                MultiTaskUIComponent bK = bVar2.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
                if (bK != null) {
                    if (bK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                        AppMethodBeat.o(236683);
                        throw tVar;
                    }
                    ((MultiTaskMinusScreenUIC) bK).erK();
                }
            }
            erP();
            AppMethodBeat.o(236683);
            return;
        }
        erV();
        AppMethodBeat.o(236683);
    }

    @Override // com.tencent.mm.plugin.multitask.PluginMultiTask.b
    public final void jK(boolean z) {
        AppMethodBeat.i(236684);
        if (erO()) {
            if (z) {
                SecDataUIC.a aVar = SecDataUIC.CWq;
                crt crt = (crt) SecDataUIC.a.a(getActivity(), 5, crt.class);
                if (crt != null) {
                    crs crs = crt.MwP;
                    if (crs != null) {
                        if (cl.aWA() >= crt.viC) {
                            crs.duration += cl.aWA() - crt.viC;
                        }
                        AppMethodBeat.o(236684);
                        return;
                    }
                    AppMethodBeat.o(236684);
                    return;
                }
                AppMethodBeat.o(236684);
                return;
            }
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            crt crt2 = (crt) SecDataUIC.a.a(getActivity(), 5, crt.class);
            if (crt2 != null) {
                if (crt2.MwP != null && cl.aWA() >= crt2.viC) {
                    crt2.viC = cl.aWA();
                }
                AppMethodBeat.o(236684);
                return;
            }
        }
        AppMethodBeat.o(236684);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(236685);
        Log.i(TAG, "onPause, isMultiTaskPanel:%b", Boolean.valueOf(erO()));
        if (erO()) {
            com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
            if (bVar != null) {
                Log.i(bVar.TAG, "onPause");
            }
            erR();
        }
        AppMethodBeat.o(236685);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
        AppMethodBeat.i(236686);
        Log.i(TAG, "onStop, isMultiTaskPanel:%b", Boolean.valueOf(erO()));
        if (erO()) {
            com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
            if (bVar != null) {
                Log.i(bVar.TAG, "onStop");
            }
            erR();
        }
        AppMethodBeat.o(236686);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(236687);
        Log.i(TAG, "onDestroy, isMultiTaskPanel:%b", Boolean.valueOf(erO()));
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            bVar.onDestroy();
        }
        this.AfO.dead();
        com.tencent.mm.plugin.multitask.ui.base.b bVar2 = this.AfC;
        if (bVar2 != null) {
            MultiTaskUIC multiTaskUIC = this;
            synchronized (bVar2.AcI) {
                try {
                    bVar2.AcI.remove(multiTaskUIC);
                } catch (Throwable th) {
                    AppMethodBeat.o(236687);
                    throw th;
                }
            }
        }
        ((PluginMultiTask) g.ah(PluginMultiTask.class)).setListener(null);
        DynamicBgContainer dynamicBgContainer = this.AfN;
        if (dynamicBgContainer != null) {
            dynamicBgContainer.release();
            AppMethodBeat.o(236687);
            return;
        }
        AppMethodBeat.o(236687);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(236688);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (this.AfE != null) {
            p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            p.h(iArr, "grantResults");
        }
        AppMethodBeat.o(236688);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(236689);
        p.h(configuration, "newConfig");
        a.esx();
        this.AfJ = configuration.orientation;
        if (configuration.orientation != 2 || erO()) {
            hx(true);
        } else {
            hx(false);
        }
        com.tencent.mm.plugin.multitask.ui.panel.b bVar = this.AfE;
        if (bVar != null) {
            p.h(configuration, "newConfig");
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            MultiTaskUIComponent bK = bVar.bK(0, com.tencent.mm.plugin.multitask.g.eqw());
            if (bK == null) {
                AppMethodBeat.o(236689);
            } else if (bK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
                AppMethodBeat.o(236689);
                throw tVar;
            } else {
                ((MultiTaskMinusScreenUIC) bK).onConfigurationChanged(configuration);
                AppMethodBeat.o(236689);
            }
        } else {
            AppMethodBeat.o(236689);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(236690);
        p.h(keyEvent, "event");
        if (this.AfE != null) {
            com.tencent.mm.plugin.multitask.ui.panel.b.e(keyEvent);
        }
        AppMethodBeat.o(236690);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(236691);
        p.h(keyEvent, "event");
        if (this.AfE != null) {
            p.h(keyEvent, "event");
        }
        AppMethodBeat.o(236691);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStartActivityForResult(Intent intent, int i2, Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onBeforeFinish(Intent intent) {
        AppMethodBeat.i(236692);
        Log.i(TAG, "onBeforeFinish");
        AppMethodBeat.o(236692);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTaskUIC Agq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MultiTaskUIC multiTaskUIC) {
            super(0);
            this.Agq = multiTaskUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(236648);
            MultiTaskUIC.b(this.Agq);
            x xVar = x.SXb;
            AppMethodBeat.o(236648);
            return xVar;
        }
    }
}
