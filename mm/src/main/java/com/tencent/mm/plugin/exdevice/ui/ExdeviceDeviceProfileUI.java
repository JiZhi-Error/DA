package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class ExdeviceDeviceProfileUI extends MMPreference implements i {
    private String dfJ;
    private q gxX;
    private String mDeviceType;
    private long rAv;
    private String rFI;
    private String rFJ;
    private String rFd;
    private int rGG;
    private q rGN = null;
    private String rHJ;
    private String rHK;
    private boolean rHL;
    private String rHM;
    private boolean rHN;
    private String rHO;
    private h.b rHP;
    private String rzn;
    private String rzo;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(24033);
        exdeviceDeviceProfileUI.h(qVar);
        AppMethodBeat.o(24033);
    }

    static /* synthetic */ void a(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI, DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        AppMethodBeat.i(24032);
        exdeviceDeviceProfileUI.a(deviceProfileHeaderPreference);
        AppMethodBeat.o(24032);
    }

    static /* synthetic */ void f(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        AppMethodBeat.i(24034);
        exdeviceDeviceProfileUI.cLJ();
        AppMethodBeat.o(24034);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01cb, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r11.rFJ) == false) goto L_0x01cd;
     */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 472
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.onCreate(android.os.Bundle):void");
    }

    private void cLJ() {
        AppMethodBeat.i(24022);
        f preferenceScreen = getPreferenceScreen();
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) preferenceScreen.bmg("device_profile_header");
        deviceProfileHeaderPreference.a(1, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(24014);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.string.c08), "", "", 50, ExdeviceDeviceProfileUI.this.rHP);
                a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24014);
            }
        });
        deviceProfileHeaderPreference.a(4, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(24015);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.string.c08), ExdeviceDeviceProfileUI.this.rHK, "", 50, ExdeviceDeviceProfileUI.this.rHP);
                a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24015);
            }
        });
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.setIconUrl(this.rHM);
        ((KeyValuePreference) preferenceScreen.bmg("message_manage")).BC(true);
        ((KeyValuePreference) preferenceScreen.bmg("connect_setting")).BC(true);
        ((KeyValuePreference) preferenceScreen.bmg("user_list")).BC(true);
        preferenceScreen.m38do("message_manage", true);
        preferenceScreen.m38do("connect_setting", true);
        preferenceScreen.m38do("user_list", true);
        if (this.rHN) {
            preferenceScreen.m38do("sub_device_desc", false);
            preferenceScreen.bmg("sub_device_desc").setTitle(getResources().getString(R.string.c2d, this.rHO));
            preferenceScreen.m38do("bind_device", true);
            preferenceScreen.m38do("unbind_device", true);
        } else {
            preferenceScreen.m38do("sub_device_desc", true);
            preferenceScreen.m38do("bind_device", this.rHL);
            preferenceScreen.m38do("unbind_device", !this.rHL);
        }
        if (Util.isNullOrNil(this.rHJ)) {
            preferenceScreen.m38do("open_device_panel", true);
        }
        AppMethodBeat.o(24022);
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        AppMethodBeat.i(24023);
        String str = Util.isNullOrNil(this.rFI) ? this.rzn : this.rFI;
        if (!Util.isNullOrNil(this.rHK)) {
            deviceProfileHeaderPreference.setName(this.rHK);
            deviceProfileHeaderPreference.anM(getString(R.string.c01, new Object[]{str}));
            deviceProfileHeaderPreference.ai(3, true);
            deviceProfileHeaderPreference.ai(4, true);
            deviceProfileHeaderPreference.ai(1, false);
        } else {
            deviceProfileHeaderPreference.setName(str);
            deviceProfileHeaderPreference.anM("");
            deviceProfileHeaderPreference.ai(3, false);
            deviceProfileHeaderPreference.ai(4, false);
            deviceProfileHeaderPreference.ai(1, this.rHL);
        }
        deviceProfileHeaderPreference.Cs(this.rFd);
        AppMethodBeat.o(24023);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.at;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        AppMethodBeat.i(24024);
        Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", preference.mKey);
        if ("bind_device".equals(preference.mKey)) {
            if (Util.isNullOrNil(this.rFJ)) {
                Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                m mVar = new m(com.tencent.mm.plugin.exdevice.k.b.anY(this.dfJ), this.rzn, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, this.rAv);
                h(mVar);
                bg.azz().a(1262, this);
                bg.azz().a(mVar, 0);
            } else {
                Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                String str2 = this.rFJ;
                int i2 = this.rGG;
                bg.azz().a(536, this);
                dr drVar = new dr();
                drVar.dGF.dGH = str2;
                drVar.dGF.opType = 1;
                drVar.dGF.dGI = i2;
                EventCenter.instance.publish(drVar);
                final com.tencent.mm.ak.q qVar = drVar.dGG.dGJ;
                getString(R.string.zb);
                this.rGN = h.a((Context) this, getString(R.string.byx), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass10 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(24016);
                        bg.azz().b(536, ExdeviceDeviceProfileUI.this);
                        dr drVar = new dr();
                        drVar.dGF.opType = 2;
                        drVar.dGF.dGJ = qVar;
                        EventCenter.instance.publish(drVar);
                        AppMethodBeat.o(24016);
                    }
                });
            }
        } else if ("unbind_device".equals(preference.mKey)) {
            cat cat = new cat();
            cat.oTH = this.rzo;
            cat.KLO = this.mDeviceType;
            com.tencent.mm.plugin.exdevice.i.b gb = ad.cKL().gb(this.rzo, this.mDeviceType);
            if (!(gb == null || (str = gb.fMk) == null || str.length() <= 0)) {
                String[] split = str.split(",");
                for (String str3 : split) {
                    ad.cKL().gd(str3, this.mDeviceType);
                }
            }
            x xVar = new x(cat, 2);
            h(xVar);
            bg.azz().a(537, this);
            bg.azz().a(xVar, 0);
        } else if ("open_device_panel".equals(preference.mKey)) {
            com.tencent.mm.plugin.exdevice.model.f.ay(getContext(), this.rHJ);
        } else if ("contact_info_biz_go_chatting".equals(preference.mKey)) {
            bg.aVF();
            as Kn = c.aSN().Kn(this.rzn);
            Intent intent = new Intent();
            intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, this.rzo);
            intent.putExtra("device_type", this.mDeviceType);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.rFJ);
            if (Kn != null) {
                if (!com.tencent.mm.contact.c.oR(Kn.field_type) || !Kn.gBM()) {
                    intent.putExtra("Contact_User", this.rzn);
                    intent.putExtra("force_get_contact", true);
                    com.tencent.mm.br.c.b(getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                } else {
                    ag.bah().MT(Kn.field_username);
                    intent.putExtra("Chat_User", this.rzn);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.a.rxo.d(intent, getContext());
                }
            }
        } else if (!"message_manage".equals(preference.mKey) && !"connect_setting".equals(preference.mKey) && !"user_list".equals(preference.mKey)) {
            AppMethodBeat.o(24024);
            return false;
        }
        AppMethodBeat.o(24024);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(24025);
        Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar == null) {
            Log.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            AppMethodBeat.o(24025);
            return;
        }
        Log.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", Integer.valueOf(qVar.getType()));
        if (qVar instanceof l) {
            cLD();
            bg.azz().b(qVar.getType(), this);
            if (i2 == 0 && i3 == 0) {
                cLL();
                f(ad.cKL().gb(this.rzo, this.mDeviceType));
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(24017);
                        ExdeviceDeviceProfileUI.this.rHL = true;
                        ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
                        ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
                        AppMethodBeat.o(24017);
                    }
                });
                AppMethodBeat.o(24025);
                return;
            }
            Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i3), Integer.valueOf(i2), str, Integer.valueOf(qVar.getType()));
            cLK();
            AppMethodBeat.o(24025);
        } else if (qVar instanceof m) {
            cLD();
            bg.azz().b(qVar.getType(), this);
            com.tencent.mm.plugin.exdevice.i.b Di = ad.cKL().Di(com.tencent.mm.plugin.exdevice.k.b.anY(this.dfJ));
            if (i2 == 0 && i3 == 0 && Di != null) {
                f(Di);
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass12 */

                    public final void run() {
                        AppMethodBeat.i(24018);
                        ExdeviceDeviceProfileUI.this.rHL = true;
                        ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
                        ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
                        AppMethodBeat.o(24018);
                    }
                });
                cLL();
                AppMethodBeat.o(24025);
                return;
            }
            Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i3), Integer.valueOf(i2), str, Integer.valueOf(qVar.getType()));
            cLK();
            AppMethodBeat.o(24025);
        } else if (qVar instanceof y) {
            cLD();
            bg.azz().b(1263, this);
            if (i2 == 0 && i3 == 0) {
                this.rHK = ((y) qVar).fMb;
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(24019);
                        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference) ExdeviceDeviceProfileUI.this.getPreferenceScreen().bmg("device_profile_header"));
                        AppMethodBeat.o(24019);
                    }
                });
                com.tencent.mm.plugin.exdevice.i.b gb = ad.cKL().gb(this.rzo, this.mDeviceType);
                if (gb == null) {
                    Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", this.rzo, this.mDeviceType);
                    AppMethodBeat.o(24025);
                    return;
                }
                gb.BC(this.rHK);
                ad.cKL().update(gb, new String[0]);
                AppMethodBeat.o(24025);
                return;
            }
            Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i3), Integer.valueOf(i2), str, Integer.valueOf(qVar.getType()));
            Toast.makeText(getContext(), getString(R.string.c06), 1).show();
            AppMethodBeat.o(24025);
        } else {
            if (qVar instanceof x) {
                cLD();
                if (i2 == 0 && i3 == 0) {
                    runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass14 */

                        public final void run() {
                            AppMethodBeat.i(24020);
                            ExdeviceDeviceProfileUI.this.rHK = null;
                            ExdeviceDeviceProfileUI.this.rHL = false;
                            ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
                            ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
                            AppMethodBeat.o(24020);
                        }
                    });
                    finish();
                } else {
                    Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", Integer.valueOf(i3), Integer.valueOf(i2), str, Integer.valueOf(qVar.getType()));
                    runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(24011);
                            Toast.makeText(ExdeviceDeviceProfileUI.this.getContext(), (int) R.string.c2i, 1).show();
                            AppMethodBeat.o(24011);
                        }
                    });
                    AppMethodBeat.o(24025);
                    return;
                }
            }
            AppMethodBeat.o(24025);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24026);
        bg.azz().b(537, this);
        super.onDestroy();
        AppMethodBeat.o(24026);
    }

    private void f(com.tencent.mm.plugin.exdevice.i.b bVar) {
        AppMethodBeat.i(24027);
        if (bVar != null) {
            this.rzo = bVar.field_deviceID;
            this.mDeviceType = bVar.field_deviceType;
            this.rHK = Util.nullAsNil(bVar.fMb);
            this.rFI = Util.nullAsNil(bVar.fMc);
            this.rzn = Util.nullAsNil(bVar.field_brandName);
            this.rFd = Util.nullAsNil(bVar.fMd);
            this.rHM = Util.nullAsNil(bVar.iconUrl);
            this.rHJ = Util.nullAsNil(bVar.jumpUrl);
        }
        AppMethodBeat.o(24027);
    }

    private void cLD() {
        AppMethodBeat.i(24028);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(24004);
                if (ExdeviceDeviceProfileUI.this.gxX != null && ExdeviceDeviceProfileUI.this.gxX.isShowing()) {
                    ExdeviceDeviceProfileUI.this.gxX.dismiss();
                }
                if (ExdeviceDeviceProfileUI.this.rGN != null && ExdeviceDeviceProfileUI.this.rGN.isShowing()) {
                    ExdeviceDeviceProfileUI.this.rGN.dismiss();
                }
                AppMethodBeat.o(24004);
            }
        });
        AppMethodBeat.o(24028);
    }

    private void cLK() {
        AppMethodBeat.i(24029);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(24005);
                h.c(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.string.bym), ExdeviceDeviceProfileUI.this.getString(R.string.zb), true);
                AppMethodBeat.o(24005);
            }
        });
        AppMethodBeat.o(24029);
    }

    private void cLL() {
        AppMethodBeat.i(24030);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(24008);
                ExdeviceDeviceProfileUI exdeviceDeviceProfileUI = ExdeviceDeviceProfileUI.this;
                ExdeviceDeviceProfileUI.this.getString(R.string.zb);
                final q a2 = h.a((Context) exdeviceDeviceProfileUI, ExdeviceDeviceProfileUI.this.getString(R.string.bz0), false, (DialogInterface.OnCancelListener) null);
                new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(24007);
                        ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(24006);
                                a2.dismiss();
                                AppMethodBeat.o(24006);
                            }
                        });
                        AppMethodBeat.o(24007);
                        return true;
                    }
                }, false).startTimer(1000);
                AppMethodBeat.o(24008);
            }
        });
        AppMethodBeat.o(24030);
    }

    private void h(final com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(24031);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(24010);
                ExdeviceDeviceProfileUI.this.gxX = h.a((Context) ExdeviceDeviceProfileUI.this.getContext(), ExdeviceDeviceProfileUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.AnonymousClass5.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(24009);
                        bg.azz().a(qVar);
                        AppMethodBeat.o(24009);
                    }
                });
                AppMethodBeat.o(24010);
            }
        });
        AppMethodBeat.o(24031);
    }
}
