package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 .2\u00020\u0001:\u0001.B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\tJ\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J(\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0014J\u001e\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 J\u001a\u0010(\u001a\u00020\t2\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bJ\u000e\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u000bJ\u0016\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/view/board/MultiTalkBoardView;", "Lcom/tencent/mm/view/board/BaseBoardView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "callback", "Lkotlin/Function0;", "", "isLockRefresh", "", "mBaseScale", "", "mBaseTranslateX", "mBaseTranslateY", "mFilePath", "", "mFileToken", "mSlidForbidden", "clearScreen", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getMinScale", "isCanAdapted", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSelfTouch", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "setEnableToResponseSlid", "enable", "setScreenFileParams", "filePath", "fileToken", "Companion", "plugin-photoedit-sdk_release"})
public final class b extends a {
    public static final a RnS = new a((byte) 0);
    public boolean RnM;
    private float RnN = 1.0f;
    private float RnO;
    private float RnP;
    private boolean RnQ;
    private String RnR;
    private String mFilePath;
    public kotlin.g.a.a<x> uGD;

    static {
        AppMethodBeat.i(204712);
        AppMethodBeat.o(204712);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/board/MultiTalkBoardView$Companion;", "", "()V", "TAG", "", "plugin-photoedit-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(Context context, com.tencent.mm.bt.b bVar) {
        super(context, bVar);
        AppMethodBeat.i(204711);
        this.Rnv = this.drT;
        this.RnD = false;
        AppMethodBeat.o(204711);
    }

    public final void setEnableToResponseSlid(boolean z) {
        this.RnQ = z;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(204705);
        com.tencent.mm.bt.b presenter = getPresenter();
        p.g(presenter, "presenter");
        if (presenter.gtn()) {
            aB(motionEvent);
        }
        getPresenter().R(motionEvent);
        if (this.RnQ) {
            h.b(this.RnR, this.mFilePath, motionEvent);
        }
        boolean z = this.RnQ;
        AppMethodBeat.o(204705);
        return z;
    }

    public final void h(float f2, int i2, int i3) {
        AppMethodBeat.i(204706);
        Matrix matrix = new Matrix();
        matrix.postScale(this.RnN * f2, this.RnN * f2, 0.0f, 0.0f);
        matrix.postTranslate((float) i2, (float) i3);
        this.Rnv = matrix;
        invalidate();
        AppMethodBeat.o(204706);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(204707);
        super.onSizeChanged(i2, i3, i4, i5);
        Log.i("MicroMsg.MultiTalkBoardView", "onSizeChanged " + getRawLayoutRect().flattenToString() + ", " + i2 + ',' + i4);
        if (getRawLayoutRect() != null) {
            Rect rawLayoutRect = getRawLayoutRect();
            if (rawLayoutRect == null) {
                p.hyc();
            }
            float width = ((float) rawLayoutRect.width()) * 1.0f;
            Rect rawLayoutRect2 = getRawLayoutRect();
            if (rawLayoutRect2 == null) {
                p.hyc();
            }
            if (width / ((float) rawLayoutRect2.height()) > (((float) getWidth()) * 1.0f) / ((float) getHeight())) {
                float width2 = ((float) getWidth()) * 1.0f;
                Rect rawLayoutRect3 = getRawLayoutRect();
                if (rawLayoutRect3 == null) {
                    p.hyc();
                }
                this.RnN = width2 / (((float) rawLayoutRect3.width()) * 1.0f);
                this.RnO = 0.0f;
                float height = (float) getHeight();
                Rect rawLayoutRect4 = getRawLayoutRect();
                if (rawLayoutRect4 == null) {
                    p.hyc();
                }
                this.RnP = (height - (((float) rawLayoutRect4.height()) * this.RnN)) / 2.0f;
            } else {
                float height2 = ((float) getHeight()) * 1.0f;
                Rect rawLayoutRect5 = getRawLayoutRect();
                if (rawLayoutRect5 == null) {
                    p.hyc();
                }
                this.RnN = height2 / (((float) rawLayoutRect5.height()) * 1.0f);
                float width3 = (float) getWidth();
                Rect rawLayoutRect6 = getRawLayoutRect();
                if (rawLayoutRect6 == null) {
                    p.hyc();
                }
                this.RnO = (width3 - (((float) rawLayoutRect6.width()) * this.RnN)) / 2.0f;
                this.RnP = 0.0f;
            }
        }
        invalidate();
        AppMethodBeat.o(204707);
    }

    @Override // com.tencent.mm.view.b.a
    public final boolean hgb() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.b.a
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(204708);
        p.h(canvas, "canvas");
        if (this.Rnv != null) {
            this.drT.set(this.Rnv);
            canvas.setMatrix(this.Rnv);
        } else {
            canvas.setMatrix(getMainMatrix());
        }
        com.tencent.mm.bt.b presenter = getPresenter();
        p.g(presenter, "presenter");
        Bitmap gtm = presenter.gtm();
        if (gtm != null && !gtm.isRecycled()) {
            canvas.drawBitmap(gtm, 0.0f, 0.0f, (Paint) null);
        }
        getPresenter().onDraw(canvas);
        if (this.RnM) {
            this.RnM = false;
            kotlin.g.a.a<x> aVar = this.uGD;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(204708);
                return;
            }
        }
        AppMethodBeat.o(204708);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.b.a
    public final void aA(MotionEvent motionEvent) {
        AppMethodBeat.i(204709);
        p.h(motionEvent, "event");
        AppMethodBeat.o(204709);
    }

    @Override // com.tencent.mm.view.b.a
    public final float getMinScale() {
        AppMethodBeat.i(204710);
        com.tencent.mm.e.b gti = getPresenter().gti();
        p.g(gti, "presenter.getCurArtist<BaseArtist<*>>()");
        if (gti.XS() == com.tencent.mm.e.a.CROP_PHOTO) {
            int width = getBoardRect().width() / getRawLayoutRect().width();
            int height = getBoardRect().height() / getRawLayoutRect().height();
            if (width <= height) {
                width = height;
            }
            float curScale = ((float) width) * getCurScale();
            AppMethodBeat.o(204710);
            return curScale;
        }
        float minScale = super.getMinScale();
        AppMethodBeat.o(204710);
        return minScale;
    }
}
