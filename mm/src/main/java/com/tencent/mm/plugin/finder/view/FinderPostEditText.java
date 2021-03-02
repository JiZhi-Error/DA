package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RL\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastSelection", "getLastSelection", "()I", "setLastSelection", "(I)V", "onSelectionChangedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cur", "last", "", "getOnSelectionChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionChanged", "selStart", "selEnd", "plugin-finder_release"})
public final class FinderPostEditText extends MMEditText {
    private final String TAG = "Finder.FinderPostEditText";
    private int wom;
    private m<? super Integer, ? super Integer, x> won;

    public FinderPostEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FinderPostEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final int getLastSelection() {
        return this.wom;
    }

    public final void setLastSelection(int i2) {
        this.wom = i2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Integer, kotlin.x>, kotlin.g.a.m<java.lang.Integer, java.lang.Integer, kotlin.x> */
    public final m<Integer, Integer, x> getOnSelectionChangedListener() {
        return this.won;
    }

    public final void setOnSelectionChangedListener(m<? super Integer, ? super Integer, x> mVar) {
        this.won = mVar;
    }

    /* access modifiers changed from: protected */
    public final void onSelectionChanged(int i2, int i3) {
        AppMethodBeat.i(168379);
        super.onSelectionChanged(i2, i3);
        Log.i(this.TAG, "onSelectionChanged start " + i2 + ", end " + i3);
        if (this.wom != i2) {
            m<? super Integer, ? super Integer, x> mVar = this.won;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(i2), Integer.valueOf(this.wom));
            }
            this.wom = i2;
        }
        AppMethodBeat.o(168379);
    }
}
