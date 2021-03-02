package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.contact.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, f.a, BaseSortView.a {
    private boolean ajQ;
    private String mRa;
    private int mServiceType = 251658241;
    private boolean poJ;
    private int ppd = 0;
    private int ppe = 0;
    private HashMap<String, SpannableString> pqp = new HashMap<>();
    private f pqq = new f();
    private com.tencent.mm.ui.widget.b.a pqr;
    private boolean pqs;
    private ListView pqt;
    private a pqu;
    private String pqv;
    private View pqw;
    private TextView pqx;
    private o.g pqy = new o.g() {
        /* class com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.AnonymousClass3 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(5797);
            if (Util.isNullOrNil(BrandServiceSortView.this.mRa)) {
                Log.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
                AppMethodBeat.o(5797);
                return;
            }
            if (menuItem.getItemId() == 0) {
                Log.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", Integer.valueOf(i2));
                as Kn = ((l) g.af(l.class)).aSN().Kn(BrandServiceSortView.this.mRa);
                BrandServiceSortView.a(BrandServiceSortView.this, com.tencent.mm.al.g.fJ(BrandServiceSortView.this.mRa), BrandServiceSortView.this.getContext(), Kn, menuItem.getGroupId());
            }
            AppMethodBeat.o(5797);
        }
    };

    public interface a {
        boolean clY();
    }

    public static class b {
        static Bitmap pqA = null;
        public View contentView;
        ImageView gvv;
        TextView gvw;
        public TextView pnP;
        ImageView pps;
        View ppt;
        String username;
    }

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(5799);
        setDataSetObserver(this);
        this.pqs = false;
        setShowFooterView(false);
        refresh();
        f fVar = this.pqq;
        if (!fVar.pno.contains(this)) {
            Log.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            fVar.pno.add(this);
        }
        this.pqr = new com.tencent.mm.ui.widget.b.a(getContext());
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(5795);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof b)) {
                    Log.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(5795);
                    return;
                }
                b bVar2 = (b) tag;
                if (Util.isNullOrNil(bVar2.username)) {
                    Log.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(5795);
                    return;
                }
                am.aXh(bVar2.username);
                ac.u(BrandServiceSortView.this.pqv, 12, 4, i2 - 1);
                if (BrandServiceSortView.this.poJ) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", bVar2.username);
                    intent.putExtra("Select_Conv_User", bVar2.username);
                    if (BrandServiceSortView.this.getContext() instanceof Activity) {
                        Activity activity = (Activity) BrandServiceSortView.this.getContext();
                        activity.setResult(-1, intent);
                        activity.finish();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(5795);
                        return;
                    }
                }
                String str = bVar2.username;
                Context context = BrandServiceSortView.this.getContext();
                Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                Intent putExtra = new Intent().putExtra("Chat_User", str);
                putExtra.putExtra("finish_direct", true);
                putExtra.putExtra("chat_from_scene", 2);
                putExtra.putExtra("specific_chat_from_scene", 4);
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                com.tencent.mm.plugin.brandservice.b.jRt.d(putExtra, context);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(5795);
            }
        });
        setOnItemLongClickListener(this);
        AppMethodBeat.o(5799);
    }

    public void setReturnResult(boolean z) {
        this.poJ = z;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final void refresh() {
        AppMethodBeat.i(5800);
        this.pqq.init();
        hy(cy(this.pqq.CV(this.mServiceType)));
        super.refresh();
        AppMethodBeat.o(5800);
    }

    private static List<d> cy(List<qw> list) {
        AppMethodBeat.i(5801);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                qw qwVar = list.get(i2);
                if (!(qwVar == null || qwVar.contact == null)) {
                    d dVar = new d();
                    dVar.data = qwVar;
                    int i3 = qwVar.contact.field_showHead;
                    if (i3 >= 97 && i3 <= 122) {
                        i3 -= 32;
                    }
                    if (i3 < 65 || i3 > 90) {
                        dVar.Pae = "#";
                    } else {
                        dVar.Pae = new StringBuilder().append((char) i3).toString();
                    }
                    arrayList.add(dVar);
                }
            }
            AppMethodBeat.o(5801);
            return arrayList;
        }
        AppMethodBeat.o(5801);
        return null;
    }

    public final void release() {
        AppMethodBeat.i(5802);
        if (g.aAc()) {
            ag.bas().aZX();
        }
        this.pqq.release();
        AppMethodBeat.o(5802);
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(5803);
        if (!Util.isNullOrNil(str) && dVar != null) {
            this.pqv = str;
            qw qwVar = (qw) dVar.data;
            if (qwVar == null || qwVar.contact == null) {
                Log.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                AppMethodBeat.o(5803);
                return false;
            }
            as asVar = qwVar.contact;
            String arJ = asVar.arJ();
            String ajz = asVar.ajz();
            String ajA = asVar.ajA();
            String upperCase = str.toUpperCase();
            if ((!Util.isNullOrNil(arJ) && arJ.toUpperCase().indexOf(upperCase) != -1) || ((!Util.isNullOrNil(ajz) && ajz.toUpperCase().indexOf(upperCase) != -1) || (!Util.isNullOrNil(ajA) && ajA.toUpperCase().startsWith(upperCase)))) {
                AppMethodBeat.o(5803);
                return true;
            }
        }
        AppMethodBeat.o(5803);
        return false;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View inflate() {
        AppMethodBeat.i(5804);
        View inflate = View.inflate(getContext(), R.layout.lq, this);
        AppMethodBeat.o(5804);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(5805);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.hrg);
        AppMethodBeat.o(5805);
        return verticalScrollBar;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public ListView getListView() {
        AppMethodBeat.i(5806);
        this.pqt = (ListView) findViewById(R.id.ed2);
        if (this.pqw == null) {
            this.pqw = inflate(getContext(), R.layout.yi, null);
            if (!(this.pqt == null || this.pqw == null)) {
                this.pqx = (TextView) this.pqw.findViewById(R.id.bgc);
                this.pqt.addFooterView(this.pqw, null, false);
            }
        }
        ListView listView = this.pqt;
        AppMethodBeat.o(5806);
        return listView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public View getNoResultView() {
        AppMethodBeat.i(5807);
        View findViewById = findViewById(R.id.fzz);
        AppMethodBeat.o(5807);
        return findViewById;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public c.a getItemViewCreator() {
        AppMethodBeat.i(5808);
        AnonymousClass2 r0 = new c.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.sortview.c.a
            public final View a(d dVar, View view, int i2, boolean z, boolean z2) {
                b bVar;
                AppMethodBeat.i(5796);
                long currentTicks = Util.currentTicks();
                Context context = BrandServiceSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.lo, (ViewGroup) null);
                    bVar = new b();
                    bVar.pnP = (TextView) view.findViewById(R.id.apx);
                    bVar.contentView = view.findViewById(R.id.beh);
                    bVar.gvv = (ImageView) view.findViewById(R.id.n9);
                    bVar.pps = (ImageView) view.findViewById(R.id.fx7);
                    bVar.gvw = (TextView) view.findViewById(R.id.ac5);
                    bVar.ppt = view.findViewById(R.id.hj4);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                qw qwVar = (qw) dVar.data;
                if (qwVar == null) {
                    Log.e("MicroMsg.BrandServiceSortView", "should not be empty");
                    AppMethodBeat.o(5796);
                } else {
                    if (!BrandServiceSortView.this.OZW || !z) {
                        bVar.pnP.setVisibility(8);
                    } else {
                        bVar.pnP.setText(dVar.Pae);
                        bVar.pnP.setVisibility(0);
                    }
                    bVar.username = qwVar.userName;
                    bVar.gvv.setTag(qwVar.userName);
                    a.b.d(bVar.gvv, bVar.username);
                    BrandServiceSortView.a(BrandServiceSortView.this, bVar.gvw, context, qwVar.contact.arJ(), (int) bVar.gvw.getTextSize());
                    Log.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", Integer.valueOf(qwVar.Bdk.field_status));
                    bVar.pps.setVisibility((!BrandServiceSortView.this.pqs || qwVar.Bdk.field_status != 1) ? 8 : 0);
                    if (BrandServiceSortView.this.getMode() != 0 || !z2) {
                        bVar.ppt.setBackgroundResource(R.drawable.b9w);
                    } else {
                        bVar.ppt.setBackgroundResource(R.drawable.qd);
                    }
                    if (BrandServiceSortView.this.OZX) {
                        bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(R.dimen.f3060e), bVar.contentView.getPaddingBottom());
                    } else {
                        bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(R.dimen.ir), bVar.contentView.getPaddingBottom());
                    }
                    Log.v("MicroMsg.BrandServiceSortView", "get view use %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                    AppMethodBeat.o(5796);
                }
                return view;
            }
        };
        AppMethodBeat.o(5808);
        return r0;
    }

    @Override // com.tencent.mm.plugin.brandservice.b.f.a
    public final void onChange() {
        AppMethodBeat.i(5809);
        refresh();
        AppMethodBeat.o(5809);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(5810);
        if (motionEvent.getAction() == 0) {
            this.ppd = (int) motionEvent.getRawX();
            this.ppe = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(5810);
        return dispatchTouchEvent;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(5811);
        this.pqr.QSr = view;
        this.pqr.a(adapterView, i2, j2, this, this.pqy, this.ppd, this.ppe);
        AppMethodBeat.o(5811);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(5812);
        if (contextMenuInfo == null) {
            Log.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            AppMethodBeat.o(5812);
            return;
        }
        Log.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        d dVar = (d) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (dVar == null || dVar.data == null) {
            Log.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", dVar);
            AppMethodBeat.o(5812);
            return;
        }
        as asVar = ((qw) dVar.data).contact;
        if (asVar == null) {
            Log.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            AppMethodBeat.o(5812);
            return;
        }
        this.mRa = asVar.field_username;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), asVar.arJ()));
        com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(asVar.field_username);
        if (fJ != null && !fJ.UE()) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.eur);
        }
        AppMethodBeat.o(5812);
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView.a
    public final void cz(List<d> list) {
        AppMethodBeat.i(5813);
        if (!(this.pqx == null || list == null)) {
            this.pqx.setText(getContext().getString(R.string.alt, Integer.valueOf(list.size())));
        }
        AppMethodBeat.o(5813);
    }

    public void setShowFooterView(boolean z) {
        AppMethodBeat.i(5814);
        this.ajQ = z;
        A(this.pqx, z);
        AppMethodBeat.o(5814);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(5815);
        if (this.pqu != null) {
            this.pqu.clY();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(5815);
            return true;
        }
        AppMethodBeat.o(5815);
        return false;
    }

    public a getITransferToChildOnTouchListener() {
        return this.pqu;
    }

    public void setITransferToChildOnTouchListener(a aVar) {
        this.pqu = aVar;
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, TextView textView, Context context, String str, int i2) {
        AppMethodBeat.i(5816);
        if (textView == null) {
            Log.w("MicroMsg.BrandServiceSortView", "display area is null");
            AppMethodBeat.o(5816);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BrandServiceSortView", "remark is null");
            AppMethodBeat.o(5816);
        } else {
            SpannableString spannableString = brandServiceSortView.pqp.get(str);
            if (spannableString == null) {
                try {
                    Log.d("MicroMsg.BrandServiceSortView", "new one %s", str);
                    SpannableString spannableString2 = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) str, i2));
                    brandServiceSortView.pqp.put(str, spannableString2);
                    textView.setText(spannableString2);
                    AppMethodBeat.o(5816);
                } catch (Exception e2) {
                    Log.w("MicroMsg.BrandServiceSortView", "error, set empty str");
                    textView.setText("");
                    AppMethodBeat.o(5816);
                }
            } else {
                Log.v("MicroMsg.BrandServiceSortView", "match one %s", str);
                textView.setText(spannableString);
                AppMethodBeat.o(5816);
            }
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, com.tencent.mm.api.c cVar, Context context, as asVar, final int i2) {
        AppMethodBeat.i(5817);
        Log.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog");
        if (cVar == null || context == null || !(context instanceof Activity) || asVar == null) {
            Log.e("MicroMsg.BrandServiceSortView", "bizInfo(%s) or context(%s) or contact(%s) is null", cVar, context, asVar);
            AppMethodBeat.o(5817);
            return;
        }
        ((m) g.af(m.class)).a(cVar, (Activity) context, asVar, false, new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(5798);
                Log.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog run");
                List<d> datas = BrandServiceSortView.this.getDatas();
                if (i2 < 0 || datas == null || i2 >= datas.size()) {
                    Log.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog run refresh all");
                    BrandServiceSortView.this.refresh();
                    AppMethodBeat.o(5798);
                    return;
                }
                datas.remove(i2);
                BrandServiceSortView.this.getAdapter().refresh();
                AppMethodBeat.o(5798);
            }
        });
        AppMethodBeat.o(5817);
    }
}
