package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel;
import com.tencent.mm.ui.aa;

public class WebViewSmileyGrid extends GridView {
    private c JBa;
    a JBb;
    AdapterView.OnItemClickListener awr = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(82338);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (i2 == WebViewSmileyGrid.this.JBb.getCount() - 1) {
                if (WebViewSmileyGrid.this.JBa.JBh != null) {
                    WebViewSmileyGrid.this.JBa.JBh.aHC();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(82338);
            } else if ((WebViewSmileyGrid.this.owW * (WebViewSmileyGrid.this.owV - 1)) + i2 >= WebViewSmileyGrid.this.owU) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(82338);
            } else {
                int i3 = (WebViewSmileyGrid.this.owW * (WebViewSmileyGrid.this.owV - 1)) + i2;
                if (WebViewSmileyGrid.this.JBa.JBh != null) {
                    WebViewSmileyPanel.a aVar = WebViewSmileyGrid.this.JBa.JBh;
                    c unused = WebViewSmileyGrid.this.JBa;
                    aVar.append(e.gxR().An(i3));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/input/WebViewSmileyGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(82338);
            }
        }
    };
    int gOF = 0;
    int owU;
    int owV = 0;
    int owW;
    int owX = 0;
    int owY = 0;

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(82342);
        AppMethodBeat.o(82342);
    }

    /* access modifiers changed from: package-private */
    public int getRowSpacing() {
        return this.owX;
    }

    public void setPanelManager(c cVar) {
        this.JBa = cVar;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WebViewSmileyGrid webViewSmileyGrid, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(82339);
            int i2 = WebViewSmileyGrid.this.owV;
            AppMethodBeat.o(82339);
            return i2;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(82340);
            if (view == null || view.getTag() == null) {
                view = aa.jQ(WebViewSmileyGrid.this.getContext()).inflate(R.layout.cbx, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, ((WebViewSmileyGrid.this.JBa.oxh - com.tencent.mm.cb.a.aG(WebViewSmileyGrid.this.getContext(), R.dimen.i2)) - com.tencent.mm.cb.a.aG(WebViewSmileyGrid.this.getContext(), R.dimen.a35)) / WebViewSmileyGrid.this.gOF));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i2 == getCount() - 1) {
                bVar.nnL.setImageResource(R.drawable.rg);
                bVar.nnL.setContentDescription(WebViewSmileyGrid.this.getContext().getString(R.string.bld));
            } else {
                int i3 = ((WebViewSmileyGrid.this.owV - 1) * WebViewSmileyGrid.this.owW) + i2;
                if (i3 > WebViewSmileyGrid.this.owU - 1) {
                    bVar.nnL.setImageDrawable(null);
                } else {
                    c unused = WebViewSmileyGrid.this.JBa;
                    bVar.nnL.setImageDrawable(e.gxR().Al(i3));
                }
            }
            AppMethodBeat.o(82340);
            return view;
        }
    }

    static final class b {
        ImageView nnL;

        public b(View view) {
            AppMethodBeat.i(82341);
            this.nnL = (ImageView) view.findViewById(R.id.ur);
            AppMethodBeat.o(82341);
        }
    }
}
