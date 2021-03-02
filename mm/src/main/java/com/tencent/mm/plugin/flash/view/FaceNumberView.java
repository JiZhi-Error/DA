package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceNumberView extends RelativeLayout {
    View wIS;
    TextView wIT;
    Animation wIU;

    public FaceNumberView(Context context) {
        this(context, null);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FaceNumberView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(186715);
        this.wIU = new AlphaAnimation(0.0f, 1.0f);
        LayoutInflater.from(getContext()).inflate(R.layout.a5w, (ViewGroup) this, true);
        setGravity(17);
        this.wIS = findViewById(R.id.c9q);
        this.wIT = (TextView) findViewById(R.id.c9o);
        AppMethodBeat.o(186715);
    }

    public void setNumber(String str) {
        AppMethodBeat.i(186716);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "setNumber :%s", str);
        this.wIT.setText(str);
        AppMethodBeat.o(186716);
    }

    public final void release() {
        AppMethodBeat.i(186717);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.flash.view.FaceNumberView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186714);
                Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
                FaceNumberView.this.wIU.cancel();
                FaceNumberView.this.wIT.clearAnimation();
                AppMethodBeat.o(186714);
            }
        });
        AppMethodBeat.o(186717);
    }
}
