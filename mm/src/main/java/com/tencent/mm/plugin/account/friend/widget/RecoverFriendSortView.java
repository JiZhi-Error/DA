package com.tencent.mm.plugin.account.friend.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ns;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.e;
import java.util.LinkedList;

public class RecoverFriendSortView extends BaseSortView {
    public String kgb;

    public RecoverFriendSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View inflate() {
        AppMethodBeat.i(184461);
        View inflate = View.inflate(getContext(), R.layout.bm2, this);
        AppMethodBeat.o(184461);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(184462);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.i2i);
        AppMethodBeat.o(184462);
        return verticalScrollBar;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public ListView getListView() {
        AppMethodBeat.i(184463);
        ListView listView = (ListView) findViewById(R.id.ecx);
        AppMethodBeat.o(184463);
        return listView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public View getNoResultView() {
        AppMethodBeat.i(184464);
        View findViewById = findViewById(R.id.fzz);
        AppMethodBeat.o(184464);
        return findViewById;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final boolean a(String str, d dVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public c.a getItemViewCreator() {
        AppMethodBeat.i(184465);
        AnonymousClass1 r0 = new c.a() {
            /* class com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.sortview.c.a
            public final View a(d dVar, View view, int i2, boolean z, boolean z2) {
                final a aVar;
                AppMethodBeat.i(184460);
                if (view == null) {
                    view = View.inflate(RecoverFriendSortView.this.getContext(), R.layout.bm0, null);
                    aVar = new a();
                    aVar.gyr = (ImageView) view.findViewById(R.id.da9);
                    aVar.kib = (TextView) view.findViewById(R.id.dat);
                    aVar.kcY = (TextView) view.findViewById(R.id.apx);
                    aVar.kic = (TextView) view.findViewById(R.id.das);
                    aVar.keD = (TextView) view.findViewById(R.id.gx);
                    aVar.kid = (Button) view.findViewById(R.id.gn);
                } else {
                    aVar = (a) view.getTag();
                }
                au.a aVar2 = (au.a) dVar.data;
                aVar.kie = aVar2;
                a.b.c(aVar.gyr, aVar2.kfY.field_encryptUsername);
                aVar.kib.setText(l.c(view.getContext(), aVar2.kfY.field_nickname));
                if (aVar2.kfZ == null || Util.isNullOrNil(aVar2.kfZ.field_msgContent)) {
                    aVar.kic.setVisibility(8);
                } else {
                    aVar.kic.setVisibility(0);
                    aVar.kib.setText(l.c(view.getContext(), aVar2.kfZ.field_msgContent));
                }
                if (!RecoverFriendSortView.this.OZW || !z) {
                    aVar.kcY.setVisibility(8);
                } else {
                    aVar.kcY.setText(dVar.Pae);
                    aVar.kcY.setVisibility(0);
                }
                if ((!Util.isNullOrNil(aVar2.kfY.field_encryptUsername) && ab.IS(aVar2.kfY.field_encryptUsername)) || (!Util.isNullOrNil(aVar2.kfY.field_username) && ab.IS(aVar2.kfY.field_username))) {
                    aVar.keD.setVisibility(0);
                    aVar.keD.setText(R.string.h9);
                    aVar.kid.setVisibility(8);
                } else if (aVar2.kfY.field_addState == 1) {
                    aVar.keD.setVisibility(0);
                    aVar.keD.setText(R.string.dj3);
                    aVar.kid.setVisibility(8);
                } else {
                    aVar.keD.setVisibility(8);
                    aVar.kid.setVisibility(0);
                    aVar.kid.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(184459);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            ns nsVar = new ns();
                            nsVar.eqm = 4;
                            nsVar.AR(z.aUb());
                            nsVar.AQ(RecoverFriendSortView.this.kgb);
                            nsVar.AS(aVar.kie.kfY.field_encryptUsername);
                            nsVar.bfK();
                            com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(RecoverFriendSortView.this.getContext(), new a.AbstractC2025a() {
                                /* class com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                                public final void a(boolean z, boolean z2, String str, String str2) {
                                    as asVar;
                                    AppMethodBeat.i(184457);
                                    Log.i("MicroMsg.RecoverFriendSortView", "canAddContact %s,%s", str, Boolean.valueOf(z));
                                    if (z) {
                                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(aVar.kie.kfY.field_encryptUsername);
                                        if (((int) Kn.gMZ) == 0) {
                                            if (!Util.isNullOrNil(str)) {
                                                Kn.setUsername(str);
                                            } else {
                                                Kn.setUsername(aVar.kie.kfY.field_encryptUsername);
                                            }
                                            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ap(Kn);
                                            asVar = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(Kn.field_username);
                                        } else {
                                            asVar = Kn;
                                        }
                                        if (((int) asVar.gMZ) <= 0) {
                                            Log.e("MicroMsg.RecoverFriendSortView", "addContact : insert contact failed");
                                            AppMethodBeat.o(184457);
                                            return;
                                        }
                                        ab.B(asVar);
                                        h.cD(RecoverFriendSortView.this.getContext(), RecoverFriendSortView.this.getContext().getString(R.string.h9));
                                        au.aI(aVar.kie.kfY.field_encryptUsername, 0);
                                        RecoverFriendSortView.this.refresh();
                                        AppMethodBeat.o(184457);
                                        return;
                                    }
                                    if (z2) {
                                        au.aI(aVar.kie.kfY.field_encryptUsername, 1);
                                        RecoverFriendSortView.this.refresh();
                                    }
                                    AppMethodBeat.o(184457);
                                }
                            });
                            aVar.beC(aVar.kie.kfY.field_ticket);
                            LinkedList<Integer> linkedList = new LinkedList<>();
                            linkedList.add(17);
                            aVar.Kea = new a.b() {
                                /* class com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                @Override // com.tencent.mm.pluginsdk.ui.applet.a.b
                                public final boolean aE(String str, int i2) {
                                    AppMethodBeat.i(184458);
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", aVar.kie.kfY.field_encryptUsername);
                                    intent.putExtra("Contact_Nick", aVar.kie.kfY.field_nickname);
                                    intent.putExtra("Contact_Scene", 17);
                                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                                    intent.putExtra("sayhi_with_sns_perm_set_label", false);
                                    intent.putExtra(e.d.OyT, aVar.kie.kfY.field_ticket);
                                    intent.putExtra("sayhi_verify_add_errcode", i2);
                                    int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                                    int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                                    String str2 = ".ui.SayHiWithSnsPermissionUI";
                                    if (!as.bjp(aVar.kie.kfY.field_encryptUsername) && a2 == 1) {
                                        str2 = ".ui.SayHiWithSnsPermissionUI2";
                                    } else if (!as.bjp(aVar.kie.kfY.field_encryptUsername) && a2 == 2 && ab.aVc() >= a3) {
                                        str2 = ".ui.SayHiWithSnsPermissionUI3";
                                    }
                                    com.tencent.mm.br.c.b(RecoverFriendSortView.this.getContext(), Scopes.PROFILE, str2, intent);
                                    AppMethodBeat.o(184458);
                                    return true;
                                }
                            };
                            aVar.h(aVar.kie.kfY.field_encryptUsername, linkedList);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/widget/RecoverFriendSortView$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(184459);
                        }
                    });
                }
                view.setTag(aVar);
                AppMethodBeat.o(184460);
                return view;
            }
        };
        AppMethodBeat.o(184465);
        return r0;
    }

    class a {
        ImageView gyr;
        TextView kcY;
        TextView keD;
        TextView kib;
        TextView kic;
        Button kid;
        au.a kie;

        a() {
        }
    }
}
