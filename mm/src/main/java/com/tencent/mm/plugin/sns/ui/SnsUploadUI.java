package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.j.n;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.ui.LocationWidget;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.g.c.b;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.edittext.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

@i
@a(17)
public class SnsUploadUI extends MMSecDataActivity implements LocationWidget.a {
    private String DMW = "";
    private c EPE;
    private AtContactWidget EPF;
    private LocationWidget EPG;
    private RangeWidget EPH;
    private SnsUploadSayFooter EPI;
    private DynamicGridView EPJ;
    private boolean EPK = false;
    private boolean EPL = false;
    boolean EPM = false;
    private Map<Integer, ad> EPN = new HashMap();
    private Map<String, List<String>> EPO = new HashMap();
    private Map<String, List<String>> EPP = new HashMap();
    private boolean EPQ = false;
    private String EPR = "";
    private long EPS = 3000;
    private Runnable EPT = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(176362);
            if (!(SnsUploadUI.this.EPE == null || SnsUploadUI.this.Ewa == null || !SnsUploadUI.this.Ewa.ffD())) {
                Parcel obtain = Parcel.obtain();
                SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.this.EPE.getText().toString());
                SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.this.EPE.getPasterLen());
                SnsUploadUI.c(SnsUploadUI.this);
                SnsUploadUI.this.getIntent().writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                String mD5String = MD5Util.getMD5String(marshall);
                Log.d("MicroMsg.SnsUploadUI", "autoSaveDraft lastMd5:%s, newMd5:%s", SnsUploadUI.this.EPR, mD5String);
                if (!Util.isEqual(SnsUploadUI.this.EPR, mD5String)) {
                    SnsUploadUI.this.EPR = mD5String;
                    SnsUploadUI.a(SnsUploadUI.this, marshall, 1);
                }
                aj.dRd().postDelayed(SnsUploadUI.this.EPT, SnsUploadUI.this.EPS);
            }
            AppMethodBeat.o(176362);
        }
    };
    private FrameLayout EPU = null;
    private long EPV = 0;
    private long EPW = 0;
    private int EPX = 0;
    private IListener<kp> EPY = new IListener<kp>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass18 */

        {
            AppMethodBeat.i(203776);
            this.__eventId = kp.class.getName().hashCode();
            AppMethodBeat.o(203776);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kp kpVar) {
            AppMethodBeat.i(203778);
            boolean a2 = a(kpVar);
            AppMethodBeat.o(203778);
            return a2;
        }

        private boolean a(kp kpVar) {
            AppMethodBeat.i(203777);
            if (kpVar != null && Util.isEqual(kpVar.dPH.dPI, new StringBuilder().append(SnsUploadUI.this.hashCode()).toString())) {
                g.aAh().azQ().set(ar.a.USERINFO_SNS_POST_BIZ_ID_STRING, kpVar.dPH.dPJ);
            }
            AppMethodBeat.o(203777);
            return false;
        }
    };
    private SnsUploadConfigView Eoy;
    private String EsT = "";
    private boolean EsU = false;
    private int Etq = 0;
    private int Etr = 0;
    private String EvA = "";
    private String EvB = "";
    private String Evz = "";
    private ad Ewa = null;
    private LinearLayout Ewb;
    private ArrayList<String> Ewd;
    private boolean Ewe = false;
    private boolean Ewf = false;
    private long Ewg = 0;
    private String canvasInfo = null;
    private String desc;
    private int knv = 0;
    private String mSessionId;
    private boolean thE = false;
    private int vjQ = 0;
    private KeyboardLinearLayout xbW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsUploadUI() {
        AppMethodBeat.i(99593);
        AppMethodBeat.o(99593);
    }

    static /* synthetic */ boolean K(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(176401);
        boolean z = snsUploadUI.EPL;
        AppMethodBeat.o(176401);
        return z;
    }

    static /* synthetic */ void a(SnsUploadUI snsUploadUI, byte[] bArr, int i2) {
        AppMethodBeat.i(203783);
        snsUploadUI.ac(bArr, i2);
        AppMethodBeat.o(203783);
    }

    static /* synthetic */ void b(SnsUploadUI snsUploadUI, int i2) {
        AppMethodBeat.i(203784);
        snsUploadUI.aaa(i2);
        AppMethodBeat.o(203784);
    }

    static /* synthetic */ void c(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(203782);
        snsUploadUI.fjL();
        AppMethodBeat.o(203782);
    }

    static /* synthetic */ void j(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(99620);
        snsUploadUI.fjP();
        AppMethodBeat.o(99620);
    }

    static /* synthetic */ void l(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(99623);
        snsUploadUI.fjQ();
        AppMethodBeat.o(99623);
    }

    static /* synthetic */ void n(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(176396);
        snsUploadUI.fjM();
        AppMethodBeat.o(176396);
    }

    static /* synthetic */ void q(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(176398);
        snsUploadUI.dAM();
        AppMethodBeat.o(176398);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(99594);
        if (bundle != null) {
            if (this.EPE != null) {
                bundle.putString("contentdesc", this.EPE.getText().toString());
            }
            this.Ewa.aD(bundle);
        }
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(99594);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String string;
        boolean z;
        j aQn;
        AppMethodBeat.i(99595);
        Log.i("MicroMsg.SnsUploadUI", "onCreate");
        h.q(this);
        super.onCreate(bundle);
        setActionbarColor(getContext().getResources().getColor(R.color.f3045c));
        hideActionbarLine();
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        aj.faV().db.delete("snsDraft", "key!=? AND key!=? AND timestamp<?", new String[]{"draft_text", "draft_normal", String.valueOf(System.currentTimeMillis() - Util.MILLSECONDS_OF_DAY)});
        this.EPQ = getIntent().getBooleanExtra("Kis_retry_edit", false);
        switch (getIntent().getIntExtra("Ksnsupload_type", 0)) {
            case 1:
            case 11:
            case 16:
            case 17:
            case 21:
            case 23:
            case 27:
                String nullAs = Util.nullAs(getIntent().getStringExtra("Ksnsupload_link"), "");
                if (Util.isNullOrNil(nullAs)) {
                    nullAs = Util.nullAs(getIntent().getStringExtra("ShareUrlOpen"), "");
                }
                if (Util.isNullOrNil(nullAs)) {
                    nullAs = Util.nullAs(getIntent().getStringExtra("ShareUrlOriginal"), "");
                }
                if (!Util.isNullOrNil(nullAs)) {
                    this.DMW = r.aOA(nullAs);
                }
                if (getIntent().getBooleanExtra("ksnsis_appbrand", false)) {
                    this.DMW = null;
                    break;
                }
                break;
            case 2:
            case 25:
                this.DMW = Util.nullAs(getIntent().getStringExtra("Ksnsupload_musicid"), "");
                break;
            case 15:
                Map<String, String> parseXml = XmlParser.parseXml(Util.nullAs(getIntent().getStringExtra("fav_note_xml"), ""), "favlocalid", null);
                if (!(parseXml == null || parseXml.size() == 0)) {
                    String str = parseXml.get(".favlocalid");
                    if (!Util.isEqual(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        this.DMW = str;
                        break;
                    }
                }
                break;
        }
        if (!Util.isNullOrNil(this.DMW) && !this.EPQ && (aQn = aj.faV().aQn(this.DMW)) != null) {
            byte[] bArr = aQn.field_draft;
            if (!Util.isNullOrNil(bArr)) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                setIntent((Intent) Intent.CREATOR.createFromParcel(obtain));
            }
        }
        amZ();
        this.EPE = (c) findViewById(R.id.hxn);
        this.EPE.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
        this.EPE.a(((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), new a.e() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void A(List<a.c> list, int i2) {
                AppMethodBeat.i(203765);
                long aWB = (long) cl.aWB();
                if (!(!((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag() || i2 == 8 || i2 == 1)) {
                    list.add(new a.c(SnsUploadUI.this.EPE.gYK().getString(R.string.hk_), 2));
                    SnsUploadUI.a(1, "", "", aWB, SnsUploadUI.this.mSessionId);
                }
                AppMethodBeat.o(203765);
            }

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void a(View view, a.c cVar, String str) {
                AppMethodBeat.i(203766);
                long aWB = (long) cl.aWB();
                if (cVar.id == 2) {
                    SnsUploadUI.this.EPE.getText().insert(SnsUploadUI.this.EPE.getSelectionStart(), SnsUploadUI.this.EPE.gYK().getString(R.string.hk_));
                    SnsUploadUI.a(2, "", "", aWB, SnsUploadUI.this.mSessionId);
                }
                AppMethodBeat.o(203766);
            }
        });
        this.EPE.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass9 */
            private List<ForegroundColorSpan> EDf = new LinkedList();

            {
                AppMethodBeat.i(203767);
                AppMethodBeat.o(203767);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(203768);
                Editable text = SnsUploadUI.this.EPE.getText();
                for (ForegroundColorSpan foregroundColorSpan : this.EDf) {
                    text.removeSpan(foregroundColorSpan);
                }
                this.EDf.clear();
                String obj = SnsUploadUI.this.EPE.getText().toString();
                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) {
                    Matcher matcher = k.a.Krb.matcher(obj);
                    while (matcher.find()) {
                        matcher.group();
                        int start = matcher.start();
                        int end = matcher.end();
                        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SnsUploadUI.this.getResources().getColor(R.color.Link_100));
                        this.EDf.add(foregroundColorSpan2);
                        text.setSpan(foregroundColorSpan2, start, end, 33);
                    }
                }
                AppMethodBeat.o(203768);
            }
        });
        if (!Util.isNullOrNil(getIntent().getStringExtra("Kdescription"))) {
            this.EPE.setText(b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.EPE.getTextSize()));
        } else if (!(this.EPE == null || bundle == null || (string = bundle.getString("contentdesc")) == null)) {
            this.EPE.setText(string);
        }
        if (this.vjQ == 8) {
            this.EPE.setText(b.c(getContext(), getIntent().getStringExtra("Kdescription"), this.EPE.getTextSize()));
        }
        this.EPE.setPasterLen(getIntent().getIntExtra("KparseLen", 0));
        this.xbW = (KeyboardLinearLayout) findViewById(R.id.h8v);
        this.EPI = (SnsUploadSayFooter) findViewById(R.id.h_i);
        this.EPI.setMMEditText(this.EPE);
        this.EPI.setVisibility(4);
        this.EPU = (FrameLayout) findViewById(R.id.h90);
        this.EPU.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(176382);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                aj.faD();
                com.tencent.mm.plugin.sns.storage.r.iI(displayMetrics.widthPixels, displayMetrics.heightPixels);
                AppMethodBeat.o(176382);
            }
        });
        this.EPE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass24 */

            public final void onClick(View view) {
                AppMethodBeat.i(176383);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsUploadUI.p(SnsUploadUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(176383);
            }
        });
        this.EPE.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass25 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(176384);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                SnsUploadUI.p(SnsUploadUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(176384);
                return false;
            }
        });
        final boolean[] zArr = {true};
        final boolean[] zArr2 = {false};
        this.EPE.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass2 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(176363);
                if (zArr[0]) {
                    zArr[0] = false;
                    d.INSTANCE.aIL("ie_sns_upload");
                }
                d.INSTANCE.aIM("ie_sns_upload");
                AppMethodBeat.o(176363);
            }
        });
        WrapScollview wrapScollview = (WrapScollview) findViewById(R.id.hcs);
        wrapScollview.setContentView(this.EPE.gYG());
        wrapScollview.setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        String nullAs2 = Util.nullAs(getIntent().getStringExtra("reportSessionId"), "");
        this.Eoy = (SnsUploadConfigView) findViewById(R.id.b_3);
        SnsUploadConfigView snsUploadConfigView = this.Eoy;
        if (this.vjQ != 14 || nullAs2.contains("wx5dfbe0a95623607b")) {
            z = false;
        } else {
            z = true;
        }
        snsUploadConfigView.EPu = z;
        if (z) {
            g.aAi();
            g.aAg().hqi.a(2842, snsUploadConfigView);
            com.tencent.mm.plugin.sns.model.j jVar = new com.tencent.mm.plugin.sns.model.j();
            g.aAi();
            g.aAg().hqi.a(jVar, 0);
        }
        snsUploadConfigView.Etm.LbD = -1000.0f;
        snsUploadConfigView.Etm.LbC = -1000.0f;
        if (!snsUploadConfigView.vUk) {
            g.aAi();
            int nullAsNil = Util.nullAsNil((Integer) g.aAh().azQ().get(68404, (Object) null));
            snsUploadConfigView.EPo = (nullAsNil & 2) != 0;
            snsUploadConfigView.EPp = (nullAsNil & 8) != 0;
            if (!com.tencent.mm.aw.b.isOverseasUser()) {
                snsUploadConfigView.EPp = false;
            }
            if (!z.aUC()) {
                snsUploadConfigView.EPo = false;
            }
        }
        snsUploadConfigView.setSyncFacebook(false);
        snsUploadConfigView.fjE();
        snsUploadConfigView.fjG();
        snsUploadConfigView.fjF();
        if (snsUploadConfigView.EPp) {
            snsUploadConfigView.EPv.a(snsUploadConfigView);
        }
        if (this.vjQ != 0) {
            SnsUploadConfigView snsUploadConfigView2 = this.Eoy;
            snsUploadConfigView2.EPj.setVisibility(8);
            snsUploadConfigView2.EPk.setVisibility(8);
            snsUploadConfigView2.EPl.setVisibility(8);
            snsUploadConfigView2.EPm.setVisibility(8);
        }
        if (this.vjQ == 9) {
            this.Eoy.EPl.setVisibility(0);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99572);
                SnsUploadUI.q(SnsUploadUI.this);
                AppMethodBeat.o(99572);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.h_8), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(176366);
                if (SnsUploadUI.this.isFinishing()) {
                    Log.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
                    AppMethodBeat.o(176366);
                } else if (SnsUploadUI.this.Ewa != null && !SnsUploadUI.this.Ewa.ffC()) {
                    Log.i("MicroMsg.SnsUploadUI", "skip commit, beforeCommit: false");
                    AppMethodBeat.o(176366);
                } else if (System.currentTimeMillis() - SnsUploadUI.this.EPV < 500) {
                    Log.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
                    AppMethodBeat.o(176366);
                } else if (SnsUploadUI.this.EPM) {
                    Log.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
                    AppMethodBeat.o(176366);
                } else {
                    aj.dRd().removeCallbacks(SnsUploadUI.this.EPT);
                    Parcel obtain = Parcel.obtain();
                    SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.this.EPE.getText().toString());
                    SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.this.EPE.getPasterLen());
                    SnsUploadUI.c(SnsUploadUI.this);
                    SnsUploadUI.this.getIntent().writeToParcel(obtain, 0);
                    SnsUploadUI.a(SnsUploadUI.this, obtain.marshall(), 2);
                    SnsUploadUI.j(SnsUploadUI.this);
                    if (zArr2[0]) {
                        zArr2[0] = false;
                    } else {
                        d.INSTANCE.jf("ce_sns_upload", "<SnsUpload>");
                        d.INSTANCE.a("ce_sns_upload", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                        d.INSTANCE.aIQ("ce_sns_upload");
                    }
                    SnsUploadUI.this.EPV = System.currentTimeMillis();
                    com.tencent.mm.plugin.report.service.g.Wl(22);
                    com.tencent.mm.ui.widget.cedit.api.d.a(SnsUploadUI.this.EPE).aoq(com.tencent.mm.n.c.aqj()).CN(true).a(new c.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.tools.b.c.a
                        public final void Tw(String str) {
                            AppMethodBeat.i(176364);
                            Log.i("MicroMsg.SnsUploadUI", "commit after check");
                            SnsUploadUI.this.knv = 3;
                            SnsUploadUI.t(SnsUploadUI.this);
                            int syncFlag = SnsUploadUI.this.Eoy.getSyncFlag();
                            g.aAi();
                            g.aAh().azQ().set(68404, Integer.valueOf(syncFlag));
                            SnsUploadUI.this.desc = SnsUploadUI.this.EPE.getText().toString();
                            int pasterLen = SnsUploadUI.this.EPE.getPasterLen();
                            int privated = SnsUploadUI.this.Eoy.getPrivated();
                            int syncFlag2 = SnsUploadUI.this.Eoy.getSyncFlag();
                            RangeWidget unused = SnsUploadUI.this.EPH;
                            if (SnsUploadUI.this.EPK) {
                                SnsUploadUI.this.setResult(-1, new Intent());
                            }
                            if (SnsUploadUI.this.Ewa instanceof aq) {
                                ((aq) SnsUploadUI.this.Ewa).EuL = SnsUploadUI.this.EPG.getCurLocation();
                            }
                            if (SnsUploadUI.this.Ewa instanceof am) {
                                SnsUploadUI.this.EPE.setText("");
                            }
                            SnsUploadUI.this.EPM = true;
                            PInt pInt = new PInt();
                            if (SnsUploadUI.this.Ewa instanceof a) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("param_is_privated", privated);
                                bundle.putString("param_description", SnsUploadUI.this.desc);
                                bundle.putStringArrayList("param_with_list", new ArrayList<>(SnsUploadUI.this.EPF.getAtList()));
                                bundle.putInt("param_paste_len", pasterLen);
                                try {
                                    bundle.putByteArray("param_localtion", SnsUploadUI.this.EPG.getLocation().toByteArray());
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.SnsUploadUI", e2, "parse location error", new Object[0]);
                                }
                                bundle.putBoolean("param_is_black_group", SnsUploadUI.this.Ewe);
                                bundle.putStringArrayList("param_group_user", SnsUploadUI.this.Ewd);
                                bundle.putInt("param_contact_tag_count", SnsUploadUI.this.Etq);
                                bundle.putInt("param_temp_user_count", SnsUploadUI.this.Etr);
                                pInt.value = ((a) SnsUploadUI.this.Ewa).getContentType();
                                ad unused2 = SnsUploadUI.this.Ewa;
                            } else {
                                SnsUploadUI.this.Ewa.a(privated, syncFlag2, SnsUploadUI.this.Eoy.getTwitterAccessToken(), SnsUploadUI.this.desc, SnsUploadUI.this.EPF.getAtList(), SnsUploadUI.this.EPG.getLocation(), null, pasterLen, SnsUploadUI.this.Ewe, SnsUploadUI.this.Ewd, pInt, SnsUploadUI.this.canvasInfo, SnsUploadUI.this.Etq, SnsUploadUI.this.Etr);
                            }
                            SnsUploadUI.G(SnsUploadUI.this);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr = new Object[5];
                            objArr[0] = Long.valueOf(SnsUploadUI.this.Ewg);
                            objArr[1] = Long.valueOf(Util.nowSecond());
                            objArr[2] = Integer.valueOf(SnsUploadUI.this.Ewf ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            objArr[4] = "";
                            hVar.a(13303, objArr);
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Long.valueOf(SnsUploadUI.this.Ewg);
                            objArr2[1] = Long.valueOf(Util.nowSecond());
                            objArr2[2] = Integer.valueOf(SnsUploadUI.this.Ewf ? 0 : 1);
                            objArr2[3] = Integer.valueOf(pInt.value);
                            Log.d("MicroMsg.SnsUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", objArr2);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10910, "1");
                            if (!Util.isNullOrNil(SnsUploadUI.this.Evz)) {
                                if (SnsUploadUI.this.Ewe) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11455, "", SnsUploadUI.this.Evz, -1, -1);
                                } else {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11455, SnsUploadUI.this.Evz, "", -1, -1);
                                }
                            }
                            if (SnsUploadUI.K(SnsUploadUI.this)) {
                                Intent intent = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                                intent.putExtra("sns_resume_state", false);
                                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                                intent.addFlags(67108864);
                                SnsUploadUI snsUploadUI = SnsUploadUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(snsUploadUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                snsUploadUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(snsUploadUI, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$12$1", "doWhenOK", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            q.br(SnsUploadUI.this.getIntent());
                            EventCenter.instance.publish(new wm());
                            SnsUploadUI.b(SnsUploadUI.this, 1);
                            SnsUploadUI.l(SnsUploadUI.this);
                            if (SnsUploadUI.this.EPQ) {
                                e.DUQ.DVA.eUb = 1;
                            } else {
                                e.DUQ.DVA.xm(SnsUploadUI.this.EsT);
                                e.DUQ.DVz.xm(SnsUploadUI.this.EsT);
                            }
                            r.eZy();
                            AppMethodBeat.o(176364);
                        }

                        @Override // com.tencent.mm.ui.tools.b.c.a
                        public final void Tx(String str) {
                        }

                        @Override // com.tencent.mm.ui.tools.b.c.a
                        public final void dv(String str) {
                            AppMethodBeat.i(176365);
                            com.tencent.mm.ui.base.h.n(SnsUploadUI.this, R.string.hc2, R.string.hc3);
                            AppMethodBeat.o(176365);
                        }
                    });
                    AppMethodBeat.o(176366);
                }
                return false;
            }
        }, null, new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(99574);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr2[0] = true;
                        d.INSTANCE.jf("ce_sns_upload", "<SnsUpload>");
                        break;
                    case 1:
                    case 6:
                        d.INSTANCE.a("ce_sns_upload", motionEvent);
                        d.INSTANCE.aIQ("ce_sns_upload");
                        break;
                }
                AppMethodBeat.o(99574);
                return false;
            }
        }, t.b.GREEN);
        findViewById(R.id.j0w).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(176367);
                Log.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
                if (SnsUploadUI.L(SnsUploadUI.this)) {
                    AppMethodBeat.o(176367);
                    return true;
                }
                AppMethodBeat.o(176367);
                return false;
            }
        });
        this.EPF = (AtContactWidget) findViewById(R.id.v6);
        this.EPF.Eoy = this.Eoy;
        this.EPG = (LocationWidget) findViewById(R.id.er1);
        this.EPG.setLocationWidgetListener(this);
        switch (this.vjQ) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 28:
                this.EPH = (RangeWidget) findViewById(R.id.gr3);
                findViewById(R.id.gr4).setVisibility(8);
                break;
            case 1:
            case 11:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 27:
                this.EPH = (RangeWidget) findViewById(R.id.gr3);
                findViewById(R.id.gr4).setVisibility(8);
                break;
            case 2:
            case 8:
            case 25:
                this.EPH = (RangeWidget) findViewById(R.id.gr3);
                findViewById(R.id.gr4).setVisibility(8);
                break;
        }
        this.EPH.Eoy = this.Eoy;
        this.EPH.setRangeTipClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(176368);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsUploadUI.M(SnsUploadUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(176368);
            }
        });
        this.EPG.aY(getIntent());
        this.EPF.aY(getIntent());
        e.DUQ.YP(0);
        e.DUQ.DVa.eTg = 2;
        bb(getIntent());
        hideVKB();
        aF(bundle);
        j aQn2 = aj.faV().aQn(this.DMW);
        if (aQn2 != null && (aQn2.field_extFlag & 1) == 1) {
            int i2 = 0;
            int i3 = 2;
            switch (this.vjQ) {
                case 0:
                case 28:
                    i2 = 3;
                    break;
                case 1:
                case 11:
                case 15:
                case 16:
                case 17:
                case 21:
                case 23:
                case 27:
                    i3 = 3;
                    break;
                case 9:
                    i2 = 1;
                    break;
                case 14:
                    i2 = 5;
                    break;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14247, 0, Integer.valueOf(i2), this.EsT, Long.valueOf(Util.nowSecond()), Integer.valueOf(i3));
        }
        h.r(this);
        Parcel obtain2 = Parcel.obtain();
        getIntent().writeToParcel(obtain2, 0);
        this.EPR = MD5Util.getMD5String(obtain2.marshall());
        this.EPS = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_draft_time, 3000L);
        this.EPW = Util.nowMilliSecond();
        this.EPM = false;
        AppMethodBeat.o(99595);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(176385);
        super.onStart();
        aj.dRd().postDelayed(this.EPT, this.EPS);
        AppMethodBeat.o(176385);
    }

    @TargetApi(11)
    private void fjK() {
        AppMethodBeat.i(99596);
        if (!(this.Ewa instanceof aq)) {
            Log.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
            AppMethodBeat.o(99596);
        } else if (Build.VERSION.SDK_INT < 11) {
            Log.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
            AppMethodBeat.o(99596);
        } else {
            new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(99582);
                    AnonymousClass1 r0 = new View.OnDragListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass12.AnonymousClass1 */

                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            AppMethodBeat.i(99581);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            bVar.bm(dragEvent);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, bVar.axR());
                            boolean z = false;
                            int action = dragEvent.getAction();
                            switch (action) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    z = true;
                                    Log.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", Integer.valueOf(action));
                                    break;
                                case 3:
                                    Log.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData == null) {
                                        z = true;
                                        break;
                                    } else {
                                        int itemCount = clipData.getItemCount();
                                        ArrayList arrayList = new ArrayList();
                                        for (int i2 = 0; i2 < itemCount; i2++) {
                                            ClipData.Item itemAt = clipData.getItemAt(i2);
                                            if (itemAt == null) {
                                                Log.e("MicroMsg.SnsUploadUI", "item == null");
                                            } else if (itemAt.getIntent() != null) {
                                                SnsUploadUI snsUploadUI = SnsUploadUI.this;
                                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(itemAt.getIntent());
                                                com.tencent.mm.hellhoundlib.a.a.a(snsUploadUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                snsUploadUI.startActivity((Intent) bl.pG(0));
                                                com.tencent.mm.hellhoundlib.a.a.a(snsUploadUI, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            } else if (itemAt.getUri() != null) {
                                                com.tencent.mm.pluginsdk.ui.tools.t tVar = new com.tencent.mm.pluginsdk.ui.tools.t(SnsUploadUI.this.getContext(), itemAt.getUri());
                                                if (tVar.fileType == 0 || tVar.filePath == null) {
                                                    Log.e("MicroMsg.SnsUploadUI", "get file path failed");
                                                } else {
                                                    switch (tVar.fileType) {
                                                        case 3:
                                                            arrayList.add(tVar.filePath);
                                                            continue;
                                                    }
                                                }
                                            }
                                        }
                                        if (arrayList.size() >= 0) {
                                            ((aq) SnsUploadUI.this.Ewa).c(arrayList, 0, false);
                                            z = true;
                                            break;
                                        } else {
                                            Log.e("MicroMsg.SnsUploadUI", "no image file available");
                                            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                                            AppMethodBeat.o(99581);
                                            return true;
                                        }
                                    }
                                    break;
                                default:
                                    Log.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                                    break;
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
                            AppMethodBeat.o(99581);
                            return z;
                        }
                    };
                    if (SnsUploadUI.this.EPU != null) {
                        SnsUploadUI.this.EPU.setOnDragListener(r0);
                    }
                    AppMethodBeat.o(99582);
                }
            }.run();
            AppMethodBeat.o(99596);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        AppMethodBeat.i(99597);
        if (keyEvent.getKeyCode() == 4) {
            SnsUploadSayFooter snsUploadSayFooter = this.EPI;
            if (snsUploadSayFooter.fjI() || snsUploadSayFooter.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.EPI.fjJ();
                AppMethodBeat.o(99597);
                return true;
            }
            dAM();
            AppMethodBeat.o(99597);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(99597);
        return onKeyDown;
    }

    private void fjL() {
        AppMethodBeat.i(203779);
        getIntent().putExtra("Kis_retry_edit", false);
        AppMethodBeat.o(203779);
    }

    private void ac(final byte[] bArr, final int i2) {
        AppMethodBeat.i(203780);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(176380);
                long currentTimeMillis = System.currentTimeMillis();
                aj.faV().b(SnsUploadUI.this.DMW, bArr, i2);
                Log.i("MicroMsg.SnsUploadUI", "saveDraft draftKey:%s, %s", SnsUploadUI.this.DMW, Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)));
                AppMethodBeat.o(176380);
            }
        });
        AppMethodBeat.o(203780);
    }

    private void dAM() {
        AppMethodBeat.i(99598);
        final boolean booleanExtra = getIntent().getBooleanExtra("KThrid_app", false);
        final String nullAs = Util.nullAs(getIntent().getStringExtra("Ksnsupload_appid"), "");
        if ((this.vjQ == 0 && ((aq) this.Ewa).fgG() > 0) || ((this.vjQ == 14 && (this.Ewa instanceof al) && !((al) this.Ewa).EsV) || ((this.vjQ == 9 && !Util.isNullOrNil(this.EPE.getText().toString())) || ((this.Ewa instanceof u) && !((u) this.Ewa).ffF())))) {
            com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.hbx, 0, (int) R.string.hbz, (int) R.string.hby, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass20 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    int i3;
                    AppMethodBeat.i(99587);
                    Log.i("MicroMsg.SnsUploadUI", "exitAndSave shareType:%s realtimeType:%s", Integer.valueOf(SnsUploadUI.this.vjQ), Integer.valueOf(SnsUploadUI.this.getIntent().getIntExtra("Ksnsupload_type", -1)));
                    SnsUploadUI.this.knv = 1;
                    Parcel obtain = Parcel.obtain();
                    SnsUploadUI.this.getIntent().putExtra("Kdescription", SnsUploadUI.this.EPE.getText().toString());
                    SnsUploadUI.this.getIntent().putExtra("KparseLen", SnsUploadUI.this.EPE.getPasterLen());
                    SnsUploadUI.c(SnsUploadUI.this);
                    SnsUploadUI.this.getIntent().writeToParcel(obtain, 0);
                    SnsUploadUI.a(SnsUploadUI.this, obtain.marshall(), 0);
                    SnsUploadUI.j(SnsUploadUI.this);
                    switch (SnsUploadUI.this.vjQ) {
                        case 0:
                            i3 = 3;
                            break;
                        case 9:
                            i3 = 1;
                            break;
                        case 14:
                            i3 = 5;
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14247, 0, Integer.valueOf(i3), SnsUploadUI.this.EsT, Long.valueOf(Util.nowSecond()), 1);
                    SnsUploadUI.b(SnsUploadUI.this, 3);
                    SnsUploadUI.l(SnsUploadUI.this);
                    if (SnsUploadUI.this.EPQ) {
                        e.DUQ.DVA.eUb = 2;
                        e.DUQ.fcE();
                    }
                    if (SnsUploadUI.this.Ewa instanceof u) {
                        e.DUQ.DVE.esJ = 3;
                        e.DUQ.fcF();
                    }
                    if (booleanExtra && nullAs.equals("wxa5e0de08d96cc09d")) {
                        e.DUQ.DVG.esJ = 3;
                        e.DUQ.fcG();
                    }
                    SnsUploadUI.n(SnsUploadUI.this);
                    AppMethodBeat.o(99587);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass21 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    int i3;
                    AppMethodBeat.i(99588);
                    SnsUploadUI.this.knv = 2;
                    aj.dRd().removeCallbacks(SnsUploadUI.this.EPT);
                    SnsUploadUI.a(SnsUploadUI.this, null, 0);
                    SnsUploadUI.j(SnsUploadUI.this);
                    String stringExtra = SnsUploadUI.this.getIntent().getStringExtra("KSightThumbPath");
                    String stringExtra2 = SnsUploadUI.this.getIntent().getStringExtra("KSightPath");
                    if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_sns_tmp_file, true)) {
                        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                        com.tencent.mm.plugin.recordvideo.e.c.aLG(stringExtra2);
                        com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                        com.tencent.mm.plugin.recordvideo.e.c.aLG(stringExtra);
                    }
                    if (SnsUploadUI.this.Ewa instanceof am) {
                        SnsUploadUI.this.EPE.setText("");
                    }
                    switch (SnsUploadUI.this.vjQ) {
                        case 0:
                            i3 = 4;
                            break;
                        case 9:
                            i3 = 2;
                            break;
                        case 14:
                            i3 = 6;
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14247, 0, Integer.valueOf(i3), SnsUploadUI.this.EsT, Long.valueOf(Util.nowSecond()), 0);
                    SnsUploadUI.b(SnsUploadUI.this, 2);
                    SnsUploadUI.l(SnsUploadUI.this);
                    if (SnsUploadUI.this.EPQ) {
                        e.DUQ.DVA.eUb = 3;
                        e.DUQ.fcE();
                    }
                    if (SnsUploadUI.this.Ewa instanceof u) {
                        e.DUQ.DVE.esJ = 3;
                        e.DUQ.fcF();
                    }
                    if (booleanExtra && nullAs.equals("wxa5e0de08d96cc09d")) {
                        e.DUQ.DVG.esJ = 3;
                        e.DUQ.fcG();
                    }
                    SnsUploadUI.o(SnsUploadUI.this);
                    AppMethodBeat.o(99588);
                }
            }, (int) R.color.cc);
            AppMethodBeat.o(99598);
        } else if ((this.Ewa instanceof ae) || (this.Ewa instanceof ak) || (this.Ewa instanceof aj)) {
            if (!Util.isNullOrNil(this.EPE.getText().toString())) {
                aj.dRd().removeCallbacks(this.EPT);
                Parcel obtain = Parcel.obtain();
                getIntent().putExtra("Kdescription", this.EPE.getText().toString());
                getIntent().putExtra("KparseLen", this.EPE.getPasterLen());
                fjL();
                getIntent().writeToParcel(obtain, 0);
                ac(obtain.marshall(), 0);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14247, 0, 7, this.EsT, Long.valueOf(Util.nowSecond()), 3);
            }
            fjP();
            aaa(2);
            if (this.EPQ) {
                e.DUQ.DVA.eUb = 2;
                e.DUQ.fcE();
            }
            fjQ();
            fjM();
            AppMethodBeat.o(99598);
        } else {
            com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.hbw, 0, (int) R.string.ha, (int) R.string.sz, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass22 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(176381);
                    aj.dRd().removeCallbacks(SnsUploadUI.this.EPT);
                    SnsUploadUI.a(SnsUploadUI.this, null, 0);
                    SnsUploadUI.j(SnsUploadUI.this);
                    SnsUploadUI.b(SnsUploadUI.this, 2);
                    SnsUploadUI.l(SnsUploadUI.this);
                    if (SnsUploadUI.this.EPQ) {
                        e.DUQ.DVA.eUb = 3;
                        e.DUQ.fcE();
                    }
                    if (SnsUploadUI.this.Ewa instanceof u) {
                        e.DUQ.DVE.esJ = 3;
                        e.DUQ.fcF();
                    }
                    if (booleanExtra && nullAs.equals("wxa5e0de08d96cc09d")) {
                        e.DUQ.DVG.esJ = 3;
                        e.DUQ.fcG();
                    }
                    SnsUploadUI.o(SnsUploadUI.this);
                    AppMethodBeat.o(176381);
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
            AppMethodBeat.o(99598);
        }
    }

    private void fjM() {
        AppMethodBeat.i(99599);
        if (this.thE) {
            e eVar = e.DUQ;
            e.a(10, "", 0, 0, cl.aWz(), 0);
        }
        setResult(0, new Intent());
        finish();
        r.eZy();
        AppMethodBeat.o(99599);
    }

    public final void fjN() {
        AppMethodBeat.i(99600);
        if (this.Ewa.ffA()) {
            enableOptionMenu(true);
            AppMethodBeat.o(99600);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(99600);
    }

    public static void a(int i2, String str, String str2, long j2, String str3) {
        AppMethodBeat.i(203781);
        com.tencent.mm.plugin.websearch.a.b.a(1, 1, z.aTY(), str2, 1, "", str3, i2, str, j2);
        AppMethodBeat.o(203781);
    }

    private void amZ() {
        AppMethodBeat.i(99601);
        this.Ewf = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.Ewg = getIntent().getLongExtra("KTouchCameraTime", 0);
        this.vjQ = getIntent().getIntExtra("Ksnsupload_type", 0);
        this.EsU = getIntent().getBooleanExtra("Kis_take_photo", false);
        this.EPX = this.EsU ? 2 : 1;
        this.EPK = getIntent().getBooleanExtra("need_result", false);
        this.EPL = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
        this.canvasInfo = getIntent().getStringExtra("Ksnsupload_canvas_info");
        this.EsT = getIntent().getStringExtra("KSessionID");
        this.thE = getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
        if (Util.isNullOrNil(this.EsT)) {
            this.EsT = r.eZx();
            getIntent().putExtra("KSessionID", this.EsT);
        } else {
            this.EPX = 3;
        }
        this.mSessionId = com.tencent.mm.plugin.fts.a.d.Nj(79);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        com.tencent.mm.plugin.sns.j.j jVar = (com.tencent.mm.plugin.sns.j.j) SecDataUIC.a.c(this, 2, com.tencent.mm.plugin.sns.j.j.class);
        if (jVar != null) {
            jVar.sessionId = this.mSessionId;
        }
        AppMethodBeat.o(99601);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(99602);
        super.hideVKB();
        super.onPause();
        this.EPE.onPause();
        AppMethodBeat.o(99602);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(99603);
        super.onResume();
        this.EPI.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(203769);
                com.tencent.mm.compatible.util.i.v(SnsUploadUI.this);
                AppMethodBeat.o(203769);
            }
        });
        if (this.Ewa != null && (this.Ewa instanceof al)) {
            al alVar = (al) this.Ewa;
            if (alVar.EsO != null) {
                if (!alVar.EsV) {
                    alVar.ffZ();
                } else {
                    alVar.fga();
                }
            }
        }
        this.EPE.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
        AppMethodBeat.o(99603);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(176387);
        super.onStop();
        aj.dRd().removeCallbacks(this.EPT);
        AppMethodBeat.o(176387);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99604);
        super.onDestroy();
        if (this.Eoy != null) {
            SnsUploadConfigView snsUploadConfigView = this.Eoy;
            g.aAi();
            g.aAg().hqi.b(2842, snsUploadConfigView);
        }
        if (this.Ewa != null) {
            this.Ewa.ffE();
        }
        if (this.EPG != null) {
            this.EPG.stop();
        }
        if (this.EPI != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.EPI;
            if (snsUploadSayFooter.rum != null) {
                snsUploadSayFooter.rum.goC();
                snsUploadSayFooter.rum.destroy();
            }
        }
        this.EPN.clear();
        d.INSTANCE.aIN("ie_sns_upload");
        r.eZy();
        EventCenter.instance.removeListener(this.EPY);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        com.tencent.mm.plugin.sns.j.j jVar = (com.tencent.mm.plugin.sns.j.j) SecDataUIC.a.c(this, 2, com.tencent.mm.plugin.sns.j.j.class);
        if (jVar != null && jVar.ecf > 0) {
            ((com.tencent.mm.plugin.secdata.g) g.ah(com.tencent.mm.plugin.secdata.g.class)).updateWithSave(2, "SnsPostEnd_" + jVar.ecf, jVar, new com.tencent.mm.plugin.secdata.i<com.tencent.mm.plugin.sns.j.j>() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass11 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, boolean, com.tencent.mm.bw.a] */
                @Override // com.tencent.mm.plugin.secdata.i
                public final /* synthetic */ void a(int i2, boolean z, com.tencent.mm.plugin.sns.j.j jVar) {
                    AppMethodBeat.i(203770);
                    Log.i("MicroMsg.SnsUploadUI", "PluginSecData onActionDone %s %b", Integer.valueOf(i2), Boolean.valueOf(z));
                    AppMethodBeat.o(203770);
                }
            });
        }
        this.EPE.destroy();
        AppMethodBeat.o(99604);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(99605);
        super.onActivityResult(i2, i3, intent);
        if (this.EPE != null) {
            this.EPE.clearFocus();
        }
        if (i3 != -1) {
            AppMethodBeat.o(99605);
        } else if (i2 == 30764) {
            Bundle bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                g.aAh().azQ().set(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
            }
            AppMethodBeat.o(99605);
        } else {
            if (this.Ewa.k(i2, intent)) {
                fjN();
            }
            switch (i2) {
                case 5:
                    if (intent == null) {
                        AppMethodBeat.o(99605);
                        return;
                    }
                    getIntent().putExtras(intent.getExtras());
                    bb(intent);
                    AppMethodBeat.o(99605);
                    return;
                case 6:
                    if (intent == null) {
                        AppMethodBeat.o(99605);
                        return;
                    }
                    getIntent().putExtras(intent.getExtras());
                    this.EPF.aY(intent);
                    AppMethodBeat.o(99605);
                    return;
                case 8:
                    if (intent == null) {
                        AppMethodBeat.o(99605);
                        return;
                    }
                    boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                    SnsUploadConfigView snsUploadConfigView = this.Eoy;
                    if (booleanExtra) {
                        snsUploadConfigView.EPo = true;
                        snsUploadConfigView.setSyncFacebook(true);
                    }
                    AppMethodBeat.o(99605);
                    return;
                case 10:
                    if (intent != null) {
                        String nullAs = Util.nullAs(intent.getStringExtra("get_poi_name"), "");
                        String nullAs2 = Util.nullAs(intent.getStringExtra("get_city"), "");
                        if (Util.isNullOrNil(nullAs)) {
                            getIntent().removeExtra("get_poi_name");
                        }
                        if (Util.isNullOrNil(nullAs2)) {
                            getIntent().removeExtra("get_city");
                        }
                        getIntent().putExtras(intent.getExtras());
                        this.EPG.aY(intent);
                        break;
                    } else {
                        AppMethodBeat.o(99605);
                        return;
                    }
            }
            AppMethodBeat.o(99605);
        }
    }

    private void bb(Intent intent) {
        List<String> list;
        List<String> list2;
        List<String> list3 = null;
        AppMethodBeat.i(99606);
        this.EPH.a(5, -1, intent, this.EPF);
        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
        if (intExtra >= 2) {
            this.Evz = intent.getStringExtra("Klabel_name_list");
            this.EvA = intent.getStringExtra("Kother_user_name_list");
            this.EvB = intent.getStringExtra("Kchat_room_name_list");
            if (!Util.isNullOrNil(this.Evz)) {
                list = Arrays.asList(this.Evz.split(","));
            } else {
                list = null;
            }
            if (!Util.isNullOrNil(this.EvA)) {
                list2 = Arrays.asList(this.EvA.split(","));
                e.DUQ.gT(list2);
            } else {
                list2 = null;
            }
            if (!Util.isNullOrNil(this.EvB)) {
                list3 = Arrays.asList(this.EvB.split(","));
            }
            r(list, list2);
            gg(list3);
            if (intExtra == 2) {
                this.Ewe = false;
            } else {
                this.Ewe = true;
            }
            if (this.EPO != null && !this.EPO.isEmpty()) {
                e.DUQ.aP(this.EPO);
            }
            if (this.EPP != null && !this.EPP.isEmpty()) {
                e.DUQ.aO(this.EPP);
            }
        } else if (!Util.isNullOrNil(this.Ewd)) {
            this.Ewd.clear();
        }
        e.DUQ.YP(intExtra);
        AppMethodBeat.o(99606);
    }

    private void gg(List<String> list) {
        AppMethodBeat.i(99607);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(99607);
            return;
        }
        this.EPP.clear();
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            List<String> Id = v.Id(str);
            if (Id != null) {
                Log.d("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom chatromm:%s membersCount:%s", str, Integer.valueOf(Id.size()));
                for (String str2 : Id) {
                    if (!this.Ewd.contains(str2) && ab.IS(str2)) {
                        Log.i("MicroMsg.SnsUploadUI", "getContactNamesFromChatroom memberName:%s", str2);
                        this.Ewd.add(str2);
                        this.Etr++;
                    }
                    if (ab.IS(str2)) {
                        arrayList.add(str2);
                    }
                }
                Log.d("MicroMsg.SnsUploadUI", "%s , %s", str, Integer.valueOf(arrayList.size()));
                this.EPP.put(str, arrayList);
            }
        }
        AppMethodBeat.o(99607);
    }

    private void r(List<String> list, List<String> list2) {
        int i2;
        AppMethodBeat.i(99608);
        this.Ewd = new ArrayList<>();
        this.Etq = 0;
        this.EPO.clear();
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            HashSet hashSet = new HashSet();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                List<String> aCK = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(next));
                if (aCK == null || aCK.size() == 0) {
                    Log.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                } else {
                    for (String str : aCK) {
                        hashSet.add(str);
                        this.Etq++;
                        Log.d("MicroMsg.SnsUploadUI", "dz:name : %s", str);
                    }
                    this.EPO.put(next, aCK);
                }
            }
            this.Ewd = new ArrayList<>(hashSet);
        }
        if (list != null) {
            int i3 = 0;
            for (String str2 : list) {
                if (!Util.isNullOrNil(str2)) {
                    i2 = i3 + 1;
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
            this.Etq = i3;
        }
        this.Etr = 0;
        if (list2 != null && list2.size() > 0) {
            for (String str3 : list2) {
                if (!this.Ewd.contains(str3)) {
                    this.Ewd.add(str3);
                    this.Etr++;
                }
            }
        }
        AppMethodBeat.o(99608);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.by2;
    }

    @Override // com.tencent.mm.plugin.sns.ui.LocationWidget.a
    public final ArrayList<Exif.a> ffS() {
        AppMethodBeat.i(99609);
        if (this.Ewa instanceof aq) {
            aq aqVar = (aq) this.Ewa;
            ArrayList<String> arrayList = aqVar.EuF.EuQ;
            ArrayList<Exif.a> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                Exif.a aVar = aqVar.EuH.get(it.next());
                if (aVar != null) {
                    arrayList2.add(aVar);
                }
            }
            AppMethodBeat.o(99609);
            return arrayList2;
        }
        AppMethodBeat.o(99609);
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.LocationWidget.a
    public final boolean ffT() {
        return this.EsU;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(99610);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(99610);
            return;
        }
        Log.i("MicroMsg.SnsUploadUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 64:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(203771);
                            SnsUploadUI snsUploadUI = SnsUploadUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(snsUploadUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$20", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            snsUploadUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(snsUploadUI, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$20", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            dialogInterface.dismiss();
                            AppMethodBeat.o(203771);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass14 */

                        {
                            AppMethodBeat.i(160743);
                            AppMethodBeat.o(160743);
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(203772);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(203772);
                        }
                    });
                    break;
                } else {
                    this.EPG.ffP();
                    AppMethodBeat.o(99610);
                    return;
                }
        }
        AppMethodBeat.o(99610);
    }

    public final void a(String str, boolean z, int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i3) {
        AppMethodBeat.i(99611);
        Log.i("MicroMsg.SnsUploadUI", "updatePicConfig");
        getIntent().getExtras().clear();
        getIntent().putExtra("KTouchCameraTime", Util.nowSecond());
        getIntent().putExtra("KSnsPostManu", true);
        getIntent().putExtra("Ksnsupload_type", 0);
        getIntent().putExtra("KFilterId", i2);
        if (!Util.isNullOrNil(str)) {
            getIntent().putExtra("sns_kemdia_path", str);
        }
        if (!Util.isNullOrNil(arrayList)) {
            getIntent().putExtra("sns_kemdia_path_list", arrayList);
        }
        if (!Util.isNullOrNil(arrayList2)) {
            getIntent().putStringArrayListExtra("sns_media_latlong_list", arrayList2);
        }
        if (z) {
            getIntent().putExtra("Kis_take_photo", z);
        }
        if (i3 != 0) {
            getIntent().putExtra("Ksnsupload_source", 11);
        }
        AppMethodBeat.o(99611);
    }

    public final void a(String str, String str2, String str3, byte[] bArr, boolean z) {
        AppMethodBeat.i(99612);
        Log.i("MicroMsg.SnsUploadUI", "updateSightConfig");
        getIntent().getExtras().clear();
        getIntent().putExtra("KSightPath", str);
        getIntent().putExtra("KSightThumbPath", str2);
        getIntent().putExtra("sight_md5", str3);
        getIntent().putExtra("KSnsPostManu", true);
        getIntent().putExtra("Ksnsupload_type", 14);
        getIntent().putExtra("Kis_take_photo", false);
        getIntent().putExtra("KMMSightExtInfo", bArr);
        if (z) {
            getIntent().putExtra("KSessionID", Util.nowMilliSecond() + "_" + Util.getRandomString(5));
        }
        AppMethodBeat.o(99612);
    }

    public final void fjO() {
        AppMethodBeat.i(99613);
        Log.i("MicroMsg.SnsUploadUI", "resetWidget");
        if (this.EPJ != null) {
            this.EPJ.setVisibility(8);
        }
        if (this.Ewb != null) {
            this.Ewb.removeAllViews();
            this.Ewb.setVisibility(8);
        }
        if (this.Ewa != null) {
            this.Ewa.ffE();
        }
        amZ();
        aF(null);
        AppMethodBeat.o(99613);
    }

    private ad ZZ(int i2) {
        AppMethodBeat.i(99614);
        ad adVar = this.EPN.get(Integer.valueOf(i2));
        if (adVar == null) {
            if (i2 == 0) {
                adVar = new aq(this);
            } else if (i2 == 14) {
                adVar = new al(this);
            } else if (i2 == 28) {
                adVar = new by(this);
            }
            this.EPN.put(Integer.valueOf(i2), adVar);
        }
        AppMethodBeat.o(99614);
        return adVar;
    }

    private void aF(Bundle bundle) {
        View view;
        boolean z = true;
        AppMethodBeat.i(99615);
        Log.i("MicroMsg.SnsUploadUI", "attachWidget. share type %d, isManuSnsPost:%b", Integer.valueOf(this.vjQ), Boolean.valueOf(this.Ewf));
        if (this.vjQ == 0 || this.vjQ == 14 || this.vjQ == 9) {
            Parcel obtain = Parcel.obtain();
            getIntent().writeToParcel(obtain, 0);
            obtain.marshall();
            if (this.vjQ == 9) {
                setMMTitle(getContext().getResources().getString(R.string.hb0));
            } else {
                setMMTitle("");
            }
        }
        switch (this.vjQ) {
            case 0:
            case 28:
                this.DMW = "draft_normal";
                this.Ewa = ZZ(this.vjQ);
                this.EPE.addTextChangedListener(new TextWatcher() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass15 */

                    {
                        AppMethodBeat.i(176376);
                        AppMethodBeat.o(176376);
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        View findViewById;
                        AppMethodBeat.i(203773);
                        if (SnsUploadUI.this.EPE.getText().toString().trim().length() > 10 && (findViewById = SnsUploadUI.this.findViewById(R.id.hya)) != null) {
                            findViewById.setVisibility(8);
                        }
                        AppMethodBeat.o(203773);
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 1:
            case 11:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
                this.Ewa = new ae(this);
                break;
            case 2:
                this.Ewa = new ak(this);
                break;
            case 3:
                this.Ewa = new ar(this, 9);
                break;
            case 4:
                this.Ewa = new q(this);
                break;
            case 5:
                this.Ewa = new ar(this, 14);
                break;
            case 6:
                this.Ewa = new ar(this, 12);
                break;
            case 7:
                this.Ewa = new ar(this, 13);
                break;
            case 8:
                this.Ewa = new bp(this);
                break;
            case 9:
                this.DMW = "draft_text";
                String nullAs = Util.nullAs(getIntent().getStringExtra("Kdescription"), "");
                int nullAs2 = Util.nullAs(Integer.valueOf(getIntent().getIntExtra("KparseLen", 0)), 0);
                if (nullAs == null || Util.isNullOrNil(nullAs.trim())) {
                    z = false;
                }
                this.Ewa = new am(this, z);
                this.EPE.setPasterLen(nullAs2);
                this.EPE.setText(com.tencent.mm.ui.g.c.b.c(getContext(), nullAs, this.EPE.getTextSize()));
                this.EPE.addTextChangedListener(new TextWatcher() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass16 */

                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        AppMethodBeat.i(203774);
                        if (SnsUploadUI.this.EPE.getText().toString().trim().length() > 0) {
                            SnsUploadUI.this.enableOptionMenu(true);
                            AppMethodBeat.o(203774);
                            return;
                        }
                        SnsUploadUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(203774);
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 10:
                this.Ewa = new o(this);
                break;
            case 12:
                this.Ewa = new p(this);
                break;
            case 13:
                this.Ewa = new r(this);
                break;
            case 14:
                this.DMW = "draft_normal";
                this.Ewa = ZZ(this.vjQ);
                break;
            case 17:
                this.Ewa = new u(this);
                break;
            case 19:
                this.Ewa = new ag(this);
                break;
            case 21:
                this.Ewa = new t(this);
                break;
            case 23:
                this.Ewa = new ah(this);
                break;
            case 25:
                this.Ewa = new aj(this);
                break;
            case 27:
                this.Ewa = new bx(this);
                break;
        }
        this.Ewa.aC(bundle);
        if (!(this.Ewa instanceof aq) || (this.Ewa instanceof by)) {
            View ffB = this.Ewa.ffB();
            this.Ewb = (LinearLayout) findViewById(R.id.jnw);
            this.Ewb.setVisibility(0);
            this.Ewb.setClipChildren(false);
            if (ffB != null) {
                Log.d("MicroMsg.SnsUploadUI", "will add widget view in widgetLL.");
                this.Ewb.addView(ffB);
            } else {
                this.Ewb.setVisibility(8);
            }
            if (this.vjQ == 9 || this.vjQ == 14) {
                View findViewById = findViewById(R.id.jnx);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.addRule(3, R.id.jnw);
                layoutParams.topMargin = (int) (((float) (this.vjQ == 9 ? 128 : 96)) * BitmapUtil.getDefaultDisplayMetrics().density);
                findViewById.setLayoutParams(layoutParams);
            }
            view = ffB;
        } else {
            View findViewById2 = findViewById(R.id.hxm);
            View findViewById3 = findViewById(R.id.hya);
            this.EPJ = (DynamicGridView) findViewById(R.id.hzy);
            this.EPJ.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadUI.AnonymousClass17 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(203775);
                    boolean L = SnsUploadUI.L(SnsUploadUI.this);
                    AppMethodBeat.o(203775);
                    return L;
                }
            });
            View a2 = ((aq) this.Ewa).a(findViewById2, findViewById(R.id.blg), this.EPJ, findViewById3);
            this.EPJ.setVisibility(0);
            View findViewById4 = findViewById(R.id.jnx);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById4.getLayoutParams();
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(3, R.id.hzy);
            findViewById4.setLayoutParams(layoutParams2);
            view = a2;
        }
        if ((this.Ewa instanceof ae) || (this.Ewa instanceof ag)) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = -1;
            view.setLayoutParams(layoutParams3);
        }
        if ((this.Ewa instanceof q) || (this.Ewa instanceof o) || (this.Ewa instanceof p)) {
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams4.width = -1;
            view.setLayoutParams(layoutParams4);
        }
        fjN();
        if (this.vjQ == 0) {
            fjK();
        }
        AppMethodBeat.o(99615);
    }

    private void fjP() {
        AppMethodBeat.i(176388);
        if (this.vjQ == 9) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_NEWTEXT_LAST_SESSIONID_STRING, this.EsT);
            AppMethodBeat.o(176388);
            return;
        }
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, this.EsT);
        AppMethodBeat.o(176388);
    }

    private void aaa(int i2) {
        AppMethodBeat.i(176389);
        e.DUQ.DVa.xk(this.EsT);
        e.DUQ.DVa.eTw = i2;
        if (i2 == 3 || i2 == 2) {
            e.DUQ.fcw();
        }
        AppMethodBeat.o(176389);
    }

    private void fjQ() {
        Map<String, Boolean> fgI;
        int i2;
        AppMethodBeat.i(176390);
        com.tencent.mm.plugin.expt.b.c cVar = (com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class);
        cVar.gk("startTime", new StringBuilder().append(this.EPW).toString());
        cVar.gk("endTime", new StringBuilder().append(Util.nowMilliSecond()).toString());
        cVar.gk("bussinessId", this.EsT);
        cVar.gk("shareType", new StringBuilder().append(this.vjQ).toString());
        cVar.gk("hadLocation", new StringBuilder().append(this.EPG.getShowFlag()).toString());
        cVar.gk("desc", this.EPE.getText().toString());
        cVar.gk("nextStep", new StringBuilder().append(this.knv).toString());
        cVar.gk("beforeStep", new StringBuilder().append(this.EPX).toString());
        cVar.gk("ContactTagCount", new StringBuilder().append(this.Etq).toString());
        cVar.gk("mIsBlackGroup", new StringBuilder().append(this.Ewe).toString());
        cVar.gk("mContactNameList", this.Ewd != null ? new StringBuilder().append(this.Ewd.size()).toString() : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if ((this.Ewa instanceof aq) && (fgI = ((aq) this.Ewa).fgI()) != null && !fgI.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Boolean bool : fgI.values()) {
                if (bool.booleanValue()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                sb.append(i2).append("#");
            }
            cVar.gk("picSource", sb.toString());
        }
        if (this.Ewa instanceof al) {
            cVar.gk("sightSource", ((al) this.Ewa).fgb() ? "1" : "2");
        }
        AppMethodBeat.o(176390);
    }

    static /* synthetic */ void o(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(99625);
        snsUploadUI.fjM();
        AppMethodBeat.o(99625);
    }

    static /* synthetic */ void p(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(176397);
        snsUploadUI.EPE.gYJ();
        Log.d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.EPI.fjI()) {
            snsUploadUI.EPI.fjJ();
        }
        if (!KeyBoardUtil.isPortOrientation(snsUploadUI)) {
            snsUploadUI.EPI.fjH();
        }
        snsUploadUI.getContentView().postInvalidate();
        AppMethodBeat.o(176397);
    }

    static /* synthetic */ void t(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(203785);
        EventCenter.instance.add(snsUploadUI.EPY);
        com.tencent.mm.plugin.expt.b.c cVar = (com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class);
        if (cVar != null) {
            cVar.aoe(new StringBuilder().append(snsUploadUI.hashCode()).toString());
        }
        AppMethodBeat.o(203785);
    }

    static /* synthetic */ void G(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(203786);
        List<String> stringToList = Util.stringToList(snsUploadUI.EvA, ",");
        List<String> stringToList2 = Util.stringToList(snsUploadUI.Evz, ",");
        List<String> stringToList3 = Util.stringToList(snsUploadUI.EvB, ",");
        LinkedList linkedList = new LinkedList();
        if (!Util.isNullOrNil(stringToList2)) {
            for (String str : stringToList2) {
                n nVar = new n();
                nVar.name = com.tencent.mm.plugin.label.a.a.ecg().aCH(str);
                nVar.type = 1;
                linkedList.add(nVar);
            }
        }
        if (!Util.isNullOrNil(stringToList3)) {
            for (int i2 = 0; i2 < stringToList3.size(); i2++) {
                n nVar2 = new n();
                nVar2.name = stringToList3.get(i2);
                nVar2.type = 2;
                linkedList.add(nVar2);
            }
        }
        if (!Util.isNullOrNil(stringToList)) {
            for (String str2 : stringToList) {
                n nVar3 = new n();
                nVar3.name = str2;
                nVar3.type = 0;
                linkedList.add(nVar3);
            }
        }
        aj.faK().m(linkedList, snsUploadUI.Ewe);
        AppMethodBeat.o(203786);
    }

    static /* synthetic */ boolean L(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(203787);
        snsUploadUI.hideVKB();
        if (snsUploadUI.EPI.fjI()) {
            snsUploadUI.EPI.fjJ();
            AppMethodBeat.o(203787);
            return true;
        }
        AppMethodBeat.o(203787);
        return false;
    }

    static /* synthetic */ void M(SnsUploadUI snsUploadUI) {
        AppMethodBeat.i(203788);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        m mVar = aj.faK().DOH;
        Iterator<n> it = mVar.DSe.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.type == 2) {
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(next.name);
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    arrayList.add(next.name);
                }
            } else if (next.type == 1) {
                String aCG = com.tencent.mm.plugin.label.a.a.ecg().aCG(next.name);
                if (aCG != null) {
                    arrayList2.add(aCG);
                }
            } else if (next.type == 0) {
                arrayList3.add(next.name);
            }
        }
        snsUploadUI.EvB = Util.listToString(arrayList, ",");
        snsUploadUI.Evz = Util.listToString(arrayList2, ",");
        snsUploadUI.EvA = Util.listToString(arrayList3, ",");
        snsUploadUI.getIntent().putExtra("Kother_user_name_list", snsUploadUI.EvA);
        snsUploadUI.getIntent().putExtra("Klabel_name_list", snsUploadUI.Evz);
        snsUploadUI.getIntent().putExtra("Kchat_room_name_list", snsUploadUI.EvB);
        if (mVar.DSg) {
            snsUploadUI.getIntent().putExtra("Ktag_range_index", 3);
        } else {
            snsUploadUI.getIntent().putExtra("Ktag_range_index", 2);
        }
        snsUploadUI.bb(snsUploadUI.getIntent());
        AppMethodBeat.o(203788);
    }
}
