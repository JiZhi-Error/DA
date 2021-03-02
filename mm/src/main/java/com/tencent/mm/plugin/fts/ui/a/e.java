package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;

public final class e extends k {
    public int count;
    public CharSequence jVL;
    public String talker;
    private a xcF = new a();
    b xcG = new b();

    public e(int i2) {
        super(i2);
        AppMethodBeat.i(112064);
        AppMethodBeat.o(112064);
    }

    public class a extends a.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112062);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an4, viewGroup, false);
            b bVar = e.this.xcG;
            bVar.xcJ = inflate.findViewById(R.id.dp2);
            bVar.qqq = (TextView) inflate.findViewById(R.id.dp0);
            bVar.xcK = inflate.findViewById(R.id.g8b);
            bVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            bVar.gvw = (TextView) inflate.findViewById(R.id.fzg);
            inflate.setTag(bVar);
            AppMethodBeat.o(112062);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(final Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112063);
            b bVar = (b) aVar;
            n.b(e.this.header, bVar.qqq);
            a.b.c(bVar.gvv, e.this.talker);
            n.a(e.this.jVL, bVar.gvw);
            bVar.xcJ.setBackgroundResource(R.drawable.qa);
            bVar.xcJ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fts.ui.a.e.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(235398);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ab.JB(e.this.talker)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", e.this.talker);
                        intent.putExtra("app_brand_conversation_from_scene", 1);
                        intent.addFlags(67108864);
                        c.f(context, ".ui.conversation.AppBrandServiceConversationUI", intent);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", e.this.talker);
                        intent2.putExtra("finish_direct", true);
                        c.f(context, ".ui.chatting.ChattingUI", intent2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235398);
                }
            });
            AppMethodBeat.o(112063);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class b extends a.AbstractC1374a {
        public ImageView gvv;
        public TextView gvw;
        public TextView qqq;
        public View xcJ;
        public View xcK;

        public b() {
            super();
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.k
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112065);
        this.header = context.getString(R.string.ggt, Integer.valueOf(this.count));
        this.jVL = l.d(context, d.arL(this.talker), ((b) aVar).gvw.getTextSize());
        AppMethodBeat.o(112065);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.k
    public final a.b axc() {
        return this.xcF;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a.k
    public final a.AbstractC1374a dPz() {
        return this.xcG;
    }
}
