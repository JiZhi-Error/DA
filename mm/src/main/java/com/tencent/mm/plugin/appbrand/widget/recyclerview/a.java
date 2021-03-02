package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.LinkedList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a extends RecyclerView.a<RecyclerView.v> {
    private static ViewGroup.LayoutParams oEc = new ViewGroup.LayoutParams(-1, -2);
    RecyclerView.a adj;
    private ViewGroup oEd;
    private ViewGroup oEe;
    List<View> oEf = new LinkedList();
    private List<View> oEg = new LinkedList();
    b oEh;
    c oEi;
    RecyclerView.c oEj = new RecyclerView.c() {
        /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.a.AnonymousClass1 */

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(131532);
            a.this.atj.notifyChanged();
            AppMethodBeat.o(131532);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            AppMethodBeat.i(131533);
            a.this.aq((a.this.oEf.isEmpty() ? 0 : 1) + i2, i3);
            AppMethodBeat.o(131533);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(131534);
            a.this.e((a.this.oEf.isEmpty() ? 0 : 1) + i2, i3, obj);
            AppMethodBeat.o(131534);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(131535);
            a.this.as((a.this.oEf.isEmpty() ? 0 : 1) + i2, i3);
            AppMethodBeat.o(131535);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(131536);
            a.this.at((a.this.oEf.isEmpty() ? 0 : 1) + i2, i3);
            AppMethodBeat.o(131536);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            int i5 = 0;
            AppMethodBeat.i(169241);
            if (i4 == 1) {
                a aVar = a.this;
                int i6 = (aVar.oEf.isEmpty() ? 0 : 1) + i2;
                if (!a.this.oEf.isEmpty()) {
                    i5 = 1;
                }
                aVar.ar(i6, i5 + i3);
                AppMethodBeat.o(169241);
                return;
            }
            a.this.atj.notifyChanged();
            AppMethodBeat.o(169241);
        }
    };

    static {
        AppMethodBeat.i(131553);
        AppMethodBeat.o(131553);
    }

    a() {
        AppMethodBeat.i(131542);
        AppMethodBeat.o(131542);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(131543);
        if (!this.oEf.isEmpty() && i2 == 0) {
            AppMethodBeat.o(131543);
            return Integer.MAX_VALUE;
        } else if (this.oEg.isEmpty() || i2 != getItemCount() - 1) {
            int itemViewType = this.adj.getItemViewType(i2 - (this.oEf.isEmpty() ? 0 : 1));
            AppMethodBeat.o(131543);
            return itemViewType;
        } else {
            AppMethodBeat.o(131543);
            return 2147483646;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        AppMethodBeat.i(131544);
        if (getItemViewType(i2) == Integer.MAX_VALUE) {
            long hashCode = (long) "MRecyclerHeaderView".hashCode();
            AppMethodBeat.o(131544);
            return hashCode;
        } else if (getItemViewType(i2) == 2147483646) {
            long hashCode2 = (long) "MRecyclerFooterView".hashCode();
            AppMethodBeat.o(131544);
            return hashCode2;
        } else if (!this.adj.atk) {
            long j2 = (long) i2;
            AppMethodBeat.o(131544);
            return j2;
        } else {
            long itemId = this.adj.getItemId(i2 - (this.oEf.isEmpty() ? 0 : 1));
            AppMethodBeat.o(131544);
            return itemId;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(131545);
        int itemCount = this.adj == null ? 0 : this.adj.getItemCount();
        if (!this.oEf.isEmpty()) {
            itemCount++;
        }
        if (!this.oEg.isEmpty()) {
            itemCount++;
        }
        AppMethodBeat.o(131545);
        return itemCount;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(final RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(131546);
        if (!this.oEf.isEmpty() && i2 == 0) {
            AppMethodBeat.o(131546);
        } else if (this.oEg.isEmpty() || i2 != getItemCount() - 1) {
            final int i3 = i2 - (this.oEf.isEmpty() ? 0 : 1);
            this.adj.a(vVar, i3);
            if (this.oEh != null) {
                vVar.aus.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.a.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(131538);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (a.this.oEh != null) {
                            a.this.oEh.Q(vVar.aus, i3);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(131538);
                    }
                });
            }
            if (this.oEi != null) {
                vVar.aus.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.a.AnonymousClass3 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(131539);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        if (a.this.oEi != null) {
                            boolean R = a.this.oEi.R(vVar.aus, i3);
                            com.tencent.mm.hellhoundlib.a.a.a(R, this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(131539);
                            return R;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(131539);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(131546);
        } else {
            AppMethodBeat.o(131546);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(final RecyclerView.v vVar, int i2, List<Object> list) {
        AppMethodBeat.i(131547);
        if (!this.oEf.isEmpty() && i2 == 0) {
            AppMethodBeat.o(131547);
        } else if (this.oEg.isEmpty() || i2 != getItemCount() - 1) {
            final int i3 = i2 - (this.oEf.isEmpty() ? 0 : 1);
            this.adj.a(vVar, i3, list);
            if (this.oEh != null) {
                vVar.aus.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.a.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(131540);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (a.this.oEh != null) {
                            a.this.oEh.Q(vVar.aus, i3);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(131540);
                    }
                });
            }
            if (this.oEi != null) {
                vVar.aus.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.widget.recyclerview.a.AnonymousClass5 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(131541);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        if (a.this.oEi != null) {
                            boolean R = a.this.oEi.R(vVar.aus, i3);
                            com.tencent.mm.hellhoundlib.a.a.a(R, this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(131541);
                            return R;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/FixedRecyclerViewAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(131541);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(131547);
        } else {
            AppMethodBeat.o(131547);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(131548);
        if (i2 == 2147483646) {
            if (this.oEd != null) {
                this.oEd.removeAllViews();
            }
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c1a, viewGroup, false);
            this.oEd = viewGroup2;
            for (View view : this.oEg) {
                viewGroup2.addView(view, oEc);
            }
            C0825a aVar = new C0825a(viewGroup2);
            AppMethodBeat.o(131548);
            return aVar;
        } else if (i2 == Integer.MAX_VALUE) {
            if (this.oEe != null) {
                this.oEe.removeAllViews();
            }
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c1a, viewGroup, false);
            this.oEe = viewGroup3;
            for (View view2 : this.oEf) {
                viewGroup3.addView(view2, oEc);
            }
            C0825a aVar2 = new C0825a(viewGroup3);
            AppMethodBeat.o(131548);
            return aVar2;
        } else {
            RecyclerView.v a2 = this.adj.a(viewGroup, i2);
            AppMethodBeat.o(131548);
            return a2;
        }
    }

    public final int cda() {
        AppMethodBeat.i(131549);
        int size = this.oEg.size();
        AppMethodBeat.o(131549);
        return size;
    }

    public final void addFooterView(View view) {
        AppMethodBeat.i(131550);
        this.oEg.add(view);
        aq(getItemCount() - 1, 1);
        AppMethodBeat.o(131550);
    }

    public final void c(int i2, View view) {
        AppMethodBeat.i(131551);
        this.oEg.add(i2, view);
        aq(getItemCount() - 1, 1);
        AppMethodBeat.o(131551);
    }

    public final void dl(View view) {
        AppMethodBeat.i(131552);
        this.oEg.remove(view);
        aq(getItemCount() - 1, 1);
        AppMethodBeat.o(131552);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recyclerview.a$a  reason: collision with other inner class name */
    static class C0825a extends RecyclerView.v {
        C0825a(View view) {
            super(view);
        }
    }
}
