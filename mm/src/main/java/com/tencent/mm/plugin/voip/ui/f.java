package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.ui.ar;

public final class f extends BaseSmallView {
    private ImageView BQU = ((ImageView) findViewById(R.id.j9l));
    private ImageView gBZ = ((ImageView) findViewById(R.id.jcb));
    private TextView jBS = ((TextView) findViewById(R.id.jcd));
    private TextView timeTv = ((TextView) findViewById(R.id.jcc));

    public f(Context context) {
        super(context, null);
        AppMethodBeat.i(115506);
        LayoutInflater.from(context).inflate(R.layout.c78, this);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_call, Color.parseColor("#07C160")));
        AppMethodBeat.o(115506);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGy(String str) {
        AppMethodBeat.i(115507);
        this.timeTv.setTextSize(1, 14.0f);
        this.timeTv.setText(str);
        setContentDescription(getContext().getString(R.string.b3_) + "," + str);
        AppMethodBeat.o(115507);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGx(String str) {
        AppMethodBeat.i(115508);
        this.timeTv.setTextSize(1, 12.0f);
        this.timeTv.setText(str);
        setContentDescription(getContext().getString(R.string.b3_) + "," + str);
        AppMethodBeat.o(115508);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setCaptureView(CaptureView captureView) {
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void onAnimationEnd() {
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final OpenGlRender getBeautyData() {
        return null;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final OpenGlRender getSpatioTemporalFilterData() {
        return null;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final boolean eoK() {
        AppMethodBeat.i(184087);
        super.eoK();
        this.timeTv.setVisibility(8);
        this.jBS.setVisibility(0);
        this.jBS.setTextColor(Color.parseColor("#FA5151"));
        this.jBS.setText(R.string.i3b);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_call_end, Color.parseColor("#FA5151")));
        AppMethodBeat.o(184087);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void eoL() {
        AppMethodBeat.i(184088);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_call, Color.parseColor("#07C160")));
        this.jBS.setVisibility(8);
        this.jBS.setTextColor(Color.parseColor("#07C160"));
        this.timeTv.setVisibility(0);
        AppMethodBeat.o(184088);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void eoM() {
        AppMethodBeat.i(184877);
        super.eoM();
        this.BQU.setBackground(ar.m(getContext(), R.drawable.b32, getResources().getColor(R.color.f3045c)));
        AppMethodBeat.o(184877);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(184089);
        if (this.GUk != i2) {
            this.GUk = i2;
            this.jBS.setVisibility(0);
            switch (i2) {
                case 1:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_volume_up, Color.parseColor("#07C160")));
                    this.jBS.setText(R.string.i3a);
                    break;
                case 2:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_ear, Color.parseColor("#07C160")));
                    this.jBS.setText(R.string.i39);
                    break;
                case 3:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_headset, Color.parseColor("#07C160")));
                    this.jBS.setText(R.string.i3_);
                    break;
                case 4:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_bluetooth, Color.parseColor("#07C160")));
                    this.jBS.setText(R.string.i38);
                    break;
            }
            this.timeTv.setVisibility(8);
            super.setVoicePlayDevice(i2);
        }
        AppMethodBeat.o(184089);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void enR() {
        AppMethodBeat.i(184090);
        this.jBS.setVisibility(0);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icon_filled_mike_off, Color.parseColor("#FA5151")));
        this.jBS.setTextColor(Color.parseColor("#FA5151"));
        this.jBS.setText(R.string.i4h);
        this.timeTv.setVisibility(8);
        super.enR();
        AppMethodBeat.o(184090);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void xm(boolean z) {
        AppMethodBeat.i(184091);
        if (z) {
            this.timeTv.setVisibility(8);
            this.jBS.setVisibility(0);
            this.jBS.setText(R.string.i3n);
            AppMethodBeat.o(184091);
            return;
        }
        super.xm(false);
        AppMethodBeat.o(184091);
    }
}
