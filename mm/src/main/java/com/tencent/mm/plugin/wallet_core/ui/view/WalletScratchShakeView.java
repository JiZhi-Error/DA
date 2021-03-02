package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView extends FrameLayout {
    private a InA;
    b Inx;
    boolean Iny;
    boolean Inz;

    public interface a {
        void fTW();

        void yy(boolean z);
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setScratchShakeCallback(a aVar) {
        this.InA = aVar;
    }

    public final void onDestroy() {
        AppMethodBeat.i(71547);
        if (this.Inx != null) {
            b bVar = this.Inx;
            Log.i("MicroMsg.WalletScratchShakeView", "onDestroy");
            if (bVar.shakeSensor != null) {
                bVar.shakeSensor.cBo();
            }
        }
        AppMethodBeat.o(71547);
    }

    /* access modifiers changed from: package-private */
    public class b extends View {
        private Bitmap Ehf;
        private Canvas InB;
        Drawable InC;
        Paint InD;
        Paint InE;
        Path InF;
        Path InG;
        private float InH;
        private float InI;
        private int[] InJ;
        private int InK = -1;
        boolean InL;
        boolean InM;
        float InN;
        float InO;
        int InP;
        private boolean InQ;
        boolean InR;
        private float InS = 0.9f;
        Paint aYz;
        private boolean isStartShake = false;
        long lastShakeTime;
        private int meh = 0;
        int rZ;
        d shakeSensor;

        public b(Context context) {
            super(context);
        }

        static byte[] aD(Bitmap bitmap) {
            AppMethodBeat.i(71538);
            int[] iArr = {30, bitmap.getWidth() / 3, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getWidth() - 30};
            int[] iArr2 = {0, bitmap.getHeight()};
            ByteBuffer order = ByteBuffer.allocate(92).order(ByteOrder.nativeOrder());
            order.put((byte) 1);
            order.put((byte) 4);
            order.put((byte) 2);
            order.put((byte) 9);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(iArr[0]);
            order.putInt(iArr[1]);
            order.putInt(iArr[2]);
            order.putInt(iArr[3]);
            order.putInt(iArr2[0]);
            order.putInt(iArr2[1]);
            for (int i2 = 0; i2 < 9; i2++) {
                order.putInt(1);
            }
            byte[] array = order.array();
            AppMethodBeat.o(71538);
            return array;
        }

        private boolean fTX() {
            AppMethodBeat.i(71539);
            if (this.InO >= ((float) getHeight())) {
                this.InR = true;
                if (!this.InM) {
                    if (WalletScratchShakeView.this.InA != null) {
                        WalletScratchShakeView.this.InA.fTW();
                    }
                    this.InM = true;
                }
                if (this.InB != null) {
                    this.InG.reset();
                    this.InG.moveTo(0.0f, 0.0f);
                    this.InG.lineTo((float) getWidth(), 0.0f);
                    this.InG.lineTo((float) getWidth(), (float) getHeight());
                    this.InG.lineTo(0.0f, (float) getHeight());
                    this.InB.drawPath(this.InG, this.InE);
                }
                invalidate();
                AppMethodBeat.o(71539);
                return true;
            }
            AppMethodBeat.o(71539);
            return false;
        }

        private void fTY() {
            AppMethodBeat.i(71540);
            if (this.InB != null) {
                this.InG.reset();
                this.InG.moveTo(0.0f, this.InO);
                this.InG.cubicTo((float) (getWidth() / 2), (float) getHeight(), (float) (getWidth() / 2), 0.0f, (float) getWidth(), this.InN);
                this.InG.lineTo((float) getWidth(), 0.0f);
                this.InG.lineTo(0.0f, 0.0f);
                this.InB.drawPath(this.InG, this.InE);
            }
            invalidate();
            AppMethodBeat.o(71540);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.i(71541);
            canvas.save();
            if (this.Ehf == null) {
                int width = getWidth();
                int height = getHeight();
                Log.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", Integer.valueOf(width), Integer.valueOf(height), this.InC);
                this.Ehf = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.InB = new Canvas(this.Ehf);
                if (this.InC != null) {
                    this.InC.setBounds(new Rect(0, 0, width, height));
                    this.InC.draw(this.InB);
                }
                this.InJ = new int[(width * height)];
            }
            canvas.drawBitmap(this.Ehf, 0.0f, 0.0f, this.aYz);
            canvas.restore();
            AppMethodBeat.o(71541);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(71542);
            if (!WalletScratchShakeView.this.Inz) {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(71542);
                return onTouchEvent;
            }
            boolean z = false;
            switch (motionEvent.getAction()) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.InF.reset();
                    this.InF.moveTo(x, y);
                    this.InH = x;
                    this.InI = y;
                    invalidate();
                    if (!this.InL) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(71535);
                                if (WalletScratchShakeView.this.InA != null) {
                                    WalletScratchShakeView.this.InA.yy(true);
                                }
                                AppMethodBeat.o(71535);
                            }
                        }, 50);
                        this.InL = true;
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1:
                case 3:
                    this.InH = 0.0f;
                    this.InI = 0.0f;
                    this.InF.reset();
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(71536);
                            b.e(b.this);
                            AppMethodBeat.o(71536);
                        }
                    }, "ScratchShakeView_calcErasePercentAndCallEnd");
                    invalidate();
                    z = true;
                    break;
                case 2:
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    if (this.InB != null) {
                        int abs = (int) Math.abs(x2 - this.InH);
                        int abs2 = (int) Math.abs(y2 - this.InI);
                        if (abs >= this.rZ || abs2 >= this.rZ) {
                            this.InH = x2;
                            this.InI = y2;
                            this.InF.quadTo((this.InH + x2) / 2.0f, (this.InI + y2) / 2.0f, x2, y2);
                            this.InB.drawPath(this.InF, this.InD);
                            this.InF.reset();
                            this.InF.moveTo(this.InH, this.InI);
                        }
                    }
                    invalidate();
                    z = true;
                    break;
            }
            if (this.InR || ae(motionEvent) || !z) {
                boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(71542);
                return onTouchEvent2;
            }
            AppMethodBeat.o(71542);
            return true;
        }

        public final boolean ae(MotionEvent motionEvent) {
            AppMethodBeat.i(71543);
            if (this.Ehf != null && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 0)) {
                int width = getWidth();
                int height = getHeight();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int i2 = (y * width) + x;
                Log.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i2), Integer.valueOf(getWidth() * getHeight()));
                if (i2 > 0 && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                    if (this.Ehf.getPixel(x, y) == 0) {
                        AppMethodBeat.o(71543);
                        return true;
                    }
                    AppMethodBeat.o(71543);
                    return false;
                }
            }
            AppMethodBeat.o(71543);
            return false;
        }

        static /* synthetic */ void d(b bVar) {
            AppMethodBeat.i(71544);
            if (bVar.InR) {
                Log.i("MicroMsg.WalletScratchShakeView", "onStartShakeOrClick, already finish clear mask");
                AppMethodBeat.o(71544);
                return;
            }
            if (!bVar.fTX()) {
                if (!bVar.InQ) {
                    bVar.InN += (float) (bVar.getHeight() / 6);
                    bVar.fTY();
                } else {
                    bVar.InO += (float) (bVar.getHeight() / 6);
                    bVar.fTY();
                }
                bVar.InQ = !bVar.InQ;
                if (!bVar.InL) {
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(71534);
                            if (WalletScratchShakeView.this.InA != null) {
                                WalletScratchShakeView.this.InA.yy(false);
                            }
                            AppMethodBeat.o(71534);
                        }
                    }, 50);
                    bVar.InL = true;
                }
                bVar.fTX();
            }
            AppMethodBeat.o(71544);
        }

        static /* synthetic */ void e(b bVar) {
            AppMethodBeat.i(71545);
            int width = bVar.getWidth();
            int height = bVar.getHeight();
            bVar.Ehf.getPixels(bVar.InJ, 0, width, 0, 0, width, height);
            float f2 = (float) (width * height);
            float f3 = 0.0f;
            for (int i2 = 0; ((float) i2) < f2; i2++) {
                if (bVar.InJ[i2] == 0) {
                    f3 += 1.0f;
                }
            }
            float f4 = (f3 < 0.0f || f2 <= 0.0f) ? 0.0f : f3 / f2;
            Log.i("MicroMsg.WalletScratchShakeView", "erasePercent: %s", Float.valueOf(f4));
            Log.i("MicroMsg.WalletScratchShakeView", "");
            if (f4 >= bVar.InS) {
                bVar.InR = true;
                if (!bVar.InM) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(71537);
                            b.this.animate().alpha(0.0f).setDuration(100);
                            if (WalletScratchShakeView.this.InA != null) {
                                WalletScratchShakeView.this.InA.fTW();
                            }
                            AppMethodBeat.o(71537);
                        }
                    });
                    bVar.InM = true;
                }
            }
            AppMethodBeat.o(71545);
        }
    }
}
