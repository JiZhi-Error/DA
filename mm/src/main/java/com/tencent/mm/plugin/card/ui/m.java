package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public final class m extends BaseAdapter {
    private Context mContext;
    private List<b> pRa = new ArrayList();
    View.OnClickListener qet;
    boolean qeu = false;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(113619);
        b Ew = Ew(i2);
        AppMethodBeat.o(113619);
        return Ew;
    }

    public m(Context context) {
        AppMethodBeat.i(113612);
        this.mContext = context;
        AppMethodBeat.o(113612);
    }

    public final void setData(List<b> list) {
        AppMethodBeat.i(113613);
        this.pRa.clear();
        this.pRa.addAll(list);
        AppMethodBeat.o(113613);
    }

    public final int getCount() {
        AppMethodBeat.i(113614);
        int size = this.pRa.size();
        AppMethodBeat.o(113614);
        return size;
    }

    private b Ew(int i2) {
        AppMethodBeat.i(113615);
        b bVar = this.pRa.get(i2);
        AppMethodBeat.o(113615);
        return bVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z;
        int i3;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        AppMethodBeat.i(113616);
        final b Ew = Ew(i2);
        switch (Ew.pSi) {
            case 2:
                view = View.inflate(this.mContext, R.layout.m7, null);
                TextView textView = (TextView) view.findViewById(R.id.al8);
                TextView textView2 = (TextView) view.findViewById(R.id.al7);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.hqf);
                if (!TextUtils.isEmpty(Ew.pSm)) {
                    linearLayout.setTag(Ew.pSm);
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.m.AnonymousClass1 */

                        public final void onClick(View view) {
                            final String str;
                            AppMethodBeat.i(113610);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CellAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            String str2 = (String) view.getTag();
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2.contains(";")) {
                                    str = str2.substring(0, str2.indexOf(";"));
                                } else {
                                    str = str2;
                                }
                                h.a(m.this.mContext, true, str, "", m.this.mContext.getString(R.string.ao9), m.this.mContext.getString(R.string.b96), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.card.ui.m.AnonymousClass1.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(113609);
                                        Intent intent = new Intent("android.intent.action.DIAL");
                                        intent.setFlags(268435456);
                                        intent.setData(Uri.parse(WebView.SCHEME_TEL + str));
                                        Context context = m.this.mContext;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/card/ui/CellAdapter$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        context.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/card/ui/CellAdapter$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(113609);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CellAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113610);
                        }
                    });
                    ((ImageView) view.findViewById(R.id.al6)).setBackgroundColor(l.ake(Ew.ixw));
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                textView.setText(Ew.title);
                textView2.setText(Ew.pRY);
                AppMethodBeat.o(113616);
                break;
            default:
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || aVar == null) {
                    view = View.inflate(this.mContext, R.layout.m8, null);
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.qdx = (TextView) view.findViewById(R.id.al5);
                    aVar2.qez = (TextView) view.findViewById(R.id.al4);
                    aVar2.qeA = (TextView) view.findViewById(R.id.al1);
                    aVar2.qeB = (ImageView) view.findViewById(R.id.al3);
                    aVar2.sc = view.findViewById(R.id.akz);
                    aVar2.qeC = (CheckBox) view.findViewById(R.id.al2);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.qdx.setText(Ew.title);
                if (Ew.pSk) {
                    aVar.qeC.setVisibility(0);
                    aVar.qeC.setChecked(Ew.edw);
                    aVar.qeC.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.m.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(113611);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CellAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (((CheckBox) view).isChecked()) {
                                Ew.edw = true;
                            } else {
                                Ew.edw = false;
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CellAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113611);
                        }
                    });
                } else {
                    aVar.qeC.setVisibility(8);
                }
                if (TextUtils.isEmpty(Ew.pRY)) {
                    aVar.qez.setVisibility(4);
                } else {
                    aVar.qez.setVisibility(0);
                    aVar.qez.setText(Ew.pRY);
                }
                if ((Ew.LfD & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.qdx.setGravity(17);
                    aVar.qdx.setTextColor(this.mContext.getResources().getColor(R.color.x0));
                    aVar.qez.setVisibility(8);
                } else {
                    aVar.qdx.setGravity(3);
                    aVar.qdx.setTextColor(this.mContext.getResources().getColor(Ew.pSl ? R.color.a2x : R.color.ae));
                    if (Ew.pSl) {
                        view.setBackgroundColor(this.mContext.getResources().getColor(R.color.afz));
                    } else {
                        view.setBackgroundColor(this.mContext.getResources().getColor(R.color.am));
                    }
                }
                if (Ew.pSj) {
                    aVar.qeA.setVisibility(0);
                } else {
                    aVar.qeA.setVisibility(8);
                }
                TextView textView3 = aVar.qez;
                Resources resources = this.mContext.getResources();
                if (Ew.pSl) {
                    i3 = R.color.l4;
                } else {
                    i3 = R.color.ad;
                }
                textView3.setTextColor(resources.getColor(i3));
                if (!Util.isNullOrNil(Ew.qGB)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    aVar.qeB.setVisibility(0);
                    n.a(aVar.qeB, Ew.qGB, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20), (int) R.drawable.ci4, false);
                } else {
                    aVar.qeB.setVisibility(8);
                }
                if (i2 + 1 < getCount()) {
                    a(aVar.sc, Ew(i2), !Ew.pSl);
                    b Ew2 = Ew(i2 + 1);
                    View view2 = aVar.sc;
                    if (Ew.pSl) {
                        z3 = false;
                    }
                    a(view2, Ew2, z3);
                } else if (i2 + 1 == getCount()) {
                    if (this.qeu) {
                        View view3 = aVar.sc;
                        if (!Ew.pSl) {
                            z4 = true;
                        }
                        c(view3, true, z4);
                    } else {
                        View view4 = aVar.sc;
                        if (Ew.pSl) {
                            z3 = false;
                        }
                        c(view4, false, z3);
                    }
                }
                AppMethodBeat.o(113616);
                break;
        }
        return view;
    }

    class a {
        TextView qdx;
        TextView qeA;
        ImageView qeB;
        CheckBox qeC;
        TextView qez;
        View sc;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }
    }

    private static void a(View view, b bVar, boolean z) {
        AppMethodBeat.i(161199);
        if (bVar == null) {
            AppMethodBeat.o(161199);
            return;
        }
        c(view, bVar.pSj, z);
        AppMethodBeat.o(161199);
    }

    private static void c(View view, boolean z, boolean z2) {
        int i2;
        View view2;
        AppMethodBeat.i(161200);
        Rect dC = n.dC(view);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (z) {
            i2 = R.drawable.aij;
            view2 = view;
        } else if (z2) {
            i2 = R.drawable.can;
            view2 = view;
        } else {
            i2 = R.drawable.b9w;
            view2 = view;
        }
        view2.setBackgroundResource(i2);
        view.setLayoutParams(layoutParams);
        n.f(view, dC);
        AppMethodBeat.o(161200);
    }
}
