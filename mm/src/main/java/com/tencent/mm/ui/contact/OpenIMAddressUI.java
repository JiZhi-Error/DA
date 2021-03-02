package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.g;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ci.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI extends MMActivity {
    public MMFragment PSI;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37918);
        super.onCreate(bundle);
        g supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(16908290) == null) {
            this.PSI = new OpenIMAddressUIFragment();
            this.PSI.setArguments(getIntent().getExtras());
            supportFragmentManager.beginTransaction().a(R.id.dyh, this.PSI).commit();
        }
        AppMethodBeat.o(37918);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bgy;
    }

    public static class OpenIMAddressUIFragment extends MMFragment implements i {
        private b PSM;
        private String PSO = "";
        boolean PTd;
        private boolean PTe = true;
        List<String> PTh = new LinkedList();
        private String PXZ = "";
        private x PYa;
        private Runnable PYb = new Runnable() {
            /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(37901);
                OpenIMAddressUIFragment.i(OpenIMAddressUIFragment.this);
                AppMethodBeat.o(37901);
            }
        };
        private ProgressDialog gtM = null;
        e gup = new e(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass4 */

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(37886);
                Log.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", Integer.valueOf(i2));
                AppMethodBeat.o(37886);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(37887);
                Log.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", Integer.valueOf(i2));
                if (i2 == 2) {
                    d.gGm().gV(OpenIMAddressUI.class.getName() + ".Listview", 4);
                }
                AppMethodBeat.o(37887);
            }
        });
        List<String> gzY = new LinkedList();
        private int ppd;
        private int ppe;
        private f ppm;
        private o.g rJj = new o.g() {
            /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(37885);
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        OpenIMAddressUIFragment.a(OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.PSO);
                        AppMethodBeat.o(37885);
                        return;
                    case 7:
                        OpenIMAddressUIFragment.c(OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.PSO);
                        AppMethodBeat.o(37885);
                        return;
                    default:
                        AppMethodBeat.o(37885);
                        return;
                }
            }
        };
        private ListView yCT;

        static /* synthetic */ void k(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.i(37917);
            openIMAddressUIFragment.gUr();
            AppMethodBeat.o(37917);
        }

        public OpenIMAddressUIFragment() {
            super(true);
            AppMethodBeat.i(37902);
            AppMethodBeat.o(37902);
        }

        @Override // com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return R.layout.bh2;
        }

        @Override // com.tencent.mm.ui.MMFragment
        public View getLayoutView() {
            AppMethodBeat.i(37903);
            com.tencent.mm.kiss.a.b.aBh();
            View c2 = com.tencent.mm.kiss.a.b.c(getContext(), R.layout.bh2);
            AppMethodBeat.o(37903);
            return c2;
        }

        @Override // com.tencent.mm.ui.MMFragment
        public boolean supportNavigationSwipeBack() {
            return false;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(37904);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            bg.aVF();
            as Kn = c.aSN().Kn(this.PSO);
            if (Kn == null) {
                Log.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.PSO);
                AppMethodBeat.o(37904);
            } else if (z.aTY().equals(Kn.field_username)) {
                AppMethodBeat.o(37904);
            } else if (ab.IQ(this.PSO)) {
                contextMenu.setHeaderTitle(l.c(view.getContext(), Kn.arJ()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.ew);
                AppMethodBeat.o(37904);
            } else if (ab.Jf(this.PSO) || ab.Jv(this.PSO)) {
                AppMethodBeat.o(37904);
            } else {
                contextMenu.setHeaderTitle(l.c(view.getContext(), Kn.arJ()));
                if (com.tencent.mm.contact.c.oR(Kn.field_type) && Kn.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.string.bd1);
                }
                AppMethodBeat.o(37904);
            }
        }

        @Override // com.tencent.mm.ak.i
        public void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(37905);
            if (qVar.getType() != 453) {
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (!Util.isTopActivity(getContext())) {
                    AppMethodBeat.o(37905);
                } else if (z.a.a(getContext(), i2, i3, str, 4)) {
                    AppMethodBeat.o(37905);
                } else if (i2 == 0 && i3 == 0) {
                    AppMethodBeat.o(37905);
                } else {
                    AppMethodBeat.o(37905);
                }
            } else if (i2 == 0 && i3 == 0) {
                if (!((brr) ((com.tencent.mm.openim.b.i) qVar).rr.iLL.iLR).LYW.isEmpty()) {
                    gUr();
                }
                AppMethodBeat.o(37905);
            } else {
                AppMethodBeat.o(37905);
            }
        }

        private void gUq() {
            AppMethodBeat.i(37906);
            this.gzY = new LinkedList();
            this.PTh = new LinkedList();
            com.tencent.mm.br.c.gsX();
            this.gzY.add("tmessage");
            this.PTh.addAll(this.gzY);
            if (!this.gzY.contains("officialaccounts")) {
                this.gzY.add("officialaccounts");
            }
            this.gzY.add("helper_entry");
            if (this.PYa != null) {
                this.PYa.jB(this.gzY);
            }
            if (this.PSM != null) {
                this.PSM.jB(this.PTh);
            }
            AppMethodBeat.o(37906);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(37907);
            Log.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i2));
            if (i2 == 6 && i3 == -1) {
                setResult(-1);
                finish();
                AppMethodBeat.o(37907);
            } else if (i3 != -1) {
                AppMethodBeat.o(37907);
            } else {
                switch (i2) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        break;
                }
                AppMethodBeat.o(37907);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(37908);
            super.onActivityCreated(bundle);
            Log.v("MicroMsg.OpenIMAddressUI", "on address ui create");
            bg.azz().a(138, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(u.CTRL_INDEX, this);
            this.PXZ = getStringExtra("key_openim_acctype_id");
            setMMTitle(((a) com.tencent.mm.kernel.g.af(a.class)).b(this.PXZ, "openim_acct_type_title", a.EnumC0497a.TYPE_WORDING));
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(37883);
                    OpenIMAddressUIFragment.this.finish();
                    AppMethodBeat.o(37883);
                    return true;
                }
            });
            setTitleBarDoubleClickListener(this.PYb);
            Log.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            this.yCT = (ListView) findViewById(R.id.h4);
            this.yCT.setScrollingCacheEnabled(false);
            this.PYa = new x(getContext(), "@openim.contact", this.PXZ);
            this.PYa.a(new f.a() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass11 */

                @Override // com.tencent.mm.ui.f.a
                public final void bnE() {
                    AppMethodBeat.i(37894);
                    OpenIMAddressUIFragment openIMAddressUIFragment = OpenIMAddressUIFragment.this;
                    OpenIMAddressUIFragment.this.PYa.getCount();
                    OpenIMAddressUIFragment.b(openIMAddressUIFragment);
                    OpenIMAddressUIFragment.this.PYa.gUn();
                    AppMethodBeat.o(37894);
                }

                @Override // com.tencent.mm.ui.f.a
                public final void gHg() {
                }
            });
            this.PYa.PSs = true;
            this.PYa.PYf = this;
            this.PYa.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass12 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(37895);
                    int positionForView = OpenIMAddressUIFragment.this.yCT.getPositionForView(view);
                    AppMethodBeat.o(37895);
                    return positionForView;
                }
            });
            this.PYa.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass13 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(37896);
                    OpenIMAddressUIFragment.this.yCT.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(37896);
                }
            });
            this.PYa.a(new MMSlideDelView.f() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass14 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.f
                public final void cZ(Object obj) {
                    AppMethodBeat.i(37897);
                    if (obj == null) {
                        Log.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
                        AppMethodBeat.o(37897);
                        return;
                    }
                    OpenIMAddressUIFragment.a(OpenIMAddressUIFragment.this, obj.toString());
                    AppMethodBeat.o(37897);
                }
            });
            this.PSM = new b(getContext(), 1);
            this.PSM.CR(true);
            this.ppm = new com.tencent.mm.ui.widget.f(getContext());
            this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass15 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(37898);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    Log.i("MicroMsg.OpenIMAddressUI", "onItemClick " + i2 + (OpenIMAddressUIFragment.this.PSM == null ? OpenIMAddressUIFragment.this.PSM : Boolean.valueOf(OpenIMAddressUIFragment.this.PSM.QBl)));
                    int headerViewsCount = i2 - OpenIMAddressUIFragment.this.yCT.getHeaderViewsCount();
                    if (OpenIMAddressUIFragment.this.PSM == null || !OpenIMAddressUIFragment.this.PSM.QBl) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) OpenIMAddressUIFragment.this.PYa.getItem(headerViewsCount);
                        if (fVar != null) {
                            String str = fVar.field_username;
                            OpenIMAddressUIFragment openIMAddressUIFragment = OpenIMAddressUIFragment.this;
                            if (str != null && str.length() > 0) {
                                if (ab.Js(str)) {
                                    Log.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", str);
                                } else {
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", str);
                                    if (ab.IQ(str)) {
                                        intent.putExtra("Is_group_card", true);
                                    }
                                    if (str != null && str.length() > 0) {
                                        e.a(intent, str);
                                        com.tencent.mm.br.c.b(openIMAddressUIFragment.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                    }
                                }
                            }
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(37898);
                        return;
                    }
                    boolean Ox = OpenIMAddressUIFragment.this.PSM.Ox(headerViewsCount);
                    boolean aot = OpenIMAddressUIFragment.this.PSM.aot(headerViewsCount);
                    Log.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(aot)));
                    if (aot) {
                        OpenIMAddressUIFragment.this.PSM.boh("");
                    } else if (Ox) {
                        drr aos = OpenIMAddressUIFragment.this.PSM.aos(headerViewsCount);
                        String str2 = aos.Lqk.MTo;
                        bg.aVF();
                        as Kn = c.aSN().Kn(str2);
                        if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", str2);
                            intent2.putExtra("Contact_Scene", 3);
                            if (str2 != null && str2.length() > 0) {
                                if (Kn.gBM()) {
                                    h.INSTANCE.kvStat(10298, str2 + ",3");
                                }
                                e.a(intent2, str2);
                                com.tencent.mm.br.c.b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                            }
                        } else {
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", aos.Lqk.MTo);
                            intent3.putExtra("Contact_Alias", aos.ked);
                            intent3.putExtra("Contact_Nick", aos.Mjj.MTo);
                            intent3.putExtra("Contact_Signature", aos.keb);
                            intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(aos.keh, aos.kdZ, aos.kea));
                            intent3.putExtra("Contact_Sex", aos.kdY);
                            intent3.putExtra("Contact_VUser_Info", aos.MmL);
                            intent3.putExtra("Contact_VUser_Info_Flag", aos.MmK);
                            intent3.putExtra("Contact_KWeibo_flag", aos.MmO);
                            intent3.putExtra("Contact_KWeibo", aos.MmM);
                            intent3.putExtra("Contact_KWeiboNick", aos.MmN);
                            intent3.putExtra("Contact_KSnsIFlag", aos.MmQ.kej);
                            intent3.putExtra("Contact_KSnsBgId", aos.MmQ.kel);
                            intent3.putExtra("Contact_KSnsBgUrl", aos.MmQ.kek);
                            if (aos.MmR != null) {
                                try {
                                    intent3.putExtra("Contact_customInfo", aos.MmR.toByteArray());
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.OpenIMAddressUI", e2, "", new Object[0]);
                                }
                            }
                            if ((aos.MmK & 8) > 0) {
                                h.INSTANCE.kvStat(10298, str2 + ",3");
                            }
                            com.tencent.mm.br.c.b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                        }
                    } else {
                        as Ln = OpenIMAddressUIFragment.this.PSM.Ln(headerViewsCount);
                        if (Ln == null) {
                            Log.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(OpenIMAddressUIFragment.this.PSM.getCount()), Integer.valueOf(headerViewsCount));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(37898);
                            return;
                        }
                        String str3 = Ln.field_username;
                        if (ab.Js(str3)) {
                            Intent intent4 = new Intent(OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
                            intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                            OpenIMAddressUIFragment openIMAddressUIFragment2 = OpenIMAddressUIFragment.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                            com.tencent.mm.hellhoundlib.a.a.a(openIMAddressUIFragment2, bl.axQ(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            openIMAddressUIFragment2.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(openIMAddressUIFragment2, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(37898);
                            return;
                        }
                        Intent intent5 = new Intent();
                        intent5.putExtra("Contact_User", str3);
                        intent5.putExtra("Contact_Scene", 3);
                        if (str3 != null && str3.length() > 0) {
                            com.tencent.mm.br.c.b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent5);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(37898);
                }
            });
            this.yCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass16 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(37899);
                    Log.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i2)));
                    if (i2 < OpenIMAddressUIFragment.this.yCT.getHeaderViewsCount()) {
                        Log.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
                        AppMethodBeat.o(37899);
                        return true;
                    } else if (OpenIMAddressUIFragment.this.PSM == null || !OpenIMAddressUIFragment.this.PSM.QBl) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) OpenIMAddressUIFragment.this.PYa.getItem(i2 - OpenIMAddressUIFragment.this.yCT.getHeaderViewsCount());
                        if (fVar == null) {
                            Log.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i2), Integer.valueOf(OpenIMAddressUIFragment.this.yCT.getHeaderViewsCount()));
                            AppMethodBeat.o(37899);
                            return true;
                        }
                        String str = fVar.field_username;
                        if (ab.Js(str) || ab.Jt(str)) {
                            AppMethodBeat.o(37899);
                            return true;
                        }
                        OpenIMAddressUIFragment.this.PSO = str;
                        OpenIMAddressUIFragment.this.ppm.a(view, i2, j2, OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.rJj, OpenIMAddressUIFragment.this.ppd, OpenIMAddressUIFragment.this.ppe);
                        AppMethodBeat.o(37899);
                        return true;
                    } else {
                        AppMethodBeat.o(37899);
                        return true;
                    }
                }
            });
            this.yCT.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass17 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(37900);
                    switch (motionEvent.getAction()) {
                        case 0:
                            OpenIMAddressUIFragment.this.hideVKB();
                            OpenIMAddressUIFragment.this.ppd = (int) motionEvent.getRawX();
                            OpenIMAddressUIFragment.this.ppe = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(37900);
                    return false;
                }
            });
            this.yCT.setOnScrollListener(this.gup);
            this.yCT.setDrawingCacheEnabled(false);
            bg.aVF();
            c.aSN().add(this.PYa);
            AppMethodBeat.o(37908);
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onResume() {
            AppMethodBeat.i(37909);
            super.onResume();
            Log.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
            if (this.PTe) {
                this.PTe = false;
                this.PTd = false;
                gUq();
                this.yCT.setAdapter((ListAdapter) this.PYa);
                this.yCT.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(37890);
                        Log.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
                        View findViewById = OpenIMAddressUIFragment.this.findViewById(R.id.epv);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                            findViewById.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUIFragment.this.getContext(), R.anim.bs));
                        }
                        AppMethodBeat.o(37890);
                    }
                });
                this.PSM.CQ(false);
            } else if (this.PTd) {
                this.PTd = false;
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(37891);
                        Process.setThreadPriority(10);
                        OpenIMAddressUIFragment.k(OpenIMAddressUIFragment.this);
                        AppMethodBeat.o(37891);
                    }
                }, "AddressUI_updateUIData", 4);
            }
            if (this.PSM != null) {
                this.PSM.onResume();
            }
            this.PYa.OzQ = false;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(37892);
                    OpenIMAddressUIFragment.this.PYa.resume();
                    AppMethodBeat.o(37892);
                }
            });
            AppMethodBeat.o(37909);
        }

        private synchronized void gUr() {
            AppMethodBeat.i(37910);
            long currentTimeMillis = System.currentTimeMillis();
            gUq();
            Log.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.PYa != null) {
                Log.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(37888);
                        OpenIMAddressUIFragment.this.PYa.gUp();
                        AppMethodBeat.o(37888);
                    }
                });
            }
            if (this.PSM != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(37889);
                        Log.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
                        OpenIMAddressUIFragment.this.PSM.onNotifyChange(null, null);
                        AppMethodBeat.o(37889);
                    }
                });
            }
            Log.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis2));
            AppMethodBeat.o(37910);
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onPause() {
            AppMethodBeat.i(37911);
            super.onPause();
            Log.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
            if (this.PSM != null) {
                this.PSM.onPause();
            }
            this.PYa.gUo();
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(37893);
                    OpenIMAddressUIFragment.this.PYa.pause();
                    AppMethodBeat.o(37893);
                }
            });
            AppMethodBeat.o(37911);
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            AppMethodBeat.i(37912);
            super.onDestroy();
            Log.v("MicroMsg.OpenIMAddressUI", "onDestory");
            bg.azz().b(138, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.b(u.CTRL_INDEX, this);
            if (this.PYa != null) {
                this.PYa.AV(true);
                this.PYa.detach();
                this.PYa.gGV();
            }
            if (this.PSM != null) {
                this.PSM.detach();
                this.PSM.ebf();
            }
            if (bg.aAc() && this.PYa != null) {
                bg.aVF();
                c.aSN().remove(this.PYa);
            }
            AppMethodBeat.o(37912);
        }

        static /* synthetic */ void b(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.i(37913);
            openIMAddressUIFragment.yCT.setVisibility(0);
            AppMethodBeat.o(37913);
        }

        static /* synthetic */ void a(OpenIMAddressUIFragment openIMAddressUIFragment, String str) {
            AppMethodBeat.i(37914);
            bg.aVF();
            c.aSN().remove(openIMAddressUIFragment.PYa);
            bg.aVF();
            as Kn = c.aSN().Kn(str);
            Kn.aqR();
            ab.G(Kn);
            bg.aVF();
            c.aSN().c(str, Kn);
            openIMAddressUIFragment.PYa.hi(str, 5);
            bg.aVF();
            c.aSN().add(openIMAddressUIFragment.PYa);
            AppMethodBeat.o(37914);
        }

        static /* synthetic */ void i(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.i(37915);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(openIMAddressUIFragment.yCT);
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment", "doubleTap", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment", "doubleTap", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(37884);
                    OpenIMAddressUIFragment.this.yCT.setSelection(0);
                    AppMethodBeat.o(37884);
                }
            }, 300);
            AppMethodBeat.o(37915);
        }

        static /* synthetic */ void c(OpenIMAddressUIFragment openIMAddressUIFragment, String str) {
            AppMethodBeat.i(37916);
            bg.aVF();
            as Kn = c.aSN().Kn(str);
            if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                Intent intent = new Intent();
                intent.setClass(openIMAddressUIFragment.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", Kn.field_username);
                intent.putExtra("view_mode", true);
                Activity context = openIMAddressUIFragment.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment", "viewRemarkInfo", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment", "viewRemarkInfo", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(37916);
        }
    }
}
