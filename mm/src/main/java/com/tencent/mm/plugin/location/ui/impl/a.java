package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.aa;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a extends com.tencent.mm.plugin.k.a {
    protected float aTD = 0.0f;
    protected float aTE = 0.0f;
    public Activity activity;
    protected int dKf = 0;
    protected ProgressDialog gtM = null;
    MMHandler handler = new MMHandler(Looper.getMainLooper());
    protected String kHV = "";
    protected LocationInfo lXk = new LocationInfo((byte) 0);
    protected LocationInfo lXl = new LocationInfo((byte) 0);
    protected d lXm;
    protected String rgD = "";
    protected int type = 0;
    protected boolean uSr = false;
    DisplayMetrics xTo = null;
    int yFw;
    protected String yHz;
    public String yKR = "";
    protected boolean yKS = false;
    public boolean yKT = false;
    protected Addr yKU = null;
    protected C1463a yKV;
    protected boolean yKW = false;
    protected HashMap<String, c> yKX = new HashMap<>();
    protected com.tencent.mm.modelgeo.c yKY;
    protected boolean yKZ = false;
    protected ArrayList<String> yLa = new ArrayList<>();
    protected boolean yLb = false;
    protected com.tencent.mm.plugin.location.model.c yLc = null;
    protected com.tencent.mm.modelgeo.d yLd;
    public c.a yLe = new c.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.a.AnonymousClass3 */

        @Override // com.tencent.mm.modelgeo.c.a
        public final void b(Addr addr) {
            AppMethodBeat.i(55997);
            Log.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", addr.toString());
            a.this.yKU = addr;
            String bbW = addr.bbW();
            a.this.lXl.dWi = a.this.activity.getResources().getString(R.string.ekg);
            if (addr.tag != null && addr.tag.equals(a.this.lXl.yFt)) {
                a.this.lXl.yFx = bbW;
            } else if (!Util.isNullOrNil(addr.iUO)) {
                a.this.yKV.yLh.setVisibility(0);
            }
            if (addr.tag != null && a.this.yKX.containsKey(addr.tag)) {
                com.tencent.mm.plugin.location.ui.c cVar = a.this.yKX.get(addr.tag);
                cVar.setText(cVar.getPreText() + bbW);
            }
            AppMethodBeat.o(55997);
        }
    };

    /* access modifiers changed from: protected */
    public abstract String bmB();

    /* access modifiers changed from: protected */
    public abstract void edF();

    /* access modifiers changed from: package-private */
    public abstract void edG();

    public a(Activity activity2) {
        this.activity = activity2;
        this.yKY = com.tencent.mm.modelgeo.c.bbX();
    }

    @Override // com.tencent.mm.plugin.k.a
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onBackPressed() {
        this.activity.finish();
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onCreate(Bundle bundle) {
        this.yLd = com.tencent.mm.modelgeo.d.bca();
        LocationInfo locationInfo = this.lXl;
        LocationInfo locationInfo2 = this.lXk;
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getDefaultPreference(), this.activity);
        Log.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(loadApplicationLanguage)));
        if (loadApplicationLanguage.equals(LocaleUtil.LANGUAGE_DEFAULT)) {
            LocaleUtil.updateApplicationResourceLocale(this.activity, Locale.ENGLISH);
            loadApplicationLanguage = LocaleUtil.ENGLISH;
        } else {
            LocaleUtil.updateApplicationResourceLocale(this.activity, LocaleUtil.transLanguageToLocale(loadApplicationLanguage));
        }
        locationInfo2.yFy = loadApplicationLanguage;
        locationInfo.yFy = loadApplicationLanguage;
        Log.d("MicroMsg.BaseMapUI", "sosomap " + this.lXk.yFy);
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(R.layout.ati);
        SoSoMapView soSoMapView = (SoSoMapView) d.gs(this.activity);
        ((FrameLayout) findViewById(R.id.f_w)).addView(soSoMapView);
        if (ao.isDarkMode()) {
            soSoMapView.enableDarkMode();
        } else {
            soSoMapView.disableDarkMode();
        }
        this.lXm = new d(this.activity);
        this.yKV = new C1463a();
        this.yHz = this.activity.getIntent().getStringExtra("kRemark");
        this.yLa = this.activity.getIntent().getStringArrayListExtra("kTags");
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        this.yKT = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
        Log.i("MicroMsg.BaseMapUI", "isPickPoi " + this.yKT);
    }

    @Override // com.tencent.mm.plugin.k.a
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        Log.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        edF();
        this.activity.finish();
        return true;
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onResume() {
        aa.d(true, new Intent().putExtra("classname", getClass().getName()));
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onPause() {
        aa.d(false, new Intent().putExtra("classname", getClass().getName()));
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onDestroy() {
        this.yKY.a(this.yLe);
        this.yKX.clear();
        Log.d("MicroMsg.BaseMapUI", "destroy");
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        this.yKV.yHR.destroy();
        System.gc();
    }

    public final String getString(int i2) {
        return this.activity.getString(i2);
    }

    /* access modifiers changed from: protected */
    public final void edC() {
        if (!(this.yKV.yLm == null || this.yKV.yLn == null)) {
            this.yKV.yLm.setText(l.b(this.yKV.yLm.getContext(), this.yHz, this.yKV.yLm.getTextSize()));
            if (this.yLa == null || this.yLa.isEmpty()) {
                this.yKV.yLn.setText("");
                return;
            }
            String string = this.activity.getResources().getString(R.string.ccr);
            String str = this.yLa.get(0);
            for (int i2 = 1; i2 < this.yLa.size(); i2++) {
                str = str + string + this.yLa.get(i2);
            }
            this.yKV.yLn.setText(l.b(this.yKV.yLn.getContext(), str, this.yKV.yLn.getTextSize()));
        }
    }

    /* access modifiers changed from: protected */
    public final void edD() {
        this.yKV.yLh.removeAllViews();
        View inflate = View.inflate(this.activity, R.layout.b2a, null);
        this.yKV.yLh.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        this.yKV.yLm = (TextView) inflate.findViewById(R.id.eqq);
        this.yKV.yLm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(55995);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(a.this.activity, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", a.this.edE());
                intent.putExtra("key_hint", a.this.getString(R.string.ekx));
                intent.putExtra("Kwebmap_locaion", a.this.lXk.yFx);
                intent.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
                a.this.activity.startActivityForResult(intent, 4096);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55995);
            }
        });
        this.yKV.yLn = (TextView) inflate.findViewById(R.id.eqv);
        this.yKV.yLn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.a.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(55996);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
                com.tencent.mm.plugin.fav.a.b.a(a.this.activity, ".ui.FavTagEditUI", intent, 4100);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55996);
            }
        });
        edC();
    }

    /* access modifiers changed from: protected */
    public final String edE() {
        return Util.nullAs(this.yHz, "");
    }

    /* access modifiers changed from: protected */
    public final boolean c(LocationInfo locationInfo) {
        if (this.yKV.yHR.getIController() == null || !e.j(locationInfo.yFu, locationInfo.yFv)) {
            return false;
        }
        this.yKV.yHR.getIController().animateTo(locationInfo.yFu, locationInfo.yFv);
        return true;
    }

    public final View findViewById(int i2) {
        return this.activity.findViewById(i2);
    }

    /* access modifiers changed from: protected */
    public final void initView() {
        Log.d("MicroMsg.BaseMapUI", "initView");
        this.yKV.yLl = (LinearLayout) findViewById(R.id.do1);
        this.yKV.yHR = (com.tencent.mm.plugin.k.d) findViewById(R.id.dch);
        this.yKV.yLg = (FrameLayout) findViewById(R.id.bfr);
        this.yKV.yLh = (RelativeLayout) findViewById(R.id.iox);
        this.yKV.hNZ = (ImageView) findViewById(R.id.iq1);
        this.yKV.yLi = (ImageButton) findViewById(R.id.iq3);
        this.yKV.yLj = findViewById(R.id.iq4);
        this.yKV.yLk = (TextView) findViewById(R.id.d9);
        this.yKV.titleView = (TextView) findViewById(R.id.ff4);
        this.yKV.sLV = (TextView) findViewById(R.id.fke);
        this.yKV.titleView.setText(bmB());
        this.yKV.yHR.getIController().setZoom(d.ede());
        if (!(this.type == 0 || this.type == 3)) {
            this.yKV.yLi.setVisibility(0);
            this.yKV.yLj.setVisibility(8);
            this.yKV.yLi.setEnabled(false);
            this.yKV.yLi.setImageResource(R.raw.icons_outlined_more);
        }
        this.yKV.yHR.setBuiltInZoomControls(false);
        this.yKV.hNZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.a.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(55998);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.edF();
                a.this.hideVKB();
                a.this.activity.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55998);
            }
        });
        this.yKV.yLk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.a.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(55999);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/BaseMapUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/BaseMapUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(55999);
            }
        });
        edG();
        setActionbarColor(MMApplicationContext.getResources().getColor(R.color.a2r));
        this.yKV.yHR.setMapAnchor(0.5f, 0.5f);
    }

    /* access modifiers changed from: protected */
    public final void setActionbarColor(int i2) {
        int i3;
        this.yKV.yLl.setBackgroundColor(i2);
        Boolean valueOf = Boolean.valueOf(ar.aln(i2));
        if (valueOf.booleanValue()) {
            this.yKV.hNZ.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            this.yKV.yLi.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            this.yKV.titleView.setTextColor(MMApplicationContext.getResources().getColor(R.color.ag2));
        } else {
            this.yKV.hNZ.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
            this.yKV.yLi.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
            this.yKV.titleView.setTextColor(MMApplicationContext.getResources().getColor(R.color.fr));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            if (Build.VERSION.SDK_INT < 23 || g.isMIUIV8()) {
                i2 = Build.VERSION.SDK_INT >= 21 ? ar.v(this.activity.getResources().getColor(R.color.a_7), i2) : 0;
            }
            this.activity.getWindow().setStatusBarColor(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                View decorView = this.activity.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (valueOf.booleanValue()) {
                    i3 = systemUiVisibility & -8193;
                } else {
                    i3 = systemUiVisibility | 8192;
                }
                decorView.setSystemUiVisibility(i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$a  reason: collision with other inner class name */
    public class C1463a {
        ImageView hNZ;
        TextView sLV;
        TextView titleView;
        com.tencent.mm.plugin.k.d yHR;
        FrameLayout yLg;
        RelativeLayout yLh;
        ImageButton yLi;
        View yLj;
        TextView yLk;
        LinearLayout yLl;
        TextView yLm;
        TextView yLn;

        C1463a() {
        }
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (-1 == i3) {
            if (4096 == i2) {
                if (this.yKV.yLm != null) {
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                    this.yHz = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                    edC();
                }
            } else if (4100 == i2 && this.yKV.yLn != null) {
                this.yLa = intent.getStringArrayListExtra("key_fav_result_list");
                edC();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void hideVKB() {
        View currentFocus;
        IBinder windowToken;
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = this.activity.getCurrentFocus()) != null && (windowToken = currentFocus.getWindowToken()) != null) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    @Override // com.tencent.mm.plugin.k.a
    public boolean edH() {
        return true;
    }
}
