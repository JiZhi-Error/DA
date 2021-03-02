package com.tencent.mm.plugin.sns.ui.a;

import android.database.Cursor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.j.n;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a extends q {
    private List<n> ESn;
    public View.OnClickListener ESo;
    private List<String> dataList;
    private Cursor jWh;

    public a(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this(mMBaseSelectContactUI, (byte) 0);
    }

    private a(MMBaseSelectContactUI mMBaseSelectContactUI, byte b2) {
        super(mMBaseSelectContactUI, null, true, true);
        AppMethodBeat.i(99808);
        this.jWh = null;
        this.ESn = null;
        this.dataList = new ArrayList();
        this.ESo = null;
        Log.i("MicroMsg.SnsChatRoomAdapter", "create!");
        and();
        AppMethodBeat.o(99808);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.tencent.mm.ui.contact.a.h */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.tencent.mm.ui.contact.a.h */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        as asVar;
        com.tencent.mm.plugin.sns.ui.a.a.a aVar;
        AppMethodBeat.i(99809);
        String str = this.dataList.get(i2);
        if (Util.isEqual(str, "recent_use")) {
            h hVar = new h(i2);
            hVar.header = this.PWg.getActivity().getResources().getString(R.string.h7s);
            aVar = hVar;
        } else if (Util.isEqual(str, "recent")) {
            h hVar2 = new h(i2);
            hVar2.header = this.PWg.getActivity().getResources().getString(R.string.h7r);
            aVar = hVar2;
        } else {
            g.aAi();
            as bjF = ((l) g.af(l.class)).aSN().bjF(str);
            if (bjF == null) {
                g.aAi();
                asVar = ((l) g.af(l.class)).aSN().bjK(str);
            } else {
                asVar = bjF;
            }
            com.tencent.mm.plugin.sns.ui.a.a.a aVar2 = new com.tencent.mm.plugin.sns.ui.a.a.a(i2);
            aVar2.ESo = this.ESo;
            aVar2.contact = asVar;
            aVar2.PWh = eWh();
            aVar = aVar2;
        }
        AppMethodBeat.o(99809);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(99810);
        Log.i("MicroMsg.SnsChatRoomAdapter", "resetData");
        this.ESn = aj.faK().DOH.DSf;
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        this.jWh = ((l) g.af(l.class)).aST().b(ab.iCM, this.gzY, com.tencent.mm.o.a.gNj, this.PWC, "");
        clearCache();
        if (!Util.isNullOrNil(this.ESn)) {
            for (n nVar : this.ESn) {
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(nVar.name);
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    this.dataList.add(nVar.name);
                }
            }
        }
        if (!Util.isNullOrNil(this.dataList)) {
            this.dataList.add(0, "recent_use");
            this.dataList.add("recent");
        } else {
            this.dataList.add(0, "recent");
        }
        while (this.jWh.moveToNext()) {
            String string = this.jWh.getString(this.jWh.getColumnIndex(ch.COL_USERNAME));
            if (!this.dataList.contains(string)) {
                this.dataList.add(string);
            }
        }
        AppMethodBeat.o(99810);
    }

    public final int getCount() {
        AppMethodBeat.i(99811);
        int size = this.dataList.size();
        AppMethodBeat.o(99811);
        return size;
    }
}
