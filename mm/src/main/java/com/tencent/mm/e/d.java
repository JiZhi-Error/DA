package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.cache.c;
import com.tencent.mm.view.footer.a;
import com.tencent.mm.z.b;

public final class d extends b {
    private float ayd;
    private float aye;
    private float dsW;
    private boolean dsX = true;
    private boolean dsY = false;
    private float dsy;
    private float dsz;
    public int mColor = a.RoQ[2];
    private Path xT = new Path();

    public d() {
        AppMethodBeat.i(9148);
        AppMethodBeat.o(9148);
    }

    @Override // com.tencent.mm.e.b
    public final void onAlive() {
        AppMethodBeat.i(9149);
        super.onAlive();
        this.dsW = this.drS.getInitScale();
        AppMethodBeat.o(9149);
    }

    @Override // com.tencent.mm.e.b
    public final a XS() {
        return a.DOODLE;
    }

    @Override // com.tencent.mm.e.b
    public final boolean q(MotionEvent motionEvent) {
        AppMethodBeat.i(9150);
        if (!XZ()) {
            AppMethodBeat.o(9150);
            return false;
        }
        if (this.dsb != null) {
            this.dsb.q(motionEvent);
        }
        float[] v = v(motionEvent.getX(), motionEvent.getY());
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.drU.contains((int) v[0], (int) v[1])) {
                    float f2 = v[0];
                    this.dsy = f2;
                    this.ayd = f2;
                    float f3 = v[1];
                    this.dsz = f3;
                    this.aye = f3;
                    this.dsX = true;
                } else {
                    this.dsX = false;
                }
                this.dsY = false;
                break;
            case 1:
            case 5:
                if (this.dsX && this.dsY) {
                    if (XU() == null) {
                        AppMethodBeat.o(9150);
                        return false;
                    }
                    XU().add(new b(new Path(this.xT), this.drS.getInitScale() / this.drS.getCurScale(), this.mColor));
                    cT(false);
                    c.alF().b(h.DOODLE);
                }
                Yc();
                this.xT.reset();
                this.dsY = false;
                this.dsX = false;
                break;
            case 2:
                if (!this.dsX || !this.dsY) {
                    if (this.dsX && !this.dsY) {
                        this.xT.moveTo(v[0], v[1]);
                        this.dsY = true;
                        break;
                    }
                } else {
                    this.dsy = this.ayd;
                    this.dsz = this.aye;
                    this.ayd = v[0];
                    this.aye = v[1];
                    this.xT.quadTo(this.dsy, this.dsz, (this.ayd + this.dsy) / 2.0f, (this.aye + this.dsz) / 2.0f);
                    Yb();
                    break;
                }
                break;
        }
        boolean z = this.dsX;
        AppMethodBeat.o(9150);
        return z;
    }

    @Override // com.tencent.mm.e.b
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(9151);
        canvas.save();
        canvas.clipRect(this.drU);
        d(canvas);
        if (!this.xT.isEmpty()) {
            new b(this.xT, this.drS.getInitScale() / this.drS.getCurScale(), this.mColor).draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(9151);
    }

    @Override // com.tencent.mm.e.b
    public final void XT() {
        AppMethodBeat.i(9152);
        cT(true);
        AppMethodBeat.o(9152);
    }
}
