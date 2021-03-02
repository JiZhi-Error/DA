package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class g implements View.OnTouchListener {
    private long kyW = -1;
    private float kyX = -1.0f;
    private int kyY = 0;
    a kyZ;

    public interface a {
        void I(float f2, float f3);

        void bqQ();

        void bqR();
    }

    public final void a(a aVar) {
        this.kyZ = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(89268);
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
                if (this.kyW <= 0 || SystemClock.elapsedRealtime() - this.kyW >= 400) {
                    if (this.kyZ != null) {
                        this.kyZ.I(motionEvent.getX(), motionEvent.getY());
                    }
                } else if (this.kyZ != null) {
                }
                this.kyW = SystemClock.elapsedRealtime();
                this.kyX = -1.0f;
                this.kyY++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
                this.kyX = -1.0f;
                this.kyY = 0;
                break;
            case 2:
                if (this.kyY >= 2) {
                    float x = x(motionEvent);
                    Log.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", Float.valueOf(x));
                    if (x > 0.0f) {
                        if (this.kyX > 0.0f) {
                            if (Math.abs(x - this.kyX) > 15.0f) {
                                if (x > this.kyX) {
                                    Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
                                    if (this.kyZ != null) {
                                        this.kyZ.bqQ();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
                                    if (this.kyZ != null) {
                                        this.kyZ.bqR();
                                    }
                                }
                            }
                        }
                        this.kyX = x;
                        break;
                    }
                }
                break;
            case 5:
                Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
                this.kyY++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
                this.kyY--;
                break;
        }
        AppMethodBeat.o(89268);
        return true;
    }

    private float x(MotionEvent motionEvent) {
        AppMethodBeat.i(89269);
        try {
            if (this.kyY >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float abs = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
                AppMethodBeat.o(89269);
                return abs;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", e2.getMessage());
        }
        AppMethodBeat.o(89269);
        return 0.0f;
    }
}
