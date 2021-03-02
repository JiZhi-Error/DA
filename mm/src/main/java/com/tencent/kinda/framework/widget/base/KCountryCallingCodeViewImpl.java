package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCountryCallingCodeView;
import com.tencent.kinda.gen.KCountryCallingCodeViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class KCountryCallingCodeViewImpl extends MMKView implements KCountryCallingCodeView {
    private static final String TAG = "KCountryCallingCodeView";
    private String[] mBannedCountryIsoCodes;
    private KCountryCallingCodeViewOnSelectCallback mCallback;
    private String mCountryCode;
    private HashMap<String, b.a> mCountryCodeMap;
    private String mCountryIsoCode;
    private String mCountryName;
    private EditText mEditText;
    private boolean mHideCode;
    private HashMap<String, b.a> mISOCountryCodeMap;
    private UIPageFragmentActivity mUIPageFragmentActivity;

    static /* synthetic */ void access$300(KCountryCallingCodeViewImpl kCountryCallingCodeViewImpl) {
        AppMethodBeat.i(18807);
        kCountryCallingCodeViewImpl.updateCountryName();
        AppMethodBeat.o(18807);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public View createView(Context context) {
        AppMethodBeat.i(18798);
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setTextSize(16.0f);
        this.mEditText.setPadding(0, 0, 0, 0);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (topOrUIPageFragmentActivity instanceof UIPageFragmentActivity) {
            this.mUIPageFragmentActivity = (UIPageFragmentActivity) topOrUIPageFragmentActivity;
            initData(topOrUIPageFragmentActivity);
        } else {
            Log.e(TAG, "没有找到UIPageFragmentActivity，却展示了KCountryCallingCodeView");
        }
        EditText editText = this.mEditText;
        AppMethodBeat.o(18798);
        return editText;
    }

    private void initData(Activity activity) {
        AppMethodBeat.i(18799);
        List<b.a> Pf = b.Pf(activity.getString(R.string.bj8));
        this.mCountryCodeMap = new HashMap<>();
        this.mISOCountryCodeMap = new HashMap<>();
        for (b.a aVar : Pf) {
            if (aVar != null) {
                this.mCountryCodeMap.put(aVar.jbY, aVar);
                this.mISOCountryCodeMap.put(aVar.jbX, aVar);
            }
        }
        AppMethodBeat.o(18799);
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18800);
        if (z && this.mUIPageFragmentActivity != null) {
            Log.d(TAG, "click area");
            Intent intent = new Intent();
            intent.putExtra("CountryCodeUI_isShowCountryCode", !this.mHideCode);
            intent.putExtra("exclude_countries_iso", this.mBannedCountryIsoCodes);
            intent.setClassName(this.mUIPageFragmentActivity, "com.tencent.mm.ui.tools.CountryCodeUI");
            this.mUIPageFragmentActivity.startActivityForResult(intent, ShareElfFile.SectionHeader.SHN_ABS);
        }
        AppMethodBeat.o(18800);
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public boolean getFocus() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setCountryCode(String str) {
        AppMethodBeat.i(18801);
        if (this.mCountryCodeMap != null) {
            if (str.contains("+")) {
                str = str.substring(1);
            }
            if ((str.equals("1") && this.mCountryIsoCode.equals("CA")) || (str.equals("1") && this.mCountryIsoCode.equals("US"))) {
                AppMethodBeat.o(18801);
                return;
            } else if (!this.mCountryCodeMap.containsKey(str) || this.mCountryCodeMap.get(str) == null) {
                Log.i(TAG, "country code is %s, can not found valid data, reset data to null", str);
                this.mCountryName = "";
                this.mCountryCode = "";
                this.mCountryIsoCode = "";
            } else {
                b.a aVar = this.mCountryCodeMap.get(str);
                Log.i(TAG, "country code is %s, find target data, country name is %s", str, this.mCountryName);
                this.mCountryCode = str;
                this.mCountryName = aVar.jbZ;
                this.mCountryIsoCode = aVar.jbX;
            }
        } else {
            Log.e(TAG, "输入国家代码后无法找到国家名称，因为国家代码、名称映射表为空！");
        }
        updateCountryName();
        AppMethodBeat.o(18801);
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public String getCountryCode() {
        return this.mCountryCode;
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setOnSelectCallback(KCountryCallingCodeViewOnSelectCallback kCountryCallingCodeViewOnSelectCallback) {
        AppMethodBeat.i(18802);
        this.mCallback = kCountryCallingCodeViewOnSelectCallback;
        AnonymousClass1 r0 = new UIPageFragmentActivity.a() {
            /* class com.tencent.kinda.framework.widget.base.KCountryCallingCodeViewImpl.AnonymousClass1 */

            @Override // com.tencent.mm.framework.app.UIPageFragmentActivity.a
            public void handle(int i2, Intent intent) {
                AppMethodBeat.i(18797);
                String stringExtra = intent.getStringExtra("country_name");
                String stringExtra2 = intent.getStringExtra("couttry_code");
                String stringExtra3 = intent.getStringExtra("iso_code");
                if (Util.isNullOrNil(stringExtra) || Util.isNullOrNil(stringExtra2)) {
                    Log.i(KCountryCallingCodeViewImpl.TAG, "countryName or countrycode is null , user cancel case");
                    AppMethodBeat.o(18797);
                    return;
                }
                KCountryCallingCodeViewImpl.this.mCountryName = stringExtra;
                KCountryCallingCodeViewImpl.this.mCountryCode = stringExtra2;
                KCountryCallingCodeViewImpl.this.mCountryIsoCode = stringExtra3;
                Log.i(KCountryCallingCodeViewImpl.TAG, "handle back mCountryName:%s.mCountryCode:%s mCountryIsoCode:%s", KCountryCallingCodeViewImpl.this.mCountryName, KCountryCallingCodeViewImpl.this.mCountryCode, KCountryCallingCodeViewImpl.this.mCountryIsoCode);
                KCountryCallingCodeViewImpl.access$300(KCountryCallingCodeViewImpl.this);
                KCountryCallingCodeViewImpl.this.mCallback.onSelect(KCountryCallingCodeViewImpl.this.mCountryCode, KCountryCallingCodeViewImpl.this.mCountryIsoCode);
                AppMethodBeat.o(18797);
            }
        };
        if (this.mUIPageFragmentActivity != null) {
            UIPageFragmentActivity.a((int) ShareElfFile.SectionHeader.SHN_ABS, r0);
        }
        AppMethodBeat.o(18802);
    }

    private void updateCountryName() {
        AppMethodBeat.i(18803);
        if (this.mCountryName == null || this.mCountryName.length() <= 0) {
            String str = null;
            if (this.mEditText.getHint() != null) {
                str = this.mEditText.getHint().toString();
            }
            if (str == null || str.length() == 0) {
                this.mEditText.setText(R.string.ip0);
                this.mEditText.setTextColor(this.mUIPageFragmentActivity.getResources().getColor(R.color.a5e));
            }
            AppMethodBeat.o(18803);
            return;
        }
        this.mEditText.setText(this.mCountryName);
        this.mEditText.setTextColor(this.mUIPageFragmentActivity.getResources().getColor(R.color.a2x));
        AppMethodBeat.o(18803);
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public String getPlaceHolder() {
        AppMethodBeat.i(18804);
        String charSequence = this.mEditText.getHint().toString();
        AppMethodBeat.o(18804);
        return charSequence;
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setPlaceHolder(String str) {
        AppMethodBeat.i(18805);
        this.mEditText.setHint(str);
        AppMethodBeat.o(18805);
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public boolean getHideCode() {
        return this.mHideCode;
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setHideCode(boolean z) {
        this.mHideCode = z;
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public String getNationality() {
        return this.mCountryIsoCode;
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setNationality(String str) {
        AppMethodBeat.i(18806);
        if (this.mISOCountryCodeMap != null) {
            Iterator<b.a> it = this.mISOCountryCodeMap.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b.a next = it.next();
                if (next.jbX.equals(str)) {
                    this.mCountryCode = next.jbY;
                    this.mCountryName = next.jbZ;
                    this.mCountryIsoCode = next.jbX;
                    break;
                }
            }
        }
        updateCountryName();
        AppMethodBeat.o(18806);
    }

    @Override // com.tencent.kinda.gen.KCountryCallingCodeView
    public void setNationalityExcludeArray(ArrayList<String> arrayList) {
        AppMethodBeat.i(214460);
        if (arrayList != null) {
            this.mBannedCountryIsoCodes = Util.listToStrings(arrayList);
        }
        AppMethodBeat.o(214460);
    }
}
