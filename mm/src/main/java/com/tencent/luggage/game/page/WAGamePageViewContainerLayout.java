package com.tencent.luggage.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class WAGamePageViewContainerLayout extends FrameLayout {
    private b cwM;
    private a cwN;

    public interface a {
        void a(b bVar, b bVar2);
    }

    public enum b {
        UNDEFINED,
        PORTRAIT,
        LANDSCAPE,
        PORTRAIT_REVERSE,
        LANDSCAPE_REVERSE;

        public static b valueOf(String str) {
            AppMethodBeat.i(130641);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(130641);
            return bVar;
        }

        static {
            AppMethodBeat.i(130642);
            AppMethodBeat.o(130642);
        }
    }

    public WAGamePageViewContainerLayout(Context context) {
        this(context, null);
    }

    public WAGamePageViewContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setOnConfigurationChangedListener(a aVar) {
        this.cwN = aVar;
    }

    public WAGamePageViewContainerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.cwM = null;
        this.cwN = null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        AppMethodBeat.i(130643);
        super.onLayout(z, i2, i3, i4, i5);
        if (getContext() instanceof Activity) {
            int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
            switch (rotation) {
                case 0:
                    bVar = b.PORTRAIT;
                    break;
                case 1:
                    bVar = b.LANDSCAPE;
                    break;
                case 2:
                    bVar = b.PORTRAIT_REVERSE;
                    break;
                case 3:
                    bVar = b.LANDSCAPE_REVERSE;
                    break;
                default:
                    Log.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", Integer.valueOf(rotation));
                    bVar = b.UNDEFINED;
                    break;
            }
            if (this.cwN != null) {
                this.cwN.a(this.cwM, bVar);
            }
            this.cwM = bVar;
        }
        AppMethodBeat.o(130643);
    }
}
