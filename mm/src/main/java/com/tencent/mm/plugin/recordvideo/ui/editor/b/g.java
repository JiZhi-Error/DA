package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J(\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J(\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u0004\u0018\u00010&J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010(\u001a\u00020$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "retrieverData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "retrieverTransform", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "blurBgEnable", "", "calcCenterCropScale", "drawingWidth", "drawingHeight", "videoWidth", "", "videoHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"})
public final class g implements b {
    public static final a CgL = new a((byte) 0);
    private Bitmap CgG;
    private Canvas CgH;
    private final Matrix CgI = new Matrix();
    private e CgJ = new e();
    private final d CgK;
    private final Canvas aTi;
    private final Bitmap bitmap;
    private final Matrix finalMatrix = new Matrix();
    public Bitmap ikc;
    private final Paint paint = new Paint();
    private final b rpA = new b(this.CgK.rpx);

    static {
        AppMethodBeat.i(237921);
        AppMethodBeat.o(237921);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public g(d dVar) {
        boolean z;
        boolean z2;
        int height;
        int i2;
        p.h(dVar, "retrieverData");
        AppMethodBeat.i(237920);
        this.CgK = dVar;
        Log.i("MicroMsg.StoryFrameRetriever", "create StoryFrameRetriever, " + this.CgK);
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        int i3 = this.CgK.width;
        int i4 = this.CgK.height;
        switch (this.CgK.dYT) {
            case 90:
            case 270:
                i4 = this.CgK.width;
                i3 = this.CgK.height;
                if (this.CgK.videoHeight <= this.CgK.videoWidth) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
            default:
                if (this.CgK.videoWidth <= this.CgK.videoHeight) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        e eVar = this.CgJ;
        float[] fArr = this.CgK.BKV;
        float[] fArr2 = this.CgK.BKW;
        p.h(fArr, "drawingRect");
        eVar.BKV = fArr;
        if (fArr2 == null || fArr2.length != 4) {
            z2 = false;
        } else if (fArr2[0] == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f && fArr2[3] == 0.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (fArr2 == null) {
                p.hyc();
            }
            eVar.BKW = fArr2;
            float f2 = fArr2[1];
            Log.i("MicroMsg.RetrieverTransform", "topOffset :".concat(String.valueOf(f2)));
            eVar.CgD.postTranslate(0.0f, -f2);
        }
        if (eMw()) {
            Bitmap createBitmap = Bitmap.createBitmap(this.CgK.width, this.CgK.height, Bitmap.Config.ARGB_8888);
            p.g(createBitmap, "Bitmap.createBitmap(retr… Bitmap.Config.ARGB_8888)");
            this.bitmap = createBitmap;
            float a2 = a(this.CgK.width, this.CgK.height, this.CgK.BKV[2], this.CgK.BKV[3]);
            Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(a2)));
            this.CgI.postScale(a2, a2);
            if (this.CgK.CgB && z && (this.CgK.dYT == 90 || this.CgK.dYT == 270 || this.CgK.dYT == 180)) {
                this.CgG = Bitmap.createBitmap(this.CgK.height, this.CgK.width, Bitmap.Config.ARGB_8888);
                Bitmap bitmap2 = this.CgG;
                if (bitmap2 == null) {
                    p.hyc();
                }
                this.CgH = new Canvas(bitmap2);
                float f3 = 360.0f - ((float) this.CgK.dYT);
                this.finalMatrix.postRotate(f3);
                if (f3 == 90.0f) {
                    Matrix matrix = this.finalMatrix;
                    Canvas canvas = this.CgH;
                    if (canvas == null) {
                        p.hyc();
                    }
                    matrix.postTranslate((float) canvas.getWidth(), 0.0f);
                } else if (f3 == 270.0f) {
                    Matrix matrix2 = this.finalMatrix;
                    Canvas canvas2 = this.CgH;
                    if (canvas2 == null) {
                        p.hyc();
                    }
                    matrix2.postTranslate(0.0f, (float) canvas2.getHeight());
                }
            }
            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(this.CgK.BLa, this.CgK.height, this.CgK.width, true);
            if (extractThumbNail != null) {
                float width = ((float) this.CgK.width) / ((float) extractThumbNail.getWidth());
                float height2 = ((float) this.CgK.height) / ((float) extractThumbNail.getHeight());
                if (width == 1.0f && height2 == 1.0f) {
                    this.ikc = extractThumbNail;
                } else {
                    float max = Math.max(width, height2);
                    Bitmap rotateAndScale = BitmapUtil.rotateAndScale(extractThumbNail, 0.0f, max, max);
                    p.g(rotateAndScale, "scaledBitmap");
                    int width2 = rotateAndScale.getWidth();
                    int height3 = rotateAndScale.getHeight();
                    if (width < height2) {
                        i2 = (rotateAndScale.getWidth() - this.CgK.width) / 2;
                        width2 = i2 + this.CgK.width;
                        height = 0;
                    } else {
                        height = (rotateAndScale.getHeight() - this.CgK.height) / 2;
                        height3 = this.CgK.height + height;
                        i2 = 0;
                    }
                    this.ikc = Bitmap.createBitmap(rotateAndScale, i2, height, width2, height3);
                }
                if (this.CgK.CgB && this.CgK.dYT != 0) {
                    this.ikc = BitmapUtil.rotate(this.ikc, 360.0f - ((float) this.CgK.dYT));
                }
            }
        } else if (this.CgK.CgB) {
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            p.g(createBitmap2, "Bitmap.createBitmap(real… Bitmap.Config.ARGB_8888)");
            this.bitmap = createBitmap2;
            if (this.CgK.dYT == 90 || this.CgK.dYT == 270 || this.CgK.dYT == 180) {
                this.CgG = Bitmap.createBitmap(this.CgK.width, this.CgK.height, Bitmap.Config.ARGB_8888);
                Bitmap bitmap3 = this.CgG;
                if (bitmap3 == null) {
                    p.hyc();
                }
                this.CgH = new Canvas(bitmap3);
                float f4 = 360.0f - ((float) this.CgK.dYT);
                this.finalMatrix.postRotate(f4);
                if (f4 == 90.0f) {
                    Matrix matrix3 = this.finalMatrix;
                    Canvas canvas3 = this.CgH;
                    if (canvas3 == null) {
                        p.hyc();
                    }
                    matrix3.postTranslate((float) canvas3.getWidth(), 0.0f);
                } else if (f4 == 270.0f) {
                    Matrix matrix4 = this.finalMatrix;
                    Canvas canvas4 = this.CgH;
                    if (canvas4 == null) {
                        p.hyc();
                    }
                    matrix4.postTranslate(0.0f, (float) canvas4.getHeight());
                }
            }
            float a3 = a(i3, i4, this.CgK.BKV[2], this.CgK.BKV[3]);
            Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(a3)));
            this.CgI.postScale(a3, a3);
        } else {
            Bitmap createBitmap3 = Bitmap.createBitmap(Math.min(this.CgK.width, this.CgK.height), Math.max(this.CgK.width, this.CgK.height), Bitmap.Config.ARGB_8888);
            p.g(createBitmap3, "Bitmap.createBitmap(Math… Bitmap.Config.ARGB_8888)");
            this.bitmap = createBitmap3;
            float a4 = a(Math.min(this.CgK.width, this.CgK.height), Math.max(this.CgK.width, this.CgK.height), this.CgK.BKV[2], this.CgK.BKV[3]);
            Log.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(a4)));
            this.CgI.postScale(a4, a4);
        }
        this.aTi = new Canvas(this.bitmap);
        AppMethodBeat.o(237920);
    }

    private static float a(int i2, int i3, float f2, float f3) {
        float f4 = ((float) i2) / f2;
        if (f4 == ((float) i3) / f3) {
            return f4;
        }
        float f5 = ((float) i2) / f2;
        float f6 = ((float) i3) / f3;
        if (i2 > i3) {
            return f5;
        }
        if (f5 < f6) {
            return f6;
        }
        if (f5 <= f6) {
            return 1.0f;
        }
        return f5;
    }

    public final boolean eMw() {
        boolean z;
        AppMethodBeat.i(237916);
        if (this.CgK.BLa.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !s.YS(this.CgK.BLa)) {
            AppMethodBeat.o(237916);
            return false;
        }
        AppMethodBeat.o(237916);
        return true;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.b.b
    public final a cJu() {
        long j2;
        AppMethodBeat.i(237917);
        if (this.CgK.rpx.size() == 0) {
            AppMethodBeat.o(237917);
            return null;
        }
        int save = this.aTi.save();
        this.aTi.drawColor(0, PorterDuff.Mode.MULTIPLY);
        this.aTi.concat(this.CgI);
        e eVar = this.CgJ;
        Canvas canvas = this.aTi;
        p.h(canvas, "canvas");
        eVar.CgC = canvas.save();
        canvas.concat(eVar.CgD);
        try {
            j2 = this.rpA.a(this.aTi, this.paint);
        } catch (Exception e2) {
            j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        e eVar2 = this.CgJ;
        Canvas canvas2 = this.aTi;
        p.h(canvas2, "canvas");
        if (eVar2.CgC <= 0) {
            Log.w("MicroMsg.RetrieverTransform", "canvas restore saveCount: " + eVar2.CgC);
        } else {
            canvas2.restoreToCount(eVar2.CgC);
        }
        if (save <= 0) {
            Log.w("MicroMsg.StoryFrameRetriever", "canvas restore saveCount: ".concat(String.valueOf(save)));
        } else {
            this.aTi.restoreToCount(save);
        }
        if (this.CgH == null || this.CgG == null) {
            a aVar = new a(this.bitmap, j2);
            AppMethodBeat.o(237917);
            return aVar;
        }
        Canvas canvas3 = this.CgH;
        if (canvas3 != null) {
            canvas3.drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        Canvas canvas4 = this.CgH;
        if (canvas4 != null) {
            canvas4.save();
        }
        Canvas canvas5 = this.CgH;
        if (canvas5 == null) {
            p.hyc();
        }
        canvas5.drawBitmap(this.bitmap, this.finalMatrix, null);
        Canvas canvas6 = this.CgH;
        if (canvas6 != null) {
            canvas6.restore();
        }
        Bitmap bitmap2 = this.CgG;
        if (bitmap2 == null) {
            p.hyc();
        }
        a aVar2 = new a(bitmap2, j2);
        AppMethodBeat.o(237917);
        return aVar2;
    }

    public final void start() {
        AppMethodBeat.i(237918);
        try {
            Iterator<T> it = this.CgK.rpx.iterator();
            while (it.hasNext()) {
                it.next().init();
            }
            AppMethodBeat.o(237918);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", e2, "start error", new Object[0]);
            AppMethodBeat.o(237918);
        }
    }

    public final void destroy() {
        AppMethodBeat.i(237919);
        try {
            Iterator<T> it = this.CgK.rpx.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            AppMethodBeat.o(237919);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", e2, "destroy error", new Object[0]);
            AppMethodBeat.o(237919);
        }
    }
}
