package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements i, MStorage.IOnStorageChange {
    private ProgressDialog gtM = null;
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(125556);
            MySafeDeviceListUI.this.screen.notifyDataSetChanged();
            super.handleMessage(message);
            AppMethodBeat.o(125556);
        }
    };
    private int kjd = -2;
    private List<SafeDeviceListPreference> kje;
    private a kjf;
    private List<d> kjg;
    private MenuItem.OnMenuItemClickListener kjh = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass1 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(125554);
            MySafeDeviceListUI.a(MySafeDeviceListUI.this);
            AppMethodBeat.o(125554);
            return true;
        }
    };
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MySafeDeviceListUI() {
        AppMethodBeat.i(125563);
        AppMethodBeat.o(125563);
    }

    static /* synthetic */ void g(MySafeDeviceListUI mySafeDeviceListUI) {
        AppMethodBeat.i(125573);
        mySafeDeviceListUI.boT();
        AppMethodBeat.o(125573);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125564);
        super.onCreate(bundle);
        g.azz().a(850, this);
        g.azz().a(361, this);
        com.tencent.mm.plugin.account.security.a.g.boR().add(this);
        initView();
        final b bVar = new b();
        g.azz().a(bVar, 0);
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125555);
                g.azz().a(bVar);
                AppMethodBeat.o(125555);
            }
        });
        AppMethodBeat.o(125564);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(125565);
        super.onDestroy();
        g.azz().b(850, this);
        g.azz().b(361, this);
        com.tencent.mm.plugin.account.security.a.g.boR().remove(this);
        AppMethodBeat.o(125565);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(125566);
        super.onResume();
        boT();
        AppMethodBeat.o(125566);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public class a implements SafeDeviceListPreference.a, SafeDeviceListPreference.b {
        private a() {
        }

        /* synthetic */ a(MySafeDeviceListUI mySafeDeviceListUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.b
        public final void onSucceed(String str) {
            AppMethodBeat.i(125561);
            MySafeDeviceListUI.this.screen.bmi(str);
            MySafeDeviceListUI.this.handler.sendEmptyMessage(0);
            MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(R.string.ga3), MySafeDeviceListUI.this.kjh);
            MySafeDeviceListUI.this.kjd ^= -1;
            MySafeDeviceListUI.g(MySafeDeviceListUI.this);
            AppMethodBeat.o(125561);
        }

        @Override // com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.a
        public final void Tp(String str) {
            AppMethodBeat.i(125562);
            Log.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed".concat(String.valueOf(str)));
            AppMethodBeat.o(125562);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(125568);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125559);
                MySafeDeviceListUI.this.finish();
                AppMethodBeat.o(125559);
                return true;
            }
        });
        this.screen = getPreferenceScreen();
        this.kje = new LinkedList();
        this.kjf = new a(this, (byte) 0);
        addTextOptionMenu(0, getString(R.string.ga3), this.kjh);
        setMMTitle(R.string.gq4);
        AppMethodBeat.o(125568);
    }

    private void boT() {
        AppMethodBeat.i(125569);
        this.kje.clear();
        this.kjg = com.tencent.mm.plugin.account.security.a.g.boR().boO();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.c3);
        if (this.kjg.size() == 0) {
            this.screen.bmi("my_safe_device_list_tip");
            showOptionMenu(false);
            AppMethodBeat.o(125569);
            return;
        }
        if (this.kjd == 1) {
            addTextOptionMenu(0, getString(R.string.ga3), this.kjh);
            this.kjd ^= -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        for (d dVar : this.kjg) {
            SafeDeviceListPreference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + dVar.field_uid);
            safeDeviceListPreference.setTitle(l.c(this, dVar.field_name));
            safeDeviceListPreference.setSummary(simpleDateFormat.format(new Date(dVar.field_createtime * 1000)));
            safeDeviceListPreference.kjp = this.kjf;
            safeDeviceListPreference.kjq = this.kjf;
            safeDeviceListPreference.kjm = dVar;
            this.screen.a(safeDeviceListPreference, -1);
            this.kje.add(safeDeviceListPreference);
        }
        showOptionMenu(true);
        AppMethodBeat.o(125569);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(125570);
        Log.i("MicroMsg.MySafeDeviceListUI", "notify ".concat(String.valueOf(str)));
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(125560);
                MySafeDeviceListUI.g(MySafeDeviceListUI.this);
                AppMethodBeat.o(125560);
            }
        });
        AppMethodBeat.o(125570);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        LinkedList<ckf> linkedList = null;
        AppMethodBeat.i(125571);
        Log.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", Integer.valueOf(i3), str, qVar);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() == 850) {
            if (i2 == 0 && i3 == 0) {
                b bVar = (b) qVar;
                if (!(bVar.kiN == null || bVar.kiN.MaW == null || bVar.kiN.MaW.MTs == null)) {
                    linkedList = bVar.kiN.MaW.MTs;
                }
                if (!(linkedList == null || linkedList == null)) {
                    com.tencent.mm.plugin.account.security.a.g.boR().execSQL("SafeDeviceInfo", "delete from SafeDeviceInfo");
                    for (ckf ckf : linkedList) {
                        com.tencent.mm.plugin.account.security.a.g.boR().a(new d(ckf));
                    }
                }
                AppMethodBeat.o(125571);
                return;
            }
        } else if (qVar.getType() == 361) {
            if (i2 == 0 && i3 == 0) {
                c cVar = (c) qVar;
                d dVar = new d();
                dVar.field_devicetype = cVar.dGP;
                dVar.field_name = cVar.deviceName;
                dVar.field_uid = cVar.dGL;
                dVar.field_createtime = 0;
                com.tencent.mm.plugin.account.security.a.g.boR().update(dVar, new String[0]);
                h.cD(this, com.tencent.mm.cb.a.aI(this, R.string.ga9));
                AppMethodBeat.o(125571);
                return;
            } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
                AppMethodBeat.o(125571);
                return;
            }
        }
        AppMethodBeat.o(125571);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        SafeDeviceListPreference safeDeviceListPreference;
        AppMethodBeat.i(125567);
        String str = preference.mKey;
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MySafeDeviceListUI", "null key");
            AppMethodBeat.o(125567);
            return false;
        }
        if (str.startsWith("mysafedevice_") && (safeDeviceListPreference = (SafeDeviceListPreference) preference) != null) {
            final d dVar = safeDeviceListPreference.kjm;
            h.a(getContext(), getString(R.string.ga5), dVar.field_name, getString(R.string.ga8), -1, new h.b() {
                /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.h.b
                public final boolean onFinish(CharSequence charSequence) {
                    AppMethodBeat.i(125558);
                    String trim = charSequence == null ? "" : charSequence.toString().trim();
                    if (trim.equals(dVar.field_name)) {
                        AppMethodBeat.o(125558);
                        return true;
                    } else if (trim.length() <= 0) {
                        h.cD(MySafeDeviceListUI.this.getContext(), MySafeDeviceListUI.this.getString(R.string.ga4));
                        AppMethodBeat.o(125558);
                        return false;
                    } else {
                        final c cVar = new c(dVar.field_uid, trim, dVar.field_devicetype);
                        g.azz().a(cVar, 0);
                        if (MySafeDeviceListUI.this.gtM != null) {
                            MySafeDeviceListUI.this.gtM.dismiss();
                        }
                        MySafeDeviceListUI.this.gtM = h.a((Context) MySafeDeviceListUI.this, com.tencent.mm.cb.a.aI(MySafeDeviceListUI.this, R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.AnonymousClass4.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125557);
                                g.azz().a(cVar);
                                AppMethodBeat.o(125557);
                            }
                        });
                        AppMethodBeat.o(125558);
                        return true;
                    }
                }
            });
        }
        AppMethodBeat.o(125567);
        return true;
    }

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        AppMethodBeat.i(125572);
        if (mySafeDeviceListUI.kje != null && mySafeDeviceListUI.kje.size() > 0) {
            mySafeDeviceListUI.kjd ^= -1;
            for (SafeDeviceListPreference safeDeviceListPreference : mySafeDeviceListUI.kje) {
                safeDeviceListPreference.mode = mySafeDeviceListUI.kjd;
                safeDeviceListPreference.initView();
            }
            mySafeDeviceListUI.screen.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.kjd == 1) {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.string.vl), mySafeDeviceListUI.kjh);
            AppMethodBeat.o(125572);
            return;
        }
        mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.string.ga3), mySafeDeviceListUI.kjh);
        AppMethodBeat.o(125572);
    }
}
