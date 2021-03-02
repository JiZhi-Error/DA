package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.a;
import com.tencent.mm.sdk.platformtools.Log;

public class VoiceTipInfoView extends LinearLayout {
    TextView BgP;
    private boolean GSA = false;
    private float GSB = 0.0f;
    boolean GSx = false;
    private boolean GSy = false;
    private TextView GSz;
    public ProgressBar krF;
    TextView mPa;

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29910);
        View inflate = LayoutInflater.from(context).inflate(R.layout.cda, (ViewGroup) this, true);
        this.krF = (ProgressBar) inflate.findViewById(R.id.ep4);
        ekF();
        this.mPa = (TextView) inflate.findViewById(R.id.j_j);
        this.BgP = (TextView) inflate.findViewById(R.id.j_l);
        this.GSz = (TextView) inflate.findViewById(R.id.j_k);
        reset();
        AppMethodBeat.o(29910);
    }

    public final void reset() {
        AppMethodBeat.i(29911);
        this.BgP.setTextSize(0, getContext().getResources().getDimension(R.dimen.aol));
        this.GSB = this.BgP.getTextSize();
        this.BgP.clearAnimation();
        Log.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", Float.valueOf(this.GSB));
        AppMethodBeat.o(29911);
    }

    public final void fEU() {
        AppMethodBeat.i(29912);
        Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.krF.setVisibility(0);
        AppMethodBeat.o(29912);
    }

    public final void ekF() {
        AppMethodBeat.i(29913);
        Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.krF.setVisibility(8);
        AppMethodBeat.o(29913);
    }

    public void setTipText(String str) {
        AppMethodBeat.i(29914);
        this.BgP.setText(str);
        this.BgP.setVisibility(0);
        AppMethodBeat.o(29914);
    }

    public void setTipText(int i2) {
        AppMethodBeat.i(29915);
        this.BgP.setText(i2);
        this.BgP.setVisibility(0);
        AppMethodBeat.o(29915);
    }

    public void setTitleText(String str) {
        AppMethodBeat.i(29916);
        this.mPa.setText(str);
        this.mPa.setVisibility(0);
        AppMethodBeat.o(29916);
    }

    public void setTitleText(int i2) {
        AppMethodBeat.i(29917);
        this.mPa.setText(i2);
        this.mPa.setVisibility(0);
        AppMethodBeat.o(29917);
    }

    public final void fEV() {
        AppMethodBeat.i(29918);
        Log.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(this.mPa.getVisibility()), Boolean.valueOf(this.GSx));
        if ((this.mPa.getVisibility() == 4 || this.mPa.getVisibility() == 8) && !this.GSx) {
            this.mPa.clearAnimation();
            this.GSx = true;
            a.b(this.mPa, getContext(), new a.AbstractC1886a() {
                /* class com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                public final void fEL() {
                }

                @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                public final void fEM() {
                    AppMethodBeat.i(29906);
                    VoiceTipInfoView.this.mPa.setVisibility(0);
                    VoiceTipInfoView.this.GSx = false;
                    AppMethodBeat.o(29906);
                }
            });
            AppMethodBeat.o(29918);
            return;
        }
        Log.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.mPa.clearAnimation();
        this.mPa.setVisibility(0);
        this.mPa.invalidate();
        AppMethodBeat.o(29918);
    }

    public final void fEW() {
        AppMethodBeat.i(29919);
        this.BgP.setVisibility(8);
        AppMethodBeat.o(29919);
    }

    public final void fEX() {
        AppMethodBeat.i(29920);
        if (this.GSz.getVisibility() != 4 || this.GSA) {
            this.GSz.clearAnimation();
            this.GSz.setVisibility(0);
            AppMethodBeat.o(29920);
            return;
        }
        this.GSz.clearAnimation();
        this.GSA = true;
        TextView textView = this.GSz;
        getContext();
        a.b(textView, new a.AbstractC1886a() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEL() {
            }

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEM() {
                AppMethodBeat.i(29908);
                VoiceTipInfoView.this.GSz.setVisibility(0);
                VoiceTipInfoView.this.GSA = false;
                AppMethodBeat.o(29908);
            }
        });
        AppMethodBeat.o(29920);
    }

    public final void fEY() {
        AppMethodBeat.i(29921);
        if (this.GSz.getVisibility() != 0 || this.GSA) {
            this.GSz.clearAnimation();
            this.GSz.setVisibility(4);
            AppMethodBeat.o(29921);
            return;
        }
        this.GSz.clearAnimation();
        this.GSA = true;
        a.a(this.GSz, getContext(), new a.AbstractC1886a() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEL() {
            }

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEM() {
                AppMethodBeat.i(29909);
                VoiceTipInfoView.this.GSz.setVisibility(4);
                VoiceTipInfoView.this.GSA = false;
                AppMethodBeat.o(29909);
            }
        });
        AppMethodBeat.o(29921);
    }

    public void setErr(String str) {
        AppMethodBeat.i(29922);
        this.GSz.setText(str);
        AppMethodBeat.o(29922);
    }

    public void setErr(int i2) {
        AppMethodBeat.i(29923);
        this.GSz.setText(i2);
        AppMethodBeat.o(29923);
    }
}
