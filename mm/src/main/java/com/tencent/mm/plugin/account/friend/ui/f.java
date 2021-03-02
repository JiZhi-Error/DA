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
import com.tencent.mm.aj.c;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.ui.d;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f extends d {
    private final int adT;
    private final MMActivity gte;
    private String kcL;
    private d.a khc;
    boolean khk = false;
    private a khl = new a() {
        /* class com.tencent.mm.plugin.account.friend.ui.f.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.account.friend.ui.f.a
        public final void f(int i2, String str, int i3) {
            AppMethodBeat.i(131264);
            Log.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
            as asVar = (as) f.this.getItem(i2);
            if (asVar == null) {
                Log.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", str);
                AppMethodBeat.o(131264);
                return;
            }
            Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", asVar.toString());
            if (asVar.kfO == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(f.this.gte, new a.AbstractC2025a() {
                    /* class com.tencent.mm.plugin.account.friend.ui.f.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(131263);
                        Log.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        long longValue = new p(p.fd(str2)).longValue();
                        as AT = ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).AT(longValue);
                        if (z && AT != null) {
                            AT.username = str;
                        }
                        if (AT != null) {
                            AT.iKU = 2;
                            Log.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", AT.toString());
                            ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(longValue, AT);
                            f.this.anp();
                        } else {
                            Log.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", str2);
                        }
                        if (z && AT != null) {
                            f.Tk(str);
                        }
                        AppMethodBeat.o(131263);
                    }
                });
                aVar.khI = new StringBuilder().append(asVar.kfN).toString();
                aVar.Kee = false;
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(12);
                if (Util.isNullOrNil(asVar.getUsername())) {
                    Log.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    AppMethodBeat.o(131264);
                    return;
                }
                aVar.b(asVar.getUsername(), linkedList, true);
                asVar.iKU = 1;
                ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(asVar.kfN, asVar);
                f.this.anp();
            }
            AppMethodBeat.o(131264);
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
        AppMethodBeat.i(131273);
        as asVar2 = asVar;
        if (asVar2 == null) {
            asVar2 = new as();
        }
        asVar2.convertFrom(cursor);
        AppMethodBeat.o(131273);
        return asVar2;
    }

    public f(MMActivity mMActivity, int i2) {
        super(mMActivity, new as());
        AppMethodBeat.i(131267);
        this.gte = mMActivity;
        this.adT = i2;
        this.khk = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        Bh(true);
        AppMethodBeat.o(131267);
    }

    @Override // com.tencent.mm.plugin.account.friend.ui.d
    public final void a(d.a aVar) {
        this.khc = aVar;
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(131269);
        anp();
        AppMethodBeat.o(131269);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(131270);
        ebf();
        if (Util.isNullOrNil(this.kcL)) {
            setCursor(((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).J(this.adT, this.khk));
        } else {
            setCursor(((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).b(this.adT, this.kcL, this.khk));
        }
        if (!(this.khc == null || this.kcL == null)) {
            this.khc.ve(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(131270);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        int i3;
        boolean z;
        Bitmap bitmap;
        AppMethodBeat.i(131271);
        as asVar = (as) getItem(i2);
        if (view == null) {
            view = View.inflate(this.gte, R.layout.amt, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.kcR = i2;
        bVar.account = new StringBuilder().append(asVar.kfN).toString();
        bVar.status = asVar.kfO;
        bVar.kcZ.setText(l.b(this.gte, asVar.getDisplayName(), bVar.kcZ.getTextSize()));
        bVar.kda.setText(l.b(this.gte, asVar.getNickname(), bVar.kda.getTextSize()));
        if (this.khk) {
            if (p.fd(bVar.account) != 0) {
                bitmap = c.Ah(asVar.kfN);
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                bVar.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, R.raw.default_avatar));
            } else {
                bVar.gyr.setImageBitmap(bitmap);
            }
        } else {
            a.b.c(bVar.gyr, asVar.getUsername());
        }
        if (!this.khk) {
            switch (asVar.kfO) {
                case 1:
                case 2:
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(asVar.getUsername()) && !z.aTY().equals(asVar.getUsername())) {
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
                    bVar.kdb.setVisibility(4);
                    break;
                case 1:
                    bVar.gCd.setVisibility(4);
                    bVar.kdb.setVisibility(0);
                    break;
            }
        } else {
            bVar.kcT.setVisibility(8);
        }
        as asVar2 = (as) getItem(i2 - 1);
        if (asVar2 == null) {
            i3 = -1;
        } else {
            i3 = asVar2.iKT;
        }
        Object[] objArr = new Object[1];
        objArr[0] = asVar2 != null ? asVar2.toString() : "";
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend pre:%s", objArr);
        Object[] objArr2 = new Object[1];
        objArr2[0] = asVar != null ? asVar.toString() : "";
        Log.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", objArr2);
        if (i2 == 0) {
            String b2 = b(asVar);
            if (Util.isNullOrNil(b2)) {
                Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", asVar.getUsername(), Integer.valueOf(i2));
                bVar.kcY.setVisibility(8);
            } else {
                bVar.kcY.setVisibility(0);
                bVar.kcY.setText(b2);
                bVar.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            if (asVar.iKT != i3) {
                z = true;
            } else {
                z = false;
            }
            String b3 = b(asVar);
            if (Util.isNullOrNil(b3) || !z) {
                Log.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", asVar.getUsername(), Integer.valueOf(i2));
                bVar.kcY.setVisibility(8);
            } else {
                bVar.kcY.setVisibility(0);
                bVar.kcY.setText(b3);
                bVar.kcY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        AppMethodBeat.o(131271);
        return view;
    }

    class b {
        String account;
        TextView gCd;
        ImageView gyr;
        int kcR;
        View kcT;
        TextView kcY;
        TextView kcZ;
        TextView kda;
        ProgressBar kdb;
        int status;

        public b(View view) {
            AppMethodBeat.i(131266);
            this.kcY = (TextView) view.findViewById(R.id.dan);
            this.gyr = (ImageView) view.findViewById(R.id.dam);
            this.kcZ = (TextView) view.findViewById(R.id.dao);
            this.kda = (TextView) view.findViewById(R.id.dar);
            this.kcT = view.findViewById(R.id.dal);
            this.gCd = (TextView) view.findViewById(R.id.daq);
            this.kdb = (ProgressBar) view.findViewById(R.id.dap);
            this.kcT.setOnClickListener(new View.OnClickListener(f.this) {
                /* class com.tencent.mm.plugin.account.friend.ui.f.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(131265);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (f.this.khl != null) {
                        f.this.khl.f(b.this.kcR, b.this.account, b.this.status);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendAdapterCaseB$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(131265);
                }
            });
            AppMethodBeat.o(131266);
        }
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
    }

    @Override // com.tencent.mm.plugin.account.friend.ui.d
    public final void SM(String str) {
        AppMethodBeat.i(131268);
        this.kcL = Util.escapeSqlValue(str.trim());
        ebf();
        anp();
        AppMethodBeat.o(131268);
    }

    private static String b(as asVar) {
        AppMethodBeat.i(131272);
        if (asVar.iKT == 123) {
            AppMethodBeat.o(131272);
            return "#";
        }
        String valueOf = String.valueOf((char) asVar.iKT);
        AppMethodBeat.o(131272);
        return valueOf;
    }
}
