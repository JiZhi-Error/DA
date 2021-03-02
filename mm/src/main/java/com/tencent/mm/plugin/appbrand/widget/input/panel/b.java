package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b extends a {
    private static final int owR = a.fromDPToPix(MMApplicationContext.getContext(), 48);
    private static final int owS = a.fromDPToPix(MMApplicationContext.getContext(), 43);

    static {
        AppMethodBeat.i(49928);
        AppMethodBeat.o(49928);
    }

    private int cci() {
        AppMethodBeat.i(49922);
        c cVar = this.owP;
        if (cVar.oxi <= 1) {
            cVar.oxi = c.ccp()[0];
        }
        int i2 = cVar.oxi;
        AppMethodBeat.o(49922);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final int ccf() {
        AppMethodBeat.i(49923);
        int cca = this.owP.cbY().cca();
        AppMethodBeat.o(49923);
        return cca;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final int ccg() {
        AppMethodBeat.i(49924);
        int cch = cch() * getRowCount();
        AppMethodBeat.o(49924);
        return cch;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final int getPageCount() {
        AppMethodBeat.i(49925);
        if (ccg() <= 0) {
            AppMethodBeat.o(49925);
            return 0;
        }
        int ceil = (int) Math.ceil(((double) ccf()) / ((double) ccg()));
        AppMethodBeat.o(49925);
        return ceil;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final int cch() {
        AppMethodBeat.i(49926);
        if (this.owP.oxd) {
            AppMethodBeat.o(49926);
            return 7;
        }
        int cci = cci() / owS;
        AppMethodBeat.o(49926);
        return cci;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final int getRowCount() {
        int i2 = 3;
        int i3 = this.owP.oxh / owR;
        if (i3 <= 3) {
            i2 = i3;
        }
        if (i2 <= 0) {
            return 1;
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final View Ap(int i2) {
        View view = null;
        AppMethodBeat.i(49921);
        Context context = this.owO;
        c cVar = this.owP;
        d dVar = new d();
        dVar.mIndex = i2;
        dVar.oxj = this;
        dVar.mContext = context;
        dVar.owP = cVar;
        if (dVar.mContext == null || dVar.oxj == null) {
            AppMethodBeat.o(49921);
        } else {
            view = View.inflate(dVar.mContext, R.layout.h0, null);
            if (view instanceof AppBrandSmileyGrid) {
                ((AppBrandSmileyGrid) view).setPanelManager(dVar.owP);
                AppBrandSmileyGrid appBrandSmileyGrid = (AppBrandSmileyGrid) view;
                int i3 = dVar.mIndex;
                int ccf = dVar.oxj.ccf();
                int ccg = dVar.oxj.ccg();
                int cch = dVar.oxj.cch();
                int rowCount = dVar.oxj.getRowCount();
                int rowSpacing = dVar.oxj.getRowSpacing();
                appBrandSmileyGrid.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                appBrandSmileyGrid.setBackgroundResource(0);
                appBrandSmileyGrid.setStretchMode(2);
                appBrandSmileyGrid.setOnItemClickListener(appBrandSmileyGrid.awr);
                appBrandSmileyGrid.owW = i3;
                appBrandSmileyGrid.owU = ccf;
                appBrandSmileyGrid.owV = ccg;
                appBrandSmileyGrid.owX = rowSpacing;
                appBrandSmileyGrid.owY = cch;
                appBrandSmileyGrid.gOF = rowCount;
                appBrandSmileyGrid.setNumColumns(cch);
                int rowSpacing2 = appBrandSmileyGrid.getRowSpacing();
                int fromDPToPix = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                int fromDPToPix2 = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                if (rowSpacing2 == 0) {
                    rowSpacing2 = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                }
                appBrandSmileyGrid.setPadding(fromDPToPix, rowSpacing2, fromDPToPix2, 0);
                appBrandSmileyGrid.owT = new AppBrandSmileyGrid.a(appBrandSmileyGrid, (byte) 0);
                appBrandSmileyGrid.setAdapter((ListAdapter) appBrandSmileyGrid.owT);
                appBrandSmileyGrid.owT.notifyDataSetChanged();
            }
            AppMethodBeat.o(49921);
        }
        return view;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.a
    public final int getRowSpacing() {
        AppMethodBeat.i(49927);
        int rowCount = (this.owP.oxh - (owR * getRowCount())) / (getRowCount() + 1);
        AppMethodBeat.o(49927);
        return rowCount;
    }
}
