package com.tencent.mm.plugin.gallery.picker.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.picker.view.TouchCoordinatorLayout;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class AppBarLayoutBehavior extends AppBarLayout.Behavior implements View.OnTouchListener {
    private View nmd;
    private Rect rect = new Rect();
    private boolean xkM = false;
    private int xkN = ((int) MMApplicationContext.getContext().getResources().getDimension(R.dimen.cn));
    private boolean xkO = true;
    private boolean xkP = false;
    private boolean xkQ = false;
    private AppBarLayout xkh;

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(164787);
        a(coordinatorLayout, (AppBarLayout) view, view2, i2, i3, i4, i5, i6);
        AppMethodBeat.o(164787);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(164786);
        a(coordinatorLayout, (AppBarLayout) view, view2, i2, i3, iArr, i4);
        AppMethodBeat.o(164786);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
        AppMethodBeat.i(164785);
        boolean b2 = b(coordinatorLayout, (AppBarLayout) view, i2);
        AppMethodBeat.o(164785);
        return b2;
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        AppMethodBeat.i(164788);
        boolean a2 = a(coordinatorLayout, (AppBarLayout) view, view2, view3, i2, i3);
        AppMethodBeat.o(164788);
        return a2;
    }

    public AppBarLayoutBehavior() {
        AppMethodBeat.i(164777);
        init();
        AppMethodBeat.o(164777);
    }

    public AppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164778);
        init();
        AppMethodBeat.o(164778);
    }

    private void init() {
        AppMethodBeat.i(164779);
        a(new AppBarLayout.Behavior.a() {
            /* class com.tencent.mm.plugin.gallery.picker.behavior.AppBarLayoutBehavior.AnonymousClass1 */

            @Override // android.support.design.widget.AppBarLayout.BaseBehavior.a
            public final boolean bS() {
                AppMethodBeat.i(164776);
                if (AppBarLayoutBehavior.this.xkP || AppBarLayoutBehavior.this.xkQ) {
                    AppMethodBeat.o(164776);
                    return true;
                }
                AppMethodBeat.o(164776);
                return false;
            }
        });
        AppMethodBeat.o(164779);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        AppMethodBeat.i(164780);
        this.xkh = appBarLayout;
        this.nmd = appBarLayout.findViewById(R.id.d7s);
        if (coordinatorLayout instanceof TouchCoordinatorLayout) {
            ((TouchCoordinatorLayout) coordinatorLayout).setTouchListener(this);
        }
        boolean b2 = super.b(coordinatorLayout, appBarLayout, i2);
        AppMethodBeat.o(164780);
        return b2;
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
        AppMethodBeat.i(164781);
        super.a(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        AppMethodBeat.o(164781);
        return true;
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(164782);
        if (i4 != 1 || !this.xkP) {
            if (this.xkM) {
                super.a(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
                if (this.xkO) {
                    if (iArr[1] == 0) {
                        super.a(coordinatorLayout, appBarLayout, view, 0, 0, 0, i3, i4);
                    }
                    iArr[1] = i3;
                }
            }
            AppMethodBeat.o(164782);
            return;
        }
        AppMethodBeat.o(164782);
    }

    @Override // android.support.design.widget.AppBarLayout.BaseBehavior, android.support.design.widget.AppBarLayout.Behavior
    public final void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(164783);
        if (i6 != 1 || !this.xkP) {
            if (this.xkM) {
                super.a(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
            }
            AppMethodBeat.o(164783);
            return;
        }
        AppMethodBeat.o(164783);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(164784);
        if (motionEvent.getAction() == 0) {
            this.xkM = false;
            this.xkQ = false;
            if (Math.abs(bT()) <= 0) {
                z = true;
            } else {
                z = false;
            }
            this.xkO = z;
            if (this.xkh.getTotalScrollRange() == Math.abs(bT())) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.xkP = z2;
            new StringBuilder("isFromSnapOfBottom=").append(this.xkO).append(" isFromSnapOfTop=").append(this.xkP);
            if (this.xkO) {
                this.nmd.getGlobalVisibleRect(this.rect);
                if (this.rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    this.xkM = true;
                    this.xkQ = true;
                }
            }
        }
        if (this.xkP) {
            this.xkM = true;
        }
        if (!this.xkM) {
            this.xkh.getGlobalVisibleRect(this.rect);
            this.rect.bottom -= this.xkN;
            if (this.rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.xkM = true;
            }
        }
        AppMethodBeat.o(164784);
        return false;
    }
}
