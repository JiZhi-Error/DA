package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends LinearLayout implements View.OnClickListener {
    private String mAppId;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int xGR;

    public e(Context context) {
        super(context);
        AppMethodBeat.i(41900);
        this.mContext = context;
        setOrientation(1);
        AppMethodBeat.o(41900);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0026 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.game.protobuf.aq r12, java.lang.String r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 418
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.e.a(com.tencent.mm.plugin.game.protobuf.aq, java.lang.String, int, int):void");
    }

    public final void onClick(View view) {
        AppMethodBeat.i(41902);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            Log.w("MicroMsg.GameBlockContentView", "getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41902);
            return;
        }
        a aVar = (a) view.getTag();
        if (Util.isNullOrNil(aVar.jumpUrl)) {
            Log.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41902);
            return;
        }
        f.a(this.mContext, 10, 1002, aVar.xHK, c.D(this.mContext, aVar.jumpUrl, "game_center_mygame_comm"), this.mAppId, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(aVar.xEl));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41902);
    }

    private void w(ViewGroup viewGroup) {
        AppMethodBeat.i(41903);
        ImageView imageView = (ImageView) this.mInflater.inflate(R.layout.aq2, viewGroup, false);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
        AppMethodBeat.o(41903);
    }

    static class a {
        public String jumpUrl;
        public String xEl;
        public int xHK;

        public a(int i2, String str, String str2) {
            this.xHK = i2;
            this.jumpUrl = str;
            this.xEl = str2;
        }
    }
}
