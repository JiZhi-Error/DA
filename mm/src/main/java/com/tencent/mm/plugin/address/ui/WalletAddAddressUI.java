package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.plugin.address.ui.AddrEditView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.List;

public class WalletAddAddressUI extends MMActivity implements i, AddrEditView.b {
    private String dWN = "";
    private int ktp = 0;
    private AddrEditView kuS;
    private AddrEditView kuT;
    private AddrEditView kuU;
    private AddrEditView kuV;
    private AddrEditView kuW;
    private b kuX = null;
    private b kuY = new b();
    private boolean kuZ;
    private Dialog tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletAddAddressUI() {
        AppMethodBeat.i(20988);
        AppMethodBeat.o(20988);
    }

    static /* synthetic */ void a(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(21001);
        walletAddAddressUI.bqp();
        AppMethodBeat.o(21001);
    }

    static /* synthetic */ void b(b bVar, b bVar2) {
        AppMethodBeat.i(21006);
        a(bVar, bVar2);
        AppMethodBeat.o(21006);
    }

    static /* synthetic */ void b(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(21002);
        walletAddAddressUI.bqq();
        AppMethodBeat.o(21002);
    }

    static /* synthetic */ void d(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(21004);
        walletAddAddressUI.bqi();
        AppMethodBeat.o(21004);
    }

    static /* synthetic */ boolean e(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(21005);
        boolean bqg = walletAddAddressUI.bqg();
        AppMethodBeat.o(21005);
        return bqg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20989);
        super.onCreate(bundle);
        bg.azz().a(415, this);
        bg.azz().a(418, this);
        Log.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        Log.setLevel(0, false);
        this.ktp = getIntent().getIntExtra("address_id", 0);
        if (this.ktp == 0) {
            setMMTitle(R.string.e1);
        } else {
            setMMTitle(R.string.fh);
        }
        initView();
        AppMethodBeat.o(20989);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(20990);
        a.bqd().bqe();
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.ji9);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.kuS = (AddrEditView) findViewById(R.id.hi);
        this.kuT = (AddrEditView) findViewById(R.id.h6);
        this.kuU = (AddrEditView) findViewById(R.id.h7);
        this.kuV = (AddrEditView) findViewById(R.id.hu);
        this.kuW = (AddrEditView) findViewById(R.id.hk);
        this.kuZ = getIntent().getBooleanExtra("force_light_mode", false);
        if (this.kuZ) {
            findViewById(R.id.ji9).setBackgroundResource(R.color.am);
            this.kuS.bqk();
            this.kuT.bqk();
            this.kuU.bqk();
            this.kuV.bqk();
            this.kuW.bqk();
            setActionbarColor(getContext().getResources().getColor(R.color.af));
            setNavigationbarColor(getContext().getResources().getColor(R.color.af));
        }
        this.kuS.setOnInputValidChangeListener(this);
        this.kuT.setOnInputValidChangeListener(this);
        this.kuU.setOnInputValidChangeListener(this);
        this.kuV.setOnInputValidChangeListener(this);
        this.kuW.setOnInputValidChangeListener(this);
        this.kuS.setInfoIvOnClickListener(new AddrEditView.a() {
            /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.address.ui.AddrEditView.a
            public final void onClick() {
                AppMethodBeat.i(20976);
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, (String) null, (String) null);
                Log.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a2), Util.getStack());
                if (!a2) {
                    AppMethodBeat.o(20976);
                    return;
                }
                WalletAddAddressUI.a(WalletAddAddressUI.this);
                AppMethodBeat.o(20976);
            }
        });
        this.kuT.setInfoIvOnClickListener(new AddrEditView.a() {
            /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.address.ui.AddrEditView.a
            public final void onClick() {
                AppMethodBeat.i(20981);
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 64, (String) null, (String) null);
                Log.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    AppMethodBeat.o(20981);
                    return;
                }
                WalletAddAddressUI.b(WalletAddAddressUI.this);
                AppMethodBeat.o(20981);
            }
        });
        this.kuT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(20982);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletAddAddressUI.c(WalletAddAddressUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20982);
            }
        });
        if (this.ktp != 0) {
            this.kuX = a.bqd().vp(this.ktp);
            if (this.kuX == null) {
                Log.w("MicroMsg.WalletAddAddressUI", "addr is null");
                finish();
                AppMethodBeat.o(20990);
                return;
            }
            this.kuS.setValStr(this.kuX.ktm);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.kuX.kth)) {
                sb.append(this.kuX.kth);
            }
            if (!TextUtils.isEmpty(this.kuX.kti)) {
                sb.append(" ");
                sb.append(this.kuX.kti);
            }
            if (!TextUtils.isEmpty(this.kuX.ktj)) {
                sb.append(" ");
                sb.append(this.kuX.ktj);
            }
            this.kuT.setValStr(sb.toString());
            this.kuU.setValStr(this.kuX.ktl);
            this.kuV.setValStr(this.kuX.ktk);
            this.kuW.setValStr(this.kuX.ktn);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20983);
                WalletAddAddressUI.d(WalletAddAddressUI.this);
                AppMethodBeat.o(20983);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20984);
                if (!WalletAddAddressUI.e(WalletAddAddressUI.this)) {
                    AppMethodBeat.o(20984);
                } else {
                    if (WalletAddAddressUI.this.ktp != 0) {
                        WalletAddAddressUI.this.kuX = a.bqd().vp(WalletAddAddressUI.this.ktp);
                        Log.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.this.kuX.toString());
                        WalletAddAddressUI.b(WalletAddAddressUI.this.kuX, WalletAddAddressUI.this.kuY);
                    } else {
                        WalletAddAddressUI.this.kuX = new b();
                    }
                    String text = WalletAddAddressUI.this.kuS.getText();
                    String text2 = WalletAddAddressUI.this.kuT.getText();
                    String text3 = WalletAddAddressUI.this.kuU.getText();
                    String text4 = WalletAddAddressUI.this.kuV.getText();
                    String text5 = WalletAddAddressUI.this.kuW.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        WalletAddAddressUI.this.kuY.kth = split[0];
                    }
                    if (split.length >= 2) {
                        WalletAddAddressUI.this.kuY.kti = split[1];
                    }
                    if (split.length >= 3) {
                        WalletAddAddressUI.this.kuY.ktj = split[2];
                    } else {
                        WalletAddAddressUI.this.kuY.ktj = "";
                    }
                    WalletAddAddressUI.this.kuY.ktl = text3;
                    WalletAddAddressUI.this.kuY.ktm = text;
                    WalletAddAddressUI.this.kuY.ktn = text5;
                    WalletAddAddressUI.this.kuY.ktk = text4;
                    if (!Util.isNullOrNil(WalletAddAddressUI.this.dWN)) {
                        WalletAddAddressUI.this.kuY.kto = WalletAddAddressUI.this.dWN;
                    }
                    WalletAddAddressUI.o(WalletAddAddressUI.this);
                    AppMethodBeat.o(20984);
                }
                return true;
            }
        }, null, t.b.GREEN);
        bqg();
        AppMethodBeat.o(20990);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(20991);
        super.onDestroy();
        bg.azz().b(415, this);
        bg.azz().b(418, this);
        l bqd = a.bqd();
        Log.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List<RcptItem> list : bqd.kta.values()) {
            list.clear();
        }
        for (List<RcptItem> list2 : bqd.ktb.values()) {
            list2.clear();
        }
        bqd.ksZ.clear();
        bqd.kta.clear();
        bqd.ktb.clear();
        AppMethodBeat.o(20991);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        RcptItem rcptItem;
        String str;
        String str2;
        AppMethodBeat.i(20992);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!Util.isNullOrNil(stringExtra)) {
                        Log.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.kuT.setValStr(stringExtra);
                    }
                    String stringExtra2 = intent.getStringExtra("kpost_code");
                    if (!Util.isNullOrNil(stringExtra2)) {
                        Log.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(stringExtra2)));
                        this.kuV.setValStr(stringExtra2);
                    }
                    this.dWN = intent.getStringExtra("kwcode");
                    AppMethodBeat.o(20992);
                    return;
                }
                break;
            case 2:
                if (i3 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        Log.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        AppMethodBeat.o(20992);
                        return;
                    }
                    String[] i4 = com.tencent.mm.pluginsdk.b.i(getBaseContext(), data);
                    if (i4 == null || i4.length != 2) {
                        h.c(this, getString(R.string.gc), "", true);
                        str = null;
                        str2 = null;
                    } else {
                        str = i4[0];
                        str2 = i4[1];
                    }
                    this.kuS.setValStr(str);
                    this.kuW.setValStr(str2);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                        bqg();
                        AppMethodBeat.o(20992);
                        return;
                    }
                    h.c(this, getString(R.string.gc), "", true);
                    AppMethodBeat.o(20992);
                    return;
                }
                break;
            case 3:
                if (i3 != -1) {
                    Log.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                    break;
                } else {
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    if (addr != null) {
                        Log.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                        if (addr != null) {
                            String str3 = addr.iUR;
                            if (Util.isNullOrNil(str3)) {
                                str3 = addr.iUQ;
                            }
                            if (a.bqd().y(addr.iUP, str3, addr.iUS)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(addr.iUP);
                                sb.append(" ");
                                sb.append(str3);
                                if (!TextUtils.isEmpty(addr.iUS)) {
                                    sb.append(" ");
                                    sb.append(addr.iUS);
                                }
                                this.kuT.setValStr(sb.toString());
                            } else {
                                this.kuT.setValStr("");
                            }
                            StringBuilder sb2 = new StringBuilder();
                            if (!TextUtils.isEmpty(addr.iUT)) {
                                sb2.append(addr.iUT);
                            }
                            if (!TextUtils.isEmpty(addr.iUU)) {
                                sb2.append(addr.iUU);
                            }
                            if (!TextUtils.isEmpty(addr.iUV)) {
                                sb2.append(addr.iUV);
                            }
                            if (!TextUtils.isEmpty(addr.iUX)) {
                                sb2.append(" ");
                                sb2.append(addr.iUX);
                            }
                            if (!Util.isNullOrNil(addr.iUX) || Util.isNullOrNil(addr.iUO)) {
                                this.kuU.setValStr(sb2.toString());
                            } else {
                                this.kuU.setValStr(addr.iUO);
                            }
                            RcptItem x = a.bqd().x(addr.iUP, addr.iUR, addr.iUS);
                            if (x == null) {
                                rcptItem = a.bqd().x(addr.iUP, addr.iUQ, addr.iUS);
                            } else {
                                rcptItem = x;
                            }
                            if (rcptItem != null) {
                                this.kuV.setValStr(rcptItem.ksV);
                                this.dWN = rcptItem.code;
                            }
                        }
                    }
                    AppMethodBeat.o(20992);
                    return;
                }
        }
        AppMethodBeat.o(20992);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7c;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(20993);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.address.d.a aVar = a.bqd().ksX;
            if (aVar.ktf.size() > 0) {
                a(this.kuY, this.kuX);
                b first = aVar.ktf.getFirst();
                if (first != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(first));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            AppMethodBeat.o(20993);
            return;
        }
        switch (i3) {
            case -3104:
            case -3103:
            case -3102:
                h.d(this, str, "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(20986);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(20986);
                    }
                });
                AppMethodBeat.o(20993);
                return;
            case -3101:
            default:
                h.a((Context) this, (int) R.string.dy, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass14 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(20993);
                return;
            case -3100:
                h.a((Context) this, (int) R.string.e0, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass12 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(20985);
                        WalletAddAddressUI.this.finish();
                        AppMethodBeat.o(20985);
                    }
                });
                AppMethodBeat.o(20993);
                return;
        }
    }

    private boolean bqg() {
        boolean z = false;
        AppMethodBeat.i(20994);
        boolean z2 = true;
        if (!this.kuS.bql()) {
            z2 = false;
        }
        if (!this.kuU.bql()) {
            z2 = false;
        }
        if (!this.kuT.bql()) {
            z2 = false;
        }
        if (!this.kuV.bql()) {
            z2 = false;
        }
        if (this.kuW.bql()) {
            z = z2;
        }
        enableOptionMenu(z);
        AppMethodBeat.o(20994);
        return z;
    }

    @Override // com.tencent.mm.plugin.address.ui.AddrEditView.b
    public final void bqh() {
        AppMethodBeat.i(20995);
        bqg();
        AppMethodBeat.o(20995);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(20996);
        if (i2 == 4) {
            bqi();
            AppMethodBeat.o(20996);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(20996);
        return onKeyUp;
    }

    private void bqi() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20997);
        int i2 = R.string.e4;
        if (this.ktp == 0) {
            i2 = R.string.e3;
        }
        if (this.kuS.bqm()) {
            z = true;
        } else {
            z = false;
        }
        if (this.kuU.bqm()) {
            z = true;
        }
        if (this.kuT.bqm()) {
            z = true;
        }
        if (this.kuV.bqm()) {
            z = true;
        }
        if (!this.kuW.bqm()) {
            z2 = z;
        }
        if (z2) {
            h.a(this, i2, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(20987);
                    WalletAddAddressUI.this.setResult(0);
                    WalletAddAddressUI.this.finish();
                    AppMethodBeat.o(20987);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(20997);
            return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(20997);
    }

    private void bqp() {
        AppMethodBeat.i(20998);
        Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        if (Util.isIntentAvailable(this, intent)) {
            startActivityForResult(intent, 2);
            AppMethodBeat.o(20998);
            return;
        }
        Log.w("MicroMsg.WalletAddAddressUI", "intent not available");
        AppMethodBeat.o(20998);
    }

    private void bqq() {
        AppMethodBeat.i(20999);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.kuT.getText())) {
            sb.append(this.kuT.getText());
        }
        if (!TextUtils.isEmpty(this.kuU.getText())) {
            sb.append(this.kuU.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", sb.toString());
        intent.putExtra("map_view_type", 8);
        intent.putExtra("type_tag", -1);
        c.b(this, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 3);
        AppMethodBeat.o(20999);
    }

    private static void a(b bVar, b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.kth = bVar.kth;
            bVar2.kti = bVar.kti;
            bVar2.ktj = bVar.ktj;
            bVar2.ktl = bVar.ktl;
            bVar2.ktm = bVar.ktm;
            bVar2.ktn = bVar.ktn;
            bVar2.ktk = bVar.ktk;
            bVar2.kto = bVar.kto;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(21000);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(21000);
            return;
        }
        Log.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (iArr[0] == 0) {
                    bqp();
                    AppMethodBeat.o(21000);
                    return;
                }
                h.a((Context) this, getString(R.string.fl2), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(20977);
                        dialogInterface.dismiss();
                        WalletAddAddressUI walletAddAddressUI = WalletAddAddressUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(walletAddAddressUI, bl.axQ(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletAddAddressUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletAddAddressUI, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(20977);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(20978);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(20978);
                    }
                });
                AppMethodBeat.o(21000);
                return;
            case 64:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(20979);
                            dialogInterface.dismiss();
                            WalletAddAddressUI walletAddAddressUI = WalletAddAddressUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(walletAddAddressUI, bl.axQ(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            walletAddAddressUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(walletAddAddressUI, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(20979);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(20980);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(20980);
                        }
                    });
                    break;
                } else {
                    bqq();
                    AppMethodBeat.o(21000);
                    return;
                }
        }
        AppMethodBeat.o(21000);
    }

    static /* synthetic */ void c(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(21003);
        walletAddAddressUI.startActivityForResult(new Intent(walletAddAddressUI, WalletMultiRcptSelectUI.class), 1);
        AppMethodBeat.o(21003);
    }

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        AppMethodBeat.i(21007);
        if (walletAddAddressUI.ktp != 0) {
            Log.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.kuY.toString());
            a.bqd().bqf();
            bg.azz().a(new com.tencent.mm.plugin.address.model.h(walletAddAddressUI.kuY), 0);
            walletAddAddressUI.tipDialog = h.a((Context) walletAddAddressUI, "", true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.o(21007);
            return;
        }
        Log.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.kuY.toString());
        bg.azz().a(new com.tencent.mm.plugin.address.model.c(walletAddAddressUI.kuY), 0);
        walletAddAddressUI.tipDialog = h.a((Context) walletAddAddressUI, "", true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletAddAddressUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(21007);
    }
}
