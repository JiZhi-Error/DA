package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.Cdo;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameRecomBlockView extends LinearLayout implements View.OnClickListener {
    private ViewGroup mContainer = this;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int xGR;

    public GameRecomBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42348);
        setOrientation(1);
        this.mContext = context;
        AppMethodBeat.o(42348);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42349);
        super.onFinishInflate();
        Log.i("MicroMsg.GameRecomBlockView", "initView finished");
        AppMethodBeat.o(42349);
    }

    /* access modifiers changed from: package-private */
    public final void a(as asVar, int i2, int i3) {
        AppMethodBeat.i(42350);
        this.mContainer.removeAllViews();
        if (Util.isNullOrNil(asVar.xKD)) {
            setVisibility(8);
            AppMethodBeat.o(42350);
            return;
        }
        if (i2 == 2) {
            com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1021, 0, null, i3, com.tencent.mm.plugin.game.d.a.Fh(asVar.xJt));
        }
        this.mInflater.inflate(R.layout.aoy, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.gvh);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.gve);
        View findViewById = findViewById(R.id.gvi);
        TextView textView2 = (TextView) findViewById(R.id.gvj);
        if (!Util.isNullOrNil(asVar.xJu)) {
            textView.setText(asVar.xJu);
        } else {
            textView.setVisibility(8);
        }
        if (!Util.isNullOrNil(asVar.xKE)) {
            textView2.setText(asVar.xKE);
        } else {
            textView2.setVisibility(8);
        }
        findViewById.setTag(new a(null, 999, asVar.xKF, asVar.xJt, "game_center_mygame_more"));
        findViewById.setOnClickListener(this);
        int i4 = 0;
        for (int i5 = 0; i5 < asVar.xKD.size(); i5++) {
            Cdo doVar = asVar.xKD.get(i5);
            if (doVar != null) {
                if (linearLayout.getChildCount() < 3) {
                    i4++;
                    LinearLayout linearLayout2 = (LinearLayout) this.mInflater.inflate(R.layout.aoz, (ViewGroup) this, false);
                    linearLayout2.setTag(new a(doVar.jfi, i4, doVar.xIy, doVar.xJt, "game_center_mygame_rank"));
                    linearLayout2.setOnClickListener(this);
                    linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2, 1.0f));
                    TextView textView3 = (TextView) linearLayout2.findViewById(R.id.gvg);
                    ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.gvd);
                    TextView textView4 = (TextView) linearLayout2.findViewById(R.id.gvf);
                    TextView textView5 = (TextView) linearLayout2.findViewById(R.id.gvc);
                    switch (i5) {
                        case 0:
                            textView3.setTextColor(this.mContext.getResources().getColor(R.color.sp));
                            break;
                        case 1:
                            textView3.setTextColor(this.mContext.getResources().getColor(R.color.sq));
                            break;
                        case 2:
                            textView3.setTextColor(this.mContext.getResources().getColor(R.color.sr));
                            break;
                    }
                    textView3.setText(doVar.Title);
                    e.dWR().o(imageView, doVar.xIx);
                    textView4.setText(doVar.xMq);
                    if (!Util.isNullOrNil(doVar.Desc)) {
                        textView5.setText(doVar.Desc);
                    } else {
                        textView5.setVisibility(8);
                    }
                    if (i2 == 2) {
                        com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1021, i4, doVar.jfi, i3, com.tencent.mm.plugin.game.d.a.Fh(doVar.xJt));
                    }
                } else {
                    View view = new View(getContext());
                    view.setBackgroundColor(getContext().getResources().getColor(R.color.s8));
                    addView(view, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5)));
                    AppMethodBeat.o(42350);
                }
            }
        }
        View view2 = new View(getContext());
        view2.setBackgroundColor(getContext().getResources().getColor(R.color.s8));
        addView(view2, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5)));
        AppMethodBeat.o(42350);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42351);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            Log.w("MicroMsg.GameRecomBlockView", "getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42351);
            return;
        }
        a aVar = (a) view.getTag();
        if (Util.isNullOrNil(aVar.jumpUrl)) {
            Log.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42351);
            return;
        }
        f.a(this.mContext, 10, 1021, aVar.xHK, c.D(this.mContext, aVar.jumpUrl, aVar.eam), aVar.appId, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(aVar.xEl));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42351);
    }

    static class a {
        public String appId;
        public String eam;
        public String jumpUrl;
        public String xEl;
        public int xHK;

        public a(String str, int i2, String str2, String str3, String str4) {
            this.appId = str;
            this.xHK = i2;
            this.jumpUrl = str2;
            this.xEl = str3;
            this.eam = str4;
        }
    }
}
