package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d extends a {
    private View qlD;
    private TextView qlE;
    private TextView qlF;
    private View qlG;
    private TextView qlH;
    private TextView qlI;
    private View qlJ;
    private View qlK;
    private View qlL;

    public d(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxM() {
        AppMethodBeat.i(113904);
        this.qlD = this.qlr.findViewById(R.id.g9o);
        this.qlE = (TextView) this.qlr.findViewById(R.id.g9q);
        this.qlF = (TextView) this.qlr.findViewById(R.id.g9p);
        this.qlG = this.qlr.findViewById(R.id.a3k);
        this.qlH = (TextView) this.qlr.findViewById(R.id.a3m);
        this.qlI = (TextView) this.qlr.findViewById(R.id.a3l);
        this.qlK = this.qlr.findViewById(R.id.apu);
        this.qlL = this.qlr.findViewById(R.id.akr);
        AppMethodBeat.o(113904);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxN() {
        abz abz;
        AppMethodBeat.i(113905);
        if (this.pQV.csQ().LeC == null || this.pQV.csQ().LeC.size() <= 0) {
            Log.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList<abz> linkedList = this.pQV.csQ().LeC;
            abz abz2 = null;
            if (linkedList.size() == 1) {
                abz = linkedList.get(0);
            } else {
                abz = linkedList.get(0);
                abz2 = linkedList.get(1);
            }
            if (abz != null) {
                this.qlD.setVisibility(0);
                this.qlE.setText(abz.title);
                this.qlF.setText(abz.pRY);
                if (!TextUtils.isEmpty(abz.LfE)) {
                    this.qlE.setTextColor(l.ake(abz.LfE));
                }
                if (!TextUtils.isEmpty(abz.LfF)) {
                    this.qlF.setTextColor(l.ake(abz.LfF));
                }
            }
            if (abz2 != null) {
                this.qlG.setVisibility(0);
                this.qlH.setText(abz2.title);
                this.qlI.setText(abz2.pRY);
                if (!TextUtils.isEmpty(abz2.LfE)) {
                    this.qlH.setTextColor(l.ake(abz2.LfE));
                }
                if (!TextUtils.isEmpty(abz2.LfF)) {
                    this.qlI.setTextColor(l.ake(abz2.LfF));
                }
            }
        }
        if (this.pQV.csv() && !this.pQV.csB()) {
            Log.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.pQV.csR().Lcs == null || this.pQV.csR().Lcs.size() <= 0) {
            if (this.qlJ != null) {
                this.qlJ.setVisibility(8);
            }
            this.qlr.findViewById(R.id.akr).setVisibility(8);
        } else {
            if (this.qlJ == null) {
                this.qlJ = ((ViewStub) this.qlr.findViewById(R.id.aow)).inflate();
            }
            this.qlr.findViewById(R.id.akr).setVisibility(8);
            View view = this.qlJ;
            b bVar = this.pQV;
            View.OnClickListener onClickListener = this.kuO;
            LinkedList<abz> linkedList2 = bVar.csR().Lcs;
            if (linkedList2.size() == 1) {
                view.findViewById(R.id.ap0).setVisibility(0);
                abz abz3 = linkedList2.get(0);
                ((TextView) view.findViewById(R.id.hfm)).setText(abz3.title);
                ((TextView) view.findViewById(R.id.hfj)).setText(abz3.pRY);
                view.findViewById(R.id.ap0).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(abz3.LfE)) {
                    ((TextView) view.findViewById(R.id.hfm)).setTextColor(l.ake(abz3.LfE));
                }
                if (!TextUtils.isEmpty(abz3.LfF)) {
                    ((TextView) view.findViewById(R.id.hfj)).setTextColor(l.ake(abz3.LfF));
                }
                view.findViewById(R.id.ap1).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                abz abz4 = linkedList2.get(0);
                ((TextView) view.findViewById(R.id.hfm)).setText(abz4.title);
                ((TextView) view.findViewById(R.id.hfj)).setText(abz4.pRY);
                if (!TextUtils.isEmpty(abz4.LfE)) {
                    ((TextView) view.findViewById(R.id.hfm)).setTextColor(l.ake(abz4.LfE));
                }
                if (!TextUtils.isEmpty(abz4.LfF)) {
                    ((TextView) view.findViewById(R.id.hfj)).setTextColor(l.ake(abz4.LfF));
                }
                abz abz5 = linkedList2.get(1);
                ((TextView) view.findViewById(R.id.hfn)).setText(abz5.title);
                ((TextView) view.findViewById(R.id.hfk)).setText(abz5.pRY);
                if (!TextUtils.isEmpty(abz5.LfE)) {
                    ((TextView) view.findViewById(R.id.hfn)).setTextColor(l.ake(abz5.LfE));
                }
                if (!TextUtils.isEmpty(abz5.LfF)) {
                    ((TextView) view.findViewById(R.id.hfk)).setTextColor(l.ake(abz5.LfF));
                }
                view.findViewById(R.id.ap0).setOnClickListener(onClickListener);
                view.findViewById(R.id.ap1).setOnClickListener(onClickListener);
            }
        }
        if (this.pQV.csM()) {
            this.qlK.setVisibility(8);
        } else {
            this.qlK.setVisibility(0);
            TextView textView = (TextView) this.qlK.findViewById(R.id.ap9);
            if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
                textView.setText(this.pQV.csQ().LeY);
            } else {
                n.h(textView, this.pQV.csR().status);
            }
        }
        if (this.pQV.csR().LcB != null || !this.pQV.csM()) {
            this.qlL.setVisibility(8);
            AppMethodBeat.o(113905);
            return;
        }
        this.qlL.setVisibility(0);
        AppMethodBeat.o(113905);
    }
}
