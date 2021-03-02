package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class x {
    private ChatFooterCustom Pgh;
    private FrameLayout Pgi;
    private View.OnClickListener ko = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.x.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(34687);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.pl(1);
            ab.IU("gh_43f2581f6fd6");
            Intent intent = new Intent();
            intent.putExtra("key_is_latest", true);
            intent.putExtra("rank_id", "#");
            intent.putExtra("key_only_show_latest_rank", true);
            intent.putExtra("app_username", aa.getDisplayName("gh_43f2581f6fd6"));
            intent.putExtra("device_type", 1);
            com.tencent.mm.br.c.b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
            a.a(this, "com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34687);
        }
    };
    private LinearLayout rmL;

    public x(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(34688);
        this.Pgh = chatFooterCustom;
        AppMethodBeat.o(34688);
    }

    public final void gKK() {
        AppMethodBeat.i(34689);
        Log.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.Pgh.findViewById(R.id.avb).setVisibility(8);
        this.Pgh.findViewById(R.id.av6).setVisibility(8);
        this.rmL = (LinearLayout) this.Pgh.findViewById(R.id.av7);
        this.rmL.setWeightSum(1.0f);
        this.Pgi = (FrameLayout) this.rmL.getChildAt(0);
        this.Pgi.setVisibility(0);
        this.Pgi.setOnClickListener(this.ko);
        ((TextView) this.Pgi.findViewById(R.id.av9)).setText(R.string.c28);
        this.Pgi.findViewById(R.id.av8).setVisibility(8);
        for (int i2 = 1; i2 < 6; i2++) {
            this.rmL.getChildAt(i2).setVisibility(8);
        }
        AppMethodBeat.o(34689);
    }
}
