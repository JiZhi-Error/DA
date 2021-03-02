package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private ProgressDialog Dav = null;
    private boolean isDeleteCancel = false;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74146);
        super.onCreate(bundle);
        if (!g.aAf().azp()) {
            finish();
            AppMethodBeat.o(74146);
            return;
        }
        initView();
        AppMethodBeat.o(74146);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74147);
        setMMTitle(R.string.gnz);
        this.screen = getPreferenceScreen();
        if (g.aAh().azQ().getInt(89, 0) != 2) {
            this.screen.bmi("settings_recovery");
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74139);
                SettingsChattingUI.this.hideVKB();
                SettingsChattingUI.this.finish();
                AppMethodBeat.o(74139);
                return true;
            }
        });
        AppMethodBeat.o(74147);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74148);
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(((Boolean) g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue());
            checkBoxPreference.OZw = false;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("settings_enter_button_send");
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setChecked(((Boolean) g.aAh().azQ().get(66832, Boolean.FALSE)).booleanValue());
            checkBoxPreference2.OZw = false;
        }
        AppMethodBeat.o(74148);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ci;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(74149);
        String str = preference.mKey;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1776646462:
                if (str.equals("settings_chatting_bg")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1565531065:
                if (str.equals("settings_bak_chat")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1550690765:
                if (str.equals("settings_reset")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1439483675:
                if (str.equals("settings_voice_play_mode")) {
                    c2 = 0;
                    break;
                }
                break;
            case -409015247:
                if (str.equals("settings_recovery")) {
                    c2 = 6;
                    break;
                }
                break;
            case 624882802:
                if (str.equals("settings_enter_button_send")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1789437336:
                if (str.equals("settings_emoji_manager")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                boolean booleanValue = ((Boolean) g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue();
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(booleanValue);
                objArr[1] = Boolean.valueOf(!booleanValue);
                Log.d("MicroMsg.SettingsChattingUI", "set voice mode from %B to %B", objArr);
                ao azQ = g.aAh().azQ();
                if (!booleanValue) {
                    z = true;
                }
                azQ.set(26, Boolean.valueOf(z));
                AppMethodBeat.o(74149);
                return true;
            case 1:
                final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_enter_button_send");
                if (checkBoxPreference != null) {
                    final boolean isChecked = checkBoxPreference.isChecked();
                    if (isChecked) {
                        f.a aVar = new f.a(getContext());
                        aVar.bow(getResources().getString(R.string.gok));
                        aVar.c(new f.c() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass4 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(256524);
                                if (z) {
                                    Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", Boolean.valueOf(isChecked));
                                    g.aAh().azQ().set(66832, Boolean.valueOf(isChecked));
                                    AppMethodBeat.o(256524);
                                    return;
                                }
                                checkBoxPreference.setChecked(false);
                                SettingsChattingUI.this.screen.notifyDataSetChanged();
                                AppMethodBeat.o(256524);
                            }
                        }).show();
                    } else {
                        Log.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", Boolean.valueOf(isChecked));
                        g.aAh().azQ().set(66832, Boolean.valueOf(isChecked));
                    }
                }
                AppMethodBeat.o(74149);
                return true;
            case 2:
                a bl = new a().bl(new Intent().setClassName(getContext(), "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI"));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToBackup", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToBackup", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(74149);
                return true;
            case 3:
                Intent intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                AppCompatActivity context = getContext();
                a bl2 = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(74149);
                return true;
            case 4:
                Intent intent2 = new Intent();
                intent2.putExtra("10931", 2);
                c.b(getContext(), "emoji", ".ui.EmojiMineUI", intent2);
                AppMethodBeat.o(74149);
                return true;
            case 5:
                h.c(getContext(), getResources().getString(R.string.gtd), "", getString(R.string.t2), getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        final ArrayList arrayList;
                        AppMethodBeat.i(74143);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 5, 2, "");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(324, 0, 1, false);
                        SettingsChattingUI.this.isDeleteCancel = false;
                        SettingsChattingUI settingsChattingUI = SettingsChattingUI.this;
                        SettingsChattingUI settingsChattingUI2 = SettingsChattingUI.this;
                        SettingsChattingUI.this.getString(R.string.zb);
                        settingsChattingUI.Dav = h.a((Context) settingsChattingUI2, SettingsChattingUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass2.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(74140);
                                SettingsChattingUI.this.isDeleteCancel = true;
                                AppMethodBeat.o(74140);
                            }
                        });
                        List<ca> eiQ = ((l) g.af(l.class)).eiy().eiQ();
                        if (eiQ != null) {
                            Log.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", Integer.valueOf(eiQ.size()));
                            HashSet hashSet = new HashSet();
                            for (ca caVar : eiQ) {
                                if (!hashSet.contains(caVar.field_talker) && ((l) g.af(l.class)).aST().bjY(caVar.field_talker) != null && d.aU(caVar)) {
                                    hashSet.add(caVar.field_talker);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(hashSet);
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null || arrayList.size() <= 0) {
                            SettingsChattingUI.b(SettingsChattingUI.this);
                            AppMethodBeat.o(74143);
                            return;
                        }
                        SettingsChattingUI.this.Dav.dismiss();
                        h.a(SettingsChattingUI.this, false, SettingsChattingUI.this.getString(R.string.ibc, new Object[]{Integer.valueOf(arrayList.size())}), null, SettingsChattingUI.this.getString(R.string.dvh), SettingsChattingUI.this.getString(R.string.b5s), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass2.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(74141);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 5, 4, "");
                                SettingsChattingUI.this.isDeleteCancel = true;
                                if (arrayList.size() <= 1) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", (String) arrayList.get(0));
                                    intent.addFlags(67108864);
                                    c.f(SettingsChattingUI.this, ".ui.chatting.ChattingUI", intent);
                                    AppMethodBeat.o(74141);
                                    return;
                                }
                                Intent intent2 = new Intent();
                                intent2.putStringArrayListExtra("key_conversation_list", arrayList);
                                c.f(SettingsChattingUI.this, ".ui.conversation.SettingCheckUnProcessWalletConvUI", intent2);
                                AppMethodBeat.o(74141);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass2.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(74142);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 5, 3, "");
                                SettingsChattingUI.this.Dav.show();
                                SettingsChattingUI.this.isDeleteCancel = false;
                                SettingsChattingUI.b(SettingsChattingUI.this);
                                AppMethodBeat.o(74142);
                            }
                        }, -1, R.color.cd);
                        AppMethodBeat.o(74143);
                    }
                }, null);
                AppMethodBeat.o(74149);
                return true;
            case 6:
                Intent className = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
                className.putExtra("scene", 1);
                AppCompatActivity context2 = getContext();
                a bl3 = new a().bl(className);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToRecovery", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingUI", "goToRecovery", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(74149);
                return true;
            default:
                AppMethodBeat.o(74149);
                return false;
        }
    }

    static /* synthetic */ void b(SettingsChattingUI settingsChattingUI) {
        AppMethodBeat.i(74150);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass3 */

            {
                AppMethodBeat.i(161719);
                AppMethodBeat.o(161719);
            }

            public final void run() {
                List<Boolean> am;
                AppMethodBeat.i(173795);
                List<String> gCw = ((l) g.af(l.class)).aST().gCw();
                if (gCw.size() > 0 && (am = u.am(gCw)) != null) {
                    for (int i2 = 0; i2 < am.size(); i2++) {
                        if (am.get(i2).booleanValue()) {
                            com.tencent.mm.plugin.setting.c.jRu.gr(gCw.get(i2));
                        }
                    }
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.u) g.af(com.tencent.mm.plugin.messenger.foundation.a.u.class)).amb();
                bp.a(new bp.a() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.model.bp.a
                    public final boolean amG() {
                        AppMethodBeat.i(173793);
                        boolean z = SettingsChattingUI.this.isDeleteCancel;
                        AppMethodBeat.o(173793);
                        return z;
                    }

                    @Override // com.tencent.mm.model.bp.a
                    public final void amH() {
                        AppMethodBeat.i(173794);
                        if (SettingsChattingUI.this.Dav != null) {
                            SettingsChattingUI.this.Dav.dismiss();
                            SettingsChattingUI.this.Dav = null;
                        }
                        EventCenter.instance.publish(new sq());
                        AppMethodBeat.o(173794);
                    }
                });
                AppMethodBeat.o(173795);
            }
        }, "doResetChatHistory");
        AppMethodBeat.o(74150);
    }
}
