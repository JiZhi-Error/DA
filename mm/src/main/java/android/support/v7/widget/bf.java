package android.support.v7.widget;

import android.view.View;

/* access modifiers changed from: package-private */
public final class bf {
    final b azN;
    a azO = new a();

    /* access modifiers changed from: package-private */
    public interface b {
        int bB(View view);

        int bC(View view);

        View getChildAt(int i2);

        int lE();

        int lF();
    }

    bf(b bVar) {
        this.azN = bVar;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int azP = 0;
        int azQ;
        int azR;
        int azS;
        int azT;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void setBounds(int i2, int i3, int i4, int i5) {
            this.azQ = i2;
            this.azR = i3;
            this.azS = i4;
            this.azT = i5;
        }

        /* access modifiers changed from: package-private */
        public final void addFlags(int i2) {
            this.azP |= i2;
        }

        private static int compare(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            if (i2 == i3) {
                return 2;
            }
            return 4;
        }

        /* access modifiers changed from: package-private */
        public final boolean nl() {
            if ((this.azP & 7) != 0 && (this.azP & (compare(this.azS, this.azQ) << 0)) == 0) {
                return false;
            }
            if ((this.azP & 112) != 0 && (this.azP & (compare(this.azS, this.azR) << 4)) == 0) {
                return false;
            }
            if ((this.azP & 1792) != 0 && (this.azP & (compare(this.azT, this.azQ) << 8)) == 0) {
                return false;
            }
            if ((this.azP & 28672) == 0 || (this.azP & (compare(this.azT, this.azR) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final View k(int i2, int i3, int i4, int i5) {
        int lE = this.azN.lE();
        int lF = this.azN.lF();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View childAt = this.azN.getChildAt(i2);
            this.azO.setBounds(lE, lF, this.azN.bB(childAt), this.azN.bC(childAt));
            if (i4 != 0) {
                this.azO.azP = 0;
                this.azO.addFlags(i4);
                if (this.azO.nl()) {
                    return childAt;
                }
            }
            if (i5 != 0) {
                this.azO.azP = 0;
                this.azO.addFlags(i5);
                if (this.azO.nl()) {
                    i2 += i6;
                    view = childAt;
                }
            }
            childAt = view;
            i2 += i6;
            view = childAt;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public final boolean bR(View view) {
        this.azO.setBounds(this.azN.lE(), this.azN.lF(), this.azN.bB(view), this.azN.bC(view));
        this.azO.azP = 0;
        this.azO.addFlags(24579);
        return this.azO.nl();
    }
}
