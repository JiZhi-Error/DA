package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.bizchat.b;
import com.tencent.mm.ui.conversation.m;
import com.tencent.mm.ui.s;

public final class l extends s<a> {
    private boolean Qgd = false;
    private m Qge;
    final j Qgf;
    public final b Qgg;
    private final DataSetObserver Qgh = new DataSetObserver() {
        /* class com.tencent.mm.ui.conversation.l.AnonymousClass1 */

        public final void onChanged() {
            AppMethodBeat.i(234199);
            if (l.this.Qge != null) {
                l.this.Qge.gWb();
            }
            l.this.notifyDataSetChanged();
            AppMethodBeat.o(234199);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(234200);
            if (l.this.Qge != null) {
                l.this.Qge.gWb();
            }
            l.this.notifyDataSetInvalidated();
            AppMethodBeat.o(234200);
        }
    };

    public static class a {
        int Qgj = 0;
        public com.tencent.mm.al.a.a Qgk;
        public az conversation;
        int qcr = 1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ a a(a aVar, Cursor cursor) {
        AppMethodBeat.i(234215);
        a a2 = a(aVar, cursor);
        AppMethodBeat.o(234215);
        return a2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ a getItem(int i2) {
        AppMethodBeat.i(234214);
        a anT = anT(i2);
        AppMethodBeat.o(234214);
        return anT;
    }

    public l(Context context, String str, s.a aVar) {
        super(context, new a());
        AppMethodBeat.i(234205);
        super.Bh(false);
        this.Qgf = new j(context, str, aVar);
        this.Qgf.registerDataSetObserver(this.Qgh);
        ag.bah();
        String MX = f.MX(str);
        this.Qgg = new b(context, aVar, !Util.isNullOrNil(MX) ? MX : str);
        this.Qgg.registerDataSetObserver(this.Qgh);
        b bVar = this.Qgg;
        ag.bak().add(bVar);
        ag.bak().a(bVar, bVar.wkt.getMainLooper());
        AppMethodBeat.o(234205);
    }

    @Override // com.tencent.mm.ui.s
    public final void Bh(boolean z) {
        AppMethodBeat.i(234206);
        super.Bh(false);
        AppMethodBeat.o(234206);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(234207);
        this.Qgf.anp();
        this.Qgg.anp();
        this.Qge = new m(m.e.DESC, new m.a() {
            /* class com.tencent.mm.ui.conversation.l.AnonymousClass2 */

            @Override // com.tencent.mm.ui.conversation.m.a
            public final Cursor gVZ() {
                AppMethodBeat.i(234201);
                Cursor cursor = l.this.Qgf.getCursor();
                AppMethodBeat.o(234201);
                return cursor;
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.ui.conversation.m.a
            public final m.d c(Cursor cursor, int i2) {
                AppMethodBeat.i(234202);
                m.d dVar = new m.d();
                String string = cursor.getString(b(cursor, ch.COL_USERNAME));
                dVar.QgC = cursor.getLong(b(cursor, "conversationTime"));
                if (dVar.QgC == 0) {
                    dVar.QgC = cursor.getLong(b(cursor, "flag")) & 72057594037927935L;
                }
                if (((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(string)) {
                    dVar.QgD = 1;
                } else {
                    dVar.QgD = 0;
                }
                AppMethodBeat.o(234202);
                return dVar;
            }
        }, new m.a() {
            /* class com.tencent.mm.ui.conversation.l.AnonymousClass3 */

            @Override // com.tencent.mm.ui.conversation.m.a
            public final Cursor gVZ() {
                AppMethodBeat.i(234203);
                Cursor cursor = l.this.Qgg.getCursor();
                AppMethodBeat.o(234203);
                return cursor;
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.ui.conversation.m.a
            public final m.d c(Cursor cursor, int i2) {
                AppMethodBeat.i(234204);
                m.d dVar = new m.d();
                dVar.QgC = cursor.getLong(b(cursor, "lastMsgTime"));
                if ((cursor.getLong(b(cursor, "flag")) & 4611686018427387904L) != 0) {
                    dVar.QgD = 1;
                } else {
                    dVar.QgD = 0;
                }
                AppMethodBeat.o(234204);
                return dVar;
            }
        });
        setCursor(this.Qge);
        AppMethodBeat.o(234207);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(234208);
        if (this.Qgd) {
            this.Qge = m.gWa();
            setCursor(this.Qge);
            AppMethodBeat.o(234208);
            return;
        }
        this.Qgd = true;
        anp();
        this.Qgd = false;
        AppMethodBeat.o(234208);
    }

    private a a(a aVar, Cursor cursor) {
        AppMethodBeat.i(234209);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.Qgj = this.Qge.gWc().getPosition();
        try {
            aVar.conversation = null;
            aVar.Qgk = this.Qgg.a(aVar.Qgk, cursor);
            if (aVar.Qgk.field_bizChatId > 0) {
                aVar.qcr = 0;
                AppMethodBeat.o(234209);
                return aVar;
            }
            aVar.Qgk = null;
            try {
                aVar.conversation = j.a(aVar.conversation, cursor);
                aVar.qcr = 1;
            } catch (Throwable th) {
                aVar.conversation = null;
            }
            AppMethodBeat.o(234209);
            return aVar;
        } catch (Throwable th2) {
            aVar.Qgk = null;
        }
    }

    public final a anT(int i2) {
        AppMethodBeat.i(234210);
        a aVar = (a) super.getItem(i2);
        if (aVar == null) {
            try {
                int count = this.Qgf.getCount();
                int count2 = this.Qgg.getCount();
                Log.w("MergeBizChatConversationAdapter", "getItem NULL, position=%d, size=%d, cursor.size=[%d, %d], window=[%d, %d)", Integer.valueOf(i2), Integer.valueOf(getCount()), Integer.valueOf(count), Integer.valueOf(count2), Integer.valueOf(this.Qge.Qgo), Integer.valueOf(this.Qge.Qgo + this.Qge.Qgp.size()));
                if (count > 0 && i2 < count) {
                    a aVar2 = new a();
                    try {
                        aVar2.qcr = 1;
                        aVar2.Qgj = Math.max(0, i2);
                        aVar2.conversation = (az) this.Qgf.getItem(aVar2.Qgj);
                        aVar = aVar2;
                    } catch (Throwable th) {
                        aVar = aVar2;
                    }
                }
                int i3 = i2 - count;
                if (aVar == null && count2 > 0 && i3 < count2) {
                    a aVar3 = new a();
                    try {
                        aVar3.qcr = 0;
                        aVar3.Qgj = Math.max(0, i3);
                        aVar3.Qgk = (com.tencent.mm.al.a.a) this.Qgg.getItem(aVar3.Qgj);
                        aVar = aVar3;
                    } catch (Throwable th2) {
                        aVar = aVar3;
                    }
                }
            } catch (Throwable th3) {
            }
        }
        AppMethodBeat.o(234210);
        return aVar;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2 = null;
        AppMethodBeat.i(234211);
        a anT = anT(i2);
        int i3 = anT.qcr;
        int i4 = 1;
        View view3 = view;
        while (true) {
            if (i3 == 1) {
                try {
                    View view4 = this.Qgf.getView(anT.Qgj, view3, viewGroup);
                    AppMethodBeat.o(234211);
                    return view4;
                } catch (ClassCastException e2) {
                    if (view3 == null) {
                        break;
                    }
                    view3 = view2;
                }
            } else {
                if (i3 == 0) {
                    View view5 = this.Qgg.getView(anT.Qgj, view3, viewGroup);
                    AppMethodBeat.o(234211);
                    return view5;
                }
                int i5 = i4 - 1;
                if (i4 <= 0) {
                    break;
                }
                i4 = i5;
            }
        }
        AppMethodBeat.o(234211);
        return view2;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(234212);
        a anT = anT(i2);
        if (anT == null) {
            AppMethodBeat.o(234212);
            return 0;
        }
        int i3 = anT.qcr;
        AppMethodBeat.o(234212);
        return i3;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(234213);
        if (this.Qge != null) {
            int count = this.Qge.getCount();
            AppMethodBeat.o(234213);
            return count;
        }
        int count2 = super.getCount();
        AppMethodBeat.o(234213);
        return count2;
    }
}
