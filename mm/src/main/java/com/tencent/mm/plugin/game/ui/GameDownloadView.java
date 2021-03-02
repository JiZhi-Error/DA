package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameDownloadView extends FrameLayout implements View.OnClickListener {
    private k.a xQH = new k.a() {
        /* class com.tencent.mm.plugin.game.ui.GameDownloadView.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.game.model.k.a
        public final void e(int i2, String str, boolean z) {
            AppMethodBeat.i(42065);
            if (!z || Util.isNullOrNil(str)) {
                AppMethodBeat.o(42065);
            } else if (GameDownloadView.this.xQJ == null || GameDownloadView.this.xQJ.xEP == null || !GameDownloadView.this.xQJ.xEP.field_appId.equals(str)) {
                AppMethodBeat.o(42065);
            } else {
                GameDownloadView.this.refresh();
                AppMethodBeat.o(42065);
            }
        }
    };
    private l xQJ;
    private Button xRO;
    private TextProgressBar xRP;
    private d xRQ;

    static /* synthetic */ void a(GameDownloadView gameDownloadView) {
        AppMethodBeat.i(42074);
        gameDownloadView.dWo();
        AppMethodBeat.o(42074);
    }

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42066);
        AppMethodBeat.o(42066);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(42067);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aq4, (ViewGroup) this, true);
        this.xRO = (Button) inflate.findViewById(R.id.dfb);
        this.xRP = (TextProgressBar) inflate.findViewById(R.id.dfd);
        this.xRP.setTextSize(14);
        this.xRO.setOnClickListener(this);
        this.xRP.setOnClickListener(this);
        this.xRQ = new d(getContext());
        this.xRQ.xOA = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDownloadView.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(42062);
                GameDownloadView.a(GameDownloadView.this);
                AppMethodBeat.o(42062);
            }
        };
        AppMethodBeat.o(42067);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(42068);
        super.onDetachedFromWindow();
        k.b(this.xQH);
        AppMethodBeat.o(42068);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(42069);
        super.onAttachedToWindow();
        k.a(this.xQH);
        AppMethodBeat.o(42069);
    }

    public final void refresh() {
        AppMethodBeat.i(42070);
        if (this.xQJ != null) {
            this.xQJ.gi(MMApplicationContext.getContext());
            this.xQJ.cCq();
            dWo();
        }
        AppMethodBeat.o(42070);
    }

    public void setDownloadInfo(l lVar) {
        AppMethodBeat.i(42071);
        this.xQJ = lVar;
        c.cyh().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameDownloadView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(42063);
                GameDownloadView.this.xQJ.gi(MMApplicationContext.getContext());
                GameDownloadView.this.xQJ.cCq();
                GameDownloadView.a(GameDownloadView.this);
                AppMethodBeat.o(42063);
            }
        });
        dWo();
        AppMethodBeat.o(42071);
    }

    private void dWo() {
        AppMethodBeat.i(42072);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameDownloadView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(42064);
                GameDownloadView.this.xRQ.a(GameDownloadView.this.xRP, GameDownloadView.this.xRO, GameDownloadView.this.xQJ.xEP, GameDownloadView.this.xQJ);
                AppMethodBeat.o(42064);
            }
        });
        AppMethodBeat.o(42072);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42073);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameDownloadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.xQJ.gi(MMApplicationContext.getContext());
        this.xRQ.a(this.xQJ.xEP, this.xQJ);
        a.a(this, "com/tencent/mm/plugin/game/ui/GameDownloadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42073);
    }
}
