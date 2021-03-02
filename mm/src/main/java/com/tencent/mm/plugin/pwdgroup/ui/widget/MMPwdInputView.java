package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMPwdInputView extends LinearLayout {
    private boolean BpS;
    private ImageView BpT;
    private ImageView BpU;
    private ImageView BpV;
    private ImageView BpW;
    private a BpX;
    private b BpY;
    public StringBuilder gBy;
    public int sWx;

    public interface a {
        void z(boolean z, String str);
    }

    public enum b {
        Normal,
        Shine;

        public static b valueOf(String str) {
            AppMethodBeat.i(27695);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(27695);
            return bVar;
        }

        static {
            AppMethodBeat.i(27696);
            AppMethodBeat.o(27696);
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(27697);
        this.gBy = new StringBuilder();
        this.BpS = false;
        this.BpY = b.Shine;
        View inflate = inflate(getContext(), R.layout.bjt, null);
        this.BpT = (ImageView) inflate.findViewById(R.id.d57);
        this.BpU = (ImageView) inflate.findViewById(R.id.hfb);
        this.BpV = (ImageView) inflate.findViewById(R.id.ild);
        this.BpW = (ImageView) inflate.findViewById(R.id.d9l);
        this.BpT.setImageResource(R.drawable.byn);
        this.BpU.setImageResource(R.drawable.byn);
        this.BpV.setImageResource(R.drawable.byn);
        this.BpW.setImageResource(R.drawable.byn);
        addView(inflate);
        AppMethodBeat.o(27697);
    }

    public void setOnFinishInputListener(a aVar) {
        this.BpX = aVar;
    }

    public void setNumberStyle(b bVar) {
        this.BpY = bVar;
    }

    public void setNumberWidth(int i2) {
        AppMethodBeat.i(27698);
        if (this.BpT != null) {
            ViewGroup.LayoutParams layoutParams = this.BpT.getLayoutParams();
            layoutParams.width = i2;
            this.BpT.setLayoutParams(layoutParams);
            this.BpU.setLayoutParams(layoutParams);
            this.BpV.setLayoutParams(layoutParams);
            this.BpW.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(27698);
    }

    public final void eFX() {
        String str;
        AppMethodBeat.i(27699);
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.sWx > i2) {
                str = new StringBuilder().append(this.gBy.toString().charAt(i2)).toString();
            } else {
                str = "";
            }
            switch (i2) {
                case 0:
                    w(this.BpT, str);
                    break;
                case 1:
                    w(this.BpU, str);
                    break;
                case 2:
                    w(this.BpV, str);
                    break;
                case 3:
                    w(this.BpW, str);
                    break;
            }
        }
        AppMethodBeat.o(27699);
    }

    private static void w(ImageView imageView, String str) {
        AppMethodBeat.i(27700);
        if (imageView == null) {
            AppMethodBeat.o(27700);
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            imageView.setImageResource(R.drawable.byd);
            AppMethodBeat.o(27700);
        } else if (str.equals("1")) {
            imageView.setImageResource(R.drawable.bye);
            AppMethodBeat.o(27700);
        } else if (str.equals("2")) {
            imageView.setImageResource(R.drawable.byf);
            AppMethodBeat.o(27700);
        } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            imageView.setImageResource(R.drawable.byg);
            AppMethodBeat.o(27700);
        } else if (str.equals("4")) {
            imageView.setImageResource(R.drawable.byh);
            AppMethodBeat.o(27700);
        } else if (str.equals("5")) {
            imageView.setImageResource(R.drawable.byi);
            AppMethodBeat.o(27700);
        } else if (str.equals("6")) {
            imageView.setImageResource(R.drawable.byj);
            AppMethodBeat.o(27700);
        } else if (str.equals("7")) {
            imageView.setImageResource(R.drawable.byk);
            AppMethodBeat.o(27700);
        } else if (str.equals("8")) {
            imageView.setImageResource(R.drawable.byl);
            AppMethodBeat.o(27700);
        } else if (str.equals("9")) {
            imageView.setImageResource(R.drawable.bym);
            AppMethodBeat.o(27700);
        } else {
            imageView.setImageResource(R.drawable.byn);
            AppMethodBeat.o(27700);
        }
    }

    public final void cTV() {
        AppMethodBeat.i(27701);
        if (this.gBy != null) {
            this.sWx = this.gBy.length();
        } else {
            this.sWx = 0;
        }
        if (this.sWx >= 4) {
            this.BpS = true;
        } else {
            this.BpS = false;
        }
        if (this.BpX != null) {
            this.BpX.z(this.BpS, this.gBy.toString());
        }
        AppMethodBeat.o(27701);
    }

    public final void byC() {
        AppMethodBeat.i(27702);
        if (this.sWx > 0) {
            this.gBy.delete(0, this.sWx);
        }
        cTV();
        eFX();
        AppMethodBeat.o(27702);
    }

    public final void input(String str) {
        AppMethodBeat.i(27703);
        if (TextUtils.isEmpty(str) || this.BpS) {
            AppMethodBeat.o(27703);
            return;
        }
        this.gBy.append(str);
        cTV();
        eFX();
        AppMethodBeat.o(27703);
    }
}
