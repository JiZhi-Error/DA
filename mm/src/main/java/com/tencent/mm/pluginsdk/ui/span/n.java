package com.tencent.mm.pluginsdk.ui.span;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class n {
    static String Kri;

    public static void b(final Context context, final String str, final DialogInterface.OnDismissListener onDismissListener) {
        AppMethodBeat.i(31936);
        if ((z.aUl() & 1) == 0) {
            h.a(context, str, context.getResources().getStringArray(R.array.f3022g), "", new h.d() {
                /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(31921);
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", "").replace("#", "@");
                    switch (i2) {
                        case 0:
                            Context context = context;
                            Intent intent = new Intent();
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", new String[]{replace.substring(0, replace.indexOf(64)) + " " + replace});
                            c.b(context, "qqmail", ".ui.ComposeUI", intent);
                            AppMethodBeat.o(31921);
                            return;
                        case 1:
                            n.co(context, replace);
                            break;
                    }
                    AppMethodBeat.o(31921);
                }
            });
            AppMethodBeat.o(31936);
            return;
        }
        h.a(context, str, new String[]{context.getResources().getString(R.string.ay4)}, "", new h.d() {
            /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(31922);
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
                String replace = str.replace(" ", "").replace("#", "@");
                switch (i2) {
                    case 0:
                        n.co(context, replace);
                        break;
                }
                AppMethodBeat.o(31922);
            }
        });
        AppMethodBeat.o(31936);
    }

    public static void a(final Context context, final String str, final DialogInterface.OnDismissListener onDismissListener, final Bundle bundle) {
        boolean z;
        final ArrayList<String> stringsToList;
        String[] strArr;
        AppMethodBeat.i(31937);
        if (!(context instanceof Activity)) {
            Log.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", Util.getStack());
        }
        if (g.aAf().azp()) {
            z = ((Boolean) g.aAh().azQ().get(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
        } else {
            z = false;
        }
        final int i2 = bundle != null ? bundle.getInt("fromScene") : 0;
        if (grU()) {
            String nullAsNil = Util.nullAsNil(bundle == null ? "" : bundle.getString("Contact_User"));
            if (nullAsNil == null || nullAsNil == "" || z.Im(nullAsNil) || as.bjp(nullAsNil)) {
                strArr = z ? new String[]{context.getResources().getString(R.string.b1j), context.getResources().getString(R.string.b1k), context.getResources().getString(R.string.b1d), context.getResources().getString(R.string.b1b)} : new String[]{context.getResources().getString(R.string.b1j), context.getResources().getString(R.string.b1d), context.getResources().getString(R.string.b1b)};
            } else {
                as Kn = ((l) g.af(l.class)).aSN().Kn(nullAsNil);
                if (Kn == null) {
                    AppMethodBeat.o(31937);
                    return;
                } else {
                    Kri = context.getResources().getString(R.string.b1c, Kn.arJ());
                    strArr = z ? new String[]{context.getResources().getString(R.string.b1j), context.getResources().getString(R.string.b1k), Kri, context.getResources().getString(R.string.b1d), context.getResources().getString(R.string.b1b)} : new String[]{context.getResources().getString(R.string.b1j), Kri, context.getResources().getString(R.string.b1d), context.getResources().getString(R.string.b1b)};
                }
            }
            stringsToList = Util.stringsToList(strArr);
        } else {
            stringsToList = Util.stringsToList(new String[]{context.getResources().getString(R.string.b1j), context.getResources().getString(R.string.b1d)});
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11621, Integer.valueOf(i2), 2);
        final com.tencent.mm.ui.base.l lVar = new com.tencent.mm.ui.base.l(context);
        lVar.setTitle(str);
        a aVar = new a(stringsToList, context, onDismissListener, bundle);
        aVar.Krr = new a.AbstractC2030a() {
            /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.span.n.a.AbstractC2030a
            public final void qA(boolean z) {
                AppMethodBeat.i(31925);
                if (z) {
                    lVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
                AppMethodBeat.o(31925);
            }
        };
        lVar.pXY = aVar;
        h.a(context, lVar);
        lVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(31926);
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
                AppMethodBeat.o(31926);
            }
        });
        lVar.Kth = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                final String[] strArr;
                AppMethodBeat.i(31929);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                final String replace = str.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
                String replaceAll = replace.replaceAll("#", "%23");
                String str = (String) stringsToList.get(i2);
                Log.i("MicroMsg.MailPhoneMenuHelper", str);
                if (context.getString(R.string.b1j).equals(str)) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(replaceAll))));
                    intent.addFlags(268435456);
                    if (Util.isIntentAvailable(context, intent)) {
                        Context context = context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10112, "1");
                    lVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                } else if (context.getString(R.string.b1k).equals(str)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12059, 0, 0, 0, 0, 0);
                    Intent intent2 = new Intent();
                    intent2.putExtra("IPCallTalkUI_phoneNumber", replace);
                    c.b(context, "ipcall", ".ui.IPCallDialUI", intent2);
                    lVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                } else if (context.getString(R.string.b1b).equals(str)) {
                    if (!n.grV() || !n.grW()) {
                        strArr = n.grV() ? new String[]{context.getResources().getString(R.string.b1a)} : new String[]{context.getResources().getString(R.string.b1i)};
                    } else {
                        strArr = context.getResources().getStringArray(R.array.a9);
                    }
                    context.getResources().getString(R.string.b1h);
                    com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
                    lVar.HLX = new o.f() {
                        /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass7.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(179832);
                            for (int i2 = 0; i2 < strArr.length; i2++) {
                                mVar.d(i2, strArr[i2]);
                            }
                            AppMethodBeat.o(179832);
                        }
                    };
                    lVar.HLY = new o.g() {
                        /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass7.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(179833);
                            if (onDismissListener != null) {
                                onDismissListener.onDismiss(null);
                            }
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (n.grV()) {
                                        Context context = context;
                                        String str = replace;
                                        Intent intent = new Intent("android.intent.action.INSERT");
                                        intent.setType("vnd.android.cursor.dir/contact");
                                        intent.putExtra("phone", str);
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        context.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneCreateContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10113, "1");
                                        AppMethodBeat.o(179833);
                                        return;
                                    }
                                    n.cp(context, replace);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10114, "1");
                                    AppMethodBeat.o(179833);
                                    return;
                                case 1:
                                    n.cp(context, replace);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10114, "1");
                                    break;
                            }
                            AppMethodBeat.o(179833);
                        }
                    };
                    lVar.a(new e.b() {
                        /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass7.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.widget.a.e.b
                        public final void onDismiss() {
                            AppMethodBeat.i(179834);
                            if (onDismissListener != null) {
                                onDismissListener.onDismiss(null);
                            }
                            AppMethodBeat.o(179834);
                        }
                    });
                    lVar.dismiss();
                    lVar.gXI();
                } else if (context.getString(R.string.b1d).equals(str)) {
                    ClipboardHelper.setText(context, replace, replace);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10115, "1");
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    lVar.dismiss();
                    Toast.makeText(context, context.getString(R.string.ta), 1).show();
                } else if (context.getString(R.string.b1f).equals(str)) {
                    Log.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                } else if (n.Kri.equals(str)) {
                    n.a((Activity) context, str, bundle);
                    lVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                } else {
                    Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                    lVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(31929);
            }
        };
        lVar.show();
        AppMethodBeat.o(31937);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        private Bundle GY = null;
        private DialogInterface.OnDismissListener Krq = null;
        AbstractC2030a Krr = null;
        private List<String> cvc = null;
        private Context mContext = null;

        /* renamed from: com.tencent.mm.pluginsdk.ui.span.n$a$a  reason: collision with other inner class name */
        public interface AbstractC2030a {
            void qA(boolean z);
        }

        public a(List<String> list, Context context, DialogInterface.OnDismissListener onDismissListener, Bundle bundle) {
            AppMethodBeat.i(31931);
            Assert.assertTrue(context != null);
            this.cvc = list;
            this.mContext = context;
            this.Krq = onDismissListener;
            this.GY = bundle;
            AppMethodBeat.o(31931);
        }

        public final int getCount() {
            AppMethodBeat.i(31932);
            if (this.cvc == null) {
                AppMethodBeat.o(31932);
                return 0;
            }
            int size = this.cvc.size();
            AppMethodBeat.o(31932);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(31933);
            String str = this.cvc.get(i2);
            AppMethodBeat.o(31933);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(31934);
            if (this.mContext.getString(R.string.b1f).equals(this.cvc.get(i2))) {
                AppMethodBeat.o(31934);
                return 1;
            }
            AppMethodBeat.o(31934);
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            Object tag;
            View view2;
            Object cVar;
            AppMethodBeat.i(31935);
            String str = (String) getItem(i2);
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
                if (itemViewType == 1) {
                    View inflate = layoutInflater.inflate(R.layout.sg, viewGroup, false);
                    cVar = new b(this, (byte) 0);
                    ((b) cVar).hbb = (TextView) inflate.findViewById(R.id.ipm);
                    ((b) cVar).thJ = (Button) inflate.findViewById(R.id.bto);
                    ((b) cVar).Krt = (TextView) inflate.findViewById(R.id.iol);
                    view2 = inflate;
                } else {
                    View inflate2 = layoutInflater.inflate(R.layout.sh, viewGroup, false);
                    cVar = new c(this, (byte) 0);
                    ((c) cVar).hbb = (TextView) inflate2.findViewById(R.id.ipm);
                    view2 = inflate2;
                }
                view2.setTag(cVar);
                tag = cVar;
            } else {
                tag = view.getTag();
                view2 = view;
            }
            switch (itemViewType) {
                case 0:
                    c cVar2 = (c) tag;
                    cVar2.hbb.setText(l.b(this.mContext, Util.nullAsNil(str), cVar2.hbb.getTextSize()));
                    break;
                case 1:
                    b bVar = (b) tag;
                    bVar.hbb.setText(l.b(this.mContext, Util.nullAsNil(str), bVar.hbb.getTextSize()));
                    bVar.Krt.setText(this.mContext.getString(R.string.b1l));
                    bVar.thJ.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.pluginsdk.ui.span.n.a.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(31930);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (!PlatformComm.C2Java.isNetworkConnected()) {
                                Log.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                                u.makeText(a.this.mContext, a.this.mContext.getString(R.string.dep), 0).show();
                                if (a.this.Krr != null) {
                                    a.this.Krr.qA(false);
                                }
                            } else {
                                s.i(a.this.mContext, a.this.GY);
                                if (a.this.Krr != null) {
                                    a.this.Krr.qA(true);
                                }
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$PhoneAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(31930);
                        }
                    });
                    break;
                default:
                    Log.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                    break;
            }
            AppMethodBeat.o(31935);
            return view2;
        }

        class b {
            TextView Krt;
            TextView hbb;
            Button thJ;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b2) {
                this();
            }
        }

        class c {
            TextView hbb;

            private c() {
            }

            /* synthetic */ c(a aVar, byte b2) {
                this();
            }
        }
    }

    private static boolean grU() {
        AppMethodBeat.i(31938);
        if (grV() || grW()) {
            AppMethodBeat.o(31938);
            return true;
        }
        AppMethodBeat.o(31938);
        return false;
    }

    static boolean grV() {
        AppMethodBeat.i(31939);
        Context context = MMApplicationContext.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        boolean isIntentAvailable = Util.isIntentAvailable(context, intent);
        AppMethodBeat.o(31939);
        return isIntentAvailable;
    }

    static boolean grW() {
        AppMethodBeat.i(31940);
        boolean isIntentAvailable = Util.isIntentAvailable(MMApplicationContext.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
        AppMethodBeat.o(31940);
        return isIntentAvailable;
    }

    private static void a(Activity activity, as asVar, String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(31941);
        cqe cqe = new cqe();
        cqe.MvG = str;
        dbl dbl = new dbl();
        dbl.MGv = new LinkedList<>();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (com.tencent.mm.plugin.bbom.c.ahc(next)) {
                dbk dbk = new dbk();
                dbk.MGu = next;
                dbl.MGv.add(dbk);
                arrayList2.add(next);
            }
        }
        dbl.oTz = arrayList2.size();
        cqe.Mvx = dbl;
        ((l) g.af(l.class)).aSM().d(new k.a(60, cqe));
        com.tencent.mm.contact.a.a(asVar, str, arrayList);
        Toast.makeText(activity, activity.getString(R.string.hjk), 0).show();
        AppMethodBeat.o(31941);
    }

    static /* synthetic */ void co(Context context, String str) {
        AppMethodBeat.i(31942);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (Util.isIntentAvailable(context, intent)) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "emailByDefault", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "emailByDefault", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(31942);
            return;
        }
        h.a(context, (int) R.string.b18, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.span.n.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(31942);
    }

    static /* synthetic */ void cp(Context context, String str) {
        AppMethodBeat.i(31943);
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (Util.isIntentAvailable(context, intent)) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneModifyContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper", "phoneModifyContact", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(31943);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(android.app.Activity r11, java.lang.String r12, android.os.Bundle r13) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.span.n.a(android.app.Activity, java.lang.String, android.os.Bundle):void");
    }
}
