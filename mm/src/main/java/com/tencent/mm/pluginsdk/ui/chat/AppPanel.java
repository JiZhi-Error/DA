package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.b.a.gx;
import com.tencent.mm.g.b.a.gy;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.chat.AppGrid;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int COl = 215;
    private static int COm = 158;
    private static boolean Khh = false;
    private boolean COA = false;
    private int COB;
    private int COC;
    public MMFlipper COD;
    private MMDotView COE;
    private final boolean[] KgI = new boolean[21];
    private a KgJ;
    private b KgK;
    private ChatFooter.b KgL;
    private List<AppGrid> KgM;
    private int KgN;
    public int KgO = 0;
    private int KgP = -1;
    public a KgQ;
    private int KgR = 0;
    private int KgS = 0;
    private int KgT = 0;
    private boolean KgU = false;
    private boolean KgV = false;
    private boolean KgW = false;
    private boolean KgX = false;
    boolean KgY = false;
    boolean KgZ = false;
    private int Kgu;
    private int Kgx = 21;
    boolean Kha = false;
    boolean Khb = false;
    private Map<String, g> Khc = null;
    private boolean Khd = true;
    private final int Khe = 2;
    private int Khf = -1;
    private AppGrid.b Khg = new AppGrid.b() {
        /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass6 */

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppGrid.b
        public final int air(int i2) {
            AppMethodBeat.i(232207);
            if (i2 < AppPanel.this.Kgx) {
                int length = AppPanel.this.KgI.length;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (AppPanel.this.KgI[i4]) {
                        if (i3 == i2) {
                            AppMethodBeat.o(232207);
                            return i4;
                        }
                        i3++;
                    }
                }
            } else if (i2 >= AppPanel.this.Kgx && i2 < AppPanel.this.xeA) {
                AppMethodBeat.o(232207);
                return Integer.MIN_VALUE;
            }
            AppMethodBeat.o(232207);
            return Integer.MAX_VALUE;
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppGrid.b
        public final void ais(int i2) {
            AppMethodBeat.i(232208);
            if (i2 != 0) {
                AppMethodBeat.o(232208);
            } else if (!AppPanel.this.KgQ.Khp.value) {
                Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                AppMethodBeat.o(232208);
            } else {
                AppPanel.a(AppPanel.this, true);
                AppMethodBeat.o(232208);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.chat.AppGrid.b
        public final void a(int i2, g gVar) {
            g gVar2;
            g gVar3;
            int i3 = 0;
            AppMethodBeat.i(232209);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Boolean.valueOf(gVar != null);
            Log.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", objArr);
            if (gVar != null && h.p(gVar)) {
                z.aH(gVar.field_appId, "1");
            }
            AppPanel.this.KgO = AppPanel.this.COD.getCurScreen();
            if (gVar instanceof a.C2027a) {
                a.C2027a aVar = (a.C2027a) gVar;
                Log.i("MicroMsg.AppPanel", "jump_type:%s", Integer.valueOf(aVar.uSc));
                if (aVar.Kig == null || aVar.Kig.gqg() == null) {
                    if (aVar.uSc == 1) {
                        com.tencent.mm.plugin.appbrand.api.g gVar4 = new com.tencent.mm.plugin.appbrand.api.g();
                        if (!TextUtils.isEmpty(aVar.KhS)) {
                            gVar4.username = aVar.KhS;
                        } else {
                            gVar4.appId = aVar.KhT;
                        }
                        gVar4.version = aVar.KhU;
                        try {
                            gVar4.iOo = Integer.parseInt(aVar.KhW);
                        } catch (NumberFormatException e2) {
                            gVar4.iOo = 0;
                        }
                        gVar4.kHw = aVar.KhV;
                        gVar4.scene = 1156;
                        gVar4.kHG = aVar.kHG;
                        ((r) com.tencent.mm.kernel.g.af(r.class)).a(AppPanel.this.getContext(), gVar4);
                    } else if (aVar.uSc == 2) {
                        if (aVar.Kif > 0) {
                            Context context = AppPanel.this.context;
                            String str = aVar.nnB;
                            int i4 = aVar.Kif;
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", false);
                            intent.putExtra("show_bottom", false);
                            intent.putExtra("needRedirect", false);
                            intent.putExtra("neverGetA8Key", false);
                            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                            intent.putExtra("KHalfScreenHeight", i4);
                            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                        } else {
                            com.tencent.mm.plugin.account.a.b.a.b(AppPanel.this.context, aVar.nnB, 0, true);
                        }
                    }
                    gx gxVar = new gx();
                    gxVar.ejA = 2;
                    gxVar.eLg = 0;
                    gxVar.uM(aVar.KhQ);
                    gxVar.bfK();
                    AppMethodBeat.o(232209);
                    return;
                }
                AppPanel.a(AppPanel.this, aVar.Kig.gqg());
                AppMethodBeat.o(232209);
                return;
            }
            switch (i2) {
                case Integer.MIN_VALUE:
                    if (!AppPanel.this.KgQ.Khw.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    } else if (gVar == null) {
                        Log.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                        AppMethodBeat.o(232209);
                        return;
                    } else {
                        if (gVar.gmR() || gVar.gmT()) {
                            if (AppPanel.this.sp == null) {
                                AppPanel.this.sp = AppPanel.this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                            }
                            if (AppPanel.this.sp.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar.field_appId, true)) {
                                AppPanel.this.sp.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar.field_appId, false).commit();
                            }
                            if (gVar.gmT()) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 16, gVar.field_appId, 0);
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 13, gVar.field_appId, 0);
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 11, gVar.field_appId);
                        }
                        AppPanel.this.KgJ.d(gVar);
                        AppMethodBeat.o(232209);
                        return;
                    }
                case 0:
                    if (AppPanel.w(AppPanel.this)) {
                        AppPanel.x(AppPanel.this);
                        AppMethodBeat.o(232209);
                        return;
                    }
                    String aAU = ((d) com.tencent.mm.kernel.g.af(d.class)).aAU(AppPanel.this.KgL.getTalkerUserName());
                    if (!TextUtils.isEmpty(aAU)) {
                        AppPanel.a(AppPanel.this, aAU);
                        AppMethodBeat.o(232209);
                        return;
                    } else if (!AppPanel.this.KgQ.Khp.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 1);
                        AppPanel.a(AppPanel.this, false);
                        AppMethodBeat.o(232209);
                        return;
                    }
                case 1:
                    if (AppPanel.w(AppPanel.this)) {
                        AppPanel.x(AppPanel.this);
                        AppMethodBeat.o(232209);
                        return;
                    }
                    String aAV = ((d) com.tencent.mm.kernel.g.af(d.class)).aAV(AppPanel.this.KgL.getTalkerUserName());
                    if (!TextUtils.isEmpty(aAV)) {
                        AppPanel.a(AppPanel.this, aAV);
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 14);
                    a aVar2 = AppPanel.this.KgJ;
                    if (!AppPanel.this.KgQ.KhF.value) {
                        i3 = 2;
                    }
                    aVar2.Qk(i3);
                    AppMethodBeat.o(232209);
                    return;
                case 2:
                    if (!AppPanel.this.KgQ.Khs.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 8);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(54, Boolean.FALSE);
                    if (AppPanel.this.KgJ != null) {
                        xq xqVar = new xq();
                        xqVar.edR.edT = true;
                        EventCenter.instance.publish(xqVar);
                        String str2 = xqVar.edS.edV;
                        if (!Util.isNullOrNil(str2)) {
                            Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(str2)));
                            com.tencent.mm.ui.base.h.c(AppPanel.this.context, AppPanel.this.context.getString(R.string.hke), "", AppPanel.this.context.getString(R.string.x_), AppPanel.this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass6.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(232203);
                                    xq xqVar = new xq();
                                    xqVar.edR.edU = true;
                                    EventCenter.instance.publish(xqVar);
                                    AppPanel.this.KgJ.ehU();
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(232203);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass6.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(232204);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(232204);
                                }
                            });
                            AppMethodBeat.o(232209);
                            return;
                        }
                        AppPanel.this.KgJ.ehU();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 3:
                    if (AppPanel.this.KgJ != null) {
                        AppPanel.this.KgJ.eie();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 4:
                    if (!AppPanel.this.KgQ.Khy.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 7);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(62, Boolean.FALSE);
                    xq xqVar2 = new xq();
                    xqVar2.edR.edT = true;
                    EventCenter.instance.publish(xqVar2);
                    String str3 = xqVar2.edS.edV;
                    if (!Util.isNullOrNil(str3)) {
                        Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(str3)));
                        com.tencent.mm.ui.base.h.c(AppPanel.this.context, AppPanel.this.context.getString(R.string.hke), "", AppPanel.this.context.getString(R.string.x_), AppPanel.this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass6.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(232205);
                                xq xqVar = new xq();
                                xqVar.edR.edU = true;
                                EventCenter.instance.publish(xqVar);
                                AppPanel.this.KgJ.ehV();
                                dialogInterface.dismiss();
                                AppMethodBeat.o(232205);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass6.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(232206);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(232206);
                            }
                        });
                        AppMethodBeat.o(232209);
                        return;
                    }
                    AppPanel.this.KgJ.ehV();
                    AppMethodBeat.o(232209);
                    return;
                case 5:
                    if (AppPanel.this.KgJ != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 6);
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(67, Boolean.FALSE);
                        AppPanel.this.KgJ.ehW();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 6:
                    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(AppPanel.this.getContext())) {
                        AppMethodBeat.o(232209);
                        return;
                    } else if (!AppPanel.this.KgQ.KhC.value || !AppPanel.this.KgQ.KhD.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    } else {
                        bg.aVF();
                        if (((Boolean) com.tencent.mm.model.c.azQ().get(290817, Boolean.TRUE)).booleanValue()) {
                            bg.aVF();
                            com.tencent.mm.model.c.azQ().set(290817, Boolean.FALSE);
                            AppPanel.this.refresh();
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 3);
                        AppPanel.this.KgJ.ehX();
                        AppMethodBeat.o(232209);
                        return;
                    }
                case 7:
                    if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(AppPanel.this.getContext())) {
                        AppMethodBeat.o(232209);
                        return;
                    } else if (!AppPanel.this.KgQ.KhG.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    } else {
                        if (gVar == null) {
                            gVar3 = (g) AppPanel.this.Khc.get(g.JVT);
                            if (gVar3 == null) {
                                AppMethodBeat.o(232209);
                                return;
                            }
                        } else {
                            gVar3 = gVar;
                        }
                        if (gVar3.gmR() || gVar3.gmT()) {
                            if (AppPanel.this.sp == null) {
                                AppPanel.this.sp = AppPanel.this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                            }
                            if (AppPanel.this.sp.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar3.field_appId, true)) {
                                AppPanel.this.sp.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar3.field_appId, false).commit();
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 13, gVar3.field_appId, 0);
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 11, gVar3.field_appId);
                        }
                        bg.aVF();
                        int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                        bg.aVF();
                        ArrayList<String> stringsToList = Util.stringsToList(((String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, "")).split(";"));
                        if (!stringsToList.contains(String.valueOf(intValue))) {
                            stringsToList.add(String.valueOf(intValue));
                            bg.aVF();
                            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, Util.listToString(stringsToList, ";"));
                            AppPanel.this.refresh();
                        }
                        AppPanel.this.KgJ.eid();
                        AppMethodBeat.o(232209);
                        return;
                    }
                case 8:
                    if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(AppPanel.this.getContext())) {
                        AppMethodBeat.o(232209);
                        return;
                    }
                    if (gVar == null) {
                        gVar = (g) AppPanel.this.Khc.get(g.JVR);
                    }
                    bg.aVF();
                    int intValue2 = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                    bg.aVF();
                    ArrayList<String> stringsToList2 = Util.stringsToList(((String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, "")).split(";"));
                    if (!stringsToList2.contains(String.valueOf(intValue2))) {
                        stringsToList2.add(String.valueOf(intValue2));
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, Util.listToString(stringsToList2, ";"));
                        AppPanel.this.refresh();
                    }
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(80, Boolean.FALSE);
                    AppPanel.this.KgJ.d(gVar);
                    AppMethodBeat.o(232209);
                    return;
                case 9:
                    if (AppPanel.this.KgJ != null) {
                        if (gVar == null) {
                            gVar2 = (g) AppPanel.this.Khc.get(g.JVU);
                            if (gVar2 == null) {
                                Log.i("MicroMsg.AppPanel", "empty info");
                                AppMethodBeat.o(232209);
                                return;
                            }
                        } else {
                            gVar2 = gVar;
                        }
                        if (gVar2.gmR() || gVar2.gmT()) {
                            if (AppPanel.this.sp == null) {
                                AppPanel.this.sp = AppPanel.this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                            }
                            if (AppPanel.this.sp.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar2.field_appId, true)) {
                                AppPanel.this.sp.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar2.field_appId, false).commit();
                            }
                        }
                        AppPanel.this.KgJ.eih();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 10:
                    if (AppPanel.w(AppPanel.this)) {
                        AppPanel.x(AppPanel.this);
                        AppMethodBeat.o(232209);
                        return;
                    } else if (!WeChatBrands.Business.Entries.SessionVoiceMsg.checkAvailable(AppPanel.this.getContext())) {
                        AppMethodBeat.o(232209);
                        return;
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 9);
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(73, Boolean.FALSE);
                        AppPanel.this.KgK.gqc();
                        AppMethodBeat.o(232209);
                        return;
                    }
                case 11:
                    if (!AppPanel.this.KgQ.Khr.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 5);
                    if (AppPanel.this.KgJ != null) {
                        AppPanel.this.KgJ.eia();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 12:
                    if (!WeChatBrands.Business.Entries.SessionGroupTools.checkAvailable(AppPanel.this.getContext())) {
                        AppMethodBeat.o(232209);
                        return;
                    } else if (!AppPanel.this.KgQ.KhL.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    } else if (AppPanel.this.KgJ != null) {
                        AppPanel.this.KgJ.eik();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 13:
                    if (!WeChatBrands.Business.Entries.SessionGroupSolitaire.checkAvailable(AppPanel.this.getContext())) {
                        AppMethodBeat.o(232209);
                        return;
                    } else if (!AppPanel.this.KgQ.KhM.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 19);
                        if (AppPanel.this.KgJ != null) {
                            AppPanel.this.KgJ.eil();
                            AppMethodBeat.o(232209);
                            return;
                        }
                    }
                    break;
                case 14:
                    if (WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(AppPanel.this.getContext())) {
                        if (AppPanel.this.KgQ.KhN.value) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 20);
                            if (AppPanel.this.KgJ != null) {
                                AppPanel.this.KgJ.eij();
                                com.tencent.mm.live.d.a.aHT();
                                break;
                            }
                        } else {
                            Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                            AppMethodBeat.o(232209);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 15:
                    if (!AppPanel.this.KgQ.Khq.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 4);
                    AppPanel.this.KgJ.ehY();
                    AppMethodBeat.o(232209);
                    return;
                case 16:
                    if (!AppPanel.this.KgQ.KhE.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    if (AppPanel.this.KgJ != null) {
                        AppPanel.this.KgJ.eic();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 15);
                    bg.aVF();
                    boolean booleanValue = ((Boolean) com.tencent.mm.model.c.azQ().get(208899, Boolean.FALSE)).booleanValue();
                    bg.aVF();
                    boolean booleanValue2 = ((Boolean) com.tencent.mm.model.c.azQ().get(208913, Boolean.FALSE)).booleanValue();
                    if (booleanValue) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11594, 3);
                        AppMethodBeat.o(232209);
                        return;
                    } else if (booleanValue2) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11594, 4);
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 17:
                    if (!AppPanel.this.KgQ.Khu.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    bg.aVF();
                    if (((Boolean) com.tencent.mm.model.c.azQ().get(327744, Boolean.TRUE)).booleanValue()) {
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(327744, Boolean.FALSE);
                        AppPanel.this.refresh();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 12);
                    AppPanel.this.KgJ.eib();
                    AppMethodBeat.o(232209);
                    return;
                case 18:
                    if (!AppPanel.this.KgQ.KhI.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    AppPanel.this.KgJ.eif();
                    AppMethodBeat.o(232209);
                    return;
                case 19:
                    if (!AppPanel.this.KgQ.KhK.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 17);
                    if (AppPanel.this.KgJ != null) {
                        AppPanel.this.KgJ.eii();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    break;
                case 20:
                    if (!AppPanel.this.KgQ.KhO.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.string.b12), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                    }
                    AppPanel.this.KgJ.eig();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 21);
                    AppMethodBeat.o(232209);
                    return;
                case Integer.MAX_VALUE:
                    if (AppPanel.this.jGV == null) {
                        Log.e("MicroMsg.AppPanel", "infoList == null");
                        AppMethodBeat.o(232209);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10305, String.valueOf(AppPanel.this.jGV.size()));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10923, 10);
                    com.tencent.mm.kernel.g.aAh().azQ().set(69121, "");
                    AppPanel.this.KgJ.ehZ();
                    AppMethodBeat.o(232209);
                    return;
            }
            AppMethodBeat.o(232209);
        }
    };
    private boolean Khi = true;
    private int Khj = -1;
    Context context;
    private boolean isInit = false;
    private List<g> jGV = new LinkedList();
    private SharedPreferences sp;
    private int xeA = this.Kgx;

    public interface a {
        void Qj(int i2);

        void Qk(int i2);

        void d(g gVar);

        void ehU();

        void ehV();

        void ehW();

        void ehX();

        void ehY();

        void ehZ();

        void eia();

        void eib();

        void eic();

        void eid();

        void eie();

        void eif();

        void eig();

        void eih();

        void eii();

        void eij();

        void eik();

        void eil();
    }

    public interface b {
        void gqc();
    }

    static /* synthetic */ void a(AppPanel appPanel, String str) {
        AppMethodBeat.i(232219);
        appPanel.beW(str);
        AppMethodBeat.o(232219);
    }

    static /* synthetic */ int b(AppPanel appPanel) {
        AppMethodBeat.i(31488);
        int screenOrientation = appPanel.getScreenOrientation();
        AppMethodBeat.o(31488);
        return screenOrientation;
    }

    static /* synthetic */ int c(AppPanel appPanel, int i2) {
        AppMethodBeat.i(163207);
        int ait = appPanel.ait(i2);
        AppMethodBeat.o(163207);
        return ait;
    }

    public AppPanel(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(31459);
        this.context = context2;
        AppMethodBeat.o(31459);
    }

    public final void init(int i2) {
        AppMethodBeat.i(31460);
        Log.i("MicroMsg.AppPanel", "init: %s", Integer.valueOf(i2));
        this.KgQ = new a();
        this.KgT = i2;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.KgR = defaultDisplay.getWidth();
            this.KgS = defaultDisplay.getHeight();
        } else {
            this.KgR = defaultDisplay.getHeight();
            this.KgS = defaultDisplay.getWidth();
        }
        View.inflate(this.context, R.layout.gf, this);
        this.COE = (MMDotView) findViewById(R.id.sc);
        this.COD = (MMFlipper) findViewById(R.id.sd);
        gpW();
        gpK();
        bqe();
        AppMethodBeat.o(31460);
    }

    public void setServiceShowFlag(int i2) {
        AppMethodBeat.i(31461);
        Log.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", Integer.valueOf(i2));
        this.KgT = i2;
        AppMethodBeat.o(31461);
    }

    public final void gpK() {
        AppMethodBeat.i(31463);
        this.KgQ.gqd();
        this.KgY = false;
        this.KgZ = false;
        this.Kha = false;
        this.Khb = false;
        gpL();
        this.KgQ.Aa(this.KgU);
        this.KgQ.Ab(this.KgV);
        this.KgQ.Ae(this.KgW);
        this.KgQ.Af(this.KgX);
        gpV();
        AppMethodBeat.o(31463);
    }

    public final void gpL() {
        AppMethodBeat.i(31464);
        com.tencent.mm.n.h.aqK();
        boolean z = com.tencent.mm.n.d.aqw() == 2;
        this.KgQ.gqe();
        this.KgQ.Ac(z);
        this.KgQ.Ad(c.aZU(FirebaseAnalytics.b.LOCATION));
        this.KgQ.gqf();
        AppMethodBeat.o(31464);
    }

    public final void gpM() {
        AppMethodBeat.i(31465);
        this.KgQ.Khq.value = false;
        gpV();
        AppMethodBeat.o(31465);
    }

    public final void zW(boolean z) {
        AppMethodBeat.i(31466);
        boolean z2 = !z;
        this.KgQ.Khs.value = z2;
        gpV();
        Log.d("MicroMsg.AppPanel", "enable " + z2 + " isVoipPluginEnable " + this.KgQ.Kht.value);
        AppMethodBeat.o(31466);
    }

    public final void zX(boolean z) {
        AppMethodBeat.i(31467);
        boolean z2 = !z;
        this.KgQ.Khy.value = z2;
        gpV();
        Log.d("MicroMsg.AppPanel", "enable " + this.KgQ.Khz.value + " isVoipAudioEnable " + z2);
        AppMethodBeat.o(31467);
    }

    public final void zY(boolean z) {
        AppMethodBeat.i(31468);
        boolean z2 = !z;
        this.KgQ.KhH.value = z2;
        gpV();
        Log.d("MicroMsg.AppPanel", "enable " + this.KgQ.KhH.value + " isMultiTalkEnable " + z2);
        AppMethodBeat.o(31468);
    }

    public final void zZ(boolean z) {
        AppMethodBeat.i(31469);
        this.KgQ.KhA.value = !z;
        gpV();
        AppMethodBeat.o(31469);
    }

    public final void gpN() {
        AppMethodBeat.i(31470);
        this.KgQ.Khx.value = false;
        gpV();
        Log.d("MicroMsg.AppPanel", "disableTalkroom enable false");
        AppMethodBeat.o(31470);
    }

    public final void gpO() {
        AppMethodBeat.i(31471);
        this.KgQ.KhC.value = false;
        gpV();
        AppMethodBeat.o(31471);
    }

    public final void gpP() {
        AppMethodBeat.i(31472);
        this.KgQ.Khw.value = false;
        gpV();
        AppMethodBeat.o(31472);
    }

    public final void gpQ() {
        AppMethodBeat.i(31473);
        this.KgQ.KhE.value = false;
        gpV();
        AppMethodBeat.o(31473);
    }

    public final void gpR() {
        AppMethodBeat.i(31474);
        this.KgQ.KhK.value = false;
        gpV();
        AppMethodBeat.o(31474);
    }

    public final void gpS() {
        AppMethodBeat.i(185751);
        this.KgQ.KhL.value = false;
        gpV();
        AppMethodBeat.o(185751);
    }

    public final void gpT() {
        AppMethodBeat.i(232211);
        this.KgQ.KhM.value = false;
        gpV();
        AppMethodBeat.o(232211);
    }

    public final void gpU() {
        AppMethodBeat.i(232212);
        this.KgQ.Ag(false);
        gpV();
        AppMethodBeat.o(232212);
    }

    public void setAppPanelUnCertainEnterArrayList(ArrayList<a.C2027a> arrayList) {
        this.KgQ.KhP = arrayList;
    }

    public ArrayList<a.C2027a> getAppPanelUnCertainEnterArrayList() {
        AppMethodBeat.i(163205);
        ArrayList<a.C2027a> appPanelUnCertainEnterArrayList = this.KgQ.getAppPanelUnCertainEnterArrayList();
        AppMethodBeat.o(163205);
        return appPanelUnCertainEnterArrayList;
    }

    public final void gpV() {
        int i2;
        AppMethodBeat.i(31475);
        int length = this.KgI.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.KgI[i3] = true;
        }
        if (!this.KgQ.Khp.value) {
            this.KgI[0] = false;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!this.KgQ.Kho.value) {
            this.KgI[1] = false;
            i2++;
        }
        if (!this.KgQ.KhK.value) {
            this.KgI[19] = false;
            i2++;
        }
        if (!this.KgQ.KhL.value) {
            this.KgI[12] = false;
            i2++;
        }
        if (!this.KgQ.KhM.value) {
            this.KgI[13] = false;
            i2++;
        }
        if (!this.KgQ.KhN.value) {
            this.KgI[14] = false;
            i2++;
        }
        if (!this.KgQ.KhC.value || !this.KgQ.KhD.value) {
            this.KgI[6] = false;
            i2++;
        }
        if (!this.KgQ.Khu.value) {
            this.KgI[17] = false;
            i2++;
        }
        if (!this.KgQ.Khv.value) {
            Log.i("MicroMsg.AppPanel", "disable remittance");
            this.KgI[8] = false;
            i2++;
        }
        if (!this.KgQ.Khq.value) {
            this.KgI[15] = false;
            i2++;
        }
        if (!this.KgQ.KhE.value) {
            this.KgI[16] = false;
            i2++;
        }
        if (!this.KgQ.KhH.value) {
            this.KgI[3] = false;
            i2++;
        }
        if (!this.KgQ.Khr.value) {
            this.KgI[11] = false;
            i2++;
        }
        if (!this.KgQ.Khx.value) {
            this.KgI[5] = false;
            i2++;
        }
        if (!this.KgQ.Khz.value || !this.KgQ.Khy.value) {
            this.KgI[4] = false;
            i2++;
        }
        if (!this.KgQ.Kht.value || !this.KgQ.Khs.value) {
            this.KgI[2] = false;
            i2++;
        }
        if (!this.KgQ.KhB.value || !this.KgQ.KhA.value) {
            this.KgI[10] = false;
            i2++;
        }
        if (!this.KgQ.KhG.value) {
            Log.i("MicroMsg.AppPanel", "disable lucky money");
            this.KgI[7] = false;
            i2++;
        }
        if (!this.KgQ.KhI.value) {
            this.KgI[18] = false;
            i2++;
        }
        if (!this.KgQ.KhO.value) {
            this.KgI[20] = false;
            i2++;
        }
        this.KgI[9] = false;
        this.Kgx = 21 - (i2 + 1);
        AppMethodBeat.o(31475);
    }

    private int getScreenOrientation() {
        int i2;
        AppMethodBeat.i(31476);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        AppMethodBeat.o(31476);
        return i2;
    }

    private void gpW() {
        AppMethodBeat.i(31477);
        Log.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.Khf = -1;
        this.COD.removeAllViews();
        this.COD.setOnMeasureListener(new MMFlipper.b() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMFlipper.b
            public final void ig(int i2, int i3) {
                AppMethodBeat.i(31448);
                Log.i("MicroMsg.AppPanel", "onMeasure width:" + i2 + " height:" + i3 + " isMeasured:" + AppPanel.this.COA);
                if (AppPanel.this.COA || i3 == 0 || i2 == 0) {
                    if (i3 == 0 || i2 == 0) {
                        Log.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
                    }
                    AppMethodBeat.o(31448);
                    return;
                }
                if (AppPanel.b(AppPanel.this) == 2) {
                    Log.d("MicroMsg.AppPanel", "landspace");
                } else {
                    Log.d("MicroMsg.AppPanel", "portrait");
                }
                AppPanel.this.COA = true;
                AppPanel.this.COC = i3;
                AppPanel.this.COB = i2;
                AppPanel.d(AppPanel.this);
                AppMethodBeat.o(31448);
            }
        });
        this.COD.setOnFlipperViewShowedListener(new MMFlipper.a() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMFlipper.a
            public final void aiv(int i2) {
                AppMethodBeat.i(232199);
                Log.i("MicroMsg.AppPanel", "viewpage reshow %s", Integer.valueOf(i2));
                int aiu = AppPanel.this.aiu(14);
                if (i2 == aiu && AppPanel.this.KgQ.KhN.value) {
                    e.rj(aiu + 1);
                }
                AppMethodBeat.o(232199);
            }
        });
        this.COD.setOnScreenChangedListener(new MMFlipper.c() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMFlipper.c
            public final void z(int i2, int i3, boolean z) {
                int i4;
                AppMethodBeat.i(232200);
                AppPanel.this.COE.setSelectedDot(i3);
                if (AppPanel.this.getVisibility() == 0 && i2 != -1 && i2 != i3 && z) {
                    if (AppPanel.this.KgQ.Khw.value) {
                        i4 = AppPanel.this.Kgx + AppPanel.this.jGV.size();
                    } else {
                        i4 = AppPanel.this.Kgx;
                    }
                    gx gxVar = new gx();
                    gxVar.ejA = 1;
                    gxVar.eLg = 0;
                    StringBuilder sb = new StringBuilder();
                    for (int i5 = 0; i5 < AppPanel.this.getAppPanelUnCertainEnterArrayList().size(); i5++) {
                        AppPanel appPanel = AppPanel.this;
                        if (i2 == AppPanel.c(appPanel, appPanel.KgP + i4 + 1)) {
                            sb.append(AppPanel.this.getAppPanelUnCertainEnterArrayList().get(i5).KhQ).append("|");
                        }
                    }
                    gxVar.uM(sb.toString());
                    gxVar.bfK();
                    int aiu = AppPanel.this.aiu(13);
                    if (aiu != -1 && aiu == AppPanel.this.getCurScreen()) {
                        String talkerUserName = AppPanel.this.KgL == null ? "" : AppPanel.this.KgL.getTalkerUserName();
                        gy gyVar = new gy();
                        gyVar.uN(talkerUserName);
                        gyVar.eLg = 0;
                        gyVar.uO("19");
                        gyVar.eLj = aiu + 1;
                        gyVar.bfK();
                    }
                    Log.i("MicroMsg.AppPanel", "scroll to show page %s", Integer.valueOf(i3));
                    int aiu2 = AppPanel.this.aiu(14);
                    if (i3 == aiu2 && AppPanel.this.KgQ.KhN.value) {
                        e.rj(aiu2 + 1);
                    }
                }
                AppMethodBeat.o(232200);
            }
        });
        gqa();
        AppMethodBeat.o(31477);
    }

    private void bqe() {
        AppMethodBeat.i(232213);
        com.tencent.f.h.RTc.bqo("AppPanel-loadinfo");
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(232202);
                AppPanel.this.jGV.clear();
                try {
                    String value = com.tencent.mm.n.h.aqJ().getValue("ShowAPPSuggestion");
                    if (Util.isNullOrNil(value) || Integer.valueOf(value).intValue() != 1) {
                        AppPanel.this.jGV = h.a(AppPanel.this.context, false, AppPanel.this.KgT);
                        Log.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
                    } else {
                        Log.i("MicroMsg.AppPanel", "jacks show App Suggestion");
                        AppPanel.this.jGV = h.a(AppPanel.this.context, true, AppPanel.this.KgT);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e2.getMessage());
                    AppPanel.this.jGV = h.a(AppPanel.this.context, false, AppPanel.this.KgT);
                }
                if (!AppPanel.l(AppPanel.this)) {
                    AppPanel.iu(AppPanel.this.jGV);
                }
                AppPanel.b(AppPanel.this, AppPanel.this.jGV);
                if (AppPanel.this.KgQ != null) {
                    AppPanel.this.KgQ.Aa(AppPanel.this.KgU);
                    AppPanel.this.KgQ.Ab(AppPanel.this.KgV);
                    AppPanel.this.KgQ.Ae(AppPanel.this.KgW);
                    AppPanel.this.KgQ.Af(AppPanel.this.KgX);
                }
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232201);
                        int curScreen = AppPanel.this.KgP == -1 ? AppPanel.this.COD.getCurScreen() : -1;
                        AppPanel.d(AppPanel.this);
                        if (curScreen != -1) {
                            AppPanel.this.COD.setToScreen(curScreen);
                            AppPanel.this.COE.setSelectedDot(curScreen);
                        }
                        AppMethodBeat.o(232201);
                    }
                });
                AppMethodBeat.o(232202);
            }
        }, "AppPanel-loadinfo");
        AppMethodBeat.o(232213);
    }

    public final void refresh() {
        AppMethodBeat.i(31478);
        Log.i("MicroMsg.AppPanel", "app panel refleshed: %s", Integer.valueOf(this.KgT));
        bqe();
        AppMethodBeat.o(31478);
    }

    public void setUncertainEnterLocation(int i2) {
        this.KgP = i2;
    }

    private void gpX() {
        int i2;
        AppMethodBeat.i(163206);
        if (this.KgP == -1) {
            AppMethodBeat.o(163206);
            return;
        }
        if (this.KgQ.Khw.value) {
            i2 = this.Kgx + this.jGV.size();
        } else {
            i2 = this.Kgx;
        }
        this.KgO = ait(this.KgP + i2 + 1);
        this.COD.setToScreen(this.KgO);
        this.KgP = -1;
        gx gxVar = new gx();
        gxVar.ejA = 1;
        gxVar.eLg = 1;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < getAppPanelUnCertainEnterArrayList().size(); i3++) {
            if (this.KgO == ait(this.KgP + i2 + 1)) {
                sb.append(getAppPanelUnCertainEnterArrayList().get(i3).KhQ).append("|");
            }
        }
        gxVar.uM(sb.toString());
        gxVar.bfK();
        AppMethodBeat.o(163206);
    }

    private int ait(int i2) {
        int i3 = i2 / this.Kgu;
        if (i2 % this.Kgu <= 0) {
            i3--;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public final int aiu(int i2) {
        int length = this.KgI.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length) {
                i4 = -1;
                break;
            }
            if (this.KgI[i3]) {
                if (i3 == i2) {
                    break;
                }
                i4++;
            }
            i3++;
        }
        if (i4 == -1) {
            return -1;
        }
        int i5 = i4 + 1;
        int i6 = i5 / this.Kgu;
        if (i5 % this.Kgu <= 0) {
            i6--;
        }
        if (i6 < 0) {
            return 0;
        }
        return i6;
    }

    public int getPageMaxRowCount() {
        if (this.KgN != 0) {
            return this.KgN;
        }
        int i2 = (this.xeA + 3) / 4;
        if (i2 > 2) {
            return 2;
        }
        return i2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(31481);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            Log.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.Khd = true;
            } else {
                this.Khd = false;
            }
            setNeedRefreshHeight(true);
            gpY();
        }
        AppMethodBeat.o(31481);
    }

    private void gpY() {
        AppMethodBeat.i(31482);
        Log.i("MicroMsg.AppPanel", "[dealOrientationChange]");
        this.COA = false;
        this.COD.setToScreen(0);
        gpW();
        requestLayout();
        AppMethodBeat.o(31482);
    }

    public int getCurScreen() {
        AppMethodBeat.i(232214);
        if (this.COD != null) {
            int curScreen = this.COD.getCurScreen();
            AppMethodBeat.o(232214);
            return curScreen;
        }
        AppMethodBeat.o(232214);
        return -1;
    }

    private void beW(String str) {
        AppMethodBeat.i(232215);
        Log.i("MicroMsg.AppPanel", "showForbiddenDialog: %s", str);
        f.a aVar = new f.a(MMApplicationContext.getContext());
        aVar.bow(str).Dq(true);
        aVar.apa(R.string.j34).b(new f.c() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass8 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        }).b(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass7 */

            public final void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
        AppMethodBeat.o(232215);
    }

    public void setOnSwitchPanelListener(b bVar) {
        this.KgK = bVar;
    }

    public void setChattingContext(ChatFooter.b bVar) {
        this.KgL = bVar;
    }

    public void setAppPanelListener(a aVar) {
        this.KgJ = aVar;
    }

    public void setPortHeighDP(int i2) {
        if (COl != i2) {
            COl = i2;
            this.Khi = true;
        }
    }

    public void setPortHeighPx(int i2) {
        if (this.Khj != i2) {
            this.Khj = i2;
            this.Khi = true;
        }
    }

    public void setNeedRefreshHeight(boolean z) {
        this.Khi = z;
    }

    public final void gpZ() {
        AppMethodBeat.i(31483);
        Log.i("MicroMsg.AppPanel", "[forceRefreshSize]");
        gqa();
        gpY();
        AppMethodBeat.o(31483);
    }

    private void gqa() {
        AppMethodBeat.i(31484);
        if (this.Khi) {
            if (getScreenOrientation() == 2) {
                Log.d("MicroMsg.AppPanel", "initFlipper, landscape");
                View findViewById = findViewById(R.id.sb);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) COm);
                findViewById.setLayoutParams(layoutParams);
            } else {
                Log.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", Integer.valueOf(COl));
                View findViewById2 = findViewById(R.id.sb);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                layoutParams2.height = getPortHeightPX();
                findViewById2.setLayoutParams(layoutParams2);
            }
            this.Khi = false;
        }
        AppMethodBeat.o(31484);
    }

    private int getPortHeightPX() {
        AppMethodBeat.i(31485);
        if (this.Khj > 0) {
            int i2 = this.Khj;
            AppMethodBeat.o(31485);
            return i2;
        }
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) COl);
        AppMethodBeat.o(31485);
        return fromDPToPix;
    }

    static /* synthetic */ void d(AppPanel appPanel) {
        int i2;
        boolean z;
        AppGrid appGrid;
        AppMethodBeat.i(31489);
        Log.i("MicroMsg.AppPanel", "init app grid: %s, %s", Integer.valueOf(appPanel.COB), Integer.valueOf(appPanel.COC));
        if (appPanel.COB == 0 || appPanel.COC == 0) {
            AppMethodBeat.o(31489);
            return;
        }
        if (appPanel.KgP == -1) {
            appPanel.COD.setToScreen(appPanel.KgO);
        }
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(appPanel.context, 82.0f);
        int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(appPanel.context, 90.0f);
        appPanel.gpV();
        int i3 = 4;
        if (!appPanel.Khd) {
            i3 = appPanel.COB / fromDPToPix;
        }
        int i4 = appPanel.COC / fromDPToPix2;
        if (i4 > 2) {
            i4 = 2;
        }
        int i5 = (appPanel.COC - (fromDPToPix2 * i4)) / (i4 + 1);
        Log.d("MicroMsg.AppPanel", "jacks spacing2 = %d", Integer.valueOf(i5));
        Log.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", Integer.valueOf(appPanel.COB), Integer.valueOf(appPanel.COC));
        int i6 = i3 == 0 ? 1 : i3;
        if (i4 == 0) {
            i4 = 1;
        }
        appPanel.KgN = i4;
        appPanel.Kgu = i6 * i4;
        if (appPanel.KgQ.Khw.value) {
            appPanel.xeA = appPanel.Kgx + appPanel.jGV.size();
        } else {
            appPanel.xeA = appPanel.Kgx;
        }
        int i7 = appPanel.xeA;
        a aVar = appPanel.KgQ;
        if (aVar.KhP != null) {
            i2 = aVar.KhP.size();
        } else {
            i2 = 0;
        }
        appPanel.xeA = i2 + i7;
        int ceil = (int) Math.ceil(((double) appPanel.xeA) / ((double) appPanel.Kgu));
        Log.i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", Integer.valueOf(appPanel.xeA), Integer.valueOf(appPanel.Kgu), Integer.valueOf(ceil), Integer.valueOf(appPanel.Kgx), Integer.valueOf(appPanel.jGV.size()));
        if (appPanel.Khf == ceil) {
            Log.i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", Integer.valueOf(appPanel.Khf), Integer.valueOf(ceil));
            z = false;
        } else {
            z = true;
        }
        if (z) {
            appPanel.KgM = new ArrayList();
            appPanel.COD.removeAllViews();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 0;
        if (ceil > 10) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16776, 0, 1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(999, 1, 1);
        }
        AnonymousClass5 r18 = new com.tencent.f.i.b() {
            /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass5 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "initAppGrid";
            }

            public final void run() {
                AppMethodBeat.i(31458);
                Log.e("MicroMsg.AppPanel", "initAppGrid ANR!");
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(999, 2, 1);
                AppMethodBeat.o(31458);
            }
        };
        com.tencent.f.h.RTc.o(r18, 5000);
        int i8 = 0;
        while (true) {
            if (i8 >= ceil) {
                break;
            } else if (i8 >= ceil) {
                Log.e("MicroMsg.AppPanel", "my god! you see a ghost! %s", Integer.valueOf(ceil));
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(999, 0, 1);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16776, 1, 0);
                break;
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (z || appPanel.KgM.size() <= i8 || appPanel.KgM.get(i8) == null) {
                    appGrid = (AppGrid) inflate(appPanel.context, R.layout.gb, null);
                } else {
                    appGrid = appPanel.KgM.get(i8);
                }
                Log.i("MicroMsg.AppPanel", "[initAppGrid] i:%s cost:%sms", Integer.valueOf(i8), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                j2 += System.currentTimeMillis() - currentTimeMillis2;
                appGrid.Kgy = new AppGrid.a(appGrid.context, appPanel.jGV, appPanel.Khc, appPanel.KgQ.getAppPanelUnCertainEnterArrayList());
                appGrid.setBackgroundResource(0);
                appGrid.setAdapter((ListAdapter) appGrid.Kgy);
                appGrid.setOnItemClickListener(appGrid.ppw);
                appGrid.setOnItemLongClickListener(appGrid.tej);
                appGrid.setPadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(appGrid.context, 16.0f), BackwardSupportUtil.BitmapFactory.fromDPToPix(appGrid.context, 6.0f), BackwardSupportUtil.BitmapFactory.fromDPToPix(appGrid.context, 16.0f), 0);
                int i9 = appPanel.xeA;
                int i10 = appPanel.Kgu;
                int i11 = appPanel.Kgx;
                appGrid.Kgw = i8;
                appGrid.Kgt = i9;
                appGrid.Kgu = i10;
                appGrid.Kgv = ceil;
                appGrid.Kgx = i11;
                appGrid.setNumColumns(i6);
                if (i5 > 0) {
                    appGrid.setPadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(appGrid.context, 16.0f), i5, BackwardSupportUtil.BitmapFactory.fromDPToPix(appGrid.context, 16.0f), 0);
                    appGrid.setVerticalSpacing(i5 / 2);
                }
                if (z) {
                    appPanel.COD.addView(appGrid, new LinearLayout.LayoutParams(-1, -2));
                    appPanel.KgM.add(appGrid);
                }
                i8++;
            }
        }
        r18.cancel();
        Log.i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j2));
        for (AppGrid appGrid2 : appPanel.KgM) {
            appGrid2.setOnAppSelectedListener(appPanel.Khg);
        }
        if (appPanel.KgM.size() <= 1) {
            appPanel.COE.setVisibility(4);
        } else {
            appPanel.COE.setVisibility(0);
            appPanel.COE.setDotCount(appPanel.KgM.size());
            int curScreen = appPanel.COD.getCurScreen();
            appPanel.COD.setToScreen(curScreen);
            appPanel.COE.setSelectedDot(curScreen);
        }
        appPanel.Khf = ceil;
        appPanel.requestLayout();
        appPanel.gpX();
        AppMethodBeat.o(31489);
    }

    static /* synthetic */ boolean l(AppPanel appPanel) {
        com.tencent.mm.plugin.card.c.b bVar;
        AppMethodBeat.i(232216);
        if (appPanel.Khb || (bVar = (com.tencent.mm.plugin.card.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.card.c.b.class)) == null) {
            AppMethodBeat.o(232216);
            return false;
        } else if (!bVar.cuq() || bVar.cut() <= 0) {
            AppMethodBeat.o(232216);
            return false;
        } else {
            AppMethodBeat.o(232216);
            return true;
        }
    }

    static /* synthetic */ void iu(List list) {
        AppMethodBeat.i(31486);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(31486);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            g gVar = (g) list.get(i2);
            if (gVar != null && g.JVS.equals(gVar.field_appId)) {
                list.remove(gVar);
                Log.i("MicroMsg.AppPanel", "do remove card");
                AppMethodBeat.o(31486);
                return;
            }
        }
        AppMethodBeat.o(31486);
    }

    static /* synthetic */ void b(AppPanel appPanel, List list) {
        int count;
        boolean z;
        AppMethodBeat.i(232217);
        boolean z2 = appPanel.KgU;
        appPanel.KgU = false;
        boolean z3 = appPanel.KgV;
        boolean z4 = appPanel.KgW;
        boolean z5 = appPanel.KgX;
        appPanel.KgV = false;
        appPanel.KgW = false;
        appPanel.KgX = false;
        int i2 = appPanel.KgT;
        new ArrayList();
        if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            count = 0;
        } else {
            Cursor hG = a.C1616a.eAZ().hG(0, i2);
            if (hG == null) {
                count = 0;
            } else {
                count = hG.getCount();
                hG.close();
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(count);
        objArr[1] = Integer.valueOf(appPanel.KgT);
        objArr[2] = Integer.valueOf(list != null ? list.size() : -1);
        Log.i("MicroMsg.AppPanel", "serviceCount, %d, %s, %s", objArr);
        appPanel.Khc = new HashMap();
        if (count > 0) {
            if (list == null || list.size() <= 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(965, 36);
            } else {
                int i3 = 0;
                while (i3 < list.size()) {
                    g gVar = (g) list.get(i3);
                    if (!(gVar == null || gVar.field_appId == null || !gVar.gmR())) {
                        if ((gVar.field_serviceAppInfoFlag & 1) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            appPanel.KgU = true;
                        }
                        if (g.JVR.equals(gVar.field_appId)) {
                            appPanel.Khc.put(g.JVR, gVar);
                            Log.i("MicroMsg.AppPanel", "remittance: %s, %s", Boolean.valueOf(appPanel.KgZ), Boolean.valueOf(appPanel.KgV));
                            if (!appPanel.KgZ) {
                                appPanel.KgV = true;
                            }
                            list.remove(i3);
                            i3--;
                        }
                        if (g.JVT.equals(gVar.field_appId)) {
                            appPanel.Khc.put(g.JVT, gVar);
                            Log.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", Boolean.valueOf(appPanel.KgY), Boolean.valueOf(appPanel.KgW));
                            if (!appPanel.KgY) {
                                appPanel.KgW = true;
                            }
                            list.remove(i3);
                            i3--;
                        }
                        if (g.JVU.equals(gVar.field_appId)) {
                            appPanel.Khc.put(g.JVU, gVar);
                            Log.i("MicroMsg.AppPanel", "aa: %s, %s", Boolean.valueOf(appPanel.KgY), Boolean.valueOf(appPanel.KgW));
                            if (!appPanel.Kha) {
                                appPanel.KgX = true;
                            }
                            list.remove(i3);
                            i3--;
                        }
                    }
                    i3++;
                }
            }
        }
        Log.i("MicroMsg.AppPanel", "hasService %b", Boolean.valueOf(appPanel.KgU));
        if (!(z2 == appPanel.KgU && z3 == appPanel.KgV && z4 == appPanel.KgW && z5 == appPanel.KgX)) {
            appPanel.KgQ.Aa(appPanel.KgU);
            appPanel.KgQ.Ab(appPanel.KgV);
            appPanel.KgQ.Ae(appPanel.KgW);
            appPanel.KgQ.Af(appPanel.KgX);
            appPanel.gpV();
        }
        AppMethodBeat.o(232217);
    }

    static /* synthetic */ void a(AppPanel appPanel, boolean z) {
        AppMethodBeat.i(232218);
        if (!Khh) {
            Khh = true;
            com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.pluginsdk.ui.chat.AppPanel.AnonymousClass9 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "AppPanel_preMakeConnection";
                }

                public final void run() {
                    AppMethodBeat.i(232210);
                    com.tencent.mm.an.f.baR();
                    Log.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", 0);
                    boolean unused = AppPanel.Khh = false;
                    AppMethodBeat.o(232210);
                }
            });
        }
        if (z) {
            appPanel.KgJ.Qj(0);
            AppMethodBeat.o(232218);
            return;
        }
        appPanel.KgJ.Qj(1);
        AppMethodBeat.o(232218);
    }

    static /* synthetic */ boolean w(AppPanel appPanel) {
        AppMethodBeat.i(232220);
        if (!as.avl(appPanel.KgL.getTalkerUserName())) {
            AppMethodBeat.o(232220);
            return false;
        } else if (((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getConversationStorage().avq(appPanel.KgL.getTalkerUserName()).field_actionPermission == 0) {
            AppMethodBeat.o(232220);
            return true;
        } else {
            AppMethodBeat.o(232220);
            return false;
        }
    }

    static /* synthetic */ void x(AppPanel appPanel) {
        AppMethodBeat.i(232221);
        appPanel.beW(appPanel.context.getString(R.string.d6a));
        AppMethodBeat.o(232221);
    }
}
