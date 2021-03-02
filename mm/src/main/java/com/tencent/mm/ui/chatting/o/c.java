package com.tencent.mm.ui.chatting.o;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c extends b {
    public c(b.AbstractC1472b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final String eiT() {
        return "link_revoke_unbindapp";
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final CharSequence b(final Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(233526);
        String str2 = map.get(str + ".title");
        final String str3 = map.get(str + ".username");
        final String str4 = map.get(str + ".appid");
        final String str5 = map.get(str + ".appname");
        final String str6 = map.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.memberlist.member.nickname");
        final String string = bundle.getString("conv_talker_username");
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new a() {
            /* class com.tencent.mm.ui.chatting.o.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                AppMethodBeat.i(233523);
                final Context context = (Context) weakReference.get();
                if (context == null) {
                    AppMethodBeat.o(233523);
                    return;
                }
                final e eVar = new e(context, 1, true);
                eVar.j(Util.safeFormatString(context.getString(R.string.av8), str6, str5), 17, com.tencent.mm.cb.a.fromDPToPix(context, 14));
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.ui.chatting.o.c.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(233521);
                        mVar.d(100, context.getResources().getString(R.string.g72));
                        mVar.d(101, Util.safeFormatString(context.getResources().getString(R.string.av7), str5));
                        AppMethodBeat.o(233521);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.ui.chatting.o.c.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(233522);
                        eVar.bMo();
                        switch (menuItem.getItemId()) {
                            case 100:
                                c cVar = c.this;
                                String str = str3;
                                LinkedList<String> linkedList = new LinkedList<>();
                                linkedList.add(str);
                                cVar.a(-1, linkedList, 0);
                                AppMethodBeat.o(233522);
                                return;
                            case 101:
                                c cVar2 = c.this;
                                Context context = context;
                                String str2 = str4;
                                String str3 = str5;
                                String str4 = string;
                                e eVar = new e(context, 1, true);
                                eVar.j(Util.safeFormatString(context.getString(R.string.av4, str3), new Object[0]), 17, com.tencent.mm.cb.a.fromDPToPix(context, 14));
                                eVar.HLX = new o.f(context) {
                                    /* class com.tencent.mm.ui.chatting.o.c.AnonymousClass2 */
                                    final /* synthetic */ Context val$context;

                                    {
                                        this.val$context = r2;
                                    }

                                    @Override // com.tencent.mm.ui.base.o.f
                                    public final void onCreateMMMenu(m mVar) {
                                        AppMethodBeat.i(233524);
                                        mVar.a(101, this.val$context.getResources().getColor(R.color.a5e), this.val$context.getString(R.string.av2));
                                        AppMethodBeat.o(233524);
                                    }
                                };
                                eVar.HLY = new o.g(str2, str4, context, eVar) {
                                    /* class com.tencent.mm.ui.chatting.o.c.AnonymousClass3 */
                                    final /* synthetic */ String PFZ;
                                    final /* synthetic */ e gwC;
                                    final /* synthetic */ String val$appId;
                                    final /* synthetic */ Context val$context;

                                    {
                                        this.val$appId = r2;
                                        this.PFZ = r3;
                                        this.val$context = r4;
                                        this.gwC = r5;
                                    }

                                    @Override // com.tencent.mm.ui.base.o.g
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                        AppMethodBeat.i(233525);
                                        if (menuItem.getItemId() == 101) {
                                            c.b bVar = new c.b();
                                            bVar.appId = this.val$appId;
                                            bVar.zqa = this.PFZ;
                                            bVar.zqc = 2;
                                            ((com.tencent.mm.plugin.messenger.foundation.a.c) g.af(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(this.val$context, bVar, new c.AbstractC1475c() {
                                                /* class com.tencent.mm.ui.chatting.o.c.AnonymousClass3.AnonymousClass1 */

                                                @Override // com.tencent.mm.plugin.messenger.foundation.a.c.AbstractC1475c
                                                public final void f(boolean z, String str) {
                                                }
                                            });
                                            this.gwC.bMo();
                                        }
                                        AppMethodBeat.o(233525);
                                    }
                                };
                                eVar.dGm();
                                break;
                        }
                        AppMethodBeat.o(233522);
                    }
                };
                eVar.dGm();
                ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", map, bundle);
                AppMethodBeat.o(233523);
            }
        }, 0, str2.length(), 33);
        AppMethodBeat.o(233526);
        return spannableString;
    }
}
