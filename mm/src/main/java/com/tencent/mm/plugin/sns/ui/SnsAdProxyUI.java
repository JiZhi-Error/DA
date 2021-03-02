package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.n;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class SnsAdProxyUI extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98450);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.SnsAdBlankUI", "intent null!");
            finish();
            AppMethodBeat.o(98450);
            return;
        }
        int intExtra = intent.getIntExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, -1);
        Log.i("MicroMsg.SnsAdBlankUI", "action=".concat(String.valueOf(intExtra)));
        if (intExtra < 0) {
            finish();
            AppMethodBeat.o(98450);
            return;
        }
        if (intExtra == 1) {
            cr crVar = new cr();
            crVar.dFK.activity = this;
            crVar.dFK.dDX = intent.getStringExtra("qrcodeStr");
            crVar.dFK.dFL = intent.getIntExtra("qrcodeType", 0);
            crVar.dFK.dFM = intent.getIntExtra("qrcodeVer", 0);
            EventCenter.instance.publish(crVar);
        } else if (intExtra == 2) {
            String stringExtra = intent.getStringExtra(ch.COL_USERNAME);
            String stringExtra2 = intent.getStringExtra("url");
            String stringExtra3 = intent.getStringExtra("sceneNote");
            wq wqVar = new wq();
            wqVar.ecI.userName = stringExtra;
            wqVar.ecI.ecK = stringExtra2;
            wqVar.ecI.scene = 1084;
            wqVar.ecI.dCw = stringExtra3;
            wqVar.ecI.context = this;
            EventCenter.instance.publish(wqVar);
        } else if (intExtra == 3) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("searchContactResponseByte");
            String nullAsNil = Util.nullAsNil(intent.getStringExtra("searchWord"));
            try {
                drt drt = new drt();
                drt.parseFrom(byteArrayExtra);
                Log.i("MicroMsg.SnsAdBlankUI", "doOpenProfile, query=" + nullAsNil + ", count=" + drt.LUB);
                if (drt.LUB > 0) {
                    if (drt.LUC.isEmpty()) {
                        h.a((Context) this, (int) R.string.gfw, 0, true, (DialogInterface.OnClickListener) null);
                    } else {
                        Intent intent2 = new Intent();
                        ((n) g.af(n.class)).a(intent2, drt.LUC.getFirst(), 182);
                        c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    }
                } else if (Util.nullAsNil(z.a(drt.Lqk)).length() > 0) {
                    Intent intent3 = new Intent();
                    ((n) g.af(n.class)).a(intent3, drt, 182);
                    intent3.putExtra("Contact_Scene", 182);
                    intent3.putExtra("add_more_friend_search_scene", 2);
                    c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.SnsAdBlankUI", "parse GetWXUserNameResp exp=" + th.toString());
            }
        }
        finish();
        AppMethodBeat.o(98450);
    }
}
