package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\b&\u0018\u0000 ­\u00012\u00020\u0001:\u0004¬\u0001­\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ*\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020\u001cH\u0002J\b\u0010X\u001a\u00020RH\u0002J\u000e\u0010Y\u001a\u00020R2\u0006\u0010Z\u001a\u00020!J\u000e\u0010[\u001a\u00020R2\u0006\u0010\\\u001a\u00020\u001aJ\b\u0010]\u001a\u00020\u001cH\u0002J\b\u0010^\u001a\u00020\u001cH\u0002J\b\u0010_\u001a\u00020\u001cH\u0002J\b\u0010`\u001a\u00020RH\u0002J\u0010\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020\tH\u0016J\b\u0010c\u001a\u00020RH\u0002J\b\u0010d\u001a\u00020RH\u0002J0\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\u00182\u0006\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u0018H\u0002J\u0010\u0010k\u001a\u00020R2\b\b\u0002\u0010l\u001a\u00020\tJ\u0010\u0010m\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u001eH&J\b\u0010o\u001a\u00020\tH&J\b\u0010p\u001a\u00020\tH&J\b\u0010q\u001a\u00020\tH\u0002J\u0010\u0010r\u001a\u00020\u00182\u0006\u0010s\u001a\u00020\u0018H\u0002J\u0010\u0010t\u001a\u00020\u00182\u0006\u0010u\u001a\u00020\u0018H\u0002J\u0018\u0010v\u001a\u00020R2\u0006\u0010w\u001a\u00020\u00182\u0006\u0010x\u001a\u00020\u001cH\u0002J\u0018\u0010v\u001a\u00020R2\u0006\u0010s\u001a\u00020\u00182\u0006\u0010u\u001a\u00020\u0018H\u0002J\u0010\u0010y\u001a\u00020R2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010z\u001a\u00020RH\u0002J\b\u0010{\u001a\u00020RH\u0002J\b\u0010|\u001a\u00020RH\u0002J\b\u0010}\u001a\u00020RH\u0002J\b\u0010~\u001a\u00020RH\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\u0006\u0010\u001a\u00020\u001cJ\u0015\u0010\u0001\u001a\u00020R2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\u0015\u0010\u0001\u001a\u00020\u001c2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001b\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0014J\u0007\u0010\u0001\u001a\u00020RJ\u0007\u0010\u0001\u001a\u00020RJ\u0015\u0010\u0001\u001a\u00020\u001c2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020RH\u0002J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u000eJ\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0012J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0014J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0016J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u001cJ\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u001cJ\u000f\u0010\u0001\u001a\u00020R2\u0006\u0010*\u001a\u00020\u001cJ\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u001cJ\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010 \u0001\u001a\u00020\tJ\u0010\u0010¡\u0001\u001a\u00020R2\u0007\u0010¢\u0001\u001a\u00020\u0018J\u0010\u0010£\u0001\u001a\u00020R2\u0007\u0010¤\u0001\u001a\u00020\u001cJ\u0007\u0010¥\u0001\u001a\u00020RJ\b\u0010W\u001a\u00020RH\u0002J\t\u0010¦\u0001\u001a\u00020RH\u0002J\u0011\u0010§\u0001\u001a\u00020R2\u0006\u0010T\u001a\u00020\u0018H\u0002J(\u0010¨\u0001\u001a\u00020R2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u001e2\u0007\u0010ª\u0001\u001a\u00020\t2\t\b\u0002\u0010«\u0001\u001a\u00020\u001cH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u000600R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u000600R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006®\u0001"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "backgroundOpContainer", "Landroid/widget/LinearLayout;", "backgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "backgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "dialog", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableCancelOutSide", "enableScrollRightClose", "enableScrollVertical", "fixedDialogHeight", "fixedDialogHeightRate", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedDialogHeight", "isShowing", "isTouchScrolling", "lastOrientation", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "topExtraHeight", "webViewContainer", "Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "attachWebView", "webView", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFixedWebViewHeight", "dialogHeight", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getCloseButton", "root", "getCloseLayoutHeight", "getLayoutId", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initBackgroundOpView", "initDialogBg", "initMoveOffsetXFactor", "initWebViewHeight", "initWindowVisibleHeight", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "view", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBackgroundOpView", "opView", "setBackgroundTouchListener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setCanceledOnTouchOutside", "cancel", "setEnableDialogScroll", "enableScroll", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-scan_release"})
public abstract class BaseBoxDialogView extends RelativeLayout {
    public static final b CBX = new b((byte) 0);
    private boolean CAL;
    private int CBA;
    private int CBB;
    public boolean CBC;
    private int CBD;
    private int CBE;
    private int CBF;
    private boolean CBG;
    private int CBH;
    private int CBI;
    private float CBJ;
    private float CBK;
    private float CBL;
    private boolean CBM;
    private boolean CBN;
    private boolean CBO;
    private boolean CBP;
    private boolean CBQ;
    private boolean CBS;
    a CBT;
    private a CBU;
    final DecelerateInterpolator CBV;
    int CBW;
    private float CBd;
    private float CBe;
    private float CBf;
    private VelocityTracker CBg;
    e CBh;
    private View CBi;
    View CBj;
    BoxWebViewContainer CBk;
    private View CBl;
    private LinearLayout CBm;
    MMWebView CBn;
    private f CBo;
    private c CBp;
    private d CBq;
    private b CBr;
    private float CBs;
    private float CBt;
    private int CBu;
    private float CBv;
    private float CBw;
    float CBx;
    private int CBy;
    private int CBz;
    final ValueAnimator animator;
    private boolean ddZ;
    boolean isAnimating;
    private int lastOrientation;
    private int mEY;
    private int mStatusBarHeight;
    private int nmS;
    private float onW;
    boolean yPa;

    public abstract View eQ(View view);

    public abstract int getCloseLayoutHeight();

    public abstract int getLayoutId();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$Companion;", "", "()V", "DIALOG_SHOW_ANIMATION_DURATION", "", "DIALOG_SWITCH_ANIMATION_DURATION", "FULL_SCREEN_DRAG_CLOSE_FACTOR", "", "FULL_SCREEN_MOVE_OFFSET_Y_FACTOR", "HALF_SCREEN_DRAG_CLOSE_FACTOR", "HALF_SCREEN_DRAG_OPEN_FACTOR", "SCROLL_RIGHT_CLOSE_MOVE_OFFSET_X_FACTOR", "TAG", "", "plugin-scan_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ View e(BaseBoxDialogView baseBoxDialogView) {
        View view = baseBoxDialogView.CBj;
        if (view == null) {
            p.btv("dialogContainer");
        }
        return view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseBoxDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseBoxDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        this.CBC = true;
        this.CBL = 1.0f;
        this.CBM = true;
        this.CBQ = true;
        this.CBS = true;
        this.animator = new ValueAnimator();
        this.CBT = new a();
        this.CBU = new a();
        this.CBV = new DecelerateInterpolator();
        setFitsSystemWindows(true);
        Resources resources = getResources();
        p.g(resources, "resources");
        this.lastOrientation = resources.getConfiguration().orientation;
        View inflate = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        p.g(inflate, "view");
        eP(inflate);
        View findViewById = inflate.findViewById(R.id.bqs);
        p.g(findViewById, "view.findViewById(R.id.dialog_container)");
        this.CBj = findViewById;
        View findViewById2 = inflate.findViewById(R.id.bqp);
        p.g(findViewById2, "view.findViewById(R.id.dialog_bg)");
        this.CBi = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.jkn);
        p.g(findViewById3, "view.findViewById(R.id.webview_container)");
        this.CBk = (BoxWebViewContainer) findViewById3;
        this.CBl = eQ(inflate);
        this.CBm = (LinearLayout) inflate.findViewById(R.id.y4);
        LinearLayout linearLayout = this.CBm;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.nmS = au.aD(context);
        ePa();
        View view = this.CBl;
        if (view == null) {
            p.btv("closeButton");
        }
        view.setOnClickListener(new j(this));
        this.mStatusBarHeight = au.getStatusBarHeight(context);
        this.mEY = com.tencent.mm.cb.a.jo(context) + this.mStatusBarHeight;
        this.CBy = getCloseLayoutHeight();
        this.CBA = com.tencent.mm.cb.a.fromDPToPix(context, 50);
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initBoxDialogView orientation: %s, getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", Integer.valueOf(this.lastOrientation), Integer.valueOf(this.mEY), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.CBA));
        View view2 = this.CBj;
        if (view2 == null) {
            p.btv("dialogContainer");
        }
        view2.setTranslationY((float) this.mEY);
        ePb();
    }

    public void eP(View view) {
        p.h(view, "view");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ BaseBoxDialogView CCb;

        j(BaseBoxDialogView baseBoxDialogView) {
            this.CCb = baseBoxDialogView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240232);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.CCb.Wr(4);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240232);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ BaseBoxDialogView CCb;

        k(BaseBoxDialogView baseBoxDialogView) {
            this.CCb = baseBoxDialogView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240233);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$initDialogBg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.CCb.CBS) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$initDialogBg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240233);
                return;
            }
            this.CCb.Wr(3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$initDialogBg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240233);
        }
    }

    private final void ePa() {
        View view = this.CBi;
        if (view == null) {
            p.btv("dialogBg");
        }
        view.setOnClickListener(new k(this));
    }

    private final void ePb() {
        View decorView;
        if (getContext() instanceof Activity) {
            Rect rect = new Rect();
            Context context = getContext();
            if (context == null) {
                throw new t("null cannot be cast to non-null type android.app.Activity");
            }
            Window window = ((Activity) context).getWindow();
            if (!(window == null || (decorView = window.getDecorView()) == null)) {
                decorView.getWindowVisibleDisplayFrame(rect);
            }
            this.CBz = rect.height();
            Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWindowVisibleHeight: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", rect, Integer.valueOf(rect.height()), Integer.valueOf(this.CBz), Integer.valueOf(this.nmS));
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Object[] objArr = new Object[2];
        objArr[0] = configuration != null ? Integer.valueOf(configuration.orientation) : null;
        objArr[1] = Integer.valueOf(this.lastOrientation);
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onConfigurationChanged newConfig orientation: %s, last: %s", objArr);
        int i2 = this.lastOrientation;
        if (configuration == null || i2 != configuration.orientation) {
            ePb();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 953
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.box.BaseBoxDialogView.onMeasure(int, int):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged"})
    static final class g implements MMWebView.e {
        final /* synthetic */ BaseBoxDialogView CCb;

        g(BaseBoxDialogView baseBoxDialogView) {
            this.CCb = baseBoxDialogView;
        }

        @Override // com.tencent.mm.ui.widget.MMWebView.e
        public final void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
            boolean z = true;
            AppMethodBeat.i(240226);
            Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            BaseBoxDialogView baseBoxDialogView = this.CCb;
            if (i3 != 0) {
                z = false;
            }
            baseBoxDialogView.CBM = z;
            AppMethodBeat.o(240226);
        }
    }

    public final void setBackgroundListener(f fVar) {
        p.h(fVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.CBo = fVar;
    }

    public final void setBackgroundTouchListener(c cVar) {
        p.h(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.CBp = cVar;
    }

    public final void setBackgroundViewModel(d dVar) {
        p.h(dVar, "model");
        this.CBq = dVar;
        d dVar2 = this.CBq;
        this.CBt = dVar2 != null ? dVar2.getMarkViewTransY() : 0.0f;
        if (this.CBq != null) {
            d dVar3 = this.CBq;
            if (dVar3 == null) {
                p.hyc();
            }
            if (dVar3.getMarkViewHeight() > ((float) this.CBA)) {
                d dVar4 = this.CBq;
                if (dVar4 == null) {
                    p.hyc();
                }
                this.CBA = (int) dVar4.getMarkViewHeight();
            }
        }
        Object[] objArr = new Object[1];
        d dVar5 = this.CBq;
        objArr[0] = dVar5 != null ? Float.valueOf(dVar5.getMarkViewTransY()) : null;
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setMarkView translationY: %s", objArr);
    }

    public final void setBackgroundOpView(b bVar) {
        p.h(bVar, "opView");
        this.CBr = bVar;
        if (this.CBr instanceof View) {
            LinearLayout linearLayout = this.CBm;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            LinearLayout linearLayout2 = this.CBm;
            if (linearLayout2 != null) {
                b bVar2 = this.CBr;
                if (bVar2 == null) {
                    throw new t("null cannot be cast to non-null type android.view.View");
                }
                linearLayout2.addView((View) bVar2);
            }
            LinearLayout linearLayout3 = this.CBm;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            requestLayout();
            return;
        }
        LinearLayout linearLayout4 = this.CBm;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
    }

    public final void setIsFixDialogHeight(boolean z) {
        this.CBG = z;
    }

    public final void setFixDialogHeight(int i2) {
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeight: %d", Integer.valueOf(i2));
        this.CBH = i2;
    }

    public final void setFixDialogHeightRate(float f2) {
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeightRate: %s", Float.valueOf(f2));
        this.CBJ = f2;
    }

    private final boolean ePc() {
        return this.CBG && (this.CBH > 0 || this.CBJ > 0.0f);
    }

    public final void setEnableWebViewScroll(boolean z) {
        BoxWebViewContainer boxWebViewContainer = this.CBk;
        if (boxWebViewContainer == null) {
            p.btv("webViewContainer");
        }
        boxWebViewContainer.setEnableScroll(z);
    }

    public final void setEnableDialogScroll(boolean z) {
        this.CBQ = z;
    }

    public final void setEnableScrollRightClose(boolean z) {
        this.CAL = z;
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        this.CBS = z;
        if (!this.CBS) {
            View view = this.CBi;
            if (view == null) {
                p.btv("dialogBg");
            }
            view.setVisibility(8);
            View view2 = this.CBi;
            if (view2 == null) {
                p.btv("dialogBg");
            }
            view2.setOnClickListener(null);
            return;
        }
        View view3 = this.CBi;
        if (view3 == null) {
            p.btv("dialogBg");
        }
        view3.setVisibility(0);
        ePa();
    }

    public final void Wr(int i2) {
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator updateListener;
        float maxTranslationY = (float) getMaxTranslationY();
        d dVar = this.CBq;
        float backgroundTransY = dVar != null ? dVar.getBackgroundTransY() : 0.0f;
        this.isAnimating = true;
        this.ddZ = false;
        View view = this.CBj;
        if (view == null) {
            p.btv("dialogContainer");
        }
        ViewPropertyAnimator animate = view.animate();
        if (animate != null && (translationY = animate.translationY(maxTranslationY)) != null && (duration = translationY.setDuration(300)) != null && (interpolator = duration.setInterpolator(new AccelerateInterpolator())) != null && (listener = interpolator.setListener(new h(this, i2))) != null && (updateListener = listener.setUpdateListener(new i(this, backgroundTransY))) != null) {
            updateListener.start();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class h implements Animator.AnimatorListener {
        final /* synthetic */ BaseBoxDialogView CCb;
        final /* synthetic */ int CCg;

        h(BaseBoxDialogView baseBoxDialogView, int i2) {
            this.CCb = baseBoxDialogView;
            this.CCg = i2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240228);
            this.CCb.isAnimating = false;
            this.CCb.CBW = 0;
            f fVar = this.CCb.CBo;
            if (fVar != null) {
                fVar.ePj();
            }
            MMHandlerThread.postToMainThread(new a(this));
            AppMethodBeat.o(240228);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ h CCh;

            a(h hVar) {
                this.CCh = hVar;
            }

            public final void run() {
                AppMethodBeat.i(240227);
                e eVar = this.CCh.CCb.CBh;
                if (eVar != null) {
                    eVar.dismissDialog(this.CCh.CCg);
                    AppMethodBeat.o(240227);
                    return;
                }
                AppMethodBeat.o(240227);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(240229);
            this.CCb.isAnimating = false;
            AppMethodBeat.o(240229);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(240230);
            f fVar = this.CCb.CBo;
            if (fVar != null) {
                fVar.ePi();
                AppMethodBeat.o(240230);
                return;
            }
            AppMethodBeat.o(240230);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-scan_release"})
    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ BaseBoxDialogView CCb;
        final /* synthetic */ float CCi;
        final /* synthetic */ float CCj = 0.0f;

        /* JADX WARN: Incorrect types in method signature: (FF)V */
        i(BaseBoxDialogView baseBoxDialogView, float f2) {
            this.CCb = baseBoxDialogView;
            this.CCi = f2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240231);
            this.CCb.bQ(BaseBoxDialogView.e(this.CCb).getTranslationY());
            if (valueAnimator == null) {
                AppMethodBeat.o(240231);
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240231);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.CCb.setBackgroundTranslationY((floatValue * (this.CCj - this.CCi)) + this.CCi);
            AppMethodBeat.o(240231);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class l implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ BaseBoxDialogView CCb;

        l(BaseBoxDialogView baseBoxDialogView) {
            this.CCb = baseBoxDialogView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240234);
            this.CCb.CBv = BaseBoxDialogView.e(this.CCb).getTranslationY();
            this.CCb.bQ(BaseBoxDialogView.e(this.CCb).getTranslationY());
            AppMethodBeat.o(240234);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class m implements Animator.AnimatorListener {
        final /* synthetic */ BaseBoxDialogView CCb;
        final /* synthetic */ float CCk;
        final /* synthetic */ float CCl;

        m(BaseBoxDialogView baseBoxDialogView, float f2, float f3) {
            this.CCb = baseBoxDialogView;
            this.CCk = f2;
            this.CCl = f3;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240235);
            f fVar = this.CCb.CBo;
            if (fVar != null) {
                fVar.ePk();
            }
            this.CCb.ddZ = true;
            this.CCb.isAnimating = false;
            Log.v("MicroMsg.BaseBoxDialogView", "alvinluo show onAnimationEnd current translationY: %f", Float.valueOf(BaseBoxDialogView.e(this.CCb).getTranslationY()));
            AppMethodBeat.o(240235);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(240236);
            this.CCb.isAnimating = false;
            AppMethodBeat.o(240236);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(240237);
            f fVar = this.CCb.CBo;
            if (fVar != null) {
                fVar.d(this.CCb.CBu, this.CCk, this.CCl);
                AppMethodBeat.o(240237);
                return;
            }
            AppMethodBeat.o(240237);
        }
    }

    /* access modifiers changed from: package-private */
    public final int getMaxTranslationY() {
        return this.CBu;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateShowBackground$1$1"})
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ BaseBoxDialogView CCb;

        e(BaseBoxDialogView baseBoxDialogView) {
            this.CCb = baseBoxDialogView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240224);
            BaseBoxDialogView baseBoxDialogView = this.CCb;
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240224);
                throw tVar;
            }
            baseBoxDialogView.setBackgroundTranslationY(((Float) animatedValue).floatValue());
            AppMethodBeat.o(240224);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateShowBackground$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class f implements Animator.AnimatorListener {
        final /* synthetic */ BaseBoxDialogView CCb;

        f(BaseBoxDialogView baseBoxDialogView) {
            this.CCb = baseBoxDialogView;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            Float f2;
            Float f3 = null;
            AppMethodBeat.i(240225);
            this.CCb.CBW = 1;
            BaseBoxDialogView baseBoxDialogView = this.CCb;
            d dVar = this.CCb.CBq;
            baseBoxDialogView.CBs = dVar != null ? dVar.getBackgroundTransY() : 0.0f;
            Object[] objArr = new Object[2];
            d dVar2 = this.CCb.CBq;
            if (dVar2 != null) {
                f2 = Float.valueOf(dVar2.getBackgroundTransY());
            } else {
                f2 = null;
            }
            objArr[0] = f2;
            d dVar3 = this.CCb.CBq;
            if (dVar3 != null) {
                f3 = Float.valueOf(dVar3.getMarkViewTransY());
            }
            objArr[1] = f3;
            Log.d("MicroMsg.BaseBoxDialogView", "alvinluo animateShowBackground onAnimationEnd bgTranslationY: %s, markViewTranslationY: %s", objArr);
            AppMethodBeat.o(240225);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Object[] objArr = new Object[1];
        objArr[0] = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent %s", objArr);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (onInterceptTouchEvent) {
            return onInterceptTouchEvent;
        }
        if (motionEvent == null) {
            return false;
        }
        if (this.CBg == null) {
            this.CBg = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.CBg;
        if (velocityTracker == null) {
            p.hyc();
        }
        velocityTracker.addMovement(motionEvent);
        VelocityTracker velocityTracker2 = this.CBg;
        if (velocityTracker2 == null) {
            p.hyc();
        }
        velocityTracker2.computeCurrentVelocity(1000);
        VelocityTracker velocityTracker3 = this.CBg;
        if (velocityTracker3 == null) {
            p.hyc();
        }
        int xVelocity = (int) velocityTracker3.getXVelocity();
        VelocityTracker velocityTracker4 = this.CBg;
        if (velocityTracker4 == null) {
            p.hyc();
        }
        int yVelocity = (int) velocityTracker4.getYVelocity();
        switch (motionEvent.getAction() & 255) {
            case 0:
                Object[] objArr2 = new Object[3];
                objArr2[0] = Float.valueOf(motionEvent.getRawX());
                objArr2[1] = Float.valueOf(motionEvent.getRawY());
                View view = this.CBj;
                if (view == null) {
                    p.btv("dialogContainer");
                }
                objArr2[2] = Float.valueOf(view.getTranslationY());
                Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", objArr2);
                this.CBe = motionEvent.getRawX();
                this.CBf = motionEvent.getRawY();
                z = false;
                break;
            case 1:
                z = false;
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.CBe;
                float rawY = motionEvent.getRawY() - this.CBf;
                Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", Float.valueOf(rawX), Float.valueOf(rawY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                float rawY2 = motionEvent.getRawY();
                View view2 = this.CBj;
                if (view2 == null) {
                    p.btv("dialogContainer");
                }
                if (rawY2 >= view2.getTranslationY()) {
                    if (Math.abs(rawY) >= 5.0f && this.CBQ && Math.abs(rawX) <= 250.0f && Math.abs(yVelocity) > Math.abs(xVelocity) && Math.abs(yVelocity) > 0 && Math.abs(rawY) > Math.abs(rawX)) {
                        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", Integer.valueOf(motionEvent.getAction()), Float.valueOf(this.CBv));
                        if (this.CBv <= this.CBw) {
                            z = this.CBM ? rawY >= 0.0f : false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            this.CBN = true;
                            break;
                        }
                    } else {
                        if (this.CAL) {
                            if (Math.abs(xVelocity) <= Math.abs(yVelocity) || rawX <= 0.0f || Math.abs(rawX) <= Math.abs(rawY) || this.CBe > 20.0f) {
                                z = false;
                            } else {
                                z = true;
                            }
                            Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", Float.valueOf(this.CBe), Boolean.valueOf(z));
                            if (z) {
                                this.CBO = true;
                                break;
                            }
                        }
                        z = false;
                        break;
                    }
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent enableScrollVertical: %b, action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", Boolean.valueOf(this.CBQ), Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(z), Boolean.valueOf(this.CBN), Boolean.valueOf(this.CBO));
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.box.BaseBoxDialogView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private final void c(float f2, boolean z) {
        float f3;
        if (!this.CBP) {
            this.CBP = true;
            f fVar = this.CBo;
            if (fVar != null) {
                fVar.ePg();
            }
        }
        MMWebView mMWebView = this.CBn;
        this.CBD = mMWebView != null ? mMWebView.getScrollHeight() : 0;
        if (ePc() && this.CBE > this.CBI) {
            int max = Math.max(this.CBI, this.CBF);
            Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", Integer.valueOf(this.CBI), Integer.valueOf(max));
            this.CBw = Math.max(this.CBw, (float) (this.CBE - max));
        } else if (this.CBE > this.CBD) {
            int max2 = Math.max(this.CBD, this.CBF);
            Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", Integer.valueOf(this.CBD), Integer.valueOf(max2));
            this.CBw = Math.max(this.CBw, (float) (this.CBE - max2));
        }
        if (z) {
            f3 = 0.68f * f2;
        } else {
            f3 = 0.85f * f2;
        }
        float min = Math.min((float) this.CBu, Math.max(this.CBw, this.CBv + f3));
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(this.CBv), Float.valueOf(min), Float.valueOf(this.CBw));
        this.CBK = f3;
        bP(min);
        if (f3 >= 0.0f) {
            float f4 = this.CBv;
            float f5 = (float) this.CBu;
            View view = this.CBj;
            if (view == null) {
                p.btv("dialogContainer");
            }
            setBackgroundTranslationY(a(f4, f5, view.getTranslationY(), this.CBs, 0.0f));
        } else if (this.CBv > 0.0f) {
            float f6 = this.CBv;
            View view2 = this.CBj;
            if (view2 == null) {
                p.btv("dialogContainer");
            }
            setBackgroundTranslationY(a(f6, 0.0f, view2.getTranslationY(), this.CBU.CBY, this.CBU.CBZ));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setBackgroundTranslationY(float f2) {
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setBackgroundTranslationY: %f", Float.valueOf(f2));
        d dVar = this.CBq;
        if (dVar != null) {
            dVar.setBackgroundTransY(f2);
        }
        d dVar2 = this.CBq;
        if (dVar2 != null) {
            dVar2.setMarkViewTransY(this.CBt + f2);
        }
    }

    /* access modifiers changed from: private */
    public static float a(float f2, float f3, float f4, float f5, float f6) {
        return (((1.0f * (f4 - f2)) / (f3 - f2)) * (f6 - f5)) + f5;
    }

    private final void d(View view, int i2, boolean z) {
        View view2;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i2;
                view2 = view;
            } else {
                layoutParams = null;
                view2 = view;
            }
            view2.setLayoutParams(layoutParams);
        }
        if (z) {
            post(new n(view));
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class n implements Runnable {
        final /* synthetic */ View wlJ;

        n(View view) {
            this.wlJ = view;
        }

        public final void run() {
            AppMethodBeat.i(240238);
            View view = this.wlJ;
            if (view != null) {
                view.requestLayout();
                AppMethodBeat.o(240238);
                return;
            }
            AppMethodBeat.o(240238);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void bP(float f2) {
        View view = this.CBj;
        if (view == null) {
            p.btv("dialogContainer");
        }
        view.setTranslationY(f2);
        bQ(f2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void bQ(float f2) {
        int i2;
        float f3 = (1.0f * f2) / ((float) this.CBu);
        f fVar = this.CBo;
        if (fVar != null) {
            fVar.c(this.CBW, f2, f3);
        }
        LinearLayout linearLayout = this.CBm;
        if (linearLayout != null) {
            b bVar = this.CBr;
            if (bVar != null) {
                i2 = bVar.getVieHeight();
            } else {
                i2 = 0;
            }
            linearLayout.setTranslationY(f2 - ((float) i2));
        }
        Object[] objArr = new Object[3];
        objArr[0] = Float.valueOf(f2);
        objArr[1] = Integer.valueOf(this.CBu);
        b bVar2 = this.CBr;
        objArr[2] = bVar2 != null ? Integer.valueOf(bVar2.getVieHeight()) : null;
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f, dialogHeight: %s, backgroundOpViewHeight: %s", objArr);
    }

    private final boolean ePd() {
        return this.CBK > 0.0f && Math.abs(this.CBK) >= ((float) this.CBE) * 0.15f;
    }

    private final boolean ePe() {
        return this.CBK < 0.0f && Math.abs(this.CBK) >= ((float) this.CBE) * 0.05f;
    }

    private final boolean ePf() {
        return this.CBK > 0.0f && Math.abs(this.CBK) >= ((float) this.CBE) * 0.15f;
    }

    private final void f(float f2, float f3, boolean z) {
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", Float.valueOf(f2), Float.valueOf(f3));
        if (f2 == f3) {
            Log.w("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
            return;
        }
        d dVar = this.CBq;
        float backgroundTransY = dVar != null ? dVar.getBackgroundTransY() : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        p.g(ofFloat, "animator");
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new c(this, z, f2, f3, backgroundTransY));
        ofFloat.addListener(new d(this, z));
        ofFloat.start();
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ BaseBoxDialogView CCb;
        final /* synthetic */ boolean CCc;
        final /* synthetic */ float CCd;
        final /* synthetic */ float CCe;
        final /* synthetic */ float CCf;

        c(BaseBoxDialogView baseBoxDialogView, boolean z, float f2, float f3, float f4) {
            this.CCb = baseBoxDialogView;
            this.CCc = z;
            this.CCd = f2;
            this.CCe = f3;
            this.CCf = f4;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            AppMethodBeat.i(240222);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240222);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.CCb.bP(floatValue);
            if (this.CCc) {
                f2 = this.CCb.CBU.CBZ;
            } else {
                f2 = this.CCb.CBT.CBZ;
            }
            this.CCb.setBackgroundTranslationY(BaseBoxDialogView.a(this.CCd, this.CCe, floatValue, this.CCf, f2));
            AppMethodBeat.o(240222);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/box/BaseBoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ BaseBoxDialogView CCb;
        final /* synthetic */ boolean CCc;

        d(BaseBoxDialogView baseBoxDialogView, boolean z) {
            this.CCb = baseBoxDialogView;
            this.CCc = z;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            int i2;
            AppMethodBeat.i(240223);
            this.CCb.yPa = this.CCc;
            this.CCb.CBv = BaseBoxDialogView.e(this.CCb).getTranslationY();
            BaseBoxDialogView baseBoxDialogView = this.CCb;
            d dVar = this.CCb.CBq;
            baseBoxDialogView.CBs = dVar != null ? dVar.getBackgroundTransY() : 0.0f;
            BaseBoxDialogView baseBoxDialogView2 = this.CCb;
            if (this.CCc) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            baseBoxDialogView2.CBW = i2;
            AppMethodBeat.o(240223);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-scan_release"})
    public final class a {
        float CBY;
        float CBZ;
        boolean CCa;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }
    }
}
