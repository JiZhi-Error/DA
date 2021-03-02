package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.g;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\rH\u0016J\u0006\u0010'\u001a\u00020$R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoTLFooterLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasNavigationBar", "", "isShowKeyboard", "()Z", "setShowKeyboard", "(Z)V", "listenKeyBoardChange", "getListenKeyBoardChange", "setListenKeyBoardChange", "marginBottomOffset", "getMarginBottomOffset", "()I", "marginBottomOffset$delegate", "Lkotlin/Lazy;", "nestedAnimButton", "Landroid/view/View;", "getNestedAnimButton", "()Landroid/view/View;", "setNestedAnimButton", "(Landroid/view/View;)V", "nestedAnimVideoView", "getNestedAnimVideoView", "setNestedAnimVideoView", "onKeyboardHeightChanged", "", "height", "isResized", "reset", "Companion", "plugin-finder_release"})
public final class MegaVideoTLFooterLayout extends LinearLayout implements g {
    public static final a uMJ = new a((byte) 0);
    private boolean uMD;
    private final f uME = kotlin.g.ah(new b(this));
    private final boolean uMF = au.aA(getContext());
    public boolean uMG;
    public View uMH;
    public View uMI;

    static {
        AppMethodBeat.i(248607);
        AppMethodBeat.o(248607);
    }

    private final int getMarginBottomOffset() {
        AppMethodBeat.i(248603);
        int intValue = ((Number) this.uME.getValue()).intValue();
        AppMethodBeat.o(248603);
        return intValue;
    }

    public MegaVideoTLFooterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(248605);
        AppMethodBeat.o(248605);
    }

    public MegaVideoTLFooterLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(248606);
        AppMethodBeat.o(248606);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoTLFooterLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setShowKeyboard(boolean z) {
        this.uMD = z;
    }

    public final boolean getListenKeyBoardChange() {
        return this.uMG;
    }

    public final void setListenKeyBoardChange(boolean z) {
        this.uMG = z;
    }

    public final View getNestedAnimVideoView() {
        return this.uMH;
    }

    public final void setNestedAnimVideoView(View view) {
        this.uMH = view;
    }

    public final View getNestedAnimButton() {
        return this.uMI;
    }

    public final void setNestedAnimButton(View view) {
        this.uMI = view;
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator translationY;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator translationY2;
        ViewPropertyAnimator scaleX;
        ViewPropertyAnimator scaleY;
        boolean z2;
        int i3;
        float f2;
        View view;
        ViewPropertyAnimator animate3;
        ViewPropertyAnimator duration3;
        ViewPropertyAnimator translationY3;
        ViewPropertyAnimator duration4;
        ViewPropertyAnimator translationY4;
        ViewPropertyAnimator scaleX2;
        ViewPropertyAnimator scaleY2;
        boolean z3 = true;
        AppMethodBeat.i(248604);
        if (!this.uMG) {
            Log.i("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: listenKeyBoardChange = " + this.uMG);
            AppMethodBeat.o(248604);
            return;
        }
        boolean z4 = i2 > 0;
        if (this.uMD != z4) {
            this.uMD = z4;
            if (z4 && Float.compare(getTranslationY(), 0.0f) == 0) {
                if (this.uMF) {
                    i2 += au.aD(getContext());
                }
                int marginBottomOffset = i2 - getMarginBottomOffset();
                animate().setDuration(90).translationY(-((float) marginBottomOffset)).start();
                Log.i("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: footer translateY = ".concat(String.valueOf(marginBottomOffset)));
                View view2 = this.uMH;
                if (view2 != null) {
                    Point az = ao.az(getContext());
                    if (az.x == 0 || az.y == 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        i3 = az.y;
                    } else {
                        Context context = getContext();
                        p.g(context, "context");
                        Resources resources = context.getResources();
                        p.g(resources, "context.resources");
                        i3 = resources.getDisplayMetrics().heightPixels;
                    }
                    int i4 = i3 - i2;
                    int[] iArr = new int[2];
                    view2.getLocationInWindow(iArr);
                    int height = view2.getHeight();
                    if (height > i4) {
                        f2 = ((float) i4) / ((float) height);
                        height = i4;
                    } else {
                        f2 = 1.0f;
                    }
                    int i5 = ((i4 - height) / 2) - iArr[1];
                    view2.setPivotY(0.0f);
                    ViewPropertyAnimator animate4 = view2.animate();
                    if (!(animate4 == null || (duration4 = animate4.setDuration(90)) == null || (translationY4 = duration4.translationY((float) i5)) == null || (scaleX2 = translationY4.scaleX(f2)) == null || (scaleY2 = scaleX2.scaleY(f2)) == null)) {
                        scaleY2.start();
                    }
                    View view3 = this.uMI;
                    if (view3 != null) {
                        if (view3.getVisibility() != 0) {
                            z3 = false;
                        }
                        if (z3) {
                            view = view3;
                        } else {
                            view = null;
                        }
                        if (!(view == null || (animate3 = view.animate()) == null || (duration3 = animate3.setDuration(90)) == null || (translationY3 = duration3.translationY((float) i5)) == null)) {
                            translationY3.start();
                        }
                    }
                    Log.e("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: video view translateY = " + i5 + ", scale = " + f2);
                    AppMethodBeat.o(248604);
                    return;
                }
                AppMethodBeat.o(248604);
                return;
            } else if (!z4 && Float.compare(getTranslationY(), 0.0f) != 0) {
                Log.i("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: return to original");
                animate().setDuration(180).translationY(0.0f).start();
                View view4 = this.uMH;
                if (!(view4 == null || (animate2 = view4.animate()) == null || (duration2 = animate2.setDuration(180)) == null || (translationY2 = duration2.translationY(0.0f)) == null || (scaleX = translationY2.scaleX(1.0f)) == null || (scaleY = scaleX.scaleY(1.0f)) == null)) {
                    scaleY.start();
                }
                View view5 = this.uMI;
                if (view5 != null) {
                    if (Float.compare(view5.getTranslationY(), 0.0f) == 0) {
                        z3 = false;
                    }
                    if (!z3) {
                        view5 = null;
                    }
                    if (!(view5 == null || (animate = view5.animate()) == null || (duration = animate.setDuration(180)) == null || (translationY = duration.translationY(0.0f)) == null)) {
                        translationY.start();
                        AppMethodBeat.o(248604);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(248604);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ MegaVideoTLFooterLayout uMK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MegaVideoTLFooterLayout megaVideoTLFooterLayout) {
            super(0);
            this.uMK = megaVideoTLFooterLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(248602);
            Context context = this.uMK.getContext();
            p.g(context, "context");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelOffset(R.dimen.a5a));
            AppMethodBeat.o(248602);
            return valueOf;
        }
    }
}
