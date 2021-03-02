package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthOtherUI extends MMActivity implements i {
    private aj JeI;
    private drk JeJ;
    private boolean JeK = false;
    private a JeQ;
    private int accountType = 2;
    private String appId;
    private String edo;
    private String extData;
    private q gxX;
    private int lGW;
    private long startTime;
    private String state;
    private String transaction;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(79721);
        super.onCreate(bundle);
        g.azz().a(1346, this);
        g.azz().a(1137, this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ((TextView) findViewById(R.id.ea4)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(211043);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 0, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.this.JeI.agb(-2);
                SDKOAuthOtherUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(211043);
            }
        });
        Intent intent = getIntent();
        this.appId = intent.getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.transaction = intent.getStringExtra("1");
        try {
            this.JeJ = (drk) new drk().parseFrom(intent.getByteArrayExtra("2"));
        } catch (IOException e2) {
            Log.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        }
        this.state = intent.getStringExtra("4");
        this.extData = intent.getStringExtra("7");
        this.JeK = intent.getBooleanExtra("auth_from_scan", false);
        if (this.JeK) {
            this.accountType = 3;
            this.edo = intent.getStringExtra("auth_raw_url");
            this.JeI = new aj(this, this.appId, this.edo);
        } else {
            this.JeI = new aj(this, this.appId, this.transaction, this.state, this.extData);
        }
        this.lGW = intent.getIntExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, -1);
        TextView textView = (TextView) findViewById(R.id.vy);
        textView.setText(R.string.fc8);
        textView.getPaint().setFakeBoldText(true);
        TextView textView2 = (TextView) findViewById(R.id.vu);
        if (!Util.isNullOrNil(this.JeJ.MUa)) {
            textView2.setVisibility(0);
            textView2.setText(this.JeJ.MUa);
        } else {
            textView2.setVisibility(8);
        }
        c.a aVar = new c.a();
        aVar.jbq = R.raw.native_oauth_default_head_img;
        aVar.jbx = getResources().getDimension(R.dimen.aie);
        aVar.iaT = true;
        com.tencent.mm.av.q.bcV().a(this.JeJ.Mzt, (ImageView) findViewById(R.id.fv7), aVar.bdv());
        ((TextView) findViewById(R.id.fv_)).setText(this.JeJ.ixZ);
        ListView listView = (ListView) findViewById(R.id.vx);
        LinkedList linkedList = new LinkedList();
        Iterator<cuh> it = this.JeJ.Mzs.iterator();
        final boolean z2 = false;
        while (it.hasNext()) {
            cuh next = it.next();
            if (!next.scope.equals("snsapi_userinfo") && !next.scope.equals("snsapi_login") && !next.scope.equals("group_sns_login") && !next.scope.equals("snsapi_friend")) {
                linkedList.add(next);
                if (next.MzA == 3) {
                    z = true;
                    z2 = z;
                }
            }
            z = z2;
            z2 = z;
        }
        this.JeQ = new a(this, linkedList);
        listView.setAdapter((ListAdapter) this.JeQ);
        final int intExtra = intent.getIntExtra("5", -2);
        final int intExtra2 = intent.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        ((Button) findViewById(R.id.ers)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(79712);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 1, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, intExtra, intExtra2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79712);
            }
        });
        ((Button) findViewById(R.id.erv)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(79713);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthOtherUI.this.appId, SDKOAuthOtherUI.this.startTime, 0, SDKOAuthOtherUI.this.accountType, 4, 1, 0);
                SDKOAuthOtherUI.a(SDKOAuthOtherUI.this, z2, intExtra, intExtra2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79713);
            }
        });
        AppMethodBeat.o(79721);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(79722);
        super.onResume();
        AppMethodBeat.o(79722);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(79723);
        super.onPause();
        AppMethodBeat.o(79723);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79724);
        super.onDestroy();
        gep();
        g.azz().b(1346, this);
        g.azz().b(1137, this);
        AppMethodBeat.o(79724);
    }

    private void gep() {
        AppMethodBeat.i(79725);
        if (this.gxX == null) {
            AppMethodBeat.o(79725);
            return;
        }
        this.gxX.dismiss();
        AppMethodBeat.o(79725);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(79726);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
            this.JeI.agb(-2);
            finish();
            AppMethodBeat.o(79726);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(79726);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bos;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(79727);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.appId, this.startTime, 2, this.accountType, 4, 1, i3);
        }
        gep();
        if (qVar instanceof ac) {
            this.JeI.i(i2, i3, str, qVar);
            AppMethodBeat.o(79727);
            return;
        }
        if (qVar instanceof aa) {
            this.JeI.Q(i2, i3, str);
        }
        AppMethodBeat.o(79727);
    }

    private void aM(final int i2, final int i3, final int i4) {
        AppMethodBeat.i(79728);
        Log.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.appId, new com.tencent.mm.model.gdpr.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.AnonymousClass5 */

            @Override // com.tencent.mm.model.gdpr.b
            public final void sx(int i2) {
                LinkedList<String> linkedList;
                AppMethodBeat.i(79714);
                Log.i("MicroMsg.SDKOAuthOtherUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                if (i2 == 1) {
                    SDKOAuthOtherUI.this.JeI.agb(-4);
                    AppMethodBeat.o(79714);
                    return;
                }
                if (i4 == 7) {
                    a aVar = SDKOAuthOtherUI.this.JeQ;
                    LinkedList<String> linkedList2 = new LinkedList<>();
                    for (int i3 = 0; i3 < aVar.JeV.size(); i3++) {
                        cuh cuh = aVar.JeV.get(i3);
                        if (cuh.MzA == 2 || cuh.MzA == 3) {
                            linkedList2.add(cuh.scope);
                        }
                    }
                    linkedList = linkedList2;
                } else {
                    linkedList = new LinkedList<>();
                }
                if (i2 == -2 || i3 == -2) {
                    if (i2 != -2) {
                        if (i2 == 8 && i4 == 8) {
                            SDKOAuthOtherUI.this.JeI.agb(-4);
                            AppMethodBeat.o(79714);
                            return;
                        }
                        SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
                        if (i2 == 7) {
                            aj unused = SDKOAuthOtherUI.this.JeI;
                            aj.a(SDKOAuthOtherUI.this.JeJ, linkedList);
                            if (SDKOAuthOtherUI.this.lGW == -1) {
                                Log.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
                            }
                            if (SDKOAuthOtherUI.this.JeK) {
                                aj unused2 = SDKOAuthOtherUI.this.JeI;
                                aj.a(linkedList, SDKOAuthOtherUI.this.lGW, SDKOAuthOtherUI.this.edo);
                                AppMethodBeat.o(79714);
                                return;
                            }
                            SDKOAuthOtherUI.this.JeI.k(linkedList, SDKOAuthOtherUI.this.lGW);
                            AppMethodBeat.o(79714);
                        } else if (SDKOAuthOtherUI.this.JeK) {
                            aj unused3 = SDKOAuthOtherUI.this.JeI;
                            aj.a(linkedList, SDKOAuthOtherUI.this.lGW, SDKOAuthOtherUI.this.edo);
                            AppMethodBeat.o(79714);
                        } else {
                            SDKOAuthOtherUI.this.JeI.bE(linkedList);
                            AppMethodBeat.o(79714);
                        }
                    } else if (i3 != -2) {
                        if (i3 == 8 && i4 == 8) {
                            SDKOAuthOtherUI.this.JeI.agb(-4);
                            AppMethodBeat.o(79714);
                            return;
                        }
                        SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
                        if (i3 == 7) {
                            linkedList.add("snsapi_friend");
                        }
                        if (SDKOAuthOtherUI.this.JeK) {
                            aj unused4 = SDKOAuthOtherUI.this.JeI;
                            aj.a(linkedList, SDKOAuthOtherUI.this.lGW, SDKOAuthOtherUI.this.edo);
                            AppMethodBeat.o(79714);
                            return;
                        }
                        SDKOAuthOtherUI.this.JeI.bE(linkedList);
                        AppMethodBeat.o(79714);
                    } else if (i4 == 8) {
                        SDKOAuthOtherUI.this.JeI.agb(-4);
                        AppMethodBeat.o(79714);
                    } else {
                        SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
                        if (SDKOAuthOtherUI.this.JeK) {
                            aj unused5 = SDKOAuthOtherUI.this.JeI;
                            aj.a(linkedList, SDKOAuthOtherUI.this.lGW, SDKOAuthOtherUI.this.edo);
                            AppMethodBeat.o(79714);
                            return;
                        }
                        SDKOAuthOtherUI.this.JeI.bE(linkedList);
                        AppMethodBeat.o(79714);
                    }
                } else if (i2 == 8 && i3 == 8 && i4 == 8) {
                    SDKOAuthOtherUI.this.JeI.agb(-4);
                    AppMethodBeat.o(79714);
                } else {
                    if (i3 == 7) {
                        linkedList.add("snsapi_friend");
                    }
                    SDKOAuthOtherUI.f(SDKOAuthOtherUI.this);
                    if (i2 == 7) {
                        aj unused6 = SDKOAuthOtherUI.this.JeI;
                        aj.a(SDKOAuthOtherUI.this.JeJ, linkedList);
                        if (SDKOAuthOtherUI.this.lGW == -1) {
                            Log.e("MicroMsg.SDKOAuthOtherUI", "btnCallback: do not get avatarId from pageone");
                        }
                        if (SDKOAuthOtherUI.this.JeK) {
                            aj unused7 = SDKOAuthOtherUI.this.JeI;
                            aj.a(linkedList, SDKOAuthOtherUI.this.lGW, SDKOAuthOtherUI.this.edo);
                            AppMethodBeat.o(79714);
                            return;
                        }
                        SDKOAuthOtherUI.this.JeI.k(linkedList, SDKOAuthOtherUI.this.lGW);
                        AppMethodBeat.o(79714);
                    } else if (SDKOAuthOtherUI.this.JeK) {
                        aj unused8 = SDKOAuthOtherUI.this.JeI;
                        aj.a(linkedList, 0, SDKOAuthOtherUI.this.edo);
                        AppMethodBeat.o(79714);
                    } else {
                        SDKOAuthOtherUI.this.JeI.bE(linkedList);
                        AppMethodBeat.o(79714);
                    }
                }
            }
        });
        AppMethodBeat.o(79728);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends BaseAdapter {
        LinkedList<cuh> JeV;
        private Context mContext;
        private LayoutInflater mInflater;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(79720);
            cuh agE = agE(i2);
            AppMethodBeat.o(79720);
            return agE;
        }

        public a(Context context, LinkedList<cuh> linkedList) {
            AppMethodBeat.i(79716);
            this.mInflater = LayoutInflater.from(context);
            this.JeV = linkedList;
            this.mContext = context;
            AppMethodBeat.o(79716);
        }

        public final int getCount() {
            AppMethodBeat.i(79717);
            if (this.JeV == null) {
                AppMethodBeat.o(79717);
                return 0;
            }
            int size = this.JeV.size();
            AppMethodBeat.o(79717);
            return size;
        }

        private cuh agE(int i2) {
            AppMethodBeat.i(79718);
            if (i2 < 0 || i2 >= this.JeV.size()) {
                AppMethodBeat.o(79718);
                return null;
            }
            cuh cuh = this.JeV.get(i2);
            AppMethodBeat.o(79718);
            return cuh;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1974a aVar;
            AppMethodBeat.i(79719);
            if (this.JeV == null || this.JeV.size() <= 0) {
                AppMethodBeat.o(79719);
                return null;
            }
            final cuh agE = agE(i2);
            if (agE == null) {
                AppMethodBeat.o(79719);
                return view;
            }
            if (view == null) {
                C1974a aVar2 = new C1974a((byte) 0);
                view = this.mInflater.inflate(R.layout.boo, (ViewGroup) null, false);
                aVar2.JeY = (ImageView) view.findViewById(R.id.n8);
                aVar2.oqe = (TextView) view.findViewById(R.id.n7);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1974a) view.getTag();
            }
            if (agE.MzA == 1) {
                aVar.JeY.setImageResource(R.drawable.p6);
            } else if (agE.MzA == 3) {
                aVar.JeY.setImageResource(ao.isDarkMode() ? R.raw.checkbox_selected_grey_dark_small : R.raw.checkbox_selected_grey_small);
            } else {
                aVar.JeY.setImageResource(R.raw.checkbox_selected_small);
            }
            aVar.oqe.setText(agE.desc);
            final ImageView imageView = aVar.JeY;
            aVar.JeY.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(79715);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (agE.MzA == 2) {
                        imageView.setImageResource(R.drawable.p6);
                        agE.MzA = 1;
                    } else if (agE.MzA == 1) {
                        imageView.setImageResource(R.raw.checkbox_selected_small);
                        agE.MzA = 2;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79715);
                }
            });
            AppMethodBeat.o(79719);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI$a$a  reason: collision with other inner class name */
        static final class C1974a {
            ImageView JeY;
            TextView oqe;

            private C1974a() {
            }

            /* synthetic */ C1974a(byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ void a(SDKOAuthOtherUI sDKOAuthOtherUI, int i2, int i3) {
        AppMethodBeat.i(79729);
        sDKOAuthOtherUI.aM(i2, i3, 7);
        AppMethodBeat.o(79729);
    }

    static /* synthetic */ void a(SDKOAuthOtherUI sDKOAuthOtherUI, boolean z, int i2, int i3) {
        AppMethodBeat.i(79730);
        if (z) {
            sDKOAuthOtherUI.JeI.agb(-4);
        }
        sDKOAuthOtherUI.aM(i2, i3, 8);
        AppMethodBeat.o(79730);
    }

    static /* synthetic */ void f(SDKOAuthOtherUI sDKOAuthOtherUI) {
        AppMethodBeat.i(79731);
        sDKOAuthOtherUI.gep();
        sDKOAuthOtherUI.gxX = h.a((Context) sDKOAuthOtherUI, sDKOAuthOtherUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(79710);
                try {
                    dialogInterface.dismiss();
                    AppMethodBeat.o(79710);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDKOAuthOtherUI", "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                    AppMethodBeat.o(79710);
                }
            }
        });
        AppMethodBeat.o(79731);
    }
}
