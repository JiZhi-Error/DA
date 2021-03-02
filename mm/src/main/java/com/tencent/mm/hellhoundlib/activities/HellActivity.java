package com.tencent.mm.hellhoundlib.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.b;

public class HellActivity extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55515);
        super.onCreate(bundle);
        a.axP().g(this, 0);
        AppMethodBeat.o(55515);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(55516);
        super.onNewIntent(intent);
        a axP = a.axP();
        if (b.be(this) && axP.hlG != null) {
            axP.hlG.c(this, intent);
        }
        AppMethodBeat.o(55516);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        AppMethodBeat.i(55517);
        super.onResume();
        a.axP().g(this, 2);
        AppMethodBeat.o(55517);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        AppMethodBeat.i(55518);
        super.onPause();
        a.axP().g(this, 3);
        AppMethodBeat.o(55518);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        AppMethodBeat.i(55519);
        super.onStop();
        a.axP().g(this, 4);
        AppMethodBeat.o(55519);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AppMethodBeat.i(55520);
        a.axP().g(this, 5);
        super.onDestroy();
        AppMethodBeat.o(55520);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        AppMethodBeat.i(55521);
        super.onPostResume();
        a.axP().g(this, 6);
        AppMethodBeat.o(55521);
    }

    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(55522);
        a.axP().a(this, intent);
        super.startActivityForResult(intent, i2, bundle);
        AppMethodBeat.o(55522);
    }

    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(55523);
        a.axP().a(this, intent);
        boolean startActivityIfNeeded = super.startActivityIfNeeded(intent, i2, bundle);
        AppMethodBeat.o(55523);
        return startActivityIfNeeded;
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.i(55524);
        a axP = a.axP();
        if (b.be(this) && axP.hlG != null) {
            axP.hlG.a(this, intentArr);
        }
        super.startActivities(intentArr, bundle);
        AppMethodBeat.o(55524);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(55525);
        a.axP().a(this, intent);
        super.startActivityFromFragment(fragment, intent, i2, bundle);
        AppMethodBeat.o(55525);
    }

    public void finish() {
        AppMethodBeat.i(55526);
        a.axP().bd(this);
        super.finish();
        AppMethodBeat.o(55526);
    }

    public void finishActivity(int i2) {
        AppMethodBeat.i(55527);
        a.axP().bd(this);
        super.finishActivity(i2);
        AppMethodBeat.o(55527);
    }

    public void finishAffinity() {
        AppMethodBeat.i(55528);
        a.axP().bd(this);
        super.finishAffinity();
        AppMethodBeat.o(55528);
    }

    public void finishActivityFromChild(Activity activity, int i2) {
        AppMethodBeat.i(55529);
        a.axP().bd(activity);
        super.finishActivityFromChild(activity, i2);
        AppMethodBeat.o(55529);
    }

    public void finishAndRemoveTask() {
        AppMethodBeat.i(55530);
        a.axP().bd(this);
        super.finishAndRemoveTask();
        AppMethodBeat.o(55530);
    }

    public boolean moveTaskToBack(boolean z) {
        AppMethodBeat.i(55531);
        a axP = a.axP();
        if (axP.hlG != null) {
            axP.hlG.c(this, z);
        }
        boolean moveTaskToBack = super.moveTaskToBack(z);
        AppMethodBeat.o(55531);
        return moveTaskToBack;
    }
}
