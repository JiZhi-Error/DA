package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

@i
public class SnsGalleryUI extends SnsBaseGalleryUI implements w.a {
    private String DUW = "";
    private int EAu = 0;
    private boolean dJM = false;
    private int scene = 0;
    private String userName = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int a(SnsGalleryUI snsGalleryUI, SnsInfo snsInfo) {
        AppMethodBeat.i(203577);
        int W = snsGalleryUI.W(snsInfo);
        AppMethodBeat.o(203577);
        return W;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98700);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setActionbarColor(getContext().getResources().getColor(R.color.ko));
        setNavigationbarColor(getContext().getResources().getColor(R.color.ko));
        initView();
        e.DUQ.DVn = System.currentTimeMillis();
        AppMethodBeat.o(98700);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int i2;
        AppMethodBeat.i(98701);
        getWindow().clearFlags(128);
        aq.a faE = aj.faE();
        String str = this.userName;
        if (faE.DMA.containsKey(str)) {
            i2 = Math.max(faE.DMA.get(str).intValue() - 1, 0);
            faE.DMA.put(str, Integer.valueOf(i2));
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            faE.DMz.remove(str);
        }
        aj.faL().aI(this);
        super.onDestroy();
        e eVar = e.DUQ;
        if (eVar.DVn != 0) {
            eVar.DVo += System.currentTimeMillis() - eVar.DVn;
            eVar.DVn = 0;
        }
        e.DUQ.fcB();
        e.DUQ.fcD();
        AppMethodBeat.o(98701);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(98702);
        super.onStart();
        e.DUQ.DVu = System.currentTimeMillis();
        AppMethodBeat.o(98702);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(98703);
        super.onStop();
        e.DUQ.fcB();
        AppMethodBeat.o(98703);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(98704);
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(98704);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        boolean z;
        AppMethodBeat.i(98705);
        super.onResume();
        if (this.EAi != null) {
            cnb cntMedia = this.EAi.getCntMedia();
            SnsInfoFlip snsInfoFlip = this.EAi;
            if (cntMedia == null || cntMedia.oUv != 6) {
                z = false;
            } else {
                z = true;
            }
            snsInfoFlip.vu(z);
        }
        f.e(true, true, true);
        AppMethodBeat.o(98705);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public int getLayoutId() {
        return R.layout.bvx;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(98706);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.EAf.EqW);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(98706);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(98706);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        ArrayList<b> arrayList;
        bp gCX;
        AppMethodBeat.i(98707);
        this.scene = getIntent().getIntExtra("sns_video_scene", 0);
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        this.dJM = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.EAu = getIntent().getIntExtra("sns_gallery_position", 0);
        String bq = y.bq("sns_table_", (long) intExtra);
        Log.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", bq, Integer.valueOf(this.EAu));
        fI(bq, this.EAu);
        X(this.dJM, 1);
        this.EAi = new SnsInfoFlip(this);
        this.EAi.setVideoScene(this.scene);
        this.EAi.setNeedScanImage(true);
        aq.a faE = aj.faE();
        String str = this.userName;
        if (faE.DMA.containsKey(str)) {
            faE.DMA.put(str, Integer.valueOf(faE.DMA.get(str).intValue() + 1));
        } else {
            faE.DMA.put(str, 0);
        }
        ArrayList<b> arrayList2 = faE.DMz.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = arrayList2;
        }
        this.EAi.setShowTitle(true);
        this.EAi.setEnableHorLongBmpMode(false);
        this.EAi.a(arrayList, this.userName, this.EAu, this.EAd, this);
        this.EAi.setOnDeleteAllAction(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsGalleryUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(98697);
                SnsGalleryUI.this.EAf.ffJ();
                AppMethodBeat.o(98697);
            }
        });
        this.EAi.setOnPageSelectListener(this);
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.userName);
        if (Kn == null || ((int) Kn.gMZ) <= 0 || !c.oR(Kn.field_type)) {
            if (this.userName.equals(z.aTY())) {
                gCX = bp.gCW();
            } else {
                gCX = bp.gCX();
            }
        } else {
            gCX = bp.gCV();
        }
        this.EAi.setFromScene(gCX);
        this.EAi.setUIFromScene(getFromScene());
        this.EAi.username = this.userName;
        addView(this.EAi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsGalleryUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98698);
                SnsGalleryUI.this.EAf.ffJ();
                AppMethodBeat.o(98698);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsGalleryUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98699);
                String selectId = SnsGalleryUI.this.EAi.getSelectId();
                String selectedMediaId = SnsGalleryUI.this.EAi.getSelectedMediaId();
                b selectItem = SnsGalleryUI.this.EAi.getSelectItem();
                Log.d("MicroMsg.SnsGalleryUI", "click selectLocalId: %s, mediaId: %s, showTranslate: %s, showOcr: %s", selectId, selectedMediaId, Boolean.valueOf(SnsGalleryUI.this.EAi.Eqi), Boolean.valueOf(SnsGalleryUI.this.EAi.Eqj));
                SnsInfo aQm = aj.faO().aQm(selectId);
                try {
                    SnsGalleryUI.this.EAf.a(SnsGalleryUI.this.dJM, aQm, selectItem.ebR, SnsGalleryUI.this.EAi.Eqi, SnsGalleryUI.this.EAi.Eqj, true, SnsGalleryUI.a(SnsGalleryUI.this, aQm));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsGalleryUI", e2, "", new Object[0]);
                }
                AppMethodBeat.o(98699);
                return true;
            }
        });
        AppMethodBeat.o(98707);
    }

    private int W(SnsInfo snsInfo) {
        int i2;
        AppMethodBeat.i(203575);
        int position = this.EAi.getPosition();
        int size = snsInfo.getTimeLine().ContentObj.LoV.size();
        if (size <= 1 || position <= 1 || position > size) {
            i2 = 0;
        } else {
            i2 = position - 1;
        }
        AppMethodBeat.o(203575);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void ap(boolean z, boolean z2) {
        boolean z3;
        AppMethodBeat.i(203576);
        if ((z || z2) && this.EAf != null) {
            w wVar = this.EAf;
            if (wVar.Epy == null || !wVar.Epy.isShowing()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                String selectId = this.EAi.getSelectId();
                String selectedMediaId = this.EAi.getSelectedMediaId();
                b selectItem = this.EAi.getSelectItem();
                Log.i("MicroMsg.SnsGalleryUI", "onTranslateEnd showTranslateMenu: %s, showOcrMenu: %s, selectLocalId: %s, mediaId: %s", Boolean.valueOf(z), Boolean.valueOf(z2), selectId, selectedMediaId);
                SnsInfo aQm = aj.faO().aQm(selectId);
                this.EAf.a(this.dJM, aQm, selectItem.ebR, z, z2, true, W(aQm));
            }
        }
        AppMethodBeat.o(203576);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fH(String str, int i2) {
        AppMethodBeat.i(98708);
        if (this.EAi != null) {
            if (!Util.isNullOrNil(str) && i2 != 3) {
                SnsInfoFlip snsInfoFlip = this.EAi;
                if (!(snsInfoFlip.EDX == null || snsInfoFlip.iHf == null)) {
                    int i3 = 0;
                    while (i3 >= 0) {
                        if (snsInfoFlip.EDX != null) {
                            while (true) {
                                if (i3 >= snsInfoFlip.iHf.size()) {
                                    break;
                                }
                                b ZN = snsInfoFlip.EDX.ZN(i3);
                                if (!Util.isNullOrNil(ZN.parentId) && ZN.parentId.equals(str)) {
                                    snsInfoFlip.iHf.remove(i3);
                                    break;
                                }
                                i3++;
                            }
                        }
                        i3 = -1;
                    }
                    snsInfoFlip.EDX.notifyDataSetChanged();
                }
            }
            this.EAi.vu(true);
        }
        AppMethodBeat.o(98708);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final boolean fhC() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final int fhD() {
        return 4;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final int fhE() {
        return 4;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        cnb cnb;
        String str;
        String str2;
        AppMethodBeat.i(98709);
        Log.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(98709);
            return;
        }
        if (2 == i2) {
            if (-1 == i3) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                if (this.EAi != null) {
                    b selectItem = this.EAi.getSelectItem();
                    if (selectItem.ebR.oUv != 6) {
                        AppMethodBeat.o(98709);
                        return;
                    }
                    cnb = selectItem.ebR;
                } else {
                    cnb = null;
                }
                if (cnb == null) {
                    AppMethodBeat.o(98709);
                    return;
                }
                String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
                String str3 = "";
                String str4 = "";
                String j2 = r.j(cnb);
                if (s.YS(ki + j2)) {
                    str4 = ki + j2;
                    str3 = ki + r.e(cnb);
                }
                if (s.YS(ki + r.p(cnb))) {
                    str = ki + r.p(cnb);
                    str2 = ki + r.n(cnb);
                } else {
                    str = str4;
                    str2 = str3;
                }
                ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
                int aOx = r.aOx(str);
                for (String str5 : stringsToList) {
                    Log.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", str5, str, str2, Integer.valueOf(aOx));
                    com.tencent.mm.plugin.messenger.a.g.eir().a(this, str5, str, str2, 62, aOx, "", (String) null);
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str5);
                }
                com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
                AppMethodBeat.o(98709);
                return;
            }
        } else if (1 == i2) {
            int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
            String bq = y.bq("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
            this.EAf.Zu(intExtra);
            fH(bq, 1);
            if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("sns_cmd_list", this.EAf.EqW);
                setResult(-1, intent2);
                finish();
            }
        }
        AppMethodBeat.o(98709);
    }

    @Override // com.tencent.mm.plugin.sns.ui.w.a, com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
    public final void fI(String str, int i2) {
        AppMethodBeat.i(98710);
        super.fI(str, i2);
        SnsInfo aQm = aj.faO().aQm(str);
        if (aQm != null) {
            e.DUQ.P(aQm);
            e.DUQ.c(aQm, i2);
            TimeLineObject timeLine = aQm.getTimeLine();
            if (!(timeLine == null || timeLine.ContentObj == null || Util.isNullOrNil(timeLine.ContentObj.LoV))) {
                ih fcz = e.DUQ.fcz();
                if (fcz == null) {
                    ih fcA = e.DUQ.fcA();
                    fcA.eOs = 1;
                    ih we = fcA.wf(r.Jc(aQm.field_snsId)).we(e.DUQ.DVe.ePK);
                    we.eDV = e.DUQ.DVe.eDV;
                    we.erx = (long) timeLine.ContentObj.LoU;
                    we.eOr = (long) timeLine.ContentObj.LoV.size();
                    e.DUQ.DVu = System.currentTimeMillis();
                } else if (!Util.isEqual(r.Jc(aQm.field_snsId), fcz.err)) {
                    e.DUQ.fcD();
                    ih fcA2 = e.DUQ.fcA();
                    fcA2.eOs = 0;
                    ih we2 = fcA2.wf(r.Jc(aQm.field_snsId)).we(e.DUQ.DVe.ePK);
                    we2.eDV = e.DUQ.DVe.eDV;
                    we2.erx = (long) timeLine.ContentObj.LoU;
                    we2.eOr = (long) timeLine.ContentObj.LoV.size();
                    e.DUQ.DVu = System.currentTimeMillis();
                }
                e.DUQ.f(aQm, i2);
            }
        }
        AppMethodBeat.o(98710);
    }
}
