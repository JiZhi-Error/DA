package com.samsung.android.sdk.look.airbutton;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl;
import com.samsung.android.sdk.look.Slook;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookAirButton {
    public static final int DIRECTION_AUTO = -1;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_LOWER = 2;
    public static final int DIRECTION_RIGHT = 4;
    public static final int DIRECTION_UPPER = 1;
    public static final int GRAVITY_AUTO = -1;
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_HOVER_POINT = 5;
    public static final int GRAVITY_LEFT = 3;
    public static final int GRAVITY_RIGHT = 4;
    public static final int GRAVITY_TOP = 1;
    private static final String TAG = "AirButtonWidget";
    public static final int UI_TYPE_LIST = 2;
    public static final int UI_TYPE_MENU = 1;
    private AirButtonImpl mAirButtonImpl = null;
    private ItemSelectListener mItemSelectListener;
    private Slook mSlook = new Slook();
    private int mUIType = 2;

    public interface ItemSelectListener {
        void onItemSelected(View view, int i2, Object obj);
    }

    public SlookAirButton(View view, SlookAirButtonAdapter slookAirButtonAdapter, int i2) {
        AppMethodBeat.i(76293);
        if (!isSupport(1)) {
            AppMethodBeat.o(76293);
        } else if (slookAirButtonAdapter == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("adapter is null");
            AppMethodBeat.o(76293);
            throw illegalArgumentException;
        } else {
            this.mUIType = i2;
            this.mAirButtonImpl = new AirButtonImpl(view, slookAirButtonAdapter, i2);
            AppMethodBeat.o(76293);
        }
    }

    public void setItemSelectListener(ItemSelectListener itemSelectListener) {
        AppMethodBeat.i(76294);
        if (!isSupport(1)) {
            AppMethodBeat.o(76294);
            return;
        }
        this.mItemSelectListener = itemSelectListener;
        if (this.mItemSelectListener != null) {
            this.mAirButtonImpl.setOnItemSelectedListener(new AirButtonImpl.OnItemSelectedListener() {
                /* class com.samsung.android.sdk.look.airbutton.SlookAirButton.AnonymousClass1 */

                public void onItemSelected(View view, int i2, Object obj) {
                    AppMethodBeat.i(76313);
                    SlookAirButton.this.mItemSelectListener.onItemSelected(view, i2, obj);
                    AppMethodBeat.o(76313);
                }
            });
        }
        AppMethodBeat.o(76294);
    }

    public void setGravity(int i2) {
        AppMethodBeat.i(76295);
        if (!isSupport(1)) {
            AppMethodBeat.o(76295);
            return;
        }
        switch (i2) {
            case -1:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 0:
            default:
                new StringBuilder("The gravity(").append(i2).append(") was wrong.");
                break;
        }
        if (this.mUIType == 1 && (i2 == 3 || i2 == 4)) {
            IllegalStateException illegalStateException = new IllegalStateException("The Gravity is wrong. You cann't use GRAVITY_LEFT/GRAVITY_RIGHT with UI_TYPE_MENU.");
            AppMethodBeat.o(76295);
            throw illegalStateException;
        }
        this.mAirButtonImpl.setGravity(i2);
        AppMethodBeat.o(76295);
    }

    public int getGravity() {
        AppMethodBeat.i(76296);
        if (!isSupport(1)) {
            AppMethodBeat.o(76296);
            return 0;
        }
        int gravity = this.mAirButtonImpl.getGravity();
        AppMethodBeat.o(76296);
        return gravity;
    }

    public void setDirection(int i2) {
        AppMethodBeat.i(76297);
        if (!isSupport(1)) {
            AppMethodBeat.o(76297);
            return;
        }
        switch (i2) {
            case -1:
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 0:
            default:
                new StringBuilder("The direction(").append(i2).append(") was wrong.");
                break;
        }
        if (this.mUIType == 1 && (i2 == 1 || i2 == 2)) {
            IllegalStateException illegalStateException = new IllegalStateException("The Direction is wrong.you cann't use UPPER/LOWER direction with UI_TYPE_MENU.");
            AppMethodBeat.o(76297);
            throw illegalStateException;
        } else if (this.mUIType == 2 && (i2 == 3 || i2 == 4)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("The Direction is wrong.you cann't use LEFT/RIGHT direction with UI_TYPE_LIST.");
            AppMethodBeat.o(76297);
            throw illegalStateException2;
        } else {
            this.mAirButtonImpl.setDirection(i2);
            AppMethodBeat.o(76297);
        }
    }

    public int getDirection() {
        AppMethodBeat.i(76298);
        if (!isSupport(1)) {
            AppMethodBeat.o(76298);
            return 0;
        }
        int direction = this.mAirButtonImpl.getDirection();
        AppMethodBeat.o(76298);
        return direction;
    }

    public void setPosition(int i2, int i3) {
        AppMethodBeat.i(76299);
        if (!isSupport(1)) {
            AppMethodBeat.o(76299);
            return;
        }
        this.mAirButtonImpl.setPosition(i2, i3);
        AppMethodBeat.o(76299);
    }

    public void setScrollEnabled(boolean z) {
        AppMethodBeat.i(76300);
        if (!isSupport(1)) {
            AppMethodBeat.o(76300);
            return;
        }
        this.mAirButtonImpl.setScrollEnabled(z);
        AppMethodBeat.o(76300);
    }

    public boolean isScrollEnabled() {
        AppMethodBeat.i(76301);
        if (!isSupport(1)) {
            AppMethodBeat.o(76301);
            return false;
        }
        boolean isScrollEnabled = this.mAirButtonImpl.isScrollEnabled();
        AppMethodBeat.o(76301);
        return isScrollEnabled;
    }

    private boolean isSupport(int i2) {
        AppMethodBeat.i(76302);
        if (this.mSlook.isFeatureEnabled(1)) {
            AppMethodBeat.o(76302);
            return true;
        }
        AppMethodBeat.o(76302);
        return false;
    }

    public void setBounceEffectEnabled(boolean z) {
        AppMethodBeat.i(76303);
        if (!isSupport(1)) {
            AppMethodBeat.o(76303);
            return;
        }
        this.mAirButtonImpl.setBounceEffectEnabled(z);
        AppMethodBeat.o(76303);
    }

    public boolean isBounceEffectEnabled() {
        AppMethodBeat.i(76304);
        if (!isSupport(1)) {
            AppMethodBeat.o(76304);
            return false;
        }
        boolean isBounceEffectEnabled = this.mAirButtonImpl.isBounceEffectEnabled();
        AppMethodBeat.o(76304);
        return isBounceEffectEnabled;
    }

    public void hide() {
        AppMethodBeat.i(76305);
        if (!isSupport(1)) {
            AppMethodBeat.o(76305);
            return;
        }
        this.mAirButtonImpl.hide();
        AppMethodBeat.o(76305);
    }

    public void dismiss() {
        AppMethodBeat.i(76306);
        if (!isSupport(1)) {
            AppMethodBeat.o(76306);
            return;
        }
        this.mAirButtonImpl.dismiss();
        AppMethodBeat.o(76306);
    }

    public void setAutoControlEnabled(boolean z) {
        AppMethodBeat.i(76307);
        if (!isSupport(1)) {
            AppMethodBeat.o(76307);
            return;
        }
        this.mAirButtonImpl.setEnabled(z);
        AppMethodBeat.o(76307);
    }

    public boolean isAutoControlEnabled() {
        AppMethodBeat.i(76308);
        if (!isSupport(1)) {
            AppMethodBeat.o(76308);
            return false;
        }
        boolean isEnabled = this.mAirButtonImpl.isEnabled();
        AppMethodBeat.o(76308);
        return isEnabled;
    }

    public void startAnimationIcon(MotionEvent motionEvent) {
        AppMethodBeat.i(76309);
        if (!isSupport(1)) {
            AppMethodBeat.o(76309);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(76309);
            throw illegalStateException;
        } else if (motionEvent.getAction() != 9) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't ACTION_HOVER_ENTER");
            AppMethodBeat.o(76309);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverEnter(motionEvent);
            AppMethodBeat.o(76309);
        }
    }

    public void moveAnimationIcon(MotionEvent motionEvent) {
        AppMethodBeat.i(76310);
        if (!isSupport(1)) {
            AppMethodBeat.o(76310);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(76310);
            throw illegalStateException;
        } else if (motionEvent.getAction() != 7) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't ACTION_HOVER_MOVE.");
            AppMethodBeat.o(76310);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverMove(motionEvent);
            AppMethodBeat.o(76310);
        }
    }

    public void stopAnimationIcon(MotionEvent motionEvent) {
        AppMethodBeat.i(76311);
        if (!isSupport(1)) {
            AppMethodBeat.o(76311);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(76311);
            throw illegalStateException;
        } else if (motionEvent.getAction() != 10) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't ACTION_HOVER_EXIT.");
            AppMethodBeat.o(76311);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverExit(motionEvent);
            AppMethodBeat.o(76311);
        }
    }

    public void show(MotionEvent motionEvent) {
        AppMethodBeat.i(76312);
        if (!isSupport(1)) {
            AppMethodBeat.o(76312);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(76312);
            throw illegalStateException;
        } else if (motionEvent.getToolType(0) != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't TOOL_TYPE_STYLUS.");
            AppMethodBeat.o(76312);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverButtonSecondary(motionEvent);
            AppMethodBeat.o(76312);
        }
    }
}
