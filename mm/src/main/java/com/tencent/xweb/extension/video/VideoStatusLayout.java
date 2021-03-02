package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class VideoStatusLayout extends RelativeLayout {
    private VideoDotPercentIndicator SBe;
    private TextView SBf;
    private TextView SBg;
    private LinearLayout SBh;
    private a SBi;
    private int duration = 1000;
    private ImageView qbp;

    public VideoStatusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(153564);
        LayoutInflater.from(context).inflate(R.layout.bse, this);
        this.qbp = (ImageView) findViewById(R.id.dwt);
        this.SBe = (VideoDotPercentIndicator) findViewById(R.id.glq);
        this.SBf = (TextView) findViewById(R.id.iy_);
        this.SBg = (TextView) findViewById(R.id.ikv);
        this.SBh = (LinearLayout) findViewById(R.id.e_c);
        this.SBi = new a(this, (byte) 0);
        setVisibility(8);
        AppMethodBeat.o(153564);
    }

    public final void show() {
        AppMethodBeat.i(153565);
        setVisibility(0);
        removeCallbacks(this.SBi);
        postDelayed(this.SBi, (long) this.duration);
        AppMethodBeat.o(153565);
    }

    public void setVolumnProgress(int i2) {
        AppMethodBeat.i(153566);
        this.SBe.setProgress((float) i2);
        this.SBe.setVisibility(0);
        this.SBg.setText(R.string.j7o);
        this.SBh.setVisibility(0);
        this.qbp.setImageResource(R.drawable.b6z);
        this.SBf.setVisibility(8);
        AppMethodBeat.o(153566);
    }

    public void setBrightProgress(int i2) {
        AppMethodBeat.i(153567);
        this.SBe.setProgress((float) i2);
        this.SBe.setVisibility(0);
        this.SBg.setText(R.string.j7n);
        this.SBh.setVisibility(0);
        this.qbp.setImageResource(R.drawable.b6p);
        this.SBf.setVisibility(8);
        AppMethodBeat.o(153567);
    }

    public void setVideoTimeProgress(String str) {
        AppMethodBeat.i(153568);
        this.SBf.setText(str);
        this.SBf.setVisibility(0);
        this.SBh.setVisibility(8);
        AppMethodBeat.o(153568);
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(153569);
        this.qbp.setImageResource(i2);
        AppMethodBeat.o(153569);
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(VideoStatusLayout videoStatusLayout, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(153563);
            VideoStatusLayout.this.setVisibility(8);
            AppMethodBeat.o(153563);
        }
    }
}
