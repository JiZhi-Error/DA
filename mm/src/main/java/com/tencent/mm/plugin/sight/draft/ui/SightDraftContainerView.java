package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.plugin.sight.draft.ui.b;

public class SightDraftContainerView extends ListView {
    private boolean DoG;
    private a DoH;
    b DoI;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(28686);
        init();
        AppMethodBeat.o(28686);
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28687);
        init();
        AppMethodBeat.o(28687);
    }

    public SightDraftContainerView(Context context) {
        super(context);
        AppMethodBeat.i(28688);
        init();
        AppMethodBeat.o(28688);
    }

    private void init() {
        AppMethodBeat.i(28689);
        setBackgroundColor(getResources().getColor(R.color.fm));
        setSelector(R.color.ac_);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.k5);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.hs);
        TextView textView = new TextView(getContext());
        textView.setText(R.string.h25);
        textView.setTextSize(0, (float) a.aG(getContext(), R.dimen.hc));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R.color.uk));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(28685);
                SightDraftContainerView sightDraftContainerView = SightDraftContainerView.this;
                if (sightDraftContainerView.DoI != null) {
                    b bVar = sightDraftContainerView.DoI;
                    bVar.a((b.e) null);
                    bVar.Dom.eVV();
                }
                AppMethodBeat.o(28685);
                return false;
            }
        });
        AppMethodBeat.o(28689);
    }

    public void setTipsResId(int i2) {
        if (this.DoI != null) {
            this.DoI.Dos = i2;
        }
    }

    public final void eVW() {
        AppMethodBeat.i(28690);
        if (this.DoG) {
            this.DoI.Dot = 12;
            this.DoI.a(b.d.NORMAL, false);
            this.DoI.onNotifyChange(null, null);
            setSelection(0);
            AppMethodBeat.o(28690);
            return;
        }
        this.DoG = true;
        this.DoI = new b(getContext(), this.DoH);
        this.DoI.Dot = 12;
        setAdapter((ListAdapter) this.DoI);
        AppMethodBeat.o(28690);
    }

    public void setSightDraftCallback(a aVar) {
        this.DoH = aVar;
        if (this.DoI != null) {
            this.DoI.Dor = aVar;
        }
    }

    public j getLastDrafInfo() {
        b bVar = this.DoI;
        if (bVar.Dox == null) {
            return null;
        }
        return bVar.Dox.DoE;
    }
}
