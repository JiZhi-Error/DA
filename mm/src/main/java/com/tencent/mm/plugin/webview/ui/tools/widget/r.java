package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.graphics.drawable.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class r {
    private b JAw;
    private Context context;
    private String lFU;
    private String mAppName = "";
    AuthorizeItemListView opS;
    private LinearLayout opU;

    public interface a {
        void i(int i2, Bundle bundle);
    }

    public r(Context context2) {
        this.context = context2;
    }

    public final boolean a(LinkedList<drb> linkedList, String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(151604);
        Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        this.mAppName = str;
        this.lFU = str2;
        boolean a2 = a(str3, linkedList, aVar);
        AppMethodBeat.o(151604);
        return a2;
    }

    public final boolean a(LinkedList<drb> linkedList, String str, String str2, a aVar) {
        AppMethodBeat.i(151605);
        boolean a2 = a(linkedList, str, str2, null, aVar);
        AppMethodBeat.o(151605);
        return a2;
    }

    private boolean a(String str, final LinkedList<drb> linkedList, final a aVar) {
        AppMethodBeat.i(151606);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            AppMethodBeat.o(151606);
            return false;
        }
        final i iVar = new i(this.context, R.style.a68);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.hb, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.jlk);
        if (!Util.isNullOrNil(str)) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.f3095rx);
        android.support.v4.graphics.drawable.b a2 = d.a(MMApplicationContext.getResources(), com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), R.raw.default_avatar));
        a2.eD();
        if (imageView != null) {
            com.tencent.mm.modelappbrand.a.b.aXY().a(imageView, this.lFU, a2, new e());
        }
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.sa);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView2.setText(l.b(this.context, this.context.getString(R.string.elm, this.mAppName), textView2.getTextSize()));
        this.opS = (AuthorizeItemListView) linearLayout.findViewById(R.id.vw);
        this.JAw = new b(linkedList);
        this.opS.setAdapter((ListAdapter) this.JAw);
        if (linkedList.size() > 5) {
            this.opS.akb = linkedList.size();
            this.opU = (LinearLayout) linearLayout.findViewById(R.id.w5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.opU.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(R.dimen.aaa);
            this.opU.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(R.id.erg)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.r.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(151595);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    if (((drb) linkedList.get(i2)).MTI == 2 || ((drb) linkedList.get(i2)).MTI == 3) {
                        arrayList.add(((drb) linkedList.get(i2)).KWK);
                    }
                }
                Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.i(1, bundle);
                iVar.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(151595);
            }
        });
        ((Button) linearLayout.findViewById(R.id.esc)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.r.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(151596);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    if (((drb) linkedList.get(i2)).MTI == 2 || ((drb) linkedList.get(i2)).MTI == 3) {
                        arrayList.add(((drb) linkedList.get(i2)).KWK);
                    }
                }
                Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.i(2, bundle);
                iVar.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(151596);
            }
        });
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.r.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(151597);
                if (r.this.opS != null) {
                    r.this.opS.setAdapter((ListAdapter) null);
                }
                AppMethodBeat.o(151597);
            }
        });
        iVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.r.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(151598);
                Log.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.i(3, null);
                AppMethodBeat.o(151598);
            }
        });
        iVar.setContentView(linearLayout);
        try {
            iVar.show();
            AppMethodBeat.o(151606);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", e2.getMessage());
            AppMethodBeat.o(151606);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private LinkedList<drb> JAy;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(151603);
            drb ahl = ahl(i2);
            AppMethodBeat.o(151603);
            return ahl;
        }

        public b(LinkedList<drb> linkedList) {
            this.JAy = linkedList;
        }

        public final int getCount() {
            AppMethodBeat.i(151600);
            if (this.JAy == null) {
                AppMethodBeat.o(151600);
                return 0;
            }
            int size = this.JAy.size();
            AppMethodBeat.o(151600);
            return size;
        }

        private drb ahl(int i2) {
            AppMethodBeat.i(151601);
            drb drb = this.JAy.get(i2);
            AppMethodBeat.o(151601);
            return drb;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(151602);
            if (this.JAy == null || this.JAy.size() <= 0) {
                AppMethodBeat.o(151602);
                return null;
            }
            final drb ahl = ahl(i2);
            if (view == null) {
                a aVar2 = new a(this, (byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.hc, null);
                aVar2.JeY = (ImageView) view.findViewById(R.id.n8);
                aVar2.oqe = (TextView) view.findViewById(R.id.n7);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (ahl.MTI == 1) {
                aVar.JeY.setImageResource(R.raw.login_auth_state_not_selected);
            } else if (ahl.MTI == 3) {
                aVar.JeY.setImageResource(R.raw.login_auth_state_must_select);
            } else {
                aVar.JeY.setImageResource(R.raw.login_auth_state_default_select);
            }
            aVar.oqe.setText(ahl.Desc);
            final ImageView imageView = aVar.JeY;
            aVar.JeY.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.r.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(151599);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ahl.MTI == 2) {
                        imageView.setImageResource(R.raw.login_auth_state_not_selected);
                        ahl.MTI = 1;
                    } else if (ahl.MTI == 1) {
                        imageView.setImageResource(R.raw.login_auth_state_default_select);
                        ahl.MTI = 2;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/WebAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(151599);
                }
            });
            AppMethodBeat.o(151602);
            return view;
        }

        class a {
            ImageView JeY;
            TextView oqe;

            private a() {
            }

            /* synthetic */ a(b bVar, byte b2) {
                this();
            }
        }
    }
}
