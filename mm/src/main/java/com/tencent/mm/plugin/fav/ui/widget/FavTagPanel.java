package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTagPanel;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    private LinkedList<MMTagPanel.d> tmP = new LinkedList<>();
    private a tmQ = null;
    private View.OnClickListener tmR = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.AnonymousClass1 */

        public final void onClick(final View view) {
            AppMethodBeat.i(107554);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (((Integer) view.getTag()).intValue() == 0) {
                FavTagPanel.a(FavTagPanel.this, (TextView) view);
                if (FavTagPanel.this.tmQ != null) {
                    view.post(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(107552);
                            a unused = FavTagPanel.this.tmQ;
                            ((TextView) view).getText().toString();
                            AppMethodBeat.o(107552);
                        }
                    });
                }
            } else {
                FavTagPanel.b(FavTagPanel.this, (TextView) view);
                if (FavTagPanel.this.tmQ != null) {
                    view.post(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(107553);
                            FavTagPanel.this.tmQ.asx(((TextView) view).getText().toString());
                            AppMethodBeat.o(107553);
                        }
                    });
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107554);
        }
    };

    public interface a extends MMTagPanel.a {
        void asx(String str);
    }

    static /* synthetic */ void a(FavTagPanel favTagPanel, TextView textView) {
        AppMethodBeat.i(107559);
        favTagPanel.a(textView, true, false);
        AppMethodBeat.o(107559);
    }

    static /* synthetic */ void b(FavTagPanel favTagPanel, TextView textView) {
        AppMethodBeat.i(107560);
        favTagPanel.a(textView, false, false);
        AppMethodBeat.o(107560);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(107555);
        AppMethodBeat.o(107555);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107556);
        AppMethodBeat.o(107556);
    }

    public void setCallBack(a aVar) {
        AppMethodBeat.i(107557);
        this.tmQ = aVar;
        super.setCallBack((MMTagPanel.a) aVar);
        AppMethodBeat.o(107557);
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel
    public final void cWT() {
    }

    public void setType(String str) {
        AppMethodBeat.i(107558);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
            AppMethodBeat.o(107558);
            return;
        }
        String trim = str.trim();
        Iterator<MMTagPanel.d> it = this.tmP.iterator();
        while (it.hasNext()) {
            if (trim.equals(it.next().OTF)) {
                Log.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", trim);
                AppMethodBeat.o(107558);
                return;
            }
        }
        this.tmP.clear();
        MMTagPanel.d gLf = gLf();
        this.tmP.add(gLf);
        a(gLf, trim, true);
        gLf.OTG.setOnClickListener(this.tmR);
        removeViews(0, getChildCount() - 1);
        addView(gLf.OTG, 0);
        gLg();
        AppMethodBeat.o(107558);
    }
}
