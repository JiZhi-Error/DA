package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016J0\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "libmmui_release"})
public class InsectFrameLayout extends FrameLayout {
    private int[] QBW;
    private b<? super Integer, Boolean> QBX;
    private final String TAG;
    private Rect vPN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsectFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(204862);
        this.TAG = "MicroMsg.InsectLayout";
        this.vPN = new Rect();
        this.QBW = new int[2];
        AppMethodBeat.o(204862);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InsectFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(204863);
        AppMethodBeat.o(204863);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InsectFrameLayout(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(204864);
        AppMethodBeat.o(204864);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, java.lang.Boolean>, kotlin.g.a.b<java.lang.Integer, java.lang.Boolean> */
    public final b<Integer, Boolean> getInsectCallback() {
        return this.QBX;
    }

    public final void setInsectCallback(b<? super Integer, Boolean> bVar) {
        this.QBX = bVar;
    }

    public boolean Gv(int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(204861);
        getWindowVisibleDisplayFrame(this.vPN);
        getLocationOnScreen(this.QBW);
        int i6 = ((i5 - i3) + this.QBW[1]) - this.vPN.bottom;
        boolean Gv = Gv(i6);
        if (!Gv && this.QBX != null) {
            b<? super Integer, Boolean> bVar = this.QBX;
            if (bVar == null) {
                p.hyc();
            }
            Gv = bVar.invoke(Integer.valueOf(i6)).booleanValue();
        }
        Log.d(this.TAG, "InsectFrameLayout onLayout. handled=" + Gv + " bottom=" + i5);
        if (!Gv && getPaddingBottom() != i6) {
            post(new a(this, i6));
        }
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(204861);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ InsectFrameLayout QBY;
        final /* synthetic */ int QBZ;

        a(InsectFrameLayout insectFrameLayout, int i2) {
            this.QBY = insectFrameLayout;
            this.QBZ = i2;
        }

        public final void run() {
            AppMethodBeat.i(204860);
            Log.i(this.QBY.TAG, "InsectFrameLayout onLayout. bottomInsect=" + this.QBZ);
            this.QBY.setPadding(this.QBY.getPaddingLeft(), this.QBY.getPaddingTop(), this.QBY.getPaddingRight(), this.QBZ);
            this.QBY.requestLayout();
            AppMethodBeat.o(204860);
        }
    }
}