package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(SnsAdNativeLandingPagesPreviewUI snsAdNativeLandingPagesPreviewUI, Intent intent, String str) {
        AppMethodBeat.i(98315);
        boolean j2 = snsAdNativeLandingPagesPreviewUI.j(intent, str);
        AppMethodBeat.o(98315);
        return j2;
    }

    static /* synthetic */ boolean k(Intent intent, String str) {
        AppMethodBeat.i(98314);
        boolean i2 = i(intent, str);
        AppMethodBeat.o(98314);
        return i2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        d dVar;
        AppMethodBeat.i(98310);
        super.onCreate(bundle);
        ap.aK(this);
        final Intent intent = getIntent();
        if (intent == null) {
            finish();
            AppMethodBeat.o(98310);
            return;
        }
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        final int i2 = intent.hasExtra("sns_landing_pages_canvasid") ? 1 : 0;
        final long longExtra = intent.getLongExtra("sns_landing_pages_pageid", 0);
        final String stringExtra2 = intent.getStringExtra("sns_landing_pages_canvasid");
        final String stringExtra3 = intent.getStringExtra("sns_landing_pages_canvas_ext");
        if (TextUtils.isEmpty(stringExtra)) {
            if (intent.getIntExtra("sns_landing_pages_no_store", 0) != 1) {
                if (i2 == 1) {
                    stringExtra = m.feB().n(stringExtra2, stringExtra3, 0, 0);
                } else {
                    stringExtra = m.feB().p(longExtra, 0, 0);
                }
                intent.putExtra("sns_landing_pages_xml", stringExtra);
            }
        } else if (!i(intent, stringExtra)) {
            finish();
            AppMethodBeat.o(98310);
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            final View findViewById = findViewById(R.id.glr);
            findViewById.setVisibility(0);
            d.a aVar = new d.a();
            if (i2 == 0 && longExtra > 0) {
                Log.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", Long.valueOf(longExtra));
                aVar.iLN = new bhr();
                aVar.iLO = new bhs();
                aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
                aVar.funcId = 1286;
                d aXF = aVar.aXF();
                ((bhr) aXF.iLK.iLR).gTg = longExtra;
                dVar = aXF;
            } else if (i2 != 1 || Util.isNullOrNil(stringExtra2)) {
                Log.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
                finish();
                AppMethodBeat.o(98310);
                return;
            } else {
                Log.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", stringExtra2);
                aVar.iLN = new brb();
                aVar.iLO = new brc();
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
                aVar.funcId = 1890;
                d aXF2 = aVar.aXF();
                brb brb = (brb) aXF2.iLK.iLR;
                brb.LYB = stringExtra2;
                brb.LYC = stringExtra3;
                dVar = aXF2;
            }
            aa.a(dVar, new aa.a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesPreviewUI.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    String str2;
                    AppMethodBeat.i(98309);
                    findViewById.setVisibility(8);
                    if (i2 == 0 && i3 == 0) {
                        if (i2 == 1) {
                            String yO = ((brc) dVar.iLL.iLR).LYD.yO();
                            Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", stringExtra2, stringExtra3, yO);
                            if (!TextUtils.isEmpty(yO)) {
                                intent.putExtra("sns_landing_pages_xml", yO);
                                if (!SnsAdNativeLandingPagesPreviewUI.k(intent, yO)) {
                                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                                    AppMethodBeat.o(98309);
                                    return 0;
                                }
                                SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, intent, yO);
                                m feB = m.feB();
                                String str3 = stringExtra2;
                                String str4 = stringExtra3;
                                if (!TextUtils.isEmpty(yO) && !TextUtils.isEmpty(str3)) {
                                    if (!Util.isNullOrNil(str4)) {
                                        str2 = str3 + str4;
                                    } else {
                                        str2 = str3;
                                    }
                                    feB.ElZ.put(str2, yO);
                                    ab abVar = new ab();
                                    abVar.field_canvasId = str3;
                                    abVar.field_canvasXml = yO;
                                    abVar.field_canvasExt = str4;
                                    feB.ElY.a(abVar);
                                }
                            }
                        } else {
                            bhs bhs = (bhs) dVar.iLL.iLR;
                            Log.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(longExtra), bhs.LSf);
                            if (!TextUtils.isEmpty(bhs.LSf)) {
                                intent.putExtra("sns_landing_pages_xml", bhs.LSf);
                                if (!SnsAdNativeLandingPagesPreviewUI.k(intent, bhs.LSf)) {
                                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                                    AppMethodBeat.o(98309);
                                    return 0;
                                }
                                SnsAdNativeLandingPagesPreviewUI.a(SnsAdNativeLandingPagesPreviewUI.this, intent, bhs.LSf);
                                m.feB().J(longExtra, bhs.LSf);
                            }
                        }
                    } else if (i2 == 1) {
                        Log.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", stringExtra2, stringExtra3, Integer.valueOf(i2), Integer.valueOf(i3));
                    } else {
                        Log.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", Long.valueOf(longExtra), Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                    SnsAdNativeLandingPagesPreviewUI.this.finish();
                    AppMethodBeat.o(98309);
                    return 0;
                }
            }, false, this);
            AppMethodBeat.o(98310);
        } else if (j(intent, stringExtra)) {
            AppMethodBeat.o(98310);
        } else {
            finish();
            AppMethodBeat.o(98310);
        }
    }

    private static boolean i(Intent intent, String str) {
        AppMethodBeat.i(98311);
        if (!Util.isNullOrNil(str) && ap.aQb(str)) {
            String aQc = ap.aQc(str);
            if (Util.isNullOrNil(aQc)) {
                AppMethodBeat.o(98311);
                return false;
            }
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_too_large_xml_path", aQc);
        }
        AppMethodBeat.o(98311);
        return true;
    }

    private boolean j(Intent intent, String str) {
        AppMethodBeat.i(98312);
        if (i.aQg(str)) {
            intent.setClass(this, SnsAdNativeLandingPagesUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesPreviewUI", "openCanvas", "(Landroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
            } else if (ADXml.k.aPT(str)) {
                overridePendingTransition(0, 0);
            } else if (IntentUtil.getIntExtra(intent, "sns_landing_page_from_bonus", 0) > 0) {
                overridePendingTransition(R.anim.dq, R.anim.s);
            } else {
                overridePendingTransition(R.anim.eq, R.anim.en);
            }
            AppMethodBeat.o(98312);
            return true;
        }
        Log.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, ".concat(String.valueOf(str)));
        String aU = aU(str, f.COL_ADXML, ".adxml.adActionLink");
        if (TextUtils.isEmpty(aU)) {
            Log.e("SnsAdNativeLandingPagesPreviewUI", "adActionLink is empty");
            aU = aU(str, f.COL_ADXML, ".adxml.adCanvasInfo.shareWebUrl");
        }
        Log.i("SnsAdNativeLandingPagesPreviewUI", "jumpUrl=".concat(String.valueOf(aU)));
        if (!TextUtils.isEmpty(aU)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", aU);
            intent2.putExtra("showShare", true);
            c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            finish();
            overridePendingTransition(R.anim.eq, R.anim.en);
            AppMethodBeat.o(98312);
            return true;
        }
        AppMethodBeat.o(98312);
        return false;
    }

    private static String aU(String str, String str2, String str3) {
        AppMethodBeat.i(98313);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(98313);
            return "";
        }
        try {
            String str4 = XmlParser.parseXml(str, str2, null).get(str3);
            AppMethodBeat.o(98313);
            return str4;
        } catch (Exception e2) {
            Log.e("SnsAdNativeLandingPagesPreviewUI", "getXmlValueByTag exp=" + e2.toString());
            AppMethodBeat.o(98313);
            return "";
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.buu;
    }
}
