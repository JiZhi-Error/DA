package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.qbar.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class h {
    ScanCodeSheetItemLogic DDK;
    int DDL;
    int DDM;
    volatile String DDN;
    int DDO = 0;
    private String DDP;
    private ah DDQ;
    private String DDR;
    private String lBO;
    Context mContext;
    int mScene;
    e oXS;

    public h(Context context, ah ahVar, int i2, Bundle bundle) {
        AppMethodBeat.i(202581);
        this.mContext = context;
        this.DDQ = ahVar;
        this.mScene = i2;
        if (this.DDK == null) {
            this.oXS = new e(this.mContext, 1, false);
            this.DDK = new ScanCodeSheetItemLogic(this.mContext);
            this.oXS.mLO = true;
            this.oXS.HLX = new o.f() {
                /* class com.tencent.mm.plugin.sns.data.h.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(176226);
                    try {
                        h hVar = h.this;
                        View a2 = hVar.DDK.a(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.data.h.AnonymousClass3 */

                            public final void onClick(View view) {
                                boolean z;
                                int i2 = 0;
                                AppMethodBeat.i(176228);
                                b bVar = new b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/sns/data/SnsAdQRHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("SnsAdQRHelper", "createQRCodeMenuItem, onClick");
                                if (h.this.oXS.isShowing()) {
                                    h.this.oXS.bMo();
                                }
                                Intent intent = new Intent(h.this.mContext, SnsAdProxyUI.class);
                                intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, 1);
                                intent.putExtra("qrcodeStr", h.this.DDN);
                                intent.putExtra("qrcodeType", h.this.DDL);
                                intent.putExtra("qrcodeVer", h.this.DDM);
                                Context context = h.this.mContext;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                a.a(context, "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                h hVar = h.this;
                                String str = h.this.DDN;
                                if (!TextUtils.isEmpty(h.this.DDN)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (hVar.mScene == 1) {
                                    i2 = 3;
                                } else if (hVar.mScene == 2) {
                                    i2 = 7;
                                } else if (hVar.mScene == 3) {
                                    i2 = 9;
                                }
                                hVar.aNY(hVar.g(i2, str, z).toString());
                                k.jY("17539", hVar.h(i2, str, z));
                                h.this.eZt();
                                a.a(this, "com/tencent/mm/plugin/sns/data/SnsAdQRHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(176228);
                            }
                        }, hVar.DDL, hVar.DDN, 9);
                        if (a2 instanceof ViewTitleWithAnimation) {
                            ((ViewTitleWithAnimation) a2).setTopPaddingVisibility(8);
                        }
                        h.this.oXS.setFooterView(a2);
                        View view = new View(h.this.mContext);
                        view.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(h.this.mContext, 2));
                        h.this.oXS.V(view, true);
                        AppMethodBeat.o(176226);
                    } catch (Exception e2) {
                        Log.e("SnsAdQRHelper", "onCreateMMMenu exp=" + e2.toString());
                        AppMethodBeat.o(176226);
                    }
                }
            };
            this.oXS.PGl = new e.b() {
                /* class com.tencent.mm.plugin.sns.data.h.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(176227);
                    h.this.DDK.onDismiss();
                    h.this.eZt();
                    AppMethodBeat.o(176227);
                }
            };
        }
        try {
            this.DDR = Util.nullAs(IntentUtil.getString(bundle, "qrExtInfo"), "");
            AppMethodBeat.o(202581);
        } catch (Throwable th) {
            Log.e("SnsAdQRHelper", "there is something wrong in parseExtraParams");
            AppMethodBeat.o(202581);
        }
    }

    public final void eZt() {
        this.DDN = "";
        this.DDL = -1;
        this.DDP = "";
        this.lBO = "";
        this.DDM = 0;
        this.DDO = 0;
    }

    public final boolean jX(String str, String str2) {
        AppMethodBeat.i(179078);
        this.DDP = str;
        this.lBO = str2;
        Log.i("SnsAdQRHelper", "onLongClick, filePath=" + this.DDP);
        if (TextUtils.isEmpty(this.DDP)) {
            eZt();
            AppMethodBeat.o(179078);
            return false;
        }
        com.tencent.qbar.e.hki().a(this.mContext, System.currentTimeMillis(), this.DDP, new e.b() {
            /* class com.tencent.mm.plugin.sns.data.h.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00d9  */
            @Override // com.tencent.qbar.e.b
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(long r10, com.tencent.qbar.e.d r12) {
                /*
                // Method dump skipped, instructions count: 310
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.data.h.AnonymousClass4.a(long, com.tencent.qbar.e$d):void");
            }
        });
        AppMethodBeat.o(179078);
        return true;
    }

    public final void ch(String str, boolean z) {
        int i2 = 2;
        AppMethodBeat.i(176235);
        if (this.mScene != 1) {
            if (this.mScene == 2) {
                i2 = 6;
            } else {
                i2 = this.mScene == 3 ? 8 : 0;
            }
        }
        aNY(g(i2, str, z).toString());
        k.jY("17539", h(i2, str, z));
        AppMethodBeat.o(176235);
    }

    public final void aNY(String str) {
        AppMethodBeat.i(176236);
        try {
            ah ahVar = this.DDQ;
            String snsId = ahVar.getSnsId();
            String nullAsNil = Util.nullAsNil(ahVar.uxInfo);
            String nullAsNil2 = Util.nullAsNil(ahVar.aid);
            int i2 = ahVar.source;
            String encode = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(17539, snsId, nullAsNil2, nullAsNil, Integer.valueOf(i2), encode);
            Log.d("SnsAdQRHelper", "reportKV17539 snsId=" + snsId + ", aid=" + nullAsNil2 + ", uxInfo=" + nullAsNil + ", kvData=" + str);
            AppMethodBeat.o(176236);
        } catch (Exception e2) {
            Log.e("SnsAdQRHelper", "reportKV17539 exp:" + e2.toString());
            AppMethodBeat.o(176236);
        }
    }

    public final JSONObject g(int i2, String str, boolean z) {
        AppMethodBeat.i(176237);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("qrResult", z ? 0 : 1);
            jSONObject.put("qrUrl", this.lBO);
            jSONObject.put("qrResultUrl", str);
            jSONObject.put("qrExtInfo", this.DDR);
            if (this.DDO != 0) {
                jSONObject.put("qrResultUrlType", this.DDO);
            }
        } catch (Exception e2) {
            Log.e("SnsAdQRHelper", "buildKVData exp:" + e2.toString());
        }
        AppMethodBeat.o(176237);
        return jSONObject;
    }

    public final String h(int i2, String str, boolean z) {
        AppMethodBeat.i(176238);
        JSONObject jSONObject = new JSONObject();
        try {
            ah ahVar = this.DDQ;
            JSONObject g2 = g(i2, str, z);
            String nullAsNil = Util.nullAsNil(ahVar.uxInfo);
            String snsId = ahVar.getSnsId();
            int i3 = ahVar.source;
            long safeParseLong = Util.safeParseLong(ahVar.lAN);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, g2);
            jSONObject.put("uxinfo", nullAsNil);
            jSONObject.put("snsId", snsId);
            jSONObject.put("scene", i3);
            jSONObject.put("canvasId", safeParseLong);
            if (!TextUtils.isEmpty(ahVar.adExtInfo)) {
                jSONObject.put("adExtInfo", ahVar.adExtInfo);
            }
        } catch (Exception e2) {
            Log.e("SnsAdQRHelper", "buildCgiReportData exp:" + e2.toString());
        }
        String jSONObject2 = jSONObject.toString();
        Log.d("SnsAdQRHelper", "buildCgiReportData ret=".concat(String.valueOf(jSONObject2)));
        AppMethodBeat.o(176238);
        return jSONObject2;
    }
}
