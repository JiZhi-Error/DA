package com.tencent.mm.ui.base.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T, V extends View> extends RecyclerView.a<b> {
    public AbstractC2080a OXb = null;
    public List<T> cvc = new ArrayList();
    private RecyclerView hak;

    /* renamed from: com.tencent.mm.ui.base.a.a$a  reason: collision with other inner class name */
    public interface AbstractC2080a<T> {
        void a(int i2, View view, T t);

        boolean a(View view, T t);
    }

    /* access modifiers changed from: protected */
    public abstract V l(ViewGroup viewGroup, int i2);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public /* bridge */ /* synthetic */ void a(b bVar, int i2, List list) {
        a(bVar, i2, (List<Object>) list);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void b(RecyclerView recyclerView) {
        super.b(recyclerView);
        this.hak = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        return this.cvc.size();
    }

    public void a(b bVar, int i2, List<Object> list) {
        super.a((RecyclerView.v) bVar, i2, list);
        bVar.hak = this.hak;
    }

    public final void setItems(List<T> list) {
        if (list != null) {
            this.cvc = list;
            this.atj.notifyChanged();
        }
    }

    public final void je(List<T> list) {
        if (list != null) {
            int size = this.cvc.size();
            this.cvc.addAll(list);
            as(size, list.size());
        }
    }

    public final void p(T t, int i2) {
        if (t != null) {
            this.cvc.add(i2, t);
            cj(i2);
        }
    }

    public final void alC(int i2) {
        this.cvc.add(i2, this.cvc.get(0));
        cj(i2);
    }

    public final void removeItem(int i2) {
        if (i2 > 0 || i2 < this.cvc.size()) {
            this.cvc.remove(i2);
            ck(i2);
        }
    }

    public final void clearItems() {
        int size = this.cvc.size();
        this.cvc.clear();
        at(0, size);
    }

    public final T getItemAtPosition(int i2) {
        return this.cvc.get(i2);
    }

    public void a(final b bVar, final int i2) {
        bVar.aus.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.a.a.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.tencent.mm.ui.base.a.a$a */
            /* JADX WARN: Multi-variable type inference failed */
            public final void onClick(View view) {
                AppMethodBeat.i(164160);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.OXb != null) {
                    int lR = ((b) ((RecyclerView) bVar.aus.getParent()).bu(bVar.aus)).lR();
                    if (lR < 0) {
                        Log.e("MicroMsg.RecyclerViewAdapterBase", "[onBindViewHolder#setOnClickListener] pos=%s", Integer.valueOf(lR));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(164160);
                        return;
                    }
                    a.this.OXb.a(lR, view, a.this.getItemAtPosition(lR));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(164160);
            }
        });
        bVar.aus.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.base.a.a.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.tencent.mm.ui.base.a.a$a */
            /* JADX WARN: Multi-variable type inference failed */
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(164161);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (a.this.OXb != null) {
                    boolean a2 = a.this.OXb.a(view, a.this.getItemAtPosition(i2));
                    com.tencent.mm.hellhoundlib.a.a.a(a2, this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(164161);
                    return a2;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(164161);
                return false;
            }
        });
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        b bVar = new b(l(viewGroup, i2));
        bVar.hak = this.hak;
        return bVar;
    }
}
