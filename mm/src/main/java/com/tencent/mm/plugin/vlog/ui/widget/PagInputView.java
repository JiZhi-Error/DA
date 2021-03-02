package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\tH\u0016J\u0006\u0010#\u001a\u00020\u0015J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0015H\u0002J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0015J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020 R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014j\u0004\u0018\u0001`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "doneView", "inputView", "Landroid/widget/EditText;", "lastBottom", "showImeRunnable", "Ljava/lang/Runnable;", "textChangeCallback", "Lkotlin/Function1;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/widget/ChangeTextCallback;", "getTextChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "waitKeyBoardShown", "cancel", "confirm", "getResult", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setShow", "show", "setup", "text", "plugin-vlog_release"})
public final class PagInputView extends InsectRelativeLayout {
    private final View GQo;
    private final View GQp;
    private final EditText GQq;
    private b<? super Boolean, x> GQr;
    private int ruG;
    private boolean ruH;
    private final Runnable ruJ;

    public static final /* synthetic */ void a(PagInputView pagInputView, boolean z) {
        AppMethodBeat.i(192198);
        pagInputView.setImeVisibility(z);
        AppMethodBeat.o(192198);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192196);
        View.inflate(context, R.layout.a12, this);
        setBackgroundResource(R.color.aa5);
        View findViewById = findViewById(R.id.bvu);
        p.g(findViewById, "findViewById(R.id.edit_input_close)");
        this.GQo = findViewById;
        View findViewById2 = findViewById(R.id.bvv);
        p.g(findViewById2, "findViewById(R.id.edit_input_done)");
        this.GQp = findViewById2;
        View findViewById3 = findViewById(R.id.bw5);
        p.g(findViewById3, "findViewById(R.id.edit_text_input)");
        this.GQq = (EditText) findViewById3;
        this.GQq.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.widget.PagInputView.AnonymousClass1 */
            final /* synthetic */ PagInputView GQs;

            {
                this.GQs = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(192186);
                PagInputView.a(this.GQs, z);
                AppMethodBeat.o(192186);
            }
        });
        this.GQo.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.widget.PagInputView.AnonymousClass2 */
            final /* synthetic */ PagInputView GQs;

            {
                this.GQs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(192187);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                PagInputView.a(this.GQs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(192187);
            }
        });
        this.GQp.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.widget.PagInputView.AnonymousClass3 */
            final /* synthetic */ PagInputView GQs;

            {
                this.GQs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(192188);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                PagInputView.b(this.GQs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(192188);
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.widget.PagInputView.AnonymousClass4 */
            final /* synthetic */ PagInputView GQs;

            {
                this.GQs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(192189);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.GQs.GQq.requestFocus();
                PagInputView.a(this.GQs, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(192189);
            }
        });
        this.ruJ = new a(this);
        AppMethodBeat.o(192196);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PagInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(192197);
        AppMethodBeat.o(192197);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final b<Boolean, x> getTextChangeCallback() {
        return this.GQr;
    }

    public final void setTextChangeCallback(b<? super Boolean, x> bVar) {
        this.GQr = bVar;
    }

    public final void setup(String str) {
        AppMethodBeat.i(192191);
        p.h(str, "text");
        this.GQq.setText(str);
        this.GQq.setSelection(0, str.length());
        AppMethodBeat.o(192191);
    }

    public final String getResult() {
        AppMethodBeat.i(192192);
        String obj = this.GQq.getText().toString();
        AppMethodBeat.o(192192);
        return obj;
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(192193);
        if (z) {
            setVisibility(0);
            setPadding(0, 0, 0, this.ruG);
            this.GQq.requestFocus();
            AppMethodBeat.o(192193);
            return;
        }
        this.GQq.clearFocus();
        this.ruH = true;
        setVisibility(8);
        AppMethodBeat.o(192193);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ PagInputView GQs;

        a(PagInputView pagInputView) {
            this.GQs = pagInputView;
        }

        public final void run() {
            AppMethodBeat.i(192190);
            InputMethodManager inputMethodManager = (InputMethodManager) this.GQs.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.GQs.GQq, 0);
                AppMethodBeat.o(192190);
                return;
            }
            AppMethodBeat.o(192190);
        }
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(192194);
        if (z) {
            post(this.ruJ);
            AppMethodBeat.o(192194);
            return;
        }
        removeCallbacks(this.ruJ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(192194);
            return;
        }
        AppMethodBeat.o(192194);
    }

    @Override // com.tencent.mm.ui.widget.InsectRelativeLayout
    public final boolean Gv(int i2) {
        AppMethodBeat.i(192195);
        this.ruG = i2;
        boolean z = i2 > au.aD(getContext());
        if (!this.ruH) {
            AppMethodBeat.o(192195);
            return false;
        } else if (z) {
            this.ruH = false;
            AppMethodBeat.o(192195);
            return false;
        } else {
            AppMethodBeat.o(192195);
            return true;
        }
    }

    public static final /* synthetic */ void a(PagInputView pagInputView) {
        AppMethodBeat.i(192199);
        b<? super Boolean, x> bVar = pagInputView.GQr;
        if (bVar != null) {
            bVar.invoke(Boolean.FALSE);
            AppMethodBeat.o(192199);
            return;
        }
        AppMethodBeat.o(192199);
    }

    public static final /* synthetic */ void b(PagInputView pagInputView) {
        AppMethodBeat.i(192200);
        b<? super Boolean, x> bVar = pagInputView.GQr;
        if (bVar != null) {
            bVar.invoke(Boolean.TRUE);
            AppMethodBeat.o(192200);
            return;
        }
        AppMethodBeat.o(192200);
    }
}
