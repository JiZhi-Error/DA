package com.tencent.mm.ui.chatting.o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a extends b {
    public a(b.AbstractC1472b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final String eiT() {
        return "link_profile";
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final CharSequence b(final Map<String, String> map, String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(233517);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String nullAs = Util.nullAs(map.get(str + ".separator"), "、");
        int i2 = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i2 != 0 ? Integer.valueOf(i2) : "");
            if (map.get(str2) != null) {
                if (i2 != 0) {
                    spannableStringBuilder.append((CharSequence) nullAs);
                }
                final String str3 = map.get(str2 + ".username");
                String str4 = map.get(str2 + ".nickname");
                final String str5 = map.get(str2 + ".antispam_ticket");
                if (Util.isNullOrNil(str3) || Util.isNullOrNil(str4)) {
                    Log.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
                } else {
                    SpannableString c2 = l.c(MMApplicationContext.getContext(), str4);
                    c2.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                        /* class com.tencent.mm.ui.chatting.o.a.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.messenger.a.a
                        public final void onClickImp(View view) {
                            AppMethodBeat.i(233516);
                            ((e) g.af(e.class)).a("link_profile", map, bundle);
                            if (!(weakReference == null || weakReference.get() == null)) {
                                long j2 = bundle.getLong("msg_id");
                                String string = bundle.getString("conv_talker_username", null);
                                if (ab.Eq(string)) {
                                    a.a((Context) weakReference.get(), str3, string, str5, j2);
                                    AppMethodBeat.o(233516);
                                    return;
                                }
                                a.a((Context) weakReference.get(), str3, null, str5, j2);
                            }
                            AppMethodBeat.o(233516);
                        }
                    }, 0, str4.length(), 33);
                    spannableStringBuilder.append((CharSequence) c2);
                }
                i2++;
            } else {
                AppMethodBeat.o(233517);
                return spannableStringBuilder;
            }
        }
    }

    static /* synthetic */ void a(Context context, String str, String str2, String str3, long j2) {
        AppMethodBeat.i(233518);
        if (context != null && !Util.isNullOrNil(str)) {
            h.INSTANCE.a(14516, 1, 0, 0, 0);
            Intent putExtra = new Intent().putExtra("Contact_User", str);
            putExtra.putExtra("Contact_ChatRoomId", str2);
            putExtra.putExtra(e.d.OyT, str3);
            putExtra.putExtra("room_name", str2);
            putExtra.putExtra("Contact_Scene", 14);
            putExtra.putExtra("key_msg_id", j2);
            c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", putExtra);
        }
        AppMethodBeat.o(233518);
    }
}
