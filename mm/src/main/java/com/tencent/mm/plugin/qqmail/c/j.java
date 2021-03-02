package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.al;
import com.tencent.mm.plugin.qqmail.d.ba;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.LinkedList;

public class j implements i, b<IPCVoid, Bundle> {
    private long Bra;
    private ArrayList<Bundle> Brb = new ArrayList<>();
    private ArrayList<Bundle> Brc = new ArrayList<>();
    private d<Bundle> hny;
    private ArrayList<Bundle> yBN = new ArrayList<>();

    public j() {
        AppMethodBeat.i(198589);
        AppMethodBeat.o(198589);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(198590);
        Log.i("MicroMsg.SyncMailAddrTask", "search mail, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (((e) qVar).Btx != this.Bra) {
            Log.w("MicroMsg.SyncMailAddrTask", "not my scene, ignore");
            AppMethodBeat.o(198590);
            return;
        }
        if (i2 == 0 && i3 == 0) {
            LinkedList<al> linkedList = ((ba) ((e) qVar).iUB.iLL.iLR).Btp;
            if (!linkedList.isEmpty()) {
                for (al alVar : linkedList) {
                    Bundle bundle = new Bundle();
                    bundle.putString(FirebaseAnalytics.b.ITEM_NAME, alVar.nickname);
                    bundle.putString("item_addr", alVar.BsK);
                    this.yBN.add(bundle);
                }
            }
            LinkedList<al> linkedList2 = ((ba) ((e) qVar).iUB.iLL.iLR).Btq;
            if (!linkedList2.isEmpty()) {
                for (al alVar2 : linkedList2) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(FirebaseAnalytics.b.ITEM_NAME, alVar2.nickname);
                    bundle2.putString("item_addr", alVar2.BsK);
                    this.Brb.add(bundle2);
                }
            }
            LinkedList<al> linkedList3 = ((ba) ((e) qVar).iUB.iLL.iLR).Btr;
            if (!linkedList3.isEmpty()) {
                for (al alVar3 : linkedList3) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(FirebaseAnalytics.b.ITEM_NAME, alVar3.nickname);
                    bundle3.putString("item_addr", alVar3.BsK);
                    this.Brc.add(bundle3);
                }
            }
            if (((ba) ((e) qVar).iUB.iLL.iLR).Btt) {
                this.Bra = ((ba) ((e) qVar).iUB.iLL.iLR).Bts;
                g.azz().a(new e(this.Bra), 0);
                AppMethodBeat.o(198590);
                return;
            }
        }
        Bundle bundle4 = new Bundle();
        bundle4.putInt("err_type", i2);
        bundle4.putInt("err_code", i3);
        bundle4.putString("err_msg", str);
        bundle4.putParcelableArrayList("sync_add_list", this.yBN);
        bundle4.putParcelableArrayList("sync_update_list", this.Brb);
        bundle4.putParcelableArrayList("sync_delete_list", this.Brc);
        bundle4.putLong("last_sync_key", this.Bra);
        if (this.hny != null) {
            this.hny.bn(bundle4);
        }
        AppMethodBeat.o(198590);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCVoid iPCVoid, d<Bundle> dVar) {
        AppMethodBeat.i(198591);
        this.hny = dVar;
        this.Bra = g.aAh().azQ().a(ar.a.USERINFO_XMAIL_SYNC_CONTACT_KEY_LONG_SYNC, 0);
        g.azz().a(new e(this.Bra), 0);
        g.azz().a(14418, this);
        AppMethodBeat.o(198591);
    }
}
