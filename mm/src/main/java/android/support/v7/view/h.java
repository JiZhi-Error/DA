package android.support.v7.view;

import android.support.v4.view.aa;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    z aey;
    private final aa aez = new aa() {
        /* class android.support.v7.view.h.AnonymousClass1 */
        private boolean aeA = false;
        private int aeB = 0;

        @Override // android.support.v4.view.aa, android.support.v4.view.z
        public final void aI(View view) {
            if (!this.aeA) {
                this.aeA = true;
                if (h.this.aey != null) {
                    h.this.aey.aI(null);
                }
            }
        }

        @Override // android.support.v4.view.aa, android.support.v4.view.z
        public final void aJ(View view) {
            int i2 = this.aeB + 1;
            this.aeB = i2;
            if (i2 == h.this.xd.size()) {
                if (h.this.aey != null) {
                    h.this.aey.aJ(null);
                }
                this.aeB = 0;
                this.aeA = false;
                h.this.mIsStarted = false;
            }
        }
    };
    private long mDuration = -1;
    private Interpolator mInterpolator;
    boolean mIsStarted;
    final ArrayList<y> xd = new ArrayList<>();

    public final h a(y yVar) {
        if (!this.mIsStarted) {
            this.xd.add(yVar);
        }
        return this;
    }

    public final h a(y yVar, y yVar2) {
        this.xd.add(yVar);
        yVar2.k(yVar.getDuration());
        this.xd.add(yVar2);
        return this;
    }

    public final void start() {
        if (!this.mIsStarted) {
            Iterator<y> it = this.xd.iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (this.mDuration >= 0) {
                    next.j(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    next.a(this.mInterpolator);
                }
                if (this.aey != null) {
                    next.a(this.aez);
                }
                next.start();
            }
            this.mIsStarted = true;
        }
    }

    public final void cancel() {
        if (this.mIsStarted) {
            Iterator<y> it = this.xd.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mIsStarted = false;
        }
    }

    public final h hI() {
        if (!this.mIsStarted) {
            this.mDuration = 250;
        }
        return this;
    }

    public final h b(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public final h b(z zVar) {
        if (!this.mIsStarted) {
            this.aey = zVar;
        }
        return this;
    }
}
