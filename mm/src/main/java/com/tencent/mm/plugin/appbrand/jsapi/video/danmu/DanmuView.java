package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView extends View {
    private LinkedList<Float> ddH;
    public List<d> mAA;
    private int[] mAB;
    private volatile boolean mAC;
    private LinkedList<Long> mAD;
    private Paint mAE;
    private long mAF;
    private int mAq;
    private int mAr;
    private int mAs;
    private float mAt;
    private float mAu;
    private boolean mAv;
    private boolean mAw;
    private c mAx;
    private HashMap<Integer, ArrayList<d>> mAy;
    public final Deque<d> mAz;
    private final Context mContext;
    private volatile int status;

    static /* synthetic */ void c(DanmuView danmuView) {
        AppMethodBeat.i(137885);
        danmuView.bKq();
        AppMethodBeat.o(137885);
    }

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(137862);
        this.mAq = 5;
        this.mAr = 500;
        this.mAs = 10;
        this.mAt = 0.0f;
        this.mAu = 0.6f;
        this.mAv = false;
        this.mAw = false;
        this.mAz = new LinkedList();
        this.mAA = new LinkedList();
        this.status = 3;
        this.mAF = 0;
        this.mContext = context;
        AppMethodBeat.o(137862);
    }

    private static void N(float f2, float f3) {
        AppMethodBeat.i(137863);
        if (f2 >= f3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("start_Y_offset must < end_Y_offset");
            AppMethodBeat.o(137863);
            throw illegalArgumentException;
        } else if (f2 < 0.0f || f2 >= 1.0f || f3 < 0.0f || f3 > 1.0f) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
            AppMethodBeat.o(137863);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(137863);
        }
    }

    public final void prepare() {
        AppMethodBeat.i(137864);
        N(this.mAt, this.mAu);
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        bKm();
        AppMethodBeat.o(137864);
    }

    private void bKm() {
        AppMethodBeat.i(137865);
        bKn();
        bKo();
        AppMethodBeat.o(137865);
    }

    private void bKn() {
        AppMethodBeat.i(137866);
        this.mAy = new HashMap<>(this.mAq);
        for (int i2 = 0; i2 < this.mAq; i2++) {
            this.mAy.put(Integer.valueOf(i2), new ArrayList<>(this.mAs));
        }
        AppMethodBeat.o(137866);
    }

    private void bKo() {
        AppMethodBeat.i(137867);
        this.mAB = new int[this.mAq];
        float dW = b.dW(this.mContext);
        float height = this.mAt * ((float) getHeight());
        for (int i2 = 0; i2 < this.mAq; i2++) {
            this.mAB[i2] = (int) (((((float) (i2 + 1)) * dW) + height) - ((3.0f * dW) / 4.0f));
        }
        if (this.mAw) {
            this.ddH.clear();
            this.ddH.add(Float.valueOf(height));
            for (int i3 = 0; i3 < this.mAq; i3++) {
                this.ddH.add(Float.valueOf((((float) (i3 + 1)) * dW) + height));
            }
        }
        AppMethodBeat.o(137867);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int b2;
        AppMethodBeat.i(137868);
        super.onDraw(canvas);
        if (this.mAC) {
            Log.i("MicroMsg.DanmuView", "inTransition");
            AppMethodBeat.o(137868);
        } else if (this.status == 1) {
            try {
                canvas.drawColor(0);
                for (int i2 = 0; i2 < this.mAy.size(); i2++) {
                    Iterator<d> it = this.mAy.get(Integer.valueOf(i2)).iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        if (next.bKj()) {
                            it.remove();
                        } else {
                            next.b(canvas, false);
                        }
                    }
                }
                if (System.currentTimeMillis() - this.mAF > ((long) this.mAr)) {
                    this.mAF = System.currentTimeMillis();
                    synchronized (this.mAz) {
                        try {
                            if (this.mAz.size() > 0) {
                                int baT = this.mAx.baT();
                                d first = this.mAz.getFirst();
                                while (first != null && first.xD(baT)) {
                                    this.mAz.pollFirst();
                                    first = this.mAz.getFirst();
                                }
                                if (first != null && first.xC(baT) && (b2 = b(first)) >= 0) {
                                    first.eh(canvas.getWidth() - 2, this.mAB[b2]);
                                    first.b(canvas, false);
                                    this.mAy.get(Integer.valueOf(b2)).add(first);
                                    this.mAz.pollFirst();
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(137868);
                            throw th;
                        }
                    }
                }
                if (this.mAv && this.mAD != null) {
                    canvas.drawText("FPS:".concat(String.valueOf((int) bKu())), 5.0f, 20.0f, this.mAE);
                }
                if (this.mAw && this.ddH != null) {
                    Iterator<Float> it2 = this.ddH.iterator();
                    while (it2.hasNext()) {
                        float floatValue = it2.next().floatValue();
                        canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.mAE);
                    }
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", e2);
            }
            invalidate();
            AppMethodBeat.o(137868);
        } else {
            if (this.status == 2) {
                try {
                    canvas.drawColor(0);
                    for (int i3 = 0; i3 < this.mAy.size(); i3++) {
                        Iterator<d> it3 = this.mAy.get(Integer.valueOf(i3)).iterator();
                        while (it3.hasNext()) {
                            it3.next().b(canvas, true);
                        }
                    }
                    if (this.mAv && this.mAD != null) {
                        canvas.drawText("FPS:".concat(String.valueOf((int) bKu())), 5.0f, 20.0f, this.mAE);
                    }
                    if (this.mAw && this.ddH != null) {
                        Iterator<Float> it4 = this.ddH.iterator();
                        while (it4.hasNext()) {
                            float floatValue2 = it4.next().floatValue();
                            canvas.drawLine(0.0f, floatValue2, (float) getWidth(), floatValue2, this.mAE);
                        }
                    }
                } catch (Exception e3) {
                    Log.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", e3);
                }
                invalidate();
            }
            AppMethodBeat.o(137868);
        }
    }

    private int b(d dVar) {
        AppMethodBeat.i(137869);
        for (int i2 = 0; i2 < this.mAq; i2++) {
            try {
                int i3 = (i2 + 0) % this.mAq;
                ArrayList<d> arrayList = this.mAy.get(Integer.valueOf(i3));
                if (arrayList.size() == 0) {
                    AppMethodBeat.o(137869);
                    return i3;
                } else if (arrayList.size() <= this.mAs && !dVar.a(arrayList.get(arrayList.size() - 1))) {
                    AppMethodBeat.o(137869);
                    return i3;
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.DanmuView", "findVacant,Exception:" + e2.getMessage());
            }
        }
        AppMethodBeat.o(137869);
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(137870);
        super.onSizeChanged(i2, i3, i4, i5);
        bKo();
        AppMethodBeat.o(137870);
    }

    public final void bKp() {
        AppMethodBeat.i(137871);
        if (isMainThread()) {
            this.mAC = true;
            AppMethodBeat.o(137871);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(137857);
                DanmuView.this.mAC = true;
                AppMethodBeat.o(137857);
            }
        });
        AppMethodBeat.o(137871);
    }

    public final void bKq() {
        AppMethodBeat.i(137872);
        if (isMainThread()) {
            this.mAC = false;
            invalidate();
            AppMethodBeat.o(137872);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(137858);
                DanmuView.this.mAC = false;
                DanmuView.this.invalidate();
                AppMethodBeat.o(137858);
            }
        });
        AppMethodBeat.o(137872);
    }

    public final void show() {
        AppMethodBeat.i(137873);
        this.status = 1;
        invalidate();
        AppMethodBeat.o(137873);
    }

    public final void pause() {
        AppMethodBeat.i(137874);
        this.status = 2;
        invalidate();
        AppMethodBeat.o(137874);
    }

    public final void hide() {
        AppMethodBeat.i(137875);
        this.status = 4;
        invalidate();
        AppMethodBeat.o(137875);
    }

    public final void clear() {
        AppMethodBeat.i(137876);
        this.status = 3;
        clearItems();
        this.mAA.clear();
        invalidate();
        AppMethodBeat.o(137876);
    }

    public final void clearItems() {
        AppMethodBeat.i(137877);
        bKr();
        bKs();
        AppMethodBeat.o(137877);
    }

    private void bKr() {
        AppMethodBeat.i(137878);
        if (this.mAy != null && !this.mAy.isEmpty()) {
            this.mAy.clear();
        }
        AppMethodBeat.o(137878);
    }

    private void bKs() {
        AppMethodBeat.i(137879);
        synchronized (this.mAz) {
            try {
                if (!this.mAz.isEmpty()) {
                    this.mAz.clear();
                }
            } finally {
                AppMethodBeat.o(137879);
            }
        }
    }

    public void setMaxRow(int i2) {
        AppMethodBeat.i(137880);
        this.mAq = i2;
        if (this.mAy != null) {
            synchronized (this.mAy) {
                for (int i3 = 0; i3 < this.mAy.size(); i3++) {
                    try {
                        ArrayList<d> arrayList = this.mAy.get(Integer.valueOf(i3));
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(137880);
                        throw th;
                    }
                }
            }
        }
        bKm();
        AppMethodBeat.o(137880);
    }

    public void setPickItemInterval(int i2) {
        this.mAr = i2;
    }

    public void setMaxRunningPerRow(int i2) {
        this.mAs = i2;
    }

    public final void bKt() {
        this.mAt = 0.0f;
        this.mAu = 0.8f;
    }

    public float getYOffset() {
        return this.mAu - this.mAt;
    }

    public void setShowFps(boolean z) {
        AppMethodBeat.i(137881);
        this.mAv = z;
        if (z && (this.mAE == null || this.mAD == null)) {
            this.mAE = new TextPaint(1);
            this.mAE.setColor(-256);
            this.mAE.setTextSize(20.0f);
            this.mAD = new LinkedList<>();
        }
        AppMethodBeat.o(137881);
    }

    public void setShowLines(boolean z) {
        AppMethodBeat.i(137882);
        this.mAw = z;
        if (z && this.ddH == null) {
            this.ddH = new LinkedList<>();
        }
        AppMethodBeat.o(137882);
    }

    public void setDanmuViewCallBack(c cVar) {
        this.mAx = cVar;
    }

    public final void xE(final int i2) {
        AppMethodBeat.i(234904);
        Log.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", Integer.valueOf(i2));
        bKp();
        clearItems();
        prepare();
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass5 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "DanmuView-seekToPlayTime";
            }

            public final void run() {
                AppMethodBeat.i(137861);
                synchronized (DanmuView.this.mAz) {
                    try {
                        for (int size = DanmuView.this.mAA.size() - 1; size >= 0; size--) {
                            d dVar = (d) DanmuView.this.mAA.get(size);
                            if (dVar.bKk() < i2) {
                                break;
                            }
                            Log.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", Integer.valueOf(size), Integer.valueOf(dVar.bKk()));
                            DanmuView.this.mAz.addFirst(dVar);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(137861);
                        throw th;
                    }
                }
                DanmuView.c(DanmuView.this);
                AppMethodBeat.o(137861);
            }
        });
        AppMethodBeat.o(234904);
    }

    private double bKu() {
        AppMethodBeat.i(137883);
        long nanoTime = System.nanoTime();
        this.mAD.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - this.mAD.getFirst().longValue())) / 1.0E9d;
        if (this.mAD.size() > 100) {
            this.mAD.removeFirst();
        }
        if (longValue > 0.0d) {
            double size = ((double) this.mAD.size()) / longValue;
            AppMethodBeat.o(137883);
            return size;
        }
        AppMethodBeat.o(137883);
        return 0.0d;
    }

    private static boolean isMainThread() {
        AppMethodBeat.i(137884);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.o(137884);
            return true;
        }
        AppMethodBeat.o(137884);
        return false;
    }
}
