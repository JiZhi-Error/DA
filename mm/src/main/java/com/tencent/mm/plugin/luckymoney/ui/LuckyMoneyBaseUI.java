package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.d.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LuckyMoneyBaseUI extends MMActivity implements i, f {
    private LinkedList<k> callbacks = new LinkedList<>();
    public z zbX = null;
    protected boolean zbY = true;

    public abstract boolean onSceneEnd(int i2, int i3, String str, q qVar);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        fixStatusbar(true);
        super.onCreate(bundle);
        this.zbX = new z(this, this);
        this.zbX.addSceneEndListener(1554);
        this.zbX.addSceneEndListener(1575);
        this.zbX.addSceneEndListener(1668);
        this.zbX.addSceneEndListener(1581);
        this.zbX.addSceneEndListener(1685);
        this.zbX.addSceneEndListener(1585);
        this.zbX.addSceneEndListener(1514);
        this.zbX.addSceneEndListener(1682);
        this.zbX.addSceneEndListener(1612);
        this.zbX.addSceneEndListener(1643);
        this.zbX.addSceneEndListener(1558);
        this.zbX.addSceneEndListener(2715);
        this.zbX.addSceneEndListener(4605);
        this.zbX.addSceneEndListener(4915);
        this.zbX.addSceneEndListener(4536);
        this.zbX.addSceneEndListener(5148);
        this.zbX.addSceneEndListener(4395);
        this.zbX.addSceneEndListener(4373);
        this.zbX.addSceneEndListener(4595);
        this.zbX.addSceneEndListener(4339);
        this.zbX.addSceneEndListener(4717);
        this.zbX.addSceneEndListener(4878);
        setActionbarColor(getResources().getColor(R.color.yd));
        if (this.zbY) {
            setActionbarElementColor(getResources().getColor(R.color.yl));
        }
        getLayoutId();
        Iterator it = ((List) this.callbacks.clone()).iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void efZ() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            setActionbarColor(getResources().getColor(R.color.yd));
        }
    }

    /* access modifiers changed from: protected */
    public final void ega() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        this.zbX.removeSceneEndListener(1554);
        this.zbX.removeSceneEndListener(1575);
        this.zbX.removeSceneEndListener(1668);
        this.zbX.removeSceneEndListener(1581);
        this.zbX.removeSceneEndListener(1685);
        this.zbX.removeSceneEndListener(1585);
        this.zbX.removeSceneEndListener(1514);
        this.zbX.removeSceneEndListener(1682);
        this.zbX.removeSceneEndListener(1612);
        this.zbX.removeSceneEndListener(1643);
        this.zbX.removeSceneEndListener(1558);
        this.zbX.removeSceneEndListener(2715);
        this.zbX.removeSceneEndListener(4605);
        this.zbX.removeSceneEndListener(4915);
        this.zbX.removeSceneEndListener(4536);
        this.zbX.removeSceneEndListener(5148);
        this.zbX.removeSceneEndListener(4395);
        this.zbX.removeSceneEndListener(4373);
        this.zbX.removeSceneEndListener(4595);
        this.zbX.removeSceneEndListener(4339);
        this.zbX.removeSceneEndListener(4717);
        for (k kVar : (List) this.callbacks.clone()) {
            kVar.onDestroy();
        }
        this.callbacks.clear();
        super.onDestroy();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.zbX != null && this.zbX.isProcessing()) {
                this.zbX.forceCancel();
            }
            if (getContentView().getVisibility() == 8 || getContentView().getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.tencent.mm.wallet_core.d.f
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        if (onSceneEnd(i2, i3, str, qVar)) {
            return;
        }
        if (i2 != 0 || i3 != 0) {
            h.cD(this, str);
            finish();
        }
    }

    public final void addSceneEndListener(int i2) {
        this.zbX.addSceneEndListener(i2);
    }

    public final void removeSceneEndListener(int i2) {
        this.zbX.removeSceneEndListener(i2);
    }

    public final void doSceneProgress(q qVar, boolean z) {
        this.zbX.doSceneProgress(qVar, z);
    }

    public final void doSceneProgress(q qVar) {
        this.zbX.doSceneProgress(qVar, true);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (k kVar : (List) this.callbacks.clone()) {
            kVar.hhl();
        }
    }

    @Override // com.tencent.mm.wallet_core.c.i
    public void register(k kVar) {
        if (!this.callbacks.contains(kVar)) {
            this.callbacks.add(kVar);
        }
    }
}
