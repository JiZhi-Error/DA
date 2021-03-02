package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.Iterator;
import java.util.LinkedList;

public final class w extends i {
    private View qkt;
    private View qku;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113710);
        if (this.qkt != null) {
            this.qkt.setVisibility(8);
        }
        if (this.qku != null) {
            this.qku.setVisibility(8);
        }
        AppMethodBeat.o(113710);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113709);
        b cvq = this.qjX.cvq();
        g cvv = this.qjX.cvv();
        if (cvq.csR().Lcs != null && cvq.csR().Lcs.size() > 1) {
            if (this.qkt == null) {
                this.qkt = ((ViewStub) findViewById(R.id.aoy)).inflate();
            }
            if (this.qku != null) {
                this.qku.setVisibility(8);
            }
            MMActivity cvt = this.qjX.cvt();
            View view = this.qkt;
            View.OnClickListener cvu = this.qjX.cvu();
            LinkedList<abz> linkedList = cvq.csR().Lcs;
            int ake = l.ake(cvq.csQ().ixw);
            ((ViewGroup) view).removeAllViews();
            Iterator<abz> it = linkedList.iterator();
            while (it.hasNext()) {
                abz next = it.next();
                View inflate = aa.jQ(cvt).inflate(R.layout.oh, (ViewGroup) view, false);
                inflate.setId(R.id.aoz);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(next)));
                inflate.setOnClickListener(cvu);
                if (TextUtils.isEmpty(next.url) && Util.isNullOrNil(next.Leo)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(R.id.hfl)).setText(next.title);
                TextView textView = (TextView) inflate.findViewById(R.id.hfi);
                textView.setText(next.pRY);
                textView.setTextColor(ake);
                ((ViewGroup) view).addView(inflate);
                if (linkedList.indexOf(next) + 1 != linkedList.size()) {
                    ((ViewGroup) view).addView(aa.jQ(cvt).inflate(R.layout.oi, (ViewGroup) view, false));
                }
            }
            if (cvq.csx() && cvq.csR().Lcz != null && !TextUtils.isEmpty(cvq.csR().Lcz.title)) {
                this.qkt.setBackgroundResource(R.drawable.aij);
            }
            if (!cvq.csx() && cvv.cwK()) {
                this.qkt.setBackgroundResource(R.drawable.aij);
                AppMethodBeat.o(113709);
                return;
            }
        } else if (cvq.csR().Lcs == null || cvq.csR().Lcs.size() != 1) {
            if (this.qkt != null) {
                this.qkt.setVisibility(8);
            }
            if (this.qku != null) {
                this.qku.setVisibility(8);
            }
        } else {
            if (this.qku == null) {
                this.qku = ((ViewStub) findViewById(R.id.aox)).inflate();
            }
            if (this.qkt != null) {
                this.qkt.setVisibility(8);
            }
            View view2 = this.qku;
            View.OnClickListener cvu2 = this.qjX.cvu();
            LinkedList<abz> linkedList2 = cvq.csR().Lcs;
            if (linkedList2.size() == 1) {
                view2.findViewById(R.id.ap0).setVisibility(0);
                abz abz = linkedList2.get(0);
                ((TextView) view2.findViewById(R.id.hfm)).setText(abz.title);
                ((TextView) view2.findViewById(R.id.hfj)).setText(abz.pRY);
                ((TextView) view2.findViewById(R.id.hfj)).setTextColor(l.ake(cvq.csQ().ixw));
                view2.findViewById(R.id.ap0).setOnClickListener(cvu2);
                if (TextUtils.isEmpty(abz.url)) {
                    view2.findViewById(R.id.ap0).setEnabled(false);
                }
            }
            if (cvq.csx() && cvq.csR().Lcz != null && !TextUtils.isEmpty(cvq.csR().Lcz.title)) {
                this.qku.setBackgroundResource(R.drawable.aij);
            }
            if (!cvq.csx() && cvv.cwK()) {
                this.qku.setBackgroundResource(R.drawable.aij);
                AppMethodBeat.o(113709);
                return;
            }
        }
        AppMethodBeat.o(113709);
    }
}
