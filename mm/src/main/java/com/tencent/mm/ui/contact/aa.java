package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class aa extends q implements MStorageEx.IOnStorageChange {
    private HashMap<String, Integer> PTD = null;
    private SparseArray<String> PTE = null;
    private a PYl;
    private final String dNI;
    private Cursor jWh;

    public static class a {
    }

    public aa(String str, MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z) {
        super((n) mMBaseSelectContactUI, list, false, z, false);
        AppMethodBeat.i(37935);
        this.dNI = str;
        this.PYl = new a();
        ((l) g.af(l.class)).aSN().add(this);
        and();
        AppMethodBeat.o(37935);
    }

    private static ArrayList<as> bny(String str) {
        AppMethodBeat.i(37936);
        bg.aVF();
        Cursor bjI = c.aSN().bjI(str);
        ArrayList<as> arrayList = new ArrayList<>();
        if (bjI.moveToFirst()) {
            do {
                as asVar = new as();
                asVar.convertFrom(bjI);
                arrayList.add(asVar);
            } while (bjI.moveToNext());
        }
        bjI.close();
        AppMethodBeat.o(37936);
        return arrayList;
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(37937);
        if (this.PTD != null) {
            this.PTD.clear();
        } else {
            this.PTD = new HashMap<>();
        }
        if (this.PTE != null) {
            this.PTE.clear();
        } else {
            this.PTE = new SparseArray<>();
        }
        ArrayList arrayList = new ArrayList();
        List<String> Sd = ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().Sd(this.dNI);
        bg.aVF();
        arrayList.add(c.aSN().a(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Sd));
        bny("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId  and OpenIMWordingInfo.language='zh_CN'  where (type & 1!=0) and type & 32=0   and type & 8=0 and username like '%@openim' and username != 'appbrandcustomerservicemsg' and username != 'notifymessage' and username != 'weibo' and username != 'pc_share' and username != 'officialaccounts' and username != 'voicevoipapp' and username != 'cardpackage' and username != 'qqfriend' and username != 'helper_entry' and username != 'medianote' and username != 'shakeapp' and username != 'topstoryapp' and username != 'qmessage' and username != 'voipapp' and username != 'qqsync' and username != 'qqmail' and username != 'blogapp' and username != 'lbsapp' and username != 'readerapp' and username != 'feedsapp' and username != 'newsapp' and username != 'floatbottle' and username != 'fmessage' and username != 'tmessage' and username != 'weixin' and username != 'facebookapp' and username != 'meishiapp' and username != 'masssendapp' and username != 'voiceinputapp' and username != 'filehelper' and username != 'linkedinplugin' group by rcontact.openImAppid");
        bg.aVF();
        Cursor b2 = c.aSN().b(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Sd);
        int[] iArr = new int[b2.getCount()];
        if (b2.moveToFirst()) {
            int i2 = 0;
            do {
                iArr[i2] = b2.getInt(0);
                i2++;
            } while (b2.moveToNext());
        }
        b2.close();
        bg.aVF();
        Cursor c2 = c.aSN().c(this.gzY, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Sd);
        if (c2.moveToFirst()) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                as asVar = new as();
                asVar.convertFrom(c2);
                dm(i4, ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(this.dNI, asVar.field_descWordingId));
                i4 = iArr[i3] + i4 + 1;
                int i5 = i3 + 1;
                if (!c2.moveToNext()) {
                    break;
                }
                i3 = i5;
            }
        }
        c2.close();
        Log.d("MicroMsg.OpenIMSelectContactAdapter", "headerPosMap=%s", this.PTD.toString());
        this.jWh = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
        AppMethodBeat.o(37937);
    }

    private void dm(int i2, String str) {
        AppMethodBeat.i(37938);
        this.PTD.put(str, Integer.valueOf(i2));
        this.PTE.put(i2, str);
        AppMethodBeat.o(37938);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final int bnr(String str) {
        AppMethodBeat.i(37939);
        if (str.equals("↑")) {
            AppMethodBeat.o(37939);
            return 0;
        } else if (this.PTD == null) {
            AppMethodBeat.o(37939);
            return -1;
        } else if (this.PTD.containsKey(str)) {
            int intValue = this.PTD.get(str).intValue() + this.PWg.getContentLV().getHeaderViewsCount();
            AppMethodBeat.o(37939);
            return intValue;
        } else {
            AppMethodBeat.o(37939);
            return -1;
        }
    }

    public final int getCount() {
        AppMethodBeat.i(37940);
        int count = this.jWh.getCount() + this.PTD.size();
        AppMethodBeat.o(37940);
        return count;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(37941);
        if (this.PTE.indexOfKey(i2) >= 0) {
            h hVar = new h(i2);
            hVar.header = this.PTE.get(i2);
            AppMethodBeat.o(37941);
            return hVar;
        }
        int i3 = 0;
        int i4 = i2;
        while (i3 <= this.PTE.size()) {
            if (this.PTE.indexOfKey(i4) >= 0) {
                i3++;
            }
            i4--;
            if (i4 < 0) {
                break;
            }
        }
        int i5 = i2 - i3;
        if (this.jWh.moveToPosition(i5)) {
            Log.d("MicroMsg.OpenIMSelectContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
            as asVar = new as();
            asVar.convertFrom(this.jWh);
            e eVar = new e(i2);
            eVar.contact = asVar;
            eVar.PWh = eWh();
            eVar.PWi = this.PWi;
            eVar.Qao = true;
            AppMethodBeat.o(37941);
            return eVar;
        }
        Log.i("MicroMsg.OpenIMSelectContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i2), Integer.valueOf(i5));
        AppMethodBeat.o(37941);
        return null;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(37942);
        super.finish();
        Log.i("MicroMsg.OpenIMSelectContactAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        ((l) g.af(l.class)).aSN().remove(this);
        AppMethodBeat.o(37942);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(37943);
        and();
        notifyDataSetChanged();
        AppMethodBeat.o(37943);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(37944);
        if (this.PTE.indexOfKey(aVar.position + 1) >= 0) {
            AppMethodBeat.o(37944);
            return true;
        }
        AppMethodBeat.o(37944);
        return false;
    }
}
