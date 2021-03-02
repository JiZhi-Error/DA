package com.tencent.mm.plugin.finder.widget.pref;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017H\u0014J\u0012\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010)\u001a\u00020*H\u0014J\u0006\u0010+\u001a\u00020&R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cityCode", "", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "locationIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mView", "Landroid/view/View;", "provinceCode", "getProvinceCode", "setProvinceCode", "selectIV", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "showLocationIcon", "getShowLocationIcon", "setShowLocationIcon", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "updateTitle", "plugin-finder_release"})
public final class FinderLocationPreference extends Preference {
    public String cityCode = "";
    public String countryCode = "";
    private View mView;
    public String provinceCode = "";
    public boolean uOQ;
    private WeImageView wDF;
    private WeImageView wDG;
    public boolean wDH;

    public final void setCountryCode(String str) {
        AppMethodBeat.i(178497);
        p.h(str, "<set-?>");
        this.countryCode = str;
        AppMethodBeat.o(178497);
    }

    public final void awY(String str) {
        AppMethodBeat.i(178498);
        p.h(str, "<set-?>");
        this.provinceCode = str;
        AppMethodBeat.o(178498);
    }

    public final void awZ(String str) {
        AppMethodBeat.i(178499);
        p.h(str, "<set-?>");
        this.cityCode = str;
        AppMethodBeat.o(178499);
    }

    public FinderLocationPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(178503);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(178503);
    }

    public FinderLocationPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(178500);
        p.h(viewGroup, "parent");
        View onCreateView = super.onCreateView(viewGroup);
        View findViewById = onCreateView.findViewById(R.id.be9);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(178500);
            throw tVar;
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.ag9, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(178500);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(178501);
        p.h(view, "view");
        super.onBindView(view);
        alO(8);
        View findViewById = view.findViewById(R.id.i4u);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
            AppMethodBeat.o(178501);
            throw tVar;
        }
        this.wDG = (WeImageView) findViewById;
        WeImageView weImageView = this.wDG;
        if (weImageView != null) {
            if (this.uOQ) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            weImageView.setVisibility(i2);
        }
        View findViewById2 = view.findViewById(R.id.eq9);
        if (findViewById2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
            AppMethodBeat.o(178501);
            throw tVar2;
        }
        this.wDF = (WeImageView) findViewById2;
        WeImageView weImageView2 = this.wDF;
        if (weImageView2 != null) {
            if (!this.wDH) {
                i3 = 8;
            }
            weImageView2.setVisibility(i3);
            AppMethodBeat.o(178501);
            return;
        }
        AppMethodBeat.o(178501);
    }

    public final void updateTitle() {
        AppMethodBeat.i(178502);
        if (!p.j(this.countryCode, "unshow")) {
            if (!(this.countryCode.length() == 0)) {
                RegionCodeDecoder.gEm();
                String country = RegionCodeDecoder.getCountry(this.countryCode);
                RegionCodeDecoder.gEm();
                String mV = RegionCodeDecoder.mV(this.countryCode, this.provinceCode);
                RegionCodeDecoder.gEm();
                String br = RegionCodeDecoder.br(this.countryCode, this.provinceCode, this.cityCode);
                if (!Util.isNullOrNil(br)) {
                    setTitle(((b) g.af(b.class)).It(mV) + " " + br);
                    AppMethodBeat.o(178502);
                    return;
                } else if (!Util.isNullOrNil(mV)) {
                    setTitle(country + ' ' + mV);
                    AppMethodBeat.o(178502);
                    return;
                } else {
                    if (!Util.isNullOrNil(country)) {
                        setTitle(country);
                    }
                    AppMethodBeat.o(178502);
                    return;
                }
            }
        }
        setTitle(getContext().getString(R.string.d9g));
        AppMethodBeat.o(178502);
    }
}
