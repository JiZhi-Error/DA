package com.tencent.mm.plugin.recordvideo.ui;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u0000 Ã\u00012\u00020\u00012\u00020\u0002:\bÃ\u0001Ä\u0001Å\u0001Æ\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u0001\u001a\u00020v2\u0007\u0010\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u0013\u0010\u0001\u001a\u0004\u0018\u00010Y2\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020vJ\u0007\u0010\u0001\u001a\u00020vJ\u0007\u0010\u0001\u001a\u00020vJ\t\u0010\u0001\u001a\u00020vH\u0014J\u0013\u0010\u0001\u001a\u00020<2\b\u0010\u0001\u001a\u00030 \u0001H\u0016J\u0013\u0010¡\u0001\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u0001H\u0014J/\u0010¢\u0001\u001a\u00020<2\b\u0010£\u0001\u001a\u00030 \u00012\b\u0010¤\u0001\u001a\u00030 \u00012\u0007\u0010¥\u0001\u001a\u00020\r2\u0007\u0010¦\u0001\u001a\u00020\rH\u0016J6\u0010§\u0001\u001a\u00020v2\u0007\u0010¨\u0001\u001a\u00020<2\u0007\u0010©\u0001\u001a\u00020\n2\u0007\u0010ª\u0001\u001a\u00020\n2\u0007\u0010«\u0001\u001a\u00020\n2\u0007\u0010¬\u0001\u001a\u00020\nH\u0014J\u0013\u0010­\u0001\u001a\u00020v2\b\u0010®\u0001\u001a\u00030 \u0001H\u0016J/\u0010¯\u0001\u001a\u00020<2\b\u0010\u0001\u001a\u00030 \u00012\b\u0010¤\u0001\u001a\u00030 \u00012\u0007\u0010°\u0001\u001a\u00020\r2\u0007\u0010±\u0001\u001a\u00020\rH\u0016J\u0013\u0010²\u0001\u001a\u00020v2\b\u0010®\u0001\u001a\u00030 \u0001H\u0016J\u0013\u0010³\u0001\u001a\u00020<2\b\u0010®\u0001\u001a\u00030 \u0001H\u0016J\u0013\u0010´\u0001\u001a\u00020<2\b\u0010\u0001\u001a\u00030 \u0001H\u0016J\u0007\u0010µ\u0001\u001a\u00020vJ\u0011\u0010¶\u0001\u001a\u00020v2\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010·\u0001\u001a\u00030¸\u00012\b\u0010¹\u0001\u001a\u00030º\u0001J\u001e\u0010»\u0001\u001a\u00020v2\u0007\u0010¼\u0001\u001a\u00020\n2\n\b\u0002\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0007\u0010¿\u0001\u001a\u00020vJ\u000f\u0010|\u001a\u00020v2\u0007\u0010À\u0001\u001a\u00020<J\u0007\u0010Á\u0001\u001a\u00020vJ\t\u0010Â\u0001\u001a\u00020vH\u0002R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u000fR\u001b\u0010\u001b\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001c\u0010\u000fR\u001b\u0010\u001e\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001f\u0010\u000fR\u001b\u0010!\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b\"\u0010\u000fR\u001b\u0010$\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b)\u0010&R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b8\u00109R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020QX\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0XX\u0004¢\u0006\u0004\n\u0002\u0010ZR\u000e\u0010[\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u00020BX\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0014\u0010_\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010>\"\u0004\bc\u0010@R\u001a\u0010d\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010>\"\u0004\be\u0010@R\u000e\u0010f\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R$\u0010g\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000f\"\u0004\bi\u0010jR$\u0010k\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u000f\"\u0004\bm\u0010jR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010t\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010uX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u000e\u0010{\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010|\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010>\"\u0004\b~\u0010@R)\u0010\u0001\u001a\u000202\u0006\u0010-\u001a\u00020@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\u0011\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010\u0001\u001a\u00020Q¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u000f\u0010\u0001\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Ç\u0001"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BLOCK_WIDTH", "", "getBLOCK_WIDTH", "()F", "BLOCK_WIDTH$delegate", "Lkotlin/Lazy;", "BOX_GIRD_WIDTH", "getBOX_GIRD_WIDTH", "BOX_GIRD_WIDTH$delegate", "BOX_LINE_WIDTH", "getBOX_LINE_WIDTH", "BOX_LINE_WIDTH$delegate", "BOX_PADDING", "getBOX_PADDING", "BOX_PADDING$delegate", "CORNER_LENGTH", "getCORNER_LENGTH", "CORNER_LENGTH$delegate", "CORNER_WIDTH", "getCORNER_WIDTH", "CORNER_WIDTH$delegate", "TOUCH_BLOCK_PADDING", "getTOUCH_BLOCK_PADDING", "TOUCH_BLOCK_PADDING$delegate", "_1A", "get_1A", "()I", "_1A$delegate", "_4A", "get_4A", "_4A$delegate", "bgAnimator", "Landroid/animation/ValueAnimator;", "value", "bgColor", "getBgColor", "setBgColor", "(I)V", "blockBottomPath", "Landroid/graphics/Path;", "blockBottomPath_1", "blockBottomPath_2", "blockDrawable", "Landroid/graphics/drawable/Drawable;", "getBlockDrawable", "()Landroid/graphics/drawable/Drawable;", "blockDrawable$delegate", "blockOutsideTouch", "", "getBlockOutsideTouch", "()Z", "setBlockOutsideTouch", "(Z)V", "blockPaint", "Landroid/graphics/Paint;", "blockTopPath", "blockTopPath_1", "blockTopPath_2", "borderAlpha", "borderAnimator", "borderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "getBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "setBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;)V", "bottomBlockPoint", "Landroid/graphics/PointF;", "bottomBlockRect", "Landroid/graphics/RectF;", "boxPaint", "boxRect", "getBoxRect", "()Landroid/graphics/RectF;", "cornerPaint", "cornerViews", "", "Landroid/view/View;", "[Landroid/view/View;", "grepBlockPaint", "gridLinePaint", "getGridLinePaint", "()Landroid/graphics/Paint;", "gridLinePath", "getGridLinePath", "()Landroid/graphics/Path;", "isBelongBottomBlock", "setBelongBottomBlock", "isBelongTopBlock", "setBelongTopBlock", "lastVisibilityRect", "limitMaxHeight", "getLimitMaxHeight", "setLimitMaxHeight", "(F)V", "limitMinHeight", "getLimitMinHeight", "setLimitMinHeight", "onOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "getOnOperationCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "setOnOperationCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;)V", "outsideTouckListener", "Lkotlin/Function0;", "", "getOutsideTouckListener", "()Lkotlin/jvm/functions/Function0;", "setOutsideTouckListener", "(Lkotlin/jvm/functions/Function0;)V", "paint", "showGridLine", "getShowGridLine", "setShowGridLine", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "getStyle", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "topBlockPoint", "topBlockRect", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "visibilityRect", "getVisibilityRect", "widgetRect", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "addCornerView", "view", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "drawCutBoxLine", "getCornerView", "hideBorder", "hideCornerView", "hideInvisible", "onDetachedFromWindow", "onDown", "event", "Landroid/view/MotionEvent;", "onDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", e.a.NAME, "e", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "removeAllCornerView", "removeCornerView", "rescaleCropFromSize", "Landroid/graphics/Rect;", "size", "Landroid/graphics/Point;", "showBorder", "alpha", "delay", "", "showCornerViews", "show", "showInvisible", "updateBorderRect", "Companion", "CornerStyle", "OnOperationCallback", "Style", "plugin-recordvideo_release"})
public class WxCropOperationLayout extends FrameLayout implements GestureDetector.OnGestureListener {
    public static final g BZw = new g((byte) 0);
    private final kotlin.f BYE = kotlin.g.ah(new c(this));
    private final kotlin.f BYF = kotlin.g.ah(new b(this));
    private final kotlin.f BYG = kotlin.g.ah(new f(this));
    private final kotlin.f BYH = kotlin.g.ah(new a(this));
    private final kotlin.f BYI = kotlin.g.ah(new d(this));
    private final kotlin.f BYJ = kotlin.g.ah(new e(this));
    private final kotlin.f BYK = kotlin.g.ah(new k(this));
    private final kotlin.f BYL = kotlin.g.ah(new l(this));
    private final kotlin.f BYM = kotlin.g.ah(new m(this));
    private final Path BYN = new Path();
    private final Path BYO = new Path();
    private final Path BYP = new Path();
    private final Path BYQ = new Path();
    private final Path BYR = new Path();
    private final Path BYS = new Path();
    private final Path BYT = new Path();
    private final Paint BYU = new Paint();
    private final Paint BYV = new Paint();
    private final Paint BYW = new Paint();
    private final Paint BYX = new Paint();
    private final Paint BYY = new Paint();
    private final RectF BYZ = new RectF();
    private final RectF BZa = new RectF();
    public int BZb;
    private i BZc;
    private kotlin.g.a.a<x> BZd;
    private boolean BZe;
    private final kotlin.f BZf = kotlin.g.ah(new n(this));
    private final View[] BZg;
    public boolean BZh;
    private ValueAnimator BZi;
    private final RectF BZj;
    private float BZk;
    private float BZl;
    private final RectF BZm;
    private final RectF BZn;
    private final PorterDuffXfermode BZo;
    protected boolean BZp;
    protected boolean BZq;
    private com.tencent.mm.ui.widget.cropview.b BZr;
    public ValueAnimator BZs;
    private final RectF BZt;
    private final PointF BZu;
    private final PointF BZv;
    private int bgColor;
    private final Paint paint;
    private final kotlin.f wbH = kotlin.g.ah(new s(this));
    private j xmW = j.RECT_ADJUST;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-recordvideo_release"})
    public interface i {
        void e(RectF rectF);

        void pA(boolean z);

        void pz(boolean z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "", "(Ljava/lang/String;I)V", "CIRCLE", "RECT_ADJUST", "RECT_HARD", "RECT_LINE_HARD", "plugin-recordvideo_release"})
    public enum j {
        CIRCLE,
        RECT_ADJUST,
        RECT_HARD,
        RECT_LINE_HARD;

        static {
            AppMethodBeat.i(237521);
            AppMethodBeat.o(237521);
        }

        public static j valueOf(String str) {
            AppMethodBeat.i(237523);
            j jVar = (j) Enum.valueOf(j.class, str);
            AppMethodBeat.o(237523);
            return jVar;
        }
    }

    static {
        AppMethodBeat.i(237571);
        AppMethodBeat.o(237571);
    }

    private final float getBLOCK_WIDTH() {
        AppMethodBeat.i(237536);
        float floatValue = ((Number) this.BYH.getValue()).floatValue();
        AppMethodBeat.o(237536);
        return floatValue;
    }

    private final float getBOX_GIRD_WIDTH() {
        AppMethodBeat.i(237534);
        float floatValue = ((Number) this.BYF.getValue()).floatValue();
        AppMethodBeat.o(237534);
        return floatValue;
    }

    private final float getBOX_LINE_WIDTH() {
        AppMethodBeat.i(237533);
        float floatValue = ((Number) this.BYE.getValue()).floatValue();
        AppMethodBeat.o(237533);
        return floatValue;
    }

    private final float getBOX_PADDING() {
        AppMethodBeat.i(237537);
        float floatValue = ((Number) this.BYI.getValue()).floatValue();
        AppMethodBeat.o(237537);
        return floatValue;
    }

    private final Drawable getBlockDrawable() {
        AppMethodBeat.i(237544);
        Drawable drawable = (Drawable) this.BZf.getValue();
        AppMethodBeat.o(237544);
        return drawable;
    }

    private final float getCORNER_LENGTH() {
        AppMethodBeat.i(237538);
        float floatValue = ((Number) this.BYJ.getValue()).floatValue();
        AppMethodBeat.o(237538);
        return floatValue;
    }

    private final float getCORNER_WIDTH() {
        AppMethodBeat.i(237535);
        float floatValue = ((Number) this.BYG.getValue()).floatValue();
        AppMethodBeat.o(237535);
        return floatValue;
    }

    private final float getTOUCH_BLOCK_PADDING() {
        AppMethodBeat.i(237539);
        float floatValue = ((Number) this.BYK.getValue()).floatValue();
        AppMethodBeat.o(237539);
        return floatValue;
    }

    private final GestureDetector getTouchDetector() {
        AppMethodBeat.i(237542);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(237542);
        return gestureDetector;
    }

    private final int get_1A() {
        AppMethodBeat.i(237540);
        int intValue = ((Number) this.BYL.getValue()).intValue();
        AppMethodBeat.o(237540);
        return intValue;
    }

    private final int get_4A() {
        AppMethodBeat.i(237541);
        int intValue = ((Number) this.BYM.getValue()).intValue();
        AppMethodBeat.o(237541);
        return intValue;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Companion;", "", "()V", "BORDER_DELAY", "", "BORDER_DURATION", "TAG", "", "plugin-recordvideo_release"})
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$CornerStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "TOP_LEFT_OUT", "TOP_RIGHT_OUT", "BOTTOM_LEFT_OUT", "BOTTOM_RIGHT_OUT", "plugin-recordvideo_release"})
    public enum h {
        TOP_LEFT(0),
        TOP_RIGHT(1),
        BOTTOM_LEFT(2),
        BOTTOM_RIGHT(3),
        TOP_LEFT_OUT(4),
        TOP_RIGHT_OUT(5),
        BOTTOM_LEFT_OUT(6),
        BOTTOM_RIGHT_OUT(7);
        
        final int value;

        public static h valueOf(String str) {
            AppMethodBeat.i(237520);
            h hVar = (h) Enum.valueOf(h.class, str);
            AppMethodBeat.o(237520);
            return hVar;
        }

        private h(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(237518);
            AppMethodBeat.o(237518);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxCropOperationLayout(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(237568);
        View[] viewArr = new View[8];
        for (int i2 = 0; i2 < 8; i2++) {
            viewArr[i2] = null;
        }
        this.BZg = viewArr;
        this.BZh = true;
        setBackgroundColor(0);
        this.BYU.setColor(-1);
        this.BYU.setStrokeWidth(getBOX_LINE_WIDTH());
        this.BYU.setStyle(Paint.Style.STROKE);
        this.BYU.setAntiAlias(true);
        this.BYV.set(this.BYU);
        this.BYV.setStrokeWidth(getBOX_GIRD_WIDTH());
        this.BYW.set(this.BYU);
        this.BYW.setStrokeWidth(getCORNER_WIDTH());
        this.BYX.set(this.BYU);
        this.BYX.setStrokeCap(Paint.Cap.ROUND);
        this.BYX.setStrokeWidth(getBLOCK_WIDTH());
        this.BYY.set(this.BYU);
        this.BYY.setStrokeCap(Paint.Cap.ROUND);
        this.BYY.setStrokeWidth(getBOX_GIRD_WIDTH());
        this.BYY.setColor(-7829368);
        this.bgColor = Color.parseColor("#bf232323");
        Paint paint2 = new Paint();
        paint2.setDither(false);
        paint2.setColor(this.bgColor);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setFilterBitmap(true);
        this.paint = paint2;
        this.BZj = new RectF();
        this.BZm = new RectF();
        this.BZn = new RectF();
        this.BZo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.BZt = new RectF();
        this.BZu = new PointF();
        this.BZv = new PointF();
        AppMethodBeat.o(237568);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxCropOperationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(237569);
        View[] viewArr = new View[8];
        for (int i2 = 0; i2 < 8; i2++) {
            viewArr[i2] = null;
        }
        this.BZg = viewArr;
        this.BZh = true;
        setBackgroundColor(0);
        this.BYU.setColor(-1);
        this.BYU.setStrokeWidth(getBOX_LINE_WIDTH());
        this.BYU.setStyle(Paint.Style.STROKE);
        this.BYU.setAntiAlias(true);
        this.BYV.set(this.BYU);
        this.BYV.setStrokeWidth(getBOX_GIRD_WIDTH());
        this.BYW.set(this.BYU);
        this.BYW.setStrokeWidth(getCORNER_WIDTH());
        this.BYX.set(this.BYU);
        this.BYX.setStrokeCap(Paint.Cap.ROUND);
        this.BYX.setStrokeWidth(getBLOCK_WIDTH());
        this.BYY.set(this.BYU);
        this.BYY.setStrokeCap(Paint.Cap.ROUND);
        this.BYY.setStrokeWidth(getBOX_GIRD_WIDTH());
        this.BYY.setColor(-7829368);
        this.bgColor = Color.parseColor("#bf232323");
        Paint paint2 = new Paint();
        paint2.setDither(false);
        paint2.setColor(this.bgColor);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setFilterBitmap(true);
        this.paint = paint2;
        this.BZj = new RectF();
        this.BZm = new RectF();
        this.BZn = new RectF();
        this.BZo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.BZt = new RectF();
        this.BZu = new PointF();
        this.BZv = new PointF();
        AppMethodBeat.o(237569);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxCropOperationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(237570);
        View[] viewArr = new View[8];
        for (int i3 = 0; i3 < 8; i3++) {
            viewArr[i3] = null;
        }
        this.BZg = viewArr;
        this.BZh = true;
        setBackgroundColor(0);
        this.BYU.setColor(-1);
        this.BYU.setStrokeWidth(getBOX_LINE_WIDTH());
        this.BYU.setStyle(Paint.Style.STROKE);
        this.BYU.setAntiAlias(true);
        this.BYV.set(this.BYU);
        this.BYV.setStrokeWidth(getBOX_GIRD_WIDTH());
        this.BYW.set(this.BYU);
        this.BYW.setStrokeWidth(getCORNER_WIDTH());
        this.BYX.set(this.BYU);
        this.BYX.setStrokeCap(Paint.Cap.ROUND);
        this.BYX.setStrokeWidth(getBLOCK_WIDTH());
        this.BYY.set(this.BYU);
        this.BYY.setStrokeCap(Paint.Cap.ROUND);
        this.BYY.setStrokeWidth(getBOX_GIRD_WIDTH());
        this.BYY.setColor(-7829368);
        this.bgColor = Color.parseColor("#bf232323");
        Paint paint2 = new Paint();
        paint2.setDither(false);
        paint2.setColor(this.bgColor);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setFilterBitmap(true);
        this.paint = paint2;
        this.BZj = new RectF();
        this.BZm = new RectF();
        this.BZn = new RectF();
        this.BZo = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.BZt = new RectF();
        this.BZu = new PointF();
        this.BZv = new PointF();
        AppMethodBeat.o(237570);
    }

    /* access modifiers changed from: protected */
    public final Path getGridLinePath() {
        return this.BYN;
    }

    /* access modifiers changed from: protected */
    public final Paint getGridLinePaint() {
        return this.BYV;
    }

    public final i getOnOperationCallback() {
        return this.BZc;
    }

    public final void setOnOperationCallback(i iVar) {
        this.BZc = iVar;
    }

    public final kotlin.g.a.a<x> getOutsideTouckListener() {
        return this.BZd;
    }

    public final void setOutsideTouckListener(kotlin.g.a.a<x> aVar) {
        this.BZd = aVar;
    }

    public final j getStyle() {
        return this.xmW;
    }

    public final void setStyle(j jVar) {
        AppMethodBeat.i(237543);
        kotlin.g.b.p.h(jVar, "value");
        this.xmW = jVar;
        postInvalidate();
        AppMethodBeat.o(237543);
    }

    public final boolean getBlockOutsideTouch() {
        return this.BZe;
    }

    public final void setBlockOutsideTouch(boolean z) {
        this.BZe = z;
    }

    /* access modifiers changed from: protected */
    public final boolean getShowGridLine() {
        return this.BZh;
    }

    /* access modifiers changed from: protected */
    public final void setShowGridLine(boolean z) {
        this.BZh = z;
    }

    public final void a(View view, h hVar) {
        AppMethodBeat.i(237545);
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(hVar, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        View view2 = this.BZg[hVar.value];
        if (view2 != null) {
            removeView(view2);
        }
        this.BZg[hVar.value] = view;
        addView(view);
        AppMethodBeat.o(237545);
    }

    public final void eLC() {
        AppMethodBeat.i(237546);
        View[] viewArr = this.BZg;
        for (View view : viewArr) {
            if (view != null) {
                removeView(view);
            }
        }
        AppMethodBeat.o(237546);
    }

    public final void a(h hVar) {
        AppMethodBeat.i(237547);
        kotlin.g.b.p.h(hVar, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        View view = this.BZg[hVar.value];
        if (view != null) {
            removeView(view);
        }
        this.BZg[hVar.value] = null;
        AppMethodBeat.o(237547);
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int i2) {
        AppMethodBeat.i(237548);
        this.paint.setColor(i2);
        this.bgColor = i2;
        AppMethodBeat.o(237548);
    }

    public final RectF getVisibilityRect() {
        return this.BZj;
    }

    public final float getLimitMaxHeight() {
        return this.BZk;
    }

    public final void setLimitMaxHeight(float f2) {
        AppMethodBeat.i(237549);
        this.BZk = f2;
        postInvalidate();
        AppMethodBeat.o(237549);
    }

    public final float getLimitMinHeight() {
        return this.BZl;
    }

    public final void setLimitMinHeight(float f2) {
        AppMethodBeat.i(237550);
        this.BZl = f2;
        postInvalidate();
        AppMethodBeat.o(237550);
    }

    /* access modifiers changed from: protected */
    public final RectF getBoxRect() {
        return this.BZn;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(237551);
        if (!z) {
            super.onLayout(z, i2, i3, i4, i5);
            AppMethodBeat.o(237551);
            return;
        }
        ay(255, 500);
        this.BZm.set((float) i2, (float) i3, (float) i4, (float) i5);
        if (this.BZj.isEmpty()) {
            this.BZj.set((float) i2, (float) ((getHeight() / 4) + i3), (float) i4, (float) (i5 - (getHeight() / 4)));
        }
        if (this.BZk == 0.0f) {
            setLimitMaxHeight(this.BZm.height() / 2.0f);
        }
        if (this.BZl == 0.0f) {
            setLimitMinHeight(this.BZm.height() / 4.0f);
        }
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(237551);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(237552);
        kotlin.g.b.p.h(canvas, "canvas");
        int saveLayer = canvas.saveLayer(this.BZm, null);
        canvas.drawRect(this.BZm, this.paint);
        this.paint.setXfermode(this.BZo);
        if (j.CIRCLE == this.xmW) {
            canvas.drawCircle(this.BZj.centerX(), this.BZj.centerY(), Math.min(this.BZj.width(), this.BZj.height()) / 2.0f, this.paint);
        } else if (j.RECT_ADJUST == this.xmW || j.RECT_HARD == this.xmW || j.RECT_LINE_HARD == this.xmW) {
            canvas.drawRect(this.BZj, this.paint);
        }
        this.paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        if (!(this.xmW == j.CIRCLE || this.xmW == j.RECT_HARD || kotlin.g.b.p.j(this.BZj, this.BZt))) {
            this.BZt.set(this.BZj);
            i iVar = this.BZc;
            if (iVar != null) {
                iVar.e(this.BZj);
            }
            this.BZn.set(this.BZj);
            this.BZn.set(this.BZj.left + getBOX_PADDING(), this.BZj.top + getBOX_PADDING(), this.BZj.right - getBOX_PADDING(), this.BZj.bottom - getBOX_PADDING());
            float width = this.BZn.left + (this.BZn.width() / 2.0f);
            float f2 = this.BZn.bottom;
            this.BZa.set(width - (getTOUCH_BLOCK_PADDING() * 2.0f), f2 - (getTOUCH_BLOCK_PADDING() * 1.5f), (getTOUCH_BLOCK_PADDING() * 2.0f) + width, f2 + (getTOUCH_BLOCK_PADDING() * 1.5f));
            this.BZu.set(((this.BZn.width() / 2.0f) - ((float) (get_4A() / 2))) + this.BZj.left, this.BZn.top - ((float) (get_1A() / 2)));
            this.BZv.set(((this.BZn.width() / 2.0f) - ((float) (get_4A() / 2))) + this.BZj.left, this.BZn.bottom - ((float) (get_1A() / 2)));
            float f3 = this.BZn.top;
            this.BYZ.set(width - (getTOUCH_BLOCK_PADDING() * 2.0f), f3 - (getTOUCH_BLOCK_PADDING() * 1.5f), width + (getTOUCH_BLOCK_PADDING() * 2.0f), f3 + (getTOUCH_BLOCK_PADDING() * 1.5f));
            this.BYN.reset();
            for (int i2 = 1; i2 <= 2; i2++) {
                this.BYN.moveTo(this.BZn.left + ((this.BZn.width() / 3.0f) * ((float) i2)), this.BZn.top);
                this.BYN.lineTo(this.BZn.left + ((this.BZn.width() / 3.0f) * ((float) i2)), this.BZn.bottom);
                this.BYN.moveTo(this.BZn.left, this.BZn.top + ((this.BZn.height() / 3.0f) * ((float) i2)));
                this.BYN.lineTo(this.BZn.right, this.BZn.top + ((this.BZn.height() / 3.0f) * ((float) i2)));
            }
        }
        u(canvas);
        AppMethodBeat.o(237552);
    }

    /* access modifiers changed from: protected */
    public final void setBelongTopBlock(boolean z) {
        this.BZp = z;
    }

    /* access modifiers changed from: protected */
    public final void setBelongBottomBlock(boolean z) {
        this.BZq = z;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(237553);
        kotlin.g.b.p.h(motionEvent, "event");
        kotlin.g.b.p.h(motionEvent2, "e2");
        new StringBuilder("[onScroll] event=").append(motionEvent);
        if (this.BZp) {
            this.BZj.top -= f3;
            this.BZj.bottom += f3;
        }
        if (this.BZq) {
            this.BZj.top += f3;
            this.BZj.bottom -= f3;
        }
        if (this.BZj.height() > this.BZk) {
            float height = this.BZk - this.BZj.height();
            this.BZj.top -= height / 2.0f;
            RectF rectF = this.BZj;
            rectF.bottom = (height / 2.0f) + rectF.bottom;
        } else if (this.BZj.height() < this.BZl) {
            float height2 = this.BZl - this.BZj.height();
            this.BZj.top -= height2 / 2.0f;
            RectF rectF2 = this.BZj;
            rectF2.bottom = (height2 / 2.0f) + rectF2.bottom;
        }
        postInvalidate();
        if (this.BZq || this.BZp) {
            AppMethodBeat.o(237553);
            return true;
        }
        AppMethodBeat.o(237553);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(237554);
        kotlin.g.b.p.h(motionEvent, "event");
        if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && (this.BZp || this.BZq)) {
            ay(0, 1000);
            i iVar = this.BZc;
            if (iVar != null) {
                iVar.pA(this.BZp);
            }
        }
        GestureDetector touchDetector = getTouchDetector();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, bl.axQ(), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(touchDetector, touchDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(237554);
        return a2;
    }

    public final com.tencent.mm.ui.widget.cropview.b getBorderVisibilityCallback() {
        return this.BZr;
    }

    public final void setBorderVisibilityCallback(com.tencent.mm.ui.widget.cropview.b bVar) {
        this.BZr = bVar;
    }

    public static /* synthetic */ void a(WxCropOperationLayout wxCropOperationLayout) {
        AppMethodBeat.i(237556);
        wxCropOperationLayout.ay(0, 1000);
        AppMethodBeat.o(237556);
    }

    public void ay(int i2, long j2) {
        ValueAnimator valueAnimator;
        WxCropOperationLayout wxCropOperationLayout;
        AppMethodBeat.i(237555);
        ValueAnimator valueAnimator2 = this.BZs;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
        }
        new StringBuilder("[animBorder] alpha=").append(i2).append(" delay=").append(j2);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("alpha", this.BZb, i2));
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.addUpdateListener(new p(this, j2));
            ofPropertyValuesHolder.setDuration(300L);
            ofPropertyValuesHolder.setStartDelay(j2);
            ofPropertyValuesHolder.start();
            valueAnimator = ofPropertyValuesHolder;
            wxCropOperationLayout = this;
        } else {
            valueAnimator = null;
            wxCropOperationLayout = this;
        }
        wxCropOperationLayout.BZs = valueAnimator;
        if (i2 == 0) {
            eLD();
            AppMethodBeat.o(237555);
            return;
        }
        eLE();
        AppMethodBeat.o(237555);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showBorder$1$1"})
    public static final class p implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ long BZM;
        final /* synthetic */ WxCropOperationLayout BZx;

        p(WxCropOperationLayout wxCropOperationLayout, long j2) {
            this.BZx = wxCropOperationLayout;
            this.BZM = j2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(237529);
            kotlin.g.b.p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(237529);
                throw tVar;
            }
            this.BZx.BZb = ((Integer) animatedValue).intValue();
            this.BZx.invalidate();
            AppMethodBeat.o(237529);
        }
    }

    public final void eLD() {
        AppMethodBeat.i(237557);
        this.BZb = 255;
        Context context = getContext();
        kotlin.g.b.p.g(context, "context");
        float dimension = context.getResources().getDimension(R.dimen.cb);
        View[] viewArr = this.BZg;
        int i2 = 0;
        int length = viewArr.length;
        int i3 = 0;
        while (i3 < length) {
            View view = viewArr[i3];
            int i4 = i2 + 1;
            if (view != null) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
                view.animate().setStartDelay(300).withStartAction(new q(view, i2, view, this, dimension)).alpha(1.0f).setDuration(300).start();
            }
            i3++;
            i2 = i4;
        }
        com.tencent.mm.ui.widget.cropview.b bVar = this.BZr;
        if (bVar != null) {
            bVar.Df(true);
            AppMethodBeat.o(237557);
            return;
        }
        AppMethodBeat.o(237557);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showCornerViews$1$1$1", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$$special$$inlined$let$lambda$1"})
    public static final class q implements Runnable {
        final /* synthetic */ float BZN;
        final /* synthetic */ WxCropOperationLayout BZx;
        final /* synthetic */ View tBN;
        final /* synthetic */ View tzy;
        final /* synthetic */ int vLN;

        q(View view, int i2, View view2, WxCropOperationLayout wxCropOperationLayout, float f2) {
            this.tzy = view;
            this.vLN = i2;
            this.tBN = view2;
            this.BZx = wxCropOperationLayout;
            this.BZN = f2;
        }

        public final void run() {
            AppMethodBeat.i(237530);
            int i2 = this.vLN;
            if (i2 == h.TOP_LEFT.value) {
                this.tzy.setTranslationY(this.BZx.getBoxRect().top + this.BZN);
                this.tzy.setTranslationX(this.BZx.getBoxRect().left + this.BZN);
                AppMethodBeat.o(237530);
            } else if (i2 == h.TOP_RIGHT.value) {
                this.tzy.setTranslationY(this.BZx.getBoxRect().top + this.BZN);
                this.tzy.setTranslationX((this.BZx.getBoxRect().right - this.BZN) - ((float) this.tzy.getWidth()));
                AppMethodBeat.o(237530);
            } else if (i2 == h.BOTTOM_LEFT.value) {
                this.tzy.setTranslationY((this.BZx.getBoxRect().bottom - this.BZN) - ((float) this.tBN.getHeight()));
                this.tzy.setTranslationX(this.BZx.getBoxRect().left + this.BZN);
                AppMethodBeat.o(237530);
            } else if (i2 == h.BOTTOM_RIGHT.value) {
                this.tzy.setTranslationY((this.BZx.getBoxRect().bottom - this.BZN) - ((float) this.tBN.getHeight()));
                this.tzy.setTranslationX((this.BZx.getBoxRect().right - this.BZN) - ((float) this.tzy.getWidth()));
                AppMethodBeat.o(237530);
            } else if (i2 == h.TOP_LEFT_OUT.value) {
                this.tzy.setTranslationY((this.BZx.getBoxRect().top - this.BZN) - ((float) this.tBN.getHeight()));
                this.tzy.setTranslationX(this.BZx.getBoxRect().left + this.BZN);
                AppMethodBeat.o(237530);
            } else if (i2 == h.TOP_RIGHT_OUT.value) {
                this.tzy.setTranslationY((this.BZx.getBoxRect().top - this.BZN) - ((float) this.tBN.getHeight()));
                this.tzy.setTranslationX((this.BZx.getBoxRect().right - this.BZN) - ((float) this.tzy.getWidth()));
                AppMethodBeat.o(237530);
            } else if (i2 == h.BOTTOM_LEFT_OUT.value) {
                this.tzy.setTranslationY(this.BZx.getBoxRect().bottom + this.BZN);
                this.tzy.setTranslationX(this.BZx.getBoxRect().left + this.BZN);
                AppMethodBeat.o(237530);
            } else {
                if (i2 == h.BOTTOM_RIGHT_OUT.value) {
                    this.tzy.setTranslationY(this.BZx.getBoxRect().bottom + this.BZN);
                    this.tzy.setTranslationX((this.BZx.getBoxRect().right - this.BZN) - ((float) this.tzy.getWidth()));
                }
                AppMethodBeat.o(237530);
            }
        }
    }

    private void eLE() {
        AppMethodBeat.i(237558);
        View[] viewArr = this.BZg;
        for (View view : viewArr) {
            if (view != null) {
                view.setVisibility(8);
            }
        }
        com.tencent.mm.ui.widget.cropview.b bVar = this.BZr;
        if (bVar != null) {
            bVar.Df(false);
            AppMethodBeat.o(237558);
            return;
        }
        AppMethodBeat.o(237558);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(237559);
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.BZs;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.BZi;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            AppMethodBeat.o(237559);
            return;
        }
        AppMethodBeat.o(237559);
    }

    /* access modifiers changed from: protected */
    public void u(Canvas canvas) {
        AppMethodBeat.i(237560);
        kotlin.g.b.p.h(canvas, "canvas");
        if (this.xmW == j.RECT_ADJUST || this.xmW == j.RECT_LINE_HARD) {
            this.BYV.setAlpha(this.BZb);
            this.BYU.setAlpha(this.BZb);
            if (this.BZh) {
                canvas.drawPath(this.BYN, this.BYV);
            }
            canvas.drawRect(this.BZn, this.BYV);
            if (this.xmW == j.RECT_ADJUST) {
                canvas.save();
                canvas.translate(this.BZv.x, this.BZv.y);
                if (getBlockDrawable() instanceof BitmapDrawable) {
                    getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
                    getBlockDrawable().draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate(this.BZu.x, this.BZu.y);
                if (getBlockDrawable() instanceof BitmapDrawable) {
                    getBlockDrawable().setBounds(0, 0, get_4A(), get_1A());
                    getBlockDrawable().draw(canvas);
                }
                canvas.restore();
            }
        }
        AppMethodBeat.o(237560);
    }

    public void onShowPress(MotionEvent motionEvent) {
        AppMethodBeat.i(237561);
        kotlin.g.b.p.h(motionEvent, "e");
        AppMethodBeat.o(237561);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(237562);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        kotlin.g.b.p.h(motionEvent, "e");
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(237562);
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(237563);
        kotlin.g.b.p.h(motionEvent, "event");
        if (!this.BZj.contains(motionEvent.getX(), motionEvent.getY()) && (aVar = this.BZd) != null) {
            aVar.invoke();
        }
        if (this.xmW == j.RECT_ADJUST) {
            this.BZq = false;
            this.BZp = false;
            if (this.BYZ.contains(motionEvent.getX(), motionEvent.getY())) {
                this.BZp = true;
                i iVar = this.BZc;
                if (iVar != null) {
                    iVar.pz(true);
                }
            } else if (this.BZa.contains(motionEvent.getX(), motionEvent.getY())) {
                this.BZq = true;
                i iVar2 = this.BZc;
                if (iVar2 != null) {
                    iVar2.pz(false);
                }
            }
            if (this.BZp || this.BZq) {
                ay(255, 0);
            }
            if (this.BZp || this.BZq || (this.BZe && !this.BZj.contains(motionEvent.getX(), motionEvent.getY()))) {
                AppMethodBeat.o(237563);
                return true;
            }
            AppMethodBeat.o(237563);
            return false;
        }
        AppMethodBeat.o(237563);
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(237564);
        kotlin.g.b.p.h(motionEvent, "e1");
        kotlin.g.b.p.h(motionEvent2, "e2");
        AppMethodBeat.o(237564);
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(237565);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        kotlin.g.b.p.h(motionEvent, "e");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(237565);
    }

    public final void eLF() {
        AppMethodBeat.i(237566);
        ValueAnimator valueAnimator = this.BZi;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofArgb = ValueAnimator.ofArgb(this.bgColor, -14474461);
        ofArgb.addUpdateListener(new o(this));
        ofArgb.start();
        this.BZi = ofArgb;
        AppMethodBeat.o(237566);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$hideInvisible$1$1"})
    static final class o implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ WxCropOperationLayout BZx;

        o(WxCropOperationLayout wxCropOperationLayout) {
            this.BZx = wxCropOperationLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(237528);
            WxCropOperationLayout wxCropOperationLayout = this.BZx;
            kotlin.g.b.p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(237528);
                throw tVar;
            }
            wxCropOperationLayout.setBgColor(((Integer) animatedValue).intValue());
            this.BZx.invalidate();
            AppMethodBeat.o(237528);
        }
    }

    public final void eLG() {
        AppMethodBeat.i(237567);
        ValueAnimator valueAnimator = this.BZi;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofArgb = ValueAnimator.ofArgb(this.bgColor, -1088216285);
        ofArgb.addUpdateListener(new r(this));
        ofArgb.start();
        this.BZi = ofArgb;
        AppMethodBeat.o(237567);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$showInvisible$1$1"})
    static final class r implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ WxCropOperationLayout BZx;

        r(WxCropOperationLayout wxCropOperationLayout) {
            this.BZx = wxCropOperationLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(237531);
            WxCropOperationLayout wxCropOperationLayout = this.BZx;
            kotlin.g.b.p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(237531);
                throw tVar;
            }
            wxCropOperationLayout.setBgColor(((Integer) animatedValue).intValue());
            this.BZx.invalidate();
            AppMethodBeat.o(237531);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237514);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.ts));
            AppMethodBeat.o(237514);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237513);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tr));
            AppMethodBeat.o(237513);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237517);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tq));
            AppMethodBeat.o(237517);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237512);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.to));
            AppMethodBeat.o(237512);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237515);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tt));
            AppMethodBeat.o(237515);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237516);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.tp));
            AppMethodBeat.o(237516);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<Float> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(237524);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.amy));
            AppMethodBeat.o(237524);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(237525);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Integer valueOf = Integer.valueOf((int) (context.getResources().getDimension(R.dimen.ct) * 1.2f));
            AppMethodBeat.o(237525);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(237526);
            Context context = this.BZx.getContext();
            kotlin.g.b.p.g(context, "context");
            Integer valueOf = Integer.valueOf((int) context.getResources().getDimension(R.dimen.ci));
            AppMethodBeat.o(237526);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(237532);
            GestureDetector gestureDetector = new GestureDetector(this.BZx.getContext(), this.BZx);
            AppMethodBeat.o(237532);
            return gestureDetector;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<Drawable> {
        final /* synthetic */ WxCropOperationLayout BZx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(WxCropOperationLayout wxCropOperationLayout) {
            super(0);
            this.BZx = wxCropOperationLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Drawable invoke() {
            AppMethodBeat.i(237527);
            Drawable drawable = this.BZx.getResources().getDrawable(R.drawable.ja);
            AppMethodBeat.o(237527);
            return drawable;
        }
    }
}
