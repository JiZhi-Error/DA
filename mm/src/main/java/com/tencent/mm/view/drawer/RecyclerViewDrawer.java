package com.tencent.mm.view.drawer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0015J\u0012\u00109\u001a\u0002042\b\b\u0002\u0010:\u001a\u00020\u0015H\u0016J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0016J\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u0006\u0010C\u001a\u00020AJ\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020\u0015J\b\u0010G\u001a\u000204H\u0016J\u0018\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020\u0015H\u0017J\u0010\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020\u0013H\u0016J\u001c\u0010M\u001a\u0002042\b\b\u0002\u0010:\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\u0015H\u0016R$\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R$\u00100\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011¨\u0006O"}, hxF = {"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer extends InsectFrameLayout implements RecyclerViewDrawerSquares.c {
    public static final a Roh = new a((byte) 0);
    private final RecyclerViewDrawerSquares RnY = new RecyclerViewDrawerSquares(getContext());
    private boolean RnZ = true;
    private int Roa = R.color.ad;
    private int Rob = R.color.afz;
    private g Roc;
    private final int Rod;
    private RecyclerViewDrawerSquares.c Roe;
    protected boolean Rof;
    private boolean Rog;
    private float aTE;
    private float dep;
    private final Rect rect;
    private int topOffset = ((int) getResources().getDimension(R.dimen.c_));

    static {
        AppMethodBeat.i(164669);
        AppMethodBeat.o(164669);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewDrawer(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164666);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.Rod = viewConfiguration.getScaledTouchSlop();
        setBackgroundResource(this.Roa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        setPadding(0, this.topOffset, 0, 0);
        this.RnY.setBackgroundResource(this.Rob);
        addView(this.RnY, layoutParams);
        setVisibility(8);
        this.RnY.setOnOpenDrawerListener(this);
        this.rect = new Rect();
        AppMethodBeat.o(164666);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164667);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.Rod = viewConfiguration.getScaledTouchSlop();
        setBackgroundResource(this.Roa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        setPadding(0, this.topOffset, 0, 0);
        this.RnY.setBackgroundResource(this.Rob);
        addView(this.RnY, layoutParams);
        setVisibility(8);
        this.RnY.setOnOpenDrawerListener(this);
        this.rect = new Rect();
        AppMethodBeat.o(164667);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewDrawer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164668);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.Rod = viewConfiguration.getScaledTouchSlop();
        setBackgroundResource(this.Roa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        setPadding(0, this.topOffset, 0, 0);
        this.RnY.setBackgroundResource(this.Rob);
        addView(this.RnY, layoutParams);
        setVisibility(8);
        this.RnY.setOnOpenDrawerListener(this);
        this.rect = new Rect();
        AppMethodBeat.o(164668);
    }

    public final void setEnableClickBackgroundToCloseDrawer(boolean z) {
        this.RnZ = z;
    }

    public final int getTopOffset() {
        return this.topOffset;
    }

    public final void setTopOffset(int i2) {
        AppMethodBeat.i(164650);
        this.topOffset = i2;
        setPadding(0, this.topOffset, 0, 0);
        AppMethodBeat.o(164650);
    }

    public final int getBackgroundColorRes() {
        return this.Roa;
    }

    public final void setBackgroundColorRes(int i2) {
        AppMethodBeat.i(164651);
        this.Roa = i2;
        setBackgroundResource(i2);
        AppMethodBeat.o(164651);
    }

    public final int getSquaresBackgroundResource() {
        return this.Rob;
    }

    public final void setSquaresBackgroundResource(int i2) {
        AppMethodBeat.i(164652);
        this.Rob = i2;
        this.RnY.setBackgroundResource(i2);
        AppMethodBeat.o(164652);
    }

    public final g getKeyboardHeightObserver() {
        return this.Roc;
    }

    public final void setKeyboardHeightObserver(g gVar) {
        AppMethodBeat.i(164653);
        this.Roc = gVar;
        this.RnY.setKeyboardHeightObserver(this.Roc);
        AppMethodBeat.o(164653);
    }

    public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener() {
        return this.Roe;
    }

    public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c cVar) {
        this.Roe = cVar;
    }

    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(164654);
        RecyclerView recyclerView = this.RnY.getCenterLayout().getRecyclerView();
        AppMethodBeat.o(164654);
        return recyclerView;
    }

    public final RefreshLoadMoreLayout getCenterLayout() {
        AppMethodBeat.i(164655);
        RefreshLoadMoreLayout centerLayout = this.RnY.getCenterLayout();
        AppMethodBeat.o(164655);
        return centerLayout;
    }

    public final FrameLayout getFooterLayout() {
        AppMethodBeat.i(164656);
        FrameLayout drawerFooterLayout = this.RnY.getDrawerFooterLayout();
        AppMethodBeat.o(164656);
        return drawerFooterLayout;
    }

    public final FrameLayout getHeaderLayout() {
        AppMethodBeat.i(164657);
        FrameLayout drawerHeaderLayout = this.RnY.getDrawerHeaderLayout();
        AppMethodBeat.o(164657);
        return drawerHeaderLayout;
    }

    public final FrameLayout getLoadingLayout() {
        AppMethodBeat.i(164658);
        FrameLayout loadingLayout = this.RnY.getLoadingLayout();
        AppMethodBeat.o(164658);
        return loadingLayout;
    }

    public final void hH(View view) {
        AppMethodBeat.i(205017);
        p.h(view, "view");
        if (!this.RnY.getIgnoreInterceptViewList().contains(view)) {
            this.RnY.getIgnoreInterceptViewList().add(view);
        }
        AppMethodBeat.o(205017);
    }

    public final void bi(boolean z, boolean z2) {
        AppMethodBeat.i(205018);
        this.RnY.bi(z, z2);
        AppMethodBeat.o(205018);
    }

    public final void hge() {
        AppMethodBeat.i(164660);
        this.RnY.setCanCloseDrawerWhenStop(true);
        AppMethodBeat.o(164660);
    }

    public final void DG(boolean z) {
        AppMethodBeat.i(164661);
        this.RnY.DG(z);
        AppMethodBeat.o(164661);
    }

    public final boolean dGs() {
        AppMethodBeat.i(164662);
        if (getVisibility() == 0) {
            AppMethodBeat.o(164662);
            return true;
        }
        AppMethodBeat.o(164662);
        return false;
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void S(boolean z, boolean z2) {
        AppMethodBeat.i(164663);
        new StringBuilder("[onDrawerOpen] isOpen=").append(z).append(" isBegin=").append(z2);
        if (z2 && z) {
            setVisibility(0);
        } else if (!z2 && !z) {
            setVisibility(4);
            getCenterLayout().reset();
        }
        RecyclerViewDrawerSquares.c cVar = this.Roe;
        if (cVar != null) {
            cVar.S(z, z2);
            AppMethodBeat.o(164663);
            return;
        }
        AppMethodBeat.o(164663);
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void bo(float f2) {
        AppMethodBeat.i(164664);
        Drawable background = getBackground();
        if (background != null) {
            background.setAlpha((int) (255.0f * (1.0f - f2)));
        }
        RecyclerViewDrawerSquares.c cVar = this.Roe;
        if (cVar != null) {
            cVar.bo(f2);
            AppMethodBeat.o(164664);
            return;
        }
        AppMethodBeat.o(164664);
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void dHu() {
        AppMethodBeat.i(205019);
        RecyclerViewDrawerSquares.c cVar = this.Roe;
        if (cVar != null) {
            cVar.dHu();
            AppMethodBeat.o(205019);
            return;
        }
        AppMethodBeat.o(205019);
    }

    /* access modifiers changed from: protected */
    public final void setIntercept(boolean z) {
        this.Rof = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164665);
        p.h(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            this.rect.setEmpty();
            this.RnY.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
            this.Rof = this.rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (this.Rof) {
                Rect rect2 = new Rect();
                for (View view : this.RnY.getIgnoreInterceptViewList()) {
                    view.getGlobalVisibleRect(rect2);
                    this.Rof = !rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (!this.Rof) {
                        break;
                    }
                }
            }
            this.aTE = motionEvent.getY();
            this.dep = this.aTE;
            if (!this.Rof && this.RnZ) {
                this.RnY.getGlobalVisibleRect(this.rect);
                if (!this.rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.Rog = true;
                }
            }
        }
        if (this.Rof) {
            this.RnY.u((int) (this.aTE - motionEvent.getY()), 0, true);
            this.aTE = motionEvent.getY();
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.Rof) {
                this.RnY.ddr();
            }
            this.Rof = false;
            if (this.Rog && this.RnZ && motionEvent.getAction() == 1 && Math.abs(this.dep - motionEvent.getY()) <= ((float) this.Rod)) {
                RecyclerViewDrawerSquares.a(this.RnY);
            }
            this.Rog = false;
        }
        if (this.Rof || this.Rog || super.dispatchTouchEvent(motionEvent)) {
            AppMethodBeat.o(164665);
            return true;
        }
        AppMethodBeat.o(164665);
        return false;
    }
}
