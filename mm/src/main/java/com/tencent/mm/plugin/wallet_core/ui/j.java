package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f;
import java.util.HashMap;
import java.util.List;

public final class j {
    public static void a(Context context, List<Bankcard> list, Bankcard bankcard, String str, String str2, boolean z, String str3, o.g gVar) {
        AppMethodBeat.i(70721);
        e eVar = new e(context, 2, true);
        eVar.HLX = new o.f(list, context, new HashMap(), eVar, false, z, str3) {
            /* class com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass1 */
            final /* synthetic */ List HvP;
            final /* synthetic */ HashMap Idh;
            final /* synthetic */ e Idi;
            final /* synthetic */ boolean Idj = false;
            final /* synthetic */ boolean Idk;
            final /* synthetic */ String Idl;
            final /* synthetic */ Context val$context;

            {
                this.HvP = r2;
                this.val$context = r3;
                this.Idh = r4;
                this.Idi = r5;
                this.Idk = r7;
                this.Idl = r8;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(final m mVar) {
                final String str;
                SpannableStringBuilder spannableStringBuilder;
                String str2;
                AppMethodBeat.i(70720);
                int i2 = 0;
                for (final Bankcard bankcard : this.HvP) {
                    com.tencent.mm.plugin.wallet_core.model.e eVar = null;
                    if (bankcard.fQc()) {
                        Bankcard bankcard2 = t.fQI().IbQ;
                        if (bankcard2 != null) {
                            eVar = bankcard2.HVM;
                        }
                    } else {
                        eVar = b.j(this.val$context, bankcard.field_bankcardType, bankcard.fQa());
                    }
                    if (eVar != null) {
                        str = eVar.AAU;
                    } else {
                        str = "";
                    }
                    Log.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", str);
                    Bitmap a2 = u.a(new c(str));
                    u.a(new u.a() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.platformtools.u.a
                        public final void k(final String str, final Bitmap bitmap) {
                            AppMethodBeat.i(70718);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(70717);
                                    Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                    if (AnonymousClass1.this.Idh.containsKey(str)) {
                                        int intValue = ((Integer) AnonymousClass1.this.Idh.get(str)).intValue();
                                        if (mVar.getItem(intValue) != null) {
                                            mVar.getItem(intValue).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(bitmap, MMApplicationContext.getResources().getDimensionPixelOffset(R.dimen.aov), MMApplicationContext.getResources().getDimensionPixelOffset(R.dimen.aov), true, false)));
                                            AnonymousClass1.this.Idi.fPw();
                                        }
                                    }
                                    AppMethodBeat.o(70717);
                                }
                            });
                            AppMethodBeat.o(70718);
                        }
                    });
                    String str3 = "";
                    if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                        str3 = bankcard.field_forbidWord;
                    }
                    if (Util.isNullOrNil(bankcard.field_forbid_title)) {
                        spannableStringBuilder = new SpannableStringBuilder(str3);
                        str2 = str3;
                    } else {
                        String str4 = str3 + " ";
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str4 + bankcard.field_forbid_title);
                        AnonymousClass2 r3 = new l(this.val$context) {
                            /* class com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass1.AnonymousClass2 */

                            @Override // com.tencent.mm.plugin.wallet_core.ui.l
                            public final void onClick(View view) {
                                AppMethodBeat.i(70719);
                                Intent intent = new Intent();
                                String str = bankcard.field_forbid_url;
                                Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", str);
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("geta8key_username", z.aTY());
                                intent.putExtra("pay_channel", 1);
                                f.aA(AnonymousClass1.this.val$context, intent);
                                AppMethodBeat.o(70719);
                            }
                        };
                        int length = str4.length();
                        int length2 = str4.length() + bankcard.field_forbid_title.length();
                        spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(R.color.ael)), length, length2, 33);
                        spannableStringBuilder2.setSpan(r3, length, length2, 33);
                        spannableStringBuilder = spannableStringBuilder2;
                        str2 = str4;
                    }
                    if (this.Idj && Util.isNullOrNil(spannableStringBuilder) && !Util.isNullOrNil(bankcard.field_fetchArriveTimeWording)) {
                        spannableStringBuilder = new SpannableStringBuilder(bankcard.field_fetchArriveTimeWording);
                    }
                    if (!Util.isNullOrNil(spannableStringBuilder) && !Util.isNullOrNil(bankcard.field_prompt_info_prompt_text)) {
                        spannableStringBuilder = new SpannableStringBuilder(bankcard.field_prompt_info_prompt_text);
                        if (!Util.isNullOrNil(bankcard.field_prompt_info_jump_text) && !Util.isNullOrNil(bankcard.field_prompt_info_jump_url)) {
                            spannableStringBuilder.append((CharSequence) bankcard.field_prompt_info_jump_text);
                            spannableStringBuilder.setSpan(new q(new q.a() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass1.AnonymousClass3 */

                                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                                public final void dF(View view) {
                                    AppMethodBeat.i(214238);
                                    f.bn(AnonymousClass1.this.val$context, bankcard.field_prompt_info_jump_url);
                                    h.INSTANCE.a(20216, 4, bankcard.field_prompt_info_jump_url);
                                    AppMethodBeat.o(214238);
                                }
                            }), bankcard.field_prompt_info_prompt_text.length(), spannableStringBuilder.length(), 33);
                        }
                    }
                    CharSequence charSequence = bankcard.field_desc;
                    Bitmap extractThumbNail = a2 != null ? BitmapUtil.extractThumbNail(a2, this.val$context.getResources().getDimensionPixelOffset(R.dimen.aov), this.val$context.getResources().getDimensionPixelOffset(R.dimen.aov), true, false) : null;
                    if (extractThumbNail == null) {
                        this.Idh.put(str, Integer.valueOf(i2));
                    }
                    Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", Integer.valueOf(i2), charSequence, spannableStringBuilder);
                    if (bankcard.fQb()) {
                        int i3 = i2 + 1;
                        mVar.a(i2, charSequence, spannableStringBuilder, this.val$context.getResources().getDrawable(R.drawable.cqo), 0, !Util.isNullOrNil(str2));
                        i2 = i3;
                    } else {
                        int i4 = i2 + 1;
                        mVar.a(i2, charSequence, spannableStringBuilder, extractThumbNail == null ? null : new BitmapDrawable(extractThumbNail), 0, !Util.isNullOrNil(str2));
                        i2 = i4;
                    }
                }
                if (this.Idk && !Util.isNullOrNil(this.Idl)) {
                    mVar.a(i2, this.Idl, "", MMApplicationContext.getResources().getDrawable(R.drawable.cqi), false);
                }
                AppMethodBeat.o(70720);
            }
        };
        eVar.HLY = gVar;
        eVar.HMg = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.c7j, (ViewGroup) null);
        if (!Util.isNullOrNil(str)) {
            ((TextView) inflate.findViewById(R.id.a2w)).setText(str);
        }
        if (!Util.isNullOrNil(str2)) {
            ((TextView) inflate.findViewById(R.id.a2v)).setText(str2);
        } else {
            inflate.findViewById(R.id.a2v).setVisibility(8);
        }
        eVar.V(inflate, false);
        if (bankcard != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).field_bindSerial.equals(bankcard.field_bindSerial)) {
                    eVar.jKz = i2;
                }
            }
        }
        eVar.dGm();
        AppMethodBeat.o(70721);
    }
}
