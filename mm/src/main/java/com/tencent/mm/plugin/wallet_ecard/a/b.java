package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public final class b {

    public interface a {
        boolean fUk();
    }

    public static String d(Context context, String... strArr) {
        String str;
        AppMethodBeat.i(71685);
        String string = context.getString(R.string.itf);
        if (strArr.length > 0) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                str = strArr[i2];
                if (!Util.isNullOrNil(str)) {
                    break;
                }
                i2++;
            }
            AppMethodBeat.o(71685);
            return str;
        }
        str = string;
        AppMethodBeat.o(71685);
        return str;
    }

    public static boolean a(WalletBaseUI walletBaseUI, q qVar, int i2, String str, int i3, String str2) {
        AppMethodBeat.i(71686);
        if (i3 == 0) {
            str2 = str;
        } else {
            i2 = i3;
        }
        Log.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", Integer.valueOf(i2), str2);
        if (i2 == 269293577) {
            h.a((Context) walletBaseUI, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_ecard.a.b.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(71686);
            return true;
        }
        boolean a2 = com.tencent.mm.wallet_core.d.h.a(walletBaseUI, qVar, 1000, i2, str2);
        AppMethodBeat.o(71686);
        return a2;
    }

    public static void a(int i2, String str, String str2, String str3, Context context, d.a aVar) {
        AppMethodBeat.i(71687);
        Log.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", Integer.valueOf(i2), Boolean.valueOf(Util.isNullOrNil(str)), str2, str3);
        Bundle bundle = new Bundle();
        bundle.putInt(a.Ipq, i2);
        bundle.putString(a.Ipr, str);
        bundle.putString(a.Ipv, str2);
        bundle.putString(a.Ipw, str3);
        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_ecard.b.b.class, bundle, aVar);
        AppMethodBeat.o(71687);
    }

    public static boolean a(final WalletBaseUI walletBaseUI, final ddb ddb) {
        AppMethodBeat.i(71684);
        if (ddb == null) {
            Log.i("MicroMsg.ECardUtil", "no popItem");
        } else if (!Util.isNullOrNil(ddb.LZw)) {
            if (!Util.isNullOrNil(ddb.HFD) && !Util.isNullOrNil(ddb.MIh)) {
                Log.i("MicroMsg.ECardUtil", "show guide info 1");
                h.a((Context) walletBaseUI, ddb.LZw, "", ddb.HFD, ddb.MIh, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_ecard.a.b.AnonymousClass1 */
                    final /* synthetic */ a IpQ = null;

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71681);
                        if (!Util.isNullOrNil(ddb.yUB)) {
                            WalletBaseUI walletBaseUI = walletBaseUI;
                            String str = ddb.yUB;
                            a aVar = this.IpQ;
                            Log.i("MicroMsg.ECardUtil", "url: %s", str);
                            if (!Util.isNullOrNil(str)) {
                                if (str.startsWith("native.")) {
                                    Log.i("MicroMsg.ECardUtil", "goto native");
                                    if ((aVar == null || !aVar.fUk()) && !str.equals("native.qryacctdesc") && !str.equals("native.openecardauth") && !str.equals("native.cancloseecard") && str.equals("native.withdraw")) {
                                    }
                                } else {
                                    Log.d("MicroMsg.ECardUtil", "url: %s", str);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str);
                                    intent.putExtra("showShare", false);
                                    f.aA(walletBaseUI, intent);
                                }
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(71681);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_ecard.a.b.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71682);
                        if (ddb.MeU == a.Ipm) {
                            Log.i("MicroMsg.ECardUtil", "do end process");
                            d process = walletBaseUI.getProcess();
                            if (process != null) {
                                process.b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (ddb.MeU == a.Ipp) {
                            Log.i("MicroMsg.ECardUtil", "back bank list");
                            d process2 = walletBaseUI.getProcess();
                            if (process2 != null) {
                                process2.g(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(71682);
                    }
                });
                AppMethodBeat.o(71684);
                return true;
            } else if (!Util.isNullOrNil(ddb.MIh)) {
                Log.i("MicroMsg.ECardUtil", "show guide info 2");
                h.a((Context) walletBaseUI, ddb.LZw, "", ddb.MIh, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_ecard.a.b.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71683);
                        if (ddb.MeU == a.Ipm) {
                            Log.i("MicroMsg.ECardUtil", "do end process");
                            d process = walletBaseUI.getProcess();
                            if (process != null) {
                                process.b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (ddb.MeU == a.Ipp) {
                            Log.i("MicroMsg.ECardUtil", "back bank list");
                            d process2 = walletBaseUI.getProcess();
                            if (process2 != null) {
                                process2.g(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(71683);
                    }
                });
                AppMethodBeat.o(71684);
                return true;
            }
        }
        AppMethodBeat.o(71684);
        return false;
    }
}
