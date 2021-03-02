package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.a.a;
import com.tencent.mm.chatroom.a.b;
import com.tencent.mm.chatroom.ui.a;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray grn;
    private a gro;
    protected b guT;
    protected int guU;
    protected long guV;
    protected int guW;
    private RecyclerView.l guX;
    private Collection<com.tencent.mm.chatroom.d.a> guY;
    private long guZ;
    protected Context mContext;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(12625);
        this.guU = 0;
        this.guW = 0;
        this.guZ = -1;
        if (!isInEditMode()) {
            this.grn = context.obtainStyledAttributes(attributeSet, a.C0292a.DayPickerView);
            setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            setLayoutManager(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            setOnScrollListener(this.guX);
            setFadingEdgeLength(0);
            this.guX = new RecyclerView.l() {
                /* class com.tencent.mm.chatroom.ui.DayPickerView.AnonymousClass1 */

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    AppMethodBeat.i(194116);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                    super.onScrollStateChanged(recyclerView, i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                    AppMethodBeat.o(194116);
                }

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    AppMethodBeat.i(12624);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    bVar.pH(i3);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                    super.onScrolled(recyclerView, i2, i3);
                    if (((c) recyclerView.getChildAt(0)) == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                        AppMethodBeat.o(12624);
                        return;
                    }
                    DayPickerView.this.guV = (long) i3;
                    DayPickerView.this.guW = DayPickerView.this.guU;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                    AppMethodBeat.o(12624);
                }
            };
        }
        AppMethodBeat.o(12625);
    }

    public final void a(com.tencent.mm.chatroom.a.a aVar, Collection<com.tencent.mm.chatroom.d.a> collection) {
        AppMethodBeat.i(12626);
        this.guY = collection;
        this.gro = aVar;
        setUpAdapter(collection);
        setAdapter(this.guT);
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(this.guT.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(this, a2.axQ(), "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
        scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
        this.guT.atj.notifyChanged();
        AppMethodBeat.o(12626);
    }

    public void setBeginDate(long j2) {
        this.guZ = j2;
    }

    /* access modifiers changed from: protected */
    public void setUpAdapter(Collection<com.tencent.mm.chatroom.d.a> collection) {
        AppMethodBeat.i(12627);
        if (this.guT == null) {
            this.guT = new b(getContext(), this.gro, this.grn, this.guZ, collection);
        }
        AppMethodBeat.o(12627);
    }

    public b.a<com.tencent.mm.chatroom.d.a> getSelectedDays() {
        return this.guT.grp;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.chatroom.a.a getController() {
        return this.gro;
    }

    /* access modifiers changed from: protected */
    public TypedArray getTypedArray() {
        return this.grn;
    }
}
