package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.tools.MMTextInputUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.tools.MMTextInputUI
    public int getLayoutId() {
        return R.layout.a74;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.tools.MMTextInputUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106933);
        customfixStatusbar(true);
        super.onCreate(bundle);
        setMMTitle(R.string.c9u);
        AppMethodBeat.o(106933);
    }

    @Override // com.tencent.mm.ui.tools.MMTextInputUI
    public final void O(CharSequence charSequence) {
        AppMethodBeat.i(106934);
        if (charSequence == null || Util.isNullOrNil(charSequence.toString())) {
            Log.w("MicroMsg.FavTextEditUI", "text is null");
            AppMethodBeat.o(106934);
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            Log.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", Integer.valueOf(intExtra));
            AppMethodBeat.o(106934);
            return;
        }
        LinkedList linkedList = new LinkedList();
        cps cps = new cps();
        cps.MvI = 4;
        cps.MvJ = 0;
        linkedList.add(cps);
        LinkedList linkedList2 = new LinkedList();
        cpv cpv = new cpv();
        cpv.xMo = "favitem.desc";
        cpv.Cyk = Util.nullAs(charSequence2, "");
        linkedList2.add(cpv);
        cpv cpv2 = new cpv();
        cpv2.xMo = "favitem.edittime";
        cpv2.Cyk = String.valueOf(Util.nowSecond());
        linkedList2.add(cpv2);
        g DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) intExtra);
        if (DZ != null) {
            DZ.field_edittime = Util.nowSecond();
            DZ.field_favProto.Mz(DZ.field_edittime);
            DZ.field_favProto.bhe(Util.nullAs(charSequence2, ""));
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
        }
        com.tencent.mm.kernel.g.azz().a(new am(intExtra, linkedList, linkedList2), 0);
        h.INSTANCE.a(10874, 1);
        AppMethodBeat.o(106934);
    }
}
