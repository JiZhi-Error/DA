package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class f extends LinearLayout implements View.OnClickListener {
    private String mAppId;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int xGR;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(41905);
        this.mContext = context;
        setOrientation(0);
        AppMethodBeat.o(41905);
    }

    public final void a(ar arVar, String str, int i2, int i3) {
        AppMethodBeat.i(41906);
        if (arVar == null || Util.isNullOrNil(arVar.xKD)) {
            setVisibility(8);
            AppMethodBeat.o(41906);
            return;
        }
        if (arVar.xKD.size() == 1) {
            arVar.xKD.add(null);
            arVar.xKD.add(null);
        } else if (arVar.xKD.size() == 2) {
            arVar.xKD.add(null);
        }
        this.mAppId = str;
        this.xGR = i3;
        Iterator<o> it = arVar.xKD.iterator();
        while (it.hasNext()) {
            o next = it.next();
            LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(R.layout.aov, (ViewGroup) this, false);
            addView(linearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0f));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.c4b);
            TextView textView = (TextView) linearLayout.findViewById(R.id.c4c);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.c4a);
            if (next == null) {
                imageView.setImageResource(R.drawable.bfy);
                textView.setText(R.string.dtd);
                textView.setTextColor(this.mContext.getResources().getColor(R.color.sy));
            } else {
                linearLayout.setOnClickListener(this);
                e.dWR().o(imageView, next.IconUrl);
                textView.setText(next.Title);
                if (!Util.isNullOrNil(next.Desc)) {
                    textView2.setText(next.Desc);
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
                linearLayout.setTag(next);
                if (i2 == 2) {
                    a.b(this.mContext, 10, 1002, next.xJv, str, i3, a.Fh(next.xJt));
                }
            }
        }
        AppMethodBeat.o(41906);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(41907);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof o)) {
            Log.w("MicroMsg.GameBlockEntranceView", "getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41907);
            return;
        }
        o oVar = (o) view.getTag();
        if (Util.isNullOrNil(oVar.xIy)) {
            Log.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41907);
            return;
        }
        com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, oVar.xJv, c.D(this.mContext, oVar.xIy, "game_center_mygame_comm"), this.mAppId, this.xGR, a.Fh(oVar.xJt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41907);
    }
}
