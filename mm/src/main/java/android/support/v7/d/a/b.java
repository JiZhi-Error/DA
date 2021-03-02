package android.support.v7.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* access modifiers changed from: package-private */
public class b extends Drawable implements Drawable.Callback {
    AbstractC0046b ach;
    private Rect aci;
    private Drawable acj;
    private Drawable ack;
    private boolean acl;
    int acm = -1;
    private int acn = -1;
    private Runnable aco;
    private long acp;
    private long acq;
    private a acr;
    private int mAlpha = 255;
    private boolean xp;

    b() {
    }

    public void draw(Canvas canvas) {
        if (this.acj != null) {
            this.acj.draw(canvas);
        }
        if (this.ack != null) {
            this.ack.draw(canvas);
        }
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.ach.getChangingConfigurations();
    }

    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rect2 = null;
        boolean z = true;
        AbstractC0046b bVar = this.ach;
        if (!bVar.acA) {
            if (bVar.acC != null || bVar.acB) {
                rect2 = bVar.acC;
            } else {
                bVar.hx();
                Rect rect3 = new Rect();
                int i2 = bVar.acz;
                Drawable[] drawableArr = bVar.acy;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect3)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        if (rect3.left > rect2.left) {
                            rect2.left = rect3.left;
                        }
                        if (rect3.top > rect2.top) {
                            rect2.top = rect3.top;
                        }
                        if (rect3.right > rect2.right) {
                            rect2.right = rect3.right;
                        }
                        if (rect3.bottom > rect2.bottom) {
                            rect2.bottom = rect3.bottom;
                        }
                    }
                }
                bVar.acB = true;
                bVar.acC = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            padding = (rect2.right | ((rect2.left | rect2.top) | rect2.bottom)) != 0;
        } else if (this.acj != null) {
            padding = this.acj.getPadding(rect);
        } else {
            padding = super.getPadding(rect);
        }
        if (!isAutoMirrored() || getLayoutDirection() != 1) {
            z = false;
        }
        if (z) {
            int i4 = rect.left;
            rect.left = rect.right;
            rect.right = i4;
        }
        return padding;
    }

    public void getOutline(Outline outline) {
        if (this.acj != null) {
            this.acj.getOutline(outline);
        }
    }

    public void setAlpha(int i2) {
        if (!this.acl || this.mAlpha != i2) {
            this.acl = true;
            this.mAlpha = i2;
            if (this.acj == null) {
                return;
            }
            if (this.acp == 0) {
                this.acj.setAlpha(i2);
            } else {
                Y(false);
            }
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public void setDither(boolean z) {
        if (this.ach.acP != z) {
            this.ach.acP = z;
            if (this.acj != null) {
                this.acj.setDither(this.ach.acP);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.ach.acS = true;
        if (this.ach.xo != colorFilter) {
            this.ach.xo = colorFilter;
            if (this.acj != null) {
                this.acj.setColorFilter(colorFilter);
            }
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        this.ach.acT = true;
        if (this.ach.Kr != colorStateList) {
            this.ach.Kr = colorStateList;
            android.support.v4.graphics.drawable.a.a(this.acj, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.ach.acU = true;
        if (this.ach.yl != mode) {
            this.ach.yl = mode;
            android.support.v4.graphics.drawable.a.a(this.acj, mode);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.ack != null) {
            this.ack.setBounds(rect);
        }
        if (this.acj != null) {
            this.acj.setBounds(rect);
        }
    }

    public boolean isStateful() {
        boolean z = false;
        AbstractC0046b bVar = this.ach;
        if (bVar.acL) {
            return bVar.acM;
        }
        bVar.hx();
        int i2 = bVar.acz;
        Drawable[] drawableArr = bVar.acy;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (drawableArr[i3].isStateful()) {
                z = true;
                break;
            } else {
                i3++;
            }
        }
        bVar.acM = z;
        bVar.acL = true;
        return z;
    }

    public void setAutoMirrored(boolean z) {
        if (this.ach.ym != z) {
            this.ach.ym = z;
            if (this.acj != null) {
                android.support.v4.graphics.drawable.a.a(this.acj, this.ach.ym);
            }
        }
    }

    public boolean isAutoMirrored() {
        return this.ach.ym;
    }

    public void jumpToCurrentState() {
        boolean z = true;
        boolean z2 = false;
        if (this.ack != null) {
            this.ack.jumpToCurrentState();
            this.ack = null;
            this.acn = -1;
            z2 = true;
        }
        if (this.acj != null) {
            this.acj.jumpToCurrentState();
            if (this.acl) {
                this.acj.setAlpha(this.mAlpha);
            }
        }
        if (this.acq != 0) {
            this.acq = 0;
            z2 = true;
        }
        if (this.acp != 0) {
            this.acp = 0;
        } else {
            z = z2;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public void setHotspot(float f2, float f3) {
        if (this.acj != null) {
            android.support.v4.graphics.drawable.a.a(this.acj, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        if (this.aci == null) {
            this.aci = new Rect(i2, i3, i4, i5);
        } else {
            this.aci.set(i2, i3, i4, i5);
        }
        if (this.acj != null) {
            android.support.v4.graphics.drawable.a.a(this.acj, i2, i3, i4, i5);
        }
    }

    public void getHotspotBounds(Rect rect) {
        if (this.aci != null) {
            rect.set(this.aci);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.ack != null) {
            return this.ack.setState(iArr);
        }
        if (this.acj != null) {
            return this.acj.setState(iArr);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        if (this.ack != null) {
            return this.ack.setLevel(i2);
        }
        if (this.acj != null) {
            return this.acj.setLevel(i2);
        }
        return false;
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean z;
        AbstractC0046b bVar = this.ach;
        int i3 = this.acm;
        int i4 = bVar.acz;
        Drawable[] drawableArr = bVar.acy;
        int i5 = 0;
        boolean z2 = false;
        while (i5 < i4) {
            if (drawableArr[i5] != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    z = drawableArr[i5].setLayoutDirection(i2);
                } else {
                    z = false;
                }
                if (i5 == i3) {
                    i5++;
                    z2 = z;
                }
            }
            z = z2;
            i5++;
            z2 = z;
        }
        bVar.mLayoutDirection = i2;
        return z2;
    }

    public int getIntrinsicWidth() {
        if (this.ach.acD) {
            AbstractC0046b bVar = this.ach;
            if (!bVar.acE) {
                bVar.computeConstantSize();
            }
            return bVar.acF;
        } else if (this.acj != null) {
            return this.acj.getIntrinsicWidth();
        } else {
            return -1;
        }
    }

    public int getIntrinsicHeight() {
        if (this.ach.acD) {
            AbstractC0046b bVar = this.ach;
            if (!bVar.acE) {
                bVar.computeConstantSize();
            }
            return bVar.acG;
        } else if (this.acj != null) {
            return this.acj.getIntrinsicHeight();
        } else {
            return -1;
        }
    }

    public int getMinimumWidth() {
        if (this.ach.acD) {
            AbstractC0046b bVar = this.ach;
            if (!bVar.acE) {
                bVar.computeConstantSize();
            }
            return bVar.acH;
        } else if (this.acj != null) {
            return this.acj.getMinimumWidth();
        } else {
            return 0;
        }
    }

    public int getMinimumHeight() {
        if (this.ach.acD) {
            AbstractC0046b bVar = this.ach;
            if (!bVar.acE) {
                bVar.computeConstantSize();
            }
            return bVar.acI;
        } else if (this.acj != null) {
            return this.acj.getMinimumHeight();
        } else {
            return 0;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.ach != null) {
            this.ach.hw();
        }
        if (drawable == this.acj && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.acj && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.acj && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.ack != null) {
            this.ack.setVisible(z, z2);
        }
        if (this.acj != null) {
            this.acj.setVisible(z, z2);
        }
        return visible;
    }

    public int getOpacity() {
        int i2 = -2;
        if (this.acj == null || !this.acj.isVisible()) {
            return -2;
        }
        AbstractC0046b bVar = this.ach;
        if (bVar.acJ) {
            return bVar.acK;
        }
        bVar.hx();
        int i3 = bVar.acz;
        Drawable[] drawableArr = bVar.acy;
        if (i3 > 0) {
            i2 = drawableArr[0].getOpacity();
        }
        for (int i4 = 1; i4 < i3; i4++) {
            i2 = Drawable.resolveOpacity(i2, drawableArr[i4].getOpacity());
        }
        bVar.acK = i2;
        bVar.acJ = true;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean selectDrawable(int i2) {
        if (i2 == this.acm) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.ach.acR > 0) {
            if (this.ack != null) {
                this.ack.setVisible(false, false);
            }
            if (this.acj != null) {
                this.ack = this.acj;
                this.acn = this.acm;
                this.acq = ((long) this.ach.acR) + uptimeMillis;
            } else {
                this.ack = null;
                this.acn = -1;
                this.acq = 0;
            }
        } else if (this.acj != null) {
            this.acj.setVisible(false, false);
        }
        if (i2 < 0 || i2 >= this.ach.acz) {
            this.acj = null;
            this.acm = -1;
        } else {
            Drawable child = this.ach.getChild(i2);
            this.acj = child;
            this.acm = i2;
            if (child != null) {
                if (this.ach.acQ > 0) {
                    this.acp = uptimeMillis + ((long) this.ach.acQ);
                }
                m(child);
            }
        }
        if (!(this.acp == 0 && this.acq == 0)) {
            if (this.aco == null) {
                this.aco = new Runnable() {
                    /* class android.support.v7.d.a.b.AnonymousClass1 */

                    public final void run() {
                        b.this.Y(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.aco);
            }
            Y(true);
        }
        invalidateSelf();
        return true;
    }

    private void m(Drawable drawable) {
        if (this.acr == null) {
            this.acr = new a();
        }
        a aVar = this.acr;
        aVar.wZ = drawable.getCallback();
        drawable.setCallback(aVar);
        try {
            if (this.ach.acQ <= 0 && this.acl) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.ach.acS) {
                drawable.setColorFilter(this.ach.xo);
            } else {
                if (this.ach.acT) {
                    android.support.v4.graphics.drawable.a.a(drawable, this.ach.Kr);
                }
                if (this.ach.acU) {
                    android.support.v4.graphics.drawable.a.a(drawable, this.ach.yl);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.ach.acP);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.ach.ym);
            }
            Rect rect = this.aci;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.acr.hv());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y(boolean r13) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.d.a.b.Y(boolean):void");
    }

    public Drawable getCurrent() {
        return this.acj;
    }

    public void applyTheme(Resources.Theme theme) {
        AbstractC0046b bVar = this.ach;
        if (theme != null) {
            bVar.hx();
            int i2 = bVar.acz;
            Drawable[] drawableArr = bVar.acy;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                    bVar.acw |= drawableArr[i3].getChangingConfigurations();
                }
            }
            bVar.e(theme.getResources());
        }
    }

    public boolean canApplyTheme() {
        return this.ach.canApplyTheme();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.ach.canConstantState()) {
            return null;
        }
        this.ach.mChangingConfigurations = getChangingConfigurations();
        return this.ach;
    }

    public Drawable mutate() {
        if (!this.xp && super.mutate() == this) {
            AbstractC0046b hs = hs();
            hs.ht();
            a(hs);
            this.xp = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public AbstractC0046b hs() {
        return this.ach;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v7.d.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0046b extends Drawable.ConstantState {
        ColorStateList Kr;
        boolean acA = false;
        boolean acB;
        Rect acC;
        boolean acD = false;
        boolean acE;
        int acF;
        int acG;
        int acH;
        int acI;
        boolean acJ;
        int acK;
        boolean acL;
        boolean acM;
        boolean acN;
        boolean acO;
        boolean acP = true;
        int acQ = 0;
        int acR = 0;
        boolean acS;
        boolean acT;
        boolean acU;
        final b act;
        Resources acu;
        int acv = 160;
        int acw;
        SparseArray<Drawable.ConstantState> acx;
        Drawable[] acy;
        int acz;
        int mChangingConfigurations;
        int mLayoutDirection;
        ColorFilter xo;
        boolean xp;
        PorterDuff.Mode yl;
        boolean ym;

        AbstractC0046b(AbstractC0046b bVar, b bVar2, Resources resources) {
            this.act = bVar2;
            this.acu = resources != null ? resources : bVar != null ? bVar.acu : null;
            this.acv = b.b(resources, bVar != null ? bVar.acv : 0);
            if (bVar != null) {
                this.mChangingConfigurations = bVar.mChangingConfigurations;
                this.acw = bVar.acw;
                this.acN = true;
                this.acO = true;
                this.acA = bVar.acA;
                this.acD = bVar.acD;
                this.acP = bVar.acP;
                this.xp = bVar.xp;
                this.mLayoutDirection = bVar.mLayoutDirection;
                this.acQ = bVar.acQ;
                this.acR = bVar.acR;
                this.ym = bVar.ym;
                this.xo = bVar.xo;
                this.acS = bVar.acS;
                this.Kr = bVar.Kr;
                this.yl = bVar.yl;
                this.acT = bVar.acT;
                this.acU = bVar.acU;
                if (bVar.acv == this.acv) {
                    if (bVar.acB) {
                        this.acC = new Rect(bVar.acC);
                        this.acB = true;
                    }
                    if (bVar.acE) {
                        this.acF = bVar.acF;
                        this.acG = bVar.acG;
                        this.acH = bVar.acH;
                        this.acI = bVar.acI;
                        this.acE = true;
                    }
                }
                if (bVar.acJ) {
                    this.acK = bVar.acK;
                    this.acJ = true;
                }
                if (bVar.acL) {
                    this.acM = bVar.acM;
                    this.acL = true;
                }
                Drawable[] drawableArr = bVar.acy;
                this.acy = new Drawable[drawableArr.length];
                this.acz = bVar.acz;
                SparseArray<Drawable.ConstantState> sparseArray = bVar.acx;
                if (sparseArray != null) {
                    this.acx = sparseArray.clone();
                } else {
                    this.acx = new SparseArray<>(this.acz);
                }
                int i2 = this.acz;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.acx.put(i3, constantState);
                        } else {
                            this.acy[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.acy = new Drawable[10];
            this.acz = 0;
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.acw;
        }

        public final int addChild(Drawable drawable) {
            int i2 = this.acz;
            if (i2 >= this.acy.length) {
                growArray(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.act);
            this.acy[i2] = drawable;
            this.acz++;
            this.acw |= drawable.getChangingConfigurations();
            hw();
            this.acC = null;
            this.acB = false;
            this.acE = false;
            this.acN = false;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void hw() {
            this.acJ = false;
            this.acL = false;
        }

        /* access modifiers changed from: package-private */
        public final void hx() {
            if (this.acx != null) {
                int size = this.acx.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.acy[this.acx.keyAt(i2)] = n(this.acx.valueAt(i2).newDrawable(this.acu));
                }
                this.acx = null;
            }
        }

        private Drawable n(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.mLayoutDirection);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.act);
            return mutate;
        }

        public final Drawable getChild(int i2) {
            int indexOfKey;
            Drawable drawable = this.acy[i2];
            if (drawable != null) {
                return drawable;
            }
            if (this.acx == null || (indexOfKey = this.acx.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable n = n(this.acx.valueAt(indexOfKey).newDrawable(this.acu));
            this.acy[i2] = n;
            this.acx.removeAt(indexOfKey);
            if (this.acx.size() != 0) {
                return n;
            }
            this.acx = null;
            return n;
        }

        /* access modifiers changed from: package-private */
        public final void e(Resources resources) {
            if (resources != null) {
                this.acu = resources;
                int b2 = b.b(resources, this.acv);
                int i2 = this.acv;
                this.acv = b2;
                if (i2 != b2) {
                    this.acE = false;
                    this.acB = false;
                }
            }
        }

        public boolean canApplyTheme() {
            int i2 = this.acz;
            Drawable[] drawableArr = this.acy;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.acx.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void ht() {
            int i2 = this.acz;
            Drawable[] drawableArr = this.acy;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    drawableArr[i3].mutate();
                }
            }
            this.xp = true;
        }

        /* access modifiers changed from: package-private */
        public final void computeConstantSize() {
            this.acE = true;
            hx();
            int i2 = this.acz;
            Drawable[] drawableArr = this.acy;
            this.acG = -1;
            this.acF = -1;
            this.acI = 0;
            this.acH = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.acF) {
                    this.acF = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.acG) {
                    this.acG = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.acH) {
                    this.acH = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.acI) {
                    this.acI = minimumHeight;
                }
            }
        }

        public void growArray(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.acy, 0, drawableArr, 0, i2);
            this.acy = drawableArr;
        }

        public final synchronized boolean canConstantState() {
            boolean z = false;
            synchronized (this) {
                if (!this.acN) {
                    hx();
                    this.acN = true;
                    int i2 = this.acz;
                    Drawable[] drawableArr = this.acy;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= i2) {
                            this.acO = true;
                            z = true;
                            break;
                        } else if (drawableArr[i3].getConstantState() == null) {
                            this.acO = false;
                            break;
                        } else {
                            i3++;
                        }
                    }
                } else {
                    z = this.acO;
                }
            }
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public void a(AbstractC0046b bVar) {
        this.ach = bVar;
        if (this.acm >= 0) {
            this.acj = bVar.getChild(this.acm);
            if (this.acj != null) {
                m(this.acj);
            }
        }
        this.acn = -1;
        this.ack = null;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Drawable.Callback {
        Drawable.Callback wZ;

        a() {
        }

        public final Drawable.Callback hv() {
            Drawable.Callback callback = this.wZ;
            this.wZ = null;
            return callback;
        }

        public final void invalidateDrawable(Drawable drawable) {
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            if (this.wZ != null) {
                this.wZ.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.wZ != null) {
                this.wZ.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int b(Resources resources, int i2) {
        int i3 = resources == null ? i2 : resources.getDisplayMetrics().densityDpi;
        if (i3 == 0) {
            return 160;
        }
        return i3;
    }
}
