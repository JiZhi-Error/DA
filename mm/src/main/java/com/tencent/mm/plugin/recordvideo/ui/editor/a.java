package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import com.tencent.mm.vfs.s;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010R\u001a\u00020&J\u0006\u0010S\u001a\u00020&J\u000e\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020/J\n\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0014\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020]H\u0014J\b\u0010^\u001a\u00020&H\u0002J\b\u0010_\u001a\u00020>H\u0016J\b\u0010`\u001a\u0004\u0018\u00010aJ\b\u0010b\u001a\u000205H\u0016J\n\u0010c\u001a\u0004\u0018\u00010WH\u0016J\b\u0010d\u001a\u000201H\u0016J\u000e\u0010e\u001a\u00020E2\u0006\u0010Z\u001a\u000203J\b\u0010f\u001a\u00020gH\u0016J\u000e\u0010h\u001a\u0002072\u0006\u0010i\u001a\u00020jJ\u0010\u0010k\u001a\u0002072\u0006\u0010l\u001a\u00020mH\u0016J(\u0010n\u001a\u0002072\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020p2\u0006\u0010r\u001a\u00020E2\u0006\u0010s\u001a\u00020EH\u0016J\u0018\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020\u00112\u0006\u0010v\u001a\u00020pH\u0016J\u000e\u0010w\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010x\u001a\u00020&2\u0006\u00100\u001a\u0002012\u0006\u0010y\u001a\u00020EH\u0016J\u0012\u0010z\u001a\u00020&2\b\u0010{\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010|\u001a\u00020&2\u0006\u0010}\u001a\u0002012\u0006\u0010~\u001a\u00020\bH\u0016J\u000e\u0010\u001a\u00020&2\u0006\u0010A\u001a\u00020BJ\u0011\u0010\u0001\u001a\u00020&2\u0006\u0010P\u001a\u000201H\u0016J\u0011\u0010\u0001\u001a\u0002072\u0006\u0010U\u001a\u00020/H\u0016J\u000f\u0010\u0001\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001a\u0010\rR#\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b\u001e\u0010\u001fR7\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u000205X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignDiff", "", "captionContentLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCaptionContentLayout", "()Landroid/widget/LinearLayout;", "captionContentLayout$delegate", "Lkotlin/Lazy;", "captionFloatCommentHint", "Landroid/view/View;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionLayout", "Landroid/widget/RelativeLayout;", "getCaptionLayout", "()Landroid/widget/RelativeLayout;", "captionLayout$delegate", "captionLoadingLayout", "getCaptionLoadingLayout", "captionLoadingLayout$delegate", "captionView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "getCaptionView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "captionView$delegate", "clearCaptionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "getClearCaptionListener", "()Lkotlin/jvm/functions/Function1;", "setClearCaptionListener", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "Landroid/view/View$OnClickListener;", "commentHintHeight", "currentTimeMs", "", "displayRect", "Landroid/graphics/Rect;", "drawMatrix", "Landroid/graphics/Matrix;", "drawRect", "Landroid/graphics/RectF;", "enableEdit", "", "getEnableEdit", "()Z", "setEnableEdit", "(Z)V", "minLength", "originPivot", "", "selectChecker", "Ljava/lang/Runnable;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchAligned", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "getTouchSlop", "()I", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "touched", "validRect", "viewRect", "applyMatrix", "checkMatrix", "contentValid", "currentMs", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "editMode", "getContentBoundary", "getCurrentCaption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "getDrawRect", "getEditorData", "getSafeArea", "getScale", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "isCaptionType", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouch", "v", "event", "setCaptionItem", "setDefaultLocation", "heightPercent", "setOnClickListener", "l", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "showAtTime", "updateCaptionItem", "Companion", "plugin-recordvideo_release"})
public final class a extends TouchEventLayout implements com.tencent.mm.plugin.recordvideo.ui.editor.item.g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c {
    public static final C1656a CaG = new C1656a((byte) 0);
    private final int CaA;
    private final int CaB;
    private long CaC;
    private kotlin.g.a.b<? super View, x> CaD;
    private boolean CaE;
    private final Runnable CaF;
    public com.tencent.mm.plugin.recordvideo.ui.editor.item.c Can;
    private final Rect Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private final Rect Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    private EditorItemContainer.b Caq;
    private final RectF Car = new RectF();
    private final RectF Cas = new RectF();
    private final Matrix Cat = new Matrix();
    private final int Cau;
    private final kotlin.f Cav;
    private final kotlin.f Caw;
    private final kotlin.f Cax;
    private final kotlin.f Cay;
    private final View Caz;
    private View.OnClickListener dec;
    private boolean gZT;
    private boolean gZU;
    private float gZX;
    private float gZY;
    private final int rZ;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    private final float[] rrd;

    static {
        AppMethodBeat.i(237610);
        AppMethodBeat.o(237610);
    }

    private final LinearLayout getCaptionContentLayout() {
        AppMethodBeat.i(237586);
        LinearLayout linearLayout = (LinearLayout) this.Cax.getValue();
        AppMethodBeat.o(237586);
        return linearLayout;
    }

    private final RelativeLayout getCaptionLayout() {
        AppMethodBeat.i(237585);
        RelativeLayout relativeLayout = (RelativeLayout) this.Caw.getValue();
        AppMethodBeat.o(237585);
        return relativeLayout;
    }

    private final LinearLayout getCaptionLoadingLayout() {
        AppMethodBeat.i(237587);
        LinearLayout linearLayout = (LinearLayout) this.Cay.getValue();
        AppMethodBeat.o(237587);
        return linearLayout;
    }

    private final PhotoTextView getCaptionView() {
        AppMethodBeat.i(237584);
        PhotoTextView photoTextView = (PhotoTextView) this.Cav.getValue();
        AppMethodBeat.o(237584);
        return photoTextView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
    static final class f extends q implements m<Matrix, Boolean, x> {
        final /* synthetic */ a CaH;
        final /* synthetic */ MotionEvent CaJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar, MotionEvent motionEvent) {
            super(2);
            this.CaH = aVar;
            this.CaJ = motionEvent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            EditorItemContainer.b bVar;
            AppMethodBeat.i(237582);
            Matrix matrix2 = matrix;
            boolean booleanValue = bool.booleanValue();
            p.h(matrix2, "m");
            this.CaH.Cat.set(matrix2);
            this.CaH.eLJ();
            if (booleanValue && (bVar = this.CaH.Caq) != null) {
                bVar.d(this.CaH, this.CaJ);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(237582);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(237609);
        this.Cau = com.tencent.mm.cb.a.fromDPToPix(context, 4);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        this.Cav = kotlin.g.ah(new e(this));
        this.Caw = kotlin.g.ah(new c(this));
        this.Cax = kotlin.g.ah(new b(this));
        this.Cay = kotlin.g.ah(new d(this, context));
        this.CaA = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
        this.CaB = com.tencent.mm.cb.a.jn(context) - com.tencent.mm.cb.a.aG(context, R.dimen.c2);
        this.rrd = new float[2];
        this.CaF = new g(this);
        setEnableFling(false);
        if (p.j(Looper.myLooper(), Looper.getMainLooper())) {
            getTouchDetector().setIsLongpressEnabled(false);
        }
        LayoutInflater.from(context).inflate(R.layout.c5e, (ViewGroup) this, true);
        LayoutInflater.from(context).inflate(R.layout.c5d, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.air);
        p.g(findViewById, "findViewById(R.id.caption_float_comment)");
        this.Caz = findViewById;
        getCaptionView().setText(com.tencent.mm.cb.a.aI(context, R.string.hw2));
        setOnTouchListener(this);
        AppMethodBeat.o(237609);
    }

    public static final /* synthetic */ PhotoTextView c(a aVar) {
        AppMethodBeat.i(237612);
        PhotoTextView captionView = aVar.getCaptionView();
        AppMethodBeat.o(237612);
        return captionView;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean aLB(String str) {
        AppMethodBeat.i(237611);
        p.h(str, "objID");
        boolean a2 = c.a.a(this, str);
        AppMethodBeat.o(237611);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean eLK() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.ui.editor.a$a  reason: collision with other inner class name */
    public static final class C1656a {
        private C1656a() {
        }

        public /* synthetic */ C1656a(byte b2) {
            this();
        }
    }

    public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker() {
        return this.rqT;
    }

    public final int getTouchSlop() {
        return this.rZ;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ Context $context;
        final /* synthetic */ a CaH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, Context context) {
            super(0);
            this.CaH = aVar;
            this.$context = context;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$1$1"})
        /* renamed from: com.tencent.mm.plugin.recordvideo.ui.editor.a$d$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1657a implements View.OnClickListener {
            final /* synthetic */ d CaI;

            View$OnClickListenerC1657a(d dVar) {
                this.CaI = dVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237579);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ViewParent parent = this.CaI.CaH.getParent();
                if (parent == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(237579);
                    throw tVar;
                }
                ((ViewGroup) parent).removeView(this.CaI.CaH);
                kotlin.g.a.b<View, x> clearCaptionListener = this.CaI.CaH.getClearCaptionListener();
                if (clearCaptionListener != null) {
                    clearCaptionListener.invoke(this.CaI.CaH);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237579);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(237580);
            LinearLayout linearLayout = (LinearLayout) this.CaH.findViewById(R.id.aiw);
            View findViewById = linearLayout.findViewById(R.id.aix);
            p.g(findViewById, "view.findViewById<TextVi…R.id.caption_loading_tip)");
            ((TextView) findViewById).setText(com.tencent.mm.cb.a.aI(this.$context, R.string.hw2));
            TextView textView = (TextView) linearLayout.findViewById(R.id.aiv);
            p.g(textView, LocaleUtil.ITALIAN);
            textView.setText(com.tencent.mm.cb.a.aI(this.$context, R.string.hvz));
            textView.setOnClickListener(new View$OnClickListenerC1657a(this));
            AppMethodBeat.o(237580);
            return linearLayout;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.view.View, kotlin.x>, kotlin.g.a.b<android.view.View, kotlin.x> */
    public final kotlin.g.a.b<View, x> getClearCaptionListener() {
        return this.CaD;
    }

    public final void setClearCaptionListener(kotlin.g.a.b<? super View, x> bVar) {
        this.CaD = bVar;
    }

    public final boolean getEnableEdit() {
        return this.CaE;
    }

    public final void setEnableEdit(boolean z) {
        this.CaE = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ a CaH;

        g(a aVar) {
            this.CaH = aVar;
        }

        public final void run() {
            AppMethodBeat.i(237583);
            a.c(this.CaH).setBackgroundDrawable(null);
            AppMethodBeat.o(237583);
        }
    }

    public final boolean a(com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar) {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar2;
        AppMethodBeat.i(237588);
        p.h(dVar, "type");
        com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar = this.Can;
        if (cVar != null) {
            dVar2 = cVar.Cex;
        } else {
            dVar2 = null;
        }
        if (dVar2 == dVar) {
            AppMethodBeat.o(237588);
            return true;
        }
        AppMethodBeat.o(237588);
        return false;
    }

    public final void setCaptionItem(com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar) {
        AppMethodBeat.i(237589);
        p.h(cVar, "captionItem");
        this.Can = cVar;
        getCaptionLayout().measure(0, 0);
        com.tencent.mm.plugin.recordvideo.ui.editor.c.c cVar2 = this.rqT;
        RelativeLayout captionLayout = getCaptionLayout();
        p.g(captionLayout, "captionLayout");
        cVar2.height = captionLayout.getMeasuredHeight();
        RectF rectF = this.Car;
        RelativeLayout captionLayout2 = getCaptionLayout();
        p.g(captionLayout2, "captionLayout");
        rectF.bottom = (float) captionLayout2.getMeasuredHeight();
        eLJ();
        if (cVar.textColor != 0) {
            getCaptionView().setTextColor(cVar.textColor);
        }
        getCaptionView().setTextBackground(cVar.bgColor);
        if (TextUtils.isEmpty(cVar.CeI)) {
            PhotoTextView captionView = getCaptionView();
            PhotoTextView captionView2 = getCaptionView();
            p.g(captionView2, "captionView");
            captionView.setTypeface(captionView2.getTypeface(), 1);
        } else if (s.YS(cVar.CeI)) {
            PhotoTextView captionView3 = getCaptionView();
            p.g(captionView3, "captionView");
            captionView3.setTypeface(Typeface.createFromFile(cVar.CeI));
        } else {
            PhotoTextView captionView4 = getCaptionView();
            p.g(captionView4, "captionView");
            captionView4.setTypeface(Typeface.DEFAULT);
        }
        StringBuilder sb = new StringBuilder("height:");
        PhotoTextView captionView5 = getCaptionView();
        p.g(captionView5, "captionView");
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.CaptionItemView", sb.append(captionView5.getMeasuredHeight()).append(" caption:").append(cVar).toString());
        AppMethodBeat.o(237589);
    }

    public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar) {
        AppMethodBeat.i(237590);
        p.h(cVar, "captionItem");
        this.Can = cVar;
        if (cVar.textColor != 0) {
            getCaptionView().setTextColor(cVar.textColor);
        }
        getCaptionView().setTextBackground(cVar.bgColor);
        if (TextUtils.isEmpty(cVar.CeI)) {
            PhotoTextView captionView = getCaptionView();
            PhotoTextView captionView2 = getCaptionView();
            p.g(captionView2, "captionView");
            captionView.setTypeface(captionView2.getTypeface(), 1);
        } else if (s.YS(cVar.CeI)) {
            PhotoTextView captionView3 = getCaptionView();
            p.g(captionView3, "captionView");
            captionView3.setTypeface(Typeface.createFromFile(cVar.CeI));
        } else {
            PhotoTextView captionView4 = getCaptionView();
            p.g(captionView4, "captionView");
            captionView4.setTypeface(Typeface.DEFAULT);
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.CaptionItemView", "updateCaptionItem caption:".concat(String.valueOf(cVar)));
        AppMethodBeat.o(237590);
    }

    public final void setStateResolve(EditorItemContainer.b bVar) {
        AppMethodBeat.i(237591);
        p.h(bVar, "stateResolve");
        this.Caq = bVar;
        AppMethodBeat.o(237591);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean Ig(long j2) {
        String str;
        boolean z;
        com.tencent.mm.bw.b bVar;
        AppMethodBeat.i(237592);
        this.CaC = j2;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar = this.Can;
        sy Ii = cVar != null ? cVar.Ii(j2) : null;
        if (Ii == null || (bVar = Ii.LaS) == null) {
            str = null;
        } else {
            str = bVar.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        }
        if (!TextUtils.isEmpty(str)) {
            setVisibility(0);
            getCaptionView().setAutoSizeTextTypeWithDefaults(0);
            PhotoTextView captionView = getCaptionView();
            p.g(captionView, "captionView");
            captionView.setText("");
            getCaptionView().setTextSize(0, (float) com.tencent.mm.cb.a.aG(getContext(), R.dimen.hd));
            getCaptionView().setAutoSizeTextTypeWithDefaults(1);
            PhotoTextView captionView2 = getCaptionView();
            p.g(captionView2, "captionView");
            captionView2.setVisibility(0);
            PhotoTextView captionView3 = getCaptionView();
            p.g(captionView3, "captionView");
            captionView3.setText(str);
            if (Ii == null) {
                p.hyc();
            }
            if (!Ii.LaV) {
                z = true;
            } else {
                z = false;
            }
            this.CaE = z;
            if (!this.CaE) {
                getCaptionView().setBackgroundDrawable(null);
                com.tencent.mm.audio.mix.i.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set INVISIBLE");
                LinearLayout captionContentLayout = getCaptionContentLayout();
                p.g(captionContentLayout, "captionContentLayout");
                captionContentLayout.setVisibility(4);
                LinearLayout captionLoadingLayout = getCaptionLoadingLayout();
                p.g(captionLoadingLayout, "captionLoadingLayout");
                captionLoadingLayout.setVisibility(0);
            } else {
                com.tencent.mm.audio.mix.i.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set VISIBLE");
                LinearLayout captionContentLayout2 = getCaptionContentLayout();
                p.g(captionContentLayout2, "captionContentLayout");
                captionContentLayout2.setVisibility(0);
                LinearLayout captionLoadingLayout2 = getCaptionLoadingLayout();
                p.g(captionLoadingLayout2, "captionLoadingLayout");
                captionLoadingLayout2.setVisibility(4);
            }
            AppMethodBeat.o(237592);
            return true;
        }
        com.tencent.mm.audio.mix.i.b.d("MicroMsg.CaptionItemView", "text it empty, set INVISIBLE");
        setVisibility(4);
        AppMethodBeat.o(237592);
        return false;
    }

    public final sy getCurrentCaption() {
        AppMethodBeat.i(237593);
        com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar = this.Can;
        if (cVar != null) {
            long j2 = this.CaC;
            for (T t : cVar.CeH) {
                if (t.LaT <= j2 && t.LaU >= j2) {
                    AppMethodBeat.o(237593);
                    return t;
                }
            }
            AppMethodBeat.o(237593);
            return null;
        }
        AppMethodBeat.o(237593);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(237594);
        p.h(canvas, "canvas");
        canvas.save();
        canvas.clipRect(this.Cao);
        super.dispatchDraw(canvas);
        canvas.restore();
        AppMethodBeat.o(237594);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO() {
        AppMethodBeat.i(237595);
        com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar = this.Can;
        if (cVar != null) {
            Matrix matrix = new Matrix();
            RelativeLayout captionLayout = getCaptionLayout();
            p.g(captionLayout, "captionLayout");
            float scaleX = captionLayout.getScaleX();
            RelativeLayout captionLayout2 = getCaptionLayout();
            p.g(captionLayout2, "captionLayout");
            matrix.postScale(scaleX, captionLayout2.getScaleY());
            int[] iArr = new int[2];
            getCaptionLayout().getLocationOnScreen(iArr);
            matrix.postTranslate(0.0f, (float) iArr[1]);
            com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(cVar.Cex, cVar.CeH, matrix);
            cVar2.CeI = cVar.CeI;
            cVar2.textColor = cVar.textColor;
            cVar2.bgColor = cVar.bgColor;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar3 = cVar2;
            AppMethodBeat.o(237595);
            return cVar3;
        }
        AppMethodBeat.o(237595);
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void b(Rect rect, int i2) {
        AppMethodBeat.i(237596);
        p.h(rect, "safeRect");
        this.rqT.BKm = rect;
        this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), i2);
        AppMethodBeat.o(237596);
    }

    public final Rect getSafeArea() {
        AppMethodBeat.i(237597);
        Rect rect = this.rqT.BKm;
        if (rect == null) {
            Resources resources = getResources();
            p.g(resources, "resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            p.g(resources2, "resources");
            rect = new Rect(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.o(237597);
        return rect;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(237598);
        p.h(rect, "validRect");
        this.Cao.set(rect);
        eLI();
        eLJ();
        ViewGroup.LayoutParams layoutParams = this.Caz.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(237598);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.topMargin != rect.bottom - this.CaA) {
            marginLayoutParams.topMargin = rect.bottom - this.CaA;
            this.Caz.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(237598);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void a(Rect rect, float f2) {
        AppMethodBeat.i(237599);
        p.h(rect, "displayRect");
        this.Cap.set(rect);
        this.rqT.width = rect.width();
        this.Car.right = (float) rect.width();
        measure(0, 0);
        RelativeLayout captionLayout = getCaptionLayout();
        p.g(captionLayout, "captionLayout");
        int measuredHeight = captionLayout.getMeasuredHeight();
        LinearLayout captionContentLayout = getCaptionContentLayout();
        p.g(captionContentLayout, "captionContentLayout");
        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        float measuredHeight2 = (((float) com.tencent.mm.plugin.recordvideo.background.e.getVisibleRect().bottom) - (((float) (measuredHeight + captionContentLayout.getMeasuredHeight())) / 2.0f)) - ((float) this.CaA);
        this.rqT.o(new float[]{0.0f, 0.0f, (float) this.rqT.width, 0.0f, 0.0f, (float) this.rqT.height, (float) this.rqT.width, (float) this.rqT.height});
        this.Cat.postTranslate(0.0f, measuredHeight2);
        eLJ();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.CaptionItemView", "topMargin:" + measuredHeight2 + " width:" + rect.width());
        AppMethodBeat.o(237599);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(237600);
        super.setOnClickListener(onClickListener);
        this.dec = onClickListener;
        AppMethodBeat.o(237600);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final float[] getContentBoundary() {
        AppMethodBeat.i(237601);
        float[] fArr = (float[]) this.rqT.Chg.clone();
        AppMethodBeat.o(237601);
        return fArr;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType() {
        AppMethodBeat.i(237602);
        if (a(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.RECORD_CAPTION)) {
            com.tencent.mm.plugin.recordvideo.ui.editor.view.b bVar = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.EditItemTypeRecordCaption;
            AppMethodBeat.o(237602);
            return bVar;
        }
        com.tencent.mm.plugin.recordvideo.ui.editor.view.b bVar2 = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.EditItemTypeCaption;
        AppMethodBeat.o(237602);
        return bVar2;
    }

    private static float e(Matrix matrix) {
        AppMethodBeat.i(237603);
        p.h(matrix, "matrix");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        double d2 = (double) fArr[0];
        double d3 = (double) fArr[3];
        float sqrt = (float) Math.sqrt((d3 * d3) + (d2 * d2));
        AppMethodBeat.o(237603);
        return sqrt;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(237604);
        p.h(view, "v");
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.gZX = motionEvent.getX();
                this.gZY = motionEvent.getY();
                if (this.Cas.contains(this.gZX, this.gZY)) {
                    this.gZT = true;
                }
                this.gZU = false;
                this.rrd[0] = this.Car.width() / 2.0f;
                this.rrd[1] = this.Car.height() / 2.0f;
                this.Cat.mapPoints(this.rrd);
                break;
            case 1:
            case 3:
                this.gZT = false;
                this.Caz.setVisibility(4);
                com.tencent.mm.plugin.recordvideo.ui.editor.c.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
                Rect rect = this.Cao;
                aVar.aXu = 0.5f;
                aVar.aXt = 3.0f;
                aVar.n(new float[]{this.Car.width() / 2.0f, this.Car.height() / 2.0f});
                aVar.f(new RectF((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
                float[] fArr = {this.Car.width() / 2.0f, this.Car.height() / 2.0f};
                this.Cat.mapPoints(fArr);
                if (!aVar.CgM.contains(fArr[0], fArr[1])) {
                    aVar.f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
                }
                aVar.a(this.Cat, new f(this, motionEvent));
                break;
            case 2:
                float max = Math.max(Math.abs(motionEvent.getX() - this.gZX), Math.abs(motionEvent.getY() - this.gZY));
                if (!this.gZU) {
                    this.gZU = max > ((float) this.rZ);
                    break;
                }
                break;
        }
        if (this.gZT) {
            if (!(motionEvent.getAction() == 3 && motionEvent.getAction() == 1)) {
                bringToFront();
                if (this.CaE) {
                    getCaptionView().setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), R.drawable.fk));
                }
                EditorItemContainer.b bVar = this.Caq;
                if (bVar != null) {
                    bVar.d(this, motionEvent);
                }
                MMHandlerThread.removeRunnable(this.CaF);
                MMHandlerThread.postToMainThreadDelayed(this.CaF, 1500);
            }
            boolean onTouch = super.onTouch(view, motionEvent);
            AppMethodBeat.o(237604);
            return onTouch;
        }
        AppMethodBeat.o(237604);
        return false;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(237605);
        p.h(scaleGestureDetector, "detector");
        float focusY = scaleGestureDetector.getFocusY();
        float scaleFactor = 1.0f - scaleGestureDetector.getScaleFactor();
        this.Cat.postScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getScaleFactor());
        this.Cat.postTranslate(this.Car.centerX() * scaleFactor, focusY * scaleFactor);
        eLI();
        eLJ();
        AppMethodBeat.o(237605);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(237606);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        this.Cat.postTranslate(0.0f, -f3);
        eLI();
        eLJ();
        AppMethodBeat.o(237606);
        return true;
    }

    private void eLI() {
        AppMethodBeat.i(237607);
        LinearLayout captionContentLayout = getCaptionContentLayout();
        p.g(captionContentLayout, "captionContentLayout");
        float[] fArr = {this.Car.right, (float) captionContentLayout.getBottom()};
        this.Cat.mapPoints(fArr);
        float f2 = ((float) (this.Cao.bottom - this.CaA)) - fArr[1];
        if (f2 < 0.0f) {
            this.Cat.postTranslate(0.0f, f2);
            this.Caz.setVisibility(0);
        }
        AppMethodBeat.o(237607);
    }

    public final void eLJ() {
        AppMethodBeat.i(237608);
        this.Cat.mapRect(this.Cas, this.Car);
        float[] fArr = new float[9];
        this.Cat.getValues(fArr);
        float e2 = e(this.Cat);
        RelativeLayout captionLayout = getCaptionLayout();
        p.g(captionLayout, "captionLayout");
        captionLayout.setPivotX(0.0f);
        RelativeLayout captionLayout2 = getCaptionLayout();
        p.g(captionLayout2, "captionLayout");
        captionLayout2.setPivotY(0.0f);
        RelativeLayout captionLayout3 = getCaptionLayout();
        p.g(captionLayout3, "captionLayout");
        captionLayout3.setScaleX(e2);
        RelativeLayout captionLayout4 = getCaptionLayout();
        p.g(captionLayout4, "captionLayout");
        captionLayout4.setScaleY(e2);
        RelativeLayout captionLayout5 = getCaptionLayout();
        p.g(captionLayout5, "captionLayout");
        captionLayout5.setTranslationX(fArr[2]);
        RelativeLayout captionLayout6 = getCaptionLayout();
        p.g(captionLayout6, "captionLayout");
        captionLayout6.setTranslationY(fArr[5]);
        AppMethodBeat.o(237608);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData() {
        return this.Can;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final RectF getDrawRect() {
        return this.Cas;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<PhotoTextView> {
        final /* synthetic */ a CaH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(0);
            this.CaH = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ PhotoTextView invoke() {
            AppMethodBeat.i(237581);
            PhotoTextView photoTextView = (PhotoTextView) this.CaH.findViewById(R.id.aj0);
            AppMethodBeat.o(237581);
            return photoTextView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ a CaH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.CaH = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(237578);
            RelativeLayout relativeLayout = (RelativeLayout) this.CaH.findViewById(R.id.ais);
            AppMethodBeat.o(237578);
            return relativeLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ a CaH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.CaH = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(237577);
            LinearLayout linearLayout = (LinearLayout) this.CaH.findViewById(R.id.aip);
            AppMethodBeat.o(237577);
            return linearLayout;
        }
    }
}
