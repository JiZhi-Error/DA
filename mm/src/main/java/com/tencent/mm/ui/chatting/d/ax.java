package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.k;
import com.tencent.mm.av.n;
import com.tencent.mm.av.q;
import com.tencent.mm.ba.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.s;

@a(gRF = an.class)
public class ax extends a implements k.a, an {
    private d zol;

    static /* synthetic */ void a(ax axVar, ca caVar) {
        AppMethodBeat.i(35580);
        axVar.cf(caVar);
        AppMethodBeat.o(35580);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.an
    public final boolean a(MenuItem menuItem, final ca caVar) {
        AppMethodBeat.i(35566);
        switch (menuItem.getItemId()) {
            case 110:
                final String N = br.N(caVar);
                if (Util.isNullOrNil(N) || caVar.field_isSend == 1) {
                    cf(caVar);
                } else {
                    h.INSTANCE.a(17509, 3, N);
                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.ax.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35559);
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", N);
                            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                            c.b(ax.this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            h.INSTANCE.a(17509, 1, N);
                            AppMethodBeat.o(35559);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.ax.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35560);
                            ax.a(ax.this, caVar);
                            h.INSTANCE.a(17509, 2, N);
                            AppMethodBeat.o(35560);
                        }
                    });
                }
                if (br.D(caVar)) {
                    jc jcVar = new jc();
                    jcVar.emN = caVar.field_msgSvrId;
                    jcVar.eLn = (long) caVar.getType();
                    jcVar.eQu = (long) br.C(caVar);
                    jcVar.ejA = 4;
                    jcVar.bfK();
                }
                AppMethodBeat.o(35566);
                return true;
            default:
                AppMethodBeat.o(35566);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x018c  */
    @Override // com.tencent.mm.ui.chatting.d.b.an
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(final int r12, int r13, android.content.Intent r14) {
        /*
        // Method dump skipped, instructions count: 618
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ax.i(int, int, android.content.Intent):boolean");
    }

    @Override // com.tencent.mm.ui.chatting.d.b.an
    public final void a(SightCaptureResult sightCaptureResult) {
        AppMethodBeat.i(35568);
        String str = sightCaptureResult.zsG;
        if (!Util.isNullOrNil(str)) {
            try {
                boolean z = sightCaptureResult.zsz;
                Log.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", str);
                o.e tc = o.a(o.d.jdL).tc(z ? 2 : 1);
                tc.dRL = z.aTY();
                tc.toUser = this.dom.getTalkerUserName();
                tc.iZt = str;
                tc.iXp = 1;
                tc.jdS = null;
                tc.dQd = 0;
                tc.iXy = "";
                tc.thumbPath = "";
                tc.jdV = true;
                tc.jdU = R.drawable.c3h;
                tc.jdR = 11;
                n nVar = (n) tc.bdQ().jdJ;
                if (((b) g.af(b.class)).a(b.a.clicfg_clear_c2c_tmp_file, true)) {
                    com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.jD(String.valueOf(nVar.bcD().field_msgId), str);
                }
                bg.azz().a(nVar, 0);
                AppMethodBeat.o(35568);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(35568);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.an
    public final void T(int i2, int i3, String str) {
        AppMethodBeat.i(35569);
        if (str == null || str.equals("") || !s.YS(str)) {
            Log.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
            AppMethodBeat.o(35569);
        } else if (l.at(this.dom.GUe)) {
            AppMethodBeat.o(35569);
        } else {
            o.e tc = o.a(o.d.jdL).tc(4);
            tc.dRL = this.dom.gRI();
            tc.toUser = this.dom.getTalkerUserName();
            tc.iZt = str;
            tc.iXp = i2;
            tc.jdS = null;
            tc.dQd = i3;
            tc.iXy = "";
            tc.thumbPath = "";
            tc.jdV = true;
            tc.jdU = R.drawable.c3h;
            tc.jdR = 11;
            tc.bdQ().execute();
            this.dom.BN(true);
            AppMethodBeat.o(35569);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.an
    public final boolean bU(ca caVar) {
        AppMethodBeat.i(35570);
        if (!caVar.gAz()) {
            AppMethodBeat.o(35570);
            return false;
        }
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
            AppMethodBeat.o(35570);
            return true;
        }
        if (!this.dom.getTalkerUserName().equals("medianote")) {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new f(caVar.field_talker, caVar.field_msgSvrId));
        }
        ak.bH(caVar);
        this.dom.BN(true);
        AppMethodBeat.o(35570);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.an
    public final void a(ContextMenu contextMenu, int i2, ca caVar) {
        AppMethodBeat.i(35571);
        contextMenu.add(i2, 100, 0, this.dom.Pwc.getMMResources().getString(R.string.b05));
        com.tencent.mm.av.g gVar = null;
        if (caVar.field_msgId > 0) {
            gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
        }
        if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
            gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        }
        if (caVar.field_isSend == 1 || (gVar != null && caVar.field_isSend == 0 && gVar.offset >= gVar.iKP && gVar.iKP != 0)) {
            contextMenu.add(i2, 110, 0, this.dom.Pwc.getMMResources().getString(R.string.g5c));
        }
        String o = gVar == null ? "" : q.bcR().o(gVar.iXm, "", "");
        if (gVar != null && s.YS(o)) {
            contextMenu.add(i2, 112, 0, this.dom.Pwc.getMMResources().getString(R.string.ay2));
        }
        AppMethodBeat.o(35571);
    }

    private void cf(ca caVar) {
        AppMethodBeat.i(35572);
        com.tencent.mm.ui.chatting.s.a(caVar, this.dom.Pwc.getContext(), this.dom);
        AppMethodBeat.o(35572);
    }

    @Override // com.tencent.mm.av.k.a
    public final void a(long j2, int i2, int i3) {
        AppMethodBeat.i(35573);
        ((com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).s(j2, i2, i3);
        AppMethodBeat.o(35573);
    }

    @Override // com.tencent.mm.av.k.a
    public final void j(long j2, boolean z) {
        AppMethodBeat.i(35574);
        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.aLD(String.valueOf(j2));
        ((com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).Q(j2, z);
        AppMethodBeat.o(35574);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.an
    public final void Q(String str, int i2, final String str2) {
        AppMethodBeat.i(35575);
        if ((this.zol == null || !this.zol.isShowing()) && !Util.isNullOrNil(str2) && ImgUtil.isImgFile(str2)) {
            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str2, 300, 300, false);
            if (extractThumbNail == null) {
                Log.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
                AppMethodBeat.o(35575);
                return;
            }
            final com.tencent.mm.ui.chatting.d.b.u uVar = (com.tencent.mm.ui.chatting.d.b.u) this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class);
            ImageView imageView = new ImageView(this.dom.Pwc.getContext());
            int dimensionPixelSize = this.dom.Pwc.getMMResources().getDimensionPixelSize(R.dimen.hs);
            imageView.setImageBitmap(extractThumbNail);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            final String string = Settings.Secure.getString(this.dom.Pwc.getContentResolver(), "default_input_method");
            final boolean z = ImgUtil.isGif(s.aW(str2, 0, -1)) && string != null && (string.contains("com.sohu.inputmethod.sogou") || string.contains("com.tencent.qqpinyin"));
            if (z) {
                if (string.contains("com.sohu.inputmethod.sogou")) {
                    h.INSTANCE.dN(1062, 1);
                } else if (string.contains("com.tencent.qqpinyin")) {
                    h.INSTANCE.dN(1062, 2);
                }
            }
            if (!z || !as.bjw(this.dom.getTalkerUserName())) {
                this.zol = com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.b2l), imageView, this.dom.Pwc.getMMResources().getString(R.string.x_), this.dom.Pwc.getMMResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.ax.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(233187);
                        if (!z || uVar.gPO() == null || uVar.gPO().getCallback() == null || !(uVar.gPO().getCallback() instanceof w)) {
                            o.e tc = o.a(o.d.jdL).tc(5);
                            tc.dRL = ax.this.dom.gRI();
                            tc.toUser = ax.this.dom.getTalkerUserName();
                            tc.iZt = str2;
                            tc.iXp = 0;
                            tc.jdS = null;
                            tc.dQd = 0;
                            tc.iXy = "";
                            tc.thumbPath = "";
                            tc.jdV = true;
                            tc.jdU = R.drawable.c3h;
                            tc.jdR = 11;
                            tc.bdQ().execute();
                            AppMethodBeat.o(233187);
                            return;
                        }
                        if (string.contains("com.sohu.inputmethod.sogou")) {
                            h.INSTANCE.dN(1062, 3);
                        } else if (string.contains("com.tencent.qqpinyin")) {
                            h.INSTANCE.dN(1062, 4);
                        }
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        if ((BitmapUtil.decodeFile(str2, options) == null || options.outHeight <= com.tencent.mm.n.c.aqo()) && options.outWidth <= com.tencent.mm.n.c.aqo()) {
                            String a2 = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(ax.this.dom.Pwc.getContext(), new WXMediaMessage(new WXEmojiObject(str2)), (String) null);
                            if (a2 != null) {
                                ((w) uVar.gPO().getCallback()).N(((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(a2));
                            }
                            AppMethodBeat.o(233187);
                            return;
                        }
                        Toast.makeText(ax.this.dom.Pwc.getContext(), (int) R.string.bs3, 0).show();
                        AppMethodBeat.o(233187);
                    }
                }, (DialogInterface.OnClickListener) null);
                final String substring = str.substring(0, i2);
                uVar.gPO().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.ax.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(233188);
                        uVar.gPO().z(substring, -1, false);
                        AppMethodBeat.o(233188);
                    }
                }, 10);
            } else {
                final String substring2 = str.substring(0, i2);
                uVar.gPO().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.ax.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(233186);
                        uVar.gPO().z(substring2, -1, false);
                        AppMethodBeat.o(233186);
                    }
                }, 0);
                Log.i("MicroMsg.ChattingUI.SendImgComponent", "gamelife fobidden image: from the third playground");
                Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.btk), 0).show();
                AppMethodBeat.o(35575);
                return;
            }
        }
        AppMethodBeat.o(35575);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35576);
        super.onActivityResult(i2, i3, intent);
        i(i2, i3, intent);
        AppMethodBeat.o(35576);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35579);
        super.gOK();
        q.bcP().iYF = null;
        AppMethodBeat.o(35579);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35577);
        q.bcP().iYF = this;
        AppMethodBeat.o(35577);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35578);
        q.bcP().iYF = null;
        AppMethodBeat.o(35578);
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x016b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x027e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.chatting.d.ax r20, android.content.Intent r21, java.lang.String r22) {
        /*
        // Method dump skipped, instructions count: 1412
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ax.a(com.tencent.mm.ui.chatting.d.ax, android.content.Intent, java.lang.String):void");
    }
}
