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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class i {
    private ChatFooterCustom Pgh;
    private FrameLayout Pgi;
    private View.OnClickListener ko = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.i.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(34384);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/ui/chatting/ChattingDownloaderFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((c) g.af(c.class)).a(view.getContext(), (Intent) null, (a.c) null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingDownloaderFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34384);
        }
    };
    private LinearLayout rmL;

    public i(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(34385);
        this.Pgh = chatFooterCustom;
        AppMethodBeat.o(34385);
    }

    public final void gKK() {
        AppMethodBeat.i(34386);
        Log.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
        this.Pgh.setVisibility(8);
        this.Pgh.findViewById(R.id.avb).setVisibility(8);
        this.Pgh.findViewById(R.id.av6).setVisibility(8);
        this.rmL = (LinearLayout) this.Pgh.findViewById(R.id.av7);
        this.rmL.setWeightSum(1.0f);
        this.Pgi = (FrameLayout) this.rmL.getChildAt(0);
        this.Pgi.setVisibility(0);
        this.Pgi.setOnClickListener(this.ko);
        ((TextView) this.Pgi.findViewById(R.id.av9)).setText(R.string.box);
        this.Pgi.findViewById(R.id.av8).setVisibility(8);
        for (int i2 = 1; i2 < 6; i2++) {
            this.rmL.getChildAt(i2).setVisibility(8);
        }
        AppMethodBeat.o(34386);
    }
}
