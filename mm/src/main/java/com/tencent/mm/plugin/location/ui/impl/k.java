package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.y;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.LinkedList;

public class k extends a implements i {
    private boolean dUo = true;
    public d gVN = new d(this.activity);
    private boolean mbo = false;
    protected long msgId = -1;
    e qBG;
    private long yKl = 0;
    private String yOk = "";
    l yOl;
    boolean yOm = false;
    private Runnable yOn;
    private b.a yOo = new b.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass5 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(56205);
            if (!z) {
                AppMethodBeat.o(56205);
                return false;
            }
            Log.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f2 + " flat " + f3);
            if (((double) f3) == 0.0d && ((double) f2) == 0.0d) {
                AppMethodBeat.o(56205);
                return true;
            }
            Log.d("MicroMsg.ViewMapUI", "myLocation " + k.this.lXl.yFu + " " + k.this.lXl.yFv);
            Log.d("MicroMsg.ViewMapUI", "location my show");
            k.this.lXl.yFu = (double) f3;
            k.this.lXl.yFv = (double) f2;
            k.this.yKY.a(k.this.lXl.yFu, k.this.lXl.yFv, k.this.yLe, k.this.lXl.yFt);
            AppMethodBeat.o(56205);
            return true;
        }
    };

    public k(Activity activity) {
        super(activity);
        AppMethodBeat.i(56208);
        g.azz().a(v2helper.EMethodSetSpkEnhance, this);
        AppMethodBeat.o(56208);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public boolean edH() {
        AppMethodBeat.i(56209);
        if (this.qBG == null || !this.qBG.isShowing()) {
            eeh();
            this.qBG.dGm();
        } else {
            this.qBG.bMo();
        }
        AppMethodBeat.o(56209);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void eeh() {
        AppMethodBeat.i(56210);
        this.qBG = new e((Context) this.activity, 1, false);
        this.qBG.HLX = new o.f() {
            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(56200);
                mVar.b(1, k.this.getString(R.string.yz), 0);
                if (k.this.type == 1) {
                    mVar.b(3, k.this.getString(R.string.fn9), 0);
                } else if (k.this.type == 2) {
                    if (k.this.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
                        mVar.b(7, k.this.getString(R.string.cbw), 0);
                        mVar.b(5, k.this.getString(R.string.c9t), 0);
                        mVar.b(4, k.this.getString(R.string.tf), 0);
                    }
                } else if (k.this.type == 10) {
                    mVar.b(8, k.this.getString(R.string.fn9), 0);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = k.this.msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX || h.s(MMApplicationContext.getContext(), 4)) {
                    mVar.b(6, k.this.getString(R.string.bo1), 0);
                }
                AppMethodBeat.o(56200);
            }
        };
        this.qBG.HLY = new o.g() {
            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(56202);
                switch (menuItem.getItemId()) {
                    case 0:
                        k.this.eej();
                        AppMethodBeat.o(56202);
                        return;
                    case 1:
                        if (k.this.type == 2) {
                            com.tencent.mm.plugin.fav.a.h.w(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1), 1);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.lXk));
                        intent.putExtra("Retr_Msg_Type", 9);
                        c.f(k.this.activity, ".ui.transmit.MsgRetransmitUI", intent);
                        AppMethodBeat.o(56202);
                        return;
                    case 2:
                        k.this.dKf = 0;
                        k.this.eel();
                        AppMethodBeat.o(56202);
                        return;
                    case 3:
                        k.this.eek();
                        AppMethodBeat.o(56202);
                        return;
                    case 4:
                        com.tencent.mm.ui.base.h.a(k.this.activity, k.this.activity.getString(R.string.th), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(56201);
                                long longExtra = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                                cu cuVar = new cu();
                                cuVar.dFU.dFW = longExtra;
                                EventCenter.instance.publish(cuVar);
                                boolean nullAs = Util.nullAs(Boolean.valueOf(cuVar.dFV.dFE), false);
                                Log.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", Long.valueOf(longExtra), Boolean.valueOf(nullAs));
                                if (nullAs) {
                                    k.this.activity.finish();
                                }
                                AppMethodBeat.o(56201);
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(56202);
                        return;
                    case 5:
                        long longExtra = k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_fav_item_id", longExtra);
                        intent2.putExtra("key_fav_scene", 2);
                        com.tencent.mm.plugin.fav.a.b.b(k.this.activity, ".ui.FavTagEditUI", intent2);
                        AppMethodBeat.o(56202);
                        return;
                    case 6:
                        Intent intent3 = new Intent();
                        intent3.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(k.this.lXk));
                        intent3.putExtra("Retr_Msg_Id", k.this.msgId);
                        c.f(k.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                        AppMethodBeat.o(56202);
                        return;
                    case 7:
                        try {
                            com.tencent.mm.plugin.fav.a.g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(k.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15378, Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_type));
                            Log.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_type));
                            DY.field_flag = 0;
                            DY.field_updateTime = System.currentTimeMillis();
                            DY.field_localId = -1;
                            DY.field_sourceType = 6;
                            if (DY.field_favProto.Lya != null) {
                                DY.field_favProto.Lya.bhh("");
                                DY.field_favProto.Lya.ajm(6);
                                DY.field_favProto.Lya.bhf(z.aTY());
                            }
                            DY.field_fromUser = z.aTY();
                            LinkedList<aml> linkedList = new LinkedList<>();
                            aml aml = new aml();
                            amm amm = new amm();
                            amm.c(DY.field_favProto.LwQ);
                            aml.a(amm);
                            aml.bgC("WeNote_0");
                            aml.ajd(6);
                            linkedList.add(0, aml);
                            DY.field_favProto.bH(linkedList);
                            DY.field_type = 18;
                            DY.field_xml = com.tencent.mm.plugin.fav.a.g.t(DY);
                            and and = new and();
                            Activity activity = k.this.activity;
                            oc ocVar = new oc();
                            ocVar.dUe.field_localId = DY.field_localId;
                            ocVar.dUe.dUn = 5;
                            ocVar.dUe.dUg = DY.field_xml;
                            ocVar.dUe.context = activity;
                            Bundle bundle = new Bundle();
                            amv amv = DY.field_favProto.KBr;
                            if (amv != null) {
                                bundle.putString("noteauthor", amv.LxT);
                                bundle.putString("noteeditor", amv.LxU);
                            }
                            bundle.putLong("edittime", DY.field_updateTime);
                            ocVar.dUe.dUl = bundle;
                            ocVar.dUe.field_favProto = DY.field_favProto;
                            ocVar.dUe.type = 2;
                            ocVar.dUe.dUo = true;
                            ocVar.dUe.dUp = and;
                            EventCenter.instance.publish(ocVar);
                            k.this.activity.finish();
                            AppMethodBeat.o(56202);
                            return;
                        } catch (Throwable th) {
                            Toast.makeText(k.this.activity, (int) R.string.cby, 0).show();
                            AppMethodBeat.o(56202);
                            return;
                        }
                    case 8:
                        k.a(k.this);
                        break;
                }
                AppMethodBeat.o(56202);
            }
        };
        AppMethodBeat.o(56210);
    }

    private Intent eei() {
        AppMethodBeat.i(56211);
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.lXm.yHB);
        intent.putExtra("kopenOthersNums", this.lXm.yHC);
        intent.putExtra("kopenreportType", this.lXm.dYn);
        intent.putExtra("kRemark", edE());
        intent.putExtra("kwebmap_slat", this.lXk.yFu);
        intent.putExtra("kwebmap_lng", this.lXk.yFv);
        intent.putExtra("Kwebmap_locaion", this.lXk.yFx);
        intent.putExtra("kPoiName", this.kHV);
        AppMethodBeat.o(56211);
        return intent;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.location.ui.impl.a
    public void edG() {
        AppMethodBeat.i(56212);
        this.yKV.yLk.setEnabled(true);
        this.yKV.yLg.setVisibility(8);
        c(this.lXk);
        this.yKV.yHR.getIController().setZoom(this.yFw);
        this.yKV.yLi.setEnabled(true);
        this.dUo = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.dUo) {
            this.yKV.yLi.setVisibility(0);
        } else {
            this.yKV.yLi.setVisibility(8);
        }
        this.yOk = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!Util.isNullOrNil(this.yOk) && (LocaleUtil.isTraditionalChineseAppLang() || LocaleUtil.isSimplifiedChineseAppLang())) {
            this.yOm = true;
        } else if (LocaleUtil.isTraditionalChineseAppLang() || LocaleUtil.isSimplifiedChineseAppLang()) {
            this.yOm = false;
            try {
                dqx dqx = (dqx) new x((float) this.lXk.yFv, (float) this.lXk.yFu, this.msgId).rr.iLK.iLR;
                new x(dqx);
                g.azz().a(new x(dqx), 0);
            } catch (Exception e2) {
                Log.e("MicroMsg.ViewMapUI", e2.toString());
            }
        }
        this.yKV.yLi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(56203);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                k.this.eeh();
                k.this.qBG.dGm();
                a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(56203);
            }
        });
        this.yOl = new l(this.yKV.yHR, this.activity);
        l lVar = this.yOl;
        if (lVar.mViewManager != null) {
            lVar.mViewManager.addView(lVar.yKM, 0.0d, 0.0d);
            lVar.mViewManager.setMarkerTag(lVar.yKM, "info_window_tag");
            if (lVar.yKP) {
                lVar.mViewManager.setInfoWindowAdapter(new l.a(lVar, (byte) 0));
                lVar.mViewManager.showInfoWindowByView(lVar.yKM);
            }
        }
        l lVar2 = this.yOl;
        LocationInfo locationInfo = this.lXk;
        lVar2.yFu = locationInfo.yFu;
        lVar2.yFv = locationInfo.yFv;
        if (!com.tencent.mm.plugin.location.model.e.j(this.lXk.yFu, this.lXk.yFv)) {
            Log.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", Double.valueOf(this.lXk.yFu), Double.valueOf(this.lXk.yFv));
            l lVar3 = this.yOl;
            lVar3.yHP = false;
            lVar3.yKN.setVisibility(8);
        }
        if (2 == this.type) {
            Log.i("MicroMsg.ViewMapUI", "location id %s", this.lXk.yFt);
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                edD();
            }
            if (!Util.isNullOrNil(this.lXk.yFx)) {
                this.yKV.yLh.setVisibility(0);
            }
        }
        this.yKX.put(this.lXk.yFt, this.yOl);
        if (this.lXk.ecI()) {
            if (this.kHV != null && !this.kHV.equals("")) {
                this.yOl.kHV = this.kHV;
            }
            this.yOl.setText(this.yOl.getPreText() + this.lXk.yFx);
        } else if (com.tencent.mm.plugin.location.model.e.j(this.lXk.yFu, this.lXk.yFv)) {
            this.yKY.a(this.lXk.yFu, this.lXk.yFv, this.yLe, this.lXk.yFt);
        }
        l lVar4 = this.yOl;
        AnonymousClass4 r1 = new TencentMap.OnInfoWindowClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass4 */

            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener
            public final void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(56204);
                k.this.dKf = 0;
                k.this.edZ();
                k.this.eel();
                AppMethodBeat.o(56204);
            }
        };
        if (lVar4.yKP && lVar4.mViewManager != null) {
            lVar4.mViewManager.setInfoWindowClick(lVar4.yKM, r1);
        }
        AppMethodBeat.o(56212);
    }

    /* access modifiers changed from: protected */
    public void eec() {
    }

    /* access modifiers changed from: protected */
    public void edZ() {
    }

    /* access modifiers changed from: protected */
    public final void eej() {
        AppMethodBeat.i(56213);
        if (this.yOm) {
            y.a(new com.tencent.mm.pluginsdk.ui.tools.i());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.yOk);
            intent.putExtra("title", R.string.gbw);
            intent.putExtra("webview_bg_color_rsID", R.color.fm);
            c.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(56213);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public void onResume() {
        AppMethodBeat.i(56214);
        super.onResume();
        Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.yLd != null) {
            this.yLd.b(this.yOo, true);
        }
        AppMethodBeat.o(56214);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(56216);
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        Log.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.yFw = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.yFw <= 0) {
            this.yFw = 15;
        }
        this.kHV = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        Log.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.lXk;
        locationInfo.yFu = doubleExtra;
        locationInfo.yFv = doubleExtra2;
        locationInfo.yFx = stringExtra;
        locationInfo.yFw = this.yFw;
        locationInfo.dWi = this.kHV;
        this.msgId = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.rgD = this.activity.getIntent().getStringExtra("map_talker_name");
        initView();
        AppMethodBeat.o(56216);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.location.ui.impl.a
    public void edF() {
        AppMethodBeat.i(56217);
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.lXm.yHB);
        intent.putExtra("kopenOthersNums", this.lXm.yHC);
        intent.putExtra("kopenreportType", this.lXm.dYn);
        intent.putExtra("kRemark", edE());
        intent.putExtra("soso_street_view_url", this.yOk);
        this.activity.setResult(-1, intent);
        AppMethodBeat.o(56217);
    }

    /* access modifiers changed from: protected */
    public final void eek() {
        AppMethodBeat.i(56218);
        Log.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", Double.valueOf(this.lXk.yFu), Double.valueOf(this.lXk.yFv));
        this.activity.setResult(-1, eei());
        this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        this.activity.finish();
        AppMethodBeat.o(56218);
    }

    /* access modifiers changed from: protected */
    public final void eel() {
        AppMethodBeat.i(56219);
        Log.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", Double.valueOf(this.lXk.yFu), Double.valueOf(this.lXk.yFv), Double.valueOf(this.lXl.yFu), Double.valueOf(this.lXl.yFv));
        if (this.lXl.ecH()) {
            eec();
            AppMethodBeat.o(56219);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12809, 3, "");
        this.yKZ = true;
        if (this.handler == null) {
            AppMethodBeat.o(56219);
            return;
        }
        if (this.yOn != null) {
            this.handler.removeCallbacks(this.yOn);
        }
        this.yOn = new Runnable() {
            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(56206);
                if (k.this.yKZ) {
                    if (k.this.gtM != null) {
                        k.this.gtM.dismiss();
                    }
                    k.this.eec();
                }
                k.this.yKZ = false;
                AppMethodBeat.o(56206);
            }
        };
        this.handler.postDelayed(this.yOn, 10000);
        Activity activity = this.activity;
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) activity, getString(R.string.dv8), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                k.this.yKZ = false;
            }
        });
        AppMethodBeat.o(56219);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(56220);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.lXm;
                switch (i2) {
                    case 4098:
                        if (-1 == i3 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            Bundle bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            ArrayList parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            dVar.a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            AppMethodBeat.o(56220);
                            return;
                        } else if (4097 == i3) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11091, 6, 2);
                            } else {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11091, 6, 1);
                            }
                            ArrayList parcelableArrayList2 = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList2.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList2.get(1);
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=".concat(String.valueOf(Util.isNullOrNil(locationInfo.yFy) ? "zh-cn" : locationInfo.yFy)), Double.valueOf(locationInfo2.yFu), Double.valueOf(locationInfo2.yFv), Double.valueOf(locationInfo.yFu), Double.valueOf(locationInfo.yFv))));
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("targetintent", intent2);
                            Intent intent3 = new Intent();
                            intent3.setClass(dVar.context, AppChooserUI.class);
                            intent3.putExtra("type", 1);
                            intent3.putExtra("title", dVar.context.getResources().getString(R.string.eko));
                            intent3.putExtra("targetintent", intent2);
                            intent3.putExtra("transferback", bundle);
                            intent3.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(intent3, 4099);
                            AppMethodBeat.o(56220);
                            return;
                        }
                        break;
                    case 4099:
                        if (-1 == i3 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            Intent intent4 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent4.setPackage(stringExtra2);
                            intent4.addFlags(524288);
                            Context context = dVar.context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                            a.a(context, bl.axQ(), "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            a.a(context, "com/tencent/mm/plugin/location/ui/MapHelper", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            break;
                        }
                }
                break;
        }
        AppMethodBeat.o(56220);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public void onDestroy() {
        AppMethodBeat.i(56221);
        this.gVN.release();
        this.handler.removeCallbacks(this.yOn);
        this.handler = null;
        g.azz().b(v2helper.EMethodSetSpkEnhance, this);
        super.onDestroy();
        AppMethodBeat.o(56221);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.location.ui.impl.a
    public final String bmB() {
        AppMethodBeat.i(56222);
        String string = getString(R.string.ekz);
        AppMethodBeat.o(56222);
        return string;
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(56223);
        switch (motionEvent.getAction()) {
            case 0:
                this.aTD = motionEvent.getX();
                this.aTE = motionEvent.getY();
                this.yKl = System.currentTimeMillis();
                this.mbo = false;
                eeb();
                break;
            case 1:
                if (!this.mbo) {
                    System.currentTimeMillis();
                    break;
                }
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.aTD) > 10.0f || Math.abs(motionEvent.getY() - this.aTE) > 10.0f) {
                    this.mbo = true;
                    edY();
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(56223);
        return dispatchTouchEvent;
    }

    public void edY() {
    }

    public void eeb() {
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(56224);
        Log.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar.getType() != 424) {
            Log.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        } else if (i3 == 0 && i2 == 0) {
            String PE = x.PE(((x) qVar).bfB().MbV);
            Log.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", PE);
            this.yOk = PE;
            if (!Util.isNullOrNil(PE)) {
                this.yOm = true;
            }
            if (this.type == 9 && !Util.isNullOrNil(PE)) {
                TextView textView = (TextView) findViewById(R.id.icv);
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.location.ui.impl.k.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(56207);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        k.this.eej();
                        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ViewMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(56207);
                    }
                });
            }
            AppMethodBeat.o(56224);
            return;
        }
        AppMethodBeat.o(56224);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public void onPause() {
        AppMethodBeat.i(56215);
        Log.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.yLd != null) {
            this.yLd.c(this.yOo);
        }
        super.onPause();
        AppMethodBeat.o(56215);
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(56225);
        Intent eei = kVar.eei();
        cz czVar = new cz();
        ((ad) g.af(ad.class)).a(czVar, eei);
        czVar.dFZ.activity = kVar.activity;
        czVar.dFZ.dGf = 42;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(56225);
    }
}
