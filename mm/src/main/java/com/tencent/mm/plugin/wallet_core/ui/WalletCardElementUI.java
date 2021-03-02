package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import com.tenpay.ndk.Encrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements TextView.OnEditorActionListener, WalletFormView.a {
    private Orders CwO = null;
    private TextView EIm;
    private Authen HFI = new Authen();
    d HGS = null;
    private IListener HJH = new IListener<tg>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass13 */

        {
            AppMethodBeat.i(174519);
            this.__eventId = tg.class.getName().hashCode();
            AppMethodBeat.o(174519);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tg tgVar) {
            AppMethodBeat.i(174520);
            tg tgVar2 = tgVar;
            if (!(tgVar2 instanceof tg)) {
                Log.f("MicroMsg.WalletCardElmentUI", "mismatched ScanBankCardResultEvent event");
                AppMethodBeat.o(174520);
                return false;
            }
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletCardElementUI.a(WalletCardElementUI.this, encrypt.desedeEncode(tgVar2.dZH.cardId, randomKey), randomKey, tgVar2.dZH.dZI);
            AppMethodBeat.o(174520);
            return true;
        }
    };
    private WalletFormView HJY;
    private TextView HJZ;
    private TextView HKa;
    private int HKd = 1;
    private ElementQuery HRy = new ElementQuery();
    private Profession HRz;
    private List<djv> HSB = new ArrayList();
    private String[] HSD;
    private WalletFormView Idq;
    private Bankcard Ids = null;
    private WalletFormView IeA;
    private WalletFormView IeB;
    private WalletFormView IeC;
    private WalletFormView IeD;
    private WalletFormView IeE;
    private WalletPhoneInputView IeF;
    private WalletFormView IeG = null;
    private WalletFormView IeH;
    private Map<String, d.a> IeI = null;
    private boolean IeJ = false;
    private CheckBox IeK;
    private CheckBox IeL;
    private String IeM;
    private boolean IeN;
    private boolean IeO;
    private boolean IeP = false;
    private boolean IeQ = false;
    private boolean IeR = false;
    private boolean IeS = false;
    private boolean IeT = false;
    private boolean IeU = false;
    private boolean IeV = false;
    private String[] IeW = null;
    private String IeX;
    private WalletFormView IeY;
    private List<ElementQuery> IeZ = new ArrayList();
    private TextView Iea;
    private TextView Ieb;
    private TextView Iec;
    private TextView Ied;
    private TextView Iee;
    private TextView Ief;
    private TextView Ieg;
    private TextView Ieh;
    private TextView Iei;
    private WalletFormView Iej;
    private WalletFormView Iek;
    private WalletFormView Iel;
    private WalletFormView Iem;
    private WalletFormView Ien;
    private WalletFormView Ieo;
    private WalletFormView Iep;
    private WalletFormView Ieq;
    private WalletFormView Ier;
    private WalletFormView Ies;
    private WalletFormView Iet;
    private WalletFormView Ieu;
    private WalletFormView Iev;
    private WalletFormView Iew;
    private WalletFormView Iex;
    private WalletFormView Iey;
    private WalletFormView Iez;
    private int Ifa;
    private int Ifb;
    private int Ifc;
    private int Ifd;
    private int Ife;
    private int Iff;
    private int Ifg;
    private int Ifh;
    private int Ifi;
    private int Ifj;
    private String Ifk;
    private String Ifl;
    private boolean Ifm;
    private int Ifn;
    private int Ifo;
    private int Ifp;
    private View.OnClickListener Ifq = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass11 */

        public final void onClick(View view) {
            AppMethodBeat.i(174518);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.INSTANCE.a(11353, 2, 0);
            f.d(WalletCardElementUI.this, t.fQI().getTrueName());
            a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174518);
        }
    };
    private String cityCode;
    private String countryCode;
    private int fuA;
    private Button gxv;
    private ScrollView gxx;
    private PayInfo mPayInfo = null;
    private Profession[] mProfessions;
    private String mSelectBankName;
    private int mSelectCreCountIndex;
    private String mTrueName;
    private String provinceCode;
    private String yMR;
    private String yMS;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletCardElementUI() {
        AppMethodBeat.i(70798);
        AppMethodBeat.o(70798);
    }

    static /* synthetic */ void C(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(174525);
        walletCardElementUI.fSH();
        AppMethodBeat.o(174525);
    }

    static /* synthetic */ void a(WalletCardElementUI walletCardElementUI, WalletFormView walletFormView, int i2) {
        AppMethodBeat.i(182528);
        walletCardElementUI.a(walletFormView, i2);
        AppMethodBeat.o(182528);
    }

    static /* synthetic */ boolean b(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(70821);
        boolean bqg = walletCardElementUI.bqg();
        AppMethodBeat.o(70821);
        return bqg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70799);
        customfixStatusbar(true);
        super.onCreate(bundle);
        this.HRy = (ElementQuery) getInput().getParcelable("elemt_query");
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        this.HKd = t.fQI().fRu();
        this.Ids = (Bankcard) getInput().getParcelable("key_history_bankcard");
        this.IeN = getInput().getBoolean("key_need_area", false);
        this.IeO = getInput().getBoolean("key_need_profession", false);
        this.IeV = getInput().getBoolean("key_need_country", false);
        this.IeW = getInput().getStringArray("key_country_excludes");
        if (this.HRy != null) {
            aVO(this.HRy.ynT);
        }
        Log.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", Boolean.valueOf(this.IeV));
        if (this.IeN || this.IeO) {
            setMMTitle(R.string.ica);
        } else {
            setMMTitle(R.string.ic_);
        }
        Parcelable[] parcelableArray = getInput().getParcelableArray("key_profession_list");
        if (parcelableArray != null) {
            this.mProfessions = new Profession[parcelableArray.length];
            for (int i2 = 0; i2 < parcelableArray.length; i2++) {
                this.mProfessions[i2] = (Profession) parcelableArray[i2];
            }
        }
        if (this.mPayInfo == null) {
            this.mPayInfo = new PayInfo();
        }
        Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
        this.HSD = new String[100];
        for (int i3 = 0; i3 < this.HSD.length; i3++) {
            this.HSD[i3] = getString(R.string.ibj, new Object[]{Integer.valueOf(i3)});
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) getInput().getParcelable("key_favor_pay_info");
        if (!(this.CwO == null || favorPayInfo == null)) {
            this.HGS = e.INSTANCE.a(this.CwO);
            if (this.HGS != null) {
                this.IeI = this.HGS.aVG(this.HGS.aVL(favorPayInfo.HXI));
            } else {
                Log.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        initView();
        this.gxx.pageScroll(33);
        com.tencent.mm.plugin.wallet_core.utils.f.b(this, getInput(), 3);
        EventCenter.instance.addListener(this.HJH);
        AppMethodBeat.o(70799);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70800);
        this.Iea = (TextView) findViewById(R.id.jev);
        this.IeH = (WalletFormView) findViewById(R.id.jet);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.IeH);
        this.Ieb = (TextView) findViewById(R.id.jeu);
        this.HJZ = (TextView) findViewById(R.id.jex);
        this.Idq = (WalletFormView) findViewById(R.id.fte);
        this.Iem = (WalletFormView) findViewById(R.id.d9b);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Idq);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Iem);
        this.Ien = (WalletFormView) findViewById(R.id.jff);
        this.HJY = (WalletFormView) findViewById(R.id.duk);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.HJY);
        this.HKa = (TextView) findViewById(R.id.jew);
        this.Iec = (TextView) findViewById(R.id.jem);
        this.Iej = (WalletFormView) findViewById(R.id.jey);
        this.IeY = (WalletFormView) findViewById(R.id.jf2);
        this.Ied = (TextView) findViewById(R.id.jen);
        this.Ieh = (TextView) findViewById(R.id.jer);
        this.Iee = (TextView) findViewById(R.id.jep);
        this.Iel = (WalletFormView) findViewById(R.id.bk5);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Iel);
        this.Iek = (WalletFormView) findViewById(R.id.bkj);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.Iek);
        this.Ief = (TextView) findViewById(R.id.jeo);
        this.EIm = (TextView) findViewById(R.id.jek);
        this.Iey = (WalletFormView) findViewById(R.id.d5d);
        this.Iez = (WalletFormView) findViewById(R.id.e7w);
        this.IeA = (WalletFormView) findViewById(R.id.uj);
        this.IeB = (WalletFormView) findViewById(R.id.hb);
        this.IeC = (WalletFormView) findViewById(R.id.gaa);
        this.IeD = (WalletFormView) findViewById(R.id.gf_);
        this.IeE = (WalletFormView) findViewById(R.id.byt);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.IeE);
        this.Ieg = (TextView) findViewById(R.id.jej);
        this.IeK = (CheckBox) findViewById(R.id.id);
        this.IeL = (CheckBox) findViewById(R.id.ia);
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxx = (ScrollView) findViewById(R.id.ji9);
        this.Iep = (WalletFormView) findViewById(R.id.ghg);
        this.Ieq = (WalletFormView) findViewById(R.id.gh9);
        this.Ier = (WalletFormView) findViewById(R.id.gh8);
        this.Ies = (WalletFormView) findViewById(R.id.ghh);
        this.Iet = (WalletFormView) findViewById(R.id.jfc);
        this.Ieu = (WalletFormView) findViewById(R.id.jfd);
        this.Iev = (WalletFormView) findViewById(R.id.jfe);
        this.Iew = (WalletFormView) findViewById(R.id.gh_);
        this.Iex = (WalletFormView) findViewById(R.id.gha);
        this.Iei = (TextView) findViewById(R.id.jf0);
        this.IeF = (WalletPhoneInputView) findViewById(R.id.fh1);
        this.Ieo = this.IeF.getPhoneNumberEt();
        this.Idq.setOnInputValidChangeListener(this);
        this.Iem.setOnInputValidChangeListener(this);
        this.IeH.setOnInputValidChangeListener(this);
        this.Ien.setOnInputValidChangeListener(this);
        this.HJY.setOnInputValidChangeListener(this);
        this.Ieo.setOnInputValidChangeListener(new WalletFormView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(70773);
                if (!z) {
                    WalletCardElementUI.this.Ids = null;
                    WalletCardElementUI.this.getInput().putParcelable("key_history_bankcard", null);
                }
                WalletCardElementUI.b(WalletCardElementUI.this);
                AppMethodBeat.o(70773);
            }
        });
        this.Iel.setOnInputValidChangeListener(this);
        this.Iek.setOnInputValidChangeListener(this);
        this.Iey.setOnInputValidChangeListener(this);
        this.Iez.setOnInputValidChangeListener(this);
        this.IeA.setOnInputValidChangeListener(this);
        this.IeB.setOnInputValidChangeListener(this);
        this.IeC.setOnInputValidChangeListener(this);
        this.IeD.setOnInputValidChangeListener(this);
        this.IeE.setOnInputValidChangeListener(this);
        this.Iep.setOnInputValidChangeListener(this);
        this.Ieq.setOnInputValidChangeListener(this);
        this.Idq.setOnEditorActionListener(this);
        this.Iem.setOnEditorActionListener(this);
        this.IeH.setOnEditorActionListener(this);
        this.Ien.setOnEditorActionListener(this);
        this.HJY.setOnEditorActionListener(this);
        this.Ieo.setOnEditorActionListener(this);
        this.Iel.setOnEditorActionListener(this);
        this.Iek.setOnEditorActionListener(this);
        this.Iey.setOnEditorActionListener(this);
        this.Iez.setOnEditorActionListener(this);
        this.IeA.setOnEditorActionListener(this);
        this.IeB.setOnEditorActionListener(this);
        this.IeC.setOnEditorActionListener(this);
        this.IeD.setOnEditorActionListener(this);
        this.IeE.setOnEditorActionListener(this);
        this.Ieq.setOnEditorActionListener(this);
        this.Iep.setOnEditorActionListener(this);
        this.Iej.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(70786);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardElementUI.this.getInput().getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletCardElementUI.this.getInput().getInt("key_bind_scene", -1));
                Util.isNullOrNil(WalletCardElementUI.this.Iej.getText());
                WalletCardElementUI.this.hideTenpayKB();
                com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(WalletCardElementUI.this);
                if (by != null) {
                    by.a(WalletCardElementUI.this, WalletBankCardSelectUI.class, bundle, 1);
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70786);
            }
        });
        this.IeY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(70788);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList arrayList = new ArrayList();
                arrayList.add(WalletCardElementUI.this.getString(R.string.ic4));
                arrayList.add(WalletCardElementUI.this.getString(R.string.ibk));
                if (WalletCardElementUI.this.IeZ.size() == 1) {
                    ElementQuery elementQuery = (ElementQuery) WalletCardElementUI.this.IeZ.get(0);
                    if (elementQuery.fQr()) {
                        arrayList.remove(1);
                    } else if (elementQuery.fQd()) {
                        arrayList.remove(0);
                    }
                }
                final c cVar = new c(WalletCardElementUI.this.getContext(), arrayList);
                cVar.app(WalletCardElementUI.this.Ifa);
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass14.AnonymousClass1 */

                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
                        r5.Ift.Ifr.HRy = r0;
                        com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.g(r5.Ift.Ifr);
                     */
                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onResult(boolean r6, java.lang.Object r7, java.lang.Object r8) {
                        /*
                        // Method dump skipped, instructions count: 119
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass14.AnonymousClass1.onResult(boolean, java.lang.Object, java.lang.Object):void");
                    }
                };
                cVar.show();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70788);
            }
        });
        this.Ien.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(70789);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardElementUI.h(WalletCardElementUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70789);
            }
        });
        this.Iet.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(70791);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final c cVar = new c(WalletCardElementUI.this.getContext(), WalletCardElementUI.this.HSD);
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass16.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    public final void onResult(boolean z, Object obj, Object obj2) {
                        AppMethodBeat.i(70790);
                        if (z) {
                            WalletCardElementUI.this.Iet.setText((String) obj);
                            WalletCardElementUI.this.mSelectCreCountIndex = cVar.hci();
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        cVar.hide();
                        AppMethodBeat.o(70790);
                    }
                };
                cVar.app(WalletCardElementUI.this.mSelectCreCountIndex);
                cVar.show();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70791);
            }
        });
        this.Ieu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(70793);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final com.tencent.mm.ui.widget.picker.b bVar2 = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
                bVar2.QSU = new b.a() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass17.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(70792);
                        if (z) {
                            if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
                                AppMethodBeat.o(70792);
                                return;
                            }
                            WalletCardElementUI.this.Ieu.setText(String.format("%04d%02d%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
                            WalletCardElementUI.this.Ife = i2;
                            WalletCardElementUI.this.Iff = i3;
                            WalletCardElementUI.this.Ifg = i4;
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        bVar2.hide();
                        AppMethodBeat.o(70792);
                    }
                };
                Calendar instance = Calendar.getInstance();
                int i2 = instance.get(1);
                int i3 = instance.get(2) + 1;
                int i4 = instance.get(5);
                bVar2.aZ(i2, i3, i4);
                String obj = WalletCardElementUI.this.Ieu.getContentEt().getText().toString();
                if (WalletCardElementUI.this.Ife > 0 && WalletCardElementUI.this.Iff > 0 && WalletCardElementUI.this.Ifg > 0) {
                    bVar2.aX(WalletCardElementUI.this.Ife, WalletCardElementUI.this.Iff, WalletCardElementUI.this.Ifg);
                } else if (!Util.isNullOrNil(obj) && obj.length() == 8) {
                    WalletCardElementUI.this.Ife = Util.getInt(obj.substring(0, 4), i2);
                    WalletCardElementUI.this.Iff = Util.getInt(obj.substring(4, 6), i3);
                    WalletCardElementUI.this.Ifg = Util.getInt(obj.substring(6, 8), i4);
                    bVar2.aX(WalletCardElementUI.this.Ife, WalletCardElementUI.this.Iff, WalletCardElementUI.this.Ifg);
                }
                bVar2.show();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70793);
            }
        });
        this.Iev.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(70794);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final com.tencent.mm.ui.widget.picker.b bVar2 = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
                bVar2.QSU = new b.a() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass18.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(174521);
                        if (z) {
                            if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
                                AppMethodBeat.o(174521);
                                return;
                            }
                            if (i2 == 1) {
                                WalletCardElementUI.this.Iev.setText(WalletCardElementUI.this.getString(R.string.ixm));
                                WalletCardElementUI.this.Ifb = 9999;
                                WalletCardElementUI.this.Ifc = 12;
                                WalletCardElementUI.this.Ifd = 31;
                            } else {
                                WalletCardElementUI.this.Iev.setText(String.format("%04d%02d%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
                                WalletCardElementUI.this.Ifb = i2;
                                WalletCardElementUI.this.Ifc = i3;
                                WalletCardElementUI.this.Ifd = i4;
                            }
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        bVar2.hide();
                        AppMethodBeat.o(174521);
                    }
                };
                Calendar instance = Calendar.getInstance();
                int i2 = instance.get(1);
                int i3 = instance.get(2) + 1;
                int i4 = instance.get(5);
                bVar2.aY(i2, i3, i4);
                bVar2.aZ(i2 + 200, 12, 31);
                bVar2.setLongTermYear(true);
                String obj = WalletCardElementUI.this.Iev.getContentEt().getText().toString();
                if (WalletCardElementUI.this.Ifb <= 0 || WalletCardElementUI.this.Ifc <= 0 || WalletCardElementUI.this.Ifd <= 0) {
                    if (!Util.isNullOrNil(obj) && obj.length() == 8) {
                        WalletCardElementUI.this.Ifb = Util.getInt(obj.substring(0, 4), i2);
                        WalletCardElementUI.this.Ifc = Util.getInt(obj.substring(4, 6), i3);
                        WalletCardElementUI.this.Ifd = Util.getInt(obj.substring(6, 8), i4);
                    } else if (obj.equals(WalletCardElementUI.this.getString(R.string.ixm))) {
                        WalletCardElementUI.this.Ifb = 9999;
                        WalletCardElementUI.this.Ifc = 12;
                        WalletCardElementUI.this.Ifd = 31;
                    }
                }
                if (WalletCardElementUI.this.Ifb == 9999) {
                    bVar2.aX(1, 1, 1);
                } else {
                    bVar2.aX(WalletCardElementUI.this.Ifb, WalletCardElementUI.this.Ifc, WalletCardElementUI.this.Ifd);
                }
                bVar2.show();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70794);
            }
        });
        this.Ies.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(70795);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final c cVar = new c(WalletCardElementUI.this.getContext(), WalletCardElementUI.this.getResources().getStringArray(R.array.b1));
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass19.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    public final void onResult(boolean z, Object obj, Object obj2) {
                        AppMethodBeat.i(174522);
                        if (z) {
                            WalletCardElementUI.this.Ies.setText((String) obj);
                            if (((String) obj).equalsIgnoreCase(WalletCardElementUI.this.getString(R.string.gxi))) {
                                WalletCardElementUI.this.Ifn = 0;
                            } else {
                                WalletCardElementUI.this.Ifn = 1;
                            }
                            cVar.app(WalletCardElementUI.this.Ifn);
                        }
                        cVar.hide();
                        AppMethodBeat.o(174522);
                    }
                };
                cVar.show();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70795);
            }
        });
        this.Ieq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(70797);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("GetAddress", true);
                intent.putExtra("ShowSelectedLocation", false);
                if (!Bankcard.aeI(WalletCardElementUI.this.HRy.HQg)) {
                    intent.putExtra("IsRealNameVerifyScene", true);
                    intent.putExtra("IsNeedShowSearchBar", true);
                }
                if (WalletCardElementUI.this.IeW != null && WalletCardElementUI.this.IeW.length > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(Arrays.asList(WalletCardElementUI.this.IeW));
                    arrayList.remove(WeChatBrands.AppInfo.LANG_CN);
                    arrayList.remove(WeChatBrands.AppInfo.LANG_TW);
                    arrayList.remove(WeChatBrands.AppInfo.LANG_HK);
                    arrayList.remove("MO");
                    intent.putStringArrayListExtra("BlockedCountries", arrayList);
                }
                com.tencent.mm.br.c.c(WalletCardElementUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", intent, 4);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70797);
            }
        });
        this.Iep.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70774);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(WalletCardElementUI.this.getContext(), WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", WalletCardElementUI.this.mProfessions);
                WalletCardElementUI.this.startActivityForResult(intent, 5);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70774);
            }
        });
        this.Iew.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(174512);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final com.tencent.mm.ui.widget.picker.b bVar2 = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.getContext());
                bVar2.QSU = new b.a() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(174511);
                        if (z) {
                            WalletCardElementUI.this.Iew.setText(String.format("%04d%02d%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
                            WalletCardElementUI.this.Ifh = i2;
                            WalletCardElementUI.this.Ifi = i3;
                            WalletCardElementUI.this.Ifj = i4;
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        bVar2.hide();
                        AppMethodBeat.o(174511);
                    }
                };
                if (WalletCardElementUI.this.Ifh > 0 && WalletCardElementUI.this.Ifi > 0 && WalletCardElementUI.this.Ifj > 0) {
                    bVar2.aX(WalletCardElementUI.this.Ifh, WalletCardElementUI.this.Ifi, WalletCardElementUI.this.Ifj);
                }
                bVar2.show();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174512);
            }
        });
        this.Iex.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(70776);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClassName(WalletCardElementUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
                intent.putExtra("exclude_countries_iso", WalletCardElementUI.this.IeW);
                intent.putExtra("CountryCodeUI_isShowCountryCode", false);
                intent.putExtra("ui_title", WalletCardElementUI.this.getString(R.string.isb));
                WalletCardElementUI.this.startActivityForResult(intent, 6);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70776);
            }
        });
        this.IeK.setChecked(true);
        this.IeK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass5 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(174513);
                WalletCardElementUI.b(WalletCardElementUI.this);
                AppMethodBeat.o(174513);
            }
        });
        findViewById(R.id.i9).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(70778);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.b(WalletCardElementUI.this, WalletCardElementUI.this.HRy.dDj, WalletCardElementUI.this.HRy.ynT, false, WalletCardElementUI.this.HRy.HXD);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70778);
            }
        });
        this.IeA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(174514);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (Bankcard.aeI(WalletCardElementUI.this.HRy.HQg)) {
                    putExtra.putExtra("IsAutoPosition", false);
                } else {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                WalletCardElementUI.this.startActivityForResult(putExtra, 2);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174514);
            }
        });
        this.Ier.setOnInputValidChangeListener(this);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(174515);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardElementUI.C(WalletCardElementUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardElementUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174515);
            }
        });
        setEditFocusListener(this.IeH, 0, false, false, true);
        setEditFocusListener(this.HJY, 1, false, false, true);
        setEditFocusListener(this.Ieo, 0, false, false, true);
        if (this.HRy != null && !Util.isNullOrNil(this.HRy.HXr)) {
            com.tencent.mm.ui.base.h.a((Context) this, this.HRy.HXr, (String) null, true, (DialogInterface.OnClickListener) null);
            this.HRy = null;
        } else if (getInput().getInt("key_bind_scene", -1) == 5 && !this.HRy.HXH) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ivb), (String) null, true, (DialogInterface.OnClickListener) null);
            this.HRy.ynT = null;
        }
        is(true);
        bqg();
        com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(this);
        if (by != null && by.hgK()) {
            Orders orders = (Orders) getInput().getParcelable("key_orders");
            if (orders == null || orders.HYN != 1) {
                this.IeJ = false;
            } else {
                this.IeJ = true;
                this.Idq.setText(f.bps(orders.HTZ));
                this.Idq.setEnabled(false);
                this.Idq.setFocusable(false);
                this.HKd = orders.HYO;
                this.Ien.setText(t.fQQ().av(this, this.HKd));
                this.Ien.setEnabled(false);
                this.HJY.setText(orders.HXh);
                this.HJY.setInputEnable(false);
                this.HJY.setFocusable(false);
                this.HJZ.setText(R.string.i90);
                AppMethodBeat.o(70800);
                return;
            }
        }
        AppMethodBeat.o(70800);
    }

    private void fSF() {
        AppMethodBeat.i(70801);
        if (fSK()) {
            String string = getInput().getString("realname_verify_process_get_wording_cache");
            try {
                if (!Util.isNullOrNil(string)) {
                    this.HSB.addAll(((btr) new btr().parseFrom(string.getBytes(org.apache.commons.a.a.ISO_8859_1))).MaA);
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WalletCardElmentUI", e2, "", new Object[0]);
            }
            RealNameBundle realNameBundle = (RealNameBundle) getInput().getParcelable("realname_verify_process_bundle");
            if (realNameBundle != null) {
                this.mTrueName = realNameBundle.HTZ;
                this.Ifl = realNameBundle.HUv;
                this.fuA = realNameBundle.fuA;
                if (!(this.HRy == null || this.HRy.fQs() == null || !this.HRy.fQs().contains(Integer.valueOf(realNameBundle.HUc)))) {
                    Log.i("MicroMsg.WalletCardElmentUI", "set cretype: %s", Integer.valueOf(realNameBundle.HUc), this.HRy.fQs());
                    this.HKd = realNameBundle.HUc;
                    this.Ien.setText(realNameBundle.HUd);
                    this.HJY.setText(realNameBundle.HUa);
                    a(this.HJY, this.HKd);
                    if (realNameBundle.HUl == 9999) {
                        this.Iev.setText(getString(R.string.ixm));
                        this.Ifb = 9999;
                        this.Ifc = 12;
                        this.Ifd = 31;
                    } else {
                        this.Iev.setText(String.format("%04d%02d%02d", Integer.valueOf(realNameBundle.HUl), Integer.valueOf(realNameBundle.HUm), Integer.valueOf(realNameBundle.HUn)));
                    }
                    this.Ieu.setText(String.format("%04d%02d%02d", Integer.valueOf(realNameBundle.HUx), Integer.valueOf(realNameBundle.HUy), Integer.valueOf(realNameBundle.HUz)));
                    this.mSelectCreCountIndex = realNameBundle.HUj;
                    this.Iet.setText(this.HSD[this.mSelectCreCountIndex]);
                }
                this.Idq.setText(realNameBundle.HTZ);
                this.countryCode = realNameBundle.HUf;
                this.provinceCode = realNameBundle.HUg;
                this.cityCode = realNameBundle.HUh;
                this.Ieq.setText(realNameBundle.HUi);
                this.Ier.setText(realNameBundle.HUv);
                this.IeX = realNameBundle.HUs;
                this.Iex.setText(realNameBundle.HUt);
                this.HRz = realNameBundle.HUe;
                if (this.HRz != null) {
                    this.Iep.setText(this.HRz.HTX);
                }
                this.Ifn = realNameBundle.fuA - 1;
                if (this.Ifn < 0) {
                    this.Ifn = 0;
                }
                this.Ies.setText(getString(realNameBundle.fuA == 1 ? R.string.gxi : R.string.gxh));
                this.Ifh = realNameBundle.HUp;
                this.Ifi = realNameBundle.HUq;
                this.Ifj = realNameBundle.HUr;
                if (this.Ifh > 0 && this.Ifi > 0 && this.Ifj > 0) {
                    this.Iew.setText(String.format("%04d%02d%02d", Integer.valueOf(this.Ifh), Integer.valueOf(this.Ifi), Integer.valueOf(this.Ifj)));
                }
            }
        }
        AppMethodBeat.o(70801);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fSG() {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.fSG():void");
    }

    private void is(boolean z) {
        AppMethodBeat.i(70803);
        if (this.HRy == null) {
            this.HRy = new ElementQuery();
        }
        Log.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", this.HRy.ynT, this.HRy.dDj);
        fSG();
        fSI();
        com.tencent.mm.wallet_core.a.by(this);
        Bankcard bankcard = (Bankcard) getInput().getParcelable("key_bankcard");
        if (!fSJ() || bankcard == null) {
            if (!Util.isNullOrNil(this.HRy.ynT)) {
                this.Iej.setText(this.HRy.ynT);
                if (this.HRy.fQd()) {
                    this.IeY.setVisibility(0);
                    this.IeY.setText(getString(R.string.ibk));
                } else if (this.HRy.fQr()) {
                    this.IeY.setVisibility(0);
                    this.IeY.setText(getString(R.string.ic4));
                }
            }
            a(new boolean[]{false}, new WalletFormView[]{this.IeH}, this.Iea, this.Ieb, true);
            a(new boolean[]{true}, new WalletFormView[]{this.Iej}, this.Iec, this.Ied, true);
            this.IeH.setOnInfoIvClickListener(this.Ifq);
            if (t.fQI().fRs().fQZ()) {
                this.IeH.getInfoIv().setImageResource(R.raw.wallet_scan_camera);
                this.IeH.getInfoIv().setVisibility(0);
            } else {
                this.IeH.getInfoIv().setVisibility(4);
            }
        } else {
            this.IeH.setHint(getString(R.string.i_4, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.IeH}, this.Iea, this.Ieb);
            a(new boolean[]{false}, new WalletFormView[]{this.Iej}, this.Iec, this.Ied);
        }
        if (z) {
            fSF();
        }
        this.IeP = false;
        this.IeQ = false;
        this.IeS = false;
        this.IeT = false;
        if (fSK()) {
            for (djv djv : this.HSB) {
                if (djv.MNM.key == this.HKd) {
                    this.IeP = djv.MNQ;
                    this.IeQ = djv.MNP;
                    this.IeR = djv.MNT;
                    this.IeS = djv.MNR;
                    this.Ifm = djv.MNV;
                    this.IeO = djv.MNN;
                    this.IeN = djv.MNO;
                    this.IeU = djv.MNS;
                    this.IeT = true;
                }
            }
        } else if (this.HRy.HXG != null && !this.HRy.HXG.isEmpty()) {
            Log.i("MicroMsg.WalletCardElmentUI", "identity type： %s", Integer.valueOf(this.HKd));
            Iterator<CreTypeRuleInfo> it = this.HRy.HXG.iterator();
            while (it.hasNext()) {
                CreTypeRuleInfo next = it.next();
                if (next.HWK == this.HKd) {
                    if (next.HWL.HWG == 1) {
                        Log.i("MicroMsg.WalletCardElmentUI", "need show cre count");
                        this.IeP = true;
                    }
                    if (next.HWL.HWI == 1) {
                        Log.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
                        this.IeQ = true;
                    }
                    if (next.HWL.HWH == 1) {
                        Log.i("MicroMsg.WalletCardElmentUI", "need show birthday");
                        this.IeS = true;
                    }
                    if (next.HWL.HWJ == 1) {
                        Log.i("MicroMsg.WalletCardElmentUI", "need show cre type");
                        if (t.fQI().fRu() > 0) {
                            Log.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
                            this.IeT = true;
                        }
                    }
                }
            }
            if (this.HKd != 2 || !this.IeV) {
                this.IeU = false;
            } else {
                this.IeU = true;
            }
        } else if (this.HKd != 2 || !this.IeV) {
            this.IeU = false;
        } else {
            this.IeU = true;
        }
        if (!this.IeQ) {
            this.Ifb = 0;
            this.Ifc = 0;
            this.Ifd = 0;
        }
        if (!this.IeS) {
            this.Ifh = 0;
            this.Ifi = 0;
            this.Ifj = 0;
        }
        if (!this.IeP) {
            this.mSelectCreCountIndex = 0;
        }
        this.Iem.setVisibility(8);
        if (Bankcard.aeI(this.HRy.HQg)) {
            a(new boolean[]{false, false, false, false, false, false}, new WalletFormView[]{this.Idq, this.Ien, this.HJY, this.Iet, this.Ieu, this.Iev}, this.HJZ, this.HKa);
            this.Ieo.setVisibility(8);
            yl(true);
            a(new boolean[]{false, false, false, this.IeS, this.IeU, this.Ifm}, new WalletFormView[]{this.Ieq, this.Ier, this.Iep, this.Iew, this.Iex, this.Ies}, this.Iei, (TextView) null);
        } else {
            boolean z2 = this.HRy.fQs() != null && this.HRy.fQs().size() > 0;
            if (fSJ() || t.fQI().fRm()) {
                String trueName = t.fQI().getTrueName();
                if (Util.isNullOrNil(trueName) && getProcess() != null) {
                    trueName = getProcess().dQL.getString("key_true_name");
                }
                if (!Util.isNullOrNil(trueName)) {
                    String string = getString(R.string.iag, new Object[]{f.bps(trueName)});
                    this.Idq.setHint(string);
                    this.Iem.setHint(string);
                } else {
                    String string2 = getString(R.string.iaf);
                    this.Idq.setHint(string2);
                    this.Iem.setHint(string2);
                }
                if (!fSJ() || Util.isNullOrNil(getInput().getString("key_identity")) || getInput().getInt("key_id_type", -1) == -1 || Util.isNullOrNil(getInput().getString("key_true_name"))) {
                    boolean[] zArr = new boolean[6];
                    zArr[0] = true;
                    zArr[1] = this.IeT || z2;
                    zArr[2] = true;
                    zArr[3] = this.IeP;
                    zArr[4] = this.IeR;
                    zArr[5] = this.IeQ;
                    a(zArr, new WalletFormView[]{this.Idq, this.Ien, this.HJY, this.Iet, this.Ieu, this.Iev}, this.HJZ, this.HKa);
                } else {
                    Log.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
                    a(new boolean[]{false, false, false, this.IeP, this.IeR, this.IeQ}, new WalletFormView[]{this.Idq, this.Ien, this.HJY, this.Iet, this.Ieu, this.Iev}, this.HJZ, this.HKa);
                    this.mTrueName = getInput().getString("key_true_name");
                    Log.i("MicroMsg.WalletCardElmentUI", "name is " + this.mTrueName);
                }
                this.Ieo.setVisibility(0);
            } else {
                boolean[] zArr2 = new boolean[6];
                zArr2[0] = this.HRy.HXd;
                zArr2[1] = this.IeT || (z2 && this.HRy.HXe);
                zArr2[2] = this.HRy.HXe;
                zArr2[3] = this.IeP;
                zArr2[4] = this.IeR;
                zArr2[5] = this.IeQ;
                a(zArr2, new WalletFormView[]{this.Idq, this.Ien, this.HJY, this.Iet, this.Ieu, this.Iev}, this.HJZ, this.HKa);
                this.Ieo.setVisibility(0);
                Log.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.HRy.HXd + " canModifyIdentity:" + this.HRy.HXe);
            }
            if (this.Ids != null) {
                if (!Util.isNullOrNil(this.Ids.field_mobile)) {
                    d(this.Ieo, this.Ids.field_mobile);
                }
                if (!Util.isNullOrNil(this.Ids.HUS)) {
                    d(this.Iel, this.Ids.HUS);
                }
                if (!Util.isNullOrNil(this.Ids.HVz)) {
                    d(this.Iek, this.Ids.HVz);
                }
            }
            if (this.HRy.HXd) {
                this.HKa.setText("");
            } else {
                this.HKa.setText(getString(R.string.i__));
            }
            if (!Util.isNullOrNil(this.HRy.HXh)) {
                this.HJY.setText(this.HRy.HXh);
            }
            if (t.fQI().fRu() > 0) {
                Log.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", Integer.valueOf(t.fQI().fRu()));
                this.Ien.setClickable(false);
                this.Ien.setText(t.fQQ().hM(this));
                this.Ien.setInputEnable(false);
                a(this.HJY, this.HKd);
            } else {
                int size = this.HRy.fQs() != null ? this.HRy.fQs().size() : 0;
                Log.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", Integer.valueOf(size));
                if (size <= 1) {
                    this.Ien.setClickable(false);
                    this.Ien.setInputEnable(false);
                    this.HJY.setInputEnable(true);
                } else {
                    this.Ien.setClickable(true);
                    this.Ien.setInputEnable(true);
                    this.HJY.setInputEnable(true);
                }
                List<Integer> fQs = this.HRy.fQs();
                if (fQs == null || !fQs.contains(Integer.valueOf(this.HKd))) {
                    this.HKd = 1;
                }
                if (!t.fQQ().av(this, this.HKd).equals(this.Ifk)) {
                    h.INSTANCE.a(16816, Integer.valueOf(this.HKd));
                }
                this.Ien.setText(t.fQQ().av(this, this.HKd));
            }
            yl(false);
            a(new boolean[]{this.Ifm, this.IeN, this.IeN, this.IeO, this.IeS, this.IeU}, new WalletFormView[]{this.Ies, this.Ieq, this.Ier, this.Iep, this.Iew, this.Iex}, this.Iei, (TextView) null);
        }
        a(new boolean[]{this.HRy.HXf, this.HRy.HXg}, new WalletFormView[]{this.Iel, this.Iek}, this.Iee, this.Ief);
        if (this.Iej.getVisibility() == 0) {
            switch (this.HRy.HXk) {
                case 1:
                    this.Ied.setVisibility(8);
                    break;
                case 2:
                    this.Ied.setVisibility(8);
                    break;
                case 3:
                    this.Ied.setText(R.string.i97);
                    this.Ied.setVisibility(0);
                    break;
                case 4:
                    this.Ied.setVisibility(8);
                    break;
                default:
                    this.Ied.setVisibility(8);
                    break;
            }
            this.Ied.setTextColor(getResources().getColor(R.color.a2t));
        } else {
            this.Ied.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.HRy.HXE) && this.Ied.getVisibility() != 0) {
            Log.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
            this.Ied.setText(this.HRy.HXE);
            this.Ied.setVisibility(0);
        }
        if (Util.isNullOrNil(this.HRy.HXp) || !ab.IS(this.HRy.HXp) || fSJ()) {
            this.IeL.setVisibility(8);
            AppMethodBeat.o(70803);
            return;
        }
        this.IeL.setText(this.HRy.HXq);
        this.IeL.setVisibility(0);
        AppMethodBeat.o(70803);
    }

    private static void d(WalletFormView walletFormView, String str) {
        AppMethodBeat.i(70804);
        if (!Util.isNullOrNil(str)) {
            KeyListener keyListener = walletFormView.getKeyListener();
            walletFormView.setKeyListener(null);
            walletFormView.setEnabled(false);
            walletFormView.setClickable(false);
            walletFormView.setText(str);
            walletFormView.setKeyListener(keyListener);
            walletFormView.setVisibility(0);
            AppMethodBeat.o(70804);
            return;
        }
        walletFormView.setVisibility(8);
        AppMethodBeat.o(70804);
    }

    private void yl(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        AppMethodBeat.i(70805);
        if (z) {
            this.EIm.setVisibility(this.HRy.HXs ? 0 : 8);
            WalletFormView walletFormView = this.Iey;
            if (this.HRy.HXs) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.Iez;
            if (this.HRy.HXt) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            walletFormView2.setVisibility(i3);
            WalletFormView walletFormView3 = this.IeA;
            if (this.HRy.HXu) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            walletFormView3.setVisibility(i4);
            WalletFormView walletFormView4 = this.IeB;
            if (this.HRy.HXx) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            walletFormView4.setVisibility(i5);
            WalletFormView walletFormView5 = this.IeC;
            if (this.HRy.HXz) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            walletFormView5.setVisibility(i6);
            WalletFormView walletFormView6 = this.IeD;
            if (this.HRy.HXy) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            walletFormView6.setVisibility(i7);
            WalletFormView walletFormView7 = this.IeE;
            if (!this.HRy.HXA) {
                i8 = 8;
            }
            walletFormView7.setVisibility(i8);
            this.Ieg.setVisibility(4);
            AppMethodBeat.o(70805);
            return;
        }
        this.EIm.setVisibility(8);
        this.Iey.setVisibility(8);
        this.Iez.setVisibility(8);
        this.IeA.setVisibility(8);
        this.IeB.setVisibility(8);
        this.IeC.setVisibility(8);
        this.IeD.setVisibility(8);
        this.IeE.setVisibility(8);
        this.Ieg.setVisibility(8);
        AppMethodBeat.o(70805);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        AppMethodBeat.i(70806);
        int length = zArr.length;
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                z2 = true;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
                walletFormViewArr[i2].eIj();
            }
        }
        if (z2) {
            textView.setVisibility(0);
            if (textView2 != null) {
                if (z) {
                    textView2.setVisibility(8);
                    AppMethodBeat.o(70806);
                    return;
                }
                textView2.setVisibility(4);
                AppMethodBeat.o(70806);
                return;
            }
        } else {
            textView.setVisibility(8);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        AppMethodBeat.o(70806);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        AppMethodBeat.i(70807);
        a(zArr, walletFormViewArr, textView, textView2, false);
        AppMethodBeat.o(70807);
    }

    private void fSH() {
        String str;
        String string;
        AppMethodBeat.i(70808);
        if (bqg()) {
            com.tencent.mm.plugin.wallet_core.utils.f.fUi();
            if (!Util.isNullOrNil(this.HRy.HXp)) {
                getInput().putBoolean("key_is_follow_bank_username", this.IeL.getVisibility() == 0 && this.IeL.isChecked());
                getInput().putString("key_bank_username", this.HRy.HXp);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) getInput().getParcelable("key_favor_pay_info");
            if (!(this.HRy == null || favorPayInfo == null || this.HGS == null || this.IeI == null)) {
                if (this.IeI.containsKey(this.HRy.dDj)) {
                    favorPayInfo.HXI = this.IeI.get(this.HRy.dDj).IcR.HEJ;
                } else {
                    favorPayInfo.HXI = this.HGS.cG(favorPayInfo.HXI, false);
                }
                getInput().putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.HFI = new Authen();
            if (this.Ids != null) {
                this.HFI.ANo = this.Ids.HVA;
                this.HFI.xxN = this.Ids.field_bankcardTail;
            }
            String string2 = getInput().getString("key_card_id");
            if (this.IeH.getVisibility() == 0) {
                str = this.IeH.getText();
            } else {
                str = string2;
            }
            this.HFI.BDB = (PayInfo) getInput().getParcelable("key_pay_info");
            this.HFI.HUR = str;
            this.HFI.dDj = this.HRy.dDj;
            this.HFI.HUQ = this.HKd;
            this.HFI.HUO = getInput().getString("key_pwd1");
            if (!Util.isNullOrNil(this.Iel.getText())) {
                this.HFI.HUS = this.Iel.getText();
            }
            this.HFI.HQc = this.Ieo.getText();
            this.HFI.HUV = this.Iey.getText();
            this.HFI.HUW = this.Iez.getText();
            this.HFI.country = this.IeM;
            this.HFI.fuJ = this.yMR;
            this.HFI.fuK = this.yMS;
            this.HFI.iUO = this.IeB.getText();
            this.HFI.ynV = this.IeC.getText();
            this.HFI.ksV = this.IeD.getText();
            this.HFI.fuD = this.IeE.getText();
            String bpt = f.bpt(this.HFI.HQc);
            getInput().putString("key_mobile", bpt);
            getInput().putBoolean("key_is_oversea", this.HRy.HQg == 2);
            this.HFI.HUP = this.HJY.getText();
            this.HFI.HTZ = this.Idq.getText();
            this.HFI.HUT = this.Iek.getText();
            FavorPayInfo favorPayInfo2 = (FavorPayInfo) getInput().getParcelable("key_favor_pay_info");
            if (favorPayInfo2 != null) {
                this.HFI.HUX = favorPayInfo2.HXL;
                this.HFI.HUY = favorPayInfo2.HXI;
            }
            this.HFI.HVd = "+" + this.IeF.getCountryCode();
            this.HFI.HUj = this.mSelectCreCountIndex;
            if (this.Ifb == 9999) {
                Log.i("MicroMsg.WalletCardElmentUI", "is long term");
                this.HFI.HUk = new TenpaySecureEncrypt().desedeEncode(String.format("%04d%02d%02d", Integer.valueOf(this.Ifb), Integer.valueOf(this.Ifc), Integer.valueOf(this.Ifd)), f.hhV());
            } else {
                this.HFI.HUk = this.Iev.getText();
            }
            Log.d("MicroMsg.WalletCardElmentUI", "expire date: %s", this.Iev.getText());
            this.HFI.HUo = this.Iew.getText();
            Log.d("MicroMsg.WalletCardElmentUI", "birth date: %s", this.Iew.getText());
            RealNameBundle realNameBundle = (RealNameBundle) getInput().getParcelable("realname_verify_process_bundle");
            if (realNameBundle == null) {
                realNameBundle = new RealNameBundle();
            }
            realNameBundle.HTZ = this.Idq.getText();
            realNameBundle.fuA = this.Ifn + 1;
            realNameBundle.HUf = this.countryCode;
            realNameBundle.HUg = this.provinceCode;
            realNameBundle.HUh = this.cityCode;
            realNameBundle.HUv = this.Ier.getText();
            realNameBundle.HUe = this.HRz;
            realNameBundle.HUs = this.IeX;
            realNameBundle.HUo = this.Iew.getText();
            realNameBundle.HUc = this.HKd;
            realNameBundle.HUd = this.Ien.getText();
            realNameBundle.HUa = "";
            realNameBundle.HUb = this.HJY.getText();
            realNameBundle.HUw = this.Ieu.getText();
            realNameBundle.HUk = this.Iev.getText();
            realNameBundle.HUj = this.mSelectCreCountIndex;
            getInput().putParcelable("realname_verify_process_bundle", realNameBundle);
            Log.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", Integer.valueOf(this.HFI.HUj), this.HFI.HUk, this.HFI.HUo);
            if (fSJ() && !Util.isNullOrNil(getInput().getString("key_identity")) && getInput().getInt("key_id_type", -1) != -1 && !Util.isNullOrNil(getInput().getString("key_true_name"))) {
                Log.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
                this.HFI.HUP = getInput().getString("key_identity");
                this.HFI.HUQ = getInput().getInt("key_id_type", -1);
                this.HFI.HTZ = this.mTrueName;
                Log.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.HFI.HTZ);
            }
            Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.HFI.BDB + " elemt.bankcardTag : " + this.HRy.HQg);
            Log.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.HRy.HQg);
            Bundle input = getInput();
            input.putString("key_mobile", bpt);
            input.putParcelable("key_authen", this.HFI);
            input.putString("key_bank_phone", this.HRy.HXo);
            input.putString("key_country_code", this.countryCode);
            input.putString("key_province_code", this.provinceCode);
            input.putString("key_city_code", this.cityCode);
            input.putParcelable("key_profession", this.HRz);
            input.putString("key_country_iso", this.IeX);
            input.putString("key_bind_card_type", this.HFI.dDj);
            input.putString("key_bind_card_show1", this.HRy.ynT);
            if (2 == this.HRy.HXl) {
                string = getString(R.string.ibk);
            } else {
                string = getString(R.string.ic4);
            }
            input.putString("key_bind_card_show2", string);
            String string3 = input.getString("key_bind_card_user_token", null);
            if (!Util.isNullOrNil(string3)) {
                this.HFI.HVe = 1;
                this.HFI.HQm = string3;
            }
            this.HFI.HVf = input.getString("kreq_token");
            if (getNetController().r(this.HFI, this.CwO)) {
                Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
                AppMethodBeat.o(70808);
                return;
            }
            Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
        }
        AppMethodBeat.o(70808);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70809);
        Log.i("MicroMsg.WalletCardElmentUI", " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            Bundle input = getInput();
            Log.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
            if (qVar instanceof ad) {
                Log.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
                com.tencent.mm.wallet_core.a.l(this, input);
                AppMethodBeat.o(70809);
                return true;
            }
            AppMethodBeat.o(70809);
            return false;
        }
        AppMethodBeat.o(70809);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8d;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70810);
        Log.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (this.IeF.g(i2, i3, intent)) {
            AppMethodBeat.o(70810);
        } else if (i2 == 6 && i3 == 100) {
            if (!Util.isNullOrNil(intent.getStringExtra("country_name"))) {
                this.IeX = intent.getStringExtra("iso_code");
                this.Iex.setText(intent.getStringExtra("country_name"));
            }
            AppMethodBeat.o(70810);
        } else if (i3 != -1) {
            AppMethodBeat.o(70810);
        } else {
            switch (i2) {
                case 1:
                    this.HRy = null;
                    this.Ifa = 0;
                    this.mSelectBankName = intent.getStringExtra("bank_name");
                    this.Iej.setText(this.mSelectBankName);
                    this.IeY.setVisibility(0);
                    this.IeY.setText("");
                    aVO(this.mSelectBankName);
                    if (this.IeZ.size() == 1) {
                        this.HRy = this.IeZ.get(0);
                    }
                    Log.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", this.mSelectBankName, Integer.valueOf(this.IeZ.size()));
                    this.Ids = null;
                    is(false);
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("Country");
                    this.IeM = stringExtra + "|" + stringExtra2;
                    String stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!Util.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                        this.yMR = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.yMS = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        if (Util.isNullOrNil(stringExtra)) {
                            this.IeA.setText(stringExtra3 + " " + stringExtra4);
                        } else {
                            this.IeA.setText(stringExtra + " " + stringExtra4);
                        }
                    } else if (!Util.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
                        this.yMS = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.IeA.setText(stringExtra + " " + stringExtra3);
                    } else {
                        this.yMS = this.IeM;
                        this.IeA.setText(stringExtra);
                    }
                    if ("US".equals(stringExtra2) || "CA".equals(stringExtra2) || this.HRy.HXy) {
                        this.IeD.setVisibility(0);
                    } else {
                        this.IeD.setVisibility(8);
                    }
                    Log.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, this.yMS);
                    break;
                case 3:
                    this.IeH.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
                    break;
                case 4:
                    String stringExtra5 = intent.getStringExtra("CountryName");
                    String stringExtra6 = intent.getStringExtra("ProviceName");
                    String stringExtra7 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.provinceCode = intent.getStringExtra("Contact_Province");
                    this.cityCode = intent.getStringExtra("Contact_City");
                    StringBuilder sb = new StringBuilder();
                    if (!Util.isNullOrNil(stringExtra5)) {
                        sb.append(stringExtra5);
                    }
                    if (!Util.isNullOrNil(stringExtra6)) {
                        sb.append(" ").append(stringExtra6);
                    }
                    if (!Util.isNullOrNil(stringExtra7)) {
                        sb.append(" ").append(stringExtra7);
                    }
                    this.Ieq.setText(sb.toString());
                    break;
                case 5:
                    this.HRz = (Profession) intent.getParcelableExtra("key_select_profession");
                    this.Iep.setText(this.HRz.HTX);
                    break;
            }
            bqg();
            AppMethodBeat.o(70810);
        }
    }

    private void aVO(String str) {
        AppMethodBeat.i(70811);
        List<ElementQuery> list = t.fQQ().HQe;
        this.IeZ.clear();
        if (list != null) {
            for (ElementQuery elementQuery : list) {
                if (elementQuery.ynT.equals(str)) {
                    Log.i("MicroMsg.WalletCardElmentUI", "add element: %s, %s", elementQuery.ynT, elementQuery.dDj);
                    this.IeZ.add(elementQuery);
                    if (getInput().getInt("key_bind_scene", -1) == 5 && !elementQuery.HXH) {
                        elementQuery.HXr = getString(R.string.iv_);
                    }
                    if (this.IeZ.size() >= 2) {
                        break;
                    }
                }
            }
        }
        AppMethodBeat.o(70811);
    }

    private boolean bqg() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(70812);
        WalletFormView walletFormView = this.IeG;
        this.IeG = null;
        if (!this.Iej.hK(null)) {
            if (this.IeG == null && walletFormView != this.Iej) {
                this.IeG = this.Iej;
            }
            this.Ied.setText(R.string.i92);
            this.Ied.setTextColor(getResources().getColor(R.color.a5c));
            z = false;
        } else {
            z = true;
        }
        if (!this.Idq.hK(null)) {
            if (this.IeG == null && walletFormView != this.Idq) {
                this.IeG = this.Idq;
            }
            z = false;
        }
        if (!this.IeH.hK(this.Ieb)) {
            if (this.IeG == null && walletFormView != this.IeH) {
                this.IeG = this.IeH;
            }
            z = false;
        }
        if (this.HJY.hK(this.HKa) || this.IeJ) {
            z2 = false;
        } else {
            if (this.IeG == null && walletFormView != this.HJY) {
                this.IeG = this.HJY;
            }
            this.HKa.setText(R.string.i_6);
            this.HKa.setTextColor(getResources().getColor(R.color.a5c));
            z2 = true;
            z = false;
        }
        if (this.IeP && !this.Iet.hK(null)) {
            if (this.IeG == null && walletFormView != this.Iet) {
                this.IeG = this.Iet;
            }
            z = false;
        }
        if (this.IeQ && !this.Iev.hK(null)) {
            if (this.IeG == null && walletFormView != this.Iev) {
                this.IeG = this.Iev;
            }
            z = false;
        }
        if (!this.Ieo.hK(this.HKa)) {
            if (z2) {
                this.HKa.setText(R.string.i9z);
                this.HKa.setTextColor(getResources().getColor(R.color.a5c));
            } else {
                this.HKa.setText(R.string.i_0);
                this.HKa.setTextColor(getResources().getColor(R.color.a5c));
            }
            if (this.IeG == null && walletFormView != this.Ieo) {
                this.IeG = this.Ieo;
            }
            z = false;
        } else if (z2) {
            this.HKa.setVisibility(0);
        }
        if (this.HKa.getVisibility() == 4) {
            if (this.HRy.HXd) {
                this.HKa.setText(getString(R.string.i_7));
            } else {
                this.HKa.setText(getString(R.string.i__));
            }
            this.HKa.setTextColor(getResources().getColor(R.color.uj));
            this.HKa.setVisibility(0);
        }
        if (!this.Iel.hK(this.Ief)) {
            if (this.IeG == null && walletFormView != this.Iel) {
                this.IeG = this.Iel;
            }
            z3 = true;
            z = false;
        } else {
            z3 = false;
        }
        if (!this.Iek.hK(this.Ief)) {
            if (this.IeG == null && walletFormView != this.Iek) {
                this.IeG = this.Iek;
            }
            z = false;
        } else if (z3) {
            this.Ief.setVisibility(4);
        }
        if (!this.IeK.isChecked()) {
            z = false;
        }
        if (!this.Iey.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.Iey) {
                this.IeG = this.Iey;
            }
            z = false;
        }
        if (!this.Iez.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.Iez) {
                this.IeG = this.Iez;
            }
            z = false;
        }
        if (!this.IeA.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.IeA) {
                this.IeG = this.IeA;
            }
            z = false;
        }
        if (!this.IeB.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.IeB) {
                this.IeG = this.IeB;
            }
            z = false;
        }
        if (!this.IeC.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.IeC) {
                this.IeG = this.IeC;
            }
            z = false;
        }
        if (!this.IeD.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.IeD) {
                this.IeG = this.IeD;
            }
            z = false;
        }
        if (!this.IeE.hK(this.Ieg)) {
            if (this.IeG == null && walletFormView != this.IeE) {
                this.IeG = this.IeE;
            }
            z = false;
        }
        if (this.IeO && !this.Iep.hK(null)) {
            if (this.IeG == null && walletFormView != this.Iep) {
                this.IeG = this.Iep;
            }
            z = false;
        }
        if (this.IeN && !this.Ieq.hK(null)) {
            if (this.IeG == null && walletFormView != this.Ieq) {
                this.IeG = this.Ieq;
            }
            z = false;
        }
        if (this.IeN && !this.Ier.hK(null)) {
            if (this.IeG == null && walletFormView != this.Ier) {
                this.IeG = this.Ier;
            }
            z = false;
        }
        if (this.Ifm && !this.Ies.hK(null)) {
            if (this.IeG == null && walletFormView != this.Ies) {
                this.IeG = this.Ies;
            }
            z = false;
        }
        if (this.IeS && !this.Iew.hK(null)) {
            if (this.IeG == null && walletFormView != this.Iew) {
                this.IeG = this.Iew;
            }
            z = false;
        }
        if (z) {
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(1073741824);
            }
        } else {
            this.gxv.setEnabled(false);
            this.gxv.setClickable(false);
        }
        AppMethodBeat.o(70812);
        return z;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(70813);
        bqg();
        AppMethodBeat.o(70813);
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(70814);
        Log.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(i2)));
        switch (i2) {
            case 5:
                if (this.IeG != null) {
                    WalletFormView walletFormView = this.IeG;
                    if (walletFormView.Rwe != null) {
                        z = walletFormView.Rwe.isFocusable();
                    } else {
                        z = false;
                    }
                    if (z) {
                        WalletFormView walletFormView2 = this.IeG;
                        if (walletFormView2.Rwe != null) {
                            z2 = walletFormView2.Rwe.isClickable();
                        }
                        if (z2 && this.IeG.hhZ()) {
                            this.IeG.hic();
                        }
                    }
                    this.IeG.performClick();
                } else {
                    fSH();
                }
                AppMethodBeat.o(70814);
                return true;
            default:
                if (this.IeG == null) {
                    fSH();
                }
                AppMethodBeat.o(70814);
                return false;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean getCancelable() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70815);
        EventCenter.instance.removeListener(this.HJH);
        super.onDestroy();
        AppMethodBeat.o(70815);
    }

    private void a(WalletFormView walletFormView, int i2) {
        AppMethodBeat.i(70816);
        com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof a.C2170a) {
            ((a.C2170a) logicDelegate).aqn(i2);
            aeP(i2);
        }
        AppMethodBeat.o(70816);
    }

    private void aeP(int i2) {
        AppMethodBeat.i(70817);
        if (i2 == 1) {
            setEditFocusListener(this.HJY, 1, false, false, false);
            AppMethodBeat.o(70817);
            return;
        }
        setEditFocusListener(this.HJY, 1, true, false, false);
        AppMethodBeat.o(70817);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void fSI() {
        double d2;
        AppMethodBeat.i(70818);
        if (this.HRy == null || this.IeI == null || !this.IeI.containsKey(this.HRy.dDj)) {
            this.Ieh.setVisibility(8);
            AppMethodBeat.o(70818);
            return;
        }
        d.a aVar = this.IeI.get(this.HRy.dDj);
        if (aVar == null || aVar.IcR == null) {
            d2 = 0.0d;
        } else {
            d2 = aVar.IcS;
        }
        this.Ieh.setText(getString(R.string.i91, new Object[]{f.D(d2)}));
        this.Ieh.setVisibility(0);
        AppMethodBeat.o(70818);
    }

    private boolean fSJ() {
        AppMethodBeat.i(70819);
        boolean z = getInput().getBoolean("key_is_forgot_process", false);
        AppMethodBeat.o(70819);
        return z;
    }

    private boolean fSK() {
        AppMethodBeat.i(174523);
        com.tencent.mm.wallet_core.d process = getProcess();
        if (process == null || !"realname_verify_process".equals(process.dKC())) {
            AppMethodBeat.o(174523);
            return false;
        } else if (process.dQL.getInt("real_name_verify_mode", 0) == 4) {
            AppMethodBeat.o(174523);
            return true;
        } else {
            AppMethodBeat.o(174523);
            return false;
        }
    }

    static /* synthetic */ void g(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(70822);
        walletCardElementUI.is(false);
        AppMethodBeat.o(70822);
    }

    static /* synthetic */ void h(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(174524);
        List<Integer> fQs = walletCardElementUI.HRy.fQs();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Integer num : fQs) {
            arrayList.add(t.fQQ().av(walletCardElementUI.getContext(), num.intValue()));
        }
        AnonymousClass9 r0 = new RadioGroup.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass9 */

            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                AppMethodBeat.i(174516);
                WalletCardElementUI.this.Ifo = i2;
                AppMethodBeat.o(174516);
            }
        };
        walletCardElementUI.Ifo = -1;
        walletCardElementUI.Ifp = fQs.indexOf(Integer.valueOf(walletCardElementUI.HKd));
        f.a aVar = new f.a(walletCardElementUI.getContext());
        aVar.aC(walletCardElementUI.getString(R.string.i9h)).a(arrayList, r0, walletCardElementUI.Ifp).JnN = true;
        aVar.c(new f.c() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.AnonymousClass10 */

            {
                AppMethodBeat.i(160883);
                AppMethodBeat.o(160883);
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(174517);
                WalletCardElementUI.this.hideVKB();
                WalletCardElementUI.this.hideTenpayKB();
                if (z) {
                    if (WalletCardElementUI.this.Ifo == -1) {
                        AppMethodBeat.o(174517);
                        return;
                    }
                    WalletCardElementUI.this.Ifp = WalletCardElementUI.this.Ifo;
                    int intValue = WalletCardElementUI.this.HRy.fQs().get(WalletCardElementUI.this.Ifo).intValue();
                    if (WalletCardElementUI.this.HKd != intValue) {
                        WalletCardElementUI.this.HKd = intValue;
                        WalletCardElementUI.this.Ifk = WalletCardElementUI.this.Ien.getText();
                        WalletCardElementUI.this.Ien.setText(t.fQQ().av(WalletCardElementUI.this.getContext(), WalletCardElementUI.this.HKd));
                        WalletCardElementUI.a(WalletCardElementUI.this, WalletCardElementUI.this.HJY, WalletCardElementUI.this.HKd);
                        WalletCardElementUI.this.HJY.eIj();
                        WalletCardElementUI.this.HJY.eIi();
                        WalletCardElementUI.g(WalletCardElementUI.this);
                    }
                }
                WalletCardElementUI.this.Ifo = -1;
                AppMethodBeat.o(174517);
            }
        });
        aVar.show();
        AppMethodBeat.o(174524);
    }

    static /* synthetic */ void a(WalletCardElementUI walletCardElementUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(174527);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putString("key_bankcard_des", str2);
        bundle.putString("key_bankcard_id", str);
        com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(walletCardElementUI);
        if (by != null) {
            by.a(walletCardElementUI, WalletConfirmCardIDUI.class, bundle, 3);
        }
        AppMethodBeat.o(174527);
    }
}
