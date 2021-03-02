package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dpf;
import java.util.List;

public class FTSLocalPageRelevantView extends LinearLayout implements View.OnClickListener {
    private String hes = null;
    private String query = null;
    private b xeQ = null;
    private List<dpf> xeR = null;

    class a {
    }

    public interface b {
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnRelevantClickListener(b bVar) {
        this.xeQ = bVar;
    }

    public void onClick(View view) {
        AppMethodBeat.i(112264);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/FTSLocalPageRelevantView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(this.xeQ == null || view.getTag() == null || !(view.getTag() instanceof a))) {
            view.getTag();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/FTSLocalPageRelevantView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112264);
    }

    public String getSearchId() {
        return this.hes != null ? this.hes : "";
    }

    public String getWordList() {
        AppMethodBeat.i(112265);
        StringBuilder sb = new StringBuilder("");
        if (this.xeR != null) {
            for (dpf dpf : this.xeR) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(dpf.MGp);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(112265);
        return sb2;
    }

    public String getQuery() {
        return this.query != null ? this.query : "";
    }
}
