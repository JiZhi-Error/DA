package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.s;
import java.util.List;

public final class d extends s<as> {
    protected MMSlideDelView.f AAA;
    e KfF;
    protected String PSf = null;
    protected MMActivity gte;
    protected List<String> gzY = null;
    b kex = null;
    private b.AbstractC2078b kez = null;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

    /* access modifiers changed from: protected */
    public static class a {
        public ViewGroup PUk;
        public MaskLayout gAN;
        public TextView gwR;
        public TextView yuS;
    }

    public d(Context context, String str) {
        super(context, new as());
        AppMethodBeat.i(37683);
        this.gte = (MMActivity) context;
        this.PSf = str;
        this.kex = new b(new b.a() {
            /* class com.tencent.mm.ui.contact.d.AnonymousClass1 */

            @Override // com.tencent.mm.ui.applet.b.a
            public final Bitmap Ta(String str) {
                AppMethodBeat.i(37680);
                Bitmap a2 = c.a(str, false, -1, null);
                AppMethodBeat.o(37680);
                return a2;
            }
        });
        AppMethodBeat.o(37683);
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.AAA = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(37684);
        int count = getCursor().getCount();
        AppMethodBeat.o(37684);
        return count;
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(37685);
        anp();
        AppMethodBeat.o(37685);
    }

    @Override // com.tencent.mm.ui.s
    public final synchronized void anp() {
        AppMethodBeat.i(37686);
        bg.aVF();
        Cursor d2 = com.tencent.mm.model.c.aSN().d(this.PSf, "", this.gzY);
        ebf();
        setCursor(d2);
        notifyDataSetChanged();
        AppMethodBeat.o(37686);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        int i3;
        AppMethodBeat.i(37687);
        if (this.kez == null) {
            this.kez = new b.AbstractC2078b() {
                /* class com.tencent.mm.ui.contact.d.AnonymousClass2 */

                @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                public final String vg(int i2) {
                    AppMethodBeat.i(37681);
                    if (i2 < 0 || i2 >= d.this.getCount()) {
                        Log.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                        AppMethodBeat.o(37681);
                        return null;
                    }
                    as asVar = (as) d.this.getItem(i2);
                    if (asVar == null) {
                        AppMethodBeat.o(37681);
                        return null;
                    }
                    String str = asVar.field_username;
                    AppMethodBeat.o(37681);
                    return str;
                }

                @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                public final int bnW() {
                    AppMethodBeat.i(37682);
                    int count = d.this.getCount();
                    AppMethodBeat.o(37682);
                    return count;
                }
            };
        }
        if (this.kex != null) {
            this.kex.a(i2, this.kez);
        }
        if (view == null) {
            view = View.inflate(this.gte, R.layout.pg, null);
            a aVar2 = new a();
            aVar2.yuS = (TextView) view.findViewById(R.id.bdr);
            aVar2.gAN = (MaskLayout) view.findViewById(R.id.bdo);
            aVar2.gwR = (TextView) view.findViewById(R.id.bdw);
            aVar2.PUk = (ViewGroup) view.findViewById(R.id.bdv);
            ViewGroup.LayoutParams layoutParams = aVar2.PUk.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.cb.a.aH(this.gte, R.dimen.az)) * com.tencent.mm.cb.a.jj(this.gte));
            aVar2.PUk.setLayoutParams(layoutParams);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        as asVar = (as) getItem(i2 - 1);
        if (asVar == null) {
            i3 = -1;
        } else {
            i3 = asVar.field_showHead;
        }
        as asVar2 = (as) getItem(i2);
        if (i2 == 0) {
            String ax = ax(asVar2);
            if (Util.isNullOrNil(ax)) {
                Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", asVar2.field_username, Integer.valueOf(i2));
                aVar.yuS.setVisibility(8);
            } else {
                aVar.yuS.setVisibility(0);
                aVar.yuS.setText(ax);
                aVar.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i2 + 1) == null) {
                aVar.PUk.setBackgroundResource(0);
            }
        } else if (i2 <= 0 || asVar2.field_showHead == i3) {
            aVar.yuS.setVisibility(8);
            a(aVar, i2, i3);
        } else {
            String ax2 = ax(asVar2);
            aVar.PUk.setBackgroundResource(R.drawable.qa);
            if (Util.isNullOrNil(ax2)) {
                Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", asVar2.field_username, Integer.valueOf(i2));
                aVar.yuS.setVisibility(8);
            } else {
                aVar.yuS.setVisibility(0);
                aVar.yuS.setText(ax2);
                if (asVar2.field_showHead == 32) {
                    aVar.yuS.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bi5, 0, 0, 0);
                    aVar.yuS.setCompoundDrawablePadding(2);
                } else {
                    aVar.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i2, i3);
        }
        aVar.gwR.setTextColor(com.tencent.mm.cb.a.m(this.gte, !ab.JE(asVar2.field_username) ? R.color.a0b : R.color.a0c));
        ImageView imageView = (ImageView) aVar.gAN.getContentView();
        a.b.c(imageView, asVar2.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.KfF != null) {
            this.KfF.a(aVar3);
        }
        aVar.gAN.setMaskDrawable(null);
        try {
            if (ab.Iz(asVar2.field_username)) {
                ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(this.gte, aVar.gwR, aa.getDisplayName(asVar2.field_username));
            } else {
                aVar.gwR.setText(l.e((Context) this.gte, (CharSequence) aa.getDisplayName(asVar2.field_username), (int) aVar.gwR.getTextSize()));
            }
        } catch (Exception e2) {
            aVar.gwR.setText("");
        }
        AppMethodBeat.o(37687);
        return view;
    }

    private void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(37688);
        as asVar = (as) getItem(i2 + 1);
        if (asVar == null || (asVar.field_showHead != i3 && !Util.isNullOrNil(ax(asVar)))) {
            aVar.PUk.setBackgroundResource(0);
        }
        AppMethodBeat.o(37688);
    }

    private String ax(as asVar) {
        AppMethodBeat.i(37689);
        if (asVar.field_showHead == 31) {
            AppMethodBeat.o(37689);
            return "";
        } else if (asVar.field_showHead == 43) {
            String string = this.gte.getString(R.string.g7f);
            AppMethodBeat.o(37689);
            return string;
        } else {
            String valueOf = String.valueOf((char) asVar.field_showHead);
            AppMethodBeat.o(37689);
            return valueOf;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ as a(as asVar, Cursor cursor) {
        AppMethodBeat.i(37690);
        bg.aVF();
        as bjF = com.tencent.mm.model.c.aSN().bjF(as.p(cursor));
        if (bjF == null) {
            bjF = new as();
            bjF.convertFrom(cursor);
            bg.aVF();
            com.tencent.mm.model.c.aSN().am(bjF);
        }
        AppMethodBeat.o(37690);
        return bjF;
    }
}
