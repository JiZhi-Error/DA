package com.tencent.mm.plugin.wallet_core.id_verify;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;

public class WcPayRealnameInputAddressUI extends WalletBaseUI {
    public static String HRI = "key_countrycode";
    public static String HRJ = "key_provincecode";
    public static String HRK = "key_citycode";
    public static String HRL = "key_zone";
    public static String HRM = "key_address";
    public static String HRN = "key_exclude_country";
    private WalletFormView HRE;
    private Button HRF;
    private InputPanelLinearLayout HRG;
    private int HRH = 1;
    private String HRO;
    private Bundle HRP = new Bundle();
    private ArrayList<String> HRQ = new ArrayList<>();
    private WalletFormView HRv;
    private String cityCode;
    private String countryCode;
    private boolean hwq;
    private String iUO;
    private String provinceCode;
    private int ygg;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WcPayRealnameInputAddressUI() {
        AppMethodBeat.i(174450);
        AppMethodBeat.o(174450);
    }

    static /* synthetic */ void a(WcPayRealnameInputAddressUI wcPayRealnameInputAddressUI, boolean z) {
        AppMethodBeat.i(214172);
        wcPayRealnameInputAddressUI.aS(z, true);
        AppMethodBeat.o(214172);
    }

    static /* synthetic */ void c(WcPayRealnameInputAddressUI wcPayRealnameInputAddressUI) {
        AppMethodBeat.i(174456);
        wcPayRealnameInputAddressUI.fPX();
        AppMethodBeat.o(174456);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(174451);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.f3048f));
        hideActionbarLine();
        setMMTitle("");
        this.countryCode = getIntent().getStringExtra(HRI);
        this.provinceCode = getIntent().getStringExtra(HRJ);
        this.cityCode = getIntent().getStringExtra(HRK);
        this.HRO = getIntent().getStringExtra(HRL);
        this.iUO = getIntent().getStringExtra(HRM);
        String[] stringArrayExtra = getIntent().getStringArrayExtra(HRN);
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            this.HRQ.addAll(Arrays.asList(stringArrayExtra));
            this.HRQ.remove(WeChatBrands.AppInfo.LANG_CN);
            this.HRQ.remove(WeChatBrands.AppInfo.LANG_TW);
            this.HRQ.remove(WeChatBrands.AppInfo.LANG_HK);
            this.HRQ.remove("MO");
        }
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(174446);
                if (WcPayRealnameInputAddressUI.this.hwq) {
                    WcPayRealnameInputAddressUI.this.hideVKB();
                    WcPayRealnameInputAddressUI.this.hwq = false;
                } else {
                    WcPayRealnameInputAddressUI.this.setResult(0);
                    WcPayRealnameInputAddressUI.this.finish();
                }
                AppMethodBeat.o(174446);
                return false;
            }
        }, R.raw.actionbar_icon_dark_close);
        AppMethodBeat.o(174451);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(174452);
        this.HRE = (WalletFormView) findViewById(R.id.jq4);
        this.HRv = (WalletFormView) findViewById(R.id.jq0);
        this.HRF = (Button) findViewById(R.id.jq1);
        this.HRG = (InputPanelLinearLayout) findViewById(R.id.jq2);
        this.HRG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(214167);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameInputAddressUI.this.hideVKB();
                a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(214167);
            }
        });
        this.HRv.getContentEt().setInputType(131073);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.hs);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.bt);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = dimensionPixelSize2;
        this.HRv.getInfoIv().setLayoutParams(layoutParams);
        this.HRv.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.HRv.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        this.HRv.setText(this.iUO);
        this.HRv.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(214168);
                WcPayRealnameInputAddressUI.c(WcPayRealnameInputAddressUI.this);
                AppMethodBeat.o(214168);
            }
        });
        this.HRE.setText(this.HRO);
        this.HRE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(174449);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameInputAddressUI.d(WcPayRealnameInputAddressUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174449);
            }
        });
        this.HRF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(214169);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameInputAddressUI.this.hideVKB();
                Intent intent = new Intent();
                intent.putExtra(WcPayRealnameInputAddressUI.HRI, WcPayRealnameInputAddressUI.this.countryCode);
                intent.putExtra(WcPayRealnameInputAddressUI.HRJ, WcPayRealnameInputAddressUI.this.provinceCode);
                intent.putExtra(WcPayRealnameInputAddressUI.HRK, WcPayRealnameInputAddressUI.this.cityCode);
                intent.putExtra(WcPayRealnameInputAddressUI.HRL, WcPayRealnameInputAddressUI.this.HRE.getText());
                intent.putExtra(WcPayRealnameInputAddressUI.HRM, WcPayRealnameInputAddressUI.this.HRv.getText());
                WcPayRealnameInputAddressUI.this.setResult(-1, intent);
                WcPayRealnameInputAddressUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameInputAddressUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(214169);
            }
        });
        fPX();
        this.HRG.setExternalListener(new b.a() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameInputAddressUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.b.a
            public final void f(boolean z, int i2) {
                AppMethodBeat.i(214170);
                if (z) {
                    int height = ((WindowManager) WcPayRealnameInputAddressUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) WcPayRealnameInputAddressUI.this.getContext(), 96);
                    int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) WcPayRealnameInputAddressUI.this.getContext(), 40);
                    int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix((Context) WcPayRealnameInputAddressUI.this.getContext(), 32);
                    int fromDPToPix4 = com.tencent.mm.cb.a.fromDPToPix((Context) WcPayRealnameInputAddressUI.this.getContext(), 40);
                    int ay = (((height - au.ay(WcPayRealnameInputAddressUI.this.getContext())) - au.aD(WcPayRealnameInputAddressUI.this.getContext())) - h.eu(WcPayRealnameInputAddressUI.this.getContext())) - WcPayRealnameInputAddressUI.this.HRv.getBottom();
                    Log.d("MicroMsg.WcPayRealnameInputAddressUI", "marginBottomOriginPix：%s, marginBottomNewPix: %s, marginTopMinPix: %s, buttonHeightPix: %s, height: %s, offset: %s", Integer.valueOf(fromDPToPix), Integer.valueOf(fromDPToPix2), Integer.valueOf(fromDPToPix3), Integer.valueOf(fromDPToPix4), Integer.valueOf(ay), Integer.valueOf(((ay - fromDPToPix4) - i2) - fromDPToPix2));
                    if (((ay - fromDPToPix4) - i2) - fromDPToPix2 > fromDPToPix3) {
                        WcPayRealnameInputAddressUI.this.ygg = i2 - (fromDPToPix - fromDPToPix2);
                    } else {
                        WcPayRealnameInputAddressUI.this.ygg = ((ay - fromDPToPix3) - fromDPToPix4) - fromDPToPix;
                    }
                }
                WcPayRealnameInputAddressUI.a(WcPayRealnameInputAddressUI.this, z);
                Log.i("MicroMsg.WcPayRealnameInputAddressUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(WcPayRealnameInputAddressUI.this.ygg));
                AppMethodBeat.o(214170);
            }
        });
        float titleMeasuredWidth = this.HRv.getTitleMeasuredWidth();
        float titleMeasuredWidth2 = this.HRE.getTitleMeasuredWidth();
        Log.d("MicroMsg.WcPayRealnameInputAddressUI", "measured width: %s, %s", Float.valueOf(titleMeasuredWidth), Float.valueOf(titleMeasuredWidth2));
        float max = Math.max(titleMeasuredWidth, titleMeasuredWidth2) + 10.0f;
        this.HRv.setTitleWidth((int) max);
        this.HRE.setTitleWidth((int) max);
        f.a(new WalletFormView[]{this.HRv, this.HRE});
        AppMethodBeat.o(174452);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(182522);
        super.onPause();
        if (this.hwq) {
            hideVKB();
            aS(false, false);
            this.HRG.getInputPanelHelper().AxH = false;
        }
        AppMethodBeat.o(182522);
    }

    private void aS(boolean z, boolean z2) {
        ObjectAnimator ofFloat;
        AppMethodBeat.i(182523);
        this.hwq = z;
        if (z2) {
            if (z) {
                ofFloat = ObjectAnimator.ofFloat(this.HRF, "translationY", this.HRF.getTranslationY(), this.HRF.getTranslationY() - ((float) this.ygg));
            } else {
                ofFloat = ObjectAnimator.ofFloat(this.HRF, "translationY", this.HRF.getTranslationY(), this.HRF.getTranslationY() + ((float) this.ygg));
            }
            ofFloat.setDuration(175L);
            ofFloat.setInterpolator(new android.support.v4.view.b.b());
            ofFloat.start();
            AppMethodBeat.o(182523);
        } else if (z) {
            this.HRF.setTranslationY(this.HRF.getTranslationY() - ((float) this.ygg));
            AppMethodBeat.o(182523);
        } else {
            this.HRF.setTranslationY(this.HRF.getTranslationY() + ((float) this.ygg));
            AppMethodBeat.o(182523);
        }
    }

    private void fPX() {
        boolean z = false;
        AppMethodBeat.i(174453);
        boolean z2 = true;
        if (Util.isNullOrNil(this.HRE.getText())) {
            z2 = false;
        }
        if (!Util.isNullOrNil(this.HRv.getText())) {
            z = z2;
        }
        this.HRF.setEnabled(z);
        AppMethodBeat.o(174453);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(174454);
        if (i2 == this.HRH && i3 == -1) {
            String stringExtra = intent.getStringExtra("CountryName");
            String stringExtra2 = intent.getStringExtra("ProviceName");
            String stringExtra3 = intent.getStringExtra("CityName");
            this.countryCode = intent.getStringExtra("Country");
            this.provinceCode = intent.getStringExtra("Contact_Province");
            this.cityCode = intent.getStringExtra("Contact_City");
            StringBuilder sb = new StringBuilder();
            if (!Util.isNullOrNil(stringExtra)) {
                sb.append(stringExtra);
                sb.append(" ");
            }
            if (!Util.isNullOrNil(stringExtra2)) {
                sb.append(stringExtra2);
                sb.append(" ");
            }
            if (!Util.isNullOrNil(stringExtra3)) {
                sb.append(stringExtra3);
            }
            this.HRO = sb.toString();
            this.HRE.setText(sb.toString());
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(174454);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.caz;
    }

    static /* synthetic */ void d(WcPayRealnameInputAddressUI wcPayRealnameInputAddressUI) {
        AppMethodBeat.i(214171);
        Log.i("MicroMsg.WcPayRealnameInputAddressUI", "go to select address ui");
        Intent intent = new Intent();
        intent.putExtra("GetAddress", true);
        intent.putExtra("ShowSelectedLocation", false);
        intent.putExtra("IsRealNameVerifyScene", true);
        intent.putExtra("IsNeedShowSearchBar", true);
        if (!wcPayRealnameInputAddressUI.HRQ.isEmpty()) {
            intent.putStringArrayListExtra("BlockedCountries", wcPayRealnameInputAddressUI.HRQ);
        }
        c.c(wcPayRealnameInputAddressUI.getContext(), ".ui.tools.MultiStageCitySelectUI", intent, wcPayRealnameInputAddressUI.HRH);
        AppMethodBeat.o(214171);
    }
}
