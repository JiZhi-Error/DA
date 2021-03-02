package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

final class ad {
    boolean apX = true;
    int apY;
    int apZ;
    int aqa;
    int aqb = 0;
    int aqc = 0;
    boolean aqd;
    boolean aqe;
    int mLayoutDirection;

    ad() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(RecyclerView.s sVar) {
        return this.apZ >= 0 && this.apZ < sVar.getItemCount();
    }

    /* access modifiers changed from: package-private */
    public final View a(RecyclerView.n nVar) {
        View cq = nVar.cq(this.apZ);
        this.apZ += this.aqa;
        return cq;
    }

    public final String toString() {
        return "LayoutState{mAvailable=" + this.apY + ", mCurrentPosition=" + this.apZ + ", mItemDirection=" + this.aqa + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.aqb + ", mEndLine=" + this.aqc + '}';
    }
}
