package com.tencent.mm.ext.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.SwipeBackLayout;
import com.tencent.mm.ext.ui.d;

public class SwipeBackActivity extends AppCompatActivity implements SwipeBackLayout.a, d.a {
    protected SwipeBackLayout hfl;
    private View mContentViewForSwipeBack = null;
    private boolean mSwiping;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        AppMethodBeat.i(197826);
        super.onCreate(bundle, persistableBundle);
        AppMethodBeat.o(197826);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(197827);
        super.onStart();
        AppMethodBeat.o(197827);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(197828);
        super.onPause();
        if (this.hfl != null) {
            this.hfl.setEnableGesture(false);
        }
        if (!isFinishing()) {
            d.a(this);
        }
        AppMethodBeat.o(197828);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(197829);
        super.onResume();
        d.b(this);
        onSwipe(1.0f);
        if (this.hfl != null) {
            this.hfl.setEnableGesture(true);
            this.hfl.hfx = false;
        }
        AppMethodBeat.o(197829);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(197830);
        super.onStop();
        AppMethodBeat.o(197830);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(197831);
        super.onDestroy();
        AppMethodBeat.o(197831);
    }

    @Override // com.tencent.mm.ext.ui.d.a
    public final void onSwipe(float f2) {
        AppMethodBeat.i(197833);
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = e.a(getWindow(), getSupportActionBar() != null ? getSupportActionBar().getCustomView() : null);
        }
        View view = this.mContentViewForSwipeBack;
        if (Float.compare(1.0f, f2) <= 0) {
            b.q(view, 0.0f);
            AppMethodBeat.o(197833);
            return;
        }
        b.q(view, (((float) view.getWidth()) / 3.5f) * (1.0f - f2) * -1.0f);
        AppMethodBeat.o(197833);
    }

    @Override // com.tencent.mm.ext.ui.d.a
    public final void onSettle(boolean z, int i2) {
        long j2 = 130;
        AppMethodBeat.i(197834);
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = e.a(getWindow(), getSupportActionBar().getCustomView());
        }
        View view = this.mContentViewForSwipeBack;
        if (z) {
            if (i2 <= 0) {
                j2 = 260;
            }
            b.a(view, j2, 0.0f, null);
            AppMethodBeat.o(197834);
            return;
        }
        if (i2 <= 0) {
            j2 = 260;
        }
        b.a(view, j2, ((float) (view.getWidth() * -1)) / 3.5f, null);
        AppMethodBeat.o(197834);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(197835);
        if (!isFinishing()) {
            finish();
        }
        getWindow().getDecorView().setVisibility(8);
        overridePendingTransition(0, 0);
        this.mSwiping = false;
        AppMethodBeat.o(197835);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackLayout.a
    public final void onDrag() {
        this.mSwiping = true;
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackLayout.a
    public final void onCancel() {
        this.mSwiping = false;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(197832);
        SwipeBackLayout swipeBackLayout = this.hfl;
        if (keyEvent.getKeyCode() == 4 && swipeBackLayout != null) {
            swipeBackLayout.awK();
            if (swipeBackLayout.hfx) {
                b.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event", new Object[0]);
                AppMethodBeat.o(197832);
                return true;
            }
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(197832);
        return dispatchKeyEvent;
    }
}
