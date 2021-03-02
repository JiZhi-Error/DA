package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.c;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@a(23)
public class RedirectUI extends HellActivity {
    private static long gmF = Util.MILLSECONDS_OF_DAY;
    private String haD = "";
    private final MMHandler handler = new MMHandler();
    private String info = "";
    private boolean isStart = false;
    private long msgId;
    private int qcr;
    private int type = 0;
    private double yFu = 0.0d;
    private double yFv = 0.0d;
    private int yFw = 0;
    private boolean yHD = true;
    private final int yIA = 0;
    private final int yIB = 1;
    private final int yIC = 0;
    private final int yID = 1;
    private String yIw = "";
    private int yIx;
    private final int yIy = 1;
    private boolean yIz = false;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RedirectUI() {
        AppMethodBeat.i(55874);
        AppMethodBeat.o(55874);
    }

    static /* synthetic */ void a(RedirectUI redirectUI, Intent intent, double d2, double d3) {
        AppMethodBeat.i(55882);
        redirectUI.a(intent, d2, d3);
        AppMethodBeat.o(55882);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(55875);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        if (Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(81938, (Object) null))) * 1000 > gmF) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c.beo().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.msgId = getIntent().getLongExtra("kMsgId", -1);
        this.haD = getIntent().getStringExtra("map_talker_name");
        Log.d("MicroMsg.RedirectUI", "tofutest type: %s", Integer.valueOf(this.type));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.yIw = getIntent().getStringExtra("map_sender_name");
                this.qcr = getIntent().getIntExtra("view_type_key", 1);
                this.yIx = getIntent().getIntExtra("key_get_location_type", 0);
                this.yFu = getIntent().getDoubleExtra("KPickPoiLat", -85.0d);
                this.yFv = getIntent().getDoubleExtra("KPickPoiLong", -85.0d);
                k(this.yFu, this.yFv);
                break;
            case 1:
            case 2:
            case 7:
            case 9:
            case 10:
                this.yFu = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.yFv = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.yFw = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                k(this.yFu, this.yFv);
                AppMethodBeat.o(55875);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a aCZ = n.ecS().aCZ(this.haD);
                Log.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (aCZ != null));
                if (aCZ != null) {
                    this.yFu = aCZ.latitude;
                    this.yFv = aCZ.longitude;
                    this.info = aCZ.yFq;
                    Log.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", Double.valueOf(this.yFu), Double.valueOf(this.yFv), this.info, Integer.valueOf(aCZ.dTe.size()));
                    this.yFw = 0;
                    k(this.yFu, this.yFv);
                    AppMethodBeat.o(55875);
                    return;
                }
                k(-1000.0d, -1000.0d);
                AppMethodBeat.o(55875);
                return;
        }
        AppMethodBeat.o(55875);
    }

    private void k(final double d2, final double d3) {
        AppMethodBeat.i(55876);
        this.isStart = true;
        final Intent edk = edk();
        switch (this.type) {
            case 0:
                edk.putExtra("location_scene", 1);
                break;
        }
        if (ac.jNZ) {
            this.handler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.location.ui.RedirectUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(55873);
                    RedirectUI.a(RedirectUI.this, edk, d2, d3);
                    AppMethodBeat.o(55873);
                }
            }, 2000);
            AppMethodBeat.o(55876);
            return;
        }
        a(edk, d2, d3);
        AppMethodBeat.o(55876);
    }

    private Intent edk() {
        AppMethodBeat.i(55877);
        Intent ar = d.ar(this);
        ar.putExtra("type_tag", getIntent().getIntExtra("type_tag", 0));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                Log.d("MicroMsg.RedirectUI", "view poi isHidePoiOversea : " + h.aqK().aqx());
                ar.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
            case 10:
                Log.d("MicroMsg.RedirectUI", "view normal");
                ar.putExtra("intent_map_key", 4);
                break;
            case 4:
            case 5:
            default:
                Log.d("MicroMsg.RedirectUI", "view type error");
                ar = null;
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                Log.d("MicroMsg.RedirectUI", "location resume");
                ar.putExtra("intent_map_key", 5);
                if (!Util.isNullOrNil(stringExtra)) {
                    ar.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                ar.putExtra("intent_map_key", 4);
                break;
        }
        AppMethodBeat.o(55877);
        return ar;
    }

    private void a(Intent intent, double d2, double d3) {
        AppMethodBeat.i(55878);
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            intent.putExtra("kimg_path", com.tencent.mm.plugin.image.d.aSY());
            intent.putExtra("kPoi_url", Util.nullAs(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d2);
            intent.putExtra("kwebmap_lng", d3);
            intent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", Util.nullAs(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.haD);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            xr xrVar = new xr();
            xrVar.edW.edX = true;
            EventCenter.instance.publish(xrVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.yFw > 0) {
                    intent.putExtra("kwebmap_scale", this.yFw);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                AppMethodBeat.o(55878);
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9 || this.type == 10) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.yFw > 0) {
                    intent.putExtra("kwebmap_scale", this.yFw);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                AppMethodBeat.o(55878);
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                AppMethodBeat.o(55878);
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                AppMethodBeat.o(55878);
            } else {
                if (this.type == 8) {
                    intent.putExtra("KPickPoiLat", d2);
                    intent.putExtra("KPickPoiLong", d3);
                    startActivityForResult(intent, 6);
                }
                AppMethodBeat.o(55878);
            }
        } else {
            finish();
            AppMethodBeat.o(55878);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        AppMethodBeat.i(55879);
        Log.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            finish();
            AppMethodBeat.o(55879);
        } else if (intent == null) {
            finish();
            AppMethodBeat.o(55879);
        } else {
            switch (i2) {
                case 2:
                    String str2 = this.haD;
                    LocationIntent locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    Log.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.aBz());
                    pz pzVar = new pz();
                    pzVar.dWg.cSx = this.yIx;
                    pzVar.dWg.lat = locationIntent.lat;
                    pzVar.dWg.lng = locationIntent.lng;
                    pzVar.dWg.dRt = locationIntent.dRt;
                    pzVar.dWg.label = locationIntent.label;
                    pzVar.dWg.dWi = locationIntent.kHV;
                    EventCenter.instance.publish(pzVar);
                    double d2 = locationIntent.lat;
                    double d3 = locationIntent.lng;
                    int i4 = locationIntent.dRt;
                    String str3 = locationIntent.label;
                    String str4 = locationIntent.kHV;
                    String str5 = locationIntent.JTr;
                    String str6 = locationIntent.yFB;
                    if (str4 == null) {
                        str4 = "";
                    }
                    String str7 = "<msg><location x=\"" + d2 + "\" y=\"" + d3 + "\" scale=\"" + i4 + "\" label=\"" + Util.escapeStringForXml(str3) + "\" poiname=\"" + Util.escapeStringForXml(str4) + "\" infourl=\"" + Util.escapeStringForXml(str5) + "\" maptype=\"0\" poiid=\"" + str6 + "\" /></msg>";
                    Log.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(str7)));
                    tw twVar = new tw();
                    twVar.eaq.dkV = str2;
                    twVar.eaq.content = str7;
                    twVar.eaq.type = 48;
                    twVar.eaq.flags = 0;
                    EventCenter.instance.publish(twVar);
                    o.a(2004, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    LocationIntent locationIntent2 = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    Log.i("MicroMsg.RedirectUI", "locationintent " + locationIntent2.aBz());
                    if (locationIntent2.JTs == 3) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10822, 1, locationIntent2.yFz, 1);
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10822, 1, locationIntent2.yFz, 0);
                    }
                    intent.putExtra("kwebmap_slat", locationIntent2.lat);
                    intent.putExtra("kwebmap_lng", locationIntent2.lng);
                    intent.putExtra("kwebmap_scale", locationIntent2.dRt);
                    intent.putExtra("Kwebmap_locaion", locationIntent2.label);
                    intent.putExtra("kTags", intent.getStringArrayListExtra("kTags"));
                    if (locationIntent2.kHV.equals("")) {
                        str = "";
                    } else {
                        str = locationIntent2.kHV;
                    }
                    intent.putExtra("kPoiName", str);
                    break;
                case 6:
                    LocationIntent locationIntent3 = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    Log.i("MicroMsg.RedirectUI", "locationintent " + locationIntent3.aBz());
                    if (locationIntent3.iVi != null) {
                        Log.d("MicroMsg.RedirectUI", "addr: " + locationIntent3.iVi.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent3.iVi);
                    break;
            }
            setResult(i3, intent);
            finish();
            AppMethodBeat.o(55879);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(55880);
        this.yHD = false;
        super.onDestroy();
        AppMethodBeat.o(55880);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(55881);
        super.finish();
        AppMethodBeat.o(55881);
    }
}
