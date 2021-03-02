package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.t;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements i {
    private static int Dew = 5;
    private boolean Dcl;
    private List<String> Deu;
    private a Dev;
    private View oQL;
    private q sOk;
    private GridView wmW;
    private TextView xVY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void g(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.i(74493);
        settingsTrustFriendUI.eTA();
        AppMethodBeat.o(74493);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74484);
        super.onCreate(bundle);
        String str = (String) g.aAh().azQ().get(352277, (Object) null);
        if (!Util.isNullOrNil(str)) {
            this.Deu = Util.stringsToList(str.split(","));
        }
        if (this.Deu == null) {
            this.Deu = new ArrayList();
        }
        getContentView().post(new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(74468);
                SettingsTrustFriendUI.a(SettingsTrustFriendUI.this);
                AppMethodBeat.o(74468);
            }
        });
        initView();
        AppMethodBeat.o(74484);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brh;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(74485);
        super.onStart();
        g.azz().a(869, this);
        g.azz().a(583, this);
        AppMethodBeat.o(74485);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(74486);
        super.onStop();
        g.azz().b(869, this);
        g.azz().b(583, this);
        AppMethodBeat.o(74486);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74487);
        setMMTitle(R.string.gvk);
        this.wmW = (GridView) findViewById(R.id.ivr);
        this.Dev = new a(this, (byte) 0);
        this.wmW.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.il));
        this.wmW.setNumColumns(-1);
        this.wmW.setStretchMode(1);
        this.wmW.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.a8t) * 2);
        this.wmW.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.a8u));
        this.wmW.setAdapter((ListAdapter) this.Dev);
        ((ViewGroup) this.wmW.getParent()).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(74473);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SettingsTrustFriendUI.this.Dcl) {
                    SettingsTrustFriendUI.this.Dcl = false;
                    SettingsTrustFriendUI.this.Dev.notifyDataSetChanged();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74473);
            }
        });
        this.wmW.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74474);
                if (SettingsTrustFriendUI.this.Dcl && motionEvent.getAction() == 1 && SettingsTrustFriendUI.this.wmW.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) == -1) {
                    SettingsTrustFriendUI.this.Dcl = false;
                    SettingsTrustFriendUI.this.Dev.notifyDataSetChanged();
                    AppMethodBeat.o(74474);
                    return true;
                }
                AppMethodBeat.o(74474);
                return false;
            }
        });
        this.wmW.setHorizontalScrollBarEnabled(false);
        this.wmW.setVerticalScrollBarEnabled(false);
        this.wmW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass8 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(74475);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (SettingsTrustFriendUI.this.Dev.getItemViewType(i2) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", SettingsTrustFriendUI.this.getString(R.string.g4));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.Dew);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", Util.listToString(SettingsTrustFriendUI.this.Deu, ","));
                    intent.putExtra("block_contact", z.aTY());
                    intent.putExtra("list_attr", u.ll(u.ll(u.PWY, 256), TPMediaCodecProfileLevel.HEVCMainTierLevel62));
                    intent.putExtra("KBlockOpenImFav", true);
                    intent.putExtra("without_openim", true);
                    intent.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(R.string.gvm, new Object[]{Integer.valueOf(SettingsTrustFriendUI.Dew)}));
                    c.c(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", intent, 1);
                } else {
                    if (SettingsTrustFriendUI.this.Dev.getItemViewType(i2) == 2) {
                        if (!SettingsTrustFriendUI.this.Dcl) {
                            SettingsTrustFriendUI.this.Dcl = true;
                        }
                    } else if (SettingsTrustFriendUI.this.Dev.getItemViewType(i2) == 0 && SettingsTrustFriendUI.this.Dcl) {
                        SettingsTrustFriendUI.this.Deu.remove(SettingsTrustFriendUI.this.Dev.getItem(i2));
                        if (SettingsTrustFriendUI.this.Deu.size() == 0) {
                            SettingsTrustFriendUI.this.Dcl = false;
                        }
                    }
                    SettingsTrustFriendUI.this.Dev.notifyDataSetChanged();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(74475);
            }
        });
        this.xVY = (TextView) findViewById(R.id.ivq);
        String stringExtra = getIntent().getStringExtra(e.m.Ozm);
        if (!Util.isNullOrNil(stringExtra)) {
            this.xVY.setText(stringExtra);
        } else {
            this.xVY.setText(getResources().getString(R.string.gvo, 3));
        }
        this.oQL = findViewById(R.id.ivu);
        this.oQL.setVisibility(8);
        ((TextView) this.oQL.findViewById(R.id.jj6)).setText(getString(R.string.gvn, new Object[]{3}));
        this.oQL.findViewById(R.id.b4d).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(74476);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTrustFriendUI.this.oQL.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74476);
            }
        });
        findViewById(R.id.ivs).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(74477);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
                c.b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74477);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74478);
                SettingsTrustFriendUI.g(SettingsTrustFriendUI.this);
                AppMethodBeat.o(74478);
                return true;
            }
        });
        addTextOptionMenu(1, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74479);
                SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
                AppMethodBeat.o(74479);
                return true;
            }
        }, null, t.b.GREEN);
        showOptionMenu(true);
        AppMethodBeat.o(74487);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74488);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!Util.isNullOrNil(stringExtra)) {
                this.Deu.clear();
                this.Deu.addAll(Util.stringsToList(stringExtra.split(",")));
                this.Dev.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(74488);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(74489);
        Log.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.sOk != null) {
            this.sOk.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 869) {
                bwi bwi = (bwi) ((d) qVar.getReqResp()).iLL.iLR;
                Dew = bwi.Mch;
                LinkedList<eku> linkedList = bwi.KHC;
                if (linkedList.size() != this.Deu.size()) {
                    z = true;
                } else if (linkedList.size() != 0) {
                    Iterator<eku> it = linkedList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!this.Deu.contains(it.next().UserName)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (z) {
                    this.Deu.clear();
                    for (eku eku : linkedList) {
                        this.Deu.add(eku.UserName);
                    }
                    this.Dev.notifyDataSetChanged();
                }
                if (this.Deu.size() > 0 && this.Deu.size() < 3) {
                    this.oQL.setVisibility(0);
                }
                g.aAh().azQ().set(352277, Util.listToString(this.Deu, ","));
                AppMethodBeat.o(74489);
                return;
            } else if (qVar.getType() == 583) {
                g.aAh().azQ().set(352277, Util.listToString(this.Deu, ","));
                finish();
                AppMethodBeat.o(74489);
                return;
            }
        } else if (!Util.isNullOrNil(str)) {
            h.cD(this, str);
        }
        AppMethodBeat.o(74489);
    }

    private void eTA() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(74490);
        String str = (String) g.aAh().azQ().get(352277, (Object) null);
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!Util.isNullOrNil(str)) {
            arrayList = Util.stringsToList(str.split(","));
        } else {
            arrayList = arrayList2;
        }
        if (this.Deu.size() != arrayList.size() || !this.Deu.containsAll(arrayList)) {
            h.a((Context) this, getString(R.string.gar), getString(R.string.zb), getString(R.string.yl), getString(R.string.x7), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74470);
                    SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
                    AppMethodBeat.o(74470);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74471);
                    SettingsTrustFriendUI.this.finish();
                    AppMethodBeat.o(74471);
                }
            });
            AppMethodBeat.o(74490);
            return;
        }
        finish();
        AppMethodBeat.o(74490);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(74491);
        if (i2 == 4) {
            eTA();
            AppMethodBeat.o(74491);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(74491);
        return onKeyUp;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(SettingsTrustFriendUI settingsTrustFriendUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(74480);
            int size = SettingsTrustFriendUI.this.Deu.size();
            if (!SettingsTrustFriendUI.this.Dcl) {
                if (size == 0) {
                    size = 1;
                } else if (size <= 0 || size >= SettingsTrustFriendUI.Dew) {
                    size = size >= SettingsTrustFriendUI.Dew ? size + 1 : 0;
                } else {
                    size += 2;
                }
            }
            AppMethodBeat.o(74480);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(74481);
            if (getItemViewType(i2) == 0) {
                Object obj = SettingsTrustFriendUI.this.Deu.get(i2);
                AppMethodBeat.o(74481);
                return obj;
            }
            AppMethodBeat.o(74481);
            return null;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(74482);
            int size = SettingsTrustFriendUI.this.Deu.size();
            if (SettingsTrustFriendUI.this.Dcl || i2 < size) {
                AppMethodBeat.o(74482);
                return 0;
            } else if (size == 0) {
                AppMethodBeat.o(74482);
                return 1;
            } else if (size >= SettingsTrustFriendUI.Dew) {
                AppMethodBeat.o(74482);
                return 2;
            } else if (i2 == size) {
                AppMethodBeat.o(74482);
                return 1;
            } else if (i2 == size + 1) {
                AppMethodBeat.o(74482);
                return 2;
            } else {
                AppMethodBeat.o(74482);
                return -1;
            }
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1689a aVar;
            AppMethodBeat.i(74483);
            if (view == null) {
                view = SettingsTrustFriendUI.this.getLayoutInflater().inflate(R.layout.bri, (ViewGroup) null);
                C1689a aVar2 = new C1689a(this, (byte) 0);
                aVar2.COW = (ImageView) view.findViewById(R.id.ivo);
                aVar2.DeA = (ImageView) view.findViewById(R.id.ivp);
                aVar2.oSN = (TextView) view.findViewById(R.id.ivt);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1689a) view.getTag();
            }
            if (getItemViewType(i2) == 0) {
                String str = (String) SettingsTrustFriendUI.this.Deu.get(i2);
                as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                aVar.COW.setScaleType(ImageView.ScaleType.FIT_XY);
                a.b.c(aVar.COW, str);
                aVar.oSN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(SettingsTrustFriendUI.this, Kn.arJ(), aVar.oSN.getTextSize()));
                if (SettingsTrustFriendUI.this.Dcl) {
                    aVar.DeA.setVisibility(0);
                } else {
                    aVar.DeA.setVisibility(8);
                }
            } else {
                aVar.oSN.setVisibility(4);
                aVar.DeA.setVisibility(8);
                aVar.COW.setScaleType(ImageView.ScaleType.FIT_XY);
                if (getItemViewType(i2) == 1) {
                    aVar.COW.setImageResource(R.drawable.gg);
                } else if (getItemViewType(i2) == 2) {
                    aVar.COW.setImageResource(R.drawable.gh);
                }
            }
            AppMethodBeat.o(74483);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI$a$a  reason: collision with other inner class name */
        class C1689a {
            ImageView COW;
            ImageView DeA;
            TextView oSN;

            private C1689a() {
            }

            /* synthetic */ C1689a(a aVar, byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.i(74492);
        final com.tencent.mm.plugin.setting.model.h hVar = new com.tencent.mm.plugin.setting.model.h();
        g.azz().a(hVar, 0);
        settingsTrustFriendUI.getString(R.string.ty);
        settingsTrustFriendUI.sOk = h.a((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74472);
                g.azz().a(hVar);
                AppMethodBeat.o(74472);
            }
        });
        AppMethodBeat.o(74492);
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        AppMethodBeat.i(74494);
        if (settingsTrustFriendUI.Deu.size() <= 0 || settingsTrustFriendUI.Deu.size() >= 3) {
            final com.tencent.mm.plugin.setting.model.c cVar = new com.tencent.mm.plugin.setting.model.c(settingsTrustFriendUI.Deu);
            g.azz().a(cVar, 0);
            if (settingsTrustFriendUI.sOk != null) {
                settingsTrustFriendUI.sOk.dismiss();
            }
            settingsTrustFriendUI.getString(R.string.ty);
            settingsTrustFriendUI.sOk = h.a((Context) settingsTrustFriendUI, settingsTrustFriendUI.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(74469);
                    g.azz().a(cVar);
                    AppMethodBeat.o(74469);
                }
            });
            AppMethodBeat.o(74494);
            return;
        }
        h.c(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.string.gvn, new Object[]{3}), settingsTrustFriendUI.getString(R.string.zb), true);
        AppMethodBeat.o(74494);
    }
}
