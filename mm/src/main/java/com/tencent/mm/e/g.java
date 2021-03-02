package com.tencent.mm.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g {
    c dgO;
    Rect dgS;
    float dsA;
    float dsB;
    float dsC;
    float dsD;
    private int dsd = ((int) MMApplicationContext.getResources().getDimension(R.dimen.u8));
    Rect dsl;
    private boolean dsr = false;
    private float dsy;
    private float dsz;
    float dtn;
    private int dto = 0;
    private Rect dtp;
    int dtq;
    int dtr;
    int dtt;
    int dtu;

    public g(c cVar, float f2, Rect rect) {
        AppMethodBeat.i(204729);
        this.dtn = f2;
        this.dgO = cVar;
        this.dgS = rect;
        this.dsl = cVar.dsl;
        AppMethodBeat.o(204729);
    }

    /* access modifiers changed from: package-private */
    public final boolean v(MotionEvent motionEvent) {
        AppMethodBeat.i(204730);
        RectF curImageRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
        this.dsA = curImageRect.top - (curImageRect.bottom - ((float) this.dgS.bottom));
        this.dsB = curImageRect.bottom + (((float) this.dgS.top) - curImageRect.top);
        this.dsC = curImageRect.left - (curImageRect.right - ((float) this.dgS.right));
        this.dsD = (((float) this.dgS.left) - curImageRect.left) + curImageRect.right;
        if (this.dsD > ((float) this.dsl.right)) {
            this.dsD = (float) this.dsl.right;
        }
        if (this.dsC < ((float) this.dsd)) {
            this.dsC = (float) this.dsd;
        }
        if (this.dsB > ((float) this.dsl.bottom)) {
            this.dsB = (float) this.dsl.bottom;
        }
        if (this.dsA < ((float) this.dsd)) {
            this.dsA = (float) this.dsd;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                Log.i("FixRatioCropHelper", "ACTION_DOWN moveDirection :" + this.dto);
                this.dsr = false;
                if (this.dgO.dsp != null) {
                    this.dgO.dsp.cancel();
                }
                if (this.dgO.dsi.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.dto |= 8;
                }
                if (this.dgO.dsh.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.dto |= 2;
                }
                if (this.dgO.dsj.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.dto |= 1;
                }
                if (this.dgO.dsk.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.dto |= 4;
                }
                this.dgO.dsx = false;
                if (this.dto > 0) {
                    this.dsr = true;
                    this.dsy = motionEvent.getX();
                    this.dsz = motionEvent.getY();
                    break;
                }
                break;
            case 1:
                final float width = (((float) this.dsl.width()) * 1.0f) / ((float) this.dgS.width());
                float height = (((float) this.dsl.height()) * 1.0f) / ((float) this.dgS.height());
                if (width >= height) {
                    width = height;
                }
                final float centerX = ((float) this.dsl.centerX()) - ((float) this.dgS.centerX());
                final float centerY = ((float) this.dsl.centerY()) - ((float) this.dgS.centerY());
                h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.e.g.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(204728);
                        g.this.dgO.dsp.dgV = 1000;
                        g.this.dgO.dsp.a(width, g.this.dgS, centerX, centerY);
                        g.this.dgO.dsp.play();
                        AppMethodBeat.o(204728);
                    }
                }, this.dsr ? 0 : 100);
                if (this.dto > 0) {
                    this.dsr = true;
                } else {
                    this.dsr = false;
                }
                this.dto = 0;
                this.dgO.Yc();
                break;
            case 2:
                if (this.dsr) {
                    Log.i("FixRatioCropHelper", "ACTION_MOVE moveDirection :" + this.dto + "mBoxRect：" + this.dgS + " originRect:" + this.dtp);
                    this.dtp = new Rect(this.dgS);
                    if (motionEvent.getPointerCount() != 1 || this.dto <= 0) {
                        this.dsr = false;
                    } else {
                        switch (this.dto) {
                            case 1:
                                Log.i("FixRatioCropHelper", "moveDirection: LEFT xDelta:" + (this.dsy - motionEvent.getX()));
                                if (this.dgS.right >= this.dgS.left) {
                                    g((int) (this.dsy - motionEvent.getX()), this.dto, this.dtp);
                                    break;
                                }
                                break;
                            case 2:
                                if (this.dgS.bottom >= this.dgS.top) {
                                    c((int) (this.dsz - motionEvent.getY()), this.dto, this.dtp);
                                    break;
                                }
                                break;
                            case 3:
                                if (this.dgS.right >= this.dgS.left && this.dgS.bottom >= this.dgS.top) {
                                    float y = this.dsz - motionEvent.getY();
                                    float x = this.dsy - motionEvent.getX();
                                    Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + x + " yDelta:" + y);
                                    if (Math.abs(y) < Math.abs(x)) {
                                        c((int) x, this.dto, this.dtp);
                                        break;
                                    } else {
                                        c((int) y, this.dto, this.dtp);
                                        break;
                                    }
                                }
                            case 4:
                                if (this.dgS.right >= this.dgS.left) {
                                    Log.i("FixRatioCropHelper", "moveDirection: RIGHT xDelta:" + (motionEvent.getX() - this.dsy));
                                    i((int) (motionEvent.getX() - this.dsy), this.dto, this.dtp);
                                    break;
                                }
                                break;
                            case 6:
                                if (this.dgS.right >= this.dgS.left && this.dgS.bottom >= this.dgS.top) {
                                    float y2 = this.dsz - motionEvent.getY();
                                    float x2 = motionEvent.getX() - this.dsy;
                                    Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + x2 + " yDelta:" + y2);
                                    if (Math.abs(y2) < Math.abs(x2)) {
                                        i((int) x2, this.dto, this.dtp);
                                        break;
                                    } else {
                                        i((int) y2, this.dto, this.dtp);
                                        break;
                                    }
                                }
                            case 8:
                                if (this.dgS.bottom >= this.dgS.top) {
                                    d((int) (motionEvent.getY() - this.dsz), this.dto, this.dtp);
                                    break;
                                }
                                break;
                            case 9:
                                if (this.dgS.right >= this.dgS.left && this.dgS.bottom >= this.dgS.top) {
                                    float y3 = motionEvent.getY() - this.dsz;
                                    float x3 = this.dsy - motionEvent.getX();
                                    Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + x3 + " yDelta:" + y3);
                                    if (Math.abs(y3) < Math.abs(x3)) {
                                        g((int) x3, this.dto, this.dtp);
                                        break;
                                    } else {
                                        g((int) y3, this.dto, this.dtp);
                                        break;
                                    }
                                }
                            case 12:
                                if (this.dgS.right >= this.dgS.left && this.dgS.bottom >= this.dgS.top) {
                                    float y4 = motionEvent.getY() - this.dsz;
                                    float x4 = motionEvent.getX() - this.dsy;
                                    Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + x4 + " yDelta:" + y4);
                                    if (Math.abs(y4) < Math.abs(x4 / this.dtn)) {
                                        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + (x4 / this.dtn));
                                        d((int) (x4 / this.dtn), this.dto, this.dtp);
                                        break;
                                    } else {
                                        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " yDelta:" + y4);
                                        d((int) y4, this.dto, this.dtp);
                                        break;
                                    }
                                }
                        }
                        this.dgO.Ye();
                        this.dsr = true;
                        this.dgO.Yb();
                        this.dsy = motionEvent.getX();
                        this.dsz = motionEvent.getY();
                    }
                    this.dgO.t(motionEvent);
                    break;
                }
                break;
            case 5:
                this.dto = 0;
                this.dsr = false;
                break;
        }
        boolean z = this.dsr;
        AppMethodBeat.o(204730);
        return z;
    }

    private void c(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204731);
        if (this.dgS.top >= this.dsl.top) {
            if (i2 > this.dgS.top - this.dsl.top) {
                e(this.dsl.top, i3, rect);
            } else {
                e(this.dgS.top - i2, i3, rect);
            }
        }
        if (this.dgS.top > this.dgS.bottom - (this.dsd * 2)) {
            e(this.dgS.bottom - (this.dsd * 2), i3, rect);
        }
        if (this.dgS.top < this.dsl.top) {
            e(this.dsl.top, i3, rect);
        }
        RectF curImageRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
        if (i3 > 2) {
            b(curImageRect, i3);
        } else {
            b(curImageRect, 2);
            b(curImageRect, 1);
            b(curImageRect, 4);
        }
        a(curImageRect, 2);
        AppMethodBeat.o(204731);
    }

    private void d(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204732);
        if (this.dgS.bottom <= this.dsl.bottom) {
            if (i2 > this.dsl.bottom - this.dgS.bottom) {
                f(this.dsl.bottom, i3, rect);
            } else {
                f(this.dgS.bottom + i2, i3, rect);
            }
            if (this.dgS.bottom < this.dgS.top + (this.dsd * 2)) {
                f(this.dgS.top + (this.dsd * 2), i3, rect);
            }
            if (this.dgS.bottom > this.dsl.bottom) {
                f(this.dgS.bottom, i3, rect);
            }
            RectF curImageRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
            if (i3 > 8) {
                b(curImageRect, i3);
            } else {
                b(curImageRect, 8);
                b(curImageRect, 1);
                b(curImageRect, 4);
            }
            a(curImageRect, 8);
        }
        AppMethodBeat.o(204732);
    }

    private void a(RectF rectF, int i2) {
        AppMethodBeat.i(204733);
        Log.i("FixRatioCropHelper", "scaleImage cropDirection:".concat(String.valueOf(i2)));
        switch (i2) {
            case 1:
                if (((float) this.dgS.width()) > rectF.width() && this.dgS.left > this.dsl.left) {
                    float width = ((float) this.dgS.width()) / rectF.width();
                    Log.i("FixRatioCropHelper", "scaleImage LEFT 11 :".concat(String.valueOf(width)));
                    getMainMatrix().postScale(width, width, (float) this.dgS.right, (float) this.dgS.centerY());
                }
                if (((float) this.dgS.height()) > rectF.height()) {
                    float height = ((float) this.dgS.height()) / rectF.height();
                    Log.i("FixRatioCropHelper", "scaleImage LEFT 22 :".concat(String.valueOf(height)));
                    getMainMatrix().postScale(height, height, (float) this.dgS.right, (float) this.dgS.centerY());
                    break;
                }
                break;
            case 2:
                if (((float) this.dgS.height()) > rectF.height() && this.dgS.top > this.dsl.top) {
                    float height2 = ((float) this.dgS.height()) / rectF.height();
                    Log.i("FixRatioCropHelper", "scaleImage TOP 11 :".concat(String.valueOf(height2)));
                    getMainMatrix().postScale(height2, height2, (float) this.dgS.centerX(), (float) this.dgS.bottom);
                }
                if (((float) this.dgS.width()) > rectF.width()) {
                    float width2 = ((float) this.dgS.width()) / rectF.width();
                    Log.i("FixRatioCropHelper", "scaleImage TOP 22 :".concat(String.valueOf(width2)));
                    getMainMatrix().postScale(width2, width2, (float) this.dgS.centerX(), (float) this.dgS.bottom);
                    AppMethodBeat.o(204733);
                    return;
                }
                break;
            case 4:
                if (((float) this.dgS.width()) > rectF.width() && this.dgS.right < this.dsl.right) {
                    float width3 = ((float) this.dgS.width()) / rectF.width();
                    Log.i("FixRatioCropHelper", "scaleImage RIGHT 11 :".concat(String.valueOf(width3)));
                    getMainMatrix().postScale(width3, width3, (float) this.dgS.left, (float) this.dgS.centerY());
                }
                if (((float) this.dgS.height()) > rectF.height()) {
                    float height3 = ((float) this.dgS.height()) / rectF.height();
                    Log.i("FixRatioCropHelper", "scaleImage RIGHT 22 :".concat(String.valueOf(height3)));
                    getMainMatrix().postScale(height3, height3, (float) this.dgS.left, (float) this.dgS.centerY());
                    AppMethodBeat.o(204733);
                    return;
                }
                break;
            case 8:
                if (((float) this.dgS.height()) > rectF.height() && this.dgS.bottom < this.dsl.bottom) {
                    float height4 = ((float) this.dgS.height()) / rectF.height();
                    getMainMatrix().postScale(height4, height4, (float) this.dgS.centerX(), (float) this.dgS.top);
                    Log.i("FixRatioCropHelper", "scaleImage bottom 11 :".concat(String.valueOf(height4)));
                }
                if (((float) this.dgS.width()) > rectF.width()) {
                    float width4 = ((float) this.dgS.width()) / rectF.width();
                    getMainMatrix().postScale(width4, width4, (float) this.dgS.centerX(), (float) this.dgS.top);
                    Log.i("FixRatioCropHelper", "scaleImage bottom 22 :".concat(String.valueOf(width4)));
                    AppMethodBeat.o(204733);
                    return;
                }
                break;
        }
        AppMethodBeat.o(204733);
    }

    private void b(RectF rectF, int i2) {
        AppMethodBeat.i(204734);
        if ((i2 & 1) == 1) {
            a(rectF, (float) (this.dgS.left - this.dtp.left), 1);
        }
        if ((i2 & 4) == 4) {
            a(rectF, (float) (this.dgS.right - this.dtp.right), 4);
        }
        if ((i2 & 2) == 2) {
            a(rectF, (float) (this.dgS.top - this.dtp.top), 2);
        }
        if ((i2 & 8) == 8) {
            a(rectF, (float) (this.dgS.bottom - this.dtp.bottom), 8);
        }
        AppMethodBeat.o(204734);
    }

    private void a(RectF rectF, float f2, int i2) {
        AppMethodBeat.i(204735);
        Log.i("FixRatioCropHelper", "translateImage cropDirection:" + i2 + " eventPosDelta:" + f2);
        switch (i2) {
            case 1:
                Log.i("FixRatioCropHelper", "translateImage LEFT begin");
                if (((int) rectF.left) < ((int) this.dsC) || ((int) rectF.left) < this.dgS.left) {
                    Log.i("FixRatioCropHelper", "translateImage LEFT else");
                    break;
                } else if (f2 > rectF.left - this.dsC) {
                    Log.i("FixRatioCropHelper", "translateImage left mEdgeLeft - imageRect.left:" + (this.dsC - rectF.left));
                    getMainMatrix().postTranslate(this.dsC - rectF.left, 0.0f);
                    AppMethodBeat.o(204735);
                    return;
                } else {
                    Log.i("FixRatioCropHelper", "translateImage left eventPosDelta:".concat(String.valueOf(f2)));
                    getMainMatrix().postTranslate(f2, 0.0f);
                    AppMethodBeat.o(204735);
                    return;
                }
            case 2:
                if (((int) rectF.top) >= ((int) this.dsA) && ((int) rectF.top) >= this.dgS.top) {
                    if (f2 > rectF.top - this.dsA) {
                        Log.i("FixRatioCropHelper", "translateImage imageRect.top - mEdgeTop - imageRect.left:" + (rectF.top - this.dsA));
                        getMainMatrix().postTranslate(0.0f, this.dsA - rectF.top);
                        AppMethodBeat.o(204735);
                        return;
                    }
                    Log.i("FixRatioCropHelper", "translateImage top eventPosDelta:".concat(String.valueOf(f2)));
                    getMainMatrix().postTranslate(0.0f, f2);
                    AppMethodBeat.o(204735);
                    return;
                }
            case 4:
                if (((int) rectF.right) <= ((int) this.dsD) && ((int) rectF.right) <= this.dgS.right) {
                    if (f2 > this.dsD - rectF.right) {
                        getMainMatrix().postTranslate(this.dsD - rectF.right, 0.0f);
                        AppMethodBeat.o(204735);
                        return;
                    }
                    getMainMatrix().postTranslate(f2, 0.0f);
                    AppMethodBeat.o(204735);
                    return;
                }
            case 8:
                if (((int) rectF.bottom) > ((int) this.dsB) || ((int) rectF.bottom) > this.dgS.bottom) {
                    Log.i("FixRatioCropHelper", "translateImage bottom else :".concat(String.valueOf(f2)));
                    AppMethodBeat.o(204735);
                    return;
                } else if (f2 > this.dsB - rectF.bottom) {
                    Log.i("FixRatioCropHelper", "translateImage bottom 11:" + (this.dsB - rectF.bottom));
                    getMainMatrix().postTranslate(0.0f, this.dsB - rectF.bottom);
                    AppMethodBeat.o(204735);
                    return;
                } else {
                    Log.i("FixRatioCropHelper", "translateImage bottom 22:".concat(String.valueOf(f2)));
                    getMainMatrix().postTranslate(0.0f, f2);
                    AppMethodBeat.o(204735);
                    return;
                }
        }
        AppMethodBeat.o(204735);
    }

    private void e(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204736);
        while (true) {
            int i4 = (int) (((float) (rect.bottom - i2)) * this.dtn);
            switch (i3) {
                case 2:
                    int centerX = rect.centerX();
                    this.dtu = centerX - (i4 / 2);
                    this.dtt = (i4 / 2) + centerX;
                    if (centerX >= this.dsl.centerX()) {
                        if (this.dtt <= this.dsl.right) {
                            break;
                        } else {
                            i3 = 3;
                        }
                    } else if (this.dtu >= this.dsl.left) {
                        break;
                    } else {
                        i3 = 6;
                    }
                case 3:
                    this.dtu = rect.right - i4;
                    if (this.dtu < this.dsl.left) {
                        int i5 = rect.right - this.dsl.left;
                        this.dgS.left = this.dsl.left;
                        this.dgS.top = (int) (((float) rect.bottom) - (((float) i5) / this.dtn));
                        AppMethodBeat.o(204736);
                        return;
                    }
                    this.dgS.left = this.dtu;
                    this.dgS.top = i2;
                    AppMethodBeat.o(204736);
                    return;
                case 6:
                    this.dtt = i4 + rect.left;
                    if (this.dgS.right > this.dsl.right) {
                        int i6 = this.dsl.right - rect.left;
                        this.dgS.right = this.dsl.right;
                        this.dgS.top = (int) (((float) rect.bottom) - (((float) i6) / this.dtn));
                        AppMethodBeat.o(204736);
                        return;
                    }
                    break;
            }
        }
        this.dgS.left = this.dtu;
        this.dgS.right = this.dtt;
        this.dgS.top = i2;
        AppMethodBeat.o(204736);
    }

    private void f(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204737);
        while (true) {
            int i4 = (int) (((float) (i2 - rect.top)) * this.dtn);
            switch (i3) {
                case 8:
                    int centerX = rect.centerX();
                    this.dtu = centerX - (i4 / 2);
                    this.dtt = (i4 / 2) + centerX;
                    if (centerX >= this.dsl.centerX()) {
                        if (this.dtt <= this.dsl.right) {
                            break;
                        } else {
                            Log.i("FixRatioCropHelper", "change direct to RIGHT_TOP");
                            i3 = 9;
                        }
                    } else if (this.dtu >= this.dsl.left) {
                        break;
                    } else {
                        Log.i("FixRatioCropHelper", "change direct to right_bottom");
                        i3 = 12;
                    }
                case 9:
                    this.dtu = rect.right - i4;
                    Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM :" + this.dgS);
                    if (this.dtu < this.dsl.left) {
                        int i5 = rect.right - this.dsl.left;
                        this.dgS.left = this.dsl.left;
                        this.dgS.bottom = (int) ((((float) i5) / this.dtn) + ((float) rect.top));
                        AppMethodBeat.o(204737);
                        return;
                    }
                    this.dgS.left = this.dtu;
                    this.dgS.bottom = i2;
                    AppMethodBeat.o(204737);
                    return;
                case 12:
                    this.dtt = i4 + rect.left;
                    Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM" + this.dgS);
                    if (this.dtt > this.dsl.right) {
                        int i6 = this.dsl.right - rect.left;
                        this.dgS.right = this.dsl.right;
                        this.dgS.bottom = (int) ((((float) i6) / this.dtn) + ((float) this.dgS.top));
                        AppMethodBeat.o(204737);
                        return;
                    }
                    break;
            }
        }
        this.dgS.left = this.dtu;
        this.dgS.right = this.dtt;
        this.dgS.bottom = i2;
        AppMethodBeat.o(204737);
    }

    private void g(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204738);
        if (this.dgS.left >= this.dsl.left) {
            if (i2 > this.dgS.left - this.dsl.left) {
                h(this.dsl.left, i3, rect);
            } else {
                h(this.dgS.left - i2, i3, rect);
            }
        }
        if (this.dgS.left > this.dgS.right - (this.dsd * 2)) {
            h(this.dgS.right - (this.dsd * 2), i3, rect);
        }
        if (this.dgS.left < this.dsl.left) {
            h(this.dsl.left, i3, rect);
        }
        RectF curImageRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
        if (i3 > 1) {
            b(curImageRect, i3);
        } else {
            b(curImageRect, 1);
            b(curImageRect, 8);
            b(curImageRect, 2);
        }
        a(curImageRect, 1);
        AppMethodBeat.o(204738);
    }

    private void h(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204739);
        while (true) {
            int i4 = (int) (((float) (rect.right - i2)) / this.dtn);
            switch (i3) {
                case 1:
                    float centerY = (float) rect.centerY();
                    this.dtq = (int) (centerY - ((float) (i4 / 2)));
                    this.dtr = (int) (((float) (i4 / 2)) + centerY);
                    Log.i("FixRatioCropHelper", "adjustLeft :" + this.dgS + " LEFT");
                    if (centerY < ((float) this.dsl.centerY())) {
                        if (this.dtq >= this.dsl.top) {
                            break;
                        } else {
                            i3 = 9;
                        }
                    } else if (this.dtr <= this.dsl.bottom) {
                        break;
                    } else {
                        i3 = 3;
                    }
                case 3:
                    this.dtq = rect.bottom - i4;
                    if (this.dtq <= this.dsl.top) {
                        int i5 = rect.bottom - this.dsl.top;
                        this.dgS.top = this.dsl.top;
                        this.dgS.left = (int) (((float) rect.right) - (((float) i5) * this.dtn));
                    } else {
                        this.dgS.top = this.dtq;
                        this.dgS.left = i2;
                    }
                    Log.i("FixRatioCropHelper", "adjustLeft :" + this.dgS + " LEFT_TOP");
                    AppMethodBeat.o(204739);
                    return;
                case 9:
                    this.dtr = i4 + rect.top;
                    Log.i("FixRatioCropHelper", "adjustLeft :" + this.dgS + " LEFT_BOTTOM");
                    if (this.dtr >= this.dsl.bottom) {
                        int i6 = this.dsl.bottom - rect.top;
                        this.dgS.bottom = this.dsl.bottom;
                        this.dgS.left = (int) (((float) rect.right) - (((float) i6) * this.dtn));
                        AppMethodBeat.o(204739);
                        return;
                    }
                    break;
            }
        }
        this.dgS.top = this.dtq;
        this.dgS.bottom = this.dtr;
        this.dgS.left = i2;
        AppMethodBeat.o(204739);
    }

    private void i(int i2, int i3, Rect rect) {
        AppMethodBeat.i(204740);
        if (this.dgS.right <= this.dsl.right) {
            if (i2 > this.dsl.right - this.dgS.right) {
                Log.i("FixRatioCropHelper", "changeRight outof bound:");
                j(this.dsl.right, i3, rect);
            } else {
                Log.i("FixRatioCropHelper", "changeRight normal eventPosDelta: ".concat(String.valueOf(i2)));
                j(this.dgS.right + i2, i3, rect);
            }
        }
        if (this.dgS.right < this.dgS.left + (this.dsd * 2)) {
            Log.i("FixRatioCropHelper", "changeRight < 2 padding>: " + this.dgS.right);
            j(this.dgS.left + (this.dsd * 2), i3, rect);
        }
        if (this.dgS.right > this.dsl.right) {
            Log.i("FixRatioCropHelper", "changeRight after out of bound>: " + this.dgS.right);
            j(this.dsl.right, i3, rect);
        }
        RectF curImageRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
        if (i3 > 4) {
            b(curImageRect, i3);
        } else {
            b(curImageRect, 4);
            b(curImageRect, 8);
            b(curImageRect, 2);
        }
        a(curImageRect, 4);
        AppMethodBeat.o(204740);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(204741);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j(int r6, int r7, android.graphics.Rect r8) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.e.g.j(int, int, android.graphics.Rect):void");
    }

    private Matrix getMainMatrix() {
        AppMethodBeat.i(204742);
        Matrix mainMatrix = this.dgO.drS.gth().getBaseBoardView().getMainMatrix();
        AppMethodBeat.o(204742);
        return mainMatrix;
    }
}
