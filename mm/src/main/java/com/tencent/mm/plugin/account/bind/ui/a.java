package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;

public final class a extends s<n> {
    private String jZG;
    AbstractC0519a kco;
    private Context mContext;
    private String mFilter;
    private LayoutInflater mLayoutInflater = LayoutInflater.from(this.mContext);

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.account.bind.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC0519a {
        void vd(int i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ n a(n nVar, Cursor cursor) {
        AppMethodBeat.i(110073);
        n nVar2 = nVar;
        if (nVar2 == null) {
            nVar2 = new n();
        }
        nVar2.convertFrom(cursor);
        AppMethodBeat.o(110073);
        return nVar2;
    }

    public a(Context context, String str) {
        super(context, new n());
        AppMethodBeat.i(110068);
        this.jZG = str;
        this.mContext = context;
        AppMethodBeat.o(110068);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(110069);
        anp();
        AppMethodBeat.o(110069);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(110070);
        setCursor(((o) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bZ(this.mFilter, this.jZG));
        super.notifyDataSetChanged();
        AppMethodBeat.o(110070);
    }

    public final void SM(String str) {
        AppMethodBeat.i(110071);
        this.mFilter = Util.escapeSqlValue(str);
        ebf();
        anp();
        AppMethodBeat.o(110071);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap bitmap;
        AppMethodBeat.i(110072);
        if (view == null || view.getTag() == null) {
            view = this.mLayoutInflater.inflate(R.layout.atf, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) getItem(i2);
        if (nVar == null) {
            AppMethodBeat.o(110072);
        } else {
            bVar.position = i2;
            bVar.kcp = nVar.field_googlegmail;
            switch (nVar.field_status) {
                case 0:
                case 2:
                    if (nVar.field_small_url != null) {
                        bitmap = c.a(nVar.field_username, false, -1, null);
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null) {
                        bVar.gyr.setImageBitmap(bitmap);
                        break;
                    } else {
                        bVar.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.default_avatar));
                        break;
                    }
                case 1:
                    Bitmap LV = c.LV(nVar.field_googleid);
                    if (LV != null) {
                        bVar.gyr.setImageBitmap(LV);
                        break;
                    } else {
                        bVar.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, R.raw.default_avatar));
                        break;
                    }
            }
            if (TextUtils.isEmpty(nVar.field_googlename)) {
                bVar.gxs.setText(Util.subStringEmail(nVar.field_googlegmail));
            } else {
                bVar.gxs.setText(nVar.field_googlename);
            }
            switch (nVar.field_status) {
                case 0:
                    bVar.kcr.setClickable(true);
                    bVar.kcr.setBackgroundResource(R.drawable.k7);
                    bVar.gCd.setText(R.string.dtt);
                    bVar.gCd.setTextColor(this.mContext.getResources().getColor(R.color.afz));
                    break;
                case 1:
                    bVar.kcr.setClickable(true);
                    bVar.kcr.setBackgroundResource(R.drawable.k9);
                    bVar.gCd.setText(R.string.du1);
                    bVar.gCd.setTextColor(this.mContext.getResources().getColor(R.color.wx));
                    break;
                case 2:
                    bVar.kcr.setClickable(false);
                    bVar.kcr.setBackgroundDrawable(null);
                    bVar.gCd.setText(R.string.dtv);
                    bVar.gCd.setTextColor(this.mContext.getResources().getColor(R.color.wx));
                    break;
            }
            switch (nVar.field_googlecgistatus) {
                case 0:
                    bVar.gCd.setVisibility(4);
                    bVar.kcs.setVisibility(0);
                    break;
                case 1:
                    bVar.kcr.setClickable(false);
                    bVar.kcr.setBackgroundDrawable(null);
                    bVar.gCd.setVisibility(0);
                    bVar.kcs.setVisibility(8);
                    bVar.gCd.setTextColor(this.mContext.getResources().getColor(R.color.wx));
                    switch (nVar.field_status) {
                        case 0:
                            bVar.gCd.setText(R.string.dtu);
                            break;
                        case 1:
                            bVar.gCd.setText(R.string.du2);
                            break;
                    }
                case 2:
                    bVar.gCd.setVisibility(0);
                    bVar.kcs.setVisibility(8);
                    switch (nVar.field_status) {
                        case 0:
                            bVar.gCd.setText(R.string.dtt);
                            bVar.gCd.setTextColor(this.mContext.getResources().getColor(R.color.afz));
                            break;
                        case 1:
                            bVar.gCd.setText(R.string.du1);
                            bVar.gCd.setTextColor(this.mContext.getResources().getColor(R.color.wx));
                            break;
                    }
            }
            bVar.kcq.setText(nVar.field_googlegmail);
            AppMethodBeat.o(110072);
        }
        return view;
    }

    class b {
        TextView gCd;
        TextView gxs;
        ImageView gyr;
        String kcp;
        TextView kcq;
        View kcr;
        ProgressBar kcs;
        int position;

        public b(View view) {
            AppMethodBeat.i(110067);
            this.gyr = (ImageView) view.findViewById(R.id.djd);
            this.gxs = (TextView) view.findViewById(R.id.djh);
            this.kcr = view.findViewById(R.id.dji);
            this.gCd = (TextView) view.findViewById(R.id.djj);
            this.kcs = (ProgressBar) view.findViewById(R.id.djg);
            this.kcq = (TextView) view.findViewById(R.id.dje);
            this.kcr.setOnClickListener(new View.OnClickListener(a.this) {
                /* class com.tencent.mm.plugin.account.bind.ui.a.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(110066);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
                    if (a.this.kco != null) {
                        a.this.kco.vd(b.this.position);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110066);
                }
            });
            AppMethodBeat.o(110067);
        }
    }
}
