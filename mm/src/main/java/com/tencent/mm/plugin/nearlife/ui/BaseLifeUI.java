package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.nearlife.ui.LogoImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLifeUI extends MMActivity implements i {
    private String AAU = "";
    protected int ABA = 0;
    protected boolean ABB = false;
    protected int ABC = -1;
    protected boolean ABD = false;
    boolean ABE = false;
    protected boolean ABF = true;
    private View.OnClickListener ABG = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(26560);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            BaseLifeUI.a(BaseLifeUI.this);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26560);
        }
    };
    private View.OnClickListener ABH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(26561);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (BaseLifeUI.this.ABs == null) {
                Log.e("MicroMsg.BaseLifeUI", "Location is null");
                a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26561);
                return;
            }
            h.INSTANCE.a(11138, "1", Integer.valueOf(BaseLifeUI.this.ABl.getCount() + 1), BaseLifeUI.this.hes);
            Intent intent = new Intent();
            intent.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
            intent.putExtra("get_lat", BaseLifeUI.this.ABs.LbD);
            intent.putExtra("get_lng", BaseLifeUI.this.ABs.LbC);
            intent.putExtra("get_preci", BaseLifeUI.this.ABs.LuT);
            intent.putExtra("get_poi_name", BaseLifeUI.this.ABl.exa());
            intent.putExtra("get_cur_lat", BaseLifeUI.this.ABt);
            intent.putExtra("get_cur_lng", BaseLifeUI.this.ABu);
            intent.putExtra("get_accuracy", BaseLifeUI.this.ABw);
            intent.putExtra("get_loctype", BaseLifeUI.this.ABv);
            intent.putExtra("search_id", BaseLifeUI.this.hes);
            intent.putExtra("get_is_mars", BaseLifeUI.this.iVk);
            BaseLifeUI.this.startActivityForResult(intent, 1);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26561);
        }
    };
    private b.a ABI = new b.a() {
        /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass7 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            boolean z2;
            AppMethodBeat.i(26572);
            if (BaseLifeUI.this.ifz) {
                AppMethodBeat.o(26572);
                return false;
            } else if (BaseLifeUI.this.gmw) {
                AppMethodBeat.o(26572);
                return false;
            } else if (!z) {
                if (!BaseLifeUI.this.uSu && !d.bcc()) {
                    BaseLifeUI.this.uSu = true;
                    com.tencent.mm.ui.base.h.a((Context) BaseLifeUI.this, BaseLifeUI.this.getString(R.string.dvi), BaseLifeUI.this.getString(R.string.zb), BaseLifeUI.this.getString(R.string.e_k), BaseLifeUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass7.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26571);
                            d.cZ(BaseLifeUI.this);
                            AppMethodBeat.o(26571);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                AppMethodBeat.o(26572);
                return true;
            } else {
                o.a(2003, f2, f3, (int) d3);
                BaseLifeUI.this.gmw = true;
                Log.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), Float.valueOf(f3), Float.valueOf(f2));
                BaseLifeUI.this.ABs = new chk();
                BaseLifeUI.this.ABs.LuV = "";
                BaseLifeUI.this.ABs.LuW = 0;
                BaseLifeUI.this.ABs.LbD = f3;
                BaseLifeUI.this.ABs.LbC = f2;
                BaseLifeUI.this.ABs.LuU = "";
                BaseLifeUI.this.ABs.LuT = (int) d3;
                BaseLifeUI.this.ABt = f3;
                BaseLifeUI.this.ABu = f2;
                BaseLifeUI.this.ABv = i2;
                BaseLifeUI.this.ABw = (float) d3;
                BaseLifeUI baseLifeUI = BaseLifeUI.this;
                if (BaseLifeUI.this.uzs == null) {
                    z2 = false;
                } else {
                    z2 = BaseLifeUI.this.uzs.iVk;
                }
                baseLifeUI.iVk = z2;
                ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> arrayList = BaseLifeUI.this.ABk.ABb;
                if (arrayList == null || arrayList.size() <= 0) {
                    BaseLifeUI.this.p((double) f3, (double) f2);
                } else {
                    BackwardSupportUtil.ExifHelper.LatLongData latLongData = arrayList.get(arrayList.size() - 1);
                    BaseLifeUI.this.p((double) latLongData.latitude, (double) latLongData.longtitude);
                    BaseLifeUI.this.ABD = BaseLifeUI.p(latLongData.latitude, latLongData.longtitude, f3, f2);
                }
                BaseLifeUI.this.ABk.ABf = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.ABs.LbD, BaseLifeUI.this.ABs.LbC);
                BaseLifeUI.this.ABl.ABf = new BackwardSupportUtil.ExifHelper.LatLongData(BaseLifeUI.this.ABs.LbD, BaseLifeUI.this.ABs.LbC);
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.khr ? BaseLifeUI.this.ABl : BaseLifeUI.this.ABk);
                BaseLifeUI.this.ss(false);
                BaseLifeUI.this.addSearchMenu(true, BaseLifeUI.this.gzP);
                AppMethodBeat.o(26572);
                return false;
            }
        }
    };
    private View ABi;
    private NearLifeErrorContent ABj;
    private a ABk;
    private a ABl;
    private View ABm;
    private TextView ABn;
    private TextView ABo;
    private com.tencent.mm.plugin.nearlife.b.d ABp;
    private int ABq;
    private List<chk> ABr;
    protected chk ABs = null;
    protected float ABt = 0.0f;
    protected float ABu = 0.0f;
    protected int ABv = 0;
    protected float ABw = 0.0f;
    protected long ABx = -1;
    protected long ABy = -1;
    protected long ABz = -1;
    protected String dPI = "";
    boolean gmw = false;
    protected s gzP;
    protected String hes = "";
    protected boolean iVk = true;
    boolean ifz = false;
    boolean khr = false;
    int sceneType = 0;
    private boolean uSq = false;
    private boolean uSu;
    private d uzs = d.bca();
    private int yFK = 1;
    public int yLS = -1;
    MMLoadMoreListView yLr;

    public abstract a exc();

    public abstract a exd();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public abstract void p(double d2, double d3);

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, a aVar) {
        if (baseLifeUI.ABs == null) {
            Log.e("MicroMsg.BaseLifeUI", "location is null");
            return;
        }
        HashMap hashMap = new HashMap();
        baseLifeUI.ABr.clear();
        if (aVar.ABg && baseLifeUI.ABs != null) {
            baseLifeUI.ABr.add(baseLifeUI.ABs);
            hashMap.put(new BackwardSupportUtil.ExifHelper.LatLongData(baseLifeUI.ABs.LbD, baseLifeUI.ABs.LbC), 1);
        }
        Iterator<BackwardSupportUtil.ExifHelper.LatLongData> it = aVar.ABb.iterator();
        while (it.hasNext()) {
            BackwardSupportUtil.ExifHelper.LatLongData next = it.next();
            if (!hashMap.containsKey(next)) {
                chk chk = new chk();
                chk.LuV = "";
                chk.LuW = 0;
                chk.LbD = next.latitude;
                chk.LbC = next.longtitude;
                chk.LuU = "";
                chk.LuT = 0;
                baseLifeUI.ABr.add(chk);
                hashMap.put(next, 1);
            }
        }
        baseLifeUI.ABp = null;
        baseLifeUI.ABq = -1;
        Log.i("MicroMsg.BaseLifeUI", "list size:" + baseLifeUI.ABr.size() + " show curpos: " + aVar.ABg);
    }

    public void exe() {
        Log.d("MicroMsg.BaseLifeUI", "init header");
        this.ABm = View.inflate(this, R.layout.yp, null);
        this.ABn = (TextView) this.ABm.findViewById(R.id.ix1);
        this.ABo = (TextView) this.ABm.findViewById(R.id.ix0);
        this.ABm.setOnClickListener(this.ABH);
        this.ABi = View.inflate(this, R.layout.bij, null);
        this.yLr.addFooterView(this.ABi);
        this.ABi.setVisibility(8);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ABF = getIntent().getBooleanExtra("poi_show_none", true);
        this.yLS = (int) (System.currentTimeMillis() / 1000);
        com.tencent.mm.plugin.nearlife.b.d.clear();
        bg.azz().a(603, this);
        this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
        this.dPI = getIntent().getStringExtra("request_id");
        this.ABr = new ArrayList();
        initView();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        this.yLr = (MMLoadMoreListView) findViewById(R.id.ftw);
        this.yLr.setFooterTips(getString(R.string.f_m));
        this.ABj = (NearLifeErrorContent) findViewById(R.id.ftv);
        exe();
        this.ABk = exc();
        this.ABl = exd();
        this.yLr.setAdapter((ListAdapter) this.ABk);
        this.ABj.setListView(this.yLr);
        this.ABk.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26562);
                BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.ABE);
                BaseLifeUI.this.finish();
                AppMethodBeat.o(26562);
                return true;
            }
        });
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(26563);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(BaseLifeUI.this.yLr);
                Object obj = new Object();
                a.a(obj, bl.axQ(), "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                a.a(obj, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26563);
            }
        });
        this.gzP = new s((byte) 0);
        this.gzP.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
                AppMethodBeat.i(26565);
                Log.d("MicroMsg.BaseLifeUI", "click clear");
                if (BaseLifeUI.this.ABp != null) {
                    bg.azz().a(BaseLifeUI.this.ABp);
                    BaseLifeUI.this.ABp = null;
                }
                BaseLifeUI.this.ABl.ewZ();
                BaseLifeUI.this.Tw(8);
                AppMethodBeat.o(26565);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(26566);
                Log.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", str);
                if (Util.isNullOrNil(str)) {
                    bnA();
                    AppMethodBeat.o(26566);
                    return;
                }
                BaseLifeUI.a(BaseLifeUI.this, str);
                AppMethodBeat.o(26566);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
                AppMethodBeat.i(26567);
                Log.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                BaseLifeUI.this.khr = false;
                BaseLifeUI.this.yLr.setAdapter((ListAdapter) BaseLifeUI.this.ABk);
                BaseLifeUI.this.ABk.notifyDataSetChanged();
                BaseLifeUI.this.ABj.Tx(BaseLifeUI.this.ABk.ABh);
                if (!BaseLifeUI.this.ABk.exb() && BaseLifeUI.this.ABi != null) {
                    BaseLifeUI.this.ABi.setVisibility(0);
                }
                BaseLifeUI.this.yLr.setOnTouchListener(null);
                BaseLifeUI.this.Tw(8);
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.ABk);
                AppMethodBeat.o(26567);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
                AppMethodBeat.i(26568);
                Log.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                BaseLifeUI.this.ABB = true;
                BaseLifeUI.this.gzP.setHint(BaseLifeUI.this.getString(R.string.f_l));
                BaseLifeUI.this.khr = true;
                BaseLifeUI.this.ABl.ewZ();
                BaseLifeUI.this.yLr.setAdapter((ListAdapter) BaseLifeUI.this.ABl);
                BaseLifeUI.this.ABl.notifyDataSetChanged();
                BaseLifeUI.this.yLr.gKN();
                BaseLifeUI.this.ABj.Tx(BaseLifeUI.this.ABl.ABh);
                if (BaseLifeUI.this.ABi != null) {
                    BaseLifeUI.this.ABi.setVisibility(8);
                }
                BaseLifeUI.this.yLr.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass5.AnonymousClass1 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(26564);
                        BaseLifeUI.this.hideVKB();
                        AppMethodBeat.o(26564);
                        return false;
                    }
                });
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.ABl);
                AppMethodBeat.o(26568);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                AppMethodBeat.i(26569);
                Log.d("MicroMsg.BaseLifeUI", "search key click");
                BaseLifeUI.b(BaseLifeUI.this, str);
                AppMethodBeat.o(26569);
                return false;
            }
        };
        this.yLr.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(26570);
                BaseLifeUI.a(BaseLifeUI.this);
                AppMethodBeat.o(26570);
            }
        });
        this.yLr.gKM();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.ABk.notifyDataSetChanged();
        this.yLr.gKO();
        if (this.uzs != null) {
            this.uzs.a(this.ABI, true);
        }
        this.ifz = false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        bg.azz().b(603, this);
        super.onDestroy();
        if (this.uzs != null) {
            this.uzs.c(this.ABI);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.uzs.c(this.ABI);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bex;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean ss(boolean z) {
        int b2;
        SKBuiltinBuffer_t a2;
        while (this.ABp == null) {
            if (this.ABr.size() - 1 <= this.ABq) {
                this.ABq = -1;
                Log.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            this.ABq++;
            chk chk = this.ABr.get(this.ABq);
            if (this.ABq == 0) {
                this.ABA++;
            }
            if (this.khr) {
                b2 = this.ABl.b(new BackwardSupportUtil.ExifHelper.LatLongData(chk.LbD, chk.LbC));
                continue;
            } else {
                b2 = this.ABk.b(new BackwardSupportUtil.ExifHelper.LatLongData(chk.LbD, chk.LbC));
                continue;
            }
            if (b2 > 0) {
                if (this.khr) {
                    a2 = this.ABl.a(new BackwardSupportUtil.ExifHelper.LatLongData(chk.LbD, chk.LbC));
                } else {
                    a2 = this.ABk.a(new BackwardSupportUtil.ExifHelper.LatLongData(chk.LbD, chk.LbC));
                }
                int i2 = this.khr ? 1 : 0;
                if (!com.tencent.mm.plugin.nearlife.b.d.Tt(i2)) {
                    this.ABq = -1;
                    return false;
                }
                if (-1 == this.ABx) {
                    this.ABx = System.currentTimeMillis();
                }
                this.ABp = new com.tencent.mm.plugin.nearlife.b.d(i2, this.sceneType, chk.LbC, chk.LbD, chk.LuT, chk.LuW, chk.LuU, chk.LuV, a2, this.khr ? this.ABl.exa() : "", this.yLS, z, false);
                bg.azz().a(this.ABp, 0);
                Log.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", Integer.valueOf(this.ABq), Float.valueOf(chk.LbD), Float.valueOf(chk.LbC));
                return true;
            }
        }
        Log.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        a aVar;
        a aVar2;
        a aVar3;
        Bitmap bitmap;
        if (qVar.getType() == 603) {
            this.yLr.gKN();
            com.tencent.mm.plugin.nearlife.b.d dVar = (com.tencent.mm.plugin.nearlife.b.d) qVar;
            if (!Util.isNullOrNil(dVar.AAU)) {
                this.AAU = dVar.AAU;
                LogoImageView logoImageView = (LogoImageView) this.ABi.findViewById(R.id.gmd);
                String str2 = this.AAU;
                bg.aVF();
                logoImageView.imagePath = c.aSZ();
                logoImageView.url = str2;
                logoImageView.targetWidth = 0;
                logoImageView.targetHeight = 0;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    Bitmap decodeFile = BitmapFactory.decodeFile(logoImageView.imagePath + g.getMessageDigest(str2.getBytes()));
                    if (decodeFile != null) {
                        if (logoImageView.targetWidth > 0 && logoImageView.targetHeight > 0) {
                            decodeFile = BitmapUtil.extractThumbNail(decodeFile, logoImageView.targetWidth, logoImageView.targetHeight, true, false);
                        }
                        logoImageView.setImageBitmap(decodeFile);
                    } else {
                        ThreadPool.post(new LogoImageView.a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (!com.tencent.mm.vfs.s.YS(str2)) {
                    logoImageView.setVisibility(8);
                } else {
                    if (logoImageView.targetWidth <= 0 || logoImageView.targetHeight <= 0) {
                        bitmap = BitmapUtil.getBitmapNative(str2);
                    } else {
                        bitmap = BitmapUtil.extractThumbNail(str2, logoImageView.targetWidth, logoImageView.targetHeight, true);
                    }
                    if (bitmap == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(bitmap);
                    }
                }
            }
            this.hes = dVar.hes;
            this.yFK = dVar.yFK;
            int i4 = ((com.tencent.mm.plugin.nearlife.b.d) qVar).dJY;
            com.tencent.mm.plugin.nearlife.b.d.Tu(i4);
            if (this.ABp == null) {
                Log.d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            Log.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", Integer.valueOf(this.ABq), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4));
            boolean z = i3 == 0 || i3 == 101;
            if (i2 == 0 || z) {
                if (-1 == this.ABy) {
                    this.ABy = System.currentTimeMillis();
                }
                this.ABz = System.currentTimeMillis();
                List<com.tencent.mm.plugin.nearlife.b.b> list = dVar.AAV;
                chk chk = this.ABr.get(this.ABq);
                BackwardSupportUtil.ExifHelper.LatLongData latLongData = new BackwardSupportUtil.ExifHelper.LatLongData(chk.LbD, chk.LbC);
                if (this.khr && !this.ABp.AAW) {
                    this.ABl.ewZ();
                }
                if (this.khr) {
                    this.ABl.a(latLongData, dVar.cYA(), dVar.ewY());
                } else {
                    this.ABk.a(latLongData, dVar.cYA(), dVar.ewY());
                }
                if (list == null || list.size() == 0) {
                    if (this.khr) {
                        aVar = this.ABl;
                    } else {
                        aVar = this.ABk;
                    }
                    if (this.ABr.size() - 1 == this.ABq) {
                        if (aVar.getCount() == 0) {
                            this.ABj.Tx(aVar.ABh);
                        }
                        this.yLr.gKN();
                        if (!aVar.exb() && i3 != 101) {
                            exf();
                        }
                    }
                } else {
                    if (this.khr) {
                        aVar2 = this.ABl;
                    } else {
                        aVar2 = this.ABk;
                    }
                    this.yLr.setVisibility(0);
                    aVar2.ABh = 0;
                    this.ABj.Tx(this.ABl.ABh);
                    aVar2.a(latLongData, list);
                    aVar2.notifyDataSetChanged();
                    if (this.ABr.size() - 1 == this.ABq && !aVar2.exb()) {
                        this.yLr.gKN();
                        exf();
                    }
                }
                if (!this.ABk.exb() && this.ABi != null && !this.khr) {
                    this.ABi.setVisibility(0);
                }
                if (this.ABi != null && !this.khr) {
                    this.ABi.setVisibility(0);
                } else if (this.ABi != null) {
                    this.ABi.setVisibility(8);
                }
            } else {
                Log.d("MicroMsg.BaseLifeUI", "error");
                if (this.khr) {
                    aVar3 = this.ABl;
                } else {
                    aVar3 = this.ABk;
                }
                if (this.ABr.size() - 1 == this.ABq && aVar3.getCount() == 0) {
                    aVar3.ABh = 1;
                    this.ABj.Tx(aVar3.ABh);
                }
            }
            this.ABp = null;
            ss(false);
        }
    }

    private void exf() {
        if (!this.khr) {
            Log.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
            return;
        }
        try {
            int intValue = Integer.valueOf(com.tencent.mm.n.h.aqJ().getValue("POICreateForbiden")).intValue();
            Log.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", Integer.valueOf(intValue));
            if (intValue == 1) {
                return;
            }
        } catch (Exception e2) {
        }
        if (!this.ABl.aIw(this.ABl.exa())) {
            this.ABn.setText(String.format(getResources().getString(R.string.fda), this.ABl.exa()));
            Tw(0);
            return;
        }
        Tw(8);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -1) {
            switch (i2) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, boolean z, String str, boolean z2) {
        int i3;
        String str2;
        String format;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        String str3 = "";
        if (i2 >= 0) {
            i3 = z ? z2 ? 43 : 3 : z2 ? 41 : 1;
            if (this.ABD) {
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                hVar.a(11139, objArr);
            }
            if (z) {
                str3 = this.ABl.getItem(i2).yMY;
                if (this.ABl.getCount() > 0) {
                    str2 = this.ABl.getItem(1).dPI;
                }
                str2 = "";
            } else {
                str3 = this.ABk.getItem(i2).yMY;
                if (this.ABk.getCount() > 0) {
                    str2 = this.ABk.getItem(1).dPI;
                }
                str2 = "";
            }
            if (Util.isNullOrNil(str2)) {
                str2 = this.dPI;
            }
        } else {
            i3 = this.ABB ? z2 ? 44 : 4 : z2 ? 42 : 2;
            str2 = "";
        }
        if (this.ABs == null) {
            format = "null/null";
        } else {
            format = String.format("%f/%f", Float.valueOf(this.ABs.LbD), Float.valueOf(this.ABs.LbC));
        }
        Log.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", Integer.valueOf(i2 + 1), str, Integer.valueOf(i2), str3, str2);
        h.INSTANCE.a(11135, Integer.valueOf(i3), Integer.valueOf(i2 + 1), Long.valueOf(this.ABx), Long.valueOf(this.ABz), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.ABy), Integer.valueOf(this.ABA), format, str, Integer.valueOf(this.yLS), str3, com.tencent.mm.compatible.deviceinfo.q.dr(true), 0, 0, 0, "", 0, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Tw(int i2) {
        this.yLr.removeFooterView(this.ABi);
        this.yLr.removeFooterView(this.ABm);
        this.yLr.gKP();
        this.ABm.setVisibility(i2);
        this.ABn.setVisibility(i2);
        this.ABo.setVisibility(i2);
        if (i2 == 0) {
            this.yLr.addFooterView(this.ABm);
            return;
        }
        this.yLr.gKL();
        this.yLr.addFooterView(this.ABi);
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.ABq != -1 || baseLifeUI.ABp != null) {
            Log.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.ss(true)) {
            baseLifeUI.yLr.gKO();
        }
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, String str) {
        chk chk;
        Log.d("MicroMsg.BaseLifeUI", "do auto query");
        baseLifeUI.Tw(8);
        if (baseLifeUI.yFK <= 0) {
            Log.i("MicroMsg.BaseLifeUI", "block by autoQueryInterval: %d", Integer.valueOf(baseLifeUI.yFK));
            return;
        }
        if (baseLifeUI.ABp != null) {
            bg.azz().a(baseLifeUI.ABp);
            baseLifeUI.ABp = null;
        }
        if (baseLifeUI.ABr.size() > 0) {
            chk = baseLifeUI.ABr.get(0);
        } else {
            Log.i("MicroMsg.BaseLifeUI", "empty lbslist");
            chk = new chk();
        }
        baseLifeUI.ABq = 0;
        baseLifeUI.ABl.aIu(str);
        baseLifeUI.ABp = new com.tencent.mm.plugin.nearlife.b.d(1, baseLifeUI.sceneType, chk.LbC, chk.LbD, chk.LuT, chk.LuW, chk.LuU, chk.LuV, null, baseLifeUI.khr ? baseLifeUI.ABl.exa() : "", baseLifeUI.yLS, false, true);
        bg.azz().a(baseLifeUI.ABp, 0);
    }

    static /* synthetic */ void b(BaseLifeUI baseLifeUI, String str) {
        if (Util.isNullOrNil(str)) {
            return;
        }
        if (baseLifeUI.ABp == null || !str.equals(baseLifeUI.ABp.AAT)) {
            baseLifeUI.Tw(8);
            if (baseLifeUI.ABp != null) {
                bg.azz().a(baseLifeUI.ABp);
            }
            if (baseLifeUI.ABs != null) {
                baseLifeUI.ABl.ewZ();
                baseLifeUI.ABl.aIu(str);
                baseLifeUI.ss(false);
                baseLifeUI.yLr.gKO();
            }
        }
    }

    static /* synthetic */ boolean p(float f2, float f3, float f4, float f5) {
        return com.tencent.mm.pluginsdk.s.c((double) f2, (double) f3, (double) f4, (double) f5) > 1000.0d;
    }
}
