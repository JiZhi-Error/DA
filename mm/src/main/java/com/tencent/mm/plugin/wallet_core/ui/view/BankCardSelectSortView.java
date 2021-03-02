package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView extends BaseSortView {
    private ListView pqt;

    public static class a {
        public String AOj;
        public String ImL;
        public String icon;
        public String pinyin;
    }

    public BankCardSelectSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View inflate() {
        AppMethodBeat.i(71469);
        View inflate = View.inflate(getContext(), R.layout.iq, this);
        AppMethodBeat.o(71469);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(71470);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.hrg);
        AppMethodBeat.o(71470);
        return verticalScrollBar;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public ListView getListView() {
        AppMethodBeat.i(71471);
        this.pqt = (ListView) findViewById(R.id.ed2);
        ListView listView = this.pqt;
        AppMethodBeat.o(71471);
        return listView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public View getNoResultView() {
        AppMethodBeat.i(71472);
        View findViewById = findViewById(R.id.a1w);
        AppMethodBeat.o(71472);
        return findViewById;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public c.a getItemViewCreator() {
        AppMethodBeat.i(71474);
        AnonymousClass1 r0 = new c.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.sortview.c.a
            public final View a(d dVar, View view, int i2, boolean z, boolean z2) {
                AppMethodBeat.i(71468);
                Context context = BankCardSelectSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.ip, (ViewGroup) null);
                    b bVar = new b((byte) 0);
                    bVar.ClO = (TextView) view.findViewById(R.id.apx);
                    bVar.Cjs = (TextView) view.findViewById(R.id.ae0);
                    bVar.Cjq = (CdnImageView) view.findViewById(R.id.adz);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                if (!BankCardSelectSortView.this.OZW || !z) {
                    bVar2.ClO.setVisibility(8);
                } else {
                    bVar2.ClO.setText(dVar.Pae);
                    bVar2.ClO.setVisibility(0);
                }
                a aVar = (a) dVar.data;
                bVar2.Cjs.setText(aVar.AOj);
                if (!Util.isNullOrNil(aVar.icon)) {
                    bVar2.Cjq.setUseSdcardCache(true);
                    bVar2.Cjq.mB(aVar.icon, aVar.ImL);
                } else {
                    bVar2.Cjq.setImageBitmap(null);
                }
                AppMethodBeat.o(71468);
                return view;
            }
        };
        AppMethodBeat.o(71474);
        return r0;
    }

    static class b {
        CdnImageView Cjq;
        TextView Cjs;
        TextView ClO;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(71473);
        boolean contains = ((a) dVar.data).AOj.toUpperCase().contains(str.toUpperCase());
        AppMethodBeat.o(71473);
        return contains;
    }
}
