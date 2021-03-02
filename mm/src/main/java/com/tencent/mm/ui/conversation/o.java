package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.Map;

public final class o {
    private static d QgW = null;

    static /* synthetic */ void kt(Context context) {
        AppMethodBeat.i(38719);
        J(context, true);
        AppMethodBeat.o(38719);
    }

    static /* synthetic */ void ku(Context context) {
        AppMethodBeat.i(38720);
        ks(context);
        AppMethodBeat.o(38720);
    }

    public static void kr(final Context context) {
        boolean z;
        AppMethodBeat.i(38715);
        if (!ChannelUtil.isGPVersion()) {
            AppMethodBeat.o(38715);
            return;
        }
        String value = h.aqJ().getValue("NewShowRating");
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(38715);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(value, "ShowRatingNode", ProtocolPackage.ServerEncoding);
        int intValue = Integer.decode((parseXml == null || parseXml.get(".ShowRatingNode.MinVer") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : parseXml.get(".ShowRatingNode.MinVer")).intValue();
        int intValue2 = Integer.decode((parseXml == null || parseXml.get(".ShowRatingNode.MaxVer") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : parseXml.get(".ShowRatingNode.MaxVer")).intValue();
        int intValue3 = Integer.decode((parseXml == null || parseXml.get(".ShowRatingNode.WaitDays") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : parseXml.get(".ShowRatingNode.WaitDays")).intValue();
        if (intValue > com.tencent.mm.protocal.d.KyO || com.tencent.mm.protocal.d.KyO > intValue2) {
            AppMethodBeat.o(38715);
            return;
        }
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        int i2 = sharedPreferences.getInt("show_rating_flag", 0);
        int i3 = sharedPreferences.getInt("show_rating_version", 0);
        long j2 = sharedPreferences.getLong("show_rating_timestamp", 0);
        boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        long j3 = ((long) (intValue3 == 0 ? 7 : intValue3)) * Util.MILLSECONDS_OF_DAY;
        if (i3 == 0 || intValue > i3 || i3 > intValue2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sharedPreferences.edit().putInt("show_rating_version", com.tencent.mm.protocal.d.KyO).commit();
            sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
            i2 = 0;
            j2 = System.currentTimeMillis();
            sharedPreferences.edit().putLong("show_rating_timestamp", j2).commit();
            sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
            sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
            sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
            Log.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", Integer.valueOf(com.tencent.mm.protocal.d.KyO), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j3));
        }
        if (intValue <= com.tencent.mm.protocal.d.KyO && com.tencent.mm.protocal.d.KyO <= intValue2 && i2 == 0 && j2 != 0 && System.currentTimeMillis() >= j2 + j3) {
            Log.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
            QgW = com.tencent.mm.ui.base.h.a(context, false, context.getString(R.string.h1r), "", context.getString(R.string.h1k), context.getString(R.string.h1j), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.o.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38709);
                    sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    d unused = o.QgW = null;
                    o.kt(context);
                    Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                    AppMethodBeat.o(38709);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.o.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38710);
                    sharedPreferences.edit().putInt("show_rating_flag", 2).commit();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    d unused = o.QgW = null;
                    o.ku(context);
                    Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
                    AppMethodBeat.o(38710);
                }
            });
            AppMethodBeat.o(38715);
        } else if (z2 && j2 != 0 && System.currentTimeMillis() >= j2 + j3 + 345600000) {
            Log.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
            J(context, false);
            sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
            AppMethodBeat.o(38715);
        } else if (i2 == 1) {
            J(context, true);
            AppMethodBeat.o(38715);
        } else if (i2 == 2) {
            ks(context);
            AppMethodBeat.o(38715);
        } else {
            if (i2 == 3) {
                J(context, false);
            }
            AppMethodBeat.o(38715);
        }
    }

    private static void J(final Context context, boolean z) {
        String string;
        String str;
        String str2;
        AppMethodBeat.i(38716);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        final int i2 = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i3 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        if (z) {
            String string2 = context.getString(R.string.h1q);
            String string3 = context.getString(R.string.h1p);
            string = context.getString(R.string.h1o);
            str = string3;
            str2 = string2;
        } else {
            String string4 = context.getString(R.string.h1n);
            String string5 = context.getString(R.string.h1m);
            string = context.getString(R.string.h1l);
            str = string5;
            str2 = string4;
        }
        QgW = com.tencent.mm.ui.base.h.a(context, false, str2, "", str, string, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.conversation.o.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(38711);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + MMApplicationContext.getPackageName()));
                Context context = context;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/conversation/RatingDialogHelper$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/conversation/RatingDialogHelper$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                d unused = o.QgW = null;
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11216, 5, Integer.valueOf(i3), Integer.valueOf(i2));
                    AppMethodBeat.o(38711);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11216, 4, Integer.valueOf(i3), Integer.valueOf(i2));
                AppMethodBeat.o(38711);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.conversation.o.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(38712);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (z2) {
                    sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11216, 3, Integer.valueOf(i3), Integer.valueOf(i2));
                } else {
                    Log.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
                    sharedPreferences.edit().putBoolean("show_rating_again", true).commit();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11216, 6, Integer.valueOf(i3), Integer.valueOf(i2));
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                d unused = o.QgW = null;
                AppMethodBeat.o(38712);
            }
        });
        AppMethodBeat.o(38716);
    }

    private static void ks(final Context context) {
        AppMethodBeat.i(38717);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i2 = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i3 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        QgW = com.tencent.mm.ui.base.h.a(context, false, context.getString(R.string.h1u), "", context.getString(R.string.h1t), context.getString(R.string.h1s), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.conversation.o.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(38713);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                g.a(context, (int) System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
                d unused = o.QgW = null;
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11216, 2, Integer.valueOf(i3), Integer.valueOf(i2));
                AppMethodBeat.o(38713);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.conversation.o.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(38714);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                d unused = o.QgW = null;
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11216, 1, Integer.valueOf(i3), Integer.valueOf(i2));
                AppMethodBeat.o(38714);
            }
        });
        AppMethodBeat.o(38717);
    }

    public static void gWh() {
        AppMethodBeat.i(38718);
        if (QgW != null) {
            QgW.dismiss();
            QgW = null;
        }
        AppMethodBeat.o(38718);
    }
}
