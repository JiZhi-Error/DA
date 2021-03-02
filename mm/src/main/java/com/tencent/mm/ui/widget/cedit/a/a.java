package com.tencent.mm.ui.widget.cedit.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.w;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import com.tencent.mm.ui.widget.cedit.edit.b;
import com.tencent.mm.ui.widget.edittext.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a {
    CustomTextView QIo;
    ImageView QLA;
    public boolean QLB = false;
    private Menu QLC;
    Map<Integer, CharSequence> QLD = new HashMap();
    private int[] QLE = new int[2];
    private b.p QLF = new b.p() {
        /* class com.tencent.mm.ui.widget.cedit.a.a.AnonymousClass2 */

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.p
        public final void i(int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(206039);
            a.this.qQv.dismiss();
            a aVar = a.this;
            aVar.QIo.removeCallbacks(aVar.QLG);
            aVar.QIo.postDelayed(aVar.QLG, 100);
            AppMethodBeat.o(206039);
        }
    };
    Runnable QLG = new Runnable() {
        /* class com.tencent.mm.ui.widget.cedit.a.a.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(206040);
            a.this.Dd(false);
            AppMethodBeat.o(206040);
        }
    };
    C2140a QLy;
    List<a.c> QLz;
    View mContentView;
    Context mContext;
    private int mHeight;
    RecyclerView mRecyclerView;
    private int mWidth;
    public PopupWindow qQv;

    public a(CustomTextView customTextView) {
        AppMethodBeat.i(206046);
        this.QIo = customTextView;
        this.mContext = customTextView.getContext();
        this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.ayw, (ViewGroup) null);
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mWidth = this.mContentView.getMeasuredWidth();
        this.mHeight = this.mContentView.getMeasuredHeight();
        this.qQv = new PopupWindow(this.mContentView, -2, -2, false);
        this.qQv.setClippingEnabled(false);
        this.mRecyclerView = (RecyclerView) this.mContentView.findViewById(R.id.h_1);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        LinkedList linkedList = new LinkedList();
        linkedList.add(new a.c(this.mContext.getResources().getString(17039373), 16908319, 12));
        linkedList.add(new a.c(this.mContext.getResources().getString(17039363), 16908320, 9));
        linkedList.add(new a.c(this.mContext.getResources().getString(17039361), 16908321, 9));
        linkedList.add(new a.c(this.mContext.getResources().getString(17039371), 16908322));
        this.QLz = linkedList;
        this.QLy = new C2140a(this.QLz, new a.e() {
            /* class com.tencent.mm.ui.widget.cedit.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void A(List<a.c> list, int i2) {
            }

            @Override // com.tencent.mm.ui.widget.edittext.a.e
            public final void a(View view, a.c cVar, String str) {
                AppMethodBeat.i(206038);
                a aVar = a.this;
                switch (cVar.id) {
                    case 16908319:
                        aVar.QIo.gZJ();
                        break;
                    case 16908320:
                        aVar.QIo.onTextContextMenuItem(16908320);
                        break;
                    case 16908321:
                        aVar.QIo.onTextContextMenuItem(16908321);
                        break;
                    case 16908322:
                        aVar.QIo.onTextContextMenuItem(16908322);
                        break;
                }
                if (aVar.QLD.containsKey(Integer.valueOf(cVar.id)) && aVar.QIo.getAdaptText() != null) {
                    try {
                        aVar.QIo.getAdaptText().onTextContextMenuItem(cVar.id);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("cmEdit.OperateWindow", th, "adaptText item err %s %s", cVar.name, Integer.valueOf(cVar.id));
                        com.tencent.mm.ui.widget.cedit.api.b.aow(11);
                    }
                    aVar.QIo.gZE();
                }
                if (aVar.QIo.getMenuCallback() != null) {
                    aVar.QIo.getMenuCallback().a(view, cVar, str);
                }
                AppMethodBeat.o(206038);
            }
        });
        this.mRecyclerView.setAdapter(this.QLy);
        w wVar = new w(this.mContext, 0);
        wVar.setDrawable(new ColorDrawable(this.mContext.getResources().getColor(R.color.w1)));
        this.mRecyclerView.a(wVar);
        this.QLA = (ImageView) this.mContentView.findViewById(R.id.bjj);
        this.qQv.setAnimationStyle(R.style.rq);
        Log.i("cmEdit.OperateWindow", "new OpWindow @%s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(206046);
    }

    private void haW() {
        int i2;
        AppMethodBeat.i(206047);
        int length = this.QIo.getText().length();
        int selectionStart = this.QIo.getSelectionStart();
        int selectionEnd = this.QIo.getSelectionEnd();
        if (length > 0 && selectionStart == 0 && selectionEnd == length) {
            i2 = 1;
        } else if (selectionStart != selectionEnd) {
            i2 = 8;
        } else if (length > 0) {
            i2 = 4;
        } else {
            i2 = 2;
        }
        LinkedList linkedList = new LinkedList();
        for (a.c cVar : this.QLz) {
            if ((cVar.QPF & i2) != 0) {
                linkedList.add(cVar);
            }
        }
        this.QLD.clear();
        if (this.QIo.gZN()) {
            Log.i("cmEdit.OperateWindow", "tryGetMenus");
            long currentTimeMillis = System.currentTimeMillis();
            CustomTextView customTextView = this.QIo;
            if (this.QLC == null) {
                this.QLC = new m(this.mContext);
            }
            this.QLC.clear();
            boolean a2 = a(customTextView.getAdaptText(), this.QLC);
            g(this.QLC);
            Log.i("cmEdit.OperateWindow", String.format("startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s, duration:%s", Integer.valueOf(Build.VERSION.SDK_INT), Boolean.TRUE, Boolean.valueOf(a2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        if (this.QLD.size() > 0) {
            for (Map.Entry<Integer, CharSequence> entry : this.QLD.entrySet()) {
                linkedList.add(new a.c(entry.getValue().toString(), entry.getKey().intValue()));
            }
        }
        if (this.QIo.getMenuCallback() != null) {
            this.QIo.getMenuCallback().A(linkedList, i2);
        }
        this.QLy.qXp = linkedList;
        this.QLy.atj.notifyChanged();
        AppMethodBeat.o(206047);
    }

    private void g(Menu menu) {
        AppMethodBeat.i(206048);
        if (menu != null && this.QIo.getReuseItems().size() > 0) {
            for (int i2 = 0; i2 < menu.size(); i2++) {
                MenuItem item = menu.getItem(i2);
                Log.d("cmEdit.OperateWindow", String.format("filterReuseMenus:%s", item.getTitle()));
                if (this.QIo.getReuseItems().contains(item.getTitle())) {
                    Log.d("cmEdit.OperateWindow", String.format("reuse bingo:%s", item.getTitle()));
                    this.QLD.put(Integer.valueOf(item.getItemId()), item.getTitle());
                }
            }
        }
        AppMethodBeat.o(206048);
    }

    private static boolean a(TextView textView, Menu menu) {
        AppMethodBeat.i(206049);
        if (textView == null) {
            Log.i("cmEdit.OperateWindow", "populateMenuItems fail null");
            AppMethodBeat.o(206049);
            return false;
        }
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(textView);
            Class<?> cls = Class.forName("android.widget.Editor");
            Class<?> cls2 = Class.forName("android.widget.Editor$TextActionModeCallback");
            Object tag = textView.getTag(R.id.iku);
            if (tag == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls, Integer.TYPE);
                    declaredConstructor.setAccessible(true);
                    tag = declaredConstructor.newInstance(obj, 1);
                } else {
                    Constructor<?> declaredConstructor2 = cls2.getDeclaredConstructor(cls, Boolean.TYPE);
                    declaredConstructor2.setAccessible(true);
                    tag = declaredConstructor2.newInstance(obj, Boolean.FALSE);
                }
            }
            Method declaredMethod = cls2.getDeclaredMethod("populateMenuWithItems", Menu.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(tag, menu);
            textView.setTag(R.id.iku, tag);
            Log.i("cmEdit.OperateWindow", "populateMenuItems succ");
            AppMethodBeat.o(206049);
            return true;
        } catch (Throwable th) {
            Log.e("cmEdit.OperateWindow", "populateMenuItems err:%s", Util.stackTraceToString(th));
            com.tencent.mm.ui.widget.cedit.api.b.aow(5);
            AppMethodBeat.o(206049);
            return false;
        }
    }

    public final void show() {
        AppMethodBeat.i(206050);
        if (this.QLB) {
            Log.i("cmEdit.OperateWindow", "show after destroy @", Integer.valueOf(hashCode()));
            this.qQv.setContentView(this.mContentView);
            this.QLB = false;
        }
        haW();
        Dd(true);
        this.QIo.getEditor().a(this.QLF);
        AppMethodBeat.o(206050);
    }

    /* access modifiers changed from: package-private */
    public final void Dd(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(206051);
        if (z) {
            View contentView = this.qQv.getContentView();
            contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mWidth = contentView.getMeasuredWidth();
            this.mHeight = contentView.getMeasuredHeight();
        }
        this.QIo.getLocationInWindow(this.QLE);
        Layout layout = this.QIo.getLayout();
        int screenWidth = com.tencent.mm.ui.widget.textview.b.getScreenWidth(this.mContext);
        int fromDPToPix = at.fromDPToPix(this.mContext, 10);
        int i6 = screenWidth - (fromDPToPix * 2);
        if (this.mWidth >= i6) {
            this.mWidth = i6;
        }
        int selectionStart = this.QIo.getSelectionStart();
        int selectionEnd = this.QIo.getSelectionEnd();
        int primaryHorizontal = ((((((int) layout.getPrimaryHorizontal(selectionStart)) + ((int) layout.getPrimaryHorizontal(selectionEnd))) / 2) + this.QLE[0]) - (this.mWidth / 2)) + this.QIo.getPaddingLeft();
        if (selectionStart == selectionEnd || layout.getLineForOffset(selectionStart) == layout.getLineForOffset(selectionEnd)) {
            i2 = primaryHorizontal;
        } else {
            i2 = (this.QLE[0] + (this.QIo.getWidth() / 2)) - (this.mWidth / 2);
        }
        int lineTop = ((((layout.getLineTop(layout.getLineForOffset(selectionStart)) + this.QLE[1]) - this.mHeight) + this.QIo.getPaddingTop()) - this.QIo.getScrollY()) - at.fromDPToPix(this.mContext, 5);
        int fromDPToPix2 = (this.QLE[1] - this.mHeight) - at.fromDPToPix(this.mContext, 5);
        int height = ((this.QLE[1] + this.QIo.getHeight()) - this.mHeight) - at.fromDPToPix(this.mContext, 5);
        if (i2 <= fromDPToPix) {
            i3 = fromDPToPix;
        } else {
            i3 = i2;
        }
        if (lineTop < fromDPToPix2) {
            i4 = fromDPToPix2;
        } else {
            i4 = lineTop;
        }
        if (i4 > height) {
            AppMethodBeat.o(206051);
            return;
        }
        if (this.mWidth + i3 > screenWidth) {
            i5 = (screenWidth - this.mWidth) - fromDPToPix;
        } else {
            i5 = i3;
        }
        ((LinearLayout.LayoutParams) this.QLA.getLayoutParams()).leftMargin = i2 - i5;
        if (Build.VERSION.SDK_INT >= 21) {
            this.qQv.setElevation(8.0f);
        }
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(linearLayoutManager, a2.axQ(), "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            linearLayoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(linearLayoutManager, "com/tencent/mm/ui/widget/cedit/menu/OperateWindow", "positionView", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
        }
        this.qQv.setWidth(this.mWidth);
        try {
            if (this.qQv.isShowing()) {
                this.qQv.update(i5, i4, this.qQv.getWidth(), this.qQv.getHeight());
                AppMethodBeat.o(206051);
                return;
            }
            this.qQv.showAtLocation(this.QIo, 0, i5, i4);
            AppMethodBeat.o(206051);
        } catch (Exception e2) {
            AppMethodBeat.o(206051);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(206052);
        try {
            this.QIo.getEditor().b(this.QLF);
            this.qQv.dismiss();
            AppMethodBeat.o(206052);
        } catch (Throwable th) {
            AppMethodBeat.o(206052);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.cedit.a.a$a  reason: collision with other inner class name */
    public class C2140a extends RecyclerView.a<C2141a> {
        private a.e QLI;
        private List<a.c> qXp;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C2141a aVar, int i2) {
            AppMethodBeat.i(206044);
            C2141a aVar2 = aVar;
            a.c cVar = this.qXp.get(i2);
            aVar2.vr.setText(cVar.name);
            aVar2.vr.setTag(cVar);
            AppMethodBeat.o(206044);
        }

        C2140a(List<a.c> list, a.e eVar) {
            this.qXp = list;
            this.QLI = eVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(206043);
            int size = this.qXp.size();
            AppMethodBeat.o(206043);
            return size;
        }

        /* renamed from: com.tencent.mm.ui.widget.cedit.a.a$a$a  reason: collision with other inner class name */
        class C2141a extends RecyclerView.v {
            TextView vr;

            public C2141a(View view) {
                super(view);
                AppMethodBeat.i(206042);
                this.vr = (TextView) view.findViewById(R.id.fd8);
                this.vr.setTextSize(1, 14.0f);
                AppMethodBeat.o(206042);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C2141a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(206045);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ayx, viewGroup, false);
            C2141a aVar = new C2141a(inflate);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.cedit.a.a.C2140a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(206041);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cedit/menu/OperateWindow$MyRecycleViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view != null || (view.getTag() instanceof a.c)) {
                        int selectionStart = a.this.QIo.getSelectionStart();
                        int selectionEnd = a.this.QIo.getSelectionEnd();
                        String charSequence = a.this.QIo.getText().subSequence(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd)).toString();
                        C2140a.this.QLI.a(view, (a.c) view.getTag(), charSequence);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cedit/menu/OperateWindow$MyRecycleViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(206041);
                }
            });
            AppMethodBeat.o(206045);
            return aVar;
        }
    }
}
