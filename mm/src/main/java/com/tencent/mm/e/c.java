package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bt.b;
import com.tencent.mm.cache.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.b.a;

public final class c extends b<a> {
    public Rect dgS;
    float dsA;
    float dsB;
    float dsC;
    float dsD;
    public ValueAnimator dsE;
    public Rect dsF = new Rect();
    public int dsG = 0;
    public boolean dsH = false;
    private int dsd = ((int) MMApplicationContext.getResources().getDimension(R.dimen.u8));
    private int dse = ((int) MMApplicationContext.getResources().getDimension(R.dimen.a4a));
    private int dsf = ((int) MMApplicationContext.getResources().getDimension(R.dimen.yk));
    private Matrix dsg = new Matrix();
    RectF dsh;
    RectF dsi;
    RectF dsj;
    RectF dsk;
    public final Rect dsl = new Rect();
    private com.tencent.mm.z.a dsm;
    boolean dsn = false;
    private boolean dso = false;
    public com.tencent.mm.c.a dsp;
    g dsq;
    boolean dsr = false;
    boolean dss = false;
    boolean dsu = false;
    boolean dsv = false;
    boolean dsw = false;
    public boolean dsx = true;
    float dsy;
    float dsz;

    public c() {
        AppMethodBeat.i(9136);
        AppMethodBeat.o(9136);
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(204726);
        cVar.Yg();
        AppMethodBeat.o(204726);
    }

    static /* synthetic */ int e(c cVar) {
        int i2 = cVar.dsG;
        cVar.dsG = i2 - 1;
        return i2;
    }

    @Override // com.tencent.mm.e.b
    public final a XS() {
        return a.CROP_PHOTO;
    }

    @Override // com.tencent.mm.e.b
    public final void a(b bVar, Matrix matrix, Rect rect) {
        AppMethodBeat.i(9137);
        super.a(bVar, matrix, rect);
        this.dgS = new Rect();
        this.dsi = new RectF();
        this.dsh = new RectF();
        this.dsj = new RectF();
        this.dsk = new RectF();
        this.dsm = new com.tencent.mm.z.a(this.dgS);
        this.dsp = new com.tencent.mm.c.a(this);
        AppMethodBeat.o(9137);
    }

    @Override // com.tencent.mm.e.b
    public final void onAlive() {
        AppMethodBeat.i(9138);
        super.onAlive();
        if (this.dsl.isEmpty()) {
            this.dsl.set(this.dsd, this.dsd * 2, getBoardRect().width() - this.dsd, ((getBoardRect().height() - this.dse) - this.dsf) - (this.dsd * 2));
        }
        Log.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", this.dsl);
        if (XU() == null) {
            Log.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
            AppMethodBeat.o(9138);
            return;
        }
        com.tencent.mm.z.a alE = ((a) XU()).alE();
        if (alE != null && !alE.hof.isEmpty()) {
            this.drS.gth().getBaseBoardView().v(alE.hof);
            float b2 = b(alE.mMatrix);
            Log.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", Float.valueOf(b2));
            getMainMatrix().postRotate(-b2, (float) alE.hof.centerX(), (float) alE.hof.centerY());
        }
        if (this.drS != null && this.drS.gtk() > 0.0f && this.dsq == null) {
            this.dsq = new g(this, this.drS.gtk(), this.dgS);
        }
        AppMethodBeat.o(9138);
    }

    @Override // com.tencent.mm.e.b
    public final void onDestroy() {
        AppMethodBeat.i(204724);
        super.onDestroy();
        this.dsq = null;
        AppMethodBeat.o(204724);
    }

    @Override // com.tencent.mm.e.b
    public final void XV() {
        AppMethodBeat.i(9139);
        super.XV();
        this.drS.gth().getActionBar().setVisibility(8);
        this.dsF.setEmpty();
        if (XU() == null) {
            Log.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
            AppMethodBeat.o(9139);
            return;
        }
        if (((a) XU()).ai(true) <= 0) {
            com.tencent.mm.z.a aVar = new com.tencent.mm.z.a();
            aVar.mMatrix.set(getMainMatrix());
            ((a) XU()).a(aVar);
            Yf();
            this.drS.gth().getBaseBoardView().u(this.dgS);
            this.drS.gth().getBaseBoardView().a(new a.b() {
                /* class com.tencent.mm.e.c.AnonymousClass1 */

                @Override // com.tencent.mm.view.b.a.b
                public final void Yh() {
                    AppMethodBeat.i(9119);
                    if (c.this.XU() == null) {
                        AppMethodBeat.o(9119);
                        return;
                    }
                    if (((com.tencent.mm.cache.a) c.this.XU()).gpz.isIdentity()) {
                        ((com.tencent.mm.cache.a) c.this.XU()).gpz.set(c.this.getMainMatrix());
                    }
                    Rect rect = new Rect();
                    if (c.this.drS.gtm() == null) {
                        rect.set(0, 0, c.this.drS.gth().getBaseBoardView().getBoardRect().width(), c.this.drS.gth().getBaseBoardView().getBoardRect().height());
                    } else {
                        rect.set(0, 0, c.this.drS.gtm().getWidth(), c.this.drS.gtm().getHeight());
                    }
                    c.this.drS.gth().getBaseBoardView().v(rect);
                    c.a(c.this, 200, true, false);
                    c.a(c.this);
                    c.this.Yc();
                    AppMethodBeat.o(9119);
                }

                @Override // com.tencent.mm.view.b.a.b
                public final void onStart() {
                    AppMethodBeat.i(9120);
                    c.this.dsn = false;
                    c.this.dsx = false;
                    AppMethodBeat.o(9120);
                }
            }, 0.0f, false);
        } else {
            com.tencent.mm.z.a alE = ((com.tencent.mm.cache.a) XU()).alE();
            if (alE == null) {
                Log.e("MicroMsg.CropArtist", "item is null!!!");
                AppMethodBeat.o(9139);
                return;
            }
            this.dgS.set(new Rect(alE.dgS));
            this.drS.gth().getBaseBoardView().u(alE.dgS);
            try {
                ((com.tencent.mm.cache.a) XU()).a((com.tencent.mm.z.a) alE.clone());
            } catch (CloneNotSupportedException e2) {
                Log.printErrStackTrace("MicroMsg.CropArtist", e2, "", new Object[0]);
            }
            this.drS.gth().getBaseBoardView().a(new a.b() {
                /* class com.tencent.mm.e.c.AnonymousClass3 */

                @Override // com.tencent.mm.view.b.a.b
                public final void Yh() {
                    Rect rect;
                    AppMethodBeat.i(9121);
                    c.this.dsx = true;
                    if (c.this.drS.gtm() == null) {
                        rect = new Rect();
                        Log.e("MicroMsg.CropArtist", "getImageBitmap is null!");
                    } else {
                        rect = new Rect(0, 0, c.this.drS.gtm().getWidth(), c.this.drS.gtm().getHeight());
                    }
                    c.this.drS.gth().getBaseBoardView().v(rect);
                    c.a(c.this, 200, true, false);
                    c.a(c.this);
                    AppMethodBeat.o(9121);
                }

                @Override // com.tencent.mm.view.b.a.b
                public final void onStart() {
                    AppMethodBeat.i(9122);
                    c.this.dsn = false;
                    c.this.dsx = false;
                    com.tencent.mm.z.a unused = c.this.dsm;
                    com.tencent.mm.z.a.pO(282);
                    AppMethodBeat.o(9122);
                }
            }, 0.0f, false);
        }
        setOneFingerMoveEnable(true);
        AppMethodBeat.o(9139);
    }

    @Override // com.tencent.mm.e.b
    public final boolean XX() {
        AppMethodBeat.i(9140);
        if (XU() == null) {
            AppMethodBeat.o(9140);
            return false;
        } else if (!((com.tencent.mm.cache.a) XU()).gpz.equals(getMainMatrix())) {
            AppMethodBeat.o(9140);
            return true;
        } else {
            AppMethodBeat.o(9140);
            return false;
        }
    }

    @Override // com.tencent.mm.e.b
    public final void XT() {
    }

    @Override // com.tencent.mm.e.b
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(9141);
        if (!this.dso) {
            canvas.setMatrix(null);
        } else {
            canvas.setMatrix(this.dsg);
        }
        com.tencent.mm.z.a aVar = this.dsm;
        boolean z = this.dsx;
        boolean z2 = this.dsn;
        if (aVar.dgS == null) {
            Log.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            AppMethodBeat.o(9141);
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(aVar.dgS, Region.Op.DIFFERENCE);
            canvas.drawPaint(com.tencent.mm.z.a.hob);
            canvas.restore();
        }
        if (z2) {
            if (!com.tencent.mm.z.a.Ui.equals(aVar.dgS)) {
                com.tencent.mm.z.a.hnY.reset();
                com.tencent.mm.z.a.hnY.moveTo((float) aVar.dgS.left, (float) aVar.dgS.top);
                com.tencent.mm.z.a.hnY.lineTo((float) aVar.dgS.right, (float) aVar.dgS.top);
                com.tencent.mm.z.a.hnY.lineTo((float) aVar.dgS.right, (float) aVar.dgS.bottom);
                com.tencent.mm.z.a.hnY.lineTo((float) aVar.dgS.left, (float) aVar.dgS.bottom);
                com.tencent.mm.z.a.hnY.close();
                com.tencent.mm.z.a.hnX.reset();
                for (int i2 = 1; i2 < 3; i2++) {
                    com.tencent.mm.z.a.hnX.moveTo((float) (aVar.dgS.left + ((aVar.dgS.width() / 3) * i2)), (float) aVar.dgS.top);
                    com.tencent.mm.z.a.hnX.lineTo((float) (aVar.dgS.left + ((aVar.dgS.width() / 3) * i2)), (float) aVar.dgS.bottom);
                    com.tencent.mm.z.a.hnX.moveTo((float) aVar.dgS.left, (float) (aVar.dgS.top + ((aVar.dgS.height() / 3) * i2)));
                    com.tencent.mm.z.a.hnX.lineTo((float) aVar.dgS.right, (float) (aVar.dgS.top + ((aVar.dgS.height() / 3) * i2)));
                }
            }
            canvas.drawRect((float) aVar.dgS.left, (float) aVar.dgS.top, (float) aVar.dgS.right, (float) aVar.dgS.bottom, com.tencent.mm.z.a.hoa);
            canvas.drawPath(com.tencent.mm.z.a.hnX, com.tencent.mm.z.a.hoc);
            canvas.drawPath(com.tencent.mm.z.a.hnY, com.tencent.mm.z.a.hnZ);
            canvas.drawLine(((float) aVar.dgS.left) - com.tencent.mm.z.a.hnV, ((float) aVar.dgS.top) - (com.tencent.mm.z.a.hnV / 2.0f), com.tencent.mm.z.a.hnW + ((float) aVar.dgS.left), ((float) aVar.dgS.top) - (com.tencent.mm.z.a.hnV / 2.0f), com.tencent.mm.z.a.hod);
            canvas.drawLine((com.tencent.mm.z.a.hnV / 2.0f) + (((float) aVar.dgS.right) - com.tencent.mm.z.a.hnW), ((float) aVar.dgS.top) - (com.tencent.mm.z.a.hnV / 2.0f), com.tencent.mm.z.a.hnV + ((float) aVar.dgS.right), ((float) aVar.dgS.top) - (com.tencent.mm.z.a.hnV / 2.0f), com.tencent.mm.z.a.hod);
            canvas.drawLine(((float) aVar.dgS.left) - (com.tencent.mm.z.a.hnV / 2.0f), ((float) aVar.dgS.top) - (com.tencent.mm.z.a.hnV / 2.0f), ((float) aVar.dgS.left) - (com.tencent.mm.z.a.hnV / 2.0f), com.tencent.mm.z.a.hnW + ((float) aVar.dgS.top), com.tencent.mm.z.a.hod);
            canvas.drawLine(((float) aVar.dgS.left) - (com.tencent.mm.z.a.hnV / 2.0f), (com.tencent.mm.z.a.hnV / 2.0f) + (((float) aVar.dgS.bottom) - com.tencent.mm.z.a.hnW), ((float) aVar.dgS.left) - (com.tencent.mm.z.a.hnV / 2.0f), (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.bottom), com.tencent.mm.z.a.hod);
            canvas.drawLine((com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.right), (float) aVar.dgS.top, (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.right), com.tencent.mm.z.a.hnW + ((float) aVar.dgS.top), com.tencent.mm.z.a.hod);
            canvas.drawLine((com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.right), (com.tencent.mm.z.a.hnV / 2.0f) + (((float) aVar.dgS.bottom) - com.tencent.mm.z.a.hnW), (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.right), (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.bottom), com.tencent.mm.z.a.hod);
            canvas.drawLine(((float) aVar.dgS.left) - com.tencent.mm.z.a.hnV, (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.bottom), com.tencent.mm.z.a.hnW + ((float) aVar.dgS.left), (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.bottom), com.tencent.mm.z.a.hod);
            canvas.drawLine(((float) aVar.dgS.right) - com.tencent.mm.z.a.hnW, (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.bottom), com.tencent.mm.z.a.hnV + ((float) aVar.dgS.right), (com.tencent.mm.z.a.hnV / 2.0f) + ((float) aVar.dgS.bottom), com.tencent.mm.z.a.hod);
            if (!com.tencent.mm.z.a.Ui.equals(aVar.dgS)) {
                com.tencent.mm.z.a.Ui.set(aVar.dgS);
            }
        }
        AppMethodBeat.o(9141);
    }

    @Override // com.tencent.mm.e.b
    public final boolean q(MotionEvent motionEvent) {
        AppMethodBeat.i(9142);
        if (!XZ()) {
            AppMethodBeat.o(9142);
            return false;
        } else if (this.dsq != null) {
            boolean v = this.dsq.v(motionEvent);
            AppMethodBeat.o(9142);
            return v;
        } else {
            RectF curImageRect = this.drS.gth().getBaseBoardView().getCurImageRect();
            this.dsA = curImageRect.top - (curImageRect.bottom - ((float) this.dgS.bottom));
            this.dsB = curImageRect.bottom + (((float) this.dgS.top) - curImageRect.top);
            this.dsC = curImageRect.left - (curImageRect.right - ((float) this.dgS.right));
            this.dsD = curImageRect.right + (((float) this.dgS.left) - curImageRect.left);
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
                    this.dsr = false;
                    if (this.dsp != null) {
                        this.dsp.cancel();
                    }
                    if (this.dsi.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.dsv = true;
                    }
                    if (this.dsh.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.dsu = true;
                    }
                    if (this.dsj.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.dss = true;
                    }
                    if (this.dsk.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.dsw = true;
                    }
                    this.dsx = false;
                    if (Yd()) {
                        this.dsr = true;
                        if (this.dsv && this.dss) {
                            this.dsv = true;
                            this.dss = true;
                            this.dsu = false;
                            this.dsw = false;
                        } else if (this.dsv && this.dsw) {
                            this.dsv = true;
                            this.dss = false;
                            this.dsu = false;
                            this.dsw = true;
                        } else if (this.dsu && this.dsw) {
                            this.dsv = false;
                            this.dss = false;
                            this.dsu = true;
                            this.dsw = true;
                        } else if (this.dsu && this.dsw) {
                            this.dsv = false;
                            this.dss = false;
                            this.dsu = true;
                            this.dsw = true;
                        }
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
                        /* class com.tencent.mm.e.c.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(204718);
                            c.this.dsp.dgV = 1000;
                            c.this.dsp.a(width, c.this.dgS, centerX, centerY);
                            c.this.dsp.play();
                            AppMethodBeat.o(204718);
                        }
                    }, this.dsr ? 0 : 100);
                    if (Yd()) {
                        this.dsr = true;
                    } else {
                        this.dsr = false;
                    }
                    this.dsv = false;
                    this.dss = false;
                    this.dsu = false;
                    this.dsw = false;
                    Yc();
                    break;
                case 2:
                    if (this.dsr) {
                        if (motionEvent.getPointerCount() != 1 || !Yd()) {
                            this.dsr = false;
                        } else {
                            if (this.dsw && this.dgS.right >= this.dgS.left) {
                                if (this.dgS.right <= this.dsl.right) {
                                    if (motionEvent.getX() - this.dsy > ((float) (this.dsl.right - this.dgS.right))) {
                                        this.dgS.right = this.dsl.right;
                                    } else {
                                        Rect rect = this.dgS;
                                        rect.right = (int) (((float) rect.right) + (motionEvent.getX() - this.dsy));
                                    }
                                }
                                if (this.dgS.right < this.dgS.left + (this.dsd * 2)) {
                                    this.dgS.right = this.dgS.left + (this.dsd * 2);
                                }
                                if (this.dgS.right > this.dsl.right) {
                                    this.dgS.right = this.dsl.right;
                                }
                                if (((int) curImageRect.right) <= ((int) this.dsD) && ((int) curImageRect.right) <= this.dgS.right) {
                                    if (motionEvent.getX() - this.dsy > this.dsD - curImageRect.right) {
                                        getMainMatrix().postTranslate(this.dsD - curImageRect.right, 0.0f);
                                    } else {
                                        getMainMatrix().postTranslate(motionEvent.getX() - this.dsy, 0.0f);
                                    }
                                }
                                if (((float) this.dgS.width()) > curImageRect.width() && this.dgS.right < this.dsl.right) {
                                    float width2 = ((float) this.dgS.width()) / curImageRect.width();
                                    getMainMatrix().postScale(width2, width2, (float) this.dgS.left, (float) this.dgS.centerY());
                                }
                            }
                            if (this.dss && this.dgS.right >= this.dgS.left) {
                                if (this.dgS.left >= this.dsl.left) {
                                    if (this.dsy - motionEvent.getX() > ((float) (this.dgS.left - this.dsl.left))) {
                                        this.dgS.left = this.dsl.left;
                                    } else {
                                        Rect rect2 = this.dgS;
                                        rect2.left = (int) (((float) rect2.left) - (this.dsy - motionEvent.getX()));
                                    }
                                }
                                if (this.dgS.left > this.dgS.right - (this.dsd * 2)) {
                                    this.dgS.left = this.dgS.right - (this.dsd * 2);
                                }
                                if (this.dgS.left < this.dsl.left) {
                                    this.dgS.left = this.dsl.left;
                                }
                                if (((int) curImageRect.left) >= ((int) this.dsC) && ((int) curImageRect.left) >= this.dgS.left) {
                                    if (this.dsy - motionEvent.getX() > curImageRect.left - this.dsC) {
                                        getMainMatrix().postTranslate(this.dsC - curImageRect.left, 0.0f);
                                    } else {
                                        getMainMatrix().postTranslate(motionEvent.getX() - this.dsy, 0.0f);
                                    }
                                }
                                if (((float) this.dgS.width()) > curImageRect.width() && this.dgS.left > this.dsl.left) {
                                    float width3 = ((float) this.dgS.width()) / curImageRect.width();
                                    getMainMatrix().postScale(width3, width3, (float) this.dgS.right, (float) this.dgS.centerY());
                                }
                            }
                            if (this.dsu && this.dgS.bottom >= this.dgS.top) {
                                if (this.dgS.top >= this.dsl.top) {
                                    if (this.dsz - motionEvent.getY() > ((float) (this.dgS.top - this.dsl.top))) {
                                        this.dgS.top = this.dsl.top;
                                    } else {
                                        Rect rect3 = this.dgS;
                                        rect3.top = (int) (((float) rect3.top) - (this.dsz - motionEvent.getY()));
                                    }
                                }
                                if (this.dgS.top > this.dgS.bottom - (this.dsd * 2)) {
                                    this.dgS.top = this.dgS.bottom - (this.dsd * 2);
                                }
                                if (this.dgS.top < this.dsl.top) {
                                    this.dgS.top = this.dsl.top;
                                }
                                if (((int) curImageRect.top) >= ((int) this.dsA) && ((int) curImageRect.top) >= this.dgS.top) {
                                    if (this.dsz - motionEvent.getY() > curImageRect.top - this.dsA) {
                                        getMainMatrix().postTranslate(0.0f, this.dsA - curImageRect.top);
                                    } else {
                                        getMainMatrix().postTranslate(0.0f, motionEvent.getY() - this.dsz);
                                    }
                                }
                                if (((float) this.dgS.height()) > curImageRect.height() && this.dgS.top > this.dsl.top) {
                                    float height2 = ((float) this.dgS.height()) / curImageRect.height();
                                    getMainMatrix().postScale(height2, height2, (float) this.dgS.centerX(), (float) this.dgS.bottom);
                                }
                            }
                            if (this.dsv && this.dgS.bottom >= this.dgS.top) {
                                if (this.dgS.bottom <= this.dsl.bottom) {
                                    if (motionEvent.getY() - this.dsz > ((float) (this.dsl.bottom - this.dgS.bottom))) {
                                        this.dgS.bottom = this.dsl.bottom;
                                    } else {
                                        Rect rect4 = this.dgS;
                                        rect4.bottom = (int) (((float) rect4.bottom) + (motionEvent.getY() - this.dsz));
                                    }
                                }
                                if (this.dgS.bottom < this.dgS.top + (this.dsd * 2)) {
                                    this.dgS.bottom = this.dgS.top + (this.dsd * 2);
                                }
                                if (this.dgS.bottom > this.dsl.bottom) {
                                    this.dgS.bottom = this.dsl.bottom;
                                }
                                if (((int) curImageRect.bottom) <= ((int) this.dsB) && ((int) curImageRect.bottom) <= this.dgS.bottom) {
                                    if (motionEvent.getY() - this.dsz > this.dsB - curImageRect.bottom) {
                                        getMainMatrix().postTranslate(0.0f, this.dsB - curImageRect.bottom);
                                    } else {
                                        getMainMatrix().postTranslate(0.0f, motionEvent.getY() - this.dsz);
                                    }
                                }
                                if (((float) this.dgS.height()) > curImageRect.height() && this.dgS.bottom < this.dsl.bottom) {
                                    float height3 = ((float) this.dgS.height()) / curImageRect.height();
                                    getMainMatrix().postScale(height3, height3, (float) this.dgS.centerX(), (float) this.dgS.top);
                                }
                            }
                            Ye();
                            this.dsr = true;
                            Yb();
                            this.dsy = motionEvent.getX();
                            this.dsz = motionEvent.getY();
                        }
                        t(motionEvent);
                        break;
                    }
                    break;
                case 5:
                    this.dsv = false;
                    this.dss = false;
                    this.dsu = false;
                    this.dsw = false;
                    this.dsr = false;
                    break;
            }
            boolean z = this.dsr;
            AppMethodBeat.o(9142);
            return z;
        }
    }

    private boolean Yd() {
        return this.dsv || this.dss || this.dsu || this.dsw;
    }

    public final void Ye() {
        AppMethodBeat.i(9143);
        this.dsi.set((float) (this.dgS.left - this.dsd), (float) (this.dgS.bottom - this.dsd), (float) (this.dgS.right + this.dsd), (float) (this.dgS.bottom + this.dsd));
        this.dsh.set((float) (this.dgS.left - this.dsd), (float) (this.dgS.top - this.dsd), (float) (this.dgS.right + this.dsd), (float) (this.dgS.top + this.dsd));
        this.dsj.set((float) (this.dgS.left - this.dsd), (float) (this.dgS.top - this.dsd), (float) (this.dgS.left + this.dsd), (float) (this.dgS.bottom + this.dsd));
        this.dsk.set((float) (this.dgS.right - this.dsd), (float) (this.dgS.top - this.dsd), (float) (this.dgS.right + this.dsd), (float) (this.dgS.bottom + this.dsd));
        AppMethodBeat.o(9143);
    }

    public final void Yf() {
        AppMethodBeat.i(9144);
        if (this.drS.gtm() == null) {
            Log.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
            AppMethodBeat.o(9144);
            return;
        }
        float width = (((float) this.drS.gtm().getWidth()) * 1.0f) / ((float) this.drS.gtm().getHeight());
        if (width < (((float) this.dsl.width()) * 1.0f) / ((float) this.dsl.height())) {
            int width2 = (int) ((((float) this.dsl.width()) - (width * ((float) this.dsl.height()))) / 2.0f);
            this.dgS.set(this.dsl.left + width2, this.dsl.top, this.dsl.right - width2, this.dsl.bottom);
        } else {
            int height = (int) ((((float) this.dsl.height()) - (((float) this.dsl.width()) / width)) / 2.0f);
            this.dgS.set(this.dsl.left, this.dsl.top + height, this.dsl.right, this.dsl.bottom - height);
        }
        Ye();
        AppMethodBeat.o(9144);
    }

    public final void Yg() {
        AppMethodBeat.i(9145);
        this.drS.gth().getBaseBoardView().u(this.drS.gth().getBaseBoardView().getRawBoardRect());
        RectF rectF = new RectF(this.dgS);
        Matrix matrix = new Matrix();
        getMainMatrix().invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.drS.gth().getBaseBoardView().v(rect);
        final com.tencent.mm.z.a aVar = new com.tencent.mm.z.a();
        aVar.dgS = new Rect(this.dgS);
        aVar.hof.set(rect);
        if (this.dsq != null) {
            this.drS.gth().getBaseBoardView().hgc();
            aVar.setMatrix(getMainMatrix());
            if (XU() != null) {
                ((com.tencent.mm.cache.a) XU()).clear();
                ((com.tencent.mm.cache.a) XU()).a(aVar);
            }
        } else {
            this.drS.gth().getBaseBoardView().a(new a.b() {
                /* class com.tencent.mm.e.c.AnonymousClass8 */

                @Override // com.tencent.mm.view.b.a.b
                public final void Yh() {
                    AppMethodBeat.i(9130);
                    aVar.setMatrix(c.this.getMainMatrix());
                    if (c.this.XU() != null) {
                        ((com.tencent.mm.cache.a) c.this.XU()).clear();
                        ((com.tencent.mm.cache.a) c.this.XU()).a(aVar);
                    }
                    AppMethodBeat.o(9130);
                }

                @Override // com.tencent.mm.view.b.a.b
                public final void onStart() {
                    AppMethodBeat.i(9131);
                    AppMethodBeat.o(9131);
                }
            }, 0.0f, true);
        }
        this.drS.gth().getActionBar().setVisibility(0);
        AppMethodBeat.o(9145);
    }

    static /* synthetic */ void a(c cVar, long j2, boolean z, boolean z2) {
        PropertyValuesHolder ofInt;
        AppMethodBeat.i(9146);
        if (cVar.dsE != null) {
            cVar.dsE.cancel();
        }
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("alpha", 0, 255);
        if (z) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", 282, 255);
        } else if (z2) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", 255, 255);
        } else {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", 0, 255);
        }
        cVar.dsE = ValueAnimator.ofPropertyValuesHolder(ofInt2, ofInt);
        cVar.dsE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.e.c.AnonymousClass5 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(204719);
                int intValue = ((Integer) valueAnimator.getAnimatedValue("bg_alpha")).intValue();
                int intValue2 = ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue();
                com.tencent.mm.z.a unused = c.this.dsm;
                com.tencent.mm.z.a.pN(intValue2);
                com.tencent.mm.z.a unused2 = c.this.dsm;
                com.tencent.mm.z.a.pO(intValue);
                c.this.Yb();
                AppMethodBeat.o(204719);
            }
        });
        cVar.dsE.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.e.c.AnonymousClass6 */

            public final void onAnimationStart(Animator animator) {
                c.this.dsx = true;
                c.this.dsn = true;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(9127);
                c.this.dsn = true;
                AppMethodBeat.o(9127);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(9128);
                c.this.dsn = false;
                animator.removeAllListeners();
                AppMethodBeat.o(9128);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        cVar.dsE.setStartDelay(j2);
        cVar.dsE.setDuration(300L);
        cVar.dsE.start();
        AppMethodBeat.o(9146);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(204725);
        if (cVar.dsq != null) {
            g gVar = cVar.dsq;
            gVar.dgO.dsn = true;
            Log.i("FixRatioCropHelper", "resetBoxClipRect");
            float width = (((float) gVar.dgS.width()) * 1.0f) / ((float) gVar.dgS.height());
            if (gVar.dgO.drS.gtm() == null) {
                Log.w("FixRatioCropHelper", "[resetBoxRect] getImageBitmap is null!");
            } else if (width > gVar.dtn) {
                float height = ((float) gVar.dgS.height()) * gVar.dtn;
                Rect rect = gVar.dgS;
                int i2 = rect.top;
                rect.set((int) (((float) gVar.dgS.centerX()) - (height / 2.0f)), i2, (int) ((height / 2.0f) + ((float) gVar.dgS.centerX())), gVar.dgS.bottom);
            } else {
                float width2 = ((float) gVar.dgS.width()) / gVar.dtn;
                Rect rect2 = gVar.dgS;
                int i3 = gVar.dgS.left;
                int i4 = gVar.dgS.right;
                rect2.set(i3, (int) (((float) gVar.dgS.centerY()) - (width2 / 2.0f)), i4, (int) ((width2 / 2.0f) + ((float) gVar.dgS.centerY())));
            }
            h.RTc.n(new Runnable(Math.min((((float) gVar.dsl.width()) * 1.0f) / ((float) gVar.dgS.width()), (((float) gVar.dsl.height()) * 1.0f) / ((float) gVar.dgS.height())), ((float) gVar.dsl.centerX()) - ((float) gVar.dgS.centerX()), ((float) gVar.dsl.centerY()) - ((float) gVar.dgS.centerY())) {
                /* class com.tencent.mm.e.g.AnonymousClass1 */
                final /* synthetic */ float dsJ;
                final /* synthetic */ float dsK;
                final /* synthetic */ float dsL;

                {
                    this.dsJ = r2;
                    this.dsK = r3;
                    this.dsL = r4;
                }

                public final void run() {
                    AppMethodBeat.i(204727);
                    com.tencent.mm.c.a aVar = g.this.dgO.dsp;
                    aVar.dgV = 100;
                    aVar.a(this.dsJ, g.this.dgS, this.dsK, this.dsL);
                    aVar.play();
                    AppMethodBeat.o(204727);
                }
            }, 0);
        }
        AppMethodBeat.o(204725);
    }
}
