package com.tencent.mm.plugin.sns.ui.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.contact.a.a;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static final Pattern ESG = Pattern.compile(";");
    public CharSequence ESH;
    private b ESI = new b();
    C1734a ESJ = new C1734a();
    public View.OnClickListener ESo = null;
    public CharSequence hXr;
    public CharSequence jVL;
    public m lqW;
    public String username;

    static {
        AppMethodBeat.i(99837);
        AppMethodBeat.o(99837);
    }

    public a(int i2) {
        super(4, i2);
        AppMethodBeat.i(99835);
        AppMethodBeat.o(99835);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(99833);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bx1, viewGroup, false);
            C1734a aVar = a.this.ESJ;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.hwy);
            aVar.gvw = (TextView) inflate.findViewById(R.id.hx3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.hwz);
            aVar.jBR.setVisibility(8);
            aVar.xcs = (TextView) inflate.findViewById(R.id.hx2);
            aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hx1);
            aVar.EFD = (ImageView) inflate.findViewById(R.id.hx0);
            aVar.EFD.setImageDrawable(ar.m(context, R.raw.sns_label_more_btn, context.getResources().getColor(R.color.BW_50)));
            aVar.EFD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.a.a.a.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(99832);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.ESo != null) {
                        a.this.ESo.onClick(view);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/adapter/data/SnsSelectChatRoomDataItem$SnsChatRoomViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99832);
                }
            });
            inflate.setTag(aVar);
            AppMethodBeat.o(99833);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(99834);
            C1734a aVar3 = (C1734a) aVar;
            a aVar4 = (a) aVar2;
            if (aVar4.username == null || aVar4.username.length() <= 0) {
                aVar3.gvv.setImageResource(R.drawable.bca);
            } else {
                a.b.a(aVar3.gvv, aVar4.username, 0.1f, false);
            }
            n.a(aVar4.jVL, aVar3.gvw);
            if (ab.Iz(aVar4.username)) {
                Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                aVar3.gvw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            } else {
                aVar3.gvw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            n.a(aVar4.hXr, aVar3.jBR);
            n.a(aVar4.ESH, aVar3.xcs);
            if (a.this.PWh) {
                if (z) {
                    aVar3.jVQ.setChecked(true);
                    aVar3.jVQ.setEnabled(false);
                    aVar3.jVQ.setBackgroundResource(ao.isDarkMode() ? R.raw.checkbox_selected_grey_dark : R.raw.checkbox_selected_grey);
                } else {
                    aVar3.jVQ.setChecked(z2);
                    aVar3.jVQ.setEnabled(true);
                }
                aVar3.jVQ.setVisibility(0);
            } else {
                aVar3.jVQ.setVisibility(8);
            }
            aVar3.EFD.setTag(a.this.contact);
            AppMethodBeat.o(99834);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.ui.contact.a.a aVar) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.a.a.a$a  reason: collision with other inner class name */
    public class C1734a extends a.C2110a {
        public ImageView EFD;
        public ImageView gvv;
        public TextView gvw;
        public TextView jBR;
        public CheckBox jVQ;
        public TextView xcs;

        public C1734a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        String[] strArr;
        CharSequence charSequence = null;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.i(99836);
        if (this.lqW != null) {
            if (this.contact == null) {
                g.aAi();
                this.contact = ((l) g.af(l.class)).aSN().bjF(this.lqW.wVX);
                if (this.contact == null) {
                    g.aAi();
                    this.contact = ((l) g.af(l.class)).aSN().bjK(this.lqW.wVX);
                    z = true;
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (this.contact == null) {
            this.jVL = "";
            AppMethodBeat.o(99836);
            return;
        }
        this.username = this.contact.field_username;
        if (z) {
            m mVar = this.lqW;
            as asVar = this.contact;
            Resources resources = context.getResources();
            String b2 = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(asVar, asVar.field_username);
            switch (mVar.wVW) {
                case 1:
                case 5:
                    z2 = false;
                    z3 = false;
                    resources.getString(R.string.gg4);
                    break;
                case 3:
                case 7:
                    z5 = true;
                case 2:
                case 6:
                    z2 = z5;
                    z3 = true;
                    resources.getString(R.string.gg4);
                    break;
                case 38:
                    g.aAi();
                    Cursor rawQuery = g.aAh().hqK.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{asVar.field_username}, 2);
                    if (rawQuery.moveToFirst()) {
                        String string = rawQuery.getString(0);
                        rawQuery.close();
                        strArr = string == null ? null : ESG.split(string);
                    } else {
                        rawQuery.close();
                        strArr = null;
                    }
                    if (strArr != null && strArr.length > 0) {
                        this.ESH = "(" + strArr.length + ")";
                    }
                    if (!(strArr == null || mVar.wXl == null)) {
                        charSequence = TextUtils.concat(resources.getString(R.string.gg2), n.a(context, mVar.wXl, strArr, this.wWd, b.c.wZY));
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        break;
                    }
                default:
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    break;
            }
            if (z4) {
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) b2, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
                this.jVL = f.a(e.a(this.jVL, this.wWd, z3, z2)).wWu;
            } else {
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) b2, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
            }
            this.hXr = charSequence;
            AppMethodBeat.o(99836);
            return;
        }
        this.jVL = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact, this.contact.field_username);
        if (this.lqW != null) {
            this.ESH = "(" + this.lqW.wXe + ")";
        }
        AppMethodBeat.o(99836);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.ESI;
    }
}
