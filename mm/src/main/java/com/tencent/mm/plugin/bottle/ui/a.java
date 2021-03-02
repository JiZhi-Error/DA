package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.s;

/* access modifiers changed from: package-private */
public final class a extends s<az> implements MStorageEx.IOnStorageChange {
    private final MMActivity gte;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.f pla;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

    /* renamed from: com.tencent.mm.plugin.bottle.ui.a$a  reason: collision with other inner class name */
    public static class C0859a {
        public ImageView gvv;
        public TextView gvw;
        public ImageView ooE;
        public TextView pld;
        public TextView ple;
        public TextView plf;
        public View plg;
        public TextView plh;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(22663);
        az azVar2 = azVar;
        if (azVar2 == null) {
            azVar2 = new az();
        }
        azVar2.Cm("");
        azVar2.Cn("");
        azVar2.convertFrom(cursor);
        AppMethodBeat.o(22663);
        return azVar2;
    }

    public a(Context context, s.a aVar) {
        super(context, new az());
        AppMethodBeat.i(22656);
        super.a(aVar);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(22656);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(22657);
        bg.aVF();
        setCursor(c.aST().gCx());
        if (this.OFI != null) {
            this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(22657);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.pla = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    public final int getItemViewType(int i2) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.i(22658);
        if (this.plb != null) {
            this.plb.ebo();
        }
        AppMethodBeat.o(22658);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        C0859a aVar;
        int i3;
        AppMethodBeat.i(22659);
        az azVar = (az) getItem(i2);
        if (view == null) {
            C0859a aVar2 = new C0859a();
            MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.gte, R.layout.is, null);
            View inflate = View.inflate(this.gte, R.layout.c3g, null);
            aVar2.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar2.gvw = (TextView) inflate.findViewById(R.id.fzg);
            aVar2.pld = (TextView) inflate.findViewById(R.id.j0l);
            aVar2.ple = (TextView) inflate.findViewById(R.id.e7t);
            aVar2.ooE = (ImageView) inflate.findViewById(R.id.i4v);
            aVar2.plf = (TextView) inflate.findViewById(R.id.iot);
            aVar2.plg = mMSlideDelView.findViewById(R.id.hsk);
            aVar2.plh = (TextView) mMSlideDelView.findViewById(R.id.hsm);
            mMSlideDelView.setView(inflate);
            mMSlideDelView.setPerformItemClickListener(this.pkY);
            mMSlideDelView.setGetViewPositionCallback(this.pkZ);
            mMSlideDelView.setItemStatusCallBack(this.plb);
            mMSlideDelView.setEnable(false);
            mMSlideDelView.setTag(aVar2);
            aVar = aVar2;
            view = mMSlideDelView;
        } else {
            aVar = (C0859a) view.getTag();
        }
        bg.aVF();
        aVar.gvw.setText(S(c.aSN().Kn(azVar.field_username)));
        aVar.pld.setText(azVar.field_status == 1 ? this.gte.getString(R.string.evg) : f.c(this.gte, azVar.field_conversationTime, true));
        a.b.c(aVar.gvv, as.bjz(azVar.field_username));
        bg.aVF();
        aVar.ple.setText(l.b(this.gte, c.aST().Xh().a(azVar.field_isSend, azVar.field_username, azVar.field_content, ahn(azVar.field_msgType), this.gte), aVar.ple.getTextSize()));
        aVar.ple.setTextColor(com.tencent.mm.cb.a.m(this.gte, R.color.a0f));
        if (ahn(azVar.field_msgType) == 34 && azVar.field_isSend == 0 && !Util.isNullOrNil(azVar.field_content) && !new p(azVar.field_content).jsi) {
            aVar.ple.setTextColor(com.tencent.mm.cb.a.m(this.gte, R.color.a0g));
        }
        switch (azVar.field_status) {
            case 0:
                i3 = -1;
                break;
            case 1:
                i3 = R.raw.msg_state_sending;
                break;
            case 2:
                i3 = -1;
                break;
            case 3:
            case 4:
            default:
                i3 = -1;
                break;
            case 5:
                i3 = R.raw.msg_state_failed;
                break;
        }
        if (i3 != -1) {
            aVar.ooE.setBackgroundResource(i3);
            aVar.ooE.setVisibility(0);
        } else {
            aVar.ooE.setVisibility(8);
        }
        aVar.plg.setTag(azVar.field_username);
        aVar.plg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.bottle.ui.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(22655);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
                a.this.plb.ebp();
                if (a.this.pla != null) {
                    a.this.pla.cZ(view.getTag());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22655);
            }
        });
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (azVar.field_unReadCount > 100) {
            aVar.plf.setText("...");
            aVar.plf.setVisibility(0);
            Log.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (azVar.field_unReadCount > 0) {
            aVar.plf.setText(new StringBuilder().append(azVar.field_unReadCount).toString());
            aVar.plf.setVisibility(0);
            Log.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.plf.setVisibility(4);
            Log.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(R.drawable.b6c);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        AppMethodBeat.o(22659);
        return view;
    }

    /* access modifiers changed from: package-private */
    public final String S(as asVar) {
        AppMethodBeat.i(22660);
        String a2 = com.tencent.mm.plugin.bottle.a.c.a(this.gte, asVar);
        AppMethodBeat.o(22660);
        return a2;
    }

    private static int ahn(String str) {
        int i2 = 1;
        AppMethodBeat.i(22661);
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(22661);
        return i2;
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(22662);
        anp();
        AppMethodBeat.o(22662);
    }
}
