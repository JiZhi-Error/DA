package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.o;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.d;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.s;
import java.util.List;

public final class a extends s<f> {
    public static final ColorStateList yCN = com.tencent.mm.cb.a.m(MMApplicationContext.getContext(), R.color.a0b);
    public static final ColorStateList yCO = com.tencent.mm.cb.a.m(MMApplicationContext.getContext(), R.color.uj);
    List<String> yCP;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ f a(f fVar, Cursor cursor) {
        AppMethodBeat.i(26259);
        f a2 = a(fVar, cursor);
        AppMethodBeat.o(26259);
        return a2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ f getItem(int i2) {
        AppMethodBeat.i(26258);
        f Pu = Pu(i2);
        AppMethodBeat.o(26258);
        return Pu;
    }

    static {
        AppMethodBeat.i(26260);
        AppMethodBeat.o(26260);
    }

    public a(Context context) {
        super(context, new f());
        AppMethodBeat.i(26250);
        AppMethodBeat.o(26250);
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(26251);
        int count = super.getCount();
        AppMethodBeat.o(26251);
        return count;
    }

    public final f Pu(int i2) {
        f fVar;
        AppMethodBeat.i(26252);
        if (Ox(i2)) {
            f fVar2 = (f) dWw();
            AppMethodBeat.o(26252);
            return fVar2;
        } else if (this.OFH != null && (fVar = (f) this.OFH.get(Integer.valueOf(i2))) != null) {
            AppMethodBeat.o(26252);
            return fVar;
        } else if (i2 < 0 || !getCursor().moveToPosition(i2)) {
            AppMethodBeat.o(26252);
            return null;
        } else {
            f a2 = a((f) null, getCursor());
            if (this.OFH == null) {
                Bh(true);
            }
            if (this.OFH != null) {
                this.OFH.put(Integer.valueOf(i2), a2);
            }
            AppMethodBeat.o(26252);
            return a2;
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        C1456a aVar;
        c cVar;
        CharSequence charSequence;
        AppMethodBeat.i(26253);
        as asVar = Pu(i2).contact;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, R.layout.y1, null);
            C1456a aVar2 = new C1456a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (C1456a) view.getTag();
        }
        AddressView addressView = aVar.yCS;
        String str = asVar.field_username;
        float f2 = com.tencent.mm.pluginsdk.ui.a.ppN;
        Drawable drawable = addressView.getDrawable();
        if (drawable == null || !(drawable instanceof c)) {
            cVar = new c(str, f2);
        } else {
            cVar = (c) drawable;
        }
        cVar.setTag(str);
        addressView.setImageDrawable(cVar);
        addressView.doInvalidate();
        if (asVar.field_verifyFlag != 0) {
            String rW = ay.a.iDs.rW(asVar.field_verifyFlag);
            if (rW != null) {
                aVar.yCS.setMaskBitmap(o.Nw(rW));
            } else {
                aVar.yCS.setMaskBitmap(null);
            }
        } else {
            aVar.yCS.setMaskBitmap(null);
        }
        if (asVar.field_deleteFlag == 1) {
            aVar.yCS.setNickNameTextColor(yCO);
        } else {
            aVar.yCS.setNickNameTextColor(yCN);
        }
        aVar.yCS.updateTextColors();
        aVar.yCS.setMergeCallback(null);
        CharSequence charSequence2 = asVar.NON;
        if (charSequence2 == null) {
            try {
                Context context = this.context;
                String displayName = aa.getDisplayName(asVar.field_username);
                if ("".length() > 0 && !"".equals(displayName)) {
                    StringBuilder sb = new StringBuilder(32);
                    sb.append(displayName);
                    sb.append("(");
                    sb.append("");
                    sb.append(")");
                    displayName = sb.toString();
                }
                charSequence = l.b(context, displayName, aVar.yCS.getNickNameSize());
            } catch (Exception e2) {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.yCS.setName(charSequence);
            asVar.NON = charSequence;
        } else {
            aVar.yCS.setName(charSequence2);
        }
        aVar.yCS.updatePositionFlag();
        AppMethodBeat.o(26253);
        return view;
    }

    @Override // com.tencent.mm.ui.s
    public final synchronized void anp() {
        final Cursor gFu;
        AppMethodBeat.i(26254);
        boolean z = Looper.myLooper() == Looper.getMainLooper();
        if (this.yCP == null || this.yCP.size() <= 0) {
            gFu = d.gFu();
        } else {
            bg.aVF();
            gFu = com.tencent.mm.model.c.aSN().iL(this.yCP);
        }
        if (z) {
            j(gFu);
            AppMethodBeat.o(26254);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.label.ui.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(26248);
                    a.this.j(gFu);
                    AppMethodBeat.o(26248);
                }
            });
            AppMethodBeat.o(26254);
        }
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(26255);
        anp();
        AppMethodBeat.o(26255);
    }

    private static f a(f fVar, Cursor cursor) {
        AppMethodBeat.i(26256);
        if (fVar == null) {
            fVar = new f();
        }
        bg.aVF();
        as bjF = com.tencent.mm.model.c.aSN().bjF(as.p(cursor));
        if (bjF == null) {
            fVar.contact.convertFrom(cursor);
            bg.aVF();
            com.tencent.mm.model.c.aSN().am(fVar.contact);
        } else {
            fVar.contact = bjF;
        }
        AppMethodBeat.o(26256);
        return fVar;
    }

    public final void j(Cursor cursor) {
        AppMethodBeat.i(26257);
        ebf();
        setCursor(cursor);
        notifyDataSetChanged();
        AppMethodBeat.o(26257);
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.a$a  reason: collision with other inner class name */
    protected static class C1456a {
        public AddressView yCS;

        public C1456a(View view) {
            AppMethodBeat.i(26249);
            this.yCS = (AddressView) view.findViewById(R.id.ft6);
            AppMethodBeat.o(26249);
        }
    }
}
