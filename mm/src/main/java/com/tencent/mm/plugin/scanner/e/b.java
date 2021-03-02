package com.tencent.mm.plugin.scanner.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.scanner.box.ScanOCRDialogBackgroundOpView;
import com.tencent.mm.plugin.scanner.box.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\n'\u0018\u0000 |2\u00020\u0001:\u0003{|}B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010?\u001a\u00020@2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020>H\u0016J\b\u0010E\u001a\u00020@H\u0002J\b\u0010F\u001a\u00020!H\u0002J4\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\f\u0010J\u001a\b\u0012\u0004\u0012\u00020@0K2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020@0KH\u0002J\u0018\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020!H\u0002J\u0010\u0010R\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020!H\u0002J\b\u0010S\u001a\u00020\bH\u0002J\b\u0010T\u001a\u00020\bH\u0002J\b\u0010Q\u001a\u00020!H\u0002J\u0010\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020\bH\u0002J\b\u0010W\u001a\u00020!H\u0016J\u0012\u0010X\u001a\u00020@2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0012\u0010[\u001a\u00020!2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u0018\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J\u0010\u0010`\u001a\u00020@2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u0010\u0010a\u001a\u00020@2\u0006\u0010b\u001a\u00020\bH\u0002J\u0018\u0010c\u001a\u00020@2\u0006\u0010d\u001a\u00020\u00112\u0006\u0010e\u001a\u00020\u0011H\u0002J\b\u0010f\u001a\u00020@H\u0016J\b\u0010g\u001a\u00020@H\u0002J\u0010\u0010h\u001a\u00020@2\u0006\u0010i\u001a\u00020!H\u0002J\u0010\u0010j\u001a\u00020@2\u0006\u0010k\u001a\u00020!H\u0002J\u0010\u0010l\u001a\u00020@2\u0006\u0010m\u001a\u00020nH\u0002J\u0018\u0010o\u001a\u00020@2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0002J&\u0010t\u001a\u00020>2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010u\u001a\u0004\u0018\u000100H\u0016J\b\u0010v\u001a\u00020@H\u0002J \u0010w\u001a\u00020@2\u0006\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u00112\u0006\u0010z\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animatingInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$AnimatingZoomInfo;", "animationType", "", "backgroundOpListener", "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1;", "backgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "currentImageView", "Landroid/view/View;", "currentZoomScale", "", "currentZoomState", "currentZooming", "dialogEndOffsetY", "dialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "dialogStartOffsetY", "gallery", "Lcom/tencent/mm/ui/base/MMViewPager;", "galleryHeight", "galleryWidth", "imageViewDismissStartInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$ImageViewTransformInfo;", "imageViewShowEndInfo", "imageViewShowStartInfo", "isLongImage", "", "isTouchHandledByBackground", "isTouchMoved", "isUploadFinish", "leftRightPadding", "mBackgroundTouchListener", "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1;", "mBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "mBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "mImageOCRListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "mOcrResultCallback", "Lcom/tencent/mm/plugin/scanner/api/ocr/ImageOcrResultCallback;", "matrix", "Landroid/graphics/Matrix;", "onScaleChangedListener", "Lcom/tencent/mm/ui/base/IZoomableImageView$ZoomScaleChangedListener;", "scale", "Landroid/graphics/PointF;", "showDefaultScale", "showDoubleScale", "showParams", "Lcom/tencent/mm/plugin/scanner/api/ScanBoxDialogShowParams;", "statusBarHeight", "translation", "uploadSessionId", "", "attachGallery", "", "attachImageView", "image", "cancelImageOCR", "sessionId", "checkMinScale", "checkNetWorkConnected", "checkZoomStateChanged", "currentScale", "scaleRate", "zoomOut", "Lkotlin/Function0;", "zoomIn", "doUpdateGalleryHeight", "width", "height", "getAnimationType", "isLandscape", "getDialogHeightRate", "getShowGalleryHeight", "getShowGalleryWidth", "isLocalError", "errCode", "isShowingOCRResult", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onError", "errType", "onZoomScaleChanged", "onZoomStateChanged", "zoomState", "processZoom", "centerX", "centerY", "release", "resetWhenTouchUp", "setCanRefresh", "canRefresh", "showBackgroundOpView", "show", "showErrorTips", "errTips", "", "showImageOCRResult", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "startImageOCR", "callback", "updateCustomScaleRate", "updateGalleryHeight", "dialogState", "offsetY", "factor", "AnimatingZoomInfo", "Companion", "ImageViewTransformInfo", "plugin-scan_release"})
public final class b implements com.tencent.mm.plugin.scanner.api.a.a {
    public static final C1670b CIC = new C1670b((byte) 0);
    private com.tencent.mm.plugin.scanner.box.b CBr;
    private com.tencent.mm.plugin.scanner.api.d CHV;
    private View CHW;
    private int CHX;
    private int CHY;
    private int CHZ;
    private final g CIA = new g(this);
    private final g.a CIB = new i(this);
    private int CIa;
    private float CIb;
    private float CIc;
    private boolean CId;
    private float CIe = 2.0f;
    private float CIf = 1.0f;
    private c CIg = new c();
    private c CIh = new c();
    private c CIi = new c();
    private final PointF CIj = new PointF();
    private final PointF CIk = new PointF();
    private long CIl;
    private boolean CIm;
    private com.tencent.mm.plugin.scanner.api.a.c CIn;
    private c CIo = new d();
    private int CIp;
    private com.tencent.mm.plugin.scanner.box.i CIq;
    private final com.tencent.mm.plugin.scanner.box.g CIr = new f(this);
    private int CIs;
    private float CIt;
    private int CIu;
    private a CIv = new a();
    private final e CIw = new e(this);
    private boolean CIx;
    private final com.tencent.mm.plugin.scanner.box.f CIy = new h(this);
    private boolean CIz;
    private final Context context;
    private final Matrix gT = new Matrix();
    private MMViewPager xqs;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$AnimatingZoomInfo;", "", "()V", "isAnimatingZoomIn", "", "()Z", "setAnimatingZoomIn", "(Z)V", "startScale", "", "getStartScale", "()F", "setStartScale", "(F)V", "targetScale", "getTargetScale", "setTargetScale", "plugin-scan_release"})
    public static final class a {
        boolean CID;
        float CIE;
        float aZy;
    }

    static {
        AppMethodBeat.i(240524);
        AppMethodBeat.o(240524);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$Companion;", "", "()V", "ANIMATION_TYPE_ALPHA", "", "ANIMATION_TYPE_TRANSLATION_AND_SCALE", "DIALOG_HEIGHT_RATE_LANDSCAPE", "", "DIALOG_HEIGHT_RATE_PORTRAIT", "TAG", "", "ZOOM_SCALE_CHANGED_LIMIT", "ZOOM_STATE_CHANGED_LIMIT", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.e.b$b  reason: collision with other inner class name */
    public static final class C1670b {
        private C1670b() {
        }

        public /* synthetic */ C1670b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void A(b bVar) {
        AppMethodBeat.i(240535);
        bVar.eQr();
        AppMethodBeat.o(240535);
    }

    public static final /* synthetic */ void B(b bVar) {
        AppMethodBeat.i(240536);
        bVar.eQq();
        AppMethodBeat.o(240536);
    }

    public static final /* synthetic */ void a(b bVar, float f2) {
        AppMethodBeat.i(240527);
        bVar.ai(f2, 0.0f);
        AppMethodBeat.o(240527);
    }

    public static final /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(240539);
        bVar.Ws(i2);
        AppMethodBeat.o(240539);
    }

    public static final /* synthetic */ void a(b bVar, int i2, int i3) {
        AppMethodBeat.i(240526);
        bVar.onError(i2, i3);
        AppMethodBeat.o(240526);
    }

    public static final /* synthetic */ void b(b bVar, int i2, int i3) {
        AppMethodBeat.i(240533);
        bVar.id(i2, i3);
        AppMethodBeat.o(240533);
    }

    public static final /* synthetic */ void b(b bVar, boolean z) {
        AppMethodBeat.i(240530);
        bVar.tQ(z);
        AppMethodBeat.o(240530);
    }

    public static final /* synthetic */ void c(b bVar, boolean z) {
        AppMethodBeat.i(240532);
        bVar.setCanRefresh(z);
        AppMethodBeat.o(240532);
    }

    public static final /* synthetic */ int e(b bVar) {
        AppMethodBeat.i(240528);
        int eQs = bVar.eQs();
        AppMethodBeat.o(240528);
        return eQs;
    }

    public static final /* synthetic */ void g(b bVar) {
        bVar.CIz = false;
        bVar.CIu = 0;
    }

    public static final /* synthetic */ boolean p(b bVar) {
        AppMethodBeat.i(240531);
        boolean isLandscape = bVar.isLandscape();
        AppMethodBeat.o(240531);
        return isLandscape;
    }

    public static final /* synthetic */ int v(b bVar) {
        AppMethodBeat.i(240534);
        int eQt = bVar.eQt();
        AppMethodBeat.o(240534);
        return eQt;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$ImageViewTransformInfo;", "", "()V", "scale", "Landroid/graphics/PointF;", "getScale", "()Landroid/graphics/PointF;", "translation", "getTranslation", "plugin-scan_release"})
    public static final class c {
        final PointF CIj = new PointF();
        final PointF CIk = new PointF();

        public c() {
            AppMethodBeat.i(240483);
            AppMethodBeat.o(240483);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$dialogOnShowListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"})
    public static final class f implements com.tencent.mm.plugin.scanner.box.g {
        final /* synthetic */ b CIF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(b bVar) {
            this.CIF = bVar;
        }

        @Override // com.tencent.mm.plugin.scanner.box.g
        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.i(240486);
            com.tencent.mm.plugin.scanner.api.a.c cVar = this.CIF.CIn;
            if (cVar != null) {
                cVar.eOX();
            }
            c cVar2 = this.CIF.CIo;
            if (cVar2 != null) {
                cVar2.eOX();
                AppMethodBeat.o(240486);
                return;
            }
            AppMethodBeat.o(240486);
        }

        @Override // com.tencent.mm.plugin.scanner.box.g
        public final void a(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(240487);
            com.tencent.mm.plugin.scanner.api.a.c cVar = this.CIF.CIn;
            if (cVar != null) {
                cVar.eOY();
            }
            c cVar2 = this.CIF.CIo;
            if (cVar2 != null) {
                cVar2.WM(i2);
            }
            this.CIF.release();
            AppMethodBeat.o(240487);
        }

        @Override // com.tencent.mm.plugin.scanner.box.g
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(240488);
            com.tencent.mm.plugin.scanner.api.a.c unused = this.CIF.CIn;
            c unused2 = this.CIF.CIo;
            this.CIF.release();
            AppMethodBeat.o(240488);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "onClick", "", "view", "Landroid/view/View;", "plugin-scan_release"})
    public static final class e implements b.a {
        final /* synthetic */ b CIF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(b bVar) {
            this.CIF = bVar;
        }

        @Override // com.tencent.mm.plugin.scanner.box.b.a
        public final void bmr() {
            AppMethodBeat.i(240485);
            if (this.CIF.CHW instanceof com.tencent.mm.ui.base.g) {
                b.a(this.CIF, ((float) b.e(this.CIF)) / 2.0f);
            }
            AppMethodBeat.o(240485);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0005H\u0002¨\u0006&"}, hxF = {"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBoxDialogMoveListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "computeScale", "", "factor", "", "scale", "Landroid/graphics/PointF;", "startScale", "endScale", "computeTranslation", "translation", "startTrans", "endTrans", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "onDismissDialogMove", "onShowDialogMove", "onTouchMoveBegin", "onTouchMoveEnd", "updateImageViewMatrix", "imageView", "Lcom/tencent/mm/ui/base/IZoomableImageView;", "matrix", "Landroid/graphics/Matrix;", "updateViewAlpha", "view", "Landroid/view/View;", "alpha", "plugin-scan_release"})
    public static final class h implements com.tencent.mm.plugin.scanner.box.f {
        final /* synthetic */ b CIF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(b bVar) {
            this.CIF = bVar;
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void ePg() {
            AppMethodBeat.i(240490);
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onTouchMoveBegin");
            ePi();
            this.CIF.CIx = true;
            AppMethodBeat.o(240490);
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void ePh() {
            AppMethodBeat.i(240491);
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onTouchMoveEnd");
            b.g(this.CIF);
            AppMethodBeat.o(240491);
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void c(int i2, float f2, float f3) {
            AppMethodBeat.i(240492);
            float min = Math.min(Math.max((Math.abs(this.CIF.CIb - f2) * 1.0f) / Math.abs(this.CIF.CIc - this.CIF.CIb), 0.0f), 1.0f);
            b.a(this.CIF, i2, f2, min);
            if (i2 == 0) {
                Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onShowDialogMove factor: %s", Float.valueOf(min));
                if (this.CIF.CHW instanceof com.tencent.mm.ui.base.g) {
                    if (this.CIF.CIp == 1) {
                        a(min, this.CIF.CIj, this.CIF.CIg.CIj, this.CIF.CIh.CIj);
                        b(min, this.CIF.CIk, this.CIF.CIg.CIk, this.CIF.CIh.CIk);
                        this.CIF.gT.reset();
                        this.CIF.gT.setScale(this.CIF.CIj.x, this.CIF.CIj.y);
                        this.CIF.gT.postTranslate(this.CIF.CIk.x, this.CIF.CIk.y);
                        View view = this.CIF.CHW;
                        if (view == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                            AppMethodBeat.o(240492);
                            throw tVar;
                        }
                        ((com.tencent.mm.ui.base.g) view).setImageViewMatrix(this.CIF.gT);
                    } else if (this.CIF.CIp == 2) {
                        View view2 = this.CIF.CHW;
                        if (view2 == null) {
                            p.hyc();
                        }
                        if (view2.getAlpha() >= 1.0f - min) {
                            y(this.CIF.CHW, 1.0f - min);
                        }
                    }
                }
            } else {
                Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDismissDialogMove factor: %s", Float.valueOf(min));
                if (this.CIF.CHW instanceof com.tencent.mm.ui.base.g) {
                    float f4 = 1.0f - min;
                    if (this.CIF.CIp == 1 && !b.p(this.CIF)) {
                        a(f4, this.CIF.CIj, this.CIF.CIi.CIj, this.CIF.CIg.CIj);
                        b(f4, this.CIF.CIk, this.CIF.CIi.CIk, this.CIF.CIg.CIk);
                        this.CIF.gT.reset();
                        this.CIF.gT.setScale(this.CIF.CIj.x, this.CIF.CIj.y);
                        this.CIF.gT.postTranslate(this.CIF.CIk.x, this.CIF.CIk.y);
                        View view3 = this.CIF.CHW;
                        if (view3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                            AppMethodBeat.o(240492);
                            throw tVar2;
                        }
                        ((com.tencent.mm.ui.base.g) view3).setImageViewMatrix(this.CIF.gT);
                    } else if (this.CIF.CIp == 2) {
                        View view4 = this.CIF.CHW;
                        if (view4 == null) {
                            p.hyc();
                        }
                        if (view4.getAlpha() <= f4) {
                            y(this.CIF.CHW, f4);
                        }
                    }
                }
            }
            if (min >= 1.0f) {
                b.b(this.CIF, true);
                this.CIF.CIx = false;
                AppMethodBeat.o(240492);
                return;
            }
            b.b(this.CIF, false);
            AppMethodBeat.o(240492);
        }

        private static void y(View view, float f2) {
            AppMethodBeat.i(240493);
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo updateViewAlpha: %s", Float.valueOf(f2));
            if (view != null) {
                view.setAlpha(f2);
                AppMethodBeat.o(240493);
                return;
            }
            AppMethodBeat.o(240493);
        }

        private static void a(float f2, PointF pointF, PointF pointF2, PointF pointF3) {
            float f3;
            float f4;
            AppMethodBeat.i(240494);
            float f5 = pointF2.x;
            float f6 = pointF2.y;
            float f7 = pointF3.x;
            float f8 = pointF3.y;
            if (f5 == f7) {
                f3 = f5;
            } else {
                f3 = ((f7 - f5) * f2) + f5;
            }
            if (f6 == f7) {
                f4 = f6;
            } else {
                f4 = ((f8 - f6) * f2) + f6;
            }
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo computeScale scale factor: %s, start: (%s, %s), end: (%s, %s), current: (%s, %s)", Float.valueOf(f2), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f3), Float.valueOf(f4));
            pointF.x = f3;
            pointF.y = f4;
            AppMethodBeat.o(240494);
        }

        private static void b(float f2, PointF pointF, PointF pointF2, PointF pointF3) {
            float f3;
            float f4;
            AppMethodBeat.i(240495);
            float f5 = pointF2.x;
            float f6 = pointF2.y;
            float f7 = pointF3.x;
            float f8 = pointF3.y;
            if (f5 == f7) {
                f3 = f5;
            } else {
                f3 = ((f7 - f5) * f2) + f5;
            }
            if (f6 == f8) {
                f4 = f6;
            } else {
                f4 = ((f8 - f6) * f2) + f6;
            }
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo computeTranslation translate factor: %s, start: (%s, %s), end: (%s, %s), current: (%s, %s)", Float.valueOf(f2), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f3), Float.valueOf(f4));
            pointF.x = f3;
            pointF.y = f4;
            AppMethodBeat.o(240495);
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void ePi() {
            float f2;
            AppMethodBeat.i(240496);
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDialogDismissAnimationStart");
            if (this.CIF.CIx) {
                this.CIF.CIx = false;
                AppMethodBeat.o(240496);
                return;
            }
            if (this.CIF.CHW instanceof com.tencent.mm.ui.base.g) {
                View view = this.CIF.CHW;
                if (view == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(240496);
                    throw tVar;
                }
                PointF imageViewMatrixScale = ((com.tencent.mm.ui.base.g) view).getImageViewMatrixScale();
                View view2 = this.CIF.CHW;
                if (view2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(240496);
                    throw tVar2;
                }
                PointF imageViewMatrixTranslation = ((com.tencent.mm.ui.base.g) view2).getImageViewMatrixTranslation();
                this.CIF.CIi.CIj.set(imageViewMatrixScale != null ? imageViewMatrixScale.x : 1.0f, imageViewMatrixScale != null ? imageViewMatrixScale.y : 1.0f);
                PointF pointF = this.CIF.CIi.CIk;
                if (imageViewMatrixTranslation != null) {
                    f2 = imageViewMatrixTranslation.x;
                } else {
                    f2 = 0.0f;
                }
                pointF.set(f2, imageViewMatrixTranslation != null ? imageViewMatrixTranslation.y : 0.0f);
                Log.d("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDialogDismissAnimationStart start scale: %s, translation: %s", this.CIF.CIi.CIj, this.CIF.CIi.CIk);
            }
            b.c(this.CIF, false);
            b.b(this.CIF, false);
            AppMethodBeat.o(240496);
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void ePj() {
            AppMethodBeat.i(240497);
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDialogDismissAnimationEnd");
            b.c(this.CIF, true);
            if (this.CIF.CHW instanceof com.tencent.mm.ui.base.g) {
                View view = this.CIF.CHW;
                if (view == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(240497);
                    throw tVar;
                }
                ((com.tencent.mm.ui.base.g) view).gKB();
            }
            if (this.CIF.CHW instanceof WxImageView) {
                View view2 = this.CIF.CHW;
                if (view2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                    AppMethodBeat.o(240497);
                    throw tVar2;
                }
                ((WxImageView) view2).setAllowInterceptTouchEvent(true);
            }
            y(this.CIF.CHW, 1.0f);
            if (this.CIF.CIp == 1 && b.p(this.CIF) && (this.CIF.CHW instanceof com.tencent.mm.ui.base.g)) {
                b.b(this.CIF, this.CIF.CHX, this.CIF.CHY);
                View view3 = this.CIF.CHW;
                if (view3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(240497);
                    throw tVar3;
                }
                ((com.tencent.mm.ui.base.g) view3).gKy();
            }
            AppMethodBeat.o(240497);
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void d(int i2, float f2, float f3) {
            float f4;
            float f5;
            AppMethodBeat.i(240498);
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Float.valueOf(f2);
            objArr[2] = Float.valueOf(f3);
            objArr[3] = Integer.valueOf(this.CIF.CHZ);
            com.tencent.mm.plugin.scanner.api.d dVar = this.CIF.CHV;
            objArr[4] = dVar != null ? Boolean.valueOf(dVar.CAK) : null;
            Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDialogShowAnimationStart dialogHeight: %s, startTransY: %s, endTransY: %s, statusBarHeight: %s, enableFullScreen: %s", objArr);
            this.CIF.CIb = f2;
            this.CIF.CIc = f3;
            if (this.CIF.CHW instanceof com.tencent.mm.ui.base.g) {
                View view = this.CIF.CHW;
                if (view == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(240498);
                    throw tVar;
                }
                com.tencent.mm.ui.base.g gVar = (com.tencent.mm.ui.base.g) view;
                PointF imageViewMatrixScale = gVar.getImageViewMatrixScale();
                PointF imageViewMatrixTranslation = gVar.getImageViewMatrixTranslation();
                this.CIF.CIg.CIj.set(imageViewMatrixScale != null ? imageViewMatrixScale.x : 1.0f, imageViewMatrixScale != null ? imageViewMatrixScale.y : 1.0f);
                PointF pointF = this.CIF.CIg.CIk;
                if (imageViewMatrixTranslation != null) {
                    f4 = imageViewMatrixTranslation.x;
                } else {
                    f4 = 0.0f;
                }
                if (imageViewMatrixTranslation != null) {
                    f5 = imageViewMatrixTranslation.y;
                } else {
                    f5 = 0.0f;
                }
                pointF.set(f4, f5);
                Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDialogShowAnimationStart start scale: %s, translation: %s", this.CIF.CIg.CIj, this.CIF.CIg.CIk);
                int imageWidth = gVar.getImageWidth();
                int imageHeight = gVar.getImageHeight();
                int e2 = b.e(this.CIF);
                int v = b.v(this.CIF);
                if ((((float) imageWidth) * 1.0f) / ((float) imageHeight) > (((float) e2) * 1.0f) / ((float) v)) {
                    this.CIF.CIh.CIj.x = (1.0f * ((float) e2)) / ((float) imageWidth);
                    this.CIF.CIh.CIj.y = this.CIF.CIh.CIj.x;
                    this.CIF.CIh.CIk.x = 0.0f;
                    this.CIF.CIh.CIk.y = (((float) v) - (((float) imageHeight) * this.CIF.CIh.CIj.y)) / 2.0f;
                    this.CIF.CIf = this.CIF.CIh.CIj.x;
                } else {
                    this.CIF.CId = true;
                    this.CIF.CIh.CIj.x = (((float) v) * 1.0f) / ((float) imageHeight);
                    this.CIF.CIh.CIj.y = this.CIF.CIh.CIj.x;
                    this.CIF.CIh.CIk.x = (((float) e2) - (this.CIF.CIh.CIj.x * ((float) imageWidth))) / 2.0f;
                    this.CIF.CIh.CIk.y = 0.0f;
                    this.CIF.CIe = (1.0f * ((float) e2)) / ((float) imageWidth);
                    this.CIF.CIf = this.CIF.CIh.CIj.x;
                }
                Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onDialogShowAnimationStart end scale: %s, translation: %s, isLongImage: %b, showDoubleScale: %s, showDefaultScale: %s", this.CIF.CIh.CIj, this.CIF.CIh.CIk, Boolean.valueOf(this.CIF.CId), Float.valueOf(this.CIF.CIe), Float.valueOf(this.CIF.CIf));
            }
            b.A(this.CIF);
            b.B(this.CIF);
            if (this.CIF.CHW instanceof WxImageView) {
                View view2 = this.CIF.CHW;
                if (view2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                    AppMethodBeat.o(240498);
                    throw tVar2;
                }
                ((WxImageView) view2).setAllowInterceptTouchEvent(false);
            }
            AppMethodBeat.o(240498);
        }

        @Override // com.tencent.mm.plugin.scanner.box.f
        public final void ePk() {
            View view;
            AppMethodBeat.i(240499);
            if (this.CIF.CIp != 1 || !b.p(this.CIF) || (view = (View) this.CIF.CBr) == null) {
                AppMethodBeat.o(240499);
                return;
            }
            view.setVisibility(0);
            AppMethodBeat.o(240499);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "onBackgroundTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "dialogOffsetY", "", "plugin-scan_release"})
    public static final class g implements com.tencent.mm.plugin.scanner.box.c {
        final /* synthetic */ b CIF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(b bVar) {
            this.CIF = bVar;
        }

        @Override // com.tencent.mm.plugin.scanner.box.c
        public final boolean i(MotionEvent motionEvent, int i2) {
            int action;
            AppMethodBeat.i(240489);
            boolean z = false;
            if (this.CIF.CIz) {
                MMViewPager mMViewPager = this.CIF.xqs;
                if (mMViewPager == null) {
                    p.hyc();
                }
                z = mMViewPager.dispatchTouchEvent(motionEvent);
            } else if (motionEvent != null && motionEvent.getRawY() <= ((float) i2)) {
                MMViewPager mMViewPager2 = this.CIF.xqs;
                if (mMViewPager2 == null) {
                    p.hyc();
                }
                z = mMViewPager2.dispatchTouchEvent(motionEvent);
                if (z) {
                    this.CIF.CIz = true;
                }
            }
            if (motionEvent != null && ((action = motionEvent.getAction() & 255) == 1 || action == 6)) {
                b.g(this.CIF);
            }
            AppMethodBeat.o(240489);
            return z;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "oldScale", "", "newScale", "onScaleChanged"})
    static final class i implements g.a {
        final /* synthetic */ b CIF;

        i(b bVar) {
            this.CIF = bVar;
        }

        @Override // com.tencent.mm.ui.base.g.a
        public final void aj(float f2, float f3) {
            AppMethodBeat.i(240502);
            Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onScaleChanged old: %s, new: %s", Float.valueOf(f2), Float.valueOf(f3));
            if (this.CIF.CIv.CID && this.CIF.CIv.aZy == f3) {
                this.CIF.CIv.CID = false;
            }
            b.f(this.CIF, f3);
            b bVar = this.CIF;
            View view = this.CIF.CHW;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                AppMethodBeat.o(240502);
                throw tVar;
            }
            b.a(bVar, f3, ((com.tencent.mm.ui.base.g) view).getScaleRate(), new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.scanner.e.b.i.AnonymousClass1 */
                final /* synthetic */ i CIG;

                {
                    this.CIG = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(240500);
                    if (!this.CIG.CIF.CIv.CID) {
                        b.a(this.CIG.CIF, 2);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(240500);
                    return xVar;
                }
            }, new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.scanner.e.b.i.AnonymousClass2 */
                final /* synthetic */ i CIG;

                {
                    this.CIG = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(240501);
                    if (!this.CIG.CIF.CIv.CID) {
                        b.a(this.CIG.CIF, 1);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(240501);
                    return xVar;
                }
            });
            AppMethodBeat.o(240502);
        }
    }

    public b(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(240523);
        this.context = context2;
        this.CHZ = au.getStatusBarHeight(context2);
        this.CIa = context2.getResources().getDimensionPixelSize(R.dimen.ct);
        AppMethodBeat.o(240523);
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(240505);
        Object[] objArr = new Object[1];
        objArr[0] = configuration != null ? Integer.valueOf(configuration.orientation) : null;
        Log.d("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onConfigurationChanged new: %s", objArr);
        if (this.CIq != null) {
            com.tencent.mm.plugin.scanner.box.i iVar = this.CIq;
            if (iVar == null) {
                p.hyc();
            }
            if (iVar.isShowingDialog()) {
                if (configuration != null && configuration.orientation == 2) {
                    tQ(false);
                    if (this.CIp == 1) {
                        if (this.CHW instanceof com.tencent.mm.ui.base.g) {
                            View view = this.CHW;
                            if (view == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                                AppMethodBeat.o(240505);
                                throw tVar;
                            }
                            ((com.tencent.mm.ui.base.g) view).gKB();
                        }
                        id(-1, -1);
                    } else if (this.CIp == 2) {
                        id(-1, -1);
                    }
                    if (this.CHW instanceof com.tencent.mm.ui.base.g) {
                        View view2 = this.CHW;
                        if (view2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                            AppMethodBeat.o(240505);
                            throw tVar2;
                        }
                        ((com.tencent.mm.ui.base.g) view2).gKy();
                        AppMethodBeat.o(240505);
                        return;
                    }
                    AppMethodBeat.o(240505);
                } else if (configuration != null) {
                    if (configuration.orientation == 1) {
                        if (this.CIp == 1) {
                            eQr();
                            eQq();
                            tQ(true);
                            id(eQs(), eQt());
                        } else if (this.CIp == 2) {
                            tQ(false);
                            id(-1, -1);
                        }
                        if (this.CHW instanceof com.tencent.mm.ui.base.g) {
                            View view3 = this.CHW;
                            if (view3 == null) {
                                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                                AppMethodBeat.o(240505);
                                throw tVar3;
                            }
                            ((com.tencent.mm.ui.base.g) view3).gKy();
                        }
                    }
                    AppMethodBeat.o(240505);
                    return;
                } else {
                    AppMethodBeat.o(240505);
                    return;
                }
            }
        }
        id(-1, -1);
        AppMethodBeat.o(240505);
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final void eN(View view) {
        if (view instanceof MMViewPager) {
            this.xqs = (MMViewPager) view;
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final void eO(View view) {
        AppMethodBeat.i(240506);
        this.CHW = view;
        if (this.CHW instanceof WxImageView) {
            View view2 = this.CHW;
            if (view2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                AppMethodBeat.o(240506);
                throw tVar;
            }
            ((WxImageView) view2).setOnDoubleTapListener(new d(this));
        }
        if (this.CHW instanceof com.tencent.mm.ui.base.g) {
            View view3 = this.CHW;
            if (view3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                AppMethodBeat.o(240506);
                throw tVar2;
            }
            ((com.tencent.mm.ui.base.g) view3).setOnZoomScaleChangedListener(this.CIB);
        }
        AppMethodBeat.o(240506);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onSingleTapConfirmed", "plugin-scan_release"})
    public static final class d implements GestureDetector.OnDoubleTapListener {
        final /* synthetic */ b CIF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(b bVar) {
            this.CIF = bVar;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(240484);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = this.CIF.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(240484);
            return onDoubleTap;
        }

        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final long a(com.tencent.mm.plugin.scanner.api.e eVar, com.tencent.mm.plugin.scanner.api.d dVar, com.tencent.mm.plugin.scanner.api.a.c cVar) {
        AppMethodBeat.i(240507);
        if (!eQu()) {
            onError(3, 301);
            AppMethodBeat.o(240507);
            return 0;
        } else if (this.xqs == null || this.CHW == null) {
            Log.e("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo startImageOCR gallery null or currentImageView null");
            AppMethodBeat.o(240507);
            return 0;
        } else {
            if (this.CHW instanceof com.tencent.mm.ui.base.g) {
                View view = this.CHW;
                if (view == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                    AppMethodBeat.o(240507);
                    throw tVar;
                }
                ((com.tencent.mm.ui.base.g) view).gKy();
            }
            this.CIm = false;
            this.CHV = dVar;
            MMViewPager mMViewPager = this.xqs;
            if (mMViewPager == null) {
                p.hyc();
            }
            this.CHX = mMViewPager.getMeasuredHeight();
            MMViewPager mMViewPager2 = this.xqs;
            if (mMViewPager2 == null) {
                p.hyc();
            }
            this.CHY = mMViewPager2.getMeasuredWidth();
            this.CIn = cVar;
            this.CIl = ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).b(eVar, new j(this, eVar));
            if (cVar != null) {
                cVar.eOW();
            }
            c cVar2 = this.CIo;
            if (cVar2 != null) {
                cVar2.IA(this.CIl);
            }
            Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo startImageOCR galleryWidth: %s, galleryHeight: %s, uploadSessionId: %s", Integer.valueOf(this.CHY), Integer.valueOf(this.CHX), Long.valueOf(this.CIl));
            long j2 = this.CIl;
            AppMethodBeat.o(240507);
            return j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    static final class j implements com.tencent.mm.plugin.scanner.api.g {
        final /* synthetic */ com.tencent.mm.plugin.scanner.api.e CFc;
        final /* synthetic */ b CIF;

        j(b bVar, com.tencent.mm.plugin.scanner.api.e eVar) {
            this.CIF = bVar;
            this.CFc = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(240503);
            a(j2, fVar);
            AppMethodBeat.o(240503);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(240504);
            p.h(fVar, "result");
            Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo dealWithImageOcr onCallback session: %s, success: %b, errType: %s, errCode: %s, errMsg: %s, result: %s, reqKey: %s", Long.valueOf(j2), Boolean.valueOf(fVar.success), Integer.valueOf(fVar.errType), Integer.valueOf(fVar.errCode), fVar.errMsg, fVar.dZL, fVar.dDL);
            this.CIF.CIm = true;
            c cVar = this.CIF.CIo;
            if (cVar != null) {
                cVar.a(fVar);
            }
            if (fVar.success) {
                b.a(this.CIF, this.CFc, fVar);
                AppMethodBeat.o(240504);
                return;
            }
            b.a(this.CIF, fVar.errType, fVar.errCode);
            AppMethodBeat.o(240504);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final boolean It(long j2) {
        boolean z;
        c cVar;
        boolean z2;
        boolean z3 = false;
        boolean z4 = true;
        AppMethodBeat.i(240508);
        Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo cancelImageOCR sessionId: %s, uploadFinish: %s", Long.valueOf(j2), Boolean.valueOf(this.CIm));
        if (j2 == 0 || this.CIm) {
            z = false;
        } else {
            ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Ir(j2);
            z = true;
        }
        if (this.CIq != null) {
            com.tencent.mm.plugin.scanner.box.i iVar = this.CIq;
            if (iVar == null) {
                p.hyc();
            }
            if (iVar.isShowingDialog()) {
                com.tencent.mm.plugin.scanner.box.i iVar2 = this.CIq;
                if (iVar2 == null) {
                    p.hyc();
                }
                if (iVar2.isShowing()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo cancelImageOCR dismiss dialog handled: %s", Boolean.valueOf(z2));
                com.tencent.mm.plugin.scanner.box.i iVar3 = this.CIq;
                if (iVar3 == null) {
                    p.hyc();
                }
                iVar3.dismiss();
                z3 = z2;
                if (z4 && (cVar = this.CIo) != null) {
                    cVar.IB(j2);
                }
                AppMethodBeat.o(240508);
                return z3;
            }
        }
        z4 = z;
        cVar.IB(j2);
        AppMethodBeat.o(240508);
        return z3;
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final boolean eOV() {
        AppMethodBeat.i(240509);
        if (this.CIq != null) {
            com.tencent.mm.plugin.scanner.box.i iVar = this.CIq;
            if (iVar == null) {
                p.hyc();
            }
            if (iVar.isShowing()) {
                AppMethodBeat.o(240509);
                return true;
            }
        }
        AppMethodBeat.o(240509);
        return false;
    }

    private final void ai(float f2, float f3) {
        AppMethodBeat.i(240510);
        View view = this.CHW;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
            AppMethodBeat.o(240510);
            throw tVar;
        }
        com.tencent.mm.ui.base.g gVar = (com.tencent.mm.ui.base.g) view;
        float scale = gVar.getScale();
        Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo processZoom currentScale: %s, isLongImage: %s, showDoubleScale: %s, showDefaultScale: %s, scaleRate: %s, centerX: %s, centerY: %s, zoomState: %s", Float.valueOf(scale), Boolean.valueOf(this.CId), Float.valueOf(this.CIe), Float.valueOf(this.CIf), Float.valueOf(gVar.getScaleRate()), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(this.CIs));
        if (this.CId) {
            if (this.CIs == 1) {
                a aVar = this.CIv;
                aVar.CIE = scale;
                aVar.aZy = this.CIe;
                aVar.CID = true;
                c cVar = this.CIo;
                if (cVar != null) {
                    cVar.bqR();
                }
                gVar.l(this.CIe, f2, f3);
                Ws(2);
                AppMethodBeat.o(240510);
                return;
            }
            if (this.CIs == 2) {
                a aVar2 = this.CIv;
                aVar2.CIE = scale;
                aVar2.aZy = this.CIf;
                aVar2.CID = true;
                c cVar2 = this.CIo;
                if (cVar2 != null) {
                    cVar2.bqQ();
                }
                gVar.l(this.CIf, f2, f3);
                Ws(1);
            }
            AppMethodBeat.o(240510);
        } else if (this.CIs == 1) {
            float y = gVar.y(f2, f3);
            a aVar3 = this.CIv;
            aVar3.CIE = scale;
            aVar3.aZy = y;
            aVar3.CID = true;
            c cVar3 = this.CIo;
            if (cVar3 != null) {
                cVar3.bqR();
            }
            Ws(2);
            AppMethodBeat.o(240510);
        } else {
            if (this.CIs == 2) {
                a aVar4 = this.CIv;
                aVar4.CIE = scale;
                aVar4.aZy = this.CIf;
                aVar4.CID = true;
                c cVar4 = this.CIo;
                if (cVar4 != null) {
                    cVar4.bqQ();
                }
                Ws(1);
                gVar.l(this.CIf, f2, f3);
            }
            AppMethodBeat.o(240510);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(240511);
        if (motionEvent == null) {
            AppMethodBeat.o(240511);
            return false;
        }
        if (this.CIq != null) {
            com.tencent.mm.plugin.scanner.box.i iVar = this.CIq;
            if (iVar == null) {
                p.hyc();
            }
            if (iVar.isShowing()) {
                if (this.CHW instanceof com.tencent.mm.ui.base.g) {
                    ai(com.tencent.mm.ui.base.f.j(motionEvent, 0), com.tencent.mm.ui.base.f.k(motionEvent, 0));
                    AppMethodBeat.o(240511);
                    return true;
                }
                AppMethodBeat.o(240511);
                return false;
            }
        }
        AppMethodBeat.o(240511);
        return false;
    }

    private final void tQ(boolean z) {
        View view;
        AppMethodBeat.i(240512);
        if (!(this.CBr instanceof View) || (view = (View) this.CBr) == null) {
            AppMethodBeat.o(240512);
            return;
        }
        view.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(240512);
    }

    private final void eQq() {
        AppMethodBeat.i(240513);
        if (this.CHW instanceof WxImageView) {
            View view = this.CHW;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                AppMethodBeat.o(240513);
                throw tVar;
            } else if (((WxImageView) view).getMinScale() > this.CIh.CIj.x) {
                View view2 = this.CHW;
                if (view2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                    AppMethodBeat.o(240513);
                    throw tVar2;
                }
                ((WxImageView) view2).setMinScale(this.CIh.CIj.x);
            }
        }
        AppMethodBeat.o(240513);
    }

    private final void eQr() {
        AppMethodBeat.i(240514);
        if ((this.CHW instanceof com.tencent.mm.ui.base.g) && this.CIp == 1) {
            View view = this.CHW;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                AppMethodBeat.o(240514);
                throw tVar;
            }
            ((com.tencent.mm.ui.base.g) view).setCustomScaleRate(Float.valueOf(this.CIf));
        }
        AppMethodBeat.o(240514);
    }

    private final void Ws(int i2) {
        AppMethodBeat.i(240515);
        Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onZoomStateChanged currentZoomState: %s, target: %s", Integer.valueOf(this.CIs), Integer.valueOf(i2));
        if (this.CIs != i2) {
            this.CIs = i2;
            com.tencent.mm.plugin.scanner.box.b bVar = this.CBr;
            if (bVar != null) {
                bVar.Ws(i2);
                AppMethodBeat.o(240515);
                return;
            }
        }
        AppMethodBeat.o(240515);
    }

    private final void setCanRefresh(boolean z) {
        AppMethodBeat.i(240516);
        Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo setCanRefresh %b, view: %s", Boolean.valueOf(z), this.CHW);
        if (this.CHW instanceof MultiTouchImageView) {
            View view = this.CHW;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
                AppMethodBeat.o(240516);
                throw tVar;
            }
            ((MultiTouchImageView) view).setCanRefresh(z);
            AppMethodBeat.o(240516);
            return;
        }
        if (this.CHW instanceof WxImageView) {
            View view2 = this.CHW;
            if (view2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                AppMethodBeat.o(240516);
                throw tVar2;
            }
            ((WxImageView) view2).setCanRefresh(z);
        }
        AppMethodBeat.o(240516);
    }

    private final int eQs() {
        return this.CHY - (this.CIa * 2);
    }

    private final int eQt() {
        com.tencent.mm.plugin.scanner.api.d dVar = this.CHV;
        if (dVar != null ? dVar.CAK : true) {
            return (int) (this.CIc + ((float) this.CHZ));
        }
        return (int) this.CIc;
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(240517);
        Resources resources = this.context.getResources();
        p.g(resources, "context.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(240517);
            return true;
        }
        AppMethodBeat.o(240517);
        return false;
    }

    private final void id(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(240518);
        MMViewPager mMViewPager = this.xqs;
        if (mMViewPager != null) {
            MMViewPager mMViewPager2 = this.xqs;
            if (mMViewPager2 == null || (layoutParams = mMViewPager2.getLayoutParams()) == null) {
                layoutParams = null;
            } else {
                layoutParams.height = i3;
                layoutParams.width = i2;
            }
            mMViewPager.setLayoutParams(layoutParams);
            AppMethodBeat.o(240518);
            return;
        }
        AppMethodBeat.o(240518);
    }

    private static boolean eQu() {
        AppMethodBeat.i(240519);
        com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        if (azz.aYS() != 6) {
            com.tencent.mm.ak.t azz2 = com.tencent.mm.kernel.g.azz();
            p.g(azz2, "MMKernel.getNetSceneQueue()");
            if (azz2.aYS() != 4) {
                AppMethodBeat.o(240519);
                return false;
            }
        }
        AppMethodBeat.o(240519);
        return true;
    }

    private final void onError(int i2, int i3) {
        AppMethodBeat.i(240520);
        Log.e("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onError errType: " + i2 + ", errCode: " + i3);
        com.tencent.mm.plugin.scanner.api.a.c cVar = this.CIn;
        if (cVar != null) {
            cVar.eOZ();
        }
        if (eQu()) {
            boolean WL = WL(i3);
            if (i2 == 4) {
                if (WL) {
                    String string = this.context.getString(R.string.gcg);
                    p.g(string, "context.getString(R.stri…an_image_ocr_local_error)");
                    aeu(string);
                    AppMethodBeat.o(240520);
                    return;
                }
                String string2 = this.context.getString(R.string.gci);
                p.g(string2, "context.getString(R.stri…image_ocr_result_invalid)");
                aeu(string2);
                AppMethodBeat.o(240520);
            } else if (i2 != 3 || !WL) {
                String string3 = this.context.getString(R.string.gch);
                p.g(string3, "context.getString(R.stri…image_ocr_network_failed)");
                aeu(string3);
                AppMethodBeat.o(240520);
            } else {
                String string4 = this.context.getString(R.string.gcg);
                p.g(string4, "context.getString(R.stri…an_image_ocr_local_error)");
                aeu(string4);
                AppMethodBeat.o(240520);
            }
        } else {
            String string5 = this.context.getString(R.string.gch);
            p.g(string5, "context.getString(R.stri…image_ocr_network_failed)");
            aeu(string5);
            AppMethodBeat.o(240520);
        }
    }

    private static boolean WL(int i2) {
        return i2 == 101 || i2 == 102 || i2 == 999;
    }

    private final void aeu(String str) {
        AppMethodBeat.i(240521);
        com.tencent.mm.ui.base.h.a(this.context, str, "", this.context.getResources().getString(R.string.w1), false, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(240521);
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.a
    public final void release() {
        AppMethodBeat.i(240522);
        com.tencent.mm.plugin.scanner.box.b bVar = this.CBr;
        if (bVar != null) {
            bVar.release();
        }
        this.CBr = null;
        this.CIq = null;
        this.CIp = 0;
        this.CIs = 0;
        this.CIt = 0.0f;
        this.CIx = false;
        if (this.CIl != 0) {
            ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Ir(this.CIl);
            this.CIl = 0;
        }
        if (this.CHW instanceof WxImageView) {
            View view = this.CHW;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
                AppMethodBeat.o(240522);
                throw tVar;
            }
            ((WxImageView) view).setOnDoubleTapListener(null);
        }
        if (this.CHW instanceof com.tencent.mm.ui.base.g) {
            View view2 = this.CHW;
            if (view2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
                AppMethodBeat.o(240522);
                throw tVar2;
            }
            ((com.tencent.mm.ui.base.g) view2).setOnZoomScaleChangedListener(null);
        }
        this.CHW = null;
        AppMethodBeat.o(240522);
    }

    public static final /* synthetic */ void a(b bVar, com.tencent.mm.plugin.scanner.api.e eVar, com.tencent.mm.plugin.scanner.api.f fVar) {
        float f2;
        int i2;
        boolean z;
        AppMethodBeat.i(240525);
        String str = fVar.dZL;
        if ((str == null || str.length() == 0) || fVar.CBc) {
            bVar.onError(4, 202);
            AppMethodBeat.o(240525);
            return;
        }
        boolean isLandscape = bVar.isLandscape();
        if (!isLandscape) {
            f2 = 0.7f;
        } else {
            f2 = 1.0f;
        }
        if (!isLandscape) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        bVar.CIp = i2;
        bVar.setCanRefresh(false);
        Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo showImageOCRResult isLandscape: %s, dialogHeightRate: %f, animationType: %s", Boolean.valueOf(isLandscape), Float.valueOf(f2), Integer.valueOf(bVar.CIp));
        Bundle bundle = new Bundle();
        bundle.putLong("session_id", fVar.dDZ);
        bundle.putString("req_key", fVar.dDL);
        bundle.putInt("scene", eVar.source);
        bundle.putInt(MessengerShareContentUtility.TEMPLATE_TYPE, 2);
        bundle.putFloat("fixed_dialog_height_rate", f2);
        bundle.putBoolean("enable_dialog_scroll", false);
        bundle.putBoolean("enable_cancel_outside", false);
        bundle.putBoolean("show_after_webview_ready", true);
        com.tencent.mm.plugin.scanner.api.d dVar = bVar.CHV;
        bundle.putBoolean("enable_full_screen", dVar != null ? dVar.CAK : true);
        com.tencent.mm.plugin.scanner.api.d dVar2 = bVar.CHV;
        if (dVar2 != null) {
            z = dVar2.CAL;
        } else {
            z = false;
        }
        bundle.putBoolean("enable_scroll_right_close", z);
        bVar.CIq = com.tencent.mm.plugin.scanner.box.l.a(bVar.context, bundle, bVar.CIr);
        com.tencent.mm.plugin.scanner.box.i iVar = bVar.CIq;
        if (iVar != null) {
            iVar.a(bVar.CIy);
        }
        com.tencent.mm.plugin.scanner.box.i iVar2 = bVar.CIq;
        if (iVar2 != null) {
            g gVar = bVar.CIA;
            p.h(gVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            BaseBoxDialogView baseBoxDialogView = iVar2.CCE;
            if (baseBoxDialogView != null) {
                baseBoxDialogView.setBackgroundTouchListener(gVar);
            }
        }
        if (bVar.CIp == 1) {
            bVar.CBr = new ScanOCRDialogBackgroundOpView(bVar.context);
            com.tencent.mm.plugin.scanner.box.b bVar2 = bVar.CBr;
            if (bVar2 != null) {
                bVar2.setOpListener(bVar.CIw);
            }
            com.tencent.mm.plugin.scanner.box.i iVar3 = bVar.CIq;
            if (iVar3 != null) {
                com.tencent.mm.plugin.scanner.box.b bVar3 = bVar.CBr;
                if (bVar3 == null) {
                    p.hyc();
                }
                p.h(bVar3, "opView");
                BaseBoxDialogView baseBoxDialogView2 = iVar3.CCE;
                if (baseBoxDialogView2 != null) {
                    baseBoxDialogView2.setBackgroundOpView(bVar3);
                    AppMethodBeat.o(240525);
                    return;
                }
                AppMethodBeat.o(240525);
                return;
            }
        }
        AppMethodBeat.o(240525);
    }

    public static final /* synthetic */ void a(b bVar, int i2, float f2, float f3) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Integer num = null;
        AppMethodBeat.i(240529);
        if (bVar.CIp != 1 || bVar.isLandscape()) {
            AppMethodBeat.o(240529);
            return;
        }
        int i3 = bVar.CHX;
        int eQt = bVar.eQt();
        int i4 = ((int) (((float) (eQt - i3)) * f3)) + i3;
        bVar.id((int) ((((float) (bVar.eQs() - bVar.CHY)) * f3) + ((float) bVar.CHY)), i4);
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(eQt);
        objArr[3] = Integer.valueOf(i4);
        objArr[4] = Float.valueOf(f3);
        objArr[5] = Float.valueOf(f2);
        objArr[6] = Float.valueOf(f3);
        MMViewPager mMViewPager = bVar.xqs;
        objArr[7] = (mMViewPager == null || (layoutParams2 = mMViewPager.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams2.width);
        MMViewPager mMViewPager2 = bVar.xqs;
        if (!(mMViewPager2 == null || (layoutParams = mMViewPager2.getLayoutParams()) == null)) {
            num = Integer.valueOf(layoutParams.height);
        }
        objArr[8] = num;
        Log.v("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo updateGalleryHeight dialogState: %s, start: %s, end: %s, targetHeight: %s, factor: %s, offsetY: %s, realFactor: %s, gallery: (%s, %s)", objArr);
        AppMethodBeat.o(240529);
    }

    public static final /* synthetic */ void f(b bVar, float f2) {
        AppMethodBeat.i(240537);
        if (f2 - bVar.CIt > 0.01f) {
            bVar.CIt = f2;
            if (bVar.CIu != 1) {
                bVar.CIu = 1;
                c cVar = bVar.CIo;
                if (cVar != null) {
                    cVar.bqR();
                    AppMethodBeat.o(240537);
                    return;
                }
                AppMethodBeat.o(240537);
                return;
            }
        } else if (bVar.CIt - f2 > 0.01f) {
            bVar.CIt = f2;
            if (bVar.CIu != 2) {
                bVar.CIu = 2;
                c cVar2 = bVar.CIo;
                if (cVar2 != null) {
                    cVar2.bqQ();
                    AppMethodBeat.o(240537);
                    return;
                }
                AppMethodBeat.o(240537);
                return;
            }
        } else {
            Log.w("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onZoomScaleChanged ignore, %s, %s", Float.valueOf(f2), Float.valueOf(bVar.CIt));
        }
        AppMethodBeat.o(240537);
    }

    public static final /* synthetic */ void a(b bVar, float f2, float f3, kotlin.g.a.a aVar, kotlin.g.a.a aVar2) {
        AppMethodBeat.i(240538);
        if (bVar.CId) {
            if (f2 - bVar.CIf > 0.01f) {
                aVar.invoke();
                AppMethodBeat.o(240538);
            } else if (f2 - bVar.CIe > 0.01f) {
                aVar.invoke();
                AppMethodBeat.o(240538);
            } else {
                aVar2.invoke();
                AppMethodBeat.o(240538);
            }
        } else if (f2 <= f3) {
            aVar2.invoke();
            AppMethodBeat.o(240538);
        } else {
            aVar.invoke();
            AppMethodBeat.o(240538);
        }
    }
}
