package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.pluginsdk.location.Location;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020NH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020NH\u0016J\b\u0010R\u001a\u00020NH\u0014J\b\u0010S\u001a\u00020NH\u0014J\b\u0010T\u001a\u00020NH\u0016J\u0010\u0010U\u001a\u00020N2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010V\u001a\u00020N2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010W\u001a\u00020NH\u0016J\u0010\u0010X\u001a\u00020N2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010Y\u001a\u00020N2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010Z\u001a\u00020N2\u0006\u0010#\u001a\u00020\nH\u0016J\b\u0010[\u001a\u00020NH\u0016J\u0010\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020\nH\u0016J\u0010\u0010^\u001a\u00020N2\u0006\u0010#\u001a\u00020\nH\u0016J\u0012\u0010_\u001a\u00020N2\b\u0010`\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010a\u001a\u00020N2\u0006\u0010L\u001a\u00020\nH\u0016J\u0010\u0010b\u001a\u00020N2\u0006\u0010c\u001a\u00020\nH\u0016J\u001c\u0010d\u001a\u00020N2\b\u0010e\u001a\u0004\u0018\u00010\r2\b\u0010f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010g\u001a\u00020N2\b\u0010h\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010i\u001a\u00020N2\b\u0010e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010j\u001a\u00020N2\u0006\u0010L\u001a\u00020\nH\u0016J\u0010\u0010k\u001a\u00020N2\u0006\u0010l\u001a\u00020\nH\u0016R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R\u001a\u0010C\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0015\"\u0004\bE\u0010\u0017R\u001a\u0010F\u001a\u00020;X.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?R\u001a\u0010I\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)R\u000e\u0010L\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLocationView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickLocationListener", "Lcom/tencent/mm/pluginsdk/location/ILocationView$OnClickLocationListener;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "defaultLoadingPBarColor", "defaultLoadingTipColor", "defaultStateIconColor", "defaultStateTextColor", m.NAME, "Lcom/tencent/mm/modelgeo/LocationGeo;", "kotlin.jvm.PlatformType", "getGetLocation", "()Lcom/tencent/mm/modelgeo/LocationGeo;", "setGetLocation", "(Lcom/tencent/mm/modelgeo/LocationGeo;)V", "iconColor", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLocationIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLocationIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "locationListener", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getLocationListener", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "locationLoadingProBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getLocationLoadingProBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "setLocationLoadingProBar", "(Lcom/tencent/mm/ui/widget/MMProcessBar;)V", "locationLoadingTip", "Landroid/widget/TextView;", "getLocationLoadingTip", "()Landroid/widget/TextView;", "setLocationLoadingTip", "(Landroid/widget/TextView;)V", "locationLoadingView", "getLocationLoadingView", "setLocationLoadingView", "locationNormalView", "getLocationNormalView", "setLocationNormalView", "locationTv", "getLocationTv", "setLocationTv", "longitude", "getLongitude", "setLongitude", "textColor", "GDPRLocationConfirm", "", "doClickAfterPermission", "Lcom/tencent/mm/pluginsdk/location/Location;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onAttachedToWindow", "onDetachedFromWindow", "resetLocationColor", "setDefaultLoadingPBarColor", "setDefaultLoadingTipColor", "setDefaultState", "setDefaultStateIconColor", "setDefaultStateTextColor", "setIconColor", "setLoadingState", "setLocationIcon", "resId", "setLocationIconColor", "setLocationName", "locationName", "setLocationNameColor", "setLocationTipColor", "color", "setNormalState", "city", "poiName", "setOnClickLocationListener", "onClickLocationListener", "setSuggestView", "setTextColor", "updateLoadingView", "id", "plugin-finder_release"})
public final class FinderLiveLocationView extends LinearLayout implements com.tencent.mm.pluginsdk.location.b {
    private final String TAG = "Finder.FinderLiveLocationView";
    public View contentView;
    private float dTj = -1000.0f;
    private float latitude = -85.0f;
    private int textColor;
    public WeImageView uzl;
    public TextView uzm;
    public View uzo;
    public MMProcessBar uzp;
    public TextView uzq;
    public View uzr;
    private d uzs = d.bca();
    private int uzt;
    private int uzu;
    private int uzv;
    private int uzw;
    private int uzx;
    b.a uzy;
    private final b.a uzz = new b(this);

    public final String getTAG() {
        return this.TAG;
    }

    public final WeImageView getLocationIv() {
        AppMethodBeat.i(247493);
        WeImageView weImageView = this.uzl;
        if (weImageView == null) {
            p.btv("locationIv");
        }
        AppMethodBeat.o(247493);
        return weImageView;
    }

    public final void setLocationIv(WeImageView weImageView) {
        AppMethodBeat.i(247494);
        p.h(weImageView, "<set-?>");
        this.uzl = weImageView;
        AppMethodBeat.o(247494);
    }

    public final TextView getLocationTv() {
        AppMethodBeat.i(247495);
        TextView textView = this.uzm;
        if (textView == null) {
            p.btv("locationTv");
        }
        AppMethodBeat.o(247495);
        return textView;
    }

    public final void setLocationTv(TextView textView) {
        AppMethodBeat.i(247496);
        p.h(textView, "<set-?>");
        this.uzm = textView;
        AppMethodBeat.o(247496);
    }

    public final View getLocationLoadingView() {
        AppMethodBeat.i(247499);
        View view = this.uzo;
        if (view == null) {
            p.btv("locationLoadingView");
        }
        AppMethodBeat.o(247499);
        return view;
    }

    public final void setLocationLoadingView(View view) {
        AppMethodBeat.i(247500);
        p.h(view, "<set-?>");
        this.uzo = view;
        AppMethodBeat.o(247500);
    }

    public final MMProcessBar getLocationLoadingProBar() {
        AppMethodBeat.i(247501);
        MMProcessBar mMProcessBar = this.uzp;
        if (mMProcessBar == null) {
            p.btv("locationLoadingProBar");
        }
        AppMethodBeat.o(247501);
        return mMProcessBar;
    }

    public final void setLocationLoadingProBar(MMProcessBar mMProcessBar) {
        AppMethodBeat.i(247502);
        p.h(mMProcessBar, "<set-?>");
        this.uzp = mMProcessBar;
        AppMethodBeat.o(247502);
    }

    public final TextView getLocationLoadingTip() {
        AppMethodBeat.i(247503);
        TextView textView = this.uzq;
        if (textView == null) {
            p.btv("locationLoadingTip");
        }
        AppMethodBeat.o(247503);
        return textView;
    }

    public final void setLocationLoadingTip(TextView textView) {
        AppMethodBeat.i(247504);
        p.h(textView, "<set-?>");
        this.uzq = textView;
        AppMethodBeat.o(247504);
    }

    public final View getLocationNormalView() {
        AppMethodBeat.i(247505);
        View view = this.uzr;
        if (view == null) {
            p.btv("locationNormalView");
        }
        AppMethodBeat.o(247505);
        return view;
    }

    public final void setLocationNormalView(View view) {
        AppMethodBeat.i(247506);
        p.h(view, "<set-?>");
        this.uzr = view;
        AppMethodBeat.o(247506);
    }

    public final View getContentView() {
        AppMethodBeat.i(247507);
        View view = this.contentView;
        if (view == null) {
            p.btv("contentView");
        }
        AppMethodBeat.o(247507);
        return view;
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(247508);
        p.h(view, "<set-?>");
        this.contentView = view;
        AppMethodBeat.o(247508);
    }

    public final d getGetLocation() {
        return this.uzs;
    }

    public final void setGetLocation(d dVar) {
        this.uzs = dVar;
    }

    public final float getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(float f2) {
        this.latitude = f2;
    }

    public final float getLongitude() {
        return this.dTj;
    }

    public final void setLongitude(float f2) {
        this.dTj = f2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setIconColor(int i2) {
        this.uzt = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setTextColor(int i2) {
        this.textColor = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setDefaultStateIconColor(int i2) {
        this.uzu = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setDefaultStateTextColor(int i2) {
        this.uzv = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setDefaultLoadingPBarColor(int i2) {
        this.uzw = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setDefaultLoadingTipColor(int i2) {
        this.uzx = i2;
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setOnClickLocationListener(b.a aVar) {
        this.uzy = aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(247523);
        init();
        AppMethodBeat.o(247523);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLocationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(247524);
        init();
        AppMethodBeat.o(247524);
    }

    private void init() {
        AppMethodBeat.i(247509);
        View inflate = View.inflate(getContext(), R.layout.aec, this);
        p.g(inflate, "View.inflate(context, R.…_location_geo_view, this)");
        this.contentView = inflate;
        View findViewById = findViewById(R.id.eq9);
        p.g(findViewById, "findViewById(R.id.location_icon)");
        this.uzl = (WeImageView) findViewById;
        View findViewById2 = findViewById(R.id.eqn);
        p.g(findViewById2, "findViewById(R.id.location_poi_name)");
        this.uzm = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.eqh);
        p.g(findViewById3, "findViewById(R.id.location_loading_view)");
        this.uzo = findViewById3;
        View findViewById4 = findViewById(R.id.eqz);
        p.g(findViewById4, "findViewById(R.id.location_verifying_icon)");
        this.uzp = (MMProcessBar) findViewById4;
        View findViewById5 = findViewById(R.id.er0);
        p.g(findViewById5, "findViewById(R.id.location_verifying_tip)");
        this.uzq = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.eql);
        p.g(findViewById6, "findViewById(R.id.location_normal_view)");
        this.uzr = findViewById6;
        setBackgroundResource(R.drawable.qa);
        a aVar = new a(this);
        View view = this.contentView;
        if (view == null) {
            p.btv("contentView");
        }
        view.setOnClickListener(aVar);
        AppMethodBeat.o(247509);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ FinderLiveLocationView uzA;

        a(FinderLiveLocationView finderLiveLocationView) {
            this.uzA = finderLiveLocationView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247491);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(274436);
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(247491);
                throw tVar;
            }
            if (!com.tencent.mm.aw.b.Pi((String) obj)) {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) this.uzA.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
                Log.i(this.uzA.getTAG(), "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(247491);
                    return;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(this.uzA.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                Object obj2 = aAh2.azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.o(247491);
                    throw tVar2;
                }
                if (((Boolean) obj2).booleanValue()) {
                    FinderLiveLocationView finderLiveLocationView = this.uzA;
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", finderLiveLocationView.getResources().getString(R.string.el_));
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", false);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                    c.b(finderLiveLocationView.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    com.tencent.mm.pluginsdk.permission.b.b((Activity) this.uzA.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247491);
                return;
            }
            b.a aVar = this.uzA.uzy;
            if (aVar != null) {
                aVar.dBx();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247491);
        }
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void dix() {
        AppMethodBeat.i(247510);
        View view = this.uzr;
        if (view == null) {
            p.btv("locationNormalView");
        }
        view.setVisibility(8);
        View view2 = this.uzo;
        if (view2 == null) {
            p.btv("locationLoadingView");
        }
        view2.setVisibility(0);
        AppMethodBeat.o(247510);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setSuggestView(String str) {
        AppMethodBeat.i(247511);
        View view = this.uzr;
        if (view == null) {
            p.btv("locationNormalView");
        }
        view.setVisibility(0);
        View view2 = this.uzo;
        if (view2 == null) {
            p.btv("locationLoadingView");
        }
        view2.setVisibility(8);
        setLocationName(str);
        setLocationNameColor(this.textColor);
        setLocationIcon(R.raw.icons_filled_location);
        setLocationIconColor(this.uzt);
        AppMethodBeat.o(247511);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void gM(String str, String str2) {
        AppMethodBeat.i(247512);
        View view = this.uzr;
        if (view == null) {
            p.btv("locationNormalView");
        }
        view.setVisibility(0);
        View view2 = this.uzo;
        if (view2 == null) {
            p.btv("locationLoadingView");
        }
        view2.setVisibility(8);
        if (!Util.isNullOrNil(str2)) {
            setLocationName(str2);
        } else {
            setLocationName(str);
        }
        setLocationNameColor(this.textColor);
        setLocationIcon(R.raw.icons_filled_location);
        setLocationIconColor(this.uzt);
        AppMethodBeat.o(247512);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void diy() {
        AppMethodBeat.i(247513);
        View view = this.uzr;
        if (view == null) {
            p.btv("locationNormalView");
        }
        view.setVisibility(0);
        View view2 = this.uzo;
        if (view2 == null) {
            p.btv("locationLoadingView");
        }
        view2.setVisibility(8);
        setLocationName(getContext().getString(R.string.jb_));
        WeImageView weImageView = this.uzl;
        if (weImageView == null) {
            p.btv("locationIv");
        }
        weImageView.setIconColor(this.uzu);
        TextView textView = this.uzm;
        if (textView == null) {
            p.btv("locationTv");
        }
        textView.setTextColor(this.uzv);
        setLocationIcon(R.raw.icons_filled_location);
        AppMethodBeat.o(247513);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\n¢\u0006\u0002\b\f"}, hxF = {"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
    static final class b implements b.a {
        final /* synthetic */ FinderLiveLocationView uzA;

        b(FinderLiveLocationView finderLiveLocationView) {
            this.uzA = finderLiveLocationView;
        }

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(247492);
            if (!z) {
                AppMethodBeat.o(247492);
                return true;
            }
            Log.d(this.uzA.getTAG(), "get location %f %f", Float.valueOf(f3), Float.valueOf(f2));
            o.a(2015, f2, f3, 0);
            if (this.uzA.getLatitude() == -85.0f || this.uzA.getLongitude() == -1000.0f) {
                this.uzA.setLatitude(f3);
                this.uzA.setLongitude(f2);
            }
            AppMethodBeat.o(247492);
            return false;
        }
    }

    public final b.a getLocationListener() {
        return this.uzz;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(247514);
        super.onAttachedToWindow();
        this.uzs.b(this.uzz);
        AppMethodBeat.o(247514);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(247515);
        super.onDetachedFromWindow();
        this.uzs.c(this.uzz);
        AppMethodBeat.o(247515);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void setLocationName(String str) {
        AppMethodBeat.i(247516);
        TextView textView = this.uzm;
        if (textView == null) {
            p.btv("locationTv");
        }
        textView.setText(str);
        AppMethodBeat.o(247516);
    }

    public final void setLocationIconColor(int i2) {
        AppMethodBeat.i(247517);
        WeImageView weImageView = this.uzl;
        if (weImageView == null) {
            p.btv("locationIv");
        }
        weImageView.setIconColor(i2);
        AppMethodBeat.o(247517);
    }

    public final void setLocationIcon(int i2) {
        AppMethodBeat.i(247518);
        WeImageView weImageView = this.uzl;
        if (weImageView == null) {
            p.btv("locationIv");
        }
        weImageView.setImageResource(i2);
        AppMethodBeat.o(247518);
    }

    public final void setLocationNameColor(int i2) {
        AppMethodBeat.i(247519);
        TextView textView = this.uzm;
        if (textView == null) {
            p.btv("locationTv");
        }
        textView.setTextColor(i2);
        AppMethodBeat.o(247519);
    }

    public final Location getLocation() {
        AppMethodBeat.i(247520);
        Location location = new Location(this.latitude, this.dTj);
        AppMethodBeat.o(247520);
        return location;
    }

    public final void setLocationTipColor(int i2) {
        AppMethodBeat.i(247521);
        AppMethodBeat.o(247521);
    }

    @Override // com.tencent.mm.pluginsdk.location.b
    public final void diz() {
        AppMethodBeat.i(247522);
        MMProcessBar mMProcessBar = this.uzp;
        if (mMProcessBar == null) {
            p.btv("locationLoadingProBar");
        }
        mMProcessBar.setBackground$255f295(this.uzw);
        TextView textView = this.uzq;
        if (textView == null) {
            p.btv("locationLoadingTip");
        }
        textView.setTextColor(this.uzx);
        AppMethodBeat.o(247522);
    }
}
