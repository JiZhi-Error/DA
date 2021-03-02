package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.nearlife.ui.b;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI extends BaseLifeUI implements i {
    private boolean ABE = false;
    private String ABO = "";
    private b ABU;
    private b ABV;
    private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ABW;
    private c ABX = null;
    private chj ABY;
    private View.OnClickListener ABZ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(26578);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/CheckInLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CheckInLifeUI.a(CheckInLifeUI.this, view, true);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/CheckInLifeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26578);
        }
    };
    private c.a ACa = new c.a() {
        /* class com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI.AnonymousClass3 */

        @Override // com.tencent.mm.modelgeo.c.a
        public final void b(Addr addr) {
            AppMethodBeat.i(26579);
            Log.i("MicroMsg.CheckInLifeUI", "get info %s", addr.toString());
            if (!Util.isNullOrNil(CheckInLifeUI.this.fuK)) {
                AppMethodBeat.o(26579);
                return;
            }
            CheckInLifeUI.this.fuK = addr.iUQ;
            if (!Util.isNullOrNil(CheckInLifeUI.this.fuK) && CheckInLifeUI.this.Vaw) {
                CheckInLifeUI.this.ABU.jd(CheckInLifeUI.this.fuK, addr.request_id);
            }
            AppMethodBeat.o(26579);
        }
    };
    private boolean Vav = false;
    private boolean Vaw = true;
    private String fuK = "";
    String ixw;
    private View.OnClickListener qOH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(26577);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/nearlife/ui/CheckInLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CheckInLifeUI.a(CheckInLifeUI.this, view, false);
            a.a(this, "com/tencent/mm/plugin/nearlife/ui/CheckInLifeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26577);
        }
    };

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CheckInLifeUI() {
        AppMethodBeat.i(26580);
        AppMethodBeat.o(26580);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.nearlife.ui.BaseLifeUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26581);
        this.Vav = getIntent().getBooleanExtra("is_force_dark_mode", false);
        this.Vaw = getIntent().getBooleanExtra("show_city", true);
        super.onCreate(bundle);
        setMMTitle(R.string.f_f);
        this.ABX = c.bbX();
        this.ABY = new chj();
        this.ABO = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.ABY = (chj) this.ABY.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.ABY != null) {
                this.ABO = this.ABY.AAG;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CheckInLifeUI", e2, "", new Object[0]);
            this.ABY = null;
        }
        if (Util.isNullOrNil(this.ABO)) {
            this.fuK = getIntent().getStringExtra("get_city");
        }
        if (!Util.isNullOrNil(this.fuK) && this.Vaw) {
            this.ABO = this.ABU.jd(this.fuK, "").AAG;
        }
        this.ABU.ABO = this.ABO;
        if (this.ABY != null && !Util.isNullOrNil(this.ABY.AAG)) {
            b bVar = this.ABU;
            com.tencent.mm.plugin.nearlife.b.b bVar2 = new com.tencent.mm.plugin.nearlife.b.b("", this.ABY);
            if (bVar.ABM == null) {
                bVar.a(bVar2, 1);
            } else {
                bVar.a(bVar2, 2);
            }
        }
        if (this.Vav) {
            setActionbarColor(getContext().getResources().getColor(R.color.ko));
            setBackBtnColorFilter(-1);
            setMMTitleColor(-1);
            this.yLr.setBackgroundColor(getContext().getResources().getColor(R.color.w));
            setBackGroundColorResource(R.color.w);
            setIsDarkActionbarBg(true);
            this.gzP.VlU = true;
        }
        AppMethodBeat.o(26581);
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
    public final void exe() {
        AppMethodBeat.i(26582);
        super.exe();
        AppMethodBeat.o(26582);
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(26583);
        super.onResume();
        AppMethodBeat.o(26583);
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26584);
        super.onDestroy();
        if (this.ABX != null) {
            this.ABX.a(this.ACa);
        }
        AppMethodBeat.o(26584);
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(26585);
        super.onPause();
        AppMethodBeat.o(26585);
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bex;
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
    public final a exc() {
        AppMethodBeat.i(26586);
        if (this.ABW == null) {
            this.ABW = aG(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (getIntent().getStringExtra("select_radio_icon_color") != null) {
            this.ixw = getIntent().getStringExtra("select_radio_icon_color");
        }
        if (getIntent().getStringExtra("select_radio_icon_color") != null && getIntent().getStringExtra("get_poi_from_scene").equals("story")) {
            this.ABE = true;
            super.ABE = true;
        }
        if (this.ABU == null) {
            this.ABU = new b(this, this.qOH, "viewlist", this.ABF, false, this.ixw, this.Vav);
            if (!(this.ABW == null || this.ABW.size() == 0)) {
                ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> arrayList = new ArrayList<>();
                arrayList.add(this.ABW.get(this.ABW.size() - 1));
                this.ABU.aF(arrayList);
                this.ABU.ABg = false;
            }
            b bVar = this.ABU;
            AppMethodBeat.o(26586);
            return bVar;
        }
        b bVar2 = this.ABU;
        AppMethodBeat.o(26586);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
    public final a exd() {
        AppMethodBeat.i(26587);
        if (this.ABW == null) {
            this.ABW = aG(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.ABV == null) {
            this.ABV = new b(this, this.ABZ, "searchlist", this.ABF, true, this.ixw, this.Vav);
            this.ABV.aF(this.ABW);
            this.ABV.ABg = true;
            b bVar = this.ABV;
            AppMethodBeat.o(26587);
            return bVar;
        }
        b bVar2 = this.ABV;
        AppMethodBeat.o(26587);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.nearlife.ui.BaseLifeUI
    public final void p(double d2, double d3) {
        AppMethodBeat.i(26588);
        Log.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", Double.valueOf(d2), Double.valueOf(d3));
        if (this.ABX != null && Util.isNullOrNil(this.fuK)) {
            this.ABX.a(d2, d3, this.ACa);
        }
        AppMethodBeat.o(26588);
    }

    private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> aG(ArrayList<String> arrayList) {
        AppMethodBeat.i(26589);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(26589);
            return null;
        }
        ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split("\n");
            if (2 == split.length) {
                try {
                    arrayList2.add(new BackwardSupportUtil.ExifHelper.LatLongData(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue()));
                } catch (NumberFormatException e2) {
                }
            }
        }
        Log.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        AppMethodBeat.o(26589);
        return arrayList2;
    }

    static /* synthetic */ void a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        BackwardSupportUtil.ExifHelper.LatLongData aIv;
        int aIx;
        AppMethodBeat.i(26590);
        Log.d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof b.a) {
            b.a aVar = (b.a) view.getTag();
            com.tencent.mm.plugin.nearlife.b.b bVar = aVar.ABQ;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", bVar.AAP.toByteArray());
                intent.putExtra("location_ctx", bVar.AAO.getBuffer().zy);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CheckInLifeUI", e2, "", new Object[0]);
            }
            if (z) {
                aIv = checkInLifeUI.ABV.aIv(aVar.AAG);
                aIx = checkInLifeUI.ABV.aIx(aVar.AAG);
                checkInLifeUI.a(aIx, true, aVar.AAG, checkInLifeUI.ABE);
            } else {
                aIv = checkInLifeUI.ABU.aIv(aVar.AAG);
                aIx = checkInLifeUI.ABU.aIx(aVar.AAG);
                checkInLifeUI.a(aIx, false, aVar.AAG, checkInLifeUI.ABE);
            }
            intent.putExtra("report_index", aIx);
            intent.putExtra("first_start_time", checkInLifeUI.ABx);
            intent.putExtra("lastSuccStamp", checkInLifeUI.ABz);
            intent.putExtra("firstSuccStamp", checkInLifeUI.ABy);
            intent.putExtra("reqLoadCnt", checkInLifeUI.ABA);
            intent.putExtra("entry_time", checkInLifeUI.yLS);
            intent.putExtra("search_id", bVar.yMY);
            intent.putExtra("request_id", bVar.dPI);
            if (aIv == null) {
                if (checkInLifeUI.ABs == null) {
                    aIv = new BackwardSupportUtil.ExifHelper.LatLongData(-85.0f, -1000.0f);
                } else {
                    aIv = new BackwardSupportUtil.ExifHelper.LatLongData(checkInLifeUI.ABs.LbD, checkInLifeUI.ABs.LbC);
                }
            }
            Log.i("MicroMsg.CheckInLifeUI", "lbs.Type %d", Integer.valueOf(bVar.oUv));
            switch (aVar.type) {
                case 0:
                    intent.putExtra("get_poi_data_type", 2);
                    if (aIv != null) {
                        intent.putExtra("get_lat", aIv.latitude);
                        intent.putExtra("get_lng", aIv.longtitude);
                    }
                    if (!Util.isNullOrNil(checkInLifeUI.fuK)) {
                        intent.putExtra("get_city", checkInLifeUI.fuK);
                    }
                    intent.putExtra("get_poi_classify_type", bVar.oUv);
                    intent.putExtra("get_poi_address", a.fF(bVar.AAL));
                    intent.putExtra("get_poi_classify_id", bVar.AAG);
                    intent.putExtra("get_poi_name", bVar.Title);
                    intent.putExtra("get_poi_showflag", bVar.showFlag);
                    break;
                case 1:
                    intent.putExtra("get_poi_data_type", 1);
                    if (aIv != null) {
                        intent.putExtra("get_lat", aIv.latitude);
                        intent.putExtra("get_lng", aIv.longtitude);
                    }
                    intent.putExtra("get_city", bVar.Title);
                    break;
                case 2:
                    intent.putExtra("get_poi_data_type", 0);
                    break;
            }
            intent.putExtra("get_cur_lat", checkInLifeUI.ABt);
            intent.putExtra("get_cur_lng", checkInLifeUI.ABu);
            intent.putExtra("get_accuracy", checkInLifeUI.ABw);
            intent.putExtra("get_loctype", checkInLifeUI.ABv);
            intent.putExtra("get_is_mars", checkInLifeUI.iVk);
            checkInLifeUI.setResult(-1, intent);
            checkInLifeUI.finish();
        }
        checkInLifeUI.hideVKB();
        AppMethodBeat.o(26590);
    }
}
