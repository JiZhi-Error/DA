package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@i
public class NearbyFriendsUI extends MMActivity implements com.tencent.mm.ak.i {
    private c AAa;
    private com.tencent.mm.plugin.nearby.a.c AAb;
    private com.tencent.mm.plugin.nearby.a.d AAc;
    private boolean AAd = false;
    private String[] AAe;
    private BindMobileOrQQHeaderView AAf;
    private View AAg;
    private b AAh;
    private com.tencent.mm.plugin.nearby.a.c AzP;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass8 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            boolean z2;
            AppMethodBeat.i(89846);
            if (NearbyFriendsUI.this.uSr) {
                AppMethodBeat.o(89846);
                return false;
            }
            NearbyFriendsUI.this.uSr = true;
            if (NearbyFriendsUI.this.ifz) {
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                g.Wn(11);
                AppMethodBeat.o(89846);
                return false;
            }
            if (z) {
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.setMessage(NearbyFriendsUI.this.getString(R.string.f_u));
                }
                NearbyFriendsUI.this.AAh = new b(f3, f2, (int) d3);
                com.tencent.mm.modelstat.e bge = com.tencent.mm.modelstat.e.bge();
                boolean z3 = i2 != 0;
                if (NearbyFriendsUI.this.gmt == null) {
                    z2 = false;
                } else {
                    z2 = NearbyFriendsUI.this.gmt.iVk;
                }
                bge.a(2001, z3, z2, f2, f3, (int) d3);
                NearbyFriendsUI.this.AAb = new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.this.uSp, NearbyFriendsUI.this.AAh.iUZ, NearbyFriendsUI.this.AAh.iUY, NearbyFriendsUI.this.AAh.accuracy, i2, "", "");
                com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.this.AAb, 0);
            } else {
                g.Wn(11);
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                NearbyFriendsUI.this.findViewById(R.id.fu7).setVisibility(0);
                NearbyFriendsUI.this.khv.setVisibility(8);
                NearbyFriendsUI.this.uSq = true;
                if (!NearbyFriendsUI.this.uSu && !com.tencent.mm.modelgeo.d.bcc()) {
                    NearbyFriendsUI.this.uSu = true;
                    h.a((Context) NearbyFriendsUI.this, NearbyFriendsUI.this.getString(R.string.dvi), NearbyFriendsUI.this.getString(R.string.zb), NearbyFriendsUI.this.getString(R.string.e_k), NearbyFriendsUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass8.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(89845);
                            com.tencent.mm.modelgeo.d.cZ(NearbyFriendsUI.this);
                            AppMethodBeat.o(89845);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
            }
            AppMethodBeat.o(89846);
            return false;
        }
    };
    private IListener gmC = new IListener<ls>() {
        /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160514);
            this.__eventId = ls.class.getName().hashCode();
            AppMethodBeat.o(160514);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ls lsVar) {
            AppMethodBeat.i(89839);
            ls lsVar2 = lsVar;
            if (lsVar2 != null && (lsVar2 instanceof ls)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(89838);
                        NearbyFriendsUI.a(NearbyFriendsUI.this);
                        AppMethodBeat.o(89838);
                    }
                });
            }
            AppMethodBeat.o(89839);
            return false;
        }
    };
    private com.tencent.mm.modelgeo.d gmt;
    boolean ifz = false;
    private ListView khv;
    private List<chi> sNv = new LinkedList();
    private q tipDialog = null;
    private Map<String, a> uRY = new HashMap();
    private ViewGroup uSh;
    private View uSj = null;
    private View uSk;
    private boolean uSm = false;
    private int uSn;
    private int uSp = 1;
    private boolean uSq = false;
    private boolean uSr = false;
    private int uSs = 0;
    private boolean uSu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NearbyFriendsUI() {
        AppMethodBeat.i(89866);
        AppMethodBeat.o(89866);
    }

    static /* synthetic */ void A(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(89882);
        nearbyFriendsUI.dlx();
        AppMethodBeat.o(89882);
    }

    static /* synthetic */ void a(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(89878);
        nearbyFriendsUI.ewW();
        AppMethodBeat.o(89878);
    }

    static /* synthetic */ void w(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(89879);
        nearbyFriendsUI.getData();
        AppMethodBeat.o(89879);
    }

    /* access modifiers changed from: package-private */
    public class b {
        public int accuracy;
        public float iUY;
        public float iUZ;

        public b(float f2, float f3, int i2) {
            this.iUY = f2;
            this.iUZ = f3;
            this.accuracy = i2;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        Map<String, String> parseXml;
        int i2;
        a aVar;
        AppMethodBeat.i(89867);
        g.Wl(11);
        super.onCreate(bundle);
        setMMTitle(R.string.fad);
        com.tencent.mm.kernel.g.azz().a(148, this);
        com.tencent.mm.kernel.g.azz().a(376, this);
        com.tencent.mm.kernel.g.azz().a(1087, this);
        this.gmt = com.tencent.mm.modelgeo.d.bca();
        initView();
        this.AAe = new String[]{getResources().getString(R.string.fa6), getResources().getString(R.string.fa5), getResources().getString(R.string.fa4), getResources().getString(R.string.gb0)};
        this.uSp = Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(16386, (Object) null), 1);
        if (this.uSp == 3) {
            setTitleLogo(0, R.raw.ic_sex_male);
        } else if (this.uSp == 4) {
            setTitleLogo(0, R.raw.ic_sex_female);
        } else {
            setTitleLogo(0, 0);
            this.uSp = 1;
        }
        getData();
        if (LocaleUtil.isSimplifiedChineseAppLang() && (parseXml = XmlParser.parseXml(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_nearby_ad, ""), "lbsads", null)) != null && (i2 = Util.getInt(parseXml.get(".lbsads.$count"), 0)) > 0) {
            int i3 = 0;
            while (i3 < i2) {
                String str = ".lbsads.lbsad" + (i3 == 0 ? "" : Integer.valueOf(i3));
                a aVar2 = new a((byte) 0);
                aVar2.id = parseXml.get(str + ".$id");
                aVar2.pos = Util.getInt(parseXml.get(str + ".$pos"), 0);
                aVar2.uSa = Util.getInt(parseXml.get(str + ".$close_times"), 0);
                aVar2.uSb = Util.getInt(parseXml.get(str + ".$show_times"), Integer.MAX_VALUE);
                aVar2.name = parseXml.get(str + ".name");
                aVar2.desc = parseXml.get(str + ".desc");
                aVar2.icon = parseXml.get(str + ".icon");
                aVar2.uSc = Util.getInt(parseXml.get(str + ".jump.$type"), 0);
                aVar2.uSd = parseXml.get(str + ".jump");
                this.uRY.put(aVar2.id, aVar2);
                i3++;
            }
            Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_NEAR_BY_AD_STRING_SYNC, (Object) null);
            for (String str2 : (obj == null ? "" : (String) obj).split("\\|")) {
                String[] split = str2.split(":");
                if (split.length == 3 && (aVar = this.uRY.get(split[0])) != null) {
                    aVar.uSe = Util.getInt(split[1], 0);
                    aVar.qdp = Util.getInt(split[2], 0);
                }
            }
        }
        AppMethodBeat.o(89867);
    }

    private void getData() {
        AppMethodBeat.i(89868);
        this.uSr = false;
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.tipDialog = h.a((Context) context, getString(R.string.fa3), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(89844);
                NearbyFriendsUI.this.ifz = true;
                g.Wn(11);
                if (NearbyFriendsUI.this.AAb != null) {
                    com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.this.AAb);
                }
                Log.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
                if (!NearbyFriendsUI.this.uSq) {
                    NearbyFriendsUI.this.finish();
                    Log.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
                }
                AppMethodBeat.o(89844);
            }
        });
        this.ifz = false;
        if (this.gmt != null) {
            this.gmt.a(this.gmA, true);
        }
        AppMethodBeat.o(89868);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bf0;
    }

    private void ewW() {
        View view;
        AppMethodBeat.i(89869);
        if (com.tencent.mm.bp.a.glC()) {
            if (this.uSj != null) {
                this.khv.removeHeaderView(this.uSj);
                this.uSj = null;
            }
            View inflate = View.inflate(this, R.layout.bf4, null);
            TextView textView = (TextView) inflate.findViewById(R.id.h_k);
            com.tencent.mm.kernel.g.aAf().azk();
            int ctM = ((l) com.tencent.mm.kernel.g.af(l.class)).eiv().ctM();
            if (ctM == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(R.plurals.a3, ctM, Integer.valueOf(ctM)));
                ImageView imageView = (ImageView) inflate.findViewById(R.id.faz);
                bx eiG = ((l) com.tencent.mm.kernel.g.af(l.class)).eiv().eiG();
                if (eiG != null) {
                    a.b.c(imageView, eiG.field_sayhiuser);
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(89847);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        NearbyFriendsUI.this.khv.removeHeaderView(NearbyFriendsUI.this.uSj);
                        NearbyFriendsUI.this.uSj = null;
                        Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                        intent.putExtra("k_say_hi_type", 2);
                        intent.putExtra("show_clear_header", true);
                        NearbyFriendsUI.this.startActivityForResult(intent, 2009);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(89847);
                    }
                });
                view = inflate;
            }
            this.uSj = view;
            if (this.uSj != null) {
                this.khv.addHeaderView(this.uSj);
            }
        }
        AppMethodBeat.o(89869);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(89870);
        this.khv = (ListView) findViewById(R.id.fu8);
        this.AAa = new c(this);
        ListView listView = this.khv;
        if (this.uSh == null) {
            this.uSh = new LinearLayout(this);
            this.uSh.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((LinearLayout) this.uSh).setGravity(17);
        }
        this.uSm = true;
        listView.addHeaderView(this.uSh);
        String value = com.tencent.mm.n.h.aqJ().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.uSn = Integer.valueOf(value).intValue();
            } catch (Exception e2) {
                this.uSn = 0;
            }
        }
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(6, (Object) null);
        if (str != null && str.length() > 0) {
            this.uSn = 0;
        }
        this.uSs = 0;
        if (com.tencent.mm.model.a.g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            String str2 = com.tencent.mm.model.a.g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            l.a bnZ = com.tencent.mm.plugin.account.friend.a.l.bnZ();
            if (str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.uSs = 0;
            } else if (str2.equals("2")) {
                if (bnZ == l.a.SUCC_UNLOAD) {
                    this.uSs = 2;
                    f.KV(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (str2.equals("1") && bnZ == l.a.NO_INIT) {
                this.uSs = 2;
                f.KV(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.uSn > 0 || this.uSs > 0) && this.uSs != 1) {
            this.AAf = new BindMobileOrQQHeaderView(this);
            this.khv.addHeaderView(this.AAf);
        }
        this.khv.setAdapter((ListAdapter) this.AAa);
        this.khv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass10 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(89848);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (NearbyFriendsUI.this.uSn > 0 || NearbyFriendsUI.this.uSs > 0) {
                    i2--;
                }
                if (com.tencent.mm.bp.a.glC() && NearbyFriendsUI.this.uSj != null) {
                    i2--;
                }
                if (NearbyFriendsUI.this.uSm) {
                    i2--;
                }
                if (i2 < 0 || i2 >= NearbyFriendsUI.this.sNv.size()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(89848);
                    return;
                }
                chi chi = (chi) NearbyFriendsUI.this.sNv.get(i2);
                if (d.JD(chi.kdY)) {
                    a aVar = (a) NearbyFriendsUI.this.uRY.get(chi.UserName);
                    aVar.uSf |= 1;
                    if (aVar.uSc == 1) {
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1134;
                        ((r) com.tencent.mm.kernel.g.af(r.class)).a(NearbyFriendsUI.this, aVar.uSd, "", 0, 0, "", appBrandStatObject);
                    } else if (aVar.uSc == 2) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", aVar.uSd);
                        intent.putExtra("geta8key_scene", 25);
                        intent.putExtra("stastic_scene", 12);
                        com.tencent.mm.br.c.b(NearbyFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(89848);
                    return;
                }
                String str = chi.UserName;
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Scene", 18);
                    intent2.putExtra("Sns_from_Scene", 18);
                    intent2.putExtra("lbs_ticket", chi.LRO);
                    intent2.putExtra("Contact_IsLbsGotoChatting", true);
                    if (str != null && str.length() > 0) {
                        if (Kn.gBM()) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, str + ",18");
                        }
                        uj ujVar = new uj();
                        ujVar.eaI.intent = intent2;
                        ujVar.eaI.username = str;
                        EventCenter.instance.publish(ujVar);
                        intent2.putExtra("CONTACT_INFO_UI_SOURCE", 5);
                        com.tencent.mm.plugin.nearby.a.jRt.c(intent2, NearbyFriendsUI.this);
                    }
                } else {
                    Intent intent3 = new Intent();
                    intent3.putExtra("Contact_User", chi.UserName);
                    intent3.putExtra("Contact_Alias", chi.ked);
                    intent3.putExtra("Contact_Nick", chi.oUJ);
                    intent3.putExtra("Contact_Distance", chi.MmJ);
                    intent3.putExtra("Contact_Signature", chi.keb);
                    intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(chi.keh, chi.kdZ, chi.kea));
                    intent3.putExtra("Contact_Sex", chi.kdY);
                    intent3.putExtra("Contact_IsLBSFriend", true);
                    intent3.putExtra("Contact_Scene", 18);
                    intent3.putExtra("Contact_VUser_Info", chi.MmL);
                    intent3.putExtra("Contact_VUser_Info_Flag", chi.MmK);
                    intent3.putExtra("Contact_KWeibo_flag", chi.MmO);
                    intent3.putExtra("Contact_KWeibo", chi.MmM);
                    intent3.putExtra("Contact_KWeiboNick", chi.MmN);
                    intent3.putExtra("Contact_KSnsIFlag", chi.MmQ.kej);
                    intent3.putExtra("Contact_KSnsBgId", chi.MmQ.kel);
                    intent3.putExtra("Contact_KSnsBgUrl", chi.MmQ.kek);
                    intent3.putExtra("lbs_ticket", chi.LRO);
                    intent3.putExtra("Contact_IsLbsGotoChatting", true);
                    if (chi.kei != null) {
                        com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
                        cVar.field_brandList = chi.kei;
                        cVar.field_brandFlag = chi.MmR.kem;
                        cVar.field_brandIconURL = chi.MmR.kep;
                        cVar.field_extInfo = chi.MmR.ken;
                        cVar.field_brandInfo = chi.MmR.keo;
                        intent3.putExtra("KBrandInfo_item", new MCacheItem(cVar));
                    }
                    intent3.putExtra("Sns_from_Scene", 18);
                    intent3.putExtra("CONTACT_INFO_UI_SOURCE", 5);
                    com.tencent.mm.plugin.nearby.a.jRt.c(intent3, NearbyFriendsUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(89848);
            }
        });
        this.khv.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass11 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(89849);
                if (NearbyFriendsUI.this.AAa != null) {
                    c cVar = NearbyFriendsUI.this.AAa;
                    if (cVar.kex != null) {
                        cVar.kex.onTouchEvent(motionEvent);
                    }
                }
                AppMethodBeat.o(89849);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89850);
                NearbyFriendsUI.this.finish();
                AppMethodBeat.o(89850);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(89851);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(NearbyFriendsUI.this.khv);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89851);
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89855);
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) NearbyFriendsUI.this, 1, false);
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass14.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(89853);
                        switch (i2) {
                            case 0:
                                NearbyFriendsUI.this.uSp = 4;
                                NearbyFriendsUI.this.AAd = false;
                                com.tencent.mm.kernel.g.aAh().azQ().set(16386, Integer.valueOf(NearbyFriendsUI.this.uSp));
                                NearbyFriendsUI.w(NearbyFriendsUI.this);
                                AppMethodBeat.o(89853);
                                return;
                            case 1:
                                NearbyFriendsUI.this.uSp = 3;
                                NearbyFriendsUI.this.AAd = false;
                                com.tencent.mm.kernel.g.aAh().azQ().set(16386, Integer.valueOf(NearbyFriendsUI.this.uSp));
                                NearbyFriendsUI.w(NearbyFriendsUI.this);
                                AppMethodBeat.o(89853);
                                return;
                            case 2:
                                NearbyFriendsUI.this.uSp = 1;
                                NearbyFriendsUI.this.AAd = false;
                                com.tencent.mm.kernel.g.aAh().azQ().set(16386, Integer.valueOf(NearbyFriendsUI.this.uSp));
                                NearbyFriendsUI.w(NearbyFriendsUI.this);
                                AppMethodBeat.o(89853);
                                return;
                            case 3:
                                Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                                intent.putExtra("k_say_hi_type", 2);
                                NearbyFriendsUI.this.startActivityForResult(intent, 2009);
                                AppMethodBeat.o(89853);
                                return;
                            case 4:
                                NearbyFriendsUI.this.AzP = new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", "");
                                com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.this.AzP, 0);
                                NearbyFriendsUI nearbyFriendsUI = NearbyFriendsUI.this;
                                AppCompatActivity context = NearbyFriendsUI.this.getContext();
                                NearbyFriendsUI.this.getString(R.string.zb);
                                nearbyFriendsUI.tipDialog = h.a((Context) context, NearbyFriendsUI.this.getString(R.string.f_s), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass14.AnonymousClass1.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(89852);
                                        com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.this.AzP);
                                        AppMethodBeat.o(89852);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(89853);
                    }
                };
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass14.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(89854);
                        mVar.kV(-1, R.string.fa6);
                        mVar.kV(-1, R.string.fa5);
                        mVar.kV(-1, R.string.fa4);
                        mVar.kV(-1, R.string.gb0);
                        mVar.kV(-1, R.string.f_o);
                        AppMethodBeat.o(89854);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(89855);
                return true;
            }
        });
        AppMethodBeat.o(89870);
    }

    private void ewX() {
        AppMethodBeat.i(89871);
        com.tencent.mm.plugin.nearby.a.jRt.bY(this);
        AppMethodBeat.o(89871);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(89872);
        Log.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    this.AAd = false;
                    getData();
                    AppMethodBeat.o(89872);
                    return;
                }
                break;
            case 2009:
                if (i3 == -1) {
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.o(89872);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(89873);
        super.onPause();
        if (this.gmt != null) {
            this.gmt.c(this.gmA);
        }
        EventCenter.instance.removeListener(this.gmC);
        AppMethodBeat.o(89873);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(89874);
        super.onResume();
        if (this.gmt != null) {
            this.gmt.a(this.gmA, true);
        }
        ewW();
        this.AAa.notifyDataSetChanged();
        com.tencent.mm.kernel.g.aAf().azk();
        if (((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().ctM() == 0) {
            this.khv.removeHeaderView(this.uSk);
        }
        EventCenter.instance.addListener(this.gmC);
        AppMethodBeat.o(89874);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(89875);
        if (this.uSs > 0) {
            f.KW(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        g.Wn(11);
        com.tencent.mm.kernel.g.azz().b(148, this);
        com.tencent.mm.kernel.g.azz().b(376, this);
        com.tencent.mm.kernel.g.azz().b(1087, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.gmt != null) {
            this.gmt.c(this.gmA);
        }
        p.aYD().cancel();
        if (this.AAa != null) {
            c cVar = this.AAa;
            if (cVar.kex != null) {
                cVar.kex.detach();
                cVar.kex = null;
            }
        }
        if (this.sNv.size() > 0) {
            String str = "";
            for (a aVar : this.uRY.values()) {
                StringBuilder append = new StringBuilder().append(str).append("|").append(aVar.id).append(":").append(aVar.uSe).append(":");
                int i2 = aVar.qdp + 1;
                aVar.qdp = i2;
                str = append.append(i2).toString();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17431, aVar.id, Integer.valueOf(aVar.uSf + 1));
            }
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEAR_BY_AD_STRING_SYNC, str);
        }
        super.onDestroy();
        AppMethodBeat.o(89875);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(89876);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (qVar.getType() == 148) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            int Vj = ((com.tencent.mm.plugin.nearby.a.c) qVar).Vj();
            if (this.AAb == null && (Vj == 1 || Vj == 3 || Vj == 4)) {
                AppMethodBeat.o(89876);
            } else if ((Vj == 1 || Vj == 3 || Vj == 4) && this.AAd) {
                Log.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", Integer.valueOf(Vj));
                AppMethodBeat.o(89876);
            } else if (this.AzP == null && Vj == 2) {
                AppMethodBeat.o(89876);
            } else {
                Log.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (qVar.getType() != 148) {
                    AppMethodBeat.o(89876);
                } else if (i2 == 0 && i3 == 0) {
                    if (Vj == 1 || Vj == 3 || Vj == 4) {
                        this.sNv = ((com.tencent.mm.plugin.nearby.a.c) qVar).ewT();
                        if (this.sNv == null || this.sNv.size() == 0) {
                            findViewById(R.id.fu_).setVisibility(0);
                            this.khv.setVisibility(8);
                            ewX();
                            g.Wn(11);
                        } else {
                            LinkedList linkedList = new LinkedList();
                            int i4 = 0;
                            for (chi chi : this.sNv) {
                                if (((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(chi.UserName)) {
                                    linkedList.add(i4, chi);
                                    i4++;
                                } else if (!Util.isNullOrNil(chi.UserName) && !Util.isNullOrNil(chi.MmJ)) {
                                    linkedList.add(chi);
                                }
                            }
                            this.sNv.clear();
                            this.sNv = linkedList;
                            if (this.sNv == null || this.sNv.size() == 0) {
                                findViewById(R.id.fu_).setVisibility(0);
                                this.khv.setVisibility(8);
                            } else {
                                findViewById(R.id.fu_).setVisibility(8);
                                dlx();
                                this.AAa.notifyDataSetChanged();
                                if (this.AAa.getCount() > 0) {
                                    this.khv.setSelection(0);
                                }
                                this.khv.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass4 */

                                    public final void run() {
                                        AppMethodBeat.i(89842);
                                        g.Wm(11);
                                        AppMethodBeat.o(89842);
                                    }
                                });
                            }
                        }
                        if (this.uSp == 3) {
                            setTitleLogo(0, R.raw.ic_sex_male);
                        } else if (this.uSp == 4) {
                            setTitleLogo(0, R.raw.ic_sex_female);
                        } else {
                            setTitleLogo(0, 0);
                            this.uSp = 1;
                        }
                        this.AAd = true;
                        this.AAb = null;
                    }
                    if (((com.tencent.mm.plugin.nearby.a.c) qVar).Vj() == 2) {
                        h.d(getContext(), getString(R.string.f_r), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(89843);
                                NearbyFriendsUI.this.finish();
                                AppMethodBeat.o(89843);
                            }
                        });
                        this.AzP = null;
                    }
                    if (((com.tencent.mm.plugin.nearby.a.c) qVar).ewR()) {
                        String string = getString(R.string.fah);
                        int ewS = ((com.tencent.mm.plugin.nearby.a.c) qVar).ewS();
                        if (this.uSh != null) {
                            if (this.AAg == null) {
                                this.AAg = View.inflate(this, R.layout.bf5, null);
                                this.uSh.addView(this.AAg);
                                this.AAg.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass2 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(89840);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        NearbyFriendsUI.y(NearbyFriendsUI.this);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(89840);
                                    }
                                });
                            } else {
                                this.AAg.setVisibility(0);
                            }
                            ((TextView) this.AAg.findViewById(R.id.fuf)).setText(string);
                            if (ewS != 0) {
                                ((TextView) this.AAg.findViewById(R.id.fue)).setText(String.format(getResources().getQuantityString(R.plurals.w, ewS, Integer.valueOf(ewS)), new Object[0]));
                            }
                        }
                    } else if (!(this.AAg == null || this.uSh == null)) {
                        this.AAg.setVisibility(8);
                    }
                    this.uSq = true;
                    AppMethodBeat.o(89876);
                } else {
                    if (Vj == 1 || Vj == 3 || Vj == 4) {
                        TextView textView = (TextView) findViewById(R.id.fu_);
                        textView.setVisibility(0);
                        ewX();
                        com.tencent.mm.h.a Dk = (str == null || str.length() <= 0) ? null : com.tencent.mm.h.a.Dk(str);
                        if (Dk != null && Dk.desc != null && Dk.desc.length() > 0) {
                            textView.setText(Dk.desc);
                        } else if (i3 == -2001) {
                            textView.setText(getString(R.string.f_t));
                        } else {
                            textView.setText(getString(R.string.f_x));
                        }
                        this.khv.setVisibility(8);
                        this.AAb = null;
                    }
                    if (((com.tencent.mm.plugin.nearby.a.c) qVar).Vj() == 2) {
                        Toast.makeText(this, (int) R.string.f_q, 1).show();
                        this.AzP = null;
                    }
                    AppMethodBeat.o(89876);
                }
            }
        } else {
            if (qVar.getType() == 376) {
                if (((com.tencent.mm.plugin.nearby.a.d) qVar).Vj() != 1) {
                    AppMethodBeat.o(89876);
                    return;
                }
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i2 == 0 && i3 == 0 && ((com.tencent.mm.plugin.nearby.a.d) qVar).jHa != null) {
                    String str2 = ((com.tencent.mm.plugin.nearby.a.d) qVar).jHa;
                    com.tencent.mm.plugin.nearby.a.b.jc(str2, ((com.tencent.mm.plugin.nearby.a.d) qVar).Azx);
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    com.tencent.mm.plugin.nearby.a.jRt.e(intent, this);
                    AppMethodBeat.o(89876);
                    return;
                }
                h.a(getContext(), (int) R.string.faf, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            AppMethodBeat.o(89876);
        }
    }

    private void dlx() {
        int i2 = 0;
        AppMethodBeat.i(89877);
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < this.sNv.size(); i3++) {
            if (!d.JD(this.sNv.get(i3).kdY)) {
                linkedList.add(this.sNv.get(i3));
            }
        }
        this.sNv.clear();
        this.sNv = linkedList;
        Log.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
        boolean z = !this.sNv.isEmpty();
        for (String str : this.uRY.keySet()) {
            if (z) {
                a aVar = this.uRY.get(str);
                if (!aVar.oBV && ((aVar.uSa <= 0 || aVar.uSe < aVar.uSa) && aVar.qdp < aVar.uSb)) {
                    this.sNv.add((aVar.pos < 0 || aVar.pos > this.sNv.size()) ? this.sNv.size() : aVar.pos + i2, d.h(aVar.id, aVar.icon, aVar.name, aVar.desc, aVar.uSd));
                    i2++;
                }
            }
        }
        AppMethodBeat.o(89877);
    }

    /* access modifiers changed from: package-private */
    public static class d {
        public static int uSE = 10000;

        public static chi h(String str, String str2, String str3, String str4, String str5) {
            AppMethodBeat.i(89865);
            com.tencent.mm.plugin.nearby.a.a aVar = new com.tencent.mm.plugin.nearby.a.a();
            aVar.kdY = uSE;
            aVar.UserName = str;
            aVar.Lis = str2;
            aVar.MmJ = str4;
            aVar.oUJ = str3;
            aVar.kdZ = str5;
            AppMethodBeat.o(89865);
            return aVar;
        }

        public static boolean JD(int i2) {
            return i2 == uSE;
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends BaseAdapter {
        private final Context context;
        com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(new b.a() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c.AnonymousClass1 */

            @Override // com.tencent.mm.ui.applet.b.a
            public final Bitmap Ta(String str) {
                AppMethodBeat.i(89856);
                Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                AppMethodBeat.o(89856);
                return a2;
            }
        });
        private b.AbstractC2078b kez = null;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(89864);
            chi JC = JC(i2);
            AppMethodBeat.o(89864);
            return JC;
        }

        public c(Context context2) {
            AppMethodBeat.i(89860);
            this.context = context2;
            AppMethodBeat.o(89860);
        }

        public final int getCount() {
            AppMethodBeat.i(89861);
            int size = NearbyFriendsUI.this.sNv.size();
            AppMethodBeat.o(89861);
            return size;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            e eVar;
            AppMethodBeat.i(89862);
            if (this.kez == null) {
                this.kez = new b.AbstractC2078b() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                    public final String vg(int i2) {
                        AppMethodBeat.i(89857);
                        if (i2 < 0 || i2 >= c.this.getCount()) {
                            Log.e("MicroMsg.NearbyFriend", "pos is invalid");
                            AppMethodBeat.o(89857);
                            return null;
                        }
                        chi JC = c.this.JC(i2);
                        if (JC == null) {
                            AppMethodBeat.o(89857);
                            return null;
                        }
                        String str = JC.UserName;
                        AppMethodBeat.o(89857);
                        return str;
                    }

                    @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                    public final int bnW() {
                        AppMethodBeat.i(89858);
                        int count = c.this.getCount();
                        AppMethodBeat.o(89858);
                        return count;
                    }
                };
            }
            if (this.kex != null) {
                this.kex.a(i2, this.kez);
            }
            if (view == null) {
                e eVar2 = new e();
                view = View.inflate(this.context, R.layout.bf2, null);
                eVar2.kcS = (TextView) view.findViewById(R.id.fu9);
                eVar2.uSH = (TextView) view.findViewById(R.id.fub);
                eVar2.uSG = (TextView) view.findViewById(R.id.fu4);
                eVar2.keC = (ImageView) view.findViewById(R.id.fu3);
                eVar2.keD = (TextView) view.findViewById(R.id.fu6);
                eVar2.uSI = (ImageView) view.findViewById(R.id.fud);
                eVar2.uSJ = (ImageView) view.findViewById(R.id.fuc);
                eVar2.uSM = (ImageView) view.findViewById(R.id.fu0);
                eVar2.uSN = (ImageView) view.findViewById(R.id.fu1);
                eVar2.uSO = (ImageView) view.findViewById(R.id.fu2);
                eVar2.hTd = (ImageView) view.findViewById(R.id.b46);
                ViewGroup.LayoutParams layoutParams = eVar2.uSJ.getLayoutParams();
                layoutParams.height = com.tencent.mm.cb.a.aG(this.context, R.dimen.ir);
                layoutParams.width = com.tencent.mm.cb.a.aG(this.context, R.dimen.ir);
                eVar2.uSJ.setLayoutParams(layoutParams);
                eVar2.uSL = (ImageView) view.findViewById(R.id.fua);
                view.setTag(eVar2);
                eVar = eVar2;
            } else {
                eVar = (e) view.getTag();
            }
            final chi chi = (chi) NearbyFriendsUI.this.sNv.get(i2);
            eVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, chi.oUJ, eVar.kcS.getTextSize()));
            if (NearbyFriendsUI.this.uSp == 1) {
                switch (chi.kdY) {
                    case 1:
                        eVar.uSL.setVisibility(0);
                        eVar.uSL.setImageResource(R.raw.ic_sex_male);
                        eVar.uSL.setContentDescription(this.context.getString(R.string.evk));
                        break;
                    case 2:
                        eVar.uSL.setVisibility(0);
                        eVar.uSL.setImageResource(R.raw.ic_sex_female);
                        eVar.uSL.setContentDescription(this.context.getString(R.string.cdg));
                        break;
                    default:
                        eVar.uSL.setVisibility(8);
                        break;
                }
            } else {
                eVar.uSL.setVisibility(8);
            }
            if (chi.MmK != 0) {
                eVar.uSI.setVisibility(0);
                eVar.uSI.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(chi.MmK), 2.0f));
                eVar.uSL.setVisibility(8);
            } else {
                eVar.uSI.setVisibility(8);
            }
            eVar.uSG.setText(chi.MmJ);
            eVar.uSM.setVisibility(8);
            eVar.uSN.setVisibility(8);
            eVar.uSO.setVisibility(8);
            eVar.hTd.setVisibility(8);
            if (chi instanceof com.tencent.mm.plugin.nearby.a.a) {
                LinkedList<String> linkedList = ((com.tencent.mm.plugin.nearby.a.a) chi).Azu;
                if (linkedList != null && linkedList.size() == 1) {
                    eVar.uSM.setVisibility(0);
                    NearbyFriendsUI.u(eVar.uSM, linkedList.get(0));
                } else if (linkedList != null && linkedList.size() == 2) {
                    eVar.uSM.setVisibility(0);
                    eVar.uSN.setVisibility(0);
                    NearbyFriendsUI.u(eVar.uSM, linkedList.get(0));
                    NearbyFriendsUI.u(eVar.uSN, linkedList.get(1));
                } else if (linkedList != null && linkedList.size() >= 3) {
                    eVar.uSM.setVisibility(0);
                    eVar.uSN.setVisibility(0);
                    eVar.uSO.setVisibility(0);
                    NearbyFriendsUI.u(eVar.uSM, linkedList.get(0));
                    NearbyFriendsUI.u(eVar.uSN, linkedList.get(1));
                    NearbyFriendsUI.u(eVar.uSO, linkedList.get(2));
                }
                a aVar = (a) NearbyFriendsUI.this.uRY.get(chi.UserName);
                if (aVar != null) {
                    aVar.uSf = aVar.uSf == -1 ? 0 : aVar.uSf;
                    if (aVar.uSa > 0) {
                        eVar.hTd.setVisibility(0);
                    }
                }
                eVar.hTd.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(89859);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a aVar = (a) NearbyFriendsUI.this.uRY.get(chi.UserName);
                        if (aVar != null) {
                            aVar.uSe++;
                            aVar.oBV = true;
                            aVar.uSf |= 2;
                        }
                        NearbyFriendsUI.A(NearbyFriendsUI.this);
                        c.this.notifyDataSetChanged();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$NearbyFriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(89859);
                    }
                });
            }
            if (chi.keb == null || chi.keb.trim().equals("")) {
                eVar.uSH.setVisibility(8);
            } else {
                eVar.uSH.setVisibility(0);
                eVar.uSH.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, chi.keb, eVar.uSH.getTextSize()));
            }
            if (chi.MmQ == null || (chi.MmQ.kej & 1) <= 0) {
                eVar.uSJ.setVisibility(8);
            } else {
                eVar.uSJ.setVisibility(0);
            }
            if (d.JD(chi.kdY)) {
                eVar.keC.setImageBitmap(null);
                c.a aVar2 = new c.a();
                aVar2.prefixPath = com.tencent.mm.plugin.image.d.aSY();
                aVar2.jbf = true;
                aVar2.hZF = true;
                com.tencent.mm.av.q.bcV().a(chi.Lis, eVar.keC, aVar2.bdv());
                if (!Util.isNullOrNil(chi.ked)) {
                    eVar.keD.setText(chi.ked);
                    eVar.keD.setVisibility(0);
                }
                eVar.keD.setVisibility(8);
            } else {
                a.b.c(eVar.keC, chi.UserName);
                if (((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(chi.UserName)) {
                    eVar.keD.setVisibility(0);
                    if (as.akh(chi.MmK)) {
                        eVar.keD.setText(NearbyFriendsUI.this.getString(R.string.f_w));
                    } else {
                        as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(chi.UserName);
                        if (bjJ != null) {
                            eVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Util.isNullOrNil(bjJ.arJ()) ? chi.oUJ : bjJ.arJ(), eVar.kcS.getTextSize()));
                        }
                        eVar.keD.setText(NearbyFriendsUI.this.getString(R.string.fa1));
                    }
                }
                eVar.keD.setVisibility(8);
            }
            AppMethodBeat.o(89862);
            return view;
        }

        public final chi JC(int i2) {
            AppMethodBeat.i(89863);
            chi chi = (chi) NearbyFriendsUI.this.sNv.get(i2);
            AppMethodBeat.o(89863);
            return chi;
        }

        public final long getItemId(int i2) {
            return 0;
        }
    }

    static class e {
        ImageView hTd;
        TextView kcS;
        ImageView keC;
        TextView keD;
        TextView uSG;
        TextView uSH;
        ImageView uSI;
        ImageView uSJ;
        ImageView uSL;
        ImageView uSM;
        ImageView uSN;
        ImageView uSO;

        e() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String desc;
        String icon;
        String id;
        String name;
        boolean oBV;
        int pos;
        int qdp;
        int uSa;
        int uSb;
        int uSc;
        String uSd;
        int uSe;
        int uSf;

        private a() {
            this.uSf = -1;
            this.oBV = false;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static /* synthetic */ void y(NearbyFriendsUI nearbyFriendsUI) {
        AppMethodBeat.i(89880);
        if (nearbyFriendsUI.AAh != null) {
            nearbyFriendsUI.AAc = new com.tencent.mm.plugin.nearby.a.d(nearbyFriendsUI.AAh.iUZ, nearbyFriendsUI.AAh.iUY, nearbyFriendsUI.AAh.accuracy, "", "");
            AppCompatActivity context = nearbyFriendsUI.getContext();
            nearbyFriendsUI.getString(R.string.zb);
            nearbyFriendsUI.tipDialog = h.a((Context) context, nearbyFriendsUI.getString(R.string.fag), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(89841);
                    com.tencent.mm.kernel.g.azz().a(NearbyFriendsUI.this.AAc);
                    AppMethodBeat.o(89841);
                }
            });
            com.tencent.mm.plugin.nearby.a.b.Ts(3);
            com.tencent.mm.kernel.g.azz().a(nearbyFriendsUI.AAc, 0);
        }
        AppMethodBeat.o(89880);
    }

    static /* synthetic */ void u(ImageView imageView, String str) {
        AppMethodBeat.i(89881);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            AppMethodBeat.o(89881);
            return;
        }
        imageView.setImageBitmap(null);
        c.a aVar = new c.a();
        aVar.prefixPath = com.tencent.mm.plugin.image.d.aSY();
        aVar.jbf = true;
        aVar.hZF = true;
        com.tencent.mm.av.q.bcV().a(str, imageView, aVar.bdv());
        AppMethodBeat.o(89881);
    }
}
