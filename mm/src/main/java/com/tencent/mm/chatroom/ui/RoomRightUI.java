package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import junit.framework.Assert;

public class RoomRightUI extends MMPreference implements i {
    private ProgressDialog gtM = null;
    private String gyA = "";
    private int gyB = 0;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.by;
    }

    private void amX() {
        AppMethodBeat.i(12756);
        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(135175, (Object) null), 0);
        Preference bmg = this.screen.bmg("settings_room_size");
        if (bmg != null && nullAs > 0) {
            bmg.setSummary(getResources().getQuantityString(R.plurals.a2, nullAs, Integer.valueOf(nullAs)));
            bmg.setEnabled(false);
        } else if (bmg != null) {
            this.screen.e(bmg);
        }
        this.screen.bmg("room_right_max_tip").setTitle(getString(R.string.g94, new Object[]{Integer.valueOf(nullAs)}));
        int nullAs2 = Util.nullAs((Integer) g.aAh().azQ().get(135176, (Object) null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.screen.bmg("settings_room_grant");
        if (roomGrantPreference != null && nullAs2 <= 0) {
            this.screen.e(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            String str = getString(R.string.g97, new Object[]{Integer.valueOf(nullAs2)});
            roomGrantPreference.num = str;
            if (roomGrantPreference.gyt != null) {
                roomGrantPreference.gyt.setText(str);
            }
        }
        Preference bmg2 = this.screen.bmg("room_right_tip");
        Preference bmg3 = this.screen.bmg("room_right_grant_tip");
        if (nullAs2 <= 0) {
            if (bmg2 != null) {
                this.screen.e(bmg2);
            }
            if (bmg3 != null) {
                this.screen.e(bmg3);
            }
            Preference bmg4 = this.screen.bmg("room_grant_to_friend");
            if (bmg4 != null) {
                this.screen.e(bmg4);
            }
            if (roomGrantPreference != null) {
                this.screen.e(roomGrantPreference);
            }
            AppMethodBeat.o(12756);
            return;
        }
        String string = getString(R.string.g98, new Object[]{Integer.valueOf(nullAs2), Integer.valueOf(nullAs)});
        if (bmg2 != null) {
            bmg2.setTitle(string);
        }
        String string2 = getString(R.string.g91, new Object[]{Integer.valueOf(this.gyB)});
        if (bmg3 != null) {
            bmg3.setTitle(string2);
        }
        AppMethodBeat.o(12756);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12757);
        super.onCreate(bundle);
        this.gyB = Util.nullAs((Integer) g.aAh().azQ().get(135177, (Object) null), 0);
        g.aAg().hqi.a(339, this);
        g.aAg().hqi.a(30, this);
        g.aAh().azQ().set(135184, Boolean.FALSE);
        initView();
        AppMethodBeat.o(12757);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(12758);
        super.onResume();
        amX();
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(12758);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12760);
        super.onDestroy();
        g.aAg().hqi.b(339, this);
        g.aAg().hqi.b(30, this);
        AppMethodBeat.o(12760);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12761);
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.gti);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomRightUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12752);
                RoomRightUI.this.hideVKB();
                RoomRightUI.this.finish();
                AppMethodBeat.o(12752);
                return true;
            }
        });
        AppMethodBeat.o(12761);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(12762);
        Log.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", Integer.valueOf(i2));
        if (i3 != -1 || intent == null) {
            AppMethodBeat.o(12762);
            return;
        }
        switch (i2) {
            case 1:
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                Log.d("MicroMsg.RoomRightUI", "pick user %s", stringExtra);
                if (!Util.isNullOrNil(stringExtra)) {
                    this.gyA = stringExtra;
                    final String str = this.gyA;
                    h.a(getContext(), getString(R.string.g7_, new Object[]{((l) g.af(l.class)).aSN().Kn(str).arJ(), Integer.valueOf(this.gyB)}), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.RoomRightUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(12754);
                            final o oVar = new o(str);
                            RoomRightUI roomRightUI = RoomRightUI.this;
                            RoomRightUI roomRightUI2 = RoomRightUI.this;
                            RoomRightUI.this.getString(R.string.zb);
                            roomRightUI.gtM = h.a((Context) roomRightUI2, "", true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.chatroom.ui.RoomRightUI.AnonymousClass2.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(12753);
                                    g.aAg().hqi.a(oVar);
                                    AppMethodBeat.o(12753);
                                }
                            });
                            g.aAg().hqi.a(oVar, 0);
                            AppMethodBeat.o(12754);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    AppMethodBeat.o(12762);
                    return;
                }
        }
        AppMethodBeat.o(12762);
    }

    private void a(final LinkedList<String> linkedList) {
        AppMethodBeat.i(12763);
        Assert.assertTrue(linkedList.size() > 0);
        String string = MMApplicationContext.getContext().getString(R.string.awt);
        linkedList.size();
        Object[] objArr = new Object[1];
        LinkedList linkedList2 = new LinkedList();
        if (g.aAc()) {
            for (String str : linkedList) {
                linkedList2.add(aa.getDisplayName(str));
            }
        }
        objArr[0] = Util.listToString(linkedList2, string);
        h.d(this, getString(R.string.g95, objArr), getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomRightUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(12755);
                RoomRightUI.a(RoomRightUI.this, linkedList);
                AppMethodBeat.o(12755);
            }
        });
        AppMethodBeat.o(12763);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(12764);
        Log.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        if (qVar.getType() != 339) {
            AppMethodBeat.o(12764);
            return;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.gyA);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            str2 = this.gyA;
        } else {
            str2 = Kn.arJ();
        }
        if (i2 == 0 && i3 == 0) {
            h.c(this, getString(R.string.g7c, new Object[]{str2}), getString(R.string.zb), true);
            if (this.screen != null) {
                amX();
                this.screen.notifyDataSetChanged();
            }
            AppMethodBeat.o(12764);
        } else if (i3 == -251) {
            h.c(this, getString(R.string.g7a, new Object[]{str2, Integer.valueOf(this.gyB)}), getString(R.string.zb), true);
            AppMethodBeat.o(12764);
        } else if (i3 == -44) {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(this.gyA);
            a(linkedList);
            AppMethodBeat.o(12764);
        } else if (i3 == -22) {
            h.c(this, getString(R.string.g7b, new Object[]{str2}), getString(R.string.zb), true);
            AppMethodBeat.o(12764);
        } else {
            Toast.makeText(this, "err :" + i2 + " ," + i3, 0).show();
            AppMethodBeat.o(12764);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(12759);
        if (preference.mKey.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            LinkedList linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", Util.listToString(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        AppMethodBeat.o(12759);
        return false;
    }

    static /* synthetic */ void a(RoomRightUI roomRightUI, LinkedList linkedList) {
        AppMethodBeat.i(12765);
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            linkedList2.add(3);
        }
        new com.tencent.mm.pluginsdk.ui.applet.aa(roomRightUI, new aa.a() {
            /* class com.tencent.mm.chatroom.ui.RoomRightUI.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.aa.a
            /* renamed from: do  reason: not valid java name */
            public final void m6do(boolean z) {
            }
        }).a(linkedList, linkedList2, null);
        AppMethodBeat.o(12765);
    }
}
