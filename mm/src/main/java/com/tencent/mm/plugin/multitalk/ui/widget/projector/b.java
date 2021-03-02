package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 f2\u00020\u0001:\u0001fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010M\u001a\u00020DJ\u0006\u0010N\u001a\u00020DJ\u000e\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020DJ\u001e\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0012J\u000e\u0010W\u001a\u00020D2\u0006\u0010X\u001a\u00020\u001fJ\"\u0010Y\u001a\u00020D2\u0006\u0010\u0006\u001a\u00020Z2\u0012\b\u0002\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010\\J\u000e\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\u001fJ.\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020&2\u0006\u0010a\u001a\u00020\u00122\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001fJ\u0006\u0010e\u001a\u00020DR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001e\u0010'\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020&@BX\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001a\u0010?\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R*\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006g"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "value", "", "currentPageIndex", "getCurrentPageIndex", "()I", "setCurrentPageIndex", "(I)V", "editorPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "getEditorPlugin", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "setEditorPlugin", "(Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;)V", "isShowEditContainer", "", "mCurrentPageHeight", "getMCurrentPageHeight", "setMCurrentPageHeight", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "", "mCurrentScale", "setMCurrentScale", "(F)V", "mCurrentViewStatus", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFilePath", "", "getMFilePath", "()Ljava/lang/String;", "setMFilePath", "(Ljava/lang/String;)V", "mStrokeLayout", "Landroid/widget/FrameLayout;", "getMStrokeLayout", "()Landroid/widget/FrameLayout;", "setMStrokeLayout", "(Landroid/widget/FrameLayout;)V", "mToken", "getMToken", "setMToken", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "onSwitchReaderPageCallback", "Lkotlin/Function1;", "", "getOnSwitchReaderPageCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSwitchReaderPageCallback", "(Lkotlin/jvm/functions/Function1;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "doEnterDoodle", "getScreenBitmap", "canvas", "Landroid/graphics/Canvas;", "loadDoodle", "onViewStatusChange", "zoom", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "setView", "newScale", "left", "top", "needCorrect", "setXWeb", "show", "Companion", "plugin-multitalk_release"})
public final class b {
    public static final a zVR = new a((byte) 0);
    private Context context;
    String mFilePath;
    String mToken;
    int vfW;
    private a zQD;
    private e zQw;
    FrameLayout zVI = new FrameLayout(this.context);
    float zVJ = 1.0f;
    int zVK = -1;
    int zVL = -1;
    h.b zVM;
    int zVN;
    com.tencent.mm.plugin.multitalk.ui.a.b zVO = new com.tencent.mm.plugin.multitalk.ui.a.b(this.context, this.zQD, this.zQw);
    kotlin.g.a.b<? super Integer, x> zVP;
    boolean zVQ;

    static {
        AppMethodBeat.i(239908);
        AppMethodBeat.o(239908);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(Context context2, a aVar, e eVar) {
        p.h(context2, "context");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(239907);
        this.context = context2;
        this.zQD = aVar;
        this.zQw = eVar;
        com.tencent.mm.plugin.multitalk.ui.a.b bVar = this.zVO;
        if (bVar != null) {
            bVar.setDrawingEnable(false);
        }
        FrameLayout frameLayout = this.zVI;
        if (frameLayout != null) {
            frameLayout.addView(this.zVO);
        }
        FrameLayout frameLayout2 = this.zVI;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
            AppMethodBeat.o(239907);
            return;
        }
        AppMethodBeat.o(239907);
    }

    public final void show() {
        AppMethodBeat.i(239900);
        FrameLayout frameLayout = this.zVI;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            AppMethodBeat.o(239900);
            return;
        }
        AppMethodBeat.o(239900);
    }

    public static /* synthetic */ void a(b bVar, com.tencent.mm.media.widget.camerarecordview.b.b bVar2) {
        AppMethodBeat.i(239902);
        bVar.a(bVar2, (kotlin.g.a.a<x>) null);
        AppMethodBeat.o(239902);
    }

    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar, kotlin.g.a.a<x> aVar) {
        com.tencent.mm.view.b.b bVar2;
        AppMethodBeat.i(239901);
        p.h(bVar, "config");
        com.tencent.mm.plugin.multitalk.ui.a.b bVar3 = this.zVO;
        if (bVar3 != null) {
            p.h(bVar, "config");
            com.tencent.mm.plugin.multitalk.ui.a.a aVar2 = bVar3.zQC;
            bVar3.zQD.epf();
            p.h(bVar, "config");
            if (!aVar2.zQs) {
                aVar2.b(bVar);
            } else {
                Object[] objArr = new Object[1];
                Rect rect = bVar.rect;
                objArr[0] = rect != null ? rect.toShortString() : null;
                Log.printInfoStack("MicroMsg.MultiTalkEditPhotoContainerPlugin", "config is %s", objArr);
            }
            com.tencent.mm.view.l lVar = aVar2.zQo;
            if (lVar == null || (bVar2 = (com.tencent.mm.view.b.b) lVar.getBaseBoardView()) == null) {
                AppMethodBeat.o(239901);
                return;
            }
            bVar2.hgd();
            bVar2.invalidate();
            bVar2.uGD = aVar;
            bVar2.RnM = true;
            AppMethodBeat.o(239901);
            return;
        }
        AppMethodBeat.o(239901);
    }

    public final void epj() {
        AppMethodBeat.i(239903);
        com.tencent.mm.plugin.multitalk.ui.a.b bVar = this.zVO;
        if (bVar != null) {
            bVar.zQB.onClick(null);
            AppMethodBeat.o(239903);
            return;
        }
        AppMethodBeat.o(239903);
    }

    public final void epk() {
        com.tencent.mm.view.b.b bVar;
        AppMethodBeat.i(239904);
        com.tencent.mm.plugin.multitalk.ui.a.b bVar2 = this.zVO;
        if (bVar2 != null) {
            com.tencent.mm.plugin.multitalk.ui.a.a aVar = bVar2.zQC;
            aVar.zQq = null;
            com.tencent.mm.view.l lVar = aVar.zQo;
            if (lVar == null || (bVar = (com.tencent.mm.view.b.b) lVar.getBaseBoardView()) == null) {
                AppMethodBeat.o(239904);
                return;
            }
            bVar.getPresenter().gtl();
            bVar.postInvalidate();
            AppMethodBeat.o(239904);
            return;
        }
        AppMethodBeat.o(239904);
    }

    public final void t(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        Bitmap bitmap;
        com.tencent.mm.plugin.multitalk.ui.a.a multiTalkEditPhotoWrapper;
        com.tencent.mm.view.l lVar;
        AppMethodBeat.i(239905);
        p.h(canvas, "canvas");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        com.tencent.mm.plugin.multitalk.ui.a.b bVar = this.zVO;
        if (bVar != null) {
            i2 = bVar.getHeight();
        } else {
            i2 = 0;
        }
        com.tencent.mm.plugin.multitalk.ui.a.b bVar2 = this.zVO;
        if (bVar2 == null || (multiTalkEditPhotoWrapper = bVar2.getMultiTalkEditPhotoWrapper()) == null || (lVar = multiTalkEditPhotoWrapper.zQo) == null) {
            i3 = 0;
        } else {
            i3 = lVar.getHeight();
        }
        float f2 = (float) (i2 - i3);
        com.tencent.mm.plugin.multitalk.ui.a.b bVar3 = this.zVO;
        if (bVar3 != null) {
            com.tencent.mm.view.l lVar2 = bVar3.zQC.zQo;
            int width = lVar2 != null ? lVar2.getWidth() : 0;
            com.tencent.mm.view.l lVar3 = bVar3.zQC.zQo;
            if (lVar3 != null) {
                i4 = lVar3.getHeight();
            } else {
                i4 = 0;
            }
            if (width <= 0 || i4 <= 0) {
                bitmap = null;
            } else {
                if (!(bVar3.bitmap != null && bVar3.mWidth == width && bVar3.mHeight == i4)) {
                    bVar3.mWidth = width;
                    bVar3.mHeight = i4;
                    bVar3.bitmap = Bitmap.createBitmap(width, i4, Bitmap.Config.ARGB_8888);
                }
                Bitmap bitmap2 = bVar3.bitmap;
                if (bitmap2 == null) {
                    p.hyc();
                }
                Canvas canvas2 = new Canvas(bitmap2);
                canvas2.drawPaint(new Paint());
                canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                com.tencent.mm.view.l lVar4 = bVar3.zQC.zQo;
                if (lVar4 != null) {
                    lVar4.draw(canvas2);
                }
                bitmap = bVar3.bitmap;
            }
            if (bitmap != null) {
                Matrix matrix = new Matrix();
                matrix.postTranslate(0.0f, f2 / 2.0f);
                canvas.drawBitmap(bitmap, matrix, paint);
                AppMethodBeat.o(239905);
                return;
            }
        }
        AppMethodBeat.o(239905);
    }

    public final void sc(boolean z) {
        AppMethodBeat.i(239906);
        com.tencent.mm.plugin.multitalk.ui.a.b bVar = this.zVO;
        if (bVar != null) {
            d dVar = bVar.zQB;
            RelativeLayout relativeLayout = dVar.zQG;
            relativeLayout.removeAllViews();
            com.tencent.mm.plugin.recordvideo.plugin.doodle.b bVar2 = dVar.zQF;
            if (bVar2 != null) {
                bVar2.a(z, relativeLayout);
                AppMethodBeat.o(239906);
                return;
            }
            AppMethodBeat.o(239906);
            return;
        }
        AppMethodBeat.o(239906);
    }
}
