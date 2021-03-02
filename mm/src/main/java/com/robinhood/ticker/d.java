package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.robinhood.ticker.TickerView;
import com.robinhood.ticker.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {
    private final c[] cgD;
    final f cgE;
    char cgF = 0;
    char cgG = 0;
    char[] cgH;
    int cgI;
    float cgJ;
    float cgK;
    float cgL;
    float cgM;
    float cgN;
    float cgO;
    float cgP;
    float cgQ;
    int cgR;
    int endIndex;
    int startIndex;

    d(c[] cVarArr, f fVar) {
        this.cgD = cVarArr;
        this.cgE = fVar;
    }

    /* access modifiers changed from: package-private */
    public final void q(char c2) {
        c.a aVar;
        boolean z = false;
        AppMethodBeat.i(39845);
        this.cgG = c2;
        this.cgL = this.cgM;
        this.cgN = this.cgE.r(c2);
        this.cgO = Math.max(this.cgL, this.cgN);
        this.cgH = null;
        for (int i2 = 0; i2 < this.cgD.length; i2++) {
            c cVar = this.cgD[i2];
            char c3 = this.cgF;
            char c4 = this.cgG;
            TickerView.a aVar2 = this.cgE.cgX;
            int p = cVar.p(c3);
            int p2 = cVar.p(c4);
            if (p < 0 || p2 < 0) {
                aVar = null;
            } else {
                switch (aVar2) {
                    case DOWN:
                        if (c4 != 0) {
                            if (p2 < p) {
                                p2 += cVar.cgy;
                                break;
                            }
                        } else {
                            p2 = cVar.cgz.length;
                            break;
                        }
                        break;
                    case UP:
                        if (p < p2) {
                            p += cVar.cgy;
                            break;
                        }
                        break;
                    case ANY:
                        if (!(c3 == 0 || c4 == 0)) {
                            if (p2 < p) {
                                if ((cVar.cgy - p) + p2 < p - p2) {
                                    p2 += cVar.cgy;
                                    break;
                                }
                            } else if (p < p2 && (cVar.cgy - p2) + p < p2 - p) {
                                p += cVar.cgy;
                                break;
                            }
                        }
                        break;
                }
                aVar = new c.a(p, p2);
            }
            if (aVar != null) {
                this.cgH = this.cgD[i2].cgz;
                this.startIndex = aVar.startIndex;
                this.endIndex = aVar.endIndex;
            }
        }
        if (this.cgH == null) {
            if (this.cgF == this.cgG) {
                this.cgH = new char[]{this.cgF};
                this.endIndex = 0;
                this.startIndex = 0;
            } else {
                this.cgH = new char[]{this.cgF, this.cgG};
                this.startIndex = 0;
                this.endIndex = 1;
            }
        }
        if (this.endIndex >= this.startIndex) {
            z = true;
        }
        this.cgR = z ? 1 : -1;
        this.cgQ = this.cgP;
        this.cgP = 0.0f;
        AppMethodBeat.o(39845);
    }

    /* access modifiers changed from: package-private */
    public final float IM() {
        AppMethodBeat.i(39846);
        IN();
        float f2 = this.cgM;
        AppMethodBeat.o(39846);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final void IN() {
        AppMethodBeat.i(39847);
        float r = this.cgE.r(this.cgG);
        if (this.cgM == this.cgN && this.cgN != r) {
            this.cgN = r;
            this.cgM = r;
            this.cgO = r;
        }
        AppMethodBeat.o(39847);
    }

    static boolean a(Canvas canvas, Paint paint, char[] cArr, int i2, float f2) {
        AppMethodBeat.i(39848);
        if (i2 < 0 || i2 >= cArr.length) {
            AppMethodBeat.o(39848);
            return false;
        }
        canvas.drawText(cArr, i2, 1, 0.0f, f2, paint);
        AppMethodBeat.o(39848);
        return true;
    }
}
