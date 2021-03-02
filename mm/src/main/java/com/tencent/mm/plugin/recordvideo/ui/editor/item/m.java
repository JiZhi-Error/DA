package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0017\u0010\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010>H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\nH\u0002J\t\u0010\u0001\u001a\u00020\\H\u0016J\t\u0010\u0001\u001a\u00020|H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000203J\t\u0010\u0001\u001a\u00020(H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u0013\u0010\u0001\u001a\u0002082\b\u0010\u0001\u001a\u00030\u0001H\u0016J\b\u0010\u0001\u001a\u00030\u0001J\u0018\u0010\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002050 \u0001J\u0011\u0010¡\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000203J\b\u0010¢\u0001\u001a\u00030\u0001J\u001b\u0010£\u0001\u001a\u00030\u00012\u0006\u0010'\u001a\u00020(2\u0007\u0010¤\u0001\u001a\u00020\fH\u0016J\u001c\u0010¥\u0001\u001a\u00030\u00012\u0007\u0010¦\u0001\u001a\u00020(2\u0007\u0010§\u0001\u001a\u00020\bH\u0016J\u0010\u0010¨\u0001\u001a\u00030\u00012\u0006\u0010N\u001a\u00020OJ\u0012\u0010©\u0001\u001a\u00030\u00012\u0006\u0010l\u001a\u00020(H\u0016J\u001a\u0010ª\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002050 \u0001H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R!\u00104\u001a\u0012\u0012\u0004\u0012\u0002050\u001bj\b\u0012\u0004\u0012\u000205`\u001d¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010-\"\u0004\bM\u0010/R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u000e\u0010[\u001a\u00020\\X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010X\"\u0004\b_\u0010ZR\u001a\u0010`\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010X\"\u0004\bb\u0010ZR\u001a\u0010c\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010:\"\u0004\be\u0010<R\u0011\u0010f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bg\u0010$R\u0014\u0010h\u001a\u00020iX\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u001a\u0010l\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010*\"\u0004\bn\u0010oR(\u0010q\u001a\u0004\u0018\u00010>2\b\u0010p\u001a\u0004\u0018\u00010>@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u000e\u0010v\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010w\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010B\"\u0004\by\u0010DR\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{X\u0004¢\u0006\u0004\n\u0002\u0010}R\u000e\u0010~\u001a\u00020\\X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/¨\u0006«\u0001"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_VERTICAL_OFFSET", "", "MARGIN", "TAG", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "bitmapList", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmapList", "()Ljava/util/ArrayList;", "setBitmapList", "(Ljava/util/ArrayList;)V", "curIndex", "getCurIndex", "()I", "setCurIndex", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "()J", "setDuration", "(J)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "lyricsItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "lyricsList", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "getLyricsList", "needInvalidate", "", "getNeedInvalidate", "()Z", "setNeedInvalidate", "(Z)V", "originMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "startTime", "getStartTime", "setStartTime", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "touchArray", "", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "setValidRect", "(Landroid/graphics/Rect;)V", "value", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "waveAlpha", "wavePaint", "getWavePaint", "setWavePaint", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "waveTime", "getWaveTime", "setWaveTime", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "createLyricsBitmap", "", "drawWave", "canvas", "Landroid/graphics/Canvas;", "fillAlpha", "fillWaveAlpha", "appearTime", "getContentBoundary", "getDrawRect", "getEditorData", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "nextIndex", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "renderLyrics", "lyricsInfo", "", "reshowLyrics", "resume", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "updateLyricsList", "plugin-recordvideo_release"})
public final class m extends View implements g, c {
    private final ArrayList<ckm> BOY = new ArrayList<>();
    private Rect Cao;
    private final Rect Cap;
    private EditorItemContainer.b Caq;
    private d CeD;
    private Matrix CeE;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
    private long CfC;
    private int CfD;
    private final long CfE = 50;
    private final long CfF = 200;
    private final long CfG = 3000;
    private final int CfH = 11;
    private final float CfI;
    private final float CfJ;
    private final int CfK;
    private final float CfL;
    private final float CfM;
    private final float CfN;
    private final int CfO;
    private final RectF[] CfP;
    private final float[] CfQ;
    private final float[] CfR;
    private final Matrix CfS;
    private ArrayList<Bitmap> CfT;
    private Paint CfU;
    public boolean CfV;
    private l CfW;
    private final String TAG = "MicroMsg.LyricsItemView";
    private int alpha;
    private final int apv;
    private long duration;
    private boolean gZU;
    private float gZX;
    private float gZY;
    private Paint paint;
    private final int qfm;
    private final int rZ;
    private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
    private int sTB;
    private long startTime;
    private CharSequence text;
    private float textSize;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.m<Matrix, Boolean, x> {
        final /* synthetic */ m CfX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m mVar) {
            super(2);
            this.CfX = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Matrix matrix, Boolean bool) {
            AppMethodBeat.i(237790);
            Matrix matrix2 = matrix;
            bool.booleanValue();
            p.h(matrix2, "m");
            this.CfX.getTouchTracker().gT.set(matrix2);
            this.CfX.postInvalidate();
            x xVar = x.SXb;
            AppMethodBeat.o(237790);
            return xVar;
        }
    }

    public m(Context context) {
        super(context);
        AppMethodBeat.i(76159);
        this.qfm = at.fromDPToPix(context, 1);
        this.CfI = ((float) this.qfm) * 1.5f;
        this.CfJ = ((float) this.qfm) * 9.0f;
        this.CfK = this.qfm;
        this.CfL = ((float) this.qfm) * 1.5f;
        this.CfM = ((float) this.qfm) * 12.0f;
        this.CfN = ((float) this.qfm) * 2.0f;
        this.CfO = this.qfm;
        this.apv = at.fromDPToPix(context, 32);
        int i2 = this.CfH;
        RectF[] rectFArr = new RectF[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            rectFArr[i3] = new RectF();
        }
        this.CfP = rectFArr;
        this.CfQ = new float[this.CfH];
        this.CfR = new float[9];
        this.CfS = new Matrix();
        this.rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
        this.textSize = getResources().getDimension(R.dimen.a1l);
        this.CeD = d.LYRICS;
        this.CfT = new ArrayList<>();
        this.paint = new Paint();
        this.CfU = new Paint();
        this.Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
        this.Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
        this.CfV = true;
        this.rqT.aXu = 0.5f;
        this.rqT.aXt = 3.0f;
        this.CfU.setColor(Color.parseColor("#CCFFFFFF"));
        Resources resources = getResources();
        p.g(resources, "resources");
        this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(resources);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(76159);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean Ig(long j2) {
        AppMethodBeat.i(237798);
        boolean a2 = c.a.a(this, j2);
        AppMethodBeat.o(237798);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean aLB(String str) {
        AppMethodBeat.i(237799);
        p.h(str, "objID");
        boolean a2 = c.a.a(this, str);
        AppMethodBeat.o(237799);
        return a2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final boolean eLK() {
        return true;
    }

    public final ArrayList<ckm> getLyricsList() {
        return this.BOY;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j2) {
        this.duration = j2;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j2) {
        this.startTime = j2;
    }

    public final long getWaveTime() {
        return this.CfC;
    }

    public final void setWaveTime(long j2) {
        this.CfC = j2;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker() {
        return this.rqT;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void setText(CharSequence charSequence) {
        this.text = charSequence;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f2) {
        this.textSize = f2;
    }

    public final d getSourceDataType() {
        return this.CeD;
    }

    public final void setSourceDataType(d dVar) {
        AppMethodBeat.i(237791);
        p.h(dVar, "<set-?>");
        this.CeD = dVar;
        AppMethodBeat.o(237791);
    }

    public final ArrayList<Bitmap> getBitmapList() {
        return this.CfT;
    }

    public final void setBitmapList(ArrayList<Bitmap> arrayList) {
        AppMethodBeat.i(76139);
        p.h(arrayList, "<set-?>");
        this.CfT = arrayList;
        AppMethodBeat.o(76139);
    }

    public final int getCurIndex() {
        return this.sTB;
    }

    public final void setCurIndex(int i2) {
        this.sTB = i2;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final void setPaint(Paint paint2) {
        AppMethodBeat.i(76140);
        p.h(paint2, "<set-?>");
        this.paint = paint2;
        AppMethodBeat.o(76140);
    }

    public final Paint getWavePaint() {
        return this.CfU;
    }

    public final void setWavePaint(Paint paint2) {
        AppMethodBeat.i(76141);
        p.h(paint2, "<set-?>");
        this.CfU = paint2;
        AppMethodBeat.o(76141);
    }

    public final Rect getValidRect() {
        return this.Cao;
    }

    public final void setValidRect(Rect rect) {
        AppMethodBeat.i(76142);
        p.h(rect, "<set-?>");
        this.Cao = rect;
        AppMethodBeat.o(76142);
    }

    public final Rect getDisplayRect() {
        return this.Cap;
    }

    public final boolean getNeedInvalidate() {
        return this.CfV;
    }

    public final void setNeedInvalidate(boolean z) {
        this.CfV = z;
    }

    public final Matrix getViewMatrix() {
        return this.CeE;
    }

    public final void setViewMatrix(Matrix matrix) {
        AppMethodBeat.i(76143);
        this.CeE = matrix;
        if (matrix != null) {
            this.rqT.setMatrix(matrix);
            Canvas canvas = new Canvas();
            canvas.save();
            if (this.CeE != null) {
                canvas.setMatrix(matrix);
            }
            if (isActivated()) {
                this.Cey.draw(canvas);
            }
        }
        AppMethodBeat.o(76143);
    }

    public final float getTouchDownX() {
        return this.gZX;
    }

    public final void setTouchDownX(float f2) {
        this.gZX = f2;
    }

    public final float getTouchDownY() {
        return this.gZY;
    }

    public final void setTouchDownY(float f2) {
        this.gZY = f2;
    }

    public final boolean getTouchMoved() {
        return this.gZU;
    }

    public final void setTouchMoved(boolean z) {
        this.gZU = z;
    }

    public final int getTouchSlop() {
        return this.rZ;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void setValidArea(Rect rect) {
        AppMethodBeat.i(76144);
        p.h(rect, "validRect");
        this.Cao.set(rect);
        AppMethodBeat.o(76144);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void a(Rect rect, float f2) {
        AppMethodBeat.i(76145);
        p.h(rect, "displayRect");
        this.Cap.set(rect);
        AppMethodBeat.o(76145);
    }

    public final void gm(List<? extends ckm> list) {
        float f2;
        int i2;
        AppMethodBeat.i(76146);
        p.h(list, "lyricsInfo");
        gn(list);
        eMt();
        int i3 = 0;
        int i4 = 0;
        for (T t : this.CfT) {
            if (t.getWidth() > i4) {
                i4 = t.getWidth();
            }
            if (t.getHeight() > i3) {
                i2 = t.getHeight();
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        if (!(i4 == 0 || i3 == 0)) {
            this.rqT.width = i4;
            this.rqT.height = i3;
            this.Cey.setBounds(0, 0, i4, i3);
            this.rqT.o(new float[]{0.0f, 0.0f, (float) i4, 0.0f, 0.0f, (float) i3, (float) i4, (float) i3});
            float height = (float) ((this.Cap.height() - at.fromDPToPix(getContext(), v2helper.VOIP_ENC_HEIGHT_LV1)) - i3);
            int i5 = this.apv;
            e eVar = e.BKp;
            if (i5 >= e.eIR().left) {
                f2 = (float) this.apv;
            } else {
                e eVar2 = e.BKp;
                f2 = (float) e.eIR().left;
            }
            this.rqT.gT.setTranslate(f2, height);
        }
        AppMethodBeat.o(76146);
    }

    public final void setStateResolve(EditorItemContainer.b bVar) {
        AppMethodBeat.i(76147);
        p.h(bVar, "stateResolve");
        this.Caq = bVar;
        AppMethodBeat.o(76147);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(237792);
        p.h(lVar, "item");
        this.CfW = lVar;
        setViewMatrix(lVar.gT);
        gn(lVar.CfA);
        eMt();
        this.CeD = d.LYRICS;
        AppMethodBeat.o(237792);
    }

    private final void gn(List<? extends ckm> list) {
        AppMethodBeat.i(76149);
        this.BOY.clear();
        ArrayList<ckm> arrayList = this.BOY;
        ArrayList arrayList2 = new ArrayList();
        for (T t : list) {
            if (!Util.isNullOrNil(t.lyrics)) {
                arrayList2.add(t);
            }
        }
        arrayList.addAll(arrayList2);
        AppMethodBeat.o(76149);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void eMt() {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.m.eMt():void");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(76151);
        p.h(motionEvent, "event");
        this.CfS.set(this.rqT.gT);
        this.CfS.getValues(this.CfR);
        float f2 = this.CfR[2];
        boolean Y = this.rqT.Y(motionEvent);
        this.rqT.gT.getValues(this.CfR);
        float f3 = this.CfR[5];
        this.rqT.gT.set(this.CfS);
        this.rqT.gT.setTranslate(f2, f3);
        if (Y) {
            EditorItemContainer.b bVar = this.Caq;
            if (bVar != null) {
                bVar.d(this, motionEvent);
            }
            bringToFront();
            postInvalidate();
        }
        if (Y) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.gZX = motionEvent.getX();
                    this.gZY = motionEvent.getY();
                    this.gZU = false;
                    break;
                case 1:
                    if (!this.gZU) {
                        performClick();
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.c.a aVar = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
                    Rect rect = this.Cao;
                    aVar.aXu = this.rqT.aXu;
                    aVar.aXt = this.rqT.aXt;
                    aVar.n(new float[]{((float) this.rqT.width) / 2.0f, ((float) this.rqT.height) / 2.0f});
                    aVar.f(new RectF((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
                    aVar.a(this.rqT.gT, new a(this));
                    break;
                case 2:
                    float max = Math.max(Math.abs(motionEvent.getX() - this.gZX), Math.abs(motionEvent.getY() - this.gZY));
                    if (!this.gZU) {
                        this.gZU = max > ((float) this.rZ);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(76151);
        return Y;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        boolean z;
        long j2;
        float max;
        AppMethodBeat.i(76152);
        p.h(canvas, "canvas");
        canvas.save();
        if (this.CeE != null) {
            canvas.setMatrix(this.CeE);
        } else {
            canvas.setMatrix(this.rqT.gT);
        }
        if (isActivated()) {
            this.Cey.draw(canvas);
        }
        if (!this.BOY.isEmpty()) {
            if (this.CfC == 0 || Util.milliSecondsToNow(this.CfC) > this.CfE) {
                this.CfC = System.currentTimeMillis();
                float f2 = 0.0f;
                RectF[] rectFArr = this.CfP;
                int i2 = 0;
                int length = rectFArr.length;
                int i3 = 0;
                while (i3 < length) {
                    RectF rectF = rectFArr[i3];
                    int i4 = i2 + 1;
                    float height = rectF.height();
                    if (height <= ((float) this.CfK)) {
                        this.CfQ[i2] = (float) (((double) this.CfJ) * Math.random());
                    } else if (height >= this.CfQ[i2]) {
                        this.CfQ[i2] = (float) this.CfK;
                    }
                    if (height <= this.CfQ[i2]) {
                        max = Math.min(this.CfN + height, this.CfJ);
                    } else {
                        max = Math.max(height - ((float) this.CfO), (float) this.CfK);
                    }
                    rectF.set(this.CfL + f2, (this.CfJ / 2.0f) - (max / 2.0f), f2 + this.CfL + this.CfI, (max / 2.0f) + (this.CfJ / 2.0f));
                    f2 = rectF.right;
                    i3++;
                    i2 = i4;
                }
            }
            long j3 = this.BOY.get(0).startTime;
            if (this.CfD < 255) {
                long j4 = this.CfF;
                long j5 = this.duration - j3;
                if (0 <= j5 && j4 >= j5) {
                    this.CfD = (int) ((((float) (this.duration - j3)) * 255.0f) / ((float) this.CfF));
                } else if (this.duration - j3 > this.CfF) {
                    this.CfD = 255;
                }
            }
            this.CfU.setAlpha(this.CfD);
            for (RectF rectF2 : this.CfP) {
                canvas.drawRect(rectF2, this.CfU);
            }
        }
        if (!this.BOY.isEmpty()) {
            this.duration = System.currentTimeMillis() - this.startTime;
            ckm ckm = (ckm) j.L(this.BOY, this.sTB + 1);
            if (ckm != null) {
                j2 = ckm.startTime;
            } else {
                j2 = this.BOY.get(this.sTB).startTime + this.CfG;
            }
            if (this.duration >= j2) {
                this.sTB++;
                if (this.sTB >= this.BOY.size()) {
                    this.sTB = 0;
                    this.startTime = System.currentTimeMillis();
                    this.duration = 0;
                }
            }
        }
        if (!this.CfT.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.sTB < this.CfT.size()) {
            if (this.sTB < this.BOY.size()) {
                long j6 = this.BOY.get(this.sTB).startTime;
                ckm ckm2 = (ckm) j.L(this.BOY, this.sTB + 1);
                long j7 = ckm2 != null ? ckm2.startTime : this.BOY.get(this.sTB).startTime + this.CfG;
                long j8 = this.CfF;
                long j9 = this.duration - j6;
                if (0 <= j9 && j8 >= j9) {
                    this.alpha = (int) ((255.0f * ((float) (this.duration - j6))) / ((float) this.CfF));
                } else {
                    long j10 = this.CfF;
                    long j11 = j7 - this.duration;
                    if (0 <= j11 && j10 >= j11) {
                        this.alpha = (int) ((((float) (j7 - this.duration)) / ((float) this.CfF)) * 255.0f);
                    } else if (this.duration - j6 > this.CfF && j7 - this.duration > this.CfF) {
                        this.alpha = 255;
                    }
                }
            }
            this.paint.setAlpha(this.alpha);
            canvas.drawBitmap(this.CfT.get(this.sTB), 0.0f, this.CfM, this.paint);
        }
        canvas.restore();
        if (this.CfV) {
            invalidate();
        }
        AppMethodBeat.o(76152);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        AppMethodBeat.i(237793);
        if (this.CfT.isEmpty()) {
            AppMethodBeat.o(237793);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (T t : this.BOY) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (i2 < this.CfT.size()) {
                Bitmap bitmap = this.CfT.get(i2);
                p.g(bitmap, "bitmapList[index]");
                arrayList.add(new f(t2, bitmap));
            }
            i2 = i3;
        }
        Matrix matrix2 = new Matrix();
        matrix2.postConcat(this.rqT.gT);
        g gVar = new g(arrayList, matrix2);
        AppMethodBeat.o(237793);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final a cJO() {
        AppMethodBeat.i(237794);
        if (this.CfT.isEmpty()) {
            AppMethodBeat.o(237794);
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postConcat(this.rqT.gT);
        l lVar = new l(this.BOY, matrix);
        AppMethodBeat.o(237794);
        return lVar;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final void b(Rect rect, int i2) {
        AppMethodBeat.i(237796);
        p.h(rect, "safeRect");
        this.rqT.BKm = rect;
        this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), 54);
        AppMethodBeat.o(237796);
    }

    public final Rect getSafeArea() {
        AppMethodBeat.i(76156);
        Rect rect = this.rqT.BKm;
        if (rect == null) {
            Resources resources = getResources();
            p.g(resources, "resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            Resources resources2 = getResources();
            p.g(resources2, "resources");
            rect = new Rect(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
        }
        AppMethodBeat.o(76156);
        return rect;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final float[] getContentBoundary() {
        AppMethodBeat.i(76157);
        float[] fArr = (float[]) this.rqT.Chg.clone();
        AppMethodBeat.o(76157);
        return fArr;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final a getEditorData() {
        return this.CfW;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final b getType() {
        return b.EditItemTypeLyrics;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.view.c
    public final RectF getDrawRect() {
        AppMethodBeat.i(237797);
        RectF rectF = new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
        AppMethodBeat.o(237797);
        return rectF;
    }

    public final void resume() {
        AppMethodBeat.i(76158);
        this.CfV = true;
        invalidate();
        AppMethodBeat.o(76158);
    }

    public final g b(l lVar) {
        AppMethodBeat.i(237795);
        p.h(lVar, "item");
        gm(lVar.CfA);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (T t : this.BOY) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            Bitmap bitmap = this.CfT.get(i2);
            p.g(bitmap, "bitmapList[index]");
            arrayList.add(new f(t, bitmap));
            i2 = i3;
        }
        g gVar = new g(arrayList, lVar.gT);
        AppMethodBeat.o(237795);
        return gVar;
    }
}
