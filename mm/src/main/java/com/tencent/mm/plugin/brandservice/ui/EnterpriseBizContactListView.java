package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    private ListView krb;
    private String poQ;
    private boolean poY;
    private a poZ;
    private int ppa = -1;
    private d ppb;
    private c ppc;
    private int ppd = 0;
    private int ppe = 0;
    private final EnterpriseBizEntranceListUI.a ppf = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.AbstractC0867a() {
        /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.a.AbstractC0867a
        public final Context getContext() {
            AppMethodBeat.i(194862);
            Context context = EnterpriseBizContactListView.this.getContext();
            AppMethodBeat.o(194862);
            return context;
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI.a.AbstractC0867a
        public final String cma() {
            AppMethodBeat.i(194863);
            String str = EnterpriseBizContactListView.this.poQ;
            AppMethodBeat.o(194863);
            return str;
        }
    });
    private List<b> ppg;

    public interface a {
        void Da(int i2);
    }

    public interface d {
        boolean clY();
    }

    public static class e {
        public View contentView;
        ImageView gvv;
        TextView gvw;
        String iconUrl;
        public TextView pnP;
        ewv ppr;
        ImageView pps;
        View ppt;
        String username;
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(194869);
        AppMethodBeat.o(194869);
    }

    public void setFatherBizName(String str) {
        this.poQ = str;
    }

    public void setExcludeBizChat(boolean z) {
        this.poY = z;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final void refresh() {
        AppMethodBeat.i(5705);
        List<com.tencent.mm.ui.base.sortview.d> sortEntityList = getSortEntityList();
        if (this.poZ != null) {
            this.poZ.Da(this.ppa);
        }
        hy(sortEntityList);
        super.refresh();
        AppMethodBeat.o(5705);
    }

    public void setEmptyListener(a aVar) {
        this.poZ = aVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(5706);
        if (motionEvent.getAction() == 0) {
            this.ppd = (int) motionEvent.getRawX();
            this.ppe = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(5706);
        return dispatchTouchEvent;
    }

    public final void clZ() {
        AppMethodBeat.i(5707);
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(194864);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof e)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194864);
                    return;
                }
                e eVar = (e) tag;
                if (eVar.ppr != null) {
                    EnterpriseBizContactListView.this.ppf.a(eVar.ppr);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194864);
                } else if (Util.isNullOrNil(eVar.username)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194864);
                } else {
                    boolean Nh = g.Nh(eVar.username);
                    boolean DQ = g.DQ(eVar.username);
                    com.tencent.mm.api.c fJ = g.fJ(eVar.username);
                    String UJ = fJ == null ? null : fJ.UJ();
                    if (UJ == null) {
                        UJ = "";
                    }
                    if (Nh) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", UJ);
                        intent.putExtra("useJs", true);
                        intent.putExtra("srcUsername", eVar.username);
                        intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                        intent.addFlags(67108864);
                        com.tencent.mm.br.c.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, fJ, 2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(194864);
                        return;
                    }
                    if (DQ) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", eVar.username);
                        intent2.addFlags(67108864);
                        intent2.putExtra("biz_chat_from_scene", 3);
                        com.tencent.mm.br.c.f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", intent2);
                    } else {
                        Intent intent3 = new Intent();
                        intent3.addFlags(67108864);
                        intent3.putExtra("finish_direct", true);
                        intent3.putExtra("Chat_User", eVar.username);
                        intent3.putExtra("chat_from_scene", 2);
                        com.tencent.mm.plugin.brandservice.b.d(intent3, EnterpriseBizContactListView.this.getContext());
                        EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, fJ, 1);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194864);
                }
            }
        });
        if (getMode() == 0) {
            setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(194865);
                    if (EnterpriseBizContactListView.this.ppc == null) {
                        EnterpriseBizContactListView.this.ppc = new c(EnterpriseBizContactListView.this);
                    }
                    c cVar = EnterpriseBizContactListView.this.ppc;
                    int i3 = EnterpriseBizContactListView.this.ppd;
                    int i4 = EnterpriseBizContactListView.this.ppe;
                    if (cVar.ppm == null) {
                        EnterpriseBizContactListView enterpriseBizContactListView = cVar.ppn.get();
                        if (enterpriseBizContactListView == null) {
                            AppMethodBeat.o(194865);
                            return false;
                        }
                        cVar.ppm = new com.tencent.mm.ui.widget.f(enterpriseBizContactListView.getContext());
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        AppMethodBeat.o(194865);
                        return false;
                    }
                    cVar.ppl = ((e) tag).username;
                    if (Util.isNullOrNil(cVar.ppl) || g.DQ(cVar.ppl)) {
                        AppMethodBeat.o(194865);
                        return false;
                    }
                    cVar.ppm.QSr = view;
                    cVar.ppm.a(adapterView, i2, j2, new View.OnCreateContextMenuListener(i2) {
                        /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c.AnonymousClass1 */
                        final /* synthetic */ int vi;

                        {
                            this.vi = r2;
                        }

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(5697);
                            contextMenu.add(this.vi, 1, 0, R.string.bxm);
                            AppMethodBeat.o(5697);
                        }
                    }, new o.g() {
                        /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(5698);
                            if (Util.isNullOrNil(c.this.ppl)) {
                                AppMethodBeat.o(5698);
                                return;
                            }
                            if (menuItem.getItemId() == 1) {
                                c cVar = c.this;
                                String str = c.this.ppl;
                                EnterpriseBizContactListView enterpriseBizContactListView = cVar.ppn.get();
                                if (enterpriseBizContactListView != null) {
                                    Context context = enterpriseBizContactListView.getContext();
                                    h.c(context, context.getString(R.string.bxd), "", context.getString(R.string.bxc), context.getString(R.string.sz), new DialogInterface.OnClickListener(str, context) {
                                        /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c.AnonymousClass3 */
                                        final /* synthetic */ String gMw;
                                        final /* synthetic */ Context val$context;

                                        {
                                            this.gMw = r2;
                                            this.val$context = r3;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(5700);
                                            final com.tencent.mm.plugin.profile.b.d dVar = new com.tencent.mm.plugin.profile.b.d(this.gMw, true);
                                            com.tencent.mm.kernel.g.azz().a(1394, c.this);
                                            com.tencent.mm.kernel.g.azz().a(dVar, 0);
                                            c cVar = c.this;
                                            Context context = this.val$context;
                                            this.val$context.getString(R.string.zb);
                                            cVar.tipDialog = h.a(context, this.val$context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                                /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c.AnonymousClass3.AnonymousClass1 */

                                                public final void onCancel(DialogInterface dialogInterface) {
                                                    AppMethodBeat.i(5699);
                                                    com.tencent.mm.kernel.g.azz().a(dVar);
                                                    com.tencent.mm.kernel.g.azz().b(1394, c.this);
                                                    AppMethodBeat.o(5699);
                                                }
                                            });
                                            AppMethodBeat.o(5700);
                                        }
                                    }, null);
                                }
                            }
                            AppMethodBeat.o(5698);
                        }
                    }, i3, i4);
                    AppMethodBeat.o(194865);
                    return true;
                }
            });
        }
        AppMethodBeat.o(5707);
    }

    public static class b extends qw {
        private static ewv ppi = new ewv();
        public boolean ppj = false;
        public ewv ppk = ppi;

        static {
            AppMethodBeat.i(194868);
            AppMethodBeat.o(194868);
        }

        public static b cmb() {
            AppMethodBeat.i(194867);
            b bVar = new b();
            bVar.contact = new as();
            bVar.Bdk = new com.tencent.mm.api.c();
            AppMethodBeat.o(194867);
            return bVar;
        }
    }

    public int getContactCount() {
        return this.ppa;
    }

    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList() {
        AppMethodBeat.i(5708);
        ArrayList arrayList = new ArrayList();
        ag.bah();
        Cursor O = com.tencent.mm.al.f.O(this.poQ, this.poY);
        while (O.moveToNext()) {
            b bVar = new b();
            if (O != null) {
                as asVar = new as();
                asVar.convertFrom(O);
                com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
                cVar.convertFrom(O);
                bVar.userName = asVar.field_username;
                bVar.contact = asVar;
                bVar.Bdk = cVar;
            }
            if (bVar.contact != null) {
                com.tencent.mm.ui.base.sortview.d dVar = new com.tencent.mm.ui.base.sortview.d();
                dVar.data = bVar;
                if (bVar.Bdk.UH()) {
                    dVar.Pae = "!1";
                } else if (bVar.contact.arE()) {
                    dVar.Pae = "!2";
                } else {
                    int aqN = bVar.contact.aqN();
                    if (aqN >= 97 && aqN <= 122) {
                        aqN -= 32;
                    }
                    if (aqN < 65 || aqN > 90) {
                        dVar.Pae = "#";
                    } else {
                        dVar.Pae = new StringBuilder().append((char) aqN).toString();
                    }
                }
                arrayList.add(dVar);
            }
        }
        O.close();
        cw(arrayList);
        this.ppa = arrayList.size();
        Collections.sort(arrayList, new f(this, (byte) 0));
        AppMethodBeat.o(5708);
        return arrayList;
    }

    public void setFixedBrandServiceItem(List<b> list) {
        this.ppg = list;
    }

    private void cw(List<com.tencent.mm.ui.base.sortview.d> list) {
        AppMethodBeat.i(194870);
        if (this.ppg == null) {
            AppMethodBeat.o(194870);
            return;
        }
        ArrayList arrayList = new ArrayList(this.ppg.size());
        for (b bVar : this.ppg) {
            com.tencent.mm.ui.base.sortview.d dVar = new com.tencent.mm.ui.base.sortview.d();
            dVar.data = bVar;
            dVar.Pae = "!1";
            arrayList.add(dVar);
        }
        list.addAll(0, arrayList);
        AppMethodBeat.o(194870);
    }

    /* access modifiers changed from: package-private */
    public class f implements Comparator<com.tencent.mm.ui.base.sortview.d> {
        private f() {
        }

        /* synthetic */ f(EnterpriseBizContactListView enterpriseBizContactListView, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.tencent.mm.ui.base.sortview.d dVar, com.tencent.mm.ui.base.sortview.d dVar2) {
            int i2;
            int i3;
            int i4;
            int i5;
            boolean z;
            boolean z2;
            AppMethodBeat.i(5704);
            com.tencent.mm.ui.base.sortview.d dVar3 = dVar;
            com.tencent.mm.ui.base.sortview.d dVar4 = dVar2;
            String str = dVar3.Pae;
            String str2 = dVar4.Pae;
            if (str == null || str2 == null) {
                i2 = 0;
            } else {
                i2 = str.compareToIgnoreCase(str2);
            }
            if (i2 != 0) {
                if (str.equalsIgnoreCase("#")) {
                    i2 = 1;
                }
                if (str2.equalsIgnoreCase("#")) {
                    i2 = -1;
                }
                AppMethodBeat.o(5704);
                return i2;
            }
            qw qwVar = (qw) dVar3.data;
            qw qwVar2 = (qw) dVar4.data;
            if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                int aqN = qwVar.contact.aqN();
                int aqN2 = qwVar2.contact.aqN();
                if ((aqN < 97 || aqN > 122) && (aqN < 65 || aqN > 90)) {
                    z = true;
                } else {
                    z = false;
                }
                if ((aqN2 < 97 || aqN2 > 122) && (aqN2 < 65 || aqN2 > 90)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && !z2) {
                    AppMethodBeat.o(5704);
                    return 1;
                } else if (!z && z2) {
                    AppMethodBeat.o(5704);
                    return -1;
                }
            }
            if (qwVar.contact == null || qwVar.contact.ajA() == null || qwVar.contact.ajA().length() <= 0 || qwVar2.contact == null || qwVar2.contact.ajA() == null || qwVar2.contact.ajA().length() <= 0) {
                i3 = 0;
            } else {
                i3 = qwVar.contact.ajA().compareToIgnoreCase(qwVar2.contact.ajA());
            }
            if (i3 != 0) {
                AppMethodBeat.o(5704);
                return i3;
            }
            if (qwVar.contact == null || qwVar.contact.field_nickname == null || qwVar.contact.field_nickname.length() <= 0 || qwVar2.contact == null || qwVar2.contact.field_nickname == null || qwVar2.contact.field_nickname.length() <= 0) {
                i4 = 0;
            } else {
                i4 = qwVar.contact.field_nickname.compareToIgnoreCase(qwVar2.contact.field_nickname);
            }
            if (i4 != 0) {
                AppMethodBeat.o(5704);
                return i4;
            }
            if (qwVar.contact == null || qwVar.contact.field_username == null || qwVar.contact.field_username.length() <= 0 || qwVar2.contact == null || qwVar2.contact.field_username == null || qwVar2.contact.field_username.length() <= 0) {
                i5 = 0;
            } else {
                i5 = qwVar.contact.field_username.compareToIgnoreCase(qwVar2.contact.field_username);
            }
            if (i5 != 0) {
                AppMethodBeat.o(5704);
                return i5;
            }
            AppMethodBeat.o(5704);
            return 0;
        }
    }

    public static void release() {
        AppMethodBeat.i(5709);
        ag.bas().aZX();
        AppMethodBeat.o(5709);
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        AppMethodBeat.i(5710);
        if (!Util.isNullOrNil(str) && dVar != null) {
            qw qwVar = (qw) dVar.data;
            if (qwVar == null) {
                AppMethodBeat.o(5710);
                return false;
            }
            String arJ = qwVar.contact.arJ();
            String ajz = qwVar.contact.ajz();
            String ajA = qwVar.contact.ajA();
            String upperCase = str.toUpperCase();
            if ((!Util.isNullOrNil(arJ) && arJ.toUpperCase().indexOf(upperCase) != -1) || ((!Util.isNullOrNil(ajz) && ajz.toUpperCase().indexOf(upperCase) != -1) || (!Util.isNullOrNil(ajA) && ajA.toUpperCase().startsWith(upperCase)))) {
                AppMethodBeat.o(5710);
                return true;
            }
        }
        AppMethodBeat.o(5710);
        return false;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public final View inflate() {
        AppMethodBeat.i(5711);
        View inflate = View.inflate(getContext(), R.layout.a3y, this);
        AppMethodBeat.o(5711);
        return inflate;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(5712);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.hrg);
        AppMethodBeat.o(5712);
        return verticalScrollBar;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public ListView getListView() {
        AppMethodBeat.i(5713);
        this.krb = (ListView) findViewById(R.id.ed2);
        ListView listView = this.krb;
        AppMethodBeat.o(5713);
        return listView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public View getNoResultView() {
        AppMethodBeat.i(5714);
        TextView textView = (TextView) findViewById(R.id.fzz);
        textView.setText(R.string.bxn);
        AppMethodBeat.o(5714);
        return textView;
    }

    @Override // com.tencent.mm.ui.base.sortview.BaseSortView
    public c.a getItemViewCreator() {
        AppMethodBeat.i(5715);
        AnonymousClass4 r0 = new c.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.AnonymousClass4 */

            /* JADX WARNING: Removed duplicated region for block: B:19:0x00bd  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0102  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x011c  */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x0187  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x01ef  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x01fd  */
            @Override // com.tencent.mm.ui.base.sortview.c.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final android.view.View a(com.tencent.mm.ui.base.sortview.d r10, android.view.View r11, int r12, boolean r13, boolean r14) {
                /*
                // Method dump skipped, instructions count: 552
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.AnonymousClass4.a(com.tencent.mm.ui.base.sortview.d, android.view.View, int, boolean, boolean):android.view.View");
            }
        };
        AppMethodBeat.o(5715);
        return r0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(5716);
        if (this.ppb != null) {
            this.ppb.clY();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(5716);
            return true;
        }
        AppMethodBeat.o(5716);
        return false;
    }

    public void setOnTouchListener(d dVar) {
        this.ppb = dVar;
    }

    /* access modifiers changed from: package-private */
    public static class c implements i {
        public String ppl;
        com.tencent.mm.ui.widget.f ppm;
        WeakReference<EnterpriseBizContactListView> ppn;
        q tipDialog;

        public c(EnterpriseBizContactListView enterpriseBizContactListView) {
            AppMethodBeat.i(5701);
            this.ppn = new WeakReference<>(enterpriseBizContactListView);
            AppMethodBeat.o(5701);
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            AppMethodBeat.i(5702);
            com.tencent.mm.kernel.g.azz().b(1394, this);
            super.finalize();
            AppMethodBeat.o(5702);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(5703);
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i2 == 0 && i3 == 0) {
                if (qVar.getType() == 1394) {
                    efm eDZ = ((com.tencent.mm.plugin.profile.b.d) qVar).eDZ();
                    efn eDY = ((com.tencent.mm.plugin.profile.b.d) qVar).eDY();
                    if (eDY == null || eDY.KTz == null || eDY.KTz.ret != 0) {
                        if (eDY == null || eDY.KTz == null) {
                            Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(qVar.getType()));
                            AppMethodBeat.o(5703);
                            return;
                        }
                        Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(qVar.getType()), Integer.valueOf(eDY.KTz.ret));
                        AppMethodBeat.o(5703);
                        return;
                    } else if (!eDZ.neT) {
                        AppMethodBeat.o(5703);
                        return;
                    } else {
                        com.tencent.mm.api.c fJ = g.fJ(eDZ.KTt);
                        fJ.field_brandFlag |= 1;
                        cpe cpe = new cpe();
                        cpe.kem = fJ.field_brandFlag;
                        cpe.UserName = eDZ.KTt;
                        ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(47, cpe));
                        ag.bah().update(fJ, new String[0]);
                        ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW(fJ.field_username);
                        if (((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkk(fJ.field_enterpriseFather) <= 0) {
                            ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bjW(fJ.field_enterpriseFather);
                        } else {
                            ((com.tencent.mm.al.q) com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class)).aSS().biO(fJ.field_enterpriseFather);
                        }
                        EnterpriseBizContactListView enterpriseBizContactListView = this.ppn.get();
                        if (enterpriseBizContactListView == null) {
                            AppMethodBeat.o(5703);
                            return;
                        }
                        enterpriseBizContactListView.refresh();
                    }
                }
                AppMethodBeat.o(5703);
                return;
            }
            AppMethodBeat.o(5703);
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactListView enterpriseBizContactListView, com.tencent.mm.api.c cVar, int i2) {
        AppMethodBeat.i(194871);
        com.tencent.mm.al.d MO = ag.bar().MO(enterpriseBizContactListView.poQ);
        long j2 = MO != null ? MO.field_wwCorpId : 0;
        long j3 = MO != null ? MO.field_wwUserVid : 0;
        long UK = cVar.UK();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14507, Long.valueOf(j2), Long.valueOf(UK), Long.valueOf(j3), 2, 2, Integer.valueOf(i2));
        Log.d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j2), Long.valueOf(UK), Long.valueOf(j3), 1, 2, Integer.valueOf(i2));
        AppMethodBeat.o(194871);
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i2) {
        AppMethodBeat.i(194872);
        if (textView == null) {
            AppMethodBeat.o(194872);
            return;
        }
        if (!Util.isNullOrNil(str)) {
            try {
                textView.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) str, i2)));
                AppMethodBeat.o(194872);
                return;
            } catch (Exception e2) {
                textView.setText("");
            }
        }
        AppMethodBeat.o(194872);
    }
}
