package com.tencent.mm.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.c;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

public final class b extends RecyclerView.a<C0288b> implements c.a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray grn;
    private final a gro;
    public final a<com.tencent.mm.chatroom.d.a> grp;
    private final Collection<com.tencent.mm.chatroom.d.a> grq;
    private final Integer grr;
    private final Integer grs;
    private final boolean grt;
    private final Context mContext;

    public static class a<K> implements Serializable {
        K first;
        K gru;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C0288b bVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(12442);
        c cVar = bVar.grv;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int intValue = (this.grr.intValue() + (i2 % 12)) % 12;
        int intValue2 = (i2 / 12) + this.calendar.get(1) + ((this.grr.intValue() + (i2 % 12)) / 12);
        if (this.grp.first != null) {
            i5 = this.grp.first.grV;
            i4 = this.grp.first.month;
            i3 = this.grp.first.year;
        } else {
            i3 = -1;
            i4 = -1;
            i5 = -1;
        }
        if (this.grp.gru != null) {
            i8 = this.grp.gru.grV;
            i7 = this.grp.gru.month;
            i6 = this.grp.gru.year;
        } else {
            i6 = -1;
            i7 = -1;
            i8 = -1;
        }
        cVar.mNumRows = 6;
        cVar.requestLayout();
        hashMap.put("selected_begin_year", Integer.valueOf(i3));
        hashMap.put("selected_last_year", Integer.valueOf(i6));
        hashMap.put("selected_begin_month", Integer.valueOf(i4));
        hashMap.put("selected_last_month", Integer.valueOf(i7));
        hashMap.put("selected_begin_day", Integer.valueOf(i5));
        hashMap.put("selected_last_day", Integer.valueOf(i8));
        hashMap.put("year", Integer.valueOf(intValue2));
        hashMap.put("month", Integer.valueOf(intValue));
        hashMap.put("week_start", Integer.valueOf(this.calendar.getFirstDayOfWeek()));
        cVar.setMarkDate(this.grq);
        cVar.setMonthParams(hashMap);
        cVar.invalidate();
        AppMethodBeat.o(12442);
    }

    public b(Context context, a aVar, TypedArray typedArray, long j2, Collection<com.tencent.mm.chatroom.d.a> collection) {
        AppMethodBeat.i(12437);
        this.grn = typedArray;
        this.grs = Integer.valueOf(typedArray.getInt(15, this.calendar.get(2) % 12));
        if (-1 != j2) {
            this.calendar.setTimeInMillis(j2);
        }
        this.grr = Integer.valueOf(typedArray.getInt(13, this.calendar.get(2)));
        this.grt = typedArray.getBoolean(16, false);
        this.grp = new a<>();
        this.grq = collection;
        this.mContext = context;
        this.gro = aVar;
        if (this.grn.getBoolean(10, false)) {
            c(new com.tencent.mm.chatroom.d.a(System.currentTimeMillis()));
        }
        AppMethodBeat.o(12437);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        return (long) i2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(12438);
        int i2 = ((new com.tencent.mm.chatroom.d.a(this.gro.alZ()).year - this.calendar.get(1)) + 1) * 12;
        if (this.grr.intValue() != -1) {
            i2 -= this.grr.intValue();
        }
        if (this.grs.intValue() != -1) {
            i2 -= (12 - this.grs.intValue()) - 1;
        }
        AppMethodBeat.o(12438);
        return i2;
    }

    /* renamed from: com.tencent.mm.chatroom.a.b$b  reason: collision with other inner class name */
    public static class C0288b extends RecyclerView.v {
        final c grv;

        public C0288b(View view, c.a aVar) {
            super(view);
            AppMethodBeat.i(12436);
            this.grv = (c) view;
            this.grv.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.grv.setClickable(true);
            this.grv.setOnDayClickListener(aVar);
            AppMethodBeat.o(12436);
        }
    }

    @Override // com.tencent.mm.chatroom.ui.c.a
    public final void b(com.tencent.mm.chatroom.d.a aVar) {
        AppMethodBeat.i(12439);
        if (aVar != null) {
            c(aVar);
        }
        AppMethodBeat.o(12439);
    }

    private void c(com.tencent.mm.chatroom.d.a aVar) {
        AppMethodBeat.i(12440);
        this.gro.a(aVar);
        d(aVar);
        AppMethodBeat.o(12440);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.tencent.mm.chatroom.d.a */
    /* JADX WARN: Multi-variable type inference failed */
    private void d(com.tencent.mm.chatroom.d.a aVar) {
        AppMethodBeat.i(12441);
        if (!this.grt) {
            this.grp.first = aVar;
        } else if (this.grp.first != null && this.grp.gru == null) {
            this.grp.gru = aVar;
            if (this.grp.first.month < aVar.month) {
                for (int i2 = 0; i2 < (this.grp.first.month - aVar.month) - 1; i2++) {
                    this.gro.a(aVar);
                }
            }
        } else if (this.grp.gru != null) {
            this.grp.first = aVar;
            this.grp.gru = null;
        } else {
            this.grp.first = aVar;
        }
        this.atj.notifyChanged();
        AppMethodBeat.o(12441);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C0288b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(12443);
        C0288b bVar = new C0288b(new c(this.mContext, this.grn), this);
        AppMethodBeat.o(12443);
        return bVar;
    }
}
