package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

public class TopStoryHomeUI extends MMActivity {
    private b Gkl = new b(this, true);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStoryHomeUI() {
        AppMethodBeat.i(125906);
        AppMethodBeat.o(125906);
    }

    static /* synthetic */ void a(TopStoryHomeUI topStoryHomeUI) {
        AppMethodBeat.i(125918);
        super.finish();
        AppMethodBeat.o(125918);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125907);
        fixStatusbar(true);
        super.onCreate(bundle);
        Log.i("MicroMsg.TopStory.TopStoryHomeUI", "use TopStoryHomeUI");
        this.Gkl.onCreate(bundle);
        AppMethodBeat.o(125907);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(125908);
        if (this.Gkl.abS(i2)) {
            AppMethodBeat.o(125908);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(125908);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(125909);
        super.onResume();
        this.Gkl.onResume();
        AppMethodBeat.o(125909);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(125910);
        this.Gkl.onPause();
        super.onPause();
        AppMethodBeat.o(125910);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(125911);
        this.Gkl.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(125911);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(125912);
        this.Gkl.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(125912);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c43;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(125913);
        super.onSaveInstanceState(bundle);
        this.Gkl.onSaveInstanceState(bundle);
        AppMethodBeat.o(125913);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        boolean z;
        AppMethodBeat.i(125914);
        b bVar = this.Gkl;
        if (bVar.Gky) {
            bVar.fyo();
            z = false;
        } else {
            z = true;
        }
        if (z) {
            super.onBackPressed();
        }
        AppMethodBeat.o(125914);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(125915);
        int i2 = 100;
        if (!getController().hideVKB()) {
            i2 = 0;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStoryHomeUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(125905);
                Log.i("MicroMsg.TopStory.TopStoryHomeUI", " finish");
                TopStoryHomeUI.a(TopStoryHomeUI.this);
                AppMethodBeat.o(125905);
            }
        }, (long) i2);
        AppMethodBeat.o(125915);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(125916);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(125916);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(125917);
        this.Gkl.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(125917);
    }
}
