package com.tencent.midas.comm;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class APProgressDialog extends ProgressDialog {
    private Context context = null;
    private String loadingTxt = "请稍候...";
    private TextView loading_txt = null;

    public APProgressDialog(Context context2) {
        super(context2);
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(193215);
        super.onCreate(bundle);
        setContentView(APMidasCommMethod.getLayoutId(this.context, "unipay_layout_loadding"));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(600);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        ((ProgressBar) findViewById(APMidasCommMethod.getId(this.context, "unipay_progress"))).setAnimation(alphaAnimation);
        alphaAnimation.start();
        this.loading_txt = (TextView) findViewById(APMidasCommMethod.getId(this.context, "unipay_id_LoadingTxt"));
        this.loading_txt.setText(this.loadingTxt);
        setCancelable(false);
        AppMethodBeat.o(193215);
    }

    public void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(193216);
        super.setMessage(charSequence);
        this.loadingTxt = String.valueOf(charSequence);
        AppMethodBeat.o(193216);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(193217);
        if (i2 == 4) {
            cancel();
            AppMethodBeat.o(193217);
            return false;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(193217);
        return onKeyDown;
    }
}
