package com.tencent.mm.plugin.selectrecord.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class RecordSelectTipsBar extends LinearLayout {
    private LinearLayout CXl;
    private TextView CXm;
    private LinearLayout CXn;
    private TextView CXo;
    private TextView CXp;
    private TextView CXq;
    private boolean CXr = false;
    private a CXs = null;
    private FrameLayout gUY;

    public interface a {
        void eSC();

        void uo(boolean z);
    }

    public RecordSelectTipsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(187947);
        initView();
        AppMethodBeat.o(187947);
    }

    public RecordSelectTipsBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(187948);
        initView();
        AppMethodBeat.o(187948);
    }

    private void initView() {
        AppMethodBeat.i(187949);
        View inflate = inflate(getContext(), R.layout.blv, this);
        this.gUY = (FrameLayout) inflate.findViewById(R.id.h94);
        this.CXl = (LinearLayout) inflate.findViewById(R.id.dop);
        this.CXm = (TextView) inflate.findViewById(R.id.dzd);
        this.CXn = (LinearLayout) inflate.findViewById(R.id.i55);
        this.CXo = (TextView) inflate.findViewById(R.id.gxh);
        this.CXp = (TextView) inflate.findViewById(R.id.fb6);
        this.CXq = (TextView) inflate.findViewById(R.id.gxg);
        this.CXq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(187944);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.recordSelect.RecordSelectTipsBar", "clear all select record");
                if (RecordSelectTipsBar.this.CXs != null) {
                    com.tencent.mm.plugin.selectrecord.b.a.eSu().CWR++;
                    RecordSelectTipsBar.this.CXs.eSC();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187944);
            }
        });
        AppMethodBeat.o(187949);
    }

    public void setIRecordSelectCallback(a aVar) {
        this.CXs = aVar;
    }

    public final void Xl(final int i2) {
        AppMethodBeat.i(187950);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(187946);
                RecordSelectTipsBar.this.CXm.setVisibility(8);
                RecordSelectTipsBar.this.CXn.setVisibility(0);
                RecordSelectTipsBar.this.CXo.setText(MMApplicationContext.getContext().getString(R.string.gih, Integer.toString(i2)));
                if (i2 > 0) {
                    RecordSelectTipsBar.this.CXq.setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.iz));
                } else {
                    RecordSelectTipsBar.this.CXq.setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.uj));
                }
                if (i2 >= 99) {
                    RecordSelectTipsBar.this.CXp.setVisibility(0);
                    RecordSelectTipsBar.this.CXr = true;
                } else {
                    RecordSelectTipsBar.this.CXp.setVisibility(8);
                    RecordSelectTipsBar.this.CXr = false;
                }
                if (RecordSelectTipsBar.this.CXs != null) {
                    RecordSelectTipsBar.this.CXs.uo(RecordSelectTipsBar.this.CXr);
                }
                AppMethodBeat.o(187946);
            }
        });
        AppMethodBeat.o(187950);
    }
}
