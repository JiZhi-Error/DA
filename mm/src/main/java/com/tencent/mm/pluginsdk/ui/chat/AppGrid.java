package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.chat.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid extends GridView {
    private b Kgs;
    int Kgt;
    int Kgu = 0;
    int Kgv = 0;
    int Kgw;
    int Kgx;
    a Kgy;
    Context context;
    AdapterView.OnItemClickListener ppw = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.chat.AppGrid.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(31433);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            AppGrid.this.Kgs.a(AppGrid.this.Kgs.air((AppGrid.this.Kgw * AppGrid.this.Kgu) + i2), AppGrid.this.Kgy.abn(i2));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(31433);
        }
    };
    private SharedPreferences sp;
    AdapterView.OnItemLongClickListener tej = new AdapterView.OnItemLongClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.chat.AppGrid.AnonymousClass2 */

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(31434);
            b bVar = AppGrid.this.Kgs;
            int air = AppGrid.this.Kgs.air((AppGrid.this.Kgw * AppGrid.this.Kgu) + i2);
            AppGrid.this.Kgy.abn(i2);
            bVar.ais(air);
            AppMethodBeat.o(31434);
            return true;
        }
    };

    public interface b {
        void a(int i2, g gVar);

        int air(int i2);

        void ais(int i2);
    }

    public AppGrid(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(31441);
        this.context = context2;
        AppMethodBeat.o(31441);
    }

    public AppGrid(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(31442);
        this.context = context2;
        AppMethodBeat.o(31442);
    }

    public void setOnAppSelectedListener(b bVar) {
        this.Kgs = bVar;
    }

    public int getCount() {
        AppMethodBeat.i(31446);
        int count = this.Kgy.getCount();
        AppMethodBeat.o(31446);
        return count;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private boolean Blm = false;
        private int KgA;
        private int KgB;
        private Map<String, g> KgC = null;
        List<g> jGV = new ArrayList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(31440);
            g abn = abn(i2);
            AppMethodBeat.o(31440);
            return abn;
        }

        public a(Context context, List<g> list, Map<String, g> map, ArrayList<a.C2027a> arrayList) {
            AppMethodBeat.i(163201);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
            Log.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", objArr);
            this.jGV.clear();
            this.jGV.addAll(list);
            this.jGV.addAll(arrayList);
            this.KgC = map;
            this.KgA = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 56.0f);
            this.KgB = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 53.3f);
            Iterator<a.C2027a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.b a2 = AppGrid.a(it.next());
                if (a2 != null && !Util.isNullOrNil(a2.desc)) {
                    this.Blm = true;
                    AppMethodBeat.o(163201);
                    return;
                }
            }
            AppMethodBeat.o(163201);
        }

        public final int getCount() {
            AppMethodBeat.i(31436);
            if (AppGrid.this.Kgw == AppGrid.this.Kgv - 1) {
                int i2 = AppGrid.this.Kgt - (AppGrid.this.Kgw * AppGrid.this.Kgu);
                AppMethodBeat.o(31436);
                return i2;
            }
            int i3 = AppGrid.this.Kgu;
            AppMethodBeat.o(31436);
            return i3;
        }

        public final g abn(int i2) {
            AppMethodBeat.i(31437);
            if ((i2 >= AppGrid.this.Kgx || AppGrid.this.Kgw != 0) && (AppGrid.this.Kgw * AppGrid.this.Kgu) + i2 >= AppGrid.this.Kgx && (i2 - AppGrid.this.Kgx) + (AppGrid.this.Kgw * AppGrid.this.Kgu) < this.jGV.size()) {
                int i3 = (i2 - AppGrid.this.Kgx) + (AppGrid.this.Kgw * AppGrid.this.Kgu);
                Log.v("MicroMsg.AppGrid", "get item db pos: %d", Integer.valueOf(i3));
                g gVar = this.jGV.get(i3);
                AppMethodBeat.o(31437);
                return gVar;
            }
            AppMethodBeat.o(31437);
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2026a aVar;
            AppMethodBeat.i(31438);
            if (view == null) {
                aVar = new C2026a();
                view = View.inflate(AppGrid.this.context, R.layout.gc, null);
                aVar.kc = (ImageView) view.findViewById(R.id.rr);
                aVar.KgD = (CdnImageView) view.findViewById(R.id.rq);
                aVar.KgF = view.findViewById(R.id.rs);
                aVar.uGh = (TextView) view.findViewById(R.id.rt);
                aVar.jCB = (TextView) view.findViewById(R.id.rp);
                aVar.KgE = (TextView) view.findViewById(R.id.ru);
                aVar.KgG = view.findViewById(R.id.rv);
                view.setTag(aVar);
            } else {
                aVar = (C2026a) view.getTag();
            }
            Log.i("MicroMsg.AppGrid", "pos:" + i2 + " page:" + AppGrid.this.Kgw);
            aVar.uGh.setVisibility(0);
            if (this.Blm) {
                aVar.jCB.setVisibility(0);
            } else {
                aVar.jCB.setVisibility(8);
            }
            aVar.KgG.setVisibility(8);
            aVar.KgE.setVisibility(8);
            aVar.KgF.setVisibility(0);
            aVar.kc.setVisibility(0);
            aVar.KgD.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = aVar.kc.getLayoutParams();
            layoutParams.width = this.KgA;
            layoutParams.height = this.KgA;
            aVar.kc.setLayoutParams(layoutParams);
            int i3 = (AppGrid.this.Kgw * AppGrid.this.Kgu) + i2;
            int air = AppGrid.this.Kgs.air(i3);
            if (i3 < AppGrid.this.Kgx) {
                switch (air) {
                    case 0:
                        aVar.kc.setImageResource(R.raw.panel_icon_pic);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.up));
                        break;
                    case 1:
                        if (!ac.jPB) {
                            aVar.kc.setImageResource(R.raw.panel_icon_camera);
                            aVar.uGh.setText(AppGrid.this.context.getString(R.string.um));
                            break;
                        } else {
                            aVar.kc.setImageResource(R.raw.panel_icon_sights);
                            aVar.uGh.setText(AppGrid.this.context.getString(R.string.ux));
                            break;
                        }
                    case 2:
                        aVar.kc.setImageResource(R.raw.panel_icon_voip);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.v4));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(54, Boolean.FALSE)).booleanValue()) {
                                aVar.KgE.setVisibility(8);
                                break;
                            } else {
                                aVar.KgE.setVisibility(0);
                                break;
                            }
                        } catch (Exception e2) {
                            break;
                        }
                    case 3:
                        aVar.kc.setImageResource(R.raw.panel_icon_multitalk);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.v6));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(81, Boolean.FALSE)).booleanValue()) {
                                aVar.KgE.setVisibility(8);
                                break;
                            } else {
                                aVar.KgE.setVisibility(0);
                                break;
                            }
                        } catch (Exception e3) {
                            break;
                        }
                    case 4:
                        aVar.kc.setImageResource(R.raw.panel_icon_voipvoice);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.v6));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(62, Boolean.FALSE)).booleanValue()) {
                                aVar.KgE.setVisibility(8);
                                break;
                            } else {
                                aVar.KgE.setVisibility(0);
                                break;
                            }
                        } catch (Exception e4) {
                            break;
                        }
                    case 5:
                        aVar.kc.setImageResource(R.raw.panel_icon_wxtalk);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.uz));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(67, Boolean.FALSE)).booleanValue()) {
                                aVar.KgE.setVisibility(8);
                                break;
                            } else {
                                aVar.KgE.setVisibility(0);
                                break;
                            }
                        } catch (Exception e5) {
                            break;
                        }
                    case 6:
                        aVar.kc.setImageResource(R.raw.panel_icon_location);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.uk));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(290817, Boolean.FALSE)).booleanValue()) {
                                aVar.KgG.setVisibility(8);
                                break;
                            } else {
                                aVar.KgG.setVisibility(0);
                                break;
                            }
                        } catch (Exception e6) {
                            break;
                        }
                    case 7:
                        Log.i("MicroMsg.AppGrid", "attach lucky money");
                        a(aVar, g.JVT, AppGrid.this.context.getString(R.string.ul));
                        break;
                    case 8:
                        Log.i("MicroMsg.AppGrid", "attach remittance");
                        a(aVar, g.JVR, AppGrid.this.context.getString(R.string.v0));
                        break;
                    case 9:
                        a(aVar, g.JVU, null);
                        break;
                    case 10:
                        aVar.kc.setImageResource(R.raw.panel_icon_voiceinput);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.dza));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(73, Boolean.FALSE)).booleanValue()) {
                                aVar.KgE.setVisibility(8);
                                break;
                            } else {
                                aVar.KgE.setVisibility(0);
                                break;
                            }
                        } catch (Exception e7) {
                            break;
                        }
                    case 11:
                        aVar.kc.setImageResource(R.raw.panel_icon_fav);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.ue));
                        break;
                    case 12:
                        aVar.kc.setImageResource(R.raw.icons_filled_grouptool);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.ui));
                        break;
                    case 13:
                        aVar.kc.setImageResource(R.raw.icons_outlined_continued_form);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.uh));
                        break;
                    case 14:
                        aVar.kc.setImageResource(R.raw.panel_icon_live);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.uj));
                        break;
                    case 15:
                        aVar.kc.setImageResource(R.raw.panel_icon_friendcard);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.u_));
                        break;
                    case 16:
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.bvt));
                        try {
                            bg.aVF();
                            boolean booleanValue = ((Boolean) c.azQ().get(208899, Boolean.FALSE)).booleanValue();
                            bg.aVF();
                            boolean booleanValue2 = ((Boolean) c.azQ().get(208913, Boolean.FALSE)).booleanValue();
                            if (!booleanValue && !booleanValue2) {
                                aVar.KgE.setVisibility(8);
                                break;
                            } else {
                                aVar.KgE.setVisibility(0);
                                if (!booleanValue2) {
                                    aVar.KgE.setText(R.string.x4);
                                    break;
                                } else {
                                    aVar.KgE.setText(R.string.vn);
                                    break;
                                }
                            }
                        } catch (Exception e8) {
                            break;
                        }
                    case 17:
                        aVar.kc.setImageResource(R.raw.panel_icon_service);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.uw));
                        try {
                            bg.aVF();
                            if (!((Boolean) c.azQ().get(327744, Boolean.TRUE)).booleanValue()) {
                                aVar.KgG.setVisibility(8);
                                break;
                            } else {
                                aVar.KgG.setVisibility(0);
                                break;
                            }
                        } catch (Exception e9) {
                            break;
                        }
                    case 18:
                        aVar.kc.setImageResource(R.raw.panel_icon_enterprise);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.ud));
                        try {
                            aVar.KgG.setVisibility(8);
                            break;
                        } catch (Exception e10) {
                            break;
                        }
                    case 19:
                        aVar.kc.setImageResource(R.raw.panel_icon_file_explorer);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.uf));
                        break;
                    case 20:
                        aVar.kc.setImageResource(R.raw.icons_filled_gift);
                        aVar.uGh.setText(AppGrid.this.context.getString(R.string.ug));
                        break;
                }
            } else {
                layoutParams.width = this.KgB;
                layoutParams.height = this.KgB;
                aVar.kc.setLayoutParams(layoutParams);
                g abn = abn(i2);
                if (abn != null) {
                    if (abn instanceof a.C2027a) {
                        a.C2027a aVar2 = (a.C2027a) abn;
                        a.b a2 = AppGrid.a(aVar2);
                        String str = aVar2.iconUrl;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case -793313752:
                                if (str.equals("icons_filled_live_mark")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1442800093:
                                if (str.equals("icons_filled_health_note")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                aVar.kc.setImageResource(R.raw.icons_filled_health_note);
                                break;
                            case 1:
                                aVar.kc.setImageResource(R.raw.icons_filled_live_mark);
                                break;
                            default:
                                aVar.kc.setVisibility(8);
                                aVar.KgD.setVisibility(0);
                                if (ao.isDarkMode() && !Util.isNullOrNil(aVar2.Kib)) {
                                    aVar.KgD.aM(aVar2.Kib, com.tencent.mm.cb.a.fromDPToPix(AppGrid.this.context, aVar2.Kic), com.tencent.mm.cb.a.fromDPToPix(AppGrid.this.context, aVar2.Kid));
                                    break;
                                } else {
                                    aVar.KgD.aM(aVar2.iconUrl, com.tencent.mm.cb.a.fromDPToPix(AppGrid.this.context, aVar2.Kic), com.tencent.mm.cb.a.fromDPToPix(AppGrid.this.context, aVar2.Kid));
                                    break;
                                }
                        }
                        aVar.uGh.setText(a2.title);
                        if (!Util.isNullOrNil(a2.desc)) {
                            aVar.jCB.setText(a2.desc);
                        }
                    } else {
                        bg.aVF();
                        if (c.isSDCardAvailable()) {
                            if (abn.field_status == 5) {
                                h.c(abn.field_appId, 3, com.tencent.mm.cb.a.getDensity(AppGrid.this.context));
                            } else if (abn.gmR()) {
                                h.c(abn.field_appId, 4, com.tencent.mm.cb.a.getDensity(AppGrid.this.context));
                            } else {
                                h.c(abn.field_appId, 1, com.tencent.mm.cb.a.getDensity(AppGrid.this.context));
                            }
                            if (g.JVR.equals(abn.field_appId)) {
                                aVar.kc.setImageResource(R.raw.panel_icon_transfer);
                            } else if (g.JVT.equals(abn.field_appId)) {
                                aVar.kc.setImageResource(R.raw.panel_icon_luckymoney);
                            } else if (g.JVS.equals(abn.field_appId)) {
                                aVar.kc.setImageResource(R.raw.panel_icon_card);
                            } else if (g.JVU.equals(abn.field_appId)) {
                                aVar.kc.setImageResource(R.raw.panel_icon_aa);
                            } else {
                                aVar.kc.setBackgroundResource(R.drawable.by9);
                            }
                        } else {
                            aVar.kc.setBackgroundResource(R.drawable.bni);
                        }
                        aVar.uGh.setText(h.a(AppGrid.this.context, abn, (String) null));
                        if (abn.gmR() && abn.gmS()) {
                            if (AppGrid.this.sp == null) {
                                AppGrid.this.sp = AppGrid.this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                            }
                            if (AppGrid.this.sp.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + abn.field_appId, true)) {
                                aVar.KgE.setVisibility(0);
                            }
                        }
                    }
                }
            }
            g abn2 = abn(i2);
            if (abn2 != null && h.p(abn2)) {
                aVar.KgE.setVisibility(0);
            }
            AppMethodBeat.o(31438);
            return view;
        }

        private void a(C2026a aVar, String str, String str2) {
            AppMethodBeat.i(31439);
            if (this.KgC == null) {
                Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
                AppMethodBeat.o(31439);
                return;
            }
            g gVar = this.KgC.get(str);
            if (gVar == null) {
                Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
                AppMethodBeat.o(31439);
                return;
            }
            if (g.JVR.equals(gVar.field_appId)) {
                aVar.kc.setImageResource(R.raw.panel_icon_transfer);
            } else if (g.JVT.equals(gVar.field_appId)) {
                aVar.kc.setImageResource(R.raw.panel_icon_luckymoney);
            } else if (g.JVS.equals(gVar.field_appId)) {
                aVar.kc.setImageResource(R.raw.panel_icon_card);
            } else if (g.JVU.equals(gVar.field_appId)) {
                aVar.kc.setImageResource(R.raw.panel_icon_aa);
            } else {
                aVar.kc.setImageResource(R.drawable.by9);
            }
            if (!Util.isNullOrNil(str2)) {
                aVar.uGh.setText(h.b(AppGrid.this.context, gVar, str2));
            } else {
                aVar.uGh.setText(h.a(AppGrid.this.context, gVar, (String) null));
            }
            if (gVar.gmR() && gVar.gmS()) {
                if (AppGrid.this.sp == null) {
                    AppGrid.this.sp = AppGrid.this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                }
                if (AppGrid.this.sp.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + gVar.field_appId, true)) {
                    aVar.KgE.setVisibility(0);
                }
            }
            if (g.JVR.equals(gVar.field_appId)) {
                bg.aVF();
                int intValue = ((Integer) c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                if (intValue <= 1) {
                    AppMethodBeat.o(31439);
                    return;
                }
                bg.aVF();
                if (!Util.stringsToList(((String) c.azQ().get(ar.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.KgE.setVisibility(0);
                }
                AppMethodBeat.o(31439);
                return;
            }
            if (g.JVT.equals(gVar.field_appId)) {
                bg.aVF();
                int intValue2 = ((Integer) c.azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                if (intValue2 <= 1) {
                    aVar.KgE.setVisibility(8);
                    AppMethodBeat.o(31439);
                    return;
                }
                bg.aVF();
                if (!Util.stringsToList(((String) c.azQ().get(ar.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, "")).split(";")).contains(String.valueOf(intValue2))) {
                    aVar.KgE.setVisibility(0);
                }
            }
            AppMethodBeat.o(31439);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.AppGrid$a$a  reason: collision with other inner class name */
        public class C2026a {
            CdnImageView KgD;
            TextView KgE;
            View KgF;
            View KgG;
            TextView jCB;
            ImageView kc;
            TextView uGh;

            C2026a() {
            }
        }
    }

    public static a.b a(a.C2027a aVar) {
        AppMethodBeat.i(163203);
        if (aVar == null) {
            AppMethodBeat.o(163203);
            return null;
        }
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        if (LocaleUtil.CHINA.equals(applicationLanguage)) {
            a.b bVar = aVar.KhX;
            AppMethodBeat.o(163203);
            return bVar;
        } else if (LocaleUtil.TAIWAN.equals(applicationLanguage)) {
            a.b bVar2 = aVar.KhZ;
            AppMethodBeat.o(163203);
            return bVar2;
        } else if (LocaleUtil.HONGKONG.equals(applicationLanguage)) {
            a.b bVar3 = aVar.KhY;
            AppMethodBeat.o(163203);
            return bVar3;
        } else {
            a.b bVar4 = aVar.Kia;
            AppMethodBeat.o(163203);
            return bVar4;
        }
    }
}
