package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.support.v7.view.menu.o;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.mm.R;

public class n {
    private final h aaQ;
    private boolean afG;
    private o.a afH;
    PopupWindow.OnDismissListener afJ;
    private final int afp;
    private final int afq;
    private final boolean afr;
    protected int afz;
    private m ahe;
    private final PopupWindow.OnDismissListener ahf;
    private final Context mContext;
    protected View qK;

    public n(Context context, h hVar, View view, boolean z) {
        this(context, hVar, view, z, R.attr.ap, 0);
    }

    public n(Context context, h hVar, View view, boolean z, int i2, int i3) {
        this.afz = 8388611;
        this.ahf = new PopupWindow.OnDismissListener() {
            /* class android.support.v7.view.menu.n.AnonymousClass1 */

            public final void onDismiss() {
                n.this.onDismiss();
            }
        };
        this.mContext = context;
        this.aaQ = hVar;
        this.qK = view;
        this.afr = z;
        this.afp = i2;
        this.afq = i3;
    }

    public final void setForceShowIcon(boolean z) {
        this.afG = z;
        if (this.ahe != null) {
            this.ahe.setForceShowIcon(z);
        }
    }

    public final m iu() {
        m tVar;
        if (this.ahe == null) {
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.mg)) {
                tVar = new e(this.mContext, this.qK, this.afp, this.afq, this.afr);
            } else {
                tVar = new t(this.mContext, this.aaQ, this.qK, this.afp, this.afq, this.afr);
            }
            tVar.f(this.aaQ);
            tVar.setOnDismissListener(this.ahf);
            tVar.setAnchorView(this.qK);
            tVar.a(this.afH);
            tVar.setForceShowIcon(this.afG);
            tVar.setGravity(this.afz);
            this.ahe = tVar;
        }
        return this.ahe;
    }

    public final boolean iv() {
        if (isShowing()) {
            return true;
        }
        if (this.qK == null) {
            return false;
        }
        b(0, 0, false, false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, int i3, boolean z, boolean z2) {
        m iu = iu();
        iu.setShowTitle(z2);
        if (z) {
            if ((d.getAbsoluteGravity(this.afz, u.Z(this.qK)) & 7) == 5) {
                i2 -= this.qK.getWidth();
            }
            iu.setHorizontalOffset(i2);
            iu.setVerticalOffset(i3);
            int i4 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            iu.ahd = new Rect(i2 - i4, i3 - i4, i2 + i4, i4 + i3);
        }
        iu.show();
    }

    public final void dismiss() {
        if (isShowing()) {
            this.ahe.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDismiss() {
        this.ahe = null;
        if (this.afJ != null) {
            this.afJ.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.ahe != null && this.ahe.isShowing();
    }

    public final void c(o.a aVar) {
        this.afH = aVar;
        if (this.ahe != null) {
            this.ahe.a(aVar);
        }
    }
}
