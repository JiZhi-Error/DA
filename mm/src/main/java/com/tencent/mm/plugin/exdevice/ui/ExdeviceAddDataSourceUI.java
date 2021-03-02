package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI extends MMActivity implements i, e.b {
    private q gxX;
    private ListView mListView;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(23845);
            if (intent == null) {
                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
                AppMethodBeat.o(23845);
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                    if (com.tencent.mm.plugin.d.a.e.a.ckP()) {
                        ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(23841);
                                if (!ExdeviceAddDataSourceUI.this.rFm || ExdeviceAddDataSourceUI.this.rFl.isProviderEnabled("gps")) {
                                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                                    Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                    AppMethodBeat.o(23841);
                                    return;
                                }
                                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 4);
                                AppMethodBeat.o(23841);
                            }
                        });
                        if (!ExdeviceAddDataSourceUI.this.rFm || ExdeviceAddDataSourceUI.this.rFl.isProviderEnabled("gps")) {
                            ad.cKW();
                            e.cKy();
                        }
                    }
                } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10 && !com.tencent.mm.plugin.d.a.e.a.ckP()) {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(23842);
                            ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                            AppMethodBeat.o(23842);
                        }
                    });
                    ad.cKX().stopScan();
                }
            }
            if (ExdeviceAddDataSourceUI.this.rFm && "android.location.MODE_CHANGED".equals(action)) {
                if (ExdeviceAddDataSourceUI.this.rFl.isProviderEnabled("gps")) {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass4.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(23843);
                            if (com.tencent.mm.plugin.d.a.e.a.ckP()) {
                                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                AppMethodBeat.o(23843);
                                return;
                            }
                            ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                            AppMethodBeat.o(23843);
                        }
                    });
                    if (com.tencent.mm.plugin.d.a.e.a.ckP()) {
                        ad.cKW();
                        e.cKy();
                        AppMethodBeat.o(23845);
                        return;
                    }
                } else {
                    ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass4.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(23844);
                            ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 4);
                            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                            AppMethodBeat.o(23844);
                        }
                    });
                    ad.cKX().stopScan();
                }
            }
            AppMethodBeat.o(23845);
        }
    };
    private a rFf;
    private List<b> rFg;
    private TextView rFh;
    private TextView rFi;
    private TextView rFj;
    private RelativeLayout rFk;
    private LocationManager rFl;
    private boolean rFm = false;
    private l rFn;
    private View rfF;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceAddDataSourceUI() {
        AppMethodBeat.i(23866);
        AppMethodBeat.o(23866);
    }

    static /* synthetic */ void a(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI, int i2) {
        AppMethodBeat.i(23876);
        exdeviceAddDataSourceUI.GA(i2);
        AppMethodBeat.o(23876);
    }

    static /* synthetic */ boolean anN(String str) {
        AppMethodBeat.i(23877);
        boolean aW = aW(str, true);
        AppMethodBeat.o(23877);
        return aW;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a47;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23867);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23837);
                ExdeviceAddDataSourceUI.this.finish();
                AppMethodBeat.o(23837);
                return true;
            }
        });
        setMMTitle(R.string.bya);
        if (d.oD(23) && !Build.VERSION.RELEASE.equalsIgnoreCase("6.0") && !Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            this.rFm = true;
        }
        this.rFg = new LinkedList();
        this.rFl = (LocationManager) getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        getContext().registerReceiver(this.mReceiver, intentFilter);
        bg.azz().a(536, this);
        bg.azz().a(1706, this);
        ad.cKW().a(this);
        if (!com.tencent.mm.plugin.d.a.e.a.eL(getContext())) {
            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", Integer.valueOf(Build.VERSION.SDK_INT));
            GA(2);
            AppMethodBeat.o(23867);
        } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            GA(1);
            AppMethodBeat.o(23867);
        } else if (this.rFl == null || !this.rFm || this.rFl.isProviderEnabled("gps")) {
            try {
                ad.cKW();
                e.cKy();
                AppMethodBeat.o(23867);
            } catch (Exception e2) {
                AppMethodBeat.o(23867);
            }
        } else {
            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            GA(4);
            AppMethodBeat.o(23867);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void GA(int i2) {
        AppMethodBeat.i(23868);
        switch (i2) {
            case 1:
                this.rFk.setVisibility(8);
                this.rFi.setText(R.string.bz1);
                this.rFj.setText(R.string.byl);
                AppMethodBeat.o(23868);
                return;
            case 2:
                this.rFk.setVisibility(8);
                this.rFi.setText(R.string.byz);
                this.rFj.setText("");
                AppMethodBeat.o(23868);
                return;
            case 3:
                this.rFk.setVisibility(0);
                this.rfF.setVisibility(0);
                break;
            case 4:
                this.rFk.setVisibility(8);
                this.rFi.setText(R.string.bz1);
                this.rFj.setText(R.string.c0b);
                AppMethodBeat.o(23868);
                return;
        }
        AppMethodBeat.o(23868);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(23869);
        this.mListView = (ListView) findViewById(R.id.ed2);
        View inflate = View.inflate(this, R.layout.a49, null);
        this.rFk = (RelativeLayout) findViewById(R.id.hd5);
        this.rfF = View.inflate(this, R.layout.a48, null);
        this.rFh = (TextView) findViewById(R.id.h_s);
        this.rFi = (TextView) findViewById(R.id.c4e);
        this.rFj = (TextView) findViewById(R.id.c4f);
        String string = getString(R.string.c1v);
        String string2 = getString(R.string.bzf);
        SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan((int) R.color.x0), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new ClickableSpan() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(23846);
                f.ay(ExdeviceAddDataSourceUI.this.getContext(), HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1l) + "/steprank/step/connect-help.html");
                AppMethodBeat.o(23846);
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(23847);
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(23847);
            }
        }, string.length(), string.length() + string2.length(), 33);
        this.rFh.setMovementMethod(LinkMovementMethod.getInstance());
        this.rFh.setText(spannableString);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(this.rfF, null, false);
        this.rFf = new a();
        this.mListView.setAdapter((ListAdapter) this.rFf);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass6 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(23848);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                b GB = ExdeviceAddDataSourceUI.this.rFf.GB(i2 - ((ListView) adapterView).getHeaderViewsCount());
                if (GB.rFv != c.NORMAL) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(23848);
                } else if (!ExdeviceAddDataSourceUI.anN(GB.mac)) {
                    Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(23848);
                } else {
                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, GB.mac);
                    GB.rFv = c.ADDING;
                    ExdeviceAddDataSourceUI.this.rFf.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(23848);
                }
            }
        });
        AppMethodBeat.o(23869);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(23870);
        super.onDestroy();
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(23849);
                Log.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
                EventCenter.instance.publish(new wz());
                AppMethodBeat.o(23849);
            }
        });
        bg.azz().b(536, this);
        bg.azz().b(1706, this);
        getContext().unregisterReceiver(this.mReceiver);
        ad.cKW().b(this);
        ad.cKX().stopScan();
        AppMethodBeat.o(23870);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(23871);
        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar == null) {
            Log.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
            AppMethodBeat.o(23871);
        } else if (qVar.getType() == 536) {
            cLD();
            this.rFn = null;
            mc cKE = ((l) qVar).cKE();
            if (i2 == 0 && i3 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", com.tencent.mm.plugin.exdevice.k.b.anY(com.tencent.mm.plugin.exdevice.k.b.anZ(cKE.KPE.KOS)));
                aW(com.tencent.mm.plugin.exdevice.k.b.anZ(cKE.KPE.KOS), false);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(23871);
                return;
            }
            b anO = this.rFf.anO(com.tencent.mm.plugin.exdevice.k.b.anZ(cKE.KPE.KOS));
            if (anO != null) {
                anO.rFv = c.NORMAL;
                aW(anO.mac, false);
            }
            Log.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
            AppMethodBeat.o(23871);
        } else {
            if (qVar.getType() == 1706) {
                drm cKH = ((t) qVar).cKH();
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", Long.valueOf(cKH.KPE.fMg));
                    if (0 != (cKH.KPE.fMg & 1)) {
                        if (ad.cKL().gb(cKH.KPD.oTH, cKH.KPD.KLO) != null) {
                            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", cKH.KPE.KOS);
                            AppMethodBeat.o(23871);
                            return;
                        }
                        b bVar = new b((byte) 0);
                        bVar.name = cKH.KOY.Mjj == null ? "" : z.a(cKH.KOY.Mjj);
                        bVar.mac = com.tencent.mm.plugin.exdevice.k.b.anZ(cKH.KPE.KOS);
                        bVar.dHx = cKH.KOX;
                        bVar.iconUrl = cKH.KPE.IconUrl;
                        this.rFg.add(bVar);
                        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", bVar.mac, bVar.name);
                        runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass8 */

                            public final void run() {
                                AppMethodBeat.i(23850);
                                ExdeviceAddDataSourceUI.this.rFf.ad(ExdeviceAddDataSourceUI.this.rFg);
                                ExdeviceAddDataSourceUI.this.rFf.notifyDataSetChanged();
                                AppMethodBeat.o(23850);
                            }
                        });
                    }
                } else {
                    Log.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(23871);
                    return;
                }
            }
            AppMethodBeat.o(23871);
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.model.e.b
    public final void p(String str, String str2, boolean z) {
        int i2;
        AppMethodBeat.i(23872);
        Log.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (z) {
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(23851);
                    ExdeviceAddDataSourceUI.this.rfF.setVisibility(8);
                    ExdeviceAddDataSourceUI.this.rFf.notifyDataSetChanged();
                    AppMethodBeat.o(23851);
                }
            });
        }
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            AppMethodBeat.o(23872);
            return;
        }
        int i3 = 0;
        while (i3 < this.rFg.size()) {
            b bVar = this.rFg.get(i3);
            if (bVar == null || Util.isNullOrNil(bVar.mac)) {
                i2 = i3 - 1;
                this.rFg.remove(i3);
            } else if (bVar.mac.equalsIgnoreCase(str2)) {
                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", str2);
                AppMethodBeat.o(23872);
                return;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", Boolean.valueOf(bg.azz().a(new t(str2.replaceAll(":", ""), null, null), 0)), str2);
        AppMethodBeat.o(23872);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.e.b
    public final void c(String str, int i2, long j2) {
        AppMethodBeat.i(23873);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            AppMethodBeat.o(23873);
            return;
        }
        final b anO = this.rFf.anO(str);
        if (anO == null) {
            Log.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", str);
            AppMethodBeat.o(23873);
            return;
        }
        if (anO.rFv == c.ADDING && i2 == 4) {
            anO.rFv = c.NORMAL;
            cLD();
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(23854);
                    h.a((Context) ExdeviceAddDataSourceUI.this, (int) R.string.bzi, (int) R.string.bzg, (int) R.string.bzh, (int) R.string.bzj, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass10.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(23852);
                            ExdeviceAddDataSourceUI.this.rFg.remove(anO);
                            ExdeviceAddDataSourceUI.this.rFf.ad(ExdeviceAddDataSourceUI.this.rFg);
                            ExdeviceAddDataSourceUI.this.rFf.notifyDataSetChanged();
                            AppMethodBeat.o(23852);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass10.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(23853);
                            f.ay(ExdeviceAddDataSourceUI.this.getContext(), HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1l) + "/steprank/step/connect-help.html");
                            AppMethodBeat.o(23853);
                        }
                    }).show();
                    AppMethodBeat.o(23854);
                }
            });
        } else if (i2 == 2) {
            if (anO.rFv == c.ADDING) {
                anO.rFv = c.ADDED;
                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", anO.mac, anO.name);
                if (anO.dHx != null) {
                    this.rFn = new l(anO.dHx, 0);
                    bg.azz().a(this.rFn, 0);
                }
            } else {
                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", str);
                aW(str, false);
            }
        } else if (i2 == 1 || i2 == 2) {
            AppMethodBeat.o(23873);
            return;
        } else {
            anO.rFv = c.NORMAL;
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(23855);
                ExdeviceAddDataSourceUI.this.rFf.notifyDataSetChanged();
                AppMethodBeat.o(23855);
            }
        });
        AppMethodBeat.o(23873);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.e.b
    public final void b(String str, byte[] bArr, boolean z) {
    }

    private static boolean aW(String str, boolean z) {
        AppMethodBeat.i(23874);
        fd fdVar = new fd();
        fdVar.dIz.mac = str;
        fdVar.dIz.dGW = z;
        if (!EventCenter.instance.publish(fdVar)) {
            Log.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", str);
            AppMethodBeat.o(23874);
            return false;
        }
        AppMethodBeat.o(23874);
        return true;
    }

    private void cLD() {
        AppMethodBeat.i(23875);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(23838);
                if (ExdeviceAddDataSourceUI.this.gxX != null && ExdeviceAddDataSourceUI.this.gxX.isShowing()) {
                    ExdeviceAddDataSourceUI.this.gxX.dismiss();
                }
                AppMethodBeat.o(23838);
            }
        });
        AppMethodBeat.o(23875);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String dHx;
        public String iconUrl;
        String mac;
        String name;
        c rFv;

        private b() {
            this.rFv = c.NORMAL;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends BaseAdapter {
        private List<b> rFg = new LinkedList();
        private com.tencent.mm.av.a.a.c rFu;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(23862);
            b GB = GB(i2);
            AppMethodBeat.o(23862);
            return GB;
        }

        public a() {
            AppMethodBeat.i(23856);
            c.a aVar = new c.a();
            aVar.jbq = R.drawable.c69;
            this.rFu = aVar.bdv();
            AppMethodBeat.o(23856);
        }

        public final void ad(List<b> list) {
            AppMethodBeat.i(23857);
            this.rFg.clear();
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(23857);
                return;
            }
            this.rFg.addAll(list);
            AppMethodBeat.o(23857);
        }

        public final b anO(String str) {
            AppMethodBeat.i(23858);
            if (!Util.isNullOrNil(str)) {
                for (b bVar : this.rFg) {
                    if (str.equalsIgnoreCase(bVar.mac)) {
                        AppMethodBeat.o(23858);
                        return bVar;
                    }
                }
            }
            AppMethodBeat.o(23858);
            return null;
        }

        public final int getCount() {
            AppMethodBeat.i(23859);
            int size = this.rFg.size();
            AppMethodBeat.o(23859);
            return size;
        }

        public final b GB(int i2) {
            AppMethodBeat.i(23860);
            b bVar = this.rFg.get(i2);
            AppMethodBeat.o(23860);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0998a aVar;
            AppMethodBeat.i(23861);
            b GB = GB(i2);
            if (view == null) {
                C0998a aVar2 = new C0998a((byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.a46, null);
                aVar2.nnL = (ImageView) view.findViewById(R.id.dtb);
                aVar2.kgE = (TextView) view.findViewById(R.id.ft9);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C0998a) view.getTag();
            }
            Log.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i2), GB.name, GB.mac);
            aVar.kgE.setText(GB.name);
            com.tencent.mm.av.q.bcV().a(GB.iconUrl, aVar.nnL, this.rFu);
            AppMethodBeat.o(23861);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI$a$a  reason: collision with other inner class name */
        static class C0998a {
            TextView kgE;
            ImageView nnL;

            private C0998a() {
            }

            /* synthetic */ C0998a(byte b2) {
                this();
            }
        }
    }

    enum c {
        NORMAL,
        ADDING,
        ADDED;

        public static c valueOf(String str) {
            AppMethodBeat.i(23864);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(23864);
            return cVar;
        }

        static {
            AppMethodBeat.i(23865);
            AppMethodBeat.o(23865);
        }
    }

    static /* synthetic */ void a(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI, final String str) {
        AppMethodBeat.i(23878);
        exdeviceAddDataSourceUI.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(23840);
                ExdeviceAddDataSourceUI.this.gxX = h.a((Context) ExdeviceAddDataSourceUI.this.getContext(), ExdeviceAddDataSourceUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.AnonymousClass3.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(23839);
                        bg.azz().a(ExdeviceAddDataSourceUI.this.rFn);
                        ExdeviceAddDataSourceUI.this.rFn = null;
                        b anO = ExdeviceAddDataSourceUI.this.rFf.anO(str);
                        if (anO != null) {
                            anO.rFv = c.NORMAL;
                        }
                        AppMethodBeat.o(23839);
                    }
                });
                AppMethodBeat.o(23840);
            }
        });
        AppMethodBeat.o(23878);
    }
}
