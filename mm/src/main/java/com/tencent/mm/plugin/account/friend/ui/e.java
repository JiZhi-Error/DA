package com.tencent.mm.plugin.account.friend.ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.ui.a;
import com.tencent.mm.plugin.account.friend.ui.c;
import com.tencent.mm.plugin.account.friend.ui.d;
import com.tencent.mm.plugin.account.friend.ui.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e extends d {
    private final int adT;
    private final MMActivity gte;
    private String kcL;
    private final a kha;
    private final c khb;
    private d.a khc;
    boolean khd = false;
    private a khe = new a() {
        /* class com.tencent.mm.plugin.account.friend.ui.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.account.friend.ui.e.a
        public final void f(int i2, String str, int i3) {
            AppMethodBeat.i(131250);
            Log.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
            as asVar = (as) e.this.getItem(i2);
            if (asVar == null) {
                Log.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", str);
                AppMethodBeat.o(131250);
            } else if (Util.isNullOrNil(asVar.getUsername())) {
                Log.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", str);
                AppMethodBeat.o(131250);
            } else {
                Log.d("MicroMsg.QQFriendAdapter", "qq friend:%s", asVar.toString());
                if (asVar.kfO == 0) {
                    int[] iArr = {p.fd(new StringBuilder().append(asVar.kfN).toString())};
                    g gVar = new g(e.this.gte, new g.a() {
                        /* class com.tencent.mm.plugin.account.friend.ui.e.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.account.friend.ui.g.a
                        public final void i(boolean z, String str) {
                            AppMethodBeat.i(131248);
                            as AT = ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).AT((long) p.fd(str));
                            if (AT != null) {
                                AT.iKU = 2;
                                Log.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", AT.toString());
                                ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(AT.kfN, AT);
                                e.this.anp();
                                AppMethodBeat.o(131248);
                                return;
                            }
                            Log.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", AT);
                            AppMethodBeat.o(131248);
                        }
                    }, (byte) 0);
                    gVar.t(iArr);
                    gVar.khI = new StringBuilder().append(asVar.kfN).toString();
                    asVar.iKU = 1;
                    ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(asVar.kfN, asVar);
                    e.this.anp();
                    AppMethodBeat.o(131250);
                    return;
                }
                if (asVar.kfO == 1) {
                    com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(e.this.gte, new a.AbstractC2025a() {
                        /* class com.tencent.mm.plugin.account.friend.ui.e.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                        public final void a(boolean z, boolean z2, String str, String str2) {
                            AppMethodBeat.i(131249);
                            Log.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                            long longValue = new p(p.fd(str2)).longValue();
                            as AT = ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).AT(longValue);
                            if (AT != null && z) {
                                AT.username = str;
                            }
                            if (AT != null) {
                                AT.iKU = 2;
                                Log.d("MicroMsg.QQFriendAdapter", "f :%s", AT.toString());
                                ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(longValue, AT);
                                e.this.anp();
                            } else {
                                Log.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                            }
                            if (z && AT != null) {
                                e.Tk(str);
                            }
                            AppMethodBeat.o(131249);
                        }
                    });
                    aVar.khI = new StringBuilder().append(asVar.kfN).toString();
                    aVar.Kee = false;
                    LinkedList<Integer> linkedList = new LinkedList<>();
                    linkedList.add(12);
                    aVar.b(asVar.getUsername(), linkedList, true);
                    asVar.iKU = 1;
                    ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(asVar.kfN, asVar);
                    e.this.anp();
                }
                AppMethodBeat.o(131250);
            }
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        void f(int i2, String str, int i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ as a(as asVar, Cursor cursor) {
        AppMethodBeat.i(131262);
        as asVar2 = asVar;
        if (asVar2 == null) {
            asVar2 = new as();
        }
        asVar2.convertFrom(cursor);
        AppMethodBeat.o(131262);
        return asVar2;
    }

    public e(MMActivity mMActivity, int i2) {
        super(mMActivity, new as());
        AppMethodBeat.i(131256);
        this.gte = mMActivity;
        this.adT = i2;
        this.khd = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.kha = new a(mMActivity, new a.AbstractC0521a() {
            /* class com.tencent.mm.plugin.account.friend.ui.e.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.account.friend.ui.a.AbstractC0521a
            public final void Tj(String str) {
                AppMethodBeat.i(131251);
                at atVar = (at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                as Tg = atVar.Tg(str);
                if (Tg == null) {
                    Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", String.valueOf(str));
                    AppMethodBeat.o(131251);
                    return;
                }
                Tg.kfO = 2;
                atVar.a(Tg.kfN, Tg);
                e.this.notifyDataSetChanged();
                com.tencent.mm.storage.as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
                if (Kn == null) {
                    as Tg2 = ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Tg(str);
                    if (Tg2 != null) {
                        Tg2.boC();
                        Log.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + Tg2.kfN);
                        ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(Tg2.kfN, Tg2);
                    }
                } else if ((Kn.field_conRemark == null || Kn.field_conRemark.equals("")) && Tg != null && Tg.boz() != null && !Tg.boz().equals("")) {
                    ab.c(Kn, Tg.boz());
                }
                cf.aWl().f(26, new Object[0]);
                AppMethodBeat.o(131251);
            }

            @Override // com.tencent.mm.plugin.account.friend.ui.a.AbstractC0521a
            public final void ae(String str, boolean z) {
                AppMethodBeat.i(131252);
                if (z) {
                    as Tg = ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Tg(str);
                    if (Tg != null) {
                        Tg.boC();
                        Log.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + Tg.kfN);
                        ((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(Tg.kfN, Tg);
                    } else {
                        Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", String.valueOf(str));
                    }
                }
                e.this.notifyDataSetChanged();
                AppMethodBeat.o(131252);
            }
        });
        this.khb = new c(mMActivity, new c.a() {
            /* class com.tencent.mm.plugin.account.friend.ui.e.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.account.friend.ui.c.a
            public final void gm(boolean z) {
                AppMethodBeat.i(131253);
                if (z) {
                    e.this.notifyDataSetChanged();
                }
                AppMethodBeat.o(131253);
            }
        });
        AppMethodBeat.o(131256);
    }

    @Override // com.tencent.mm.plugin.account.friend.ui.d
    public final void a(d.a aVar) {
        this.khc = aVar;
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(131258);
        anp();
        AppMethodBeat.o(131258);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(131259);
        ebf();
        if (Util.isNullOrNil(this.kcL)) {
            setCursor(((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).J(this.adT, this.khd));
        } else {
            setCursor(((at) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adT, this.kcL, this.khd));
        }
        if (!(this.khc == null || this.kcL == null)) {
            this.khc.ve(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(131259);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap bitmap;
        AppMethodBeat.i(131260);
        as asVar = (as) getItem(i2);
        if (view == null) {
            view = View.inflate(this.gte, R.layout.bjv, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.kcR = i2;
        bVar.khh = new StringBuilder().append(asVar.kfN).toString();
        bVar.status = asVar.kfO;
        bVar.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, asVar.getDisplayName(), bVar.kcS.getTextSize()));
        if (p.fd(new StringBuilder().append(asVar.kfN).toString()) != 0) {
            bitmap = com.tencent.mm.aj.c.Ah(asVar.kfN);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            bVar.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.raw.default_avatar));
        } else {
            bVar.gyr.setImageBitmap(bitmap);
        }
        if (!this.khd) {
            switch (asVar.kfO) {
                case 0:
                    if (asVar.iKU != 2) {
                        bVar.kcT.setClickable(true);
                        bVar.kcT.setBackgroundResource(R.drawable.k7);
                        bVar.gCd.setText(R.string.diz);
                        bVar.gCd.setTextColor(this.gte.getResources().getColor(R.color.ag2));
                        break;
                    } else {
                        bVar.kcT.setClickable(false);
                        bVar.kcT.setBackgroundDrawable(null);
                        bVar.gCd.setText(R.string.dj0);
                        bVar.gCd.setTextColor(this.gte.getResources().getColor(R.color.wx));
                        break;
                    }
                case 1:
                case 2:
                    if (!((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjG(asVar.getUsername()) && !z.aTY().equals(asVar.getUsername())) {
                        if (asVar.iKU != 2) {
                            bVar.kcT.setClickable(true);
                            bVar.kcT.setBackgroundResource(R.drawable.k7);
                            bVar.gCd.setText(R.string.dix);
                            bVar.gCd.setTextColor(this.gte.getResources().getColor(R.color.ag2));
                            break;
                        } else {
                            bVar.kcT.setClickable(false);
                            bVar.kcT.setBackgroundDrawable(null);
                            bVar.gCd.setText(R.string.dj3);
                            bVar.gCd.setTextColor(this.gte.getResources().getColor(R.color.wx));
                            break;
                        }
                    } else {
                        bVar.kcT.setClickable(false);
                        bVar.kcT.setBackgroundDrawable(null);
                        bVar.gCd.setText(R.string.diy);
                        bVar.gCd.setTextColor(this.gte.getResources().getColor(R.color.wx));
                        break;
                    }
                    break;
            }
            switch (asVar.iKU) {
                case 0:
                case 2:
                    bVar.gCd.setVisibility(0);
                    bVar.hRO.setVisibility(4);
                    break;
                case 1:
                    bVar.gCd.setVisibility(4);
                    bVar.hRO.setVisibility(0);
                    break;
            }
        } else {
            bVar.kcT.setVisibility(8);
        }
        AppMethodBeat.o(131260);
        return view;
    }

    class b {
        TextView gCd;
        ImageView gyr;
        ProgressBar hRO;
        int kcR;
        TextView kcS;
        View kcT;
        String khh;
        int status;

        public b(View view) {
            AppMethodBeat.i(131255);
            this.gyr = (ImageView) view.findViewById(R.id.bdp);
            this.kcS = (TextView) view.findViewById(R.id.gmo);
            this.kcT = view.findViewById(R.id.gmi);
            this.gCd = (TextView) view.findViewById(R.id.gmq);
            this.hRO = (ProgressBar) view.findViewById(R.id.gmp);
            this.kcT.setOnClickListener(new View.OnClickListener(e.this) {
                /* class com.tencent.mm.plugin.account.friend.ui.e.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(131254);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (e.this.khe != null) {
                        e.this.khe.f(b.this.kcR, b.this.khh, b.this.status);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseA$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(131254);
                }
            });
            AppMethodBeat.o(131255);
        }
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(131261);
        notifyDataSetChanged();
        AppMethodBeat.o(131261);
    }

    @Override // com.tencent.mm.plugin.account.friend.ui.d
    public final void SM(String str) {
        AppMethodBeat.i(131257);
        this.kcL = Util.escapeSqlValue(str.trim());
        ebf();
        anp();
        AppMethodBeat.o(131257);
    }
}
