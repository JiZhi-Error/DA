package com.google.android.gms.common.images.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CrossFadingDrawable extends Drawable implements Drawable.Callback {
    private int mAlpha;
    private int mFrom;
    private boolean zzpl;
    private int zzpw;
    private long zzpx;
    private int zzpy;
    private int zzpz;
    private int zzqa;
    private boolean zzqb;
    private zzb zzqc;
    private Drawable zzqd;
    private Drawable zzqe;
    private boolean zzqf;
    private boolean zzqg;
    private boolean zzqh;
    private int zzqi;

    static final class zza extends Drawable {
        private static final zza zzqj = new zza();
        private static final zzb zzqk = new zzb();

        static {
            AppMethodBeat.i(11751);
            AppMethodBeat.o(11751);
        }

        private zza() {
        }

        public final void draw(Canvas canvas) {
        }

        public final Drawable.ConstantState getConstantState() {
            return zzqk;
        }

        public final int getOpacity() {
            return -2;
        }

        public final void setAlpha(int i2) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzb extends Drawable.ConstantState {
        int mChangingConfigurations;
        int zzql;

        zzb(zzb zzb) {
            AppMethodBeat.i(11752);
            if (zzb != null) {
                this.mChangingConfigurations = zzb.mChangingConfigurations;
                this.zzql = zzb.zzql;
            }
            AppMethodBeat.o(11752);
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(11753);
            CrossFadingDrawable crossFadingDrawable = new CrossFadingDrawable(this);
            AppMethodBeat.o(11753);
            return crossFadingDrawable;
        }
    }

    public CrossFadingDrawable(Drawable drawable, Drawable drawable2) {
        this(null);
        AppMethodBeat.i(11754);
        drawable = drawable == null ? zza.zzqj : drawable;
        this.zzqd = drawable;
        drawable.setCallback(this);
        this.zzqc.zzql |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.zzqj : drawable2;
        this.zzqe = drawable2;
        drawable2.setCallback(this);
        this.zzqc.zzql |= drawable2.getChangingConfigurations();
        AppMethodBeat.o(11754);
    }

    CrossFadingDrawable(zzb zzb2) {
        AppMethodBeat.i(11755);
        this.zzpw = 0;
        this.zzpz = 255;
        this.mAlpha = 0;
        this.zzpl = true;
        this.zzqc = new zzb(zzb2);
        AppMethodBeat.o(11755);
    }

    public final boolean canConstantState() {
        AppMethodBeat.i(11767);
        if (!this.zzqf) {
            this.zzqg = (this.zzqd.getConstantState() == null || this.zzqe.getConstantState() == null) ? false : true;
            this.zzqf = true;
        }
        boolean z = this.zzqg;
        AppMethodBeat.o(11767);
        return z;
    }

    public final void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(11771);
        switch (this.zzpw) {
            case 1:
                this.zzpx = SystemClock.uptimeMillis();
                this.zzpw = 2;
                break;
            case 2:
                if (this.zzpx >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzpx)) / ((float) this.zzqa);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.zzpw = 0;
                    }
                    this.mAlpha = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) this.zzpy)) + 0.0f);
                }
            default:
                z2 = z;
                break;
        }
        int i2 = this.mAlpha;
        boolean z3 = this.zzpl;
        Drawable drawable = this.zzqd;
        Drawable drawable2 = this.zzqe;
        if (z2) {
            if (!z3 || i2 == 0) {
                drawable.draw(canvas);
            }
            if (i2 == this.zzpz) {
                drawable2.setAlpha(this.zzpz);
                drawable2.draw(canvas);
            }
            AppMethodBeat.o(11771);
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zzpz - i2);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zzpz);
        }
        if (i2 > 0) {
            drawable2.setAlpha(i2);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzpz);
        }
        invalidateSelf();
        AppMethodBeat.o(11771);
    }

    public final int getChangingConfigurations() {
        AppMethodBeat.i(11759);
        int changingConfigurations = super.getChangingConfigurations() | this.zzqc.mChangingConfigurations | this.zzqc.zzql;
        AppMethodBeat.o(11759);
        return changingConfigurations;
    }

    public final Drawable.ConstantState getConstantState() {
        AppMethodBeat.i(11765);
        if (canConstantState()) {
            this.zzqc.mChangingConfigurations = getChangingConfigurations();
            zzb zzb2 = this.zzqc;
            AppMethodBeat.o(11765);
            return zzb2;
        }
        AppMethodBeat.o(11765);
        return null;
    }

    public final Drawable getEndDrawable() {
        return this.zzqe;
    }

    public final int getIntrinsicHeight() {
        AppMethodBeat.i(11763);
        int max = Math.max(this.zzqd.getIntrinsicHeight(), this.zzqe.getIntrinsicHeight());
        AppMethodBeat.o(11763);
        return max;
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(11762);
        int max = Math.max(this.zzqd.getIntrinsicWidth(), this.zzqe.getIntrinsicWidth());
        AppMethodBeat.o(11762);
        return max;
    }

    public final int getOpacity() {
        AppMethodBeat.i(11766);
        if (!this.zzqh) {
            this.zzqi = Drawable.resolveOpacity(this.zzqd.getOpacity(), this.zzqe.getOpacity());
            this.zzqh = true;
        }
        int i2 = this.zzqi;
        AppMethodBeat.o(11766);
        return i2;
    }

    public final Drawable getStartDrawable() {
        return this.zzqd;
    }

    public final void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(11756);
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
        AppMethodBeat.o(11756);
    }

    public final Drawable mutate() {
        AppMethodBeat.i(11768);
        if (!this.zzqb && super.mutate() == this) {
            if (!canConstantState()) {
                IllegalStateException illegalStateException = new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
                AppMethodBeat.o(11768);
                throw illegalStateException;
            }
            this.zzqd.mutate();
            this.zzqe.mutate();
            this.zzqb = true;
        }
        AppMethodBeat.o(11768);
        return this;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(11764);
        this.zzqd.setBounds(rect);
        this.zzqe.setBounds(rect);
        AppMethodBeat.o(11764);
    }

    public final void resetTransition() {
        AppMethodBeat.i(11770);
        this.mAlpha = 0;
        this.zzpw = 0;
        invalidateSelf();
        AppMethodBeat.o(11770);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        AppMethodBeat.i(11757);
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
        AppMethodBeat.o(11757);
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(11760);
        if (this.mAlpha == this.zzpz) {
            this.mAlpha = i2;
        }
        this.zzpz = i2;
        invalidateSelf();
        AppMethodBeat.o(11760);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(11761);
        this.zzqd.setColorFilter(colorFilter);
        this.zzqe.setColorFilter(colorFilter);
        AppMethodBeat.o(11761);
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public final void startTransition(int i2) {
        AppMethodBeat.i(11769);
        this.mFrom = 0;
        this.zzpy = this.zzpz;
        this.mAlpha = 0;
        this.zzqa = i2;
        this.zzpw = 1;
        invalidateSelf();
        AppMethodBeat.o(11769);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        AppMethodBeat.i(11758);
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
        AppMethodBeat.o(11758);
    }
}
