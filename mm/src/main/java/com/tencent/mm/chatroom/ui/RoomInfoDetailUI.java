package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.f.a;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;

@Deprecated
public class RoomInfoDetailUI extends MMPreference implements MStorage.IOnStorageChange {
    private as contact;
    private boolean dRx;
    private CheckBoxPreference gtV;
    private boolean gui = false;
    private String guu;
    private int gyu;
    private SignaturePreference gyv;
    private CheckBoxPreference gyw;
    private CheckBoxPreference gyx;
    private boolean isDeleteCancel = false;
    private String roomId;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12741);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(12741);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(12742);
        super.onResume();
        amy();
        amW();
        if (!(this.contact == null || this.gyw == null)) {
            ah Ke = ((c) g.af(c.class)).aSX().Ke(this.roomId);
            SharedPreferences sharedPreferences = getSharedPreferences(this.guu, 0);
            if (Ke.gBx()) {
                this.gyw.setChecked(true);
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.gyw.setChecked(false);
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(12742);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12743);
        setMMTitle(R.string.g_a);
        this.screen = getPreferenceScreen();
        this.guu = getPackageName() + "_preferences";
        this.dRx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.roomId = getIntent().getStringExtra("RoomInfo_Id");
        if (this.roomId == null) {
            this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
        }
        this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
        if (this.dRx) {
            this.gyu = this.contact.fuH;
            this.gyv = (SignaturePreference) this.screen.bmg("room_name");
            this.gtV = (CheckBoxPreference) this.screen.bmg("room_msg_notify");
            this.gyx = (CheckBoxPreference) this.screen.bmg("room_show_msg_count");
            this.gyw = (CheckBoxPreference) this.screen.bmg("room_msg_show_username");
            this.gyx.OZw = false;
        } else {
            this.gyu = 1;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomInfoDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12734);
                RoomInfoDetailUI.this.finish();
                AppMethodBeat.o(12734);
                return true;
            }
        });
        AppMethodBeat.o(12743);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bz;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12745);
        super.onPause();
        if (this.gui) {
            ah Kd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
            ((c) g.af(c.class)).aSX().update(Kd, new String[0]);
            String aTY = z.aTY();
            boolean gBx = Kd.gBx();
            cpi cpi = new cpi();
            cpi.KGO = this.roomId;
            cpi.UserName = aTY;
            cpi.Mvf = 1;
            cpi.Cyb = gBx ? 1 : 0;
            ((l) g.af(l.class)).aSM().d(new k.a(49, cpi));
        }
        AppMethodBeat.o(12745);
    }

    private boolean amU() {
        AppMethodBeat.i(12746);
        if ((((c) g.af(c.class)).aSX().Kd(this.roomId).field_chatroomdataflag & 2) == 0) {
            AppMethodBeat.o(12746);
            return true;
        }
        AppMethodBeat.o(12746);
        return false;
    }

    private String amV() {
        AppMethodBeat.i(12747);
        ah Kd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
        if (Kd == null) {
            AppMethodBeat.o(12747);
            return "";
        }
        String str = Kd.field_selfDisplayName;
        AppMethodBeat.o(12747);
        return str;
    }

    private void amW() {
        AppMethodBeat.i(12748);
        if (!(this.contact == null || this.gyv == null)) {
            String amV = amV();
            if (Util.isNullOrNil(amV)) {
                amV = z.aUa();
            }
            if (!Util.isNullOrNil(amV)) {
                SignaturePreference signaturePreference = this.gyv;
                if (amV.length() <= 0) {
                    amV = getString(R.string.gu1);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, amV));
                AppMethodBeat.o(12748);
                return;
            }
            this.gyv.setSummary("");
        }
        AppMethodBeat.o(12748);
    }

    private void amy() {
        boolean z = true;
        AppMethodBeat.i(12749);
        if (!this.dRx) {
            AppMethodBeat.o(12749);
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(this.guu, 0);
        if (this.gyu == 0) {
            setTitleMuteIconVisibility(0);
            if (this.gtV != null) {
                this.gtV.setChecked(true);
                sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
            }
            if (this.gyx != null) {
                this.gyx.setChecked(amU());
            }
        } else if (this.gyu == 1) {
            setTitleMuteIconVisibility(8);
            if (this.gtV != null) {
                this.gtV.setChecked(false);
                sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
            }
        }
        f fVar = this.screen;
        if (this.gyu != 1) {
            z = false;
        }
        fVar.m38do("room_show_msg_count", z);
        AppMethodBeat.o(12749);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ah ahVar;
        AppMethodBeat.i(12750);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(12750);
            return;
        }
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    setResult(-1);
                    finish();
                    AppMethodBeat.o(12750);
                    return;
                }
                break;
            case 2:
                if (intent != null) {
                    String nullAs = Util.nullAs(intent.getStringExtra("Contact_Nick"), "");
                    if (!Util.isNullOrNil(nullAs)) {
                        String aTY = z.aTY();
                        ah Kd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
                        if (Kd == null) {
                            ahVar = new ah();
                        } else {
                            ahVar = Kd;
                        }
                        ahVar.field_chatroomname = this.roomId;
                        ahVar.field_selfDisplayName = nullAs;
                        ((c) g.af(c.class)).aSX().update(ahVar, new String[0]);
                        cph cph = new cph();
                        cph.KGO = this.roomId;
                        cph.UserName = aTY;
                        cph.Liq = Util.nullAsNil(nullAs);
                        ((l) g.af(l.class)).aSM().d(new k.a(48, cph));
                        amW();
                        break;
                    }
                } else {
                    AppMethodBeat.o(12750);
                    return;
                }
                break;
        }
        AppMethodBeat.o(12750);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        int i2;
        String string;
        boolean z2 = true;
        AppMethodBeat.i(12744);
        String str = preference.mKey;
        Log.d("MicroMsg.RoomInfoDetailUI", "click key : %s", str);
        if (str.equals("room_name")) {
            Intent intent = new Intent();
            intent.setClass(this, e.j.class);
            intent.putExtra("Contact_mode_name_type", 4);
            String aTY = z.aTY();
            intent.putExtra("Contact_Nick", amV());
            intent.putExtra("Contact_User", aTY);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
            intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
            getContext().startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            ah Kd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
            Kd.AL(!Kd.gBx());
            this.gui = true;
        }
        if (str.equals("room_msg_notify")) {
            this.gyu = this.gyu == 0 ? 1 : 0;
            ((l) g.af(l.class)).aSM().d(new a(this.roomId, this.gyu));
            this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
            this.contact.nm(this.gyu);
            ((l) g.af(l.class)).aSN().c(this.roomId, this.contact);
            amy();
            this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
            this.screen.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            Intent intent2 = new Intent();
            intent2.putExtra("isApplyToAll", false);
            intent2.putExtra(ch.COL_USERNAME, this.contact.field_username);
            com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent2, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            if (this.dRx) {
                string = getString(R.string.dei);
            } else {
                string = getString(R.string.deh, new Object[]{this.contact.arJ()});
            }
            h.a(this, string, new String[]{getString(R.string.g6i)}, (String) null, new h.d() {
                /* class com.tencent.mm.chatroom.ui.RoomInfoDetailUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    String str;
                    AppMethodBeat.i(12738);
                    switch (i2) {
                        case 0:
                            RoomInfoDetailUI.this.isDeleteCancel = false;
                            RoomInfoDetailUI roomInfoDetailUI = RoomInfoDetailUI.this;
                            RoomInfoDetailUI.this.getString(R.string.zb);
                            final q a2 = h.a((Context) roomInfoDetailUI, RoomInfoDetailUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.chatroom.ui.RoomInfoDetailUI.AnonymousClass2.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(12735);
                                    RoomInfoDetailUI.this.isDeleteCancel = true;
                                    AppMethodBeat.o(12735);
                                }
                            });
                            if (!RoomInfoDetailUI.this.isDeleteCancel) {
                                str = d.bfO(RoomInfoDetailUI.this.contact.field_username);
                            } else {
                                str = null;
                            }
                            if (Util.isNullOrNil(str)) {
                                RoomInfoDetailUI.a(RoomInfoDetailUI.this, a2);
                                break;
                            } else {
                                a2.dismiss();
                                h.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(R.string.iba, new Object[]{str}), null, RoomInfoDetailUI.this.getString(R.string.dvh), RoomInfoDetailUI.this.getString(R.string.b5r), new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.chatroom.ui.RoomInfoDetailUI.AnonymousClass2.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(12736);
                                        RoomInfoDetailUI.this.isDeleteCancel = true;
                                        Intent intent = new Intent();
                                        intent.putExtra("Chat_User", RoomInfoDetailUI.this.contact.field_username);
                                        intent.addFlags(67108864);
                                        com.tencent.mm.br.c.f(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", intent);
                                        AppMethodBeat.o(12736);
                                    }
                                }, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.chatroom.ui.RoomInfoDetailUI.AnonymousClass2.AnonymousClass3 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(12737);
                                        a2.show();
                                        RoomInfoDetailUI.this.isDeleteCancel = false;
                                        RoomInfoDetailUI.a(RoomInfoDetailUI.this, a2);
                                        AppMethodBeat.o(12737);
                                    }
                                }, -1, R.color.cd);
                                AppMethodBeat.o(12738);
                                return;
                            }
                    }
                    AppMethodBeat.o(12738);
                }
            });
        }
        if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.guu, 0);
            if (this.contact != null) {
                if (((l) g.af(l.class)).aST().bkg(this.contact.field_username)) {
                    ab.F(this.contact.field_username, true);
                } else {
                    ab.E(this.contact.field_username, true);
                }
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", ((l) g.af(l.class)).aST().bkg(this.contact.field_username)).commit();
            }
        }
        if ("room_show_msg_count".equals(str)) {
            boolean amU = amU();
            Log.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", Boolean.valueOf(amU), Boolean.valueOf(amU));
            if (!amU) {
                z = true;
            } else {
                z = false;
            }
            ah Kd2 = ((c) g.af(c.class)).aSX().Kd(this.roomId);
            if (z) {
                Kd2.oS(0);
            } else {
                Kd2.oS(2);
            }
            Log.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", Boolean.valueOf(z));
            ((c) g.af(c.class)).aSX().update(Kd2, new String[0]);
            String aTY2 = z.aTY();
            cpi cpi = new cpi();
            cpi.KGO = this.roomId;
            cpi.UserName = aTY2;
            cpi.Mvf = 2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            cpi.Cyb = i2;
            ((l) g.af(l.class)).aSM().d(new k.a(49, cpi));
            if (this.gyx != null) {
                CheckBoxPreference checkBoxPreference = this.gyx;
                if (amU) {
                    z2 = false;
                }
                checkBoxPreference.setChecked(z2);
            }
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12744);
        return false;
    }

    static /* synthetic */ void a(RoomInfoDetailUI roomInfoDetailUI, final ProgressDialog progressDialog) {
        AppMethodBeat.i(12751);
        bp.a(roomInfoDetailUI.contact.field_username, new bp.a() {
            /* class com.tencent.mm.chatroom.ui.RoomInfoDetailUI.AnonymousClass3 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(12739);
                boolean z = RoomInfoDetailUI.this.isDeleteCancel;
                AppMethodBeat.o(12739);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(12740);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(12740);
            }
        });
        AppMethodBeat.o(12751);
    }
}
