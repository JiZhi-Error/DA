package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public class ScannerFlashSwitcher extends LinearLayout {
    private ImageView COa;
    private TextView COb;
    private boolean COc = false;
    public boolean VC;
    boolean ddZ;

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91061);
        init();
        AppMethodBeat.o(91061);
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(91062);
        init();
        AppMethodBeat.o(91062);
    }

    private void init() {
        AppMethodBeat.i(91063);
        aa.jQ(getContext()).inflate(R.layout.boa, (ViewGroup) this, true);
        this.COa = (ImageView) findViewById(R.id.d60);
        this.COb = (TextView) findViewById(R.id.d5w);
        this.COc = true;
        AppMethodBeat.o(91063);
    }

    public final void show() {
        AppMethodBeat.i(91064);
        Log.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", Boolean.valueOf(this.COc));
        this.ddZ = true;
        if (this.COc) {
            this.COa.setAlpha(0.0f);
            this.COb.setAlpha(0.0f);
            setVisibility(0);
            this.COb.animate().alpha(1.0f).setListener(null).setDuration(500);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(91058);
                    ScannerFlashSwitcher.this.COa.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    AppMethodBeat.o(91058);
                }
            });
            ofFloat.setRepeatCount(3);
            ofFloat.setRepeatMode(2);
            ofFloat.setDuration(500L);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.AnonymousClass2 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(91059);
                    ScannerFlashSwitcher.this.COa.setAlpha(1.0f);
                    AppMethodBeat.o(91059);
                }
            });
            ofFloat.start();
            this.COc = false;
        } else {
            setVisibility(0);
            this.COb.animate().alpha(1.0f).setDuration(500).setListener(null).start();
            this.COa.animate().alpha(1.0f).setDuration(500).setListener(null).start();
        }
        setEnabled(true);
        AppMethodBeat.o(91064);
    }

    public final void hide() {
        AppMethodBeat.i(91065);
        Log.i("MicroMsg.ScannerFlashSwitcher", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
        setEnabled(false);
        this.ddZ = false;
        this.COa.animate().alpha(0.0f).setDuration(500);
        this.COb.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(91060);
                ScannerFlashSwitcher.this.setVisibility(8);
                AppMethodBeat.o(91060);
            }
        });
        this.VC = false;
        AppMethodBeat.o(91065);
    }

    public final void eRm() {
        AppMethodBeat.i(91066);
        Log.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
        this.VC = true;
        this.COa.setImageResource(R.raw.scanner_flash_open_on);
        this.COb.setText(R.string.gby);
        AppMethodBeat.o(91066);
    }

    public final void eRn() {
        AppMethodBeat.i(91067);
        Log.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.VC = false;
        this.COa.setImageResource(R.raw.scanner_flash_open_normal);
        this.COb.setText(R.string.gbz);
        AppMethodBeat.o(91067);
    }
}
