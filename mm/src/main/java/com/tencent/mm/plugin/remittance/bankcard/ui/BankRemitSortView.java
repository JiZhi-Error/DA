package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView extends BaseSortView {
    private final String TAG = "MicroMsg.BankcardSortView";
    private ListView pqt;

    public BankRemitSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View inflate() {
        AppMethodBeat.i(67612);
        View inflate = View.inflate(getContext(), R.layout.iq, this);
        AppMethodBeat.o(67612);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(67613);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.hrg);
        AppMethodBeat.o(67613);
        return verticalScrollBar;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public ListView getListView() {
        AppMethodBeat.i(67614);
        this.pqt = (ListView) findViewById(R.id.ed2);
        ListView listView = this.pqt;
        AppMethodBeat.o(67614);
        return listView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public View getNoResultView() {
        return null;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final boolean a(String str, d dVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public c.a getItemViewCreator() {
        AppMethodBeat.i(67615);
        AnonymousClass1 r0 = new c.a() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.sortview.c.a
            public final View a(d dVar, View view, int i2, boolean z, boolean z2) {
                AppMethodBeat.i(67611);
                Context context = BankRemitSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.ip, (ViewGroup) null);
                    a aVar = new a(BankRemitSortView.this, (byte) 0);
                    aVar.ClO = (TextView) view.findViewById(R.id.apx);
                    aVar.Cjs = (TextView) view.findViewById(R.id.ae0);
                    aVar.Cjq = (CdnImageView) view.findViewById(R.id.adz);
                    view.setTag(aVar);
                }
                a aVar2 = (a) view.getTag();
                jg jgVar = (jg) dVar.data;
                if (jgVar != null) {
                    if (!BankRemitSortView.this.OZW || !z) {
                        aVar2.ClO.setVisibility(8);
                    } else {
                        if (dVar.Pae.equals("☆")) {
                            aVar2.ClO.setText(R.string.ac1);
                        } else {
                            aVar2.ClO.setText(dVar.Pae);
                        }
                        aVar2.ClO.setVisibility(0);
                    }
                    aVar2.Cjq.setUseSdcardCache(true);
                    aVar2.Cjq.mB(jgVar.CiX, b.aKj(jgVar.CiX));
                    aVar2.Cjs.setText(jgVar.ynT);
                } else {
                    Log.w("MicroMsg.BankcardSortView", "elem is null: %s", Integer.valueOf(i2));
                }
                AppMethodBeat.o(67611);
                return view;
            }
        };
        AppMethodBeat.o(67615);
        return r0;
    }

    class a {
        CdnImageView Cjq;
        TextView Cjs;
        TextView ClO;

        private a() {
        }

        /* synthetic */ a(BankRemitSortView bankRemitSortView, byte b2) {
            this();
        }
    }
}
