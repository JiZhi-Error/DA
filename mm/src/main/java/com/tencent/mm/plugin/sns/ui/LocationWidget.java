package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends LinearLayout {
    private b.a ABI;
    private chj ABY;
    private float ABu;
    private TextView EpI;
    private View ErT;
    private View ErU;
    private int[] ErV;
    private ImageView[] ErW;
    private int ErX;
    private TextView ErY;
    private String ErZ;
    private String Esa;
    private int Esb;
    private float Esc;
    private int Esd;
    private a Ese;
    private boolean Esf;
    private b Esg;
    private float cjn;
    private byte[] ctx;
    private String dPI;
    private String fuK;
    private float iUY;
    private float iUZ;
    private boolean iVk;
    private String kHV;
    private Activity mContext;
    private int score;
    private int showFlag;
    private ImageView uzC;
    private d uzs;
    private c.a yFD;
    private c yKY;

    public interface a {
        ArrayList<Exif.a> ffS();

        boolean ffT();
    }

    static /* synthetic */ int b(LocationWidget locationWidget) {
        int i2 = locationWidget.score;
        locationWidget.score = i2 - 1;
        return i2;
    }

    static /* synthetic */ void c(LocationWidget locationWidget) {
        AppMethodBeat.i(97953);
        locationWidget.ffO();
        AppMethodBeat.o(97953);
    }

    static /* synthetic */ void f(LocationWidget locationWidget) {
        AppMethodBeat.i(97954);
        locationWidget.ffQ();
        AppMethodBeat.o(97954);
    }

    public LocationWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(97940);
        this.ErV = new int[]{R.id.hbg, R.id.hbh, R.id.hbi, R.id.hbj, R.id.hbk};
        this.ErW = new ImageView[5];
        this.iUY = -1000.0f;
        this.iUZ = -1000.0f;
        this.Esb = 0;
        this.ABY = null;
        this.showFlag = 0;
        this.Esc = 0.0f;
        this.ABu = 0.0f;
        this.cjn = 0.0f;
        this.Esd = -1;
        this.iVk = true;
        this.uzs = d.bca();
        this.Ese = null;
        this.Esf = false;
        this.yFD = new c.a() {
            /* class com.tencent.mm.plugin.sns.ui.LocationWidget.AnonymousClass3 */

            @Override // com.tencent.mm.modelgeo.c.a
            public final void b(Addr addr) {
                AppMethodBeat.i(97938);
                Log.i("MicroMsg.LocationWidget", "get info %s", addr.toString());
                if (!LocationWidget.this.Esf) {
                    AppMethodBeat.o(97938);
                    return;
                }
                LocationWidget.f(LocationWidget.this);
                if (!Util.isNullOrNil(LocationWidget.this.fuK)) {
                    AppMethodBeat.o(97938);
                    return;
                }
                LocationWidget.this.fuK = addr.iUQ;
                LocationWidget.f(LocationWidget.this);
                AppMethodBeat.o(97938);
            }
        };
        this.ABI = new b.a() {
            /* class com.tencent.mm.plugin.sns.ui.LocationWidget.AnonymousClass4 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                boolean z2;
                AppMethodBeat.i(97939);
                if (!z) {
                    AppMethodBeat.o(97939);
                    return true;
                }
                Log.d("MicroMsg.LocationWidget", "get location %f %f", Float.valueOf(f3), Float.valueOf(f2));
                e bge = e.bge();
                boolean z3 = i2 != 0;
                if (LocationWidget.this.uzs == null) {
                    z2 = false;
                } else {
                    z2 = LocationWidget.this.uzs.iVk;
                }
                bge.a(2003, z3, z2, f2, f3, (int) d3);
                o.a(2003, f2, f3, 0);
                if (!LocationWidget.this.Esf) {
                    AppMethodBeat.o(97939);
                    return false;
                }
                if (LocationWidget.this.iUY == -1000.0f || LocationWidget.this.iUZ == -1000.0f) {
                    LocationWidget.this.iUY = f3;
                    LocationWidget.this.iUZ = f2;
                }
                AppMethodBeat.o(97939);
                return false;
            }
        };
        this.Esg = null;
        n((MMActivity) context);
        AppMethodBeat.o(97940);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97941);
        this.ErV = new int[]{R.id.hbg, R.id.hbh, R.id.hbi, R.id.hbj, R.id.hbk};
        this.ErW = new ImageView[5];
        this.iUY = -1000.0f;
        this.iUZ = -1000.0f;
        this.Esb = 0;
        this.ABY = null;
        this.showFlag = 0;
        this.Esc = 0.0f;
        this.ABu = 0.0f;
        this.cjn = 0.0f;
        this.Esd = -1;
        this.iVk = true;
        this.uzs = d.bca();
        this.Ese = null;
        this.Esf = false;
        this.yFD = new c.a() {
            /* class com.tencent.mm.plugin.sns.ui.LocationWidget.AnonymousClass3 */

            @Override // com.tencent.mm.modelgeo.c.a
            public final void b(Addr addr) {
                AppMethodBeat.i(97938);
                Log.i("MicroMsg.LocationWidget", "get info %s", addr.toString());
                if (!LocationWidget.this.Esf) {
                    AppMethodBeat.o(97938);
                    return;
                }
                LocationWidget.f(LocationWidget.this);
                if (!Util.isNullOrNil(LocationWidget.this.fuK)) {
                    AppMethodBeat.o(97938);
                    return;
                }
                LocationWidget.this.fuK = addr.iUQ;
                LocationWidget.f(LocationWidget.this);
                AppMethodBeat.o(97938);
            }
        };
        this.ABI = new b.a() {
            /* class com.tencent.mm.plugin.sns.ui.LocationWidget.AnonymousClass4 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                boolean z2;
                AppMethodBeat.i(97939);
                if (!z) {
                    AppMethodBeat.o(97939);
                    return true;
                }
                Log.d("MicroMsg.LocationWidget", "get location %f %f", Float.valueOf(f3), Float.valueOf(f2));
                e bge = e.bge();
                boolean z3 = i2 != 0;
                if (LocationWidget.this.uzs == null) {
                    z2 = false;
                } else {
                    z2 = LocationWidget.this.uzs.iVk;
                }
                bge.a(2003, z3, z2, f2, f3, (int) d3);
                o.a(2003, f2, f3, 0);
                if (!LocationWidget.this.Esf) {
                    AppMethodBeat.o(97939);
                    return false;
                }
                if (LocationWidget.this.iUY == -1000.0f || LocationWidget.this.iUZ == -1000.0f) {
                    LocationWidget.this.iUY = f3;
                    LocationWidget.this.iUZ = f2;
                }
                AppMethodBeat.o(97939);
                return false;
            }
        };
        this.Esg = null;
        n((MMActivity) context);
        AppMethodBeat.o(97941);
    }

    private void n(MMActivity mMActivity) {
        AppMethodBeat.i(97942);
        this.mContext = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.ErT = inflate.findViewById(R.id.eq7);
        this.ErY = (TextView) this.ErT.findViewById(R.id.eqx);
        this.EpI = (TextView) this.ErT.findViewById(R.id.eqm);
        this.uzC = (ImageView) this.ErT.findViewById(R.id.eqe);
        this.ErU = inflate.findViewById(R.id.hbe);
        for (final int i2 = 0; i2 < 5; i2++) {
            this.ErW[i2] = (ImageView) this.ErU.findViewById(this.ErV[i2]);
            this.ErW[i2].setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.LocationWidget.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(97936);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (LocationWidget.this.score == i2 + 1) {
                        LocationWidget.b(LocationWidget.this);
                    } else {
                        LocationWidget.this.score = i2 + 1;
                    }
                    LocationWidget.c(LocationWidget.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97936);
                }
            });
        }
        this.yKY = c.bbX();
        this.ErT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.LocationWidget.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(97937);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97937);
                    return;
                }
                if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                    if (!(com.tencent.mm.pluginsdk.permission.b.n(LocationWidget.this.mContext, "android.permission.ACCESS_FINE_LOCATION") && com.tencent.mm.pluginsdk.permission.b.n(LocationWidget.this.mContext, "android.permission.ACCESS_COARSE_LOCATION"))) {
                        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                            com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.this.mContext, LocationWidget.this.getResources().getString(R.string.el_, LocaleUtil.getApplicationLanguage()), 30764, true);
                        } else {
                            com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.this.mContext, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 64);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(97937);
                        return;
                    }
                } else {
                    boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.this.mContext, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 64, (String) null, (String) null);
                    Log.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                    if (!a2) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(97937);
                        return;
                    }
                }
                LocationWidget.this.ffP();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LocationWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97937);
            }
        });
        this.Esa = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!Util.isNullOrNil(this.Esa)) {
            this.iUY = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.iUZ = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.kHV = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.ErZ = mMActivity.getIntent().getStringExtra("Kpoi_address");
            ffQ();
        }
        if (g.aAf().azp()) {
            this.ErX = Util.getInt(h.aqJ().getValue("SnsPostPOICommentSwitch"), 0);
        } else {
            this.ErX = 0;
        }
        ffO();
        AppMethodBeat.o(97942);
    }

    private void ffO() {
        AppMethodBeat.i(97943);
        Log.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", Integer.valueOf(this.ErX), this.Esa, Integer.valueOf(this.Esb), Integer.valueOf(this.showFlag), Boolean.valueOf(WeChatLocaleUtil.isOverseasUserByWechatLanguage()));
        if (WeChatLocaleUtil.isOverseasUserByWechatLanguage() || this.ErX == 0 || Util.isNullOrNil(this.Esa) || this.Esb == 1 || (this.showFlag & 1) == 0) {
            this.ErU.setVisibility(8);
            AppMethodBeat.o(97943);
            return;
        }
        this.ErU.setVisibility(0);
        for (int i2 = 0; i2 < this.score; i2++) {
            this.ErW[i2].setImageResource(getSelectedStarImageResource());
        }
        for (int i3 = this.score; i3 < 5; i3++) {
            this.ErW[i3].setImageResource(getNormalStarImageResource());
        }
        AppMethodBeat.o(97943);
    }

    public final void ffP() {
        ArrayList<Exif.a> ffS;
        AppMethodBeat.i(97944);
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.ABY.toByteArray());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LocationWidget", e2, "", new Object[0]);
        }
        if (!Util.isNullOrNil(this.Esa)) {
            intent.putExtra("get_poi_classify_id", this.Esa);
        } else if (!Util.isNullOrNil(this.fuK)) {
            intent.putExtra("get_city", this.fuK);
        }
        intent.putExtra("get_lat", this.iUY);
        intent.putExtra("get_lng", this.iUZ);
        intent.putExtra("request_id", this.dPI);
        if (!(this.Ese == null || (ffS = this.Ese.ffS()) == null)) {
            aP(ffS);
            ArrayList arrayList = new ArrayList();
            Iterator<Exif.a> it = ffS.iterator();
            while (it.hasNext()) {
                Exif.a next = it.next();
                arrayList.add(String.format("%f\n%f", Double.valueOf(next.latitude), Double.valueOf(next.longitude)));
            }
        }
        com.tencent.mm.br.c.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
        AppMethodBeat.o(97944);
    }

    private void aP(ArrayList<Exif.a> arrayList) {
        boolean z;
        AppMethodBeat.i(97945);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(97945);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11139, "1");
        if (((double) Math.abs(-1000.0f - this.iUY)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.iUZ)) > 1.0E-6d) {
            Exif.a aVar = arrayList.get(arrayList.size() - 1);
            if (b(aVar.latitude, aVar.longitude, (double) this.iUY, (double) this.iUZ)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11139, "2");
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int i3 = i2 + 1;
            while (true) {
                if (i3 >= arrayList.size()) {
                    z = true;
                    break;
                }
                Exif.a aVar2 = arrayList.get(i2);
                Exif.a aVar3 = arrayList.get(i3);
                if (b(aVar2.latitude, aVar2.longitude, aVar3.latitude, aVar3.longitude)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11139, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    z = false;
                    break;
                }
                i3++;
            }
            if (!z) {
                break;
            }
        }
        AppMethodBeat.o(97945);
    }

    private static boolean b(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(97946);
        if (s.c(d2, d3, d4, d5) > 1000.0d) {
            AppMethodBeat.o(97946);
            return true;
        }
        AppMethodBeat.o(97946);
        return false;
    }

    public final void stop() {
        AppMethodBeat.i(97947);
        if (this.uzs != null) {
            this.uzs.c(this.ABI);
        }
        if (this.yKY != null) {
            this.yKY.a(this.yFD);
        }
        AppMethodBeat.o(97947);
    }

    public final boolean aY(Intent intent) {
        AppMethodBeat.i(97948);
        if (intent == null) {
            AppMethodBeat.o(97948);
        } else {
            this.Esb = intent.getIntExtra("get_poi_classify_type", 0);
            this.showFlag = intent.getIntExtra("get_poi_showflag", 0);
            Log.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", Integer.valueOf(this.Esb));
            this.kHV = Util.nullAs(intent.getStringExtra("get_poi_name"), "");
            this.fuK = Util.nullAs(intent.getStringExtra("get_city"), "");
            this.iUY = intent.getFloatExtra("get_lat", -1000.0f);
            this.iUZ = intent.getFloatExtra("get_lng", -1000.0f);
            Log.i("MicroMsg.LocationWidget", "check cur lat " + this.Esc + " " + this.ABu);
            this.Esc = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.ABu = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.Esd = intent.getIntExtra("get_loctype", -1);
            this.cjn = intent.getFloatExtra("get_accuracy", 0.0f);
            this.iVk = intent.getBooleanExtra("get_is_mars", true);
            this.dPI = intent.getStringExtra("request_id");
            e.bge().a(2003, this.Esd != 0, this.iVk, this.iUZ, this.iUY, (int) this.cjn);
            this.ctx = intent.getByteArrayExtra("location_ctx");
            if (!Util.isNullOrNil(this.kHV)) {
                this.ErZ = Util.nullAs(intent.getStringExtra("get_poi_address"), "");
                this.Esa = Util.nullAs(intent.getStringExtra("get_poi_classify_id"), "");
                this.ABY = new chj();
                try {
                    this.ABY = (chj) this.ABY.parseFrom(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LocationWidget", e2, "", new Object[0]);
                    this.ABY = null;
                }
                if (!Util.isNullOrNil(this.Esa)) {
                    this.ABY = new chj();
                    this.ABY.AAG = this.Esa;
                    this.ABY.oUv = this.Esb;
                    this.ABY.Title = this.kHV;
                    this.ABY.AAL.add(new dqi().bhy(this.ErZ));
                }
            } else if (!Util.isNullOrNil(this.fuK)) {
                this.kHV = "";
                this.ErZ = "";
                this.Esa = "";
                this.ABY = null;
            } else {
                this.iUY = -1000.0f;
                this.iUZ = -1000.0f;
                this.kHV = "";
                this.ErZ = "";
                this.fuK = "";
                this.Esa = "";
                this.ABY = null;
            }
            Log.d("MicroMsg.LocationWidget", "label %s poiname %s", this.ErZ, this.kHV);
            ffQ();
            ffO();
            this.Esg = new b();
            b bVar = this.Esg;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.ABx = intent.getLongExtra("first_start_time", 0);
                bVar.ABy = intent.getLongExtra("lastSuccStamp", 0);
                bVar.ABz = intent.getLongExtra("firstSuccStamp", 0);
                bVar.ABA = intent.getIntExtra("reqLoadCnt", 0);
                bVar.yLS = intent.getIntExtra("entry_time", 0);
                bVar.hes = intent.getStringExtra("search_id");
            }
            AppMethodBeat.o(97948);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public class b {
        int ABA = 0;
        long ABx = -1;
        long ABy = -1;
        long ABz = -1;
        String hes = "";
        int index;
        int yLS = 0;

        b() {
        }
    }

    private void ffQ() {
        AppMethodBeat.i(97949);
        if (!(this.ErY == null || this.EpI == null)) {
            if (!Util.isNullOrNil(this.kHV)) {
                this.ErY.setText(this.kHV);
                this.ErY.setTextColor(getResources().getColor(R.color.ts));
                this.EpI.setVisibility(8);
            } else if (!Util.isNullOrNil(this.fuK)) {
                this.ErY.setText(this.fuK);
                this.ErY.setTextColor(getResources().getColor(R.color.ts));
                this.EpI.setVisibility(8);
            } else {
                this.ErY.setText(R.string.h83);
                this.ErY.setTextColor(getResources().getColor(R.color.a2x));
                this.EpI.setVisibility(8);
            }
        }
        if (!Util.isNullOrNil(this.kHV) || !Util.isNullOrNil(this.fuK)) {
            this.uzC.setImageDrawable(com.tencent.mm.ui.ar.m(this.mContext, R.raw.album_location_icon_pressed, getContext().getResources().getColor(R.color.afp)));
            AppMethodBeat.o(97949);
            return;
        }
        this.uzC.setImageDrawable(com.tencent.mm.ui.ar.m(this.mContext, R.raw.album_location_icon_normal, getContext().getResources().getColor(R.color.vm)));
        AppMethodBeat.o(97949);
    }

    /* access modifiers changed from: protected */
    public int getNormalStateImageResource() {
        return R.raw.album_location_icon_normal;
    }

    /* access modifiers changed from: protected */
    public int getSelectedStateImageResource() {
        return R.raw.album_location_icon_pressed;
    }

    /* access modifiers changed from: protected */
    public int getNormalStarImageResource() {
        return R.raw.sns_shoot_star_normal;
    }

    /* access modifiers changed from: protected */
    public int getSelectedStarImageResource() {
        return R.raw.sns_shoot_star_selected;
    }

    public cjy getLocation() {
        AppMethodBeat.i(97950);
        cjy cjy = new cjy();
        cjy.LbD = this.iUY;
        cjy.LbC = this.iUZ;
        cjy.Mpv = 0;
        cjy.score = this.score;
        if (this.ctx != null) {
            cjy.Mpw = new com.tencent.mm.bw.b(this.ctx);
        }
        if (!Util.isNullOrNil(this.kHV)) {
            cjy.ErZ = this.ErZ;
            cjy.kHV = this.kHV;
            cjy.LIb = this.Esa;
            cjy.kea = this.fuK;
            if (this.Esb == 0 || this.Esb != 1) {
                cjy.Esb = 1;
            } else {
                cjy.Esb = 2;
            }
            Log.d("MicroMsg.LocationWidget", "getlocation type %d", Integer.valueOf(cjy.Esb));
        } else if (!Util.isNullOrNil(this.fuK)) {
            cjy.kea = this.fuK;
        }
        if (this.Esg != null) {
            String format = String.format("%f/%f", Float.valueOf(cjy.LbD), Float.valueOf(cjy.LbC));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.Esg.index);
            stringBuffer.append("firstStartStamp " + this.Esg.ABx);
            stringBuffer.append("lastSuccStamp " + this.Esg.ABz);
            stringBuffer.append("firstSuccStamp " + this.Esg.ABy);
            stringBuffer.append("reqLoadCnt " + this.Esg.ABA);
            stringBuffer.append("classifyId " + this.Esa);
            stringBuffer.append("entryTime " + this.Esg.yLS);
            stringBuffer.append("searchId" + this.Esg.hes);
            Log.d("MicroMsg.LocationWidget", "report %s", stringBuffer.toString());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11135, 5, Integer.valueOf(this.Esg.index + 1), Long.valueOf(this.Esg.ABx), Long.valueOf(this.Esg.ABz), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Esg.ABy), Integer.valueOf(this.Esg.ABA), format, this.Esa, Integer.valueOf(this.Esg.yLS), this.Esg.hes, q.dr(true));
        }
        ffR();
        AppMethodBeat.o(97950);
        return cjy;
    }

    public int getShowFlag() {
        return this.showFlag;
    }

    public cjy getCurLocation() {
        AppMethodBeat.i(97951);
        cjy cjy = new cjy();
        cjy.LbD = this.Esc;
        cjy.LbC = this.ABu;
        cjy.cjn = this.cjn;
        cjy.Esd = this.Esd;
        AppMethodBeat.o(97951);
        return cjy;
    }

    private void ffR() {
        int i2;
        AppMethodBeat.i(97952);
        if (this.Ese != null) {
            boolean ffT = this.Ese.ffT();
            ArrayList<Exif.a> ffS = this.Ese.ffS();
            if (ffS == null || ffS.size() == 0) {
                AppMethodBeat.o(97952);
                return;
            }
            Iterator<Exif.a> it = ffS.iterator();
            while (it.hasNext()) {
                Exif.a next = it.next();
                Log.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", Double.valueOf(next.latitude), Double.valueOf(next.longitude));
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf((int) (next.latitude * 1000000.0d));
                objArr[1] = Integer.valueOf((int) (next.longitude * 1000000.0d));
                if (ffT) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = 2;
                hVar.a(11345, objArr);
            }
        }
        AppMethodBeat.o(97952);
    }

    public void setLocationWidgetListener(a aVar) {
        this.Ese = aVar;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.b2f;
    }
}
