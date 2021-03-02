package com.tencent.mm.pluginsdk.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class LocationView extends LinearLayout implements b {
    private View contentView;
    private float dTj;
    private float latitude;
    private int textColor;
    private WeImageView uzl;
    private TextView uzm;
    private TextView uzn;
    private View uzo;
    private MMProcessBar uzp;
    private TextView uzq;
    private View uzr;
    private d uzs;
    private int uzt;
    private int uzu;
    private int uzv;
    private int uzw;
    private int uzx;
    private b.a uzy;
    private b.a uzz;

    public LocationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public LocationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(169201);
        this.uzs = d.bca();
        this.latitude = -85.0f;
        this.dTj = -1000.0f;
        this.uzz = new b.a() {
            /* class com.tencent.mm.pluginsdk.location.LocationView.AnonymousClass2 */

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                AppMethodBeat.i(169200);
                if (!z) {
                    AppMethodBeat.o(169200);
                    return true;
                }
                Log.d("MicroMsg.LocationView", "get location %f %f", Float.valueOf(f3), Float.valueOf(f2));
                o.a(2015, f2, f3, 0);
                if (LocationView.this.latitude == -85.0f || LocationView.this.dTj == -1000.0f) {
                    LocationView.this.latitude = f3;
                    LocationView.this.dTj = f2;
                }
                AppMethodBeat.o(169200);
                return false;
            }
        };
        this.contentView = View.inflate(getContext(), R.layout.b2b, this);
        this.uzl = (WeImageView) findViewById(R.id.eq9);
        this.uzm = (TextView) findViewById(R.id.eqn);
        this.uzn = (TextView) findViewById(R.id.eqo);
        this.uzo = findViewById(R.id.eqh);
        this.uzp = (MMProcessBar) findViewById(R.id.eqz);
        this.uzq = (TextView) findViewById(R.id.er0);
        this.uzr = findViewById(R.id.eql);
        setBackgroundResource(R.drawable.qa);
        this.contentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.location.LocationView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(169199);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                    boolean a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) LocationView.this.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
                    Log.i("MicroMsg.LocationView", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                    if (!a2) {
                        a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(169199);
                        return;
                    }
                } else if (!com.tencent.mm.pluginsdk.permission.b.n(LocationView.this.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                    if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                        LocationView.a(LocationView.this);
                    } else {
                        com.tencent.mm.pluginsdk.permission.b.b((Activity) LocationView.this.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
                    }
                    a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(169199);
                    return;
                }
                LocationView.b(LocationView.this);
                a.a(this, "com/tencent/mm/pluginsdk/location/LocationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(169199);
            }
        });
        setTextColor(getContext().getResources().getColor(R.color.Orange));
        setIconColor(getContext().getResources().getColor(R.color.Orange));
        setDefaultStateIconColor(getContext().getResources().getColor(R.color.a2x));
        setDefaultStateTextColor(getContext().getResources().getColor(R.color.a2x));
        setDefaultLoadingPBarColor(getContext().getResources().getColor(R.color.Orange));
        setDefaultLoadingTipColor(getContext().getResources().getColor(R.color.FG_2));
        AppMethodBeat.o(169201);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void dix() {
        AppMethodBeat.i(223716);
        this.uzr.setVisibility(8);
        this.uzo.setVisibility(0);
        AppMethodBeat.o(223716);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setSuggestView(String str) {
        AppMethodBeat.i(223717);
        this.uzr.setVisibility(0);
        this.uzo.setVisibility(8);
        this.uzn.setVisibility(0);
        setLocationName(str);
        setLocationNameColor(this.textColor);
        setLocationIcon(R.raw.icons_filled_location);
        setLocationIconColor(this.uzt);
        AppMethodBeat.o(223717);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void gM(String str, String str2) {
        AppMethodBeat.i(223718);
        this.uzr.setVisibility(0);
        this.uzo.setVisibility(8);
        this.uzn.setVisibility(8);
        if (!Util.isNullOrNil(str2)) {
            setLocationName(str2);
        } else {
            setLocationName(str);
        }
        setLocationNameColor(this.textColor);
        setLocationIcon(R.raw.icons_filled_location);
        setLocationIconColor(this.uzt);
        AppMethodBeat.o(223718);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void diy() {
        AppMethodBeat.i(169208);
        this.uzr.setVisibility(0);
        this.uzo.setVisibility(8);
        this.uzn.setVisibility(8);
        setLocationName(getContext().getString(R.string.ekj));
        this.uzl.setIconColor(this.uzu);
        this.uzm.setTextColor(this.uzv);
        setLocationIcon(R.raw.icons_outlined_location);
        AppMethodBeat.o(169208);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(169202);
        super.onAttachedToWindow();
        this.uzs.a(this.uzz, true);
        AppMethodBeat.o(169202);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(169203);
        super.onDetachedFromWindow();
        this.uzs.c(this.uzz);
        AppMethodBeat.o(169203);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setOnClickLocationListener(b.a aVar) {
        this.uzy = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setLocationName(String str) {
        AppMethodBeat.i(169204);
        this.uzm.setText(str);
        AppMethodBeat.o(169204);
    }

    public void setLocationIconColor(int i2) {
        AppMethodBeat.i(169205);
        this.uzl.setIconColor(i2);
        AppMethodBeat.o(169205);
    }

    public void setLocationIcon(int i2) {
        AppMethodBeat.i(169206);
        this.uzl.setImageResource(i2);
        AppMethodBeat.o(169206);
    }

    public void setLocationNameColor(int i2) {
        AppMethodBeat.i(169207);
        this.uzm.setTextColor(i2);
        AppMethodBeat.o(169207);
    }

    public Location getLocation() {
        AppMethodBeat.i(169209);
        Location location = new Location(this.latitude, this.dTj);
        AppMethodBeat.o(169209);
        return location;
    }

    public void setLocationTipColor(int i2) {
        AppMethodBeat.i(223719);
        this.uzn.setTextColor(i2);
        AppMethodBeat.o(223719);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setIconColor(int i2) {
        this.uzt = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setTextColor(int i2) {
        this.textColor = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setDefaultStateIconColor(int i2) {
        this.uzu = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setDefaultStateTextColor(int i2) {
        this.uzv = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void diz() {
        AppMethodBeat.i(223720);
        this.uzp.setBackground$255f295(this.uzw);
        this.uzq.setTextColor(this.uzx);
        AppMethodBeat.o(223720);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setDefaultLoadingPBarColor(int i2) {
        this.uzw = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public void setDefaultLoadingTipColor(int i2) {
        this.uzx = i2;
    }

    static /* synthetic */ void a(LocationView locationView) {
        AppMethodBeat.i(169210);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", locationView.getResources().getString(R.string.el_));
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", false);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        c.b(locationView.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(169210);
    }

    static /* synthetic */ void b(LocationView locationView) {
        AppMethodBeat.i(169211);
        if (locationView.uzy != null) {
            locationView.uzy.dBx();
        }
        AppMethodBeat.o(169211);
    }
}
