package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class f extends g {
    private eiw GjK;
    public ImageView GmA;
    public View GoE;
    public View GoF;
    public ImageView GoG;
    public TextView GoH;
    public View GoI;
    public View GoJ;
    public View GoK;
    public View GoL;
    public View GoM;
    public View GoN;
    public View GoO;
    public TextView GoP;
    public TextView GoQ;
    public ImageView GoR;
    public ImageView GoS;
    public View GoT;
    MTimerHandler GoU;
    private a GoV;
    private boolean GoW;
    public TextView titleTv;
    public TextView xYx;

    public interface a {
        void b(eiw eiw, int i2, int i3);

        void fzK();

        void fzL();
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public int getLayoutId() {
        return R.layout.c3v;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.topstory.ui.video.g, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public void init() {
        AppMethodBeat.i(126305);
        super.init();
        this.GoI = this.contentView.findViewById(R.id.bej);
        this.GoE = this.contentView.findViewById(R.id.hpi);
        this.GoF = this.contentView.findViewById(R.id.jox);
        this.GoG = (ImageView) this.contentView.findViewById(R.id.jow);
        this.GoH = (TextView) this.contentView.findViewById(R.id.jov);
        this.GoJ = this.contentView.findViewById(R.id.gln);
        this.GoK = this.contentView.findViewById(R.id.glm);
        this.GoL = this.contentView.findViewById(R.id.ih0);
        this.GoM = this.contentView.findViewById(R.id.abg);
        this.GoN = this.contentView.findViewById(R.id.igp);
        this.GoO = this.contentView.findViewById(R.id.igt);
        this.GoP = (TextView) this.contentView.findViewById(R.id.igq);
        this.GoQ = (TextView) this.contentView.findViewById(R.id.igu);
        this.GoR = (ImageView) this.contentView.findViewById(R.id.igo);
        this.GoS = (ImageView) this.contentView.findViewById(R.id.igs);
        this.GmA = (ImageView) this.contentView.findViewById(R.id.i2z);
        this.xYx = (TextView) this.contentView.findViewById(R.id.i34);
        this.GoT = this.contentView.findViewById(R.id.i2y);
        this.titleTv = (TextView) this.contentView.findViewById(R.id.ir3);
        AppMethodBeat.o(126305);
    }

    public final void m(eiw eiw) {
        AppMethodBeat.i(126306);
        if ((eiw.Nix & 128) > 0) {
            this.GoF.setVisibility(0);
            if (eiw.NiC) {
                this.GoG.setImageResource(R.raw.top_story_wow_selected);
                this.GoH.setTextColor(getResources().getColor(R.color.ac7));
            } else {
                this.GoG.setImageResource(R.raw.top_story_wow_unselected);
                this.GoH.setTextColor(getResources().getColor(R.color.ag2));
            }
            this.GoH.setText(c.abR(eiw.NiH));
            AppMethodBeat.o(126306);
            return;
        }
        this.GoF.setVisibility(8);
        AppMethodBeat.o(126306);
    }

    public void n(eiw eiw) {
        AppMethodBeat.i(126307);
        this.GjK = eiw;
        this.GoE.setVisibility(0);
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a8a);
        this.mCQ.setTextSize(0, dimensionPixelSize);
        this.mCR.setTextSize(0, dimensionPixelSize);
        ViewGroup.LayoutParams layoutParams = this.GoK.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a8_);
        this.GoK.setLayoutParams(layoutParams);
        if (eiw.xuO.size() > 0) {
            if (this.GoL != null) {
                this.GoL.setVisibility(0);
            }
            this.GoM.setVisibility(0);
            dyi dyi = eiw.xuO.get(0);
            this.GoN.setTag(dyi);
            this.GoP.setText(dyi.dQx);
            this.GoP.setVisibility(0);
            this.GoN.setVisibility(0);
            this.GoR.setVisibility(8);
            if (!Util.isNullOrNil(dyi.icon)) {
                q.bcV().a(dyi.icon, this.GoR, c.GjV);
                this.GoR.setVisibility(0);
            }
            if (eiw.xuO.size() > 1) {
                dyi dyi2 = eiw.xuO.get(1);
                this.GoO.setTag(dyi2);
                this.GoQ.setText(dyi2.dQx);
                this.GoQ.setVisibility(0);
                this.GoO.setVisibility(0);
                this.GoS.setVisibility(8);
                if (!Util.isNullOrNil(dyi2.icon)) {
                    q.bcV().a(dyi2.icon, this.GoS, c.GjV);
                    this.GoS.setVisibility(0);
                }
            } else {
                this.GoO.setVisibility(8);
                this.GoQ.setVisibility(8);
            }
        } else {
            if (this.GoL != null) {
                this.GoL.setVisibility(8);
            }
            this.GoM.setVisibility(8);
        }
        m(eiw);
        if (this.GoW) {
            this.GoM.setVisibility(8);
        }
        if (!(this.GoT == null || this.xYx == null || this.GmA == null)) {
            this.GoT.setVisibility(8);
            this.xYx.setVisibility(8);
            this.GmA.setVisibility(8);
            if (!Util.isNullOrNil(eiw.source)) {
                this.xYx.setText(eiw.source);
                this.xYx.setVisibility(0);
                if (n.i(eiw)) {
                    this.GoT.setVisibility(0);
                }
                if (!Util.isNullOrNil(eiw.MwR)) {
                    q.bcV().a(eiw.MwR, this.GmA, c.GjU);
                } else {
                    this.GmA.setImageResource(R.drawable.bca);
                }
                this.GmA.setVisibility(0);
            }
        }
        if (this.titleTv != null) {
            this.titleTv.setText(eiw.title);
        }
        AppMethodBeat.o(126307);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.g
    public final void hide() {
        AppMethodBeat.i(263560);
        setVisibility(8);
        AppMethodBeat.o(263560);
    }

    public final boolean bJw() {
        AppMethodBeat.i(126309);
        if (getVisibility() == 0) {
            AppMethodBeat.o(126309);
            return true;
        }
        AppMethodBeat.o(126309);
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.g
    public final void show() {
        AppMethodBeat.i(126310);
        setVisibility(0);
        fzN();
        if (this.GoU == null) {
            this.GoU = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.topstory.ui.video.fs.f.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(126304);
                    f.this.setVisibility(8);
                    f.this.GoU.stopTimer();
                    AppMethodBeat.o(126304);
                    return false;
                }
            }, false);
        }
        this.GoU.stopTimer();
        this.GoU.startTimer(2000);
        AppMethodBeat.o(126310);
    }

    public final void crH() {
        AppMethodBeat.i(126311);
        if (this.GoU != null) {
            this.GoU.stopTimer();
        }
        AppMethodBeat.o(126311);
    }

    public final void bJB() {
        AppMethodBeat.i(126312);
        if (this.GoU != null) {
            this.GoU.stopTimer();
            this.GoU.startTimer(2000);
        }
        AppMethodBeat.o(126312);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public int getBarPointWidth() {
        AppMethodBeat.i(126313);
        int width = this.mCO.getWidth();
        AppMethodBeat.o(126313);
        return width;
    }

    public void setShareBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(126314);
        this.GoE.setOnClickListener(onClickListener);
        AppMethodBeat.o(126314);
    }

    public void setTagBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(126315);
        this.GoN.setOnClickListener(onClickListener);
        this.GoO.setOnClickListener(onClickListener);
        AppMethodBeat.o(126315);
    }

    public void setWowBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(126316);
        this.GoF.setVisibility(0);
        this.GoF.setOnClickListener(onClickListener);
        AppMethodBeat.o(126316);
    }

    public void setSourceItemClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(126317);
        if (this.xYx != null) {
            this.xYx.setOnClickListener(onClickListener);
        }
        if (this.GmA != null) {
            this.GmA.setOnClickListener(onClickListener);
        }
        if (this.GoT != null) {
            this.GoT.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(126317);
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(126318);
        this.titleTv.setOnClickListener(onClickListener);
        AppMethodBeat.o(126318);
    }

    public final void fzM() {
        AppMethodBeat.i(126319);
        this.mCP.setVisibility(8);
        AppMethodBeat.o(126319);
    }

    public final void fzN() {
        AppMethodBeat.i(126320);
        this.mCP.setVisibility(0);
        AppMethodBeat.o(126320);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public final void bKO() {
        AppMethodBeat.i(126321);
        super.bKO();
        if (!(this.GoV == null || this.GjK == null)) {
            this.GoV.b(this.GjK, this.mPosition, getVideoTotalTime());
        }
        AppMethodBeat.o(126321);
    }

    public void setOnUpdateProgressLenListener(a aVar) {
        this.GoV = aVar;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(126322);
        super.setVisibility(i2);
        if (i2 == 8 || i2 == 4) {
            if (this.GoV != null) {
                this.GoV.fzL();
                AppMethodBeat.o(126322);
                return;
            }
        } else if (i2 == 0 && this.GoV != null) {
            this.GoV.fzK();
        }
        AppMethodBeat.o(126322);
    }

    public void setOnlyFS(boolean z) {
        this.GoW = z;
    }

    public View getWowView() {
        return this.GoF;
    }
}
