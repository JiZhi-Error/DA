package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class s {
    final b alX;
    final a alY = new a();
    final List<View> alZ = new ArrayList();

    /* access modifiers changed from: package-private */
    public interface b {
        void addView(View view, int i2);

        void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams);

        RecyclerView.v bi(View view);

        void bj(View view);

        void bk(View view);

        void detachViewFromParent(int i2);

        View getChildAt(int i2);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i2);
    }

    s(b bVar) {
        this.alX = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void bf(View view) {
        this.alZ.add(view);
        this.alX.bj(view);
    }

    /* access modifiers changed from: package-private */
    public final boolean bg(View view) {
        if (!this.alZ.remove(view)) {
            return false;
        }
        this.alX.bk(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, boolean z) {
        int bL;
        if (i2 < 0) {
            bL = this.alX.getChildCount();
        } else {
            bL = bL(i2);
        }
        this.alY.i(bL, z);
        if (z) {
            bf(view);
        }
        this.alX.addView(view, bL);
    }

    private int bL(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = this.alX.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            int bN = i2 - (i3 - this.alY.bN(i3));
            if (bN == 0) {
                while (this.alY.get(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += bN;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void removeViewAt(int i2) {
        int bL = bL(i2);
        View childAt = this.alX.getChildAt(bL);
        if (childAt != null) {
            if (this.alY.remove(bL)) {
                bg(childAt);
            }
            this.alX.removeViewAt(bL);
        }
    }

    /* access modifiers changed from: package-private */
    public final View getChildAt(int i2) {
        return this.alX.getChildAt(bL(i2));
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int bL;
        if (i2 < 0) {
            bL = this.alX.getChildCount();
        } else {
            bL = bL(i2);
        }
        this.alY.i(bL, z);
        if (z) {
            bf(view);
        }
        this.alX.attachViewToParent(view, bL, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public final int getChildCount() {
        return this.alX.getChildCount() - this.alZ.size();
    }

    /* access modifiers changed from: package-private */
    public final int jA() {
        return this.alX.getChildCount();
    }

    /* access modifiers changed from: package-private */
    public final View bM(int i2) {
        return this.alX.getChildAt(i2);
    }

    /* access modifiers changed from: package-private */
    public final void detachViewFromParent(int i2) {
        int bL = bL(i2);
        this.alY.remove(bL);
        this.alX.detachViewFromParent(bL);
    }

    /* access modifiers changed from: package-private */
    public final int indexOfChild(View view) {
        int indexOfChild = this.alX.indexOfChild(view);
        if (indexOfChild != -1 && !this.alY.get(indexOfChild)) {
            return indexOfChild - this.alY.bN(indexOfChild);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final boolean bh(View view) {
        return this.alZ.contains(view);
    }

    public final String toString() {
        return this.alY.toString() + ", hidden list:" + this.alZ.size();
    }

    /* access modifiers changed from: package-private */
    public static class a {
        long ama = 0;
        a amb;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void set(int i2) {
            while (i2 >= 64) {
                this.jB();
                this = this.amb;
                i2 -= 64;
            }
            this.ama |= 1 << i2;
        }

        private void jB() {
            if (this.amb == null) {
                this.amb = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void clear(int i2) {
            while (i2 >= 64) {
                if (this.amb != null) {
                    this = this.amb;
                    i2 -= 64;
                } else {
                    return;
                }
            }
            this.ama &= (1 << i2) ^ -1;
        }

        /* access modifiers changed from: package-private */
        public final boolean get(int i2) {
            while (i2 >= 64) {
                this.jB();
                this = this.amb;
                i2 -= 64;
            }
            return (this.ama & (1 << i2)) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void i(int i2, boolean z) {
            while (true) {
                if (i2 >= 64) {
                    this.jB();
                    this = this.amb;
                    i2 -= 64;
                } else {
                    boolean z2 = (this.ama & Long.MIN_VALUE) != 0;
                    long j2 = (1 << i2) - 1;
                    this.ama = (((j2 ^ -1) & this.ama) << 1) | (this.ama & j2);
                    if (z) {
                        this.set(i2);
                    } else {
                        this.clear(i2);
                    }
                    if (z2 || this.amb != null) {
                        this.jB();
                        this = this.amb;
                        i2 = 0;
                        z = z2;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean remove(int i2) {
            while (i2 >= 64) {
                this.jB();
                this = this.amb;
                i2 -= 64;
            }
            long j2 = 1 << i2;
            boolean z = (this.ama & j2) != 0;
            this.ama &= j2 ^ -1;
            long j3 = j2 - 1;
            this.ama = Long.rotateRight((j3 ^ -1) & this.ama, 1) | (this.ama & j3);
            if (this.amb != null) {
                if (this.amb.get(0)) {
                    this.set(63);
                }
                this.amb.remove(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final int bN(int i2) {
            if (this.amb == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.ama);
                }
                return Long.bitCount(this.ama & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.ama & ((1 << i2) - 1));
            } else {
                return this.amb.bN(i2 - 64) + Long.bitCount(this.ama);
            }
        }

        public final String toString() {
            if (this.amb == null) {
                return Long.toBinaryString(this.ama);
            }
            return this.amb.toString() + "xx" + Long.toBinaryString(this.ama);
        }
    }
}
