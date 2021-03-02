package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public final class c extends b {
    private b FWc;
    private final String lFU;
    private final String mAppName;
    private Context mContext;
    private AuthorizeItemListView opS;
    private LinearLayout opU;

    public interface a {
        void a(int i2, ArrayList<String> arrayList);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.dialog.c$c  reason: collision with other inner class name */
    public static class C0819c {
        public String desc;
        public String scope;
        public int state;
    }

    public c(Context context, List<C0819c> list, String str, String str2, final a aVar) {
        super(context, (byte) 0);
        final ArrayList arrayList;
        AppMethodBeat.i(230012);
        this.mContext = context;
        this.mAppName = Util.nullAsNil(str);
        this.lFU = str2;
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = new ArrayList(list);
        }
        if (arrayList == null || arrayList.size() <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scopeInfoList is empty or null");
            AppMethodBeat.o(230012);
            throw illegalArgumentException;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.d7, (ViewGroup) null);
        setContentView(viewGroup);
        com.tencent.mm.modelappbrand.a.b.aXY().a((ImageView) viewGroup.findViewById(R.id.f3095rx), this.lFU, R.drawable.cg_, g.iJB);
        ((TextView) viewGroup.findViewById(R.id.sa)).setText(this.mContext.getString(R.string.elm, this.mAppName));
        this.opS = (AuthorizeItemListView) viewGroup.findViewById(R.id.vw);
        this.FWc = new b(arrayList);
        this.opS.setAdapter((ListAdapter) this.FWc);
        if (arrayList.size() > 5) {
            this.opS.akb = arrayList.size();
            this.opU = (LinearLayout) viewGroup.findViewById(R.id.w5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.opU.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.aaa);
            this.opU.setLayoutParams(layoutParams);
        }
        ((Button) viewGroup.findViewById(R.id.erg)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.dialog.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(147732);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((C0819c) arrayList.get(i2)).state == 2 || ((C0819c) arrayList.get(i2)).state == 3) {
                        arrayList.add(((C0819c) arrayList.get(i2)).scope);
                    }
                }
                Log.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                aVar.a(1, arrayList);
                this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(147732);
            }
        });
        ((Button) viewGroup.findViewById(R.id.esc)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.dialog.c.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(147733);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((C0819c) arrayList.get(i2)).state == 2 || ((C0819c) arrayList.get(i2)).state == 3) {
                        arrayList.add(((C0819c) arrayList.get(i2)).scope);
                    }
                }
                Log.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                aVar.a(2, arrayList);
                this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(147733);
            }
        });
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.dialog.c.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(147734);
                Log.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.a(3, null);
                AppMethodBeat.o(147734);
            }
        });
        AppMethodBeat.o(230012);
    }

    static final class b extends BaseAdapter {
        private final ArrayList<C0819c> GcY;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(147739);
            C0819c aww = aww(i2);
            AppMethodBeat.o(147739);
            return aww;
        }

        b(ArrayList<C0819c> arrayList) {
            this.GcY = arrayList;
        }

        public final int getCount() {
            AppMethodBeat.i(147736);
            if (this.GcY == null) {
                AppMethodBeat.o(147736);
                return 0;
            }
            int size = this.GcY.size();
            AppMethodBeat.o(147736);
            return size;
        }

        private C0819c aww(int i2) {
            AppMethodBeat.i(147737);
            C0819c cVar = this.GcY.get(i2);
            AppMethodBeat.o(147737);
            return cVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(147738);
            if (this.GcY == null || this.GcY.size() <= 0) {
                AppMethodBeat.o(147738);
                return null;
            }
            final C0819c aww = aww(i2);
            if (view == null) {
                a aVar2 = new a((byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.hc, null);
                aVar2.GdA = (ImageView) view.findViewById(R.id.n8);
                aVar2.oqe = (TextView) view.findViewById(R.id.n7);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aww.state == 1) {
                aVar.GdA.setImageResource(R.drawable.cb_);
            } else if (aww.state == 3) {
                aVar.GdA.setImageResource(R.drawable.cb9);
            } else {
                aVar.GdA.setImageResource(R.drawable.cb8);
            }
            aVar.oqe.setText(aww.desc);
            final ImageView imageView = aVar.GdA;
            aVar.GdA.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.dialog.c.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(147735);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (aww.state == 2) {
                        imageView.setImageResource(R.drawable.cb_);
                        aww.state = 1;
                    } else if (aww.state == 1) {
                        imageView.setImageResource(R.drawable.cb8);
                        aww.state = 2;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(147735);
                }
            });
            AppMethodBeat.o(147738);
            return view;
        }

        static final class a {
            ImageView GdA;
            TextView oqe;

            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }
    }
}
