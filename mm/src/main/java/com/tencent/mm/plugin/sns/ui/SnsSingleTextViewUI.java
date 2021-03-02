package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.io.IOException;
import kotlin.g.b.p;

public class SnsSingleTextViewUI extends MMSecDataActivity {
    private SnsInfo DPf;
    private int EJA;
    private byte[] EJB = null;
    private dzo EJC = null;
    private boolean EJD = false;
    private SnsTranslateResultView EJE;
    private IListener EJF = new IListener<wk>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160717);
            this.__eventId = wk.class.getName().hashCode();
            AppMethodBeat.o(160717);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wk wkVar) {
            AppMethodBeat.i(99129);
            wk wkVar2 = wkVar;
            if ((wkVar2 instanceof wk) && SnsSingleTextViewUI.this.DPf != null && Util.isEqual(SnsSingleTextViewUI.this.EJz, wkVar2.ecw.id)) {
                au.fA(SnsSingleTextViewUI.this.EJz, 8);
                SnsSingleTextViewUI.this.EJE.setVisibility(0);
                SnsSingleTextViewUI.this.EJE.ZW(SnsSingleTextViewUI.this.EJA);
                SnsSingleTextViewUI.this.EJD = false;
            }
            AppMethodBeat.o(99129);
            return false;
        }
    };
    private IListener EJG = new IListener<wi>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.AnonymousClass2 */

        {
            AppMethodBeat.i(160718);
            this.__eventId = wi.class.getName().hashCode();
            AppMethodBeat.o(160718);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wi wiVar) {
            AppMethodBeat.i(99130);
            wi wiVar2 = wiVar;
            if ((wiVar2 instanceof wi) && SnsSingleTextViewUI.this.DPf != null && Util.isEqual(SnsSingleTextViewUI.this.EJz, wiVar2.ect.id)) {
                au.fA(SnsSingleTextViewUI.this.EJz, 8);
                String str = wiVar2.ect.result;
                String str2 = wiVar2.ect.ecu;
                if (Util.isNullOrNil(str)) {
                    SnsSingleTextViewUI.this.EJE.setVisibility(8);
                    au.fB(SnsSingleTextViewUI.this.EJz, 8);
                } else {
                    SnsSingleTextViewUI.this.EJE.setVisibility(0);
                    SnsSingleTextViewUI.this.EJE.a(null, SnsSingleTextViewUI.this.EJA, str, str2, true);
                    SnsSingleTextViewUI.this.EJD = true;
                }
            }
            AppMethodBeat.o(99130);
            return false;
        }
    };
    private IListener EJH = new IListener<wl>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.AnonymousClass3 */

        {
            AppMethodBeat.i(160719);
            this.__eventId = wl.class.getName().hashCode();
            AppMethodBeat.o(160719);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wl wlVar) {
            AppMethodBeat.i(99131);
            wl wlVar2 = wlVar;
            if ((wlVar2 instanceof wl) && Util.isEqual(SnsSingleTextViewUI.this.EJz, wlVar2.ecx.id)) {
                au.fB(wlVar2.ecx.id, 8);
                SnsSingleTextViewUI.this.EJE.setVisibility(8);
                SnsSingleTextViewUI.this.EJD = false;
            }
            AppMethodBeat.o(99131);
            return false;
        }
    };
    private TextView EJx;
    private String EJy = null;
    private String EJz = null;
    private String dJX;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.AnonymousClass5 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(99133);
            switch (menuItem.getItemId()) {
                case 0:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        if (ClipboardHelper.setTextSwallowException(SnsSingleTextViewUI.this.EJx.getText())) {
                            h.cD(SnsSingleTextViewUI.this.getContext(), SnsSingleTextViewUI.this.getContext().getString(R.string.ta));
                            if (SnsSingleTextViewUI.this.DPf != null) {
                                a aVar = a.INSTANCE;
                                a.q(2, Util.getUnsignedLongString(SnsSingleTextViewUI.this.DPf.field_snsId), Util.getUTF8ByteLength(SnsSingleTextViewUI.this.EJx.getText().toString()));
                                AppMethodBeat.o(99133);
                                return;
                            }
                        } else {
                            h.cD(SnsSingleTextViewUI.this.getContext(), SnsSingleTextViewUI.this.getContext().getString(R.string.j80));
                        }
                    }
                    AppMethodBeat.o(99133);
                    return;
                case 1:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        cz czVar = new cz();
                        com.tencent.mm.plugin.sns.l.a.a(czVar, SnsSingleTextViewUI.this.dJX, SnsSingleTextViewUI.this.EJx.getText());
                        czVar.dFZ.activity = SnsSingleTextViewUI.this;
                        czVar.dFZ.dGf = 18;
                        EventCenter.instance.publish(czVar);
                    }
                    AppMethodBeat.o(99133);
                    return;
                case 6:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        Intent intent = new Intent();
                        SnsInfo aQm = aj.faO().aQm(SnsSingleTextViewUI.this.dJX);
                        intent.putExtra("k_username", aQm == null ? "" : aQm.field_userName);
                        intent.putExtra("k_expose_msg_id", aQm == null ? 0 : aQm.getSnsId());
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
                        c.b(SnsSingleTextViewUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(99133);
                    return;
                case 14:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(SnsSingleTextViewUI.this.EJx.getContext())) {
                            AppMethodBeat.o(99133);
                            return;
                        }
                        au.E(aj.faO().aQm(SnsSingleTextViewUI.this.dJX));
                    }
                    AppMethodBeat.o(99133);
                    return;
                case 15:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(SnsSingleTextViewUI.this.EJx.getContext())) {
                            AppMethodBeat.o(99133);
                            return;
                        }
                        au.a(new m(null, SnsSingleTextViewUI.this.DPf.getSnsId(), SnsSingleTextViewUI.this.EJC, null, SnsSingleTextViewUI.this.EJC.iAc, null, 1, SnsSingleTextViewUI.this.DPf.field_userName));
                    }
                    AppMethodBeat.o(99133);
                    return;
                case 16:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        au.F(aj.faO().aQm(SnsSingleTextViewUI.this.dJX));
                    }
                    AppMethodBeat.o(99133);
                    return;
                case 17:
                    if (!(SnsSingleTextViewUI.this.EJx == null || SnsSingleTextViewUI.this.EJx.getText() == null)) {
                        au.b(new m(null, SnsSingleTextViewUI.this.DPf.getSnsId(), SnsSingleTextViewUI.this.EJC, null, SnsSingleTextViewUI.this.EJC.iAc, null, 1, SnsSingleTextViewUI.this.DPf.field_userName));
                    }
                    AppMethodBeat.o(99133);
                    return;
                default:
                    AppMethodBeat.o(99133);
                    return;
            }
        }
    };
    protected int requestType = 0;
    private String text;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSingleTextViewUI() {
        AppMethodBeat.i(99134);
        AppMethodBeat.o(99134);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int i2;
        long createTime;
        Bundle bundle2;
        au.b aPp;
        f eSr;
        long j2;
        int i3 = 4;
        AppMethodBeat.i(99135);
        super.onCreate(bundle);
        setMMTitle(R.string.h52);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99132);
                SnsSingleTextViewUI.this.finish();
                AppMethodBeat.o(99132);
                return true;
            }
        });
        a.C1715a aVar = com.tencent.mm.plugin.sns.i.a.DRI;
        a.C1715a.gZ(this);
        this.text = getIntent().getStringExtra("sns_text_show");
        this.dJX = Util.nullAs(getIntent().getStringExtra("sns_local_id"), "");
        this.EJB = getIntent().getByteArrayExtra("sns_comment_buf");
        if (this.EJB != null && this.EJB.length > 0) {
            this.EJC = new dzo();
            try {
                this.EJC.parseFrom(this.EJB);
                StringBuilder sb = new StringBuilder();
                if (this.EJC.MYT != 0) {
                    j2 = (long) this.EJC.MYT;
                } else {
                    j2 = this.EJC.MYV;
                }
                this.EJy = sb.append(j2).toString();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.SnsSingleTextViewUI", e2, "initCommentInfo error.", new Object[0]);
            }
        }
        this.DPf = aj.faO().aQm(this.dJX);
        if (Util.isNullOrNil(this.text)) {
            this.text = "";
        }
        this.EJx = (TextView) findViewById(R.id.i15);
        this.EJx.setText(this.text, TextView.BufferType.SPANNABLE);
        TextView textView = this.EJx;
        if (this.DPf == null) {
            bundle2 = null;
        } else {
            Bundle bundle3 = new Bundle();
            String str = this.DPf.getUserName() + "#" + r.Jb(this.DPf.field_snsId);
            if (this.EJC != null) {
                i2 = r.a(this.EJC) ? 5 : 4;
                str = str + "#" + this.EJC.Username + "#" + this.EJC.MYT;
            } else {
                i2 = 3;
            }
            bundle3.putInt("ShareScene", i2);
            bundle3.putString("ShareSceneId", str);
            if (this.EJC != null) {
                createTime = (long) this.EJC.CreateTime;
            } else {
                createTime = (long) this.DPf.getCreateTime();
            }
            bundle3.putLong("CreateTime", createTime);
            bundle3.putInt("TimelineEnterSource", 1);
            bundle3.putInt("SnsContentType", this.DPf.field_type);
            bundle2 = bundle3;
        }
        l.a(textView, 2, 2, bundle2);
        a.C1715a aVar2 = com.tencent.mm.plugin.sns.i.a.DRI;
        SnsInfo snsInfo = this.DPf;
        dzo dzo = this.EJC;
        TextView textView2 = this.EJx;
        p.h(snsInfo, "snsInfo");
        p.h(textView2, "view");
        egl egl = new egl();
        if (dzo != null) {
            if (r.a(dzo)) {
                i3 = 5;
            }
            egl.Ngu = i3;
            egl.Ngv = snsInfo.getUserName() + "#" + r.Jb(snsInfo.field_snsId) + "#" + dzo.Username + "#" + dzo.MYT;
            egl.KMc = (long) dzo.CreateTime;
        } else {
            egl.Ngu = 3;
            egl.Ngv = snsInfo.getUserName() + "#" + r.Jb(snsInfo.field_snsId);
            egl.KMc = (long) snsInfo.getCreateTime();
        }
        egl.Ngw = 1;
        egl.Ngx = snsInfo.field_type;
        SecDataUIC.a aVar3 = SecDataUIC.CWq;
        Context context = textView2.getContext();
        p.g(context, "view.context");
        SecDataUIC gU = SecDataUIC.a.gU(context);
        if (!(gU == null || (eSr = gU.eSr()) == null)) {
            eSr.c(String.valueOf(textView2.hashCode()), egl);
        }
        this.EJx.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
        new com.tencent.mm.ui.tools.l(this).a(this.EJx, this, this.pso);
        this.EJE = (SnsTranslateResultView) findViewById(R.id.i1c);
        this.EJE.setResultTextSize(this.EJx.getTextSize());
        if (this.DPf != null) {
            if (!fiJ()) {
                this.EJz = this.DPf.getSnsId();
                this.EJA = 1;
            } else {
                this.EJz = au.kj(this.DPf.getSnsId(), this.EJy);
                this.EJA = 2;
            }
            if (au.fC(this.EJz, 8) && (aPp = au.aPp(this.EJz)) != null && aPp.iGD) {
                this.EJE.setVisibility(0);
                this.EJE.a(null, this.EJA, aPp.result, aPp.brand, false);
                this.EJD = true;
            }
        }
        EventCenter.instance.addListener(this.EJF);
        EventCenter.instance.addListener(this.EJG);
        EventCenter.instance.addListener(this.EJH);
        AppMethodBeat.o(99135);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99136);
        super.onDestroy();
        EventCenter.instance.removeListener(this.EJF);
        EventCenter.instance.removeListener(this.EJG);
        EventCenter.instance.removeListener(this.EJH);
        AppMethodBeat.o(99136);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bx_;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        boolean z = true;
        AppMethodBeat.i(99137);
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(R.string.t_));
            if (c.aZU("favorite") && !fiJ()) {
                contextMenu.add(0, 1, 0, getString(R.string.c8z));
            }
            contextMenu.add(0, 6, 1, getString(R.string.u7));
            if (!this.EJD) {
                if (fiJ()) {
                    z = false;
                }
                au.a(contextMenu, z);
                AppMethodBeat.o(99137);
                return;
            }
            if (fiJ()) {
                z = false;
            }
            au.b(contextMenu, z);
        }
        AppMethodBeat.o(99137);
    }

    private boolean fiJ() {
        boolean z = false;
        AppMethodBeat.i(99138);
        if (this.EJC != null && (!(this.EJC.MYT == 0 && this.EJC.MYV == 0) && !Util.isNullOrNil(this.EJC.iAc))) {
            z = true;
        }
        AppMethodBeat.o(99138);
        return z;
    }
}
