package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ce.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyGrid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b extends a {
    private static final int owR = a.fromDPToPix(MMApplicationContext.getContext(), 48);
    private static final int owS = a.fromDPToPix(MMApplicationContext.getContext(), 43);

    static {
        AppMethodBeat.i(82337);
        AppMethodBeat.o(82337);
    }

    private int cci() {
        AppMethodBeat.i(82331);
        c cVar = this.JBa;
        if (cVar.oxi <= 1) {
            Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
            cVar.oxi = new int[]{defaultDisplay.getWidth(), defaultDisplay.getHeight()}[0];
        }
        int i2 = cVar.oxi;
        AppMethodBeat.o(82331);
        return i2;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final int ccg() {
        AppMethodBeat.i(82333);
        int cch = cch() * getRowCount();
        AppMethodBeat.o(82333);
        return cch;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final int getPageCount() {
        AppMethodBeat.i(82334);
        if (ccg() <= 0) {
            AppMethodBeat.o(82334);
            return 0;
        }
        int ceil = (int) Math.ceil(((double) e.gxR().cca()) / ((double) ccg()));
        AppMethodBeat.o(82334);
        return ceil;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final int cch() {
        AppMethodBeat.i(82335);
        if (this.JBa.oxd) {
            AppMethodBeat.o(82335);
            return 7;
        }
        int cci = cci() / owS;
        AppMethodBeat.o(82335);
        return cci;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final int getRowCount() {
        int i2 = 3;
        int i3 = this.JBa.oxh / owR;
        if (i3 <= 3) {
            i2 = i3;
        }
        if (i2 <= 0) {
            return 1;
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final View Ap(int i2) {
        View view = null;
        AppMethodBeat.i(82330);
        Context context = this.owO;
        c cVar = this.JBa;
        d dVar = new d();
        dVar.mIndex = i2;
        dVar.JBi = this;
        dVar.mContext = context;
        dVar.JBa = cVar;
        if (dVar.mContext == null || dVar.JBi == null) {
            AppMethodBeat.o(82330);
        } else {
            view = View.inflate(dVar.mContext, R.layout.cbz, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).setPanelManager(dVar.JBa);
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i3 = dVar.mIndex;
                int ccf = dVar.JBi.ccf();
                int ccg = dVar.JBi.ccg();
                int cch = dVar.JBi.cch();
                int rowCount = dVar.JBi.getRowCount();
                int rowSpacing = dVar.JBi.getRowSpacing();
                webViewSmileyGrid.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.awr);
                webViewSmileyGrid.owW = i3;
                webViewSmileyGrid.owU = ccf;
                webViewSmileyGrid.owV = ccg;
                webViewSmileyGrid.owX = rowSpacing;
                webViewSmileyGrid.owY = cch;
                webViewSmileyGrid.gOF = rowCount;
                webViewSmileyGrid.setNumColumns(cch);
                int rowSpacing2 = webViewSmileyGrid.getRowSpacing();
                int fromDPToPix = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                int fromDPToPix2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (rowSpacing2 == 0) {
                    rowSpacing2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(fromDPToPix, rowSpacing2, fromDPToPix2, 0);
                webViewSmileyGrid.JBb = new WebViewSmileyGrid.a(webViewSmileyGrid, (byte) 0);
                webViewSmileyGrid.setAdapter((ListAdapter) webViewSmileyGrid.JBb);
                webViewSmileyGrid.JBb.notifyDataSetChanged();
            }
            AppMethodBeat.o(82330);
        }
        return view;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final int ccf() {
        AppMethodBeat.i(82332);
        int cca = e.gxR().cca();
        AppMethodBeat.o(82332);
        return cca;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.a
    public final int getRowSpacing() {
        AppMethodBeat.i(82336);
        int rowCount = (this.JBa.oxh - (owR * getRowCount())) / (getRowCount() + 1);
        AppMethodBeat.o(82336);
        return rowCount;
    }
}
