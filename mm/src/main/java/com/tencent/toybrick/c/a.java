package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.g.b;

public final class a extends g<a, C2219a> {
    public static final int Sno = R.layout.ub;
    private CharSequence Bic;
    private Drawable Snp;
    private b.AbstractC2224b<a> Snq;
    private b.a<a> Snr;

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ void a(com.tencent.toybrick.f.a aVar) {
        AppMethodBeat.i(159935);
        C2219a aVar2 = (C2219a) aVar;
        aVar2.titleTv.setText(this.Hn);
        if (TextUtils.isEmpty(this.Bic)) {
            aVar2.BfZ.setVisibility(8);
        } else {
            aVar2.BfZ.setVisibility(0);
            aVar2.BfZ.setText(this.Bic);
        }
        if (this.Snp != null) {
            aVar2.Snv.setImageDrawable(this.Snp);
            aVar2.Snv.setVisibility(0);
        } else if (this.Snq != null) {
            c.Sox.a(aVar2, this.Snq, aVar2.Snv);
        } else {
            aVar2.Snv.setVisibility(8);
        }
        c.Sox.a(aVar2, this.Snr, new c.a<C2219a, Boolean>() {
            /* class com.tencent.toybrick.c.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.toybrick.e.c.a
            public final /* synthetic */ void T(C2219a aVar, Boolean bool) {
                AppMethodBeat.i(159932);
                aVar.Snw.setCheck(bool.booleanValue());
                AppMethodBeat.o(159932);
            }
        });
        AppMethodBeat.o(159935);
    }

    @Override // com.tencent.toybrick.c.f
    public final int getLayoutResource() {
        return Sno;
    }

    /* renamed from: com.tencent.toybrick.c.a$a  reason: collision with other inner class name */
    public class C2219a extends com.tencent.toybrick.f.a {
        public TextView BfZ;
        public TextView Snt;
        public ImageView Snu;
        public ImageView Snv;
        public MMSwitchBtn Snw;
        public TextView titleTv;

        public C2219a(View view) {
            super(view);
            AppMethodBeat.i(159933);
            this.titleTv = (TextView) view.findViewById(16908310);
            this.Snv = (ImageView) view.findViewById(R.id.ea_);
            this.Snt = (TextView) view.findViewById(R.id.ikj);
            this.Snu = (ImageView) view.findViewById(R.id.dwi);
            this.BfZ = (TextView) view.findViewById(R.id.ied);
            this.Snw = (MMSwitchBtn) view.findViewById(R.id.b0m);
            this.Snw.setSwitchListener(new MMSwitchBtn.a(a.this) {
                /* class com.tencent.toybrick.c.a.C2219a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                public final void onStatusChange(boolean z) {
                }
            });
            AppMethodBeat.o(159933);
        }
    }

    @Override // com.tencent.toybrick.c.f
    public final /* synthetic */ com.tencent.toybrick.f.a hM(View view) {
        AppMethodBeat.i(159934);
        C2219a aVar = new C2219a(view);
        AppMethodBeat.o(159934);
        return aVar;
    }
}
