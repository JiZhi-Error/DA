package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI extends MMPreference {
    private boolean CXV;
    private boolean CXW;
    private boolean CXX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74621);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74621);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cv;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        AppMethodBeat.i(74622);
        if (preference instanceof CheckPreference) {
            CheckPreference checkPreference = (CheckPreference) preference;
            if (preference.mKey.equals("settings_half_year_not_chat")) {
                if (!this.CXV) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                checkPreference.oD = z5;
                if (!this.CXV) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.CXV = z6;
            } else if (preference.mKey.equals("settings_has_not_same_chatroom")) {
                if (!this.CXX) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                checkPreference.oD = z3;
                if (!this.CXX) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.CXX = z4;
            } else if (preference.mKey.equals("settings_half_year_not_response")) {
                if (!this.CXW) {
                    z = true;
                } else {
                    z = false;
                }
                checkPreference.oD = z;
                if (!this.CXW) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.CXW = z2;
            }
            TextButtonPreference textButtonPreference = (TextButtonPreference) fVar.bmg("settings_next_step");
            if (this.CXV || this.CXX || this.CXW) {
                z7 = true;
            }
            textButtonPreference.setEnabled(z7);
        } else if (preference.mKey.equals("settings_next_step")) {
            Intent intent = new Intent(this, UnfamiliarContactDetailUI.class);
            intent.putExtra("half_year_not_chat", this.CXV);
            intent.putExtra("half_year_not_response", this.CXW);
            intent.putExtra("has_not_same_chatroom", this.CXX);
            startActivityForResult(intent, 291);
        }
        fVar.notifyDataSetChanged();
        AppMethodBeat.o(74622);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74623);
        super.initView();
        setMMTitle(R.string.gw2);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74620);
                UnfamiliarContactUI.this.finish();
                AppMethodBeat.o(74620);
                return true;
            }
        });
        ((CheckPreference) getPreferenceScreen().bmg("settings_half_year_not_chat")).OXu = 0;
        ((CheckPreference) getPreferenceScreen().bmg("settings_has_not_same_chatroom")).OXu = 0;
        ((CheckPreference) getPreferenceScreen().bmg("settings_half_year_not_response")).OXu = 0;
        ((TextButtonPreference) getPreferenceScreen().bmg("settings_next_step")).setEnabled(false);
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(74623);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74624);
        if (i2 == 4) {
            onBackPressed();
            AppMethodBeat.o(74624);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(74624);
        return onKeyDown;
    }
}
