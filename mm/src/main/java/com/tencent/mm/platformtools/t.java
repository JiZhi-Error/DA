package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.google.android.gms.common.internal.Constants;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import java.util.regex.Pattern;

public final class t {

    public interface a {
        void D(Bundle bundle);
    }

    public static int a(Context context, a aVar) {
        AppMethodBeat.i(127723);
        if (context == null) {
            Log.e("MicroMsg.MMAccountManager", "context is null");
            AppMethodBeat.o(127723);
            return 0;
        }
        String blH = blH();
        if (Util.isNullOrNil(blH)) {
            Log.e("MicroMsg.MMAccountManager", "account username is null or nil");
            blH = (String) g.aAh().azQ().get(6, "");
            if (Util.isNullOrNil(blH)) {
                AppMethodBeat.o(127723);
                return 0;
            }
        }
        if (S(context, blH)) {
            AppMethodBeat.o(127723);
            return 3;
        } else if (!b.n(context, "android.permission.READ_CONTACTS")) {
            AppMethodBeat.o(127723);
            return 2;
        } else {
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(blH, "com.tencent.mm.account");
                if (accountManager.addAccountExplicitly(account, "", null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", blH);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (aVar != null) {
                        aVar.D(bundle);
                    }
                    AppMethodBeat.o(127723);
                    return 1;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMAccountManager", e2, "", new Object[0]);
                Log.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e2.getMessage());
            }
            if (aVar != null) {
                aVar.D(null);
            }
            AppMethodBeat.o(127723);
            return 2;
        }
    }

    public static int a(Context context, String str, a aVar) {
        AppMethodBeat.i(127724);
        if (context == null) {
            Log.e("MicroMsg.MMAccountManager", "activity is null");
            AppMethodBeat.o(127724);
            return 0;
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MMAccountManager", "account username is null or nil");
            AppMethodBeat.o(127724);
            return 0;
        } else {
            String blH = blH();
            if (!Util.isNullOrNil(blH)) {
                str = blH;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!b.n(context, "android.permission.READ_CONTACTS")) {
                    AppMethodBeat.o(127724);
                    return 2;
                } else if (S(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    AppMethodBeat.o(127724);
                    return 3;
                } else {
                    Q(context, null);
                    if (accountManager.addAccountExplicitly(account, "", null)) {
                        ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                        Bundle bundle = new Bundle();
                        bundle.putString("authAccount", str);
                        bundle.putString("accountType", "com.tencent.mm.account");
                        if (aVar != null) {
                            aVar.D(bundle);
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.KEY_ACCOUNT_NAME, str);
                        contentValues.put("account_type", "com.tencent.mm.account");
                        contentValues.put("should_sync", (Integer) 1);
                        contentValues.put("ungrouped_visible", (Integer) 1);
                        context.getContentResolver().insert(ContactsContract.Settings.CONTENT_URI, contentValues);
                        AppMethodBeat.o(127724);
                        return 1;
                    }
                    if (aVar != null) {
                        aVar.D(null);
                    }
                    AppMethodBeat.o(127724);
                    return 2;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMAccountManager", e2, "", new Object[0]);
                Log.e("MicroMsg.MMAccountManager", "exception in addAccount() " + e2.getMessage());
            }
        }
    }

    public static void dr(Context context) {
        AppMethodBeat.i(127725);
        c.gsX();
        if (ChannelUtil.autoAddAccount == 0) {
            Log.d("MicroMsg.MMAccountManager", "do not auto add account");
            AppMethodBeat.o(127725);
        } else if (ChannelUtil.autoAddAccount != 1) {
            if (ChannelUtil.autoAddAccount == 2) {
                Log.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(context, null))));
            }
            AppMethodBeat.o(127725);
        } else if (l.bnZ() == l.a.SUCC) {
            Log.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(context, l.bob(), null))));
            AppMethodBeat.o(127725);
        } else {
            Log.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
            AppMethodBeat.o(127725);
        }
    }

    public static boolean Q(Context context, String str) {
        AppMethodBeat.i(127726);
        boolean isNullOrNil = Util.isNullOrNil(str);
        Log.v("MicroMsg.MMAccountManager", "remove account : ".concat(String.valueOf(str)));
        if (context == null) {
            Log.e("MicroMsg.MMAccountManager", "null context");
            AppMethodBeat.o(127726);
            return false;
        }
        try {
            Account[] dx = dx(context);
            if (dx == null || dx.length == 0) {
                Log.d("MicroMsg.MMAccountManager", "get account info is null or nil");
                AppMethodBeat.o(127726);
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : dx) {
                if (isNullOrNil) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    Log.i("MicroMsg.MMAccountManager", "remove account success: ".concat(String.valueOf(str)));
                }
            }
            AppMethodBeat.o(127726);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMAccountManager", e2, "", new Object[0]);
            Log.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e2.getMessage());
            AppMethodBeat.o(127726);
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public static boolean ds(Context context) {
        AppMethodBeat.i(127727);
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", blH());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = Q(context, blH());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        AppMethodBeat.o(127727);
        return z;
    }

    private static String blH() {
        AppMethodBeat.i(127728);
        if (!g.aAc()) {
            Log.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
            AppMethodBeat.o(127728);
            return "";
        }
        String str = (String) g.aAh().azQ().get(4, (Object) null);
        if (Util.isNullOrNil(str)) {
            str = z.aTZ();
            if (Util.isNullOrNil(str)) {
                str = z.aTY();
                if (Util.isNullOrNil(str) || as.bjx(str)) {
                    str = "";
                }
            }
        }
        String Sp = Sp(str);
        AppMethodBeat.o(127728);
        return Sp;
    }

    public static void dt(Context context) {
        AppMethodBeat.i(127729);
        if (!du(context)) {
            Q(context, null);
            Log.d("MicroMsg.MMAccountManager", "no account added or not current account");
        } else if (!g.aAh().azQ().getBoolean(ar.a.USERINFO_ACCOUNT_MANAGER_NEW_ACCOUNTS_BOOLEAN_SYNC, false)) {
            h.RTc.aX(new g(context, dw(context)));
            AppMethodBeat.o(127729);
            return;
        }
        AppMethodBeat.o(127729);
    }

    public static void l(Context context, String str, String str2) {
        AppMethodBeat.i(127730);
        if (!du(context)) {
            Q(context, null);
            Log.d("MicroMsg.MMAccountManager", "no account added or not current account");
        } else if (!g.aAh().azQ().getBoolean(ar.a.USERINFO_ACCOUNT_MANAGER_NEW_ACCOUNTS_BOOLEAN_SYNC, false)) {
            h.RTc.aX(new g(context, dw(context), str, str2));
            AppMethodBeat.o(127730);
            return;
        }
        AppMethodBeat.o(127730);
    }

    public static void R(Context context, String str) {
        AppMethodBeat.i(127731);
        if (!du(context)) {
            Q(context, null);
            Log.d("MicroMsg.MMAccountManager", "no account added or not current account");
        } else if (!g.aAh().azQ().getBoolean(ar.a.USERINFO_ACCOUNT_MANAGER_NEW_ACCOUNTS_BOOLEAN_SYNC, false)) {
            h.RTc.aX(new g(context, dw(context), str));
            AppMethodBeat.o(127731);
            return;
        }
        AppMethodBeat.o(127731);
    }

    private static boolean du(Context context) {
        AppMethodBeat.i(127732);
        Account dw = dw(context);
        if (dw == null) {
            AppMethodBeat.o(127732);
            return false;
        } else if (dw.name.equals(blH())) {
            AppMethodBeat.o(127732);
            return true;
        } else {
            AppMethodBeat.o(127732);
            return false;
        }
    }

    public static boolean dv(Context context) {
        AppMethodBeat.i(127733);
        if (!du(context)) {
            Log.e("MicroMsg.MMAccountManager", "no account added or not current account");
            AppMethodBeat.o(127733);
            return false;
        } else if (!b.n(context, "android.permission.READ_CONTACTS")) {
            AppMethodBeat.o(127733);
            return false;
        } else {
            Account dw = dw(context);
            if (dw != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(dw, "com.android.contacts", bundle);
                AppMethodBeat.o(127733);
                return true;
            }
            Log.e("MicroMsg.MMAccountManager", "no account added");
            AppMethodBeat.o(127733);
            return false;
        }
    }

    private static Account dw(Context context) {
        AppMethodBeat.i(127734);
        String blH = blH();
        if (Util.isNullOrNil(blH)) {
            blH = (String) g.aAh().azQ().get(6, "");
        }
        if (!Util.isNullOrNil(blH)) {
            Account[] dx = dx(context);
            if (dx == null) {
                AppMethodBeat.o(127734);
                return null;
            }
            for (Account account : dx) {
                if (account.name.equals(blH)) {
                    AppMethodBeat.o(127734);
                    return account;
                }
            }
        }
        AppMethodBeat.o(127734);
        return null;
    }

    private static Account[] dx(Context context) {
        AppMethodBeat.i(127735);
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
            AppMethodBeat.o(127735);
            return accountsByType;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMAccountManager", "get all accounts failed");
            Log.printErrStackTrace("MicroMsg.MMAccountManager", e2, "", new Object[0]);
            AppMethodBeat.o(127735);
            return null;
        }
    }

    private static boolean S(Context context, String str) {
        AppMethodBeat.i(127736);
        Account[] dx = dx(context);
        if (dx == null || dx.length == 0) {
            AppMethodBeat.o(127736);
            return false;
        }
        for (Account account : dx) {
            if (account.name.equals(str)) {
                AppMethodBeat.o(127736);
                return true;
            }
        }
        AppMethodBeat.o(127736);
        return false;
    }

    private static Account[] T(Context context, String str) {
        AppMethodBeat.i(127737);
        Account[] accountArr = null;
        try {
            accountArr = AccountManager.get(context).getAccountsByType(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMAccountManager", "get all accounts failed");
            Log.printErrStackTrace("MicroMsg.MMAccountManager", e2, "", new Object[0]);
        }
        AppMethodBeat.o(127737);
        return accountArr;
    }

    public static String dy(Context context) {
        AppMethodBeat.i(127738);
        Account[] T = T(context, "com.google");
        String str = null;
        if (T != null && T.length > 0) {
            for (Account account : T) {
                str = account.name;
                if (!Util.isNullOrNil(str) && Util.isValidEmail(str)) {
                    break;
                }
            }
        }
        AppMethodBeat.o(127738);
        return str;
    }

    private static String Sp(String str) {
        AppMethodBeat.i(127739);
        try {
            str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
            AppMethodBeat.o(127739);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", str, e2.getMessage());
            Log.printErrStackTrace("MicroMsg.MMAccountManager", e2, "", new Object[0]);
            AppMethodBeat.o(127739);
        }
        return str;
    }
}
