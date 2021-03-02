package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 ·\u00012\u00020\u00012\u00020\u0002:\u0002·\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020;J\u0014\u0010T\u001a\u00020R2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020RH\u0002J\u0018\u0010X\u001a\u00020R2\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u0015H\u0002J\u0010\u0010[\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\\\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020\bH\u0002J\u0010\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0002J\u0010\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010d\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010e\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010f\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010g\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010h\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010i\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010j\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010k\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010l\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010m\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010n\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010o\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J \u0010p\u001a\u00020R2\u0006\u0010q\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u00152\b\u0010U\u001a\u0004\u0018\u00010VJ\u0010\u0010s\u001a\u00020R2\b\u0010U\u001a\u0004\u0018\u00010VJ\u0010\u0010t\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010u\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010v\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010w\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010x\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010y\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010z\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010{\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010|\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010}\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010~\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0011\u0010\u0001\u001a\u00020R2\u0006\u0010\u0003\u001a\u00020\u0004H\u0003J\t\u0010\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0001\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\u0015J\u0006\u0010>\u001a\u00020\u0015J*\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u0015J\u0010\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\bJ\t\u0010\u0001\u001a\u00020RH\u0014J\u0013\u0010\u0001\u001a\u00020R2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\t\u0010\u0001\u001a\u00020RH\u0014J\u001f\u0010\u0001\u001a\u00020R2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u0007\u0010\u0001\u001a\u00020RJ\u0007\u0010\u0001\u001a\u00020RJ\u0011\u0010\u0001\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010;J\t\u0010\u0001\u001a\u00020RH\u0002J\t\u0010\u0001\u001a\u00020RH\u0002J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020@H\u0016J\u0012\u0010\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020@H\u0002J\u000f\u0010\u0001\u001a\u00020R2\u0006\u0010>\u001a\u00020\u0015J\u0012\u0010 \u0001\u001a\u00020R2\u0007\u0010¡\u0001\u001a\u00020\bH\u0016J\u001a\u0010¢\u0001\u001a\u00020R2\u0007\u0010£\u0001\u001a\u00020\u00152\b\u0010U\u001a\u0004\u0018\u00010VJ#\u0010¢\u0001\u001a\u00020R2\u0007\u0010£\u0001\u001a\u00020\u00152\u0007\u0010¤\u0001\u001a\u00020\u00152\b\u0010U\u001a\u0004\u0018\u00010VJ\u0011\u0010¥\u0001\u001a\u00020R2\b\u0010U\u001a\u0004\u0018\u00010VJ4\u0010¦\u0001\u001a\u00020R2\u0007\u0010§\u0001\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\u0007\u0010¨\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\bH\u0002J7\u0010ª\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u00152\t\b\u0002\u0010«\u0001\u001a\u00020\u0015H\u0007J\u001c\u0010¬\u0001\u001a\u00020R2\u0007\u0010­\u0001\u001a\u00020\b2\b\b\u0002\u0010Y\u001a\u00020\u0015H\u0002J*\u0010®\u0001\u001a\u00020R2\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\bH\u0002J-\u0010¯\u0001\u001a\u00020R2\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u00152\t\b\u0002\u0010°\u0001\u001a\u00020\u0015H\u0002J\u0015\u0010±\u0001\u001a\u00020R2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010²\u0001\u001a\u00020RH\u0002J$\u0010²\u0001\u001a\u00020R2\u0007\u0010³\u0001\u001a\u00020\b2\u0007\u0010´\u0001\u001a\u00020\b2\u0007\u0010µ\u0001\u001a\u00020\u0015H\u0002J\u001a\u0010¶\u0001\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u0015H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u000e\u0010&\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203XD¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010A\u001a\u00020@2\u0006\u0010*\u001a\u00020@@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001bR\u000e\u0010F\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u001bR\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006¸\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/floatball/MultiTaskFBViewAnimationHandler;", "backgroundDrawableCenter", "Landroid/graphics/drawable/Drawable;", "backgroundDrawableCenterPressed", "backgroundDrawableLeft", "backgroundDrawableLeftPressed", "backgroundDrawableRight", "backgroundDrawableRightPressed", "ballRootView", "canResetExtraSize", "", "currentBallRootViewVerticalGravity", "currentLayoutState", "currentPassiveCount", "currentStateHeight", "getCurrentStateHeight", "()I", "currentStateWidth", "getCurrentStateWidth", "customView", "Landroid/view/View;", "customViewMargin", "customViewSize", "Landroid/graphics/Point;", "enableClick", "extendWidth", "getExtendWidth", "extraSize", "fingerPosOnDown", "Landroid/graphics/PointF;", "innerView", "<set-?>", "isFloatBallViewDockLeft", "()Z", "isTouchEnabled", "lastBackgroundDockLeft", "lastBackgroundManual", "lastBackgroundSettled", "lastBackgroundState", "lastClickTime", "", "lastLayoutDockLeft", "lastLayoutManual", "lastLayoutSettled", "lastLayoutState", "lastOrientation", "listeners", "", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "mLayoutTransition", "Landroid/animation/LayoutTransition;", "needTranslateAnimation", "otherContentView", "", "posYPercentOfScreen", "getPosYPercentOfScreen", "()F", "positionY", "getPositionY", "previousLayoutState", "scaleTouchSlop", "screenResolution", "stickyAnimator", "Landroid/animation/ValueAnimator;", "targetPositionXWhenOrientationChanged", "getTargetPositionXWhenOrientationChanged", "uiHandler", "Landroid/os/Handler;", "viewPosOnDown", "widthNeedExtend", "addFloatBallViewListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkDoTranslateAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "checkOrientationIfNeed", "doUpdateFloatBallViewLayout", "isSettled", "isDockLeft", "getStateHeight", "getStateWidth", "getTargetPositionX", "startPositionX", "getTargetPositionY", "startPositionY", "getViewHeightWithoutVoip", "state", "getViewWidthWithoutVoip", "hasActiveState", "hasAppBrandVOIPState", "hasAudioState", "hasCustomViewState", "hasFourPassiveState", "hasOnePassiveState", "hasPassiveState", "hasThreePassiveState", "hasTwoPassiveState", "hasVOIPMultiTalkAudioState", "hasVOIPMultiTalkVideoState", "hasVideoState", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "withTransAnimation", "withAlphaAnimation", "hideByTranslation", "inActiveFourPassiveState", "inActiveOnePassiveState", "inActiveState", "inActiveThreePassiveState", "inActiveTwoPassiveState", "inAudioState", "inCustomViewActiveState", "inFourPassiveState", "inOnePassiveState", "inThreePassiveState", "inTwoPassiveState", "inVideoState", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isAnimating", "isPositionLeft", "positionX", "isWechatInForeground", "markWechatInForeground", "inForeground", "notifyBallPositionChanged", "x", "y", "isManual", "notifyOrientationChange", "orientation", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "processOrientationChanged", "newOrientation", "quickHide", "quickShow", "removeFloatBallViewListener", "resetExtraSize", "resetFloatBallViewSizeAndPosition", "setAlpha", "alpha", "setFloatBallAlphaInternal", "setNeedTranslateAnimation", "setVisibility", "visibility", "show", "withAnimation", "checkVisible", "showByTranslation", "startStickyAnimation", "stickToLeft", "targetPositionX", "targetPositionY", "updateBallPosition", "needNotify", "updateBallRootViewLayout", "gravity", "updateFloatBallBackground", "updateFloatBallViewLayout", "forceUpdate", "updateFloatBallViewLayoutState", "updateFloatBallViewSize", "viewWidth", "viewHeight", "notify", "updatePosYPercentOfScreen", "Companion", "plugin-multitask_release"})
public final class MultiTaskFloatBallView extends FrameLayout implements com.tencent.mm.plugin.multitask.c.b {
    public static final a Acs = new a((byte) 0);
    private static final int pae = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a5p);
    private static final int paf = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a5o);
    public com.tencent.mm.plugin.multitask.animation.b.b Aco;
    private FrameLayout Acp;
    private LayoutTransition Acq;
    private boolean Acr;
    private final Handler cPw;
    private int lastOrientation;
    private final Set<d> listeners;
    boolean oYj;
    private int oZZ;
    private int paR;
    private ValueAnimator paU;
    private FrameLayout paZ;
    private int paa;
    private boolean pbB;
    private Point pbD;
    private final PointF pbE;
    private final Point pbF;
    private float pbG;
    private int pbH;
    private boolean pbI;
    private final boolean pbK;
    private final Point pbN;
    private final boolean pbP;
    private int pbQ;
    private boolean pbR;
    private boolean pbS;
    private boolean pbT;
    private int pbU;
    private boolean pbX;
    private boolean pbY;
    private boolean pbZ;
    private Drawable pbg;
    private final Drawable pbh;
    private final Drawable pbi;
    private int pca;

    public MultiTaskFloatBallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskFloatBallView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(200689);
        this.listeners = new CopyOnWriteArraySet();
        this.pbD = new Point();
        this.pbE = new PointF();
        this.pbF = new Point();
        this.pbG = -1.0f;
        this.pbK = true;
        this.pbN = new Point();
        this.pbQ = 16;
        this.cPw = new Handler(Looper.getMainLooper());
        View.inflate(context, R.layout.ayu, this);
        this.pbg = com.tencent.mm.cb.a.l(context, R.drawable.a4p);
        this.Acp = (FrameLayout) findViewById(R.id.a0a);
        this.paZ = (FrameLayout) findViewById(R.id.g77);
        this.Aco = new com.tencent.mm.plugin.multitask.animation.b.b(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.paR = viewConfiguration.getScaledTouchSlop();
        Point az = ao.az(context);
        p.g(az, "UIUtils.getDisplayRealSize(context)");
        this.pbD = az;
        if (ao.gJN() && aw.kB(context)) {
            this.pbD.x = ao.getDeviceWidth();
        }
        if (ao.gJK()) {
            this.pbD.x = ao.getDeviceHeight();
        }
        this.Acq = new LayoutTransition();
        FrameLayout frameLayout = this.Acp;
        if (frameLayout != null) {
            frameLayout.setLayoutTransition(this.Acq);
        }
        Resources resources = getResources();
        p.g(resources, "resources");
        this.lastOrientation = resources.getConfiguration().orientation;
        AppMethodBeat.o(200689);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiTaskFloatBallView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
        AppMethodBeat.i(200690);
        AppMethodBeat.o(200690);
    }

    public final float getPosYPercentOfScreen() {
        return this.pbG;
    }

    public final int getPositionY() {
        return this.pbH;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(200660);
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(200660);
            throw tVar;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        y(layoutParams2.leftMargin, layoutParams2.topMargin, true);
        AppMethodBeat.o(200660);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(200661);
        super.onDetachedFromWindow();
        if (this.paU != null) {
            ValueAnimator valueAnimator = this.paU;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.paU = null;
        }
        AppMethodBeat.o(200661);
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(200662);
        p.h(configuration, "newConfig");
        Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.lastOrientation));
        BR(configuration.orientation);
        int i2 = configuration.orientation;
        for (d dVar : this.listeners) {
            dVar.onOrientationChange(i2);
        }
        AppMethodBeat.o(200662);
    }

    private final void BR(int i2) {
        Object obj;
        boolean z;
        AppMethodBeat.i(200663);
        Point point = this.pbD;
        Point az = ao.az(getContext());
        p.g(az, "UIUtils.getDisplayRealSize(context)");
        this.pbD = az;
        if (ao.gJN() && aw.kB(getContext())) {
            this.pbD.x = ao.getDeviceWidth();
        }
        if (ao.gJK()) {
            this.pbD.x = ao.getDeviceHeight();
        }
        Object[] objArr = new Object[2];
        objArr[0] = this.pbD;
        if (point == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = point;
        }
        objArr[1] = obj;
        Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", objArr);
        if (!(this.lastOrientation == i2 && (point == null || (point.x == this.pbD.x && point.y == this.pbD.y)))) {
            this.lastOrientation = i2;
            this.pbI = true;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(200663);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = marginLayoutParams.leftMargin;
            int i4 = (int) (((float) this.pbD.y) * this.pbG);
            int max = Math.max(Math.min(i3, this.pbD.x), 0);
            int max2 = Math.max(Math.min(i4, this.pbD.y), 0);
            int targetPositionXWhenOrientationChanged = getTargetPositionXWhenOrientationChanged();
            int BU = BU(max2);
            if (targetPositionXWhenOrientationChanged == 0) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.topMargin), Boolean.valueOf(z), Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(targetPositionXWhenOrientationChanged), Integer.valueOf(BU));
            d(z, max, max2, targetPositionXWhenOrientationChanged, BU);
        }
        AppMethodBeat.o(200663);
    }

    @Override // com.tencent.mm.plugin.multitask.c.b
    public final void a(MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200664);
        Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, multiTaskInfo:%s", multiTaskInfo);
        erl();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(200664);
            throw tVar;
        }
        boolean BT = BT(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
        f(true, BT, false);
        a(true, BT, false, this.oZZ);
        g(animatorListenerAdapter);
        AppMethodBeat.o(200664);
    }

    private final void erl() {
        AppMethodBeat.i(200665);
        this.paa = this.oZZ;
        this.oZZ = 0;
        if (AppForegroundDelegate.INSTANCE.Wc()) {
            this.oZZ |= 32;
        }
        AppMethodBeat.o(200665);
    }

    private final void f(boolean z, boolean z2, boolean z3) {
        int i2;
        boolean z4 = true;
        AppMethodBeat.i(200666);
        if (this.pbS == z && this.pbT == z2 && this.pbR == z3 && this.pbU != 0 && this.pbU == this.oZZ) {
            Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", Boolean.valueOf(this.pbY), Boolean.valueOf(z), Boolean.valueOf(this.pbT), Boolean.valueOf(z2), Boolean.valueOf(this.pbR), Boolean.valueOf(z3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ));
            AppMethodBeat.o(200666);
            return;
        }
        Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ));
        this.pbR = z3;
        this.pbS = z;
        this.pbT = z2;
        this.pbU = this.oZZ;
        cjz();
        FrameLayout frameLayout = this.Acp;
        if (frameLayout != null) {
            frameLayout.getPaddingLeft();
            int paddingRight = frameLayout.getPaddingRight();
            int paddingTop = frameLayout.getPaddingTop();
            int paddingBottom = frameLayout.getPaddingBottom();
            if ((this.oZZ & 32) == 0) {
                z4 = false;
            }
            if (z4) {
                if (z2) {
                    i2 = this.pbQ | 3;
                } else {
                    i2 = this.pbQ | 5;
                }
                RO(i2);
                if (z && z2) {
                    FrameLayout frameLayout2 = this.Acp;
                    if (frameLayout2 != null) {
                        frameLayout2.setPadding(getExtendWidth(), paddingTop, paddingRight, paddingBottom);
                    }
                    FrameLayout frameLayout3 = this.Acp;
                    if (frameLayout3 != null) {
                        frameLayout3.setLayoutTransition(this.Acq);
                    }
                    RO(this.pbQ | 3);
                    FrameLayout frameLayout4 = this.paZ;
                    if (frameLayout4 != null) {
                        frameLayout4.setVisibility(0);
                        AppMethodBeat.o(200666);
                        return;
                    }
                    AppMethodBeat.o(200666);
                    return;
                }
            } else if (z && z2) {
                FrameLayout frameLayout5 = this.Acp;
                if (frameLayout5 != null) {
                    frameLayout5.setPadding(getExtendWidth(), paddingTop, paddingRight, paddingBottom);
                }
                FrameLayout frameLayout6 = this.Acp;
                if (frameLayout6 != null) {
                    frameLayout6.setLayoutTransition(this.Acq);
                }
                RO(this.pbQ | 3);
                FrameLayout frameLayout7 = this.paZ;
                if (frameLayout7 != null) {
                    frameLayout7.setVisibility(0);
                    AppMethodBeat.o(200666);
                    return;
                }
            }
            AppMethodBeat.o(200666);
            return;
        }
        AppMethodBeat.o(200666);
    }

    private final void RO(int i2) {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(200667);
        FrameLayout frameLayout = this.Acp;
        ViewGroup.LayoutParams layoutParams2 = frameLayout != null ? frameLayout.getLayoutParams() : null;
        if (layoutParams2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(200667);
            throw tVar;
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.gravity = i2;
        FrameLayout frameLayout2 = this.Acp;
        if (frameLayout2 != null) {
            frameLayout2.setLayoutParams(layoutParams3);
        }
        FrameLayout frameLayout3 = this.paZ;
        if (frameLayout3 != null) {
            if (frameLayout3.getVisibility() == 0) {
                FrameLayout frameLayout4 = this.paZ;
                if (frameLayout4 != null) {
                    layoutParams = frameLayout4.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams;
                if (layoutParams4 != null) {
                    layoutParams4.gravity = 17;
                }
                FrameLayout frameLayout5 = this.paZ;
                if (frameLayout5 != null) {
                    frameLayout5.setLayoutParams(layoutParams4);
                    AppMethodBeat.o(200667);
                    return;
                }
            }
            AppMethodBeat.o(200667);
            return;
        }
        AppMethodBeat.o(200667);
    }

    private final void Y(int i2, boolean z) {
        if (z) {
            this.pbG = ((float) i2) / ((float) this.pbD.y);
        }
        this.pbH = i2;
    }

    public final void y(int i2, int i3, boolean z) {
        AppMethodBeat.i(200669);
        this.Acr = BT(i2);
        a(z, this.Acr, false, this.oZZ);
        f(z, this.Acr, false);
        Y(i3, z);
        Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.FALSE, Boolean.valueOf(this.Acr));
        AppMethodBeat.o(200669);
    }

    private final void a(boolean z, boolean z2, boolean z3, int i2) {
        AppMethodBeat.i(200670);
        if (this.pbY == z && this.pbZ == z2 && !this.pbX && this.pca == i2) {
            AppMethodBeat.o(200670);
            return;
        }
        Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.FALSE, Integer.valueOf(i2));
        this.pca = i2;
        this.pbX = false;
        this.pbY = z;
        this.pbZ = z2;
        if (!z) {
            FrameLayout frameLayout = this.Acp;
            if (frameLayout != null) {
                frameLayout.setBackground(this.pbi);
                AppMethodBeat.o(200670);
                return;
            }
            AppMethodBeat.o(200670);
        } else if (z2) {
            FrameLayout frameLayout2 = this.Acp;
            if (frameLayout2 != null) {
                frameLayout2.setBackground(this.pbg);
                AppMethodBeat.o(200670);
                return;
            }
            AppMethodBeat.o(200670);
        } else {
            FrameLayout frameLayout3 = this.Acp;
            if (frameLayout3 != null) {
                frameLayout3.setBackground(this.pbh);
                AppMethodBeat.o(200670);
                return;
            }
            AppMethodBeat.o(200670);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean BT(int i2) {
        AppMethodBeat.i(200671);
        if ((getCurrentStateWidth() / 2) + i2 <= this.pbD.x / 2) {
            AppMethodBeat.o(200671);
            return true;
        }
        AppMethodBeat.o(200671);
        return false;
    }

    private final void setFloatBallAlphaInternal(float f2) {
        int i2 = 0;
        AppMethodBeat.i(200673);
        setAlpha(f2);
        if (f2 == 0.0f) {
            Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
            i2 = 8;
        } else {
            Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", Float.valueOf(f2));
        }
        setVisibility(i2);
        AppMethodBeat.o(200673);
    }

    public final void setNeedTranslateAnimation(boolean z) {
        this.oYj = z;
    }

    private void d(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200674);
        Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
        setNeedTranslateAnimation(false);
        if (getVisibility() == 0) {
            Log.i("MicroMsg.FloatBallView", "showByTranslation float ball already show");
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200674);
                return;
            }
            AppMethodBeat.o(200674);
        } else if (this.Aco != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(200674);
                throw tVar;
            }
            boolean BT = BT(((FrameLayout.LayoutParams) layoutParams).leftMargin);
            com.tencent.mm.plugin.multitask.animation.b.b bVar = this.Aco;
            if (bVar != null) {
                bVar.a(getCurrentStateWidth(), BT, animatorListenerAdapter);
                AppMethodBeat.o(200674);
                return;
            }
            AppMethodBeat.o(200674);
        } else if (animatorListenerAdapter != null) {
            animatorListenerAdapter.onAnimationCancel(null);
            AppMethodBeat.o(200674);
        } else {
            AppMethodBeat.o(200674);
        }
    }

    public final void d(boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200675);
        if (getVisibility() == 8) {
            Log.i("MicroMsg.FloatBallView", "float ball already hide");
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200675);
                return;
            }
            AppMethodBeat.o(200675);
        } else if (z && this.Aco != null) {
            Log.i("MicroMsg.FloatBallView", "hide with trans animation");
            com.tencent.mm.plugin.multitask.animation.b.b bVar = this.Aco;
            if (bVar != null) {
                bVar.a(getCurrentStateWidth(), z, z2, animatorListenerAdapter);
                AppMethodBeat.o(200675);
                return;
            }
            AppMethodBeat.o(200675);
        } else if (!z2 || this.Aco == null) {
            Log.i("MicroMsg.FloatBallView", "hide without animation");
            setVisibility(8);
            cjB();
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200675);
                return;
            }
            AppMethodBeat.o(200675);
        } else {
            Log.i("MicroMsg.FloatBallView", "hide with alpha animation");
            com.tencent.mm.plugin.multitask.animation.b.b bVar2 = this.Aco;
            if (bVar2 != null) {
                bVar2.a(getCurrentStateWidth(), z, z2, animatorListenerAdapter);
                AppMethodBeat.o(200675);
                return;
            }
            AppMethodBeat.o(200675);
        }
    }

    private final void d(boolean z, int i2, int i3, int i4, int i5) {
        ValueAnimator valueAnimator;
        AppMethodBeat.i(200676);
        Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i5));
        if (!(this.paU == null || (valueAnimator = this.paU) == null || !valueAnimator.isRunning())) {
            Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
            ValueAnimator valueAnimator2 = this.paU;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
        this.paU = ValueAnimator.ofFloat(0.0f, 1.0f);
        ValueAnimator valueAnimator3 = this.paU;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator4 = this.paU;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration(100L);
        }
        ValueAnimator valueAnimator5 = this.paU;
        if (valueAnimator5 != null) {
            valueAnimator5.addUpdateListener(new b(this, i2, i4, i3, i5));
        }
        ValueAnimator valueAnimator6 = this.paU;
        if (valueAnimator6 != null) {
            valueAnimator6.addListener(new c(this));
        }
        ValueAnimator valueAnimator7 = this.paU;
        if (valueAnimator7 != null) {
            valueAnimator7.start();
            AppMethodBeat.o(200676);
            return;
        }
        AppMethodBeat.o(200676);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ MultiTaskFloatBallView Act;
        final /* synthetic */ int Acu;
        final /* synthetic */ int Acv;
        final /* synthetic */ int Acw;
        final /* synthetic */ int Acx;

        b(MultiTaskFloatBallView multiTaskFloatBallView, int i2, int i3, int i4, int i5) {
            this.Act = multiTaskFloatBallView;
            this.Acu = i2;
            this.Acv = i3;
            this.Acw = i4;
            this.Acx = i5;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(200658);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(200658);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            MultiTaskFloatBallView.a(this.Act, this.Acu + ((int) (((((float) this.Acv) * 1.0f) - ((float) this.Acu)) * floatValue)), ((int) (floatValue * ((((float) this.Acx) * 1.0f) - ((float) this.Acw)))) + this.Acw, false);
            AppMethodBeat.o(200658);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView$startStickyAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ MultiTaskFloatBallView Act;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(MultiTaskFloatBallView multiTaskFloatBallView) {
            this.Act = multiTaskFloatBallView;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(200659);
            p.h(animator, "animation");
            super.onAnimationEnd(animator);
            ViewGroup.LayoutParams layoutParams = this.Act.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(200659);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.Act.y(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, true);
            AppMethodBeat.o(200659);
        }
    }

    private static int BU(int i2) {
        if (i2 < f.oYS) {
            return f.oYS;
        }
        if (i2 > f.oYT) {
            return f.oYT;
        }
        return i2;
    }

    private final int getTargetPositionXWhenOrientationChanged() {
        AppMethodBeat.i(200677);
        int i2 = 0;
        if (!this.Acr) {
            i2 = this.pbD.x - getCurrentStateWidth();
        }
        AppMethodBeat.o(200677);
        return i2;
    }

    private static int getViewWidthWithoutVoip$134621() {
        return pae;
    }

    private static int getViewHeightWithoutVoip$134621() {
        return paf;
    }

    /* access modifiers changed from: package-private */
    public final int getCurrentStateWidth() {
        AppMethodBeat.i(200678);
        Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", Integer.valueOf(this.oZZ));
        int i2 = pae + f.oYN;
        AppMethodBeat.o(200678);
        return i2;
    }

    private final int getCurrentStateHeight() {
        AppMethodBeat.i(200679);
        Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", Integer.valueOf(this.oZZ));
        int i2 = paf + f.oYL + f.oYM;
        AppMethodBeat.o(200679);
        return i2;
    }

    private final void eY(int i2, int i3) {
        AppMethodBeat.i(200681);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(200681);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (i2 == 0 || i3 == 0) {
            marginLayoutParams.width = 0;
            marginLayoutParams.height = 0;
        } else {
            marginLayoutParams.width = i2;
            marginLayoutParams.height = i3;
        }
        try {
            setLayoutParams(marginLayoutParams);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallView", e2, "updateFloatBallViewSize exception", new Object[0]);
        }
        Log.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", Integer.valueOf(marginLayoutParams.width), Integer.valueOf(marginLayoutParams.height));
        AppMethodBeat.o(200681);
    }

    private final int getExtendWidth() {
        int i2;
        AppMethodBeat.i(200682);
        if (!this.pbI) {
            AppMethodBeat.o(200682);
            return 0;
        } else if (!com.tencent.mm.plugin.multitask.f.c.eF(getContext())) {
            AppMethodBeat.o(200682);
            return 0;
        } else {
            if (getContext() instanceof Activity) {
                Context context = getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(200682);
                    throw tVar;
                }
                Window window = ((Activity) context).getWindow();
                p.g(window, "(context as Activity).window");
                WindowManager windowManager = window.getWindowManager();
                p.g(windowManager, "(context as Activity).window.windowManager");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                p.g(defaultDisplay, "(context as Activity).wi…dowManager.defaultDisplay");
                i2 = defaultDisplay.getRotation();
            } else {
                i2 = 0;
            }
            if ((!this.Acr || i2 != 1) && (this.Acr || i2 != 3)) {
                AppMethodBeat.o(200682);
                return 0;
            }
            int aP = com.tencent.mm.plugin.multitask.f.c.aP(getContext());
            AppMethodBeat.o(200682);
            return aP;
        }
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(200683);
        super.setVisibility(i2);
        int alpha = (int) getAlpha();
        if (alpha == 0) {
            this.pbB = false;
            Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", Integer.valueOf(i2), Integer.valueOf(alpha));
            AppMethodBeat.o(200683);
            return;
        }
        if (alpha == 1) {
            this.pbB = true;
            Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", Integer.valueOf(i2), Integer.valueOf(alpha));
            cjA();
        }
        AppMethodBeat.o(200683);
    }

    public final void setAlpha(float f2) {
        AppMethodBeat.i(200684);
        super.setAlpha(f2);
        Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", Float.valueOf(f2));
        cjA();
        AppMethodBeat.o(200684);
    }

    private final void cjA() {
        AppMethodBeat.i(200685);
        if (((int) getAlpha()) == 1 && getVisibility() == 0) {
            Resources resources = getResources();
            p.g(resources, "resources");
            int i2 = resources.getConfiguration().orientation;
            if (i2 != this.lastOrientation) {
                Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", Integer.valueOf(i2), Integer.valueOf(this.lastOrientation));
                BR(i2);
            }
        }
        AppMethodBeat.o(200685);
    }

    private final void cjB() {
        AppMethodBeat.i(200686);
        if (!this.pbP) {
            AppMethodBeat.o(200686);
            return;
        }
        try {
            if (!(this.pbN.x == 0 && this.pbN.y == 0)) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                    AppMethodBeat.o(200686);
                    throw tVar;
                }
                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                int i2 = this.Acr ? 0 : layoutParams2.x + this.pbN.x;
                cjC();
                this.pbQ = 16;
                cjz();
                a(this, i2, layoutParams2.y + this.pbN.y, true);
                AppMethodBeat.o(200686);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallView", e2, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
        }
        AppMethodBeat.o(200686);
    }

    private final void cjC() {
        AppMethodBeat.i(200687);
        Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
        this.pbN.x = 0;
        this.pbN.y = 0;
        AppMethodBeat.o(200687);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(200688);
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(dVar);
        AppMethodBeat.o(200688);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView$Companion;", "", "()V", "FLOAT_BALL_ACTIVE_PASSIVE_HEIGHT", "", "FLOAT_BALL_ACTIVE_PASSIVE_WIDTH", "STATE_ACTIVE", "STATE_APPBRAND_VOIP_MIC_OFF", "STATE_APPBRAND_VOIP_MIC_ON", "STATE_AUDIO", "STATE_FOUR_PASSIVE", "STATE_NONE", "STATE_ONE_PASSIVE", "STATE_THREE_PASSIVE", "STATE_TWO_PASSIVE", "STATE_VIDEO", "STATE_VOIP_MULTI_TALK_AUDIO", "STATE_VOIP_MULTI_TALK_VIDEO", "STATE_WECHAT_FOREGROUND", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(200691);
        AppMethodBeat.o(200691);
    }

    public static /* synthetic */ void a(MultiTaskFloatBallView multiTaskFloatBallView, int i2, int i3, boolean z) {
        AppMethodBeat.i(200668);
        ViewGroup.LayoutParams layoutParams = multiTaskFloatBallView.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(200668);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i4 = marginLayoutParams.leftMargin;
        int i5 = marginLayoutParams.topMargin;
        if (!(i4 == i2 && i5 == i3)) {
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.topMargin = i3;
            try {
                multiTaskFloatBallView.y(i2, i3, z);
                AppMethodBeat.o(200668);
                return;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.FloatBallView", th, "updateBallPosition fail", new Object[0]);
            }
        }
        AppMethodBeat.o(200668);
    }

    private final void g(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200672);
        if (this.oYj) {
            d(animatorListenerAdapter);
            AppMethodBeat.o(200672);
        } else if (animatorListenerAdapter != null) {
            animatorListenerAdapter.onAnimationCancel(null);
            AppMethodBeat.o(200672);
        } else {
            AppMethodBeat.o(200672);
        }
    }

    private final void cjz() {
        AppMethodBeat.i(200680);
        eY(pae, pae);
        AppMethodBeat.o(200680);
    }
}
