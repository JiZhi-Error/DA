package io.flutter.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.app.a;
import io.flutter.plugin.a.m;
import io.flutter.view.FlutterView;

public class FlutterFragmentActivity extends FragmentActivity implements a.AbstractC2242a, m, FlutterView.b {
    private final a SLU = new a(this, this);
    private final b SLV = this.SLU;
    private final FlutterView.b SLW = this.SLU;
    private final m wJn = this.SLU;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FlutterFragmentActivity() {
        AppMethodBeat.i(9631);
        AppMethodBeat.o(9631);
    }

    @Override // io.flutter.plugin.a.m
    public final boolean bsW(String str) {
        AppMethodBeat.i(9632);
        boolean bsW = this.wJn.bsW(str);
        AppMethodBeat.o(9632);
        return bsW;
    }

    @Override // io.flutter.plugin.a.m
    public final m.c bsX(String str) {
        AppMethodBeat.i(9633);
        m.c bsX = this.wJn.bsX(str);
        AppMethodBeat.o(9633);
        return bsX;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(9634);
        super.onCreate(bundle);
        this.SLV.hwi();
        AppMethodBeat.o(9634);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(9635);
        this.SLV.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(9635);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(9636);
        if (!this.SLV.onBackPressed()) {
            super.onBackPressed();
        }
        AppMethodBeat.o(9636);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(9637);
        super.onStart();
        this.SLV.onStart();
        AppMethodBeat.o(9637);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(9638);
        this.SLV.onStop();
        super.onStop();
        AppMethodBeat.o(9638);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(9639);
        super.onPause();
        this.SLV.onPause();
        AppMethodBeat.o(9639);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPostResume() {
        AppMethodBeat.i(9640);
        super.onPostResume();
        this.SLV.onPostResume();
        AppMethodBeat.o(9640);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(9641);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.SLV.a(i2, strArr, iArr);
        AppMethodBeat.o(9641);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(9642);
        if (!this.SLV.onActivityResult(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(9642);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(9643);
        super.onNewIntent(intent);
        this.SLV.onNewIntent(intent);
        AppMethodBeat.o(9643);
    }

    public void onUserLeaveHint() {
        AppMethodBeat.i(9644);
        this.SLV.onUserLeaveHint();
        AppMethodBeat.o(9644);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(9645);
        this.SLV.onTrimMemory(i2);
        AppMethodBeat.o(9645);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onLowMemory() {
        AppMethodBeat.i(9646);
        this.SLV.onLowMemory();
        AppMethodBeat.o(9646);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(9647);
        super.onConfigurationChanged(configuration);
        this.SLV.onConfigurationChanged(configuration);
        AppMethodBeat.o(9647);
    }
}
