package android.support.transition;

import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.u;
import android.view.ViewGroup;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class o extends am {
    private float AP = 3.0f;
    int BH = 80;

    @Override // android.support.transition.t
    public final long a(ViewGroup viewGroup, Transition transition, v vVar, v vVar2) {
        int i2;
        int i3;
        int i4;
        int abs;
        int width;
        if (vVar == null && vVar2 == null) {
            return 0;
        }
        int i5 = 1;
        Rect epicenter = transition.getEpicenter();
        if (vVar2 == null || e(vVar) == 0) {
            i5 = -1;
            vVar2 = vVar;
        }
        int a2 = am.a(vVar2, 0);
        int a3 = am.a(vVar2, 1);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width2 = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i2 = epicenter.centerX();
            i3 = epicenter.centerY();
        } else {
            i2 = (round + width2) / 2;
            i3 = (round2 + height) / 2;
        }
        if (this.BH == 8388611) {
            i4 = u.Z(viewGroup) == 1 ? 5 : 3;
        } else if (this.BH == 8388613) {
            i4 = u.Z(viewGroup) == 1 ? 3 : 5;
        } else {
            i4 = this.BH;
        }
        switch (i4) {
            case 3:
                abs = (width2 - a2) + Math.abs(i3 - a3);
                break;
            case 5:
                abs = (a2 - round) + Math.abs(i3 - a3);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                abs = Math.abs(i2 - a2) + (height - a3);
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                abs = Math.abs(i2 - a2) + (a3 - round2);
                break;
            default:
                abs = 0;
                break;
        }
        float f2 = (float) abs;
        switch (this.BH) {
            case 3:
            case 5:
            case 8388611:
            case 8388613:
                width = viewGroup.getWidth();
                break;
            default:
                width = viewGroup.getHeight();
                break;
        }
        float f3 = f2 / ((float) width);
        long j2 = transition.mDuration;
        if (j2 < 0) {
            j2 = 300;
        }
        return (long) Math.round((((float) (j2 * ((long) i5))) / this.AP) * f3);
    }
}
