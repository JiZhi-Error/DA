package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    private CharSequence Nm;
    private String mDeviceName;
    protected MMActivity qdG;
    private ImageView rEV;
    private TextView rEW;
    private TextView rEX;
    private TextView rEY;
    private View rEZ;
    private TextView rFa;
    private boolean[] rFb;
    private View.OnClickListener[] rFc;
    private String rFd;
    private boolean rFe;
    private String rcG;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23827);
        this.rFb = new boolean[6];
        this.rFc = new View.OnClickListener[6];
        this.rFe = false;
        this.qdG = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(23827);
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(23828);
        this.rFb = new boolean[6];
        this.rFc = new View.OnClickListener[6];
        this.rFe = false;
        this.qdG = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(23828);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(23829);
        Log.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.rEV = (ImageView) view.findViewById(R.id.wn);
        this.rEW = (TextView) view.findViewById(R.id.ft9);
        this.rEX = (TextView) view.findViewById(R.id.bvk);
        this.rEY = (TextView) view.findViewById(R.id.bow);
        this.rEZ = view.findViewById(R.id.bvl);
        this.rFa = (TextView) view.findViewById(R.id.bov);
        aa(this.rEV, 0);
        aa(this.rEW, 2);
        aa(this.rEX, 1);
        aa(this.rEY, 3);
        aa(this.rEZ, 4);
        aa(this.rFa, 5);
        this.rFe = true;
        if (!this.rFe) {
            Log.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.rFe);
        } else {
            this.rEW.setText(this.Nm);
            this.rEY.setText(this.mDeviceName);
            this.rFa.setText(this.rFd);
            setIconUrl(this.rcG);
        }
        super.onBindView(view);
        AppMethodBeat.o(23829);
    }

    private void aa(View view, int i2) {
        AppMethodBeat.i(23830);
        view.setVisibility(this.rFb[i2] ? 8 : 0);
        view.setOnClickListener(this.rFc[i2]);
        AppMethodBeat.o(23830);
    }

    public final void ai(int i2, boolean z) {
        View view;
        boolean z2;
        int i3 = 0;
        AppMethodBeat.i(23831);
        switch (i2) {
            case 0:
                view = this.rEV;
                break;
            case 1:
                view = this.rEX;
                break;
            case 2:
                view = this.rEW;
                break;
            case 3:
                view = this.rEY;
                break;
            case 4:
                view = this.rEZ;
                break;
            case 5:
                view = this.rFa;
                break;
            default:
                AppMethodBeat.o(23831);
                return;
        }
        boolean[] zArr = this.rFb;
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[i2] = z2;
        if (view != null) {
            if (!z) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        AppMethodBeat.o(23831);
    }

    public final void a(int i2, View.OnClickListener onClickListener) {
        View view;
        AppMethodBeat.i(23832);
        switch (i2) {
            case 0:
                view = this.rEV;
                break;
            case 1:
                view = this.rEX;
                break;
            case 2:
                view = this.rEW;
                break;
            case 3:
                view = this.rEY;
                break;
            case 4:
                view = this.rEZ;
                break;
            case 5:
                view = this.rFa;
                break;
            default:
                AppMethodBeat.o(23832);
                return;
        }
        this.rFc[i2] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(23832);
    }

    public final void setName(CharSequence charSequence) {
        AppMethodBeat.i(23833);
        this.Nm = charSequence;
        if (this.rEW != null) {
            this.rEW.setText(charSequence);
        }
        AppMethodBeat.o(23833);
    }

    public final void anM(String str) {
        AppMethodBeat.i(23834);
        this.mDeviceName = str;
        if (this.rEY != null) {
            this.rEY.setText(str);
        }
        AppMethodBeat.o(23834);
    }

    public final void Cs(String str) {
        AppMethodBeat.i(23835);
        this.rFd = str;
        if (this.rFa != null) {
            this.rFa.setText(str);
        }
        AppMethodBeat.o(23835);
    }

    public final void setIconUrl(String str) {
        AppMethodBeat.i(23836);
        this.rcG = str;
        if (this.rEV != null) {
            c.a aVar = new c.a();
            Bitmap bitmapNative = BitmapUtil.getBitmapNative((int) R.drawable.bd0);
            if (bitmapNative != null && !bitmapNative.isRecycled() && (bitmapNative = BitmapUtil.getRoundedCornerBitmap(bitmapNative, true, 0.5f * ((float) bitmapNative.getWidth()))) != null && !bitmapNative.isRecycled()) {
                aVar.hZC = new BitmapDrawable(bitmapNative);
            }
            if (bitmapNative == null || bitmapNative.isRecycled()) {
                aVar.jbq = R.drawable.bd0;
            }
            aVar.iaT = true;
            q.bcV().a(this.rcG, this.rEV, aVar.bdv());
        }
        AppMethodBeat.o(23836);
    }
}
