package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean OSK;
    private boolean OSL;
    private boolean OSM;
    private a OSN;
    private a OSO;

    public interface a {
        void a(MMRadioImageButton mMRadioImageButton);

        void b(MMRadioImageButton mMRadioImageButton);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.OSL = true;
    }

    public boolean performClick() {
        AppMethodBeat.i(142117);
        toggle();
        AppMethodBeat.o(142117);
        return false;
    }

    public boolean isChecked() {
        return this.OSM;
    }

    public void setChecked(boolean z) {
        AppMethodBeat.i(142118);
        if (this.OSM != z) {
            this.OSM = z;
            setSelected(this.OSM);
            refreshDrawableState();
            if (this.OSK) {
                AppMethodBeat.o(142118);
                return;
            }
            this.OSK = true;
            if (this.OSN != null) {
                this.OSN.a(this);
            }
            if (this.OSO != null) {
                this.OSO.a(this);
            }
            this.OSK = false;
        }
        AppMethodBeat.o(142118);
    }

    public void setCheckable(boolean z) {
        this.OSL = z;
    }

    public void setOnMMRadioButtonCheckedChangeListener(a aVar) {
        this.OSN = aVar;
    }

    public void setOnOtherMMRadioButtonCheckedChangeListener(a aVar) {
        this.OSO = aVar;
    }

    public void toggle() {
        AppMethodBeat.i(142116);
        if (!this.OSL) {
            if (this.OSN != null) {
                this.OSN.b(this);
            }
            if (this.OSO != null) {
                this.OSO.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.OSM);
            AppMethodBeat.o(142116);
            return;
        }
        AppMethodBeat.o(142116);
    }
}
