package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader extends LinearLayout {
    private String DTT;
    private b EDA;
    private boolean EDB = false;
    private Map<Integer, View> EDC = new HashMap();
    private String EDD = "";
    Bitmap EDE = null;
    boolean EDF = false;
    c EDy;
    private a EDz;
    Animation ErS = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
    Context context;
    boolean dJM = false;
    private Dialog dialog;
    String gna;
    private String sessionId;
    int type;
    String userName;

    public interface a {
        boolean JQ(long j2);

        boolean fif();
    }

    public interface b {
    }

    public void setHeadBgListener(b bVar) {
        this.EDA = bVar;
    }

    public SnsHeader(Context context2) {
        super(context2);
        AppMethodBeat.i(98715);
        init(context2);
        AppMethodBeat.o(98715);
    }

    public SnsHeader(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(98716);
        init(context2);
        AppMethodBeat.o(98716);
    }

    static boolean fic() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(203582);
        boolean z3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_sns_live_list, 1) == 1;
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            z3 = true;
        }
        if (z3) {
            if (!((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() || ((ad) g.af(ad.class)).dxY()) {
                z = false;
            } else {
                z = true;
            }
            boolean showFinderEntry = ((aj) g.ah(aj.class)).showFinderEntry();
            if (!showFinderEntry || z) {
                z2 = false;
            }
            Log.i("MicroMsg.SnsHeader", "timeline_live_list_show " + z + "," + showFinderEntry);
        } else {
            z2 = z3;
        }
        AppMethodBeat.o(203582);
        return z2;
    }

    public View getFinderSnsRecyclerView() {
        AppMethodBeat.i(203583);
        if (this.EDy == null || this.EDy.EDU == null) {
            AppMethodBeat.o(203583);
            return null;
        }
        View dHc = this.EDy.EDU.dHc();
        AppMethodBeat.o(203583);
        return dHc;
    }

    public final boolean fx(View view) {
        int i2;
        AppMethodBeat.i(203584);
        View finderSnsRecyclerView = getFinderSnsRecyclerView();
        if (finderSnsRecyclerView == null) {
            AppMethodBeat.o(203584);
            return false;
        }
        if (finderSnsRecyclerView.getVisibility() == 0) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                i2 = rect.bottom;
            } else {
                i2 = 0;
            }
            Rect rect2 = new Rect();
            boolean globalVisibleRect = finderSnsRecyclerView.getGlobalVisibleRect(rect2);
            int dimension = (int) (((float) rect2.bottom) - this.context.getResources().getDimension(R.dimen.cb));
            if (!globalVisibleRect || dimension <= i2) {
                AppMethodBeat.o(203584);
                return false;
            }
            AppMethodBeat.o(203584);
            return true;
        }
        AppMethodBeat.o(203584);
        return false;
    }

    public void setStoryAction(SnsStoryHeaderView.a aVar) {
        AppMethodBeat.i(98718);
        if (!(this.EDy == null || this.EDy.EDQ == null || this.EDF)) {
            this.EDy.EDQ.setStoryAction(aVar);
        }
        AppMethodBeat.o(98718);
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(98719);
        this.sessionId = str;
        if (!(this.EDy == null || this.EDy.EDQ == null || this.EDF)) {
            this.EDy.EDQ.setSessionId(str);
        }
        AppMethodBeat.o(98719);
    }

    public void setEnterObjectId(String str) {
        AppMethodBeat.i(98720);
        this.DTT = str;
        if (!(this.EDy == null || this.EDy.EDQ == null || this.EDF)) {
            this.EDy.EDQ.setEnterObjectId(str);
        }
        AppMethodBeat.o(98720);
    }

    private void init(final Context context2) {
        AppMethodBeat.i(98721);
        this.context = context2;
        g.aAi();
        this.EDF = ((e) g.ah(e.class)).getStoryNewFeatureConfig().fng();
        View inflate = aa.jQ(context2).inflate(R.layout.bw1, (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.i0d);
        this.EDy = new c();
        this.EDy.oSN = (TextView) inflate.findViewById(R.id.fzg);
        this.EDy.gyr = (ImageView) inflate.findViewById(R.id.x1);
        this.EDy.Eob = (TextView) inflate.findViewById(R.id.hs2);
        this.EDy.EDL = (ImageView) inflate.findViewById(R.id.hwp);
        this.EDy.EDM = (ImageView) inflate.findViewById(R.id.hwq);
        this.EDy.EDN = (LinearLayout) inflate.findViewById(R.id.hll);
        this.EDy.EDO = (LinearLayout) inflate.findViewById(R.id.hxs);
        this.EDy.EDR = (RelativeLayout) inflate.findViewById(R.id.hy6);
        this.EDy.EDS = (LinearLayout) inflate.findViewById(R.id.hy7);
        this.EDy.EDT = (ImageView) inflate.findViewById(R.id.hy8);
        this.EDy.EDV = (ViewGroup) inflate.findViewById(R.id.hxy);
        this.ErS.setDuration(1000);
        this.ErS.setRepeatCount(-1);
        this.ErS.setInterpolator(new LinearInterpolator());
        if (!p.fvC()) {
            c cVar = this.EDy;
            g.aAi();
            cVar.EDP = ((e) g.ah(e.class)).getStoryUIFactory().hi(context2);
            this.EDy.EDQ = new SnsStoryHeaderView(context2);
            if (this.EDF) {
                frameLayout.addView(this.EDy.EDP);
                this.EDy.EDP.onCreateView();
            } else {
                frameLayout.addView(this.EDy.EDQ);
                this.EDy.EDQ.setSessionId(this.sessionId);
                this.EDy.EDQ.setEnterObjectId(this.DTT);
            }
        }
        this.EDy.EDL.setContentDescription(context2.getString(R.string.h56));
        this.EDy.EDL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsHeader.AnonymousClass2 */

            public final void onClick(View view) {
                String[] strArr;
                AppMethodBeat.i(98713);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.SnsHeader", "change backGround");
                if (SnsHeader.this.dialog == null || !SnsHeader.this.dialog.isShowing()) {
                    if (SnsHeader.this.EDz != null) {
                        SnsHeader.this.EDz.fif();
                    }
                    l aQr = com.tencent.mm.plugin.sns.model.aj.faS().aQr(SnsHeader.this.type == 1 ? SnsHeader.this.gna : SnsHeader.this.userName);
                    final long j2 = aQr.field_snsBgId;
                    if (SnsHeader.this.dJM || j2 != 0) {
                        SnsHeader.this.EDB = aQr.feK();
                        if (SnsHeader.this.type == 1 || SnsHeader.this.gna.trim().equals(SnsHeader.this.userName.trim())) {
                            strArr = new String[]{context2.getString(R.string.hbq)};
                            SnsHeader.this.EDB = false;
                        } else {
                            strArr = SnsHeader.this.EDB ? new String[0] : new String[]{context2.getString(R.string.h85)};
                        }
                        String string = SnsHeader.this.EDB ? context2.getString(R.string.h_d) : "";
                        if (SnsHeader.this.EDB) {
                            context2.getString(R.string.x_);
                        } else {
                            context2.getString(R.string.sz);
                        }
                        SnsHeader.this.dialog = h.a(SnsHeader.this.getContext(), string, strArr, new h.d() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsHeader.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.h.d
                            public final void oj(int i2) {
                                AppMethodBeat.i(203579);
                                switch (i2) {
                                    case 0:
                                        if (!SnsHeader.this.EDB) {
                                            SnsHeader.a(SnsHeader.this, j2);
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.o(203579);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98713);
                        return;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98713);
                    return;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98713);
            }
        });
        this.EDy.gyr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsHeader.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(203580);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                as Kn = com.tencent.mm.plugin.sns.model.aj.faC().Kn(SnsHeader.this.userName);
                if (Kn == null || (!com.tencent.mm.contact.c.oR(Kn.field_type) && !SnsHeader.this.dJM)) {
                    Intent intent = ((Activity) context2).getIntent();
                    intent.putExtra("Contact_User", SnsHeader.this.userName);
                    com.tencent.mm.plugin.sns.c.a.jRt.c(intent, context2);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", SnsHeader.this.userName);
                    if (SnsHeader.this.userName != null && SnsHeader.this.userName.length() > 0) {
                        intent2.putExtra("CONTACT_INFO_UI_SOURCE", SnsHeader.this.type == 1 ? 6 : 1);
                        com.tencent.mm.plugin.sns.c.a.jRt.c(intent2, context2);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203580);
            }
        });
        AppMethodBeat.o(98721);
    }

    public void setAvatarOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(98722);
        if (!(this.EDy == null || this.EDy.gyr == null)) {
            this.EDy.gyr.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(98722);
    }

    public final void fid() {
        boolean z;
        Bitmap bitmap;
        AppMethodBeat.i(98723);
        String str = this.userName;
        if (this.type == 1) {
            str = this.gna;
        }
        String accSnsPath = com.tencent.mm.plugin.sns.model.aj.getAccSnsPath();
        Log.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str)));
        l aQr = com.tencent.mm.plugin.sns.model.aj.faS().aQr(str);
        String str2 = aQr.field_bgId;
        Log.d("MicroMsg.SnsHeader", "showName " + str + " get bgId : " + str2 + "  olderBgId：　" + aQr.field_older_bgId);
        String aOh = r.aOh(str2);
        String str3 = str + "bg_";
        String str4 = str + "tbg_";
        String ki = ar.ki(accSnsPath, str);
        s.boN(ki);
        if ((aQr.field_local_flag & 1) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.d("MicroMsg.SnsHeader", "bg is change");
            com.tencent.mm.plugin.sns.model.aj.faS().aQq(str);
            if (s.YS(ar.ki(accSnsPath, str) + str3)) {
                s.deleteFile(ar.ki(accSnsPath, str) + str4);
                s.bo(ar.ki(accSnsPath, str), str3, str4);
            }
            aQr.field_local_flag &= -2;
            com.tencent.mm.plugin.sns.model.aj.faS().c(aQr);
        }
        if (s.YS(ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), str2) + aOh) && !s.YS(ar.ki(accSnsPath, str) + str3)) {
            s.nw(ar.ki(accSnsPath, str2) + aOh, ar.ki(accSnsPath, str) + str3);
            Log.d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        String str5 = aQr.field_bgUrl;
        if (str2 != null) {
            com.tencent.mm.plugin.sns.model.aj.faL();
            this.context.hashCode();
            bitmap = com.tencent.mm.plugin.sns.model.g.a(ki + str3, str5, str2, true, bp.Oqt);
            Log.d("MicroMsg.SnsHeader", "set a new bg");
            if (bitmap == null) {
                s.deleteFile(ki + str3);
            }
        } else {
            bitmap = null;
        }
        if (bitmap == null && str2 != null) {
            com.tencent.mm.plugin.sns.model.aj.faL();
            this.context.hashCode();
            bitmap = com.tencent.mm.plugin.sns.model.g.a(ki + str4, str5, str2, false, bp.Oqt);
        }
        if (this.EDy.EDL != null) {
            this.EDy.EDL.setImageBitmap(bitmap);
            if (bitmap != null) {
                this.EDy.EDL.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.EDE == null || this.EDE.isRecycled()) {
                        Log.i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.EDE = BackwardSupportUtil.BitmapFactory.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.EDy.EDL.setBackgroundDrawable(new BitmapDrawable(this.EDE));
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.SnsHeader", e2, "", new Object[0]);
                }
            }
        }
        this.EDy.EDN.setVisibility(8);
        if (bitmap == null && (this.type == 1 || this.gna.equals(str))) {
            this.EDy.EDN.setVisibility(0);
        }
        this.EDB = aQr.feK();
        AppMethodBeat.o(98723);
    }

    public void setBackClickListener(a aVar) {
        this.EDz = aVar;
    }

    public final boolean fie() {
        KeyEvent.Callback callback;
        String str;
        AppMethodBeat.i(98724);
        if (this.EDy.EDO == null) {
            AppMethodBeat.o(98724);
            return false;
        }
        List<SnsInfo> fbp = an.fbp();
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < fbp.size(); i2++) {
            SnsInfo snsInfo = fbp.get(i2);
            try {
                if (((cnc) new cnc().parseFrom(snsInfo.field_postBuf)).Mtl) {
                }
            } catch (Exception e2) {
            }
            linkedList.add(snsInfo);
        }
        String str2 = "";
        int i3 = 0;
        while (i3 < linkedList.size()) {
            try {
                if (((cnc) new cnc().parseFrom(((SnsInfo) linkedList.get(i3)).field_postBuf)).Mtl) {
                    str = str2;
                    i3++;
                    str2 = str;
                }
            } catch (Exception e3) {
            }
            str = str2 + ((SnsInfo) linkedList.get(i3)).getLocalid() + " ";
            i3++;
            str2 = str;
        }
        Log.i("MicroMsg.SnsHeader", "refreshError %s %s %s", Integer.valueOf(linkedList.size()), str2, this.EDD);
        if (!str2.equals(this.EDD)) {
            this.EDD = str2;
            this.EDy.EDO.removeAllViews();
            this.EDy.EDO.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new d());
            for (final int i4 = 0; i4 < linkedList.size(); i4++) {
                int i5 = ((SnsInfo) linkedList.get(i4)).localid;
                final int size = linkedList.size();
                if (!this.EDC.containsKey(Integer.valueOf(i5)) || this.EDC.get(Integer.valueOf(i5)) == null) {
                    LinearLayout linearLayout = (LinearLayout) aa.jQ(this.context).inflate(R.layout.aua, (ViewGroup) null);
                    linearLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsHeader.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(98714);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (view.getTag() instanceof String) {
                                String str = (String) view.getTag();
                                Log.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(str)));
                                SnsInfo aQm = com.tencent.mm.plugin.sns.model.aj.faO().aQm(str);
                                if (!(SnsHeader.this.context == null || aQm == null)) {
                                    Intent intent = new Intent();
                                    intent.setClass(SnsHeader.this.context, SnsCommentDetailUI.class);
                                    if (aQm == null || aQm.getUserName() == null || aQm.getUserName().equals("")) {
                                        Log.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(98714);
                                        return;
                                    }
                                    intent.putExtra("INTENT_TALKER", aQm.getUserName());
                                    intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                                    intent.putExtra("INTENT_FROMGALLERY", true);
                                    k tO = k.tO(726);
                                    tO.tR(size).tR(i4).tR(aQm.getCreateTime());
                                    tO.bfK();
                                    Context context = SnsHeader.this.context;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    context.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    try {
                                        cnc cnc = (cnc) new cnc().parseFrom(aQm.field_postBuf);
                                        if (cnc.Mtd == 201 || cnc.Mtd == 210 || cnc.Mtd != 211) {
                                            cnc.Mtl = true;
                                            aQm.setPostBuf(cnc.toByteArray());
                                            com.tencent.mm.plugin.sns.model.aj.faO().d(aQm.localid, aQm);
                                        }
                                    } catch (Exception e2) {
                                    }
                                }
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(98714);
                        }
                    });
                    this.EDC.put(Integer.valueOf(i5), linearLayout);
                    callback = linearLayout;
                } else {
                    callback = (View) this.EDC.get(Integer.valueOf(i5));
                }
                LinearLayout linearLayout2 = (LinearLayout) callback;
                linearLayout2.getChildAt(0).setTag(((SnsInfo) linkedList.get(i4)).getLocalid());
                SnsInfo snsInfo2 = (SnsInfo) linkedList.get(i4);
                TextView textView = (TextView) linearLayout2.findViewById(R.id.hzl);
                if (snsInfo2.getTypeFlag() == 15) {
                    textView.setText(R.string.h9s);
                } else if (snsInfo2.getTypeFlag() == 2) {
                    textView.setText(R.string.h9t);
                } else if (snsInfo2.getTypeFlag() == 1) {
                    textView.setText(R.string.h9k);
                } else if (snsInfo2.getTypeFlag() == 26) {
                    textView.setText(R.string.h9r);
                } else if (snsInfo2.getTypeFlag() == 28) {
                    textView.setText(R.string.h9p);
                } else {
                    textView.setText(R.string.h9q);
                }
                this.EDy.EDO.addView(linearLayout2);
            }
            if (linkedList.size() > 0) {
                AppMethodBeat.o(98724);
                return true;
            }
            AppMethodBeat.o(98724);
            return false;
        } else if (linkedList.size() > 0) {
            AppMethodBeat.o(98724);
            return true;
        } else {
            AppMethodBeat.o(98724);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        ImageView EDL;
        ImageView EDM;
        LinearLayout EDN;
        LinearLayout EDO;
        AbsStoryHeaderTipView EDP;
        SnsStoryHeaderView EDQ;
        RelativeLayout EDR;
        LinearLayout EDS;
        ImageView EDT;
        ab EDU;
        ViewGroup EDV;
        TextView Eob;
        ImageView gyr;
        TextView oSN;

        c() {
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Comparator<SnsInfo> {
        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(SnsInfo snsInfo, SnsInfo snsInfo2) {
            AppMethodBeat.i(203581);
            SnsInfo snsInfo3 = snsInfo;
            SnsInfo snsInfo4 = snsInfo2;
            if (snsInfo3.getCreateTime() == snsInfo4.getCreateTime()) {
                AppMethodBeat.o(203581);
                return 0;
            } else if (snsInfo3.getCreateTime() > snsInfo4.getCreateTime()) {
                AppMethodBeat.o(203581);
                return -1;
            } else {
                AppMethodBeat.o(203581);
                return 1;
            }
        }
    }

    public final void onResume() {
        AppMethodBeat.i(98725);
        if (!(this.EDy == null || this.EDy.EDP == null || !this.EDF)) {
            this.EDy.EDP.fmT();
        }
        if (!(this.EDy == null || this.EDy.EDQ == null || this.EDF)) {
            SnsStoryHeaderView snsStoryHeaderView = this.EDy.EDQ;
            Log.i("MicroMsg.SnsStoryHeaderView", "resume: ");
            snsStoryHeaderView.dLD = false;
            ((e) g.ah(e.class)).getContactFetcher().fno();
            snsStoryHeaderView.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(100431);
                    SnsStoryHeaderView.c(SnsStoryHeaderView.this);
                    AppMethodBeat.o(100431);
                }
            });
        }
        if (!(this.type != 1 || this.EDy == null || this.EDy.EDV == null || this.EDy.EDU == null)) {
            if (!fic()) {
                this.EDy.EDV.removeAllViews();
                this.EDy.EDV.setPadding(0, (int) this.context.getResources().getDimension(R.dimen.ci), 0, 0);
                if (this.EDy.EDQ != null) {
                    this.EDy.EDQ.setTopLineVisibility(0);
                }
                Log.i("MicroMsg.SnsHeader", "disable2 finderSnsHeader");
                AppMethodBeat.o(98725);
                return;
            }
            this.EDy.EDU.dHd();
        }
        AppMethodBeat.o(98725);
    }

    public int getLoadingGroupHeight() {
        AppMethodBeat.i(203585);
        int i2 = 0;
        if (!(this.EDy == null || this.EDy.EDS == null)) {
            i2 = this.EDy.EDS.getHeight() + at.fromDPToPix(getContext(), 32);
        }
        AppMethodBeat.o(203585);
        return i2;
    }

    static /* synthetic */ boolean a(SnsHeader snsHeader, long j2) {
        AppMethodBeat.i(203586);
        if (snsHeader.EDz != null) {
            snsHeader.EDz.JQ(j2);
        }
        AppMethodBeat.o(203586);
        return true;
    }
}
