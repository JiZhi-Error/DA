package com.tencent.mm.plugin.scanner.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.scanlib.ui.ScanCodeView;

@a(35)
public class ScanSampleActivity extends MMActivity {
    private ScanCodeView CMu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(91052);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getController().p(this, getResources().getColor(R.color.ac_));
        getController().setNavigationbarColor(getResources().getColor(R.color.ac_));
        View decorView = getWindow().getDecorView();
        int i2 = 1796;
        if (Build.VERSION.SDK_INT >= 19) {
            i2 = 5892;
        }
        decorView.setSystemUiVisibility(i2);
        initView();
        AppMethodBeat.o(91052);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bo7;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(91053);
        this.CMu = (ScanCodeView) findViewById(R.id.hb3);
        this.CMu.setScanCallBack(new ScanCodeView.a() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanSampleActivity.AnonymousClass1 */

            @Override // com.tencent.scanlib.ui.ScanCodeView.a
            public final void ay(Bundle bundle) {
                AppMethodBeat.i(91051);
                String string = bundle.getString("result_content", "");
                if (!com.tencent.scanlib.a.isNullOrNil(string)) {
                    h.c(ScanSampleActivity.this, string, "", true);
                }
                AppMethodBeat.o(91051);
            }
        });
        this.CMu.onCreate();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(91053);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(91054);
        super.onResume();
        this.CMu.onResume();
        AppMethodBeat.o(91054);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(91055);
        super.onPause();
        this.CMu.onPause();
        AppMethodBeat.o(91055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(91056);
        super.onStop();
        this.CMu.onStop();
        AppMethodBeat.o(91056);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(91057);
        super.onDestroy();
        this.CMu.onDestroy();
        AppMethodBeat.o(91057);
    }
}
