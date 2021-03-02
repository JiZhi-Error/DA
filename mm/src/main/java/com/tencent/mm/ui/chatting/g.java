package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.chatting.ap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private Boolean PeQ = Boolean.FALSE;
    Map<String, ap> PeR = new ConcurrentHashMap();
    List<ap> PeS = new ArrayList();
    AdapterView.OnItemClickListener Pff = null;
    String Pfg = "";
    private ViewGroup Pfh = null;
    private b Pfi = null;
    private MMListPopupWindow Pfj;
    private int Pfk = R.style.zt;
    private int Pfl;
    k Pfm = null;
    private boolean Pfn = true;
    boolean eaY = false;
    private int height;
    private Context mContext = null;
    private int mCount;
    private LayoutInflater mInflater;

    public g(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(34351);
        this.mContext = context;
        this.Pfh = viewGroup;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        gNq();
        this.Pfi = new b(this, (byte) 0);
        AppMethodBeat.o(34351);
    }

    @SuppressLint({"WrongCall"})
    public final boolean a(k kVar, int i2, int i3) {
        AppMethodBeat.i(34352);
        if (isShowing() || kVar == null || kVar.iOs == null || kVar.iOs.size() <= 0) {
            AppMethodBeat.o(34352);
            return false;
        }
        this.Pfn = false;
        this.Pfm = kVar;
        this.mCount = kVar.iOs.size();
        this.Pfi.notifyDataSetChanged();
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        a.C2094a a2 = a.a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.bii, (ViewGroup) null)).getPaint(), kVar.iOs, i2);
        this.Pfl = (i3 - (this.Pfi.getCount() * this.mContext.getResources().getDimensionPixelSize(R.dimen.k4))) - this.mContext.getResources().getDimensionPixelSize(R.dimen.en);
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + i3 + "verticalOffset=" + this.Pfl);
        this.Pfj = new MMListPopupWindow(this.mContext, null, 0);
        this.Pfj.setOnDismissListener(this);
        this.Pfj.ars = this.Pff;
        this.Pfj.setAdapter(this.Pfi);
        this.Pfj.setModal(true);
        this.Pfj.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.coj));
        this.Pfj.setAnimationStyle(this.Pfk);
        this.Pfj.are = a2.oxr;
        this.Pfj.setVerticalOffset(this.Pfl);
        this.Pfj.arp = this.Pfh;
        this.Pfj.setContentWidth(b(this.Pfi));
        this.Pfj.kC();
        this.Pfj.show();
        this.Pfj.ORx.setOnKeyListener(this);
        this.Pfj.ORx.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.color.a7t)));
        this.Pfj.ORx.setSelector(this.mContext.getResources().getDrawable(R.drawable.aol));
        this.Pfj.ORx.setDividerHeight(1);
        this.Pfj.ORx.setVerticalScrollBarEnabled(false);
        this.Pfj.ORx.setHorizontalScrollBarEnabled(false);
        this.Pfj.ORx.setBackgroundColor(this.mContext.getResources().getColor(R.color.f3048f));
        AppMethodBeat.o(34352);
        return true;
    }

    public final boolean isShowing() {
        AppMethodBeat.i(34353);
        if (this.Pfj == null || !this.Pfj.kuK.isShowing()) {
            AppMethodBeat.o(34353);
            return false;
        }
        AppMethodBeat.o(34353);
        return true;
    }

    public final boolean gNq() {
        AppMethodBeat.i(34354);
        if (isShowing()) {
            this.Pfj.dismiss();
            AppMethodBeat.o(34354);
            return true;
        }
        AppMethodBeat.o(34354);
        return false;
    }

    class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(g gVar, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(34350);
            k ame = ame(i2);
            AppMethodBeat.o(34350);
            return ame;
        }

        public final int getCount() {
            AppMethodBeat.i(34347);
            int i2 = g.this.mCount;
            AppMethodBeat.o(34347);
            return i2;
        }

        private k ame(int i2) {
            AppMethodBeat.i(34348);
            k kVar = g.this.Pfm.iOs.get(i2);
            AppMethodBeat.o(34348);
            return kVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            TextView textView;
            AppMethodBeat.i(34349);
            if (view == null) {
                textView = (TextView) g.this.mInflater.inflate(R.layout.bii, viewGroup, false);
            } else {
                textView = (TextView) view;
            }
            k ame = ame(i2);
            textView.setTag(ame);
            if (g.a(g.this, ame.key)) {
                Log.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", ame.key);
                textView.setEllipsize(null);
                Drawable drawable = g.this.mContext.getResources().getDrawable(R.drawable.b1a);
                drawable.setBounds(0, 0, at.fromDPToPix(g.this.mContext, 8), at.fromDPToPix(g.this.mContext, 8));
                com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
                SpannableString spannableString = new SpannableString("@");
                spannableString.setSpan(aVar, 0, 1, 33);
                textView.setText(TextUtils.concat(((Object) l.c(g.this.mContext, ame.name)) + " ", spannableString));
            } else {
                textView.setText(l.c(g.this.mContext, ame.name));
            }
            AppMethodBeat.o(34349);
            return textView;
        }
    }

    public static class a {
        private static DisplayMetrics Pfp = null;

        /* renamed from: com.tencent.mm.ui.chatting.g$a$a  reason: collision with other inner class name */
        public static class C2094a {
            public int oxq;
            public int oxr;

            public final String toString() {
                AppMethodBeat.i(34344);
                String str = " marginLeft:" + this.oxq + " marginRight:" + this.oxr;
                AppMethodBeat.o(34344);
                return str;
            }
        }

        private static int a(Context context, TextPaint textPaint, List<k> list) {
            AppMethodBeat.i(34345);
            float f2 = 0.0f;
            for (k kVar : list) {
                f2 = textPaint.measureText(kVar.name);
                if (f2 >= f2) {
                    f2 = f2;
                }
            }
            int fromDPToPix = ((int) f2) + (com.tencent.mm.cb.a.fromDPToPix(context, 30) * 2);
            AppMethodBeat.o(34345);
            return fromDPToPix;
        }

        public static C2094a a(Context context, TextPaint textPaint, List<k> list, int i2) {
            DisplayMetrics displayMetrics;
            AppMethodBeat.i(34346);
            C2094a aVar = new C2094a();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (context instanceof Activity) {
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
                displayMetrics = displayMetrics2;
            } else {
                if (Pfp == null) {
                    Pfp = context.getResources().getDisplayMetrics();
                }
                displayMetrics = Pfp;
            }
            Point az = av.az(context);
            int i3 = displayMetrics.widthPixels;
            if (!(i3 == displayMetrics.widthPixels && az.y == displayMetrics.heightPixels)) {
                Log.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", Integer.valueOf(i3), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(az.y), Integer.valueOf(displayMetrics.heightPixels));
            }
            int a2 = a(context, textPaint, list);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 95);
            if (a2 >= fromDPToPix) {
                fromDPToPix = a2;
            }
            if (i2 - (fromDPToPix / 2) < 0) {
                aVar.oxq = 0;
                aVar.oxr = i3 - (fromDPToPix + 0);
            } else if (i3 - ((fromDPToPix / 2) + i2) < 0) {
                aVar.oxq = i3 - (fromDPToPix + 0);
                aVar.oxr = 0;
            } else {
                aVar.oxq = i2 - (fromDPToPix / 2);
                aVar.oxr = i3 - ((fromDPToPix / 2) + i2);
            }
            AppMethodBeat.o(34346);
            return aVar;
        }
    }

    private int b(ListAdapter listAdapter) {
        AppMethodBeat.i(34355);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                view = null;
            } else {
                itemViewType = i3;
            }
            if (this.Pfh == null) {
                this.Pfh = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i2, view, this.Pfh);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
            i2++;
            i3 = itemViewType;
        }
        AppMethodBeat.o(34355);
        return i4;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(232845);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        bVar.pH(i2);
        bVar.bm(keyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(232845);
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(232846);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(232846);
    }

    public final void onDismiss() {
    }

    public final void d(k kVar) {
        AppMethodBeat.i(232847);
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", Integer.valueOf(kVar.iOs.size()));
        this.PeQ = Boolean.TRUE;
        int i2 = 0;
        while (true) {
            if (i2 >= kVar.iOs.size()) {
                break;
            }
            k kVar2 = kVar.iOs.get(i2);
            Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", kVar2.key, kVar2.name);
            if (this.PeR.containsKey(kVar2.key)) {
                Log.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
                break;
            }
            ap apVar = new ap(this.mContext, kVar2.key, new ap.a() {
                /* class com.tencent.mm.ui.chatting.g.AnonymousClass1 */

                @Override // com.tencent.mm.ui.chatting.ap.a
                public final void O(boolean z, String str) {
                    AppMethodBeat.i(232844);
                    Log.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", Boolean.valueOf(z), str);
                    g.this.Pfg = str;
                    g.this.eaY = z;
                    AppMethodBeat.o(232844);
                }
            });
            com.tencent.mm.plugin.newtips.a.exl().h(apVar);
            this.PeR.put(kVar2.key, apVar);
            this.PeS.add(apVar);
            Log.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", kVar2.key);
            i2++;
        }
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", Integer.valueOf(this.PeR.size()), Integer.valueOf(this.PeS.size()));
        AppMethodBeat.o(232847);
    }

    static /* synthetic */ boolean a(g gVar, String str) {
        AppMethodBeat.i(232848);
        if (!gVar.PeQ.booleanValue() || !gVar.Pfg.equals(str) || !gVar.eaY) {
            AppMethodBeat.o(232848);
            return false;
        }
        AppMethodBeat.o(232848);
        return true;
    }
}
