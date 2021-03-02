package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference extends MMPreferenceFragment implements n {
    protected boolean OwA;
    private boolean Owu;
    private boolean Owv;
    private boolean Oww;
    private boolean Owx;
    protected boolean Owy = false;
    protected boolean Owz = false;
    private Bundle savedInstanceState;

    /* access modifiers changed from: protected */
    public abstract void gGu();

    /* access modifiers changed from: protected */
    public abstract void gGv();

    /* access modifiers changed from: protected */
    public abstract void gGw();

    /* access modifiers changed from: protected */
    public abstract void gGx();

    /* access modifiers changed from: protected */
    public abstract void gGy();

    /* access modifiers changed from: protected */
    public abstract void gGz();

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.savedInstanceState = bundle;
        this.Owv = true;
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.MMFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        super.onResume();
        gGE();
        LauncherUI instance = LauncherUI.getInstance();
        if (instance != null && instance.ODU) {
            this.Owy = true;
            if (this.Owz) {
                gGH();
                this.Owz = false;
            }
        }
    }

    @Override // com.tencent.mm.ui.n
    public final void gGD() {
        gGB();
        this.Oww = true;
    }

    @Override // com.tencent.mm.ui.n
    public final void gGH() {
        if (this.Owy) {
            gGG();
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Oww) {
                gGC();
                this.Oww = false;
            }
            gLO();
            gGv();
            Log.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.Owx = true;
            this.Owy = false;
        }
    }

    @Override // com.tencent.mm.ui.n
    public final void gGF() {
        this.Owz = true;
    }

    private void gGG() {
        if (this.Owv) {
            gGu();
            this.Owv = false;
        } else if (this.Owu) {
            gGz();
            gGu();
            Log.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
            this.Owu = false;
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onPause() {
        super.onPause();
        this.OwA = true;
        if (!this.OwA) {
            return;
        }
        if (!this.Owx) {
            this.OwA = false;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        gGx();
        Log.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
        this.Owx = false;
        this.OwA = false;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onStop() {
        super.onStop();
        gGy();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onStart() {
        super.onStart();
        LauncherUI instance = LauncherUI.getInstance();
        if (instance != null && instance.ODU) {
            gGw();
        }
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        gGz();
        super.onDestroy();
    }
}
