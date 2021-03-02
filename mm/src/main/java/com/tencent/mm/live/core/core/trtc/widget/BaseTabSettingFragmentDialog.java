package com.tencent.mm.live.core.core.trtc.widget;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabSettingFragmentDialog extends BaseSettingFragmentDialog {
    private TabLayout hBW;
    private ViewPager hBX;
    private List<Fragment> hBY;
    private List<String> hBZ;
    private q hCa;

    /* access modifiers changed from: protected */
    public abstract List<String> aDW();

    /* access modifiers changed from: protected */
    public abstract List<Fragment> getFragments();

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.hBY = getFragments();
        this.hBZ = aDW();
        if (this.hBY == null) {
            this.hBY = new ArrayList();
        }
        this.hBW.a(this.hBX, false, false);
        this.hCa = new i(getChildFragmentManager()) {
            /* class com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog.AnonymousClass1 */

            @Override // android.support.v4.app.i
            public final Fragment getItem(int i2) {
                AppMethodBeat.i(196303);
                if (BaseTabSettingFragmentDialog.this.hBY == null) {
                    AppMethodBeat.o(196303);
                    return null;
                }
                Fragment fragment = (Fragment) BaseTabSettingFragmentDialog.this.hBY.get(i2);
                AppMethodBeat.o(196303);
                return fragment;
            }

            @Override // android.support.v4.view.q
            public final int getCount() {
                AppMethodBeat.i(196304);
                if (BaseTabSettingFragmentDialog.this.hBY == null) {
                    AppMethodBeat.o(196304);
                    return 0;
                }
                int size = BaseTabSettingFragmentDialog.this.hBY.size();
                AppMethodBeat.o(196304);
                return size;
            }
        };
        this.hBX.setAdapter(this.hCa);
        for (int i2 = 0; i2 < this.hBZ.size(); i2++) {
            TabLayout.f ab = this.hBW.ab(i2);
            if (ab != null) {
                ab.d(this.hBZ.get(i2));
            }
        }
    }
}
