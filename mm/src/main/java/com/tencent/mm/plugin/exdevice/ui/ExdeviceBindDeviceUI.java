package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements i, e.b {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ProgressDialog gtM;
    private ScrollView lTw;
    private String mDeviceType;
    private ListView mListView;
    private TextView qbW;
    private j.a rAa;
    private a rFV;
    private View rFW;
    private TextView rFX;
    private ImageView rFY;
    private View rFZ;
    private TextView rFi;
    private TextView rFj;
    private e rGa;
    private String rGb;
    private String rGc;
    private boolean rGd = false;
    private j.a rGe;
    private boolean rGf = false;
    private boolean rGg = false;
    private String rzn;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(23938);
        AppMethodBeat.o(23938);
    }

    /* access modifiers changed from: package-private */
    public enum b {
        CONNECT_PROTO_TYPE_WIFI,
        CONNECT_PROTO_TYPE_BLUE;

        public static b valueOf(String str) {
            AppMethodBeat.i(23919);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(23919);
            return bVar;
        }

        static {
            AppMethodBeat.i(23920);
            AppMethodBeat.o(23920);
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        public String dfJ;
        public String rGv;

        private c() {
        }

        /* synthetic */ c(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class d {
        public String mDeviceType;
        public String rzo;

        private d() {
        }

        /* synthetic */ d(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class f {
        public String rFJ;
        public boolean rGA;
        public b rGB;
        public c rGC;
        public d rGD;
        public cat rGE;
        public cau rGF;
        public int rGG;
        public cpl rGH;
        public String rGI;

        private f() {
            this.rGA = false;
            this.rGB = b.CONNECT_PROTO_TYPE_WIFI;
        }

        /* synthetic */ f(ExdeviceBindDeviceUI exdeviceBindDeviceUI, byte b2) {
            this();
        }

        public final String getKey() {
            AppMethodBeat.i(23924);
            if (this.rGB == b.CONNECT_PROTO_TYPE_WIFI) {
                String str = this.rGD.mDeviceType + this.rGD.rzo;
                AppMethodBeat.o(23924);
                return str;
            }
            String str2 = this.rGC.dfJ;
            AppMethodBeat.o(23924);
            return str2;
        }

        public final String cLF() {
            if (this.rGB != b.CONNECT_PROTO_TYPE_WIFI) {
                return this.rGC.dfJ;
            }
            if (this.rGF == null) {
                return null;
            }
            return this.rGF.KOS;
        }
    }

    /* access modifiers changed from: package-private */
    public enum e {
        SCAN_ALL,
        SCAN_MY_DEVICE,
        SCAN_CATALOG;

        public static e valueOf(String str) {
            AppMethodBeat.i(23922);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(23922);
            return eVar;
        }

        static {
            AppMethodBeat.i(23923);
            AppMethodBeat.o(23923);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4d;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23925);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23892);
                ExdeviceBindDeviceUI.this.finish();
                AppMethodBeat.o(23892);
                return true;
            }
        });
        Intent intent = getIntent();
        this.rGb = intent.getStringExtra("device_category_id");
        this.rzn = intent.getStringExtra("device_brand_name");
        this.mDeviceType = intent.getStringExtra("device_type");
        if (this.mDeviceType == null || this.mDeviceType.length() == 0) {
            this.mDeviceType = this.rzn;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (Util.isNullOrNil(stringExtra3)) {
            stringExtra3 = getContext().getString(R.string.c00);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.rGa = e.SCAN_MY_DEVICE;
            str = getContext().getString(R.string.byb);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.rGa = e.SCAN_CATALOG;
            str = getContext().getString(R.string.by_);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.rGa == e.SCAN_CATALOG) {
            this.rGf = stringExtra.contains("wifi");
            this.rGg = stringExtra.contains("blue");
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", Boolean.valueOf(this.rGf), Boolean.valueOf(this.rGg));
        } else if (this.rGa == e.SCAN_MY_DEVICE) {
            this.rGg = true;
            this.rGf = true;
        }
        this.rAa = new j.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass3 */

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[ADDED_TO_REGION] */
            @Override // com.tencent.mm.plugin.exdevice.model.j.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void h(int r10, java.lang.Object... r11) {
                /*
                // Method dump skipped, instructions count: 185
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass3.h(int, java.lang.Object[]):void");
            }
        };
        this.rGe = new j.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.exdevice.model.j.a
            public final void h(int i2, Object... objArr) {
            }
        };
        initView();
        this.qbW.setText(getContext().getString(R.string.c1w, new Object[]{stringExtra3}));
        bg.azz().a(1264, this);
        bg.azz().a(1706, this);
        bg.azz().a(1270, this);
        bg.azz().a(1719, this);
        if (this.rGg) {
            ad.cKW().a(this);
        }
        if (this.rGf) {
            j.cKC().a(10, this.rAa);
            j.cKC().a(11, this.rGe);
            Java2CExDevice.initWCLanDeviceLib();
        }
        AppMethodBeat.o(23925);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(23926);
        super.onResume();
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.rGg) {
            ad.cKW();
            com.tencent.mm.plugin.exdevice.model.e.cKy();
        }
        if (this.rGf) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.rFV.cLE();
        this.rFV.notifyDataSetChanged();
        AppMethodBeat.o(23926);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(23927);
        this.mListView = (ListView) findViewById(R.id.ed2);
        View inflate = View.inflate(this, R.layout.a4f, null);
        this.rFZ = View.inflate(this, R.layout.a5b, null);
        this.rFW = this.rFZ.findViewById(R.id.hfa);
        this.qbW = (TextView) this.rFZ.findViewById(R.id.iow);
        this.rFX = (TextView) findViewById(R.id.h_s);
        this.rFY = (ImageView) findViewById(R.id.esk);
        this.rFi = (TextView) findViewById(R.id.c4e);
        this.rFj = (TextView) findViewById(R.id.c4f);
        this.lTw = (ScrollView) findViewById(R.id.bou);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(this.rFZ, null, false);
        this.rFV = new a(this.rzn, this.rGa, this.rGb);
        this.mListView.setAdapter((ListAdapter) this.rFV);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(23897);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                f GC = ExdeviceBindDeviceUI.this.rFV.GC(i2 - ((ListView) adapterView).getHeaderViewsCount());
                if (GC.rGF.fMf != 0) {
                    ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, GC);
                } else {
                    ExdeviceBindDeviceUI.b(ExdeviceBindDeviceUI.this, GC);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(23897);
            }
        });
        if (this.rGg && !this.rGf) {
            if (!com.tencent.mm.plugin.d.a.e.a.eL(getContext())) {
                Log.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", Integer.valueOf(Build.VERSION.SDK_INT));
                GA(4);
                AppMethodBeat.o(23927);
                return;
            } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                Log.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                GA(3);
                AppMethodBeat.o(23927);
                return;
            }
        }
        if (!this.rGg && this.rGf && !NetStatusUtil.isWifi(getContext())) {
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            GA(5);
            AppMethodBeat.o(23927);
        } else if (this.rGa == e.SCAN_MY_DEVICE) {
            GA(0);
            AppMethodBeat.o(23927);
        } else {
            if (this.rGa != e.SCAN_CATALOG) {
                e eVar = e.SCAN_ALL;
                Assert.assertTrue(false);
            } else if (this.rGg && this.rGf) {
                Assert.assertTrue(false);
                GA(1);
                AppMethodBeat.o(23927);
                return;
            } else if (this.rGg) {
                GA(2);
                AppMethodBeat.o(23927);
                return;
            } else if (this.rGf) {
                GA(1);
                AppMethodBeat.o(23927);
                return;
            }
            AppMethodBeat.o(23927);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(23928);
        super.onPause();
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.rGf) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.rGg) {
            ad.cKX().stopScan();
        }
        AppMethodBeat.o(23928);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(23929);
        super.onDestroy();
        if (this.rGf) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(23898);
                    Java2CExDevice.stopScanWCLanDevice();
                    Java2CExDevice.releaseWCLanDeviceLib();
                    AppMethodBeat.o(23898);
                }
            });
            j.cKC().b(10, this.rAa);
            j.cKC().b(11, this.rGe);
        }
        if (this.rGg) {
            ad.cKW().b(this);
            ad.cKX().stopScan();
        }
        bg.azz().b(1264, this);
        bg.azz().b(1706, this);
        bg.azz().b(1270, this);
        bg.azz().b(1719, this);
        AppMethodBeat.o(23929);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.e.b
    public final void p(String str, String str2, boolean z) {
        AppMethodBeat.i(23930);
        Log.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", str, str2, Boolean.valueOf(z));
            AppMethodBeat.o(23930);
            return;
        }
        final f fVar = new f(this, (byte) 0);
        fVar.rGB = b.CONNECT_PROTO_TYPE_BLUE;
        fVar.rGC = new c(this, (byte) 0);
        fVar.rGC.rGv = str;
        fVar.rGC.dfJ = com.tencent.mm.plugin.exdevice.k.b.Dk(com.tencent.mm.plugin.exdevice.k.b.anY(str2));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(23899);
                ExdeviceBindDeviceUI.this.a(fVar);
                AppMethodBeat.o(23899);
            }
        });
        AppMethodBeat.o(23930);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.e.b
    public final void c(String str, int i2, long j2) {
    }

    @Override // com.tencent.mm.plugin.exdevice.model.e.b
    public final void b(String str, byte[] bArr, boolean z) {
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(final int i2, final int i3, final String str, final q qVar) {
        AppMethodBeat.i(23931);
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar == null) {
            Log.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
            AppMethodBeat.o(23931);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(23900);
                ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, i2, i3, str, qVar);
                AppMethodBeat.o(23900);
            }
        });
        AppMethodBeat.o(23931);
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar) {
        AppMethodBeat.i(23932);
        if (this.rFV.anP(fVar.getKey())) {
            AppMethodBeat.o(23932);
            return;
        }
        Log.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.cLF());
        a aVar = this.rFV;
        if (fVar != null && !aVar.anP(fVar.getKey())) {
            fVar.rGA = aVar.c(fVar);
            aVar.rGo.add(fVar);
        }
        this.rFV.notifyDataSetChanged();
        if (fVar.rGB == b.CONNECT_PROTO_TYPE_BLUE) {
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", fVar.rGC.dfJ, this.rzn, this.rGb);
            bg.azz().a(new t(fVar.rGC.dfJ, this.rzn, this.rGb), 0);
            AppMethodBeat.o(23932);
        } else if (fVar.rGB == b.CONNECT_PROTO_TYPE_WIFI) {
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", fVar.rGD.mDeviceType, fVar.rGD.rzo);
            bg.azz().a(new v(fVar.rGD.mDeviceType, fVar.rGD.rzo, fVar.rGI), 0);
            AppMethodBeat.o(23932);
        } else {
            Assert.assertTrue(false);
            AppMethodBeat.o(23932);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(23933);
        this.rFV.cLE();
        this.rFV.notifyDataSetChanged();
        AppMethodBeat.o(23933);
    }

    private void GA(int i2) {
        AppMethodBeat.i(23934);
        switch (i2) {
            case 0:
                String string = getString(R.string.byo);
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new ForegroundColorSpan((int) R.color.x0), 0, string.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(23901);
                        com.tencent.mm.plugin.exdevice.model.f.ay(ExdeviceBindDeviceUI.this.getContext(), HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e21) + "/mydevice/page/deviceHelp.html");
                        AppMethodBeat.o(23901);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(23902);
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(23902);
                    }
                }, 0, string.length(), 33);
                this.rFX.setMovementMethod(LinkMovementMethod.getInstance());
                this.rFX.setText(spannableString);
                break;
            case 1:
                String string2 = getString(R.string.byt);
                String string3 = getString(R.string.bzl);
                SpannableString spannableString2 = new SpannableString(string2 + string3);
                spannableString2.setSpan(new ForegroundColorSpan((int) R.color.x0), string2.length(), string2.length() + string3.length(), 33);
                spannableString2.setSpan(new ClickableSpan() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(23893);
                        ExdeviceBindDeviceUI.this.finish();
                        AppMethodBeat.o(23893);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(23894);
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(23894);
                    }
                }, string2.length(), string2.length() + string3.length(), 33);
                this.rFX.setMovementMethod(LinkMovementMethod.getInstance());
                this.rFX.setText(spannableString2);
                break;
            case 2:
                String string4 = getString(R.string.bys);
                String string5 = getString(R.string.byp);
                SpannableString spannableString3 = new SpannableString(string4 + string5);
                spannableString3.setSpan(new ForegroundColorSpan((int) R.color.x0), string4.length(), string4.length() + string5.length(), 33);
                spannableString3.setSpan(new ClickableSpan() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.AnonymousClass10 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(23903);
                        ExdeviceBindDeviceUI.this.finish();
                        AppMethodBeat.o(23903);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        AppMethodBeat.i(23904);
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                        AppMethodBeat.o(23904);
                    }
                }, string4.length(), string4.length() + string5.length(), 33);
                this.rFX.setMovementMethod(LinkMovementMethod.getInstance());
                this.rFX.setText(spannableString3);
                break;
        }
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.rFY.setImageResource(R.raw.bluetooth_logo);
                this.rFi.setText(R.string.bz1);
                this.rFj.setText(R.string.byl);
                break;
            case 4:
                this.rFY.setImageResource(R.raw.bluetooth_logo);
                this.rFi.setText(R.string.byz);
                this.rFj.setText("");
                break;
            case 5:
                this.rFY.setImageResource(R.raw.wifi_logo);
                this.rFi.setText(R.string.bz1);
                this.rFj.setText(R.string.byw);
                break;
        }
        switch (i2) {
            case 0:
            case 1:
            case 2:
                this.rFW.setVisibility(0);
                this.mListView.setVisibility(0);
                this.rFX.setVisibility(0);
                this.rFY.setVisibility(8);
                this.rFi.setVisibility(8);
                this.rFj.setVisibility(8);
                AppMethodBeat.o(23934);
                return;
            case 3:
            case 4:
            case 5:
                this.lTw.setVisibility(8);
                this.rFW.setVisibility(8);
                this.mListView.setVisibility(8);
                this.rFX.setVisibility(8);
                this.rFY.setVisibility(0);
                this.rFi.setVisibility(0);
                if (i2 != 4) {
                    this.rFj.setVisibility(0);
                    break;
                } else {
                    this.rFj.setVisibility(8);
                    AppMethodBeat.o(23934);
                    return;
                }
        }
        AppMethodBeat.o(23934);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends BaseAdapter {
        private com.tencent.mm.av.a.a.c rFu;
        List<f> rGo = new ArrayList();
        private String rGp;
        private e rGq;
        private String rGr;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(23917);
            f GC = GC(i2);
            AppMethodBeat.o(23917);
            return GC;
        }

        public a(String str, e eVar, String str2) {
            AppMethodBeat.i(23905);
            this.rGp = str;
            this.rGq = eVar;
            this.rGr = str2;
            c.a aVar = new c.a();
            aVar.jbt = R.color.a74;
            this.rFu = aVar.bdv();
            AppMethodBeat.o(23905);
        }

        /* access modifiers changed from: package-private */
        public final void cLE() {
            AppMethodBeat.i(23906);
            for (int i2 = 0; i2 < this.rGo.size(); i2++) {
                f fVar = this.rGo.get(i2);
                fVar.rGA = c(fVar);
            }
            AppMethodBeat.o(23906);
        }

        public final boolean b(f fVar) {
            AppMethodBeat.i(23907);
            if (anR(fVar.getKey()) < 0) {
                AppMethodBeat.o(23907);
                return false;
            }
            fVar.rGA = c(fVar);
            AppMethodBeat.o(23907);
            return true;
        }

        public final boolean anP(String str) {
            AppMethodBeat.i(23908);
            if (anR(str) >= 0) {
                AppMethodBeat.o(23908);
                return true;
            }
            AppMethodBeat.o(23908);
            return false;
        }

        public final f anQ(String str) {
            AppMethodBeat.i(23909);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(23909);
                return null;
            }
            for (int i2 = 0; i2 < this.rGo.size(); i2++) {
                f fVar = this.rGo.get(i2);
                if (!anS(fVar.cLF()) && str.equalsIgnoreCase(fVar.cLF())) {
                    AppMethodBeat.o(23909);
                    return fVar;
                }
            }
            AppMethodBeat.o(23909);
            return null;
        }

        public final int getCount() {
            AppMethodBeat.i(23910);
            int i2 = 0;
            for (int i3 = 0; i3 < this.rGo.size(); i3++) {
                if (this.rGo.get(i3).rGA) {
                    i2++;
                }
            }
            AppMethodBeat.o(23910);
            return i2;
        }

        public final f GC(int i2) {
            AppMethodBeat.i(23911);
            int i3 = -1;
            for (int i4 = 0; i4 < this.rGo.size(); i4++) {
                if (this.rGo.get(i4).rGA) {
                    i3++;
                }
                if (i3 == i2) {
                    f fVar = this.rGo.get(i4);
                    AppMethodBeat.o(23911);
                    return fVar;
                }
            }
            AppMethodBeat.o(23911);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1000a aVar;
            View view2;
            AppMethodBeat.i(23912);
            f GC = GC(i2);
            if (view == null) {
                aVar = new C1000a((byte) 0);
                view2 = View.inflate(viewGroup.getContext(), R.layout.a4c, null);
                aVar.kgE = (TextView) view2.findViewById(R.id.ft9);
                aVar.nnL = (ImageView) view2.findViewById(R.id.dtb);
                view2.setTag(aVar);
            } else {
                aVar = (C1000a) view.getTag();
                view2 = view;
            }
            if (GC == null || GC.rGF == null) {
                Assert.assertTrue(false);
                AppMethodBeat.o(23912);
                return view2;
            }
            if (GC.rGB == b.CONNECT_PROTO_TYPE_BLUE) {
                Log.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", Integer.valueOf(i2), GC.rGC.rGv, GC.rGC.dfJ, GC.rGF.Mgf);
                String str = "";
                String str2 = GC.rGF.fMj;
                if (str2 != null && str2.length() >= 4) {
                    str = str2.substring(str2.length() - 4, str2.length());
                } else if (GC.rGC.dfJ != null && GC.rGC.dfJ.length() >= 4) {
                    String str3 = GC.rGC.dfJ;
                    str = str3.substring(str3.length() - 4, str3.length());
                }
                String str4 = GC.rGF.Mgf + " " + str;
                SpannableString spannableString = new SpannableString(str4);
                spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.color.uj)), GC.rGF.Mgf.length() + 1, str4.length(), 17);
                aVar.kgE.setText(spannableString);
            } else if (GC.rGB == b.CONNECT_PROTO_TYPE_WIFI) {
                String str5 = "";
                String str6 = GC.rGF.fMj;
                if (str6 != null && str6.length() >= 4) {
                    str5 = str6.substring(str6.length() - 4, str6.length());
                } else if (GC.rGF.KOS != null && GC.rGF.KOS.length() >= 4) {
                    String str7 = GC.rGF.KOS;
                    str5 = str7.substring(str7.length() - 4, str7.length());
                }
                String str8 = GC.rGF.Mgf + " " + str5;
                SpannableString spannableString2 = new SpannableString(str8);
                spannableString2.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.color.uj)), GC.rGF.Mgf.length() + 1, str8.length(), 17);
                aVar.kgE.setText(spannableString2);
            } else {
                Assert.assertTrue(false);
            }
            String str9 = GC.rGF.IconUrl;
            if (!anS(str9)) {
                com.tencent.mm.av.q.bcV().a(str9, aVar.nnL, this.rFu);
            }
            AppMethodBeat.o(23912);
            return view2;
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI$a$a  reason: collision with other inner class name */
        static class C1000a {
            TextView kgE;
            ImageView nnL;

            private C1000a() {
            }

            /* synthetic */ C1000a(byte b2) {
                this();
            }
        }

        private int anR(String str) {
            AppMethodBeat.i(23913);
            for (int i2 = 0; i2 < this.rGo.size(); i2++) {
                if (this.rGo.get(i2).getKey().compareTo(str) == 0) {
                    AppMethodBeat.o(23913);
                    return i2;
                }
            }
            AppMethodBeat.o(23913);
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final int ge(String str, String str2) {
            String str3;
            String str4;
            AppMethodBeat.i(23914);
            for (int i2 = 0; i2 < this.rGo.size(); i2++) {
                f fVar = this.rGo.get(i2);
                if (fVar.rGE != null) {
                    str3 = fVar.rGE.KLO;
                } else {
                    str3 = fVar.rGB == b.CONNECT_PROTO_TYPE_WIFI ? fVar.rGD.mDeviceType : null;
                }
                if (fVar.rGE != null) {
                    str4 = fVar.rGE.oTH;
                } else {
                    str4 = fVar.rGB == b.CONNECT_PROTO_TYPE_WIFI ? fVar.rGD.rzo : null;
                }
                if (!anS(str3) && !anS(str4) && str.compareTo(str3) == 0 && str2.compareTo(str4) == 0) {
                    AppMethodBeat.o(23914);
                    return i2;
                }
            }
            AppMethodBeat.o(23914);
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final boolean c(f fVar) {
            AppMethodBeat.i(23915);
            if (fVar.rGF == null) {
                AppMethodBeat.o(23915);
                return false;
            }
            if (this.rGq == e.SCAN_CATALOG) {
                if (fVar.rGF.MfY == null || fVar.rGF.MfY.compareTo(this.rGp) != 0) {
                    AppMethodBeat.o(23915);
                    return false;
                } else if (fVar.rGF.Mgh == null || fVar.rGF.Mgh.compareTo(this.rGr) != 0) {
                    AppMethodBeat.o(23915);
                    return false;
                }
            } else if (this.rGq != e.SCAN_MY_DEVICE) {
                Assert.assertTrue(false);
                AppMethodBeat.o(23915);
                return false;
            } else if (fVar.rGF.fMf == 0) {
                AppMethodBeat.o(23915);
                return false;
            }
            AppMethodBeat.o(23915);
            return true;
        }

        private static boolean anS(String str) {
            AppMethodBeat.i(23916);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(23916);
                return true;
            }
            AppMethodBeat.o(23916);
            return false;
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        AppMethodBeat.i(23935);
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        cau cau = fVar.rGF;
        intent.putExtra("device_mac", cau.KOS);
        intent.putExtra("device_brand_name", cau.MfY);
        intent.putExtra("device_desc", cau.Mgg);
        intent.putExtra("device_title", cau.Mgf);
        intent.putExtra("device_icon_url", cau.IconUrl);
        intent.putExtra("device_alias", cau.ked);
        intent.putExtra("device_jump_url", cau.xIy);
        intent.putExtra("bind_ticket", fVar.rFJ);
        intent.putExtra("device_type", fVar.rGE.KLO);
        intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, fVar.rGE.oTH);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.rGG);
        if (fVar.rGB == b.CONNECT_PROTO_TYPE_BLUE) {
            intent.putExtra("device_ble_simple_proto", cau.fMg);
        } else if (fVar.rGB != b.CONNECT_PROTO_TYPE_WIFI) {
            Assert.assertTrue(false);
            AppMethodBeat.o(23935);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
        AppMethodBeat.o(23935);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        AppMethodBeat.i(23936);
        if (fVar == null) {
            Log.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
            AppMethodBeat.o(23936);
        } else if (fVar.rGH == null) {
            Log.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
            AppMethodBeat.o(23936);
        } else {
            cpl cpl = fVar.rGH;
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(z.a(cpl.Lqk));
            Intent intent = new Intent();
            intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, fVar.rGE.oTH);
            intent.putExtra("device_type", fVar.rGE.KLO);
            intent.putExtra("Contact_User", z.a(cpl.Lqk));
            intent.putExtra("Contact_Scene", cpl.LoR);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.rFJ);
            if (Kn != null) {
                if (!com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    intent.putExtra("Contact_Alias", cpl.ked);
                    intent.putExtra("Contact_Nick", cpl.Mjj.toString());
                    intent.putExtra("Contact_Signature", cpl.keb);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(cpl.keh, cpl.kdZ, cpl.kea));
                    intent.putExtra("Contact_Sex", cpl.kdY);
                    intent.putExtra("Contact_VUser_Info", cpl.MmL);
                    intent.putExtra("Contact_VUser_Info_Flag", cpl.MmK);
                    intent.putExtra("Contact_KWeibo_flag", cpl.MmO);
                    intent.putExtra("Contact_KWeibo", cpl.MmM);
                    intent.putExtra("Contact_KWeiboNick", cpl.MmN);
                    if (cpl.MmR != null) {
                        try {
                            intent.putExtra("Contact_customInfo", cpl.MmR.toByteArray());
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e2, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.br.c.b(exdeviceBindDeviceUI.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            AppMethodBeat.o(23936);
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i2, int i3, String str, q qVar) {
        f fVar;
        AppMethodBeat.i(23937);
        if (qVar instanceof p) {
            if (exdeviceBindDeviceUI.gtM != null && exdeviceBindDeviceUI.gtM.isShowing()) {
                exdeviceBindDeviceUI.gtM.dismiss();
            }
            exdeviceBindDeviceUI.rGd = false;
            p pVar = (p) qVar;
            if (!(i2 == 0 && i3 == 0)) {
                Log.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
            }
            exdeviceBindDeviceUI.rGc = ((boa) pVar.rr.iLL.iLR).LWq;
            String str2 = exdeviceBindDeviceUI.rGc;
            if (Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                AppMethodBeat.o(23937);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.br.c.b(exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(23937);
        } else if (qVar instanceof t) {
            drm cKH = ((t) qVar).cKH();
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.o(23937);
            } else if (cKH.KPE == null) {
                Log.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
                AppMethodBeat.o(23937);
            } else {
                f anQ = exdeviceBindDeviceUI.rFV.anQ(cKH.KPE.KOS);
                if (anQ == null) {
                    Log.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    AppMethodBeat.o(23937);
                } else if (anQ.rGE != null) {
                    Log.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    AppMethodBeat.o(23937);
                } else {
                    anQ.rGF = cKH.KPE;
                    anQ.rGE = cKH.KPD;
                    anQ.rFJ = cKH.KOX;
                    anQ.rGH = cKH.KOY;
                    exdeviceBindDeviceUI.rFV.b(anQ);
                    exdeviceBindDeviceUI.rFV.notifyDataSetChanged();
                    Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", cKH.KPD.KLO, cKH.KPD.oTH, cKH.KPE.Mgf, cKH.KPE.KOS, Integer.valueOf(cKH.KPE.fMf));
                    AppMethodBeat.o(23937);
                }
            }
        } else {
            if (qVar instanceof v) {
                if (i2 == 0 && i3 == 0) {
                    dsx dsx = (dsx) ((v) qVar).rr.iLL.iLR;
                    if (dsx.KPD == null) {
                        Log.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                        AppMethodBeat.o(23937);
                        return;
                    }
                    a aVar = exdeviceBindDeviceUI.rFV;
                    String str3 = dsx.KPD.KLO;
                    String str4 = dsx.KPD.oTH;
                    if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                        fVar = null;
                    } else {
                        int ge = aVar.ge(str3, str4);
                        if (ge < 0) {
                            fVar = null;
                        } else {
                            fVar = aVar.rGo.get(ge);
                        }
                    }
                    if (fVar == null) {
                        Log.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                        AppMethodBeat.o(23937);
                        return;
                    } else if (fVar.rGE != null) {
                        Log.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                        AppMethodBeat.o(23937);
                        return;
                    } else {
                        fVar.rGF = dsx.KPE;
                        fVar.rGE = dsx.KPD;
                        fVar.rFJ = dsx.KOX;
                        fVar.rGH = dsx.KOY;
                        exdeviceBindDeviceUI.rFV.b(fVar);
                        exdeviceBindDeviceUI.rFV.notifyDataSetChanged();
                        Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", dsx.KPD.KLO, dsx.KPD.oTH, dsx.KPE.Mgf, Integer.valueOf(dsx.KPE.fMf));
                    }
                } else {
                    Log.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(23937);
                    return;
                }
            }
            AppMethodBeat.o(23937);
        }
    }
}
