package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.df;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends b {
    private IListener OAS;
    View Qif;
    int showFlag;

    public j(final Context context) {
        super(context);
        AppMethodBeat.i(38794);
        this.Qif = View.inflate(context, R.layout.aw6, null);
        if (this.Qif == null) {
            AppMethodBeat.o(38794);
            return;
        }
        this.showFlag = Util.getInt(h.aqJ().getValue("InviteFriendsControlFlags"), 0);
        this.Qif.setVisibility(8);
        this.Qif.setPadding(0, -a.fromDPToPix(context, (int) R.dimen.iq), 0, 0);
        if ((this.showFlag & 1) > 0) {
            this.Qif.setVisibility(0);
            this.Qif.setPadding(0, 0, 0, 0);
        }
        this.Qif.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.conversation.a.j.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(38791);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Invite_friends", 1);
                c.b(context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14034, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(38791);
            }
        });
        this.OAS = new IListener<df>() {
            /* class com.tencent.mm.ui.conversation.a.j.AnonymousClass2 */

            {
                AppMethodBeat.i(161577);
                this.__eventId = df.class.getName().hashCode();
                AppMethodBeat.o(161577);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(df dfVar) {
                AppMethodBeat.i(38793);
                Log.i("MicroMsg.InviteFriendBanner", "dynamic config file change");
                j.this.showFlag = Util.getInt(h.aqJ().getValue("InviteFriendsControlFlags"), 0);
                if ((j.this.showFlag & 1) > 0) {
                    j.this.Qif.post(new Runnable() {
                        /* class com.tencent.mm.ui.conversation.a.j.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(38792);
                            j.this.Qif.setVisibility(0);
                            j.this.Qif.setPadding(0, 0, 0, 0);
                            AppMethodBeat.o(38792);
                        }
                    });
                }
                AppMethodBeat.o(38793);
                return true;
            }
        };
        AppMethodBeat.o(38794);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(38795);
        EventCenter.instance.addListener(this.OAS);
        if (this.Qif == null || this.Qif.getVisibility() != 0) {
            AppMethodBeat.o(38795);
            return false;
        }
        AppMethodBeat.o(38795);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void release() {
        AppMethodBeat.i(38796);
        EventCenter.instance.removeListener(this.OAS);
        AppMethodBeat.o(38796);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b, com.tencent.mm.pluginsdk.ui.b.a
    public final View getView() {
        return this.Qif;
    }
}
