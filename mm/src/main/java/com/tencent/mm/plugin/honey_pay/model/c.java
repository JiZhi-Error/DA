package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.honey_pay.a;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tav.coremedia.TimeUtil;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public final class c {
    public static String GO(long j2) {
        AppMethodBeat.i(64651);
        String bigDecimal = f.b(String.valueOf(j2), "100", 2, RoundingMode.HALF_UP).toString();
        AppMethodBeat.o(64651);
        return bigDecimal;
    }

    public static void a(MMActivity mMActivity, Bundle bundle, cal cal, final boolean z) {
        AppMethodBeat.i(64652);
        RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
        realnameGuideHelper.b(new StringBuilder().append(cal.KCl).toString(), cal.yXJ, cal.lHA, cal.lHB, cal.yXK, 0);
        bundle.putString("realname_verify_process_jump_plugin", "honey_pay");
        realnameGuideHelper.a(mMActivity, bundle, null, new d.a() {
            /* class com.tencent.mm.plugin.honey_pay.model.c.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.d.a
            public final Intent q(int i2, Bundle bundle) {
                AppMethodBeat.i(64647);
                if (z) {
                    h.INSTANCE.a(15191, 0, 0, 0, 0, 0, 0, 0, 0, 1);
                } else {
                    h.INSTANCE.a(15191, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
                }
                Intent intent = new Intent();
                AppMethodBeat.o(64647);
                return intent;
            }
        }, false);
        if (z) {
            h.INSTANCE.a(15191, 0, 0, 0, 0, 0, 0, 0, 1);
            AppMethodBeat.o(64652);
            return;
        }
        h.INSTANCE.a(15191, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
        AppMethodBeat.o(64652);
    }

    public static void a(final MMActivity mMActivity, final dpp dpp, final String str, final int i2, final eig eig) {
        AppMethodBeat.i(64653);
        if (!(dpp == null || dpp.MSO == null || dpp.MSO.isEmpty())) {
            AnonymousClass2 r0 = new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.honey_pay.model.c.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(64650);
                    e eVar = new e((Context) mMActivity, 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.honey_pay.model.c.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(64648);
                            int i2 = 0;
                            Iterator<cos> it = dpp.MSO.iterator();
                            while (it.hasNext()) {
                                cos next = it.next();
                                if (!Util.isNullOrNil(next.pqv)) {
                                    if (!Util.isNullOrNil(next.ixw)) {
                                        mVar.a(i2, g.cI(next.ixw, true), next.pqv);
                                    } else {
                                        mVar.d(i2, next.pqv);
                                    }
                                    i2++;
                                } else {
                                    i2 = i2;
                                }
                            }
                            AppMethodBeat.o(64648);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.honey_pay.model.c.AnonymousClass2.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(64649);
                            cos cos = dpp.MSO.get(i2);
                            if (!Util.isNullOrNil(cos.url)) {
                                if (!cos.url.equals("weixin://wcpay/honeypay/unbind") || Util.isNullOrNil(str) || eig == null) {
                                    f.p(mMActivity, cos.url, false);
                                } else {
                                    Log.i("MicroMsg.HoneyPayUtil", "go to unbind");
                                    Intent intent = new Intent(mMActivity, HoneyPayCheckPwdUI.class);
                                    intent.putExtra("key_scene", 3);
                                    intent.putExtra("key_card_no", str);
                                    try {
                                        intent.putExtra("key_toke_mess", eig.toByteArray());
                                    } catch (IOException e2) {
                                        Log.printErrStackTrace("MicroMsg.HoneyPayUtil", e2, "", new Object[0]);
                                    }
                                    mMActivity.startActivityForResult(intent, i2);
                                    AppMethodBeat.o(64649);
                                    return;
                                }
                            }
                            AppMethodBeat.o(64649);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(64650);
                    return false;
                }
            };
            if (!Util.isNullOrNil(dpp.title)) {
                mMActivity.addTextOptionMenu(0, dpp.title, R.color.afz, r0);
                AppMethodBeat.o(64653);
                return;
            }
            mMActivity.addIconOptionMenu(0, R.raw.actionbar_dark_icon_more, r0);
        }
        AppMethodBeat.o(64653);
    }

    public static void b(MMActivity mMActivity, dpp dpp, String str, int i2, eig eig) {
        AppMethodBeat.i(64654);
        a(mMActivity, dpp, str, i2, eig);
        AppMethodBeat.o(64654);
    }

    public static String W(String str, String str2, int i2) {
        AppMethodBeat.i(64656);
        if (i2 >= 0) {
            String replace = str.replace("$" + str2 + "$", f.hs(f.getDisplayName(str2), i2));
            AppMethodBeat.o(64656);
            return replace;
        }
        String replace2 = str.replace("$" + str2 + "$", f.getDisplayName(str2));
        AppMethodBeat.o(64656);
        return replace2;
    }

    public static int aB(int i2, boolean z) {
        AppMethodBeat.i(64657);
        if (z) {
            int i3 = -1;
            if (!ao.isDarkMode()) {
                if (i2 == 1) {
                    i3 = R.raw.honey_pay_disable_father_card_icon;
                } else if (i2 == 2) {
                    i3 = R.raw.honey_pay_disable_mother_card_icon;
                } else if (i2 == 3) {
                    i3 = R.raw.honey_pay_disable_child_card_icon;
                }
            } else if (i2 == 1) {
                i3 = R.raw.honey_pay_disable_father_card_icon_dm;
            } else if (i2 == 2) {
                i3 = R.raw.honey_pay_disable_mother_card_icon_dm;
            } else if (i2 == 3) {
                i3 = R.raw.honey_pay_disable_child_card_icon_dm;
            }
            AppMethodBeat.o(64657);
            return i3;
        }
        int OM = OM(i2);
        AppMethodBeat.o(64657);
        return OM;
    }

    public static int OM(int i2) {
        AppMethodBeat.i(182450);
        int i3 = -1;
        if (!ao.isDarkMode()) {
            if (i2 == 1) {
                i3 = R.raw.honey_pay_father_card_icon;
            } else if (i2 == 2) {
                i3 = R.raw.honey_pay_mother_card_icon;
            } else if (i2 == 3) {
                i3 = R.raw.honey_pay_child_card_icon;
            }
        } else if (i2 == 1) {
            i3 = R.raw.honey_pay_father_card_icon_dm;
        } else if (i2 == 2) {
            i3 = R.raw.honey_pay_mother_card_icon_dm;
        } else if (i2 == 3) {
            i3 = R.raw.honey_pay_child_card_icon_dm;
        }
        AppMethodBeat.o(182450);
        return i3;
    }

    public static int dYO() {
        AppMethodBeat.i(182451);
        if (!ao.isDarkMode()) {
            AppMethodBeat.o(182451);
            return R.raw.honey_pay_input_logo;
        }
        AppMethodBeat.o(182451);
        return R.raw.honey_pay_input_logo_dm;
    }

    public static void s(String str, String str2, String str3, String str4) {
        String str5;
        AppMethodBeat.i(64658);
        Log.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", str, Boolean.valueOf(Util.isNullOrNil(str2)));
        if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str)) {
            String W = W(str2, str3, 6);
            if (!Util.isNullOrNil(str4)) {
                str5 = W(W, str4, 6);
            } else {
                str5 = W;
            }
            a aVar = new a();
            aVar.field_payMsgId = str;
            a.dYM().dYN().get(aVar, new String[0]);
            if (aVar.field_msgId > 0) {
                Log.i("MicroMsg.HoneyPayUtil", "find msg: %s", Long.valueOf(aVar.field_msgId));
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(aVar.field_msgId);
                if (Hb.field_msgId > 0) {
                    Hb.setContent(str5);
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
                    AppMethodBeat.o(64658);
                    return;
                }
                Log.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", Long.valueOf(aVar.field_msgId));
            }
        }
        AppMethodBeat.o(64658);
    }

    public static String GP(long j2) {
        AppMethodBeat.i(64659);
        String format = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).format(new Date(1000 * j2));
        AppMethodBeat.o(64659);
        return format;
    }

    public static void a(Context context, cma cma, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(64655);
        com.tencent.mm.ui.base.h.a(context, cma.dQx, "", cma.lHB, cma.lHA, false, onClickListener, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(64655);
    }
}
