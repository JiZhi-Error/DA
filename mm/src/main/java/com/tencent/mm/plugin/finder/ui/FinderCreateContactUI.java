package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.g.b.ae;
import kotlin.x;

public final class FinderCreateContactUI extends MMFinderUI implements e.a, com.tencent.mm.ak.i, b.a {
    private static final int UUO = 1;
    private static final int UUP = 2;
    private static String kme = "";
    private static String vIO = "";
    private static String vIP = "";
    private static String vIQ = "";
    private static String vIR = "";
    private static String vIS = "";
    private static String vIT = "";
    private static String vIU = "";
    private static String vIV = "";
    private static boolean vIW = true;
    private static String vIX = "";
    private static final HashMap<String, String> vIY = new HashMap<>();
    public static final a vIZ = new a((byte) 0);
    private final String TAG = "Finder.FinderCreateContactUI";
    private int UUN;
    private HashMap _$_findViewCache;
    private ImageView jWS;
    private int scene;
    private TextView titleTv;
    private String tjJ;
    private bed udb;
    private View uht;
    private ProgressDialog vIA;
    private int vIB;
    private int vIC;
    private int vID;
    private int vIE = 20;
    private boolean vIF = true;
    private final kotlin.f vIG = kotlin.g.ah(new b(this));
    private final kotlin.f vIH = kotlin.g.ah(new n(this));
    private final kotlin.f vII = kotlin.g.ah(new s(this));
    private final kotlin.f vIJ = kotlin.g.ah(new t(this));
    private boolean vIK = true;
    private int vIL;
    private int vIM;
    private int vIN;
    private View vIc;
    private EditText vId;
    private TextView vIe;
    private TextView vIf;
    private View vIg;
    private View vIh;
    private View vIi;
    private View vIj;
    private View vIk;
    private View vIl;
    private Button vIm;
    private View vIn;
    private View vIo;
    private View vIp;
    private InputPanelFrameLayout vIq;
    private TextView vIr;
    private TextView vIs;
    private View vIt;
    private CheckBox vIu;
    private TextView vIv;
    private final int vIw = 1000;
    private final int vIx = 1001;
    private final int vIy = 1002;
    private final int vIz = 1003;

    private final LinearLayout dzf() {
        AppMethodBeat.i(252252);
        LinearLayout linearLayout = (LinearLayout) this.vII.getValue();
        AppMethodBeat.o(252252);
        return linearLayout;
    }

    private final MMSwitchBtn dzg() {
        AppMethodBeat.i(252253);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) this.vIJ.getValue();
        AppMethodBeat.o(252253);
        return mMSwitchBtn;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252270);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252270);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252269);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252269);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static final class l<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ FinderCreateContactUI vJa;

        l(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            AppMethodBeat.i(252246);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0 && (str = ((bbe) aVar.iLC).nickName) != null) {
                if ((str.length() > 0) && Util.isNullOrNil(FinderCreateContactUI.a(this.vJa).getText())) {
                    FinderCreateContactUI.a(this.vJa).append(com.tencent.mm.pluginsdk.ui.span.l.c(this.vJa.getContext(), str));
                    a aVar2 = FinderCreateContactUI.vIZ;
                    kotlin.g.b.p.h(str, "<set-?>");
                    FinderCreateContactUI.vIX = str;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252246);
            return xVar;
        }
    }

    public static final class o extends kotlin.g.b.q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderCreateContactUI vJa;
        final /* synthetic */ String vJf;
        final /* synthetic */ String vJg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderCreateContactUI finderCreateContactUI, String str, String str2) {
            super(1);
            this.vJa = finderCreateContactUI;
            this.vJf = str;
            this.vJg = str2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(167174);
            String str2 = str;
            kotlin.g.b.p.h(str2, LocaleUtil.ITALIAN);
            Log.i(this.vJa.TAG, "click ".concat(String.valueOf(str2)));
            y yVar = y.vXH;
            String str3 = this.vJf;
            String str4 = this.vJg;
            if (!(str3 == null || str4 == null)) {
                wq wqVar = new wq();
                wqVar.ecI.userName = str3;
                wqVar.ecI.ecK = str4;
                EventCenter.instance.publish(wqVar);
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            int i2 = this.vJa.scene;
            int i3 = this.vJa.vIN;
            int i4 = this.vJa.vIM;
            int i5 = this.vJa.vIL;
            int i6 = this.vJa.vIB;
            a aVar = FinderCreateContactUI.vIZ;
            boolean z = FinderCreateContactUI.vIW;
            a aVar2 = FinderCreateContactUI.vIZ;
            boolean z2 = !kotlin.g.b.p.j(FinderCreateContactUI.vIX, FinderCreateContactUI.a(this.vJa).getText().toString());
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vJa);
            com.tencent.mm.plugin.finder.report.k.a(i2, 2, i3, false, i4, i5, i6, z, z2, fH != null ? fH.dIx() : null);
            x xVar = x.SXb;
            AppMethodBeat.o(167174);
            return xVar;
        }
    }

    public static final class p extends kotlin.g.b.q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ String vJh;
        final /* synthetic */ SpannableString vJi;
        final /* synthetic */ List vJj;
        final /* synthetic */ String vJk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str, SpannableString spannableString, List list, String str2, Context context) {
            super(1);
            this.vJh = str;
            this.vJi = spannableString;
            this.vJj = list;
            this.vJk = str2;
            this.$context$inlined = context;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(252248);
            String str2 = str;
            kotlin.g.b.p.h(str2, "url");
            Log.i(this.vJk, "click ".concat(String.valueOf(str2)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.br.c.b(this.$context$inlined, "webview", ".ui.tools.WebViewUI", intent);
            x xVar = x.SXb;
            AppMethodBeat.o(252248);
            return xVar;
        }
    }

    public FinderCreateContactUI() {
        AppMethodBeat.i(252265);
        AppMethodBeat.o(252265);
    }

    public static final /* synthetic */ EditText a(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(167190);
        EditText editText = finderCreateContactUI.vId;
        if (editText == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        AppMethodBeat.o(167190);
        return editText;
    }

    public static final /* synthetic */ MMSwitchBtn f(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(252266);
        MMSwitchBtn dzg = finderCreateContactUI.dzg();
        AppMethodBeat.o(252266);
        return dzg;
    }

    public static final /* synthetic */ CheckBox h(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(252267);
        CheckBox checkBox = finderCreateContactUI.vIu;
        if (checkBox == null) {
            kotlin.g.b.p.btv("tipsCheckCB");
        }
        AppMethodBeat.o(252267);
        return checkBox;
    }

    public static final /* synthetic */ TextView j(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(167191);
        TextView textView = finderCreateContactUI.vIs;
        if (textView == null) {
            kotlin.g.b.p.btv("editNickNameLimit");
        }
        AppMethodBeat.o(167191);
        return textView;
    }

    public static final /* synthetic */ void k(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(167194);
        finderCreateContactUI.cO();
        AppMethodBeat.o(167194);
    }

    public static final /* synthetic */ View l(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(252268);
        View view = finderCreateContactUI.vIt;
        if (view == null) {
            kotlin.g.b.p.btv("clearNameBtn");
        }
        AppMethodBeat.o(252268);
        return view;
    }

    public static final /* synthetic */ View q(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(167197);
        View view = finderCreateContactUI.vIc;
        if (view == null) {
            kotlin.g.b.p.btv("scrollContainer");
        }
        AppMethodBeat.o(167197);
        return view;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void avO(String str) {
            AppMethodBeat.i(252237);
            kotlin.g.b.p.h(str, "<set-?>");
            FinderCreateContactUI.vIO = str;
            AppMethodBeat.o(252237);
        }
    }

    static {
        AppMethodBeat.i(167188);
        AppMethodBeat.o(167188);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(167175);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        getController().p(this, getResources().getColor(R.color.afz));
        View findViewById = findViewById(R.id.hcm);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.scroll_container)");
        this.vIc = findViewById;
        View findViewById2 = findViewById(R.id.ckb);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.finder_avatar_iv)");
        this.jWS = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.cl0);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.finder_create_title)");
        this.titleTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.d0p);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.finder_nick_tv)");
        this.vId = (EditText) findViewById4;
        View findViewById5 = findViewById(R.id.d3i);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.finder_sex_tv)");
        this.vIe = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.cl4);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.finder_district_tv)");
        this.vIf = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.brr);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.district_layout)");
        this.vIl = findViewById7;
        View findViewById8 = findViewById(R.id.eq9);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.location_icon)");
        this.vIg = findViewById8;
        View findViewById9 = findViewById(R.id.up);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.arrow_icon)");
        this.vIh = findViewById9;
        View findViewById10 = findViewById(R.id.dy3);
        kotlin.g.b.p.g(findViewById10, "findViewById(R.id.info_icon)");
        this.vIi = findViewById10;
        View findViewById11 = findViewById(R.id.hn6);
        kotlin.g.b.p.g(findViewById11, "findViewById(R.id.sex_arrow_icon)");
        this.vIj = findViewById11;
        View findViewById12 = findViewById(R.id.hn7);
        kotlin.g.b.p.g(findViewById12, "findViewById(R.id.sex_info_icon)");
        this.vIk = findViewById12;
        View findViewById13 = findViewById(R.id.ckx);
        kotlin.g.b.p.g(findViewById13, "findViewById(R.id.finder_contact_create_btn)");
        this.vIm = (Button) findViewById13;
        View findViewById14 = findViewById(R.id.dyy);
        kotlin.g.b.p.g(findViewById14, "findViewById(R.id.input_panel)");
        this.vIq = (InputPanelFrameLayout) findViewById14;
        View findViewById15 = findViewById(R.id.cmg);
        kotlin.g.b.p.g(findViewById15, "findViewById(R.id.finder_input_container)");
        this.uht = findViewById15;
        View findViewById16 = findViewById(R.id.by4);
        kotlin.g.b.p.g(findViewById16, "findViewById(R.id.edt_top_space)");
        this.vIn = findViewById16;
        View findViewById17 = findViewById(R.id.by3);
        kotlin.g.b.p.g(findViewById17, "findViewById(R.id.edt_middle_space)");
        this.vIo = findViewById17;
        View findViewById18 = findViewById(R.id.by1);
        kotlin.g.b.p.g(findViewById18, "findViewById(R.id.edt_bottom_space)");
        this.vIp = findViewById18;
        View findViewById19 = findViewById(R.id.isu);
        kotlin.g.b.p.g(findViewById19, "findViewById(R.id.top_error_tip)");
        this.vIr = (TextView) findViewById19;
        View findViewById20 = findViewById(R.id.d0r);
        kotlin.g.b.p.g(findViewById20, "findViewById(R.id.finder_nickname_edit_limit)");
        this.vIs = (TextView) findViewById20;
        View findViewById21 = findViewById(R.id.b3l);
        kotlin.g.b.p.g(findViewById21, "findViewById(R.id.clear_text_btn)");
        this.vIt = findViewById21;
        View view = this.vIt;
        if (view == null) {
            kotlin.g.b.p.btv("clearNameBtn");
        }
        view.setVisibility(8);
        View findViewById22 = findViewById(R.id.ip2);
        kotlin.g.b.p.g(findViewById22, "findViewById(R.id.tips_check_cb)");
        this.vIu = (CheckBox) findViewById22;
        View findViewById23 = findViewById(R.id.ipg);
        kotlin.g.b.p.g(findViewById23, "findViewById(R.id.tips_warning_tv)");
        this.vIv = (TextView) findViewById23;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsL().value().intValue() == 1) {
            LinearLayout dzf = dzf();
            kotlin.g.b.p.g(dzf, "wxProfileLayout");
            dzf.setVisibility(0);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC, (Object) 1);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU2_INT_SYNC, (Object) 1);
            Log.i(this.TAG, "showWxProfileTips set USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC 1");
        } else {
            LinearLayout dzf2 = dzf();
            kotlin.g.b.p.g(dzf2, "wxProfileLayout");
            dzf2.setVisibility(8);
        }
        ((LinearLayout) this.vIG.getValue()).setOnClickListener(new c(this));
        Button button = this.vIm;
        if (button == null) {
            kotlin.g.b.p.btv("createBtn");
        }
        button.setOnClickListener(new d(this));
        k kVar = new k(this);
        EditText editText = this.vId;
        if (editText == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        editText.addTextChangedListener(kVar);
        EditText editText2 = this.vId;
        if (editText2 == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        editText2.setOnEditorActionListener(new e(this));
        View view2 = this.vIt;
        if (view2 == null) {
            kotlin.g.b.p.btv("clearNameBtn");
        }
        view2.setOnClickListener(new f(this));
        EditText editText3 = this.vId;
        if (editText3 == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        editText3.setOnFocusChangeListener(new g(this));
        setBackBtn(new h(this));
        InputPanelFrameLayout inputPanelFrameLayout = this.vIq;
        if (inputPanelFrameLayout == null) {
            kotlin.g.b.p.btv("inputPanel");
        }
        inputPanelFrameLayout.setExternalListener(this);
        View view3 = this.vIc;
        if (view3 == null) {
            kotlin.g.b.p.btv("scrollContainer");
        }
        view3.post(new i(this));
        if (vIO != null) {
            EditText editText4 = this.vId;
            if (editText4 == null) {
                kotlin.g.b.p.btv("nickEdt");
            }
            editText4.setText(vIO);
        }
        if (kme.length() == 0) {
            ImageView imageView = this.jWS;
            if (imageView == null) {
                kotlin.g.b.p.btv("avatarView");
            }
            a.b.c(imageView, z.aTY());
            com.tencent.mm.aj.p.aYn();
            this.tjJ = com.tencent.mm.aj.e.L(z.aTY(), false);
            if (((int) com.tencent.mm.vfs.s.boW(this.tjJ)) == 0) {
                Log.i(this.TAG, "WX avatar file size is zero");
                com.tencent.mm.aj.p.aYn().a(this);
                this.tjJ = "";
            }
        } else {
            this.tjJ = kme;
            setAvatar(this.tjJ);
        }
        String str = this.tjJ;
        com.tencent.mm.aj.p.aYn();
        if (kotlin.g.b.p.j(str, com.tencent.mm.aj.e.L(z.aTY(), false))) {
            this.vIN = 1;
        } else {
            String str2 = this.tjJ;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.vIN = 3;
            } else {
                this.vIN = 2;
            }
        }
        if (vIP.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            int i2 = aAh3.azQ().getInt(12290, 0);
            if (i2 == 1) {
                vIP = "male";
                this.vIL = 1;
            } else if (i2 == 2) {
                vIP = "female";
                this.vIL = 1;
            } else {
                LinearLayout linearLayout = (LinearLayout) this.vIH.getValue();
                kotlin.g.b.p.g(linearLayout, "sexLayout");
                linearLayout.setVisibility(8);
                this.vIL = 3;
            }
        } else {
            Log.i(this.TAG, "lastSelectSex = " + vIP);
        }
        MMSwitchBtn dzg = dzg();
        kotlin.g.b.p.g(dzg, "wxProfileSwitchBtn");
        dzg.setCheck(vIW);
        dzg().setSwitchListener(j.vJb);
        Log.i(this.TAG, "lastWxProfileChecked = " + vIW);
        ArrayList arrayList = new ArrayList();
        ae aeVar = ae.SYK;
        String format = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[]{LocaleUtil.getCurrentLanguage(this)}, 1));
        kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
        arrayList.add(format);
        ae aeVar2 = ae.SYK;
        String format2 = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
        kotlin.g.b.p.g(format2, "java.lang.String.format(format, *args)");
        arrayList.add(format2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(getString(R.string.ck7));
        arrayList2.add(getString(R.string.ckg));
        FinderCreateContactUI finderCreateContactUI = this;
        ArrayList arrayList3 = arrayList;
        String string = getString(R.string.cki);
        kotlin.g.b.p.g(string, "getString(R.string.finder_create_contact_warning)");
        ArrayList arrayList4 = arrayList2;
        TextView textView = this.vIv;
        if (textView == null) {
            kotlin.g.b.p.btv("tipsWarningTV");
        }
        a(finderCreateContactUI, arrayList3, string, arrayList4, textView, this.TAG);
        dzh();
        Log.i(this.TAG, "isLastSelectDistrictEmpty = " + dzi());
        ox(dzi());
        com.tencent.mm.kernel.g.azz().a(3922, this);
        com.tencent.mm.kernel.g.azz().a(3759, this);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.vIB = getIntent().getIntExtra("key_create_scene", 3);
        this.vIC = getIntent().getIntExtra("key_mv_status", 0);
        this.vIK = getIntent().getBooleanExtra("key_router_to_profile", true);
        this.UUN = getIntent().getIntExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 0);
        this.udb = new bed();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_prepare_resp");
        if (byteArrayExtra != null) {
            try {
                bed bed = this.udb;
                if (bed != null) {
                    bed.parseFrom(byteArrayExtra);
                }
            } catch (Exception e2) {
                x xVar = x.SXb;
            }
        }
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
        Object obj = aAh4.azQ().get(ar.a.USERINFO_MY_FINDER_POST_NICK_NAME_MAX_LENGTH_INT_SYNC, (Object) 20);
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(167175);
            throw tVar;
        }
        this.vIE = ((Integer) obj).intValue();
        bed bed2 = this.udb;
        if (bed2 != null) {
            Log.i(this.TAG, "nicknameMaxLength ： " + bed2.vIE);
            if (bed2.vIE > 0) {
                this.vIE = bed2.vIE;
            }
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 30, 1);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsM().value().intValue() == 1) {
            new com.tencent.mm.plugin.finder.cgi.y().aYI().a(this).g(new l(this));
        }
        switch (this.vIC) {
            case 1:
                TextView textView2 = this.titleTv;
                if (textView2 == null) {
                    kotlin.g.b.p.btv("titleTv");
                }
                textView2.setText(getResources().getText(R.string.ckl));
                Button button2 = this.vIm;
                if (button2 == null) {
                    kotlin.g.b.p.btv("createBtn");
                }
                button2.setText(getResources().getText(R.string.ckd));
                AppMethodBeat.o(167175);
                return;
            case 2:
                TextView textView3 = this.titleTv;
                if (textView3 == null) {
                    kotlin.g.b.p.btv("titleTv");
                }
                textView3.setText(getResources().getText(R.string.ckl));
                Button button3 = this.vIm;
                if (button3 == null) {
                    kotlin.g.b.p.btv("createBtn");
                }
                button3.setText(getResources().getText(R.string.ckc));
                break;
        }
        AppMethodBeat.o(167175);
    }

    static final class c implements View.OnClickListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        c(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167160);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.pluginsdk.ui.tools.s.a((Activity) this.vJa, this.vJa.vIw, 1, 5, (Intent) null, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167160);
        }
    }

    static final class d implements View.OnClickListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        d(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00c7, code lost:
            if (r0 == null) goto L_0x00c9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r13) {
            /*
            // Method dump skipped, instructions count: 652
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.d.onClick(android.view.View):void");
        }
    }

    public static final class k implements TextWatcher {
        final /* synthetic */ FinderCreateContactUI vJa;

        k(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x005b, code lost:
            if (r0 == null) goto L_0x005d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r5) {
            /*
            // Method dump skipped, instructions count: 123
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.k.afterTextChanged(android.text.Editable):void");
        }

        public static final class a implements c.a {
            final /* synthetic */ k vJc;

            a(k kVar) {
                this.vJc = kVar;
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void Tx(String str) {
                AppMethodBeat.i(252245);
                FinderCreateContactUI.j(this.vJc.vJa).setText(String.valueOf(this.vJc.vJa.vIE));
                FinderCreateContactUI.j(this.vJc.vJa).setTextColor(this.vJc.vJa.getResources().getColor(R.color.BW_0_Alpha_0_3));
                AppMethodBeat.o(252245);
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void dv(String str) {
                AppMethodBeat.i(167166);
                FinderCreateContactUI.j(this.vJc.vJa).setText(String.valueOf(com.tencent.mm.ui.tools.f.dp(this.vJc.vJa.vIE, str)));
                FinderCreateContactUI.j(this.vJc.vJa).setVisibility(0);
                FinderCreateContactUI.j(this.vJc.vJa).setTextColor(this.vJc.vJa.getResources().getColor(R.color.Red_100));
                FinderCreateContactUI finderCreateContactUI = this.vJc.vJa;
                String string = this.vJc.vJa.getString(R.string.d3b);
                kotlin.g.b.p.g(string, "getString(R.string.finder_nickname_too_long_tip)");
                FinderCreateContactUI.a(finderCreateContactUI, string);
                AppMethodBeat.o(167166);
            }

            @Override // com.tencent.mm.ui.tools.b.c.a
            public final void Tw(String str) {
                AppMethodBeat.i(167167);
                int dp = com.tencent.mm.ui.tools.f.dp(this.vJc.vJa.vIE, str);
                FinderCreateContactUI.j(this.vJc.vJa).setText(String.valueOf(dp));
                FinderCreateContactUI.j(this.vJc.vJa).setTextColor(this.vJc.vJa.getResources().getColor(R.color.BW_0_Alpha_0_3));
                if (dp <= kotlin.k.j.mZ((int) (((float) this.vJc.vJa.vIE) * 0.1f), 1)) {
                    FinderCreateContactUI.j(this.vJc.vJa).setVisibility(0);
                } else {
                    FinderCreateContactUI.j(this.vJc.vJa).setVisibility(4);
                }
                FinderCreateContactUI.k(this.vJc.vJa);
                AppMethodBeat.o(167167);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    static final class e implements TextView.OnEditorActionListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        e(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(167162);
            if (5 == i2) {
                FinderCreateContactUI.a(this.vJa).clearFocus();
            }
            AppMethodBeat.o(167162);
            return false;
        }
    }

    static final class f implements View.OnClickListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        f(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252239);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderCreateContactUI.a(this.vJa).getText().clear();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252239);
        }
    }

    static final class g implements View.OnFocusChangeListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        g(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(252240);
            FinderCreateContactUI.l(this.vJa).setVisibility(z ? 0 : 8);
            AppMethodBeat.o(252240);
        }
    }

    static final class h implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        h(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252241);
            com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.Ks(5);
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            int i2 = this.vJa.scene;
            int i3 = this.vJa.vIN;
            int i4 = this.vJa.vIM;
            int i5 = this.vJa.vIL;
            int i6 = this.vJa.vIB;
            a aVar = FinderCreateContactUI.vIZ;
            boolean z = FinderCreateContactUI.vIW;
            a aVar2 = FinderCreateContactUI.vIZ;
            boolean z2 = !kotlin.g.b.p.j(FinderCreateContactUI.vIX, FinderCreateContactUI.a(this.vJa).getText().toString());
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vJa);
            com.tencent.mm.plugin.finder.report.k.a(i2, 0, i3, false, i4, i5, i6, z, z2, fH != null ? fH.dIx() : null);
            FinderCreateContactUI finderCreateContactUI = this.vJa;
            a aVar4 = FinderCreateContactUI.vIZ;
            finderCreateContactUI.setResult(FinderCreateContactUI.UUP);
            this.vJa.finish();
            AppMethodBeat.o(252241);
            return true;
        }
    }

    static final class i implements Runnable {
        final /* synthetic */ FinderCreateContactUI vJa;

        i(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final void run() {
            AppMethodBeat.i(252242);
            this.vJa.vID = FinderCreateContactUI.q(this.vJa).getMeasuredHeight();
            AppMethodBeat.o(252242);
        }
    }

    static final class j implements MMSwitchBtn.a {
        public static final j vJb = new j();

        static {
            AppMethodBeat.i(252244);
            AppMethodBeat.o(252244);
        }

        j() {
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
        public final void onStatusChange(boolean z) {
            AppMethodBeat.i(252243);
            a aVar = FinderCreateContactUI.vIZ;
            FinderCreateContactUI.vIW = z;
            AppMethodBeat.o(252243);
        }
    }

    public final void onClickEditSex(View view) {
        AppMethodBeat.i(167176);
        EditText editText = this.vId;
        if (editText == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        editText.clearFocus();
        hideVKB();
        f(false, 0);
        if (this.vIF) {
            Intent intent = new Intent();
            intent.putExtra("key_input_sex", vIP);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.a((MMActivity) this, intent, this.vIy);
        }
        AppMethodBeat.o(167176);
    }

    public final void onTipsCheckBoxClick(View view) {
        AppMethodBeat.i(252254);
        CheckBox checkBox = this.vIu;
        if (checkBox == null) {
            kotlin.g.b.p.btv("tipsCheckCB");
        }
        CheckBox checkBox2 = this.vIu;
        if (checkBox2 == null) {
            kotlin.g.b.p.btv("tipsCheckCB");
        }
        checkBox.setChecked(!checkBox2.isChecked());
        AppMethodBeat.o(252254);
    }

    public final void onClickEditDistrict(View view) {
        AppMethodBeat.i(167177);
        EditText editText = this.vId;
        if (editText == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        editText.clearFocus();
        hideVKB();
        f(false, 0);
        Intent intent = new Intent();
        intent.putExtra("GetAddress", true);
        intent.putExtra("ShowSelectedLocation", true);
        intent.putExtra("SetSelectLocation", true);
        intent.putExtra("SelectedCountryCode", vIQ);
        intent.putExtra("SelectedProvinceCode", vIR);
        intent.putExtra("SelectedCityCode", vIS);
        intent.putExtra("NeedUnshowItem", false);
        com.tencent.mm.br.c.c(getContext(), ".ui.tools.MultiStageCitySelectUI", intent, this.vIz);
        AppMethodBeat.o(167177);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167178);
        setResult(UUP);
        super.onBackPressed();
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Ks(5);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        int i2 = this.scene;
        int i3 = this.vIN;
        int i4 = this.vIM;
        int i5 = this.vIL;
        int i6 = this.vIB;
        boolean z = vIW;
        String str = vIX;
        EditText editText = this.vId;
        if (editText == null) {
            kotlin.g.b.p.btv("nickEdt");
        }
        boolean z2 = !kotlin.g.b.p.j(str, editText.getText().toString());
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
        com.tencent.mm.plugin.finder.report.k.a(i2, 0, i3, false, i4, i5, i6, z, z2, fH != null ? fH.dIx() : null);
        AppMethodBeat.o(167178);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(167180);
        if (z) {
            View view = this.vIc;
            if (view == null) {
                kotlin.g.b.p.btv("scrollContainer");
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
            layoutParams.height = this.vID - i2;
            View view2 = this.vIc;
            if (view2 == null) {
                kotlin.g.b.p.btv("scrollContainer");
            }
            view2.setLayoutParams(layoutParams);
            View view3 = this.vIn;
            if (view3 == null) {
                kotlin.g.b.p.btv("editTopSpace");
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(view3.getLayoutParams());
            layoutParams2.height = com.tencent.mm.cb.a.aG(this, R.dimen.cb);
            View view4 = this.vIn;
            if (view4 == null) {
                kotlin.g.b.p.btv("editTopSpace");
            }
            view4.setLayoutParams(layoutParams2);
            View view5 = this.vIo;
            if (view5 == null) {
                kotlin.g.b.p.btv("editMiddleSpace");
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(view5.getLayoutParams());
            layoutParams3.height = com.tencent.mm.cb.a.aG(this, R.dimen.cs);
            View view6 = this.vIo;
            if (view6 == null) {
                kotlin.g.b.p.btv("editMiddleSpace");
            }
            view6.setLayoutParams(layoutParams3);
            View view7 = this.vIp;
            if (view7 == null) {
                kotlin.g.b.p.btv("editBottomSpace");
            }
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(view7.getLayoutParams());
            layoutParams4.height = com.tencent.mm.cb.a.aG(this, R.dimen.cb);
            View view8 = this.vIp;
            if (view8 == null) {
                kotlin.g.b.p.btv("editBottomSpace");
            }
            view8.setLayoutParams(layoutParams4);
            AppMethodBeat.o(167180);
            return;
        }
        View view9 = this.vIc;
        if (view9 == null) {
            kotlin.g.b.p.btv("scrollContainer");
        }
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(view9.getLayoutParams());
        layoutParams5.height = -1;
        View view10 = this.vIc;
        if (view10 == null) {
            kotlin.g.b.p.btv("scrollContainer");
        }
        view10.setLayoutParams(layoutParams5);
        View view11 = this.vIn;
        if (view11 == null) {
            kotlin.g.b.p.btv("editTopSpace");
        }
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(view11.getLayoutParams());
        layoutParams6.height = com.tencent.mm.cb.a.aG(this, R.dimen.cr);
        View view12 = this.vIn;
        if (view12 == null) {
            kotlin.g.b.p.btv("editTopSpace");
        }
        view12.setLayoutParams(layoutParams6);
        View view13 = this.vIo;
        if (view13 == null) {
            kotlin.g.b.p.btv("editMiddleSpace");
        }
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(view13.getLayoutParams());
        layoutParams7.height = -2;
        layoutParams7.weight = 1.0f;
        View view14 = this.vIo;
        if (view14 == null) {
            kotlin.g.b.p.btv("editMiddleSpace");
        }
        view14.setLayoutParams(layoutParams7);
        View view15 = this.vIp;
        if (view15 == null) {
            kotlin.g.b.p.btv("editBottomSpace");
        }
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(view15.getLayoutParams());
        layoutParams8.height = com.tencent.mm.cb.a.aG(this, R.dimen.bx);
        View view16 = this.vIp;
        if (view16 == null) {
            kotlin.g.b.p.btv("editBottomSpace");
        }
        view16.setLayoutParams(layoutParams8);
        AppMethodBeat.o(167180);
    }

    static /* synthetic */ void a(FinderCreateContactUI finderCreateContactUI, String str) {
        AppMethodBeat.i(252256);
        finderCreateContactUI.aj(str, null, null);
        AppMethodBeat.o(252256);
    }

    private final void aj(String str, String str2, String str3) {
        AppMethodBeat.i(252255);
        Log.i(this.TAG, "showError ".concat(String.valueOf(str)));
        Matcher matcher = com.tencent.mm.plugin.i.a.k.PATTERN.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            StringBuilder sb = new StringBuilder();
            if (matcher.start(0) > 0) {
                int start = matcher.start(0);
                if (str == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(252255);
                    throw tVar;
                }
                String substring = str.substring(0, start);
                kotlin.g.b.p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
            }
            sb.append(group);
            if (matcher.end(0) < str.length()) {
                int end = matcher.end(0);
                int length = str.length();
                if (str == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(252255);
                    throw tVar2;
                }
                String substring2 = str.substring(end, length);
                kotlin.g.b.p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
            }
            String sb2 = sb.toString();
            kotlin.g.b.p.g(sb2, "sb.toString()");
            int start2 = matcher.start(0);
            int length2 = start2 + group.length();
            SpannableString spannableString = new SpannableString(sb2);
            kotlin.g.b.p.g(group, "content");
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            int color = context.getResources().getColor(R.color.Link);
            AppCompatActivity context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(group, color, context2.getResources().getColor(R.color.Link_Alpha_0_6), new o(this, str2, str3)), start2, length2, 17);
            TextView textView = this.vIr;
            if (textView == null) {
                kotlin.g.b.p.btv("topErrorTip");
            }
            textView.setText(spannableString);
            TextView textView2 = this.vIr;
            if (textView2 == null) {
                kotlin.g.b.p.btv("topErrorTip");
            }
            a(textView2, spannableString);
        } else {
            TextView textView3 = this.vIr;
            if (textView3 == null) {
                kotlin.g.b.p.btv("topErrorTip");
            }
            textView3.setText(str);
        }
        TextView textView4 = this.vIr;
        if (textView4 == null) {
            kotlin.g.b.p.btv("topErrorTip");
        }
        textView4.setVisibility(0);
        AppMethodBeat.o(252255);
    }

    private void a(TextView textView, Spannable spannable) {
        AppMethodBeat.i(252257);
        kotlin.g.b.p.h(textView, "descTv");
        kotlin.g.b.p.h(spannable, "text");
        textView.setOnTouchListener(new m(this, spannable, textView));
        AppMethodBeat.o(252257);
    }

    public static final class m implements View.OnTouchListener {
        final /* synthetic */ FinderCreateContactUI vJa;
        final /* synthetic */ Spannable vJd;
        final /* synthetic */ TextView vJe;

        m(FinderCreateContactUI finderCreateContactUI, Spannable spannable, TextView textView) {
            this.vJa = finderCreateContactUI;
            this.vJd = spannable;
            this.vJe = textView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            ClickableSpan[] clickableSpanArr;
            AppMethodBeat.i(167173);
            kotlin.g.b.p.g(motionEvent, "event");
            int action = motionEvent.getAction();
            if (view == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(167173);
                throw tVar;
            }
            TextView textView = (TextView) view;
            Spannable spannable = this.vJd;
            if ((action == 1 || action == 3) && (clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, this.vJd.length(), ClickableSpan.class)) != null) {
                for (ClickableSpan clickableSpan : clickableSpanArr) {
                    if (clickableSpan instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                        ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan).setIsPressed(false);
                        this.vJe.invalidate();
                    }
                }
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr2.length != 0) {
                    ClickableSpan clickableSpan2 = clickableSpanArr2[0];
                    if (action == 1) {
                        clickableSpan2.onClick(textView);
                    } else if (action == 0) {
                        if (clickableSpan2 instanceof com.tencent.mm.pluginsdk.ui.span.p) {
                            ((com.tencent.mm.pluginsdk.ui.span.p) clickableSpan2).setIsPressed(true);
                            this.vJe.invalidate();
                        }
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan2), spannable.getSpanEnd(clickableSpan2));
                    }
                    z = true;
                    Log.i(this.vJa.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
                    AppMethodBeat.o(167173);
                    return z;
                }
                Selection.removeSelection(spannable);
            }
            z = false;
            Log.i(this.vJa.TAG, "touch " + motionEvent.getX() + ", " + motionEvent.getY() + ", ret:" + z);
            AppMethodBeat.o(167173);
            return z;
        }
    }

    private final void cO() {
        AppMethodBeat.i(252258);
        TextView textView = this.vIr;
        if (textView == null) {
            kotlin.g.b.p.btv("topErrorTip");
        }
        textView.setText("");
        TextView textView2 = this.vIr;
        if (textView2 == null) {
            kotlin.g.b.p.btv("topErrorTip");
        }
        textView2.setVisibility(8);
        AppMethodBeat.o(252258);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_9;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167182);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3922, this);
        com.tencent.mm.kernel.g.azz().b(3759, this);
        com.tencent.mm.aj.p.aYn().b(this);
        AppMethodBeat.o(167182);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(167183);
        Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof at) {
            ProgressDialog progressDialog = this.vIA;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            if (i2 == 0 && i3 == 0) {
                FinderContact cYe = ((at) qVar).cYe();
                if (cYe != null) {
                    com.tencent.mm.plugin.finder.utils.n nVar = com.tencent.mm.plugin.finder.utils.n.vVR;
                    com.tencent.mm.plugin.finder.utils.n.dBS();
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    int i4 = this.scene;
                    int i5 = this.vIN;
                    int i6 = this.vIM;
                    int i7 = this.vIL;
                    int i8 = this.vIB;
                    boolean z = vIW;
                    String str2 = vIX;
                    EditText editText = this.vId;
                    if (editText == null) {
                        kotlin.g.b.p.btv("nickEdt");
                    }
                    boolean z2 = !kotlin.g.b.p.j(str2, editText.getText().toString());
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
                    com.tencent.mm.plugin.finder.report.k.a(i4, 1, i5, true, i6, i7, i8, z, z2, fH != null ? fH.dIx() : null);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 32, 1);
                    Intent intent = new Intent();
                    if (this.vIK) {
                        intent.putExtra("finder_username", cYe.username);
                        intent.putExtra("KEY_FINDER_SELF_FLAG", true);
                        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                        FinderReporterUIC.a.a(this, intent, 0, 0, false, 124);
                        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this, intent);
                    }
                    setResult(UUO);
                    finish();
                    AppMethodBeat.o(167183);
                    return;
                }
                AppMethodBeat.o(167183);
                return;
            }
            if (i3 == -4003) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 37, 1);
            } else if (i3 == -4008) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 38, 1);
            }
            com.tencent.mm.bw.a aYK = ((at) qVar).rr.aYK();
            if (aYK == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
                AppMethodBeat.o(167183);
                throw tVar;
            }
            azn azn = ((aqf) aYK).verifyInfo;
            if (azn != null) {
                Log.i(this.TAG, "verify info: " + com.tencent.mm.ac.g.bN(azn));
                if (azn.LJr == 1) {
                    EditText editText2 = this.vId;
                    if (editText2 == null) {
                        kotlin.g.b.p.btv("nickEdt");
                    }
                    editText2.setTextColor(com.tencent.mm.cb.a.n(this, R.color.a5c));
                }
                if (!Util.isNullOrNil(azn.LJo)) {
                    String str3 = azn.LJo;
                    if (str3 == null) {
                        str3 = "";
                    }
                    aj(str3, azn.LJt, azn.LJs);
                } else {
                    String string = getString(R.string.ckb);
                    kotlin.g.b.p.g(string, "getString(R.string.finde…reate_contact_failed_tip)");
                    aj(string, null, null);
                }
            } else {
                FinderCreateContactUI finderCreateContactUI = this;
                String string2 = finderCreateContactUI.getString(R.string.ckb);
                kotlin.g.b.p.g(string2, "getString(R.string.finde…reate_contact_failed_tip)");
                finderCreateContactUI.aj(string2, null, null);
            }
            setResult(UUP);
            AppMethodBeat.o(167183);
            return;
        }
        if (qVar instanceof cl) {
            if (i2 == 0 && i3 == 0) {
                String str4 = ((cl) qVar).twt;
                String str5 = ((cl) qVar).fileMD5;
                int i9 = ((cl) qVar).iKP;
                if (str4 != null) {
                    String dI = dI(str5, i9);
                    if (dI.length() > 0) {
                        vIY.put(dI, str4);
                    }
                }
                avK(str4);
                AppMethodBeat.o(167183);
                return;
            }
            ProgressDialog progressDialog2 = this.vIA;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 33, 1);
            String string3 = getString(R.string.ckb);
            kotlin.g.b.p.g(string3, "getString(R.string.finde…reate_contact_failed_tip)");
            aj(string3, null, null);
        }
        AppMethodBeat.o(167183);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(167184);
        if (i2 == this.vIw) {
            if (intent != null && i3 == -1) {
                setIntent(new Intent());
                getIntent().putExtra("key_source_img_path", com.tencent.mm.ui.tools.a.i(getContext(), intent, com.tencent.mm.plugin.image.d.aSY()));
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.b((Activity) this, getIntent(), this.vIx);
            }
        } else if (i2 == this.vIx) {
            if (intent != null && i3 == -1) {
                this.tjJ = intent.getStringExtra("key_result_img_path");
                String str = this.tjJ;
                if (str != null) {
                    kme = str;
                }
                Log.i(this.TAG, "avatar file length %d KB", Long.valueOf(com.tencent.mm.vfs.s.boW(this.tjJ) / 1024));
                this.vIN = 2;
                setAvatar(this.tjJ);
            }
        } else if (i2 == this.vIy) {
            if (intent != null && i3 == -1) {
                String stringExtra = intent.getStringExtra("key_output_sex");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                vIP = stringExtra;
                dzh();
                this.vIL = 2;
            }
        } else if (i2 == this.vIz && intent != null && i3 == -1) {
            String stringExtra2 = intent.getStringExtra("Country");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            vIQ = stringExtra2;
            String stringExtra3 = intent.getStringExtra("Contact_Province");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            vIR = stringExtra3;
            String stringExtra4 = intent.getStringExtra("Contact_City");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            vIS = stringExtra4;
            ox(false);
            this.vIM = 2;
        }
        cO();
        AppMethodBeat.o(167184);
    }

    private static String dI(String str, int i2) {
        AppMethodBeat.i(252259);
        if (str != null) {
            String str2 = str + '_' + i2;
            AppMethodBeat.o(252259);
            return str2;
        }
        AppMethodBeat.o(252259);
        return "";
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void avK(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(252260);
        app app = new app();
        app app2 = new app();
        String str2 = vIP;
        switch (str2.hashCode()) {
            case -1278174388:
                if (str2.equals("female")) {
                    app.fuA = 2;
                    i2 = 0;
                    break;
                }
                app.fuA = 0;
                i2 = 1;
                break;
            case 3343885:
                if (str2.equals("male")) {
                    app.fuA = 1;
                    i2 = 0;
                    break;
                }
                app.fuA = 0;
                i2 = 1;
                break;
            default:
                app.fuA = 0;
                i2 = 1;
                break;
        }
        if (kotlin.g.b.p.j(vIQ, "unshow")) {
            i3 = 1;
        } else {
            app.country = vIQ;
            app.fuJ = vIR;
            app.fuK = vIS;
            i3 = 0;
        }
        com.tencent.mm.kernel.g.azz().b(new at(vIO, "", str, app, i2, i3, app2, vIW));
        AppMethodBeat.o(252260);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dzh() {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.dzh():void");
    }

    public static final class r implements View.OnClickListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        r(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252249);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            String string = this.vJa.getString(R.string.d9i);
            kotlin.g.b.p.g(string, "getString(R.string.finder_sex_tip)");
            com.tencent.mm.plugin.finder.spam.a.avm(string);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252249);
        }
    }

    private final void ox(boolean z) {
        AppMethodBeat.i(252261);
        if (z) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bme bme = ((FinderGlobalLocationVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
            if (bme != null) {
                String str = bme.keh;
                kotlin.g.b.p.g(str, "it.Country");
                vIQ = str;
                String str2 = bme.kdZ;
                kotlin.g.b.p.g(str2, "it.Province");
                vIR = str2;
                String str3 = bme.kea;
                kotlin.g.b.p.g(str3, "it.City");
                vIS = str3;
                String str4 = bme.keh;
                kotlin.g.b.p.g(str4, "it.Country");
                vIT = str4;
                String str5 = bme.kdZ;
                kotlin.g.b.p.g(str5, "it.Province");
                vIU = str5;
                String str6 = bme.kea;
                kotlin.g.b.p.g(str6, "it.City");
                vIV = str6;
                View view = this.vIg;
                if (view == null) {
                    kotlin.g.b.p.btv("locationIcon");
                }
                view.setVisibility(0);
                View view2 = this.vIh;
                if (view2 == null) {
                    kotlin.g.b.p.btv("locationArrowIcon");
                }
                view2.setVisibility(0);
                View view3 = this.vIi;
                if (view3 == null) {
                    kotlin.g.b.p.btv("locationInfoIcon");
                }
                view3.setVisibility(8);
                View view4 = this.vIi;
                if (view4 == null) {
                    kotlin.g.b.p.btv("locationInfoIcon");
                }
                view4.setOnClickListener(new q(this));
                this.vIM = 1;
                ak(vIQ, vIR, vIS);
            } else {
                FinderCreateContactUI finderCreateContactUI = this;
                vIQ = "unshow";
                vIR = "";
                vIS = "";
                View view5 = finderCreateContactUI.vIl;
                if (view5 == null) {
                    kotlin.g.b.p.btv("districtLayout");
                }
                view5.setVisibility(8);
                finderCreateContactUI.vIM = 3;
            }
        } else {
            View view6 = this.vIg;
            if (view6 == null) {
                kotlin.g.b.p.btv("locationIcon");
            }
            view6.setVisibility(8);
            ak(vIQ, vIR, vIS);
        }
        Log.i(this.TAG, "updateDistrict " + vIQ + ' ' + vIR + ' ' + vIS);
        AppMethodBeat.o(252261);
    }

    public static final class q implements View.OnClickListener {
        final /* synthetic */ FinderCreateContactUI vJa;

        q(FinderCreateContactUI finderCreateContactUI) {
            this.vJa = finderCreateContactUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178430);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            String string = this.vJa.getString(R.string.d0t);
            kotlin.g.b.p.g(string, "getString(R.string.finder_location_tip_gps)");
            com.tencent.mm.plugin.finder.spam.a.avm(string);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178430);
        }
    }

    private static boolean dzi() {
        AppMethodBeat.i(252262);
        if (vIQ.length() == 0) {
            if (vIR.length() == 0) {
                if (vIS.length() == 0) {
                    AppMethodBeat.o(252262);
                    return true;
                }
            }
        }
        AppMethodBeat.o(252262);
        return false;
    }

    private final void ak(String str, String str2, String str3) {
        AppMethodBeat.i(178431);
        RegionCodeDecoder.gEm();
        String country = RegionCodeDecoder.getCountry(str);
        RegionCodeDecoder.gEm();
        String mV = RegionCodeDecoder.mV(str, str2);
        RegionCodeDecoder.gEm();
        String br = RegionCodeDecoder.br(str, str2, str3);
        if (!Util.isNullOrNil(br)) {
            TextView textView = this.vIf;
            if (textView == null) {
                kotlin.g.b.p.btv("districtTV");
            }
            textView.setText(((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).It(mV) + " " + br);
            View view = this.vIl;
            if (view == null) {
                kotlin.g.b.p.btv("districtLayout");
            }
            view.setVisibility(0);
            AppMethodBeat.o(178431);
        } else if (!Util.isNullOrNil(mV)) {
            TextView textView2 = this.vIf;
            if (textView2 == null) {
                kotlin.g.b.p.btv("districtTV");
            }
            textView2.setText(country + ' ' + mV);
            View view2 = this.vIl;
            if (view2 == null) {
                kotlin.g.b.p.btv("districtLayout");
            }
            view2.setVisibility(0);
            AppMethodBeat.o(178431);
        } else if (!Util.isNullOrNil(country)) {
            TextView textView3 = this.vIf;
            if (textView3 == null) {
                kotlin.g.b.p.btv("districtTV");
            }
            textView3.setText(country);
            View view3 = this.vIl;
            if (view3 == null) {
                kotlin.g.b.p.btv("districtLayout");
            }
            view3.setVisibility(0);
            AppMethodBeat.o(178431);
        } else {
            View view4 = this.vIl;
            if (view4 == null) {
                kotlin.g.b.p.btv("districtLayout");
            }
            view4.setVisibility(8);
            AppMethodBeat.o(178431);
        }
    }

    private final void setAvatar(String str) {
        Bitmap extractThumbNail;
        AppMethodBeat.i(167187);
        if (Util.isNullOrNil(str) || (extractThumbNail = BitmapUtil.extractThumbNail(str, 256, 256, false)) == null) {
            AppMethodBeat.o(167187);
            return;
        }
        ImageView imageView = this.jWS;
        if (imageView == null) {
            kotlin.g.b.p.btv("avatarView");
        }
        imageView.setImageBitmap(extractThumbNail);
        AppMethodBeat.o(167187);
    }

    private void a(Context context, List<String> list, String str, List<String> list2, TextView textView, String str2) {
        AppMethodBeat.i(252263);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(list, "h5urlList");
        kotlin.g.b.p.h(str, "allText");
        kotlin.g.b.p.h(list2, "linkTextList");
        kotlin.g.b.p.h(textView, "descTv");
        kotlin.g.b.p.h(str2, "logTag");
        SpannableString spannableString = new SpannableString(str);
        int i2 = 0;
        for (T t2 : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t3 = t2;
            int a2 = kotlin.n.n.a((CharSequence) str, (String) t3, 0, false, 6);
            int length = a2 + t3.length();
            if (a2 >= 0 && length <= str.length()) {
                String str3 = list.get(i2);
                Context context2 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                int color = context2.getResources().getColor(R.color.x0);
                Context context3 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
                spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(str3, color, context3.getResources().getColor(R.color.BW_0_Alpha_0_2), new p(str, spannableString, list, str2, context)), a2, length, 17);
            }
            i2 = i3;
        }
        textView.setText(spannableString);
        a(textView, spannableString);
        AppMethodBeat.o(252263);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(252264);
        if (kotlin.g.b.p.j(str, z.aTY())) {
            Log.i(this.TAG, "[notifyChanged] user:" + str + ",avatarPath:" + this.tjJ);
            com.tencent.mm.aj.p.aYn();
            String L = com.tencent.mm.aj.e.L(z.aTY(), false);
            int boW = (int) com.tencent.mm.vfs.s.boW(L);
            String str2 = this.tjJ;
            if ((str2 == null || str2.length() == 0) && boW > 0) {
                Log.i(this.TAG, "[notifyChanged] filesize:".concat(String.valueOf(boW)));
                this.tjJ = L;
            }
        }
        AppMethodBeat.o(252264);
    }

    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderCreateContactUI vJa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderCreateContactUI finderCreateContactUI) {
            super(0);
            this.vJa = finderCreateContactUI;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(252238);
            LinearLayout linearLayout = (LinearLayout) this.vJa._$_findCachedViewById(R.id.cko);
            AppMethodBeat.o(252238);
            return linearLayout;
        }
    }

    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderCreateContactUI vJa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(FinderCreateContactUI finderCreateContactUI) {
            super(0);
            this.vJa = finderCreateContactUI;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(252247);
            LinearLayout linearLayout = (LinearLayout) this.vJa._$_findCachedViewById(R.id.hn8);
            AppMethodBeat.o(252247);
            return linearLayout;
        }
    }

    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderCreateContactUI vJa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(FinderCreateContactUI finderCreateContactUI) {
            super(0);
            this.vJa = finderCreateContactUI;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(252250);
            LinearLayout linearLayout = (LinearLayout) this.vJa._$_findCachedViewById(R.id.jry);
            AppMethodBeat.o(252250);
            return linearLayout;
        }
    }

    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<MMSwitchBtn> {
        final /* synthetic */ FinderCreateContactUI vJa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(FinderCreateContactUI finderCreateContactUI) {
            super(0);
            this.vJa = finderCreateContactUI;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ MMSwitchBtn invoke() {
            AppMethodBeat.i(252251);
            MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) this.vJa._$_findCachedViewById(R.id.jrz);
            AppMethodBeat.o(252251);
            return mMSwitchBtn;
        }
    }

    public static final /* synthetic */ void i(FinderCreateContactUI finderCreateContactUI) {
        AppMethodBeat.i(167189);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 31, 1);
        Log.i(finderCreateContactUI.TAG, "createContact avatarPath " + finderCreateContactUI.tjJ + " length=" + (com.tencent.mm.vfs.s.boW(kme) / 1024), kme);
        String bhK = com.tencent.mm.vfs.s.bhK(kme);
        int boW = (int) com.tencent.mm.vfs.s.boW(kme);
        String dI = dI(bhK, boW);
        String str = vIY.get(dI);
        if ((dI.length() == 0) || str == null) {
            String str2 = kme;
            cl.a aVar = cl.twA;
            com.tencent.mm.kernel.g.azz().b(new cl(str2, cl.twy, bhK, boW));
        } else {
            avK(str);
        }
        finderCreateContactUI.vIA = com.tencent.mm.ui.base.h.a((Context) finderCreateContactUI, finderCreateContactUI.getString(R.string.ys), true, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(167189);
    }
}
