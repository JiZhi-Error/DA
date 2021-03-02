package io.flutter.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import io.flutter.app.a;
import io.flutter.plugin.a.m;
import io.flutter.view.FlutterView;

public class FlutterActivity extends HellActivity implements a.AbstractC2242a, m, FlutterView.b {
    private final a SLU = new a(this, this);
    private final b SLV = this.SLU;
    private final FlutterView.b SLW = this.SLU;
    private final m wJn = this.SLU;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FlutterActivity() {
        AppMethodBeat.i(9605);
        AppMethodBeat.o(9605);
    }

    @Override // io.flutter.plugin.a.m
    public final boolean bsW(String str) {
        AppMethodBeat.i(9606);
        boolean bsW = this.wJn.bsW(str);
        AppMethodBeat.o(9606);
        return bsW;
    }

    @Override // io.flutter.plugin.a.m
    public final m.c bsX(String str) {
        AppMethodBeat.i(9607);
        m.c bsX = this.wJn.bsX(str);
        AppMethodBeat.o(9607);
        return bsX;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(9608);
        super.onCreate(bundle);
        this.SLV.hwi();
        AppMethodBeat.o(9608);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(9609);
        super.onStart();
        this.SLV.onStart();
        AppMethodBeat.o(9609);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(9610);
        super.onResume();
        this.SLV.onResume();
        AppMethodBeat.o(9610);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(9611);
        this.SLV.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(9611);
    }

    public void onBackPressed() {
        AppMethodBeat.i(9612);
        if (!this.SLV.onBackPressed()) {
            super.onBackPressed();
        }
        AppMethodBeat.o(9612);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(9613);
        this.SLV.onStop();
        super.onStop();
        AppMethodBeat.o(9613);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(9614);
        super.onPause();
        this.SLV.onPause();
        AppMethodBeat.o(9614);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPostResume() {
        AppMethodBeat.i(9615);
        super.onPostResume();
        this.SLV.onPostResume();
        AppMethodBeat.o(9615);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(9616);
        this.SLV.a(i2, strArr, iArr);
        AppMethodBeat.o(9616);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(9617);
        if (!this.SLV.onActivityResult(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(9617);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(9618);
        this.SLV.onNewIntent(intent);
        AppMethodBeat.o(9618);
    }

    public void onUserLeaveHint() {
        AppMethodBeat.i(9619);
        this.SLV.onUserLeaveHint();
        AppMethodBeat.o(9619);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(9620);
        this.SLV.onTrimMemory(i2);
        AppMethodBeat.o(9620);
    }

    public void onLowMemory() {
        AppMethodBeat.i(9621);
        this.SLV.onLowMemory();
        AppMethodBeat.o(9621);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(9622);
        super.onConfigurationChanged(configuration);
        this.SLV.onConfigurationChanged(configuration);
        AppMethodBeat.o(9622);
    }
}
