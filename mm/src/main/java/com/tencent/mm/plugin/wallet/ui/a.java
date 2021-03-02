package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a {
    public o.f HLX;
    o.g HLY;
    o.g HLZ;
    o.b HMa;
    o.c HMb;
    m HMc;
    m HMd;
    C1906a HMe;
    public boolean HMf = false;
    public boolean HMg = false;
    private AdapterView.OnItemClickListener HMh = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.wallet.ui.a.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(214099);
            b bVar = new b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (i2 >= a.this.HMc.size() + a.this.HMd.size()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(214099);
                return;
            }
            if (i2 < a.this.HMc.size()) {
                n nVar = (n) a.this.HMc.ORD.get(i2);
                if (nVar == null || !nVar.neT) {
                    if (a.this.HLY != null) {
                        a.this.HLY.onMMMenuItemSelected(nVar, i2);
                    } else {
                        nVar.performClick();
                    }
                    a.this.jKz = i2;
                } else {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(214099);
                    return;
                }
            } else if (a.this.HMd.size() > 0 && i2 < a.this.HMc.size() + a.this.HMd.size()) {
                n nVar2 = (n) a.this.HMd.ORD.get(i2 - a.this.HMc.size());
                if (nVar2 != null && nVar2.neT) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(214099);
                    return;
                } else if (a.this.HLZ != null) {
                    a.this.HLZ.onMMMenuItemSelected(nVar2, i2);
                }
            }
            a.this.HMe.atj.notifyChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(214099);
        }
    };
    public int jKz = 0;
    Context mContext;
    private RecyclerView mRecyclerView;
    public final g qAx;

    public a(Context context) {
        AppMethodBeat.i(214106);
        this.mContext = context;
        this.qAx = new g(context, 2, 3);
        Context context2 = this.mContext;
        this.HMc = new m(context2);
        this.HMd = new m(context2);
        this.mRecyclerView = new RecyclerView(this.mContext);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mRecyclerView.setFocusable(false);
        this.mRecyclerView.setLayoutParams(layoutParams);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.mRecyclerView.setItemViewCacheSize(20);
        this.mRecyclerView.setPadding(0, 0, 0, 0);
        this.HMe = new C1906a();
        this.HMe.HMj = this.HMc;
        this.HMe.ars = this.HMh;
        this.mRecyclerView.setAdapter(this.HMe);
        if (this.qAx != null) {
            this.qAx.setCustomView(this.mRecyclerView);
        }
        BottomSheetBehavior.l((View) this.qAx.lJI.getParent()).J(com.tencent.mm.cb.a.jo(this.mRecyclerView.getContext()));
        AppMethodBeat.o(214106);
    }

    public final void setTitleView(View view) {
        AppMethodBeat.i(214107);
        this.qAx.hv(view);
        AppMethodBeat.o(214107);
    }

    public final void T(CharSequence charSequence) {
        AppMethodBeat.i(214108);
        this.qAx.T(charSequence);
        AppMethodBeat.o(214108);
    }

    public final void a(g.a aVar) {
        this.qAx.QOT = aVar;
    }

    public final void fPw() {
        AppMethodBeat.i(214109);
        if (this.HMe != null) {
            this.HMe.atj.notifyChanged();
        }
        this.qAx.dGm();
        AppMethodBeat.o(214109);
    }

    public final void a(m mVar, o.g gVar) {
        this.HMd = mVar;
        this.HLZ = gVar;
    }

    public final void dGm() {
        AppMethodBeat.i(214110);
        if (this.HLX != null) {
            this.HLX.onCreateMMMenu(this.HMc);
        }
        this.mRecyclerView.setPadding(0, 0, 0, 0);
        if (!(this.HMd == null || this.HMe == null)) {
            this.HMe.atj.notifyChanged();
        }
        this.qAx.dGm();
        AppMethodBeat.o(214110);
    }

    /* renamed from: com.tencent.mm.plugin.wallet.ui.a$a  reason: collision with other inner class name */
    public class C1906a extends RecyclerView.a<View$OnClickListenerC1907a> {
        m HMj;
        AdapterView.OnItemClickListener ars;

        public C1906a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(View$OnClickListenerC1907a aVar, int i2) {
            AppMethodBeat.i(214104);
            View$OnClickListenerC1907a aVar2 = aVar;
            if (i2 < this.HMj.size()) {
                if (a.this.jKz >= this.HMj.size()) {
                    a.this.jKz = 0;
                }
                n nVar = (n) this.HMj.ORD.get(i2);
                aVar2.hbb.setText(nVar.getTitle());
                if (nVar.getIcon() != null) {
                    aVar2.uGm.setVisibility(0);
                    aVar2.uGm.setImageDrawable(nVar.getIcon());
                    if (nVar.uzt != 0) {
                        aVar2.uGm.setIconColor(nVar.uzt);
                    } else {
                        aVar2.uGm.setIconColor(a.this.mContext.getResources().getColor(R.color.ac_));
                    }
                } else if (a.this.HMa != null) {
                    aVar2.uGm.setVisibility(0);
                    aVar2.uGm.setIconColor(a.this.mContext.getResources().getColor(R.color.ac_));
                    a.this.HMa.a(aVar2.uGm, nVar);
                } else if (a.this.HMg) {
                    aVar2.uGm.setVisibility(4);
                } else {
                    aVar2.uGm.setVisibility(8);
                }
                if (a.this.HMb != null) {
                    a.this.HMb.a(aVar2.hbb, nVar);
                }
                if (nVar.neT) {
                    aVar2.hbb.setTextColor(a.this.mContext.getResources().getColor(R.color.g1));
                    aVar2.uGm.setAlpha(77);
                    aVar2.HMm.setBackgroundResource(R.color.ac_);
                } else {
                    aVar2.uGm.setAlpha(255);
                    aVar2.hbb.setTextColor(a.this.mContext.getResources().getColor(R.color.g0));
                }
                if (aVar2.jCB != null) {
                    if (!TextUtils.isEmpty(nVar.xdb)) {
                        aVar2.jCB.setVisibility(0);
                        aVar2.jCB.setText(nVar.xdb);
                        if (a.this.HMf) {
                            aVar2.jCB.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                    } else {
                        aVar2.jCB.setVisibility(8);
                    }
                }
                if (a.this.HMf) {
                    if (nVar.neT) {
                        aVar2.HMk.setVisibility(4);
                        aVar2.jCB.setTextColor(a.this.mContext.getResources().getColor(R.color.g1));
                    } else {
                        aVar2.jCB.setTextColor(a.this.mContext.getResources().getColor(R.color.g2));
                        if (a.this.jKz == i2) {
                            aVar2.HMk.setVisibility(0);
                        } else {
                            aVar2.HMk.setVisibility(4);
                        }
                    }
                    aVar2.HMl.setVisibility(0);
                }
                if (a.this.HMd.size() == 0 && i2 == this.HMj.size() - 1) {
                    ((LinearLayout.LayoutParams) aVar2.HMl.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                AppMethodBeat.o(214104);
                return;
            }
            if (a.this.HMd.size() > 0 && i2 < this.HMj.size() + a.this.HMd.size()) {
                n nVar2 = (n) a.this.HMd.ORD.get(i2 - this.HMj.size());
                aVar2.hbb.setText(nVar2.getTitle());
                if (a.this.jKz >= this.HMj.size() + a.this.HMd.size()) {
                    a.this.jKz = 0;
                }
                if (nVar2.getIcon() != null) {
                    aVar2.uGm.setVisibility(0);
                    aVar2.uGm.setImageDrawable(nVar2.getIcon());
                    if (nVar2.uzt != 0) {
                        aVar2.uGm.setIconColor(nVar2.uzt);
                    } else {
                        aVar2.uGm.setIconColor(a.this.mContext.getResources().getColor(R.color.ac_));
                    }
                } else {
                    aVar2.uGm.setVisibility(8);
                }
                if (nVar2.neT) {
                    aVar2.hbb.setTextColor(a.this.mContext.getResources().getColor(R.color.g1));
                    aVar2.HMm.setBackgroundResource(R.color.ac_);
                    aVar2.uGm.setAlpha(0.1f);
                } else {
                    aVar2.hbb.setTextColor(aVar2.hbb.getTextColors());
                    aVar2.HMm.setBackgroundResource(R.drawable.agn);
                }
                if (aVar2.jCB != null) {
                    if (!TextUtils.isEmpty(nVar2.xdb)) {
                        aVar2.jCB.setVisibility(0);
                        aVar2.jCB.setText(nVar2.xdb);
                    } else {
                        aVar2.jCB.setVisibility(8);
                    }
                }
                if (nVar2.neT) {
                    aVar2.HMk.setVisibility(4);
                    aVar2.jCB.setTextColor(a.this.mContext.getResources().getColor(R.color.g1));
                    aVar2.uGm.setAlpha(0.1f);
                } else {
                    aVar2.jCB.setTextColor(a.this.mContext.getResources().getColor(R.color.g2));
                    aVar2.HMk.setVisibility(0);
                }
                aVar2.HMl.setVisibility(0);
            }
            AppMethodBeat.o(214104);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(214102);
            if (i2 < this.HMj.size()) {
                AppMethodBeat.o(214102);
                return 0;
            }
            AppMethodBeat.o(214102);
            return 1;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(214103);
            int size = this.HMj.size() + a.this.HMd.size();
            AppMethodBeat.o(214103);
            return size;
        }

        /* renamed from: com.tencent.mm.plugin.wallet.ui.a$a$a  reason: collision with other inner class name */
        public class View$OnClickListenerC1907a extends RecyclerView.v implements View.OnClickListener {
            WeImageView HMk;
            ImageView HMl;
            LinearLayout HMm;
            TextView hbb;
            TextView jCB;
            WeImageView uGm;

            public View$OnClickListenerC1907a(View view, int i2) {
                super(view);
                AppMethodBeat.i(214100);
                view.setOnClickListener(this);
                this.hbb = (TextView) view.findViewById(R.id.ipm);
                this.uGm = (WeImageView) view.findViewById(R.id.dt5);
                this.HMm = (LinearLayout) view.findViewById(R.id.h8v);
                if (a.this.HMf) {
                    this.HMk = (WeImageView) view.findViewById(R.id.gqn);
                    this.jCB = (TextView) view.findViewById(R.id.bmr);
                    this.HMl = (ImageView) view.findViewById(R.id.brt);
                    if (i2 == 1) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HMl.getLayoutParams();
                        layoutParams.setMargins(0, 0, 0, 0);
                        this.HMl.setLayoutParams(layoutParams);
                        this.HMk.setImageResource(R.raw.icons_outlined_arrow);
                        this.HMk.setIconColor(a.this.mContext.getResources().getColor(R.color.FG_2));
                    }
                }
                AppMethodBeat.o(214100);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(214101);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (C1906a.this.ars != null) {
                    C1906a.this.ars.onItemClick(null, view, getPosition(), (long) getPosition());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/ui/BankCardListBottomSheetUI$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(214101);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ View$OnClickListenerC1907a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(214105);
            View$OnClickListenerC1907a aVar = new View$OnClickListenerC1907a(LayoutInflater.from(a.this.mContext).inflate(R.layout.b2t, viewGroup, false), i2);
            AppMethodBeat.o(214105);
            return aVar;
        }
    }
}
