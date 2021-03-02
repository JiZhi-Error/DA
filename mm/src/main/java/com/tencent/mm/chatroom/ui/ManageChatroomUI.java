package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.vending.c.a;

public class ManageChatroomUI extends MMPreference {
    CheckBoxPreference gws;
    RoomManagerPreference gwt;
    Preference gwu;
    NewTipPreference gwv;
    private dps gww = null;
    private String gwx;
    private String gwy;
    private g gwz = null;
    private f screen;
    private SharedPreferences sp = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12658);
        super.onCreate(bundle);
        Log.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gwy = getIntent().getStringExtra("room_owner_name");
        AppMethodBeat.o(12658);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        boolean z;
        AppMethodBeat.i(12659);
        ah Kd = ((c) com.tencent.mm.kernel.g.af(c.class)).aSX().Kd(this.gwx);
        if (Kd != null && this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.sp.edit().putBoolean("allow_by_identity", Kd.gBv() == 2).commit();
        }
        super.onResume();
        this.screen = getPreferenceScreen();
        if (this.screen != null) {
            setMMTitle(R.string.ey0);
            this.gws = (CheckBoxPreference) this.screen.bmg("allow_by_identity");
            this.gwt = (RoomManagerPreference) this.screen.bmg("room_manager");
            this.gwu = this.screen.bmg("room_bind_app_info");
            if (!ab.IB(this.gwx) || (z.aUT() & 16) != 0) {
                this.screen.m38do("room_manager", !((c) com.tencent.mm.kernel.g.af(c.class)).akx(this.gwx));
            }
            this.screen.m38do("select_enable_qrcode", true);
            this.screen.m38do("select_into_room_type", true);
            this.screen.m38do("use_wework_manager_room", true);
            this.screen.m38do("room_bind_app_info", true);
            boolean equals = z.aTY().equals(this.gwy);
            if (!equals) {
                this.screen.m38do("room_transfer_room_ower", true);
            }
            if (equals) {
                com.tencent.mm.co.g.ey(this.gwx).h(new a<dps, String>() {
                    /* class com.tencent.mm.chatroom.ui.ManageChatroomUI.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ dps call(String str) {
                        AppMethodBeat.i(194128);
                        dps DA = ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupBindAppStorage().DA(str);
                        AppMethodBeat.o(194128);
                        return DA;
                    }
                }).b(new a<Void, dps>() {
                    /* class com.tencent.mm.chatroom.ui.ManageChatroomUI.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(dps dps) {
                        AppMethodBeat.i(194127);
                        dps dps2 = dps;
                        if (dps2 != null && !Util.isNullOrNil(dps2.MSS)) {
                            ManageChatroomUI.this.gww = dps2;
                            ManageChatroomUI.a(ManageChatroomUI.this);
                        }
                        AppMethodBeat.o(194127);
                        return null;
                    }
                });
            }
            ah Kd2 = ((c) com.tencent.mm.kernel.g.af(c.class)).aSX().Kd(this.gwx);
            if (Kd2 != null) {
                if (ab.Iy(this.gwx)) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(Kd2.gBv() == 1);
                    Log.i("MicroMsg.ManageChatroomUI", "isChecked = %s", objArr);
                    CheckBoxPreference checkBoxPreference = this.gws;
                    if ((Kd2.gBv() & 1) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    checkBoxPreference.setChecked(z);
                } else {
                    this.gws.setChecked(Kd2.gBv() == 2);
                }
                Log.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", Util.nullAs(this.gwx, BuildConfig.COMMAND), Integer.valueOf(Kd2.field_chatroomStatus));
                if (!ab.Iy(this.gwx) && v.aTU() && (((long) Kd2.field_chatroomStatus) & 131072) != 131072 && (((long) Kd2.field_chatroomStatus) & 65536) == 65536 && v.aTS()) {
                    this.screen.m38do("use_wework_manager_room", false);
                    this.gwv = (NewTipPreference) this.screen.bmg("use_wework_manager_room");
                    this.gwv.a(this.screen);
                    com.tencent.mm.plugin.newtips.a.exl().h(this.gwv);
                    com.tencent.mm.plugin.newtips.a.g.a(this.gwv);
                }
            }
            this.gws.OZw = false;
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.chatroom.ui.ManageChatroomUI.AnonymousClass3 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(194129);
                    ManageChatroomUI.this.finish();
                    AppMethodBeat.o(194129);
                    return true;
                }
            });
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(12659);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12660);
        super.onDestroy();
        AppMethodBeat.o(12660);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bj;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(12662);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(12662);
                    return;
                }
                int intExtra = intent.getIntExtra("into_room_type", -1);
                Log.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", this.gwx, Integer.valueOf(intExtra));
                cpf cpf = new cpf();
                cpf.KGO = Util.nullAsNil(this.gwx);
                cpf.Cyb = intExtra;
                ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(66, cpf));
                AppMethodBeat.o(12662);
                return;
            case 2:
                Log.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", 2);
                break;
        }
        AppMethodBeat.o(12662);
    }

    private dpr amM() {
        AppMethodBeat.i(194134);
        if (this.gww == null || Util.isNullOrNil(this.gww.MSS)) {
            AppMethodBeat.o(194134);
            return null;
        }
        dpr first = this.gww.MSS.getFirst();
        AppMethodBeat.o(194134);
        return first;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0324, code lost:
        r1 = amM();
     */
    @Override // com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f r13, com.tencent.mm.ui.base.preference.Preference r14) {
        /*
        // Method dump skipped, instructions count: 962
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.chatroom.ui.ManageChatroomUI.onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f, com.tencent.mm.ui.base.preference.Preference):boolean");
    }

    static /* synthetic */ void a(ManageChatroomUI manageChatroomUI) {
        AppMethodBeat.i(194135);
        if (manageChatroomUI.gww == null || Util.isNullOrNil(manageChatroomUI.gww.MSS)) {
            manageChatroomUI.screen.m38do("room_bind_app_info", true);
        } else {
            manageChatroomUI.screen.m38do("room_bind_app_info", false);
            manageChatroomUI.gwu.setSummary(Util.nullAsNil(manageChatroomUI.gww.MSS.getFirst().xMq));
        }
        manageChatroomUI.screen.notifyDataSetChanged();
        AppMethodBeat.o(194135);
    }

    static /* synthetic */ void a(ManageChatroomUI manageChatroomUI, final dpr dpr) {
        AppMethodBeat.i(194136);
        final e eVar = new e((Context) manageChatroomUI.getContext(), 1, true);
        eVar.j(Util.safeFormatString(manageChatroomUI.getString(R.string.av4, new Object[]{dpr.xMq}), new Object[0]), 17, com.tencent.mm.cb.a.fromDPToPix((Context) manageChatroomUI, 14));
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.chatroom.ui.ManageChatroomUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(194131);
                mVar.a(1, ManageChatroomUI.this.getResources().getColor(R.color.a5e), ManageChatroomUI.this.getString(R.string.av2));
                AppMethodBeat.o(194131);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.chatroom.ui.ManageChatroomUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(194133);
                if (menuItem.getItemId() == 1) {
                    c.b bVar = new c.b();
                    bVar.appId = dpr.jfi;
                    bVar.zqa = ManageChatroomUI.this.gwx;
                    bVar.zqc = 1;
                    ((com.tencent.mm.plugin.messenger.foundation.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(ManageChatroomUI.this.getContext(), bVar, new c.AbstractC1475c() {
                        /* class com.tencent.mm.chatroom.ui.ManageChatroomUI.AnonymousClass6.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.messenger.foundation.a.c.AbstractC1475c
                        public final void f(boolean z, String str) {
                            AppMethodBeat.i(194132);
                            if (!z) {
                                AppMethodBeat.o(194132);
                                return;
                            }
                            if (ManageChatroomUI.this.gww != null && !Util.isNullOrNil(ManageChatroomUI.this.gww.MSS)) {
                                dps dps = ManageChatroomUI.this.gww;
                                dps.MSR--;
                                try {
                                    ManageChatroomUI.this.gww.MSS.removeFirst();
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.ManageChatroomUI", e2.getMessage());
                                }
                                ManageChatroomUI.a(ManageChatroomUI.this);
                            }
                            AppMethodBeat.o(194132);
                        }
                    });
                    eVar.bMo();
                }
                AppMethodBeat.o(194133);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(194136);
    }
}
