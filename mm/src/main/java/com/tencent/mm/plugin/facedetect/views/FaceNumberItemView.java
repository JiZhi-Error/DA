package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class FaceNumberItemView extends View {
    static final long sWm = 29;
    Timer sWl;
    private boolean sWn;
    private Paint sWo;
    private RectF sWp;
    private Bitmap sWq;
    private int sWr;
    int sWs;
    Runnable sWt;

    static /* synthetic */ int b(FaceNumberItemView faceNumberItemView) {
        int i2 = faceNumberItemView.sWs;
        faceNumberItemView.sWs = i2 + 1;
        return i2;
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104166);
        this.sWl = null;
        this.sWn = false;
        this.sWo = null;
        this.sWp = null;
        this.sWq = null;
        this.sWr = 17;
        this.sWs = 0;
        this.sWt = new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(104163);
                if (FaceNumberItemView.this.sWs <= 30) {
                    FaceNumberItemView.b(FaceNumberItemView.this);
                    FaceNumberItemView.this.invalidate();
                    AppMethodBeat.o(104163);
                    return;
                }
                FaceNumberItemView.this.cTT();
                AppMethodBeat.o(104163);
            }
        };
        setLayerType(1, null);
        this.sWo = new Paint();
        this.sWo.setColor(context.getResources().getColor(R.color.od));
        this.sWo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.sWp = new RectF();
        AppMethodBeat.o(104166);
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(104167);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i2);
        if (i2 == R.drawable.c6x) {
            int dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.a41) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 8)) / 2;
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth() + (dimensionPixelSize * 2), decodeResource.getHeight() + 0, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 255, 255, 255);
            canvas.drawBitmap(decodeResource, (float) dimensionPixelSize, 0.0f, (Paint) null);
            this.sWq = createBitmap;
            AppMethodBeat.o(104167);
            return;
        }
        this.sWq = Bitmap.createScaledBitmap(decodeResource, com.tencent.mm.cb.a.fromDPToPix(getContext(), 48), decodeResource.getHeight(), false);
        AppMethodBeat.o(104167);
    }

    public void setGravity(int i2) {
        AppMethodBeat.i(104168);
        Log.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
        this.sWr = i2;
        AppMethodBeat.o(104168);
    }

    public final void cTT() {
        AppMethodBeat.i(104169);
        if (this.sWl != null) {
            this.sWl.cancel();
            this.sWl = null;
        }
        AppMethodBeat.o(104169);
    }

    class a extends TimerTask {
        private WeakReference<Runnable> sWv;

        /* synthetic */ a(FaceNumberItemView faceNumberItemView, Runnable runnable, byte b2) {
            this(runnable);
        }

        private a(Runnable runnable) {
            AppMethodBeat.i(104164);
            this.sWv = null;
            this.sWv = new WeakReference<>(runnable);
            AppMethodBeat.o(104164);
        }

        public final void run() {
            AppMethodBeat.i(104165);
            if (this.sWv == null || this.sWv.get() == null) {
                cancel();
                AppMethodBeat.o(104165);
                return;
            }
            MMHandlerThread.postToMainThread(this.sWv.get());
            AppMethodBeat.o(104165);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float width;
        float height;
        AppMethodBeat.i(104170);
        super.onDraw(canvas);
        if (this.sWr == 17) {
            width = (float) ((getWidth() - this.sWq.getWidth()) >> 1);
            height = (float) ((getHeight() - this.sWq.getHeight()) >> 1);
        } else if (this.sWr == 3) {
            height = (float) ((getHeight() - this.sWq.getHeight()) >> 1);
            width = 0.0f;
        } else if (this.sWr == 5) {
            width = (float) (getWidth() - this.sWq.getWidth());
            height = (float) ((getHeight() - this.sWq.getHeight()) >> 1);
        } else {
            Log.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
            width = (float) ((getWidth() - this.sWq.getWidth()) >> 1);
            height = (float) ((getHeight() - this.sWq.getHeight()) >> 1);
        }
        if (!this.sWn) {
            canvas.drawBitmap(this.sWq, width, height, (Paint) null);
        }
        this.sWp.set(width, 0.0f, ((((float) this.sWq.getWidth()) * ((float) this.sWs)) / 30.0f) + width, (float) getHeight());
        canvas.drawRect(this.sWp, this.sWo);
        AppMethodBeat.o(104170);
    }
}
