package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends s<az> {
    private ColorStateList[] Pav = new ColorStateList[2];
    private HashMap<String, C2135a> Pax;
    private b QBc;
    private boolean QbL = true;
    protected List<String> gzY = null;
    private String kdi;
    private com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(new b.a() {
        /* class com.tencent.mm.ui.voicesearch.a.AnonymousClass1 */

        @Override // com.tencent.mm.ui.applet.b.a
        public final Bitmap Ta(String str) {
            AppMethodBeat.i(39511);
            Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
            AppMethodBeat.o(39511);
            return a2;
        }
    });
    private b.AbstractC2078b kez = null;

    public interface b {
    }

    public static class c {
        public ImageView PaH;
        public ImageView PaI;
        public ImageView gvv;
        public TextView gvw;
        public TextView pld;
        public TextView ple;
        public TextView plf;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(39522);
        az azVar2 = azVar;
        if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
            if (azVar2 == null) {
                azVar2 = new az();
            }
            azVar2.convertFrom(cursor);
            AppMethodBeat.o(39522);
        } else if (cursor.getString(0).equals("2")) {
            bg.aVF();
            as bjF = com.tencent.mm.model.c.aSN().bjF(as.p(cursor));
            if (bjF == null) {
                bjF = new as();
                bjF.convertFrom(cursor);
                bg.aVF();
                com.tencent.mm.model.c.aSN().am(bjF);
            }
            if (azVar2 == null) {
                azVar2 = new az();
            }
            azVar2.setStatus(2);
            azVar2.yA(-1);
            azVar2.nv(1);
            azVar2.setContent(this.context.getString(R.string.dj5));
            azVar2.setUsername(bjF.field_username);
            azVar2.nt(0);
            azVar2.Cl(Integer.toString(1));
            AppMethodBeat.o(39522);
        } else {
            if (azVar2 == null) {
                azVar2 = new az();
            }
            azVar2.convertFrom(cursor);
            AppMethodBeat.o(39522);
        }
        return azVar2;
    }

    public a(Context context, s.a aVar) {
        super(context, new az());
        AppMethodBeat.i(39514);
        super.a(aVar);
        this.Pav[0] = com.tencent.mm.cb.a.m(context, R.color.a0f);
        this.Pav[1] = com.tencent.mm.cb.a.m(context, R.color.a0g);
        this.Pax = new HashMap<>();
        AppMethodBeat.o(39514);
    }

    public final void jB(List<String> list) {
        AppMethodBeat.i(39515);
        this.gzY = list;
        onNotifyChange(null, null);
        AppMethodBeat.o(39515);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(39516);
        anp();
        AppMethodBeat.o(39516);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(39517);
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = bg.aVF().iBo.a(ab.iCF, this.gzY, this.kdi);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.gzY != null && this.gzY.size() > 0) {
            arrayList.addAll(this.gzY);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex(ch.COL_USERNAME));
                arrayList.add(string);
                if (!ab.Eq(string)) {
                    arrayList2.add(string);
                }
                Log.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(string)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SearchConversationAdapter", e2, "", new Object[0]);
            }
        }
        cursorArr[1] = bg.aVF().iBp.a(this.kdi, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.QBc == null || this.kdi == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(39517);
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
        // Method dump skipped, instructions count: 1024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.voicesearch.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private static int ahn(String str) {
        int i2 = 1;
        AppMethodBeat.i(39519);
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(39519);
        return i2;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(39520);
        if (str != null && !str.equals("") && this.Pax != null) {
            this.Pax.remove(str);
        } else if (this.Pax != null) {
            this.Pax.clear();
        }
        super.onNotifyChange(str, mStorageEventData);
        AppMethodBeat.o(39520);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.voicesearch.a$a  reason: collision with other inner class name */
    public class C2135a {
        public CharSequence Qcd;
        public CharSequence Qce;
        public int Qcf;
        public CharSequence nickName;

        private C2135a() {
        }

        /* synthetic */ C2135a(a aVar, byte b2) {
            this();
        }
    }

    public final void SM(String str) {
        AppMethodBeat.i(39521);
        this.kdi = str;
        ebf();
        anp();
        AppMethodBeat.o(39521);
    }
}
