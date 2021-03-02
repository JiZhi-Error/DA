package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.a.f;
import com.tencent.mm.ui.contact.OpenIMAddressUI;
import com.tencent.mm.ui.contact.a;
import java.util.HashSet;
import java.util.LinkedList;

public final class x extends a {
    private HashSet<String> PYd = new HashSet<>();
    private String PYe;
    OpenIMAddressUI.OpenIMAddressUIFragment PYf;

    public x(Context context, String str, String str2) {
        super(context, str, null, 2);
        AppMethodBeat.i(37919);
        this.PYe = str2;
        AppMethodBeat.o(37919);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.a
    public final Cursor gUm() {
        AppMethodBeat.i(37920);
        long currentTimeMillis = System.currentTimeMillis();
        g.aAi();
        d appIdInfoStg = ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg();
        String str = this.PYe;
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = appIdInfoStg.iFy.rawQuery("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[]{str}, 2);
        if (rawQuery.moveToFirst()) {
            do {
                String string = rawQuery.getString(0);
                if (!Util.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        bg.aVF();
        Cursor a2 = c.aSN().a(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), linkedList);
        if (a2 instanceof f) {
            a2 = new e(new com.tencent.mm.storagebase.a.d[]{(com.tencent.mm.storagebase.a.d) com.tencent.mm.storagebase.d.gFu(), (f) a2});
        }
        Log.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(37920);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.a
    public final int a(com.tencent.mm.storage.f fVar, int i2) {
        AppMethodBeat.i(37921);
        if (fVar == null) {
            Log.e("OpenIMContactAdapter", "contact is null, position:%d", Integer.valueOf(i2));
            AppMethodBeat.o(37921);
            return -1;
        } else if (Util.isNullOrNil(fVar.field_descWording)) {
            AppMethodBeat.o(37921);
            return -1;
        } else {
            int hashCode = fVar.field_descWording.hashCode();
            AppMethodBeat.o(37921);
            return hashCode;
        }
    }

    @Override // com.tencent.mm.ui.contact.a, com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(37925);
        if (obj == null || !(obj instanceof String)) {
            Log.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(37925);
            return;
        }
        bg.aVF();
        if (mStorageEx == c.aSN()) {
            if (as.bjp((String) obj)) {
                this.PYf.PTd = true;
                AppMethodBeat.o(37925);
                return;
            }
            Log.d("OpenIMContactAdapter", "newcursor is not openim ，return");
        }
        AppMethodBeat.o(37925);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.a
    public final String b(com.tencent.mm.storage.f fVar, int i2) {
        AppMethodBeat.i(37922);
        String str = fVar.field_descWording;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(37922);
            return "#";
        }
        AppMethodBeat.o(37922);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.a
    public final void b(com.tencent.mm.storage.f fVar, a.b bVar) {
        CharSequence charSequence;
        AppMethodBeat.i(37923);
        CharSequence charSequence2 = fVar.NON;
        if (charSequence2 == null) {
            try {
                if (as.bjp(fVar.field_username)) {
                    charSequence = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), fVar.arJ(), com.tencent.mm.cb.a.aG(this.context, R.dimen.is));
                } else {
                    charSequence = l.e(this.context, (CharSequence) bnp(getDisplayName(fVar.arJ(), fVar.field_username)), com.tencent.mm.cb.a.aG(this.context, R.dimen.is));
                }
            } catch (Exception e2) {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            bVar.PSD.setText(charSequence);
            AppMethodBeat.o(37923);
            return;
        }
        bVar.PSD.setText(charSequence2);
        AppMethodBeat.o(37923);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.a
    public final void a(com.tencent.mm.storage.f fVar, a.b bVar) {
        AppMethodBeat.i(37924);
        String str = fVar.field_descWordingId;
        if (this.PYd.contains(str)) {
            AppMethodBeat.o(37924);
            return;
        }
        this.PYd.add(str);
        ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(fVar.field_openImAppid, str);
        AppMethodBeat.o(37924);
    }
}
