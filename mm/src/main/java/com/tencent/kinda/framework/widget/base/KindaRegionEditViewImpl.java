package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KRegionEditView;
import com.tencent.kinda.gen.KRegionEditViewOnRegionSelectedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class KindaRegionEditViewImpl extends MMKView<View> implements KRegionEditView {
    private int REQUEST_CODE;
    private String cityCode;
    private String countryCode;
    private ArrayList<String> excludeAreaList;
    private UIPageFragmentActivity.a intentHandler = new UIPageFragmentActivity.a() {
        /* class com.tencent.kinda.framework.widget.base.KindaRegionEditViewImpl.AnonymousClass1 */

        @Override // com.tencent.mm.framework.app.UIPageFragmentActivity.a
        public void handle(int i2, Intent intent) {
            AppMethodBeat.i(18938);
            if (i2 != -1) {
                AppMethodBeat.o(18938);
                return;
            }
            KindaRegionEditViewImpl.this.countryCode = intent.getStringExtra("Country");
            if (!Util.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                KindaRegionEditViewImpl.this.provinceCode = intent.getStringExtra("Contact_Province");
                KindaRegionEditViewImpl.this.cityCode = intent.getStringExtra("Contact_City");
            } else if (!Util.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
                KindaRegionEditViewImpl.this.cityCode = intent.getStringExtra("Contact_Province");
            } else {
                KindaRegionEditViewImpl.this.cityCode = KindaRegionEditViewImpl.this.countryCode;
            }
            String stringExtra = intent.getStringExtra("CountryName");
            String stringExtra2 = intent.getStringExtra("ProviceName");
            String stringExtra3 = intent.getStringExtra("CityName");
            StringBuilder sb = new StringBuilder();
            if (!Util.isNullOrNil(stringExtra)) {
                sb.append(stringExtra);
            }
            if (!Util.isNullOrNil(stringExtra2)) {
                sb.append(" ").append(stringExtra2);
            }
            if (!Util.isNullOrNil(stringExtra3)) {
                sb.append(" ").append(stringExtra3);
            }
            KindaRegionEditViewImpl.this.mEditText.setText(sb.toString());
            if (KindaRegionEditViewImpl.this.mCallback != null) {
                KindaRegionEditViewImpl.this.mCallback.onRegionSelected();
            }
            AppMethodBeat.o(18938);
        }
    };
    private boolean mAutoLocation = false;
    private KRegionEditViewOnRegionSelectedCallback mCallback;
    private Context mContext;
    private EditText mEditText;
    private boolean mShowDomesticCity = false;
    private boolean mShowSelectedLocation = true;
    private String provinceCode;

    public KindaRegionEditViewImpl() {
        AppMethodBeat.i(18939);
        AppMethodBeat.o(18939);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public View createView(Context context) {
        AppMethodBeat.i(18945);
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setHint(R.string.i_y);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0f));
        this.mEditText.setPadding(0, 0, 0, 0);
        this.mContext = context;
        if (this.mContext instanceof UIPageFragmentActivity) {
            this.REQUEST_CODE = ((UIPageFragmentActivity) this.mContext).hgB.getAndIncrement();
            UIPageFragmentActivity.a(this.REQUEST_CODE, this.intentHandler);
        }
        LayoutWrapper layoutWrapper = new LayoutWrapper(context, this.mEditText);
        AppMethodBeat.o(18945);
        return layoutWrapper;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setOriginRegion(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(18941);
        this.countryCode = str;
        this.provinceCode = str2;
        this.cityCode = str3;
        if (!Util.isNullOrNil(str4)) {
            this.mEditText.setText(str4);
        }
        AppMethodBeat.o(18941);
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setAreaExcludeArray(ArrayList<String> arrayList) {
        this.excludeAreaList = arrayList;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public String getCountry() {
        return this.countryCode;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public String getProvince() {
        return this.provinceCode;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public String getCity() {
        return this.cityCode;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public boolean isUSOrCA() {
        AppMethodBeat.i(18942);
        if (Util.isNullOrNil(this.countryCode)) {
            AppMethodBeat.o(18942);
            return false;
        } else if ("US".equals(this.countryCode) || "CA".equals(this.countryCode)) {
            AppMethodBeat.o(18942);
            return true;
        } else {
            AppMethodBeat.o(18942);
            return false;
        }
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setShowDomesticCity(boolean z) {
        this.mShowDomesticCity = z;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public boolean getShowDomesticCity() {
        return this.mShowDomesticCity;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setShowSelectedLocation(boolean z) {
        this.mShowSelectedLocation = z;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public boolean getShowSelectedLocation() {
        return this.mShowSelectedLocation;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setAutoLocation(boolean z) {
        this.mAutoLocation = z;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public boolean getAutoLocation() {
        return this.mAutoLocation;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18943);
        if (z && (this.mContext instanceof BaseFrActivity)) {
            ((BaseFrActivity) this.mContext).hideTenpayKB();
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.tools.MultiStageCitySelectUI");
            intent.putExtra("GetAddress", true);
            intent.putExtra("IsNeedShowSearchBar", this.mShowDomesticCity);
            intent.putExtra("IsRealNameVerifyScene", this.mShowDomesticCity);
            intent.putExtra("ShowSelectedLocation", this.mShowSelectedLocation);
            intent.putExtra("IsAutoPosition", this.mAutoLocation);
            if (this.excludeAreaList != null && !this.excludeAreaList.isEmpty()) {
                intent.putStringArrayListExtra("BlockedCountries", this.excludeAreaList);
            }
            ((BaseFrActivity) this.mContext).startActivityForResult(intent, this.REQUEST_CODE);
        }
        AppMethodBeat.o(18943);
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public boolean getFocus() {
        AppMethodBeat.i(18944);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18944);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KRegionEditView
    public void setOnRegionSelectedCallback(KRegionEditViewOnRegionSelectedCallback kRegionEditViewOnRegionSelectedCallback) {
        this.mCallback = kRegionEditViewOnRegionSelectedCallback;
    }
}
