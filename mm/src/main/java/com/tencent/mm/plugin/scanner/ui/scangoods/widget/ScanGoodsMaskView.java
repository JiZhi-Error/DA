package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.vending.g.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ¡\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002¡\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HJ\u0010\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020F2\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020F0NH\u0002J\u0010\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020\u000fH\u0002J\u0012\u0010Q\u001a\u00020F2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020F2\b\u0010R\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010S\u001a\u00020\u000fH\u0002J\b\u0010T\u001a\u00020FH\u0002J(\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\fH\u0002J\u0012\u0010[\u001a\u00020F2\b\u0010R\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\b\u0010_\u001a\u00020]H\u0016J\b\u0010`\u001a\u00020VH\u0002J\u0018\u0010a\u001a\u00020K2\u0006\u0010b\u001a\u00020]2\u0006\u0010c\u001a\u00020]H\u0002J\u0018\u0010d\u001a\u00020K2\u0006\u0010b\u001a\u00020]2\u0006\u0010c\u001a\u00020]H\u0002J\u0010\u0010e\u001a\u00020F2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020\u0002H\u0002J\b\u0010h\u001a\u00020\u000fH\u0002J\b\u0010i\u001a\u00020\u000fH\u0002J\b\u0010j\u001a\u00020FH\u0016J\b\u0010k\u001a\u00020FH\u0016J\b\u0010l\u001a\u00020FH\u0016J \u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020\f2\u0006\u0010o\u001a\u00020]2\u0006\u0010p\u001a\u00020]H\u0016J \u0010q\u001a\u00020F2\u0006\u0010r\u001a\u00020\f2\u0006\u0010s\u001a\u00020]2\u0006\u0010t\u001a\u00020]H\u0016J\u0018\u0010u\u001a\u00020F2\u0006\u0010v\u001a\u00020\f2\u0006\u0010w\u001a\u00020\fH\u0014J\u0010\u0010x\u001a\u00020F2\u0006\u0010y\u001a\u00020\u000fH\u0016J\u001a\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010<H\u0016J\b\u0010~\u001a\u00020FH\u0002J\b\u0010\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0016J\t\u0010\u0001\u001a\u00020FH\u0016J\u0015\u0010\u0001\u001a\u00020F2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020FH\u0016J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0016J\t\u0010\u0001\u001a\u00020FH\u0003J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020]H\u0016J\u0013\u0010\u0001\u001a\u00020F2\b\u0010R\u001a\u0004\u0018\u00010\u0015H\u0003J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010g\u001a\u00020\u0002H\u0002J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020]H\u0016J\u0013\u0010\u0001\u001a\u00020F2\b\u0010g\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010\u0001\u001a\u00020F2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001e\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020\u000f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020F2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00020F2\b\u0010R\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010S\u001a\u00020\u000fH\u0002J\u0011\u0010\u0001\u001a\u00020F2\b\u0010R\u001a\u0004\u0018\u00010\u0015J\u0013\u0010\u0001\u001a\u00020F2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010t\u001a\u00020]H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010 \u0001\u001a\u00020FH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME, "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroid/support/animation/SpringAnimation;", "scanTipsImageAnimationTimer", "Ljava/util/Timer;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initScanTipsImageAnimation", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onTouchMoveBegin", "onTouchMoveEnd", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showLoadingView", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView extends BaseScanMaskView<ScanGoodsRequest> implements com.tencent.mm.plugin.scanner.box.d, com.tencent.mm.plugin.scanner.box.f {
    public static final a CQs = new a((byte) 0);
    private Bitmap BQT;
    public ScanAnimationDotsView CPO;
    private View CPP;
    private ImageView CPQ;
    private ImageView CPR;
    private ImageView CPS;
    private ImageView CPT;
    private View CPU;
    private boolean CPV;
    private ImageView CPW;
    private ImageView CPX;
    private LinearLayout CPY;
    private LinearLayout CPZ;
    private ImageView CQa;
    private TextView CQb;
    private ArrayList<Runnable> CQc;
    private long CQd;
    private int CQe;
    private int CQf;
    private boolean CQg;
    public boolean CQh;
    public boolean CQi;
    private Bitmap CQj;
    private com.tencent.mm.plugin.scanner.view.d CQk;
    private LinearInterpolator CQl;
    private DecelerateInterpolator CQm;
    private boolean CQn;
    private boolean CQo;
    private TimerTask CQp;
    private Timer CQq;
    private android.support.a.d CQr;
    private int gRD;
    private int gRE;
    private com.tencent.mm.ui.base.q gut;
    private View maskView;
    private Vibrator paT;

    static {
        AppMethodBeat.i(52328);
        AppMethodBeat.o(52328);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "roundBitmap", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.b<Bitmap, Boolean> {
        final /* synthetic */ ScanGoodsMaskView CQt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(ScanGoodsMaskView scanGoodsMaskView) {
            super(1);
            this.CQt = scanGoodsMaskView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Bitmap bitmap) {
            boolean z;
            AppMethodBeat.i(240604);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomTipsImage roundBitmap is invalid");
                com.tencent.mm.vending.g.g.hdx().ej(com.tencent.mm.vending.g.g.P(Boolean.FALSE, "tipsImage roundBitmap is invalid"));
                z = false;
            } else {
                Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomTipsImage");
                ScanGoodsMaskView.w(this.CQt).setImageBitmap(bitmap2);
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(240604);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"})
    public static final class o<T> implements d.b<Boolean> {
        final /* synthetic */ ScanGoodsMaskView CQt;

        o(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.g.d.b
        public final /* synthetic */ void bz(Boolean bool) {
            AppMethodBeat.i(240607);
            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomView finish result: %b", bool);
            this.CQt.CPV = true;
            ScanGoodsMaskView.y(this.CQt).setVisibility(0);
            ScanGoodsMaskView.r(this.CQt).setVisibility(0);
            this.CQt.CQe = this.CQt.getResources().getDimensionPixelSize(R.dimen.ai1);
            ScanGoodsMaskView.m(this.CQt).setVisibility(8);
            this.CQt.CPP = ScanGoodsMaskView.x(this.CQt);
            AppMethodBeat.o(240607);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$Companion;", "", "()V", "BACKGROUND_BLUR_RADIUS", "", "BACKGROUND_BLUR_SCALE", "", "BLUR_THREAD_LOOP_TAG", "", "SCAN_TIPS_IMAGE_ANIMATION_DELAY_MS", "", "SUCCESS_CUSTOM_VIEW_ROTATION_DEGREE", "SUCCESS_VIBRATE_DURATION", "TAG", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ ImageView a(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240620);
        ImageView imageView = scanGoodsMaskView.CPQ;
        if (imageView == null) {
            kotlin.g.b.p.btv("successDecorationView");
        }
        AppMethodBeat.o(240620);
        return imageView;
    }

    public static final /* synthetic */ void b(ScanGoodsMaskView scanGoodsMaskView, Bitmap bitmap) {
        AppMethodBeat.i(240623);
        scanGoodsMaskView.ap(bitmap);
        AppMethodBeat.o(240623);
    }

    public static final /* synthetic */ void b(ScanGoodsMaskView scanGoodsMaskView, boolean z) {
        AppMethodBeat.i(240622);
        scanGoodsMaskView.uf(z);
        AppMethodBeat.o(240622);
    }

    public static final /* synthetic */ LinearLayout c(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240621);
        LinearLayout linearLayout = scanGoodsMaskView.CPY;
        if (linearLayout == null) {
            kotlin.g.b.p.btv("customTipsContainer");
        }
        AppMethodBeat.o(240621);
        return linearLayout;
    }

    public static final /* synthetic */ View d(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52329);
        View view = scanGoodsMaskView.maskView;
        if (view == null) {
            kotlin.g.b.p.btv("maskView");
        }
        AppMethodBeat.o(52329);
        return view;
    }

    public static final /* synthetic */ ImageView e(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52330);
        ImageView imageView = scanGoodsMaskView.CPS;
        if (imageView == null) {
            kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
        }
        AppMethodBeat.o(52330);
        return imageView;
    }

    public static final /* synthetic */ ImageView f(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52331);
        ImageView imageView = scanGoodsMaskView.CPR;
        if (imageView == null) {
            kotlin.g.b.p.btv("bottomBlurView");
        }
        AppMethodBeat.o(52331);
        return imageView;
    }

    public static final /* synthetic */ ImageView k(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52334);
        ImageView imageView = scanGoodsMaskView.CPT;
        if (imageView == null) {
            kotlin.g.b.p.btv("blurView");
        }
        AppMethodBeat.o(52334);
        return imageView;
    }

    public static final /* synthetic */ void l(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52335);
        scanGoodsMaskView.ub(true);
        AppMethodBeat.o(52335);
    }

    public static final /* synthetic */ View m(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52337);
        View view = scanGoodsMaskView.CPP;
        if (view == null) {
            kotlin.g.b.p.btv("successMarkView");
        }
        AppMethodBeat.o(52337);
        return view;
    }

    public static final /* synthetic */ void p(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52339);
        scanGoodsMaskView.eRr();
        AppMethodBeat.o(52339);
    }

    public static final /* synthetic */ ImageView r(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240625);
        ImageView imageView = scanGoodsMaskView.CPW;
        if (imageView == null) {
            kotlin.g.b.p.btv("customMaskView");
        }
        AppMethodBeat.o(240625);
        return imageView;
    }

    public static final /* synthetic */ void v(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240627);
        scanGoodsMaskView.eRt();
        AppMethodBeat.o(240627);
    }

    public static final /* synthetic */ ImageView w(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240628);
        ImageView imageView = scanGoodsMaskView.CQa;
        if (imageView == null) {
            kotlin.g.b.p.btv("customTipsImage");
        }
        AppMethodBeat.o(240628);
        return imageView;
    }

    public static final /* synthetic */ ImageView x(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240629);
        ImageView imageView = scanGoodsMaskView.CPX;
        if (imageView == null) {
            kotlin.g.b.p.btv("customSuccessView");
        }
        AppMethodBeat.o(240629);
        return imageView;
    }

    public static final /* synthetic */ LinearLayout y(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240630);
        LinearLayout linearLayout = scanGoodsMaskView.CPZ;
        if (linearLayout == null) {
            kotlin.g.b.p.btv("customTipsImageContainer");
        }
        AppMethodBeat.o(240630);
        return linearLayout;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.scanner.api.BaseScanRequest] */
    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final /* bridge */ /* synthetic */ void setScanRequest(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240615);
        setScanRequest(scanGoodsRequest);
        AppMethodBeat.o(240615);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanGoodsMaskView(Context context) {
        this(context, null);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(52325);
        AppMethodBeat.o(52325);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanGoodsMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(52326);
        AppMethodBeat.o(52326);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanGoodsMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LinearLayout linearLayout;
        Object systemService;
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(52327);
        this.CQc = new ArrayList<>();
        this.CQe = getResources().getDimensionPixelSize(R.dimen.ai_);
        this.CQf = getResources().getDimensionPixelSize(R.dimen.ai0);
        this.CQl = new LinearInterpolator();
        this.CQm = new DecelerateInterpolator();
        this.CQn = true;
        this.CQo = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.az2, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.h_t);
        kotlin.g.b.p.g(findViewById, "view.findViewById(R.id.scan_animation_dots_view)");
        this.CPO = (ScanAnimationDotsView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.hap);
        kotlin.g.b.p.g(findViewById2, "view.findViewById(R.id.scan_success_dot_view)");
        this.CPP = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.gge);
        kotlin.g.b.p.g(findViewById3, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
        this.CPR = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.ggd);
        kotlin.g.b.p.g(findViewById4, "view.findViewById(R.id.preview_blur_view)");
        this.CPT = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.fac);
        kotlin.g.b.p.g(findViewById5, "view.findViewById(R.id.mask_view)");
        this.maskView = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.ggk);
        kotlin.g.b.p.g(findViewById6, "view.findViewById(R.id.preview_image)");
        this.CPS = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.bjp);
        kotlin.g.b.p.g(findViewById7, "view.findViewById(R.id.custom_mask_view)");
        this.CPW = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.bjy);
        kotlin.g.b.p.g(findViewById8, "view.findViewById(R.id.custom_success_view)");
        this.CPX = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.idw);
        kotlin.g.b.p.g(findViewById9, "view.findViewById(R.id.success_decoration_view)");
        this.CPQ = (ImageView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.bjs);
        kotlin.g.b.p.g(findViewById10, "view.findViewById(R.id.custom_scan_tips_container)");
        this.CPY = (LinearLayout) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.bju);
        kotlin.g.b.p.g(findViewById11, "view.findViewById(R.id.c…can_tips_image_container)");
        this.CPZ = (LinearLayout) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.bjt);
        kotlin.g.b.p.g(findViewById12, "view.findViewById(R.id.custom_scan_tips_image)");
        this.CQa = (ImageView) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.bjv);
        kotlin.g.b.p.g(findViewById13, "view.findViewById(R.id.custom_scan_tips_wording)");
        this.CQb = (TextView) findViewById13;
        if (this.paT == null && (systemService = context.getSystemService("vibrator")) != null) {
            this.paT = (Vibrator) systemService;
        }
        LinearLayout linearLayout2 = this.CPY;
        if (linearLayout2 == null) {
            kotlin.g.b.p.btv("customTipsContainer");
        }
        LinearLayout linearLayout3 = this.CPY;
        if (linearLayout3 == null) {
            kotlin.g.b.p.btv("customTipsContainer");
        }
        ViewGroup.LayoutParams layoutParams = linearLayout3.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(context, 154) + getMBottomExtraHeight();
            }
            linearLayout = linearLayout2;
        } else {
            layoutParams = null;
            linearLayout = linearLayout2;
        }
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(52327);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ ScanGoodsMaskView CQt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        public final void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator alpha;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator interpolator;
            ViewPropertyAnimator listener;
            ViewPropertyAnimator updateListener;
            AppMethodBeat.i(240598);
            super.onAnimationEnd(animator);
            ViewPropertyAnimator animate = ScanGoodsMaskView.a(this.CQt).animate();
            if (animate == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(200)) == null || (interpolator = duration.setInterpolator(new LinearInterpolator())) == null || (listener = interpolator.setListener(new a(this))) == null || (updateListener = listener.setUpdateListener(null)) == null) {
                AppMethodBeat.o(240598);
                return;
            }
            updateListener.start();
            AppMethodBeat.o(240598);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ b CQu;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.CQu = bVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(240597);
                super.onAnimationEnd(animator);
                com.tencent.mm.plugin.scanner.view.d dVar = this.CQu.CQt.CQk;
                if (dVar != null) {
                    dVar.eQG();
                    AppMethodBeat.o(240597);
                    return;
                }
                AppMethodBeat.o(240597);
            }
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(240599);
            super.onAnimationStart(animator);
            com.tencent.mm.plugin.scanner.view.d unused = this.CQt.CQk;
            AppMethodBeat.o(240599);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanGoodsMaskView CQt;

        c(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240600);
            kotlin.g.b.p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240600);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ScanGoodsMaskView.a(this.CQt).setRotation(360.0f - Math.abs(15.0f + (-15.0f * floatValue)));
            ScanGoodsMaskView.a(this.CQt).setAlpha(floatValue);
            ScanGoodsMaskView.c(this.CQt).setAlpha(1.0f - floatValue);
            AppMethodBeat.o(240600);
        }
    }

    private final void ub(boolean z) {
        int i2;
        AppMethodBeat.i(52302);
        ScanAnimationDotsView scanAnimationDotsView = this.CPO;
        if (scanAnimationDotsView == null) {
            kotlin.g.b.p.btv("animationDotsView");
        }
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        scanAnimationDotsView.setVisibility(i2);
        if (z) {
            ScanAnimationDotsView scanAnimationDotsView2 = this.CPO;
            if (scanAnimationDotsView2 == null) {
                kotlin.g.b.p.btv("animationDotsView");
            }
            scanAnimationDotsView2.startAnimation();
            AppMethodBeat.o(52302);
            return;
        }
        ScanAnimationDotsView scanAnimationDotsView3 = this.CPO;
        if (scanAnimationDotsView3 == null) {
            kotlin.g.b.p.btv("animationDotsView");
        }
        scanAnimationDotsView3.stopAnimation();
        AppMethodBeat.o(52302);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateHideBlurView$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ kotlin.g.a.a CQv;

        d(kotlin.g.a.a aVar) {
            this.CQv = aVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(52289);
            this.CQv.invoke();
            AppMethodBeat.o(52289);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanGoodsMaskView CQt;
        final /* synthetic */ boolean CQw;

        e(ScanGoodsMaskView scanGoodsMaskView, boolean z) {
            this.CQt = scanGoodsMaskView;
            this.CQw = z;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(52290);
            if (valueAnimator == null) {
                AppMethodBeat.o(52290);
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(52290);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ScanGoodsMaskView.d(this.CQt).setAlpha(0.5f - (floatValue * 0.5f));
            if (this.CQw) {
                ScanGoodsMaskView.e(this.CQt).setAlpha(1.0f - floatValue);
                ScanGoodsMaskView.f(this.CQt).setAlpha(1.0f - floatValue);
            }
            if (this.CQt.CPV) {
                ScanGoodsMaskView.c(this.CQt).setAlpha(floatValue);
            }
            Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", Float.valueOf(ScanGoodsMaskView.d(this.CQt).getAlpha()), Float.valueOf(floatValue));
            AppMethodBeat.o(52290);
        }
    }

    private final void ao(Bitmap bitmap) {
        AppMethodBeat.i(240610);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            new f(this, bitmap).invoke();
        }
        AppMethodBeat.o(240610);
    }

    private final Point getPreviewImageSize() {
        AppMethodBeat.i(240611);
        if (this.CQj != null) {
            Bitmap bitmap = this.CQj;
            if (bitmap == null) {
                kotlin.g.b.p.hyc();
            }
            if (!bitmap.isRecycled()) {
                try {
                    Bitmap bitmap2 = this.CQj;
                    if (bitmap2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    float width = ((float) bitmap2.getWidth()) * 1.0f;
                    Bitmap bitmap3 = this.CQj;
                    if (bitmap3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    float height = width / ((float) bitmap3.getHeight());
                    if (height < (((float) getMeasuredWidth()) * 1.0f) / ((float) getMeasuredHeight())) {
                        int measuredHeight = getMeasuredHeight();
                        Point point = new Point((int) (height * ((float) measuredHeight)), measuredHeight);
                        AppMethodBeat.o(240611);
                        return point;
                    }
                    int measuredWidth = getMeasuredWidth();
                    Point point2 = new Point(measuredWidth, (int) (((float) measuredWidth) / height));
                    AppMethodBeat.o(240611);
                    return point2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", e2, "alvinluo getPreviewImageSize exception", new Object[0]);
                    Point point3 = new Point(0, 0);
                    AppMethodBeat.o(240611);
                    return point3;
                }
            }
        }
        Point point4 = new Point(0, 0);
        AppMethodBeat.o(240611);
        return point4;
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void eU(View view) {
        boolean z = true;
        AppMethodBeat.i(52309);
        this.CPU = view;
        Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo attachBackgroundView source: %d", Integer.valueOf(getMScanSource()));
        if (view instanceof TextureView) {
            if (getMScanSource() != 1) {
                z = false;
            }
            if (z) {
                com.tencent.f.h.RTc.aX(new r(this, (TextureView) view));
            }
        }
        AppMethodBeat.o(52309);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void eRq() {
        AppMethodBeat.i(52310);
        super.eRq();
        AppMethodBeat.o(52310);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView, com.tencent.mm.plugin.scanner.view.b
    public final void a(Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(52311);
        super.a(animatorListener);
        eRs();
        com.tencent.mm.plugin.scanner.util.m.a(this, 1.0f, 0.0f, 200, animatorListener);
        AppMethodBeat.o(52311);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tY(boolean r8) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.tY(boolean):void");
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void b(Object obj, com.tencent.mm.plugin.scanner.view.d dVar) {
        int i2;
        PointF pointF;
        AppMethodBeat.i(52313);
        kotlin.g.b.p.h(obj, "data");
        Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
        this.CQk = dVar;
        if (obj instanceof z) {
            z zVar = (z) obj;
            Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
            ub(false);
            Log.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", Boolean.valueOf(this.CPV));
            ImageView imageView = this.CPX;
            if (imageView == null) {
                kotlin.g.b.p.btv("customSuccessView");
            }
            imageView.setVisibility(this.CPV ? 0 : 8);
            ImageView imageView2 = this.CPQ;
            if (imageView2 == null) {
                kotlin.g.b.p.btv("successDecorationView");
            }
            if (this.CPV) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView2.setVisibility(i2);
            eRs();
            float f2 = zVar.centerX;
            float f3 = zVar.centerY;
            if (getMScanSource() == 1) {
                float measuredWidth = f2 * ((float) getMeasuredWidth());
                float measuredHeight = f3 * ((float) getMeasuredHeight());
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(measuredWidth), Float.valueOf(measuredHeight));
                pointF = new PointF(measuredWidth, measuredHeight);
            } else {
                Point previewImageSize = getPreviewImageSize();
                int measuredWidth2 = (getMeasuredWidth() - previewImageSize.x) / 2;
                int measuredHeight2 = (getMeasuredHeight() - previewImageSize.y) / 2;
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, left: %d, top: %d", previewImageSize, Integer.valueOf(measuredWidth2), Integer.valueOf(measuredHeight2));
                pointF = new PointF((f2 * ((float) previewImageSize.x)) + ((float) measuredWidth2), (f3 * ((float) previewImageSize.y)) + ((float) measuredHeight2));
            }
            View view = this.CPP;
            if (view == null) {
                kotlin.g.b.p.btv("successMarkView");
            }
            view.setVisibility(0);
            view.setPivotX(((float) this.CQe) / 2.0f);
            view.setPivotY(((float) this.CQe) / 2.0f);
            view.setTranslationX(pointF.x - ((float) (this.CQe / 2)));
            view.setTranslationY(pointF.y - ((float) (this.CQe / 2)));
            view.setScaleX(0.0f);
            view.setScaleY(0.0f);
            if (!this.CPV) {
                View view2 = this.CPP;
                if (view2 == null) {
                    kotlin.g.b.p.btv("successMarkView");
                }
                h.a(view2, this.CQk);
            } else {
                Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo animateCustomSuccessView");
                View view3 = this.CPP;
                if (view3 == null) {
                    kotlin.g.b.p.btv("successMarkView");
                }
                h.eS(view3);
                ImageView imageView3 = this.CPQ;
                if (imageView3 == null) {
                    kotlin.g.b.p.btv("successDecorationView");
                }
                imageView3.setVisibility(0);
                imageView3.setPivotX(((float) this.CQf) / 2.0f);
                imageView3.setPivotY(((float) this.CQf) / 2.0f);
                imageView3.setTranslationX(pointF.x - ((float) (this.CQf / 2)));
                imageView3.setTranslationY(pointF.y - ((float) (this.CQf / 2)));
                imageView3.setScaleX(0.5f);
                imageView3.setScaleY(0.5f);
                imageView3.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setInterpolator(new LinearInterpolator()).setListener(new b(this)).setUpdateListener(new c(this)).start();
            }
            View view4 = this.maskView;
            if (view4 == null) {
                kotlin.g.b.p.btv("maskView");
            }
            view4.setAlpha(0.0f);
            view4.setVisibility(0);
            ImageView imageView4 = this.CPT;
            if (imageView4 == null) {
                kotlin.g.b.p.btv("blurView");
            }
            imageView4.setVisibility(8);
            uf(false);
            TextView scanTips = getScanTips();
            if (scanTips != null) {
                scanTips.setAlpha(1.0f);
            }
        }
        if (this.CQn) {
            com.tencent.f.h.RTc.aX(new i(this));
        }
        if (this.CQo) {
            postDelayed(new j(this), 100);
        }
        AppMethodBeat.o(52313);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ ScanGoodsMaskView CQt;

        i(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        public final void run() {
            AppMethodBeat.i(52296);
            PlaySound.play(this.CQt.getContext(), R.string.fse);
            AppMethodBeat.o(52296);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ ScanGoodsMaskView CQt;

        j(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        public final void run() {
            AppMethodBeat.i(52297);
            ScanGoodsMaskView.q(this.CQt);
            AppMethodBeat.o(52297);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void b(boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(52314);
        if (z) {
            com.tencent.mm.ui.base.q qVar = this.gut;
            if (qVar != null) {
                qVar.dismiss();
            }
            this.gut = com.tencent.mm.ui.base.h.a(getContext(), getResources().getString(R.string.gd3), true, onCancelListener);
            AppMethodBeat.o(52314);
            return;
        }
        com.tencent.mm.ui.base.q qVar2 = this.gut;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(52314);
            return;
        }
        AppMethodBeat.o(52314);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView, com.tencent.mm.plugin.scanner.view.b
    public final void release() {
        AppMethodBeat.i(52315);
        super.release();
        ScanAnimationDotsView scanAnimationDotsView = this.CPO;
        if (scanAnimationDotsView == null) {
            kotlin.g.b.p.btv("animationDotsView");
        }
        scanAnimationDotsView.release();
        ab abVar = ab.CGu;
        long j2 = this.CQd;
        ScanGoodsRequest scanGoodsRequest = ab.CGr.get(Long.valueOf(j2));
        ab.CGr.remove(Long.valueOf(j2));
        ab.hdu.remove(Long.valueOf(j2));
        if (scanGoodsRequest != null) {
            Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", Long.valueOf(j2));
            String c2 = ab.c(scanGoodsRequest);
            ab.CGt.put(c2, Boolean.TRUE);
            com.tencent.f.h.RTc.b(new ab.f(c2, scanGoodsRequest), 10000, "ScanResourceTag");
        }
        eRs();
        AppMethodBeat.o(52315);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class r implements Runnable {
        final /* synthetic */ TextureView CQE;
        final /* synthetic */ ScanGoodsMaskView CQt;

        r(ScanGoodsMaskView scanGoodsMaskView, TextureView textureView) {
            this.CQt = scanGoodsMaskView;
            this.CQE = textureView;
        }

        public final void run() {
            AppMethodBeat.i(52301);
            try {
                ScanGoodsMaskView.p(this.CQt);
                long currentTimeMillis = System.currentTimeMillis();
                final Bitmap bitmap = this.CQE.getBitmap();
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                com.tencent.f.h.RTc.aV(new Runnable(this) {
                    /* class com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.r.AnonymousClass1 */
                    final /* synthetic */ r CQF;

                    {
                        this.CQF = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(52300);
                        this.CQF.CQt.CQh = w.ePU();
                        this.CQF.CQt.CQi = true;
                        ScanGoodsMaskView.b(this.CQF.CQt, bitmap);
                        AppMethodBeat.o(52300);
                    }
                });
                AppMethodBeat.o(52301);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", e2, "alvinluo updatePreviewBitmap exception", new Object[0]);
                AppMethodBeat.o(52301);
            }
        }
    }

    public final void ap(Bitmap bitmap) {
        AppMethodBeat.i(240612);
        eRr();
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Boolean.valueOf(this.CQh), Boolean.valueOf(this.CQi));
            this.CQj = bitmap;
            ImageView imageView = this.CPS;
            if (imageView == null) {
                kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
            }
            imageView.setImageBitmap(bitmap);
            if (this.CQh) {
                ImageView imageView2 = this.CPS;
                if (imageView2 == null) {
                    kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                }
                imageView2.setVisibility(0);
                if (this.CQi) {
                    ImageView imageView3 = this.CPS;
                    if (imageView3 == null) {
                        kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                    }
                    imageView3.setAlpha(0.0f);
                } else {
                    ImageView imageView4 = this.CPS;
                    if (imageView4 == null) {
                        kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                    }
                    imageView4.setAlpha(1.0f);
                }
            } else {
                ImageView imageView5 = this.CPS;
                if (imageView5 == null) {
                    kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                }
                imageView5.setVisibility(8);
            }
        }
        ao(bitmap);
        AppMethodBeat.o(240612);
    }

    @Override // com.tencent.mm.plugin.scanner.box.d
    public final void setBackgroundTransY(float f2) {
        AppMethodBeat.i(52318);
        View view = this.CPU;
        if (view != null) {
            view.setTranslationY(f2);
        }
        ImageView imageView = this.CPT;
        if (imageView == null) {
            kotlin.g.b.p.btv("blurView");
        }
        imageView.setTranslationY(f2);
        ImageView imageView2 = this.CPS;
        if (imageView2 == null) {
            kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
        }
        imageView2.setTranslationY(f2);
        ImageView imageView3 = this.CPR;
        if (imageView3 == null) {
            kotlin.g.b.p.btv("bottomBlurView");
        }
        imageView3.setTranslationY(f2);
        AppMethodBeat.o(52318);
    }

    @Override // com.tencent.mm.plugin.scanner.box.d
    public final float getBackgroundTransY() {
        AppMethodBeat.i(52319);
        View view = this.CPU;
        if (view != null) {
            float translationY = view.getTranslationY();
            AppMethodBeat.o(52319);
            return translationY;
        }
        AppMethodBeat.o(52319);
        return 0.0f;
    }

    @Override // com.tencent.mm.plugin.scanner.box.d
    public final void setMarkViewTransY(float f2) {
        AppMethodBeat.i(52320);
        View view = this.CPP;
        if (view == null) {
            kotlin.g.b.p.btv("successMarkView");
        }
        view.setTranslationY(f2);
        AppMethodBeat.o(52320);
    }

    @Override // com.tencent.mm.plugin.scanner.box.d
    public final float getMarkViewTransY() {
        AppMethodBeat.i(52321);
        View view = this.CPP;
        if (view == null) {
            kotlin.g.b.p.btv("successMarkView");
        }
        float translationY = view.getTranslationY();
        AppMethodBeat.o(52321);
        return translationY;
    }

    @Override // com.tencent.mm.plugin.scanner.box.d
    public final float getMarkViewHeight() {
        AppMethodBeat.i(52322);
        float f2 = (float) this.CQe;
        AppMethodBeat.o(52322);
        return f2;
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void ePg() {
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void ePh() {
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void c(int i2, float f2, float f3) {
        boolean z;
        AppMethodBeat.i(52323);
        float max = Math.max(0.0f, Math.min(1.0f, f3));
        if (i2 == 1 || i2 == 2) {
            if (max >= 0.5f && i2 == 1) {
                z = this.CQg & true;
                float f4 = (max - 0.5f) / 0.5f;
                ImageView imageView = this.CPT;
                if (imageView == null) {
                    kotlin.g.b.p.btv("blurView");
                }
                imageView.setAlpha(this.CQm.getInterpolation(f4));
                View view = this.CPP;
                if (view == null) {
                    kotlin.g.b.p.btv("successMarkView");
                }
                view.setAlpha(1.0f - f4);
                ImageView imageView2 = this.CPS;
                if (imageView2 == null) {
                    kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                }
                ImageView imageView3 = this.CPT;
                if (imageView3 == null) {
                    kotlin.g.b.p.btv("blurView");
                }
                imageView2.setAlpha(1.0f - imageView3.getAlpha());
            } else if (i2 == 2) {
                z = this.CQg & true;
                ImageView imageView4 = this.CPT;
                if (imageView4 == null) {
                    kotlin.g.b.p.btv("blurView");
                }
                imageView4.setAlpha(this.CQm.getInterpolation(max));
                View view2 = this.CPP;
                if (view2 == null) {
                    kotlin.g.b.p.btv("successMarkView");
                }
                view2.setAlpha(1.0f - max);
                ImageView imageView5 = this.CPS;
                if (imageView5 == null) {
                    kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                }
                ImageView imageView6 = this.CPT;
                if (imageView6 == null) {
                    kotlin.g.b.p.btv("blurView");
                }
                imageView5.setAlpha(1.0f - imageView6.getAlpha());
            } else {
                View view3 = this.CPP;
                if (view3 == null) {
                    kotlin.g.b.p.btv("successMarkView");
                }
                view3.setAlpha(1.0f);
                ImageView imageView7 = this.CPS;
                if (imageView7 == null) {
                    kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                }
                imageView7.setAlpha(1.0f);
                z = false;
            }
            View view4 = this.maskView;
            if (view4 == null) {
                kotlin.g.b.p.btv("maskView");
            }
            view4.setAlpha(0.5f);
        } else {
            View view5 = this.maskView;
            if (view5 == null) {
                kotlin.g.b.p.btv("maskView");
            }
            view5.setAlpha(Math.max(0.0f, Math.min(0.5f, 1.0f - max)));
            if (this.CQh) {
                if (this.CQi) {
                    float max2 = Math.max(0.0f, Math.min(1.0f, (f3 - 0.5f) / 0.5f));
                    ImageView imageView8 = this.CPS;
                    if (imageView8 == null) {
                        kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                    }
                    imageView8.setAlpha(1.0f - max2);
                    Object[] objArr = new Object[2];
                    ImageView imageView9 = this.CPS;
                    if (imageView9 == null) {
                        kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                    }
                    objArr[0] = Float.valueOf(imageView9.getAlpha());
                    objArr[1] = Float.valueOf(max2);
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", objArr);
                    z = false;
                } else {
                    ImageView imageView10 = this.CPS;
                    if (imageView10 == null) {
                        kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
                    }
                    imageView10.setAlpha(1.0f);
                }
            }
            z = false;
        }
        ImageView imageView11 = this.CPT;
        if (imageView11 == null) {
            kotlin.g.b.p.btv("blurView");
        }
        imageView11.setVisibility(z ? 0 : 8);
        View view6 = this.maskView;
        if (view6 == null) {
            kotlin.g.b.p.btv("maskView");
        }
        view6.setVisibility(0);
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Float.valueOf(f2);
        objArr2[2] = Float.valueOf(f3);
        objArr2[3] = Boolean.valueOf(z);
        ImageView imageView12 = this.CPT;
        if (imageView12 == null) {
            kotlin.g.b.p.btv("blurView");
        }
        objArr2[4] = Float.valueOf(imageView12.getAlpha());
        View view7 = this.CPP;
        if (view7 == null) {
            kotlin.g.b.p.btv("successMarkView");
        }
        objArr2[5] = Float.valueOf(view7.getAlpha());
        View view8 = this.maskView;
        if (view8 == null) {
            kotlin.g.b.p.btv("maskView");
        }
        objArr2[6] = Float.valueOf(view8.getAlpha());
        ImageView imageView13 = this.CPS;
        if (imageView13 == null) {
            kotlin.g.b.p.btv(com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME);
        }
        objArr2[7] = Float.valueOf(imageView13.getAlpha());
        Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", objArr2);
        AppMethodBeat.o(52323);
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void ePi() {
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void ePj() {
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void ePk() {
    }

    @Override // com.tencent.mm.plugin.scanner.box.f
    public final void d(int i2, float f2, float f3) {
    }

    private final void eRr() {
        AppMethodBeat.i(52324);
        if (this.BQT != null) {
            Bitmap bitmap = this.BQT;
            if (bitmap == null) {
                kotlin.g.b.p.hyc();
            }
            if (!bitmap.isRecycled()) {
                Bitmap bitmap2 = this.BQT;
                if (bitmap2 == null) {
                    kotlin.g.b.p.hyc();
                }
                bitmap2.recycle();
                this.BQT = null;
            }
        }
        AppMethodBeat.o(52324);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(240613);
        super.onMeasure(i2, i3);
        this.gRD = getMeasuredWidth();
        this.gRE = getMeasuredHeight();
        if (!(this.gRD == 0 || this.gRE == 0)) {
            Iterator<T> it = this.CQc.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.CQc.clear();
        }
        AppMethodBeat.o(240613);
    }

    public final void setScanRequest(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240614);
        super.setScanRequest((BaseScanRequest) scanGoodsRequest);
        if (scanGoodsRequest == null) {
            AppMethodBeat.o(240614);
        } else if (!scanGoodsRequest.isValid()) {
            Log.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
            af.e(scanGoodsRequest);
            AppMethodBeat.o(240614);
        } else {
            LinearLayout linearLayout = this.CPY;
            if (linearLayout == null) {
                kotlin.g.b.p.btv("customTipsContainer");
            }
            linearLayout.setVisibility(0);
            setCustomTipsWording(scanGoodsRequest);
            ab abVar = ab.CGu;
            this.CQd = ab.a(scanGoodsRequest, new q(this, scanGoodsRequest));
            if (scanGoodsRequest.CAS) {
                scanGoodsRequest.CAS = false;
                this.CQq = new Timer();
                this.CQp = new g(this);
                Timer timer = this.CQq;
                if (timer != null) {
                    timer.schedule(this.CQp, 15000);
                    AppMethodBeat.o(240614);
                    return;
                }
            }
            AppMethodBeat.o(240614);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"})
    public static final class q implements aa {
        final /* synthetic */ ScanGoodsRequest CGz;
        final /* synthetic */ ScanGoodsMaskView CQt;

        q(ScanGoodsMaskView scanGoodsMaskView, ScanGoodsRequest scanGoodsRequest) {
            this.CQt = scanGoodsMaskView;
            this.CGz = scanGoodsRequest;
        }

        @Override // com.tencent.mm.plugin.scanner.model.aa
        public final void cn(int i2, String str) {
            AppMethodBeat.i(240609);
            kotlin.g.b.p.h(str, "errMsg");
            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
            if (i2 == 0) {
                ScanGoodsMaskView scanGoodsMaskView = this.CQt;
                String str2 = this.CGz.CAN;
                kotlin.g.b.p.g(str2, "request.decorationImagePath");
                ScanGoodsMaskView.a(scanGoodsMaskView, str2);
            }
            AppMethodBeat.o(240609);
        }
    }

    private final void setCustomTipsWording(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240616);
        String str = scanGoodsRequest.CAQ;
        if (!(str == null || str.length() == 0)) {
            TextView textView = this.CQb;
            if (textView == null) {
                kotlin.g.b.p.btv("customTipsWording");
            }
            textView.setText(scanGoodsRequest.CAQ);
            AppMethodBeat.o(240616);
            return;
        }
        TextView textView2 = this.CQb;
        if (textView2 == null) {
            kotlin.g.b.p.btv("customTipsWording");
        }
        Context context = getContext();
        kotlin.g.b.p.g(context, "context");
        textView2.setText(context.getResources().getString(R.string.gc7));
        AppMethodBeat.o(240616);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class p implements Runnable {
        final /* synthetic */ ScanGoodsMaskView CQt;
        final /* synthetic */ Bitmap cKG;

        p(ScanGoodsMaskView scanGoodsMaskView, Bitmap bitmap) {
            this.CQt = scanGoodsMaskView;
            this.cKG = bitmap;
        }

        public final void run() {
            AppMethodBeat.i(240608);
            com.tencent.mm.plugin.scanner.util.m mVar = com.tencent.mm.plugin.scanner.util.m.CUv;
            if (com.tencent.mm.plugin.scanner.util.m.a(this.cKG, ScanGoodsMaskView.r(this.CQt), this.CQt.gRD, this.CQt.gRE)) {
                ScanGoodsMaskView.r(this.CQt).setVisibility(0);
                ScanGoodsMaskView.u(this.CQt);
                AppMethodBeat.o(240608);
                return;
            }
            ScanGoodsMaskView.v(this.CQt);
            AppMethodBeat.o(240608);
        }
    }

    private final void setCustomBackgroundBitmap(Bitmap bitmap) {
        AppMethodBeat.i(240617);
        p pVar = new p(this, bitmap);
        if (this.gRD == 0 || this.gRE == 0) {
            this.CQc.add(pVar);
            AppMethodBeat.o(240617);
            return;
        }
        pVar.run();
        AppMethodBeat.o(240617);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$onSetCustomBackgroundSuccess$4", "Lcom/tencent/mm/vending/pipeline/PipeableTerminal$Interrupt;", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "", "onInterrupt", "", "result", "plugin-scan_release"})
    public static final class n implements d.a<com.tencent.mm.vending.j.c<Boolean, String>> {
        final /* synthetic */ ScanGoodsMaskView CQt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.g.d.a
        public final /* synthetic */ void cn(com.tencent.mm.vending.j.c<Boolean, String> cVar) {
            Boolean bool;
            AppMethodBeat.i(240606);
            com.tencent.mm.vending.j.c<Boolean, String> cVar2 = cVar;
            Object[] objArr = new Object[2];
            objArr[0] = cVar2 != null ? cVar2.hdM() : null;
            objArr[1] = cVar2 != null ? cVar2.hdN() : null;
            Log.e("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomView onInterrupt result: %s, %s", objArr);
            if (cVar2 != null) {
                bool = cVar2.hdM();
            } else {
                bool = null;
            }
            if (kotlin.g.b.p.j(bool, Boolean.FALSE)) {
                ScanGoodsMaskView.v(this.CQt);
            }
            AppMethodBeat.o(240606);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
    public static final class g extends TimerTask {
        final /* synthetic */ ScanGoodsMaskView CQt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(ScanGoodsMaskView scanGoodsMaskView) {
            this.CQt = scanGoodsMaskView;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ g CQB;

            a(g gVar) {
                this.CQB = gVar;
            }

            public final void run() {
                AppMethodBeat.i(240601);
                if (this.CQB.CQt.CPV && ScanGoodsMaskView.y(this.CQB.CQt).getVisibility() == 0) {
                    this.CQB.CQt.CQr = h.eT(ScanGoodsMaskView.y(this.CQB.CQt));
                }
                AppMethodBeat.o(240601);
            }
        }

        public final void run() {
            AppMethodBeat.i(240602);
            com.tencent.f.h.RTc.aV(new a(this));
            AppMethodBeat.o(240602);
        }
    }

    private final void eRs() {
        AppMethodBeat.i(240618);
        try {
            android.support.a.d dVar = this.CQr;
            if (dVar != null) {
                dVar.cancel();
            }
            TimerTask timerTask = this.CQp;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.CQq;
            if (timer != null) {
                timer.cancel();
                AppMethodBeat.o(240618);
                return;
            }
            AppMethodBeat.o(240618);
        } catch (Exception e2) {
            AppMethodBeat.o(240618);
        }
    }

    private final void eRt() {
        AppMethodBeat.i(240619);
        Log.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
        this.CPV = false;
        LinearLayout linearLayout = this.CPZ;
        if (linearLayout == null) {
            kotlin.g.b.p.btv("customTipsImageContainer");
        }
        linearLayout.setVisibility(8);
        ImageView imageView = this.CPW;
        if (imageView == null) {
            kotlin.g.b.p.btv("customMaskView");
        }
        imageView.setVisibility(8);
        ImageView imageView2 = this.CPW;
        if (imageView2 == null) {
            kotlin.g.b.p.btv("customMaskView");
        }
        imageView2.setImageBitmap(null);
        if (getRequest() instanceof ScanGoodsRequest) {
            BaseScanRequest request = getRequest();
            if (request == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
                AppMethodBeat.o(240619);
                throw tVar;
            }
            af.f((ScanGoodsRequest) request);
        }
        AppMethodBeat.o(240619);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ScanGoodsMaskView CQt;
        final /* synthetic */ boolean CQx = false;
        final /* synthetic */ Bitmap cKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ScanGoodsMaskView scanGoodsMaskView, Bitmap bitmap) {
            super(0);
            this.CQt = scanGoodsMaskView;
            this.cKG = bitmap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Integer num;
            AppMethodBeat.i(52294);
            boolean i2 = ScanGoodsMaskView.i(this.CQt);
            boolean i3 = ScanGoodsMaskView.i(this.CQt);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.CQt.BQT = BitmapUtil.fastBlurBitmap(this.cKG, 0.1f, 10, true, 200);
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo blurBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", e2, "blurBitmap exception", new Object[0]);
            }
            if (this.CQt.BQT != null) {
                Bitmap bitmap = this.CQt.BQT;
                if (bitmap == null) {
                    kotlin.g.b.p.hyc();
                }
                if (!bitmap.isRecycled()) {
                    Object[] objArr = new Object[2];
                    Bitmap bitmap2 = this.CQt.BQT;
                    if (bitmap2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    objArr[0] = Integer.valueOf(bitmap2.getWidth());
                    Bitmap bitmap3 = this.CQt.BQT;
                    if (bitmap3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    objArr[1] = Integer.valueOf(bitmap3.getHeight());
                    Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo blurBitmap width: %d, height: %d", objArr);
                    if (i2) {
                        Bitmap bitmap4 = this.CQt.BQT;
                        if (bitmap4 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        int width = bitmap4.getWidth();
                        Bitmap bitmap5 = this.CQt.BQT;
                        if (bitmap5 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        Point J = ScanGoodsMaskView.J(width, bitmap5.getHeight(), this.CQt.getMeasuredWidth(), this.CQt.getMeasuredHeight());
                        Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo blurBitmap needCrop width: %d, height: %d", Integer.valueOf(J.x), Integer.valueOf(J.y));
                        this.CQt.BQT = BitmapUtil.extractThumbNail(this.CQt.BQT, J.y, J.x, true, true);
                        Object[] objArr2 = new Object[2];
                        Bitmap bitmap6 = this.CQt.BQT;
                        objArr2[0] = bitmap6 != null ? Integer.valueOf(bitmap6.getWidth()) : null;
                        Bitmap bitmap7 = this.CQt.BQT;
                        if (bitmap7 != null) {
                            num = Integer.valueOf(bitmap7.getHeight());
                        } else {
                            num = null;
                        }
                        objArr2[1] = num;
                        Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo blurBitmap cropBitmap width: %s, height: %s", objArr2);
                    }
                    final a aVar = new a(this, i3);
                    if (this.CQx) {
                        this.CQt.post(new Runnable() {
                            /* class com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.f.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(52292);
                                aVar.invoke();
                                AppMethodBeat.o(52292);
                            }
                        });
                    } else {
                        aVar.invoke();
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(52294);
            return xVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ boolean CQA;
            final /* synthetic */ f CQz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar, boolean z) {
                super(0);
                this.CQz = fVar;
                this.CQA = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(52293);
                if (this.CQz.CQt.BQT != null) {
                    Bitmap bitmap = this.CQz.CQt.BQT;
                    if (bitmap == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (!bitmap.isRecycled()) {
                        ScanGoodsMaskView.k(this.CQz.CQt).setImageBitmap(this.CQz.CQt.BQT);
                        ScanGoodsMaskView.k(this.CQz.CQt).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        if (this.CQA) {
                            ScanGoodsMaskView.f(this.CQz.CQt).setImageBitmap(this.CQz.CQt.BQT);
                            ScanGoodsMaskView.f(this.CQz.CQt).setVisibility(0);
                            ScanGoodsMaskView.f(this.CQz.CQt).setAlpha(1.0f);
                            ScanGoodsMaskView.f(this.CQz.CQt).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                        this.CQz.CQt.CQg = true;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(52293);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean CQC;
        final /* synthetic */ ScanGoodsMaskView CQt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ScanGoodsMaskView scanGoodsMaskView, boolean z) {
            super(0);
            this.CQt = scanGoodsMaskView;
            this.CQC = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(52295);
            ScanGoodsMaskView.l(this.CQt);
            ScanGoodsMaskView.k(this.CQt).setVisibility(8);
            ScanGoodsMaskView.k(this.CQt).setImageBitmap(null);
            ScanGoodsMaskView.f(this.CQt).setVisibility(8);
            ScanGoodsMaskView.f(this.CQt).setImageBitmap(null);
            ScanGoodsMaskView.e(this.CQt).setVisibility(8);
            ScanGoodsMaskView.e(this.CQt).setImageBitmap(null);
            ScanGoodsMaskView.b(this.CQt, !this.CQC);
            ScanGoodsMaskView.d(this.CQt).setVisibility(8);
            ScanGoodsMaskView.m(this.CQt).setVisibility(8);
            View view = this.CQt.CPU;
            if (view != null) {
                view.setTranslationY(0.0f);
            }
            this.CQt.CQg = false;
            this.CQt.CQh = false;
            this.CQt.CQi = false;
            this.CQt.CQj = null;
            ScanGoodsMaskView.p(this.CQt);
            x xVar = x.SXb;
            AppMethodBeat.o(52295);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    public static final class k<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ ScanGoodsRequest CQD;

        k(ScanGoodsRequest scanGoodsRequest) {
            this.CQD = scanGoodsRequest;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(240603);
            ab abVar = ab.CGu;
            Bitmap aMy = ab.aMy(this.CQD.CAP);
            if (aMy == null || aMy.isRecycled()) {
                com.tencent.mm.vending.g.g.hdx().ej(com.tencent.mm.vending.g.g.P(Boolean.FALSE, "tipsImage getResource failed"));
                AppMethodBeat.o(240603);
                return null;
            }
            Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomTipsImage getRoundBitmap");
            com.tencent.mm.plugin.scanner.util.m mVar = com.tencent.mm.plugin.scanner.util.m.CUv;
            Bitmap ar = com.tencent.mm.plugin.scanner.util.m.ar(aMy);
            AppMethodBeat.o(240603);
            return ar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke", "(Ljava/lang/Boolean;)Z"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, Boolean> {
        final /* synthetic */ ScanGoodsRequest CQD;
        final /* synthetic */ ScanGoodsMaskView CQt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(ScanGoodsMaskView scanGoodsMaskView, ScanGoodsRequest scanGoodsRequest) {
            super(1);
            this.CQt = scanGoodsMaskView;
            this.CQD = scanGoodsRequest;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Boolean bool) {
            boolean z;
            AppMethodBeat.i(240605);
            Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomSuccessView");
            ab abVar = ab.CGu;
            Bitmap aMy = ab.aMy(this.CQD.CAO);
            if (aMy == null || aMy.isRecycled()) {
                com.tencent.mm.vending.g.g.hdx().ej(com.tencent.mm.vending.g.g.P(Boolean.FALSE, "successView getResouce failed"));
                z = false;
            } else {
                ScanGoodsMaskView.x(this.CQt).setImageBitmap(aMy);
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(240605);
            return valueOf;
        }
    }

    public static final /* synthetic */ boolean i(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52332);
        if (scanGoodsMaskView.getMScanSource() == 2) {
            AppMethodBeat.o(52332);
            return true;
        }
        AppMethodBeat.o(52332);
        return false;
    }

    public static final /* synthetic */ Point J(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(52333);
        float f2 = (((float) i4) * 1.0f) / ((float) i5);
        if ((((float) i2) * 1.0f) / ((float) i3) < f2) {
            if (i2 < i4) {
                Point point = new Point(i2, (int) (((float) i2) / f2));
                AppMethodBeat.o(52333);
                return point;
            }
            Point point2 = new Point(i4, i5);
            AppMethodBeat.o(52333);
            return point2;
        } else if (i3 < i5) {
            Point point3 = new Point((int) (f2 * ((float) i3)), i3);
            AppMethodBeat.o(52333);
            return point3;
        } else {
            Point point4 = new Point(i4, i5);
            AppMethodBeat.o(52333);
            return point4;
        }
    }

    public static final /* synthetic */ void q(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(52338);
        Vibrator vibrator = scanGoodsMaskView.paT;
        if (vibrator != null) {
            vibrator.vibrate(10);
            AppMethodBeat.o(52338);
            return;
        }
        AppMethodBeat.o(52338);
    }

    public static final /* synthetic */ void a(ScanGoodsMaskView scanGoodsMaskView, String str) {
        AppMethodBeat.i(240624);
        ab abVar = ab.CGu;
        Bitmap aMy = ab.aMy(str);
        if (aMy == null || aMy.isRecycled()) {
            scanGoodsMaskView.eRt();
            AppMethodBeat.o(240624);
            return;
        }
        scanGoodsMaskView.setCustomBackgroundBitmap(aMy);
        AppMethodBeat.o(240624);
    }

    public static final /* synthetic */ void u(ScanGoodsMaskView scanGoodsMaskView) {
        AppMethodBeat.i(240626);
        if (scanGoodsMaskView.getRequest() instanceof ScanGoodsRequest) {
            BaseScanRequest request = scanGoodsMaskView.getRequest();
            if (request == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
                AppMethodBeat.o(240626);
                throw tVar;
            }
            ScanGoodsRequest scanGoodsRequest = (ScanGoodsRequest) request;
            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo onSetCustomBackgroundSuccess");
            com.tencent.mm.vending.g.c<_Ret> Du = com.tencent.mm.vending.g.g.hdG().e(new k(scanGoodsRequest)).Du(true);
            kotlin.g.b.p.g(Du, "QuickAccess.pipeline().`…           }.serial(true)");
            com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.b(Du, new l(scanGoodsMaskView)), new m(scanGoodsMaskView, scanGoodsRequest)).a(new n(scanGoodsMaskView)).a(new o(scanGoodsMaskView));
        }
        AppMethodBeat.o(240626);
    }
}
