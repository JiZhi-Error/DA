package com.d.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public final class m implements UiSettings {
    private com.tencent.tencentmap.mapsdk.maps.UiSettings SKv;

    public m(com.tencent.tencentmap.mapsdk.maps.UiSettings uiSettings) {
        this.SKv = uiSettings;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final boolean isAnimationEnabled() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setAnimationEnabled(boolean z) {
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setScaleControlsEnabled(boolean z) {
        AppMethodBeat.i(217550);
        if (this.SKv != null) {
            this.SKv.setScaleViewEnabled(z);
        }
        AppMethodBeat.o(217550);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setScrollGesturesEnabled(boolean z) {
        AppMethodBeat.i(217551);
        if (this.SKv != null) {
            this.SKv.setScrollGesturesEnabled(z);
        }
        AppMethodBeat.o(217551);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setZoomGesturesEnabled(boolean z) {
        AppMethodBeat.i(217552);
        if (this.SKv != null) {
            this.SKv.setZoomGesturesEnabled(z);
        }
        AppMethodBeat.o(217552);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setAllGesturesEnabled(boolean z) {
        AppMethodBeat.i(217553);
        if (this.SKv != null) {
            this.SKv.setAllGesturesEnabled(z);
        }
        AppMethodBeat.o(217553);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setLogoPosition(int i2) {
        AppMethodBeat.i(217554);
        if (this.SKv != null) {
            this.SKv.setLogoPosition(i2);
        }
        AppMethodBeat.o(217554);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setScaleViewPosition(int i2) {
        AppMethodBeat.i(217555);
        if (this.SKv != null) {
            switch (i2) {
                case 1:
                    i2 = 4;
                    break;
                case 2:
                    i2 = 1;
                    break;
            }
            this.SKv.setScaleViewPosition(i2);
        }
        AppMethodBeat.o(217555);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final boolean isScaleControlsEnabled() {
        AppMethodBeat.i(217556);
        if (this.SKv != null) {
            boolean isScaleViewEnabled = this.SKv.isScaleViewEnabled();
            AppMethodBeat.o(217556);
            return isScaleViewEnabled;
        }
        AppMethodBeat.o(217556);
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setTiltGesturesEnabled(boolean z) {
        AppMethodBeat.i(217557);
        if (this.SKv == null) {
            AppMethodBeat.o(217557);
            return;
        }
        this.SKv.setTiltGesturesEnabled(z);
        AppMethodBeat.o(217557);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setRotateGesturesEnabled(boolean z) {
        AppMethodBeat.i(217558);
        if (this.SKv == null) {
            AppMethodBeat.o(217558);
            return;
        }
        this.SKv.setRotateGesturesEnabled(z);
        AppMethodBeat.o(217558);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final boolean isTiltGesturesEnabled() {
        AppMethodBeat.i(217559);
        if (this.SKv == null) {
            AppMethodBeat.o(217559);
            return false;
        }
        boolean isTiltGesturesEnabled = this.SKv.isTiltGesturesEnabled();
        AppMethodBeat.o(217559);
        return isTiltGesturesEnabled;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setLogoScale(float f2) {
        AppMethodBeat.i(217560);
        if (this.SKv == null) {
            AppMethodBeat.o(217560);
            return;
        }
        this.SKv.setLogoScale(f2);
        AppMethodBeat.o(217560);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final boolean isRotateGesturesEnabled() {
        AppMethodBeat.i(217561);
        if (this.SKv == null) {
            AppMethodBeat.o(217561);
            return false;
        }
        boolean isRotateGesturesEnabled = this.SKv.isRotateGesturesEnabled();
        AppMethodBeat.o(217561);
        return isRotateGesturesEnabled;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setLogoPosition(int i2, int[] iArr) {
        AppMethodBeat.i(217562);
        if (this.SKv != null) {
            this.SKv.setLogoPosition(i2, iArr);
        }
        AppMethodBeat.o(217562);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setIndoorLevelPickerEnabled(boolean z) {
        AppMethodBeat.i(217563);
        if (this.SKv != null) {
            this.SKv.setIndoorLevelPickerEnabled(z);
        }
        AppMethodBeat.o(217563);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final boolean isIndoorLevelPickerEnabled() {
        AppMethodBeat.i(217564);
        if (this.SKv == null) {
            AppMethodBeat.o(217564);
            return false;
        }
        boolean isIndoorLevelPickerEnabled = this.SKv.isIndoorLevelPickerEnabled();
        AppMethodBeat.o(217564);
        return isIndoorLevelPickerEnabled;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final void setCompassEnabled(boolean z) {
        AppMethodBeat.i(217565);
        if (this.SKv == null) {
            AppMethodBeat.o(217565);
            return;
        }
        this.SKv.setCompassEnabled(z);
        AppMethodBeat.o(217565);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.UiSettings
    public final boolean isCompassEnabled() {
        AppMethodBeat.i(217566);
        if (this.SKv == null) {
            AppMethodBeat.o(217566);
            return false;
        }
        boolean isCompassEnabled = this.SKv.isCompassEnabled();
        AppMethodBeat.o(217566);
        return isCompassEnabled;
    }
}
