package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u001c\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0013H\u0014J\b\u0010'\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getResourceId", "", "goBack", "", "handleAtShowTab", "initFeedMvReproductionBtn", "initFeedReproductionBtn", "initMessageMuteBtn", "initNoSeeAtTab", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFeedMvReproductionClick", "onFeedReproductionClick", "onMessageMuteClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "plugin-finder_release"})
public final class FinderSettingPrivacyUI extends MMPreference {
    private final String TAG = "Finder.FinderSettingPrivacyUI";
    private HashMap _$_findViewCache;
    private final ai<azg> tUo = new a(this);
    Dialog tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252686);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252686);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252685);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252685);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderSettingPrivacyUI() {
        AppMethodBeat.i(252683);
        AppMethodBeat.o(252683);
    }

    public static final /* synthetic */ void a(FinderSettingPrivacyUI finderSettingPrivacyUI) {
        AppMethodBeat.i(252684);
        finderSettingPrivacyUI.goBack();
        AppMethodBeat.o(252684);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167619);
        super.onCreate(bundle);
        setMMTitle(R.string.d5w);
        setBackBtn(new e(this));
        AppMethodBeat.o(167619);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSettingPrivacyUI vOx;

        e(FinderSettingPrivacyUI finderSettingPrivacyUI) {
            this.vOx = finderSettingPrivacyUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167618);
            FinderSettingPrivacyUI.a(this.vOx);
            AppMethodBeat.o(167618);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(252681);
        goBack();
        AppMethodBeat.o(252681);
    }

    private final void goBack() {
        AppMethodBeat.i(252682);
        Preference bmg = getPreferenceScreen().bmg("checkbox_preference_one");
        if (bmg == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(252682);
            throw tVar;
        }
        boolean isChecked = ((CheckBoxPreference) bmg).isChecked();
        y yVar = y.vXH;
        if (isChecked != y.dnv()) {
            Dialog dialog = this.tipDialog;
            if (dialog != null) {
                dialog.show();
            } else {
                FinderSettingPrivacyUI finderSettingPrivacyUI = this;
                finderSettingPrivacyUI.getContext().getString(R.string.zb);
                finderSettingPrivacyUI.tipDialog = h.a((Context) finderSettingPrivacyUI.getContext(), finderSettingPrivacyUI.getContext().getString(R.string.a06), false, (DialogInterface.OnCancelListener) b.vOy);
            }
            ((x) g.af(x.class)).b(isChecked ? 1 : 2, this.tUo);
            AppMethodBeat.o(252682);
            return;
        }
        finish();
        AppMethodBeat.o(252682);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class b implements DialogInterface.OnCancelListener {
        public static final b vOy = new b();

        static {
            AppMethodBeat.i(252678);
            AppMethodBeat.o(252678);
        }

        b() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class c implements DialogInterface.OnCancelListener {
        public static final c vOz = new c();

        static {
            AppMethodBeat.i(252679);
            AppMethodBeat.o(252679);
        }

        c() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$handleAtShowTab$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class d implements ai<azg> {
        final /* synthetic */ FinderSettingPrivacyUI vOx;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderSettingPrivacyUI finderSettingPrivacyUI) {
            this.vOx = finderSettingPrivacyUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(azg azg, apg apg) {
            int i2;
            AppMethodBeat.i(252680);
            azg azg2 = azg;
            p.h(azg2, "req");
            p.h(apg, "ret");
            Dialog dialog = this.vOx.tipDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (apg.retCode == 0) {
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
                if (azg2.LJb == 1) {
                    i2 = i3 | 2048;
                } else {
                    i2 = i3 & -2049;
                }
                com.tencent.mm.kernel.e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i2));
                AppMethodBeat.o(252680);
                return;
            }
            u.makeText(this.vOx, this.vOx.getString(R.string.dax), 0).show();
            AppMethodBeat.o(252680);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a implements ai<azg> {
        final /* synthetic */ FinderSettingPrivacyUI vOx;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderSettingPrivacyUI finderSettingPrivacyUI) {
            this.vOx = finderSettingPrivacyUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(azg azg, apg apg) {
            int i2;
            AppMethodBeat.i(252677);
            azg azg2 = azg;
            p.h(azg2, "req");
            p.h(apg, "ret");
            Dialog dialog = this.vOx.tipDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (apg.retCode == 0) {
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
                if (azg2.LJa == 1) {
                    i2 = i3 | 1024;
                } else {
                    i2 = i3 & -1025;
                }
                com.tencent.mm.kernel.e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i2));
                this.vOx.finish();
                AppMethodBeat.o(252677);
                return;
            }
            u.makeText(this.vOx, this.vOx.getString(R.string.dax), 0).show();
            this.vOx.finish();
            AppMethodBeat.o(252677);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0238  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResume() {
        /*
        // Method dump skipped, instructions count: 570
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI.onResume():void");
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getResourceId() {
        return R.xml.b8;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        int i3;
        int i4;
        int i5 = 2;
        AppMethodBeat.i(167621);
        if (preference == null) {
            p.hyc();
        }
        String key = preference.getKey();
        Log.i(this.TAG, "click ".concat(String.valueOf(key)));
        if (key != null) {
            switch (key.hashCode()) {
                case -1462242975:
                    if (key.equals("feed_mv_reproduction")) {
                        Preference bmg = getPreferenceScreen().bmg("feed_mv_reproduction");
                        if (bmg != null) {
                            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) bmg;
                            if (checkBoxPreference != null) {
                                boolean isChecked = checkBoxPreference.isChecked();
                                com.tencent.mm.kernel.e aAh = g.aAh();
                                p.g(aAh, "MMKernel.storage()");
                                int i6 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
                                if (isChecked) {
                                    int i7 = -524289 & i6;
                                    AppCompatActivity context = getContext();
                                    p.g(context, "context");
                                    checkBoxPreference.setSummary(context.getResources().getString(R.string.cnt));
                                    i4 = i7;
                                } else {
                                    int i8 = 524288 | i6;
                                    AppCompatActivity context2 = getContext();
                                    p.g(context2, "context");
                                    checkBoxPreference.setSummary(context2.getResources().getString(R.string.cnv));
                                    i4 = i8;
                                }
                                com.tencent.mm.kernel.e aAh2 = g.aAh();
                                p.g(aAh2, "MMKernel.storage()");
                                aAh2.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i4));
                                ((x) g.af(x.class)).mR(isChecked);
                                break;
                            }
                        } else {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                            AppMethodBeat.o(167621);
                            throw tVar;
                        }
                    }
                    break;
                case -421449683:
                    if (key.equals("feed_reproduction")) {
                        Preference bmg2 = getPreferenceScreen().bmg("feed_reproduction");
                        if (bmg2 != null) {
                            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) bmg2;
                            if (checkBoxPreference2 != null) {
                                boolean isChecked2 = checkBoxPreference2.isChecked();
                                k kVar = k.vfA;
                                k.ge(3, isChecked2 ? 1 : 2);
                                com.tencent.mm.kernel.e aAh3 = g.aAh();
                                p.g(aAh3, "MMKernel.storage()");
                                int i9 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
                                if (isChecked2) {
                                    int i10 = i9 & -257;
                                    AppCompatActivity context3 = getContext();
                                    p.g(context3, "context");
                                    checkBoxPreference2.setSummary(context3.getResources().getString(R.string.cdd));
                                    i2 = i10;
                                } else {
                                    int i11 = i9 | 256;
                                    AppCompatActivity context4 = getContext();
                                    p.g(context4, "context");
                                    checkBoxPreference2.setSummary(context4.getResources().getString(R.string.cnu));
                                    i2 = i11;
                                }
                                com.tencent.mm.kernel.e aAh4 = g.aAh();
                                p.g(aAh4, "MMKernel.storage()");
                                aAh4.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i2));
                                ((com.tencent.mm.plugin.i.a.u) g.af(com.tencent.mm.plugin.i.a.u.class)).mP(isChecked2);
                                break;
                            }
                        } else {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                            AppMethodBeat.o(167621);
                            throw tVar2;
                        }
                    }
                    break;
                case 541151233:
                    if (key.equals("settings_blacklist")) {
                        Intent intent = new Intent();
                        intent.setClass(this, FinderBlackListUI.class);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    }
                    break;
                case 622179821:
                    if (key.equals("settings_message_mute")) {
                        Preference bmg3 = getPreferenceScreen().bmg("settings_message_mute");
                        if (bmg3 != null) {
                            CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) bmg3;
                            if (checkBoxPreference3 != null) {
                                boolean isChecked3 = checkBoxPreference3.isChecked();
                                com.tencent.mm.kernel.e aAh5 = g.aAh();
                                p.g(aAh5, "MMKernel.storage()");
                                int i12 = aAh5.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
                                if (isChecked3) {
                                    i3 = i12 | 64;
                                } else {
                                    i3 = i12 & -65;
                                }
                                com.tencent.mm.kernel.e aAh6 = g.aAh();
                                p.g(aAh6, "MMKernel.storage()");
                                aAh6.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i3));
                                ((com.tencent.mm.plugin.i.a.p) g.af(com.tencent.mm.plugin.i.a.p.class)).mQ(isChecked3);
                                break;
                            }
                        } else {
                            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                            AppMethodBeat.o(167621);
                            throw tVar3;
                        }
                    }
                    break;
                case 1697865235:
                    if (key.equals("setting_no_see_at_tab_tips")) {
                        Preference bmg4 = getPreferenceScreen().bmg("setting_no_see_at_tab_tips");
                        if (bmg4 != null) {
                            boolean isChecked4 = ((CheckBoxPreference) bmg4).isChecked();
                            Dialog dialog = this.tipDialog;
                            if (dialog != null) {
                                dialog.show();
                            } else {
                                FinderSettingPrivacyUI finderSettingPrivacyUI = this;
                                finderSettingPrivacyUI.getContext().getString(R.string.zb);
                                finderSettingPrivacyUI.tipDialog = h.a((Context) finderSettingPrivacyUI.getContext(), finderSettingPrivacyUI.getContext().getString(R.string.a06), false, (DialogInterface.OnCancelListener) c.vOz);
                            }
                            x xVar = (x) g.af(x.class);
                            if (isChecked4) {
                                i5 = 1;
                            }
                            xVar.c(i5, new d(this));
                            break;
                        } else {
                            t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                            AppMethodBeat.o(167621);
                            throw tVar4;
                        }
                    }
                    break;
            }
        }
        AppMethodBeat.o(167621);
        return true;
    }
}
