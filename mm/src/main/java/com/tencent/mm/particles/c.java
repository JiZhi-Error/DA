package com.tencent.mm.particles;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c {
    private ValueAnimator animator;
    private float jIA;
    private float jIB;
    private float jIC;
    private float jID;
    private float jIE;
    private float jIF;
    private float jIG;
    private float jIH;
    private Float jII;
    private Float jIJ;
    private Float jIK;
    private Float jIL;
    private int jIM;
    private int jIN;
    private float jIO;
    private float jIP;
    private float jIQ;
    private float jIR;
    private Float jIS;
    private Float jIT;
    private long jIU;
    public float jIV;
    public float jIW;
    private final b jIn;
    private final d jIo;
    private final ViewGroup jIp;
    final ConfettiView jIq;
    final Queue<b> jIr;
    final List<b> jIs;
    private long jIt;
    int jIu;
    long jIv;
    private float jIw;
    private float jIx;
    public Interpolator jIy;
    private Rect jIz;
    private final Random random;

    public c(Context context, b bVar, d dVar, ViewGroup viewGroup) {
        this(bVar, dVar, viewGroup, ConfettiView.m11do(context));
        AppMethodBeat.i(151350);
        AppMethodBeat.o(151350);
    }

    private c(b bVar, d dVar, ViewGroup viewGroup, ConfettiView confettiView) {
        AppMethodBeat.i(151351);
        this.random = new Random();
        this.jIr = new LinkedList();
        this.jIs = new ArrayList(300);
        this.jIn = bVar;
        this.jIo = dVar;
        this.jIp = viewGroup;
        this.jIq = confettiView;
        this.jIq.jIs = this.jIs;
        this.jIq.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            /* class com.tencent.mm.particles.c.AnonymousClass1 */

            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(151348);
                c.this.bkK();
                AppMethodBeat.o(151348);
            }
        });
        this.jIU = -1;
        this.jIz = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        AppMethodBeat.o(151351);
    }

    public final c bkD() {
        this.jIu = 1;
        return this;
    }

    public final c bkE() {
        this.jIv = MAlarmHandler.NEXT_FIRE_INTERVAL;
        return this;
    }

    public final c ax(float f2) {
        this.jIw = f2 / 1000.0f;
        this.jIx = 1.0f / this.jIw;
        return this;
    }

    public final c bkF() {
        AppMethodBeat.i(223652);
        c G = G(0.0f, 0.0f);
        AppMethodBeat.o(223652);
        return G;
    }

    public final c G(float f2, float f3) {
        this.jIA = f2 / 1000.0f;
        this.jIB = f3 / 1000.0f;
        return this;
    }

    public final c H(float f2, float f3) {
        this.jIC = f2 / 1000.0f;
        this.jID = f3 / 1000.0f;
        return this;
    }

    public final c ay(float f2) {
        this.jIE = f2 / 1000000.0f;
        this.jIF = 0.0f;
        return this;
    }

    public final c az(float f2) {
        this.jIG = f2 / 1000000.0f;
        this.jIH = 0.0f;
        return this;
    }

    public final c bkG() {
        this.jIM = TXLiveConstants.RENDER_ROTATION_180;
        this.jIN = TXLiveConstants.RENDER_ROTATION_180;
        return this;
    }

    public final c bkH() {
        this.jIQ = 3.6E-4f;
        this.jIR = 1.8E-4f;
        return this;
    }

    public final c bkI() {
        AppMethodBeat.i(151352);
        this.jIS = Float.valueOf(0.36f);
        this.jIT = Float.valueOf(0.0f);
        AppMethodBeat.o(151352);
        return this;
    }

    public final c AQ(long j2) {
        this.jIU = j2;
        return this;
    }

    public final c bkJ() {
        AppMethodBeat.i(151353);
        bkL();
        bkM();
        H(this.jIu, 0L);
        bkN();
        AppMethodBeat.o(151353);
        return this;
    }

    public final void bkK() {
        AppMethodBeat.i(151354);
        if (this.animator != null) {
            this.animator.cancel();
        }
        this.jIq.bkK();
        AppMethodBeat.o(151354);
    }

    private void bkL() {
        AppMethodBeat.i(151355);
        if (this.animator != null) {
            this.animator.cancel();
        }
        this.jIt = 0;
        Iterator<b> it = this.jIs.iterator();
        while (it.hasNext()) {
            this.jIr.add(it.next());
            it.remove();
        }
        AppMethodBeat.o(151355);
    }

    private void bkM() {
        AppMethodBeat.i(151356);
        ViewParent parent = this.jIq.getParent();
        if (parent != null) {
            if (parent != this.jIp) {
                ((ViewGroup) parent).removeView(this.jIq);
            }
            this.jIq.terminated = false;
            AppMethodBeat.o(151356);
        }
        this.jIp.addView(this.jIq);
        this.jIq.terminated = false;
        AppMethodBeat.o(151356);
    }

    private void H(int i2, long j2) {
        b bVar;
        AppMethodBeat.i(151357);
        for (int i3 = 0; i3 < i2; i3++) {
            b poll = this.jIr.poll();
            if (poll == null) {
                bVar = this.jIn.a(this.random);
            } else {
                bVar = poll;
            }
            a(bVar, this.jIo, this.random, j2);
            this.jIs.add(bVar);
        }
        AppMethodBeat.o(151357);
    }

    private void bkN() {
        AppMethodBeat.i(151358);
        this.animator = ValueAnimator.ofInt(0).setDuration(MAlarmHandler.NEXT_FIRE_INTERVAL);
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.particles.c.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                boolean z;
                AppMethodBeat.i(151349);
                long currentPlayTime = valueAnimator.getCurrentPlayTime();
                c.a(c.this, currentPlayTime);
                c cVar = c.this;
                Iterator<b> it = cVar.jIs.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.jJj == -1) {
                        next.jJj = currentPlayTime;
                    }
                    long j2 = currentPlayTime - next.jJj;
                    next.jJy = j2 >= 0;
                    if (next.jJy && !next.terminated) {
                        next.jJv = b.a(j2, next.jJk, next.jJm, next.jIE, next.jJo, next.jII);
                        next.jJw = b.a(j2, next.jJl, next.jJn, next.jIG, next.jJp, next.jIK);
                        next.jJx = b.a(j2, next.jJq, next.jJr, next.jIQ, next.jJs, next.jIS);
                        if (next.jIy != null) {
                            next.alpha = (int) (next.jIy.getInterpolation(((float) j2) / next.jJt) * 255.0f);
                        } else {
                            next.alpha = 255;
                        }
                        next.terminated = !next.jJz && ((float) j2) >= next.jJt;
                        next.jJu = Math.min(1.0f, ((float) j2) / next.jJt);
                    }
                    if (!next.terminated) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        it.remove();
                        cVar.jIr.add(next);
                    }
                }
                if (c.this.jIs.size() != 0 || currentPlayTime < c.this.jIv) {
                    c.this.jIq.invalidate();
                    AppMethodBeat.o(151349);
                    return;
                }
                c.this.bkK();
                AppMethodBeat.o(151349);
            }
        });
        this.animator.start();
        AppMethodBeat.o(151358);
    }

    private void a(b bVar, d dVar, Random random2, long j2) {
        Float valueOf;
        Float valueOf2;
        Float f2 = null;
        AppMethodBeat.i(151359);
        bVar.reset();
        bVar.jJj = j2;
        bVar.jJk = dVar.aA(random2.nextFloat());
        bVar.jJl = dVar.aB(random2.nextFloat());
        bVar.jJm = a(this.jIA, this.jIB, random2);
        bVar.jJn = a(this.jIC, this.jID, random2);
        bVar.jIE = a(this.jIE, this.jIF, random2);
        bVar.jIG = a(this.jIG, this.jIH, random2);
        if (this.jII == null) {
            valueOf = null;
        } else {
            valueOf = Float.valueOf(a(this.jII.floatValue(), this.jIJ.floatValue(), random2));
        }
        bVar.jII = valueOf;
        if (this.jIK == null) {
            valueOf2 = null;
        } else {
            valueOf2 = Float.valueOf(a(this.jIK.floatValue(), this.jIL.floatValue(), random2));
        }
        bVar.jIK = valueOf2;
        bVar.jJq = a((float) this.jIM, (float) this.jIN, random2);
        bVar.jJr = a(this.jIO, this.jIP, random2);
        bVar.jIQ = a(this.jIQ, this.jIR, random2);
        if (this.jIS != null) {
            f2 = Float.valueOf(a(this.jIS.floatValue(), this.jIT.floatValue(), random2));
        }
        bVar.jIS = f2;
        bVar.jIU = this.jIU;
        bVar.jIy = this.jIy;
        bVar.jJt = a(this.jIV, this.jIW, random2);
        bVar.k(this.jIz);
        AppMethodBeat.o(151359);
    }

    private static float a(float f2, float f3, Random random2) {
        AppMethodBeat.i(151360);
        float nextFloat = (((random2.nextFloat() * 2.0f) - 1.0f) * f3) + f2;
        AppMethodBeat.o(151360);
        return nextFloat;
    }

    static /* synthetic */ void a(c cVar, long j2) {
        AppMethodBeat.i(151361);
        if (j2 < cVar.jIv) {
            if (cVar.jIt == 0) {
                cVar.jIt = j2;
                AppMethodBeat.o(151361);
                return;
            }
            int nextFloat = (int) (((float) (j2 - cVar.jIt)) * cVar.random.nextFloat() * cVar.jIw);
            if (nextFloat > 0) {
                cVar.jIt = (long) (((float) cVar.jIt) + (cVar.jIx * ((float) nextFloat)));
                cVar.H(nextFloat, j2);
            }
        }
        AppMethodBeat.o(151361);
    }
}
