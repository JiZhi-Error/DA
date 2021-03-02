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
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.fs.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class k extends e {
    public ImageView GmA;
    public View GoE;
    public View GoF;
    public ImageView GoG;
    public TextView GoH;
    public View GoT;
    public View Gpw;
    public View Gpx;
    public View Gpy;
    public TextView xYx;

    public k(Context context, b bVar, com.tencent.mm.plugin.topstory.ui.video.a aVar) {
        super(context, bVar, aVar);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f, com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final void init() {
        AppMethodBeat.i(126400);
        super.init();
        this.GoE = findViewById(R.id.hpi);
        this.Gpw = findViewById(R.id.fki);
        this.Gpx = findViewById(R.id.fk6);
        this.GoF = findViewById(R.id.jox);
        this.GoG = (ImageView) findViewById(R.id.jow);
        this.GoH = (TextView) findViewById(R.id.jov);
        this.Gpy = findViewById(R.id.i30);
        this.GmA = (ImageView) findViewById(R.id.i2z);
        this.xYx = (TextView) findViewById(R.id.i34);
        this.GoT = findViewById(R.id.i2y);
        this.Gpw.setOnClickListener(this.Goq);
        this.GoF.setOnClickListener(this.Gos);
        this.Gpy.setOnClickListener(this.Gou);
        this.GoE.setOnClickListener(this.Gor);
        AppMethodBeat.o(126400);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f, com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final i.e c(eiw eiw) {
        AppMethodBeat.i(126401);
        float jn = (float) com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
        float jo = (float) (com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 64));
        float f2 = jn / jo;
        float f3 = ((float) eiw.thumbWidth) / ((float) eiw.thumbHeight);
        Log.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(jn), Float.valueOf(jo));
        if (f2 <= f3) {
            i.e eVar = i.e.CONTAIN;
            AppMethodBeat.o(126401);
            return eVar;
        }
        i.e eVar2 = i.e.COVER;
        AppMethodBeat.o(126401);
        return eVar2;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f, com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final void updateView() {
        AppMethodBeat.i(126402);
        super.updateView();
        i.e c2 = c(this.GjH);
        ViewGroup.LayoutParams layoutParams = this.puw.getLayoutParams();
        if (c2 == i.e.CONTAIN) {
            layoutParams.width = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
            layoutParams.height = (int) (((float) layoutParams.width) / (((float) this.GjH.thumbWidth) / ((float) this.GjH.thumbHeight)));
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        this.puw.setLayoutParams(layoutParams);
        if (!(this.GoT == null || this.xYx == null || this.GmA == null)) {
            this.GoT.setVisibility(8);
            this.xYx.setVisibility(8);
            this.GmA.setVisibility(8);
            if (!Util.isNullOrNil(this.GjH.source)) {
                this.xYx.setText(this.GjH.source);
                this.xYx.setVisibility(0);
                if (n.i(this.GjH)) {
                    this.GoT.setVisibility(0);
                }
                if (!Util.isNullOrNil(this.GjH.MwR)) {
                    q.bcV().a(this.GjH.MwR, this.GmA, c.GjU);
                } else {
                    this.GmA.setImageResource(R.drawable.bca);
                }
                this.GmA.setVisibility(0);
            }
        }
        if (this.GlS.fyJ()) {
            this.Gpx.setVisibility(0);
            this.Gpw.setVisibility(0);
        } else {
            this.Gpx.setVisibility(8);
            this.Gpw.setVisibility(8);
        }
        fzI();
        AppMethodBeat.o(126402);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final void fzI() {
        AppMethodBeat.i(126403);
        if ((this.GjH.Nix & 128) > 0) {
            this.GoF.setVisibility(0);
            if (this.GjH.NiC) {
                this.GoG.setImageResource(R.raw.top_story_wow_selected);
                this.GoH.setTextColor(getResources().getColor(R.color.ac7));
            } else {
                this.GoG.setImageResource(R.raw.top_story_wow_unselected);
                this.GoH.setTextColor(getResources().getColor(R.color.ag2));
            }
            this.GoH.setText(c.abR(this.GjH.NiH));
            AppMethodBeat.o(126403);
            return;
        }
        this.GoF.setVisibility(8);
        AppMethodBeat.o(126403);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.f, com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final int getLayoutId() {
        return R.layout.c3s;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final void bIY() {
        AppMethodBeat.i(126404);
        this.Goo = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
        AppMethodBeat.o(126404);
    }

    public class a extends e.a {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.fs.e.a, com.tencent.mm.plugin.topstory.ui.video.c
        public final void bJl() {
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.fs.e.a, com.tencent.mm.plugin.topstory.ui.video.c
        public final int ce(float f2) {
            AppMethodBeat.i(126399);
            int currentPosition = getCurrentPosition();
            AppMethodBeat.o(126399);
            return currentPosition;
        }

        @Override // com.tencent.mm.plugin.topstory.ui.video.fs.e.a, com.tencent.mm.plugin.topstory.ui.video.c
        public final void abX(int i2) {
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.e
    public final boolean fzJ() {
        return true;
    }
}
