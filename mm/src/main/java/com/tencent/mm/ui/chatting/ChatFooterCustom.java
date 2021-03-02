package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.al.k;
import com.tencent.mm.al.w;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.chatting.d.c;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements View.OnClickListener, cj.a {
    private c Bdk;
    private ChatFooter.g KiE;
    private MMFragment OHs;
    private ImageView PeL;
    public ImageView PeM;
    public LinearLayout PeN;
    public g PeO;
    private c.a PeP;
    private Boolean PeQ;
    private Map<String, ap> PeR;
    private List<ap> PeS;
    private int PeT;
    private ci PeU;
    private a PeV;
    private b PeW;
    private List<String> PeX;
    private final String PeY;
    private final String PeZ;
    private k Pfa;
    private Object dBh;
    private as dSh;
    private String mRa;
    private LinearLayout rmL;

    static /* synthetic */ void a(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(34340);
        chatFooterCustom.gNm();
        AppMethodBeat.o(34340);
    }

    static /* synthetic */ void b(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(34341);
        chatFooterCustom.gNl();
        AppMethodBeat.o(34341);
    }

    static /* synthetic */ void c(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(34342);
        chatFooterCustom.gNo();
        AppMethodBeat.o(34342);
    }

    public void setOnFooterSwitchListener(ChatFooter.g gVar) {
        this.KiE = gVar;
    }

    public void setOnProcessClickListener(c.a aVar) {
        this.PeP = aVar;
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(34319);
        this.rmL = null;
        this.PeL = null;
        this.PeM = null;
        this.PeN = null;
        this.PeO = null;
        this.KiE = null;
        this.PeP = null;
        this.PeQ = Boolean.FALSE;
        this.PeR = new ConcurrentHashMap();
        this.PeS = new ArrayList();
        this.PeT = 0;
        this.PeX = new LinkedList();
        this.PeY = "qrcode";
        this.PeZ = "barcode";
        this.dBh = new Object();
        AppMethodBeat.o(34319);
    }

    public final void gNk() {
        AppMethodBeat.i(34321);
        if (this.PeV != null) {
            EventCenter.instance.removeListener(this.PeV);
        }
        if (this.PeW != null) {
            EventCenter.instance.removeListener(this.PeW);
        }
        Log.i("ChatCustomFooter", " releaseRedDotResource()");
        if (this.PeO != null) {
            g gVar = this.PeO;
            Log.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
            gVar.Pfg = "";
            gVar.eaY = false;
            if (gVar.PeR != null && gVar.PeR.size() > 0) {
                gVar.PeR.clear();
            }
            if (gVar.PeS != null && gVar.PeS.size() > 0) {
                for (ap apVar : gVar.PeS) {
                    com.tencent.mm.plugin.newtips.a.exl();
                    i.i(apVar);
                }
                gVar.PeS.clear();
            }
        }
        if (this.PeR != null && this.PeR.size() > 0) {
            this.PeR.clear();
        }
        if (this.PeS != null && this.PeS.size() > 0) {
            for (ap apVar2 : this.PeS) {
                com.tencent.mm.plugin.newtips.a.exl();
                i.i(apVar2);
            }
            this.PeS.clear();
        }
        AppMethodBeat.o(34321);
    }

    private void gNm() {
        AppMethodBeat.i(34323);
        o oVar = new o(com.tencent.mm.loader.j.b.aKV());
        if (oVar.exists() || oVar.mkdirs()) {
            if (this.OHs != null && !s.a(this.OHs, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg")) {
                Toast.makeText((Activity) getContext(), getContext().getString(R.string.gix), 1).show();
            }
            AppMethodBeat.o(34323);
            return;
        }
        Toast.makeText((Activity) getContext(), getContext().getString(R.string.b2v), 1).show();
        AppMethodBeat.o(34323);
    }

    private String getSender() {
        String str;
        AppMethodBeat.i(34324);
        StringBuilder append = new StringBuilder("getSender ").append(this.PeU == null).append(" ");
        if (this.PeU == null) {
            str = z.aTY();
        } else {
            str = this.PeU.name;
        }
        Log.i("ChatCustomFooter", append.append(str).toString());
        if (this.PeU == null) {
            String aTY = z.aTY();
            AppMethodBeat.o(34324);
            return aTY;
        }
        String str2 = this.PeU.name;
        AppMethodBeat.o(34324);
        return str2;
    }

    public final void gNn() {
        AppMethodBeat.i(34325);
        if (this.PeO != null) {
            this.PeO.gNq();
        }
        AppMethodBeat.o(34325);
    }

    public synchronized void onClick(View view) {
        String str = null;
        synchronized (this) {
            AppMethodBeat.i(34326);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Object tag = view.getTag();
            if (!(tag instanceof k)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34326);
            } else {
                h.setPayChannel(8);
                k kVar = (k) tag;
                if (this.PeQ.booleanValue()) {
                    com.tencent.mm.plugin.newtips.a.exl().a(new e(kVar.key));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19541, 2, kVar.key);
                }
                kVar.content = "";
                switch (kVar.type) {
                    case 0:
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        Log.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth()));
                        g gVar = this.PeO;
                        int width = iArr[0] + (view.getWidth() / 2);
                        int i2 = iArr[1];
                        if (gVar.isShowing()) {
                            gVar.gNq();
                            if (kVar != null && (gVar.Pfm.id != kVar.id || !gVar.Pfm.key.equals(kVar.key))) {
                                gVar.a(kVar, width, i2);
                                break;
                            }
                        } else {
                            gVar.a(kVar, width, i2);
                            break;
                        }
                    case 1:
                        Log.i("ChatCustomFooter", "get latest message");
                        gNp();
                        this.PeO.gNq();
                        kVar.state = k.iOp;
                        a(kVar, kVar.value);
                        c(kVar);
                        this.PeP.gPf();
                        if (ab.Iv(getTalkerUserName()) && WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam() && kVar.key.equalsIgnoreCase("rselfmenu_2") && kVar.value.contains("weixin://dl/")) {
                            g.ce(getContext(), kVar.value);
                            break;
                        }
                    case 2:
                        Log.i("ChatCustomFooter", "start webview url");
                        gNp();
                        this.PeO.gNq();
                        kVar.state = k.iOp;
                        a(kVar, kVar.egX);
                        c(kVar);
                        if (!q.a.JSZ.b(getContext(), kVar.value, new Object[0]) && !e.a(kVar.egX, getContext(), this.OHs, this.mRa)) {
                            Intent intent = new Intent();
                            intent.putExtra("KPublisherId", "custom_menu");
                            intent.putExtra("pre_username", this.mRa);
                            intent.putExtra("prePublishId", "custom_menu");
                            intent.putExtra("preUsername", this.mRa);
                            intent.putExtra("preChatName", this.mRa);
                            intent.putExtra("preChatTYPE", ac.aJ(this.mRa, this.mRa));
                            intent.putExtra("rawUrl", kVar.value);
                            intent.putExtra("geta8key_username", this.mRa);
                            intent.putExtra("from_scence", 1);
                            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            break;
                        }
                    case 3:
                        Log.i("ChatCustomFooter", "switch to input");
                        this.PeO.gNq();
                        gNo();
                        kVar.state = k.iOp;
                        a(kVar, kVar.value);
                        c(kVar);
                        break;
                    case 4:
                        Log.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                        gNp();
                        this.PeO.gNq();
                        kVar.state = k.iOq;
                        String str2 = kVar.id + kVar.key;
                        synchronized (this.dBh) {
                            try {
                                this.PeX.add(str2);
                            } catch (Throwable th) {
                                AppMethodBeat.o(34326);
                                throw th;
                            }
                        }
                        Log.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", str2, Integer.valueOf(this.PeX.size()));
                        b(this.mRa, new StringBuilder().append(kVar.id).toString(), kVar.key, k.iOq, kVar.name, "", kVar.value);
                        this.Pfa = kVar;
                        switch (kVar.iOt) {
                            case 100:
                                Intent intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_set_result_after_scan", true);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.q.a.o(getContext(), true)) {
                                    getContext();
                                    if (!com.tencent.mm.bh.e.bgF() && !com.tencent.mm.q.a.r(getContext(), true)) {
                                        com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 101:
                                Intent intent3 = new Intent();
                                intent3.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent3.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent3.putExtra("key_set_result_after_scan", false);
                                intent3.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.q.a.o(getContext(), true)) {
                                    getContext();
                                    if (!com.tencent.mm.bh.e.bgF() && !com.tencent.mm.q.a.r(getContext(), true)) {
                                        com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", intent3);
                                        break;
                                    }
                                }
                                break;
                            case 102:
                                gNm();
                                break;
                            case 103:
                                bg.aVF();
                                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                    com.tencent.mm.ui.base.h.a(getContext(), (String) null, new String[]{getContext().getString(R.string.ay1), getContext().getString(R.string.ay0)}, (String) null, new h.d() {
                                        /* class com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass1 */

                                        @Override // com.tencent.mm.ui.base.h.d
                                        public final void oj(int i2) {
                                            AppMethodBeat.i(34313);
                                            switch (i2) {
                                                case 0:
                                                    ChatFooterCustom.a(ChatFooterCustom.this);
                                                    AppMethodBeat.o(34313);
                                                    return;
                                                case 1:
                                                    ChatFooterCustom.b(ChatFooterCustom.this);
                                                    break;
                                            }
                                            AppMethodBeat.o(34313);
                                        }
                                    });
                                    break;
                                } else {
                                    u.kf(getContext());
                                    break;
                                }
                            case 104:
                                gNl();
                                break;
                            case 105:
                                Intent intent4 = new Intent();
                                intent4.putExtra("map_view_type", 0);
                                intent4.putExtra("map_sender_name", getSender());
                                intent4.putExtra("map_talker_name", getTalkerUserName());
                                intent4.putExtra("view_type_key", 1);
                                intent4.putExtra("key_get_location_type", 1);
                                com.tencent.mm.br.c.b(getContext(), FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent4);
                                break;
                            case 106:
                                es esVar = new es();
                                esVar.dIa.op = 1;
                                esVar.dIa.userName = this.dSh.field_username;
                                esVar.dIa.context = getContext();
                                EventCenter.instance.publish(esVar);
                                break;
                            case 107:
                                es esVar2 = new es();
                                esVar2.dIa.op = 2;
                                esVar2.dIa.userName = this.dSh.field_username;
                                esVar2.dIa.context = getContext();
                                EventCenter.instance.publish(esVar2);
                                break;
                        }
                    case 5:
                        gNp();
                        this.PeO.gNq();
                        kVar.state = k.iOp;
                        a(kVar, kVar.value);
                        c(kVar);
                        if (!TextUtils.isEmpty(kVar.value)) {
                            try {
                                JSONObject jSONObject = new JSONObject(kVar.value);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = 1035;
                                appBrandStatObject.dCw = this.mRa;
                                r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
                                Context context = getContext();
                                String optString = jSONObject.optString("userName");
                                String optString2 = jSONObject.optString("pagePath");
                                if (this.Bdk != null) {
                                    str = this.Bdk.field_appId;
                                }
                                rVar.a(context, optString, null, 0, 0, optString2, appBrandStatObject, str);
                                break;
                            } catch (JSONException e2) {
                                break;
                            }
                        }
                        break;
                    case 6:
                        Log.i("ChatCustomFooter", "jump to search");
                        gNp();
                        this.PeO.gNq();
                        kVar.state = k.iOp;
                        a(kVar, kVar.value);
                        c(kVar);
                        String str3 = kVar.value;
                        String str4 = "";
                        if (this.dSh != null) {
                            str4 = this.dSh.field_username;
                        }
                        Log.i("ChatCustomFooter", "bizMenu jumpToSearch username: %s, suggestData: %s", str4, str3);
                        Intent fXX = ai.fXX();
                        fXX.putExtra("ftsneedkeyboard", true);
                        fXX.putExtra("ftsbizscene", 75);
                        fXX.putExtra("ftsType", 2);
                        Map<String, String> h2 = ai.h(75, false, 2);
                        h2.put("userName", str4);
                        if (!af.isNullOrNil(str3)) {
                            h2.put("thirdExtParam", str3);
                        }
                        fXX.putExtra("rawUrl", ai.bd(h2));
                        fXX.putExtra("key_load_js_without_delay", true);
                        fXX.putExtra("ftsbizusername", str4);
                        fXX.addFlags(67108864);
                        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34326);
            }
        }
    }

    private boolean a(k kVar) {
        int i2;
        AppMethodBeat.i(34327);
        if (kVar == null) {
            AppMethodBeat.o(34327);
            return false;
        }
        String str = kVar.id + kVar.key;
        synchronized (this.dBh) {
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= this.PeX.size()) {
                        i2 = -1;
                        break;
                    } else if (this.PeX.get(i3).equals(str)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                } finally {
                    AppMethodBeat.o(34327);
                }
            }
            if (i2 >= 0) {
                this.PeX.remove(i2);
                Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", str, Integer.valueOf(this.PeX.size()));
                return true;
            }
            Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", str, Integer.valueOf(this.PeX.size()));
            AppMethodBeat.o(34327);
            return false;
        }
    }

    private void a(k kVar, String str) {
        AppMethodBeat.i(34328);
        b(this.mRa, new StringBuilder().append(kVar.id).toString(), kVar.key, k.iOp, kVar.name, "", str);
        AppMethodBeat.o(34328);
    }

    private void b(k kVar) {
        AppMethodBeat.i(34329);
        b(this.mRa, new StringBuilder().append(kVar.id).toString(), kVar.key, k.iOr, kVar.name, "", kVar.value);
        AppMethodBeat.o(34329);
    }

    private static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(34330);
        Log.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", str, str2, str3, str4, 0, 0, 0, str5, str6, str7);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10809, str, str2, str3, str4, 0, 0, 0, str5, str6, str7);
        AppMethodBeat.o(34330);
    }

    public String getTalkerUserName() {
        if (this.dSh == null) {
            return null;
        }
        return this.dSh.field_username;
    }

    public final boolean s(int i2, Object obj) {
        AppMethodBeat.i(34331);
        if (obj != null) {
            switch (i2) {
                case 201:
                case 203:
                    i2 = 1001;
                    break;
                case 217:
                    i2 = 1002;
                    break;
            }
            switch (i2) {
                case 1001:
                    Log.i("ChatCustomFooter", "return from camera");
                    if (obj instanceof Intent) {
                        String stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                        if (stringExtra != null) {
                            o oVar = new o(stringExtra);
                            if (!oVar.exists() || !oVar.isFile()) {
                                Log.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                            } else {
                                Log.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                                String bhK = com.tencent.mm.vfs.s.bhK(aa.z(oVar.mUri));
                                Log.i("ChatCustomFooter", "MD5 is %s", bhK);
                                if (this.Pfa == null || !(this.Pfa.iOt == 102 || this.Pfa.iOt == 103)) {
                                    Log.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                                    AppMethodBeat.o(34331);
                                    break;
                                } else {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.add(bhK);
                                    this.Pfa.state = k.iOr;
                                    this.Pfa.u(arrayList);
                                    if (a(this.Pfa)) {
                                        c(this.Pfa);
                                        b(this.Pfa);
                                    }
                                }
                            }
                            AppMethodBeat.o(34331);
                            break;
                        } else {
                            Log.e("ChatCustomFooter", "return null path");
                            AppMethodBeat.o(34331);
                            break;
                        }
                    } else {
                        Log.e("ChatCustomFooter", "type error");
                        AppMethodBeat.o(34331);
                        break;
                    }
                    break;
                case 1002:
                    Log.i("ChatCustomFooter", "return from albumn");
                    if (obj instanceof Intent) {
                        ArrayList<String> stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                            Iterator<String> it = stringArrayListExtra.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                Log.i("ChatCustomFooter", "retrieving bitmap path %s", next);
                                if (next != null) {
                                    o oVar2 = new o(next);
                                    if (!oVar2.exists() || !oVar2.isFile()) {
                                        Log.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", next);
                                    } else {
                                        Log.i("ChatCustomFooter", "%s retrieved!", next);
                                        String bhK2 = com.tencent.mm.vfs.s.bhK(aa.z(oVar2.mUri));
                                        arrayList2.add(bhK2);
                                        Log.i("ChatCustomFooter", "MD5 is %s", bhK2);
                                    }
                                } else {
                                    Log.e("ChatCustomFooter", "no file contained!");
                                }
                            }
                            if (this.Pfa == null || !(this.Pfa.iOt == 104 || this.Pfa.iOt == 103 || this.Pfa.iOt == 102)) {
                                Log.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                                AppMethodBeat.o(34331);
                                break;
                            } else {
                                this.Pfa.state = k.iOr;
                                this.Pfa.u(arrayList2);
                                if (a(this.Pfa)) {
                                    c(this.Pfa);
                                    b(this.Pfa);
                                }
                            }
                        }
                        AppMethodBeat.o(34331);
                        break;
                    } else {
                        Log.e("ChatCustomFooter", "type error");
                        AppMethodBeat.o(34331);
                        break;
                    }
                    break;
                case 1003:
                    Log.i("ChatCustomFooter", "send qrcode wait msg");
                    if (eg(obj)) {
                        this.PeP.gPf();
                        AppMethodBeat.o(34331);
                        break;
                    } else {
                        AppMethodBeat.o(34331);
                        break;
                    }
                case 1004:
                    Log.i("ChatCustomFooter", "send qrcode direct");
                    eg(obj);
                    AppMethodBeat.o(34331);
                    break;
                case 1005:
                    Log.i("ChatCustomFooter", "send current");
                    ef(obj);
                    AppMethodBeat.o(34331);
                    break;
                case 1006:
                    Log.i("ChatCustomFooter", "send selected");
                    ef(obj);
                    AppMethodBeat.o(34331);
                    break;
                default:
                    AppMethodBeat.o(34331);
                    break;
            }
        } else {
            Log.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
            AppMethodBeat.o(34331);
        }
        return true;
    }

    private boolean ef(Object obj) {
        AppMethodBeat.i(34332);
        if (!(obj instanceof pz)) {
            Log.e("ChatCustomFooter", "send current location data type error!");
            AppMethodBeat.o(34332);
        } else {
            pz pzVar = (pz) obj;
            double d2 = pzVar.dWg.lat;
            double d3 = pzVar.dWg.lng;
            int i2 = pzVar.dWg.dRt;
            String str = pzVar.dWg.label;
            String str2 = pzVar.dWg.dWi;
            Log.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i2), str, str2);
            if (this.Pfa == null || this.Pfa.iOt != 105) {
                Log.e("ChatCustomFooter", "cache lost or location type is not correct");
                AppMethodBeat.o(34332);
            } else {
                this.Pfa.state = k.iOr;
                this.Pfa.a(d2, d3, i2, str, str2);
                if (a(this.Pfa)) {
                    c(this.Pfa);
                    b(this.Pfa);
                }
                AppMethodBeat.o(34332);
            }
        }
        return true;
    }

    private boolean eg(Object obj) {
        AppMethodBeat.i(34333);
        if (obj == null || !(obj instanceof qa)) {
            AppMethodBeat.o(34333);
            return false;
        }
        String str = ((qa) obj).dWj.dWl;
        String str2 = ((qa) obj).dWj.scanResult;
        if (!e.d.bcW(str)) {
            str2 = str + "," + str2;
        }
        if (this.Pfa == null || !(this.Pfa.iOt == 100 || this.Pfa.iOt == 101)) {
            Log.e("ChatCustomFooter", "null pointer in cache or type error");
            AppMethodBeat.o(34333);
            return false;
        }
        Log.i("ChatCustomFooter", "scan type: %s , scan result:%s", str, str2);
        this.Pfa.state = k.iOr;
        this.Pfa.bf(bmv(str), str2);
        if (a(this.Pfa)) {
            c(this.Pfa);
            b(this.Pfa);
        }
        AppMethodBeat.o(34333);
        return true;
    }

    private static String bmv(String str) {
        AppMethodBeat.i(34334);
        if (e.d.bcW(str)) {
            AppMethodBeat.o(34334);
            return "qrcode";
        }
        AppMethodBeat.o(34334);
        return "barcode";
    }

    private void c(k kVar) {
        AppMethodBeat.i(34335);
        Log.i("ChatCustomFooter", kVar.getInfo());
        bg.azz().a(new w(this.mRa, kVar.getInfo()), 0);
        AppMethodBeat.o(34335);
    }

    public final void M(ViewGroup viewGroup) {
        AppMethodBeat.i(34336);
        this.rmL = (LinearLayout) findViewById(R.id.av7);
        this.PeN = (LinearLayout) findViewById(R.id.avb);
        this.PeN.setVisibility(0);
        this.PeM = (ImageView) findViewById(R.id.ava);
        this.PeM.setVisibility(0);
        this.PeM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(34314);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ChatFooterCustom.c(ChatFooterCustom.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34314);
            }
        });
        this.PeL = (ImageView) findViewById(R.id.av6);
        this.PeL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(34315);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ChatFooterCustom.this.PeO.gNq();
                ImageView imageView = (ImageView) view;
                if (imageView.getTag() == null) {
                    imageView.setTag(new Object());
                    imageView.setImageResource(R.drawable.aiq);
                    for (int i2 = 0; i2 < ChatFooterCustom.this.PeT; i2++) {
                        ChatFooterCustom.this.rmL.getChildAt(i2).setVisibility(i2 >= 3 ? 0 : 8);
                    }
                } else {
                    imageView.setTag(null);
                    imageView.setImageResource(R.drawable.aip);
                    for (int i3 = 0; i3 < ChatFooterCustom.this.PeT; i3++) {
                        ChatFooterCustom.this.rmL.getChildAt(i3).setVisibility(i3 < 3 ? 0 : 8);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34315);
            }
        });
        this.PeO = new g(getContext(), viewGroup);
        this.PeO.Pff = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(34316);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ChatFooterCustom.this.onClick(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34316);
            }
        };
        AppMethodBeat.o(34336);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(34337);
        String a2 = com.tencent.mm.platformtools.z.a(aVar.heO.KHn);
        Log.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(a2)));
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a2));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        String name = newPullParser.getName();
                        if ("sysmsg".equals(name)) {
                            if ("type".equals(newPullParser.getAttributeName(0))) {
                                newPullParser.getAttributeValue(0);
                                break;
                            } else {
                                break;
                            }
                        } else if (!ch.COL_USERNAME.equals(name)) {
                            if ("data".equals(name)) {
                                newPullParser.nextText();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            newPullParser.nextText();
                            break;
                        }
                }
            }
            AppMethodBeat.o(34337);
        } catch (Exception e2) {
            Log.printErrStackTrace("ChatCustomFooter", e2, "", new Object[0]);
            AppMethodBeat.o(34337);
        }
    }

    class a extends IListener<pz> {
        private a() {
            AppMethodBeat.i(161517);
            this.__eventId = pz.class.getName().hashCode();
            AppMethodBeat.o(161517);
        }

        /* synthetic */ a(ChatFooterCustom chatFooterCustom, byte b2) {
            this();
            AppMethodBeat.i(161518);
            this.__eventId = pz.class.getName().hashCode();
            AppMethodBeat.o(161518);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pz pzVar) {
            AppMethodBeat.i(34317);
            pz pzVar2 = pzVar;
            switch (pzVar2.dWg.cSx) {
                case 0:
                    ChatFooterCustom.this.s(1005, pzVar2);
                    break;
                case 1:
                    ChatFooterCustom.this.s(1006, pzVar2);
                    break;
            }
            AppMethodBeat.o(34317);
            return false;
        }
    }

    class b extends IListener<qa> {
        private b() {
            AppMethodBeat.i(161519);
            this.__eventId = qa.class.getName().hashCode();
            AppMethodBeat.o(161519);
        }

        /* synthetic */ b(ChatFooterCustom chatFooterCustom, byte b2) {
            this();
            AppMethodBeat.i(161520);
            this.__eventId = qa.class.getName().hashCode();
            AppMethodBeat.o(161520);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qa qaVar) {
            AppMethodBeat.i(34318);
            qa qaVar2 = qaVar;
            switch (qaVar2.dWj.cSx) {
                case 0:
                    ChatFooterCustom.this.s(1003, qaVar2);
                    break;
                case 1:
                    ChatFooterCustom.this.s(1004, qaVar2);
                    break;
            }
            AppMethodBeat.o(34318);
            return false;
        }
    }

    private void gNo() {
        AppMethodBeat.i(34338);
        Log.i("ChatCustomFooter", "switch footer");
        if (this.KiE != null) {
            this.PeO.gNq();
            this.KiE.An(true);
        }
        AppMethodBeat.o(34338);
    }

    public as getTalker() {
        return this.dSh;
    }

    public void setTalker(as asVar) {
        this.dSh = asVar;
    }

    private void gNp() {
        AppMethodBeat.i(34339);
        if (this.dSh == null) {
            AppMethodBeat.o(34339);
            return;
        }
        if (this.dSh.fuQ == 1) {
            bg.aVF();
            com.tencent.mm.model.c.aST().bkd(this.dSh.field_username);
        }
        AppMethodBeat.o(34339);
    }

    public final void a(MMFragment mMFragment, com.tencent.mm.api.c cVar, String str) {
        AppMethodBeat.i(34320);
        c.b.C0262c Ve = cVar.cG(false).Ve();
        if (Ve == null || Ve.dij == null || str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(" menuInfo or username is null ! ");
            AppMethodBeat.o(34320);
            throw illegalArgumentException;
        }
        this.PeQ = Boolean.valueOf(str.equals("gh_f0a92aa7146c"));
        this.PeT = Math.min(Ve.dij.size(), 6);
        Log.i("ChatCustomFooter", "setMenus, count:" + this.PeT);
        if (this.PeT <= 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(" mTabCount is invalid ! ");
            AppMethodBeat.o(34320);
            throw illegalArgumentException2;
        }
        if (this.PeT > 3) {
            this.PeL.setVisibility(0);
        } else {
            this.PeL.setVisibility(8);
        }
        this.rmL.setWeightSum((float) Math.min(this.PeT, 3));
        for (int i2 = 0; i2 < 6; i2++) {
            FrameLayout frameLayout = (FrameLayout) this.rmL.getChildAt(i2);
            final TextView textView = (TextView) frameLayout.findViewById(R.id.av9);
            textView.setTextSize(1, Math.min(1.125f, com.tencent.mm.cb.a.ez(getContext())) * 17.0f);
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.av8);
            imageView.setVisibility(8);
            if (i2 < this.PeT) {
                final k kVar = Ve.dij.get(i2);
                frameLayout.setTag(kVar);
                textView.setText(l.c(getContext(), kVar.name));
                if (kVar.type == 0) {
                    int textSize = (((int) textView.getTextSize()) * 2) / 3;
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = textSize;
                    layoutParams.width = textSize;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageDrawable(ar.m(getContext(), R.raw.biz_menu_show_sub_menu_icon, getContext().getResources().getColor(R.color.FG_2)));
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
                if (this.PeQ.booleanValue()) {
                    Log.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
                    Log.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", kVar.key, kVar.name);
                    if (this.PeR.containsKey(kVar.key)) {
                        Log.d("ChatCustomFooter", "this key has register");
                    } else {
                        ap apVar = new ap(getContext(), kVar.key, new ap.a() {
                            /* class com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass5 */

                            @Override // com.tencent.mm.ui.chatting.ap.a
                            public final void O(boolean z, String str) {
                                AppMethodBeat.i(232843);
                                Log.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", Boolean.valueOf(z), str);
                                if (textView == null) {
                                    Log.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
                                    AppMethodBeat.o(232843);
                                } else if (z) {
                                    new MMHandler().postDelayed(new Runnable() {
                                        /* class com.tencent.mm.ui.chatting.ChatFooterCustom.AnonymousClass5.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(232842);
                                            Drawable drawable = ChatFooterCustom.this.getContext().getResources().getDrawable(R.drawable.b1a);
                                            drawable.setBounds(0, 0, at.fromDPToPix(ChatFooterCustom.this.getContext(), 8), at.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                                            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
                                            SpannableString spannableString = new SpannableString("@");
                                            spannableString.setSpan(aVar, 0, 1, 33);
                                            Log.i("ChatCustomFooter", "setReddotText：%s", kVar.key);
                                            textView.setText(TextUtils.concat(((Object) l.c(ChatFooterCustom.this.getContext(), kVar.name)) + " ", spannableString));
                                            AppMethodBeat.o(232842);
                                        }
                                    }, 500);
                                    AppMethodBeat.o(232843);
                                } else {
                                    Log.i("ChatCustomFooter", "dont setReddotText:%s", kVar.key);
                                    textView.setText(l.c(ChatFooterCustom.this.getContext(), kVar.name));
                                    AppMethodBeat.o(232843);
                                }
                            }
                        });
                        com.tencent.mm.plugin.newtips.a.exl().h(apVar);
                        this.PeR.put(kVar.key, apVar);
                        this.PeS.add(apVar);
                        Log.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", Integer.valueOf(this.PeR.size()), Integer.valueOf(this.PeS.size()));
                    }
                    this.PeO.d(kVar);
                }
            } else if (i2 < 3 || this.PeT <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText("");
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
        }
        this.OHs = mMFragment;
        this.mRa = str;
        this.Bdk = cVar;
        if (this.PeV != null) {
            EventCenter.instance.removeListener(this.PeV);
        }
        if (this.PeW != null) {
            EventCenter.instance.removeListener(this.PeW);
        }
        this.PeV = new a(this, (byte) 0);
        this.PeW = new b(this, (byte) 0);
        EventCenter.instance.addListener(this.PeV);
        EventCenter.instance.addListener(this.PeW);
        AppMethodBeat.o(34320);
    }

    private void gNl() {
        AppMethodBeat.i(34322);
        if (!(this.OHs == null || this.dSh == null || af.isNullOrNil(this.mRa))) {
            s.a((Fragment) this.OHs, this.mRa, this.dSh.field_username);
        }
        AppMethodBeat.o(34322);
    }
}
