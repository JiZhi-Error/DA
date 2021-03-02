package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.model.q;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class a implements i {
    private boolean CFK;
    private boolean CIS = false;
    public int CJz;
    private boolean CSX;
    private int CSY = -1;
    public e.a CSZ;
    private c CTa;
    private Timer CTb = null;
    private TimerTask CTc = null;
    private int dFM;
    public Bundle dFP;
    public Activity dKq;
    private String dWl;
    public ProgressDialog gtM;
    private String result;

    public final void a(String str, c.a aVar) {
        boolean z = false;
        AppMethodBeat.i(52023);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.CIS);
        if (this.CTa == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", objArr);
        if (this.CTa == null || !this.CIS) {
            b(str, aVar);
            AppMethodBeat.o(52023);
            return;
        }
        a(aVar);
        AppMethodBeat.o(52023);
    }

    private void a(c.a aVar) {
        AppMethodBeat.i(52024);
        Log.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
        cancelLoading();
        this.CTb = new Timer();
        this.CTc = new i(this.CTa, new i.b() {
            /* class com.tencent.mm.plugin.scanner.util.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.util.i.b
            public final void onShow() {
            }
        }, aVar);
        this.CTb.schedule(this.CTc, 500);
        AppMethodBeat.o(52024);
    }

    private void cancelLoading() {
        AppMethodBeat.i(52025);
        Log.d("MicroMsg.BarcodeStringHandler", "alvinluo cancelLoading");
        if (this.CTa != null) {
            this.CTa.a(false, false, null);
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        if (this.CTb != null) {
            this.CTb.cancel();
        }
        if (this.CTc != null) {
            this.CTc.cancel();
        }
        AppMethodBeat.o(52025);
    }

    private void b(String str, final c.a aVar) {
        AppMethodBeat.i(52026);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        this.gtM = h.a((Context) this.dKq, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.scanner.util.a.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(52020);
                if (aVar != null) {
                    aVar.eRN();
                }
                if (a.this.CSZ != null) {
                    a.this.CSZ.r(1, null);
                }
                AppMethodBeat.o(52020);
            }
        });
        AppMethodBeat.o(52026);
    }

    public final void a(Activity activity, e.a aVar, c cVar, String str, boolean z, int i2, String str2, Bundle bundle, int i3, boolean z2, int i4, boolean z3, int i5) {
        AppMethodBeat.i(240805);
        Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode result: %s, processOfflineScan: %b, selectFromAlbum: %b, codeName: %s, mode: %d", str, Boolean.valueOf(z2), Boolean.valueOf(z), str2, Integer.valueOf(i5));
        this.dKq = activity;
        int bcV = e.d.bcV(str2);
        this.dFP = bundle;
        this.result = str;
        this.dWl = str2;
        this.dFM = i2;
        this.CJz = i3;
        this.CSX = z2;
        this.CFK = z;
        this.CSY = i4;
        this.CIS = z3;
        this.CSZ = aVar;
        this.CTa = cVar;
        if (g.azz().aYS() == 0) {
            boolean isConnected = NetStatusUtil.isConnected(activity);
            int i6 = isConnected ? 2 : 1;
            Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", Boolean.valueOf(isConnected));
            if (!z2) {
                b bVar = b.CTi;
                if (b.uk(z3)) {
                    if (aVar != null) {
                        aVar.r(isConnected ? 7 : 6, null);
                    }
                    b bVar2 = b.CTi;
                    b.a(new OfflineScanContext(activity, i6, str, bcV, i2, str2, z, bundle), isConnected ? activity.getString(R.string.gd7) : activity.getString(R.string.gd_), false);
                    q qVar = q.CFL;
                    q.b(str, str2, z ? 2 : 1, i6, 0);
                    AppMethodBeat.o(240805);
                    return;
                }
            }
            if (z2) {
                b bVar3 = b.CTi;
                if (b.uk(z3)) {
                    b bVar4 = b.CTi;
                    b.k(activity, activity.getString(R.string.gd5));
                }
            }
            Toast.makeText(activity, activity.getString(R.string.dep), 0).show();
        }
        eRL();
        final n nVar = new n(str2, str, i2, i5, i3);
        nVar.CFF = z;
        g.azz().a(nVar, 0);
        a(activity.getString(R.string.fsp), new c.a() {
            /* class com.tencent.mm.plugin.scanner.util.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.scanner.view.c.a
            public final void eRN() {
                AppMethodBeat.i(52022);
                a.this.eRM();
                g.azz().a(nVar);
                AppMethodBeat.o(52022);
            }
        });
        AppMethodBeat.o(240805);
    }

    public final void eRL() {
        AppMethodBeat.i(52028);
        g.azz().a(1061, this);
        AppMethodBeat.o(52028);
    }

    /* access modifiers changed from: package-private */
    public final void eRM() {
        AppMethodBeat.i(52029);
        g.azz().b(1061, this);
        AppMethodBeat.o(52029);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        pu puVar;
        char c2;
        n.b bVar;
        n.c cVar;
        AppMethodBeat.i(52030);
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        eRM();
        cancelLoading();
        if (i2 == 4 && i3 == -4) {
            h.a(this.dKq, (int) R.string.fsk, (int) R.string.zb, (DialogInterface.OnClickListener) null);
            if (this.CSZ != null) {
                this.CSZ.r(5, null);
            }
            AppMethodBeat.o(52030);
            return;
        }
        b bVar2 = b.CTi;
        if (b.uk(this.CIS)) {
            b bVar3 = b.CTi;
            if (b.b(i2, qVar)) {
                if (!this.CSX) {
                    if (this.CSZ != null) {
                        this.CSZ.r(7, null);
                    }
                    Log.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
                    b bVar4 = b.CTi;
                    b.a(new OfflineScanContext(this.dKq, 2, this.result, e.d.bcV(this.dWl), this.dFM, this.dWl, this.CFK, this.dFP), this.dKq.getString(R.string.gd7), true);
                    q qVar2 = q.CFL;
                    q.b(this.result, this.dWl, this.CFK ? 2 : 1, 2, 0);
                    AppMethodBeat.o(52030);
                    return;
                }
                b bVar5 = b.CTi;
                b.k(this.dKq, this.dKq.getString(R.string.gd5));
                AppMethodBeat.o(52030);
                return;
            }
        }
        switch (i2) {
            case 1:
                if (g.azz().aYT()) {
                    g.azz().getNetworkServerIp();
                    new StringBuilder().append(i3);
                } else if (ag.dm(this.dKq)) {
                    m.iC(this.dKq);
                } else {
                    Toast.makeText(this.dKq, this.dKq.getString(R.string.deo, new Object[]{1, Integer.valueOf(i3)}), 1).show();
                }
                z = true;
                break;
            case 2:
                Toast.makeText(this.dKq, this.dKq.getString(R.string.dep), 1).show();
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            AppMethodBeat.o(52030);
        } else if (i2 == 4 && i3 == -2004) {
            h.n(this.dKq, R.string.fsc, R.string.zb);
            if (this.CSZ != null) {
                this.CSZ.r(5, null);
            }
            AppMethodBeat.o(52030);
        } else if (qVar.getType() == 1061) {
            com.tencent.mm.plugin.scanner.model.n nVar = (com.tencent.mm.plugin.scanner.model.n) qVar;
            if (nVar.rr == null || nVar.rr.iLL.iLR == null) {
                puVar = null;
            } else {
                puVar = (pu) nVar.rr.iLL.iLR;
            }
            if (puVar == null) {
                Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                if (this.CSZ != null) {
                    this.CSZ.r(2, null);
                }
                AppMethodBeat.o(52030);
                return;
            }
            Log.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(puVar.oUv));
            if (Util.isNullOrNil(puVar.KUw)) {
                if (this.CSZ != null) {
                    this.CSZ.r(2, null);
                }
                AppMethodBeat.o(52030);
                return;
            }
            int i4 = puVar.oUv;
            String str2 = puVar.KUw;
            Activity activity = this.dKq;
            String str3 = this.dWl;
            int i5 = ((com.tencent.mm.plugin.scanner.model.n) qVar).dFM;
            boolean z2 = ((com.tencent.mm.plugin.scanner.model.n) qVar).CFF;
            int i6 = this.CJz;
            boolean z3 = this.CSX;
            int i7 = this.CSY;
            boolean z4 = this.CIS;
            if (Util.isNullOrNil(str2)) {
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(str2 == null);
                Log.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", objArr);
                c2 = 2;
            } else {
                int aMS = n.aMS(str2);
                Log.i("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s], respType: %d", Integer.valueOf(aMS), Integer.valueOf(i4));
                if (aMS == 1) {
                    if (str2 == null) {
                        cVar = null;
                    } else {
                        Map<String, String> parseXml = XmlParser.parseXml(str2, "user", null);
                        if (parseXml == null) {
                            cVar = null;
                        } else {
                            cVar = new n.c(Util.nullAsNil(parseXml.get(".user.username")), Util.nullAsNil(parseXml.get(".user.nickname")));
                        }
                    }
                    if (cVar == null || Util.isNullOrNil(cVar.username)) {
                        Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                        c2 = 2;
                    } else {
                        as Kn = ((l) g.af(l.class)).aSN().Kn(cVar.username);
                        if (Kn == null || ((int) Kn.gMZ) <= 0) {
                            new c().a(activity, cVar.username, 1, str3, e.d.bcV(str3), i5, null, null, null, i6, z3, i7, z4);
                            c2 = 1;
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", Kn.field_username);
                            intent.setFlags(65536);
                            com.tencent.mm.plugin.scanner.h.jRt.c(intent, activity);
                            c2 = 0;
                        }
                    }
                } else if (aMS == 2) {
                    if (str2 == null) {
                        bVar = null;
                    } else {
                        Map<String, String> parseXml2 = XmlParser.parseXml(str2, "url", null);
                        if (parseXml2 == null) {
                            bVar = null;
                        } else {
                            bVar = new n.b(Util.nullAsNil(parseXml2.get(".url.link")));
                        }
                    }
                    if (bVar == null || Util.isNullOrNil(bVar.link)) {
                        Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                        c2 = 2;
                    } else {
                        Log.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", bVar.link);
                        if (i4 == 5) {
                            ((s) g.af(s.class)).b(activity, bVar.link, z2 ? 1032 : TXLiteAVCode.EVT_CAMERA_CLOSE, null, null);
                            c2 = 0;
                        } else if (i4 == 6) {
                            c2 = 3;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", bVar.link);
                            intent2.setFlags(65536);
                            com.tencent.mm.plugin.scanner.h.jRt.i(intent2, activity);
                            c2 = 0;
                        }
                    }
                } else if (aMS == 3 || aMS == 4) {
                    Log.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", 4, Boolean.TRUE);
                    Intent intent3 = new Intent();
                    intent3.setClass(activity, ProductUI.class);
                    intent3.setFlags(65536);
                    intent3.putExtra("key_Product_xml", str2);
                    intent3.putExtra("key_Product_funcType", 4);
                    intent3.putExtra("key_ProductUI_addToDB", true);
                    intent3.putExtra("key_need_add_to_history", true);
                    intent3.putExtra("key_is_from_barcode", true);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    c2 = 0;
                } else {
                    Log.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                    Log.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", str2);
                    c2 = 2;
                }
            }
            switch (c2) {
                case 0:
                    Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                    if (this.CSZ != null) {
                        this.CSZ.r(3, null);
                    }
                    AppMethodBeat.o(52030);
                    return;
                case 1:
                    Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                    AppMethodBeat.o(52030);
                    return;
                case 2:
                    Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                    if (this.CSZ != null) {
                        this.CSZ.r(2, null);
                        AppMethodBeat.o(52030);
                        return;
                    }
                    break;
                case 3:
                    Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_JUMP_SCAN_GOODS");
                    Bundle bundle = new Bundle();
                    try {
                        bundle.putByteArray("key_scan_bar_code_response", puVar.toByteArray());
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.BarcodeStringHandler", e2, "onSceneEnd BizScanBarcodeResponse toByteArray exception", new Object[0]);
                    }
                    if (this.CSZ != null) {
                        this.CSZ.r(8, bundle);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(52030);
        } else if (i2 == 0 && i3 == 0) {
            AppMethodBeat.o(52030);
        } else {
            Toast.makeText(this.dKq, this.dKq.getString(R.string.dg3, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            if (this.CSZ != null) {
                this.CSZ.r(2, null);
            }
            AppMethodBeat.o(52030);
        }
    }
}
