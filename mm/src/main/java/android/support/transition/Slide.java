package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.a.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator AQ = new DecelerateInterpolator();
    private static final TimeInterpolator AR = new AccelerateInterpolator();
    private static final a BK = new b() {
        /* class android.support.transition.Slide.AnonymousClass1 */

        @Override // android.support.transition.Slide.a
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a BL = new b() {
        /* class android.support.transition.Slide.AnonymousClass2 */

        @Override // android.support.transition.Slide.a
        public final float b(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (u.Z(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a BM = new c() {
        /* class android.support.transition.Slide.AnonymousClass3 */

        @Override // android.support.transition.Slide.a
        public final float c(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final a BN = new b() {
        /* class android.support.transition.Slide.AnonymousClass4 */

        @Override // android.support.transition.Slide.a
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a BO = new b() {
        /* class android.support.transition.Slide.AnonymousClass5 */

        @Override // android.support.transition.Slide.a
        public final float b(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (u.Z(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a BP = new c() {
        /* class android.support.transition.Slide.AnonymousClass6 */

        @Override // android.support.transition.Slide.a
        public final float c(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };
    private a BI = BP;
    private int BJ = 80;

    /* access modifiers changed from: package-private */
    public interface a {
        float b(ViewGroup viewGroup, View view);

        float c(ViewGroup viewGroup, View view);
    }

    static abstract class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // android.support.transition.Slide.a
        public final float c(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    static abstract class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        @Override // android.support.transition.Slide.a
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        setSlideEdge(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BX);
        int a2 = g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(a2);
    }

    private static void c(v vVar) {
        int[] iArr = new int[2];
        vVar.view.getLocationOnScreen(iArr);
        vVar.values.put("android:slide:screenPosition", iArr);
    }

    @Override // android.support.transition.Transition, android.support.transition.Visibility
    public final void a(v vVar) {
        super.a(vVar);
        c(vVar);
    }

    @Override // android.support.transition.Transition, android.support.transition.Visibility
    public final void b(v vVar) {
        super.b(vVar);
        c(vVar);
    }

    private void setSlideEdge(int i2) {
        switch (i2) {
            case 3:
                this.BI = BK;
                break;
            case 5:
                this.BI = BN;
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                this.BI = BM;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                this.BI = BP;
                break;
            case 8388611:
                this.BI = BL;
                break;
            case 8388613:
                this.BI = BO;
                break;
            default:
                throw new IllegalArgumentException("Invalid slide direction");
        }
        this.BJ = i2;
        o oVar = new o();
        oVar.BH = i2;
        a(oVar);
    }

    @Override // android.support.transition.Visibility
    public final Animator a(ViewGroup viewGroup, View view, v vVar, v vVar2) {
        if (vVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) vVar2.values.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return x.a(view, vVar2, iArr[0], iArr[1], this.BI.b(viewGroup, view), this.BI.c(viewGroup, view), translationX, translationY, AQ);
    }

    @Override // android.support.transition.Visibility
    public final Animator a(ViewGroup viewGroup, View view, v vVar) {
        if (vVar == null) {
            return null;
        }
        int[] iArr = (int[]) vVar.values.get("android:slide:screenPosition");
        return x.a(view, vVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.BI.b(viewGroup, view), this.BI.c(viewGroup, view), AR);
    }
}
