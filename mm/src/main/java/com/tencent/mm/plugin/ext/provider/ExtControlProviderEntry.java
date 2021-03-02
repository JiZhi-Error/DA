package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cr;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher sNf;
    private String[] sMN;
    private int sMO;
    private boolean sNg;
    private Context sNh;

    static {
        AppMethodBeat.i(24426);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sNf = uriMatcher;
        uriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "view_profile", 2);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_chatting", 3);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_nearby", 4);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "sns_comment_detail", 5);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "share_time_line", 6);
        AppMethodBeat.o(24426);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.sNg = false;
        this.sMN = null;
        this.sMO = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i2, Context context) {
        this.sNg = false;
        this.sMN = null;
        this.sMO = -1;
        this.sNg = true;
        this.sMN = strArr;
        this.sMO = i2;
        this.sNh = context;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        AppMethodBeat.i(24422);
        Log.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.sNg);
        if (this.sNg) {
            a(uri, this.sNh, this.sMO, this.sMN);
            if (Util.isNullOrNil(this.sMZ)) {
                Log.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                fP(3, 7);
                MatrixCursor ahx = a.ahx(7);
                AppMethodBeat.o(24422);
                return ahx;
            } else if (Util.isNullOrNil(cSt())) {
                Log.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                fP(3, 6);
                MatrixCursor ahx2 = a.ahx(6);
                AppMethodBeat.o(24422);
                return ahx2;
            } else {
                int cSu = cSu();
                if (cSu != 1) {
                    Log.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(cSu)));
                    fP(2, cSu);
                    MatrixCursor ahx3 = a.ahx(cSu);
                    AppMethodBeat.o(24422);
                    return ahx3;
                }
            }
        } else {
            this.sNh = getContext();
            a(uri, this.sNh, sNf);
            if (uri == null) {
                HF(3);
                AppMethodBeat.o(24422);
                return null;
            } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
                HF(3);
                MatrixCursor ahx4 = a.ahx(3);
                AppMethodBeat.o(24422);
                return ahx4;
            } else if (!ckf()) {
                HF(1);
                MatrixCursor matrixCursor = this.pem;
                AppMethodBeat.o(24422);
                return matrixCursor;
            } else if (!fe(this.sNh)) {
                Log.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
                HF(2);
                AppMethodBeat.o(24422);
                return null;
            }
        }
        String nullAsNil = Util.nullAsNil(uri.getQueryParameter("source"));
        if (!this.sNg) {
            this.sMO = sNf.match(uri);
        }
        switch (this.sMO) {
            case 2:
                Cursor A = A(strArr2);
                AppMethodBeat.o(24422);
                return A;
            case 3:
                Cursor a2 = a(strArr2, nullAsNil);
                AppMethodBeat.o(24422);
                return a2;
            case 4:
                if (this.sNh == null) {
                    HF(4);
                    AppMethodBeat.o(24422);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(268435456);
                Context context = this.sNh;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                HF(0);
                MatrixCursor ahx5 = a.ahx(1);
                AppMethodBeat.o(24422);
                return ahx5;
            case 5:
                Cursor B = B(strArr2);
                AppMethodBeat.o(24422);
                return B;
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    HF(3);
                    AppMethodBeat.o(24422);
                    return null;
                } else if (this.sNh == null) {
                    HF(4);
                    AppMethodBeat.o(24422);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(268435456);
                    if (strArr2[1] == null) {
                        str3 = "";
                    } else {
                        str3 = strArr2[1];
                    }
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    Context context2 = this.sNh;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    HF(0);
                    MatrixCursor ahx6 = a.ahx(1);
                    AppMethodBeat.o(24422);
                    return ahx6;
                }
            default:
                fP(3, 15);
                AppMethodBeat.o(24422);
                return null;
        }
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor A(String[] strArr) {
        AppMethodBeat.i(24423);
        if (strArr == null || strArr.length <= 0) {
            Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            HF(3);
            AppMethodBeat.o(24423);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            HF(3);
            AppMethodBeat.o(24423);
            return null;
        }
        try {
            bg.aVF();
            as Nh = c.aSN().Nh(AESUtil.aro(str));
            if (Nh == null || ((int) Nh.gMZ) <= 0 || this.sNh == null) {
                HF(3);
                AppMethodBeat.o(24423);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("Contact_User", Nh.field_username);
            com.tencent.mm.br.c.b(this.sNh, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            HF(0);
            MatrixCursor ahx = a.ahx(1);
            AppMethodBeat.o(24423);
            return ahx;
        } catch (Exception e2) {
            Log.w("MicroMsg.ExtControlEntryProvider", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e2, "", new Object[0]);
            HF(3);
            AppMethodBeat.o(24423);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str) {
        as Nh;
        AppMethodBeat.i(24424);
        Log.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        if (strArr == null || strArr.length <= 0) {
            Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            fP(3, 3601);
            MatrixCursor ahx = a.ahx(3601);
            AppMethodBeat.o(24424);
            return ahx;
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            fP(3, 3602);
            MatrixCursor ahx2 = a.ahx(3602);
            AppMethodBeat.o(24424);
            return ahx2;
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                fP(3, 3603);
                MatrixCursor ahx3 = a.ahx(3603);
                AppMethodBeat.o(24424);
                return ahx3;
            }
            if (str != null && str.equalsIgnoreCase("openapi")) {
                try {
                    cr bkX = b.cSi().bkX(str2);
                    if (bkX == null || Util.isNullOrNil(bkX.field_openId) || Util.isNullOrNil(bkX.field_username)) {
                        Log.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        fP(3, 3604);
                        MatrixCursor ahx4 = a.ahx(3604);
                        AppMethodBeat.o(24424);
                        return ahx4;
                    }
                    bg.aVF();
                    Nh = c.aSN().Kn(bkX.field_username);
                } catch (Exception e2) {
                    Log.w("MicroMsg.ExtControlEntryProvider", e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e2, "", new Object[0]);
                    ac(5, 4, 12);
                    MatrixCursor ahx5 = a.ahx(12);
                    AppMethodBeat.o(24424);
                    return ahx5;
                }
            } else {
                bg.aVF();
                Nh = c.aSN().Nh(AESUtil.aro(str2));
            }
            if (Nh == null || ((int) Nh.gMZ) <= 0 || this.sNh == null) {
                Log.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                fP(3, 3605);
                MatrixCursor ahx6 = a.ahx(3605);
                AppMethodBeat.o(24424);
                return ahx6;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", Nh.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            Context context = this.sNh;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ac(4, 0, 1);
            MatrixCursor ahx7 = a.ahx(1);
            AppMethodBeat.o(24424);
            return ahx7;
        }
    }

    private Cursor B(String[] strArr) {
        AppMethodBeat.i(24425);
        if (strArr == null || strArr.length <= 0) {
            Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            HF(3);
            AppMethodBeat.o(24425);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            HF(3);
            AppMethodBeat.o(24425);
            return null;
        }
        try {
            long aro = AESUtil.aro(str);
            if (aro <= 0) {
                HF(3);
                AppMethodBeat.o(24425);
                return null;
            } else if (this.sNh == null) {
                HF(4);
                AppMethodBeat.o(24425);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) aro);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                Context context = this.sNh;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                HF(0);
                MatrixCursor ahx = a.ahx(1);
                AppMethodBeat.o(24425);
                return ahx;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.ExtControlEntryProvider", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e2, "", new Object[0]);
            HF(3);
            AppMethodBeat.o(24425);
            return null;
        }
    }
}
