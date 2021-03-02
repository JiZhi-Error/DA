package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.g;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.cj;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.ui.MusicPreference;
import com.tencent.mm.plugin.scanner.ui.ProductScrollView;
import com.tencent.mm.plugin.scanner.ui.d;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI extends MMPreference implements i, u.a {
    private List<MusicPreference> AjG;
    private ImageView CLc;
    private View CLd;
    private TextView CLe;
    private ImageView CLf;
    private View CLg;
    private LinearLayout CLh;
    private ImageView CLi;
    private n.a CLj;
    private View CLk;
    private int CLl = 0;
    private int CLm;
    private a CLn;
    private boolean CLo = false;
    private HashMap<String, Boolean> CLp;
    private d.a CLq;
    private String CLr;
    private boolean CLs = false;
    private String CLt;
    private boolean CLu = false;
    private boolean CLv = false;
    private com.tencent.mm.plugin.scanner.history.a.a CLw;
    private cj.a CLx = new cj.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass9 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(51861);
            String a2 = z.a(aVar.heO.KHn);
            Log.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            n.a aVar2 = ProductUI.this.CLj;
            if (aVar2 != null && !Util.isNullOrNil(a2)) {
                Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
                String str = parseXml.get(".sysmsg.scanproductinfo.product.id");
                if (Util.isNullOrNil(aVar2.field_productid) || !aVar2.field_productid.equals(str)) {
                    Log.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + Util.nullAsNil(str) + ", target=" + aVar2.field_productid);
                } else {
                    LinkedList<com.tencent.mm.plugin.scanner.model.b> o = com.tencent.mm.plugin.scanner.model.b.o(parseXml, ".sysmsg.scanproductinfo.product");
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < o.size(); i2++) {
                        LinkedList<b.a> linkedList = o.get(i2).mRG;
                        if (linkedList != null) {
                            for (int i3 = 0; i3 < linkedList.size(); i3++) {
                                b.a aVar3 = linkedList.get(i3);
                                if (aVar3 != null) {
                                    hashMap.put(aVar3.key, aVar3);
                                }
                            }
                        }
                    }
                    Log.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    t.b(aVar2.CUx, hashMap);
                }
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass9.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(51860);
                    ProductUI.a(ProductUI.this, ProductUI.this.CLj);
                    AppMethodBeat.o(51860);
                }
            });
            AppMethodBeat.o(51861);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private MusicPreference.a CLy = new MusicPreference.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.scanner.ui.MusicPreference.a
        public final void d(MusicPreference musicPreference) {
            String blA;
            int i2;
            AppMethodBeat.i(51854);
            if (musicPreference == null) {
                Log.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
                AppMethodBeat.o(51854);
            } else if (!Util.isNullOrNil(musicPreference.CEJ) || !Util.isNullOrNil(musicPreference.CEK)) {
                String format = String.format("%s_cd_%s", musicPreference.CEJ, musicPreference.mKey);
                if (ProductUI.aMN(format)) {
                    com.tencent.mm.ay.a.bea();
                    Log.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", format);
                } else if (musicPreference.getTitle() == null) {
                    Log.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                    AppMethodBeat.o(51854);
                    return;
                } else {
                    int i3 = -1;
                    if (ProductUI.this.CLn == null) {
                        blA = null;
                    } else {
                        blA = ProductUI.this.CLn.blA();
                    }
                    String format2 = String.format("%s_cd_%s", musicPreference.CEJ, musicPreference.mKey);
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    for (MusicPreference musicPreference2 : ProductUI.this.AjG) {
                        String format3 = String.format("%s_cd_%s", musicPreference2.CEJ, musicPreference2.mKey);
                        if (format2.equals(format3)) {
                            i2 = i4;
                        } else {
                            i2 = i3;
                        }
                        arrayList.add(g.a(5, blA, musicPreference2.getTitle().toString(), "", musicPreference2.CEL, musicPreference2.CEK, musicPreference2.CEJ, format3, com.tencent.mm.kernel.g.aAh().hqG, blA, "", "wx482a4001c37e2b74"));
                        i4++;
                        i3 = i2;
                    }
                    if (i3 < 0) {
                        AppMethodBeat.o(51854);
                        return;
                    }
                    com.tencent.mm.ay.a.f(arrayList, i3);
                }
                ProductUI.q(ProductUI.this);
                AppMethodBeat.o(51854);
            } else {
                Log.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
                if (!Util.isNullOrNil(musicPreference.CEL)) {
                    ProductUI.a(ProductUI.this, musicPreference.CEL);
                }
                AppMethodBeat.o(51854);
            }
        }
    };
    private boolean CLz = true;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(51851);
            if (z) {
                Log.i("MicroMsg.scanner.ProductUI", "getLocation suc");
                if (ProductUI.this.CLj != null) {
                    Log.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f2 + ", lat=" + f3);
                    com.tencent.mm.kernel.g.azz().a(new k(ProductUI.this.rcD, t.gA(ProductUI.this.CLj.CUx), ProductUI.this.mScene, ProductUI.this.CLr, (double) f2, (double) f3), 0);
                }
                if (ProductUI.this.gmt != null) {
                    ProductUI.this.gmt.c(ProductUI.this.gmA);
                }
                if (!ProductUI.this.iOy) {
                    ProductUI.this.iOy = true;
                    o.a(2011, f2, f3, (int) d3);
                }
                AppMethodBeat.o(51851);
                return false;
            }
            if (!ProductUI.this.uSu && !com.tencent.mm.modelgeo.d.bcc()) {
                ProductUI.this.uSu = true;
                com.tencent.mm.ui.base.h.a((Context) ProductUI.this, ProductUI.this.getString(R.string.dvi), ProductUI.this.getString(R.string.zb), ProductUI.this.getString(R.string.e_k), ProductUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(51850);
                        com.tencent.mm.modelgeo.d.cZ(ProductUI.this);
                        AppMethodBeat.o(51850);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            Log.w("MicroMsg.scanner.ProductUI", "getLocation fail");
            AppMethodBeat.o(51851);
            return false;
        }
    };
    private com.tencent.mm.modelgeo.d gmt;
    protected ProgressDialog gtM = null;
    private boolean iOy = false;
    private TextView kch;
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass5 */

        {
            AppMethodBeat.i(161008);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(161008);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(51855);
            switch (mxVar.dSE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    if (ProductUI.this.screen != null) {
                        ProductUI.q(ProductUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(51855);
            return false;
        }
    };
    private int mScene;
    private long mStartTime;
    private long msgId;
    private String rcD;
    protected f screen;
    private TextView titleTv;
    private ImageView uBJ;
    private boolean uOU = false;
    private boolean uSu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProductUI() {
        AppMethodBeat.i(51876);
        AppMethodBeat.o(51876);
    }

    static /* synthetic */ void A(View view, float f2) {
        AppMethodBeat.i(51912);
        z(view, f2);
        AppMethodBeat.o(51912);
    }

    static /* synthetic */ void a(ProductUI productUI, int i2, String str) {
        AppMethodBeat.i(51902);
        productUI.co(i2, str);
        AppMethodBeat.o(51902);
    }

    static /* synthetic */ void a(ProductUI productUI, n.a aVar) {
        AppMethodBeat.i(51900);
        productUI.b(aVar);
        AppMethodBeat.o(51900);
    }

    static /* synthetic */ void a(ProductUI productUI, String str) {
        AppMethodBeat.i(51903);
        productUI.aMM(str);
        AppMethodBeat.o(51903);
    }

    static /* synthetic */ boolean aMN(String str) {
        AppMethodBeat.i(51907);
        boolean aMJ = aMJ(str);
        AppMethodBeat.o(51907);
        return aMJ;
    }

    static /* synthetic */ int m(ProductUI productUI) {
        AppMethodBeat.i(51904);
        int bLC = productUI.bLC();
        AppMethodBeat.o(51904);
        return bLC;
    }

    static /* synthetic */ void q(ProductUI productUI) {
        AppMethodBeat.i(51908);
        productUI.eQL();
        AppMethodBeat.o(51908);
    }

    static /* synthetic */ void t(ProductUI productUI) {
        AppMethodBeat.i(51910);
        productUI.eQK();
        AppMethodBeat.o(51910);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.bis;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bt;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getHeaderResourceId() {
        return R.layout.biz;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(51877);
        super.onCreate(bundle);
        this.mStartTime = Util.nowSecond();
        this.mScene = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        u.b(this);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("scanproductinfo", this.CLx, true);
        initView();
        AppMethodBeat.o(51877);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(51878);
        super.onResume();
        com.tencent.mm.kernel.g.azz().a(1063, this);
        com.tencent.mm.kernel.g.azz().a(1068, this);
        AppMethodBeat.o(51878);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(51879);
        com.tencent.mm.kernel.g.azz().b(1063, this);
        com.tencent.mm.kernel.g.azz().b(1068, this);
        super.onPause();
        AppMethodBeat.o(51879);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(51880);
        u.c(this);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("scanproductinfo", this.CLx, true);
        EventCenter.instance.removeListener(this.lEl);
        if (this.gmt != null) {
            this.gmt.c(this.gmA);
        }
        co(10100, new StringBuilder().append(Util.nowSecond() - this.mStartTime).toString());
        super.onDestroy();
        AppMethodBeat.o(51880);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(51881);
        setMMTitle(R.string.gdn);
        this.screen = getPreferenceScreen();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(null);
            getSupportActionBar();
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51862);
                if (ProductUI.this.mScene == 4) {
                    ProductUI.this.setResult(0);
                }
                ProductUI.this.finish();
                AppMethodBeat.o(51862);
                return true;
            }
        });
        this.titleTv = (TextView) findViewById(R.id.gi_);
        this.CLc = (ImageView) findViewById(R.id.ghx);
        this.CLd = findViewById(R.id.gi2);
        this.CLf = (ImageView) findViewById(R.id.ghr);
        this.CLk = findViewById(R.id.ghn);
        this.CLh = (LinearLayout) findViewById(R.id.gi1);
        this.CLi = (ImageView) findViewById(R.id.ghz);
        this.CLg = findViewById(R.id.ghq);
        z(this.CLk, 0.0f);
        if (com.tencent.mm.cb.a.jk(getContext())) {
            this.titleTv.setTextSize(0, ((float) getContext().getResources().getDimensionPixelSize(R.dimen.bm)) * com.tencent.mm.cb.a.iZ(getContext()));
        } else {
            this.titleTv.setTextSize(0, (float) com.tencent.mm.cb.a.aG(getContext(), R.dimen.bm));
        }
        this.CLe = (TextView) findViewById(R.id.ghp);
        this.kch = (TextView) findViewById(R.id.hah);
        this.CLp = new HashMap<>();
        this.CLq = new d.a() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.scanner.ui.d.a
            public final void b(String str, Boolean bool) {
                AppMethodBeat.i(51863);
                if (str != null && str.length() > 0) {
                    ProductUI.this.CLp.put(str, bool);
                }
                AppMethodBeat.o(51863);
            }

            @Override // com.tencent.mm.plugin.scanner.ui.d.a
            public final Boolean aMH(String str) {
                AppMethodBeat.i(51864);
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(51864);
                    return null;
                }
                Boolean bool = (Boolean) ProductUI.this.CLp.get(str);
                AppMethodBeat.o(51864);
                return bool;
            }

            @Override // com.tencent.mm.plugin.scanner.ui.d.a
            public final void eQI() {
                AppMethodBeat.i(51865);
                if (ProductUI.this.screen != null) {
                    ProductUI.this.screen.notifyDataSetChanged();
                }
                AppMethodBeat.o(51865);
            }
        };
        this.CLw = new com.tencent.mm.plugin.scanner.history.a.a();
        this.CLw.field_ScanTime = System.currentTimeMillis();
        this.CLw.field_scene = this.mScene;
        if (this.mScene == 5) {
            this.CLu = true;
            String stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            String aMK = aMK(stringExtra);
            this.CLw.field_qrcodeUrl = stringExtra;
            this.CLw.field_productId = aMK;
            y(aMK, stringExtra, false);
        } else if (this.mScene == 4) {
            String stringExtra2 = getIntent().getStringExtra("key_product_id");
            String stringExtra3 = getIntent().getStringExtra("key_Qrcode_Url");
            if (!Util.isNullOrNil(stringExtra2)) {
                y(stringExtra2, stringExtra3, false);
            } else {
                Log.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                AppMethodBeat.o(51881);
                return;
            }
        } else {
            this.CLv = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.CLu = getIntent().getBooleanExtra("key_need_add_to_history", false);
            String stringExtra4 = getIntent().getStringExtra("key_Product_xml");
            if (!Util.isNullOrNil(stringExtra4)) {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.CLj = r.fn(stringExtra4, intExtra);
                if (this.CLj == null) {
                    Log.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    AppMethodBeat.o(51881);
                    return;
                }
                this.rcD = this.CLj.field_productid;
                this.CLr = this.CLj.field_extinfo;
                if (!this.CLu || TextUtils.isEmpty(this.rcD)) {
                    Log.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.CLu + " mProductId:" + this.rcD);
                } else {
                    this.CLw.field_xmlContent = stringExtra4;
                    this.CLw.field_qrcodeUrl = this.CLr;
                    this.CLw.field_productId = this.rcD;
                    this.CLw.field_funcType = intExtra;
                    eQO();
                }
                n.a aVar = this.CLj;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                a(aVar);
                if (intExtra != 0 || Util.isNullOrNil(this.CLj.field_productid)) {
                    eQN();
                } else {
                    y(this.CLj.field_productid, this.CLj.field_extinfo, true);
                }
            } else {
                String stringExtra5 = getIntent().getStringExtra("key_Product_ID");
                if (!Util.isNullOrNil(stringExtra5)) {
                    y(stringExtra5, null, false);
                } else {
                    Log.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    AppMethodBeat.o(51881);
                    return;
                }
            }
        }
        findViewById(R.id.gi4).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(51866);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ProductUI.l(ProductUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(51866);
            }
        });
        findViewById(R.id.ght).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(51867);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ProductUI.l(ProductUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(51867);
            }
        });
        this.CLg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(51868);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ProductUI.this.CLj != null && !Util.isNullOrNil(ProductUI.this.CLj.field_certificationurl)) {
                    ProductUI.a(ProductUI.this, 10002, ProductUI.this.CLj.field_certificationurl);
                    ProductUI.a(ProductUI.this, ProductUI.this.CLj.field_certificationurl);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(51868);
            }
        });
        new b();
        AppMethodBeat.o(51881);
    }

    private void eQJ() {
        AppMethodBeat.i(51882);
        this.CLm = getContext().getResources().getDimensionPixelSize(R.dimen.ag6);
        if (this.CLj != null && (this.CLj.field_type == 1 || this.CLj.field_type == 2)) {
            this.CLm = getContext().getResources().getDimensionPixelSize(R.dimen.ag7);
            ViewGroup.LayoutParams layoutParams = this.CLc.getLayoutParams();
            layoutParams.height = this.CLm;
            this.CLc.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.CLd.getLayoutParams();
            layoutParams2.height = this.CLm;
            this.CLh.setLayoutParams(layoutParams2);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ghy);
            ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
            layoutParams3.height = this.CLm;
            relativeLayout.setLayoutParams(layoutParams3);
            ViewGroup.LayoutParams layoutParams4 = this.CLh.getLayoutParams();
            layoutParams4.height = this.CLm;
            this.CLh.setLayoutParams(layoutParams4);
        }
        AppMethodBeat.o(51882);
    }

    private void a(final n.a aVar) {
        AppMethodBeat.i(51883);
        if (aVar == null) {
            Log.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            AppMethodBeat.o(51883);
            return;
        }
        if (!Util.isNullOrNil(aVar.field_thumburl)) {
            this.CLn = new a(aVar);
        }
        eQJ();
        if (Util.isNullOrNil(aVar.field_introtitle) || Util.isNullOrNil(aVar.field_introlink)) {
            this.kch.setVisibility(8);
        } else {
            this.kch.setText(aVar.field_introtitle);
            this.kch.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass15 */

                public final void onClick(View view) {
                    AppMethodBeat.i(51869);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ProductUI.a(ProductUI.this, ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, aVar.field_introlink);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.field_introlink);
                    intent.putExtra("geta8key_scene", ProductUI.m(ProductUI.this));
                    c.b(ProductUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(51869);
                }
            });
            this.kch.setVisibility(0);
        }
        this.CLl = this.CLj.field_functionType;
        if (aVar.field_xmlType == 3) {
            this.titleTv.setText(aVar.field_title);
            if (!Util.isNullOrNil(aVar.field_certification)) {
                this.CLe.setText(aVar.field_certification);
                this.CLf.setVisibility(0);
            } else {
                this.CLe.setText(aVar.field_source);
                this.CLf.setVisibility(8);
                this.CLg.setOnClickListener(null);
                this.CLg.setBackgroundDrawable(null);
                this.CLg.setFocusable(false);
            }
            if (aVar.field_type == 1 || aVar.field_type == 2) {
                this.uBJ = (ImageView) findViewById(R.id.gi0);
                findViewById(R.id.gi0).setVisibility(0);
                findViewById(R.id.gi3).setVisibility(8);
            } else {
                this.uBJ = (ImageView) findViewById(R.id.gi3);
                findViewById(R.id.gi3).setVisibility(0);
                findViewById(R.id.gi0).setVisibility(8);
            }
            if (!Util.isNullOrNil(aVar.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(R.id.ghw);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass16 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(51870);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ProductUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent("android.intent.action.VIEW");
                        FileProviderHelper.setIntentDataAndType((Context) ProductUI.this.getContext(), intent, Uri.parse(aVar.field_playurl), "video/*", false);
                        ProductUI productUI = ProductUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(productUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        productUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(productUI, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(51870);
                    }
                });
            }
            addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(51852);
                    ProductUI.n(ProductUI.this);
                    AppMethodBeat.o(51852);
                    return true;
                }
            });
        } else if (aVar.field_xmlType == 4) {
            this.uBJ = (ImageView) findViewById(R.id.gi3);
            findViewById(R.id.gi3).setVisibility(0);
            findViewById(R.id.gi0).setVisibility(8);
            this.uBJ.setImageResource(R.raw.scan_without_commodity_icon);
            this.uBJ.setBackgroundResource(R.raw.scan_without_commodity_icon);
            this.titleTv.setText(R.string.gck);
            this.CLe.setText((CharSequence) null);
        }
        Log.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(51853);
                ProductUI.a(ProductUI.this, aVar);
                ProductUI.b(ProductUI.this, aVar);
                AppMethodBeat.o(51853);
            }
        });
        AppMethodBeat.o(51883);
    }

    private void eQK() {
        AppMethodBeat.i(51884);
        this.msgId = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.msgId > 0 && com.tencent.mm.kernel.g.aAc()) {
            ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
            if (Hb.field_msgId > 0) {
                Hb.Cz(this.CLn.blA());
                ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.msgId, Hb);
            }
        }
        AppMethodBeat.o(51884);
    }

    private void b(n.a aVar) {
        AppMethodBeat.i(51885);
        if (aVar == null || aVar.CUx == null || aVar.CUx.size() == 0 || this.screen == null) {
            AppMethodBeat.o(51885);
            return;
        }
        this.screen.removeAll();
        for (int i2 = 0; i2 < aVar.CUx.size(); i2++) {
            com.tencent.mm.plugin.scanner.model.b bVar = aVar.CUx.get(i2);
            if (!(bVar == null || bVar.mRG == null || bVar.mRG.size() == 0 || bVar.CEF == 1 || !bVar.CEH)) {
                if (i2 != 0) {
                    Preference preference = new Preference(this);
                    preference.setLayoutResource(R.layout.biq);
                    this.screen.c(preference);
                }
                if (!Util.isNullOrNil(bVar.title) && (bVar.type == 6 || bVar.type == 7)) {
                    CategoryWithTitlePreference categoryWithTitlePreference = new CategoryWithTitlePreference(this);
                    categoryWithTitlePreference.setTitle(bVar.title);
                    this.screen.c(categoryWithTitlePreference);
                }
                if (bVar.type == 6) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < bVar.mRG.size(); i3++) {
                        b.a aVar2 = bVar.mRG.get(i3);
                        if (aVar2.type == 10) {
                            arrayList.add(aVar2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        g gVar = new g(this);
                        gVar.setKey(new StringBuilder().append(i2 * 100).toString());
                        gVar.Bar = arrayList;
                        this.screen.c(gVar);
                    }
                } else {
                    for (int i4 = 0; i4 < bVar.mRG.size(); i4++) {
                        String sb = new StringBuilder().append((i2 * 100) + i4).toString();
                        b.a aVar3 = bVar.mRG.get(i4);
                        if (aVar3.type == 11) {
                            this.CLs = true;
                            this.CLt = aVar3.name;
                        }
                        if (aVar3.dDG != 2) {
                            if (aVar3.dDG != 1) {
                                if (aVar3.type == 5) {
                                    MusicPreference musicPreference = new MusicPreference(this);
                                    musicPreference.setKey(sb);
                                    musicPreference.setTitle(aVar3.name);
                                    musicPreference.CEJ = aVar3.CEJ;
                                    musicPreference.CEK = aVar3.CEK;
                                    musicPreference.CEL = aVar3.CEL;
                                    if (!aMJ(String.format("%s_cd_%s", aVar3.CEJ, sb))) {
                                        musicPreference.tV(false);
                                    } else {
                                        musicPreference.tV(true);
                                    }
                                    musicPreference.CKI = this.CLy;
                                    this.screen.c(musicPreference);
                                    EventCenter.instance.addListener(this.lEl);
                                    if (this.AjG == null) {
                                        this.AjG = new ArrayList();
                                    }
                                    if (this.CLz) {
                                        this.AjG.add(musicPreference);
                                    }
                                } else if (aVar3.type == 6) {
                                    d dVar = new d(this);
                                    dVar.setKey(sb);
                                    dVar.mTitle = aVar3.name;
                                    dVar.setSummary(aVar3.desc);
                                    this.screen.c(dVar);
                                    dVar.CKx = this.CLq;
                                } else if (aVar3.type == 12) {
                                    e eVar = new e(this);
                                    eVar.setKey(sb);
                                    eVar.CJf = aVar3.thumburl;
                                    eVar.screen = this.screen;
                                    this.screen.c(eVar);
                                } else if (aVar3.type == 2) {
                                    String str = aML(aVar3.username) ? aVar3.CER : aVar3.CEQ;
                                    a aVar4 = new a(this);
                                    aVar4.setKey(sb);
                                    aVar4.setTitle(str);
                                    aVar4.setSummary(aVar3.desc);
                                    aVar4.CJc = aVar3.iAq;
                                    this.screen.c(aVar4);
                                } else if (aVar3.type == 22) {
                                    c cVar = new c(this);
                                    cVar.setKey(sb);
                                    if (!Util.isNullOrNil(aVar3.nickname)) {
                                        cVar.qnT = aVar3.nickname + ":";
                                    }
                                    cVar.mContent = aVar3.content;
                                    cVar.CKl = aVar3.thumburl;
                                    this.screen.c(cVar);
                                } else {
                                    a aVar5 = new a(this);
                                    aVar5.setKey(sb);
                                    aVar5.setTitle(aVar3.name);
                                    aVar5.setSummary(aVar3.desc);
                                    aVar5.CJc = aVar3.iAq;
                                    aVar5.rcG = aVar3.iconUrl;
                                    this.screen.c(aVar5);
                                }
                                if (!(i4 >= bVar.mRG.size() - 1 || aVar3.type == 12 || bVar.mRG.get(i4 + 1).type == 12 || bVar.mRG.get(i4 + 1).dDG == 1 || !e(i4, bVar.mRG))) {
                                    this.screen.c(new f(this));
                                }
                            } else if (!Util.isNullOrNil(aVar3.image)) {
                                b bVar2 = new b(this);
                                bVar2.setKey(sb);
                                bVar2.CJf = aVar3.image;
                                bVar2.screen = this.screen;
                                this.screen.c(bVar2);
                            }
                        }
                    }
                }
            }
        }
        this.screen.notifyDataSetChanged();
        Log.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
        if (this.AjG != null) {
            this.CLz = false;
        }
        AppMethodBeat.o(51885);
    }

    private static boolean e(int i2, LinkedList<b.a> linkedList) {
        AppMethodBeat.i(51886);
        if (linkedList != null) {
            for (int i3 = i2 + 1; i3 < linkedList.size(); i3++) {
                if (linkedList.get(i3).dDG != 2) {
                    AppMethodBeat.o(51886);
                    return true;
                }
            }
        }
        AppMethodBeat.o(51886);
        return false;
    }

    private void eQL() {
        AppMethodBeat.i(51887);
        if (this.CLj == null || this.CLj.CUx == null || this.CLj.CUx.size() == 0 || this.screen == null) {
            AppMethodBeat.o(51887);
            return;
        }
        for (int i2 = 0; i2 < this.CLj.CUx.size(); i2++) {
            com.tencent.mm.plugin.scanner.model.b bVar = this.CLj.CUx.get(i2);
            if (!(bVar == null || bVar.mRG == null || bVar.mRG.size() == 0)) {
                for (int i3 = 0; i3 < bVar.mRG.size(); i3++) {
                    b.a aVar = bVar.mRG.get(i3);
                    if (aVar.type == 5) {
                        String sb = new StringBuilder().append((i2 * 100) + i3).toString();
                        MusicPreference musicPreference = (MusicPreference) this.screen.bmg(sb);
                        if (musicPreference != null) {
                            if (!aMJ(String.format("%s_cd_%s", aVar.CEJ, sb))) {
                                musicPreference.tV(false);
                            } else {
                                musicPreference.tV(true);
                            }
                        }
                    }
                }
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(51887);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        AppMethodBeat.i(51888);
        Log.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", preference.mKey);
        if (this.CLj == null || this.CLj.CUx == null) {
            Log.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            AppMethodBeat.o(51888);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i2 = intValue / 100;
            int i3 = intValue % 100;
            Log.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 < 0 || i2 >= this.CLj.CUx.size()) {
                Log.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i2), Integer.valueOf(this.CLj.CUx.size()));
                AppMethodBeat.o(51888);
                return false;
            }
            com.tencent.mm.plugin.scanner.model.b bVar = this.CLj.CUx.get(i2);
            if (bVar == null) {
                Log.w("MicroMsg.scanner.ProductUI", "actionList == null");
                AppMethodBeat.o(51888);
                return false;
            } else if (i3 < 0 || i3 >= bVar.mRG.size()) {
                Log.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i3), Integer.valueOf(bVar.mRG.size()));
                AppMethodBeat.o(51888);
                return false;
            } else {
                b.a aVar = bVar.mRG.get(i3);
                if (aVar == null) {
                    Log.w("MicroMsg.scanner.ProductUI", "action == null");
                    AppMethodBeat.o(51888);
                    return false;
                }
                Log.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", Integer.valueOf(aVar.type));
                Intent intent = new Intent();
                switch (aVar.type) {
                    case 1:
                    case 3:
                    case 22:
                        str = aVar.link;
                        if (!Util.isNullOrNil(aVar.link)) {
                            aMM(aVar.link);
                            break;
                        }
                        break;
                    case 2:
                    case 4:
                        str = aVar.username;
                        if (!Util.isNullOrNil(aVar.username)) {
                            String str2 = aVar.username;
                            if (!aML(str2)) {
                                if (!TextUtils.isEmpty(str2)) {
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("Contact_User", str2);
                                    intent2.putExtra("force_get_contact", true);
                                    intent2.putExtra("Contact_Scene", eQM());
                                    com.tencent.mm.plugin.scanner.h.jRt.c(intent2, this);
                                    break;
                                } else {
                                    Log.v("MicroMsg.scanner.ProductUI", "username is null");
                                    break;
                                }
                            } else {
                                Intent intent3 = new Intent();
                                intent3.putExtra("Chat_User", str2);
                                intent3.putExtra("finish_direct", true);
                                intent3.putExtra("add_scene", eQM());
                                com.tencent.mm.plugin.scanner.h.jRt.d(intent3, getContext());
                                break;
                            }
                        }
                        break;
                    case 5:
                        str = aVar.CEL;
                        intent.putExtra("rawUrl", aVar.CEL);
                        intent.putExtra("geta8key_scene", bLC());
                        com.tencent.mm.plugin.scanner.h.jRt.i(intent, this);
                        com.tencent.mm.ay.a.bea();
                        eQL();
                        break;
                    case 6:
                    case 7:
                    case 10:
                        str = null;
                        break;
                    case 8:
                        str = aVar.CEN;
                        intent.putExtra("key_card_id", aVar.CEP);
                        intent.putExtra("key_card_ext", aVar.CEO);
                        intent.putExtra("key_from_scene", 9);
                        c.b(this, "card", ".ui.CardDetailUI", intent);
                        break;
                    case 9:
                        str = aVar.CEN;
                        if (!Util.isNullOrNil(aVar.CEN)) {
                            intent.putExtra("key_product_id", aVar.CEN);
                            intent.putExtra("key_product_scene", 12);
                            c.b(this, "product", ".ui.MallProductUI", intent);
                            break;
                        }
                        break;
                    case 11:
                        intent.setClass(this, ProductFurtherInfoUI.class);
                        intent.putExtra("key_Product_xml", this.CLj.field_xml);
                        intent.putExtra("key_title", aVar.name);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        str = null;
                        break;
                    case 12:
                        str = aVar.link;
                        if (!Util.isNullOrNil(aVar.link)) {
                            aMM(aVar.link);
                            break;
                        }
                        break;
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    default:
                        Log.d("MicroMsg.scanner.ProductUI", "Default go url:" + aVar.link);
                        if (!Util.isNullOrNil(aVar.link)) {
                            aMM(aVar.link);
                        }
                        str = null;
                        break;
                    case 21:
                        String str3 = aVar.CEG;
                        intent.setClass(this, ProductPurchaseAreaUI.class);
                        intent.putExtra("key_Product_xml", this.CLj.field_xml);
                        intent.putExtra("referkey", aVar.CEG);
                        intent.putExtra("key_Product_funcType", this.CLl);
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        str = str3;
                        break;
                }
                com.tencent.mm.kernel.g.azz().a(new p(this.CLj.field_productid, aVar.CEM, aVar.type, str, bVar.mRG.size(), aVar.dDG), 0);
                AppMethodBeat.o(51888);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.scanner.ProductUI", e2, "", new Object[0]);
            AppMethodBeat.o(51888);
            return false;
        }
    }

    private static boolean aMJ(String str) {
        AppMethodBeat.i(51889);
        com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
        if (bef == null || bef.jeT != 5 || !str.equals(bef.jeV) || !com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(51889);
            return false;
        }
        AppMethodBeat.o(51889);
        return true;
    }

    private void co(int i2, String str) {
        AppMethodBeat.i(51890);
        if (this.CLj == null) {
            AppMethodBeat.o(51890);
            return;
        }
        com.tencent.mm.kernel.g.azz().a(new p(this.CLj.field_productid, "", i2, str, 0, 0), 0);
        AppMethodBeat.o(51890);
    }

    public static final class a implements com.tencent.mm.platformtools.s {
        private n.a CLj;

        public a(n.a aVar) {
            this.CLj = aVar;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blA() {
            AppMethodBeat.i(51871);
            String jP = j.eOR().jP(this.CLj.field_thumburl, "@S");
            AppMethodBeat.o(51871);
            return jP;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blB() {
            if (this.CLj == null) {
                return "";
            }
            return this.CLj.field_thumburl;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String blC() {
            if (this.CLj == null) {
                return "";
            }
            return this.CLj.field_thumburl;
        }

        @Override // com.tencent.mm.platformtools.s
        public final String getCacheKey() {
            if (this.CLj == null) {
                return "";
            }
            return this.CLj.field_thumburl;
        }

        @Override // com.tencent.mm.platformtools.s
        public final boolean blD() {
            return false;
        }

        @Override // com.tencent.mm.platformtools.s
        public final boolean blE() {
            return false;
        }

        @Override // com.tencent.mm.platformtools.s
        public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
            AppMethodBeat.i(51872);
            if (s.a.NET == aVar) {
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.scanner.ProductUI", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(51872);
            return bitmap;
        }

        @Override // com.tencent.mm.platformtools.s
        public final void blG() {
        }

        @Override // com.tencent.mm.platformtools.s
        public final void ad(String str, boolean z) {
        }

        @Override // com.tencent.mm.platformtools.s
        public final void a(s.a aVar, String str) {
        }

        @Override // com.tencent.mm.platformtools.s
        public final Bitmap blF() {
            AppMethodBeat.i(51873);
            if (MMApplicationContext.getContext() == null) {
                AppMethodBeat.o(51873);
                return null;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(51873);
            return decodeResource;
        }

        @Override // com.tencent.mm.platformtools.s
        public final s.b blz() {
            return null;
        }
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(final String str, final Bitmap bitmap) {
        AppMethodBeat.i(51891);
        if (!Util.isNullOrNil(str) && this.CLj != null && bitmap != null && !bitmap.isRecycled()) {
            Log.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(str)));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(51858);
                    if (str.equals(ProductUI.this.CLj.field_thumburl) && ProductUI.this.uBJ != null) {
                        Log.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
                        try {
                            ProductUI.this.uBJ.setImageBitmap(bitmap);
                            ProductUI.this.uBJ.setBackgroundDrawable(null);
                            ProductUI.this.uBJ.setBackgroundColor(-1);
                            ProductUI.t(ProductUI.this);
                            ProductUI.this.CLo = true;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", e2.getLocalizedMessage());
                        }
                    }
                    if (str.equals(ProductUI.this.CLj.field_headerbackgroundurl) && ProductUI.this.CLc != null) {
                        ProductUI.this.CLc.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(51858);
                }
            });
        }
        AppMethodBeat.o(51891);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        oo ooVar;
        AppMethodBeat.i(51892);
        if (qVar == null) {
            Log.w("MicroMsg.scanner.ProductUI", "scene == null");
            AppMethodBeat.o(51892);
        } else if (qVar.getType() != 1063) {
            if (qVar.getType() == 1068 && i2 == 0 && i3 == 0) {
                LinkedList<String> linkedList = ((om) ((k) qVar).rr.iLL.iLR).KUv;
                if (this.CLj != null && t.b(this.CLj.CUx, t.gB(linkedList))) {
                    b(this.CLj);
                }
            }
            AppMethodBeat.o(51892);
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.scanner.model.l lVar = (com.tencent.mm.plugin.scanner.model.l) qVar;
            if (lVar.rr == null || lVar.rr.iLL.iLR == null) {
                ooVar = null;
            } else {
                ooVar = (oo) lVar.rr.iLL.iLR;
            }
            if (ooVar == null) {
                Log.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                AppMethodBeat.o(51892);
                return;
            }
            if (ooVar.KUw != null) {
                Log.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                n.a fn = r.fn(ooVar.KUw, this.CLl);
                if (this.CLj != null && this.CLj.field_xml != null && fn != null && fn.field_xml != null && !this.CLj.field_xml.equals(fn.field_xml)) {
                    this.CLj = fn;
                    a(this.CLj);
                } else if (!(fn == null || fn.field_xml == null)) {
                    this.CLj = fn;
                    a(this.CLj);
                }
                if (this.gtM != null && this.gtM.isShowing()) {
                    this.gtM.dismiss();
                }
                eQN();
                if (!this.CLu || this.uOU || TextUtils.isEmpty(this.rcD)) {
                    Log.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.CLu + " mProductId:" + this.rcD + "  hasAddToHistory:" + this.uOU);
                } else {
                    this.CLw.field_xmlContent = ooVar.KUw;
                    this.CLw.field_funcType = this.CLl;
                    eQO();
                    AppMethodBeat.o(51892);
                    return;
                }
            }
            AppMethodBeat.o(51892);
        } else {
            Log.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(51892);
        }
    }

    private static String aMK(String str) {
        String str2 = null;
        AppMethodBeat.i(51893);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(51893);
        } else {
            try {
                str2 = Uri.parse(str).getQueryParameter("p");
                AppMethodBeat.o(51893);
            } catch (Exception e2) {
                Log.w("MicroMsg.scanner.ProductUI", str + ";" + e2.getLocalizedMessage());
                AppMethodBeat.o(51893);
            }
        }
        return str2;
    }

    private void y(String str, String str2, boolean z) {
        AppMethodBeat.i(51894);
        this.rcD = str;
        this.CLr = str2;
        final com.tencent.mm.plugin.scanner.model.l lVar = new com.tencent.mm.plugin.scanner.model.l(str, this.mScene, str2);
        com.tencent.mm.kernel.g.azz().a(lVar, 0);
        if (!z) {
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = com.tencent.mm.ui.base.h.b((Context) context, getString(R.string.gct), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(51859);
                    Log.d("MicroMsg.scanner.ProductUI", "User cancel");
                    com.tencent.mm.kernel.g.azz().a(lVar);
                    AppMethodBeat.o(51859);
                }
            });
        }
        AppMethodBeat.o(51894);
    }

    private static boolean aML(String str) {
        AppMethodBeat.i(51895);
        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0 || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
            AppMethodBeat.o(51895);
            return false;
        }
        AppMethodBeat.o(51895);
        return true;
    }

    private int bLC() {
        if (this.CLl == 4) {
            return 11;
        }
        if (this.CLl == 3) {
            return 12;
        }
        return 0;
    }

    private void aMM(String str) {
        AppMethodBeat.i(51896);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", r.Wu(this.CLl));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", bLC());
        c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(51896);
    }

    private int eQM() {
        if (this.CLl == 3) {
            return 47;
        }
        return 49;
    }

    private void eQN() {
        AppMethodBeat.i(51897);
        if (this.CLj != null) {
            Log.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.CLj.field_getaction);
            if ((this.CLj.field_getaction & 2) > 0) {
                this.gmt = com.tencent.mm.modelgeo.d.bca();
                if (this.gmt != null) {
                    this.gmt.b(this.gmA);
                    AppMethodBeat.o(51897);
                    return;
                }
            } else if ((this.CLj.field_getaction & 1) > 0) {
                com.tencent.mm.kernel.g.azz().a(new k(this.rcD, t.gA(this.CLj.CUx), this.mScene, this.CLr, 0.0d, 0.0d), 0);
            }
        }
        AppMethodBeat.o(51897);
    }

    /* access modifiers changed from: package-private */
    public final class b {
        ProductScrollView CLG = ((ProductScrollView) ProductUI.this.findViewById(R.id.glx));
        boolean CLH;
        private ProductScrollView.a CLI = new ProductScrollView.a() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.ui.ProductScrollView.a
            public final void cLT() {
                float f2;
                float f3 = 1.0f;
                AppMethodBeat.i(51874);
                b bVar = b.this;
                int scrollY = bVar.CLG.getScrollY();
                if (scrollY < 0) {
                    f2 = -1.0f;
                } else if (scrollY >= ProductUI.this.CLm - bVar.mActionBarHeight || ((float) ProductUI.this.CLm) == 0.0f) {
                    f2 = 1.0f;
                } else {
                    f2 = (((float) scrollY) * 1.37f) / ((float) ProductUI.this.CLm);
                }
                Log.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f2)));
                if (f2 == 1.0f) {
                    if (!bVar.CLH) {
                        bVar.CLH = true;
                    }
                    AppMethodBeat.o(51874);
                }
                bVar.CLH = false;
                if (ProductUI.this.CLh != null) {
                    float f4 = (1.0f - f2) - 0.2f;
                    if (f4 <= 0.0f) {
                        f4 = 0.0f;
                    }
                    if (f2 == 0.0f) {
                        f4 = 1.0f;
                    }
                    ProductUI.A(ProductUI.this.CLh, f4);
                }
                if (ProductUI.this.CLk != null) {
                    if (f2 == 0.0f) {
                        f3 = 0.0f;
                    } else if (f2 >= 0.0f) {
                        float f5 = f2 + 0.2f;
                        if (f5 <= 1.0f) {
                            f3 = f5;
                        }
                    }
                    ProductUI.A(ProductUI.this.CLk, f3);
                }
                AppMethodBeat.o(51874);
            }
        };
        int mActionBarHeight;

        public b() {
            AppMethodBeat.i(51875);
            this.CLG.setOnScrollListener(this.CLI);
            this.mActionBarHeight = ProductUI.w(ProductUI.this);
            AppMethodBeat.o(51875);
        }
    }

    private static void z(View view, float f2) {
        AppMethodBeat.i(51898);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f2);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
        AppMethodBeat.o(51898);
    }

    private void eQO() {
        boolean update;
        AppMethodBeat.i(51899);
        if (!e.eRU()) {
            Log.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
            AppMethodBeat.o(51899);
            return;
        }
        com.tencent.mm.plugin.scanner.history.a.a aVar = new com.tencent.mm.plugin.scanner.history.a.a();
        aVar.field_productId = this.rcD;
        if (!j.eOR().eOS().get(aVar, new String[0])) {
            update = j.eOR().eOS().insert(this.CLw);
        } else {
            update = j.eOR().eOS().update(this.CLw, new String[0]);
        }
        if (update) {
            Log.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
            this.uOU = true;
            AppMethodBeat.o(51899);
            return;
        }
        Log.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
        AppMethodBeat.o(51899);
    }

    static /* synthetic */ void l(ProductUI productUI) {
        AppMethodBeat.i(51901);
        if (productUI.CLj != null) {
            if (!Util.isNullOrNil(productUI.CLj.field_detailurl)) {
                productUI.co(10000, productUI.CLj.field_detailurl);
                productUI.aMM(productUI.CLj.field_detailurl);
                AppMethodBeat.o(51901);
                return;
            } else if (!Util.isNullOrNil(productUI.CLj.field_xml) && productUI.CLs) {
                productUI.co(10001, "");
                Intent intent = new Intent();
                intent.setClass(productUI, ProductFurtherInfoUI.class);
                intent.putExtra("key_Product_xml", productUI.CLj.field_xml);
                intent.putExtra("key_title", productUI.CLt);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(productUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ProductUI", "toProductDetail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                productUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(productUI, "com/tencent/mm/plugin/scanner/ui/ProductUI", "toProductDetail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
        AppMethodBeat.o(51901);
    }

    static /* synthetic */ void n(ProductUI productUI) {
        AppMethodBeat.i(51905);
        String str = "";
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(R.string.j4d));
        linkedList2.add(0);
        linkedList.add(productUI.getString(R.string.j4c));
        linkedList2.add(1);
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(R.string.fn9));
            linkedList2.add(2);
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(R.string.tf);
            linkedList.add(productUI.getString(R.string.dm));
            linkedList2.add(3);
        } else {
            str = "";
        }
        if (productUI.CLj != null && !TextUtils.isEmpty(productUI.CLj.field_exposeurl)) {
            linkedList.add(productUI.getString(R.string.bal));
            linkedList2.add(4);
        }
        com.tencent.mm.ui.base.h.b(productUI, "", linkedList, linkedList2, str, new h.e() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(51857);
                if (ProductUI.this.CLj == null) {
                    AppMethodBeat.o(51857);
                    return;
                }
                switch (i3) {
                    case -1:
                        com.tencent.mm.ui.base.h.a(ProductUI.this.getContext(), ProductUI.this.getContext().getString(R.string.th), (List<String>) null, (List<Integer>) null, ProductUI.this.getContext().getString(R.string.tf), new h.e() {
                            /* class com.tencent.mm.plugin.scanner.ui.ProductUI.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.h.e
                            public final void cy(int i2, int i3) {
                                AppMethodBeat.i(51856);
                                switch (i3) {
                                    case -1:
                                        cu cuVar = new cu();
                                        cuVar.dFU.dFW = ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1);
                                        EventCenter.instance.publish(cuVar);
                                        Log.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", Long.valueOf(cuVar.dFU.dFW), Boolean.valueOf(cuVar.dFV.dFE));
                                        if (cuVar.dFV.dFE) {
                                            ProductUI.this.finish();
                                            AppMethodBeat.o(51856);
                                            return;
                                        }
                                        break;
                                    default:
                                        Log.d("MicroMsg.scanner.ProductUI", "do del cancel");
                                        break;
                                }
                                AppMethodBeat.o(51856);
                            }
                        });
                        AppMethodBeat.o(51857);
                        return;
                    case 0:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11446, ProductUI.this.CLj.field_productid, 2);
                        if (ProductUI.this.mScene == 3) {
                            com.tencent.mm.plugin.fav.a.h.w(ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1), 1);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10651, 10, 0, 0);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("KContentObjDesc", ProductUI.this.CLj.field_subtitle);
                        intent.putExtra("Ksnsupload_title", ProductUI.this.CLj.field_title);
                        intent.putExtra("Ksnsupload_link", ProductUI.this.CLj.field_shareurl);
                        intent.putExtra("Ksnsupload_appname", n.am(ProductUI.this, ProductUI.this.CLj.field_type));
                        intent.putExtra("Ksnsupload_appid", r.Wu(ProductUI.this.CLj.field_functionType));
                        intent.putExtra("Ksnsupload_imgurl", ProductUI.this.CLj.field_thumburl);
                        Log.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.this.CLj.field_thumburl);
                        if (ProductUI.this.CLn != null) {
                            intent.putExtra("KsnsUpload_imgPath", ProductUI.this.CLn.blA());
                        } else {
                            Log.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                        }
                        intent.putExtra("Ksnsupload_type", 3);
                        intent.putExtra("KUploadProduct_UserData", n.c(ProductUI.this.CLj));
                        intent.putExtra("KUploadProduct_subType", ProductUI.this.CLj.field_type);
                        String JX = ad.JX("scan_product");
                        ad.aVe().G(JX, true).l("prePublishId", "scan_product");
                        intent.putExtra("reportSessionId", JX);
                        c.b(ProductUI.this, "sns", ".ui.SnsUploadUI", intent);
                        AppMethodBeat.o(51857);
                        return;
                    case 1:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11446, ProductUI.this.CLj.field_productid, 1);
                        String a2 = r.a(ProductUI.this.getContext(), ProductUI.this.CLj);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_content", a2);
                        intent2.putExtra("Retr_Msg_Type", 2);
                        if (ProductUI.this.CLn != null) {
                            intent2.putExtra("Retr_Msg_thumb_path", ProductUI.this.CLn.blA());
                        } else {
                            Log.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                        }
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        com.tencent.mm.plugin.scanner.h.jRt.k(intent2, ProductUI.this);
                        if (ProductUI.this.mScene == 3) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10651, 10, 1, 0);
                            AppMethodBeat.o(51857);
                            return;
                        }
                        break;
                    case 2:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11446, ProductUI.this.CLj.field_productid, 3);
                        ProductUI.r(ProductUI.this);
                        AppMethodBeat.o(51857);
                        return;
                    case 3:
                        Intent intent3 = new Intent();
                        intent3.putExtra("key_fav_scene", 2);
                        intent3.putExtra("key_fav_item_id", ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1));
                        com.tencent.mm.plugin.fav.a.b.b(ProductUI.this.getContext(), ".ui.FavTagEditUI", intent3);
                        AppMethodBeat.o(51857);
                        return;
                    case 4:
                        Intent intent4 = new Intent();
                        intent4.putExtra("rawUrl", ProductUI.this.CLj.field_exposeurl);
                        c.b(ProductUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent4);
                        break;
                }
                AppMethodBeat.o(51857);
            }
        });
        AppMethodBeat.o(51905);
    }

    static /* synthetic */ void b(ProductUI productUI, n.a aVar) {
        Bitmap a2;
        AppMethodBeat.i(51906);
        if (aVar == null || Util.isNullOrNil(aVar.field_thumburl)) {
            Log.e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            AppMethodBeat.o(51906);
            return;
        }
        try {
            productUI.CLd.setBackgroundColor(Color.parseColor(aVar.field_headermask));
            if (!Util.isNullOrNil(aVar.field_headermask) && aVar.field_headermask.length() == 9) {
                productUI.CLk.setBackgroundColor(Color.parseColor("#" + aVar.field_headermask.substring(3, 9)));
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        Log.e("MicroMsg.scanner.ProductUI", "begin to get the url " + aVar.field_thumburl);
        Bitmap a3 = u.a(productUI.CLn);
        if (a3 != null) {
            productUI.uBJ.setImageBitmap(a3);
            productUI.uBJ.setBackgroundDrawable(null);
            productUI.uBJ.setBackgroundColor(-1);
            productUI.CLo = true;
            productUI.eQK();
        } else {
            productUI.uBJ.setImageBitmap(null);
        }
        if (!Util.isNullOrNil(aVar.field_headerbackgroundurl) && (a2 = u.a(new com.tencent.mm.plugin.scanner.util.q(aVar.field_headerbackgroundurl))) != null && !a2.isRecycled()) {
            productUI.CLc.setImageBitmap(a2);
        }
        AppMethodBeat.o(51906);
    }

    static /* synthetic */ void r(ProductUI productUI) {
        AppMethodBeat.i(51909);
        if (productUI.CLj == null) {
            Log.w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            AppMethodBeat.o(51909);
            return;
        }
        cz czVar = new cz();
        anb anb = new anb();
        anh anh = new anh();
        ana ana = new ana();
        anh.bhf(com.tencent.mm.model.z.aTY());
        anh.bhg(com.tencent.mm.model.z.aTY());
        anh.ajm(8);
        anh.MA(Util.nowMilliSecond());
        anh.bhl(r.Wu(productUI.CLj.field_functionType));
        ana.bgY(productUI.CLj.field_title);
        ana.bgZ(productUI.CLj.field_subtitle);
        ana.ajj(productUI.CLj.field_type);
        ana.bhb(n.c(productUI.CLj));
        ana.bha(productUI.CLj.field_thumburl);
        czVar.dFZ.title = productUI.CLj.field_title;
        czVar.dFZ.desc = productUI.CLj.field_subtitle;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 10;
        anb.a(anh);
        anb.b(ana);
        czVar.dFZ.dGf = 11;
        czVar.dFZ.activity = productUI;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(51909);
    }

    static /* synthetic */ int w(ProductUI productUI) {
        AppMethodBeat.i(51911);
        int i2 = 0;
        TypedValue typedValue = new TypedValue();
        if (productUI.getTheme().resolveAttribute(R.attr.z, typedValue, true)) {
            i2 = TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics());
        }
        AppMethodBeat.o(51911);
        return i2;
    }
}
