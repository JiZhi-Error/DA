package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.IOException;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher aws;
    private EditText klM;
    private View rGJ;
    private TextView rGK;
    private View rGL;
    private View rGM;
    private q rGN;
    private String rGO;
    private com.tencent.mm.plugin.exdevice.e.a rGP;
    private boolean rGQ;
    private boolean rGR;
    private boolean rGS;
    private int rGT;
    private byte[] rGU;
    private int rGV;
    private int rGW;
    private int rGX;
    private String rGY = "";
    private int rGZ;
    private long rHa;
    boolean rHb = false;
    private com.tencent.mm.plugin.exdevice.e.b rHc;
    private b rHd;
    private p rHe;
    private j.a rHf;
    private WifiManager.MulticastLock rHg;
    private Runnable rHh = new Runnable() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(23939);
            if (!Util.isNullOrNil(ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this))) {
                Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
                AppMethodBeat.o(23939);
                return;
            }
            ExdeviceConnectWifiUI.this.klM.setText(ExdeviceConnectWifiUI.this.rGP.rBz);
            Editable text = ExdeviceConnectWifiUI.this.klM.getText();
            if (text != null) {
                Selection.setSelection(text, text.length());
            }
            AppMethodBeat.o(23939);
        }
    };
    private boolean rHi = true;
    private String rcq = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceConnectWifiUI() {
        AppMethodBeat.i(23964);
        AppMethodBeat.o(23964);
    }

    static /* synthetic */ String a(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(23979);
        String password = exdeviceConnectWifiUI.getPassword();
        AppMethodBeat.o(23979);
        return password;
    }

    static /* synthetic */ void e(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(23980);
        exdeviceConnectWifiUI.refresh(true);
        AppMethodBeat.o(23980);
    }

    static /* synthetic */ void p(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(23982);
        exdeviceConnectWifiUI.cLG();
        AppMethodBeat.o(23982);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        if (r0 != false) goto L_0x004b;
     */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
        // Method dump skipped, instructions count: 374
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(23966);
        super.onResume();
        refresh(false);
        bg.a(this.rHe);
        if (this.rGR) {
            cLG();
            this.rGR = false;
        }
        AppMethodBeat.o(23966);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(23967);
        super.onDestroy();
        if (!this.rHb) {
            GD(2);
        }
        j.cKC().b(0, this.rHf);
        AppMethodBeat.o(23967);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(23968);
        super.onStop();
        bg.b(this.rHe);
        AppMethodBeat.o(23968);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(23969);
        setMMTitle(R.string.bzl);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                AppMethodBeat.i(179596);
                if (!ExdeviceConnectWifiUI.this.rGS) {
                    Intent intent = new Intent();
                    if (ExdeviceConnectWifiUI.this.rHd != b.NO_WIFI_CONNECTED) {
                        z = true;
                    } else {
                        z = false;
                    }
                    intent.putExtra("is_wifi_connected", z);
                    ExdeviceConnectWifiUI.this.setResult(0, intent);
                    ExdeviceConnectWifiUI.this.finish();
                }
                AppMethodBeat.o(179596);
                return false;
            }
        });
        this.rGJ = findViewById(R.id.hl4);
        this.rGK = (TextView) findViewById(R.id.ft9);
        this.rGL = findViewById(R.id.lj);
        this.klM = (EditText) findViewById(R.id.g8x);
        this.rGM = findViewById(R.id.b_s);
        this.aws = new TextWatcher() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass15 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(179597);
                if (editable.length() > 31) {
                    ExdeviceConnectWifiUI.this.rGL.setVisibility(0);
                    ExdeviceConnectWifiUI.this.rGM.setEnabled(false);
                    AppMethodBeat.o(179597);
                    return;
                }
                ExdeviceConnectWifiUI.this.rGL.setVisibility(8);
                ExdeviceConnectWifiUI.this.rGM.setEnabled(true);
                AppMethodBeat.o(179597);
            }
        };
        this.rGJ.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass16 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(179598);
                ExdeviceConnectWifiUI.this.klM.clearFocus();
                ExdeviceConnectWifiUI.this.hideVKB();
                AppMethodBeat.o(179598);
                return false;
            }
        });
        this.rGM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(179599);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
                ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179599);
            }
        });
        this.klM.setTransformationMethod(new PasswordTransformationMethod());
        this.klM.addTextChangedListener(this.aws);
        this.klM.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass18 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(179600);
                if (i2 == 6 || i2 == 5) {
                    Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
                    ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
                    AppMethodBeat.o(179600);
                    return true;
                }
                AppMethodBeat.o(179600);
                return false;
            }
        });
        this.klM.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass2 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(179588);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(179588);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(179588);
                return false;
            }
        });
        this.klM.requestFocus();
        AppMethodBeat.o(23969);
    }

    private void GD(int i2) {
        AppMethodBeat.i(23970);
        long j2 = 0;
        if (i2 == 4) {
            j2 = System.currentTimeMillis() - this.rHa;
        }
        h.INSTANCE.a(13503, Integer.valueOf(i2), Integer.valueOf(this.rGX), Long.valueOf(j2), this.rGY, this.rcq, Integer.valueOf(this.rGZ));
        AppMethodBeat.o(23970);
    }

    private com.tencent.mm.plugin.exdevice.e.a aS(int i2, String str) {
        AppMethodBeat.i(23971);
        if (Util.isNullOrNil(str) || this.rHc == null) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            AppMethodBeat.o(23971);
            return null;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.rHc.rBA.size()) {
                com.tencent.mm.plugin.exdevice.e.a aVar = this.rHc.rBA.get(i4);
                if (aVar == null) {
                    this.rHc.rBA.remove(i4);
                    this.rGQ = true;
                    i4--;
                } else if (aVar.rBx == i2 && str.equals(aVar.rBy)) {
                    AppMethodBeat.o(23971);
                    return aVar;
                }
                i3 = i4 + 1;
            } else {
                AppMethodBeat.o(23971);
                return null;
            }
        }
    }

    private void cLG() {
        AppMethodBeat.i(23972);
        this.rGP.rBz = "";
        this.rGP.rBy = "";
        String str = this.rGO;
        com.tencent.mm.plugin.exdevice.e.a aS = aS(this.rGT, str);
        if (aS == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(23972);
        } else if (Util.isNullOrNil(aS.rBz)) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.rHc.rBA.remove(aS);
            this.rGQ = true;
            AppMethodBeat.o(23972);
        } else {
            this.rGP.rBz = com.tencent.mm.plugin.base.model.b.eW(aS.rBz, a.aT(this.rGT, aS.rBy));
            this.rGP.rBy = aS.rBy;
            MMHandlerThread.postToMainThread(this.rHh);
            AppMethodBeat.o(23972);
        }
    }

    private String getPassword() {
        AppMethodBeat.i(23973);
        if (this.klM.getText() != null) {
            String obj = this.klM.getText().toString();
            AppMethodBeat.o(23973);
            return obj;
        }
        AppMethodBeat.o(23973);
        return null;
    }

    private void refresh(boolean z) {
        AppMethodBeat.i(23974);
        b bVar = z ? b.NORMAL : this.rHd;
        if (NetStatusUtil.getNetType(this) != 0) {
            bVar = b.NO_WIFI_CONNECTED;
        } else {
            this.rGO = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", this.rGO);
            if (!Util.isNullOrNil(this.rGO)) {
                this.rGK.setText(this.rGO);
            } else {
                this.rGK.setText("");
            }
        }
        a(bVar);
        AppMethodBeat.o(23974);
    }

    public final synchronized void a(b bVar) {
        AppMethodBeat.i(23975);
        if (bVar == null) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
            AppMethodBeat.o(23975);
        } else {
            this.rHd = bVar;
            switch (bVar) {
                case NORMAL:
                    i(true, false, false);
                    break;
                case SETTING:
                    i(true, true, false);
                    break;
                case NO_WIFI_CONNECTED:
                    i(false, false, false);
                    break;
                case rHw:
                    GD(5);
                    this.rGS = true;
                    setResult(1);
                    finish();
                    break;
                case FINISH:
                    GD(4);
                    i(true, false, true);
                    this.rGS = true;
                    setResult(-1);
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(23945);
                            ExdeviceConnectWifiUI.q(ExdeviceConnectWifiUI.this);
                            AppMethodBeat.o(23945);
                        }
                    });
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, getIntent().getStringExtra(TPDownloadProxyEnum.USER_DEVICE_ID));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        c.b(getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                    finish();
                    break;
            }
            if (bVar != b.NORMAL) {
                this.klM.clearFocus();
                hideVKB();
            }
            AppMethodBeat.o(23975);
        }
    }

    private void cLH() {
        AppMethodBeat.i(23976);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(23946);
                ExdeviceConnectWifiUI exdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
                AppCompatActivity context = ExdeviceConnectWifiUI.this.getContext();
                ExdeviceConnectWifiUI.this.getString(R.string.zb);
                exdeviceConnectWifiUI.rGN = com.tencent.mm.ui.base.h.a((Context) context, ExdeviceConnectWifiUI.this.getString(R.string.c23), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass6.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(179590);
                        Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
                        if (ExdeviceConnectWifiUI.this.rHd != b.FINISH) {
                            ExdeviceConnectWifiUI.r(ExdeviceConnectWifiUI.this);
                        }
                        AppMethodBeat.o(179590);
                    }
                });
                AppMethodBeat.o(23946);
            }
        });
        AppMethodBeat.o(23976);
    }

    private void cLD() {
        AppMethodBeat.i(23977);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(179591);
                if (ExdeviceConnectWifiUI.this.rGN != null && ExdeviceConnectWifiUI.this.rGN.isShowing()) {
                    ExdeviceConnectWifiUI.this.rGN.dismiss();
                }
                AppMethodBeat.o(179591);
            }
        });
        if (this.rHg.isHeld()) {
            this.rHg.release();
        }
        AppMethodBeat.o(23977);
    }

    private void i(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(23978);
        this.rGJ.setVisibility(z ? 0 : 8);
        if (z2) {
            cLH();
        } else {
            cLD();
        }
        if (z3) {
            Toast.makeText(getContext(), (int) R.string.bzo, 0).show();
        }
        AppMethodBeat.o(23978);
    }

    public enum b {
        NORMAL,
        NO_WIFI_CONNECTED,
        SETTING,
        FINISH,
        rHw;

        public static b valueOf(String str) {
            AppMethodBeat.i(23962);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(23962);
            return bVar;
        }

        static {
            AppMethodBeat.i(23963);
            AppMethodBeat.o(23963);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public static String aT(int i2, String str) {
            AppMethodBeat.i(23960);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(23960);
                return null;
            }
            String str2 = i2 + "@" + str.hashCode();
            AppMethodBeat.o(23960);
            return str2;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(179601);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(179601);
            return;
        }
        Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.rHi = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(179592);
                            ExdeviceConnectWifiUI exdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(exdeviceConnectWifiUI, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            exdeviceConnectWifiUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(exdeviceConnectWifiUI, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ExdeviceConnectWifiUI.this.finish();
                            AppMethodBeat.o(179592);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(179593);
                            ExdeviceConnectWifiUI.this.finish();
                            AppMethodBeat.o(179593);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(179601);
    }

    static /* synthetic */ void k(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(23981);
        exdeviceConnectWifiUI.rHb = true;
        exdeviceConnectWifiUI.rHa = System.currentTimeMillis();
        exdeviceConnectWifiUI.GD(3);
        final String password = exdeviceConnectWifiUI.getPassword();
        final String str = exdeviceConnectWifiUI.rGO;
        Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "do start AirKiss, ssid(%s).", str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is invalid");
            Toast.makeText(exdeviceConnectWifiUI.getContext(), "SSID is invalid", 0).show();
            AppMethodBeat.o(23981);
            return;
        }
        exdeviceConnectWifiUI.a(b.SETTING);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(23942);
                ExdeviceConnectWifiUI.this.rHg.acquire();
                Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s", Integer.valueOf(Java2CExDevice.startAirKissWithInter(password, str, ExdeviceConnectWifiUI.this.rGU, Util.MILLSECONDS_OF_MINUTE, ExdeviceConnectWifiUI.this.rGV, ExdeviceConnectWifiUI.this.rGW)), str);
                AppMethodBeat.o(23942);
            }
        });
        AppMethodBeat.o(23981);
    }

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(23983);
        String str = exdeviceConnectWifiUI.rGO;
        String nullAsNil = Util.nullAsNil(exdeviceConnectWifiUI.getPassword());
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            AppMethodBeat.o(23983);
            return;
        }
        if (Util.isNullOrNil(exdeviceConnectWifiUI.rGP.rBy) || (str.equals(exdeviceConnectWifiUI.rGP.rBy) && !nullAsNil.equals(exdeviceConnectWifiUI.rGP.rBz))) {
            com.tencent.mm.plugin.exdevice.e.a aS = exdeviceConnectWifiUI.aS(exdeviceConnectWifiUI.rGT, str);
            if (aS == null) {
                aS = new com.tencent.mm.plugin.exdevice.e.a();
                aS.rBy = str;
                aS.rBx = exdeviceConnectWifiUI.rGT;
                exdeviceConnectWifiUI.rHc.rBA.add(aS);
            }
            aS.rBz = com.tencent.mm.plugin.base.model.b.eW(nullAsNil, a.aT(exdeviceConnectWifiUI.rGT, str));
        } else if (!exdeviceConnectWifiUI.rGQ) {
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            AppMethodBeat.o(23983);
            return;
        }
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(com.tencent.mm.model.c.getAccPath()).append("exdevice_wifi_infos").toString();
        try {
            byte[] byteArray = exdeviceConnectWifiUI.rHc.toByteArray();
            s.f(sb2, byteArray, byteArray.length);
        } catch (IOException e2) {
            Log.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2, "", new Object[0]);
        }
        Log.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", sb2);
        AppMethodBeat.o(23983);
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        AppMethodBeat.i(23984);
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.refresh(true);
        if (exdeviceConnectWifiUI.rHg.isHeld()) {
            exdeviceConnectWifiUI.rHg.release();
        }
        AppMethodBeat.o(23984);
    }
}
