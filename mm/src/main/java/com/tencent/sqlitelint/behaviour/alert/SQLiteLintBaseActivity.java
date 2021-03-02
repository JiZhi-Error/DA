package com.tencent.sqlitelint.behaviour.alert;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public abstract class SQLiteLintBaseActivity extends HellActivity {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLintBaseActivity.class.desiredAssertionStatus());
    private Toolbar mToolBar;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onCreateView();
    }

    /* access modifiers changed from: protected */
    public void onCreateView() {
        setContentView(R.layout.bz);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.be9);
        LayoutInflater from = LayoutInflater.from(this);
        int layoutId = getLayoutId();
        if ($assertionsDisabled || layoutId != 0) {
            from.inflate(layoutId, frameLayout);
            this.mToolBar = (Toolbar) findViewById(R.id.is8);
            this.mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                /* class com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity.AnonymousClass1 */

                public void onClick(View view) {
                    AppMethodBeat.i(52910);
                    SQLiteLintBaseActivity.this.onBackBtnClick();
                    AppMethodBeat.o(52910);
                }
            });
            Drawable logo = this.mToolBar.getLogo();
            if (logo != null) {
                logo.setVisible(false, true);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public void setTitle(String str) {
        this.mToolBar.setTitle(str);
    }

    /* access modifiers changed from: protected */
    public void onBackBtnClick() {
        finish();
    }
}
