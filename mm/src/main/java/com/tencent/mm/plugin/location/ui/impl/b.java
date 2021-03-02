package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b extends a {
    protected float aTD = 0.0f;
    protected float aTE = 0.0f;
    public Activity activity;
    protected int type = 0;
    protected d yJa;

    public abstract d edI();

    public b(Activity activity2) {
        this.activity = activity2;
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onCreate(Bundle bundle) {
        this.activity.setContentView(R.layout.bib);
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        Log.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", Integer.valueOf(this.type));
        ((FrameLayout) findViewById(R.id.f_w)).addView(d.gs(this.activity));
        this.yJa = edI();
        this.yJa.setMapViewOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.location.ui.impl.b.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(56000);
                int action = motionEvent.getAction();
                Log.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(action)));
                switch (action) {
                    case 0:
                        b.this.aTD = motionEvent.getX();
                        b.this.aTE = motionEvent.getY();
                        b.this.edJ();
                        break;
                    case 1:
                        if (Math.abs(motionEvent.getX() - b.this.aTD) > 10.0f || Math.abs(motionEvent.getY() - b.this.aTE) > 10.0f) {
                            b.this.edK();
                            break;
                        }
                }
                AppMethodBeat.o(56000);
                return false;
            }
        });
        this.yJa.setMapAnchor(0.5f, 0.5f);
    }

    public final View findViewById(int i2) {
        return this.activity.findViewById(i2);
    }

    @Override // com.tencent.mm.plugin.k.a
    public final void onBackPressed() {
    }

    @Override // com.tencent.mm.plugin.k.a
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void edJ() {
    }

    public void edK() {
    }

    @Override // com.tencent.mm.plugin.k.a
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        Log.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
        this.activity.finish();
        return true;
    }

    @Override // com.tencent.mm.plugin.k.a
    public final boolean edH() {
        return false;
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onResume() {
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onPause() {
    }

    @Override // com.tencent.mm.plugin.k.a
    public void onDestroy() {
        this.yJa.destroy();
    }
}
