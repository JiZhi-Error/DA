package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.g.b;

public final class c extends g<c, a> {
    public static final int Sno = R.layout.bn9;
    private CharSequence Bic;
    private Drawable SnB;
    private b.AbstractC2224b<c> SnC;
    private b.d<c> SnD;
    private boolean SnE;
    private b<Boolean, c> SnF;
    private b<Boolean, c> SnG;
    private Drawable Snp;
    private b.AbstractC2224b<c> Snq;

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        int i2 = 0;
        AppMethodBeat.i(159944);
        a aVar2 = (a) aVar;
        aVar2.titleTv.setText(this.Hn);
        if (this.Snp != null) {
            aVar2.Snv.setImageDrawable(this.Snp);
            aVar2.Snv.setVisibility(0);
        } else if (this.Snq != null) {
            com.tencent.toybrick.e.c.Sox.a(aVar2, this.Snq, aVar2.Snv);
        } else {
            aVar2.Snv.setVisibility(8);
        }
        if (this.SnB != null) {
            aVar2.SnM.setVisibility(0);
            aVar2.SnI.setVisibility(0);
            aVar2.SnI.setImageDrawable(this.Snp);
        } else if (this.SnC != null) {
            aVar2.SnM.setVisibility(0);
            com.tencent.toybrick.e.c.Sox.a(aVar2, this.SnC, aVar2.SnI);
        } else {
            aVar2.SnI.setVisibility(8);
            aVar2.SnM.setVisibility(8);
        }
        com.tencent.toybrick.e.c.Sox.a(aVar2, this.SnF, new c.a<a, Boolean>() {
            /* class com.tencent.toybrick.c.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.toybrick.e.c.a
            public final /* synthetic */ void T(a aVar, Boolean bool) {
                int i2;
                AppMethodBeat.i(159939);
                ImageView imageView = aVar.SnK;
                if (bool.booleanValue()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                AppMethodBeat.o(159939);
            }
        });
        com.tencent.toybrick.e.c.Sox.a(aVar2, this.SnG, new c.a<a, Boolean>() {
            /* class com.tencent.toybrick.c.c.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.toybrick.e.c.a
            public final /* synthetic */ void T(a aVar, Boolean bool) {
                int i2;
                AppMethodBeat.i(159940);
                ImageView imageView = aVar.SnJ;
                if (bool.booleanValue()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                AppMethodBeat.o(159940);
            }
        });
        com.tencent.toybrick.e.c.Sox.a(aVar2, this.SnD, new c.a<a, CharSequence>() {
            /* class com.tencent.toybrick.c.c.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.toybrick.e.c.a
            public final /* synthetic */ void T(a aVar, CharSequence charSequence) {
                AppMethodBeat.i(159941);
                a aVar2 = aVar;
                CharSequence charSequence2 = charSequence;
                aVar2.SnL.setVisibility(TextUtils.isEmpty(charSequence2) ? 8 : 0);
                aVar2.SnL.setText(charSequence2);
                AppMethodBeat.o(159941);
            }
        });
        if (TextUtils.isEmpty(this.Bic)) {
            aVar2.BfZ.setVisibility(8);
        } else {
            aVar2.BfZ.setVisibility(0);
            aVar2.BfZ.setText(this.Bic);
        }
        ImageView imageView = aVar2.EbJ;
        if (!this.SnE) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        AppMethodBeat.o(159944);
    }

    @Override // com.tencent.toybrick.c.f
    public final int getLayoutResource() {
        return Sno;
    }

    public class a extends d.a {
        ImageView EbJ;
        ImageView SnI;
        ImageView SnJ;
        ImageView SnK;
        TextView SnL;
        View SnM;

        public a(View view) {
            super(view);
            AppMethodBeat.i(159942);
            this.SnI = (ImageView) view.findViewById(R.id.dwk);
            this.SnL = (TextView) view.findViewById(R.id.h73);
            this.SnJ = (ImageView) view.findViewById(R.id.h7d);
            this.SnM = view.findViewById(R.id.h7f);
            this.EbJ = (ImageView) view.findViewById(R.id.h6o);
            this.SnK = (ImageView) view.findViewById(R.id.h72);
            AppMethodBeat.o(159942);
        }
    }

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ com.tencent.toybrick.f.a hM(View view) {
        AppMethodBeat.i(159943);
        a aVar = new a(view);
        AppMethodBeat.o(159943);
        return aVar;
    }
}
