package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.g.b;

public final class d extends g<d, a> {
    public static final int Sno = R.layout.btb;
    private CharSequence Bic;
    private Drawable SnB;
    private b.AbstractC2224b<d> SnC;
    private g.a SnN;
    private b.c<d> SnO;
    private Drawable Snp;
    private b.AbstractC2224b<d> Snq;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        AppMethodBeat.i(159951);
        a aVar2 = (a) aVar;
        aVar2.titleTv.setText(this.Hn);
        if (this.Snp != null) {
            aVar2.Snv.setImageDrawable(this.Snp);
            aVar2.Snv.setVisibility(0);
        } else if (this.Snq != null) {
            c.Sox.a(aVar2, this.Snq, aVar2.Snv);
        } else {
            aVar2.Snv.setVisibility(8);
        }
        if (this.SnB != null) {
            aVar2.SnI.setImageDrawable(this.SnB);
            aVar2.SnI.setVisibility(0);
        } else if (this.SnC != null) {
            c.Sox.a(aVar2, this.SnC, aVar2.SnI);
        } else {
            aVar2.SnI.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.Bic)) {
            aVar2.BfZ.setVisibility(8);
        } else {
            aVar2.BfZ.setVisibility(0);
            aVar2.BfZ.setText(this.Bic);
        }
        switch (this.SnN) {
            case NONE:
                aVar2.Snu.setVisibility(8);
                aVar2.Snt.setVisibility(8);
                AppMethodBeat.o(159951);
                return;
            case RED_DOT:
                aVar2.Snt.setVisibility(8);
                c.Sox.a(aVar2, this.SnO, new c.a<a, Integer>() {
                    /* class com.tencent.toybrick.c.d.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // com.tencent.toybrick.e.c.a
                    public final /* synthetic */ void T(a aVar, Integer num) {
                        AppMethodBeat.i(159945);
                        a aVar2 = aVar;
                        if (num.intValue() > 0) {
                            aVar2.Snu.setVisibility(0);
                            AppMethodBeat.o(159945);
                            return;
                        }
                        aVar2.Snu.setVisibility(8);
                        AppMethodBeat.o(159945);
                    }
                });
                AppMethodBeat.o(159951);
                return;
            case RED_NEW:
                aVar2.Snu.setVisibility(8);
                int dimension = (int) this.SnR.getResources().getDimension(R.dimen.k5);
                aVar2.Snt.setPadding(dimension, 0, dimension, 0);
                c.Sox.a(aVar2, this.SnO, new c.a<a, Integer>() {
                    /* class com.tencent.toybrick.c.d.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // com.tencent.toybrick.e.c.a
                    public final /* synthetic */ void T(a aVar, Integer num) {
                        AppMethodBeat.i(159946);
                        a aVar2 = aVar;
                        if (num.intValue() > 0) {
                            aVar2.Snt.setVisibility(0);
                            aVar2.Snt.setText(d.this.SnR.getString(R.string.hrt));
                            AppMethodBeat.o(159946);
                            return;
                        }
                        aVar2.Snt.setVisibility(8);
                        AppMethodBeat.o(159946);
                    }
                });
                AppMethodBeat.o(159951);
                return;
            case RED_NUM:
                aVar2.Snt.setPadding(0, 0, 0, 0);
                aVar2.Snu.setVisibility(8);
                c.Sox.a(aVar2, this.SnO, new c.a<a, Integer>() {
                    /* class com.tencent.toybrick.c.d.AnonymousClass3 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // com.tencent.toybrick.e.c.a
                    public final /* synthetic */ void T(a aVar, Integer num) {
                        AppMethodBeat.i(159947);
                        a aVar2 = aVar;
                        Integer num2 = num;
                        if (num2.intValue() > 0) {
                            aVar2.Snt.setVisibility(0);
                            aVar2.Snt.setText(String.valueOf(num2));
                            AppMethodBeat.o(159947);
                            return;
                        }
                        aVar2.Snt.setVisibility(8);
                        AppMethodBeat.o(159947);
                    }
                });
                break;
        }
        AppMethodBeat.o(159951);
    }

    @Override // com.tencent.toybrick.c.f
    public final int getLayoutResource() {
        return Sno;
    }

    public static class a extends com.tencent.toybrick.f.a {
        public TextView BfZ;
        public ImageView SnI;
        public TextView Snt;
        public ImageView Snu;
        public ImageView Snv;
        public TextView titleTv;

        public a(View view) {
            super(view);
            AppMethodBeat.i(159949);
            this.titleTv = (TextView) view.findViewById(16908310);
            this.Snv = (ImageView) view.findViewById(R.id.ea_);
            this.SnI = (ImageView) view.findViewById(R.id.h76);
            this.Snt = (TextView) view.findViewById(R.id.ikj);
            this.Snu = (ImageView) view.findViewById(R.id.dwi);
            this.BfZ = (TextView) view.findViewById(R.id.ied);
            AppMethodBeat.o(159949);
        }
    }

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ com.tencent.toybrick.f.a hM(View view) {
        AppMethodBeat.i(159950);
        a aVar = new a(view);
        AppMethodBeat.o(159950);
        return aVar;
    }
}
