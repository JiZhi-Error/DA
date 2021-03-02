package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements i {
    private String HP;
    private Button krs;
    private String mDeviceType;
    private ListView mListView;
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(23882);
            Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
            if (intent == null) {
                AppMethodBeat.o(23882);
                return;
            }
            String action = intent.getAction();
            Log.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", action);
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && ExdeviceBindDeviceGuideUI.this.rFO) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra != 12) {
                    if (intExtra == 10) {
                        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
                    }
                    AppMethodBeat.o(23882);
                    return;
                } else if (!ExdeviceBindDeviceGuideUI.this.rFm || ExdeviceBindDeviceGuideUI.this.rFl.isProviderEnabled("gps")) {
                    ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
                    AppMethodBeat.o(23882);
                    return;
                }
            } else if (!"android.net.wifi.WIFI_STATE_CHANGED".equals(action) || !ExdeviceBindDeviceGuideUI.this.rFN) {
                if (ExdeviceBindDeviceGuideUI.this.rFm && "android.location.MODE_CHANGED".equals(action)) {
                    if (ExdeviceBindDeviceGuideUI.this.rFl.isProviderEnabled("gps")) {
                        if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
                            AppMethodBeat.o(23882);
                            return;
                        }
                        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
                        AppMethodBeat.o(23882);
                        return;
                    }
                }
                AppMethodBeat.o(23882);
            } else {
                int intExtra2 = intent.getIntExtra("wifi_state", -1);
                Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", Integer.valueOf(intExtra2));
                if (intExtra2 == 3) {
                    ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 1);
                    AppMethodBeat.o(23882);
                    return;
                }
                if (intExtra2 == 1) {
                    ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 5);
                }
                AppMethodBeat.o(23882);
                return;
            }
            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 6);
            AppMethodBeat.o(23882);
        }
    };
    private String mTitle;
    private a rFA;
    private Button rFB;
    private TextView rFC;
    private ScrollView rFD;
    private ImageView rFE;
    private TextView rFF;
    private String rFG;
    private String rFH;
    private String rFI;
    private String rFJ;
    private long rFK;
    private ArrayList<String> rFL;
    private String rFM;
    private boolean rFN = false;
    private boolean rFO = false;
    private String rFd;
    private TextView rFi;
    private LocationManager rFl;
    private boolean rFm = false;
    private String rcG;
    private String rzn;
    private String rzo;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceBindDeviceGuideUI() {
        AppMethodBeat.i(23887);
        AppMethodBeat.o(23887);
    }

    static /* synthetic */ void a(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI, int i2) {
        AppMethodBeat.i(23891);
        exdeviceBindDeviceGuideUI.GA(i2);
        AppMethodBeat.o(23891);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4b;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23888);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23879);
                ExdeviceBindDeviceGuideUI.this.finish();
                AppMethodBeat.o(23879);
                return true;
            }
        });
        if (d.oD(23) && !Build.VERSION.RELEASE.equalsIgnoreCase("6.0") && !Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", Build.VERSION.RELEASE);
            this.rFm = true;
        }
        Intent intent = getIntent();
        this.rFG = intent.getStringExtra("device_scan_mode");
        this.rFH = intent.getStringExtra("device_scan_conn_proto");
        this.rzo = intent.getStringExtra(TPDownloadProxyEnum.USER_DEVICE_ID);
        this.mDeviceType = intent.getStringExtra("device_type");
        this.rFI = intent.getStringExtra("device_title");
        this.rFd = intent.getStringExtra("device_desc");
        this.rcG = intent.getStringExtra("device_icon_url");
        this.HP = intent.getStringExtra("device_category_id");
        this.rzn = intent.getStringExtra("device_brand_name");
        this.rFJ = intent.getStringExtra("bind_ticket");
        this.rFK = intent.getLongExtra("device_ble_simple_proto", -1);
        this.rFL = intent.getStringArrayListExtra("device_airkiss_steps");
        this.rFM = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", Integer.valueOf(this.rFL.size()));
        this.rFl = (LocationManager) getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
        this.mListView = (ListView) findViewById(R.id.beb);
        View inflate = View.inflate(this, R.layout.a45, null);
        this.rFC = (TextView) inflate.findViewById(R.id.ipp);
        this.rFA = new a(this.rFL);
        this.mListView.addHeaderView(inflate);
        this.mListView.setDividerHeight(0);
        this.mListView.setClickable(false);
        this.mListView.setFooterDividersEnabled(false);
        this.mListView.setAdapter((ListAdapter) this.rFA);
        this.rFE = (ImageView) findViewById(R.id.esk);
        this.rFD = (ScrollView) findViewById(R.id.dmk);
        this.rFB = (Button) findViewById(R.id.b_p);
        this.krs = (Button) findViewById(R.id.fyz);
        this.rFi = (TextView) findViewById(R.id.c4e);
        this.rFF = (TextView) findViewById(R.id.c4f);
        String str = "";
        if (this.rFG.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.rFH.contains("wifi")) {
            this.rFN = true;
            str = getContext().getString(R.string.bzl);
        } else if (this.rFH.contains("blue")) {
            this.rFO = true;
            str = getContext().getString(R.string.byp);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.rFO && !this.rFN) {
            if (!com.tencent.mm.plugin.d.a.e.a.eL(getContext())) {
                Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", Integer.valueOf(Build.VERSION.SDK_INT));
                GA(4);
            } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                GA(3);
            } else if (this.rFl != null && this.rFm && !this.rFl.isProviderEnabled("gps")) {
                Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                GA(6);
            }
            this.rFB.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23880);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                    intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                    intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                    intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                    intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                    intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                    intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                    intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                    intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                    intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                    intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.rFK);
                    intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.rFM);
                    intent.putExtra("jumpToBindDevice", true);
                    if (ExdeviceBindDeviceGuideUI.this.rFO && !ExdeviceBindDeviceGuideUI.this.rFN) {
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23880);
                }
            });
            this.krs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23881);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                        intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23881);
                }
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            getContext().registerReceiver(this.mReceiver, intentFilter);
            AppMethodBeat.o(23888);
        }
        if (!this.rFO && this.rFN && !NetStatusUtil.isWifi(getContext())) {
            Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            GA(5);
            this.rFB.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23880);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                    intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                    intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                    intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                    intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                    intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                    intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                    intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                    intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                    intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                    intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.rFK);
                    intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.rFM);
                    intent.putExtra("jumpToBindDevice", true);
                    if (ExdeviceBindDeviceGuideUI.this.rFO && !ExdeviceBindDeviceGuideUI.this.rFN) {
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23880);
                }
            });
            this.krs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23881);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                        intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23881);
                }
            });
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter2.addAction("android.location.MODE_CHANGED");
            getContext().registerReceiver(this.mReceiver, intentFilter2);
            AppMethodBeat.o(23888);
        } else if (!this.rFN || this.rFO) {
            if (this.rFO && !this.rFN) {
                GA(2);
            }
            this.rFB.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23880);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                    intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                    intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                    intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                    intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                    intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                    intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                    intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                    intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                    intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                    intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.rFK);
                    intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.rFM);
                    intent.putExtra("jumpToBindDevice", true);
                    if (ExdeviceBindDeviceGuideUI.this.rFO && !ExdeviceBindDeviceGuideUI.this.rFN) {
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23880);
                }
            });
            this.krs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23881);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                        intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23881);
                }
            });
            IntentFilter intentFilter22 = new IntentFilter();
            intentFilter22.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter22.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter22.addAction("android.location.MODE_CHANGED");
            getContext().registerReceiver(this.mReceiver, intentFilter22);
            AppMethodBeat.o(23888);
        } else {
            GA(1);
            this.rFB.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23880);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                    intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                    intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                    intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                    intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                    intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                    intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                    intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                    intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                    intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                    intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.this.rFK);
                    intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.this.rFM);
                    intent.putExtra("jumpToBindDevice", true);
                    if (ExdeviceBindDeviceGuideUI.this.rFO && !ExdeviceBindDeviceGuideUI.this.rFN) {
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23880);
                }
            });
            this.krs.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(23881);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ExdeviceBindDeviceGuideUI.this.rFN && !ExdeviceBindDeviceGuideUI.this.rFO) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.rFG);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.rFH);
                        intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, ExdeviceBindDeviceGuideUI.this.rzo);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.mDeviceType);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.rFI);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.rFd);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.rcG);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.HP);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.rzn);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.rFJ);
                        c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(23881);
                }
            });
            IntentFilter intentFilter222 = new IntentFilter();
            intentFilter222.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter222.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter222.addAction("android.location.MODE_CHANGED");
            getContext().registerReceiver(this.mReceiver, intentFilter222);
            AppMethodBeat.o(23888);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(23889);
        super.onDestroy();
        getContext().unregisterReceiver(this.mReceiver);
        AppMethodBeat.o(23889);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    private void GA(int i2) {
        AppMethodBeat.i(23890);
        switch (i2) {
            case 1:
                this.rFB.setText(getContext().getString(R.string.bzl));
                this.krs.setText(getContext().getString(R.string.byh));
                this.rFC.setText(getContext().getString(R.string.bzm));
                break;
            case 2:
                this.rFB.setText(getContext().getString(R.string.bzd));
                this.krs.setVisibility(8);
                this.rFC.setText(getContext().getString(R.string.bzc));
                break;
            case 3:
                this.rFE.setImageResource(R.raw.bluetooth_logo);
                this.rFi.setText(R.string.bz1);
                this.rFF.setText(R.string.byl);
                break;
            case 4:
                this.rFE.setImageResource(R.raw.bluetooth_logo);
                this.rFi.setText(R.string.byz);
                this.rFF.setText("");
                break;
            case 5:
                this.rFE.setImageResource(R.raw.wifi_logo);
                this.rFi.setText(R.string.bz1);
                this.rFF.setText(R.string.byw);
                break;
            case 6:
                this.rFE.setImageResource(R.raw.bluetooth_logo);
                this.rFi.setText(R.string.bz1);
                this.rFF.setText(R.string.c0b);
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                this.rFE.setVisibility(8);
                this.rFi.setVisibility(8);
                this.rFF.setVisibility(8);
                this.mListView.setVisibility(0);
                this.rFD.setVisibility(0);
                AppMethodBeat.o(23890);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.rFE.setVisibility(0);
                this.rFi.setVisibility(0);
                this.mListView.setVisibility(8);
                this.rFD.setVisibility(8);
                if (i2 != 4) {
                    this.rFF.setVisibility(0);
                    break;
                } else {
                    this.rFF.setVisibility(8);
                    AppMethodBeat.o(23890);
                    return;
                }
        }
        AppMethodBeat.o(23890);
    }

    static final class a extends BaseAdapter {
        private ArrayList<String> rFQ;

        public a(ArrayList<String> arrayList) {
            this.rFQ = arrayList;
        }

        public final int getCount() {
            AppMethodBeat.i(23883);
            if (this.rFQ != null) {
                int size = this.rFQ.size();
                AppMethodBeat.o(23883);
                return size;
            }
            AppMethodBeat.o(23883);
            return 0;
        }

        private String getItem(int i2) {
            AppMethodBeat.i(23884);
            if (this.rFQ == null || this.rFQ.size() <= 0) {
                AppMethodBeat.o(23884);
                return null;
            }
            String str = this.rFQ.get(i2);
            AppMethodBeat.o(23884);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0999a aVar;
            AppMethodBeat.i(23885);
            if (this.rFQ == null || this.rFQ.size() <= 0) {
                AppMethodBeat.o(23885);
                return null;
            }
            String item = getItem(i2);
            if (view == null) {
                C0999a aVar2 = new C0999a((byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.a4a, null);
                aVar2.rFS = (TextView) view.findViewById(R.id.bee);
                aVar2.rFR = (TextView) view.findViewById(R.id.i5s);
                aVar2.rFT = view.findViewById(R.id.isi);
                aVar2.rFU = view.findViewById(R.id.aa5);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C0999a) view.getTag();
            }
            aVar.rFR.setText(Integer.toString(i2 + 1));
            aVar.rFS.setText(item);
            if (i2 == 0 && this.rFQ.size() == 1) {
                aVar.rFT.setVisibility(4);
                aVar.rFU.setVisibility(4);
            } else if (i2 == 0) {
                aVar.rFT.setVisibility(4);
                aVar.rFU.setVisibility(0);
            } else if (i2 == this.rFQ.size() - 1) {
                aVar.rFU.setVisibility(4);
                aVar.rFT.setVisibility(0);
            }
            AppMethodBeat.o(23885);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI$a$a  reason: collision with other inner class name */
        static class C0999a {
            TextView rFR;
            TextView rFS;
            View rFT;
            View rFU;

            private C0999a() {
            }

            /* synthetic */ C0999a(byte b2) {
                this();
            }
        }
    }
}
