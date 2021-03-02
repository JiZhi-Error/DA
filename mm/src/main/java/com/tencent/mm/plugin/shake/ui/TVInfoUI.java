package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.je;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TVInfoUI extends MMPreference implements i, u.a {
    private boolean CLo = false;
    private String DlB = "";
    private TextView DlC;
    private c.a DlD;
    private boolean DlE = false;
    private b DlF;
    protected ProgressDialog gtM = null;
    private long msgId;
    private ImageView qbE;
    protected f screen;
    private TextView titleTv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void g(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(28604);
        tVInfoUI.eQK();
        AppMethodBeat.o(28604);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.c4p;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d8;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getHeaderResourceId() {
        return R.layout.c4q;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28587);
        super.onCreate(bundle);
        u.b(this);
        initView();
        AppMethodBeat.o(28587);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(28588);
        super.onResume();
        bg.azz().a(g.CTRL_INDEX, this);
        AppMethodBeat.o(28588);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(28589);
        bg.azz().b(g.CTRL_INDEX, this);
        super.onPause();
        AppMethodBeat.o(28589);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(28590);
        u.c(this);
        super.onDestroy();
        AppMethodBeat.o(28590);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        byte[] byteArrayExtra;
        AppMethodBeat.i(28591);
        setMMTitle(R.string.ge8);
        this.screen = getPreferenceScreen();
        this.titleTv = (TextView) findViewById(R.id.iz7);
        this.DlC = (TextView) findViewById(R.id.iz8);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (Util.isNullOrNil(stringExtra) && (byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes")) != null) {
            stringExtra = new String(byteArrayExtra);
        }
        Log.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", stringExtra);
        this.DlD = c.aNu(stringExtra);
        if (this.DlD == null) {
            Log.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            AppMethodBeat.o(28591);
            return;
        }
        a(this.DlD);
        AppMethodBeat.o(28591);
    }

    private void a(final c.a aVar) {
        AppMethodBeat.i(28592);
        if (aVar == null) {
            Log.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            AppMethodBeat.o(28592);
            return;
        }
        this.titleTv.setText(aVar.field_title);
        if (Util.isNullOrNil(aVar.field_topic)) {
            this.DlC.setVisibility(8);
        } else {
            this.DlC.setText(aVar.field_topic);
        }
        this.qbE = (ImageView) findViewById(R.id.iz6);
        if (!Util.isNullOrNil(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(R.id.iz5);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(28579);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    h.INSTANCE.a(10987, 2, aVar.field_playstatid, "", "");
                    TVInfoUI.a(TVInfoUI.this, aVar.field_playurl);
                    a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(28579);
                }
            });
            this.qbE.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(28580);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    h.INSTANCE.a(10987, 2, aVar.field_playstatid, "", "");
                    TVInfoUI.a(TVInfoUI.this, aVar.field_playurl);
                    a.a(this, "com/tencent/mm/plugin/shake/ui/TVInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(28580);
                }
            });
        }
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28581);
                TVInfoUI.a(TVInfoUI.this);
                AppMethodBeat.o(28581);
                return true;
            }
        });
        if (!Util.isNullOrNil(aVar.field_id) && !this.DlE && !getIntent().getBooleanExtra("key_TV_come_from_shake", false)) {
            int intExtra = getIntent().getIntExtra("key_TV_getProductInfoScene", 0);
            Log.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", aVar.field_id, Integer.valueOf(intExtra));
            bg.azz().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, intExtra), 0);
            this.DlE = true;
        }
        this.qbE.setVisibility(0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28582);
                TVInfoUI.this.finish();
                AppMethodBeat.o(28582);
                return true;
            }
        });
        Log.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(28583);
                TVInfoUI.a(TVInfoUI.this, aVar);
                TVInfoUI.b(TVInfoUI.this, aVar);
                AppMethodBeat.o(28583);
            }
        });
        AppMethodBeat.o(28592);
    }

    private void eQK() {
        AppMethodBeat.i(28593);
        this.msgId = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.msgId > 0 && bg.aAc()) {
            bg.aVF();
            ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
            if (Hb.field_msgId > 0) {
                Hb.Cz(this.DlF.blA());
                bg.aVF();
                com.tencent.mm.model.c.aSQ().a(this.msgId, Hb);
            }
        }
        AppMethodBeat.o(28593);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(28594);
        Log.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", preference.mKey);
        if (this.DlD == null || this.DlD.CUx == null) {
            Log.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            AppMethodBeat.o(28594);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i2 = intValue / 100;
            int i3 = intValue % 100;
            Log.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 < 0 || i2 >= this.DlD.CUx.size()) {
                Log.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i2), Integer.valueOf(this.DlD.CUx.size()));
                AppMethodBeat.o(28594);
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = this.DlD.CUx.get(i2);
            if (aVar == null) {
                Log.w("MicroMsg.TVInfoUI", "actionList == null");
                AppMethodBeat.o(28594);
                return false;
            } else if (i3 < 0 || i3 >= aVar.mRG.size()) {
                Log.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i3), Integer.valueOf(aVar.mRG.size()));
                AppMethodBeat.o(28594);
                return false;
            } else {
                a.C1693a aVar2 = aVar.mRG.get(i3);
                if (aVar2 == null) {
                    Log.w("MicroMsg.TVInfoUI", "action == null");
                    AppMethodBeat.o(28594);
                    return false;
                }
                Log.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.daA + ", targetDesc:" + aVar2.DlP + ", targetDesc2:" + aVar2.DlQ);
                if (aVar2.type == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar2.daA);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("geta8key_scene", 10);
                    intent.putExtra("srcUsername", aVar2.DlQ);
                    com.tencent.mm.plugin.shake.a.jRt.i(intent, this);
                } else if (aVar2.type == 4) {
                    bg.aVF();
                    as Kn = com.tencent.mm.model.c.aSN().Kn(aVar2.daA);
                    if (Kn != null) {
                        Intent intent2 = new Intent();
                        if (com.tencent.mm.contact.c.oR(Kn.field_type) && Kn.gBM()) {
                            ag.bah().MT(aVar2.daA);
                            if (aVar2.DlP.equals("1")) {
                                intent2.putExtra("Chat_User", aVar2.daA);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.jRt.d(intent2, this);
                            }
                        }
                        intent2.putExtra("Contact_User", aVar2.daA);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.br.c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    }
                } else if (aVar2.type == 5) {
                    je jeVar = new je();
                    jeVar.dNT.actionCode = 11;
                    jeVar.dNT.result = aVar2.daA;
                    jeVar.dNT.context = this;
                    jeVar.callback = null;
                    EventCenter.instance.asyncPublish(jeVar, Looper.myLooper());
                } else if (aVar2.type == 6) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_product_id", aVar2.daA);
                    intent3.putExtra("key_product_scene", 9);
                    com.tencent.mm.br.c.b(this, "product", ".ui.MallProductUI", intent3);
                }
                AppMethodBeat.o(28594);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.TVInfoUI", e2, "", new Object[0]);
            AppMethodBeat.o(28594);
            return false;
        }
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(final String str, final Bitmap bitmap) {
        AppMethodBeat.i(28595);
        if (str != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            Log.d("MicroMsg.TVInfoUI", "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]", objArr);
            try {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(28586);
                        if (TVInfoUI.this.DlB != null && TVInfoUI.this.DlB.equals(str)) {
                            if (!(TVInfoUI.this.qbE == null || bitmap == null)) {
                                TVInfoUI.this.qbE.setImageBitmap(bitmap);
                                TVInfoUI.g(TVInfoUI.this);
                            }
                            TVInfoUI.this.CLo = true;
                        }
                        AppMethodBeat.o(28586);
                    }
                });
                AppMethodBeat.o(28595);
            } catch (Exception e2) {
                Log.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", e2.getLocalizedMessage());
                Log.printErrStackTrace("MicroMsg.TVInfoUI", e2, "", new Object[0]);
                AppMethodBeat.o(28595);
            }
        } else {
            Log.e("MicroMsg.TVInfoUI", "onUpdateEnable pic, url  is null ");
            AppMethodBeat.o(28595);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        bvy bvy;
        AppMethodBeat.i(28596);
        if (qVar == null) {
            Log.w("MicroMsg.TVInfoUI", "scene == null");
            AppMethodBeat.o(28596);
            return;
        }
        if (qVar.getType() == 552) {
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i2), Integer.valueOf(i3));
                Toast.makeText(this, (int) R.string.ge9, 0).show();
                AppMethodBeat.o(28596);
                return;
            } else if (this.DlD == null) {
                Log.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
                AppMethodBeat.o(28596);
                return;
            } else {
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) qVar;
                if (bVar.rr == null || bVar.rr.iLL.iLR == null) {
                    bvy = null;
                } else {
                    bvy = (bvy) bVar.rr.iLL.iLR;
                }
                if (bvy == null) {
                    Log.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                    AppMethodBeat.o(28596);
                    return;
                } else if (bvy.MbV != null) {
                    Log.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + bvy.MbV);
                    c.a aNu = c.aNu(bvy.MbV);
                    if (!(this.DlD == null || this.DlD.field_xml == null || aNu == null || aNu.field_xml == null || this.DlD.field_xml.equals(aNu.field_xml))) {
                        this.DlD = aNu;
                        a(this.DlD);
                    }
                }
            }
        }
        AppMethodBeat.o(28596);
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, String str) {
        AppMethodBeat.i(28597);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 10);
        com.tencent.mm.plugin.shake.a.jRt.i(intent, tVInfoUI);
        AppMethodBeat.o(28597);
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(28598);
        String str = "";
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList.add(tVInfoUI.getString(R.string.j4c));
        linkedList2.add(0);
        linkedList.add(tVInfoUI.getString(R.string.j4d));
        linkedList2.add(1);
        if (!tVInfoUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(tVInfoUI.getString(R.string.fn9));
            linkedList2.add(2);
        } else if (tVInfoUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = tVInfoUI.getString(R.string.tf);
        } else {
            str = "";
        }
        com.tencent.mm.ui.base.h.b(tVInfoUI, "", linkedList, linkedList2, str, new h.e() {
            /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass6 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(28585);
                switch (i3) {
                    case -1:
                        com.tencent.mm.ui.base.h.a(TVInfoUI.this.getContext(), TVInfoUI.this.getContext().getString(R.string.th), (List<String>) null, (List<Integer>) null, TVInfoUI.this.getContext().getString(R.string.tf), new h.e() {
                            /* class com.tencent.mm.plugin.shake.ui.TVInfoUI.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.h.e
                            public final void cy(int i2, int i3) {
                                AppMethodBeat.i(28584);
                                switch (i3) {
                                    case -1:
                                        cu cuVar = new cu();
                                        cuVar.dFU.dFW = TVInfoUI.this.getIntent().getLongExtra("key_favorite_local_id", -1);
                                        EventCenter.instance.publish(cuVar);
                                        Log.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", Long.valueOf(cuVar.dFU.dFW), Boolean.valueOf(cuVar.dFV.dFE));
                                        if (cuVar.dFV.dFE) {
                                            TVInfoUI.this.finish();
                                            AppMethodBeat.o(28584);
                                            return;
                                        }
                                        break;
                                    default:
                                        Log.d("MicroMsg.TVInfoUI", "do del cancel");
                                        break;
                                }
                                AppMethodBeat.o(28584);
                            }
                        });
                        AppMethodBeat.o(28585);
                        return;
                    case 0:
                        TVInfoUI.b(TVInfoUI.this);
                        AppMethodBeat.o(28585);
                        return;
                    case 1:
                        TVInfoUI.c(TVInfoUI.this);
                        AppMethodBeat.o(28585);
                        return;
                    case 2:
                        TVInfoUI.d(TVInfoUI.this);
                        break;
                }
                AppMethodBeat.o(28585);
            }
        });
        AppMethodBeat.o(28598);
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, c.a aVar) {
        AppMethodBeat.i(28599);
        if (aVar == null || aVar.CUx == null || aVar.CUx.size() == 0 || tVInfoUI.screen == null) {
            AppMethodBeat.o(28599);
            return;
        }
        tVInfoUI.screen.removeAll();
        for (int i2 = 0; i2 < aVar.CUx.size(); i2++) {
            com.tencent.mm.plugin.shake.e.a aVar2 = aVar.CUx.get(i2);
            if (!(aVar2 == null || aVar2.mRG == null || aVar2.mRG.size() == 0)) {
                for (int i3 = 0; i3 < aVar2.mRG.size(); i3++) {
                    String sb = new StringBuilder().append((i2 * 100) + i3).toString();
                    a.C1693a aVar3 = aVar2.mRG.get(i3);
                    if (aVar3.type == 2) {
                        Preference preference = new Preference(tVInfoUI);
                        preference.setKey(sb);
                        preference.setLayoutResource(R.layout.c4r);
                        preference.setTitle(Util.isNullOrNil(aVar3.title) ? tVInfoUI.getResources().getString(R.string.h0e) : aVar3.title);
                        preference.setSummary(String.format(tVInfoUI.getResources().getString(R.string.h0d), 108));
                    } else if (aVar3.DlO == null || aVar3.DlO.size() <= 0) {
                        Preference preference2 = new Preference(tVInfoUI);
                        preference2.setKey(sb);
                        preference2.setLayoutResource(R.layout.c4r);
                        preference2.setTitle(aVar3.title);
                        preference2.setSummary(aVar3.summary);
                        tVInfoUI.screen.c(preference2);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int i4 = 0;
                        while (i4 < aVar3.DlO.size() && i4 < 3 && (i4 != 2 || aVar3.title.length() <= 4)) {
                            arrayList.add(aVar3.DlO.get(i4));
                            i4++;
                        }
                        TVThumbPreference tVThumbPreference = new TVThumbPreference(tVInfoUI);
                        tVThumbPreference.setKey(sb);
                        tVThumbPreference.DlM = arrayList;
                        tVThumbPreference.setTitle(aVar3.title);
                        tVThumbPreference.nRm = tVInfoUI.screen;
                        tVInfoUI.screen.c(tVThumbPreference);
                    }
                }
            }
        }
        tVInfoUI.screen.notifyDataSetChanged();
        AppMethodBeat.o(28599);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        AppMethodBeat.i(28600);
        if (aVar == null || Util.isNullOrNil(aVar.field_thumburl)) {
            AppMethodBeat.o(28600);
            return;
        }
        tVInfoUI.DlF = new b(aVar);
        tVInfoUI.DlB = tVInfoUI.DlF.blC();
        Bitmap a2 = u.a(tVInfoUI.DlF);
        Log.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", a2);
        if (a2 != null) {
            tVInfoUI.qbE.setImageBitmap(a2);
            tVInfoUI.CLo = true;
            tVInfoUI.eQK();
            AppMethodBeat.o(28600);
            return;
        }
        tVInfoUI.qbE.setImageDrawable(tVInfoUI.getResources().getDrawable(R.raw.tv_info_thumb_default));
        AppMethodBeat.o(28600);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(28601);
        if (tVInfoUI.DlD == null) {
            Log.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            AppMethodBeat.o(28601);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10987, 4, "", "", "");
        String a2 = c.a(tVInfoUI.getContext(), tVInfoUI.DlD);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a2);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.DlF != null && tVInfoUI.CLo) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.DlF.blA());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.jRt.k(intent, tVInfoUI);
        AppMethodBeat.o(28601);
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(28602);
        if (tVInfoUI.DlD == null) {
            Log.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            AppMethodBeat.o(28602);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10987, 3, "", "", "");
        Intent intent = new Intent();
        if (!Util.isNullOrNil(tVInfoUI.DlD.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.DlD.field_topic);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.DlD.field_subtitle);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.DlD.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.DlD.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(R.string.gea));
        if (k.eUk()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.DlD.field_thumburl);
        if (tVInfoUI.DlF != null && tVInfoUI.CLo) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.DlF.blA());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.DlD));
        String JX = ad.JX("shake_tv");
        ad.aVe().G(JX, true).l("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", JX);
        com.tencent.mm.br.c.b(tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(28602);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(28603);
        if (tVInfoUI.DlD == null) {
            Log.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            AppMethodBeat.o(28603);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10987, 5, "", "", "");
        cz czVar = new cz();
        anb anb = new anb();
        anh anh = new anh();
        ank ank = new ank();
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(8);
        anh.MA(Util.nowMilliSecond());
        if (k.eUk()) {
            anh.bhl("wxaf060266bfa9a35c");
        }
        ank.bho(tVInfoUI.DlD.field_title);
        if (!Util.isNullOrNil(tVInfoUI.DlD.field_topic)) {
            ank.bhp(tVInfoUI.DlD.field_topic);
        } else {
            ank.bhp(tVInfoUI.DlD.field_subtitle);
        }
        ank.bhr(c.b(tVInfoUI.DlD));
        ank.bhq(tVInfoUI.DlD.field_thumburl);
        czVar.dFZ.title = tVInfoUI.DlD.field_title;
        czVar.dFZ.desc = tVInfoUI.DlD.field_topic;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 15;
        anb.a(anh);
        anb.b(ank);
        czVar.dFZ.dGf = 12;
        czVar.dFZ.activity = tVInfoUI;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(28603);
    }
}
