package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.ci.d;
import com.tencent.mm.g.a.we;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.AbstractTabChildActivity;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.contact.a;
import com.tencent.mm.ui.contact.b;
import com.tencent.mm.ui.contact.j;
import com.tencent.mm.ui.contact.y;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AddressUI extends FragmentActivity {
    public MMFragment PSI;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37647);
        super.onCreate(bundle);
        g supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(16908290) == null) {
            this.PSI = new AddressUIFragment();
            this.PSI.setArguments(getIntent().getExtras());
            supportFragmentManager.beginTransaction().a(16908290, this.PSI).commit();
        }
        AppMethodBeat.o(37647);
    }

    public static class AddressUIFragment extends AbstractTabChildActivity.AbStractTabFragment implements i {
        private Animation Aod;
        private IListener ELE = new IListener<we>() {
            /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass1 */

            {
                AppMethodBeat.i(161548);
                this.__eventId = we.class.getName().hashCode();
                AppMethodBeat.o(161548);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(we weVar) {
                AppMethodBeat.i(37597);
                we weVar2 = weVar;
                if (AddressUIFragment.this.getContext() == null || AddressUIFragment.this.getContext().isFinishing()) {
                    AppMethodBeat.o(37597);
                } else {
                    if (!weVar2.ecn.eco && AddressUIFragment.this.PSL != null) {
                        ((e) com.tencent.mm.kernel.g.ah(e.class)).getFavourUserChecker().fnb();
                        AddressUIFragment.this.PSL.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(37597);
                }
                return false;
            }
        };
        private TextView PSJ;
        private TextView PSK;
        private a PSL;
        private b PSM;
        private String PSN;
        private String PSO = "";
        private int PSP;
        private AlphabetScrollBar PSQ;
        private LinearLayout PSR = null;
        private boolean PSS = false;
        private boolean PST = false;
        private l PSU;
        private BizContactEntranceView PSV;
        private b PSW;
        private b PSX;
        private b PSY;
        private b PSZ;
        private String PSf;
        private String PSg;
        private ContactCountView PTa;
        private y PTb;
        private j PTc;
        boolean PTd;
        private boolean PTe = true;
        private LinearLayout PTf;
        private VerticalScrollBar.a PTg = new VerticalScrollBar.a() {
            /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
            public final void DP(String str) {
                int i2 = 0;
                AppMethodBeat.i(233983);
                if (AddressUIFragment.this.getString(R.string.gf5).equals(str)) {
                    AddressUIFragment.this.yCT.setSelection(0);
                    AppMethodBeat.o(233983);
                    return;
                }
                a aVar = AddressUIFragment.this.PSL;
                Log.v("MicroMsg.AddressAdapter", "getSections");
                String[] strArr = aVar.PSl;
                if (strArr == null) {
                    AppMethodBeat.o(233983);
                } else if ("↑".equals(str)) {
                    AddressUIFragment.this.yCT.setSelection(0);
                    AppMethodBeat.o(233983);
                } else if ("☆".equals(str)) {
                    AddressUIFragment.this.yCT.setSelection(AddressUIFragment.this.yCT.getHeaderViewsCount());
                    AppMethodBeat.o(233983);
                } else {
                    while (i2 < strArr.length && strArr[i2] != null) {
                        if (strArr[i2].equals(str)) {
                            AddressUIFragment.this.yCT.setSelection(AddressUIFragment.this.PSL.getPositionForSection(i2) + AddressUIFragment.this.yCT.getHeaderViewsCount());
                            AppMethodBeat.o(233983);
                            return;
                        }
                        i2++;
                    }
                    AppMethodBeat.o(233983);
                }
            }
        };
        List<String> PTh = new LinkedList();
        private Runnable PTi = new Runnable() {
            /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(37614);
                AddressUIFragment.s(AddressUIFragment.this);
                AppMethodBeat.o(37614);
            }
        };
        private ProgressDialog gtM = null;
        com.tencent.mm.pluginsdk.ui.e gup = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass11 */

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(233984);
                if (i2 < 2) {
                    AppMethodBeat.o(233984);
                    return;
                }
                if (!AddressUIFragment.this.PSS) {
                    AddressUIFragment.this.PSS = true;
                }
                AppMethodBeat.o(233984);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(233985);
                if (i2 == 2) {
                    d.gGm().gV(AddressUI.class.getName() + ".Listview", 4);
                }
                AppMethodBeat.o(233985);
            }
        });
        List<String> gzY = new LinkedList();
        private final long jpE = 180000;
        private TextView kdj;
        private boolean khr = false;
        private int ppd;
        private int ppe;
        private a pqr;
        private o.g rJj = new o.g() {
            /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(233982);
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        AddressUIFragment.a(AddressUIFragment.this, AddressUIFragment.this.PSO);
                        AppMethodBeat.o(233982);
                        return;
                    case 7:
                        AddressUIFragment.c(AddressUIFragment.this, AddressUIFragment.this.PSO);
                        AppMethodBeat.o(233982);
                        return;
                    default:
                        AppMethodBeat.o(233982);
                        return;
                }
            }
        };
        private Animation sSE;
        private ListView yCT;

        public AddressUIFragment() {
            AppMethodBeat.i(37621);
            AppMethodBeat.o(37621);
        }

        static /* synthetic */ int b(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(37641);
            int topHeight = addressUIFragment.getTopHeight();
            AppMethodBeat.o(37641);
            return topHeight;
        }

        static /* synthetic */ void r(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(37646);
            addressUIFragment.gUr();
            AppMethodBeat.o(37646);
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return R.layout.cf;
        }

        @Override // com.tencent.mm.ui.MMFragment
        public View getLayoutView() {
            AppMethodBeat.i(37622);
            com.tencent.mm.kiss.a.b.aBh();
            View c2 = com.tencent.mm.kiss.a.b.c(getContext(), R.layout.cf);
            AppMethodBeat.o(37622);
            return c2;
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(37623);
            super.onCreate(bundle);
            EventCenter.instance.addListener(this.ELE);
            AppMethodBeat.o(37623);
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
        public boolean supportNavigationSwipeBack() {
            return false;
        }

        @Override // com.tencent.mm.ui.MMFragment
        public boolean noActionBar() {
            return true;
        }

        public final void Cl(boolean z) {
            AppMethodBeat.i(37624);
            if (this.PSQ != null) {
                if (this.sSE == null) {
                    this.sSE = AnimationUtils.loadAnimation(getContext(), R.anim.bh);
                    this.sSE.setDuration(200);
                }
                if (this.Aod == null) {
                    this.Aod = AnimationUtils.loadAnimation(getContext(), R.anim.bh);
                    this.Aod.setDuration(200);
                }
                if (z) {
                    if (this.PSQ.getVisibility() != 0) {
                        this.PSQ.setVisibility(0);
                        this.PSQ.startAnimation(this.sSE);
                        AppMethodBeat.o(37624);
                        return;
                    }
                } else if (4 != this.PSQ.getVisibility()) {
                    this.PSQ.setVisibility(8);
                    this.PSQ.startAnimation(this.Aod);
                }
            }
            AppMethodBeat.o(37624);
        }

        private void gHs() {
            AppMethodBeat.i(233991);
            final View findViewById = getView().getRootView().findViewById(R.id.e8y);
            int eu = au.eu(getContext());
            int D = au.D(getContext(), -1);
            AnonymousClass12 r3 = new Runnable() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass12 */
                int ibG = 0;

                public final void run() {
                    AppMethodBeat.i(37608);
                    if (AddressUIFragment.this.getView() == null) {
                        AppMethodBeat.o(37608);
                        return;
                    }
                    int eu = au.eu(AddressUIFragment.this.getContext());
                    int D = au.D(AddressUIFragment.this.getContext(), -1);
                    if (D <= 0) {
                        if (this.ibG < 2) {
                            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
                            AddressUIFragment.this.getView().post(this);
                        } else {
                            Log.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
                        }
                        this.ibG++;
                    } else {
                        int b2 = AddressUIFragment.b(AddressUIFragment.this);
                        if (b2 != AddressUIFragment.this.getView().getPaddingTop()) {
                            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", Integer.valueOf(b2), Integer.valueOf(AddressUIFragment.this.getView().getPaddingTop()));
                            AddressUIFragment.this.getView().setPadding(0, b2, 0, findViewById.getHeight());
                        } else {
                            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(D), Integer.valueOf(eu));
                        }
                    }
                    Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(this.ibG), Integer.valueOf(D), Integer.valueOf(eu));
                    AppMethodBeat.o(37608);
                }
            };
            if (D <= 0) {
                getView().post(r3);
                AppMethodBeat.o(233991);
                return;
            }
            getView().setPadding(0, getTopHeight(), 0, findViewById.getHeight());
            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(D), Integer.valueOf(eu));
            getView().postDelayed(r3, 100);
            AppMethodBeat.o(233991);
        }

        private int getTopHeight() {
            boolean z;
            boolean z2;
            int i2;
            AppMethodBeat.i(37625);
            int eu = au.eu(getContext());
            int D = au.D(getContext(), -1);
            View findViewById = getView().getRootView().findViewById(R.id.c_);
            if (Build.VERSION.SDK_INT < 24 || LauncherUI.getInstance() == null) {
                z = false;
            } else {
                z = LauncherUI.getInstance().isInMultiWindowMode();
            }
            if (!z) {
                SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
                if (defaultPreference != null) {
                    z2 = defaultPreference.getBoolean("Main_need_read_top_margin", false);
                } else {
                    z2 = false;
                }
                if (z2 && (i2 = defaultPreference.getInt("Main_top_marign", -1)) >= 0) {
                    int i3 = eu + i2;
                    AppMethodBeat.o(37625);
                    return i3;
                }
            }
            if (z) {
                if (findViewById != null) {
                    D = findViewById.getTop();
                } else {
                    D = 0;
                }
            }
            Log.i("MicroMsg.AddressUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", Integer.valueOf(D), Boolean.valueOf(z));
            int i4 = D + eu;
            AppMethodBeat.o(37625);
            return i4;
        }

        @Override // android.support.v4.app.Fragment
        public void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(233992);
            super.onConfigurationChanged(configuration);
            gHs();
            AppMethodBeat.o(233992);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(37626);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
            bg.aVF();
            as Kn = c.aSN().Kn(this.PSO);
            if (Kn == null) {
                Log.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.PSO);
                AppMethodBeat.o(37626);
            } else if (z.aTY().equals(Kn.field_username)) {
                AppMethodBeat.o(37626);
            } else if (ab.IQ(this.PSO)) {
                contextMenu.setHeaderTitle(l.c(view.getContext(), Kn.arJ()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.ew);
                AppMethodBeat.o(37626);
            } else if (ab.Jf(this.PSO) || ab.Jv(this.PSO)) {
                AppMethodBeat.o(37626);
            } else {
                contextMenu.setHeaderTitle(l.c(view.getContext(), Kn.arJ()));
                if (com.tencent.mm.contact.c.oR(Kn.field_type) && Kn.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.string.bd1);
                }
                AppMethodBeat.o(37626);
            }
        }

        @Override // com.tencent.mm.ak.i
        public void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(37627);
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (!Util.isTopActivity(getContext())) {
                AppMethodBeat.o(37627);
            } else if (z.a.a(getContext(), i2, i3, str, 4)) {
                AppMethodBeat.o(37627);
            } else if (i2 == 0 && i3 == 0) {
                AppMethodBeat.o(37627);
            } else {
                AppMethodBeat.o(37627);
            }
        }

        private void gUq() {
            AppMethodBeat.i(37628);
            this.gzY = new LinkedList();
            this.PTh = new LinkedList();
            com.tencent.mm.br.c.gsX();
            this.gzY.add("tmessage");
            this.PTh.addAll(this.gzY);
            if (!this.gzY.contains("officialaccounts")) {
                this.gzY.add("officialaccounts");
            }
            this.gzY.add("helper_entry");
            if (this.PSL != null) {
                this.PSL.jB(this.gzY);
            }
            if (this.PSM != null) {
                this.PSM.jB(this.PTh);
            }
            AppMethodBeat.o(37628);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(37629);
            Log.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i2));
            if (i2 == 6 && i3 == -1) {
                setResult(-1);
                finish();
                AppMethodBeat.o(37629);
            } else if (i3 != -1) {
                AppMethodBeat.o(37629);
            } else {
                switch (i2) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        break;
                }
                AppMethodBeat.o(37629);
            }
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGu() {
            AppMethodBeat.i(37630);
            Log.v("MicroMsg.AddressUI", "address ui on create");
            Log.v("MicroMsg.AddressUI", "on address ui create");
            this.PSS = false;
            this.khr = false;
            this.PST = false;
            this.PSf = null;
            this.PSg = null;
            this.PSN = null;
            bg.azz().a(138, this);
            this.PSf = "@all.contact.without.chatroom.without.openim";
            this.PSg = getStringExtra("Contact_GroupFilter_Str");
            this.PSN = getString(R.string.dwv);
            this.PSP = getIntExtra("List_Type", 2);
            gHs();
            Log.v("MicroMsg.AddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            if (this.yCT != null) {
                if (this.PSU != null) {
                    this.yCT.removeHeaderView(this.PSU);
                }
                if (this.PSV != null) {
                    this.yCT.removeHeaderView(this.PSV);
                }
                if (this.PSW != null) {
                    this.yCT.removeHeaderView(this.PSW);
                }
                if (this.PSZ != null) {
                    this.yCT.removeHeaderView(this.PSZ);
                }
                if (this.PSY != null) {
                    this.yCT.removeHeaderView(this.PSY);
                }
            }
            this.yCT = (ListView) findViewById(R.id.h4);
            this.yCT.setScrollingCacheEnabled(false);
            this.PSJ = (TextView) findViewById(R.id.c2l);
            this.PSJ.setText(R.string.ez);
            this.kdj = (TextView) findViewById(R.id.c3h);
            this.kdj.setText(R.string.f1);
            this.PSK = (TextView) findViewById(R.id.c42);
            this.PSK.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass20 */

                public final void onClick(View view) {
                    AppMethodBeat.i(37615);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37615);
                }
            });
            this.PSL = new a(getContext(), this.PSf, this.PSg, this.PSP);
            this.yCT.setAdapter((ListAdapter) null);
            this.PSL.a(new f.a() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass21 */

                @Override // com.tencent.mm.ui.f.a
                public final void bnE() {
                    AppMethodBeat.i(37616);
                    AddressUIFragment addressUIFragment = AddressUIFragment.this;
                    AddressUIFragment.this.PSL.getCount();
                    AddressUIFragment.c(addressUIFragment);
                    AddressUIFragment.this.PSL.gUn();
                    AppMethodBeat.o(37616);
                }

                @Override // com.tencent.mm.ui.f.a
                public final void gHg() {
                }
            });
            this.PSL.PSs = true;
            this.PSL.setFragment(this);
            this.PSL.setGetViewPositionCallback(new MMSlideDelView.c() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass22 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.c
                public final int dr(View view) {
                    AppMethodBeat.i(37617);
                    View view2 = view;
                    while (true) {
                        try {
                            View view3 = (View) view2.getParent();
                            if (view3 != null && !view3.equals(AddressUIFragment.this.yCT)) {
                                view2 = view3;
                            }
                        } catch (ClassCastException e2) {
                            AppMethodBeat.o(37617);
                            return -1;
                        }
                    }
                    if (view2.getParent() == null) {
                        AppMethodBeat.o(37617);
                        return -1;
                    }
                    int positionForView = AddressUIFragment.this.yCT.getPositionForView(view);
                    AppMethodBeat.o(37617);
                    return positionForView;
                }
            });
            this.PSL.setPerformItemClickListener(new MMSlideDelView.g() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass23 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.g
                public final void r(View view, int i2, int i3) {
                    AppMethodBeat.i(37618);
                    AddressUIFragment.this.yCT.performItemClick(view, i2, (long) i3);
                    AppMethodBeat.o(37618);
                }
            });
            this.PSL.a(new MMSlideDelView.f() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass24 */

                @Override // com.tencent.mm.ui.base.MMSlideDelView.f
                public final void cZ(Object obj) {
                    AppMethodBeat.i(37619);
                    if (obj == null) {
                        Log.e("MicroMsg.AddressUI", "onItemDel object null");
                        AppMethodBeat.o(37619);
                        return;
                    }
                    AddressUIFragment.a(AddressUIFragment.this, obj.toString());
                    AppMethodBeat.o(37619);
                }
            });
            this.PSM = new b(getContext(), 1);
            this.PSM.CR(true);
            this.PTf = new LinearLayout(getContext());
            this.PTf.setOrientation(1);
            this.yCT.addHeaderView(this.PTf);
            this.PSX = new b(getContext(), b.a.ContactIpCall);
            this.PTf.addView(this.PSX);
            bg.aVF();
            ((Boolean) c.azQ().get(ar.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
            this.PSX.setVisible(false);
            this.PSU = new l(getContext());
            this.PTf.addView(this.PSU);
            this.PSZ = new b(getContext(), b.a.OnlyChat);
            this.PTf.addView(this.PSZ);
            boolean z = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_CHATONLY_ENTRANCE_BOOLEAN, false);
            if (!z) {
                h.RTc.aY(new Runnable() {
                    /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass25 */

                    public final void run() {
                        AppMethodBeat.i(233989);
                        com.tencent.mm.kernel.g.aAi();
                        if (((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjS("@social.black.android") > 0) {
                            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CHATONLY_ENTRANCE_BOOLEAN, Boolean.TRUE);
                            AddressUIFragment.this.PSZ.post(new Runnable() {
                                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass25.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(233988);
                                    AddressUIFragment.this.PSZ.setVisible(true);
                                    AppMethodBeat.o(233988);
                                }
                            });
                        }
                        AppMethodBeat.o(233989);
                    }
                });
            }
            this.PSZ.setVisible(z);
            this.PSW = new b(getContext(), b.a.Chatromm);
            this.PTf.addView(this.PSW);
            this.PSW.setVisible(true);
            this.PSY = new b(getContext(), b.a.ContactLabel);
            this.PTf.addView(this.PSY);
            this.PSY.setVisible(true);
            ListView listView = this.yCT;
            ContactCountView contactCountView = new ContactCountView(getContext());
            this.PTa = contactCountView;
            listView.addFooterView(contactCountView, null, false);
            if (com.tencent.mm.br.c.aZU("brandservice")) {
                this.PSV = new BizContactEntranceView(getContext());
                this.PTf.addView(this.PSV);
                this.PSV.setVisible(true);
            }
            AnonymousClass26 r0 = new y.b() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass26 */

                @Override // com.tencent.mm.ui.contact.y.b
                public final void Cm(boolean z) {
                    AppMethodBeat.i(233990);
                    if (AddressUIFragment.this.PSV == null) {
                        AppMethodBeat.o(233990);
                        return;
                    }
                    AddressUIFragment.this.PSV.Cn(!z);
                    AppMethodBeat.o(233990);
                }
            };
            this.PTb = new y(getContext(), new y.a() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass2 */

                @Override // com.tencent.mm.ui.contact.y.a
                public final void anE(int i2) {
                    AppMethodBeat.i(233976);
                    if (AddressUIFragment.this.PTb == null || AddressUIFragment.this.PSV == null) {
                        AppMethodBeat.o(233976);
                    } else if (i2 <= 0) {
                        AddressUIFragment.this.PTb.setVisibility(8);
                        AddressUIFragment.this.PSV.Cn(true);
                        AppMethodBeat.o(233976);
                    } else {
                        AddressUIFragment.this.PTb.setVisibility(0);
                        AddressUIFragment.this.PSV.Cn(false);
                        AppMethodBeat.o(233976);
                    }
                }
            });
            this.PTb.setOnVisibilityChangeListener(r0);
            if (this.PTb.getOpenIMCount() <= 0) {
                r0.Cm(false);
                this.PTb.setVisibility(8);
            } else {
                r0.Cm(true);
            }
            this.PTf.addView(this.PTb);
            this.PTc = new j(getContext(), new j.a() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass3 */

                @Override // com.tencent.mm.ui.contact.j.a
                public final void anF(int i2) {
                    AppMethodBeat.i(233977);
                    if (AddressUIFragment.this.PTc == null) {
                        AppMethodBeat.o(233977);
                    } else if (i2 <= 0) {
                        AddressUIFragment.this.PTc.setVisibility(8);
                        AppMethodBeat.o(233977);
                    } else {
                        AddressUIFragment.this.PTc.setVisibility(0);
                        AppMethodBeat.o(233977);
                    }
                }
            });
            if (this.PTc.getEnterpriseFriendCount() <= 0) {
                this.PTc.setVisibility(8);
            }
            this.PTf.addView(this.PTc);
            this.pqr = new a(getContext());
            this.PSL.PSq = new a.AbstractC2109a() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass4 */
            };
            this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass5 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(233978);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    Log.i("MicroMsg.AddressUI", "onItemClick " + i2 + (AddressUIFragment.this.PSM == null ? AddressUIFragment.this.PSM : Boolean.valueOf(AddressUIFragment.this.PSM.QBl)));
                    if (i2 == 0 && !"@biz.contact".equals(AddressUIFragment.this.PSf)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(233978);
                    } else if (i2 < AddressUIFragment.this.yCT.getHeaderViewsCount()) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(233978);
                    } else {
                        int headerViewsCount = i2 - AddressUIFragment.this.yCT.getHeaderViewsCount();
                        if (AddressUIFragment.this.PSM == null || !AddressUIFragment.this.PSM.QBl) {
                            com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) AddressUIFragment.this.PSL.getItem(headerViewsCount);
                            if (fVar != null) {
                                String str = fVar.field_username;
                                AddressUIFragment addressUIFragment = AddressUIFragment.this;
                                if (str != null && str.length() > 0 && ((!as.bjp(str) && !as.bjq(str)) || WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(addressUIFragment.getContext()))) {
                                    if (ab.Js(str)) {
                                        Log.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", str);
                                    } else {
                                        Intent intent = new Intent();
                                        intent.putExtra("Contact_User", str);
                                        if (ab.IQ(str)) {
                                            intent.putExtra("Is_group_card", true);
                                        }
                                        if (str != null && str.length() > 0) {
                                            e.a(intent, str);
                                            intent.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                            com.tencent.mm.br.c.b(addressUIFragment.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                            ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(str, 10);
                                        }
                                    }
                                }
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(233978);
                            return;
                        }
                        boolean Ox = AddressUIFragment.this.PSM.Ox(headerViewsCount);
                        boolean aot = AddressUIFragment.this.PSM.aot(headerViewsCount);
                        Log.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(aot)));
                        if (aot) {
                            AddressUIFragment.this.PSM.boh("");
                        } else if (Ox) {
                            drr aos = AddressUIFragment.this.PSM.aos(headerViewsCount);
                            String str2 = aos.Lqk.MTo;
                            bg.aVF();
                            as Kn = c.aSN().Kn(str2);
                            if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("Contact_User", str2);
                                intent2.putExtra("Contact_Scene", 3);
                                if (str2 != null && str2.length() > 0) {
                                    if (Kn.gBM()) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, str2 + ",3");
                                    }
                                    e.a(intent2, str2);
                                    intent2.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                    com.tencent.mm.br.c.b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
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
                                        Log.printErrStackTrace("MicroMsg.AddressUI", e2, "", new Object[0]);
                                    }
                                }
                                if ((aos.MmK & 8) > 0) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, str2 + ",3");
                                }
                                intent3.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                com.tencent.mm.br.c.b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                            }
                        } else {
                            as Ln = AddressUIFragment.this.PSM.Ln(headerViewsCount);
                            if (Ln == null) {
                                Log.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(AddressUIFragment.this.PSM.getCount()), Integer.valueOf(headerViewsCount));
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(233978);
                                return;
                            }
                            String str3 = Ln.field_username;
                            if (ab.Js(str3)) {
                                Intent intent4 = new Intent(AddressUIFragment.this.getContext(), AddressUI.class);
                                intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                                AddressUIFragment addressUIFragment2 = AddressUIFragment.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                                com.tencent.mm.hellhoundlib.a.a.a(addressUIFragment2, bl.axQ(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                addressUIFragment2.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(addressUIFragment2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(233978);
                                return;
                            }
                            Intent intent5 = new Intent();
                            intent5.putExtra("Contact_User", str3);
                            intent5.putExtra("Contact_Scene", 3);
                            intent5.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                            if (str3 != null && str3.length() > 0) {
                                com.tencent.mm.br.c.b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent5);
                            }
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(233978);
                    }
                }
            });
            this.yCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass6 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(233979);
                    Log.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i2)));
                    if (i2 < AddressUIFragment.this.yCT.getHeaderViewsCount()) {
                        Log.w("MicroMsg.AddressUI", "on item long click, but match header view");
                        AppMethodBeat.o(233979);
                        return true;
                    } else if (AddressUIFragment.this.PSM == null || !AddressUIFragment.this.PSM.QBl) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) AddressUIFragment.this.PSL.getItem(i2 - AddressUIFragment.this.yCT.getHeaderViewsCount());
                        if (fVar == null) {
                            Log.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i2), Integer.valueOf(AddressUIFragment.this.yCT.getHeaderViewsCount()));
                            AppMethodBeat.o(233979);
                            return true;
                        }
                        String str = fVar.field_username;
                        if (ab.Js(str) || ab.Jt(str)) {
                            AppMethodBeat.o(233979);
                            return true;
                        }
                        AddressUIFragment.this.PSO = str;
                        AddressUIFragment.this.pqr.a(view, i2, j2, AddressUIFragment.this, AddressUIFragment.this.rJj, AddressUIFragment.this.ppd, AddressUIFragment.this.ppe);
                        AppMethodBeat.o(233979);
                        return true;
                    } else {
                        AppMethodBeat.o(233979);
                        return true;
                    }
                }
            });
            this.yCT.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass7 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(233980);
                    switch (motionEvent.getAction()) {
                        case 0:
                            AddressUIFragment.this.hideVKB();
                            AddressUIFragment.this.ppd = (int) motionEvent.getRawX();
                            AddressUIFragment.this.ppe = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(233980);
                    return false;
                }
            });
            this.yCT.setOnScrollListener(this.gup);
            this.yCT.setDrawingCacheEnabled(false);
            this.PSQ = (AlphabetScrollBar) findViewById(R.id.hl);
            this.PSQ.setOnScrollBarTouchListener(this.PTg);
            bg.aVF();
            c.aSN().add(this.PSL);
            if (this.PTc != null) {
                ag.bah().a(this.PTc, (Looper) null);
            }
            AppMethodBeat.o(37630);
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGv() {
            AppMethodBeat.i(37631);
            Log.v("MicroMsg.AddressUI", "address ui on resume");
            long currentTimeMillis = System.currentTimeMillis();
            bg.aVF();
            if (currentTimeMillis - Util.nullAs((Long) c.azQ().get(340226, (Object) null), 0) >= 180000) {
                gUs();
            }
            if (this.PTe) {
                this.PTe = false;
                this.PTd = false;
                gUq();
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass15 */

                    public final void run() {
                        AppMethodBeat.i(37611);
                        Log.i("MicroMsg.AddressUI", "rcontact db init select count: %d", Integer.valueOf(AddressUIFragment.this.PSL.getCount()));
                        AddressUIFragment.this.yCT.post(new Runnable() {
                            /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass15.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(233986);
                                AddressUIFragment.this.yCT.setAdapter((ListAdapter) AddressUIFragment.this.PSL);
                                Log.i("MicroMsg.AddressUI", "post to first init finish");
                                View findViewById = AddressUIFragment.this.findViewById(R.id.epv);
                                if (findViewById != null) {
                                    findViewById.setVisibility(8);
                                    findViewById.startAnimation(AnimationUtils.loadAnimation(AddressUIFragment.this.getContext(), R.anim.bs));
                                }
                                AppMethodBeat.o(233986);
                            }
                        });
                        AddressUIFragment.this.PSM.CQ(false);
                        AppMethodBeat.o(37611);
                    }
                });
            } else if (this.PTd) {
                this.PTd = false;
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass16 */

                    public final void run() {
                        AppMethodBeat.i(37612);
                        Process.setThreadPriority(10);
                        AddressUIFragment.r(AddressUIFragment.this);
                        AppMethodBeat.o(37612);
                    }
                }, "AddressUI_updateUIData", 4);
                this.PTa.gUw();
            }
            if (this.PSV != null) {
                BizContactEntranceView bizContactEntranceView = this.PSV;
                bizContactEntranceView.gUu();
                bizContactEntranceView.setVisible(true);
            }
            if (this.PTc != null) {
                if (this.PTc.getEnterpriseFriendCount() <= 0) {
                    this.PTc.setVisibility(8);
                } else {
                    this.PTc.setVisibility(0);
                }
            }
            bg.aVF();
            this.PSS = ((Boolean) c.azQ().get(12296, Boolean.FALSE)).booleanValue();
            if (this.PSP == 2) {
                bg.aVF();
                as Kn = c.aSN().Kn(com.tencent.mm.model.z.aTY());
                if (Kn != null && (!com.tencent.mm.contact.c.oR(Kn.field_type) || !Util.isNullOrNil(Kn.field_conRemark) || !Util.isNullOrNil(Kn.field_conRemarkPYFull) || !Util.isNullOrNil(Kn.field_conRemarkPYShort))) {
                    Kn.aqQ();
                    Kn.BD("");
                    Kn.BI("");
                    Kn.BJ("");
                    bg.aVF();
                    c.aSN().c(com.tencent.mm.model.z.aTY(), Kn);
                }
            }
            if (this.PSM != null) {
                this.PSM.onResume();
            }
            this.PSL.OzQ = false;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(37613);
                    AddressUIFragment.this.PSL.resume();
                    AppMethodBeat.o(37613);
                }
            });
            if (this.PSU != null) {
                this.PSU.setFrontGround(true);
                l.gUK();
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.getHomeUI().setTitleBarDoubleClickListener(this.PTi);
            }
            AppMethodBeat.o(37631);
        }

        private synchronized void gUr() {
            AppMethodBeat.i(37632);
            long currentTimeMillis = System.currentTimeMillis();
            gUq();
            Log.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.PSL != null) {
                Log.v("MicroMsg.AddressUI", "post to do refresh");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(37609);
                        AddressUIFragment.this.PSL.gUp();
                        if (AddressUIFragment.this.PTc != null) {
                            AddressUIFragment.this.PTc.reset();
                        }
                        AppMethodBeat.o(37609);
                    }
                });
            }
            if (this.PSM != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass14 */

                    public final void run() {
                        AppMethodBeat.i(37610);
                        Log.v("MicroMsg.AddressUI", "post search adapter to do refresh");
                        AddressUIFragment.this.PSM.onNotifyChange(null, null);
                        AppMethodBeat.o(37610);
                    }
                });
            }
            Log.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis2));
            AppMethodBeat.o(37632);
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGw() {
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGx() {
            AppMethodBeat.i(37633);
            Log.i("MicroMsg.AddressUI", "AddressUI on Pause");
            bg.aVF();
            c.azQ().set(340226, Long.valueOf(System.currentTimeMillis()));
            bg.aVF();
            c.azQ().set(12296, Boolean.valueOf(this.PSS));
            if (this.PSM != null) {
                this.PSM.onPause();
            }
            this.PSL.gUo();
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(233987);
                    AddressUIFragment.this.PSL.pause();
                    AppMethodBeat.o(233987);
                }
            });
            if (this.PSU != null) {
                this.PSU.setFrontGround(false);
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.getHomeUI().aI(this.PTi);
            }
            AppMethodBeat.o(37633);
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGy() {
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGz() {
            AppMethodBeat.i(37634);
            Log.v("MicroMsg.AddressUI", "onDestory");
            if (this.PSQ != null) {
                this.PSQ.OWL = null;
            }
            bg.azz().b(138, this);
            if (this.PSL != null) {
                this.PSL.AV(true);
                this.PSL.detach();
                this.PSL.gGV();
            }
            if (this.PSM != null) {
                this.PSM.detach();
                this.PSM.ebf();
            }
            if (bg.aAc() && this.PSL != null) {
                bg.aVF();
                c.aSN().remove(this.PSL);
            }
            if (bg.aAc() && this.PTc != null) {
                ag.bah().a(this.PTc);
            }
            if (this.PSU != null) {
                l lVar = this.PSU;
                if (bg.aAc()) {
                    com.tencent.mm.bj.d.bgN().remove(lVar.PVF);
                }
                this.PSU = null;
            }
            if (this.PSV != null) {
                this.PSV = null;
            }
            if (this.PSW != null) {
                this.PSW = null;
            }
            if (this.PSZ != null) {
                this.PSZ = null;
            }
            if (this.PSY != null) {
                this.PSY = null;
            }
            AppMethodBeat.o(37634);
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            AppMethodBeat.i(37635);
            super.onDestroy();
            EventCenter.instance.removeListener(this.ELE);
            AppMethodBeat.o(37635);
        }

        @Override // com.tencent.mm.ui.n, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGB() {
            AppMethodBeat.i(37636);
            if (this.PSL != null) {
                a aVar = this.PSL;
                aVar.PSw.clear();
                aVar.PSu.clear();
                aVar.PSv = false;
            }
            Log.i("MicroMsg.INIT", "KEVIN Address turnTobg");
            if (this.PSV != null) {
                this.PSV.destroyDrawingCache();
            }
            if (this.PSW != null) {
                this.PSW.destroyDrawingCache();
            }
            if (this.PSY != null) {
                this.PSY.destroyDrawingCache();
            }
            if (this.PSZ != null) {
                this.PSZ.destroyDrawingCache();
            }
            if (this.PTa != null) {
                this.PTa.destroyDrawingCache();
            }
            if (this.PSU != null) {
                this.PSU.destroyDrawingCache();
            }
            AppMethodBeat.o(37636);
        }

        @Override // com.tencent.mm.ui.n, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGC() {
            AppMethodBeat.i(37637);
            Log.v("MicroMsg.INIT", "KEVIN Address turnTofg");
            AppMethodBeat.o(37637);
        }

        @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
        public final void gGA() {
            AppMethodBeat.i(37638);
            Log.v("MicroMsg.AddressUI", "request to top");
            if (this.yCT != null) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.yCT);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            }
            AppMethodBeat.o(37638);
        }

        @Override // com.tencent.mm.ui.n
        public final void gHE() {
            AppMethodBeat.i(37639);
            if (this.PSU != null) {
                l.gUK();
            }
            AppMethodBeat.o(37639);
        }

        @Override // com.tencent.mm.ui.n
        public final void gHF() {
        }

        public final void gUs() {
            AppMethodBeat.i(37640);
            if (this.yCT != null) {
                this.yCT.setSelection(0);
            }
            AppMethodBeat.o(37640);
        }

        static /* synthetic */ void c(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(37642);
            addressUIFragment.PSJ.setVisibility(8);
            addressUIFragment.yCT.setVisibility(0);
            AppMethodBeat.o(37642);
        }

        static /* synthetic */ void a(AddressUIFragment addressUIFragment, String str) {
            AppMethodBeat.i(37643);
            bg.aVF();
            c.aSN().remove(addressUIFragment.PSL);
            bg.aVF();
            as Kn = c.aSN().Kn(str);
            Kn.aqR();
            ab.G(Kn);
            if (ab.Eq(str)) {
                bg.aVF();
                c.aSN().aNa(str);
                bg.aVF();
                c.aSX().Kj(str);
            } else {
                bg.aVF();
                c.aSN().c(str, Kn);
            }
            addressUIFragment.PSL.hi(str, 5);
            bg.aVF();
            c.aSN().add(addressUIFragment.PSL);
            AppMethodBeat.o(37643);
        }

        static /* synthetic */ void c(AddressUIFragment addressUIFragment, String str) {
            AppMethodBeat.i(233993);
            bg.aVF();
            as Kn = c.aSN().Kn(str);
            if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                Intent intent = new Intent();
                intent.setClass(addressUIFragment.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", Kn.field_username);
                intent.putExtra("view_mode", true);
                Activity context = addressUIFragment.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "viewRemarkInfo", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "viewRemarkInfo", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(233993);
        }

        static /* synthetic */ void s(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(233994);
            LauncherUI launcherUI = (LauncherUI) addressUIFragment.getContext();
            if (launcherUI == null || launcherUI.ODR.getMainTabUI().acm == 1) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(addressUIFragment.yCT);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "doubleTap", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "doubleTap", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(233981);
                        AddressUIFragment.this.yCT.setSelection(0);
                        AppMethodBeat.o(233981);
                    }
                }, 300);
            }
            AppMethodBeat.o(233994);
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
    }
}
