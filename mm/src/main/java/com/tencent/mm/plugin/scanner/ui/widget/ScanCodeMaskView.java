package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.rtmp.TXLiveConstants;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010:\u001a\u00020\u001dH\u0002J\b\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020<H\u0002J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fH\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\"2\u0006\u0010C\u001a\u00020DH\u0002J\u0014\u0010E\u001a\u0004\u0018\u00010\"2\b\u0010F\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010G\u001a\u00020<H\u0002J\u0010\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0014\u0010J\u001a\u0004\u0018\u00010\u00152\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\n\u0010M\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010N\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010O\u001a\u00020<H\u0002J\b\u0010P\u001a\u00020<H\u0002J\b\u0010Q\u001a\u00020<H\u0002J\u0018\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0014J\b\u0010U\u001a\u00020<H\u0016J\u0010\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020\u0011H\u0016J\b\u0010X\u001a\u00020<H\u0016J\u001a\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010]\u001a\u00020<2\u0006\u0010^\u001a\u00020\u0011H\u0016J\u0010\u0010_\u001a\u00020<2\u0006\u0010^\u001a\u00020\u0011H\u0016J\u0012\u0010`\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020<H\u0016J\b\u0010d\u001a\u00020<H\u0002J\b\u0010e\u001a\u00020<H\u0016J,\u0010f\u001a\u0004\u0018\u00010\u00152\b\u0010g\u001a\u0004\u0018\u00010\u00152\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002J\b\u0010k\u001a\u00020<H\u0002J*\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f2\u0006\u0010o\u001a\u00020p2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002J\u0010\u0010l\u001a\u00020<2\u0006\u0010q\u001a\u00020\nH\u0002J\u0012\u0010r\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002J\u0012\u0010s\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002J\u000e\u0010t\u001a\u00020<2\u0006\u0010u\u001a\u00020\u001bJ\u0010\u0010v\u001a\u00020<2\u0006\u0010w\u001a\u00020\nH\u0016J\u0012\u0010x\u001a\u00020<2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u000e\u0010y\u001a\u00020<2\u0006\u0010z\u001a\u00020\u0011J\u000e\u0010{\u001a\u00020<2\u0006\u0010$\u001a\u00020\u0011J\u000e\u0010|\u001a\u00020<2\u0006\u00102\u001a\u000203J\u0018\u0010}\u001a\u00020<2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"06H\u0002J\u0006\u0010\u001a\u00020<J\u0007\u0010\u0001\u001a\u00020<J\u0012\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001d06j\b\u0012\u0004\u0012\u00020\u001d`7X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "myQrCodeButton", "needRotate", "pointCount", "scaleAnimationTimer", "Ljava/util/Timer;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Ljava/util/TimerTask;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/mm/plugin/scanner/model/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "successMarkViewSize", "viewWidth", "addSuccessView", "cancelScaleAnimator", "", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/qbar/WxQBarPoint;", "computeRealPosition", "pos", "dismissMultiCodeView", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getTargetSuccessMarkView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onShowInfoView", "show", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setMyQrCodeButtonVisible", "visible", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "plugin-scan_release"})
public final class ScanCodeMaskView extends BaseScanMaskView<BaseScanRequest> {
    public static final a CRC = new a((byte) 0);
    private int CQe;
    private com.tencent.mm.plugin.scanner.view.d CQk;
    private PointF CRA;
    private boolean CRB;
    private ImageView CRh;
    private View CRi;
    private View CRj;
    private TextView CRk;
    private ImageView CRl;
    private Bitmap CRm;
    private ArrayList<View> CRn;
    private int CRo;
    private ValueAnimator CRp;
    private float CRq;
    private boolean CRr;
    private boolean CRs;
    private ag CRt;
    private int CRu;
    private Timer CRv;
    private TimerTask CRw;
    private AccelerateInterpolator CRx;
    private DecelerateInterpolator CRy;
    private int CRz;
    private int gRD;
    private Rect mRect;
    private int pointCount;
    private ValueAnimator rnC;
    private ValueAnimator tgS;
    private boolean zvq;

    static {
        AppMethodBeat.i(52406);
        AppMethodBeat.o(52406);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$Companion;", "", "()V", "MULTI_CODE_TIPS_DEFAULT_BOTTOM_MARGIN_DP", "", "MULTI_CODE_TIPS_MIN_BOTTOM_MARGIN_DP", "SCALE_ANIMATION_DELAY", "", "SCALE_ANIMATION_DURATION", "SCALE_ANIMATION_MAX_SCALE", "", "SCALE_ANIMATION_MIN_SCALE", "SCALE_ANIMATION_PERIOD", "SCAN_LINE_ANIMATION_DURATION", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ Bitmap a(ScanCodeMaskView scanCodeMaskView, ScanDecodeFrameData scanDecodeFrameData) {
        AppMethodBeat.i(170073);
        Bitmap a2 = scanCodeMaskView.a(scanDecodeFrameData);
        AppMethodBeat.o(170073);
        return a2;
    }

    public static final /* synthetic */ ImageView a(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(52407);
        ImageView imageView = scanCodeMaskView.CRh;
        if (imageView == null) {
            p.btv("scanLineImageView");
        }
        AppMethodBeat.o(52407);
        return imageView;
    }

    public static final /* synthetic */ void b(ScanCodeMaskView scanCodeMaskView, int i2) {
        AppMethodBeat.i(170071);
        scanCodeMaskView.WW(i2);
        AppMethodBeat.o(170071);
    }

    public static final /* synthetic */ View g(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(52408);
        View view = scanCodeMaskView.CRi;
        if (view == null) {
            p.btv("myQrCodeButton");
        }
        AppMethodBeat.o(52408);
        return view;
    }

    public static final /* synthetic */ TextView h(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(52409);
        TextView scanTips = scanCodeMaskView.getScanTips();
        AppMethodBeat.o(52409);
        return scanTips;
    }

    public static final /* synthetic */ TextView k(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(170068);
        TextView textView = scanCodeMaskView.CRk;
        if (textView == null) {
            p.btv("multiCodeTips");
        }
        AppMethodBeat.o(170068);
        return textView;
    }

    public static final /* synthetic */ ImageView p(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(170074);
        ImageView imageView = scanCodeMaskView.CRl;
        if (imageView == null) {
            p.btv("frameImage");
        }
        AppMethodBeat.o(170074);
        return imageView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanCodeMaskView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(52403);
        AppMethodBeat.o(52403);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanCodeMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(52404);
        AppMethodBeat.o(52404);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanCodeMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(52405);
        this.CRn = new ArrayList<>();
        this.CQe = getResources().getDimensionPixelSize(R.dimen.aia);
        this.CRo = (this.CQe - (getResources().getDimensionPixelSize(R.dimen.ir) * 2)) + (getResources().getDimensionPixelSize(R.dimen.kb) * 2);
        this.CRp = new ValueAnimator();
        this.tgS = new ValueAnimator();
        this.mRect = new Rect(0, 0, 0, 0);
        this.CRu = -1;
        this.CRx = new AccelerateInterpolator(1.5f);
        this.CRy = new DecelerateInterpolator(1.5f);
        this.CRz = 120;
        this.CRA = new PointF();
        this.CRB = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ayy, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.ha7);
        p.g(findViewById, "view.findViewById(R.id.scan_line)");
        this.CRh = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ft3);
        p.g(findViewById2, "view.findViewById(R.id.my_qr_code)");
        this.CRi = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.fnc);
        p.g(findViewById3, "view.findViewById(R.id.multi_code_mask)");
        this.CRj = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.fnd);
        p.g(findViewById4, "view.findViewById(R.id.multi_code_tips)");
        this.CRk = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.d9t);
        p.g(findViewById5, "view.findViewById(R.id.frame_image)");
        this.CRl = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.hap);
        if (findViewById6 != null) {
            this.CRn.clear();
            this.CRn.add(findViewById6);
        }
        View view = this.CRi;
        if (view == null) {
            p.btv("myQrCodeButton");
        }
        view.setOnClickListener(new b(context));
        eRw();
        this.CRq = 0.16f;
        this.tgS.setInterpolator(new LinearInterpolator());
        this.tgS.setDuration(2500L);
        this.tgS.addListener(new d(this));
        this.tgS.addUpdateListener(new e(this));
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(-1);
        AppMethodBeat.o(52405);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ Context $context;

        b(Context context) {
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(170044);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11264, 3);
            com.tencent.mm.plugin.scanner.h.eON().ca(this.$context);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(170044);
        }
    }

    private final void eRw() {
        AppMethodBeat.i(52388);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        setAnimationRect(new Rect(0, (int) (0.15f * ((float) measuredHeight)), measuredWidth, (int) (((float) measuredHeight) * 0.6f)));
        AppMethodBeat.o(52388);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(52389);
        super.onMeasure(i2, i3);
        if (!(getMeasuredWidth() == 0 || getMeasuredWidth() == this.gRD)) {
            this.gRD = getMeasuredWidth();
            eRw();
        }
        if (this.CRB) {
            PointF pointF = this.CRA;
            TextView textView = this.CRk;
            if (textView == null) {
                p.btv("multiCodeTips");
            }
            pointF.x = textView.getX();
            PointF pointF2 = this.CRA;
            TextView textView2 = this.CRk;
            if (textView2 == null) {
                p.btv("multiCodeTips");
            }
            pointF2.y = textView2.getY();
        }
        AppMethodBeat.o(52389);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScanLineAnimator$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ ScanCodeMaskView CRD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(ScanCodeMaskView scanCodeMaskView) {
            this.CRD = scanCodeMaskView;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(52379);
            ScanCodeMaskView.a(this.CRD).setVisibility(8);
            AppMethodBeat.o(52379);
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanCodeMaskView CRD;

        e(ScanCodeMaskView scanCodeMaskView) {
            this.CRD = scanCodeMaskView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(52380);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(52380);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ScanCodeMaskView.a(this.CRD).setTranslationY(floatValue);
            float height = ((float) this.CRD.mRect.height()) * this.CRD.CRq;
            float f2 = floatValue - ((float) this.CRD.mRect.top);
            if (f2 <= height) {
                ScanCodeMaskView.a(this.CRD).setAlpha(1.0f - ((height - f2) / height));
                AppMethodBeat.o(52380);
            } else if (f2 >= ((float) this.CRD.mRect.height()) * (1.0f - this.CRD.CRq)) {
                ScanCodeMaskView.a(this.CRD).setAlpha(1.0f - ((f2 - (((float) this.CRD.mRect.height()) * (1.0f - this.CRD.CRq))) / height));
                AppMethodBeat.o(52380);
            } else {
                ScanCodeMaskView.a(this.CRD).setAlpha(1.0f);
                AppMethodBeat.o(52380);
            }
        }
    }

    public final void setMyQrCodeButtonVisible(boolean z) {
        AppMethodBeat.i(240635);
        View view = this.CRi;
        if (view == null) {
            p.btv("myQrCodeButton");
        }
        view.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(240635);
    }

    public final void setAnimationRect(Rect rect) {
        ImageView imageView;
        AppMethodBeat.i(52390);
        p.h(rect, "rect");
        this.mRect.set(rect);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo setAnimationRect %s", rect);
        ImageView imageView2 = this.CRh;
        if (imageView2 == null) {
            p.btv("scanLineImageView");
        }
        ImageView imageView3 = this.CRh;
        if (imageView3 == null) {
            p.btv("scanLineImageView");
        }
        ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.mRect.left;
            }
            imageView = imageView2;
        } else {
            layoutParams = null;
            imageView = imageView2;
        }
        imageView.setLayoutParams(layoutParams);
        this.tgS.setFloatValues((float) this.mRect.top, (float) this.mRect.bottom);
        AppMethodBeat.o(52390);
    }

    public final void cWj() {
        AppMethodBeat.i(52391);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
        this.tgS.cancel();
        AppMethodBeat.o(52391);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void setBottomExtraHeight(int i2) {
        AppMethodBeat.i(52395);
        super.setBottomExtraHeight(i2);
        View view = this.CRi;
        if (view == null) {
            p.btv("myQrCodeButton");
        }
        View view2 = this.CRi;
        if (view2 == null) {
            p.btv("myQrCodeButton");
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight();
        }
        view.setLayoutParams(layoutParams);
        WV(120);
        AppMethodBeat.o(52395);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void onResume() {
        AppMethodBeat.i(52396);
        super.onResume();
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo startScanLineAnimation");
        this.tgS.cancel();
        ImageView imageView = this.CRh;
        if (imageView == null) {
            p.btv("scanLineImageView");
        }
        imageView.setVisibility(0);
        this.tgS.start();
        AppMethodBeat.o(52396);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void onPause() {
        AppMethodBeat.i(52397);
        super.onPause();
        cWj();
        AppMethodBeat.o(52397);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void tY(boolean z) {
        AppMethodBeat.i(52401);
        super.tY(z);
        View view = this.CRi;
        if (view == null) {
            p.btv("myQrCodeButton");
        }
        view.setAlpha(1.0f);
        Iterator<T> it = this.CRn.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        TextView textView = this.CRk;
        if (textView == null) {
            p.btv("multiCodeTips");
        }
        textView.setVisibility(8);
        View view2 = this.CRj;
        if (view2 == null) {
            p.btv("multiCodeBgMask");
        }
        view2.setVisibility(8);
        ImageView imageView = this.CRl;
        if (imageView == null) {
            p.btv("frameImage");
        }
        imageView.setVisibility(8);
        this.CRs = false;
        this.CRr = false;
        if (!z) {
            TextView scanTips = getScanTips();
            if (scanTips != null) {
                scanTips.setVisibility(0);
            }
            TextView scanTips2 = getScanTips();
            if (scanTips2 != null) {
                scanTips2.setAlpha(1.0f);
            }
        }
        com.tencent.mm.plugin.scanner.util.m.a(this, 0.0f, 1.0f, 200, (Animator.AnimatorListener) null);
        eRx();
        eRy();
        this.CRp.removeAllListeners();
        this.CRp.removeAllUpdateListeners();
        this.CRp.cancel();
        AppMethodBeat.o(52401);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void eRq() {
        AppMethodBeat.i(52398);
        super.eRq();
        Log.v("MicroMsg.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(52398);
    }

    @Override // com.tencent.mm.plugin.scanner.view.b, com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void a(Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(52399);
        super.a(animatorListener);
        this.tgS.cancel();
        if (this.CRm != null) {
            Bitmap bitmap = this.CRm;
            if (bitmap == null) {
                p.hyc();
            }
            if (!bitmap.isRecycled()) {
                Bitmap bitmap2 = this.CRm;
                if (bitmap2 == null) {
                    p.hyc();
                }
                bitmap2.recycle();
            }
        }
        com.tencent.mm.plugin.scanner.util.m.a(this, 1.0f, 0.0f, 200, new f(this, animatorListener));
        AppMethodBeat.o(52399);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$onViewDestroy$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class f implements Animator.AnimatorListener {
        final /* synthetic */ Animator.AnimatorListener CPk;
        final /* synthetic */ ScanCodeMaskView CRD;

        f(ScanCodeMaskView scanCodeMaskView, Animator.AnimatorListener animatorListener) {
            this.CRD = scanCodeMaskView;
            this.CPk = animatorListener;
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(52381);
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
                AppMethodBeat.o(52381);
                return;
            }
            AppMethodBeat.o(52381);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(52382);
            Log.i("MicroMsg.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
            this.CRD.cWj();
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
                AppMethodBeat.o(52382);
                return;
            }
            AppMethodBeat.o(52382);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(52383);
            this.CRD.cWj();
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
                AppMethodBeat.o(52383);
                return;
            }
            AppMethodBeat.o(52383);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(52384);
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
                AppMethodBeat.o(52384);
                return;
            }
            AppMethodBeat.o(52384);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void b(Object obj, com.tencent.mm.plugin.scanner.view.d dVar) {
        PointF pointF;
        PointF pointF2;
        AppMethodBeat.i(52400);
        p.h(obj, "data");
        this.CQk = dVar;
        if ((obj instanceof ArrayList) && (kotlin.a.j.kt((List) obj) instanceof WxQBarResult)) {
            ArrayList<PointF> arrayList = new ArrayList<>();
            for (Object obj2 : (Iterable) obj) {
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.qbar.WxQBarResult");
                    AppMethodBeat.o(52400);
                    throw tVar;
                }
                WxQBarPoint wxQBarPoint = ((WxQBarResult) obj2).RKp;
                if (wxQBarPoint != null) {
                    if (wxQBarPoint.point_cnt != 4 || getMPreviewRect() == null || getScanCamera() == null) {
                        pointF = null;
                    } else {
                        com.tencent.mm.plugin.scanner.a.a scanCamera = getScanCamera();
                        if (scanCamera == null) {
                            p.hyc();
                        }
                        if (!scanCamera.hkT() || !this.zvq) {
                            float f2 = wxQBarPoint.x0 + wxQBarPoint.x1 + wxQBarPoint.x2 + wxQBarPoint.x3;
                            Rect mPreviewRect = getMPreviewRect();
                            if (mPreviewRect == null) {
                                p.hyc();
                            }
                            float width = f2 / ((float) (mPreviewRect.width() * 4));
                            float f3 = wxQBarPoint.y3 + wxQBarPoint.y0 + wxQBarPoint.y1 + wxQBarPoint.y2;
                            Rect mPreviewRect2 = getMPreviewRect();
                            if (mPreviewRect2 == null) {
                                p.hyc();
                            }
                            pointF = new PointF(width, f3 / ((float) (mPreviewRect2.height() * 4)));
                        } else {
                            float f4 = wxQBarPoint.x0 + wxQBarPoint.x1 + wxQBarPoint.x2 + wxQBarPoint.x3;
                            Rect mPreviewRect3 = getMPreviewRect();
                            if (mPreviewRect3 == null) {
                                p.hyc();
                            }
                            float height = f4 / ((float) (mPreviewRect3.height() * 4));
                            float f5 = wxQBarPoint.y3 + wxQBarPoint.y0 + wxQBarPoint.y1 + wxQBarPoint.y2;
                            Rect mPreviewRect4 = getMPreviewRect();
                            if (mPreviewRect4 == null) {
                                p.hyc();
                            }
                            pointF = new PointF(height, f5 / ((float) (mPreviewRect4.width() * 4)));
                        }
                    }
                    if (pointF == null || getMScanRect() == null) {
                        pointF2 = null;
                    } else {
                        float f6 = pointF.x;
                        Rect mScanRect = getMScanRect();
                        if (mScanRect == null) {
                            p.hyc();
                        }
                        float width2 = f6 * ((float) mScanRect.width());
                        Rect mScanRect2 = getMScanRect();
                        if (mScanRect2 == null) {
                            p.hyc();
                        }
                        float f7 = width2 + ((float) mScanRect2.left);
                        float f8 = pointF.y;
                        Rect mScanRect3 = getMScanRect();
                        if (mScanRect3 == null) {
                            p.hyc();
                        }
                        float height2 = f8 * ((float) mScanRect3.height());
                        Rect mScanRect4 = getMScanRect();
                        if (mScanRect4 == null) {
                            p.hyc();
                        }
                        pointF2 = new PointF(f7, height2 + ((float) mScanRect4.top));
                    }
                    arrayList.add(pointF2);
                }
            }
            aN(arrayList);
        }
        AppMethodBeat.o(52400);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aN(java.util.ArrayList<android.graphics.PointF> r14) {
        /*
        // Method dump skipped, instructions count: 844
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.aN(java.util.ArrayList):void");
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ ScanCodeMaskView CRD;
        final /* synthetic */ PointF CRP;
        final /* synthetic */ z.a CRQ;
        final /* synthetic */ int puW;
        final /* synthetic */ z.f uNn;

        m(int i2, PointF pointF, z.f fVar, ScanCodeMaskView scanCodeMaskView, z.a aVar) {
            this.puW = i2;
            this.CRP = pointF;
            this.uNn = fVar;
            this.CRD = scanCodeMaskView;
            this.CRQ = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(170054);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.CRD.CRu = this.puW;
            ag agVar = this.CRD.CRt;
            if (agVar != null) {
                agVar.WK(this.puW);
            }
            for (View view2 : this.CRD.CRn) {
                view2.setOnClickListener(null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(170054);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class k implements Animator.AnimatorListener {
        final /* synthetic */ ScanCodeMaskView CRD;

        k(ScanCodeMaskView scanCodeMaskView) {
            this.CRD = scanCodeMaskView;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(52385);
            Log.v("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
            com.tencent.mm.plugin.scanner.view.d dVar = this.CRD.CQk;
            if (dVar != null) {
                dVar.eQG();
                AppMethodBeat.o(52385);
                return;
            }
            AppMethodBeat.o(52385);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(52386);
            com.tencent.mm.plugin.scanner.view.d unused = this.CRD.CQk;
            AppMethodBeat.o(52386);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$2"})
    public static final class l implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanCodeMaskView CRD;

        l(ScanCodeMaskView scanCodeMaskView) {
            this.CRD = scanCodeMaskView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(52387);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(52387);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ScanCodeMaskView.g(this.CRD).setAlpha(1.0f - floatValue);
            TextView h2 = ScanCodeMaskView.h(this.CRD);
            if (h2 != null) {
                h2.setAlpha(1.0f - floatValue);
            }
            int i2 = 0;
            for (Object obj : this.CRD.CRn) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                View view = (View) obj;
                if (i2 < this.CRD.pointCount) {
                    view.setAlpha(floatValue);
                    view.setScaleX(floatValue);
                    view.setScaleY(floatValue);
                }
                i2 = i3;
            }
            if (this.CRD.CRr) {
                ScanCodeMaskView.k(this.CRD).setAlpha(floatValue);
            }
            AppMethodBeat.o(52387);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class n implements Animator.AnimatorListener {
        final /* synthetic */ ScanCodeMaskView CRD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(ScanCodeMaskView scanCodeMaskView) {
            this.CRD = scanCodeMaskView;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(170055);
            ScanCodeMaskView.l(this.CRD);
            AppMethodBeat.o(170055);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private final void WV(int i2) {
        AppMethodBeat.i(240636);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", Integer.valueOf(i2));
        TextView textView = this.CRk;
        if (textView == null) {
            p.btv("multiCodeTips");
        }
        TextView textView2 = this.CRk;
        if (textView2 == null) {
            p.btv("multiCodeTips");
        }
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            this.CRz = i2;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), i2) + getMBottomExtraHeight();
        }
        textView.setLayoutParams(layoutParams);
        AppMethodBeat.o(240636);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScaleAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
    public static final class c extends TimerTask {
        final /* synthetic */ ScanCodeMaskView CRD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(ScanCodeMaskView scanCodeMaskView) {
            this.CRD = scanCodeMaskView;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c CRE;

            a(c cVar) {
                this.CRE = cVar;
            }

            public final void run() {
                AppMethodBeat.i(170045);
                ScanCodeMaskView.m(this.CRE.CRD);
                AppMethodBeat.o(170045);
            }
        }

        public final void run() {
            AppMethodBeat.i(170046);
            MMHandlerThread.postToMainThread(new a(this));
            AppMethodBeat.o(170046);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ ScanCodeMaskView CRD;
        final /* synthetic */ int CRL;

        i(ScanCodeMaskView scanCodeMaskView, int i2) {
            this.CRD = scanCodeMaskView;
            this.CRL = i2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ i CRM;

            a(i iVar) {
                this.CRM = iVar;
            }

            public final void run() {
                AppMethodBeat.i(170050);
                if (this.CRM.CRL < 2) {
                    ScanCodeMaskView.b(this.CRM.CRD, this.CRM.CRL + 1);
                }
                AppMethodBeat.o(170050);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(170051);
            MMHandlerThread.postToMainThreadDelayed(new a(this), 50);
            AppMethodBeat.o(170051);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private final void WW(int i2) {
        AppMethodBeat.i(170057);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation %d", Integer.valueOf(i2));
        a(1.0f, 0.8f, this.CRx, new h(this, new i(this, i2)));
        AppMethodBeat.o(170057);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class h implements Animator.AnimatorListener {
        final /* synthetic */ ScanCodeMaskView CRD;
        final /* synthetic */ i CRJ;

        h(ScanCodeMaskView scanCodeMaskView, i iVar) {
            this.CRD = scanCodeMaskView;
            this.CRJ = iVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ h CRK;

            a(h hVar) {
                this.CRK = hVar;
            }

            public final void run() {
                AppMethodBeat.i(170048);
                ScanCodeMaskView.a(this.CRK.CRD, this.CRK.CRJ);
                AppMethodBeat.o(170048);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(170049);
            MMHandlerThread.postToMainThreadDelayed(new a(this), 50);
            AppMethodBeat.o(170049);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private final void a(float f2, float f3, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(170058);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", Float.valueOf(f2), Float.valueOf(f3));
        eRy();
        this.rnC = new ValueAnimator();
        ValueAnimator valueAnimator = this.rnC;
        if (valueAnimator != null) {
            valueAnimator.setFloatValues(f2, f3);
            valueAnimator.setInterpolator(interpolator);
            valueAnimator.setDuration(300L);
            valueAnimator.addUpdateListener(new g(this, f2, f3, interpolator, animatorListener));
            valueAnimator.addListener(animatorListener);
            valueAnimator.start();
            AppMethodBeat.o(170058);
            return;
        }
        AppMethodBeat.o(170058);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$2$1"})
    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanCodeMaskView CRD;
        final /* synthetic */ float CRF;
        final /* synthetic */ float CRG;
        final /* synthetic */ Interpolator CRH;
        final /* synthetic */ Animator.AnimatorListener CRI;

        g(ScanCodeMaskView scanCodeMaskView, float f2, float f3, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
            this.CRD = scanCodeMaskView;
            this.CRF = f2;
            this.CRG = f3;
            this.CRH = interpolator;
            this.CRI = animatorListener;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(170047);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(170047);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            int i2 = 0;
            for (Object obj : this.CRD.CRn) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                View view = (View) obj;
                if (i2 < this.CRD.pointCount) {
                    view.setScaleX(floatValue);
                    view.setScaleY(floatValue);
                }
                i2 = i3;
            }
            AppMethodBeat.o(170047);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.view.b, com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void release() {
        AppMethodBeat.i(52402);
        super.release();
        eRx();
        eRy();
        AppMethodBeat.o(52402);
    }

    private final void eRx() {
        AppMethodBeat.i(170060);
        Timer timer = this.CRv;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.CRw;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.CRv = null;
        this.CRw = null;
        AppMethodBeat.o(170060);
    }

    private final void eRy() {
        AppMethodBeat.i(170061);
        ValueAnimator valueAnimator = this.rnC;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.rnC;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.rnC;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.rnC = null;
        AppMethodBeat.o(170061);
    }

    public final void setNeedRotate(boolean z) {
        this.zvq = z;
    }

    public final void setSuccessMarkClickListener(ag agVar) {
        AppMethodBeat.i(170062);
        p.h(agVar, "successMarkClickListener");
        this.CRt = agVar;
        AppMethodBeat.o(170062);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void setDecodeSuccessFrameData(ScanDecodeFrameData scanDecodeFrameData) {
        AppMethodBeat.i(170063);
        super.setDecodeSuccessFrameData(scanDecodeFrameData);
        com.tencent.f.h.RTc.aX(new j(this, scanDecodeFrameData));
        AppMethodBeat.o(170063);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ ScanCodeMaskView CRD;
        final /* synthetic */ ScanDecodeFrameData CRN;

        j(ScanCodeMaskView scanCodeMaskView, ScanDecodeFrameData scanDecodeFrameData) {
            this.CRD = scanCodeMaskView;
            this.CRN = scanDecodeFrameData;
        }

        public final void run() {
            AppMethodBeat.i(170053);
            long currentTimeMillis = System.currentTimeMillis();
            this.CRD.CRm = ScanCodeMaskView.a(this.CRD, this.CRN);
            Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.j.AnonymousClass1 */
                final /* synthetic */ j CRO;

                {
                    this.CRO = r1;
                }

                public final void run() {
                    ViewPropertyAnimator alpha;
                    ViewPropertyAnimator duration;
                    AppMethodBeat.i(170052);
                    if (!this.CRO.CRD.CUN && this.CRO.CRD.CRm != null) {
                        Bitmap bitmap = this.CRO.CRD.CRm;
                        if (bitmap == null) {
                            p.hyc();
                        }
                        if (!bitmap.isRecycled()) {
                            ScanCodeMaskView.p(this.CRO.CRD).setImageBitmap(this.CRO.CRD.CRm);
                            ScanCodeMaskView.p(this.CRO.CRD).setVisibility(0);
                            ScanCodeMaskView.p(this.CRO.CRD).setAlpha(0.0f);
                            ViewPropertyAnimator animate = ScanCodeMaskView.p(this.CRO.CRD).animate();
                            if (animate != null) {
                                animate.cancel();
                            }
                            ViewPropertyAnimator animate2 = ScanCodeMaskView.p(this.CRO.CRD).animate();
                            if (!(animate2 == null || (alpha = animate2.alpha(1.0f)) == null || (duration = alpha.setDuration(200)) == null)) {
                                duration.start();
                                AppMethodBeat.o(170052);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(170052);
                }
            });
            AppMethodBeat.o(170053);
        }
    }

    private final Bitmap a(ScanDecodeFrameData scanDecodeFrameData) {
        byte[] bArr;
        Bitmap createBitmap;
        AppMethodBeat.i(170064);
        try {
            com.tencent.mm.plugin.scanner.a.a scanCamera = getScanCamera();
            if (scanCamera == null) {
                p.hyc();
            }
            int previewFormat = scanCamera.getPreviewFormat();
            com.tencent.mm.plugin.scanner.a.a scanCamera2 = getScanCamera();
            if (scanCamera2 == null) {
                p.hyc();
            }
            Point hkU = scanCamera2.hkU();
            if (!(scanDecodeFrameData == null || (bArr = scanDecodeFrameData.CDY) == null)) {
                Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", Integer.valueOf(bArr.length), Integer.valueOf(scanDecodeFrameData.width), Integer.valueOf(scanDecodeFrameData.height), Integer.valueOf(scanDecodeFrameData.sRI), Integer.valueOf(previewFormat));
                YuvImage yuvImage = new YuvImage(scanDecodeFrameData.CDY, previewFormat, hkU.x, hkU.y, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, hkU.x, hkU.y), 100, byteArrayOutputStream);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                if (decodeByteArray != null && !decodeByteArray.isRecycled()) {
                    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(decodeByteArray.getHeight()));
                    if (scanDecodeFrameData.sRI != 0) {
                        int i2 = scanDecodeFrameData.sRI;
                        int measuredWidth = getMeasuredWidth();
                        int measuredHeight = getMeasuredHeight();
                        if (decodeByteArray == null) {
                            AppMethodBeat.o(170064);
                            return null;
                        }
                        Log.i("MicroMsg.ScanCodeMaskView", "alvinlu rotateAndScaleBitmap rotation: %d, targetWidth: %d, targetHeight: %d", Integer.valueOf(i2), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                        Matrix matrix = new Matrix();
                        matrix.postRotate((float) i2);
                        boolean z = i2 % TXLiveConstants.RENDER_ROTATION_180 != 0;
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        int height2 = z ? decodeByteArray.getHeight() : decodeByteArray.getWidth();
                        int width2 = z ? decodeByteArray.getWidth() : decodeByteArray.getHeight();
                        if (!(measuredWidth == 0 || measuredHeight == 0)) {
                            float f2 = (1.0f * ((float) measuredWidth)) / ((float) measuredHeight);
                            if ((1.0f * ((float) height2)) / ((float) width2) > f2) {
                                width = (int) (((float) width2) * f2);
                                height = width2;
                            } else {
                                height = (int) (((float) height2) / f2);
                                width = height2;
                            }
                        }
                        int max = Math.max(0, (height2 - width) / 2);
                        int max2 = Math.max(0, (width2 - height) / 2);
                        Log.i("MicroMsg.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(max), Integer.valueOf(max2));
                        if (z) {
                            createBitmap = Bitmap.createBitmap(decodeByteArray, max2, max, height, width, matrix, true);
                        } else {
                            createBitmap = Bitmap.createBitmap(decodeByteArray, max, max2, width, height, matrix, true);
                        }
                        if ((!p.j(createBitmap, decodeByteArray)) && !decodeByteArray.isRecycled()) {
                            decodeByteArray.recycle();
                        }
                        AppMethodBeat.o(170064);
                        return createBitmap;
                    }
                    AppMethodBeat.o(170064);
                    return decodeByteArray;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanCodeMaskView", e2, "alvinluo getFrameBitmap exception", new Object[0]);
        }
        AppMethodBeat.o(170064);
        return null;
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final View getTargetSuccessMarkView() {
        AppMethodBeat.i(170065);
        if (this.CRr) {
            View view = (View) kotlin.a.j.L(this.CRn, this.CRu);
            AppMethodBeat.o(170065);
            return view;
        }
        View view2 = (View) kotlin.a.j.L(this.CRn, 0);
        AppMethodBeat.o(170065);
        return view2;
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void uc(boolean z) {
        AppMethodBeat.i(170066);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkLoading show: %b", Boolean.valueOf(z));
        if (z) {
            eRA();
        }
        AppMethodBeat.o(170066);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void eRz() {
        AppMethodBeat.i(240637);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowResultInfoView show: %b", Boolean.TRUE);
        eRA();
        AppMethodBeat.o(240637);
    }

    private final void eRA() {
        AppMethodBeat.i(240638);
        if (this.CRr) {
            View view = this.CRj;
            if (view == null) {
                p.btv("multiCodeBgMask");
            }
            view.setVisibility(8);
            this.CRs = false;
            Iterator<T> it = this.CRn.iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.0f);
            }
            eRx();
            eRy();
            TextView textView = this.CRk;
            if (textView == null) {
                p.btv("multiCodeTips");
            }
            com.tencent.mm.plugin.scanner.util.m.a(textView, 1.0f, 0.0f, 200, (Animator.AnimatorListener) null);
        }
        AppMethodBeat.o(240638);
    }

    public static final /* synthetic */ void l(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(170069);
        scanCodeMaskView.eRx();
        scanCodeMaskView.CRw = new c(scanCodeMaskView);
        scanCodeMaskView.CRv = new Timer();
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo initScaleAnimation period: %d", 3350L);
        Timer timer = scanCodeMaskView.CRv;
        if (timer != null) {
            timer.scheduleAtFixedRate(scanCodeMaskView.CRw, 0, 3350);
            AppMethodBeat.o(170069);
            return;
        }
        AppMethodBeat.o(170069);
    }

    public static final /* synthetic */ void m(ScanCodeMaskView scanCodeMaskView) {
        AppMethodBeat.i(170070);
        Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runScaleAnimation");
        scanCodeMaskView.WW(1);
        AppMethodBeat.o(170070);
    }

    public static final /* synthetic */ void a(ScanCodeMaskView scanCodeMaskView, Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(170072);
        scanCodeMaskView.a(0.8f, 1.0f, scanCodeMaskView.CRy, animatorListener);
        AppMethodBeat.o(170072);
    }
}
