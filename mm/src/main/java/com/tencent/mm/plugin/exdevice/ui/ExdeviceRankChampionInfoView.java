package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private TextPaint ayn;
    private int huY = 0;
    private String mRa;
    private TextView qbV;
    private ImageView rEV;

    public void setAlpha(float f2) {
        AppMethodBeat.i(24182);
        this.qbV.setAlpha(f2);
        this.rEV.setAlpha(f2);
        AppMethodBeat.o(24182);
    }

    public ExdeviceRankChampionInfoView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(24183);
        View inflate = LayoutInflater.from(context).inflate(R.layout.a50, (ViewGroup) this, true);
        this.ayn = new TextPaint(1);
        this.qbV = (TextView) inflate.findViewById(R.id.ipp);
        this.rEV = (ImageView) inflate.findViewById(R.id.wn);
        this.rEV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(24180);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.isNullOrNil(ExdeviceRankChampionInfoView.this.mRa)) {
                    Log.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(24180);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra(ch.COL_USERNAME, ExdeviceRankChampionInfoView.this.mRa);
                Context context = context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24180);
            }
        });
        this.qbV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(24181);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.isNullOrNil(ExdeviceRankChampionInfoView.this.mRa)) {
                    Log.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(24181);
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra(ch.COL_USERNAME, ExdeviceRankChampionInfoView.this.mRa);
                Context context = context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankChampionInfoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24181);
            }
        });
        try {
            this.huY = context.getResources().getDimensionPixelSize(R.dimen.f11do);
            if (this.huY <= 0) {
                this.huY = 128;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e2, "", new Object[0]);
            if (this.huY <= 0) {
                this.huY = 128;
            }
        } catch (Throwable th) {
            if (this.huY <= 0) {
                this.huY = 128;
            }
            AppMethodBeat.o(24183);
            throw th;
        }
        Log.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", Integer.valueOf(this.huY));
        AppMethodBeat.o(24183);
    }

    public final void anT(String str) {
        AppMethodBeat.i(24184);
        this.mRa = str;
        if (this.qbV != null) {
            if (!Util.isNullOrNil(str)) {
                this.qbV.setVisibility(0);
                String string = getContext().getString(R.string.bz4, TextUtils.ellipsize(l.c(getContext(), aa.getDisplayName(this.mRa)), this.ayn, (float) this.huY, TextUtils.TruncateAt.END));
                Log.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", l.c(getContext(), string));
                this.qbV.setText(l.b(getContext(), string, this.qbV.getTextSize()));
            } else {
                this.qbV.setVisibility(8);
                this.qbV.setText("");
            }
        }
        if (this.rEV != null) {
            if (!Util.isNullOrNil(str)) {
                a.b.d(this.rEV, str);
                this.rEV.setVisibility(0);
                AppMethodBeat.o(24184);
                return;
            }
            this.rEV.setVisibility(4);
        }
        AppMethodBeat.o(24184);
    }
}
