package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.LinkedList;

@a(gRF = ad.class)
public class ak extends a implements ad {
    @Override // com.tencent.mm.ui.chatting.d.b.ad
    public final boolean bU(ca caVar) {
        AppMethodBeat.i(35467);
        if (caVar.dOS()) {
            com.tencent.mm.ui.chatting.ak.bL(caVar);
            this.dom.BN(true);
            AppMethodBeat.o(35467);
            return true;
        }
        AppMethodBeat.o(35467);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ad
    public final void gQI() {
        final boolean z;
        AppMethodBeat.i(35468);
        final boolean z2 = (as.bjp(this.dom.getTalkerUserName()) || ab.Iy(this.dom.GUe.field_username)) ? (((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).RZ(this.dom.GUe.field_openImAppid) & 4096) == 0 : false;
        if (!ab.IB(this.dom.GUe.field_username) || (z.aUT() & 8) == 0) {
            z = false;
        } else {
            z = true;
        }
        e eVar = new e((Context) this.dom.Pwc.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.d.ak.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(35463);
                if (z) {
                    mVar.d(1, ak.this.dom.Pwc.getMMResources().getString(R.string.el2));
                    mVar.d(2, ak.this.dom.Pwc.getMMResources().getString(R.string.el3));
                    AppMethodBeat.o(35463);
                } else if (!ak.a(ak.this) || z2) {
                    mVar.d(1, ak.this.dom.Pwc.getMMResources().getString(R.string.el2));
                    AppMethodBeat.o(35463);
                } else {
                    mVar.d(1, ak.this.dom.Pwc.getMMResources().getString(R.string.el2));
                    mVar.d(2, ak.this.dom.Pwc.getMMResources().getString(R.string.el3));
                    AppMethodBeat.o(35463);
                }
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.ui.chatting.d.ak.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                boolean z;
                boolean z2;
                AppMethodBeat.i(35464);
                switch (menuItem.getItemId()) {
                    case 1:
                        if (b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                            if (!com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_FINE_LOCATION") || !com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                    com.tencent.mm.plugin.account.a.b.a.b(ak.this.dom.Pwc.getContext(), ak.this.dom.Pwc.getMMResources().getString(R.string.el_, LocaleUtil.getApplicationLanguage()), 30763, true);
                                    AppMethodBeat.o(35464);
                                    return;
                                }
                                com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 67);
                                AppMethodBeat.o(35464);
                                return;
                            }
                        } else {
                            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 67, (String) null, (String) null);
                            Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                            if (!a2) {
                                AppMethodBeat.o(35464);
                                return;
                            }
                        }
                        ak.this.gQJ();
                        AppMethodBeat.o(35464);
                        return;
                    case 2:
                        if (b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                            if (!com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_FINE_LOCATION") || !com.tencent.mm.pluginsdk.permission.b.n(ak.this.dom.Pwc.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                    com.tencent.mm.plugin.account.a.b.a.b(ak.this.dom.Pwc.getContext(), ak.this.dom.Pwc.getMMResources().getString(R.string.el_, LocaleUtil.getApplicationLanguage()), 30762, true);
                                    AppMethodBeat.o(35464);
                                    return;
                                }
                                com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 68);
                                AppMethodBeat.o(35464);
                                return;
                            }
                        } else {
                            boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(ak.this.dom.Pwc.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 68, (String) null, (String) null);
                            Log.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a3));
                            if (!a3) {
                                AppMethodBeat.o(35464);
                                return;
                            }
                        }
                        ak.this.gQK();
                        break;
                }
                AppMethodBeat.o(35464);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(35468);
    }

    public final void gQJ() {
        AppMethodBeat.i(35469);
        h.INSTANCE.a(12809, 1, "");
        Intent intent = new Intent();
        if (this.dom.gRM()) {
            intent.putExtra("type_tag", 2);
        } else {
            intent.putExtra("type_tag", 1);
        }
        intent.putExtra("map_view_type", 0);
        intent.putExtra("map_sender_name", this.dom.gRI());
        intent.putExtra("map_talker_name", this.dom.getTalkerUserName());
        c.b(this.dom.Pwc.getContext(), FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(35469);
    }

    public final void gQK() {
        LinkedList<String> PY;
        AppMethodBeat.i(35470);
        if (!com.tencent.mm.q.a.cC(this.dom.Pwc.getContext()) && !com.tencent.mm.q.a.cA(this.dom.Pwc.getContext()) && !com.tencent.mm.q.a.cE(this.dom.Pwc.getContext())) {
            if (((d) g.af(d.class)).aFH(this.dom.getTalkerUserName())) {
                Log.i("MicroMsg.ChattingUI.LocationComponent", "click share location, but now is in multitalk!");
                com.tencent.mm.ui.base.h.n(this.dom.Pwc.getContext(), R.string.f64, R.string.zb);
                AppMethodBeat.o(35470);
                return;
            }
            if (!Util.isNullOrNil((String) null)) {
                boolean z = false;
                if (com.tencent.mm.bi.d.jpA != null && com.tencent.mm.bi.d.jpA.PZ(this.dom.GUe.field_username) && (PY = com.tencent.mm.bi.d.jpA.PY(this.dom.GUe.field_username)) != null && PY.contains(this.dom.gRI())) {
                    z = true;
                }
                if (!z) {
                    d.a aVar = new d.a(this.dom.Pwc.getContext());
                    aVar.boo(null);
                    aVar.aoV(R.string.e2u).c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.ak.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35465);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(35465);
                        }
                    });
                    aVar.hbn().show();
                    AppMethodBeat.o(35470);
                    return;
                }
            }
            ((com.tencent.mm.ui.chatting.d.b.as) this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class)).bmP("fromPluginLocation");
        }
        AppMethodBeat.o(35470);
    }

    @Override // com.tencent.mm.ui.l
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(35471);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        switch (i2) {
            case 67:
            case 68:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.fl_), this.dom.Pwc.getMMResources().getString(R.string.flp), this.dom.Pwc.getMMResources().getString(R.string.e_k), this.dom.Pwc.getMMResources().getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.ak.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35466);
                            BaseChattingUIFragment baseChattingUIFragment = ak.this.dom.Pwc;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/LocationComponent$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(35466);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else if (i2 == 67) {
                    gQJ();
                    AppMethodBeat.o(35471);
                    return;
                } else {
                    gQK();
                    AppMethodBeat.o(35471);
                    return;
                }
                break;
        }
        AppMethodBeat.o(35471);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35472);
        super.gOK();
        ly lyVar = new ly();
        lyVar.dRv.dRq = 2;
        EventCenter.instance.publish(lyVar);
        AppMethodBeat.o(35472);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35474);
        EventCenter.instance.publish(new by());
        AppMethodBeat.o(35474);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35473);
        ly lyVar = new ly();
        lyVar.dRv.dRq = 0;
        lyVar.dRv.language = LocaleUtil.getApplicationLanguage();
        if (ab.Eq(this.dom.GUe.field_username)) {
            lyVar.dRv.dRx = true;
        } else {
            lyVar.dRv.dRx = false;
        }
        EventCenter.instance.publish(lyVar);
        AppMethodBeat.o(35473);
    }

    static /* synthetic */ boolean a(ak akVar) {
        AppMethodBeat.i(35475);
        if (akVar.dom.GUe.gBM() || ab.Jz(akVar.dom.getTalkerUserName()) || as.bjm(akVar.dom.getTalkerUserName()) || as.bjo(akVar.dom.getTalkerUserName()) || as.IG(akVar.dom.getTalkerUserName()) || akVar.dom.getTalkerUserName().equals(z.aTY())) {
            AppMethodBeat.o(35475);
            return false;
        }
        AppMethodBeat.o(35475);
        return true;
    }
}
