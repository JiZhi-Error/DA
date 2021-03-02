package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;
import com.tencent.smtt.sdk.TbsListener;

public class SettingsModifyPatSuffixUI extends MMWizardActivity implements h.a, b.a {
    private int ARG = 16;
    private MTimerHandler ARK;
    private MMClearEditText DcC;
    private int Ddb = 1;
    private ScrollView gxx;
    private InputPanelLinearLayout gxy;
    private TextView kuu;
    private q tipDialog;
    private Button vMn;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(256578);
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("jumptoPat", false)) {
            this.Ddb = 2;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20379, new StringBuilder().append(System.currentTimeMillis()).toString(), 1, 0, Integer.valueOf(this.Ddb));
        this.ARG = com.tencent.mm.n.h.aqJ().getInt("PatSuffixMaxByte", 16);
        initView();
        this.ARK = new MTimerHandler(getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(256573);
                SettingsModifyPatSuffixUI.this.kuu.setText(SettingsModifyPatSuffixUI.this.getString(R.string.glr));
                SettingsModifyPatSuffixUI.this.kuu.setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(R.color.l4));
                AppMethodBeat.o(256573);
                return false;
            }
        }, false);
        AppMethodBeat.o(256578);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br4;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(256579);
        ((l) g.af(l.class)).eis().b(TbsListener.ErrorCode.UNLZMA_FAIURE, this);
        if (this.ARK != null) {
            this.ARK.stopTimer();
        }
        super.onDestroy();
        AppMethodBeat.o(256579);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(256580);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.gxy = (InputPanelLinearLayout) findViewById(R.id.dym);
        this.gxy.setExternalListener(this);
        this.vMn = (Button) findViewById(R.id.fz0);
        this.DcC = (MMClearEditText) findViewById(R.id.g91);
        this.kuu = (TextView) findViewById(R.id.g92);
        this.gxx = (ScrollView) findViewById(R.id.hcs);
        this.vMn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(256574);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsModifyPatSuffixUI.this.hideVKB();
                SettingsModifyPatSuffixUI.a(SettingsModifyPatSuffixUI.this, SettingsModifyPatSuffixUI.this.DcC.getText());
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyPatSuffixUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(256574);
            }
        });
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, (Object) null);
        int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_PAT_SUFFIX_VERSION_INT_SYNC, 0);
        Log.i("MicroMsg.SettingsModifyPatSuffixUI", "curSuffix %s, suffixVersion %d", str, Integer.valueOf(i2));
        if (!Util.isNullOrNil(str)) {
            if (i2 == 0 && LocaleUtil.isChineseAppLang()) {
                str = "的".concat(String.valueOf(str));
            }
            this.DcC.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, str));
            this.DcC.setSelection(str.length());
        }
        this.DcC.requestFocus();
        this.DcC.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(256575);
                int a2 = f.a(editable.toString(), f.a.MODE_CHINESE_AS_2);
                if (a2 > SettingsModifyPatSuffixUI.this.ARG) {
                    SettingsModifyPatSuffixUI.this.kuu.setText(SettingsModifyPatSuffixUI.this.getString(R.string.glq, new Object[]{Integer.valueOf(SettingsModifyPatSuffixUI.this.ARG / 2)}));
                    SettingsModifyPatSuffixUI.this.kuu.setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(R.color.a5e));
                    SettingsModifyPatSuffixUI.this.kuu.performHapticFeedback(3, 2);
                    if (SettingsModifyPatSuffixUI.this.ARK.stopped()) {
                        SettingsModifyPatSuffixUI.this.ARK.startTimer(5000);
                    }
                    SettingsModifyPatSuffixUI.this.DcC.setText(f.hm(editable.toString(), SettingsModifyPatSuffixUI.this.ARG));
                    SettingsModifyPatSuffixUI.this.DcC.setSelection(SettingsModifyPatSuffixUI.this.DcC.getText().length());
                } else if (a2 < SettingsModifyPatSuffixUI.this.ARG) {
                    SettingsModifyPatSuffixUI.this.ARK.stopTimer();
                    SettingsModifyPatSuffixUI.this.kuu.setText(SettingsModifyPatSuffixUI.this.getString(R.string.glr));
                    SettingsModifyPatSuffixUI.this.kuu.setTextColor(SettingsModifyPatSuffixUI.this.getResources().getColor(R.color.l4));
                }
                SettingsModifyPatSuffixUI.this.vMn.setEnabled(true);
                AppMethodBeat.o(256575);
            }
        });
        ((l) g.af(l.class)).eis().a(TbsListener.ErrorCode.UNLZMA_FAIURE, this);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256576);
                SettingsModifyPatSuffixUI.this.onBackPressed();
                AppMethodBeat.o(256576);
                return true;
            }
        });
        AppMethodBeat.o(256580);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(256581);
        super.onBackPressed();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20379, new StringBuilder().append(System.currentTimeMillis()).toString(), 3, 0, Integer.valueOf(this.Ddb));
        AppMethodBeat.o(256581);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(256582);
        Log.i("MicroMsg.SettingsModifyPatSuffixUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.vMn.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            this.vMn.setLayoutParams(layoutParams);
            this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), i2);
            final int height = this.gxx.getHeight();
            this.gxy.requestLayout();
            this.gxy.post(new Runnable() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(256577);
                    Log.i("MicroMsg.SettingsModifyPatSuffixUI", "inputContainer.height: %d, screenHeight: %d", Integer.valueOf(SettingsModifyPatSuffixUI.this.gxy.getHeight()), Integer.valueOf(height));
                    if (SettingsModifyPatSuffixUI.this.gxy.getHeight() > height) {
                        SettingsModifyPatSuffixUI.this.gxx.scrollBy(0, SettingsModifyPatSuffixUI.this.gxy.getHeight() - height);
                    }
                    AppMethodBeat.o(256577);
                }
            });
            AppMethodBeat.o(256582);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.vMn.getLayoutParams();
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        layoutParams2.topMargin = 0;
        this.vMn.setLayoutParams(layoutParams2);
        this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
        this.gxx.scrollBy(0, 0);
        AppMethodBeat.o(256582);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h.a
    public final void a(int i2, cxl cxl, k.b bVar) {
        AppMethodBeat.i(256583);
        Log.i("MicroMsg.SettingsModifyPatSuffixUI", "ret:%d, content:%s, title:%s", Integer.valueOf(i2), cxl.iAc, cxl.Title);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i2 == 0) {
            try {
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.wo));
                cqa cqa = (cqa) bVar.zqv;
                if (!Util.nullAsNil((String) g.aAh().azQ().get(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, (Object) null)).equals(cqa.MvT)) {
                    g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_VERSION_INT_SYNC, (Object) 2);
                }
                g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, cqa.MvT);
                ala(1);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20379, new StringBuilder().append(System.currentTimeMillis()).toString(), 2, 0, Integer.valueOf(this.Ddb));
                g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_TIMESTAMP_LONG, Long.valueOf(cl.aWA()));
                g.aAh().azQ().set(ar.a.USERINFO_PAT_SUFFIX_MODIFY_TIP_COUNT_INT, (Object) 0);
                AppMethodBeat.o(256583);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SettingsModifyPatSuffixUI", e2, "", new Object[0]);
                AppMethodBeat.o(256583);
            }
        } else {
            if (!Util.isNullOrNil(cxl.iAc)) {
                com.tencent.mm.ui.base.h.c(this, cxl.iAc, getString(R.string.wn), true);
            } else {
                com.tencent.mm.ui.base.h.n(getContext(), R.string.u5, R.string.wn);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20379, new StringBuilder().append(System.currentTimeMillis()).toString(), 2, Integer.valueOf(i2), Integer.valueOf(this.Ddb));
            AppMethodBeat.o(256583);
        }
    }

    static /* synthetic */ void a(SettingsModifyPatSuffixUI settingsModifyPatSuffixUI, CharSequence charSequence) {
        AppMethodBeat.i(256584);
        cqa cqa = new cqa();
        cqa.MvT = Util.escapeStringForUCC(charSequence.toString()).trim();
        ((l) g.af(l.class)).eis().b(new k.a(TbsListener.ErrorCode.UNLZMA_FAIURE, cqa));
        settingsModifyPatSuffixUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) settingsModifyPatSuffixUI.getContext(), settingsModifyPatSuffixUI.getString(R.string.f30), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(256584);
    }
}
