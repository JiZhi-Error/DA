package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\rH\u0016J-\u0010'\u001a\u00020 2#\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cH\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001a2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\rH\u0016R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeTouchOutside", "", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "coverByKeyboard", "getCoverByKeyboard", "setCoverByKeyboard", "value", "outsideTouchable", "getOutsideTouchable", "setOutsideTouchable", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "Companion", "plugin-recordvideo_release"})
public final class EditorPanelHolder extends InsectFrameLayout {
    public static final a Cdx = new a((byte) 0);
    private View AeF;
    private kotlin.g.a.b<? super Boolean, x> Ccp;
    private boolean Cdu;
    private boolean Cdv;
    private boolean Cdw;

    static {
        AppMethodBeat.i(237733);
        AppMethodBeat.o(237733);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorPanelHolder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(237730);
        this.Cdv = true;
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder.AnonymousClass1 */
            final /* synthetic */ EditorPanelHolder Cdy;

            {
                this.Cdy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237718);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.Cdy.getCloseTouchOutside()) {
                    this.Cdy.setShow(false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237718);
            }
        });
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(237730);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorPanelHolder(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(237731);
        AppMethodBeat.o(237731);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorPanelHolder(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(237732);
        AppMethodBeat.o(237732);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean getCoverByKeyboard() {
        return this.Cdu;
    }

    public final void setCoverByKeyboard(boolean z) {
        this.Cdu = z;
    }

    public final boolean getCloseTouchOutside() {
        return this.Cdv;
    }

    public final void setCloseTouchOutside(boolean z) {
        this.Cdv = z;
    }

    public final boolean getOutsideTouchable() {
        return this.Cdw;
    }

    public final void setOutsideTouchable(boolean z) {
        AppMethodBeat.i(237723);
        this.Cdw = z;
        if (z) {
            setOnClickListener(null);
            setClickable(false);
            AppMethodBeat.o(237723);
            return;
        }
        setOnClickListener(new c(this));
        AppMethodBeat.o(237723);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ EditorPanelHolder Cdy;

        c(EditorPanelHolder editorPanelHolder) {
            this.Cdy = editorPanelHolder;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(237720);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.Cdy.getCloseTouchOutside()) {
                this.Cdy.setShow(false);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(237720);
        }
    }

    public static /* synthetic */ void a(EditorPanelHolder editorPanelHolder, View view) {
        AppMethodBeat.i(237725);
        editorPanelHolder.a(view, (ViewGroup.LayoutParams) null);
        AppMethodBeat.o(237725);
    }

    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2;
        AppMethodBeat.i(237724);
        p.h(view, "view");
        this.AeF = view;
        if (layoutParams != null) {
            layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        } else if (view.getLayoutParams() != null) {
            layoutParams2 = new FrameLayout.LayoutParams(view.getLayoutParams());
        } else {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        }
        layoutParams2.gravity = 80;
        addView(view, layoutParams2);
        AppMethodBeat.o(237724);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(237726);
        if (z) {
            setVisibility(0);
            kotlin.g.a.b<? super Boolean, x> bVar = this.Ccp;
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
            }
            View view = this.AeF;
            if (view != null) {
                view.animate().cancel();
                if (view.getHeight() == 0) {
                    view.setVisibility(4);
                    view.post(new e(view));
                    AppMethodBeat.o(237726);
                    return;
                }
                view.animate().translationY(0.0f).start();
                AppMethodBeat.o(237726);
                return;
            }
            AppMethodBeat.o(237726);
            return;
        }
        kotlin.g.a.b<? super Boolean, x> bVar2 = this.Ccp;
        if (bVar2 != null) {
            bVar2.invoke(Boolean.FALSE);
        }
        View view2 = this.AeF;
        if (view2 != null) {
            view2.animate().cancel();
            view2.animate().translationY((float) view2.getHeight()).withEndAction(new d(this)).start();
            AppMethodBeat.o(237726);
            return;
        }
        AppMethodBeat.o(237726);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ View Cdz;

        e(View view) {
            this.Cdz = view;
        }

        public final void run() {
            AppMethodBeat.i(237722);
            this.Cdz.setVisibility(0);
            this.Cdz.setTranslationY((float) this.Cdz.getHeight());
            this.Cdz.animate().translationY(0.0f).start();
            AppMethodBeat.o(237722);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$setShow$2$1"})
    public static final class d implements Runnable {
        final /* synthetic */ EditorPanelHolder Cdy;

        d(EditorPanelHolder editorPanelHolder) {
            this.Cdy = editorPanelHolder;
        }

        public final void run() {
            AppMethodBeat.i(237721);
            this.Cdy.setVisibility(8);
            AppMethodBeat.o(237721);
        }
    }

    @Override // com.tencent.mm.ui.widget.InsectFrameLayout
    public final boolean Gv(int i2) {
        AppMethodBeat.i(237727);
        if (!this.Cdu || (i2 <= 200 && i2 >= 0)) {
            View view = this.AeF;
            if (!(view == null || view.getPaddingBottom() == i2)) {
                view.post(new b(view, i2));
            }
            AppMethodBeat.o(237727);
        } else {
            AppMethodBeat.o(237727);
        }
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$insectBottom$1$1"})
    static final class b implements Runnable {
        final /* synthetic */ View Cct;
        final /* synthetic */ int Ccu;

        b(View view, int i2) {
            this.Cct = view;
            this.Ccu = i2;
        }

        public final void run() {
            AppMethodBeat.i(237719);
            this.Cct.setPadding(this.Cct.getPaddingLeft(), this.Cct.getPaddingTop(), this.Cct.getPaddingRight(), this.Ccu);
            this.Cct.requestLayout();
            AppMethodBeat.o(237719);
        }
    }

    public final boolean bJw() {
        AppMethodBeat.i(237728);
        if (getVisibility() == 0) {
            AppMethodBeat.o(237728);
            return true;
        }
        AppMethodBeat.o(237728);
        return false;
    }

    public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.Ccp = bVar;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        AppMethodBeat.i(237729);
        p.h(keyEvent, "event");
        if (keyEvent.getKeyCode() != 4) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(237729);
            return dispatchKeyEvent;
        } else if (getKeyDispatcherState() == null) {
            boolean dispatchKeyEvent2 = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(237729);
            return dispatchKeyEvent2;
        } else if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
            if (keyDispatcherState2 != null) {
                keyDispatcherState2.startTracking(keyEvent, this);
            }
            AppMethodBeat.o(237729);
            return true;
        } else if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
            boolean dispatchKeyEvent3 = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(237729);
            return dispatchKeyEvent3;
        } else {
            setShow(false);
            AppMethodBeat.o(237729);
            return true;
        }
    }
}
