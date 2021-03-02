package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookPointerIcon {
    private static final String TAG = "SlookPointerIcon";
    private Drawable mDrawable;
    private Slook mSlook = new Slook();

    public SlookPointerIcon() {
        AppMethodBeat.i(76314);
        AppMethodBeat.o(76314);
    }

    public void setHoverIcon(View view, Drawable drawable) {
        AppMethodBeat.i(76315);
        if (!isSupport(1)) {
            AppMethodBeat.o(76315);
        } else if (view == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("view is null.");
            AppMethodBeat.o(76315);
            throw illegalArgumentException;
        } else if (drawable == null) {
            view.setOnHoverListener(null);
            try {
                PointerIcon.setHoveringSpenIcon(1, -1);
                AppMethodBeat.o(76315);
            } catch (RemoteException e2) {
                AppMethodBeat.o(76315);
            }
        } else {
            this.mDrawable = drawable;
            view.setOnHoverListener(new View.OnHoverListener() {
                /* class com.samsung.android.sdk.look.SlookPointerIcon.AnonymousClass1 */

                public boolean onHover(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(76234);
                    switch (motionEvent.getAction()) {
                        case 9:
                            try {
                                PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.this.mDrawable);
                                break;
                            } catch (RemoteException e2) {
                                break;
                            }
                        case 10:
                            try {
                                PointerIcon.setHoveringSpenIcon(1, -1);
                                break;
                            } catch (RemoteException e3) {
                                break;
                            }
                    }
                    AppMethodBeat.o(76234);
                    return false;
                }
            });
            AppMethodBeat.o(76315);
        }
    }

    private boolean isSupport(int i2) {
        AppMethodBeat.i(76316);
        if (this.mSlook.isFeatureEnabled(4)) {
            AppMethodBeat.o(76316);
            return true;
        }
        AppMethodBeat.o(76316);
        return false;
    }
}
